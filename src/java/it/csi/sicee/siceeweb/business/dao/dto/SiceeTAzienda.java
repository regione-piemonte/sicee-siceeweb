/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTAzienda implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7030980069532978892L;

	/** 
	 * This attribute maps to the column ID_AZIENDA in the SICEE_T_AZIENDA table.
	 */
	protected long idAzienda;

	/** 
	 * This attribute maps to the column DENOMINAZIONE in the SICEE_T_AZIENDA table.
	 */
	protected String denominazione;

	/** 
	 * This attribute maps to the column ID_INDIRIZZO in the SICEE_T_AZIENDA table.
	 */
	protected Integer idIndirizzo;

	/** 
	 * This attribute maps to the column DESC_INDIRIZZO in the SICEE_T_AZIENDA table.
	 */
	protected String descIndirizzo;

	/** 
	 * This attribute maps to the column CAP in the SICEE_T_AZIENDA table.
	 */
	protected String cap;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_T_AZIENDA table.
	 */
	protected String idComune;

	/** 
	 * This attribute maps to the column DESC_COMUNE in the SICEE_T_AZIENDA table.
	 */
	protected String descComune;

	/** 
	 * This attribute maps to the column P_IVA in the SICEE_T_AZIENDA table.
	 */
	protected String pIva;

	/** 
	 * This attribute maps to the column ID_PROV in the SICEE_T_AZIENDA table.
	 */
	protected String idProv;

	/** 
	 * This attribute maps to the column DESC_PROV in the SICEE_T_AZIENDA table.
	 */
	protected String descProv;

	/** 
	 * This attribute maps to the column ID_REGIONE in the SICEE_T_AZIENDA table.
	 */
	protected String idRegione;

	/** 
	 * This attribute maps to the column DESC_REGIONE in the SICEE_T_AZIENDA table.
	 */
	protected String descRegione;

	/** 
	 * This attribute maps to the column NUM_CIVICO in the SICEE_T_AZIENDA table.
	 */
	protected String numCivico;

	/**
	 * Method 'SiceeTAzienda'
	 * 
	 */
	public SiceeTAzienda()
	{
	}

	/**
	 * Method 'getIdAzienda'
	 * 
	 * @return long
	 */
	public long getIdAzienda()
	{
		return this.idAzienda;
	}

	/**
	 * Method 'setIdAzienda'
	 * 
	 * @param idAzienda
	 */
	public void setIdAzienda(long idAzienda)
	{
		this.idAzienda = idAzienda;
	}

	/**
	 * Method 'getDenominazione'
	 * 
	 * @return String
	 */
	public String getDenominazione()
	{
		return this.denominazione;
	}

	/**
	 * Method 'setDenominazione'
	 * 
	 * @param denominazione
	 */
	public void setDenominazione(String denominazione)
	{
		this.denominazione = denominazione;
	}

	/**
	 * Method 'getIdIndirizzo'
	 * 
	 * @return Integer
	 */
	public Integer getIdIndirizzo()
	{
		return this.idIndirizzo;
	}

	/**
	 * Method 'setIdIndirizzo'
	 * 
	 * @param idIndirizzo
	 */
	public void setIdIndirizzo(Integer idIndirizzo)
	{
		this.idIndirizzo = idIndirizzo;
	}

	/**
	 * Method 'getDescIndirizzo'
	 * 
	 * @return String
	 */
	public String getDescIndirizzo()
	{
		return this.descIndirizzo;
	}

	/**
	 * Method 'setDescIndirizzo'
	 * 
	 * @param descIndirizzo
	 */
	public void setDescIndirizzo(String descIndirizzo)
	{
		this.descIndirizzo = descIndirizzo;
	}

	/**
	 * Method 'getCap'
	 * 
	 * @return String
	 */
	public String getCap()
	{
		return this.cap;
	}

	/**
	 * Method 'setCap'
	 * 
	 * @param cap
	 */
	public void setCap(String cap)
	{
		this.cap = cap;
	}

	/**
	 * Method 'getIdComune'
	 * 
	 * @return String
	 */
	public String getIdComune()
	{
		return this.idComune;
	}

	/**
	 * Method 'setIdComune'
	 * 
	 * @param idComune
	 */
	public void setIdComune(String idComune)
	{
		this.idComune = idComune;
	}

	/**
	 * Method 'getDescComune'
	 * 
	 * @return String
	 */
	public String getDescComune()
	{
		return this.descComune;
	}

	/**
	 * Method 'setDescComune'
	 * 
	 * @param descComune
	 */
	public void setDescComune(String descComune)
	{
		this.descComune = descComune;
	}

	/**
	 * Method 'getPIva'
	 * 
	 * @return String
	 */
	public String getPIva()
	{
		return this.pIva;
	}

	/**
	 * Method 'setPIva'
	 * 
	 * @param pIva
	 */
	public void setPIva(String pIva)
	{
		this.pIva = pIva;
	}

	/**
	 * Method 'getIdProv'
	 * 
	 * @return String
	 */
	public String getIdProv()
	{
		return this.idProv;
	}

	/**
	 * Method 'setIdProv'
	 * 
	 * @param idProv
	 */
	public void setIdProv(String idProv)
	{
		this.idProv = idProv;
	}

	/**
	 * Method 'getDescProv'
	 * 
	 * @return String
	 */
	public String getDescProv()
	{
		return this.descProv;
	}

	/**
	 * Method 'setDescProv'
	 * 
	 * @param descProv
	 */
	public void setDescProv(String descProv)
	{
		this.descProv = descProv;
	}

	/**
	 * Method 'getIdRegione'
	 * 
	 * @return String
	 */
	public String getIdRegione()
	{
		return this.idRegione;
	}

	/**
	 * Method 'setIdRegione'
	 * 
	 * @param idRegione
	 */
	public void setIdRegione(String idRegione)
	{
		this.idRegione = idRegione;
	}

	/**
	 * Method 'getDescRegione'
	 * 
	 * @return String
	 */
	public String getDescRegione()
	{
		return this.descRegione;
	}

	/**
	 * Method 'setDescRegione'
	 * 
	 * @param descRegione
	 */
	public void setDescRegione(String descRegione)
	{
		this.descRegione = descRegione;
	}

	/**
	 * Method 'getNumCivico'
	 * 
	 * @return String
	 */
	public String getNumCivico()
	{
		return this.numCivico;
	}

	/**
	 * Method 'setNumCivico'
	 * 
	 * @param numCivico
	 */
	public void setNumCivico(String numCivico)
	{
		this.numCivico = numCivico;
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
		
		if (!(_other instanceof SiceeTAzienda)) {
			return false;
		}
		
		final SiceeTAzienda _cast = (SiceeTAzienda) _other;
		if (this.idAzienda != _cast.idAzienda) {
			return false;
		}
		
		if (this.denominazione == null ? _cast.denominazione != this.denominazione : !this.denominazione.equals( _cast.denominazione )) {
			return false;
		}
		
		if (this.idIndirizzo == null ? _cast.idIndirizzo != this.idIndirizzo : !this.idIndirizzo.equals( _cast.idIndirizzo )) {
			return false;
		}
		
		if (this.descIndirizzo == null ? _cast.descIndirizzo != this.descIndirizzo : !this.descIndirizzo.equals( _cast.descIndirizzo )) {
			return false;
		}
		
		if (this.cap == null ? _cast.cap != this.cap : !this.cap.equals( _cast.cap )) {
			return false;
		}
		
		if (this.idComune == null ? _cast.idComune != this.idComune : !this.idComune.equals( _cast.idComune )) {
			return false;
		}
		
		if (this.descComune == null ? _cast.descComune != this.descComune : !this.descComune.equals( _cast.descComune )) {
			return false;
		}
		
		if (this.pIva == null ? _cast.pIva != this.pIva : !this.pIva.equals( _cast.pIva )) {
			return false;
		}
		
		if (this.idProv == null ? _cast.idProv != this.idProv : !this.idProv.equals( _cast.idProv )) {
			return false;
		}
		
		if (this.descProv == null ? _cast.descProv != this.descProv : !this.descProv.equals( _cast.descProv )) {
			return false;
		}
		
		if (this.idRegione == null ? _cast.idRegione != this.idRegione : !this.idRegione.equals( _cast.idRegione )) {
			return false;
		}
		
		if (this.descRegione == null ? _cast.descRegione != this.descRegione : !this.descRegione.equals( _cast.descRegione )) {
			return false;
		}
		
		if (this.numCivico == null ? _cast.numCivico != this.numCivico : !this.numCivico.equals( _cast.numCivico )) {
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
		_hashCode = 29 * _hashCode + (int) (this.idAzienda ^ (this.idAzienda >>> 32));
		if (this.denominazione != null) {
			_hashCode = 29 * _hashCode + this.denominazione.hashCode();
		}
		
		if (this.idIndirizzo != null) {
			_hashCode = 29 * _hashCode + this.idIndirizzo.hashCode();
		}
		
		if (this.descIndirizzo != null) {
			_hashCode = 29 * _hashCode + this.descIndirizzo.hashCode();
		}
		
		if (this.cap != null) {
			_hashCode = 29 * _hashCode + this.cap.hashCode();
		}
		
		if (this.idComune != null) {
			_hashCode = 29 * _hashCode + this.idComune.hashCode();
		}
		
		if (this.descComune != null) {
			_hashCode = 29 * _hashCode + this.descComune.hashCode();
		}
		
		if (this.pIva != null) {
			_hashCode = 29 * _hashCode + this.pIva.hashCode();
		}
		
		if (this.idProv != null) {
			_hashCode = 29 * _hashCode + this.idProv.hashCode();
		}
		
		if (this.descProv != null) {
			_hashCode = 29 * _hashCode + this.descProv.hashCode();
		}
		
		if (this.idRegione != null) {
			_hashCode = 29 * _hashCode + this.idRegione.hashCode();
		}
		
		if (this.descRegione != null) {
			_hashCode = 29 * _hashCode + this.descRegione.hashCode();
		}
		
		if (this.numCivico != null) {
			_hashCode = 29 * _hashCode + this.numCivico.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTAziendaPk
	 */
	public SiceeTAziendaPk createPk()
	{
		return new SiceeTAziendaPk(this.idAzienda);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda: " );
		ret.append( "idAzienda=" + this.idAzienda );
		ret.append( ", denominazione=" + this.denominazione );
		ret.append( ", idIndirizzo=" + this.idIndirizzo );
		ret.append( ", descIndirizzo=" + this.descIndirizzo );
		ret.append( ", cap=" + this.cap );
		ret.append( ", idComune=" + this.idComune );
		ret.append( ", descComune=" + this.descComune );
		ret.append( ", pIva=" + this.pIva );
		ret.append( ", idProv=" + this.idProv );
		ret.append( ", descProv=" + this.descProv );
		ret.append( ", idRegione=" + this.idRegione );
		ret.append( ", descRegione=" + this.descRegione );
		ret.append( ", numCivico=" + this.numCivico );
		return ret.toString();
	}

}
