/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action.gestattestati;

import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.BaseAction;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.CommandExecutionException;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.ICommand;
import it.csi.sicee.siceeweb.util.Constants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class ScaricaAttestatoAction extends BaseAction<BaseSessionAwareDTO> {

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	
	private SOAIntegrationMgr soaIntegrationMgr;
	private String inputName;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	
	
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	
//	public int getBufferSize() {
//		return bufferSize;
//	}
//
//	public void setBufferSize(int bufferSize) {
//		this.bufferSize = bufferSize;
//	}
	
	public String getContentDisposition() {
		return contentDisposition;
	}

	

	

	

	
	public String getContentType() {
		return contentType;
	}

	

	private String contentDisposition;
	public String getInputName() {
		return inputName;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

//	private int bufferSize;
	private String contentType;
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String execute() throws Exception {
		
		LOG.debug("[ScaricaAttestatoAction::execute] BEGIN");
		try {
			
		 String numeroCertificato = getAppDatacodAttestatoDaStampare();
		 DatiCertificatore cert = getAppDatacertificatore();
		 
		 LOG.debug("numeroCertificato: " + numeroCertificato);
		 
		 
		 String uidIndex = getCertificatoMgr().recuperaUidDocumento(cert, numeroCertificato, Constants.ID_PDF_APE_FIRMATO);
		 Documento doc = getSoaIntegrationMgr().recuperaDocumento(uidIndex);


		 /* OLD
		 DatiAttestato attRes = getCertificatoMgr().recuperaAttestato(cert, numeroCertificato);
		 
		 
		 
		 
		 
		 LOG.debug("uidDoc: " + attRes.getDatiAnagraficiImm().getDtCatastali().getUidDoc());
		 
		 Documento doc = getSoaIntegrationMgr().recuperaDocumento(attRes.getDatiAnagraficiImm().getDtCatastali().getUidDoc());
		 */
		 
		 
		 if (doc.getDoc() != null) {
		 if (doc.getMimeType() != null  && !doc.getMimeType().trim().equals("")) {
			 contentType = doc.getMimeType();	 
		 } else {
			 contentType = "application/download";
		 }
		 
		 contentDisposition = "attachment; filename=\"" + doc.getNome() + "\";";
		 
		 
		 inputStream = new ByteArrayInputStream(doc.getDoc());
		 }
		 
		 
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[ScaricaAttestatoAction::execute] END");
		}
		return SUCCESS;
	}
	
	



	
	public it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore getAppDatacertificatore() {
		return (it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore) (getSession()
				.get("appDatacertificatore"));
	}
	
	public it.csi.sicee.siceeweb.dto.attestati.DatiAttestato getAppDatacertificato() {
		return (it.csi.sicee.siceeweb.dto.attestati.DatiAttestato) (getSession()
				.get("appDatacertificato"));
	}
	
	public java.lang.String getAppDatacodAttestatoDaStampare() {
		return (java.lang.String) (getSession()
				.get("appDatacodAttestatoDaStampare"));
	}



	@Override
	public Class modelClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModel(BaseSessionAwareDTO t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void dumpModel(boolean pre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doBeforeEventCommand() throws CommandExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand() throws CommandExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	


}
