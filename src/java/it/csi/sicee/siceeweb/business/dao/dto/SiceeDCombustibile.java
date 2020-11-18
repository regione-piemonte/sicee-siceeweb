/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDCombustibile implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 557023014945151225L;

	/** 
	 * This attribute maps to the column ID_COMBUSTIBILE in the SICEE_D_COMBUSTIBILE table.
	 */
	protected Integer idCombustibile;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_COMBUSTIBILE table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FATTORE_EMISSIONE in the SICEE_D_COMBUSTIBILE table.
	 */
	protected Double fattoreEmissione;

	/** 
	 * This attribute maps to the column FLG_COMBO_RISCALD in the SICEE_D_COMBUSTIBILE table.
	 */
	protected String flgComboRiscald;

	/**
	 * Method 'SiceeDCombustibile'
	 * 
	 */
	public SiceeDCombustibile()
	{
	}

	/**
	 * Method 'getIdCombustibile'
	 * 
	 * @return Integer
	 */
	public Integer getIdCombustibile()
	{
		return this.idCombustibile;
	}

	/**
	 * Method 'setIdCombustibile'
	 * 
	 * @param idCombustibile
	 */
	public void setIdCombustibile(Integer idCombustibile)
	{
		this.idCombustibile = idCombustibile;
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
	 * Method 'getFattoreEmissione'
	 * 
	 * @return Double
	 */
	public Double getFattoreEmissione()
	{
		return this.fattoreEmissione;
	}

	/**
	 * Method 'setFattoreEmissione'
	 * 
	 * @param fattoreEmissione
	 */
	public void setFattoreEmissione(Double fattoreEmissione)
	{
		this.fattoreEmissione = fattoreEmissione;
	}

	/**
	 * Method 'getFlgComboRiscald'
	 * 
	 * @return String
	 */
	public String getFlgComboRiscald()
	{
		return this.flgComboRiscald;
	}

	/**
	 * Method 'setFlgComboRiscald'
	 * 
	 * @param flgComboRiscald
	 */
	public void setFlgComboRiscald(String flgComboRiscald)
	{
		this.flgComboRiscald = flgComboRiscald;
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
		
		if (!(_other instanceof SiceeDCombustibile)) {
			return false;
		}
		
		final SiceeDCombustibile _cast = (SiceeDCombustibile) _other;
		if (this.idCombustibile == null ? _cast.idCombustibile != this.idCombustibile : !this.idCombustibile.equals( _cast.idCombustibile )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.fattoreEmissione == null ? _cast.fattoreEmissione != this.fattoreEmissione : !this.fattoreEmissione.equals( _cast.fattoreEmissione )) {
			return false;
		}
		
		if (this.flgComboRiscald == null ? _cast.flgComboRiscald != this.flgComboRiscald : !this.flgComboRiscald.equals( _cast.flgComboRiscald )) {
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
		if (this.idCombustibile != null) {
			_hashCode = 29 * _hashCode + this.idCombustibile.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.fattoreEmissione != null) {
			_hashCode = 29 * _hashCode + this.fattoreEmissione.hashCode();
		}
		
		if (this.flgComboRiscald != null) {
			_hashCode = 29 * _hashCode + this.flgComboRiscald.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDCombustibilePk
	 */
	public SiceeDCombustibilePk createPk()
	{
		return new SiceeDCombustibilePk(this.idCombustibile);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile: " );
		ret.append( "idCombustibile=" + this.idCombustibile );
		ret.append( ", descr=" + this.descr );
		ret.append( ", fattoreEmissione=" + this.fattoreEmissione );
		ret.append( ", flgComboRiscald=" + this.flgComboRiscald );
		return ret.toString();
	}

}
