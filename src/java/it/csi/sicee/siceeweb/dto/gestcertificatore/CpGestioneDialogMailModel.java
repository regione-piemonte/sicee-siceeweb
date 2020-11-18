package it.csi.sicee.siceeweb.dto.gestcertificatore;

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
 * logica di business associata alla Schermata [cpGestioneDialogMail]
 */
@Validation
public class CpGestioneDialogMailModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatamsgEsitoVerificaMail'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgEsitoVerificaMail(java.lang.String value) {
		getSession().put("appDatamsgEsitoVerificaMail", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgEsitoVerificaMail'
	 * @generated
	 */
	public java.lang.String getAppDatamsgEsitoVerificaMail() {
		return (java.lang.String) (getSession().get("appDatamsgEsitoVerificaMail"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataflgEsitoVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataflgEsitoVerifica(java.lang.Boolean value) {
		getSession().put("appDataflgEsitoVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataflgEsitoVerifica'
	 * @generated
	 */
	public java.lang.Boolean getAppDataflgEsitoVerifica() {
		return (java.lang.Boolean) (getSession().get("appDataflgEsitoVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataauthVerify'
	 * @param value
	 * @generated
	 */

	public void setAppDataauthVerify(java.lang.String value) {
		getSession().put("appDataauthVerify", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataauthVerify'
	 * @generated
	 */
	public java.lang.String getAppDataauthVerify() {
		return (java.lang.String) (getSession().get("appDataauthVerify"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpGestioneDialogMail.certificatore.visitorvalidator.label", appendPrefix = true)
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// HiddenValue hvEsitoMailOK

	private java.lang.String widgHvEsitoMailOK;

	public void setWidg_hvEsitoMailOK(java.lang.String value) {
		widgHvEsitoMailOK = value;
	}

	public java.lang.String getWidg_hvEsitoMailOK() {
		return widgHvEsitoMailOK;
	}
	// HiddenValue hvEsitoMailKO

	private java.lang.String widgHvEsitoMailKO;

	public void setWidg_hvEsitoMailKO(java.lang.String value) {
		widgHvEsitoMailKO = value;
	}

	public java.lang.String getWidg_hvEsitoMailKO() {
		return widgHvEsitoMailKO;
	}
	// HiddenValue hvEsitoMailMSG

	private java.lang.String widgHvEsitoMailMSG;

	public void setWidg_hvEsitoMailMSG(java.lang.String value) {
		widgHvEsitoMailMSG = value;
	}

	public java.lang.String getWidg_hvEsitoMailMSG() {
		return widgHvEsitoMailMSG;
	}

}
