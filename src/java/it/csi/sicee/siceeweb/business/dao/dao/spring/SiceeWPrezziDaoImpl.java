/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeWPrezziDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezzi;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezziPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWPrezziDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class SiceeWPrezziDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeWPrezzi>, SiceeWPrezziDao
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
	 * @return SiceeWPrezziPk
	 */
	
	public SiceeWPrezziPk insert(SiceeWPrezzi dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE ) VALUES ( ?, ?, ?, ?, ? )",dto.getDescrizione(),dto.getValuta(),dto.getIdPrezzi(),dto.getDtInizio(),dto.getDtFine());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_W_PREZZI table.
	 */
	
	public void update(SiceeWPrezziPk pk, SiceeWPrezzi dto) throws SiceeWPrezziDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET DESCRIZIONE = ?, VALUTA = ?, ID_PREZZI = ?, DT_INIZIO = ?, DT_FINE = ? WHERE ID_PREZZI = ?",dto.getDescrizione(),dto.getValuta(),dto.getIdPrezzi(),dto.getDtInizio(),dto.getDtFine(),pk.getIdPrezzi());
	}

	/** 
	 * Deletes a single row in the SICEE_W_PREZZI table.
	 */
	
	public void delete(SiceeWPrezziPk pk) throws SiceeWPrezziDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_PREZZI = ?",pk.getIdPrezzi());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeWPrezzi
	 */
	public SiceeWPrezzi mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeWPrezzi dto = new SiceeWPrezzi();
		dto.setDescrizione( rs.getString( 1 ) );
		dto.setValuta( new Double( rs.getDouble(2) ) );
		if (rs.wasNull()) {
			dto.setValuta( null );
		}
		
		dto.setIdPrezzi( new Integer( rs.getInt(3) ) );
		dto.setDtInizio( rs.getTimestamp(4 ) );
		dto.setDtFine( rs.getTimestamp(5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_W_PREZZI";
	}

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'ID_PREZZI = :idPrezzi'.
	 */
	
	public SiceeWPrezzi findByPrimaryKey(Integer idPrezzi) throws SiceeWPrezziDaoException
	{
		try {
			List<SiceeWPrezzi> list = jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE ID_PREZZI = ?", this,idPrezzi);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DESCRIZIONE = :descrizione
		AND SYSDATE BETWEEN DT_INIZIO AND COALESCE(DT_FINE,SYSDATE)'.
	 */
	public SiceeWPrezzi findWhereDescrizioneValidaEquals(String descrizione) throws SiceeWPrezziDaoException
	{
		try {
			List<SiceeWPrezzi> list = jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DESCRIZIONE = ? AND SYSDATE BETWEEN DT_INIZIO AND COALESCE(DT_FINE,SYSDATE)", this,descrizione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DESCRIZIONE = :descrizione
	AND :dataTransazione BETWEEN DT_INIZIO AND COALESCE(DT_FINE,SYSDATE)'.
	 */
	public SiceeWPrezzi findWhereDescrizioneValidaAllaDataEquals(String descrizione, Date dataTransazione) throws SiceeWPrezziDaoException
	{
		try {
			List<SiceeWPrezzi> list = jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DESCRIZIONE = ? AND ? BETWEEN DT_INIZIO AND COALESCE(DT_FINE,SYSDATE)", this,descrizione,dataTransazione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}
	

	
	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'PREZZO_REGISTRAZIONE = :prezzoRegistrazione'.
	 */
	/*
	public List<SiceeWPrezzi> findWherePrezzoRegistrazioneEquals(Float prezzoRegistrazione) throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA FROM " + getTableName() + " WHERE PREZZO_REGISTRAZIONE = ? ORDER BY PREZZO_REGISTRAZIONE", this,prezzoRegistrazione);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}
	*/
	
	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'PREZZO_ACE = :prezzoAce'.
	 */
	/*
	public List<SiceeWPrezzi> findWherePrezzoAceEquals(Float prezzoAce) throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA FROM " + getTableName() + " WHERE PREZZO_ACE = ? ORDER BY PREZZO_ACE", this,prezzoAce);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}
	*/
	
	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria ''.
	 */
	
	public List<SiceeWPrezzi> findAll() throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " ORDER BY ID_PREZZI", this);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DESCRIZIONE = :descrizione'.
	 */
	public List<SiceeWPrezzi> findWhereDescrizioneEquals(String descrizione) throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DESCRIZIONE = ? ORDER BY DESCRIZIONE", this,descrizione);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'VALUTA = :valuta'.
	 */
	public List<SiceeWPrezzi> findWhereValutaEquals(Float valuta) throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE VALUTA = ? ORDER BY VALUTA", this,valuta);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'ID_PREZZI = :idPrezzi'.
	 */
	public List<SiceeWPrezzi> findWhereIdPrezziEquals(Integer idPrezzi) throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE ID_PREZZI = ? ORDER BY ID_PREZZI", this,idPrezzi);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DT_INIZIO = :dtInizio'.
	 */
	public List<SiceeWPrezzi> findWhereDtInizioEquals(Date dtInizio) throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DT_INIZIO = ? ORDER BY DT_INIZIO", this,dtInizio);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DT_FINE = :dtFine'.
	 */
	public List<SiceeWPrezzi> findWhereDtFineEquals(Date dtFine) throws SiceeWPrezziDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DESCRIZIONE, VALUTA, ID_PREZZI, DT_INIZIO, DT_FINE FROM " + getTableName() + " WHERE DT_FINE = ? ORDER BY DT_FINE", this,dtFine);
		}
		catch (Exception e) {
			throw new SiceeWPrezziDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_W_PREZZI table that matches the specified primary-key value.
	 */
	public SiceeWPrezzi findByPrimaryKey(SiceeWPrezziPk pk) throws SiceeWPrezziDaoException
	{
		return findByPrimaryKey( pk.getIdPrezzi() );
	}


}
