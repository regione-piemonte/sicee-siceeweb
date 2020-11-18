/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEnergiaSoprIngrDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEnergiaSoprIngr;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEnergiaSoprIngrPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTEnergiaSoprIngrDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTEnergiaSoprIngrDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTEnergiaSoprIngr>, SiceeTEnergiaSoprIngrDao
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
	 * @return SiceeTEnergiaSoprIngrPk
	 */
	
	public SiceeTEnergiaSoprIngrPk insert(SiceeTEnergiaSoprIngr dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkDati(),dto.getTecnoRinno(),dto.getAnnoInstall(),dto.getEnTermicaProd(),dto.getEnElettProd(),dto.getAutoconsTermico(),dto.getAutoconsElett(),dto.getDtSopralluogo(),dto.getNoteSoprall(),dto.getPercFontiRinnov());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	
	public void update(SiceeTEnergiaSoprIngrPk pk, SiceeTEnergiaSoprIngr dto) throws SiceeTEnergiaSoprIngrDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FK_DATI = ?, TECNO_RINNO = ?, ANNO_INSTALL = ?, EN_TERMICA_PROD = ?, EN_ELETT_PROD = ?, AUTOCONS_TERMICO = ?, AUTOCONS_ELETT = ?, DT_SOPRALLUOGO = ?, NOTE_SOPRALL = ?, PERC_FONTI_RINNOV = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkDati(),dto.getTecnoRinno(),dto.getAnnoInstall(),dto.getEnTermicaProd(),dto.getEnElettProd(),dto.getAutoconsTermico(),dto.getAutoconsElett(),dto.getDtSopralluogo(),dto.getNoteSoprall(),dto.getPercFontiRinnov(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	
	public void delete(SiceeTEnergiaSoprIngrPk pk) throws SiceeTEnergiaSoprIngrDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTEnergiaSoprIngr
	 */
	public SiceeTEnergiaSoprIngr mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTEnergiaSoprIngr dto = new SiceeTEnergiaSoprIngr();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFkDati( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setFkDati( null );
		}
		
		dto.setTecnoRinno( rs.getString( 5 ) );
		dto.setAnnoInstall( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setAnnoInstall( null );
		}
		
		dto.setEnTermicaProd( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setEnTermicaProd( null );
		}
		
		dto.setEnElettProd( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setEnElettProd( null );
		}
		
		dto.setAutoconsTermico( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setAutoconsTermico( null );
		}
		
		dto.setAutoconsElett( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setAutoconsElett( null );
		}
		
		dto.setDtSopralluogo( rs.getTimestamp(11 ) );
		dto.setNoteSoprall( rs.getString( 12 ) );
		dto.setPercFontiRinnov( new Double( rs.getDouble(13) ) );
		if (rs.wasNull()) {
			dto.setPercFontiRinnov( null );
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
		return "SICEE_T_ENERGIA_SOPR_INGR";
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTEnergiaSoprIngr findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			List<SiceeTEnergiaSoprIngr> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria ''.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findAll() throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereAnnoEquals(String anno) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'FK_DATI = :fkDati'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereFkDatiEquals(Integer fkDati) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE FK_DATI = ? ORDER BY FK_DATI", this,fkDati);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'TECNO_RINNO = :tecnoRinno'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereTecnoRinnoEquals(String tecnoRinno) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE TECNO_RINNO = ? ORDER BY TECNO_RINNO", this,tecnoRinno);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ANNO_INSTALL = :annoInstall'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereAnnoInstallEquals(Integer annoInstall) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE ANNO_INSTALL = ? ORDER BY ANNO_INSTALL", this,annoInstall);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'EN_TERMICA_PROD = :enTermicaProd'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereEnTermicaProdEquals(Double enTermicaProd) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE EN_TERMICA_PROD = ? ORDER BY EN_TERMICA_PROD", this,enTermicaProd);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'EN_ELETT_PROD = :enElettProd'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereEnElettProdEquals(Double enElettProd) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE EN_ELETT_PROD = ? ORDER BY EN_ELETT_PROD", this,enElettProd);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'AUTOCONS_TERMICO = :autoconsTermico'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereAutoconsTermicoEquals(Double autoconsTermico) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE AUTOCONS_TERMICO = ? ORDER BY AUTOCONS_TERMICO", this,autoconsTermico);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'AUTOCONS_ELETT = :autoconsElett'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereAutoconsElettEquals(Double autoconsElett) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE AUTOCONS_ELETT = ? ORDER BY AUTOCONS_ELETT", this,autoconsElett);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'DT_SOPRALLUOGO = :dtSopralluogo'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereDtSopralluogoEquals(Date dtSopralluogo) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE DT_SOPRALLUOGO = ? ORDER BY DT_SOPRALLUOGO", this,dtSopralluogo);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'NOTE_SOPRALL = :noteSoprall'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWhereNoteSoprallEquals(String noteSoprall) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE NOTE_SOPRALL = ? ORDER BY NOTE_SOPRALL", this,noteSoprall);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'PERC_FONTI_RINNOV = :percFontiRinnov'.
	 */
	
	public List<SiceeTEnergiaSoprIngr> findWherePercFontiRinnovEquals(Double percFontiRinnov) throws SiceeTEnergiaSoprIngrDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_DATI, TECNO_RINNO, ANNO_INSTALL, EN_TERMICA_PROD, EN_ELETT_PROD, AUTOCONS_TERMICO, AUTOCONS_ELETT, DT_SOPRALLUOGO, NOTE_SOPRALL, PERC_FONTI_RINNOV FROM " + getTableName() + " WHERE PERC_FONTI_RINNOV = ? ORDER BY PERC_FONTI_RINNOV", this,percFontiRinnov);
		}
		catch (Exception e) {
			throw new SiceeTEnergiaSoprIngrDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ENERGIA_SOPR_INGR table that matches the specified primary-key value.
	 */
	public SiceeTEnergiaSoprIngr findByPrimaryKey(SiceeTEnergiaSoprIngrPk pk) throws SiceeTEnergiaSoprIngrDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
