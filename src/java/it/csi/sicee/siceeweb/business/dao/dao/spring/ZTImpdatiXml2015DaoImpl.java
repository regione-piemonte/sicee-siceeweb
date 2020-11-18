/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImpdatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.ZTImpdatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.ZTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.ZTImpdatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImpdatiXml2015DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.ZTImpdatiXml2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.soap.providers.com.Log;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class ZTImpdatiXml2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<ZTImpdatiXml2015>, ZTImpdatiXml2015Dao
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
	

	/**
	 * Updates a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	
	public void update(ZTImpdatiXml2015Pk pk, ZTImpdatiXml2015 dto) throws ZTImpdatiXml2015DaoException
	{
		jdbcTemplate.update("BEGIN UPDATE " + getTableName() + " SET GRADI_GIORNO = ?, DT_SOPRALLUOGO = ?, SW_UTILIZZATO = ?, NUM_CERTIF_SW = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?; END;",dto.getGradiGiorno(),dto.getDtSopralluogo(),dto.getSwUtilizzato(),dto.getNumCertifSw(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTImpdatiXml2015
	 */
	public ZTImpdatiXml2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		ZTImpdatiXml2015 dto = new ZTImpdatiXml2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFXml( super.getClobColumn(rs, 4 ) );
		dto.setGradiGiorno( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setGradiGiorno( null );
		}
		
		dto.setDtSopralluogo( rs.getTimestamp(6 ) );

		dto.setSwUtilizzato( rs.getString( 7 ) );
		
		dto.setNumCertifSw( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setNumCertifSw( null );
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
		return "Z_T_IMPDATI_XML_2015_STORICO";
	}

	

	/** 
	 * Returns all rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria ''.
	 */
	
	public List<ZTImpdatiXml2015> findAll() throws ZTImpdatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, T.F_XML.getCLOBVal(), GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " T WHERE GRADI_GIORNO IS NULL AND rownum <= (SELECT VALORE FROM SICEE_T_PARAMETRI WHERE CODICE='NUMERO_MAX_ACE_TRATTAMENTO') ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ZTImpdatiXml2015DaoException("Query failed", e);
		}
		
	}


}
