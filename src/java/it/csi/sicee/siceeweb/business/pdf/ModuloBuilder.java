/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.pdf;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
//import it.csi.modol.modolsrv.dto.Applicazione;
//import it.csi.modol.modolsrv.dto.Utente;
//import it.csi.modol.modolsrv.dto.XmlModel;
import it.csi.sicee.siceeweb.business.facade.ServiziMgr;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.MapDto;
import it.csi.sicee.siceeweb.util.XmlBeanUtils;

import java.io.Serializable;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.xmlbeans.impl.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ModuloBuilder  implements Serializable {

	protected static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.pdf");
	
	private static final long serialVersionUID = 1L;

	private ServiziMgr serviziMgr;
	
	private String idCertificatore;
	private String progrCertificato;
	private String anno;
	
	public String getIdCertificatore() {
		return idCertificatore;
	}
	public void setIdCertificatore(String idCertificatore) {
		this.idCertificatore = idCertificatore;
	}

	public String getProgrCertificato() {
		return progrCertificato;
	}
	public void setProgrCertificato(String progrCertificato) {
		this.progrCertificato = progrCertificato;
	}

	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}
	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}
	
	protected CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}
	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	/*
	public byte[] showApeOld(){
		log.debug("[ModuloBuilder::showApe] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlApe();
		
			return getServiziMgr().showModuloModol(app,Constants.CODICE_MODULO_MODOL_APE,utente,model);
		
		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showApe] END");
		}
	}
	*/
	
	/*
	private XmlModel getXmlApe(){
		log.debug("[ModuloBuilder::getXmlApe] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();

			// INIEZIONE FOTO - START
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getApe(getIdCertificatore(), getProgrCertificato(), getAnno()));
			String indexImage = getCertificatoMgr().recuperaFoto(getIdCertificatore(), getProgrCertificato(), getAnno());
			
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
			model.setXmlContent(bos.toByteArray());
			// INIEZIONE FOTO - END

			//model.setXmlContent(xmlByteArray);
			return model;
			
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlApe] END");
		}
	}
	*/
	
	public byte[] showApeReadOnly() throws Exception {
		log.debug("[ModuloBuilder::showApeReadOnly] START");

		try {
			
			byte[] xmlModel = getCertificatoMgr().recuperaStampaCertificatoReadOnly(getIdCertificatore(), getProgrCertificato(), getAnno(), null);

			//return getServiziMgr().showApeReadOnly(xmlModel, getIdCertificatore(), getProgrCertificato(), getAnno());
			
			return xmlModel;


		}catch(Exception e){
			log.error("Errore apertura file",e);
			throw e;
		}finally{
			log.debug("[ModuloBuilder::showApeReadOnly] END");
		}
	}
	
	/*
	public byte[] showApeReadOnlyOld(){
		log.debug("[ModuloBuilder::showApeReadOnly] START");

		try {
			return getServiziMgr().showApeReadOnlyOld(getIdCertificatore(), getProgrCertificato(), getAnno());


		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showApeReadOnly] END");
		}
	}
	*/
	
	/*
	public byte[] showApeReadOnlyOLD(){
		log.debug("[ModuloBuilder::showApeReadOnly] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlApeReadOnly();
		
			//return getServiziMgr().showModuloModolStatico(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);
			return getServiziMgr().showModuloModol(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);
		
		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showApeReadOnly] END");
		}
	}
	
	private XmlModel getXmlApeReadOnly(){
		log.debug("[ModuloBuilder::getXmlApeReadOnly] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();

			// INIEZIONE FOTO - START
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getApeReadOnly(getIdCertificatore(), getProgrCertificato(), getAnno()));
			String indexImage = getCertificatoMgr().recuperaFoto(getIdCertificatore(), getProgrCertificato(), getAnno());
			
			SiceeTDatiEner2015 datiEner2015 = getCertificatoMgr().recuperaDatiEner2015(getIdCertificatore(), getProgrCertificato(), getAnno());
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

			//model.setXmlContent(xmlByteArray);
			return model;
			
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlApeReadOnly] END");
		}
		
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
	*/
	
	public byte[] getImmaginePrinciale()
	{
		log.debug("[ModuloBuilder::getImmaginePrinciale] START");

		try {
		//byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getApe(getIdCertificatore(), getProgrCertificato(), getAnno()));
		//String indexImage = getCertificatoMgr().recuperaFoto(getIdCertificatore(), getProgrCertificato(), getAnno());
		return getCertificatoMgr().recuperaFotoJasper(getIdCertificatore(), getProgrCertificato(), getAnno());
				
		//return indexImage;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getImmaginePrinciale] END");
		}
	}
}
