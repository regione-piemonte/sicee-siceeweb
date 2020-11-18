/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImportDati2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImportDati2015DaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTImportDati2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTImportDati2015Pk
	 */
	public SiceeTImportDati2015Pk insert(SiceeTImportDati2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	public void update(SiceeTImportDati2015Pk pk, SiceeTImportDati2015 dto) throws SiceeTImportDati2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	public void delete(SiceeTImportDati2015Pk pk) throws SiceeTImportDati2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDati2015DaoException;

	/** 
	 * Delete all rows in the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'UID_INDEX = :uidIndex.
	 */
	public void deleteByUidIndex(String uidIndex) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTImportDati2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria ''.
	 */
	public List<SiceeTImportDati2015> findAll() throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTImportDati2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTImportDati2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTImportDati2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTImportDati2015> findWhereAnnoEquals(String anno) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'NOME_XML = :nomeXml'.
	 */
	public List<SiceeTImportDati2015> findWhereNomeXmlEquals(String nomeXml) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'UID_INDEX = :uidIndex'.
	 */
	public List<SiceeTImportDati2015> findWhereUidIndexEquals(String uidIndex) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'DT_CARICAMENTO = :dtCaricamento'.
	 */
	public List<SiceeTImportDati2015> findWhereDtCaricamentoEquals(Date dtCaricamento) throws SiceeTImportDati2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_IMPORT_DATI_2015 table that matches the specified primary-key value.
	 */
	public SiceeTImportDati2015 findByPrimaryKey(SiceeTImportDati2015Pk pk) throws SiceeTImportDati2015DaoException;

}
