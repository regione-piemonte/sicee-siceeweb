/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_R_CERT_RUOLI table.
 */
public class SiceeRCertRuoliPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6573659381226840217L;

	protected String idCertificatore;

	protected String progr;

	protected String anno;

	protected Integer fkRuoloEdificio;

	/** 
	 * Sets the value of idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/** 
	 * Gets the value of idCertificatore
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/** 
	 * Sets the value of progr
	 */
	public void setProgr(String progr)
	{
		this.progr = progr;
	}

	/** 
	 * Gets the value of progr
	 */
	public String getProgr()
	{
		return this.progr;
	}

	/** 
	 * Sets the value of anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/** 
	 * Gets the value of anno
	 */
	public String getAnno()
	{
		return this.anno;
	}

	/** 
	 * Sets the value of fkRuoloEdificio
	 */
	public void setFkRuoloEdificio(Integer fkRuoloEdificio)
	{
		this.fkRuoloEdificio = fkRuoloEdificio;
	}

	/** 
	 * Gets the value of fkRuoloEdificio
	 */
	public Integer getFkRuoloEdificio()
	{
		return this.fkRuoloEdificio;
	}

	/**
	 * Method 'SiceeRCertRuoliPk'
	 * 
	 */
	public SiceeRCertRuoliPk()
	{
	}

	/**
	 * Method 'SiceeRCertRuoliPk'
	 * 
	 * @param idCertificatore
	 * @param progr
	 * @param anno
	 * @param fkRuoloEdificio
	 */
	public SiceeRCertRuoliPk(final String idCertificatore, final String progr, final String anno, final Integer fkRuoloEdificio)
	{
		this.idCertificatore = idCertificatore;
		this.progr = progr;
		this.anno = anno;
		this.fkRuoloEdificio = fkRuoloEdificio;
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
		
		if (!(_other instanceof SiceeRCertRuoliPk)) {
			return false;
		}
		
		final SiceeRCertRuoliPk _cast = (SiceeRCertRuoliPk) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progr == null ? _cast.progr != this.progr : !this.progr.equals( _cast.progr )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.fkRuoloEdificio == null ? _cast.fkRuoloEdificio != this.fkRuoloEdificio : !this.fkRuoloEdificio.equals( _cast.fkRuoloEdificio )) {
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
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progr != null) {
			_hashCode = 29 * _hashCode + this.progr.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.fkRuoloEdificio != null) {
			_hashCode = 29 * _hashCode + this.fkRuoloEdificio.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertRuoliPk: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progr=" + this.progr );
		ret.append( ", anno=" + this.anno );
		ret.append( ", fkRuoloEdificio=" + this.fkRuoloEdificio );
		return ret.toString();
	}

}
