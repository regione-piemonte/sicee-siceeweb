/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDSistemaRacc implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5665682714466336828L;
	/** 
	 * This attribute maps to the column SISTEMA in the SICEE_D_SISTEMA_RACC table.
	 */
	protected String sistema;

	/**
	 * Method 'SiceeDSistemaRacc'
	 * 
	 */
	public SiceeDSistemaRacc()
	{
	}

	/**
	 * Method 'getSistema'
	 * 
	 * @return String
	 */
	public String getSistema()
	{
		return this.sistema;
	}

	/**
	 * Method 'setSistema'
	 * 
	 * @param sistema
	 */
	public void setSistema(String sistema)
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
		
		if (!(_other instanceof SiceeDSistemaRacc)) {
			return false;
		}
		
		final SiceeDSistemaRacc _cast = (SiceeDSistemaRacc) _other;
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
	 * Method 'createPk'
	 * 
	 * @return SiceeDSistemaRaccPk
	 */
	public SiceeDSistemaRaccPk createPk()
	{
		return new SiceeDSistemaRaccPk(this.sistema);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDSistemaRacc: " );
		ret.append( "sistema=" + this.sistema );
		return ret.toString();
	}

}
