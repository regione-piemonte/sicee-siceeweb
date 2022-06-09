/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertificatoDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTCertificatoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTCertificato>, SiceeTCertificatoDao
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
	 * @return SiceeTCertificatoPk
	 */
	
	public SiceeTCertificatoPk insert(SiceeTCertificato dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDtScadenza(),dto.getFkTransazioneAce(),dto.getDtAcquisto(),dto.getFkStato(),dto.getFkDichiarazione(),dto.getFlgDichiarazione(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getDtInizio(),dto.getCap(),dto.getIdComune(),dto.getDescComune(),dto.getSezione(),dto.getIdProv(),dto.getFoglio(),dto.getDescProv(),dto.getIdRegione(),dto.getParticella(),dto.getSubalterno(),dto.getDescRegione(),dto.getPiano(),dto.getNumPianiComplessivi(),dto.getNumAppartamenti(),dto.getScala(),dto.getInterno(),dto.getNote(),dto.getFlgStampaDef(),dto.getNomeAceFirmato(),dto.getNomeCocertificatore(),dto.getCognomeCocertificatore(),dto.getNumCocertificatore(),dto.getCodFiscCocertificatore(),dto.getNumCivico(),dto.getIdentificPdf(),dto.getIdentificFoto(),dto.getLuogoDichiarazione(),dto.getNomeFoto(),dto.getNomePdf(),dto.getDtUpload(),dto.getFlgEdificioPerformante(),dto.getFlgSigmater(),dto.getFkMotivoSost(),dto.getDtSostituzione(),dto.getNoteSostituzione(),dto.getDtFoto(),dto.getFlgOld(),dto.isCoordNNull()?null:dto.getCoordN(),dto.isCoordENull()?null:dto.getCoordE(),dto.getFlgNoRaccomand(),dto.getRifCatasto(),dto.getCodiceComuneCatastale(),dto.getFkScadenzaCert(),dto.getNumPianiFTRisc(),dto.getCfUtenteSostituzione(), dto.getCoordXLongDd(), dto.getCoordYLatDd());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_CERTIFICATO table.
	 */
	
	public void update(SiceeTCertificatoPk pk, SiceeTCertificato dto) throws SiceeTCertificatoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, DT_SCADENZA = ?, FK_TRANSAZIONE_ACE = ?, DT_ACQUISTO = ?, FK_STATO = ?, FK_DICHIARAZIONE = ?, FLG_DICHIARAZIONE = ?, ID_INDIRIZZO = ?, DESC_INDIRIZZO = ?, DT_INIZIO = ?, CAP = ?, ID_COMUNE = ?, DESC_COMUNE = ?, SEZIONE = ?, ID_PROV = ?, FOGLIO = ?, DESC_PROV = ?, ID_REGIONE = ?, PARTICELLA = ?, SUBALTERNO = ?, DESC_REGIONE = ?, PIANO = ?, NUM_PIANI_COMPLESSIVI = ?, NUM_APPARTAMENTI = ?, SCALA = ?, INTERNO = ?, NOTE = ?, FLG_STAMPA_DEF = ?, NOME_ACE_FIRMATO = ?, NOME_COCERTIFICATORE = ?, COGNOME_COCERTIFICATORE = ?, NUM_COCERTIFICATORE = ?, COD_FISC_COCERTIFICATORE = ?, NUM_CIVICO = ?, IDENTIFIC_PDF = ?, IDENTIFIC_FOTO = ?, LUOGO_DICHIARAZIONE = ?, NOME_FOTO = ?, NOME_PDF = ?, DT_UPLOAD = ?, FLG_EDIFICIO_PERFORMANTE = ?, FLG_SIGMATER = ?, FK_MOTIVO_SOST = ?, DT_SOSTITUZIONE = ?, NOTE_SOSTITUZIONE = ?, DT_FOTO = ?, FLG_OLD = ?, COORD_N = ?, COORD_E = ?, FLG_NO_RACCOMAND = ?, RIF_CATASTO = ?, CODICE_COMUNE_CATASTALE = ?, FK_SCADENZA_CERT = ?, NUM_PIANI_FT_RISC = ?, CF_UTENTE_SOSTITUZIONE = ?, COORD_X_LONG_DD = ?, COORD_Y_LAT_DD = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ? ",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDtScadenza(),dto.getFkTransazioneAce(),dto.getDtAcquisto(),dto.getFkStato(),dto.getFkDichiarazione(),dto.getFlgDichiarazione(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getDtInizio(),dto.getCap(),dto.getIdComune(),dto.getDescComune(),dto.getSezione(),dto.getIdProv(),dto.getFoglio(),dto.getDescProv(),dto.getIdRegione(),dto.getParticella(),dto.getSubalterno(),dto.getDescRegione(),dto.getPiano(),dto.getNumPianiComplessivi(),dto.getNumAppartamenti(),dto.getScala(),dto.getInterno(),dto.getNote(),dto.getFlgStampaDef(),dto.getNomeAceFirmato(),dto.getNomeCocertificatore(),dto.getCognomeCocertificatore(),dto.getNumCocertificatore(),dto.getCodFiscCocertificatore(),dto.getNumCivico(),dto.getIdentificPdf(),dto.getIdentificFoto(),dto.getLuogoDichiarazione(),dto.getNomeFoto(),dto.getNomePdf(),dto.getDtUpload(),dto.getFlgEdificioPerformante(),dto.getFlgSigmater(),dto.getFkMotivoSost(),dto.getDtSostituzione(),dto.getNoteSostituzione(),dto.getDtFoto(),dto.getFlgOld(),dto.getCoordN(),dto.getCoordE(),dto.getFlgNoRaccomand(),dto.getRifCatasto(),dto.getCodiceComuneCatastale(),dto.getFkScadenzaCert(),dto.getNumPianiFTRisc(),dto.getCfUtenteSostituzione(), dto.getCoordXLongDd(), dto.getCoordYLatDd(), pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_CERTIFICATO table.
	 */
	
	public void delete(SiceeTCertificatoPk pk) throws SiceeTCertificatoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTCertificato
	 */
	public SiceeTCertificato mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTCertificato dto = new SiceeTCertificato();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setDtScadenza( rs.getTimestamp(4 ) );
		dto.setFkTransazioneAce( rs.getLong( 5 ) );
		dto.setDtAcquisto( rs.getTimestamp(6 ) );
		dto.setFkStato( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setFkStato( null );
		}
		
		dto.setFkDichiarazione( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setFkDichiarazione( null );
		}
		
		dto.setFlgDichiarazione( rs.getString( 9 ) );
		dto.setIdIndirizzo( new Integer( rs.getInt(10) ) );
		if (rs.wasNull()) {
			dto.setIdIndirizzo( null );
		}
		
		dto.setDescIndirizzo( rs.getString( 11 ) );
		dto.setDtInizio( rs.getTimestamp(12 ) );
		dto.setCap( rs.getString( 13 ) );
		dto.setIdComune( rs.getString( 14 ) );
		dto.setDescComune( rs.getString( 15 ) );
		dto.setSezione( rs.getString( 16 ) );
		dto.setIdProv( rs.getString( 17 ) );
		dto.setFoglio( rs.getString( 18 ) );
		dto.setDescProv( rs.getString( 19 ) );
		dto.setIdRegione( rs.getString( 20 ) );
		dto.setParticella( rs.getString( 21 ) );
		dto.setSubalterno( rs.getString( 22 ) );
		dto.setDescRegione( rs.getString( 23 ) );
		dto.setPiano( new Integer( rs.getInt(24) ) );
		if (rs.wasNull()) {
			dto.setPiano( null );
		}
		
		dto.setNumPianiComplessivi( new Integer( rs.getInt(25) ) );
		if (rs.wasNull()) {
			dto.setNumPianiComplessivi( null );
		}
		
		dto.setNumAppartamenti( new Integer( rs.getInt(26) ) );
		if (rs.wasNull()) {
			dto.setNumAppartamenti( null );
		}
		
		dto.setScala( rs.getString( 27 ) );
		dto.setInterno( rs.getString( 28 ) );
		dto.setNote( rs.getString( 29 ) );
		dto.setFlgStampaDef( rs.getString( 30 ) );
		dto.setNomeAceFirmato( rs.getString( 31 ) );
		dto.setNomeCocertificatore( rs.getString( 32 ) );
		dto.setCognomeCocertificatore( rs.getString( 33 ) );
		dto.setNumCocertificatore( rs.getString( 34 ) );
		dto.setCodFiscCocertificatore( rs.getString( 35 ) );
		dto.setNumCivico( rs.getString( 36 ) );
		dto.setIdentificPdf( rs.getString( 37 ) );
		dto.setIdentificFoto( rs.getString( 38 ) );
		dto.setLuogoDichiarazione( rs.getString( 39 ) );
		dto.setNomeFoto( rs.getString( 40 ) );
		dto.setNomePdf( rs.getString( 41 ) );
		dto.setDtUpload( rs.getTimestamp(42 ) );
		dto.setFlgEdificioPerformante( rs.getString( 43 ) );
		dto.setFlgSigmater( rs.getString( 44 ) );
		dto.setFkMotivoSost( new Integer( rs.getInt(45) ) );
		if (rs.wasNull()) {
			dto.setFkMotivoSost( null );
		}
		
		dto.setDtSostituzione( rs.getTimestamp(46 ) );
		dto.setNoteSostituzione( rs.getString( 47 ) );
		dto.setDtFoto( rs.getTimestamp(48 ) );
		dto.setFlgOld( rs.getString( 49 ) );
		dto.setCoordN( rs.getDouble( 50 ) );
		if (rs.wasNull()) {
			dto.setCoordNNull( true );
		}
		
		dto.setCoordE( rs.getDouble( 51 ) );
		if (rs.wasNull()) {
			dto.setCoordENull( true );
		}
		
		dto.setFlgNoRaccomand( rs.getString( 52 ) );
		
		dto.setRifCatasto( rs.getString( 53 ) );
		dto.setCodiceComuneCatastale( rs.getString( 54 ) );
		
		dto.setFkScadenzaCert( new Integer( rs.getInt(55) ) );
		if (rs.wasNull()) {
			dto.setFkScadenzaCert( null );
		}

		dto.setNumPianiFTRisc( new Integer( rs.getInt(56) ) );
		if (rs.wasNull()) {
			dto.setNumPianiFTRisc( null );
		}
		
		dto.setCfUtenteSostituzione( rs.getString( 57 ) );

		dto.setCoordXLongDd( rs.getDouble( 58 ) );
		if (rs.wasNull()) {
			dto.setCoordXLongDd( null );
		}
		
		dto.setCoordYLatDd( rs.getDouble( 59 ) );
		if (rs.wasNull()) {
			dto.setCoordYLatDd( null );
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
		return "SICEE_T_CERTIFICATO";
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTCertificato findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTCertificatoDaoException
	{
		try {
			List<SiceeTCertificato> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_STATO = :1'.
	 * QUESTO METODO E' PER  RIPORTARE A NUOVO GLI APE IN STATO BOZZA - è un trattamento dati 
	 */
	
	public List<SiceeTCertificato> findRiportareANuovo() throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_STATO = 1 and rownum <= (SELECT VALORE FROM SICEE_T_PARAMETRI WHERE CODICE='NUMERO_MAX_ACE_TRATTAMENTO')", this);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FOTO = :foto'.
	 */
	
	public List<SiceeTCertificato> findWhereFotoEquals(byte[] foto) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FOTO = ? ORDER BY FOTO", this,foto);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ACE_FIRMATO = :aceFirmato'.
	 */
	
	public List<SiceeTCertificato> findWhereAceFirmatoEquals(byte[] aceFirmato) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ACE_FIRMATO = ? ORDER BY ACE_FIRMATO", this,aceFirmato);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'CIRCO = :circo'.
	 */
	
	public List<SiceeTCertificato> findWhereCircoEquals(Integer circo) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE CIRCO = ? ORDER BY CIRCO", this,circo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_STATO = :fkStato'.
	 */
	
	public List<SiceeTCertificato> findBySiceeDStatoCert(Integer fkStato) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_STATO = ?", this,fkStato);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTCertificato> findBySiceeTCertificatore(String idCertificatore) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ?", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_TRANSAZIONE_ACE = :fkTransazioneAce'.
	 */
	
	public List<SiceeTCertificato> findBySiceeTTransazioneAce(long fkTransazioneAce) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_TRANSAZIONE_ACE = ?", this,fkTransazioneAce);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_CONDOMINIO = :flgCondominio'.
	 */
	
	public List<SiceeTCertificato> findWhereFlgCondominioEquals(String flgCondominio) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FLG_CONDOMINIO = ? ORDER BY FLG_CONDOMINIO", this,flgCondominio);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_MOTIVO_SOST = :fkMotivoSost'.
	 */
	
	public List<SiceeTCertificato> findBySiceeDMotivoSost(Integer fkMotivoSost) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_MOTIVO_SOST = ?", this,fkMotivoSost);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'dt_upload >= SICEE_T_PARAMETRI.data_upload_inizio_batch
and dt_upload < SICEE_T_PARAMETRI.data_upload_fine_batch
and fk_stato = :fkStato
and identific_pdf is not null
and id_certificatore||' '||progr_certificato||' '||anno 
not in (select id_certificatore||' '||progr_certificato||' '||anno 
from SICEE_T_VERIFY_REPORT)'.
	 */
	
	public List<SiceeTCertificato> findWhereDataInRange(Integer fkStato) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE dt_upload >= SICEE_T_PARAMETRI.data_upload_inizio_batch and dt_upload < SICEE_T_PARAMETRI.data_upload_fine_batch and fk_stato = ? and identific_pdf is not null and id_certificatore||' '||progr_certificato||' '||anno  not in (select id_certificatore||' '||progr_certificato||' '||anno  from SICEE_T_VERIFY_REPORT)", this,fkStato);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria ''.
	 */
	
	public List<SiceeTCertificato> findAll() throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTCertificato> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTCertificato> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTCertificato> findWhereAnnoEquals(String anno) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_SCADENZA = :dtScadenza'.
	 */
	
	public List<SiceeTCertificato> findWhereDtScadenzaEquals(Date dtScadenza) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DT_SCADENZA = ? ORDER BY DT_SCADENZA", this,dtScadenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_TRANSAZIONE_ACE = :fkTransazioneAce'.
	 */
	
	public List<SiceeTCertificato> findWhereFkTransazioneAceEquals(long fkTransazioneAce) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_TRANSAZIONE_ACE = ? ORDER BY FK_TRANSAZIONE_ACE", this,fkTransazioneAce);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_ACQUISTO = :dtAcquisto'.
	 */
	
	public List<SiceeTCertificato> findWhereDtAcquistoEquals(Date dtAcquisto) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DT_ACQUISTO = ? ORDER BY DT_ACQUISTO", this,dtAcquisto);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_STATO = :fkStato'.
	 */
	
	public List<SiceeTCertificato> findWhereFkStatoEquals(Integer fkStato) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_STATO = ? ORDER BY FK_STATO", this,fkStato);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_DICHIARAZIONE = :fkDichiarazione'.
	 */
	
	public List<SiceeTCertificato> findWhereFkDichiarazioneEquals(Integer fkDichiarazione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_DICHIARAZIONE = ? ORDER BY FK_DICHIARAZIONE", this,fkDichiarazione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_DICHIARAZIONE = :flgDichiarazione'.
	 */
	
	public List<SiceeTCertificato> findWhereFlgDichiarazioneEquals(String flgDichiarazione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FLG_DICHIARAZIONE = ? ORDER BY FLG_DICHIARAZIONE", this,flgDichiarazione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	
	public List<SiceeTCertificato> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ID_INDIRIZZO = ? ORDER BY ID_INDIRIZZO", this,idIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	
	public List<SiceeTCertificato> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DESC_INDIRIZZO = ? ORDER BY DESC_INDIRIZZO", this,descIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_INIZIO = :dtInizio'.
	 */
	
	public List<SiceeTCertificato> findWhereDtInizioEquals(Date dtInizio) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DT_INIZIO = ? ORDER BY DT_INIZIO", this,dtInizio);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'CAP = :cap'.
	 */
	
	public List<SiceeTCertificato> findWhereCapEquals(String cap) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE CAP = ? ORDER BY CAP", this,cap);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public List<SiceeTCertificato> findWhereIdComuneEquals(String idComune) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	
	public List<SiceeTCertificato> findWhereDescComuneEquals(String descComune) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DESC_COMUNE = ? ORDER BY DESC_COMUNE", this,descComune);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'SEZIONE = :sezione'.
	 */
	
	public List<SiceeTCertificato> findWhereSezioneEquals(String sezione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE SEZIONE = ? ORDER BY SEZIONE", this,sezione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_PROV = :idProv'.
	 */
	
	public List<SiceeTCertificato> findWhereIdProvEquals(String idProv) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ID_PROV = ? ORDER BY ID_PROV", this,idProv);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FOGLIO = :foglio'.
	 */
	
	public List<SiceeTCertificato> findWhereFoglioEquals(String foglio) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FOGLIO = ? ORDER BY FOGLIO", this,foglio);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_PROV = :descProv'.
	 */
	
	public List<SiceeTCertificato> findWhereDescProvEquals(String descProv) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DESC_PROV = ? ORDER BY DESC_PROV", this,descProv);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_REGIONE = :idRegione'.
	 */
	
	public List<SiceeTCertificato> findWhereIdRegioneEquals(String idRegione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE ID_REGIONE = ? ORDER BY ID_REGIONE", this,idRegione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'PARTICELLA = :particella'.
	 */
	
	public List<SiceeTCertificato> findWhereParticellaEquals(String particella) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE PARTICELLA = ? ORDER BY PARTICELLA", this,particella);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'SUBALTERNO = :subalterno'.
	 */
	
	public List<SiceeTCertificato> findWhereSubalternoEquals(String subalterno) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE SUBALTERNO = ? ORDER BY SUBALTERNO", this,subalterno);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_REGIONE = :descRegione'.
	 */
	
	public List<SiceeTCertificato> findWhereDescRegioneEquals(String descRegione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DESC_REGIONE = ? ORDER BY DESC_REGIONE", this,descRegione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'PIANO = :piano'.
	 */
	
	public List<SiceeTCertificato> findWherePianoEquals(Integer piano) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE PIANO = ? ORDER BY PIANO", this,piano);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_PIANI_COMPLESSIVI = :numPianiComplessivi'.
	 */
	
	public List<SiceeTCertificato> findWhereNumPianiComplessiviEquals(Integer numPianiComplessivi) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NUM_PIANI_COMPLESSIVI = ? ORDER BY NUM_PIANI_COMPLESSIVI", this,numPianiComplessivi);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_APPARTAMENTI = :numAppartamenti'.
	 */
	
	public List<SiceeTCertificato> findWhereNumAppartamentiEquals(Integer numAppartamenti) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NUM_APPARTAMENTI = ? ORDER BY NUM_APPARTAMENTI", this,numAppartamenti);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'SCALA = :scala'.
	 */
	
	public List<SiceeTCertificato> findWhereScalaEquals(String scala) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE SCALA = ? ORDER BY SCALA", this,scala);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'INTERNO = :interno'.
	 */
	
	public List<SiceeTCertificato> findWhereInternoEquals(String interno) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE INTERNO = ? ORDER BY INTERNO", this,interno);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOTE = :note'.
	 */
	
	public List<SiceeTCertificato> findWhereNoteEquals(String note) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NOTE = ? ORDER BY NOTE", this,note);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_STAMPA_DEF = :flgStampaDef'.
	 */
	
	public List<SiceeTCertificato> findWhereFlgStampaDefEquals(String flgStampaDef) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FLG_STAMPA_DEF = ? ORDER BY FLG_STAMPA_DEF", this,flgStampaDef);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_ACE_FIRMATO = :nomeAceFirmato'.
	 */
	
	public List<SiceeTCertificato> findWhereNomeAceFirmatoEquals(String nomeAceFirmato) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NOME_ACE_FIRMATO = ? ORDER BY NOME_ACE_FIRMATO", this,nomeAceFirmato);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_COCERTIFICATORE = :nomeCocertificatore'.
	 */
	
	public List<SiceeTCertificato> findWhereNomeCocertificatoreEquals(String nomeCocertificatore) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NOME_COCERTIFICATORE = ? ORDER BY NOME_COCERTIFICATORE", this,nomeCocertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'COGNOME_COCERTIFICATORE = :cognomeCocertificatore'.
	 */
	
	public List<SiceeTCertificato> findWhereCognomeCocertificatoreEquals(String cognomeCocertificatore) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE COGNOME_COCERTIFICATORE = ? ORDER BY COGNOME_COCERTIFICATORE", this,cognomeCocertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_COCERTIFICATORE = :numCocertificatore'.
	 */
	
	public List<SiceeTCertificato> findWhereNumCocertificatoreEquals(String numCocertificatore) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NUM_COCERTIFICATORE = ? ORDER BY NUM_COCERTIFICATORE", this,numCocertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	
	public List<SiceeTCertificato> findWhereNumCivicoEquals(String numCivico) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NUM_CIVICO = ? ORDER BY NUM_CIVICO", this,numCivico);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'IDENTIFIC_PDF = :identificPdf'.
	 */
	
	public List<SiceeTCertificato> findWhereIdentificPdfEquals(String identificPdf) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE IDENTIFIC_PDF = ? ORDER BY IDENTIFIC_PDF", this,identificPdf);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'IDENTIFIC_FOTO = :identificFoto'.
	 */
	
	public List<SiceeTCertificato> findWhereIdentificFotoEquals(String identificFoto) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE IDENTIFIC_FOTO = ? ORDER BY IDENTIFIC_FOTO", this,identificFoto);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'LUOGO_DICHIARAZIONE = :luogoDichiarazione'.
	 */
	
	public List<SiceeTCertificato> findWhereLuogoDichiarazioneEquals(String luogoDichiarazione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE LUOGO_DICHIARAZIONE = ? ORDER BY LUOGO_DICHIARAZIONE", this,luogoDichiarazione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_FOTO = :nomeFoto'.
	 */
	
	public List<SiceeTCertificato> findWhereNomeFotoEquals(String nomeFoto) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NOME_FOTO = ? ORDER BY NOME_FOTO", this,nomeFoto);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_PDF = :nomePdf'.
	 */
	
	public List<SiceeTCertificato> findWhereNomePdfEquals(String nomePdf) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NOME_PDF = ? ORDER BY NOME_PDF", this,nomePdf);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_UPLOAD = :dtUpload'.
	 */
	
	public List<SiceeTCertificato> findWhereDtUploadEquals(Date dtUpload) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DT_UPLOAD = ? ORDER BY DT_UPLOAD", this,dtUpload);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_EDIFICIO_PERFORMANTE = :flgEdificioPerformante'.
	 */
	
	public List<SiceeTCertificato> findWhereFlgEdificioPerformanteEquals(String flgEdificioPerformante) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FLG_EDIFICIO_PERFORMANTE = ? ORDER BY FLG_EDIFICIO_PERFORMANTE", this,flgEdificioPerformante);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_SIGMATER = :flgSigmater'.
	 */
	
	public List<SiceeTCertificato> findWhereFlgSigmaterEquals(String flgSigmater) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FLG_SIGMATER = ? ORDER BY FLG_SIGMATER", this,flgSigmater);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_MOTIVO_SOST = :fkMotivoSost'.
	 */
	
	public List<SiceeTCertificato> findWhereFkMotivoSostEquals(Integer fkMotivoSost) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FK_MOTIVO_SOST = ? ORDER BY FK_MOTIVO_SOST", this,fkMotivoSost);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_SOSTITUZIONE = :dtSostituzione'.
	 */
	
	public List<SiceeTCertificato> findWhereDtSostituzioneEquals(Date dtSostituzione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DT_SOSTITUZIONE = ? ORDER BY DT_SOSTITUZIONE", this,dtSostituzione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOTE_SOSTITUZIONE = :noteSostituzione'.
	 */
	
	public List<SiceeTCertificato> findWhereNoteSostituzioneEquals(String noteSostituzione) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE NOTE_SOSTITUZIONE = ? ORDER BY NOTE_SOSTITUZIONE", this,noteSostituzione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_FOTO = :dtFoto'.
	 */
	
	public List<SiceeTCertificato> findWhereDtFotoEquals(Date dtFoto) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE DT_FOTO = ? ORDER BY DT_FOTO", this,dtFoto);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_OLD = :flgOld'.
	 */
	
	public List<SiceeTCertificato> findWhereFlgOldEquals(String flgOld) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FLG_OLD = ? ORDER BY FLG_OLD", this,flgOld);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'COORD_N = :coordN'.
	 */
	
	public List<SiceeTCertificato> findWhereCoordNEquals(long coordN) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE COORD_N = ? ORDER BY COORD_N", this,coordN);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'COORD_E = :coordE'.
	 */
	
	public List<SiceeTCertificato> findWhereCoordEEquals(long coordE) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE COORD_E = ? ORDER BY COORD_E", this,coordE);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_NO_RACCOMAND = :flgNoRaccomand'.
	 */
	
	public List<SiceeTCertificato> findWhereFlgNoRaccomandEquals(String flgNoRaccomand) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE FLG_NO_RACCOMAND = ? ORDER BY FLG_NO_RACCOMAND", this,flgNoRaccomand);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'RIF_CATASTO = :rifCatasto'.
	 */
	
	public List<SiceeTCertificato> findWhereRifCatastoEquals(String rifCatasto) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE RIF_CATASTO = ? ORDER BY RIF_CATASTO", this,rifCatasto);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'CODICE_COMUNE_CATASTALE = :codiceComuneCatastale'.
	 */
	
	public List<SiceeTCertificato> findWhereCodiceComuneCatastaleEquals(String codiceComuneCatastale) throws SiceeTCertificatoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_SCADENZA, FK_TRANSAZIONE_ACE, DT_ACQUISTO, FK_STATO, FK_DICHIARAZIONE, FLG_DICHIARAZIONE, ID_INDIRIZZO, DESC_INDIRIZZO, DT_INIZIO, CAP, ID_COMUNE, DESC_COMUNE, SEZIONE, ID_PROV, FOGLIO, DESC_PROV, ID_REGIONE, PARTICELLA, SUBALTERNO, DESC_REGIONE, PIANO, NUM_PIANI_COMPLESSIVI, NUM_APPARTAMENTI, SCALA, INTERNO, NOTE, FLG_STAMPA_DEF, NOME_ACE_FIRMATO, NOME_COCERTIFICATORE, COGNOME_COCERTIFICATORE, NUM_COCERTIFICATORE, COD_FISC_COCERTIFICATORE, NUM_CIVICO, IDENTIFIC_PDF, IDENTIFIC_FOTO, LUOGO_DICHIARAZIONE, NOME_FOTO, NOME_PDF, DT_UPLOAD, FLG_EDIFICIO_PERFORMANTE, FLG_SIGMATER, FK_MOTIVO_SOST, DT_SOSTITUZIONE, NOTE_SOSTITUZIONE, DT_FOTO, FLG_OLD, COORD_N, COORD_E, FLG_NO_RACCOMAND, RIF_CATASTO, CODICE_COMUNE_CATASTALE, FK_SCADENZA_CERT, NUM_PIANI_FT_RISC, CF_UTENTE_SOSTITUZIONE, COORD_X_LONG_DD, COORD_Y_LAT_DD FROM " + getTableName() + " WHERE CODICE_COMUNE_CATASTALE = ? ORDER BY CODICE_COMUNE_CATASTALE", this,codiceComuneCatastale);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoDaoException("Query failed", e);
		}
		
	}
	/** 
	 * Returns the rows from the SICEE_T_CERTIFICATO table that matches the specified primary-key value.
	 */
	public SiceeTCertificato findByPrimaryKey(SiceeTCertificatoPk pk) throws SiceeTCertificatoDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
