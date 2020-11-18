/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCredito2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCredito2018DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTCredito2018DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTCredito2018>, SiceeTCredito2018Dao
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
	 * @return SiceeTCredito2018Pk
	 */
	
	public SiceeTCredito2018Pk insert(SiceeTCredito2018 dto)
	{
		dto.setIdCredito(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCredito(),dto.getFkCertificatore(),dto.isFkTransazione2018Null()?null:dto.getFkTransazione2018(),dto.getFkTipoOp2018(),dto.isValoreCreditoInizialeNull()?null:dto.getValoreCreditoIniziale(),dto.isValoreCreditoFinaleNull()?null:dto.getValoreCreditoFinale(),dto.getDataOperazione(),dto.isValoreOperazioneNull()?null:dto.getValoreOperazione(),dto.getNote(),dto.getFkCertificatoreCertificato(),dto.getProgrCertificato(),dto.getAnno());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_CREDITO_2018 table.
	 */
	
	public void update(SiceeTCredito2018Pk pk, SiceeTCredito2018 dto) throws SiceeTCredito2018DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CREDITO = ?, FK_CERTIFICATORE = ?, FK_TRANSAZIONE_2018 = ?, FK_TIPO_OP_2018 = ?, VALORE_CREDITO_INIZIALE = ?, VALORE_CREDITO_FINALE = ?, DATA_OPERAZIONE = ?, VALORE_OPERAZIONE = ?, NOTE = ?, FK_CERTIFICATORE_CERTIFICATO = ?, PROGR_CERTIFICATO = ?, ANNO = ? WHERE ID_CREDITO = ?",dto.getIdCredito(),dto.getFkCertificatore(),dto.getFkTransazione2018(),dto.getFkTipoOp2018(),dto.getValoreCreditoIniziale(),dto.getValoreCreditoFinale(),dto.getDataOperazione(),dto.getValoreOperazione(),dto.getNote(),dto.getFkCertificatoreCertificato(),dto.getProgrCertificato(),dto.getAnno(),pk.getIdCredito());
	}

	/** 
	 * Deletes a single row in the SICEE_T_CREDITO_2018 table.
	 */
	
	public void delete(SiceeTCredito2018Pk pk) throws SiceeTCredito2018DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CREDITO = ?",pk.getIdCredito());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTCredito2018
	 */
	public SiceeTCredito2018 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTCredito2018 dto = new SiceeTCredito2018();
		dto.setIdCredito( new Integer( rs.getInt( 1 ) ));
		dto.setFkCertificatore( rs.getString( 2 ) );
		dto.setFkTransazione2018( new Integer( rs.getInt( 3 ) ));
		if (rs.wasNull()) {
			dto.setFkTransazione2018Null( true );
		}
		
		dto.setFkTipoOp2018( new Integer( rs.getInt(4) ) );
		dto.setValoreCreditoIniziale( new Double( rs.getDouble( 5 ) ));
		if (rs.wasNull()) {
			dto.setValoreCreditoInizialeNull( true );
		}
		
		dto.setValoreCreditoFinale( new Double( rs.getDouble( 6 ) ));
		if (rs.wasNull()) {
			dto.setValoreCreditoFinaleNull( true );
		}
		
		dto.setDataOperazione( rs.getTimestamp(7 ) );
		dto.setValoreOperazione( new Double( rs.getDouble( 8 ) ));
		if (rs.wasNull()) {
			dto.setValoreOperazioneNull( true );
		}
		
		dto.setNote( rs.getString( 9 ) );
		dto.setFkCertificatoreCertificato( rs.getString( 10 ) );
		dto.setProgrCertificato( rs.getString( 11 ) );
		dto.setAnno( rs.getString( 12 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_CREDITO_2018";
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'ID_CREDITO = :idCredito'.
	 */
	
	public SiceeTCredito2018 findByPrimaryKey(long idCredito) throws SiceeTCredito2018DaoException
	{
		try {
			List<SiceeTCredito2018> list = jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_CREDITO = ?", this,idCredito);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_CERTIFICATORE_CERTIFICATO = :fkCertificatoreCertificato AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTCredito2018> findBySiceeTCertificato(String fkCertificatoreCertificato, String progrCertificato, String anno) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_CERTIFICATORE_CERTIFICATO = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,fkCertificatoreCertificato,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria ''.
	 */
	
	public List<SiceeTCredito2018> findAll() throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " ORDER BY ID_CREDITO", this);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public SiceeTCredito2018 findWhereFkCertificatoreEqualsCreditoDisp(String fkCertificatore) throws SiceeTCredito2018DaoException
	{
		try {
			List<SiceeTCredito2018> list = jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? ORDER BY ID_CREDITO DESC", this,fkCertificatore);
			return list.size() == 0 ? null : list.get(0);

		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TIPO_OP_2018 = :fkTipoOp2018'.
	 */
	
	public List<SiceeTCredito2018> findBySiceeDTipoOp2018(Integer fkTipoOp2018) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_TIPO_OP_2018 = ?", this,fkTipoOp2018);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TRANSAZIONE_2018 = :fkTransazione2018'.
	 */
	
	public List<SiceeTCredito2018> findBySiceeTTransazione2018(long fkTransazione2018) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_TRANSAZIONE_2018 = ?", this,fkTransazione2018);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'ID_CREDITO = :idCredito'.
	 */
	
	public List<SiceeTCredito2018> findWhereIdCreditoEquals(long idCredito) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ID_CREDITO = ? ORDER BY ID_CREDITO", this,idCredito);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTCredito2018> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? ORDER BY FK_CERTIFICATORE", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TRANSAZIONE_2018 = :fkTransazione2018'.
	 */
	
	public List<SiceeTCredito2018> findWhereFkTransazione2018Equals(long fkTransazione2018) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_TRANSAZIONE_2018 = ? ORDER BY FK_TRANSAZIONE_2018", this,fkTransazione2018);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TIPO_OP_2018 = :fkTipoOp2018'.
	 */
	
	public List<SiceeTCredito2018> findWhereFkTipoOp2018Equals(Integer fkTipoOp2018) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_TIPO_OP_2018 = ? ORDER BY FK_TIPO_OP_2018", this,fkTipoOp2018);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'VALORE_CREDITO_INIZIALE = :valoreCreditoIniziale'.
	 */
	
	public List<SiceeTCredito2018> findWhereValoreCreditoInizialeEquals(long valoreCreditoIniziale) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE VALORE_CREDITO_INIZIALE = ? ORDER BY VALORE_CREDITO_INIZIALE", this,valoreCreditoIniziale);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'VALORE_CREDITO_FINALE = :valoreCreditoFinale'.
	 */
	
	public List<SiceeTCredito2018> findWhereValoreCreditoFinaleEquals(long valoreCreditoFinale) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE VALORE_CREDITO_FINALE = ? ORDER BY VALORE_CREDITO_FINALE", this,valoreCreditoFinale);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'DATA_OPERAZIONE = :dataOperazione'.
	 */
	
	public List<SiceeTCredito2018> findWhereDataOperazioneEquals(Date dataOperazione) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE DATA_OPERAZIONE = ? ORDER BY DATA_OPERAZIONE", this,dataOperazione);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'VALORE_OPERAZIONE = :valoreOperazione'.
	 */
	
	public List<SiceeTCredito2018> findWhereValoreOperazioneEquals(long valoreOperazione) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE VALORE_OPERAZIONE = ? ORDER BY VALORE_OPERAZIONE", this,valoreOperazione);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'NOTE = :note'.
	 */
	
	public List<SiceeTCredito2018> findWhereNoteEquals(String note) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE NOTE = ? ORDER BY NOTE", this,note);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_CERTIFICATORE_CERTIFICATO = :fkCertificatoreCertificato'.
	 */
	
	public List<SiceeTCredito2018> findWhereFkCertificatoreCertificatoEquals(String fkCertificatoreCertificato) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE FK_CERTIFICATORE_CERTIFICATO = ? ORDER BY FK_CERTIFICATORE_CERTIFICATO", this,fkCertificatoreCertificato);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTCredito2018> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTCredito2018> findWhereAnnoEquals(String anno) throws SiceeTCredito2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CREDITO, FK_CERTIFICATORE, FK_TRANSAZIONE_2018, FK_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, NOTE, FK_CERTIFICATORE_CERTIFICATO, PROGR_CERTIFICATO, ANNO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTCredito2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_CREDITO_2018 table that matches the specified primary-key value.
	 */
	public SiceeTCredito2018 findByPrimaryKey(SiceeTCredito2018Pk pk) throws SiceeTCredito2018DaoException
	{
		return findByPrimaryKey( pk.getIdCredito() );
	}

}
