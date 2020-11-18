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

public class SiceeDTipoFoto2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_FOTO in the SICEE_D_TIPO_FOTO_2015 table.
	 */
	protected long idTipoFoto;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_FOTO_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipoFoto2015'
	 * 
	 */
	public SiceeDTipoFoto2015()
	{
	}

	/**
	 * Method 'getIdTipoFoto'
	 * 
	 * @return long
	 */
	public long getIdTipoFoto()
	{
		return idTipoFoto;
	}

	/**
	 * Method 'setIdTipoFoto'
	 * 
	 * @param idTipoFoto
	 */
	public void setIdTipoFoto(long idTipoFoto)
	{
		this.idTipoFoto = idTipoFoto;
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
		
		if (!(_other instanceof SiceeDTipoFoto2015)) {
			return false;
		}
		
		final SiceeDTipoFoto2015 _cast = (SiceeDTipoFoto2015) _other;
		if (idTipoFoto != _cast.idTipoFoto) {
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
		_hashCode = 29 * _hashCode + (int) (idTipoFoto ^ (idTipoFoto >>> 32));
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoFoto2015Pk
	 */
	public SiceeDTipoFoto2015Pk createPk()
	{
		return new SiceeDTipoFoto2015Pk(idTipoFoto);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015: " );
		ret.append( "idTipoFoto=" + idTipoFoto );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
