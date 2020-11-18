/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDGradiGiorno implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8276866639814953652L;

	/** 
	 * This attribute maps to the column COMUNE in the SICEE_D_GRADI_GIORNO table.
	 */
	protected String comune;

	/** 
	 * This attribute maps to the column ZONA_CLIMATICA in the SICEE_D_GRADI_GIORNO table.
	 */
	protected String zonaClimatica;

	/** 
	 * This attribute maps to the column GRADI_GIORNO in the SICEE_D_GRADI_GIORNO table.
	 */
	protected Integer gradiGiorno;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_D_GRADI_GIORNO table.
	 */
	protected String idComune;

	/**
	 * Method 'SiceeDGradiGiorno'
	 * 
	 */
	public SiceeDGradiGiorno()
	{
	}

	/**
	 * Method 'getComune'
	 * 
	 * @return String
	 */
	public String getComune()
	{
		return this.comune;
	}

	/**
	 * Method 'setComune'
	 * 
	 * @param comune
	 */
	public void setComune(String comune)
	{
		this.comune = comune;
	}

	/**
	 * Method 'getZonaClimatica'
	 * 
	 * @return String
	 */
	public String getZonaClimatica()
	{
		return this.zonaClimatica;
	}

	/**
	 * Method 'setZonaClimatica'
	 * 
	 * @param zonaClimatica
	 */
	public void setZonaClimatica(String zonaClimatica)
	{
		this.zonaClimatica = zonaClimatica;
	}

	/**
	 * Method 'getGradiGiorno'
	 * 
	 * @return Integer
	 */
	public Integer getGradiGiorno()
	{
		return this.gradiGiorno;
	}

	/**
	 * Method 'setGradiGiorno'
	 * 
	 * @param gradiGiorno
	 */
	public void setGradiGiorno(Integer gradiGiorno)
	{
		this.gradiGiorno = gradiGiorno;
	}

	/**
	 * Method 'getIdComune'
	 * 
	 * @return String
	 */
	public String getIdComune()
	{
		return this.idComune;
	}

	/**
	 * Method 'setIdComune'
	 * 
	 * @param idComune
	 */
	public void setIdComune(String idComune)
	{
		this.idComune = idComune;
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
		
		if (!(_other instanceof SiceeDGradiGiorno)) {
			return false;
		}
		
		final SiceeDGradiGiorno _cast = (SiceeDGradiGiorno) _other;
		if (this.comune == null ? _cast.comune != this.comune : !this.comune.equals( _cast.comune )) {
			return false;
		}
		
		if (this.zonaClimatica == null ? _cast.zonaClimatica != this.zonaClimatica : !this.zonaClimatica.equals( _cast.zonaClimatica )) {
			return false;
		}
		
		if (this.gradiGiorno == null ? _cast.gradiGiorno != this.gradiGiorno : !this.gradiGiorno.equals( _cast.gradiGiorno )) {
			return false;
		}
		
		if (this.idComune == null ? _cast.idComune != this.idComune : !this.idComune.equals( _cast.idComune )) {
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
		if (this.comune != null) {
			_hashCode = 29 * _hashCode + this.comune.hashCode();
		}
		
		if (this.zonaClimatica != null) {
			_hashCode = 29 * _hashCode + this.zonaClimatica.hashCode();
		}
		
		if (this.gradiGiorno != null) {
			_hashCode = 29 * _hashCode + this.gradiGiorno.hashCode();
		}
		
		if (this.idComune != null) {
			_hashCode = 29 * _hashCode + this.idComune.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDGradiGiornoPk
	 */
	public SiceeDGradiGiornoPk createPk()
	{
		return new SiceeDGradiGiornoPk(this.idComune);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno: " );
		ret.append( "comune=" + this.comune );
		ret.append( ", zonaClimatica=" + this.zonaClimatica );
		ret.append( ", gradiGiorno=" + this.gradiGiorno );
		ret.append( ", idComune=" + this.idComune );
		return ret.toString();
	}

}
