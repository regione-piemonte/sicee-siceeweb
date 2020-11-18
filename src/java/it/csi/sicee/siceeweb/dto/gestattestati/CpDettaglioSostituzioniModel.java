package it.csi.sicee.siceeweb.dto.gestattestati;

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
 * logica di business associata alla Schermata [cpDettaglioSostituzioni]
 */
@Validation
public class CpDettaglioSostituzioniModel extends BaseSessionAwareDTO {

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
	@VisitorFieldValidator(message = "", key = "cpDettaglioSostituzioni.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatacertificatiSostituiti'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatiSostituiti(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDatacertificatiSostituiti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatiSostituiti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDatacertificatiSostituiti() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession()
				.get("appDatacertificatiSostituiti"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblVediSostituzioni

	private java.lang.String widgTblVediSostituzioni;

	public void setWidg_tblVediSostituzioni(java.lang.String value) {
		widgTblVediSostituzioni = value;
	}

	public java.lang.String getWidg_tblVediSostituzioni() {
		return widgTblVediSostituzioni;
	}

}
