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
import java.util.Date;

public class SiceeTEsameDpr75 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_DATI_ESAMI in the SICEE_T_ESAME_DPR75 table.
	 */
	protected Integer idDatiEsami;

	/** 
	 * This attribute maps to the column FK_CERTIFICATORE in the SICEE_T_ESAME_DPR75 table.
	 */
	protected String fkCertificatore;

	/** 
	 * This attribute maps to the column CORSO_FREQUENTATO in the SICEE_T_ESAME_DPR75 table.
	 */
	protected String corsoFrequentato;

	/** 
	 * This attribute maps to the column DT_DAL in the SICEE_T_ESAME_DPR75 table.
	 */
	protected Date dtDal;

	/** 
	 * This attribute maps to the column DT_AL in the SICEE_T_ESAME_DPR75 table.
	 */
	protected Date dtAl;

	/** 
	 * This attribute maps to the column TOTALE_ORE in the SICEE_T_ESAME_DPR75 table.
	 */
	protected Integer totaleOre;

	/** 
	 * This attribute maps to the column ESAME_PRESSO in the SICEE_T_ESAME_DPR75 table.
	 */
	protected String esamePresso;

	/** 
	 * This attribute maps to the column DT_ESAME in the SICEE_T_ESAME_DPR75 table.
	 */
	protected Date dtEsame;

	/** 
	 * This attribute maps to the column ATTESTATO_PRESSO in the SICEE_T_ESAME_DPR75 table.
	 */
	protected String attestatoPresso;

	/** 
	 * This attribute maps to the column DT_ATTESTATO in the SICEE_T_ESAME_DPR75 table.
	 */
	protected Date dtAttestato;

	/**
	 * Method 'SiceeTEsameDpr75'
	 * 
	 */
	public SiceeTEsameDpr75()
	{
	}

	/**
	 * Method 'getIdDatiEsami'
	 * 
	 * @return Integer
	 */
	public Integer getIdDatiEsami()
	{
		return idDatiEsami;
	}

	/**
	 * Method 'setIdDatiEsami'
	 * 
	 * @param idDatiEsami
	 */
	public void setIdDatiEsami(Integer idDatiEsami)
	{
		this.idDatiEsami = idDatiEsami;
	}

	/**
	 * Method 'getFkCertificatore'
	 * 
	 * @return String
	 */
	public String getFkCertificatore()
	{
		return fkCertificatore;
	}

	/**
	 * Method 'setFkCertificatore'
	 * 
	 * @param fkCertificatore
	 */
	public void setFkCertificatore(String fkCertificatore)
	{
		this.fkCertificatore = fkCertificatore;
	}

	/**
	 * Method 'getCorsoFrequentato'
	 * 
	 * @return String
	 */
	public String getCorsoFrequentato()
	{
		return corsoFrequentato;
	}

	/**
	 * Method 'setCorsoFrequentato'
	 * 
	 * @param corsoFrequentato
	 */
	public void setCorsoFrequentato(String corsoFrequentato)
	{
		this.corsoFrequentato = corsoFrequentato;
	}

	/**
	 * Method 'getDtDal'
	 * 
	 * @return Date
	 */
	public Date getDtDal()
	{
		return dtDal;
	}

	/**
	 * Method 'setDtDal'
	 * 
	 * @param dtDal
	 */
	public void setDtDal(Date dtDal)
	{
		this.dtDal = dtDal;
	}

	/**
	 * Method 'getDtAl'
	 * 
	 * @return Date
	 */
	public Date getDtAl()
	{
		return dtAl;
	}

	/**
	 * Method 'setDtAl'
	 * 
	 * @param dtAl
	 */
	public void setDtAl(Date dtAl)
	{
		this.dtAl = dtAl;
	}

	/**
	 * Method 'getTotaleOre'
	 * 
	 * @return Integer
	 */
	public Integer getTotaleOre()
	{
		return totaleOre;
	}

	/**
	 * Method 'setTotaleOre'
	 * 
	 * @param totaleOre
	 */
	public void setTotaleOre(Integer totaleOre)
	{
		this.totaleOre = totaleOre;
	}

	/**
	 * Method 'getEsamePresso'
	 * 
	 * @return String
	 */
	public String getEsamePresso()
	{
		return esamePresso;
	}

	/**
	 * Method 'setEsamePresso'
	 * 
	 * @param esamePresso
	 */
	public void setEsamePresso(String esamePresso)
	{
		this.esamePresso = esamePresso;
	}

	/**
	 * Method 'getDtEsame'
	 * 
	 * @return Date
	 */
	public Date getDtEsame()
	{
		return dtEsame;
	}

	/**
	 * Method 'setDtEsame'
	 * 
	 * @param dtEsame
	 */
	public void setDtEsame(Date dtEsame)
	{
		this.dtEsame = dtEsame;
	}

	/**
	 * Method 'getAttestatoPresso'
	 * 
	 * @return String
	 */
	public String getAttestatoPresso()
	{
		return attestatoPresso;
	}

	/**
	 * Method 'setAttestatoPresso'
	 * 
	 * @param attestatoPresso
	 */
	public void setAttestatoPresso(String attestatoPresso)
	{
		this.attestatoPresso = attestatoPresso;
	}

	/**
	 * Method 'getDtAttestato'
	 * 
	 * @return Date
	 */
	public Date getDtAttestato()
	{
		return dtAttestato;
	}

	/**
	 * Method 'setDtAttestato'
	 * 
	 * @param dtAttestato
	 */
	public void setDtAttestato(Date dtAttestato)
	{
		this.dtAttestato = dtAttestato;
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
		
		if (!(_other instanceof SiceeTEsameDpr75)) {
			return false;
		}
		
		final SiceeTEsameDpr75 _cast = (SiceeTEsameDpr75) _other;
		if (idDatiEsami == null ? _cast.idDatiEsami != idDatiEsami : !idDatiEsami.equals( _cast.idDatiEsami )) {
			return false;
		}
		
		if (fkCertificatore == null ? _cast.fkCertificatore != fkCertificatore : !fkCertificatore.equals( _cast.fkCertificatore )) {
			return false;
		}
		
		if (corsoFrequentato == null ? _cast.corsoFrequentato != corsoFrequentato : !corsoFrequentato.equals( _cast.corsoFrequentato )) {
			return false;
		}
		
		if (dtDal == null ? _cast.dtDal != dtDal : !dtDal.equals( _cast.dtDal )) {
			return false;
		}
		
		if (dtAl == null ? _cast.dtAl != dtAl : !dtAl.equals( _cast.dtAl )) {
			return false;
		}
		
		if (totaleOre == null ? _cast.totaleOre != totaleOre : !totaleOre.equals( _cast.totaleOre )) {
			return false;
		}
		
		if (esamePresso == null ? _cast.esamePresso != esamePresso : !esamePresso.equals( _cast.esamePresso )) {
			return false;
		}
		
		if (dtEsame == null ? _cast.dtEsame != dtEsame : !dtEsame.equals( _cast.dtEsame )) {
			return false;
		}
		
		if (attestatoPresso == null ? _cast.attestatoPresso != attestatoPresso : !attestatoPresso.equals( _cast.attestatoPresso )) {
			return false;
		}
		
		if (dtAttestato == null ? _cast.dtAttestato != dtAttestato : !dtAttestato.equals( _cast.dtAttestato )) {
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
		if (idDatiEsami != null) {
			_hashCode = 29 * _hashCode + idDatiEsami.hashCode();
		}
		
		if (fkCertificatore != null) {
			_hashCode = 29 * _hashCode + fkCertificatore.hashCode();
		}
		
		if (corsoFrequentato != null) {
			_hashCode = 29 * _hashCode + corsoFrequentato.hashCode();
		}
		
		if (dtDal != null) {
			_hashCode = 29 * _hashCode + dtDal.hashCode();
		}
		
		if (dtAl != null) {
			_hashCode = 29 * _hashCode + dtAl.hashCode();
		}
		
		if (totaleOre != null) {
			_hashCode = 29 * _hashCode + totaleOre.hashCode();
		}
		
		if (esamePresso != null) {
			_hashCode = 29 * _hashCode + esamePresso.hashCode();
		}
		
		if (dtEsame != null) {
			_hashCode = 29 * _hashCode + dtEsame.hashCode();
		}
		
		if (attestatoPresso != null) {
			_hashCode = 29 * _hashCode + attestatoPresso.hashCode();
		}
		
		if (dtAttestato != null) {
			_hashCode = 29 * _hashCode + dtAttestato.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTEsameDpr75Pk
	 */
	public SiceeTEsameDpr75Pk createPk()
	{
		return new SiceeTEsameDpr75Pk(idDatiEsami);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsameDpr75: " );
		ret.append( "idDatiEsami=" + idDatiEsami );
		ret.append( ", fkCertificatore=" + fkCertificatore );
		ret.append( ", corsoFrequentato=" + corsoFrequentato );
		ret.append( ", dtDal=" + dtDal );
		ret.append( ", dtAl=" + dtAl );
		ret.append( ", totaleOre=" + totaleOre );
		ret.append( ", esamePresso=" + esamePresso );
		ret.append( ", dtEsame=" + dtEsame );
		ret.append( ", attestatoPresso=" + attestatoPresso );
		ret.append( ", dtAttestato=" + dtAttestato );
		return ret.toString();
	}

}
