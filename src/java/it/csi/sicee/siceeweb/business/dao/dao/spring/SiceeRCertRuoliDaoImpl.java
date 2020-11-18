/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCertRuoliDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertRuoli;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertRuoliPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRCertRuoliDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeRCertRuoliDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeRCertRuoli>, SiceeRCertRuoliDao
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
	 * @return SiceeRCertRuoliPk
	 */
	
	public SiceeRCertRuoliPk insert(SiceeRCertRuoli dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO ) VALUES ( ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgr(),dto.getAnno(),dto.getFkRuoloEdificio());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_R_CERT_RUOLI table.
	 */
	
	public void update(SiceeRCertRuoliPk pk, SiceeRCertRuoli dto) throws SiceeRCertRuoliDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR = ?, ANNO = ?, FK_RUOLO_EDIFICIO = ? WHERE ID_CERTIFICATORE = ? AND PROGR = ? AND ANNO = ? AND FK_RUOLO_EDIFICIO = ?",dto.getIdCertificatore(),dto.getProgr(),dto.getAnno(),dto.getFkRuoloEdificio(),pk.getIdCertificatore(),pk.getProgr(),pk.getAnno(),pk.getFkRuoloEdificio());
	}

	/** 
	 * Deletes a single row in the SICEE_R_CERT_RUOLI table.
	 */
	
	public void delete(SiceeRCertRuoliPk pk) throws SiceeRCertRuoliDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR = ? AND ANNO = ? AND FK_RUOLO_EDIFICIO = ?",pk.getIdCertificatore(),pk.getProgr(),pk.getAnno(),pk.getFkRuoloEdificio());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeRCertRuoli
	 */
	public SiceeRCertRuoli mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeRCertRuoli dto = new SiceeRCertRuoli();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgr( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFkRuoloEdificio( new Integer( rs.getInt(4) ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_R_CERT_RUOLI";
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR = :progr AND ANNO = :anno AND FK_RUOLO_EDIFICIO = :fkRuoloEdificio'.
	 */
	
	public SiceeRCertRuoli findByPrimaryKey(String idCertificatore, String progr, String anno, Integer fkRuoloEdificio) throws SiceeRCertRuoliDaoException
	{
		try {
			List<SiceeRCertRuoli> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR = ? AND ANNO = ? AND FK_RUOLO_EDIFICIO = ?", this,idCertificatore,progr,anno,fkRuoloEdificio);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria ''.
	 */
	
	public List<SiceeRCertRuoli> findAll() throws SiceeRCertRuoliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO", this);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR = :progr AND ANNO = :anno'.
	 */
	
	public List<SiceeRCertRuoli> findBySiceeTCertificato(String idCertificatore, String progr, String anno) throws SiceeRCertRuoliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR = ? AND ANNO = ?", this,idCertificatore,progr,anno);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'FK_RUOLO_EDIFICIO = :fkRuoloEdificio'.
	 */
	
	public List<SiceeRCertRuoli> findBySiceeTRuoliEdificio(Integer fkRuoloEdificio) throws SiceeRCertRuoliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " WHERE FK_RUOLO_EDIFICIO = ?", this,fkRuoloEdificio);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeRCertRuoli> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeRCertRuoliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'PROGR = :progr'.
	 */
	
	public List<SiceeRCertRuoli> findWhereProgrEquals(String progr) throws SiceeRCertRuoliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " WHERE PROGR = ? ORDER BY PROGR", this,progr);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeRCertRuoli> findWhereAnnoEquals(String anno) throws SiceeRCertRuoliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_CERT_RUOLI table that match the criteria 'FK_RUOLO_EDIFICIO = :fkRuoloEdificio'.
	 */
	
	public List<SiceeRCertRuoli> findWhereFkRuoloEdificioEquals(Integer fkRuoloEdificio) throws SiceeRCertRuoliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR, ANNO, FK_RUOLO_EDIFICIO FROM " + getTableName() + " WHERE FK_RUOLO_EDIFICIO = ? ORDER BY FK_RUOLO_EDIFICIO", this,fkRuoloEdificio);
		}
		catch (Exception e) {
			throw new SiceeRCertRuoliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_R_CERT_RUOLI table that matches the specified primary-key value.
	 */
	public SiceeRCertRuoli findByPrimaryKey(SiceeRCertRuoliPk pk) throws SiceeRCertRuoliDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgr(), pk.getAnno(), pk.getFkRuoloEdificio() );
	}

}
