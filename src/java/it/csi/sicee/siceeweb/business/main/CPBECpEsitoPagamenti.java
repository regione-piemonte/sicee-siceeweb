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

/*PROTECTED REGION ID(R-1905658662) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.*;
import it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel;
/*PROTECTED REGION END*/

public class CPBECpEsitoPagamenti {

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

	// ApplicationData: [mdpURL, scope:USER_SESSION]
	public static final String APPDATA_MDPURL_CODE = "appDatamdpURL";

	// ApplicationData: [switchPagamento, scope:USER_SESSION]
	public static final String APPDATA_SWITCHPAGAMENTO_CODE = "appDataswitchPagamento";

	// ApplicationData: [datiPagamento, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTO_CODE = "appDatadatiPagamento";

	// ApplicationData: [msgPagamento, scope:SAME_PAGE]
	public static final String APPDATA_MSGPAGAMENTO_CODE = "appDatamsgPagamento";

	// ApplicationData: [idTransazione, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONE_CODE = "appDataidTransazione";

	// ApplicationData: [numeroTransazione, scope:USER_SESSION]
	public static final String APPDATA_NUMEROTRANSAZIONE_CODE = "appDatanumeroTransazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpEsitoPagamenti";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoOK definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamenti
	 */
	public ExecResults recepisciPagamentoOK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOOK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1955154634) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//			System.out.println("\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			//			System.out.println("Stampo theModel.getIdTransazione(): "
			//					+ theModel.getAppDatatranId());
			//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");

			log.debug("########## FUNZIONA ##########");

			//String cosaHoPagato = theModel.getAppDataswitchPagamento();
			String cosaHoPagato = theModel.getAppDataswitchPagamento();
			if (Constants.PAGAMENTO_REGISTRAZIONE.equals(cosaHoPagato)) {

				// gestione dell'esito in caso di pagamento della registrazione
				completaRegistrazione(theModel);

				DatiCertificatore cert = theModel.getAppDatacertificatore();

				cert.setFlgAggDati(true);

				getCertificatoreMgr().aggiornaCertificatoreFlgDati(cert.getIdCertificatore());

				//				theModel.setAppDatamsgPagamento(MSG_OK_REGISTRAZ
				//						+ "\""
				//						+ theModel.getAppDatacertificatore()
				//								.getNumCertificatore() + "\"");

				theModel.setAppDatacertificatore(cert);

				if (cert.getFlgCompetenzeNaz()) {
					theModel.setAppDatamsgPagamento(
							Constants.MSG_OK_REGISTRAZ_NAZ + "\"" + cert.getNumCertificatore() + "\"");
				} else {
					theModel.setAppDatamsgPagamento(
							Constants.MSG_OK_REGISTRAZ_REG + "\"" + cert.getNumCertificatore() + "\"");
				}

			} else if (Constants.PAGAMENTO_ACE.equals(cosaHoPagato)) {

				//				System.out
				//						.println("\n\n##########################################");
				//				System.out.println("STAMPO l'tranId parameter: "
				//						+ getServletRequest().getParameter("tranId"));
				//				System.out.println("STAMPO l'tranId attribute: "
				//						+ getServletRequest().getAttribute("tranId"));
				//				System.out
				//						.println("##########################################\n\n");

				// gestione dell'esito in caso di pagamento ACE

				completaAcquistoACE(theModel);

				theModel.setAppDatamsgPagamento(MSG_OK_ACE);
			} else
				throw new IllegalArgumentException(
						"Errore interno: l'oggetto di pagamento " + cosaHoPagato + " non è valido");

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
	 * ContentPanel cpEsitoPagamenti
	 */
	public ExecResults recepisciPagamentoKO(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOKO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1480343486) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String cosaHoPagato = theModel.getAppDataswitchPagamento();
			if (Constants.PAGAMENTO_REGISTRAZIONE.equals(cosaHoPagato)) {

				// gestione dell'esito in caso di pagamento della registrazione
				marcaKORegistrazione(theModel);

				result.setResultCode(RECEPISCIPAGAMENTOKO_OUTCOME_CODE__OK);
			} else if (Constants.PAGAMENTO_ACE.equals(cosaHoPagato)) {

				// gestione dell'esito in caso di pagamento ACE
				marcaKOAcquistoACE(theModel);

				result.setResultCode(RECEPISCIPAGAMENTOKO_OUTCOME_CODE__OK);
			} else
				throw new IllegalArgumentException(
						"Errore interno: l'oggetto di pagamento " + cosaHoPagato + " non è valido");

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
	 * Implementazione del metodo recepisciPagamentoABORT definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamenti
	 */
	public ExecResults recepisciPagamentoABORT(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOABORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1296766174) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String cosaHoPagato = theModel.getAppDataswitchPagamento();
			if (Constants.PAGAMENTO_REGISTRAZIONE.equals(cosaHoPagato)) {

				// gestione dell'esito in caso di pagamento della registrazione
				abortisciRegistrazione(theModel);

			} else if (Constants.PAGAMENTO_ACE.equals(cosaHoPagato)) {

				// gestione dell'esito in caso di pagamento ACE
				abortisciAcquistoACE(theModel);

			} else
				throw new IllegalArgumentException(
						"Errore interno: l'oggetto di pagamento " + cosaHoPagato + " non è valido");

			// impostazione del result code
			result.setResultCode(RECEPISCIPAGAMENTOABORT_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoABORT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo switchOggettoPagato definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamenti
	 */
	public ExecResults switchOggettoPagato(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHOGGETTOPAGATO_OUTCOME_CODE__PAGATO_REGISTRAZ = //NOSONAR  Reason:EIAS
				"PAGATO_REGISTRAZ"; //NOSONAR  Reason:EIAS
		final String SWITCHOGGETTOPAGATO_OUTCOME_CODE__PAGATO_ACE = //NOSONAR  Reason:EIAS
				"PAGATO_ACE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1505547116) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//System.out.println(theModel.geta);
			if (log.isDebugEnabled()) {
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("###### switchOggettoPagato");
				log.debug(
						"###### Stampo theModel.getAppDataswitchPagamento(): " + theModel.getAppDataswitchPagamento());
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}

			// Prima verifica questo paramentro
			//theModel.getAppDataswitchPagamento();
			if (Constants.PAGAMENTO_REGISTRAZIONE.equals(theModel.getAppDataswitchPagamento()))
				result.setResultCode(SWITCHOGGETTOPAGATO_OUTCOME_CODE__PAGATO_REGISTRAZ);
			else if (Constants.PAGAMENTO_ACE.equals(theModel.getAppDataswitchPagamento()))
				result.setResultCode(SWITCHOGGETTOPAGATO_OUTCOME_CODE__PAGATO_ACE);
			else
				throw new IllegalArgumentException(
						"errore interno: oggetto di pagamento non previsto " + theModel.getAppDataswitchPagamento());
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchOggettoPagato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1777261286) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private TransazioneRegistrazMgr transazioneRegistrazMgr;

	public TransazioneRegistrazMgr getTransazioneRegistrazMgr() {
		return transazioneRegistrazMgr;
	}

	public void setTransazioneRegistrazMgr(TransazioneRegistrazMgr transazioneRegistrazMgr) {
		this.transazioneRegistrazMgr = transazioneRegistrazMgr;
	}

	private TransazioneAceMgr transazioneAceMgr;

	public TransazioneAceMgr getTransazioneAceMgr() {
		return transazioneAceMgr;
	}

	public void setTransazioneAceMgr(TransazioneAceMgr transazioneAceMgr) {
		this.transazioneAceMgr = transazioneAceMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/**
	 * completa la registrazioen del certificatore, marcandolo come verificato e
	 * attribuendo il numero matricola
	 * @param theModel
	 * @throws BEException
	 */
	public void completaRegistrazione(CpEsitoPagamentiModel theModel) throws BEException {
		DatiCertificatore cert = theModel.getAppDatacertificatore();

		//DatiPagamento dp = theModel.getAppDatadatiPagamento();
		Long idTransazione = theModel.getAppDataidTransazione();
		getTransazioneRegistrazMgr().aggiornaStatoTransazione(idTransazione);

		Long idTrans = getCertificatoreMgr().completaRegistrazione(idTransazione, cert);
		theModel.setAppDataidTransazione(idTrans);
	}

	public void completaAcquistoACE(CpEsitoPagamentiModel theModel) throws BEException {
		//DatiPagamento dp = theModel.getAppDatadatiPagamento();
		Long idTransazione = theModel.getAppDataidTransazione();

		DatiCertificatore cert = theModel.getAppDatacertificatore();
		//getTransazioneAceMgr().aggiornaStatoTransazione(idTransazione);

		getCertificatoMgr().completaAcquistoACE(idTransazione, cert);
		//theModel.setAppDataidTransazione(idTrans);
	}

	public void marcaKORegistrazione(CpEsitoPagamentiModel theModel) throws BEException {
		getTransazioneRegistrazMgr().annullaTransazione(theModel.getAppDataidTransazione());
	}

	public void marcaKOAcquistoACE(CpEsitoPagamentiModel theModel) throws BEException {
		getTransazioneAceMgr().annullaTransazione(theModel.getAppDataidTransazione());
	}

	public void abortisciRegistrazione(CpEsitoPagamentiModel theModel) throws BEException {
		getTransazioneRegistrazMgr().abortisciTransazione(theModel.getAppDataidTransazione());
	}

	public void abortisciAcquistoACE(CpEsitoPagamentiModel theModel) throws BEException {
		getTransazioneAceMgr().abortisciTransazione(theModel.getAppDataidTransazione());
	}

	////////
	/// messaggi esito OK
	//private static final String MSG_OK_REGISTRAZ = "La registrazione all'elenco regionale e' avvenuta con successo. Il suo N. di iscrizione e' il seguente: ";
	private static final String MSG_OK_ACE = "La prenotazione di attestati di prestazione energetica e' avvenuto con successo. E' possibile stampare la ricevuta di acquisto cliccando il pulsante \"stampa ricevuta\". ";
	//////

	/*
	private HttpServletRequest request;
	
	public HttpServletRequest getServletRequest() {
		return request;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	 */

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	/*PROTECTED REGION END*/
}
