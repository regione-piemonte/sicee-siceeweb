/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergeticaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDClasseEnergeticaDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDClasseEnergeticaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDClasseEnergetica>, SiceeDClasseEnergeticaDao
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
	 * @return SiceeDClasseEnergeticaPk
	 */
	
	public SiceeDClasseEnergeticaPk insert(SiceeDClasseEnergetica dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CLASSE, DESCR, FLG_NAZIONALE_19205 ) VALUES ( ?, ?, ? )",dto.getIdClasse(),dto.getDescr(),dto.getFlgNazionale19205());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	
	public void update(SiceeDClasseEnergeticaPk pk, SiceeDClasseEnergetica dto) throws SiceeDClasseEnergeticaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CLASSE = ?, DESCR = ?, FLG_NAZIONALE_19205 = ? WHERE ID_CLASSE = ?",dto.getIdClasse(),dto.getDescr(),dto.getFlgNazionale19205(),pk.getIdClasse());
	}

	/** 
	 * Deletes a single row in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	
	public void delete(SiceeDClasseEnergeticaPk pk) throws SiceeDClasseEnergeticaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CLASSE = ?",pk.getIdClasse());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDClasseEnergetica
	 */
	public SiceeDClasseEnergetica mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDClasseEnergetica dto = new SiceeDClasseEnergetica();
		dto.setIdClasse( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFlgNazionale19205( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_CLASSE_ENERGETICA";
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'ID_CLASSE = :idClasse'.
	 */
	
	public SiceeDClasseEnergetica findByPrimaryKey(Integer idClasse) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			List<SiceeDClasseEnergetica> list = jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205 FROM " + getTableName() + " WHERE ID_CLASSE = ?", this,idClasse);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria ''.
	 */
	
	public List<SiceeDClasseEnergetica> findAll() throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205 FROM " + getTableName() + " ORDER BY ID_CLASSE", this);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'ID_CLASSE = :idClasse'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereIdClasseEquals(Integer idClasse) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205 FROM " + getTableName() + " WHERE ID_CLASSE = ? ORDER BY ID_CLASSE", this,idClasse);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereDescrEquals(String descr) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205 FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDClasseEnergetica> findAttivoWhereDescrEquals(String attivo, String descr) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205 FROM " + getTableName() + " WHERE DESCR = ? AND FLG_ATTIVO = ? ORDER BY DESCR", this, descr, attivo);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'FLG_NAZIONALE_19205 = :flgNazionale19205'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereFlgNazionale19205Equals(String flgNazionale19205) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205 FROM " + getTableName() + " WHERE FLG_NAZIONALE_19205 = ? ORDER BY ID_CLASSE", this,flgNazionale19205);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereFlgAttivoEquals(String flgAttivo) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205 FROM " + getTableName() + " WHERE FLG_ATTIVO = ? ORDER BY ID_CLASSE", this,flgAttivo);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_CLASSE_ENERGETICA table that matches the specified primary-key value.
	 */
	public SiceeDClasseEnergetica findByPrimaryKey(SiceeDClasseEnergeticaPk pk) throws SiceeDClasseEnergeticaDaoException
	{
		return findByPrimaryKey( pk.getIdClasse() );
	}

}
