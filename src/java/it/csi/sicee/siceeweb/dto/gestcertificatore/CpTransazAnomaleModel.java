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
 * logica di business associata alla Schermata [cpTransazAnomale]
 */
@Validation
public class CpTransazAnomaleModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpTransazAnomale.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatatransazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatatransazione(it.csi.sicee.siceeweb.dto.pagamenti.Transazione value) {
		getSession().put("appDatatransazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatransazione'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.pagamenti.Transazione getAppDatatransazione() {
		return (it.csi.sicee.siceeweb.dto.pagamenti.Transazione) (getSession().get("appDatatransazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTransazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTransazione(java.lang.Long value) {
		getSession().put("appDataidTransazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTransazione'
	 * @generated
	 */
	public java.lang.Long getAppDataidTransazione() {
		return (java.lang.Long) (getSession().get("appDataidTransazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatransazioneAce'
	 * @param value
	 * @generated
	 */

	public void setAppDatatransazioneAce(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce> value) {
		getSession().put("appDatatransazioneAce", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatransazioneAce'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce> getAppDatatransazioneAce() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce>) (getSession()
				.get("appDatatransazioneAce"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatransazioneRegistrazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatatransazioneRegistrazione(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.transazioni.TransazioneRegistrazione> value) {
		getSession().put("appDatatransazioneRegistrazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatransazioneRegistrazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.transazioni.TransazioneRegistrazione> getAppDatatransazioneRegistrazione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.transazioni.TransazioneRegistrazione>) (getSession()
				.get("appDatatransazioneRegistrazione"));
	}

	/**
	 * @generated
	 */
	private java.lang.String appDatamsgEsitoTransazione = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDatamsgEsitoTransazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgEsitoTransazione(java.lang.String value) {
		appDatamsgEsitoTransazione = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgEsitoTransazione'
	 * @generated
	 */
	public java.lang.String getAppDatamsgEsitoTransazione() {
		return appDatamsgEsitoTransazione;
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
