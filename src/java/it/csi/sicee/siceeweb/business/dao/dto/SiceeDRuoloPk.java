/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_RUOLO table.
 */
public class SiceeDRuoloPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1725888812262180705L;
	protected Integer idTipoRuolo;

	/** 
	 * Sets the value of idTipoRuolo
	 */
	public void setIdTipoRuolo(Integer idTipoRuolo)
	{
		this.idTipoRuolo = idTipoRuolo;
	}

	/** 
	 * Gets the value of idTipoRuolo
	 */
	public Integer getIdTipoRuolo()
	{
		return this.idTipoRuolo;
	}

	/**
	 * Method 'SiceeDRuoloPk'
	 * 
	 */
	public SiceeDRuoloPk()
	{
	}

	/**
	 * Method 'SiceeDRuoloPk'
	 * 
	 * @param idTipoRuolo
	 */
	public SiceeDRuoloPk(final Integer idTipoRuolo)
	{
		this.idTipoRuolo = idTipoRuolo;
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
		
		if (!(_other instanceof SiceeDRuoloPk)) {
			return false;
		}
		
		final SiceeDRuoloPk _cast = (SiceeDRuoloPk) _other;
		if (this.idTipoRuolo == null ? _cast.idTipoRuolo != this.idTipoRuolo : !this.idTipoRuolo.equals( _cast.idTipoRuolo )) {
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
		if (this.idTipoRuolo != null) {
			_hashCode = 29 * _hashCode + this.idTipoRuolo.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloPk: " );
		ret.append( "idTipoRuolo=" + this.idTipoRuolo );
		return ret.toString();
	}

}
