/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCombustibileDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibilePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDCombustibileDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDCombustibileDao.
 */
public interface SiceeDCombustibileDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDCombustibilePk
	 */
	public SiceeDCombustibilePk insert(SiceeDCombustibile dto);

	/**
	 * Updates a single row in the SICEE_D_COMBUSTIBILE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public void update(SiceeDCombustibilePk pk, SiceeDCombustibile dto) throws SiceeDCombustibileDaoException;

	/**
	 * Deletes a single row in the SICEE_D_COMBUSTIBILE table.
	 *
	 * @param pk the pk
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public void delete(SiceeDCombustibilePk pk) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile'.
	 *
	 * @param idCombustibile the id combustibile
	 * @return the sicee d combustibile
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public SiceeDCombustibile findByPrimaryKey(Integer idCombustibile) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findAll() throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile'.
	 *
	 * @param idCombustibile the id combustibile
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findWhereIdCombustibileEquals(Integer idCombustibile) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findWhereDescrEquals(String descr) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FATTORE_EMISSIONE = :fattoreEmissione'.
	 *
	 * @param fattoreEmissione the fattore emissione
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findWhereFattoreEmissioneEquals(Double fattoreEmissione) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_COMBO_RISCALD = :flgComboRiscald'.
	 *
	 * @param flgComboRiscald the flg combo riscald
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findWhereFlgComboRiscaldEquals(String flgComboRiscald) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_VETTORE_EN_EXPORT = :flgVettoreEnExport'.
	 *
	 * @param flgVettoreEnExport the flg vettore en export
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findWhereFlgVettoreEnExportEquals(String flgVettoreEnExport) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_VETTORE_DET_IMP = :flgVettoreDetImp'.
	 *
	 * @param flgVettoreDetImp the flg vettore det imp
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findWhereFlgVettoreDetImpEquals(String flgVettoreDetImp) throws SiceeDCombustibileDaoException;

	/**
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_CONSUMI = :flgConsumi'.
	 *
	 * @param flgConsumi the flg consumi
	 * @return the list
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public List<SiceeDCombustibile> findWhereFlgConsumiEquals(String flgConsumi) throws SiceeDCombustibileDaoException;

	/**
	 * Returns the rows from the SICEE_D_COMBUSTIBILE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d combustibile
	 * @throws SiceeDCombustibileDaoException the sicee d combustibile dao exception
	 */
	public SiceeDCombustibile findByPrimaryKey(SiceeDCombustibilePk pk) throws SiceeDCombustibileDaoException;

}
