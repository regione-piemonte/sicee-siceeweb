package it.csi.sicee.siceeweb.business.compilazattestatiape;

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

/*PROTECTED REGION ID(R-184513523) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.ValidationMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.exceptions.UserException;
import it.csi.sicee.siceeweb.business.facade.exceptions.ValidationManagerException;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDGradiGiornoDaoException;
import it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel;
import it.csi.sicee.siceeweb.dto.type.UDTDateValid;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiReader;

import java.util.*;

import it.csi.sicee.siceeweb.business.facade.Message;

/*PROTECTED REGION END*/

public class CPBECpCompilazApe {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [provinceCertDTCat, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTDTCAT_CODE = "appDataprovinceCertDTCat";

	// ApplicationData: [comuniCertDtCat, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDTCAT_CODE = "appDatacomuniCertDtCat";

	// ApplicationData: [suggestIndirizzo, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZO_CODE = "appDatasuggestIndirizzo";

	// ApplicationData: [suggestIndirizzoDtCat, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZODTCAT_CODE = "appDatasuggestIndirizzoDtCat";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	// ApplicationData: [fotoSelezionata, scope:USER_SESSION]
	public static final String APPDATA_FOTOSELEZIONATA_CODE = "appDatafotoSelezionata";

	// ApplicationData: [tipoFoto, scope:USER_SESSION]
	public static final String APPDATA_TIPOFOTO_CODE = "appDatatipoFoto";

	// ApplicationData: [tipoFotoSel, scope:USER_SESSION]
	public static final String APPDATA_TIPOFOTOSEL_CODE = "appDatatipoFotoSel";

	// ApplicationData: [tipoFotoAltreSel, scope:USER_SESSION]
	public static final String APPDATA_TIPOFOTOALTRESEL_CODE = "appDatatipoFotoAltreSel";

	// ApplicationData: [visuraRicerca, scope:USER_SESSION]
	public static final String APPDATA_VISURARICERCA_CODE = "appDatavisuraRicerca";

	// ApplicationData: [visuraCodImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_VISURACODIMPIANTOSELEZ_CODE = "appDatavisuraCodImpiantoSelez";

	// ApplicationData: [visuraImpianto, scope:USER_SESSION]
	public static final String APPDATA_VISURAIMPIANTO_CODE = "appDatavisuraImpianto";

	// ApplicationData: [visuraImpiantoList, scope:USER_SESSION]
	public static final String APPDATA_VISURAIMPIANTOLIST_CODE = "appDatavisuraImpiantoList";

	// ApplicationData: [visuraRappControlloList, scope:USER_SESSION]
	public static final String APPDATA_VISURARAPPCONTROLLOLIST_CODE = "appDatavisuraRappControlloList";

	// ApplicationData: [visuraRifCatastaleList, scope:USER_SESSION]
	public static final String APPDATA_VISURARIFCATASTALELIST_CODE = "appDatavisuraRifCatastaleList";

	// ApplicationData: [visuraUidLibrettoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_VISURAUIDLIBRETTODASTAMPARE_CODE = "appDatavisuraUidLibrettoDaStampare";

	// ApplicationData: [tipolCostrutt, scope:USER_SESSION]
	public static final String APPDATA_TIPOLCOSTRUTT_CODE = "appDatatipolCostrutt";

	// ApplicationData: [tipolEdilizia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLEDILIZIA_CODE = "appDatatipolEdilizia";

	// ApplicationData: [tipoRistrutt, scope:USER_SESSION]
	public static final String APPDATA_TIPORISTRUTT_CODE = "appDatatipoRistrutt";

	// ApplicationData: [proprEdificio, scope:USER_SESSION]
	public static final String APPDATA_PROPREDIFICIO_CODE = "appDataproprEdificio";

	// ApplicationData: [listaCf, scope:USER_SESSION]
	public static final String APPDATA_LISTACF_CODE = "appDatalistaCf";

	// ApplicationData: [cfSel, scope:USER_SESSION]
	public static final String APPDATA_CFSEL_CODE = "appDatacfSel";

	// ApplicationData: [motiviRilascio, scope:USER_SESSION]
	public static final String APPDATA_MOTIVIRILASCIO_CODE = "appDatamotiviRilascio";

	// ApplicationData: [oggettiApeLista, scope:USER_SESSION]
	public static final String APPDATA_OGGETTIAPELISTA_CODE = "appDataoggettiApeLista";

	// ApplicationData: [serviziEnergia, scope:USER_SESSION]
	public static final String APPDATA_SERVIZIENERGIA_CODE = "appDataserviziEnergia";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [rifCatasto, scope:USER_SESSION]
	public static final String APPDATA_RIFCATASTO_CODE = "appDatarifCatasto";

	// ApplicationData: [dichiarazioni, scope:USER_SESSION]
	public static final String APPDATA_DICHIARAZIONI_CODE = "appDatadichiarazioni";

	// ApplicationData: [tempDichiarazSelez, scope:USER_SESSION]
	public static final String APPDATA_TEMPDICHIARAZSELEZ_CODE = "appDatatempDichiarazSelez";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [dichiarazioneAceSostitutivo, scope:USER_SESSION]
	public static final String APPDATA_DICHIARAZIONEACESOSTITUTIVO_CODE = "appDatadichiarazioneAceSostitutivo";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpCompilazApe";

	public static final String TABSET_TSPAPE = "tspApe";
	public static final String TAB_TSPAPE_FPTSPAPEDATIGEN = CPNAME + "_" + TABSET_TSPAPE + "_" + "fpTspApeDatiGen";
	public static final String TAB_TSPAPE_FPTSPAPESOPRALLUOGO = CPNAME + "_" + TABSET_TSPAPE + "_"
			+ "fpTspApeSopralluogo";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1756337299) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String actProvSel = theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().getCodProv();

			DatiAttestato datiAttestato = theModel.getAppDatacertificato();

			Provincia provinciaSelez = getProvincia(theModel.getAppDataprovinceCertDTCat(), actProvSel);

			datiAttestato.getDatiAnagraficiImm().getDtCatastali().setDescrProv(provinciaSelez.getNome());

			datiAttestato.getDatiAnagraficiImm().getDtCatastali().setGradiGiorno(null);

			datiAttestato.getDatiAnagraficiImm().getDtCatastali().setZonaClimatica(null);

			/*
			theModel.getAppDatacertificato()
					.getDatiAnagraficiImm()
					.getDtCatastali()
					.setDescrProv(
							getDescrProvincia(
									theModel.getAppDataprovinceCertDTCat(),
									actProvSel));
			 */

			ArrayList<Comune> comuni = new ArrayList<Comune>();

			if (actProvSel != null) {
				comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
			}

			theModel.setAppDatacomuniCertDtCat(comuni);

			datiAttestato.getDatiAnagraficiImm().getDtCatastali().setCodComune(null);

			datiAttestato.getDatiAnagraficiImm().getDtCatastali().setCodComuneCatasto(null);

			theModel.setAppDatacertificato(datiAttestato);

			// svuoto l'indirizzo
			//svuotaComboDtCatastali(theModel);

			// impostazione del result code
			result.setResultCode(SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneDtCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults setComuneDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNEDTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-177481799) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato datiAttestato = theModel.getAppDatacertificato();

			// recupero il comune 
			Comune comuneSelez = getComune(theModel.getAppDatacomuniCertDtCat(),
					theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali().getCodComune());

			/*
			theModel.getAppDatacertificato()
					.getDatiAnagraficiImm()
					.getDtCatastali()
					.setDescrComune(
							getDescrComune(
									theModel.getAppDatacomuniCertDtCat(),
									theModel.getAppDatacertificato()
											.getDatiAnagraficiImm()
											.getDtCatastali().getCodComune()));
			
			theModel.getAppDatacertificato()
					.getDatiAnagraficiImm()
					.getDtCatastali()
					.setCodComuneCatasto(
							getCodComuneCatasto(
									theModel.getAppDatacomuniCertDtCat(),
									theModel.getAppDatacertificato()
											.getDatiAnagraficiImm()
											.getDtCatastali().getCodComune()));
			 */
			datiAttestato.getDatiAnagraficiImm().getDtCatastali().setDescrComune(comuneSelez.getNome());

			datiAttestato.getDatiAnagraficiImm().getDtCatastali().setCodComuneCatasto(comuneSelez.getCodCatasto());

			datiAttestato = getCertificatoMgr().recuperaGradiGiornoEZonaClimatica(datiAttestato);

			theModel.setAppDatacertificato(datiAttestato);

			// svuoto l'indirizzo
			//svuotaComboDtCatastali(theModel);

			// impostazione del result code
			result.setResultCode(SETCOMUNEDTCATASTALI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaIndirizzoDtCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults verificaIndirizzoDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1676682643) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato cert = theModel.getAppDatacertificato();
			DtCatastali dres = cert.getDatiAnagraficiImm().getDtCatastali();

			log.debug("PASSO 1");
			// se non e' compilato il campo comune non faccio partire la verifica
			if (GenericUtil.isNullOrEmpty(dres.getCodComune())) {
				result.getGlobalErrors()
						.add("E' necessario selezionare un comune per effettuare una verifica dell'indirizzo");
				// impostazione del result code 
				result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__KO);
				log.debug("PASSO 2");

			}

			else if ("".equals(dres.getRicercaIndirizzo().trim())) {
				log.debug("PASSO 3");

				result.getGlobalErrors().add("E' necessario indicare un indirizzo per poter effettuare la verifica");
				result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__KO);
			} else {
				log.debug("PASSO 4");

				ArrayList<Indirizzo> indirizzi = caricaComboIndirizzi(dres.getRicercaIndirizzo(),
						Constants.COD_REGIONE_PIEMONTE, dres.getCodComune());

				theModel.setAppDatasuggestIndirizzoDtCat(indirizzi);

				dres.setCodIndirizzo(null);

				if (indirizzi != null && indirizzi.isEmpty()) {
					dres.setDescrIndirizzo(dres.getRicercaIndirizzo());

				} else {
					dres.setDescrIndirizzo(null);
				}

				result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__OK);
				// impostazione del result code
				//				if (theModel.getAppDatasuggestIndirizzoDtCat().size() > 0)
				//					result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__OK);
				//				else {
				//					result.setResultCode(VERIFICAINDIRIZZODTCATASTALI_OUTCOME_CODE__KO);
				//				}
			}

			log.debug("PASSO 5 STAMPO IL RESULT: " + result.getResultCode());

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzoDtCatastali] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo svuotaIndirizzo definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults svuotaIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SVUOTAINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1534512218) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato cert = theModel.getAppDatacertificato();
			DtCatastali dres = cert.getDatiAnagraficiImm().getDtCatastali();
			dres.setCodIndirizzo(null);
			dres.setRicercaIndirizzo(null);
			dres.setDescrIndirizzo(null);

			// impostazione del result code 
			result.setResultCode(SVUOTAINDIRIZZO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::svuotaIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaCoordinate definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults cercaCoordinate(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCACOORDINATE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCACOORDINATE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-85865148) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(CERCACOORDINATE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaCoordinate] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo motivazioneChanged definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults motivazioneChanged(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MOTIVAZIONECHANGED_OUTCOME_CODE__VALORI = //NOSONAR  Reason:EIAS
				"VALORI"; //NOSONAR  Reason:EIAS
		final String MOTIVAZIONECHANGED_OUTCOME_CODE__ALTRO = //NOSONAR  Reason:EIAS
				"ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1407380849) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();

			if (!(Integer.toString(Constants.ID_MOTIVO_ALTRO)
					.equalsIgnoreCase(att.getAltreInfo().getGenerali().getMotivoRilascio()))) {
				att.getAltreInfo().getGenerali().setAltroServiziEnergia(null);
				// impostazione del result code 
				result.setResultCode(MOTIVAZIONECHANGED_OUTCOME_CODE__VALORI);
			} else {
				// impostazione del result code 
				result.setResultCode(MOTIVAZIONECHANGED_OUTCOME_CODE__ALTRO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::motivazioneChanged] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaListaCf definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults caricaListaCf(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICALISTACF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICALISTACF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1913041897) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String cfDigitato = theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCoCertificatore()
					.getCodFisc().toUpperCase();
			log.debug("\n\n\n>>>>>>> CF digitato: " + cfDigitato);
			if (cfDigitato.length() >= 3) {
				ArrayList<SiceeTCertificatore> listaCertificatori = (ArrayList<SiceeTCertificatore>) getCertificatoMgr()
						.recuperaCertificatoriByCf(cfDigitato + "%");
				ArrayList<DtListaCf> listaCf = new ArrayList<DtListaCf>();
				for (SiceeTCertificatore lc : listaCertificatori) {
					DtListaCf dtListaCf = new DtListaCf();
					dtListaCf.setIdCertificatore(lc.getIdCertificatore());
					dtListaCf.setCodiceFiscale(lc.getCodiceFiscale());
					listaCf.add(dtListaCf);
				}
				theModel.setAppDatalistaCf(listaCf);
			}

			// impostazione del result code 
			result.setResultCode(CARICALISTACF_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaListaCf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo copiaDatiCoCertificatore definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults copiaDatiCoCertificatore(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String COPIADATICOCERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String COPIADATICOCERTIFICATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1150653420) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idCertificatore = theModel.getAppDatacfSel();
			if (!BaseMgr.isNullOrEmpty(idCertificatore)) {
				SiceeTCertificatore coCertificatore = getCertificatoMgr().recuperaCertificatore(idCertificatore);
				theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCoCertificatore()
						.setCodFisc(coCertificatore.getCodiceFiscale());
				theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCoCertificatore()
						.setCognome(coCertificatore.getCognome());
				theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCoCertificatore()
						.setNome(coCertificatore.getNome());
				theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCoCertificatore()
						.setNumMatricola(coCertificatore.getNumCertificatore());

				ArrayList<DtListaCf> listaCf = new ArrayList<DtListaCf>();
				DtListaCf lcf = new DtListaCf();
				lcf.setIdCertificatore("");
				lcf.setCodiceFiscale("");
				listaCf.add(lcf);
				theModel.setAppDatalistaCf(listaCf);
			}

			// impostazione del result code 
			result.setResultCode(COPIADATICOCERTIFICATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::copiaDatiCoCertificatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo controlloIndirizzo definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults controlloIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONTROLLOINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONTROLLOINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-158807648) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// l'utente potrebbe aver inserito la descrizione senza aver fatto la verifica indirizzo
			DatiAttestato att = theModel.getAppDatacertificato();
			if (!isVisibleState(theModel)) {
				DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

				if (log.isDebugEnabled()) {
					log.debug("\n");
					log.debug("cat.getCodIndirizzo(): " + cat.getCodIndirizzo());
					log.debug("cat.getDescrIndirizzo(): " + cat.getDescrIndirizzo());
					log.debug("cat.getCodComune(): " + cat.getCodComune());
					log.debug("cat.getCodProv(): " + cat.getCodProv());
					log.debug("cat.getCap(): " + cat.getCap());
					log.debug("cat.getCoordN(): " + cat.getCoordN());
					log.debug("cat.getCoordE(): " + cat.getCoordE());
				}

				// verifico i campi della pagina
				if (checkDatiAnagrafici(theModel, result)) {
					// impostazione del result code
					result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__OK);
				} else {
					// impostazione del result code
					result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__KO);
				}

				//				
				//				if (GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())) {
				//
				//					// richiamo il servizio di verifica indirizzo per verificare
				//					// se esiste l'indirizzo digitato
				//					// in tal caso chiedo all'utente di verificare
				//					try {
				//						if (cat.getDescrIndirizzo() != null) {
				//							cat.setDescrIndirizzo(cat.getDescrIndirizzo()
				//									.toUpperCase());
				//						}
				//
				//						String descrizioneIndirizzo = !GenericUtil
				//								.isNullOrEmpty(cat.getDescrIndirizzo()) ? cat
				//								.getDescrIndirizzo() : cat
				//								.getRicercaIndirizzo();
				//						theModel.setAppDatasuggestIndirizzoDtCat(caricaComboIndirizzi(
				//								descrizioneIndirizzo,
				//								Constants.COD_REGIONE_PIEMONTE,
				//								cat.getCodComune()));
				//
				//					} catch (BEException e) {
				//						log.error(
				//								"[BackEndFacade::checkDatiAnagrafici] Errore occorso nell'esecuzione del metodo caricaComboIndirizzi:"
				//										+ e, e);
				//					}
				//
				//					log.debug("Stampo theModel.getAppDatasuggestIndirizzoDtCat(): "
				//							+ theModel.getAppDatasuggestIndirizzoDtCat());
				//
				//					// se il servizio trova degli indirizzi li propone nella
				//					// combo
				//					if (theModel.getAppDatasuggestIndirizzoDtCat() != null
				//							&& theModel.getAppDatasuggestIndirizzoDtCat()
				//									.size() > 0) {
				//						// cat.setRicercaIndirizzo(cat.getDescrIndirizzo());
				//						addMissingRequiredFieldError(
				//								"appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo",
				//								result);
				//
				//						// verifico gli altri campi della pagina
				//						checkDatiAnagrafici(theModel, result);
				//
				//						// impostazione del result code
				//						result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__SELEZIONARE_INDIRIZZO);
				//					}
				//				}
				//
				//				else if (GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())
				//						&& theModel.getAppDatasuggestIndirizzoDtCat() != null
				//						&& theModel.getAppDatasuggestIndirizzoDtCat().size() > 0) {
				//					addMissingRequiredFieldError(
				//							"appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo",
				//							result);
				//
				//					// verifico gli altri campi della pagina
				//					checkDatiAnagrafici(theModel, result);
				//
				//					// impostazione del result code
				//					result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__SELEZIONARE_INDIRIZZO);
				//				}
				//
				//				// se non sono stati trovati indirizzi controllo che sia
				//				// compilato il campo descrizione
				//				if (result.getResultCode() == null) {
				//					if (GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())
				//							&& GenericUtil.isNullOrEmpty(cat
				//									.getDescrIndirizzo())) {
				//
				//						addMissingRequiredFieldError(
				//								"appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo",
				//								result);
				//
				//						// verifico gli altri campi della pagina
				//						checkDatiAnagrafici(theModel, result);
				//
				//						result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__PROVA);
				//					}
				//
				//					else {
				//						// impostazione del result code
				//
				//						// verifico gli altri campi della pagina
				//						if (checkDatiAnagrafici(theModel, result)) {
				//							if (!GenericUtil.isNullOrEmpty(cat
				//									.getCodIndirizzo())) {
				//								Indirizzo ind = getSOAIntegrationMgr()
				//										.getIndirizzoById(cat.getCodIndirizzo());
				//								cat.setDescrIndirizzo(ind.getDescr()
				//										.toUpperCase());
				//							}
				//							result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__OK);
				//						} else
				//							result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__PROVA);
				//
				//					}
				//}
			} else {
				result.setResultCode(CONTROLLOINDIRIZZO_OUTCOME_CODE__OK);
			}

			log.debug("STAMPO il result.getResultCode(): " + result.getResultCode());

			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::controlloIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtCatastaliAvantiSalva definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults bDtCatastaliAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTCATASTALIAVANTISALVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTCATASTALIAVANTISALVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1557038648) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato att = theModel.getAppDatacertificato();

			// SICEE-96:I campi disabilitati sia per la registrazione (utente
			// registrato) che per la compilazione ace (ace inviato) NON devono
			// MAI essere soggetti a controllo di obbligatorietà
			if (!isVisibleState(theModel)) {
				//				boolean ok = checkDatiAnagrafici(theModel, result);
				//				if (ok) {
				DatiCertificatore cert = theModel.getAppDatacertificatore();

				att.getDichiarazioni().setCodDichiaraz(theModel.getAppDatatempDichiarazSelez());

				att.setStatus(Constants.BOZZA);

				getCertificatoMgr().aggiornaDatiGenerali(cert, att, recuperaDescIndirizzoTope(theModel));
				//getCertificatoMgr().aggiornaDatiCatastali(cert, att, null);

				att.getDatiAnagraficiImm().getDtCatastali().setRicercaIndirizzo(null);

				//				} else
				//					result.setResultCode(BDTCATASTALIAVANTISALVA_OUTCOME_CODE__KO);

				result.getGlobalMessages().add("Salvataggio avvenuto correttamente");

				result.setResultCode(BDTCATASTALIAVANTISALVA_OUTCOME_CODE__OK);

			} else {
				// impostazione del result code
				result.setResultCode(BDTCATASTALIAVANTISALVA_OUTCOME_CODE__OK);
			}

			att.getDatiAnagraficiImm().getDtCatastali().setRicercaIndirizzo(null);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtCatastaliAvantiSalva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaDatiGenerali definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults salvaDatiGenerali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVADATIGENERALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVADATIGENERALI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1059622990) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(SALVADATIGENERALI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaDatiGenerali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtSalvaDataSopralluogo definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults bDtSalvaDataSopralluogo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTSALVADATASOPRALLUOGO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BDTSALVADATASOPRALLUOGO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-708864922) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();
			DtAltreInfo altreInfo = att.getAltreInfo();
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			if (!isVisibleState(theModel)
					&& checkIsValidDataSopralluogo(altreInfo.getSopralluoghi().getData(), result)) {

				getCertificatoMgr().aggiornaDatiGenerali(cert, att, recuperaDescIndirizzoTope(theModel));

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				result.setResultCode(BDTSALVADATASOPRALLUOGO_OUTCOME_CODE__OK);

			} else {
				result.setResultCode(BDTSALVADATASOPRALLUOGO_OUTCOME_CODE__KO);

			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtSalvaDataSopralluogo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFotoElimina definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults bDtFotoElimina(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFOTOELIMINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-509201901) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n>>>>>>> bDtFotoElimina::getAppDatafotoSelezionata(): " + theModel.getAppDatafotoSelezionata());
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatafotoSelezionata())) {
				result.getGlobalErrors().add("E' necessario selezionare la foto da eliminare");
			} else {
				// Eliminazione documento da index e record da SICEE_T_FOTO_2015
				try {
					getCertificatoMgr().eliminaFotoDbIndexByUid(theModel.getAppDatafotoSelezionata());

					/*
					getCertificatoMgr().getSiceeTFoto2015Dao()
							.deleteByIdentificFoto(
									theModel.getAppDatafotoSelezionata());
					getCertificatoMgr().eliminaFotoByUid(
							theModel.getAppDatafotoSelezionata());
					 */

					// Eliminazione istanza dagli appData
					DatiAttestato att = theModel.getAppDatacertificato();
					ArrayList<DtFoto> dtFotoList = att.getDatiAnagraficiImm().getDtCatastali().getDtFoto();
					ArrayList<DtFoto> dtFotoListBuild = new ArrayList<DtFoto>();
					for (DtFoto dtf : dtFotoList) {
						if (!dtf.getUidFoto().equals(theModel.getAppDatafotoSelezionata())) {
							dtFotoListBuild.add(dtf);
						}
					}

					if (dtFotoListBuild.size() < dtFotoList.size()) {
						// se la dimensione dell'ArrayList costruito è minore della dimensione di quello originario
						// ho eliminato una foto secondaria e aggiorno gli appData delle immagini secondarie
						att.getDatiAnagraficiImm().getDtCatastali().setDtFoto(dtFotoListBuild);
					} else {
						// se la dimensione dell'ArrayList costruito è uguale alla dimensione di quello originario
						// ho eliminato la foto principale e aggiorno gli appData dell'immagine principale
						att.getDatiAnagraficiImm().getDtCatastali().setIdFoto(null);
						att.getDatiAnagraficiImm().getDtCatastali().setUidFoto(null);
						att.getDatiAnagraficiImm().getDtCatastali().setDescTipoFoto(null);
						att.getDatiAnagraficiImm().getDtCatastali().setNomeFoto(null);
						att.getDatiAnagraficiImm().getDtCatastali().setDataUpFoto(null);
						att.getDatiAnagraficiImm().getDtCatastali().setPreviewBase64(null);
					}

					theModel.setAppDatacertificato(att);
					theModel.setAppDatafotoSelezionata(null);
					result.getGlobalMessages().add("Eliminazione foto avvenuta correttamente");
				} catch (Exception e) {
					log.error(e);
					result.getGlobalErrors().add(Messages.ERROR_ELIMINAZIONE_FOTO);
				}
			}

			// impostazione del result code 
			result.setResultCode(BDTFOTOELIMINA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFotoElimina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFotoCarica definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults bDtFotoCarica(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFOTOCARICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-614908703) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Carico la foto");

			boolean ok = false;

			try {
				ok = checkDatiFotoCarica(theModel, result);

				log.debug("FOTO - stampo l'esito verifica: " + ok);
			} catch (Exception e) {
				log.error(e);
				result.getGlobalErrors().add(Messages.ERROR_VALIDAZIONE_FOTO);
			}

			if (ok) {

				try {
					Integer errorCaricamento = aggiornaFoto(theModel);

					if (errorCaricamento != null) {

						log.debug("errorCaricamento: " + errorCaricamento);

						if (errorCaricamento.intValue() == Constants.ERRORE_INDEX.intValue()) {
							log.debug("ERRORE INDEX");

							result.getGlobalErrors()
									.add("Aggiornamento della foto non avvenuto correttamente. Si prega di riprovare");
						} else if (errorCaricamento.intValue() == Constants.ERRORE_FOTO.intValue()) {

							log.debug("ERRORE FOTO");

							result.getGlobalErrors().add(
									"Attenzione e' necessario sostituire la foto. Si consiglia di caricare la foto con le caratteristiche specificate nella nota");
						}

					} else {

						log.debug("Devo aggiornare la foto");

						long idFoto = getCertificatoMgr().aggiornaDatiGeneraliFoto(theModel.getAppDatacertificatore(),
								theModel.getAppDatacertificato());

						result.getGlobalMessages().add("Aggiornamento foto avvenuto correttamente");
					}
				} catch (Exception e) {
					log.error(e);
					result.getGlobalErrors().add(Messages.ERROR_CARICAMENTO_FOTO);
				}
			}
			// impostazione del result code
			result.setResultCode(BDTFOTOCARICA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFotoCarica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bDtFotoCaricaAltre definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults bDtFotoCaricaAltre(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BDTFOTOCARICAALTRE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1104031269) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Carico la foto");

			boolean ok = false;

			try {
				ok = checkDatiFotoCaricaAltre(theModel, result);

				log.debug("FOTO - stampo l'esito verifica: " + ok);
			} catch (Exception e) {
				log.error(e);
				result.getGlobalErrors().add(Messages.ERROR_VALIDAZIONE_FOTO);
			}

			if (ok) {

				try {
					Integer errorCaricamento = aggiornaFotoAltre(theModel);

					if (errorCaricamento != null) {

						log.debug("errorCaricamento: " + errorCaricamento);

						if (errorCaricamento.intValue() == Constants.ERRORE_INDEX.intValue()) {
							log.debug("ERRORE INDEX");

							result.getGlobalErrors()
									.add("Aggiornamento della foto non avvenuto correttamente. Si prega di riprovare");
						} else if (errorCaricamento.intValue() == Constants.ERRORE_FOTO.intValue()) {

							log.debug("ERRORE FOTO");

							result.getGlobalErrors().add(
									"Attenzione e' necessario sostituire la foto. Si consiglia di caricare la foto con le caratteristiche specificate nella nota");
						}

					} else {

						log.debug("Devo aggiornare la foto");

						long idFoto = getCertificatoMgr().aggiornaDatiGeneraliFotoAltre(
								theModel.getAppDatacertificatore(), theModel.getAppDatacertificato());

						result.getGlobalMessages().add("Inserimento foto avvenuto correttamente");
					}
				} catch (Exception e) {
					log.error(e);
					result.getGlobalErrors().add(Messages.ERROR_CARICAMENTO_FOTO);
				}
			}

			// impostazione del result code 
			result.setResultCode(BDTFOTOCARICAALTRE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bDtFotoCaricaAltre] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo invioCertificato definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults invioCertificato(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIOCERTIFICATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INVIOCERTIFICATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1455763716) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			// Imposto il numero certificato x la stampa ricevuta
			theModel.setAppDatacodAttestatoDaStampare(numeroCertificato);

			// impostazione del result code 
			result.setResultCode(INVIOCERTIFICATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::invioCertificato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo consolidaCertificato definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults consolidaCertificato(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONSOLIDACERTIFICATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONSOLIDACERTIFICATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1917204549) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			int retval = 0;
			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiAttestato att = theModel.getAppDatacertificato();

			String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), att.getNumeroAttestato());

			String id = split[Constants.PK_ID_CERTIFICATORE];
			String prog = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			SiceeTCertificato certificato = getCertificatoMgr().recuperaCertificato(id, prog, anno);

			// Verifico che il libretto sia stato validato
			if (certificato.getFkStato() == Constants.BOZZA) {

				if (checkDatiAnagrafici(theModel, result)) {

					// Verifico che ci sia almeno una foto

					if (BaseMgr.isNullOrEmpty(att.getDatiAnagraficiImm().getDtCatastali().getIdFoto())) {

						result.getGlobalErrors().add("Occorre caricare la foto principale dell'edificio");

						result.setResultCode(CONSOLIDACERTIFICATO_OUTCOME_CODE__KO);

					} else if (!checkIsValidDataSopralluogo(att.getAltreInfo().getSopralluoghi().getData(), result)) {
						// Verifico che ci sia la data del sopralluogo e che sia valida

						result.setResultCode(CONSOLIDACERTIFICATO_OUTCOME_CODE__KO);
					} else {

						// Effettuo l'aggiornamento!!!
						// Questo metodo è stato aggiunto, perchè a volte sul DB (non si è capito il motivo) mancavano dei dati, quindi vado a completare
						att = completaDatiAttestato(att);

						att.getDichiarazioni().setCodDichiaraz(theModel.getAppDatatempDichiarazSelez());

						getCertificatoMgr().aggiornaDatiGenerali(cert, att, recuperaDescIndirizzoTope(theModel));

						retval = getCertificatoMgr().consolidaApeReadOnly(att.getNumeroAttestato(), cert);

						// devo verifciare che nel caso in cui l'utente ha selezionato un indirizzo dalla combo,
						// devo andare  aripulire il campo settato su descIndirizzo
						if (!GenericUtil.isNullOrEmpty(att.getDatiAnagraficiImm().getDtCatastali().getCodIndirizzo())) {

							// Ripulisco questo campo x non farlo visualizzare sugli indirizzi non trovati
							att.getDatiAnagraficiImm().getDtCatastali().setDescrIndirizzo(null);
						}

						// Errore Gestito: FK_CLASSEENERGETICA NULL
						if (retval == Constants.CODERR_FKCLASSEENERGETICA.intValue()) {
							result.getGlobalErrors().add(
									"APE non consolidato. Motivo: Classe Energetica non calcolata. Verificare all'interno dell'attestato");

							result.setResultCode(CONSOLIDACERTIFICATO_OUTCOME_CODE__KO);
						} else {

							result.getGlobalMessages().add("Ape consolidato correttamente");

							att.setStatus(Constants.CONSOLIDATO);

							// impostazione del result code 
							result.setResultCode(CONSOLIDACERTIFICATO_OUTCOME_CODE__OK);
						}

					}
				} else {
					result.setResultCode(CONSOLIDACERTIFICATO_OUTCOME_CODE__KO);

				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::consolidaCertificato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaApe definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults modificaApe(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MODIFICAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-94700644) ENABLED START*/
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

			if (checkDatiAnagrafici(theModel, result)) {
				if (!isVisibleState(theModel)) {

					att = completaDatiAttestato(att);

					att.getDichiarazioni().setCodDichiaraz(theModel.getAppDatatempDichiarazSelez());

					getCertificatoMgr().aggiornaDatiGenerali(cert, att, recuperaDescIndirizzoTope(theModel));

					// devo verifciare che nel caso in cui l'utente ha selezionato un indirizzo dalla combo,
					// devo andare  aripulire il campo settato su descIndirizzo
					if (!GenericUtil.isNullOrEmpty(att.getDatiAnagraficiImm().getDtCatastali().getCodIndirizzo())) {

						// Ripulisco questo campo x non farlo visualizzare sugli indirizzi non trovati
						att.getDatiAnagraficiImm().getDtCatastali().setDescrIndirizzo(null);
					}

				}
				result.setResultCode(MODIFICAAPE_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(MODIFICAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaApe definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults stampaApe(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1845469294) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato att = theModel.getAppDatacertificato();

			result.setResultCode(STAMPAAPE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaApe definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults verificaApe(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1073043301) ENABLED START*/
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

			if (checkDatiAnagrafici(theModel, result)
					&& checkIsValidDataSopralluogo(att.getAltreInfo().getSopralluoghi().getData(), result)) {
				if (!isVisibleState(theModel)) {

					// Questo metodo è stato aggiunto, perchè a volte sul DB (non si è capito il motivo) mancavano dei dati, quindi vado a completare
					att = completaDatiAttestato(att);

					att.getDichiarazioni().setCodDichiaraz(theModel.getAppDatatempDichiarazSelez());

					getCertificatoMgr().aggiornaDatiGenerali(cert, att, recuperaDescIndirizzoTope(theModel));

					// devo verifciare che nel caso in cui l'utente ha selezionato un indirizzo dalla combo,
					// devo andare  aripulire il campo settato su descIndirizzo
					if (!GenericUtil.isNullOrEmpty(att.getDatiAnagraficiImm().getDtCatastali().getCodIndirizzo())) {

						// Ripulisco questo campo x non farlo visualizzare sugli indirizzi non trovati
						att.getDatiAnagraficiImm().getDtCatastali().setDescrIndirizzo(null);
					}

				}
				result.setResultCode(VERIFICAAPE_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(VERIFICAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaDocAggiuntiva definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults preparaAperturaDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1250829084) ENABLED START*/
			DatiAttestato datiAttestato = theModel.getAppDatacertificato();
			String numeroCertificato = datiAttestato.getNumeroAttestato();

			log.debug("num certificato: " + numeroCertificato);

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {

				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiCertificatore cert = theModel.getAppDatacertificatore();

				String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), numeroCertificato);

				String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
				String progrCertificato = split[Constants.PK_PROGR];
				String anno = split[Constants.PK_ANNO];

				log.debug(idCertificatore);
				log.debug(progrCertificato);
				log.debug(anno);

				if (datiAttestato.getStatus().equals(Constants.NUOVO)) {
					result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO);
					result.getGlobalErrors().add("Ape selezionato in stato nuovo.");
				} else {

					ArrayList<DocumentoAggiuntivo> documenti = getCertificatoMgr()
							.findDocumentiAggiuntiviByAce(idCertificatore, progrCertificato, anno);

					theModel.setAppDatalistDocumentazioneAggiuntiva(documenti);
					theModel.setAppDatacertificato(datiAttestato);
					result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__OK);
				}
			} else {
				result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaDocAggiuntiva] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroDatiCatastali definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults indietroDatiCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRODATICATASTALI_OUTCOME_CODE__RICERCAACE = //NOSONAR  Reason:EIAS
				"RicercaACE"; //NOSONAR  Reason:EIAS
		final String INDIETRODATICATASTALI_OUTCOME_CODE__COMPILAZIONE = //NOSONAR  Reason:EIAS
				"Compilazione"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R323710304) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDataprovenienzaPerReport()
					.equalsIgnoreCase(INDIETRODATICATASTALI_OUTCOME_CODE__RICERCAACE))
				result.setResultCode(INDIETRODATICATASTALI_OUTCOME_CODE__RICERCAACE);
			else
				result.setResultCode(INDIETRODATICATASTALI_OUTCOME_CODE__COMPILAZIONE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroDatiCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo switchScreenState definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHSCREENSTATE_OUTCOME_CODE__REGISTRAZIONE = //NOSONAR  Reason:EIAS
				"REGISTRAZIONE"; //NOSONAR  Reason:EIAS
		final String SWITCHSCREENSTATE_OUTCOME_CODE__VISUALIZZAZIONE = //NOSONAR  Reason:EIAS
				"VISUALIZZAZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R359819705) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiAttestato att = theModel.getAppDatacertificato();
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), att.getNumeroAttestato());

			String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			if (log.isDebugEnabled()) {
				log.debug("\n\nswitchScreenState");
				log.debug("\natt.getStatus(): " + att.getStatus());
				log.debug("\nidCertificatore: " + idCertificatore);
				log.debug("\nprogrCertificato: " + progrCertificato);
				log.debug("\nanno: " + anno);
			}

			//SiceeTImpdatiXml2015 xml = getCertificatoMgr().getSiceeTImpdatiXml2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			//			int ccount = getCertificatoMgr().getSiceeTImpdatiXml2015Dao()
			//					.countByPrimaryKey(idCertificatore, progrCertificato, anno);

			if (BaseMgr.isNullOrEmpty(att.getStatus())) {
				result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__REGISTRAZIONE);
			} else if ((att.getStatus() == Constants.NUOVO) || (att.getStatus() == Constants.BOZZA)) {
				// se non esiste un record in SICEE_T_IMPDATI_XML_2015 allora non c'è stata importazione da XML
				//if (xml == null)

				if (theModel.getAppDatamsgGenerico() != null) {
					result.getGlobalMessages().add(theModel.getAppDatamsgGenerico());

					theModel.setAppDatamsgGenerico(null);
				}
				result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__REGISTRAZIONE);

				//				if (ccount == 0)
				// se esiste un record in SICEE_T_IMPDATI_XML_2015 allora c'è stata importazione da XML
				// prima c'era una diversificazione di comportamento: ora si comportano uguale sia
				// ci sia stata una importazione sia non ci sia stata
				//				else
				//					result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__REGISTRAZIONE);
			} else {
				result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__VISUALIZZAZIONE);
			}

			log.debug("\nSTAMPO result.getResultCode(): " + result.getResultCode());
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchScreenState] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo checkMotivazione definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults checkMotivazione(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHECKMOTIVAZIONE_OUTCOME_CODE__VALORI = //NOSONAR  Reason:EIAS
				"VALORI"; //NOSONAR  Reason:EIAS
		final String CHECKMOTIVAZIONE_OUTCOME_CODE__ALTRO = //NOSONAR  Reason:EIAS
				"ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2068046785) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiAttestato att = theModel.getAppDatacertificato();

			if (!(Integer.toString(Constants.ID_MOTIVO_ALTRO)
					.equalsIgnoreCase(att.getAltreInfo().getGenerali().getMotivoRilascio()))) {
				att.getAltreInfo().getGenerali().setAltroServiziEnergia(null);
				// impostazione del result code 
				result.setResultCode(CHECKMOTIVAZIONE_OUTCOME_CODE__VALORI);
			} else {
				// impostazione del result code 
				result.setResultCode(CHECKMOTIVAZIONE_OUTCOME_CODE__ALTRO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::checkMotivazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaComboIndirizzo definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults visualizzaComboIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1886795542) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Indirizzo> indirizzi = new ArrayList<Indirizzo>();

			DatiAttestato att = theModel.getAppDatacertificato();

			DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

			String descIndirizzo = cat.getDescrIndirizzo();
			Integer idIndSel = cat.getCodIndirizzo();

			if (log.isDebugEnabled()) {
				log.debug("desc ind: " + descIndirizzo);
				log.debug("ind sel: " + idIndSel);
			}

			if (!GenericUtil.isNullOrEmpty(idIndSel) || !GenericUtil.isNullOrEmpty(descIndirizzo)) {
				// Vuol dire che l'indirizzo è nello stradario
				if (!GenericUtil.isNullOrEmpty(idIndSel)) {

					Indirizzo indirizzo = new Indirizzo();
					indirizzo.setCod(idIndSel);
					if(GenericUtil.isNullOrEmpty(descIndirizzo)){
						Indirizzo indirizzoTrovato = getCertificatoMgr().getSoaIntegrationMgr().getIndirizzoById(idIndSel);
						indirizzo.setDescr(indirizzoTrovato.getDescr());
					}else
						indirizzo.setDescr(cat.getDescrIndirizzo());
					indirizzi.add(indirizzo);

					theModel.setAppDatasuggestIndirizzoDtCat(indirizzi);

					// Ripulisco questo campo x non farlo visualizzare sugli indirizzi nont rovati
					att.getDatiAnagraficiImm().getDtCatastali().setDescrIndirizzo(null);
				} else {
					theModel.setAppDatasuggestIndirizzoDtCat(indirizzi);
				}

				// impostazione del result code 
				result.setResultCode(VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__OK);
			} else {
				// Non e' ancora stato cercato l'indirizzo
				// impostazione del result code 
				result.setResultCode(VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaComboIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboIndirizzo definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults gestisciComboIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1781069375) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Indirizzo> indirizzi = new ArrayList<Indirizzo>();

			DatiAttestato att = theModel.getAppDatacertificato();

			DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

			String descIndirizzo = cat.getDescrIndirizzo();
			Integer idIndSel = cat.getCodIndirizzo();

			if (log.isDebugEnabled()) {
				log.debug("desc ind: " + descIndirizzo);
				log.debug("ind sel: " + idIndSel);
			}

			// Sicuramente almeno uno dei due ci deve essere
			if (!GenericUtil.isNullOrEmpty(idIndSel) || !GenericUtil.isNullOrEmpty(descIndirizzo)) {
				// Vuol dire che l'indirizzo è nello stradario
				if (!GenericUtil.isNullOrEmpty(idIndSel)) {

					if (log.isDebugEnabled()) {
						log.debug("IND NOT NULL");
					}

					Indirizzo indirizzo = new Indirizzo();
					indirizzo.setCod(idIndSel);
					if(GenericUtil.isNullOrEmpty(descIndirizzo)){
						Indirizzo indirizzoTrovato = getCertificatoMgr().getSoaIntegrationMgr().getIndirizzoById(idIndSel);
						indirizzo.setDescr(indirizzoTrovato.getDescr());
					}else
						indirizzo.setDescr(cat.getDescrIndirizzo());
					indirizzi.add(indirizzo);

					theModel.setAppDatasuggestIndirizzoDtCat(indirizzi);

					// Ripulisco questo campo x non farlo visualizzare sugli indirizzi nont rovati
					att.getDatiAnagraficiImm().getDtCatastali().setDescrIndirizzo(null);
				} else {
					theModel.setAppDatasuggestIndirizzoDtCat(indirizzi);
				}
			}

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOINDIRIZZO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R489775868) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);

			// indirizzi
			theModel.setAppDatasuggestIndirizzo(new ArrayList<Indirizzo>());

			if (theModel.getAppDatasuggestIndirizzoDtCat() == null)
				theModel.setAppDatasuggestIndirizzoDtCat(new ArrayList<Indirizzo>());

			// impostazione del result code
			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpCompilazApe
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R615745912) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			if (msg != null) {
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());

				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			}

			// impostazione del result code 
			result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiornaDatiPagina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDichiarazioneIndipendenza
	 */
	public static void resetClearStatus_widg_tblDichiarazioneIndipendenza(java.util.Map session) {
		session.put("cpCompilazApe_tblDichiarazioneIndipendenza_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-164372415) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private ValidationMgr validationMgr = null;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private String getDescrProvincia(ArrayList<Provincia> province, String id) {
		if (province != null) {
			if (id != null && id.length() > 0) {
				for (Provincia provincia : province) {
					if (provincia.getCod().equals(id))
						return provincia.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private Provincia getProvincia(ArrayList<Provincia> province, String id) {
		if (province != null) {
			if (id != null && id.length() > 0) {
				for (Provincia provincia : province) {
					if (provincia.getCod().equals(id))
						return provincia;
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private ArrayList<Indirizzo> caricaComboIndirizzi(String descrIndirizzo, String codReg, String codComune)
			throws BEException {
		if (Constants.COD_REGIONE_PIEMONTE.equals(codReg)) {
			// cerco solo se regione == piemonte
			return (ArrayList<Indirizzo>) getSOAIntegrationMgr().verificaIndirizzi(descrIndirizzo, codComune);
		} else {
			log.debug("L'elenco degli indirizzi è vuoto!!!!!!!!!");
			return new ArrayList<Indirizzo>();
		}

	}

	private boolean isVisibleState(it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel) {
		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if ((theModel.getAppDatacertificato().getStatus() != null)
				&& (theModel.getAppDatacertificato().getStatus() >= Constants.CONSOLIDATO)) {
		 */
		if ((theModel.getAppDatacertificato().getStatus() != null)
				&& ((theModel.getAppDatacertificato().getStatus() == Constants.CONSOLIDATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.INVIATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.ANNULLATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.DA_INVIARE)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.SOSPESO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.CANCELLATO)
						|| (theModel.getAppDatacertificato().getStatus() == Constants.ANNULLATO_BO))) {
			return true;
		}

		return false;
	}

	private boolean checkDatiAnagrafici(it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel,
			ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
		DtTecniciGen tec = att.getDatiTecnici();
		DtCoCertificatore coCert = att.getDatiAnagraficiImm().getDtCoCertificatore();
		DtAIGenerali dtGenerali = att.getAltreInfo().getGenerali();

		DtDichiarazFinale dic = att.getDichiarazioni();

		boolean out = true;

		if (GenericUtil.isNullOrEmpty(cat.getCodProv())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codProv", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getCodComune())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codComune", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getCodIndirizzo()) && GenericUtil.isNullOrEmpty(cat.getDescrIndirizzo())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo", result);

			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo", result);

			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.ricercaIndirizzo", result);

			out = false;
		}

		/*
		if (GenericUtil.isNullOrEmpty(cat.getZonaClimatica())) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.zonaClimatica",
					result);
			out = false;
		}
		
		if (GenericUtil.isNullOrEmpty(cat.getGradiGiorno())) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.gradiGiorno",
					result);
			out = false;
		}
		 */

		//_sv_ spostato in controlloIndirizzo()
		/*if (GenericUtil.isNullOrEmpty(cat.getDescrIndirizzo())) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo",
					result);
			out = false;
		}*/

		if (GenericUtil.isNullOrEmpty(cat.getCoordN())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.coordN", result);
			out = false;
		} else if (!GenericUtil.isNumeroDecimaleValido(cat.getCoordE(), 16, 8)) {
			result.getFldErrors().put("appDatacertificato.datiAnagraficiImm.dtCatastali.coordE",
					"Le coordinate devono essere numeriche e valide");
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getCoordE())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.coordE", result);
			out = false;
		} else if (!GenericUtil.isNumeroDecimaleValido(cat.getCoordN(), 16, 8)) {
			result.getFldErrors().put("appDatacertificato.datiAnagraficiImm.dtCatastali.coordN",
					"Le coordinate devono essere numeriche e valide");
			out = false;
		}

		//@@@CONTROLLO COORDINATE INIZIO
		/*
		if (cat.getCoordE().indexOf(".") < 0) {
			result.getFldErrors()
					.put("appDatacertificato.datiAnagraficiImm.dtCatastali.coordE",
							"Il separatore dei numeri decimali delle coordinate deve essere il punto (.)");
			out = false;
		}
		
		if (cat.getCoordN().indexOf(".") < 0) {
			result.getFldErrors()
					.put("appDatacertificato.datiAnagraficiImm.dtCatastali.coordN",
							"Il separatore dei numeri decimali delle coordinate deve essere il punto (.)");
			out = false;
		}*/

		//@@@CONTROLLO COORDINATE FINE

		if (GenericUtil.isNullOrEmpty(cat.getCap())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.cap", result);
			out = false;
		} else if (!GenericUtil.isNullOrEmpty(cat.getCap())) {
			if (!BaseMgr.checkValideNumber(cat.getCap())) {
				result.getFldErrors().put("appDatacertificato.datiAnagraficiImm.dtCatastali.cap",
						"solo caratteri numerici");
				out = false;
			}
		}

		/*
		if (GenericUtil.isNullOrEmpty(cat.getNumCiv())) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.numCiv",
					result);
			out = false;
		} else if (!GenericUtil.isNullOrEmpty(cat.getNumCiv())) {
			if (!BaseMgr.checkValideNumber(cat.getNumCiv())) {
				result.getFldErrors()
						.put("appDatacertificato.datiAnagraficiImm.dtCatastali.numCiv",
								"solo caratteri numerici");
				out = false;
			}
		}
		 */

		// Beppe 10/01/2012
		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getFlgCondominio())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.datiAnagraficiImm.dtCatastali.flgCondominio",
		 * result); out = false; }
		 */

		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getSezione())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.datiAnagraficiImm.dtCatastali.sezione", result);
		 * out = false; }
		 */

		if (GenericUtil.isNullOrEmpty(cat.getFoglio())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.foglio", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(cat.getParticella())) {
			addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCatastali.particella", result);
			out = false;
		}

		if (!GenericUtil.isNullOrEmpty(cat.getSubalterno())) {
			if (!GenericUtil.isNumero(cat.getSubalterno())) {
				result.getFldErrors().put("appDatacertificato.datiAnagraficiImm.dtCatastali.subalterno",
						"Il subalterno pricipale deve essere numerico");
				out = false;
			}
		}

		/*
		 * if (GenericUtil.isNullOrEmpty(cat.getSubalterno())) {
		 * addMissingRequiredFieldError(
		 * "appDatacertificato.datiAnagraficiImm.dtCatastali.subalterno",
		 * result); out = false; }
		 */
		/*
		if (GenericUtil.isNullOrEmpty(cat.getPiano())) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.piano",
					result);
			out = false;
		}
		 */

		/*
		if (GenericUtil.isNullOrEmpty(cat.getPianiTot())) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.pianiTot",
					result);
			out = false;
		}
		
		if (!GenericUtil.isNullOrEmpty(cat.getNote())
				&& cat.getNote().length() > 2000) {
			result.getGlobalErrors()
					.add("La dimensione del campo Note non puo' superare i 2000 caratteri");
		
			out = false;
		}
		 */

		if (GenericUtil.isNullOrEmpty(tec.getAnnoCostr())) {
			addMissingRequiredFieldError("appDatacertificato.datiTecnici.annoCostr", result);
			out = false;
		} else if (!GenericUtil.checkValideFourNumber(tec.getAnnoCostr())) {
			addFormatRequiredFieldError("appDatacertificato.datiTecnici.annoCostr", result);
			out = false;
		} else {
			int anno = BaseMgr.convertToInteger(tec.getAnnoCostr());
			if (anno > DateUtil.getAnnoCorrente()) {
				result.getFldErrors().put("appDatacertificato.datiTecnici.annoCostr", "l'anno non puo' essere futuro");
				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(tec.getAnnoUltimaRistrutt())) {
			if (!GenericUtil.checkValideFourNumber(tec.getAnnoUltimaRistrutt())) {
				addFormatRequiredFieldError("appDatacertificato.datiTecnici.annoUltimaRistrutt", result);
				out = false;
			} else {
				int anno = BaseMgr.convertToInteger(tec.getAnnoUltimaRistrutt());
				if (anno > DateUtil.getAnnoCorrente()) {
					result.getFldErrors().put("appDatacertificato.datiTecnici.annoUltimaRistrutt",
							"l'anno non puo' essere futuro");
					out = false;
				}
			}
		}

		if (GenericUtil.isNullOrEmpty(dic.getDataDichiarazione())) {
			addMissingRequiredFieldError("appDatacertificato.dichiarazioni.dataDichiarazione", result);
			out = false;
		}

		//		if (!DateUtil.checkDateFuture(dic.getDataDichiarazione()
		//				.getValue())) {
		//			result.getGlobalErrors().add(
		//					"La data di emissione non puo' essere futura");
		//			out = false;
		//		}

		if (GenericUtil.isNullOrEmpty(att.getIdScadenza())) {
			addMissingRequiredFieldError("appDatacertificato.idScadenza", result);
			out = false;
		}

		if ((GenericUtil.isNullOrEmpty(tec.getTipoRistrutturazione()))
				&& (!GenericUtil.isNullOrEmpty(tec.getAnnoUltimaRistrutt()))) {
			addMissingRequiredFieldError("appDatacertificato.datiTecnici.tipoRistrutturazione", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(tec.getTipolEdilizia())) {
			addMissingRequiredFieldError("appDatacertificato.datiTecnici.tipolEdilizia", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(tec.getTipolCostruttiva())) {
			addMissingRequiredFieldError("appDatacertificato.datiTecnici.tipolCostruttiva", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(tec.getProprEdificio())) {
			addMissingRequiredFieldError("appDatacertificato.datiTecnici.proprEdificio", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(tec.getOggetto())) {
			addMissingRequiredFieldError("appDatacertificato.datiTecnici.oggetto", result);
			out = false;
		}

		if (GenericUtil.isNullOrEmpty(dtGenerali.getMotivoRilascio())) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.generali.motivoRilascio", result);
			out = false;
		}

		if (((Integer.toString(Constants.ID_MOTIVO_ALTRO)).equalsIgnoreCase(dtGenerali.getMotivoRilascio()))
				&& (GenericUtil.isNullOrEmpty(dtGenerali.getAltroServiziEnergia()))) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.generali.altroServiziEnergia", result);
			out = false;
		}

		// Dati co-certificatore (o sono nulli tutti o se uno solo non è nullo devono esserci tutti)
		if ((!GenericUtil.isNullOrEmpty(coCert.getCodFisc())) || (!GenericUtil.isNullOrEmpty(coCert.getCognome()))
				|| (!GenericUtil.isNullOrEmpty(coCert.getNome()))
				|| (!GenericUtil.isNullOrEmpty(coCert.getNumMatricola()))) {
			if (GenericUtil.isNullOrEmpty(coCert.getCodFisc())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.codFisc", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(coCert.getCognome())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.cognome", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(coCert.getNome())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.nome", result);
				out = false;
			}
			if (GenericUtil.isNullOrEmpty(coCert.getNumMatricola())) {
				addMissingRequiredFieldError("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.numMatricola",
						result);
				out = false;
			}

		}
		//		if (GenericUtil.isNullOrEmpty(att.getDataScadenza())) {
		//			addMissingRequiredFieldError("appDatacertificato.dataScadenza",
		//					result);
		//			out = false;
		//		}

		// Nel caso in cui le verifiche sui singoli campi siano corretti procedo con i controlli combinati
		if (out) {

			if (!GenericUtil.isNullOrEmpty(coCert.getCodFisc())) {
				try {
					getValidationMgr().controlloCf(coCert.getCodFisc(),
							"appDatacertificato.datiAnagraficiImm.dtCoCertificatore.codFisc");
				} catch (ValidationManagerException ex) {
					result.getGlobalErrors().add(ex.getMessage());
					result.getFldErrors().put("appDatacertificato.datiAnagraficiImm.dtCoCertificatore.codFisc",
							"il campo non e' corretto");

					out = false;
				}
			}

			//			if (!DateUtil.checkDateOrder(dic.getDataDichiarazione().getValue(),
			//					att.getDataScadenza(), true)) {
			//				result.getGlobalErrors()
			//						.add("La data di scadenza deve essere superiore alla data di emissione");
			//				out = false;
			//			}
			//
			//			if (!DateUtil.checkDateOrder(att.getDataScadenza(),
			//					getMaxDataScadenza(dic.getDataDichiarazione().getValue()),
			//					true)) {
			//				result.getGlobalErrors()
			//						.add("Il certificato puo' avere validita' massima di 10 anni");
			//				out = false;
			//			}

			if (out && !GenericUtil.isNullOrEmpty(tec.getAnnoUltimaRistrutt())) {

				int annoCostr = BaseMgr.convertToInteger(tec.getAnnoCostr());
				int annoRistr = BaseMgr.convertToInteger(tec.getAnnoUltimaRistrutt());

				if (annoCostr > annoRistr) {
					result.getGlobalErrors()
							.add("L'anno di ristrutturazione non puo' essere precedente all'anno di costruzione");

					out = false;

				}
			}

			if (out && GenericUtil.isNullOrEmpty(theModel.getAppDatatempDichiarazSelez())) {
				result.getGlobalErrors().add("E' necessario selezionare la Dichiarazione indipendenza e imparzialita'");

				out = false;

			}

			if (out && cat.getSistCatast().equalsIgnoreCase(Constants.ID_RIF_CATASTO_CT)) {
				result.getGlobalErrors().add("Catasto Tavolare non in uso nella provincia selezionata");

				out = false;
			}

		}

		return out;
	}

	/*
	private boolean checkIndirizzo(
			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel,
			ExecResults result) {
	
		DatiAttestato att = theModel.getAppDatacertificato();
	
		boolean out = true;
	
		// devo verificare che l'utente abbia messo l'indirizzo
		Integer codIndirizzo = att.getDatiAnagraficiImm().getDtCatastali()
				.getCodIndirizzo();
		String descIndirizzo = att.getDatiAnagraficiImm().getDtCatastali()
				.getDescrIndirizzo();
	
		if (GenericUtil.isNullOrEmpty(codIndirizzo)
				&& GenericUtil.isNullOrEmpty(descIndirizzo)) {
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo",
					result);
	
			addMissingRequiredFieldError(
					"appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo",
					result);
	
			out = false;
	
		}
	
		return out;
	}
	 */

	public static String getMaxDataScadenza(String dataEmissione) {

		try {
			return DateUtil.addTenYear(dataEmissione);
		} catch (BEException e) {
			// Non dovrebbe mai capitare, ho già verificato la data formalmente
			return null;
		}

	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	private void addFormatRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo deve essere numerico");
	}

	private void gestisciComboDtCatasto(it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel)
			throws BEException {

		DatiAttestato cert = theModel.getAppDatacertificato();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByPiemonte();
		theModel.setAppDataprovinceCertDTCat(province);

		String actProvSel = cert.getDatiAnagraficiImm().getDtCatastali().getCodProv();
		ArrayList<Comune> comuni = new ArrayList<Comune>();

		log.debug("STAMPO IL actProvSel: " + actProvSel);

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuniCertDtCat(comuni);

		ArrayList<SiceeDTipoRistrutt2015> tipoRistrutt = (ArrayList<SiceeDTipoRistrutt2015>) getCertificatoMgr()
				.recuperaDTipoRistrutt2015();
		ArrayList<DtDecodTipologie> dtDecodTipologie = new ArrayList<DtDecodTipologie>();
		for (SiceeDTipoRistrutt2015 tr : tipoRistrutt) {
			DtDecodTipologie ddt = new DtDecodTipologie();
			ddt.setIdTipo(tr.getIdTipoRistrutturaz());
			ddt.setDescr(tr.getDescr());
			dtDecodTipologie.add(ddt);
		}
		theModel.setAppDatatipoRistrutt(dtDecodTipologie);

		ArrayList<SiceeDTipolEdilizia2015> tipolEdilizia = (ArrayList<SiceeDTipolEdilizia2015>) getCertificatoMgr()
				.recuperaDTipolEdilizia2015();
		dtDecodTipologie = new ArrayList<DtDecodTipologie>();
		for (SiceeDTipolEdilizia2015 te : tipolEdilizia) {
			DtDecodTipologie ddt = new DtDecodTipologie();
			ddt.setIdTipo(te.getIdTipolEdilizia());
			ddt.setDescr(te.getDescr());
			dtDecodTipologie.add(ddt);
		}
		theModel.setAppDatatipolEdilizia(dtDecodTipologie);

		ArrayList<DtDecodTipologieCod> dtDecodTipologieCod = new ArrayList<DtDecodTipologieCod>();

		DtDecodTipologieCod dCat = new DtDecodTipologieCod();
		dCat.setCodTipo(Constants.ID_RIF_CATASTO_NCEU);
		dCat.setDescr(Constants.DESC_RIF_CATASTO_NCEU);
		dtDecodTipologieCod.add(dCat);

		dCat = new DtDecodTipologieCod();
		dCat.setCodTipo(Constants.ID_RIF_CATASTO_NCT);
		dCat.setDescr(Constants.DESC_RIF_CATASTO_NCT);
		dtDecodTipologieCod.add(dCat);

		dCat = new DtDecodTipologieCod();
		dCat.setCodTipo(Constants.ID_RIF_CATASTO_CT);
		dCat.setDescr(Constants.DESC_RIF_CATASTO_CT);
		dtDecodTipologieCod.add(dCat);

		theModel.setAppDatarifCatasto(dtDecodTipologieCod);

		ArrayList<SiceeDTipolCostrutt2015> tipolCostrutt = (ArrayList<SiceeDTipolCostrutt2015>) getCertificatoMgr()
				.recuperaDTipolCostrutt2015();
		dtDecodTipologie = new ArrayList<DtDecodTipologie>();
		for (SiceeDTipolCostrutt2015 tc : tipolCostrutt) {
			DtDecodTipologie ddt = new DtDecodTipologie();
			ddt.setIdTipo(tc.getIdTipolCostrutt());
			ddt.setDescr(tc.getDescr());
			dtDecodTipologie.add(ddt);
		}
		theModel.setAppDatatipolCostrutt(dtDecodTipologie);

		ArrayList<SiceeDProprietaEdif2015> proprEdificio = (ArrayList<SiceeDProprietaEdif2015>) getCertificatoMgr()
				.recuperaDProprietaEdif2015();
		dtDecodTipologie = new ArrayList<DtDecodTipologie>();
		for (SiceeDProprietaEdif2015 pe : proprEdificio) {
			DtDecodTipologie ddt = new DtDecodTipologie();
			ddt.setIdTipo(pe.getIdProprietaEdi());
			ddt.setDescr(pe.getDescr());
			dtDecodTipologie.add(ddt);
		}
		theModel.setAppDataproprEdificio(dtDecodTipologie);

		ArrayList<SiceeDMotivoRilascio> motivoRilascioAttivo = (ArrayList<SiceeDMotivoRilascio>) getCertificatoMgr()
				.recuperaDMotivoRilascio();
		ArrayList<MotivoRilascio> motivoRilascio = new ArrayList<MotivoRilascio>();
		for (SiceeDMotivoRilascio mra : motivoRilascioAttivo) {
			MotivoRilascio mr = new MotivoRilascio();
			mr.setCod(Integer.toString(mra.getIdMotivo()));
			mr.setDescr(mra.getDescr());
			motivoRilascio.add(mr);
		}
		theModel.setAppDatamotiviRilascio(motivoRilascio);

		ArrayList<SiceeDOggettoApe2015> oggettiApe = (ArrayList<SiceeDOggettoApe2015>) getCertificatoMgr()
				.recuperaDOggettoApe();
		ArrayList<DtDecodTipologie> dtOggettiApe = new ArrayList<DtDecodTipologie>();
		for (SiceeDOggettoApe2015 oa : oggettiApe) {
			DtDecodTipologie dt = new DtDecodTipologie();
			dt.setIdTipo((int) oa.getIdOggettoApe());
			dt.setDescr(oa.getDescr());
			dtOggettiApe.add(dt);
		}
		theModel.setAppDataoggettiApeLista(dtOggettiApe);

		ArrayList<SiceeDMotivoRilascio> serviziEnergiaAttivo = (ArrayList<SiceeDMotivoRilascio>) getCertificatoMgr()
				.recuperaServiziEnergia();
		ArrayList<MotivoRilascio> serviziEnergia = new ArrayList<MotivoRilascio>();
		for (SiceeDMotivoRilascio se : serviziEnergiaAttivo) {
			MotivoRilascio mr = new MotivoRilascio();
			mr.setCod(Integer.toString(se.getIdMotivo()));
			mr.setDescr(se.getDescr());
			serviziEnergia.add(mr);
		}
		theModel.setAppDataserviziEnergia(serviziEnergia);

		ArrayList<SiceeDTipoFoto2015> tipoFoto = (ArrayList<SiceeDTipoFoto2015>) getCertificatoMgr()
				.recuperaTipoFoto2015();
		ArrayList<DtTipoFoto> dtTipoFoto = new ArrayList<DtTipoFoto>();
		for (SiceeDTipoFoto2015 tf : tipoFoto) {
			DtTipoFoto dtf = new DtTipoFoto();
			dtf.setIdTipoFoto((int) tf.getIdTipoFoto());
			dtf.setDescr(tf.getDescr());
			dtTipoFoto.add(dtf);
		}
		theModel.setAppDatatipoFoto(dtTipoFoto);

		ArrayList<DtListaCf> listaCf = new ArrayList<DtListaCf>();
		DtListaCf lcf = new DtListaCf();
		lcf.setIdCertificatore("");
		lcf.setCodiceFiscale("");
		listaCf.add(lcf);
		theModel.setAppDatalistaCf(listaCf);

		if (theModel.getAppDatadichiarazioni() == null) {
			ArrayList<Dichiarazione> dichiarazioni = (ArrayList<Dichiarazione>) getMiscMgr().getDichiarazioniNew();

			theModel.setAppDatadichiarazioni(dichiarazioni);
		}

		// il tipo della foto principale è sempre 1 --> Facciata edificio
		// la combo corrispondente è bloccata
		theModel.setAppDatatipoFotoSel(1);
	}

	private Comune getComune(ArrayList<Comune> comuni, String id) {
		if (comuni != null) {
			if (id != null && id.length() > 0) {
				for (Comune comune : comuni) {
					if (comune.getCod().equals(id))
						return comune;
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private String getDescrComune(ArrayList<Comune> comuni, String id) {
		if (comuni != null) {
			if (id != null && id.length() > 0) {
				for (Comune comune : comuni) {
					if (comune.getCod().equals(id))
						return comune.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private String getCodComuneCatasto(ArrayList<Comune> comuni, String id) {
		if (comuni != null) {
			if (id != null && id.length() > 0) {
				for (Comune comune : comuni) {
					if (comune.getCod().equals(id))
						return comune.getCodCatasto();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private boolean checkDatiFotoCarica(CpCompilazApeModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

		boolean out = true;
		if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoFileName())) {
			if (getMiscMgr().isFileNameValid(theModel.getWidg_fileFotoCatastoFileName())) {

				String mimeType = getSOAIntegrationMgr().checkMimeTypeImmagine(theModel.getWidg_fileFotoCatasto());
				theModel.setWidg_fileFotoCatastoContentType(mimeType);
				if (GenericUtil.isNullOrEmpty(mimeType)) {
					out = false;
				}

				if (!out) {
					result.getGlobalErrors().add("Il formato del file non e' corretto");
				}
			} else {
				result.getGlobalErrors().add(
						"Il caricamento non e' andato a buon fine, e' necessario rinominare il file senza indicare caratteri speciali");
				out = false;
			}

		} else {
			result.getGlobalErrors().add("E' necessario selezionare una foto");
			out = false;
		}

		if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoFileName())) {
			if (theModel.getWidg_fileFotoCatasto().length() > Constants.IMAGE_SIZE) {
				result.getGlobalErrors()
						.add("La dimensione della foto e' troppo elevata. La dimensione massima e' di 500Kb");
				out = false;
			}
			// patch per aggirare l'eccezione scatenata da index che in ricerca non è case sensitive, ma in inserimento si
			// a regime non sarà più utile
			if (theModel.getWidg_fileFotoCatastoFileName()
					.equalsIgnoreCase(att.getDatiAnagraficiImm().getDtCatastali().getNomeFoto())) {
				result.getGlobalErrors()
						.add("Esiste gia' una foto con questo nome. Rinominarla per inserirla/sostituirla");
				out = false;
			}
			ArrayList<DtFoto> dtFotoList = att.getDatiAnagraficiImm().getDtCatastali().getDtFoto();
			for (DtFoto dtFoto : dtFotoList) {
				if (dtFoto.getNomeFoto().equalsIgnoreCase(theModel.getWidg_fileFotoCatastoFileName())) {
					result.getGlobalErrors()
							.add("Esiste gia' una foto con questo nome. Rinominarla per inserirla/sostituirla");
					out = false;
				}
			}

		}

		return out;

	}

	private boolean checkDatiFotoCaricaAltre(CpCompilazApeModel theModel, ExecResults result) {
		DatiAttestato att = theModel.getAppDatacertificato();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();

		boolean out = true;
		if (GenericUtil.isNullOrEmpty(theModel.getAppDatatipoFotoAltreSel())) {
			result.getGlobalErrors().add("E' necessario selezionare la tipologia della foto");
			out = false;
		} else {
			if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoAltreFileName())) {
				if (getMiscMgr().isFileNameValid(theModel.getWidg_fileFotoCatastoAltreFileName())) {

					String mimeType = getSOAIntegrationMgr()
							.checkMimeTypeImmagine(theModel.getWidg_fileFotoCatastoAltre());
					theModel.setWidg_fileFotoCatastoAltreContentType(mimeType);
					if (GenericUtil.isNullOrEmpty(mimeType)) {
						out = false;
					}

					if (!out) {
						result.getGlobalErrors().add("Il formato del file non e' corretto");
					}
				} else {
					result.getGlobalErrors().add(
							"Il caricamento non e' andato a buon fine, e' necessario rinominare il file senza indicare caratteri speciali");
					out = false;
				}

			} else {
				result.getGlobalErrors().add("E' necessario selezionare una foto");
				out = false;
			}
		}

		if (!GenericUtil.isNullOrEmpty(theModel.getWidg_fileFotoCatastoAltreFileName())) {
			if (theModel.getWidg_fileFotoCatastoAltre().length() > Constants.IMAGE_SIZE) {
				result.getGlobalErrors()
						.add("La dimensione della foto e' troppo elevata. La dimensione massima e' di 500Kb");
				out = false;
			}
			// patch per aggirare l'eccezione scatenata da index che in ricerca non è case sensitive, ma in inserimento si
			// a regime non sarà più utile
			if (theModel.getWidg_fileFotoCatastoAltreFileName()
					.equalsIgnoreCase(att.getDatiAnagraficiImm().getDtCatastali().getNomeFoto())) {
				result.getGlobalErrors()
						.add("Esiste gia' una foto con questo nome. Rinominarla per inserirla/sostituirla");
				out = false;
			}
			ArrayList<DtFoto> dtFotoList = att.getDatiAnagraficiImm().getDtCatastali().getDtFoto();
			for (DtFoto dtFoto : dtFotoList) {
				if (dtFoto.getNomeFoto().equalsIgnoreCase(theModel.getWidg_fileFotoCatastoAltreFileName())) {
					result.getGlobalErrors()
							.add("Esiste gia' una foto con questo nome. Rinominarla per inserirla/sostituirla");
					out = false;
				}
			}

		}

		return out;

	}

	private Integer aggiornaFoto(CpCompilazApeModel theModel) throws FileNotFoundException, IOException, BEException {

		log.debug("[CPBECpCompilazApe::aggiornaFoto] BEGIN");
		DatiAttestato att = theModel.getAppDatacertificato();
		String uid = "";
		try {
			String nomeFoto = theModel.getWidg_fileFotoCatastoFileName().toLowerCase();
			String contentType = theModel.getWidg_fileFotoCatastoContentType().toLowerCase();
			log.debug("Nome file: " + nomeFoto);
			log.debug("Content Type: " + contentType);
			if (!GenericUtil.isNullOrEmpty(nomeFoto)) {

				log.debug("foto - passo 1");
				java.io.File file = theModel.getWidg_fileFotoCatasto();
				log.debug("foto - passo 2");

				byte[] bytes = getMiscMgr().readFile(file);

				log.debug("foto - passo 3");

				if (log.isDebugEnabled()) {

					log.debug("foto - passo 4");

					log.debug("STAMPO array di byte - inizio");

					//log.debug(bytes);

					log.debug("STAMPO array di byte - fine");
				}
				/*
				BufferedImage ioBf = null;
				log.debug("foto - passo 5");
				
				try {
					log.debug("foto - passo 6");
					ioBf = ImageIO.read(baFoto);
				} catch (Exception e) {
					// TODO: handle exception
					log.debug("Errore nella FOTO");
					return Constants.ERRORE_FOTO;
				}
				
				log.debug("foto - passo 7");
				 */

				ByteArrayInputStream baFoto = new ByteArrayInputStream(bytes);
				try {
					log.debug("inizio");
					JimiReader createJimiReader = Jimi.createJimiReader(baFoto);
					createJimiReader.getRasterImage();

					log.debug("fine jimi");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.debug("Errore nella FOTO");
					return Constants.ERRORE_FOTO;
				}

				// Faccio il resize della foto
				bytes = getMiscMgr().resizeFoto(bytes);

				// Riformatto il nome file
				int lastDot = nomeFoto.lastIndexOf(".");
				nomeFoto = nomeFoto.substring(0, lastDot);

				log.debug("nome NEW: " + nomeFoto);

				nomeFoto = "sipee_" + nomeFoto + ".jpg";

				uid = getSOAIntegrationMgr().salvaImmagine(theModel.getAppDatacertificatore(), att, bytes, nomeFoto,
						contentType, file.length());
				log.debug("foto - passo 8");

				if (uid == null) {
					log.debug("Errore nel caricamento della foto su INDEX");

					return Constants.ERRORE_INDEX;
				}

				att.getDatiAnagraficiImm().getDtCatastali().setUidFoto(uid);
				att.getDatiAnagraficiImm().getDtCatastali().setNomeFoto(nomeFoto);

				att.getDatiAnagraficiImm().getDtCatastali().setDataUpFoto(GenericUtil.getDataOdiernaCompleta());

				theModel.setAppDatacertificato(att);

			}
		} catch (BEException e) {
			throw e;
		} finally {
			log.debug("[CPBECpCompilazApe::aggiornaFoto] END");
		}

		// Se ritorno null vuol dire che il caricamento è andato a buon fine
		return null;
	}

	private Integer aggiornaFotoAltre(CpCompilazApeModel theModel)
			throws FileNotFoundException, IOException, BEException {

		log.debug("[CPBECpCompilazApe::aggiornaFotoAltre] BEGIN");
		DatiAttestato att = theModel.getAppDatacertificato();
		String uid = "";
		try {
			String nomeFoto = theModel.getWidg_fileFotoCatastoAltreFileName().toLowerCase();
			String contentType = theModel.getWidg_fileFotoCatastoAltreContentType().toLowerCase();
			int tipoFotoSel = theModel.getAppDatatipoFotoAltreSel();

			log.debug("Nome file: " + nomeFoto);
			log.debug("Content Type: " + contentType);
			if (!GenericUtil.isNullOrEmpty(nomeFoto)) {
				java.io.File file = theModel.getWidg_fileFotoCatastoAltre();
				byte[] bytes = getMiscMgr().readFile(file);

				log.debug("foto altre - passo 1");

				ByteArrayInputStream baFoto = new ByteArrayInputStream(bytes);

				log.debug("foto altre - passo 2");

				//BufferedImage ioBf = null;
				log.debug("foto altre - passo 3");
				try {
					log.debug("foto altre - passo 4");

					//ioBf = ImageIO.read(baFoto);

					log.debug("inizio");
					JimiReader createJimiReader = Jimi.createJimiReader(baFoto);
					createJimiReader.getRasterImage();

					log.debug("fine jimi");

				} catch (Exception e) {
					// TODO: handle exception
					log.debug("Errore nella FOTO");
					return Constants.ERRORE_FOTO;
				}

				// Faccio il resize della foto
				bytes = getMiscMgr().resizeFoto(bytes);

				// Riformatto il nome file
				int lastDot = nomeFoto.lastIndexOf(".");
				nomeFoto = nomeFoto.substring(0, lastDot);

				log.debug("nome NEW: " + nomeFoto);

				nomeFoto = "sipee_" + nomeFoto + ".jpg";

				log.debug("foto altre - passo 5");

				uid = getSOAIntegrationMgr().salvaImmagineSecondaria(theModel.getAppDatacertificatore(), att, bytes,
						nomeFoto, contentType, file.length());

				if (uid == null) {
					log.debug("Errore nel caricamento della foto su INDEX");

					return Constants.ERRORE_INDEX;
				}

				//ALEX ADV MOD START
				ArrayList<DtFoto> dtFotoList = att.getDatiAnagraficiImm().getDtCatastali().getDtFoto();
				DtFoto dtFoto = new DtFoto();
				// idFoto a -1 significa che è questo l'app data che dovrò inserire in db 
				dtFoto.setIdFoto(-1);
				dtFoto.setUidFoto(uid);
				dtFoto.setNomeFoto(nomeFoto);
				dtFoto.setFlgPrincipale("N");
				dtFoto.setDataUpFoto(GenericUtil.getDataOdiernaCompleta());
				dtFoto.setFkTipoFoto(tipoFotoSel);
				dtFotoList.add(dtFoto);
				att.getDatiAnagraficiImm().getDtCatastali().setDtFoto(dtFotoList);
				//ALEX ADV MOD END
				theModel.setAppDatacertificato(att);

			}
		} catch (BEException e) {
			throw e;
		} finally {
			log.debug("[CPBECpCompilazApe::aggiornaFotoAltre] END");
		}

		// Se ritorno null vuol dire che il caricamento è andato a buon fine
		return null;
	}

	public DatiAttestato completaDatiAttestato(DatiAttestato datiAttestato) throws BEException {
		log.debug("[CPBECpCompilazApe::completaDatiAttestato] BEGIN");

		try {

			if (datiAttestato != null) {

				// verifico i gradiGiorno e zonaClimatica
				if (GenericUtil.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getGradiGiorno())
						|| GenericUtil.isNullOrEmpty(
								datiAttestato.getDatiAnagraficiImm().getDtCatastali().getZonaClimatica())) {

					log.debug("######### DATO MANCANTE (gradiGiorno, zonaClimatica) ##########");
					log.debug("GradiGiorno (p): "
							+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getGradiGiorno());
					log.debug("ZonaClimatica (p): "
							+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getZonaClimatica());

					datiAttestato = getCertificatoMgr().recuperaGradiGiornoEZonaClimatica(datiAttestato);

					log.debug("GradiGiorno (d): "
							+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getGradiGiorno());
					log.debug("ZonaClimatica (d): "
							+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getZonaClimatica());

					log.debug("###################");

				}

				// verifico provincia e comune
				if (GenericUtil.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrProv())
						|| GenericUtil
								.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrComune())
						|| GenericUtil.isNullOrEmpty(
								datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodComuneCatasto())) {

					log.debug("######### DATO MANCANTE (prov, comune) ##########");

					if (!GenericUtil
							.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodComune())) {
						Comune comune = getSOAIntegrationMgr().getDescrizioneComune(
								datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodComune());

						log.debug("Stampo il comune: " + comune);

						if (GenericUtil
								.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrProv())) {
							log.debug("DescrProv (p): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrProv());

							datiAttestato.getDatiAnagraficiImm().getDtCatastali().setDescrProv(comune.getNomeProv());

							log.debug("DescrProv (d): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrProv());

						}

						if (GenericUtil
								.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodProv())) {
							log.debug("CodProv (p): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodProv());

							datiAttestato.getDatiAnagraficiImm().getDtCatastali().setCodProv(comune.getCodProv());

							log.debug("CodProv (d): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodProv());
						}

						if (GenericUtil.isNullOrEmpty(
								datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrComune())) {
							log.debug("DescrComune (p): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrComune());

							datiAttestato.getDatiAnagraficiImm().getDtCatastali().setDescrComune(comune.getNome());

							log.debug("DescrComune (d): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrComune());

						}

						if (GenericUtil.isNullOrEmpty(
								datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodComuneCatasto())) {
							log.debug("CodComuneCatasto (p): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodComuneCatasto());

							datiAttestato.getDatiAnagraficiImm().getDtCatastali()
									.setCodComuneCatasto(comune.getCodCatasto());

							log.debug("CodComuneCatasto (d): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodComuneCatasto());
						}
						log.error("###################");

					} else if (!GenericUtil
							.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodProv())) {
						log.error("######### DATO MANCANTE (prov) ##########");

						// E' un caso che si è verificato raramente e non recentemente, lo metto solo x sicurezza 

						Provincia provincia = getSOAIntegrationMgr().getDescrizioneProvincia(
								datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodProv());

						if (GenericUtil
								.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrProv())) {
							log.debug("DescrProv (p): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrProv());

							datiAttestato.getDatiAnagraficiImm().getDtCatastali().setDescrProv(provincia.getNome());

							log.debug("DescrProv (d): "
									+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrProv());
						}
						log.debug("###################");

					}
				}

				// verifico l'indirizzo (è presente l'id ma non la descrizione)
				if (!GenericUtil.isNullOrEmpty(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodIndirizzo())
						&& GenericUtil.isNullOrEmpty(
								datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrIndirizzo())) {

					log.debug("######### DATO MANCANTE (descrIndirizzo) ##########");
					log.debug("CodIndirizzo (p): "
							+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodIndirizzo());
					log.debug("DescrIndirizzo (p): "
							+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrIndirizzo());

					Indirizzo indirizzo = getSOAIntegrationMgr()
							.getIndirizzoById(datiAttestato.getDatiAnagraficiImm().getDtCatastali().getCodIndirizzo());

					log.debug("Stampo l'indirizzo: " + indirizzo);

					datiAttestato.getDatiAnagraficiImm().getDtCatastali().setDescrIndirizzo(indirizzo.getDescr());

					log.debug("DescrIndirizzo (d): "
							+ datiAttestato.getDatiAnagraficiImm().getDtCatastali().getDescrIndirizzo());

					log.debug("###################");

				}

			}

		} catch (BEException e) {
			throw e;
		} finally {
			log.debug("[CPBECpCompilazApe::completaDatiAttestato] END");
		}

		return datiAttestato;
	}

	public String recuperaDescIndirizzoTope(CpCompilazApeModel theModel) throws BEException {

		String descIndTope = null;
		ArrayList<Indirizzo> indirizzi = theModel.getAppDatasuggestIndirizzoDtCat();

		DtCatastali cat = theModel.getAppDatacertificato().getDatiAnagraficiImm().getDtCatastali();

		if (!GenericUtil.isNullOrEmpty(cat.getCodIndirizzo())) {
			for (Indirizzo indirizzo : indirizzi) {
				if (indirizzo.getCod().intValue() == cat.getCodIndirizzo().intValue()) {
					descIndTope = indirizzo.getDescr();
					break;
				}
			}
		}

		return descIndTope;

	}

	private boolean checkIsValidDataSopralluogo(UDTDateValid dataSopralluogo, ExecResults result) {

		boolean isValid = true;

		if (GenericUtil.isNullOrEmpty(dataSopralluogo)) {
			addMissingRequiredFieldError("appDatacertificato.altreInfo.sopralluoghi.data", result);
			isValid = false;
		} else {
			String[] dataNascita = dataSopralluogo.getValue().split("/");
			Calendar calDN = Calendar.getInstance();
			calDN.set(Integer.parseInt(dataNascita[2]), Integer.parseInt(dataNascita[1]) - 1,
					Integer.parseInt(dataNascita[0]));
			Calendar tomorrow = Calendar.getInstance(Locale.ITALY);
			tomorrow.add(Calendar.DATE, 1);
			tomorrow.set(Calendar.HOUR_OF_DAY, 0);
			tomorrow.set(Calendar.MINUTE, 0);
			tomorrow.set(Calendar.SECOND, 0);
			tomorrow.set(Calendar.MILLISECOND, 0);
			if (calDN.getTimeInMillis() > tomorrow.getTimeInMillis()) {
				result.getGlobalErrors().add(Messages.ERROR_DATA_SOPRALLUOGO_NON_VALIDA);
				isValid = false;
			}
		}

		return isValid;

	}

	/*PROTECTED REGION END*/
}
