/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeWPrezzi implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3500544026628451254L;

	/** 
	 * This attribute maps to the column DESCRIZIONE in the SICEE_W_PREZZI table.
	 */
	protected String descrizione;

	/** 
	 * This attribute maps to the column VALUTA in the SICEE_W_PREZZI table.
	 */
	protected Double valuta;

	/** 
	 * This attribute maps to the column ID_PREZZI in the SICEE_W_PREZZI table.
	 */
	protected Integer idPrezzi;

	/** 
	 * This attribute maps to the column DT_INIZIO in the SICEE_W_PREZZI table.
	 */
	protected Date dtInizio;

	/** 
	 * This attribute maps to the column DT_FINE in the SICEE_W_PREZZI table.
	 */
	protected Date dtFine;

	
	/**
	 * Method 'SiceeWPrezzi'
	 * 
	 */
	public SiceeWPrezzi()
	{
	}

	/**
	 * Method 'getDescrizione'
	 * 
	 * @return String
	 */
	public String getDescrizione()
	{
		return this.descrizione;
	}

	/**
	 * Method 'setDescrizione'
	 * 
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}

	/**
	 * Method 'getValuta'
	 * 
	 * @return Double
	 */
	public Double getValuta()
	{
		return this.valuta;
	}

	/**
	 * Method 'setValuta'
	 * 
	 * @param valuta
	 */
	public void setValuta(Double valuta)
	{
		this.valuta = valuta;
	}

	/**
	 * Method 'getIdPrezzi'
	 * 
	 * @return Integer
	 */
	public Integer getIdPrezzi()
	{
		return idPrezzi;
	}

	/**
	 * Method 'setIdPrezzi'
	 * 
	 * @param idPrezzi
	 */
	public void setIdPrezzi(Integer idPrezzi)
	{
		this.idPrezzi = idPrezzi;
	}

	/**
	 * Method 'getDtInizio'
	 * 
	 * @return Date
	 */
	public Date getDtInizio()
	{
		return dtInizio;
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
		return dtFine;
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
		
		if (!(_other instanceof SiceeWPrezzi)) {
			return false;
		}
		
		final SiceeWPrezzi _cast = (SiceeWPrezzi) _other;
		if (descrizione == null ? _cast.descrizione != descrizione : !descrizione.equals( _cast.descrizione )) {
			return false;
		}
		
		if (valuta == null ? _cast.valuta != valuta : !valuta.equals( _cast.valuta )) {
			return false;
		}
		
		if (idPrezzi == null ? _cast.idPrezzi != idPrezzi : !idPrezzi.equals( _cast.idPrezzi )) {
			return false;
		}
		
		if (dtInizio == null ? _cast.dtInizio != dtInizio : !dtInizio.equals( _cast.dtInizio )) {
			return false;
		}
		
		if (dtFine == null ? _cast.dtFine != dtFine : !dtFine.equals( _cast.dtFine )) {
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
		if (descrizione != null) {
			_hashCode = 29 * _hashCode + descrizione.hashCode();
		}
		
		if (valuta != null) {
			_hashCode = 29 * _hashCode + valuta.hashCode();
		}
		
		if (idPrezzi != null) {
			_hashCode = 29 * _hashCode + idPrezzi.hashCode();
		}
		
		if (dtInizio != null) {
			_hashCode = 29 * _hashCode + dtInizio.hashCode();
		}
		
		if (dtFine != null) {
			_hashCode = 29 * _hashCode + dtFine.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeWPrezziPk
	 */
	public SiceeWPrezziPk createPk()
	{
		return new SiceeWPrezziPk(idPrezzi);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezzi: " );
		ret.append( "descrizione=" + descrizione );
		ret.append( ", valuta=" + valuta );
		ret.append( ", idPrezzi=" + idPrezzi );
		ret.append( ", dtInizio=" + dtInizio );
		ret.append( ", dtFine=" + dtFine );
		return ret.toString();
	}

}
