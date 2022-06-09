package it.csi.sicee.siceeweb.business.gestattestati;

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

/*PROTECTED REGION ID(R-680752879) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpRisultatoRicercaAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [certificatiInviati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATIINVIATI_CODE = "appDatacertificatiInviati";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [cerificatore, scope:USER_SESSION]
	public static final String APPDATA_CERIFICATORE_CODE = "appDatacerificatore";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [parametroDiRequest, scope:USER_ACTION]
	public static final String APPDATA_PARAMETRODIREQUEST_CODE = "appDataparametroDiRequest";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [tempDtCatastaliSecondari, scope:USER_SESSION]
	public static final String APPDATA_TEMPDTCATASTALISECONDARI_CODE = "appDatatempDtCatastaliSecondari";

	// ApplicationData: [tempRaccomandazioni, scope:USER_SESSION]
	public static final String APPDATA_TEMPRACCOMANDAZIONI_CODE = "appDatatempRaccomandazioni";

	// ApplicationData: [tempDichiarazSelez, scope:USER_SESSION]
	public static final String APPDATA_TEMPDICHIARAZSELEZ_CODE = "appDatatempDichiarazSelez";

	// ApplicationData: [certificatiSostituiti, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATISOSTITUITI_CODE = "appDatacertificatiSostituiti";

	// ApplicationData: [idRigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDRIGASELEZIONATA_CODE = "appDataidRigaSelezionata";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [listTipiDoc, scope:USER_SESSION]
	public static final String APPDATA_LISTTIPIDOC_CODE = "appDatalistTipiDoc";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	// ApplicationData: [uidDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_UIDDOCUMENTOSELEZIONATO_CODE = "appDatauidDocumentoSelezionato";

	// ApplicationData: [documentoAggiuntivo, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTOAGGIUNTIVO_CODE = "appDatadocumentoAggiuntivo";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoRicercaAce";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaScaricoModulo definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO = //NOSONAR  Reason:EIAS
				"ATTESTATO"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA = //NOSONAR  Reason:EIAS
				"RICEVUTA"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__INDICATORE = //NOSONAR  Reason:EIAS
				"INDICATORE"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ANNULATO = //NOSONAR  Reason:EIAS
				"ANNULATO"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2017051427) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String numeroAttestato = theModel.getIdRiga();
			int stato = getCertificatoMgr().getStatoCertificato(numeroAttestato);

			if (GenericUtil.isNullOrEmpty(numeroAttestato)
					|| !GenericUtil.isCertificatoPresente(numeroAttestato, theModel.getAppDatacertificatiInviati())) {

				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__KO);

			} else {
				theModel.setAppDatacodAttestatoDaStampare(numeroAttestato);
				// impostazione del result code
				if (theModel.getIdColonna().equals("flgInviato") || theModel.getIdColonna().equals("linkDownload")) {
					if (stato != Constants.ANNULLATO && stato != Constants.ANNULLATO_BO) {
						result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO);
					} else {
						result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ANNULATO);
					}
				} else if (theModel.getIdColonna().equals("flgRicevuta")) {
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA);
				} else if (theModel.getIdColonna().equals("linkDownloadInd")) {
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__INDICATORE);
				}
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo vediACESostituiti definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults vediACESostituiti(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VEDIACESOSTITUITI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VEDIACESOSTITUITI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-910327218) ENABLED START*/
			//String numeroCertificato = theModel.getAppDatacodAceInviatoSelezionato();

			// Recupero la riga selezionata, in questo modo non possono hackerare il dato
			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			String numeroCertificato = GenericUtil.getAceByIdRiga(idRigaTabella,
					theModel.getAppDatacertificatiInviati());

			if (!BaseMgr.isNullOrEmpty(numeroCertificato)) {

				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiAttestato certificato = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);
				if (certificato.getStatus() == Constants.ANNULLATO
						|| certificato.getStatus() == Constants.ANNULLATO_BO) {

					String[] s = numeroCertificato.split(" ");
					FiltroRicercaAce filtro = new FiltroRicercaAce();
					filtro.setProgCertificato(s[Constants.PK_PROGR]);
					filtro.setAnnoCertificato(s[Constants.PK_ANNO]);
					filtro.setCertificatore(s[Constants.PK_NUM_CERTIFICATORE]);

					ArrayList<Ace> list = (ArrayList<Ace>) getSOAIntegrationMgr().findAceSostitutivi(filtro);
					theModel.setAppDatacertificatiSostituiti(list);
					result.setResultCode(VEDIACESOSTITUITI_OUTCOME_CODE__OK);

				} else {
					result.getGlobalErrors().add("E' necessario selezionare un certificato ANNULLATO");
					result.setResultCode(VEDIACESOSTITUITI_OUTCOME_CODE__KO);
				}

			} else {
				theModel.setAppDataidRigaSelezionata(null);
				result.getGlobalErrors().add("E' necessario selezionare un certificato");
				result.setResultCode(VEDIACESOSTITUITI_OUTCOME_CODE__KO);
			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::vediACESostituiti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaACENuovi definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults ricercaACENuovi(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACENUOVI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACENUOVI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-476348865) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Recupero la riga selezionata, in questo modo non possono hackerare il dato
			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAceByIdRiga(idRigaTabella,
					theModel.getAppDatacertificatiInviati());

			//String codAceSel = theModel.getAppDatacodAceInviatoSelezionato();
			// impostazione del result code

			if (BaseMgr.isNullOrEmpty(numeroCertificato)) {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un certificato");
				result.setResultCode(RICERCAACENUOVI_OUTCOME_CODE__KO);
			} else {

				DatiAttestato att = getCertificatoMgr().recuperaAttestato(theModel.getAppDatacertificatore(),
						numeroCertificato);

				if (att.getFlgOldApe()) {
					result.getGlobalErrors()
							.add("Si possono duplicare i dati dei soli APE che rispettano le nuove normative");
					result.setResultCode(RICERCAACENUOVI_OUTCOME_CODE__KO);

				} else {
					att.setNumeroAttestato(numeroCertificato);
					theModel.setAppDatacertificato(att);

					result.setResultCode(RICERCAACENUOVI_OUTCOME_CODE__OK);
				}
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaACENuovi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaReport definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPAREPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPAREPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1747431416) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// impostazione del result code
			String parametroDiRequest = theModel.getAppDataparametroDiRequest();

			if (BaseMgr.isNullOrEmpty(parametroDiRequest))
				parametroDiRequest = "ci sono";

			theModel.setAppDataparametroDiRequest(parametroDiRequest);

			// Recupero la riga selezionata, in questo modo non possono hackerare il dato
			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();
			String numeroCertificato = GenericUtil.getAceByIdRiga(idRigaTabella,
					theModel.getAppDatacertificatiInviati());

			//String numeroCertificato = theModel.getAppDatacodAceInviatoSelezionato();

			theModel.setAppDatacodAttestatoDaStampare(numeroCertificato);

			if (!BaseMgr.isNullOrEmpty(numeroCertificato)) {
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__OK);
				theModel.setAppDataprovenienzaPerReport(Constants.PROVENIENZA_RICERCA_ACE);
			} else {
				theModel.setAppDataidRigaSelezionata(null);
				result.getGlobalErrors().add("E' necessario selezionare un certificato");
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaReport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaAttestato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults visualizzaAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAATTESTATO_OUTCOME_CODE__OK_OLD = //NOSONAR  Reason:EIAS
				"OK_OLD"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAATTESTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-848994833) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Recupero la riga selezionata, in questo modo non possono hackerare il dato
			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAceByIdRiga(idRigaTabella,
					theModel.getAppDatacertificatiInviati());
			// impostazione del result code
			//String numeroCertificato = theModel.getAppDatacodAceInviatoSelezionato();

			if (!BaseMgr.isNullOrEmpty(numeroCertificato)) {

				DatiCertificatore cert = theModel.getAppDatacertificatore();

				DatiAttestato att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				att.setNumeroAttestato(numeroCertificato);

				theModel.setAppDatatempDichiarazSelez(att.getDichiarazioni().getCodDichiaraz());

				theModel.setAppDatacertificato(att);

				if (att.getFlgOldApe()) {
					theModel.setAppDatatempDtCatastaliSecondari(
							att.getDatiAnagraficiImm().getDtCatastali().getDtCatastaliSecondari());

					theModel.setAppDatatempRaccomandazioni((ArrayList<Raccomandazione>) getCertificatoMgr()
							.recuperaRaccomandazioni(cert, numeroCertificato));

					// Mi serve per l'indietro
					theModel.setAppDataprovenienzaPerReport(Constants.PROVENIENZA_RICERCA_ACE);

					// impostazione del result code
					theModel.getSession().remove("cpCompilaz_pWizCompilazLiv1_selectedMultiPanel");
					theModel.getSession().remove("cpCompilaz_pWizAnagImmobile_selectedMultiPanel");
					result.setResultCode(VISUALIZZAATTESTATO_OUTCOME_CODE__OK_OLD);
				} else {
					// Mi serve per l'indietro
					theModel.setAppDataprovenienzaPerReport(Constants.PROVENIENZA_RICERCA_ACE);
					result.setResultCode(VISUALIZZAATTESTATO_OUTCOME_CODE__OK);

				}
				// impostazione del result code
			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un certificato");
				result.setResultCode(VISUALIZZAATTESTATO_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaAttestato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaDocAggiuntiva definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults preparaAperturaDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-4989600) ENABLED START*/
			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();
			log.debug("id riga: " + idRigaTabella);

			String numeroCertificato = GenericUtil.getAceByIdRiga(idRigaTabella,
					theModel.getAppDatacertificatiInviati());

			log.debug("num certificato: " + numeroCertificato);

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {

				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiCertificatore cert = theModel.getAppDatacertificatore();

				String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), numeroCertificato);

				String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
				String progrCertificato = split[Constants.PK_PROGR];
				String anno = split[Constants.PK_ANNO];

				log.debug(idCertificatore);
				log.debug(progrCertificato);
				log.debug(anno);

				DatiAttestato dati = certificatoMgr.recuperaAttestato(cert, numeroCertificato);

				if (dati.getStatus().equals(Constants.NUOVO)) {
					result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO);
					result.getGlobalErrors().add("Ape selezionato in stato nuovo.");
				} else {
					ArrayList<DocumentoAggiuntivo> documenti = getCertificatoMgr()
							.findDocumentiAggiuntiviByAce(idCertificatore, progrCertificato, anno);
					theModel.setAppDatalistDocumentazioneAggiuntiva(documenti);
					DatiAttestato datiAttestato = new DatiAttestato();

					datiAttestato.setNumeroAttestato(numeroCertificato);
					theModel.setAppDatacertificato(datiAttestato);
					result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__OK);
				}
			} else {
				theModel.setAppDataidRigaSelezionata(null);
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaDocAggiuntiva] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo switchPulsantiStampaDuplica definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults switchPulsantiStampaDuplica(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHPULSANTISTAMPADUPLICA_OUTCOME_CODE__MOSTRA = //NOSONAR  Reason:EIAS
				"MOSTRA"; //NOSONAR  Reason:EIAS
		final String SWITCHPULSANTISTAMPADUPLICA_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R608292660) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatacertificatiInviati() != null && theModel.getAppDatacertificatiInviati().size() > 0) {
				// impostazione del result code
				result.setResultCode(SWITCHPULSANTISTAMPADUPLICA_OUTCOME_CODE__MOSTRA);
			} else {
				result.setResultCode(SWITCHPULSANTISTAMPADUPLICA_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchPulsantiStampaDuplica] Errore occorso nell'esecuzione del metodo:" + e, e);
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
		session.put("cpRisultatoRicercaAce_tblRisultatoRicercaAceInviati_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1647327165) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private CertificatoMgr certificatoMgr = null;

	public void setCertificatoMgr(CertificatoMgr cm) {
		certificatoMgr = cm;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/*PROTECTED REGION END*/
}
