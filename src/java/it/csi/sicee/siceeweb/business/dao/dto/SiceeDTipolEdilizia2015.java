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

public class SiceeDTipolEdilizia2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPOL_EDILIZIA in the SICEE_D_TIPOL_EDILIZIA_2015 table.
	 */
	protected Integer idTipolEdilizia;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPOL_EDILIZIA_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipolEdilizia2015'
	 * 
	 */
	public SiceeDTipolEdilizia2015()
	{
	}

	/**
	 * Method 'getIdTipolEdilizia'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipolEdilizia()
	{
		return idTipolEdilizia;
	}

	/**
	 * Method 'setIdTipolEdilizia'
	 * 
	 * @param idTipolEdilizia
	 */
	public void setIdTipolEdilizia(Integer idTipolEdilizia)
	{
		this.idTipolEdilizia = idTipolEdilizia;
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
		
		if (!(_other instanceof SiceeDTipolEdilizia2015)) {
			return false;
		}
		
		final SiceeDTipolEdilizia2015 _cast = (SiceeDTipolEdilizia2015) _other;
		if (idTipolEdilizia == null ? _cast.idTipolEdilizia != idTipolEdilizia : !idTipolEdilizia.equals( _cast.idTipolEdilizia )) {
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
		if (idTipolEdilizia != null) {
			_hashCode = 29 * _hashCode + idTipolEdilizia.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipolEdilizia2015Pk
	 */
	public SiceeDTipolEdilizia2015Pk createPk()
	{
		return new SiceeDTipolEdilizia2015Pk(idTipolEdilizia);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015: " );
		ret.append( "idTipolEdilizia=" + idTipolEdilizia );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
