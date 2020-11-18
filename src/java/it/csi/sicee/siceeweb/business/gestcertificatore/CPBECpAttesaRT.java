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

/*PROTECTED REGION ID(R880506288) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.TransazioneCreditoMgr;
import it.csi.sicee.siceeweb.business.facade.ValidationMgr;
import it.csi.sicee.siceeweb.business.facade.exceptions.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpAttesaRT {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [statiTransazioneMdpNew, scope:USER_SESSION]
	public static final String APPDATA_STATITRANSAZIONEMDPNEW_CODE = "appDatastatiTransazioneMdpNew";

	// ApplicationData: [datiPagamentoNewList, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTONEWLIST_CODE = "appDatadatiPagamentoNewList";

	// ApplicationData: [idStatoTransazioneMdpNewSelez, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOTRANSAZIONEMDPNEWSELEZ_CODE = "appDataidStatoTransazioneMdpNewSelez";

	// ApplicationData: [idDatiPagamentoNewSelez, scope:USER_SESSION]
	public static final String APPDATA_IDDATIPAGAMENTONEWSELEZ_CODE = "appDataidDatiPagamentoNewSelez";

	// ApplicationData: [datiPagamentoNew, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTONEW_CODE = "appDatadatiPagamentoNew";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAttesaRT";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricaricaDatiPagamento definito in un ExecCommand del
	 * ContentPanel cpAttesaRT
	 */
	public ExecResults ricaricaDatiPagamento(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpAttesaRTModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICARICADATIPAGAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1468801955) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			// Recupero le transazioni
			ArrayList<DatiPagamentoNew> transazioneMdp = getTransazioneCreditoMgr().getTransazioneByIdStato(
					theModel.getAppDataidStatoTransazioneMdpNewSelez(), certificatore.getIdCertificatore());

			theModel.setAppDatadatiPagamentoNewList(transazioneMdp);

			// impostazione del result code 
			result.setResultCode(RICARICADATIPAGAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricaricaDatiPagamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaRicevutaRicarica definito in un ExecCommand del
	 * ContentPanel cpAttesaRT
	 */
	public ExecResults stampaRicevutaRicarica(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpAttesaRTModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPARICEVUTARICARICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPARICEVUTARICARICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1944793410) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idTranszione2018 = theModel.getAppDataidDatiPagamentoNewSelez();
			try {
				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(Converter.convertToString(idTranszione2018));

				DatiPagamentoNew datiPag = getTransazioneCreditoMgr().getTransazioneById(idTranszione2018);

				theModel.setAppDatadatiPagamentoNew(datiPag);

				// impostazione del result code 
				result.setResultCode(STAMPARICEVUTARICARICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaRicevutaRicarica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaDatiPagamento definito in un ExecCommand del
	 * ContentPanel cpAttesaRT
	 */
	public ExecResults caricaDatiPagamento(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpAttesaRTModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADATIPAGAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-794894676) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			// Verifico se la combo e' gia' presente in sessione
			ArrayList<LabelValueCombo> statiTransazioneMdp = theModel.getAppDatastatiTransazioneMdpNew();

			if (statiTransazioneMdp == null) {
				statiTransazioneMdp = getTransazioneCreditoMgr().getComboStatiTransazione2018();

				theModel.setAppDatastatiTransazioneMdpNew(statiTransazioneMdp);
			}

			// Setto come default "ATTESA RT"
			theModel.setAppDataidStatoTransazioneMdpNewSelez(Constants.ID_STATO_TRANS_2018_ATTESA_RT);

			// Recupero le transazioni
			ArrayList<DatiPagamentoNew> transazioneMdp = getTransazioneCreditoMgr().getTransazioneByIdStato(
					theModel.getAppDataidStatoTransazioneMdpNewSelez(), certificatore.getIdCertificatore());

			theModel.setAppDatadatiPagamentoNewList(transazioneMdp);

			// impostazione del result code 
			result.setResultCode(CARICADATIPAGAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaDatiPagamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_transCredito
	 */
	public static void resetClearStatus_widg_transCredito(java.util.Map session) {
		session.put("cpAttesaRT_transCredito_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1626323260) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private TransazioneCreditoMgr transazioneCreditoMgr = null;

	public TransazioneCreditoMgr getTransazioneCreditoMgr() {
		return transazioneCreditoMgr;
	}

	public void setTransazioneCreditoMgr(TransazioneCreditoMgr transazioneCreditoMgr) {
		this.transazioneCreditoMgr = transazioneCreditoMgr;
	}

	private ValidationMgr validationMgr = null;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	/*PROTECTED REGION END*/
}
