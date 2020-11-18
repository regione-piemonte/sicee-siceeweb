/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFabbisognoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFabbisogno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFabbisognoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTFabbisognoDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTFabbisognoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTFabbisogno>, SiceeTFabbisognoDao
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
	 * @return SiceeTFabbisognoPk
	 */
	
	public SiceeTFabbisognoPk insert(SiceeTFabbisogno dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDomRiscQh(),dto.getLimiteRegQhLim(),dto.getFabbCondiz(),dto.getDomAcsQhw(),dto.getEnAcsRinno(),dto.getRendAcsEtagacs(),dto.getFabbAcs(),dto.getFabbIllum());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_FABBISOGNO table.
	 */
	
	public void update(SiceeTFabbisognoPk pk, SiceeTFabbisogno dto) throws SiceeTFabbisognoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, DOM_RISC_QH = ?, LIMITE_REG_QH_LIM = ?, FABB_CONDIZ = ?, DOM_ACS_QHW = ?, EN_ACS_RINNO = ?, REND_ACS_ETAGACS = ?, FABB_ACS = ?, FABB_ILLUM = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDomRiscQh(),dto.getLimiteRegQhLim(),dto.getFabbCondiz(),dto.getDomAcsQhw(),dto.getEnAcsRinno(),dto.getRendAcsEtagacs(),dto.getFabbAcs(),dto.getFabbIllum(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_FABBISOGNO table.
	 */
	
	public void delete(SiceeTFabbisognoPk pk) throws SiceeTFabbisognoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTFabbisogno
	 */
	public SiceeTFabbisogno mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTFabbisogno dto = new SiceeTFabbisogno();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setDomRiscQh( new Double( rs.getDouble(4) ) );
		if (rs.wasNull()) {
			dto.setDomRiscQh( null );
		}
		
		dto.setLimiteRegQhLim( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setLimiteRegQhLim( null );
		}
		
		dto.setFabbCondiz( new Double( rs.getDouble(6) ) );
		if (rs.wasNull()) {
			dto.setFabbCondiz( null );
		}
		
		dto.setDomAcsQhw( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhw( null );
		}
		
		dto.setEnAcsRinno( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setEnAcsRinno( null );
		}
		
		dto.setRendAcsEtagacs( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setRendAcsEtagacs( null );
		}
		
		dto.setFabbAcs( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setFabbAcs( null );
		}
		
		dto.setFabbIllum( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setFabbIllum( null );
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
		return "SICEE_T_FABBISOGNO";
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTFabbisogno findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTFabbisognoDaoException
	{
		try {
			List<SiceeTFabbisogno> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria ''.
	 */
	
	public List<SiceeTFabbisogno> findAll() throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTFabbisogno> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTFabbisogno> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTFabbisogno> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTFabbisogno> findWhereAnnoEquals(String anno) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'DOM_RISC_QH = :domRiscQh'.
	 */
	
	public List<SiceeTFabbisogno> findWhereDomRiscQhEquals(Double domRiscQh) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE DOM_RISC_QH = ? ORDER BY DOM_RISC_QH", this,domRiscQh);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'LIMITE_REG_QH_LIM = :limiteRegQhLim'.
	 */
	
	public List<SiceeTFabbisogno> findWhereLimiteRegQhLimEquals(Double limiteRegQhLim) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE LIMITE_REG_QH_LIM = ? ORDER BY LIMITE_REG_QH_LIM", this,limiteRegQhLim);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'FABB_CONDIZ = :fabbCondiz'.
	 */
	
	public List<SiceeTFabbisogno> findWhereFabbCondizEquals(Double fabbCondiz) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE FABB_CONDIZ = ? ORDER BY FABB_CONDIZ", this,fabbCondiz);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'DOM_ACS_QHW = :domAcsQhw'.
	 */
	
	public List<SiceeTFabbisogno> findWhereDomAcsQhwEquals(Double domAcsQhw) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE DOM_ACS_QHW = ? ORDER BY DOM_ACS_QHW", this,domAcsQhw);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'EN_ACS_RINNO = :enAcsRinno'.
	 */
	
	public List<SiceeTFabbisogno> findWhereEnAcsRinnoEquals(Double enAcsRinno) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE EN_ACS_RINNO = ? ORDER BY EN_ACS_RINNO", this,enAcsRinno);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'REND_ACS_ETAGACS = :rendAcsEtagacs'.
	 */
	
	public List<SiceeTFabbisogno> findWhereRendAcsEtagacsEquals(Double rendAcsEtagacs) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE REND_ACS_ETAGACS = ? ORDER BY REND_ACS_ETAGACS", this,rendAcsEtagacs);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'FABB_ACS = :fabbAcs'.
	 */
	
	public List<SiceeTFabbisogno> findWhereFabbAcsEquals(Double fabbAcs) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE FABB_ACS = ? ORDER BY FABB_ACS", this,fabbAcs);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'FABB_ILLUM = :fabbIllum'.
	 */
	
	public List<SiceeTFabbisogno> findWhereFabbIllumEquals(Double fabbIllum) throws SiceeTFabbisognoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DOM_RISC_QH, LIMITE_REG_QH_LIM, FABB_CONDIZ, DOM_ACS_QHW, EN_ACS_RINNO, REND_ACS_ETAGACS, FABB_ACS, FABB_ILLUM FROM " + getTableName() + " WHERE FABB_ILLUM = ? ORDER BY FABB_ILLUM", this,fabbIllum);
		}
		catch (Exception e) {
			throw new SiceeTFabbisognoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_FABBISOGNO table that matches the specified primary-key value.
	 */
	public SiceeTFabbisogno findByPrimaryKey(SiceeTFabbisognoPk pk) throws SiceeTFabbisognoDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
