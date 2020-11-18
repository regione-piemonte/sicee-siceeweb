
package it.csi.sicee.siceeweb.business;

import java.util.*;
import java.io.*;
import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.iride2.policy.entity.*;
import it.csi.iride2.policy.exceptions.*;
import it.csi.iride2.policy.interfaces.PolicyEnforcerBaseService;
import it.csi.iride2.iridefed.entity.Ruolo;
import it.csi.iride2.iridefed.exceptions.BadRuoloException;
import it.csi.sicee.siceeweb.dto.*;
import org.apache.log4j.*;
import it.csi.sicee.siceeweb.util.*;
/*PROTECTED REGION ID(R-952919469) ENABLED START*/
import it.csi.sicee.siceeweb.dto.ace.Ace;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.daticert.DtCatastali;
import it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce;
import it.csi.sicee.siceeweb.dto.transazioni.TransazioneRegistrazione;
import it.csi.sicee.siceeweb.business.compilazattestati.CPBECpCompilaz;
import it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpCompilazApe;
import it.csi.sicee.siceeweb.business.facade.*;
import it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpTransazAnomale;
/*PROTECTED REGION END*/

public class SecurityHelper {

	/**  */
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".security");

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi di supporto alla sicurezza.
	//////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////
	//// Metodi per la sicurezza basata su IRIDE2
	///////////////////////////////////////////////////////////////////////////////

	public static final String IRIDE_PEP_RESOURCE = "/META-INF/iride2_pep_defPD_ejb.xml";
	public static final String IRIDE_PEP_WS_RESOURCE = "/META-INF/iride2_pep_defPD_ws.xml";

	it.csi.iride2.policy.interfaces.PolicyEnforcerBaseService iride = null;

	/**
	 * restituisce il percorso effettivo della configurazione della PD
	 * di IRIDE da caricare.
	 * Se la security (e la pep-implementation) e' custom viene restituito sempre il 
	 * valore della costante IRIDE_PEP_RESOURCE.
	 * Se la security non e' custom viene restituito un valore differente a seconda del valore
	 * della property "pdProtocol":
	 * <ul>
	 * <li>EJB: IRIDE_PEP_RESOURCE</li>
	 * <li>WS: IRIDE_PEP_WS_RESOURCE</li>
	 * <li>(altro): IRIDE_PEP_RESOURCE</li>
	 * </ul>  
	 */
	protected String getActualIridePepResource() {
		if ("WS".equals(pdProtocol)) {
			return IRIDE_PEP_WS_RESOURCE;
		} else {
			return IRIDE_PEP_RESOURCE;
		}
	}

	/**
	 * Carica la configurazione della PD del PEP e crea il proxy.
	 * @return il proxy della PD del PEP. 
	 */
	protected PolicyEnforcerBaseService getIridePEP() {
		if (this.iride == null) {
			InputStream is = getClass().getResourceAsStream(getActualIridePepResource());
			if (is != null) {
				try {
					InfoPortaDelegata info = PDConfigReader.read(is);
					this.iride = (PolicyEnforcerBaseService) PDProxy.newInstance(info);
					return this.iride;
				} catch (Exception e) {
					LOG.error(
							"[SecurityHelper::getIridePEP] errore nella parsificazione della configurazione di IRIDE2:"
									+ e,
							e);
					throw new IllegalArgumentException("errore nella parsificazione della configurazione di IRIDE2", e);
				}
			} else
				LOG.error("[SecurityHelper::getIridePEP] configurazione di IRIDE2 non trovata, risorsa:"
						+ getActualIridePepResource());
			throw new IllegalArgumentException(
					"configurazione di IRIDE2 non trovata, risorsa:" + getActualIridePepResource());
		} else
			return this.iride;
	}

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	protected Identita getCurrentUser(Map session) throws BEException {
		Identita id = (Identita) session.get(IRIDE_ID_SESSIONATTR);
		if (id == null) {
			LOG.error(
					"[SecurityHelper::getCurrentUser] Errore nel reperimento del current user dalla sessione: attributo non trovato");
			throw new IllegalStateException(
					"Errore nel reperimento del current user dalla sessione: attributo non trovato");
		} else {
			return id;
		}
	}

	protected it.csi.sicee.siceeweb.dto.UserInfo getCurrentUserInfo(Map session) throws BEException {
		it.csi.sicee.siceeweb.dto.UserInfo userInfo = (it.csi.sicee.siceeweb.dto.UserInfo) session
				.get("appDatacurrentUser");
		if (userInfo == null) {
			LOG.error(
					"[SecurityHelper::getCurrentUser] Errore nel reperimento del current user dalla sessione: attributo non trovato");
			throw new IllegalStateException(
					"Errore nel reperimento del current user dalla sessione: attributo non trovato");
		} else {
			return userInfo;
		}
	}

	public static final Application IRIDE2_APPLICATION = new Application("SICEE");

	public boolean verifyCurrentUserForRole(Map session, String roleCode, String domainCode) throws BEException {
		Identita currentUser = getCurrentUser(session);
		Ruolo rol = new Ruolo();

		rol.setCodiceRuolo(roleCode);
		rol.setCodiceDominio(domainCode);
		try {
			return getIridePEP().isPersonaInRuolo(getCurrentUser(session), rol);
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] identita' non autentica [" + currentUser + "]," + e);
			throw new BEException("verifyCurrentUserForRole: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (BadRuoloException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] ruolo [" + rol + "] non valido" + e);
			throw new BEException("verifyCurrentUserForRole: ruolo [" + rol + "] non valido" + e, e);
		} catch (UnrecoverableException e) {
			LOG.error(
					"[SecurityHelper::verifyCurrentUserForRole] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForRole:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForRole:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		}
	}

	/**
	 * estrae il prefisso dal cod ruolo in formato <idruolo>@<coddominio>
	 * @param codRuolo
	 */
	private String getPrefixFromCodRuolo(String codRuolo) {
		return codRuolo.substring(0, codRuolo.indexOf("@"));
	}

	/**
	 * estrae il codice dominio dal cod ruolo in formato <idruolo>@<coddominio>
	 * @param codRuolo
	 */
	private String getDomainFromCodRuolo(String codRuolo) {
		return codRuolo.substring(codRuolo.indexOf("@") + 1);
	}

	public boolean verifyCurrentUserForUC(Map session, String useCaseCode) throws BEException {
		Identita currentUser = getCurrentUser(session);
		UseCase uc = new UseCase();

		uc.setAppId(IRIDE2_APPLICATION);
		uc.setId(useCaseCode);
		try {
			it.csi.sicee.siceeweb.dto.UserInfo currentUserInfo = getCurrentUserInfo(session);
			if (currentUserInfo == null || currentUserInfo.getCodRuolo() == null
					|| currentUserInfo.getCodRuolo().length() == 0) {
				// verifica dell'abilitazione allo UC senza tener conto del ruolo corrente
				return getIridePEP().isPersonaAutorizzataInUseCase(getCurrentUser(session), uc);
			} else {
				// verifica dell'abilitazione allo UC tenendo conto del ruolo corrente
				Ruolo[] ruoliForPersonaInUseCase = getIridePEP().findRuoliForPersonaInUseCase(currentUser, uc);

				String codDominioRuolo = getDomainFromCodRuolo(currentUserInfo.getCodRuolo());
				String codRuoloRuolo = getPrefixFromCodRuolo(currentUserInfo.getCodRuolo());
				boolean authorized = false;
				Ruolo currentRole = new Ruolo(codRuoloRuolo, codDominioRuolo);
				for (Ruolo ruolo : ruoliForPersonaInUseCase) {
					if (ruolo != null && currentRole.getMnemonico().equals(ruolo.getMnemonico())) {
						authorized = true;
						break;
					}
				}
				return authorized;
			}
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] identita' non autentica [" + currentUser + "]," + e);
			throw new BEException("verifyCurrentUserForUC: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (NoSuchUseCaseException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] use case [" + uc + "] non valido" + e);
			throw new BEException("verifyCurrentUserForUC: use case [" + uc + "] non valido" + e, e);
		} catch (NoSuchApplicationException e) {
			LOG.error(
					"[SecurityHelper::verifyCurrentUserForUC] applicazione " + IRIDE2_APPLICATION + " non valida" + e);
			throw new BEException("verifyCurrentUserForUC: applicazione " + IRIDE2_APPLICATION + " non valida" + e, e);
		} catch (UnrecoverableException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForUC:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForUC:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		}
	}

	public boolean verifyCurrentUserForActor(Map session, String actorCode) throws BEException {
		Identita currentUser = getCurrentUser(session);
		Actor act = new Actor();

		act.setAppId(IRIDE2_APPLICATION);
		act.setId(actorCode);
		try {
			Actor[] actors = getIridePEP().findActorsForPersonaInApplication(currentUser, IRIDE2_APPLICATION);
			if (actors != null) {
				for (int i = 0; i < actors.length; i++) {
					Actor actor = actors[i];
					if (actor.equals(act))
						return true;
				}
				return false;
			} else
				return false;
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] Errore interno in verifyCurrentUserForUC:" + e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] identita' non autentica [" + currentUser + "]," + e,
					e);
			throw new BEException("verifyCurrentUserForUC: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (NoSuchApplicationException e) {
			LOG.error(
					"[SecurityHelper::verifyCurentUserForActor] applicazione " + IRIDE2_APPLICATION + " non valida" + e,
					e);
			throw new BEException("verifyCurrentUserForUC: applicazione " + IRIDE2_APPLICATION + " non valida" + e, e);
		} catch (UnrecoverableException e) {
			LOG.error(
					"[SecurityHelper::verifyCurentUserForActor] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForUC:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForUC:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	//// Metodi per la sicurezza custom
	///////////////////////////////////////////////////////////////////////////////

	public boolean customCheckAbilitaVediSostituzioni(Map session) throws BEException {
		/*PROTECTED REGION ID(R1324170237) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckAbilitaVediSostituzioni] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckAbilitaVediSostituzioni", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckAbilitaDuplicaDati(Map session) throws BEException {
		/*PROTECTED REGION ID(R2144307153) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			try {
				/*
				switch (getStatoCertificatore(session)) {
					case Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO :
						return false;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO :
						return false;
					default :
				}
				 */
				return false;
			} catch (Exception ex) {
				LOG.error("[SecurityHelper::customCheckAbilitaDuplicaDati] Errore durante l'esecuzione del metodo", ex);
				throw new BEException("Errore durante l'esecuzione del metodo customCheckAbilitaDuplicaDati", ex);
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckAbilitaDuplicaDati] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckAbilitaDuplicaDati", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVisibleIfEsisteIndirizzo(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1305407859) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			DatiAttestato att = (DatiAttestato) session.get(CPBECpCompilaz.APPDATA_CERTIFICATO_CODE);
			DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
			if (!GenericUtil.isNullOrEmpty(cat.getDescrIndirizzo()))
				return true;
			return false;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVisibleIfEsisteIndirizzo] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVisibleIfEsisteIndirizzo", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotSalvaApe(Map session) throws BEException {
		/*PROTECTED REGION ID(R-712998150) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			DatiAttestato att = (DatiAttestato) session.get(CPBECpCompilaz.APPDATA_CERTIFICATO_CODE);

			if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				return false;
			} else if (att.getStatus() == Constants.NUOVO || att.getStatus() == Constants.BOZZA) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckGestisciVisBotSalvaApe] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckGestisciVisBotSalvaApe", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilEliminaFoto(Map session) throws BEException {
		/*PROTECTED REGION ID(R-994570448) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilEliminaFoto] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilEliminaFoto", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotInviaApe(Map session) throws BEException {
		/*PROTECTED REGION ID(R-2034300614) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			DatiAttestato att = (DatiAttestato) session.get(CPBECpCompilaz.APPDATA_CERTIFICATO_CODE);

			if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				return false;
			} else if (att.getStatus() == Constants.CONSOLIDATO) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckGestisciVisBotInviaApe] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckGestisciVisBotInviaApe", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotConsolidaApe(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1517749749) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			DatiAttestato att = (DatiAttestato) session.get(CPBECpCompilaz.APPDATA_CERTIFICATO_CODE);

			LOG.debug("STAMPO LO STATO x visulizzare consolidamento: " + att.getStatus());

			if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				return false;
			} else if (att.getStatus() == Constants.BOZZA) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckGestisciVisBotConsolidaApe] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckGestisciVisBotConsolidaApe", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotCompModApe(Map session) throws BEException {
		/*PROTECTED REGION ID(R1500501264) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			/* Vecchio metodo - compilazione MODOL
			DatiAttestato att = (DatiAttestato) session
					.get(CPBECpCompilaz.APPDATA_CERTIFICATO_CODE);
			
			if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				return false;
			} else if (att.getStatus() == Constants.BOZZA) {
				return true;
			} else {
				return false;
			}
			 */

			return false;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckGestisciVisBotCompModApe] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckGestisciVisBotCompModApe", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotViasualizzaApe(Map session) throws BEException {
		/*PROTECTED REGION ID(R-129976752) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			DatiAttestato att = (DatiAttestato) session.get(CPBECpCompilaz.APPDATA_CERTIFICATO_CODE);

			if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				return false;
			} else if (att.getStatus() == Constants.CONSOLIDATO || att.getStatus() == Constants.INVIATO
					|| att.getStatus() == Constants.DA_INVIARE || att.getStatus() == Constants.ANNULLATO
					|| att.getStatus() == Constants.ANNULLATO_BO) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckGestisciVisBotViasualizzaApe] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckGestisciVisBotViasualizzaApe", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotVerificaApe(Map session) throws BEException {
		/*PROTECTED REGION ID(R-2062413246) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			DatiAttestato att = (DatiAttestato) session.get(CPBECpCompilaz.APPDATA_CERTIFICATO_CODE);

			//return false;

			if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				return false;
			} else if (att.getStatus() == Constants.BOZZA) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckGestisciVisBotVerificaApe] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckGestisciVisBotVerificaApe", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotCaricaXmlRO(Map session) throws BEException {
		/*PROTECTED REGION ID(R-100359596) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			// Imposto come default il false
			return true;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckGestisciVisBotCaricaXmlRO] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckGestisciVisBotCaricaXmlRO", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilGestisciStampaRicevutaReg(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1460323203) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsAbilGestisciStampaRicevutaReg] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilGestisciStampaRicevutaReg",
					ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilGestisciStampaRicevutaAce(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1460339604) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsAbilGestisciStampaRicevutaAce] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilGestisciStampaRicevutaAce",
					ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilGestisciDettRicarica(Map session) throws BEException {
		/*PROTECTED REGION ID(R-271680065) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilGestisciDettRicarica] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilGestisciDettRicarica", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilGestisciGeneraApe(Map session) throws BEException {
		/*PROTECTED REGION ID(R-593155266) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilGestisciGeneraApe] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilGestisciGeneraApe", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilGestisciPagaIscrizione(Map session) throws BEException {
		/*PROTECTED REGION ID(R1249440518) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsAbilGestisciPagaIscrizione] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilGestisciPagaIscrizione", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotVerificaTransazioneReg(Map session) throws BEException {
		/*PROTECTED REGION ID(R-748270006) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			ArrayList<TransazioneRegistrazione> transazioni = (ArrayList<TransazioneRegistrazione>) session
					.get(CPBECpTransazAnomale.APPDATA_TRANSAZIONEREGISTRAZIONE_CODE);

			if (transazioni != null && transazioni.size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckGestisciVisBotVerificaTransazioneReg] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckGestisciVisBotVerificaTransazioneReg", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckGestisciVisBotVerificaTransazioneAce(Map session) throws BEException {
		/*PROTECTED REGION ID(R-748286407) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			ArrayList<TransazioneAce> transazioni = (ArrayList<TransazioneAce>) session
					.get(CPBECpTransazAnomale.APPDATA_TRANSAZIONEACE_CODE);

			if (transazioni != null && transazioni.size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckGestisciVisBotVerificaTransazioneAce] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckGestisciVisBotVerificaTransazioneAce", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVizualizzaCreaJasper(Map session) throws BEException {
		/*PROTECTED REGION ID(R780272020) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			//			Identita currentUser = getCurrentUser(session);
			//
			//			String cfLoggato = currentUser.getCodFiscale();
			boolean ret = false;

			/*
			LOG.debug("customCheckVizualizzaCreaJasper - INIZIO");
			LOG.debug("customCheckVizualizzaCreaJasper - Stampo il CF LOGGATO: *"
					+ cfLoggato + "*");
			
			String users = getMiscMgr().getParametro(
					Constants.SICEE_USER_ENABLED);
			
			if (users != null) {
				String[] cf = users.split(",");
				for (int i = 0; i < cf.length; i++) {
			
					LOG.debug("customCheckVizualizzaCreaJasper - Stampo il CF AUTORIZZATO: *"
							+ cf[i] + "*");
			
					if (cf[i].equalsIgnoreCase(cfLoggato)) {
						ret = true;
						break;
					}
				}
			}
			 */
			LOG.debug("customCheckVizualizzaCreaJasper - Stampo il RET: *" + ret + "*");
			LOG.debug("customCheckVizualizzaCreaJasper - FINE");

			return ret;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVizualizzaCreaJasper] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVizualizzaCreaJasper", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVizualizzaRiportaBozza(Map session) throws BEException {
		/*PROTECTED REGION ID(R1867968499) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			//			Identita currentUser = getCurrentUser(session);
			//
			//String cfLoggato = currentUser.getCodFiscale();

			boolean ret = false;

			/*
			LOG.debug("customCheckVizualizzaRiportaBozza - INIZIO");
			LOG.debug("customCheckVizualizzaRiportaBozza - Stampo il CF LOGGATO: *"
					+ cfLoggato + "*");
			
			String users = getMiscMgr().getParametro(
					Constants.SICEE_USER_ENABLED);
			
			if (users != null) {
				String[] cf = users.split(",");
				for (int i = 0; i < cf.length; i++) {
			
					LOG.debug("customCheckVizualizzaRiportaBozza - Stampo il CF AUTORIZZATO: *"
							+ cf[i] + "*");
			
					if (cf[i].equalsIgnoreCase(cfLoggato)) {
						ret = true;
						break;
					}
				}
			}
			 */
			LOG.debug("customCheckVizualizzaRiportaBozza - Stampo il RET: *" + ret + "*");
			LOG.debug("customCheckVizualizzaRiportaBozza - FINE");

			return ret;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVizualizzaRiportaBozza] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVizualizzaRiportaBozza", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVizualizzaEffettuaCalcoli(Map session) throws BEException {
		/*PROTECTED REGION ID(R-224844285) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			boolean ret = false;

			/*
			Identita currentUser = getCurrentUser(session);
			
			String cfLoggato = currentUser.getCodFiscale();
			
			LOG.debug("customCheckVizualizzaEffettuaCalcoli - INIZIO");
			LOG.debug("customCheckVizualizzaEffettuaCalcoli - Stampo il CF LOGGATO: *"
					+ cfLoggato + "*");
			
			String users = getMiscMgr().getParametro(
					Constants.SICEE_USER_ENABLED);
			
			if (users != null) {
				String[] cf = users.split(",");
				for (int i = 0; i < cf.length; i++) {
			
					LOG.debug("customCheckVizualizzaEffettuaCalcoli - Stampo il CF AUTORIZZATO: *"
							+ cf[i] + "*");
			
					if (cf[i].equalsIgnoreCase(cfLoggato)) {
						ret = true;
						break;
					}
				}
			}
			 */

			LOG.debug("customCheckVizualizzaEffettuaCalcoli - Stampo il RET: *" + ret + "*");
			LOG.debug("customCheckVizualizzaEffettuaCalcoli - FINE");

			return ret;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVizualizzaEffettuaCalcoli] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVizualizzaEffettuaCalcoli", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVizualizzaEffettuaArchivio(Map session) throws BEException {
		/*PROTECTED REGION ID(R83587997) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return false;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVizualizzaEffettuaArchivio] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVizualizzaEffettuaArchivio", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVizualizzaCompletaSw(Map session) throws BEException {
		/*PROTECTED REGION ID(R75034977) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			boolean ret = false;

			/*
			Identita currentUser = getCurrentUser(session);
			
			String cfLoggato = currentUser.getCodFiscale();
			
			LOG.debug("customCheckVizualizzaCompletaSw - INIZIO");
			LOG.debug("customCheckVizualizzaCompletaSw - Stampo il CF LOGGATO: *"
					+ cfLoggato + "*");
			
			String users = getMiscMgr().getParametro(
					Constants.SICEE_USER_ENABLED);
			
			if (users != null) {
				String[] cf = users.split(",");
				for (int i = 0; i < cf.length; i++) {
			
					LOG.debug("customCheckVizualizzaCompletaSw - Stampo il CF AUTORIZZATO: *"
							+ cf[i] + "*");
			
					if (cf[i].equalsIgnoreCase(cfLoggato)) {
						ret = true;
						break;
					}
				}
			}
			 */

			LOG.debug("customCheckVizualizzaCompletaSw - Stampo il RET: *" + ret + "*");
			LOG.debug("customCheckVizualizzaCompletaSw - FINE");

			return ret;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVizualizzaCompletaSw] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVizualizzaCompletaSw", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVizualizzaEstrapolaSw(Map session) throws BEException {
		/*PROTECTED REGION ID(R802506181) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			boolean ret = false;

			/*
			Identita currentUser = getCurrentUser(session);
			
			String cfLoggato = currentUser.getCodFiscale();
			
			LOG.debug("customCheckVizualizzaEstrapolaSw - INIZIO");
			LOG.debug("customCheckVizualizzaEstrapolaSw - Stampo il CF LOGGATO: *"
					+ cfLoggato + "*");
			
			String users = getMiscMgr().getParametro(
					Constants.SICEE_USER_ENABLED);
			
			if (users != null) {
				String[] cf = users.split(",");
				for (int i = 0; i < cf.length; i++) {
			
					LOG.debug("customCheckVizualizzaEstrapolaSw - Stampo il CF AUTORIZZATO: *"
							+ cf[i] + "*");
			
					if (cf[i].equalsIgnoreCase(cfLoggato)) {
						ret = true;
						break;
					}
				}
			}
			 */

			LOG.debug("customCheckVizualizzaEstrapolaSw - Stampo il RET: *" + ret + "*");
			LOG.debug("customCheckVizualizzaEstrapolaSw - FINE");

			return ret;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVizualizzaEstrapolaSw] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVizualizzaEstrapolaSw", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckVisibleIfEsisteLibretto(Map session) throws BEException {
		/*PROTECTED REGION ID(R1253668472) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			VisuraImpianto visura = (VisuraImpianto) session.get(CPBECpCompilazApe.APPDATA_VISURAIMPIANTO_CODE);

			if (BaseMgr.isNullOrEmpty(visura.getUidIndexLibretto())) {
				return false;
			} else {
				return true;
			}

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVisibleIfEsisteLibretto] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVisibleIfEsisteLibretto", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoRiepilogoTransazioni(Map session) throws BEException {
		/*PROTECTED REGION ID(R-692152313) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			if (isCertificatoreAggiornato(session)) {
				switch (getStatoCertificatore(session)) {
					case Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO :
						return false;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO :
						return true;
					default :
				}
			}
			return false;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoRiepilogoTransazioni] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckRegistratoRiepilogoTransazioni",
					ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoRiepilogoTransazioniAnomaleOld(Map session) throws BEException {
		/*PROTECTED REGION ID(R-704662497) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return false;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoRiepilogoTransazioniAnomaleOld] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckRegistratoRiepilogoTransazioniAnomaleOld", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoRiepilogoTransazioniAnomale(Map session) throws BEException {
		/*PROTECTED REGION ID(R1908930792) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoRiepilogoTransazioniAnomale] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckRegistratoRiepilogoTransazioniAnomale", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoInviaCurriculum(Map session) throws BEException {
		/*PROTECTED REGION ID(R337629229) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			switch (getStatoCertificatore(session)) {
				case Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO :
					return false;
				case Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO :
					return true;
				case Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA :
					return true;
				case Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO :
					return false;
				default :
			}
			return false;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckRegistratoInviaCurriculum] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckRegistratoInviaCurriculum", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoPrenotazioneAcquistoAceOld(Map session) throws BEException {
		/*PROTECTED REGION ID(R-663660404) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			return false;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoPrenotazioneAcquistoAceOld] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckRegistratoPrenotazioneAcquistoAceOld", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoPrenotazioneAcquistoAce(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1627556965) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			if (isCertificatoreAggiornato(session)) {
				switch (getStatoCertificatore(session)) {
					case Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO :
						return false;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO :
						return false;
					default :
				}
			}
			return false;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoPrenotazioneAcquistoAce] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckRegistratoPrenotazioneAcquistoAce",
					ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoVisualizzaDuplicaAce(Map session) throws BEException {
		/*PROTECTED REGION ID(R583274968) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			if (isCertificatoreAggiornato(session)) {
				switch (getStatoCertificatore(session)) {
					case Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO :
						return false;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO :
						return true;
					default :
				}
			}
			return false;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoVisualizzaDuplicaAce] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckRegistratoVisualizzaDuplicaAce",
					ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoCompilazioneTrasmissioneAce(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1948106789) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			if (isCertificatoreAggiornato(session)) {
				switch (getStatoCertificatore(session)) {
					case Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO :
						return false;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO :
						return false;
					default :
				}
			}
			return false;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoCompilazioneTrasmissioneAce] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckRegistratoCompilazioneTrasmissioneAce", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckRegistratoSostituzioneAnnullamentoAce(Map session) throws BEException {
		/*PROTECTED REGION ID(R-361560354) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			if (isCertificatoreAggiornato(session)) {
				switch (getStatoCertificatore(session)) {
					case Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO :
						return false;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA :
						return true;
					case Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO :
						return false;
					default :
				}
			}
			return false;
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckRegistratoSostituzioneAnnullamentoAce] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckRegistratoSostituzioneAnnullamentoAce", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckVerificaCodiceFiscale(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1655297578) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			String codiceFiscale = getCurrentUser(session).getCodFiscale();
			String[] codiciFiscaliAmmessi = getMiscMgr().getParametro(Constants.CODICI_FISCALI_MONITORAGGIO).split(",");
			for (String c : codiciFiscaliAmmessi) {
				if (codiceFiscale.equals(c.trim()))
					return true;
			}
			return false;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckVerificaCodiceFiscale] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckVerificaCodiceFiscale", ex);
		}
		/*PROTECTED REGION END*/
	}

	//////////////////////////////////////////////////////////////////////////////
	/// properieta' di configurazione dell'helper
	//////////////////////////////////////////////////////////////////////////////

	private String pdProtocol = "EJB";

	/**
	 * @param prot protocollo di richiamo del PEP. Puo' valere: 
	 * 1) EJB (default)
	 * 2) WS
	 * utilizzato solo se la security non e' custom
	 */
	public void setPDProtocol(String prot) {
		pdProtocol = prot;
	}

	public String getPDProtocol() {
		return pdProtocol;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1742205394) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	public static boolean isDataScaduta(String s) throws BEException {
		if (s == null || s.length() == 0)
			return false;
		else {
			java.util.Date dScadenza = DateUtil.convertToDate(s);
			if (dScadenza.getTime() > System.currentTimeMillis())
				return true;
			else
				return false;
		}
	}

	public boolean verifyCurrentUserForRoleInApplication(Map session) throws BEException {
		Identita currentUser = getCurrentUser(session);
		Ruolo rol = new Ruolo();

		try {
			if (getIridePEP().findRuoliForPersonaInApplication(getCurrentUser(session), IRIDE2_APPLICATION) == null) {
				return false;
			}

			return true;
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] identita' non autentica [" + currentUser + "]," + e);
			throw new BEException("verifyCurrentUserForRole: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (UnrecoverableException e) {
			LOG.error(
					"[SecurityHelper::verifyCurrentUserForRole] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForRole:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForRole:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		}
	}

	public boolean verifyCurrentUserForUseCaseInApplication(Map session) throws BEException {
		Identita currentUser = getCurrentUser(session);

		try {
			UseCase[] array = getIridePEP().findUseCasesForPersonaInApplication(getCurrentUser(session),
					IRIDE2_APPLICATION);

			if (array == null) {
				return false;
			}

			if (array.length == 0) {
				return false;
			}

			return true;
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] identita' non autentica [" + currentUser + "]," + e);
			throw new BEException("verifyCurrentUserForRole: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (UnrecoverableException e) {
			LOG.error(
					"[SecurityHelper::verifyCurrentUserForRole] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForRole:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForRole:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		}
	}

	private int getStatoCertificatore(Map session) throws BEException {
		try {
			DatiCertificatore dc = (DatiCertificatore) session.get("appDatacertificatore");
			if (dc != null)
				return dc.getStato();
			else
				return Constants.STATO_CERTIFICATORE_ERRATO;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckRegistrato1] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckRegistrato1", ex);
		}
	}

	private boolean isCertificatoreAggiornato(Map session) throws BEException {
		try {
			DatiCertificatore dc = (DatiCertificatore) session.get("appDatacertificatore");

			boolean isAggiornato = false;
			if (dc != null) {
				// verifico che il certificatore abbia aggiornato la mail i dati e non sia bloccato
				isAggiornato = dc.getFlgAggEmail() && dc.getFlgAggDati() && GenericUtil.isNullOrEmpty(dc.getIdBlocco());
			}

			return isAggiornato;

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckRegistrato1] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckRegistrato1", ex);
		}
	}

	private boolean getCertificatiInviati(Map session) throws BEException {
		try {
			ArrayList<Ace> dc = (ArrayList<Ace>) session.get("appDatacertificatiInviati");
			if (dc != null && dc.isEmpty()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckRegistrato1] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckRegistrato1", ex);
		}
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	/*PROTECTED REGION END*/
}
