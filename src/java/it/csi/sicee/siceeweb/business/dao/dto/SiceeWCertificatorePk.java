/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_W_CERTIFICATORE table.
 */
public class SiceeWCertificatorePk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2981618764574410311L;

	protected Integer idCertificatore;

	protected String anno;

	/** 
	 * Sets the value of idCertificatore
	 */
	public void setIdCertificatore(Integer idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/** 
	 * Gets the value of idCertificatore
	 */
	public Integer getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/** 
	 * Sets the value of anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/** 
	 * Gets the value of anno
	 */
	public String getAnno()
	{
		return this.anno;
	}

	/**
	 * Method 'SiceeWCertificatorePk'
	 * 
	 */
	public SiceeWCertificatorePk()
	{
	}

	/**
	 * Method 'SiceeWCertificatorePk'
	 * 
	 * @param idCertificatore
	 * @param anno
	 */
	public SiceeWCertificatorePk(final Integer idCertificatore, final String anno)
	{
		this.idCertificatore = idCertificatore;
		this.anno = anno;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeWCertificatorePk)) {
			return false;
		}
		
		final SiceeWCertificatorePk _cast = (SiceeWCertificatorePk) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeWCertificatorePk: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", anno=" + this.anno );
		return ret.toString();
	}

}
