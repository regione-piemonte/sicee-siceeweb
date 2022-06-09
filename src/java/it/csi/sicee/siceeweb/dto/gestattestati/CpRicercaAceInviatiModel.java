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
 * logica di business associata alla Schermata [cpRicercaAceInviati]
 */
@Validation
public class CpRicercaAceInviatiModel extends BaseSessionAwareDTO {

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
	 * @generated
	 */
	private it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce appDatafiltroAce = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDatafiltroAce'
	 * @param value
	 * @generated
	 */

	public void setAppDatafiltroAce(it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce value) {
		appDatafiltroAce = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafiltroAce'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce getAppDatafiltroAce() {
		return appDatafiltroAce;
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> appDatacomuni = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>();

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuni'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuni(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		appDatacomuni = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuni() {
		return appDatacomuni;
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> appDataprovince = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>();

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovince'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovince(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		appDataprovince = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovince() {
		return appDataprovince;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatiInviati'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatiInviati(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDatacertificatiInviati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatiInviati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDatacertificatiInviati() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession().get("appDatacertificatiInviati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRicercaAceInviati.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDataidRigaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidRigaSelezionata(java.lang.Integer value) {
		getSession().put("appDataidRigaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidRigaSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidRigaSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidRigaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodAttestatoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodAttestatoSelezionato(java.lang.String value) {
		getSession().put("appDatacodAttestatoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodAttestatoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodAttestatoSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodAttestatoSelezionato"));
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
