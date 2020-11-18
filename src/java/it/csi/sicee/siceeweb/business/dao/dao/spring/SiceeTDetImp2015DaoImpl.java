/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDetImp2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDetImp2015DaoException;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDetImp2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDetImp2015>, SiceeTDetImp2015Dao
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
	 * @return SiceeTDetImp2015Pk
	 */
	
	public SiceeTDetImp2015Pk insert(SiceeTDetImp2015 dto)
	{
		dto.setIdDettaglioImp(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdDettaglioImp(),dto.getProgressivoDett(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getFkCombustibile(),dto.getAnno(),dto.getFkServEner(),dto.getTipoImpianto(),dto.getAnnoInstall(),dto.getPotenzaNominKw(),dto.isCodiceImpiantoCitNull()?null:dto.getCodiceImpiantoCit(),dto.getFkTipoImpianto());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DET_IMP_2015 table.
	 */
	
	public void update(SiceeTDetImp2015Pk pk, SiceeTDetImp2015 dto) throws SiceeTDetImp2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DETTAGLIO_IMP = ?, PROGRESSIVO_DETT = ?, ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, FK_COMBUSTIBILE = ?, ANNO = ?, FK_SERV_ENER = ?, TIPO_IMPIANTO = ?, ANNO_INSTALL = ?, POTENZA_NOMIN_KW = ?, CODICE_IMPIANTO_CIT = ?, FK_TIPO_IMPIANTO = ? WHERE ID_DETTAGLIO_IMP = ?",dto.getIdDettaglioImp(),dto.getProgressivoDett(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getFkCombustibile(),dto.getAnno(),dto.getFkServEner(),dto.getTipoImpianto(),dto.getAnnoInstall(),dto.getPotenzaNominKw(),dto.getCodiceImpiantoCit(),dto.getFkTipoImpianto(),pk.getIdDettaglioImp());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DET_IMP_2015 table.
	 */
	
	public void delete(SiceeTDetImp2015Pk pk) throws SiceeTDetImp2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DETTAGLIO_IMP = ?",pk.getIdDettaglioImp());
	}

	/** 
	 * Deletes in the SICEE_T_DET_IMP_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDetImp2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDetImp2015
	 */
	public SiceeTDetImp2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDetImp2015 dto = new SiceeTDetImp2015();
		dto.setIdDettaglioImp( rs.getLong( 1 ) );
		dto.setProgressivoDett( new Integer( rs.getInt(2) ) );
		if (rs.wasNull()) {
			dto.setProgressivoDett( null );
		}
		
		dto.setIdCertificatore( rs.getString( 3 ) );
		dto.setProgrCertificato( rs.getString( 4 ) );
		dto.setFkCombustibile( new Integer( rs.getInt(5) ) );
		dto.setAnno( rs.getString( 6 ) );
		dto.setFkServEner( new Integer( rs.getInt(7) ) );
		dto.setTipoImpianto( rs.getString( 8 ) );
		dto.setAnnoInstall( new Integer( rs.getInt(9) ) );
		if (rs.wasNull()) {
			dto.setAnnoInstall( null );
		}
		
		dto.setPotenzaNominKw( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setPotenzaNominKw( null );
		}
		
		dto.setCodiceImpiantoCit( new Integer(rs.getInt( 11 ) ) );
		if (rs.wasNull()) {
			dto.setCodiceImpiantoCitNull( true );
		}
		dto.setFkTipoImpianto( new Integer( rs.getInt(12) ) );
		if (rs.wasNull()) {
			dto.setFkTipoImpianto( null );
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
		return "SICEE_T_DET_IMP_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_DETTAGLIO_IMP = :idDettaglioImp'.
	 */
	
	public SiceeTDetImp2015 findByPrimaryKey(long idDettaglioImp) throws SiceeTDetImp2015DaoException
	{
		try {
			List<SiceeTDetImp2015> list = jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE ID_DETTAGLIO_IMP = ?", this,idDettaglioImp);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTDetImp2015> findAll() throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " ORDER BY ID_DETTAGLIO_IMP", this);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'FK_SERV_ENER = :fkServEner'.
	 */
	
	public List<SiceeTDetImp2015> findBySiceeDServEner2015(Integer fkServEner) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE FK_SERV_ENER = ?", this,fkServEner);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_DETTAGLIO_IMP = :idDettaglioImp'.
	 */
	
	public List<SiceeTDetImp2015> findWhereIdDettaglioImpEquals(long idDettaglioImp) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE ID_DETTAGLIO_IMP = ? ORDER BY ID_DETTAGLIO_IMP", this,idDettaglioImp);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'PROGRESSIVO_DETT = :progressivoDett'.
	 */
	
	public List<SiceeTDetImp2015> findWhereProgressivoDettEquals(Integer progressivoDett) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE PROGRESSIVO_DETT = ? ORDER BY PROGRESSIVO_DETT", this,progressivoDett);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDetImp2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTDetImp2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'FK_COMBUSTIBILE = :fkCombustibile'.
	 */
	
	public List<SiceeTDetImp2015> findWhereFkCombustibileEquals(Integer fkCombustibile) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE FK_COMBUSTIBILE = ? ORDER BY FK_COMBUSTIBILE", this,fkCombustibile);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTDetImp2015> findWhereAnnoEquals(String anno) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'FK_SERV_ENER = :fkServEner'.
	 */
	
	public List<SiceeTDetImp2015> findWhereFkServEnerEquals(Integer fkServEner) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE FK_SERV_ENER = ? ORDER BY FK_SERV_ENER", this,fkServEner);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'TIPO_IMPIANTO = :tipoImpianto'.
	 */
	
	public List<SiceeTDetImp2015> findWhereTipoImpiantoEquals(String tipoImpianto) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE TIPO_IMPIANTO = ? ORDER BY TIPO_IMPIANTO", this,tipoImpianto);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ANNO_INSTALL = :annoInstall'.
	 */
	
	public List<SiceeTDetImp2015> findWhereAnnoInstallEquals(Integer annoInstall) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE ANNO_INSTALL = ? ORDER BY ANNO_INSTALL", this,annoInstall);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'POTENZA_NOMIN_KW = :potenzaNominKw'.
	 */
	
	public List<SiceeTDetImp2015> findWherePotenzaNominKwEquals(Double potenzaNominKw) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE POTENZA_NOMIN_KW = ? ORDER BY POTENZA_NOMIN_KW", this,potenzaNominKw);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'EFFICIENZA = :efficienza'.
	 */
	
	public List<SiceeTDetImp2015> findWhereEfficienzaEquals(Double efficienza) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE EFFICIENZA = ? ORDER BY EFFICIENZA", this,efficienza);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'CODICE_IMPIANTO_CIT = :codiceImpiantoCit'.
	 */
	
	public List<SiceeTDetImp2015> findWhereCodiceImpiantoCitEquals(long codiceImpiantoCit) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE CODICE_IMPIANTO_CIT = ? ORDER BY CODICE_IMPIANTO_CIT", this,codiceImpiantoCit);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'EPREN = :epren'.
	 */
	
	public List<SiceeTDetImp2015> findWhereEprenEquals(Double epren) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE EPREN = ? ORDER BY EPREN", this,epren);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'EPNREN = :epnren'.
	 */
	
	public List<SiceeTDetImp2015> findWhereEpnrenEquals(Double epnren) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE EPNREN = ? ORDER BY EPNREN", this,epnren);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTDetImp2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDetImp2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DETTAGLIO_IMP, PROGRESSIVO_DETT, ID_CERTIFICATORE, PROGR_CERTIFICATO, FK_COMBUSTIBILE, ANNO, FK_SERV_ENER, TIPO_IMPIANTO, ANNO_INSTALL, POTENZA_NOMIN_KW, CODICE_IMPIANTO_CIT, FK_TIPO_IMPIANTO  FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ORDER BY FK_SERV_ENER", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTDetImp2015DaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_T_DET_IMP_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDetImp2015 findByPrimaryKey(SiceeTDetImp2015Pk pk) throws SiceeTDetImp2015DaoException
	{
		return findByPrimaryKey( pk.getIdDettaglioImp() );
	}

}
