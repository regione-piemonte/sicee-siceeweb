/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDNormativaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDNormativa;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDNormativaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDNormativaDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDNormativaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDNormativa>, SiceeDNormativaDao
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
	 * @return SiceeDNormativaPk
	 */
	
	public SiceeDNormativaPk insert(SiceeDNormativa dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_NORMA, DESCR, DT_INIZIO, DT_FINE ) VALUES ( ?, ?, ?, ? )",dto.getIdNorma(),dto.getDescr(),dto.getDtInizio(),dto.getDtFine());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_NORMATIVA table.
	 */
	
	public void update(SiceeDNormativaPk pk, SiceeDNormativa dto) throws SiceeDNormativaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_NORMA = ?, DESCR = ?, DT_INIZIO = ?, DT_FINE = ? WHERE ID_NORMA = ?",dto.getIdNorma(),dto.getDescr(),dto.getDtInizio(),dto.getDtFine(),pk.getIdNorma());
	}

	/** 
	 * Deletes a single row in the SICEE_D_NORMATIVA table.
	 */
	
	public void delete(SiceeDNormativaPk pk) throws SiceeDNormativaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_NORMA = ?",pk.getIdNorma());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDNormativa
	 */
	public SiceeDNormativa mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDNormativa dto = new SiceeDNormativa();
		dto.setIdNorma( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setDtInizio( rs.getTimestamp(3 ) );
		dto.setDtFine( rs.getTimestamp(4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_NORMATIVA";
	}

	/** 
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'ID_NORMA = :idNorma'.
	 */
	
	public SiceeDNormativa findByPrimaryKey(Integer idNorma) throws SiceeDNormativaDaoException
	{
		try {
			List<SiceeDNormativa> list = jdbcTemplate.query("SELECT ID_NORMA, DESCR, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE ID_NORMA = ?", this,idNorma);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDNormativaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria ''.
	 */
	
	public List<SiceeDNormativa> findAll() throws SiceeDNormativaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_NORMA, DESCR, DT_INIZIO, DT_FINE FROM " + getTableName() + " ORDER BY ID_NORMA", this);
		}
		catch (Exception e) {
			throw new SiceeDNormativaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'ID_NORMA = :idNorma'.
	 */
	
	public List<SiceeDNormativa> findWhereIdNormaEquals(Integer idNorma) throws SiceeDNormativaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_NORMA, DESCR, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE ID_NORMA = ? ORDER BY ID_NORMA", this,idNorma);
		}
		catch (Exception e) {
			throw new SiceeDNormativaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDNormativa> findWhereDescrEquals(String descr) throws SiceeDNormativaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_NORMA, DESCR, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDNormativaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'DT_INIZIO = :dtInizio'.
	 */
	
	public List<SiceeDNormativa> findWhereDtInizioEquals(Date dtInizio) throws SiceeDNormativaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_NORMA, DESCR, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DT_INIZIO = ? ORDER BY DT_INIZIO", this,dtInizio);
		}
		catch (Exception e) {
			throw new SiceeDNormativaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'DT_FINE = :dtFine'.
	 */
	
	public List<SiceeDNormativa> findWhereDtFineEquals(Date dtFine) throws SiceeDNormativaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_NORMA, DESCR, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DT_FINE = ? ORDER BY DT_FINE", this,dtFine);
		}
		catch (Exception e) {
			throw new SiceeDNormativaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria ':date BETWEEN DT_INIZIO AND DT_FINE'.
	 */
	
	public SiceeDNormativa findWhereDtInizioBetweenDtFine(Date date) throws SiceeDNormativaDaoException
	{
		try {
			List<SiceeDNormativa> list = jdbcTemplate.query("SELECT ID_NORMA, DESCR, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE ? BETWEEN DT_INIZIO AND DT_FINE", this,date);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDNormativaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_NORMATIVA table that matches the specified primary-key value.
	 */
	public SiceeDNormativa findByPrimaryKey(SiceeDNormativaPk pk) throws SiceeDNormativaDaoException
	{
		return findByPrimaryKey( pk.getIdNorma() );
	}

}
