/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTActaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTActa;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTActaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTActaDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTActaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTActa>, SiceeTActaDao
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
	 * @return SiceeTActaPk
	 */
	
	public SiceeTActaPk insert(SiceeTActa dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getVolume(),dto.getIdDocActa(),dto.getIdClassificazioneActa(),dto.getTipoDocumentoActa(),dto.getFailedStepActa(),dto.getTimestampArchiviazione(),dto.getNumeroProtocollo(),dto.getMailInviata(),dto.getTimestampProtocollo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ACTA table.
	 */
	
	public void update(SiceeTActaPk pk, SiceeTActa dto) throws SiceeTActaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, VOLUME = ?, ID_DOC_ACTA = ?, ID_CLASSIFICAZIONE_ACTA = ?, TIPO_DOCUMENTO_ACTA = ?, FAILED_STEP_ACTA = ?, TIMESTAMP_ARCHIVIAZIONE = ?, NUMERO_PROTOCOLLO = ?, MAIL_INVIATA = ?, TIMESTAMP_PROTOCOLLO = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getVolume(),dto.getIdDocActa(),dto.getIdClassificazioneActa(),dto.getTipoDocumentoActa(),dto.getFailedStepActa(),dto.getTimestampArchiviazione(),dto.getNumeroProtocollo(),dto.getMailInviata(),dto.getTimestampProtocollo(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ACTA table.
	 */
	
	public void delete(SiceeTActaPk pk) throws SiceeTActaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTActa
	 */
	public SiceeTActa mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTActa dto = new SiceeTActa();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setVolume( rs.getString( 4 ) );
		dto.setIdDocActa( rs.getString( 5 ) );
		dto.setIdClassificazioneActa( rs.getString( 6 ) );
		dto.setTipoDocumentoActa( rs.getString( 7 ) );
		dto.setFailedStepActa( rs.getString( 8 ) );
		dto.setTimestampArchiviazione( rs.getTimestamp(9 ) );
		dto.setNumeroProtocollo( rs.getString( 10 ) );
		dto.setMailInviata( rs.getString( 11 ) );
		dto.setTimestampProtocollo( rs.getTimestamp(12 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_ACTA";
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTActa findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTActaDaoException
	{
		try {
			List<SiceeTActa> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria ''.
	 */
	
	public List<SiceeTActa> findAll() throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTActa> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTActa> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTActa> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTActa> findWhereAnnoEquals(String anno) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'VOLUME = :volume'.
	 */
	
	public List<SiceeTActa> findWhereVolumeEquals(String volume) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE VOLUME = ? ORDER BY VOLUME", this,volume);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_DOC_ACTA = :idDocActa'.
	 */
	
	public List<SiceeTActa> findWhereIdDocActaEquals(String idDocActa) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE ID_DOC_ACTA = ? ORDER BY ID_DOC_ACTA", this,idDocActa);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CLASSIFICAZIONE_ACTA = :idClassificazioneActa'.
	 */
	
	public List<SiceeTActa> findWhereIdClassificazioneActaEquals(String idClassificazioneActa) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE ID_CLASSIFICAZIONE_ACTA = ? ORDER BY ID_CLASSIFICAZIONE_ACTA", this,idClassificazioneActa);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'TIPO_DOCUMENTO_ACTA = :tipoDocumentoActa'.
	 */
	
	public List<SiceeTActa> findWhereTipoDocumentoActaEquals(String tipoDocumentoActa) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE TIPO_DOCUMENTO_ACTA = ? ORDER BY TIPO_DOCUMENTO_ACTA", this,tipoDocumentoActa);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'FAILED_STEP_ACTA = :failedStepActa'.
	 */
	
	public List<SiceeTActa> findWhereFailedStepActaEquals(String failedStepActa) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE FAILED_STEP_ACTA = ? ORDER BY FAILED_STEP_ACTA", this,failedStepActa);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'TIMESTAMP_ARCHIVIAZIONE = :timestampArchiviazione'.
	 */
	
	public List<SiceeTActa> findWhereTimestampArchiviazioneEquals(Date timestampArchiviazione) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE TIMESTAMP_ARCHIVIAZIONE = ? ORDER BY TIMESTAMP_ARCHIVIAZIONE", this,timestampArchiviazione);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'NUMERO_PROTOCOLLO = :numeroProtocollo'.
	 */
	
	public List<SiceeTActa> findWhereNumeroProtocolloEquals(String numeroProtocollo) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE NUMERO_PROTOCOLLO = ? ORDER BY NUMERO_PROTOCOLLO", this,numeroProtocollo);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'MAIL_INVIATA = :mailInviata'.
	 */
	
	public List<SiceeTActa> findWhereMailInviataEquals(String mailInviata) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE MAIL_INVIATA = ? ORDER BY MAIL_INVIATA", this,mailInviata);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'TIMESTAMP_PROTOCOLLO = :timestampProtocollo'.
	 */
	
	public List<SiceeTActa> findWhereTimestampProtocolloEquals(Date timestampProtocollo) throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO FROM " + getTableName() + " WHERE TIMESTAMP_PROTOCOLLO = ? ORDER BY TIMESTAMP_PROTOCOLLO", this,timestampProtocollo);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ACTA table that matches the specified primary-key value.
	 */
	public SiceeTActa findByPrimaryKey(SiceeTActaPk pk) throws SiceeTActaDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
