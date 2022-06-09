package it.csi.sicee.siceeweb.business.compilazattestatiape;

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

import org.apache.log4j.*;
import it.csi.sicee.siceeweb.util.*;
import it.csi.sicee.siceeweb.business.*;

/*PROTECTED REGION ID(R1273534060) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger;
/*PROTECTED REGION END*/

public class CPBECpZonaClima {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [aceList, scope:USER_SESSION]
	public static final String APPDATA_ACELIST_CODE = "appDataaceList";

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [aceSostituzioneList, scope:USER_SESSION]
	public static final String APPDATA_ACESOSTITUZIONELIST_CODE = "appDataaceSostituzioneList";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [emailInvioApe, scope:USER_SESSION]
	public static final String APPDATA_EMAILINVIOAPE_CODE = "appDataemailInvioApe";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [documentoAggiuntivo, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTOAGGIUNTIVO_CODE = "appDatadocumentoAggiuntivo";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	// ApplicationData: [uidDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_UIDDOCUMENTOSELEZIONATO_CODE = "appDatauidDocumentoSelezionato";

	// ApplicationData: [listTipiDoc, scope:USER_SESSION]
	public static final String APPDATA_LISTTIPIDOC_CODE = "appDatalistTipiDoc";

	// ApplicationData: [idTipoDocumento, scope:USER_SESSION]
	public static final String APPDATA_IDTIPODOCUMENTO_CODE = "appDataidTipoDocumento";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [listZoneClima, scope:USER_SESSION]
	public static final String APPDATA_LISTZONECLIMA_CODE = "appDatalistZoneClima";

	// ApplicationData: [idComuneZonaClima, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNEZONACLIMA_CODE = "appDataidComuneZonaClima";

	// ApplicationData: [descZonaClima, scope:USER_SESSION]
	public static final String APPDATA_DESCZONACLIMA_CODE = "appDatadescZonaClima";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpZonaClima";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaZonaClima definito in un ExecCommand del
	 * ContentPanel cpZonaClima
	 */
	public ExecResults salvaZonaClima(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpZonaClimaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAZONACLIMA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAZONACLIMA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R550899340) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiAttestato att = theModel.getAppDatacertificato();

			String istat = theModel.getAppDataidComuneZonaClima();
			String descZona = theModel.getAppDatadescZonaClima();

			log.debug("istat: " + istat);
			log.debug("zonaClima: " + descZona);

			String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), att.getNumeroAttestato());

			String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			SiceeTDatiGenerali datiGenerali = getCertificatoMgr().recuperaDatiGenerali(idCertificatore,
					progrCertificato, anno);
			SiceeDGradiGiorno grado = getCertificatoMgr().getSiceeDGradiGiornoDao().findByZonaEComune(istat, descZona);
			if (grado != null && datiGenerali != null) {
				datiGenerali.setZonaClimatica(grado.getZonaClimatica());
				datiGenerali.setGradiGiorno(grado.getGradiGiorno());
				att.getDatiAnagraficiImm().getDtCatastali().setZonaClimatica(grado.getZonaClimatica());
				UDTPositiveInteger udtPositiveInteger = new UDTPositiveInteger();
				udtPositiveInteger.setValue(grado.getGradiGiorno());
				att.getDatiAnagraficiImm().getDtCatastali().setGradiGiorno(udtPositiveInteger);
				getCertificatoMgr().getSiceeTDatiGeneraliDao().update(datiGenerali.createPk(), datiGenerali);
				result.setResultCode(SALVAZONACLIMA_OUTCOME_CODE__OK);
			} else
				result.setResultCode(SALVAZONACLIMA_OUTCOME_CODE__KO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaZonaClima] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initZonaClimaComboBox definito in un ExecCommand del
	 * ContentPanel cpZonaClima
	 */
	public ExecResults initZonaClimaComboBox(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpZonaClimaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITZONACLIMACOMBOBOX_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INITZONACLIMACOMBOBOX_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1950776816) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INITZONACLIMACOMBOBOX_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initZonaClimaComboBox] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R715842754) ENABLED START*/
	private CertificatoMgr certificatoMgr = null;
	private SOAIntegrationMgr soaIntegrationMgr;
	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}
	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}
	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
