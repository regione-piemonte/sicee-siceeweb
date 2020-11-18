/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImpdatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImpdatiXml2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTImpdatiXml2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTImpdatiXml2015>, SiceeTImpdatiXml2015Dao
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
	 * @return SiceeTImpdatiXml2015Pk
	 */
	
	public SiceeTImpdatiXml2015Pk insert(SiceeTImpdatiXml2015 dto)
	{
		jdbcTemplate.update("BEGIN INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, F_XML ) VALUES ( ?, ?, ?, XMLPARSE(DOCUMENT ? WELLFORMED) ); END;",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFXml());
		return dto.createPk();
	}

	/**
	 * Updates a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	
	public void update(SiceeTImpdatiXml2015Pk pk, SiceeTImpdatiXml2015 dto) throws SiceeTImpdatiXml2015DaoException
	{
		jdbcTemplate.update("BEGIN UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, F_XML = XMLPARSE(DOCUMENT ? WELLFORMED) WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?; END;",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFXml(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	
	public void delete(SiceeTImpdatiXml2015Pk pk) throws SiceeTImpdatiXml2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpdatiXml2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore,progrCertificato,anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTImpdatiXml2015
	 */
	public SiceeTImpdatiXml2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTImpdatiXml2015 dto = new SiceeTImpdatiXml2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFXml( super.getClobColumn(rs, 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_IMPDATI_XML_2015";
	}

	/** 
	 * Returns the number of rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public int countByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpdatiXml2015DaoException
	{
		try {
			int ccount = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM " + getTableName() + " T WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", idCertificatore, progrCertificato, anno);
			return ccount;
		}
		catch (Exception e) {
			throw new SiceeTImpdatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTImpdatiXml2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpdatiXml2015DaoException
	{
		try {
			List<SiceeTImpdatiXml2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, T.F_XML.getCLOBVal() FROM " + getTableName() + " T WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTImpdatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTImpdatiXml2015> findAll() throws SiceeTImpdatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, T.F_XML.getCLOBVal() FROM " + getTableName() + " T ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTImpdatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_IMPDATI_XML_2015 table that matches the specified primary-key value.
	 */
	public SiceeTImpdatiXml2015 findByPrimaryKey(SiceeTImpdatiXml2015Pk pk) throws SiceeTImpdatiXml2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
