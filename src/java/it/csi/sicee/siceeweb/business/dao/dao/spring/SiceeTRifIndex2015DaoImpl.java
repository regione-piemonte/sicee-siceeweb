/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRifIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRifIndex2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTRifIndex2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTRifIndex2015>, SiceeTRifIndex2015Dao
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
	 * @return SiceeTRifIndex2015Pk
	 */
	
	public SiceeTRifIndex2015Pk insert(SiceeTRifIndex2015 dto)
	{
		dto.setIdRifIndex(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkTipoDoc(),dto.getNomeFile(),dto.getUidIndex(),dto.getHash(),dto.getIdRifIndex(), dto.getDtCaricamento());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_RIF_INDEX_2015 table.
	 */
	
	public void update(SiceeTRifIndex2015Pk pk, SiceeTRifIndex2015 dto) throws SiceeTRifIndex2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FK_TIPO_DOC = ?, NOME_FILE = ?, UID_INDEX = ?, HASH = ?, ID_RIF_INDEX = ?, DT_CARICAMENTO = ? WHERE ID_RIF_INDEX = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkTipoDoc(),dto.getNomeFile(),dto.getUidIndex(),dto.getHash(),dto.getIdRifIndex(),dto.getDtCaricamento(),pk.getIdRifIndex());
	}

	/** 
	 * Deletes a single row in the SICEE_T_RIF_INDEX_2015 table.
	 */
	
	public void delete(SiceeTRifIndex2015Pk pk) throws SiceeTRifIndex2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_RIF_INDEX = ?",pk.getIdRifIndex());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTRifIndex2015
	 */
	public SiceeTRifIndex2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTRifIndex2015 dto = new SiceeTRifIndex2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFkTipoDoc( new Integer( rs.getInt(4) ) );
		dto.setNomeFile( rs.getString( 5 ) );
		dto.setUidIndex( rs.getString( 6 ) );
		dto.setHash( rs.getString( 7 ) );
		dto.setIdRifIndex( rs.getLong( 8 ) );
		dto.setDtCaricamento(  rs.getTimestamp(9 ) );

		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_RIF_INDEX_2015";
	}
	
	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_RIF_INDEX = :idRifIndex'.
	 */
	public SiceeTRifIndex2015 findByPrimaryKey(long idRifIndex) throws SiceeTRifIndex2015DaoException
	{
		try {
			List<SiceeTRifIndex2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ID_RIF_INDEX = ?", this,idRifIndex);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTRifIndex2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno' AND 'FK_TIPO_DOC = :fkTipoDoc'.
	 */
	public SiceeTRifIndex2015 findBySiceeTCertificatoidTipoDoc(String idCertificatore, String progrCertificato, String anno, Integer fkTipoDoc) throws SiceeTRifIndex2015DaoException
	{
		try {
			List<SiceeTRifIndex2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND FK_TIPO_DOC = ?", this,idCertificatore,progrCertificato,anno,fkTipoDoc);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
	}
	
	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTRifIndex2015> findAll() throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'FK_TIPO_DOC = :fkTipoDoc'.
	 */
	
	public List<SiceeTRifIndex2015> findBySiceeDTipoDocIndex2015(Integer fkTipoDoc) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE FK_TIPO_DOC = ?", this,fkTipoDoc);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTRifIndex2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTRifIndex2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTRifIndex2015> findWhereAnnoEquals(String anno) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'FK_TIPO_DOC = :fkTipoDoc'.
	 */
	
	public List<SiceeTRifIndex2015> findWhereFkTipoDocEquals(Integer fkTipoDoc) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE FK_TIPO_DOC = ? ORDER BY FK_TIPO_DOC", this,fkTipoDoc);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'NOME_FILE = :nomeFile'.
	 */
	
	public List<SiceeTRifIndex2015> findWhereNomeFileEquals(String nomeFile) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE NOME_FILE = ? ORDER BY NOME_FILE", this,nomeFile);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'UID_INDEX = :uidIndex'.
	 */
	
	public List<SiceeTRifIndex2015> findWhereUidIndexEquals(String uidIndex) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE UID_INDEX = ? ORDER BY UID_INDEX", this,uidIndex);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RIF_INDEX_2015 table that match the criteria 'HASH = :hash'.
	 */
	
	public List<SiceeTRifIndex2015> findWhereHashEquals(String hash) throws SiceeTRifIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_DOC, NOME_FILE, UID_INDEX, HASH, ID_RIF_INDEX, DT_CARICAMENTO FROM " + getTableName() + " WHERE HASH = ? ORDER BY HASH", this,hash);
		}
		catch (Exception e) {
			throw new SiceeTRifIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_RIF_INDEX_2015 table that matches the specified primary-key value.
	 */
	public SiceeTRifIndex2015 findByPrimaryKey(SiceeTRifIndex2015Pk pk) throws SiceeTRifIndex2015DaoException
	{
		return findByPrimaryKey( pk.getIdRifIndex() );
	}


}
