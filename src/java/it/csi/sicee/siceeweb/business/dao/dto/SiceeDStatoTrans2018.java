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

public class SiceeDStatoTrans2018 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_STATO_TRANS_2018 in the SICEE_D_STATO_TRANS_2018 table.
	 */
	protected Integer idStatoTrans2018;

	/** 
	 * This attribute maps to the column DESCR_STATO_TRANS in the SICEE_D_STATO_TRANS_2018 table.
	 */
	protected String descrStatoTrans;

	/**
	 * Method 'SiceeDStatoTrans2018'
	 * 
	 */
	public SiceeDStatoTrans2018()
	{
	}

	/**
	 * Method 'getIdStatoTrans2018'
	 * 
	 * @return Integer
	 */
	public Integer getIdStatoTrans2018()
	{
		return idStatoTrans2018;
	}

	/**
	 * Method 'setIdStatoTrans2018'
	 * 
	 * @param idStatoTrans2018
	 */
	public void setIdStatoTrans2018(Integer idStatoTrans2018)
	{
		this.idStatoTrans2018 = idStatoTrans2018;
	}

	/**
	 * Method 'getDescrStatoTrans'
	 * 
	 * @return String
	 */
	public String getDescrStatoTrans()
	{
		return descrStatoTrans;
	}

	/**
	 * Method 'setDescrStatoTrans'
	 * 
	 * @param descrStatoTrans
	 */
	public void setDescrStatoTrans(String descrStatoTrans)
	{
		this.descrStatoTrans = descrStatoTrans;
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
		
		if (!(_other instanceof SiceeDStatoTrans2018)) {
			return false;
		}
		
		final SiceeDStatoTrans2018 _cast = (SiceeDStatoTrans2018) _other;
		if (idStatoTrans2018 == null ? _cast.idStatoTrans2018 != idStatoTrans2018 : !idStatoTrans2018.equals( _cast.idStatoTrans2018 )) {
			return false;
		}
		
		if (descrStatoTrans == null ? _cast.descrStatoTrans != descrStatoTrans : !descrStatoTrans.equals( _cast.descrStatoTrans )) {
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
		if (idStatoTrans2018 != null) {
			_hashCode = 29 * _hashCode + idStatoTrans2018.hashCode();
		}
		
		if (descrStatoTrans != null) {
			_hashCode = 29 * _hashCode + descrStatoTrans.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDStatoTrans2018Pk
	 */
	public SiceeDStatoTrans2018Pk createPk()
	{
		return new SiceeDStatoTrans2018Pk(idStatoTrans2018);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTrans2018: " );
		ret.append( "idStatoTrans2018=" + idStatoTrans2018 );
		ret.append( ", descrStatoTrans=" + descrStatoTrans );
		return ret.toString();
	}

}
