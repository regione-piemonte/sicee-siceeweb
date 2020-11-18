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

public class SiceeDRuoloCert2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_RUOLO_CERT in the SICEE_D_RUOLO_CERT_2015 table.
	 */
	protected long idRuoloCert;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_RUOLO_CERT_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDRuoloCert2015'
	 * 
	 */
	public SiceeDRuoloCert2015()
	{
	}

	/**
	 * Method 'getIdRuoloCert'
	 * 
	 * @return long
	 */
	public long getIdRuoloCert()
	{
		return idRuoloCert;
	}

	/**
	 * Method 'setIdRuoloCert'
	 * 
	 * @param idRuoloCert
	 */
	public void setIdRuoloCert(long idRuoloCert)
	{
		this.idRuoloCert = idRuoloCert;
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
		
		if (!(_other instanceof SiceeDRuoloCert2015)) {
			return false;
		}
		
		final SiceeDRuoloCert2015 _cast = (SiceeDRuoloCert2015) _other;
		if (idRuoloCert != _cast.idRuoloCert) {
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
		_hashCode = 29 * _hashCode + (int) (idRuoloCert ^ (idRuoloCert >>> 32));
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDRuoloCert2015Pk
	 */
	public SiceeDRuoloCert2015Pk createPk()
	{
		return new SiceeDRuoloCert2015Pk(idRuoloCert);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloCert2015: " );
		ret.append( "idRuoloCert=" + idRuoloCert );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
