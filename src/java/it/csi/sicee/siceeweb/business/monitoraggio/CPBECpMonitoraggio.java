package it.csi.sicee.siceeweb.business.monitoraggio;

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

/*PROTECTED REGION ID(R-371595849) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;

import java.io.FileNotFoundException;
import java.io.IOException;
/*PROTECTED REGION END*/

public class CPBECpMonitoraggio {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [provinceMonitoraggio, scope:USER_ACTION]
	public static final String APPDATA_PROVINCEMONITORAGGIO_CODE = "appDataprovinceMonitoraggio";

	// ApplicationData: [titoliMonitoraggio, scope:USER_ACTION]
	public static final String APPDATA_TITOLIMONITORAGGIO_CODE = "appDatatitoliMonitoraggio";

	// ApplicationData: [indirizziMonitoraggio, scope:USER_ACTION]
	public static final String APPDATA_INDIRIZZIMONITORAGGIO_CODE = "appDataindirizziMonitoraggio";

	// ApplicationData: [aceMonitoraggio, scope:USER_SESSION]
	public static final String APPDATA_ACEMONITORAGGIO_CODE = "appDataaceMonitoraggio";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [codiceAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICEATTESTATOSELEZIONATO_CODE = "appDatacodiceAttestatoSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpMonitoraggio";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaFoto definito in un ExecCommand del
	 * ContentPanel cpMonitoraggio
	 */
	public ExecResults scaricaFoto(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICAFOTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SCARICAFOTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1126791722) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato att = theModel.getAppDatacertificato();
			String uidFoto = att.getDatiAnagraficiImm().getDtCatastali().getUidFoto();

			//theModel.setAppDatauidDaStampare(curr.getUid());

			// impostazione del result code 
			result.setResultCode(SCARICAFOTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scaricaFoto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaApe definito in un ExecCommand del
	 * ContentPanel cpMonitoraggio
	 */
	public ExecResults scaricaApe(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SCARICAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1584011180) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiAttestato att = theModel.getAppDatacertificato();

			String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), att.getNumeroAttestato());

			String id = split[Constants.PK_ID_CERTIFICATORE];
			String prog = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			theModel.getSession().put(Constants.PK_ID_CERTIFICATORE, id);

			theModel.getSession().put(Constants.PK_PROGR, prog);

			theModel.getSession().put(Constants.PK_ANNO, anno);

			// impostazione del result code 
			result.setResultCode(SCARICAAPE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scaricaApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaComboTitoli definito in un ExecCommand del
	 * ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboTitoli(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICACOMBOTITOLI_OUTCOME_CODE__OKDATABASE = //NOSONAR  Reason:EIAS
				"OKDatabase"; //NOSONAR  Reason:EIAS
		final String CARICACOMBOTITOLI_OUTCOME_CODE__KODATABASE = //NOSONAR  Reason:EIAS
				"KODatabase"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1782264500) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			loadComboTitoli(theModel);

			// impostazione del result code 
			if (theModel.getAppDatatitoliMonitoraggio() != null && theModel.getAppDatatitoliMonitoraggio().size() > 0)
				result.setResultCode(CARICACOMBOTITOLI_OUTCOME_CODE__OKDATABASE);
			else
				result.setResultCode(CARICACOMBOTITOLI_OUTCOME_CODE__KODATABASE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaComboTitoli] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaComboProvince definito in un ExecCommand del
	 * ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboProvince(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICACOMBOPROVINCE_OUTCOME_CODE__OKTAVT = //NOSONAR  Reason:EIAS
				"OKTavt"; //NOSONAR  Reason:EIAS
		final String CARICACOMBOPROVINCE_OUTCOME_CODE__KOTAVT = //NOSONAR  Reason:EIAS
				"KOTavt"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1455590935) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			loadComboProvince(theModel);

			// impostazione del result code 
			if (theModel.getAppDataprovinceMonitoraggio() != null
					&& theModel.getAppDataprovinceMonitoraggio().size() > 0)
				result.setResultCode(CARICACOMBOPROVINCE_OUTCOME_CODE__OKTAVT);
			else
				result.setResultCode(CARICACOMBOPROVINCE_OUTCOME_CODE__KOTAVT);

			result.setResultCode(CARICACOMBOPROVINCE_OUTCOME_CODE__OKTAVT);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaComboProvince] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaComboIndirizzi definito in un ExecCommand del
	 * ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboIndirizzi(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICACOMBOINDIRIZZI_OUTCOME_CODE__OKTOPE = //NOSONAR  Reason:EIAS
				"OKTope"; //NOSONAR  Reason:EIAS
		final String CARICACOMBOINDIRIZZI_OUTCOME_CODE__KOTOPE = //NOSONAR  Reason:EIAS
				"KOTope"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R558137271) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			loadComboComboIndirizzi(theModel, "via rom", "001272");

			// impostazione del result code 
			if (theModel.getAppDataindirizziMonitoraggio() != null
					&& theModel.getAppDataindirizziMonitoraggio().size() > 0)
				result.setResultCode(CARICACOMBOINDIRIZZI_OUTCOME_CODE__OKTOPE);
			else
				result.setResultCode(CARICACOMBOINDIRIZZI_OUTCOME_CODE__KOTOPE);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaComboIndirizzi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaComboAce definito in un ExecCommand del
	 * ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboAce(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICACOMBOACE_OUTCOME_CODE__OKACE = //NOSONAR  Reason:EIAS
				"OKAce"; //NOSONAR  Reason:EIAS
		final String CARICACOMBOACE_OUTCOME_CODE__KOACE = //NOSONAR  Reason:EIAS
				"KOAce"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1784130628) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			loadComboAce(theModel);
			// impostazione del result code 

			if (theModel.getAppDataaceMonitoraggio() != null && theModel.getAppDataaceMonitoraggio().size() > 0)
				result.setResultCode(CARICACOMBOACE_OUTCOME_CODE__OKACE);
			else
				result.setResultCode(CARICACOMBOACE_OUTCOME_CODE__KOACE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaComboAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R2068595677) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private CertificatoreMgr certificatoreMgr;
	private CertificatoMgr certificatoMgr;
	private SOAIntegrationMgr soaIntegrationMgr;
	private MiscMgr miscMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private void loadComboTitoli(it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel) {
		try {
			theModel.setAppDatatitoliMonitoraggio(getCertificatoreMgr().getAllTitoli());
		} catch (Exception e) {
			theModel.setAppDatatitoliMonitoraggio(null);
		}
	}

	private void loadComboProvince(it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel) {
		try {
			theModel.setAppDataprovinceMonitoraggio(
					(ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByPiemonte());
		} catch (Exception e) {
			theModel.setAppDataprovinceMonitoraggio(null);
		}
	}

	private void loadComboComboIndirizzi(it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel,
			String descrIndirizzo, String codComune) throws BEException {
		try {
			theModel.setAppDataindirizziMonitoraggio(
					(ArrayList<Indirizzo>) getSOAIntegrationMgr().verificaIndirizzi(descrIndirizzo, codComune));
		} catch (Exception e) {
			theModel.setAppDataindirizziMonitoraggio(null);
		}
	}

	private void loadComboAce(it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel) {
		try {

			//			FiltroRicercaAce filtro = new FiltroRicercaAce();
			//			filtro.setStato(Constants.BOZZA);

			/*
			theModel.setAppDataaceMonitoraggio((ArrayList<Ace>) getCertificatoMgr()
					.getCertificati(
							new FiltroRicercaAce(),
							theModel.getAppDatacertificatore()
									.getIdCertificatore()));
			 */

			ArrayList<Ace> listAceMonit = (ArrayList<Ace>) getSOAIntegrationMgr()
					.findAceMonitoraggio(theModel.getAppDatacertificatore().getIdCertificatore());

			theModel.setAppDataaceMonitoraggio(listAceMonit);

			if (listAceMonit != null) {

				DatiAttestato att = theModel.getAppDatacertificato();
				att = getCertificatoMgr().recuperaAttestato(theModel.getAppDatacertificatore(),
						listAceMonit.get(0).getCodice());
				theModel.setAppDatacertificato(att);

			}

		} catch (Exception e) {
			theModel.setAppDataaceMonitoraggio(null);
		}
	}

	/*
	private boolean checkDatiFotoCarica(
			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel,
			ExecResults result) {
	
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
	
		boolean out = true;
		if (GenericUtil.isNullOrEmpty(cat.getNomeFoto())
				&& GenericUtil.isNullOrEmpty(theModel
						.getWidg_fileFotoMonitoraggioFileName())) {
			addMissingRequiredFieldError("monitoraggio.nomeFoto", result);
			out = false;
		} else {
			if (!GenericUtil.isNullOrEmpty(theModel
					.getWidg_fileFotoMonitoraggioFileName())) {
	
				String mimeType = getSOAIntegrationMgr().checkMimeTypeImmagine(
						theModel.getWidg_fileFotoMonitoraggio());
				theModel.setWidg_fileFotoMonitoraggioContentType(mimeType);
				if (GenericUtil.isNullOrEmpty(mimeType)) {
					out = false;
				}
	
				if (!out) {
					result.getGlobalErrors().add(
							"Il formato del file non e' corretto");
				}
	
			} else if (GenericUtil.isNullOrEmpty(cat.getNomeFoto())) {
				result.getGlobalErrors().add(
						"E' necessario selezionare una foto");
				out = false;
			}
		}
	
		if (!GenericUtil.isNullOrEmpty(theModel
				.getWidg_fileFotoMonitoraggioFileName())) {
			if (theModel.getWidg_fileFotoMonitoraggio().length() > Constants.IMAGE_SIZE) {
				result.getGlobalErrors()
						.add("La dimensione della foto e' troppo elevata. La dimensione massima e' di 500Kb");
				out = false;
			}
		}
	
		return out;
	
	}
	 */

	/*
	private String aggiornaFoto(
			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel)
			throws FileNotFoundException, IOException, BEException {
	
		log.debug("[CPBECpMonitoraggio::aggiornaFoto] BEGIN");
		DatiAttestato att = theModel.getAppDatacertificato();
		String uid = "";
		try {
			String nomeFoto = theModel.getWidg_fileFotoMonitoraggioFileName();
			String contentType = theModel
					.getWidg_fileFotoMonitoraggioContentType();
			log.debug("Nome file: " + nomeFoto);
			log.debug("Content Type: " + contentType);
			if (!GenericUtil.isNullOrEmpty(nomeFoto)) {
				java.io.File file = theModel.getWidg_fileFotoMonitoraggio();
				byte[] bytes = getMiscMgr().readFile(file);
	
				uid = getSOAIntegrationMgr().salvaImmagine(
						theModel.getAppDatacertificatore(), att, bytes,
						nomeFoto, contentType, file.length());
	
				att.getDatiAnagraficiImm().getDtCatastali().setUidFoto(uid);
				att.getDatiAnagraficiImm().getDtCatastali()
						.setNomeFoto(nomeFoto);
	
				att.getDatiAnagraficiImm().getDtCatastali()
						.setDataUpFoto(GenericUtil.getDataOdiernaCompleta());
	
				theModel.setAppDatacertificato(att);
	
			}
		} catch (BEException e) {
			throw e;
		} finally {
			log.debug("[CPBECpMonitoraggio::aggiornaFoto] END");
		}
	
		return uid;
	}
	 */

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}
	/*PROTECTED REGION END*/
}
