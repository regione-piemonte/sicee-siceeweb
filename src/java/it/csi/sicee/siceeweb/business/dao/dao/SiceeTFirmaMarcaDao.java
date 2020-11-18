/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFirmaMarcaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFirmaMarca;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFirmaMarcaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTFirmaMarcaDaoException;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTFirmaMarcaDao.
 */
public interface SiceeTFirmaMarcaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTFirmaMarcaPk
	 */
	public SiceeTFirmaMarcaPk insert(SiceeTFirmaMarca dto);

	/**
	 * Updates a single row in the SICEE_T_FIRMA_MARCA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public void update(SiceeTFirmaMarcaPk pk, SiceeTFirmaMarca dto) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Deletes a single row in the SICEE_T_FIRMA_MARCA table.
	 *
	 * @param pk the pk
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public void delete(SiceeTFirmaMarcaPk pk) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_FIRMA_MARCA = :idFirmaMarca'.
	 *
	 * @param idFirmaMarca the id firma marca
	 * @return the sicee t firma marca
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public SiceeTFirmaMarca findByPrimaryKey(Long idFirmaMarca) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findAll() throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_SIGNANDCERT = :progrSignandcert'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @param progrSignandcert the progr signandcert
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findBySiceeTVerifysignandcert(String idCertificatore, String progrCertificato, String anno, Integer progrSignandcert) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_FIRMA_MARCA = :idFirmaMarca'.
	 *
	 * @param idFirmaMarca the id firma marca
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereIdFirmaMarcaEquals(Long idFirmaMarca) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereAnnoEquals(String anno) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'PROGR_SIGNANDCERT = :progrSignandcert'.
	 *
	 * @param progrSignandcert the progr signandcert
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereProgrSignandcertEquals(Integer progrSignandcert) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'CERTIFICATE_TYPE = :certificateType'.
	 *
	 * @param certificateType the certificate type
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereCertificateTypeEquals(Integer certificateType) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'COMPLIANCE = :compliance'.
	 *
	 * @param compliance the compliance
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereComplianceEquals(String compliance) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'DATE_TIME_SIGNATURE = :dateTimeSignature'.
	 *
	 * @param dateTimeSignature the date time signature
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereDateTimeSignatureEquals(Date dateTimeSignature) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'DIGEST_ALGORITHM = :digestAlgorithm'.
	 *
	 * @param digestAlgorithm the digest algorithm
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereDigestAlgorithmEquals(String digestAlgorithm) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ERROR_CODE_FIRMA = :errorCodeFirma'.
	 *
	 * @param errorCodeFirma the error code firma
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereErrorCodeFirmaEquals(Integer errorCodeFirma) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'GIVEN_NAME = :givenName'.
	 *
	 * @param givenName the given name
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereGivenNameEquals(String givenName) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'SURNAME = :surname'.
	 *
	 * @param surname the surname
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereSurnameEquals(String surname) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'TAX_CODE = :taxCode'.
	 *
	 * @param taxCode the tax code
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereTaxCodeEquals(String taxCode) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'REVOCATION_DATE = :revocationDate'.
	 *
	 * @param revocationDate the revocation date
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereRevocationDateEquals(Date revocationDate) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'CERTIFICATION_AUTHORITY = :certificationAuthority'.
	 *
	 * @param certificationAuthority the certification authority
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereCertificationAuthorityEquals(String certificationAuthority) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ERROR_CODE_CERTIFICATO = :errorCodeCertificato'.
	 *
	 * @param errorCodeCertificato the error code certificato
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereErrorCodeCertificatoEquals(Integer errorCodeCertificato) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'SERIAL_NUMBER = :serialNumber'.
	 *
	 * @param serialNumber the serial number
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereSerialNumberEquals(String serialNumber) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'VALID_FROM = :validFrom'.
	 *
	 * @param validFrom the valid from
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereValidFromEquals(Date validFrom) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'VALID_TO = :validTo'.
	 *
	 * @param validTo the valid to
	 * @return the list
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public List<SiceeTFirmaMarca> findWhereValidToEquals(Date validTo) throws SiceeTFirmaMarcaDaoException;

	/**
	 * Returns the rows from the SICEE_T_FIRMA_MARCA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t firma marca
	 * @throws SiceeTFirmaMarcaDaoException the sicee t firma marca dao exception
	 */
	public SiceeTFirmaMarca findByPrimaryKey(SiceeTFirmaMarcaPk pk) throws SiceeTFirmaMarcaDaoException;

}
