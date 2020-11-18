/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiGeneraliDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGeneraliPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiGeneraliDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDatiGeneraliDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDatiGenerali>, SiceeTDatiGeneraliDao
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
	 * @return SiceeTDatiGeneraliPk
	 */
	
	public SiceeTDatiGeneraliPk insert(SiceeTDatiGenerali dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDescTipoEdificio(),dto.getFkDestUso(),dto.getAnnoCostruzione(),dto.getAnnoUltRist(),dto.getVolLordoRiscaldato(),dto.getSupDisperdenteTot(),dto.getFattoreForma(),dto.getTrasmOpache(),dto.getTrasmTrasp(),dto.getZonaClimatica(),dto.getGradiGiorno(),dto.getSu(),dto.getEmissioniSerra(),dto.getEttariBosco(),dto.getFlagUsoPubblico(),dto.getFkCarattEdificio(),dto.getNrUm(),dto.getSupRiscaldata(),dto.getSupRaffrescata(),dto.getSupDisperdente(),dto.getVolLordoRaffrescato(),dto.isFkOggettoApeNull()?null:dto.getFkOggettoApe(),dto.getFkDestUso2015(),dto.getFkTipoRistrutturaz(),dto.getFkTipolEdilizia(),dto.getFkTipolCostruttiva(), dto.getFkProprietaEdi(), dto.getCodiceEdificioScolastico());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATI_GENERALI table.
	 */
	
	public void update(SiceeTDatiGeneraliPk pk, SiceeTDatiGenerali dto) throws SiceeTDatiGeneraliDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, DESC_TIPO_EDIFICIO = ?, FK_DEST_USO = ?, ANNO_COSTRUZIONE = ?, ANNO_ULT_RIST = ?, VOL_LORDO_RISCALDATO = ?, SUP_DISPERDENTE_TOT = ?, FATTORE_FORMA = ?, TRASM_OPACHE = ?, TRASM_TRASP = ?, ZONA_CLIMATICA = ?, GRADI_GIORNO = ?, SU = ?, EMISSIONI_SERRA = ?, ETTARI_BOSCO = ?, FLG_USO_PUBBLICO = ?, FK_CARATT_EDIFICIO = ?, NR_UM = ?, SUP_RISCALDATA = ?, SUP_RAFFRESCATA = ?, SUP_DISPERDENTE = ?, VOL_LORDO_RAFFRESCATO = ?, FK_OGGETTO_APE = ?, FK_DEST_USO_2015 = ?, FK_TIPO_RISTRUTTURAZ = ?, FK_TIPOL_EDILIZIA = ?, FK_TIPOL_COSTRUTTIVA = ?, FK_PROPRIETA_EDI = ?, CODICE_EDIFICIO_SCOLASTICO = ?  WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDescTipoEdificio(),dto.getFkDestUso(),dto.getAnnoCostruzione(),dto.getAnnoUltRist(),dto.getVolLordoRiscaldato(),dto.getSupDisperdenteTot(),dto.getFattoreForma(),dto.getTrasmOpache(),dto.getTrasmTrasp(),dto.getZonaClimatica(),dto.getGradiGiorno(),dto.getSu(),dto.getEmissioniSerra(),dto.getEttariBosco(),dto.getFlagUsoPubblico(),dto.getFkCarattEdificio(),dto.getNrUm(),dto.getSupRiscaldata(),dto.getSupRaffrescata(),dto.getSupDisperdente(),dto.getVolLordoRaffrescato(),dto.getFkOggettoApe(),dto.getFkDestUso2015(),dto.getFkTipoRistrutturaz(),dto.getFkTipolEdilizia(),dto.getFkTipolCostruttiva(),dto.getFkProprietaEdi(),dto.getCodiceEdificioScolastico(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_GENERALI table.
	 */
	
	public void delete(SiceeTDatiGeneraliPk pk) throws SiceeTDatiGeneraliDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDatiGenerali
	 */
	public SiceeTDatiGenerali mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDatiGenerali dto = new SiceeTDatiGenerali();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setDescTipoEdificio( rs.getString( 4 ) );
		dto.setFkDestUso( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setFkDestUso( null );
		}
		
		dto.setAnnoCostruzione( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setAnnoCostruzione( null );
		}
		
		dto.setAnnoUltRist( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setAnnoUltRist( null );
		}
		
		dto.setVolLordoRiscaldato( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setVolLordoRiscaldato( null );
		}
		
		dto.setSupDisperdenteTot( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setSupDisperdenteTot( null );
		}
		
		dto.setFattoreForma( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setFattoreForma( null );
		}
		
		dto.setTrasmOpache( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setTrasmOpache( null );
		}
		
		dto.setTrasmTrasp( new Double( rs.getDouble(12) ) );
		if (rs.wasNull()) {
			dto.setTrasmTrasp( null );
		}
		
		dto.setZonaClimatica( rs.getString( 13 ) );
		dto.setGradiGiorno( new Integer( rs.getInt(14) ) );
		if (rs.wasNull()) {
			dto.setGradiGiorno( null );
		}
		
		dto.setSu( new Double( rs.getDouble(15) ) );
		if (rs.wasNull()) {
			dto.setSu( null );
		}
		
		dto.setEmissioniSerra( new Double( rs.getDouble(16) ) );
		if (rs.wasNull()) {
			dto.setEmissioniSerra( null );
		}
		
		dto.setEttariBosco( new Double( rs.getDouble(17) ) );
		if (rs.wasNull()) {
			dto.setEttariBosco( null );
		}
		
		dto.setFlagUsoPubblico( rs.getString( 18 ) );
		dto.setFkCarattEdificio( new Integer( rs.getInt(19) ) );
		if (rs.wasNull()) {
			dto.setFkCarattEdificio( null );
		}
		
		dto.setNrUm( new Integer( rs.getInt(20) ) );
		if (rs.wasNull()) {
			dto.setNrUm( null );
		}
		
		dto.setSupRiscaldata( new Double( rs.getDouble(21) ) );
		if (rs.wasNull()) {
			dto.setSupRiscaldata( null );
		}
		
		dto.setSupRaffrescata( new Double( rs.getDouble(22) ) );
		if (rs.wasNull()) {
			dto.setSupRaffrescata( null );
		}
		
		dto.setSupDisperdente( new Double( rs.getDouble(23) ) );
		if (rs.wasNull()) {
			dto.setSupDisperdente( null );
		}
		
		dto.setVolLordoRaffrescato( new Double( rs.getDouble(24) ) );
		if (rs.wasNull()) {
			dto.setVolLordoRaffrescato( null );
		}
		
		dto.setFkOggettoApe( new Integer(rs.getInt( 25 ) ) );
		if (rs.wasNull()) {
			dto.setFkOggettoApeNull( true );
		}
		
		dto.setFkDestUso2015( new Integer( rs.getInt(26) ) );
		if (rs.wasNull()) {
			dto.setFkDestUso2015( null );
		}

		dto.setFkTipoRistrutturaz( new Integer( rs.getInt(27) ) );
		if (rs.wasNull()) {
			dto.setFkTipoRistrutturaz( null );
		}

		dto.setFkTipolEdilizia( new Integer( rs.getInt(28) ) );
		if (rs.wasNull()) {
			dto.setFkTipolEdilizia( null );
		}

		dto.setFkTipolCostruttiva( new Integer( rs.getInt(29) ) );
		if (rs.wasNull()) {
			dto.setFkTipolCostruttiva( null );
		}

		dto.setFkProprietaEdi( new Integer( rs.getInt(30) ) );
		if (rs.wasNull()) {
			dto.setFkProprietaEdi( null );
		}

		dto.setCodiceEdificioScolastico( rs.getString( 31 ) );

		
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_DATI_GENERALI";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTDatiGenerali findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiGeneraliDaoException
	{
		try {
			List<SiceeTDatiGenerali> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_DEST_USO = :fkDestUso'.
	 */
	
	public List<SiceeTDatiGenerali> findBySiceeDDestUso(Integer fkDestUso) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_DEST_USO = ?", this,fkDestUso);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_EDIFICIO = :fkEdificio'.
	 */
	
	public List<SiceeTDatiGenerali> findBySiceeDEdificio(Integer fkEdificio) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_EDIFICIO = ?", this,fkEdificio);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_EDIFICIO = :fkEdificio'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereFkEdificioEquals(Integer fkEdificio) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_EDIFICIO = ? ORDER BY FK_EDIFICIO", this,fkEdificio);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_CARATT_EDIFICIO = :fkCarattEdificio'.
	 */
	
	public List<SiceeTDatiGenerali> findBySiceeDCarattEdificio(Integer fkCarattEdificio) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_CARATT_EDIFICIO = ?", this,fkCarattEdificio);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria ''.
	 */
	
	public List<SiceeTDatiGenerali> findAll() throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTDatiGenerali> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereAnnoEquals(String anno) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'DESC_TIPO_EDIFICIO = :descTipoEdificio'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereDescTipoEdificioEquals(String descTipoEdificio) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE DESC_TIPO_EDIFICIO = ? ORDER BY DESC_TIPO_EDIFICIO", this,descTipoEdificio);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_DEST_USO = :fkDestUso'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereFkDestUsoEquals(Integer fkDestUso) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_DEST_USO = ? ORDER BY FK_DEST_USO", this,fkDestUso);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ANNO_COSTRUZIONE = :annoCostruzione'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereAnnoCostruzioneEquals(Integer annoCostruzione) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ANNO_COSTRUZIONE = ? ORDER BY ANNO_COSTRUZIONE", this,annoCostruzione);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ANNO_ULT_RIST = :annoUltRist'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereAnnoUltRistEquals(Integer annoUltRist) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ANNO_ULT_RIST = ? ORDER BY ANNO_ULT_RIST", this,annoUltRist);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'VOL_LORDO_RISCALDATO = :volLordoRiscaldato'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereVolLordoRiscaldatoEquals(Double volLordoRiscaldato) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE VOL_LORDO_RISCALDATO = ? ORDER BY VOL_LORDO_RISCALDATO", this,volLordoRiscaldato);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_DISPERDENTE_TOT = :supDisperdenteTot'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereSupDisperdenteTotEquals(Double supDisperdenteTot) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE SUP_DISPERDENTE_TOT = ? ORDER BY SUP_DISPERDENTE_TOT", this,supDisperdenteTot);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FATTORE_FORMA = :fattoreForma'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereFattoreFormaEquals(Double fattoreForma) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FATTORE_FORMA = ? ORDER BY FATTORE_FORMA", this,fattoreForma);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'TRASM_OPACHE = :trasmOpache'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereTrasmOpacheEquals(Double trasmOpache) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE TRASM_OPACHE = ? ORDER BY TRASM_OPACHE", this,trasmOpache);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'TRASM_TRASP = :trasmTrasp'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereTrasmTraspEquals(Double trasmTrasp) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE TRASM_TRASP = ? ORDER BY TRASM_TRASP", this,trasmTrasp);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ZONA_CLIMATICA = :zonaClimatica'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereZonaClimaticaEquals(String zonaClimatica) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ZONA_CLIMATICA = ? ORDER BY ZONA_CLIMATICA", this,zonaClimatica);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'GRADI_GIORNO = :gradiGiorno'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereGradiGiornoEquals(Integer gradiGiorno) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE GRADI_GIORNO = ? ORDER BY GRADI_GIORNO", this,gradiGiorno);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SU = :su'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereSuEquals(Double su) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE SU = ? ORDER BY SU", this,su);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'EMISSIONI_SERRA = :emissioniSerra'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereEmissioniSerraEquals(Double emissioniSerra) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE EMISSIONI_SERRA = ? ORDER BY EMISSIONI_SERRA", this,emissioniSerra);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ETTARI_BOSCO = :ettariBosco'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereEttariBoscoEquals(Double ettariBosco) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE ETTARI_BOSCO = ? ORDER BY ETTARI_BOSCO", this,ettariBosco);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FLG_USO_PUBBLICO = :flgUsoPubblico'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereFlgUsoPubblicoEquals(String flgUsoPubblico) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FLG_USO_PUBBLICO = ? ORDER BY FLG_USO_PUBBLICO", this,flgUsoPubblico);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_CARATT_EDIFICIO = :fkCarattEdificio'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereFkCarattEdificioEquals(Integer fkCarattEdificio) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_CARATT_EDIFICIO = ? ORDER BY FK_CARATT_EDIFICIO", this,fkCarattEdificio);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'NR_UM = :nrUm'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereNrUmEquals(Integer nrUm) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE NR_UM = ? ORDER BY NR_UM", this,nrUm);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_RISCALDATA = :supRiscaldata'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereSupRiscaldataEquals(Double supRiscaldata) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE SUP_RISCALDATA = ? ORDER BY SUP_RISCALDATA", this,supRiscaldata);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_RAFFRESCATA = :supRaffrescata'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereSupRaffrescataEquals(Double supRaffrescata) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE SUP_RAFFRESCATA = ? ORDER BY SUP_RAFFRESCATA", this,supRaffrescata);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_DISPERDENTE = :supDisperdente'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereSupDisperdenteEquals(Double supDisperdente) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE SUP_DISPERDENTE = ? ORDER BY SUP_DISPERDENTE", this,supDisperdente);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'VOL_LORDO_RAFFRESCATO = :volLordoRaffrescato'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereVolLordoRaffrescatoEquals(Double volLordoRaffrescato) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE VOL_LORDO_RAFFRESCATO = ? ORDER BY VOL_LORDO_RAFFRESCATO", this,volLordoRaffrescato);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_OGGETTO_APE = :fkOggettoApe'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereFkOggettoApeEquals(long fkOggettoApe) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_OGGETTO_APE = ? ORDER BY FK_OGGETTO_APE", this,fkOggettoApe);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_DEST_USO_2015 = :fkDestUso2015'.
	 */
	
	public List<SiceeTDatiGenerali> findWhereFkDestUso2015Equals(Integer fkDestUso2015) throws SiceeTDatiGeneraliDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EDIFICIO, FK_DEST_USO, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, FATTORE_FORMA, TRASM_OPACHE, TRASM_TRASP, ZONA_CLIMATICA, GRADI_GIORNO, SU, EMISSIONI_SERRA, ETTARI_BOSCO, FLG_USO_PUBBLICO, FK_CARATT_EDIFICIO, NR_UM, SUP_RISCALDATA, SUP_RAFFRESCATA, SUP_DISPERDENTE, VOL_LORDO_RAFFRESCATO, FK_OGGETTO_APE, FK_DEST_USO_2015, FK_TIPO_RISTRUTTURAZ, FK_TIPOL_EDILIZIA, FK_TIPOL_COSTRUTTIVA, FK_PROPRIETA_EDI, CODICE_EDIFICIO_SCOLASTICO FROM " + getTableName() + " WHERE FK_DEST_USO_2015 = ? ORDER BY FK_DEST_USO_2015", this,fkDestUso2015);
		}
		catch (Exception e) {
			throw new SiceeTDatiGeneraliDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DATI_GENERALI table that matches the specified primary-key value.
	 */
	public SiceeTDatiGenerali findByPrimaryKey(SiceeTDatiGeneraliPk pk) throws SiceeTDatiGeneraliDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
