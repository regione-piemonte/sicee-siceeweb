/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTLimiteqhPiemonte implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8222763697122576L;

	/** 
	 * This attribute maps to the column VOLUME in the SICEE_T_LIMITEQH_PIEMONTE table.
	 */
	protected Integer volume;

	/** 
	 * This attribute maps to the column GG_3000 in the SICEE_T_LIMITEQH_PIEMONTE table.
	 */
	protected Double gg3000;

	/** 
	 * This attribute maps to the column GG_5000 in the SICEE_T_LIMITEQH_PIEMONTE table.
	 */
	protected Double gg5000;

	/** 
	 * This attribute maps to the column FLG_EDIFICIO in the SICEE_T_LIMITEQH_PIEMONTE table.
	 */
	protected String flgEdificio;

	/**
	 * Method 'SiceeTLimiteqhPiemonte'
	 * 
	 */
	public SiceeTLimiteqhPiemonte()
	{
	}

	/**
	 * Method 'getVolume'
	 * 
	 * @return Integer
	 */
	public Integer getVolume()
	{
		return this.volume;
	}

	/**
	 * Method 'setVolume'
	 * 
	 * @param volume
	 */
	public void setVolume(Integer volume)
	{
		this.volume = volume;
	}

	/**
	 * Method 'getGg3000'
	 * 
	 * @return Double
	 */
	public Double getGg3000()
	{
		return this.gg3000;
	}

	/**
	 * Method 'setGg3000'
	 * 
	 * @param gg3000
	 */
	public void setGg3000(Double gg3000)
	{
		this.gg3000 = gg3000;
	}

	/**
	 * Method 'getGg5000'
	 * 
	 * @return Double
	 */
	public Double getGg5000()
	{
		return this.gg5000;
	}

	/**
	 * Method 'setGg5000'
	 * 
	 * @param gg5000
	 */
	public void setGg5000(Double gg5000)
	{
		this.gg5000 = gg5000;
	}

	/**
	 * Method 'getFlgEdificio'
	 * 
	 * @return String
	 */
	public String getFlgEdificio()
	{
		return this.flgEdificio;
	}

	/**
	 * Method 'setFlgEdificio'
	 * 
	 * @param flgEdificio
	 */
	public void setFlgEdificio(String flgEdificio)
	{
		this.flgEdificio = flgEdificio;
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
		
		if (!(_other instanceof SiceeTLimiteqhPiemonte)) {
			return false;
		}
		
		final SiceeTLimiteqhPiemonte _cast = (SiceeTLimiteqhPiemonte) _other;
		if (this.volume == null ? _cast.volume != this.volume : !this.volume.equals( _cast.volume )) {
			return false;
		}
		
		if (this.gg3000 == null ? _cast.gg3000 != this.gg3000 : !this.gg3000.equals( _cast.gg3000 )) {
			return false;
		}
		
		if (this.gg5000 == null ? _cast.gg5000 != this.gg5000 : !this.gg5000.equals( _cast.gg5000 )) {
			return false;
		}
		
		if (this.flgEdificio == null ? _cast.flgEdificio != this.flgEdificio : !this.flgEdificio.equals( _cast.flgEdificio )) {
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
		if (this.volume != null) {
			_hashCode = 29 * _hashCode + this.volume.hashCode();
		}
		
		if (this.gg3000 != null) {
			_hashCode = 29 * _hashCode + this.gg3000.hashCode();
		}
		
		if (this.gg5000 != null) {
			_hashCode = 29 * _hashCode + this.gg5000.hashCode();
		}
		
		if (this.flgEdificio != null) {
			_hashCode = 29 * _hashCode + this.flgEdificio.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTLimiteqhPiemonte: " );
		ret.append( "volume=" + this.volume );
		ret.append( ", gg3000=" + this.gg3000 );
		ret.append( ", gg5000=" + this.gg5000 );
		ret.append( ", flgEdificio=" + this.flgEdificio );
		return ret.toString();
	}

}
