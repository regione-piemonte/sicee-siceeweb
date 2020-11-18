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
 * logica di business associata alla Schermata [cpEsitoPagamentiNew]
 */
@Validation
public class CpEsitoPagamentiNewModel extends BaseSessionAwareDTO {

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
	@VisitorFieldValidator(message = "", key = "cpEsitoPagamentiNew.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatamsgPagamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgPagamento(java.lang.String value) {
		getSession().put("appDatamsgPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgPagamento'
	 * @generated
	 */
	public java.lang.String getAppDatamsgPagamento() {
		return (java.lang.String) (getSession().get("appDatamsgPagamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroTransazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroTransazione(java.lang.String value) {
		getSession().put("appDatanumeroTransazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroTransazione'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroTransazione() {
		return (java.lang.String) (getSession().get("appDatanumeroTransazione"));
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

	/**
	 * imposta il valore dell' ApplicationData 'appDatamdpNewURL'
	 * @param value
	 * @generated
	 */

	public void setAppDatamdpNewURL(java.lang.String value) {
		getSession().put("appDatamdpNewURL", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamdpNewURL'
	 * @generated
	 */
	public java.lang.String getAppDatamdpNewURL() {
		return (java.lang.String) (getSession().get("appDatamdpNewURL"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// HiddenValue hvPagamentoWISPOK

	private java.lang.String widgHvPagamentoWISPOK;

	public void setWidg_hvPagamentoWISPOK(java.lang.String value) {
		widgHvPagamentoWISPOK = value;
	}

	public java.lang.String getWidg_hvPagamentoWISPOK() {
		return widgHvPagamentoWISPOK;
	}
	// HiddenValue hvPagamentoWISPKO

	private java.lang.String widgHvPagamentoWISPKO;

	public void setWidg_hvPagamentoWISPKO(java.lang.String value) {
		widgHvPagamentoWISPKO = value;
	}

	public java.lang.String getWidg_hvPagamentoWISPKO() {
		return widgHvPagamentoWISPKO;
	}
	// HiddenValue hvPagamentoOK

	private java.lang.String widgHvPagamentoOK;

	public void setWidg_hvPagamentoOK(java.lang.String value) {
		widgHvPagamentoOK = value;
	}

	public java.lang.String getWidg_hvPagamentoOK() {
		return widgHvPagamentoOK;
	}
	// HiddenValue hvPagamentoKO

	private java.lang.String widgHvPagamentoKO;

	public void setWidg_hvPagamentoKO(java.lang.String value) {
		widgHvPagamentoKO = value;
	}

	public java.lang.String getWidg_hvPagamentoKO() {
		return widgHvPagamentoKO;
	}
	// HiddenValue hvPagamentoBACK

	private java.lang.String widgHvPagamentoBACK;

	public void setWidg_hvPagamentoBACK(java.lang.String value) {
		widgHvPagamentoBACK = value;
	}

	public java.lang.String getWidg_hvPagamentoBACK() {
		return widgHvPagamentoBACK;
	}

}
