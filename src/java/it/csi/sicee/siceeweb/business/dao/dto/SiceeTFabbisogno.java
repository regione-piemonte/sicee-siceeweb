/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTFabbisogno implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2474661119392541235L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_FABBISOGNO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_FABBISOGNO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_FABBISOGNO table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column DOM_RISC_QH in the SICEE_T_FABBISOGNO table.
	 */
	protected Double domRiscQh;

	/** 
	 * This attribute maps to the column LIMITE_REG_QH_LIM in the SICEE_T_FABBISOGNO table.
	 */
	protected Double limiteRegQhLim;

	/** 
	 * This attribute maps to the column FABB_CONDIZ in the SICEE_T_FABBISOGNO table.
	 */
	protected Double fabbCondiz;

	/** 
	 * This attribute maps to the column DOM_ACS_QHW in the SICEE_T_FABBISOGNO table.
	 */
	protected Double domAcsQhw;

	/** 
	 * This attribute maps to the column EN_ACS_RINNO in the SICEE_T_FABBISOGNO table.
	 */
	protected Double enAcsRinno;

	/** 
	 * This attribute maps to the column REND_ACS_ETAGACS in the SICEE_T_FABBISOGNO table.
	 */
	protected Double rendAcsEtagacs;

	/** 
	 * This attribute maps to the column FABB_ACS in the SICEE_T_FABBISOGNO table.
	 */
	protected Double fabbAcs;

	/** 
	 * This attribute maps to the column FABB_ILLUM in the SICEE_T_FABBISOGNO table.
	 */
	protected Double fabbIllum;

	/**
	 * Method 'SiceeTFabbisogno'
	 * 
	 */
	public SiceeTFabbisogno()
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
	 * Method 'getProgrCertificato'
	 * 
	 * @return String
	 */
	public String getProgrCertificato()
	{
		return this.progrCertificato;
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
	 * Method 'getDomRiscQh'
	 * 
	 * @return Double
	 */
	public Double getDomRiscQh()
	{
		return this.domRiscQh;
	}

	/**
	 * Method 'setDomRiscQh'
	 * 
	 * @param domRiscQh
	 */
	public void setDomRiscQh(Double domRiscQh)
	{
		this.domRiscQh = domRiscQh;
	}

	/**
	 * Method 'getLimiteRegQhLim'
	 * 
	 * @return Double
	 */
	public Double getLimiteRegQhLim()
	{
		return this.limiteRegQhLim;
	}

	/**
	 * Method 'setLimiteRegQhLim'
	 * 
	 * @param limiteRegQhLim
	 */
	public void setLimiteRegQhLim(Double limiteRegQhLim)
	{
		this.limiteRegQhLim = limiteRegQhLim;
	}

	/**
	 * Method 'getFabbCondiz'
	 * 
	 * @return Double
	 */
	public Double getFabbCondiz()
	{
		return this.fabbCondiz;
	}

	/**
	 * Method 'setFabbCondiz'
	 * 
	 * @param fabbCondiz
	 */
	public void setFabbCondiz(Double fabbCondiz)
	{
		this.fabbCondiz = fabbCondiz;
	}

	/**
	 * Method 'getDomAcsQhw'
	 * 
	 * @return Double
	 */
	public Double getDomAcsQhw()
	{
		return this.domAcsQhw;
	}

	/**
	 * Method 'setDomAcsQhw'
	 * 
	 * @param domAcsQhw
	 */
	public void setDomAcsQhw(Double domAcsQhw)
	{
		this.domAcsQhw = domAcsQhw;
	}

	/**
	 * Method 'getEnAcsRinno'
	 * 
	 * @return Double
	 */
	public Double getEnAcsRinno()
	{
		return this.enAcsRinno;
	}

	/**
	 * Method 'setEnAcsRinno'
	 * 
	 * @param enAcsRinno
	 */
	public void setEnAcsRinno(Double enAcsRinno)
	{
		this.enAcsRinno = enAcsRinno;
	}

	/**
	 * Method 'getRendAcsEtagacs'
	 * 
	 * @return Double
	 */
	public Double getRendAcsEtagacs()
	{
		return this.rendAcsEtagacs;
	}

	/**
	 * Method 'setRendAcsEtagacs'
	 * 
	 * @param rendAcsEtagacs
	 */
	public void setRendAcsEtagacs(Double rendAcsEtagacs)
	{
		this.rendAcsEtagacs = rendAcsEtagacs;
	}

	/**
	 * Method 'getFabbAcs'
	 * 
	 * @return Double
	 */
	public Double getFabbAcs()
	{
		return this.fabbAcs;
	}

	/**
	 * Method 'setFabbAcs'
	 * 
	 * @param fabbAcs
	 */
	public void setFabbAcs(Double fabbAcs)
	{
		this.fabbAcs = fabbAcs;
	}

	/**
	 * Method 'getFabbIllum'
	 * 
	 * @return Double
	 */
	public Double getFabbIllum()
	{
		return this.fabbIllum;
	}

	/**
	 * Method 'setFabbIllum'
	 * 
	 * @param fabbIllum
	 */
	public void setFabbIllum(Double fabbIllum)
	{
		this.fabbIllum = fabbIllum;
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
		
		if (!(_other instanceof SiceeTFabbisogno)) {
			return false;
		}
		
		final SiceeTFabbisogno _cast = (SiceeTFabbisogno) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.domRiscQh == null ? _cast.domRiscQh != this.domRiscQh : !this.domRiscQh.equals( _cast.domRiscQh )) {
			return false;
		}
		
		if (this.limiteRegQhLim == null ? _cast.limiteRegQhLim != this.limiteRegQhLim : !this.limiteRegQhLim.equals( _cast.limiteRegQhLim )) {
			return false;
		}
		
		if (this.fabbCondiz == null ? _cast.fabbCondiz != this.fabbCondiz : !this.fabbCondiz.equals( _cast.fabbCondiz )) {
			return false;
		}
		
		if (this.domAcsQhw == null ? _cast.domAcsQhw != this.domAcsQhw : !this.domAcsQhw.equals( _cast.domAcsQhw )) {
			return false;
		}
		
		if (this.enAcsRinno == null ? _cast.enAcsRinno != this.enAcsRinno : !this.enAcsRinno.equals( _cast.enAcsRinno )) {
			return false;
		}
		
		if (this.rendAcsEtagacs == null ? _cast.rendAcsEtagacs != this.rendAcsEtagacs : !this.rendAcsEtagacs.equals( _cast.rendAcsEtagacs )) {
			return false;
		}
		
		if (this.fabbAcs == null ? _cast.fabbAcs != this.fabbAcs : !this.fabbAcs.equals( _cast.fabbAcs )) {
			return false;
		}
		
		if (this.fabbIllum == null ? _cast.fabbIllum != this.fabbIllum : !this.fabbIllum.equals( _cast.fabbIllum )) {
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
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.domRiscQh != null) {
			_hashCode = 29 * _hashCode + this.domRiscQh.hashCode();
		}
		
		if (this.limiteRegQhLim != null) {
			_hashCode = 29 * _hashCode + this.limiteRegQhLim.hashCode();
		}
		
		if (this.fabbCondiz != null) {
			_hashCode = 29 * _hashCode + this.fabbCondiz.hashCode();
		}
		
		if (this.domAcsQhw != null) {
			_hashCode = 29 * _hashCode + this.domAcsQhw.hashCode();
		}
		
		if (this.enAcsRinno != null) {
			_hashCode = 29 * _hashCode + this.enAcsRinno.hashCode();
		}
		
		if (this.rendAcsEtagacs != null) {
			_hashCode = 29 * _hashCode + this.rendAcsEtagacs.hashCode();
		}
		
		if (this.fabbAcs != null) {
			_hashCode = 29 * _hashCode + this.fabbAcs.hashCode();
		}
		
		if (this.fabbIllum != null) {
			_hashCode = 29 * _hashCode + this.fabbIllum.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTFabbisognoPk
	 */
	public SiceeTFabbisognoPk createPk()
	{
		return new SiceeTFabbisognoPk(this.idCertificatore, this.progrCertificato, this.anno);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTFabbisogno: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", domRiscQh=" + this.domRiscQh );
		ret.append( ", limiteRegQhLim=" + this.limiteRegQhLim );
		ret.append( ", fabbCondiz=" + this.fabbCondiz );
		ret.append( ", domAcsQhw=" + this.domAcsQhw );
		ret.append( ", enAcsRinno=" + this.enAcsRinno );
		ret.append( ", rendAcsEtagacs=" + this.rendAcsEtagacs );
		ret.append( ", fabbAcs=" + this.fabbAcs );
		ret.append( ", fabbIllum=" + this.fabbIllum );
		return ret.toString();
	}

}
