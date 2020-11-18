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

public class SiceeDTipoRistrutt2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_RISTRUTTURAZ in the SICEE_D_TIPO_RISTRUTT_2015 table.
	 */
	protected Integer idTipoRistrutturaz;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_RISTRUTT_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipoRistrutt2015'
	 * 
	 */
	public SiceeDTipoRistrutt2015()
	{
	}

	/**
	 * Method 'getIdTipoRistrutturaz'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoRistrutturaz()
	{
		return idTipoRistrutturaz;
	}

	/**
	 * Method 'setIdTipoRistrutturaz'
	 * 
	 * @param idTipoRistrutturaz
	 */
	public void setIdTipoRistrutturaz(Integer idTipoRistrutturaz)
	{
		this.idTipoRistrutturaz = idTipoRistrutturaz;
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
		
		if (!(_other instanceof SiceeDTipoRistrutt2015)) {
			return false;
		}
		
		final SiceeDTipoRistrutt2015 _cast = (SiceeDTipoRistrutt2015) _other;
		if (idTipoRistrutturaz == null ? _cast.idTipoRistrutturaz != idTipoRistrutturaz : !idTipoRistrutturaz.equals( _cast.idTipoRistrutturaz )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
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
		if (idTipoRistrutturaz != null) {
			_hashCode = 29 * _hashCode + idTipoRistrutturaz.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoRistrutt2015Pk
	 */
	public SiceeDTipoRistrutt2015Pk createPk()
	{
		return new SiceeDTipoRistrutt2015Pk(idTipoRistrutturaz);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015: " );
		ret.append( "idTipoRistrutturaz=" + idTipoRistrutturaz );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
