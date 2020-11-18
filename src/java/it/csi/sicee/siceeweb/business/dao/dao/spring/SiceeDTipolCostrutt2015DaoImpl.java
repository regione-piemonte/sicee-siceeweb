/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipolCostrutt2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipolCostrutt2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipolCostrutt2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipolCostrutt2015>, SiceeDTipolCostrutt2015Dao
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
	 * @return SiceeDTipolCostrutt2015Pk
	 */
	
	public SiceeDTipolCostrutt2015Pk insert(SiceeDTipolCostrutt2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPOL_COSTRUTT, DESCR ) VALUES ( ?, ? )",dto.getIdTipolCostrutt(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPOL_COSTRUTT_2015 table.
	 */
	
	public void update(SiceeDTipolCostrutt2015Pk pk, SiceeDTipolCostrutt2015 dto) throws SiceeDTipolCostrutt2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPOL_COSTRUTT = ?, DESCR = ? WHERE ID_TIPOL_COSTRUTT = ?",dto.getIdTipolCostrutt(),dto.getDescr(),pk.getIdTipolCostrutt());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPOL_COSTRUTT_2015 table.
	 */
	
	public void delete(SiceeDTipolCostrutt2015Pk pk) throws SiceeDTipolCostrutt2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPOL_COSTRUTT = ?",pk.getIdTipolCostrutt());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipolCostrutt2015
	 */
	public SiceeDTipolCostrutt2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipolCostrutt2015 dto = new SiceeDTipolCostrutt2015();
		dto.setIdTipolCostrutt( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_TIPOL_COSTRUTT_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria 'ID_TIPOL_COSTRUTT = :idTipolCostrutt'.
	 */
	
	public SiceeDTipolCostrutt2015 findByPrimaryKey(Integer idTipolCostrutt) throws SiceeDTipolCostrutt2015DaoException
	{
		try {
			List<SiceeDTipolCostrutt2015> list = jdbcTemplate.query("SELECT ID_TIPOL_COSTRUTT, DESCR FROM " + getTableName() + " WHERE ID_TIPOL_COSTRUTT = ?", this,idTipolCostrutt);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipolCostrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDTipolCostrutt2015> findAll() throws SiceeDTipolCostrutt2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPOL_COSTRUTT, DESCR FROM " + getTableName() + " ORDER BY ID_TIPOL_COSTRUTT", this);
		}
		catch (Exception e) {
			throw new SiceeDTipolCostrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria 'ID_TIPOL_COSTRUTT = :idTipolCostrutt'.
	 */
	
	public List<SiceeDTipolCostrutt2015> findWhereIdTipolCostruttEquals(Integer idTipolCostrutt) throws SiceeDTipolCostrutt2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPOL_COSTRUTT, DESCR FROM " + getTableName() + " WHERE ID_TIPOL_COSTRUTT = ? ORDER BY ID_TIPOL_COSTRUTT", this,idTipolCostrutt);
		}
		catch (Exception e) {
			throw new SiceeDTipolCostrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipolCostrutt2015> findWhereDescrEquals(String descr) throws SiceeDTipolCostrutt2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPOL_COSTRUTT, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipolCostrutt2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipolCostrutt2015 findByPrimaryKey(SiceeDTipolCostrutt2015Pk pk) throws SiceeDTipolCostrutt2015DaoException
	{
		return findByPrimaryKey( pk.getIdTipolCostrutt() );
	}

}
