/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifysignandcertDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifysignandcert;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifysignandcertPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTVerifysignandcertDaoException;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTVerifysignandcertDao.
 */
public interface SiceeTVerifysignandcertDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTVerifysignandcertPk
	 */
	public SiceeTVerifysignandcertPk insert(SiceeTVerifysignandcert dto);

	/**
	 * Updates a single row in the SICEE_T_VERIFYSIGNANDCERT table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public void update(SiceeTVerifysignandcertPk pk, SiceeTVerifysignandcert dto) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Deletes a single row in the SICEE_T_VERIFYSIGNANDCERT table.
	 *
	 * @param pk the pk
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public void delete(SiceeTVerifysignandcertPk pk) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_SIGNANDCERT = :progrSignandcert'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @param progrSignandcert the progr signandcert
	 * @return the sicee t verifysignandcert
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public SiceeTVerifysignandcert findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer progrSignandcert) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findAll() throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereAnnoEquals(String anno) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'PROGR_SIGNANDCERT = :progrSignandcert'.
	 *
	 * @param progrSignandcert the progr signandcert
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereProgrSignandcertEquals(Integer progrSignandcert) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ERROR_CODE = :errorCode'.
	 *
	 * @param errorCode the error code
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereErrorCodeEquals(Integer errorCode) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'TOT_NUM_SIGNATURE = :totNumSignature'.
	 *
	 * @param totNumSignature the tot num signature
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereTotNumSignatureEquals(Integer totNumSignature) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'TOT_NUM_TIMESTAMP = :totNumTimestamp'.
	 *
	 * @param totNumTimestamp the tot num timestamp
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereTotNumTimestampEquals(Integer totNumTimestamp) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'VERIFICATION_DATE = :verificationDate'.
	 *
	 * @param verificationDate the verification date
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereVerificationDateEquals(Date verificationDate) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'DELIBERATION_COMPLIANT = :deliberationCompliant'.
	 *
	 * @param deliberationCompliant the deliberation compliant
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereDeliberationCompliantEquals(String deliberationCompliant) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'FILE_TYPE = :fileType'.
	 *
	 * @param fileType the file type
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereFileTypeEquals(Integer fileType) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'SIGNATURE_TYPE = :signatureType'.
	 *
	 * @param signatureType the signature type
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereSignatureTypeEquals(Integer signatureType) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'SIGNATURE_FORMAT = :signatureFormat'.
	 *
	 * @param signatureFormat the signature format
	 * @return the list
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public List<SiceeTVerifysignandcert> findWhereSignatureFormatEquals(Integer signatureFormat) throws SiceeTVerifysignandcertDaoException;

	/**
	 * Returns the rows from the SICEE_T_VERIFYSIGNANDCERT table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t verifysignandcert
	 * @throws SiceeTVerifysignandcertDaoException the sicee t verifysignandcert dao exception
	 */
	public SiceeTVerifysignandcert findByPrimaryKey(SiceeTVerifysignandcertPk pk) throws SiceeTVerifysignandcertDaoException;

}
