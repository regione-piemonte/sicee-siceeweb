package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeTDocAggiuntiva implements Serializable {
	protected Integer idDocAggiuntiva;
	protected String nomeDocOriginale;
	protected String nomeDoc;
	protected String uidIndex;
	protected Integer idTipoDocAgg;
	protected String idCertificatore;
	protected String progrCertificato;
	protected String anno;
	protected Date dtUpload;
	protected Date dtDelete;

	public SiceeTDocAggiuntiva() {
	}

	public SiceeTDocAggiuntiva(Integer idDocAggiuntiva, String nomeDocOriginale, String nomeDoc, String uidIndex, Integer idTipoDocAgg, String idCertificatore, String progrCertificato, String anno, Date dtUpload, Date dtDelete) {
		this.idDocAggiuntiva = idDocAggiuntiva;
		this.nomeDocOriginale = nomeDocOriginale;
		this.nomeDoc = nomeDoc;
		this.uidIndex = uidIndex;
		this.idTipoDocAgg = idTipoDocAgg;
		this.idCertificatore = idCertificatore;
		this.progrCertificato = progrCertificato;
		this.anno = anno;
		this.dtUpload = dtUpload;
		this.dtDelete = dtDelete;
	}

	public Integer getIdDocAggiuntiva() {
		return idDocAggiuntiva;
	}

	public void setIdDocAggiuntiva(Integer idDocAggiuntiva) {
		this.idDocAggiuntiva = idDocAggiuntiva;
	}

	public String getNomeDocOriginale() {
		return nomeDocOriginale;
	}

	public void setNomeDocOriginale(String nomeDocOriginale) {
		this.nomeDocOriginale = nomeDocOriginale;
	}

	public String getNomeDoc() {
		return nomeDoc;
	}

	public void setNomeDoc(String nomeDoc) {
		this.nomeDoc = nomeDoc;
	}

	public String getUidIndex() {
		return uidIndex;
	}

	public void setUidIndex(String uidIndex) {
		this.uidIndex = uidIndex;
	}

	public Integer getIdTipoDocAgg() {
		return idTipoDocAgg;
	}

	public void setIdTipoDocAgg(Integer idTipoDocAgg) {
		this.idTipoDocAgg = idTipoDocAgg;
	}

	public String getIdCertificatore() {
		return idCertificatore;
	}

	public void setIdCertificatore(String idCertificatore) {
		this.idCertificatore = idCertificatore;
	}

	public String getProgrCertificato() {
		return progrCertificato;
	}

	public void setProgrCertificato(String progrCertificato) {
		this.progrCertificato = progrCertificato;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public Date getDtUpload() {
		return dtUpload;
	}

	public void setDtUpload(Date dtUpload) {
		this.dtUpload = dtUpload;
	}

	public Date getDtDelete() {
		return dtDelete;
	}

	public void setDtDelete(Date dtDelete) {
		this.dtDelete = dtDelete;
	}
}
