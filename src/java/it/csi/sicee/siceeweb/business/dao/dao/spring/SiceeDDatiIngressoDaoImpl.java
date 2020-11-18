/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDatiIngressoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDatiIngresso;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDatiIngressoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDatiIngressoDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDDatiIngressoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDDatiIngresso>, SiceeDDatiIngressoDao
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
	 * @return SiceeDDatiIngressoPk
	 */
	
	public SiceeDDatiIngressoPk insert(SiceeDDatiIngresso dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DATI, DESCR ) VALUES ( ?, ? )",dto.getIdDati(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_DATI_INGRESSO table.
	 */
	
	public void update(SiceeDDatiIngressoPk pk, SiceeDDatiIngresso dto) throws SiceeDDatiIngressoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DATI = ?, DESCR = ? WHERE ID_DATI = ?",dto.getIdDati(),dto.getDescr(),pk.getIdDati());
	}

	/** 
	 * Deletes a single row in the SICEE_D_DATI_INGRESSO table.
	 */
	
	public void delete(SiceeDDatiIngressoPk pk) throws SiceeDDatiIngressoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DATI = ?",pk.getIdDati());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDDatiIngresso
	 */
	public SiceeDDatiIngresso mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDDatiIngresso dto = new SiceeDDatiIngresso();
		dto.setIdDati( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_DATI_INGRESSO";
	}

	/** 
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria 'ID_DATI = :idDati'.
	 */
	
	public SiceeDDatiIngresso findByPrimaryKey(Integer idDati) throws SiceeDDatiIngressoDaoException
	{
		try {
			List<SiceeDDatiIngresso> list = jdbcTemplate.query("SELECT ID_DATI, DESCR FROM " + getTableName() + " WHERE ID_DATI = ?", this,idDati);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDDatiIngressoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria ''.
	 */
	
	public List<SiceeDDatiIngresso> findAll() throws SiceeDDatiIngressoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI, DESCR FROM " + getTableName() + " ORDER BY ID_DATI", this);
		}
		catch (Exception e) {
			throw new SiceeDDatiIngressoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria 'ID_DATI = :idDati'.
	 */
	
	public List<SiceeDDatiIngresso> findWhereIdDatiEquals(Integer idDati) throws SiceeDDatiIngressoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI, DESCR FROM " + getTableName() + " WHERE ID_DATI = ? ORDER BY ID_DATI", this,idDati);
		}
		catch (Exception e) {
			throw new SiceeDDatiIngressoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDDatiIngresso> findWhereDescrEquals(String descr) throws SiceeDDatiIngressoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDDatiIngressoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_DATI_INGRESSO table that matches the specified primary-key value.
	 */
	public SiceeDDatiIngresso findByPrimaryKey(SiceeDDatiIngressoPk pk) throws SiceeDDatiIngressoDaoException
	{
		return findByPrimaryKey( pk.getIdDati() );
	}

}
