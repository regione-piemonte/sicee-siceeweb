/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTClasseEnergeticaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTClasseEnergeticaDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTClasseEnergeticaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTClasseEnergetica>, SiceeTClasseEnergeticaDao
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
	 * @return SiceeTClasseEnergeticaPk
	 */
	
	public SiceeTClasseEnergeticaPk insert(SiceeTClasseEnergetica dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIndRiscEpi(),dto.getIdCertificatore(),dto.getIndCondEst(),dto.getProgrCertificato(),dto.getIndIllum(),dto.getAnno(),dto.getIndGlobEplordo(),dto.getFkClasse(),dto.getRendGener(),dto.getRendRegol(),dto.getServiziEnergetici(),dto.getRendEmiss(),dto.getRendDistrib(),dto.getRendImpEtag(),dto.getDomRiscQhto(),dto.getLimiteRegQhto(),dto.getIndRiscEpito(),dto.getDomAcsQhwto(),dto.getEnAcsRinnoTo(),dto.getRendAcsEtagAcsto(),dto.getFabbAcsTo(),dto.getIndGlobEplordoTo(),dto.getEtagConv(),dto.getIndGlobLimiteTo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	
	public void update(SiceeTClasseEnergeticaPk pk, SiceeTClasseEnergetica dto) throws SiceeTClasseEnergeticaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET IND_RISC_EPI = ?, ID_CERTIFICATORE = ?, IND_COND_EST = ?, PROGR_CERTIFICATO = ?, IND_ILLUM = ?, ANNO = ?, IND_GLOB_EPLORDO = ?, FK_CLASSE = ?, REND_GENER = ?, REND_REGOL = ?, SERVIZI_ENERGETICI = ?, REND_EMISS = ?, REND_DISTRIB = ?, REND_IMP_ETAG = ?, DOM_RISC_QHTO = ?, LIMITE_REG_QHTO = ?, IND_RISC_EPITO = ?, DOM_ACS_QHWTO = ?, EN_ACS_RINNO_TO = ?, REND_ACS_ETAG_ACSTO = ?, FABB_ACS_TO = ?, IND_GLOB_EPLORDO_TO = ?, ETAG_CONV = ?, IND_GLOB_LIMITE_TO = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIndRiscEpi(),dto.getIdCertificatore(),dto.getIndCondEst(),dto.getProgrCertificato(),dto.getIndIllum(),dto.getAnno(),dto.getIndGlobEplordo(),dto.getFkClasse(),dto.getRendGener(),dto.getRendRegol(),dto.getServiziEnergetici(),dto.getRendEmiss(),dto.getRendDistrib(),dto.getRendImpEtag(),dto.getDomRiscQhto(),dto.getLimiteRegQhto(),dto.getIndRiscEpito(),dto.getDomAcsQhwto(),dto.getEnAcsRinnoTo(),dto.getRendAcsEtagAcsto(),dto.getFabbAcsTo(),dto.getIndGlobEplordoTo(),dto.getEtagConv(),dto.getIndGlobLimiteTo(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	
	public void delete(SiceeTClasseEnergeticaPk pk) throws SiceeTClasseEnergeticaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTClasseEnergetica
	 */
	public SiceeTClasseEnergetica mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTClasseEnergetica dto = new SiceeTClasseEnergetica();
		dto.setIndRiscEpi( new Double( rs.getDouble(1) ) );
		if (rs.wasNull()) {
			dto.setIndRiscEpi( null );
		}
		
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setIndCondEst( new Double( rs.getDouble(3) ) );
		if (rs.wasNull()) {
			dto.setIndCondEst( null );
		}
		
		dto.setProgrCertificato( rs.getString( 4 ) );
		dto.setIndIllum( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setIndIllum( null );
		}
		
		dto.setAnno( rs.getString( 6 ) );
		dto.setIndGlobEplordo( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setIndGlobEplordo( null );
		}
		
		dto.setFkClasse( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setFkClasse( null );
		}
		
		dto.setRendGener( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setRendGener( null );
		}
		
		dto.setRendRegol( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setRendRegol( null );
		}
		
		dto.setServiziEnergetici( rs.getString( 11 ) );
		dto.setRendEmiss( new Double( rs.getDouble(12) ) );
		if (rs.wasNull()) {
			dto.setRendEmiss( null );
		}
		
		dto.setRendDistrib( new Double( rs.getDouble(13) ) );
		if (rs.wasNull()) {
			dto.setRendDistrib( null );
		}
		
		dto.setRendImpEtag( new Double( rs.getDouble(14) ) );
		if (rs.wasNull()) {
			dto.setRendImpEtag( null );
		}
		
		dto.setDomRiscQhto( new Double( rs.getDouble(15) ) );
		if (rs.wasNull()) {
			dto.setDomRiscQhto( null );
		}
		
		dto.setLimiteRegQhto( new Double( rs.getDouble(16) ) );
		if (rs.wasNull()) {
			dto.setLimiteRegQhto( null );
		}
		
		dto.setIndRiscEpito( new Double( rs.getDouble(17) ) );
		if (rs.wasNull()) {
			dto.setIndRiscEpito( null );
		}
		
		dto.setDomAcsQhwto( new Double( rs.getDouble(18) ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhwto( null );
		}
		
		dto.setEnAcsRinnoTo( new Double( rs.getDouble(19) ) );
		if (rs.wasNull()) {
			dto.setEnAcsRinnoTo( null );
		}
		
		dto.setRendAcsEtagAcsto( new Double( rs.getDouble(20) ) );
		if (rs.wasNull()) {
			dto.setRendAcsEtagAcsto( null );
		}
		
		dto.setFabbAcsTo( new Double( rs.getDouble(21) ) );
		if (rs.wasNull()) {
			dto.setFabbAcsTo( null );
		}
		
		dto.setIndGlobEplordoTo( new Double( rs.getDouble(22) ) );
		if (rs.wasNull()) {
			dto.setIndGlobEplordoTo( null );
		}
		
		dto.setEtagConv( new Double( rs.getDouble(23) ) );
		if (rs.wasNull()) {
			dto.setEtagConv( null );
		}
		
		dto.setIndGlobLimiteTo( new Double( rs.getDouble(24) ) );
		if (rs.wasNull()) {
			dto.setIndGlobLimiteTo( null );
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
		return "SICEE_T_CLASSE_ENERGETICA";
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTClasseEnergetica findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			List<SiceeTClasseEnergetica> list = jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria ''.
	 */
	
	public List<SiceeTClasseEnergetica> findAll() throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTClasseEnergetica> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_RISC_EPI = :indRiscEpi'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIndRiscEpiEquals(Double indRiscEpi) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE IND_RISC_EPI = ? ORDER BY IND_RISC_EPI", this,indRiscEpi);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_COND_EST = :indCondEst'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIndCondEstEquals(Double indCondEst) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE IND_COND_EST = ? ORDER BY IND_COND_EST", this,indCondEst);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_ILLUM = :indIllum'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIndIllumEquals(Double indIllum) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE IND_ILLUM = ? ORDER BY IND_ILLUM", this,indIllum);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereAnnoEquals(String anno) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_GLOB_EPLORDO = :indGlobEplordo'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIndGlobEplordoEquals(Double indGlobEplordo) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE IND_GLOB_EPLORDO = ? ORDER BY IND_GLOB_EPLORDO", this,indGlobEplordo);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'FK_CLASSE = :fkClasse'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereFkClasseEquals(Integer fkClasse) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE FK_CLASSE = ? ORDER BY FK_CLASSE", this,fkClasse);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_GENER = :rendGener'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereRendGenerEquals(Double rendGener) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE REND_GENER = ? ORDER BY REND_GENER", this,rendGener);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_REGOL = :rendRegol'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereRendRegolEquals(Double rendRegol) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE REND_REGOL = ? ORDER BY REND_REGOL", this,rendRegol);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'SERVIZI_ENERGETICI = :serviziEnergetici'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereServiziEnergeticiEquals(String serviziEnergetici) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE SERVIZI_ENERGETICI = ? ORDER BY SERVIZI_ENERGETICI", this,serviziEnergetici);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_EMISS = :rendEmiss'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereRendEmissEquals(Double rendEmiss) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE REND_EMISS = ? ORDER BY REND_EMISS", this,rendEmiss);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_DISTRIB = :rendDistrib'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereRendDistribEquals(Double rendDistrib) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE REND_DISTRIB = ? ORDER BY REND_DISTRIB", this,rendDistrib);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_IMP_ETAG = :rendImpEtag'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereRendImpEtagEquals(Double rendImpEtag) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE REND_IMP_ETAG = ? ORDER BY REND_IMP_ETAG", this,rendImpEtag);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'DOM_RISC_QHTO = :domRiscQhto'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereDomRiscQhtoEquals(Double domRiscQhto) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE DOM_RISC_QHTO = ? ORDER BY DOM_RISC_QHTO", this,domRiscQhto);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'LIMITE_REG_QHTO = :limiteRegQhto'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereLimiteRegQhtoEquals(Double limiteRegQhto) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE LIMITE_REG_QHTO = ? ORDER BY LIMITE_REG_QHTO", this,limiteRegQhto);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_RISC_EPITO = :indRiscEpito'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIndRiscEpitoEquals(Double indRiscEpito) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE IND_RISC_EPITO = ? ORDER BY IND_RISC_EPITO", this,indRiscEpito);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'DOM_ACS_QHWTO = :domAcsQhwto'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereDomAcsQhwtoEquals(Double domAcsQhwto) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE DOM_ACS_QHWTO = ? ORDER BY DOM_ACS_QHWTO", this,domAcsQhwto);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'EN_ACS_RINNO_TO = :enAcsRinnoTo'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereEnAcsRinnoToEquals(Double enAcsRinnoTo) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE EN_ACS_RINNO_TO = ? ORDER BY EN_ACS_RINNO_TO", this,enAcsRinnoTo);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_ACS_ETAG_ACSTO = :rendAcsEtagAcsto'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereRendAcsEtagAcstoEquals(Double rendAcsEtagAcsto) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE REND_ACS_ETAG_ACSTO = ? ORDER BY REND_ACS_ETAG_ACSTO", this,rendAcsEtagAcsto);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'FABB_ACS_TO = :fabbAcsTo'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereFabbAcsToEquals(Double fabbAcsTo) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE FABB_ACS_TO = ? ORDER BY FABB_ACS_TO", this,fabbAcsTo);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_GLOB_EPLORDO_TO = :indGlobEplordoTo'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIndGlobEplordoToEquals(Double indGlobEplordoTo) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE IND_GLOB_EPLORDO_TO = ? ORDER BY IND_GLOB_EPLORDO_TO", this,indGlobEplordoTo);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ETAG_CONV = :etagConv'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereEtagConvEquals(Double etagConv) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE ETAG_CONV = ? ORDER BY ETAG_CONV", this,etagConv);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_GLOB_LIMITE_TO = :indGlobLimiteTo'.
	 */
	
	public List<SiceeTClasseEnergetica> findWhereIndGlobLimiteToEquals(Double indGlobLimiteTo) throws SiceeTClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT IND_RISC_EPI, ID_CERTIFICATORE, IND_COND_EST, PROGR_CERTIFICATO, IND_ILLUM, ANNO, IND_GLOB_EPLORDO, FK_CLASSE, REND_GENER, REND_REGOL, SERVIZI_ENERGETICI, REND_EMISS, REND_DISTRIB, REND_IMP_ETAG, DOM_RISC_QHTO, LIMITE_REG_QHTO, IND_RISC_EPITO, DOM_ACS_QHWTO, EN_ACS_RINNO_TO, REND_ACS_ETAG_ACSTO, FABB_ACS_TO, IND_GLOB_EPLORDO_TO, ETAG_CONV, IND_GLOB_LIMITE_TO FROM " + getTableName() + " WHERE IND_GLOB_LIMITE_TO = ? ORDER BY IND_GLOB_LIMITE_TO", this,indGlobLimiteTo);
		}
		catch (Exception e) {
			throw new SiceeTClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_CLASSE_ENERGETICA table that matches the specified primary-key value.
	 */
	public SiceeTClasseEnergetica findByPrimaryKey(SiceeTClasseEnergeticaPk pk) throws SiceeTClasseEnergeticaDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
