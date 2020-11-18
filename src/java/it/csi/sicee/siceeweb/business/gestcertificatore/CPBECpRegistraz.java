package it.csi.sicee.siceeweb.business.gestcertificatore;

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

/*PROTECTED REGION ID(R1092627011) ENABLED START*/
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumento;
import it.csi.sicee.siceeweb.business.facade.*;
import it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamenti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
/*PROTECTED REGION END*/

public class CPBECpRegistraz {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [comuniProvincia, scope:SAME_PAGE]
	public static final String APPDATA_COMUNIPROVINCIA_CODE = "appDatacomuniProvincia";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [provinceRegione, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCEREGIONE_CODE = "appDataprovinceRegione";

	// ApplicationData: [suggestIndirizzo, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZO_CODE = "appDatasuggestIndirizzo";

	// ApplicationData: [regioni, scope:SAME_PAGE]
	public static final String APPDATA_REGIONI_CODE = "appDataregioni";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [comuniResProvincia, scope:SAME_PAGE]
	public static final String APPDATA_COMUNIRESPROVINCIA_CODE = "appDatacomuniResProvincia";

	// ApplicationData: [comuniStudioProvincia, scope:SAME_PAGE]
	public static final String APPDATA_COMUNISTUDIOPROVINCIA_CODE = "appDatacomuniStudioProvincia";

	// ApplicationData: [provinceResRegione, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCERESREGIONE_CODE = "appDataprovinceResRegione";

	// ApplicationData: [provinceStudioRegione, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCESTUDIOREGIONE_CODE = "appDataprovinceStudioRegione";

	// ApplicationData: [regioniRes, scope:SAME_PAGE]
	public static final String APPDATA_REGIONIRES_CODE = "appDataregioniRes";

	// ApplicationData: [regioniStudio, scope:SAME_PAGE]
	public static final String APPDATA_REGIONISTUDIO_CODE = "appDataregioniStudio";

	// ApplicationData: [titoli, scope:USER_SESSION]
	public static final String APPDATA_TITOLI_CODE = "appDatatitoli";

	// ApplicationData: [provinceOrdinePiemonte, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCEORDINEPIEMONTE_CODE = "appDataprovinceOrdinePiemonte";

	// ApplicationData: [datiPagamento, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTO_CODE = "appDatadatiPagamento";

	// ApplicationData: [switchPagamento, scope:USER_SESSION]
	public static final String APPDATA_SWITCHPAGAMENTO_CODE = "appDataswitchPagamento";

	// ApplicationData: [flagDatiPers, scope:USER_SESSION]
	public static final String APPDATA_FLAGDATIPERS_CODE = "appDataflagDatiPers";

	// ApplicationData: [flagAutocert, scope:USER_SESSION]
	public static final String APPDATA_FLAGAUTOCERT_CODE = "appDataflagAutocert";

	// ApplicationData: [msgPagamento, scope:SAME_PAGE]
	public static final String APPDATA_MSGPAGAMENTO_CODE = "appDatamsgPagamento";

	// ApplicationData: [suggestIndirizzoCode, scope:USER_ACTION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODE_CODE = "appDatasuggestIndirizzoCode";

	// ApplicationData: [codiceIstruzione, scope:USER_SESSION]
	public static final String APPDATA_CODICEISTRUZIONE_CODE = "appDatacodiceIstruzione";

	// ApplicationData: [tipoIstruzione, scope:USER_SESSION]
	public static final String APPDATA_TIPOISTRUZIONE_CODE = "appDatatipoIstruzione";

	// ApplicationData: [uidDaStampare, scope:USER_SESSION]
	public static final String APPDATA_UIDDASTAMPARE_CODE = "appDatauidDaStampare";

	// ApplicationData: [isPulireTab, scope:USER_SESSION]
	public static final String APPDATA_ISPULIRETAB_CODE = "appDataisPulireTab";

	// ApplicationData: [chiaviAttPartOld, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTOLD_CODE = "appDatachiaviAttPartOld";

	// ApplicationData: [chiaviAttPartNew, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTNEW_CODE = "appDatachiaviAttPartNew";

	// ApplicationData: [idCorsoSelected, scope:USER_SESSION]
	public static final String APPDATA_IDCORSOSELECTED_CODE = "appDataidCorsoSelected";

	// ApplicationData: [chiaviTitoloStudio, scope:USER_SESSION]
	public static final String APPDATA_CHIAVITITOLOSTUDIO_CODE = "appDatachiaviTitoloStudio";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRegistraz";

	public static final String WIZARD_PWIZREGISTRAZ = "pWizRegistraz";
	public static final String STEP_PWIZREGISTRAZ_PDATIANAG = CPNAME + "_" + WIZARD_PWIZREGISTRAZ + "_" + "pDatiAnag";
	public static final String STEP_PWIZREGISTRAZ_PRESIDENZA = CPNAME + "_" + WIZARD_PWIZREGISTRAZ + "_" + "pResidenza";
	public static final String STEP_PWIZREGISTRAZ_PSTUDIO = CPNAME + "_" + WIZARD_PWIZREGISTRAZ + "_" + "pStudio";
	public static final String STEP_PWIZREGISTRAZ_PORDINE = CPNAME + "_" + WIZARD_PWIZREGISTRAZ + "_" + "pOrdine";
	public static final String STEP_PWIZREGISTRAZ_PRIEPILOGO = CPNAME + "_" + WIZARD_PWIZREGISTRAZ + "_" + "pRiepilogo";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneNascita definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setRegioneNascita(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONENASCITA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-786990788) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDatacertificatore().getDtAnag().setDescrRegNasc(getDescrRegione(theModel.getAppDataregioni(),
					theModel.getAppDatacertificatore().getDtAnag().getCodRegNasc()));

			theModel.getAppDatacertificatore().getDtAnag().setCodProvNasc(null);
			theModel.getAppDatacertificatore().getDtAnag().setDescrProvNasc(null);

			theModel.getAppDatacertificatore().getDtAnag().setCodComuneNasc(null);
			theModel.getAppDatacertificatore().getDtAnag().setDescrComuneNasc(null);

			theModel.setAppDatacomuniProvincia(new ArrayList<Comune>());
			// impostazione del result code
			result.setResultCode(SETREGIONENASCITA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneNascita] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaNascita definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setProvinciaNascita(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIANASCITA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R873426552) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtAnag()
					.setDescrProvNasc(getDescrProvincia(theModel.getAppDataprovinceRegione(),
							theModel.getAppDatacertificatore().getDtAnag().getCodProvNasc()));

			theModel.getAppDatacertificatore().getDtAnag().setCodComuneNasc(null);
			// impostazione del result code
			result.setResultCode(SETPROVINCIANASCITA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaNascita] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneNascita definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setComuneNascita(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNENASCITA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1390942478) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtAnag()
					.setDescrComuneNasc(getDescrComune(theModel.getAppDatacomuniProvincia(),
							theModel.getAppDatacertificatore().getDtAnag().getCodComuneNasc()));
			// impostazione del result code
			result.setResultCode(SETCOMUNENASCITA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneNascita] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtAnagAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults bDtAnagAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTANAGAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTANAGAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R787020043) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// setDescrizioni(theModel);
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			boolean ok = checkAnagAvanti(theModel, result);
			if (ok) {
				getCertificatoreMgr().updateCertificatore(cert);
				theModel.getAppDatacurrentUser().setNome(cert.getDtAnag().getNome());
				theModel.getAppDatacurrentUser().setCognome(cert.getDtAnag().getCognome());
				theModel.setAppDatacertificatore(cert);
				result.setResultCode(BDTANAGAVANTISALVA_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(BDTANAGAVANTISALVA_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtAnagAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setResidenzaForward definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setResidenzaForward(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETRESIDENZAFORWARD_OUTCOME_CODE__ITALIA = //NOSONAR  Reason:EIAS
				"ITALIA"; //NOSONAR  Reason:EIAS
		final String SETRESIDENZAFORWARD_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R72144516) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String flgResidenzaItalia = theModel.getAppDatacertificatore().getDtResidenza().getFlgResidenzaItalia();

			if (BaseMgr.isNullOrEmpty(flgResidenzaItalia)) {
				flgResidenzaItalia = "S";
				theModel.getAppDatacertificatore().getDtResidenza().setFlgResidenzaItalia("S");
			}

			log.debug("\n\n\n flgResidenzaItalia: " + flgResidenzaItalia);
			if (flgResidenzaItalia.equalsIgnoreCase("S")) {
				// impostazione del result code 
				result.setResultCode(SETRESIDENZAFORWARD_OUTCOME_CODE__ITALIA);
			} else {
				// impostazione del result code 
				result.setResultCode(SETRESIDENZAFORWARD_OUTCOME_CODE__ESTERO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setResidenzaForward] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo switchResidenza definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults switchResidenza(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHRESIDENZA_OUTCOME_CODE__ITALIA = //NOSONAR  Reason:EIAS
				"ITALIA"; //NOSONAR  Reason:EIAS
		final String SWITCHRESIDENZA_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R818656105) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String flgResidenzaItalia = theModel.getAppDatacertificatore().getDtResidenza().getFlgResidenzaItalia();
			log.debug("\n\n\n flgResidenzaItalia: " + flgResidenzaItalia);
			if (flgResidenzaItalia.equalsIgnoreCase("S")) {
				theModel.getAppDatacertificatore().getDtResidenza().setStatoResEstero(null);
				theModel.getAppDatacertificatore().getDtResidenza().setCittaEstera(null);
				theModel.getAppDatacertificatore().getDtResidenza().setViaEstera(null);
				theModel.getAppDatacertificatore().getDtResidenza().setCivicoEstero(null);
				theModel.getAppDatacertificatore().getDtResidenza().setCapEstero(null);
				// impostazione del result code
				result.setResultCode(SWITCHRESIDENZA_OUTCOME_CODE__ITALIA);
			} else {
				theModel.getAppDatacertificatore().getDtResidenza().setCodReg(null);
				theModel.getAppDatacertificatore().getDtResidenza().setDescrReg(null);
				theModel.getAppDatacertificatore().getDtResidenza().setCodProv(null);
				theModel.getAppDatacertificatore().getDtResidenza().setDescrProv(null);
				theModel.getAppDatacertificatore().getDtResidenza().setCodComune(null);
				theModel.getAppDatacertificatore().getDtResidenza().setDescrComune(null);
				theModel.getAppDatacertificatore().getDtResidenza().setCodIndirizzo(null);
				theModel.getAppDatacertificatore().getDtResidenza().setDescrIndirizzo(null);
				theModel.getAppDatacertificatore().getDtResidenza().setNumCiv(null);
				theModel.getAppDatacertificatore().getDtResidenza().setCap(null);
				// impostazione del result code
				result.setResultCode(SWITCHRESIDENZA_OUTCOME_CODE__ESTERO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchResidenza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneResid definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setRegioneResid(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONERESID_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1574911924) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtResidenza().setDescrReg(getDescrRegione(
					theModel.getAppDataregioni(), theModel.getAppDatacertificatore().getDtResidenza().getCodReg()));

			theModel.getAppDatacertificatore().getDtResidenza().setCodProv(null);
			theModel.getAppDatacertificatore().getDtResidenza().setDescrProv(null);

			theModel.getAppDatacertificatore().getDtResidenza().setCodComune(null);
			theModel.getAppDatacertificatore().getDtResidenza().setDescrComune(null);

			theModel.setAppDatacomuniResProvincia(new ArrayList<Comune>());
			// impostazione del result code
			result.setResultCode(SETREGIONERESID_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneResid] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaResid definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setProvinciaResid(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIARESID_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2072728560) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtResidenza()
					.setDescrProv(getDescrProvincia(theModel.getAppDataprovinceResRegione(),
							theModel.getAppDatacertificatore().getDtResidenza().getCodProv()));

			theModel.getAppDatacertificatore().getDtResidenza().setCodComune(null);

			// impostazione del result code
			result.setResultCode(SETPROVINCIARESID_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaResid] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneResid definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setComuneResid(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNERESID_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1802216170) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtResidenza()
					.setDescrComune(getDescrComune(theModel.getAppDatacomuniResProvincia(),
							theModel.getAppDatacertificatore().getDtResidenza().getCodComune()));
			// impostazione del result code
			result.setResultCode(SETCOMUNERESID_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneResid] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaIndirizzoRes definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults verificaIndirizzoRes(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZORES_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1034938561) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode(VERIFICAINDIRIZZORES_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiResidenza dres = cert.getDtResidenza();
			theModel.setAppDatasuggestIndirizzo((ArrayList<Indirizzo>) caricaComboIndirizzi(cert,
					dres.getDescrIndirizzo(), dres.getCodReg(), dres.getCodComune()));
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzoRes] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scegliIndirizzoRes definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults scegliIndirizzoRes(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCEGLIINDIRIZZORES_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R788739543) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiResidenza dres = theModel.getAppDatacertificatore().getDtResidenza();
			Integer code = theModel.getAppDatasuggestIndirizzoCode();

			Indirizzo ind = getSOAIntegrationMgr().getIndirizzoById(code);
			dres.setDescrIndirizzo(ind.getDescr());
			dres.setCodIndirizzo(ind.getCod());

			// impostazione del result code
			result.setResultCode(SCEGLIINDIRIZZORES_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scegliIndirizzoRes] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroRes definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults indietroRes(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRORES_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R474542102) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(INDIETRORES_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroRes] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtResAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults bDtResAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTRESAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTRESAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String BDTRESAVANTISALVA_OUTCOME_CODE__CONF_MAIL = //NOSONAR  Reason:EIAS
				"CONF_MAIL"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-432066852) ENABLED START*/
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			boolean ok = checkResidAvanti(theModel, result);
			if (ok) {

				DatiCertificatore certOld = getCertificatoreMgr()
						.loadCertifcatoreByIdCertificatore(cert.getIdCertificatore());

				boolean isEmailMod = !cert.getDtResidenza().getEmail()
						.equalsIgnoreCase(certOld.getDtResidenza().getEmail());
				if (isEmailMod) {
					cert.setFlgAggEmail(false);
					cert.setDataAggEmail(null);
				}

				getCertificatoreMgr().updateCertificatore(cert);
				theModel.setAppDatacertificatore(cert);

				if (!isEmailMod) {

					// E' DA FARE?????
					// controllo che la email impostata non sia da
					// scartare(ovvero se si trova nella tavola
					// SiceeWEmailNewsletter non e' valida)

					result.setResultCode(BDTRESAVANTISALVA_OUTCOME_CODE__OK);
				} else {

					// devo inviare la mail
					//					getMiscMgr().sendMailVerificaMail(cert,
					//							cert.getDtResidenza().getEmail());

					Date dataVerificaMaster = new Date();
					String dataVerifica = DateUtil.convertToStringDataCompleta(dataVerificaMaster);

					// devo inviare la mail
					getMiscMgr().sendMailVerificaMail(cert, cert.getDtResidenza().getEmail(), dataVerifica);

					getCertificatoreMgr().aggiornaCertificatoreEmail(cert.getIdCertificatore(),
							cert.getDtResidenza().getEmail(), dataVerificaMaster);

					result.setResultCode(BDTRESAVANTISALVA_OUTCOME_CODE__CONF_MAIL);
				}

			} else
				result.setResultCode(BDTRESAVANTISALVA_OUTCOME_CODE__KO);
			// } else
			// result.setResultCode(BDTRESAVANTISALVA_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtResAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setRegioneStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONESTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2014506669) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtStudio().setDescrReg(getDescrRegione(theModel.getAppDataregioni(),
					theModel.getAppDatacertificatore().getDtStudio().getCodReg()));

			theModel.getAppDatacertificatore().getDtStudio().setCodProv(null);
			theModel.getAppDatacertificatore().getDtStudio().setDescrProv(null);

			theModel.getAppDatacertificatore().getDtStudio().setCodComune(null);
			theModel.getAppDatacertificatore().getDtStudio().setDescrComune(null);

			theModel.setAppDatacomuniStudioProvincia(new ArrayList<Comune>());
			// impostazione del result code
			result.setResultCode(SETREGIONESTUDIO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setProvinciaStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIASTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R532907159) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtStudio()
					.setDescrProv(getDescrProvincia(theModel.getAppDataprovinceStudioRegione(),
							theModel.getAppDatacertificatore().getDtStudio().getCodProv()));
			theModel.getAppDatacertificatore().getDtStudio().setCodComune(null);
			// impostazione del result code
			result.setResultCode(SETPROVINCIASTUDIO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setComuneStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNESTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R736957661) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatacertificatore().getDtStudio()
					.setDescrComune(getDescrComune(theModel.getAppDatacomuniStudioProvincia(),
							theModel.getAppDatacertificatore().getDtStudio().getCodComune()));
			// impostazione del result code
			result.setResultCode(SETCOMUNESTUDIO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaIndirizzoStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults verificaIndirizzoStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZOSTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1199443773) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiStudio dstu = cert.getDtStudio();
			theModel.setAppDatasuggestIndirizzo((ArrayList<Indirizzo>) caricaComboIndirizzi(cert,
					dstu.getDescrIndirizzo(), dstu.getCodReg(), dstu.getCodComune()));
			// impostazione del result code
			result.setResultCode(VERIFICAINDIRIZZOSTUDIO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzoStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scegliIndirizzoStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults scegliIndirizzoStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCEGLIINDIRIZZOSTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R953625387) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiStudio dstu = theModel.getAppDatacertificatore().getDtStudio();
			Integer code = theModel.getAppDatasuggestIndirizzoCode();

			Indirizzo ind = getSOAIntegrationMgr().getIndirizzoById(code);
			dstu.setDescrIndirizzo(ind.getDescr());
			dstu.setCodIndirizzo(ind.getCod());

			// impostazione del result code
			result.setResultCode(SCEGLIINDIRIZZOSTUDIO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scegliIndirizzoStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults indietroStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETROSTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-568601460) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(INDIETROSTUDIO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setResidenzaBackward definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults setResidenzaBackward(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETRESIDENZABACKWARD_OUTCOME_CODE__ITALIA = //NOSONAR  Reason:EIAS
				"ITALIA"; //NOSONAR  Reason:EIAS
		final String SETRESIDENZABACKWARD_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-142447348) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String flgResidenzaItalia = theModel.getAppDatacertificatore().getDtResidenza().getFlgResidenzaItalia();
			log.debug("\n\n\n flgResidenzaItalia: " + flgResidenzaItalia);
			if (flgResidenzaItalia.equalsIgnoreCase("S")) {
				// impostazione del result code 
				result.setResultCode(SETRESIDENZABACKWARD_OUTCOME_CODE__ITALIA);
			} else {
				// impostazione del result code 
				result.setResultCode(SETRESIDENZABACKWARD_OUTCOME_CODE__ESTERO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setResidenzaBackward] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtStudioAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults bDtStudioAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTSTUDIOAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTSTUDIOAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1617163342) ENABLED START*/
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			boolean ok = checkStudioAvanti(theModel, result);
			if (ok) {
				getCertificatoreMgr().updateCertificatore(cert);
				theModel.setAppDatacertificatore(cert);

				result.setResultCode(BDTSTUDIOAVANTISALVA_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(BDTSTUDIOAVANTISALVA_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtStudioAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo changeIscrittoOrdine definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults changeIscrittoOrdine(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHANGEISCRITTOORDINE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1164425034) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//
			//			theModel.getAppDatacertificatore().getDtOrdine()
			//					.setCodiceIstruzione(null);
			//			theModel.getAppDatacertificatore().getDtOrdine()
			//					.setTitoloIstruzione(null);
			//			theModel.setAppDatacodiceIstruzione(new ArrayList<Istruzione>());

			// impostazione del result code 
			result.setResultCode(CHANGEISCRITTOORDINE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::changeIscrittoOrdine] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo changeTipoIstruzione definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults changeTipoIstruzione(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHANGETIPOISTRUZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-325654006) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			theModel.getAppDatacertificatore().getDtOrdine()
			//					.setCodiceIstruzione(null);
			//			theModel.getAppDatacertificatore().getDtOrdine()
			//					.setTitoloIstruzione(null);
			//
			//			theModel.setAppDatacodiceIstruzione(new ArrayList<Istruzione>());

			// impostazione del result code 
			result.setResultCode(CHANGETIPOISTRUZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::changeTipoIstruzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo changeCodiceIstruzione definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults changeCodiceIstruzione(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHANGECODICEISTRUZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1286352309) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			theModel.getAppDatacertificatore().getDtOrdine()
			//					.setTitoloIstruzione(null);

			// impostazione del result code 
			result.setResultCode(CHANGECODICEISTRUZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::changeCodiceIstruzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaTitoloStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults scaricaTitoloStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICATITOLOSTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-383775503) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("\n\n\n>>>>>>> uid del documento preso da idRiga: " + theModel.getIdRiga());
			String uid = theModel.getIdRiga();

			theModel.setAppDatauidDaStampare(uid);

			// impostazione del result code 
			result.setResultCode(SCARICATITOLOSTUDIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scaricaTitoloStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadTitoloStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults uploadTitoloStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADTITOLOSTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPLOADTITOLOSTUDIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R995910606) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			Attestato attestato = null;

			log.debug("theModel.getWidg_attTitoloStudioFileName(): " + theModel.getWidg_attTitoloStudioFileName());
			if (theModel.getWidg_attTitoloStudioFileName() != null) {

				SiceeTDocumento doc = getCertificatoreMgr().getSiceeTDocumentoDao()
						.findWhereIdCertificatoreAndIdTipoDocEquals(cert.getIdCertificatore(),
								BaseMgr.TITOLO_DI_STUDIO);

				Integer idDoc = null;
				if (doc != null) {
					idDoc = doc.getIdDocumento();
				} else {
					idDoc = getCertificatoreMgr().getIdDocumento();
				}

				String nomeDoc = theModel.getWidg_attTitoloStudioFileName();
				String nomeDocNew = GenericUtil.getNomeFile(BaseMgr.TITOLO_DI_STUDIO, idDoc, nomeDoc);

				// Carico il file titolo di studio
				String uid = invioDocumento(cert, nomeDocNew, theModel.getWidg_attTitoloStudioContentType(),
						theModel.getWidg_attTitoloStudio(), Constants.TIPOLOGIA_TITOLO_DI_STUDIO,
						BaseMgr.TITOLO_DI_STUDIO, null);

				attestato = new Attestato();
				attestato.setNome(nomeDocNew);
				attestato.setTipo(BaseMgr.TITOLO_DI_STUDIO);
				attestato.setUid(uid);

				getCertificatoreMgr().aggiornaTitoloDiStudioInviato(doc, idDoc, attestato.getUid(), attestato.getNome(),
						cert.getIdCertificatore());
				theModel.setAppDatachiaviTitoloStudio(getCertificatoreMgr().getDocumentiTitoloDiStudio(cert));

				result.setResultCode(UPLOADTITOLOSTUDIO_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Occorre selezionare un file");
				result.setResultCode(UPLOADTITOLOSTUDIO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::uploadTitoloStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaAttestatoPartecipazioneNew definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults scaricaAttestatoPartecipazioneNew(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICAATTESTATOPARTECIPAZIONENEW_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-223811041) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n>>>>>>> uid del documento preso da idRiga: " + theModel.getIdRiga());
			String uid = theModel.getIdRiga();

			theModel.setAppDatauidDaStampare(uid);

			// impostazione del result code 
			result.setResultCode(SCARICAATTESTATOPARTECIPAZIONENEW_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::scaricaAttestatoPartecipazioneNew] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadAttestato definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults uploadAttestato(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPLOADATTESTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R850053002) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			Attestato attestato = null;

			if (!BaseMgr.isNullOrEmpty(theModel.getAppDataidCorsoSelected())) {
				Integer idCorsoSelected = Converter.convertToInteger(theModel.getAppDataidCorsoSelected());

				ArrayList<CorsoAttestatoSummary> casList = theModel.getAppDatachiaviAttPartNew();
				String esito = null;
				for (CorsoAttestatoSummary cas : casList) {
					if (Integer.parseInt(cas.getIdCorso()) == idCorsoSelected)
						esito = cas.getEsitoEsame();
				}

				if (!esito.equalsIgnoreCase(Constants.ESITO_RESPINTO)) {
					log.debug("theModel.getWidg_attPartNewFileName(): " + theModel.getWidg_attPartNewFileName());
					if (theModel.getWidg_attPartNewFileName() != null) {

						SiceeTDocumento doc = getCertificatoreMgr().getSiceeTDocumentoDao()
								.findWhereIdCertificatoreAndFkCorsoEquals(cert.getIdCertificatore(), idCorsoSelected);

						Integer idDoc = null;
						if (doc != null) {
							idDoc = doc.getIdDocumento();
						} else {
							idDoc = getCertificatoreMgr().getIdDocumento();
						}

						String nomeDoc = theModel.getWidg_attPartNewFileName();
						String nomeDocNew = GenericUtil.getNomeFile(BaseMgr.TIPO_ATTESTATO_CORSO, idDoc, nomeDoc);

						// Carico il file attestato di partecipazione
						String uid = invioDocumento(cert, nomeDocNew, theModel.getWidg_attPartNewContentType(),
								theModel.getWidg_attPartNew(), Constants.TIPOLOGIA_ATTESTATO_CORSO,
								BaseMgr.TIPO_ATTESTATO_CORSO, idCorsoSelected);

						attestato = new Attestato();
						attestato.setNome(nomeDocNew);
						attestato.setTipo(BaseMgr.TIPO_ATTESTATO_CORSO);
						attestato.setUid(uid);

						getCertificatoreMgr().aggiornaAttestatoInviato(doc, idDoc, attestato.getUid(),
								attestato.getNome(), attestato.getTipo(), idCorsoSelected, cert.getIdCertificatore());
						theModel.setAppDatachiaviAttPartNew(getCertificatoreMgr().getDocumentiPartecipazioneNew(cert));

						result.setResultCode(UPLOADATTESTATO_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Occorre selezionare un file");
						result.setResultCode(UPLOADATTESTATO_OUTCOME_CODE__KO);
					}
				} else {
					result.getGlobalErrors().add("Non si puo' associare un attestato ad un esame con esito negativo");
					result.setResultCode(UPLOADATTESTATO_OUTCOME_CODE__KO);
				}

			} else {
				result.getGlobalErrors().add("Occorre selezionare un corso");
				result.setResultCode(UPLOADATTESTATO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::uploadAttestato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaAttestatoPartecipazioneOld definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults scaricaAttestatoPartecipazioneOld(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICAATTESTATOPARTECIPAZIONEOLD_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1402363400) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n>>>>>>> uid del documento preso da idRiga: " + theModel.getIdRiga());
			String uid = theModel.getIdRiga();

			theModel.setAppDatauidDaStampare(uid);

			// impostazione del result code 
			result.setResultCode(SCARICAATTESTATOPARTECIPAZIONEOLD_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::scaricaAttestatoPartecipazioneOld] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroOrdine definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults indietroOrdine(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETROORDINE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-935372125) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(INDIETROORDINE_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroOrdine] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtOrdineAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults bDtOrdineAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTORDINEAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTORDINEAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2145814999) ENABLED START*/
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			//String totOreEsame = getMiscMgr().getParametro(Constants.TOTALE_ORE_ESAME);
			//String dataEsame = getMiscMgr().getParametro(Constants.DATA_ESAME);

			boolean ok = checkOrdineAvanti(theModel, result);
			if (ok) {
				/*
				if (!BaseMgr.isNullOrEmpty(cert.getDtEsame().getDataEsame())) {
					cert.getDtEsame().setFlagSostenuto(Constants.SI);
				} else {
					cert.getDtEsame().setFlagSostenuto(Constants.NO);
				}
				 */
				/*
				 log.debug("theModel.getWidg_attPartRegFileName(): "
				 + theModel.getWidg_attPartRegFileName());
				 log.debug("theModel.getWidg_attPartProfittoRegFileName(): "
				 + theModel.getWidg_attPartProfittoRegFileName());
				 log.debug("theModel.getWidg_attPartProfittoNazFileName(): "
				 + theModel.getWidg_attPartProfittoNazFileName());
				 */

				//gestione spostata in uploadAttestato
				/*				
				 ArrayList<Attestato> listAttestati = new ArrayList<Attestato>();
				 Attestato att = null;
				 if (theModel.getWidg_attPartRegFileName() != null) {
				 // Carico il file Regionale - attestato di partecipazione
				 String uid = invioDocumento(cert,
				 theModel.getWidg_attPartRegFileName(),
				 theModel.getWidg_attPartRegContentType(),
				 theModel.getWidg_attPartReg(),
				 Constants.TIPOLOGIA_ALLEGATO_PARTECIPAZ_REGIONALE,
				 BaseMgr.TIPO_PARTECIPAZ_REGIONALE);
				 att = new Attestato();
				 att.setNome(theModel.getWidg_attPartRegFileName());
				 att.setTipo(BaseMgr.TIPO_PARTECIPAZ_REGIONALE);
				 att.setUid(uid);
				 listAttestati.add(att);
				 }
				 */
				/*
				 if (theModel.getWidg_attPartProfittoRegFileName() != null) {
				 // Carico il file Regionale - attestato di partecipazione con profitto
				 String uid = invioDocumento(cert,
				 theModel.getWidg_attPartProfittoRegFileName(),
				 theModel.getWidg_attPartProfittoRegContentType(),
				 theModel.getWidg_attPartProfittoReg(),
				 Constants.TIPOLOGIA_ALLEGATO_PROFITTO_REGIONALE,
				 BaseMgr.TIPO_PROFITTO_REGIONALE);
				 att = new Attestato();
				 att.setNome(theModel.getWidg_attPartProfittoRegFileName());
				 att.setTipo(BaseMgr.TIPO_PROFITTO_REGIONALE);
				 att.setUid(uid);
				 listAttestati.add(att);
				 }
				 */
				/*
				 if (theModel.getWidg_attPartProfittoNazFileName() != null) {
				 // Carico il file Regionale - attestato di partecipazione con profitto
				 String uid = invioDocumento(cert,
				 theModel.getWidg_attPartProfittoNazFileName(),
				 theModel.getWidg_attPartProfittoNazContentType(),
				 theModel.getWidg_attPartProfittoNaz(),
				 Constants.TIPOLOGIA_ALLEGATO_PROFITTO_NAZIONALE,
				 BaseMgr.TIPO_PROFITTO_NAZIONALE);
				 att = new Attestato();
				 att.setNome(theModel.getWidg_attPartProfittoNazFileName());
				 att.setTipo(BaseMgr.TIPO_PROFITTO_NAZIONALE);
				 att.setUid(uid);
				 listAttestati.add(att);
				 }
				 */
				getCertificatoreMgr().updateCertificatore(cert);

				recuperaDescrizioniIstruzione(theModel);

				theModel.setAppDatacertificatore(cert);
				/*
				 theModel.setAppDatachiaviAttPartReg(getCertificatoreMgr()
				 .getDocumento(cert, BaseMgr.TIPO_PARTECIPAZ_REGIONALE));
				
				 theModel.setAppDatachiaviAttPartProfittoReg(getCertificatoreMgr()
				 .getDocumento(cert, BaseMgr.TIPO_PROFITTO_REGIONALE));
				
				 theModel.setAppDatachiaviAttPartProfittoNaz(getCertificatoreMgr()
				 .getDocumento(cert, BaseMgr.TIPO_PROFITTO_NAZIONALE));
				 */
				theModel.setAppDatachiaviTitoloStudio(getCertificatoreMgr().getDocumentiTitoloDiStudio(cert));

				theModel.setAppDatachiaviAttPartOld(getCertificatoreMgr().getDocumentiPartecipazioneOld(cert));

				theModel.setAppDatachiaviAttPartNew(getCertificatoreMgr().getDocumentiPartecipazioneNew(cert));

				result.setResultCode(BDTORDINEAVANTISALVA_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(BDTORDINEAVANTISALVA_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtOrdineAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoOK definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults recepisciPagamentoOK(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOOK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1825956545) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode(RECEPISCIPAGAMENTOOK_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoOK] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroRiepilogo definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults indietroRiepilogo(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRORIEPILOGO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-77920572) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(INDIETRORIEPILOGO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroRiepilogo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtRiepilogoAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults bDtRiepilogoAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__PAGAMENTO = //NOSONAR  Reason:EIAS
				"PAGAMENTO"; //NOSONAR  Reason:EIAS
		final String BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__NON_PAGAMENTO = //NOSONAR  Reason:EIAS
				"NON_PAGAMENTO"; //NOSONAR  Reason:EIAS
		final String BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__STAY = //NOSONAR  Reason:EIAS
				"STAY"; //NOSONAR  Reason:EIAS
		final String BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__COMPLETA_REGISTRAZIONE = //NOSONAR  Reason:EIAS
				"COMPLETA_REGISTRAZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R871612014) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			boolean ris = checkRiepilogoAvanti(theModel, result);

			if (ris) {
				if (!GenericUtil.isNullOrEmpty(cert.getIdBlocco())) {
					result.getGlobalErrors().add(Messages.ERROR_INVIARE_MAIL_ASSISTENZA);

					result.setResultCode(BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__STAY);
				} else if (CertificatoreMgr.isNotRegistratoOrNearScadenza(cert)) {

					//if (!cert.getRegistrato()) { // caso in cui non e'registrato
					if (CertificatoreMgr.isFlagPagamento(cert)) {
						// non e' registrato e deve pagare => vai al
						// pagamento
						result.setResultCode(BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__PAGAMENTO);

						// BEPPE
						// QUESTA PARTE E' DA RIVEDERE CON IL NUOVO MDP 

					} else {
						// non deve pagare => completa la registrazione
						// e vado alla pagina di dialogo (col msg di
						// completamento registraz e il pulsante di ritorno
						// alla home)
						// completa la registrazione
						if (GenericUtil.isNullOrEmpty(cert.getNumCertificatore())) {
							cert.setNumCertificatore(getCertificatoreMgr().calcolaNumeroMatricola(cert));
						}

						if (cert.getStato() != Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA) {
							Date dataIscrizione = new Date();
							cert.setDataIscrizioneRegistrazione(DateUtil.convertToString(dataIscrizione));
						} else {
							cert.setDataIscrizioneRegistrazione(
									DateUtil.addOneDay(cert.getDataScadenzaRegistrazione()));
						}

						if (CertificatoreMgr.isFlagPagamento(cert)) {
							cert.setDataScadenzaRegistrazione(
									DateUtil.addOneYear(cert.getDataIscrizioneRegistrazione()));
						} else {
							cert.setDataScadenzaRegistrazione(Constants.DATA_SCADENZA_REGISTRAZIONE_ILLIMITATA);
						}

						cert.setStato(Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO);

						getCertificatoreMgr().updateCertificatore(cert);

						cert.setFlgAggDati(true);

						getCertificatoreMgr().aggiornaCertificatoreFlgDati(cert.getIdCertificatore());

						theModel.setAppDatacertificatore(cert);

						if (cert.getFlgCompetenzeNaz()) {
							theModel.setAppDatamsgPagamento(
									Constants.MSG_OK_REGISTRAZ_NAZ + "\"" + cert.getNumCertificatore() + "\"");
						} else {
							theModel.setAppDatamsgPagamento(
									Constants.MSG_OK_REGISTRAZ_REG + "\"" + cert.getNumCertificatore() + "\"");
						}

						// vado alla dialog
						result.setResultCode(BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__COMPLETA_REGISTRAZIONE);
					}

				} else {

					cert.setFlgAggDati(true);

					getCertificatoreMgr().aggiornaCertificatoreFlgDati(cert.getIdCertificatore());

					theModel.setAppDatacertificatore(cert);

					result.setResultCode(BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__NON_PAGAMENTO);
				}
			} else {
				result.setResultCode(BDTRIEPILOGOAVANTISALVA_OUTCOME_CODE__STAY);
			}

			log.debug("@@@@@@@STAMPO ResultCode: " + result.getResultCode());

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtRiepilogoAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaDatiPagamentoIscrizione definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults preparaDatiPagamentoIscrizione(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADATIPAGAMENTOISCRIZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R390578048) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataswitchPagamento(Constants.PAGAMENTO_REGISTRAZIONE);

			/*
			DatiPagamento dpaga = new DatiPagamento();
			
			dpaga.setImporto(getMiscMgr().getPrezzoRegistrazione());
			// dpaga.setModPagamento("CC");
			// la causale и fissa
			dpaga.setCausale("Onere annuale iscrizione");
			dpaga.setDataValuta(DateUtil
					.convertToUDTDateValid(new java.util.Date()));
			dpaga.setEseguitoDaCognome(theModel.getAppDatacurrentUser()
					.getCognome());
			dpaga.setEseguitoDaNome(theModel.getAppDatacurrentUser().getNome());
			dpaga.setTipo("REGISTRAZIONE");
			dpaga.setQuantita(1);
			theModel.setAppDatadatiPagamento(dpaga);
			// impostazione del result code
			 */

			result.setResultCode(PREPARADATIPAGAMENTOISCRIZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaDatiPagamentoIscrizione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-890842618) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// carico le regioni se non sono gia' caricate
			gestisciComboAnag(theModel);
			gestisciComboResid(theModel);
			gestisciComboStudio(theModel);

			gestisciComboOrdine(theModel);
			//			loadComboTitoli(theModel);

			// / indirizzi
			ArrayList<Indirizzo> indirizzi = new ArrayList<Indirizzo>();
			theModel.setAppDatasuggestIndirizzo(indirizzi);

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
	 * Implementazione del metodo switchStatoWidget definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults switchStatoWidget(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHSTATOWIDGET_OUTCOME_CODE__REGISTRAZIONE = //NOSONAR  Reason:EIAS
				"REGISTRAZIONE"; //NOSONAR  Reason:EIAS
		final String SWITCHSTATOWIDGET_OUTCOME_CODE__VISUALIZZAZIONE = //NOSONAR  Reason:EIAS
				"VISUALIZZAZIONE"; //NOSONAR  Reason:EIAS
		final String SWITCHSTATOWIDGET_OUTCOME_CODE__RIREGISTRAZIONE = //NOSONAR  Reason:EIAS
				"RIREGISTRAZIONE"; //NOSONAR  Reason:EIAS
		final String SWITCHSTATOWIDGET_OUTCOME_CODE__NUOVAREGISTRAZIONE = //NOSONAR  Reason:EIAS
				"NUOVAREGISTRAZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R633298165) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			log.debug("\n\n\n>>>>>>> CPBECpRegistraz::switchStatoWidget --> cert.getStato(); " + cert.getStato());

			if (!GenericUtil.isNullOrEmpty(cert.getIdBlocco())) {
				result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__NUOVAREGISTRAZIONE);
			} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO) {
				String flgMdp = cert.getDtOrdine().getTitolo().getFlgMdp();
				if (!GenericUtil.isNullOrEmpty(flgMdp) && BaseMgr.convertToBoolean(flgMdp)) {
					result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__VISUALIZZAZIONE);
				} else {
					result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__REGISTRAZIONE);
				}
			} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA) {
				result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__RIREGISTRAZIONE);
			} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO) {
				result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__NUOVAREGISTRAZIONE);
			} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO) {
				result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__NUOVAREGISTRAZIONE);
			}
			//			else if (cert.getStato() == Constants.STATO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO) {
			//				result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__NUOVAREGISTRAZIONE);
			//			}

			//			if (cert.getRegistrato()) {
			//				theModel.setAppDataflagAutocert(true);
			//				theModel.setAppDataflagDatiPers(true);
			//				if (!cert.getNearScadenza()) {
			//					if (cert.getDtOrdine().getTitolo().getFlgMdp() != null
			//							&& cert.getDtOrdine().getTitolo().getFlgMdp()
			//									.equalsIgnoreCase("S"))
			//						result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__VISUALIZZAZIONE);
			//					else
			//						result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__REGISTRAZIONE);
			//				} else {
			//					result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__RIREGISTRAZIONE);
			//				}
			//
			//			} else {
			/*if (BaseMgr
					.isNullOrEmpty(cert.getDataIscrizioneRegistrazione())) {
				result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__NUOVAREGISTRAZIONE);
			} else {
				result.setResultCode(SWITCHSTATOWIDGET_OUTCOME_CODE__RIREGISTRAZIONE);
			}*/
			//			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchStatoWidget] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciTabAttPartOld definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults gestisciTabAttPartOld(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCITABATTPARTOLD_OUTCOME_CODE__MOSTRA_ATT_OLD = //NOSONAR  Reason:EIAS
				"MOSTRA_ATT_OLD"; //NOSONAR  Reason:EIAS
		final String GESTISCITABATTPARTOLD_OUTCOME_CODE__NASCONDI_ATT_OLD = //NOSONAR  Reason:EIAS
				"NASCONDI_ATT_OLD"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R262829287) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			//getCertificatoreMgr().getDocumentiPartecipazione(cert) -->
			//getSiceeTDocumentoDao().findAttPartOld(idCertificatore) -->
			//SELECT * FROM SICEE_T_DOCUMENTO WHERE ID_CERTIFICATORE = ? 
			//AND FK_CORSO IS NULL 
			//AND (ID_TIPO_DOC = 2 OR ID_TIPO_DOC = 3 OR ID_TIPO_DOC = 4)
			ArrayList<DocumentSummary> attestati = getCertificatoreMgr().getDocumentiPartecipazioneOld(cert);

			if (attestati != null && attestati.size() > 0) {

				theModel.setAppDatachiaviAttPartOld(attestati);

				// impostazione del result code 
				result.setResultCode(GESTISCITABATTPARTOLD_OUTCOME_CODE__MOSTRA_ATT_OLD);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCITABATTPARTOLD_OUTCOME_CODE__NASCONDI_ATT_OLD);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciTabAttPartOld] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciTabAttPartNew definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults gestisciTabAttPartNew(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCITABATTPARTNEW_OUTCOME_CODE__MOSTRA_ATT_NEW = //NOSONAR  Reason:EIAS
				"MOSTRA_ATT_NEW"; //NOSONAR  Reason:EIAS
		final String GESTISCITABATTPARTNEW_OUTCOME_CODE__NASCONDI_ATT_NEW = //NOSONAR  Reason:EIAS
				"NASCONDI_ATT_NEW"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1441381646) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			ArrayList<CorsoAttestatoSummary> corsiAttestati = getCertificatoreMgr().getDocumentiPartecipazioneNew(cert);

			if (corsiAttestati != null && corsiAttestati.size() > 0) {

				theModel.setAppDatachiaviAttPartNew(corsiAttestati);

				// impostazione del result code 
				result.setResultCode(GESTISCITABATTPARTNEW_OUTCOME_CODE__MOSTRA_ATT_NEW);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCITABATTPARTNEW_OUTCOME_CODE__NASCONDI_ATT_NEW);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciTabAttPartNew] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciTabTitoloStudio definito in un ExecCommand del
	 * ContentPanel cpRegistraz
	 */
	public ExecResults gestisciTabTitoloStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCITABTITOLOSTUDIO_OUTCOME_CODE__MOSTRA_TITOLOSTUDIO = //NOSONAR  Reason:EIAS
				"MOSTRA_TITOLOSTUDIO"; //NOSONAR  Reason:EIAS
		final String GESTISCITABTITOLOSTUDIO_OUTCOME_CODE__NASCONDI_TITOLOSTUDIO = //NOSONAR  Reason:EIAS
				"NASCONDI_TITOLOSTUDIO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R348159377) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			//getCertificatoreMgr().getDocumentiTitoloDiStudio(cert) -->
			//getSiceeTDocumentoDao().findTitoloDiStudio(idCertificatore) -->
			//SELECT * FROM SICEE_T_DOCUMENTO WHERE ID_CERTIFICATORE = ? 
			//AND FK_CORSO IS NULL 
			//AND ID_TIPO_DOC = 6
			ArrayList<DocumentSummary> attestati = getCertificatoreMgr().getDocumentiTitoloDiStudio(cert);

			if (attestati != null && attestati.size() > 0) {

				theModel.setAppDatachiaviTitoloStudio(attestati);

				// impostazione del result code 
				result.setResultCode(GESTISCITABTITOLOSTUDIO_OUTCOME_CODE__MOSTRA_TITOLOSTUDIO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCITABTITOLOSTUDIO_OUTCOME_CODE__NASCONDI_TITOLOSTUDIO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciTabTitoloStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblTitoloStudioSummary
	 */
	public static void resetClearStatus_widg_tblTitoloStudioSummary(java.util.Map session) {
		session.put("cpRegistraz_tblTitoloStudioSummary_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttPartNewSummary
	 */
	public static void resetClearStatus_widg_tblAttPartNewSummary(java.util.Map session) {
		session.put("cpRegistraz_tblAttPartNewSummary_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttPartOldSummary
	 */
	public static void resetClearStatus_widg_tblAttPartOldSummary(java.util.Map session) {
		session.put("cpRegistraz_tblAttPartOldSummary_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1497902475) ENABLED START*/
	// // inserire qui le property che si vogliono iniettare in questo bean (es.
	// dao, proxy di pd, ...)
	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

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

	// //////////////////////////
	// // METODI DI UTILITA'
	// //////////////////////////

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "e' obbligatorio");
	}

	private boolean checkAnagAvanti(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel,
			ExecResults result) {
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		DatiAnag da = cert.getDtAnag();
		boolean out = true;
		if (BaseMgr.isNullOrEmpty(da.getCodFisc())) {
			addMissingRequiredFieldError("appDatacertificatore.dtAnag.codFisc", result);
			out = false;
		}
		if (BaseMgr.isNullOrEmpty(da.getCognome())) {
			// addMissingRequiredFieldError("tfCognome", result);
			addMissingRequiredFieldError("appDatacertificatore.dtAnag.cognome", result);
			out = false;
		}
		if (BaseMgr.isNullOrEmpty(da.getNome())) {
			addMissingRequiredFieldError("appDatacertificatore.dtAnag.nome", result);
			out = false;
		}

		if (BaseMgr.isNullOrEmpty(da.getDataNascita())) {
			addMissingRequiredFieldError("appDatacertificatore.dtAnag.dataNascita", result);
			out = false;
		} else {
			String[] dataNascita = da.getDataNascita().getValue().split("/");
			Calendar calDN = Calendar.getInstance();
			calDN.set(Integer.parseInt(dataNascita[2]), Integer.parseInt(dataNascita[1]) - 1,
					Integer.parseInt(dataNascita[0]));
			Calendar today = Calendar.getInstance(Locale.ITALY);
			if (calDN.getTimeInMillis() >= today.getTimeInMillis()) {
				result.getGlobalErrors().add("Indicare una data di nascita valida");
				out = false;
			}
		}
		/*if (!BaseMgr.isNullOrEmpty(da.getDataNascita())) {
			if (!MiscMgr.checkValideDate(da.getDataNascita())) {
				result.getGlobalErrors()
						.add("Data in formato errato. Il formato accettato и GG/MM/AAAA");
				out = false;
			}
		}*/

		if (!BaseMgr.isNullOrEmpty(da.getStatoEstero()) && !BaseMgr.isNullOrEmpty(da.getDescrRegNasc())) {
			result.getGlobalErrors().add("Indicare solo un luogo di nascita");
			out = false;
		} else if (BaseMgr.isNullOrEmpty(da.getStatoEstero()) && BaseMgr.isNullOrEmpty(da.getDescrRegNasc())) {
			result.getGlobalErrors().add("E' necessario indicare il luogo di nascita");
			out = false;
		} else if (!BaseMgr.isNullOrEmpty(da.getDescrRegNasc())) {
			if (BaseMgr.isNullOrEmpty(da.getCodRegNasc())) {
				addMissingRequiredFieldError("appDatacertificatore.dtAnag.codRegNasc", result);
				out = false;
			}
			if (BaseMgr.isNullOrEmpty(da.getCodProvNasc())) {
				addMissingRequiredFieldError("appDatacertificatore.dtAnag.codProvNasc", result);
				out = false;
			}
			if (BaseMgr.isNullOrEmpty(da.getCodComuneNasc())) {
				addMissingRequiredFieldError("appDatacertificatore.dtAnag.codComuneNasc", result);
				out = false;
			}
		}
		return out;
	}

	private boolean checkResidAvanti(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel,
			ExecResults result) {
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		DatiResidenza dr = cert.getDtResidenza();
		boolean out = true;
		if (BaseMgr.isNullOrEmpty(dr.getTel())) {
			addMissingRequiredFieldError("appDatacertificatore.dtResidenza.tel", result);
			out = false;
		} else if (!BaseMgr.isNullOrEmpty(dr.getTel())) {
			if (!BaseMgr.checkValideTelephoneNumber(dr.getTel())) {
				result.getFldErrors().put("appDatacertificatore.dtResidenza.tel", "solo caratteri numerici");
				out = false;
			}
		}
		if (BaseMgr.isNullOrEmpty(dr.getEmail())) {
			addMissingRequiredFieldError("appDatacertificatore.dtResidenza.email", result);
			out = false;
		} else if (!BaseMgr.isNullOrEmpty(dr.getEmail())) {
			if (!BaseMgr.checkValideEmail(dr.getEmail())) {
				result.getFldErrors().put("appDatacertificatore.dtResidenza.email", "mail non formalmente valida");
				out = false;
			}
		}

		if (!BaseMgr.isNullOrEmpty(dr.getEmailPec())) {
			if (!BaseMgr.checkValideEmail(dr.getEmailPec())) {
				result.getFldErrors().put("appDatacertificatore.dtResidenza.emailPec", "mail non formalmente valida");
				out = false;
			}
		}

		if (!BaseMgr.isNullOrEmpty(dr.getFax())) {
			if (!BaseMgr.checkValideTelephoneNumber(dr.getFax())) {
				result.getFldErrors().put("appDatacertificatore.dtResidenza.fax", "solo caratteri numerici");
				out = false;
			}
		}

		if (log.isDebugEnabled()) {
			log.debug("##########################");
			log.debug(dr.getFlgAutorCell());
			log.debug("prova: " + (dr.getFlgAutorCell().equals(Constants.TRUE)));
			log.debug("##########################");
		}

		if (!BaseMgr.isNullOrEmpty(dr.getCell())) {
			if (!BaseMgr.checkValideTelephoneNumber(dr.getCell())) {
				result.getFldErrors().put("appDatacertificatore.dtResidenza.cell", "solo caratteri numerici");
				out = false;
			}
		} else if (!BaseMgr.isNullOrEmpty(dr.getFlgAutorCell()) && dr.getFlgAutorCell().equals(Constants.TRUE)) {

			// Se l'utente ha selezionato che il cell и "Visibile in elenco certificatori", allora deve obbligatoriamente inserire il cellulare	
			addMissingRequiredFieldError("appDatacertificatore.dtResidenza.cell", result);

			out = false;

		}

		// se il certificatore ha residenza in Italia ...
		if (dr.getFlgResidenzaItalia().equalsIgnoreCase("S")) {

			if (BaseMgr.isNullOrEmpty(dr.getCodReg())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.codReg", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(dr.getCodProv())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.codProv", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(dr.getCodComune())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.codComune", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(dr.getDescrIndirizzo())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.descrIndirizzo", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(dr.getCap())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.cap", result);
				out = false;
			} else if (!BaseMgr.isNullOrEmpty(dr.getCap())) {
				if (!BaseMgr.checkValideNumber(dr.getCap())) {
					result.getFldErrors().put("appDatacertificatore.dtResidenza.cap", "solo caratteri numerici");
					out = false;
				}
			}
			// se invece il certificatore ha residenza all'estero ...
		} else {

			if (BaseMgr.isNullOrEmpty(dr.getStatoResEstero())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.statoResEstero", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(dr.getCittaEstera())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.cittaEstera", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(dr.getViaEstera())) {
				addMissingRequiredFieldError("appDatacertificatore.dtResidenza.viaEstera", result);
				out = false;
			}

		}

		return out;
	}

	private boolean checkStudioAvanti(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel,
			ExecResults result) {
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		DatiStudio ds = cert.getDtStudio();
		boolean out = true;

		// se id comune и vuoto cancello descrizione
		if (BaseMgr.isNullOrEmpty(ds.getCodComune())) {
			ds.setDescrComune(null);
		}

		// Se sono stati annullati tutti i campi annullo anche l'eventuale codice indirizzo
		if (BaseMgr.isNullOrEmpty(ds.getCap()) && BaseMgr.isNullOrEmpty(ds.getCodComune())
				&& BaseMgr.isNullOrEmpty(ds.getCodProv()) && BaseMgr.isNullOrEmpty(ds.getCodReg())
				&& BaseMgr.isNullOrEmpty(ds.getDescrComune()) && BaseMgr.isNullOrEmpty(ds.getDescrProv())
				&& BaseMgr.isNullOrEmpty(ds.getDescrReg()) && BaseMgr.isNullOrEmpty(ds.getDescrIndirizzo())
				&& BaseMgr.isNullOrEmpty(ds.getNumCiv()) && BaseMgr.isNullOrEmpty(ds.getRagSociale())
				&& BaseMgr.isNullOrEmpty(ds.getPartitaIVA())) {

			ds.setCodIndirizzo(null);
		}

		// Se viene compilato un campo allora sono tutti obbligatori (tranne il num civico)
		if (!BaseMgr.isNullOrEmpty(ds.getCap()) || !BaseMgr.isNullOrEmpty(ds.getCodComune())
				|| !BaseMgr.isNullOrEmpty(ds.getCodIndirizzo()) || !BaseMgr.isNullOrEmpty(ds.getCodProv())
				|| !BaseMgr.isNullOrEmpty(ds.getCodReg()) || !BaseMgr.isNullOrEmpty(ds.getDescrComune())
				|| !BaseMgr.isNullOrEmpty(ds.getDescrProv()) || !BaseMgr.isNullOrEmpty(ds.getDescrReg())
				|| !BaseMgr.isNullOrEmpty(ds.getDescrIndirizzo()) || !BaseMgr.isNullOrEmpty(ds.getNumCiv())
				|| !BaseMgr.isNullOrEmpty(ds.getRagSociale()) || !BaseMgr.isNullOrEmpty(ds.getPartitaIVA())) {

			if (BaseMgr.isNullOrEmpty(ds.getPartitaIVA())) {
				addMissingRequiredFieldError("appDatacertificatore.dtStudio.partitaIVA", result);
				out = false;
			} else if (ds.getPartitaIVA().length() != 11 || !BaseMgr.checkValideNumber(ds.getPartitaIVA())) {
				result.getFldErrors().put("appDatacertificatore.dtStudio.partitaIVA",
						"deve essere costituito da 11 caratteri numerici");
				//addMissingRequiredFieldError("appDatacertificatore.dtStudio.partitaIVA", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(ds.getRagSociale())) {
				addMissingRequiredFieldError("appDatacertificatore.dtStudio.ragSociale", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(ds.getCodReg())) {
				addMissingRequiredFieldError("appDatacertificatore.dtStudio.codReg", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(ds.getCodProv())) {
				addMissingRequiredFieldError("appDatacertificatore.dtStudio.codProv", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(ds.getCodComune())) {
				addMissingRequiredFieldError("appDatacertificatore.dtStudio.codComune", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(ds.getDescrIndirizzo())) {
				addMissingRequiredFieldError("appDatacertificatore.dtStudio.descrIndirizzo", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(ds.getCap())) {
				addMissingRequiredFieldError("appDatacertificatore.dtStudio.cap", result);
				out = false;
			} else if (!BaseMgr.checkValideNumber(ds.getCap())) {
				result.getFldErrors().put("appDatacertificatore.dtStudio.cap", "solo caratteri numerici");
				out = false;
			}

			//			if (!BaseMgr.isNullOrEmpty(ds.getCap())) {
			//				if (!BaseMgr.checkValideNumber(ds.getCap())) {
			//					result.getFldErrors().put(
			//							"appDatacertificatore.dtStudio.cap",
			//							"solo caratteri numerici");
			//					out = false;
			//				}
			//			}

			/*
			if (!BaseMgr.isNullOrEmpty(ds.getDescrIndirizzo())) {
				if (BaseMgr.isNullOrEmpty(ds.getCodComune())
						|| BaseMgr.isNullOrEmpty(ds.getCodProv())
						|| BaseMgr.isNullOrEmpty(ds.getCodReg())) {
					result.getGlobalErrors()
							.add("Se si compila il campo indirizzo e' necessario compilare anche i campi regione, provincia, comune");
					// result.getFldErrors().put("appDatacertificatore.dtStudio.descrIndirizzo",
					// "Se si compila il campo indirizzo e' necessario compilare anche i campi regione, provincia, comune");
					out = false;
				}
			
			}
			 */
		}

		return out;
	}

	private boolean checkOrdineAvanti(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel,
			ExecResults result) throws ParseException {
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		DatiOrdine dord = cert.getDtOrdine();
		ArrayList<DocumentSummary> titoloStudio = theModel.getAppDatachiaviTitoloStudio();
		boolean out = true;

		if (dord.getFlagIscritto() == null) {
			addMissingRequiredFieldError("appDatacertificatore.dtOrdine.flagIscritto", result);
			return false;
		}

		if (dord.getTipoIstruzione() == null || BaseMgr.isNullOrEmpty(dord.getTipoIstruzione())) {
			addMissingRequiredFieldError("appDatacertificatore.dtOrdine.tipoIstruzione", result);
			return false;
		}

		if (dord.getCodiceIstruzione() == null || BaseMgr.isNullOrEmpty(dord.getCodiceIstruzione())) {
			addMissingRequiredFieldError("appDatacertificatore.dtOrdine.codiceIstruzione", result);
			return false;

		}
		/*
		 boolean isObblEsameReg = true;
		 boolean isObblEsameNaz = true;
		
		 DatiEsame dtEsameReg = cert.getDtEsameReg();
		 DatiEsame dtEsameNaz = cert.getDtEsameNaz();
		 */
		boolean isIscritto = !BaseMgr.isNullOrEmpty(dord.getFlagIscritto())
				&& BaseMgr.convertToBoolean(dord.getFlagIscritto());

		if (isIscritto) {

			if (BaseMgr.isNullOrEmpty(dord.getAlbo())) {
				addMissingRequiredFieldError("appDatacertificatore.dtOrdine.albo", result);
				out = false;
			}
			if (BaseMgr.isNullOrEmpty(dord.getDescrProv())) {
				addMissingRequiredFieldError("appDatacertificatore.dtOrdine.descrProv", result);
				out = false;
			}
			if (BaseMgr.isNullOrEmpty(dord.getNumIscrizione())) {
				addMissingRequiredFieldError("appDatacertificatore.dtOrdine.numIscrizione", result);
				out = false;
			}
			if (BaseMgr.isNullOrEmpty(dord.getDataIscrizione())) {
				addMissingRequiredFieldError("appDatacertificatore.dtOrdine.dataIscrizione", result);
				out = false;
			}

			if (dord.getPresaVisione() == null || !dord.getPresaVisione().booleanValue()) {
				addMissingRequiredFieldError("appDatacertificatore.dtOrdine.presaVisione", result);
				out = false;
			}

			if (BaseMgr.isNullOrEmpty(titoloStudio)) {
				result.getGlobalErrors().add("Occorre inserire il titolo di studio");
				out = false;
			}

			/*
			 isObblEsameReg = false;
			 isObblEsameNaz = false;
			 */
		}

		//-------------> sezione Competenze
		//		if (GenericUtil.isNullOrEmpty(cert.getDtCompetenze().getEdifici())) {
		//			addMissingRequiredFieldError(
		//					"appDatacertificatore.dtCompetenze.edifici", result);
		//			out = false;
		//		}
		//		if (GenericUtil.isNullOrEmpty(cert.getDtCompetenze().getImpianti())) {
		//			addMissingRequiredFieldError(
		//					"appDatacertificatore.dtCompetenze.impianti", result);
		//			out = false;
		//		}

		/*
		 boolean isCompilatoEsameReg = false;
		 boolean isCompilatoEsameNaz = false;
		
		 String fileNameAttPartReg = theModel.getWidg_attPartRegFileName();
		 String fileNameAttPartRegProfitto = theModel
		 .getWidg_attPartProfittoRegFileName();
		 String fileNameAttPartNazProfitto = theModel
		 .getWidg_attPartProfittoNazFileName();
		
		 if (!BaseMgr.isNullOrEmpty(dtEsameReg.getCorso())
		 || dtEsameReg.getTotaleOre() != null
		 || !BaseMgr.isNullOrEmpty(dtEsameReg
		 .getAttestazionePartecipazione())
		 || !BaseMgr.isNullOrEmpty(dtEsameReg.getAttestazioneEsame())
		 || !BaseMgr.isNullOrEmpty(dtEsameReg.getDataEsame())
		 || !BaseMgr.isNullOrEmpty(dtEsameReg.getDataPartecipazione())
		 || fileNameAttPartRegProfitto != null) {
		 isCompilatoEsameReg = true;
		 }
		 if (!BaseMgr.isNullOrEmpty(dtEsameNaz.getCorso())
		 || dtEsameNaz.getTotaleOre() != null
		 || !BaseMgr.isNullOrEmpty(dtEsameNaz
		 .getAttestazionePartecipazione())
		 || !BaseMgr.isNullOrEmpty(dtEsameNaz.getAttestazioneEsame())
		 || !BaseMgr.isNullOrEmpty(dtEsameNaz.getDataEsame())
		 || !BaseMgr.isNullOrEmpty(dtEsameNaz.getDataPartecipazione())
		 || fileNameAttPartNazProfitto != null) {
		 isCompilatoEsameNaz = true;
		 }
		
		 if (dtEsameReg != null) {
		
		 try {
		 if (isObblEsameReg && isCompilatoEsameReg) {
		
		 if (BaseMgr.isNullOrEmpty(dtEsameReg.getCorso())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameReg.corso", result);
		 out = false;
		 }
		
		 if (dtEsameReg.getTotaleOre() == null) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameReg.totaleOre",
		 result);
		 out = false;
		 }
		
		 if (BaseMgr.isNullOrEmpty(dtEsameReg
		 .getAttestazionePartecipazione())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameReg.attestazionePartecipazione",
		 result);
		 out = false;
		 }
		
		 if (BaseMgr
		 .isNullOrEmpty(dtEsameReg.getAttestazioneEsame())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameReg.attestazioneEsame",
		 result);
		 out = false;
		 }
		
		 if (BaseMgr.isNullOrEmpty(dtEsameReg.getDataEsame())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameReg.dataEsame",
		 result);
		 out = false;
		 }
		
		 if (BaseMgr.isNullOrEmpty(dtEsameReg
		 .getDataPartecipazione())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameReg.dataPartecipazione",
		 result);
		 out = false;
		 }
		
		 log.debug("Nome file attestato partecipazione con profitto regionale: -"
		 + fileNameAttPartRegProfitto + "-");
		
		 if (!(theModel.getAppDatachiaviAttPartProfittoReg() != null && fileNameAttPartRegProfitto == null)) {
		
		 if (!checkAttestato(
		 fileNameAttPartRegProfitto,
		 "Attestato di partecipazione con profitto regionale",
		 result)) {
		 out = false;
		 }
		 }
		
		 }
		
		 log.debug("Nome file attestato partecipazione regionale: -"
		 + fileNameAttPartReg + "-");
		 if (fileNameAttPartReg != null
		 && !checkAttestato(fileNameAttPartReg,
		 "Attestato di partecipazione regionale", result)) {
		 out = false;
		 }
		
		 if (!BaseMgr.isNullOrEmpty(dtEsameReg.getModulo1DataDal())
		 && !BaseMgr
		 .isNullOrEmpty(dtEsameReg.getModulo1DataAl())) {
		
		 Date dal = DateUtil.convertToDate(dtEsameReg
		 .getModulo1DataDal());
		 Date al = DateUtil.convertToDate(dtEsameReg
		 .getModulo1DataAl());
		
		 if (dal.after(al)) {
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameReg.modulo1DataDal",
		 "La 'data al' deve essere successiva o uguale alla 'data dal' ");
		 out = false;
		
		 }
		 } else if (!BaseMgr.isNullOrEmpty(dtEsameReg
		 .getModulo1DataDal())
		 || !BaseMgr
		 .isNullOrEmpty(dtEsameReg.getModulo1DataAl())) {
		 result.getGlobalErrors()
		 .add("E' necessario indicare entrambe le date per il modulo 1");
		 out = false;
		 }
		
		 // DATE MODULO 2
		
		 if (!BaseMgr.isNullOrEmpty(dtEsameReg.getModulo2DataDal())
		 && !BaseMgr
		 .isNullOrEmpty(dtEsameReg.getModulo2DataAl())) {
		
		 Date dal = DateUtil.convertToDate(dtEsameReg
		 .getModulo2DataDal());
		 Date al = DateUtil.convertToDate(dtEsameReg
		 .getModulo2DataAl());
		
		 if (dal.after(al)) {
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameReg.modulo2DataDal",
		 "La 'data al' deve essere successiva o uguale alla 'data dal' ");
		 out = false;
		
		 }
		 } else if (!BaseMgr.isNullOrEmpty(dtEsameReg
		 .getModulo2DataDal())
		 || !BaseMgr
		 .isNullOrEmpty(dtEsameReg.getModulo2DataAl())) {
		 result.getGlobalErrors()
		 .add("E' necessario indicare entrambe le date per il modulo 2");
		 out = false;
		 }
		
		 if ((BaseMgr.isNullOrEmpty(dtEsameReg.getDataPartecipazione()) && !BaseMgr
		 .isNullOrEmpty(dtEsameReg
		 .getAttestazionePartecipazione()))
		 || (!BaseMgr.isNullOrEmpty(dtEsameReg
		 .getDataPartecipazione()) && BaseMgr
		 .isNullOrEmpty(dtEsameReg
		 .getAttestazionePartecipazione()))
		
		 ) {
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameReg.attestazionePartecipazione",
		 "E' necessario indicare entrambi i campi relativi alla partecipazione");
		
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameReg.dataPartecipazione",
		 "E' necessario indicare entrambi i campi relativi alla partecipazione");
		 out = false;
		 }
		
		 if ((BaseMgr.isNullOrEmpty(dtEsameReg.getDataEsame()) && !BaseMgr
		 .isNullOrEmpty(dtEsameReg.getAttestazioneEsame()))
		 || (!BaseMgr.isNullOrEmpty(dtEsameReg.getDataEsame()) && BaseMgr
		 .isNullOrEmpty(dtEsameReg
		 .getAttestazioneEsame()))
		
		 ) {
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameReg.attestazioneEsame",
		 "E' necessario indicare entrambi i campi relativi alla verifica finale");
		
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameReg.dataEsame",
		 "E' necessario indicare entrambi i campi relativi alla verifica finale");
		 out = false;
		 }
		
		
		 } catch (Exception e) {
		 log.error(e);
		 }
		 }
		
		 if (dtEsameNaz != null) {
		 try {
		
		 if (isObblEsameNaz && isCompilatoEsameNaz) {
		
		 if (BaseMgr.isNullOrEmpty(dtEsameNaz.getCorso())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameNaz.corso", result);
		 out = false;
		 }
		
		 if (dtEsameNaz.getTotaleOre() == null) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameNaz.totaleOre",
		 result);
		 out = false;
		 } else if (BaseMgr.convertToInteger(dtEsameNaz
		 .getTotaleOre()) < BaseMgr
		 .convertToInteger(totOreEsame)) {
		 result.getFldErrors().put(
		 "appDatacertificatore.dtEsameNaz.totaleOre",
		 "Il totale ore non puo' essere minore di "
		 + totOreEsame);
		 }
		
		 if (BaseMgr.isNullOrEmpty(dtEsameNaz
		 .getAttestazionePartecipazione())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameNaz.attestazionePartecipazione",
		 result);
		 out = false;
		 }
		
		 if (BaseMgr
		 .isNullOrEmpty(dtEsameNaz.getAttestazioneEsame())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameNaz.attestazioneEsame",
		 result);
		 out = false;
		 }
		
		 if (BaseMgr.isNullOrEmpty(dtEsameNaz.getDataEsame())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameNaz.dataEsame",
		 result);
		 out = false;
		 }
		
		 if (BaseMgr.isNullOrEmpty(dtEsameNaz
		 .getDataPartecipazione())) {
		 addMissingRequiredFieldError(
		 "appDatacertificatore.dtEsameNaz.dataPartecipazione",
		 result);
		 out = false;
		 }
		
		 log.debug("Nome file attestato partecipazione con profitto nazionale: -"
		 + fileNameAttPartNazProfitto + "-");
		
		 if (!(theModel.getAppDatachiaviAttPartProfittoNaz() != null && fileNameAttPartNazProfitto == null)) {
		 if (!checkAttestato(
		 fileNameAttPartNazProfitto,
		 "Attestato di partecipazione con profitto nazionale",
		 result)) {
		 out = false;
		 }
		 }
		 }
		
		 if (!BaseMgr.isNullOrEmpty(dtEsameNaz.getModulo1DataDal())
		 && !BaseMgr
		 .isNullOrEmpty(dtEsameNaz.getModulo1DataAl())) {
		
		 Date dal = DateUtil.convertToDate(dtEsameNaz
		 .getModulo1DataDal());
		 Date al = DateUtil.convertToDate(dtEsameNaz
		 .getModulo1DataAl());
		
		 if (dal.after(al)) {
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameNaz.modulo1DataDal",
		 "La 'data al' deve essere successiva o uguale alla 'data dal' ");
		 out = false;
		
		 }
		 } else if (!BaseMgr.isNullOrEmpty(dtEsameNaz
		 .getModulo1DataDal())
		 || !BaseMgr
		 .isNullOrEmpty(dtEsameNaz.getModulo1DataAl())) {
		 result.getGlobalErrors()
		 .add("E' necessario indicare entrambe le date per il corso nazionale");
		 out = false;
		 }
		
		 if ((BaseMgr.isNullOrEmpty(dtEsameNaz.getDataPartecipazione()) && !BaseMgr
		 .isNullOrEmpty(dtEsameNaz
		 .getAttestazionePartecipazione()))
		 || (!BaseMgr.isNullOrEmpty(dtEsameNaz
		 .getDataPartecipazione()) && BaseMgr
		 .isNullOrEmpty(dtEsameNaz
		 .getAttestazionePartecipazione()))
		
		 ) {
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameNaz.attestazionePartecipazione",
		 "E' necessario indicare entrambi i campi relativi alla partecipazione");
		
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameNaz.dataPartecipazione",
		 "E' necessario indicare entrambi i campi relativi alla partecipazione");
		 out = false;
		 }
		
		 if ((BaseMgr.isNullOrEmpty(dtEsameNaz.getDataEsame()) && !BaseMgr
		 .isNullOrEmpty(dtEsameNaz.getAttestazioneEsame()))
		 || (!BaseMgr.isNullOrEmpty(dtEsameNaz.getDataEsame()) && BaseMgr
		 .isNullOrEmpty(dtEsameNaz
		 .getAttestazioneEsame()))
		
		 ) {
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameNaz.attestazioneEsame",
		 "E' necessario indicare entrambi i campi relativi alla verifica finale");
		
		 result.getFldErrors()
		 .put("appDatacertificatore.dtEsameNaz.dataEsame",
		 "E' necessario indicare entrambi i campi relativi alla verifica finale");
		 out = false;
		 }
		
		 } catch (Exception e) {
		 log.error(e);
		 }
		
		 }
		
		 if (!isIscritto) {
		 if (!isCompilatoEsameReg && !isCompilatoEsameNaz) {
		 result.getGlobalErrors()
		 .add("E' necessario compilare i dati del corso/esame regionale e/o nazionale");
		 out = false;
		 } else if (isCompilatoEsameReg) {
		
		 try {
		 log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@тт");
		 log.debug("DateUtil.convertToDate(dataEsame): "
		 + DateUtil.convertToDate(dataEsame));
		 log.debug("DateUtil.convertToDate(dtEsameReg.getDataPartecipazione()): "
		 + DateUtil.convertToDate(dtEsameReg
		 .getDataPartecipazione()));
		
		 log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@тт");
		
		 if (!DateUtil.checkDateOrder(DateUtil
		 .convertToDate(dataEsame), DateUtil
		 .convertToDate(dtEsameReg.getDataPartecipazione()),
		 true)
		 && !isCompilatoEsameNaz) {
		 result.getGlobalErrors()
		 .add("E' necessario compilare i dati del corso/esame nazionale");
		 out = false;
		 }
		 } catch (BEException e) {
		 result.getGlobalErrors()
		 .add("E' necessario compilare i dati del corso/esame nazionale");
		 out = false;
		 }
		 }
		
		 }
		 */
		return out;
	}

	private boolean checkAttestato(String fileNameAttestato, String tipoAttestato, ExecResults result) {
		boolean out = true;

		if (fileNameAttestato != null) {
			if (getMiscMgr().isFileNameValid(fileNameAttestato)) {
				if (!fileNameAttestato.endsWith(".doc") && !fileNameAttestato.endsWith(".odt")
						&& !fileNameAttestato.endsWith(".pdf")) {
					result.getGlobalErrors().add(tipoAttestato + " - Il formato del file non e' corretto");
					out = false;
				}
			} else {
				result.getGlobalErrors().add(tipoAttestato
						+ " - Il caricamento non e' andato a buon fine, e' necessario rinominare il file senza indicare caratteri speciali");
				out = false;
			}
		} else {
			result.getGlobalErrors().add(tipoAttestato + " - E' necessario selezionare un documento");
			out = false;
		}

		return out;
	}

	private boolean checkRiepilogoAvanti(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel,
			ExecResults result) {
		boolean out = true;
		if (theModel.getAppDataflagAutocert() == null || !theModel.getAppDataflagAutocert().booleanValue()) {
			addMissingRequiredFieldError("appDataflagAutocert", result);
			out = false;
		}
		if (theModel.getAppDataflagDatiPers() == null || !theModel.getAppDataflagDatiPers().booleanValue()) {
			addMissingRequiredFieldError("appDataflagDatiPers", result);
			out = false;
		}
		return out;
	}

	// /**
	// * imposta i campi di descrizione
	// */
	// public void setDescrizioni(CpRegistrazModel theModel){
	//		
	// int currStep = getCurrentStep(theModel.getSession());
	// DatiCertificatore cert = theModel.getAppDatacertificatore();
	// switch(currStep){
	// case STEP_ANAG:
	// if (cert.getDtAnag().getCodComuneNasc()!=null &&
	// cert.getDtAnag().getCodComuneNasc().length()>0){
	// getSOAIntegrationMgr().findComuneById(cert.getDtAnag().getCodComuneNasc());
	// }
	// break;
	// case STEP_ORDINE:
	// break;
	// case STEP_RESID:
	// break;
	// case STEP_STUDIO:
	// break;
	// default:
	// break;
	// }
	// }
	private void gestisciComboAnag(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel)
			throws BEException {
		if (theModel.getAppDataregioni() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr().getAllRegioni();
			theModel.setAppDataregioni(regioni);
		}

		if (theModel.getAppDataprovinceOrdinePiemonte() == null) {
			ArrayList<Provincia> provPiemonte = (ArrayList<Provincia>) getSOAIntegrationMgr()
					.getProvinceByRegione(Constants.COD_REGIONE_PIEMONTE);
			theModel.setAppDataprovinceOrdinePiemonte(provPiemonte);
		}

		DatiCertificatore cert = theModel.getAppDatacertificatore();
		String actRegSel = cert.getDtAnag().getCodRegNasc();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			province = new ArrayList<Provincia>();
		}
		theModel.setAppDataprovinceRegione(province);

		String actProvSel = cert.getDtAnag().getCodProvNasc();
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		} else {
			comuni = new ArrayList<Comune>();
		}
		theModel.setAppDatacomuniProvincia(comuni);
	}

	private void gestisciComboResid(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel)
			throws BEException {
		if (theModel.getAppDataregioniRes() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr().getAllRegioni();
			theModel.setAppDataregioniRes(regioni);
		}

		DatiCertificatore cert = theModel.getAppDatacertificatore();
		String actRegSel = cert.getDtResidenza().getCodReg();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			province = new ArrayList<Provincia>();
		}
		theModel.setAppDataprovinceResRegione(province);

		String actProvSel = cert.getDtResidenza().getCodProv();
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		} else {
			comuni = new ArrayList<Comune>();
		}
		theModel.setAppDatacomuniResProvincia(comuni);
	}

	private void gestisciComboStudio(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel)
			throws BEException {

		if (theModel.getAppDataregioniStudio() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr().getAllRegioni();
			theModel.setAppDataregioniStudio(regioni);
		}

		DatiCertificatore cert = theModel.getAppDatacertificatore();
		String actRegSel = cert.getDtStudio().getCodReg();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			province = new ArrayList<Provincia>();
		}

		theModel.setAppDataprovinceStudioRegione(province);

		String actProvSel = cert.getDtStudio().getCodProv();
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		} else {
			comuni = new ArrayList<Comune>();
		}
		theModel.setAppDatacomuniStudioProvincia(comuni);
	}

	private void gestisciComboOrdine(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel)
			throws BEException {

		ArrayList<Istruzione> tipoIstruzione = theModel.getAppDatatipoIstruzione();

		// Se и giа presente in sessione non lo ricarico
		if (tipoIstruzione == null) {
			tipoIstruzione = getCertificatoreMgr().getAllTipoIstruzione();

			theModel.setAppDatatipoIstruzione(tipoIstruzione);
		}

		Boolean isIscrittoOrdine = BaseMgr
				.convertToBoolean(theModel.getAppDatacertificatore().getDtOrdine().getFlagIscritto());

		boolean isTipoIstruzioneSelez = theModel.getAppDatacertificatore().getDtOrdine().getTipoIstruzione() != null;

		ArrayList<Istruzione> listIstruzione = new ArrayList<Istruzione>();

		if (log.isDebugEnabled()) {
			log.debug("##############");
			log.debug("Stamp iscritto ordine: " + theModel.getAppDatacertificatore().getDtOrdine().getFlagIscritto());

			log.debug("isIscrittoOrdine: " + isIscrittoOrdine);

			log.debug("Stampo il tipo di istruzione: "
					+ theModel.getAppDatacertificatore().getDtOrdine().getTipoIstruzione());
		}

		if (isIscrittoOrdine != null && isTipoIstruzioneSelez) {
			log.debug("ENTRO COMBO ISTRUZIONE");
			listIstruzione = getCertificatoreMgr().getIstruzioneByIdTipoIstruzione(
					BaseMgr.convertToInteger(theModel.getAppDatacertificatore().getDtOrdine().getTipoIstruzione()),
					isIscrittoOrdine);

			String idIstrSelez = theModel.getAppDatacertificatore().getDtOrdine().getCodiceIstruzione();

			String titoloIstruzione = null;
			if (idIstrSelez != null) {
				log.debug("idIstrSelez: " + idIstrSelez);
				for (Istruzione istruzione : listIstruzione) {

					log.debug("istruzione.getId(): " + istruzione.getId());

					if (istruzione.getId().equals(idIstrSelez)) {

						log.debug("SETTO IL TIPO ISTRUZIONE: " + istruzione.getDescr());

						titoloIstruzione = istruzione.getDescr();

						break;
					}
				}
			}

			theModel.getAppDatacertificatore().getDtOrdine().setTitoloIstruzione(titoloIstruzione);

		} else {
			log.debug("VUOTA COMBO ISTRUZIONE");

			listIstruzione = new ArrayList<Istruzione>();

			theModel.getAppDatacertificatore().getDtOrdine().setCodiceIstruzione(null);

			theModel.getAppDatacertificatore().getDtOrdine().setTitoloIstruzione(null);

		}

		theModel.setAppDatacodiceIstruzione(listIstruzione);

		/*
		if (theModel.getAppDataregioniStudio() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr()
					.getAllRegioni();
			theModel.setAppDataregioniStudio(regioni);
		}
		
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		String actRegSel = cert.getDtStudio().getCodReg();
		
		ArrayList<Provincia> province = new ArrayList<Provincia>();
		if (actRegSel != null) {
		province = (ArrayList<Provincia>) getSOAIntegrationMgr()
				.getProvinceByRegione(actRegSel);
		} else {
		province = new ArrayList<Provincia>();
		}
		
		theModel.setAppDataprovinceStudioRegione(province);
		
		String actProvSel = cert.getDtStudio().getCodProv();
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		if (actProvSel != null) {
		comuni = (ArrayList<Comune>) getSOAIntegrationMgr()
				.getComuniByProvincia(actProvSel);
		} else {
		comuni = new ArrayList<Comune>();
		}
		theModel.setAppDatacomuniStudioProvincia(comuni);
		 */
	}

	private void recuperaDescrizioniIstruzione(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel)
			throws BEException {

		DatiCertificatore cert = theModel.getAppDatacertificatore();
		String descTipoIstruzione = getCertificatoreMgr()
				.getDescTipoIstruzioneById(BaseMgr.convertToInteger(cert.getDtOrdine().getTipoIstruzione()));
		String descIstruzione = getCertificatoreMgr()
				.getDescIstruzioneById(BaseMgr.convertToInteger(cert.getDtOrdine().getCodiceIstruzione()));

		cert.getDtOrdine().setDescTipoIstruzione(descTipoIstruzione);
		cert.getDtOrdine().setDescCodTitoloIstruzione(descIstruzione);

	}

	private void loadComboTitoli(it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel)
			throws BEException {
		theModel.setAppDatatitoli(getCertificatoreMgr().getAllTitoli());
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

	private List<Indirizzo> caricaComboIndirizzi(DatiCertificatore cert, String descrIndirizzo, String codReg,
			String codComune) throws BEException {
		if (Constants.COD_REGIONE_PIEMONTE.equals(codReg)) {
			// cerco solo se regione == piemonte
			return getSOAIntegrationMgr().verificaIndirizzi(descrIndirizzo, codComune);
		} else
			return new ArrayList<Indirizzo>();
	}

	private DatiCertificatore recuperaCertificatore(
			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel) throws BEException {
		DatiCertificatore cert = null;
		try {
			cert = getCertificatoreMgr().loadCertifcatoreByCF(theModel.getAppDatacurrentUser().getCodFisc());

			theModel.setAppDatacertificatore(cert);

		} catch (BEException e) {
			throw e;
		}

		return cert;

	}

	private String invioDocumento(DatiCertificatore cert, String nomeAttestato, String contentType, java.io.File file,
			String tipoDocumentoIndex, Integer tipoDocumentoDB, Integer fkCorso)
			throws FileNotFoundException, IOException, BEException {

		log.debug("[CpRegistrazModel::invioDocumento] BEGIN");
		//DatiCertificatore cert = theModel.getAppDatacertificatore();
		String uid = null;
		try {

			//String nomeAttestato = theModel.getWidg_fileAttestatoFileName();
			//String contentType = theModel.getWidg_fileAttestatoContentType();

			if (log.isDebugEnabled()) {
				log.debug("Nome file: " + nomeAttestato);
				log.debug("Content Type: " + contentType);
			}

			if (!GenericUtil.isNullOrEmpty(nomeAttestato)) {
				//java.io.File file = theModel.getWidg_fileAttestato();
				InputStream is = new FileInputStream(file);

				long length = file.length();
				if (length > Integer.MAX_VALUE) {
					log.error("File is too large");
				}

				byte[] bytes = new byte[(int) length];

				is.read(bytes);

				is.close();

				if (!GenericUtil.isNullOrEmpty(fkCorso)) {
					uid = getSOAIntegrationMgr().salvaDocumentoNew(cert, bytes, nomeAttestato, contentType, length,
							tipoDocumentoIndex, tipoDocumentoDB, fkCorso);
				} else {
					uid = getSOAIntegrationMgr().salvaDocumento(cert, bytes, nomeAttestato, contentType, length,
							tipoDocumentoIndex, tipoDocumentoDB);
				}
			}
		} catch (BEException e) {
			log.error("Errore", e);
		} finally {
			log.debug("[CpRegistrazModel::invioDocumento] END");
		}

		return uid;
	}
	/*PROTECTED REGION END*/
}
