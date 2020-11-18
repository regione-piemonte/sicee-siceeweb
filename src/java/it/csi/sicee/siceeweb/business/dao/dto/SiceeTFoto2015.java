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

public class SiceeTFoto2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_FOTO in the SICEE_T_FOTO_2015 table.
	 */
	protected long idFoto;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_FOTO_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_FOTO_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_FOTO_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column IDENTIFIC_FOTO in the SICEE_T_FOTO_2015 table.
	 */
	protected String identificFoto;

	/** 
	 * This attribute maps to the column NOME_FOTO in the SICEE_T_FOTO_2015 table.
	 */
	protected String nomeFoto;

	/** 
	 * This attribute maps to the column DT_FOTO in the SICEE_T_FOTO_2015 table.
	 */
	protected Date dtFoto;

	/** 
	 * This attribute maps to the column FLG_PRINCIPALE in the SICEE_T_FOTO_2015 table.
	 */
	protected String flgPrincipale;

	/** 
	 * This attribute maps to the column FK_TIPO_FOTO in the SICEE_T_FOTO_2015 table.
	 */
	protected long fkTipoFoto;

	/**
	 * Method 'SiceeTFoto2015'
	 * 
	 */
	public SiceeTFoto2015()
	{
	}

	/**
	 * Method 'getIdFoto'
	 * 
	 * @return long
	 */
	public long getIdFoto()
	{
		return idFoto;
	}

	/**
	 * Method 'setIdFoto'
	 * 
	 * @param idFoto
	 */
	public void setIdFoto(long idFoto)
	{
		this.idFoto = idFoto;
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
	 * Method 'getIdentificFoto'
	 * 
	 * @return String
	 */
	public String getIdentificFoto()
	{
		return identificFoto;
	}

	/**
	 * Method 'setIdentificFoto'
	 * 
	 * @param identificFoto
	 */
	public void setIdentificFoto(String identificFoto)
	{
		this.identificFoto = identificFoto;
	}

	/**
	 * Method 'getNomeFoto'
	 * 
	 * @return String
	 */
	public String getNomeFoto()
	{
		return nomeFoto;
	}

	/**
	 * Method 'setNomeFoto'
	 * 
	 * @param nomeFoto
	 */
	public void setNomeFoto(String nomeFoto)
	{
		this.nomeFoto = nomeFoto;
	}

	/**
	 * Method 'getDtFoto'
	 * 
	 * @return Date
	 */
	public Date getDtFoto()
	{
		return dtFoto;
	}

	/**
	 * Method 'setDtFoto'
	 * 
	 * @param dtFoto
	 */
	public void setDtFoto(Date dtFoto)
	{
		this.dtFoto = dtFoto;
	}

	/**
	 * Method 'getFlgPrincipale'
	 * 
	 * @return String
	 */
	public String getFlgPrincipale()
	{
		return flgPrincipale;
	}

	/**
	 * Method 'setFlgPrincipale'
	 * 
	 * @param flgPrincipale
	 */
	public void setFlgPrincipale(String flgPrincipale)
	{
		this.flgPrincipale = flgPrincipale;
	}

	/**
	 * Method 'getFkTipoFoto'
	 * 
	 * @return long
	 */
	public long getFkTipoFoto()
	{
		return fkTipoFoto;
	}

	/**
	 * Method 'setFkTipoFoto'
	 * 
	 * @param fkTipoFoto
	 */
	public void setFkTipoFoto(long fkTipoFoto)
	{
		this.fkTipoFoto = fkTipoFoto;
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
		
		if (!(_other instanceof SiceeTFoto2015)) {
			return false;
		}
		
		final SiceeTFoto2015 _cast = (SiceeTFoto2015) _other;
		if (idFoto != _cast.idFoto) {
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
		
		if (identificFoto == null ? _cast.identificFoto != identificFoto : !identificFoto.equals( _cast.identificFoto )) {
			return false;
		}
		
		if (nomeFoto == null ? _cast.nomeFoto != nomeFoto : !nomeFoto.equals( _cast.nomeFoto )) {
			return false;
		}
		
		if (dtFoto == null ? _cast.dtFoto != dtFoto : !dtFoto.equals( _cast.dtFoto )) {
			return false;
		}
		
		if (flgPrincipale == null ? _cast.flgPrincipale != flgPrincipale : !flgPrincipale.equals( _cast.flgPrincipale )) {
			return false;
		}
		
		if (fkTipoFoto != _cast.fkTipoFoto) {
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
		_hashCode = 29 * _hashCode + (int) (idFoto ^ (idFoto >>> 32));
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (identificFoto != null) {
			_hashCode = 29 * _hashCode + identificFoto.hashCode();
		}
		
		if (nomeFoto != null) {
			_hashCode = 29 * _hashCode + nomeFoto.hashCode();
		}
		
		if (dtFoto != null) {
			_hashCode = 29 * _hashCode + dtFoto.hashCode();
		}
		
		if (flgPrincipale != null) {
			_hashCode = 29 * _hashCode + flgPrincipale.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (fkTipoFoto ^ (fkTipoFoto >>> 32));
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTFoto2015Pk
	 */
	public SiceeTFoto2015Pk createPk()
	{
		return new SiceeTFoto2015Pk(idFoto);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015: " );
		ret.append( "idFoto=" + idFoto );
		ret.append( ", idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", identificFoto=" + identificFoto );
		ret.append( ", nomeFoto=" + nomeFoto );
		ret.append( ", dtFoto=" + dtFoto );
		ret.append( ", flgPrincipale=" + flgPrincipale );
		ret.append( ", fkTipoFoto=" + fkTipoFoto );
		return ret.toString();
	}

}
