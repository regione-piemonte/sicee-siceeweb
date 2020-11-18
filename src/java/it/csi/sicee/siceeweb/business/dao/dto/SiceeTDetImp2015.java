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

public class SiceeTDetImp2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_DETTAGLIO_IMP in the SICEE_T_DET_IMP_2015 table.
	 */
	protected long idDettaglioImp;

	/** 
	 * This attribute maps to the column PROGRESSIVO_DETT in the SICEE_T_DET_IMP_2015 table.
	 */
	protected Integer progressivoDett;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DET_IMP_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DET_IMP_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column FK_COMBUSTIBILE in the SICEE_T_DET_IMP_2015 table.
	 */
	protected Integer fkCombustibile;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DET_IMP_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_SERV_ENER in the SICEE_T_DET_IMP_2015 table.
	 */
	protected Integer fkServEner;

	/** 
	 * This attribute maps to the column TIPO_IMPIANTO in the SICEE_T_DET_IMP_2015 table.
	 */
	protected String tipoImpianto;

	/** 
	 * This attribute maps to the column ANNO_INSTALL in the SICEE_T_DET_IMP_2015 table.
	 */
	protected Integer annoInstall;

	/** 
	 * This attribute maps to the column POTENZA_NOMIN_KW in the SICEE_T_DET_IMP_2015 table.
	 */
	protected Double potenzaNominKw;

	/** 
	 * This attribute maps to the column EFFICIENZA in the SICEE_T_DET_IMP_2015 table.
	 */
	//protected Double efficienza;

	/** 
	 * This attribute maps to the column CODICE_IMPIANTO_CIT in the SICEE_T_DET_IMP_2015 table.
	 */
	protected Integer codiceImpiantoCit;

	/** 
	 * This attribute represents whether the primitive attribute codiceImpiantoCit is null.
	 */
	protected boolean codiceImpiantoCitNull = true;

	/** 
	 * This attribute maps to the column FK_TIPO_IMPIANTO in the SICEE_T_DET_IMP_2015 table.
	 */
	protected Integer fkTipoImpianto;

	
	/** 
	 * This attribute maps to the column EPREN in the SICEE_T_DET_IMP_2015 table.
	 */
	//protected Double epren;

	/** 
	 * This attribute maps to the column EPNREN in the SICEE_T_DET_IMP_2015 table.
	 */
	//protected Double epnren;

	/**
	 * Method 'SiceeTDetImp2015'
	 * 
	 */
	public SiceeTDetImp2015()
	{
	}

	/**
	 * Method 'getIdDettaglioImp'
	 * 
	 * @return long
	 */
	public long getIdDettaglioImp()
	{
		return idDettaglioImp;
	}

	/**
	 * Method 'setIdDettaglioImp'
	 * 
	 * @param idDettaglioImp
	 */
	public void setIdDettaglioImp(long idDettaglioImp)
	{
		this.idDettaglioImp = idDettaglioImp;
	}

	/**
	 * Method 'getProgressivoDett'
	 * 
	 * @return Integer
	 */
	public Integer getProgressivoDett()
	{
		return progressivoDett;
	}

	/**
	 * Method 'setProgressivoDett'
	 * 
	 * @param progressivoDett
	 */
	public void setProgressivoDett(Integer progressivoDett)
	{
		this.progressivoDett = progressivoDett;
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
	 * Method 'getFkServEner'
	 * 
	 * @return Integer
	 */
	public Integer getFkServEner()
	{
		return fkServEner;
	}

	/**
	 * Method 'setFkServEner'
	 * 
	 * @param fkServEner
	 */
	public void setFkServEner(Integer fkServEner)
	{
		this.fkServEner = fkServEner;
	}

	/**
	 * Method 'getTipoImpianto'
	 * 
	 * @return String
	 */
	public String getTipoImpianto()
	{
		return tipoImpianto;
	}

	/**
	 * Method 'setTipoImpianto'
	 * 
	 * @param tipoImpianto
	 */
	public void setTipoImpianto(String tipoImpianto)
	{
		this.tipoImpianto = tipoImpianto;
	}

	/**
	 * Method 'getAnnoInstall'
	 * 
	 * @return Integer
	 */
	public Integer getAnnoInstall()
	{
		return annoInstall;
	}

	/**
	 * Method 'setAnnoInstall'
	 * 
	 * @param annoInstall
	 */
	public void setAnnoInstall(Integer annoInstall)
	{
		this.annoInstall = annoInstall;
	}

	/**
	 * Method 'getPotenzaNominKw'
	 * 
	 * @return Double
	 */
	public Double getPotenzaNominKw()
	{
		return potenzaNominKw;
	}

	/**
	 * Method 'setPotenzaNominKw'
	 * 
	 * @param potenzaNominKw
	 */
	public void setPotenzaNominKw(Double potenzaNominKw)
	{
		this.potenzaNominKw = potenzaNominKw;
	}

	/**
	 * Method 'getEfficienza'
	 * 
	 * @return Double
	 */
/*
	public Double getEfficienza()
	{
		return efficienza;
	}
*/
	/**
	 * Method 'setEfficienza'
	 * 
	 * @param efficienza
	 */
/*
	public void setEfficienza(Double efficienza)
	{
		this.efficienza = efficienza;
	}
*/
	/**
	 * Method 'getCodiceImpiantoCit'
	 * 
	 * @return long
	 */
	public Integer getCodiceImpiantoCit()
	{
		return codiceImpiantoCit;
	}

	/**
	 * Method 'setCodiceImpiantoCit'
	 * 
	 * @param codiceImpiantoCit
	 */
	public void setCodiceImpiantoCit(Integer codiceImpiantoCit)
	{
		this.codiceImpiantoCit = codiceImpiantoCit;
		this.codiceImpiantoCitNull = false;
	}

	/**
	 * Method 'setCodiceImpiantoCitNull'
	 * 
	 * @param value
	 */
	public void setCodiceImpiantoCitNull(boolean value)
	{
		this.codiceImpiantoCitNull = value;
	}

	/**
	 * Method 'isCodiceImpiantoCitNull'
	 * 
	 * @return boolean
	 */
	public boolean isCodiceImpiantoCitNull()
	{
		return codiceImpiantoCitNull;
	}

	
	
	public Integer getFkTipoImpianto() {
		return fkTipoImpianto;
	}

	public void setFkTipoImpianto(Integer fkTipoImpianto) {
		this.fkTipoImpianto = fkTipoImpianto;
	}

	/**
	 * Method 'getEpren'
	 * 
	 * @return Double
	 */
/*
	public Double getEpren()
	{
		return epren;
	}
*/
	/**
	 * Method 'setEpren'
	 * 
	 * @param epren
	 */
/*
	public void setEpren(Double epren)
	{
		this.epren = epren;
	}
*/
	/**
	 * Method 'getEpnren'
	 * 
	 * @return Double
	 */
/*
	public Double getEpnren()
	{
		return epnren;
	}
*/
	/**
	 * Method 'setEpnren'
	 * 
	 * @param epnren
	 */
/*
	public void setEpnren(Double epnren)
	{
		this.epnren = epnren;
	}
*/
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
		
		if (!(_other instanceof SiceeTDetImp2015)) {
			return false;
		}
		
		final SiceeTDetImp2015 _cast = (SiceeTDetImp2015) _other;
		if (idDettaglioImp != _cast.idDettaglioImp) {
			return false;
		}
		
		if (progressivoDett == null ? _cast.progressivoDett != progressivoDett : !progressivoDett.equals( _cast.progressivoDett )) {
			return false;
		}
		
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (fkCombustibile == null ? _cast.fkCombustibile != fkCombustibile : !fkCombustibile.equals( _cast.fkCombustibile )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (fkServEner == null ? _cast.fkServEner != fkServEner : !fkServEner.equals( _cast.fkServEner )) {
			return false;
		}
		
		if (tipoImpianto == null ? _cast.tipoImpianto != tipoImpianto : !tipoImpianto.equals( _cast.tipoImpianto )) {
			return false;
		}
		
		if (annoInstall == null ? _cast.annoInstall != annoInstall : !annoInstall.equals( _cast.annoInstall )) {
			return false;
		}
		
		if (potenzaNominKw == null ? _cast.potenzaNominKw != potenzaNominKw : !potenzaNominKw.equals( _cast.potenzaNominKw )) {
			return false;
		}
/*		
		if (efficienza == null ? _cast.efficienza != efficienza : !efficienza.equals( _cast.efficienza )) {
			return false;
		}
*/		
		if (codiceImpiantoCit != _cast.codiceImpiantoCit) {
			return false;
		}
		
		if (codiceImpiantoCitNull != _cast.codiceImpiantoCitNull) {
			return false;
		}
		
		if (fkTipoImpianto != _cast.fkTipoImpianto) {
			return false;
		}
		
/*		
		if (epren == null ? _cast.epren != epren : !epren.equals( _cast.epren )) {
			return false;
		}
		
		if (epnren == null ? _cast.epnren != epnren : !epnren.equals( _cast.epnren )) {
			return false;
		}
*/		
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
		_hashCode = 29 * _hashCode + (int) (idDettaglioImp ^ (idDettaglioImp >>> 32));
		if (progressivoDett != null) {
			_hashCode = 29 * _hashCode + progressivoDett.hashCode();
		}
		
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (fkCombustibile != null) {
			_hashCode = 29 * _hashCode + fkCombustibile.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (fkServEner != null) {
			_hashCode = 29 * _hashCode + fkServEner.hashCode();
		}
		
		if (tipoImpianto != null) {
			_hashCode = 29 * _hashCode + tipoImpianto.hashCode();
		}
		
		if (annoInstall != null) {
			_hashCode = 29 * _hashCode + annoInstall.hashCode();
		}
		
		if (potenzaNominKw != null) {
			_hashCode = 29 * _hashCode + potenzaNominKw.hashCode();
		}
/*		
		if (efficienza != null) {
			_hashCode = 29 * _hashCode + efficienza.hashCode();
		}
*/	
		_hashCode = 29 * _hashCode + (int) (codiceImpiantoCit ^ (codiceImpiantoCit >>> 32));
		_hashCode = 29 * _hashCode + (codiceImpiantoCitNull ? 1 : 0);
		
		if (fkTipoImpianto != null) {
			_hashCode = 29 * _hashCode + fkTipoImpianto.hashCode();
		}
		
/*
		if (epren != null) {
			_hashCode = 29 * _hashCode + epren.hashCode();
		}
		
		if (epnren != null) {
			_hashCode = 29 * _hashCode + epnren.hashCode();
		}
*/	
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDetImp2015Pk
	 */
	public SiceeTDetImp2015Pk createPk()
	{
		return new SiceeTDetImp2015Pk(idDettaglioImp);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015: " );
		ret.append( "idDettaglioImp=" + idDettaglioImp );
		ret.append( ", progressivoDett=" + progressivoDett );
		ret.append( ", idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", fkCombustibile=" + fkCombustibile );
		ret.append( ", anno=" + anno );
		ret.append( ", fkServEner=" + fkServEner );
		ret.append( ", tipoImpianto=" + tipoImpianto );
		ret.append( ", annoInstall=" + annoInstall );
		ret.append( ", potenzaNominKw=" + potenzaNominKw );
		//ret.append( ", efficienza=" + efficienza );
		ret.append( ", codiceImpiantoCit=" + codiceImpiantoCit );
		ret.append( ", fkTipoImpianto=" + fkTipoImpianto );

		//ret.append( ", epren=" + epren );
		//ret.append( ", epnren=" + epnren );
		return ret.toString();
	}

}
