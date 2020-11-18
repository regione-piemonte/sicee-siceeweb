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

public class SiceeDTipoIstruzione implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_ISTRUZIONE in the SICEE_D_TIPO_ISTRUZIONE table.
	 */
	protected Integer idTipoIstruzione;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_ISTRUZIONE table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipoIstruzione'
	 * 
	 */
	public SiceeDTipoIstruzione()
	{
	}

	/**
	 * Method 'getIdTipoIstruzione'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoIstruzione()
	{
		return idTipoIstruzione;
	}

	/**
	 * Method 'setIdTipoIstruzione'
	 * 
	 * @param idTipoIstruzione
	 */
	public void setIdTipoIstruzione(Integer idTipoIstruzione)
	{
		this.idTipoIstruzione = idTipoIstruzione;
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
		
		if (!(_other instanceof SiceeDTipoIstruzione)) {
			return false;
		}
		
		final SiceeDTipoIstruzione _cast = (SiceeDTipoIstruzione) _other;
		if (idTipoIstruzione == null ? _cast.idTipoIstruzione != idTipoIstruzione : !idTipoIstruzione.equals( _cast.idTipoIstruzione )) {
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
		if (idTipoIstruzione != null) {
			_hashCode = 29 * _hashCode + idTipoIstruzione.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoIstruzionePk
	 */
	public SiceeDTipoIstruzionePk createPk()
	{
		return new SiceeDTipoIstruzionePk(idTipoIstruzione);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzione: " );
		ret.append( "idTipoIstruzione=" + idTipoIstruzione );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
