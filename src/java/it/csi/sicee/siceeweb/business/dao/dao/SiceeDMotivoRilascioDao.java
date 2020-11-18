/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMotivoRilascioDaoException;
import java.util.List;

public interface SiceeDMotivoRilascioDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDMotivoRilascioPk
	 */
	public SiceeDMotivoRilascioPk insert(SiceeDMotivoRilascio dto);

	/** 
	 * Updates a single row in the SICEE_D_MOTIVO_RILASCIO table.
	 */
	public void update(SiceeDMotivoRilascioPk pk, SiceeDMotivoRilascio dto) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Deletes a single row in the SICEE_D_MOTIVO_RILASCIO table.
	 */
	public void delete(SiceeDMotivoRilascioPk pk) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'ID_MOTIVO = :idMotivo'.
	 */
	public SiceeDMotivoRilascio findByPrimaryKey(Integer idMotivo) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria ''.
	 */
	public List<SiceeDMotivoRilascio> findAll() throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'ID_MOTIVO = :idMotivo'.
	 */
	public List<SiceeDMotivoRilascio> findWhereIdMotivoEquals(Integer idMotivo) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDMotivoRilascio> findWhereDescrEquals(String descr) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_VISIBILE_COMBO = :flgVisibileCombo'.
	 */
	public List<SiceeDMotivoRilascio> findWhereFlgVisibileComboEquals(String flgVisibileCombo) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	public List<SiceeDMotivoRilascio> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLAG_NON_VALIDO_DLGS192_2005 = :flagNonValidoDlgs1922005'.
	 */
	public List<SiceeDMotivoRilascio> findWhereFlagNonValidoDlgs1922005Equals(String flagNonValidoDlgs1922005) throws SiceeDMotivoRilascioDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_VISIBILE_COMBO = 'S''.
	 *
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findWhereFlgComboEqualsS() throws SiceeDMotivoRilascioDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO= 1'.
	 *
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findWhereFlgAttivoOn() throws SiceeDMotivoRilascioDaoException;

	
	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO= 1 AND ID_MOTIVO > :idMotivo'.
	 *
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findMotiviStandardWhereFlgAttivoOn(Integer idMotivo) throws SiceeDMotivoRilascioDaoException;
	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO= 1 AND ID_MOTIVO > :idMotivo'.
	 *
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findAltroWhereFlgAttivoOn(Integer idMotivo) throws SiceeDMotivoRilascioDaoException;


	/** 
	 * Returns the rows from the SICEE_D_MOTIVO_RILASCIO table that matches the specified primary-key value.
	 */
	public SiceeDMotivoRilascio findByPrimaryKey(SiceeDMotivoRilascioPk pk) throws SiceeDMotivoRilascioDaoException;

}
