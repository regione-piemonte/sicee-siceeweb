/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDClasseEnergetica implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8495946036121876098L;

	/** 
	 * This attribute maps to the column ID_CLASSE in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	protected Integer idClasse;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_NAZIONALE_19205 in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	protected String flgNazionale19205;

	/**
	 * Method 'SiceeDClasseEnergetica'
	 * 
	 */
	public SiceeDClasseEnergetica()
	{
	}

	/**
	 * Method 'getIdClasse'
	 * 
	 * @return Integer
	 */
	public Integer getIdClasse()
	{
		return this.idClasse;
	}

	/**
	 * Method 'setIdClasse'
	 * 
	 * @param idClasse
	 */
	public void setIdClasse(Integer idClasse)
	{
		this.idClasse = idClasse;
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
	 * Method 'getFlgNazionale19205'
	 * 
	 * @return String
	 */
	public String getFlgNazionale19205()
	{
		return this.flgNazionale19205;
	}

	/**
	 * Method 'setFlgNazionale19205'
	 * 
	 * @param flgNazionale19205
	 */
	public void setFlgNazionale19205(String flgNazionale19205)
	{
		this.flgNazionale19205 = flgNazionale19205;
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
		
		if (!(_other instanceof SiceeDClasseEnergetica)) {
			return false;
		}
		
		final SiceeDClasseEnergetica _cast = (SiceeDClasseEnergetica) _other;
		if (this.idClasse == null ? _cast.idClasse != this.idClasse : !this.idClasse.equals( _cast.idClasse )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.flgNazionale19205 == null ? _cast.flgNazionale19205 != this.flgNazionale19205 : !this.flgNazionale19205.equals( _cast.flgNazionale19205 )) {
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
		if (this.idClasse != null) {
			_hashCode = 29 * _hashCode + this.idClasse.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.flgNazionale19205 != null) {
			_hashCode = 29 * _hashCode + this.flgNazionale19205.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDClasseEnergeticaPk
	 */
	public SiceeDClasseEnergeticaPk createPk()
	{
		return new SiceeDClasseEnergeticaPk(this.idClasse);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica: " );
		ret.append( "idClasse=" + this.idClasse );
		ret.append( ", descr=" + this.descr );
		ret.append( ", flgNazionale19205=" + this.flgNazionale19205 );
		return ret.toString();
	}

}
