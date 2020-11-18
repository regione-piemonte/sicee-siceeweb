/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTSiapeDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSiape;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSiapePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTSiapeDaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTSiapeDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTSiape>, SiceeTSiapeDao
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
	 * @return SiceeTSiapePk
	 */
	public SiceeTSiapePk insert(SiceeTSiape dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE ) VALUES ( ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdTipoAzione(),dto.getFlgDaElaborare());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_SIAPE table.
	 */
	public void update(SiceeTSiapePk pk, SiceeTSiape dto) throws SiceeTSiapeDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, ID_TIPO_AZIONE = ?, FLG_DA_ELABORARE = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND ID_TIPO_AZIONE = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdTipoAzione(),dto.getFlgDaElaborare(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getIdTipoAzione());
	}

	/** 
	 * Deletes a single row in the SICEE_T_SIAPE table.
	 */
	public void delete(SiceeTSiapePk pk) throws SiceeTSiapeDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND ID_TIPO_AZIONE = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno(),pk.getIdTipoAzione());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTSiape
	 */
	public SiceeTSiape mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTSiape dto = new SiceeTSiape();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setIdTipoAzione( new Long(rs.getLong( 4 ) ));
		dto.setFlgDaElaborare( rs.getString( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_SIAPE";
	}

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND ID_TIPO_AZIONE = :idTipoAzione'.
	 */
	public SiceeTSiape findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, long idTipoAzione) throws SiceeTSiapeDaoException
	{
		try {
			List<SiceeTSiape> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? AND ID_TIPO_AZIONE = ?", this,idCertificatore,progrCertificato,anno,idTipoAzione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTSiapeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria ''.
	 */
	public List<SiceeTSiape> findAll() throws SiceeTSiapeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE", this);
		}
		catch (Exception e) {
			throw new SiceeTSiapeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTSiape> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTSiapeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTSiapeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTSiape> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTSiapeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTSiapeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTSiape> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTSiapeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTSiapeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTSiape> findWhereAnnoEquals(String anno) throws SiceeTSiapeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTSiapeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SIAPE table that match the criteria 'ID_TIPO_AZIONE = :idTipoAzione'.
	 */
	public List<SiceeTSiape> findWhereIdTipoAzioneEquals(long idTipoAzione) throws SiceeTSiapeDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_TIPO_AZIONE, FLG_DA_ELABORARE FROM " + getTableName() + " WHERE ID_TIPO_AZIONE = ? ORDER BY ID_TIPO_AZIONE", this,idTipoAzione);
		}
		catch (Exception e) {
			throw new SiceeTSiapeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_SIAPE table that matches the specified primary-key value.
	 */
	public SiceeTSiape findByPrimaryKey(SiceeTSiapePk pk) throws SiceeTSiapeDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno(), pk.getIdTipoAzione() );
	}

}
