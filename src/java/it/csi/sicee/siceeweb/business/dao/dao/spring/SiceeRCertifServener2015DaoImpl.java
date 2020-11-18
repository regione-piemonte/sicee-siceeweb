/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCertifServener2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRCertifServener2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeRCertifServener2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeRCertifServener2015>, SiceeRCertifServener2015Dao
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
	 * @return SiceeRCertifServener2015Pk
	 */
	
	public SiceeRCertifServener2015Pk insert(SiceeRCertifServener2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN ) VALUES ( ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdServEner(),dto.getEfficienza(),dto.getEpren(),dto.getEpnren());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	
	public void update(SiceeRCertifServener2015Pk pk, SiceeRCertifServener2015 dto) throws SiceeRCertifServener2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, ID_SERV_ENER = ?, EFFICIENZA = ?, EPREN = ?, EPNREN = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND ID_SERV_ENER = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdServEner(),dto.getEfficienza(),dto.getEpren(),dto.getEpnren(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getIdServEner());
	}

	/** 
	 * Deletes a single row in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	
	public void delete(SiceeRCertifServener2015Pk pk) throws SiceeRCertifServener2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND ID_SERV_ENER = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getIdServEner());
	}
	
	/** 
	 * Deletes rows in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeRCertifServener2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore,progrCertificato,anno);
	}


	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeRCertifServener2015
	 */
	public SiceeRCertifServener2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeRCertifServener2015 dto = new SiceeRCertifServener2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setIdServEner( new Integer( rs.getInt(4) ) );
		dto.setEfficienza( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setEfficienza( null );
		}
		
		dto.setEpren( new Double( rs.getDouble(6) ) );
		if (rs.wasNull()) {
			dto.setEpren( null );
		}
		
		dto.setEpnren( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setEpnren( null );
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
		return "SICEE_R_CERTIF_SERVENER2015";
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND ID_SERV_ENER = :idServEner'.
	 */
	
	public SiceeRCertifServener2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer idServEner) throws SiceeRCertifServener2015DaoException
	{
		try {
			List<SiceeRCertifServener2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND ID_SERV_ENER = ?", this,idCertificatore,progrCertificato,anno,idServEner);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria ''.
	 */
	
	public List<SiceeRCertifServener2015> findAll() throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER", this);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeRCertifServener2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ORDER BY ID_SERV_ENER", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeRCertifServener2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeRCertifServener2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeRCertifServener2015> findWhereAnnoEquals(String anno) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_SERV_ENER = :idServEner'.
	 */
	
	public List<SiceeRCertifServener2015> findWhereIdServEnerEquals(Integer idServEner) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE ID_SERV_ENER = ? ORDER BY ID_SERV_ENER", this,idServEner);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'EFFICIENZA = :efficienza'.
	 */
	
	public List<SiceeRCertifServener2015> findWhereEfficienzaEquals(Double efficienza) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE EFFICIENZA = ? ORDER BY EFFICIENZA", this,efficienza);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'EPREN = :epren'.
	 */
	
	public List<SiceeRCertifServener2015> findWhereEprenEquals(Double epren) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE EPREN = ? ORDER BY EPREN", this,epren);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'EPNREN = :epnren'.
	 */
	
	public List<SiceeRCertifServener2015> findWhereEpnrenEquals(Double epnren) throws SiceeRCertifServener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_SERV_ENER, EFFICIENZA, EPREN, EPNREN FROM " + getTableName() + " WHERE EPNREN = ? ORDER BY EPNREN", this,epnren);
		}
		catch (Exception e) {
			throw new SiceeRCertifServener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_R_CERTIF_SERVENER2015 table that matches the specified primary-key value.
	 */
	public SiceeRCertifServener2015 findByPrimaryKey(SiceeRCertifServener2015Pk pk) throws SiceeRCertifServener2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno(), pk.getIdServEner() );
	}

}
