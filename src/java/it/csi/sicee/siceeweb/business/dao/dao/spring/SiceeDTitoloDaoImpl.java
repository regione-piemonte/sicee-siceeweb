/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTitoloDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTitolo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTitoloPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTitoloDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeDTitoloDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTitolo>, SiceeDTitoloDao
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
	 * @return SiceeDTitoloPk
	 */
	
	public SiceeDTitoloPk insert(SiceeDTitolo dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP ) VALUES ( ?, ?, ?, ?, ?, ? )",dto.getIdTitolo(),dto.getDescr(),dto.getFlgEdifici(),dto.getFlgImpianti(),dto.getSigla(),dto.getFlgMdp());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TITOLO table.
	 */
	
	public void update(SiceeDTitoloPk pk, SiceeDTitolo dto) throws SiceeDTitoloDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TITOLO = ?, DESCR = ?, FLG_EDIFICI = ?, FLG_IMPIANTI = ?, SIGLA = ?, FLG_MDP = ? WHERE ID_TITOLO = ?",dto.getIdTitolo(),dto.getDescr(),dto.getFlgEdifici(),dto.getFlgImpianti(),dto.getSigla(),dto.getFlgMdp(),pk.getIdTitolo());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TITOLO table.
	 */
	
	public void delete(SiceeDTitoloPk pk) throws SiceeDTitoloDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TITOLO = ?",pk.getIdTitolo());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTitolo
	 */
	public SiceeDTitolo mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTitolo dto = new SiceeDTitolo();
		dto.setIdTitolo( rs.getString( 1 ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFlgEdifici( rs.getString( 3 ) );
		dto.setFlgImpianti( rs.getString( 4 ) );
		dto.setSigla( rs.getString( 5 ) );
		dto.setFlgMdp( rs.getString( 6 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_TITOLO";
	}

	/** 
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'ID_TITOLO = :idTitolo'.
	 */
	
	public SiceeDTitolo findByPrimaryKey(String idTitolo) throws SiceeDTitoloDaoException
	{
		try {
			List<SiceeDTitolo> list = jdbcTemplate.query("SELECT ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP FROM " + getTableName() + " WHERE ID_TITOLO = ?", this,idTitolo);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTitoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria ''.
	 */
	
	public List<SiceeDTitolo> findAll() throws SiceeDTitoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP FROM " + getTableName() + " ORDER BY ID_TITOLO", this);
		}
		catch (Exception e) {
			throw new SiceeDTitoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'ID_TITOLO = :idTitolo'.
	 */
	
	public List<SiceeDTitolo> findWhereIdTitoloEquals(String idTitolo) throws SiceeDTitoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP FROM " + getTableName() + " WHERE ID_TITOLO = ? ORDER BY ID_TITOLO", this,idTitolo);
		}
		catch (Exception e) {
			throw new SiceeDTitoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTitolo> findWhereDescrEquals(String descr) throws SiceeDTitoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTitoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'FLG_EDIFICI = :flgEdifici'.
	 */
	
	public List<SiceeDTitolo> findWhereFlgEdificiEquals(String flgEdifici) throws SiceeDTitoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP FROM " + getTableName() + " WHERE FLG_EDIFICI = ? ORDER BY FLG_EDIFICI", this,flgEdifici);
		}
		catch (Exception e) {
			throw new SiceeDTitoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'FLG_IMPIANTI = :flgImpianti'.
	 */
	
	public List<SiceeDTitolo> findWhereFlgImpiantiEquals(String flgImpianti) throws SiceeDTitoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP FROM " + getTableName() + " WHERE FLG_IMPIANTI = ? ORDER BY FLG_IMPIANTI", this,flgImpianti);
		}
		catch (Exception e) {
			throw new SiceeDTitoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'SIGLA = :sigla'.
	 */
	
	public List<SiceeDTitolo> findWhereSiglaEquals(String sigla) throws SiceeDTitoloDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TITOLO, DESCR, FLG_EDIFICI, FLG_IMPIANTI, SIGLA, FLG_MDP FROM " + getTableName() + " WHERE SIGLA = ? ORDER BY SIGLA", this,sigla);
		}
		catch (Exception e) {
			throw new SiceeDTitoloDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TITOLO table that matches the specified primary-key value.
	 */
	public SiceeDTitolo findByPrimaryKey(SiceeDTitoloPk pk) throws SiceeDTitoloDaoException
	{
		return findByPrimaryKey( pk.getIdTitolo() );
	}

}
