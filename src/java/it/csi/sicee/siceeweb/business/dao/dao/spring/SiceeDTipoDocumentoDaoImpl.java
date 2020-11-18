/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocumento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocumentoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoDocumentoDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;


public class SiceeDTipoDocumentoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoDocumento>, SiceeDTipoDocumentoDao
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
	 * @return SiceeDTipoDocumentoPk
	 */
	
	public SiceeDTipoDocumentoPk insert(SiceeDTipoDocumento dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_DOC, DS_TIPO_DOC ) VALUES ( ?, ? )",dto.getIdTipoDoc(),dto.getDsTipoDoc());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_DOCUMENTO table.
	 */
	
	public void update(SiceeDTipoDocumentoPk pk, SiceeDTipoDocumento dto) throws SiceeDTipoDocumentoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_DOC = ?, DS_TIPO_DOC = ? WHERE ID_TIPO_DOC = ?",dto.getIdTipoDoc(),dto.getDsTipoDoc(),pk.getIdTipoDoc());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_DOCUMENTO table.
	 */
	
	public void delete(SiceeDTipoDocumentoPk pk) throws SiceeDTipoDocumentoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_DOC = ?",pk.getIdTipoDoc());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoDocumento
	 */
	public SiceeDTipoDocumento mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoDocumento dto = new SiceeDTipoDocumento();
		dto.setIdTipoDoc( new Integer( rs.getInt(1) ) );
		dto.setDsTipoDoc( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_TIPO_DOCUMENTO";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	
	public SiceeDTipoDocumento findByPrimaryKey(Integer idTipoDoc) throws SiceeDTipoDocumentoDaoException
	{
		try {
			List<SiceeDTipoDocumento> list = jdbcTemplate.query("SELECT ID_TIPO_DOC, DS_TIPO_DOC FROM " + getTableName() + " WHERE ID_TIPO_DOC = ?", this,idTipoDoc);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria ''.
	 */
	
	public List<SiceeDTipoDocumento> findAll() throws SiceeDTipoDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_DOC, DS_TIPO_DOC FROM " + getTableName() + " ORDER BY ID_TIPO_DOC", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	
	public List<SiceeDTipoDocumento> findWhereIdTipoDocEquals(Integer idTipoDoc) throws SiceeDTipoDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_DOC, DS_TIPO_DOC FROM " + getTableName() + " WHERE ID_TIPO_DOC = ? ORDER BY ID_TIPO_DOC", this,idTipoDoc);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOCUMENTO table that match the criteria 'DS_TIPO_DOC = :dsTipoDoc'.
	 */
	
	public List<SiceeDTipoDocumento> findWhereDsTipoDocEquals(String dsTipoDoc) throws SiceeDTipoDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_DOC, DS_TIPO_DOC FROM " + getTableName() + " WHERE DS_TIPO_DOC = ? ORDER BY DS_TIPO_DOC", this,dsTipoDoc);
		}
		catch (Exception e) {
			throw new SiceeDTipoDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_DOCUMENTO table that matches the specified primary-key value.
	 */
	public SiceeDTipoDocumento findByPrimaryKey(SiceeDTipoDocumentoPk pk) throws SiceeDTipoDocumentoDaoException
	{
		return findByPrimaryKey( pk.getIdTipoDoc() );
	}

}
