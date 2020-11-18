/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_AZIENDA table.
 */
public class SiceeTAziendaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1893546527389796958L;

	protected long idAzienda;

	/** 
	 * This attribute represents whether the primitive attribute idAzienda is null.
	 */
	protected boolean idAziendaNull;

	/** 
	 * Sets the value of idAzienda
	 */
	public void setIdAzienda(long idAzienda)
	{
		this.idAzienda = idAzienda;
	}

	/** 
	 * Gets the value of idAzienda
	 */
	public long getIdAzienda()
	{
		return this.idAzienda;
	}

	/**
	 * Method 'SiceeTAziendaPk'
	 * 
	 */
	public SiceeTAziendaPk()
	{
	}

	/**
	 * Method 'SiceeTAziendaPk'
	 * 
	 * @param idAzienda
	 */
	public SiceeTAziendaPk(final long idAzienda)
	{
		this.idAzienda = idAzienda;
	}

	/** 
	 * Sets the value of idAziendaNull
	 */
	public void setIdAziendaNull(boolean idAziendaNull)
	{
		this.idAziendaNull = idAziendaNull;
	}

	/** 
	 * Gets the value of idAziendaNull
	 */
	public boolean isIdAziendaNull()
	{
		return this.idAziendaNull;
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
		
		if (!(_other instanceof SiceeTAziendaPk)) {
			return false;
		}
		
		final SiceeTAziendaPk _cast = (SiceeTAziendaPk) _other;
		if (this.idAzienda != _cast.idAzienda) {
			return false;
		}
		
		if (this.idAziendaNull != _cast.idAziendaNull) {
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
		_hashCode = 29 * _hashCode + (int) (this.idAzienda ^ (this.idAzienda >>> 32));
		_hashCode = 29 * _hashCode + (this.idAziendaNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTAziendaPk: " );
		ret.append( "idAzienda=" + this.idAzienda );
		return ret.toString();
	}

}
