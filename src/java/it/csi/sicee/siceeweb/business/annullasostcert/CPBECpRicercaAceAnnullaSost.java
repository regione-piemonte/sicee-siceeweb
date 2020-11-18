package it.csi.sicee.siceeweb.business.annullasostcert;

import java.util.*;

import it.csi.sicee.siceeweb.dto.*;
import it.csi.sicee.siceeweb.dto.ace.*;
import it.csi.sicee.siceeweb.dto.attestati.*;
import it.csi.sicee.siceeweb.dto.certificatore.*;
import it.csi.sicee.siceeweb.dto.geo.*;
import it.csi.sicee.siceeweb.dto.pagamenti.*;
import it.csi.sicee.siceeweb.dto.daticert.*;
import it.csi.sicee.siceeweb.dto.transazioni.*;
import it.csi.sicee.siceeweb.dto.annullamento.*;
import it.csi.sicee.siceeweb.dto.commons.*;

import org.apache.log4j.*;
import it.csi.sicee.siceeweb.util.*;
import it.csi.sicee.siceeweb.business.*;

/*PROTECTED REGION ID(R303477210) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;

/*PROTECTED REGION END*/

public class CPBECpRicercaAceAnnullaSost {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [datiAnnullamento, scope:USER_SESSION]
	public static final String APPDATA_DATIANNULLAMENTO_CODE = "appDatadatiAnnullamento";

	// ApplicationData: [certificatiTrovati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATITROVATI_CODE = "appDatacertificatiTrovati";

	// ApplicationData: [codiciCertificatiSelezionati, scope:USER_SESSION]
	public static final String APPDATA_CODICICERTIFICATISELEZIONATI_CODE = "appDatacodiciCertificatiSelezionati";

	// ApplicationData: [filtroAce, scope:USER_ACTION]
	public static final String APPDATA_FILTROACE_CODE = "appDatafiltroAce";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [province, scope:USER_ACTION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_ACTION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [idTipoRicAnnullametoSost, scope:USER_SESSION]
	public static final String APPDATA_IDTIPORICANNULLAMETOSOST_CODE = "appDataidTipoRicAnnullametoSost";

	// ApplicationData: [isPrimoIngresso, scope:USER_SESSION]
	public static final String APPDATA_ISPRIMOINGRESSO_CODE = "appDataisPrimoIngresso";

	// ApplicationData: [carrelloAceNew, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACENEW_CODE = "appDatacarrelloAceNew";

	// ApplicationData: [carrelloAceOld, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACEOLD_CODE = "appDatacarrelloAceOld";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAceAnnullaSost";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaACEByCodice definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults ricercaACEByCodice(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYCODICE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYCODICE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-3232629) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

			if (log.isDebugEnabled())
				GenericUtil.stampa(filtro, true, 4);

			boolean out = true;
			if (GenericUtil.isNullOrEmpty(filtro.getAnnoCertificato())) {
				addMissingRequiredFieldError("appDatafiltroAce.annoCertificato", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(filtro.getCertificatore())) {
				addMissingRequiredFieldError("appDatafiltroAce.certificatore", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(filtro.getProgCertificato())) {
				addMissingRequiredFieldError("appDatafiltroAce.progCertificato", result);
				out = false;
			}

			if (out) {

				ArrayList<Ace> aceList = null;

				resetClearStatus_widg_tblRisultatoRicercaAceInviati(theModel.getSession());

				boolean flgPregresso = theModel.getAppDatadatiAnnullamento().getFlgRicercaPregresso();
				if (filtro != null) {
					if (GenericUtil.checkFiltroAce(filtro)) {
						// prende solo gli Ace con stato Inviato

						Integer statoAce = null;
						if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_OLD) {
							statoAce = Constants.INVIATO;
						} else if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_NEW) {

							if (flgPregresso) {
								statoAce = Constants.INVIATO;
							} else {
								statoAce = Constants.DA_INVIARE;
							}
						}

						filtro.setStato(statoAce);

						aceList = (ArrayList<Ace>) getSOAIntegrationMgr().findAceFlgPregresso(filtro, flgPregresso);

						/*
						aceList = (ArrayList<Ace>) getCertificatoMgr()
								.getCertificatiAnnullaSostByCodice(filtro,
										statoAce, flgPregresso);
						 */

						result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__OK);

					} else {
						result.getGlobalErrors().add(
								"Attenzione. Tutti i campi sono obbligatori ed e' necessario inserirli come indicati nell'esempio.");

						// impostazione del result code
						result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__KO);
					}
				}
				theModel.setAppDatacertificatiTrovati(aceList);
			} else {
				result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaACEByCodice] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisibBotAggiungiByCodice definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisibBotAggiungiByCodice(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISIBBOTAGGIUNGIBYCODICE_OUTCOME_CODE__BOTTONE_AGG_VIS_COD = //NOSONAR  Reason:EIAS
				"BOTTONE_AGG_VIS_COD"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISIBBOTAGGIUNGIBYCODICE_OUTCOME_CODE__BOTTONE_AGG_NON_VIS_COD = //NOSONAR  Reason:EIAS
				"BOTTONE_AGG_NON_VIS_COD"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2007204265) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatacertificatiTrovati().size() > 0) {
				result.setResultCode(GESTISCIVISIBBOTAGGIUNGIBYCODICE_OUTCOME_CODE__BOTTONE_AGG_VIS_COD);
			} else {
				result.setResultCode(GESTISCIVISIBBOTAGGIUNGIBYCODICE_OUTCOME_CODE__BOTTONE_AGG_NON_VIS_COD);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciVisibBotAggiungiByCodice] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastali definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2044480864) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode("OK");
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAceByFiltro definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1085739338) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer statoAce = null;
			String idCerificatore = null;
			ArrayList<Ace> aceList = null;

			resetClearStatus_widg_tblRisultatoRicercaAceInviati(theModel.getSession());

			boolean flgPregresso = theModel.getAppDatadatiAnnullamento().getFlgRicercaPregresso();

			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

			if (GenericUtil.checkFiltroAce2(filtro)) {

				if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_OLD) {

					log.debug("ENTRO A MODIFICARE LO STATO");
					statoAce = Constants.INVIATO;
				} else if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_NEW) {

					if (flgPregresso) {
						statoAce = Constants.INVIATO;
					} else {
						statoAce = Constants.DA_INVIARE;
					}

					idCerificatore = theModel.getAppDatacertificatore().getIdCertificatore();

				}

				filtro.setStato(statoAce);

				log.debug("STAMPO LO STATO: " + filtro.getStato());

				Integer countAce = getSOAIntegrationMgr().findAceFiltroCount(filtro, idCerificatore, flgPregresso);

				log.debug("Stampo il countAce: " + countAce);

				/*
				Integer countAce = getCertificatoMgr()
						.getCertificatiAnnullaSostByParametriCount(filtro,
								idCerificatore, statoAce, flgPregresso);
				 */
				if (countAce != null && countAce > 0) {

					Integer numMax = getCertificatoMgr().getNumeroMaxAceAnnullaSost();

					log.debug("Stampo il numMax: " + numMax);

					if (countAce < numMax) {

						/*
						aceList = (ArrayList<Ace>) getCertificatoMgr()
								.getCertificatiAnnullaSostByParametri(filtro,
										idCerificatore, statoAce, flgPregresso);
						 */

						aceList = (ArrayList<Ace>) getSOAIntegrationMgr().findAceFiltro(filtro, idCerificatore,
								flgPregresso, true);

						// impostazione del result code
						result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Sono stati estratti " + countAce
								+ " record. E' necessario restringere il campo della ricerca. Il massimo consentito e' "
								+ numMax + " record.");

						result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
					}
				} else {
					aceList = new ArrayList<Ace>();
					result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__OK);
				}
			} else {

				result.getGlobalErrors().add("Attenzione. Nessun criterio di ricerca selezionato.");

				// impostazione del result code
				result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
			}

			theModel.setAppDatacertificatiTrovati(aceList);

			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAceByFiltro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisibBotAggiungiByFiltro definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisibBotAggiungiByFiltro(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISIBBOTAGGIUNGIBYFILTRO_OUTCOME_CODE__BOTTONE_AGG_VIS_FILTRO = //NOSONAR  Reason:EIAS
				"BOTTONE_AGG_VIS_FILTRO"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISIBBOTAGGIUNGIBYFILTRO_OUTCOME_CODE__BOTTONE_AGG_NON_VIS_FILTRO = //NOSONAR  Reason:EIAS
				"BOTTONE_AGG_NON_VIS_FILTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-793754494) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatacertificatiTrovati().size() > 0) {
				result.setResultCode(GESTISCIVISIBBOTAGGIUNGIBYFILTRO_OUTCOME_CODE__BOTTONE_AGG_VIS_FILTRO);
			} else {
				result.setResultCode(GESTISCIVISIBBOTAGGIUNGIBYFILTRO_OUTCOME_CODE__BOTTONE_AGG_NON_VIS_FILTRO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciVisibBotAggiungiByFiltro] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaScaricoModulo definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO_COPIA = //NOSONAR  Reason:EIAS
				"ATTESTATO_COPIA"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO_DIFINITIVO = //NOSONAR  Reason:EIAS
				"ATTESTATO_DIFINITIVO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2132808774) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDatacodAttestatoDaStampare(theModel.getIdRiga());

			if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_OLD) {
				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO_COPIA);
			} else if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_NEW) {
				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO_DIFINITIVO);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaScaricoModulo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiungiAlCarrello definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults aggiungiAlCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIUNGIALCARRELLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIUNGIALCARRELLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1421540565) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<String> idCertSelez = theModel.getAppDatacodiciCertificatiSelezionati();

			ArrayList<Ace> carrelloOld = null;
			ArrayList<Ace> carrelloNew = null;
			ArrayList<Ace> aceTrovati = theModel.getAppDatacertificatiTrovati();

			if (idCertSelez != null && idCertSelez.size() > 0) {

				if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_OLD) {

					carrelloOld = theModel.getAppDatacarrelloAceOld();

					carrelloOld = addCertificatiAlCarrello(idCertSelez, carrelloOld, aceTrovati);

					theModel.setAppDatacarrelloAceOld(carrelloOld);

				} else if (theModel.getAppDataidTipoRicAnnullametoSost() == Constants.ID_RICERCA_ACE_NEW) {
					carrelloNew = theModel.getAppDatacarrelloAceNew();

					carrelloNew = addCertificatiAlCarrello(idCertSelez, carrelloNew, aceTrovati);

					theModel.setAppDatacarrelloAceNew(carrelloNew);

				}

				result.getGlobalMessages().add("Certificati aggiunti correttamente.");

				result.setResultCode(AGGIUNGIALCARRELLO_OUTCOME_CODE__OK);

			} else {
				result.getGlobalErrors().add("Attenzione. Nessun certificato selezionato.");

				result.setResultCode(AGGIUNGIALCARRELLO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiungiAlCarrello] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisualizzaCarrello definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisualizzaCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISUALIZZACARRELLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R287045394) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataisPrimoIngresso(true);

			// impostazione del result code
			result.setResultCode(GESTISCIVISUALIZZACARRELLO_OUTCOME_CODE__OK);
			theModel.setAppDatapaginaProvenienza(Constants.PAGINA_RICERCA_ACE);

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisualizzaCarrello] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciInitAnnullaSost definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciInitAnnullaSost(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINITANNULLASOST_OUTCOME_CODE__ACE_OLD = //NOSONAR  Reason:EIAS
				"ACE_OLD"; //NOSONAR  Reason:EIAS
		final String GESTISCIINITANNULLASOST_OUTCOME_CODE__ACE_NEW = //NOSONAR  Reason:EIAS
				"ACE_NEW"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1592589484) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idTipoRic = theModel.getAppDataidTipoRicAnnullametoSost();

			if (idTipoRic == Constants.ID_RICERCA_ACE_OLD) {
				result.setResultCode(GESTISCIINITANNULLASOST_OUTCOME_CODE__ACE_OLD);
			} else if (idTipoRic == Constants.ID_RICERCA_ACE_NEW) {
				result.setResultCode(GESTISCIINITANNULLASOST_OUTCOME_CODE__ACE_NEW);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciInitAnnullaSost] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciCombo definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R535372792) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);

			// impostazione del result code
			result.setResultCode(GESTISCICOMBO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciCombo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisCarrello definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_VIS = //NOSONAR  Reason:EIAS
				"CARRELLO_VIS"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_NON_VIS = //NOSONAR  Reason:EIAS
				"CARRELLO_NON_VIS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R761008510) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Ace> carrelloOld = theModel.getAppDatacarrelloAceOld();
			ArrayList<Ace> carrelloNew = theModel.getAppDatacarrelloAceNew();

			if ((carrelloOld != null && !carrelloOld.isEmpty()) || (carrelloNew != null && !carrelloNew.isEmpty())) {
				result.setResultCode(GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_VIS);
			} else {
				result.setResultCode(GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_NON_VIS);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisCarrello] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciInitAnnullaSostPrimoIngresso definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciInitAnnullaSostPrimoIngresso(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINITANNULLASOSTPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_SI = //NOSONAR  Reason:EIAS
				"PRIMO_INGRESSO_SI"; //NOSONAR  Reason:EIAS
		final String GESTISCIINITANNULLASOSTPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_NO = //NOSONAR  Reason:EIAS
				"PRIMO_INGRESSO_NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-314687255) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataisPrimoIngresso()) {
				theModel.setAppDataisPrimoIngresso(false);
				result.setResultCode(GESTISCIINITANNULLASOSTPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_SI);
			} else {
				result.setResultCode(GESTISCIINITANNULLASOSTPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_NO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciInitAnnullaSostPrimoIngresso] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo precaricaFiltroRicercaACE definito in un ExecCommand del
	 * ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults precaricaFiltroRicercaACE(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PRECARICAFILTRORICERCAACE_OUTCOME_CODE__OKPRECARICA = //NOSONAR  Reason:EIAS
				"OKPRECARICA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-548115507) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();
			Integer idTipoRic = theModel.getAppDataidTipoRicAnnullametoSost();
			if (idTipoRic == Constants.ID_RICERCA_ACE_NEW) {

				if (filtro == null)
					filtro = new FiltroRicercaAce();
				DatiCertificatore certificatore = theModel.getAppDatacertificatore();
				if (certificatore != null)
					filtro.setCertificatore(certificatore.getNumCertificatore());
				theModel.setAppDatafiltroAce(filtro);

			}
			// impostazione del result code
			result.setResultCode(PRECARICAFILTRORICERCAACE_OUTCOME_CODE__OKPRECARICA);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::precaricaFiltroRicercaACE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRisultatoRicercaAceInviati
	 */
	public static void resetClearStatus_widg_tblRisultatoRicercaAceInviati(java.util.Map session) {
		session.put("cpRicercaAceAnnullaSost_tblRisultatoRicercaAceInviati_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-111780076) ENABLED START*/
	// // inserire qui le property che si vogliono iniettare in questo bean (es.
	// dao, proxy di pd, ...)

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private void gestisciComboDtCatasto(it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel)
			throws BEException {

		FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByPiemonte();
		theModel.setAppDataprovince(province);

		String actProvSel = filtro != null ? filtro.getCodProv() : null;
		ArrayList<Comune> comuni = new ArrayList<Comune>();

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuni(comuni);
	}

	private ArrayList<Ace> addCertificatiAlCarrello(ArrayList<String> idCertSelez, ArrayList<Ace> carrello,
			ArrayList<Ace> aceTrovati) {

		if (carrello == null) {
			carrello = new ArrayList<Ace>();
		}

		for (int i = 0; i < idCertSelez.size(); i++) {
			String certificato = idCertSelez.get(i);

			boolean isPresente = false;

			for (int j = 0; j < carrello.size(); j++) {

				if (carrello.get(j).getCodice().equals(certificato)) {
					isPresente = true;
					break;
				}
			}

			if (!isPresente) {

				for (int j = 0; j < aceTrovati.size(); j++) {
					Ace ace = aceTrovati.get(j);
					if (ace.getCodice().equals(certificato)) {
						carrello.add(ace);
						break;
					}

				}

			}

		}

		return carrello;
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	/*PROTECTED REGION END*/
}
