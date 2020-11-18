/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoRistrutt2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoRistrutt2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipoRistrutt2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoRistrutt2015>, SiceeDTipoRistrutt2015Dao
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
	 * @return SiceeDTipoRistrutt2015Pk
	 */
	
	public SiceeDTipoRistrutt2015Pk insert(SiceeDTipoRistrutt2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_RISTRUTTURAZ, DESCR ) VALUES ( ?, ? )",dto.getIdTipoRistrutturaz(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_RISTRUTT_2015 table.
	 */
	
	public void update(SiceeDTipoRistrutt2015Pk pk, SiceeDTipoRistrutt2015 dto) throws SiceeDTipoRistrutt2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_RISTRUTTURAZ = ?, DESCR = ? WHERE ID_TIPO_RISTRUTTURAZ = ?",dto.getIdTipoRistrutturaz(),dto.getDescr(),pk.getIdTipoRistrutturaz());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_RISTRUTT_2015 table.
	 */
	
	public void delete(SiceeDTipoRistrutt2015Pk pk) throws SiceeDTipoRistrutt2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_RISTRUTTURAZ = ?",pk.getIdTipoRistrutturaz());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoRistrutt2015
	 */
	public SiceeDTipoRistrutt2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoRistrutt2015 dto = new SiceeDTipoRistrutt2015();
		dto.setIdTipoRistrutturaz( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_TIPO_RISTRUTT_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria 'ID_TIPO_RISTRUTTURAZ = :idTipoRistrutturaz'.
	 */
	
	public SiceeDTipoRistrutt2015 findByPrimaryKey(Integer idTipoRistrutturaz) throws SiceeDTipoRistrutt2015DaoException
	{
		try {
			List<SiceeDTipoRistrutt2015> list = jdbcTemplate.query("SELECT ID_TIPO_RISTRUTTURAZ, DESCR FROM " + getTableName() + " WHERE ID_TIPO_RISTRUTTURAZ = ?", this,idTipoRistrutturaz);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoRistrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDTipoRistrutt2015> findAll() throws SiceeDTipoRistrutt2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_RISTRUTTURAZ, DESCR FROM " + getTableName() + " ORDER BY ID_TIPO_RISTRUTTURAZ", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoRistrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria 'ID_TIPO_RISTRUTTURAZ = :idTipoRistrutturaz'.
	 */
	
	public List<SiceeDTipoRistrutt2015> findWhereIdTipoRistrutturazEquals(Integer idTipoRistrutturaz) throws SiceeDTipoRistrutt2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_RISTRUTTURAZ, DESCR FROM " + getTableName() + " WHERE ID_TIPO_RISTRUTTURAZ = ? ORDER BY ID_TIPO_RISTRUTTURAZ", this,idTipoRistrutturaz);
		}
		catch (Exception e) {
			throw new SiceeDTipoRistrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoRistrutt2015> findWhereDescrEquals(String descr) throws SiceeDTipoRistrutt2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_RISTRUTTURAZ, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoRistrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_RISTRUTT_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoRistrutt2015 findByPrimaryKey(SiceeDTipoRistrutt2015Pk pk) throws SiceeDTipoRistrutt2015DaoException
	{
		return findByPrimaryKey( pk.getIdTipoRistrutturaz() );
	}

}
