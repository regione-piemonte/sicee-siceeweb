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

/*PROTECTED REGION ID(R1285512865) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
/*PROTECTED REGION END*/

public class CPBECpBloccoUtente {

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

	// ApplicationData: [valoreMsgBlocco, scope:USER_SESSION]
	public static final String APPDATA_VALOREMSGBLOCCO_CODE = "appDatavaloreMsgBlocco";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpBloccoUtente";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo retrieveRagioneBlocco definito in un ExecCommand del
	 * ContentPanel cpBloccoUtente
	 */
	public ExecResults retrieveRagioneBlocco(

			it.csi.sicee.siceeweb.dto.main.CpBloccoUtenteModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RETRIEVERAGIONEBLOCCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R357604027) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			String codiceMsgBlocco = null;
			String valoreMsgBlocco = null;
			log.debug("STATO: " + cert.getStato());
			if (cert.getStato() == Constants.ID_BLOCCO_CERTIFICATORE_RADIATO) {
				codiceMsgBlocco = Constants.MSG_UTENTE_RADIATO;
			} else if (cert.getStato() == Constants.ID_BLOCCO_CERTIFICATORE_DECEDUTO) {
				codiceMsgBlocco = Constants.MSG_UTENTE_DECEDUTO;
			} else if (cert.getStato() == Constants.ID_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI) {
				codiceMsgBlocco = Constants.MSG_UTENTE_FALSE_DICHIARAZIONI;
			}
			valoreMsgBlocco = getMiscMgr().getParametro(codiceMsgBlocco);
			valoreMsgBlocco = "<b><font size=\"+1\">" + valoreMsgBlocco + "</font></b>";
			theModel.setAppDatavaloreMsgBlocco(valoreMsgBlocco);
			// impostazione del result code 
			result.setResultCode(RETRIEVERAGIONEBLOCCO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::retrieveRagioneBlocco] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1654773069) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	/*PROTECTED REGION END*/
}
