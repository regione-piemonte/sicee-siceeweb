/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifysignandcertDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifysignandcert;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifysignandcertPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTVerifysignandcertDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTVerifysignandcertDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTVerifysignandcert>, SiceeTVerifysignandcertDao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;
	
	protected DataFieldMaxValueIncrementer incrementerVerifysignandcert;
	   
	public void setIncrementerVerifysignandcert(DataFieldMaxValueIncrementer incrementer) {
		this.incrementerVerifysignandcert = incrementer;
	}
	
	public int getNextValueVerifysignandcert() {
		return this.incrementerVerifysignandcert.nextIntValue();
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
	 * @return SiceeTVerifysignandcertPk
	 */
	public SiceeTVerifysignandcertPk insert(SiceeTVerifysignandcert dto)
	{
		dto.setProgrSignandcert(getNextValueVerifysignandcert());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getProgrSignandcert(),dto.getErrorCode(),dto.getTotNumSignature(),dto.getTotNumTimestamp(),dto.getVerificationDate(),dto.getDeliberationCompliant(),dto.getFileType(),dto.getSignatureType(),dto.getSignatureFormat());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	public void update(SiceeTVerifysignandcertPk pk, SiceeTVerifysignandcert dto) throws SiceeTVerifysignandcertDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, PROGR_SIGNANDCERT = ?, ERROR_CODE = ?, TOT_NUM_SIGNATURE = ?, TOT_NUM_TIMESTAMP = ?, VERIFICATION_DATE = ?, DELIBERATION_COMPLIANT = ?, FILE_TYPE = ?, SIGNATURE_TYPE = ?, SIGNATURE_FORMAT = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_SIGNANDCERT = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getProgrSignandcert(),dto.getErrorCode(),dto.getTotNumSignature(),dto.getTotNumTimestamp(),dto.getVerificationDate(),dto.getDeliberationCompliant(),dto.getFileType(),dto.getSignatureType(),dto.getSignatureFormat(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getProgrSignandcert());
	}

	/** 
	 * Deletes a single row in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	public void delete(SiceeTVerifysignandcertPk pk) throws SiceeTVerifysignandcertDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_SIGNANDCERT = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getProgrSignandcert());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTVerifysignandcert
	 */
	public SiceeTVerifysignandcert mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTVerifysignandcert dto = new SiceeTVerifysignandcert();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setProgrSignandcert( new Integer( rs.getInt(4) ) );
		dto.setErrorCode( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setErrorCode( null );
		}
		
		dto.setTotNumSignature( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setTotNumSignature( null );
		}
		
		dto.setTotNumTimestamp( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setTotNumTimestamp( null );
		}
		
		dto.setVerificationDate( rs.getTimestamp(8 ) );
		dto.setDeliberationCompliant( rs.getString( 9 ) );
		dto.setFileType( new Integer( rs.getInt(10) ) );
		if (rs.wasNull()) {
			dto.setFileType( null );
		}
		
		dto.setSignatureType( new Integer( rs.getInt(11) ) );
		if (rs.wasNull()) {
			dto.setSignatureType( null );
		}
		
		dto.setSignatureFormat( new Integer( rs.getInt(12) ) );
		if (rs.wasNull()) {
			dto.setSignatureFormat( null );
		}
		
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_VERIFYSIGNANDCERT";
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_SIGNANDCERT = :progrSignandcert'.
	 */
	public SiceeTVerifysignandcert findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer progrSignandcert) throws SiceeTVerifysignandcertDaoException
	{
		try {
			List<SiceeTVerifysignandcert> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_SIGNANDCERT = ?", this,idCertificatore,progrCertificato,anno,progrSignandcert);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria ''.
	 */
	public List<SiceeTVerifysignandcert> findAll() throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT", this);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTVerifysignandcert> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTVerifysignandcert> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTVerifysignandcert> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTVerifysignandcert> findWhereAnnoEquals(String anno) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'PROGR_SIGNANDCERT = :progrSignandcert'.
	 */
	public List<SiceeTVerifysignandcert> findWhereProgrSignandcertEquals(Integer progrSignandcert) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE PROGR_SIGNANDCERT = ? ORDER BY PROGR_SIGNANDCERT", this,progrSignandcert);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'ERROR_CODE = :errorCode'.
	 */
	public List<SiceeTVerifysignandcert> findWhereErrorCodeEquals(Integer errorCode) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE ERROR_CODE = ? ORDER BY ERROR_CODE", this,errorCode);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'TOT_NUM_SIGNATURE = :totNumSignature'.
	 */
	public List<SiceeTVerifysignandcert> findWhereTotNumSignatureEquals(Integer totNumSignature) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE TOT_NUM_SIGNATURE = ? ORDER BY TOT_NUM_SIGNATURE", this,totNumSignature);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'TOT_NUM_TIMESTAMP = :totNumTimestamp'.
	 */
	public List<SiceeTVerifysignandcert> findWhereTotNumTimestampEquals(Integer totNumTimestamp) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE TOT_NUM_TIMESTAMP = ? ORDER BY TOT_NUM_TIMESTAMP", this,totNumTimestamp);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'VERIFICATION_DATE = :verificationDate'.
	 */
	public List<SiceeTVerifysignandcert> findWhereVerificationDateEquals(Date verificationDate) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE VERIFICATION_DATE = ? ORDER BY VERIFICATION_DATE", this,verificationDate);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'DELIBERATION_COMPLIANT = :deliberationCompliant'.
	 */
	public List<SiceeTVerifysignandcert> findWhereDeliberationCompliantEquals(String deliberationCompliant) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE DELIBERATION_COMPLIANT = ? ORDER BY DELIBERATION_COMPLIANT", this,deliberationCompliant);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'FILE_TYPE = :fileType'.
	 */
	public List<SiceeTVerifysignandcert> findWhereFileTypeEquals(Integer fileType) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE FILE_TYPE = ? ORDER BY FILE_TYPE", this,fileType);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'SIGNATURE_TYPE = :signatureType'.
	 */
	public List<SiceeTVerifysignandcert> findWhereSignatureTypeEquals(Integer signatureType) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE SIGNATURE_TYPE = ? ORDER BY SIGNATURE_TYPE", this,signatureType);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFYSIGNANDCERT table that match the criteria 'SIGNATURE_FORMAT = :signatureFormat'.
	 */
	public List<SiceeTVerifysignandcert> findWhereSignatureFormatEquals(Integer signatureFormat) throws SiceeTVerifysignandcertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_SIGNANDCERT, ERROR_CODE, TOT_NUM_SIGNATURE, TOT_NUM_TIMESTAMP, VERIFICATION_DATE, DELIBERATION_COMPLIANT, FILE_TYPE, SIGNATURE_TYPE, SIGNATURE_FORMAT FROM " + getTableName() + " WHERE SIGNATURE_FORMAT = ? ORDER BY SIGNATURE_FORMAT", this,signatureFormat);
		}
		catch (Exception e) {
			throw new SiceeTVerifysignandcertDaoException("Query failed", e);
		}
		
	}
	/** 
	 * Returns the rows from the SICEE_T_VERIFYSIGNANDCERT table that matches the specified primary-key value.
	 */
	public SiceeTVerifysignandcert findByPrimaryKey(SiceeTVerifysignandcertPk pk) throws SiceeTVerifysignandcertDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno(), pk.getProgrSignandcert() );
	}

}
