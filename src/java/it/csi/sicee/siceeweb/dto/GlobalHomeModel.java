package it.csi.sicee.siceeweb.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.sicee.siceeweb.dto.ace.*;
import it.csi.sicee.siceeweb.dto.attestati.*;
import it.csi.sicee.siceeweb.dto.certificatore.*;
import it.csi.sicee.siceeweb.dto.geo.*;
import it.csi.sicee.siceeweb.dto.pagamenti.*;
import it.csi.sicee.siceeweb.dto.daticert.*;
import it.csi.sicee.siceeweb.dto.transazioni.*;
import it.csi.sicee.siceeweb.dto.annullamento.*;
import it.csi.sicee.siceeweb.dto.commons.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla OnInit action
 */
public class GlobalHomeModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataflagDatiPers'
	 * @param value
	 * @generated
	 */

	public void setAppDataflagDatiPers(java.lang.Boolean value) {
		getSession().put("appDataflagDatiPers", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataflagDatiPers'
	 * @generated
	 */
	public java.lang.Boolean getAppDataflagDatiPers() {
		return (java.lang.Boolean) (getSession().get("appDataflagDatiPers"));
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
	 * imposta il valore dell' ApplicationData 'appDataisPulireTab'
	 * @param value
	 * @generated
	 */

	public void setAppDataisPulireTab(java.lang.Boolean value) {
		getSession().put("appDataisPulireTab", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisPulireTab'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisPulireTab() {
		return (java.lang.Boolean) (getSession().get("appDataisPulireTab"));
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
	 * imposta il valore dell' ApplicationData 'appDataswitchPagamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataswitchPagamento(java.lang.String value) {
		getSession().put("appDataswitchPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataswitchPagamento'
	 * @generated
	 */
	public java.lang.String getAppDataswitchPagamento() {
		return (java.lang.String) (getSession().get("appDataswitchPagamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamailVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDatamailVerifica(java.lang.String value) {
		getSession().put("appDatamailVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamailVerifica'
	 * @generated
	 */
	public java.lang.String getAppDatamailVerifica() {
		return (java.lang.String) (getSession().get("appDatamailVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacerificatore'
	 * @param value
	 * @generated
	 */

	public void setAppDatacerificatore(it.csi.sicee.siceeweb.dto.certificatore.DatiOrdine value) {
		getSession().put("appDatacerificatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacerificatore'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiOrdine getAppDatacerificatore() {
		return (it.csi.sicee.siceeweb.dto.certificatore.DatiOrdine) (getSession().get("appDatacerificatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */

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
	 * imposta il valore dell' ApplicationData 'appDataflagAutocert'
	 * @param value
	 * @generated
	 */

	public void setAppDataflagAutocert(java.lang.Boolean value) {
		getSession().put("appDataflagAutocert", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataflagAutocert'
	 * @generated
	 */
	public java.lang.Boolean getAppDataflagAutocert() {
		return (java.lang.Boolean) (getSession().get("appDataflagAutocert"));
	}

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
	 * Activation Param [tranId]
	 * @generated
	 */
	private java.lang.String tranId = null;

	/**
	 * imposta il valore dell' Activation Param [tranId]
	 * @praram val
	 * @generated
	 */
	public void setTranId(java.lang.String val) {
		tranId = val;
	}

	/**
	 * legge il valore dell' Activation Param [tranId]
	 * @generated
	 */
	public java.lang.String getTranId() {
		return tranId;
	}

	/**
	 * Activation Param [auth]
	 * @generated
	 */
	private java.lang.String auth = null;

	/**
	 * imposta il valore dell' Activation Param [auth]
	 * @praram val
	 * @generated
	 */
	public void setAuth(java.lang.String val) {
		auth = val;
	}

	/**
	 * legge il valore dell' Activation Param [auth]
	 * @generated
	 */
	public java.lang.String getAuth() {
		return auth;
	}

	/**
	 * Activation Param [transactionId]
	 * @generated
	 */
	private java.lang.String transactionId = null;

	/**
	 * imposta il valore dell' Activation Param [transactionId]
	 * @praram val
	 * @generated
	 */
	public void setTransactionId(java.lang.String val) {
		transactionId = val;
	}

	/**
	 * legge il valore dell' Activation Param [transactionId]
	 * @generated
	 */
	public java.lang.String getTransactionId() {
		return transactionId;
	}

	/**
	 * Activation Param [esito]
	 * @generated
	 */
	private java.lang.String esito = null;

	/**
	 * imposta il valore dell' Activation Param [esito]
	 * @praram val
	 * @generated
	 */
	public void setEsito(java.lang.String val) {
		esito = val;
	}

	/**
	 * legge il valore dell' Activation Param [esito]
	 * @generated
	 */
	public java.lang.String getEsito() {
		return esito;
	}

}
