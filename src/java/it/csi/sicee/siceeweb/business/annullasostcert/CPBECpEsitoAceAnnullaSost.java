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

/*PROTECTED REGION ID(R-1190324133) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpEsitoAceAnnullaSost {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [codiceCertificatoDaSostituireSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICECERTIFICATODASOSTITUIRESELEZIONATO_CODE = "appDatacodiceCertificatoDaSostituireSelezionato";

	// ApplicationData: [codiceCertificatoSostitutivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICECERTIFICATOSOSTITUTIVOSELEZIONATO_CODE = "appDatacodiceCertificatoSostitutivoSelezionato";

	// ApplicationData: [isPrimoIngresso, scope:USER_SESSION]
	public static final String APPDATA_ISPRIMOINGRESSO_CODE = "appDataisPrimoIngresso";

	// ApplicationData: [carrelloAceOld, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACEOLD_CODE = "appDatacarrelloAceOld";

	// ApplicationData: [carrelloAceNew, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACENEW_CODE = "appDatacarrelloAceNew";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpEsitoAceAnnullaSost";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciStampaRicevuta definito in un ExecCommand del
	 * ContentPanel cpEsitoAceAnnullaSost
	 */
	public ExecResults gestisciStampaRicevuta(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpEsitoAceAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCISTAMPARICEVUTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCISTAMPARICEVUTA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2075515694) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug(
					"@@@@@@@@@Stampo getAppDatacodAttestatoDaStampare: " + theModel.getAppDatacodAttestatoDaStampare());

			if (!GenericUtil.isNullOrEmpty(theModel.getAppDatacodAttestatoDaStampare())) {

				result.setResultCode(GESTISCISTAMPARICEVUTA_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Attenzione. Nessun certificato selezionato.");

				result.setResultCode(GESTISCISTAMPARICEVUTA_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciStampaRicevuta] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblCarrelloAceNew
	 */
	public static void resetClearStatus_widg_tblCarrelloAceNew(java.util.Map session) {
		session.put("cpEsitoAceAnnullaSost_tblCarrelloAceNew_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-575476685) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
