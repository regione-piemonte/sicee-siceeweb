/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoIstruzioneDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoIstruzioneDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipoIstruzioneDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoIstruzione>, SiceeDTipoIstruzioneDao
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
	 * @return SiceeDTipoIstruzionePk
	 */
	
	public SiceeDTipoIstruzionePk insert(SiceeDTipoIstruzione dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_ISTRUZIONE, DESCR ) VALUES ( ?, ? )",dto.getIdTipoIstruzione(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_ISTRUZIONE table.
	 */
	
	public void update(SiceeDTipoIstruzionePk pk, SiceeDTipoIstruzione dto) throws SiceeDTipoIstruzioneDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_ISTRUZIONE = ?, DESCR = ? WHERE ID_TIPO_ISTRUZIONE = ?",dto.getIdTipoIstruzione(),dto.getDescr(),pk.getIdTipoIstruzione());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_ISTRUZIONE table.
	 */
	
	public void delete(SiceeDTipoIstruzionePk pk) throws SiceeDTipoIstruzioneDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_ISTRUZIONE = ?",pk.getIdTipoIstruzione());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoIstruzione
	 */
	public SiceeDTipoIstruzione mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoIstruzione dto = new SiceeDTipoIstruzione();
		dto.setIdTipoIstruzione( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_TIPO_ISTRUZIONE";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria 'ID_TIPO_ISTRUZIONE = :idTipoIstruzione'.
	 */
	
	public SiceeDTipoIstruzione findByPrimaryKey(Integer idTipoIstruzione) throws SiceeDTipoIstruzioneDaoException
	{
		try {
			List<SiceeDTipoIstruzione> list = jdbcTemplate.query("SELECT ID_TIPO_ISTRUZIONE, DESCR FROM " + getTableName() + " WHERE ID_TIPO_ISTRUZIONE = ?", this,idTipoIstruzione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria ''.
	 */
	
	public List<SiceeDTipoIstruzione> findAll() throws SiceeDTipoIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_ISTRUZIONE, DESCR FROM " + getTableName() + " ORDER BY DESCR", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria 'ID_TIPO_ISTRUZIONE = :idTipoIstruzione'.
	 */
	
	public List<SiceeDTipoIstruzione> findWhereIdTipoIstruzioneEquals(Integer idTipoIstruzione) throws SiceeDTipoIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_ISTRUZIONE, DESCR FROM " + getTableName() + " WHERE ID_TIPO_ISTRUZIONE = ? ORDER BY ID_TIPO_ISTRUZIONE", this,idTipoIstruzione);
		}
		catch (Exception e) {
			throw new SiceeDTipoIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoIstruzione> findWhereDescrEquals(String descr) throws SiceeDTipoIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_ISTRUZIONE, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ISTRUZIONE table that match the criteria 'ID_TIPO_ISTRUZIONE = :idTipoIstruzione
AND SIGLA_ORDINE IS NOT NULL'.
	 */
	
	public List<SiceeDTipoIstruzione> findWhereIdTipoIstruzioneEqualsAndSiglaOrdineIsNotNull(Integer idTipoIstruzione) throws SiceeDTipoIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_ISTRUZIONE, DESCR FROM " + getTableName() + " WHERE ID_TIPO_ISTRUZIONE = ? AND SIGLA_ORDINE IS NOT NULL ORDER BY ID_TIPO_ISTRUZIONE", this,idTipoIstruzione);
		}
		catch (Exception e) {
			throw new SiceeDTipoIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_ISTRUZIONE table that matches the specified primary-key value.
	 */
	public SiceeDTipoIstruzione findByPrimaryKey(SiceeDTipoIstruzionePk pk) throws SiceeDTipoIstruzioneDaoException
	{
		return findByPrimaryKey( pk.getIdTipoIstruzione() );
	}

}
