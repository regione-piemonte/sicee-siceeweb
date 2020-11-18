/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_DATI_ESAMI table.
 */
public class SiceeTDatiEsamiPk implements Serializable
{
	protected Integer idDatiEsami;

	/** 
	 * Sets the value of idDatiEsami
	 */
	public void setIdDatiEsami(Integer idDatiEsami)
	{
		this.idDatiEsami = idDatiEsami;
	}

	/** 
	 * Gets the value of idDatiEsami
	 */
	public Integer getIdDatiEsami()
	{
		return idDatiEsami;
	}

	/**
	 * Method 'SiceeTDatiEsamiPk'
	 * 
	 */
	public SiceeTDatiEsamiPk()
	{
	}

	/**
	 * Method 'SiceeTDatiEsamiPk'
	 * 
	 * @param idDatiEsami
	 */
	public SiceeTDatiEsamiPk(final Integer idDatiEsami)
	{
		this.idDatiEsami = idDatiEsami;
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
		
		if (!(_other instanceof SiceeTDatiEsamiPk)) {
			return false;
		}
		
		final SiceeTDatiEsamiPk _cast = (SiceeTDatiEsamiPk) _other;
		if (idDatiEsami == null ? _cast.idDatiEsami != idDatiEsami : !idDatiEsami.equals( _cast.idDatiEsami )) {
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
		if (idDatiEsami != null) {
			_hashCode = 29 * _hashCode + idDatiEsami.hashCode();
		}
		
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsamiPk: " );
		ret.append( "idDatiEsami=" + idDatiEsami );
		return ret.toString();
	}

}
