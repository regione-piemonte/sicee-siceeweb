/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_MOTIVO_RILASCIO table.
 */
public class SiceeDMotivoRilascioPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -423765152874966366L;
	protected Integer idMotivo;

	/** 
	 * Sets the value of idMotivo
	 */
	public void setIdMotivo(Integer idMotivo)
	{
		this.idMotivo = idMotivo;
	}

	/** 
	 * Gets the value of idMotivo
	 */
	public Integer getIdMotivo()
	{
		return this.idMotivo;
	}

	/**
	 * Method 'SiceeDMotivoRilascioPk'
	 * 
	 */
	public SiceeDMotivoRilascioPk()
	{
	}

	/**
	 * Method 'SiceeDMotivoRilascioPk'
	 * 
	 * @param idMotivo
	 */
	public SiceeDMotivoRilascioPk(final Integer idMotivo)
	{
		this.idMotivo = idMotivo;
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
		
		if (!(_other instanceof SiceeDMotivoRilascioPk)) {
			return false;
		}
		
		final SiceeDMotivoRilascioPk _cast = (SiceeDMotivoRilascioPk) _other;
		if (this.idMotivo == null ? _cast.idMotivo != this.idMotivo : !this.idMotivo.equals( _cast.idMotivo )) {
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
		if (this.idMotivo != null) {
			_hashCode = 29 * _hashCode + this.idMotivo.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascioPk: " );
		ret.append( "idMotivo=" + this.idMotivo );
		return ret.toString();
	}

}
