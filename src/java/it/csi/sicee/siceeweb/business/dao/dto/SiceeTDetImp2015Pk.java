/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_DET_IMP_2015 table.
 */
public class SiceeTDetImp2015Pk implements Serializable
{
	protected long idDettaglioImp;

	/** 
	 * This attribute represents whether the primitive attribute idDettaglioImp is null.
	 */
	protected boolean idDettaglioImpNull;

	/** 
	 * Sets the value of idDettaglioImp
	 */
	public void setIdDettaglioImp(long idDettaglioImp)
	{
		this.idDettaglioImp = idDettaglioImp;
	}

	/** 
	 * Gets the value of idDettaglioImp
	 */
	public long getIdDettaglioImp()
	{
		return idDettaglioImp;
	}

	/**
	 * Method 'SiceeTDetImp2015Pk'
	 * 
	 */
	public SiceeTDetImp2015Pk()
	{
	}

	/**
	 * Method 'SiceeTDetImp2015Pk'
	 * 
	 * @param idDettaglioImp
	 */
	public SiceeTDetImp2015Pk(final long idDettaglioImp)
	{
		this.idDettaglioImp = idDettaglioImp;
	}

	/** 
	 * Sets the value of idDettaglioImpNull
	 */
	public void setIdDettaglioImpNull(boolean idDettaglioImpNull)
	{
		this.idDettaglioImpNull = idDettaglioImpNull;
	}

	/** 
	 * Gets the value of idDettaglioImpNull
	 */
	public boolean isIdDettaglioImpNull()
	{
		return idDettaglioImpNull;
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
		
		if (!(_other instanceof SiceeTDetImp2015Pk)) {
			return false;
		}
		
		final SiceeTDetImp2015Pk _cast = (SiceeTDetImp2015Pk) _other;
		if (idDettaglioImp != _cast.idDettaglioImp) {
			return false;
		}
		
		if (idDettaglioImpNull != _cast.idDettaglioImpNull) {
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
		_hashCode = 29 * _hashCode + (int) (idDettaglioImp ^ (idDettaglioImp >>> 32));
		_hashCode = 29 * _hashCode + (idDettaglioImpNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015Pk: " );
		ret.append( "idDettaglioImp=" + idDettaglioImp );
		return ret.toString();
	}

}
