/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDestUso2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDestUso2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDDestUso2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDDestUso2015>, SiceeDDestUso2015Dao
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
	 * @return SiceeDDestUso2015Pk
	 */
	
	public SiceeDDestUso2015Pk insert(SiceeDDestUso2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO ) VALUES ( ?, ?, ?, ?, ? )",dto.getIdDestUso2015(),dto.getSigla(),dto.getDescr(),dto.getFlgResidenziale(),dto.getFlgAttivo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_DEST_USO_2015 table.
	 */
	
	public void update(SiceeDDestUso2015Pk pk, SiceeDDestUso2015 dto) throws SiceeDDestUso2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DEST_USO_2015 = ?, SIGLA = ?, DESCR = ?, FLG_RESIDENZIALE = ?, FLG_ATTIVO = ? WHERE ID_DEST_USO_2015 = ?",dto.getIdDestUso2015(),dto.getSigla(),dto.getDescr(),dto.getFlgResidenziale(),dto.getFlgAttivo(),pk.getIdDestUso2015());
	}

	/** 
	 * Deletes a single row in the SICEE_D_DEST_USO_2015 table.
	 */
	
	public void delete(SiceeDDestUso2015Pk pk) throws SiceeDDestUso2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DEST_USO_2015 = ?",pk.getIdDestUso2015());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDDestUso2015
	 */
	public SiceeDDestUso2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDDestUso2015 dto = new SiceeDDestUso2015();
		dto.setIdDestUso2015( new Integer( rs.getInt(1) ) );
		dto.setSigla( rs.getString( 2 ) );
		dto.setDescr( rs.getString( 3 ) );
		dto.setFlgResidenziale( rs.getString( 4 ) );
		dto.setFlgAttivo( new Integer( rs.getInt(5) ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_DEST_USO_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'ID_DEST_USO_2015 = :idDestUso2015'.
	 */
	
	public SiceeDDestUso2015 findByPrimaryKey(Integer idDestUso2015) throws SiceeDDestUso2015DaoException
	{
		try {
			List<SiceeDDestUso2015> list = jdbcTemplate.query("SELECT ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO FROM " + getTableName() + " WHERE ID_DEST_USO_2015 = ?", this,idDestUso2015);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDDestUso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDDestUso2015> findAll() throws SiceeDDestUso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO FROM " + getTableName() + " ORDER BY ID_DEST_USO_2015", this);
		}
		catch (Exception e) {
			throw new SiceeDDestUso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'ID_DEST_USO_2015 = :idDestUso2015'.
	 */
	
	public List<SiceeDDestUso2015> findWhereIdDestUso2015Equals(Integer idDestUso2015) throws SiceeDDestUso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO FROM " + getTableName() + " WHERE ID_DEST_USO_2015 = ? ORDER BY ID_DEST_USO_2015", this,idDestUso2015);
		}
		catch (Exception e) {
			throw new SiceeDDestUso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'SIGLA = :sigla'.
	 */
	
	public List<SiceeDDestUso2015> findWhereSiglaEquals(String sigla) throws SiceeDDestUso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO FROM " + getTableName() + " WHERE SIGLA = ? ORDER BY SIGLA", this,sigla);
		}
		catch (Exception e) {
			throw new SiceeDDestUso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDDestUso2015> findWhereDescrEquals(String descr) throws SiceeDDestUso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDDestUso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'FLG_RESIDENZIALE = :flgResidenziale'.
	 */
	
	public List<SiceeDDestUso2015> findWhereFlgResidenzialeEquals(String flgResidenziale) throws SiceeDDestUso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO FROM " + getTableName() + " WHERE FLG_RESIDENZIALE = ? ORDER BY FLG_RESIDENZIALE", this,flgResidenziale);
		}
		catch (Exception e) {
			throw new SiceeDDestUso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	
	public List<SiceeDDestUso2015> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDDestUso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO_2015, SIGLA, DESCR, FLG_RESIDENZIALE, FLG_ATTIVO FROM " + getTableName() + " WHERE FLG_ATTIVO = ? ORDER BY FLG_ATTIVO", this,flgAttivo);
		}
		catch (Exception e) {
			throw new SiceeDDestUso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_DEST_USO_2015 table that matches the specified primary-key value.
	 */
	public SiceeDDestUso2015 findByPrimaryKey(SiceeDDestUso2015Pk pk) throws SiceeDDestUso2015DaoException
	{
		return findByPrimaryKey( pk.getIdDestUso2015() );
	}

}
