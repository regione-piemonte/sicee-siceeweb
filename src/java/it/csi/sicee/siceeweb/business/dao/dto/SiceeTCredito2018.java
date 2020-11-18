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
import java.util.Date;

public class SiceeTCredito2018 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CREDITO in the SICEE_T_CREDITO_2018 table.
	 */
	protected Integer idCredito;

	/** 
	 * This attribute maps to the column FK_CERTIFICATORE in the SICEE_T_CREDITO_2018 table.
	 */
	protected String fkCertificatore;

	/** 
	 * This attribute maps to the column FK_TRANSAZIONE_2018 in the SICEE_T_CREDITO_2018 table.
	 */
	protected Integer fkTransazione2018;

	/** 
	 * This attribute represents whether the primitive attribute fkTransazione2018 is null.
	 */
	protected boolean fkTransazione2018Null = true;

	/** 
	 * This attribute maps to the column FK_TIPO_OP_2018 in the SICEE_T_CREDITO_2018 table.
	 */
	protected Integer fkTipoOp2018;

	/** 
	 * This attribute maps to the column VALORE_CREDITO_INIZIALE in the SICEE_T_CREDITO_2018 table.
	 */
	protected Double valoreCreditoIniziale;

	/** 
	 * This attribute represents whether the primitive attribute valoreCreditoIniziale is null.
	 */
	protected boolean valoreCreditoInizialeNull = true;

	/** 
	 * This attribute maps to the column VALORE_CREDITO_FINALE in the SICEE_T_CREDITO_2018 table.
	 */
	protected Double valoreCreditoFinale;

	/** 
	 * This attribute represents whether the primitive attribute valoreCreditoFinale is null.
	 */
	protected boolean valoreCreditoFinaleNull = true;

	/** 
	 * This attribute maps to the column DATA_OPERAZIONE in the SICEE_T_CREDITO_2018 table.
	 */
	protected Date dataOperazione;

	/** 
	 * This attribute maps to the column VALORE_OPERAZIONE in the SICEE_T_CREDITO_2018 table.
	 */
	protected Double valoreOperazione;

	/** 
	 * This attribute represents whether the primitive attribute valoreOperazione is null.
	 */
	protected boolean valoreOperazioneNull = true;

	/** 
	 * This attribute maps to the column NOTE in the SICEE_T_CREDITO_2018 table.
	 */
	protected String note;

	/** 
	 * This attribute maps to the column FK_CERTIFICATORE_CERTIFICATO in the SICEE_T_CREDITO_2018 table.
	 */
	protected String fkCertificatoreCertificato;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_CREDITO_2018 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_CREDITO_2018 table.
	 */
	protected String anno;

	/**
	 * Method 'SiceeTCredito2018'
	 * 
	 */
	public SiceeTCredito2018()
	{
	}

	/**
	 * Method 'getIdCredito'
	 * 
	 * @return Integer
	 */
	public Integer getIdCredito()
	{
		return idCredito;
	}

	/**
	 * Method 'setIdCredito'
	 * 
	 * @param idCredito
	 */
	public void setIdCredito(Integer idCredito)
	{
		this.idCredito = idCredito;
	}

	/**
	 * Method 'getFkCertificatore'
	 * 
	 * @return String
	 */
	public String getFkCertificatore()
	{
		return fkCertificatore;
	}

	/**
	 * Method 'setFkCertificatore'
	 * 
	 * @param fkCertificatore
	 */
	public void setFkCertificatore(String fkCertificatore)
	{
		this.fkCertificatore = fkCertificatore;
	}

	/**
	 * Method 'getFkTransazione2018'
	 * 
	 * @return long
	 */
	public Integer getFkTransazione2018()
	{
		return fkTransazione2018;
	}

	/**
	 * Method 'setFkTransazione2018'
	 * 
	 * @param fkTransazione2018
	 */
	public void setFkTransazione2018(Integer fkTransazione2018)
	{
		this.fkTransazione2018 = fkTransazione2018;
		this.fkTransazione2018Null = false;
	}

	/**
	 * Method 'setFkTransazione2018Null'
	 * 
	 * @param value
	 */
	public void setFkTransazione2018Null(boolean value)
	{
		this.fkTransazione2018Null = value;
	}

	/**
	 * Method 'isFkTransazione2018Null'
	 * 
	 * @return boolean
	 */
	public boolean isFkTransazione2018Null()
	{
		return fkTransazione2018Null;
	}

	/**
	 * Method 'getFkTipoOp2018'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoOp2018()
	{
		return fkTipoOp2018;
	}

	/**
	 * Method 'setFkTipoOp2018'
	 * 
	 * @param fkTipoOp2018
	 */
	public void setFkTipoOp2018(Integer fkTipoOp2018)
	{
		this.fkTipoOp2018 = fkTipoOp2018;
	}

	/**
	 * Method 'getValoreCreditoIniziale'
	 * 
	 * @return Double
	 */
	public Double getValoreCreditoIniziale()
	{
		return valoreCreditoIniziale;
	}

	/**
	 * Method 'setValoreCreditoIniziale'
	 * 
	 * @param valoreCreditoIniziale
	 */
	public void setValoreCreditoIniziale(Double valoreCreditoIniziale)
	{
		this.valoreCreditoIniziale = valoreCreditoIniziale;
		this.valoreCreditoInizialeNull = false;
	}

	/**
	 * Method 'setValoreCreditoInizialeNull'
	 * 
	 * @param value
	 */
	public void setValoreCreditoInizialeNull(boolean value)
	{
		this.valoreCreditoInizialeNull = value;
	}

	/**
	 * Method 'isValoreCreditoInizialeNull'
	 * 
	 * @return boolean
	 */
	public boolean isValoreCreditoInizialeNull()
	{
		return valoreCreditoInizialeNull;
	}

	/**
	 * Method 'getValoreCreditoFinale'
	 * 
	 * @return Double
	 */
	public Double getValoreCreditoFinale()
	{
		return valoreCreditoFinale;
	}

	/**
	 * Method 'setValoreCreditoFinale'
	 * 
	 * @param valoreCreditoFinale
	 */
	public void setValoreCreditoFinale(Double valoreCreditoFinale)
	{
		this.valoreCreditoFinale = valoreCreditoFinale;
		this.valoreCreditoFinaleNull = false;
	}

	/**
	 * Method 'setValoreCreditoFinaleNull'
	 * 
	 * @param value
	 */
	public void setValoreCreditoFinaleNull(boolean value)
	{
		this.valoreCreditoFinaleNull = value;
	}

	/**
	 * Method 'isValoreCreditoFinaleNull'
	 * 
	 * @return boolean
	 */
	public boolean isValoreCreditoFinaleNull()
	{
		return valoreCreditoFinaleNull;
	}

	/**
	 * Method 'getDataOperazione'
	 * 
	 * @return Date
	 */
	public Date getDataOperazione()
	{
		return dataOperazione;
	}

	/**
	 * Method 'setDataOperazione'
	 * 
	 * @param dataOperazione
	 */
	public void setDataOperazione(Date dataOperazione)
	{
		this.dataOperazione = dataOperazione;
	}

	/**
	 * Method 'getValoreOperazione'
	 * 
	 * @return Double
	 */
	public Double getValoreOperazione()
	{
		return valoreOperazione;
	}

	/**
	 * Method 'setValoreOperazione'
	 * 
	 * @param valoreOperazione
	 */
	public void setValoreOperazione(Double valoreOperazione)
	{
		this.valoreOperazione = valoreOperazione;
		this.valoreOperazioneNull = false;
	}

	/**
	 * Method 'setValoreOperazioneNull'
	 * 
	 * @param value
	 */
	public void setValoreOperazioneNull(boolean value)
	{
		this.valoreOperazioneNull = value;
	}

	/**
	 * Method 'isValoreOperazioneNull'
	 * 
	 * @return boolean
	 */
	public boolean isValoreOperazioneNull()
	{
		return valoreOperazioneNull;
	}

	/**
	 * Method 'getNote'
	 * 
	 * @return String
	 */
	public String getNote()
	{
		return note;
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
	 * Method 'getFkCertificatoreCertificato'
	 * 
	 * @return String
	 */
	public String getFkCertificatoreCertificato()
	{
		return fkCertificatoreCertificato;
	}

	/**
	 * Method 'setFkCertificatoreCertificato'
	 * 
	 * @param fkCertificatoreCertificato
	 */
	public void setFkCertificatoreCertificato(String fkCertificatoreCertificato)
	{
		this.fkCertificatoreCertificato = fkCertificatoreCertificato;
	}

	/**
	 * Method 'getProgrCertificato'
	 * 
	 * @return String
	 */
	public String getProgrCertificato()
	{
		return progrCertificato;
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
		return anno;
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
		
		if (!(_other instanceof SiceeTCredito2018)) {
			return false;
		}
		
		final SiceeTCredito2018 _cast = (SiceeTCredito2018) _other;
		if (idCredito != _cast.idCredito) {
			return false;
		}
		
		if (fkCertificatore == null ? _cast.fkCertificatore != fkCertificatore : !fkCertificatore.equals( _cast.fkCertificatore )) {
			return false;
		}
		
		if (fkTransazione2018 != _cast.fkTransazione2018) {
			return false;
		}
		
		if (fkTransazione2018Null != _cast.fkTransazione2018Null) {
			return false;
		}
		
		if (fkTipoOp2018 == null ? _cast.fkTipoOp2018 != fkTipoOp2018 : !fkTipoOp2018.equals( _cast.fkTipoOp2018 )) {
			return false;
		}
		
		if (valoreCreditoIniziale != _cast.valoreCreditoIniziale) {
			return false;
		}
		
		if (valoreCreditoInizialeNull != _cast.valoreCreditoInizialeNull) {
			return false;
		}
		
		if (valoreCreditoFinale != _cast.valoreCreditoFinale) {
			return false;
		}
		
		if (valoreCreditoFinaleNull != _cast.valoreCreditoFinaleNull) {
			return false;
		}
		
		if (dataOperazione == null ? _cast.dataOperazione != dataOperazione : !dataOperazione.equals( _cast.dataOperazione )) {
			return false;
		}
		
		if (valoreOperazione != _cast.valoreOperazione) {
			return false;
		}
		
		if (valoreOperazioneNull != _cast.valoreOperazioneNull) {
			return false;
		}
		
		if (note == null ? _cast.note != note : !note.equals( _cast.note )) {
			return false;
		}
		
		if (fkCertificatoreCertificato == null ? _cast.fkCertificatoreCertificato != fkCertificatoreCertificato : !fkCertificatoreCertificato.equals( _cast.fkCertificatoreCertificato )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
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
		_hashCode = 29 * _hashCode + (int) (idCredito ^ (idCredito >>> 32));
		if (fkCertificatore != null) {
			_hashCode = 29 * _hashCode + fkCertificatore.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (fkTransazione2018 ^ (fkTransazione2018 >>> 32));
		_hashCode = 29 * _hashCode + (fkTransazione2018Null ? 1 : 0);
		if (fkTipoOp2018 != null) {
			_hashCode = 29 * _hashCode + fkTipoOp2018.hashCode();
		}
		
		if (valoreCreditoIniziale != null) {
			_hashCode = 29 * _hashCode + valoreCreditoIniziale.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (valoreCreditoInizialeNull ? 1 : 0);
		if (valoreCreditoFinale != null) {
			_hashCode = 29 * _hashCode + valoreCreditoFinale.hashCode();
		}
		_hashCode = 29 * _hashCode + (valoreCreditoFinaleNull ? 1 : 0);
		if (dataOperazione != null) {
			_hashCode = 29 * _hashCode + dataOperazione.hashCode();
		}
		
		if (valoreOperazione != null) {
			_hashCode = 29 * _hashCode + valoreOperazione.hashCode();
		}
		_hashCode = 29 * _hashCode + (valoreOperazioneNull ? 1 : 0);
		if (note != null) {
			_hashCode = 29 * _hashCode + note.hashCode();
		}
		
		if (fkCertificatoreCertificato != null) {
			_hashCode = 29 * _hashCode + fkCertificatoreCertificato.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTCredito2018Pk
	 */
	public SiceeTCredito2018Pk createPk()
	{
		return new SiceeTCredito2018Pk(idCredito);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018: " );
		ret.append( "idCredito=" + idCredito );
		ret.append( ", fkCertificatore=" + fkCertificatore );
		ret.append( ", fkTransazione2018=" + fkTransazione2018 );
		ret.append( ", fkTipoOp2018=" + fkTipoOp2018 );
		ret.append( ", valoreCreditoIniziale=" + valoreCreditoIniziale );
		ret.append( ", valoreCreditoFinale=" + valoreCreditoFinale );
		ret.append( ", dataOperazione=" + dataOperazione );
		ret.append( ", valoreOperazione=" + valoreOperazione );
		ret.append( ", note=" + note );
		ret.append( ", fkCertificatoreCertificato=" + fkCertificatoreCertificato );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		return ret.toString();
	}

}
