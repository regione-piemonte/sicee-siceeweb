package it.csi.sicee.siceeweb.dto.compilazattestatiape;

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
 * logica di business associata alla Schermata [cpZonaClima]
 */
@Validation
public class CpZonaClimaModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataaceList'
	 * @param value
	 * @generated
	 */

	public void setAppDataaceList(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDataaceList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaceList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDataaceList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession().get("appDataaceList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAce'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAce(it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce value) {
		getSession().put("appDataricercaAce", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAce'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce getAppDataricercaAce() {
		return (it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce) (getSession().get("appDataricercaAce"));
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
	 * imposta il valore dell' ApplicationData 'appDatacodAceSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodAceSelezionato(java.lang.String value) {
		getSession().put("appDatacodAceSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodAceSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodAceSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodAceSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaceSostituzioneList'
	 * @param value
	 * @generated
	 */

	public void setAppDataaceSostituzioneList(java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> value) {
		getSession().put("appDataaceSostituzioneList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaceSostituzioneList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace> getAppDataaceSostituzioneList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.Ace>) (getSession()
				.get("appDataaceSostituzioneList"));
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

	/**
	 * imposta il valore dell' ApplicationData 'appDatamsgGenerico'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgGenerico(java.lang.String value) {
		getSession().put("appDatamsgGenerico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgGenerico'
	 * @generated
	 */
	public java.lang.String getAppDatamsgGenerico() {
		return (java.lang.String) (getSession().get("appDatamsgGenerico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataemailInvioApe'
	 * @param value
	 * @generated
	 */

	public void setAppDataemailInvioApe(java.lang.String value) {
		getSession().put("appDataemailInvioApe", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataemailInvioApe'
	 * @generated
	 */
	public java.lang.String getAppDataemailInvioApe() {
		return (java.lang.String) (getSession().get("appDataemailInvioApe"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpZonaClima.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatadocumentoAggiuntivo'
	 * @param value
	 * @generated
	 */

	public void setAppDatadocumentoAggiuntivo(it.csi.sicee.siceeweb.dto.ace.DocumentoAggiuntivo value) {
		getSession().put("appDatadocumentoAggiuntivo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadocumentoAggiuntivo'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.ace.DocumentoAggiuntivo getAppDatadocumentoAggiuntivo() {
		return (it.csi.sicee.siceeweb.dto.ace.DocumentoAggiuntivo) (getSession().get("appDatadocumentoAggiuntivo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDocumentoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDocumentoSelezionato(java.lang.Integer value) {
		getSession().put("appDataidDocumentoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDocumentoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidDocumentoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidDocumentoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistDocumentazioneAggiuntiva'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistDocumentazioneAggiuntiva(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.DocumentoAggiuntivo> value) {
		getSession().put("appDatalistDocumentazioneAggiuntiva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistDocumentazioneAggiuntiva'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.DocumentoAggiuntivo> getAppDatalistDocumentazioneAggiuntiva() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.ace.DocumentoAggiuntivo>) (getSession()
				.get("appDatalistDocumentazioneAggiuntiva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatauidDocumentoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatauidDocumentoSelezionato(java.lang.String value) {
		getSession().put("appDatauidDocumentoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatauidDocumentoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatauidDocumentoSelezionato() {
		return (java.lang.String) (getSession().get("appDatauidDocumentoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistTipiDoc'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistTipiDoc(java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> value) {
		getSession().put("appDatalistTipiDoc", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistTipiDoc'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> getAppDatalistTipiDoc() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue>) (getSession().get("appDatalistTipiDoc"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipoDocumento'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipoDocumento(java.lang.String value) {
		getSession().put("appDataidTipoDocumento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipoDocumento'
	 * @generated
	 */
	public java.lang.String getAppDataidTipoDocumento() {
		return (java.lang.String) (getSession().get("appDataidTipoDocumento"));
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
	 * imposta il valore dell' ApplicationData 'appDatalistZoneClima'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistZoneClima(java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> value) {
		getSession().put("appDatalistZoneClima", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistZoneClima'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> getAppDatalistZoneClima() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue>) (getSession().get("appDatalistZoneClima"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneZonaClima'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneZonaClima(java.lang.String value) {
		getSession().put("appDataidComuneZonaClima", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneZonaClima'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneZonaClima() {
		return (java.lang.String) (getSession().get("appDataidComuneZonaClima"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadescZonaClima'
	 * @param value
	 * @generated
	 */

	public void setAppDatadescZonaClima(java.lang.String value) {
		getSession().put("appDatadescZonaClima", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadescZonaClima'
	 * @generated
	 */
	public java.lang.String getAppDatadescZonaClima() {
		return (java.lang.String) (getSession().get("appDatadescZonaClima"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
