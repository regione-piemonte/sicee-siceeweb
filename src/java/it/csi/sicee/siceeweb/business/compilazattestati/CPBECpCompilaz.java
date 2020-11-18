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

/*PROTECTED REGION ID(R1665096089) ENABLED START*/
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDPriorita;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CalcoloMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel;
import it.csi.sicee.siceeweb.util.exception.*;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiReader;

/*PROTECTED REGION END*/

public class CPBECpCompilaz {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [comuniCertDtCat, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDTCAT_CODE = "appDatacomuniCertDtCat";

	// ApplicationData: [provinceCertDTCat, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTDTCAT_CODE = "appDataprovinceCertDTCat";

	// ApplicationData: [comuniCertCostr, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTCOSTR_CODE = "appDatacomuniCertCostr";

	// ApplicationData: [comuniCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDIRLAV_CODE = "appDatacomuniCertDirLav";

	// ApplicationData: [comuniCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTPROGETTISTA_CODE = "appDatacomuniCertProgettista";

	// ApplicationData: [provinceCertCostr, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTCOSTR_CODE = "appDataprovinceCertCostr";

	// ApplicationData: [provinceCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTDIRLAV_CODE = "appDataprovinceCertDirLav";

	// ApplicationData: [provinceCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTPROGETTISTA_CODE = "appDataprovinceCertProgettista";

	// ApplicationData: [regioniCertCostr, scope:USER_SESSION]
	public static final String APPDATA_REGIONICERTCOSTR_CODE = "appDataregioniCertCostr";

	// ApplicationData: [regioniCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_REGIONICERTDIRLAV_CODE = "appDataregioniCertDirLav";

	// ApplicationData: [regioniCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_REGIONICERTPROGETTISTA_CODE = "appDataregioniCertProgettista";

	// ApplicationData: [classiEnergetiche, scope:USER_SESSION]
	public static final String APPDATA_CLASSIENERGETICHE_CODE = "appDataclassiEnergetiche";

	// ApplicationData: [destinazioniUso, scope:USER_SESSION]
	public static final String APPDATA_DESTINAZIONIUSO_CODE = "appDatadestinazioniUso";

	// ApplicationData: [tipologieImmobili, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIEIMMOBILI_CODE = "appDatatipologieImmobili";

	// ApplicationData: [sistemi, scope:USER_SESSION]
	public static final String APPDATA_SISTEMI_CODE = "appDatasistemi";

	// ApplicationData: [motiviRilascio, scope:USER_SESSION]
	public static final String APPDATA_MOTIVIRILASCIO_CODE = "appDatamotiviRilascio";

	// ApplicationData: [tipiRedazione, scope:USER_SESSION]
	public static final String APPDATA_TIPIREDAZIONE_CODE = "appDatatipiRedazione";

	// ApplicationData: [dichiarazioni, scope:USER_SESSION]
	public static final String APPDATA_DICHIARAZIONI_CODE = "appDatadichiarazioni";

	// ApplicationData: [tipiCombustibileRiscaldamento, scope:USER_SESSION]
	public static final String APPDATA_TIPICOMBUSTIBILERISCALDAMENTO_CODE = "appDatatipiCombustibileRiscaldamento";

	// ApplicationData: [tipiImpianto, scope:USER_SESSION]
	public static final String APPDATA_TIPIIMPIANTO_CODE = "appDatatipiImpianto";

	// ApplicationData: [tipiRegolazione, scope:USER_SESSION]
	public static final String APPDATA_TIPIREGOLAZIONE_CODE = "appDatatipiRegolazione";

	// ApplicationData: [tipiDistrib, scope:USER_SESSION]
	public static final String APPDATA_TIPIDISTRIB_CODE = "appDatatipiDistrib";

	// ApplicationData: [tipiTermErogaz, scope:USER_SESSION]
	public static final String APPDATA_TIPITERMEROGAZ_CODE = "appDatatipiTermErogaz";

	// ApplicationData: [tempDichiarazSelez, scope:USER_SESSION]
	public static final String APPDATA_TEMPDICHIARAZSELEZ_CODE = "appDatatempDichiarazSelez";

	// ApplicationData: [suggestIndirizzoCertCostr, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCERTCOSTR_CODE = "appDatasuggestIndirizzoCertCostr";

	// ApplicationData: [suggestIndirizzoCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCERTDIRLAV_CODE = "appDatasuggestIndirizzoCertDirLav";

	// ApplicationData: [suggestIndirizzoCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCERTPROGETTISTA_CODE = "appDatasuggestIndirizzoCertProgettista";

	// ApplicationData: [suggestIndirizzoDtCat, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZODTCAT_CODE = "appDatasuggestIndirizzoDtCat";

	// ApplicationData: [suggestIndirizzo, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZO_CODE = "appDatasuggestIndirizzo";

	// ApplicationData: [raccomandazioneSelezionata, scope:SAME_PAGE]
	public static final String APPDATA_RACCOMANDAZIONESELEZIONATA_CODE = "appDataraccomandazioneSelezionata";

	// ApplicationData: [qualitaInvolucro, scope:SAME_PAGE]
	public static final String APPDATA_QUALITAINVOLUCRO_CODE = "appDataqualitaInvolucro";

	// ApplicationData: [classiEfficienzaEnergetiche, scope:SAME_PAGE]
	public static final String APPDATA_CLASSIEFFICIENZAENERGETICHE_CODE = "appDataclassiEfficienzaEnergetiche";

	// ApplicationData: [tempRaccomandazioni, scope:USER_SESSION]
	public static final String APPDATA_TEMPRACCOMANDAZIONI_CODE = "appDatatempRaccomandazioni";

	// ApplicationData: [tipiCombustibileAcquaCalda, scope:USER_SESSION]
	public static final String APPDATA_TIPICOMBUSTIBILEACQUACALDA_CODE = "appDatatipiCombustibileAcquaCalda";

	// ApplicationData: [flagDatiPersCurriculum, scope:USER_SESSION]
	public static final String APPDATA_FLAGDATIPERSCURRICULUM_CODE = "appDataflagDatiPersCurriculum";

	// ApplicationData: [tempDtCatastaliSecondari, scope:USER_SESSION]
	public static final String APPDATA_TEMPDTCATASTALISECONDARI_CODE = "appDatatempDtCatastaliSecondari";

	// ApplicationData: [datoCatastaleSelezionato, scope:SAME_PAGE]
	public static final String APPDATA_DATOCATASTALESELEZIONATO_CODE = "appDatadatoCatastaleSelezionato";

	// ApplicationData: [comuniCertDtCatSecondari, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDTCATSECONDARI_CODE = "appDatacomuniCertDtCatSecondari";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	// ApplicationData: [suggestIndirizzoCode, scope:USER_ACTION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODE_CODE = "appDatasuggestIndirizzoCode";

	// ApplicationData: [suggestIndirizzoCodCostr, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODCOSTR_CODE = "appDatasuggestIndirizzoCodCostr";

	// ApplicationData: [suggestIndirizzoCodDirLav, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODDIRLAV_CODE = "appDatasuggestIndirizzoCodDirLav";

	// ApplicationData: [suggestIndirizzoCodProgettista, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODPROGETTISTA_CODE = "appDatasuggestIndirizzoCodProgettista";

	// ApplicationData: [tipiEdificio, scope:USER_SESSION]
	public static final String APPDATA_TIPIEDIFICIO_CODE = "appDatatipiEdificio";

	// ApplicationData: [carattEdificio, scope:USER_SESSION]
	public static final String APPDATA_CARATTEDIFICIO_CODE = "appDatacarattEdificio";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpCompilaz";

	public static final String WIZARD_PWIZCOMPILAZLIV1 = "pWizCompilazLiv1";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIANAGIMMOBILE = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiAnagImmobile";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATITECNICI = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiTecnici";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIFABBISOGNO = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiFabbisogno";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATICLENERG = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiClEnerg";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIFONTIRINNOV = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiFontiRinnov";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIALTREINFO = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiAltreInfo";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATINORMATIVE = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiNormative";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIIMPIANTI = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiImpianti";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIGASSERRA = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiGasSerra";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATICONSUMI = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiConsumi";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIDICHIARAZ = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiDichiaraz";
	public static final String STEP_PWIZCOMPILAZLIV1_PDATIFOTO = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pDatiFoto";
	public static final String STEP_PWIZCOMPILAZLIV1_PSTAMPACERTITIFICATO = CPNAME + "_" + WIZARD_PWIZCOMPILAZLIV1 + "_"
			+ "pStampaCertitificato";
	public static final String WIZARD_PWIZANAGIMMOBILE = "pWizAnagImmobile";
	public static final String STEP_PWIZANAGIMMOBILE_PDATICATASTALI = CPNAME + "_" + WIZARD_PWIZANAGIMMOBILE + "_"
			+ "pDatiCatastali";
	public static final String STEP_PWIZANAGIMMOBILE_PDATIRESPONSABILI = CPNAME + "_" + WIZARD_PWIZANAGIMMOBILE + "_"
			+ "pDatiResponsabili";
	public static final String STEP_PWIZANAGIMMOBILE_PDATICOCERTIFICATORE = CPNAME + "_" + WIZARD_PWIZANAGIMMOBILE + "_"
			+ "pDatiCoCertificatore";

	public static final String WIZARD_PWIZCLENERG = "pWizClEnerg";
	public static final String STEP_PWIZCLENERG_PDATILOCREALE = CPNAME + "_" + WIZARD_PWIZCLENERG + "_"
			+ "pDatiLocReale";
	public static final String STEP_PWIZCLENERG_PDATILOCTEORICA = CPNAME + "_" + WIZARD_PWIZCLENERG + "_"
			+ "pDatiLocTeorica";

	public static final String WIZARD_PWIZALTREINFO = "pWizAltreInfo";
	public static final String STEP_PWIZALTREINFO_PDATIALTRIGENERALI = CPNAME + "_" + WIZARD_PWIZALTREINFO + "_"
			+ "pDatiAltriGenerali";
	public static final String STEP_PWIZALTREINFO_PDATIALTRIRACCOMAND = CPNAME + "_" + WIZARD_PWIZALTREINFO + "_"
			+ "pDatiAltriRaccomand";
	public static final String STEP_PWIZALTREINFO_PDATIALTRIENERG = CPNAME + "_" + WIZARD_PWIZALTREINFO + "_"
			+ "pDatiAltriEnerg";
	public static final String STEP_PWIZALTREINFO_PDATIALTRISOPRALLUOGHI = CPNAME + "_" + WIZARD_PWIZALTREINFO + "_"
			+ "pDatiAltriSopralluoghi";

	public static final String WIZARD_PWIZIMPIANTI = "pWizImpianti";
	public static final String STEP_PWIZIMPIANTI_PDATIRISCALDAMENTO = CPNAME + "_" + WIZARD_PWIZIMPIANTI + "_"
			+ "pDatiRiscaldamento";
	public static final String STEP_PWIZIMPIANTI_PDATIACQUACALDA = CPNAME + "_" + WIZARD_PWIZIMPIANTI + "_"
			+ "pDatiAcquaCalda";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1085902561) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali()
					.setDescrProv(getDescrProvincia(theModel.getAppDataprovinceCertDTCat(),
							theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().getCodProv()));
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().setCodComune(null);

			// svuoto l'indirizzo
			svuotaComboDtCatastali(theModel);

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
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setComuneDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNEDTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-140958035) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali()
					.setDescrComune(getDescrComune(theModel.getAppDatacomuniCertDtCat(),
							theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().getCodComune()));

			getCertificatoMgr().recuperaGradiGiornoEZonaClimatica(theModel.getAppDatacertificato());

			// svuoto l'indirizzo
			svuotaComboDtCatastali(theModel);

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
	 * Implementazione del metodo verificaIndirizzoDtCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__NO_INDIRIZZO = //NOSONAR  Reason:EIAS
				"NO_INDIRIZZO"; //NOSONAR  Reason:EIAS
		final String VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__NO_COMUNE = //NOSONAR  Reason:EIAS
				"NO_COMUNE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R338247815) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato cert = theModel.getAppDatacertificato();
			DtCatastali dres = cert.getDatiAnagraficiImm().getDtCatastali();

			// se non e' compilato il campo comune non faccio partire la verifica
			if (GenericUtil.isNullOrEmpty(dres.getCodComune())) {
				result.getGlobalErrors()
						.add("E' necessario selezionare un comune per effettuare una verifica dell'indirizzo");
				// impostazione del result code 
				result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__NO_COMUNE);
			}

			else if ("".equals(dres.getRicercaIndirizzo().trim())) {
				result.getGlobalErrors().add("E' necessario indicare un indirizzo per poter effettuare la verifica");
				result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__NO_INDIRIZZO);
			} else {
				theModel.setAppDatasuggestIndirizzoDtCat(caricaComboIndirizzi(dres.getRicercaIndirizzo(),
						Constants.COD_REGIONE_PIEMONTE, dres.getCodComune()));
				dres.setCodIndirizzo(null);
				dres.setDescrIndirizzo(null);
				// impostazione del result code
				if (theModel.getAppDatasuggestIndirizzoDtCat().size() > 0)
					result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__OK);
				else {
					result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__KO);
				}
			}
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzoDtCatastali] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo svuotaComboDtCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults svuotaComboDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SVUOTACOMBODTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2026689700) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDatasuggestIndirizzoDtCat(new ArrayList<Indirizzo>());
			DatiAttestato cert = theModel.getAppDatacertificato();
			DtCatastali dres = cert.getDatiAnagraficiImm().getDtCatastali();
			dres.setCodIndirizzo(null);
			dres.setDescrIndirizzo(null);
			dres.setRicercaIndirizzo(null);

			// impostazione del result code 
			result.setResultCode(SVUOTACOMBODTCATASTALI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::svuotaComboDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo svuotaIndirizzo definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults svuotaIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SVUOTAINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R643521586) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato cert = theModel.getAppDatacertificato();
			DtCatastali dres = cert.getDatiAnagraficiImm().getDtCatastali();
			dres.setCodIndirizzo(null);

			// impostazione del result code 
			result.setResultCode(SVUOTAINDIRIZZO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::svuotaIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastaliSecondario definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaDtCatastaliSecondario(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALISECONDARIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R478109844) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			 * theModel.getAppDatacertificato() .getDatiAnagraficiImm()
			 * .getDtCatastali() .setDescrProv( getDescrProvincia(
			 * theModel.getAppDataprovinceCertDTCat(),
			 * theModel.getAppDatacertificato() .getDatiAnagraficiImm()
			 * .getDtCatastali().getCodProv()));
			 */

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().setCodComuneSec(null);
			// impostazione del result code

			// impostazione del result code
			result.setResultCode(SETPROVINCIADTCATASTALISECONDARIO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::setProvinciaDtCatastaliSecondario] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addDatoCatastale definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults addDatoCatastale(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDDATOCATASTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ADDDATOCATASTALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-249458195) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato att = theModel.getAppDatacertificato();
			DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

			if (log.isDebugEnabled()) {
				log.debug("CodProvSec = " + cat.getCodProvSec());
				log.debug("CodComuneSec = " + cat.getCodComuneSec());
				log.debug("SezioneSec = " + cat.getSezioneSec());
				log.debug("*FoglioSec = " + cat.getFoglioSec());
				log.debug("*ParticellaSec = " + cat.getParticellaSec());
				log.debug("SubalternoSec = " + cat.getSubalternoSec());
			}

			boolean ok = true;
			if (GenericUtil.isNullOrEmpty(cat.getCodProvSec())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codProvSec", result);
				ok = false;
			}

			if (GenericUtil.isNullOrEmpty(cat.getCodComuneSec())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codComuneSec", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(cat.getFoglioSec())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.foglioSec", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(cat.getParticellaSec())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.particellaSec", result);
				ok = false;
			}

			if (ok) {
				// boolean found = false;
				if (theModel.getAppDatatempDtCatastaliSecondari() == null) {
					theModel.setAppDatatempDtCatastaliSecondari(new ArrayList<DtCatastaliSecondari>());
				}
				ArrayList<DtCatastaliSecondari> catSec = theModel.getAppDatatempDtCatastaliSecondari();

				/*
				 * boolean isPrincipalePresente = false; for (int i = 0; i <
				 * racc.size(); i++) { if (racc.get(i).getFlgPrincipale()) {
				 * isPrincipalePresente = true; break; }
				 * 
				 * }
				 */

				/*
				 * // devo verificare se si sta cercando di inserire un'altro
				 * principale!! if (isPrincipalePresente &&
				 * cat.getFlgPrincipale()) { result.getGlobalErrors() .add(
				 * "Non e' possibile aggiungere un ulteriore dato catastale principale"
				 * ); result.setResultCode(ADDDATOCATASTALE_OUTCOME_CODE__KO);
				 * 
				 * } else {
				 */
				// devo verificare se si sta inserendo un dato catastale già
				// presente
				// l'analista deve verificare

				// if (true) {

				DtCatastaliSecondari dtCatSecondari = new DtCatastaliSecondari();
				String idDatoCatastale = cat.getFoglioSec() + "_" + cat.getParticellaSec() + "_"
						+ cat.getSubalternoSec();
				dtCatSecondari.setId(idDatoCatastale); // da verificare
				dtCatSecondari.setSezione(cat.getSezioneSec());
				dtCatSecondari.setFoglio(cat.getFoglioSec());
				dtCatSecondari.setParticella(cat.getParticellaSec());
				dtCatSecondari.setSubalterno(cat.getSubalternoSec());

				dtCatSecondari.setCodProv(cat.getCodProvSec());
				dtCatSecondari
						.setDescrProv(getDescrProvincia(theModel.getAppDataprovinceCertDTCat(), cat.getCodProvSec()));

				dtCatSecondari.setCodComune(cat.getCodComuneSec());
				dtCatSecondari.setDescrComune(
						getDescrComune(theModel.getAppDatacomuniCertDtCatSecondari(), cat.getCodComuneSec()));

				// BEPPE - 01/02/12 - SICEE-276
				// if (catSec.size() < Constants.NUMERO_MASSIMO_DATI_CATASTALI)
				// {

				catSec.add(dtCatSecondari);

				ArrayList<DtCatastaliSecondari> catSecNew = new ArrayList<DtCatastaliSecondari>();

				/*
				 * DtCatastaliSecondari[] list = new DtCatastaliSecondari[racc
				 * .size()];
				 */

				for (int i = 0; i < catSec.size(); i++) {

					DtCatastaliSecondari dtCatSecondariTemp = catSec.get(i);
					dtCatSecondariTemp.setId("" + i);
					catSecNew.add(dtCatSecondariTemp);
				}

				// racc.toArray(list);

				/*
				 * L'ordinamento è ancora da gestire Arrays.sort(list, new
				 * RaccomandazioneComparator()); racc = new
				 * ArrayList<DtCatastaliSecondari>();
				 * racc.addAll(Arrays.asList(list));
				 */

				theModel.setAppDatatempDtCatastaliSecondari(catSecNew);

				// ripulisco i campi
				cat.setCodProvSec(null);
				cat.setCodComuneSec(null);
				cat.setSezioneSec(null);
				cat.setFoglioSec(null);
				cat.setParticellaSec(null);
				cat.setSubalternoSec(null);

				ArrayList<Comune> comuni = new ArrayList<Comune>();
				theModel.setAppDatacomuniCertDtCatSecondari(comuni);

				att.getDatiAnagraficiImm().setDtCatastali(cat);
				theModel.setAppDatacertificato(att);

				result.setResultCode(ADDDATOCATASTALE_OUTCOME_CODE__OK);

				// BEPPE - 01/02/12 - SICEE-276
				/*
				 * } else { result.getGlobalErrors().add(
				 * "Non e' possibile aggiungere altri dati catastali");
				 * result.setResultCode(ADDDATOCATASTALE_OUTCOME_CODE__KO); }
				 */
			} else {
				result.setResultCode(ADDDATOCATASTALE_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addDatoCatastale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo deleteDatoCatastale definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults deleteDatoCatastale(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DELETEDATOCATASTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DELETEDATOCATASTALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R251507275) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("dato catastale selezionata id: " + theModel.getAppDatadatoCatastaleSelezionato());

			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadatoCatastaleSelezionato())) {
				result.getGlobalErrors().add("Attenzione. Nessun dato catastale selezionato.");

				result.setResultCode(DELETEDATOCATASTALE_OUTCOME_CODE__KO);
			} else {

				Integer indexRemove = null;
				if (theModel.getAppDatadatoCatastaleSelezionato() != null) {

					// PROBLEMA
					indexRemove = new Integer(theModel.getAppDatadatoCatastaleSelezionato());
				}

				ArrayList<DtCatastaliSecondari> catSec = theModel.getAppDatatempDtCatastaliSecondari();

				if (catSec != null && indexRemove != null) {

					catSec.remove(indexRemove.intValue());
				}

				theModel.setAppDatatempDtCatastaliSecondari(catSec);

				// impostazione del result code
				result.setResultCode(DELETEDATOCATASTALE_OUTCOME_CODE__OK);
				// modifica degli attributi del model (che verranno propagati
				// allo strato
				// di presentation). si puo' agire anche direttamente
				// sull'attributo "session".
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::deleteDatoCatastale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroDatiCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults indietroDatiCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRODATICATASTALI_OUTCOME_CODE__RICERCAACE = //NOSONAR  Reason:EIAS
				"RicercaACE"; //NOSONAR  Reason:EIAS
		final String INDIETRODATICATASTALI_OUTCOME_CODE__COMPILAZIONE = //NOSONAR  Reason:EIAS
				"Compilazione"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1455946988) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDataprovenienzaPerReport()
					.equalsIgnoreCase(INDIETRODATICATASTALI_OUTCOME_CODE__RICERCAACE))
				result.setResultCode(INDIETRODATICATASTALI_OUTCOME_CODE__RICERCAACE);
			else
				result.setResultCode(INDIETRODATICATASTALI_OUTCOME_CODE__COMPILAZIONE);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroDatiCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo controlloIndirizzo definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults controlloIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONTROLLOINDIRIZZO_OUTCOME_CODE__SELEZIONARE_INDIRIZZO = //NOSONAR  Reason:EIAS
				"SELEZIONARE_INDIRIZZO"; //NOSONAR  Reason:EIAS
		final String CONTROLLOINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONTROLLOINDIRIZZO_OUTCOME_CODE__DIGITARE_INDIRIZZO = //NOSONAR  Reason:EIAS
				"DIGITARE_INDIRIZZO"; //NOSONAR  Reason:EIAS
		final String CONTROLLOINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1575306644) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// l'utente potrebbe aver inserito la descrizione senza aver fatto la verifica indirizzo
			DatiAttestato att = theModel.getAppDatacertificato();
			if (!isVisibleState(theModel)) {
				DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

				if (GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())) {

					// richiamo il servizio di verifica indirizzo per verificare
					// se esiste l'indirizzo digitato
					// in tal caso chiedo all'utente di verificare
					try {
						if (cat.getDescrIndirizzo() != null)
							cat.setDescrIndirizzo(cat.getDescrIndirizzo().toUpperCase());

						String descrizioneIndirizzo = !GenericUtil.isNullOrEmpty(cat.getDescrIndirizzo())
								? cat.getDescrIndirizzo()
								: cat.getRicercaIndirizzo();
						theModel.setAppDatasuggestIndirizzoDtCat(caricaComboIndirizzi(descrizioneIndirizzo,
								Constants.COD_REGIONE_PIEMONTE, cat.getCodComune()));

					} catch (BEException e) {
						log.error(
								"[BackEndFacade::checkDatiAnagrafici] Errore occorso nell'esecuzione del metodo caricaComboIndirizzi:"
										+ e,
								e);
					}

					// se il servizio trova degli indirizzi li propone nella
					// combo
					if (theModel.getAppDatasuggestIndirizzoDtCat() != null
							&& theModel.getAppDatasuggestIndirizzoDtCat().size() > 0) {
						// cat.setRicercaIndirizzo(cat.getDescrIndirizzo());
						addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo",
								result);

						// verifico gli altri campi della pagina
						checkDatiAnagrafici(theModel, result);

						// impostazione del result code
						result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__SELEZIONARE_INDIRIZZO);
					}
				}

				else if (GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())
						&& theModel.getAppDatasuggestIndirizzoDtCat() != null
						&& theModel.getAppDatasuggestIndirizzoDtCat().size() > 0) {
					addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo",
							result);

					// verifico gli altri campi della pagina
					checkDatiAnagrafici(theModel, result);

					// impostazione del result code
					result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__SELEZIONARE_INDIRIZZO);
				}

				// se non sono stati trovati indirizzi controllo che sia
				// compilato il campo descrizione
				if (result.getResultCode() == null) {
					if (GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())
							&& GenericUtil.isNullOrEmpty(cat.getDescrIndirizzo())) {

						addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo",
								result);

						// verifico gli altri campi della pagina
						checkDatiAnagrafici(theModel, result);

						result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__DIGITARE_INDIRIZZO);
					}

					else {
						// impostazione del result code

						// verifico gli altri campi della pagina
						if (checkDatiAnagrafici(theModel, result)) {
							if (!GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())) {
								Indirizzo ind = getSOAIntegrationMgr().getIndirizzoById(cat.getCodIndirizzo());
								cat.setDescrIndirizzo(ind.getDescr().toUpperCase());
							}
							result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__OK);
						} else
							result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__KO);

					}
				}
			} else {
				result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__OK);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::controlloIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtCatastaliAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtCatastaliAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTCATASTALIAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTCATASTALIAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1285201212) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();

			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				//				boolean ok = checkDatiAnagrafici(theModel, result);
				//				if (ok) {
				DatiCertificatore cert = theModel.getAppDatacertificatore();
				getCertificatoMgr().aggiornaAttestato(cert, att);
				getCertificatoMgr().aggiornaDatiCatastali(cert, att, theModel.getAppDatatempDtCatastaliSecondari());

				result.setResultCode(BDTCATASTALIAVANTISALVA_OUTCOME_CODE__OK);
				att.getDatiAnagraficiImm().getDtCatastali().setRicercaIndirizzo(null);

				//				} else
				//					result.setResultCode(BDTCATASTALIAVANTISALVA_OUTCOME_CODE__KO);
			} else
				// impostazione del result code
				result.setResultCode(BDTCATASTALIAVANTISALVA_OUTCOME_CODE__OK);
			att.getDatiAnagraficiImm().getDtCatastali().setRicercaIndirizzo(null);

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtCatastaliAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneProgettista definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setRegioneProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONEPROGETTISTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2096753597) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().setDescrReg(
					getDescrRegione(theModel.getAppDataregioniCertProgettista(), theModel.getAppDatacertificato()
							.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().getCodReg()));

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista()
					.setCodProv(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista()
					.setDescrProv(null);

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista()
					.setCodComune(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista()
					.setDescrComune(null);

			theModel.setAppDatacomuniCertProgettista(new ArrayList<Comune>());

			// impostazione del result code
			result.setResultCode(SETREGIONEPROGETTISTA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneProgettista] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaProgettista definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIAPROGETTISTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R501239295) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().setDescrProv(
					getDescrProvincia(theModel.getAppDataprovinceCertProgettista(), theModel.getAppDatacertificato()
							.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().getCodProv()));

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista()
					.setCodComune(null);

			// impostazione del result code
			result.setResultCode(SETPROVINCIAPROGETTISTA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaProgettista] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneProgettista definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setComuneProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNEPROGETTISTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1446183821) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtProgettista()
					.setDescrComune(
							getDescrComune(theModel.getAppDatacomuniCertProgettista(), theModel.getAppDatacertificato()
									.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().getCodComune()));
			// impostazione del result code
			result.setResultCode(SETCOMUNEPROGETTISTA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneProgettista] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaIndirizzoProgettista definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZOPROGETTISTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1925389671) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato cert = theModel.getAppDatacertificato();
			SoggResponsabile dres = cert.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista();
			theModel.setAppDatasuggestIndirizzoCertProgettista(
					caricaComboIndirizzi(dres.getDescrIndirizzo(), dres.getCodReg(), dres.getCodComune()));
			// impostazione del result code
			result.setResultCode(VERIFICAINDIRIZZOPROGETTISTA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzoProgettista] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scegliIndirizzoProgettista definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults scegliIndirizzoProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCEGLIINDIRIZZOPROGETTISTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1963710079) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			SoggResponsabile dres = theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili()
					.getDtProgettista();

			Integer code = theModel.getAppDatasuggestIndirizzoCodProgettista();

			Indirizzo ind = getSOAIntegrationMgr().getIndirizzoById(code);
			dres.setDescrIndirizzo(ind.getDescr());
			dres.setCodIndirizzo(ind.getCod());

			// impostazione del result code
			result.setResultCode(SCEGLIINDIRIZZOPROGETTISTA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scegliIndirizzoProgettista] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneDirLav definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setRegioneDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONEDIRLAV_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1156761087) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().setDescrReg(
					getDescrRegione(theModel.getAppDataregioniCertDirLav(), theModel.getAppDatacertificato()
							.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().getCodReg()));

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori()
					.setCodProv(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori()
					.setDescrProv(null);

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori()
					.setCodComune(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori()
					.setDescrComune(null);

			theModel.setAppDatacomuniCertDirLav(new ArrayList<Comune>());
			// impostazione del result code
			result.setResultCode(SETREGIONEDIRLAV_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneDirLav] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDirLav definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADIRLAV_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R592602819) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().setDescrProv(
					getDescrProvincia(theModel.getAppDataprovinceCertDirLav(), theModel.getAppDatacertificato()
							.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().getCodProv()));
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori()
					.setCodComune(null);
			// impostazione del result code
			result.setResultCode(SETPROVINCIADIRLAV_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaDirLav] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneDirLav definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setComuneDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNEDIRLAV_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-699666315) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().setDescrComune(
					getDescrComune(theModel.getAppDatacomuniCertDirLav(), theModel.getAppDatacertificato()
							.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().getCodComune()));
			// impostazione del result code
			result.setResultCode(SETCOMUNEDIRLAV_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneDirLav] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaIndirizzoDirLav definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZODIRLAV_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1552574885) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato cert = theModel.getAppDatacertificato();
			SoggResponsabile dres = cert.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori();
			theModel.setAppDatasuggestIndirizzoCertDirLav(
					caricaComboIndirizzi(dres.getDescrIndirizzo(), dres.getCodReg(), dres.getCodComune()));
			// impostazione del result code
			result.setResultCode(VERIFICAINDIRIZZODIRLAV_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzoDirLav] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scegliIndirizzoDirLav definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults scegliIndirizzoDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCEGLIINDIRIZZODIRLAV_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R406031939) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			SoggResponsabile dres = theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili()
					.getDtDirLavori();

			Integer code = theModel.getAppDatasuggestIndirizzoCodDirLav();

			Indirizzo ind = getSOAIntegrationMgr().getIndirizzoById(code);
			dres.setDescrIndirizzo(ind.getDescr());
			dres.setCodIndirizzo(ind.getCod());

			// impostazione del result code
			result.setResultCode(SCEGLIINDIRIZZODIRLAV_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scegliIndirizzoDirLav] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneCostr definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setRegioneCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONECOSTR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R773651008) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore()
					.setDescrReg(getDescrRegione(theModel.getAppDataregioniCertCostr(), theModel.getAppDatacertificato()
							.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore().getCodReg()));

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore()
					.setCodProv(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore()
					.setDescrProv(null);

			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore()
					.setCodComune(null);
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore()
					.setDescrComune(null);

			theModel.setAppDatacomuniCertCostr(new ArrayList<Comune>());
			// impostazione del result code
			result.setResultCode(SETREGIONECOSTR_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneCostr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaCostr definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIACOSTR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1599852292) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore().setDescrProv(
					getDescrProvincia(theModel.getAppDataprovinceCertCostr(), theModel.getAppDatacertificato()
							.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore().getCodProv()));
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore()
					.setCodComune(null);
			// impostazione del result code
			result.setResultCode(SETPROVINCIACOSTR_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaCostr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneCostr definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults setComuneCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNECOSTR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1683597578) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore()
					.setDescrComune(
							getDescrComune(theModel.getAppDatacomuniCertCostr(), theModel.getAppDatacertificato()
									.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore().getCodComune()));
			// impostazione del result code
			result.setResultCode(SETCOMUNECOSTR_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneCostr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaIndirizzoCostr definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZOCOSTR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-837767580) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato cert = theModel.getAppDatacertificato();
			SoggResponsabile dres = cert.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore();
			theModel.setAppDatasuggestIndirizzoCertCostr(
					caricaComboIndirizzi(dres.getDescrIndirizzo(), dres.getCodReg(), dres.getCodComune()));
			// impostazione del result code
			result.setResultCode(VERIFICAINDIRIZZOCOSTR_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzoCostr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scegliIndirizzoCostr definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults scegliIndirizzoCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCEGLIINDIRIZZOCOSTR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2134907260) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			SoggResponsabile dres = theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtResponsabili()
					.getDtCostruttore();
			Integer code = theModel.getAppDatasuggestIndirizzoCodCostr();

			Indirizzo ind = getSOAIntegrationMgr().getIndirizzoById(code);
			dres.setDescrIndirizzo(new String(ind.getDescr()));
			dres.setCodIndirizzo(new Integer(ind.getCod()));

			// impostazione del result code
			result.setResultCode(SCEGLIINDIRIZZOCOSTR_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scegliIndirizzoCostr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtResponsAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtResponsAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTRESPONSAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTRESPONSAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1959516618) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok1 = checkAnagCostr(theModel, result);
				boolean ok2 = checkAnagDirLav(theModel, result);
				boolean ok3 = checkAnagProgettista(theModel, result);

				if (ok1 && ok2 && ok3) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();

					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTRESPONSAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTRESPONSAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTRESPONSAVANTISALVA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtResponsAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtAnagCoCertificatoreSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtAnagCoCertificatoreSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTANAGCOCERTIFICATORESALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTANAGCOCERTIFICATORESALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2035784144) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkAnagCoCertificatore(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();

					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTANAGCOCERTIFICATORESALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTANAGCOCERTIFICATORESALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTANAGCOCERTIFICATORESALVA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtAnagCoCertificatoreSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboTipoImpianto definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults gestisciComboTipoImpianto(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOTIPOIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-243557922) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDatacertificato().getDatiTecnici().setTipoEdificio("");
			theModel.getAppDatacertificato().getDatiTecnici().setCarattEdificio("");
			theModel.setAppDatacarattEdificio(new ArrayList<CarattEdificio>());

			// impostazione del result code
			result.setResultCode(GESTISCICOMBOTIPOIMPIANTO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboTipoImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtTecniciCalcola definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtTecniciCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTTECNICICALCOLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-3684824) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			boolean ok = checkDatiTecniciGenerali(theModel, result);
			if (ok) {

				try {
					getCalcoloMgr().calcolaDatiTecniciGenerali(theModel);
				} catch (CalcoloException e) {
					result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
				}
			}
			// impostazione del result code
			result.setResultCode(BDTTECNICICALCOLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtTecniciCalcola] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtTecniciAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtTecniciAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTTECNICIAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTTECNICIAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R467576325) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkDatiTecniciGenerali(theModel, result);
				if (ok) {

					try {
						getCalcoloMgr().calcolaDatiTecniciGenerali(theModel);
						DatiCertificatore cert = theModel.getAppDatacertificatore();
						getCertificatoMgr().aggiornaAttestato(cert, att);
						result.setResultCode(BDTTECNICIAVANTISALVA_OUTCOME_CODE__OK);
					} catch (CalcoloException e) {
						result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
						result.setResultCode(BDTTECNICIAVANTISALVA_OUTCOME_CODE__KO);
					}

				} else
					result.setResultCode(BDTTECNICIAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTTECNICIAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtTecniciAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFabbisognoCalcola definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtFabbisognoCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFABBISOGNOCALCOLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-501330749) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			boolean ok = checkFabbisogno(theModel, result);
			if (ok) {

				try {
					getCalcoloMgr().calcolaFabbisogno(theModel);
				} catch (CalcoloException e) {
					result.getGlobalErrors().add(e.getMessage());
					// .add("Possibili divisioni per zero. Verificare i dati inseriti");
				}
			}
			// impostazione del result code
			result.setResultCode(BDTFABBISOGNOCALCOLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFabbisognoCalcola] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFabbisognoAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtFabbisognoAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFABBISOGNOAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTFABBISOGNOAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1275750176) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkFabbisogno(theModel, result);
				if (ok) {

					try {
						getCalcoloMgr().calcolaFabbisogno(theModel);
						DatiCertificatore cert = theModel.getAppDatacertificatore();
						DtLocTeorica teorica = att.getClasseEnerg().getLocTeorica();
						DtIndiciFabbisogno fabb = att.getIndFabbisogno();

						if (BaseMgr.isNullOrEmpty(teorica.getDomEnergAcqua()))
							teorica.setDomEnergAcqua(fabb.getDomEnergAcqua());

						if (BaseMgr.isNullOrEmpty(teorica.getEnergTermAcquaRinnov()))
							teorica.setEnergTermAcquaRinnov(fabb.getEnergTermAcquaRinnov());

						// Beppe-Manu - il campo rendGlobStagioneAcqua di classe
						// energetica teorica è stato eliminato dalla
						// pagina (rilascio dicembre 2010-febbraio 2012) ma
						// abbiamo lasciato comunque il popolamento del campo
						// analogo al rendGlobStagioneAcqua di fabbisogno
						if (BaseMgr.isNullOrEmpty(teorica.getRendGlobStagioneAcqua()))
							teorica.setRendGlobStagioneAcqua(fabb.getRendGlobStagioneAcqua());

						if (BaseMgr.isNullOrEmpty(teorica.getIndPrestEnergAcqua()))
							teorica.setIndPrestEnergAcqua(fabb.getIndPrestEnergAcqua());

						log.debug("Codice COMUNE: " + att.getDatiAnagraficiImm().getDtCatastali().getCodComune());
						if (att.getDatiAnagraficiImm().getDtCatastali().getCodComune().equals(Constants.ISTAT_TORINO)) {
							teorica.setDomEnergRiscald(fabb.getDomEnergRiscald());
						}

						getCertificatoMgr().aggiornaAttestato(cert, att);
						result.setResultCode(BDTFABBISOGNOAVANTISALVA_OUTCOME_CODE__OK);
					} catch (CalcoloException e) {
						result.getGlobalErrors().add(e.getMessage());
						/*
						 * result.getGlobalErrors() .add(
						 * "Possibili divisioni per zero. Verificare i dati inseriti"
						 * );
						 */
						result.setResultCode(BDTFABBISOGNOAVANTISALVA_OUTCOME_CODE__KO);
					}

				} else
					result.setResultCode(BDTFABBISOGNOAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTFABBISOGNOAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFabbisognoAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtLocRealeCalcola definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocRealeCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTLOCREALECALCOLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-492399444) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			boolean ok = checkClasseEnergeticaReale(theModel, result);
			if (ok) {

				try {
					getCalcoloMgr().calcolaClasseEnergeticaReale(theModel);
				} catch (CalcoloException e) {
					result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
				}
			}
			// impostazione del result code
			result.setResultCode(BDTLOCREALECALCOLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtLocRealeCalcola] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtLocRealeAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocRealeAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTLOCREALEAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTLOCREALEAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1108700535) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkClasseEnergeticaReale(theModel, result);
				if (ok) {
					try {
						getCalcoloMgr().calcolaClasseEnergeticaReale(theModel);
						DatiCertificatore cert = theModel.getAppDatacertificatore();
						getCertificatoMgr().aggiornaAttestato(cert, att);
						result.setResultCode(BDTLOCREALEAVANTISALVA_OUTCOME_CODE__OK);
					} catch (CalcoloException e) {
						result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
						result.setResultCode(BDTLOCREALEAVANTISALVA_OUTCOME_CODE__KO);
					}

				} else
					result.setResultCode(BDTLOCREALEAVANTISALVA_OUTCOME_CODE__KO);
			} else {
				result.setResultCode(BDTLOCREALEAVANTISALVA_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::bDtLocRealeAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtLocTeorCalcola definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocTeorCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTLOCTEORCALCOLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-387315287) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			boolean ok = checkClasseEnergeticaTeorica(theModel, result);
			if (ok) {

				try {
					getCalcoloMgr().calcolaClasseEnergeticaTeorica(theModel);

					if (GenericUtil.convertTo(theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica()
							.getIndPrestEnergGlob()) > 99999) {

						theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica().setIndPrestEnergGlob(null);

						theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica().setClasseEnerg(null);

						theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica().setDescClasseEnerg(null);

						throw new Exception(
								"Non esiste nessuna classe energetica per l'Indice di prestazione energetica globale calcolato");
					}

					if (GenericUtil.convertTo(theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica()
							.getIndPrestEnergGlob()) < 0) {
						throw new Exception(
								"Non esiste nessuna classe energetica per l'Indice di prestazione energetica globale calcolato");
					}

					if (theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica().getClasseEnerg() == null) {
						throw new Exception(
								"Non esiste nessuna classe energetica per l'Indice di prestazione energetica globale calcolato");
					}

				} catch (CalcoloException e) {
					result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
				} catch (Exception e) {
					result.getGlobalErrors().add(e.getMessage());

				}
			}
			// impostazione del result code
			result.setResultCode(BDTLOCTEORCALCOLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtLocTeorCalcola] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtLocTeoricaAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocTeoricaAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTLOCTEORICAAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTLOCTEORICAAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1455265803) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkClasseEnergeticaTeorica(theModel, result);
				if (ok) {

					try {
						getCalcoloMgr().calcolaClasseEnergeticaTeorica(theModel);

						if (GenericUtil.convertTo(theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica()
								.getIndPrestEnergGlob()) > 99999) {

							theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica()
									.setIndPrestEnergGlob(null);

							theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica().setClasseEnerg(null);

							theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica().setDescClasseEnerg(null);

							throw new Exception(
									"Non esiste nessuna classe energetica per l'Indice di prestazione energetica globale calcolato");
						}

						if (GenericUtil.convertTo(theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica()
								.getIndPrestEnergGlob()) < 0) {
							throw new Exception(
									"Non esiste nessuna classe energetica per l'Indice di prestazione energetica globale calcolato");
						}

						if (theModel.getAppDatacertificato().getClasseEnerg().getLocTeorica()
								.getClasseEnerg() == null) {
							throw new Exception(
									"Non esiste nessuna classe energetica per l'Indice di prestazione energetica globale calcolato");
						}

						DatiCertificatore cert = theModel.getAppDatacertificatore();
						getCertificatoMgr().aggiornaAttestato(cert, att);
						result.setResultCode(BDTLOCTEORICAAVANTISALVA_OUTCOME_CODE__OK);
					} catch (CalcoloException e) {
						result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
						result.setResultCode(BDTLOCTEORICAAVANTISALVA_OUTCOME_CODE__KO);
					} catch (Exception e) {
						result.getGlobalErrors().add(e.getMessage());
						result.setResultCode(BDTLOCTEORICAAVANTISALVA_OUTCOME_CODE__KO);
					}

				} else
					result.setResultCode(BDTLOCTEORICAAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTLOCTEORICAAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtLocTeoricaAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFontiRinnovCalcola definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtFontiRinnovCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFONTIRINNOVCALCOLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-381359827) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				getCalcoloMgr().calcolaFontiRinnov(theModel);
			} catch (CalcoloException e) {
				result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
			}
			// impostazione del result code
			result.setResultCode(BDTFONTIRINNOVCALCOLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFontiRinnovCalcola] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFontiRinnovAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtFontiRinnovAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFONTIRINNOVAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTFONTIRINNOVAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-329728374) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			boolean ok = checkEnergiaFontiRinnovabili(theModel, result);
			if (!isVisibleState(theModel)) {
				if (ok) {
					//getCalcoloMgr().calcolaFontiRinnov(theModel);
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					DatiAttestato att = theModel.getAppDatacertificato();
					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTFONTIRINNOVAVANTISALVA_OUTCOME_CODE__OK);

				} else {
					result.setResultCode(BDTFONTIRINNOVAVANTISALVA_OUTCOME_CODE__KO);
				}
			} else {
				result.setResultCode(BDTFONTIRINNOVAVANTISALVA_OUTCOME_CODE__OK);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFontiRinnovAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtAltriGeneraliAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriGeneraliAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTALTRIGENERALIAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTALTRIGENERALIAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1762339885) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkGenerali(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTALTRIGENERALIAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTALTRIGENERALIAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTALTRIGENERALIAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtAltriGeneraliAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addRaccomandazione definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults addRaccomandazione(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDRACCOMANDAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ADDRACCOMANDAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R563252579) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getWidg_cbSistema();
			theModel.getWidg_rbsPriorita();
			theModel.getWidg_tfIntervento();
			theModel.getWidg_tfTempoRitorno();

			if (log.isDebugEnabled()) {
				log.debug("Sistema = " + theModel.getWidg_cbSistema());
				log.debug("Intervento = " + theModel.getWidg_tfIntervento());
				log.debug("Priorita = " + theModel.getWidg_rbsPriorita());
				log.debug("Tempo ritorno = " + theModel.getWidg_tfTempoRitorno());
			}

			boolean ok = checkRaccomandazioni(theModel, result);
			if (ok) {
				boolean found = false;
				if (theModel.getAppDatatempRaccomandazioni() == null) {
					theModel.setAppDatatempRaccomandazioni(new ArrayList<Raccomandazione>());
				}
				ArrayList<Raccomandazione> racc = theModel.getAppDatatempRaccomandazioni();
				int edi = 0;
				int imp = 0;
				for (int i = 0; i < racc.size(); i++) {
					if (racc.get(i).getCodSistema().equals("EDIFICIO")) {
						edi++;
					} else {
						imp++;
					}
				}

				if (log.isDebugEnabled()) {
					log.debug("EDIFICI : " + edi);
					log.debug("IMPIANTI : " + imp);
				}

				if ((edi < 4 || imp < 4) && ((imp + edi) < 8)) {
					if (edi >= 4 && theModel.getWidg_cbSistema().equals("EDIFICIO")) {
						result.getGlobalErrors()
								.add("Non e' possibile aggiungere un ulteriore intervento per il sistema scelto");
						result.setResultCode(ADDRACCOMANDAZIONE_OUTCOME_CODE__KO);
					} else if (imp >= 4 && theModel.getWidg_cbSistema().equals("IMPIANTO")) {
						result.getGlobalErrors()
								.add("Non e' possibile aggiungere un ulteriore intervento per il sistema scelto");
						result.setResultCode(ADDRACCOMANDAZIONE_OUTCOME_CODE__KO);
					} else {

						for (int i = 0; i < racc.size(); i++) {
							if (racc.get(i).getId().equals(theModel.getWidg_cbSistema() + "-"
									+ theModel.getWidg_tfIntervento() + "-" + theModel.getWidg_rbsPriorita())) {
								found = true;
								break;
							}
						}

						if (!found) {
							Raccomandazione r = new Raccomandazione();
							r.setId(theModel.getWidg_cbSistema() + "-" + theModel.getWidg_tfIntervento() + "-"
									+ theModel.getWidg_rbsPriorita());
							r.setCodSistema(theModel.getWidg_cbSistema());
							r.setIntervento(theModel.getWidg_tfIntervento());
							r.setTempoRitorno(theModel.getWidg_tfTempoRitorno());
							r.setPriorita(theModel.getWidg_rbsPriorita());
							List<SiceeDPriorita> prioritaList = getCertificatoMgr().recuperaPriorita();
							if (prioritaList != null) {
								for (int j = 0; j < prioritaList.size(); j++) {
									SiceeDPriorita priorita = prioritaList.get(j);
									if (r.getPriorita().equals(priorita.getPriorita())) {
										r.setDescrPriorita(priorita.getDescr());
										break;
									}
								}

							}

							racc.add(r);
							Raccomandazione[] list = new Raccomandazione[racc.size()];
							racc.toArray(list);
							Arrays.sort(list, new RaccomandazioneComparator());
							racc = new ArrayList<Raccomandazione>();
							racc.addAll(Arrays.asList(list));
							theModel.setAppDatatempRaccomandazioni(racc);

							/*
							 * for (int i = 0; i < racc.size(); i++) { char
							 * prioritaPresente = racc.get(i)
							 * .getPriorita().charAt(0); if (prioritaDaAgg <=
							 * prioritaPresente) { aggiunto = true;
							 * theModel.getAppDatatempRaccomandazioni()
							 * .add(pos, r); break; } else pos = pos + 1; } if
							 * (!aggiunto)
							 * theModel.getAppDatatempRaccomandazioni().add(
							 * pos, r);
							 */

							result.setResultCode(ADDRACCOMANDAZIONE_OUTCOME_CODE__OK);
						} else {
							result.getGlobalErrors().add("Raccomandazione gia' esistente");
							result.setResultCode(ADDRACCOMANDAZIONE_OUTCOME_CODE__KO);
						}
					}
				} else {
					result.getGlobalErrors()
							.add("Non e' possibile aggiungere un ulteriore intervento per il sistema scelto");
					result.setResultCode(ADDRACCOMANDAZIONE_OUTCOME_CODE__KO);
				}

			} else {
				result.setResultCode(ADDRACCOMANDAZIONE_OUTCOME_CODE__KO);
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
			log.error("[BackEndFacade::addRaccomandazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo deleteRaccomandazione definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults deleteRaccomandazione(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DELETERACCOMANDAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R954732097) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Raccomandazione selezionata id: " + theModel.getAppDataraccomandazioneSelezionata());

			ArrayList<Raccomandazione> racc = theModel.getAppDatatempRaccomandazioni();
			if (racc != null) {
				for (int i = 0; i < racc.size(); i++) {
					if (racc.get(i).getId().equals(theModel.getAppDataraccomandazioneSelezionata())) {
						racc.remove(i);
						break;
					}
				}
			}
			theModel.setAppDatatempRaccomandazioni(racc);
			// impostazione del result code
			result.setResultCode(DELETERACCOMANDAZIONE_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::deleteRaccomandazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtAltriRaccomandAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriRaccomandAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTALTRIRACCOMANDAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTALTRIRACCOMANDAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-752846996) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {

				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				getCertificatoMgr().aggiornaAttestato(cert, att);
				if (theModel.getAppDatatempRaccomandazioni() != null
						&& !theModel.getAppDatatempRaccomandazioni().isEmpty()) {
					result.setResultCode(BDTALTRIRACCOMANDAVANTISALVA_OUTCOME_CODE__OK);
				} else {
					// non ci sono raccomandazioni: sono obbligatorie tranne nel
					// caso di edificio performante checked
					DtClasseEnerg classeEnerg = att.getClasseEnerg();
					if (classeEnerg.getLocTeorica().getClasseEnerg() != null
							&& classeEnerg.getLocTeorica().getClasseEnerg().equals(Constants.CLASSE_ENERGETICA_APIU)) {
						// vado a vedere se e' cecked il flag dell'edificio
						// performante:se non lo e' ci deve per forza essere
						// almeno una raccomandazione
						DtAltreInfo altreInfo = att.getAltreInfo();

						if (altreInfo.getFlgEdificioPerformante() == null || !altreInfo.getFlgEdificioPerformante()) {
							result.getGlobalErrors().add(
									"E' obbligatorio inserire almeno una raccomandazione o indicare che l'edificio non necessiti di interventi migliorativi.");
							result.setResultCode(BDTALTRIRACCOMANDAVANTISALVA_OUTCOME_CODE__KO);
						} else
							result.setResultCode(BDTALTRIRACCOMANDAVANTISALVA_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("E' obbligatorio l'inserimento di almeno una raccomandazione.");
						result.setResultCode(BDTALTRIRACCOMANDAVANTISALVA_OUTCOME_CODE__KO);
					}
				}
				getCertificatoMgr().aggiornaAttestato(cert, att, theModel.getAppDatatempRaccomandazioni());
			} else {
				result.setResultCode(BDTALTRIRACCOMANDAVANTISALVA_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::bDtAltriRaccomandAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtAltriEnergAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriEnergAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTALTRIENERGAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTALTRIENERGAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R312121267) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkEnergetiche(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					DatiAttestato att = theModel.getAppDatacertificato();
					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTALTRIENERGAVANTISALVA_OUTCOME_CODE__OK);
				} else {
					result.setResultCode(BDTALTRIENERGAVANTISALVA_OUTCOME_CODE__KO);
				}
			} else
				result.setResultCode(BDTALTRIENERGAVANTISALVA_OUTCOME_CODE__OK);

			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtAltriEnergAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtAltriSopralluoghiAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriSopralluoghiAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTALTRISOPRALLUOGHIAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTALTRISOPRALLUOGHIAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-162947971) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkSopralluoghi(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					DatiAttestato att = theModel.getAppDatacertificato();
					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTALTRISOPRALLUOGHIAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTALTRISOPRALLUOGHIAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTALTRISOPRALLUOGHIAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtAltriSopralluoghiAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtNormativeVigente definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtNormativeVigente(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTNORMATIVEVIGENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R679011935) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			getCertificatoMgr().getNormativaVigente(theModel.getAppDatacertificato());
			// impostazione del result code
			result.setResultCode(BDTNORMATIVEVIGENTE_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtNormativeVigente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ripulisciCampi definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults ripulisciCampi(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPULISCICAMPI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1816903398) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificato().getRispNorme().setAutorizzato(null);
			// impostazione del result code
			result.setResultCode(RIPULISCICAMPI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ripulisciCampi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtNormativeAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtNormativeAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTNORMATIVEAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTNORMATIVEAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-653445349) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (getCertificatoMgr().getNormativaVigente(theModel.getAppDatacertificato())) {
				// r.getFldErrors().put("" + fname, " non è valida");
			}
			boolean ok = checkRispettoNormative(theModel, result);
			if (ok) {
				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				getCertificatoMgr().aggiornaAttestato(cert, att);
				result.setResultCode(BDTNORMATIVEAVANTISALVA_OUTCOME_CODE__OK);
			} else
				result.setResultCode(BDTNORMATIVEAVANTISALVA_OUTCOME_CODE__KO);

			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtNormativeAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtLimNormRegImpTermToCalcola definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtLimNormRegImpTermToCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTLIMNORMREGIMPTERMTOCALCOLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1906892032) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			boolean ok = checkImpiantoLimiteNormativoRegionale(theModel, result);
			if (ok) {
				try {
					getCalcoloMgr().calcolaLimiteNormativoRegionaleImpiantoTermico(theModel);
				} catch (CalcoloException e) {
					result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
				}
			}
			// impostazione del result code
			result.setResultCode(BDTLIMNORMREGIMPTERMTOCALCOLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtLimNormRegImpTermToCalcola] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtRiscaldamentoAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtRiscaldamentoAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTRISCALDAMENTOAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTRISCALDAMENTOAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1967073940) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkImpiantoRiscaldamento(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					DatiAttestato att = theModel.getAppDatacertificato();

					getCalcoloMgr().calcolaIndicePrestazioneEnergeticaGlobaleLimiteTorino(theModel);
					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTRISCALDAMENTOAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTRISCALDAMENTOAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTRISCALDAMENTOAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtRiscaldamentoAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtAcquaCaldaAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtAcquaCaldaAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTACQUACALDAAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTACQUACALDAAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1116961170) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkImpiantoAcquaCalda(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					DatiAttestato att = theModel.getAppDatacertificato();
					getCertificatoMgr().aggiornaAttestato(cert, att);

					// impostazione del result code
					result.setResultCode(BDTACQUACALDAAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTACQUACALDAAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTACQUACALDAAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtAcquaCaldaAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtEmissGasAndSuperfBoscoCalcola definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtEmissGasAndSuperfBoscoCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTEMISSGASANDSUPERFBOSCOCALCOLA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R564698413) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				getCalcoloMgr().calcolaEmissioniGasSerraEEttariBosco(theModel);
			} catch (CalcoloException e) {
				result.getGlobalErrors().add("Possibili divisioni per zero. Verificare i dati inseriti");
			}
			// impostazione del result code
			result.setResultCode(BDTEMISSGASANDSUPERFBOSCOCALCOLA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::bDtEmissGasAndSuperfBoscoCalcola] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtGasSerraAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtGasSerraAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTGASSERRAAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTGASSERRAAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R959797400) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkGasSerra(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					DatiAttestato att = theModel.getAppDatacertificato();
					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTGASSERRAAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTGASSERRAAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTGASSERRAAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtGasSerraAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtConsumiAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtConsumiAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTCONSUMIAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-768087662) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiAttestato att = theModel.getAppDatacertificato();
			getCertificatoMgr().aggiornaAttestato(cert, att);
			result.setResultCode(BDTCONSUMIAVANTISALVA_OUTCOME_CODE__OK);

			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtConsumiAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtDichiarazAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtDichiarazAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTDICHIARAZAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTDICHIARAZAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1168762821) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkDichiarazioni(theModel, result);
				if (ok) {
					DatiCertificatore cert = theModel.getAppDatacertificatore();
					DatiAttestato att = theModel.getAppDatacertificato();
					att.getDichiarazioni().setCodDichiaraz(theModel.getAppDatatempDichiarazSelez());
					getCertificatoMgr().aggiornaAttestato(cert, att);
					result.setResultCode(BDTDICHIARAZAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTDICHIARAZAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTDICHIARAZAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtDichiarazAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFotoCarica definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtFotoCarica(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFOTOCARICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R947132525) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			boolean ok = checkDatiFotoCarica(theModel, result);
			if (ok) {

				Integer errorCaricamento = aggiornaFoto(theModel);

				if (errorCaricamento != null) {

					log.debug("errorCaricamento: " + errorCaricamento);

					if (errorCaricamento.intValue() == Constants.ERRORE_INDEX.intValue()) {
						log.debug("ERRORE INDEX");

						result.getGlobalErrors()
								.add("Aggiornamento della foto non avvenuto correttamente. Si prega di riprovare");
					} else if (errorCaricamento.intValue() == Constants.ERRORE_FOTO.intValue()) {

						log.debug("ERRORE FOTO");

						result.getGlobalErrors().add(
								"Attenzione e' necessario sostituire la foto. Si consiglia di caricare la foto con le caratteristiche specificate nella nota");
					}

				} else {
					getCertificatoMgr().aggiornaAttestato(theModel.getAppDatacertificatore(),
							theModel.getAppDatacertificato());
					result.getGlobalMessages().add("Aggiornamento foto avvenuto correttamente");
				}
			}
			// impostazione del result code
			result.setResultCode(BDTFOTOCARICA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFotoCarica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFotoAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults bDtFotoAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFOTOAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTFOTOAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-265950618) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				boolean ok = checkDatiFotoConferma(theModel, result);
				if (ok) {
					result.setResultCode(BDTFOTOAVANTISALVA_OUTCOME_CODE__OK);
				} else
					result.setResultCode(BDTFOTOAVANTISALVA_OUTCOME_CODE__KO);
			} else
				result.setResultCode(BDTFOTOAVANTISALVA_OUTCOME_CODE__OK);
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFotoAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaBozza definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults stampaBozza(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPABOZZA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPABOZZA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1372952128) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode(STAMPABOZZA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaBozza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaDefinitivo definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults stampaDefinitivo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPADEFINITIVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPADEFINITIVO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-35872489) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode(STAMPADEFINITIVO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaDefinitivo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaAllaHome definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults tornaAllaHome(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAALLAHOME_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-174977107) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getSession().put("active_menu", "menu_items_" + "mnuhome");

			// impostazione del result code
			result.setResultCode(TORNAALLAHOME_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::tornaAllaHome] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo switchScreenState definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHSCREENSTATE_OUTCOME_CODE__REGISTRAZIONE = //NOSONAR  Reason:EIAS
				"REGISTRAZIONE"; //NOSONAR  Reason:EIAS
		final String SWITCHSCREENSTATE_OUTCOME_CODE__VISUALIZZAZIONE = //NOSONAR  Reason:EIAS
				"VISUALIZZAZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1801232197) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Alex 23/07/2015: modalità read-only per ogni tipologia di pratica sul vecchio SICEE
			/*
			 DatiAttestato att = theModel.getAppDatacertificato();
			 if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				 result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__REGISTRAZIONE);
			} else if ((att.getStatus() == Constants.NUOVO) 
					||(att.getStatus() == Constants.BOZZA)) {
				 result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__REGISTRAZIONE);
			 } else {
				 result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__VISUALIZZAZIONE);
			 }
			 */
			result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__VISUALIZZAZIONE);

			// impostazione del result code
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchScreenState] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisibComboImpDatiTecnici definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults gestisciVisibComboImpDatiTecnici(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISIBCOMBOIMPDATITECNICI_OUTCOME_CODE__ABILITA_COMBO_T_IMP_DATI_TEC = //NOSONAR  Reason:EIAS
				"ABILITA_COMBO_T_IMP_DATI_TEC"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISIBCOMBOIMPDATITECNICI_OUTCOME_CODE__DISABILITA_COMBO_T_IMP_DATI_TEC = //NOSONAR  Reason:EIAS
				"DISABILITA_COMBO_T_IMP_DATI_TEC"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1389809911) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String destUso = theModel.getAppDatacertificato().getDatiTecnici().getDestUso();

			if (!GenericUtil.isNullOrEmpty(destUso)) {

				int idDestUso = Integer.valueOf(destUso);

				if (idDestUso == Constants.ID_DEST_USO_E1_1 || idDestUso == Constants.ID_DEST_USO_E1_2) {
					// Abilito le combo
					result.setResultCode(GESTISCIVISIBCOMBOIMPDATITECNICI_OUTCOME_CODE__ABILITA_COMBO_T_IMP_DATI_TEC);

				} else {
					result.setResultCode(
							GESTISCIVISIBCOMBOIMPDATITECNICI_OUTCOME_CODE__DISABILITA_COMBO_T_IMP_DATI_TEC);
					pulisciComboEdificio(theModel);
				}
			} else {
				result.setResultCode(GESTISCIVISIBCOMBOIMPDATITECNICI_OUTCOME_CODE__DISABILITA_COMBO_T_IMP_DATI_TEC);
				pulisciComboEdificio(theModel);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciVisibComboImpDatiTecnici] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisibFabbisognoAcquaCalda definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults gestisciVisibFabbisognoAcquaCalda(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISIBFABBISOGNOACQUACALDA_OUTCOME_CODE__ABILITA_FAB_ACQUA_CALDA = //NOSONAR  Reason:EIAS
				"ABILITA_FAB_ACQUA_CALDA"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISIBFABBISOGNOACQUACALDA_OUTCOME_CODE__DISABILITA_FAB_ACQUA_CALDA = //NOSONAR  Reason:EIAS
				"DISABILITA_FAB_ACQUA_CALDA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1598570370) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato att = theModel.getAppDatacertificato();
			DtIndiciFabbisogno cat = att.getIndFabbisogno();

			if (!GenericUtil.isNullOrEmpty(cat.getFabAcquaCaldaSanit())
					&& cat.getFabAcquaCaldaSanit().equalsIgnoreCase(Constants.NO)) {
				cat.setDomEnergAcqua(new UDTPositiveDoubleFour(new Double(0)));
				cat.setEnergTermAcquaRinnov(new UDTPositiveDoubleFour(new Double(0)));

				cat.setIndPrestEnergAcqua(new UDTPositiveDoubleFour(new Double(0)));

				DtLocTeorica locTeorica = att.getClasseEnerg().getLocTeorica();

				locTeorica.setDomEnergAcqua(new UDTPositiveDoubleFour(new Double(0)));
				locTeorica.setEnergTermAcquaRinnov(new UDTPositiveDoubleFour(new Double(0)));

				locTeorica.setIndPrestEnergAcqua(new UDTPositiveDoubleFour(new Double(0)));

				result.setResultCode(GESTISCIVISIBFABBISOGNOACQUACALDA_OUTCOME_CODE__DISABILITA_FAB_ACQUA_CALDA);
			} else {
				result.setResultCode(GESTISCIVISIBFABBISOGNOACQUACALDA_OUTCOME_CODE__ABILITA_FAB_ACQUA_CALDA);

			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciVisibFabbisognoAcquaCalda] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciBottoneStampaDefinitiva definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults gestisciBottoneStampaDefinitiva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIBOTTONESTAMPADEFINITIVA_OUTCOME_CODE__ABILITA_STAMPA_DEF = //NOSONAR  Reason:EIAS
				"ABILITA_STAMPA_DEF"; //NOSONAR  Reason:EIAS
		final String GESTISCIBOTTONESTAMPADEFINITIVA_OUTCOME_CODE__DISABILITA_STAMPA_DEF = //NOSONAR  Reason:EIAS
				"DISABILITA_STAMPA_DEF"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2095226897) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato att = theModel.getAppDatacertificato();

			if (att.getStatus() == Constants.ANNULLATO || att.getStatus() == Constants.ANNULLATO_BO) {
				result.setResultCode(GESTISCIBOTTONESTAMPADEFINITIVA_OUTCOME_CODE__DISABILITA_STAMPA_DEF);
			} else {
				result.setResultCode(GESTISCIBOTTONESTAMPADEFINITIVA_OUTCOME_CODE__ABILITA_STAMPA_DEF);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciBottoneStampaDefinitiva] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-710652944) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);
			gestisciComboDtCatastoSecondari(theModel);
			gestisciComboProgettista(theModel);
			gestisciComboDirLav(theModel);
			gestisciComboCostr(theModel);
			gestisciComboComuni(theModel);

			gestisciComboEdificio(theModel);

			// indirizzi
			theModel.setAppDatasuggestIndirizzo(new ArrayList<Indirizzo>());
			theModel.setAppDatasuggestIndirizzoCertCostr(new ArrayList<Indirizzo>());
			theModel.setAppDatasuggestIndirizzoCertDirLav(new ArrayList<Indirizzo>());
			theModel.setAppDatasuggestIndirizzoCertProgettista(new ArrayList<Indirizzo>());
			if (theModel.getAppDatasuggestIndirizzoDtCat() == null)
				theModel.setAppDatasuggestIndirizzoDtCat(new ArrayList<Indirizzo>());

			// impostazione del result code
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
	 * Implementazione del metodo isEdificioPerformante definito in un ExecCommand del
	 * ContentPanel cpCompilaz
	 */
	public ExecResults isEdificioPerformante(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISEDIFICIOPERFORMANTE_OUTCOME_CODE__OKEDIFICIOPERF = //NOSONAR  Reason:EIAS
				"OKEdificioPerf"; //NOSONAR  Reason:EIAS
		final String ISEDIFICIOPERFORMANTE_OUTCOME_CODE__KOEDIFICIOPERF = //NOSONAR  Reason:EIAS
				"KOEdificioPerf"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1359752093) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato cert = theModel.getAppDatacertificato();
			DtClasseEnerg classeEnerg = cert.getClasseEnerg();
			// impostazione del result code
			if (classeEnerg.getLocTeorica().getClasseEnerg() != null
					&& classeEnerg.getLocTeorica().getClasseEnerg().equals(Constants.CLASSE_ENERGETICA_APIU)) {
				result.setResultCode(ISEDIFICIOPERFORMANTE_OUTCOME_CODE__OKEDIFICIOPERF);
			} else {
				cert.getAltreInfo().setFlgEdificioPerformante(false);
				theModel.setAppDatacertificato(cert);
				result.setResultCode(ISEDIFICIOPERFORMANTE_OUTCOME_CODE__KOEDIFICIOPERF);

			}
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isEdificioPerformante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDtCatastaliSecondari
	 */
	public static void resetClearStatus_widg_tblDtCatastaliSecondari(java.util.Map session) {
		session.put("cpCompilaz_tblDtCatastaliSecondari_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRaccomandazioni
	 */
	public static void resetClearStatus_widg_tblRaccomandazioni(java.util.Map session) {
		session.put("cpCompilaz_tblRaccomandazioni_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDichiarazioni
	 */
	public static void resetClearStatus_widg_tblDichiarazioni(java.util.Map session) {
		session.put("cpCompilaz_tblDichiarazioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1123586501) ENABLED START*/
	// // inserire qui le property che si vogliono iniettare in questo bean (es.
	// dao, proxy di pd, ...)
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
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

	private void gestisciComboDtCatasto(CpCompilazModel theModel) throws BEException {

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

	private void gestisciComboDtCatastoSecondari(CpCompilazModel theModel) throws BEException {

		DatiAttestato cert = theModel.getAppDatacertificato();
		/*
		 * ArrayList<Provincia> province = new ArrayList<Provincia>(); province
		 * = getSOAIntegrationMgr().getProvinceByPiemonte();
		 * theModel.setAppDataprovinceCertDTCat(province);
		 */

		String actProvSelSec = cert.getDatiAnagraficiImm().getDtCatastali().getCodProvSec();
		ArrayList<Comune> comuni = new ArrayList<Comune>();

		if (actProvSelSec != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSelSec);
		}

		theModel.setAppDatacomuniCertDtCatSecondari(comuni);
	}

	private void gestisciComboProgettista(CpCompilazModel theModel) throws BEException {
		if (theModel.getAppDataregioniCertProgettista() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr().getAllRegioni();
			theModel.setAppDataregioniCertProgettista(regioni);
		}

		DatiAttestato cert = theModel.getAppDatacertificato();
		String actRegSel = cert.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().getCodReg();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			cert.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().setCodProv(null);
		}
		theModel.setAppDataprovinceCertProgettista(province);

		String actProvSel = cert.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista().getCodProv();

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuniCertProgettista(comuni);
	}

	private void gestisciComboDirLav(CpCompilazModel theModel) throws BEException {
		if (theModel.getAppDataregioniCertDirLav() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr().getAllRegioni();
			theModel.setAppDataregioniCertDirLav(regioni);
		}

		DatiAttestato cert = theModel.getAppDatacertificato();
		String actRegSel = cert.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().getCodReg();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		ArrayList<Comune> comuni = new ArrayList<Comune>();

		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			cert.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().setCodProv(null);
		}
		theModel.setAppDataprovinceCertDirLav(province);

		String actProvSel = cert.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori().getCodProv();

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuniCertDirLav(comuni);
	}

	private void gestisciComboCostr(CpCompilazModel theModel) throws BEException {

		if (theModel.getAppDataregioniCertCostr() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr().getAllRegioni();
			theModel.setAppDataregioniCertCostr(regioni);
		}

		DatiAttestato cert = theModel.getAppDatacertificato();
		String actRegSel = cert.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore().getCodReg();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			cert.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore().setCodProv(null);
		}
		theModel.setAppDataprovinceCertCostr(province);

		String actProvSel = cert.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore().getCodProv();

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuniCertCostr(comuni);
	}

	private void gestisciComboComuni(CpCompilazModel theModel) throws BEException {
		if (theModel.getAppDataclassiEnergetiche() == null) {
			ArrayList<ClasseEnerg> cle = (ArrayList<ClasseEnerg>) getMiscMgr().getClasseEnergetica();
			theModel.setAppDataclassiEnergetiche(cle);
		}
		if (theModel.getAppDatadestinazioniUso() == null) {
			ArrayList<DestUso> duso = (ArrayList<DestUso>) getMiscMgr().getDestinazioneDuso();
			theModel.setAppDatadestinazioniUso(duso);
		}
		if (theModel.getAppDatatipiEdificio() == null) {
			ArrayList<TipoEdificio> tipoEdificio = (ArrayList<TipoEdificio>) getMiscMgr().getTipoEdificio();
			theModel.setAppDatatipiEdificio(tipoEdificio);
		}
		if (theModel.getAppDatasistemi() == null) {
			ArrayList<Sistema> sistemi = (ArrayList<Sistema>) getMiscMgr().getSistemi();
			theModel.setAppDatasistemi(sistemi);
		}
		if (theModel.getAppDatatipologieImmobili() == null) {
			ArrayList<TipoImmobile> tipImmobili = (ArrayList<TipoImmobile>) getMiscMgr().getTipologieImmobile();
			theModel.setAppDatatipologieImmobili(tipImmobili);
		}
		if (theModel.getAppDatadichiarazioni() == null) {
			ArrayList<Dichiarazione> dichiarazioni = (ArrayList<Dichiarazione>) getMiscMgr().getDichiarazioni();

			theModel.setAppDatadichiarazioni(dichiarazioni);
		}
		if (theModel.getAppDatamotiviRilascio() == null) {
			ArrayList<MotivoRilascio> motiviRilascio = (ArrayList<MotivoRilascio>) getMiscMgr().getMotiviRilascio();
			theModel.setAppDatamotiviRilascio(motiviRilascio);
		}
		if (theModel.getAppDatatipiCombustibileAcquaCalda() == null) {
			ArrayList<TipoCombustibile> tipiCombustibile = (ArrayList<TipoCombustibile>) getMiscMgr()
					.getTipiCombustibileAcquaCalda();
			theModel.setAppDatatipiCombustibileAcquaCalda(tipiCombustibile);
		}
		if (theModel.getAppDatatipiCombustibileRiscaldamento() == null) {
			ArrayList<TipoCombustibile> tipiCombustibile = (ArrayList<TipoCombustibile>) getMiscMgr()
					.getTipiCombustibileRiscaldamento();
			theModel.setAppDatatipiCombustibileRiscaldamento(tipiCombustibile);
		}
		if (theModel.getAppDatatipiDistrib() == null) {
			ArrayList<TipoDistrib> tipiDistrib = (ArrayList<TipoDistrib>) getMiscMgr().getTipiDistrib();
			theModel.setAppDatatipiDistrib(tipiDistrib);
		}
		if (theModel.getAppDatatipiImpianto() == null) {
			ArrayList<TipoImpianto> tipiImpianto = (ArrayList<TipoImpianto>) getMiscMgr().getTipiImpianto();
			theModel.setAppDatatipiImpianto(tipiImpianto);
		}
		if (theModel.getAppDatatipiRedazione() == null) {
			ArrayList<TipoRedazione> tipiRedazione = (ArrayList<TipoRedazione>) getMiscMgr().getTipiRedazione();
			theModel.setAppDatatipiRedazione(tipiRedazione);
		}
		if (theModel.getAppDatatipiRegolazione() == null) {
			ArrayList<TipoRegolaz> tipiRegolazione = (ArrayList<TipoRegolaz>) getMiscMgr().getTipiRegolazione();
			theModel.setAppDatatipiRegolazione(tipiRegolazione);
		}
		if (theModel.getAppDatatipiTermErogaz() == null) {
			ArrayList<TipoTermErogaz> tipiTermErogazione = (ArrayList<TipoTermErogaz>) getMiscMgr()
					.getTipiTermErogazione();
			theModel.setAppDatatipiTermErogaz(tipiTermErogazione);
		}
		if (theModel.getAppDataqualitaInvolucro() == null) {
			ArrayList<QualitaInvolucro> qualitaInvolucro = (ArrayList<QualitaInvolucro>) getMiscMgr()
					.getQualitaInvolucro();
			theModel.setAppDataqualitaInvolucro(qualitaInvolucro);
		}
		if (theModel.getAppDataclassiEfficienzaEnergetiche() == null) {
			ArrayList<ClasseEfficienzaEnerg> classiEfficienzaEnergetica = (ArrayList<ClasseEfficienzaEnerg>) getMiscMgr()
					.getClasseEfficienzaEnergetica();
			theModel.setAppDataclassiEfficienzaEnergetiche(classiEfficienzaEnergetica);
		}
	}

	private void gestisciComboEdificio(CpCompilazModel theModel) throws BEException {

		log.debug("[CPBECpCompilaz::gestisciComboEdificio] BEGIN");

		ArrayList<TipoEdificio> tipiEdificio = new ArrayList<TipoEdificio>();
		ArrayList<CarattEdificio> carattEdificio = new ArrayList<CarattEdificio>();

		String idTipoImpianto = theModel.getAppDatacertificato().getDatiTecnici().getTipoImpianto();

		log.debug("[CPBECpCompilaz::gestisciComboEdificio] idTipoImpianto: " + idTipoImpianto);

		if (!GenericUtil.isNullOrEmpty(idTipoImpianto)) {

			tipiEdificio = (ArrayList<TipoEdificio>) getMiscMgr().getTipiEdificio(new Integer(idTipoImpianto));
			theModel.setAppDatatipiEdificio(tipiEdificio);

			String idTipoEdificio = theModel.getAppDatacertificato().getDatiTecnici().getTipoEdificio();

			log.debug("[CPBECpCompilaz::gestisciComboEdificio] idTipoEdificio: " + idTipoEdificio);

			if (!GenericUtil.isNullOrEmpty(idTipoEdificio)) {

				carattEdificio = (ArrayList<CarattEdificio>) getMiscMgr()
						.getCaratteristicheEdificio(new Integer(idTipoEdificio));

				theModel.setAppDatacarattEdificio(carattEdificio);
			}

		} else {

			/*
			 * theModel.setAppDatatipiEdificio(new ArrayList<TipoEdificio>());
			 * theModel
			 * .getAppDatacertificato().getDatiTecnici().setTipoEdificio("");
			 */
			theModel.getAppDatacertificato().getDatiTecnici().setCarattEdificio(null);
		}

		/*
		 * theModel.setAppDatacarattEdificio(new ArrayList<CarattEdificio>());
		 * theModel
		 * .getAppDatacertificato().getDatiTecnici().setCarattEdificio("");
		 */

		theModel.setAppDatatipiEdificio(tipiEdificio);
		theModel.setAppDatacarattEdificio(carattEdificio);

		log.debug("[CPBECpCompilaz::gestisciComboEdificio] END");

	}

	private void pulisciComboEdificio(CpCompilazModel theModel) throws BEException {

		log.debug("[CPBECpCompilaz::pulisciComboEdificio] BEGIN");

		theModel.setAppDatatipiEdificio(new ArrayList<TipoEdificio>());
		theModel.setAppDatacarattEdificio(new ArrayList<CarattEdificio>());
		theModel.getAppDatacertificato().getDatiTecnici().setTipoEdificio("");
		theModel.getAppDatacertificato().getDatiTecnici().setCarattEdificio("");

		//theModel.getAppDatacertificato().getDatiTecnici().setTipoImpianto("");

		log.debug("[CPBECpCompilaz::pulisciComboEdificio] END");

	}

	private String getDescrRegione(ArrayList<Regione> regioni, String id) {
		if (regioni != null) {
			if (id != null && id.length() > 0) {
				for (Regione regione : regioni) {
					if (regione.getCod().equals(id))
						return regione.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
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

	private ArrayList<Indirizzo> caricaComboIndirizzi(String descrIndirizzo, String codReg, String codComune)
			throws BEException {
		if (Constants.COD_REGIONE_PIEMONTE.equals(codReg)) {
			// cerco solo se regione == piemonte
			return (ArrayList<Indirizzo>) getSOAIntegrationMgr().verificaIndirizzi(descrIndirizzo, codComune);
		} else
			return new ArrayList<Indirizzo>();
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	private void addFormatRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo deve essere numerico");
	}

	private void addFormatRequiredLimitedFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo con al massimo 5 cifre decimali");
	}

	private void addNumberPositiveRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo deve essere maggiore di 0");
	}

	private void addFormatRequiredLimitedTextAreaError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo deve contenere al massimo 1000 caratteri");
	}

	private boolean checkDatiFotoCarica(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getNomeFoto())
				&& GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoFileName())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto", result);
			out = false;
		} else {
			if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoFileName())) {
				if (getMiscMgr().isFileNameValid(theModel.getWidg_fileFotoCatastoFileName())) {

					String mimeType = getSOAIntegrationMgr().checkMimeTypeImmagine(theModel.getWidg_fileFotoCatasto());
					theModel.setWidg_fileFotoCatastoContentType(mimeType);
					if (GenericUtil.isNullOrEmpty(mimeType)) {
						out = false;
					}

					if (!out) {
						result.getGlobalErrors().add("Il formato del file non e' corretto");
					}
				} else {
					result.getGlobalErrors().add(
							"Il caricamento non e' andato a buon fine, e' necessario rinominare il file senza indicare caratteri speciali");
					out = false;
				}

			} else if (GenericUtil.isNullOrEmpty(cat.getNomeFoto())) {
				result.getGlobalErrors().add("E' necessario selezionare una foto");
				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoFileName())) {
			if (theModel.getWidg_fileFotoCatasto().length() > Constants.IMAGE_SIZE) {
				result.getGlobalErrors()
						.add("La dimensione della foto e' troppo elevata. La dimensione massima e' di 500Kb");
				out = false;
			}
		}

		return out;

	}

	private boolean checkDatiFotoConferma(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getNomeFoto())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto", result);
			out = false;
		} else {
			if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoFileName())
					&& !GenericUtil.isNullOrEmpty(cat.getNomeFoto())) {
				result.getGlobalErrors().add("E' necessario premere il pulsante carica per sostituire la foto");
				out = false;
			}
		}

		return out;

	}

	private boolean checkDatiAnagrafici(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

		boolean out = true;

		if (GenericUtil.isNullOrEmpty(cat.getCodProv())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codProv", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getCodComune())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codComune", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getZonaClimatica())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.zonaClimatica", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getGradiGiorno())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.gradiGiorno", result);
			out = false;
		}

		//_sv_ spostato in controlloIndirizzo()
		/*if (GenericUtil.isNullOrEmpty(cat.getDescrIndirizzo())) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo",
					result);
			out = false;
		}*/

		if (GenericUtil.isNullOrEmpty(cat.getCap())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.cap", result);
			out = false;
		} else if (!GenericUtil.isNullOrEmpty(cat.getCap())) {
			if (!BaseMgr.checkValideNumber(cat.getCap())) {
				result.getFldErrors().put("appDatacertificato.datiAnagraficiImm.dtCatastali.cap",
						"solo caratteri numerici");
				out = false;
			}
		}

		// Beppe 10/01/2012
		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getFlgCondominio())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.datiAnagraficiImm.dtCatastali.flgCondominio",
		 * result); out = false; }
		 */

		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getSezione())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.datiAnagraficiImm.dtCatastali.sezione", result);
		 * out = false; }
		 */

		if (GenericUtil.isNullOrEmpty(cat.getFoglio())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.foglio", result);
			out = false;
		}
		if (GenericUtil.isNullOrEmpty(cat.getParticella())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.particella", result);
			out = false;
		}

		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getSubalterno())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.datiAnagraficiImm.dtCatastali.subalterno",
		 * result); out = false; }
		 */
		if (GenericUtil.isNullOrEmpty(cat.getPiano())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.piano", result);
			out = false;
		}
		if (GenericUtil.isNullOrEmpty(cat.getPianiTot())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.pianiTot", result);
			out = false;
		}

		if (!GenericUtil.isNullOrEmpty(cat.getNote()) && cat.getNote().length() > 2000) {
			result.getGlobalErrors().add("La dimensione del campo Note non puo' superare i 2000 caratteri");

			out = false;
		}

		return out;
	}

	private boolean checkDatiTecniciGenerali(CpCompilazModel theModel, ExecResults result) throws BEException {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtTecniciGen cat = att.getDatiTecnici();

		boolean out = true;

		try {
			if (GenericUtil.isNullOrEmpty(cat.getDestUso())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.destUso", result);
				out = false;
			} else {

				String destUso = cat.getDestUso();

				int idDestUso = Integer.valueOf(destUso);

				if (idDestUso == Constants.ID_DEST_USO_E1_1 || idDestUso == Constants.ID_DEST_USO_E1_2) {

					if (log.isDebugEnabled()) {
						log.debug(
								"[CPBECpCompilaz::checkDatiTecniciGenerali] getTipoImpianto: " + cat.getTipoImpianto());
						log.debug(
								"[CPBECpCompilaz::checkDatiTecniciGenerali] getTipoEdificio: " + cat.getTipoEdificio());
						log.debug("[CPBECpCompilaz::checkDatiTecniciGenerali] getCarattEdificio: "
								+ cat.getCarattEdificio());
					}

					if (GenericUtil.isNullOrEmpty(cat.getTipoEdificio())) {

						addMissingRequiredFieldError("appDatacertificato.datiTecnici.tipoEdificio", result);
						out = false;
					} else if (GenericUtil.isNullOrEmpty(cat.getCarattEdificio())) {

						addMissingRequiredFieldError("appDatacertificato.datiTecnici.carattEdificio", result);
						out = false;
					}

				}

			}

			// setto la descrizione da visualizzare nella pagina Impianti
			if (!GenericUtil.isNullOrEmpty(cat.getTipoImpianto())) {
				ArrayList<TipoImpianto> ti = theModel.getAppDatatipiImpianto();
				for (TipoImpianto t : ti) {
					if (t.getCod().equals(cat.getTipoImpianto())) {
						cat.setTipoImpiantoDesc(t.getDescr());
						break;
					}
				}
			} else if (GenericUtil.isNullOrEmpty(cat.getTipoImpianto())) {

				addMissingRequiredFieldError("appDatacertificato.datiTecnici.tipoImpianto", result);
				out = false;
			}

			if (GenericUtil.isNullOrEmpty(cat.getFlagUsoPubblico())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.flagUsoPubblico", result);
				out = false;
			}

			Integer annoCostruzione = null;
			if (GenericUtil.isNullOrEmpty(cat.getAnnoCostr())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.annoCostr", result);
				out = false;
			} else {
				if (!GenericUtil.isNumero(cat.getAnnoCostr())) {
					result.getGlobalErrors().add("L'anno di costruzione deve essere nel formato AAAA");
					out = false;
				} else {
					annoCostruzione = new Integer(cat.getAnnoCostr());
					int annoMinCostruzione = getCertificatoMgr().getAnnoMinimoCostruzione();
					if ((annoCostruzione < annoMinCostruzione)
							|| (annoCostruzione > Integer.parseInt(GenericUtil.getAnnoCorrente()))) {
						result.getGlobalErrors().add("L'anno di costruzione deve essere compreso tra l'anno "
								+ annoMinCostruzione + " e l'anno corrente");
						annoCostruzione = null;
						out = false;
					}
				}

			}

			if (!GenericUtil.isNullOrEmpty(cat.getAnnoUltimaRistrutt())) {
				if (!GenericUtil.checkValideFourNumber(cat.getAnnoUltimaRistrutt())) {
					result.getGlobalErrors().add("L'anno di ultima ristrutturazione deve essere nel formato AAAA");

					out = false;
				} else if (annoCostruzione != null) {

					if (Integer.parseInt(cat.getAnnoUltimaRistrutt()) <= Integer.parseInt(cat.getAnnoCostr())) {
						result.getGlobalErrors()
								.add("L'anno di ristrutturazione deve essere maggiore dell'anno di costruzione");

						out = false;

					} else if (Integer.parseInt(cat.getAnnoUltimaRistrutt()) > Integer
							.parseInt(GenericUtil.getAnnoCorrente())) {

						result.getGlobalErrors()
								.add("L'anno di ristrutturazione non puo' essere maggiore dell'anno corrente");

						out = false;
					}
				}
			}

			if (GenericUtil.isNullOrEmpty(cat.getDescrizioneEdificio())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.descrizioneEdificio", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(cat.getVolLordoRiscald())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.volLordoRiscald", result);
				out = false;
			}

			if (GenericUtil.isNullOrEmpty(cat.getSupDispTot())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.supDispTot", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(cat.getTrasmittanzaOpache())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.trasmittanzaOpache", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(cat.getTrasmittanzaTrasp())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.trasmittanzaTrasp", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(cat.getSuperficieUtile())) {
				addMissingRequiredFieldError("appDatacertificato.datiTecnici.superficieUtile", result);
				out = false;
			}

		} catch (BEException e) {
			throw e;
		}

		return out;
	}

	private boolean checkFabbisogno(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtIndiciFabbisogno cat = att.getIndFabbisogno();

		boolean out = true;

		if (GenericUtil.isNullOrEmpty(cat.getDomEnergRiscald())) {
			addMissingRequiredFieldError("appDatacertificato.indFabbisogno.domEnergRiscald", result);
			out = false;
		}

		if (cat.getFabAcquaCaldaSanit().equalsIgnoreCase(Constants.SI)) {

			if (GenericUtil.isNullOrEmpty(cat.getDomEnergAcqua())) {
				addNumberPositiveRequiredFieldError("appDatacertificato.indFabbisogno.domEnergAcqua", result);
				out = false;
			}

			if (GenericUtil.isNullOrEmpty(cat.getEnergTermAcquaRinnov())) {
				addMissingRequiredFieldError("appDatacertificato.indFabbisogno.energTermAcquaRinnov", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(cat.getIndPrestEnergAcqua())) {
				addMissingRequiredFieldError("appDatacertificato.indFabbisogno.indPrestEnergAcqua", result);
				out = false;
			}

			if (out && cat.getDomEnergAcqua().getValue() == 0) {
				addNumberPositiveRequiredFieldError("appDatacertificato.indFabbisogno.domEnergAcqua", result);
				out = false;
			}
		}
		return out;
	}

	private boolean checkAnagCoCertificatore(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCoCertificatore co = att.getDatiAnagraficiImm().getDtCoCertificatore();

		boolean out = true;
		if (!GenericUtil.isNullOrEmpty(co.getNome()) || !GenericUtil.isNullOrEmpty(co.getCognome())
				|| !GenericUtil.isNullOrEmpty(co.getNumMatricola())) {
			if (GenericUtil.isNullOrEmpty(co.getNome())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.nome", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(co.getCognome())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.cognome", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(co.getNumMatricola())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.numMatricola",
						result);
				out = false;
			}

		}
		if (!GenericUtil.isNullOrEmpty(co.getNumMatricola())) {
			try {
				Integer.parseInt(co.getNumMatricola());
			} catch (NumberFormatException e) {
				out = false;
				addFormatRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.numMatricola",
						result);
			}
		}

		return out;
	}

	private boolean checkResponsabile(ExecResults result, SoggResponsabile co, String path, String tipo) {
		boolean out = true;
		if (!GenericUtil.isNullOrEmpty(co.getDescrIndirizzo())) {
			if (GenericUtil.isNullOrEmpty(co.getCodComune()) || GenericUtil.isNullOrEmpty(co.getCodProv())
					|| GenericUtil.isNullOrEmpty(co.getCodReg())) {
				result.getGlobalErrors().add(tipo
						+ ": Se si compila il campo indirizzo e' necessario compilare anche i campi regione, provincia, comune");
				// result.getFldErrors().put("appDatacertificatore.dtResidenza.descrIndirizzo",
				// "Se si compila il campo indirizzo e' necessario compilare anche i campi regione, provincia, comune");
				out = false;
			}

		}

		if (GenericUtil.isNullOrEmpty(co.getCognome()) || GenericUtil.isNullOrEmpty(co.getNome())) {
			if (!GenericUtil.isNullOrEmpty(co.getCap()) || !GenericUtil.isNullOrEmpty(co.getCell())
					|| !GenericUtil.isNullOrEmpty(co.getEmail()) || !GenericUtil.isNullOrEmpty(co.getFax())
					|| !GenericUtil.isNullOrEmpty(co.getTel()) || !GenericUtil.isNullOrEmpty(co.getCodComune())
					|| !GenericUtil.isNullOrEmpty(co.getCodProv()) || !GenericUtil.isNullOrEmpty(co.getCodReg())
					|| !GenericUtil.isNullOrEmpty(co.getDescrIndirizzo())
					|| !GenericUtil.isNullOrEmpty(co.getNumCiv())) {

				result.getGlobalErrors()
						.add(tipo + ": Se si compila almeno un campo e' necessario specificare nome e cognome");

				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(co.getTel())) {
			if (!BaseMgr.checkValideTelephoneNumber(co.getTel())) {
				result.getFldErrors().put(path + ".tel", "solo caratteri numerici");
				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(co.getEmail())) {
			if (!BaseMgr.checkValideEmail(co.getEmail())) {
				result.getFldErrors().put(path + ".email", "mail non formalmente valida");
				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(co.getCap())) {
			if (!BaseMgr.checkValideNumber(co.getCap())) {
				result.getFldErrors().put(path + ".cap", "solo caratteri numerici");
				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(co.getFax())) {
			if (!BaseMgr.checkValideTelephoneNumber(co.getFax())) {
				result.getFldErrors().put(path + ".fax", "solo caratteri numerici");
				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(co.getCell())) {
			if (!BaseMgr.checkValideTelephoneNumber(co.getCell())) {
				result.getFldErrors().put(path + ".cell", "solo caratteri numerici");
				out = false;
			}
		}

		if (GenericUtil.isNullOrEmpty(co.getCognome()) && !GenericUtil.isNullOrEmpty(co.getNome())) {
			result.getGlobalErrors()
					.add(tipo + ": Se si compila almeno un campo e' necessario specificare nome e cognome");

			out = false;

		} else if (!GenericUtil.isNullOrEmpty(co.getCognome()) && GenericUtil.isNullOrEmpty(co.getNome())) {
			result.getGlobalErrors()
					.add(tipo + ": Se si compila almeno un campo e' necessario specificare nome e cognome");

			out = false;

		}

		return out;
	}

	private boolean checkAnagCostr(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		SoggResponsabile co = att.getDatiAnagraficiImm().getDtResponsabili().getDtCostruttore();
		return checkResponsabile(result, co, "appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore",
				"Costruttore");

	}

	private boolean checkAnagDirLav(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		SoggResponsabile co = att.getDatiAnagraficiImm().getDtResponsabili().getDtDirLavori();
		return checkResponsabile(result, co, "appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori",
				"Direttore Lavori");
	}

	private boolean checkAnagProgettista(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		SoggResponsabile co = att.getDatiAnagraficiImm().getDtResponsabili().getDtProgettista();
		return checkResponsabile(result, co, "appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista",
				"Progettista");
	}

	private boolean checkClasseEnergeticaReale(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtLocReale cat = att.getClasseEnerg().getLocReale();

		boolean out = true;

		if (GenericUtil.isNullOrEmpty(cat.getRendGlobTermico())) {
			addMissingRequiredFieldError("appDatacertificato.classeEnerg.locReale.rendGlobTermico", result);
			out = false;
		} else {
			if (GenericUtil.convertTo(cat.getRendGlobTermico()) > 10) {
				result.getGlobalErrors()
						.add("Rendimento medio globale impianto termico (ETAg) non puo' essere maggiore di 10");
				// result.getFldErrors().put("appDatacertificatore.dtResidenza.descrIndirizzo",
				// "Se si compila il campo indirizzo e' necessario compilare anche i campi regione, provincia, comune");
				out = false;
			}
		}

		return out;
	}

	private boolean checkClasseEnergeticaTeorica(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtLocTeorica cat = att.getClasseEnerg().getLocTeorica();
		DtIndiciFabbisogno fab = att.getIndFabbisogno();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getDomEnergRiscald())) {
			addMissingRequiredFieldError("appDatacertificato.classeEnerg.locTeorica.domEnergRiscald", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getDomEnergAcqua())) {
			addMissingRequiredFieldError("appDatacertificato.classeEnerg.locTeorica.domEnergAcqua", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getIndPrestEnergRiscald())) {
			addMissingRequiredFieldError("appDatacertificato.classeEnerg.locTeorica.indPrestEnergRiscald", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getEnergTermAcquaRinnov())) {
			addMissingRequiredFieldError("appDatacertificato.classeEnerg.locTeorica.energTermAcquaRinnov", result);
			out = false;
		}

		if (fab.getDomEnergAcqua().getValue() != 0D && cat.getDomEnergAcqua().getValue() == 0D) {
			addNumberPositiveRequiredFieldError("appDatacertificato.classeEnerg.locTeorica.domEnergAcqua", result);
			out = false;
		}

		// Beppe 18/01/12
		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getRendGlobStagioneAcqua())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.classeEnerg.locTeorica.rendGlobStagioneAcqua",
		 * result); out = false; }
		 */

		if (GenericUtil.isNullOrEmpty(cat.getIndPrestEnergAcqua())) {
			addMissingRequiredFieldError("appDatacertificato.classeEnerg.locTeorica.indPrestEnergAcqua", result);
			out = false;
		}

		return out;
	}

	private boolean checkGasSerra(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtGasSerra cat = att.getGasSerra();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getEmissioniGasSerra())) {
			addMissingRequiredFieldError("appDatacertificato.gasSerra.emissioniGasSerra", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getSupBoscoEquiv())) {
			addMissingRequiredFieldError("appDatacertificato.gasSerra.supBoscoEquiv", result);
			out = false;
		}

		return out;
	}

	private boolean checkRaccomandazioni(CpCompilazModel theModel, ExecResults result) {
		theModel.getWidg_cbSistema();
		theModel.getWidg_rbsPriorita();
		theModel.getWidg_tfIntervento();
		theModel.getWidg_tfTempoRitorno();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(theModel.getWidg_cbSistema())
				|| GenericUtil.isNullOrEmpty(theModel.getWidg_rbsPriorita())
				|| GenericUtil.isNullOrEmpty(theModel.getWidg_tfIntervento())
				|| GenericUtil.isNullOrEmpty(theModel.getWidg_tfTempoRitorno())) {

			if (GenericUtil.isNullOrEmpty(theModel.getWidg_cbSistema())) {
				addMissingRequiredFieldError("widg_cbSistema", result);
			}
			if (GenericUtil.isNullOrEmpty(theModel.getWidg_rbsPriorita())) {
				addMissingRequiredFieldError("widg_rbsPriorita", result);
			}
			if (GenericUtil.isNullOrEmpty(theModel.getWidg_tfIntervento())) {
				addMissingRequiredFieldError("widg_tfIntervento", result);
			}
			if (GenericUtil.isNullOrEmpty(theModel.getWidg_tfTempoRitorno())) {
				addMissingRequiredFieldError("widg_tfTempoRitorno", result);
			}

			out = false;
		}

		return out;
	}

	private boolean checkEnergetiche(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtAIEnergetiche cat = att.getAltreInfo().getEnergetiche();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getClasseEnergEdificio())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.energetiche.classeEnergEdificio", result);
			out = false;
		}
		if (GenericUtil.isNullOrEmpty(cat.getIndPrestEnergRiscald())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.energetiche.indPrestEnergRiscald", result);
			out = false;
		}
		if (GenericUtil.isNullOrEmpty(cat.getPrestEnergRaggiungibile())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.energetiche.prestEnergRaggiungibile", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getLimNormaNazRiscald())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.energetiche.limNormaNazRiscald", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getQualitaInvolucroRaffresc())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.energetiche.qualitaInvolucroRaffresc", result);
			out = false;
		}

		if (!GenericUtil.isNullOrEmpty(cat.getAltreInfo()) && cat.getAltreInfo().length() > 2000) {
			result.getGlobalErrors()
					.add("La dimensione del campo Ulteriori informazioni non puo' superare i 2000 caratteri");

			out = false;
		}

		return out;
	}

	private boolean checkGenerali(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtAIGenerali cat = att.getAltreInfo().getGenerali();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getMotivoRilascio())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.generali.motivoRilascio", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getMetodoCalcolo())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.generali.metodoCalcolo", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getRispondenzaUNITS11300())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.generali.rispondenzaUNITS11300", result);
			out = false;
		} else if (cat.getRispondenzaUNITS11300().length() > 1000) {
			addFormatRequiredLimitedTextAreaError("appDatacertificato.altreInfo.generali.rispondenzaUNITS11300",
					result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getSoftware())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.generali.software", result);
			out = false;
		}

		return out;
	}

	private boolean checkRispettoNormative(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtRispettoNorme cat = att.getRispNorme();

		boolean out = true;

		if (!GenericUtil.isNullOrEmpty(cat.getNote()) && cat.getNote().length() > 2000) {
			result.getGlobalErrors().add("La dimensione del campo Note non puo' superare i 2000 caratteri");

			out = false;
		}

		if (!GenericUtil.isNullOrEmpty(cat.getMotivoNonConformita()) && cat.getMotivoNonConformita().length() > 2000) {
			result.getGlobalErrors().add("La dimensione del campo Se no, perche' non puo' superare i 2000 caratteri");

			out = false;
		}
		/*
		 * if (!GenericUtil.isNullOrEmpty(cat.getDataTitolo())) { if
		 * (!getMiscMgr().checkValideDate(cat.getDataTitolo())) { result
		 * .getGlobalErrors() .add(
		 * "Data in formato errato. Il formato accettato è GG/MM/AAAA"); out =
		 * false; } }
		 */

		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getDataTitolo())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.rispNorme.dataTitolo", result); out = false; }
		 * 
		 * 
		 * 
		 * if (GenericUtil.isNullOrEmpty(cat.getAutorizzato())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.rispNorme.autorizzato", result); out = false; }
		 * 
		 * if (!GenericUtil.isNullOrEmpty(cat.getAutorizzato())) { if
		 * (cat.getAutorizzato().equals("N")) { if
		 * (GenericUtil.isNullOrEmpty(cat.getMotivoNonConformita())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.rispNorme.motivoNonConformita", result); out =
		 * false; } }
		 * 
		 * }
		 */

		return out;
	}

	private boolean checkSopralluoghi(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtAISopralluoghi cat = att.getAltreInfo().getSopralluoghi();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getData())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.sopralluoghi.data", result);
			out = false;
		} /*
			 * else { if (!getMiscMgr().checkValideDate(cat.getData())) { result
			 * .getGlobalErrors() .add(
			 * "Data in formato errato. Il formato accettato è GG/MM/AAAA"); out =
			 * false; } }
			 */

		if (GenericUtil.isNullOrEmpty(cat.getTipoRedazione())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.sopralluoghi.tipoRedazione", result);
			out = false;
		}

		if (!GenericUtil.isNullOrEmpty(cat.getNote()) && cat.getNote().length() > 2000) {
			result.getGlobalErrors().add("La dimensione del campo Note non puo' superare i 2000 caratteri");

			out = false;
		}

		return out;
	}

	private boolean checkImpiantoRiscaldamento(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtImpianti impianti = att.getImpianti();
		DtImpRiscald cat = att.getImpianti().getRiscaldamento();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getFlgBollino())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.riscaldamento.flgBollino", result);
			out = false;
		} else {
			if (cat.getFlgBollino().equals(Constants.SI)) {
				if (GenericUtil.isNullOrEmpty(cat.getNumBollino())) {
					addMissingRequiredFieldError("appDatacertificato.impianti.riscaldamento.numBollino", result);
					out = false;
				}
			}

		}

		if (GenericUtil.isNullOrEmpty(cat.getCodImpianto())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.riscaldamento.codImpianto", result);
			out = false;
		}

		if (!GenericUtil.isNullOrEmpty(cat.getAnnoInstallGeneratore())
				&& !GenericUtil.checkValideFourNumber(cat.getAnnoInstallGeneratore())) {
			result.getFldErrors().put("appDatacertificato.impianti.riscaldamento.annoInstallGeneratore",
					"il campo deve essere di 4 cifre");
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getLimNormRegImpTerm())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.riscaldamento.limNormRegImpTerm", result);
			out = false;
		} else {
			Double limiteNormativoRegionaleImpiantoTermico = GenericUtil.convertTo(cat.getLimNormRegImpTerm());
			if (limiteNormativoRegionaleImpiantoTermico < Constants.LIMITE_NORMATIVO_MINIMO
					|| limiteNormativoRegionaleImpiantoTermico > Constants.LIMITE_NORMATIVO_MASSIMO) {
				result.getGlobalErrors().add(
						"Attenzione!Il campo Limite normativo regionale impianto termico deve essere compreso tra 0.77 e 0.86 secondo la DGR 46-11968 paragrafo 1.4.1.");
				out = false;
			}
		}

		//		if (GenericUtil.isNullOrEmpty(impianti.getTipoImpianto())) {
		//			addMissingRequiredFieldError(
		//					"appDatacertificato.impianti.tipoImpianto", result);
		//			out = false;
		//		}

		if (GenericUtil.isNullOrEmpty(impianti.getUiServite())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.uiServite", result);
			out = false;
		} else if (!GenericUtil.isNumero(impianti.getUiServite())) {
			result.getFldErrors().put("appDatacertificato.impianti.uiServite", "il campo deve essere un numero");
			out = false;
		} else if (!checkUIServite(theModel)) {
			result.getFldErrors().put("appDatacertificato.impianti.uiServite",
					"numero unita' immobiliari servite non coerente con il tipo impianto indicato");
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getCombustibileFossile())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.riscaldamento.combustibileFossile", result);
			out = false;
		}
		if (GenericUtil.isNullOrEmpty(cat.getPotNomCompl())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.riscaldamento.potNomCompl", result);
			out = false;
		}

		// check Limite Normativo Regionale Impianto Termico
		cat.getLimNormRegImpTerm();
		return out;
	}

	private boolean checkUIServite(CpCompilazModel theModel) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtImpianti impianti = att.getImpianti();
		DtTecniciGen dt = att.getDatiTecnici();

		boolean out = true;

		int uiServite = Integer.valueOf(impianti.getUiServite());
		//int idTipoImp = Integer.valueOf(impianti.getTipoImpianto());
		int idTipoImp = Integer.valueOf(dt.getTipoImpianto());

		if (uiServite == 0 && idTipoImp != Constants.ID_TIPO_IMP_NON_PRESENTE) {
			out = false;
		} else if (uiServite > 1 && idTipoImp != Constants.ID_TIPO_IMP_CENTRALIZZATO) {
			out = false;
		} else if (uiServite == 1 && idTipoImp != Constants.ID_TIPO_IMP_AUTONOMO) {
			out = false;
		}

		return out;
	}

	private boolean checkImpiantoLimiteNormativoRegionale(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();

		DtImpRiscald cat = att.getImpianti().getRiscaldamento();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getPotNomCompl())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.riscaldamento.potNomCompl", result);
			out = false;
		}

		return out;
	}

	private boolean checkImpiantoAcquaCalda(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtImpAcqua acqua = att.getImpianti().getAcqua();

		boolean out = true;

		if (GenericUtil.isNullOrEmpty(acqua.getCombustibileFossile())) {
			addMissingRequiredFieldError("appDatacertificato.impianti.acqua.combustibileFossile", result);
			out = false;
		}

		return out;

	}

	private boolean checkEnergiaFontiRinnovabili(CpCompilazModel theModel, ExecResults result) {
		DtEnergiaFontiRinnov fr = theModel.getAppDatacertificato().getEnergRinnov();

		boolean out = true;

		if (!GenericUtil.isNullOrEmpty(fr.getEnergTermicaProdotta()) && fr.getEnergTermicaProdotta().getValue() != 0D
				&& !GenericUtil.isNullOrEmpty(fr.getPercEnergiaFontiRinnov())
				&& fr.getPercEnergiaFontiRinnov().getValue() == 0D) {
			addNumberPositiveRequiredFieldError("appDatacertificato.energRinnov.percEnergiaFontiRinnov", result);
			out = false;
		}
		return out;
	}

	private boolean checkDichiarazioni(CpCompilazModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtDichiarazFinale cat = att.getDichiarazioni();

		boolean out = true;

		if (GenericUtil.isNullOrEmpty(theModel.getAppDatatempDichiarazSelez())) {
			result.getGlobalErrors().add("E' necessario selezionare una dichiarazione");
			out = false;
		}
		if (GenericUtil.isNullOrEmpty(cat.getDataDichiarazione())) {
			addMissingRequiredFieldError("appDatacertificato.dichiarazioni.dataDichiarazione", result);
			out = false;
		} /*
			 * else { if (!getMiscMgr().checkValideDate(cat.getDataDichiarazione()))
			 * { result .getGlobalErrors() .add(
			 * "Data in formato errato. Il formato accettato è GG/MM/AAAA"); out =
			 * false; } }
			 */
		if (GenericUtil.isNullOrEmpty(cat.getLuogoDichiarazione())) {
			addMissingRequiredFieldError("appDatacertificato.dichiarazioni.luogoDichiarazione", result);
			out = false;
		}

		return out;
	}

	private Integer aggiornaFoto(CpCompilazModel theModel) throws FileNotFoundException, IOException, BEException {

		log.debug("[CPBECpCompilaz::aggiornaFoto] BEGIN");
		DatiAttestato att = theModel.getAppDatacertificato();
		String uid = "";
		try {
			String nomeFoto = theModel.getWidg_fileFotoCatastoFileName();
			String contentType = theModel.getWidg_fileFotoCatastoContentType();

			if (log.isDebugEnabled()) {
				log.debug("Nome file: " + nomeFoto);
				log.debug("Content Type: " + contentType);
			}

			if (!GenericUtil.isNullOrEmpty(nomeFoto)) {
				java.io.File file = theModel.getWidg_fileFotoCatasto();
				byte[] bytes = getMiscMgr().readFile(file);

				ByteArrayInputStream baFoto = new ByteArrayInputStream(bytes);

				//BufferedImage ioBf = null;
				try {
					//ioBf = ImageIO.read(baFoto);
					log.debug("inizio jimi");
					JimiReader createJimiReader = Jimi.createJimiReader(baFoto);
					createJimiReader.getRasterImage();

					log.debug("fine jimi");

				} catch (Exception e) {
					// TODO: handle exception
					log.debug("Errore nella FOTO");
					return Constants.ERRORE_FOTO;
				}

				uid = getSOAIntegrationMgr().salvaImmagine(theModel.getAppDatacertificatore(), att, bytes, nomeFoto,
						contentType, file.length());

				if (uid == null) {
					log.debug("Errore nel caricamento della foto su INDEX");

					return Constants.ERRORE_INDEX;
				}

				att.getDatiAnagraficiImm().getDtCatastali().setUidFoto(uid);
				att.getDatiAnagraficiImm().getDtCatastali().setNomeFoto(nomeFoto);

				att.getDatiAnagraficiImm().getDtCatastali().setDataUpFoto(GenericUtil.getDataOdiernaCompleta());

				theModel.setAppDatacertificato(att);

			}
		} catch (BEException e) {
			throw e;
		} finally {
			log.debug("[CPBECpCompilaz::aggiornaFoto] END");
		}

		// Se ritorno null vuol dire che il caricamento è andato a buon fine
		return null;
	}

	private boolean isVisibleState(it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel) {
		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if ((theModel.getAppDatacertificato().getStatus() != null)
				&& (theModel.getAppDatacertificato().getStatus() >= Constants.CONSOLIDATO)) {
		 */
		if ((theModel.getAppDatacertificato().getStatus() != null)
				&& ((theModel.getAppDatacertificato().getStatus() == Constants.CONSOLIDATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.INVIATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.ANNULLATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.DA_INVIARE)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.SOSPESO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.CANCELLATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.ANNULLATO_BO))) {
			return true;
		}

		return false;
	}

	/*PROTECTED REGION END*/
}
