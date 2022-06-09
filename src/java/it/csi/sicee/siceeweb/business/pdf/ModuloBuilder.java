/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.pdf;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
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
	private Integer idCredito;
	
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

	public Integer getIdCredito() {
		return idCredito;
	}
	public void setIdCredito(Integer idCredito) {
		this.idCredito = idCredito;
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
	
	public byte[] getRicevutaApeReadOnly() throws Exception {
		log.debug("[ModuloBuilder::showApeReadOnly] START");

		try {
			
			byte[] xmlModel = getCertificatoMgr().recuperaStampaRicevutaApeReadOnly(idCredito);
		
			return xmlModel;


		}catch(Exception e){
			log.error("Errore apertura file",e);
			throw e;
		}finally{
			log.debug("[ModuloBuilder::getRicevutaApeReadOnly] END");
		}
	}

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
