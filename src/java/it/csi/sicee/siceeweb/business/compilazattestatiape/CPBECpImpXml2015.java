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

/*PROTECTED REGION ID(R-1592731657) ENABLED START*/
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeLHashXmlImport;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.print.dto.DatiGenericiDto;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;
import it.csi.sicee.siceeweb.xml.xmlapecompleto2015.data.DocumentoDocument;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

//import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.struts2.ServletActionContext;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.util.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiReader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.stream.Collectors;

/*PROTECTED REGION END*/

public class CPBECpImpXml2015 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [isImportaDati, scope:USER_SESSION]
	public static final String APPDATA_ISIMPORTADATI_CODE = "appDataisImportaDati";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [tempDichiarazSelez, scope:USER_SESSION]
	public static final String APPDATA_TEMPDICHIARAZSELEZ_CODE = "appDatatempDichiarazSelez";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [idComuneZonaClima, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNEZONACLIMA_CODE = "appDataidComuneZonaClima";

	// ApplicationData: [listZoneClima, scope:USER_SESSION]
	public static final String APPDATA_LISTZONECLIMA_CODE = "appDatalistZoneClima";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpImpXml2015";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaXmlReadOnly definito in un ExecCommand del
	 * ContentPanel cpImpXml2015
	 */
	public ExecResults caricaXmlReadOnly(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAXMLREADONLY_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICAXMLREADONLY_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String CARICAXMLREADONLY_OUTCOME_CODE__OK_OLD = //NOSONAR  Reason:EIAS
				"OK_OLD"; //NOSONAR  Reason:EIAS
		final String CARICAXMLREADONLY_OUTCOME_CODE__OK_ZONA_CLIMA = //NOSONAR  Reason:EIAS
				"OK_ZONA_CLIMA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1522063602) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			 * Conformità XML/XSD
			 * Lettura file e salvataggio nel DB (tabella: xxx ; campo clob: xxx)
			 * Salvataggio di un sottinsieme di informazioni nel DB
			 * Creazione del file XML (derivato da struttura XSD della Taccetti)
			 * Salvataggio nel DB del nuovo file XML popolato a partire dal primo (tabella: SICEE_T_CERT_XML_2015 ; campo clob: XML_ALLEGATO)
			 */

			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiAttestato att = theModel.getAppDatacertificato();
			theModel.setAppDatalistZoneClima(null);

			String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), att.getNumeroAttestato());

			String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			//			ServletContext sc = ServletActionContext.getServletContext();
			//			//log.debug("### sc: " + sc);
			//			InputStream is = sc.getResourceAsStream("/template/classeG.png");

			//log.debug("### is: " + is);

			if (log.isDebugEnabled()) {
				log.debug("\n\ncaricaXml");
				log.debug("\nidCertificatore: " + idCertificatore);
				log.debug("\nprogrCertificato: " + progrCertificato);
				log.debug("\nanno: " + anno);
				log.debug("file name " + theModel.getWidg_fileCaricaFileName());
				log.debug("file ContentType " + theModel.getWidg_fileCaricaContentType());

				log.debug("File: " + theModel.getWidg_fileCarica());
			}

			String retval = null;
			if (theModel.getWidg_fileCaricaFileName() == null) {
				retval = "Selezionare un file XML valido secondo lo schema XSD";
			} else {
				retval = parseAndImportXmlFileReadOnly(theModel.getWidg_fileCarica(),
						theModel.getWidg_fileCaricaFileName(), theModel.getWidg_fileCaricaContentType(), att, cert,
						idCertificatore, progrCertificato, anno, theModel);
			}

			if (retval == null) {
				result.getGlobalMessages().add(Constants.OK_DESC_IMPXML);

				theModel.setAppDatamsgGenerico(Constants.OK_DESC_IMPXML);

				String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				att.setNumeroAttestato(numeroCertificato);

				theModel.setAppDatatempDichiarazSelez(att.getDichiarazioni().getCodDichiaraz());

				// BEPPE
				//att.get
				//theModel.setappdataCodDichiarazioneSet();
				theModel.setAppDatacertificato(att);
				theModel.setAppDataprovenienzaPerReport("Compilazione");
				if (theModel.getAppDatalistZoneClima() != null)
					result.setResultCode(CARICAXMLREADONLY_OUTCOME_CODE__OK_ZONA_CLIMA);
				else
					result.setResultCode(CARICAXMLREADONLY_OUTCOME_CODE__OK);
				// impostazione del result code 
			} else {
				result.getGlobalErrors().add(retval);
				// impostazione del result code 
				result.setResultCode(CARICAXMLREADONLY_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaXmlReadOnly] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaXml definito in un ExecCommand del
	 * ContentPanel cpImpXml2015
	 */
	public ExecResults caricaXml(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAXML_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICAXML_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2038808656) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			 * Conformità XML/XSD
			 * Lettura file e salvataggio nel DB (tabella: xxx ; campo clob: xxx)
			 * Salvataggio di un sottinsieme di informazioni nel DB
			 * Creazione del file XML (derivato da struttura XSD della Taccetti)
			 * Salvataggio nel DB del nuovo file XML popolato a partire dal primo (tabella: SICEE_T_CERT_XML_2015 ; campo clob: XML_ALLEGATO)
			 */

			DatiCertificatore cert = theModel.getAppDatacertificatore();
			DatiAttestato att = theModel.getAppDatacertificato();

			String[] split = BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(), att.getNumeroAttestato());

			String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			if (log.isDebugEnabled()) {
				log.debug("\n\ncaricaXml");
				log.debug("\nidCertificatore: " + idCertificatore);
				log.debug("\nprogrCertificato: " + progrCertificato);
				log.debug("\nanno: " + anno);
				log.debug("file name " + theModel.getWidg_fileCaricaFileName());
				log.debug("file ContentType " + theModel.getWidg_fileCaricaContentType());

				log.debug("File: " + theModel.getWidg_fileCarica());
			}

			String retval = null;
			if (theModel.getWidg_fileCaricaFileName() == null) {
				retval = "Selezionare un file XML valido secondo lo schema XSD";
			} else {
				//				retval = parseAndImportXmlFile(theModel.getWidg_fileCarica(),
				//						theModel.getWidg_fileCaricaFileName(),
				//						theModel.getWidg_fileCaricaContentType(), att, cert,
				//						idCertificatore, progrCertificato, anno);
			}

			if (retval == null) {
				result.getGlobalMessages().add(Constants.OK_DESC_IMPXML);
				// impostazione del result code 
				result.setResultCode(CARICAXML_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add(retval);
				// impostazione del result code 
				result.setResultCode(CARICAXML_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaXml] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaEditAttestato definito in un ExecCommand del
	 * ContentPanel cpImpXml2015
	 */
	public ExecResults preparaEditAttestato(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAEDITATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAEDITATTESTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1723763226) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String numeroCertificato = theModel.getAppDatacodAttestatoSelezionato();

			if (numeroCertificato != null) {
				DatiCertificatore cert = theModel.getAppDatacertificatore();

				DatiAttestato att = theModel.getAppDatacertificato();

				att = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);

				att.setNumeroAttestato(numeroCertificato);

				theModel.setAppDatatempDichiarazSelez(att.getDichiarazioni().getCodDichiaraz());

				// BEPPE
				//att.get
				//theModel.setappdataCodDichiarazioneSet();

				theModel.setAppDatacertificato(att);

				result.setResultCode(PREPARAEDITATTESTATO_OUTCOME_CODE__OK);

				theModel.setAppDataprovenienzaPerReport("Compilazione");

			} else {
				result.getGlobalErrors().add("E' necessario selezionare un A.P.E.");
				result.setResultCode(PREPARAEDITATTESTATO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo switchScreenState definito in un ExecCommand del
	 * ContentPanel cpImpXml2015
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SWITCHSCREENSTATE_OUTCOME_CODE__CARICA_XML = //NOSONAR  Reason:EIAS
				"CARICA_XML"; //NOSONAR  Reason:EIAS
		final String SWITCHSCREENSTATE_OUTCOME_CODE__PROSEGUI = //NOSONAR  Reason:EIAS
				"PROSEGUI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R550609315) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (!theModel.getAppDataisImportaDati()) {
				theModel.setAppDataisImportaDati(true);
				result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__CARICA_XML);
			} else {
				result.setResultCode(SWITCHSCREENSTATE_OUTCOME_CODE__PROSEGUI);
			}
			// impostazione del result code

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2083458467) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private CertificatoMgr certificatoMgr = null;
	private SOAIntegrationMgr soaIntegrationMgr;
	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}
	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}
	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	private String gestisciErroValidazioneXml(DatiAttestato att, DatiCertificatore cert, File f, List<String> listError,
			int numValidazione, boolean sendUtente) throws Exception {
		String motivazioneErrore = null;

		if (!BaseMgr.isNullOrEmpty(listError)) {
			getMiscMgr().sendMailPerXmlNew(att, cert, f, listError, numValidazione, sendUtente);
			motivazioneErrore = "Il file selezionato non e' in un formato valido o non contiene un XML valido secondo lo schema XSD.";
			motivazioneErrore = motivazioneErrore + "<BR>";
			motivazioneErrore = motivazioneErrore
					+ "Un'e-mail contenente gli errori e' stata inviata all'indirizzo indicato in dati di registrazione.";

		} else if (listError == null) {
			listError = new ArrayList<String>();
			listError.add(
					"Non e' stato possibile determinare l'errore specifico; E' necessario verificare il file: probabilmente e' stato inviato un file in un formato non XML");
			getMiscMgr().sendMailPerXmlNew(att, cert, f, listError, numValidazione, sendUtente);
			motivazioneErrore = "Il file selezionato non e' in un formato valido o non contiene un XML valido secondo lo schema XSD.";
			motivazioneErrore = motivazioneErrore + "<BR>";
			motivazioneErrore = motivazioneErrore
					+ "Un'e-mail contenente gli errori e' stata inviata all'indirizzo indicato in dati di registrazione.";

		}

		return motivazioneErrore;
	}

	private String parseAndImportXmlFileReadOnly(File f, String fileName, String contentType, DatiAttestato att,
			DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno,
			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel) {

		log.debug("\n\n\n >>>>>>> parseAndImportXmlFileReadOnly");

		//String errorTag = null;
		//String errorMessage = null;
		try {
			theModel.setAppDatapaginaProvenienza("COMPILAZIONE");

			// Devo verificare l'hash del file
			// ATTENZIONE: per adesso è un tracciamento indormtivo, non viene bloccato,
			// in futuro dovremmo bloccare
			recuperaHashFile(idCertificatore, progrCertificato, anno, f);

			// validazione documento
			// se viene ritornato un messaggio di errore diverso da null viene lanciata
			// un'eccezione ad-hoc contenente la descrizione dell'errore che viene trappata
			// e rilanciata più in alto dove viene visualizzata
			String motivazioneErrore = null;
			try {
				// VALIDAZIONE-1 - questa validazione valida l'XML, è come i controlli effettuati con altri strumenti (è da mantenere!) - manda mail ad assistenza ed utente 
				List<String> listError = getMiscMgr().isFileXmlValidFileXml(f);

				if (!BaseMgr.isNullOrEmpty(listError) || listError == null) {
					motivazioneErrore = gestisciErroValidazioneXml(att, cert, f, listError, Constants.VALIDAZIONE_1,
							true);

					Exception e = new Exception();
					throw (e);
				}

			} catch (Exception e) {
				BEException bee = new BEException(motivazioneErrore, e);
				throw bee;
			}

			//boolean esitoValidazione;
			// recupero XML da file
			FileInputStream fileInputStream = null;
			byte[] xmlDoc = new byte[(int) f.length()];
			fileInputStream = new FileInputStream(f);
			fileInputStream.read(xmlDoc);
			fileInputStream.close();

			// recupero documento da XML
			// se viene ritornata un'eccezione generica nel processo di estrazione xml
			// o viene ritornato un documento nullo, viene lanciata un'eccezione ad-hoc 
			// contenente la descrizione dell'errore che viene trappata e rilanciata
			// più in alto dove viene visualizzata

			DocumentoDocument docXmlApeCompleto2015 = null;
			try {
				docXmlApeCompleto2015 = MapDto
						.mapImportToDocumentoDocument(XmlBeanUtils.readString(new String(xmlDoc)));

				if (docXmlApeCompleto2015 == null) {
					//log.debug("\n\n\n>>>>>>> RITORNA UN NULL !!!");
					Exception e = new Exception();
					throw (e);
				}
			} catch (Exception e) {
				// VALIDAZIONE-2 - questa eccezione potrebbe essere il BOM (è da mantenere!) - mandare mail ad assistenza 
				List<String> list = new ArrayList<String>();
				list.add(
						"Il file selezionato non e' in un formato valido o non contiene un XML valido secondo lo schema XSD");
				list.add("P.S. potrebbe essere il problema del BOM");
				getMiscMgr().sendMailPerXmlNew(att, cert, f, list, Constants.VALIDAZIONE_2, false);

				BEException bee = new BEException(
						"Il file selezionato non e' in un formato valido o non contiene un XML valido secondo lo schema XSD",
						e);
				throw bee;
			}

			// Create an XmlOptions instance and set the error listener.
			XmlOptions validateOptions = new XmlOptions();
			ArrayList errorList = new ArrayList();
			validateOptions.setErrorListener(errorList);

			// Validate the XML.
			// VALIDAZIONE-3 - questa validazione valida il documento rimappato (è da mantenere!) - mandare mail ad assistenza ed utente 
			boolean esitoValidazione = docXmlApeCompleto2015.validate(validateOptions);

			log.debug("\n>>>>>>> esito validazione documento: " + esitoValidazione);

			// If the XML isn't valid, loop through the listener's contents,
			// printing contained messages.

			if (!esitoValidazione) {
				log.error("################# INIZIO VALIDATION ERROR #####################");
				List<String> listError = new ArrayList<String>();
				for (int i = 0; i < errorList.size(); i++) {
					XmlError error = (XmlError) errorList.get(i);

					listError.add(error.getMessage());
					log.error("Message: " + error.getMessage());
					log.error("Location of invalid XML: " + error.getCursorLocation().xmlText());
				}

				log.error("################# FINE VALIDATION ERROR #####################");

				try {
					if (!BaseMgr.isNullOrEmpty(listError) || listError == null) {
						motivazioneErrore = gestisciErroValidazioneXml(att, cert, f, listError, Constants.VALIDAZIONE_3,
								true);

						Exception e = new Exception();
						throw (e);
					}

				} catch (Exception e) {
					BEException bee = new BEException(motivazioneErrore, e);
					throw bee;
				}

			}

			// creazione dell'oggetto Dati Generici e decodifiche del certificato
			DatiGenericiDto datiGenericiDto = new DatiGenericiDto();
			// popolamento con i dati del certificato
			SiceeTCertificato certificato = getCertificatoMgr().recuperaCertificato(idCertificatore, progrCertificato,
					anno);
			datiGenericiDto.setCertificato(certificato);
			// popolamento con i dati generali
			SiceeTDatiGenerali datiGenerali = getCertificatoMgr().recuperaDatiGenerali(idCertificatore,
					progrCertificato, anno);
			datiGenericiDto.setDatiGenerali(datiGenerali);
			// popolamento con le altre info
			SiceeTAltreInfo altreInfo = getCertificatoMgr().recuperaAltreInfo(idCertificatore, progrCertificato, anno);
			if (altreInfo == null) {
				altreInfo = new SiceeTAltreInfo();
				altreInfo.setIdCertificatore(idCertificatore);
				altreInfo.setProgrCertificato(progrCertificato);
				altreInfo.setAnno(anno);
			}
			datiGenericiDto.setAltreInfo(altreInfo);

			SiceeTDatiEner2015 datiEner2015 = getCertificatoMgr().recuperaDatiEner2015(idCertificatore,
					progrCertificato, anno);
			if (datiEner2015 == null) {
				datiEner2015 = new SiceeTDatiEner2015();
				datiEner2015.setIdCertificatore(idCertificatore);
				datiEner2015.setProgrCertificato(progrCertificato);
				datiEner2015.setAnno(anno);
			}
			datiGenericiDto.setDatiEner2015(datiEner2015);

			// creazione oggetti delle tabelle dati xml (se reimporto questi dati vengono riscritti)
			SiceeTDatiXml2015 datiXml2015 = new SiceeTDatiXml2015();
			datiXml2015.setIdCertificatore(idCertificatore);
			datiXml2015.setProgrCertificato(progrCertificato);
			datiXml2015.setAnno(anno);
			datiGenericiDto.setDatiXml2015(datiXml2015);
			SiceeTDatiXmlEdReale2015 datiXmlEdReale2015 = new SiceeTDatiXmlEdReale2015();
			datiXmlEdReale2015.setIdCertificatore(idCertificatore);
			datiXmlEdReale2015.setProgrCertificato(progrCertificato);
			datiXmlEdReale2015.setAnno(anno);
			datiGenericiDto.setDatiXmlEdReale2015(datiXmlEdReale2015);
			SiceeTDatiXmlEdRif2015 datiXmlEdRif2015 = new SiceeTDatiXmlEdRif2015();
			datiXmlEdRif2015.setIdCertificatore(idCertificatore);
			datiXmlEdRif2015.setProgrCertificato(progrCertificato);
			datiXmlEdRif2015.setAnno(anno);
			datiGenericiDto.setDatiXmlEdRif2015(datiXmlEdRif2015);

			// popolamento con decodifica destinazione d'uso
			Short codClassificazione = null;
			try {
				codClassificazione = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali()
						.getClassificazioneDPR412();
			} catch (Exception e) {
				codClassificazione = null;
			}
			SiceeDDestUso2015 destinazioneUso2015 = null;
			if (codClassificazione != null)
				destinazioneUso2015 = getCertificatoMgr().recuperaDDestUso2015(codClassificazione.intValue());
			datiGenericiDto.setDestinazioneUso2015(destinazioneUso2015);

			// popolamento con calcolo zona climatica, decodifica comune ed estrazione/decodifica provincia
			String istatComune = null;
			List<SiceeDGradiGiorno> zonaClimatica = null;
			Comune comune = null;
			String istatComuneCalc = null;
			boolean isProvPiemonte = false;

			try {
				istatComune = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali()
						.getDatiIdentificativi().getCodiceISTAT();

				List<Provincia> provincePiemonte = getSOAIntegrationMgr().getProvinceByPiemonte();

				comune = getSOAIntegrationMgr().getDescrizioneComune(istatComune);

				for (Provincia provincia : provincePiemonte) {
					if (comune.getCodProv().equalsIgnoreCase(provincia.getCod())) {
						isProvPiemonte = true;
					}
				}
				log.debug("ISTAT COMUNE: " + istatComune);
				log.debug("COMUNE: " + comune);
				zonaClimatica = getCertificatoMgr().getSiceeDGradiGiornoDao().findWhereIdComuneEquals(istatComune);

				datiGenericiDto.setComune(comune);

				if (zonaClimatica != null) {
					if (zonaClimatica.size() == 1) {
						datiGenericiDto.getDatiGenerali().setZonaClimatica(zonaClimatica.get(0).getZonaClimatica());
						datiGenericiDto.getDatiGenerali().setGradiGiorno(zonaClimatica.get(0).getGradiGiorno());
						datiGenericiDto.setZonaClimatica(zonaClimatica.get(0).getZonaClimatica());
					} else if (zonaClimatica.size() > 1) {
						ArrayList<LabelValue> zoneClima = new ArrayList<>();
						for (SiceeDGradiGiorno grado : zonaClimatica) {
							LabelValue label = new LabelValue();
							label.setValue(grado.getZonaClimatica());
							label.setLabel(grado.getZonaClimatica());
							zoneClima.add(label);
						}
						theModel.setAppDatalistZoneClima(zoneClima);
						theModel.setAppDataidComuneZonaClima(istatComune);
					}
				}

				// Recupero il Codice ISTAT dei dati calcolo
				istatComuneCalc = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali()
						.getCodiceISTAT();

			} catch (Exception e) {
				TrackingDbBEException bee = new TrackingDbBEException("Il Codice ISTAT del Comune e' scorretto", e);
				throw bee;
			}

			// Verifico ce il comune si PIEMONTESE
			if (!isProvPiemonte) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException(
						"Il Codice ISTAT del Comune non appartiene ad una provincia piemontese", e);
				throw bee;
			}

			// Beppe - verifico che il Codice ISTAT dei Documento() --> Ape2015 --> DatiGenerali --> DatiIdentificativi 
			// sia lo stesso di Documento --> DatiCalcolo --> DatiGenerali() --> CodiceISTAT
			if (!istatComune.equals(istatComuneCalc)) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException(
						"Il Codice ISTAT del Comune DatiIdentificativi e DatiCalcolo non coincidono", e);
				throw bee;
			}

			// popolamento elenco classi energetiche attive
			//			List<SiceeDClasseEnergetica> classiEnergetiche = getCertificatoMgr()
			//					.recuperaElencoClasseEnergetica();
			//			datiGenericiDto.setClassiEnergetiche(classiEnergetiche);

			// popolamento elenco combustibili vettori per energia esportata
			//			List<SiceeDCombustibile> combustibiliEsportazione = getCertificatoMgr()
			//					.recuperaElencoCombustibiliEnEsportata();
			//			datiGenericiDto
			//					.setCombustibiliEsportazione(combustibiliEsportazione);

			Short vettore = null;
			try {
				vettore = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiEnergetici().getVettoreEnergetico();

				SiceeDCombustibile combustibileEsportazione = getCertificatoMgr()
						.recuperaCombustibileById(MapDto.decodVettoreEnergetico(vettore));
				datiGenericiDto.setCombustibileEsportazione(combustibileEsportazione);

			} catch (Exception e) {
				vettore = null;
			}

			// popolamento elenco combustibili per consumo
			List<SiceeDCombustibile> elencoConsumiCombustibile = getCertificatoMgr()
					.recuperaElencoCombustibiliDettImpiantiImport();

			MapDto.mappaImportDatiGenericiReadOnly(docXmlApeCompleto2015, datiGenericiDto);

			log.debug("Dentro CP (1) datiGenericiDto.getDatiGenerali().getFkDestUso2015: "
					+ datiGenericiDto.getDatiGenerali().getFkDestUso2015());

			String indirizzo = GenericUtil
					.getIndirizzoNormalizzato(datiGenericiDto.getCertificato().getDescIndirizzo());
			// risetto gli indirizzi normalizzati
			datiGenericiDto.getCertificato().setDescIndirizzo(indirizzo);
			//*modDoc.getMOD().getAttestato().getDatiPrecompilati().setIndirizzo(indirizzo);

			// Cerco di normalizzare l'indirizoz e di recuperarlo da TOPE
			datiGenericiDto.getCertificato().setIdIndirizzo(cercaIndirizzoStradario(istatComune, indirizzo));

			List<SiceeDCombustibile> elencoCombustibiliDettImpianti = getCertificatoMgr()
					.recuperaElencoCombustibiliDettImpianti();

			log.debug("Dentro CP (2) datiGenericiDto.getDatiGenerali().getFkDestUso2015: "
					+ datiGenericiDto.getDatiGenerali().getFkDestUso2015());

			// la tabella dell'energia consumata dagli impianti va obbligatoriamente costruita
			//*modDoc = MapDto.mapToElencoConsumiCombustibileReadOnly(modDoc, elencoConsumiCombustibile);

			// popolamento elenco classi energetiche attive
			List<SiceeDClasseEnergetica> classiEnergetiche = getCertificatoMgr().recuperaElencoClasseEnergetica();

			MapDto.mappaImportPrestazioniReadOnly(docXmlApeCompleto2015, datiGenericiDto, elencoConsumiCombustibile,
					classiEnergetiche);

			List<SiceeDRiqEner2015> listRiqEner = getCertificatoMgr().recuperaElencoRiqEnerg();

			MapDto.mappaImportRaccomandazioniReadOnly(docXmlApeCompleto2015, datiGenericiDto, classiEnergetiche,
					listRiqEner);

			//			InputStream myPath = getservletContext.getResourceAsStream("/template/"
			//					+ fileName);

			List<SiceeDTipoImpianto2015> elencoTipiImpianto = getCertificatoMgr().recuperaElencoTipoImpianto2015();

			MapDto.mappaImportDatiImpiantiReadOnly(docXmlApeCompleto2015, datiGenericiDto,
					elencoCombustibiliDettImpianti, elencoTipiImpianto);

			MapDto.mappaImportDatiFinaliReadOnly(docXmlApeCompleto2015, datiGenericiDto);

			log.debug("Dentro CP (3) datiGenericiDto.getDatiGenerali().getFkDestUso2015: "
					+ datiGenericiDto.getDatiGenerali().getFkDestUso2015());

			// controllo ed eventualmente importo il file jpg se embedded nell'xml
			checkAndImportImmagine(docXmlApeCompleto2015, att, idCertificatore, progrCertificato, anno);

			// passaggio di stato dell'APE
			datiGenericiDto.getCertificato().setFkStato(Constants.BOZZA);

			////////////////////////////////////

			// import / update di un subset di dati dell'xml nel db
			log.debug("\n\n>>>>>>> SEZIONE TRANSAZIONALE INIZIO");
			getCertificatoMgr().importApeReadOnly(idCertificatore, progrCertificato, anno, datiGenericiDto, fileName,
					new String(xmlDoc));

			//			getCertificatoMgr().importApeReadOnly(idCertificatore, progrCertificato,
			//					anno, datiGenericiDto, new String(bos.toByteArray()),
			//					fileName, new String(xmlDoc));

			log.debug("\n\n>>>>>>> SEZIONE TRANSAZIONALE FINE");

			return null;

		} catch (TrackingDbBEException e) {
			log.error("parseAndImportXmlFileReadOnly (TrackingDbBEException):: " + e.getMessage(), e);
			// il messaggio della BEException contiene il nome del tag da riportare nel messaggio di errore

			getMiscMgr().gestisciErroreLogDbXml(att, cert, e.getMessage(), Constants.VALIDAZIONE_4);

			return e.getMessage();
		} catch (BEException e) {
			log.error("parseAndImportXmlFileReadOnly (BEException):: " + e.getMessage(), e);
			// il messaggio della BEException contiene il nome del tag da riportare nel messaggio di errore
			if (GenericUtil.isNullOrEmpty(e.getMessage())) {
				return "Si e' verificato un problema nell'import dell'XML";
			} else {

				return e.getMessage();
			}
		} catch (Exception e) {
			log.error("parseAndImportXmlFileReadOnly (Exception):: " + e.getMessage(), e);
			if (GenericUtil.isNullOrEmpty(e.getMessage())) {
				return "Si e' verificato un problema nell'import dell'XML";
			} else {
				return e.getMessage();
			}
		} finally {
			log.debug("[parseAndImportXmlFileReadOnly] END");
		}
	}

	/*
	private String recuperaImmagine(String nome) {
		String result = null;
	
		if (nome != null) {
			ServletContext sc = ServletActionContext.getServletContext();
	
			log.debug("### sc: " + sc);
			log.debug("### nome: " + nome);
	
			InputStream is = sc.getResourceAsStream("/img/attestato2015/" + nome);
	
			//log.debug("### is: " + is);
	
			byte[] input;
			try {
				input = IOUtils.toByteArray(is);
	
				byte[] immagineEncodata = Base64.encode(input);
				result = new String(immagineEncodata);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
			}
		}
		return result;
	
	}
	*/

	private void checkAndImportImmagine(DocumentoDocument docXmlApeCompleto2015, DatiAttestato att,
			String idCertificatore, String progrCertificato, String anno) throws TrackingDbBEException, BEException {

		log.debug("\n\n\n >>>>>>> checkAndImportImmagine");

		byte[] immagine = null;
		//String formatoImmagine = null;
		//try{formatoImmagine = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getFotoEdificio().getFormatoImmagine();}catch (Exception e) {formatoImmagine = null;}
		try {
			immagine = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi()
					.getFotoEdificio().getImmagine();
		} catch (Exception e) {
			immagine = null;
		}

		if ((immagine != null) && (immagine.length > 0)) {
			// c'è un'immagine embedded nell'xml
			// immagine principale
			File f = null;
			try {
				String nomeFile = "tmpImage_" + DateUtil.convertToStringDataCompletaRevert(new Date()) + ".jpg";
				log.debug("\n\n\n >>>>>>> nomeFile: " + nomeFile);
				f = new File(nomeFile);
				FileOutputStream fos = null;
				fos = new FileOutputStream(f);
				fos.write(immagine);
				fos.close();
			} catch (IOException ioe) {
				f.delete();
				TrackingDbBEException bee = new TrackingDbBEException("errore nella creazione del file temporaneo",
						ioe);
				throw bee;
			}

			// controllo che l'immagine sia di un formato supportato
			String mimeType = getSOAIntegrationMgr().checkMimeTypeImmagine(f);
			//log.debug("\n\n\n>>>>>>> mimeType: " + mimeType);
			if (GenericUtil.isNullOrEmpty(mimeType)) {
				f.delete();
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException(
						"Il formato della foto contenuta nell'XML non e' corretto", e);
				throw bee;
			}
			// controllo la dimensione dell'immagine
			if (f.length() > Constants.IMAGE_SIZE) {
				f.delete();
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException(
						"La dimensione della foto e' troppo elevata. La dimensione massima e' di 500Kb", e);
				throw bee;
			}

			// controllo che la codifica dell'immagine contenga VERAMENTE un'immagine
			ByteArrayInputStream baFoto = new ByteArrayInputStream(immagine);
			//BufferedImage ioBf = null;
			try {
				//ioBf = ImageIO.read(baFoto);

				log.debug("inizio jimi");
				JimiReader createJimiReader = Jimi.createJimiReader(baFoto);
				createJimiReader.getRasterImage();

				log.debug("fine jimi");

			} catch (Exception e) {
				f.delete();
				TrackingDbBEException bee = new TrackingDbBEException("errore nella codifica della foto", e);
				throw bee;
			}

			// Faccio il resize della foto
			immagine = getMiscMgr().resizeFoto(immagine);

			// estrarre da SICEE_T_FOTO2015 i dati dell'eventuale immagine preesistente (IDENTIFIC_FOTO che serve per eliminarla da index)
			// eliminare da index l'eventuale immagine preesistente
			// eliminare da SICEE_T_FOTO2015 i metadati dell'eventuale immagine preesistente
			// inserire in index l'immagine
			// inserire in SICEE_T_FOTO2015 i metadati dell'immagine
			List<SiceeTFoto2015> voList = null;
			SiceeTFoto2015 vo = null;
			try {
				voList = getCertificatoMgr().getSiceeTFoto2015Dao()
						.findBySiceeTCertificatoFlgPrincipale(idCertificatore, progrCertificato, anno, "S");
				if ((voList != null) && (voList.size() > 0)) {
					// se preesiste un'immagine su index: 
					// elimino da index l'immagine preesistente e da SICEE_T_FOTO2015 i suoi metadati (eliminaFotoByUid)
					vo = voList.get(0);
					getCertificatoMgr().getSiceeTFoto2015Dao().deleteByIdentificFoto(vo.getIdentificFoto());
					getCertificatoMgr().eliminaFileIndexByUid(vo.getIdentificFoto());
				}
			} catch (Exception e) {
				f.delete();
				TrackingDbBEException bee = new TrackingDbBEException(
						"errore nell'eliminazione dati foto da index o da db", e);
				throw bee;
			}
			// inserisco in index l'immagine
			// inserisco in SICEE_T_FOTO2015 i suoi metadati
			String uid = "";

			try {
				uid = getSOAIntegrationMgr().salvaImmagine(idCertificatore, progrCertificato, anno, att, immagine,
						"sipee_immagine_principale.jpg", mimeType, f.length());

				if (uid == null) {
					throw new Exception();
				}

			} catch (Exception e) {
				f.delete();
				TrackingDbBEException bee = new TrackingDbBEException("Errore nel caricamento della foto su INDEX", e);
				throw bee;
			}

			try {
				SiceeTFoto2015 foto2015 = new SiceeTFoto2015();
				foto2015.setIdCertificatore(idCertificatore);
				foto2015.setProgrCertificato(progrCertificato);
				foto2015.setAnno(anno);
				foto2015.setFkTipoFoto(new Long(1));
				foto2015.setFlgPrincipale("S");
				foto2015.setIdentificFoto(uid);
				foto2015.setNomeFoto("sipee_immagine_principale.jpg");
				foto2015.setDtFoto(new Date());
				SiceeTFoto2015Pk fotoPk = getCertificatoMgr().getSiceeTFoto2015Dao().insert(foto2015);
			} catch (Exception e) {
				f.delete();
				TrackingDbBEException bee = new TrackingDbBEException("Errore nell'inserimento dei metadati della foto",
						e);
				throw bee;
			}

			// Cancellazione del file temporaneo dal file system del server
			f.delete();

		} else {
			log.debug("\n\n\n>>>>>>> non esisitono foto nel file xml");
		}

	}

	// check dati obbligatori minimali per poter procedere con l'importazione
	// NB: Procedura diventata inutile in quanto il controllo di validazione viene fatto
	// con una docXmlApeCompleto2015.validate(); manteniamo la traccia nel caso in cui
	// in seguito occorresse ripristinarla
	private String checkDatiObbligatori(DocumentoDocument docXmlApeCompleto2015) {

		String errorMessage = null;
		//String errorTag = null;
		/*
		 errorTag = "codiceIstat";
		 String istatComune = null;
		 try {istatComune = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getCodiceISTAT();} catch (Exception e) {istatComune = null;}
		 if (GenericUtil.isNullOrEmpty(istatComune)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 }
		
		 errorTag = "indirizzo";
		 String indirizzo = null;
		 try {indirizzo = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getIndirizzo();} catch (Exception e) {indirizzo = null;}
		 if (GenericUtil.isNullOrEmpty(indirizzo)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 }
		
		 errorTag = "cap";
		 String cap = null;
		 try {cap = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getCAP();} catch (Exception e) {cap = null;}
		 if (GenericUtil.isNullOrEmpty(cap)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 } else if (!BaseMgr.checkValideNumber(cap)) {
		 errorMessage = "Solo caratteri numerici: tag " + errorTag;
		 }
		
		 errorTag = "latitudineGIS";
		 BigDecimal latitudineGIS = null;
		 try{latitudineGIS = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getLatitudineGIS();}catch (Exception e) {latitudineGIS = null;}
		 if (GenericUtil.isNullOrEmpty(latitudineGIS)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 } else if (!GenericUtil.isNumeroDecimaleValido(latitudineGIS.toString(), 16, 8)) {
		 errorMessage = "Le coordinate devono essere numeriche e valide: tag " + errorTag;
		 }
		
		 errorTag = "longitudineGIS";
		 BigDecimal longitudineGIS = null;
		 try{longitudineGIS = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getLongitudineGIS();}catch (Exception e) {longitudineGIS = null;}
		 log.debug("\n>>>>>>> longitudineGIS: " + longitudineGIS);
		 if (GenericUtil.isNullOrEmpty(longitudineGIS)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 } else if (!GenericUtil.isNumeroDecimaleValido(longitudineGIS.toString(), 16, 8)) {
		 errorMessage = "Le coordinate devono essere numeriche e valide: tag " + errorTag;
		 }
		
		 String foglio = null;
		 String particella = null;
		 List<TypeDatiCatastali> dcXmlApeList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getCatasto().getDatiCatastaliList();
		 TypeDatiCatastali dcXmlApeRow = null;
		 if (dcXmlApeList != null) {
		 dcXmlApeRow = dcXmlApeList.get(0);
		 foglio = dcXmlApeRow.getFoglio();
		 particella = dcXmlApeRow.getParticella();
		 }
		 errorTag = "foglio";
		 if (GenericUtil.isNullOrEmpty(foglio)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 }
		 errorTag = "particella";
		 if (GenericUtil.isNullOrEmpty(particella)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 }
		
		 errorTag = "annoCostruzione";
		 Integer annoCostruzione;
		 try{annoCostruzione = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getAnnoCostruzione();}catch (Exception e) {annoCostruzione = null;}
		 log.debug("\n>>>>>>> annoCostruzione: " + annoCostruzione);
		 if (GenericUtil.isNullOrEmpty(annoCostruzione)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto nel documento XML: tag " + errorTag;
		 } else if (!GenericUtil.checkValideFourNumber(annoCostruzione.toString())) {
		 errorMessage = "L'anno deve essere di quattro cifre: tag " + errorTag;
		 } else {
		 if (annoCostruzione > DateUtil.getAnnoCorrente()) {
		 errorMessage = "L'anno non può essere futuro: tag " + errorTag;
		 }
		 }
		
		 Date dtScadenza = null;
		 errorTag = "dataScadenza";
		 try{dtScadenza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiAttestato().getDataScadenza().getTime();}catch (Exception e) {dtScadenza = null;}
		 if (GenericUtil.isNullOrEmpty(dtScadenza)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto o scorretto nel documento XML: tag " + errorTag;
		 }
		
		 Date dtEmissione = null;
		 errorTag = "dataEmissione";
		 try{dtEmissione = docXmlApeCompleto2015.getDocumento().getApe2015().getDataEmissione().getTime();}catch (Exception e) {dtEmissione = null;}
		 if (GenericUtil.isNullOrEmpty(dtEmissione)) {
		 errorMessage = "Campo obbligatorio mancante/non corretto o scorretto nel documento XML: tag " + errorTag;
		 }
		 */
		return errorMessage;
	}

	private Integer cercaIndirizzoStradario(String codIstat, String indirizzo) {

		Integer idIndirizzo = null;

		try {
			// Cerco di normalizzare l'indirizoz e di recuperarlo da TOPE
			List<Indirizzo> indirizziList = getSOAIntegrationMgr().verificaIndirizzi(indirizzo, codIstat);

			for (Indirizzo indirizzoSrv : indirizziList) {

				if (indirizzoSrv.getDescr().equalsIgnoreCase(indirizzo)) {
					idIndirizzo = indirizzoSrv.getCod();
					log.debug("Indirizzo trovato: id" + idIndirizzo + " - " + indirizzoSrv.getDescr());
					break;
				}
			}
		} catch (Exception e) {
			log.error("Errore nel recupero degli indirizzi", e);
		}
		return idIndirizzo;
	}

	private boolean recuperaHashFile(String idCertificatore, String progrCertificato, String anno, File fileXmlOrig)
			throws TrackingDbBEException {
		log.info("recuperaHashFile - inizio");
		InputStream inputStream = null;
		boolean isHashCorrect = false;

		try {

			inputStream = new FileInputStream(fileXmlOrig);

			List<String> contentOrig = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
					.lines().collect(Collectors.toList());

			String hashRecuperatoTmp = null;

			String riga = null;

			int i = contentOrig.size() - 1;
			while (i > 0) {

				//log.debug("riga i: "+i);
				riga = contentOrig.get(i);
				//log.debug(riga);
				if (riga.contains("<!--")) {
					// ultima riga
					hashRecuperatoTmp = riga;
					//contentOrig.set(i, keyHash);
					break;
				}

				i--;
			}

			String hashRecuperatoFile = Constants.FILE_NO_HASH;
			String hashCalcolatoFile = Constants.FILE_NO_HASH_MATCH;
			StringBuilder sbFile = null;

			if (hashRecuperatoTmp != null) {
				// ho trovato l'hash nel file

				String hashCalcolatoFileTmp = null;
				// recupero le key possibili dal DB
				String[] keysHash = getMiscMgr().getParametro(Constants.KEY_HASH_IMPORT_XML).split(",");

				//log.debug("hashRecuperatoTmp: "+hashRecuperatoTmp);
				hashRecuperatoFile = hashRecuperatoTmp.replaceAll("<!--", "").replaceAll("-->", "");
				log.info("hashRecuperatoFile: " + hashRecuperatoFile);

				for (String key : keysHash) {
					// settare la key corrente
					contentOrig.set(i, key);

					// Devo creare una stringa dell'intero file su cui calcolare l'hash
					sbFile = new StringBuilder();
					for (int x = 0; x < contentOrig.size(); x++) {

						String rigaContent = contentOrig.get(x);
						//System.out.println(rigaContent);
						sbFile.append(rigaContent);
						if (x != contentOrig.size() - 1)
							sbFile.append("\n");

					}
					hashCalcolatoFileTmp = DigestUtils.sha256Hex(sbFile.toString());
					log.info("hashCalcolatoFileTmp: " + hashCalcolatoFileTmp);

					//hashCalcolatoFile = DigestUtils.sha256Hex(contentOrig.toString());
					//log.debug("hashCalcolatoFile: "+hashCalcolatoFile);

					isHashCorrect = hashRecuperatoFile.equals(hashCalcolatoFileTmp);

					if (isHashCorrect) {
						hashCalcolatoFile = hashCalcolatoFileTmp;
						// ho trovato la corrispondenza dell'hash, quindi esco
						break;
					}
				}

				log.info("hashCalcolatoFile: " + hashCalcolatoFile);

			}

			// devo inserire sul DB
			SiceeLHashXmlImport xashXmlImport = new SiceeLHashXmlImport();
			xashXmlImport.setIdCertificatore(idCertificatore);
			xashXmlImport.setProgrCertificato(progrCertificato);
			xashXmlImport.setAnno(anno);
			xashXmlImport.setDataImport(new Date());
			xashXmlImport.setHashFile(hashRecuperatoFile);
			xashXmlImport.setHashMatch(hashCalcolatoFile);
			getCertificatoMgr().getSiceeLHashXmlImportDao().insert(xashXmlImport);

			// Per adesso non blocchiamo
			/*
			if (!isHashCorrect)
			{
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException(
						"Il codice HASH all'interno del file non e' corretto", e);
				throw bee;
			}
			*/

		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Eccezione (IOException) nel recupero dell'hash del file xml", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Eccezione (Exception) nel recupero dell'hash del file xml", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("Eccezione nella chiusura dell'inputStream del file xml", e);
				}
			}
		}

		log.info("recuperaHashFile - fine");

		return isHashCorrect;
	}

	/*PROTECTED REGION END*/
}
