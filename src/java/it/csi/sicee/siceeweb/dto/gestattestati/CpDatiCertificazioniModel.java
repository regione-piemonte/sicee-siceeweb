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
 * logica di business associata alla Schermata [cpDatiCertificazioni]
 */
@Validation
public class CpDatiCertificazioniModel extends BaseSessionAwareDTO {

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
	@VisitorFieldValidator(message = "", key = "cpDatiCertificazioni.certificatore.visitorvalidator.label", appendPrefix = true)
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

}
