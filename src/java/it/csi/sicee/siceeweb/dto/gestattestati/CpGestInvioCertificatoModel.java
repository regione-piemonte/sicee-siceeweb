package it.csi.sicee.siceeweb.dto.gestattestati;

import java.io.File;
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
 * logica di business associata alla Schermata [cpGestInvioCertificato]
 */
@Validation
public class CpGestInvioCertificatoModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpGestInvioCertificato.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatadichiarazioneAceSostitutivo'
	 * @param value
	 * @generated
	 */

	public void setAppDatadichiarazioneAceSostitutivo(java.lang.String value) {
		getSession().put("appDatadichiarazioneAceSostitutivo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadichiarazioneAceSostitutivo'
	 * @generated
	 */
	public java.lang.String getAppDatadichiarazioneAceSostitutivo() {
		return (java.lang.String) (getSession().get("appDatadichiarazioneAceSostitutivo"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fileAttestato
	private File widgFileAttestato; // The actual file(s)
	private String widgFileAttestatoContentType; // The content type of the file(s) 
	private String widgFileAttestatoFileName; // The uploaded file(s) name and path 

	public void setWidg_fileAttestato(File value) {
		widgFileAttestato = value;
	}
	@JSON(include = false)
	public File getWidg_fileAttestato() {
		return widgFileAttestato;
	}

	public void setWidg_fileAttestatoContentType(String value) {
		widgFileAttestatoContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fileAttestatoContentType() {
		return widgFileAttestatoContentType;
	}

	public void setWidg_fileAttestatoFileName(String value) {
		widgFileAttestatoFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fileAttestatoFileName() {
		return widgFileAttestatoFileName;
	}

}
