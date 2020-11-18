/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRifIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRifIndex2015DaoException;

import java.util.List;

public interface SiceeTRifIndex2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTRifIndex2015Pk
	 */
	public SiceeTRifIndex2015Pk insert(SiceeTRifIndex2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_RIF_INDEX_2015 table.
	 */
	public void update(SiceeTRifIndex2015Pk pk, SiceeTRifIndex2015 dto) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_RIF_INDEX_2015 table.
	 */
	public void delete(SiceeTRifIndex2015Pk pk) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_RIF_INDEX = :idRifIndex'.
	 */
	public SiceeTRifIndex2015 findByPrimaryKey(long idRifIndex) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTRifIndex2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno' AND 'FK_TIPO_DOC = :fkTipoDoc'.
	 */
	public SiceeTRifIndex2015 findBySiceeTCertificatoidTipoDoc(String idCertificatore, String progrCertificato, String anno, Integer fkTipoDoc) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria ''.
	 */
	public List<SiceeTRifIndex2015> findAll() throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'FK_TIPO_DOC = :fkTipoDoc'.
	 */
	public List<SiceeTRifIndex2015> findBySiceeDTipoDocIndex2015(Integer fkTipoDoc) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTRifIndex2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTRifIndex2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTRifIndex2015> findWhereAnnoEquals(String anno) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'FK_TIPO_DOC = :fkTipoDoc'.
	 */
	public List<SiceeTRifIndex2015> findWhereFkTipoDocEquals(Integer fkTipoDoc) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'NOME_FILE = :nomeFile'.
	 */
	public List<SiceeTRifIndex2015> findWhereNomeFileEquals(String nomeFile) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'UID_INDEX = :uidIndex'.
	 */
	public List<SiceeTRifIndex2015> findWhereUidIndexEquals(String uidIndex) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'HASH = :hash'.
	 */
	public List<SiceeTRifIndex2015> findWhereHashEquals(String hash) throws SiceeTRifIndex2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_RIF_INDEX_2015 table that matches the specified primary-key value.
	 */
	public SiceeTRifIndex2015 findByPrimaryKey(SiceeTRifIndex2015Pk pk) throws SiceeTRifIndex2015DaoException;

}
