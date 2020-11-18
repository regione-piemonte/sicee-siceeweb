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

/*PROTECTED REGION ID(R-1698407593) ENABLED START*/
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneAceMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneCreditoMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneRegistrazMgr;
import it.csi.sicee.siceeweb.dto.transazioni.Transazione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018;
/*PROTECTED REGION END*/

public class CPBECpTransaz {

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

	// ApplicationData: [transazioneAce, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEACE_CODE = "appDatatransazioneAce";

	// ApplicationData: [transazioneRegistrazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEREGISTRAZIONE_CODE = "appDatatransazioneRegistrazione";

	// ApplicationData: [idTransazione, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONE_CODE = "appDataidTransazione";

	// ApplicationData: [transazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONE_CODE = "appDatatransazione";

	// ApplicationData: [transazioneCredito, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONECREDITO_CODE = "appDatatransazioneCredito";

	// ApplicationData: [gestioneCreditoNew, scope:USER_SESSION]
	public static final String APPDATA_GESTIONECREDITONEW_CODE = "appDatagestioneCreditoNew";

	// ApplicationData: [datiPagamentoNew, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTONEW_CODE = "appDatadatiPagamentoNew";

	// ApplicationData: [codRicercaTransazioniNewSelez, scope:USER_SESSION]
	public static final String APPDATA_CODRICERCATRANSAZIONINEWSELEZ_CODE = "appDatacodRicercaTransazioniNewSelez";

	// ApplicationData: [tipoRicercaTransazioniNew, scope:USER_SESSION]
	public static final String APPDATA_TIPORICERCATRANSAZIONINEW_CODE = "appDatatipoRicercaTransazioniNew";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpTransaz";

	public static final String WIZARD_PWIZTRANSAZ = "pWizTransaz";
	public static final String STEP_PWIZTRANSAZ_PREGISTRAZCERT = CPNAME + "_" + WIZARD_PWIZTRANSAZ + "_"
			+ "pRegistrazCert";
	public static final String STEP_PWIZTRANSAZ_PACQUISTOACE = CPNAME + "_" + WIZARD_PWIZTRANSAZ + "_" + "pAcquistoAce";
	public static final String STEP_PWIZTRANSAZ_PACQUISTOCREDITI = CPNAME + "_" + WIZARD_PWIZTRANSAZ + "_"
			+ "pAcquistoCrediti";

	public static final String MULTIPANEL_MPGENERAAPE = "mpGeneraApe";
	public static final String MPI_MPGENERAAPE_FPGENERAAPE = CPNAME + "_" + MULTIPANEL_MPGENERAAPE + "_"
			+ "fpGeneraApe";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaRicevutaReg definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults stampaRicevutaReg(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPARICEVUTAREG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPARICEVUTAREG_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R668085251) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Long idTransazione = theModel.getAppDataidTransazione();
			if (idTransazione != null) {
				result.setResultCode(STAMPARICEVUTAREG_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("E' necessario selezionare un transazione");
				result.setResultCode(STAMPARICEVUTAREG_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaRicevutaReg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaRicevutaAce definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults stampaRicevutaAce(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPARICEVUTAACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPARICEVUTAACE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-727185036) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Long idTransazione = theModel.getAppDataidTransazione();
			if (idTransazione != null) {
				result.setResultCode(STAMPARICEVUTAACE_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("E' necessario selezionare un transazione");
				result.setResultCode(STAMPARICEVUTAACE_OUTCOME_CODE__KO);
			}
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaRicevutaAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricaricaTransazioniCredito definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults ricaricaTransazioniCredito(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICARICATRANSAZIONICREDITO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2080647686) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Ricarico la tabella
			gestisciTransazioneCredito(theModel);

			// impostazione del result code 
			result.setResultCode(RICARICATRANSAZIONICREDITO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricaricaTransazioniCredito] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricaricaCredito definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults ricaricaCredito(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICARICACREDITO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-169931384) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RICARICACREDITO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricaricaCredito] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioRicarica definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults dettaglioRicarica(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIORICARICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DETTAGLIORICARICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1087136863) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(DETTAGLIORICARICA_OUTCOME_CODE__KO);

			Long idTransazione = theModel.getAppDataidTransazione();

			if (idTransazione != null) {

				// recupero la ricarica selezionata
				SiceeTCredito2018 siceeTCredito2018 = getTransazioneCreditoMgr().getCreditoById(idTransazione);

				if (siceeTCredito2018.getFkTipoOp2018().intValue() != Constants.ID_TIPO_OP_RICARICA) {
					result.getGlobalErrors().add("La transazione selezionata non e' una ricarica");
				} else {
					DatiPagamentoNew datiPag = getTransazioneCreditoMgr()
							.getTransazioneById(siceeTCredito2018.getFkTransazione2018());

					theModel.setAppDatadatiPagamentoNew(datiPag);

					// impostazione del result code 
					result.setResultCode(DETTAGLIORICARICA_OUTCOME_CODE__OK);
				}
			} else {
				result.getGlobalErrors().add("E' necessario selezionare una ricarica");
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dettaglioRicarica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciGeneraApe definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults gestisciGeneraApe(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIGENERAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIGENERAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2145481967) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Float creditoDisp = theModel.getAppDatagestioneCreditoNew().getCreditoDisponibile();

			GestioneCreditoNew gestCredito = theModel.getAppDatagestioneCreditoNew();

			if (log.isDebugEnabled()) {
				log.debug("[CPBECpTransaz::gestisciGeneraApe] - creditoDisp: " + creditoDisp);
				log.debug("[CPBECpTransaz::gestisciGeneraApe] - gestCredito.getImportoApe(): "
						+ gestCredito.getImportoApe());
			}

			if (creditoDisp != null && creditoDisp.doubleValue() >= gestCredito.getImportoApe().doubleValue()) {

				// Pulisto la quantità di APE
				gestCredito.setNumeroApe(null);

				// impostazione del result code 
				result.setResultCode(GESTISCIGENERAAPE_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add(GenericUtil.formattaMessaggio(Messages.ERROR_CREDITO_INSUFFICIENTE,
						BaseMgr.convertToString(creditoDisp), BaseMgr.convertToString(gestCredito.getImportoApe())));

				// impostazione del result code 
				result.setResultCode(GESTISCIGENERAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciGeneraApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pagaIscrAnnuale definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults pagaIscrAnnuale(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PAGAISCRANNUALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PAGAISCRANNUALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R425161682) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiCertificatore cert = theModel.getAppDatacertificatore();

			GestioneCreditoNew gestCredito = theModel.getAppDatagestioneCreditoNew();

			// impostazione del result code 
			result.setResultCode(PAGAISCRANNUALE_OUTCOME_CODE__KO);

			if (cert.getStato() == Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO
					|| cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA
					|| cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO) {

				DatiCertificatore certificatore = theModel.getAppDatacertificatore();

				Double creditoDisp = getTransazioneCreditoMgr()
						.getCreditoDisponibile(certificatore.getIdCertificatore());

				// Devor recuperare nuovamente il credito per essere sicuro che possa pagare la registrazione

				//@fra@mad prova --> problema di aggiornamento, in alcuni casi, del gestione credito dalla sessione
				gestisciTransazioneCredito(theModel);
				//@fra@mad prova fine

				if (creditoDisp == null
						|| creditoDisp.doubleValue() < gestCredito.getImportoRegistrazione().doubleValue()) {

					result.getGlobalErrors()
							.add(GenericUtil.formattaMessaggio(Messages.ERROR_CREDITO_INSUFFICIENTE,
									BaseMgr.convertToString(creditoDisp),
									BaseMgr.convertToString(gestCredito.getImportoRegistrazione())));

				} else {

					// puo' pagare l'iscrizione annuale

					getCertificatoreMgr().completaRegistrazioneNew(cert, gestCredito);

					cert = getCertificatoreMgr().loadCertifcatoreByCF(theModel.getAppDatacurrentUser().getCodFisc());

					cert.setFlgAggDati(true);

					getCertificatoreMgr().aggiornaCertificatoreFlgDati(cert.getIdCertificatore());

					theModel.setAppDatacertificatore(cert);

					//					theModel.setAppDatamsgEsitoTransazione("La registrazione all&rsquo;elenco regionale &egrave; avvenuta con successo. Il suo N. di iscrizione &egrave; il seguente: "
					//							+ cert.getNumCertificatore());

					// Ricarico la tabella
					gestisciTransazioneCredito(theModel);

					if (cert.getFlgCompetenzeNaz()) {
						result.getGlobalMessages()
								.add(Constants.MSG_OK_REGISTRAZ_NAZ + "\"" + cert.getNumCertificatore() + "\"");
					} else {
						result.getGlobalMessages()
								.add(Constants.MSG_OK_REGISTRAZ_REG + "\"" + cert.getNumCertificatore() + "\"");
					}

					// impostazione del result code 
					result.setResultCode(PAGAISCRANNUALE_OUTCOME_CODE__OK);
				}

			} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO) {
				// non deve pagare l'iscrizione annuale

				result.getGlobalErrors().add(Messages.ERROR_ISCRIZIONE_ANNUALE_NON_NEC);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pagaIscrAnnuale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo listaAttesaRT definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults listaAttesaRT(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LISTAATTESART_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-943419683) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(LISTAATTESART_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::listaAttesaRT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo generaApe definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults generaApe(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GENERAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GENERAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R195895778) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//@fra@mad prova --> problema di aggiornamento, in alcuni casi, del gestione credito dalla sessione
			gestisciTransazioneCredito(theModel);
			//@fra@mad prova fine

			GestioneCreditoNew gestCredito = theModel.getAppDatagestioneCreditoNew();

			// impostazione del result code 
			result.setResultCode(GENERAAPE_OUTCOME_CODE__KO);

			if (GenericUtil.isNullOrEmpty(gestCredito.getNumeroApe())) {
				result.getFldErrors().put("appDatagestioneCreditoNew.numeroApe", "il campo e' obbligatorio");

			} else {
				if (!GenericUtil.isNumero(gestCredito.getNumeroApe())) {
					result.getFldErrors().put("appDatagestioneCreditoNew.numeroApe", "il campo deve essere un numero");

				} else {
					DatiCertificatore certificatore = theModel.getAppDatacertificatore();

					Double creditoDisp = getTransazioneCreditoMgr()
							.getCreditoDisponibile(certificatore.getIdCertificatore());

					// Devor ecuperare nuovamente il credito per essere sicuro che possa generare APE

					int numApe = Converter.convertToInteger(gestCredito.getNumeroApe());

					Double impTot = gestCredito.getImportoApe().doubleValue() * numApe;

					if (creditoDisp == null || creditoDisp.doubleValue() < impTot.doubleValue()) {

						result.getGlobalErrors().add(GenericUtil.formattaMessaggio(Messages.ERROR_CREDITO_INSUFFICIENTE,
								BaseMgr.convertToString(creditoDisp), BaseMgr.convertToString(impTot)));

					} else {

						getCertificatoMgr().generaACE(certificatore.getIdCertificatore(), gestCredito);

						// Ricarico la tabella
						gestisciTransazioneCredito(theModel);

						result.getGlobalMessages().add(
								"La prenotazione di attestati di prestazione energetica &egrave; avvenuto con successo.");

						// impostazione del result code 
						result.setResultCode(GENERAAPE_OUTCOME_CODE__OK);

					}
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::generaApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaTransazioni definito in un ExecCommand del
	 * ContentPanel cpTransaz
	 */
	public ExecResults initListaTransazioni(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTATRANSAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1292928117) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			ArrayList<TransazioneAce> listAce = getTransazioneAceMgr().getTransazioni(certificatore);

			ArrayList<TransazioneRegistrazione> listReg = getTransazioneRegistrazioneMgr()
					.getTransazioni(certificatore);

			GestioneCreditoNew credito = new GestioneCreditoNew();
			Double prezzoAce = getMiscMgr().getPrezzoAce();
			Double prezzoRegistrazione = getMiscMgr().getPrezzoRegistrazione();
			credito.setImportoApe(prezzoAce.floatValue());
			credito.setImportoRegistrazione(prezzoRegistrazione.floatValue());

			theModel.setAppDatagestioneCreditoNew(credito);

			theModel.setAppDatatransazioneAce(listAce);
			theModel.setAppDatatransazioneRegistrazione(listReg);

			// Setto il default
			theModel.setAppDatacodRicercaTransazioniNewSelez(Constants.COD_TIPO_RICERCA_PARZ);
			// Carico la combo
			theModel.setAppDatatipoRicercaTransazioniNew(GenericUtil.getComboTipoRicerca());

			gestisciTransazioneCredito(theModel);

			/*
			ArrayList<TransazioneCredito> listCredito = getTransazioneCreditoMgr()
					.getTransazioni(certificatore);
			
			log.debug("Numero Transazioni ACE: " + listAce.size());
			log.debug("Numero Transazioni Registrazione: " + listReg.size());
			log.debug("Numero Transazioni Credito: " + listCredito.size());
			
			theModel.setAppDatatransazioneCredito(listCredito);
			
			GestioneCreditoNew credito = new GestioneCreditoNew();
			if (listCredito != null && listCredito.size() > 0) {
				// Recupero il credito disponibile, e' il valore dell'elemtno 0
				credito.setCreditoDisponibile(listCredito.get(0)
						.getValoreCreditoFinale());
			}
			
			Double prezzoAce = getMiscMgr().getPrezzoAce();
			Double prezzoRegistrazione = getMiscMgr().getPrezzoRegistrazione();
			credito.setImportoApe(prezzoAce.floatValue());
			credito.setImportoRegistrazione(prezzoRegistrazione.floatValue());
			
			theModel.setAppDatagestioneCreditoNew(credito);
			 */

			// impostazione del result code
			result.setResultCode(INITLISTATRANSAZIONI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaTransazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_transReg
	 */
	public static void resetClearStatus_widg_transReg(java.util.Map session) {
		session.put("cpTransaz_transReg_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_transAce
	 */
	public static void resetClearStatus_widg_transAce(java.util.Map session) {
		session.put("cpTransaz_transAce_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_transCredito
	 */
	public static void resetClearStatus_widg_transCredito(java.util.Map session) {
		session.put("cpTransaz_transCredito_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1592106185) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private TransazioneAceMgr transazioneAceMgr = null;
	private TransazioneRegistrazMgr transazioneRegistrazioneMgr = null;
	private TransazioneCreditoMgr transazioneCreditoMgr = null;

	public TransazioneAceMgr getTransazioneAceMgr() {
		return transazioneAceMgr;
	}

	public void setTransazioneAceMgr(TransazioneAceMgr transazioneAceMgr) {
		this.transazioneAceMgr = transazioneAceMgr;
	}

	public TransazioneRegistrazMgr getTransazioneRegistrazioneMgr() {
		return transazioneRegistrazioneMgr;
	}

	public void setTransazioneRegistrazioneMgr(TransazioneRegistrazMgr transazioneRegistrazioneMgr) {
		this.transazioneRegistrazioneMgr = transazioneRegistrazioneMgr;
	}

	public TransazioneCreditoMgr getTransazioneCreditoMgr() {
		return transazioneCreditoMgr;
	}

	public void setTransazioneCreditoMgr(TransazioneCreditoMgr transazioneCreditoMgr) {
		this.transazioneCreditoMgr = transazioneCreditoMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private CertificatoMgr certificatoMgr = null;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private void gestisciTransazioneCredito(it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel)
			throws Exception {
		try {
			DatiCertificatore certificatore = theModel.getAppDatacertificatore();

			String codTipoRic = theModel.getAppDatacodRicercaTransazioniNewSelez();

			ArrayList<TransazioneCredito> listCredito = getTransazioneCreditoMgr().getTransazioni(certificatore,
					codTipoRic);

			log.debug("Numero Transazioni Credito: " + listCredito.size());

			theModel.setAppDatatransazioneCredito(listCredito);

			GestioneCreditoNew credito = theModel.getAppDatagestioneCreditoNew();

			if (listCredito != null && listCredito.size() > 0) {
				// Recupero il credito disponibile, e' il valore dell'elemento 0
				credito.setCreditoDisponibile(listCredito.get(0).getValoreCreditoFinale());
			}

			theModel.setAppDatagestioneCreditoNew(credito);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/*PROTECTED REGION END*/
}
