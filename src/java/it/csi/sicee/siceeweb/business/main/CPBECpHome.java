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

/*PROTECTED REGION ID(R-1185626779) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceeweb.business.dao.dto.ZTImpdatiXml2015;

/*PROTECTED REGION END*/

public class CPBECpHome {

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpHome";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaApeJasper definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults verificaApeJasper(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAAPEJASPER_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAAPEJASPER_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R808794546) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(VERIFICAAPEJASPER_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaApeJasper] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo riportaBozza definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults riportaBozza(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPORTABOZZA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RIPORTABOZZA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R531904395) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			int elaboratiOk = getCertificatoMgr()
			//					.testTrattamentoRiportaANuovo();

			int elaboratiOk = testTrattamentoRiportaANuovo();

			result.getGlobalMessages().add("Riportati a NUOVO n. " + elaboratiOk + " A.P.E.");

			// impostazione del result code 
			result.setResultCode(RIPORTABOZZA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::riportaBozza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo effettuaCalcoli definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults effettuaCalcoli(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EFFETTUACALCOLI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EFFETTUACALCOLI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-165461865) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			int elaboratiOk = getCertificatoMgr().testTrattamentoEffettuaCalcoli();

			result.getGlobalMessages().add("Effettuato CALCOLI SMILE e S/V su n. " + elaboratiOk + " A.P.E.");

			// impostazione del result code 
			result.setResultCode(EFFETTUACALCOLI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::effettuaCalcoli] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo effettuaArchivio definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults effettuaArchivio(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EFFETTUAARCHIVIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EFFETTUAARCHIVIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1380928223) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			getCertificatoMgr().ArchiviaACTA();

			// impostazione del result code 
			result.setResultCode(EFFETTUAARCHIVIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::effettuaArchivio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo completaSW definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults completaSW(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String COMPLETASW_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String COMPLETASW_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1153622909) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			int elaboratiOk = testCompletaSw();

			result.getGlobalMessages().add("Completato SW su n. " + elaboratiOk + " A.P.E.");

			// impostazione del result code 
			result.setResultCode(COMPLETASW_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::completaSW] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo estrapolaSW definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults estrapolaSW(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ESTRAPOLASW_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ESTRAPOLASW_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-3687115) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			testElaboraImpDatiTmp();

			// impostazione del result code 
			result.setResultCode(ESTRAPOLASW_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::estrapolaSW] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1358798737) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private CertificatoMgr certificatoMgr = null;

	public void setCertificatoMgr(CertificatoMgr cm) {
		certificatoMgr = cm;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	/**
	 * Questo metodo serve solo una volta x riportare a nuovo gli APE in bozza, il max di elemnti da restituire e' preso dal db
	 *
	 */
	public int testTrattamentoRiportaANuovo() throws BEException {

		log.debug("testTrattamentoRiportaANuovo - START");

		try {

			int elaboratiOk = 0;

			List<SiceeTCertificato> certificatiList = getCertificatoMgr().getSiceeTCertificatoDao()
					.findRiportareANuovo();

			for (SiceeTCertificato siceeTCertificato : certificatiList) {
				if ((siceeTCertificato.getFkStato().intValue() == Constants.BOZZA)) {
					String esito = "KO";
					// Sicuramente lo stato è in stato BOZZA, ma per sicurezza verifico
					try {

						getCertificatoMgr().reInitApe(siceeTCertificato.getIdCertificatore(),
								siceeTCertificato.getProgrCertificato(), siceeTCertificato.getAnno());
						elaboratiOk++;
						esito = "OK";
					} catch (BEException e) {
						log.error("Errore in testTrattamentoRiportaANuovo:" + e, e);
					}
					log.info("##########");
					log.info("########## Riportato a stato NUOVO: " + siceeTCertificato.getAnno() + "-"
							+ siceeTCertificato.getIdCertificatore() + "-" + siceeTCertificato.getProgrCertificato()
							+ " (esito: " + esito + ")");
					log.info("##########");

				}
			}

			log.debug("testTrattamentoRiportaANuovo - END");

			return elaboratiOk;
		} catch (Exception e) {
			throw new BEException("Errore in testRecuperaCertificatiBozzaMax:" + e, e);
		}
	}

	public int testCompletaSw() throws BEException {
		log.debug("testCompletaSw - START");

		try {

			int elaboratiOk = 0;

			List<SiceeTDatiXml2015> siceeTDatiXml2015List = getCertificatoMgr().getSiceeTDatiXml2015Dao()
					.findByDaCompletareTmp(); // Da ricercare quelli dell'ultimo rilascio

			for (SiceeTDatiXml2015 siceeTDatiXml2015 : siceeTDatiXml2015List) {
				String esito = "KO";
				// Sicuramente lo stato è in stato BOZZA, ma per sicurezza verifico
				try {

					getCertificatoMgr().completaSwTmp(siceeTDatiXml2015);
					elaboratiOk++;
					esito = "OK";
				} catch (BEException e) {
					log.error("Errore in testCompletaSw:" + e, e);
				}
				log.info("##########");
				log.info("########## Completato APE: " + siceeTDatiXml2015.getAnno() + "-"
						+ siceeTDatiXml2015.getIdCertificatore() + "-" + siceeTDatiXml2015.getProgrCertificato()
						+ " (esito: " + esito + ")");
				log.info("##########");

			}

			log.debug("testCompletaSw - END");

			return elaboratiOk;
		} catch (Exception e) {
			throw new BEException("Errore in testCompletaSw:" + e, e);
		}
	}

	public void testElaboraImpDatiTmp() throws BEException {
		log.debug("testElaboraImpDatiTmp - START");
		try {

			getCertificatoMgr().completaZTImpdatiTmp();

		} catch (Exception e) {
			throw new BEException("Errore in testElaboraImpDatiTmp:" + e, e);
		}

		log.debug("testElaboraImpDatiTmp - END");

	}
	/*PROTECTED REGION END*/
}
