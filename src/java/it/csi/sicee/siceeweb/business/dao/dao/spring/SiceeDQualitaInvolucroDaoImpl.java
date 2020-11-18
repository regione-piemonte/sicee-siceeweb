/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDQualitaInvolucroDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDQualitaInvolucro;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDQualitaInvolucroPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDQualitaInvolucroDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDQualitaInvolucroDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDQualitaInvolucro>, SiceeDQualitaInvolucroDao
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
	 * @return SiceeDQualitaInvolucroPk
	 */
	
	public SiceeDQualitaInvolucroPk insert(SiceeDQualitaInvolucro dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_QUALITA, DESCR ) VALUES ( ?, ? )",dto.getIdQualita(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_QUALITA_INVOLUCRO table.
	 */
	
	public void update(SiceeDQualitaInvolucroPk pk, SiceeDQualitaInvolucro dto) throws SiceeDQualitaInvolucroDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_QUALITA = ?, DESCR = ? WHERE ID_QUALITA = ?",dto.getIdQualita(),dto.getDescr(),pk.getIdQualita());
	}

	/** 
	 * Deletes a single row in the SICEE_D_QUALITA_INVOLUCRO table.
	 */
	
	public void delete(SiceeDQualitaInvolucroPk pk) throws SiceeDQualitaInvolucroDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_QUALITA = ?",pk.getIdQualita());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDQualitaInvolucro
	 */
	public SiceeDQualitaInvolucro mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDQualitaInvolucro dto = new SiceeDQualitaInvolucro();
		dto.setIdQualita( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_QUALITA_INVOLUCRO";
	}

	/** 
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria 'ID_QUALITA = :idQualita'.
	 */
	
	public SiceeDQualitaInvolucro findByPrimaryKey(Integer idQualita) throws SiceeDQualitaInvolucroDaoException
	{
		try {
			List<SiceeDQualitaInvolucro> list = jdbcTemplate.query("SELECT ID_QUALITA, DESCR FROM " + getTableName() + " WHERE ID_QUALITA = ?", this,idQualita);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDQualitaInvolucroDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria ''.
	 */
	
	public List<SiceeDQualitaInvolucro> findAll() throws SiceeDQualitaInvolucroDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QUALITA, DESCR FROM " + getTableName() + " ORDER BY ID_QUALITA", this);
		}
		catch (Exception e) {
			throw new SiceeDQualitaInvolucroDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria 'ID_QUALITA = :idQualita'.
	 */
	
	public List<SiceeDQualitaInvolucro> findWhereIdQualitaEquals(Integer idQualita) throws SiceeDQualitaInvolucroDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QUALITA, DESCR FROM " + getTableName() + " WHERE ID_QUALITA = ? ORDER BY ID_QUALITA", this,idQualita);
		}
		catch (Exception e) {
			throw new SiceeDQualitaInvolucroDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDQualitaInvolucro> findWhereDescrEquals(String descr) throws SiceeDQualitaInvolucroDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QUALITA, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDQualitaInvolucroDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_QUALITA_INVOLUCRO table that matches the specified primary-key value.
	 */
	public SiceeDQualitaInvolucro findByPrimaryKey(SiceeDQualitaInvolucroPk pk) throws SiceeDQualitaInvolucroDaoException
	{
		return findByPrimaryKey( pk.getIdQualita() );
	}

}
