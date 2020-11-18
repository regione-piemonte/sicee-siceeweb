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
 * logica di business associata alla Schermata [cpRisultatoRicercaAce]
 */
@Validation
public class CpRisultatoRicercaAceModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDatacerificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRisultatoRicercaAce.cerificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatacodAttestatoDaStampare'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodAttestatoDaStampare(java.lang.String value) {
		getSession().put("appDatacodAttestatoDaStampare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodAttestatoDaStampare'
	 * @generated
	 */
	public java.lang.String getAppDatacodAttestatoDaStampare() {
		return (java.lang.String) (getSession().get("appDatacodAttestatoDaStampare"));
	}

	/**
	 * @generated
	 */
	private java.lang.String appDataparametroDiRequest = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDataparametroDiRequest'
	 * @param value
	 * @generated
	 */

	public void setAppDataparametroDiRequest(java.lang.String value) {
		appDataparametroDiRequest = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataparametroDiRequest'
	 * @generated
	 */
	public java.lang.String getAppDataparametroDiRequest() {
		return appDataparametroDiRequest;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRisultatoRicercaAce.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDataprovenienzaPerReport'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovenienzaPerReport(java.lang.String value) {
		getSession().put("appDataprovenienzaPerReport", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovenienzaPerReport'
	 * @generated
	 */
	public java.lang.String getAppDataprovenienzaPerReport() {
		return (java.lang.String) (getSession().get("appDataprovenienzaPerReport"));
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
	 * imposta il valore dell' ApplicationData 'appDatatempDtCatastaliSecondari'
	 * @param value
	 * @generated
	 */

	public void setAppDatatempDtCatastaliSecondari(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari> value) {
		getSession().put("appDatatempDtCatastaliSecondari", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatempDtCatastaliSecondari'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari> getAppDatatempDtCatastaliSecondari() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari>) (getSession()
				.get("appDatatempDtCatastaliSecondari"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatempRaccomandazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDatatempRaccomandazioni(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione> value) {
		getSession().put("appDatatempRaccomandazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatempRaccomandazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione> getAppDatatempRaccomandazioni() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione>) (getSession()
				.get("appDatatempRaccomandazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatempDichiarazSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDatatempDichiarazSelez(java.lang.Integer value) {
		getSession().put("appDatatempDichiarazSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatempDichiarazSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDatatempDichiarazSelez() {
		return (java.lang.Integer) (getSession().get("appDatatempDichiarazSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatiSostituiti'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatiSostituiti(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDatacertificatiSostituiti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatiSostituiti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDatacertificatiSostituiti() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession()
				.get("appDatacertificatiSostituiti"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
