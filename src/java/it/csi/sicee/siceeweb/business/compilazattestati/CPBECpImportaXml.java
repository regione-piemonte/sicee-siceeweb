package it.csi.sicee.siceeweb.business.compilazattestati;

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

/*PROTECTED REGION ID(R173675817) ENABLED START*/

import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CalcoloMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger;

/*PROTECTED REGION END*/

public class CPBECpImportaXml {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [xmlResult, scope:USER_SESSION]
	public static final String APPDATA_XMLRESULT_CODE = "appDataxmlResult";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [comuniCertDtCat, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDTCAT_CODE = "appDatacomuniCertDtCat";

	// ApplicationData: [provinceCertDTCat, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTDTCAT_CODE = "appDataprovinceCertDTCat";

	// ApplicationData: [esitoImportaXml, scope:USER_ACTION]
	public static final String APPDATA_ESITOIMPORTAXML_CODE = "appDataesitoImportaXml";

	// ApplicationData: [certificatoXml, scope:SAME_PAGE]
	public static final String APPDATA_CERTIFICATOXML_CODE = "appDatacertificatoXml";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [tempDichiarazSelez, scope:USER_SESSION]
	public static final String APPDATA_TEMPDICHIARAZSELEZ_CODE = "appDatatempDichiarazSelez";

	// ApplicationData: [tempRaccomandazioni, scope:USER_SESSION]
	public static final String APPDATA_TEMPRACCOMANDAZIONI_CODE = "appDatatempRaccomandazioni";

	// ApplicationData: [attestatiXml, scope:USER_SESSION]
	public static final String APPDATA_ATTESTATIXML_CODE = "appDataattestatiXml";

	// ApplicationData: [isImportaDati, scope:USER_SESSION]
	public static final String APPDATA_ISIMPORTADATI_CODE = "appDataisImportaDati";

	// ApplicationData: [tempDtCatastaliSecondari, scope:USER_SESSION]
	public static final String APPDATA_TEMPDTCATASTALISECONDARI_CODE = "appDatatempDtCatastaliSecondari";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpImportaXml";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaXml definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults caricaXml(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAXML_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICAXML_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-845173886) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (log.isDebugEnabled())
				log.debug("\n\n >>>>>>> " + theModel.getWidg_fileCaricaXmlFileName() + "\n\n");

			boolean ok = checkCaricaXml(theModel, result);
			if (ok) {
				List<String> list = getMiscMgr().isFileXmlValidFileXml(theModel.getWidg_fileCaricaXml());

				if (!BaseMgr.isNullOrEmpty(list)) {

					boolean version = false;
					for (String aaa : list) {
						if (aaa.contains("versione")) {
							result.getGlobalErrors().add(Constants.ERROR_CODE_XML_4);
							result.getGlobalErrors().add(Constants.ERROR_CODE_XML_1);
							version = true;
							break;
						}
					}
					if (!version) {
						result.getGlobalErrors().add(Constants.ERROR_CODE_XML_1);
						result.getGlobalErrors().add(Constants.ERROR_CODE_XML_2);
					}

					getMiscMgr().sendMailPerXml(theModel.getAppDatacertificato(), theModel.getAppDatacertificatore(),
							theModel.getWidg_fileCaricaXml(), list);
					theModel.setAppDataisImportaDati(false);
					result.setResultCode(CARICAXML_OUTCOME_CODE__KO);
				} else if (list == null) {
					result.getGlobalErrors().add(Constants.ERROR_CODE_XML_1);
					result.getGlobalErrors().add(Constants.ERROR_CODE_XML_3);
					theModel.setAppDataisImportaDati(false);
					result.setResultCode(CARICAXML_OUTCOME_CODE__KO);
				} else {
					try {
						theModel.setAppDataattestatiXml(caricamentoFileXml(theModel));
						DatiAttestato calc = theModel.getAppDataattestatiXml().get(1);
						ArrayList<String> errors = (ArrayList<String>) getMiscMgr().checkValideDecodifiche(calc);

						if (errors.isEmpty()) {
							result.setResultCode(CARICAXML_OUTCOME_CODE__OK);
						} else {
							theModel.setAppDataattestatiXml(new ArrayList<DatiAttestato>());
							result.getGlobalErrors().addAll(errors);
							theModel.setAppDataisImportaDati(false);
							result.setResultCode(CARICAXML_OUTCOME_CODE__KO);
						}
					} catch (BEException e) {
						result.getGlobalErrors().add(Constants.ERROR_CODE_XML_1);
						result.getGlobalErrors().add(Constants.ERROR_CODE_XML_3);
						theModel.setAppDataattestatiXml(new ArrayList<DatiAttestato>());
						theModel.setAppDataisImportaDati(false);
						result.setResultCode(CARICAXML_OUTCOME_CODE__KO);
					}

				}

			} else {
				result.getGlobalErrors().add(Constants.ERROR_CODE_XML_1);
				result.getGlobalErrors().add(Constants.ERROR_CODE_XML_3);
				theModel.setAppDataisImportaDati(false);
				result.setResultCode(CARICAXML_OUTCOME_CODE__KO);
			}
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaXml] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastali definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1380376401) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali()
					.setDescrProv(getDescrProvincia(theModel.getAppDataprovinceCertDTCat(),
							theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().getCodProv()));
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().setCodComune(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().setGradiGiorno(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().setZonaClimatica(null);
			// impostazione del result code
			result.setResultCode(SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneDtCatastali definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults setComuneDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNEDTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R954147101) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali()
					.setDescrComune(getDescrComune(theModel.getAppDatacomuniCertDtCat(),
							theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().getCodComune()));

			getCertificatoMgr().recuperaGradiGiornoEZonaClimatica(theModel.getAppDatacertificato());
			// impostazione del result code
			result.setResultCode(SETCOMUNEDTCATASTALI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eseguiCalcoli definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults eseguiCalcoli(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ESEGUICALCOLI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ESEGUICALCOLI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1230679533) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato attOrig = theModel.getAppDatacertificato();
			DatiAttestato calc = theModel.getAppDataattestatiXml().get(1);

			String codProv = attOrig.getDatiAnagraficiImm().getDtCatastali().getCodProv();
			String codCom = attOrig.getDatiAnagraficiImm().getDtCatastali().getCodComune();
			UDTPositiveInteger gradiGiorno = attOrig.getDatiAnagraficiImm().getDtCatastali().getGradiGiorno();

			boolean res = true;
			if (GenericUtil.isNullOrEmpty(codProv)) {
				result.getGlobalErrors().add("Selezionare una provincia");
				res = false;
			}

			if (GenericUtil.isNullOrEmpty(codCom)) {
				result.getGlobalErrors().add("Selezionare un comune");
				res = false;
			}

			if (GenericUtil.isNullOrEmpty(gradiGiorno)) {
				result.getGlobalErrors().add("Valorizzare i gradi giorno");
				res = false;
			}

			if (res) {

				calc.getDatiAnagraficiImm().getDtCatastali().setCodProv(codProv);
				calc.getDatiAnagraficiImm().getDtCatastali()
						.setDescrProv(attOrig.getDatiAnagraficiImm().getDtCatastali().getDescrProv());
				calc.getDatiAnagraficiImm().getDtCatastali().setCodComune(codCom);

				calc.getDatiAnagraficiImm().getDtCatastali()
						.setDescrComune(attOrig.getDatiAnagraficiImm().getDtCatastali().getDescrComune());

				calc.getDatiAnagraficiImm().getDtCatastali().setGradiGiorno(gradiGiorno);
				calc.getDatiAnagraficiImm().getDtCatastali()
						.setZonaClimatica(attOrig.getDatiAnagraficiImm().getDtCatastali().getZonaClimatica());

				getCalcoloMgr().calcolaDatiTecniciGenerali(calc);
				getCalcoloMgr().calcolaFabbisogno(calc, true);
				getCalcoloMgr().calcolaClasseEnergeticaReale(calc);
				getCalcoloMgr().calcolaClasseEnergeticaTeorica(calc);

				//BEPPE
				//fabbisognoEnergiaUtileAcs 

				calc.getEnergRinnov().setPercEnergiaFontiRinnov(BaseMgr.convertToDoubleTwo(0D));

				// Beppe 22/03
				/*
				if (!GenericUtil.isNullOrEmpty(calc.getIndFabbisogno()
						.getDomEnergAcqua())) {
					if (BaseMgr.convertTo(calc.getIndFabbisogno()
							.getDomEnergAcqua()) != 0) {
						getCalcoloMgr().calcolaFontiRinnov(calc);		
					}
				}
				 */

				getCalcoloMgr().calcolaFontiRinnov(calc);

				getCalcoloMgr().calcolaEmissioniGasSerraEEttariBosco(calc);
				getCalcoloMgr().calcolaLimiteNormativoRegionaleImpiantoTermico(calc);
				getCalcoloMgr().calcolaIndicePrestazioneEnergeticaGlobaleLimiteTorino(calc);

				theModel.setAppDatacertificatoXml(calc);
				theModel.setAppDataxmlResult(generaTabellaResoconto(theModel.getAppDataattestatiXml()));
				// impostazione del result code
				result.setResultCode(ESEGUICALCOLI_OUTCOME_CODE__OK);

			} else {
				result.setResultCode(ESEGUICALCOLI_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eseguiCalcoli] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eseguiAnnulla definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults eseguiAnnulla(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ESEGUIANNULLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ESEGUIANNULLA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1190625245) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato attOrig = theModel.getAppDatacertificato();

			attOrig.getDatiAnagraficiImm().getDtCatastali().setCodProv(null);
			attOrig.getDatiAnagraficiImm().getDtCatastali().setCodComune(null);
			attOrig.getDatiAnagraficiImm().getDtCatastali().setGradiGiorno(null);

			// impostazione del result code
			result.setResultCode(ESEGUIANNULLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eseguiAnnulla] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo importaXml definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults importaXml(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPORTAXML_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String IMPORTAXML_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String IMPORTAXML_OUTCOME_CODE__NON_VALORIZZATO = //NOSONAR  Reason:EIAS
				"NON_VALORIZZATO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1079758153) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDataesitoImportaXml() == null) {
				addMissingRequiredFieldError("appDataesitoImportaXml", result);
				result.setResultCode(IMPORTAXML_OUTCOME_CODE__NON_VALORIZZATO);
			} else if (theModel.getAppDataesitoImportaXml().equals(Constants.NO)) {
				result.setResultCode(IMPORTAXML_OUTCOME_CODE__KO);
			} else {
				String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();
				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificatoXml();

				att.setNumeroAttestato(numeroCertificato);

				theModel.setAppDatatempDichiarazSelez(att.getDichiarazioni().getCodDichiaraz());
				theModel.setAppDatacertificato(att);
				theModel.setAppDatatempRaccomandazioni((ArrayList<Raccomandazione>) getCertificatoMgr()
						.recuperaRaccomandazioni(cert, numeroCertificato));

				att.getClasseEnerg().getLocTeorica().setServEnergInclusi(Constants.SERVIZI_ENERGETICI_INCLUSI);

				getCertificatoMgr().aggiornaAttestato(cert, att);
				theModel.setAppDatacertificato(getCertificatoMgr().recuperaAttestato(cert, numeroCertificato));

				theModel.getSession().remove("cpCompilaz_pWizCompilazLiv1_selectedMultiPanel");
				theModel.getSession().remove("cpCompilaz_pWizAnagImmobile_selectedMultiPanel");

				result.setResultCode(IMPORTAXML_OUTCOME_CODE__OK);
			}
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::importaXml] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1181285984) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			gestisciComboDtCatasto(theModel);

			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo switchScreenState definito in un ExecCommand del
	 * ContentPanel cpImportaXml
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHSCREENSTATE_OUTCOME_CODE__FIRST = //NOSONAR  Reason:EIAS
				"FIRST"; //NOSONAR  Reason:EIAS
		final String SWITCHSCREENSTATE_OUTCOME_CODE__OTHER = //NOSONAR  Reason:EIAS
				"OTHER"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R321796821) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (!theModel.getAppDataisImportaDati()) {
				theModel.setAppDataisImportaDati(true);
				result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__FIRST);
			} else {
				result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__OTHER);
			}
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchScreenState] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblXmlResult
	 */
	public static void resetClearStatus_widg_tblXmlResult(java.util.Map session) {
		session.put("cpImportaXml_tblXmlResult_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-977711125) ENABLED START*/
	// // inserire qui le property che si vogliono iniettare in questo bean (es.
	// dao, proxy di pd, ...)
	private void gestisciComboDtCatasto(it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel)
			throws BEException {

		DatiAttestato cert = theModel.getAppDatacertificato();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByPiemonte();
		theModel.setAppDataprovinceCertDTCat(province);

		String actProvSel = cert.getDatiAnagraficiImm().getDtCatastali().getCodProv();
		ArrayList<Comune> comuni = new ArrayList<Comune>();

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuniCertDtCat(comuni);
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private CalcoloMgr calcoloMgr;

	public CalcoloMgr getCalcoloMgr() {
		return calcoloMgr;
	}

	public void setCalcoloMgr(CalcoloMgr calcoloMgr) {
		this.calcoloMgr = calcoloMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private boolean checkCaricaXml(it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel,
			ExecResults result) {

		boolean out = true;

		if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileCaricaXmlFileName())) {
			String fileName = theModel.getWidg_fileCaricaXmlFileName();

			if (!fileName.toLowerCase().endsWith(".xml")) {
				out = false;
			}
		} else {
			out = false;
		}

		if (!out) {
			result.getGlobalErrors().add("Il formato del file non e' corretto");
		}

		if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileCaricaXmlFileName())) {
			if (theModel.getWidg_fileCaricaXml().length() > 500000) {
				result.getGlobalErrors()
						.add("La dimensione del file XML e' troppo elevata. La dimensione massima e' di 500Kb");
				out = false;
			}
		}

		return out;

	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "e' obbligatorio");
	}

	private ArrayList<DatiAttestato> caricamentoFileXml(
			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel) throws BEException {
		return (ArrayList<DatiAttestato>) getMiscMgr().convertXmlToDatiAttestato(theModel.getWidg_fileCaricaXml());
	}

	private ArrayList<ImportXmlResult> generaTabellaResoconto(ArrayList<DatiAttestato> list) {

		DatiAttestato xml = list.get(0);
		DatiAttestato sicee = list.get(1);

		ArrayList<ImportXmlResult> result = new ArrayList<ImportXmlResult>();

		ImportXmlResult xmlRes = null;

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Fattore forma S/V [m<sup>-1</sup>]");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getDatiTecnici().getFattoreForma()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee.getDatiTecnici().getFattoreForma()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Limite normativo regionale [kWh/m<sup>2</sup> o kWh/m<sup>3</sup>]");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getIndFabbisogno().getLimNormRegione()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee.getIndFabbisogno().getLimNormRegione()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione(
				"Indice di prestazione energetica riscaldamento invernale (Epi,r) [kWh/m<sup>2</sup> o kWh/m<sup>3</sup>]");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getClasseEnerg().getLocReale().getIndPrestEnergRiscald()));
		xmlRes.setValoreCalcolato(
				BaseMgr.convertToString(sicee.getClasseEnerg().getLocReale().getIndPrestEnergRiscald()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione(
				"Indice di prestazione energetica globale (EPL lordo) [kWh/m<sup>2</sup> o kWh/m<sup>3</sup>]");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getClasseEnerg().getLocReale().getIndPrestEnergGlob()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee.getClasseEnerg().getLocReale().getIndPrestEnergGlob()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Limite normativo regionale Torino [kWh/m<sup>2</sup> o kWh/m<sup>3</sup>]");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getClasseEnerg().getLocTeorica().getLimNormaRegione()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee.getClasseEnerg().getLocTeorica().getLimNormaRegione()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione(
				"Indice di prestazione energetica globale Torino (EPL lordo) [kWh/m<sup>2</sup> o kWh/m<sup>3</sup>]");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getClasseEnerg().getLocTeorica().getIndPrestEnergGlob()));
		xmlRes.setValoreCalcolato(
				BaseMgr.convertToString(sicee.getClasseEnerg().getLocTeorica().getIndPrestEnergGlob()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Classe energetica");
		xmlRes.setValoreXml(
				getMiscMgr().getDescrizioneClasseEnergetica(xml.getClasseEnerg().getLocTeorica().getClasseEnerg()));
		xmlRes.setValoreCalcolato(
				getMiscMgr().getDescrizioneClasseEnergetica(sicee.getClasseEnerg().getLocTeorica().getClasseEnerg()));
		xmlRes.setMatched(xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato()));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Quota di energia coperta da fonti rinnovabili [%]");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getEnergRinnov().getPercEnergiaFontiRinnov()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee.getEnergRinnov().getPercEnergiaFontiRinnov()));
		xmlRes.setMatched(xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato()));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Limite normativo regionale impianto termico (DGR 46-11968)");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getImpianti().getRiscaldamento().getLimNormRegImpTerm()));
		xmlRes.setValoreCalcolato(
				BaseMgr.convertToString(sicee.getImpianti().getRiscaldamento().getLimNormRegImpTerm()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		/*xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Indice di prestazione energetica globale limite");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getClasseEnerg()
				.getLocTeorica().getIndGlobLimiteTo()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee
				.getClasseEnerg().getLocTeorica().getIndGlobLimiteTo()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes
				.getValoreCalcolato())));
		result.add(xmlRes);*/

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Emissioni gas serra");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getGasSerra().getEmissioniGasSerra()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee.getGasSerra().getEmissioniGasSerra()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		xmlRes = new ImportXmlResult();
		xmlRes.setDescrizione("Ettari di bosco");
		xmlRes.setValoreXml(BaseMgr.convertToString(xml.getGasSerra().getSupBoscoEquiv()));
		xmlRes.setValoreCalcolato(BaseMgr.convertToString(sicee.getGasSerra().getSupBoscoEquiv()));
		xmlRes.setMatched((xmlRes.getValoreXml().equals(xmlRes.getValoreCalcolato())));
		result.add(xmlRes);

		return result;
	}

	private String getDescrProvincia(ArrayList<Provincia> province, String id) {
		if (province != null) {
			if (id != null && id.length() > 0) {
				for (Provincia provincia : province) {
					if (provincia.getCod().equals(id))
						return provincia.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private String getDescrComune(ArrayList<Comune> comuni, String id) {
		if (comuni != null) {
			if (id != null && id.length() > 0) {
				for (Comune comune : comuni) {
					if (comune.getCod().equals(id))
						return comune.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	/*PROTECTED REGION END*/
}
