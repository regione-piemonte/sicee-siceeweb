/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTExportBoDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTExportBoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTExportBo>, SiceeTExportBoDao
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
	 * @return SiceeTExportBoPk
	 */
	
	public SiceeTExportBoPk insert(SiceeTExportBo dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDtInizio(),dto.getDtUpload(),dto.getDescProv(),dto.getDescComune(),dto.getGradiGiorno(),dto.getPiano(),dto.getNumPianiComplessivi(),dto.getFkStato(),dto.getFkDestUso(),dto.getDescTipoEdificio(),dto.getFkClasse(),dto.getAnnoCostruzione(),dto.getAnnoUltRist(),dto.getVolLordoRiscaldato(),dto.getSupDisperdenteTot(),dto.getSu(),dto.getTrasmOpache(),dto.getTrasmTrasp(),dto.getFattoreForma(),dto.getVSu(),dto.getIndRiscEpito(),dto.getFlgFabbMaxIndice(),dto.getValorePrestPdc(),dto.getRendAcsEtagacs(),dto.getDomAcsQhw(),dto.getEnAcsRinno(),dto.getRendImpEtag(),dto.getDomAcsQhwSu(),dto.getIndGlobEplordo(),dto.getDomAcsQhwto(),dto.getFlgFabbAcs(),dto.getFkMotivo(),dto.getMetodologiaCalcolo(),dto.getSwUtilizzato(),dto.getDescIndirizzo(),dto.getNumCivico(),dto.getSezione(),dto.getFoglio(),dto.getParticella(),dto.getSubalterno(),dto.getIdProv(),dto.getIdComune(),dto.getFkTipoImpianto(),dto.getFkCombustibileRisc(),dto.getFkCombustibileAcs(),dto.getFkClasse19205(),dto.getDomRiscQh(),dto.getIndRiscEpi(),dto.getFabbAcs(),dto.getIndGlobEplordoTo(),dto.getPrestazioneEne(),dto.getNumAppartamenti(),dto.getUiServite(),dto.getPotRiscaldamento(),dto.getFkClasseEffRisc(),dto.getGenAnnoRisc(),dto.getFlgContRip(),dto.getRendGener(),dto.getRendRegol(),dto.getRendEmiss(),dto.getRendDistrib(),dto.getDomRiscQhto(),dto.getFkCarattEdificio(),dto.getFlgOld(),dto.getFlgEdifE0(),dto.getEpglNrenGlobale(),dto.getEpglRenGlobale(),dto.getEmissioniCo2(),dto.getSupRaffrescata(),dto.getSupRiscaldata(),dto.getVolLordoRaffrescato(),dto.getEph(),dto.getAsolAsup(),dto.getYie(),dto.getVSuRaff(),dto.getVSuRisc(),dto.getSVRaff(),dto.getSVRisc(),dto.getDtScadenza());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_EXPORT_BO table.
	 */
	
	public void update(SiceeTExportBoPk pk, SiceeTExportBo dto) throws SiceeTExportBoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, DT_INIZIO = ?, DT_UPLOAD = ?, DESC_PROV = ?, DESC_COMUNE = ?, GRADI_GIORNO = ?, PIANO = ?, NUM_PIANI_COMPLESSIVI = ?, FK_STATO = ?, FK_DEST_USO = ?, DESC_TIPO_EDIFICIO = ?, FK_CLASSE = ?, ANNO_COSTRUZIONE = ?, ANNO_ULT_RIST = ?, VOL_LORDO_RISCALDATO = ?, SUP_DISPERDENTE_TOT = ?, SU = ?, TRASM_OPACHE = ?, TRASM_TRASP = ?, FATTORE_FORMA = ?, V_SU = ?, IND_RISC_EPITO = ?, FLG_FABB_MAX_INDICE = ?, VALORE_PREST_PDC = ?, REND_ACS_ETAGACS = ?, DOM_ACS_QHW = ?, EN_ACS_RINNO = ?, REND_IMP_ETAG = ?, DOM_ACS_QHW_SU = ?, IND_GLOB_EPLORDO = ?, DOM_ACS_QHWTO = ?, FLG_FABB_ACS = ?, FK_MOTIVO = ?, METODOLOGIA_CALCOLO = ?, SW_UTILIZZATO = ?, DESC_INDIRIZZO = ?, NUM_CIVICO = ?, SEZIONE = ?, FOGLIO = ?, PARTICELLA = ?, SUBALTERNO = ?, ID_PROV = ?, ID_COMUNE = ?, FK_TIPO_IMPIANTO = ?, FK_COMBUSTIBILE_RISC = ?, FK_COMBUSTIBILE_ACS = ?, FK_CLASSE_192_05 = ?, DOM_RISC_QH = ?, IND_RISC_EPI = ?, FABB_ACS = ?, IND_GLOB_EPLORDO_TO = ?, PRESTAZIONE_ENE = ?, NUM_APPARTAMENTI = ?, UI_SERVITE = ?, POT_RISCALDAMENTO = ?, FK_CLASSE_EFF_RISC = ?, GEN_ANNO_RISC = ?, FLG_CONT_RIP = ?, REND_GENER = ?, REND_REGOL = ?, REND_EMISS = ?, REND_DISTRIB = ?, DOM_RISC_QHTO = ?, FK_CARATT_EDIFICIO = ?, FLG_OLD = ?, FLG_EDIF_E0 = ?, EPGL_NREN_GLOBALE = ?, EPGL_REN_GLOBALE = ?, EMISSIONI_CO2 = ?, SUP_RAFFRESCATA = ?, SUP_RISCALDATA = ?, VOL_LORDO_RAFFRESCATO = ?, EPH = ?, ASOL_ASUP = ?, YIE = ?, V_SU_RAFF = ?, V_SU_RISC = ?, S_V_RAFF = ?, S_V_RISC = ?, DT_SCADENZA = ? WHERE ANNO = ? AND ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDtInizio(),dto.getDtUpload(),dto.getDescProv(),dto.getDescComune(),dto.getGradiGiorno(),dto.getPiano(),dto.getNumPianiComplessivi(),dto.getFkStato(),dto.getFkDestUso(),dto.getDescTipoEdificio(),dto.getFkClasse(),dto.getAnnoCostruzione(),dto.getAnnoUltRist(),dto.getVolLordoRiscaldato(),dto.getSupDisperdenteTot(),dto.getSu(),dto.getTrasmOpache(),dto.getTrasmTrasp(),dto.getFattoreForma(),dto.getVSu(),dto.getIndRiscEpito(),dto.getFlgFabbMaxIndice(),dto.getValorePrestPdc(),dto.getRendAcsEtagacs(),dto.getDomAcsQhw(),dto.getEnAcsRinno(),dto.getRendImpEtag(),dto.getDomAcsQhwSu(),dto.getIndGlobEplordo(),dto.getDomAcsQhwto(),dto.getFlgFabbAcs(),dto.getFkMotivo(),dto.getMetodologiaCalcolo(),dto.getSwUtilizzato(),dto.getDescIndirizzo(),dto.getNumCivico(),dto.getSezione(),dto.getFoglio(),dto.getParticella(),dto.getSubalterno(),dto.getIdProv(),dto.getIdComune(),dto.getFkTipoImpianto(),dto.getFkCombustibileRisc(),dto.getFkCombustibileAcs(),dto.getFkClasse19205(),dto.getDomRiscQh(),dto.getIndRiscEpi(),dto.getFabbAcs(),dto.getIndGlobEplordoTo(),dto.getPrestazioneEne(),dto.getNumAppartamenti(),dto.getUiServite(),dto.getPotRiscaldamento(),dto.getFkClasseEffRisc(),dto.getGenAnnoRisc(),dto.getFlgContRip(),dto.getRendGener(),dto.getRendRegol(),dto.getRendEmiss(),dto.getRendDistrib(),dto.getDomRiscQhto(),dto.getFkCarattEdificio(),dto.getFlgOld(),dto.getFlgEdifE0(),dto.getEpglNrenGlobale(),dto.getEpglRenGlobale(),dto.getEmissioniCo2(),dto.getSupRaffrescata(),dto.getSupRiscaldata(),dto.getVolLordoRaffrescato(),dto.getEph(),dto.getAsolAsup(),dto.getYie(),dto.getVSuRaff(),dto.getVSuRisc(),dto.getSVRaff(),dto.getSVRisc(),dto.getDtScadenza(),pk.getAnno(),pk.getIdCertificatore(),pk.getProgrCertificato());
	}

	/** 
	 * Deletes a single row in the SICEE_T_EXPORT_BO table.
	 */
	
	public void delete(SiceeTExportBoPk pk) throws SiceeTExportBoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ANNO = ? AND ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ?",pk.getAnno(),pk.getIdCertificatore(),pk.getProgrCertificato());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTExportBo
	 */
	public SiceeTExportBo mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTExportBo dto = new SiceeTExportBo();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setDtInizio( rs.getTimestamp(4 ) );
		dto.setDtUpload( rs.getTimestamp(5 ) );
		dto.setDescProv( rs.getString( 6 ) );
		dto.setDescComune( rs.getString( 7 ) );
		dto.setGradiGiorno( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setGradiGiorno( null );
		}
		
		dto.setPiano( new Integer( rs.getInt(9) ) );
		if (rs.wasNull()) {
			dto.setPiano( null );
		}
		
		dto.setNumPianiComplessivi( new Integer( rs.getInt(10) ) );
		if (rs.wasNull()) {
			dto.setNumPianiComplessivi( null );
		}
		
		dto.setFkStato( new Integer( rs.getInt(11) ) );
		if (rs.wasNull()) {
			dto.setFkStato( null );
		}
		
		dto.setFkDestUso( new Integer( rs.getInt(12) ) );
		if (rs.wasNull()) {
			dto.setFkDestUso( null );
		}
		
		dto.setDescTipoEdificio( rs.getString( 13 ) );
		dto.setFkClasse( new Integer( rs.getInt(14) ) );
		if (rs.wasNull()) {
			dto.setFkClasse( null );
		}
		
		dto.setAnnoCostruzione( new Integer( rs.getInt(15) ) );
		if (rs.wasNull()) {
			dto.setAnnoCostruzione( null );
		}
		
		dto.setAnnoUltRist( new Integer( rs.getInt(16) ) );
		if (rs.wasNull()) {
			dto.setAnnoUltRist( null );
		}
		
		dto.setVolLordoRiscaldato( new Double( rs.getDouble(17) ) );
		if (rs.wasNull()) {
			dto.setVolLordoRiscaldato( null );
		}
		
		dto.setSupDisperdenteTot( new Double( rs.getDouble(18) ) );
		if (rs.wasNull()) {
			dto.setSupDisperdenteTot( null );
		}
		
		dto.setSu( new Double( rs.getDouble(19) ) );
		if (rs.wasNull()) {
			dto.setSu( null );
		}
		
		dto.setTrasmOpache( new Double( rs.getDouble(20) ) );
		if (rs.wasNull()) {
			dto.setTrasmOpache( null );
		}
		
		dto.setTrasmTrasp( new Double( rs.getDouble(21) ) );
		if (rs.wasNull()) {
			dto.setTrasmTrasp( null );
		}
		
		dto.setFattoreForma( new Double( rs.getDouble(22) ) );
		if (rs.wasNull()) {
			dto.setFattoreForma( null );
		}
		
		dto.setVSu( new Double( rs.getDouble(23) ) );
		if (rs.wasNull()) {
			dto.setVSu( null );
		}
		
		dto.setIndRiscEpito( new Double( rs.getDouble(24) ) );
		if (rs.wasNull()) {
			dto.setIndRiscEpito( null );
		}
		
		dto.setFlgFabbMaxIndice( rs.getString( 25 ) );
		dto.setValorePrestPdc( new Double( rs.getDouble(26) ) );
		if (rs.wasNull()) {
			dto.setValorePrestPdc( null );
		}
		
		dto.setRendAcsEtagacs( new Double( rs.getDouble(27) ) );
		if (rs.wasNull()) {
			dto.setRendAcsEtagacs( null );
		}
		
		dto.setDomAcsQhw( new Double( rs.getDouble(28) ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhw( null );
		}
		
		dto.setEnAcsRinno( new Double( rs.getDouble(29) ) );
		if (rs.wasNull()) {
			dto.setEnAcsRinno( null );
		}
		
		dto.setRendImpEtag( new Double( rs.getDouble(30) ) );
		if (rs.wasNull()) {
			dto.setRendImpEtag( null );
		}
		
		dto.setDomAcsQhwSu( new Double( rs.getDouble(31) ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhwSu( null );
		}
		
		dto.setIndGlobEplordo( new Double( rs.getDouble(32) ) );
		if (rs.wasNull()) {
			dto.setIndGlobEplordo( null );
		}
		
		dto.setDomAcsQhwto( new Double( rs.getDouble(33) ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhwto( null );
		}
		
		dto.setFlgFabbAcs( rs.getString( 34 ) );
		dto.setFkMotivo( new Integer( rs.getInt(35) ) );
		if (rs.wasNull()) {
			dto.setFkMotivo( null );
		}
		
		dto.setMetodologiaCalcolo( rs.getString( 36 ) );
		dto.setSwUtilizzato( rs.getString( 37 ) );
		dto.setDescIndirizzo( rs.getString( 38 ) );
		dto.setNumCivico( rs.getString( 39 ) );
		dto.setSezione( rs.getString( 40 ) );
		dto.setFoglio( rs.getString( 41 ) );
		dto.setParticella( rs.getString( 42 ) );
		dto.setSubalterno( rs.getString( 43 ) );
		dto.setIdProv( rs.getString( 44 ) );
		dto.setIdComune( rs.getString( 45 ) );
		dto.setFkTipoImpianto( new Integer( rs.getInt(46) ) );
		if (rs.wasNull()) {
			dto.setFkTipoImpianto( null );
		}
		
		dto.setFkCombustibileRisc( new Integer( rs.getInt(47) ) );
		if (rs.wasNull()) {
			dto.setFkCombustibileRisc( null );
		}
		
		dto.setFkCombustibileAcs( new Integer( rs.getInt(48) ) );
		if (rs.wasNull()) {
			dto.setFkCombustibileAcs( null );
		}
		
		dto.setFkClasse19205( new Integer( rs.getInt(49) ) );
		if (rs.wasNull()) {
			dto.setFkClasse19205( null );
		}
		
		dto.setDomRiscQh( new Double( rs.getDouble(50) ) );
		if (rs.wasNull()) {
			dto.setDomRiscQh( null );
		}
		
		dto.setIndRiscEpi( new Double( rs.getDouble(51) ) );
		if (rs.wasNull()) {
			dto.setIndRiscEpi( null );
		}
		
		dto.setFabbAcs( new Double( rs.getDouble(52) ) );
		if (rs.wasNull()) {
			dto.setFabbAcs( null );
		}
		
		dto.setIndGlobEplordoTo( new Double( rs.getDouble(53) ) );
		if (rs.wasNull()) {
			dto.setIndGlobEplordoTo( null );
		}
		
		dto.setPrestazioneEne( new Double( rs.getDouble(54) ) );
		if (rs.wasNull()) {
			dto.setPrestazioneEne( null );
		}
		
		dto.setNumAppartamenti( new Integer( rs.getInt(55) ) );
		if (rs.wasNull()) {
			dto.setNumAppartamenti( null );
		}
		
		dto.setUiServite( rs.getString( 56 ) );
		dto.setPotRiscaldamento( new Double( rs.getDouble(57) ) );
		if (rs.wasNull()) {
			dto.setPotRiscaldamento( null );
		}
		
		dto.setFkClasseEffRisc( new Integer( rs.getInt(58) ) );
		if (rs.wasNull()) {
			dto.setFkClasseEffRisc( null );
		}
		
		dto.setGenAnnoRisc( new Integer( rs.getInt(59) ) );
		if (rs.wasNull()) {
			dto.setGenAnnoRisc( null );
		}
		
		dto.setFlgContRip( rs.getString( 60 ) );
		dto.setRendGener( new Double( rs.getDouble(61) ) );
		if (rs.wasNull()) {
			dto.setRendGener( null );
		}
		
		dto.setRendRegol( new Double( rs.getDouble(62) ) );
		if (rs.wasNull()) {
			dto.setRendRegol( null );
		}
		
		dto.setRendEmiss( new Double( rs.getDouble(63) ) );
		if (rs.wasNull()) {
			dto.setRendEmiss( null );
		}
		
		dto.setRendDistrib( new Double( rs.getDouble(64) ) );
		if (rs.wasNull()) {
			dto.setRendDistrib( null );
		}
		
		dto.setDomRiscQhto( new Double( rs.getDouble(65) ) );
		if (rs.wasNull()) {
			dto.setDomRiscQhto( null );
		}
		
		dto.setFkCarattEdificio( new Integer( rs.getInt(66) ) );
		if (rs.wasNull()) {
			dto.setFkCarattEdificio( null );
		}
		
		dto.setFlgOld( rs.getString( 67 ) );
		dto.setFlgEdifE0( rs.getString( 68 ) );
		dto.setEpglNrenGlobale( new Double( rs.getDouble(69) ) );
		if (rs.wasNull()) {
			dto.setEpglNrenGlobale( null );
		}
		
		dto.setEpglRenGlobale( new Double( rs.getDouble(70) ) );
		if (rs.wasNull()) {
			dto.setEpglRenGlobale( null );
		}
		
		dto.setEmissioniCo2( new Double( rs.getDouble(71) ) );
		if (rs.wasNull()) {
			dto.setEmissioniCo2( null );
		}
		
		dto.setSupRaffrescata( new Double( rs.getDouble(72) ) );
		if (rs.wasNull()) {
			dto.setSupRaffrescata( null );
		}
		
		dto.setSupRiscaldata( new Double( rs.getDouble(73) ) );
		if (rs.wasNull()) {
			dto.setSupRiscaldata( null );
		}
		
		dto.setVolLordoRaffrescato( new Double( rs.getDouble(74) ) );
		if (rs.wasNull()) {
			dto.setVolLordoRaffrescato( null );
		}
		
		dto.setEph( new Double( rs.getDouble(75) ) );
		if (rs.wasNull()) {
			dto.setEph( null );
		}
		
		dto.setAsolAsup( new Double( rs.getDouble(76) ) );
		if (rs.wasNull()) {
			dto.setAsolAsup( null );
		}
		
		dto.setYie( new Double( rs.getDouble(77) ) );
		if (rs.wasNull()) {
			dto.setYie( null );
		}
		
		dto.setVSuRaff( new Double( rs.getDouble(78) ) );
		if (rs.wasNull()) {
			dto.setVSuRaff( null );
		}
		
		dto.setVSuRisc( new Double( rs.getDouble(79) ) );
		if (rs.wasNull()) {
			dto.setVSuRisc( null );
		}
		
		dto.setSVRaff( new Double( rs.getDouble(80) ) );
		if (rs.wasNull()) {
			dto.setSVRaff( null );
		}
		
		dto.setSVRisc( new Double( rs.getDouble(81) ) );
		if (rs.wasNull()) {
			dto.setSVRisc( null );
		}
		
		dto.setDtScadenza( rs.getTimestamp(82 ) );
		
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_EXPORT_BO";
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO = :anno AND ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public SiceeTExportBo findByPrimaryKey(String anno, String idCertificatore, String progrCertificato) throws SiceeTExportBoDaoException
	{
		try {
			List<SiceeTExportBo> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ANNO = ? AND ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ?", this,anno,idCertificatore,progrCertificato);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_EDIFICIO = :fkEdificio'.
	 */
	
	public List<SiceeTExportBo> findWhereFkEdificioEquals(Integer fkEdificio) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_EDIFICIO = ? ORDER BY FK_EDIFICIO", this,fkEdificio);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria ''.
	 */
	
	public List<SiceeTExportBo> findAll() throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " ORDER BY ANNO, ID_CERTIFICATORE, PROGR_CERTIFICATO", this);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTExportBo> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTExportBo> findWhereAnnoEquals(String anno) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTExportBo> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTExportBo> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_STATO = :fkStato'.
	 */
	
	public List<SiceeTExportBo> findWhereFkStatoEquals(Integer fkStato) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_STATO = ? ORDER BY FK_STATO", this,fkStato);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DT_INIZIO = :dtInizio'.
	 */
	
	public List<SiceeTExportBo> findWhereDtInizioEquals(Date dtInizio) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DT_INIZIO = ? ORDER BY DT_INIZIO", this,dtInizio);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DT_UPLOAD = :dtUpload'.
	 */
	
	public List<SiceeTExportBo> findWhereDtUploadEquals(Date dtUpload) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DT_UPLOAD = ? ORDER BY DT_UPLOAD", this,dtUpload);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_PROV = :descProv'.
	 */
	
	public List<SiceeTExportBo> findWhereDescProvEquals(String descProv) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DESC_PROV = ? ORDER BY DESC_PROV", this,descProv);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_PROV = :idProv'.
	 */
	
	public List<SiceeTExportBo> findWhereIdProvEquals(String idProv) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ID_PROV = ? ORDER BY ID_PROV", this,idProv);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	
	public List<SiceeTExportBo> findWhereDescComuneEquals(String descComune) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DESC_COMUNE = ? ORDER BY DESC_COMUNE", this,descComune);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public List<SiceeTExportBo> findWhereIdComuneEquals(String idComune) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	
	public List<SiceeTExportBo> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DESC_INDIRIZZO = ? ORDER BY DESC_INDIRIZZO", this,descIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	
	public List<SiceeTExportBo> findWhereNumCivicoEquals(String numCivico) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE NUM_CIVICO = ? ORDER BY NUM_CIVICO", this,numCivico);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SEZIONE = :sezione'.
	 */
	
	public List<SiceeTExportBo> findWhereSezioneEquals(String sezione) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE SEZIONE = ? ORDER BY SEZIONE", this,sezione);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FOGLIO = :foglio'.
	 */
	
	public List<SiceeTExportBo> findWhereFoglioEquals(String foglio) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FOGLIO = ? ORDER BY FOGLIO", this,foglio);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PARTICELLA = :particella'.
	 */
	
	public List<SiceeTExportBo> findWhereParticellaEquals(String particella) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE PARTICELLA = ? ORDER BY PARTICELLA", this,particella);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUBALTERNO = :subalterno'.
	 */
	
	public List<SiceeTExportBo> findWhereSubalternoEquals(String subalterno) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE SUBALTERNO = ? ORDER BY SUBALTERNO", this,subalterno);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'GRADI_GIORNO = :gradiGiorno'.
	 */
	
	public List<SiceeTExportBo> findWhereGradiGiornoEquals(Integer gradiGiorno) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE GRADI_GIORNO = ? ORDER BY GRADI_GIORNO", this,gradiGiorno);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PIANO = :piano'.
	 */
	
	public List<SiceeTExportBo> findWherePianoEquals(Integer piano) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE PIANO = ? ORDER BY PIANO", this,piano);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'NUM_PIANI_COMPLESSIVI = :numPianiComplessivi'.
	 */
	
	public List<SiceeTExportBo> findWhereNumPianiComplessiviEquals(Integer numPianiComplessivi) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE NUM_PIANI_COMPLESSIVI = ? ORDER BY NUM_PIANI_COMPLESSIVI", this,numPianiComplessivi);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_DEST_USO = :fkDestUso'.
	 */
	
	public List<SiceeTExportBo> findWhereFkDestUsoEquals(Integer fkDestUso) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_DEST_USO = ? ORDER BY FK_DEST_USO", this,fkDestUso);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CARATT_EDIFICIO = :fkCarattEdificio'.
	 */
	
	public List<SiceeTExportBo> findWhereFkCarattEdificioEquals(Integer fkCarattEdificio) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_CARATT_EDIFICIO = ? ORDER BY FK_CARATT_EDIFICIO", this,fkCarattEdificio);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_TIPO_EDIFICIO = :descTipoEdificio'.
	 */
	
	public List<SiceeTExportBo> findWhereDescTipoEdificioEquals(String descTipoEdificio) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DESC_TIPO_EDIFICIO = ? ORDER BY DESC_TIPO_EDIFICIO", this,descTipoEdificio);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO_COSTRUZIONE = :annoCostruzione'.
	 */
	
	public List<SiceeTExportBo> findWhereAnnoCostruzioneEquals(Integer annoCostruzione) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ANNO_COSTRUZIONE = ? ORDER BY ANNO_COSTRUZIONE", this,annoCostruzione);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO_ULT_RIST = :annoUltRist'.
	 */
	
	public List<SiceeTExportBo> findWhereAnnoUltRistEquals(Integer annoUltRist) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ANNO_ULT_RIST = ? ORDER BY ANNO_ULT_RIST", this,annoUltRist);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'VOL_LORDO_RISCALDATO = :volLordoRiscaldato'.
	 */
	
	public List<SiceeTExportBo> findWhereVolLordoRiscaldatoEquals(Double volLordoRiscaldato) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE VOL_LORDO_RISCALDATO = ? ORDER BY VOL_LORDO_RISCALDATO", this,volLordoRiscaldato);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUP_DISPERDENTE_TOT = :supDisperdenteTot'.
	 */
	
	public List<SiceeTExportBo> findWhereSupDisperdenteTotEquals(Double supDisperdenteTot) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE SUP_DISPERDENTE_TOT = ? ORDER BY SUP_DISPERDENTE_TOT", this,supDisperdenteTot);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SU = :su'.
	 */
	
	public List<SiceeTExportBo> findWhereSuEquals(Double su) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE SU = ? ORDER BY SU", this,su);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'V_SU = :vSu'.
	 */
	
	public List<SiceeTExportBo> findWhereVSuEquals(Double vSu) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE V_SU = ? ORDER BY V_SU", this,vSu);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FATTORE_FORMA = :fattoreForma'.
	 */
	
	public List<SiceeTExportBo> findWhereFattoreFormaEquals(Double fattoreForma) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FATTORE_FORMA = ? ORDER BY FATTORE_FORMA", this,fattoreForma);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'TRASM_OPACHE = :trasmOpache'.
	 */
	
	public List<SiceeTExportBo> findWhereTrasmOpacheEquals(Double trasmOpache) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE TRASM_OPACHE = ? ORDER BY TRASM_OPACHE", this,trasmOpache);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'TRASM_TRASP = :trasmTrasp'.
	 */
	
	public List<SiceeTExportBo> findWhereTrasmTraspEquals(Double trasmTrasp) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE TRASM_TRASP = ? ORDER BY TRASM_TRASP", this,trasmTrasp);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_TIPO_IMPIANTO = :fkTipoImpianto'.
	 */
	
	public List<SiceeTExportBo> findWhereFkTipoImpiantoEquals(Integer fkTipoImpianto) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_TIPO_IMPIANTO = ? ORDER BY FK_TIPO_IMPIANTO", this,fkTipoImpianto);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_COMBUSTIBILE_RISC = :fkCombustibileRisc'.
	 */
	
	public List<SiceeTExportBo> findWhereFkCombustibileRiscEquals(Integer fkCombustibileRisc) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_COMBUSTIBILE_RISC = ? ORDER BY FK_COMBUSTIBILE_RISC", this,fkCombustibileRisc);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_COMBUSTIBILE_ACS = :fkCombustibileAcs'.
	 */
	
	public List<SiceeTExportBo> findWhereFkCombustibileAcsEquals(Integer fkCombustibileAcs) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_COMBUSTIBILE_ACS = ? ORDER BY FK_COMBUSTIBILE_ACS", this,fkCombustibileAcs);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CLASSE = :fkClasse'.
	 */
	
	public List<SiceeTExportBo> findWhereFkClasseEquals(Integer fkClasse) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_CLASSE = ? ORDER BY FK_CLASSE", this,fkClasse);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CLASSE_192_05 = :fkClasse19205'.
	 */
	
	public List<SiceeTExportBo> findWhereFkClasse19205Equals(Integer fkClasse19205) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_CLASSE_192_05 = ? ORDER BY FK_CLASSE_192_05", this,fkClasse19205);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_RISC_QH = :domRiscQh'.
	 */
	
	public List<SiceeTExportBo> findWhereDomRiscQhEquals(Double domRiscQh) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DOM_RISC_QH = ? ORDER BY DOM_RISC_QH", this,domRiscQh);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_RISC_QHTO = :domRiscQhto'.
	 */
	
	public List<SiceeTExportBo> findWhereDomRiscQhtoEquals(Double domRiscQhto) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DOM_RISC_QHTO = ? ORDER BY DOM_RISC_QHTO", this,domRiscQhto);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_ACS_QHW = :domAcsQhw'.
	 */
	
	public List<SiceeTExportBo> findWhereDomAcsQhwEquals(Double domAcsQhw) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DOM_ACS_QHW = ? ORDER BY DOM_ACS_QHW", this,domAcsQhw);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_ACS_QHWTO = :domAcsQhwto'.
	 */
	
	public List<SiceeTExportBo> findWhereDomAcsQhwtoEquals(Double domAcsQhwto) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DOM_ACS_QHWTO = ? ORDER BY DOM_ACS_QHWTO", this,domAcsQhwto);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_FABB_ACS = :flgFabbAcs'.
	 */
	
	public List<SiceeTExportBo> findWhereFlgFabbAcsEquals(String flgFabbAcs) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FLG_FABB_ACS = ? ORDER BY FLG_FABB_ACS", this,flgFabbAcs);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EN_ACS_RINNO = :enAcsRinno'.
	 */
	
	public List<SiceeTExportBo> findWhereEnAcsRinnoEquals(Double enAcsRinno) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE EN_ACS_RINNO = ? ORDER BY EN_ACS_RINNO", this,enAcsRinno);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_ACS_QHW_SU = :domAcsQhwSu'.
	 */
	
	public List<SiceeTExportBo> findWhereDomAcsQhwSuEquals(Double domAcsQhwSu) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE DOM_ACS_QHW_SU = ? ORDER BY DOM_ACS_QHW_SU", this,domAcsQhwSu);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_IMP_ETAG = :rendImpEtag'.
	 */
	
	public List<SiceeTExportBo> findWhereRendImpEtagEquals(Double rendImpEtag) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE REND_IMP_ETAG = ? ORDER BY REND_IMP_ETAG", this,rendImpEtag);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_ACS_ETAGACS = :rendAcsEtagacs'.
	 */
	
	public List<SiceeTExportBo> findWhereRendAcsEtagacsEquals(Double rendAcsEtagacs) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE REND_ACS_ETAGACS = ? ORDER BY REND_ACS_ETAGACS", this,rendAcsEtagacs);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'VALORE_PREST_PDC = :valorePrestPdc'.
	 */
	
	public List<SiceeTExportBo> findWhereValorePrestPdcEquals(Double valorePrestPdc) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE VALORE_PREST_PDC = ? ORDER BY VALORE_PREST_PDC", this,valorePrestPdc);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_RISC_EPI = :indRiscEpi'.
	 */
	
	public List<SiceeTExportBo> findWhereIndRiscEpiEquals(Double indRiscEpi) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE IND_RISC_EPI = ? ORDER BY IND_RISC_EPI", this,indRiscEpi);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_RISC_EPITO = :indRiscEpito'.
	 */
	
	public List<SiceeTExportBo> findWhereIndRiscEpitoEquals(Double indRiscEpito) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE IND_RISC_EPITO = ? ORDER BY IND_RISC_EPITO", this,indRiscEpito);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_FABB_MAX_INDICE = :flgFabbMaxIndice'.
	 */
	
	public List<SiceeTExportBo> findWhereFlgFabbMaxIndiceEquals(String flgFabbMaxIndice) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FLG_FABB_MAX_INDICE = ? ORDER BY FLG_FABB_MAX_INDICE", this,flgFabbMaxIndice);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FABB_ACS = :fabbAcs'.
	 */
	
	public List<SiceeTExportBo> findWhereFabbAcsEquals(Double fabbAcs) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FABB_ACS = ? ORDER BY FABB_ACS", this,fabbAcs);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_GLOB_EPLORDO = :indGlobEplordo'.
	 */
	
	public List<SiceeTExportBo> findWhereIndGlobEplordoEquals(Double indGlobEplordo) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE IND_GLOB_EPLORDO = ? ORDER BY IND_GLOB_EPLORDO", this,indGlobEplordo);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_GLOB_EPLORDO_TO = :indGlobEplordoTo'.
	 */
	
	public List<SiceeTExportBo> findWhereIndGlobEplordoToEquals(Double indGlobEplordoTo) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE IND_GLOB_EPLORDO_TO = ? ORDER BY IND_GLOB_EPLORDO_TO", this,indGlobEplordoTo);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_MOTIVO = :fkMotivo'.
	 */
	
	public List<SiceeTExportBo> findWhereFkMotivoEquals(Integer fkMotivo) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_MOTIVO = ? ORDER BY FK_MOTIVO", this,fkMotivo);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'METODOLOGIA_CALCOLO = :metodologiaCalcolo'.
	 */
	
	public List<SiceeTExportBo> findWhereMetodologiaCalcoloEquals(String metodologiaCalcolo) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE METODOLOGIA_CALCOLO = ? ORDER BY METODOLOGIA_CALCOLO", this,metodologiaCalcolo);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SW_UTILIZZATO = :swUtilizzato'.
	 */
	
	public List<SiceeTExportBo> findWhereSwUtilizzatoEquals(String swUtilizzato) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE SW_UTILIZZATO = ? ORDER BY SW_UTILIZZATO", this,swUtilizzato);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PRESTAZIONE_ENE = :prestazioneEne'.
	 */
	
	public List<SiceeTExportBo> findWherePrestazioneEneEquals(Double prestazioneEne) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE PRESTAZIONE_ENE = ? ORDER BY PRESTAZIONE_ENE", this,prestazioneEne);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'NUM_APPARTAMENTI = :numAppartamenti'.
	 */
	
	public List<SiceeTExportBo> findWhereNumAppartamentiEquals(Integer numAppartamenti) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE NUM_APPARTAMENTI = ? ORDER BY NUM_APPARTAMENTI", this,numAppartamenti);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'UI_SERVITE = :uiServite'.
	 */
	
	public List<SiceeTExportBo> findWhereUiServiteEquals(String uiServite) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE UI_SERVITE = ? ORDER BY UI_SERVITE", this,uiServite);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'POT_RISCALDAMENTO = :potRiscaldamento'.
	 */
	
	public List<SiceeTExportBo> findWherePotRiscaldamentoEquals(Double potRiscaldamento) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE POT_RISCALDAMENTO = ? ORDER BY POT_RISCALDAMENTO", this,potRiscaldamento);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CLASSE_EFF_RISC = :fkClasseEffRisc'.
	 */
	
	public List<SiceeTExportBo> findWhereFkClasseEffRiscEquals(Integer fkClasseEffRisc) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FK_CLASSE_EFF_RISC = ? ORDER BY FK_CLASSE_EFF_RISC", this,fkClasseEffRisc);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'GEN_ANNO_RISC = :genAnnoRisc'.
	 */
	
	public List<SiceeTExportBo> findWhereGenAnnoRiscEquals(Integer genAnnoRisc) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE GEN_ANNO_RISC = ? ORDER BY GEN_ANNO_RISC", this,genAnnoRisc);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_CONT_RIP = :flgContRip'.
	 */
	
	public List<SiceeTExportBo> findWhereFlgContRipEquals(String flgContRip) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FLG_CONT_RIP = ? ORDER BY FLG_CONT_RIP", this,flgContRip);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_GENER = :rendGener'.
	 */
	
	public List<SiceeTExportBo> findWhereRendGenerEquals(Double rendGener) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE REND_GENER = ? ORDER BY REND_GENER", this,rendGener);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_REGOL = :rendRegol'.
	 */
	
	public List<SiceeTExportBo> findWhereRendRegolEquals(Double rendRegol) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE REND_REGOL = ? ORDER BY REND_REGOL", this,rendRegol);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_EMISS = :rendEmiss'.
	 */
	
	public List<SiceeTExportBo> findWhereRendEmissEquals(Double rendEmiss) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE REND_EMISS = ? ORDER BY REND_EMISS", this,rendEmiss);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_DISTRIB = :rendDistrib'.
	 */
	
	public List<SiceeTExportBo> findWhereRendDistribEquals(Double rendDistrib) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE REND_DISTRIB = ? ORDER BY REND_DISTRIB", this,rendDistrib);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_OLD = :flgOld'.
	 */
	
	public List<SiceeTExportBo> findWhereFlgOldEquals(String flgOld) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FLG_OLD = ? ORDER BY FLG_OLD", this,flgOld);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_EDIF_E0 = :flgEdifE0'.
	 */
	
	public List<SiceeTExportBo> findWhereFlgEdifE0Equals(String flgEdifE0) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE FLG_EDIF_E0 = ? ORDER BY FLG_EDIF_E0", this,flgEdifE0);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EPGL_NREN_GLOBALE = :epglNrenGlobale'.
	 */
	
	public List<SiceeTExportBo> findWhereEpglNrenGlobaleEquals(Double epglNrenGlobale) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE EPGL_NREN_GLOBALE = ? ORDER BY EPGL_NREN_GLOBALE", this,epglNrenGlobale);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EPGL_REN_GLOBALE = :epglRenGlobale'.
	 */
	
	public List<SiceeTExportBo> findWhereEpglRenGlobaleEquals(Double epglRenGlobale) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE EPGL_REN_GLOBALE = ? ORDER BY EPGL_REN_GLOBALE", this,epglRenGlobale);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EMISSIONI_CO2 = :emissioniCo2'.
	 */
	
	public List<SiceeTExportBo> findWhereEmissioniCo2Equals(Double emissioniCo2) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE EMISSIONI_CO2 = ? ORDER BY EMISSIONI_CO2", this,emissioniCo2);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUP_RAFFRESCATA = :supRaffrescata'.
	 */
	
	public List<SiceeTExportBo> findWhereSupRaffrescataEquals(Double supRaffrescata) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE SUP_RAFFRESCATA = ? ORDER BY SUP_RAFFRESCATA", this,supRaffrescata);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUP_RISCALDATA = :supRiscaldata'.
	 */
	
	public List<SiceeTExportBo> findWhereSupRiscaldataEquals(Double supRiscaldata) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE SUP_RISCALDATA = ? ORDER BY SUP_RISCALDATA", this,supRiscaldata);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'VOL_LORDO_RAFFRESCATO = :volLordoRaffrescato'.
	 */
	
	public List<SiceeTExportBo> findWhereVolLordoRaffrescatoEquals(Double volLordoRaffrescato) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE VOL_LORDO_RAFFRESCATO = ? ORDER BY VOL_LORDO_RAFFRESCATO", this,volLordoRaffrescato);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EPH = :eph'.
	 */
	
	public List<SiceeTExportBo> findWhereEphEquals(Double eph) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE EPH = ? ORDER BY EPH", this,eph);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ASOL_ASUP = :asolAsup'.
	 */
	
	public List<SiceeTExportBo> findWhereAsolAsupEquals(Double asolAsup) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE ASOL_ASUP = ? ORDER BY ASOL_ASUP", this,asolAsup);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'YIE = :yie'.
	 */
	
	public List<SiceeTExportBo> findWhereYieEquals(Double yie) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE YIE = ? ORDER BY YIE", this,yie);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'V_SU_RAFF = :vSuRaff'.
	 */
	
	public List<SiceeTExportBo> findWhereVSuRaffEquals(Double vSuRaff) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE V_SU_RAFF = ? ORDER BY V_SU_RAFF", this,vSuRaff);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'V_SU_RISC = :vSuRisc'.
	 */
	
	public List<SiceeTExportBo> findWhereVSuRiscEquals(Double vSuRisc) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE V_SU_RISC = ? ORDER BY V_SU_RISC", this,vSuRisc);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'S_V_RAFF = :sVRaff'.
	 */
	
	public List<SiceeTExportBo> findWhereSVRaffEquals(Double sVRaff) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE S_V_RAFF = ? ORDER BY S_V_RAFF", this,sVRaff);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'S_V_RISC = :sVRisc'.
	 */
	
	public List<SiceeTExportBo> findWhereSVRiscEquals(Double sVRisc) throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO, ID_PROV, ID_COMUNE, FK_TIPO_IMPIANTO, FK_COMBUSTIBILE_RISC, FK_COMBUSTIBILE_ACS, FK_CLASSE_192_05, DOM_RISC_QH, IND_RISC_EPI, FABB_ACS, IND_GLOB_EPLORDO_TO, PRESTAZIONE_ENE, NUM_APPARTAMENTI, UI_SERVITE, POT_RISCALDAMENTO, FK_CLASSE_EFF_RISC, GEN_ANNO_RISC, FLG_CONT_RIP, REND_GENER, REND_REGOL, REND_EMISS, REND_DISTRIB, DOM_RISC_QHTO, FK_CARATT_EDIFICIO, FLG_OLD, FLG_EDIF_E0, EPGL_NREN_GLOBALE, EPGL_REN_GLOBALE, EMISSIONI_CO2, SUP_RAFFRESCATA, SUP_RISCALDATA, VOL_LORDO_RAFFRESCATO, EPH, ASOL_ASUP, YIE, V_SU_RAFF, V_SU_RISC, S_V_RAFF, S_V_RISC, DT_SCADENZA FROM " + getTableName() + " WHERE S_V_RISC = ? ORDER BY S_V_RISC", this,sVRisc);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_EXPORT_BO table that matches the specified primary-key value.
	 */
	public SiceeTExportBo findByPrimaryKey(SiceeTExportBoPk pk) throws SiceeTExportBoDaoException
	{
		return findByPrimaryKey( pk.getAnno(), pk.getIdCertificatore(), pk.getProgrCertificato() );
	}

}
