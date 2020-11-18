package it.csi.sicee.siceeweb.dto.annullasostcert;

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
 * logica di business associata alla Schermata [cpRiepilogoAceAnnullaSost]
 */
@Validation
public class CpRiepilogoAceAnnullaSostModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatacodiceCertificatoDaSostituireSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodiceCertificatoDaSostituireSelezionato(java.lang.String value) {
		getSession().put("appDatacodiceCertificatoDaSostituireSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodiceCertificatoDaSostituireSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodiceCertificatoDaSostituireSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodiceCertificatoDaSostituireSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodiceCertificatoSostitutivoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodiceCertificatoSostitutivoSelezionato(java.lang.String value) {
		getSession().put("appDatacodiceCertificatoSostitutivoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodiceCertificatoSostitutivoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodiceCertificatoSostitutivoSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodiceCertificatoSostitutivoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisPrimoIngresso'
	 * @param value
	 * @generated
	 */

	public void setAppDataisPrimoIngresso(java.lang.Boolean value) {
		getSession().put("appDataisPrimoIngresso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisPrimoIngresso'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisPrimoIngresso() {
		return (java.lang.Boolean) (getSession().get("appDataisPrimoIngresso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacarrelloAceOld'
	 * @param value
	 * @generated
	 */

	public void setAppDatacarrelloAceOld(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDatacarrelloAceOld", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacarrelloAceOld'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDatacarrelloAceOld() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession().get("appDatacarrelloAceOld"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacarrelloAceNew'
	 * @param value
	 * @generated
	 */

	public void setAppDatacarrelloAceNew(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDatacarrelloAceNew", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacarrelloAceNew'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDatacarrelloAceNew() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession().get("appDatacarrelloAceNew"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiAnnullamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiAnnullamento(it.csi.sicee.siceeweb.dto.annullamento.DtAnnullamento value) {
		getSession().put("appDatadatiAnnullamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiAnnullamento'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.annullamento.DtAnnullamento getAppDatadatiAnnullamento() {
		return (it.csi.sicee.siceeweb.dto.annullamento.DtAnnullamento) (getSession().get("appDatadatiAnnullamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRiepilogoAceAnnullaSost.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatapaginaProvenienza'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaProvenienza(java.lang.String value) {
		getSession().put("appDatapaginaProvenienza", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaProvenienza'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaProvenienza() {
		return (java.lang.String) (getSession().get("appDatapaginaProvenienza"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
