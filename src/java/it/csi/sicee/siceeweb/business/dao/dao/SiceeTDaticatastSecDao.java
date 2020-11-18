/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDaticatastSecDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSecPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDaticatastSecDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTDaticatastSecDao.
 */
public interface SiceeTDaticatastSecDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTDaticatastSecPk
	 */
	public SiceeTDaticatastSecPk insert(SiceeTDaticatastSec dto);

	/**
	 * Updates a single row in the SICEE_T_DATICATAST_SEC table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public void update(SiceeTDaticatastSecPk pk, SiceeTDaticatastSec dto) throws SiceeTDaticatastSecDaoException;

	/**
	 * Deletes rows in the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'..
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDaticatastSecDaoException;

	/**
	 * Deletes a single row in the SICEE_T_DATICATAST_SEC table.
	 *
	 * @param pk the pk
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public void delete(SiceeTDaticatastSecPk pk) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_DATICATAST_SEC = :idDaticatastSec'.
	 *
	 * @param idDaticatastSec the id daticatast sec
	 * @return the sicee t daticatast sec
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public SiceeTDaticatastSec findByPrimaryKey(Integer idDaticatastSec) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findAll() throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_DATICATAST_SEC = :idDaticatastSec'.
	 *
	 * @param idDaticatastSec the id daticatast sec
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereIdDaticatastSecEquals(Integer idDaticatastSec) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereAnnoEquals(String anno) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'SEZIONE = :sezione'.
	 *
	 * @param sezione the sezione
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereSezioneEquals(String sezione) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'FOGLIO = :foglio'.
	 *
	 * @param foglio the foglio
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereFoglioEquals(String foglio) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'PARTICELLA = :particella'.
	 *
	 * @param particella the particella
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereParticellaEquals(String particella) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'SUBALTERNO = :subalterno'.
	 *
	 * @param subalterno the subalterno
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereSubalternoEquals(String subalterno) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'FLG_SIGMATER = :flgSigmater'.
	 *
	 * @param flgSigmater the flg sigmater
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findWhereFlgSigmaterEquals(String flgSigmater) throws SiceeTDaticatastSecDaoException;

	/**
	 * Returns the rows from the SICEE_T_DATICATAST_SEC table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t daticatast sec
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public SiceeTDaticatastSec findByPrimaryKey(SiceeTDaticatastSecPk pk) throws SiceeTDaticatastSecDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'CODICE_COMUNE_CATASTALE = :codiceComuneCatastale'.
	 */
	public List<SiceeTDaticatastSec> findWhereCodiceComuneCatastaleEquals(String codiceComuneCatastale) throws SiceeTDaticatastSecDaoException;
	
	/**
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public List<SiceeTDaticatastSec> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDaticatastSecDaoException;

}
