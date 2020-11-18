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

public class OptimizedSiceeTCredito2018 implements Serializable
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
	 * This attribute maps to the column ID_TRANSAZIONE_MDP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String idTransazioneMdp;
	
	/** 
	 * This attribute represents whether the primitive attribute idTransazioneMdp is null.
	 */
	protected boolean idTransazioneMdpNull = true;

	/** 
	 * This attribute maps to the column FK_TIPO_OP_2018 in the SICEE_T_CREDITO_2018 table.
	 */
	protected Integer fkTipoOp2018;

	/** 
	 * This attribute maps to the column DESCR_TIPO_OP_2018 in the SICEE_D_TIPO_OP_2018 table.
	 */
	protected String descrTipoOp2018;
	
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
	 * This attribute maps to the column NUM_CERTIFICATORE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String numCertificatore;

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
	public OptimizedSiceeTCredito2018()
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
	 * Method 'getIdTransazioneMdp'
	 * 
	 * @return String
	 */
	public String getIdTransazioneMdp()
	{
		return idTransazioneMdp;
	}

	/**
	 * Method 'setIdTransazioneMdp'
	 * 
	 * @param idTransazioneMdp
	 */
	public void setIdTransazioneMdp(String idTransazioneMdp)
	{
		this.idTransazioneMdp = idTransazioneMdp;
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
	 * Method 'getDescrTipoOp2018'
	 * 
	 * @return String
	 */
	public String getDescrTipoOp2018()
	{
		return descrTipoOp2018;
	}

	/**
	 * Method 'setDescrTipoOp2018'
	 * 
	 * @param descrTipoOp2018
	 */
	public void setDescrTipoOp2018(String descrTipoOp2018)
	{
		this.descrTipoOp2018 = descrTipoOp2018;
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
	 * Method 'getNumCertificatore'
	 * 
	 * @return String
	 */
	public String getNumCertificatore()
	{
		return numCertificatore;
	}

	/**
	 * Method 'setNumCertificatore'
	 * 
	 * @param numCertificatore
	 */
	public void setNumCertificatore(String numCertificatore)
	{
		this.numCertificatore = numCertificatore;
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
		
		final OptimizedSiceeTCredito2018 _cast = (OptimizedSiceeTCredito2018) _other;
		if (idCredito != _cast.idCredito) {
			return false;
		}
		
		if (fkCertificatore == null ? _cast.fkCertificatore != fkCertificatore : !fkCertificatore.equals( _cast.fkCertificatore )) {
			return false;
		}
		
		if (idTransazioneMdp != _cast.idTransazioneMdp) {
			return false;
		}
		
		if (idTransazioneMdpNull != _cast.idTransazioneMdpNull) {
			return false;
		}
		
		if (fkTipoOp2018 == null ? _cast.fkTipoOp2018 != fkTipoOp2018 : !fkTipoOp2018.equals( _cast.fkTipoOp2018 )) {
			return false;
		}

		if (descrTipoOp2018 == null ? _cast.descrTipoOp2018 != descrTipoOp2018 : !descrTipoOp2018.equals( _cast.descrTipoOp2018 )) {
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
		
		if (numCertificatore == null ? _cast.numCertificatore != numCertificatore : !numCertificatore.equals( _cast.numCertificatore )) {
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
		ret.append( ", idTransazioneMdp=" + idTransazioneMdp );
		ret.append( ", fkTipoOp2018=" + fkTipoOp2018 );
		ret.append( ", descrTipoOp2018=" + descrTipoOp2018 );
		ret.append( ", valoreCreditoIniziale=" + valoreCreditoIniziale );
		ret.append( ", valoreCreditoFinale=" + valoreCreditoFinale );
		ret.append( ", dataOperazione=" + dataOperazione );
		ret.append( ", valoreOperazione=" + valoreOperazione );
		ret.append( ", numCertificatore=" + numCertificatore );
		ret.append( ", fkCertificatoreCertificato=" + fkCertificatoreCertificato );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		return ret.toString();
	}

}
