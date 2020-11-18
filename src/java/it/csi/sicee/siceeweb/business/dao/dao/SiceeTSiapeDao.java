/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTSiapeDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSiape;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSiapePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTSiapeDaoException;
import java.util.List;

public interface SiceeTSiapeDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTSiapePk
	 */
	public SiceeTSiapePk insert(SiceeTSiape dto);

	/** 
	 * Updates a single row in the SICEE_T_SIAPE table.
	 */
	public void update(SiceeTSiapePk pk, SiceeTSiape dto) throws SiceeTSiapeDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_SIAPE table.
	 */
	public void delete(SiceeTSiapePk pk) throws SiceeTSiapeDaoException;

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND ID_TIPO_AZIONE = :idTipoAzione'.
	 */
	public SiceeTSiape findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, long idTipoAzione) throws SiceeTSiapeDaoException;

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria ''.
	 */
	public List<SiceeTSiape> findAll() throws SiceeTSiapeDaoException;

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTSiape> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTSiapeDaoException;

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTSiape> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTSiapeDaoException;

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTSiape> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTSiapeDaoException;

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTSiape> findWhereAnnoEquals(String anno) throws SiceeTSiapeDaoException;

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_TIPO_AZIONE = :idTipoAzione'.
	 */
	public List<SiceeTSiape> findWhereIdTipoAzioneEquals(long idTipoAzione) throws SiceeTSiapeDaoException;

	/** 
	 * Returns the rows from the SICEE_T_SIAPE table that matches the specified primary-key value.
	 */
	public SiceeTSiape findByPrimaryKey(SiceeTSiapePk pk) throws SiceeTSiapeDaoException;

}
