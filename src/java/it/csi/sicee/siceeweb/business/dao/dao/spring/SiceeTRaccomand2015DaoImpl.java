/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRaccomand2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRaccomand2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTRaccomand2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTRaccomand2015>, SiceeTRaccomand2015Dao
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
	 * @return SiceeTRaccomand2015Pk
	 */
	
	public SiceeTRaccomand2015Pk insert(SiceeTRaccomand2015 dto)
	{
		dto.setIdRaccomandazione(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdRaccomandazione(),dto.getCodiceRen(),dto.getFkClasseEnergetica(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getTipoIntervento(),dto.getFlgRistrutturazione(),dto.getNrAnniRitInvest(),dto.getEpglNrenSingoloInt());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_RACCOMAND_2015 table.
	 */
	
	public void update(SiceeTRaccomand2015Pk pk, SiceeTRaccomand2015 dto) throws SiceeTRaccomand2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_RACCOMANDAZIONE = ?, CODICE_REN = ?, FK_CLASSE_ENERGETICA = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, TIPO_INTERVENTO = ?, FLG_RISTRUTTURAZIONE = ?, NR_ANNI_RIT_INVEST = ?, EPGL_NREN_SINGOLO_INT = ? WHERE ID_RACCOMANDAZIONE = ?",dto.getIdRaccomandazione(),dto.getCodiceRen(),dto.getFkClasseEnergetica(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getTipoIntervento(),dto.getFlgRistrutturazione(),dto.getNrAnniRitInvest(),dto.getEpglNrenSingoloInt(),pk.getIdRaccomandazione());
	}

	/** 
	 * Deletes a single row in the SICEE_T_RACCOMAND_2015 table.
	 */
	
	public void delete(SiceeTRaccomand2015Pk pk) throws SiceeTRaccomand2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_RACCOMANDAZIONE = ?",pk.getIdRaccomandazione());
	}

	/** 
	 * Deletes in the SICEE_T_RACCOMAND_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTRaccomand2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTRaccomand2015
	 */
	public SiceeTRaccomand2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTRaccomand2015 dto = new SiceeTRaccomand2015();
		dto.setIdRaccomandazione( new Long(rs.getLong( 1 ) ) );
		dto.setCodiceRen( rs.getString( 2 ) );
		dto.setFkClasseEnergetica( new Integer( rs.getInt(3) ) );
		if (rs.wasNull()) {
			dto.setFkClasseEnergetica( null );
		}
		
		dto.setIdCertificatore( rs.getString( 4 ) );
		dto.setProgrCertificato( rs.getString( 5 ) );
		dto.setAnno( rs.getString( 6 ) );
		dto.setTipoIntervento( rs.getString( 7 ) );
		dto.setFlgRistrutturazione( rs.getString( 8 ) );
		dto.setNrAnniRitInvest( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setNrAnniRitInvest( null );
		}
		
		dto.setEpglNrenSingoloInt( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setEpglNrenSingoloInt( null );
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
		return "SICEE_T_RACCOMAND_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_RACCOMANDAZIONE = :idRaccomandazione'.
	 */
	
	public SiceeTRaccomand2015 findByPrimaryKey(long idRaccomandazione) throws SiceeTRaccomand2015DaoException
	{
		try {
			List<SiceeTRaccomand2015> list = jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE ID_RACCOMANDAZIONE = ?", this,idRaccomandazione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTRaccomand2015> findAll() throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " ORDER BY ID_RACCOMANDAZIONE", this);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	
	public List<SiceeTRaccomand2015> findBySiceeDRiqEner2015(String codiceRen) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE CODICE_REN = ?", this,codiceRen);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_RACCOMANDAZIONE = :idRaccomandazione'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereIdRaccomandazioneEquals(long idRaccomandazione) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE ID_RACCOMANDAZIONE = ? ORDER BY ID_RACCOMANDAZIONE", this,idRaccomandazione);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereCodiceRenEquals(String codiceRen) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE CODICE_REN = ? ORDER BY CODICE_REN", this,codiceRen);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'FK_CLASSE_ENERGETICA = :fkClasseEnergetica'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereFkClasseEnergeticaEquals(Integer fkClasseEnergetica) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE FK_CLASSE_ENERGETICA = ? ORDER BY FK_CLASSE_ENERGETICA", this,fkClasseEnergetica);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereAnnoEquals(String anno) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'TIPO_INTERVENTO = :tipoIntervento'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereTipoInterventoEquals(String tipoIntervento) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE TIPO_INTERVENTO = ? ORDER BY TIPO_INTERVENTO", this,tipoIntervento);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'FLG_RISTRUTTURAZIONE = :flgRistrutturazione'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereFlgRistrutturazioneEquals(String flgRistrutturazione) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE FLG_RISTRUTTURAZIONE = ? ORDER BY FLG_RISTRUTTURAZIONE", this,flgRistrutturazione);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'NR_ANNI_RIT_INVEST = :nrAnniRitInvest'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereNrAnniRitInvestEquals(Double nrAnniRitInvest) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE NR_ANNI_RIT_INVEST = ? ORDER BY NR_ANNI_RIT_INVEST", this,nrAnniRitInvest);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'EPGL_NREN_SINGOLO_INT = :epglNrenSingoloInt'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereEpglNrenSingoloIntEquals(Double epglNrenSingoloInt) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE EPGL_NREN_SINGOLO_INT = ? ORDER BY EPGL_NREN_SINGOLO_INT", this,epglNrenSingoloInt);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTRaccomand2015> findWhereIdCertProgrAnno(String idCertificatore, String progrCertificato, String anno) throws SiceeTRaccomand2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_RACCOMANDAZIONE, CODICE_REN, FK_CLASSE_ENERGETICA, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, TIPO_INTERVENTO, FLG_RISTRUTTURAZIONE, NR_ANNI_RIT_INVEST, EPGL_NREN_SINGOLO_INT FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ORDER BY ID_RACCOMANDAZIONE", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTRaccomand2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_RACCOMAND_2015 table that matches the specified primary-key value.
	 */
	public SiceeTRaccomand2015 findByPrimaryKey(SiceeTRaccomand2015Pk pk) throws SiceeTRaccomand2015DaoException
	{
		return findByPrimaryKey( pk.getIdRaccomandazione() );
	}

}
