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

public class SiceeTAltreInfo implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_ALTRE_INFO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PRESTAZIONE_ENE in the SICEE_T_ALTRE_INFO table.
	 */
	protected Double prestazioneEne;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column LIMITE_NORMA_RISC in the SICEE_T_ALTRE_INFO table.
	 */
	protected Double limiteNormaRisc;

	/** 
	 * This attribute maps to the column FK_CLASSE_192_05 in the SICEE_T_ALTRE_INFO table.
	 */
	protected Integer fkClasse19205;

	/** 
	 * This attribute maps to the column FK_QUALITA_INVO in the SICEE_T_ALTRE_INFO table.
	 */
	protected Integer fkQualitaInvo;

	/** 
	 * This attribute maps to the column FK_MOTIVO in the SICEE_T_ALTRE_INFO table.
	 */
	protected Integer fkMotivo;

	/** 
	 * This attribute maps to the column LIMITE_NORMA_IMP in the SICEE_T_ALTRE_INFO table.
	 */
	protected Double limiteNormaImp;

	/** 
	 * This attribute maps to the column VALORE_PREST_PDC in the SICEE_T_ALTRE_INFO table.
	 */
	protected Double valorePrestPdc;

	/** 
	 * This attribute maps to the column LIMITE_NORMA_PDC in the SICEE_T_ALTRE_INFO table.
	 */
	protected Double limiteNormaPdc;

	/** 
	 * This attribute maps to the column ULT_INFO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String ultInfo;

	/** 
	 * This attribute maps to the column METODOLOGIA_CALCOLO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String metodologiaCalcolo;

	/** 
	 * This attribute maps to the column NOME_PRODUTTORE in the SICEE_T_ALTRE_INFO table.
	 */
	protected String nomeProduttore;

	/** 
	 * This attribute maps to the column SW_UTILIZZATO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String swUtilizzato;

	/** 
	 * This attribute maps to the column UNI_TS_11300 in the SICEE_T_ALTRE_INFO table.
	 */
	protected String uniTs11300;

	/** 
	 * This attribute maps to the column IND_RISC_EPI_NAZ in the SICEE_T_ALTRE_INFO table.
	 */
	protected Double indRiscEpiNaz;

	/** 
	 * This attribute maps to the column NR_CERTIFICATO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String nrCertificato;

	/** 
	 * This attribute maps to the column FK_RUOLO_CERT in the SICEE_T_ALTRE_INFO table.
	 */
	protected Integer fkRuoloCert;

	/** 
	 * This attribute represents whether the primitive attribute fkRuoloCert is null.
	 */
	protected boolean fkRuoloCertNull = true;

	/** 
	 * This attribute maps to the column DICH_INPIPENDENZA in the SICEE_T_ALTRE_INFO table.
	 */
	protected String dichInpipendenza;

	/** 
	 * This attribute maps to the column NOTE_SEGNALAZIONI in the SICEE_T_ALTRE_INFO table.
	 */
	protected String noteSegnalazioni;

	/** 
	 * This attribute maps to the column INFO_MIGL_PREST_ENERG in the SICEE_T_ALTRE_INFO table.
	 */
	protected String infoMiglPrestEnerg;

	/** 
	 * This attribute maps to the column DOCUMENTAZIONE in the SICEE_T_ALTRE_INFO table.
	 */
	protected String documentazione;

	/** 
	 * This attribute maps to the column FLG_SOPRALLUOGO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String flgSopralluogo;

	/** 
	 * This attribute maps to the column DATA_SOPRALLUOGO in the SICEE_T_ALTRE_INFO table.
	 */
	protected Date dataSopralluogo;

	/** 
	 * This attribute maps to the column FLG_SW1 in the SICEE_T_ALTRE_INFO table.
	 */
	protected String flgSw1;

	/** 
	 * This attribute maps to the column FLG_SW2 in the SICEE_T_ALTRE_INFO table.
	 */
	protected String flgSw2;

	/** 
	 * This attribute maps to the column NOTE_SOPRALLUOGO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String noteSopralluogo;

	/** 
	 * This attribute maps to the column MOTIVO_ALTRO in the SICEE_T_ALTRE_INFO table.
	 */
	protected String motivoAltro;

	/** 
	 * This attribute maps to the column STIPULA_CONTRATTO in the SICEE_T_ALTRE_INFO table.
	 */
	//protected String stipulaContratto;

	/** 
	 * This attribute maps to the column ALTRO_SERVIZI_ENERGIA in the SICEE_T_ALTRE_INFO table.
	 */
	protected Integer altroServiziEnergia;

	/**
	 * Method 'SiceeTAltreInfo'
	 * 
	 */
	public SiceeTAltreInfo()
	{
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
	 * Method 'getPrestazioneEne'
	 * 
	 * @return Double
	 */
	public Double getPrestazioneEne()
	{
		return prestazioneEne;
	}

	/**
	 * Method 'setPrestazioneEne'
	 * 
	 * @param prestazioneEne
	 */
	public void setPrestazioneEne(Double prestazioneEne)
	{
		this.prestazioneEne = prestazioneEne;
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
	 * Method 'getLimiteNormaRisc'
	 * 
	 * @return Double
	 */
	public Double getLimiteNormaRisc()
	{
		return limiteNormaRisc;
	}

	/**
	 * Method 'setLimiteNormaRisc'
	 * 
	 * @param limiteNormaRisc
	 */
	public void setLimiteNormaRisc(Double limiteNormaRisc)
	{
		this.limiteNormaRisc = limiteNormaRisc;
	}

	/**
	 * Method 'getFkClasse19205'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasse19205()
	{
		return fkClasse19205;
	}

	/**
	 * Method 'setFkClasse19205'
	 * 
	 * @param fkClasse19205
	 */
	public void setFkClasse19205(Integer fkClasse19205)
	{
		this.fkClasse19205 = fkClasse19205;
	}

	/**
	 * Method 'getFkQualitaInvo'
	 * 
	 * @return Integer
	 */
	public Integer getFkQualitaInvo()
	{
		return fkQualitaInvo;
	}

	/**
	 * Method 'setFkQualitaInvo'
	 * 
	 * @param fkQualitaInvo
	 */
	public void setFkQualitaInvo(Integer fkQualitaInvo)
	{
		this.fkQualitaInvo = fkQualitaInvo;
	}

	/**
	 * Method 'getFkMotivo'
	 * 
	 * @return Integer
	 */
	public Integer getFkMotivo()
	{
		return fkMotivo;
	}

	/**
	 * Method 'setFkMotivo'
	 * 
	 * @param fkMotivo
	 */
	public void setFkMotivo(Integer fkMotivo)
	{
		this.fkMotivo = fkMotivo;
	}

	/**
	 * Method 'getLimiteNormaImp'
	 * 
	 * @return Double
	 */
	public Double getLimiteNormaImp()
	{
		return limiteNormaImp;
	}

	/**
	 * Method 'setLimiteNormaImp'
	 * 
	 * @param limiteNormaImp
	 */
	public void setLimiteNormaImp(Double limiteNormaImp)
	{
		this.limiteNormaImp = limiteNormaImp;
	}

	/**
	 * Method 'getValorePrestPdc'
	 * 
	 * @return Double
	 */
	public Double getValorePrestPdc()
	{
		return valorePrestPdc;
	}

	/**
	 * Method 'setValorePrestPdc'
	 * 
	 * @param valorePrestPdc
	 */
	public void setValorePrestPdc(Double valorePrestPdc)
	{
		this.valorePrestPdc = valorePrestPdc;
	}

	/**
	 * Method 'getLimiteNormaPdc'
	 * 
	 * @return Double
	 */
	public Double getLimiteNormaPdc()
	{
		return limiteNormaPdc;
	}

	/**
	 * Method 'setLimiteNormaPdc'
	 * 
	 * @param limiteNormaPdc
	 */
	public void setLimiteNormaPdc(Double limiteNormaPdc)
	{
		this.limiteNormaPdc = limiteNormaPdc;
	}

	/**
	 * Method 'getUltInfo'
	 * 
	 * @return String
	 */
	public String getUltInfo()
	{
		return ultInfo;
	}

	/**
	 * Method 'setUltInfo'
	 * 
	 * @param ultInfo
	 */
	public void setUltInfo(String ultInfo)
	{
		this.ultInfo = ultInfo;
	}

	/**
	 * Method 'getMetodologiaCalcolo'
	 * 
	 * @return String
	 */
	public String getMetodologiaCalcolo()
	{
		return metodologiaCalcolo;
	}

	/**
	 * Method 'setMetodologiaCalcolo'
	 * 
	 * @param metodologiaCalcolo
	 */
	public void setMetodologiaCalcolo(String metodologiaCalcolo)
	{
		this.metodologiaCalcolo = metodologiaCalcolo;
	}

	/**
	 * Method 'getNomeProduttore'
	 * 
	 * @return String
	 */
	public String getNomeProduttore()
	{
		return nomeProduttore;
	}

	/**
	 * Method 'setNomeProduttore'
	 * 
	 * @param nomeProduttore
	 */
	public void setNomeProduttore(String nomeProduttore)
	{
		this.nomeProduttore = nomeProduttore;
	}

	/**
	 * Method 'getSwUtilizzato'
	 * 
	 * @return String
	 */
	public String getSwUtilizzato()
	{
		return swUtilizzato;
	}

	/**
	 * Method 'setSwUtilizzato'
	 * 
	 * @param swUtilizzato
	 */
	public void setSwUtilizzato(String swUtilizzato)
	{
		this.swUtilizzato = swUtilizzato;
	}

	/**
	 * Method 'getUniTs11300'
	 * 
	 * @return String
	 */
	public String getUniTs11300()
	{
		return uniTs11300;
	}

	/**
	 * Method 'setUniTs11300'
	 * 
	 * @param uniTs11300
	 */
	public void setUniTs11300(String uniTs11300)
	{
		this.uniTs11300 = uniTs11300;
	}

	/**
	 * Method 'getIndRiscEpiNaz'
	 * 
	 * @return Double
	 */
	public Double getIndRiscEpiNaz()
	{
		return indRiscEpiNaz;
	}

	/**
	 * Method 'setIndRiscEpiNaz'
	 * 
	 * @param indRiscEpiNaz
	 */
	public void setIndRiscEpiNaz(Double indRiscEpiNaz)
	{
		this.indRiscEpiNaz = indRiscEpiNaz;
	}

	/**
	 * Method 'getNrCertificato'
	 * 
	 * @return String
	 */
	public String getNrCertificato()
	{
		return nrCertificato;
	}

	/**
	 * Method 'setNrCertificato'
	 * 
	 * @param nrCertificato
	 */
	public void setNrCertificato(String nrCertificato)
	{
		this.nrCertificato = nrCertificato;
	}

	/**
	 * Method 'getFkRuoloCert'
	 * 
	 * @return 
	 */
	public Integer getFkRuoloCert()
	{
		return fkRuoloCert;
	}

	/**
	 * Method 'setFkRuoloCert'
	 * 
	 * @param fkRuoloCert
	 */
	public void setFkRuoloCert(Integer fkRuoloCert)
	{
		this.fkRuoloCert = fkRuoloCert;
		this.fkRuoloCertNull = false;
	}

	/**
	 * Method 'setFkRuoloCertNull'
	 * 
	 * @param value
	 */
	public void setFkRuoloCertNull(boolean value)
	{
		this.fkRuoloCertNull = value;
	}

	/**
	 * Method 'isFkRuoloCertNull'
	 * 
	 * @return boolean
	 */
	public boolean isFkRuoloCertNull()
	{
		return fkRuoloCertNull;
	}

	/**
	 * Method 'getDichInpipendenza'
	 * 
	 * @return String
	 */
	public String getDichInpipendenza()
	{
		return dichInpipendenza;
	}

	/**
	 * Method 'setDichInpipendenza'
	 * 
	 * @param dichInpipendenza
	 */
	public void setDichInpipendenza(String dichInpipendenza)
	{
		this.dichInpipendenza = dichInpipendenza;
	}

	/**
	 * Method 'getNoteSegnalazioni'
	 * 
	 * @return String
	 */
	public String getNoteSegnalazioni()
	{
		return noteSegnalazioni;
	}

	/**
	 * Method 'setNoteSegnalazioni'
	 * 
	 * @param noteSegnalazioni
	 */
	public void setNoteSegnalazioni(String noteSegnalazioni)
	{
		this.noteSegnalazioni = noteSegnalazioni;
	}

	/**
	 * Method 'getInfoMiglPrestEnerg'
	 * 
	 * @return String
	 */
	public String getInfoMiglPrestEnerg()
	{
		return infoMiglPrestEnerg;
	}

	/**
	 * Method 'setInfoMiglPrestEnerg'
	 * 
	 * @param infoMiglPrestEnerg
	 */
	public void setInfoMiglPrestEnerg(String infoMiglPrestEnerg)
	{
		this.infoMiglPrestEnerg = infoMiglPrestEnerg;
	}

	/**
	 * Method 'getDocumentazione'
	 * 
	 * @return String
	 */
	public String getDocumentazione()
	{
		return documentazione;
	}

	/**
	 * Method 'setDocumentazione'
	 * 
	 * @param documentazione
	 */
	public void setDocumentazione(String documentazione)
	{
		this.documentazione = documentazione;
	}

	/**
	 * Method 'getFlgSopralluogo'
	 * 
	 * @return String
	 */
	public String getFlgSopralluogo()
	{
		return flgSopralluogo;
	}

	/**
	 * Method 'setFlgSopralluogo'
	 * 
	 * @param flgSopralluogo
	 */
	public void setFlgSopralluogo(String flgSopralluogo)
	{
		this.flgSopralluogo = flgSopralluogo;
	}

	/**
	 * Method 'getDataSopralluogo'
	 * 
	 * @return Date
	 */
	public Date getDataSopralluogo()
	{
		return dataSopralluogo;
	}

	/**
	 * Method 'setDataSopralluogo'
	 * 
	 * @param dataSopralluogo
	 */
	public void setDataSopralluogo(Date dataSopralluogo)
	{
		this.dataSopralluogo = dataSopralluogo;
	}

	/**
	 * Method 'getFlgSw1'
	 * 
	 * @return String
	 */
	public String getFlgSw1()
	{
		return flgSw1;
	}

	/**
	 * Method 'setFlgSw1'
	 * 
	 * @param flgSw1
	 */
	public void setFlgSw1(String flgSw1)
	{
		this.flgSw1 = flgSw1;
	}

	/**
	 * Method 'getFlgSw2'
	 * 
	 * @return String
	 */
	public String getFlgSw2()
	{
		return flgSw2;
	}

	/**
	 * Method 'setFlgSw2'
	 * 
	 * @param flgSw2
	 */
	public void setFlgSw2(String flgSw2)
	{
		this.flgSw2 = flgSw2;
	}

	/**
	 * Method 'getNoteSopralluogo'
	 * 
	 * @return String
	 */
	public String getNoteSopralluogo()
	{
		return noteSopralluogo;
	}

	/**
	 * Method 'setNoteSopralluogo'
	 * 
	 * @param noteSopralluogo
	 */
	public void setNoteSopralluogo(String noteSopralluogo)
	{
		this.noteSopralluogo = noteSopralluogo;
	}

	/**
	 * Method 'getMotivoAltro'
	 * 
	 * @return String
	 */
	public String getMotivoAltro()
	{
		return motivoAltro;
	}

	/**
	 * Method 'setMotivoAltro'
	 * 
	 * @param motivoAltro
	 */
	public void setMotivoAltro(String motivoAltro)
	{
		this.motivoAltro = motivoAltro;
	}


	/**
	 * Method 'getAltroServiziEnergia'
	 * 
	 * @return Integer
	 */
	public Integer getAltroServiziEnergia()
	{
		return altroServiziEnergia;
	}

	/**
	 * Method 'setAltroServiziEnergia'
	 * 
	 * @param altroServiziEnergia
	 */
	public void setAltroServiziEnergia(Integer altroServiziEnergia)
	{
		this.altroServiziEnergia = altroServiziEnergia;
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
		
		if (!(_other instanceof SiceeTAltreInfo)) {
			return false;
		}
		
		final SiceeTAltreInfo _cast = (SiceeTAltreInfo) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (prestazioneEne == null ? _cast.prestazioneEne != prestazioneEne : !prestazioneEne.equals( _cast.prestazioneEne )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (limiteNormaRisc == null ? _cast.limiteNormaRisc != limiteNormaRisc : !limiteNormaRisc.equals( _cast.limiteNormaRisc )) {
			return false;
		}
		
		if (fkClasse19205 == null ? _cast.fkClasse19205 != fkClasse19205 : !fkClasse19205.equals( _cast.fkClasse19205 )) {
			return false;
		}
		
		if (fkQualitaInvo == null ? _cast.fkQualitaInvo != fkQualitaInvo : !fkQualitaInvo.equals( _cast.fkQualitaInvo )) {
			return false;
		}
		
		if (fkMotivo == null ? _cast.fkMotivo != fkMotivo : !fkMotivo.equals( _cast.fkMotivo )) {
			return false;
		}
		
		if (limiteNormaImp == null ? _cast.limiteNormaImp != limiteNormaImp : !limiteNormaImp.equals( _cast.limiteNormaImp )) {
			return false;
		}
		
		if (valorePrestPdc == null ? _cast.valorePrestPdc != valorePrestPdc : !valorePrestPdc.equals( _cast.valorePrestPdc )) {
			return false;
		}
		
		if (limiteNormaPdc == null ? _cast.limiteNormaPdc != limiteNormaPdc : !limiteNormaPdc.equals( _cast.limiteNormaPdc )) {
			return false;
		}
		
		if (ultInfo == null ? _cast.ultInfo != ultInfo : !ultInfo.equals( _cast.ultInfo )) {
			return false;
		}
		
		if (metodologiaCalcolo == null ? _cast.metodologiaCalcolo != metodologiaCalcolo : !metodologiaCalcolo.equals( _cast.metodologiaCalcolo )) {
			return false;
		}
		
		if (nomeProduttore == null ? _cast.nomeProduttore != nomeProduttore : !nomeProduttore.equals( _cast.nomeProduttore )) {
			return false;
		}
		
		if (swUtilizzato == null ? _cast.swUtilizzato != swUtilizzato : !swUtilizzato.equals( _cast.swUtilizzato )) {
			return false;
		}
		
		if (uniTs11300 == null ? _cast.uniTs11300 != uniTs11300 : !uniTs11300.equals( _cast.uniTs11300 )) {
			return false;
		}
		
		if (indRiscEpiNaz == null ? _cast.indRiscEpiNaz != indRiscEpiNaz : !indRiscEpiNaz.equals( _cast.indRiscEpiNaz )) {
			return false;
		}
		
		if (nrCertificato == null ? _cast.nrCertificato != nrCertificato : !nrCertificato.equals( _cast.nrCertificato )) {
			return false;
		}
		
		if (fkRuoloCert != _cast.fkRuoloCert) {
			return false;
		}
		
		if (fkRuoloCertNull != _cast.fkRuoloCertNull) {
			return false;
		}
		
		if (dichInpipendenza == null ? _cast.dichInpipendenza != dichInpipendenza : !dichInpipendenza.equals( _cast.dichInpipendenza )) {
			return false;
		}
		
		if (noteSegnalazioni == null ? _cast.noteSegnalazioni != noteSegnalazioni : !noteSegnalazioni.equals( _cast.noteSegnalazioni )) {
			return false;
		}
		
		if (infoMiglPrestEnerg == null ? _cast.infoMiglPrestEnerg != infoMiglPrestEnerg : !infoMiglPrestEnerg.equals( _cast.infoMiglPrestEnerg )) {
			return false;
		}
		
		if (documentazione == null ? _cast.documentazione != documentazione : !documentazione.equals( _cast.documentazione )) {
			return false;
		}
		
		if (flgSopralluogo == null ? _cast.flgSopralluogo != flgSopralluogo : !flgSopralluogo.equals( _cast.flgSopralluogo )) {
			return false;
		}
		
		if (dataSopralluogo == null ? _cast.dataSopralluogo != dataSopralluogo : !dataSopralluogo.equals( _cast.dataSopralluogo )) {
			return false;
		}
		
		if (flgSw1 == null ? _cast.flgSw1 != flgSw1 : !flgSw1.equals( _cast.flgSw1 )) {
			return false;
		}
		
		if (flgSw2 == null ? _cast.flgSw2 != flgSw2 : !flgSw2.equals( _cast.flgSw2 )) {
			return false;
		}
		
		if (noteSopralluogo == null ? _cast.noteSopralluogo != noteSopralluogo : !noteSopralluogo.equals( _cast.noteSopralluogo )) {
			return false;
		}
		
		if (motivoAltro == null ? _cast.motivoAltro != motivoAltro : !motivoAltro.equals( _cast.motivoAltro )) {
			return false;
		}
				
		if (altroServiziEnergia == null ? _cast.altroServiziEnergia != altroServiziEnergia : !altroServiziEnergia.equals( _cast.altroServiziEnergia )) {
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
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (prestazioneEne != null) {
			_hashCode = 29 * _hashCode + prestazioneEne.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (limiteNormaRisc != null) {
			_hashCode = 29 * _hashCode + limiteNormaRisc.hashCode();
		}
		
		if (fkClasse19205 != null) {
			_hashCode = 29 * _hashCode + fkClasse19205.hashCode();
		}
		
		if (fkQualitaInvo != null) {
			_hashCode = 29 * _hashCode + fkQualitaInvo.hashCode();
		}
		
		if (fkMotivo != null) {
			_hashCode = 29 * _hashCode + fkMotivo.hashCode();
		}
		
		if (limiteNormaImp != null) {
			_hashCode = 29 * _hashCode + limiteNormaImp.hashCode();
		}
		
		if (valorePrestPdc != null) {
			_hashCode = 29 * _hashCode + valorePrestPdc.hashCode();
		}
		
		if (limiteNormaPdc != null) {
			_hashCode = 29 * _hashCode + limiteNormaPdc.hashCode();
		}
		
		if (ultInfo != null) {
			_hashCode = 29 * _hashCode + ultInfo.hashCode();
		}
		
		if (metodologiaCalcolo != null) {
			_hashCode = 29 * _hashCode + metodologiaCalcolo.hashCode();
		}
		
		if (nomeProduttore != null) {
			_hashCode = 29 * _hashCode + nomeProduttore.hashCode();
		}
		
		if (swUtilizzato != null) {
			_hashCode = 29 * _hashCode + swUtilizzato.hashCode();
		}
		
		if (uniTs11300 != null) {
			_hashCode = 29 * _hashCode + uniTs11300.hashCode();
		}
		
		if (indRiscEpiNaz != null) {
			_hashCode = 29 * _hashCode + indRiscEpiNaz.hashCode();
		}
		
		if (nrCertificato != null) {
			_hashCode = 29 * _hashCode + nrCertificato.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (fkRuoloCert ^ (fkRuoloCert >>> 32));
		_hashCode = 29 * _hashCode + (fkRuoloCertNull ? 1 : 0);
		if (dichInpipendenza != null) {
			_hashCode = 29 * _hashCode + dichInpipendenza.hashCode();
		}
		
		if (noteSegnalazioni != null) {
			_hashCode = 29 * _hashCode + noteSegnalazioni.hashCode();
		}
		
		if (infoMiglPrestEnerg != null) {
			_hashCode = 29 * _hashCode + infoMiglPrestEnerg.hashCode();
		}
		
		if (documentazione != null) {
			_hashCode = 29 * _hashCode + documentazione.hashCode();
		}
		
		if (flgSopralluogo != null) {
			_hashCode = 29 * _hashCode + flgSopralluogo.hashCode();
		}
		
		if (dataSopralluogo != null) {
			_hashCode = 29 * _hashCode + dataSopralluogo.hashCode();
		}
		
		if (flgSw1 != null) {
			_hashCode = 29 * _hashCode + flgSw1.hashCode();
		}
		
		if (flgSw2 != null) {
			_hashCode = 29 * _hashCode + flgSw2.hashCode();
		}
		
		if (noteSopralluogo != null) {
			_hashCode = 29 * _hashCode + noteSopralluogo.hashCode();
		}
		
		if (motivoAltro != null) {
			_hashCode = 29 * _hashCode + motivoAltro.hashCode();
		}
								
		if (altroServiziEnergia != null) {
			_hashCode = 29 * _hashCode + altroServiziEnergia.hashCode();
		}
				
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTAltreInfoPk
	 */
	public SiceeTAltreInfoPk createPk()
	{
		return new SiceeTAltreInfoPk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", prestazioneEne=" + prestazioneEne );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", limiteNormaRisc=" + limiteNormaRisc );
		ret.append( ", fkClasse19205=" + fkClasse19205 );
		ret.append( ", fkQualitaInvo=" + fkQualitaInvo );
		ret.append( ", fkMotivo=" + fkMotivo );
		ret.append( ", limiteNormaImp=" + limiteNormaImp );
		ret.append( ", valorePrestPdc=" + valorePrestPdc );
		ret.append( ", limiteNormaPdc=" + limiteNormaPdc );
		ret.append( ", ultInfo=" + ultInfo );
		ret.append( ", metodologiaCalcolo=" + metodologiaCalcolo );
		ret.append( ", nomeProduttore=" + nomeProduttore );
		ret.append( ", swUtilizzato=" + swUtilizzato );
		ret.append( ", uniTs11300=" + uniTs11300 );
		ret.append( ", indRiscEpiNaz=" + indRiscEpiNaz );
		ret.append( ", nrCertificato=" + nrCertificato );
		ret.append( ", fkRuoloCert=" + fkRuoloCert );
		ret.append( ", dichInpipendenza=" + dichInpipendenza );
		ret.append( ", noteSegnalazioni=" + noteSegnalazioni );
		ret.append( ", infoMiglPrestEnerg=" + infoMiglPrestEnerg );
		ret.append( ", documentazione=" + documentazione );
		ret.append( ", flgSopralluogo=" + flgSopralluogo );
		ret.append( ", dataSopralluogo=" + dataSopralluogo );
		ret.append( ", flgSw1=" + flgSw1 );
		ret.append( ", flgSw2=" + flgSw2 );
		ret.append( ", noteSopralluogo=" + noteSopralluogo );
		ret.append( ", motivoAltro=" + motivoAltro );
		ret.append( ", altroServiziEnergia=" + altroServiziEnergia );
		return ret.toString();
	}

}
