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
 * logica di business associata alla Schermata [cpEsitoPagamenti]
 */
@Validation
public class CpEsitoPagamentiModel extends BaseSessionAwareDTO {

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
	@VisitorFieldValidator(message = "", key = "cpEsitoPagamenti.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatamdpURL'
	 * @param value
	 * @generated
	 */

	public void setAppDatamdpURL(java.lang.String value) {
		getSession().put("appDatamdpURL", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamdpURL'
	 * @generated
	 */
	public java.lang.String getAppDatamdpURL() {
		return (java.lang.String) (getSession().get("appDatamdpURL"));
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
	 * imposta il valore dell' ApplicationData 'appDatadatiPagamento'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpEsitoPagamenti.datiPagamento.visitorvalidator.label", appendPrefix = true)
	public void setAppDatadatiPagamento(it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento value) {
		getSession().put("appDatadatiPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiPagamento'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento getAppDatadatiPagamento() {
		return (it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento) (getSession().get("appDatadatiPagamento"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

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
	// HiddenValue hvPagamentoABORT

	private java.lang.String widgHvPagamentoABORT;

	public void setWidg_hvPagamentoABORT(java.lang.String value) {
		widgHvPagamentoABORT = value;
	}

	public java.lang.String getWidg_hvPagamentoABORT() {
		return widgHvPagamentoABORT;
	}
	// HiddenValue hvPagamentoANOMAL

	private java.lang.String widgHvPagamentoANOMAL;

	public void setWidg_hvPagamentoANOMAL(java.lang.String value) {
		widgHvPagamentoANOMAL = value;
	}

	public java.lang.String getWidg_hvPagamentoANOMAL() {
		return widgHvPagamentoANOMAL;
	}

}
