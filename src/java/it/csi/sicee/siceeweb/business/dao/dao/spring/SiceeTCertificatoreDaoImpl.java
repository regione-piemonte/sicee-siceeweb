/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatorePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertificatoreDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTCertificatoreDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTCertificatore>, SiceeTCertificatoreDao
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
	 * @return SiceeTCertificatorePk
	 */
	
	public SiceeTCertificatorePk insert(SiceeTCertificatore dto)
	{
		dto.setIdCertificatore(incrementer.nextStringValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.isFkAziendaNull()?null:dto.getFkAzienda(),dto.getFkTitolo(),dto.getNome(),dto.getCognome(),dto.getCodiceFiscale(),dto.getIdComuneNascita(),dto.getDescComuneNascita(),dto.getDtNascita(),dto.getIdProvNascita(),dto.getIdIndirizzo(),dto.getDescProvNascita(),dto.getIdRegioneNascita(),dto.getDescIndirizzo(),dto.getCap(),dto.getDescRegioneNascita(),dto.getIdComuneResidenza(),dto.getNumCivicoResidenza(),dto.getDescComuneResidenza(),dto.getFlgEdifici(),dto.getFlgImpianti(),dto.getFlgVerificato(),dto.getFlgPagamento(),dto.getNote(),dto.getIdProvResidenza(),dto.getDtIscrElenco(),dto.getDescProvResidenza(),dto.getDtScadenzaElenco(),dto.getIdRegioneResidenza(),dto.isNumTotAceNull()?null:dto.getNumTotAce(),dto.getDescRegioneResidenza(),dto.getOrdine(),dto.getDescProvOrdine(),dto.getNumIscrAlbo(),dto.getIdProvOrdine(),dto.getSettore(),dto.getSezione(),dto.getTelefono(),dto.getDataIscrAlbo(),dto.getFax(),dto.getCell(),dto.getEmail(),dto.getNumCertificatore(),dto.getStatoEstero(),dto.getFlgConsensoTel(),dto.getFlgConsensoEmail(),dto.getFlgConsensoCell(),dto.getEmailPec(),dto.getFlgNewsletter(),dto.getFlgEsameSostenuto(),dto.getSitoWeb(),dto.getFlgCancElenco(),dto.getFkIstruzione(),dto.getFlgAggDati(),dto.getFlgAggEmail(),dto.getDtAggDati(),dto.getDtAggEmail(),dto.getIscrittoOrdine(),dto.getCompetenzeNazionali(),dto.getAccettazioneTecnico(),dto.getDtEmailVerifica(),dto.getStatoResEstero(),dto.getCittaEstera(),dto.getViaEstera(),dto.getCivicoEstero(),dto.getCapEstero(),dto.getFlgResidenzaItalia(),dto.getFkBloccoCertificatore());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_CERTIFICATORE table.
	 */
	
	public void update(SiceeTCertificatorePk pk, SiceeTCertificatore dto) throws SiceeTCertificatoreDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, FK_AZIENDA = ?, FK_TITOLO = ?, NOME = ?, COGNOME = ?, CODICE_FISCALE = ?, ID_COMUNE_NASCITA = ?, DESC_COMUNE_NASCITA = ?, DT_NASCITA = ?, ID_PROV_NASCITA = ?, ID_INDIRIZZO = ?, DESC_PROV_NASCITA = ?, ID_REGIONE_NASCITA = ?, DESC_INDIRIZZO = ?, CAP = ?, DESC_REGIONE_NASCITA = ?, ID_COMUNE_RESIDENZA = ?, NUM_CIVICO_RESIDENZA = ?, DESC_COMUNE_RESIDENZA = ?, FLG_EDIFICI = ?, FLG_IMPIANTI = ?, FLG_VERIFICATO = ?, FLG_PAGAMENTO = ?, NOTE = ?, ID_PROV_RESIDENZA = ?, DT_ISCR_ELENCO = ?, DESC_PROV_RESIDENZA = ?, DT_SCADENZA_ELENCO = ?, ID_REGIONE_RESIDENZA = ?, NUM_TOT_ACE = ?, DESC_REGIONE_RESIDENZA = ?, ORDINE = ?, DESC_PROV_ORDINE = ?, NUM_ISCR_ALBO = ?, ID_PROV_ORDINE = ?, SETTORE = ?, SEZIONE = ?, TELEFONO = ?, DATA_ISCR_ALBO = ?, FAX = ?, CELL = ?, EMAIL = ?, NUM_CERTIFICATORE = ?, STATO_ESTERO = ?, FLG_CONSENSO_TEL = ?, FLG_CONSENSO_EMAIL = ?, FLG_CONSENSO_CELL = ?, EMAIL_PEC = ?, FLG_NEWSLETTER = ?, FLG_ESAME_SOSTENUTO = ?, SITO_WEB = ?, FLG_CANC_ELENCO = ?, FK_ISTRUZIONE = ?, FLG_AGG_DATI = ?, FLG_AGG_EMAIL = ?, DT_AGG_DATI = ?, DT_AGG_EMAIL = ?, ISCRITTO_ORDINE = ?, COMPETENZE_NAZIONALI = ?, ACCETTAZIONE_TECNICO = ?, DT_EMAIL_VERIFICA = ?, STATO_RES_ESTERO = ?, CITTA_ESTERA = ?, VIA_ESTERA = ?, CIVICO_ESTERO = ?, CAP_ESTERO = ? , FLG_RESIDENZA_ITALIA = ? , FK_BLOCCO_CERTIFICATORE = ? WHERE ID_CERTIFICATORE = ?",dto.getIdCertificatore(),dto.getFkAzienda(),dto.getFkTitolo(),dto.getNome(),dto.getCognome(),dto.getCodiceFiscale(),dto.getIdComuneNascita(),dto.getDescComuneNascita(),dto.getDtNascita(),dto.getIdProvNascita(),dto.getIdIndirizzo(),dto.getDescProvNascita(),dto.getIdRegioneNascita(),dto.getDescIndirizzo(),dto.getCap(),dto.getDescRegioneNascita(),dto.getIdComuneResidenza(),dto.getNumCivicoResidenza(),dto.getDescComuneResidenza(),dto.getFlgEdifici(),dto.getFlgImpianti(),dto.getFlgVerificato(),dto.getFlgPagamento(),dto.getNote(),dto.getIdProvResidenza(),dto.getDtIscrElenco(),dto.getDescProvResidenza(),dto.getDtScadenzaElenco(),dto.getIdRegioneResidenza(),dto.getNumTotAce(),dto.getDescRegioneResidenza(),dto.getOrdine(),dto.getDescProvOrdine(),dto.getNumIscrAlbo(),dto.getIdProvOrdine(),dto.getSettore(),dto.getSezione(),dto.getTelefono(),dto.getDataIscrAlbo(),dto.getFax(),dto.getCell(),dto.getEmail(),dto.getNumCertificatore(),dto.getStatoEstero(),dto.getFlgConsensoTel(),dto.getFlgConsensoEmail(),dto.getFlgConsensoCell(),dto.getEmailPec(),dto.getFlgNewsletter(),dto.getFlgEsameSostenuto(),dto.getSitoWeb(),dto.getFlgCancElenco(),dto.getFkIstruzione(),dto.getFlgAggDati(),dto.getFlgAggEmail(),dto.getDtAggDati(),dto.getDtAggEmail(),dto.getIscrittoOrdine(),dto.getCompetenzeNazionali(),dto.getAccettazioneTecnico(),dto.getDtEmailVerifica(),dto.getStatoResEstero(),dto.getCittaEstera(),dto.getViaEstera(),dto.getCivicoEstero(),dto.getCapEstero(),dto.getFlgResidenzaItalia(),dto.getFkBloccoCertificatore(),pk.getIdCertificatore());
	}

	/** 
	 * Deletes a single row in the SICEE_T_CERTIFICATORE table.
	 */
	
	public void delete(SiceeTCertificatorePk pk) throws SiceeTCertificatoreDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ?",pk.getIdCertificatore());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTCertificatore
	 */
	public SiceeTCertificatore mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTCertificatore dto = new SiceeTCertificatore();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setFkAzienda( rs.getLong( 2 ) );
		if (rs.wasNull()) {
			dto.setFkAziendaNull( true );
		}
		
		dto.setFkTitolo( rs.getString( 3 ) );
		dto.setNome( rs.getString( 4 ) );
		dto.setCognome( rs.getString( 5 ) );
		dto.setCodiceFiscale( rs.getString( 6 ) );
		dto.setIdComuneNascita( rs.getString( 7 ) );
		dto.setDescComuneNascita( rs.getString( 8 ) );
		dto.setDtNascita( rs.getTimestamp(9 ) );
		dto.setIdProvNascita( rs.getString( 10 ) );
		dto.setIdIndirizzo( new Integer( rs.getInt(11) ) );
		if (rs.wasNull()) {
			dto.setIdIndirizzo( null );
		}
		
		dto.setDescProvNascita( rs.getString( 12 ) );
		dto.setIdRegioneNascita( rs.getString( 13 ) );
		dto.setDescIndirizzo( rs.getString( 14 ) );
		dto.setCap( rs.getString( 15 ) );
		dto.setDescRegioneNascita( rs.getString( 16 ) );
		dto.setIdComuneResidenza( rs.getString( 17 ) );
		dto.setNumCivicoResidenza( rs.getString( 18 ) );
		dto.setDescComuneResidenza( rs.getString( 19 ) );
		dto.setFlgEdifici( rs.getString( 20 ) );
		dto.setFlgImpianti( rs.getString( 21 ) );
		dto.setFlgVerificato( rs.getString( 22 ) );
		dto.setFlgPagamento( rs.getString( 23 ) );
		dto.setNote( rs.getString( 24 ) );
		dto.setIdProvResidenza( rs.getString( 25 ) );
		dto.setDtIscrElenco( rs.getTimestamp(26 ) );
		dto.setDescProvResidenza( rs.getString( 27 ) );
		dto.setDtScadenzaElenco( rs.getTimestamp(28 ) );
		dto.setIdRegioneResidenza( rs.getString( 29 ) );
		dto.setNumTotAce( rs.getLong( 30 ) );
		if (rs.wasNull()) {
			dto.setNumTotAceNull( true );
		}
		
		dto.setDescRegioneResidenza( rs.getString( 31 ) );
		dto.setOrdine( rs.getString( 32 ) );
		dto.setDescProvOrdine( rs.getString( 33 ) );
		dto.setNumIscrAlbo( rs.getString( 34 ) );
		dto.setIdProvOrdine( rs.getString( 35 ) );
		dto.setSettore( rs.getString( 36 ) );
		dto.setSezione( rs.getString( 37 ) );
		dto.setTelefono( rs.getString( 38 ) );
		dto.setDataIscrAlbo( rs.getTimestamp(39 ) );
		dto.setFax( rs.getString( 40 ) );
		dto.setCell( rs.getString( 41 ) );
		dto.setEmail( rs.getString( 42 ) );
		dto.setNumCertificatore( rs.getString( 43 ) );
		dto.setStatoEstero( rs.getString( 44 ) );
		dto.setFlgConsensoTel( rs.getString( 45 ) );
		dto.setFlgConsensoEmail( rs.getString( 46 ) );
		dto.setFlgConsensoCell( rs.getString( 47 ) );
		dto.setEmailPec( rs.getString( 48 ) );
		dto.setFlgNewsletter( rs.getString( 49 ) );
		dto.setFlgEsameSostenuto( rs.getString( 50 ) );
		dto.setSitoWeb( rs.getString( 51 ) );
		dto.setFlgCancElenco( rs.getString( 52 ) );
		dto.setFkIstruzione( new Integer( rs.getInt(53) ) );
		if (rs.wasNull()) {
			dto.setFkIstruzione( null );
		}
		
		dto.setFlgAggDati( rs.getString( 54 ) );
		dto.setFlgAggEmail( rs.getString( 55 ) );
		dto.setDtAggDati( rs.getTimestamp(56 ) );
		dto.setDtAggEmail( rs.getTimestamp(57 ) );
		dto.setIscrittoOrdine( rs.getString( 58 ) );
		dto.setCompetenzeNazionali( rs.getString( 59 ) );
		dto.setAccettazioneTecnico( rs.getString( 60 ) );
		dto.setDtEmailVerifica( rs.getTimestamp(61 ) );
		dto.setStatoResEstero( rs.getString(62 ) );
		dto.setCittaEstera( rs.getString(63 ) );
		dto.setViaEstera( rs.getString(64 ) );
		dto.setCivicoEstero( rs.getString(65 ) );
		dto.setCapEstero( rs.getString(66 ) );
		dto.setFlgResidenzaItalia( rs.getString(67 ) );
		dto.setFkBloccoCertificatore( new Integer( rs.getInt(68) ));
		if (rs.wasNull()) {
			dto.setFkBloccoCertificatore( null );
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
		return "SICEE_T_CERTIFICATORE";
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public SiceeTCertificatore findByPrimaryKey(String idCertificatore) throws SiceeTCertificatoreDaoException
	{
		try {
			List<SiceeTCertificatore> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ?", this,idCertificatore);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria ''.
	 */
	
	public List<SiceeTCertificatore> findAll() throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE", this);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CODICE_FISCALE LIKE :codiceFiscale%'.
	 */
	
	public List<SiceeTCertificatore> findByCf(String codiceFiscale) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE CODICE_FISCALE LIKE ?", this,codiceFiscale);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_ISTRUZIONE = :fkIstruzione'.
	 */
	
	public List<SiceeTCertificatore> findBySiceeDIstruzione(Integer fkIstruzione) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FK_ISTRUZIONE = ?", this,fkIstruzione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_TITOLO = :fkTitolo'.
	 */
	
	public List<SiceeTCertificatore> findBySiceeDTitolo(String fkTitolo) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FK_TITOLO = ?", this,fkTitolo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_AZIENDA = :fkAzienda'.
	 */
	
	public List<SiceeTCertificatore> findBySiceeTAzienda(long fkAzienda) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FK_AZIENDA = ?", this,fkAzienda);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_AZIENDA = :fkAzienda'.
	 */
	
	public List<SiceeTCertificatore> findWhereFkAziendaEquals(long fkAzienda) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FK_AZIENDA = ? ORDER BY FK_AZIENDA", this,fkAzienda);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_TITOLO = :fkTitolo'.
	 */
	
	public List<SiceeTCertificatore> findWhereFkTitoloEquals(String fkTitolo) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FK_TITOLO = ? ORDER BY FK_TITOLO", this,fkTitolo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NOME = :nome'.
	 */
	
	public List<SiceeTCertificatore> findWhereNomeEquals(String nome) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE NOME = ? ORDER BY NOME", this,nome);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'COGNOME = :cognome'.
	 */
	
	public List<SiceeTCertificatore> findWhereCognomeEquals(String cognome) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE COGNOME = ? ORDER BY COGNOME", this,cognome);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 */
	
	public List<SiceeTCertificatore> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE CODICE_FISCALE = ? ORDER BY CODICE_FISCALE", this,codiceFiscale);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_COMUNE_NASCITA = :idComuneNascita'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdComuneNascitaEquals(String idComuneNascita) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_COMUNE_NASCITA = ? ORDER BY ID_COMUNE_NASCITA", this,idComuneNascita);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_COMUNE_NASCITA = :descComuneNascita'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescComuneNascitaEquals(String descComuneNascita) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_COMUNE_NASCITA = ? ORDER BY DESC_COMUNE_NASCITA", this,descComuneNascita);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_NASCITA = :dtNascita'.
	 */
	
	public List<SiceeTCertificatore> findWhereDtNascitaEquals(Date dtNascita) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DT_NASCITA = ? ORDER BY DT_NASCITA", this,dtNascita);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_NASCITA = :idProvNascita'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdProvNascitaEquals(String idProvNascita) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_PROV_NASCITA = ? ORDER BY ID_PROV_NASCITA", this,idProvNascita);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_INDIRIZZO = ? ORDER BY ID_INDIRIZZO", this,idIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_NASCITA = :descProvNascita'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescProvNascitaEquals(String descProvNascita) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_PROV_NASCITA = ? ORDER BY DESC_PROV_NASCITA", this,descProvNascita);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_REGIONE_NASCITA = :idRegioneNascita'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdRegioneNascitaEquals(String idRegioneNascita) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_REGIONE_NASCITA = ? ORDER BY ID_REGIONE_NASCITA", this,idRegioneNascita);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_INDIRIZZO = ? ORDER BY DESC_INDIRIZZO", this,descIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CAP = :cap'.
	 */
	
	public List<SiceeTCertificatore> findWhereCapEquals(String cap) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE CAP = ? ORDER BY CAP", this,cap);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_REGIONE_NASCITA = :descRegioneNascita'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescRegioneNascitaEquals(String descRegioneNascita) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_REGIONE_NASCITA = ? ORDER BY DESC_REGIONE_NASCITA", this,descRegioneNascita);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_COMUNE_RESIDENZA = :idComuneResidenza'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdComuneResidenzaEquals(String idComuneResidenza) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_COMUNE_RESIDENZA = ? ORDER BY ID_COMUNE_RESIDENZA", this,idComuneResidenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_CIVICO_RESIDENZA = :numCivicoResidenza'.
	 */
	
	public List<SiceeTCertificatore> findWhereNumCivicoResidenzaEquals(String numCivicoResidenza) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE NUM_CIVICO_RESIDENZA = ? ORDER BY NUM_CIVICO_RESIDENZA", this,numCivicoResidenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_COMUNE_RESIDENZA = :descComuneResidenza'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescComuneResidenzaEquals(String descComuneResidenza) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_COMUNE_RESIDENZA = ? ORDER BY DESC_COMUNE_RESIDENZA", this,descComuneResidenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_EDIFICI = :flgEdifici'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgEdificiEquals(String flgEdifici) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_EDIFICI = ? ORDER BY FLG_EDIFICI", this,flgEdifici);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_IMPIANTI = :flgImpianti'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgImpiantiEquals(String flgImpianti) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_IMPIANTI = ? ORDER BY FLG_IMPIANTI", this,flgImpianti);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_VERIFICATO = :flgVerificato'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgVerificatoEquals(String flgVerificato) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_VERIFICATO = ? ORDER BY FLG_VERIFICATO", this,flgVerificato);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_PAGAMENTO = :flgPagamento'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgPagamentoEquals(String flgPagamento) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_PAGAMENTO = ? ORDER BY FLG_PAGAMENTO", this,flgPagamento);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NOTE = :note'.
	 */
	
	public List<SiceeTCertificatore> findWhereNoteEquals(String note) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE NOTE = ? ORDER BY NOTE", this,note);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_RESIDENZA = :idProvResidenza'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdProvResidenzaEquals(String idProvResidenza) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_PROV_RESIDENZA = ? ORDER BY ID_PROV_RESIDENZA", this,idProvResidenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_ISCR_ELENCO = :dtIscrElenco'.
	 */
	
	public List<SiceeTCertificatore> findWhereDtIscrElencoEquals(Date dtIscrElenco) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DT_ISCR_ELENCO = ? ORDER BY DT_ISCR_ELENCO", this,dtIscrElenco);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_RESIDENZA = :descProvResidenza'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescProvResidenzaEquals(String descProvResidenza) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_PROV_RESIDENZA = ? ORDER BY DESC_PROV_RESIDENZA", this,descProvResidenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_SCADENZA_ELENCO = :dtScadenzaElenco'.
	 */
	
	public List<SiceeTCertificatore> findWhereDtScadenzaElencoEquals(Date dtScadenzaElenco) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DT_SCADENZA_ELENCO = ? ORDER BY DT_SCADENZA_ELENCO", this,dtScadenzaElenco);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_REGIONE_RESIDENZA = :idRegioneResidenza'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdRegioneResidenzaEquals(String idRegioneResidenza) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_REGIONE_RESIDENZA = ? ORDER BY ID_REGIONE_RESIDENZA", this,idRegioneResidenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_TOT_ACE = :numTotAce'.
	 */
	
	public List<SiceeTCertificatore> findWhereNumTotAceEquals(long numTotAce) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE NUM_TOT_ACE = ? ORDER BY NUM_TOT_ACE", this,numTotAce);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_REGIONE_RESIDENZA = :descRegioneResidenza'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescRegioneResidenzaEquals(String descRegioneResidenza) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_REGIONE_RESIDENZA = ? ORDER BY DESC_REGIONE_RESIDENZA", this,descRegioneResidenza);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ORDINE = :ordine'.
	 */
	
	public List<SiceeTCertificatore> findWhereOrdineEquals(String ordine) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ORDINE = ? ORDER BY ORDINE", this,ordine);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_ORDINE = :descProvOrdine'.
	 */
	
	public List<SiceeTCertificatore> findWhereDescProvOrdineEquals(String descProvOrdine) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DESC_PROV_ORDINE = ? ORDER BY DESC_PROV_ORDINE", this,descProvOrdine);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_ISCR_ALBO = :numIscrAlbo'.
	 */
	
	public List<SiceeTCertificatore> findWhereNumIscrAlboEquals(String numIscrAlbo) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE NUM_ISCR_ALBO = ? ORDER BY NUM_ISCR_ALBO", this,numIscrAlbo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_ORDINE = :idProvOrdine'.
	 */
	
	public List<SiceeTCertificatore> findWhereIdProvOrdineEquals(String idProvOrdine) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ID_PROV_ORDINE = ? ORDER BY ID_PROV_ORDINE", this,idProvOrdine);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SETTORE = :settore'.
	 */
	
	public List<SiceeTCertificatore> findWhereSettoreEquals(String settore) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE SETTORE = ? ORDER BY SETTORE", this,settore);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SEZIONE = :sezione'.
	 */
	
	public List<SiceeTCertificatore> findWhereSezioneEquals(String sezione) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE SEZIONE = ? ORDER BY SEZIONE", this,sezione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'TELEFONO = :telefono'.
	 */
	
	public List<SiceeTCertificatore> findWhereTelefonoEquals(String telefono) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE TELEFONO = ? ORDER BY TELEFONO", this,telefono);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DATA_ISCR_ALBO = :dataIscrAlbo'.
	 */
	
	public List<SiceeTCertificatore> findWhereDataIscrAlboEquals(Date dataIscrAlbo) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DATA_ISCR_ALBO = ? ORDER BY DATA_ISCR_ALBO", this,dataIscrAlbo);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FAX = :fax'.
	 */
	
	public List<SiceeTCertificatore> findWhereFaxEquals(String fax) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FAX = ? ORDER BY FAX", this,fax);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CELL = :cell'.
	 */
	
	public List<SiceeTCertificatore> findWhereCellEquals(String cell) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE CELL = ? ORDER BY CELL", this,cell);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'EMAIL = :email'.
	 */
	
	public List<SiceeTCertificatore> findWhereEmailEquals(String email) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this,email);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_CERTIFICATORE = :numCertificatore'.
	 */
	
	public SiceeTCertificatore findWhereNumCertificatoreEquals(String numCertificatore) throws SiceeTCertificatoreDaoException
	{
		try {
			List<SiceeTCertificatore> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE NUM_CERTIFICATORE = ? ORDER BY NUM_CERTIFICATORE", this,numCertificatore);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'STATO_ESTERO = :statoEstero'.
	 */
	
	public List<SiceeTCertificatore> findWhereStatoEsteroEquals(String statoEstero) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE STATO_ESTERO = ? ORDER BY STATO_ESTERO", this,statoEstero);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_TEL = :flgConsensoTel'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgConsensoTelEquals(String flgConsensoTel) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_CONSENSO_TEL = ? ORDER BY FLG_CONSENSO_TEL", this,flgConsensoTel);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_EMAIL = :flgConsensoEmail'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgConsensoEmailEquals(String flgConsensoEmail) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_CONSENSO_EMAIL = ? ORDER BY FLG_CONSENSO_EMAIL", this,flgConsensoEmail);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_CELL = :flgConsensoCell'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgConsensoCellEquals(String flgConsensoCell) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_CONSENSO_CELL = ? ORDER BY FLG_CONSENSO_CELL", this,flgConsensoCell);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'EMAIL_PEC = :emailPec'.
	 */
	
	public List<SiceeTCertificatore> findWhereEmailPecEquals(String emailPec) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE EMAIL_PEC = ? ORDER BY EMAIL_PEC", this,emailPec);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_NEWSLETTER = :flgNewsletter'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgNewsletterEquals(String flgNewsletter) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_NEWSLETTER = ? ORDER BY FLG_NEWSLETTER", this,flgNewsletter);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_ESAME_SOSTENUTO = :flgEsameSostenuto'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgEsameSostenutoEquals(String flgEsameSostenuto) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_ESAME_SOSTENUTO = ? ORDER BY FLG_ESAME_SOSTENUTO", this,flgEsameSostenuto);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SITO_WEB = :sitoWeb'.
	 */
	
	public List<SiceeTCertificatore> findWhereSitoWebEquals(String sitoWeb) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE SITO_WEB = ? ORDER BY SITO_WEB", this,sitoWeb);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CANC_ELENCO = :flgCancElenco'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgCancElencoEquals(String flgCancElenco) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_CANC_ELENCO = ? ORDER BY FLG_CANC_ELENCO", this,flgCancElenco);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_ISTRUZIONE = :fkIstruzione'.
	 */
	
	public List<SiceeTCertificatore> findWhereFkIstruzioneEquals(Integer fkIstruzione) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FK_ISTRUZIONE = ? ORDER BY FK_ISTRUZIONE", this,fkIstruzione);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_AGG_DATI = :flgAggDati'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgAggDatiEquals(String flgAggDati) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_AGG_DATI = ? ORDER BY FLG_AGG_DATI", this,flgAggDati);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_AGG_EMAIL = :flgAggEmail'.
	 */
	
	public List<SiceeTCertificatore> findWhereFlgAggEmailEquals(String flgAggEmail) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_AGG_EMAIL = ? ORDER BY FLG_AGG_EMAIL", this,flgAggEmail);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_AGG_DATI = :dtAggDati'.
	 */
	
	public List<SiceeTCertificatore> findWhereDtAggDatiEquals(Date dtAggDati) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DT_AGG_DATI = ? ORDER BY DT_AGG_DATI", this,dtAggDati);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_AGG_EMAIL = :dtAggEmail'.
	 */
	
	public List<SiceeTCertificatore> findWhereDtAggEmailEquals(Date dtAggEmail) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DT_AGG_EMAIL = ? ORDER BY DT_AGG_EMAIL", this,dtAggEmail);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ISCRITTO_ORDINE = :iscrittoOrdine'.
	 */
	
	public List<SiceeTCertificatore> findWhereIscrittoOrdineEquals(String iscrittoOrdine) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ISCRITTO_ORDINE = ? ORDER BY ISCRITTO_ORDINE", this,iscrittoOrdine);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'COMPETENZE_NAZIONALI = :competenzeNazionali'.
	 */
	
	public List<SiceeTCertificatore> findWhereCompetenzeNazionaliEquals(String competenzeNazionali) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE COMPETENZE_NAZIONALI = ? ORDER BY COMPETENZE_NAZIONALI", this,competenzeNazionali);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ACCETTAZIONE_TECNICO = :accettazioneTecnico'.
	 */
	
	public List<SiceeTCertificatore> findWhereAccettazioneTecnicoEquals(String accettazioneTecnico) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE ACCETTAZIONE_TECNICO = ? ORDER BY ACCETTAZIONE_TECNICO", this,accettazioneTecnico);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_EMAIL_VERIFICA = :dtEmailVerifica'.
	 */
	
	public List<SiceeTCertificatore> findWhereDtEmailVerificaEquals(Date dtEmailVerifica) throws SiceeTCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, FK_AZIENDA, FK_TITOLO, NOME, COGNOME, CODICE_FISCALE, ID_COMUNE_NASCITA, DESC_COMUNE_NASCITA, DT_NASCITA, ID_PROV_NASCITA, ID_INDIRIZZO, DESC_PROV_NASCITA, ID_REGIONE_NASCITA, DESC_INDIRIZZO, CAP, DESC_REGIONE_NASCITA, ID_COMUNE_RESIDENZA, NUM_CIVICO_RESIDENZA, DESC_COMUNE_RESIDENZA, FLG_EDIFICI, FLG_IMPIANTI, FLG_VERIFICATO, FLG_PAGAMENTO, NOTE, ID_PROV_RESIDENZA, DT_ISCR_ELENCO, DESC_PROV_RESIDENZA, DT_SCADENZA_ELENCO, ID_REGIONE_RESIDENZA, NUM_TOT_ACE, DESC_REGIONE_RESIDENZA, ORDINE, DESC_PROV_ORDINE, NUM_ISCR_ALBO, ID_PROV_ORDINE, SETTORE, SEZIONE, TELEFONO, DATA_ISCR_ALBO, FAX, CELL, EMAIL, NUM_CERTIFICATORE, STATO_ESTERO, FLG_CONSENSO_TEL, FLG_CONSENSO_EMAIL, FLG_CONSENSO_CELL, EMAIL_PEC, FLG_NEWSLETTER, FLG_ESAME_SOSTENUTO, SITO_WEB, FLG_CANC_ELENCO, FK_ISTRUZIONE, FLG_AGG_DATI, FLG_AGG_EMAIL, DT_AGG_DATI, DT_AGG_EMAIL, ISCRITTO_ORDINE, COMPETENZE_NAZIONALI, ACCETTAZIONE_TECNICO, DT_EMAIL_VERIFICA, STATO_RES_ESTERO, CITTA_ESTERA, VIA_ESTERA, CIVICO_ESTERO, CAP_ESTERO, FLG_RESIDENZA_ITALIA, FK_BLOCCO_CERTIFICATORE FROM " + getTableName() + " WHERE DT_EMAIL_VERIFICA = ? ORDER BY DT_EMAIL_VERIFICA", this,dtEmailVerifica);
		}
		catch (Exception e) {
			throw new SiceeTCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_CERTIFICATORE table that matches the specified primary-key value.
	 */
	public SiceeTCertificatore findByPrimaryKey(SiceeTCertificatorePk pk) throws SiceeTCertificatoreDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore() );
	}

}
