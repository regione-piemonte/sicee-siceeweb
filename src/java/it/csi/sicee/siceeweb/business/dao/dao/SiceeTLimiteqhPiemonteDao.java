/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTLimiteqhPiemonte;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTLimiteqhPiemonteDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTLimiteqhPiemonteDao.
 */
public interface SiceeTLimiteqhPiemonteDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 */
	public void insert(SiceeTLimiteqhPiemonte dto);

	/**
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTLimiteqhPiemonteDaoException the sicee t limiteqh piemonte dao exception
	 */
	public List<SiceeTLimiteqhPiemonte> findAll() throws SiceeTLimiteqhPiemonteDaoException;

	/**
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'VOLUME = :volume'.
	 *
	 * @param volume the volume
	 * @return the list
	 * @throws SiceeTLimiteqhPiemonteDaoException the sicee t limiteqh piemonte dao exception
	 */
	public List<SiceeTLimiteqhPiemonte> findWhereVolumeEquals(Integer volume) throws SiceeTLimiteqhPiemonteDaoException;

	/**
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'GG_3000 = :gg3000'.
	 *
	 * @param gg3000 the gg3000
	 * @return the list
	 * @throws SiceeTLimiteqhPiemonteDaoException the sicee t limiteqh piemonte dao exception
	 */
	public List<SiceeTLimiteqhPiemonte> findWhereGg3000Equals(Float gg3000) throws SiceeTLimiteqhPiemonteDaoException;

	/**
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'GG_5000 = :gg5000'.
	 *
	 * @param gg5000 the gg5000
	 * @return the list
	 * @throws SiceeTLimiteqhPiemonteDaoException the sicee t limiteqh piemonte dao exception
	 */
	public List<SiceeTLimiteqhPiemonte> findWhereGg5000Equals(Float gg5000) throws SiceeTLimiteqhPiemonteDaoException;

	/**
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'FLG_EDIFICIO = :flgEdificio'.
	 *
	 * @param flgEdificio the flg edificio
	 * @return the list
	 * @throws SiceeTLimiteqhPiemonteDaoException the sicee t limiteqh piemonte dao exception
	 */
	public List<SiceeTLimiteqhPiemonte> findWhereFlgEdificioEquals(String flgEdificio) throws SiceeTLimiteqhPiemonteDaoException;

}
