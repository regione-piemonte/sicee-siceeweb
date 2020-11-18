/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRiqEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDRiqEner2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDRiqEner2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDRiqEner2015>, SiceeDRiqEner2015Dao
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
	 * @return SiceeDRiqEner2015Pk
	 */
	
	public SiceeDRiqEner2015Pk insert(SiceeDRiqEner2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( CODICE_REN, DESCR, ID_XML ) VALUES ( ?, ?, ? )",dto.getCodiceRen(),dto.getDescr(), dto.getIdXml());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_RIQ_ENER_2015 table.
	 */
	
	public void update(SiceeDRiqEner2015Pk pk, SiceeDRiqEner2015 dto) throws SiceeDRiqEner2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET CODICE_REN = ?, DESCR = ?, ID_XML = ? WHERE CODICE_REN = ?",dto.getCodiceRen(),dto.getDescr(), dto.getIdXml(), pk.getCodiceRen());
	}

	/** 
	 * Deletes a single row in the SICEE_D_RIQ_ENER_2015 table.
	 */
	
	public void delete(SiceeDRiqEner2015Pk pk) throws SiceeDRiqEner2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE CODICE_REN = ?",pk.getCodiceRen());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDRiqEner2015
	 */
	public SiceeDRiqEner2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDRiqEner2015 dto = new SiceeDRiqEner2015();
		dto.setCodiceRen( rs.getString( 1 ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setIdXml( new Integer( rs.getInt(3) ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_RIQ_ENER_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	
	public SiceeDRiqEner2015 findByPrimaryKey(String codiceRen) throws SiceeDRiqEner2015DaoException
	{
		try {
			List<SiceeDRiqEner2015> list = jdbcTemplate.query("SELECT CODICE_REN, DESCR FROM " + getTableName() + " WHERE CODICE_REN = ?", this,codiceRen);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDRiqEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDRiqEner2015> findAll() throws SiceeDRiqEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE_REN, DESCR, ID_XML FROM " + getTableName() + " ORDER BY CODICE_REN", this);
		}
		catch (Exception e) {
			throw new SiceeDRiqEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	
	public List<SiceeDRiqEner2015> findWhereCodiceRenEquals(String codiceRen) throws SiceeDRiqEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE_REN, DESCR, ID_XML FROM " + getTableName() + " WHERE CODICE_REN = ? ORDER BY CODICE_REN", this,codiceRen);
		}
		catch (Exception e) {
			throw new SiceeDRiqEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDRiqEner2015> findWhereDescrEquals(String descr) throws SiceeDRiqEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE_REN, DESCR, ID FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDRiqEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'ID = :id'.
	 */
	
	public List<SiceeDRiqEner2015> findWhereIdXmlEquals(Integer idXml) throws SiceeDRiqEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE_REN, DESCR, ID_XML FROM " + getTableName() + " WHERE ID_XML = ? ORDER BY ID_XML", this,idXml);
		}
		catch (Exception e) {
			throw new SiceeDRiqEner2015DaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_D_RIQ_ENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeDRiqEner2015 findByPrimaryKey(SiceeDRiqEner2015Pk pk) throws SiceeDRiqEner2015DaoException
	{
		return findByPrimaryKey( pk.getCodiceRen() );
	}

}
