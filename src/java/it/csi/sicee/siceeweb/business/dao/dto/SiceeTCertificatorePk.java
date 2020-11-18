/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_CERTIFICATORE table.
 */
public class SiceeTCertificatorePk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2801980096954484412L;
	protected String idCertificatore;

	/** 
	 * Sets the value of idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/** 
	 * Gets the value of idCertificatore
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/**
	 * Method 'SiceeTCertificatorePk'
	 * 
	 */
	public SiceeTCertificatorePk()
	{
	}

	/**
	 * Method 'SiceeTCertificatorePk'
	 * 
	 * @param idCertificatore
	 */
	public SiceeTCertificatorePk(final String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
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
		
		if (!(_other instanceof SiceeTCertificatorePk)) {
			return false;
		}
		
		final SiceeTCertificatorePk _cast = (SiceeTCertificatorePk) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatorePk: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		return ret.toString();
	}

}
