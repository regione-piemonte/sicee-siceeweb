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

/*PROTECTED REGION ID(R-1823285783) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpSelezionaTipoRicercaAnnullaSost {

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

	// ApplicationData: [certificatiTrovati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATITROVATI_CODE = "appDatacertificatiTrovati";

	// ApplicationData: [codiciCertificatiSelezionati, scope:USER_SESSION]
	public static final String APPDATA_CODICICERTIFICATISELEZIONATI_CODE = "appDatacodiciCertificatiSelezionati";

	// ApplicationData: [filtroAce, scope:USER_ACTION]
	public static final String APPDATA_FILTROACE_CODE = "appDatafiltroAce";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [idTipoRicAnnullametoSost, scope:USER_SESSION]
	public static final String APPDATA_IDTIPORICANNULLAMETOSOST_CODE = "appDataidTipoRicAnnullametoSost";

	// ApplicationData: [isPrimoIngresso, scope:USER_SESSION]
	public static final String APPDATA_ISPRIMOINGRESSO_CODE = "appDataisPrimoIngresso";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [carrelloAceNew, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACENEW_CODE = "appDatacarrelloAceNew";

	// ApplicationData: [carrelloAceOld, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACEOLD_CODE = "appDatacarrelloAceOld";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpSelezionaTipoRicercaAnnullaSost";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAceDaSostituire definito in un ExecCommand del
	 * ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciAceDaSostituire(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIACEDASOSTITUIRE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-176647034) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataidTipoRicAnnullametoSost(Constants.ID_RICERCA_ACE_OLD);
			theModel.setAppDataisPrimoIngresso(true);

			// impostazione del result code
			result.setResultCode(GESTISCIACEDASOSTITUIRE_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAceDaSostituire] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAceSostitutivi definito in un ExecCommand del
	 * ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciAceSostitutivi(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIACESOSTITUTIVI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1489869297) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataidTipoRicAnnullametoSost(Constants.ID_RICERCA_ACE_NEW);
			theModel.setAppDataisPrimoIngresso(true);

			// impostazione del result code
			result.setResultCode(GESTISCIACESOSTITUTIVI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAceSostitutivi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisualizzaCarrello definito in un ExecCommand del
	 * ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciVisualizzaCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISUALIZZACARRELLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1587205661) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataisPrimoIngresso(true);
			theModel.setAppDatapaginaProvenienza(Constants.PAGINA_SELEZIONE_TIPO_RICERCA);

			// impostazione del result code 
			result.setResultCode(GESTISCIVISUALIZZACARRELLO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisualizzaCarrello] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisCarrello definito in un ExecCommand del
	 * ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciVisCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_VIS = //NOSONAR  Reason:EIAS
				"CARRELLO_VIS"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_NON_VIS = //NOSONAR  Reason:EIAS
				"CARRELLO_NON_VIS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1386154035) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<Ace> carrelloOld = theModel.getAppDatacarrelloAceOld();
			ArrayList<Ace> carrelloNew = theModel.getAppDatacarrelloAceNew();

			if ((carrelloOld != null && !carrelloOld.isEmpty()) || (carrelloNew != null && !carrelloNew.isEmpty())) {
				result.setResultCode(GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_VIS);
			} else {
				result.setResultCode(GESTISCIVISCARRELLO_OUTCOME_CODE__CARRELLO_NON_VIS);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisCarrello] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R945121381) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
