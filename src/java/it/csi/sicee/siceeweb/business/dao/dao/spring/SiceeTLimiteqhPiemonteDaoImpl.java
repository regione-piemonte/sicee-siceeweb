/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTLimiteqhPiemonteDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTLimiteqhPiemonte;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTLimiteqhPiemonteDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTLimiteqhPiemonteDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTLimiteqhPiemonte>, SiceeTLimiteqhPiemonteDao
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
	
	public void insert(SiceeTLimiteqhPiemonte dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( VOLUME, GG_3000, GG_5000, FLG_EDIFICIO ) VALUES ( ?, ?, ?, ? )",dto.getVolume(),dto.getGg3000(),dto.getGg5000(),dto.getFlgEdificio());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTLimiteqhPiemonte
	 */
	public SiceeTLimiteqhPiemonte mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTLimiteqhPiemonte dto = new SiceeTLimiteqhPiemonte();
		dto.setVolume( new Integer( rs.getInt(1) ) );
		if (rs.wasNull()) {
			dto.setVolume( null );
		}
		
		dto.setGg3000( new Double( rs.getDouble(2) ) );
		if (rs.wasNull()) {
			dto.setGg3000( null );
		}
		
		dto.setGg5000( new Double( rs.getDouble(3) ) );
		if (rs.wasNull()) {
			dto.setGg5000( null );
		}
		
		dto.setFlgEdificio( rs.getString( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_LIMITEQH_PIEMONTE";
	}

	/** 
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria ''.
	 */
	
	public List<SiceeTLimiteqhPiemonte> findAll() throws SiceeTLimiteqhPiemonteDaoException
	{
		try {
			return jdbcTemplate.query("SELECT VOLUME, GG_3000, GG_5000, FLG_EDIFICIO FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new SiceeTLimiteqhPiemonteDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'VOLUME = :volume'.
	 */
	
	public List<SiceeTLimiteqhPiemonte> findWhereVolumeEquals(Integer volume) throws SiceeTLimiteqhPiemonteDaoException
	{
		try {
			return jdbcTemplate.query("SELECT VOLUME, GG_3000, GG_5000, FLG_EDIFICIO FROM " + getTableName() + " WHERE VOLUME = ? ORDER BY VOLUME", this,volume);
		}
		catch (Exception e) {
			throw new SiceeTLimiteqhPiemonteDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'GG_3000 = :gg3000'.
	 */
	
	public List<SiceeTLimiteqhPiemonte> findWhereGg3000Equals(Float gg3000) throws SiceeTLimiteqhPiemonteDaoException
	{
		try {
			return jdbcTemplate.query("SELECT VOLUME, GG_3000, GG_5000, FLG_EDIFICIO FROM " + getTableName() + " WHERE GG_3000 = ? ORDER BY GG_3000", this,gg3000);
		}
		catch (Exception e) {
			throw new SiceeTLimiteqhPiemonteDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'GG_5000 = :gg5000'.
	 */
	
	public List<SiceeTLimiteqhPiemonte> findWhereGg5000Equals(Float gg5000) throws SiceeTLimiteqhPiemonteDaoException
	{
		try {
			return jdbcTemplate.query("SELECT VOLUME, GG_3000, GG_5000, FLG_EDIFICIO FROM " + getTableName() + " WHERE GG_5000 = ? ORDER BY GG_5000", this,gg5000);
		}
		catch (Exception e) {
			throw new SiceeTLimiteqhPiemonteDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_LIMITEQH_PIEMONTE table that match the criteria 'FLG_EDIFICIO = :flgEdificio'.
	 */
	
	public List<SiceeTLimiteqhPiemonte> findWhereFlgEdificioEquals(String flgEdificio) throws SiceeTLimiteqhPiemonteDaoException
	{
		try {
			return jdbcTemplate.query("SELECT VOLUME, GG_3000, GG_5000, FLG_EDIFICIO FROM " + getTableName() + " WHERE FLG_EDIFICIO = ? ORDER BY FLG_EDIFICIO", this,flgEdificio);
		}
		catch (Exception e) {
			throw new SiceeTLimiteqhPiemonteDaoException("Query failed", e);
		}
		
	}

}
