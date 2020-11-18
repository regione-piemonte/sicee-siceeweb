/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImportDati2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImportDati2015DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTImportDati2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTImportDati2015>, SiceeTImportDati2015Dao
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
	 * @return SiceeTImportDati2015Pk
	 */
	public SiceeTImportDati2015Pk insert(SiceeTImportDati2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO ) VALUES ( ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getNomeXml(),dto.getUidIndex(),dto.getDtCaricamento());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	public void update(SiceeTImportDati2015Pk pk, SiceeTImportDati2015 dto) throws SiceeTImportDati2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, NOME_XML = ?, UID_INDEX = ?, DT_CARICAMENTO = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getNomeXml(),dto.getUidIndex(),dto.getDtCaricamento(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	public void delete(SiceeTImportDati2015Pk pk) throws SiceeTImportDati2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDati2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore,progrCertificato,anno);
	}

	/** 
	 * Delete all rows in the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'UID_INDEX = :uidIndex.
	 */
	public void deleteByUidIndex(String uidIndex) throws SiceeTImportDati2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE UID_INDEX = ?",uidIndex);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTImportDati2015
	 */
	public SiceeTImportDati2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTImportDati2015 dto = new SiceeTImportDati2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setNomeXml( rs.getString( 4 ) );
		dto.setUidIndex( rs.getString( 5 ) );
		dto.setDtCaricamento( rs.getTimestamp(6 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_IMPORT_DATI_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTImportDati2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDati2015DaoException
	{
		try {
			List<SiceeTImportDati2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria ''.
	 */
	public List<SiceeTImportDati2015> findAll() throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	
	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTImportDati2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTImportDati2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTImportDati2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTImportDati2015> findWhereAnnoEquals(String anno) throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'NOME_XML = :nomeXml'.
	 */
	public List<SiceeTImportDati2015> findWhereNomeXmlEquals(String nomeXml) throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE NOME_XML = ? ORDER BY NOME_XML", this,nomeXml);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'UID_INDEX = :uidIndex'.
	 */
	public List<SiceeTImportDati2015> findWhereUidIndexEquals(String uidIndex) throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE UID_INDEX = ? ORDER BY UID_INDEX", this,uidIndex);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPORT_DATI_2015 table that match the criteria 'DT_CARICAMENTO = :dtCaricamento'.
	 */
	public List<SiceeTImportDati2015> findWhereDtCaricamentoEquals(Date dtCaricamento) throws SiceeTImportDati2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, NOME_XML, UID_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE DT_CARICAMENTO = ? ORDER BY DT_CARICAMENTO", this,dtCaricamento);
		}
		catch (Exception e) {
			throw new SiceeTImportDati2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_IMPORT_DATI_2015 table that matches the specified primary-key value.
	 */
	public SiceeTImportDati2015 findByPrimaryKey(SiceeTImportDati2015Pk pk) throws SiceeTImportDati2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
