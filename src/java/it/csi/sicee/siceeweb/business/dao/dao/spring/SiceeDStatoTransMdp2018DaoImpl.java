/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoTransMdp2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTransMdp2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTransMdp2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoTransMdp2018DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDStatoTransMdp2018DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDStatoTransMdp2018>, SiceeDStatoTransMdp2018Dao
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
	 * @return SiceeDStatoTransMdp2018Pk
	 */
	
	public SiceeDStatoTransMdp2018Pk insert(SiceeDStatoTransMdp2018 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_STATO_TRANS_MDP_2018, DESCR_STATO_TRANS_MDP ) VALUES ( ?, ? )",dto.getIdStatoTransMdp2018(),dto.getDescrStatoTransMdp());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_STATO_TRANS_MDP_2018 table.
	 */
	
	public void update(SiceeDStatoTransMdp2018Pk pk, SiceeDStatoTransMdp2018 dto) throws SiceeDStatoTransMdp2018DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_STATO_TRANS_MDP_2018 = ?, DESCR_STATO_TRANS_MDP = ? WHERE ID_STATO_TRANS_MDP_2018 = ?",dto.getIdStatoTransMdp2018(),dto.getDescrStatoTransMdp(),pk.getIdStatoTransMdp2018());
	}

	/** 
	 * Deletes a single row in the SICEE_D_STATO_TRANS_MDP_2018 table.
	 */
	
	public void delete(SiceeDStatoTransMdp2018Pk pk) throws SiceeDStatoTransMdp2018DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_STATO_TRANS_MDP_2018 = ?",pk.getIdStatoTransMdp2018());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDStatoTransMdp2018
	 */
	public SiceeDStatoTransMdp2018 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDStatoTransMdp2018 dto = new SiceeDStatoTransMdp2018();
		dto.setIdStatoTransMdp2018( new Integer( rs.getInt(1) ) );
		dto.setDescrStatoTransMdp( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_STATO_TRANS_MDP_2018";
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria 'ID_STATO_TRANS_MDP_2018 = :idStatoTransMdp2018'.
	 */
	
	public SiceeDStatoTransMdp2018 findByPrimaryKey(Integer idStatoTransMdp2018) throws SiceeDStatoTransMdp2018DaoException
	{
		try {
			List<SiceeDStatoTransMdp2018> list = jdbcTemplate.query("SELECT ID_STATO_TRANS_MDP_2018, DESCR_STATO_TRANS_MDP FROM " + getTableName() + " WHERE ID_STATO_TRANS_MDP_2018 = ?", this,idStatoTransMdp2018);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDStatoTransMdp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria ''.
	 */
	
	public List<SiceeDStatoTransMdp2018> findAll() throws SiceeDStatoTransMdp2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO_TRANS_MDP_2018, DESCR_STATO_TRANS_MDP FROM " + getTableName() + " ORDER BY ID_STATO_TRANS_MDP_2018", this);
		}
		catch (Exception e) {
			throw new SiceeDStatoTransMdp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria 'ID_STATO_TRANS_MDP_2018 = :idStatoTransMdp2018'.
	 */
	
	public List<SiceeDStatoTransMdp2018> findWhereIdStatoTransMdp2018Equals(Integer idStatoTransMdp2018) throws SiceeDStatoTransMdp2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO_TRANS_MDP_2018, DESCR_STATO_TRANS_MDP FROM " + getTableName() + " WHERE ID_STATO_TRANS_MDP_2018 = ? ORDER BY ID_STATO_TRANS_MDP_2018", this,idStatoTransMdp2018);
		}
		catch (Exception e) {
			throw new SiceeDStatoTransMdp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria 'DESCR_STATO_TRANS_MDP = :descrStatoTransMdp'.
	 */
	
	public List<SiceeDStatoTransMdp2018> findWhereDescrStatoTransMdpEquals(String descrStatoTransMdp) throws SiceeDStatoTransMdp2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_STATO_TRANS_MDP_2018, DESCR_STATO_TRANS_MDP FROM " + getTableName() + " WHERE DESCR_STATO_TRANS_MDP = ? ORDER BY DESCR_STATO_TRANS_MDP", this,descrStatoTransMdp);
		}
		catch (Exception e) {
			throw new SiceeDStatoTransMdp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_STATO_TRANS_MDP_2018 table that matches the specified primary-key value.
	 */
	public SiceeDStatoTransMdp2018 findByPrimaryKey(SiceeDStatoTransMdp2018Pk pk) throws SiceeDStatoTransMdp2018DaoException
	{
		return findByPrimaryKey( pk.getIdStatoTransMdp2018() );
	}

}
