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

/*PROTECTED REGION ID(R204590175) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;

/*PROTECTED REGION END*/

public class CPBECpRiepilogoAceAnnullaSost {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [codiceCertificatoDaSostituireSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICECERTIFICATODASOSTITUIRESELEZIONATO_CODE = "appDatacodiceCertificatoDaSostituireSelezionato";

	// ApplicationData: [codiceCertificatoSostitutivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICECERTIFICATOSOSTITUTIVOSELEZIONATO_CODE = "appDatacodiceCertificatoSostitutivoSelezionato";

	// ApplicationData: [isPrimoIngresso, scope:USER_SESSION]
	public static final String APPDATA_ISPRIMOINGRESSO_CODE = "appDataisPrimoIngresso";

	// ApplicationData: [carrelloAceOld, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACEOLD_CODE = "appDatacarrelloAceOld";

	// ApplicationData: [carrelloAceNew, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACENEW_CODE = "appDatacarrelloAceNew";

	// ApplicationData: [datiAnnullamento, scope:USER_SESSION]
	public static final String APPDATA_DATIANNULLAMENTO_CODE = "appDatadatiAnnullamento";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRiepilogoAceAnnullaSost";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaOldDalCarrello definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults eliminaOldDalCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAOLDDALCARRELLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINAOLDDALCARRELLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1607040805) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Ace> carrelloOld = theModel.getAppDatacarrelloAceOld();

			String idCerificato = theModel.getAppDatacodiceCertificatoDaSostituireSelezionato();

			if (!GenericUtil.isNullOrEmpty(idCerificato)) {
				for (int i = 0; i < carrelloOld.size(); i++) {
					if (idCerificato.equals(carrelloOld.get(i).getCodice())) {
						carrelloOld.remove(i);
						break;
					}
				}

				result.getGlobalMessages().add("Certificato eliminato correttamente.");

				result.setResultCode(ELIMINAOLDDALCARRELLO_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Attenzione. Nessun certificato selezionato.");

				result.setResultCode(ELIMINAOLDDALCARRELLO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaOldDalCarrello] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisBotEliminaOld definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciVisBotEliminaOld(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_OLD_VIS"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_NON_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_OLD_NON_VIS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-250818256) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Ace> carrelloOld = theModel.getAppDatacarrelloAceOld();

			if (carrelloOld != null && !carrelloOld.isEmpty()) {
				result.setResultCode(GESTISCIVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_VIS);
			} else {
				result.setResultCode(GESTISCIVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_NON_VIS);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisBotEliminaOld] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaNewDalCarrello definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults eliminaNewDalCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINANEWDALCARRELLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINANEWDALCARRELLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1865050708) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Ace> carrelloNew = theModel.getAppDatacarrelloAceNew();

			String idCerificato = theModel.getAppDatacodiceCertificatoSostitutivoSelezionato();

			if (!GenericUtil.isNullOrEmpty(idCerificato)) {
				for (int i = 0; i < carrelloNew.size(); i++) {
					if (idCerificato.equals(carrelloNew.get(i).getCodice())) {
						carrelloNew.remove(i);
						break;
					}
				}

				result.getGlobalMessages().add("Certificato eliminato correttamente.");

				result.setResultCode(ELIMINANEWDALCARRELLO_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Attenzione. Nessun certificato selezionato.");

				result.setResultCode(ELIMINANEWDALCARRELLO_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaNewDalCarrello] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisBotEliminaNew definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciVisBotEliminaNew(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_NEW_VIS"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_NON_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_NEW_NON_VIS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R927734103) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Ace> carrelloNew = theModel.getAppDatacarrelloAceNew();

			if (carrelloNew != null && !carrelloNew.isEmpty()) {
				result.setResultCode(GESTISCIVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_VIS);
			} else {
				result.setResultCode(GESTISCIVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_NON_VIS);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisBotEliminaNew] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciIndietro(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__RICERCA_ACE = //NOSONAR  Reason:EIAS
				"RICERCA_ACE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__SELEZIONA_TIPO_RICERCA = //NOSONAR  Reason:EIAS
				"SELEZIONA_TIPO_RICERCA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2130908311) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaProvenienza = theModel.getAppDatapaginaProvenienza();

			if (paginaProvenienza != null && paginaProvenienza.equals(Constants.PAGINA_SELEZIONE_TIPO_RICERCA)) {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__SELEZIONA_TIPO_RICERCA);
			} else {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__RICERCA_ACE);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIndietro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo sostituisciCertificati definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults sostituisciCertificati(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SOSTITUISCICERTIFICATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SOSTITUISCICERTIFICATI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R242280510) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Ace> carrelloOld = theModel.getAppDatacarrelloAceOld();

			ArrayList<Ace> carrelloNew = theModel.getAppDatacarrelloAceNew();

			DtAnnullamento datiAnnullamento = theModel.getAppDatadatiAnnullamento();

			int countOld = carrelloOld != null ? carrelloOld.size() : 0;
			int countNew = carrelloNew != null ? carrelloNew.size() : 0;

			if (getMiscMgr().checkCoerenzaSostituzione(datiAnnullamento.getIdMotivo(), countOld, countNew)) {

				if (checkDuplicati(carrelloOld, carrelloNew)) {

					DatiCertificatore certificatore = theModel.getAppDatacertificatore();

					getCertificatoMgr().sostituisciCertificati(certificatore, carrelloOld, carrelloNew,
							datiAnnullamento);

					getCertificatoMgr().invioMailSostituzioneCertificati(certificatore, carrelloOld, carrelloNew);

					result.getGlobalMessages().add("A.P.E. sostituiti correttamente.");

					result.setResultCode(SOSTITUISCICERTIFICATI_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Attenzione. Ci sono degli A.P.E. che vengono ripetuti.");

					result.setResultCode(SOSTITUISCICERTIFICATI_OUTCOME_CODE__KO);
				}

			} else {
				result.getGlobalErrors().add(
						"Attenzione. Il numero degli A.P.E. non e' coerente con la motivazione della sostituzione.");

				result.setResultCode(SOSTITUISCICERTIFICATI_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::sostituisciCertificati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRiepilogoCarrelloPrimoIngresso definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciRiepilogoCarrelloPrimoIngresso(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRIEPILOGOCARRELLOPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_SI = //NOSONAR  Reason:EIAS
				"PRIMO_INGRESSO_SI"; //NOSONAR  Reason:EIAS
		final String GESTISCIRIEPILOGOCARRELLOPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_NO = //NOSONAR  Reason:EIAS
				"PRIMO_INGRESSO_NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1387402372) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataisPrimoIngresso()) {

				DtAnnullamento annullamento = theModel.getAppDatadatiAnnullamento();

				MotivoAnnullamento motivo = getMiscMgr().getMotivoAnnullamentoById(annullamento.getIdMotivo());

				annullamento.setDescMotivo(motivo.getDescr());
				annullamento.setData(GenericUtil.getDataOdierna());
				if (annullamento.getFlgRicercaPregresso()) {
					annullamento.setDescFlgRicercaPregresso(Constants.LABEL_SI);
				} else {
					annullamento.setDescFlgRicercaPregresso(Constants.LABEL_NO);
				}

				theModel.setAppDatadatiAnnullamento(annullamento);

				theModel.setAppDataisPrimoIngresso(false);
				result.setResultCode(GESTISCIRIEPILOGOCARRELLOPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_SI);
			} else {
				result.setResultCode(GESTISCIRIEPILOGOCARRELLOPRIMOINGRESSO_OUTCOME_CODE__PRIMO_INGRESSO_NO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciRiepilogoCarrelloPrimoIngresso] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIngressoVisBotEliminaOld definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciIngressoVisBotEliminaOld(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINGRESSOVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_OLD_VIS"; //NOSONAR  Reason:EIAS
		final String GESTISCIINGRESSOVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_NON_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_OLD_NON_VIS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1422845942) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatacarrelloAceOld() != null && !theModel.getAppDatacarrelloAceOld().isEmpty()) {
				result.setResultCode(GESTISCIINGRESSOVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_VIS);
			} else {
				result.setResultCode(GESTISCIINGRESSOVISBOTELIMINAOLD_OUTCOME_CODE__BOTTONE_OLD_NON_VIS);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciIngressoVisBotEliminaOld] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIngressoVisBotEliminaNew definito in un ExecCommand del
	 * ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciIngressoVisBotEliminaNew(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINGRESSOVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_NEW_VIS"; //NOSONAR  Reason:EIAS
		final String GESTISCIINGRESSOVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_NON_VIS = //NOSONAR  Reason:EIAS
				"BOTTONE_NEW_NON_VIS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1693568995) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatacarrelloAceNew() != null && !theModel.getAppDatacarrelloAceNew().isEmpty()) {
				result.setResultCode(GESTISCIINGRESSOVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_VIS);
			} else {
				result.setResultCode(GESTISCIINGRESSOVISBOTELIMINANEW_OUTCOME_CODE__BOTTONE_NEW_NON_VIS);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciIngressoVisBotEliminaNew] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblCarrelloAceOld
	 */
	public static void resetClearStatus_widg_tblCarrelloAceOld(java.util.Map session) {
		session.put("cpRiepilogoAceAnnullaSost_tblCarrelloAceOld_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblCarrelloAceNew
	 */
	public static void resetClearStatus_widg_tblCarrelloAceNew(java.util.Map session) {
		session.put("cpRiepilogoAceAnnullaSost_tblCarrelloAceNew_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-13223121) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private boolean checkDuplicati(ArrayList<Ace> carrelloOld, ArrayList<Ace> carrelloNew) {
		boolean checkDuplicati = true;

		for (int i = 0; i < carrelloOld.size(); i++) {
			String numCert = carrelloOld.get(i).getCodice();

			for (int j = 0; j < carrelloNew.size(); j++) {

				if (numCert.equals(carrelloNew.get(j).getCodice())) {
					checkDuplicati = false;
				}
			}
		}

		return checkDuplicati;
	}
	/*PROTECTED REGION END*/
}
