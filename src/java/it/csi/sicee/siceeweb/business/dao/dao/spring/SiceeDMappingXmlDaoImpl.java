/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMappingXmlDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMappingXml;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMappingXmlDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDMappingXmlDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDMappingXml>, SiceeDMappingXmlDao
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
	 */
	
	public void insert(SiceeDMappingXml dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( CAMPO_XML, CAMPO_WEB ) VALUES ( ?, ? )",dto.getCampoXml(),dto.getCampoWeb());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDMappingXml
	 */
	public SiceeDMappingXml mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDMappingXml dto = new SiceeDMappingXml();
		dto.setCampoXml( rs.getString( 1 ) );
		dto.setCampoWeb( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_MAPPING_XML";
	}

	/** 
	 * Returns all rows from the SICEE_D_MAPPING_XML table that match the criteria ''.
	 */
	
	public List<SiceeDMappingXml> findAll() throws SiceeDMappingXmlDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CAMPO_XML, CAMPO_WEB FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new SiceeDMappingXmlDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MAPPING_XML table that match the criteria 'CAMPO_XML = :campoXml'.
	 */
	
	public SiceeDMappingXml findWhereCampoXmlEquals(String campoXml) throws SiceeDMappingXmlDaoException
	{
		try {
			List<SiceeDMappingXml> list = jdbcTemplate.query("SELECT CAMPO_XML, CAMPO_WEB FROM " + getTableName() + " WHERE CAMPO_XML = ?", this,campoXml);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDMappingXmlDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MAPPING_XML table that match the criteria 'CAMPO_WEB = :campoWeb'.
	 */
	
	public SiceeDMappingXml findWhereCampoWebEquals(String campoWeb) throws SiceeDMappingXmlDaoException
	{
		try {
			List<SiceeDMappingXml> list = jdbcTemplate.query("SELECT CAMPO_XML, CAMPO_WEB FROM " + getTableName() + " WHERE CAMPO_WEB = ?", this,campoWeb);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDMappingXmlDaoException("Query failed", e);
		}
		
	}

}
