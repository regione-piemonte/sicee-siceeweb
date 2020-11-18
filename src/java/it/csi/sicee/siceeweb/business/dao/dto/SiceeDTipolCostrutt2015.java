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

public class SiceeDTipolCostrutt2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPOL_COSTRUTT in the SICEE_D_TIPOL_COSTRUTT_2015 table.
	 */
	protected Integer idTipolCostrutt;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPOL_COSTRUTT_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipolCostrutt2015'
	 * 
	 */
	public SiceeDTipolCostrutt2015()
	{
	}

	/**
	 * Method 'getIdTipolCostrutt'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipolCostrutt()
	{
		return idTipolCostrutt;
	}

	/**
	 * Method 'setIdTipolCostrutt'
	 * 
	 * @param idTipolCostrutt
	 */
	public void setIdTipolCostrutt(Integer idTipolCostrutt)
	{
		this.idTipolCostrutt = idTipolCostrutt;
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
		
		if (!(_other instanceof SiceeDTipolCostrutt2015)) {
			return false;
		}
		
		final SiceeDTipolCostrutt2015 _cast = (SiceeDTipolCostrutt2015) _other;
		if (idTipolCostrutt == null ? _cast.idTipolCostrutt != idTipolCostrutt : !idTipolCostrutt.equals( _cast.idTipolCostrutt )) {
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
		if (idTipolCostrutt != null) {
			_hashCode = 29 * _hashCode + idTipolCostrutt.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipolCostrutt2015Pk
	 */
	public SiceeDTipolCostrutt2015Pk createPk()
	{
		return new SiceeDTipolCostrutt2015Pk(idTipolCostrutt);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015: " );
		ret.append( "idTipolCostrutt=" + idTipolCostrutt );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
