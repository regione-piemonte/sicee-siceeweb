/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeLHashXmlImportDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeLHashXmlImport;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeLHashXmlImportPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeLHashXmlImportDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDaticatastSecDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTFoto2015DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeLHashXmlImportDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeLHashXmlImport>, SiceeLHashXmlImportDao
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
	 * @return SiceeTFoto2015Pk
	 */
	
	public SiceeLHashXmlImportPk insert(SiceeLHashXmlImport dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DATA_IMPORT, HASH_FILE, HASH_MATCH ) VALUES ( ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDataImport(),dto.getHashFile(),dto.getHashMatch());
		return dto.createPk();
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTFoto2015
	 */
	public SiceeLHashXmlImport mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeLHashXmlImport dto = new SiceeLHashXmlImport();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setDataImport( rs.getTimestamp(4 ) );
		dto.setHashFile( rs.getString( 5 ) );
		dto.setHashMatch( rs.getString( 6 ) );
		return dto;
	}
	
	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_L_HASH_XML_IMPORT";
	}

	
	/** 
	 * Returns all rows from the SICEE_L_HASH_XML_IMPORT table that match the criteria ''.
	 */
	
	public List<SiceeLHashXmlImport> findAll() throws SiceeLHashXmlImportDaoException
	{
		try {
			return jdbcTemplate.query("ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DATA_IMPORT, HASH_FILE, HASH_MATCH FROM " + getTableName() + " ORDER BY DATA_IMPORT", this);
		}
		catch (Exception e) {
			throw new SiceeLHashXmlImportDaoException("Query failed", e);
		}
		
	}


	/** 
	 * Returns the rows from the SICEE_L_HASH_XML_IMPORT table that matches the specified primary-key value.
	 */
	public SiceeLHashXmlImport findByPrimaryKey(SiceeLHashXmlImportPk pk) throws SiceeLHashXmlImportDaoException
	{
		return findByPrimaryKey( pk );
	}

}
