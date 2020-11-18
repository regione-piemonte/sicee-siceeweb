/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEfficienzaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEfficienza;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEfficienzaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDClasseEfficienzaDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDClasseEfficienzaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDClasseEfficienza>, SiceeDClasseEfficienzaDao
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
	 * @return SiceeDClasseEfficienzaPk
	 */
	
	public SiceeDClasseEfficienzaPk insert(SiceeDClasseEfficienza dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CLASSE_EFF, DESCR ) VALUES ( ?, ? )",dto.getIdClasseEff(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_CLASSE_EFFICIENZA table.
	 */
	
	public void update(SiceeDClasseEfficienzaPk pk, SiceeDClasseEfficienza dto) throws SiceeDClasseEfficienzaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CLASSE_EFF = ?, DESCR = ? WHERE ID_CLASSE_EFF = ?",dto.getIdClasseEff(),dto.getDescr(),pk.getIdClasseEff());
	}

	/** 
	 * Deletes a single row in the SICEE_D_CLASSE_EFFICIENZA table.
	 */
	
	public void delete(SiceeDClasseEfficienzaPk pk) throws SiceeDClasseEfficienzaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CLASSE_EFF = ?",pk.getIdClasseEff());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDClasseEfficienza
	 */
	public SiceeDClasseEfficienza mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDClasseEfficienza dto = new SiceeDClasseEfficienza();
		dto.setIdClasseEff( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_CLASSE_EFFICIENZA";
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria 'ID_CLASSE_EFF = :idClasseEff'.
	 */
	
	public SiceeDClasseEfficienza findByPrimaryKey(Integer idClasseEff) throws SiceeDClasseEfficienzaDaoException
	{
		try {
			List<SiceeDClasseEfficienza> list = jdbcTemplate.query("SELECT ID_CLASSE_EFF, DESCR FROM " + getTableName() + " WHERE ID_CLASSE_EFF = ?", this,idClasseEff);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDClasseEfficienzaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria ''.
	 */
	
	public List<SiceeDClasseEfficienza> findAll() throws SiceeDClasseEfficienzaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE_EFF, DESCR FROM " + getTableName() + " ORDER BY ID_CLASSE_EFF", this);
		}
		catch (Exception e) {
			throw new SiceeDClasseEfficienzaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria 'ID_CLASSE_EFF = :idClasseEff'.
	 */
	
	public List<SiceeDClasseEfficienza> findWhereIdClasseEffEquals(Integer idClasseEff) throws SiceeDClasseEfficienzaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE_EFF, DESCR FROM " + getTableName() + " WHERE ID_CLASSE_EFF = ? ORDER BY ID_CLASSE_EFF", this,idClasseEff);
		}
		catch (Exception e) {
			throw new SiceeDClasseEfficienzaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_EFFICIENZA table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDClasseEfficienza> findWhereDescrEquals(String descr) throws SiceeDClasseEfficienzaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE_EFF, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDClasseEfficienzaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_CLASSE_EFFICIENZA table that matches the specified primary-key value.
	 */
	public SiceeDClasseEfficienza findByPrimaryKey(SiceeDClasseEfficienzaPk pk) throws SiceeDClasseEfficienzaDaoException
	{
		return findByPrimaryKey( pk.getIdClasseEff() );
	}

}
