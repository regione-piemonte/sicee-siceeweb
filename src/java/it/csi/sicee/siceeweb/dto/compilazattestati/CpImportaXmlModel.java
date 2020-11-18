package it.csi.sicee.siceeweb.dto.compilazattestati;

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
 * logica di business associata alla Schermata [cpImportaXml]
 */
@Validation
public class CpImportaXmlModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataxmlResult'
	 * @param value
	 * @generated
	 */

	public void setAppDataxmlResult(java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.ImportXmlResult> value) {
		getSession().put("appDataxmlResult", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataxmlResult'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.ImportXmlResult> getAppDataxmlResult() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.ImportXmlResult>) (getSession()
				.get("appDataxmlResult"));
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
	@VisitorFieldValidator(message = "", key = "cpImportaXml.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatacomuniCertDtCat'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniCertDtCat(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniCertDtCat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniCertDtCat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniCertDtCat() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession().get("appDatacomuniCertDtCat"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceCertDTCat'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceCertDTCat(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceCertDTCat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceCertDTCat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceCertDTCat() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceCertDTCat"));
	}

	/**
	 * @generated
	 */
	private java.lang.String appDataesitoImportaXml = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDataesitoImportaXml'
	 * @param value
	 * @generated
	 */

	public void setAppDataesitoImportaXml(java.lang.String value) {
		appDataesitoImportaXml = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataesitoImportaXml'
	 * @generated
	 */
	public java.lang.String getAppDataesitoImportaXml() {
		return appDataesitoImportaXml;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatoXml'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatoXml(it.csi.sicee.siceeweb.dto.attestati.DatiAttestato value) {
		getSession().put("appDatacertificatoXml", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatoXml'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.attestati.DatiAttestato getAppDatacertificatoXml() {
		return (it.csi.sicee.siceeweb.dto.attestati.DatiAttestato) (getSession().get("appDatacertificatoXml"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodAttestatoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodAttestatoSelezionato(java.lang.String value) {
		getSession().put("appDatacodAttestatoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodAttestatoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodAttestatoSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodAttestatoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatempDichiarazSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDatatempDichiarazSelez(java.lang.Integer value) {
		getSession().put("appDatatempDichiarazSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatempDichiarazSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDatatempDichiarazSelez() {
		return (java.lang.Integer) (getSession().get("appDatatempDichiarazSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatempRaccomandazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDatatempRaccomandazioni(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione> value) {
		getSession().put("appDatatempRaccomandazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatempRaccomandazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione> getAppDatatempRaccomandazioni() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione>) (getSession()
				.get("appDatatempRaccomandazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattestatiXml'
	 * @param value
	 * @generated
	 */

	public void setAppDataattestatiXml(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.DatiAttestato> value) {
		getSession().put("appDataattestatiXml", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattestatiXml'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.DatiAttestato> getAppDataattestatiXml() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.DatiAttestato>) (getSession()
				.get("appDataattestatiXml"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisImportaDati'
	 * @param value
	 * @generated
	 */

	public void setAppDataisImportaDati(java.lang.Boolean value) {
		getSession().put("appDataisImportaDati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisImportaDati'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisImportaDati() {
		return (java.lang.Boolean) (getSession().get("appDataisImportaDati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatempDtCatastaliSecondari'
	 * @param value
	 * @generated
	 */

	public void setAppDatatempDtCatastaliSecondari(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari> value) {
		getSession().put("appDatatempDtCatastaliSecondari", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatempDtCatastaliSecondari'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari> getAppDatatempDtCatastaliSecondari() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari>) (getSession()
				.get("appDatatempDtCatastaliSecondari"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fileCaricaXml
	private File widgFileCaricaXml; // The actual file(s)
	private String widgFileCaricaXmlContentType; // The content type of the file(s) 
	private String widgFileCaricaXmlFileName; // The uploaded file(s) name and path 

	public void setWidg_fileCaricaXml(File value) {
		widgFileCaricaXml = value;
	}
	@JSON(include = false)
	public File getWidg_fileCaricaXml() {
		return widgFileCaricaXml;
	}

	public void setWidg_fileCaricaXmlContentType(String value) {
		widgFileCaricaXmlContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fileCaricaXmlContentType() {
		return widgFileCaricaXmlContentType;
	}

	public void setWidg_fileCaricaXmlFileName(String value) {
		widgFileCaricaXmlFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fileCaricaXmlFileName() {
		return widgFileCaricaXmlFileName;
	}

	// Table tblXmlResult

	private java.lang.String widgTblXmlResult;

	public void setWidg_tblXmlResult(java.lang.String value) {
		widgTblXmlResult = value;
	}

	public java.lang.String getWidg_tblXmlResult() {
		return widgTblXmlResult;
	}

}
