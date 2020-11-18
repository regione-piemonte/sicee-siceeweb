/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazione2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazione2018DaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTTransazione2018Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTTransazione2018Pk
	 */
	public SiceeTTransazione2018Pk insert(SiceeTTransazione2018 dto);

	/** 
	 * Updates a single row in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	public void update(SiceeTTransazione2018Pk pk, SiceeTTransazione2018 dto) throws SiceeTTransazione2018DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	public void delete(SiceeTTransazione2018Pk pk) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_TRANSAZIONE_2018 = :idTransazione2018'.
	 */
	public SiceeTTransazione2018 findByPrimaryKey(long idTransazione2018) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'VALORE_TRANSAZIONE = :valoreTransazione'.
	 */
	public List<SiceeTTransazione2018> findWhereValoreTransazioneEquals(long valoreTransazione) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'XML_RPT = :xmlRpt'.
	 */
	public List<SiceeTTransazione2018> findWhereXmlRptEquals(String xmlRpt) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'DATA_RPT = :dataRpt'.
	 */
	public List<SiceeTTransazione2018> findWhereDataRptEquals(Date dataRpt) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'DATA_RT = :dataRt'.
	 */
	public List<SiceeTTransazione2018> findWhereDataRtEquals(Date dataRt) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_TRANSAZIONE_MDP = :idTransazioneMdp'.
	 */
	public List<SiceeTTransazione2018> findWhereIdTransazioneMdpEquals(String idTransazioneMdp) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_IUV = :idIuv'.
	 */
	public List<SiceeTTransazione2018> findWhereIdIuvEquals(String idIuv) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria ''.
	 */
	public List<SiceeTTransazione2018> findAll() throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'OP_GETSTATOTRANS_FK_STATO = :opGetstatotransFkStato'.
	 */
	public List<SiceeTTransazione2018> findBySiceeDStatoTransMdp2018(Integer opGetstatotransFkStato) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_STATO_TRANS_2018 = :fkStatoTrans2018'.
	 */
	public List<SiceeTTransazione2018> findBySiceeDStatoTrans2018(Integer fkStatoTrans2018) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_TRANSAZIONE_2018 = :idTransazione2018'.
	 */
	public List<SiceeTTransazione2018> findWhereIdTransazione2018Equals(long idTransazione2018) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	public List<SiceeTTransazione2018> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore' and 'FK_STATO_TRANS_2018 = :fkStatoTrans2018'.
	 */
	public List<SiceeTTransazione2018> findWhereFkCertificatoreAndStatoEquals(String fkCertificatore, Integer fkStatoTrans2018) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_STATO_TRANS_2018 = :fkStatoTrans2018'.
	 */
	public List<SiceeTTransazione2018> findWhereFkStatoTrans2018Equals(Integer fkStatoTrans2018) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_VALORE_TRANSAZIONE = :s1ValoreTransazione'.
	 */
	public List<SiceeTTransazione2018> findWhereS1ValoreTransazioneEquals(Double s1ValoreTransazione) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_TIPO_ID_VERSANTE = :s1TipoidVersante'.
	 */
	public List<SiceeTTransazione2018> findWhereS1TipoIdVersanteEquals(String s1TipoIdVersante) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_COD_ID_VERSANTE = :s1CodIdVersante'.
	 */
	public List<SiceeTTransazione2018> findWhereS1CodIdVersanteEquals(String s1CodIdVersante) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_ANAGRAFICA_VERSANTE = :s1AnagraficaVersante'.
	 */
	public List<SiceeTTransazione2018> findWhereS1AnagraficaVersanteEquals(String s1AnagraficaVersante) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_ID_TRANSAZIONE_MDP = :s1IdTransazioneMdp'.
	 */
	public List<SiceeTTransazione2018> findWhereS1IdTransazioneMdpEquals(String s1IdTransazioneMdp) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_DT_CREAZIONE_TRANSAZIONE = :s1DtCreazioneTransazione'.
	 */
	public List<SiceeTTransazione2018> findWhereS1DtCreazioneTransazioneEquals(Date s1DtCreazioneTransazione) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_ID_INFORMATIVA_PSP = :s2IdInformativaPsp'.
	 */
	public List<SiceeTTransazione2018> findWhereS2IdInformativaPspEquals(long s2IdInformativaPsp) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_IDENTIFICATIVO_PSP = :s2IdentificativoPsp'.
	 */
	public List<SiceeTTransazione2018> findWhereS2IdentificativoPspEquals(String s2IdentificativoPsp) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_RAG_SOCIALE_PSP = :s2RagSocialePsp'.
	 */
	public List<SiceeTTransazione2018> findWhereS2RagSocialePspEquals(String s2RagSocialePsp) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_DESCR_SERVIZIO_PSP = :s2DescrServizioPsp'.
	 */
	public List<SiceeTTransazione2018> findWhereS2DescrServizioPspEquals(String s2DescrServizioPsp) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S3_ID_IUV = :s3IdIuv'.
	 */
	public List<SiceeTTransazione2018> findWhereS3IdIuvEquals(String s3IdIuv) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S3_DT_AVVIO_TRANSAZIONE = :s3DtAvvioTransazione'.
	 */
	public List<SiceeTTransazione2018> findWhereS3DtAvvioTransazioneEquals(Date s3DtAvvioTransazione) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'DT_CHIUSURA_TRANSAZIONE = :dtChiusuraTransazione'.
	 */
	public List<SiceeTTransazione2018> findWhereDtChiusuraTransazioneEquals(Date dtChiusuraTransazione) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'XML_RT = :xmlRt'.
	 */
	public List<SiceeTTransazione2018> findWhereXmlRtEquals(String xmlRt) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'OP_GETSTATOTRANS_FK_STATO = :opGetstatotransFkStato'.
	 */
	public List<SiceeTTransazione2018> findWhereOpGetstatotransFkStatoEquals(Integer opGetstatotransFkStato) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'OP_GETSTATOTRANS_DT = :opGetstatotransDt'.
	 */
	public List<SiceeTTransazione2018> findWhereOpGetstatotransDtEquals(Date opGetstatotransDt) throws SiceeTTransazione2018DaoException;

	/** 
	 * Returns the rows from the SICEE_T_TRANSAZIONE_2018 table that matches the specified primary-key value.
	 */
	public SiceeTTransazione2018 findByPrimaryKey(SiceeTTransazione2018Pk pk) throws SiceeTTransazione2018DaoException;

}
