/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumentoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocumentoDaoException;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTDocumentoDao.
 */
public interface SiceeTDocumentoDao
{
	
	public int createIdDocumento();

	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTDocumentoPk
	 */
	public SiceeTDocumentoPk insert(SiceeTDocumento dto);

	/**
	 * Updates a single row in the SICEE_T_DOCUMENTO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public void update(SiceeTDocumentoPk pk, SiceeTDocumento dto) throws SiceeTDocumentoDaoException;

	/**
	 * Deletes a single row in the SICEE_T_DOCUMENTO table.
	 *
	 * @param pk the pk
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public void delete(SiceeTDocumentoPk pk) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_DOCUMENTO = :idDocumento'.
	 *
	 * @param idDocumento the id documento
	 * @return the sicee t documento
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public SiceeTDocumento findByPrimaryKey(Integer idDocumento) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND ID_TIPO_DOC = :idTipoDoc'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param idTipoDoc the id tipo doc
	 * @return the sicee t documento
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public SiceeTDocumento findWhereIdCertificatoreAndIdTipoDocEquals(String idCertificatore, Integer idTipoDoc) throws SiceeTDocumentoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FK_CORSO = :fkCorso'.
	 */
	
	public SiceeTDocumento findWhereIdCertificatoreAndFkCorsoEquals(String idCertificatore, Integer fkCorso) throws SiceeTDocumentoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FK_CORSO IS NULL AND ID_TIPO_DOC = 6'.
	 */
	
	public List<SiceeTDocumento> findTitoloDiStudio(String idCertificatore) throws SiceeTDocumentoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FK_CORSO IS NULL AND (ID_TIPO_DOC = 2 OR ID_TIPO_DOC = 3 OR ID_TIPO_DOC = 4)'.
	 */
	
	public List<SiceeTDocumento> findAttPartOld(String idCertificatore) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findAll() throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 *
	 * @param idTipoDoc the id tipo doc
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findBySiceeDTipoDocumento(Integer idTipoDoc) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findBySiceeTCertificatore(String idCertificatore) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_DOCUMENTO = :idDocumento'.
	 *
	 * @param idDocumento the id documento
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findWhereIdDocumentoEquals(Integer idDocumento) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 *
	 * @param idTipoDoc the id tipo doc
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findWhereIdTipoDocEquals(Integer idTipoDoc) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'IDENTIFIC_DOC = :identificDoc'.
	 *
	 * @param identificDoc the identific doc
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findWhereIdentificDocEquals(String identificDoc) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'DT_UPLOAD = :dtUpload'.
	 *
	 * @param dtUpload the dt upload
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findWhereDtUploadEquals(Date dtUpload) throws SiceeTDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'NOME_FILE = :nomeFile'.
	 *
	 * @param nomeFile the nome file
	 * @return the list
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public List<SiceeTDocumento> findWhereNomeFileEquals(String nomeFile) throws SiceeTDocumentoDaoException;

	/**
	 * Returns the rows from the SICEE_T_DOCUMENTO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t documento
	 * @throws SiceeTDocumentoDaoException the sicee t documento dao exception
	 */
	public SiceeTDocumento findByPrimaryKey(SiceeTDocumentoPk pk) throws SiceeTDocumentoDaoException;

}
