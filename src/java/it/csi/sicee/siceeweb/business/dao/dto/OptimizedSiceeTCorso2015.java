/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class OptimizedSiceeTCorso2015 implements Serializable
{

	protected Integer idCorso;
	protected String titolo;
	protected String denominazione;
	protected Integer totaleOre;
	protected Date dataEsame;
	protected String esitoEsame;
	protected String identificDoc;


	public Integer getIdCorso() {
		return this.idCorso;
	}
	public void setIdCorso(Integer idCorso) {
		this.idCorso = idCorso;
	}

	public String getTitolo()
	{
		return this.titolo;
	}
	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}

	public String getDenominazione()
	{
		return this.denominazione;
	}
	public void setDenominazione(String denominazione)
	{
		this.denominazione = denominazione;
	}

	public Integer getTotaleOre() {
		return this.totaleOre;
	}
	public void setTotaleOre(Integer totaleOre) {
		this.totaleOre = totaleOre;
	}

	public Date getDataEsame() {
		return this.dataEsame;
	}
	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}

	public String getEsitoEsame()
	{
		return this.esitoEsame;
	}
	public void setEsitoEsame(String esitoEsame)
	{
		this.esitoEsame = esitoEsame;
	}

	public String getIdentificDoc()
	{
		return this.identificDoc;
	}
	public void setIdentificDoc(String identificDoc)
	{
		this.identificDoc = identificDoc;
	}

	/**
	 * Method 'OptimizedSiceeTCerticato'
	 * 
	 */
	public OptimizedSiceeTCorso2015()
	{
	}

	/**

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCorso2015: " );
		ret.append( "idCorso=" + this.idCorso );
		ret.append( ", titolo=" + this.titolo );
		ret.append( ", denominazione=" + this.denominazione );
		ret.append( ", totaleOre=" + this.totaleOre );
		ret.append( ", dataEsame=" + this.dataEsame );
		ret.append( ", esitoEsame=" + this.esitoEsame );
		ret.append( ", identificDoc=" + this.identificDoc );
		return ret.toString();
	}

}
