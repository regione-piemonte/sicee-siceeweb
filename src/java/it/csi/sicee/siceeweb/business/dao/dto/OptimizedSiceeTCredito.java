/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class OptimizedSiceeTCredito implements Serializable
{

	protected Integer idCredito;
	protected String fkCertificatore;
	protected Float valoreCreditoFinale;


	public Integer getIdCredito() {
		return this.idCredito;
	}
	public void setIdCredito(Integer idCredito) {
		this.idCredito = idCredito;
	}

	public String getFkCertificatore()
	{
		return this.fkCertificatore;
	}
	public void setFkCertificatore(String fkCertificatore)
	{
		this.fkCertificatore = fkCertificatore;
	}

	public Float getValoreCreditoFinale()
	{
		return this.valoreCreditoFinale;
	}
	public void setValoreCreditoFinale(Float valoreCreditoFinale)
	{
		this.valoreCreditoFinale = valoreCreditoFinale;
	}

	/**
	 * Method 'OptimizedSiceeTCerticato'
	 * 
	 */
	public OptimizedSiceeTCredito()
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCredito: " );
		ret.append( "idCredito=" + this.idCredito );
		ret.append( ", fkCertificatore=" + this.fkCertificatore );
		ret.append( ", valoreCreditoFinale=" + this.valoreCreditoFinale );
		return ret.toString();
	}

}
