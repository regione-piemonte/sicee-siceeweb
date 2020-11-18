/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_RACCOMANDAZIONI table.
 */
public class SiceeTRaccomandazioniPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7614069896085386641L;

	protected String idCertificatore;

	protected String progrCertificato;

	protected String anno;

	protected String priorita;

	protected String sistema;

	protected String intervento;

	/** 
	 * Sets the value of idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/** 
	 * Gets the value of idCertificatore
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/** 
	 * Sets the value of progrCertificato
	 */
	public void setProgrCertificato(String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/** 
	 * Gets the value of progrCertificato
	 */
	public String getProgrCertificato()
	{
		return this.progrCertificato;
	}

	/** 
	 * Sets the value of anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/** 
	 * Gets the value of anno
	 */
	public String getAnno()
	{
		return this.anno;
	}

	/** 
	 * Sets the value of priorita
	 */
	public void setPriorita(String priorita)
	{
		this.priorita = priorita;
	}

	/** 
	 * Gets the value of priorita
	 */
	public String getPriorita()
	{
		return this.priorita;
	}

	/** 
	 * Sets the value of sistema
	 */
	public void setSistema(String sistema)
	{
		this.sistema = sistema;
	}

	/** 
	 * Gets the value of sistema
	 */
	public String getSistema()
	{
		return this.sistema;
	}

	/** 
	 * Sets the value of intervento
	 */
	public void setIntervento(String intervento)
	{
		this.intervento = intervento;
	}

	/** 
	 * Gets the value of intervento
	 */
	public String getIntervento()
	{
		return this.intervento;
	}

	/**
	 * Method 'SiceeTRaccomandazioniPk'
	 * 
	 */
	public SiceeTRaccomandazioniPk()
	{
	}

	/**
	 * Method 'SiceeTRaccomandazioniPk'
	 * 
	 * @param idCertificatore
	 * @param progrCertificato
	 * @param anno
	 * @param priorita
	 * @param sistema
	 * @param intervento
	 */
	public SiceeTRaccomandazioniPk(final String idCertificatore, final String progrCertificato, final String anno, final String priorita, final String sistema, final String intervento)
	{
		this.idCertificatore = idCertificatore;
		this.progrCertificato = progrCertificato;
		this.anno = anno;
		this.priorita = priorita;
		this.sistema = sistema;
		this.intervento = intervento;
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
		
		if (!(_other instanceof SiceeTRaccomandazioniPk)) {
			return false;
		}
		
		final SiceeTRaccomandazioniPk _cast = (SiceeTRaccomandazioniPk) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.priorita == null ? _cast.priorita != this.priorita : !this.priorita.equals( _cast.priorita )) {
			return false;
		}
		
		if (this.sistema == null ? _cast.sistema != this.sistema : !this.sistema.equals( _cast.sistema )) {
			return false;
		}
		
		if (this.intervento == null ? _cast.intervento != this.intervento : !this.intervento.equals( _cast.intervento )) {
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
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.priorita != null) {
			_hashCode = 29 * _hashCode + this.priorita.hashCode();
		}
		
		if (this.sistema != null) {
			_hashCode = 29 * _hashCode + this.sistema.hashCode();
		}
		
		if (this.intervento != null) {
			_hashCode = 29 * _hashCode + this.intervento.hashCode();
		}
		
		return _hashCode;
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomandazioniPk: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", priorita=" + this.priorita );
		ret.append( ", sistema=" + this.sistema );
		ret.append( ", intervento=" + this.intervento );
		return ret.toString();
	}

}
