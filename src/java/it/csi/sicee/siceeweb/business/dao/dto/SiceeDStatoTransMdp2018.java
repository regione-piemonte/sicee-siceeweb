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

public class SiceeDStatoTransMdp2018 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_STATO_TRANS_MDP_2018 in the SICEE_D_STATO_TRANS_MDP_2018 table.
	 */
	protected Integer idStatoTransMdp2018;

	/** 
	 * This attribute maps to the column DESCR_STATO_TRANS_MDP in the SICEE_D_STATO_TRANS_MDP_2018 table.
	 */
	protected String descrStatoTransMdp;

	/**
	 * Method 'SiceeDStatoTransMdp2018'
	 * 
	 */
	public SiceeDStatoTransMdp2018()
	{
	}

	/**
	 * Method 'getIdStatoTransMdp2018'
	 * 
	 * @return Integer
	 */
	public Integer getIdStatoTransMdp2018()
	{
		return idStatoTransMdp2018;
	}

	/**
	 * Method 'setIdStatoTransMdp2018'
	 * 
	 * @param idStatoTransMdp2018
	 */
	public void setIdStatoTransMdp2018(Integer idStatoTransMdp2018)
	{
		this.idStatoTransMdp2018 = idStatoTransMdp2018;
	}

	/**
	 * Method 'getDescrStatoTransMdp'
	 * 
	 * @return String
	 */
	public String getDescrStatoTransMdp()
	{
		return descrStatoTransMdp;
	}

	/**
	 * Method 'setDescrStatoTransMdp'
	 * 
	 * @param descrStatoTransMdp
	 */
	public void setDescrStatoTransMdp(String descrStatoTransMdp)
	{
		this.descrStatoTransMdp = descrStatoTransMdp;
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
		
		if (!(_other instanceof SiceeDStatoTransMdp2018)) {
			return false;
		}
		
		final SiceeDStatoTransMdp2018 _cast = (SiceeDStatoTransMdp2018) _other;
		if (idStatoTransMdp2018 == null ? _cast.idStatoTransMdp2018 != idStatoTransMdp2018 : !idStatoTransMdp2018.equals( _cast.idStatoTransMdp2018 )) {
			return false;
		}
		
		if (descrStatoTransMdp == null ? _cast.descrStatoTransMdp != descrStatoTransMdp : !descrStatoTransMdp.equals( _cast.descrStatoTransMdp )) {
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
		if (idStatoTransMdp2018 != null) {
			_hashCode = 29 * _hashCode + idStatoTransMdp2018.hashCode();
		}
		
		if (descrStatoTransMdp != null) {
			_hashCode = 29 * _hashCode + descrStatoTransMdp.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDStatoTransMdp2018Pk
	 */
	public SiceeDStatoTransMdp2018Pk createPk()
	{
		return new SiceeDStatoTransMdp2018Pk(idStatoTransMdp2018);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTransMdp2018: " );
		ret.append( "idStatoTransMdp2018=" + idStatoTransMdp2018 );
		ret.append( ", descrStatoTransMdp=" + descrStatoTransMdp );
		return ret.toString();
	}

}
