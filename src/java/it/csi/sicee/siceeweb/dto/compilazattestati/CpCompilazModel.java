package it.csi.sicee.siceeweb.dto.compilazattestati;

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
 * logica di business associata alla Schermata [cpCompilaz]
 */
@Validation
public class CpCompilazModel extends BaseSessionAwareDTO {

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
	@VisitorFieldValidator(message = "", key = "cpCompilaz.certificatore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatacomuniCertCostr'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniCertCostr(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniCertCostr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniCertCostr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniCertCostr() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession().get("appDatacomuniCertCostr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuniCertDirLav'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniCertDirLav(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniCertDirLav", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniCertDirLav'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniCertDirLav() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession()
				.get("appDatacomuniCertDirLav"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuniCertProgettista'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniCertProgettista(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniCertProgettista", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniCertProgettista'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniCertProgettista() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession()
				.get("appDatacomuniCertProgettista"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceCertCostr'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceCertCostr(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceCertCostr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceCertCostr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceCertCostr() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceCertCostr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceCertDirLav'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceCertDirLav(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceCertDirLav", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceCertDirLav'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceCertDirLav() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceCertDirLav"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceCertProgettista'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceCertProgettista(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> value) {
		getSession().put("appDataprovinceCertProgettista", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceCertProgettista'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia> getAppDataprovinceCertProgettista() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Provincia>) (getSession()
				.get("appDataprovinceCertProgettista"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataregioniCertCostr'
	 * @param value
	 * @generated
	 */

	public void setAppDataregioniCertCostr(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> value) {
		getSession().put("appDataregioniCertCostr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregioniCertCostr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> getAppDataregioniCertCostr() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione>) (getSession()
				.get("appDataregioniCertCostr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataregioniCertDirLav'
	 * @param value
	 * @generated
	 */

	public void setAppDataregioniCertDirLav(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> value) {
		getSession().put("appDataregioniCertDirLav", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregioniCertDirLav'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> getAppDataregioniCertDirLav() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione>) (getSession()
				.get("appDataregioniCertDirLav"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataregioniCertProgettista'
	 * @param value
	 * @generated
	 */

	public void setAppDataregioniCertProgettista(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> value) {
		getSession().put("appDataregioniCertProgettista", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregioniCertProgettista'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione> getAppDataregioniCertProgettista() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Regione>) (getSession()
				.get("appDataregioniCertProgettista"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataclassiEnergetiche'
	 * @param value
	 * @generated
	 */

	public void setAppDataclassiEnergetiche(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.ClasseEnerg> value) {
		getSession().put("appDataclassiEnergetiche", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataclassiEnergetiche'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.ClasseEnerg> getAppDataclassiEnergetiche() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.ClasseEnerg>) (getSession()
				.get("appDataclassiEnergetiche"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadestinazioniUso'
	 * @param value
	 * @generated
	 */

	public void setAppDatadestinazioniUso(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.DestUso> value) {
		getSession().put("appDatadestinazioniUso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadestinazioniUso'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.DestUso> getAppDatadestinazioniUso() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.DestUso>) (getSession()
				.get("appDatadestinazioniUso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipologieImmobili'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipologieImmobili(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoImmobile> value) {
		getSession().put("appDatatipologieImmobili", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipologieImmobili'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoImmobile> getAppDatatipologieImmobili() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoImmobile>) (getSession()
				.get("appDatatipologieImmobili"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasistemi'
	 * @param value
	 * @generated
	 */

	public void setAppDatasistemi(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Sistema> value) {
		getSession().put("appDatasistemi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasistemi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Sistema> getAppDatasistemi() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Sistema>) (getSession().get("appDatasistemi"));
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
	 * imposta il valore dell' ApplicationData 'appDatatipiRedazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiRedazione(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoRedazione> value) {
		getSession().put("appDatatipiRedazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiRedazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoRedazione> getAppDatatipiRedazione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoRedazione>) (getSession()
				.get("appDatatipiRedazione"));
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
	 * imposta il valore dell' ApplicationData 'appDatatipiCombustibileRiscaldamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiCombustibileRiscaldamento(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoCombustibile> value) {
		getSession().put("appDatatipiCombustibileRiscaldamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiCombustibileRiscaldamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoCombustibile> getAppDatatipiCombustibileRiscaldamento() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoCombustibile>) (getSession()
				.get("appDatatipiCombustibileRiscaldamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipiImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiImpianto(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoImpianto> value) {
		getSession().put("appDatatipiImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiImpianto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoImpianto> getAppDatatipiImpianto() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoImpianto>) (getSession()
				.get("appDatatipiImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipiRegolazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiRegolazione(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoRegolaz> value) {
		getSession().put("appDatatipiRegolazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiRegolazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoRegolaz> getAppDatatipiRegolazione() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoRegolaz>) (getSession()
				.get("appDatatipiRegolazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipiDistrib'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiDistrib(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoDistrib> value) {
		getSession().put("appDatatipiDistrib", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiDistrib'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoDistrib> getAppDatatipiDistrib() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoDistrib>) (getSession()
				.get("appDatatipiDistrib"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipiTermErogaz'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiTermErogaz(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoTermErogaz> value) {
		getSession().put("appDatatipiTermErogaz", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiTermErogaz'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoTermErogaz> getAppDatatipiTermErogaz() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoTermErogaz>) (getSession()
				.get("appDatatipiTermErogaz"));
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
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCertCostr'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCertCostr(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> value) {
		getSession().put("appDatasuggestIndirizzoCertCostr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCertCostr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> getAppDatasuggestIndirizzoCertCostr() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo>) (getSession()
				.get("appDatasuggestIndirizzoCertCostr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCertDirLav'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCertDirLav(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> value) {
		getSession().put("appDatasuggestIndirizzoCertDirLav", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCertDirLav'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> getAppDatasuggestIndirizzoCertDirLav() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo>) (getSession()
				.get("appDatasuggestIndirizzoCertDirLav"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCertProgettista'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCertProgettista(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> value) {
		getSession().put("appDatasuggestIndirizzoCertProgettista", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCertProgettista'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo> getAppDatasuggestIndirizzoCertProgettista() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Indirizzo>) (getSession()
				.get("appDatasuggestIndirizzoCertProgettista"));
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
	 * imposta il valore dell' ApplicationData 'appDataraccomandazioneSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataraccomandazioneSelezionata(java.lang.String value) {
		getSession().put("appDataraccomandazioneSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataraccomandazioneSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataraccomandazioneSelezionata() {
		return (java.lang.String) (getSession().get("appDataraccomandazioneSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataqualitaInvolucro'
	 * @param value
	 * @generated
	 */

	public void setAppDataqualitaInvolucro(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.QualitaInvolucro> value) {
		getSession().put("appDataqualitaInvolucro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataqualitaInvolucro'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.QualitaInvolucro> getAppDataqualitaInvolucro() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.QualitaInvolucro>) (getSession()
				.get("appDataqualitaInvolucro"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataclassiEfficienzaEnergetiche'
	 * @param value
	 * @generated
	 */

	public void setAppDataclassiEfficienzaEnergetiche(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.ClasseEfficienzaEnerg> value) {
		getSession().put("appDataclassiEfficienzaEnergetiche", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataclassiEfficienzaEnergetiche'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.ClasseEfficienzaEnerg> getAppDataclassiEfficienzaEnergetiche() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.ClasseEfficienzaEnerg>) (getSession()
				.get("appDataclassiEfficienzaEnergetiche"));
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
	 * imposta il valore dell' ApplicationData 'appDatatipiCombustibileAcquaCalda'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiCombustibileAcquaCalda(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoCombustibile> value) {
		getSession().put("appDatatipiCombustibileAcquaCalda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiCombustibileAcquaCalda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoCombustibile> getAppDatatipiCombustibileAcquaCalda() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoCombustibile>) (getSession()
				.get("appDatatipiCombustibileAcquaCalda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataflagDatiPersCurriculum'
	 * @param value
	 * @generated
	 */

	public void setAppDataflagDatiPersCurriculum(java.lang.Boolean value) {
		getSession().put("appDataflagDatiPersCurriculum", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataflagDatiPersCurriculum'
	 * @generated
	 */
	public java.lang.Boolean getAppDataflagDatiPersCurriculum() {
		return (java.lang.Boolean) (getSession().get("appDataflagDatiPersCurriculum"));
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
	 * imposta il valore dell' ApplicationData 'appDatadatoCatastaleSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatoCatastaleSelezionato(java.lang.String value) {
		getSession().put("appDatadatoCatastaleSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatoCatastaleSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatadatoCatastaleSelezionato() {
		return (java.lang.String) (getSession().get("appDatadatoCatastaleSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuniCertDtCatSecondari'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniCertDtCatSecondari(java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> value) {
		getSession().put("appDatacomuniCertDtCatSecondari", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniCertDtCatSecondari'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune> getAppDatacomuniCertDtCatSecondari() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.geo.Comune>) (getSession()
				.get("appDatacomuniCertDtCatSecondari"));
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
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCodCostr'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCodCostr(java.lang.Integer value) {
		getSession().put("appDatasuggestIndirizzoCodCostr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCodCostr'
	 * @generated
	 */
	public java.lang.Integer getAppDatasuggestIndirizzoCodCostr() {
		return (java.lang.Integer) (getSession().get("appDatasuggestIndirizzoCodCostr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCodDirLav'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCodDirLav(java.lang.Integer value) {
		getSession().put("appDatasuggestIndirizzoCodDirLav", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCodDirLav'
	 * @generated
	 */
	public java.lang.Integer getAppDatasuggestIndirizzoCodDirLav() {
		return (java.lang.Integer) (getSession().get("appDatasuggestIndirizzoCodDirLav"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCodProgettista'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCodProgettista(java.lang.Integer value) {
		getSession().put("appDatasuggestIndirizzoCodProgettista", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCodProgettista'
	 * @generated
	 */
	public java.lang.Integer getAppDatasuggestIndirizzoCodProgettista() {
		return (java.lang.Integer) (getSession().get("appDatasuggestIndirizzoCodProgettista"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipiEdificio'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiEdificio(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoEdificio> value) {
		getSession().put("appDatatipiEdificio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiEdificio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoEdificio> getAppDatatipiEdificio() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.TipoEdificio>) (getSession()
				.get("appDatatipiEdificio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacarattEdificio'
	 * @param value
	 * @generated
	 */

	public void setAppDatacarattEdificio(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CarattEdificio> value) {
		getSession().put("appDatacarattEdificio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacarattEdificio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CarattEdificio> getAppDatacarattEdificio() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.CarattEdificio>) (getSession()
				.get("appDatacarattEdificio"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// ComboBox cbSistema

	private java.lang.String widgCbSistema;

	public void setWidg_cbSistema(java.lang.String value) {
		widgCbSistema = value;
	}

	public java.lang.String getWidg_cbSistema() {
		return widgCbSistema;
	}

	// TextField tfIntervento

	private java.lang.String widgTfIntervento;

	public void setWidg_tfIntervento(java.lang.String value) {
		widgTfIntervento = value;
	}

	public java.lang.String getWidg_tfIntervento() {
		return widgTfIntervento;
	}

	// RadioButtons rbsPriorita

	private java.lang.String widgRbsPriorita;

	public void setWidg_rbsPriorita(java.lang.String value) {
		widgRbsPriorita = value;
	}

	public java.lang.String getWidg_rbsPriorita() {
		return widgRbsPriorita;
	}

	// TextField tfTempoRitorno

	private java.lang.String widgTfTempoRitorno;

	public void setWidg_tfTempoRitorno(java.lang.String value) {
		widgTfTempoRitorno = value;
	}

	public java.lang.String getWidg_tfTempoRitorno() {
		return widgTfTempoRitorno;
	}

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

}
