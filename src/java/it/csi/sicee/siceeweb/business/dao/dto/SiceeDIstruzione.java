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

public class SiceeDIstruzione implements Serializable
{
	/** 
	 * This attribute maps to the column ID_ISTRUZIONE in the SICEE_D_ISTRUZIONE table.
	 */
	protected Integer idIstruzione;

	/** 
	 * This attribute maps to the column FK_TIPO_ISTRUZIONE in the SICEE_D_ISTRUZIONE table.
	 */
	protected Integer fkTipoIstruzione;

	/** 
	 * This attribute maps to the column CODICE in the SICEE_D_ISTRUZIONE table.
	 */
	protected String codice;

	/** 
	 * This attribute maps to the column DENOMINAZIONE in the SICEE_D_ISTRUZIONE table.
	 */
	protected String denominazione;

	/** 
	 * This attribute maps to the column SIGLA_ORDINE in the SICEE_D_ISTRUZIONE table.
	 */
	protected String siglaOrdine;

	/** 
	 * This attribute maps to the column SIGLA_NON_ORDINE in the SICEE_D_ISTRUZIONE table.
	 */
	protected String siglaNonOrdine;

	/**
	 * Method 'SiceeDIstruzione'
	 * 
	 */
	public SiceeDIstruzione()
	{
	}

	/**
	 * Method 'getIdIstruzione'
	 * 
	 * @return Integer
	 */
	public Integer getIdIstruzione()
	{
		return idIstruzione;
	}

	/**
	 * Method 'setIdIstruzione'
	 * 
	 * @param idIstruzione
	 */
	public void setIdIstruzione(Integer idIstruzione)
	{
		this.idIstruzione = idIstruzione;
	}

	/**
	 * Method 'getFkTipoIstruzione'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoIstruzione()
	{
		return fkTipoIstruzione;
	}

	/**
	 * Method 'setFkTipoIstruzione'
	 * 
	 * @param fkTipoIstruzione
	 */
	public void setFkTipoIstruzione(Integer fkTipoIstruzione)
	{
		this.fkTipoIstruzione = fkTipoIstruzione;
	}

	/**
	 * Method 'getCodice'
	 * 
	 * @return String
	 */
	public String getCodice()
	{
		return codice;
	}

	/**
	 * Method 'setCodice'
	 * 
	 * @param codice
	 */
	public void setCodice(String codice)
	{
		this.codice = codice;
	}

	/**
	 * Method 'getDenominazione'
	 * 
	 * @return String
	 */
	public String getDenominazione()
	{
		return denominazione;
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
	 * Method 'getSiglaOrdine'
	 * 
	 * @return String
	 */
	public String getSiglaOrdine()
	{
		return siglaOrdine;
	}

	/**
	 * Method 'setSiglaOrdine'
	 * 
	 * @param siglaOrdine
	 */
	public void setSiglaOrdine(String siglaOrdine)
	{
		this.siglaOrdine = siglaOrdine;
	}

	/**
	 * Method 'getSiglaNonOrdine'
	 * 
	 * @return String
	 */
	public String getSiglaNonOrdine()
	{
		return siglaNonOrdine;
	}

	/**
	 * Method 'setSiglaNonOrdine'
	 * 
	 * @param siglaNonOrdine
	 */
	public void setSiglaNonOrdine(String siglaNonOrdine)
	{
		this.siglaNonOrdine = siglaNonOrdine;
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
		
		if (!(_other instanceof SiceeDIstruzione)) {
			return false;
		}
		
		final SiceeDIstruzione _cast = (SiceeDIstruzione) _other;
		if (idIstruzione == null ? _cast.idIstruzione != idIstruzione : !idIstruzione.equals( _cast.idIstruzione )) {
			return false;
		}
		
		if (fkTipoIstruzione == null ? _cast.fkTipoIstruzione != fkTipoIstruzione : !fkTipoIstruzione.equals( _cast.fkTipoIstruzione )) {
			return false;
		}
		
		if (codice == null ? _cast.codice != codice : !codice.equals( _cast.codice )) {
			return false;
		}
		
		if (denominazione == null ? _cast.denominazione != denominazione : !denominazione.equals( _cast.denominazione )) {
			return false;
		}
		
		if (siglaOrdine == null ? _cast.siglaOrdine != siglaOrdine : !siglaOrdine.equals( _cast.siglaOrdine )) {
			return false;
		}
		
		if (siglaNonOrdine == null ? _cast.siglaNonOrdine != siglaNonOrdine : !siglaNonOrdine.equals( _cast.siglaNonOrdine )) {
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
		if (idIstruzione != null) {
			_hashCode = 29 * _hashCode + idIstruzione.hashCode();
		}
		
		if (fkTipoIstruzione != null) {
			_hashCode = 29 * _hashCode + fkTipoIstruzione.hashCode();
		}
		
		if (codice != null) {
			_hashCode = 29 * _hashCode + codice.hashCode();
		}
		
		if (denominazione != null) {
			_hashCode = 29 * _hashCode + denominazione.hashCode();
		}
		
		if (siglaOrdine != null) {
			_hashCode = 29 * _hashCode + siglaOrdine.hashCode();
		}
		
		if (siglaNonOrdine != null) {
			_hashCode = 29 * _hashCode + siglaNonOrdine.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDIstruzionePk
	 */
	public SiceeDIstruzionePk createPk()
	{
		return new SiceeDIstruzionePk(idIstruzione);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDIstruzione: " );
		ret.append( "idIstruzione=" + idIstruzione );
		ret.append( ", fkTipoIstruzione=" + fkTipoIstruzione );
		ret.append( ", codice=" + codice );
		ret.append( ", denominazione=" + denominazione );
		ret.append( ", siglaOrdine=" + siglaOrdine );
		ret.append( ", siglaNonOrdine=" + siglaNonOrdine );
		return ret.toString();
	}

}
