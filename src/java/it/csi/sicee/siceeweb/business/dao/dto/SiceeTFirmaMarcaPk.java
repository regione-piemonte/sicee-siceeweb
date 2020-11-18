/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_FIRMA_MARCA table.
 */
public class SiceeTFirmaMarcaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6551106040152993214L;
	protected Long idFirmaMarca;

	/** 
	 * Sets the value of idFirmaMarca
	 */
	public void setIdFirmaMarca(Long idFirmaMarca)
	{
		this.idFirmaMarca = idFirmaMarca;
	}

	/** 
	 * Gets the value of idFirmaMarca
	 */
	public Long getIdFirmaMarca()
	{
		return this.idFirmaMarca;
	}

	/**
	 * Method 'SiceeTFirmaMarcaPk'
	 * 
	 */
	public SiceeTFirmaMarcaPk()
	{
	}

	/**
	 * Method 'SiceeTFirmaMarcaPk'
	 * 
	 * @param idFirmaMarca
	 */
	public SiceeTFirmaMarcaPk(final Long idFirmaMarca)
	{
		this.idFirmaMarca = idFirmaMarca;
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
		
		if (!(_other instanceof SiceeTFirmaMarcaPk)) {
			return false;
		}
		
		final SiceeTFirmaMarcaPk _cast = (SiceeTFirmaMarcaPk) _other;
		if (this.idFirmaMarca == null ? _cast.idFirmaMarca != this.idFirmaMarca : !this.idFirmaMarca.equals( _cast.idFirmaMarca )) {
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
		if (this.idFirmaMarca != null) {
			_hashCode = 29 * _hashCode + this.idFirmaMarca.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTFirmaMarcaPk: " );
		ret.append( "idFirmaMarca=" + this.idFirmaMarca );
		return ret.toString();
	}

}
