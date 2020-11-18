/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXmlEdRif2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiXmlEdRif2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDatiXmlEdRif2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDatiXmlEdRif2015>, SiceeTDatiXmlEdRif2015Dao
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
	 * @return SiceeTDatiXmlEdRif2015Pk
	 */
	
	public SiceeTDatiXmlEdRif2015Pk insert(SiceeTDatiXmlEdRif2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getQh(),dto.getQc(),dto.getEphnd(),dto.getEpcnd(),dto.getEph(),dto.getEpc(),dto.getEpw(),dto.getEpv(),dto.getEpl(),dto.getEpglnr(),dto.getEpglr(),dto.getEpgltot(),dto.getEtah(),dto.getEtac(),dto.getEtaw());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	
	public void update(SiceeTDatiXmlEdRif2015Pk pk, SiceeTDatiXmlEdRif2015 dto) throws SiceeTDatiXmlEdRif2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, QH = ?, QC = ?, EPHND = ?, EPCND = ?, EPH = ?, EPC = ?, EPW = ?, EPV = ?, EPL = ?, EPGLNR = ?, EPGLR = ?, EPGLTOT = ?, ETAH = ?, ETAC = ?, ETAW = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getQh(),dto.getQc(),dto.getEphnd(),dto.getEpcnd(),dto.getEph(),dto.getEpc(),dto.getEpw(),dto.getEpv(),dto.getEpl(),dto.getEpglnr(),dto.getEpglr(),dto.getEpgltot(),dto.getEtah(),dto.getEtac(),dto.getEtaw(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	
	public void delete(SiceeTDatiXmlEdRif2015Pk pk) throws SiceeTDatiXmlEdRif2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdRif2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore,progrCertificato,anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDatiXmlEdRif2015
	 */
	public SiceeTDatiXmlEdRif2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDatiXmlEdRif2015 dto = new SiceeTDatiXmlEdRif2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setQh( new Double( rs.getDouble(4) ) );
		if (rs.wasNull()) {
			dto.setQh( null );
		}
		
		dto.setQc( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setQc( null );
		}
		
		dto.setEphnd( new Double( rs.getDouble(6) ) );
		if (rs.wasNull()) {
			dto.setEphnd( null );
		}
		
		dto.setEpcnd( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setEpcnd( null );
		}
		
		dto.setEph( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setEph( null );
		}
		
		dto.setEpc( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setEpc( null );
		}
		
		dto.setEpw( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setEpw( null );
		}
		
		dto.setEpv( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setEpv( null );
		}
		
		dto.setEpl( new Double( rs.getDouble(12) ) );
		if (rs.wasNull()) {
			dto.setEpl( null );
		}
		
		dto.setEpglnr( new Double( rs.getDouble(13) ) );
		if (rs.wasNull()) {
			dto.setEpglnr( null );
		}
		
		dto.setEpglr( new Double( rs.getDouble(14) ) );
		if (rs.wasNull()) {
			dto.setEpglr( null );
		}
		
		dto.setEpgltot( new Double( rs.getDouble(15) ) );
		if (rs.wasNull()) {
			dto.setEpgltot( null );
		}
		
		dto.setEtah( new Double( rs.getDouble(16) ) );
		if (rs.wasNull()) {
			dto.setEtah( null );
		}
		
		dto.setEtac( new Double( rs.getDouble(17) ) );
		if (rs.wasNull()) {
			dto.setEtac( null );
		}
		
		dto.setEtaw( new Double( rs.getDouble(18) ) );
		if (rs.wasNull()) {
			dto.setEtaw( null );
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
		return "SICEE_T_DATI_XML_ED_RIF_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTDatiXmlEdRif2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			List<SiceeTDatiXmlEdRif2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findAll() throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereAnnoEquals(String anno) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'QH = :qh'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereQhEquals(Double qh) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE QH = ? ORDER BY QH", this,qh);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'QC = :qc'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereQcEquals(Double qc) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE QC = ? ORDER BY QC", this,qc);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPHND = :ephnd'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEphndEquals(Double ephnd) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPHND = ? ORDER BY EPHND", this,ephnd);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPCND = :epcnd'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpcndEquals(Double epcnd) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPCND = ? ORDER BY EPCND", this,epcnd);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPH = :eph'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEphEquals(Double eph) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPH = ? ORDER BY EPH", this,eph);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPC = :epc'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpcEquals(Double epc) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPC = ? ORDER BY EPC", this,epc);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPW = :epw'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpwEquals(Double epw) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPW = ? ORDER BY EPW", this,epw);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPV = :epv'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpvEquals(Double epv) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPV = ? ORDER BY EPV", this,epv);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EP = :ep'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpEquals(Double ep) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EP = ? ORDER BY EP", this,ep);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPGLNR = :epglnr'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpglnrEquals(Double epglnr) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPGLNR = ? ORDER BY EPGLNR", this,epglnr);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPGLR = :epglr'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpglrEquals(Double epglr) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPGLR = ? ORDER BY EPGLR", this,epglr);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPGLTOT = :epgltot'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEpgltotEquals(Double epgltot) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE EPGLTOT = ? ORDER BY EPGLTOT", this,epgltot);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ETAH = :etah'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEtahEquals(Double etah) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE ETAH = ? ORDER BY ETAH", this,etah);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ETAC = :etac'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEtacEquals(Double etac) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE ETAC = ? ORDER BY ETAC", this,etac);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ETAW = :etaw'.
	 */
	
	public List<SiceeTDatiXmlEdRif2015> findWhereEtawEquals(Double etaw) throws SiceeTDatiXmlEdRif2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, QH, QC, EPHND, EPCND, EPH, EPC, EPW, EPV, EPL, EPGLNR, EPGLR, EPGLTOT, ETAH, ETAC, ETAW FROM " + getTableName() + " WHERE ETAW = ? ORDER BY ETAW", this,etaw);
		}
		catch (Exception e) {
			throw new SiceeTDatiXmlEdRif2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiXmlEdRif2015 findByPrimaryKey(SiceeTDatiXmlEdRif2015Pk pk) throws SiceeTDatiXmlEdRif2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
