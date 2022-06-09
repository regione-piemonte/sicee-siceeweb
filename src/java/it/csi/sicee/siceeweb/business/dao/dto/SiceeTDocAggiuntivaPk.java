package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTDocAggiuntivaPk implements Serializable {

	protected Integer idDocAggiuntiva;

	public SiceeTDocAggiuntivaPk(Integer idDocAggiuntiva) {
		this.idDocAggiuntiva = idDocAggiuntiva;
	}

	public SiceeTDocAggiuntivaPk() {
	}

	public Integer getIdDocAggiuntiva() {
		return idDocAggiuntiva;
	}

	public void setIdDocAggiuntiva(Integer idDocAggiuntiva) {
		this.idDocAggiuntiva = idDocAggiuntiva;
	}

	@Override
	public String toString() {
		return "SiceeTDocAggiuntivaPk{" + "idDocumento=" + idDocAggiuntiva + '}';
	}
}
