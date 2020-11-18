/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiFirmaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiFirma;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiFirmaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiFirmaDaoException;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTDatiFirmaDao.
 */
public interface SiceeTDatiFirmaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTDatiFirmaPk
	 */
	public SiceeTDatiFirmaPk insert(SiceeTDatiFirma dto);

	/**
	 * Updates a single row in the SICEE_T_DATI_FIRMA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public void update(SiceeTDatiFirmaPk pk, SiceeTDatiFirma dto) throws SiceeTDatiFirmaDaoException;

	/**
	 * Deletes a single row in the SICEE_T_DATI_FIRMA table.
	 *
	 * @param pk the pk
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public void delete(SiceeTDatiFirmaPk pk) throws SiceeTDatiFirmaDaoException;

	public void deleteBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiFirmaDaoException;
	
	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_DATI_FIRMA = :idDatiFirma'.
	 *
	 * @param idDatiFirma the id dati firma
	 * @return the sicee t dati firma
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public SiceeTDatiFirma findByPrimaryKey(Integer idDatiFirma) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'PROGR_UPLOAD = :progrUpload'.
	 *
	 * @param progrUpload the progr upload
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereProgrUploadEquals(Long progrUpload) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findAll() throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @param progrVerifyReport the progr verify report
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findBySiceeTVerifyReport(String idCertificatore, String progrCertificato, String anno, Integer progrVerifyReport) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_DATI_FIRMA = :idDatiFirma'.
	 *
	 * @param idDatiFirma the id dati firma
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereIdDatiFirmaEquals(Integer idDatiFirma) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereAnnoEquals(String anno) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 *
	 * @param progrVerifyReport the progr verify report
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereProgrVerifyReportEquals(Integer progrVerifyReport) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'FK_STATO_FILE = :fkStatoFile'.
	 *
	 * @param fkStatoFile the fk stato file
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereFkStatoFileEquals(Integer fkStatoFile) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ERROR_CODE = :errorCode'.
	 *
	 * @param errorCode the error code
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereErrorCodeEquals(Integer errorCode) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'SURNAME = :surname'.
	 *
	 * @param surname the surname
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereSurnameEquals(String surname) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'GIVEN_NAME = :givenName'.
	 *
	 * @param givenName the given name
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereGivenNameEquals(String givenName) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'SERIAL_NUMBER = :serialNumber'.
	 *
	 * @param serialNumber the serial number
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereSerialNumberEquals(String serialNumber) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'CA = :ca'.
	 *
	 * @param ca the ca
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereCaEquals(String ca) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_FIRMA = :dtFirma'.
	 *
	 * @param dtFirma the dt firma
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereDtFirmaEquals(Date dtFirma) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_VERIFICA = :dtVerifica'.
	 *
	 * @param dtVerifica the dt verifica
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereDtVerificaEquals(Date dtVerifica) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_INIZIO_VAL_CERT = :dtInizioValCert'.
	 *
	 * @param dtInizioValCert the dt inizio val cert
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereDtInizioValCertEquals(Date dtInizioValCert) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_FINE_VAL_CERT = :dtFineValCert'.
	 *
	 * @param dtFineValCert the dt fine val cert
	 * @return the list
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public List<SiceeTDatiFirma> findWhereDtFineValCertEquals(Date dtFineValCert) throws SiceeTDatiFirmaDaoException;

	/**
	 * Returns the rows from the SICEE_T_DATI_FIRMA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t dati firma
	 * @throws SiceeTDatiFirmaDaoException the sicee t dati firma dao exception
	 */
	public SiceeTDatiFirma findByPrimaryKey(SiceeTDatiFirmaPk pk) throws SiceeTDatiFirmaDaoException;
	

}
