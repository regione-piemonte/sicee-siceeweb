/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXmlEdReale2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiXmlEdReale2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDatiXmlEdReale2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDatiXmlEdReale2015>, SiceeTDatiXmlEdReale2015Dao
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
	 * @return SiceeTDatiXmlEdReale2015Pk
	 */
	
	public SiceeTDatiXmlEdReale2015Pk insert(SiceeTDatiXmlEdReale2015 dto)
	{
		
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFabbRiscInvolucroExtraFlus(),dto.getFabbRiscInvolucroTrasmissio(),dto.getFabbRiscInvolucroVentilazio(),dto.getFabbRiscInvolucroApportiSo(),dto.getFabbRiscInvolucroApportiIn(),dto.getFabbRiscInvolucroApportiLa(),dto.getFabbRiscInvolucroQhnd(),dto.getFabbRiscInvolucroQlr(),dto.getFabbRiscInvolucroQhimp(),dto.getFabbRiscImpiantoEtar(),dto.getFabbRiscImpiantoEtad(),dto.getFabbRiscImpiantoEtae(),dto.getFabbRiscImpiantoEtag());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	
	public void update(SiceeTDatiXmlEdReale2015Pk pk, SiceeTDatiXmlEdReale2015 dto) throws SiceeTDatiXmlEdReale2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FABB_RISC_INVOLUCRO_EXTRA_FLUS = ?, FABB_RISC_INVOLUCRO_TRASMISSIO = ?, FABB_RISC_INVOLUCRO_VENTILAZIO = ?, FABB_RISC_INVOLUCRO_APPORTI_SO = ?, FABB_RISC_INVOLUCRO_APPORTI_IN = ?, FABB_RISC_INVOLUCRO_APPORTI_LA = ?, FABB_RISC_INVOLUCRO_QHND = ?, FABB_RISC_INVOLUCRO_QLR = ?, FABB_RISC_INVOLUCRO_QHIMP = ?, FABB_RISC_IMPIANTO_ETAR = ?, FABB_RISC_IMPIANTO_ETAD = ?, FABB_RISC_IMPIANTO_ETAE = ?, FABB_RISC_IMPIANTO_ETAG = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFabbRiscInvolucroExtraFlus(),dto.getFabbRiscInvolucroTrasmissio(),dto.getFabbRiscInvolucroVentilazio(),dto.getFabbRiscInvolucroApportiSo(),dto.getFabbRiscInvolucroApportiIn(),dto.getFabbRiscInvolucroApportiLa(),dto.getFabbRiscInvolucroQhnd(),dto.getFabbRiscInvolucroQlr(),dto.getFabbRiscInvolucroQhimp(),dto.getFabbRiscImpiantoEtar(),dto.getFabbRiscImpiantoEtad(),dto.getFabbRiscImpiantoEtae(),dto.getFabbRiscImpiantoEtag(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	
	public void delete(SiceeTDatiXmlEdReale2015Pk pk) throws SiceeTDatiXmlEdReale2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdReale2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore,progrCertificato,anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDatiXmlEdReale2015
	 */
	public SiceeTDatiXmlEdReale2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDatiXmlEdReale2015 dto = new SiceeTDatiXmlEdReale2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFabbRiscInvolucroExtraFlus( new Double( rs.getDouble(4) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroExtraFlus( null );
		}
		
		dto.setFabbRiscInvolucroTrasmissio( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroTrasmissio( null );
		}
		
		dto.setFabbRiscInvolucroVentilazio( new Double( rs.getDouble(6) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroVentilazio( null );
		}
		
		dto.setFabbRiscInvolucroApportiSo( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroApportiSo( null );
		}
		
		dto.setFabbRiscInvolucroApportiIn( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroApportiIn( null );
		}
		
		dto.setFabbRiscInvolucroApportiLa( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroApportiLa( null );
		}
		
		dto.setFabbRiscInvolucroQhnd( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroQhnd( null );
		}
		
		dto.setFabbRiscInvolucroQlr( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroQlr( null );
		}
		
		dto.setFabbRiscInvolucroQhimp( new Double( rs.getDouble(12) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscInvolucroQhimp( null );
		}
		
		dto.setFabbRiscImpiantoEtar( new Double( rs.getDouble(13) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscImpiantoEtar( null );
		}
		
		dto.setFabbRiscImpiantoEtad( new Double( rs.getDouble(14) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscImpiantoEtad( null );
		}
		
		dto.setFabbRiscImpiantoEtae( new Double( rs.getDouble(15) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscImpiantoEtae( null );
		}
		
		dto.setFabbRiscImpiantoEtag( new Double( rs.getDouble(16) ) );
		if (rs.wasNull()) {
			dto.setFabbRiscImpiantoEtag( null );
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
		return "SICEE_T_DATI_XML_ED_REALE_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTDatiXmlEdReale2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			List<SiceeTDatiXmlEdReale2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findAll() throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereAnnoEquals(String anno) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_EXTRA_FLUS = :fabbRiscInvolucroExtraFlus'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroExtraFlusEquals(Double fabbRiscInvolucroExtraFlus) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_EXTRA_FLUS = ? ORDER BY FABB_RISC_INVOLUCRO_EXTRA_FLUS", this,fabbRiscInvolucroExtraFlus);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_TRASMISSIO = :fabbRiscInvolucroTrasmissio'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroTrasmissioEquals(Double fabbRiscInvolucroTrasmissio) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_TRASMISSIO = ? ORDER BY FABB_RISC_INVOLUCRO_TRASMISSIO", this,fabbRiscInvolucroTrasmissio);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_VENTILAZIO = :fabbRiscInvolucroVentilazio'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroVentilazioEquals(Double fabbRiscInvolucroVentilazio) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_VENTILAZIO = ? ORDER BY FABB_RISC_INVOLUCRO_VENTILAZIO", this,fabbRiscInvolucroVentilazio);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_APPORTI_SO = :fabbRiscInvolucroApportiSo'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroApportiSoEquals(Double fabbRiscInvolucroApportiSo) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_APPORTI_SO = ? ORDER BY FABB_RISC_INVOLUCRO_APPORTI_SO", this,fabbRiscInvolucroApportiSo);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_APPORTI_IN = :fabbRiscInvolucroApportiIn'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroApportiInEquals(Double fabbRiscInvolucroApportiIn) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_APPORTI_IN = ? ORDER BY FABB_RISC_INVOLUCRO_APPORTI_IN", this,fabbRiscInvolucroApportiIn);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_APPORTI_LA = :fabbRiscInvolucroApportiLa'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroApportiLaEquals(Double fabbRiscInvolucroApportiLa) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_APPORTI_LA = ? ORDER BY FABB_RISC_INVOLUCRO_APPORTI_LA", this,fabbRiscInvolucroApportiLa);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_QHND = :fabbRiscInvolucroQhnd'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroQhndEquals(Double fabbRiscInvolucroQhnd) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_QHND = ? ORDER BY FABB_RISC_INVOLUCRO_QHND", this,fabbRiscInvolucroQhnd);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_QLR = :fabbRiscInvolucroQlr'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroQlrEquals(Double fabbRiscInvolucroQlr) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_QLR = ? ORDER BY FABB_RISC_INVOLUCRO_QLR", this,fabbRiscInvolucroQlr);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_QHIMP = :fabbRiscInvolucroQhimp'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroQhimpEquals(Double fabbRiscInvolucroQhimp) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_INVOLUCRO_QHIMP = ? ORDER BY FABB_RISC_INVOLUCRO_QHIMP", this,fabbRiscInvolucroQhimp);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAR = :fabbRiscImpiantoEtar'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtarEquals(Double fabbRiscImpiantoEtar) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_IMPIANTO_ETAR = ? ORDER BY FABB_RISC_IMPIANTO_ETAR", this,fabbRiscImpiantoEtar);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAD = :fabbRiscImpiantoEtad'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtadEquals(Double fabbRiscImpiantoEtad) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_IMPIANTO_ETAD = ? ORDER BY FABB_RISC_IMPIANTO_ETAD", this,fabbRiscImpiantoEtad);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAE = :fabbRiscImpiantoEtae'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtaeEquals(Double fabbRiscImpiantoEtae) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_IMPIANTO_ETAE = ? ORDER BY FABB_RISC_IMPIANTO_ETAE", this,fabbRiscImpiantoEtae);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAG = :fabbRiscImpiantoEtag'.
	 */
	
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtagEquals(Double fabbRiscImpiantoEtag) throws SiceeTDatiXmlEdReale2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FABB_RISC_INVOLUCRO_EXTRA_FLUS, FABB_RISC_INVOLUCRO_TRASMISSIO, FABB_RISC_INVOLUCRO_VENTILAZIO, FABB_RISC_INVOLUCRO_APPORTI_SO, FABB_RISC_INVOLUCRO_APPORTI_IN, FABB_RISC_INVOLUCRO_APPORTI_LA, FABB_RISC_INVOLUCRO_QHND, FABB_RISC_INVOLUCRO_QLR, FABB_RISC_INVOLUCRO_QHIMP, FABB_RISC_IMPIANTO_ETAR, FABB_RISC_IMPIANTO_ETAD, FABB_RISC_IMPIANTO_ETAE, FABB_RISC_IMPIANTO_ETAG FROM " + getTableName() + " WHERE FABB_RISC_IMPIANTO_ETAG = ? ORDER BY FABB_RISC_IMPIANTO_ETAG", this,fabbRiscImpiantoEtag);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdReale2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiXmlEdReale2015 findByPrimaryKey(SiceeTDatiXmlEdReale2015Pk pk) throws SiceeTDatiXmlEdReale2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
