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
 * logica di business associata alla Schermata [cpAttesaRT]
 */
@Validation
public class CpAttesaRTModel extends BaseSessionAwareDTO {

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
	@VisitorFieldValidator(message = "", key = "cpAttesaRT.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatastatiTransazioneMdpNew'
	 * @param value
	 * @generated
	 */

	public void setAppDatastatiTransazioneMdpNew(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.LabelValueCombo> value) {
		getSession().put("appDatastatiTransazioneMdpNew", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatastatiTransazioneMdpNew'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.LabelValueCombo> getAppDatastatiTransazioneMdpNew() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.LabelValueCombo>) (getSession()
				.get("appDatastatiTransazioneMdpNew"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiPagamentoNewList'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiPagamentoNewList(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew> value) {
		getSession().put("appDatadatiPagamentoNewList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiPagamentoNewList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew> getAppDatadatiPagamentoNewList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew>) (getSession()
				.get("appDatadatiPagamentoNewList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidStatoTransazioneMdpNewSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoTransazioneMdpNewSelez(java.lang.Integer value) {
		getSession().put("appDataidStatoTransazioneMdpNewSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoTransazioneMdpNewSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidStatoTransazioneMdpNewSelez() {
		return (java.lang.Integer) (getSession().get("appDataidStatoTransazioneMdpNewSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDatiPagamentoNewSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDatiPagamentoNewSelez(java.lang.Integer value) {
		getSession().put("appDataidDatiPagamentoNewSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDatiPagamentoNewSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidDatiPagamentoNewSelez() {
		return (java.lang.Integer) (getSession().get("appDataidDatiPagamentoNewSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiPagamentoNew'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiPagamentoNew(it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew value) {
		getSession().put("appDatadatiPagamentoNew", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiPagamentoNew'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew getAppDatadatiPagamentoNew() {
		return (it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew) (getSession().get("appDatadatiPagamentoNew"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
