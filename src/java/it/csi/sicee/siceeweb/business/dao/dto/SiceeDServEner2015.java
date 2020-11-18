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

public class SiceeDServEner2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_SERV_ENER in the SICEE_D_SERV_ENER_2015 table.
	 */
	protected Integer idServEner;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_SERV_ENER_2015 table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_ATTIVO in the SICEE_D_SERV_ENER_2015 table.
	 */
	protected Integer flgAttivo;

	/**
	 * Method 'SiceeDServEner2015'
	 * 
	 */
	public SiceeDServEner2015()
	{
	}

	/**
	 * Method 'getIdServEner'
	 * 
	 * @return Integer
	 */
	public Integer getIdServEner()
	{
		return idServEner;
	}

	/**
	 * Method 'setIdServEner'
	 * 
	 * @param idServEner
	 */
	public void setIdServEner(Integer idServEner)
	{
		this.idServEner = idServEner;
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
	 * Method 'getFlgAttivo'
	 * 
	 * @return Integer
	 */
	public Integer getFlgAttivo()
	{
		return flgAttivo;
	}

	/**
	 * Method 'setFlgAttivo'
	 * 
	 * @param flgAttivo
	 */
	public void setFlgAttivo(Integer flgAttivo)
	{
		this.flgAttivo = flgAttivo;
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
		
		if (!(_other instanceof SiceeDServEner2015)) {
			return false;
		}
		
		final SiceeDServEner2015 _cast = (SiceeDServEner2015) _other;
		if (idServEner == null ? _cast.idServEner != idServEner : !idServEner.equals( _cast.idServEner )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
			return false;
		}
		
		if (flgAttivo == null ? _cast.flgAttivo != flgAttivo : !flgAttivo.equals( _cast.flgAttivo )) {
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
		if (idServEner != null) {
			_hashCode = 29 * _hashCode + idServEner.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		if (flgAttivo != null) {
			_hashCode = 29 * _hashCode + flgAttivo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDServEner2015Pk
	 */
	public SiceeDServEner2015Pk createPk()
	{
		return new SiceeDServEner2015Pk(idServEner);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDServEner2015: " );
		ret.append( "idServEner=" + idServEner );
		ret.append( ", descr=" + descr );
		ret.append( ", flgAttivo=" + flgAttivo );
		return ret.toString();
	}

}
