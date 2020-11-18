/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;

import it.csi.sicee.siceeweb.dto.*;
import it.csi.sicee.siceeweb.dto.attestati.AttestatoSummary;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;
import it.csi.sicee.siceeweb.business.*;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneAceMgr;
import it.csi.sicee.siceeweb.business.print.dto.RicevutaAcquistoAceDto;
import it.csi.sicee.siceeweb.business.print.dto.RicevutaRegistrazioneDto;
import it.csi.sicee.siceeweb.business.print.extended.RicevutaAcquistoAce;
import it.csi.sicee.siceeweb.business.print.extended.RicevutaRegistrazione;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.GenericUtil;

/**
 * CpRegistrazAction Action Class.
 * 
 * @author GuiGen
 */

public class CpRicevutaPagamentiAction extends BaseAction<BaseSessionAwareDTO> implements Preparable {

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
		LOG.debug("[CpRicevutaPagamentiAction::execute] BEGIN");

		DatiCertificatore cert = getAppDatacertificatore();
		Double valore = null;

		try {
			if (getAppDataidTransazione() != null) {
				
				Date dataTransazione = getTransazioneAceMgr().getDataTransazione(
						getAppDataidTransazione());
						
				setDataOdierna(DateUtil.convertToString(dataTransazione));
				
				valore = getTransazioneAceMgr().getPrezzoRegistrazioneByData(dataTransazione);

				// Questo non dovrebbe succere, però ad alcuni utenti, qualche volta, succede 
				if (GenericUtil.isNullOrEmpty(valore))
				{
					valore = Constants.COSTO_DEFAULT_ACE;
				}
				
				setAppDatachiaviAttestati((ArrayList<AttestatoSummary>)getCertificatoMgr()
						.getCertificatiTransazione(getAppDataidTransazione(),
								getAppDatacertificatore()));
				
			}
			
			setAppDataidTransazione(null);

			RicevutaAcquistoAceDto dto = new RicevutaAcquistoAceDto();
			dto.setNome(cert.getDtAnag().getCognome() + " "
					+ cert.getDtAnag().getNome());
			dto.setMatricola(cert.getNumCertificatore());
			dto.setDataAcquisto(getDataOdierna());

			dto.setDataOdierna(GenericUtil.getDataOdierna());
			dto.setValore(valore);
			
			dto.setFirma(getMiscMgr().getParametroFirmaPdf());
			ArrayList<AttestatoSummary> array = getAppDatachiaviAttestati();
			if (array != null) {
				String[] codes = new String[array.size()];
				for (int i = 0; i < array.size(); i++) {
					codes[i] = array.get(i).getCod();
				}
				dto.setCodiciAce(codes);
			}

			RicevutaAcquistoAce ext = new RicevutaAcquistoAce();

			InputStream ioBf = ServletActionContext.getServletContext()
					.getResourceAsStream("/img/logo.jpg");

			// FileInputStream ioBf = new FileInputStream(FOTOFILE);
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
			LOG.debug("[CpRicevutaPagamentiAction::execute] END");
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

	private TransazioneAceMgr transazioneAceMgr = null;

	public TransazioneAceMgr getTransazioneAceMgr() {
		return transazioneAceMgr;
	}

	public void setTransazioneAceMgr(TransazioneAceMgr transazioneAceMgr) {
		this.transazioneAceMgr = transazioneAceMgr;
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
