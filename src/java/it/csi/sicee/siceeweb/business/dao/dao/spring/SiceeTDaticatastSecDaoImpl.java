/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDaticatastSecDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSecPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDaticatastSecDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDaticatastSecDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDaticatastSec>, SiceeTDaticatastSecDao
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
	 * @return SiceeTDaticatastSecPk
	 */
	public SiceeTDaticatastSecPk insert(SiceeTDaticatastSec dto)
	{
		dto.setIdDaticatastSec(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdDaticatastSec(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getSezione(),dto.getFoglio(),dto.getParticella(),dto.getSubalterno(),dto.getFlgSigmater(),dto.getIdProv(),dto.getDescProv(),dto.getIdComune(),dto.getDescComune(),dto.getCodiceComuneCatastale());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATICATAST_SEC table.
	 */
	public void update(SiceeTDaticatastSecPk pk, SiceeTDaticatastSec dto) throws SiceeTDaticatastSecDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DATICATAST_SEC = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, SEZIONE = ?, FOGLIO = ?, PARTICELLA = ?, SUBALTERNO = ?, FLG_SIGMATER = ?, ID_PROV = ?, DESC_PROV = ?, ID_COMUNE = ?, DESC_COMUNE = ?, CODICE_COMUNE_CATASTALE = ? WHERE ID_DATICATAST_SEC = ?",dto.getIdDaticatastSec(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getSezione(),dto.getFoglio(),dto.getParticella(),dto.getSubalterno(),dto.getFlgSigmater(),dto.getIdProv(),dto.getDescProv(),dto.getIdComune(),dto.getDescComune(),dto.getCodiceComuneCatastale(),pk.getIdDaticatastSec());
	}

	/**
	 * Deletes rows in the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'..
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @throws SiceeTDaticatastSecDaoException the sicee t daticatast sec dao exception
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDaticatastSecDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore, progrCertificato, anno);
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATICATAST_SEC table.
	 */
	public void delete(SiceeTDaticatastSecPk pk) throws SiceeTDaticatastSecDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DATICATAST_SEC = ?",pk.getIdDaticatastSec());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDaticatastSec
	 */
	public SiceeTDaticatastSec mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDaticatastSec dto = new SiceeTDaticatastSec();
		dto.setIdDaticatastSec( new Integer( rs.getInt(1) ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setSezione( rs.getString( 5 ) );
		dto.setFoglio( rs.getString( 6 ) );
		dto.setParticella( rs.getString( 7 ) );
		dto.setSubalterno( rs.getString( 8 ) );
		dto.setFlgSigmater( rs.getString( 9 ) );
		dto.setIdProv( rs.getString( 10 ) );
		dto.setDescProv( rs.getString( 11 ) );
		dto.setIdComune( rs.getString( 12 ) );
		dto.setDescComune( rs.getString( 13 ) );
		dto.setCodiceComuneCatastale( rs.getString( 14 ) );

		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_DATICATAST_SEC";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_DATICATAST_SEC = :idDaticatastSec'.
	 */
	public SiceeTDaticatastSec findByPrimaryKey(Integer idDaticatastSec) throws SiceeTDaticatastSecDaoException
	{
		try {
			List<SiceeTDaticatastSec> list = jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE ID_DATICATAST_SEC = ?", this,idDaticatastSec);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTDaticatastSec> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ORDER BY CODICE_COMUNE_CATASTALE ASC, SEZIONE ASC, FOGLIO ASC, PARTICELLA ASC, to_number(SUBALTERNO) ASC", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria ''.
	 */
	public List<SiceeTDaticatastSec> findAll() throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " ORDER BY ID_DATICATAST_SEC", this);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_DATICATAST_SEC = :idDaticatastSec'.
	 */
	public List<SiceeTDaticatastSec> findWhereIdDaticatastSecEquals(Integer idDaticatastSec) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE ID_DATICATAST_SEC = ? ORDER BY ID_DATICATAST_SEC", this,idDaticatastSec);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTDaticatastSec> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTDaticatastSec> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTDaticatastSec> findWhereAnnoEquals(String anno) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'SEZIONE = :sezione'.
	 */
	public List<SiceeTDaticatastSec> findWhereSezioneEquals(String sezione) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE SEZIONE = ? ORDER BY SEZIONE", this,sezione);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'FOGLIO = :foglio'.
	 */
	public List<SiceeTDaticatastSec> findWhereFoglioEquals(String foglio) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE FOGLIO = ? ORDER BY FOGLIO", this,foglio);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'PARTICELLA = :particella'.
	 */
	public List<SiceeTDaticatastSec> findWhereParticellaEquals(String particella) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE PARTICELLA = ? ORDER BY PARTICELLA", this,particella);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'SUBALTERNO = :subalterno'.
	 */
	public List<SiceeTDaticatastSec> findWhereSubalternoEquals(String subalterno) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE SUBALTERNO = ? ORDER BY SUBALTERNO", this,subalterno);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'FLG_SIGMATER = :flgSigmater'.
	 */
	public List<SiceeTDaticatastSec> findWhereFlgSigmaterEquals(String flgSigmater) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE FLG_SIGMATER = ? ORDER BY FLG_SIGMATER", this,flgSigmater);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_PROV = :idProv'.
	 */
	public List<SiceeTDaticatastSec> findWhereIdProvEquals(String idProv) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE ID_PROV = ? ORDER BY ID_PROV", this,idProv);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'DESC_PROV = :descProv'.
	 */
	public List<SiceeTDaticatastSec> findWhereDescProvEquals(String descProv) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE DESC_PROV = ? ORDER BY DESC_PROV", this,descProv);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	public List<SiceeTDaticatastSec> findWhereIdComuneEquals(String idComune) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	public List<SiceeTDaticatastSec> findWhereDescComuneEquals(String descComune) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE DESC_COMUNE = ? ORDER BY DESC_COMUNE", this,descComune);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATICATAST_SEC table that match the criteria 'CODICE_COMUNE_CATASTALE = :codiceComuneCatastale'.
	 */
	public List<SiceeTDaticatastSec> findWhereCodiceComuneCatastaleEquals(String codiceComuneCatastale) throws SiceeTDaticatastSecDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DATICATAST_SEC, ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, FLG_SIGMATER, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, CODICE_COMUNE_CATASTALE FROM " + getTableName() + " WHERE CODICE_COMUNE_CATASTALE = ? ORDER BY CODICE_COMUNE_CATASTALE", this,codiceComuneCatastale);
		}
		catch (Exception e) {
			throw new SiceeTDaticatastSecDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_T_DATICATAST_SEC table that matches the specified primary-key value.
	 */
	public SiceeTDaticatastSec findByPrimaryKey(SiceeTDaticatastSecPk pk) throws SiceeTDaticatastSecDaoException
	{
		return findByPrimaryKey( pk.getIdDaticatastSec() );
	}

}
