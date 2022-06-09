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

/*PROTECTED REGION ID(R-1103653376) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
/*PROTECTED REGION END*/

public class CPBECpUploadDocAggiuntiva {

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

	// ApplicationData: [listTipiDoc, scope:USER_SESSION]
	public static final String APPDATA_LISTTIPIDOC_CODE = "appDatalistTipiDoc";

	// ApplicationData: [idTipoDocumento, scope:USER_SESSION]
	public static final String APPDATA_IDTIPODOCUMENTO_CODE = "appDataidTipoDocumento";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpUploadDocAggiuntiva";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadDocAggiuntiva definito in un ExecCommand del
	 * ContentPanel cpUploadDocAggiuntiva
	 */
	public ExecResults uploadDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpUploadDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADDOCAGGIUNTIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPLOADDOCAGGIUNTIVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R711290661) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String idTipoDoc = theModel.getAppDataidTipoDocumento();
			if (idTipoDoc != null) {
				String nomeDocumento = theModel.getWidg_fileDocCaricatoFileName();
				String contentType = theModel.getWidg_fileDocCaricatoContentType();
				if (log.isDebugEnabled()) {
					log.debug("Nome file: " + nomeDocumento);
					log.debug("Content Type: " + contentType);
				}
				if (contentType.equals("application/pdf")) {
					String codiceAttestato = theModel.getAppDatacodAttestatoSelezionato();
					DatiCertificatore cert = theModel.getAppDatacertificatore();

					String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), codiceAttestato);

					String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
					String progrCertificato = split[Constants.PK_PROGR];
					String anno = split[Constants.PK_ANNO];
					DocumentoAggiuntivo doc = getCertificatoMgr().insertNewDocAggiuntiva(theModel, nomeDocumento,
							idCertificatore, progrCertificato, anno, idTipoDoc, codiceAttestato);
					if (doc != null) {
						result.setResultCode(UPLOADDOCAGGIUNTIVA_OUTCOME_CODE__OK);
						ArrayList<DocumentoAggiuntivo> documenti = getCertificatoMgr()
								.findDocumentiAggiuntiviByAce(idCertificatore, progrCertificato, anno);
						theModel.setAppDatalistDocumentazioneAggiuntiva(documenti);
					} else {
						result.setResultCode(UPLOADDOCAGGIUNTIVA_OUTCOME_CODE__KO);
					}
				} else {
					result.getGlobalErrors().add("E' possibile caricare solo file .PDF.");
					result.setResultCode(UPLOADDOCAGGIUNTIVA_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidTipoDocumento(null);
				result.getGlobalErrors().add("E' necessario scegliore un tipo di documento.");
				result.setResultCode(UPLOADDOCAGGIUNTIVA_OUTCOME_CODE__KO);
			}
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::uploadDocAggiuntiva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaTipiDocAggiuntiva definito in un ExecCommand del
	 * ContentPanel cpUploadDocAggiuntiva
	 */
	public ExecResults initListaTipiDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpUploadDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTATIPIDOCAGGIUNTIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INITLISTATIPIDOCAGGIUNTIVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R540462787) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<LabelValue> tipiDoc = getCertificatoMgr().getTipiDoc();
			theModel.setAppDatalistTipiDoc(tipiDoc);
			// impostazione del result code 
			result.setResultCode(INITLISTATIPIDOCAGGIUNTIVA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaTipiDocAggiuntiva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R157700206) ENABLED START*/
	private CertificatoMgr certificatoMgr;
	private SOAIntegrationMgr soaIntegrationMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	/*PROTECTED REGION END*/
}
