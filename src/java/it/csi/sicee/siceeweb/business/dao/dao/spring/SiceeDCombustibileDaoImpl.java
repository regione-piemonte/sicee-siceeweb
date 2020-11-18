/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCombustibileDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibilePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDCombustibileDaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDCombustibileDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDCombustibile>, SiceeDCombustibileDao
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
	 * @return SiceeDCombustibilePk
	 */
	
	public SiceeDCombustibilePk insert(SiceeDCombustibile dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD ) VALUES ( ?, ?, ?, ? )",dto.getIdCombustibile(),dto.getDescr(),dto.getFattoreEmissione(),dto.getFlgComboRiscald());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_COMBUSTIBILE table.
	 */
	
	public void update(SiceeDCombustibilePk pk, SiceeDCombustibile dto) throws SiceeDCombustibileDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_COMBUSTIBILE = ?, DESCR = ?, FATTORE_EMISSIONE = ?, FLG_COMBO_RISCALD = ? WHERE ID_COMBUSTIBILE = ?",dto.getIdCombustibile(),dto.getDescr(),dto.getFattoreEmissione(),dto.getFlgComboRiscald(),pk.getIdCombustibile());
	}

	/** 
	 * Deletes a single row in the SICEE_D_COMBUSTIBILE table.
	 */
	
	public void delete(SiceeDCombustibilePk pk) throws SiceeDCombustibileDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_COMBUSTIBILE = ?",pk.getIdCombustibile());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDCombustibile
	 */
	public SiceeDCombustibile mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDCombustibile dto = new SiceeDCombustibile();
		dto.setIdCombustibile( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFattoreEmissione( new Double( rs.getDouble(3) ) );
		if (rs.wasNull()) {
			dto.setFattoreEmissione( null );
		}
		
		dto.setFlgComboRiscald( rs.getString( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_COMBUSTIBILE";
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile'.
	 */
	
	public SiceeDCombustibile findByPrimaryKey(Integer idCombustibile) throws SiceeDCombustibileDaoException
	{
		try {
			List<SiceeDCombustibile> list = jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE ID_COMBUSTIBILE = ?", this,idCombustibile);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria ''.
	 */
	
	public List<SiceeDCombustibile> findAll() throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " ORDER BY ID_COMBUSTIBILE", this);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile'.
	 */
	
	public List<SiceeDCombustibile> findWhereIdCombustibileEquals(Integer idCombustibile) throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE ID_COMBUSTIBILE = ? ORDER BY ID_COMBUSTIBILE", this,idCombustibile);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDCombustibile> findWhereDescrEquals(String descr) throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FATTORE_EMISSIONE = :fattoreEmissione'.
	 */
	
	public List<SiceeDCombustibile> findWhereFattoreEmissioneEquals(Double fattoreEmissione) throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE FATTORE_EMISSIONE = ? ORDER BY FATTORE_EMISSIONE", this,fattoreEmissione);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_COMBO_RISCALD = :flgComboRiscald'.
	 */
	
	public List<SiceeDCombustibile> findWhereFlgComboRiscaldEquals(String flgComboRiscald) throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE FLG_COMBO_RISCALD = ? ORDER BY FLG_COMBO_RISCALD", this,flgComboRiscald);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_VETTORE_EN_EXPORT = :flgVettoreEnExport'.
	 */
	
	public List<SiceeDCombustibile> findWhereFlgVettoreEnExportEquals(String flgVettoreEnExport) throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE FLG_VETTORE_EN_EXPORT = ? ORDER BY ID_COMBUSTIBILE", this,flgVettoreEnExport);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_VETTORE_DET_IMP = :flgVettoreDetImp'.
	 */
	
	public List<SiceeDCombustibile> findWhereFlgVettoreDetImpEquals(String flgVettoreDetImp) throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE FLG_VETTORE_DET_IMP = ? ORDER BY ID_COMBUSTIBILE", this,flgVettoreDetImp);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_COMBUSTIBILE table that match the criteria 'FLG_CONSUMI = :flgConsumi'.
	 */
	
	public List<SiceeDCombustibile> findWhereFlgConsumiEquals(String flgConsumi) throws SiceeDCombustibileDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, DESCR, FATTORE_EMISSIONE, FLG_COMBO_RISCALD FROM " + getTableName() + " WHERE FLG_CONSUMI = ? ORDER BY ID_COMBUSTIBILE", this,flgConsumi);
		}
		catch (Exception e) {
			throw new SiceeDCombustibileDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_COMBUSTIBILE table that matches the specified primary-key value.
	 */
	public SiceeDCombustibile findByPrimaryKey(SiceeDCombustibilePk pk) throws SiceeDCombustibileDaoException
	{
		return findByPrimaryKey( pk.getIdCombustibile() );
	}

}
