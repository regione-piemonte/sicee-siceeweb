/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertRuoli;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertRuoliPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRCertRuoliDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeRCertRuoliDao.
 */
public interface SiceeRCertRuoliDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeRCertRuoliPk
	 */
	public SiceeRCertRuoliPk insert(SiceeRCertRuoli dto);

	/**
	 * Updates a single row in the SICEE_R_CERT_RUOLI table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public void update(SiceeRCertRuoliPk pk, SiceeRCertRuoli dto) throws SiceeRCertRuoliDaoException;

	/**
	 * Deletes a single row in the SICEE_R_CERT_RUOLI table.
	 *
	 * @param pk the pk
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public void delete(SiceeRCertRuoliPk pk) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR = :progr AND ANNO = :anno AND FK_RUOLO_EDIFICIO = :fkRuoloEdificio'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progr the progr
	 * @param anno the anno
	 * @param fkRuoloEdificio the fk ruolo edificio
	 * @return the sicee r cert ruoli
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public SiceeRCertRuoli findByPrimaryKey(String idCertificatore, String progr, String anno, Integer fkRuoloEdificio) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public List<SiceeRCertRuoli> findAll() throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR = :progr AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progr the progr
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public List<SiceeRCertRuoli> findBySiceeTCertificato(String idCertificatore, String progr, String anno) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'FK_RUOLO_EDIFICIO = :fkRuoloEdificio'.
	 *
	 * @param fkRuoloEdificio the fk ruolo edificio
	 * @return the list
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public List<SiceeRCertRuoli> findBySiceeTRuoliEdificio(Integer fkRuoloEdificio) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public List<SiceeRCertRuoli> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'PROGR = :progr'.
	 *
	 * @param progr the progr
	 * @return the list
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public List<SiceeRCertRuoli> findWhereProgrEquals(String progr) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public List<SiceeRCertRuoli> findWhereAnnoEquals(String anno) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'FK_RUOLO_EDIFICIO = :fkRuoloEdificio'.
	 *
	 * @param fkRuoloEdificio the fk ruolo edificio
	 * @return the list
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public List<SiceeRCertRuoli> findWhereFkRuoloEdificioEquals(Integer fkRuoloEdificio) throws SiceeRCertRuoliDaoException;

	/**
	 * Returns the rows from the SICEE_R_CERT_RUOLI table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee r cert ruoli
	 * @throws SiceeRCertRuoliDaoException the sicee r cert ruoli dao exception
	 */
	public SiceeRCertRuoli findByPrimaryKey(SiceeRCertRuoliPk pk) throws SiceeRCertRuoliDaoException;

}
