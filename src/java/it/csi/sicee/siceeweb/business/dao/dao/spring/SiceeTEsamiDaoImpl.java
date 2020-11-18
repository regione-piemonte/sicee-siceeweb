/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEsamiDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsami;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsamiPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTEsamiDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTEsamiDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTEsami>, SiceeTEsamiDao
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
	 * @return SiceeTEsamiPk
	 */
	
	public SiceeTEsamiPk insert(SiceeTEsami dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( CODICE_FISCALE ) VALUES ( ? )",dto.getCodiceFiscale());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ESAMI table.
	 */
	
	public void update(SiceeTEsamiPk pk, SiceeTEsami dto) throws SiceeTEsamiDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET CODICE_FISCALE = ? WHERE CODICE_FISCALE = ?",dto.getCodiceFiscale(),pk.getCodiceFiscale());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ESAMI table.
	 */
	
	public void delete(SiceeTEsamiPk pk) throws SiceeTEsamiDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE CODICE_FISCALE = ?",pk.getCodiceFiscale());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTEsami
	 */
	public SiceeTEsami mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTEsami dto = new SiceeTEsami();
		dto.setCodiceFiscale( rs.getString( 1 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_ESAMI";
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAMI table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 */
	
	public SiceeTEsami findByPrimaryKey(String codiceFiscale) throws SiceeTEsamiDaoException
	{
		try {
			List<SiceeTEsami> list = jdbcTemplate.query("SELECT CODICE_FISCALE FROM " + getTableName() + " WHERE CODICE_FISCALE = ?", this,codiceFiscale);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAMI table that match the criteria ''.
	 */
	
	public List<SiceeTEsami> findAll() throws SiceeTEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE_FISCALE FROM " + getTableName() + " ORDER BY CODICE_FISCALE", this);
		}
		catch (Exception e) {
			throw new SiceeTEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAMI table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 */
	
	public List<SiceeTEsami> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE_FISCALE FROM " + getTableName() + " WHERE CODICE_FISCALE = ? ORDER BY CODICE_FISCALE", this,codiceFiscale);
		}
		catch (Exception e) {
			throw new SiceeTEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ESAMI table that matches the specified primary-key value.
	 */
	public SiceeTEsami findByPrimaryKey(SiceeTEsamiPk pk) throws SiceeTEsamiDaoException
	{
		return findByPrimaryKey( pk.getCodiceFiscale() );
	}

}
