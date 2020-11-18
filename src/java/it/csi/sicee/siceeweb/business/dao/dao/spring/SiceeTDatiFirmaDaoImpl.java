/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiFirmaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiFirma;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiFirmaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiFirmaDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDatiFirmaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDatiFirma>, SiceeTDatiFirmaDao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;
		
	

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
	 * @return SiceeTDatiFirmaPk
	 */
	
	public SiceeTDatiFirmaPk insert(SiceeTDatiFirma dto)
	{	
		dto.setIdDatiFirma(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdDatiFirma(),dto.getAnno(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getFkStatoFile(),dto.getErrorCode(),dto.getSurname(),dto.getGivenName(),dto.getSerialNumber(),dto.getCa(),dto.getCodiceFiscale(),dto.getDtFirma(),dto.getDtVerifica(),dto.getDtInizioValCert(),dto.getDtFineValCert(),dto.getProgrVerifyReport());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATI_FIRMA table.
	 */
	
	public void update(SiceeTDatiFirmaPk pk, SiceeTDatiFirma dto) throws SiceeTDatiFirmaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DATI_FIRMA = ?, ANNO = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, FK_STATO_FILE = ?, ERROR_CODE = ?, SURNAME = ?, GIVEN_NAME = ?, SERIAL_NUMBER = ?, CA = ?, CODICE_FISCALE = ?, DT_FIRMA = ?, DT_VERIFICA = ?, DT_INIZIO_VAL_CERT = ?, DT_FINE_VAL_CERT = ?, PROGR_VERIFY_REPORT = ? WHERE ID_DATI_FIRMA = ?",dto.getIdDatiFirma(),dto.getAnno(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getFkStatoFile(),dto.getErrorCode(),dto.getSurname(),dto.getGivenName(),dto.getSerialNumber(),dto.getCa(),dto.getCodiceFiscale(),dto.getDtFirma(),dto.getDtVerifica(),dto.getDtInizioValCert(),dto.getDtFineValCert(),dto.getProgrVerifyReport(),pk.getIdDatiFirma());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_FIRMA table.
	 */
	
	public void delete(SiceeTDatiFirmaPk pk) throws SiceeTDatiFirmaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DATI_FIRMA = ?",pk.getIdDatiFirma());
	}

	public void deleteBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiFirmaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ",idCertificatore,progrCertificato,anno);
	}
	
	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDatiFirma
	 */
	public SiceeTDatiFirma mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDatiFirma dto = new SiceeTDatiFirma();
		dto.setIdDatiFirma( new Integer( rs.getInt(1) ) );
		dto.setAnno( rs.getString( 2 ) );
		dto.setIdCertificatore( rs.getString( 3 ) );
		dto.setProgrCertificato( rs.getString( 4 ) );
		dto.setFkStatoFile( new Integer( rs.getInt(5) ) );
		dto.setErrorCode( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setErrorCode( null );
		}
		
		dto.setSurname( rs.getString( 7 ) );
		dto.setGivenName( rs.getString( 8 ) );
		dto.setSerialNumber( rs.getString( 9 ) );
		dto.setCa( rs.getString( 10 ) );
		dto.setCodiceFiscale( rs.getString( 11 ) );
		dto.setDtFirma( rs.getTimestamp(12 ) );
		dto.setDtVerifica( rs.getTimestamp(13 ) );
		dto.setDtInizioValCert( rs.getTimestamp(14 ) );
		dto.setDtFineValCert( rs.getTimestamp(15 ) );
		dto.setProgrVerifyReport( new Integer( rs.getInt(16) ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_DATI_FIRMA";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_DATI_FIRMA = :idDatiFirma'.
	 */
	
	public SiceeTDatiFirma findByPrimaryKey(Integer idDatiFirma) throws SiceeTDatiFirmaDaoException
	{
		try {
			List<SiceeTDatiFirma> list = jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE ID_DATI_FIRMA = ?", this,idDatiFirma);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'PROGR_UPLOAD = :progrUpload'.
	 */
	
	public List<SiceeTDatiFirma> findWhereProgrUploadEquals(Long progrUpload) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE PROGR_UPLOAD = ? ORDER BY PROGR_UPLOAD", this,progrUpload);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria ''.
	 */
	
	public List<SiceeTDatiFirma> findAll() throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " ORDER BY ID_DATI_FIRMA", this);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 */
	
	public List<SiceeTDatiFirma> findBySiceeTVerifyReport(String idCertificatore, String progrCertificato, String anno, Integer progrVerifyReport) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_VERIFY_REPORT = ?", this,idCertificatore,progrCertificato,anno,progrVerifyReport);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_DATI_FIRMA = :idDatiFirma'.
	 */
	
	public List<SiceeTDatiFirma> findWhereIdDatiFirmaEquals(Integer idDatiFirma) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE ID_DATI_FIRMA = ? ORDER BY ID_DATI_FIRMA", this,idDatiFirma);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDatiFirma> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTDatiFirma> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTDatiFirma> findWhereAnnoEquals(String anno) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 */
	
	public List<SiceeTDatiFirma> findWhereProgrVerifyReportEquals(Integer progrVerifyReport) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE PROGR_VERIFY_REPORT = ? ORDER BY PROGR_VERIFY_REPORT", this,progrVerifyReport);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'FK_STATO_FILE = :fkStatoFile'.
	 */
	
	public List<SiceeTDatiFirma> findWhereFkStatoFileEquals(Integer fkStatoFile) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE FK_STATO_FILE = ? ORDER BY FK_STATO_FILE", this,fkStatoFile);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'ERROR_CODE = :errorCode'.
	 */
	
	public List<SiceeTDatiFirma> findWhereErrorCodeEquals(Integer errorCode) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE ERROR_CODE = ? ORDER BY ERROR_CODE", this,errorCode);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'SURNAME = :surname'.
	 */
	
	public List<SiceeTDatiFirma> findWhereSurnameEquals(String surname) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE SURNAME = ? ORDER BY SURNAME", this,surname);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'GIVEN_NAME = :givenName'.
	 */
	
	public List<SiceeTDatiFirma> findWhereGivenNameEquals(String givenName) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE GIVEN_NAME = ? ORDER BY GIVEN_NAME", this,givenName);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'SERIAL_NUMBER = :serialNumber'.
	 */
	
	public List<SiceeTDatiFirma> findWhereSerialNumberEquals(String serialNumber) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE SERIAL_NUMBER = ? ORDER BY SERIAL_NUMBER", this,serialNumber);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'CA = :ca'.
	 */
	
	public List<SiceeTDatiFirma> findWhereCaEquals(String ca) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE CA = ? ORDER BY CA", this,ca);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 */
	
	public List<SiceeTDatiFirma> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE CODICE_FISCALE = ? ORDER BY CODICE_FISCALE", this,codiceFiscale);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_FIRMA = :dtFirma'.
	 */
	
	public List<SiceeTDatiFirma> findWhereDtFirmaEquals(Date dtFirma) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE DT_FIRMA = ? ORDER BY DT_FIRMA", this,dtFirma);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_VERIFICA = :dtVerifica'.
	 */
	
	public List<SiceeTDatiFirma> findWhereDtVerificaEquals(Date dtVerifica) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE DT_VERIFICA = ? ORDER BY DT_VERIFICA", this,dtVerifica);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_INIZIO_VAL_CERT = :dtInizioValCert'.
	 */
	
	public List<SiceeTDatiFirma> findWhereDtInizioValCertEquals(Date dtInizioValCert) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE DT_INIZIO_VAL_CERT = ? ORDER BY DT_INIZIO_VAL_CERT", this,dtInizioValCert);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_FIRMA table that match the criteria 'DT_FINE_VAL_CERT = :dtFineValCert'.
	 */
	
	public List<SiceeTDatiFirma> findWhereDtFineValCertEquals(Date dtFineValCert) throws SiceeTDatiFirmaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_FIRMA, ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_STATO_FILE, ERROR_CODE, SURNAME, GIVEN_NAME, SERIAL_NUMBER, CA, CODICE_FISCALE, DT_FIRMA, DT_VERIFICA, DT_INIZIO_VAL_CERT, DT_FINE_VAL_CERT, PROGR_VERIFY_REPORT FROM " + getTableName() + " WHERE DT_FINE_VAL_CERT = ? ORDER BY DT_FINE_VAL_CERT", this,dtFineValCert);
		}
		catch (Exception e) {
			throw new SiceeTDatiFirmaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DATI_FIRMA table that matches the specified primary-key value.
	 */
	public SiceeTDatiFirma findByPrimaryKey(SiceeTDatiFirmaPk pk) throws SiceeTDatiFirmaDaoException
	{
		return findByPrimaryKey( pk.getIdDatiFirma() );
	}

	
}
