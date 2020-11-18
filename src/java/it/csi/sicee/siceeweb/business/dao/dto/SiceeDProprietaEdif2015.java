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

public class SiceeDProprietaEdif2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_PROPRIETA_EDI in the SICEE_D_PROPRIETA_EDIF_2015 table.
	 */
	protected Integer idProprietaEdi;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_PROPRIETA_EDIF_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDProprietaEdif2015'
	 * 
	 */
	public SiceeDProprietaEdif2015()
	{
	}

	/**
	 * Method 'getIdProprietaEdi'
	 * 
	 * @return Integer
	 */
	public Integer getIdProprietaEdi()
	{
		return idProprietaEdi;
	}

	/**
	 * Method 'setIdProprietaEdi'
	 * 
	 * @param idProprietaEdi
	 */
	public void setIdProprietaEdi(Integer idProprietaEdi)
	{
		this.idProprietaEdi = idProprietaEdi;
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
		
		if (!(_other instanceof SiceeDProprietaEdif2015)) {
			return false;
		}
		
		final SiceeDProprietaEdif2015 _cast = (SiceeDProprietaEdif2015) _other;
		if (idProprietaEdi == null ? _cast.idProprietaEdi != idProprietaEdi : !idProprietaEdi.equals( _cast.idProprietaEdi )) {
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
		if (idProprietaEdi != null) {
			_hashCode = 29 * _hashCode + idProprietaEdi.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDProprietaEdif2015Pk
	 */
	public SiceeDProprietaEdif2015Pk createPk()
	{
		return new SiceeDProprietaEdif2015Pk(idProprietaEdi);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015: " );
		ret.append( "idProprietaEdi=" + idProprietaEdi );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
