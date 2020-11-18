package it.csi.sicee.siceeweb.dto.gestcertificatore;

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
 * logica di business associata alla Schermata [cpRegistraz]
 */
@Validation
public class CpRegistrazModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuniProvincia'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniProvincia(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniProvincia", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniProvincia'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniProvincia() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession().get("appDatacomuniProvincia"));
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
	 * imposta il valore dell' ApplicationData 'appDataprovinceRegione'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceRegione(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceRegione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceRegione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceRegione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceRegione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzo'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzo(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> value) {
		getSession().put("appDatasuggestIndirizzo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> getAppDatasuggestIndirizzo() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo>) (getSession()
				.get("appDatasuggestIndirizzo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataregioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataregioni(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> value) {
		getSession().put("appDataregioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> getAppDataregioni() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione>) (getSession().get("appDataregioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRegistraz.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatacomuniResProvincia'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniResProvincia(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniResProvincia", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniResProvincia'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniResProvincia() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession()
				.get("appDatacomuniResProvincia"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuniStudioProvincia'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniStudioProvincia(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniStudioProvincia", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniStudioProvincia'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniStudioProvincia() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession()
				.get("appDatacomuniStudioProvincia"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceResRegione'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceResRegione(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceResRegione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceResRegione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceResRegione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceResRegione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceStudioRegione'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceStudioRegione(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceStudioRegione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceStudioRegione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceStudioRegione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceStudioRegione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataregioniRes'
	 * @param value
	 * @generated
	 */

	public void setAppDataregioniRes(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> value) {
		getSession().put("appDataregioniRes", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregioniRes'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> getAppDataregioniRes() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione>) (getSession().get("appDataregioniRes"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataregioniStudio'
	 * @param value
	 * @generated
	 */

	public void setAppDataregioniStudio(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> value) {
		getSession().put("appDataregioniStudio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregioniStudio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> getAppDataregioniStudio() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione>) (getSession().get("appDataregioniStudio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatitoli'
	 * @param value
	 * @generated
	 */

	public void setAppDatatitoli(java.util.ArrayList<it.csi.sicee.siceeweb.dto.certificatore.Titolo> value) {
		getSession().put("appDatatitoli", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatitoli'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.certificatore.Titolo> getAppDatatitoli() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.certificatore.Titolo>) (getSession()
				.get("appDatatitoli"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceOrdinePiemonte'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceOrdinePiemonte(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceOrdinePiemonte", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceOrdinePiemonte'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceOrdinePiemonte() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceOrdinePiemonte"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiPagamento'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRegistraz.datiPagamento.visitorvalidator.label", appendPrefix = true)
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
	 * @generated
	 */
	private java.lang.Integer appDatasuggestIndirizzoCode = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCode'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCode(java.lang.Integer value) {
		appDatasuggestIndirizzoCode = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCode'
	 * @generated
	 */
	public java.lang.Integer getAppDatasuggestIndirizzoCode() {
		return appDatasuggestIndirizzoCode;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodiceIstruzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodiceIstruzione(java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.Istruzione> value) {
		getSession().put("appDatacodiceIstruzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodiceIstruzione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.Istruzione> getAppDatacodiceIstruzione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.Istruzione>) (getSession()
				.get("appDatacodiceIstruzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoIstruzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoIstruzione(java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.Istruzione> value) {
		getSession().put("appDatatipoIstruzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoIstruzione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.Istruzione> getAppDatatipoIstruzione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.Istruzione>) (getSession()
				.get("appDatatipoIstruzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatauidDaStampare'
	 * @param value
	 * @generated
	 */

	public void setAppDatauidDaStampare(java.lang.String value) {
		getSession().put("appDatauidDaStampare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatauidDaStampare'
	 * @generated
	 */
	public java.lang.String getAppDatauidDaStampare() {
		return (java.lang.String) (getSession().get("appDatauidDaStampare"));
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
	 * imposta il valore dell' ApplicationData 'appDatachiaviAttPartOld'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviAttPartOld(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.DocumentSummary> value) {
		getSession().put("appDatachiaviAttPartOld", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviAttPartOld'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.DocumentSummary> getAppDatachiaviAttPartOld() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.DocumentSummary>) (getSession()
				.get("appDatachiaviAttPartOld"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatachiaviAttPartNew'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviAttPartNew(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CorsoAttestatoSummary> value) {
		getSession().put("appDatachiaviAttPartNew", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviAttPartNew'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CorsoAttestatoSummary> getAppDatachiaviAttPartNew() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CorsoAttestatoSummary>) (getSession()
				.get("appDatachiaviAttPartNew"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidCorsoSelected'
	 * @param value
	 * @generated
	 */

	public void setAppDataidCorsoSelected(java.lang.String value) {
		getSession().put("appDataidCorsoSelected", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidCorsoSelected'
	 * @generated
	 */
	public java.lang.String getAppDataidCorsoSelected() {
		return (java.lang.String) (getSession().get("appDataidCorsoSelected"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatachiaviTitoloStudio'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviTitoloStudio(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.DocumentSummary> value) {
		getSession().put("appDatachiaviTitoloStudio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviTitoloStudio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.DocumentSummary> getAppDatachiaviTitoloStudio() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.commons.DocumentSummary>) (getSession()
				.get("appDatachiaviTitoloStudio"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblTitoloStudioSummary

	private java.lang.String widgTblTitoloStudioSummary;

	public void setWidg_tblTitoloStudioSummary(java.lang.String value) {
		widgTblTitoloStudioSummary = value;
	}

	public java.lang.String getWidg_tblTitoloStudioSummary() {
		return widgTblTitoloStudioSummary;
	}

	// FileUpload widg_attTitoloStudio
	private File widgAttTitoloStudio; // The actual file(s)
	private String widgAttTitoloStudioContentType; // The content type of the file(s) 
	private String widgAttTitoloStudioFileName; // The uploaded file(s) name and path 

	public void setWidg_attTitoloStudio(File value) {
		widgAttTitoloStudio = value;
	}
	@JSON(include = false)
	public File getWidg_attTitoloStudio() {
		return widgAttTitoloStudio;
	}

	public void setWidg_attTitoloStudioContentType(String value) {
		widgAttTitoloStudioContentType = value;
	}
	@JSON(include = false)
	public String getWidg_attTitoloStudioContentType() {
		return widgAttTitoloStudioContentType;
	}

	public void setWidg_attTitoloStudioFileName(String value) {
		widgAttTitoloStudioFileName = value;
	}
	@JSON(include = false)
	public String getWidg_attTitoloStudioFileName() {
		return widgAttTitoloStudioFileName;
	}

	// FileUpload widg_attPartNew
	private File widgAttPartNew; // The actual file(s)
	private String widgAttPartNewContentType; // The content type of the file(s) 
	private String widgAttPartNewFileName; // The uploaded file(s) name and path 

	public void setWidg_attPartNew(File value) {
		widgAttPartNew = value;
	}
	@JSON(include = false)
	public File getWidg_attPartNew() {
		return widgAttPartNew;
	}

	public void setWidg_attPartNewContentType(String value) {
		widgAttPartNewContentType = value;
	}
	@JSON(include = false)
	public String getWidg_attPartNewContentType() {
		return widgAttPartNewContentType;
	}

	public void setWidg_attPartNewFileName(String value) {
		widgAttPartNewFileName = value;
	}
	@JSON(include = false)
	public String getWidg_attPartNewFileName() {
		return widgAttPartNewFileName;
	}

	// Table tblAttPartOldSummary

	private java.lang.String widgTblAttPartOldSummary;

	public void setWidg_tblAttPartOldSummary(java.lang.String value) {
		widgTblAttPartOldSummary = value;
	}

	public java.lang.String getWidg_tblAttPartOldSummary() {
		return widgTblAttPartOldSummary;
	}

	// HiddenValue hvPagamentoOK

	private java.lang.String widgHvPagamentoOK;

	public void setWidg_hvPagamentoOK(java.lang.String value) {
		widgHvPagamentoOK = value;
	}

	public java.lang.String getWidg_hvPagamentoOK() {
		return widgHvPagamentoOK;
	}

}
