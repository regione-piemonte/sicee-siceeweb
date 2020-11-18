/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergeticaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDClasseEnergeticaDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDClasseEnergeticaDao.
 */
public interface SiceeDClasseEnergeticaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDClasseEnergeticaPk
	 */
	public SiceeDClasseEnergeticaPk insert(SiceeDClasseEnergetica dto);

	/**
	 * Updates a single row in the SICEE_D_CLASSE_ENERGETICA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public void update(SiceeDClasseEnergeticaPk pk, SiceeDClasseEnergetica dto) throws SiceeDClasseEnergeticaDaoException;

	/**
	 * Deletes a single row in the SICEE_D_CLASSE_ENERGETICA table.
	 *
	 * @param pk the pk
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public void delete(SiceeDClasseEnergeticaPk pk) throws SiceeDClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'ID_CLASSE = :idClasse'.
	 *
	 * @param idClasse the id classe
	 * @return the sicee d classe energetica
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public SiceeDClasseEnergetica findByPrimaryKey(Integer idClasse) throws SiceeDClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public List<SiceeDClasseEnergetica> findAll() throws SiceeDClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'ID_CLASSE = :idClasse'.
	 *
	 * @param idClasse the id classe
	 * @return the list
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public List<SiceeDClasseEnergetica> findWhereIdClasseEquals(Integer idClasse) throws SiceeDClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public List<SiceeDClasseEnergetica> findWhereDescrEquals(String descr) throws SiceeDClasseEnergeticaDaoException;

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDClasseEnergetica> findAttivoWhereDescrEquals(String attivo, String descr) throws SiceeDClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'FLG_NAZIONALE_19205 = :flgNazionale19205'.
	 *
	 * @param flgNazionale19205 the flg nazionale19205
	 * @return the list
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public List<SiceeDClasseEnergetica> findWhereFlgNazionale19205Equals(String flgNazionale19205) throws SiceeDClasseEnergeticaDaoException;

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereFlgAttivoEquals(String flgAttivo) throws SiceeDClasseEnergeticaDaoException;

	/**
	 * Returns the rows from the SICEE_D_CLASSE_ENERGETICA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d classe energetica
	 * @throws SiceeDClasseEnergeticaDaoException the sicee d classe energetica dao exception
	 */
	public SiceeDClasseEnergetica findByPrimaryKey(SiceeDClasseEnergeticaPk pk) throws SiceeDClasseEnergeticaDaoException;

}
