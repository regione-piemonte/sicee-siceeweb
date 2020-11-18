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

/*PROTECTED REGION ID(R2044175346) ENABLED START*/
import it.csi.iride2.policy.entity.*;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneRegistrazMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneAceMgr;
/*PROTECTED REGION END*/

public class CPBECpPagamento {

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

	// ApplicationData: [datiPagamento, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTO_CODE = "appDatadatiPagamento";

	// ApplicationData: [switchPagamento, scope:USER_SESSION]
	public static final String APPDATA_SWITCHPAGAMENTO_CODE = "appDataswitchPagamento";

	// ApplicationData: [gestoriPagamento, scope:USER_SESSION]
	public static final String APPDATA_GESTORIPAGAMENTO_CODE = "appDatagestoriPagamento";

	// ApplicationData: [idGestorePagamento, scope:USER_ACTION]
	public static final String APPDATA_IDGESTOREPAGAMENTO_CODE = "appDataidGestorePagamento";

	// ApplicationData: [transazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONE_CODE = "appDatatransazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpPagamento";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaPagamentoRegistrazione definito in un ExecCommand del
	 * ContentPanel cpPagamento
	 */
	public ExecResults preparaPagamentoRegistrazione(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__GOTO_MDP = //NOSONAR  Reason:EIAS
				"GOTO_MDP"; //NOSONAR  Reason:EIAS
		final String PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__GOTO_OK = //NOSONAR  Reason:EIAS
				"GOTO_OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2051994016) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiPagamento dpag = theModel.getAppDatadatiPagamento();
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			String gestorePagamento = theModel.getAppDataidGestorePagamento();

			if (log.isDebugEnabled()) {
				log.debug("Modalità Pagamento: " + dpag.getModPagamento());
				log.debug("Quantita: " + dpag.getQuantita());
				log.debug("idCertificatore: " + cert.getIdCertificatore());
			}

			if (dpag.getModPagamento() != null || dpag.getModPagamento().length() > 0) {
				// scegli se pagamento con CC o BB
				if ("BB".equals(dpag.getModPagamento())) {
					// pagamento con bonifico
					log.debug("Richiamo Bonifico");
					boolean check = true;
					if (BaseMgr.isNullOrEmpty(dpag.getEseguitoDaCognome())) {
						result.getFldErrors().put("appDatadatiPagamento.eseguitoDaCognome", "e' obbligatorio");
						check = false;
					}
					if (BaseMgr.isNullOrEmpty(dpag.getEseguitoDaNome())) {
						result.getFldErrors().put("appDatadatiPagamento.eseguitoDaNome", "e' obbligatorio");
						check = false;
					}
					if (BaseMgr.isNullOrEmpty(dpag.getCro())) {
						result.getFldErrors().put("appDatadatiPagamento.cro", "e' obbligatorio");
						check = false;
					}
					if (BaseMgr.isNullOrEmpty(dpag.getDataValuta())) {
						result.getFldErrors().put("appDatadatiPagamento.dataValuta", "e' obbligatorio");
						check = false;
					}
					//					} else {
					//						if (!getMiscMgr().checkValideDate(dpag.getDataValuta())) {
					//							result.getFldErrors()
					//									.put("appDatadatiPagamento.dataValuta",
					//											"Il formato e' errato. Il formato deve essere GG/MM/YYYY");
					//							check = false;
					//						}
					//					}
					if (check) {
						if (dpag.getTipo().equals("ACE")) {
							getTransazioneAceMgr().aggiornaStatoTransazione(dpag.getIdTransazione(),
									Constants.TRANSAZIONE_STARTED);
						} else {
							getTransazioneRegistrazMgr().aggiornaStatoTransazione(dpag.getIdTransazione(),
									Constants.TRANSAZIONE_STARTED);
						}
						theModel.setAppDatadatiPagamento(dpag);
						result.setResultCode(PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__GOTO_OK);
					} else {
						result.setResultCode(PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__KO);
					}
				} else {

					if (gestorePagamento != null && gestorePagamento.length() > 0) {

						// pagamento con carta/mdp
						log.debug("Richiamo MDP");
						String mdpUrl = getSOAIntegrationMgr().acquistaArticolo(dpag.getImporto(), dpag.getCausale(),
								DateUtil.convertToString(dpag.getDataValuta()), theModel.getAppDatacertificatore(),
								theModel);

						dpag.setIdTransazioneMDP(theModel.getAppDatatransazione().getTransactionId());
						dpag.setStatoTransazione(Constants.TRANSAZIONE_STARTED);

						/*String idTransazionePEAS = soaIntegrationMgr
								.acquistaArticolo(dpag.getImporto(), dpag
										.getCausale(), BaseMgr.convertToString(dpag
										.getDataValuta()), theModel
										.getAppDatacertificatore());
						
						dpag.setIdTransazioneMDP(idTransazionePEAS);
						 */
						if (dpag.getTipo().equals("ACE")) {
							getTransazioneAceMgr().aggiornaStatoTransazione(dpag.getIdTransazione(),
									Constants.TRANSAZIONE_STARTED);
						} else {
							getTransazioneRegistrazMgr().aggiornaStatoTransazione(dpag.getIdTransazione(),
									Constants.TRANSAZIONE_STARTED);
						}
						theModel.setAppDatadatiPagamento(dpag);
						/*
						 String idApp = Constants.MDP_ID_APP;
						 String mdpUrl = Constants.MDP_URL + "?id="
						 + idTransazionePEAS + "&app=" + idApp;*/
						/*String mdpUrl = Constants.MDP_URL + "&appId=" + idApp
								+ "&transactionId=" + idTransazionePEAS;*/
						log.debug("MDP url: " + mdpUrl);
						theModel.setAppDatamdpURL(mdpUrl);
						// impostazione del result code (a seconda dell'esito del PEAS)
						result.setResultCode(PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__GOTO_MDP);
					} else {
						result.getFldErrors().put("appDataidGestorePagamento",
								"e' necessario specificare un gestore di pagamento");
						result.setResultCode(PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__KO);
					}
				}
			} else {
				// modo pagamento non selezionato
				result.getFldErrors().put("appDatadatiPagamento.modPagamento",
						"e' necessario specificare una modalita' di pagamento");
				result.setResultCode(PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaPagamentoRegistrazione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaTipiPagamentoPossibili definito in un ExecCommand del
	 * ContentPanel cpPagamento
	 */
	public ExecResults abilitaTipiPagamentoPossibili(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITATIPIPAGAMENTOPOSSIBILI_OUTCOME_CODE__CC_ONLY = //NOSONAR  Reason:EIAS
				"CC_ONLY"; //NOSONAR  Reason:EIAS
		final String ABILITATIPIPAGAMENTOPOSSIBILI_OUTCOME_CODE__BB_ONLY = //NOSONAR  Reason:EIAS
				"BB_ONLY"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-447978617) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String tipiAmmessi = getMiscMgr().getModPagamentoAbilitati();
			log.debug("#####STAMPO I TIPI AMMESSI: " + tipiAmmessi);

			// impostazione del result code
			if (tipiAmmessi.contains(Constants.PAGAMENTO_CC)) {

				result.setResultCode(ABILITATIPIPAGAMENTOPOSSIBILI_OUTCOME_CODE__CC_ONLY);
			} else if (tipiAmmessi.contains(Constants.PAGAMENTO_BB)) {

				result.setResultCode(ABILITATIPIPAGAMENTOPOSSIBILI_OUTCOME_CODE__BB_ONLY);
			} else
				throw new IllegalArgumentException("Nessuna tipologia di pagamento abilitata");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			theModel.getAppDatadatiPagamento().setModPagamento(tipiAmmessi);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaTipiPagamentoPossibili] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo chiamaServizioPagamento definito in un ExecCommand del
	 * ContentPanel cpPagamento
	 */
	public ExecResults chiamaServizioPagamento(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIAMASERVIZIOPAGAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1940942727) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiPagamento dpag = theModel.getAppDatadatiPagamento();
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			String tipiAmmessi = getMiscMgr().getModPagamentoAbilitati();
			// impostazione del result code
			if (tipiAmmessi.contains(Constants.PAGAMENTO_CC)) {
				theModel.getAppDatadatiPagamento().setModPagamento(tipiAmmessi);
				getSOAIntegrationMgr().getModalitaPagamento(theModel);

				dpag.setIdTransazioneMDP(theModel.getAppDatatransazione().getTransactionId());
				dpag.setStatoTransazione(BaseMgr.convertToString(theModel.getAppDatatransazione().getCodStato()));

				if (dpag.getTipo().equals("ACE")) {
					dpag.setIdTransazione(getTransazioneAceMgr().iniziaTransazione(dpag, cert));
				} else {
					dpag.setIdTransazione(getTransazioneRegistrazMgr().iniziaTransazione(dpag, cert));
				}

				result.setResultCode(CHIAMASERVIZIOPAGAMENTO_OUTCOME_CODE__OK);
			} else
				throw new IllegalArgumentException("Nessuna tipologia di pagamento abilitata");
			// impostazione del result code 
			result.setResultCode(CHIAMASERVIZIOPAGAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::chiamaServizioPagamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2004770436) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private TransazioneAceMgr transazioneAceMgr;

	public TransazioneAceMgr getTransazioneAceMgr() {
		return transazioneAceMgr;
	}

	public void setTransazioneAceMgr(TransazioneAceMgr transazioneAceMgr) {
		this.transazioneAceMgr = transazioneAceMgr;
	}

	public TransazioneRegistrazMgr getTransazioneRegistrazMgr() {
		return transazioneRegistrazMgr;
	}

	public void setTransazioneRegistrazMgr(TransazioneRegistrazMgr transazioneRegistrazMgr) {
		this.transazioneRegistrazMgr = transazioneRegistrazMgr;
	}

	private TransazioneRegistrazMgr transazioneRegistrazMgr;

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
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
