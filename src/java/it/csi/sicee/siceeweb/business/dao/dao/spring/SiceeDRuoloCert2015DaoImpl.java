/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRuoloCert2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloCert2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloCert2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDRuoloCert2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDRuoloCert2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDRuoloCert2015>, SiceeDRuoloCert2015Dao
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
	 * @return SiceeDRuoloCert2015Pk
	 */
	
	public SiceeDRuoloCert2015Pk insert(SiceeDRuoloCert2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_RUOLO_CERT, DESCR ) VALUES ( ?, ? )",dto.getIdRuoloCert(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_RUOLO_CERT_2015 table.
	 */
	
	public void update(SiceeDRuoloCert2015Pk pk, SiceeDRuoloCert2015 dto) throws SiceeDRuoloCert2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_RUOLO_CERT = ?, DESCR = ? WHERE ID_RUOLO_CERT = ?",dto.getIdRuoloCert(),dto.getDescr(),pk.getIdRuoloCert());
	}

	/** 
	 * Deletes a single row in the SICEE_D_RUOLO_CERT_2015 table.
	 */
	
	public void delete(SiceeDRuoloCert2015Pk pk) throws SiceeDRuoloCert2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_RUOLO_CERT = ?",pk.getIdRuoloCert());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDRuoloCert2015
	 */
	public SiceeDRuoloCert2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDRuoloCert2015 dto = new SiceeDRuoloCert2015();
		dto.setIdRuoloCert( rs.getLong( 1 ) );
		dto.setDescr( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_RUOLO_CERT_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria 'ID_RUOLO_CERT = :idRuoloCert'.
	 */
	
	public SiceeDRuoloCert2015 findByPrimaryKey(long idRuoloCert) throws SiceeDRuoloCert2015DaoException
	{
		try {
			List<SiceeDRuoloCert2015> list = jdbcTemplate.query("SELECT ID_RUOLO_CERT, DESCR FROM " + getTableName() + " WHERE ID_RUOLO_CERT = ?", this,idRuoloCert);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDRuoloCert2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDRuoloCert2015> findAll() throws SiceeDRuoloCert2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RUOLO_CERT, DESCR FROM " + getTableName() + " ORDER BY ID_RUOLO_CERT", this);
		}
		catch (Exception e) {
			throw new SiceeDRuoloCert2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria 'ID_RUOLO_CERT = :idRuoloCert'.
	 */
	
	public List<SiceeDRuoloCert2015> findWhereIdRuoloCertEquals(long idRuoloCert) throws SiceeDRuoloCert2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RUOLO_CERT, DESCR FROM " + getTableName() + " WHERE ID_RUOLO_CERT = ? ORDER BY ID_RUOLO_CERT", this,idRuoloCert);
		}
		catch (Exception e) {
			throw new SiceeDRuoloCert2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDRuoloCert2015> findWhereDescrEquals(String descr) throws SiceeDRuoloCert2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RUOLO_CERT, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDRuoloCert2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_RUOLO_CERT_2015 table that matches the specified primary-key value.
	 */
	public SiceeDRuoloCert2015 findByPrimaryKey(SiceeDRuoloCert2015Pk pk) throws SiceeDRuoloCert2015DaoException
	{
		return findByPrimaryKey( pk.getIdRuoloCert() );
	}

}
