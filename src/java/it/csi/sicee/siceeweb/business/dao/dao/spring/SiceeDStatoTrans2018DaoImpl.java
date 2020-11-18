/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoTrans2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTrans2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTrans2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoTrans2018DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDStatoTrans2018DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDStatoTrans2018>, SiceeDStatoTrans2018Dao
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
	 * @return SiceeDStatoTrans2018Pk
	 */
	
	public SiceeDStatoTrans2018Pk insert(SiceeDStatoTrans2018 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_STATO_TRANS_2018, DESCR_STATO_TRANS ) VALUES ( ?, ? )",dto.getIdStatoTrans2018(),dto.getDescrStatoTrans());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_STATO_TRANS_2018 table.
	 */
	
	public void update(SiceeDStatoTrans2018Pk pk, SiceeDStatoTrans2018 dto) throws SiceeDStatoTrans2018DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_STATO_TRANS_2018 = ?, DESCR_STATO_TRANS = ? WHERE ID_STATO_TRANS_2018 = ?",dto.getIdStatoTrans2018(),dto.getDescrStatoTrans(),pk.getIdStatoTrans2018());
	}

	/** 
	 * Deletes a single row in the SICEE_D_STATO_TRANS_2018 table.
	 */
	
	public void delete(SiceeDStatoTrans2018Pk pk) throws SiceeDStatoTrans2018DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_STATO_TRANS_2018 = ?",pk.getIdStatoTrans2018());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDStatoTrans2018
	 */
	public SiceeDStatoTrans2018 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDStatoTrans2018 dto = new SiceeDStatoTrans2018();
		dto.setIdStatoTrans2018( new Integer( rs.getInt(1) ) );
		dto.setDescrStatoTrans( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_STATO_TRANS_2018";
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria 'ID_STATO_TRANS_2018 = :idStatoTrans2018'.
	 */
	
	public SiceeDStatoTrans2018 findByPrimaryKey(Integer idStatoTrans2018) throws SiceeDStatoTrans2018DaoException
	{
		try {
			List<SiceeDStatoTrans2018> list = jdbcTemplate.query("SELECT ID_STATO_TRANS_2018, DESCR_STATO_TRANS FROM " + getTableName() + " WHERE ID_STATO_TRANS_2018 = ?", this,idStatoTrans2018);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDStatoTrans2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria ''.
	 */
	
	public List<SiceeDStatoTrans2018> findAll() throws SiceeDStatoTrans2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO_TRANS_2018, DESCR_STATO_TRANS FROM " + getTableName() + " ORDER BY ID_STATO_TRANS_2018", this);
		}
		catch (Exception e) {
			throw new SiceeDStatoTrans2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria 'ID_STATO_TRANS_2018 = :idStatoTrans2018'.
	 */
	
	public List<SiceeDStatoTrans2018> findWhereIdStatoTrans2018Equals(Integer idStatoTrans2018) throws SiceeDStatoTrans2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO_TRANS_2018, DESCR_STATO_TRANS FROM " + getTableName() + " WHERE ID_STATO_TRANS_2018 = ? ORDER BY ID_STATO_TRANS_2018", this,idStatoTrans2018);
		}
		catch (Exception e) {
			throw new SiceeDStatoTrans2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria 'DESCR_STATO_TRANS = :descrStatoTrans'.
	 */
	
	public List<SiceeDStatoTrans2018> findWhereDescrStatoTransEquals(String descrStatoTrans) throws SiceeDStatoTrans2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO_TRANS_2018, DESCR_STATO_TRANS FROM " + getTableName() + " WHERE DESCR_STATO_TRANS = ? ORDER BY DESCR_STATO_TRANS", this,descrStatoTrans);
		}
		catch (Exception e) {
			throw new SiceeDStatoTrans2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_STATO_TRANS_2018 table that matches the specified primary-key value.
	 */
	public SiceeDStatoTrans2018 findByPrimaryKey(SiceeDStatoTrans2018Pk pk) throws SiceeDStatoTrans2018DaoException
	{
		return findByPrimaryKey( pk.getIdStatoTrans2018() );
	}

}
