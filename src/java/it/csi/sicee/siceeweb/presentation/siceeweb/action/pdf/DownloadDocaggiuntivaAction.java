package it.csi.sicee.siceeweb.presentation.siceeweb.action.pdf;

import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.BaseAction;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.CommandExecutionException;
import it.csi.sicee.siceeweb.presentation.siceeweb.action.ICommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DownloadDocaggiuntivaAction extends BaseAction<BaseSessionAwareDTO> {

	private BaseSessionAwareDTO model;
	private String contentDisposition;
	private String contentType;
	private InputStream inputStream;

	@Override
	public String execute() {
		String contentType = "application/download";
		String contentDisp = "attachment;filename=";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String uidDocumentoAggiuntivo = null;
		try {
			uidDocumentoAggiuntivo = (String) session.get("appDatauidDocumentoSelezionato");
			Documento doc = soaIntegrationMgr.recuperaDocumento(uidDocumentoAggiuntivo);
			if(doc.getDoc()!=null) {
				contentDisp += doc.getNome();
				setContentDisposition(contentDisp);
				setContentType(contentType);
				setInputStream(new ByteArrayInputStream(doc.getDoc()));
				return "downloadFile";
			}else
				return "KO";

		} catch (Exception e) {
			LOG.error("Errore download documento", e);
		}

		return "KO";
	}

	@Override
	public Class modelClass() {
		return null;
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		return null;
	}

	@Override
	public void setModel(BaseSessionAwareDTO baseSessionAwareDTO) {

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
	protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {

	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
