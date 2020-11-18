/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_PRIORITA table.
 */
public class SiceeDPrioritaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -875665520629716725L;
	protected String priorita;

	/** 
	 * Sets the value of priorita
	 */
	public void setPriorita(String priorita)
	{
		this.priorita = priorita;
	}

	/** 
	 * Gets the value of priorita
	 */
	public String getPriorita()
	{
		return this.priorita;
	}

	/**
	 * Method 'SiceeDPrioritaPk'
	 * 
	 */
	public SiceeDPrioritaPk()
	{
	}

	/**
	 * Method 'SiceeDPrioritaPk'
	 * 
	 * @param priorita
	 */
	public SiceeDPrioritaPk(final String priorita)
	{
		this.priorita = priorita;
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
		
		if (!(_other instanceof SiceeDPrioritaPk)) {
			return false;
		}
		
		final SiceeDPrioritaPk _cast = (SiceeDPrioritaPk) _other;
		if (this.priorita == null ? _cast.priorita != this.priorita : !this.priorita.equals( _cast.priorita )) {
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
		if (this.priorita != null) {
			_hashCode = 29 * _hashCode + this.priorita.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDPrioritaPk: " );
		ret.append( "priorita=" + this.priorita );
		return ret.toString();
	}

}
