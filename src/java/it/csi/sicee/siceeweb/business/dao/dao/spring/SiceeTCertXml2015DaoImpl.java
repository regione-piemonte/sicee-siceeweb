/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertXml2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTCertXml2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTCertXml2015>, SiceeTCertXml2015Dao
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
	 * @return SiceeTCertXml2015Pk
	 */
	
	public SiceeTCertXml2015Pk insert(SiceeTCertXml2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA ) VALUES ( ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getXmlAllegato(),dto.getFlgControlloBozza());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_CERT_XML_2015 table.
	 */
	
	public void update(SiceeTCertXml2015Pk pk, SiceeTCertXml2015 dto) throws SiceeTCertXml2015DaoException
	{
		//jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, XML_ALLEGATO = EMPTY_CLOB(), FLG_CONTROLLO_BOZZA = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getXmlAllegato(),dto.getFlgControlloBozza(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, XML_ALLEGATO = ?, FLG_CONTROLLO_BOZZA = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getXmlAllegato(),dto.getFlgControlloBozza(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_CERT_XML_2015 table.
	 */
	
	public void delete(SiceeTCertXml2015Pk pk) throws SiceeTCertXml2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTCertXml2015
	 */
	public SiceeTCertXml2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTCertXml2015 dto = new SiceeTCertXml2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setXmlAllegato( super.getClobColumn(rs, 4 ) );
		dto.setFlgControlloBozza( rs.getString( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_CERT_XML_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTCertXml2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTCertXml2015DaoException
	{
		try {
			List<SiceeTCertXml2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTCertXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTCertXml2015> findAll() throws SiceeTCertXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTCertXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTCertXml2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTCertXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCertXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTCertXml2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTCertXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTCertXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTCertXml2015> findWhereAnnoEquals(String anno) throws SiceeTCertXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTCertXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'XML_ALLEGATO = :xmlAllegato'.
	 */
	
	public List<SiceeTCertXml2015> findWhereXmlAllegatoEquals(String xmlAllegato) throws SiceeTCertXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA FROM " + getTableName() + " WHERE XML_ALLEGATO = ? ORDER BY XML_ALLEGATO", this,xmlAllegato);
		}
		catch (Exception e) {
			throw new SiceeTCertXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'FLG_CONTROLLO_BOZZA = :flgControlloBozza'.
	 */
	
	public List<SiceeTCertXml2015> findWhereFlgControlloBozzaEquals(String flgControlloBozza) throws SiceeTCertXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, XML_ALLEGATO, FLG_CONTROLLO_BOZZA FROM " + getTableName() + " WHERE FLG_CONTROLLO_BOZZA = ? ORDER BY FLG_CONTROLLO_BOZZA", this,flgControlloBozza);
		}
		catch (Exception e) {
			throw new SiceeTCertXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_CERT_XML_2015 table that matches the specified primary-key value.
	 */
	public SiceeTCertXml2015 findByPrimaryKey(SiceeTCertXml2015Pk pk) throws SiceeTCertXml2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
