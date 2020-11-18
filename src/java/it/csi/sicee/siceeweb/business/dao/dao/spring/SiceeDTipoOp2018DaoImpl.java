/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoOp2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoOp2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoOp2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoOp2018DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipoOp2018DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoOp2018>, SiceeDTipoOp2018Dao
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
	 * @return SiceeDTipoOp2018Pk
	 */
	
	public SiceeDTipoOp2018Pk insert(SiceeDTipoOp2018 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_OP_2018, DESCR_TIPO_OP_2018 ) VALUES ( ?, ? )",dto.getIdTipoOp2018(),dto.getDescrTipoOp2018());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_OP_2018 table.
	 */
	
	public void update(SiceeDTipoOp2018Pk pk, SiceeDTipoOp2018 dto) throws SiceeDTipoOp2018DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_OP_2018 = ?, DESCR_TIPO_OP_2018 = ? WHERE ID_TIPO_OP_2018 = ?",dto.getIdTipoOp2018(),dto.getDescrTipoOp2018(),pk.getIdTipoOp2018());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_OP_2018 table.
	 */
	
	public void delete(SiceeDTipoOp2018Pk pk) throws SiceeDTipoOp2018DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_OP_2018 = ?",pk.getIdTipoOp2018());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoOp2018
	 */
	public SiceeDTipoOp2018 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoOp2018 dto = new SiceeDTipoOp2018();
		dto.setIdTipoOp2018( new Integer( rs.getInt(1) ) );
		dto.setDescrTipoOp2018( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_TIPO_OP_2018";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria 'ID_TIPO_OP_2018 = :idTipoOp2018'.
	 */
	
	public SiceeDTipoOp2018 findByPrimaryKey(Integer idTipoOp2018) throws SiceeDTipoOp2018DaoException
	{
		try {
			List<SiceeDTipoOp2018> list = jdbcTemplate.query("SELECT ID_TIPO_OP_2018, DESCR_TIPO_OP_2018 FROM " + getTableName() + " WHERE ID_TIPO_OP_2018 = ?", this,idTipoOp2018);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoOp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria ''.
	 */
	
	public List<SiceeDTipoOp2018> findAll() throws SiceeDTipoOp2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_OP_2018, DESCR_TIPO_OP_2018 FROM " + getTableName() + " ORDER BY ID_TIPO_OP_2018", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoOp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria 'ID_TIPO_OP_2018 = :idTipoOp2018'.
	 */
	
	public List<SiceeDTipoOp2018> findWhereIdTipoOp2018Equals(Integer idTipoOp2018) throws SiceeDTipoOp2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_OP_2018, DESCR_TIPO_OP_2018 FROM " + getTableName() + " WHERE ID_TIPO_OP_2018 = ? ORDER BY ID_TIPO_OP_2018", this,idTipoOp2018);
		}
		catch (Exception e) {
			throw new SiceeDTipoOp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria 'DESCR_TIPO_OP_2018 = :descrTipoOp2018'.
	 */
	
	public List<SiceeDTipoOp2018> findWhereDescrTipoOp2018Equals(String descrTipoOp2018) throws SiceeDTipoOp2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_OP_2018, DESCR_TIPO_OP_2018 FROM " + getTableName() + " WHERE DESCR_TIPO_OP_2018 = ? ORDER BY DESCR_TIPO_OP_2018", this,descrTipoOp2018);
		}
		catch (Exception e) {
			throw new SiceeDTipoOp2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_OP_2018 table that matches the specified primary-key value.
	 */
	public SiceeDTipoOp2018 findByPrimaryKey(SiceeDTipoOp2018Pk pk) throws SiceeDTipoOp2018DaoException
	{
		return findByPrimaryKey( pk.getIdTipoOp2018() );
	}

}
