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

public class SiceeTQtaConsumi2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_QTA_CONSUMI in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected long idQtaConsumi;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_COMBUSTIBILE in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected Integer fkCombustibile;

	/** 
	 * This attribute maps to the column FK_UNITA_MISURA in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected Integer fkUnitaMisura;

	/** 
	 * This attribute maps to the column QUANTITA in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected Double quantita;

	/** 
	 * This attribute maps to the column ALTRO_DESCR_COMB in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	protected String altroDescrComb;

	/**
	 * Method 'SiceeTQtaConsumi2015'
	 * 
	 */
	public SiceeTQtaConsumi2015()
	{
	}

	/**
	 * Method 'getIdQtaConsumi'
	 * 
	 * @return long
	 */
	public long getIdQtaConsumi()
	{
		return idQtaConsumi;
	}

	/**
	 * Method 'setIdQtaConsumi'
	 * 
	 * @param idQtaConsumi
	 */
	public void setIdQtaConsumi(long idQtaConsumi)
	{
		this.idQtaConsumi = idQtaConsumi;
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
	 * Method 'getFkCombustibile'
	 * 
	 * @return Integer
	 */
	public Integer getFkCombustibile()
	{
		return fkCombustibile;
	}

	/**
	 * Method 'setFkCombustibile'
	 * 
	 * @param fkCombustibile
	 */
	public void setFkCombustibile(Integer fkCombustibile)
	{
		this.fkCombustibile = fkCombustibile;
	}

	/**
	 * Method 'getFkUnitaMisura'
	 * 
	 * @return Integer
	 */
	public Integer getFkUnitaMisura()
	{
		return fkUnitaMisura;
	}

	/**
	 * Method 'setFkUnitaMisura'
	 * 
	 * @param fkUnitaMisura
	 */
	public void setFkUnitaMisura(Integer fkUnitaMisura)
	{
		this.fkUnitaMisura = fkUnitaMisura;
	}

	/**
	 * Method 'getQuantita'
	 * 
	 * @return Double
	 */
	public Double getQuantita()
	{
		return quantita;
	}

	/**
	 * Method 'setQuantita'
	 * 
	 * @param quantita
	 */
	public void setQuantita(Double quantita)
	{
		this.quantita = quantita;
	}

	/**
	 * Method 'getAltroDescrComb'
	 * 
	 * @return String
	 */
	public String getAltroDescrComb()
	{
		return altroDescrComb;
	}

	/**
	 * Method 'setAltroDescrComb'
	 * 
	 * @param altroDescrComb
	 */
	public void setAltroDescrComb(String altroDescrComb)
	{
		this.altroDescrComb = altroDescrComb;
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
		
		if (!(_other instanceof SiceeTQtaConsumi2015)) {
			return false;
		}
		
		final SiceeTQtaConsumi2015 _cast = (SiceeTQtaConsumi2015) _other;
		if (idQtaConsumi != _cast.idQtaConsumi) {
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
		
		if (fkCombustibile == null ? _cast.fkCombustibile != fkCombustibile : !fkCombustibile.equals( _cast.fkCombustibile )) {
			return false;
		}
		
		if (fkUnitaMisura == null ? _cast.fkUnitaMisura != fkUnitaMisura : !fkUnitaMisura.equals( _cast.fkUnitaMisura )) {
			return false;
		}
		
		if (quantita == null ? _cast.quantita != quantita : !quantita.equals( _cast.quantita )) {
			return false;
		}
		
		if (altroDescrComb == null ? _cast.altroDescrComb != altroDescrComb : !altroDescrComb.equals( _cast.altroDescrComb )) {
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
		_hashCode = 29 * _hashCode + (int) (idQtaConsumi ^ (idQtaConsumi >>> 32));
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (fkCombustibile != null) {
			_hashCode = 29 * _hashCode + fkCombustibile.hashCode();
		}
		
		if (fkUnitaMisura != null) {
			_hashCode = 29 * _hashCode + fkUnitaMisura.hashCode();
		}
		
		if (quantita != null) {
			_hashCode = 29 * _hashCode + quantita.hashCode();
		}
		
		if (altroDescrComb != null) {
			_hashCode = 29 * _hashCode + altroDescrComb.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTQtaConsumi2015Pk
	 */
	public SiceeTQtaConsumi2015Pk createPk()
	{
		return new SiceeTQtaConsumi2015Pk(idQtaConsumi);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015: " );
		ret.append( "idQtaConsumi=" + idQtaConsumi );
		ret.append( ", idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", fkCombustibile=" + fkCombustibile );
		ret.append( ", fkUnitaMisura=" + fkUnitaMisura );
		ret.append( ", quantita=" + quantita );
		ret.append( ", altroDescrComb=" + altroDescrComb );
		return ret.toString();
	}

}
