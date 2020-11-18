/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class SiceeTTransazioneAce implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6687458958778768118L;

	/** 
	 * This attribute maps to the column ID_TRANSAZIONE_ACE in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected long idTransazioneAce;

	/** 
	 * This attribute maps to the column FK_TIPO_PAGAMENTO in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected Integer fkTipoPagamento;

	/** 
	 * This attribute maps to the column NUM_TRANSAZIONE in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected String numTransazione;

	/** 
	 * This attribute maps to the column DATA_TRANSAZIONE in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected Timestamp dataTransazione;

	/** 
	 * This attribute maps to the column FLG_VERIFICATO in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected String flgVerificato;

	/** 
	 * This attribute maps to the column ESEGUITO_NOME in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected String eseguitoNome;

	/** 
	 * This attribute maps to the column ESEGUITO_COGNOME in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected String eseguitoCognome;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column QUANTITA in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected Integer quantita;

	/** 
	 * This attribute maps to the column FK_CERTIFICATORE in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	protected String fkCertificatore;

	/**
	 * Method 'SiceeTTransazioneAce'
	 * 
	 */
	public SiceeTTransazioneAce()
	{
	}

	/**
	 * Method 'getIdTransazioneAce'
	 * 
	 * @return long
	 */
	public long getIdTransazioneAce()
	{
		return this.idTransazioneAce;
	}

	/**
	 * Method 'setIdTransazioneAce'
	 * 
	 * @param idTransazioneAce
	 */
	public void setIdTransazioneAce(long idTransazioneAce)
	{
		this.idTransazioneAce = idTransazioneAce;
	}

	/**
	 * Method 'getFkTipoPagamento'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoPagamento()
	{
		return this.fkTipoPagamento;
	}

	/**
	 * Method 'setFkTipoPagamento'
	 * 
	 * @param fkTipoPagamento
	 */
	public void setFkTipoPagamento(Integer fkTipoPagamento)
	{
		this.fkTipoPagamento = fkTipoPagamento;
	}

	/**
	 * Method 'getNumTransazione'
	 * 
	 * @return String
	 */
	public String getNumTransazione()
	{
		return this.numTransazione;
	}

	/**
	 * Method 'setNumTransazione'
	 * 
	 * @param numTransazione
	 */
	public void setNumTransazione(String numTransazione)
	{
		this.numTransazione = numTransazione;
	}

	/**
	 * Method 'getDataTransazione'
	 * 
	 * @return Date
	 */
	public Timestamp getDataTransazione()
	{
		return this.dataTransazione;
	}

	/**
	 * Method 'setDataTransazione'
	 * 
	 * @param dataTransazione
	 */
	public void setDataTransazione(Timestamp dataTransazione)
	{
		this.dataTransazione = dataTransazione;
	}

	/**
	 * Method 'getFlgVerificato'
	 * 
	 * @return String
	 */
	public String getFlgVerificato()
	{
		return this.flgVerificato;
	}

	/**
	 * Method 'setFlgVerificato'
	 * 
	 * @param flgVerificato
	 */
	public void setFlgVerificato(String flgVerificato)
	{
		this.flgVerificato = flgVerificato;
	}

	/**
	 * Method 'getEseguitoNome'
	 * 
	 * @return String
	 */
	public String getEseguitoNome()
	{
		return this.eseguitoNome;
	}

	/**
	 * Method 'setEseguitoNome'
	 * 
	 * @param eseguitoNome
	 */
	public void setEseguitoNome(String eseguitoNome)
	{
		this.eseguitoNome = eseguitoNome;
	}

	/**
	 * Method 'getEseguitoCognome'
	 * 
	 * @return String
	 */
	public String getEseguitoCognome()
	{
		return this.eseguitoCognome;
	}

	/**
	 * Method 'setEseguitoCognome'
	 * 
	 * @param eseguitoCognome
	 */
	public void setEseguitoCognome(String eseguitoCognome)
	{
		this.eseguitoCognome = eseguitoCognome;
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
	 * Method 'getQuantita'
	 * 
	 * @return Integer
	 */
	public Integer getQuantita()
	{
		return this.quantita;
	}

	/**
	 * Method 'setQuantita'
	 * 
	 * @param quantita
	 */
	public void setQuantita(Integer quantita)
	{
		this.quantita = quantita;
	}

	/**
	 * Method 'getFkCertificatore'
	 * 
	 * @return String
	 */
	public String getFkCertificatore()
	{
		return this.fkCertificatore;
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
		
		if (!(_other instanceof SiceeTTransazioneAce)) {
			return false;
		}
		
		final SiceeTTransazioneAce _cast = (SiceeTTransazioneAce) _other;
		if (this.idTransazioneAce != _cast.idTransazioneAce) {
			return false;
		}
		
		if (this.fkTipoPagamento == null ? _cast.fkTipoPagamento != this.fkTipoPagamento : !this.fkTipoPagamento.equals( _cast.fkTipoPagamento )) {
			return false;
		}
		
		if (this.numTransazione == null ? _cast.numTransazione != this.numTransazione : !this.numTransazione.equals( _cast.numTransazione )) {
			return false;
		}
		
		if (this.dataTransazione == null ? _cast.dataTransazione != this.dataTransazione : !this.dataTransazione.equals( _cast.dataTransazione )) {
			return false;
		}
		
		if (this.flgVerificato == null ? _cast.flgVerificato != this.flgVerificato : !this.flgVerificato.equals( _cast.flgVerificato )) {
			return false;
		}
		
		if (this.eseguitoNome == null ? _cast.eseguitoNome != this.eseguitoNome : !this.eseguitoNome.equals( _cast.eseguitoNome )) {
			return false;
		}
		
		if (this.eseguitoCognome == null ? _cast.eseguitoCognome != this.eseguitoCognome : !this.eseguitoCognome.equals( _cast.eseguitoCognome )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.quantita == null ? _cast.quantita != this.quantita : !this.quantita.equals( _cast.quantita )) {
			return false;
		}
		
		if (this.fkCertificatore == null ? _cast.fkCertificatore != this.fkCertificatore : !this.fkCertificatore.equals( _cast.fkCertificatore )) {
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
		_hashCode = 29 * _hashCode + (int) (this.idTransazioneAce ^ (this.idTransazioneAce >>> 32));
		if (this.fkTipoPagamento != null) {
			_hashCode = 29 * _hashCode + this.fkTipoPagamento.hashCode();
		}
		
		if (this.numTransazione != null) {
			_hashCode = 29 * _hashCode + this.numTransazione.hashCode();
		}
		
		if (this.dataTransazione != null) {
			_hashCode = 29 * _hashCode + this.dataTransazione.hashCode();
		}
		
		if (this.flgVerificato != null) {
			_hashCode = 29 * _hashCode + this.flgVerificato.hashCode();
		}
		
		if (this.eseguitoNome != null) {
			_hashCode = 29 * _hashCode + this.eseguitoNome.hashCode();
		}
		
		if (this.eseguitoCognome != null) {
			_hashCode = 29 * _hashCode + this.eseguitoCognome.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.quantita != null) {
			_hashCode = 29 * _hashCode + this.quantita.hashCode();
		}
		
		if (this.fkCertificatore != null) {
			_hashCode = 29 * _hashCode + this.fkCertificatore.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTTransazioneAcePk
	 */
	public SiceeTTransazioneAcePk createPk()
	{
		return new SiceeTTransazioneAcePk(this.idTransazioneAce);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneAce: " );
		ret.append( "idTransazioneAce=" + this.idTransazioneAce );
		ret.append( ", fkTipoPagamento=" + this.fkTipoPagamento );
		ret.append( ", numTransazione=" + this.numTransazione );
		ret.append( ", dataTransazione=" + this.dataTransazione );
		ret.append( ", flgVerificato=" + this.flgVerificato );
		ret.append( ", eseguitoNome=" + this.eseguitoNome );
		ret.append( ", eseguitoCognome=" + this.eseguitoCognome );
		ret.append( ", anno=" + this.anno );
		ret.append( ", quantita=" + this.quantita );
		ret.append( ", fkCertificatore=" + this.fkCertificatore );
		return ret.toString();
	}

}
