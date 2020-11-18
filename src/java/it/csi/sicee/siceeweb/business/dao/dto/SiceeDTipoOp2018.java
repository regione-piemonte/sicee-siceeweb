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

public class SiceeDTipoOp2018 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_OP_2018 in the SICEE_D_TIPO_OP_2018 table.
	 */
	protected Integer idTipoOp2018;

	/** 
	 * This attribute maps to the column DESCR_TIPO_OP_2018 in the SICEE_D_TIPO_OP_2018 table.
	 */
	protected String descrTipoOp2018;

	/**
	 * Method 'SiceeDTipoOp2018'
	 * 
	 */
	public SiceeDTipoOp2018()
	{
	}

	/**
	 * Method 'getIdTipoOp2018'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoOp2018()
	{
		return idTipoOp2018;
	}

	/**
	 * Method 'setIdTipoOp2018'
	 * 
	 * @param idTipoOp2018
	 */
	public void setIdTipoOp2018(Integer idTipoOp2018)
	{
		this.idTipoOp2018 = idTipoOp2018;
	}

	/**
	 * Method 'getDescrTipoOp2018'
	 * 
	 * @return String
	 */
	public String getDescrTipoOp2018()
	{
		return descrTipoOp2018;
	}

	/**
	 * Method 'setDescrTipoOp2018'
	 * 
	 * @param descrTipoOp2018
	 */
	public void setDescrTipoOp2018(String descrTipoOp2018)
	{
		this.descrTipoOp2018 = descrTipoOp2018;
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
		
		if (!(_other instanceof SiceeDTipoOp2018)) {
			return false;
		}
		
		final SiceeDTipoOp2018 _cast = (SiceeDTipoOp2018) _other;
		if (idTipoOp2018 == null ? _cast.idTipoOp2018 != idTipoOp2018 : !idTipoOp2018.equals( _cast.idTipoOp2018 )) {
			return false;
		}
		
		if (descrTipoOp2018 == null ? _cast.descrTipoOp2018 != descrTipoOp2018 : !descrTipoOp2018.equals( _cast.descrTipoOp2018 )) {
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
		if (idTipoOp2018 != null) {
			_hashCode = 29 * _hashCode + idTipoOp2018.hashCode();
		}
		
		if (descrTipoOp2018 != null) {
			_hashCode = 29 * _hashCode + descrTipoOp2018.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoOp2018Pk
	 */
	public SiceeDTipoOp2018Pk createPk()
	{
		return new SiceeDTipoOp2018Pk(idTipoOp2018);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoOp2018: " );
		ret.append( "idTipoOp2018=" + idTipoOp2018 );
		ret.append( ", descrTipoOp2018=" + descrTipoOp2018 );
		return ret.toString();
	}

}
