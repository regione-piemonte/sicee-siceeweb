/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDServEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDServEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDServEner2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDServEner2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDServEner2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDServEner2015>, SiceeDServEner2015Dao
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
	 * @return SiceeDServEner2015Pk
	 */
	
	public SiceeDServEner2015Pk insert(SiceeDServEner2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_SERV_ENER, DESCR, FLG_ATTIVO ) VALUES ( ?, ?, ? )",dto.getIdServEner(),dto.getDescr(),dto.getFlgAttivo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_SERV_ENER_2015 table.
	 */
	
	public void update(SiceeDServEner2015Pk pk, SiceeDServEner2015 dto) throws SiceeDServEner2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_SERV_ENER = ?, DESCR = ?, FLG_ATTIVO = ? WHERE ID_SERV_ENER = ?",dto.getIdServEner(),dto.getDescr(),dto.getFlgAttivo(),pk.getIdServEner());
	}

	/** 
	 * Deletes a single row in the SICEE_D_SERV_ENER_2015 table.
	 */
	
	public void delete(SiceeDServEner2015Pk pk) throws SiceeDServEner2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_SERV_ENER = ?",pk.getIdServEner());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDServEner2015
	 */
	public SiceeDServEner2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDServEner2015 dto = new SiceeDServEner2015();
		dto.setIdServEner( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFlgAttivo( new Integer( rs.getInt(3) ) );
		if (rs.wasNull()) {
			dto.setFlgAttivo( null );
		}
		
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_SERV_ENER_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'ID_SERV_ENER = :idServEner'.
	 */
	
	public SiceeDServEner2015 findByPrimaryKey(Integer idServEner) throws SiceeDServEner2015DaoException
	{
		try {
			List<SiceeDServEner2015> list = jdbcTemplate.query("SELECT ID_SERV_ENER, DESCR, FLG_ATTIVO FROM " + getTableName() + " WHERE ID_SERV_ENER = ?", this,idServEner);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDServEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDServEner2015> findAll() throws SiceeDServEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SERV_ENER, DESCR, FLG_ATTIVO FROM " + getTableName() + " ORDER BY ID_SERV_ENER", this);
		}
		catch (Exception e) {
			throw new SiceeDServEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'ID_SERV_ENER = :idServEner'.
	 */
	
	public List<SiceeDServEner2015> findWhereIdServEnerEquals(Integer idServEner) throws SiceeDServEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SERV_ENER, DESCR, FLG_ATTIVO FROM " + getTableName() + " WHERE ID_SERV_ENER = ? ORDER BY ID_SERV_ENER", this,idServEner);
		}
		catch (Exception e) {
			throw new SiceeDServEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDServEner2015> findWhereDescrEquals(String descr) throws SiceeDServEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SERV_ENER, DESCR, FLG_ATTIVO FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDServEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	
	public List<SiceeDServEner2015> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDServEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SERV_ENER, DESCR, FLG_ATTIVO FROM " + getTableName() + " WHERE FLG_ATTIVO = ? ORDER BY FLG_ATTIVO", this,flgAttivo);
		}
		catch (Exception e) {
			throw new SiceeDServEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_SERV_ENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeDServEner2015 findByPrimaryKey(SiceeDServEner2015Pk pk) throws SiceeDServEner2015DaoException
	{
		return findByPrimaryKey( pk.getIdServEner() );
	}

}
