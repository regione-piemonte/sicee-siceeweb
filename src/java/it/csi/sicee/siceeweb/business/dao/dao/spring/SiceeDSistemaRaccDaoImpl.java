/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDSistemaRaccDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDSistemaRacc;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDSistemaRaccPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDSistemaRaccDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDSistemaRaccDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDSistemaRacc>, SiceeDSistemaRaccDao
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
	 * @return SiceeDSistemaRaccPk
	 */
	
	public SiceeDSistemaRaccPk insert(SiceeDSistemaRacc dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( SISTEMA ) VALUES ( ? )",dto.getSistema());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_SISTEMA_RACC table.
	 */
	
	public void update(SiceeDSistemaRaccPk pk, SiceeDSistemaRacc dto) throws SiceeDSistemaRaccDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET SISTEMA = ? WHERE SISTEMA = ?",dto.getSistema(),pk.getSistema());
	}

	/** 
	 * Deletes a single row in the SICEE_D_SISTEMA_RACC table.
	 */
	
	public void delete(SiceeDSistemaRaccPk pk) throws SiceeDSistemaRaccDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE SISTEMA = ?",pk.getSistema());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDSistemaRacc
	 */
	public SiceeDSistemaRacc mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDSistemaRacc dto = new SiceeDSistemaRacc();
		dto.setSistema( rs.getString( 1 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_SISTEMA_RACC";
	}

	/** 
	 * Returns all rows from the SICEE_D_SISTEMA_RACC table that match the criteria 'SISTEMA = :sistema'.
	 */
	
	public SiceeDSistemaRacc findByPrimaryKey(String sistema) throws SiceeDSistemaRaccDaoException
	{
		try {
			List<SiceeDSistemaRacc> list = jdbcTemplate.query("SELECT SISTEMA FROM " + getTableName() + " WHERE SISTEMA = ?", this,sistema);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDSistemaRaccDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_SISTEMA_RACC table that match the criteria ''.
	 */
	
	public List<SiceeDSistemaRacc> findAll() throws SiceeDSistemaRaccDaoException
	{
		try {
			return jdbcTemplate.query("SELECT SISTEMA FROM " + getTableName() + " ORDER BY SISTEMA", this);
		}
		catch (Exception e) {
			throw new SiceeDSistemaRaccDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_SISTEMA_RACC table that match the criteria 'SISTEMA = :sistema'.
	 */
	
	public List<SiceeDSistemaRacc> findWhereSistemaEquals(String sistema) throws SiceeDSistemaRaccDaoException
	{
		try {
			return jdbcTemplate.query("SELECT SISTEMA FROM " + getTableName() + " WHERE SISTEMA = ? ORDER BY SISTEMA", this,sistema);
		}
		catch (Exception e) {
			throw new SiceeDSistemaRaccDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_SISTEMA_RACC table that matches the specified primary-key value.
	 */
	public SiceeDSistemaRacc findByPrimaryKey(SiceeDSistemaRaccPk pk) throws SiceeDSistemaRaccDaoException
	{
		return findByPrimaryKey( pk.getSistema() );
	}

}
