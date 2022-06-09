/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDGradiGiornoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiornoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDGradiGiornoDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDGradiGiornoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDGradiGiorno>, SiceeDGradiGiornoDao
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
	 * @return SiceeDGradiGiornoPk
	 */
	
	public SiceeDGradiGiornoPk insert(SiceeDGradiGiorno dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE ) VALUES ( ?, ?, ?, ? )",dto.getComune(),dto.getZonaClimatica(),dto.getGradiGiorno(),dto.getIdComune());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_GRADI_GIORNO table.
	 */
	
	public void update(SiceeDGradiGiornoPk pk, SiceeDGradiGiorno dto) throws SiceeDGradiGiornoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET COMUNE = ?, ZONA_CLIMATICA = ?, GRADI_GIORNO = ?, ID_COMUNE = ? WHERE ID_COMUNE = ?",dto.getComune(),dto.getZonaClimatica(),dto.getGradiGiorno(),dto.getIdComune(),pk.getIdComune());
	}

	/** 
	 * Deletes a single row in the SICEE_D_GRADI_GIORNO table.
	 */
	
	public void delete(SiceeDGradiGiornoPk pk) throws SiceeDGradiGiornoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_COMUNE = ?",pk.getIdComune());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDGradiGiorno
	 */
	public SiceeDGradiGiorno mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDGradiGiorno dto = new SiceeDGradiGiorno();
		dto.setComune( rs.getString( 1 ) );
		dto.setZonaClimatica( rs.getString( 2 ) );
		dto.setGradiGiorno( new Integer( rs.getInt(3) ) );
		if (rs.wasNull()) {
			dto.setGradiGiorno( null );
		}
		
		dto.setIdComune( rs.getString( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_GRADI_GIORNO";
	}

	/** 
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public SiceeDGradiGiorno findByPrimaryKey(String idComune) throws SiceeDGradiGiornoDaoException
	{
		try {
			List<SiceeDGradiGiorno> list = jdbcTemplate.query("SELECT COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE FROM " + getTableName() + " WHERE ID_COMUNE = ?", this,idComune);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDGradiGiornoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria ''.
	 */
	
	public List<SiceeDGradiGiorno> findAll() throws SiceeDGradiGiornoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE FROM " + getTableName() + " ORDER BY ID_COMUNE", this);
		}
		catch (Exception e) {
			throw new SiceeDGradiGiornoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'COMUNE = :comune'.
	 */
	
	public List<SiceeDGradiGiorno> findWhereComuneEquals(String comune) throws SiceeDGradiGiornoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE FROM " + getTableName() + " WHERE COMUNE = ? ORDER BY COMUNE", this,comune);
		}
		catch (Exception e) {
			throw new SiceeDGradiGiornoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public List<SiceeDGradiGiorno> findWhereIdComuneEquals(String idComune) throws SiceeDGradiGiornoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeDGradiGiornoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'ZONA_CLIMATICA = :zonaClimatica'.
	 */
	
	public List<SiceeDGradiGiorno> findWhereZonaClimaticaEquals(String zonaClimatica) throws SiceeDGradiGiornoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE FROM " + getTableName() + " WHERE ZONA_CLIMATICA = ? ORDER BY ZONA_CLIMATICA", this,zonaClimatica);
		}
		catch (Exception e) {
			throw new SiceeDGradiGiornoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'GRADI_GIORNO = :gradiGiorno'.
	 */
	
	public List<SiceeDGradiGiorno> findWhereGradiGiornoEquals(Integer gradiGiorno) throws SiceeDGradiGiornoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE FROM " + getTableName() + " WHERE GRADI_GIORNO = ? ORDER BY GRADI_GIORNO", this,gradiGiorno);
		}
		catch (Exception e) {
			throw new SiceeDGradiGiornoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_GRADI_GIORNO table that matches the specified primary-key value.
	 */
	public SiceeDGradiGiorno findByPrimaryKey(SiceeDGradiGiornoPk pk) throws SiceeDGradiGiornoDaoException
	{
		return findByPrimaryKey( pk.getIdComune() );
	}

	public SiceeDGradiGiorno findByZonaEComune(String idComune,String zona) throws SiceeDGradiGiornoDaoException
	{
		try {
			List<SiceeDGradiGiorno> list = jdbcTemplate.query("SELECT COMUNE, ZONA_CLIMATICA, GRADI_GIORNO, ID_COMUNE FROM " + getTableName() + " WHERE ID_COMUNE = ? AND ZONA_CLIMATICA = ?", this,idComune,zona);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDGradiGiornoDaoException("Query failed", e);
		}

	}

}
