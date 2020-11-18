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

public class SiceeDUnitaMisura2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_UNITA_MISURA in the SICEE_D_UNITA_MISURA_2015 table.
	 */
	protected Integer idUnitaMisura;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_UNITA_MISURA_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDUnitaMisura2015'
	 * 
	 */
	public SiceeDUnitaMisura2015()
	{
	}

	/**
	 * Method 'getIdUnitaMisura'
	 * 
	 * @return Integer
	 */
	public Integer getIdUnitaMisura()
	{
		return idUnitaMisura;
	}

	/**
	 * Method 'setIdUnitaMisura'
	 * 
	 * @param idUnitaMisura
	 */
	public void setIdUnitaMisura(Integer idUnitaMisura)
	{
		this.idUnitaMisura = idUnitaMisura;
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
		
		if (!(_other instanceof SiceeDUnitaMisura2015)) {
			return false;
		}
		
		final SiceeDUnitaMisura2015 _cast = (SiceeDUnitaMisura2015) _other;
		if (idUnitaMisura == null ? _cast.idUnitaMisura != idUnitaMisura : !idUnitaMisura.equals( _cast.idUnitaMisura )) {
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
		if (idUnitaMisura != null) {
			_hashCode = 29 * _hashCode + idUnitaMisura.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDUnitaMisura2015Pk
	 */
	public SiceeDUnitaMisura2015Pk createPk()
	{
		return new SiceeDUnitaMisura2015Pk(idUnitaMisura);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015: " );
		ret.append( "idUnitaMisura=" + idUnitaMisura );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
