/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDTitolo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7059630009917103762L;

	/** 
	 * This attribute maps to the column ID_TITOLO in the SICEE_D_TITOLO table.
	 */
	protected String idTitolo;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TITOLO table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_EDIFICI in the SICEE_D_TITOLO table.
	 */
	protected String flgEdifici;

	/** 
	 * This attribute maps to the column FLG_IMPIANTI in the SICEE_D_TITOLO table.
	 */
	protected String flgImpianti;

	/** 
	 * This attribute maps to the column SIGLA in the SICEE_D_TITOLO table.
	 */
	protected String sigla;

	/** 
	 * This attribute maps to the column FLG_MDP in the SICEE_D_TITOLO table.
	 */
	protected String flgMdp;

	/**
	 * Method 'SiceeDTitolo'
	 * 
	 */
	public SiceeDTitolo()
	{
	}

	/**
	 * Method 'getIdTitolo'
	 * 
	 * @return String
	 */
	public String getIdTitolo()
	{
		return this.idTitolo;
	}

	/**
	 * Method 'setIdTitolo'
	 * 
	 * @param idTitolo
	 */
	public void setIdTitolo(String idTitolo)
	{
		this.idTitolo = idTitolo;
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
	 * Method 'getFlgEdifici'
	 * 
	 * @return String
	 */
	public String getFlgEdifici()
	{
		return this.flgEdifici;
	}

	/**
	 * Method 'setFlgEdifici'
	 * 
	 * @param flgEdifici
	 */
	public void setFlgEdifici(String flgEdifici)
	{
		this.flgEdifici = flgEdifici;
	}

	/**
	 * Method 'getFlgImpianti'
	 * 
	 * @return String
	 */
	public String getFlgImpianti()
	{
		return this.flgImpianti;
	}

	/**
	 * Method 'setFlgImpianti'
	 * 
	 * @param flgImpianti
	 */
	public void setFlgImpianti(String flgImpianti)
	{
		this.flgImpianti = flgImpianti;
	}

	/**
	 * Method 'getSigla'
	 * 
	 * @return String
	 */
	public String getSigla()
	{
		return this.sigla;
	}

	/**
	 * Method 'setSigla'
	 * 
	 * @param sigla
	 */
	public void setSigla(String sigla)
	{
		this.sigla = sigla;
	}

	/**
	 * Method 'getFlgMdp'
	 * 
	 * @return String
	 */
	public String getFlgMdp()
	{
		return this.flgMdp;
	}

	/**
	 * Method 'setFlgMdp'
	 * 
	 * @param flgMdp
	 */
	public void setFlgMdp(String flgMdp)
	{
		this.flgMdp = flgMdp;
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
		
		if (!(_other instanceof SiceeDTitolo)) {
			return false;
		}
		
		final SiceeDTitolo _cast = (SiceeDTitolo) _other;
		if (this.idTitolo == null ? _cast.idTitolo != this.idTitolo : !this.idTitolo.equals( _cast.idTitolo )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.flgEdifici == null ? _cast.flgEdifici != this.flgEdifici : !this.flgEdifici.equals( _cast.flgEdifici )) {
			return false;
		}
		
		if (this.flgImpianti == null ? _cast.flgImpianti != this.flgImpianti : !this.flgImpianti.equals( _cast.flgImpianti )) {
			return false;
		}
		
		if (this.sigla == null ? _cast.sigla != this.sigla : !this.sigla.equals( _cast.sigla )) {
			return false;
		}
		
		if (this.flgMdp == null ? _cast.flgMdp != this.flgMdp : !this.flgMdp.equals( _cast.flgMdp )) {
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
		if (this.idTitolo != null) {
			_hashCode = 29 * _hashCode + this.idTitolo.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.flgEdifici != null) {
			_hashCode = 29 * _hashCode + this.flgEdifici.hashCode();
		}
		
		if (this.flgImpianti != null) {
			_hashCode = 29 * _hashCode + this.flgImpianti.hashCode();
		}
		
		if (this.sigla != null) {
			_hashCode = 29 * _hashCode + this.sigla.hashCode();
		}
		
		if (this.flgMdp != null) {
			_hashCode = 29 * _hashCode + this.flgMdp.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTitoloPk
	 */
	public SiceeDTitoloPk createPk()
	{
		return new SiceeDTitoloPk(this.idTitolo);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTitolo: " );
		ret.append( "idTitolo=" + this.idTitolo );
		ret.append( ", descr=" + this.descr );
		ret.append( ", flgEdifici=" + this.flgEdifici );
		ret.append( ", flgImpianti=" + this.flgImpianti );
		ret.append( ", sigla=" + this.sigla );
		ret.append( ", flgMdp=" + this.flgMdp );
		return ret.toString();
	}

}
