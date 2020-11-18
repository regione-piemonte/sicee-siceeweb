package it.csi.sicee.siceeweb.business.main;

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

/*PROTECTED REGION ID(R-239488594) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.exceptions.UserException;

import it.csi.sicee.siceeweb.business.facade.BaseMgr;

/*PROTECTED REGION END*/

public class CPBECpVisuraCIT {

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

	// ApplicationData: [visuraCodImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_VISURACODIMPIANTOSELEZ_CODE = "appDatavisuraCodImpiantoSelez";

	// ApplicationData: [visuraImpianto, scope:USER_SESSION]
	public static final String APPDATA_VISURAIMPIANTO_CODE = "appDatavisuraImpianto";

	// ApplicationData: [visuraImpiantoList, scope:USER_SESSION]
	public static final String APPDATA_VISURAIMPIANTOLIST_CODE = "appDatavisuraImpiantoList";

	// ApplicationData: [visuraRappControlloList, scope:USER_SESSION]
	public static final String APPDATA_VISURARAPPCONTROLLOLIST_CODE = "appDatavisuraRappControlloList";

	// ApplicationData: [visuraRicerca, scope:USER_SESSION]
	public static final String APPDATA_VISURARICERCA_CODE = "appDatavisuraRicerca";

	// ApplicationData: [visuraRifCatastaleList, scope:USER_SESSION]
	public static final String APPDATA_VISURARIFCATASTALELIST_CODE = "appDatavisuraRifCatastaleList";

	// ApplicationData: [visuraUidLibrettoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_VISURAUIDLIBRETTODASTAMPARE_CODE = "appDatavisuraUidLibrettoDaStampare";

	// ApplicationData: [idRigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDRIGASELEZIONATA_CODE = "appDataidRigaSelezionata";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpVisuraCIT";

	public static final String MULTIPANEL_MPELENCOIMP = "mpElencoImp";
	public static final String MPI_MPELENCOIMP_FPELENCOIMP = CPNAME + "_" + MULTIPANEL_MPELENCOIMP + "_"
			+ "fpElencoImp";

	public static final String MULTIPANEL_MPDETTIMPIANTO = "mpDettImpianto";
	public static final String MPI_MPDETTIMPIANTO_FPDETTIMPIANTO = CPNAME + "_" + MULTIPANEL_MPDETTIMPIANTO + "_"
			+ "fpDettImpianto";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaCodiceImpianto definito in un ExecCommand del
	 * ContentPanel cpVisuraCIT
	 */
	public ExecResults verificaCodiceImpianto(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICACODICEIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICACODICEIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1129957042) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (GenericUtil.isNullOrEmpty(theModel.getAppDatavisuraRicerca().getCodImpianto())) {

				addMissingRequiredFieldError("appDatavisuraRicerca.codImpianto", result);

				// impostazione del result code 
				result.setResultCode(VERIFICACODICEIMPIANTO_OUTCOME_CODE__KO);
			} else {

				if (log.isDebugEnabled()) {
					log.debug("STAMPO IL COD IMPIANTO: " + theModel.getAppDatavisuraRicerca().getCodImpianto());

					log.debug("STAMPO IL COD IMPIANTO convert: "
							+ BaseMgr.convertToInteger(theModel.getAppDatavisuraRicerca().getCodImpianto()));
				}

				try {
					ArrayList<VisuraImpianto> visImpianto = getSOAIntegrationMgr().visuraByCodImpianto(
							BaseMgr.convertToInteger(theModel.getAppDatavisuraRicerca().getCodImpianto()));

					if (visImpianto != null && visImpianto.size() > 0) {
						theModel.setAppDatavisuraImpiantoList(visImpianto);

						// impostazione del result code 
						result.setResultCode(VERIFICACODICEIMPIANTO_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Nessun impianto trovato con il parametro di ricerca inserito");

						result.setResultCode(VERIFICACODICEIMPIANTO_OUTCOME_CODE__KO);

					}
				} catch (BEException e) {
					result.getGlobalErrors().add(e.getMessage());
					result.setResultCode(VERIFICACODICEIMPIANTO_OUTCOME_CODE__KO);
				} catch (Exception e) {
					result.getGlobalErrors().add(Messages.ERROR_RECUPERO_SERVIZIO);
					result.setResultCode(VERIFICACODICEIMPIANTO_OUTCOME_CODE__KO);
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaCodiceImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaPOD definito in un ExecCommand del
	 * ContentPanel cpVisuraCIT
	 */
	public ExecResults verificaPOD(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAPOD_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAPOD_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1486747091) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (GenericUtil.isNullOrEmpty(theModel.getAppDatavisuraRicerca().getPod())) {
				addMissingRequiredFieldError("appDatavisuraRicerca.pod", result);

				// impostazione del result code 
				result.setResultCode(VERIFICAPOD_OUTCOME_CODE__KO);
			} else {

				log.debug("STAMPO IL POD: " + theModel.getAppDatavisuraRicerca().getPod());

				try {
					ArrayList<VisuraImpianto> visImpianto = getSOAIntegrationMgr()
							.visuraByPOD(theModel.getAppDatavisuraRicerca().getPod());

					if (visImpianto != null && visImpianto.size() > 0) {
						theModel.setAppDatavisuraImpiantoList(visImpianto);

						// impostazione del result code 
						result.setResultCode(VERIFICAPOD_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Nessun impianto trovato con il parametro di ricerca inserito");

						result.setResultCode(VERIFICAPOD_OUTCOME_CODE__KO);

					}
				} catch (UserException ue) {
					result.getGlobalErrors().add("Troppi impianti trovati con il parametro di ricerca inserito");

					result.setResultCode(VERIFICAPOD_OUTCOME_CODE__KO);
				} catch (BEException e) {
					result.getGlobalErrors().add(e.getMessage());
					result.setResultCode(VERIFICAPOD_OUTCOME_CODE__KO);
				} catch (Exception e) {
					result.getGlobalErrors().add(Messages.ERROR_RECUPERO_SERVIZIO);
					result.setResultCode(VERIFICAPOD_OUTCOME_CODE__KO);
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaPOD] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaPDR definito in un ExecCommand del
	 * ContentPanel cpVisuraCIT
	 */
	public ExecResults verificaPDR(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAPDR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAPDR_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2036422420) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (GenericUtil.isNullOrEmpty(theModel.getAppDatavisuraRicerca().getPdr())) {
				addMissingRequiredFieldError("appDatavisuraRicerca.pdr", result);

				// impostazione del result code 
				result.setResultCode(VERIFICAPDR_OUTCOME_CODE__KO);
			} else {

				log.debug("STAMPO IL PDR: " + theModel.getAppDatavisuraRicerca().getPdr());

				try {
					ArrayList<VisuraImpianto> visImpianto = getSOAIntegrationMgr()
							.visuraByPDR(theModel.getAppDatavisuraRicerca().getPdr());

					if (visImpianto != null && visImpianto.size() > 0) {
						theModel.setAppDatavisuraImpiantoList(visImpianto);

						// impostazione del result code 
						result.setResultCode(VERIFICAPDR_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Nessun impianto trovato con il parametro di ricerca inserito");

						result.setResultCode(VERIFICAPDR_OUTCOME_CODE__KO);

					}

				} catch (UserException ue) {
					result.getGlobalErrors().add("Troppi impianti trovati con il parametro di ricerca inserito");

					result.setResultCode(VERIFICAPDR_OUTCOME_CODE__KO);
				} catch (BEException e) {
					result.getGlobalErrors().add(e.getMessage());
					result.setResultCode(VERIFICAPDR_OUTCOME_CODE__KO);
				} catch (Exception e) {
					result.getGlobalErrors().add(Messages.ERROR_RECUPERO_SERVIZIO);
					result.setResultCode(VERIFICAPDR_OUTCOME_CODE__KO);
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaPDR] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaImpianto definito in un ExecCommand del
	 * ContentPanel cpVisuraCIT
	 */
	public ExecResults visualizzaImpianto(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R446352048) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			Integer codImpiantoSelez = getCodImpiantoByIdRiga(idRigaTabella, theModel.getAppDatavisuraImpiantoList());

			//Integer codImpiantoSelez = theModel.getAppDatavisuraCodImpiantoSelez();

			if (!BaseMgr.isNullOrEmpty(codImpiantoSelez)) {

				theModel.setAppDatavisuraCodImpiantoSelez(codImpiantoSelez);

				ArrayList<VisuraImpianto> visImpianto = theModel.getAppDatavisuraImpiantoList();

				for (VisuraImpianto visuraImpianto : visImpianto) {

					if (BaseMgr.convertToInteger(visuraImpianto.getCodiceImpianto()).intValue() == codImpiantoSelez
							.intValue()) {

						theModel.setAppDatavisuraImpianto(visuraImpianto);
						theModel.setAppDatavisuraRifCatastaleList(visuraImpianto.getRifCatastale());
						theModel.setAppDatavisuraRappControlloList(visuraImpianto.getRappControllo());

					}

				}

				result.setResultCode(VISUALIZZAIMPIANTO_OUTCOME_CODE__OK);

			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un impianto");
				result.setResultCode(VISUALIZZAIMPIANTO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaLibretto definito in un ExecCommand del
	 * ContentPanel cpVisuraCIT
	 */
	public ExecResults scaricaLibretto(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICALIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SCARICALIBRETTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1910662578) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String uidLibretto = theModel.getAppDatavisuraImpianto().getUidIndexLibretto();

			theModel.setAppDatavisuraUidLibrettoDaStampare(uidLibretto);

			// impostazione del result code 
			result.setResultCode(SCARICALIBRETTO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scaricaLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbElencoImp
	 */
	public static void resetClearStatus_widg_tbElencoImp(java.util.Map session) {
		session.put("cpVisuraCIT_tbElencoImp_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDatiCatastali
	 */
	public static void resetClearStatus_widg_tbDatiCatastali(java.util.Map session) {
		session.put("cpVisuraCIT_tbDatiCatastali_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRappControllo
	 */
	public static void resetClearStatus_widg_tbRappControllo(java.util.Map session) {
		session.put("cpVisuraCIT_tbRappControllo_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1939728960) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

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

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	public static Integer getCodImpiantoByIdRiga(Integer idRiga, ArrayList<VisuraImpianto> impiantoList) {
		Integer codImpianto = null;

		if (idRiga != null && impiantoList != null) {
			for (VisuraImpianto ace : impiantoList) {

				if (idRiga.intValue() == ace.getIdRigaTabella().intValue()) {
					codImpianto = BaseMgr.convertToInteger(ace.getCodiceImpianto());
				}
			}
		}

		return codImpianto;
	}
	/*PROTECTED REGION END*/
}
