/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRaccomandazioniDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomandazioni;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomandazioniPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRaccomandazioniDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTRaccomandazioniDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTRaccomandazioni>, SiceeTRaccomandazioniDao
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
	 * @return SiceeTRaccomandazioniPk
	 */
	
	public SiceeTRaccomandazioniPk insert(SiceeTRaccomandazioni dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO ) VALUES ( ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getPriorita(),dto.getSistema(),dto.getIntervento(),dto.getTempoRitorno());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_RACCOMANDAZIONI table.
	 */
	
	public void update(SiceeTRaccomandazioniPk pk, SiceeTRaccomandazioni dto) throws SiceeTRaccomandazioniDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, PRIORITA = ?, SISTEMA = ?, INTERVENTO = ?, TEMPO_RITORNO = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PRIORITA = ? AND SISTEMA = ? AND INTERVENTO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getPriorita(),dto.getSistema(),dto.getIntervento(),dto.getTempoRitorno(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getPriorita(),pk.getSistema(),pk.getIntervento());
	}

	/** 
	 * Deletes a single row in the SICEE_T_RACCOMANDAZIONI table.
	 */
	
	public void delete(SiceeTRaccomandazioniPk pk) throws SiceeTRaccomandazioniDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PRIORITA = ? AND SISTEMA = ? AND INTERVENTO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getPriorita(),pk.getSistema(),pk.getIntervento());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTRaccomandazioni
	 */
	public SiceeTRaccomandazioni mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTRaccomandazioni dto = new SiceeTRaccomandazioni();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setPriorita( rs.getString( 4 ) );
		dto.setSistema( rs.getString( 5 ) );
		dto.setIntervento( rs.getString( 6 ) );
		dto.setTempoRitorno( rs.getString( 7 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_RACCOMANDAZIONI";
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PRIORITA = :priorita AND SISTEMA = :sistema AND INTERVENTO = :intervento'.
	 */
	
	public SiceeTRaccomandazioni findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, String priorita, String sistema, String intervento) throws SiceeTRaccomandazioniDaoException
	{
		try {
			List<SiceeTRaccomandazioni> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND PRIORITA = ? AND SISTEMA = ? AND INTERVENTO = ?", this,idCertificatore,progrCertificato,anno,priorita,sistema,intervento);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria ''.
	 */
	
	public List<SiceeTRaccomandazioni> findAll() throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO", this);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTRaccomandazioni> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ORDER BY SISTEMA ASC", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTRaccomandazioni> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTRaccomandazioni> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTRaccomandazioni> findWhereAnnoEquals(String anno) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'PRIORITA = :priorita'.
	 */
	
	public List<SiceeTRaccomandazioni> findWherePrioritaEquals(String priorita) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE PRIORITA = ? ORDER BY PRIORITA", this,priorita);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'SISTEMA = :sistema'.
	 */
	
	public List<SiceeTRaccomandazioni> findWhereSistemaEquals(String sistema) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE SISTEMA = ? ORDER BY SISTEMA", this,sistema);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'INTERVENTO = :intervento'.
	 */
	
	public List<SiceeTRaccomandazioni> findWhereInterventoEquals(String intervento) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE INTERVENTO = ? ORDER BY INTERVENTO", this,intervento);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'TEMPO_RITORNO = :tempoRitorno'.
	 */
	
	public List<SiceeTRaccomandazioni> findWhereTempoRitornoEquals(String tempoRitorno) throws SiceeTRaccomandazioniDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, PRIORITA, SISTEMA, INTERVENTO, TEMPO_RITORNO FROM " + getTableName() + " WHERE TEMPO_RITORNO = ? ORDER BY TEMPO_RITORNO", this,tempoRitorno);
		}
		catch (Exception e) {
			throw new SiceeTRaccomandazioniDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_RACCOMANDAZIONI table that matches the specified primary-key value.
	 */
	public SiceeTRaccomandazioni findByPrimaryKey(SiceeTRaccomandazioniPk pk) throws SiceeTRaccomandazioniDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno(), pk.getPriorita(), pk.getSistema(), pk.getIntervento() );
	}

}
