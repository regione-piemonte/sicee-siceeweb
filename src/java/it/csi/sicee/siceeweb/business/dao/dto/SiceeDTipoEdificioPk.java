/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_EDIFICIO table.
 */
public class SiceeDTipoEdificioPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5424709848263690940L;
	protected Integer idTipoEdificio;

	/** 
	 * Sets the value of idTipoEdificio
	 */
	public void setIdTipoEdificio(Integer idTipoEdificio)
	{
		this.idTipoEdificio = idTipoEdificio;
	}

	/** 
	 * Gets the value of idTipoEdificio
	 */
	public Integer getIdTipoEdificio()
	{
		return this.idTipoEdificio;
	}

	/**
	 * Method 'SiceeDTipoEdificioPk'
	 * 
	 */
	public SiceeDTipoEdificioPk()
	{
	}

	/**
	 * Method 'SiceeDTipoEdificioPk'
	 * 
	 * @param idTipoEdificio
	 */
	public SiceeDTipoEdificioPk(final Integer idTipoEdificio)
	{
		this.idTipoEdificio = idTipoEdificio;
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
		
		if (!(_other instanceof SiceeDTipoEdificioPk)) {
			return false;
		}
		
		final SiceeDTipoEdificioPk _cast = (SiceeDTipoEdificioPk) _other;
		if (this.idTipoEdificio == null ? _cast.idTipoEdificio != this.idTipoEdificio : !this.idTipoEdificio.equals( _cast.idTipoEdificio )) {
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
		if (this.idTipoEdificio != null) {
			_hashCode = 29 * _hashCode + this.idTipoEdificio.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoEdificioPk: " );
		ret.append( "idTipoEdificio=" + this.idTipoEdificio );
		return ret.toString();
	}

}
