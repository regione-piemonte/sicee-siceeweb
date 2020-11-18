/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_DOC_INDEX_2015 table.
 */
public class SiceeDTipoDocIndex2015Pk implements Serializable
{
	protected Integer idTipoDoc;

	/** 
	 * Sets the value of idTipoDoc
	 */
	public void setIdTipoDoc(Integer idTipoDoc)
	{
		this.idTipoDoc = idTipoDoc;
	}

	/** 
	 * Gets the value of idTipoDoc
	 */
	public Integer getIdTipoDoc()
	{
		return idTipoDoc;
	}

	/**
	 * Method 'SiceeDTipoDocIndex2015Pk'
	 * 
	 */
	public SiceeDTipoDocIndex2015Pk()
	{
	}

	/**
	 * Method 'SiceeDTipoDocIndex2015Pk'
	 * 
	 * @param idTipoDoc
	 */
	public SiceeDTipoDocIndex2015Pk(final Integer idTipoDoc)
	{
		this.idTipoDoc = idTipoDoc;
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
		
		if (!(_other instanceof SiceeDTipoDocIndex2015Pk)) {
			return false;
		}
		
		final SiceeDTipoDocIndex2015Pk _cast = (SiceeDTipoDocIndex2015Pk) _other;
		if (idTipoDoc == null ? _cast.idTipoDoc != idTipoDoc : !idTipoDoc.equals( _cast.idTipoDoc )) {
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
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocIndex2015Pk: " );
		ret.append( "idTipoDoc=" + idTipoDoc );
		return ret.toString();
	}

}
