/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoEdificioDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDTipoEdificioDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoEdificio>, SiceeDTipoEdificioDao
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
	 * @return SiceeDTipoEdificioPk
	 */
	
	public SiceeDTipoEdificioPk insert(SiceeDTipoEdificio dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_EDIFICIO, FK_TIPO_IMPIANTO, DESCR ) VALUES ( ?, ?, ? )",dto.getIdTipoEdificio(),dto.getFkTipoImpianto(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_EDIFICIO table.
	 */
	
	public void update(SiceeDTipoEdificioPk pk, SiceeDTipoEdificio dto) throws SiceeDTipoEdificioDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_EDIFICIO = ?, FK_TIPO_IMPIANTO = ?, DESCR = ? WHERE ID_TIPO_EDIFICIO = ?",dto.getIdTipoEdificio(),dto.getFkTipoImpianto(),dto.getDescr(),pk.getIdTipoEdificio());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_EDIFICIO table.
	 */
	
	public void delete(SiceeDTipoEdificioPk pk) throws SiceeDTipoEdificioDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_EDIFICIO = ?",pk.getIdTipoEdificio());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoEdificio
	 */
	public SiceeDTipoEdificio mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoEdificio dto = new SiceeDTipoEdificio();
		dto.setIdTipoEdificio( new Integer( rs.getInt(1) ) );
		dto.setFkTipoImpianto( new Integer( rs.getInt(2) ) );
		dto.setDescr( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_TIPO_EDIFICIO";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'ID_TIPO_EDIFICIO = :idTipoEdificio'.
	 */
	
	public SiceeDTipoEdificio findByPrimaryKey(Integer idTipoEdificio) throws SiceeDTipoEdificioDaoException
	{
		try {
			List<SiceeDTipoEdificio> list = jdbcTemplate.query("SELECT ID_TIPO_EDIFICIO, FK_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_EDIFICIO = ?", this,idTipoEdificio);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria ''.
	 */
	
	public List<SiceeDTipoEdificio> findAll() throws SiceeDTipoEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_EDIFICIO, FK_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " ORDER BY ID_TIPO_EDIFICIO", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'ID_TIPO_EDIFICIO = :idTipoEdificio'.
	 */
	
	public List<SiceeDTipoEdificio> findWhereIdTipoEdificioEquals(Integer idTipoEdificio) throws SiceeDTipoEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_EDIFICIO, FK_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE ID_TIPO_EDIFICIO = ? ORDER BY ID_TIPO_EDIFICIO", this,idTipoEdificio);
		}
		catch (Exception e) {
			throw new SiceeDTipoEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'FK_TIPO_IMPIANTO = :fkTipoImpianto'.
	 */
	
	public List<SiceeDTipoEdificio> findWhereFkTipoImpiantoEquals(Integer fkTipoImpianto) throws SiceeDTipoEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_EDIFICIO, FK_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE FK_TIPO_IMPIANTO = ? ORDER BY FK_TIPO_IMPIANTO", this,fkTipoImpianto);
		}
		catch (Exception e) {
			throw new SiceeDTipoEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoEdificio> findWhereDescrEquals(String descr) throws SiceeDTipoEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_EDIFICIO, FK_TIPO_IMPIANTO, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_EDIFICIO table that matches the specified primary-key value.
	 */
	public SiceeDTipoEdificio findByPrimaryKey(SiceeDTipoEdificioPk pk) throws SiceeDTipoEdificioDaoException
	{
		return findByPrimaryKey( pk.getIdTipoEdificio() );
	}

}
