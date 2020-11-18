/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDTipoPagamento implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2215530860574313629L;

	/** 
	 * This attribute maps to the column ID_TIPO_PAGAMENTO in the SICEE_D_TIPO_PAGAMENTO table.
	 */
	protected Integer idTipoPagamento;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_PAGAMENTO table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_PAGAM_ATTIVO in the SICEE_D_TIPO_PAGAMENTO table.
	 */
	protected String flgPagamAttivo;

	/**
	 * Method 'SiceeDTipoPagamento'
	 * 
	 */
	public SiceeDTipoPagamento()
	{
	}

	/**
	 * Method 'getIdTipoPagamento'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoPagamento()
	{
		return this.idTipoPagamento;
	}

	/**
	 * Method 'setIdTipoPagamento'
	 * 
	 * @param idTipoPagamento
	 */
	public void setIdTipoPagamento(Integer idTipoPagamento)
	{
		this.idTipoPagamento = idTipoPagamento;
	}

	/**
	 * Method 'getDescr'
	 * 
	 * @return String
	 */
	public String getDescr()
	{
		return this.descr;
	}

	/**
	 * Method 'setDescr'
	 * 
	 * @param descr
	 */
	public void setDescr(String descr)
	{
		this.descr = descr;
	}

	/**
	 * Method 'getFlgPagamAttivo'
	 * 
	 * @return String
	 */
	public String getFlgPagamAttivo()
	{
		return this.flgPagamAttivo;
	}

	/**
	 * Method 'setFlgPagamAttivo'
	 * 
	 * @param flgPagamAttivo
	 */
	public void setFlgPagamAttivo(String flgPagamAttivo)
	{
		this.flgPagamAttivo = flgPagamAttivo;
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
		
		if (!(_other instanceof SiceeDTipoPagamento)) {
			return false;
		}
		
		final SiceeDTipoPagamento _cast = (SiceeDTipoPagamento) _other;
		if (this.idTipoPagamento == null ? _cast.idTipoPagamento != this.idTipoPagamento : !this.idTipoPagamento.equals( _cast.idTipoPagamento )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.flgPagamAttivo == null ? _cast.flgPagamAttivo != this.flgPagamAttivo : !this.flgPagamAttivo.equals( _cast.flgPagamAttivo )) {
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
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.flgPagamAttivo != null) {
			_hashCode = 29 * _hashCode + this.flgPagamAttivo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoPagamentoPk
	 */
	public SiceeDTipoPagamentoPk createPk()
	{
		return new SiceeDTipoPagamentoPk(this.idTipoPagamento);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoPagamento: " );
		ret.append( "idTipoPagamento=" + this.idTipoPagamento );
		ret.append( ", descr=" + this.descr );
		ret.append( ", flgPagamAttivo=" + this.flgPagamAttivo );
		return ret.toString();
	}

}
