/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_MOTIVO_SOST table.
 */
public class SiceeDMotivoSostPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6965634321780331165L;
	protected Integer idMotivoSost;

	/** 
	 * Sets the value of idMotivoSost
	 */
	public void setIdMotivoSost(Integer idMotivoSost)
	{
		this.idMotivoSost = idMotivoSost;
	}

	/** 
	 * Gets the value of idMotivoSost
	 */
	public Integer getIdMotivoSost()
	{
		return this.idMotivoSost;
	}

	/**
	 * Method 'SiceeDMotivoSostPk'
	 * 
	 */
	public SiceeDMotivoSostPk()
	{
	}

	/**
	 * Method 'SiceeDMotivoSostPk'
	 * 
	 * @param idMotivoSost
	 */
	public SiceeDMotivoSostPk(final Integer idMotivoSost)
	{
		this.idMotivoSost = idMotivoSost;
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
		
		if (!(_other instanceof SiceeDMotivoSostPk)) {
			return false;
		}
		
		final SiceeDMotivoSostPk _cast = (SiceeDMotivoSostPk) _other;
		if (this.idMotivoSost == null ? _cast.idMotivoSost != this.idMotivoSost : !this.idMotivoSost.equals( _cast.idMotivoSost )) {
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
		if (this.idMotivoSost != null) {
			_hashCode = 29 * _hashCode + this.idMotivoSost.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoSostPk: " );
		ret.append( "idMotivoSost=" + this.idMotivoSost );
		return ret.toString();
	}

}
