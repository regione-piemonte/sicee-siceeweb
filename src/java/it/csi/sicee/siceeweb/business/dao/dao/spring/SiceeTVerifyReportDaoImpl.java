/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifyReportDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReport;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReportPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTVerifyReportDaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTVerifyReportDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTVerifyReport>, SiceeTVerifyReportDao
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
	 * @return SiceeTVerifyReportPk
	 */
	
	public SiceeTVerifyReportPk insert(SiceeTVerifyReport dto)
	{		
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getProgrVerifyReport(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getParametriInput(),dto.getFormatoFirma(),dto.getTipoFirma(),dto.getNumCertificatiFirma(),dto.getNumMarche());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_VERIFY_REPORT table.
	 */
	
	public void update(SiceeTVerifyReportPk pk, SiceeTVerifyReport dto) throws SiceeTVerifyReportDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET PROGR_VERIFY_REPORT = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, PARAMETRI_INPUT = ?, FORMATO_FIRMA = ?, TIPO_FIRMA = ?, NUM_CERTIFICATI_FIRMA = ?, NUM_MARCHE = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_VERIFY_REPORT = ?",dto.getProgrVerifyReport(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getParametriInput(),dto.getFormatoFirma(),dto.getTipoFirma(),dto.getNumCertificatiFirma(),dto.getNumMarche(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getProgrVerifyReport());
	}

	/** 
	 * Deletes a single row in the SICEE_T_VERIFY_REPORT table.
	 */
	
	public void delete(SiceeTVerifyReportPk pk) throws SiceeTVerifyReportDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_VERIFY_REPORT = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getProgrVerifyReport());
	}
	
	public void deleteBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTVerifyReportDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ",idCertificatore,progrCertificato,anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTVerifyReport
	 */
	public SiceeTVerifyReport mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTVerifyReport dto = new SiceeTVerifyReport();
		dto.setProgrVerifyReport( new Integer( rs.getInt(1) ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setParametriInput( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setParametriInput( null );
		}
		
		dto.setFormatoFirma( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setFormatoFirma( null );
		}
		
		dto.setTipoFirma( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setTipoFirma( null );
		}
		
		dto.setNumCertificatiFirma( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setNumCertificatiFirma( null );
		}
		
		dto.setNumMarche( new Integer( rs.getInt(9) ) );
		if (rs.wasNull()) {
			dto.setNumMarche( null );
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
		return "SICEE_T_VERIFY_REPORT";
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 */
	
	public SiceeTVerifyReport findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer progrVerifyReport) throws SiceeTVerifyReportDaoException
	{
		try {
			List<SiceeTVerifyReport> list = jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PROGR_VERIFY_REPORT = ?", this,idCertificatore,progrCertificato,anno,progrVerifyReport);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria ''.
	 */
	
	public List<SiceeTVerifyReport> findAll() throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PROGR_VERIFY_REPORT", this);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'PROGR_VERIFY_REPORT = :progrVerifyReport'.
	 */
	
	public List<SiceeTVerifyReport> findWhereProgrVerifyReportEquals(Integer progrVerifyReport) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE PROGR_VERIFY_REPORT = ? ORDER BY PROGR_VERIFY_REPORT", this,progrVerifyReport);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTVerifyReport> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTVerifyReport> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTVerifyReport> findWhereAnnoEquals(String anno) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'PARAMETRI_INPUT = :parametriInput'.
	 */
	
	public List<SiceeTVerifyReport> findWhereParametriInputEquals(Integer parametriInput) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE PARAMETRI_INPUT = ? ORDER BY PARAMETRI_INPUT", this,parametriInput);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'FORMATO_FIRMA = :formatoFirma'.
	 */
	
	public List<SiceeTVerifyReport> findWhereFormatoFirmaEquals(Integer formatoFirma) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE FORMATO_FIRMA = ? ORDER BY FORMATO_FIRMA", this,formatoFirma);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'TIPO_FIRMA = :tipoFirma'.
	 */
	
	public List<SiceeTVerifyReport> findWhereTipoFirmaEquals(Integer tipoFirma) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE TIPO_FIRMA = ? ORDER BY TIPO_FIRMA", this,tipoFirma);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'NUM_CERTIFICATI_FIRMA = :numCertificatiFirma'.
	 */
	
	public List<SiceeTVerifyReport> findWhereNumCertificatiFirmaEquals(Integer numCertificatiFirma) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE NUM_CERTIFICATI_FIRMA = ? ORDER BY NUM_CERTIFICATI_FIRMA", this,numCertificatiFirma);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_VERIFY_REPORT table that match the criteria 'NUM_MARCHE = :numMarche'.
	 */
	
	public List<SiceeTVerifyReport> findWhereNumMarcheEquals(Integer numMarche) throws SiceeTVerifyReportDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PROGR_VERIFY_REPORT, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PARAMETRI_INPUT, FORMATO_FIRMA, TIPO_FIRMA, NUM_CERTIFICATI_FIRMA, NUM_MARCHE FROM " + getTableName() + " WHERE NUM_MARCHE = ? ORDER BY NUM_MARCHE", this,numMarche);
		}
		catch (Exception e) {
			throw new SiceeTVerifyReportDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_VERIFY_REPORT table that matches the specified primary-key value.
	 */
	public SiceeTVerifyReport findByPrimaryKey(SiceeTVerifyReportPk pk) throws SiceeTVerifyReportDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno(), pk.getProgrVerifyReport() );
	}

}
