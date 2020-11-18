/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoIstruzioneDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoIstruzioneDaoException;
import java.util.List;

public interface SiceeDTipoIstruzioneDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipoIstruzionePk
	 */
	public SiceeDTipoIstruzionePk insert(SiceeDTipoIstruzione dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPO_ISTRUZIONE table.
	 */
	public void update(SiceeDTipoIstruzionePk pk, SiceeDTipoIstruzione dto) throws SiceeDTipoIstruzioneDaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_ISTRUZIONE table.
	 */
	public void delete(SiceeDTipoIstruzionePk pk) throws SiceeDTipoIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria 'ID_TIPO_ISTRUZIONE = :idTipoIstruzione'.
	 */
	public SiceeDTipoIstruzione findByPrimaryKey(Integer idTipoIstruzione) throws SiceeDTipoIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria ''.
	 */
	public List<SiceeDTipoIstruzione> findAll() throws SiceeDTipoIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria 'ID_TIPO_ISTRUZIONE = :idTipoIstruzione'.
	 */
	public List<SiceeDTipoIstruzione> findWhereIdTipoIstruzioneEquals(Integer idTipoIstruzione) throws SiceeDTipoIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipoIstruzione> findWhereDescrEquals(String descr) throws SiceeDTipoIstruzioneDaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPO_ISTRUZIONE table that matches the specified primary-key value.
	 */
	public SiceeDTipoIstruzione findByPrimaryKey(SiceeDTipoIstruzionePk pk) throws SiceeDTipoIstruzioneDaoException;

}
