/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoSostDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoSost;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoSostPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMotivoSostDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeDMotivoSostDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDMotivoSost>, SiceeDMotivoSostDao
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
	 * @return SiceeDMotivoSostPk
	 */
	public SiceeDMotivoSostPk insert(SiceeDMotivoSost dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO ) VALUES ( ?, ?, ?, ?, ? )",dto.getIdMotivoSost(),dto.getDescr(),dto.getMin(),dto.getMax(),dto.getFlgCombo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_MOTIVO_SOST table.
	 */
	public void update(SiceeDMotivoSostPk pk, SiceeDMotivoSost dto) throws SiceeDMotivoSostDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_MOTIVO_SOST = ?, DESCR = ?, MIN = ?, MAX = ?, FLG_VISIBILE_COMBO = ? WHERE ID_MOTIVO_SOST = ?",dto.getIdMotivoSost(),dto.getDescr(),dto.getMin(),dto.getMax(),dto.getFlgCombo(),pk.getIdMotivoSost());
	}

	/** 
	 * Deletes a single row in the SICEE_D_MOTIVO_SOST table.
	 */
	public void delete(SiceeDMotivoSostPk pk) throws SiceeDMotivoSostDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_MOTIVO_SOST = ?",pk.getIdMotivoSost());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDMotivoSost
	 */
	public SiceeDMotivoSost mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDMotivoSost dto = new SiceeDMotivoSost();
		dto.setIdMotivoSost( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setMin( new Integer( rs.getInt(3) ) );
		if (rs.wasNull()) {
			dto.setMin( null );
		}
		
		dto.setMax( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setMax( null );
		}
		
		dto.setFlgCombo( rs.getString( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_MOTIVO_SOST";
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'ID_MOTIVO_SOST = :idMotivoSost'.
	 */
	public SiceeDMotivoSost findByPrimaryKey(Integer idMotivoSost) throws SiceeDMotivoSostDaoException
	{
		try {
			List<SiceeDMotivoSost> list = jdbcTemplate.query("SELECT ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO FROM " + getTableName() + " WHERE ID_MOTIVO_SOST = ?", this,idMotivoSost);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDMotivoSostDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria ''.
	 */
	public List<SiceeDMotivoSost> findAll() throws SiceeDMotivoSostDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO FROM " + getTableName() + " ORDER BY ID_MOTIVO_SOST", this);
		}
		catch (Exception e) {
			throw new SiceeDMotivoSostDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'ID_MOTIVO_SOST = :idMotivoSost'.
	 */
	public List<SiceeDMotivoSost> findWhereIdMotivoSostEquals(Integer idMotivoSost) throws SiceeDMotivoSostDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO FROM " + getTableName() + " WHERE ID_MOTIVO_SOST = ? ORDER BY ID_MOTIVO_SOST", this,idMotivoSost);
		}
		catch (Exception e) {
			throw new SiceeDMotivoSostDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDMotivoSost> findWhereDescrEquals(String descr) throws SiceeDMotivoSostDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDMotivoSostDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'MIN = :min'.
	 */
	public List<SiceeDMotivoSost> findWhereMinEquals(Integer min) throws SiceeDMotivoSostDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO FROM " + getTableName() + " WHERE MIN = ? ORDER BY MIN", this,min);
		}
		catch (Exception e) {
			throw new SiceeDMotivoSostDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'MAX = :max'.
	 */
	public List<SiceeDMotivoSost> findWhereMaxEquals(Integer max) throws SiceeDMotivoSostDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO FROM " + getTableName() + " WHERE MAX = ? ORDER BY MAX", this,max);
		}
		catch (Exception e) {
			throw new SiceeDMotivoSostDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'FLG_VISIBILE_COMBO = 'S''.
	 */
	public List<SiceeDMotivoSost> findWhereFlagComboEqualsS() throws SiceeDMotivoSostDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO_SOST, DESCR, MIN, MAX, FLG_VISIBILE_COMBO FROM " + getTableName() + " WHERE FLG_VISIBILE_COMBO = 'S'", this);
		}
		catch (Exception e) {
			throw new SiceeDMotivoSostDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_MOTIVO_SOST table that matches the specified primary-key value.
	 */
	public SiceeDMotivoSost findByPrimaryKey(SiceeDMotivoSostPk pk) throws SiceeDMotivoSostDaoException
	{
		return findByPrimaryKey( pk.getIdMotivoSost() );
	}

}
