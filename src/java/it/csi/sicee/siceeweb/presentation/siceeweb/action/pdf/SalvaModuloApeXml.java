/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action.pdf;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.Message;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.BaseAction;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.CommandExecutionException;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.ICommand;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.MapDto;
import it.csi.sicee.siceeweb.util.Messages;
import it.csi.sicee.siceeweb.util.XmlBeanUtils;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;
import it.csi.util.performance.StopWatch;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Preparable;

public class SalvaModuloApeXml extends BaseAction<BaseSessionAwareDTO> implements Preparable,ServletRequestAware {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	protected CertificatoMgr certificatoMgr;

	private byte[] pdfStream;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute()
	{
		LOG.info("execute di SalvaModuloApeXml");
		try
		{
			LOG.debug("Xml Ricevuto: "+XmlBeanUtils.readByteArray(pdfStream));
			MODDocument modDoc = MapDto.mapToMODDocument(pdfStream);

			String idCertificatore = (String) session.get(Constants.PK_ID_CERTIFICATORE);
			String progrCertificato = (String) session.get(Constants.PK_PROGR);
			String anno = (String) session.get(Constants.PK_ANNO);
			
			LOG.debug("idCertificatore: " + idCertificatore);
			LOG.debug("progrCertificato: " + progrCertificato);
			LOG.debug("anno: " + anno);

			SiceeTCertXml2015 certXML = new SiceeTCertXml2015();
			certXML.setIdCertificatore(idCertificatore);
			certXML.setProgrCertificato(progrCertificato);
			certXML.setAnno(anno);

			LOG.debug("FlagControlloBozza = " + modDoc.getMOD().getAttestato().getDatiModulo().getFlagControlloBozza());
			if (modDoc.getMOD().getAttestato().getDatiModulo().getFlagControlloBozza())
				certXML.setFlgControlloBozza("S");
			else
				certXML.setFlgControlloBozza("N");

			String theXmlString = XmlBeanUtils.readByteArray(pdfStream);
			certXML.setXmlAllegato(theXmlString);
			getCertificatoMgr().salvaModuloApeXml(certXML);
			
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.INFO_SALVATAGGIO_CORRETTO, Message.INFO));
			LOG.debug("Salvataggio ape effettuato. Inserito messaggio in sessione");
			return "OK";
		}
		catch (Exception ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_UPDATE_DB, Message.ERROR));
			LOG.error("Errore salvataggio ape",ex);
			return "KO";
		}
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
	
	private HttpServletRequest request;
	
	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
		
	private byte[] readBytesFromInputStream(InputStream is) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		// TODO Trovare il numero di cache corretto
		
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		stopWatch.start();

		//final int FILE_BLOCK_SIZE = 16384; // Numero "magico". Preso dai
										   // sorgenti di ADOBE - DV
		final int FILE_BLOCK_SIZE = 32768; // Numero "magico". Preso dai
		   // sorgenti di ADOBE - DV
		
		//LOG.debug("FILE_BLOCK_SIZE: "+FILE_BLOCK_SIZE);
		byte[] buf = new byte[FILE_BLOCK_SIZE];

		int readed;
		try {
			while ((readed = is.read(buf)) != -1) {
				os.write(buf, 0, readed);
			}
			os.flush();
		} finally {
			is.close();
			os.close();
		}
		stopWatch.dumpElapsed("SalvaModuloApeXml", "readBytesFromInputStream", "lettura xml",
				"");
		
		return os.toByteArray();
	}

	public void prepare() throws CommandExecutionException {
		try {
//			LOG.debug("ENTRO NEL PREPARE!!!!!");
//			
//			LOG.debug("Stampo la request: "+getServletRequest());
			
			pdfStream = readBytesFromInputStream(getServletRequest().getInputStream());
//			LOG.debug("Lettura byte pdf: "+ pdfStream.length);
			//LOG.debug(new String(pdfStream,"UTF-8"));
		} catch (IOException e) {
			LOG.error("Error: ",e);
		}
		catch (Exception e) {
			LOG.error("Error: ",e);
		}
		
	}
		
	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}
	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	
	
}
