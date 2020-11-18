/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDMotivoSost implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 361144258809713239L;

	/** 
	 * This attribute maps to the column ID_MOTIVO_SOST in the SICEE_D_MOTIVO_SOST table.
	 */
	protected Integer idMotivoSost;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_MOTIVO_SOST table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column MIN in the SICEE_D_MOTIVO_SOST table.
	 */
	protected Integer min;

	/** 
	 * This attribute maps to the column MAX in the SICEE_D_MOTIVO_SOST table.
	 */
	protected Integer max;

	/** 
	 * This attribute maps to the column FLG_VISIBILE_COMBO in the SICEE_D_MOTIVO_SOST table.
	 */
	protected String flgCombo;

	/**
	 * Method 'SiceeDMotivoSost'
	 * 
	 */
	public SiceeDMotivoSost()
	{
	}

	/**
	 * Method 'getIdMotivoSost'
	 * 
	 * @return Integer
	 */
	public Integer getIdMotivoSost()
	{
		return this.idMotivoSost;
	}

	/**
	 * Method 'setIdMotivoSost'
	 * 
	 * @param idMotivoSost
	 */
	public void setIdMotivoSost(Integer idMotivoSost)
	{
		this.idMotivoSost = idMotivoSost;
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
	 * Method 'getMin'
	 * 
	 * @return Integer
	 */
	public Integer getMin()
	{
		return this.min;
	}

	/**
	 * Method 'setMin'
	 * 
	 * @param min
	 */
	public void setMin(Integer min)
	{
		this.min = min;
	}

	/**
	 * Method 'getMax'
	 * 
	 * @return Integer
	 */
	public Integer getMax()
	{
		return this.max;
	}

	/**
	 * Method 'setMax'
	 * 
	 * @param max
	 */
	public void setMax(Integer max)
	{
		this.max = max;
	}

	/**
	 * Method 'getFlgCombo'
	 * 
	 * @return String
	 */
	public String getFlgCombo()
	{
		return this.flgCombo;
	}

	/**
	 * Method 'setFlgCombo'
	 * 
	 * @param flgCombo
	 */
	public void setFlgCombo(String flgCombo)
	{
		this.flgCombo = flgCombo;
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
		
		if (!(_other instanceof SiceeDMotivoSost)) {
			return false;
		}
		
		final SiceeDMotivoSost _cast = (SiceeDMotivoSost) _other;
		if (this.idMotivoSost == null ? _cast.idMotivoSost != this.idMotivoSost : !this.idMotivoSost.equals( _cast.idMotivoSost )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.min == null ? _cast.min != this.min : !this.min.equals( _cast.min )) {
			return false;
		}
		
		if (this.max == null ? _cast.max != this.max : !this.max.equals( _cast.max )) {
			return false;
		}
		
		if (this.flgCombo == null ? _cast.flgCombo != this.flgCombo : !this.flgCombo.equals( _cast.flgCombo )) {
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
		if (this.idMotivoSost != null) {
			_hashCode = 29 * _hashCode + this.idMotivoSost.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.min != null) {
			_hashCode = 29 * _hashCode + this.min.hashCode();
		}
		
		if (this.max != null) {
			_hashCode = 29 * _hashCode + this.max.hashCode();
		}
		
		if (this.flgCombo != null) {
			_hashCode = 29 * _hashCode + this.flgCombo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDMotivoSostPk
	 */
	public SiceeDMotivoSostPk createPk()
	{
		return new SiceeDMotivoSostPk(this.idMotivoSost);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoSost: " );
		ret.append( "idMotivoSost=" + this.idMotivoSost );
		ret.append( ", descr=" + this.descr );
		ret.append( ", min=" + this.min );
		ret.append( ", max=" + this.max );
		ret.append( ", flgCombo=" + this.flgCombo );
		return ret.toString();
	}

}
