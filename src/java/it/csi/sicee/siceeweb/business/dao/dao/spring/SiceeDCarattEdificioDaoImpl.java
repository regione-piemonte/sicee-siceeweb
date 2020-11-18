/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCarattEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCarattEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCarattEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDCarattEdificioDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDCarattEdificioDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDCarattEdificio>, SiceeDCarattEdificioDao
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
	 * @return SiceeDCarattEdificioPk
	 */
	
	public SiceeDCarattEdificioPk insert(SiceeDCarattEdificio dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CARATT_EDIFICIO, DESCR, FK_TIPO_EDIFICIO ) VALUES ( ?, ?, ? )",dto.getIdCarattEdificio(),dto.getDescr(),dto.getFkTipoEdificio());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_CARATT_EDIFICIO table.
	 */
	
	public void update(SiceeDCarattEdificioPk pk, SiceeDCarattEdificio dto) throws SiceeDCarattEdificioDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CARATT_EDIFICIO = ?, DESCR = ?, FK_TIPO_EDIFICIO = ? WHERE ID_CARATT_EDIFICIO = ?",dto.getIdCarattEdificio(),dto.getDescr(),dto.getFkTipoEdificio(),pk.getIdCarattEdificio());
	}

	/** 
	 * Deletes a single row in the SICEE_D_CARATT_EDIFICIO table.
	 */
	
	public void delete(SiceeDCarattEdificioPk pk) throws SiceeDCarattEdificioDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CARATT_EDIFICIO = ?",pk.getIdCarattEdificio());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDCarattEdificio
	 */
	public SiceeDCarattEdificio mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDCarattEdificio dto = new SiceeDCarattEdificio();
		dto.setIdCarattEdificio( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFkTipoEdificio( new Integer( rs.getInt(3) ) );
		if (rs.wasNull()) {
			dto.setFkTipoEdificio( null );
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
		return "SICEE_D_CARATT_EDIFICIO";
	}

	/** 
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'ID_CARATT_EDIFICIO = :idCarattEdificio'.
	 */
	
	public SiceeDCarattEdificio findByPrimaryKey(Integer idCarattEdificio) throws SiceeDCarattEdificioDaoException
	{
		try {
			List<SiceeDCarattEdificio> list = jdbcTemplate.query("SELECT ID_CARATT_EDIFICIO, DESCR, FK_TIPO_EDIFICIO FROM " + getTableName() + " WHERE ID_CARATT_EDIFICIO = ?", this,idCarattEdificio);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDCarattEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria ''.
	 */
	
	public List<SiceeDCarattEdificio> findAll() throws SiceeDCarattEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CARATT_EDIFICIO, DESCR, FK_TIPO_EDIFICIO FROM " + getTableName() + " ORDER BY ID_CARATT_EDIFICIO", this);
		}
		catch (Exception e) {
			throw new SiceeDCarattEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'FK_TIPO_EDIFICIO = :fkTipoEdificio'.
	 */
	
	public List<SiceeDCarattEdificio> findBySiceeDTipoEdificio(Integer fkTipoEdificio) throws SiceeDCarattEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CARATT_EDIFICIO, DESCR, FK_TIPO_EDIFICIO FROM " + getTableName() + " WHERE FK_TIPO_EDIFICIO = ?", this,fkTipoEdificio);
		}
		catch (Exception e) {
			throw new SiceeDCarattEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'ID_CARATT_EDIFICIO = :idCarattEdificio'.
	 */
	
	public List<SiceeDCarattEdificio> findWhereIdCarattEdificioEquals(Integer idCarattEdificio) throws SiceeDCarattEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CARATT_EDIFICIO, DESCR, FK_TIPO_EDIFICIO FROM " + getTableName() + " WHERE ID_CARATT_EDIFICIO = ? ORDER BY ID_CARATT_EDIFICIO", this,idCarattEdificio);
		}
		catch (Exception e) {
			throw new SiceeDCarattEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDCarattEdificio> findWhereDescrEquals(String descr) throws SiceeDCarattEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CARATT_EDIFICIO, DESCR, FK_TIPO_EDIFICIO FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDCarattEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'FK_TIPO_EDIFICIO = :fkTipoEdificio'.
	 */
	
	public List<SiceeDCarattEdificio> findWhereFkTipoEdificioEquals(Integer fkTipoEdificio) throws SiceeDCarattEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CARATT_EDIFICIO, DESCR, FK_TIPO_EDIFICIO FROM " + getTableName() + " WHERE FK_TIPO_EDIFICIO = ? ORDER BY FK_TIPO_EDIFICIO", this,fkTipoEdificio);
		}
		catch (Exception e) {
			throw new SiceeDCarattEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_CARATT_EDIFICIO table that matches the specified primary-key value.
	 */
	public SiceeDCarattEdificio findByPrimaryKey(SiceeDCarattEdificioPk pk) throws SiceeDCarattEdificioDaoException
	{
		return findByPrimaryKey( pk.getIdCarattEdificio() );
	}

}
