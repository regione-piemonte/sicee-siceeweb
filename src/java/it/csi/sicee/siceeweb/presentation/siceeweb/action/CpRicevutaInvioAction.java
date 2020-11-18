/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action;

import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.print.dto.DatiCatastaliDto;
import it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.daticert.DtCatastali;
import it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari;
import it.csi.sicee.siceeweb.util.GenericUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * CpRegistrazAction Action Class.
 * 
 * @author GuiGen
 */

public class CpRicevutaInvioAction extends BaseAction<BaseSessionAwareDTO> implements Preparable {

	private String inputName;
	
	private String contentDisposition;

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public void setAppDatacertificatore(
			it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore value) {
		getSession().put("appDatacertificatore", value);
	}

	public it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore getAppDatacertificatore() {
		return (it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore) (getSession()
				.get("appDatacertificatore"));
	}

	public void setAppDatacurrentUser(it.csi.sicee.siceeweb.dto.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	public it.csi.sicee.siceeweb.dto.UserInfo getAppDatacurrentUser() {
		return (it.csi.sicee.siceeweb.dto.UserInfo) (getSession()
				.get("appDatacurrentUser"));
	}

	public void setAppDatachiaviAttestati(
			java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.AttestatoSummary> value) {
		getSession().put("appDatachiaviAttestati", value);
	}

	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.AttestatoSummary> getAppDatachiaviAttestati() {
		return (java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.AttestatoSummary>) (getSession()
				.get("appDatachiaviAttestati"));
	}

	public void setAppDatadatiPagamento(
			it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento value) {
		getSession().put("appDatadatiPagamento", value);
	}

	public it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento getAppDatadatiPagamento() {
		return (it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento) (getSession()
				.get("appDatadatiPagamento"));
	}

	public void setAppDatacertificato(
			it.csi.sicee.siceeweb.dto.attestati.DatiAttestato value) {
		getSession().put("appDatacertificato", value);
	}

	public it.csi.sicee.siceeweb.dto.attestati.DatiAttestato getAppDatacertificato() {
		return (it.csi.sicee.siceeweb.dto.attestati.DatiAttestato) (getSession()
				.get("appDatacertificato"));
	}

	public void setAppDatacodAttestatoDaStampare(java.lang.String value) {
		getSession().put("appDatacodAttestatoDaStampare", value);
	}

	public java.lang.String getAppDatacodAttestatoDaStampare() {
		return (java.lang.String) (getSession()
				.get("appDatacodAttestatoDaStampare"));
	}

	public Long getAppDataidTransazione() {
		return (Long) (getSession().get("appDataidTransazione"));
	}

	public String getDataOdierna() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(new Date(System.currentTimeMillis()));
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private InputStream inputStream;

	// ///////////////////////////////////////
	// / property comuni a tutte le action
	// ///////////////////////////////////////

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici
	 * 
	 * @return SUCCESS.
	 */

	public String execute() throws Exception {
		LOG.debug("[CpRicevutaInvioAction::execute] BEGIN");

		try {


			String numeroAttestato = getAppDatacodAttestatoDaStampare();

			LOG.debug("Stampo il numero attestato: "+numeroAttestato);
			
			byte[] certificato = getSoaIntegrationMgr()
					.getStampaRicevutaInvioAce(numeroAttestato);
			if (certificato != null) {

				ByteArrayInputStream filePdf = new ByteArrayInputStream(
						certificato);

				inputStream = filePdf;

				setContentDisposition("attachment; filename=\"ricevuta_trasmissione.pdf\";");

			}
		
		} 
		catch (Exception e)
		{
			LOG.error("Stampo l'eccezione",e);
		}
		finally {
			LOG.debug("[CpRicevutaInvioAction::execute] END");
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return "report";
	}

	private CertificatoMgr certificatoMgr = null;

	public void setCertificatoMgr(CertificatoMgr cm) {
		certificatoMgr = cm;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	private MiscMgr miscMgr = null;

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public void validate() {

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
	protected void doBeforeEventCommand()  {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand() {
		// TODO Auto-generated method stub
		
	}

	protected ICommand initCommand(String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
