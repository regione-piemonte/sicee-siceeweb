/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFirmaMarcaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFirmaMarca;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFirmaMarcaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTFirmaMarcaDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

public class SiceeTFirmaMarcaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTFirmaMarca>, SiceeTFirmaMarcaDao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;
	
	protected DataFieldMaxValueIncrementer incrementerFirmaMarca;
	   
	public void setIncrementerFirmaMarca(DataFieldMaxValueIncrementer incrementer) {
		this.incrementerFirmaMarca = incrementer;
	}
	
	public int getNextValueFirmaMarca() {
		return this.incrementerFirmaMarca.nextIntValue();
	}

	/**
	 * Method 'setDataSource'
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTFirmaMarcaPk
	 */
	public SiceeTFirmaMarcaPk insert(SiceeTFirmaMarca dto)
	{
		dto.setIdFirmaMarca(new Long(getNextValueFirmaMarca()));
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdFirmaMarca(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getProgrSignandcert(),dto.getCertificateType(),dto.getCompliance(),dto.getDateTimeSignature(),dto.getDigestAlgorithm(),dto.getErrorCodeFirma(),dto.getGivenName(),dto.getSurname(),dto.getTaxCode(),dto.getRevocationDate(),dto.getCertificationAuthority(),dto.getErrorCodeCertificato(),dto.getSerialNumber(),dto.getValidFrom(),dto.getValidTo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_FIRMA_MARCA table.
	 */
	public void update(SiceeTFirmaMarcaPk pk, SiceeTFirmaMarca dto) throws SiceeTFirmaMarcaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_FIRMA_MARCA = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, PROGR_SIGNANDCERT = ?, CERTIFICATE_TYPE = ?, COMPLIANCE = ?, DATE_TIME_SIGNATURE = ?, DIGEST_ALGORITHM = ?, ERROR_CODE_FIRMA = ?, GIVEN_NAME = ?, SURNAME = ?, TAX_CODE = ?, REVOCATION_DATE = ?, CERTIFICATION_AUTHORITY = ?, ERROR_CODE_CERTIFICATO = ?, SERIAL_NUMBER = ?, VALID_FROM = ?, VALID_TO = ? WHERE ID_FIRMA_MARCA = ?",dto.getIdFirmaMarca(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getProgrSignandcert(),dto.getCertificateType(),dto.getCompliance(),dto.getDateTimeSignature(),dto.getDigestAlgorithm(),dto.getErrorCodeFirma(),dto.getGivenName(),dto.getSurname(),dto.getTaxCode(),dto.getRevocationDate(),dto.getCertificationAuthority(),dto.getErrorCodeCertificato(),dto.getSerialNumber(),dto.getValidFrom(),dto.getValidTo(),pk.getIdFirmaMarca());
	}

	/** 
	 * Deletes a single row in the SICEE_T_FIRMA_MARCA table.
	 */
	public void delete(SiceeTFirmaMarcaPk pk) throws SiceeTFirmaMarcaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_FIRMA_MARCA = ?",pk.getIdFirmaMarca());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTFirmaMarca
	 */
	public SiceeTFirmaMarca mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTFirmaMarca dto = new SiceeTFirmaMarca();
		dto.setIdFirmaMarca( new Long( rs.getLong(1) ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setProgrSignandcert( new Integer( rs.getInt(5) ) );
		dto.setCertificateType( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setCertificateType( null );
		}
		
		dto.setCompliance( rs.getString( 7 ) );
		dto.setDateTimeSignature( rs.getTimestamp(8 ) );
		dto.setDigestAlgorithm( rs.getString( 9 ) );
		dto.setErrorCodeFirma( new Integer( rs.getInt(10) ) );
		if (rs.wasNull()) {
			dto.setErrorCodeFirma( null );
		}
		
		dto.setGivenName( rs.getString( 11 ) );
		dto.setSurname( rs.getString( 12 ) );
		dto.setTaxCode( rs.getString( 13 ) );
		dto.setRevocationDate( rs.getTimestamp(14 ) );
		dto.setCertificationAuthority( rs.getString( 15 ) );
		dto.setErrorCodeCertificato( new Integer( rs.getInt(16) ) );
		if (rs.wasNull()) {
			dto.setErrorCodeCertificato( null );
		}
		
		dto.setSerialNumber( rs.getString( 17 ) );
		dto.setValidFrom( rs.getTimestamp(18 ) );
		dto.setValidTo( rs.getTimestamp(19 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_FIRMA_MARCA";
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_FIRMA_MARCA = :idFirmaMarca'.
	 */
	public SiceeTFirmaMarca findByPrimaryKey(Long idFirmaMarca) throws SiceeTFirmaMarcaDaoException
	{
		try {
			List<SiceeTFirmaMarca> list = jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE ID_FIRMA_MARCA = ?", this,idFirmaMarca);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria ''.
	 */
	public List<SiceeTFirmaMarca> findAll() throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " ORDER BY ID_FIRMA_MARCA", this);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_SIGNANDCERT = :progrSignandcert'.
	 */
	public List<SiceeTFirmaMarca> findBySiceeTVerifysignandcert(String idCertificatore, String progrCertificato, String anno, Integer progrSignandcert) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_SIGNANDCERT = ?", this,idCertificatore,progrCertificato,anno,progrSignandcert);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_FIRMA_MARCA = :idFirmaMarca'.
	 */
	public List<SiceeTFirmaMarca> findWhereIdFirmaMarcaEquals(Long idFirmaMarca) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE ID_FIRMA_MARCA = ? ORDER BY ID_FIRMA_MARCA", this,idFirmaMarca);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTFirmaMarca> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTFirmaMarca> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTFirmaMarca> findWhereAnnoEquals(String anno) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'PROGR_SIGNANDCERT = :progrSignandcert'.
	 */
	public List<SiceeTFirmaMarca> findWhereProgrSignandcertEquals(Integer progrSignandcert) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE PROGR_SIGNANDCERT = ? ORDER BY PROGR_SIGNANDCERT", this,progrSignandcert);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'CERTIFICATE_TYPE = :certificateType'.
	 */
	public List<SiceeTFirmaMarca> findWhereCertificateTypeEquals(Integer certificateType) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE CERTIFICATE_TYPE = ? ORDER BY CERTIFICATE_TYPE", this,certificateType);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'COMPLIANCE = :compliance'.
	 */
	public List<SiceeTFirmaMarca> findWhereComplianceEquals(String compliance) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE COMPLIANCE = ? ORDER BY COMPLIANCE", this,compliance);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'DATE_TIME_SIGNATURE = :dateTimeSignature'.
	 */
	public List<SiceeTFirmaMarca> findWhereDateTimeSignatureEquals(Date dateTimeSignature) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE DATE_TIME_SIGNATURE = ? ORDER BY DATE_TIME_SIGNATURE", this,dateTimeSignature);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'DIGEST_ALGORITHM = :digestAlgorithm'.
	 */
	public List<SiceeTFirmaMarca> findWhereDigestAlgorithmEquals(String digestAlgorithm) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE DIGEST_ALGORITHM = ? ORDER BY DIGEST_ALGORITHM", this,digestAlgorithm);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ERROR_CODE_FIRMA = :errorCodeFirma'.
	 */
	public List<SiceeTFirmaMarca> findWhereErrorCodeFirmaEquals(Integer errorCodeFirma) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE ERROR_CODE_FIRMA = ? ORDER BY ERROR_CODE_FIRMA", this,errorCodeFirma);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'GIVEN_NAME = :givenName'.
	 */
	public List<SiceeTFirmaMarca> findWhereGivenNameEquals(String givenName) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE GIVEN_NAME = ? ORDER BY GIVEN_NAME", this,givenName);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'SURNAME = :surname'.
	 */
	public List<SiceeTFirmaMarca> findWhereSurnameEquals(String surname) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE SURNAME = ? ORDER BY SURNAME", this,surname);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'TAX_CODE = :taxCode'.
	 */
	public List<SiceeTFirmaMarca> findWhereTaxCodeEquals(String taxCode) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE TAX_CODE = ? ORDER BY TAX_CODE", this,taxCode);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'REVOCATION_DATE = :revocationDate'.
	 */
	public List<SiceeTFirmaMarca> findWhereRevocationDateEquals(Date revocationDate) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE REVOCATION_DATE = ? ORDER BY REVOCATION_DATE", this,revocationDate);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'CERTIFICATION_AUTHORITY = :certificationAuthority'.
	 */
	public List<SiceeTFirmaMarca> findWhereCertificationAuthorityEquals(String certificationAuthority) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE CERTIFICATION_AUTHORITY = ? ORDER BY CERTIFICATION_AUTHORITY", this,certificationAuthority);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'ERROR_CODE_CERTIFICATO = :errorCodeCertificato'.
	 */
	public List<SiceeTFirmaMarca> findWhereErrorCodeCertificatoEquals(Integer errorCodeCertificato) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE ERROR_CODE_CERTIFICATO = ? ORDER BY ERROR_CODE_CERTIFICATO", this,errorCodeCertificato);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'SERIAL_NUMBER = :serialNumber'.
	 */
	public List<SiceeTFirmaMarca> findWhereSerialNumberEquals(String serialNumber) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE SERIAL_NUMBER = ? ORDER BY SERIAL_NUMBER", this,serialNumber);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'VALID_FROM = :validFrom'.
	 */
	public List<SiceeTFirmaMarca> findWhereValidFromEquals(Date validFrom) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE VALID_FROM = ? ORDER BY VALID_FROM", this,validFrom);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FIRMA_MARCA table that match the criteria 'VALID_TO = :validTo'.
	 */
	public List<SiceeTFirmaMarca> findWhereValidToEquals(Date validTo) throws SiceeTFirmaMarcaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FIRMA_MARCA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, CERTIFICATE_TYPE, COMPLIANCE, DATE_TIME_SIGNATURE, DIGEST_ALGORITHM, ERROR_CODE_FIRMA, GIVEN_NAME, SURNAME, TAX_CODE, REVOCATION_DATE, CERTIFICATION_AUTHORITY, ERROR_CODE_CERTIFICATO, SERIAL_NUMBER, VALID_FROM, VALID_TO FROM " + getTableName() + " WHERE VALID_TO = ? ORDER BY VALID_TO", this,validTo);
		}
		catch (Exception e) {
			throw new SiceeTFirmaMarcaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_FIRMA_MARCA table that matches the specified primary-key value.
	 */
	public SiceeTFirmaMarca findByPrimaryKey(SiceeTFirmaMarcaPk pk) throws SiceeTFirmaMarcaDaoException
	{
		return findByPrimaryKey( pk.getIdFirmaMarca() );
	}

}
