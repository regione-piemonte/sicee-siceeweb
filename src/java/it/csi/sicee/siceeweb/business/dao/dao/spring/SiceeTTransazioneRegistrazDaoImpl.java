/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneRegistrazDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistraz;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistrazPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazioneRegistrazDaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTTransazioneRegistrazDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTTransazioneRegistraz>, SiceeTTransazioneRegistrazDao
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
	 * @return SiceeTTransazioneRegistrazPk
	 */
	
	public SiceeTTransazioneRegistrazPk insert(SiceeTTransazioneRegistraz dto)
	{
		dto.setIdTransazioneReg(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdTransazioneReg(),dto.getFkCertificatore(),dto.getFkTipoPagamento(),dto.getDataTransazione(),dto.getNumTransazione(),dto.getFlgVerificato(),dto.getEseguitoNome(),dto.getEseguitoCognome(),dto.getAnno(),dto.getQuantita());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_TRANSAZIONE_REGISTRAZ table.
	 */
	
	public void update(SiceeTTransazioneRegistrazPk pk, SiceeTTransazioneRegistraz dto) throws SiceeTTransazioneRegistrazDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TRANSAZIONE_REG = ?, FK_CERTIFICATORE = ?, FK_TIPO_PAGAMENTO = ?, DATA_TRANSAZIONE = ?, NUM_TRANSAZIONE = ?, FLG_VERIFICATO = ?, ESEGUITO_NOME = ?, ESEGUITO_COGNOME = ?, ANNO = ?, QUANTITA = ? WHERE ID_TRANSAZIONE_REG = ?",dto.getIdTransazioneReg(),dto.getFkCertificatore(),dto.getFkTipoPagamento(),dto.getDataTransazione(),dto.getNumTransazione(),dto.getFlgVerificato(),dto.getEseguitoNome(),dto.getEseguitoCognome(),dto.getAnno(),dto.getQuantita(),pk.getIdTransazioneReg());
	}

	/** 
	 * Deletes a single row in the SICEE_T_TRANSAZIONE_REGISTRAZ table.
	 */
	
	public void delete(SiceeTTransazioneRegistrazPk pk) throws SiceeTTransazioneRegistrazDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TRANSAZIONE_REG = ?",pk.getIdTransazioneReg());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTTransazioneRegistraz
	 */
	public SiceeTTransazioneRegistraz mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTTransazioneRegistraz dto = new SiceeTTransazioneRegistraz();
		dto.setIdTransazioneReg( rs.getLong( 1 ) );
		dto.setFkCertificatore( rs.getString( 2 ) );
		dto.setFkTipoPagamento( new Integer( rs.getInt(3) ) );
		dto.setDataTransazione( rs.getTimestamp(4 ) );
		dto.setNumTransazione( rs.getString( 5 ) );
		dto.setFlgVerificato( rs.getString( 6 ) );
		dto.setEseguitoNome( rs.getString( 7 ) );
		dto.setEseguitoCognome( rs.getString( 8 ) );
		dto.setAnno( rs.getString( 9 ) );
		dto.setQuantita( new Integer( rs.getInt(10) ) );
		if (rs.wasNull()) {
			dto.setQuantita( null );
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
		return "SICEE_T_TRANSAZIONE_REGISTRAZ";
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ID_TRANSAZIONE_REG = :idTransazioneReg'.
	 */
	
	public SiceeTTransazioneRegistraz findByPrimaryKey(long idTransazioneReg) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			List<SiceeTTransazioneRegistraz> list = jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE ID_TRANSAZIONE_REG = ?", this,idTransazioneReg);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria ''.
	 */
	
	public List<SiceeTTransazioneRegistraz> findAll() throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " ORDER BY ID_TRANSAZIONE_REG", this);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findBySiceeTCertificatore(String fkCertificatore) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ?", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ID_TRANSAZIONE_REG = :idTransazioneReg'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereIdTransazioneRegEquals(long idTransazioneReg) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE ID_TRANSAZIONE_REG = ? ORDER BY ID_TRANSAZIONE_REG", this,idTransazioneReg);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? ORDER BY FK_CERTIFICATORE", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FK_TIPO_PAGAMENTO = :fkTipoPagamento'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereFkTipoPagamentoEquals(Integer fkTipoPagamento) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE FK_TIPO_PAGAMENTO = ? ORDER BY FK_TIPO_PAGAMENTO", this,fkTipoPagamento);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'DATA_TRANSAZIONE = :dataTransazione'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereDataTransazioneEquals(Date dataTransazione) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE DATA_TRANSAZIONE = ? ORDER BY DATA_TRANSAZIONE", this,dataTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'NUM_TRANSAZIONE = :numTransazione'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereNumTransazioneEquals(String numTransazione) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE NUM_TRANSAZIONE = ? ORDER BY NUM_TRANSAZIONE", this,numTransazione);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FLG_VERIFICATO = :flgVerificato'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereFlgVerificatoEquals(String flgVerificato) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE FLG_VERIFICATO = ? ORDER BY FLG_VERIFICATO", this,flgVerificato);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ESEGUITO_NOME = :eseguitoNome'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereEseguitoNomeEquals(String eseguitoNome) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE ESEGUITO_NOME = ? ORDER BY ESEGUITO_NOME", this,eseguitoNome);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ESEGUITO_COGNOME = :eseguitoCognome'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereEseguitoCognomeEquals(String eseguitoCognome) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE ESEGUITO_COGNOME = ? ORDER BY ESEGUITO_COGNOME", this,eseguitoCognome);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereAnnoEquals(String anno) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'QUANTITA = :quantita'.
	 */
	
	public List<SiceeTTransazioneRegistraz> findWhereQuantitaEquals(Integer quantita) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE QUANTITA = ? ORDER BY QUANTITA", this,quantita);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore AND FLG_VERIFICATO = 'E''.
	 */
	
	public List<SiceeTTransazioneRegistraz> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? AND FLG_VERIFICATO = 'E' ORDER BY DATA_TRANSAZIONE DESC", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}
	
	public List<SiceeTTransazioneRegistraz> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore, String... flgVerificato) throws SiceeTTransazioneRegistrazDaoException
	{
		try {
			StringBuffer buf = new StringBuffer("FLG_VERIFICATO IN (");
			
			for(int i = 0; i < flgVerificato.length - 1; i++) {
				buf.append("'" + flgVerificato[i] + "', ");				
			}
			buf.append("'" + flgVerificato[flgVerificato.length - 1] +"'");
			buf.append(")");

			String queryTmp = "SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? AND " + buf.toString() + " ORDER BY DATA_TRANSAZIONE DESC";
			
//			System.out.println("##################");
//			System.out.println("##################");
//			System.out.println("QUERY: -REGISTRAZIONI- findBySiceeTCertificatoreAndFlgVerificatoEquals: "+queryTmp);
//			System.out.println("##################");
//			System.out.println("##################");

			
			return jdbcTemplate.query("SELECT ID_TRANSAZIONE_REG, FK_CERTIFICATORE, FK_TIPO_PAGAMENTO, DATA_TRANSAZIONE, NUM_TRANSAZIONE, FLG_VERIFICATO, ESEGUITO_NOME, ESEGUITO_COGNOME, ANNO, QUANTITA FROM " + getTableName() + " WHERE FK_CERTIFICATORE = ? AND " + buf.toString() + " ORDER BY DATA_TRANSAZIONE DESC", this,fkCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTTransazioneRegistrazDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that matches the specified primary-key value.
	 */
	public SiceeTTransazioneRegistraz findByPrimaryKey(SiceeTTransazioneRegistrazPk pk) throws SiceeTTransazioneRegistrazDaoException
	{
		return findByPrimaryKey( pk.getIdTransazioneReg() );
	}

}
