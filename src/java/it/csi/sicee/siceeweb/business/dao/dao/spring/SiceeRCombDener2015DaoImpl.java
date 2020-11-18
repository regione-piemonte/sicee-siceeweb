/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCombDener2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRCombDener2015DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRaccomand2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeRCombDener2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeRCombDener2015>, SiceeRCombDener2015Dao
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
	 * @return SiceeRCombDener2015Pk
	 */
	public SiceeRCombDener2015Pk insert(SiceeRCombDener2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO ) VALUES ( ?, ?, ?, ?, ? )",dto.getIdCombustibile(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDescrAltro());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_R_COMB_DENER_2015 table.
	 */
	public void update(SiceeRCombDener2015Pk pk, SiceeRCombDener2015 dto) throws SiceeRCombDener2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_COMBUSTIBILE = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, DESCR_ALTRO = ? WHERE ID_COMBUSTIBILE = ? AND ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCombustibile(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDescrAltro(),pk.getIdCombustibile(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_R_COMB_DENER_2015 table.
	 */
	public void delete(SiceeRCombDener2015Pk pk) throws SiceeRCombDener2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_COMBUSTIBILE = ? AND ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCombustibile(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes in the SICEE_R_COMB_DENER_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeRCombDener2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore, progrCertificato, anno);
	}
	
	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeRCombDener2015
	 */
	public SiceeRCombDener2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeRCombDener2015 dto = new SiceeRCombDener2015();
		dto.setIdCombustibile( new Integer( rs.getInt(1) ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setDescrAltro( rs.getString( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_R_COMB_DENER_2015";
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile AND ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeRCombDener2015 findByPrimaryKey(Integer idCombustibile, String idCertificatore, String progrCertificato, String anno) throws SiceeRCombDener2015DaoException
	{
		try {
			List<SiceeRCombDener2015> list = jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " WHERE ID_COMBUSTIBILE = ? AND ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCombustibile,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria ''.
	 */
	public List<SiceeRCombDener2015> findAll() throws SiceeRCombDener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " ORDER BY ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeRCombDener2015> findBySiceeTDatiEner2015(String idCertificatore, String progrCertificato, String anno) throws SiceeRCombDener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile'.
	 */
	public List<SiceeRCombDener2015> findWhereIdCombustibileEquals(Integer idCombustibile) throws SiceeRCombDener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " WHERE ID_COMBUSTIBILE = ? ORDER BY ID_COMBUSTIBILE", this,idCombustibile);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeRCombDener2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeRCombDener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeRCombDener2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeRCombDener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeRCombDener2015> findWhereAnnoEquals(String anno) throws SiceeRCombDener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'DESCR_ALTRO = :descrAltro'.
	 */
	public List<SiceeRCombDener2015> findWhereDescrAltroEquals(String descrAltro) throws SiceeRCombDener2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_COMBUSTIBILE, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESCR_ALTRO FROM " + getTableName() + " WHERE DESCR_ALTRO = ? ORDER BY DESCR_ALTRO", this,descrAltro);
		}
		catch (Exception e) {
			throw new SiceeRCombDener2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_R_COMB_DENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeRCombDener2015 findByPrimaryKey(SiceeRCombDener2015Pk pk) throws SiceeRCombDener2015DaoException
	{
		return findByPrimaryKey( pk.getIdCombustibile(), pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
