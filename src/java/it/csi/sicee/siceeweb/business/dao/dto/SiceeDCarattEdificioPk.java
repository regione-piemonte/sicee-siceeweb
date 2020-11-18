/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_CARATT_EDIFICIO table.
 */
public class SiceeDCarattEdificioPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4245033730392219405L;
	protected Integer idCarattEdificio;

	/** 
	 * Sets the value of idCarattEdificio
	 */
	public void setIdCarattEdificio(Integer idCarattEdificio)
	{
		this.idCarattEdificio = idCarattEdificio;
	}

	/** 
	 * Gets the value of idCarattEdificio
	 */
	public Integer getIdCarattEdificio()
	{
		return this.idCarattEdificio;
	}

	/**
	 * Method 'SiceeDCarattEdificioPk'
	 * 
	 */
	public SiceeDCarattEdificioPk()
	{
	}

	/**
	 * Method 'SiceeDCarattEdificioPk'
	 * 
	 * @param idCarattEdificio
	 */
	public SiceeDCarattEdificioPk(final Integer idCarattEdificio)
	{
		this.idCarattEdificio = idCarattEdificio;
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
		
		if (!(_other instanceof SiceeDCarattEdificioPk)) {
			return false;
		}
		
		final SiceeDCarattEdificioPk _cast = (SiceeDCarattEdificioPk) _other;
		if (this.idCarattEdificio == null ? _cast.idCarattEdificio != this.idCarattEdificio : !this.idCarattEdificio.equals( _cast.idCarattEdificio )) {
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
		if (this.idCarattEdificio != null) {
			_hashCode = 29 * _hashCode + this.idCarattEdificio.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDCarattEdificioPk: " );
		ret.append( "idCarattEdificio=" + this.idCarattEdificio );
		return ret.toString();
	}

}
