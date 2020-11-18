/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocumento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocumentoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoDocumentoDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDTipoDocumentoDao.
 */
public interface SiceeDTipoDocumentoDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDTipoDocumentoPk
	 */
	public SiceeDTipoDocumentoPk insert(SiceeDTipoDocumento dto);

	/**
	 * Updates a single row in the SICEE_D_TIPO_DOCUMENTO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDTipoDocumentoDaoException the sicee d tipo documento dao exception
	 */
	public void update(SiceeDTipoDocumentoPk pk, SiceeDTipoDocumento dto) throws SiceeDTipoDocumentoDaoException;

	/**
	 * Deletes a single row in the SICEE_D_TIPO_DOCUMENTO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDTipoDocumentoDaoException the sicee d tipo documento dao exception
	 */
	public void delete(SiceeDTipoDocumentoPk pk) throws SiceeDTipoDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 *
	 * @param idTipoDoc the id tipo doc
	 * @return the sicee d tipo documento
	 * @throws SiceeDTipoDocumentoDaoException the sicee d tipo documento dao exception
	 */
	public SiceeDTipoDocumento findByPrimaryKey(Integer idTipoDoc) throws SiceeDTipoDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDTipoDocumentoDaoException the sicee d tipo documento dao exception
	 */
	public List<SiceeDTipoDocumento> findAll() throws SiceeDTipoDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 *
	 * @param idTipoDoc the id tipo doc
	 * @return the list
	 * @throws SiceeDTipoDocumentoDaoException the sicee d tipo documento dao exception
	 */
	public List<SiceeDTipoDocumento> findWhereIdTipoDocEquals(Integer idTipoDoc) throws SiceeDTipoDocumentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria 'DS_TIPO_DOC = :dsTipoDoc'.
	 *
	 * @param dsTipoDoc the ds tipo doc
	 * @return the list
	 * @throws SiceeDTipoDocumentoDaoException the sicee d tipo documento dao exception
	 */
	public List<SiceeDTipoDocumento> findWhereDsTipoDocEquals(String dsTipoDoc) throws SiceeDTipoDocumentoDaoException;

	/**
	 * Returns the rows from the SICEE_D_TIPO_DOCUMENTO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d tipo documento
	 * @throws SiceeDTipoDocumentoDaoException the sicee d tipo documento dao exception
	 */
	public SiceeDTipoDocumento findByPrimaryKey(SiceeDTipoDocumentoPk pk) throws SiceeDTipoDocumentoDaoException;

}
