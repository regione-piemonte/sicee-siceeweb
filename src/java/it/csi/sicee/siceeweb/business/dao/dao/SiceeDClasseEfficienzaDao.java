/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEfficienza;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEfficienzaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDClasseEfficienzaDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDClasseEfficienzaDao.
 */
public interface SiceeDClasseEfficienzaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDClasseEfficienzaPk
	 */
	public SiceeDClasseEfficienzaPk insert(SiceeDClasseEfficienza dto);

	/**
	 * Updates a single row in the SICEE_D_CLASSE_EFFICIENZA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDClasseEfficienzaDaoException the sicee d classe efficienza dao exception
	 */
	public void update(SiceeDClasseEfficienzaPk pk, SiceeDClasseEfficienza dto) throws SiceeDClasseEfficienzaDaoException;

	/**
	 * Deletes a single row in the SICEE_D_CLASSE_EFFICIENZA table.
	 *
	 * @param pk the pk
	 * @throws SiceeDClasseEfficienzaDaoException the sicee d classe efficienza dao exception
	 */
	public void delete(SiceeDClasseEfficienzaPk pk) throws SiceeDClasseEfficienzaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria 'ID_CLASSE_EFF = :idClasseEff'.
	 *
	 * @param idClasseEff the id classe eff
	 * @return the sicee d classe efficienza
	 * @throws SiceeDClasseEfficienzaDaoException the sicee d classe efficienza dao exception
	 */
	public SiceeDClasseEfficienza findByPrimaryKey(Integer idClasseEff) throws SiceeDClasseEfficienzaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDClasseEfficienzaDaoException the sicee d classe efficienza dao exception
	 */
	public List<SiceeDClasseEfficienza> findAll() throws SiceeDClasseEfficienzaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria 'ID_CLASSE_EFF = :idClasseEff'.
	 *
	 * @param idClasseEff the id classe eff
	 * @return the list
	 * @throws SiceeDClasseEfficienzaDaoException the sicee d classe efficienza dao exception
	 */
	public List<SiceeDClasseEfficienza> findWhereIdClasseEffEquals(Integer idClasseEff) throws SiceeDClasseEfficienzaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDClasseEfficienzaDaoException the sicee d classe efficienza dao exception
	 */
	public List<SiceeDClasseEfficienza> findWhereDescrEquals(String descr) throws SiceeDClasseEfficienzaDaoException;

	/**
	 * Returns the rows from the SICEE_D_CLASSE_EFFICIENZA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d classe efficienza
	 * @throws SiceeDClasseEfficienzaDaoException the sicee d classe efficienza dao exception
	 */
	public SiceeDClasseEfficienza findByPrimaryKey(SiceeDClasseEfficienzaPk pk) throws SiceeDClasseEfficienzaDaoException;

}
