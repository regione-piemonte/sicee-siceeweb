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

public class SiceeDDestUso2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_DEST_USO_2015 in the SICEE_D_DEST_USO_2015 table.
	 */
	protected Integer idDestUso2015;

	/** 
	 * This attribute maps to the column SIGLA in the SICEE_D_DEST_USO_2015 table.
	 */
	protected String sigla;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_DEST_USO_2015 table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_RESIDENZIALE in the SICEE_D_DEST_USO_2015 table.
	 */
	protected String flgResidenziale;

	/** 
	 * This attribute maps to the column FLG_ATTIVO in the SICEE_D_DEST_USO_2015 table.
	 */
	protected Integer flgAttivo;

	/**
	 * Method 'SiceeDDestUso2015'
	 * 
	 */
	public SiceeDDestUso2015()
	{
	}

	/**
	 * Method 'getIdDestUso2015'
	 * 
	 * @return Integer
	 */
	public Integer getIdDestUso2015()
	{
		return idDestUso2015;
	}

	/**
	 * Method 'setIdDestUso2015'
	 * 
	 * @param idDestUso2015
	 */
	public void setIdDestUso2015(Integer idDestUso2015)
	{
		this.idDestUso2015 = idDestUso2015;
	}

	/**
	 * Method 'getSigla'
	 * 
	 * @return String
	 */
	public String getSigla()
	{
		return sigla;
	}

	/**
	 * Method 'setSigla'
	 * 
	 * @param sigla
	 */
	public void setSigla(String sigla)
	{
		this.sigla = sigla;
	}

	/**
	 * Method 'getDescr'
	 * 
	 * @return String
	 */
	public String getDescr()
	{
		return descr;
	}

	/**
	 * Method 'setDescr'
	 * 
	 * @param descr
	 */
	public void setDescr(String descr)
	{
		this.descr = descr;
	}

	/**
	 * Method 'getFlgResidenziale'
	 * 
	 * @return String
	 */
	public String getFlgResidenziale()
	{
		return flgResidenziale;
	}

	/**
	 * Method 'setFlgResidenziale'
	 * 
	 * @param flgResidenziale
	 */
	public void setFlgResidenziale(String flgResidenziale)
	{
		this.flgResidenziale = flgResidenziale;
	}

	/**
	 * Method 'getFlgAttivo'
	 * 
	 * @return Integer
	 */
	public Integer getFlgAttivo()
	{
		return flgAttivo;
	}

	/**
	 * Method 'setFlgAttivo'
	 * 
	 * @param flgAttivo
	 */
	public void setFlgAttivo(Integer flgAttivo)
	{
		this.flgAttivo = flgAttivo;
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
		
		if (!(_other instanceof SiceeDDestUso2015)) {
			return false;
		}
		
		final SiceeDDestUso2015 _cast = (SiceeDDestUso2015) _other;
		if (idDestUso2015 == null ? _cast.idDestUso2015 != idDestUso2015 : !idDestUso2015.equals( _cast.idDestUso2015 )) {
			return false;
		}
		
		if (sigla == null ? _cast.sigla != sigla : !sigla.equals( _cast.sigla )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
			return false;
		}
		
		if (flgResidenziale == null ? _cast.flgResidenziale != flgResidenziale : !flgResidenziale.equals( _cast.flgResidenziale )) {
			return false;
		}
		
		if (flgAttivo == null ? _cast.flgAttivo != flgAttivo : !flgAttivo.equals( _cast.flgAttivo )) {
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
		if (idDestUso2015 != null) {
			_hashCode = 29 * _hashCode + idDestUso2015.hashCode();
		}
		
		if (sigla != null) {
			_hashCode = 29 * _hashCode + sigla.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		if (flgResidenziale != null) {
			_hashCode = 29 * _hashCode + flgResidenziale.hashCode();
		}
		
		if (flgAttivo != null) {
			_hashCode = 29 * _hashCode + flgAttivo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDDestUso2015Pk
	 */
	public SiceeDDestUso2015Pk createPk()
	{
		return new SiceeDDestUso2015Pk(idDestUso2015);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015: " );
		ret.append( "idDestUso2015=" + idDestUso2015 );
		ret.append( ", sigla=" + sigla );
		ret.append( ", descr=" + descr );
		ret.append( ", flgResidenziale=" + flgResidenziale );
		ret.append( ", flgAttivo=" + flgAttivo );
		return ret.toString();
	}

}
