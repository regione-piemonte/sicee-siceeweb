package it.csi.sicee.siceeweb.business.gestattestati;

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

/*PROTECTED REGION ID(R-200740997) ENABLED START*/
import it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpDuplicaAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [codiciAceNuoviSelezionati, scope:USER_SESSION]
	public static final String APPDATA_CODICIACENUOVISELEZIONATI_CODE = "appDatacodiciAceNuoviSelezionati";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [codAceInviatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACEINVIATOSELEZIONATO_CODE = "appDatacodAceInviatoSelezionato";

	// ApplicationData: [certificatiNuovi, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATINUOVI_CODE = "appDatacertificatiNuovi";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [msgDuplicaAce, scope:SAME_PAGE]
	public static final String APPDATA_MSGDUPLICAACE_CODE = "appDatamsgDuplicaAce";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDuplicaAce";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDuplicaAceAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpDuplicaAce
	 */
	public ExecResults bDuplicaAceAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDuplicaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDUPLICAACEAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDUPLICAACEAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R580427545) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String codAceInviatoSel = theModel.getAppDatacodAceInviatoSelezionato();
			ArrayList<String> numeriCertificatiNuoviSelezionati = theModel.getAppDatacodiciAceNuoviSelezionati();

			String certificatiInviati = "Duplicazione A.P.E. n. ";

			boolean isDuplicato = false;
			if (numeriCertificatiNuoviSelezionati != null && !numeriCertificatiNuoviSelezionati.isEmpty()) {
				for (int index = 0; index < numeriCertificatiNuoviSelezionati.size(); index++) {
					String numeroCertificatoNuovo = numeriCertificatiNuoviSelezionati.get(index);

					isDuplicato = getCertificatoMgr().duplicaAttestato(codAceInviatoSel, numeroCertificatoNuovo);

					if (!isDuplicato) {
						break;
					}

					if (index != 0) {
						certificatiInviati += " / ";
					}

					certificatiInviati += numeroCertificatoNuovo;

				}

				if (isDuplicato) {
					certificatiInviati += " avvenuta correttamente";

					// Duplicazione ACE n. 'anno-matricola-progressivo_certificato'/'anno-matricola-progressivo_certificato'/... avvenuta correttamente

					//				theModel.setAppDatamsgPagamento(MSG_OK_REGISTRAZ
					//						+ "\"" + cert.getNumCertificatore() + "\"");

					theModel.setAppDatamsgDuplicaAce(certificatiInviati);

					result.setResultCode(BDUPLICAACEAVANTISALVA_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Non e' stato possibile duplicare l'A.P.E.");
					result.setResultCode(BDUPLICAACEAVANTISALVA_OUTCOME_CODE__KO);
				}

			} else {
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(BDUPLICAACEAVANTISALVA_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			theModel.getSession().put("active_menu", "menu_items_" + "mnuhome");
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDuplicaAceAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaAttestatiNuovi definito in un ExecCommand del
	 * ContentPanel cpDuplicaAce
	 */
	public ExecResults initListaAttestatiNuovi(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDuplicaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTAATTESTATINUOVI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INITLISTAATTESTATINUOVI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-309052773) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			FiltroRicercaAce filtro = new FiltroRicercaAce();
			filtro.setStato(Constants.NUOVO);
			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			ArrayList<Ace> aceList = (ArrayList<Ace>) getCertificatoMgr()
					.getCertificatiPerDuplicazione(certificatore.getIdCertificatore());

			//			ArrayList<Ace> aceList = (ArrayList<Ace>) getSOAIntegrationMgr()
			//					.findAceFiltro(filtro, certificatore.getIdCertificatore());

			theModel.setAppDatacertificatiNuovi(aceList);
			if (aceList != null && !aceList.isEmpty())
				// impostazione del result code
				result.setResultCode(INITLISTAATTESTATINUOVI_OUTCOME_CODE__OK);
			// impostazione del result code
			else
				result.setResultCode(INITLISTAATTESTATINUOVI_OUTCOME_CODE__KO);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaAttestatiNuovi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblNuoviAce
	 */
	public static void resetClearStatus_widg_tblNuoviAce(java.util.Map session) {
		session.put("cpDuplicaAce_tblNuoviAce_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1198949287) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private CertificatoMgr certificatoMgr = null;
	//private static final String MSG_OK_DUPLICAZIONE = "La registrazione all'elenco regionale e' avvenuta con successo. Il suo N. di iscrizione e' il seguente: ";

	public void setCertificatoMgr(CertificatoMgr cm) {
		certificatoMgr = cm;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/*PROTECTED REGION END*/
}
