/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImportDatiLog2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDatiLog2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDatiLog2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImportDatiLog2015DaoException;
import java.util.Date;
import java.util.List;

public interface SiceeTImportDatiLog2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTImportDatiLog2015Pk
	 */
	public SiceeTImportDatiLog2015Pk insert(SiceeTImportDatiLog2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	public void update(SiceeTImportDatiLog2015Pk pk, SiceeTImportDatiLog2015 dto) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	public void delete(SiceeTImportDatiLog2015Pk pk) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND TIMESTAMP = :timestamp'.
	 */
	public SiceeTImportDatiLog2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Date timestamp) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria ''.
	 */
	public List<SiceeTImportDatiLog2015> findAll() throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTImportDatiLog2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereAnnoEquals(String anno) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'TIMESTAMP = :timestamp'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereTimestampEquals(Date timestamp) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'PASSO_VALIDAZIONE = :passoValidazione'.
	 */
	public List<SiceeTImportDatiLog2015> findWherePassoValidazioneEquals(Integer passoValidazione) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'MESSAGGIO_ERRORE = :messaggioErrore'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereMessaggioErroreEquals(String messaggioErrore) throws SiceeTImportDatiLog2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that matches the specified primary-key value.
	 */
	public SiceeTImportDatiLog2015 findByPrimaryKey(SiceeTImportDatiLog2015Pk pk) throws SiceeTImportDatiLog2015DaoException;

}
