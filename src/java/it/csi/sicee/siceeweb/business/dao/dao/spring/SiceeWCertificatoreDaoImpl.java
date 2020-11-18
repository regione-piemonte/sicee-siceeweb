/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeWCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWCertificatorePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWCertificatoreDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeWCertificatoreDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeWCertificatore>, SiceeWCertificatoreDao
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
	 * @return SiceeWCertificatorePk
	 */
	
	public SiceeWCertificatorePk insert(SiceeWCertificatore dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO ) VALUES ( ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_W_CERTIFICATORE table.
	 */
	
	public void update(SiceeWCertificatorePk pk, SiceeWCertificatore dto) throws SiceeWCertificatoreDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ? WHERE ID_CERTIFICATORE = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),pk.getIdCertificatore(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_W_CERTIFICATORE table.
	 */
	
	public void delete(SiceeWCertificatorePk pk) throws SiceeWCertificatoreDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeWCertificatore
	 */
	public SiceeWCertificatore mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeWCertificatore dto = new SiceeWCertificatore();
		dto.setIdCertificatore( new Integer( rs.getInt(1) ) );
		dto.setProgrCertificato( new Integer( rs.getInt(2) ) );
		if (rs.wasNull()) {
			dto.setProgrCertificato( null );
		}
		
		dto.setAnno( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_W_CERTIFICATORE";
	}

	/** 
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND ANNO = :anno'.
	 */
	
	public SiceeWCertificatore findByPrimaryKey(Integer idCertificatore, String anno) throws SiceeWCertificatoreDaoException
	{
		try {
			List<SiceeWCertificatore> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND ANNO = ?", this,idCertificatore,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeWCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria ''.
	 */
	
	public List<SiceeWCertificatore> findAll() throws SiceeWCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeWCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeWCertificatore> findWhereIdCertificatoreEquals(Integer idCertificatore) throws SiceeWCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeWCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeWCertificatore> findWhereProgrCertificatoEquals(Integer progrCertificato) throws SiceeWCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeWCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeWCertificatore> findWhereAnnoEquals(String anno) throws SiceeWCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeWCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_W_CERTIFICATORE table that matches the specified primary-key value.
	 */
	public SiceeWCertificatore findByPrimaryKey(SiceeWCertificatorePk pk) throws SiceeWCertificatoreDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getAnno() );
	}

}
