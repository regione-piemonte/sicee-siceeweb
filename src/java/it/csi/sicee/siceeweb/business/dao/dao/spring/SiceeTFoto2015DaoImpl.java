/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDaticatastSecDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTFoto2015DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTFoto2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTFoto2015>, SiceeTFoto2015Dao
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
	 * @return SiceeTFoto2015Pk
	 */
	
	public SiceeTFoto2015Pk insert(SiceeTFoto2015 dto)
	{
		dto.setIdFoto(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdFoto(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdentificFoto(),dto.getNomeFoto(),dto.getDtFoto(),dto.getFlgPrincipale(),dto.getFkTipoFoto());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_FOTO_2015 table.
	 */
	
	public void update(SiceeTFoto2015Pk pk, SiceeTFoto2015 dto) throws SiceeTFoto2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_FOTO = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, IDENTIFIC_FOTO = ?, NOME_FOTO = ?, DT_FOTO = ?, FLG_PRINCIPALE = ?, FK_TIPO_FOTO = ? WHERE ID_FOTO = ?",dto.getIdFoto(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdentificFoto(),dto.getNomeFoto(),dto.getDtFoto(),dto.getFlgPrincipale(),dto.getFkTipoFoto(),pk.getIdFoto());
	}

	/** 
	 * Deletes a single row in the SICEE_T_FOTO_2015 table.
	 */
	
	public void delete(SiceeTFoto2015Pk pk) throws SiceeTFoto2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_FOTO = ?",pk.getIdFoto());
	}

	/** 
	 * Deletes rows in the SICEE_T_FOTO_2015 table.
	 */
	
	public void deleteByPkCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTFoto2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore, progrCertificato, anno);
	}

	/** 
	 * Deletes a single row in the SICEE_T_FOTO_2015 table.
	 */
	
	public void deleteByIdentificFoto(String identificFoto) throws SiceeTFoto2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE IDENTIFIC_FOTO = ?",identificFoto);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTFoto2015
	 */
	public SiceeTFoto2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTFoto2015 dto = new SiceeTFoto2015();
		dto.setIdFoto( rs.getLong( 1 ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setIdentificFoto( rs.getString( 5 ) );
		dto.setNomeFoto( rs.getString( 6 ) );
		dto.setDtFoto( rs.getTimestamp(7 ) );
		dto.setFlgPrincipale( rs.getString( 8 ) );
		dto.setFkTipoFoto( rs.getLong( 9 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_FOTO_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_FOTO = :idFoto'.
	 */
	
	public SiceeTFoto2015 findByPrimaryKey(long idFoto) throws SiceeTFoto2015DaoException
	{
		try {
			List<SiceeTFoto2015> list = jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE ID_FOTO = ?", this,idFoto);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno and FLG_PRINCIPALE = flgPrincipale'.
	 */
	public List<SiceeTFoto2015> findBySiceeTCertificatoFlgPrincipale(String idCertificatore, String progrCertificato, String anno, String flgPrincipale) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND FLG_PRINCIPALE = ?", this,idCertificatore,progrCertificato,anno,flgPrincipale);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTFoto2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}
	
	
	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTFoto2015> findAll() throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " ORDER BY ID_FOTO", this);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'FK_TIPO_FOTO = :fkTipoFoto'.
	 */
	
	public List<SiceeTFoto2015> findBySiceeDTipoFoto2015(long fkTipoFoto) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE FK_TIPO_FOTO = ?", this,fkTipoFoto);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_FOTO = :idFoto'.
	 */
	
	public List<SiceeTFoto2015> findWhereIdFotoEquals(long idFoto) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE ID_FOTO = ? ORDER BY ID_FOTO", this,idFoto);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTFoto2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTFoto2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTFoto2015> findWhereAnnoEquals(String anno) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'IDENTIFIC_FOTO = :identificFoto'.
	 */
	
	public List<SiceeTFoto2015> findWhereIdentificFotoEquals(String identificFoto) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE IDENTIFIC_FOTO = ? ORDER BY IDENTIFIC_FOTO", this,identificFoto);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'NOME_FOTO = :nomeFoto'.
	 */
	
	public List<SiceeTFoto2015> findWhereNomeFotoEquals(String nomeFoto) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE NOME_FOTO = ? ORDER BY NOME_FOTO", this,nomeFoto);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'DT_FOTO = :dtFoto'.
	 */
	
	public List<SiceeTFoto2015> findWhereDtFotoEquals(Date dtFoto) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE DT_FOTO = ? ORDER BY DT_FOTO", this,dtFoto);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'FLG_PRINCIPALE = :flgPrincipale'.
	 */
	
	public List<SiceeTFoto2015> findWhereFlgPrincipaleEquals(String flgPrincipale) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE FLG_PRINCIPALE = ? ORDER BY FLG_PRINCIPALE", this,flgPrincipale);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'FK_TIPO_FOTO = :fkTipoFoto'.
	 */
	
	public List<SiceeTFoto2015> findWhereFkTipoFotoEquals(long fkTipoFoto) throws SiceeTFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_FOTO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, IDENTIFIC_FOTO, NOME_FOTO, DT_FOTO, FLG_PRINCIPALE, FK_TIPO_FOTO FROM " + getTableName() + " WHERE FK_TIPO_FOTO = ? ORDER BY FK_TIPO_FOTO", this,fkTipoFoto);
		}
		catch (Exception e) {
			throw new SiceeTFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_FOTO_2015 table that matches the specified primary-key value.
	 */
	public SiceeTFoto2015 findByPrimaryKey(SiceeTFoto2015Pk pk) throws SiceeTFoto2015DaoException
	{
		return findByPrimaryKey( pk.getIdFoto() );
	}

}
