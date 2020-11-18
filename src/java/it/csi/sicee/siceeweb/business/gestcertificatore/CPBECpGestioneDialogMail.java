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

/*PROTECTED REGION ID(R1131755113) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;

/*PROTECTED REGION END*/

public class CPBECpGestioneDialogMail {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [msgEsitoVerificaMail, scope:USER_SESSION]
	public static final String APPDATA_MSGESITOVERIFICAMAIL_CODE = "appDatamsgEsitoVerificaMail";

	// ApplicationData: [flgEsitoVerifica, scope:USER_SESSION]
	public static final String APPDATA_FLGESITOVERIFICA_CODE = "appDataflgEsitoVerifica";

	// ApplicationData: [authVerify, scope:USER_SESSION]
	public static final String APPDATA_AUTHVERIFY_CODE = "appDataauthVerify";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestioneDialogMail";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciEsitoMailOK definito in un ExecCommand del
	 * ContentPanel cpGestioneDialogMail
	 */
	public ExecResults recepisciEsitoMailOK(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIESITOMAILOK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2085313004) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RECEPISCIESITOMAILOK_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciEsitoMailOK] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciEsitoMailKO definito in un ExecCommand del
	 * ContentPanel cpGestioneDialogMail
	 */
	public ExecResults recepisciEsitoMailKO(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIESITOMAILKO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1225843828) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RECEPISCIESITOMAILKO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciEsitoMailKO] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsgConMail definito in un ExecCommand del
	 * ContentPanel cpGestioneDialogMail
	 */
	public ExecResults gestisciMsgConMail(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSGCONMAIL_OUTCOME_CODE__MSG = //NOSONAR  Reason:EIAS
				"MSG"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1231560651) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIMSGCONMAIL_OUTCOME_CODE__MSG);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciMsgConMail] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciConfermaMail definito in un ExecCommand del
	 * ContentPanel cpGestioneDialogMail
	 */
	public ExecResults gestisciConfermaMail(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICONFERMAMAIL_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R349535399) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (log.isDebugEnabled()) {
				log.debug("STAMPO IL CERTIFICATORE: " + theModel.getAppDatacertificatore());

				log.debug("STAMPO L'ID CERTIFICATORE: " + theModel.getAppDatacertificatore().getIdCertificatore());
			}

			getCertificatoreMgr()
					.aggiornaCertificatoreFlgEmail(theModel.getAppDatacertificatore().getIdCertificatore());

			// impostazione del result code 
			result.setResultCode(GESTISCICONFERMAMAIL_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciConfermaMail] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-770202709) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}
	/*PROTECTED REGION END*/
}
