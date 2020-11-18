/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoImpianto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoImpianto2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipoImpianto2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoImpianto2015>, SiceeDTipoImpianto2015Dao
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
	 * @return SiceeDTipoImpianto2015Pk
	 */
	public SiceeDTipoImpianto2015Pk insert(SiceeDTipoImpianto2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_IMPIANTO, DESCR ) VALUES ( ?, ? )",dto.getIdTipoImpianto(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_IMPIANTO_2015 table.
	 */
	
	public void update(SiceeDTipoImpianto2015Pk pk, SiceeDTipoImpianto2015 dto) throws SiceeDTipoImpianto2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_IMPIANTO = ?, DESCR = ? WHERE ID_TIPO_IMPIANTO = ?",dto.getIdTipoImpianto(),dto.getDescr(),pk.getIdTipoImpianto());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_IMPIANTO_2015 table.
	 */
	
	public void delete(SiceeDTipoImpianto2015Pk pk) throws SiceeDTipoImpianto2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_IMPIANTO = ?",pk.getIdTipoImpianto());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoImpianto2015
	 */
	public SiceeDTipoImpianto2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoImpianto2015 dto = new SiceeDTipoImpianto2015();
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
		return "SICEE_D_TIPO_IMPIANTO_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 */
	
	public SiceeDTipoImpianto2015 findByPrimaryKey(Integer idTipoImpianto) throws SiceeDTipoImpianto2015DaoException
	{
		try {
			List<SiceeDTipoImpianto2015> list = jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_IMPIANTO = ?", this,idTipoImpianto);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpianto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDTipoImpianto2015> findAll() throws SiceeDTipoImpianto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " ORDER BY ID_TIPO_IMPIANTO", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpianto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 */
	public List<SiceeDTipoImpianto2015> findWhereIdTipoImpiantoEquals(Integer idTipoImpianto) throws SiceeDTipoImpianto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_IMPIANTO = ? ORDER BY ID_TIPO_IMPIANTO", this,idTipoImpianto);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpianto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipoImpianto2015> findWhereDescrEquals(String descr) throws SiceeDTipoImpianto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoImpianto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_IMPIANTO_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoImpianto2015 findByPrimaryKey(SiceeDTipoImpianto2015Pk pk) throws SiceeDTipoImpianto2015DaoException
	{
		return findByPrimaryKey( pk.getIdTipoImpianto() );
	}

}
