/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTParametriDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTParametriDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTParametri>, SiceeTParametriDao
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
	 */
	
	public void insert(SiceeTParametri dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( CODICE, VALORE ) VALUES ( ?, ? )",dto.getCodice(),dto.getValore());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTParametri
	 */
	public SiceeTParametri mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTParametri dto = new SiceeTParametri();
		dto.setCodice( rs.getString( 1 ) );
		dto.setValore( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_PARAMETRI";
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria ''.
	 */
	
	public List<SiceeTParametri> findAll() throws SiceeTParametriDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE, VALORE FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new SiceeTParametriDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'CODICE = :codice'.
	 */
	
	public SiceeTParametri findWhereCodiceEquals(String codice) throws SiceeTParametriDaoException
	{
		try {
			List<SiceeTParametri> list = jdbcTemplate.query("SELECT CODICE, VALORE FROM " + getTableName() + " WHERE CODICE = ?", this,codice);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTParametriDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'VALORE = :valore'.
	 */
	
	public List<SiceeTParametri> findWhereValoreEquals(String valore) throws SiceeTParametriDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE, VALORE FROM " + getTableName() + " WHERE VALORE = ? ORDER BY VALORE", this,valore);
		}
		catch (Exception e) {
			throw new SiceeTParametriDaoException("Query failed", e);
		}
		
	}

}
