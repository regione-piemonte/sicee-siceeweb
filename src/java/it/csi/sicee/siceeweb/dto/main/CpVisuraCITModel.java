package it.csi.sicee.siceeweb.dto.main;

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
 * logica di business associata alla Schermata [cpVisuraCIT]
 */
@Validation
public class CpVisuraCITModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpVisuraCIT.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatavisuraCodImpiantoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraCodImpiantoSelez(java.lang.Integer value) {
		getSession().put("appDatavisuraCodImpiantoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraCodImpiantoSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDatavisuraCodImpiantoSelez() {
		return (java.lang.Integer) (getSession().get("appDatavisuraCodImpiantoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraImpianto(it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto value) {
		getSession().put("appDatavisuraImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraImpianto'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto getAppDatavisuraImpianto() {
		return (it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto) (getSession().get("appDatavisuraImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraImpiantoList'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraImpiantoList(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto> value) {
		getSession().put("appDatavisuraImpiantoList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraImpiantoList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto> getAppDatavisuraImpiantoList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto>) (getSession()
				.get("appDatavisuraImpiantoList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraRappControlloList'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraRappControlloList(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo> value) {
		getSession().put("appDatavisuraRappControlloList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraRappControlloList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo> getAppDatavisuraRappControlloList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo>) (getSession()
				.get("appDatavisuraRappControlloList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraRicerca'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraRicerca(it.csi.sicee.siceeweb.dto.attestati.VisuraRicerca value) {
		getSession().put("appDatavisuraRicerca", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraRicerca'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.attestati.VisuraRicerca getAppDatavisuraRicerca() {
		return (it.csi.sicee.siceeweb.dto.attestati.VisuraRicerca) (getSession().get("appDatavisuraRicerca"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraRifCatastaleList'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraRifCatastaleList(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale> value) {
		getSession().put("appDatavisuraRifCatastaleList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraRifCatastaleList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale> getAppDatavisuraRifCatastaleList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale>) (getSession()
				.get("appDatavisuraRifCatastaleList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraUidLibrettoDaStampare'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraUidLibrettoDaStampare(java.lang.String value) {
		getSession().put("appDatavisuraUidLibrettoDaStampare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraUidLibrettoDaStampare'
	 * @generated
	 */
	public java.lang.String getAppDatavisuraUidLibrettoDaStampare() {
		return (java.lang.String) (getSession().get("appDatavisuraUidLibrettoDaStampare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidRigaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidRigaSelezionata(java.lang.Integer value) {
		getSession().put("appDataidRigaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidRigaSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidRigaSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidRigaSelezionata"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbDatiCatastali

	private java.lang.String widgTbDatiCatastali;

	public void setWidg_tbDatiCatastali(java.lang.String value) {
		widgTbDatiCatastali = value;
	}

	public java.lang.String getWidg_tbDatiCatastali() {
		return widgTbDatiCatastali;
	}

	// Table tbRappControllo

	private java.lang.String widgTbRappControllo;

	public void setWidg_tbRappControllo(java.lang.String value) {
		widgTbRappControllo = value;
	}

	public java.lang.String getWidg_tbRappControllo() {
		return widgTbRappControllo;
	}

}
