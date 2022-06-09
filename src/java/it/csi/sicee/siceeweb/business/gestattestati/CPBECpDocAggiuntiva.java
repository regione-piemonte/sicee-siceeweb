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

/*PROTECTED REGION ID(R1830748895) ENABLED START*/
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntiva;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import java.sql.Timestamp;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;

/*PROTECTED REGION END*/

public class CPBECpDocAggiuntiva {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [aceList, scope:USER_SESSION]
	public static final String APPDATA_ACELIST_CODE = "appDataaceList";

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [aceSostituzioneList, scope:USER_SESSION]
	public static final String APPDATA_ACESOSTITUZIONELIST_CODE = "appDataaceSostituzioneList";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [emailInvioApe, scope:USER_SESSION]
	public static final String APPDATA_EMAILINVIOAPE_CODE = "appDataemailInvioApe";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [documentoAggiuntivo, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTOAGGIUNTIVO_CODE = "appDatadocumentoAggiuntivo";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	// ApplicationData: [uidDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_UIDDOCUMENTOSELEZIONATO_CODE = "appDatauidDocumentoSelezionato";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDocAggiuntiva";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaDownloadDocumento definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaDownloadDocumento(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1981880147) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Integer idDoc = theModel.getAppDataidDocumentoSelezionato();

			if (!GenericUtil.isNullOrEmpty(idDoc)) {
				SiceeTDocAggiuntiva docAggiuntiva = getCertificatoMgr().getSiceeTDocAggiuntiva()
						.findByPrimaryKey(idDoc);

				String uid = docAggiuntiva.getUidIndex();
				if (uid != null) {
					theModel.setAppDatauidDocumentoSelezionato(uid);
					result.setResultCode(PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Documento non presente sul sistema.");
					result.setResultCode(PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidDocumentoSelezionato(null);
				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
				result.setResultCode(PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaDownloadDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaInserisciDocumento definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaInserisciDocumento(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAINSERISCIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAINSERISCIDOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1539297904) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(PREPARAINSERISCIDOCUMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaInserisciDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaEliminaDocumento definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaEliminaDocumento(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-271775626) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			Integer idDoc = theModel.getAppDataidDocumentoSelezionato();

			if (!GenericUtil.isNullOrEmpty(idDoc)) {
				SiceeTDocAggiuntiva docAggiuntiva = getCertificatoMgr().getSiceeTDocAggiuntiva()
						.findByPrimaryKey(idDoc);
				if (docAggiuntiva != null && docAggiuntiva.getDtDelete() == null) {
					result.setResultCode(PREPARAELIMINADOCUMENTO_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Documento già eliminato");
					result.setResultCode(PREPARAELIMINADOCUMENTO_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidDocumentoSelezionato(null);
				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
				result.setResultCode(PREPARAELIMINADOCUMENTO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaEliminaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo jumpBackDocAggiuntiva definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults jumpBackDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__OK_DETTAGLIO_APE = //NOSONAR  Reason:EIAS
				"OK_DETTAGLIO_APE"; //NOSONAR  Reason:EIAS
		final String JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__OK_RICERCA_APE = //NOSONAR  Reason:EIAS
				"OK_RICERCA_APE"; //NOSONAR  Reason:EIAS
		final String JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__OK_VISUALIZZA_APE = //NOSONAR  Reason:EIAS
				"OK_VISUALIZZA_APE"; //NOSONAR  Reason:EIAS
		final String JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R362479992) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("-------------------PROVENIENZA-------------: " + theModel.getAppDatapaginaProvenienza());
			// impostazione del result code
			if (theModel.getAppDatapaginaProvenienza() == null) {
				result.setResultCode(JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__OK_DETTAGLIO_APE);
			} else {
				switch (theModel.getAppDatapaginaProvenienza()) {
					case "RICERCA" :
						result.setResultCode(JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__OK_RICERCA_APE);
						break;
					case "COMPILAZIONE" :
						result.setResultCode(JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__OK_DETTAGLIO_APE);
						break;
					case "VISUALIZZA" :
						result.setResultCode(JUMPBACKDOCAGGIUNTIVA_OUTCOME_CODE__OK_VISUALIZZA_APE);
						break;
				}

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::jumpBackDocAggiuntiva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaDocAggiuntiva definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults eliminaDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINADOCAGGIUNTIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCAGGIUNTIVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1020721004) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			Integer idDoc = theModel.getAppDataidDocumentoSelezionato();

			log.debug("ID DOCUMENTO: " + idDoc);

			if (!GenericUtil.isNullOrEmpty(idDoc)) {
				SiceeTDocAggiuntiva docAggiuntiva = getCertificatoMgr().getSiceeTDocAggiuntiva()
						.findByPrimaryKey(idDoc);
				if (docAggiuntiva != null) {
					docAggiuntiva.setDtDelete(new Timestamp(new Date().getTime()));
					getCertificatoMgr().deleteDocumentazioneAggiuntiva(idDoc, docAggiuntiva);

					String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();
					DatiCertificatore cert = theModel.getAppDatacertificatore();

					String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), numeroCertificato);

					String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
					String progrCertificato = split[Constants.PK_PROGR];
					String anno = split[Constants.PK_ANNO];

					ArrayList<DocumentoAggiuntivo> documenti = getCertificatoMgr()
							.findDocumentiAggiuntiviByAce(idCertificatore, progrCertificato, anno);

					theModel.setAppDatalistDocumentazioneAggiuntiva(documenti);

					result.setResultCode(ELIMINADOCAGGIUNTIVA_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Documento non presente sul sistema.");
					result.setResultCode(ELIMINADOCAGGIUNTIVA_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidDocumentoSelezionato(null);
				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
				result.setResultCode(ELIMINADOCAGGIUNTIVA_OUTCOME_CODE__OK);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaDocAggiuntiva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaDocumentazione definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults initListaDocumentazione(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTADOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INITLISTADOCUMENTAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String INITLISTADOCUMENTAZIONE_OUTCOME_CODE__OK_VISUALIZZA = //NOSONAR  Reason:EIAS
				"OK_VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String INITLISTADOCUMENTAZIONE_OUTCOME_CODE__KO_VISUALIZZA = //NOSONAR  Reason:EIAS
				"KO_VISUALIZZA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1168717560) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code

			log.debug("PROVENIENZA: " + theModel.getAppDatapaginaProvenienza());
			if (theModel.getAppDatapaginaProvenienza() != null
					&& theModel.getAppDatapaginaProvenienza().equals("VISUALIZZA")) {
				if (!GenericUtil.isNullOrEmpty(theModel.getAppDatalistDocumentazioneAggiuntiva())) {
					result.setResultCode(INITLISTADOCUMENTAZIONE_OUTCOME_CODE__OK_VISUALIZZA);
				} else {
					result.setResultCode(INITLISTADOCUMENTAZIONE_OUTCOME_CODE__KO_VISUALIZZA);
				}
			} else {
				if (!GenericUtil.isNullOrEmpty(theModel.getAppDatalistDocumentazioneAggiuntiva())) {
					result.setResultCode(INITLISTADOCUMENTAZIONE_OUTCOME_CODE__OK);
				} else
					result.setResultCode(INITLISTADOCUMENTAZIONE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDocAggiuntiva
	 */
	public static void resetClearStatus_widg_tblDocAggiuntiva(java.util.Map session) {
		session.put("cpDocAggiuntiva_tblDocAggiuntiva_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-784609041) ENABLED START*/

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	/*PROTECTED REGION END*/
}
