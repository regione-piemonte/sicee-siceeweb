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

public class SiceeDRiqEner2015 implements Serializable
{
	/** 
	 * This attribute maps to the column CODICE_REN in the SICEE_D_RIQ_ENER_2015 table.
	 */
	protected String codiceRen;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_RIQ_ENER_2015 table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column ID_XML in the SICEE_D_RIQ_ENER_2015 table.
	 */
	protected Integer idXml;
	
	/**
	 * Method 'SiceeDRiqEner2015'
	 * 
	 */
	public SiceeDRiqEner2015()
	{
	}

	/**
	 * Method 'getCodiceRen'
	 * 
	 * @return String
	 */
	public String getCodiceRen()
	{
		return codiceRen;
	}

	/**
	 * Method 'setCodiceRen'
	 * 
	 * @param codiceRen
	 */
	public void setCodiceRen(String codiceRen)
	{
		this.codiceRen = codiceRen;
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

	
	public Integer getIdXml() {
		return idXml;
	}

	public void setIdXml(Integer idXml) {
		this.idXml = idXml;
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
		
		if (!(_other instanceof SiceeDRiqEner2015)) {
			return false;
		}
		
		final SiceeDRiqEner2015 _cast = (SiceeDRiqEner2015) _other;
		if (codiceRen == null ? _cast.codiceRen != codiceRen : !codiceRen.equals( _cast.codiceRen )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
			return false;
		}
		
		if (idXml == null ? _cast.idXml != idXml : !idXml.equals( _cast.idXml )) {
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
		if (codiceRen != null) {
			_hashCode = 29 * _hashCode + codiceRen.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		if (idXml != null) {
			_hashCode = 29 * _hashCode + idXml.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDRiqEner2015Pk
	 */
	public SiceeDRiqEner2015Pk createPk()
	{
		return new SiceeDRiqEner2015Pk(codiceRen);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015: " );
		ret.append( "codiceRen=" + codiceRen );
		ret.append( ", descr=" + descr );
		ret.append( ", idXml=" + idXml );
		return ret.toString();
	}

}
