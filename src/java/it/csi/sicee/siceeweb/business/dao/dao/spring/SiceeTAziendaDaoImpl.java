/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAziendaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAziendaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTAziendaDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTAziendaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTAzienda>, SiceeTAziendaDao
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
	 * @return SiceeTAziendaPk
	 */
	
	public SiceeTAziendaPk insert(SiceeTAzienda dto)
	{
		dto.setIdAzienda(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdAzienda(),dto.getDenominazione(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getCap(),dto.getIdComune(),dto.getDescComune(),dto.getPIva(),dto.getIdProv(),dto.getDescProv(),dto.getIdRegione(),dto.getDescRegione(),dto.getNumCivico());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_AZIENDA table.
	 */
	
	public void update(SiceeTAziendaPk pk, SiceeTAzienda dto) throws SiceeTAziendaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_AZIENDA = ?, DENOMINAZIONE = ?, ID_INDIRIZZO = ?, DESC_INDIRIZZO = ?, CAP = ?, ID_COMUNE = ?, DESC_COMUNE = ?, P_IVA = ?, ID_PROV = ?, DESC_PROV = ?, ID_REGIONE = ?, DESC_REGIONE = ?, NUM_CIVICO = ? WHERE ID_AZIENDA = ?",dto.getIdAzienda(),dto.getDenominazione(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getCap(),dto.getIdComune(),dto.getDescComune(),dto.getPIva(),dto.getIdProv(),dto.getDescProv(),dto.getIdRegione(),dto.getDescRegione(),dto.getNumCivico(),pk.getIdAzienda());
	}

	/** 
	 * Deletes a single row in the SICEE_T_AZIENDA table.
	 */
	
	public void delete(SiceeTAziendaPk pk) throws SiceeTAziendaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_AZIENDA = ?",pk.getIdAzienda());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTAzienda
	 */
	public SiceeTAzienda mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTAzienda dto = new SiceeTAzienda();
		dto.setIdAzienda( rs.getLong( 1 ) );
		dto.setDenominazione( rs.getString( 2 ) );
		dto.setIdIndirizzo( new Integer( rs.getInt(3) ) );
		if (rs.wasNull()) {
			dto.setIdIndirizzo( null );
		}
		
		dto.setDescIndirizzo( rs.getString( 4 ) );
		dto.setCap( rs.getString( 5 ) );
		dto.setIdComune( rs.getString( 6 ) );
		dto.setDescComune( rs.getString( 7 ) );
		dto.setPIva( rs.getString( 8 ) );
		dto.setIdProv( rs.getString( 9 ) );
		dto.setDescProv( rs.getString( 10 ) );
		dto.setIdRegione( rs.getString( 11 ) );
		dto.setDescRegione( rs.getString( 12 ) );
		dto.setNumCivico( rs.getString( 13 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_AZIENDA";
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_AZIENDA = :idAzienda'.
	 */
	
	public SiceeTAzienda findByPrimaryKey(long idAzienda) throws SiceeTAziendaDaoException
	{
		try {
			List<SiceeTAzienda> list = jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE ID_AZIENDA = ?", this,idAzienda);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria ''.
	 */
	
	public List<SiceeTAzienda> findAll() throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " ORDER BY ID_AZIENDA", this);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_AZIENDA = :idAzienda'.
	 */
	
	public List<SiceeTAzienda> findWhereIdAziendaEquals(long idAzienda) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE ID_AZIENDA = ? ORDER BY ID_AZIENDA", this,idAzienda);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 */
	
	public List<SiceeTAzienda> findWhereDenominazioneEquals(String denominazione) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE DENOMINAZIONE = ? ORDER BY DENOMINAZIONE", this,denominazione);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	
	public List<SiceeTAzienda> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE ID_INDIRIZZO = ? ORDER BY ID_INDIRIZZO", this,idIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	
	public List<SiceeTAzienda> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE DESC_INDIRIZZO = ? ORDER BY DESC_INDIRIZZO", this,descIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'CAP = :cap'.
	 */
	
	public List<SiceeTAzienda> findWhereCapEquals(String cap) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE CAP = ? ORDER BY CAP", this,cap);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public List<SiceeTAzienda> findWhereIdComuneEquals(String idComune) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	
	public List<SiceeTAzienda> findWhereDescComuneEquals(String descComune) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE DESC_COMUNE = ? ORDER BY DESC_COMUNE", this,descComune);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'P_IVA = :pIva'.
	 */
	
	public List<SiceeTAzienda> findWherePIvaEquals(String pIva) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE P_IVA = ? ORDER BY P_IVA", this,pIva);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_PROV = :idProv'.
	 */
	
	public List<SiceeTAzienda> findWhereIdProvEquals(String idProv) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE ID_PROV = ? ORDER BY ID_PROV", this,idProv);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_PROV = :descProv'.
	 */
	
	public List<SiceeTAzienda> findWhereDescProvEquals(String descProv) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE DESC_PROV = ? ORDER BY DESC_PROV", this,descProv);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_REGIONE = :idRegione'.
	 */
	
	public List<SiceeTAzienda> findWhereIdRegioneEquals(String idRegione) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE ID_REGIONE = ? ORDER BY ID_REGIONE", this,idRegione);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_REGIONE = :descRegione'.
	 */
	
	public List<SiceeTAzienda> findWhereDescRegioneEquals(String descRegione) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE DESC_REGIONE = ? ORDER BY DESC_REGIONE", this,descRegione);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	
	public List<SiceeTAzienda> findWhereNumCivicoEquals(String numCivico) throws SiceeTAziendaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_AZIENDA, DENOMINAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, P_IVA, ID_PROV, DESC_PROV, ID_REGIONE, DESC_REGIONE, NUM_CIVICO FROM " + getTableName() + " WHERE NUM_CIVICO = ? ORDER BY NUM_CIVICO", this,numCivico);
		}
		catch (Exception e) {
			throw new SiceeTAziendaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_AZIENDA table that matches the specified primary-key value.
	 */
	public SiceeTAzienda findByPrimaryKey(SiceeTAziendaPk pk) throws SiceeTAziendaDaoException
	{
		return findByPrimaryKey( pk.getIdAzienda() );
	}

}
