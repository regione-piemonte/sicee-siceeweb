/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneAceDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneAce;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneAcePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazioneAceDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTTransazioneAceDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTTransazioneAce>, SiceeTTransazioneAceDao
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
	 * @return SiceeTTransazioneAcePk
	 */
	
	public SiceeTTransazioneAcePk insert(SiceeTTransazioneAce dto)
	{
		dto.setIdTransazioneAce(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdTransazioneAce(),dto.getFkTipoPagamento(),dto.getNumTransazione(),dto.getDataTransazione(),dto.getFlgVerificato(),dto.getEseguitoNome(),dto.getEseguitoCognome(),dto.getAnno(),dto.getQuantita(),dto.getFkCertificatore());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	
	public void update(SiceeTTransazioneAcePk pk, SiceeTTransazioneAce dto) throws SiceeTTransazioneAceDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TRANSAZIONE_ACE = ?, FK_TIPO_PAGAMENTO = ?, NUM_TRANSAZIONE = ?, DATA_TRANSAZIONE = ?, FLG_VERIFICATO = ?, ESEGUITO_NOME = ?, ESEGUITO_COGNOME = ?, ANNO = ?, QUANTITA = ?, FK_CERTIFICATORE = ? WHERE ID_TRANSAZIONE_ACE = ?",dto.getIdTransazioneAce(),dto.getFkTipoPagamento(),dto.getNumTransazione(),dto.getDataTransazione(),dto.getFlgVerificato(),dto.getEseguitoNome(),dto.getEseguitoCognome(),dto.getAnno(),dto.getQuantita(),dto.getFkCertificatore(),pk.getIdTransazioneAce());
	}

	/** 
	 * Deletes a single row in the SICEE_T_TRANSAZIONE_ACE table.
	 */
	
	public void delete(SiceeTTransazioneAcePk pk) throws SiceeTTransazioneAceDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TRANSAZIONE_ACE = ?",pk.getIdTransazioneAce());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTTransazioneAce
	 */
	public SiceeTTransazioneAce mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTTransazioneAce dto = new SiceeTTransazioneAce();
		dto.setIdTransazioneAce( rs.getLong( 1 ) );
		dto.setFkTipoPagamento( new Integer( rs.getInt(2) ) );
		dto.setNumTransazione( rs.getString( 3 ) );
		dto.setDataTransazione( rs.getTimestamp(4 ) );
		dto.setFlgVerificato( rs.getString( 5 ) );
		dto.setEseguitoNome( rs.getString( 6 ) );
		dto.setEseguitoCognome( rs.getString( 7 ) );
		dto.setAnno( rs.getString( 8 ) );
		dto.setQuantita( new Integer( rs.getInt(9) ) );
		if (rs.wasNull()) {
			dto.setQuantita( null );
		}
		
		dto.setFkCertificatore( rs.getString( 10 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_TRANSAZIONE_ACE";
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ID_TRANSAZIONE_ACE = :idTransazioneAce'.
	 */
	
	public SiceeTTransazioneAce findByPrimaryKey(long idTransazioneAce) throws SiceeTTransazioneAceDaoException
	{
		try {
			List<SiceeTTransazioneAce> list = jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE ID_TRANSAZIONE_ACE = ?", this,idTransazioneAce);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria ''.
	 */
	
	public List<SiceeTTransazioneAce> findAll() throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " ORDER BY ID_TRANSAZIONE_ACE", this);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTTransazioneAce> findBySiceeTCertificatore(String fkCertificatore) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ?", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ID_TRANSAZIONE_ACE = :idTransazioneAce'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereIdTransazioneAceEquals(long idTransazioneAce) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE ID_TRANSAZIONE_ACE = ? ORDER BY ID_TRANSAZIONE_ACE", this,idTransazioneAce);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FK_TIPO_PAGAMENTO = :fkTipoPagamento'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereFkTipoPagamentoEquals(Integer fkTipoPagamento) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE FK_TIPO_PAGAMENTO = ? ORDER BY FK_TIPO_PAGAMENTO", this,fkTipoPagamento);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'NUM_TRANSAZIONE = :numTransazione'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereNumTransazioneEquals(String numTransazione) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE NUM_TRANSAZIONE = ? ORDER BY NUM_TRANSAZIONE", this,numTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'DATA_TRANSAZIONE = :dataTransazione'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereDataTransazioneEquals(Date dataTransazione) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE DATA_TRANSAZIONE = ? ORDER BY DATA_TRANSAZIONE", this,dataTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FLG_VERIFICATO = :flgVerificato'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereFlgVerificatoEquals(String flgVerificato) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE FLG_VERIFICATO = ? ORDER BY FLG_VERIFICATO", this,flgVerificato);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ESEGUITO_NOME = :eseguitoNome'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereEseguitoNomeEquals(String eseguitoNome) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE ESEGUITO_NOME = ? ORDER BY ESEGUITO_NOME", this,eseguitoNome);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ESEGUITO_COGNOME = :eseguitoCognome'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereEseguitoCognomeEquals(String eseguitoCognome) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE ESEGUITO_COGNOME = ? ORDER BY ESEGUITO_COGNOME", this,eseguitoCognome);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? ORDER BY FK_CERTIFICATORE", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereAnnoEquals(String anno) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'QUANTITA = :quantita'.
	 */
	
	public List<SiceeTTransazioneAce> findWhereQuantitaEquals(Integer quantita) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE QUANTITA = ? ORDER BY QUANTITA", this,quantita);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore AND FLG_VERIFICATO = 'E''.
	 */
	
	public List<SiceeTTransazioneAce> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore) throws SiceeTTransazioneAceDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? AND FLG_VERIFICATO = 'E' ORDER BY DATA_TRANSAZIONE DESC", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}
	
	public List<SiceeTTransazioneAce> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore, String... flgVerificato) throws SiceeTTransazioneAceDaoException
	{
		try {
			StringBuffer buf = new StringBuffer("FLG_VERIFICATO IN (");
			
			for(int i = 0; i < flgVerificato.length - 1; i++) {
				buf.append("'" + flgVerificato[i] + "', ");				
			}
			buf.append("'" + flgVerificato[flgVerificato.length - 1] +"'");
			buf.append(")");
			
			
			String queryTmp = "SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? AND " + buf.toString() + " ORDER BY DATA_TRANSAZIONE DESC";
			
//			System.out.println("##################");
//			System.out.println("##################");
//			System.out.println("QUERY: -APE- findBySiceeTCertificatoreAndFlgVerificatoEquals: "+queryTmp);
//			System.out.println("##################");
//			System.out.println("##################");
			
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_ACE, FK_TIPO_PAGAMENTO, NUM_TRANSAZIONE, DATA_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA, FK_CERTIFICATORE FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? AND " + buf.toString() + " ORDER BY DATA_TRANSAZIONE DESC", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneAceDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_TRANSAZIONE_ACE table that matches the specified primary-key value.
	 */
	public SiceeTTransazioneAce findByPrimaryKey(SiceeTTransazioneAcePk pk) throws SiceeTTransazioneAceDaoException
	{
		return findByPrimaryKey( pk.getIdTransazioneAce() );
	}

}
