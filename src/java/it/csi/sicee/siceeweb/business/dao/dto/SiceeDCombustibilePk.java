/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_COMBUSTIBILE table.
 */
public class SiceeDCombustibilePk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1974903162881151960L;
	protected Integer idCombustibile;

	/** 
	 * Sets the value of idCombustibile
	 */
	public void setIdCombustibile(Integer idCombustibile)
	{
		this.idCombustibile = idCombustibile;
	}

	/** 
	 * Gets the value of idCombustibile
	 */
	public Integer getIdCombustibile()
	{
		return this.idCombustibile;
	}

	/**
	 * Method 'SiceeDCombustibilePk'
	 * 
	 */
	public SiceeDCombustibilePk()
	{
	}

	/**
	 * Method 'SiceeDCombustibilePk'
	 * 
	 * @param idCombustibile
	 */
	public SiceeDCombustibilePk(final Integer idCombustibile)
	{
		this.idCombustibile = idCombustibile;
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
		
		if (!(_other instanceof SiceeDCombustibilePk)) {
			return false;
		}
		
		final SiceeDCombustibilePk _cast = (SiceeDCombustibilePk) _other;
		if (this.idCombustibile == null ? _cast.idCombustibile != this.idCombustibile : !this.idCombustibile.equals( _cast.idCombustibile )) {
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
		if (this.idCombustibile != null) {
			_hashCode = 29 * _hashCode + this.idCombustibile.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibilePk: " );
		ret.append( "idCombustibile=" + this.idCombustibile );
		return ret.toString();
	}

}
