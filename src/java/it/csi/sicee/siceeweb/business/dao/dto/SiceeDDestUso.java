/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDDestUso implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5128467474299029247L;

	/** 
	 * This attribute maps to the column ID_DEST_USO in the SICEE_D_DEST_USO table.
	 */
	protected Integer idDestUso;

	/** 
	 * This attribute maps to the column SIGLA in the SICEE_D_DEST_USO table.
	 */
	protected String sigla;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_DEST_USO table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_EDIFICIO in the SICEE_D_DEST_USO table.
	 */
	protected String flgEdificio;

	/** 
	 * This attribute maps to the column FLG_VISIBILE_COMBO in the SICEE_D_DEST_USO table.
	 */
	protected String flgVisibileCombo;

	/**
	 * Method 'SiceeDDestUso'
	 * 
	 */
	public SiceeDDestUso()
	{
	}

	/**
	 * Method 'getIdDestUso'
	 * 
	 * @return Integer
	 */
	public Integer getIdDestUso()
	{
		return this.idDestUso;
	}

	/**
	 * Method 'setIdDestUso'
	 * 
	 * @param idDestUso
	 */
	public void setIdDestUso(Integer idDestUso)
	{
		this.idDestUso = idDestUso;
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
	 * Method 'getFlgEdificio'
	 * 
	 * @return String
	 */
	public String getFlgEdificio()
	{
		return this.flgEdificio;
	}

	/**
	 * Method 'setFlgEdificio'
	 * 
	 * @param flgEdificio
	 */
	public void setFlgEdificio(String flgEdificio)
	{
		this.flgEdificio = flgEdificio;
	}

	/**
	 * Method 'getFlgVisibileCombo'
	 * 
	 * @return String
	 */
	public String getFlgVisibileCombo()
	{
		return this.flgVisibileCombo;
	}

	/**
	 * Method 'setFlgVisibileCombo'
	 * 
	 * @param flgVisibileCombo
	 */
	public void setFlgVisibileCombo(String flgVisibileCombo)
	{
		this.flgVisibileCombo = flgVisibileCombo;
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
		
		if (!(_other instanceof SiceeDDestUso)) {
			return false;
		}
		
		final SiceeDDestUso _cast = (SiceeDDestUso) _other;
		if (this.idDestUso == null ? _cast.idDestUso != this.idDestUso : !this.idDestUso.equals( _cast.idDestUso )) {
			return false;
		}
		
		if (this.sigla == null ? _cast.sigla != this.sigla : !this.sigla.equals( _cast.sigla )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
			return false;
		}
		
		if (this.flgEdificio == null ? _cast.flgEdificio != this.flgEdificio : !this.flgEdificio.equals( _cast.flgEdificio )) {
			return false;
		}
		
		if (this.flgVisibileCombo == null ? _cast.flgVisibileCombo != this.flgVisibileCombo : !this.flgVisibileCombo.equals( _cast.flgVisibileCombo )) {
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
		if (this.idDestUso != null) {
			_hashCode = 29 * _hashCode + this.idDestUso.hashCode();
		}
		
		if (this.sigla != null) {
			_hashCode = 29 * _hashCode + this.sigla.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		if (this.flgEdificio != null) {
			_hashCode = 29 * _hashCode + this.flgEdificio.hashCode();
		}
		
		if (this.flgVisibileCombo != null) {
			_hashCode = 29 * _hashCode + this.flgVisibileCombo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDDestUsoPk
	 */
	public SiceeDDestUsoPk createPk()
	{
		return new SiceeDDestUsoPk(this.idDestUso);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso: " );
		ret.append( "idDestUso=" + this.idDestUso );
		ret.append( ", sigla=" + this.sigla );
		ret.append( ", descr=" + this.descr );
		ret.append( ", flgEdificio=" + this.flgEdificio );
		ret.append( ", flgVisibileCombo=" + this.flgVisibileCombo );
		return ret.toString();
	}

}
