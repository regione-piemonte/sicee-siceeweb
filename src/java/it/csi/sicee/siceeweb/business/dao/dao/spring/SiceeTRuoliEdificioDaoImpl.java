/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRuoliEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRuoliEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRuoliEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRuoliEdificioDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTRuoliEdificioDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTRuoliEdificio>, SiceeTRuoliEdificioDao
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
	 * @return SiceeTRuoliEdificioPk
	 */
	
	public SiceeTRuoliEdificioPk insert(SiceeTRuoliEdificio dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getFkTipoRuolo(),dto.getNome(),dto.getCognome(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getCap(),dto.getIdComune(),dto.getDescComune(),dto.getTelefono(),dto.getFax(),dto.getCell(),dto.getEmail(),dto.getIdRegione(),dto.getDescRegione(),dto.getIdProvincia(),dto.getDescProvincia(),dto.getNumCivico(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	
	public void update(SiceeTRuoliEdificioPk pk, SiceeTRuoliEdificio dto) throws SiceeTRuoliEdificioDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET FK_TIPO_RUOLO = ?, NOME = ?, COGNOME = ?, ID_INDIRIZZO = ?, DESC_INDIRIZZO = ?, CAP = ?, ID_COMUNE = ?, DESC_COMUNE = ?, TELEFONO = ?, FAX = ?, CELL = ?, EMAIL = ?, ID_REGIONE = ?, DESC_REGIONE = ?, ID_PROVINCIA = ?, DESC_PROVINCIA = ?, NUM_CIVICO = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND FK_TIPO_RUOLO = ?",dto.getFkTipoRuolo(),dto.getNome(),dto.getCognome(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getCap(),dto.getIdComune(),dto.getDescComune(),dto.getTelefono(),dto.getFax(),dto.getCell(),dto.getEmail(),dto.getIdRegione(),dto.getDescRegione(),dto.getIdProvincia(),dto.getDescProvincia(),dto.getNumCivico(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getFkTipoRuolo());
	}

	/** 
	 * Deletes a single row in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	
	public void delete(SiceeTRuoliEdificioPk pk) throws SiceeTRuoliEdificioDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND FK_TIPO_RUOLO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getFkTipoRuolo());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTRuoliEdificio
	 */
	public SiceeTRuoliEdificio mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTRuoliEdificio dto = new SiceeTRuoliEdificio();
		dto.setFkTipoRuolo( new Integer( rs.getInt(1) ) );
		dto.setNome( rs.getString( 2 ) );
		dto.setCognome( rs.getString( 3 ) );
		dto.setIdIndirizzo( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setIdIndirizzo( null );
		}
		
		dto.setDescIndirizzo( rs.getString( 5 ) );
		dto.setCap( rs.getString( 6 ) );
		dto.setIdComune( rs.getString( 7 ) );
		dto.setDescComune( rs.getString( 8 ) );
		dto.setTelefono( rs.getString( 9 ) );
		dto.setFax( rs.getString( 10 ) );
		dto.setCell( rs.getString( 11 ) );
		dto.setEmail( rs.getString( 12 ) );
		dto.setIdRegione( rs.getString( 13 ) );
		dto.setDescRegione( rs.getString( 14 ) );
		dto.setIdProvincia( rs.getString( 15 ) );
		dto.setDescProvincia( rs.getString( 16 ) );
		dto.setNumCivico( rs.getString( 17 ) );
		dto.setIdCertificatore( rs.getString( 18 ) );
		dto.setProgrCertificato( rs.getString( 19 ) );
		dto.setAnno( rs.getString( 20 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_RUOLI_EDIFICIO";
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND FK_TIPO_RUOLO = :fkTipoRuolo'.
	 */
	
	public SiceeTRuoliEdificio findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer fkTipoRuolo) throws SiceeTRuoliEdificioDaoException
	{
		try {
			List<SiceeTRuoliEdificio> list = jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND FK_TIPO_RUOLO = ?", this,idCertificatore,progrCertificato,anno,fkTipoRuolo);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_RUOLO_EDIFICIO = :idRuoloEdificio'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereIdRuoloEdificioEquals(Integer idRuoloEdificio) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_RUOLO_EDIFICIO = ? ORDER BY ID_RUOLO_EDIFICIO", this,idRuoloEdificio);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria ''.
	 */
	
	public List<SiceeTRuoliEdificio> findAll() throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_RUOLO", this);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTRuoliEdificio> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'FK_TIPO_RUOLO = :fkTipoRuolo'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereFkTipoRuoloEquals(Integer fkTipoRuolo) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_TIPO_RUOLO = ? ORDER BY FK_TIPO_RUOLO", this,fkTipoRuolo);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'NOME = :nome'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereNomeEquals(String nome) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE NOME = ? ORDER BY NOME", this,nome);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'COGNOME = :cognome'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereCognomeEquals(String cognome) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE COGNOME = ? ORDER BY COGNOME", this,cognome);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_INDIRIZZO = ? ORDER BY ID_INDIRIZZO", this,idIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE DESC_INDIRIZZO = ? ORDER BY DESC_INDIRIZZO", this,descIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'CAP = :cap'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereCapEquals(String cap) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE CAP = ? ORDER BY CAP", this,cap);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereIdComuneEquals(String idComune) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereDescComuneEquals(String descComune) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE DESC_COMUNE = ? ORDER BY DESC_COMUNE", this,descComune);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'TELEFONO = :telefono'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereTelefonoEquals(String telefono) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE TELEFONO = ? ORDER BY TELEFONO", this,telefono);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'FAX = :fax'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereFaxEquals(String fax) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FAX = ? ORDER BY FAX", this,fax);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'CELL = :cell'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereCellEquals(String cell) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE CELL = ? ORDER BY CELL", this,cell);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'EMAIL = :email'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereEmailEquals(String email) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this,email);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_REGIONE = :idRegione'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereIdRegioneEquals(String idRegione) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_REGIONE = ? ORDER BY ID_REGIONE", this,idRegione);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_REGIONE = :descRegione'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereDescRegioneEquals(String descRegione) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE DESC_REGIONE = ? ORDER BY DESC_REGIONE", this,descRegione);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_PROVINCIA = :idProvincia'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereIdProvinciaEquals(String idProvincia) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_PROVINCIA = ? ORDER BY ID_PROVINCIA", this,idProvincia);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_PROVINCIA = :descProvincia'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereDescProvinciaEquals(String descProvincia) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE DESC_PROVINCIA = ? ORDER BY DESC_PROVINCIA", this,descProvincia);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereNumCivicoEquals(String numCivico) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE NUM_CIVICO = ? ORDER BY NUM_CIVICO", this,numCivico);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTRuoliEdificio> findWhereAnnoEquals(String anno) throws SiceeTRuoliEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT FK_TIPO_RUOLO, NOME, COGNOME, ID_INDIRIZZO, DESC_INDIRIZZO, CAP, ID_COMUNE, DESC_COMUNE, TELEFONO, FAX, CELL, EMAIL, ID_REGIONE, DESC_REGIONE, ID_PROVINCIA, DESC_PROVINCIA, NUM_CIVICO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTRuoliEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_RUOLI_EDIFICIO table that matches the specified primary-key value.
	 */
	public SiceeTRuoliEdificio findByPrimaryKey(SiceeTRuoliEdificioPk pk) throws SiceeTRuoliEdificioDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno(), pk.getFkTipoRuolo() );
	}

}
