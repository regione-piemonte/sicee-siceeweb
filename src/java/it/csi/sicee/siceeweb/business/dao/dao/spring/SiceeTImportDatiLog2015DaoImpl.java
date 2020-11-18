/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImportDatiLog2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDatiLog2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDatiLog2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImportDatiLog2015DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTImportDatiLog2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTImportDatiLog2015>, SiceeTImportDatiLog2015Dao
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
	 * @return SiceeTImportDatiLog2015Pk
	 */
	public SiceeTImportDatiLog2015Pk insert(SiceeTImportDatiLog2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE ) VALUES ( ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getTimestamp(),dto.isPassoValidazioneNull()?null:dto.getPassoValidazione(),dto.getMessaggioErrore());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	public void update(SiceeTImportDatiLog2015Pk pk, SiceeTImportDatiLog2015 dto) throws SiceeTImportDatiLog2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, TIMESTAMP = ?, PASSO_VALIDAZIONE = ?, MESSAGGIO_ERRORE = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND TIMESTAMP = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getTimestamp(),dto.getPassoValidazione(),dto.getMessaggioErrore(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getTimestamp());
	}

	/** 
	 * Deletes a single row in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	public void delete(SiceeTImportDatiLog2015Pk pk) throws SiceeTImportDatiLog2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND TIMESTAMP = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getTimestamp());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTImportDatiLog2015
	 */
	public SiceeTImportDatiLog2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTImportDatiLog2015 dto = new SiceeTImportDatiLog2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setTimestamp( rs.getTimestamp(4 ) );
		dto.setPassoValidazione( new Integer(rs.getInt( 5 ) ));
		if (rs.wasNull()) {
			dto.setPassoValidazioneNull( true );
		}
		
		dto.setMessaggioErrore( rs.getString( 6 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_IMPORT_DATI_LOG_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND TIMESTAMP = :timestamp'.
	 */
	public SiceeTImportDatiLog2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Date timestamp) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			List<SiceeTImportDatiLog2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND TIMESTAMP = ?", this,idCertificatore,progrCertificato,anno,timestamp);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria ''.
	 */
	public List<SiceeTImportDatiLog2015> findAll() throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP", this);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTImportDatiLog2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereAnnoEquals(String anno) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'TIMESTAMP = :timestamp'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereTimestampEquals(Date timestamp) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE TIMESTAMP = ? ORDER BY TIMESTAMP", this,timestamp);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'PASSO_VALIDAZIONE = :passoValidazione'.
	 */
	public List<SiceeTImportDatiLog2015> findWherePassoValidazioneEquals(Integer passoValidazione) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE PASSO_VALIDAZIONE = ? ORDER BY PASSO_VALIDAZIONE", this,passoValidazione);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that match the criteria 'MESSAGGIO_ERRORE = :messaggioErrore'.
	 */
	public List<SiceeTImportDatiLog2015> findWhereMessaggioErroreEquals(String messaggioErrore) throws SiceeTImportDatiLog2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIMESTAMP, PASSO_VALIDAZIONE, MESSAGGIO_ERRORE FROM " + getTableName() + " WHERE MESSAGGIO_ERRORE = ? ORDER BY MESSAGGIO_ERRORE", this,messaggioErrore);
		}
		catch (Exception e) {
			throw new SiceeTImportDatiLog2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_IMPORT_DATI_LOG_2015 table that matches the specified primary-key value.
	 */
	public SiceeTImportDatiLog2015 findByPrimaryKey(SiceeTImportDatiLog2015Pk pk) throws SiceeTImportDatiLog2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno(), pk.getTimestamp() );
	}

}
