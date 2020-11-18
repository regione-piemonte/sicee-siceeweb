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

/*PROTECTED REGION ID(R-125022501) ENABLED START*/
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCertificatoModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;

import org.springframework.transaction.UnexpectedRollbackException;

import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
/*PROTECTED REGION END*/

public class CPBECpGestInvioCertificato {

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

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [dichiarazioneAceSostitutivo, scope:USER_SESSION]
	public static final String APPDATA_DICHIARAZIONEACESOSTITUTIVO_CODE = "appDatadichiarazioneAceSostitutivo";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	// ApplicationData: [carrelloAceNew, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACENEW_CODE = "appDatacarrelloAceNew";

	// ApplicationData: [carrelloAceOld, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACEOLD_CODE = "appDatacarrelloAceOld";

	// ApplicationData: [certificatiTrovati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATITROVATI_CODE = "appDatacertificatiTrovati";

	// ApplicationData: [codiciCertificatiSelezionati, scope:USER_SESSION]
	public static final String APPDATA_CODICICERTIFICATISELEZIONATI_CODE = "appDatacodiciCertificatiSelezionati";

	// ApplicationData: [datiAnnullamento, scope:USER_SESSION]
	public static final String APPDATA_DATIANNULLAMENTO_CODE = "appDatadatiAnnullamento";

	// ApplicationData: [idTipoRicAnnullametoSost, scope:USER_SESSION]
	public static final String APPDATA_IDTIPORICANNULLAMETOSOST_CODE = "appDataidTipoRicAnnullametoSost";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestInvioCertificato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo invioAttestato definito in un ExecCommand del
	 * ContentPanel cpGestInvioCertificato
	 */
	public ExecResults invioAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCertificatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIOATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INVIOATTESTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String INVIOATTESTATO_OUTCOME_CODE__KO_CHECK = //NOSONAR  Reason:EIAS
				"KO_CHECK"; //NOSONAR  Reason:EIAS
		final String INVIOATTESTATO_OUTCOME_CODE__OK_SOSTITUZIONE = //NOSONAR  Reason:EIAS
				"OK_SOSTITUZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R315915616) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DatiCertificatore cert = theModel.getAppDatacertificatore();

			log.debug("@@PROVA STAMPA DATI: " + cert.getNumCertificatore());
			log.debug("@@PROVA STAMPA FILE: " + theModel.getWidg_fileAttestato());

			// PROVA HASH - INIZIO
			/*
			try {
				File file1 = theModel.getWidg_fileAttestato();
			
				FileInputStream fin = new FileInputStream(file1);
			
				byte fileContent[] = new byte[(int) file1.length()];
				fin.read(fileContent);
			
				//FileOutputStream fos = null;
				//fos = new FileOutputStream(file1);
			
				//InputStream filestream = new FileInputStream(file1);
			
				//byte[] fileInBytes = ByteStreams.toByteArray(filestream);
			
				//fos.write(fileContent);
				//fos.close();
				log.debug("#### STAMPO L'HASH (file orig): "
						+ certificatoMgr.getAshFile(theModel
								.getWidg_fileAttestato()));
				String hashFile1 = certificatoMgr.getHashFile(fileContent);
				log.debug("#### STAMPO IL NOME (file nome): "
						+ theModel.getWidg_fileAttestatoFileName());
				log.debug("#### STAMPO L'HASH (file mod): " + hashFile1);
			} catch (Exception ex) {
				log.error(ex);
			}
			 */
			// PROVA HASH - FINE

			boolean ok = checkInvioDocumento(theModel, result);
			Documento docInviato = new Documento();
			DatiAttestato att = null;

			//@@SETTEMBRE 2015 INIZIO
			// 1)Spacchetto il file richiamando il servizio dell'orcghestratore
			//2)recupero ash dal file spacchettato
			//3)leggo sul db ash tramite chiave attestato metterlo nel certificato manager
			//
			String hashFile = null;
			if (ok) {
				//Spacchetto il documento richiamando il servizio PA/PD
				docInviato = estraiDocumento(theModel);
				//Se lo spacchettamento è andato a buon fine controllo l'ash
				if (docInviato != null) {
					if (docInviato.getDoc() != null && docInviato.getDoc().length > 0) {
						File file = new File(theModel.getWidg_fileAttestatoFileName());

						//File file = theModel.getWidg_fileAttestato();

						FileOutputStream fos = null;
						fos = new FileOutputStream(file);
						fos.write(docInviato.getDoc());
						fos.close();
						hashFile = certificatoMgr.getAshFile(file);
						file.delete();
						//Leggo dal database l'ash salvato in precedenza
						att = theModel.getAppDatacertificato();

						String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(),
								att.getNumeroAttestato());

						String id = split[Constants.PK_ID_CERTIFICATORE];
						String prog = split[Constants.PK_PROGR];
						String anno = split[Constants.PK_ANNO];

						SiceeTRifIndex2015 daoAsh = getCertificatoMgr().recuperaRifIndex2015(id, prog, anno,
								Constants.ID_PDF_APE_CONSOLIDATO);

						String ashDB = null;

						if (daoAsh != null) {
							ashDB = daoAsh.getHash();
							log.debug("ASH TROVATO (DB)=" + ashDB);

						}
						if (hashFile != null && ashDB != null) {
							if (hashFile.trim().equals(ashDB.trim())) {
								ok = true;
								result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__OK);
							} else {
								log.debug(
										"Attenzione: il documento che si sta cercando di inviare e' diverso da quello consolidato");
								ok = false;
								result.getGlobalErrors().add(
										"Attenzione: il documento che si sta cercando di inviare e' diverso da quello consolidato");
								result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);
							}
						} else {
							log.debug("Attenzione: errore di sistema hash non recuperato.");
							ok = false;
							result.getGlobalErrors().add("Attenzione: errore di sistema hash non recuperato.");
							result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);
						}
					} else {
						log.debug("Attenzione. Errore, il file sbustato e' vuoto.");
						ok = false;
						result.getGlobalErrors().add("Attenzione. Errore, il file sbustato e' vuoto.");
						result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);
					}
				} else {
					log.debug("Attenzione. Errore nella ricezione/sbustamento del file.");
					ok = false;
					result.getGlobalErrors().add("Attenzione. Errore nella ricezione/sbustamento del file.");
					result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);
				}
			}
			//@@SETTEMBRE 2015 FINE

			// impostazione del result code
			if (ok) {
				try {
					ArrayList<String> r = (ArrayList<String>) invioDocumento(theModel, hashFile);

					if (r != null && r.size() > 1) {
						for (int i = 1; i < r.size(); i++) {
							result.getGlobalErrors().add(r.get(i));
						}

						result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);

					} else {
						if (BaseMgr.convertToBoolean(theModel.getAppDatadichiarazioneAceSostitutivo())) {
							result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__OK_SOSTITUZIONE);
						} else {
							result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__OK);
						}
					}

				} catch (UnexpectedRollbackException uex) {
					log.error(uex);
					result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);
					result.getGlobalErrors().add("UnexpectedRollbackException !!!!!");
					result.setModel(theModel);
					return result;
				} catch (Exception e) {
					log.error("[CPBECpGestInvioCert::invioAttestato] Errore occorso nell'esecuzione del metodo:" + e,
							e);
					log.error(e.getMessage());
					result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO);
					if (e.getMessage() != null && e.getMessage().equals(Constants.ERROR_CODE_INDEX)) {
						result.getGlobalErrors().add(
								"Attenzione. il servizio non e' momentaneamente disponibile si prega di riprovare piu' tardi");
					} else if (e.getMessage() != null && e.getMessage().equals(Constants.ERROR_CODE_FIRMA_CERT)) {
						result.getGlobalErrors()
								.add("Attenzione. Il certificato non risulta firmato dal certificatore: "
										+ cert.getDtAnag().getNome() + " " + cert.getDtAnag().getCognome() + " "
										+ cert.getDtAnag().getCodFisc());
					} else if (e.getMessage() != null && e.getMessage().equals(Constants.ERROR_CODE_FIRMA_COCERT)) {
						result.getGlobalErrors()
								.add("Attenzione. Il certificato non risulta firmato dal co-certificatore:  "
										+ att.getDatiAnagraficiImm().getDtCoCertificatore().getNome() + " "
										+ att.getDatiAnagraficiImm().getDtCoCertificatore().getCognome() + " "
										+ att.getDatiAnagraficiImm().getDtCoCertificatore().getCodFisc());
					} else {
						result.getGlobalErrors()
								.add("Attenzione. si e' verificato un problema nell'invio del documento.");
					}
					result.setModel(theModel);
					return result;
				}
			} else {
				result.setResultCode(INVIOATTESTATO_OUTCOME_CODE__KO_CHECK);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::invioAttestato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroInvioCert definito in un ExecCommand del
	 * ContentPanel cpGestInvioCertificato
	 */
	public ExecResults indietroInvioCert(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCertificatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETROINVIOCERT_OUTCOME_CODE__ELENCOAPE = //NOSONAR  Reason:EIAS
				"ElencoAPE"; //NOSONAR  Reason:EIAS
		final String INDIETROINVIOCERT_OUTCOME_CODE__COMPILAZIONE = //NOSONAR  Reason:EIAS
				"Compilazione"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2054356205) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDataprovenienzaPerReport().equalsIgnoreCase(INDIETROINVIOCERT_OUTCOME_CODE__ELENCOAPE))
				result.setResultCode(INDIETROINVIOCERT_OUTCOME_CODE__ELENCOAPE);
			else
				result.setResultCode(INDIETROINVIOCERT_OUTCOME_CODE__COMPILAZIONE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroInvioCert] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R945182009) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private boolean checkInvioDocumento(CpGestInvioCertificatoModel theModel, ExecResults result) {

		boolean out = true;
		String fileName = theModel.getWidg_fileAttestatoFileName();
		log.debug("Nome file attestato firmato: -" + fileName + "-");
		if (fileName != null) {
			if (getMiscMgr().isFileNameValid(fileName)) {
				String param = getMiscMgr().getParametroCertificatiAmmessi();
				String[] ends = param.split(",");
				out = false;
				for (int i = 0; i < ends.length; i++) {
					if (fileName.toLowerCase().endsWith(ends[i])) {
						out = true;
						break;
					}
				}

				if (out && fileName.toLowerCase().indexOf(Constants.ACTA_ESTENSIONE_FILE_AMMESSA) <= 0) {
					// Vuol dire che l'estensione NON rispetta l'estensione accettata da ACTA
					out = false;
				}

				if (!out) {
					result.getGlobalErrors().add("Il formato o il nome del file non e' corretto");
				}
			} else {
				result.getGlobalErrors().add(
						"Il caricamento non e' andato a buon fine, e' necessario rinominare il file senza indicare caratteri speciali");
				out = false;
			}
		} else {
			result.getGlobalErrors().add("E' necessario selezionare un documento A.P.E. firmato digitalmente.");
			out = false;
		}

		if (BaseMgr.isNullOrEmpty(theModel.getAppDatadichiarazioneAceSostitutivo())) {
			result.getGlobalErrors().add("E' necessario dichiarare se l'A.P.E. e' un sostituto.");
			out = false;
		}

		/*
		// Alex 29/09/2015
		String estensione = fileName.substring(fileName.length() - 3);
		if (!estensione.equalsIgnoreCase("p7m")) {
			result.getGlobalErrors().add("Il formato del file non e' corretto");
			out = false;
		}
		 */

		String date = null;
		if ((date = getCertificatoMgr().checkStatoInviato(theModel.getAppDatacertificatore(),
				theModel.getAppDatacertificato())) != null) {
			result.getGlobalErrors()
					.add("La data di invio non puo' essere anteriore alla data di dichiarazione (" + date + ")");
			out = false;
		}

		return out;
	}

	/*	private void addMissingRequiredFieldError(String fname, ExecResults r) {
	 r.getFldErrors().put("" + fname, "e' obbligatorio");
	 }*/

	private List<String> invioDocumento(CpGestInvioCertificatoModel theModel, String hashFile)
			throws FileNotFoundException, IOException, BEException {

		log.debug("[CPBECpGestInvioCertificato::invioDocumento] BEGIN");
		DatiAttestato att = theModel.getAppDatacertificato();
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		ArrayList<String> result = null;
		try {

			String nomeAttestato = theModel.getWidg_fileAttestatoFileName();
			String contentType = theModel.getWidg_fileAttestatoContentType();

			if (log.isDebugEnabled()) {
				log.debug("Nome file: " + nomeAttestato);
				log.debug("Content Type: " + contentType);
			}

			if (!GenericUtil.isNullOrEmpty(nomeAttestato)) {
				java.io.File file = theModel.getWidg_fileAttestato();

				if (log.isDebugEnabled())
					log.debug("file len: " + file.length());

				InputStream is = new FileInputStream(file);

				long length = file.length();
				if (length > Integer.MAX_VALUE) {
					log.error("File is too large");
				}

				byte[] bytes = new byte[(int) length];

				is.read(bytes);

				is.close();

				result = (ArrayList<String>) getSOAIntegrationMgr().salvaVerificaAttestato(cert, att, bytes,
						nomeAttestato, contentType, length);

				if (result != null && result.size() == 1) {
					int stato = 0;
					if (BaseMgr.convertToBoolean(theModel.getAppDatadichiarazioneAceSostitutivo())) {
						stato = Constants.DA_INVIARE;
					} else {
						stato = Constants.INVIATO;
					}
					getCertificatoMgr().aggiornaStatoInviato(cert, att, result.get(0), nomeAttestato, hashFile, stato);
				}

			}
			return result;
		} catch (BEException e) {
			log.error("Errore", e);
			throw e;
		} finally {
			log.debug("[CPBECpGestInvioCertificato::invioDocumento] END");
		}
	}

	//@@SETTEMBRE 2015 INIZIO
	private Documento estraiDocumento(CpGestInvioCertificatoModel theModel)
			throws FileNotFoundException, IOException, BEException {

		log.debug("[CPBECpGestInvioCertificato::estraiDocumento] BEGIN");
		DatiAttestato att = theModel.getAppDatacertificato();
		DatiCertificatore cert = theModel.getAppDatacertificatore();
		ArrayList<String> result = null;
		try {

			String nomeAttestato = theModel.getWidg_fileAttestatoFileName();
			String contentType = theModel.getWidg_fileAttestatoContentType();
			Documento retValue = new Documento();

			if (log.isDebugEnabled()) {
				log.debug("Nome file: " + nomeAttestato);
				log.debug("Content Type: " + contentType);
			}

			if (!GenericUtil.isNullOrEmpty(nomeAttestato)) {
				java.io.File file = theModel.getWidg_fileAttestato();
				InputStream is = new FileInputStream(file);
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				int nRead;
				long length = file.length();

				if (log.isDebugEnabled())
					log.debug("*** Lenght file: " + length);

				//Metto il file in un array di byte
				if (length > Integer.MAX_VALUE) {
					log.error("File is too large");
				}
				byte[] bytes = new byte[(int) length];
				is.read(bytes);
				is.close();

				/*
				while ((nRead = is.read(bytes, 0, bytes.length)) != -1) {
				  buffer.write(bytes, 0, nRead);
				}
				
				buffer.flush();
				
				byte[] retBytes = buffer.toByteArray();
				 */

				//Richiamo il servizio di spacchettamento documento
				Documento docEstratto = null;
				try {
					docEstratto = getSOAIntegrationMgr().estraiDocumento(cert, att, bytes, nomeAttestato, contentType,
							length);

				} catch (Exception e) {
					// Non devo fae niente, l'importante che nel caso di errore nello sbustamento il documento ritornato sia null
					retValue = null;
				}

				if (docEstratto != null) {
					byte[] fileVerificato = docEstratto.getDoc();
					if (fileVerificato != null && fileVerificato.length > 0) {
						retValue = docEstratto;
					}
				}

			}
			return retValue;
		} catch (Exception e) {
			log.error("Errore", e);
			throw new BEException(e.getMessage(), e);
		} finally {
			log.debug("[CPBECpGestInvioCertificato::estraiDocumento] END");
		}
	}
	//@@SETTEMBRE 2015 FINE

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

	/*PROTECTED REGION END*/
}
