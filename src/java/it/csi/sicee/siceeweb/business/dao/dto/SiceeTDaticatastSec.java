/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTDaticatastSec implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3039936128191799107L;

	/** 
	 * This attribute maps to the column ID_DATICATAST_SEC in the SICEE_T_DATICATAST_SEC table.
	 */
	protected Integer idDaticatastSec;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column SEZIONE in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String sezione;

	/** 
	 * This attribute maps to the column FOGLIO in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String foglio;

	/** 
	 * This attribute maps to the column PARTICELLA in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String particella;

	/** 
	 * This attribute maps to the column SUBALTERNO in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String subalterno;

	/** 
	 * This attribute maps to the column FLG_SIGMATER in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String flgSigmater;

	/** 
	 * This attribute maps to the column ID_PROV in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String idProv;

	/** 
	 * This attribute maps to the column DESC_PROV in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String descProv;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String idComune;

	/** 
	 * This attribute maps to the column DESC_COMUNE in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String descComune;

	/** 
	 * This attribute maps to the column CODICE_COMUNE_CATASTALE in the SICEE_T_DATICATAST_SEC table.
	 */
	protected String codiceComuneCatastale;
	
	/**
	 * Method 'SiceeTDaticatastSec'
	 * 
	 */
	public SiceeTDaticatastSec()
	{
	}

	/**
	 * Method 'getIdDaticatastSec'
	 * 
	 * @return Integer
	 */
	public Integer getIdDaticatastSec()
	{
		return this.idDaticatastSec;
	}

	/**
	 * Method 'setIdDaticatastSec'
	 * 
	 * @param idDaticatastSec
	 */
	public void setIdDaticatastSec(Integer idDaticatastSec)
	{
		this.idDaticatastSec = idDaticatastSec;
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
	 * Method 'getSezione'
	 * 
	 * @return String
	 */
	public String getSezione()
	{
		return this.sezione;
	}

	/**
	 * Method 'setSezione'
	 * 
	 * @param sezione
	 */
	public void setSezione(String sezione)
	{
		this.sezione = sezione;
	}

	/**
	 * Method 'getFoglio'
	 * 
	 * @return String
	 */
	public String getFoglio()
	{
		return this.foglio;
	}

	/**
	 * Method 'setFoglio'
	 * 
	 * @param foglio
	 */
	public void setFoglio(String foglio)
	{
		this.foglio = foglio;
	}

	/**
	 * Method 'getParticella'
	 * 
	 * @return String
	 */
	public String getParticella()
	{
		return this.particella;
	}

	/**
	 * Method 'setParticella'
	 * 
	 * @param particella
	 */
	public void setParticella(String particella)
	{
		this.particella = particella;
	}

	/**
	 * Method 'getSubalterno'
	 * 
	 * @return String
	 */
	public String getSubalterno()
	{
		return this.subalterno;
	}

	/**
	 * Method 'setSubalterno'
	 * 
	 * @param subalterno
	 */
	public void setSubalterno(String subalterno)
	{
		this.subalterno = subalterno;
	}

	/**
	 * Method 'getFlgSigmater'
	 * 
	 * @return String
	 */
	public String getFlgSigmater()
	{
		return this.flgSigmater;
	}

	/**
	 * Method 'setFlgSigmater'
	 * 
	 * @param flgSigmater
	 */
	public void setFlgSigmater(String flgSigmater)
	{
		this.flgSigmater = flgSigmater;
	}

	/**
	 * Method 'getIdProv'
	 * 
	 * @return String
	 */
	public String getIdProv()
	{
		return this.idProv;
	}

	/**
	 * Method 'setIdProv'
	 * 
	 * @param idProv
	 */
	public void setIdProv(String idProv)
	{
		this.idProv = idProv;
	}

	/**
	 * Method 'getDescProv'
	 * 
	 * @return String
	 */
	public String getDescProv()
	{
		return this.descProv;
	}

	/**
	 * Method 'setDescProv'
	 * 
	 * @param descProv
	 */
	public void setDescProv(String descProv)
	{
		this.descProv = descProv;
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
	 * Method 'getDescComune'
	 * 
	 * @return String
	 */
	public String getDescComune()
	{
		return this.descComune;
	}

	/**
	 * Method 'setDescComune'
	 * 
	 * @param descComune
	 */
	public void setDescComune(String descComune)
	{
		this.descComune = descComune;
	}

	/**
	 * Method 'getCodiceComuneCatastale'
	 * 
	 * @return String
	 */
	public String getCodiceComuneCatastale()
	{
		return this.codiceComuneCatastale;
	}

	/**
	 * Method 'setCodiceComuneCatastale'
	 * 
	 * @param codiceComuneCatastale
	 */
	public void setCodiceComuneCatastale(String codiceComuneCatastale)
	{
		this.codiceComuneCatastale = codiceComuneCatastale;
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
		
		if (!(_other instanceof SiceeTDaticatastSec)) {
			return false;
		}
		
		final SiceeTDaticatastSec _cast = (SiceeTDaticatastSec) _other;
		if (this.idDaticatastSec == null ? _cast.idDaticatastSec != this.idDaticatastSec : !this.idDaticatastSec.equals( _cast.idDaticatastSec )) {
			return false;
		}
		
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.sezione == null ? _cast.sezione != this.sezione : !this.sezione.equals( _cast.sezione )) {
			return false;
		}
		
		if (this.foglio == null ? _cast.foglio != this.foglio : !this.foglio.equals( _cast.foglio )) {
			return false;
		}
		
		if (this.particella == null ? _cast.particella != this.particella : !this.particella.equals( _cast.particella )) {
			return false;
		}
		
		if (this.subalterno == null ? _cast.subalterno != this.subalterno : !this.subalterno.equals( _cast.subalterno )) {
			return false;
		}
		
		if (this.flgSigmater == null ? _cast.flgSigmater != this.flgSigmater : !this.flgSigmater.equals( _cast.flgSigmater )) {
			return false;
		}
		
		if (this.idProv == null ? _cast.idProv != this.idProv : !this.idProv.equals( _cast.idProv )) {
			return false;
		}
		
		if (this.descProv == null ? _cast.descProv != this.descProv : !this.descProv.equals( _cast.descProv )) {
			return false;
		}
		
		if (this.idComune == null ? _cast.idComune != this.idComune : !this.idComune.equals( _cast.idComune )) {
			return false;
		}
		
		if (this.descComune == null ? _cast.descComune != this.descComune : !this.descComune.equals( _cast.descComune )) {
			return false;
		}
		
		if (this.codiceComuneCatastale == null ? _cast.codiceComuneCatastale != this.codiceComuneCatastale : !this.codiceComuneCatastale.equals( _cast.codiceComuneCatastale )) {
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
		if (this.idDaticatastSec != null) {
			_hashCode = 29 * _hashCode + this.idDaticatastSec.hashCode();
		}
		
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.sezione != null) {
			_hashCode = 29 * _hashCode + this.sezione.hashCode();
		}
		
		if (this.foglio != null) {
			_hashCode = 29 * _hashCode + this.foglio.hashCode();
		}
		
		if (this.particella != null) {
			_hashCode = 29 * _hashCode + this.particella.hashCode();
		}
		
		if (this.subalterno != null) {
			_hashCode = 29 * _hashCode + this.subalterno.hashCode();
		}
		
		if (this.flgSigmater != null) {
			_hashCode = 29 * _hashCode + this.flgSigmater.hashCode();
		}
		
		if (this.idProv != null) {
			_hashCode = 29 * _hashCode + this.idProv.hashCode();
		}
		
		if (this.descProv != null) {
			_hashCode = 29 * _hashCode + this.descProv.hashCode();
		}
		
		if (this.idComune != null) {
			_hashCode = 29 * _hashCode + this.idComune.hashCode();
		}
		
		if (this.descComune != null) {
			_hashCode = 29 * _hashCode + this.descComune.hashCode();
		}
		
		if (codiceComuneCatastale != null) {
			_hashCode = 29 * _hashCode + this.codiceComuneCatastale.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDaticatastSecPk
	 */
	public SiceeTDaticatastSecPk createPk()
	{
		return new SiceeTDaticatastSecPk(this.idDaticatastSec);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec: " );
		ret.append( "idDaticatastSec=" + this.idDaticatastSec );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", sezione=" + this.sezione );
		ret.append( ", foglio=" + this.foglio );
		ret.append( ", particella=" + this.particella );
		ret.append( ", subalterno=" + this.subalterno );
		ret.append( ", flgSigmater=" + this.flgSigmater );
		ret.append( ", idProv=" + this.idProv );
		ret.append( ", descProv=" + this.descProv );
		ret.append( ", idComune=" + this.idComune );
		ret.append( ", descComune=" + this.descComune );
		ret.append( ", codiceComuneCatastale=" + this.codiceComuneCatastale );

		return ret.toString();
	}

}
