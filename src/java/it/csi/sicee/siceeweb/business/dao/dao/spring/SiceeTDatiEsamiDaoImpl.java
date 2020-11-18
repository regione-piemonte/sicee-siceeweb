/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiEsamiDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsami;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsamiPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiEsamiDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDatiEsamiDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDatiEsami>, SiceeTDatiEsamiDao
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
	 * @return SiceeTDatiEsamiPk
	 */
	
	public SiceeTDatiEsamiPk insert(SiceeTDatiEsami dto)
	{
		dto.setIdDatiEsami(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdDatiEsami(),dto.getFkCertificatore(),dto.getCorsoFrequentato(),dto.getDtModulo1Da(),dto.getDtModulo1A(),dto.getDtModulo2Da(),dto.getDtModulo2A(),dto.getTotaleOre(),dto.getAttPartecipEmesso(),dto.getDtAttPartecip(),dto.getAttEsamePresso(),dto.getDtAttEsame());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATI_ESAMI table.
	 */
	
	public void update(SiceeTDatiEsamiPk pk, SiceeTDatiEsami dto) throws SiceeTDatiEsamiDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DATI_ESAMI = ?, FK_CERTIFICATORE = ?, CORSO_FREQUENTATO = ?, DT_MODULO1_DA = ?, DT_MODULO1_A = ?, DT_MODULO2_DA = ?, DT_MODULO2_A = ?, TOTALE_ORE = ?, ATT_PARTECIP_EMESSO = ?, DT_ATT_PARTECIP = ?, ATT_ESAME_PRESSO = ?, DT_ATT_ESAME = ? WHERE ID_DATI_ESAMI = ?",dto.getIdDatiEsami(),dto.getFkCertificatore(),dto.getCorsoFrequentato(),dto.getDtModulo1Da(),dto.getDtModulo1A(),dto.getDtModulo2Da(),dto.getDtModulo2A(),dto.getTotaleOre(),dto.getAttPartecipEmesso(),dto.getDtAttPartecip(),dto.getAttEsamePresso(),dto.getDtAttEsame(),pk.getIdDatiEsami());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_ESAMI table.
	 */
	
	public void delete(SiceeTDatiEsamiPk pk) throws SiceeTDatiEsamiDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DATI_ESAMI = ?",pk.getIdDatiEsami());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDatiEsami
	 */
	public SiceeTDatiEsami mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDatiEsami dto = new SiceeTDatiEsami();
		dto.setIdDatiEsami( new Integer( rs.getInt(1) ) );
		dto.setFkCertificatore( rs.getString( 2 ) );
		dto.setCorsoFrequentato( rs.getString( 3 ) );
		dto.setDtModulo1Da( rs.getTimestamp(4 ) );
		dto.setDtModulo1A( rs.getTimestamp(5 ) );
		dto.setDtModulo2Da( rs.getTimestamp(6 ) );
		dto.setDtModulo2A( rs.getTimestamp(7 ) );
		dto.setTotaleOre( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setTotaleOre( null );
		}
		
		dto.setAttPartecipEmesso( rs.getString( 9 ) );
		dto.setDtAttPartecip( rs.getTimestamp(10 ) );
		dto.setAttEsamePresso( rs.getString( 11 ) );
		dto.setDtAttEsame( rs.getTimestamp(12 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_DATI_ESAMI";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	
	public SiceeTDatiEsami findByPrimaryKey(Integer idDatiEsami) throws SiceeTDatiEsamiDaoException
	{
		try {
			List<SiceeTDatiEsami> list = jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE ID_DATI_ESAMI = ?", this,idDatiEsami);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria ''.
	 */
	
	public List<SiceeTDatiEsami> findAll() throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " ORDER BY ID_DATI_ESAMI", this);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public SiceeTDatiEsami findBySiceeTCertificatore(String fkCertificatore) throws SiceeTDatiEsamiDaoException
	{
		try {
			List<SiceeTDatiEsami> list = jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ?", this,fkCertificatore);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	
	public List<SiceeTDatiEsami> findWhereIdDatiEsamiEquals(Integer idDatiEsami) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE ID_DATI_ESAMI = ? ORDER BY ID_DATI_ESAMI", this,idDatiEsami);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTDatiEsami> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? ORDER BY FK_CERTIFICATORE", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'CORSO_FREQUENTATO = :corsoFrequentato'.
	 */
	
	public List<SiceeTDatiEsami> findWhereCorsoFrequentatoEquals(String corsoFrequentato) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE CORSO_FREQUENTATO = ? ORDER BY CORSO_FREQUENTATO", this,corsoFrequentato);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO1_DA = :dtModulo1Da'.
	 */
	
	public List<SiceeTDatiEsami> findWhereDtModulo1DaEquals(Date dtModulo1Da) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE DT_MODULO1_DA = ? ORDER BY DT_MODULO1_DA", this,dtModulo1Da);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO1_A = :dtModulo1A'.
	 */
	
	public List<SiceeTDatiEsami> findWhereDtModulo1AEquals(Date dtModulo1A) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE DT_MODULO1_A = ? ORDER BY DT_MODULO1_A", this,dtModulo1A);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO2_DA = :dtModulo2Da'.
	 */
	
	public List<SiceeTDatiEsami> findWhereDtModulo2DaEquals(Date dtModulo2Da) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE DT_MODULO2_DA = ? ORDER BY DT_MODULO2_DA", this,dtModulo2Da);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO2_A = :dtModulo2A'.
	 */
	
	public List<SiceeTDatiEsami> findWhereDtModulo2AEquals(Date dtModulo2A) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE DT_MODULO2_A = ? ORDER BY DT_MODULO2_A", this,dtModulo2A);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'TOTALE_ORE = :totaleOre'.
	 */
	
	public List<SiceeTDatiEsami> findWhereTotaleOreEquals(Integer totaleOre) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE TOTALE_ORE = ? ORDER BY TOTALE_ORE", this,totaleOre);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ATT_PARTECIP_EMESSO = :attPartecipEmesso'.
	 */
	
	public List<SiceeTDatiEsami> findWhereAttPartecipEmessoEquals(String attPartecipEmesso) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE ATT_PARTECIP_EMESSO = ? ORDER BY ATT_PARTECIP_EMESSO", this,attPartecipEmesso);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_ATT_PARTECIP = :dtAttPartecip'.
	 */
	
	public List<SiceeTDatiEsami> findWhereDtAttPartecipEquals(Date dtAttPartecip) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE DT_ATT_PARTECIP = ? ORDER BY DT_ATT_PARTECIP", this,dtAttPartecip);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ATT_ESAME_PRESSO = :attEsamePresso'.
	 */
	
	public List<SiceeTDatiEsami> findWhereAttEsamePressoEquals(String attEsamePresso) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE ATT_ESAME_PRESSO = ? ORDER BY ATT_ESAME_PRESSO", this,attEsamePresso);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_ATT_ESAME = :dtAttEsame'.
	 */
	
	public List<SiceeTDatiEsami> findWhereDtAttEsameEquals(Date dtAttEsame) throws SiceeTDatiEsamiDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_MODULO1_DA, DT_MODULO1_A, DT_MODULO2_DA, DT_MODULO2_A, TOTALE_ORE, ATT_PARTECIP_EMESSO, DT_ATT_PARTECIP, ATT_ESAME_PRESSO, DT_ATT_ESAME FROM " + getTableName() + " WHERE DT_ATT_ESAME = ? ORDER BY DT_ATT_ESAME", this,dtAttEsame);
		}
		catch (Exception e) {
			throw new SiceeTDatiEsamiDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DATI_ESAMI table that matches the specified primary-key value.
	 */
	public SiceeTDatiEsami findByPrimaryKey(SiceeTDatiEsamiPk pk) throws SiceeTDatiEsamiDaoException
	{
		return findByPrimaryKey( pk.getIdDatiEsami() );
	}

}
