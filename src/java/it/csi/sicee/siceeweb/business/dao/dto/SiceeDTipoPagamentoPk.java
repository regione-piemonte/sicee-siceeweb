/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_PAGAMENTO table.
 */
public class SiceeDTipoPagamentoPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4824663975095228990L;
	protected Integer idTipoPagamento;

	/** 
	 * Sets the value of idTipoPagamento
	 */
	public void setIdTipoPagamento(Integer idTipoPagamento)
	{
		this.idTipoPagamento = idTipoPagamento;
	}

	/** 
	 * Gets the value of idTipoPagamento
	 */
	public Integer getIdTipoPagamento()
	{
		return this.idTipoPagamento;
	}

	/**
	 * Method 'SiceeDTipoPagamentoPk'
	 * 
	 */
	public SiceeDTipoPagamentoPk()
	{
	}

	/**
	 * Method 'SiceeDTipoPagamentoPk'
	 * 
	 * @param idTipoPagamento
	 */
	public SiceeDTipoPagamentoPk(final Integer idTipoPagamento)
	{
		this.idTipoPagamento = idTipoPagamento;
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
		
		if (!(_other instanceof SiceeDTipoPagamentoPk)) {
			return false;
		}
		
		final SiceeDTipoPagamentoPk _cast = (SiceeDTipoPagamentoPk) _other;
		if (this.idTipoPagamento == null ? _cast.idTipoPagamento != this.idTipoPagamento : !this.idTipoPagamento.equals( _cast.idTipoPagamento )) {
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
		if (this.idTipoPagamento != null) {
			_hashCode = 29 * _hashCode + this.idTipoPagamento.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoPagamentoPk: " );
		ret.append( "idTipoPagamento=" + this.idTipoPagamento );
		return ret.toString();
	}

}
