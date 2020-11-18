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

/*PROTECTED REGION ID(R-709265018) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;

/*PROTECTED REGION END*/

public class CPBECpVerificaMail {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [mailVerifica, scope:USER_SESSION]
	public static final String APPDATA_MAILVERIFICA_CODE = "appDatamailVerifica";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpVerificaMail";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaMail definito in un ExecCommand del
	 * ContentPanel cpVerificaMail
	 */
	public ExecResults verificaMail(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpVerificaMailModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAMAIL_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAMAIL_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R489709271) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String mailVerifica = theModel.getAppDatamailVerifica();

			if (BaseMgr.isNullOrEmpty(mailVerifica)) {
				addMissingRequiredFieldError("appDatamailVerifica", result);

				result.setResultCode(VERIFICAMAIL_OUTCOME_CODE__KO);

			} else if (!BaseMgr.checkValideEmail(mailVerifica)) {
				result.getFldErrors().put("appDatamailVerifica", "e-mail non formalmente valida");

				result.setResultCode(VERIFICAMAIL_OUTCOME_CODE__KO);

			} else {
				// La mail è valida
				result.setResultCode(VERIFICAMAIL_OUTCOME_CODE__OK);

				DatiCertificatore cert = theModel.getAppDatacertificatore();

				Date dataVerificaMaster = new Date();
				String dataVerifica = DateUtil.convertToStringDataCompleta(dataVerificaMaster);

				// devo inviare la mail
				getMiscMgr().sendMailVerificaMail(cert, mailVerifica, dataVerifica);

				getCertificatoreMgr().aggiornaCertificatoreEmail(cert.getIdCertificatore(), mailVerifica,
						dataVerificaMaster);

				result.getGlobalMessages().add("E-mail inviata correttamente");
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaMail] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1379789230) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private MiscMgr miscMgr = null;

	public void setMiscMgr(MiscMgr cm) {
		miscMgr = cm;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	/*PROTECTED REGION END*/
}
