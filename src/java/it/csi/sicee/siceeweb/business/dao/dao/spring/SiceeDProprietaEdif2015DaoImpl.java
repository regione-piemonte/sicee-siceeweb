/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDProprietaEdif2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDProprietaEdif2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDProprietaEdif2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDProprietaEdif2015>, SiceeDProprietaEdif2015Dao
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
	 * @return SiceeDProprietaEdif2015Pk
	 */
	
	public SiceeDProprietaEdif2015Pk insert(SiceeDProprietaEdif2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_PROPRIETA_EDI, DESCR ) VALUES ( ?, ? )",dto.getIdProprietaEdi(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_PROPRIETA_EDIF_2015 table.
	 */
	
	public void update(SiceeDProprietaEdif2015Pk pk, SiceeDProprietaEdif2015 dto) throws SiceeDProprietaEdif2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_PROPRIETA_EDI = ?, DESCR = ? WHERE ID_PROPRIETA_EDI = ?",dto.getIdProprietaEdi(),dto.getDescr(),pk.getIdProprietaEdi());
	}

	/** 
	 * Deletes a single row in the SICEE_D_PROPRIETA_EDIF_2015 table.
	 */
	
	public void delete(SiceeDProprietaEdif2015Pk pk) throws SiceeDProprietaEdif2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_PROPRIETA_EDI = ?",pk.getIdProprietaEdi());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDProprietaEdif2015
	 */
	public SiceeDProprietaEdif2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDProprietaEdif2015 dto = new SiceeDProprietaEdif2015();
		dto.setIdProprietaEdi( new Integer( rs.getInt(1) ) );
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
		return "SICEE_D_PROPRIETA_EDIF_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria 'ID_PROPRIETA_EDI = :idProprietaEdi'.
	 */
	
	public SiceeDProprietaEdif2015 findByPrimaryKey(Integer idProprietaEdi) throws SiceeDProprietaEdif2015DaoException
	{
		try {
			List<SiceeDProprietaEdif2015> list = jdbcTemplate.query("SELECT ID_PROPRIETA_EDI, DESCR FROM " + getTableName() + " WHERE ID_PROPRIETA_EDI = ?", this,idProprietaEdi);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDProprietaEdif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDProprietaEdif2015> findAll() throws SiceeDProprietaEdif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PROPRIETA_EDI, DESCR FROM " + getTableName() + " ORDER BY ID_PROPRIETA_EDI", this);
		}
		catch (Exception e) {
			throw new SiceeDProprietaEdif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria 'ID_PROPRIETA_EDI = :idProprietaEdi'.
	 */
	
	public List<SiceeDProprietaEdif2015> findWhereIdProprietaEdiEquals(Integer idProprietaEdi) throws SiceeDProprietaEdif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PROPRIETA_EDI, DESCR FROM " + getTableName() + " WHERE ID_PROPRIETA_EDI = ? ORDER BY ID_PROPRIETA_EDI", this,idProprietaEdi);
		}
		catch (Exception e) {
			throw new SiceeDProprietaEdif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDProprietaEdif2015> findWhereDescrEquals(String descr) throws SiceeDProprietaEdif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PROPRIETA_EDI, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDProprietaEdif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_PROPRIETA_EDIF_2015 table that matches the specified primary-key value.
	 */
	public SiceeDProprietaEdif2015 findByPrimaryKey(SiceeDProprietaEdif2015Pk pk) throws SiceeDProprietaEdif2015DaoException
	{
		return findByPrimaryKey( pk.getIdProprietaEdi() );
	}

}
