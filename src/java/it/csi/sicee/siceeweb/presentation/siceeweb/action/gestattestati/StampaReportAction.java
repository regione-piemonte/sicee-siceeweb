/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action.gestattestati;

import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.print.extended.Ace;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.BaseAction;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.CommandExecutionException;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.ICommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

public class StampaReportAction extends BaseAction<BaseSessionAwareDTO> {
	

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private String inputName;

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
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

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	private String contentDisposition;
	private String contentLength;
	private InputStream inputStream;
//	private int bufferSize;
	private String contentType;
	
	private MiscMgr miscMgr;
	
	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	public String execute() throws Exception {
		
		LOG.debug("[StampaReportAction::execute] BEGIN");
		try {
			Ace ext = new Ace();		 
		 DatiAttestato att = getAppDatacertificato();
		 if (att==null){
			 String[] split = getAppDatacodAceInviatoSelezionato().split(" ");
			 DatiCertificatore cert = new DatiCertificatore();
			 cert.setIdCertificatore(split[1]);
			 att = getCertificatoMgr().recuperaAttestato(cert, getAppDatacodAceInviatoSelezionato());
		 }
		 att.setNumeroAttestato(getAppDatacodAceInviatoSelezionato());
		 ByteArrayInputStream filePdf = ext.stampaModulo(getCertificatoMgr().compilaCertificatoPerReport(att, getAppDatacertificatore()), ServletActionContext.getServletContext(), null, getMiscMgr().getParametroFoto());
		 inputStream = filePdf;
		 String nomeFile = getAppDatacertificato().getNumeroAttestato().replaceAll(" ", "_") + ".pdf";
		 contentDisposition = "attachment; filename=\"" + nomeFile + "\";";
		 //getCertificatoMgr().aggiornaStatoDefinitivo(getAppDatacertificatore(), getAppDatacertificato());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[StampaReportAction::execute] END");
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return "report";
	}
	
	

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
	}

	@Override
	public Class modelClass() {
		return null;
	}
	
	public it.csi.sicee.siceeweb.dto.attestati.DatiAttestato getAppDatacertificato() {
		return (it.csi.sicee.siceeweb.dto.attestati.DatiAttestato) (getSession()
				.get("appDatacertificato"));
	}
	
	public it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore getAppDatacertificatore() {
		return (it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore) (getSession()
				.get("appDatacertificatore"));
	}
	
	public String getAppDatacodAceInviatoSelezionato() {
		return (String) (getSession()
				.get("appDatacodAceInviatoSelezionato"));
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
	protected void doBeforeEventCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand() {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
