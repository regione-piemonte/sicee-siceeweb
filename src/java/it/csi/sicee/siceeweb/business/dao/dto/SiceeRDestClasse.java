/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeRDestClasse implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4480594611658671333L;

	/** 
	 * This attribute maps to the column ID_CLASSE in the SICEE_R_DEST_CLASSE table.
	 */
	protected Integer idClasse;

	/** 
	 * This attribute maps to the column ID_DEST_USO in the SICEE_R_DEST_CLASSE table.
	 */
	protected Integer idDestUso;

	/** 
	 * This attribute maps to the column MIN in the SICEE_R_DEST_CLASSE table.
	 */
	protected Integer min;

	/** 
	 * This attribute maps to the column MAX in the SICEE_R_DEST_CLASSE table.
	 */
	protected Integer max;

	/**
	 * Method 'SiceeRDestClasse'
	 * 
	 */
	public SiceeRDestClasse()
	{
	}

	/**
	 * Method 'getIdClasse'
	 * 
	 * @return Integer
	 */
	public Integer getIdClasse()
	{
		return this.idClasse;
	}

	/**
	 * Method 'setIdClasse'
	 * 
	 * @param idClasse
	 */
	public void setIdClasse(Integer idClasse)
	{
		this.idClasse = idClasse;
	}

	/**
	 * Method 'getIdDestUso'
	 * 
	 * @return Integer
	 */
	public Integer getIdDestUso()
	{
		return this.idDestUso;
	}

	/**
	 * Method 'setIdDestUso'
	 * 
	 * @param idDestUso
	 */
	public void setIdDestUso(Integer idDestUso)
	{
		this.idDestUso = idDestUso;
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
		
		if (!(_other instanceof SiceeRDestClasse)) {
			return false;
		}
		
		final SiceeRDestClasse _cast = (SiceeRDestClasse) _other;
		if (this.idClasse == null ? _cast.idClasse != this.idClasse : !this.idClasse.equals( _cast.idClasse )) {
			return false;
		}
		
		if (this.idDestUso == null ? _cast.idDestUso != this.idDestUso : !this.idDestUso.equals( _cast.idDestUso )) {
			return false;
		}
		
		if (this.min == null ? _cast.min != this.min : !this.min.equals( _cast.min )) {
			return false;
		}
		
		if (this.max == null ? _cast.max != this.max : !this.max.equals( _cast.max )) {
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
		if (this.idClasse != null) {
			_hashCode = 29 * _hashCode + this.idClasse.hashCode();
		}
		
		if (this.idDestUso != null) {
			_hashCode = 29 * _hashCode + this.idDestUso.hashCode();
		}
		
		if (this.min != null) {
			_hashCode = 29 * _hashCode + this.min.hashCode();
		}
		
		if (this.max != null) {
			_hashCode = 29 * _hashCode + this.max.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeRDestClassePk
	 */
	public SiceeRDestClassePk createPk()
	{
		return new SiceeRDestClassePk(this.idClasse, this.idDestUso);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClasse: " );
		ret.append( "idClasse=" + this.idClasse );
		ret.append( ", idDestUso=" + this.idDestUso );
		ret.append( ", min=" + this.min );
		ret.append( ", max=" + this.max );
		return ret.toString();
	}

}
