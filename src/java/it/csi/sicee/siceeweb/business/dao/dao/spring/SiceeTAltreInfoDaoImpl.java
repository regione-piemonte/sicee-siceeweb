/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAltreInfoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTAltreInfoDaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTAltreInfoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTAltreInfo>, SiceeTAltreInfoDao
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
	 * @return SiceeTAltreInfoPk
	 */
	
	public SiceeTAltreInfoPk insert(SiceeTAltreInfo dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getPrestazioneEne(),dto.getProgrCertificato(),dto.getAnno(),dto.getLimiteNormaRisc(),dto.getFkClasse19205(),dto.getFkQualitaInvo(),dto.getFkMotivo(),dto.getLimiteNormaImp(),dto.getValorePrestPdc(),dto.getLimiteNormaPdc(),dto.getUltInfo(),dto.getMetodologiaCalcolo(),dto.getNomeProduttore(),dto.getSwUtilizzato(),dto.getUniTs11300(),dto.getIndRiscEpiNaz(),dto.getNrCertificato(),dto.isFkRuoloCertNull()?null:dto.getFkRuoloCert(),dto.getDichInpipendenza(),dto.getNoteSegnalazioni(),dto.getInfoMiglPrestEnerg(),dto.getDocumentazione(),dto.getFlgSopralluogo(),dto.getDataSopralluogo(),dto.getFlgSw1(),dto.getFlgSw2(),dto.getNoteSopralluogo(),dto.getMotivoAltro(),dto.getAltroServiziEnergia());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ALTRE_INFO table.
	 */
	
	public void update(SiceeTAltreInfoPk pk, SiceeTAltreInfo dto) throws SiceeTAltreInfoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PRESTAZIONE_ENE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, LIMITE_NORMA_RISC = ?, FK_CLASSE_192_05 = ?, FK_QUALITA_INVO = ?, FK_MOTIVO = ?, LIMITE_NORMA_IMP = ?, VALORE_PREST_PDC = ?, LIMITE_NORMA_PDC = ?, ULT_INFO = ?, METODOLOGIA_CALCOLO = ?, NOME_PRODUTTORE = ?, SW_UTILIZZATO = ?, UNI_TS_11300 = ?, IND_RISC_EPI_NAZ = ?, NR_CERTIFICATO = ?, FK_RUOLO_CERT = ?, DICH_INPIPENDENZA = ?, NOTE_SEGNALAZIONI = ?, INFO_MIGL_PREST_ENERG = ?, DOCUMENTAZIONE = ?, FLG_SOPRALLUOGO = ?, DATA_SOPRALLUOGO = ?, FLG_SW1 = ?, FLG_SW2 = ?, NOTE_SOPRALLUOGO = ?, MOTIVO_ALTRO = ?, ALTRO_SERVIZI_ENERGIA = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getPrestazioneEne(),dto.getProgrCertificato(),dto.getAnno(),dto.getLimiteNormaRisc(),dto.getFkClasse19205(),dto.getFkQualitaInvo(),dto.getFkMotivo(),dto.getLimiteNormaImp(),dto.getValorePrestPdc(),dto.getLimiteNormaPdc(),dto.getUltInfo(),dto.getMetodologiaCalcolo(),dto.getNomeProduttore(),dto.getSwUtilizzato(),dto.getUniTs11300(),dto.getIndRiscEpiNaz(),dto.getNrCertificato(),dto.getFkRuoloCert(),dto.getDichInpipendenza(),dto.getNoteSegnalazioni(),dto.getInfoMiglPrestEnerg(),dto.getDocumentazione(),dto.getFlgSopralluogo(),dto.getDataSopralluogo(),dto.getFlgSw1(),dto.getFlgSw2(),dto.getNoteSopralluogo(),dto.getMotivoAltro(),dto.getAltroServiziEnergia(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ALTRE_INFO table.
	 */
	
	public void delete(SiceeTAltreInfoPk pk) throws SiceeTAltreInfoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTAltreInfo
	 */
	public SiceeTAltreInfo mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTAltreInfo dto = new SiceeTAltreInfo();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setPrestazioneEne( new Double( rs.getDouble(2) ) );
		if (rs.wasNull()) {
			dto.setPrestazioneEne( null );
		}
		
		dto.setProgrCertificato( rs.getString( 3 ) );
		dto.setAnno( rs.getString( 4 ) );
		dto.setLimiteNormaRisc( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setLimiteNormaRisc( null );
		}
		
		dto.setFkClasse19205( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setFkClasse19205( null );
		}
		
		dto.setFkQualitaInvo( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setFkQualitaInvo( null );
		}
		
		dto.setFkMotivo( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setFkMotivo( null );
		}
		
		dto.setLimiteNormaImp( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setLimiteNormaImp( null );
		}
		
		dto.setValorePrestPdc( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setValorePrestPdc( null );
		}
		
		dto.setLimiteNormaPdc( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setLimiteNormaPdc( null );
		}
		
		dto.setUltInfo( rs.getString( 12 ) );
		dto.setMetodologiaCalcolo( rs.getString( 13 ) );
		dto.setNomeProduttore( rs.getString( 14 ) );
		dto.setSwUtilizzato( rs.getString( 15 ) );
		dto.setUniTs11300( rs.getString( 16 ) );
		dto.setIndRiscEpiNaz( new Double( rs.getDouble(17) ) );
		if (rs.wasNull()) {
			dto.setIndRiscEpiNaz( null );
		}
		
		dto.setNrCertificato( rs.getString( 18 ) );
		dto.setFkRuoloCert( new Integer(rs.getInt( 19 ) ) );
		if (rs.wasNull()) {
			dto.setFkRuoloCertNull( true );
		}
		
		dto.setDichInpipendenza( rs.getString( 20 ) );
		dto.setNoteSegnalazioni( rs.getString( 21 ) );
		dto.setInfoMiglPrestEnerg( rs.getString( 22 ) );
		dto.setDocumentazione( rs.getString( 23 ) );
		dto.setFlgSopralluogo( rs.getString( 24 ) );
		dto.setDataSopralluogo( rs.getTimestamp(25 ) );
		dto.setFlgSw1( rs.getString( 26 ) );
		dto.setFlgSw2( rs.getString( 27 ) );
		dto.setNoteSopralluogo( rs.getString( 28 ) );
		dto.setMotivoAltro( rs.getString( 29 ) );
		dto.setAltroServiziEnergia( new Integer(rs.getInt( 30 ) ) );
		if (rs.wasNull()) {
			dto.setAltroServiziEnergia( null );
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
		return "SICEE_T_ALTRE_INFO";
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTAltreInfo findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTAltreInfoDaoException
	{
		try {
			List<SiceeTAltreInfo> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria ''.
	 */
	
	public List<SiceeTAltreInfo> findAll() throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTAltreInfo> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTAltreInfo> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'PRESTAZIONE_ENE = :prestazioneEne'.
	 */
	
	public List<SiceeTAltreInfo> findWherePrestazioneEneEquals(Double prestazioneEne) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE PRESTAZIONE_ENE = ? ORDER BY PRESTAZIONE_ENE", this,prestazioneEne);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTAltreInfo> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTAltreInfo> findWhereAnnoEquals(String anno) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'LIMITE_NORMA_RISC = :limiteNormaRisc'.
	 */
	
	public List<SiceeTAltreInfo> findWhereLimiteNormaRiscEquals(Double limiteNormaRisc) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE LIMITE_NORMA_RISC = ? ORDER BY LIMITE_NORMA_RISC", this,limiteNormaRisc);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_CLASSE_192_05 = :fkClasse19205'.
	 */
	
	public List<SiceeTAltreInfo> findWhereFkClasse19205Equals(Integer fkClasse19205) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE FK_CLASSE_192_05 = ? ORDER BY FK_CLASSE_192_05", this,fkClasse19205);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_QUALITA_INVO = :fkQualitaInvo'.
	 */
	
	public List<SiceeTAltreInfo> findWhereFkQualitaInvoEquals(Integer fkQualitaInvo) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE FK_QUALITA_INVO = ? ORDER BY FK_QUALITA_INVO", this,fkQualitaInvo);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_MOTIVO = :fkMotivo'.
	 */
	
	public List<SiceeTAltreInfo> findWhereFkMotivoEquals(Integer fkMotivo) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE FK_MOTIVO = ? ORDER BY FK_MOTIVO", this,fkMotivo);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'LIMITE_NORMA_IMP = :limiteNormaImp'.
	 */
	
	public List<SiceeTAltreInfo> findWhereLimiteNormaImpEquals(Double limiteNormaImp) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE LIMITE_NORMA_IMP = ? ORDER BY LIMITE_NORMA_IMP", this,limiteNormaImp);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'VALORE_PREST_PDC = :valorePrestPdc'.
	 */
	
	public List<SiceeTAltreInfo> findWhereValorePrestPdcEquals(Double valorePrestPdc) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE VALORE_PREST_PDC = ? ORDER BY VALORE_PREST_PDC", this,valorePrestPdc);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'LIMITE_NORMA_PDC = :limiteNormaPdc'.
	 */
	
	public List<SiceeTAltreInfo> findWhereLimiteNormaPdcEquals(Double limiteNormaPdc) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE LIMITE_NORMA_PDC = ? ORDER BY LIMITE_NORMA_PDC", this,limiteNormaPdc);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'ULT_INFO = :ultInfo'.
	 */
	
	public List<SiceeTAltreInfo> findWhereUltInfoEquals(String ultInfo) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE ULT_INFO = ? ORDER BY ULT_INFO", this,ultInfo);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'METODOLOGIA_CALCOLO = :metodologiaCalcolo'.
	 */
	
	public List<SiceeTAltreInfo> findWhereMetodologiaCalcoloEquals(String metodologiaCalcolo) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE METODOLOGIA_CALCOLO = ? ORDER BY METODOLOGIA_CALCOLO", this,metodologiaCalcolo);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NOME_PRODUTTORE = :nomeProduttore'.
	 */
	
	public List<SiceeTAltreInfo> findWhereNomeProduttoreEquals(String nomeProduttore) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE NOME_PRODUTTORE = ? ORDER BY NOME_PRODUTTORE", this,nomeProduttore);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'SW_UTILIZZATO = :swUtilizzato'.
	 */
	
	public List<SiceeTAltreInfo> findWhereSwUtilizzatoEquals(String swUtilizzato) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE SW_UTILIZZATO = ? ORDER BY SW_UTILIZZATO", this,swUtilizzato);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'UNI_TS_11300 = :uniTs11300'.
	 */
	
	public List<SiceeTAltreInfo> findWhereUniTs11300Equals(String uniTs11300) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE UNI_TS_11300 = ? ORDER BY UNI_TS_11300", this,uniTs11300);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'IND_RISC_EPI_NAZ = :indRiscEpiNaz'.
	 */
	
	public List<SiceeTAltreInfo> findWhereIndRiscEpiNazEquals(Double indRiscEpiNaz) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE IND_RISC_EPI_NAZ = ? ORDER BY IND_RISC_EPI_NAZ", this,indRiscEpiNaz);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NR_CERTIFICATO = :nrCertificato'.
	 */
	
	public List<SiceeTAltreInfo> findWhereNrCertificatoEquals(String nrCertificato) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE NR_CERTIFICATO = ? ORDER BY NR_CERTIFICATO", this,nrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FK_RUOLO_CERT = :fkRuoloCert'.
	 */
	
	public List<SiceeTAltreInfo> findWhereFkRuoloCertEquals(long fkRuoloCert) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE FK_RUOLO_CERT = ? ORDER BY FK_RUOLO_CERT", this,fkRuoloCert);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'DICH_INPIPENDENZA = :dichInpipendenza'.
	 */
	
	public List<SiceeTAltreInfo> findWhereDichInpipendenzaEquals(String dichInpipendenza) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE DICH_INPIPENDENZA = ? ORDER BY DICH_INPIPENDENZA", this,dichInpipendenza);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NOTE_SEGNALAZIONI = :noteSegnalazioni'.
	 */
	
	public List<SiceeTAltreInfo> findWhereNoteSegnalazioniEquals(String noteSegnalazioni) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE NOTE_SEGNALAZIONI = ? ORDER BY NOTE_SEGNALAZIONI", this,noteSegnalazioni);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'INFO_MIGL_PREST_ENERG = :infoMiglPrestEnerg'.
	 */
	
	public List<SiceeTAltreInfo> findWhereInfoMiglPrestEnergEquals(String infoMiglPrestEnerg) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE INFO_MIGL_PREST_ENERG = ? ORDER BY INFO_MIGL_PREST_ENERG", this,infoMiglPrestEnerg);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'DOCUMENTAZIONE = :documentazione'.
	 */
	
	public List<SiceeTAltreInfo> findWhereDocumentazioneEquals(String documentazione) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE DOCUMENTAZIONE = ? ORDER BY DOCUMENTAZIONE", this,documentazione);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FLG_SOPRALLUOGO = :flgSopralluogo'.
	 */
	
	public List<SiceeTAltreInfo> findWhereFlgSopralluogoEquals(String flgSopralluogo) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE FLG_SOPRALLUOGO = ? ORDER BY FLG_SOPRALLUOGO", this,flgSopralluogo);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'DATA_SOPRALLUOGO = :dataSopralluogo'.
	 */
	
	public List<SiceeTAltreInfo> findWhereDataSopralluogoEquals(Date dataSopralluogo) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE DATA_SOPRALLUOGO = ? ORDER BY DATA_SOPRALLUOGO", this,dataSopralluogo);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FLG_SW1 = :flgSw1'.
	 */
	
	public List<SiceeTAltreInfo> findWhereFlgSw1Equals(String flgSw1) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE FLG_SW1 = ? ORDER BY FLG_SW1", this,flgSw1);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'FLG_SW2 = :flgSw2'.
	 */
	
	public List<SiceeTAltreInfo> findWhereFlgSw2Equals(String flgSw2) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE FLG_SW2 = ? ORDER BY FLG_SW2", this,flgSw2);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'NOTE_SOPRALLUOGO = :noteSopralluogo'.
	 */
	
	public List<SiceeTAltreInfo> findWhereNoteSopralluogoEquals(String noteSopralluogo) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE NOTE_SOPRALLUOGO = ? ORDER BY NOTE_SOPRALLUOGO", this,noteSopralluogo);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ALTRE_INFO table that match the criteria 'MOTIVO_ALTRO = :motivoAltro'.
	 */
	
	public List<SiceeTAltreInfo> findWhereMotivoAltroEquals(String motivoAltro) throws SiceeTAltreInfoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PRESTAZIONE_ENE, PROGR_CERTIFICATO, ANNO, LIMITE_NORMA_RISC, FK_CLASSE_192_05, FK_QUALITA_INVO, FK_MOTIVO, LIMITE_NORMA_IMP, VALORE_PREST_PDC, LIMITE_NORMA_PDC, ULT_INFO, METODOLOGIA_CALCOLO, NOME_PRODUTTORE, SW_UTILIZZATO, UNI_TS_11300, IND_RISC_EPI_NAZ, NR_CERTIFICATO, FK_RUOLO_CERT, DICH_INPIPENDENZA, NOTE_SEGNALAZIONI, INFO_MIGL_PREST_ENERG, DOCUMENTAZIONE, FLG_SOPRALLUOGO, DATA_SOPRALLUOGO, FLG_SW1, FLG_SW2, NOTE_SOPRALLUOGO, MOTIVO_ALTRO, ALTRO_SERVIZI_ENERGIA FROM " + getTableName() + " WHERE MOTIVO_ALTRO = ? ORDER BY MOTIVO_ALTRO", this,motivoAltro);
		}
		catch (Exception e) {
			throw new SiceeTAltreInfoDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_T_ALTRE_INFO table that matches the specified primary-key value.
	 */
	public SiceeTAltreInfo findByPrimaryKey(SiceeTAltreInfoPk pk) throws SiceeTAltreInfoDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
