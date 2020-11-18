/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDIstruzioneDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDIstruzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDIstruzionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDIstruzioneDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeDIstruzioneDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDIstruzione>, SiceeDIstruzioneDao
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
	 * @return SiceeDIstruzionePk
	 */
	
	public SiceeDIstruzionePk insert(SiceeDIstruzione dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE ) VALUES ( ?, ?, ?, ?, ?, ? )",dto.getIdIstruzione(),dto.getFkTipoIstruzione(),dto.getCodice(),dto.getDenominazione(),dto.getSiglaOrdine(),dto.getSiglaNonOrdine());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_ISTRUZIONE table.
	 */
	
	public void update(SiceeDIstruzionePk pk, SiceeDIstruzione dto) throws SiceeDIstruzioneDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_ISTRUZIONE = ?, FK_TIPO_ISTRUZIONE = ?, CODICE = ?, DENOMINAZIONE = ?, SIGLA_ORDINE = ?, SIGLA_NON_ORDINE = ? WHERE ID_ISTRUZIONE = ?",dto.getIdIstruzione(),dto.getFkTipoIstruzione(),dto.getCodice(),dto.getDenominazione(),dto.getSiglaOrdine(),dto.getSiglaNonOrdine(),pk.getIdIstruzione());
	}

	/** 
	 * Deletes a single row in the SICEE_D_ISTRUZIONE table.
	 */
	
	public void delete(SiceeDIstruzionePk pk) throws SiceeDIstruzioneDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_ISTRUZIONE = ?",pk.getIdIstruzione());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDIstruzione
	 */
	public SiceeDIstruzione mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDIstruzione dto = new SiceeDIstruzione();
		dto.setIdIstruzione( new Integer( rs.getInt(1) ) );
		dto.setFkTipoIstruzione( new Integer( rs.getInt(2) ) );
		dto.setCodice( rs.getString( 3 ) );
		dto.setDenominazione( rs.getString( 4 ) );
		dto.setSiglaOrdine( rs.getString( 5 ) );
		dto.setSiglaNonOrdine( rs.getString( 6 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_ISTRUZIONE";
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'ID_ISTRUZIONE = :idIstruzione'.
	 */
	
	public SiceeDIstruzione findByPrimaryKey(Integer idIstruzione) throws SiceeDIstruzioneDaoException
	{
		try {
			List<SiceeDIstruzione> list = jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE ID_ISTRUZIONE = ?", this,idIstruzione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria ''.
	 */
	
	public List<SiceeDIstruzione> findAll() throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " ORDER BY ID_ISTRUZIONE", this);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'FK_TIPO_ISTRUZIONE = :fkTipoIstruzione'.
	 */
	
	public List<SiceeDIstruzione> findBySiceeDTipoIstruzione(Integer fkTipoIstruzione) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE FK_TIPO_ISTRUZIONE = ?", this,fkTipoIstruzione);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'ID_ISTRUZIONE = :idIstruzione'.
	 */
	
	public List<SiceeDIstruzione> findWhereIdIstruzioneEquals(Integer idIstruzione) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE ID_ISTRUZIONE = ? ORDER BY ID_ISTRUZIONE", this,idIstruzione);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'FK_TIPO_ISTRUZIONE = :fkTipoIstruzione'.
	 */
	
	public List<SiceeDIstruzione> findWhereFkTipoIstruzioneEquals(Integer fkTipoIstruzione) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE FK_TIPO_ISTRUZIONE = ? ORDER BY CODICE", this,fkTipoIstruzione);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'CODICE = :codice'.
	 */
	
	public List<SiceeDIstruzione> findWhereCodiceEquals(String codice) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE CODICE = ? ORDER BY CODICE", this,codice);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 */
	
	public List<SiceeDIstruzione> findWhereDenominazioneEquals(String denominazione) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE DENOMINAZIONE = ? ORDER BY DENOMINAZIONE", this,denominazione);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'SIGLA_ORDINE = :siglaOrdine'.
	 */
	
	public List<SiceeDIstruzione> findWhereSiglaOrdineEquals(String siglaOrdine) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE SIGLA_ORDINE = ? ORDER BY SIGLA_ORDINE", this,siglaOrdine);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'SIGLA_NON_ORDINE = :siglaNonOrdine'.
	 */
	
	public List<SiceeDIstruzione> findWhereSiglaNonOrdineEquals(String siglaNonOrdine) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE SIGLA_NON_ORDINE = ? ORDER BY SIGLA_NON_ORDINE", this,siglaNonOrdine);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'FK_TIPO_ISTRUZIONE = :fkTipoIstruzione
AND SIGLA_ORDINE IS NOT NULL '.
	 */
	
	public List<SiceeDIstruzione> findWhereFkTipoIstruzioneEqualsAndSiglaOrdineIsNotNull(Integer fkTipoIstruzione) throws SiceeDIstruzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ISTRUZIONE, FK_TIPO_ISTRUZIONE, CODICE, DENOMINAZIONE, SIGLA_ORDINE, SIGLA_NON_ORDINE FROM " + getTableName() + " WHERE FK_TIPO_ISTRUZIONE = ? AND SIGLA_ORDINE IS NOT NULL  ORDER BY CODICE", this,fkTipoIstruzione);
		}
		catch (Exception e) {
			throw new SiceeDIstruzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_ISTRUZIONE table that matches the specified primary-key value.
	 */
	public SiceeDIstruzione findByPrimaryKey(SiceeDIstruzionePk pk) throws SiceeDIstruzioneDaoException
	{
		return findByPrimaryKey( pk.getIdIstruzione() );
	}

}
