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

public class SiceeTDatiEsami implements Serializable
{
	/** 
	 * This attribute maps to the column ID_DATI_ESAMI in the SICEE_T_DATI_ESAMI table.
	 */
	protected Integer idDatiEsami;

	/** 
	 * This attribute maps to the column FK_CERTIFICATORE in the SICEE_T_DATI_ESAMI table.
	 */
	protected String fkCertificatore;

	/** 
	 * This attribute maps to the column CORSO_FREQUENTATO in the SICEE_T_DATI_ESAMI table.
	 */
	protected String corsoFrequentato;

	/** 
	 * This attribute maps to the column DT_MODULO1_DA in the SICEE_T_DATI_ESAMI table.
	 */
	protected Date dtModulo1Da;

	/** 
	 * This attribute maps to the column DT_MODULO1_A in the SICEE_T_DATI_ESAMI table.
	 */
	protected Date dtModulo1A;

	/** 
	 * This attribute maps to the column DT_MODULO2_DA in the SICEE_T_DATI_ESAMI table.
	 */
	protected Date dtModulo2Da;

	/** 
	 * This attribute maps to the column DT_MODULO2_A in the SICEE_T_DATI_ESAMI table.
	 */
	protected Date dtModulo2A;

	/** 
	 * This attribute maps to the column TOTALE_ORE in the SICEE_T_DATI_ESAMI table.
	 */
	protected Integer totaleOre;

	/** 
	 * This attribute maps to the column ATT_PARTECIP_EMESSO in the SICEE_T_DATI_ESAMI table.
	 */
	protected String attPartecipEmesso;

	/** 
	 * This attribute maps to the column DT_ATT_PARTECIP in the SICEE_T_DATI_ESAMI table.
	 */
	protected Date dtAttPartecip;

	/** 
	 * This attribute maps to the column ATT_ESAME_PRESSO in the SICEE_T_DATI_ESAMI table.
	 */
	protected String attEsamePresso;

	/** 
	 * This attribute maps to the column DT_ATT_ESAME in the SICEE_T_DATI_ESAMI table.
	 */
	protected Date dtAttEsame;

	/**
	 * Method 'SiceeTDatiEsami'
	 * 
	 */
	public SiceeTDatiEsami()
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
	 * Method 'getDtModulo1Da'
	 * 
	 * @return Date
	 */
	public Date getDtModulo1Da()
	{
		return dtModulo1Da;
	}

	/**
	 * Method 'setDtModulo1Da'
	 * 
	 * @param dtModulo1Da
	 */
	public void setDtModulo1Da(Date dtModulo1Da)
	{
		this.dtModulo1Da = dtModulo1Da;
	}

	/**
	 * Method 'getDtModulo1A'
	 * 
	 * @return Date
	 */
	public Date getDtModulo1A()
	{
		return dtModulo1A;
	}

	/**
	 * Method 'setDtModulo1A'
	 * 
	 * @param dtModulo1A
	 */
	public void setDtModulo1A(Date dtModulo1A)
	{
		this.dtModulo1A = dtModulo1A;
	}

	/**
	 * Method 'getDtModulo2Da'
	 * 
	 * @return Date
	 */
	public Date getDtModulo2Da()
	{
		return dtModulo2Da;
	}

	/**
	 * Method 'setDtModulo2Da'
	 * 
	 * @param dtModulo2Da
	 */
	public void setDtModulo2Da(Date dtModulo2Da)
	{
		this.dtModulo2Da = dtModulo2Da;
	}

	/**
	 * Method 'getDtModulo2A'
	 * 
	 * @return Date
	 */
	public Date getDtModulo2A()
	{
		return dtModulo2A;
	}

	/**
	 * Method 'setDtModulo2A'
	 * 
	 * @param dtModulo2A
	 */
	public void setDtModulo2A(Date dtModulo2A)
	{
		this.dtModulo2A = dtModulo2A;
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
	 * Method 'getAttPartecipEmesso'
	 * 
	 * @return String
	 */
	public String getAttPartecipEmesso()
	{
		return attPartecipEmesso;
	}

	/**
	 * Method 'setAttPartecipEmesso'
	 * 
	 * @param attPartecipEmesso
	 */
	public void setAttPartecipEmesso(String attPartecipEmesso)
	{
		this.attPartecipEmesso = attPartecipEmesso;
	}

	/**
	 * Method 'getDtAttPartecip'
	 * 
	 * @return Date
	 */
	public Date getDtAttPartecip()
	{
		return dtAttPartecip;
	}

	/**
	 * Method 'setDtAttPartecip'
	 * 
	 * @param dtAttPartecip
	 */
	public void setDtAttPartecip(Date dtAttPartecip)
	{
		this.dtAttPartecip = dtAttPartecip;
	}

	/**
	 * Method 'getAttEsamePresso'
	 * 
	 * @return String
	 */
	public String getAttEsamePresso()
	{
		return attEsamePresso;
	}

	/**
	 * Method 'setAttEsamePresso'
	 * 
	 * @param attEsamePresso
	 */
	public void setAttEsamePresso(String attEsamePresso)
	{
		this.attEsamePresso = attEsamePresso;
	}

	/**
	 * Method 'getDtAttEsame'
	 * 
	 * @return Date
	 */
	public Date getDtAttEsame()
	{
		return dtAttEsame;
	}

	/**
	 * Method 'setDtAttEsame'
	 * 
	 * @param dtAttEsame
	 */
	public void setDtAttEsame(Date dtAttEsame)
	{
		this.dtAttEsame = dtAttEsame;
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
		
		if (!(_other instanceof SiceeTDatiEsami)) {
			return false;
		}
		
		final SiceeTDatiEsami _cast = (SiceeTDatiEsami) _other;
		if (idDatiEsami == null ? _cast.idDatiEsami != idDatiEsami : !idDatiEsami.equals( _cast.idDatiEsami )) {
			return false;
		}
		
		if (fkCertificatore == null ? _cast.fkCertificatore != fkCertificatore : !fkCertificatore.equals( _cast.fkCertificatore )) {
			return false;
		}
		
		if (corsoFrequentato == null ? _cast.corsoFrequentato != corsoFrequentato : !corsoFrequentato.equals( _cast.corsoFrequentato )) {
			return false;
		}
		
		if (dtModulo1Da == null ? _cast.dtModulo1Da != dtModulo1Da : !dtModulo1Da.equals( _cast.dtModulo1Da )) {
			return false;
		}
		
		if (dtModulo1A == null ? _cast.dtModulo1A != dtModulo1A : !dtModulo1A.equals( _cast.dtModulo1A )) {
			return false;
		}
		
		if (dtModulo2Da == null ? _cast.dtModulo2Da != dtModulo2Da : !dtModulo2Da.equals( _cast.dtModulo2Da )) {
			return false;
		}
		
		if (dtModulo2A == null ? _cast.dtModulo2A != dtModulo2A : !dtModulo2A.equals( _cast.dtModulo2A )) {
			return false;
		}
		
		if (totaleOre == null ? _cast.totaleOre != totaleOre : !totaleOre.equals( _cast.totaleOre )) {
			return false;
		}
		
		if (attPartecipEmesso == null ? _cast.attPartecipEmesso != attPartecipEmesso : !attPartecipEmesso.equals( _cast.attPartecipEmesso )) {
			return false;
		}
		
		if (dtAttPartecip == null ? _cast.dtAttPartecip != dtAttPartecip : !dtAttPartecip.equals( _cast.dtAttPartecip )) {
			return false;
		}
		
		if (attEsamePresso == null ? _cast.attEsamePresso != attEsamePresso : !attEsamePresso.equals( _cast.attEsamePresso )) {
			return false;
		}
		
		if (dtAttEsame == null ? _cast.dtAttEsame != dtAttEsame : !dtAttEsame.equals( _cast.dtAttEsame )) {
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
		
		if (dtModulo1Da != null) {
			_hashCode = 29 * _hashCode + dtModulo1Da.hashCode();
		}
		
		if (dtModulo1A != null) {
			_hashCode = 29 * _hashCode + dtModulo1A.hashCode();
		}
		
		if (dtModulo2Da != null) {
			_hashCode = 29 * _hashCode + dtModulo2Da.hashCode();
		}
		
		if (dtModulo2A != null) {
			_hashCode = 29 * _hashCode + dtModulo2A.hashCode();
		}
		
		if (totaleOre != null) {
			_hashCode = 29 * _hashCode + totaleOre.hashCode();
		}
		
		if (attPartecipEmesso != null) {
			_hashCode = 29 * _hashCode + attPartecipEmesso.hashCode();
		}
		
		if (dtAttPartecip != null) {
			_hashCode = 29 * _hashCode + dtAttPartecip.hashCode();
		}
		
		if (attEsamePresso != null) {
			_hashCode = 29 * _hashCode + attEsamePresso.hashCode();
		}
		
		if (dtAttEsame != null) {
			_hashCode = 29 * _hashCode + dtAttEsame.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDatiEsamiPk
	 */
	public SiceeTDatiEsamiPk createPk()
	{
		return new SiceeTDatiEsamiPk(idDatiEsami);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsami: " );
		ret.append( "idDatiEsami=" + idDatiEsami );
		ret.append( ", fkCertificatore=" + fkCertificatore );
		ret.append( ", corsoFrequentato=" + corsoFrequentato );
		ret.append( ", dtModulo1Da=" + dtModulo1Da );
		ret.append( ", dtModulo1A=" + dtModulo1A );
		ret.append( ", dtModulo2Da=" + dtModulo2Da );
		ret.append( ", dtModulo2A=" + dtModulo2A );
		ret.append( ", totaleOre=" + totaleOre );
		ret.append( ", attPartecipEmesso=" + attPartecipEmesso );
		ret.append( ", dtAttPartecip=" + dtAttPartecip );
		ret.append( ", attEsamePresso=" + attEsamePresso );
		ret.append( ", dtAttEsame=" + dtAttEsame );
		return ret.toString();
	}

}
