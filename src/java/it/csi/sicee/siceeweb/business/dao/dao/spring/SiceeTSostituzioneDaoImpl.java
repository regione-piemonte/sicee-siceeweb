/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTSostituzioneDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSostituzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSostituzionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTSostituzioneDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

public class SiceeTSostituzioneDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTSostituzione>, SiceeTSostituzioneDao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	protected DataFieldMaxValueIncrementer incrementerSostituzioneProgr;
	   
	public void setIncrementerSostituzioneProgr(DataFieldMaxValueIncrementer incrementer) {
		this.incrementerSostituzioneProgr = incrementer;
	}
	
	public int getNextValueSostituzioneProgr() {
		return this.incrementerSostituzioneProgr.nextIntValue();
	}

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
	 * @return SiceeTSostituzionePk
	 */

	public SiceeTSostituzionePk insert(SiceeTSostituzione dto)
	{
		dto.setIdSostituzione(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdSostituzione(),dto.getProgrSostituzione(),dto.getIdCertificatoreOld(),dto.getProgrCertificatoOld(),dto.getAnnoOld(),dto.getIdCertificatoreNew(),dto.getProgrCertificatoNew(),dto.getAnnoNew(),dto.getFlgInvioMail(),dto.getEmail());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_SOSTITUZIONE table.
	 */
	
	public void update(SiceeTSostituzionePk pk, SiceeTSostituzione dto) throws SiceeTSostituzioneDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_SOSTITUZIONE = ?, PROGR_SOSTITUZIONE = ?, ID_CERTIFICATORE_OLD = ?, PROGR_CERTIFICATO_OLD = ?, ANNO_OLD = ?, ID_CERTIFICATORE_NEW = ?, PROGR_CERTIFICATO_NEW = ?, ANNO_NEW = ?, FLG_INVIO_MAIL = ?, EMAIL = ? WHERE ID_SOSTITUZIONE = ? AND PROGR_SOSTITUZIONE = ?",dto.getIdSostituzione(),dto.getProgrSostituzione(),dto.getIdCertificatoreOld(),dto.getProgrCertificatoOld(),dto.getAnnoOld(),dto.getIdCertificatoreNew(),dto.getProgrCertificatoNew(),dto.getAnnoNew(),dto.getFlgInvioMail(),dto.getEmail(),pk.getIdSostituzione(),pk.getProgrSostituzione());
	}

	/** 
	 * Deletes a single row in the SICEE_T_SOSTITUZIONE table.
	 */
	
	public void delete(SiceeTSostituzionePk pk) throws SiceeTSostituzioneDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_SOSTITUZIONE = ? AND PROGR_SOSTITUZIONE = ?",pk.getIdSostituzione(),pk.getProgrSostituzione());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTSostituzione
	 */
	public SiceeTSostituzione mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTSostituzione dto = new SiceeTSostituzione();
		dto.setIdSostituzione( new Integer( rs.getInt(1) ) );
		dto.setProgrSostituzione( new Integer( rs.getInt(2) ) );
		dto.setIdCertificatoreOld( rs.getString( 3 ) );
		dto.setProgrCertificatoOld( rs.getString( 4 ) );
		dto.setAnnoOld( rs.getString( 5 ) );
		dto.setIdCertificatoreNew( rs.getString( 6 ) );
		dto.setProgrCertificatoNew( rs.getString( 7 ) );
		dto.setAnnoNew( rs.getString( 8 ) );
		dto.setFlgInvioMail( rs.getString( 9 ) );
		dto.setEmail( rs.getString( 10 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_SOSTITUZIONE";
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_SOSTITUZIONE = :idSostituzione AND PROGR_SOSTITUZIONE = :progrSostituzione'.
	 */
	
	public SiceeTSostituzione findByPrimaryKey(Integer idSostituzione, Integer progrSostituzione) throws SiceeTSostituzioneDaoException
	{
		try {
			List<SiceeTSostituzione> list = jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ID_SOSTITUZIONE = ? AND PROGR_SOSTITUZIONE = ?", this,idSostituzione,progrSostituzione);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_OLD = :idCertificatoreOld AND ID_CERTIFICATORE_NEW = :idCertificatoreNew AND PROGR_CERTIFICATO_OLD = :progrCertificatoOld AND PROGR_CERTIFICATO_NEW = :progrCertificatoNew AND ANNO_OLD = :annoOld AND ANNO_NEW = :annoNew'.
	 */
	
	public SiceeTSostituzione findBySiceeTCertificatoOldNew(String idCertificatoreOld, String idCertificatoreNew, String progrCertificatoOld, String progrCertificatoNew, String annoOld, String annoNew) throws SiceeTSostituzioneDaoException
	{
		try {
			List<SiceeTSostituzione> list = jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ID_CERTIFICATORE_OLD = ? AND ID_CERTIFICATORE_NEW = ? AND PROGR_CERTIFICATO_OLD = ? AND PROGR_CERTIFICATO_NEW = ? AND ANNO_OLD = ? AND ANNO_NEW = ?", this,idCertificatoreOld,idCertificatoreNew,progrCertificatoOld,progrCertificatoNew,annoOld,annoNew);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria ''.
	 */
	
	public List<SiceeTSostituzione> findAll() throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " ORDER BY ID_SOSTITUZIONE, PROGR_SOSTITUZIONE", this);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_NEW = :idCertificatoreNew'.
	 */
	
	public List<SiceeTSostituzione> findBySiceeTCertificato(String idCertificatoreNew) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ID_CERTIFICATORE_NEW = ?", this,idCertificatoreNew);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_OLD = :idCertificatoreOld AND PROGR_CERTIFICATO_OLD = :progrCertificatoOld AND PROGR_CERTIFICATO_NEW = :progrCertificatoNew AND ANNO_OLD = :annoOld AND ANNO_NEW = :annoNew'.
	 */
	
	public List<SiceeTSostituzione> findBySiceeTCertificato2(String idCertificatoreOld, String progrCertificatoOld, String progrCertificatoNew, String annoOld, String annoNew) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ID_CERTIFICATORE_OLD = ? AND PROGR_CERTIFICATO_OLD = ? AND PROGR_CERTIFICATO_NEW = ? AND ANNO_OLD = ? AND ANNO_NEW = ?", this,idCertificatoreOld,progrCertificatoOld,progrCertificatoNew,annoOld,annoNew);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_SOSTITUZIONE = :idSostituzione'.
	 */
	
	public List<SiceeTSostituzione> findWhereIdSostituzioneEquals(Long idSostituzione) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ID_SOSTITUZIONE = ? ORDER BY ID_SOSTITUZIONE", this,idSostituzione);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'PROGR_SOSTITUZIONE = :progrSostituzione'.
	 */
	
	public List<SiceeTSostituzione> findWhereProgrSostituzioneEquals(Long progrSostituzione) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE PROGR_SOSTITUZIONE = ? ORDER BY PROGR_SOSTITUZIONE", this,progrSostituzione);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_OLD = :idCertificatoreOld'.
	 */
	
	public List<SiceeTSostituzione> findWhereIdCertificatoreOldEquals(String idCertificatoreOld) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ID_CERTIFICATORE_OLD = ? ORDER BY ID_CERTIFICATORE_OLD", this,idCertificatoreOld);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'PROGR_CERTIFICATO_OLD = :progrCertificatoOld'.
	 */
	
	public List<SiceeTSostituzione> findWhereProgrCertificatoOldEquals(String progrCertificatoOld) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE PROGR_CERTIFICATO_OLD = ? ORDER BY PROGR_CERTIFICATO_OLD", this,progrCertificatoOld);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ANNO_OLD = :annoOld'.
	 */
	
	public List<SiceeTSostituzione> findWhereAnnoOldEquals(String annoOld) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ANNO_OLD = ? ORDER BY ANNO_OLD", this,annoOld);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_NEW = :idCertificatoreNew'.
	 */
	
	public List<SiceeTSostituzione> findWhereIdCertificatoreNewEquals(String idCertificatoreNew) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ID_CERTIFICATORE_NEW = ? ORDER BY ID_CERTIFICATORE_NEW", this,idCertificatoreNew);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'PROGR_CERTIFICATO_NEW = :progrCertificatoNew'.
	 */
	
	public List<SiceeTSostituzione> findWhereProgrCertificatoNewEquals(String progrCertificatoNew) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE PROGR_CERTIFICATO_NEW = ? ORDER BY PROGR_CERTIFICATO_NEW", this,progrCertificatoNew);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ANNO_NEW = :annoNew'.
	 */
	
	public List<SiceeTSostituzione> findWhereAnnoNewEquals(String annoNew) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE ANNO_NEW = ? ORDER BY ANNO_NEW", this,annoNew);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'FLG_INVIO_MAIL = :flgInvioMail'.
	 */
	
	public List<SiceeTSostituzione> findWhereFlgInvioMailEquals(String flgInvioMail) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE FLG_INVIO_MAIL = ? ORDER BY FLG_INVIO_MAIL", this,flgInvioMail);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'EMAIL = :email'.
	 */
	
	public List<SiceeTSostituzione> findWhereEmailEquals(String email) throws SiceeTSostituzioneDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_SOSTITUZIONE, PROGR_SOSTITUZIONE, ID_CERTIFICATORE_OLD, PROGR_CERTIFICATO_OLD, ANNO_OLD, ID_CERTIFICATORE_NEW, PROGR_CERTIFICATO_NEW, ANNO_NEW, FLG_INVIO_MAIL, EMAIL FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this,email);
		}
		catch (Exception e) {
			throw new SiceeTSostituzioneDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_SOSTITUZIONE table that matches the specified primary-key value.
	 */
	public SiceeTSostituzione findByPrimaryKey(SiceeTSostituzionePk pk) throws SiceeTSostituzioneDaoException
	{
		return findByPrimaryKey( pk.getIdSostituzione(), pk.getProgrSostituzione() );
	}

}
