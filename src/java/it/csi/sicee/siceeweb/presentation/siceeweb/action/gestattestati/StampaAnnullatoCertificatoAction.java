/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action.gestattestati;


import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.print.extended.Ace;
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

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class StampaAnnullatoCertificatoAction extends BaseAction<BaseSessionAwareDTO> {

	private MiscMgr miscMgr;
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}
	
	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private String inputName;

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
	
	public String execute() throws Exception {

		LOG.debug("[StampaAnnullatoCertificatoAction::execute] BEGIN");
		try {

			String numeroAttestato = getAppDatacodAttestatoDaStampare();
			String nomeFile = null;
			byte[] certificato = null;
			if (getSoaIntegrationMgr().isAttestatoOld(numeroAttestato))
			{
				certificato = getSoaIntegrationMgr().getStampaCertificato(numeroAttestato, "ANNULATO");
				nomeFile = numeroAttestato
						.replaceAll(" ", "_") + "_copia.pdf";
			}
			else
			{
			
				certificato = getSoaIntegrationMgr().getStampaCertificatoNew(numeroAttestato, Constants.ID_PDF_APE_CONSOLIDATO);
				nomeFile = numeroAttestato
						.replaceAll(" ", "_") + "_annullato.pdf";
			}
			
			ByteArrayInputStream filePdf = new ByteArrayInputStream(certificato);
			
			/*
			Ace ext = new Ace();
			String numeroAttestato = getAppDatacodAttestatoDaStampare();
			ByteArrayInputStream filePdf = ext
					.stampaModulo(
							getCertificatoMgr().compilaCertificatoPerStampa(
									numeroAttestato),
							ServletActionContext.getServletContext(), "ANNULATO",
							getMiscMgr().getParametroFoto());
							*/
							
			inputStream = filePdf;

			contentDisposition = "attachment; filename=\"" + nomeFile + "\";";

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[StampaAnnullatoCertificatoAction::execute] END");
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return SUCCESS;
	}
	
	public java.lang.String getAppDatacodAttestatoDaStampare() {
		return (java.lang.String) (getSession()
				.get("appDatacodAttestatoDaStampare"));
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
	}

	@Override
	public Class modelClass() {
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
	protected void doBeforeEventCommand(){
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand()  {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
