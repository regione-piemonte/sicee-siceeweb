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

public class SiceeRCombDener2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_COMBUSTIBILE in the SICEE_R_COMB_DENER_2015 table.
	 */
	protected Integer idCombustibile;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_R_COMB_DENER_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_R_COMB_DENER_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_R_COMB_DENER_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column DESCR_ALTRO in the SICEE_R_COMB_DENER_2015 table.
	 */
	protected String descrAltro;

	/**
	 * Method 'SiceeRCombDener2015'
	 * 
	 */
	public SiceeRCombDener2015()
	{
	}

	/**
	 * Method 'getIdCombustibile'
	 * 
	 * @return Integer
	 */
	public Integer getIdCombustibile()
	{
		return idCombustibile;
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
	 * Method 'getDescrAltro'
	 * 
	 * @return String
	 */
	public String getDescrAltro()
	{
		return descrAltro;
	}

	/**
	 * Method 'setDescrAltro'
	 * 
	 * @param descrAltro
	 */
	public void setDescrAltro(String descrAltro)
	{
		this.descrAltro = descrAltro;
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
		
		if (!(_other instanceof SiceeRCombDener2015)) {
			return false;
		}
		
		final SiceeRCombDener2015 _cast = (SiceeRCombDener2015) _other;
		if (idCombustibile == null ? _cast.idCombustibile != idCombustibile : !idCombustibile.equals( _cast.idCombustibile )) {
			return false;
		}
		
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (descrAltro == null ? _cast.descrAltro != descrAltro : !descrAltro.equals( _cast.descrAltro )) {
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
		if (idCombustibile != null) {
			_hashCode = 29 * _hashCode + idCombustibile.hashCode();
		}
		
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (descrAltro != null) {
			_hashCode = 29 * _hashCode + descrAltro.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeRCombDener2015Pk
	 */
	public SiceeRCombDener2015Pk createPk()
	{
		return new SiceeRCombDener2015Pk(idCombustibile, idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015: " );
		ret.append( "idCombustibile=" + idCombustibile );
		ret.append( ", idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", descrAltro=" + descrAltro );
		return ret.toString();
	}

}
