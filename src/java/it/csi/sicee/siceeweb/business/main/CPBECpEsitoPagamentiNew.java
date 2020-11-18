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

/*PROTECTED REGION ID(R-1467537310) ENABLED START*/
import javax.servlet.http.HttpServletRequest;

import it.csi.sicee.siceeweb.business.facade.TransazioneCreditoMgr;

/*PROTECTED REGION END*/

public class CPBECpEsitoPagamentiNew {

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

	// ApplicationData: [msgPagamento, scope:SAME_PAGE]
	public static final String APPDATA_MSGPAGAMENTO_CODE = "appDatamsgPagamento";

	// ApplicationData: [numeroTransazione, scope:USER_SESSION]
	public static final String APPDATA_NUMEROTRANSAZIONE_CODE = "appDatanumeroTransazione";

	// ApplicationData: [datiPagamentoNew, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTONEW_CODE = "appDatadatiPagamentoNew";

	// ApplicationData: [mdpNewURL, scope:USER_SESSION]
	public static final String APPDATA_MDPNEWURL_CODE = "appDatamdpNewURL";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpEsitoPagamentiNew";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoWISPOK definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoWISPOK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOWISPOK_OUTCOME_CODE__GOTO_MDPNEW = //NOSONAR  Reason:EIAS
				"GOTO_MDPNEW"; //NOSONAR  Reason:EIAS
		final String RECEPISCIPAGAMENTOWISPOK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2039539123) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiPagamentoNew datiPagamento = theModel.getAppDatadatiPagamentoNew();

				String urlPagamento = getTransazioneCreditoMgr().getMdpNewUrlPagamento(cert, datiPagamento);

				theModel.setAppDatamdpNewURL(urlPagamento);

				// impostazione del result code 
				result.setResultCode(RECEPISCIPAGAMENTOWISPOK_OUTCOME_CODE__GOTO_MDPNEW);
			} catch (Exception ex) {
				// impostazione del result code 
				result.setResultCode(RECEPISCIPAGAMENTOWISPOK_OUTCOME_CODE__KO);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoWISPOK] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoWISPKO definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoWISPKO(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOWISPKO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1395958997) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			log.debug("\n\n##########################################");
			
			log.debug("Stampo la request: "+getServletRequest());
			
			if (getServletRequest() != null)
			{
				log.debug("STAMPO l'tranId parameter: "
						+ getServletRequest().getParameter("tranId"));
				log.debug("STAMPO l'tranId attribute: "
						+ getServletRequest().getAttribute("tranId"));
			}
			log.debug("##########################################\n\n");
			 */
			String numTransazione = theModel.getAppDatanumeroTransazione();

			log.debug("Stampo il numTransazione: " + numTransazione);

			getTransazioneCreditoMgr().aggiornaStatoTransazioneNew(numTransazione,
					Constants.ID_STATO_TRANS_2018_ANNULLATO);

			// impostazione del result code 
			result.setResultCode(RECEPISCIPAGAMENTOWISPKO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoWISPKO] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoOK definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoOK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOOK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1359275454) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String numTransazione = theModel.getAppDatanumeroTransazione();
			getTransazioneCreditoMgr().aggiornaStatoTransazioneNew(numTransazione,
					Constants.ID_STATO_TRANS_2018_ATTESA_RT);

			// impostazione del result code 
			result.setResultCode(RECEPISCIPAGAMENTOOK_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoOK] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoKO definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoKO(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOKO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-499806278) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String numTransazione = theModel.getAppDatanumeroTransazione();
			getTransazioneCreditoMgr().aggiornaStatoTransazioneNew(numTransazione,
					Constants.ID_STATO_TRANS_2018_FALLITO);

			// impostazione del result code 
			result.setResultCode(RECEPISCIPAGAMENTOKO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoKO] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoBACK definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoBACK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOBACK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1397991831) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String numTransazione = theModel.getAppDatanumeroTransazione();
			getTransazioneCreditoMgr().aggiornaStatoTransazioneNew(numTransazione,
					Constants.ID_STATO_TRANS_2018_ANNULLATO);

			// impostazione del result code 
			result.setResultCode(RECEPISCIPAGAMENTOBACK_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoBACK] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R225896972) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	/*
	private HttpServletRequest request;
	
	public HttpServletRequest getServletRequest() {
		return request;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	 */
	private TransazioneCreditoMgr transazioneCreditoMgr = null;

	public TransazioneCreditoMgr getTransazioneCreditoMgr() {
		return transazioneCreditoMgr;
	}

	public void setTransazioneCreditoMgr(TransazioneCreditoMgr transazioneCreditoMgr) {
		this.transazioneCreditoMgr = transazioneCreditoMgr;
	}

	/*PROTECTED REGION END*/
}
