/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocIndex2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocIndex2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoDocIndex2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipoDocIndex2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoDocIndex2015>, SiceeDTipoDocIndex2015Dao
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
	 * @return SiceeDTipoDocIndex2015Pk
	 */
	
	public SiceeDTipoDocIndex2015Pk insert(SiceeDTipoDocIndex2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_DOC, DESCR ) VALUES ( ?, ? )",dto.getIdTipoDoc(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_DOC_INDEX_2015 table.
	 */
	
	public void update(SiceeDTipoDocIndex2015Pk pk, SiceeDTipoDocIndex2015 dto) throws SiceeDTipoDocIndex2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_DOC = ?, DESCR = ? WHERE ID_TIPO_DOC = ?",dto.getIdTipoDoc(),dto.getDescr(),pk.getIdTipoDoc());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_DOC_INDEX_2015 table.
	 */
	
	public void delete(SiceeDTipoDocIndex2015Pk pk) throws SiceeDTipoDocIndex2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_DOC = ?",pk.getIdTipoDoc());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoDocIndex2015
	 */
	public SiceeDTipoDocIndex2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoDocIndex2015 dto = new SiceeDTipoDocIndex2015();
		dto.setIdTipoDoc( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_TIPO_DOC_INDEX_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	
	public SiceeDTipoDocIndex2015 findByPrimaryKey(Integer idTipoDoc) throws SiceeDTipoDocIndex2015DaoException
	{
		try {
			List<SiceeDTipoDocIndex2015> list = jdbcTemplate.query("SELECT ID_TIPO_DOC, DESCR FROM " + getTableName() + " WHERE ID_TIPO_DOC = ?", this,idTipoDoc);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDTipoDocIndex2015> findAll() throws SiceeDTipoDocIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_DOC, DESCR FROM " + getTableName() + " ORDER BY ID_TIPO_DOC", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	
	public List<SiceeDTipoDocIndex2015> findWhereIdTipoDocEquals(Integer idTipoDoc) throws SiceeDTipoDocIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_DOC, DESCR FROM " + getTableName() + " WHERE ID_TIPO_DOC = ? ORDER BY ID_TIPO_DOC", this,idTipoDoc);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoDocIndex2015> findWhereDescrEquals(String descr) throws SiceeDTipoDocIndex2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_DOC, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocIndex2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoDocIndex2015 findByPrimaryKey(SiceeDTipoDocIndex2015Pk pk) throws SiceeDTipoDocIndex2015DaoException
	{
		return findByPrimaryKey( pk.getIdTipoDoc() );
	}

}
