/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazione2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazione2018DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTTransazione2018DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTTransazione2018>, SiceeTTransazione2018Dao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	protected DataFieldMaxValueIncrementer incrementerSostituzioneProgr;
	   
	public void setIncrementerSostituzioneProgr(DataFieldMaxValueIncrementer incrementer) {
		this.incrementerSostituzioneProgr = incrementer;
	}
	
	public int getNextValueSostituzioneProgr() {
		return this.incrementerSostituzioneProgr.nextIntValue();
	}

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
	 * @return SiceeTTransazione2018Pk
	 */
	
	public SiceeTTransazione2018Pk insert(SiceeTTransazione2018 dto)
	{
		dto.setIdTransazione2018(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdTransazione2018(),dto.getFkCertificatore(),dto.getFkStatoTrans2018(),dto.getXmlRt(),dto.getS1ValoreTransazione(),dto.getS1TipoIdVersante(),dto.getS1CodIdVersante(),dto.getS1AnagraficaVersante(),dto.getS1IdTransazioneMdp(),dto.getS1DtCreazioneTransazione(),dto.isS2IdInformativaPspNull()?null:dto.getS2IdInformativaPsp(),dto.getS2IdentificativoPsp(),dto.getS2RagSocialePsp(),dto.getS2DescrServizioPsp(),dto.getS3IdIuv(),dto.getS3DtAvvioTransazione(),dto.getDtChiusuraTransazione(),dto.getOpGetstatotransFkStato(),dto.getOpGetstatotransDt());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	
	public void update(SiceeTTransazione2018Pk pk, SiceeTTransazione2018 dto) throws SiceeTTransazione2018DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TRANSAZIONE_2018 = ?, FK_CERTIFICATORE = ?, FK_STATO_TRANS_2018 = ?, XML_RT = ?, S1_VALORE_TRANSAZIONE = ?, S1_TIPO_ID_VERSANTE = ?, S1_COD_ID_VERSANTE = ?, S1_ANAGRAFICA_VERSANTE = ?, S1_ID_TRANSAZIONE_MDP = ?, S1_DT_CREAZIONE_TRANSAZIONE = ?, S2_ID_INFORMATIVA_PSP = ?, S2_IDENTIFICATIVO_PSP = ?, S2_RAG_SOCIALE_PSP = ?, S2_DESCR_SERVIZIO_PSP = ?, S3_ID_IUV = ?, S3_DT_AVVIO_TRANSAZIONE = ?, DT_CHIUSURA_TRANSAZIONE = ?, OP_GETSTATOTRANS_FK_STATO = ?, OP_GETSTATOTRANS_DT = ? WHERE ID_TRANSAZIONE_2018 = ?",dto.getIdTransazione2018(),dto.getFkCertificatore(),dto.getFkStatoTrans2018(),dto.getXmlRt(),dto.getS1ValoreTransazione(),dto.getS1TipoIdVersante(),dto.getS1CodIdVersante(),dto.getS1AnagraficaVersante(),dto.getS1IdTransazioneMdp(),dto.getS1DtCreazioneTransazione(),dto.getS2IdInformativaPsp(),dto.getS2IdentificativoPsp(),dto.getS2RagSocialePsp(),dto.getS2DescrServizioPsp(),dto.getS3IdIuv(),dto.getS3DtAvvioTransazione(),dto.getDtChiusuraTransazione(),dto.getOpGetstatotransFkStato(),dto.getOpGetstatotransDt(),pk.getIdTransazione2018());
	}

	/** 
	 * Deletes a single row in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	
	public void delete(SiceeTTransazione2018Pk pk) throws SiceeTTransazione2018DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TRANSAZIONE_2018 = ?",pk.getIdTransazione2018());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTTransazione2018
	 */
	public SiceeTTransazione2018 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTTransazione2018 dto = new SiceeTTransazione2018();
		dto.setIdTransazione2018( rs.getInt( 1 ) );
		dto.setFkCertificatore( rs.getString( 2 ) );
		dto.setFkStatoTrans2018( new Integer( rs.getInt(3) ) );
		dto.setXmlRt( super.getClobColumn(rs, 4 ) );

		dto.setS1ValoreTransazione( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setS1ValoreTransazione( null );
		}

		dto.setS1TipoIdVersante( rs.getString( 6 ) );
		dto.setS1CodIdVersante( rs.getString( 7 ) );
		dto.setS1AnagraficaVersante( rs.getString( 8 ) );
		dto.setS1IdTransazioneMdp( rs.getString( 9 ) );
		dto.setS1DtCreazioneTransazione( rs.getTimestamp(10 ) );
		dto.setS2IdInformativaPsp( rs.getLong( 11 ) );
		if (rs.wasNull()) {
			dto.setS2IdInformativaPspNull( true );
		}
		
		dto.setS2IdentificativoPsp( rs.getString( 12 ) );
		dto.setS2RagSocialePsp( rs.getString( 13 ) );
		dto.setS2DescrServizioPsp( rs.getString( 14 ) );
		dto.setS3IdIuv( rs.getString( 15 ) );
		
		dto.setS3DtAvvioTransazione( rs.getTimestamp(16 ) );
		dto.setDtChiusuraTransazione( rs.getTimestamp(17 ) );
		dto.setOpGetstatotransFkStato( new Integer( rs.getInt(18) ) );
		if (rs.wasNull()) {
			dto.setOpGetstatotransFkStato( null );
		}
		
		dto.setOpGetstatotransDt( rs.getTimestamp(19 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_TRANSAZIONE_2018";
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_TRANSAZIONE_2018 = :idTransazione2018'.
	 */
	
	public SiceeTTransazione2018 findByPrimaryKey(long idTransazione2018) throws SiceeTTransazione2018DaoException
	{
		try {
			List<SiceeTTransazione2018> list = jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE ID_TRANSAZIONE_2018 = ?", this,idTransazione2018);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'VALORE_TRANSAZIONE = :valoreTransazione'.
	 */
	
	public List<SiceeTTransazione2018> findWhereValoreTransazioneEquals(long valoreTransazione) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE VALORE_TRANSAZIONE = ? ORDER BY VALORE_TRANSAZIONE", this,valoreTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'XML_RPT = :xmlRpt'.
	 */
	
	public List<SiceeTTransazione2018> findWhereXmlRptEquals(String xmlRpt) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE XML_RPT = ? ORDER BY XML_RPT", this,xmlRpt);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'DATA_RPT = :dataRpt'.
	 */
	
	public List<SiceeTTransazione2018> findWhereDataRptEquals(Date dataRpt) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE DATA_RPT = ? ORDER BY DATA_RPT", this,dataRpt);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'DATA_RT = :dataRt'.
	 */
	
	public List<SiceeTTransazione2018> findWhereDataRtEquals(Date dataRt) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE DATA_RT = ? ORDER BY DATA_RT", this,dataRt);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_TRANSAZIONE_MDP = :idTransazioneMdp'.
	 */
	
	public List<SiceeTTransazione2018> findWhereIdTransazioneMdpEquals(String idTransazioneMdp) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S1_ID_TRANSAZIONE_MDP = ? ORDER BY S1_ID_TRANSAZIONE_MDP", this,idTransazioneMdp);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_IUV = :idIuv'.
	 */
	
	public List<SiceeTTransazione2018> findWhereIdIuvEquals(String idIuv) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE ID_IUV = ? ORDER BY ID_IUV", this,idIuv);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria ''.
	 */
	
	public List<SiceeTTransazione2018> findAll() throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T ORDER BY ID_TRANSAZIONE_2018", this);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'OP_GETSTATOTRANS_FK_STATO = :opGetstatotransFkStato'.
	 */
	
	public List<SiceeTTransazione2018> findBySiceeDStatoTransMdp2018(Integer opGetstatotransFkStato) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE OP_GETSTATOTRANS_FK_STATO = ?", this,opGetstatotransFkStato);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_STATO_TRANS_2018 = :fkStatoTrans2018'.
	 */
	
	public List<SiceeTTransazione2018> findBySiceeDStatoTrans2018(Integer fkStatoTrans2018) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE FK_STATO_TRANS_2018 = ?", this,fkStatoTrans2018);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'ID_TRANSAZIONE_2018 = :idTransazione2018'.
	 */
	
	public List<SiceeTTransazione2018> findWhereIdTransazione2018Equals(long idTransazione2018) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE ID_TRANSAZIONE_2018 = ? ORDER BY ID_TRANSAZIONE_2018", this,idTransazione2018);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTTransazione2018> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE FK_CERTIFICATORE = ? ORDER BY FK_CERTIFICATORE", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore' and 'FK_STATO_TRANS_2018 = :fkStatoTrans2018'.
	 */
	// Query modificata a mano, aggiunto l'ordinamento DESC
	public List<SiceeTTransazione2018> findWhereFkCertificatoreAndStatoEquals(String fkCertificatore, Integer fkStatoTrans2018) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE FK_CERTIFICATORE = ? AND FK_STATO_TRANS_2018 = ? ORDER BY ID_TRANSAZIONE_2018 DESC", this,fkCertificatore, fkStatoTrans2018);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'FK_STATO_TRANS_2018 = :fkStatoTrans2018'.
	 */
	
	public List<SiceeTTransazione2018> findWhereFkStatoTrans2018Equals(Integer fkStatoTrans2018) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE FK_STATO_TRANS_2018 = ? ORDER BY FK_STATO_TRANS_2018", this,fkStatoTrans2018);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_VALORE_TRANSAZIONE = :s1ValoreTransazione'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS1ValoreTransazioneEquals(Double s1ValoreTransazione) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S1_VALORE_TRANSAZIONE = ? ORDER BY S1_VALORE_TRANSAZIONE", this,s1ValoreTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_TIPO_ID_VERSANTE = :s1TipoIdVersante'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS1TipoIdVersanteEquals(String s1TipoidVersante) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S1_TIPO_ID_VERSANTE = ? ORDER BY S1_TIPO_ID_VERSANTE", this,s1TipoidVersante);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_COD_ID_VERSANTE = :s1CodIdVersante'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS1CodIdVersanteEquals(String s1CodIdVersante) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S1_COD_ID_VERSANTE = ? ORDER BY S1_COD_ID_VERSANTE", this,s1CodIdVersante);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_ANAGRAFICA_VERSANTE = :s1AnagraficaVersante'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS1AnagraficaVersanteEquals(String s1AnagraficaVersante) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S1_ANAGRAFICA_VERSANTE = ? ORDER BY S1_ANAGRAFICA_VERSANTE", this,s1AnagraficaVersante);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_ID_TRANSAZIONE_MDP = :s1IdTransazioneMdp'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS1IdTransazioneMdpEquals(String s1IdTransazioneMdp) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S1_ID_TRANSAZIONE_MDP = ? ORDER BY S1_ID_TRANSAZIONE_MDP", this,s1IdTransazioneMdp);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S1_DT_CREAZIONE_TRANSAZIONE = :s1DtCreazioneTransazione'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS1DtCreazioneTransazioneEquals(Date s1DtCreazioneTransazione) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S1_DT_CREAZIONE_TRANSAZIONE = ? ORDER BY S1_DT_CREAZIONE_TRANSAZIONE", this,s1DtCreazioneTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_ID_INFORMATIVA_PSP = :s2IdInformativaPsp'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS2IdInformativaPspEquals(long s2IdInformativaPsp) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S2_ID_INFORMATIVA_PSP = ? ORDER BY S2_ID_INFORMATIVA_PSP", this,s2IdInformativaPsp);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_IDENTIFICATIVO_PSP = :s2IdentificativoPsp'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS2IdentificativoPspEquals(String s2IdentificativoPsp) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S2_IDENTIFICATIVO_PSP = ? ORDER BY S2_IDENTIFICATIVO_PSP", this,s2IdentificativoPsp);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_RAG_SOCIALE_PSP = :s2RagSocialePsp'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS2RagSocialePspEquals(String s2RagSocialePsp) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S2_RAG_SOCIALE_PSP = ? ORDER BY S2_RAG_SOCIALE_PSP", this,s2RagSocialePsp);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S2_DESCR_SERVIZIO_PSP = :s2DescrServizioPsp'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS2DescrServizioPspEquals(String s2DescrServizioPsp) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S2_DESCR_SERVIZIO_PSP = ? ORDER BY S2_DESCR_SERVIZIO_PSP", this,s2DescrServizioPsp);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S3_ID_IUV = :s3IdIuv'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS3IdIuvEquals(String s3IdIuv) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S3_ID_IUV = ? ORDER BY S3_ID_IUV", this,s3IdIuv);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'S3_DT_AVVIO_TRANSAZIONE = :s3DtAvvioTransazione'.
	 */
	
	public List<SiceeTTransazione2018> findWhereS3DtAvvioTransazioneEquals(Date s3DtAvvioTransazione) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE S3_DT_AVVIO_TRANSAZIONE = ? ORDER BY S3_DT_AVVIO_TRANSAZIONE", this,s3DtAvvioTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'DT_CHIUSURA_TRANSAZIONE = :dtChiusuraTransazione'.
	 */
	
	public List<SiceeTTransazione2018> findWhereDtChiusuraTransazioneEquals(Date dtChiusuraTransazione) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE DT_CHIUSURA_TRANSAZIONE = ? ORDER BY DT_CHIUSURA_TRANSAZIONE", this,dtChiusuraTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'XML_RT = :xmlRt'.
	 */
	
	public List<SiceeTTransazione2018> findWhereXmlRtEquals(String xmlRt) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE XML_RT = ? ORDER BY XML_RT", this,xmlRt);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'OP_GETSTATOTRANS_FK_STATO = :opGetstatotransFkStato'.
	 */
	
	public List<SiceeTTransazione2018> findWhereOpGetstatotransFkStatoEquals(Integer opGetstatotransFkStato) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE OP_GETSTATOTRANS_FK_STATO = ? ORDER BY OP_GETSTATOTRANS_FK_STATO", this,opGetstatotransFkStato);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_2018 table that match the criteria 'OP_GETSTATOTRANS_DT = :opGetstatotransDt'.
	 */
	
	public List<SiceeTTransazione2018> findWhereOpGetstatotransDtEquals(Date opGetstatotransDt) throws SiceeTTransazione2018DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_2018, FK_CERTIFICATORE, FK_STATO_TRANS_2018, XML_RT, S1_VALORE_TRANSAZIONE, S1_TIPO_ID_VERSANTE, S1_COD_ID_VERSANTE, S1_ANAGRAFICA_VERSANTE, S1_ID_TRANSAZIONE_MDP, S1_DT_CREAZIONE_TRANSAZIONE, S2_ID_INFORMATIVA_PSP, S2_IDENTIFICATIVO_PSP, S2_RAG_SOCIALE_PSP, S2_DESCR_SERVIZIO_PSP, S3_ID_IUV, S3_DT_AVVIO_TRANSAZIONE, DT_CHIUSURA_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO, OP_GETSTATOTRANS_DT FROM " + getTableName() + " T WHERE OP_GETSTATOTRANS_DT = ? ORDER BY OP_GETSTATOTRANS_DT", this,opGetstatotransDt);
		}
		catch (Exception e) {
			throw new SiceeTTransazione2018DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_TRANSAZIONE_2018 table that matches the specified primary-key value.
	 */
	public SiceeTTransazione2018 findByPrimaryKey(SiceeTTransazione2018Pk pk) throws SiceeTTransazione2018DaoException
	{
		return findByPrimaryKey( pk.getIdTransazione2018() );
	}

}
