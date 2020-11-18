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
 * logica di business associata alla Schermata [cpPagamentoDettNew]
 */
@Validation
public class CpPagamentoDettNewModel extends BaseSessionAwareDTO {

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
	@VisitorFieldValidator(message = "", key = "cpPagamentoDettNew.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatagestoriPagamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatagestoriPagamento(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.pagamenti.GestorePagamento> value) {
		getSession().put("appDatagestoriPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatagestoriPagamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.pagamenti.GestorePagamento> getAppDatagestoriPagamento() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.pagamenti.GestorePagamento>) (getSession()
				.get("appDatagestoriPagamento"));
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
