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

public class SiceeDOggettoApe2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_OGGETTO_APE in the SICEE_D_OGGETTO_APE_2015 table.
	 */
	protected long idOggettoApe;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_OGGETTO_APE_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDOggettoApe2015'
	 * 
	 */
	public SiceeDOggettoApe2015()
	{
	}

	/**
	 * Method 'getIdOggettoApe'
	 * 
	 * @return long
	 */
	public long getIdOggettoApe()
	{
		return idOggettoApe;
	}

	/**
	 * Method 'setIdOggettoApe'
	 * 
	 * @param idOggettoApe
	 */
	public void setIdOggettoApe(long idOggettoApe)
	{
		this.idOggettoApe = idOggettoApe;
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
		
		if (!(_other instanceof SiceeDOggettoApe2015)) {
			return false;
		}
		
		final SiceeDOggettoApe2015 _cast = (SiceeDOggettoApe2015) _other;
		if (idOggettoApe != _cast.idOggettoApe) {
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
		_hashCode = 29 * _hashCode + (int) (idOggettoApe ^ (idOggettoApe >>> 32));
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDOggettoApe2015Pk
	 */
	public SiceeDOggettoApe2015Pk createPk()
	{
		return new SiceeDOggettoApe2015Pk(idOggettoApe);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015: " );
		ret.append( "idOggettoApe=" + idOggettoApe );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
