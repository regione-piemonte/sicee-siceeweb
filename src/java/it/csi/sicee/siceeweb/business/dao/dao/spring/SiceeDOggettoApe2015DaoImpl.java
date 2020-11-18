/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDOggettoApe2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDOggettoApe2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDOggettoApe2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDOggettoApe2015>, SiceeDOggettoApe2015Dao
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
	 * @return SiceeDOggettoApe2015Pk
	 */
	
	public SiceeDOggettoApe2015Pk insert(SiceeDOggettoApe2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_OGGETTO_APE, DESCR ) VALUES ( ?, ? )",dto.getIdOggettoApe(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_OGGETTO_APE_2015 table.
	 */
	
	public void update(SiceeDOggettoApe2015Pk pk, SiceeDOggettoApe2015 dto) throws SiceeDOggettoApe2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_OGGETTO_APE = ?, DESCR = ? WHERE ID_OGGETTO_APE = ?",dto.getIdOggettoApe(),dto.getDescr(),pk.getIdOggettoApe());
	}

	/** 
	 * Deletes a single row in the SICEE_D_OGGETTO_APE_2015 table.
	 */
	
	public void delete(SiceeDOggettoApe2015Pk pk) throws SiceeDOggettoApe2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_OGGETTO_APE = ?",pk.getIdOggettoApe());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDOggettoApe2015
	 */
	public SiceeDOggettoApe2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDOggettoApe2015 dto = new SiceeDOggettoApe2015();
		dto.setIdOggettoApe( rs.getLong( 1 ) );
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
		return "SICEE_D_OGGETTO_APE_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria 'ID_OGGETTO_APE = :idOggettoApe'.
	 */
	
	public SiceeDOggettoApe2015 findByPrimaryKey(long idOggettoApe) throws SiceeDOggettoApe2015DaoException
	{
		try {
			List<SiceeDOggettoApe2015> list = jdbcTemplate.query("SELECT ID_OGGETTO_APE, DESCR FROM " + getTableName() + " WHERE ID_OGGETTO_APE = ?", this,idOggettoApe);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDOggettoApe2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDOggettoApe2015> findAll() throws SiceeDOggettoApe2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_OGGETTO_APE, DESCR FROM " + getTableName() + " ORDER BY ID_OGGETTO_APE", this);
		}
		catch (Exception e) {
			throw new SiceeDOggettoApe2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria 'ID_OGGETTO_APE = :idOggettoApe'.
	 */
	
	public List<SiceeDOggettoApe2015> findWhereIdOggettoApeEquals(long idOggettoApe) throws SiceeDOggettoApe2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_OGGETTO_APE, DESCR FROM " + getTableName() + " WHERE ID_OGGETTO_APE = ? ORDER BY ID_OGGETTO_APE", this,idOggettoApe);
		}
		catch (Exception e) {
			throw new SiceeDOggettoApe2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDOggettoApe2015> findWhereDescrEquals(String descr) throws SiceeDOggettoApe2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_OGGETTO_APE, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDOggettoApe2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_OGGETTO_APE_2015 table that matches the specified primary-key value.
	 */
	public SiceeDOggettoApe2015 findByPrimaryKey(SiceeDOggettoApe2015Pk pk) throws SiceeDOggettoApe2015DaoException
	{
		return findByPrimaryKey( pk.getIdOggettoApe() );
	}

}
