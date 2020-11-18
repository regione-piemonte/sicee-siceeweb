package it.csi.sicee.siceeweb.business.annullasostcert;

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

/*PROTECTED REGION ID(R-1281954548) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;

/*PROTECTED REGION END*/

public class CPBECpAnnullaSostAceHome {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [datiAnnullamento, scope:USER_SESSION]
	public static final String APPDATA_DATIANNULLAMENTO_CODE = "appDatadatiAnnullamento";

	// ApplicationData: [motiviAnnullamento, scope:USER_SESSION]
	public static final String APPDATA_MOTIVIANNULLAMENTO_CODE = "appDatamotiviAnnullamento";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [certificatiTrovati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATITROVATI_CODE = "appDatacertificatiTrovati";

	// ApplicationData: [carrelloAceNew, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACENEW_CODE = "appDatacarrelloAceNew";

	// ApplicationData: [carrelloAceOld, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACEOLD_CODE = "appDatacarrelloAceOld";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAnnullaSostAceHome";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaACESostituzione definito in un ExecCommand del
	 * ContentPanel cpAnnullaSostAceHome
	 */
	public ExecResults ricercaACESostituzione(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpAnnullaSostAceHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACESOSTITUZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACESOSTITUZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R303938105) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DtAnnullamento annullamento = theModel.getAppDatadatiAnnullamento();

			boolean out = true;

			if (GenericUtil.isNullOrEmpty(annullamento.getIdMotivo())) {
				addMissingRequiredFieldError("appDatadatiAnnullamento.idMotivo", result);
				out = false;
			}

			if (GenericUtil.isNullOrEmpty(annullamento.getData())) {
				addMissingRequiredFieldError("appDatadatiAnnullamento.data", result);
				out = false;
			}

			if (GenericUtil.isNullOrEmpty(annullamento.getNote())) {
				addMissingRequiredFieldError("appDatadatiAnnullamento.note", result);
				out = false;
			} else if (annullamento.getNote().trim().length() > Constants.LUNGHEZZA_MASSIMA_NOTE) {
				result.getGlobalErrors().add(
						"Il campo Note puo' essere al massimo di " + Constants.LUNGHEZZA_MASSIMA_NOTE + " caratteri");
			}

			if (out) {
				result.setResultCode(RICERCAACESOSTITUZIONE_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(RICERCAACESOSTITUZIONE_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaACESostituzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initDatiAnnullamento definito in un ExecCommand del
	 * ContentPanel cpAnnullaSostAceHome
	 */
	public ExecResults initDatiAnnullamento(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpAnnullaSostAceHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITDATIANNULLAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1576291625) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<MotivoAnnullamento> motivi = (ArrayList<MotivoAnnullamento>) getMiscMgr().getMotiviAnnullamento();
			theModel.setAppDatamotiviAnnullamento(motivi);

			DtAnnullamento annullamento = theModel.getAppDatadatiAnnullamento();

			if (annullamento == null) {
				annullamento = new DtAnnullamento();
			}

			annullamento.setData(GenericUtil.getDataOdierna());
			theModel.setAppDatadatiAnnullamento(annullamento);

			result.setResultCode(INITDATIANNULLAMENTO_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initDatiAnnullamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1252243928) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private MiscMgr miscMgr = null;

	public void setMiscMgr(MiscMgr cm) {
		miscMgr = cm;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	/*PROTECTED REGION END*/
}
