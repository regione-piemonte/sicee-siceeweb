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
 * logica di business associata alla Schermata [cpAnnullaSostAceHome]
 */
@Validation
public class CpAnnullaSostAceHomeModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatamotiviAnnullamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatamotiviAnnullamento(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.annullamento.MotivoAnnullamento> value) {
		getSession().put("appDatamotiviAnnullamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamotiviAnnullamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.annullamento.MotivoAnnullamento> getAppDatamotiviAnnullamento() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.annullamento.MotivoAnnullamento>) (getSession()
				.get("appDatamotiviAnnullamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpAnnullaSostAceHome.certificatore.visitorvalidator.label", appendPrefix = true)
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
