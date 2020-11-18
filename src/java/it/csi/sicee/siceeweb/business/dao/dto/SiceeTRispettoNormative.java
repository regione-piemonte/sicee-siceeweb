/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeTRispettoNormative implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8661056035967010596L;

	/** 
	 * This attribute maps to the column DT_TITOLO in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected Date dtTitolo;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_NORMA in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected Integer fkNorma;

	/** 
	 * This attribute maps to the column FLG_NORMA in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected String flgNorma;

	/** 
	 * This attribute maps to the column MOTIVO_NON_CONFORMITA in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected String motivoNonConformita;

	/** 
	 * This attribute maps to the column NOTE in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	protected String note;

	/**
	 * Method 'SiceeTRispettoNormative'
	 * 
	 */
	public SiceeTRispettoNormative()
	{
	}

	/**
	 * Method 'getDtTitolo'
	 * 
	 * @return Date
	 */
	public Date getDtTitolo()
	{
		return this.dtTitolo;
	}

	/**
	 * Method 'setDtTitolo'
	 * 
	 * @param dtTitolo
	 */
	public void setDtTitolo(Date dtTitolo)
	{
		this.dtTitolo = dtTitolo;
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
	 * Method 'getFkNorma'
	 * 
	 * @return Integer
	 */
	public Integer getFkNorma()
	{
		return this.fkNorma;
	}

	/**
	 * Method 'setFkNorma'
	 * 
	 * @param fkNorma
	 */
	public void setFkNorma(Integer fkNorma)
	{
		this.fkNorma = fkNorma;
	}

	/**
	 * Method 'getFlgNorma'
	 * 
	 * @return String
	 */
	public String getFlgNorma()
	{
		return this.flgNorma;
	}

	/**
	 * Method 'setFlgNorma'
	 * 
	 * @param flgNorma
	 */
	public void setFlgNorma(String flgNorma)
	{
		this.flgNorma = flgNorma;
	}

	/**
	 * Method 'getMotivoNonConformita'
	 * 
	 * @return String
	 */
	public String getMotivoNonConformita()
	{
		return this.motivoNonConformita;
	}

	/**
	 * Method 'setMotivoNonConformita'
	 * 
	 * @param motivoNonConformita
	 */
	public void setMotivoNonConformita(String motivoNonConformita)
	{
		this.motivoNonConformita = motivoNonConformita;
	}

	/**
	 * Method 'getNote'
	 * 
	 * @return String
	 */
	public String getNote()
	{
		return this.note;
	}

	/**
	 * Method 'setNote'
	 * 
	 * @param note
	 */
	public void setNote(String note)
	{
		this.note = note;
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
		
		if (!(_other instanceof SiceeTRispettoNormative)) {
			return false;
		}
		
		final SiceeTRispettoNormative _cast = (SiceeTRispettoNormative) _other;
		if (this.dtTitolo == null ? _cast.dtTitolo != this.dtTitolo : !this.dtTitolo.equals( _cast.dtTitolo )) {
			return false;
		}
		
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.fkNorma == null ? _cast.fkNorma != this.fkNorma : !this.fkNorma.equals( _cast.fkNorma )) {
			return false;
		}
		
		if (this.flgNorma == null ? _cast.flgNorma != this.flgNorma : !this.flgNorma.equals( _cast.flgNorma )) {
			return false;
		}
		
		if (this.motivoNonConformita == null ? _cast.motivoNonConformita != this.motivoNonConformita : !this.motivoNonConformita.equals( _cast.motivoNonConformita )) {
			return false;
		}
		
		if (this.note == null ? _cast.note != this.note : !this.note.equals( _cast.note )) {
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
		if (this.dtTitolo != null) {
			_hashCode = 29 * _hashCode + this.dtTitolo.hashCode();
		}
		
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.fkNorma != null) {
			_hashCode = 29 * _hashCode + this.fkNorma.hashCode();
		}
		
		if (this.flgNorma != null) {
			_hashCode = 29 * _hashCode + this.flgNorma.hashCode();
		}
		
		if (this.motivoNonConformita != null) {
			_hashCode = 29 * _hashCode + this.motivoNonConformita.hashCode();
		}
		
		if (this.note != null) {
			_hashCode = 29 * _hashCode + this.note.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTRispettoNormativePk
	 */
	public SiceeTRispettoNormativePk createPk()
	{
		return new SiceeTRispettoNormativePk(this.idCertificatore, this.progrCertificato, this.anno);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRispettoNormative: " );
		ret.append( "dtTitolo=" + this.dtTitolo );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", fkNorma=" + this.fkNorma );
		ret.append( ", flgNorma=" + this.flgNorma );
		ret.append( ", motivoNonConformita=" + this.motivoNonConformita );
		ret.append( ", note=" + this.note );
		return ret.toString();
	}

}
