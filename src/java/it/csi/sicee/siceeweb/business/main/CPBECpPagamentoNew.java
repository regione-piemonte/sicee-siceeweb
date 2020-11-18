package it.csi.sicee.siceeweb.business.main;

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

/*PROTECTED REGION ID(R-1181613494) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneCreditoMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.ValidationMgr;
import it.csi.sicee.siceeweb.business.facade.exceptions.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpPagamentoNew {

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

	// ApplicationData: [switchPagamento, scope:USER_SESSION]
	public static final String APPDATA_SWITCHPAGAMENTO_CODE = "appDataswitchPagamento";

	// ApplicationData: [gestoriPagamento, scope:USER_SESSION]
	public static final String APPDATA_GESTORIPAGAMENTO_CODE = "appDatagestoriPagamento";

	// ApplicationData: [transazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONE_CODE = "appDatatransazione";

	// ApplicationData: [datiPagamentoNew, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTONEW_CODE = "appDatadatiPagamentoNew";

	// ApplicationData: [mdpNewURL, scope:USER_SESSION]
	public static final String APPDATA_MDPNEWURL_CODE = "appDatamdpNewURL";

	// ApplicationData: [numeroTransazione, scope:USER_SESSION]
	public static final String APPDATA_NUMEROTRANSAZIONE_CODE = "appDatanumeroTransazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpPagamentoNew";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaPagamento definito in un ExecCommand del
	 * ContentPanel cpPagamentoNew
	 */
	public ExecResults preparaPagamento(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoNewModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAPAGAMENTO_OUTCOME_CODE__GOTO_MDPNEW = //NOSONAR  Reason:EIAS
				"GOTO_MDPNEW"; //NOSONAR  Reason:EIAS
		final String PREPARAPAGAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1767741522) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DatiCertificatore cert = theModel.getAppDatacertificatore();

				DatiPagamentoNew pagamento = theModel.getAppDatadatiPagamentoNew();

				if (log.isDebugEnabled())
					GenericUtil.stampa(pagamento, true, 3);

				getValidationMgr().validazioneFormalePagamentoNew(pagamento);

				/*
				boolean check = true;
				
				if (BaseMgr.isNullOrEmpty(pagamento.getImporto())
					|| !(pagamento.getImporto() > 0)) {
				result.getFldErrors().put("appDatadatiPagamentoNew.importo",
						"e' obbligatorio");
				
				check = false;
				}
				
				if (BaseMgr.isNullOrEmpty(pagamento.getTipoPersona())) {
				result.getFldErrors().put(
						"appDatadatiPagamentoNew.tipoPersona",
						"e' obbligatorio");
				
				check = false;
				}
				
				if (BaseMgr.isNullOrEmpty(pagamento.getCodiceFiscale())) {
				result.getFldErrors().put(
						"appDatadatiPagamentoNew.codiceFiscale",
						"e' obbligatorio");
				
				check = false;
				}
				
				if (BaseMgr.isNullOrEmpty(pagamento.getAnagraficaVersante())) {
				result.getFldErrors().put(
						"appDatadatiPagamentoNew.anagraficaVersante",
						"e' obbligatorio");
				
				check = false;
				}
				
				
				if (check) {
				 */
				// Recupero il numero transazione
				String numTrans = getTransazioneCreditoMgr().getMdpNewNumTransazione();

				pagamento.setIdTransMdp(numTrans);

				theModel.setAppDatanumeroTransazione(numTrans);

				// Non si usa più questa chiamata
				// Inserisco la transazione e recupero l'url WISP
				//				String urlWisp = getTransazioneCreditoMgr().getMdpNewUrlWisp(
				//						pagamento, cert.getIdCertificatore());

				String urlWisp = null;
				try {
					urlWisp = getTransazioneCreditoMgr().getMdpNewUrlPagamento(cert, pagamento);
				} catch (BEException bE) {
					// Messaggio richiesto da Etzi (da parte di Agid)
					result.getGlobalErrors().add(Messages.ERROR_MDP);

					result.setResultCode(PREPARAPAGAMENTO_OUTCOME_CODE__KO);

				}

				if (urlWisp != null) {
					theModel.setAppDatamdpNewURL(urlWisp);

					// impostazione del result code 
					result.setResultCode(PREPARAPAGAMENTO_OUTCOME_CODE__GOTO_MDPNEW);
					//			} else {
					//				// impostazione del result code 
					//				result.setResultCode(PREPARAPAGAMENTO_OUTCOME_CODE__KO);
					//			}
				}
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaPagamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-40797590) ENABLED START*/
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
