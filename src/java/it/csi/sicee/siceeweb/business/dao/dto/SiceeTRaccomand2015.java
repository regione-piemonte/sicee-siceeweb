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
import java.math.BigInteger;

public class SiceeTRaccomand2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_RACCOMANDAZIONE in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected Long idRaccomandazione;

	/** 
	 * This attribute maps to the column CODICE_REN in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected String codiceRen;

	/** 
	 * This attribute maps to the column FK_CLASSE_ENERGETICA in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected Integer fkClasseEnergetica;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column TIPO_INTERVENTO in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected String tipoIntervento;

	/** 
	 * This attribute maps to the column FLG_RISTRUTTURAZIONE in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected String flgRistrutturazione;

	/** 
	 * This attribute maps to the column NR_ANNI_RIT_INVEST in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected Double nrAnniRitInvest;

	/** 
	 * This attribute maps to the column EPGL_NREN_SINGOLO_INT in the SICEE_T_RACCOMAND_2015 table.
	 */
	protected Double epglNrenSingoloInt;

	/**
	 * Method 'SiceeTRaccomand2015'
	 * 
	 */
	public SiceeTRaccomand2015()
	{
	}

	/**
	 * Method 'getIdRaccomandazione'
	 * 
	 * @return long
	 */
	public Long getIdRaccomandazione()
	{
		return idRaccomandazione;
	}

	/**
	 * Method 'setIdRaccomandazione'
	 * 
	 * @param idRaccomandazione
	 */
	public void setIdRaccomandazione(Long idRaccomandazione)
	{
		this.idRaccomandazione = idRaccomandazione;
	}

	/**
	 * Method 'getCodiceRen'
	 * 
	 * @return String
	 */
	public String getCodiceRen()
	{
		return codiceRen;
	}

	/**
	 * Method 'setCodiceRen'
	 * 
	 * @param codiceRen
	 */
	public void setCodiceRen(String codiceRen)
	{
		this.codiceRen = codiceRen;
	}

	/**
	 * Method 'getFkClasseEnergetica'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasseEnergetica()
	{
		return fkClasseEnergetica;
	}

	/**
	 * Method 'setFkClasseEnergetica'
	 * 
	 * @param fkClasseEnergetica
	 */
	public void setFkClasseEnergetica(Integer fkClasseEnergetica)
	{
		this.fkClasseEnergetica = fkClasseEnergetica;
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return idCertificatore;
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
	 * Method 'getTipoIntervento'
	 * 
	 * @return String
	 */
	public String getTipoIntervento()
	{
		return tipoIntervento;
	}

	/**
	 * Method 'setTipoIntervento'
	 * 
	 * @param tipoIntervento
	 */
	public void setTipoIntervento(String tipoIntervento)
	{
		this.tipoIntervento = tipoIntervento;
	}

	/**
	 * Method 'getFlgRistrutturazione'
	 * 
	 * @return String
	 */
	public String getFlgRistrutturazione()
	{
		return flgRistrutturazione;
	}

	/**
	 * Method 'setFlgRistrutturazione'
	 * 
	 * @param flgRistrutturazione
	 */
	public void setFlgRistrutturazione(String flgRistrutturazione)
	{
		this.flgRistrutturazione = flgRistrutturazione;
	}

	/**
	 * Method 'getNrAnniRitInvest'
	 * 
	 * @return Double
	 */
	public Double getNrAnniRitInvest()
	{
		return nrAnniRitInvest;
	}

	/**
	 * Method 'setNrAnniRitInvest'
	 * 
	 * @param nrAnniRitInvest
	 */
	public void setNrAnniRitInvest(Double nrAnniRitInvest)
	{
		this.nrAnniRitInvest = nrAnniRitInvest;
	}

	/**
	 * Method 'getEpglNrenSingoloInt'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenSingoloInt()
	{
		return epglNrenSingoloInt;
	}

	/**
	 * Method 'setEpglNrenSingoloInt'
	 * 
	 * @param epglNrenSingoloInt
	 */
	public void setEpglNrenSingoloInt(Double epglNrenSingoloInt)
	{
		this.epglNrenSingoloInt = epglNrenSingoloInt;
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
		
		if (!(_other instanceof SiceeTRaccomand2015)) {
			return false;
		}
		
		final SiceeTRaccomand2015 _cast = (SiceeTRaccomand2015) _other;
		if (idRaccomandazione != _cast.idRaccomandazione) {
			return false;
		}
		
		if (codiceRen == null ? _cast.codiceRen != codiceRen : !codiceRen.equals( _cast.codiceRen )) {
			return false;
		}
		
		if (fkClasseEnergetica == null ? _cast.fkClasseEnergetica != fkClasseEnergetica : !fkClasseEnergetica.equals( _cast.fkClasseEnergetica )) {
			return false;
		}
		
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (tipoIntervento == null ? _cast.tipoIntervento != tipoIntervento : !tipoIntervento.equals( _cast.tipoIntervento )) {
			return false;
		}
		
		if (flgRistrutturazione == null ? _cast.flgRistrutturazione != flgRistrutturazione : !flgRistrutturazione.equals( _cast.flgRistrutturazione )) {
			return false;
		}
		
		if (nrAnniRitInvest == null ? _cast.nrAnniRitInvest != nrAnniRitInvest : !nrAnniRitInvest.equals( _cast.nrAnniRitInvest )) {
			return false;
		}
		
		if (epglNrenSingoloInt == null ? _cast.epglNrenSingoloInt != epglNrenSingoloInt : !epglNrenSingoloInt.equals( _cast.epglNrenSingoloInt )) {
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
		_hashCode = 29 * _hashCode + (int) (idRaccomandazione ^ (idRaccomandazione >>> 32));
		if (codiceRen != null) {
			_hashCode = 29 * _hashCode + codiceRen.hashCode();
		}
		
		if (fkClasseEnergetica != null) {
			_hashCode = 29 * _hashCode + fkClasseEnergetica.hashCode();
		}
		
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (tipoIntervento != null) {
			_hashCode = 29 * _hashCode + tipoIntervento.hashCode();
		}
		
		if (flgRistrutturazione != null) {
			_hashCode = 29 * _hashCode + flgRistrutturazione.hashCode();
		}
		
		if (nrAnniRitInvest != null) {
			_hashCode = 29 * _hashCode + nrAnniRitInvest.hashCode();
		}
		
		if (epglNrenSingoloInt != null) {
			_hashCode = 29 * _hashCode + epglNrenSingoloInt.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTRaccomand2015Pk
	 */
	public SiceeTRaccomand2015Pk createPk()
	{
		return new SiceeTRaccomand2015Pk(idRaccomandazione);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015: " );
		ret.append( "idRaccomandazione=" + idRaccomandazione );
		ret.append( ", codiceRen=" + codiceRen );
		ret.append( ", fkClasseEnergetica=" + fkClasseEnergetica );
		ret.append( ", idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", tipoIntervento=" + tipoIntervento );
		ret.append( ", flgRistrutturazione=" + flgRistrutturazione );
		ret.append( ", nrAnniRitInvest=" + nrAnniRitInvest );
		ret.append( ", epglNrenSingoloInt=" + epglNrenSingoloInt );
		return ret.toString();
	}

}
