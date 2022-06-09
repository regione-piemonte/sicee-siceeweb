package it.csi.sicee.siceeweb.dto.compilazattestatiape;

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
 * logica di business associata alla Schermata [cpImpXml2015]
 */
@Validation
public class CpImpXml2015Model extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpImpXml2015.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDataprovenienzaPerReport'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovenienzaPerReport(java.lang.String value) {
		getSession().put("appDataprovenienzaPerReport", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovenienzaPerReport'
	 * @generated
	 */
	public java.lang.String getAppDataprovenienzaPerReport() {
		return (java.lang.String) (getSession().get("appDataprovenienzaPerReport"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamsgGenerico'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgGenerico(java.lang.String value) {
		getSession().put("appDatamsgGenerico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgGenerico'
	 * @generated
	 */
	public java.lang.String getAppDatamsgGenerico() {
		return (java.lang.String) (getSession().get("appDatamsgGenerico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneZonaClima'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneZonaClima(java.lang.String value) {
		getSession().put("appDataidComuneZonaClima", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneZonaClima'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneZonaClima() {
		return (java.lang.String) (getSession().get("appDataidComuneZonaClima"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistZoneClima'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistZoneClima(java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> value) {
		getSession().put("appDatalistZoneClima", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistZoneClima'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> getAppDatalistZoneClima() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue>) (getSession().get("appDatalistZoneClima"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaProvenienza'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaProvenienza(java.lang.String value) {
		getSession().put("appDatapaginaProvenienza", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaProvenienza'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaProvenienza() {
		return (java.lang.String) (getSession().get("appDatapaginaProvenienza"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fileCarica
	private File widgFileCarica; // The actual file(s)
	private String widgFileCaricaContentType; // The content type of the file(s) 
	private String widgFileCaricaFileName; // The uploaded file(s) name and path 

	public void setWidg_fileCarica(File value) {
		widgFileCarica = value;
	}
	@JSON(include = false)
	public File getWidg_fileCarica() {
		return widgFileCarica;
	}

	public void setWidg_fileCaricaContentType(String value) {
		widgFileCaricaContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fileCaricaContentType() {
		return widgFileCaricaContentType;
	}

	public void setWidg_fileCaricaFileName(String value) {
		widgFileCaricaFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fileCaricaFileName() {
		return widgFileCaricaFileName;
	}

}
