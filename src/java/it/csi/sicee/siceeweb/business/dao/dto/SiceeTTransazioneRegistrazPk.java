/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_TRANSAZIONE_REGISTRAZ table.
 */
public class SiceeTTransazioneRegistrazPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4615649175659217906L;

	protected long idTransazioneReg;

	/** 
	 * This attribute represents whether the primitive attribute idTransazioneReg is null.
	 */
	protected boolean idTransazioneRegNull;

	/** 
	 * Sets the value of idTransazioneReg
	 */
	public void setIdTransazioneReg(long idTransazioneReg)
	{
		this.idTransazioneReg = idTransazioneReg;
	}

	/** 
	 * Gets the value of idTransazioneReg
	 */
	public long getIdTransazioneReg()
	{
		return this.idTransazioneReg;
	}

	/**
	 * Method 'SiceeTTransazioneRegistrazPk'
	 * 
	 */
	public SiceeTTransazioneRegistrazPk()
	{
	}

	/**
	 * Method 'SiceeTTransazioneRegistrazPk'
	 * 
	 * @param idTransazioneReg
	 */
	public SiceeTTransazioneRegistrazPk(final long idTransazioneReg)
	{
		this.idTransazioneReg = idTransazioneReg;
	}

	/** 
	 * Sets the value of idTransazioneRegNull
	 */
	public void setIdTransazioneRegNull(boolean idTransazioneRegNull)
	{
		this.idTransazioneRegNull = idTransazioneRegNull;
	}

	/** 
	 * Gets the value of idTransazioneRegNull
	 */
	public boolean isIdTransazioneRegNull()
	{
		return this.idTransazioneRegNull;
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
		
		if (!(_other instanceof SiceeTTransazioneRegistrazPk)) {
			return false;
		}
		
		final SiceeTTransazioneRegistrazPk _cast = (SiceeTTransazioneRegistrazPk) _other;
		if (this.idTransazioneReg != _cast.idTransazioneReg) {
			return false;
		}
		
		if (this.idTransazioneRegNull != _cast.idTransazioneRegNull) {
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
		_hashCode = 29 * _hashCode + (int) (this.idTransazioneReg ^ (this.idTransazioneReg >>> 32));
		_hashCode = 29 * _hashCode + (this.idTransazioneRegNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistrazPk: " );
		ret.append( "idTransazioneReg=" + this.idTransazioneReg );
		return ret.toString();
	}

}
