/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDichiarazioneDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDichiarazioneDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDDichiarazioneDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDDichiarazione>, SiceeDDichiarazioneDao
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
	 * @return SiceeDDichiarazionePk
	 */
	
	public SiceeDDichiarazionePk insert(SiceeDDichiarazione dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DICHIARAZIONE, DESCR ) VALUES ( ?, ? )",dto.getIdDichiarazione(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_DICHIARAZIONE table.
	 */
	
	public void update(SiceeDDichiarazionePk pk, SiceeDDichiarazione dto) throws SiceeDDichiarazioneDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DICHIARAZIONE = ?, DESCR = ? WHERE ID_DICHIARAZIONE = ?",dto.getIdDichiarazione(),dto.getDescr(),pk.getIdDichiarazione());
	}

	/** 
	 * Deletes a single row in the SICEE_D_DICHIARAZIONE table.
	 */
	
	public void delete(SiceeDDichiarazionePk pk) throws SiceeDDichiarazioneDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DICHIARAZIONE = ?",pk.getIdDichiarazione());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDDichiarazione
	 */
	public SiceeDDichiarazione mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDDichiarazione dto = new SiceeDDichiarazione();
		dto.setIdDichiarazione( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_DICHIARAZIONE";
	}

	/** 
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria 'ID_DICHIARAZIONE = :idDichiarazione'.
	 */
	
	public SiceeDDichiarazione findByPrimaryKey(Integer idDichiarazione) throws SiceeDDichiarazioneDaoException
	{
		try {
			List<SiceeDDichiarazione> list = jdbcTemplate.query("SELECT ID_DICHIARAZIONE, DESCR FROM " + getTableName() + " WHERE ID_DICHIARAZIONE = ?", this,idDichiarazione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDDichiarazioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria ''.
	 */
	
	public List<SiceeDDichiarazione> findAll() throws SiceeDDichiarazioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DICHIARAZIONE, DESCR FROM " + getTableName() + " ORDER BY ID_DICHIARAZIONE", this);
		}
		catch (Exception e) {
			throw new SiceeDDichiarazioneDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria.
	 */
	
	public List<SiceeDDichiarazione> findWhereIdDichiarazioneNew() throws SiceeDDichiarazioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DICHIARAZIONE, DESCR FROM " + getTableName() + " WHERE ID_DICHIARAZIONE >= "+it.csi.sicee.siceeweb.util.Constants.ID_DICHIARAZIONE_NEW+" ORDER BY ID_DICHIARAZIONE", this);
		}
		catch (Exception e) {
			throw new SiceeDDichiarazioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria 'ID_DICHIARAZIONE = :idDichiarazione'.
	 */
	
	public List<SiceeDDichiarazione> findWhereIdDichiarazioneEquals(Integer idDichiarazione) throws SiceeDDichiarazioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DICHIARAZIONE, DESCR FROM " + getTableName() + " WHERE ID_DICHIARAZIONE = ? ORDER BY ID_DICHIARAZIONE", this,idDichiarazione);
		}
		catch (Exception e) {
			throw new SiceeDDichiarazioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDDichiarazione> findWhereDescrEquals(String descr) throws SiceeDDichiarazioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DICHIARAZIONE, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDDichiarazioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_DICHIARAZIONE table that matches the specified primary-key value.
	 */
	public SiceeDDichiarazione findByPrimaryKey(SiceeDDichiarazionePk pk) throws SiceeDDichiarazioneDaoException
	{
		return findByPrimaryKey( pk.getIdDichiarazione() );
	}

}
