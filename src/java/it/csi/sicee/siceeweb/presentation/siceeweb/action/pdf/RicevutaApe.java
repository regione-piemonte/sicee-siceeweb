/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2020
*******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action.pdf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import it.csi.sicee.siceeweb.business.facade.Message;
import it.csi.sicee.siceeweb.business.facade.ServiziMgr;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.BaseAction;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.CommandExecutionException;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.ICommand;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.Messages;

public class RicevutaApe extends BaseAction<BaseSessionAwareDTO>{

	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	
	private ServiziMgr serviziMgr;
	private static final String APPDATA_IDTRANSAZIONE_CODE = "appDataidTransazione" ;
	private InputStream inputStream;
	private String contentDisposition;
	private String contentType;
	
	// MODOL
		@SuppressWarnings("unchecked")
		@Override
		public String execute() throws IOException
		{
			
			String contentType = "application/pdf";
			String contentDisp = "attachment;filename=ricevuta_APE.pdf";
			LOG.debug("ricerco ape");
			try
			{
				Long idCredito = (Long) session.get(APPDATA_IDTRANSAZIONE_CODE);
				LOG.debug("idCredito: " + idCredito);
				LOG.debug("idCredito: " + idCredito.intValue());
				byte[] ricevutaApe = getServiziMgr().getRicevutaApeReadOnly(idCredito.intValue());
				
				if(ricevutaApe != null) {
					setInputStream(new ByteArrayInputStream(ricevutaApe));
					LOG.debug("ricevuta ape aggiunta");
					setContentDisposition(contentDisp);
					setContentType(contentType);
					
					return "downloadFile";	
				}
				else
				{
					LOG.error("Stampa ricevuta ape: Errore (ape non trovato) su apertura ape");
					session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
					return "KO";
				}
				
			}
			catch (Exception ex)
			{
				LOG.error("Stampa ricevuta ape: Errore (exception) su apertura ape", ex);
				session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
				return "KO";
			} finally {
				LOG.debug("[RicevutaApe::execute] END");
				if (inputStream != null) {
					inputStream.close();
				}
			}
		}
		
	@Override
	public Class modelClass() {
		// TODO Auto-generated method stub
		return getClass();
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}

	@Override
	public void setModel(BaseSessionAwareDTO t) {
		// TODO Auto-generated method stub
		this.model = t;
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
	protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		// TODO Auto-generated method stub
		
	}

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
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

	
}
