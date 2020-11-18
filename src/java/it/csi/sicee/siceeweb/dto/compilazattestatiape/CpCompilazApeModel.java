package it.csi.sicee.siceeweb.dto.compilazattestatiape;

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
 * logica di business associata alla Schermata [cpCompilazApe]
 */
@Validation
public class CpCompilazApeModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataprovinceCertDTCat'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceCertDTCat(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceCertDTCat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceCertDTCat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceCertDTCat() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceCertDTCat"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuniCertDtCat'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniCertDtCat(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniCertDtCat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniCertDtCat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniCertDtCat() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession().get("appDatacomuniCertDtCat"));
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
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoDtCat'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoDtCat(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> value) {
		getSession().put("appDatasuggestIndirizzoDtCat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoDtCat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> getAppDatasuggestIndirizzoDtCat() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo>) (getSession()
				.get("appDatasuggestIndirizzoDtCat"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpCompilazApe.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatafotoSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDatafotoSelezionata(java.lang.String value) {
		getSession().put("appDatafotoSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafotoSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDatafotoSelezionata() {
		return (java.lang.String) (getSession().get("appDatafotoSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoFoto'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoFoto(java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtTipoFoto> value) {
		getSession().put("appDatatipoFoto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoFoto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtTipoFoto> getAppDatatipoFoto() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtTipoFoto>) (getSession()
				.get("appDatatipoFoto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoFotoSel'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoFotoSel(java.lang.Integer value) {
		getSession().put("appDatatipoFotoSel", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoFotoSel'
	 * @generated
	 */
	public java.lang.Integer getAppDatatipoFotoSel() {
		return (java.lang.Integer) (getSession().get("appDatatipoFotoSel"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoFotoAltreSel'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoFotoAltreSel(java.lang.Integer value) {
		getSession().put("appDatatipoFotoAltreSel", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoFotoAltreSel'
	 * @generated
	 */
	public java.lang.Integer getAppDatatipoFotoAltreSel() {
		return (java.lang.Integer) (getSession().get("appDatatipoFotoAltreSel"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraRicerca'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraRicerca(it.csi.sicee.siceeweb.dto.attestati.VisuraRicerca value) {
		getSession().put("appDatavisuraRicerca", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraRicerca'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.attestati.VisuraRicerca getAppDatavisuraRicerca() {
		return (it.csi.sicee.siceeweb.dto.attestati.VisuraRicerca) (getSession().get("appDatavisuraRicerca"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraCodImpiantoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraCodImpiantoSelez(java.lang.Integer value) {
		getSession().put("appDatavisuraCodImpiantoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraCodImpiantoSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDatavisuraCodImpiantoSelez() {
		return (java.lang.Integer) (getSession().get("appDatavisuraCodImpiantoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraImpianto(it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto value) {
		getSession().put("appDatavisuraImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraImpianto'
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto getAppDatavisuraImpianto() {
		return (it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto) (getSession().get("appDatavisuraImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraImpiantoList'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraImpiantoList(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto> value) {
		getSession().put("appDatavisuraImpiantoList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraImpiantoList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto> getAppDatavisuraImpiantoList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto>) (getSession()
				.get("appDatavisuraImpiantoList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraRappControlloList'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraRappControlloList(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo> value) {
		getSession().put("appDatavisuraRappControlloList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraRappControlloList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo> getAppDatavisuraRappControlloList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo>) (getSession()
				.get("appDatavisuraRappControlloList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraRifCatastaleList'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraRifCatastaleList(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale> value) {
		getSession().put("appDatavisuraRifCatastaleList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraRifCatastaleList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale> getAppDatavisuraRifCatastaleList() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale>) (getSession()
				.get("appDatavisuraRifCatastaleList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavisuraUidLibrettoDaStampare'
	 * @param value
	 * @generated
	 */

	public void setAppDatavisuraUidLibrettoDaStampare(java.lang.String value) {
		getSession().put("appDatavisuraUidLibrettoDaStampare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavisuraUidLibrettoDaStampare'
	 * @generated
	 */
	public java.lang.String getAppDatavisuraUidLibrettoDaStampare() {
		return (java.lang.String) (getSession().get("appDatavisuraUidLibrettoDaStampare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipolCostrutt'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipolCostrutt(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> value) {
		getSession().put("appDatatipolCostrutt", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipolCostrutt'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> getAppDatatipolCostrutt() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie>) (getSession()
				.get("appDatatipolCostrutt"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipolEdilizia'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipolEdilizia(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> value) {
		getSession().put("appDatatipolEdilizia", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipolEdilizia'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> getAppDatatipolEdilizia() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie>) (getSession()
				.get("appDatatipolEdilizia"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoRistrutt'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoRistrutt(java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> value) {
		getSession().put("appDatatipoRistrutt", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoRistrutt'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> getAppDatatipoRistrutt() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie>) (getSession()
				.get("appDatatipoRistrutt"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataproprEdificio'
	 * @param value
	 * @generated
	 */

	public void setAppDataproprEdificio(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> value) {
		getSession().put("appDataproprEdificio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataproprEdificio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> getAppDataproprEdificio() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie>) (getSession()
				.get("appDataproprEdificio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaCf'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaCf(java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtListaCf> value) {
		getSession().put("appDatalistaCf", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaCf'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtListaCf> getAppDatalistaCf() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtListaCf>) (getSession().get("appDatalistaCf"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacfSel'
	 * @param value
	 * @generated
	 */

	public void setAppDatacfSel(java.lang.String value) {
		getSession().put("appDatacfSel", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacfSel'
	 * @generated
	 */
	public java.lang.String getAppDatacfSel() {
		return (java.lang.String) (getSession().get("appDatacfSel"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamotiviRilascio'
	 * @param value
	 * @generated
	 */

	public void setAppDatamotiviRilascio(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.MotivoRilascio> value) {
		getSession().put("appDatamotiviRilascio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamotiviRilascio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.MotivoRilascio> getAppDatamotiviRilascio() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.MotivoRilascio>) (getSession()
				.get("appDatamotiviRilascio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataoggettiApeLista'
	 * @param value
	 * @generated
	 */

	public void setAppDataoggettiApeLista(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> value) {
		getSession().put("appDataoggettiApeLista", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataoggettiApeLista'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie> getAppDataoggettiApeLista() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologie>) (getSession()
				.get("appDataoggettiApeLista"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataserviziEnergia'
	 * @param value
	 * @generated
	 */

	public void setAppDataserviziEnergia(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.MotivoRilascio> value) {
		getSession().put("appDataserviziEnergia", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataserviziEnergia'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.MotivoRilascio> getAppDataserviziEnergia() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.MotivoRilascio>) (getSession()
				.get("appDataserviziEnergia"));
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
	 * imposta il valore dell' ApplicationData 'appDatarifCatasto'
	 * @param value
	 * @generated
	 */

	public void setAppDatarifCatasto(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologieCod> value) {
		getSession().put("appDatarifCatasto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarifCatasto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologieCod> getAppDatarifCatasto() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.daticert.DtDecodTipologieCod>) (getSession()
				.get("appDatarifCatasto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadichiarazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDatadichiarazioni(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Dichiarazione> value) {
		getSession().put("appDatadichiarazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadichiarazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Dichiarazione> getAppDatadichiarazioni() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Dichiarazione>) (getSession()
				.get("appDatadichiarazioni"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fileFotoCatasto
	private File widgFileFotoCatasto; // The actual file(s)
	private String widgFileFotoCatastoContentType; // The content type of the file(s) 
	private String widgFileFotoCatastoFileName; // The uploaded file(s) name and path 

	public void setWidg_fileFotoCatasto(File value) {
		widgFileFotoCatasto = value;
	}
	@JSON(include = false)
	public File getWidg_fileFotoCatasto() {
		return widgFileFotoCatasto;
	}

	public void setWidg_fileFotoCatastoContentType(String value) {
		widgFileFotoCatastoContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fileFotoCatastoContentType() {
		return widgFileFotoCatastoContentType;
	}

	public void setWidg_fileFotoCatastoFileName(String value) {
		widgFileFotoCatastoFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fileFotoCatastoFileName() {
		return widgFileFotoCatastoFileName;
	}

	// FileUpload widg_fileFotoCatastoAltre
	private File widgFileFotoCatastoAltre; // The actual file(s)
	private String widgFileFotoCatastoAltreContentType; // The content type of the file(s) 
	private String widgFileFotoCatastoAltreFileName; // The uploaded file(s) name and path 

	public void setWidg_fileFotoCatastoAltre(File value) {
		widgFileFotoCatastoAltre = value;
	}
	@JSON(include = false)
	public File getWidg_fileFotoCatastoAltre() {
		return widgFileFotoCatastoAltre;
	}

	public void setWidg_fileFotoCatastoAltreContentType(String value) {
		widgFileFotoCatastoAltreContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fileFotoCatastoAltreContentType() {
		return widgFileFotoCatastoAltreContentType;
	}

	public void setWidg_fileFotoCatastoAltreFileName(String value) {
		widgFileFotoCatastoAltreFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fileFotoCatastoAltreFileName() {
		return widgFileFotoCatastoAltreFileName;
	}

}
