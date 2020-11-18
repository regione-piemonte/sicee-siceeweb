/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipolEdilizia2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipolEdilizia2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipolEdilizia2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipolEdilizia2015>, SiceeDTipolEdilizia2015Dao
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
	 * @return SiceeDTipolEdilizia2015Pk
	 */
	
	public SiceeDTipolEdilizia2015Pk insert(SiceeDTipolEdilizia2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPOL_EDILIZIA, DESCR ) VALUES ( ?, ? )",dto.getIdTipolEdilizia(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPOL_EDILIZIA_2015 table.
	 */
	
	public void update(SiceeDTipolEdilizia2015Pk pk, SiceeDTipolEdilizia2015 dto) throws SiceeDTipolEdilizia2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPOL_EDILIZIA = ?, DESCR = ? WHERE ID_TIPOL_EDILIZIA = ?",dto.getIdTipolEdilizia(),dto.getDescr(),pk.getIdTipolEdilizia());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPOL_EDILIZIA_2015 table.
	 */
	
	public void delete(SiceeDTipolEdilizia2015Pk pk) throws SiceeDTipolEdilizia2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPOL_EDILIZIA = ?",pk.getIdTipolEdilizia());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipolEdilizia2015
	 */
	public SiceeDTipolEdilizia2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipolEdilizia2015 dto = new SiceeDTipolEdilizia2015();
		dto.setIdTipolEdilizia( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_TIPOL_EDILIZIA_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria 'ID_TIPOL_EDILIZIA = :idTipolEdilizia'.
	 */
	
	public SiceeDTipolEdilizia2015 findByPrimaryKey(Integer idTipolEdilizia) throws SiceeDTipolEdilizia2015DaoException
	{
		try {
			List<SiceeDTipolEdilizia2015> list = jdbcTemplate.query("SELECT ID_TIPOL_EDILIZIA, DESCR FROM " + getTableName() + " WHERE ID_TIPOL_EDILIZIA = ?", this,idTipolEdilizia);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipolEdilizia2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDTipolEdilizia2015> findAll() throws SiceeDTipolEdilizia2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPOL_EDILIZIA, DESCR FROM " + getTableName() + " ORDER BY ID_TIPOL_EDILIZIA", this);
		}
		catch (Exception e) {
			throw new SiceeDTipolEdilizia2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria 'ID_TIPOL_EDILIZIA = :idTipolEdilizia'.
	 */
	
	public List<SiceeDTipolEdilizia2015> findWhereIdTipolEdiliziaEquals(Integer idTipolEdilizia) throws SiceeDTipolEdilizia2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPOL_EDILIZIA, DESCR FROM " + getTableName() + " WHERE ID_TIPOL_EDILIZIA = ? ORDER BY ID_TIPOL_EDILIZIA", this,idTipolEdilizia);
		}
		catch (Exception e) {
			throw new SiceeDTipolEdilizia2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipolEdilizia2015> findWhereDescrEquals(String descr) throws SiceeDTipolEdilizia2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPOL_EDILIZIA, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipolEdilizia2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipolEdilizia2015 findByPrimaryKey(SiceeDTipolEdilizia2015Pk pk) throws SiceeDTipolEdilizia2015DaoException
	{
		return findByPrimaryKey( pk.getIdTipolEdilizia() );
	}

}
