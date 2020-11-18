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

/*PROTECTED REGION ID(R-2141499290) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger;
/*PROTECTED REGION END*/

public class CPBECpRicercaAceInviati {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [filtroAce, scope:USER_ACTION]
	public static final String APPDATA_FILTROACE_CODE = "appDatafiltroAce";

	// ApplicationData: [comuni, scope:USER_ACTION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [province, scope:USER_ACTION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [certificatiInviati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATIINVIATI_CODE = "appDatacertificatiInviati";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [idRigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDRIGASELEZIONATA_CODE = "appDataidRigaSelezionata";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAceInviati";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaACEInviatiByCodice definito in un ExecCommand del
	 * ContentPanel cpRicercaAceInviati
	 */
	public ExecResults ricercaACEInviatiByCodice(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEINVIATIBYCODICE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEINVIATIBYCODICE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2029704953) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

			if (filtro != null) {
				if (GenericUtil.checkFiltroAce(filtro)) {

					// Imposto lo stato
					filtro.setStato(Constants.INVIATO_ANNULLATO);
					// prende solo gli Ace con stato Inviato/Annullato
					ArrayList<Ace> aceList = (ArrayList<Ace>) getSOAIntegrationMgr().findAce(filtro);

					theModel.setAppDatacertificatiInviati(aceList);

					// impostazione del result code
					result.setResultCode(RICERCAACEINVIATIBYCODICE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add(
							"Tutti i campi sono obbligatori ed e' necessario inserirli come indicati nell'esempio.");

					// impostazione del result code
					result.setResultCode(RICERCAACEINVIATIBYCODICE_OUTCOME_CODE__KO);
				}
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			// BEPPE

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaACEInviatiByCodice] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaFromTavt definito in un ExecCommand del
	 * ContentPanel cpRicercaAceInviati
	 */
	public ExecResults setProvinciaFromTavt(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIAFROMTAVT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1461929515) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode(SETPROVINCIAFROMTAVT_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaFromTavt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneFromTavt definito in un ExecCommand del
	 * ContentPanel cpRicercaAceInviati
	 */
	public ExecResults setComuneFromTavt(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNEFROMTAVT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2121557953) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode(SETCOMUNEFROMTAVT_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneFromTavt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAceByFiltro definito in un ExecCommand del
	 * ContentPanel cpRicercaAceInviati
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1428440662) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

			DatiCertificatore certificatore = theModel.getAppDatacertificatore();
			if (GenericUtil.checkFiltroAce2(filtro)) {

				log.debug("Stampo lo stato da ricercare: " + filtro.getStato());

				/*
				ArrayList<Ace> aceList = (ArrayList<Ace>) getCertificatoMgr()
						.getCertificati(filtro,
								certificatore.getIdCertificatore());
				theModel.setAppDatacertificatiInviati(aceList);
				 */

				ArrayList<Ace> aceList = (ArrayList<Ace>) getSOAIntegrationMgr().findAceFiltro(filtro,
						certificatore.getIdCertificatore());

				theModel.setAppDatacertificatiInviati(aceList);

				// impostazione del result code
				result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Attenzione. Nessun criterio di ricerca selezionato.");

				// impostazione del result code
				result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
			}

			// BEPPE

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAceByFiltro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeoPerRicerca definito in un ExecCommand del
	 * ContentPanel cpRicercaAceInviati
	 */
	public ExecResults gestisciComboGeoPerRicerca(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEOPERRICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1246102551) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<Provincia> province = new ArrayList<Provincia>();
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByPiemonte();
			theModel.setAppDataprovince(province);

			String codProvSel = null;

			if (theModel.getAppDatafiltroAce() != null)
				codProvSel = theModel.getAppDatafiltroAce().getCodProv();

			ArrayList<Comune> comuni = new ArrayList<Comune>();

			if (codProvSel != null && codProvSel.length() > 0)
				comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(codProvSel);

			theModel.setAppDatacomuni(comuni);
			// impostazione del result code
			result.setResultCode(GESTISCICOMBOGEOPERRICERCA_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeoPerRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo precaricaFiltroRicercaACE definito in un ExecCommand del
	 * ContentPanel cpRicercaAceInviati
	 */
	public ExecResults precaricaFiltroRicercaACE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PRECARICAFILTRORICERCAACE_OUTCOME_CODE__OKPRECARICA = //NOSONAR  Reason:EIAS
				"OKPrecarica"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-611768743) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();
			if (filtro == null) {
				filtro = new FiltroRicercaAce();
				filtro.setStato(Constants.INVIATO_ANNULLATO);
			}
			DatiCertificatore certificatore = theModel.getAppDatacertificatore();
			if (certificatore != null)
				filtro.setCertificatore(certificatore.getNumCertificatore());
			theModel.setAppDatafiltroAce(filtro);
			// impostazione del result code
			result.setResultCode(PRECARICAFILTRORICERCAACE_OUTCOME_CODE__OKPRECARICA);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::precaricaFiltroRicercaACE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1196659592) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private CertificatoMgr certificatoMgr = null;

	public void setCertificatoMgr(CertificatoMgr cm) {
		certificatoMgr = cm;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	/*PROTECTED REGION END*/
}
