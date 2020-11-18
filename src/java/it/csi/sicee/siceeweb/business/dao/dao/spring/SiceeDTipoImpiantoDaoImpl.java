/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoImpiantoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpiantoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoImpiantoDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDTipoImpiantoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoImpianto>, SiceeDTipoImpiantoDao
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
	 * @return SiceeDTipoImpiantoPk
	 */
	
	public SiceeDTipoImpiantoPk insert(SiceeDTipoImpianto dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_IMPIANTO, DESCR ) VALUES ( ?, ? )",dto.getIdTipoImpianto(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_IMPIANTO table.
	 */
	
	public void update(SiceeDTipoImpiantoPk pk, SiceeDTipoImpianto dto) throws SiceeDTipoImpiantoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_IMPIANTO = ?, DESCR = ? WHERE ID_TIPO_IMPIANTO = ?",dto.getIdTipoImpianto(),dto.getDescr(),pk.getIdTipoImpianto());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_IMPIANTO table.
	 */
	
	public void delete(SiceeDTipoImpiantoPk pk) throws SiceeDTipoImpiantoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_IMPIANTO = ?",pk.getIdTipoImpianto());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoImpianto
	 */
	public SiceeDTipoImpianto mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoImpianto dto = new SiceeDTipoImpianto();
		dto.setIdTipoImpianto( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_TIPO_IMPIANTO";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 */
	
	public SiceeDTipoImpianto findByPrimaryKey(Integer idTipoImpianto) throws SiceeDTipoImpiantoDaoException
	{
		try {
			List<SiceeDTipoImpianto> list = jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_IMPIANTO = ?", this,idTipoImpianto);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpiantoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria ''.
	 */
	
	public List<SiceeDTipoImpianto> findAll() throws SiceeDTipoImpiantoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " ORDER BY ID_TIPO_IMPIANTO", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpiantoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 */
	
	public List<SiceeDTipoImpianto> findWhereIdTipoImpiantoEquals(Integer idTipoImpianto) throws SiceeDTipoImpiantoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_IMPIANTO = ? ORDER BY ID_TIPO_IMPIANTO", this,idTipoImpianto);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpiantoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoImpianto> findWhereDescrEquals(String descr) throws SiceeDTipoImpiantoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpiantoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_IMPIANTO table that matches the specified primary-key value.
	 */
	public SiceeDTipoImpianto findByPrimaryKey(SiceeDTipoImpiantoPk pk) throws SiceeDTipoImpiantoDaoException
	{
		return findByPrimaryKey( pk.getIdTipoImpianto() );
	}

}
