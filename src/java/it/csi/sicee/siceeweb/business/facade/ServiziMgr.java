/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceeweb.business.facade.exceptions.ServiceException;
import it.csi.sicee.siceeweb.business.print.dto.ApeDto;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.MapDto;
import it.csi.sicee.siceeweb.util.Messages;
import it.csi.sicee.siceeweb.util.XmlBeanUtils;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;

import java.util.List;

import org.apache.log4j.Logger;


public class ServiziMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");
	
	//private final String PROPERTIES_RESOURCE = "/META-INF/sigitwebn.properties";
	//private final String MODOL_RESOURCE = "/META-INF/defpd_modolsrv.xml";
	//private final String MODOL_PDF_RESOURCE = "/META-INF/defpd_modolpdfgeneratorsrv.xml";

	protected CertificatoMgr certificatoMgr;
	
	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}
	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}
	
	private TransazioneCreditoMgr transazioneCreditoMgr = null;

	public TransazioneCreditoMgr getTransazioneCreditoMgr() {
		return transazioneCreditoMgr;
	}

	public void setTransazioneCreditoMgr(
			TransazioneCreditoMgr transazioneCreditoMgr) {
		this.transazioneCreditoMgr = transazioneCreditoMgr;
	}
/*	
	protected Properties getProperties() {
		log.debug("[ServiziMgr::getProperties] BEGIN");
		InputStream is = getClass().getResourceAsStream(PROPERTIES_RESOURCE);
		if (is != null) {
			try {
				 Properties properties = new Properties();
	             properties.load(is);
	              
				return properties;
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getProperties] errore nella parsificazione della configurazione delle PROPERTIES:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione delle PROPERTIES");
			}
		} else{
			log.error("[ServiziMgr::getProperties] configurazione delle PROPERTIES non trovata");
		}
		throw new IllegalArgumentException("configurazione delle PROPERTIES non trovata");
	}
*/	
	public void test(){
		log.debug("ServiziMgr RAGGIUNTO CORRETTAMENTE");
	}
				
	/*
	public ModolSrvITF getModol() {
		log.debug("[ServiziMgr::getModol] BEGIN");
		InputStream is = getClass().getResourceAsStream(MODOL_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				log.debug("[ServiziMgr::getModol] END");
				return (ModolSrvITF) PDProxy.newInstance(info);
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getModol] errore nella parsificazione della configurazione di MODOL:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOL");
			}
		} else{
			log.error("[ServiziMgr::getModol] configurazione di MODOL non trovata");
		}
		throw new IllegalArgumentException("configurazione di MODOL non trovata");
	}
	*/
	
	/*
	public ModolPdfGeneratorSrvITF getModolPdf() {
		log.debug("[ServiziMgr::getModolPdf] BEGIN");
		InputStream is = getClass().getResourceAsStream(MODOL_PDF_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				log.debug("[ServiziMgr::getModolPdf] END");
				return (ModolPdfGeneratorSrvITF) PDProxy.newInstance(info);
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getModolPdf] errore nella parsificazione della configurazione di MODOL:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOL");
			}
		} else{
			log.error("[ServiziMgr::getModolPdf] configurazione di MODOL non trovata");
		}
		throw new IllegalArgumentException("configurazione di MODOL PDF non trovata");
	}
	
	
	public byte[] getXmlFromPdf(byte[] thePdf){
		log.debug("[AllegatoBuilder:getXmlFromPdf] START");

		Applicazione app;
		Utente utente;
		
		byte[] file;
		app = new Applicazione();
		app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
		utente = null;
		 try {
			file = getXmlFromModol(app,utente,thePdf); //recupero l'xml da modol
		} catch (ServiceException e) {
			log.error("Errore in getXmlFromPdf() - recupero dati xml da MODOL" + e.getMessage());
			log.error("Stampo l'eccezione: ",e);
			return null;
		}
		log.debug("[AllegatoBuilder:getXmlFromPdf] END");
		 return file;
	}
	
	public byte[] getXmlFromModol(Applicazione app, Utente utente, byte[] thePdf) throws ServiceException {
		log.debug("[SigitMgr::getXmlFromModol] BEGIN");
		try {
			return getXmlFromModolServ(app, utente, thePdf);
		}
		catch(Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally {
			log.debug("[SigitMgr::getXmlFromModol] END");
		}
	}
	
	public byte[] getXmlFromModolServ(Applicazione app, Utente utente, byte[] thePdf) throws ServiceException {
		log.debug("[ServiziMgr::getXmlFromModol] BEGIN");
		ProcessFormRequest pfr = new ProcessFormRequest();
		pfr.setContenuto(thePdf);
		try {
			ProcessFormResponse response=  getModol().processForm(app, utente, pfr);
			log.debug("DATI XML FROM MODOL " + "\\n" + new String(response.getDatiXml()));
			return response.getDatiXml(); //ritorna l'xml con i dati, per metterlo in xmlBean usare AllegatoG Document
		} catch (SystemException e) {
			log.error(e.getStackTrace());
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} catch (UserException e) {
			log.error(e.getStackTrace());
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getXmlFromModol] END");
		}
	}
	
	public byte[] getModuloTarghettaOld(String idCertificatore, String progrCertificato, String anno) throws ServiceException
	{
		Applicazione app;
		Utente utente;
		XmlModel xmlModel = new XmlModel();
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;

			xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(getIndicatoreApeOld(idCertificatore, progrCertificato, anno)));


			return showModuloModol(app, Constants.CODICE_MODULO_MODOL_APE, utente, xmlModel);

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "Errore nella generazione del modulo targhetta");
		}
		catch (ServiceException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "Errore nella generazione del modulo targhetta");
		}
	}
*/
	
	public void creaPdfTarghetta(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		try
		{
			
			byte[] targettaPdf = getSOAIntegrationMgr().recuperaStampaTarghettaCertificatoReadOnly(idCertificatore, progrCertificato, anno);
			
			
			
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato + "_targhetta.pdf";;
	
			if (log.isDebugEnabled())
				log.debug("STAMPO il nome del pdf: "+nome);
			

			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, targettaPdf,
					nome, 
					Constants.TIPOLOGIA_TARGHETTA_ACE, att);
			
			String hash = getCertificatoMgr().getHashFile(targettaPdf);
			
			
			getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_INDICATORE_APE, nome, hash, uidIndex);
			
		}
		catch (Exception e) {
			log.error("Errore consolidamento: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	
	/*
	public void creaPdfTarghettaOld(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		try
		{
			// BEPPE - devo spostare il CREA TARGHETTA
			
//			String codiceImpianto = impianto.getCodiceImpianto().toString();
//			String idLibretto = libretto.getIdLibretto().toString();
//			
			
			it.csi.sicee.siceeweb.xml.appendiceC.data.MODDocument mod = getIndicatoreApeOld(idCertificatore, progrCertificato, anno);
			//creare pdf finale non modificabile, e salvare su INDEX,
			Applicazione app = new Applicazione();
			XmlModel xmlModel = new XmlModel();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			
			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_TARGHETTA);

			
			xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod));
			log.debug("generato xml completo");
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getModol().mergeModulo(app, null, modulo, xmlModel);
			
			log.debug("merge effettuato");
			byte[] thePdf = modulo.getDataContent();
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato + "_targhetta.pdf";;
	
			log.debug("STAMPO il nome del pdf: "+nome);
			
			
			log.debug("PRIMA DELLA CREAZIONE DEL PDF STATICO");
			
			PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
			pdfAInputRequest.setPdfInput(thePdf);
			
			it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione appPdfStatico = new it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione();
			appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			byte[] thePdfStatico = getModolPdf().toPdfA(appPdfStatico, null, pdfAInputRequest);
			
			log.debug("Stampo l'array del pdf statico: "+thePdfStatico);
			
			log.debug("DOPO DELLA CREAZIONE DEL PDF STATICO");
			

			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, thePdfStatico,
					nome, 
					Constants.TIPOLOGIA_TARGHETTA_ACE, att);
			
			String hash = getCertificatoMgr().getHashFile(thePdfStatico);
			
			
			getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_INDICATORE_APE, nome, hash, uidIndex);
			
		}
		catch (Exception e) {
			log.error("Errore consolidamento: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	
	public void creaPdfTarghettaTEST(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		try
		{
			// BEPPE - devo spostare il CREA TARGHETTA
			
//			String codiceImpianto = impianto.getCodiceImpianto().toString();
//			String idLibretto = libretto.getIdLibretto().toString();
//			
			
			it.csi.sicee.siceeweb.xml.appendiceC.data.MODDocument mod = getIndicatoreApeOld(idCertificatore, progrCertificato, anno);
			//creare pdf finale non modificabile, e salvare su INDEX,
			
			Applicazione app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			

			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_TARGHETTA);

			
			XmlModel xmlModel = new XmlModel();
			xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod));
			log.debug("generato xml completo");
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			
			modulo = getModol().mergeModulo(app, null, modulo, xmlModel);
			
			log.debug("merge effettuato");
			byte[] thePdf = modulo.getDataContent();
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato + "_targhetta.pdf";;
	
			log.debug("STAMPO il nome del pdf: "+nome);
			
			
			log.debug("PRIMA DELLA CREAZIONE DEL PDF STATICO");
			
			PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
			pdfAInputRequest.setPdfInput(thePdf);
			
			it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione appPdfStatico = new it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione();
			appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			byte[] thePdfStatico = getModolPdf().toPdfA(appPdfStatico, null, pdfAInputRequest);
			
			log.debug("Stampo l'array del pdf statico: "+thePdfStatico);
			
			log.debug("DOPO DELLA CREAZIONE DEL PDF STATICO");
			

			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, thePdfStatico,
					nome, 
					Constants.TIPOLOGIA_TARGHETTA_ACE, att);
			
			String hash = getCertificatoMgr().getHashFile(thePdfStatico);
			
			
			getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_INDICATORE_APE, nome, hash, uidIndex);
			
		}
		catch (Exception e) {
			log.error("Errore consolidamento: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	
	public byte[] showApeReadOnly(byte[] xmlModel, String idCertificatore, String progrCertificato, String anno){
		log.debug("[ServiziMgr::showApeReadOnly] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			
			model = new XmlModel();
			//model = getXmlApeReadOnly(idCertificatore, progrCertificato, anno);
		
			model.setXmlContent(xmlModel);
			
			
			return showModuloModolStatico(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);
			//return showModuloModol(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);
		
		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ServiziMgr::showApeReadOnly] END");
		}
	}
	
	
	public void showApeReadOnlyTEST(){
		log.debug("[ServiziMgr::showApeReadOnly] START");
		
		// Questi dati ce li ho!!!
		byte[] xmlModel = null; 
		String idCertificatore; 
		String progrCertificato; 
		String anno;
		

		try {
			
			Applicazione app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);

			Utente utente = null;

			XmlModel model = new XmlModel();
			model.setXmlContent(xmlModel);


			Modulo modulo = null;

			CriterioRicercaModulo criterio = new CriterioRicercaModulo();
			criterio.setCodiceModulo(Constants.CODICE_MODULO_MODOL_APE_2015);
			
			Modulo[] moduli = getModol().ricercaModuli(app, utente , criterio);
			if(moduli!=null && moduli.length>0)
			{
				modulo = moduli[0];
			}

			//Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_APE_2015);


			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());


			modulo = getModol().mergeModulo(app, utente, modulo, model);

			byte[] thePdf = modulo.getDataContent();

			PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
			pdfAInputRequest.setPdfInput(thePdf);
			it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione appPdfStatico = new it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione();
			appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			byte[] thePdfStatico = getModolPdf().toPdfA(appPdfStatico, null, pdfAInputRequest);

			// thePdfStatico E' IL RISULTATO

			//return showModuloModolStatico(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);



			
			
		}catch(Exception e){
			log.error("Errore apertura file",e);
		}finally{
			log.debug("[ServiziMgr::showApeReadOnly] END");
		}
	}
	
	public byte[] showApeReadOnlyOld(String idCertificatore, String progrCertificato, String anno){
		log.debug("[ServiziMgr::showApeReadOnly] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlApeReadOnly(idCertificatore, progrCertificato, anno);
		
			return showModuloModolStatico(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);
			//return showModuloModol(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);
		
		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ServiziMgr::showApeReadOnly] END");
		}
	}
	
	private XmlModel getXmlApeReadOnly(String idCertificatore, String progrCertificato, String anno){
		log.debug("[ServiziMgr::getXmlApeReadOnly] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();

			// INIEZIONE FOTO - START
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getApeReadOnly(idCertificatore, progrCertificato, anno));
			String indexImage = getCertificatoMgr().recuperaFoto(idCertificatore, progrCertificato, anno);
			
			SiceeTDatiEner2015 datiEner2015 = getCertificatoMgr().recuperaDatiEner2015(idCertificatore, progrCertificato, anno);
			List<SiceeDClasseEnergetica> classiEnergetiche = getCertificatoMgr()
					.recuperaElencoClasseEnergetica();
			String classeEnerg = MapDto.decodClasseEnergeticaId(datiEner2015.getFkClasseEnergetica(), classiEnergetiche);

			String nomeImg = "classe" + classeEnerg + ".png";
			
			String classeImage = recuperaImmagine(nomeImg);
			String smileInvernoImage = recuperaImmagine(recuperaNomeImmagineSmile(datiEner2015.getFlgSmileInverno()));
			String smileEstateImage = recuperaImmagine(recuperaNomeImmagineSmile(datiEner2015.getFlgSmileEstate()));

			log.debug("################");
			log.debug("classeImage: "+classeImage);
			log.debug("smileInvernoImage: "+smileInvernoImage);
			log.debug("smileEstateImage: "+smileEstateImage);
			log.debug("################");
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			InputStream myInputStream = new ByteArrayInputStream(xmlByteArray);
			Document doc = docBuilder.parse(myInputStream);
			Node datiPrecompilati = doc.getElementsByTagName("data:datiPrecompilati").item(0);
			NodeList list = datiPrecompilati.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				
				log.debug("node - datiPrecompilati: "+node.getNodeName());
				
				if ("data:foto".equals(node.getNodeName())) {
					node.setTextContent(indexImage);
				} 
				
			}
			
			datiPrecompilati = doc.getElementsByTagName(
					"data:prestEnergFabb").item(0);
			list = datiPrecompilati.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);

				log.debug("Node - prestEnergFabb: " + node.getNodeName());

				if ("data:frecciaClasse".equals(node.getNodeName())) {
					node.setTextContent(classeImage);
				} else if (smileInvernoImage != null
						&& "data:smileInverno".equals(node.getNodeName())) {
					node.setTextContent(smileInvernoImage);
				} else if (smileEstateImage != null
						&& "data:smileEstate".equals(node.getNodeName())) {
					node.setTextContent(smileEstateImage);
				}
			}
			
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			StreamResult result = new StreamResult(bos);
			transformer.transform(source, result);
			model.setXmlContent(bos.toByteArray());
			// INIEZIONE FOTO - END

			// SALVATAGGIO XML PER BO - START
			SiceeTCertXml2015 certXML = new SiceeTCertXml2015();
			certXML.setIdCertificatore(idCertificatore);
			certXML.setProgrCertificato(progrCertificato);
			certXML.setAnno(anno);
			//certXML.setFlgControlloBozza("S");

			String theXmlString = XmlBeanUtils.readByteArray(bos.toByteArray());
			certXML.setXmlAllegato(theXmlString);
			getCertificatoMgr().salvaModuloApeXml(certXML);
			// SALVATAGGIO XML PER BO - END
			
			
			//model.setXmlContent(xmlByteArray);
			return model;
			
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ServiziMgr::getXmlApeReadOnly] END");
		}
		
		
	}
	
	private String recuperaImmagine(String nome) {
		String result = null;

		if (nome != null) {
			ServletContext sc = ServletActionContext.getServletContext();

			log.debug("### sc: " + sc);
			log.debug("### nome: " + nome);

			InputStream is = sc.getResourceAsStream("/img/attestato2015/"
					+ nome);

			log.debug("### is: " + is);

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
	
	private String recuperaNomeImmagineSmile(
			Integer idSmile) {

		String smile = null;

		if (idSmile != null) {

			if (idSmile.intValue() == Constants.ID_SMILE_FELICE) {
				smile = "smile_felice.png";
			} else if (idSmile.intValue() == Constants.ID_SMILE_SERIO) {
				smile = "smile_serio.png";
			} else if (idSmile.intValue() == Constants.ID_SMILE_TRISTE) {
				smile = "smile_triste.png";
			}

		}

		return smile;

	}
	
	public byte[] showModuloModol(Applicazione app, String codModuloModol, Utente utente, XmlModel xmlModel) throws ServiceException {
		log.debug("[ServiziMgr::showModuloModol] BEGIN");
		try
		{
			Modulo modulo = cercaModulo(app, codModuloModol);
			log.debug("CODICE MODULO MODOL: "  + codModuloModol);
			if(modulo!=null)
			{
				
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				log.debug("########################################");
				log.debug("faccio la merge");
				log.debug("xmlModel: "+xmlModel.toString());
				log.debug("modulo: "+modulo);
				log.debug("xmlContent:\n"+ new String(xmlModel.getXmlContent()));
				log.debug("########################################");

				return getModol().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "Errore nella generazione del modulo");
		}finally{
			log.debug("[ServiziMgr::showModuloModol] END");
		}
	}
	
	public byte[] showModuloModolStatico(Applicazione app, String codModuloModol, Utente utente, XmlModel xmlModel) throws ServiceException {
		log.debug("[ServiziMgr::showModuloModolStatico] BEGIN");
		try
		{
			Modulo modulo = cercaModulo(app, codModuloModol);
			log.debug("CODICE MODULO MODOL: "  + codModuloModol);
			if(modulo!=null)
			{
				
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				log.debug("########################################");
				log.debug("faccio la merge");
				log.debug("xmlModel: "+xmlModel.toString());
				log.debug("modulo: "+modulo);
				log.debug("xmlContent:\n"+ new String(xmlModel.getXmlContent()));
				log.debug("########################################");

				
				modulo = getModol().mergeModulo(app, utente, modulo, xmlModel);
				log.debug("merge effettuato");
				byte[] thePdf = modulo.getDataContent();
				
				log.debug("PRIMA DELLA CREAZIONE DEL PDF STATICO");
				
				PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
				pdfAInputRequest.setPdfInput(thePdf);
				
				it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione appPdfStatico = new it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione();
				appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
				byte[] thePdfStatico = getModolPdf().toPdfA(appPdfStatico, null, pdfAInputRequest);
				
				log.debug("Stampo l'array del pdf statico: "+thePdfStatico);
				
				log.debug("DOPO DELLA CREAZIONE DEL PDF STATICO");
				
				
				
				
				return thePdfStatico;
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "Errore nella generazione del modulo");
		}finally{
			log.debug("[ServiziMgr::showModuloModolStatico] END");
		}
	}
	
	
	public it.csi.sicee.siceeweb.xml.appendiceC.data.MODDocument getIndicatoreApeOld(String idCertificatore, String progrCertificato, String anno) throws ServiceException {
		log.debug("[ServiziMgr::getIndicatoreApe] BEGIN");
		try {
			
			// Questo è da spostare sull'SRV
			// recupero il dato dal db
			SiceeTDatiEner2015 certXML = getCertificatoMgr().recuperaDatiEner2015(idCertificatore, progrCertificato, anno);
			
			SiceeDClasseEnergetica classeEner = getCertificatoMgr().recuperaClasseEnergetica(certXML.getFkClasseEnergetica());
			
			it.csi.sicee.siceeweb.xml.appendiceC.data.MODDocument modDoc = it.csi.sicee.siceeweb.xml.appendiceC.data.MODDocument.Factory.newInstance();
			modDoc.addNewMOD();
			modDoc.getMOD().addNewPrestEnergFabb();
			
			modDoc.getMOD().setAnno("0000");
			
			PrestEnergFabb energ = modDoc.getMOD().getPrestEnergFabb();
			energ.setFlagEdifEnergZero(certXML.getFlgEdifE0());
//			energ.setClasseEnergetica(classeEner.getDescr());
//			energ.setEpglnrenEdNuovi(Converter.convertToBigDecimal(certXML.getEpglNrenNuovi()));
//			energ.setEpglnrenEdEsistenti(Converter.convertToBigDecimal(certXML.getEpglNrenEsistenti()));
			energ.setEpglnren(Converter.convertToBigDecimal(certXML.getEpglNrenGlobale()));
			energ.setEpglnrenStandard(Converter.convertToBigDecimal(certXML.getEpglNrenRif()));
			energ.setEPHnd(Converter.convertToBigDecimal(certXML.getEph()));
			energ.setEPHndLimite(Converter.convertToBigDecimal(certXML.getEphLimite()));
			energ.setRapportoAsolAsup(Converter.convertToBigDecimal(certXML.getAsolAsup()));
			energ.setEpglren(Converter.convertToBigDecimal(certXML.getEpglRenGlobale()));

			energ.setYie(Converter.convertToBigDecimal(certXML.getYie()));
			
			modDoc.getMOD().setPrestEnergFabb(energ);
			
			return modDoc;
		} catch (Exception e) {
			log.error("Errore getIndicatoreApe",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally{
			log.debug("[ServiziMgr::getIndicatoreApe] END");
		}
			
	}
	*/
	
	public MODDocument getApe(String idCertificatore, String progrCertificato, String anno) throws ServiceException {
		log.debug("[ServiziMgr::getApe] BEGIN");
		try {
			// recupero XML da db
			SiceeTCertXml2015 certXML = getCertificatoMgr().recuperaCertXml2015(idCertificatore, progrCertificato, anno);
			// recupero da tutti i dto i dati da forzare nell'XML
			// e li mappo su un dto unico per comodità
			ApeDto apeDto = new ApeDto();
			SiceeTCertificato certificato = getCertificatoMgr().recuperaCertificato(idCertificatore, progrCertificato, anno);
			SiceeTImportDati2015 datiOrigXML = getCertificatoMgr().getSiceeTImportDati2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			SiceeTDatiGenerali datiGenerali = getCertificatoMgr().recuperaDatiGenerali(idCertificatore, progrCertificato, anno);
			SiceeTAltreInfo altreInfo = getCertificatoMgr().recuperaAltreInfo(idCertificatore, progrCertificato, anno);
			String dMotivo = null;
			String flagServizioEnergia = "N";
			if (!BaseMgr.isNullOrEmpty(altreInfo.getAltroServiziEnergia())) {
				dMotivo = getCertificatoMgr().recuperaDMotivoRilascioDecodifica(altreInfo.getAltroServiziEnergia()).getDescr();
				if ((Constants.ID_MOTIVO_ANTE_OPERAM == altreInfo.getAltroServiziEnergia()) 
						||(Constants.ID_MOTIVO_POST_OPERAM == altreInfo.getAltroServiziEnergia())) {
					flagServizioEnergia = "S";
					// decodifico solo se il motivo è ANTE_OPERAM o POST_OPERAM (getDescr() non produce un null pointer) 
				}
			}
			SiceeTCertificatore certificatore = getCertificatoMgr().recuperaCertificatore(idCertificatore);
			SiceeTAzienda azienda = getCertificatoMgr().recuperaAzienda(certificatore.getFkAzienda());
			String dTitolo = getCertificatoMgr().recuperaDTitolo(certificatore.getFkIstruzione());
			List<SiceeDDestUso2015> elencoClassificazioni = getCertificatoMgr().recuperaElencoClassificazioni();
			List<SiceeDUnitaMisura2015> elencoUnitaMisura = getCertificatoMgr().recuperaElencoUnitaMisura();
			List<SiceeDClasseEnergetica> elencoClasseEnergetica = getCertificatoMgr().recuperaElencoClasseEnergetica();
			List<SiceeDRiqEner2015> elencoCodiciREN = getCertificatoMgr().recuperaElencoCodiciREN();
			List<SiceeDCombustibile> elencoCombustibiliEnEsportata = getCertificatoMgr().recuperaElencoCombustibiliEnEsportata();
			List<SiceeDCombustibile> elencoCombustibiliDettImpianti = getCertificatoMgr().recuperaElencoCombustibiliDettImpianti();
			List<SiceeDCombustibile> elencoConsumiCombustibile = getCertificatoMgr().recuperaElencoConsumiCombustibile();
			apeDto = MapDto.mapFromCertificatoToApe(certificato, datiOrigXML, apeDto);
			
			// devo settare la descrizione della dichiarazione di indipendenza
			SiceeDDichiarazione dichiarazione = getCertificatoMgr().recuperaDichiarazioneIndipendenza(certificato.getFkDichiarazione());
			if (dichiarazione != null)
			{
				// deve essere sicuramente valorizzato
				apeDto.setDescDichIndipendenza(dichiarazione.getDescr());
			}
			
			apeDto = MapDto.mapFromDatiGeneraliToApe(datiGenerali, apeDto);
			apeDto = MapDto.mapFromAltreInfoToApe(altreInfo, apeDto, dMotivo, flagServizioEnergia);
			apeDto = MapDto.mapFromCertificatoreToApe(certificatore, azienda, dTitolo, apeDto);
			
			MODDocument modDoc = null;
			if (certXML != null) {
				log.debug("CERTIFICATO TROVATO");
				modDoc = MapDto.mapToMODDocument(XmlBeanUtils.readString(certXML.getXmlAllegato()));
				modDoc = MapDto.mapToDatiGenerici(modDoc, apeDto);				
				modDoc = MapDto.mapToDatiCatastali(modDoc, apeDto);			
				modDoc = MapDto.mapToElencoClassificazioni(modDoc, elencoClassificazioni);					
				modDoc = MapDto.mapToElencoUnitaMisura(modDoc, elencoUnitaMisura);			
				modDoc = MapDto.mapToElencoClasseEnergetica(modDoc, elencoClasseEnergetica);				
				modDoc = MapDto.mapToElencoCodiciREN(modDoc, elencoCodiciREN);							
				modDoc = MapDto.mapToElencoCombustibiliEnEsportata(modDoc, elencoCombustibiliEnEsportata);							
				modDoc = MapDto.mapToElencoCombustibiliDettImpianti(modDoc, elencoCombustibiliDettImpianti);						
			} else {
				log.debug("CERTIFICATO NON TROVATO");
				modDoc = MODDocument.Factory.newInstance();
				modDoc.addNewMOD();
				modDoc.getMOD().addNewSystem();
				modDoc.getMOD().addNewAttestato();
				modDoc.getMOD().getAttestato().addNewDatiPrecompilati();
				modDoc.getMOD().getAttestato().addNewDatiGenerali();
				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewSezDatiCatastali();
				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewCertificatore();
				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewFoto();
				modDoc.getMOD().getAttestato().addNewPrestEnergImpianti();
				modDoc.getMOD().getAttestato().addNewSoggettoCertificatore();
				modDoc = MapDto.mapToDatiGenerici(modDoc, apeDto);				
				modDoc = MapDto.mapToDatiCatastali(modDoc, apeDto);			
				modDoc = MapDto.mapToElencoClassificazioni(modDoc, elencoClassificazioni);				
				modDoc = MapDto.mapToElencoUnitaMisura(modDoc, elencoUnitaMisura);			
				modDoc = MapDto.mapToElencoClasseEnergetica(modDoc, elencoClasseEnergetica);			
				modDoc = MapDto.mapToElencoCodiciREN(modDoc, elencoCodiciREN);							
				modDoc = MapDto.mapToElencoCombustibiliEnEsportata(modDoc, elencoCombustibiliEnEsportata);							
				modDoc = MapDto.mapToElencoCombustibiliDettImpianti(modDoc, elencoCombustibiliDettImpianti);							
				modDoc = MapDto.mapToElencoConsumiCombustibile(modDoc, elencoConsumiCombustibile);							
			}
			return modDoc;
		} catch (Exception e) {
			log.error("Errore getApe",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally{
			log.debug("[ServiziMgr::getApe] END");
		}
			
	}

	/*
	public it.csi.sicee.siceeweb.xml.attestato2015.data.MODDocument getApeReadOnly(String idCertificatore, String progrCertificato, String anno) throws ServiceException {
		log.debug("[ServiziMgr::getApeReadOnly] BEGIN");
		try {

			SiceeTCertificato certificato = getCertificatoMgr().recuperaCertificato(idCertificatore, progrCertificato, anno);

			SiceeTDatiGenerali datiGenerali = getCertificatoMgr().recuperaDatiGenerali(idCertificatore, progrCertificato, anno);

			SiceeDDestUso2015 destinazioneUso2015 = null;
			if (datiGenerali.getFkDestUso2015() != null)
			{
				destinazioneUso2015 = getCertificatoMgr()
						.recuperaDDestUso2015(
								datiGenerali.getFkDestUso2015());
			}

			SiceeTAltreInfo altreInfo = getCertificatoMgr().recuperaAltreInfo(idCertificatore, progrCertificato, anno);
			String dMotivo = null;
			String flagServizioEnergia = "N";
			if (!BaseMgr.isNullOrEmpty(altreInfo.getAltroServiziEnergia())) {
				dMotivo = getCertificatoMgr().recuperaDMotivoRilascioDecodifica(altreInfo.getAltroServiziEnergia()).getDescr();
				if ((Constants.ID_MOTIVO_ANTE_OPERAM == altreInfo.getAltroServiziEnergia()) 
						||(Constants.ID_MOTIVO_POST_OPERAM == altreInfo.getAltroServiziEnergia())) {
					flagServizioEnergia = "S";
					// decodifico solo se il motivo è ANTE_OPERAM o POST_OPERAM (getDescr() non produce un null pointer) 
				}
			}
			SiceeTCertificatore certificatore = getCertificatoMgr().recuperaCertificatore(idCertificatore);
			SiceeTAzienda azienda = getCertificatoMgr().recuperaAzienda(certificatore.getFkAzienda());
			SiceeTDatiEner2015 datiEner2015 = getCertificatoMgr().recuperaDatiEner2015(idCertificatore, progrCertificato, anno);

			String dTitolo = getCertificatoMgr().recuperaDTitolo(certificatore.getFkIstruzione());
			String descDichIndipendenza = null;

			// devo settare la descrizione della dichiarazione di indipendenza
			SiceeDDichiarazione dichiarazione = getCertificatoMgr().recuperaDichiarazioneIndipendenza(certificato.getFkDichiarazione());
			if (dichiarazione != null)
			{
				// deve essere sicuramente valorizzato
				descDichIndipendenza = dichiarazione.getDescr();
			}

			List<SiceeTDaticatastSec> datiCatastSec = getCertificatoMgr().recuperaDatiCatastaliSec(idCertificatore, progrCertificato, anno);
			// recupero i consumi
			List<SiceeTQtaConsumi2015> quantitaConsumi2015 = getCertificatoMgr().recuperaQuantitaConsumi2015(idCertificatore, progrCertificato, anno);
			List<SiceeDUnitaMisura2015> unitaMisura2015 = getCertificatoMgr().recuperaElencoUnitaMisura();
			// popolamento elenco combustibili per consumo
			List<SiceeDCombustibile> elencoConsumiCombustibile = getCertificatoMgr()
					.recuperaElencoConsumiCombustibile();

			List<SiceeTRaccomand2015> raccomand2015 = getCertificatoMgr().recuperaRaccomand2015(idCertificatore, progrCertificato, anno);
			List<SiceeDClasseEnergetica> elencoClasseEnergetica = getCertificatoMgr().recuperaElencoClasseEnergetica();

			SiceeRCombDener2015 combDener2015 = getCertificatoMgr().recuperaCombDener2015(idCertificatore, progrCertificato, anno);

			List<SiceeRCertifServener2015> certifServener2015List = getCertificatoMgr().recuperaCertifServener2015(idCertificatore, progrCertificato, anno);
			List<SiceeTDetImp2015> detImp2015List = getCertificatoMgr().recuperaDetImp2015(idCertificatore, progrCertificato, anno);

			List<SiceeDCombustibile> elencoCombustibiliDettImpianti = getCertificatoMgr()
					.recuperaElencoCombustibiliDettImpianti();

			List<SiceeDTipoImpianto2015> elencoTipiImpianto = getCertificatoMgr()
					.recuperaElencoTipoImpianto2015();

			List<SiceeDClasseEnergetica> classiEnergetiche = getCertificatoMgr()
					.recuperaElencoClasseEnergetica();


			it.csi.sicee.siceeweb.xml.attestato2015.data.MODDocument modDoc = null;
			log.debug("CERTIFICATO NON TROVATO");
			modDoc = it.csi.sicee.siceeweb.xml.attestato2015.data.MODDocument.Factory.newInstance();

			modDoc.addNewMOD();
			modDoc.getMOD().addNewSystem();
			modDoc.getMOD().addNewAttestato();
			modDoc.getMOD().getAttestato().addNewDatiPrecompilati();
			modDoc.getMOD().getAttestato().addNewDatiGenerali();
			modDoc.getMOD().getAttestato().getDatiPrecompilati()
			.addNewSezDatiCatastali();
			modDoc.getMOD().getAttestato().getDatiPrecompilati()
			.addNewCertificatore();
			modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewFoto();
			modDoc.getMOD().getAttestato().addNewPrestEnergImpianti();
			modDoc.getMOD().getAttestato().addNewPrestEnergFabb();
			modDoc.getMOD().getAttestato().getPrestEnergFabb()
			.addNewFrecciaClasse();
			modDoc.getMOD().getAttestato().getPrestEnergFabb()
			.addNewSmileInverno();
			modDoc.getMOD().getAttestato().getPrestEnergFabb()
			.addNewSmileEstate();

			modDoc.getMOD().getAttestato().addNewRaccomandazioni();
			modDoc.getMOD().getAttestato().getRaccomandazioni()
			.addNewSezioneRen();
			modDoc.getMOD().getAttestato().addNewAltriDatiEnergetici();
			modDoc.getMOD().getAttestato().getAltriDatiEnergetici()
			.addNewVettori();
			modDoc.getMOD().getAttestato().addNewAltriDatiFabbricato();
			modDoc.getMOD().getAttestato().addNewDettaglioImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneClimaInver();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneClimaInver().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneClimaEst();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneClimaEst().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneAcquaCalda();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneAcquaCalda().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneImpiantiCombinati();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneImpiantiCombinati().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneProdFontiRinn();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneProdFontiRinn().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneVentMecc();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneVentMecc().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneIlluminazione();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneIlluminazione().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.addNewSezioneTrasporto();
			modDoc.getMOD().getAttestato().getDettaglioImpianti()
			.getSezioneTrasporto().addNewElencoImpianti();
			modDoc.getMOD().getAttestato().addNewInformazioni();
			modDoc.getMOD().getAttestato().addNewSoggettoCertificatore();
			modDoc.getMOD().getAttestato().addNewSopralluoghi();
			modDoc.getMOD().getAttestato().addNewSoftware();

			modDoc = MapDto.mapToDatiGenericiReadOnly(modDoc, certificato, datiGenerali, certificatore, dTitolo, destinazioneUso2015, azienda, altreInfo, dMotivo, flagServizioEnergia, descDichIndipendenza);				

			modDoc = MapDto.mapToDatiCatastaliReadOnly(modDoc, certificato, datiCatastSec);	

			modDoc = MapDto.mapToDatiEnerReadOnly(modDoc, datiEner2015);				

			modDoc = MapDto.mapToDatiConsumiReadOnly(modDoc, elencoConsumiCombustibile, quantitaConsumi2015, unitaMisura2015);

			modDoc = MapDto.mapToDatiRaccomandazioniReadOnly(modDoc, datiGenerali, raccomand2015, elencoClasseEnergetica, datiEner2015, combDener2015);

			modDoc = MapDto.mapToDatiImpiantiReadOnly(certifServener2015List, detImp2015List, modDoc, elencoCombustibiliDettImpianti, elencoTipiImpianto, datiEner2015, classiEnergetiche);
			modDoc = MapDto.mapToDatiFinaliReadOnly(modDoc, altreInfo, datiEner2015);

			return modDoc;
		} catch (Exception e) {
			log.error("Errore getApeReadOnly",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally{
			log.debug("[ServiziMgr::getApe] END");
		}

	}

	public it.csi.sicee.siceeweb.xml.attestato2015.data.MODDocument getApeReadOnlyOLD(String idCertificatore, String progrCertificato, String anno) throws ServiceException {
		log.debug("[ServiziMgr::getApeReadOnly] BEGIN");
		try {
			// recupero XML da db
			SiceeTCertXml2015 certXML = getCertificatoMgr().recuperaCertXml2015(idCertificatore, progrCertificato, anno);
			// recupero da tutti i dto i dati da forzare nell'XML
			// e li mappo su un dto unico per comodità
			ApeDto apeDto = new ApeDto();
			SiceeTCertificato certificato = getCertificatoMgr().recuperaCertificato(idCertificatore, progrCertificato, anno);
			SiceeTImportDati2015 datiOrigXML = getCertificatoMgr().getSiceeTImportDati2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			SiceeTDatiGenerali datiGenerali = getCertificatoMgr().recuperaDatiGenerali(idCertificatore, progrCertificato, anno);
			SiceeTAltreInfo altreInfo = getCertificatoMgr().recuperaAltreInfo(idCertificatore, progrCertificato, anno);
			String dMotivo = null;
			String flagServizioEnergia = "N";
			if (!BaseMgr.isNullOrEmpty(altreInfo.getAltroServiziEnergia())) {
				dMotivo = getCertificatoMgr().recuperaDMotivoRilascioDecodifica(altreInfo.getAltroServiziEnergia()).getDescr();
				if ((Constants.ID_MOTIVO_ANTE_OPERAM == altreInfo.getAltroServiziEnergia()) 
						||(Constants.ID_MOTIVO_POST_OPERAM == altreInfo.getAltroServiziEnergia())) {
					flagServizioEnergia = "S";
					// decodifico solo se il motivo è ANTE_OPERAM o POST_OPERAM (getDescr() non produce un null pointer) 
				}
			}
			SiceeTCertificatore certificatore = getCertificatoMgr().recuperaCertificatore(idCertificatore);
			SiceeTAzienda azienda = getCertificatoMgr().recuperaAzienda(certificatore.getFkAzienda());
			String dTitolo = getCertificatoMgr().recuperaDTitolo(certificatore.getFkIstruzione());
//			List<SiceeDDestUso2015> elencoClassificazioni = getCertificatoMgr().recuperaElencoClassificazioni();
//			List<SiceeDUnitaMisura2015> elencoUnitaMisura = getCertificatoMgr().recuperaElencoUnitaMisura();
//			List<SiceeDClasseEnergetica> elencoClasseEnergetica = getCertificatoMgr().recuperaElencoClasseEnergetica();
//			List<SiceeDRiqEner2015> elencoCodiciREN = getCertificatoMgr().recuperaElencoCodiciREN();
//			List<SiceeDCombustibile> elencoCombustibiliEnEsportata = getCertificatoMgr().recuperaElencoCombustibiliEnEsportata();
//			List<SiceeDCombustibile> elencoCombustibiliDettImpianti = getCertificatoMgr().recuperaElencoCombustibiliDettImpianti();
//			List<SiceeDCombustibile> elencoConsumiCombustibile = getCertificatoMgr().recuperaElencoConsumiCombustibile();
			apeDto = MapDto.mapFromCertificatoToApeReadOnly(certificato, apeDto);
			
			// devo settare la descrizione della dichiarazione di indipendenza
			SiceeDDichiarazione dichiarazione = getCertificatoMgr().recuperaDichiarazioneIndipendenza(certificato.getFkDichiarazione());
			if (dichiarazione != null)
			{
				// deve essere sicuramente valorizzato
				apeDto.setDescDichIndipendenza(dichiarazione.getDescr());
			}
			
			apeDto = MapDto.mapFromDatiGeneraliToApeReadOnly(datiGenerali, apeDto);
			apeDto = MapDto.mapFromAltreInfoToApeReadOnly(altreInfo, apeDto, dMotivo, flagServizioEnergia);
			apeDto = MapDto.mapFromCertificatoreToApeReadOnlyOLD(certificatore, azienda, dTitolo, apeDto);
			
			it.csi.sicee.siceeweb.xml.attestato2015.data.MODDocument modDoc = null;
//			if (certXML != null) {
//				log.debug("CERTIFICATO TROVATO");
				log.debug("Contenuto xml: " + certXML.getXmlAllegato());
				modDoc = MapDto.mapToMODDocumentReadOnly(XmlBeanUtils.readString(certXML.getXmlAllegato()));
				//modDoc = MapDto.mapToDatiGenericiReadOnly(modDoc, apeDto);				
				//*modDoc = MapDto.mapToDatiCatastaliReadOnly(modDoc, apeDto);			
//				//*modDoc = MapDto.mapToElencoClassificazioni(modDoc, elencoClassificazioni);					
//				modDoc = MapDto.mapToElencoUnitaMisura(modDoc, elencoUnitaMisura);			
//				modDoc = MapDto.mapToElencoClasseEnergetica(modDoc, elencoClasseEnergetica);				
//				modDoc = MapDto.mapToElencoCodiciREN(modDoc, elencoCodiciREN);							
//				modDoc = MapDto.mapToElencoCombustibiliEnEsportata(modDoc, elencoCombustibiliEnEsportata);							
//				modDoc = MapDto.mapToElencoCombustibiliDettImpianti(modDoc, elencoCombustibiliDettImpianti);						
//			} else {
//				log.debug("CERTIFICATO NON TROVATO");
//				modDoc = it.csi.sicee.siceeweb.xml.attestato2015.data.MODDocument.Factory.newInstance();
//				modDoc.addNewMOD();
//				modDoc.getMOD().addNewSystem();
//				modDoc.getMOD().addNewAttestato();
//				modDoc.getMOD().getAttestato().addNewDatiPrecompilati();
//				modDoc.getMOD().getAttestato().addNewDatiGenerali();
//				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewSezDatiCatastali();
//				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewCertificatore();
//				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewFoto();
//				modDoc.getMOD().getAttestato().addNewPrestEnergImpianti();
//				modDoc.getMOD().getAttestato().addNewSoggettoCertificatore();
//				modDoc = MapDto.mapToDatiGenericiReadOnly(modDoc, apeDto);				
//				modDoc = MapDto.mapToDatiCatastaliReadOnly(modDoc, apeDto);			
//				modDoc = MapDto.mapToElencoClassificazioni(modDoc, elencoClassificazioni);				
//				modDoc = MapDto.mapToElencoUnitaMisura(modDoc, elencoUnitaMisura);			
//				modDoc = MapDto.mapToElencoClasseEnergetica(modDoc, elencoClasseEnergetica);			
//				modDoc = MapDto.mapToElencoCodiciREN(modDoc, elencoCodiciREN);							
//				modDoc = MapDto.mapToElencoCombustibiliEnEsportata(modDoc, elencoCombustibiliEnEsportata);							
//				modDoc = MapDto.mapToElencoCombustibiliDettImpianti(modDoc, elencoCombustibiliDettImpianti);							
//				modDoc = MapDto.mapToElencoConsumiCombustibile(modDoc, elencoConsumiCombustibile);							
			//}
			return modDoc;
		} catch (Exception e) {
			log.error("Errore getApeReadOnly",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally{
			log.debug("[ServiziMgr::getApe] END");
		}
			
	}
	
	public Modulo cercaModulo(Applicazione applicazione, String codiceModulo) throws ServiceException {
		log.debug("[ServiziMgr::cercaModulo] BEGIN");
		log.debug("CODICE MODOL: [" + codiceModulo + "]");
		CriterioRicercaModulo criterio;
		try {
			criterio = new CriterioRicercaModulo();
			criterio.setCodiceModulo(codiceModulo);
			Modulo[] moduli = getModol().ricercaModuli(applicazione, null , criterio);
			if(moduli!=null && moduli.length>0)
			{
				return moduli[0];
			}
			else
			{
				log.error("Non ho trovato il modulo su MODOL");
				throw new ServiceException(null, Messages.ERROR_RECUPERO_SERVIZIO);
			}
		}catch (Exception e) {
				log.error("Errore recupero modulo: ", e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::cercaModulo] END");
		}
	}
	*/
	
	public void creaPdfEConsolidaCertificatoReadOnly(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		creaPdfESalvaCertificatoReadOnly(cert, idCertificatore, progrCertificato, anno, att, Constants.CONSOLIDATO);
	}
	
	/*
	public void creaPdfEConsolidaCertificatoOLD(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		creaPdfESalvaCertificatoOLD(cert, idCertificatore, progrCertificato, anno, att, Constants.CONSOLIDATO);
	}

	public void creaPdfEAnnullaCertificatoOLD(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		creaPdfESalvaCertificatoOLD(cert, idCertificatore, progrCertificato, anno, att, Constants.ANNULLATO);
	}
	*/

	public void creaPdfEAnnullaCertificatoReadOnly(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		creaPdfESalvaCertificatoReadOnly(cert, idCertificatore, progrCertificato, anno, att, Constants.ANNULLATO);
	}

	private void creaPdfESalvaCertificatoReadOnly(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att, int idStatoAttestato) throws ServiceException
	{
		try
		{

			byte[] thePdf = getCertificatoMgr().recuperaStampaCertificatoReadOnly(idCertificatore, progrCertificato, anno, idStatoAttestato);
			
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato;
			if (idStatoAttestato == Constants.ANNULLATO)
			{
				nome += "_annullato";
			}
			nome += ".pdf";
	
			if (log.isDebugEnabled())
				log.debug("STAMPO il nome del pdf: "+nome);
			

			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, thePdf,
					nome, 
					Constants.TIPOLOGIA_ALLEGATO_ACE_NEW, att);
			
			String hash = getCertificatoMgr().getHashFile(thePdf);
			
			if (idStatoAttestato == Constants.CONSOLIDATO)
			{
				getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			else if (idStatoAttestato == Constants.ANNULLATO)
			{
				getCertificatoMgr().modificaDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			
			
		}
		catch (Exception e) {
			log.error("Errore creaPdfESalvaAttestato: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	
	/*
	private void creaPdfESalvaCertificatoReadOnlyOld(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att, int statoAttestato) throws ServiceException
	{
		try
		{

			byte[] thePdf = showApeReadOnlyOld(idCertificatore, progrCertificato, anno);
			
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato;
			if (statoAttestato == Constants.ANNULLATO)
			{
				nome += "_annullato";
			}
			nome += ".pdf";
	
			log.debug("STAMPO il nome del pdf: "+nome);
			

			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, thePdf,
					nome, 
					Constants.TIPOLOGIA_ALLEGATO_ACE_NEW, att);
			
			String hash = getCertificatoMgr().getHashFile(thePdf);
			
			if (statoAttestato == Constants.CONSOLIDATO)
			{
				getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			else if (statoAttestato == Constants.ANNULLATO)
			{
				getCertificatoMgr().modificaDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			
			
		}
		catch (Exception e) {
			log.error("Errore creaPdfESalvaAttestato: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	
	private void creaPdfESalvaCertificatoOLD(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att, int statoAttestato) throws ServiceException
	{
		try
		{
			
			
//			String codiceImpianto = impianto.getCodiceImpianto().toString();
//			String idLibretto = libretto.getIdLibretto().toString();
//			
			MODDocument mod = getApe(idCertificatore, progrCertificato, anno);
			
			log.debug("@@@@@@STAMPO LO STATO DEL PDF CHE DEVO RENDERE STATICO: "+mod.getMOD().getAttestato().getDatiPrecompilati().getStatoModulo());
			
			//creare pdf finale non modificabile, e salvare su INDEX,
			Applicazione app = new Applicazione();
			XmlModel xmlModel = new XmlModel();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			
			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_APE);
			
			// INIEZIONE FOTO - START
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(mod);
			String indexImage = getCertificatoMgr().recuperaFoto(idCertificatore, progrCertificato, anno);
			
			if (indexImage == null)
			{
				throw new ServiceException(null, Messages.ERROR_RECUPERO_SERVIZIO);
			}
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			InputStream myInputStream = new ByteArrayInputStream(xmlByteArray);
			Document doc = docBuilder.parse(myInputStream);
			Node datiPrecompilati = doc.getElementsByTagName("data:datiPrecompilati").item(0);
			NodeList list = datiPrecompilati.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if ("data:foto".equals(node.getNodeName())) {
				   node.setTextContent(indexImage);
			   }
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			StreamResult result = new StreamResult(bos);
			transformer.transform(source, result);
			xmlModel.setXmlContent(bos.toByteArray());
			// INIEZIONE FOTO - END
			
			//xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod));
			log.debug("generato xml completo");
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getModol().mergeModulo(app, null, modulo, xmlModel);
			
			log.debug("merge effettuato");
			byte[] thePdf = modulo.getDataContent();
			
			
			
			// Devo creare il pdf statico
			
			
			log.debug("PRIMA DELLA CREAZIONE DEL PDF STATICO");
			
//			PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
//			pdfAInputRequest.setPdfInput(thePdf);
//			it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione appPdfStatico = new it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione();
//			appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
//			byte[] thePdfStatico = getModolPdf().toPdfA(appPdfStatico, null, pdfAInputRequest);
//			
//			log.debug("Stampo l'array del pdf statico: "+thePdfStatico);
//			
			log.debug("DOPO DELLA CREAZIONE DEL PDF STATICO");
			
			
			
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato;
			if (statoAttestato == Constants.ANNULLATO)
			{
				nome += "_annullato";
			}
			nome += ".pdf";
	
			log.debug("STAMPO il nome del pdf: "+nome);
			
			//long length = 0; // SERVE QUESTO PARAMETRO?
			//String contentType = null;
			
			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, thePdf,
					nome, 
					Constants.TIPOLOGIA_ALLEGATO_ACE_NEW, att);
			
			String hash = getCertificatoMgr().getHashFile(thePdf);
			
			if (statoAttestato == Constants.CONSOLIDATO)
			{
				getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			else if (statoAttestato == Constants.ANNULLATO)
			{
				getCertificatoMgr().modificaDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			
		}
		catch (Exception e) {
			log.error("Errore creaPdfESalvaAttestato: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	*/
	
	
}