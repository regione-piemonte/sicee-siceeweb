/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneRegistrazMgr;
import it.csi.sicee.siceeweb.business.print.dto.RicevutaRegistrazioneDto;
import it.csi.sicee.siceeweb.business.print.extended.RicevutaRegistrazione;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.GenericUtil;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * CpRegistrazAction Action Class.
 * 
 * @author GuiGen
 */

public class CpRicevutaPagamentiRegistrazioneAction extends BaseAction<BaseSessionAwareDTO>
		implements Preparable {

	private String inputName;

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

	public Long getAppDataidTransazione() {
		return (Long) (getSession().get("appDataidTransazione"));
	}

	public void setAppDataidTransazione(Long value) {
		getSession().put("appDataidTransazione", value);
	}

	public String getDataOdierna() {
		return (String) (getSession().get("appDatadataTransazione"));
	}

	public void setDataOdierna(String date) {
		getSession().put("appDatadataTransazione", date);
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
		LOG.debug("[CpRicevutaPagamentiRegistrazioneAction::execute] BEGIN");

		DatiCertificatore cert = getAppDatacertificatore();

		Double valore = null;
		try {
			if (getAppDataidTransazione() != null) {
				
				
				Date dataTransazione = getTransazioneRegistrazMgr().getDataTransazione(
						getAppDataidTransazione());
						
				
				valore = getTransazioneRegistrazMgr().getPrezzoRegistrazioneByData(dataTransazione);
				
				setDataOdierna(DateUtil.convertToString(dataTransazione));
				
				
			}
			setAppDataidTransazione(null);
			
			RicevutaRegistrazioneDto dto = new RicevutaRegistrazioneDto();
			dto.setNome(cert.getDtAnag().getCognome() + " "
					+ cert.getDtAnag().getNome());
			dto.setMatricola(cert.getNumCertificatore());
			dto.setDataAcquisto(getDataOdierna());
			dto.setFirma(getMiscMgr().getParametroFirmaPdf());
			dto.setDataOdierna(GenericUtil.getDataOdierna());
			dto.setValore(valore);
			
			RicevutaRegistrazione ext = new RicevutaRegistrazione();
			
			InputStream ioBf = ServletActionContext.getServletContext().getResourceAsStream("/img/logo.jpg");
			
			//FileInputStream ioBf = new FileInputStream(FOTOFILE);
			byte[] b = new byte[ioBf.available()];
			ioBf.read(b);

			dto.setLogo(b);
			dto.setSede(getMiscMgr().getParametroSedeRegione());

			ByteArrayInputStream filePdf = ext.stampaModulo(dto,
					ServletActionContext.getServletContext(), null, false);
			inputStream = filePdf;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[CpRicevutaPagamentiRegistrazioneAction::execute] END");
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

	private TransazioneRegistrazMgr transazioneRegistrazMgr = null;

	public TransazioneRegistrazMgr getTransazioneRegistrazMgr() {
		return transazioneRegistrazMgr;
	}

	public void setTransazioneRegistrazMgr(
			TransazioneRegistrazMgr transazioneRegistrazMgr) {
		this.transazioneRegistrazMgr = transazioneRegistrazMgr;
	}

	private MiscMgr miscMgr = null;

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void validate() {

	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		// TODO Auto-generated method stub

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
