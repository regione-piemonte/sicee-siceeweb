/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_SOSTITUZIONE table.
 */
public class SiceeTSostituzionePk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3728927968152216463L;

	protected Integer idSostituzione;

	protected Integer progrSostituzione;

	/** 
	 * Sets the value of idSostituzione
	 */
	public void setIdSostituzione(Integer idSostituzione)
	{
		this.idSostituzione = idSostituzione;
	}

	/** 
	 * Gets the value of idSostituzione
	 */
	public Integer getIdSostituzione()
	{
		return this.idSostituzione;
	}

	/** 
	 * Sets the value of progrSostituzione
	 */
	public void setProgrSostituzione(Integer progrSostituzione)
	{
		this.progrSostituzione = progrSostituzione;
	}

	/** 
	 * Gets the value of progrSostituzione
	 */
	public Integer getProgrSostituzione()
	{
		return this.progrSostituzione;
	}

	/**
	 * Method 'SiceeTSostituzionePk'
	 * 
	 */
	public SiceeTSostituzionePk()
	{
	}

	/**
	 * Method 'SiceeTSostituzionePk'
	 * 
	 * @param idSostituzione
	 * @param progrSostituzione
	 */
	public SiceeTSostituzionePk(final Integer idSostituzione, final Integer progrSostituzione)
	{
		this.idSostituzione = idSostituzione;
		this.progrSostituzione = progrSostituzione;
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
		
		if (!(_other instanceof SiceeTSostituzionePk)) {
			return false;
		}
		
		final SiceeTSostituzionePk _cast = (SiceeTSostituzionePk) _other;
		if (this.idSostituzione == null ? _cast.idSostituzione != this.idSostituzione : !this.idSostituzione.equals( _cast.idSostituzione )) {
			return false;
		}
		
		if (this.progrSostituzione == null ? _cast.progrSostituzione != this.progrSostituzione : !this.progrSostituzione.equals( _cast.progrSostituzione )) {
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
		if (this.idSostituzione != null) {
			_hashCode = 29 * _hashCode + this.idSostituzione.hashCode();
		}
		
		if (this.progrSostituzione != null) {
			_hashCode = 29 * _hashCode + this.progrSostituzione.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTSostituzionePk: " );
		ret.append( "idSostituzione=" + this.idSostituzione );
		ret.append( ", progrSostituzione=" + this.progrSostituzione );
		return ret.toString();
	}

}
