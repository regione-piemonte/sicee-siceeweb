/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeWEmailNewsletter implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3682326535760000109L;
	/** 
	 * This attribute maps to the column EMAIL in the SICEE_W_EMAIL_NEWSLETTER table.
	 */
	protected String email;

	/**
	 * Method 'SiceeWEmailNewsletter'
	 * 
	 */
	public SiceeWEmailNewsletter()
	{
	}

	/**
	 * Method 'getEmail'
	 * 
	 * @return String
	 */
	public String getEmail()
	{
		return this.email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
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
		
		if (!(_other instanceof SiceeWEmailNewsletter)) {
			return false;
		}
		
		final SiceeWEmailNewsletter _cast = (SiceeWEmailNewsletter) _other;
		if (this.email == null ? _cast.email != this.email : !this.email.equals( _cast.email )) {
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
		if (this.email != null) {
			_hashCode = 29 * _hashCode + this.email.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeWEmailNewsletter: " );
		ret.append( "email=" + this.email );
		return ret.toString();
	}

}
