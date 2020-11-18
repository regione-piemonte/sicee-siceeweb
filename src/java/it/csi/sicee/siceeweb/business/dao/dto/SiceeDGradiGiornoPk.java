/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_GRADI_GIORNO table.
 */
public class SiceeDGradiGiornoPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4002133297925074587L;
	protected String idComune;

	/** 
	 * Sets the value of idComune
	 */
	public void setIdComune(String idComune)
	{
		this.idComune = idComune;
	}

	/** 
	 * Gets the value of idComune
	 */
	public String getIdComune()
	{
		return this.idComune;
	}

	/**
	 * Method 'SiceeDGradiGiornoPk'
	 * 
	 */
	public SiceeDGradiGiornoPk()
	{
	}

	/**
	 * Method 'SiceeDGradiGiornoPk'
	 * 
	 * @param idComune
	 */
	public SiceeDGradiGiornoPk(final String idComune)
	{
		this.idComune = idComune;
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
		
		if (!(_other instanceof SiceeDGradiGiornoPk)) {
			return false;
		}
		
		final SiceeDGradiGiornoPk _cast = (SiceeDGradiGiornoPk) _other;
		if (this.idComune == null ? _cast.idComune != this.idComune : !this.idComune.equals( _cast.idComune )) {
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
		if (this.idComune != null) {
			_hashCode = 29 * _hashCode + this.idComune.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiornoPk: " );
		ret.append( "idComune=" + this.idComune );
		return ret.toString();
	}

}
