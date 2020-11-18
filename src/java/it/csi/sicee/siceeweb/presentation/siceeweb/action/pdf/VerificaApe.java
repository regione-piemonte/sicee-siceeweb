/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action.pdf;

import it.csi.sicee.siceeweb.business.facade.Message;
import it.csi.sicee.siceeweb.business.pdf.ModuloBuilder;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.BaseAction;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.CommandExecutionException;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.ICommand;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.pdf.dto.Attestato;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.Messages;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.xmlbeans.impl.util.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.lowagie.text.Image;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class VerificaApe extends BaseAction<BaseSessionAwareDTO> {

	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	private ModuloBuilder moduloBuilder;

	// MODOL
	@SuppressWarnings("unchecked")
	@Override
	public String execute()
	{
		
		String contentType = "application/pdf";
		String contentDisp = "attachment;filename=ape.pdf";
		LOG.debug("ricerco ape");
		try
		{
			String idCertificatore = (String) session.get(Constants.PK_ID_CERTIFICATORE);
			String progrCertificato = (String) session.get(Constants.PK_PROGR);
			String anno = (String) session.get(Constants.PK_ANNO);
			
			LOG.debug("idCertificatore: " + idCertificatore);
			LOG.debug("progrCertificato: " + progrCertificato);
			LOG.debug("anno: " + anno);
			moduloBuilder.setIdCertificatore(idCertificatore);
			moduloBuilder.setProgrCertificato(progrCertificato);
			moduloBuilder.setAnno(anno);

			byte[] ape = getModuloBuilder().showApeReadOnly();
			if(ape!=null)
			{
				setInputStream(new ByteArrayInputStream(ape));
				LOG.debug("ape aggiunto");
				setContentDisposition(contentDisp);
				setContentType(contentType);
				return "downloadFile";
			}
			else
			{
				LOG.error("CompilaModificaApe: Errore (ape non trovato) su apertura ape");
				session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
				return "KO";
			}
			
		}
		catch (Exception ex)
		{
			LOG.error("CompilaModificaApe: Errore (exception) su apertura ape", ex);
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
			return "KO";
		}
	}
	
	
	// JASPERREPORT
	/*
	@SuppressWarnings("unchecked")
	@Override
	public String execute()
	{
		
		String contentType = "application/pdf";
		String contentDisp = "attachment;filename=ape.pdf";
		LOG.debug("ricerco ape");
		try
		{
			JasperReport jasperReport = null;
            JasperPrint jasperPrint = null;
            JasperDesign jasperDesign = null;
            Map parameters = new HashMap();
            
            // per adesso uso dati statici, dopo dovrò usare quello sotto
            String idCertificatore = "1441";
			String progrCertificato = "0039";
			String anno = "2014";
//            String idCertificatore = (String) session.get(Constants.PK_ID_CERTIFICATORE);
//			String progrCertificato = (String) session.get(Constants.PK_PROGR);
//			String anno = (String) session.get(Constants.PK_ANNO);
			
			LOG.debug("idCertificatore: " + idCertificatore);
			LOG.debug("progrCertificato: " + progrCertificato);
			LOG.debug("anno: " + anno);
			moduloBuilder.setIdCertificatore(idCertificatore);
			moduloBuilder.setProgrCertificato(progrCertificato);
			moduloBuilder.setAnno(anno);
			
			
            ServletContext sc = ServletActionContext.getServletContext();

            // Setto la cartella in cui si trovano i SUB_REPORTS
            // Questa riga è solo in fase di sviluppo, in seguito sarà la riga sotto 
            parameters.put("SUBREPORT_DIR", "/home/apps/boz9/deploy/");
            //parameters.put("SUBREPORT_DIR", sc.getResource("/template/").getPath());
            
            URI uriImg = new URI("/img/jasper/");

            // Setto la cartella in cui si trovano le immagini
            parameters.put("PATH_IMG", sc.getResource("/img/jasper/").getPath());
            LOG.debug("PATH_IMG: "+(sc.getResource("/img/jasper/").getPath())); // OK

            byte[] fotoPrinc = getModuloBuilder().getImmaginePrinciale();
            
            InputStream in = new ByteArrayInputStream(fotoPrinc);
	        
			parameters.put("IMG_PRINC", in);


			LOG.debug("Prima di jasperDesign");
            
            // Questa riga è solo in fase di sviluppo, in seguito sarà la riga sotto 
            jasperDesign = JRXmlLoader.load("/home/apps/boz9/deploy/reportProva.jrxml");
            // jasperDesign = JRXmlLoader.load("/appserv/wls922/beahome/reportProva.jrxml"); OK
            
            // Questo sarà quello definitivo
            //jasperDesign = JRXmlLoader.load(sc.getResourceAsStream("/appserv/wls922/beahome/reportProva.jrxml"));
            
            LOG.debug("HO CARICATO QUELLO STATICO: "+jasperDesign);
            //jasperDesign = JRXmlLoader.load(sc.getResourceAsStream("/template/reportProva.jrxml"));
            //jasperDesign = JRXmlLoader.load("D:\\progetti\\test\\jasperReport2\\src\\attestato.jrxml");
            LOG.debug("Dopo di jasperDesign: "+jasperDesign);

            LOG.debug("Prima di jasperReport");
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            LOG.debug("Dopo di jasperReport: "+jasperReport);
            
            //org.codehaus.groovy.control.CompilationFailedException
            //org/codehaus/groovy/control/CompilationFailedException
            
            LOG.debug("Prima di jasperPrint");
            jasperPrint  = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(Attestato.generaAttestato()));
            LOG.debug("Dopo di jasperPrint: "+jasperPrint);


						
            byte[] ape = JasperExportManager.exportReportToPdf(jasperPrint);
			
			
			if(ape!=null)
			{
				setInputStream(new ByteArrayInputStream(ape));
				LOG.debug("ape aggiunto");
				setContentDisposition(contentDisp);
				setContentType(contentType);
				return "downloadFile";
			}
			else
			{
				LOG.error("CompilaModificaApe: Errore (ape non trovato) su apertura ape");
				session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
				return "KO";
			}
			
		}
		catch (Exception ex)
		{
			LOG.error("CompilaModificaApe: Errore (exception) su apertura ape", ex);
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
			return "KO";
		}
	}
	*/
	private String recuperaImmagine(String nome) {
		String result = null;

		ServletContext sc = ServletActionContext.getServletContext();

		//LOG.debug("### sc: " + sc);
		InputStream is = sc.getResourceAsStream("/img/jasper/" + nome);

		byte[] input;
		try {
			input = IOUtils.toByteArray(is);

			byte[] immagineEncodata = Base64.encode(input);
			result = new String(immagineEncodata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
		}
		return result;

	}

	@SuppressWarnings("rawtypes")
	public Class modelClass() {
		return getClass();
	}

	public BaseSessionAwareDTO getModel() {
		return this.model;
	}

	public void setModel(BaseSessionAwareDTO t) {
		this.model = t;
	}

	@Override
	protected void dumpModel(boolean pre) {
		
	}

	@Override
	protected void doBeforeEventCommand() throws CommandExecutionException {
		
	}

	@Override
	protected void doAfterEventCommand() throws CommandExecutionException {
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		
	}

	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	

	public ModuloBuilder getModuloBuilder() {
		return moduloBuilder;
	}
	public void setModuloBuilder(ModuloBuilder moduloBuilder) {
		this.moduloBuilder = moduloBuilder;
	}


	
}
