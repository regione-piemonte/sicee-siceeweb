/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_SISTEMA_RACC table.
 */
public class SiceeDSistemaRaccPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6521903818778364337L;
	protected String sistema;

	/** 
	 * Sets the value of sistema
	 */
	public void setSistema(String sistema)
	{
		this.sistema = sistema;
	}

	/** 
	 * Gets the value of sistema
	 */
	public String getSistema()
	{
		return this.sistema;
	}

	/**
	 * Method 'SiceeDSistemaRaccPk'
	 * 
	 */
	public SiceeDSistemaRaccPk()
	{
	}

	/**
	 * Method 'SiceeDSistemaRaccPk'
	 * 
	 * @param sistema
	 */
	public SiceeDSistemaRaccPk(final String sistema)
	{
		this.sistema = sistema;
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
		
		if (!(_other instanceof SiceeDSistemaRaccPk)) {
			return false;
		}
		
		final SiceeDSistemaRaccPk _cast = (SiceeDSistemaRaccPk) _other;
		if (this.sistema == null ? _cast.sistema != this.sistema : !this.sistema.equals( _cast.sistema )) {
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
		if (this.sistema != null) {
			_hashCode = 29 * _hashCode + this.sistema.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDSistemaRaccPk: " );
		ret.append( "sistema=" + this.sistema );
		return ret.toString();
	}

}
