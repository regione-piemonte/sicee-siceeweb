/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDCarattEdificio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3054389965968914187L;

	/** 
	 * This attribute maps to the column ID_CARATT_EDIFICIO in the SICEE_D_CARATT_EDIFICIO table.
	 */
	protected Integer idCarattEdificio;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CARATT_EDIFICIO table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FK_TIPO_EDIFICIO in the SICEE_D_CARATT_EDIFICIO table.
	 */
	protected Integer fkTipoEdificio;

	/**
	 * Method 'SiceeDCarattEdificio'
	 * 
	 */
	public SiceeDCarattEdificio()
	{
	}

	/**
	 * Method 'getIdCarattEdificio'
	 * 
	 * @return Integer
	 */
	public Integer getIdCarattEdificio()
	{
		return this.idCarattEdificio;
	}

	/**
	 * Method 'setIdCarattEdificio'
	 * 
	 * @param idCarattEdificio
	 */
	public void setIdCarattEdificio(Integer idCarattEdificio)
	{
		this.idCarattEdificio = idCarattEdificio;
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
	 * Method 'getFkTipoEdificio'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoEdificio()
	{
		return this.fkTipoEdificio;
	}

	/**
	 * Method 'setFkTipoEdificio'
	 * 
	 * @param fkTipoEdificio
	 */
	public void setFkTipoEdificio(Integer fkTipoEdificio)
	{
		this.fkTipoEdificio = fkTipoEdificio;
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
		
		if (!(_other instanceof SiceeDCarattEdificio)) {
			return false;
		}
		
		final SiceeDCarattEdificio _cast = (SiceeDCarattEdificio) _other;
		if (this.idCarattEdificio == null ? _cast.idCarattEdificio != this.idCarattEdificio : !this.idCarattEdificio.equals( _cast.idCarattEdificio )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.fkTipoEdificio == null ? _cast.fkTipoEdificio != this.fkTipoEdificio : !this.fkTipoEdificio.equals( _cast.fkTipoEdificio )) {
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
		if (this.idCarattEdificio != null) {
			_hashCode = 29 * _hashCode + this.idCarattEdificio.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.fkTipoEdificio != null) {
			_hashCode = 29 * _hashCode + this.fkTipoEdificio.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDCarattEdificioPk
	 */
	public SiceeDCarattEdificioPk createPk()
	{
		return new SiceeDCarattEdificioPk(this.idCarattEdificio);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDCarattEdificio: " );
		ret.append( "idCarattEdificio=" + this.idCarattEdificio );
		ret.append( ", descr=" + this.descr );
		ret.append( ", fkTipoEdificio=" + this.fkTipoEdificio );
		return ret.toString();
	}

}
