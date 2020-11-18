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

/*PROTECTED REGION ID(R639441296) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;

/*PROTECTED REGION END*/

public class CPBECpGestCertificazioni {

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

	// ApplicationData: [attestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_ATTESTATOSELEZIONATO_CODE = "appDataattestatoSelezionato";

	// ApplicationData: [chiaviAttestati, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTESTATI_CODE = "appDatachiaviAttestati";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [tempRaccomandazioni, scope:USER_SESSION]
	public static final String APPDATA_TEMPRACCOMANDAZIONI_CODE = "appDatatempRaccomandazioni";

	// ApplicationData: [tempDichiarazSelez, scope:USER_SESSION]
	public static final String APPDATA_TEMPDICHIARAZSELEZ_CODE = "appDatatempDichiarazSelez";

	// ApplicationData: [isImportaDati, scope:USER_SESSION]
	public static final String APPDATA_ISIMPORTADATI_CODE = "appDataisImportaDati";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [tempDtCatastaliSecondari, scope:USER_SESSION]
	public static final String APPDATA_TEMPDTCATASTALISECONDARI_CODE = "appDatatempDtCatastaliSecondari";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	// ApplicationData: [dichiarazioneAceSostitutivo, scope:USER_SESSION]
	public static final String APPDATA_DICHIARAZIONEACESOSTITUTIVO_CODE = "appDatadichiarazioneAceSostitutivo";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [idRigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDRIGASELEZIONATA_CODE = "appDataidRigaSelezionata";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestCertificazioni";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaScaricoModulo definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO = //NOSONAR  Reason:EIAS
				"ATTESTATO"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA = //NOSONAR  Reason:EIAS
				"RICEVUTA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1117221820) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDatacodAttestatoDaStampare(theModel.getIdRiga());
			// impostazione del result code

			if (theModel.getIdColonna().equals("flgScarico"))
				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO);
			else if (theModel.getIdColonna().equals("flgRicevuta"))
				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA);
			else
				result.setResultCode("OK");
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaScaricoModulo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaImportaXml definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaImportaXml(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAIMPORTAXML_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAIMPORTAXML_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1981914767) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {

				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				att.setNumeroAttestato(numeroCertificato);
				log.debug("Attestato selezionato: " + numeroCertificato);
				log.debug("Status: " + att.getStatus());
				if ((att.getStatus().equals(Constants.NUOVO)) || (att.getStatus().equals(Constants.BOZZA))) {
					theModel.setAppDataisImportaDati(false);
					theModel.setAppDatacertificato(att);
					result.setResultCode(PREPARAIMPORTAXML_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("E' necessario selezionare un A.P.E. in stato NUOVO oppure BOZZA");
					result.setResultCode(PREPARAIMPORTAXML_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidRigaSelezionata(null);
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(PREPARAIMPORTAXML_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaImportaXml] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaReConsolidaAPE definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaReConsolidaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARARECONSOLIDAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARARECONSOLIDAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1177106617) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {
				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);
				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				String[] split = numeroCertificato.split(" ");
				split[1] = cert.getIdCertificatore();
				String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
				String progrCertificato = split[Constants.PK_PROGR];
				String anno = split[Constants.PK_ANNO];

				if (log.isDebugEnabled()) {
					log.debug("Attestato selezionato: " + numeroCertificato);
					log.debug("Status: " + att.getStatus());
					log.debug("idCertificatore: " + idCertificatore);
					log.debug("progrCertificato: " + progrCertificato);
					log.debug("anno: " + anno);
				}

				if (att.getStatus().equals(Constants.DA_INVIARE)) {
					result.setResultCode(PREPARARECONSOLIDAAPE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors()
							.add("E' necessario selezionare un A.P.E. in stato DA INVIARE PER SOSTITUZIONE");
					result.setResultCode(PREPARARECONSOLIDAAPE_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidRigaSelezionata(null);
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(PREPARARECONSOLIDAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaReConsolidaAPE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaReInizializzaAPE definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaReInizializzaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAREINIZIALIZZAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAREINIZIALIZZAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R38859639) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {
				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				String[] split = numeroCertificato.split(" ");
				split[1] = cert.getIdCertificatore();
				String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
				String progrCertificato = split[Constants.PK_PROGR];
				String anno = split[Constants.PK_ANNO];

				if (log.isDebugEnabled()) {
					log.debug("Attestato selezionato: " + numeroCertificato);
					log.debug("Status: " + att.getStatus());
					log.debug("idCertificatore: " + idCertificatore);
					log.debug("progrCertificato: " + progrCertificato);
					log.debug("anno: " + anno);
				}

				if ((att.getStatus().equals(Constants.BOZZA)) || (att.getStatus().equals(Constants.NUOVO))
						|| (att.getStatus().equals(Constants.CONSOLIDATO))) {
					result.setResultCode(PREPARAREINIZIALIZZAAPE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors()
							.add("E' necessario selezionare un A.P.E. in stato BOZZA, NUOVO o CONSOLIDATO");
					result.setResultCode(PREPARAREINIZIALIZZAAPE_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(PREPARAREINIZIALIZZAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaReInizializzaAPE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaEditAttestatoOld definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaEditAttestatoOld(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAEDITATTESTATOOLD_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAEDITATTESTATOOLD_OUTCOME_CODE__OK_OLD = //NOSONAR  Reason:EIAS
				"OK_OLD"; //NOSONAR  Reason:EIAS
		final String PREPARAEDITATTESTATOOLD_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1512216592) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {

				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiCertificatore cert = theModel.getAppDatacertificatore();

				DatiAttestato att = theModel.getAppDatacertificato();

				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				if (log.isDebugEnabled())
					GenericUtil.stampa(att, true, 3);

				att.setNumeroAttestato(numeroCertificato);

				theModel.setAppDatatempDichiarazSelez(att.getDichiarazioni().getCodDichiaraz());

				theModel.setAppDatacertificato(att);

				if (att.getFlgOldApe()) {
					theModel.setAppDatatempDtCatastaliSecondari(
							att.getDatiAnagraficiImm().getDtCatastali().getDtCatastaliSecondari());

					if (log.isDebugEnabled()) {
						log.debug("##########################################");
						log.debug("HO RECUPERATO I DATI CATASTALI SECONDARI: "
								+ theModel.getAppDatatempDtCatastaliSecondari());

						log.debug("HO RECUPERATO I DATI CATASTALI SECONDARI - lunghezza: "
								+ theModel.getAppDatatempDtCatastaliSecondari().size());
					}

					ArrayList<DtCatastaliSecondari> temp = theModel.getAppDatatempDtCatastaliSecondari();
					for (int i = 0; i < temp.size(); i++) {

						DtCatastaliSecondari sing = temp.get(i);

						if (log.isDebugEnabled()) {
							log.debug("sing.getId(): " + sing.getId());
							log.debug("sing.getCodProv(): " + sing.getCodProv());
							log.debug("sing.getCodComune(): " + sing.getCodComune());
							log.debug("sing.getSezione(): " + sing.getSezione());
							log.debug("sing.getFoglio(): " + sing.getFoglio());
							log.debug("sing.getParticella(): " + sing.getParticella());
							log.debug("sing.getSubalterno(): " + sing.getSubalterno());
							log.debug("##########################################");

							log.debug("@@@@@ RECUPERO COORD NORD: "
									+ att.getDatiAnagraficiImm().getDtCatastali().getCoordN());
							log.debug("@@@@@ RECUPERO COORD EST: "
									+ att.getDatiAnagraficiImm().getDtCatastali().getCoordE());
						}

					}

					theModel.setAppDatatempRaccomandazioni((ArrayList<Raccomandazione>) getCertificatoMgr()
							.recuperaRaccomandazioni(cert, numeroCertificato));

					// impostazione del result code
					theModel.getSession().remove("cpCompilaz_pWizCompilazLiv1_selectedMultiPanel");
					theModel.getSession().remove("cpCompilaz_pWizAnagImmobile_selectedMultiPanel");

					result.setResultCode(PREPARAEDITATTESTATOOLD_OUTCOME_CODE__OK_OLD);

				} else {

					result.setResultCode(PREPARAEDITATTESTATOOLD_OUTCOME_CODE__OK);

				}

				theModel.setAppDataprovenienzaPerReport("Compilazione");

			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(PREPARAEDITATTESTATOOLD_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaEditAttestatoOld] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaEditAttestato definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaEditAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAEDITATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAEDITATTESTATO_OUTCOME_CODE__OK_IMPORT = //NOSONAR  Reason:EIAS
				"OK_IMPORT"; //NOSONAR  Reason:EIAS
		final String PREPARAEDITATTESTATO_OUTCOME_CODE__OK_OLD = //NOSONAR  Reason:EIAS
				"OK_OLD"; //NOSONAR  Reason:EIAS
		final String PREPARAEDITATTESTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1431947233) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {

				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiCertificatore cert = theModel.getAppDatacertificatore();

				DatiAttestato att = theModel.getAppDatacertificato();

				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				if (log.isDebugEnabled())
					GenericUtil.stampa(att, true, 3);

				att.setNumeroAttestato(numeroCertificato);

				theModel.setAppDatatempDichiarazSelez(att.getDichiarazioni().getCodDichiaraz());

				theModel.setAppDatacertificato(att);

				if (att.getFlgOldApe()) {
					theModel.setAppDatatempDtCatastaliSecondari(
							att.getDatiAnagraficiImm().getDtCatastali().getDtCatastaliSecondari());

					if (log.isDebugEnabled()) {
						log.debug("##########################################");
						log.debug("HO RECUPERATO I DATI CATASTALI SECONDARI: "
								+ theModel.getAppDatatempDtCatastaliSecondari());

						log.debug("HO RECUPERATO I DATI CATASTALI SECONDARI - lunghezza: "
								+ theModel.getAppDatatempDtCatastaliSecondari().size());
					}

					ArrayList<DtCatastaliSecondari> temp = theModel.getAppDatatempDtCatastaliSecondari();
					for (int i = 0; i < temp.size(); i++) {

						DtCatastaliSecondari sing = temp.get(i);

						if (log.isDebugEnabled()) {
							log.debug("sing.getId(): " + sing.getId());
							log.debug("sing.getCodProv(): " + sing.getCodProv());
							log.debug("sing.getCodComune(): " + sing.getCodComune());
							log.debug("sing.getSezione(): " + sing.getSezione());
							log.debug("sing.getFoglio(): " + sing.getFoglio());
							log.debug("sing.getParticella(): " + sing.getParticella());
							log.debug("sing.getSubalterno(): " + sing.getSubalterno());
							log.debug("##########################################");

							log.debug("@@@@@ RECUPERO COORD NORD: "
									+ att.getDatiAnagraficiImm().getDtCatastali().getCoordN());
							log.debug("@@@@@ RECUPERO COORD EST: "
									+ att.getDatiAnagraficiImm().getDtCatastali().getCoordE());
						}

					}

					theModel.setAppDatatempRaccomandazioni((ArrayList<Raccomandazione>) getCertificatoMgr()
							.recuperaRaccomandazioni(cert, numeroCertificato));

					// impostazione del result code
					theModel.getSession().remove("cpCompilaz_pWizCompilazLiv1_selectedMultiPanel");
					theModel.getSession().remove("cpCompilaz_pWizAnagImmobile_selectedMultiPanel");

					result.setResultCode(PREPARAEDITATTESTATO_OUTCOME_CODE__OK_OLD);

				} else {

					if (att.getStatus() == Constants.NUOVO) {
						result.setResultCode(PREPARAEDITATTESTATO_OUTCOME_CODE__OK_IMPORT);
						theModel.setAppDataisImportaDati(false);

					} else {
						result.setResultCode(PREPARAEDITATTESTATO_OUTCOME_CODE__OK);
					}

				}

				theModel.setAppDataprovenienzaPerReport("Compilazione");

			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(PREPARAEDITATTESTATO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaEditAttestato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo invioCertificato definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults invioCertificato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIOCERTIFICATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INVIOCERTIFICATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R251759905) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {

				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);

				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				att.setNumeroAttestato(numeroCertificato);

				theModel.setAppDatatempDichiarazSelez(att.getDichiarazioni().getCodDichiaraz());
				theModel.setAppDatacertificato(att);
				theModel.setAppDatacodAttestatoDaStampare(numeroCertificato);

				if (att.getStatus() == Constants.CONSOLIDATO) {
					result.setResultCode(INVIOCERTIFICATO_OUTCOME_CODE__OK);

					theModel.setAppDataprovenienzaPerReport("ElencoAPE");
				} else {
					result.getGlobalErrors().add("E' necessario selezionare un A.P.E. in stato CONSOLIDATO");

					result.setResultCode(INVIOCERTIFICATO_OUTCOME_CODE__KO);
				}
				// impostazione del result code

			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(INVIOCERTIFICATO_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

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
	 * Implementazione del metodo stampaAce definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults stampaAce(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPAACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPAACE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-946620472) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();
			theModel.setAppDatacodAttestatoDaStampare(numeroCertificato);
			// impostazione del result code
			if (numeroCertificato != null) {
				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);
				result.setResultCode(STAMPAACE_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(STAMPAACE_OUTCOME_CODE__KO);
				result.setModel(theModel);
				return result;
			}

			//getAppDatacertificato(), getAppDatacertificatore()

			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			DatiAttestato attestatoSelezionato = getCertificatoMgr().recuperaAttestato(certificatore,
					numeroCertificato);

			attestatoSelezionato.setNumeroAttestato(numeroCertificato);

			if (log.isDebugEnabled()) {
				log.debug("################## ACTION");
				log.debug("Stampo il numero certificato: " + numeroCertificato);
				log.debug("Stampo l'attestato trovato: " + attestatoSelezionato);

				GenericUtil.stampa(attestatoSelezionato, true, 3);

				log.debug("##################");
			}

			Integer statoAttestato = attestatoSelezionato.getStatus();

			theModel.setAppDatacertificato(attestatoSelezionato);

			if (statoAttestato == null) {
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E. in stato CONSOLIDATO o SOSTITUTIVO");
				result.setResultCode(STAMPAACE_OUTCOME_CODE__KO);
			} else if (statoAttestato != Constants.CONSOLIDATO && statoAttestato != Constants.DA_INVIARE) {
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E. in stato CONSOLIDATO o SOSTITUTIVO");
				result.setResultCode(STAMPAACE_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaReport definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPAREPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPAREPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-912381415) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idRigaTabella = theModel.getAppDataidRigaSelezionata();

			log.debug("stampaReport - Stampo idRigaTabella: " + idRigaTabella);
			log.debug("stampaReport - Stampo getAppDatachiaviAttestati: " + theModel.getAppDatachiaviAttestati());

			String numeroCertificato = GenericUtil.getAttestatoByIdRiga(idRigaTabella,
					theModel.getAppDatachiaviAttestati());

			//String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			theModel.setAppDatacodAttestatoDaStampare(numeroCertificato);
			// impostazione del result code
			if (numeroCertificato != null) {
				theModel.setAppDatacodAttestatoSelezionato(numeroCertificato);
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDataidRigaSelezionata(null);

				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__KO);
				result.setModel(theModel);
				return result;
			}

			DatiCertificatore certificatore = theModel.getAppDatacertificatore();
			DatiAttestato attestatoSelezionato = getCertificatoMgr().recuperaAttestato(certificatore,
					numeroCertificato);
			Integer statoAttestato = attestatoSelezionato.getStatus();
			if (statoAttestato == null) {
				result.getGlobalErrors().add("Non e' possibile stampare il report per un A.P.E. in stato NUOVO");
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__KO);
			} else if (statoAttestato != Constants.CONSOLIDATO && statoAttestato != Constants.DA_INVIARE) {
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E. in stato CONSOLIDATO o SOSTITUTIVO");
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			theModel.setAppDataprovenienzaPerReport("Compilazione");
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaReport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaVisuraCIT definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaVisuraCIT(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAVISURACIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1714297756) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(PREPARAVISURACIT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaVisuraCIT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo reInizializzaAPE definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults reInizializzaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String REINIZIALIZZAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String REINIZIALIZZAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1886221736) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {
				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				String[] split = numeroCertificato.split(" ");
				split[1] = cert.getIdCertificatore();
				String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
				String progrCertificato = split[Constants.PK_PROGR];
				String anno = split[Constants.PK_ANNO];

				if (log.isDebugEnabled()) {
					log.debug("Attestato selezionato: " + numeroCertificato);
					log.debug("Status: " + att.getStatus());
					log.debug("idCertificatore: " + idCertificatore);
					log.debug("progrCertificato: " + progrCertificato);
					log.debug("anno: " + anno);
				}

				DatiCertificatore certificatore = theModel.getAppDatacertificatore();

				// JIRA
				if ((att.getStatus().equals(Constants.BOZZA)) || (att.getStatus().equals(Constants.NUOVO))
						|| (att.getStatus().equals(Constants.CONSOLIDATO))) {

					getCertificatoMgr().reInitApe(idCertificatore, progrCertificato, anno);

					theModel.setAppDatachiaviAttestati(
							(ArrayList<AttestatoSummary>) getCertificatoMgr().getCertificati(certificatore));

					result.getGlobalMessages().add("Il cambio stato e' stato effettuato correttamente.");

					theModel.setAppDatamsgGenerico("Il cambio stato e' stato effettuato correttamente.");

					result.setResultCode(REINIZIALIZZAAPE_OUTCOME_CODE__OK);
				} else {

					theModel.setAppDatachiaviAttestati(
							(ArrayList<AttestatoSummary>) getCertificatoMgr().getCertificati(certificatore));

					result.getGlobalErrors()
							.add("E' necessario selezionare un A.P.E. in stato BOZZA, NUOVO o CONSOLIDATO");
					result.setResultCode(REINIZIALIZZAAPE_OUTCOME_CODE__KO);
				}
			} else {
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(REINIZIALIZZAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::reInizializzaAPE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo reConsolidaAPE definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults reConsolidaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECONSOLIDAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RECONSOLIDAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-688581670) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {
				DatiCertificatore cert = theModel.getAppDatacertificatore();
				DatiAttestato att = theModel.getAppDatacertificato();
				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				DatiCertificatore certificatore = theModel.getAppDatacertificatore();

				// JIRA
				if (att.getStatus().equals(Constants.DA_INVIARE)) {

					String[] split = numeroCertificato.split(" ");
					split[1] = cert.getIdCertificatore();
					String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
					String progrCertificato = split[Constants.PK_PROGR];
					String anno = split[Constants.PK_ANNO];

					if (log.isDebugEnabled()) {
						log.debug("Attestato selezionato: " + numeroCertificato);
						log.debug("Status: " + att.getStatus());
						log.debug("idCertificatore: " + idCertificatore);
						log.debug("progrCertificato: " + progrCertificato);
						log.debug("anno: " + anno);
					}

					getCertificatoMgr().reInitConsolidaApe(idCertificatore, progrCertificato, anno);

					theModel.setAppDatachiaviAttestati(
							(ArrayList<AttestatoSummary>) getCertificatoMgr().getCertificati(certificatore));

					result.getGlobalMessages().add("Il cambio stato e' stato effettuato correttamente.");

					theModel.setAppDatamsgGenerico("Il cambio stato e' stato effettuato correttamente.");

					result.setResultCode(RECONSOLIDAAPE_OUTCOME_CODE__OK);
				} else {

					theModel.setAppDatachiaviAttestati(
							(ArrayList<AttestatoSummary>) getCertificatoMgr().getCertificati(certificatore));

					result.getGlobalErrors()
							.add("E' necessario selezionare un A.P.E. in stato DA INVIARE PER SOSTITUZIONE");
					result.setResultCode(RECONSOLIDAAPE_OUTCOME_CODE__KO);
				}
			} else {
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(RECONSOLIDAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::reConsolidaAPE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaAttestati definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults initListaAttestati(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTAATTESTATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1401538573) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			theModel.setAppDatachiaviAttestati(
					(ArrayList<AttestatoSummary>) getCertificatoMgr().getCertificati(certificatore));

			if (theModel.getAppDatamsgGenerico() != null) {
				result.getGlobalMessages().add(theModel.getAppDatamsgGenerico());
				theModel.setAppDatamsgGenerico(null);
			}

			// impostazione del result code
			result.setResultCode(INITLISTAATTESTATI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaAttestati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo switchPulsanteScaricaMod definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults switchPulsanteScaricaMod(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHPULSANTESCARICAMOD_OUTCOME_CODE__MOSTRA_MOD = //NOSONAR  Reason:EIAS
				"MOSTRA_MOD"; //NOSONAR  Reason:EIAS
		final String SWITCHPULSANTESCARICAMOD_OUTCOME_CODE__NASCONDI_MOD = //NOSONAR  Reason:EIAS
				"NASCONDI_MOD"; //NOSONAR  Reason:EIAS
		final String SWITCHPULSANTESCARICAMOD_OUTCOME_CODE__NASCONDI_IMPORT = //NOSONAR  Reason:EIAS
				"NASCONDI_IMPORT"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-547207663) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatachiaviAttestati() != null && theModel.getAppDatachiaviAttestati().size() > 0) {
				if (getMiscMgr().getParametroImportXml()) {
					result.setResultCode(SWITCHPULSANTESCARICAMOD_OUTCOME_CODE__MOSTRA_MOD);
				} else {
					result.setResultCode(SWITCHPULSANTESCARICAMOD_OUTCOME_CODE__NASCONDI_IMPORT);
				}

			} else {
				result.setResultCode(SWITCHPULSANTESCARICAMOD_OUTCOME_CODE__NASCONDI_MOD);
			}
			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::switchPulsanteScaricaMod] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpGestCertificazioni
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1085713835) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatamsgGenerico() != null) {
				result.getGlobalMessages().add(theModel.getAppDatamsgGenerico());
				theModel.setAppDatamsgGenerico(null);
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
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttestati
	 */
	public static void resetClearStatus_widg_tblAttestati(java.util.Map session) {
		session.put("cpGestCertificazioni_tblAttestati_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R22190884) ENABLED START*/
	// // inserire qui le property che si vogliono iniettare in questo bean (es.
	// dao, proxy di pd, ...)
	private CertificatoMgr certificatoMgr = null;

	public void setCertificatoMgr(CertificatoMgr cm) {
		certificatoMgr = cm;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	/*PROTECTED REGION END*/
}
