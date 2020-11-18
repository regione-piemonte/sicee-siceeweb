/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumentoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocumentoDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;


public class SiceeTDocumentoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDocumento>, SiceeTDocumentoDao
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

	// Ritorno l'id documento con un metodo specifico perchè mi serve per creare il nome del file
	
	public int createIdDocumento()
	{
		return incrementer.nextIntValue();
	}
	
	
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDocumentoPk
	 */
	
	public SiceeTDocumentoPk insert(SiceeTDocumento dto)
	{
		//dto.setIdDocumento(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO ) VALUES ( ?, ?, ?, ?, ?, ?, ? )",dto.getIdDocumento(),dto.getIdCertificatore(),dto.getIdTipoDoc(),dto.getIdentificDoc(),dto.getDtUpload(),dto.getNomeFile(),dto.getFkCorso());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DOCUMENTO table.
	 */
	
	public void update(SiceeTDocumentoPk pk, SiceeTDocumento dto) throws SiceeTDocumentoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DOCUMENTO = ?, ID_CERTIFICATORE = ?, ID_TIPO_DOC = ?, IDENTIFIC_DOC = ?, DT_UPLOAD = ?, NOME_FILE = ?, FK_CORSO = ? WHERE ID_DOCUMENTO = ?",dto.getIdDocumento(),dto.getIdCertificatore(),dto.getIdTipoDoc(),dto.getIdentificDoc(),dto.getDtUpload(),dto.getNomeFile(),dto.getFkCorso(),pk.getIdDocumento());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DOCUMENTO table.
	 */
	
	public void delete(SiceeTDocumentoPk pk) throws SiceeTDocumentoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DOCUMENTO = ?",pk.getIdDocumento());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDocumento
	 */
	public SiceeTDocumento mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDocumento dto = new SiceeTDocumento();
		dto.setIdDocumento( new Integer( rs.getInt(1) ) );
		dto.setIdCertificatore( rs.getString( 2 ) );
		dto.setIdTipoDoc( new Integer( rs.getInt(3) ) );
		dto.setIdentificDoc( rs.getString( 4 ) );
		dto.setDtUpload( rs.getTimestamp(5 ) );
		dto.setNomeFile( rs.getString( 6 ) );
		dto.setFkCorso( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setFkCorso(null);
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
		return "SICEE_T_DOCUMENTO";
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_DOCUMENTO = :idDocumento'.
	 */
	
	public SiceeTDocumento findByPrimaryKey(Integer idDocumento) throws SiceeTDocumentoDaoException
	{
		try {
			List<SiceeTDocumento> list = jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_DOCUMENTO = ?", this,idDocumento);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND ID_TIPO_DOC = :idTipoDoc'.
	 */
	
	public SiceeTDocumento findWhereIdCertificatoreAndIdTipoDocEquals(String idCertificatore, Integer idTipoDoc) throws SiceeTDocumentoDaoException
	{
		try {
			List<SiceeTDocumento> list = jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND ID_TIPO_DOC = ?", this,idCertificatore,idTipoDoc);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FK_CORSO = :fkCorso'.
	 */
	
	public SiceeTDocumento findWhereIdCertificatoreAndFkCorsoEquals(String idCertificatore, Integer fkCorso) throws SiceeTDocumentoDaoException
	{
		try {
			List<SiceeTDocumento> list = jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND FK_CORSO = ?", this,idCertificatore,fkCorso);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FK_CORSO IS NULL AND ID_TIPO_DOC = 6'.
	 */
	
	public List<SiceeTDocumento> findTitoloDiStudio(String idCertificatore) throws SiceeTDocumentoDaoException
	{
		try {
			List<SiceeTDocumento> list = jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND FK_CORSO IS NULL AND ID_TIPO_DOC = 6", this,idCertificatore);
			return list;
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FK_CORSO IS NULL AND (ID_TIPO_DOC = 2 OR ID_TIPO_DOC = 3 OR ID_TIPO_DOC = 4)'.
	 */
	
	public List<SiceeTDocumento> findAttPartOld(String idCertificatore) throws SiceeTDocumentoDaoException
	{
		try {
			List<SiceeTDocumento> list = jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND FK_CORSO IS NULL AND (ID_TIPO_DOC = 2 OR ID_TIPO_DOC = 3 OR ID_TIPO_DOC = 4)", this,idCertificatore);
			return list;
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria ''.
	 */
	
	public List<SiceeTDocumento> findAll() throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " ORDER BY ID_DOCUMENTO", this);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	
	public List<SiceeTDocumento> findBySiceeDTipoDocumento(Integer idTipoDoc) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_TIPO_DOC = ?", this,idTipoDoc);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDocumento> findBySiceeTCertificatore(String idCertificatore) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ?", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_DOCUMENTO = :idDocumento'.
	 */
	
	public List<SiceeTDocumento> findWhereIdDocumentoEquals(Integer idDocumento) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_DOCUMENTO = ? ORDER BY ID_DOCUMENTO", this,idDocumento);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDocumento> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	
	public List<SiceeTDocumento> findWhereIdTipoDocEquals(Integer idTipoDoc) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE ID_TIPO_DOC = ? ORDER BY ID_TIPO_DOC", this,idTipoDoc);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'IDENTIFIC_DOC = :identificDoc'.
	 */
	
	public List<SiceeTDocumento> findWhereIdentificDocEquals(String identificDoc) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE IDENTIFIC_DOC = ? ORDER BY IDENTIFIC_DOC", this,identificDoc);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'DT_UPLOAD = :dtUpload'.
	 */
	
	public List<SiceeTDocumento> findWhereDtUploadEquals(Date dtUpload) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE DT_UPLOAD = ? ORDER BY DT_UPLOAD", this,dtUpload);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DOCUMENTO table that match the criteria 'NOME_FILE = :nomeFile'.
	 */
	
	public List<SiceeTDocumento> findWhereNomeFileEquals(String nomeFile) throws SiceeTDocumentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DOCUMENTO, ID_CERTIFICATORE, ID_TIPO_DOC, IDENTIFIC_DOC, DT_UPLOAD, NOME_FILE, FK_CORSO FROM " + getTableName() + " WHERE NOME_FILE = ? ORDER BY NOME_FILE", this,nomeFile);
		}
		catch (Exception e) {
			throw new SiceeTDocumentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DOCUMENTO table that matches the specified primary-key value.
	 */
	public SiceeTDocumento findByPrimaryKey(SiceeTDocumentoPk pk) throws SiceeTDocumentoDaoException
	{
		return findByPrimaryKey( pk.getIdDocumento() );
	}

}
