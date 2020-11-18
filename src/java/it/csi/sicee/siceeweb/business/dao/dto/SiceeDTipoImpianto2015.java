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

public class SiceeDTipoImpianto2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_IMPIANTO in the SICEE_D_TIPO_IMPIANTO_2015 table.
	 */
	protected Integer idTipoImpianto;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_IMPIANTO_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipoImpianto2015'
	 * 
	 */
	public SiceeDTipoImpianto2015()
	{
	}

	/**
	 * Method 'getIdTipoImpianto'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoImpianto()
	{
		return idTipoImpianto;
	}

	/**
	 * Method 'setIdTipoImpianto'
	 * 
	 * @param idTipoImpianto
	 */
	public void setIdTipoImpianto(Integer idTipoImpianto)
	{
		this.idTipoImpianto = idTipoImpianto;
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
		
		if (!(_other instanceof SiceeDTipoImpianto2015)) {
			return false;
		}
		
		final SiceeDTipoImpianto2015 _cast = (SiceeDTipoImpianto2015) _other;
		if (idTipoImpianto == null ? _cast.idTipoImpianto != idTipoImpianto : !idTipoImpianto.equals( _cast.idTipoImpianto )) {
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
		if (idTipoImpianto != null) {
			_hashCode = 29 * _hashCode + idTipoImpianto.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoImpianto2015Pk
	 */
	public SiceeDTipoImpianto2015Pk createPk()
	{
		return new SiceeDTipoImpianto2015Pk(idTipoImpianto);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015: " );
		ret.append( "idTipoImpianto=" + idTipoImpianto );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
