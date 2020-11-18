/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiXml2015DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDatiXml2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDatiXml2015>, SiceeTDatiXml2015Dao
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
	 * @return SiceeTDatiXml2015Pk
	 */
	
	public SiceeTDatiXml2015Pk insert(SiceeTDatiXml2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkTipoVentilazione(),dto.getDtTitoloAbilitativo(),dto.getFlgSistemaContabilizzazione(),dto.getHt(),dto.getSupDispTotOpaca(),dto.getSupDispTotTrasp(),dto.getTrasmittanzaMedSupOpache(),dto.getTrasmittanzaMedSupTrasp(),dto.getPortataVentilazioneTot(),dto.getEfficienzaRecuperoMedio(), dto.getGradiGiorno(), dto.getDtSopralluogo(), dto.getSwUtilizzato(), dto.getNumCertifSw());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATI_XML_2015 table.
	 */
	
	public void update(SiceeTDatiXml2015Pk pk, SiceeTDatiXml2015 dto) throws SiceeTDatiXml2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FK_TIPO_VENTILAZIONE = ?, DT_TITOLO_ABILITATIVO = ?, FLG_SISTEMA_CONTABILIZZAZIONE = ?, HT = ?, SUP_DISP_TOT_OPACA = ?, SUP_DISP_TOT_TRASP = ?, TRASMITTANZA_MED_SUP_OPACHE = ?, TRASMITTANZA_MED_SUP_TRASP = ?, PORTATA_VENTILAZIONE_TOT = ?, EFFICIENZA_RECUPERO_MEDIO = ?, GRADI_GIORNO = ?, DT_SOPRALLUOGO = ?, SW_UTILIZZATO = ?, NUM_CERTIF_SW = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkTipoVentilazione(),dto.getDtTitoloAbilitativo(),dto.getFlgSistemaContabilizzazione(),dto.getHt(),dto.getSupDispTotOpaca(),dto.getSupDispTotTrasp(),dto.getTrasmittanzaMedSupOpache(),dto.getTrasmittanzaMedSupTrasp(),dto.getPortataVentilazioneTot(),dto.getEfficienzaRecuperoMedio(),dto.getGradiGiorno(),dto.getDtSopralluogo(),dto.getSwUtilizzato(),dto.getNumCertifSw(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_2015 table.
	 */
	
	public void delete(SiceeTDatiXml2015Pk pk) throws SiceeTDatiXml2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_2015 table.
	 */
	
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXml2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",idCertificatore,progrCertificato,anno);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDatiXml2015
	 */
	public SiceeTDatiXml2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDatiXml2015 dto = new SiceeTDatiXml2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		
		dto.setFkTipoVentilazione( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setFkTipoVentilazione( null );
		}
		
		dto.setDtTitoloAbilitativo( rs.getTimestamp(5 ) );
		dto.setFlgSistemaContabilizzazione( rs.getString( 6 ) );
		dto.setHt( new Double( rs.getDouble(7) ) );
		if (rs.wasNull()) {
			dto.setHt( null );
		}
		
		dto.setSupDispTotOpaca( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setSupDispTotOpaca( null );
		}
		
		dto.setSupDispTotTrasp( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setSupDispTotTrasp( null );
		}
		
		dto.setTrasmittanzaMedSupOpache( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setTrasmittanzaMedSupOpache( null );
		}
		
		dto.setTrasmittanzaMedSupTrasp( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setTrasmittanzaMedSupTrasp( null );
		}
		
		dto.setPortataVentilazioneTot( new Double( rs.getDouble(12) ) );
		if (rs.wasNull()) {
			dto.setPortataVentilazioneTot( null );
		}
		
		dto.setEfficienzaRecuperoMedio( new Double( rs.getDouble(13) ) );
		if (rs.wasNull()) {
			dto.setEfficienzaRecuperoMedio( null );
		}

		dto.setGradiGiorno( new Integer( rs.getInt(14) ) );
		if (rs.wasNull()) {
			dto.setGradiGiorno( null );
		}
		
		dto.setDtSopralluogo( rs.getTimestamp(15 ) );

		dto.setSwUtilizzato( rs.getString( 16 ) );
		
		dto.setNumCertifSw( new Integer( rs.getInt(17) ) );
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
		return "SICEE_T_DATI_XML_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTDatiXml2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXml2015DaoException
	{
		try {
			List<SiceeTDatiXml2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	
	
	
	
	public List<SiceeTDatiXml2015> findByDaCompletareTmp() throws SiceeTDatiXml2015DaoException
	{
		try {
			
			StringBuffer sb = new StringBuffer();
			
			sb.append("SELECT x.ID_CERTIFICATORE, x.PROGR_CERTIFICATO, x.ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW "); 
			sb.append("FROM SICEE_T_DATI_XML_2015 x, SICEE_T_IMPORT_DATI_2015 i ");
			sb.append("WHERE x.ID_CERTIFICATORE = i.id_certificatore  ");
			sb.append("AND x.PROGR_CERTIFICATO = i.progr_certificato  ");
			sb.append("AND x.ANNO = i.anno ");
			sb.append("AND SW_UTILIZZATO is null ");
			sb.append("AND i.dt_caricamento > TO_DATE('2017/04/04 15:00:00', 'YYYY/MM/DD HH24:MI:SS')  ");
			sb.append("AND rownum <= (SELECT VALORE FROM SICEE_T_PARAMETRI WHERE CODICE='NUMERO_MAX_ACE_TRATTAMENTO')  ");
			sb.append("ORDER BY x.ID_CERTIFICATORE, x.PROGR_CERTIFICATO, x.ANNO ");
			
			
			return jdbcTemplate.query(sb.toString(), this);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTDatiXml2015> findAll() throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTDatiXml2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereAnnoEquals(String anno) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'FK_PROPRIETA_EDI = :fkProprietaEdi'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereFkProprietaEdiEquals(Integer fkProprietaEdi) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE FK_PROPRIETA_EDI = ? ORDER BY FK_PROPRIETA_EDI", this,fkProprietaEdi);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'FK_TIPO_VENTILAZIONE = :fkTipoVentilazione'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereFkTipoVentilazioneEquals(Integer fkTipoVentilazione) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE FK_TIPO_VENTILAZIONE = ? ORDER BY FK_TIPO_VENTILAZIONE", this,fkTipoVentilazione);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'DT_TITOLO_ABILITATIVO = :dtTitoloAbilitativo'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereDtTitoloAbilitativoEquals(Date dtTitoloAbilitativo) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE DT_TITOLO_ABILITATIVO = ? ORDER BY DT_TITOLO_ABILITATIVO", this,dtTitoloAbilitativo);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'FLG_SISTEMA_CONTABILIZZAZIONE = :flgSistemaContabilizzazione'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereFlgSistemaContabilizzazioneEquals(String flgSistemaContabilizzazione) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE FLG_SISTEMA_CONTABILIZZAZIONE = ? ORDER BY FLG_SISTEMA_CONTABILIZZAZIONE", this,flgSistemaContabilizzazione);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'HT = :ht'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereHtEquals(Double ht) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE HT = ? ORDER BY HT", this,ht);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'SUP_DISP_TOT_OPACA = :supDispTotOpaca'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereSupDispTotOpacaEquals(Double supDispTotOpaca) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE SUP_DISP_TOT_OPACA = ? ORDER BY SUP_DISP_TOT_OPACA", this,supDispTotOpaca);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'SUP_DISP_TOT_TRASP = :supDispTotTrasp'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereSupDispTotTraspEquals(Double supDispTotTrasp) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE SUP_DISP_TOT_TRASP = ? ORDER BY SUP_DISP_TOT_TRASP", this,supDispTotTrasp);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'TRASMITTANZA_MED_SUP_OPACHE = :trasmittanzaMedSupOpache'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereTrasmittanzaMedSupOpacheEquals(Double trasmittanzaMedSupOpache) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE TRASMITTANZA_MED_SUP_OPACHE = ? ORDER BY TRASMITTANZA_MED_SUP_OPACHE", this,trasmittanzaMedSupOpache);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'TRASMITTANZA_MED_SUP_TRASP = :trasmittanzaMedSupTrasp'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereTrasmittanzaMedSupTraspEquals(Double trasmittanzaMedSupTrasp) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE TRASMITTANZA_MED_SUP_TRASP = ? ORDER BY TRASMITTANZA_MED_SUP_TRASP", this,trasmittanzaMedSupTrasp);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'PORTATA_VENTILAZIONE_TOT = :portataVentilazioneTot'.
	 */
	
	public List<SiceeTDatiXml2015> findWherePortataVentilazioneTotEquals(Double portataVentilazioneTot) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE PORTATA_VENTILAZIONE_TOT = ? ORDER BY PORTATA_VENTILAZIONE_TOT", this,portataVentilazioneTot);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'EFFICIENZA_RECUPERO_MEDIO = :efficienzaRecuperoMedio'.
	 */
	
	public List<SiceeTDatiXml2015> findWhereEfficienzaRecuperoMedioEquals(Double efficienzaRecuperoMedio) throws SiceeTDatiXml2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_TIPO_VENTILAZIONE, DT_TITOLO_ABILITATIVO, FLG_SISTEMA_CONTABILIZZAZIONE, HT, SUP_DISP_TOT_OPACA, SUP_DISP_TOT_TRASP, TRASMITTANZA_MED_SUP_OPACHE, TRASMITTANZA_MED_SUP_TRASP, PORTATA_VENTILAZIONE_TOT, EFFICIENZA_RECUPERO_MEDIO, GRADI_GIORNO, DT_SOPRALLUOGO, SW_UTILIZZATO, NUM_CERTIF_SW FROM " + getTableName() + " WHERE EFFICIENZA_RECUPERO_MEDIO = ? ORDER BY EFFICIENZA_RECUPERO_MEDIO", this,efficienzaRecuperoMedio);
		}
		catch (Exception e) {
			throw new SiceeTDatiXml2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DATI_XML_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiXml2015 findByPrimaryKey(SiceeTDatiXml2015Pk pk) throws SiceeTDatiXml2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
