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

/*PROTECTED REGION ID(R859295536) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.*;
import it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamenti;
/*PROTECTED REGION END*/

public class CPBECpPrenotazAttestati {

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

	// ApplicationData: [mdpURL, scope:USER_SESSION]
	public static final String APPDATA_MDPURL_CODE = "appDatamdpURL";

	// ApplicationData: [datiPagamento, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTO_CODE = "appDatadatiPagamento";

	// ApplicationData: [numACEDesiderati, scope:USER_SESSION]
	public static final String APPDATA_NUMACEDESIDERATI_CODE = "appDatanumACEDesiderati";

	// ApplicationData: [switchPagamento, scope:USER_SESSION]
	public static final String APPDATA_SWITCHPAGAMENTO_CODE = "appDataswitchPagamento";

	// ApplicationData: [valoreCreditoFinale, scope:USER_SESSION]
	public static final String APPDATA_VALORECREDITOFINALE_CODE = "appDatavaloreCreditoFinale";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpPrenotazAttestati";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaPagamentoACE definito in un ExecCommand del
	 * ContentPanel cpPrenotazAttestati
	 */
	public ExecResults preparaPagamentoACE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpPrenotazAttestatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAPAGAMENTOACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAPAGAMENTOACE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R864160653) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatanumACEDesiderati() != null && theModel.getAppDatanumACEDesiderati().intValue() > 0) {
				theModel.setAppDataswitchPagamento(Constants.PAGAMENTO_ACE);

				DatiPagamento dpaga = new DatiPagamento();
				// l'importo è fisso 10 euri per ace
				dpaga.setImporto(theModel.getAppDatanumACEDesiderati() * getMiscMgr().getPrezzoAce());
				//dpaga.setModPagamento("BB");
				// la causale è fissa
				dpaga.setQuantita(theModel.getAppDatanumACEDesiderati());
				dpaga.setCausale("Matricola xxxxx, Prenotazione xxx A.P.E.");
				dpaga.setDataValuta(DateUtil.convertToUDTDateValid(new java.util.Date()));
				dpaga.setEseguitoDaCognome(theModel.getAppDatacurrentUser().getCognome());
				dpaga.setEseguitoDaNome(theModel.getAppDatacurrentUser().getNome());
				dpaga.setTipo("ACE");
				theModel.setAppDatadatiPagamento(dpaga);
				// impostazione del result code
				result.setResultCode(PREPARAPAGAMENTOACE_OUTCOME_CODE__OK);
			} else {
				result.getFldErrors().put("appDatanumACEDesiderati", "E'necessario selezonare un valore");
				result.setResultCode(PREPARAPAGAMENTOACE_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaPagamentoACE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ottieniValoreCreditoFinale definito in un ExecCommand del
	 * ContentPanel cpPrenotazAttestati
	 */
	public ExecResults ottieniValoreCreditoFinale(

			it.csi.sicee.siceeweb.dto.gestattestati.CpPrenotazAttestatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OTTIENIVALORECREDITOFINALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-786548819) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String fkCertificatore = theModel.getAppDatacertificatore().getIdCertificatore();
			theModel.setAppDatavaloreCreditoFinale(getCertificatoreMgr().getValoreCreditoFinale(fkCertificatore));

			// impostazione del result code 
			result.setResultCode(OTTIENIVALORECREDITOFINALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ottieniValoreCreditoFinale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1868945282) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	/*PROTECTED REGION END*/
}
