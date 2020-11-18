/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeRCertRuoli implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3327105362657447364L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_R_CERT_RUOLI table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR in the SICEE_R_CERT_RUOLI table.
	 */
	protected String progr;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_R_CERT_RUOLI table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_RUOLO_EDIFICIO in the SICEE_R_CERT_RUOLI table.
	 */
	protected Integer fkRuoloEdificio;

	/**
	 * Method 'SiceeRCertRuoli'
	 * 
	 */
	public SiceeRCertRuoli()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/**
	 * Method 'setIdCertificatore'
	 * 
	 * @param idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/**
	 * Method 'getProgr'
	 * 
	 * @return String
	 */
	public String getProgr()
	{
		return this.progr;
	}

	/**
	 * Method 'setProgr'
	 * 
	 * @param progr
	 */
	public void setProgr(String progr)
	{
		this.progr = progr;
	}

	/**
	 * Method 'getAnno'
	 * 
	 * @return String
	 */
	public String getAnno()
	{
		return this.anno;
	}

	/**
	 * Method 'setAnno'
	 * 
	 * @param anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/**
	 * Method 'getFkRuoloEdificio'
	 * 
	 * @return Integer
	 */
	public Integer getFkRuoloEdificio()
	{
		return this.fkRuoloEdificio;
	}

	/**
	 * Method 'setFkRuoloEdificio'
	 * 
	 * @param fkRuoloEdificio
	 */
	public void setFkRuoloEdificio(Integer fkRuoloEdificio)
	{
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
		
		if (!(_other instanceof SiceeRCertRuoli)) {
			return false;
		}
		
		final SiceeRCertRuoli _cast = (SiceeRCertRuoli) _other;
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
	 * Method 'createPk'
	 * 
	 * @return SiceeRCertRuoliPk
	 */
	public SiceeRCertRuoliPk createPk()
	{
		return new SiceeRCertRuoliPk(this.idCertificatore, this.progr, this.anno, this.fkRuoloEdificio);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertRuoli: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progr=" + this.progr );
		ret.append( ", anno=" + this.anno );
		ret.append( ", fkRuoloEdificio=" + this.fkRuoloEdificio );
		return ret.toString();
	}

}
