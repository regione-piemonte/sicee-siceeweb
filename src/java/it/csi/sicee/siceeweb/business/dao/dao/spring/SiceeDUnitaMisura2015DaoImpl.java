/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDUnitaMisura2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDUnitaMisura2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDUnitaMisura2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDUnitaMisura2015>, SiceeDUnitaMisura2015Dao
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
	 * @return SiceeDUnitaMisura2015Pk
	 */
	
	public SiceeDUnitaMisura2015Pk insert(SiceeDUnitaMisura2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_UNITA_MISURA, DESCR ) VALUES ( ?, ? )",dto.getIdUnitaMisura(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_UNITA_MISURA_2015 table.
	 */
	
	public void update(SiceeDUnitaMisura2015Pk pk, SiceeDUnitaMisura2015 dto) throws SiceeDUnitaMisura2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_UNITA_MISURA = ?, DESCR = ? WHERE ID_UNITA_MISURA = ?",dto.getIdUnitaMisura(),dto.getDescr(),pk.getIdUnitaMisura());
	}

	/** 
	 * Deletes a single row in the SICEE_D_UNITA_MISURA_2015 table.
	 */
	
	public void delete(SiceeDUnitaMisura2015Pk pk) throws SiceeDUnitaMisura2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_UNITA_MISURA = ?",pk.getIdUnitaMisura());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDUnitaMisura2015
	 */
	public SiceeDUnitaMisura2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDUnitaMisura2015 dto = new SiceeDUnitaMisura2015();
		dto.setIdUnitaMisura( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_UNITA_MISURA_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria 'ID_UNITA_MISURA = :idUnitaMisura'.
	 */
	
	public SiceeDUnitaMisura2015 findByPrimaryKey(Integer idUnitaMisura) throws SiceeDUnitaMisura2015DaoException
	{
		try {
			List<SiceeDUnitaMisura2015> list = jdbcTemplate.query("SELECT ID_UNITA_MISURA, DESCR FROM " + getTableName() + " WHERE ID_UNITA_MISURA = ?", this,idUnitaMisura);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDUnitaMisura2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDUnitaMisura2015> findAll() throws SiceeDUnitaMisura2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_UNITA_MISURA, DESCR FROM " + getTableName() + " ORDER BY ID_UNITA_MISURA", this);
		}
		catch (Exception e) {
			throw new SiceeDUnitaMisura2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria 'ID_UNITA_MISURA = :idUnitaMisura'.
	 */
	
	public List<SiceeDUnitaMisura2015> findWhereIdUnitaMisuraEquals(Integer idUnitaMisura) throws SiceeDUnitaMisura2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_UNITA_MISURA, DESCR FROM " + getTableName() + " WHERE ID_UNITA_MISURA = ? ORDER BY ID_UNITA_MISURA", this,idUnitaMisura);
		}
		catch (Exception e) {
			throw new SiceeDUnitaMisura2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDUnitaMisura2015> findWhereDescrEquals(String descr) throws SiceeDUnitaMisura2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_UNITA_MISURA, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDUnitaMisura2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_UNITA_MISURA_2015 table that matches the specified primary-key value.
	 */
	public SiceeDUnitaMisura2015 findByPrimaryKey(SiceeDUnitaMisura2015Pk pk) throws SiceeDUnitaMisura2015DaoException
	{
		return findByPrimaryKey( pk.getIdUnitaMisura() );
	}

}
