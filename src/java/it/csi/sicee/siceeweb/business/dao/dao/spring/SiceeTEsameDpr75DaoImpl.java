/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEsameDpr75Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsameDpr75;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsameDpr75Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTEsameDpr75DaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTEsameDpr75DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTEsameDpr75>, SiceeTEsameDpr75Dao
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
	 * @return SiceeTEsameDpr75Pk
	 */
	
	public SiceeTEsameDpr75Pk insert(SiceeTEsameDpr75 dto)
	{
		dto.setIdDatiEsami(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdDatiEsami(),dto.getFkCertificatore(),dto.getCorsoFrequentato(),dto.getDtDal(),dto.getDtAl(),dto.getTotaleOre(),dto.getEsamePresso(),dto.getDtEsame(),dto.getAttestatoPresso(),dto.getDtAttestato());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ESAME_DPR75 table.
	 */
	
	public void update(SiceeTEsameDpr75Pk pk, SiceeTEsameDpr75 dto) throws SiceeTEsameDpr75DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DATI_ESAMI = ?, FK_CERTIFICATORE = ?, CORSO_FREQUENTATO = ?, DT_DAL = ?, DT_AL = ?, TOTALE_ORE = ?, ESAME_PRESSO = ?, DT_ESAME = ?, ATTESTATO_PRESSO = ?, DT_ATTESTATO = ? WHERE ID_DATI_ESAMI = ?",dto.getIdDatiEsami(),dto.getFkCertificatore(),dto.getCorsoFrequentato(),dto.getDtDal(),dto.getDtAl(),dto.getTotaleOre(),dto.getEsamePresso(),dto.getDtEsame(),dto.getAttestatoPresso(),dto.getDtAttestato(),pk.getIdDatiEsami());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ESAME_DPR75 table.
	 */
	
	public void delete(SiceeTEsameDpr75Pk pk) throws SiceeTEsameDpr75DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DATI_ESAMI = ?",pk.getIdDatiEsami());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTEsameDpr75
	 */
	public SiceeTEsameDpr75 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTEsameDpr75 dto = new SiceeTEsameDpr75();
		dto.setIdDatiEsami( new Integer( rs.getInt(1) ) );
		dto.setFkCertificatore( rs.getString( 2 ) );
		dto.setCorsoFrequentato( rs.getString( 3 ) );
		dto.setDtDal( rs.getTimestamp(4 ) );
		dto.setDtAl( rs.getTimestamp(5 ) );
		dto.setTotaleOre( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setTotaleOre( null );
		}
		
		dto.setEsamePresso( rs.getString( 7 ) );
		dto.setDtEsame( rs.getTimestamp(8 ) );
		dto.setAttestatoPresso( rs.getString( 9 ) );
		dto.setDtAttestato( rs.getTimestamp(10 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_ESAME_DPR75";
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	
	public SiceeTEsameDpr75 findByPrimaryKey(Integer idDatiEsami) throws SiceeTEsameDpr75DaoException
	{
		try {
			List<SiceeTEsameDpr75> list = jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE ID_DATI_ESAMI = ?", this,idDatiEsami);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'IDENTIFIC_ATTESTATO = :identificAttestato'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereIdentificAttestatoEquals(String identificAttestato) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE IDENTIFIC_ATTESTATO = ? ORDER BY IDENTIFIC_ATTESTATO", this,identificAttestato);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria ''.
	 */
	
	public List<SiceeTEsameDpr75> findAll() throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " ORDER BY ID_DATI_ESAMI", this);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public SiceeTEsameDpr75 findBySiceeTCertificatore(String fkCertificatore) throws SiceeTEsameDpr75DaoException
	{
		try {
			List<SiceeTEsameDpr75> list = jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ?", this,fkCertificatore);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereIdDatiEsamiEquals(Integer idDatiEsami) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE ID_DATI_ESAMI = ? ORDER BY ID_DATI_ESAMI", this,idDatiEsami);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? ORDER BY FK_CERTIFICATORE", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'CORSO_FREQUENTATO = :corsoFrequentato'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereCorsoFrequentatoEquals(String corsoFrequentato) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE CORSO_FREQUENTATO = ? ORDER BY CORSO_FREQUENTATO", this,corsoFrequentato);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_DAL = :dtDal'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereDtDalEquals(Date dtDal) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE DT_DAL = ? ORDER BY DT_DAL", this,dtDal);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_AL = :dtAl'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereDtAlEquals(Date dtAl) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE DT_AL = ? ORDER BY DT_AL", this,dtAl);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'TOTALE_ORE = :totaleOre'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereTotaleOreEquals(Integer totaleOre) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE TOTALE_ORE = ? ORDER BY TOTALE_ORE", this,totaleOre);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ESAME_PRESSO = :esamePresso'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereEsamePressoEquals(String esamePresso) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE ESAME_PRESSO = ? ORDER BY ESAME_PRESSO", this,esamePresso);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_ESAME = :dtEsame'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereDtEsameEquals(Date dtEsame) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE DT_ESAME = ? ORDER BY DT_ESAME", this,dtEsame);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ATTESTATO_PRESSO = :attestatoPresso'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereAttestatoPressoEquals(String attestatoPresso) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE ATTESTATO_PRESSO = ? ORDER BY ATTESTATO_PRESSO", this,attestatoPresso);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_ATTESTATO = :dtAttestato'.
	 */
	
	public List<SiceeTEsameDpr75> findWhereDtAttestatoEquals(Date dtAttestato) throws SiceeTEsameDpr75DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATI_ESAMI, FK_CERTIFICATORE, CORSO_FREQUENTATO, DT_DAL, DT_AL, TOTALE_ORE, ESAME_PRESSO, DT_ESAME, ATTESTATO_PRESSO, DT_ATTESTATO FROM " + getTableName() + " WHERE DT_ATTESTATO = ? ORDER BY DT_ATTESTATO", this,dtAttestato);
		}
		catch (Exception e) {
			throw new SiceeTEsameDpr75DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ESAME_DPR75 table that matches the specified primary-key value.
	 */
	public SiceeTEsameDpr75 findByPrimaryKey(SiceeTEsameDpr75Pk pk) throws SiceeTEsameDpr75DaoException
	{
		return findByPrimaryKey( pk.getIdDatiEsami() );
	}

}
