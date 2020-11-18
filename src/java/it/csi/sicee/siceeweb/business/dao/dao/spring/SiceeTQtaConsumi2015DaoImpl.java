/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTQtaConsumi2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTQtaConsumi2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTQtaConsumi2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTQtaConsumi2015>, SiceeTQtaConsumi2015Dao
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
	 * @return SiceeTQtaConsumi2015Pk
	 */
	
	public SiceeTQtaConsumi2015Pk insert(SiceeTQtaConsumi2015 dto)
	{
		dto.setIdQtaConsumi(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdQtaConsumi(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkCombustibile(),dto.getFkUnitaMisura(),dto.getQuantita(),dto.getAltroDescrComb());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	
	public void update(SiceeTQtaConsumi2015Pk pk, SiceeTQtaConsumi2015 dto) throws SiceeTQtaConsumi2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_QTA_CONSUMI = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FK_COMBUSTIBILE = ?, FK_UNITA_MISURA = ?, QUANTITA = ?, ALTRO_DESCR_COMB = ? WHERE ID_QTA_CONSUMI = ?",dto.getIdQtaConsumi(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkCombustibile(),dto.getFkUnitaMisura(),dto.getQuantita(),dto.getAltroDescrComb(),pk.getIdQtaConsumi());
	}

	/** 
	 * Deletes a single row in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	
	public void delete(SiceeTQtaConsumi2015Pk pk) throws SiceeTQtaConsumi2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_QTA_CONSUMI = ?",pk.getIdQtaConsumi());
	}

	/** 
	 * Deletes in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTQtaConsumi2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTQtaConsumi2015
	 */
	public SiceeTQtaConsumi2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTQtaConsumi2015 dto = new SiceeTQtaConsumi2015();
		dto.setIdQtaConsumi( rs.getLong( 1 ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setFkCombustibile( new Integer( rs.getInt(5) ) );
		dto.setFkUnitaMisura( new Integer( rs.getInt(6) ) );
		dto.setQuantita( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setQuantita( null );
		}
		
		dto.setAltroDescrComb( rs.getString( 8 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_QTA_CONSUMI_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_QTA_CONSUMI = :idQtaConsumi'.
	 */
	
	public SiceeTQtaConsumi2015 findByPrimaryKey(long idQtaConsumi) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			List<SiceeTQtaConsumi2015> list = jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE ID_QTA_CONSUMI = ?", this,idQtaConsumi);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTQtaConsumi2015> findAll() throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " ORDER BY ID_QTA_CONSUMI", this);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'FK_UNITA_MISURA = :fkUnitaMisura'.
	 */
	
	public List<SiceeTQtaConsumi2015> findBySiceeDUnitaMisura2015(Integer fkUnitaMisura) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE FK_UNITA_MISURA = ?", this,fkUnitaMisura);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_QTA_CONSUMI = :idQtaConsumi'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereIdQtaConsumiEquals(long idQtaConsumi) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE ID_QTA_CONSUMI = ? ORDER BY ID_QTA_CONSUMI", this,idQtaConsumi);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereAnnoEquals(String anno) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'FK_COMBUSTIBILE = :fkCombustibile'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereFkCombustibileEquals(Integer fkCombustibile) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE FK_COMBUSTIBILE = ? ORDER BY FK_COMBUSTIBILE", this,fkCombustibile);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'FK_UNITA_MISURA = :fkUnitaMisura'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereFkUnitaMisuraEquals(Integer fkUnitaMisura) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE FK_UNITA_MISURA = ? ORDER BY FK_UNITA_MISURA", this,fkUnitaMisura);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'QUANTITA = :quantita'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereQuantitaEquals(Double quantita) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE QUANTITA = ? ORDER BY QUANTITA", this,quantita);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ALTRO_DESCR_COMB = :altroDescrComb'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereAltroDescrCombEquals(String altroDescrComb) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE ALTRO_DESCR_COMB = ? ORDER BY ALTRO_DESCR_COMB", this,altroDescrComb);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereIdCertProgrAnno(String idCertificatore, String progrCertificato, String anno) throws SiceeTQtaConsumi2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_QTA_CONSUMI, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_COMBUSTIBILE, FK_UNITA_MISURA, QUANTITA, ALTRO_DESCR_COMB FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ORDER BY ID_QTA_CONSUMI", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTQtaConsumi2015DaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_T_QTA_CONSUMI_2015 table that matches the specified primary-key value.
	 */
	public SiceeTQtaConsumi2015 findByPrimaryKey(SiceeTQtaConsumi2015Pk pk) throws SiceeTQtaConsumi2015DaoException
	{
		return findByPrimaryKey( pk.getIdQtaConsumi() );
	}

}
