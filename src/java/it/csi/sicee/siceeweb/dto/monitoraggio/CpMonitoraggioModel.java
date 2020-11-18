package it.csi.sicee.siceeweb.dto.monitoraggio;

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
 * logica di business associata alla Schermata [cpMonitoraggio]
 */
@Validation
public class CpMonitoraggioModel extends BaseSessionAwareDTO {

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
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> appDataprovinceMonitoraggio = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>();

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceMonitoraggio'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceMonitoraggio(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		appDataprovinceMonitoraggio = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceMonitoraggio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceMonitoraggio() {
		return appDataprovinceMonitoraggio;
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.certificatore.Titolo> appDatatitoliMonitoraggio = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.certificatore.Titolo>();

	/**
	 * imposta il valore dell' ApplicationData 'appDatatitoliMonitoraggio'
	 * @param value
	 * @generated
	 */

	public void setAppDatatitoliMonitoraggio(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.certificatore.Titolo> value) {
		appDatatitoliMonitoraggio = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatitoliMonitoraggio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.certificatore.Titolo> getAppDatatitoliMonitoraggio() {
		return appDatatitoliMonitoraggio;
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> appDataindirizziMonitoraggio = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo>();

	/**
	 * imposta il valore dell' ApplicationData 'appDataindirizziMonitoraggio'
	 * @param value
	 * @generated
	 */

	public void setAppDataindirizziMonitoraggio(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> value) {
		appDataindirizziMonitoraggio = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataindirizziMonitoraggio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> getAppDataindirizziMonitoraggio() {
		return appDataindirizziMonitoraggio;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaceMonitoraggio'
	 * @param value
	 * @generated
	 */

	public void setAppDataaceMonitoraggio(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDataaceMonitoraggio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaceMonitoraggio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDataaceMonitoraggio() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession().get("appDataaceMonitoraggio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpMonitoraggio.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatacodiceAttestatoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodiceAttestatoSelezionato(java.lang.String value) {
		getSession().put("appDatacodiceAttestatoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodiceAttestatoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodiceAttestatoSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodiceAttestatoSelezionato"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// ComboBox cbTitoliMonitoraggio

	private java.lang.String widgCbTitoliMonitoraggio;

	public void setWidg_cbTitoliMonitoraggio(java.lang.String value) {
		widgCbTitoliMonitoraggio = value;
	}

	public java.lang.String getWidg_cbTitoliMonitoraggio() {
		return widgCbTitoliMonitoraggio;
	}

	// ComboBox cbProvinceMonitoraggio

	private java.lang.String widgCbProvinceMonitoraggio;

	public void setWidg_cbProvinceMonitoraggio(java.lang.String value) {
		widgCbProvinceMonitoraggio = value;
	}

	public java.lang.String getWidg_cbProvinceMonitoraggio() {
		return widgCbProvinceMonitoraggio;
	}

	// ComboBox cbIndirizziMonitoraggio

	private java.lang.String widgCbIndirizziMonitoraggio;

	public void setWidg_cbIndirizziMonitoraggio(java.lang.String value) {
		widgCbIndirizziMonitoraggio = value;
	}

	public java.lang.String getWidg_cbIndirizziMonitoraggio() {
		return widgCbIndirizziMonitoraggio;
	}

}
