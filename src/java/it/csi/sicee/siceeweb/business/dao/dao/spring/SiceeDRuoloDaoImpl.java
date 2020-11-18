/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRuoloDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuolo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDRuoloDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDRuoloDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDRuolo>, SiceeDRuoloDao
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
	 * @return SiceeDRuoloPk
	 */
	
	public SiceeDRuoloPk insert(SiceeDRuolo dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_RUOLO, DESCR ) VALUES ( ?, ? )",dto.getIdTipoRuolo(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_RUOLO table.
	 */
	
	public void update(SiceeDRuoloPk pk, SiceeDRuolo dto) throws SiceeDRuoloDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_RUOLO = ?, DESCR = ? WHERE ID_TIPO_RUOLO = ?",dto.getIdTipoRuolo(),dto.getDescr(),pk.getIdTipoRuolo());
	}

	/** 
	 * Deletes a single row in the SICEE_D_RUOLO table.
	 */
	
	public void delete(SiceeDRuoloPk pk) throws SiceeDRuoloDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_RUOLO = ?",pk.getIdTipoRuolo());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDRuolo
	 */
	public SiceeDRuolo mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDRuolo dto = new SiceeDRuolo();
		dto.setIdTipoRuolo( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_RUOLO";
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria 'ID_TIPO_RUOLO = :idTipoRuolo'.
	 */
	
	public SiceeDRuolo findByPrimaryKey(Integer idTipoRuolo) throws SiceeDRuoloDaoException
	{
		try {
			List<SiceeDRuolo> list = jdbcTemplate.query("SELECT ID_TIPO_RUOLO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_RUOLO = ?", this,idTipoRuolo);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDRuoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria ''.
	 */
	
	public List<SiceeDRuolo> findAll() throws SiceeDRuoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_RUOLO, DESCR FROM " + getTableName() + " ORDER BY ID_TIPO_RUOLO", this);
		}
		catch (Exception e) {
			throw new SiceeDRuoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria 'ID_TIPO_RUOLO = :idTipoRuolo'.
	 */
	
	public List<SiceeDRuolo> findWhereIdTipoRuoloEquals(Integer idTipoRuolo) throws SiceeDRuoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_RUOLO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_RUOLO = ? ORDER BY ID_TIPO_RUOLO", this,idTipoRuolo);
		}
		catch (Exception e) {
			throw new SiceeDRuoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDRuolo> findWhereDescrEquals(String descr) throws SiceeDRuoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_RUOLO, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDRuoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_RUOLO table that matches the specified primary-key value.
	 */
	public SiceeDRuolo findByPrimaryKey(SiceeDRuoloPk pk) throws SiceeDRuoloDaoException
	{
		return findByPrimaryKey( pk.getIdTipoRuolo() );
	}

}
