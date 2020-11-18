/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRispettoNormativeDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRispettoNormative;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRispettoNormativePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRispettoNormativeDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTRispettoNormativeDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTRispettoNormative>, SiceeTRispettoNormativeDao
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
	 * @return SiceeTRispettoNormativePk
	 */
	
	public SiceeTRispettoNormativePk insert(SiceeTRispettoNormative dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )",dto.getDtTitolo(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkNorma(),dto.getFlgNorma(),dto.getMotivoNonConformita(),dto.getNote());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	
	public void update(SiceeTRispettoNormativePk pk, SiceeTRispettoNormative dto) throws SiceeTRispettoNormativeDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET DT_TITOLO = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FK_NORMA = ?, FLG_NORMA = ?, MOTIVO_NON_CONFORMITA = ?, NOTE = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getDtTitolo(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkNorma(),dto.getFlgNorma(),dto.getMotivoNonConformita(),dto.getNote(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_RISPETTO_NORMATIVE table.
	 */
	
	public void delete(SiceeTRispettoNormativePk pk) throws SiceeTRispettoNormativeDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTRispettoNormative
	 */
	public SiceeTRispettoNormative mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTRispettoNormative dto = new SiceeTRispettoNormative();
		dto.setDtTitolo( rs.getTimestamp(1 ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setFkNorma( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setFkNorma( null );
		}
		
		dto.setFlgNorma( rs.getString( 6 ) );
		dto.setMotivoNonConformita( rs.getString( 7 ) );
		dto.setNote( rs.getString( 8 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_RISPETTO_NORMATIVE";
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTRispettoNormative findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTRispettoNormativeDaoException
	{
		try {
			List<SiceeTRispettoNormative> list = jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria ''.
	 */
	
	public List<SiceeTRispettoNormative> findAll() throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTRispettoNormative> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'DT_TITOLO = :dtTitolo'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereDtTitoloEquals(Date dtTitolo) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE DT_TITOLO = ? ORDER BY DT_TITOLO", this,dtTitolo);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereAnnoEquals(String anno) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'FK_NORMA = :fkNorma'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereFkNormaEquals(Integer fkNorma) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE FK_NORMA = ? ORDER BY FK_NORMA", this,fkNorma);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'FLG_NORMA = :flgNorma'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereFlgNormaEquals(String flgNorma) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE FLG_NORMA = ? ORDER BY FLG_NORMA", this,flgNorma);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'MOTIVO_NON_CONFORMITA = :motivoNonConformita'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereMotivoNonConformitaEquals(String motivoNonConformita) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE MOTIVO_NON_CONFORMITA = ? ORDER BY MOTIVO_NON_CONFORMITA", this,motivoNonConformita);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'NOTE = :note'.
	 */
	
	public List<SiceeTRispettoNormative> findWhereNoteEquals(String note) throws SiceeTRispettoNormativeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT DT_TITOLO, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_NORMA, FLG_NORMA, MOTIVO_NON_CONFORMITA, NOTE FROM " + getTableName() + " WHERE NOTE = ? ORDER BY NOTE", this,note);
		}
		catch (Exception e) {
			throw new SiceeTRispettoNormativeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_RISPETTO_NORMATIVE table that matches the specified primary-key value.
	 */
	public SiceeTRispettoNormative findByPrimaryKey(SiceeTRispettoNormativePk pk) throws SiceeTRispettoNormativeDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
