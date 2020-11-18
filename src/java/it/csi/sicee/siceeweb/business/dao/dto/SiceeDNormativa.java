/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeDNormativa implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -646073755094652601L;

	/** 
	 * This attribute maps to the column ID_NORMA in the SICEE_D_NORMATIVA table.
	 */
	protected Integer idNorma;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_NORMATIVA table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column DT_INIZIO in the SICEE_D_NORMATIVA table.
	 */
	protected Date dtInizio;

	/** 
	 * This attribute maps to the column DT_FINE in the SICEE_D_NORMATIVA table.
	 */
	protected Date dtFine;

	/**
	 * Method 'SiceeDNormativa'
	 * 
	 */
	public SiceeDNormativa()
	{
	}

	/**
	 * Method 'getIdNorma'
	 * 
	 * @return Integer
	 */
	public Integer getIdNorma()
	{
		return this.idNorma;
	}

	/**
	 * Method 'setIdNorma'
	 * 
	 * @param idNorma
	 */
	public void setIdNorma(Integer idNorma)
	{
		this.idNorma = idNorma;
	}

	/**
	 * Method 'getDescr'
	 * 
	 * @return String
	 */
	public String getDescr()
	{
		return this.descr;
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
	 * Method 'getDtInizio'
	 * 
	 * @return Date
	 */
	public Date getDtInizio()
	{
		return this.dtInizio;
	}

	/**
	 * Method 'setDtInizio'
	 * 
	 * @param dtInizio
	 */
	public void setDtInizio(Date dtInizio)
	{
		this.dtInizio = dtInizio;
	}

	/**
	 * Method 'getDtFine'
	 * 
	 * @return Date
	 */
	public Date getDtFine()
	{
		return this.dtFine;
	}

	/**
	 * Method 'setDtFine'
	 * 
	 * @param dtFine
	 */
	public void setDtFine(Date dtFine)
	{
		this.dtFine = dtFine;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeDNormativa)) {
			return false;
		}
		
		final SiceeDNormativa _cast = (SiceeDNormativa) _other;
		if (this.idNorma == null ? _cast.idNorma != this.idNorma : !this.idNorma.equals( _cast.idNorma )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.dtInizio == null ? _cast.dtInizio != this.dtInizio : !this.dtInizio.equals( _cast.dtInizio )) {
			return false;
		}
		
		if (this.dtFine == null ? _cast.dtFine != this.dtFine : !this.dtFine.equals( _cast.dtFine )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		if (this.idNorma != null) {
			_hashCode = 29 * _hashCode + this.idNorma.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.dtInizio != null) {
			_hashCode = 29 * _hashCode + this.dtInizio.hashCode();
		}
		
		if (this.dtFine != null) {
			_hashCode = 29 * _hashCode + this.dtFine.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDNormativaPk
	 */
	public SiceeDNormativaPk createPk()
	{
		return new SiceeDNormativaPk(this.idNorma);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDNormativa: " );
		ret.append( "idNorma=" + this.idNorma );
		ret.append( ", descr=" + this.descr );
		ret.append( ", dtInizio=" + this.dtInizio );
		ret.append( ", dtFine=" + this.dtFine );
		return ret.toString();
	}

}
