/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTRaccomandazioni implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3975999716198180590L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_RACCOMANDAZIONI table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_RACCOMANDAZIONI table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_RACCOMANDAZIONI table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column PRIORITA in the SICEE_T_RACCOMANDAZIONI table.
	 */
	protected String priorita;

	/** 
	 * This attribute maps to the column SISTEMA in the SICEE_T_RACCOMANDAZIONI table.
	 */
	protected String sistema;

	/** 
	 * This attribute maps to the column INTERVENTO in the SICEE_T_RACCOMANDAZIONI table.
	 */
	protected String intervento;

	/** 
	 * This attribute maps to the column TEMPO_RITORNO in the SICEE_T_RACCOMANDAZIONI table.
	 */
	protected String tempoRitorno;

	/**
	 * Method 'SiceeTRaccomandazioni'
	 * 
	 */
	public SiceeTRaccomandazioni()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/**
	 * Method 'setIdCertificatore'
	 * 
	 * @param idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/**
	 * Method 'getProgrCertificato'
	 * 
	 * @return String
	 */
	public String getProgrCertificato()
	{
		return this.progrCertificato;
	}

	/**
	 * Method 'setProgrCertificato'
	 * 
	 * @param progrCertificato
	 */
	public void setProgrCertificato(String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/**
	 * Method 'getAnno'
	 * 
	 * @return String
	 */
	public String getAnno()
	{
		return this.anno;
	}

	/**
	 * Method 'setAnno'
	 * 
	 * @param anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/**
	 * Method 'getPriorita'
	 * 
	 * @return String
	 */
	public String getPriorita()
	{
		return this.priorita;
	}

	/**
	 * Method 'setPriorita'
	 * 
	 * @param priorita
	 */
	public void setPriorita(String priorita)
	{
		this.priorita = priorita;
	}

	/**
	 * Method 'getSistema'
	 * 
	 * @return String
	 */
	public String getSistema()
	{
		return this.sistema;
	}

	/**
	 * Method 'setSistema'
	 * 
	 * @param sistema
	 */
	public void setSistema(String sistema)
	{
		this.sistema = sistema;
	}

	/**
	 * Method 'getIntervento'
	 * 
	 * @return String
	 */
	public String getIntervento()
	{
		return this.intervento;
	}

	/**
	 * Method 'setIntervento'
	 * 
	 * @param intervento
	 */
	public void setIntervento(String intervento)
	{
		this.intervento = intervento;
	}

	/**
	 * Method 'getTempoRitorno'
	 * 
	 * @return String
	 */
	public String getTempoRitorno()
	{
		return this.tempoRitorno;
	}

	/**
	 * Method 'setTempoRitorno'
	 * 
	 * @param tempoRitorno
	 */
	public void setTempoRitorno(String tempoRitorno)
	{
		this.tempoRitorno = tempoRitorno;
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
		
		if (!(_other instanceof SiceeTRaccomandazioni)) {
			return false;
		}
		
		final SiceeTRaccomandazioni _cast = (SiceeTRaccomandazioni) _other;
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
		
		if (this.tempoRitorno == null ? _cast.tempoRitorno != this.tempoRitorno : !this.tempoRitorno.equals( _cast.tempoRitorno )) {
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
		
		if (this.tempoRitorno != null) {
			_hashCode = 29 * _hashCode + this.tempoRitorno.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTRaccomandazioniPk
	 */
	public SiceeTRaccomandazioniPk createPk()
	{
		return new SiceeTRaccomandazioniPk(this.idCertificatore, this.progrCertificato, this.anno, this.priorita, this.sistema, this.intervento);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomandazioni: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", priorita=" + this.priorita );
		ret.append( ", sistema=" + this.sistema );
		ret.append( ", intervento=" + this.intervento );
		ret.append( ", tempoRitorno=" + this.tempoRitorno );
		return ret.toString();
	}

}
