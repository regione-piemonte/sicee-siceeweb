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

/*PROTECTED REGION ID(R30908485) ENABLED START*/
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumento;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCurriculumModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;

/*PROTECTED REGION END*/

public class CPBECpGestInvioCurriculum {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [chiaviCurriculum, scope:USER_SESSION]
	public static final String APPDATA_CHIAVICURRICULUM_CODE = "appDatachiaviCurriculum";

	// ApplicationData: [uidDaStampare, scope:USER_SESSION]
	public static final String APPDATA_UIDDASTAMPARE_CODE = "appDatauidDaStampare";

	// ApplicationData: [flagDatiPersCurriculum, scope:USER_SESSION]
	public static final String APPDATA_FLAGDATIPERSCURRICULUM_CODE = "appDataflagDatiPersCurriculum";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestInvioCurriculum";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo invioAttestato definito in un ExecCommand del
	 * ContentPanel cpGestInvioCurriculum
	 */
	public ExecResults invioAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCurriculumModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIOATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INVIOATTESTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String INVIOATTESTATO_OUTCOME_CODE__KO_CHECK = //NOSONAR  Reason:EIAS
				"KO_CHECK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1846167606) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			boolean ok = checkInvioDocumento(theModel, result);
			// impostazione del result code
			if (ok) {

				SiceeTDocumento doc = getCertificatoreMgr().getSiceeTDocumentoDao()
						.findWhereIdCertificatoreAndIdTipoDocEquals(cert.getIdCertificatore(),
								BaseMgr.TIPO_CURRICULUM_VITAE);

				Integer idDoc = null;
				if (doc != null) {
					idDoc = doc.getIdDocumento();
				} else {
					idDoc = getCertificatoreMgr().getIdDocumento();
				}

				String nomeDoc = theModel.getWidg_fileAttestatoFileName();
				String nomeDocNew = GenericUtil.getNomeFile(BaseMgr.TIPO_CURRICULUM_VITAE, idDoc, nomeDoc);

				if (!invioDocumento(theModel, nomeDocNew)) {
					result.getGlobalErrors().add("Si e' verificato un problema nell'invio del documento");
					result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);
				} else {
					log.debug("UID: " + getUid());
					if (getUid() != null) {
						getCertificatoreMgr().aggiornaCurriculumInviato(doc, idDoc, getUid(), nomeDocNew,
								cert.getIdCertificatore());
						result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__OK);
						setUid(null);
						theModel.setWidg_fileAttestatoFileName(null);
						theModel.getSession().put("active_menu", "menu_items_" + "mnuhome");
					} else {
						result.getGlobalErrors().add("Si e' verificato un problema nell'invio del documento");
						result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO_CHECK);
					}
				}
			} else {
				result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO_CHECK);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::invioAttestato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaCurriculumVitae definito in un ExecCommand del
	 * ContentPanel cpGestInvioCurriculum
	 */
	public ExecResults scaricaCurriculumVitae(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCurriculumModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICACURRICULUMVITAE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1749239698) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			CurriculumSummary curr = theModel.getAppDatachiaviCurriculum().get(new Integer(theModel.getIdRiga()) - 1);
			theModel.setAppDatauidDaStampare(curr.getUid());

			// impostazione del result code
			result.setResultCode(SCARICACURRICULUMVITAE_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scaricaCurriculumVitae] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaCurriculum definito in un ExecCommand del
	 * ContentPanel cpGestInvioCurriculum
	 */
	public ExecResults initListaCurriculum(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCurriculumModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTACURRICULUM_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-753921708) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			theModel.setAppDatachiaviCurriculum(getCertificatoreMgr().getCurriculum(certificatore));
			// impostazione del result code
			result.setResultCode(INITLISTACURRICULUM_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			/*theModel.getSession().put("active_menu",
					"menu_items_" + "mnuhome");*/
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaCurriculum] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblCurriculumSummary
	 */
	public static void resetClearStatus_widg_tblCurriculumSummary(java.util.Map session) {
		session.put("cpGestInvioCurriculum_tblCurriculumSummary_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1502518263) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private boolean checkInvioDocumento(CpGestInvioCurriculumModel theModel, ExecResults result) {

		boolean out = true;

		String fileName = theModel.getWidg_fileAttestatoFileName();
		log.debug("Nome file attestato firmato: -" + fileName + "-");
		if (fileName != null) {
			if (getMiscMgr().isFileNameValid(fileName)) {
				if (!fileName.endsWith(".doc") && !fileName.endsWith(".odt") && !fileName.endsWith(".pdf")) {
					result.getGlobalErrors().add("Il formato del file non e' corretto");
					out = false;
				}
			} else {
				result.getGlobalErrors().add(
						"Il caricamento non e' andato a buon fine, e' necessario rinominare il file senza indicare caratteri speciali");
				out = false;
			}
		} else {
			result.getGlobalErrors().add("E' necessario selezionare un documento");
			out = false;
		}
		if (theModel.getAppDataflagDatiPersCurriculum() != null && !theModel.getAppDataflagDatiPersCurriculum()) {
			result.getGlobalErrors().add("E' necessario dare il consenso alla gestione dei dati personali.");
			out = false;
		}

		return out;
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "e' obbligatorio");
	}

	private boolean invioDocumento(CpGestInvioCurriculumModel theModel, String nomeDoc)
			throws FileNotFoundException, IOException, BEException {

		log.debug("[CPBECpGestInvioCertificato::invioDocumento] BEGIN");
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		try {

			//String nomeAttestato = theModel.getWidg_fileAttestatoFileName();
			String contentType = theModel.getWidg_fileAttestatoContentType();

			if (log.isDebugEnabled()) {
				log.debug("Nome file: " + nomeDoc);
				log.debug("Content Type: " + contentType);
			}

			if (!GenericUtil.isNullOrEmpty(nomeDoc)) {
				java.io.File file = theModel.getWidg_fileAttestato();
				InputStream is = new FileInputStream(file);

				long length = file.length();
				if (length > Integer.MAX_VALUE) {
					log.error("File is too large");
				}

				byte[] bytes = new byte[(int) length];

				is.read(bytes);

				is.close();

				setUid(getSOAIntegrationMgr().salvaDocumento(cert, bytes, nomeDoc, contentType, length,
						Constants.TIPOLOGIA_ALLEGATO_CV, BaseMgr.TIPO_CURRICULUM_VITAE));
				return true;
			}
			return false;
		} catch (BEException e) {
			log.error("Errore", e);
			return false;
		} finally {
			log.debug("[CPBECpGestInvioCertificato::invioDocumento] END");
		}
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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
