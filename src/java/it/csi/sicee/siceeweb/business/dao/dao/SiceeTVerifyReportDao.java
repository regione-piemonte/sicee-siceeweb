/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifyReportDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReport;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReportPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTVerifyReportDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTVerifyReportDao.
 */
public interface SiceeTVerifyReportDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTVerifyReportPk
	 */
	public SiceeTVerifyReportPk insert(SiceeTVerifyReport dto);

	/**
	 * Updates a single row in the SICEE_T_VERIFY_REPORT table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public void update(SiceeTVerifyReportPk pk, SiceeTVerifyReport dto) throws SiceeTVerifyReportDaoException;

	/**
	 * Deletes a single row in the SICEE_T_VERIFY_REPORT table.
	 *
	 * @param pk the pk
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public void delete(SiceeTVerifyReportPk pk) throws SiceeTVerifyReportDaoException;

	public void deleteBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTVerifyReportDaoException;
	
	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @param progrVerifyReport the progr verify report
	 * @return the sicee t verify report
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public SiceeTVerifyReport findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer progrVerifyReport) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findAll() throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 *
	 * @param progrVerifyReport the progr verify report
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereProgrVerifyReportEquals(Integer progrVerifyReport) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereAnnoEquals(String anno) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'PARAMETRI_INPUT = :parametriInput'.
	 *
	 * @param parametriInput the parametri input
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereParametriInputEquals(Integer parametriInput) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'FORMATO_FIRMA = :formatoFirma'.
	 *
	 * @param formatoFirma the formato firma
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereFormatoFirmaEquals(Integer formatoFirma) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'TIPO_FIRMA = :tipoFirma'.
	 *
	 * @param tipoFirma the tipo firma
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereTipoFirmaEquals(Integer tipoFirma) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'NUM_CERTIFICATI_FIRMA = :numCertificatiFirma'.
	 *
	 * @param numCertificatiFirma the num certificati firma
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereNumCertificatiFirmaEquals(Integer numCertificatiFirma) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'NUM_MARCHE = :numMarche'.
	 *
	 * @param numMarche the num marche
	 * @return the list
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public List<SiceeTVerifyReport> findWhereNumMarcheEquals(Integer numMarche) throws SiceeTVerifyReportDaoException;

	/**
	 * Returns the rows from the SICEE_T_VERIFY_REPORT table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t verify report
	 * @throws SiceeTVerifyReportDaoException the sicee t verify report dao exception
	 */
	public SiceeTVerifyReport findByPrimaryKey(SiceeTVerifyReportPk pk) throws SiceeTVerifyReportDaoException;
	
	/**
	 * Gets the next value.
	 *
	 * @return the next value
	 */
	public Long getNextValue();

}
