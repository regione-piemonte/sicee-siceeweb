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
 * logica di business associata al Menu
 */
public class GlobalMenuModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipoRicAnnullametoSost'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipoRicAnnullametoSost(java.lang.Integer value) {
		getSession().put("appDataidTipoRicAnnullametoSost", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipoRicAnnullametoSost'
	 * @generated
	 */
	public java.lang.Integer getAppDataidTipoRicAnnullametoSost() {
		return (java.lang.Integer) (getSession().get("appDataidTipoRicAnnullametoSost"));
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
	 * imposta il valore dell' ApplicationData 'appDatacertificatiTrovati'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatiTrovati(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDatacertificatiTrovati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatiTrovati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDatacertificatiTrovati() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession().get("appDatacertificatiTrovati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodiciCertificatiSelezionati'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodiciCertificatiSelezionati(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDatacodiciCertificatiSelezionati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodiciCertificatiSelezionati'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDatacodiciCertificatiSelezionati() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDatacodiciCertificatiSelezionati"));
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

}
