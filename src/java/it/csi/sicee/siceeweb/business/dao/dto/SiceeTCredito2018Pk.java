/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_CREDITO_2018 table.
 */
public class SiceeTCredito2018Pk implements Serializable
{
	protected long idCredito;

	/** 
	 * This attribute represents whether the primitive attribute idCredito is null.
	 */
	protected boolean idCreditoNull;

	/** 
	 * Sets the value of idCredito
	 */
	public void setIdCredito(long idCredito)
	{
		this.idCredito = idCredito;
	}

	/** 
	 * Gets the value of idCredito
	 */
	public long getIdCredito()
	{
		return idCredito;
	}

	/**
	 * Method 'SiceeTCredito2018Pk'
	 * 
	 */
	public SiceeTCredito2018Pk()
	{
	}

	/**
	 * Method 'SiceeTCredito2018Pk'
	 * 
	 * @param idCredito
	 */
	public SiceeTCredito2018Pk(final long idCredito)
	{
		this.idCredito = idCredito;
	}

	/** 
	 * Sets the value of idCreditoNull
	 */
	public void setIdCreditoNull(boolean idCreditoNull)
	{
		this.idCreditoNull = idCreditoNull;
	}

	/** 
	 * Gets the value of idCreditoNull
	 */
	public boolean isIdCreditoNull()
	{
		return idCreditoNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeTCredito2018Pk)) {
			return false;
		}
		
		final SiceeTCredito2018Pk _cast = (SiceeTCredito2018Pk) _other;
		if (idCredito != _cast.idCredito) {
			return false;
		}
		
		if (idCreditoNull != _cast.idCreditoNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + (int) (idCredito ^ (idCredito >>> 32));
		_hashCode = 29 * _hashCode + (idCreditoNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018Pk: " );
		ret.append( "idCredito=" + idCredito );
		return ret.toString();
	}

}
