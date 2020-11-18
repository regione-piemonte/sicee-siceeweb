package it.csi.sicee.siceeweb.business.gestcertificatore;

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

/*PROTECTED REGION ID(R551361558) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneAceMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneRegistrazMgr;
import it.csi.sicee.siceeweb.dto.transazioni.Transazione;
/*PROTECTED REGION END*/

public class CPBECpTransazAnomale {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [transazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONE_CODE = "appDatatransazione";

	// ApplicationData: [idTransazione, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONE_CODE = "appDataidTransazione";

	// ApplicationData: [transazioneAce, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEACE_CODE = "appDatatransazioneAce";

	// ApplicationData: [transazioneRegistrazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEREGISTRAZIONE_CODE = "appDatatransazioneRegistrazione";

	// ApplicationData: [msgEsitoTransazione, scope:USER_ACTION]
	public static final String APPDATA_MSGESITOTRANSAZIONE_CODE = "appDatamsgEsitoTransazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpTransazAnomale";

	public static final String WIZARD_PWIZTRANSAZ = "pWizTransaz";
	public static final String STEP_PWIZTRANSAZ_PREGISTRAZCERT = CPNAME + "_" + WIZARD_PWIZTRANSAZ + "_"
			+ "pRegistrazCert";
	public static final String STEP_PWIZTRANSAZ_PACQUISTOACE = CPNAME + "_" + WIZARD_PWIZTRANSAZ + "_" + "pAcquistoAce";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaTransazioneReg definito in un ExecCommand del
	 * ContentPanel cpTransazAnomale
	 */
	public ExecResults verificaTransazioneReg(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICATRANSAZIONEREG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICATRANSAZIONEREG_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String VERIFICATRANSAZIONEREG_OUTCOME_CODE__NOP = //NOSONAR  Reason:EIAS
				"NOP"; //NOSONAR  Reason:EIAS
		final String VERIFICATRANSAZIONEREG_OUTCOME_CODE__MIDDLE = //NOSONAR  Reason:EIAS
				"MIDDLE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2135097064) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Long idTransazione = theModel.getAppDataidTransazione();
			if (idTransazione != null) {
				long stato = getTransazioneRegistrazioneMgr().aggiornaStatoTransazione(idTransazione);
				if (stato == Constants.TRANSAZIONE_MDP_OK) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();

					//					DatiPagamento dp = getTransazioneRegistrazoneSelezionataAndConvert(
					//							theModel, idTransazione);

					getCertificatoreMgr().completaRegistrazione(idTransazione, cert);
					cert = getCertificatoreMgr().loadCertifcatoreByCF(theModel.getAppDatacurrentUser().getCodFisc());

					cert.setFlgAggDati(true);

					getCertificatoreMgr().aggiornaCertificatoreFlgDati(cert.getIdCertificatore());

					theModel.setAppDatacertificatore(cert);

					//					theModel.setAppDatamsgEsitoTransazione("La registrazione all&rsquo;elenco regionale &egrave; avvenuta con successo. Il suo N. di iscrizione &egrave; il seguente: "
					//							+ cert.getNumCertificatore());

					if (cert.getFlgCompetenzeNaz()) {
						theModel.setAppDatamsgEsitoTransazione(
								Constants.MSG_OK_REGISTRAZ_NAZ + "\"" + cert.getNumCertificatore() + "\"");
					} else {
						theModel.setAppDatamsgEsitoTransazione(
								Constants.MSG_OK_REGISTRAZ_REG + "\"" + cert.getNumCertificatore() + "\"");
					}

					result.setResultCode(VERIFICATRANSAZIONEREG_OUTCOME_CODE__OK);
				} else if (stato == Constants.TRANSAZIONE_MDP_MIDDLE) {
					theModel.setAppDatamsgEsitoTransazione(
							"Attenzione! Non &egrave; possibile verificare la transazione. Contattare il servizio energia.");
					result.setResultCode(VERIFICATRANSAZIONEREG_OUTCOME_CODE__MIDDLE);
				} else {
					theModel.setAppDatamsgEsitoTransazione(
							"Attenzione! La transazione non &egrave; andata a buon fine.");
					result.setResultCode(VERIFICATRANSAZIONEREG_OUTCOME_CODE__KO);
				}
			} else {
				result.getGlobalErrors().add("E' necessario selezionare un transazione");
				result.setResultCode(VERIFICATRANSAZIONEREG_OUTCOME_CODE__NOP);
			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaTransazioneReg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaTransazioneAce definito in un ExecCommand del
	 * ContentPanel cpTransazAnomale
	 */
	public ExecResults verificaTransazioneAce(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICATRANSAZIONEACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICATRANSAZIONEACE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String VERIFICATRANSAZIONEACE_OUTCOME_CODE__NOP = //NOSONAR  Reason:EIAS
				"NOP"; //NOSONAR  Reason:EIAS
		final String VERIFICATRANSAZIONEACE_OUTCOME_CODE__MIDDLE = //NOSONAR  Reason:EIAS
				"MIDDLE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R739826777) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Long idTransazione = theModel.getAppDataidTransazione();
			if (idTransazione != null) {
				Transazione trDB = getTransazioneAceMgr().getTransazione(idTransazione);

				String statoTransazDB = trDB.getStato();

				if (!statoTransazDB.equals(Constants.TRANSAZIONE_INIZIALIZED)
						&& !statoTransazDB.equals(Constants.TRANSAZIONE_STARTED)) {
					theModel.setAppDatamsgEsitoTransazione(
							"Attenzione! La transazione &egrave; gi&agrave; stata verificata, verificare nel riepilogo delle transazioni.");
					result.setResultCode(VERIFICATRANSAZIONEACE_OUTCOME_CODE__MIDDLE);
				} else if (trDB.getNumeroTransazione().length() > Constants.TRANSAZIONE_OLD_MDP) {

					//					long stato = getTransazioneAceMgr()
					//							.aggiornaStatoTransazione(idTransazione);

					long statoMDP = getTransazioneAceMgr().recuperaStatoTransazioneMDP(trDB.getNumeroTransazione());

					if (statoMDP == Constants.TRANSAZIONE_MDP_OK) {
						theModel.setAppDatamsgEsitoTransazione(
								"La prenotazione di attestati di prestazione energetica &egrave; avvenuto con successo. E&rsquo; possibile stampare la ricevuta di acquisto cliccando il pulsante &quot;stampa ricevuta&quot;.");
						DatiCertificatore cert = theModel.getAppDatacertificatore();

						//						DatiPagamento dp = getTransazioneAceSelezionataAndConvert(
						//								theModel, idTransazione);

						getCertificatoMgr().completaAcquistoACE(idTransazione, cert);
						result.setResultCode(VERIFICATRANSAZIONEACE_OUTCOME_CODE__OK);
					} else if (statoMDP == Constants.TRANSAZIONE_MDP_MIDDLE) {

						getTransazioneAceMgr().aggiornaStatoTransazione(idTransazione, statoMDP);

						theModel.setAppDatamsgEsitoTransazione(
								"Attenzione! Non &egrave; possibile verificare la transazione. Contattare il servizio energia.");
						result.setResultCode(VERIFICATRANSAZIONEACE_OUTCOME_CODE__MIDDLE);
					} else {

						getTransazioneAceMgr().aggiornaStatoTransazione(idTransazione, statoMDP);

						theModel.setAppDatamsgEsitoTransazione("La transazione non &egrave; andata a buon fine.");
						result.setResultCode(VERIFICATRANSAZIONEACE_OUTCOME_CODE__KO);
					}
				} else {
					theModel.setAppDatamsgEsitoTransazione(
							"Attenzione! Non &egrave; possibile verificare la transazione. Contattare il servizio energia.");
					result.setResultCode(VERIFICATRANSAZIONEACE_OUTCOME_CODE__KO);
				}
			} else {
				result.getGlobalErrors().add("E' necessario selezionare una transazione");
				result.setResultCode(VERIFICATRANSAZIONEACE_OUTCOME_CODE__NOP);
			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaTransazioneAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaRicevutaAce definito in un ExecCommand del
	 * ContentPanel cpTransazAnomale
	 */
	public ExecResults stampaRicevutaAce(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPARICEVUTAACE_OUTCOME_CODE__OK_ACE = //NOSONAR  Reason:EIAS
				"OK_ACE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1073910733) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(STAMPARICEVUTAACE_OUTCOME_CODE__OK_ACE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaRicevutaAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaRicevutaReg definito in un ExecCommand del
	 * ContentPanel cpTransazAnomale
	 */
	public ExecResults stampaRicevutaReg(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPARICEVUTAREG_OUTCOME_CODE__OK_REG = //NOSONAR  Reason:EIAS
				"OK_REG"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R321359554) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(STAMPARICEVUTAREG_OUTCOME_CODE__OK_REG);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaRicevutaReg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaTransazioni definito in un ExecCommand del
	 * ContentPanel cpTransazAnomale
	 */
	public ExecResults initListaTransazioni(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTATRANSAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1384035670) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore certificatore = theModel.getAppDatacertificatore();
			ArrayList<TransazioneAce> listAce = getTransazioneAceMgr().getTransazioniAnomale(certificatore);
			ArrayList<TransazioneRegistrazione> listReg = getTransazioneRegistrazioneMgr()
					.getTransazioniAnomale(certificatore);

			if (log.isDebugEnabled()) {
				log.debug("Numero Transazioni ACE: " + listAce.size());
				log.debug("Numero Transazioni Registrazione: " + listReg.size());
			}

			theModel.setAppDatatransazioneAce(listAce);
			theModel.setAppDatatransazioneRegistrazione(listReg);

			certificatore.setTransazioneAnomale(((listAce.size() > 0) || (listReg.size() > 0)));

			// impostazione del result code 
			result.setResultCode(INITLISTATRANSAZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaTransazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_transReg
	 */
	public static void resetClearStatus_widg_transReg(java.util.Map session) {
		session.put("cpTransazAnomale_transReg_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_transAce
	 */
	public static void resetClearStatus_widg_transAce(java.util.Map session) {
		session.put("cpTransazAnomale_transAce_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R479454302) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private DatiPagamento getTransazioneAceSelezionataAndConvert(
			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel model, long id) {
		ArrayList<TransazioneAce> array = model.getAppDatatransazioneAce();
		TransazioneAce ta = null;
		for (TransazioneAce a : array) {
			if (a.getIdTransazione() == id) {
				ta = a;
				break;
			}
		}

		DatiPagamento ret = new DatiPagamento();
		ret.setIdTransazione(ta.getIdTransazione());
		ret.setQuantita(BaseMgr.convertToInteger(ta.getQuantita()));
		try {
			ret.setDataValuta(DateUtil.convertToUDTDateValid(DateUtil.convertToDate(ta.getDataTransazione())));
		} catch (BEException e) {
			log.error("ERRORE", e);
		}
		return ret;
	}

	private DatiPagamento getTransazioneRegistrazoneSelezionataAndConvert(
			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel model, long id) {
		ArrayList<TransazioneRegistrazione> array = model.getAppDatatransazioneRegistrazione();
		TransazioneRegistrazione ta = null;
		for (TransazioneRegistrazione a : array) {
			if (a.getIdTransazione() == id) {
				ta = a;
				break;
			}
		}

		DatiPagamento ret = new DatiPagamento();
		ret.setIdTransazione(ta.getIdTransazione());

		try {
			ret.setDataValuta(DateUtil.convertToUDTDateValid(DateUtil.convertToDate(ta.getDataTransazione())));
		} catch (BEException e) {
			log.error("ERRORE", e);
		}
		return ret;
	}

	private TransazioneAceMgr transazioneAceMgr = null;
	private TransazioneRegistrazMgr transazioneRegistrazioneMgr = null;

	public TransazioneAceMgr getTransazioneAceMgr() {
		return transazioneAceMgr;
	}

	public void setTransazioneAceMgr(TransazioneAceMgr transazioneAceMgr) {
		this.transazioneAceMgr = transazioneAceMgr;
	}

	public TransazioneRegistrazMgr getTransazioneRegistrazioneMgr() {
		return transazioneRegistrazioneMgr;
	}

	public void setTransazioneRegistrazioneMgr(TransazioneRegistrazMgr transazioneRegistrazioneMgr) {
		this.transazioneRegistrazioneMgr = transazioneRegistrazioneMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}
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

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/*PROTECTED REGION END*/
}
