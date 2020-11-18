/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoCertDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoCert;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoCertPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoCertDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDStatoCertDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDStatoCert>, SiceeDStatoCertDao
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
	 * @return SiceeDStatoCertPk
	 */
	
	public SiceeDStatoCertPk insert(SiceeDStatoCert dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_STATO, DESCR ) VALUES ( ?, ? )",dto.getIdStato(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_STATO_CERT table.
	 */
	
	public void update(SiceeDStatoCertPk pk, SiceeDStatoCert dto) throws SiceeDStatoCertDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_STATO = ?, DESCR = ? WHERE ID_STATO = ?",dto.getIdStato(),dto.getDescr(),pk.getIdStato());
	}

	/** 
	 * Deletes a single row in the SICEE_D_STATO_CERT table.
	 */
	
	public void delete(SiceeDStatoCertPk pk) throws SiceeDStatoCertDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_STATO = ?",pk.getIdStato());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDStatoCert
	 */
	public SiceeDStatoCert mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDStatoCert dto = new SiceeDStatoCert();
		dto.setIdStato( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_STATO_CERT";
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria 'ID_STATO = :idStato'.
	 */
	
	public SiceeDStatoCert findByPrimaryKey(Integer idStato) throws SiceeDStatoCertDaoException
	{
		try {
			List<SiceeDStatoCert> list = jdbcTemplate.query("SELECT ID_STATO, DESCR FROM " + getTableName() + " WHERE ID_STATO = ?", this,idStato);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDStatoCertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria ''.
	 */
	
	public List<SiceeDStatoCert> findAll() throws SiceeDStatoCertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO, DESCR FROM " + getTableName() + " ORDER BY ID_STATO", this);
		}
		catch (Exception e) {
			throw new SiceeDStatoCertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria 'ID_STATO = :idStato'.
	 */
	
	public List<SiceeDStatoCert> findWhereIdStatoEquals(Integer idStato) throws SiceeDStatoCertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO, DESCR FROM " + getTableName() + " WHERE ID_STATO = ? ORDER BY ID_STATO", this,idStato);
		}
		catch (Exception e) {
			throw new SiceeDStatoCertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDStatoCert> findWhereDescrEquals(String descr) throws SiceeDStatoCertDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDStatoCertDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_STATO_CERT table that matches the specified primary-key value.
	 */
	public SiceeDStatoCert findByPrimaryKey(SiceeDStatoCertPk pk) throws SiceeDStatoCertDaoException
	{
		return findByPrimaryKey( pk.getIdStato() );
	}

}
