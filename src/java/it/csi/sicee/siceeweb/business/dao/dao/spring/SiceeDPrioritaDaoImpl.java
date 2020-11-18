/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDPrioritaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDPriorita;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDPrioritaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDPrioritaDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDPrioritaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDPriorita>, SiceeDPrioritaDao
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
	 * @return SiceeDPrioritaPk
	 */
	
	public SiceeDPrioritaPk insert(SiceeDPriorita dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( PRIORITA, DESCR ) VALUES ( ?, ? )",dto.getPriorita(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_PRIORITA table.
	 */
	
	public void update(SiceeDPrioritaPk pk, SiceeDPriorita dto) throws SiceeDPrioritaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET PRIORITA = ?, DESCR = ? WHERE PRIORITA = ?",dto.getPriorita(),dto.getDescr(),pk.getPriorita());
	}

	/** 
	 * Deletes a single row in the SICEE_D_PRIORITA table.
	 */
	
	public void delete(SiceeDPrioritaPk pk) throws SiceeDPrioritaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE PRIORITA = ?",pk.getPriorita());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDPriorita
	 */
	public SiceeDPriorita mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDPriorita dto = new SiceeDPriorita();
		dto.setPriorita( rs.getString( 1 ) );
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
		return "SICEE_D_PRIORITA";
	}

	/** 
	 * Returns all rows from the SICEE_D_PRIORITA table that match the criteria 'PRIORITA = :priorita'.
	 */
	
	public SiceeDPriorita findByPrimaryKey(String priorita) throws SiceeDPrioritaDaoException
	{
		try {
			List<SiceeDPriorita> list = jdbcTemplate.query("SELECT PRIORITA, DESCR FROM " + getTableName() + " WHERE PRIORITA = ?", this,priorita);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDPrioritaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_PRIORITA table that match the criteria ''.
	 */
	
	public List<SiceeDPriorita> findAll() throws SiceeDPrioritaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PRIORITA, DESCR FROM " + getTableName() + " ORDER BY PRIORITA", this);
		}
		catch (Exception e) {
			throw new SiceeDPrioritaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_PRIORITA table that match the criteria 'PRIORITA = :priorita'.
	 */
	
	public List<SiceeDPriorita> findWherePrioritaEquals(String priorita) throws SiceeDPrioritaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT PRIORITA, DESCR FROM " + getTableName() + " WHERE PRIORITA = ? ORDER BY PRIORITA", this,priorita);
		}
		catch (Exception e) {
			throw new SiceeDPrioritaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_PRIORITA table that matches the specified primary-key value.
	 */
	public SiceeDPriorita findByPrimaryKey(SiceeDPrioritaPk pk) throws SiceeDPrioritaDaoException
	{
		return findByPrimaryKey( pk.getPriorita() );
	}

}
