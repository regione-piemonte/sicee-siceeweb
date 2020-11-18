/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMotivoRilascioDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDMotivoRilascioDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDMotivoRilascio>, SiceeDMotivoRilascioDao
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
	 * @return SiceeDMotivoRilascioPk
	 */
	public SiceeDMotivoRilascioPk insert(SiceeDMotivoRilascio dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 ) VALUES ( ?, ?, ?, ?, ? )",dto.getIdMotivo(),dto.getDescr(),dto.getFlgVisibileCombo(),dto.getFlgAttivo(),dto.getFlagNonValidoDlgs1922005());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_MOTIVO_RILASCIO table.
	 */
	public void update(SiceeDMotivoRilascioPk pk, SiceeDMotivoRilascio dto) throws SiceeDMotivoRilascioDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_MOTIVO = ?, DESCR = ?, FLG_VISIBILE_COMBO = ?, FLG_ATTIVO = ?, FLAG_NON_VALIDO_DLGS192_2005 = ? WHERE ID_MOTIVO = ?",dto.getIdMotivo(),dto.getDescr(),dto.getFlgVisibileCombo(),dto.getFlgAttivo(),dto.getFlagNonValidoDlgs1922005(),pk.getIdMotivo());
	}

	/** 
	 * Deletes a single row in the SICEE_D_MOTIVO_RILASCIO table.
	 */

	public void delete(SiceeDMotivoRilascioPk pk) throws SiceeDMotivoRilascioDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_MOTIVO = ?",pk.getIdMotivo());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDMotivoRilascio
	 */
	public SiceeDMotivoRilascio mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDMotivoRilascio dto = new SiceeDMotivoRilascio();
		dto.setIdMotivo( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFlgVisibileCombo( rs.getString( 3 ) );
		dto.setFlgAttivo( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setFlgAttivo( null );
		}
		
		dto.setFlagNonValidoDlgs1922005( rs.getString( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_MOTIVO_RILASCIO";
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'ID_MOTIVO = :idMotivo'.
	 */
	public SiceeDMotivoRilascio findByPrimaryKey(Integer idMotivo) throws SiceeDMotivoRilascioDaoException
	{
		try {
			List<SiceeDMotivoRilascio> list = jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE ID_MOTIVO = ?", this,idMotivo);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria ''.
	 */
	
	public List<SiceeDMotivoRilascio> findAll() throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " ORDER BY ID_MOTIVO", this);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'ID_MOTIVO = :idMotivo'.
	 */
	
	public List<SiceeDMotivoRilascio> findWhereIdMotivoEquals(Integer idMotivo) throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE ID_MOTIVO = ? ORDER BY ID_MOTIVO", this,idMotivo);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDMotivoRilascio> findWhereDescrEquals(String descr) throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_VISIBILE_COMBO = :flgVisibileCombo'.
	 */
	
	public List<SiceeDMotivoRilascio> findWhereFlgVisibileComboEquals(String flgVisibileCombo) throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE FLG_VISIBILE_COMBO = ? ORDER BY FLG_VISIBILE_COMBO", this,flgVisibileCombo);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	
	public List<SiceeDMotivoRilascio> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE FLG_ATTIVO = ? ORDER BY FLG_ATTIVO", this,flgAttivo);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLAG_NON_VALIDO_DLGS192_2005 = :flagNonValidoDlgs1922005'.
	 */
	
	public List<SiceeDMotivoRilascio> findWhereFlagNonValidoDlgs1922005Equals(String flagNonValidoDlgs1922005) throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE FLAG_NON_VALIDO_DLGS192_2005 = ? ORDER BY FLAG_NON_VALIDO_DLGS192_2005", this,flagNonValidoDlgs1922005);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_VISIBILE_COMBO = 'S''.
	 */
	public List<SiceeDMotivoRilascio> findWhereFlgComboEqualsS() throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE FLG_VISIBILE_COMBO = 'S'", this);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO= 1 AND FLG_ALTRO_MOTIVO = 0'.
	 */
	public List<SiceeDMotivoRilascio> findWhereFlgAttivoOn() throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE FLG_ATTIVO = 1", this);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO= 1 AND ID_MOTIVO <= :idMotivo'.
	 *
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findMotiviStandardWhereFlgAttivoOn(Integer idMotivo) throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE FLG_ATTIVO = 1 AND ID_MOTIVO <= ?", this, idMotivo);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO= 1 AND ID_MOTIVO > :idMotivo'.
	 *
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findAltroWhereFlgAttivoOn(Integer idMotivo) throws SiceeDMotivoRilascioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_MOTIVO, DESCR, FLG_VISIBILE_COMBO, FLG_ATTIVO, FLAG_NON_VALIDO_DLGS192_2005 FROM " + getTableName() + " WHERE FLG_ATTIVO = 1 AND ID_MOTIVO > ?", this, idMotivo);
		}
		catch (Exception e) {
			throw new SiceeDMotivoRilascioDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_D_MOTIVO_RILASCIO table that matches the specified primary-key value.
	 */
	public SiceeDMotivoRilascio findByPrimaryKey(SiceeDMotivoRilascioPk pk) throws SiceeDMotivoRilascioDaoException
	{
		return findByPrimaryKey( pk.getIdMotivo() );
	}

}
