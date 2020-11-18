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

public class SiceeTTransazione2018 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TRANSAZIONE_2018 in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Integer idTransazione2018;

	/** 
	 * This attribute maps to the column FK_CERTIFICATORE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String fkCertificatore;

	/** 
	 * This attribute maps to the column FK_STATO_TRANS_2018 in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Integer fkStatoTrans2018;

	/** 
	 * This attribute maps to the column XML_RT in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String xmlRt;

	/** 
	 * This attribute maps to the column S1_VALORE_TRANSAZIONE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Double s1ValoreTransazione;

	/** 
	 * This attribute maps to the column S1_TIPO_ID_VERSANTE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s1TipoIdVersante;

	/** 
	 * This attribute maps to the column S1_COD_ID_VERSANTE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s1CodIdVersante;

	/** 
	 * This attribute maps to the column S1_ANAGRAFICA_VERSANTE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s1AnagraficaVersante;

	/** 
	 * This attribute maps to the column S1_ID_TRANSAZIONE_MDP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s1IdTransazioneMdp;

	/** 
	 * This attribute maps to the column S1_DT_CREAZIONE_TRANSAZIONE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Date s1DtCreazioneTransazione;

	/** 
	 * This attribute maps to the column S2_ID_INFORMATIVA_PSP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected long s2IdInformativaPsp;

	/** 
	 * This attribute represents whether the primitive attribute s2IdInformativaPsp is null.
	 */
	protected boolean s2IdInformativaPspNull = true;

	/** 
	 * This attribute maps to the column S2_IDENTIFICATIVO_PSP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s2IdentificativoPsp;

	/** 
	 * This attribute maps to the column S2_RAG_SOCIALE_PSP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s2RagSocialePsp;

	/** 
	 * This attribute maps to the column S2_DESCR_SERVIZIO_PSP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s2DescrServizioPsp;

	/** 
	 * This attribute maps to the column S3_ID_IUV in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s3IdIuv;

	/** 
	 * This attribute maps to the column S3_DT_AVVIO_TRANSAZIONE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Date s3DtAvvioTransazione;

	/** 
	 * This attribute maps to the column DT_CHIUSURA_TRANSAZIONE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Date dtChiusuraTransazione;

	/** 
	 * This attribute maps to the column OP_GETSTATOTRANS_FK_STATO in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Integer opGetstatotransFkStato;

	/** 
	 * This attribute maps to the column OP_GETSTATOTRANS_DT in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Date opGetstatotransDt;

	/**
	 * Method 'SiceeTTransazione2018'
	 * 
	 */
	public SiceeTTransazione2018()
	{
	}

	/**
	 * Method 'getIdTransazione2018'
	 * 
	 * @return Integer
	 */
	public Integer getIdTransazione2018()
	{
		return idTransazione2018;
	}

	/**
	 * Method 'setIdTransazione2018'
	 * 
	 * @param idTransazione2018
	 */
	public void setIdTransazione2018(Integer idTransazione2018)
	{
		this.idTransazione2018 = idTransazione2018;
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
	 * Method 'getFkStatoTrans2018'
	 * 
	 * @return Integer
	 */
	public Integer getFkStatoTrans2018()
	{
		return fkStatoTrans2018;
	}

	/**
	 * Method 'setFkStatoTrans2018'
	 * 
	 * @param fkStatoTrans2018
	 */
	public void setFkStatoTrans2018(Integer fkStatoTrans2018)
	{
		this.fkStatoTrans2018 = fkStatoTrans2018;
	}

	/**
	 * Method 'getXmlRt'
	 * 
	 * @return String
	 */
	public String getXmlRt()
	{
		return xmlRt;
	}

	/**
	 * Method 'setXmlRt'
	 * 
	 * @param xmlRt
	 */
	public void setXmlRt(String xmlRt)
	{
		this.xmlRt = xmlRt;
	}

	/**
	 * Method 'getS1ValoreTransazione'
	 * 
	 * @return Double
	 */
	public Double getS1ValoreTransazione()
	{
		return s1ValoreTransazione;
	}

	/**
	 * Method 'setS1ValoreTransazione'
	 * 
	 * @param s1ValoreTransazione
	 */
	public void setS1ValoreTransazione(Double s1ValoreTransazione)
	{
		this.s1ValoreTransazione = s1ValoreTransazione;
	}

	/**
	 * Method 'getS1TipoIdVersante'
	 * 
	 * @return String
	 */
	public String getS1TipoIdVersante()
	{
		return s1TipoIdVersante;
	}

	/**
	 * Method 'setS1TipoIdVersante'
	 * 
	 * @param s1TipoIdVersante
	 */
	public void setS1TipoIdVersante(String s1TipoIdVersante)
	{
		this.s1TipoIdVersante = s1TipoIdVersante;
	}

	/**
	 * Method 'getS1CodIdVersante'
	 * 
	 * @return String
	 */
	public String getS1CodIdVersante()
	{
		return s1CodIdVersante;
	}

	/**
	 * Method 'setS1CodIdVersante'
	 * 
	 * @param s1CodIdVersante
	 */
	public void setS1CodIdVersante(String s1CodIdVersante)
	{
		this.s1CodIdVersante = s1CodIdVersante;
	}

	/**
	 * Method 'getS1AnagraficaVersante'
	 * 
	 * @return String
	 */
	public String getS1AnagraficaVersante()
	{
		return s1AnagraficaVersante;
	}

	/**
	 * Method 'setS1AnagraficaVersante'
	 * 
	 * @param s1AnagraficaVersante
	 */
	public void setS1AnagraficaVersante(String s1AnagraficaVersante)
	{
		this.s1AnagraficaVersante = s1AnagraficaVersante;
	}

	/**
	 * Method 'getS1IdTransazioneMdp'
	 * 
	 * @return String
	 */
	public String getS1IdTransazioneMdp()
	{
		return s1IdTransazioneMdp;
	}

	/**
	 * Method 'setS1IdTransazioneMdp'
	 * 
	 * @param s1IdTransazioneMdp
	 */
	public void setS1IdTransazioneMdp(String s1IdTransazioneMdp)
	{
		this.s1IdTransazioneMdp = s1IdTransazioneMdp;
	}

	/**
	 * Method 'getS1DtCreazioneTransazione'
	 * 
	 * @return Date
	 */
	public Date getS1DtCreazioneTransazione()
	{
		return s1DtCreazioneTransazione;
	}

	/**
	 * Method 'setS1DtCreazioneTransazione'
	 * 
	 * @param s1DtCreazioneTransazione
	 */
	public void setS1DtCreazioneTransazione(Date s1DtCreazioneTransazione)
	{
		this.s1DtCreazioneTransazione = s1DtCreazioneTransazione;
	}

	/**
	 * Method 'getS2IdInformativaPsp'
	 * 
	 * @return long
	 */
	public long getS2IdInformativaPsp()
	{
		return s2IdInformativaPsp;
	}

	/**
	 * Method 'setS2IdInformativaPsp'
	 * 
	 * @param s2IdInformativaPsp
	 */
	public void setS2IdInformativaPsp(long s2IdInformativaPsp)
	{
		this.s2IdInformativaPsp = s2IdInformativaPsp;
		this.s2IdInformativaPspNull = false;
	}

	/**
	 * Method 'setS2IdInformativaPspNull'
	 * 
	 * @param value
	 */
	public void setS2IdInformativaPspNull(boolean value)
	{
		this.s2IdInformativaPspNull = value;
	}

	/**
	 * Method 'isS2IdInformativaPspNull'
	 * 
	 * @return boolean
	 */
	public boolean isS2IdInformativaPspNull()
	{
		return s2IdInformativaPspNull;
	}

	/**
	 * Method 'getS2IdentificativoPsp'
	 * 
	 * @return String
	 */
	public String getS2IdentificativoPsp()
	{
		return s2IdentificativoPsp;
	}

	/**
	 * Method 'setS2IdentificativoPsp'
	 * 
	 * @param s2IdentificativoPsp
	 */
	public void setS2IdentificativoPsp(String s2IdentificativoPsp)
	{
		this.s2IdentificativoPsp = s2IdentificativoPsp;
	}

	/**
	 * Method 'getS2RagSocialePsp'
	 * 
	 * @return String
	 */
	public String getS2RagSocialePsp()
	{
		return s2RagSocialePsp;
	}

	/**
	 * Method 'setS2RagSocialePsp'
	 * 
	 * @param s2RagSocialePsp
	 */
	public void setS2RagSocialePsp(String s2RagSocialePsp)
	{
		this.s2RagSocialePsp = s2RagSocialePsp;
	}

	/**
	 * Method 'getS2DescrServizioPsp'
	 * 
	 * @return String
	 */
	public String getS2DescrServizioPsp()
	{
		return s2DescrServizioPsp;
	}

	/**
	 * Method 'setS2DescrServizioPsp'
	 * 
	 * @param s2DescrServizioPsp
	 */
	public void setS2DescrServizioPsp(String s2DescrServizioPsp)
	{
		this.s2DescrServizioPsp = s2DescrServizioPsp;
	}

	/**
	 * Method 'getS3IdIuv'
	 * 
	 * @return String
	 */
	public String getS3IdIuv()
	{
		return s3IdIuv;
	}

	/**
	 * Method 'setS3IdIuv'
	 * 
	 * @param s3IdIuv
	 */
	public void setS3IdIuv(String s3IdIuv)
	{
		this.s3IdIuv = s3IdIuv;
	}

	/**
	 * Method 'getS3DtAvvioTransazione'
	 * 
	 * @return Date
	 */
	public Date getS3DtAvvioTransazione()
	{
		return s3DtAvvioTransazione;
	}

	/**
	 * Method 'setS3DtAvvioTransazione'
	 * 
	 * @param s3DtAvvioTransazione
	 */
	public void setS3DtAvvioTransazione(Date s3DtAvvioTransazione)
	{
		this.s3DtAvvioTransazione = s3DtAvvioTransazione;
	}

	/**
	 * Method 'getDtChiusuraTransazione'
	 * 
	 * @return Date
	 */
	public Date getDtChiusuraTransazione()
	{
		return dtChiusuraTransazione;
	}

	/**
	 * Method 'setDtChiusuraTransazione'
	 * 
	 * @param dtChiusuraTransazione
	 */
	public void setDtChiusuraTransazione(Date dtChiusuraTransazione)
	{
		this.dtChiusuraTransazione = dtChiusuraTransazione;
	}

	/**
	 * Method 'getOpGetstatotransFkStato'
	 * 
	 * @return Integer
	 */
	public Integer getOpGetstatotransFkStato()
	{
		return opGetstatotransFkStato;
	}

	/**
	 * Method 'setOpGetstatotransFkStato'
	 * 
	 * @param opGetstatotransFkStato
	 */
	public void setOpGetstatotransFkStato(Integer opGetstatotransFkStato)
	{
		this.opGetstatotransFkStato = opGetstatotransFkStato;
	}

	/**
	 * Method 'getOpGetstatotransDt'
	 * 
	 * @return Date
	 */
	public Date getOpGetstatotransDt()
	{
		return opGetstatotransDt;
	}

	/**
	 * Method 'setOpGetstatotransDt'
	 * 
	 * @param opGetstatotransDt
	 */
	public void setOpGetstatotransDt(Date opGetstatotransDt)
	{
		this.opGetstatotransDt = opGetstatotransDt;
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
		
		if (!(_other instanceof SiceeTTransazione2018)) {
			return false;
		}
		
		final SiceeTTransazione2018 _cast = (SiceeTTransazione2018) _other;
		if (idTransazione2018 != _cast.idTransazione2018) {
			return false;
		}
		
		if (fkCertificatore == null ? _cast.fkCertificatore != fkCertificatore : !fkCertificatore.equals( _cast.fkCertificatore )) {
			return false;
		}
		
		if (fkStatoTrans2018 == null ? _cast.fkStatoTrans2018 != fkStatoTrans2018 : !fkStatoTrans2018.equals( _cast.fkStatoTrans2018 )) {
			return false;
		}
		
		if (xmlRt == null ? _cast.xmlRt != xmlRt : !xmlRt.equals( _cast.xmlRt )) {
			return false;
		}
		
		if (s1ValoreTransazione == null ? _cast.s1ValoreTransazione != s1ValoreTransazione : !s1ValoreTransazione.equals( _cast.s1ValoreTransazione )) {
			return false;
		}
		
		if (s1TipoIdVersante == null ? _cast.s1TipoIdVersante != s1TipoIdVersante : !s1TipoIdVersante.equals( _cast.s1TipoIdVersante )) {
			return false;
		}
		
		if (s1CodIdVersante == null ? _cast.s1CodIdVersante != s1CodIdVersante : !s1CodIdVersante.equals( _cast.s1CodIdVersante )) {
			return false;
		}
		
		if (s1AnagraficaVersante == null ? _cast.s1AnagraficaVersante != s1AnagraficaVersante : !s1AnagraficaVersante.equals( _cast.s1AnagraficaVersante )) {
			return false;
		}
		
		if (s1IdTransazioneMdp != _cast.s1IdTransazioneMdp) {
			return false;
		}
		
		if (s1DtCreazioneTransazione == null ? _cast.s1DtCreazioneTransazione != s1DtCreazioneTransazione : !s1DtCreazioneTransazione.equals( _cast.s1DtCreazioneTransazione )) {
			return false;
		}
		
		if (s2IdInformativaPsp != _cast.s2IdInformativaPsp) {
			return false;
		}
		
		if (s2IdInformativaPspNull != _cast.s2IdInformativaPspNull) {
			return false;
		}
		
		if (s2IdentificativoPsp == null ? _cast.s2IdentificativoPsp != s2IdentificativoPsp : !s2IdentificativoPsp.equals( _cast.s2IdentificativoPsp )) {
			return false;
		}
		
		if (s2RagSocialePsp == null ? _cast.s2RagSocialePsp != s2RagSocialePsp : !s2RagSocialePsp.equals( _cast.s2RagSocialePsp )) {
			return false;
		}
		
		if (s2DescrServizioPsp == null ? _cast.s2DescrServizioPsp != s2DescrServizioPsp : !s2DescrServizioPsp.equals( _cast.s2DescrServizioPsp )) {
			return false;
		}
		
		if (s3IdIuv != _cast.s3IdIuv) {
			return false;
		}
		
		if (s3DtAvvioTransazione == null ? _cast.s3DtAvvioTransazione != s3DtAvvioTransazione : !s3DtAvvioTransazione.equals( _cast.s3DtAvvioTransazione )) {
			return false;
		}
		
		if (dtChiusuraTransazione == null ? _cast.dtChiusuraTransazione != dtChiusuraTransazione : !dtChiusuraTransazione.equals( _cast.dtChiusuraTransazione )) {
			return false;
		}
		
		if (opGetstatotransFkStato == null ? _cast.opGetstatotransFkStato != opGetstatotransFkStato : !opGetstatotransFkStato.equals( _cast.opGetstatotransFkStato )) {
			return false;
		}
		
		if (opGetstatotransDt == null ? _cast.opGetstatotransDt != opGetstatotransDt : !opGetstatotransDt.equals( _cast.opGetstatotransDt )) {
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
		_hashCode = 29 * _hashCode + (int) (idTransazione2018 ^ (idTransazione2018 >>> 32));
		if (fkCertificatore != null) {
			_hashCode = 29 * _hashCode + fkCertificatore.hashCode();
		}
		
		if (fkStatoTrans2018 != null) {
			_hashCode = 29 * _hashCode + fkStatoTrans2018.hashCode();
		}
		
		if (xmlRt != null) {
			_hashCode = 29 * _hashCode + xmlRt.hashCode();
		}
		
		if (s1ValoreTransazione != null) {
			_hashCode = 29 * _hashCode + s1ValoreTransazione.hashCode();
		}
		
		if (s1TipoIdVersante != null) {
			_hashCode = 29 * _hashCode + s1TipoIdVersante.hashCode();
		}
		
		if (s1CodIdVersante != null) {
			_hashCode = 29 * _hashCode + s1CodIdVersante.hashCode();
		}
		
		if (s1AnagraficaVersante != null) {
			_hashCode = 29 * _hashCode + s1AnagraficaVersante.hashCode();
		}
		
		if (s1IdTransazioneMdp != null) {
			_hashCode = 29 * _hashCode + s1IdTransazioneMdp.hashCode();
		}
		
		if (s1DtCreazioneTransazione != null) {
			_hashCode = 29 * _hashCode + s1DtCreazioneTransazione.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (s2IdInformativaPsp ^ (s2IdInformativaPsp >>> 32));
		_hashCode = 29 * _hashCode + (s2IdInformativaPspNull ? 1 : 0);
		if (s2IdentificativoPsp != null) {
			_hashCode = 29 * _hashCode + s2IdentificativoPsp.hashCode();
		}
		
		if (s2RagSocialePsp != null) {
			_hashCode = 29 * _hashCode + s2RagSocialePsp.hashCode();
		}
		
		if (s2DescrServizioPsp != null) {
			_hashCode = 29 * _hashCode + s2DescrServizioPsp.hashCode();
		}
		
		if (s3IdIuv != null) {
			_hashCode = 29 * _hashCode + s3IdIuv.hashCode();
		}
		
		if (s3DtAvvioTransazione != null) {
			_hashCode = 29 * _hashCode + s3DtAvvioTransazione.hashCode();
		}
		
		if (dtChiusuraTransazione != null) {
			_hashCode = 29 * _hashCode + dtChiusuraTransazione.hashCode();
		}
		
		if (opGetstatotransFkStato != null) {
			_hashCode = 29 * _hashCode + opGetstatotransFkStato.hashCode();
		}
		
		if (opGetstatotransDt != null) {
			_hashCode = 29 * _hashCode + opGetstatotransDt.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTTransazione2018Pk
	 */
	public SiceeTTransazione2018Pk createPk()
	{
		return new SiceeTTransazione2018Pk(idTransazione2018);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018: " );
		ret.append( "idTransazione2018=" + idTransazione2018 );
		ret.append( ", fkCertificatore=" + fkCertificatore );
		ret.append( ", fkStatoTrans2018=" + fkStatoTrans2018 );
		ret.append( ", xmlRt=" + xmlRt );
		ret.append( ", s1ValoreTransazione=" + s1ValoreTransazione );
		ret.append( ", s1TipoIdVersante=" + s1TipoIdVersante );
		ret.append( ", s1CodIdVersante=" + s1CodIdVersante );
		ret.append( ", s1AnagraficaVersante=" + s1AnagraficaVersante );
		ret.append( ", s1IdTransazioneMdp=" + s1IdTransazioneMdp );
		ret.append( ", s1DtCreazioneTransazione=" + s1DtCreazioneTransazione );
		ret.append( ", s2IdInformativaPsp=" + s2IdInformativaPsp );
		ret.append( ", s2IdentificativoPsp=" + s2IdentificativoPsp );
		ret.append( ", s2RagSocialePsp=" + s2RagSocialePsp );
		ret.append( ", s2DescrServizioPsp=" + s2DescrServizioPsp );
		ret.append( ", s3IdIuv=" + s3IdIuv );
		ret.append( ", s3DtAvvioTransazione=" + s3DtAvvioTransazione );
		ret.append( ", dtChiusuraTransazione=" + dtChiusuraTransazione );
		ret.append( ", opGetstatotransFkStato=" + opGetstatotransFkStato );
		ret.append( ", opGetstatotransDt=" + opGetstatotransDt );
		return ret.toString();
	}

}
