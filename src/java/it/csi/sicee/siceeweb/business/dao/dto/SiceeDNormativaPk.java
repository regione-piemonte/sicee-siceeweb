/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_NORMATIVA table.
 */
public class SiceeDNormativaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5041971771800731873L;
	protected Integer idNorma;

	/** 
	 * Sets the value of idNorma
	 */
	public void setIdNorma(Integer idNorma)
	{
		this.idNorma = idNorma;
	}

	/** 
	 * Gets the value of idNorma
	 */
	public Integer getIdNorma()
	{
		return this.idNorma;
	}

	/**
	 * Method 'SiceeDNormativaPk'
	 * 
	 */
	public SiceeDNormativaPk()
	{
	}

	/**
	 * Method 'SiceeDNormativaPk'
	 * 
	 * @param idNorma
	 */
	public SiceeDNormativaPk(final Integer idNorma)
	{
		this.idNorma = idNorma;
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
		
		if (!(_other instanceof SiceeDNormativaPk)) {
			return false;
		}
		
		final SiceeDNormativaPk _cast = (SiceeDNormativaPk) _other;
		if (this.idNorma == null ? _cast.idNorma != this.idNorma : !this.idNorma.equals( _cast.idNorma )) {
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
		if (this.idNorma != null) {
			_hashCode = 29 * _hashCode + this.idNorma.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDNormativaPk: " );
		ret.append( "idNorma=" + this.idNorma );
		return ret.toString();
	}

}
