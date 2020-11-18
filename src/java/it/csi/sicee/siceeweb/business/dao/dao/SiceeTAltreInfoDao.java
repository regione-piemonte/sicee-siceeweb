/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAltreInfoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTAltreInfoDaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTAltreInfoDao
{
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTAltreInfoPk
	 */
	public SiceeTAltreInfoPk insert(SiceeTAltreInfo dto);

	/**
	 * Updates a single row in the SICEE_T_ALTRE_INFO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public void update(SiceeTAltreInfoPk pk, SiceeTAltreInfo dto) throws SiceeTAltreInfoDaoException;

	/**
	 * Deletes a single row in the SICEE_T_ALTRE_INFO table.
	 *
	 * @param pk the pk
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public void delete(SiceeTAltreInfoPk pk) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t altre info
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public SiceeTAltreInfo findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findAll() throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'PRESTAZIONE_ENE = :prestazioneEne'.
	 *
	 * @param prestazioneEne the prestazione ene
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWherePrestazioneEneEquals(Double prestazioneEne) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereAnnoEquals(String anno) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'LIMITE_NORMA_RISC = :limiteNormaRisc'.
	 *
	 * @param limiteNormaRisc the limite norma risc
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereLimiteNormaRiscEquals(Double limiteNormaRisc) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_CLASSE_192_05 = :fkClasse19205'.
	 *
	 * @param fkClasse19205 the fk classe19205
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereFkClasse19205Equals(Integer fkClasse19205) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_QUALITA_INVO = :fkQualitaInvo'.
	 *
	 * @param fkQualitaInvo the fk qualita invo
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereFkQualitaInvoEquals(Integer fkQualitaInvo) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_MOTIVO = :fkMotivo'.
	 *
	 * @param fkMotivo the fk motivo
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereFkMotivoEquals(Integer fkMotivo) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'LIMITE_NORMA_IMP = :limiteNormaImp'.
	 *
	 * @param limiteNormaImp the limite norma imp
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereLimiteNormaImpEquals(Double limiteNormaImp) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'VALORE_PREST_PDC = :valorePrestPdc'.
	 *
	 * @param valorePrestPdc the valore prest pdc
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereValorePrestPdcEquals(Double valorePrestPdc) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'LIMITE_NORMA_PDC = :limiteNormaPdc'.
	 *
	 * @param limiteNormaPdc the limite norma pdc
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereLimiteNormaPdcEquals(Double limiteNormaPdc) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ULT_INFO = :ultInfo'.
	 *
	 * @param ultInfo the ult info
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereUltInfoEquals(String ultInfo) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'METODOLOGIA_CALCOLO = :metodologiaCalcolo'.
	 *
	 * @param metodologiaCalcolo the metodologia calcolo
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereMetodologiaCalcoloEquals(String metodologiaCalcolo) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NOME_PRODUTTORE = :nomeProduttore'.
	 *
	 * @param nomeProduttore the nome produttore
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereNomeProduttoreEquals(String nomeProduttore) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'SW_UTILIZZATO = :swUtilizzato'.
	 *
	 * @param swUtilizzato the sw utilizzato
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereSwUtilizzatoEquals(String swUtilizzato) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'UNI_TS_11300 = :uniTs11300'.
	 *
	 * @param uniTs11300 the uni ts11300
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereUniTs11300Equals(String uniTs11300) throws SiceeTAltreInfoDaoException;

	/**
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'IND_RISC_EPI_NAZ = :indRiscEpiNaz'.
	 *
	 * @param indRiscEpiNaz the ind risc epi naz
	 * @return the list
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public List<SiceeTAltreInfo> findWhereIndRiscEpiNazEquals(Double indRiscEpiNaz) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NR_CERTIFICATO = :nrCertificato'.
	 */
	public List<SiceeTAltreInfo> findWhereNrCertificatoEquals(String nrCertificato) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_RUOLO_CERT = :fkRuoloCert'.
	 */
	public List<SiceeTAltreInfo> findWhereFkRuoloCertEquals(long fkRuoloCert) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'DICH_INPIPENDENZA = :dichInpipendenza'.
	 */
	public List<SiceeTAltreInfo> findWhereDichInpipendenzaEquals(String dichInpipendenza) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NOTE_SEGNALAZIONI = :noteSegnalazioni'.
	 */
	public List<SiceeTAltreInfo> findWhereNoteSegnalazioniEquals(String noteSegnalazioni) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'INFO_MIGL_PREST_ENERG = :infoMiglPrestEnerg'.
	 */
	public List<SiceeTAltreInfo> findWhereInfoMiglPrestEnergEquals(String infoMiglPrestEnerg) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'DOCUMENTAZIONE = :documentazione'.
	 */
	public List<SiceeTAltreInfo> findWhereDocumentazioneEquals(String documentazione) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FLG_SOPRALLUOGO = :flgSopralluogo'.
	 */
	public List<SiceeTAltreInfo> findWhereFlgSopralluogoEquals(String flgSopralluogo) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'DATA_SOPRALLUOGO = :dataSopralluogo'.
	 */
	public List<SiceeTAltreInfo> findWhereDataSopralluogoEquals(Date dataSopralluogo) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FLG_SW1 = :flgSw1'.
	 */
	public List<SiceeTAltreInfo> findWhereFlgSw1Equals(String flgSw1) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FLG_SW2 = :flgSw2'.
	 */
	public List<SiceeTAltreInfo> findWhereFlgSw2Equals(String flgSw2) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NOTE_SOPRALLUOGO = :noteSopralluogo'.
	 */
	public List<SiceeTAltreInfo> findWhereNoteSopralluogoEquals(String noteSopralluogo) throws SiceeTAltreInfoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'MOTIVO_ALTRO = :motivoAltro'.
	 */
	public List<SiceeTAltreInfo> findWhereMotivoAltroEquals(String motivoAltro) throws SiceeTAltreInfoDaoException;
	
	/** 
	 * Returns the rows from the SICEE_T_ALTRE_INFO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t altre info
	 * @throws SiceeTAltreInfoDaoException the sicee t altre info dao exception
	 */
	public SiceeTAltreInfo findByPrimaryKey(SiceeTAltreInfoPk pk) throws SiceeTAltreInfoDaoException;

}
