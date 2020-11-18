/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_LIMITEQH_PIEMONTE table.
 */
public class SiceeTLimiteqhPiemontePk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6916520040740230088L;

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
		
		if (!(_other instanceof SiceeTLimiteqhPiemontePk)) {
			return false;
		}
		
		final SiceeTLimiteqhPiemontePk _cast = (SiceeTLimiteqhPiemontePk) _other;
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTLimiteqhPiemontePk: " );
		return ret.toString();
	}

}
