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

public class SiceeDTipoDocIndex2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_DOC in the SICEE_D_TIPO_DOC_INDEX_2015 table.
	 */
	protected Integer idTipoDoc;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_DOC_INDEX_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipoDocIndex2015'
	 * 
	 */
	public SiceeDTipoDocIndex2015()
	{
	}

	/**
	 * Method 'getIdTipoDoc'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoDoc()
	{
		return idTipoDoc;
	}

	/**
	 * Method 'setIdTipoDoc'
	 * 
	 * @param idTipoDoc
	 */
	public void setIdTipoDoc(Integer idTipoDoc)
	{
		this.idTipoDoc = idTipoDoc;
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
		
		if (!(_other instanceof SiceeDTipoDocIndex2015)) {
			return false;
		}
		
		final SiceeDTipoDocIndex2015 _cast = (SiceeDTipoDocIndex2015) _other;
		if (idTipoDoc == null ? _cast.idTipoDoc != idTipoDoc : !idTipoDoc.equals( _cast.idTipoDoc )) {
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
		if (idTipoDoc != null) {
			_hashCode = 29 * _hashCode + idTipoDoc.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoDocIndex2015Pk
	 */
	public SiceeDTipoDocIndex2015Pk createPk()
	{
		return new SiceeDTipoDocIndex2015Pk(idTipoDoc);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocIndex2015: " );
		ret.append( "idTipoDoc=" + idTipoDoc );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
