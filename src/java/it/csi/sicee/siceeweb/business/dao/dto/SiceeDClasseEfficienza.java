/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDClasseEfficienza implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1668801744920415602L;

	/** 
	 * This attribute maps to the column ID_CLASSE_EFF in the SICEE_D_CLASSE_EFFICIENZA table.
	 */
	protected Integer idClasseEff;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CLASSE_EFFICIENZA table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDClasseEfficienza'
	 * 
	 */
	public SiceeDClasseEfficienza()
	{
	}

	/**
	 * Method 'getIdClasseEff'
	 * 
	 * @return Integer
	 */
	public Integer getIdClasseEff()
	{
		return this.idClasseEff;
	}

	/**
	 * Method 'setIdClasseEff'
	 * 
	 * @param idClasseEff
	 */
	public void setIdClasseEff(Integer idClasseEff)
	{
		this.idClasseEff = idClasseEff;
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
		
		if (!(_other instanceof SiceeDClasseEfficienza)) {
			return false;
		}
		
		final SiceeDClasseEfficienza _cast = (SiceeDClasseEfficienza) _other;
		if (this.idClasseEff == null ? _cast.idClasseEff != this.idClasseEff : !this.idClasseEff.equals( _cast.idClasseEff )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
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
		if (this.idClasseEff != null) {
			_hashCode = 29 * _hashCode + this.idClasseEff.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDClasseEfficienzaPk
	 */
	public SiceeDClasseEfficienzaPk createPk()
	{
		return new SiceeDClasseEfficienzaPk(this.idClasseEff);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEfficienza: " );
		ret.append( "idClasseEff=" + this.idClasseEff );
		ret.append( ", descr=" + this.descr );
		return ret.toString();
	}

}
