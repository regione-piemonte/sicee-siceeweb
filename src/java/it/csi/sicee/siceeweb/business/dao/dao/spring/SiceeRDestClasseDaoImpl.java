/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeRDestClasseDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClasse;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClassePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRDestClasseDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeRDestClasseDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeRDestClasse>, SiceeRDestClasseDao
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
	 * @return SiceeRDestClassePk
	 */
	
	public SiceeRDestClassePk insert(SiceeRDestClasse dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CLASSE, ID_DEST_USO, MIN, MAX ) VALUES ( ?, ?, ?, ? )",dto.getIdClasse(),dto.getIdDestUso(),dto.getMin(),dto.getMax());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_R_DEST_CLASSE table.
	 */
	
	public void update(SiceeRDestClassePk pk, SiceeRDestClasse dto) throws SiceeRDestClasseDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CLASSE = ?, ID_DEST_USO = ?, MIN = ?, MAX = ? WHERE ID_CLASSE = ? AND ID_DEST_USO = ?",dto.getIdClasse(),dto.getIdDestUso(),dto.getMin(),dto.getMax(),pk.getIdClasse(),pk.getIdDestUso());
	}

	/** 
	 * Deletes a single row in the SICEE_R_DEST_CLASSE table.
	 */
	
	public void delete(SiceeRDestClassePk pk) throws SiceeRDestClasseDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CLASSE = ? AND ID_DEST_USO = ?",pk.getIdClasse(),pk.getIdDestUso());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeRDestClasse
	 */
	public SiceeRDestClasse mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeRDestClasse dto = new SiceeRDestClasse();
		dto.setIdClasse( new Integer( rs.getInt(1) ) );
		dto.setIdDestUso( new Integer( rs.getInt(2) ) );
		dto.setMin( new Integer( rs.getInt(3) ) );
		if (rs.wasNull()) {
			dto.setMin( null );
		}
		
		dto.setMax( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setMax( null );
		}
		
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_R_DEST_CLASSE";
	}

	/** 
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'ID_CLASSE = :idClasse AND ID_DEST_USO = :idDestUso'.
	 */
	
	public SiceeRDestClasse findByPrimaryKey(Integer idClasse, Integer idDestUso) throws SiceeRDestClasseDaoException
	{
		try {
			List<SiceeRDestClasse> list = jdbcTemplate.query("SELECT ID_CLASSE, ID_DEST_USO, MIN, MAX FROM " + getTableName() + " WHERE ID_CLASSE = ? AND ID_DEST_USO = ?", this,idClasse,idDestUso);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeRDestClasseDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria ''.
	 */
	
	public List<SiceeRDestClasse> findAll() throws SiceeRDestClasseDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, ID_DEST_USO, MIN, MAX FROM " + getTableName() + " ORDER BY ID_CLASSE, ID_DEST_USO", this);
		}
		catch (Exception e) {
			throw new SiceeRDestClasseDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'ID_CLASSE = :idClasse'.
	 */
	
	public List<SiceeRDestClasse> findWhereIdClasseEquals(Integer idClasse) throws SiceeRDestClasseDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, ID_DEST_USO, MIN, MAX FROM " + getTableName() + " WHERE ID_CLASSE = ? ORDER BY ID_CLASSE", this,idClasse);
		}
		catch (Exception e) {
			throw new SiceeRDestClasseDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'ID_DEST_USO = :idDestUso'.
	 */
	
	public List<SiceeRDestClasse> findWhereIdDestUsoEquals(Integer idDestUso) throws SiceeRDestClasseDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, ID_DEST_USO, MIN, MAX FROM " + getTableName() + " WHERE ID_DEST_USO = ? ORDER BY ID_DEST_USO", this,idDestUso);
		}
		catch (Exception e) {
			throw new SiceeRDestClasseDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'MIN = :min'.
	 */
	
	public List<SiceeRDestClasse> findWhereMinEquals(Integer min) throws SiceeRDestClasseDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, ID_DEST_USO, MIN, MAX FROM " + getTableName() + " WHERE MIN = ? ORDER BY MIN", this,min);
		}
		catch (Exception e) {
			throw new SiceeRDestClasseDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'MAX = :max'.
	 */
	
	public List<SiceeRDestClasse> findWhereMaxEquals(Integer max) throws SiceeRDestClasseDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, ID_DEST_USO, MIN, MAX FROM " + getTableName() + " WHERE MAX = ? ORDER BY MAX", this,max);
		}
		catch (Exception e) {
			throw new SiceeRDestClasseDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_R_DEST_CLASSE table that matches the specified primary-key value.
	 */
	public SiceeRDestClasse findByPrimaryKey(SiceeRDestClassePk pk) throws SiceeRDestClasseDaoException
	{
		return findByPrimaryKey( pk.getIdClasse(), pk.getIdDestUso() );
	}

}
