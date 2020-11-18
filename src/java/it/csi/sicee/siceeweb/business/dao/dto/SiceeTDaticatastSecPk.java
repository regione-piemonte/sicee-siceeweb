/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_DATICATAST_SEC table.
 */
public class SiceeTDaticatastSecPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2179874078863251761L;
	protected Integer idDaticatastSec;

	/** 
	 * Sets the value of idDaticatastSec
	 */
	public void setIdDaticatastSec(Integer idDaticatastSec)
	{
		this.idDaticatastSec = idDaticatastSec;
	}

	/** 
	 * Gets the value of idDaticatastSec
	 */
	public Integer getIdDaticatastSec()
	{
		return this.idDaticatastSec;
	}

	/**
	 * Method 'SiceeTDaticatastSecPk'
	 * 
	 */
	public SiceeTDaticatastSecPk()
	{
	}

	/**
	 * Method 'SiceeTDaticatastSecPk'
	 * 
	 * @param idDaticatastSec
	 */
	public SiceeTDaticatastSecPk(final Integer idDaticatastSec)
	{
		this.idDaticatastSec = idDaticatastSec;
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
		
		if (!(_other instanceof SiceeTDaticatastSecPk)) {
			return false;
		}
		
		final SiceeTDaticatastSecPk _cast = (SiceeTDaticatastSecPk) _other;
		if (this.idDaticatastSec == null ? _cast.idDaticatastSec != this.idDaticatastSec : !this.idDaticatastSec.equals( _cast.idDaticatastSec )) {
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
		if (this.idDaticatastSec != null) {
			_hashCode = 29 * _hashCode + this.idDaticatastSec.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSecPk: " );
		ret.append( "idDaticatastSec=" + this.idDaticatastSec );
		return ret.toString();
	}

}
