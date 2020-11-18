/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoFoto2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipoFoto2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoFoto2015>, SiceeDTipoFoto2015Dao
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
	 * @return SiceeDTipoFoto2015Pk
	 */
	
	public SiceeDTipoFoto2015Pk insert(SiceeDTipoFoto2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_FOTO, DESCR ) VALUES ( ?, ? )",dto.getIdTipoFoto(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_FOTO_2015 table.
	 */
	
	public void update(SiceeDTipoFoto2015Pk pk, SiceeDTipoFoto2015 dto) throws SiceeDTipoFoto2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_FOTO = ?, DESCR = ? WHERE ID_TIPO_FOTO = ?",dto.getIdTipoFoto(),dto.getDescr(),pk.getIdTipoFoto());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_FOTO_2015 table.
	 */
	
	public void delete(SiceeDTipoFoto2015Pk pk) throws SiceeDTipoFoto2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_FOTO = ?",pk.getIdTipoFoto());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoFoto2015
	 */
	public SiceeDTipoFoto2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoFoto2015 dto = new SiceeDTipoFoto2015();
		dto.setIdTipoFoto( rs.getLong( 1 ) );
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
		return "SICEE_D_TIPO_FOTO_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria 'ID_TIPO_FOTO = :idTipoFoto'.
	 */
	
	public SiceeDTipoFoto2015 findByPrimaryKey(long idTipoFoto) throws SiceeDTipoFoto2015DaoException
	{
		try {
			List<SiceeDTipoFoto2015> list = jdbcTemplate.query("SELECT ID_TIPO_FOTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_FOTO = ?", this,idTipoFoto);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDTipoFoto2015> findAll() throws SiceeDTipoFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_FOTO, DESCR FROM " + getTableName() + " ORDER BY ID_TIPO_FOTO", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria 'ID_TIPO_FOTO = :idTipoFoto'.
	 */
	
	public List<SiceeDTipoFoto2015> findWhereIdTipoFotoEquals(long idTipoFoto) throws SiceeDTipoFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_FOTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_FOTO = ? ORDER BY ID_TIPO_FOTO", this,idTipoFoto);
		}
		catch (Exception e) {
			throw new SiceeDTipoFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoFoto2015> findWhereDescrEquals(String descr) throws SiceeDTipoFoto2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_FOTO, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoFoto2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_FOTO_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoFoto2015 findByPrimaryKey(SiceeDTipoFoto2015Pk pk) throws SiceeDTipoFoto2015DaoException
	{
		return findByPrimaryKey( pk.getIdTipoFoto() );
	}

}
