/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDZonaClimatica2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDZonaClimatica2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDZonaClimatica2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDZonaClimatica2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDZonaClimatica2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDZonaClimatica2015>, SiceeDZonaClimatica2015Dao
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
	 * @return SiceeDZonaClimatica2015Pk
	 */
	
	public SiceeDZonaClimatica2015Pk insert(SiceeDZonaClimatica2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( COD_ZONA ) VALUES ( ? )",dto.getCodZona());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_ZONA_CLIMATICA_2015 table.
	 */
	
	public void update(SiceeDZonaClimatica2015Pk pk, SiceeDZonaClimatica2015 dto) throws SiceeDZonaClimatica2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET COD_ZONA = ? WHERE COD_ZONA = ?",dto.getCodZona(),pk.getCodZona());
	}

	/** 
	 * Deletes a single row in the SICEE_D_ZONA_CLIMATICA_2015 table.
	 */
	
	public void delete(SiceeDZonaClimatica2015Pk pk) throws SiceeDZonaClimatica2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE COD_ZONA = ?",pk.getCodZona());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDZonaClimatica2015
	 */
	public SiceeDZonaClimatica2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDZonaClimatica2015 dto = new SiceeDZonaClimatica2015();
		dto.setCodZona( rs.getString( 1 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_ZONA_CLIMATICA_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_ZONA_CLIMATICA_2015 table that match the criteria 'COD_ZONA = :codZona'.
	 */
	
	public SiceeDZonaClimatica2015 findByPrimaryKey(String codZona) throws SiceeDZonaClimatica2015DaoException
	{
		try {
			List<SiceeDZonaClimatica2015> list = jdbcTemplate.query("SELECT COD_ZONA FROM " + getTableName() + " WHERE COD_ZONA = ?", this,codZona);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDZonaClimatica2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ZONA_CLIMATICA_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDZonaClimatica2015> findAll() throws SiceeDZonaClimatica2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT COD_ZONA FROM " + getTableName() + " ORDER BY COD_ZONA", this);
		}
		catch (Exception e) {
			throw new SiceeDZonaClimatica2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ZONA_CLIMATICA_2015 table that match the criteria 'COD_ZONA = :codZona'.
	 */
	
	public List<SiceeDZonaClimatica2015> findWhereCodZonaEquals(String codZona) throws SiceeDZonaClimatica2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT COD_ZONA FROM " + getTableName() + " WHERE COD_ZONA = ? ORDER BY COD_ZONA", this,codZona);
		}
		catch (Exception e) {
			throw new SiceeDZonaClimatica2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_ZONA_CLIMATICA_2015 table that matches the specified primary-key value.
	 */
	public SiceeDZonaClimatica2015 findByPrimaryKey(SiceeDZonaClimatica2015Pk pk) throws SiceeDZonaClimatica2015DaoException
	{
		return findByPrimaryKey( pk.getCodZona() );
	}

}
