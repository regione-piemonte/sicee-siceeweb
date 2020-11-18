/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import it.csi.sicee.siceeweb.business.dao.dao.*;
import it.csi.sicee.siceeweb.business.dao.factory.*;
import it.csi.sicee.siceeweb.business.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class SiceeRCertifServener2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column ID_SERV_ENER in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	protected Integer idServEner;

	/** 
	 * This attribute maps to the column EFFICIENZA in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	protected Double efficienza;

	/** 
	 * This attribute maps to the column EPREN in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	protected Double epren;

	/** 
	 * This attribute maps to the column EPNREN in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	protected Double epnren;

	/**
	 * Method 'SiceeRCertifServener2015'
	 * 
	 */
	public SiceeRCertifServener2015()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return idCertificatore;
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
	 * Method 'getProgrCertificato'
	 * 
	 * @return String
	 */
	public String getProgrCertificato()
	{
		return progrCertificato;
	}

	/**
	 * Method 'setProgrCertificato'
	 * 
	 * @param progrCertificato
	 */
	public void setProgrCertificato(String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/**
	 * Method 'getAnno'
	 * 
	 * @return String
	 */
	public String getAnno()
	{
		return anno;
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
	 * Method 'getIdServEner'
	 * 
	 * @return Integer
	 */
	public Integer getIdServEner()
	{
		return idServEner;
	}

	/**
	 * Method 'setIdServEner'
	 * 
	 * @param idServEner
	 */
	public void setIdServEner(Integer idServEner)
	{
		this.idServEner = idServEner;
	}

	/**
	 * Method 'getEfficienza'
	 * 
	 * @return Double
	 */
	public Double getEfficienza()
	{
		return efficienza;
	}

	/**
	 * Method 'setEfficienza'
	 * 
	 * @param efficienza
	 */
	public void setEfficienza(Double efficienza)
	{
		this.efficienza = efficienza;
	}

	/**
	 * Method 'getEpren'
	 * 
	 * @return Double
	 */
	public Double getEpren()
	{
		return epren;
	}

	/**
	 * Method 'setEpren'
	 * 
	 * @param epren
	 */
	public void setEpren(Double epren)
	{
		this.epren = epren;
	}

	/**
	 * Method 'getEpnren'
	 * 
	 * @return Double
	 */
	public Double getEpnren()
	{
		return epnren;
	}

	/**
	 * Method 'setEpnren'
	 * 
	 * @param epnren
	 */
	public void setEpnren(Double epnren)
	{
		this.epnren = epnren;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeRCertifServener2015)) {
			return false;
		}
		
		final SiceeRCertifServener2015 _cast = (SiceeRCertifServener2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (idServEner == null ? _cast.idServEner != idServEner : !idServEner.equals( _cast.idServEner )) {
			return false;
		}
		
		if (efficienza == null ? _cast.efficienza != efficienza : !efficienza.equals( _cast.efficienza )) {
			return false;
		}
		
		if (epren == null ? _cast.epren != epren : !epren.equals( _cast.epren )) {
			return false;
		}
		
		if (epnren == null ? _cast.epnren != epnren : !epnren.equals( _cast.epnren )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (idServEner != null) {
			_hashCode = 29 * _hashCode + idServEner.hashCode();
		}
		
		if (efficienza != null) {
			_hashCode = 29 * _hashCode + efficienza.hashCode();
		}
		
		if (epren != null) {
			_hashCode = 29 * _hashCode + epren.hashCode();
		}
		
		if (epnren != null) {
			_hashCode = 29 * _hashCode + epnren.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeRCertifServener2015Pk
	 */
	public SiceeRCertifServener2015Pk createPk()
	{
		return new SiceeRCertifServener2015Pk(idCertificatore, progrCertificato, anno, idServEner);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", idServEner=" + idServEner );
		ret.append( ", efficienza=" + efficienza );
		ret.append( ", epren=" + epren );
		ret.append( ", epnren=" + epnren );
		return ret.toString();
	}

}
