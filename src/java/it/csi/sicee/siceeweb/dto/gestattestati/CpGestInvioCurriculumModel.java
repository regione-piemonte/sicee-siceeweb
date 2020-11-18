package it.csi.sicee.siceeweb.dto.gestattestati;

import java.io.File;
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

import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpGestInvioCurriculum]
 */
@Validation
public class CpGestInvioCurriculumModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.sicee.siceeweb.dto.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.UserInfo getAppDatacurrentUser() {
		return (it.csi.sicee.siceeweb.dto.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificato(it.csi.sicee.siceeweb.dto.attestati.DatiAttestato value) {
		getSession().put("appDatacertificato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificato'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.attestati.DatiAttestato getAppDatacertificato() {
		return (it.csi.sicee.siceeweb.dto.attestati.DatiAttestato) (getSession().get("appDatacertificato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpGestInvioCurriculum.certificatore.visitorvalidator.label", appendPrefix = true)
	public void setAppDatacertificatore(it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore value) {
		getSession().put("appDatacertificatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatore'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore getAppDatacertificatore() {
		return (it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore) (getSession().get("appDatacertificatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatachiaviCurriculum'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviCurriculum(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CurriculumSummary> value) {
		getSession().put("appDatachiaviCurriculum", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviCurriculum'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CurriculumSummary> getAppDatachiaviCurriculum() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CurriculumSummary>) (getSession()
				.get("appDatachiaviCurriculum"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatauidDaStampare'
	 * @param value
	 * @generated
	 */

	public void setAppDatauidDaStampare(java.lang.String value) {
		getSession().put("appDatauidDaStampare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatauidDaStampare'
	 * @generated
	 */
	public java.lang.String getAppDatauidDaStampare() {
		return (java.lang.String) (getSession().get("appDatauidDaStampare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataflagDatiPersCurriculum'
	 * @param value
	 * @generated
	 */

	public void setAppDataflagDatiPersCurriculum(java.lang.Boolean value) {
		getSession().put("appDataflagDatiPersCurriculum", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataflagDatiPersCurriculum'
	 * @generated
	 */
	public java.lang.Boolean getAppDataflagDatiPersCurriculum() {
		return (java.lang.Boolean) (getSession().get("appDataflagDatiPersCurriculum"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fileAttestato
	private File widgFileAttestato; // The actual file(s)
	private String widgFileAttestatoContentType; // The content type of the file(s) 
	private String widgFileAttestatoFileName; // The uploaded file(s) name and path 

	public void setWidg_fileAttestato(File value) {
		widgFileAttestato = value;
	}
	@JSON(include = false)
	public File getWidg_fileAttestato() {
		return widgFileAttestato;
	}

	public void setWidg_fileAttestatoContentType(String value) {
		widgFileAttestatoContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fileAttestatoContentType() {
		return widgFileAttestatoContentType;
	}

	public void setWidg_fileAttestatoFileName(String value) {
		widgFileAttestatoFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fileAttestatoFileName() {
		return widgFileAttestatoFileName;
	}

	// Table tblCurriculumSummary

	private java.lang.String widgTblCurriculumSummary;

	public void setWidg_tblCurriculumSummary(java.lang.String value) {
		widgTblCurriculumSummary = value;
	}

	public java.lang.String getWidg_tblCurriculumSummary() {
		return widgTblCurriculumSummary;
	}

}
