/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImpRiscaldamentoAcsDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpRiscaldamentoAcs;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpRiscaldamentoAcsPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImpRiscaldamentoAcsDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTImpRiscaldamentoAcsDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTImpRiscaldamentoAcs>, SiceeTImpRiscaldamentoAcsDao
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
	 * @return SiceeTImpRiscaldamentoAcsPk
	 */
	
	public SiceeTImpRiscaldamentoAcsPk insert(SiceeTImpRiscaldamentoAcs dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFlgBollino(),dto.getFkClasseEffRisc(),dto.getCodiceImpianto(),dto.getFkClasseEffAcs(),dto.getFkCombustibileRisc(),dto.getNumeroBollino(),dto.getGenAnnoRisc(),dto.getFkCombustibileAcs(),dto.getPotRiscaldamento(),dto.getGenAnnoAcs(),dto.getPotAcs());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	
	public void update(SiceeTImpRiscaldamentoAcsPk pk, SiceeTImpRiscaldamentoAcs dto) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FLG_BOLLINO = ?, FK_CLASSE_EFF_RISC = ?, CODICE_IMPIANTO = ?, FK_CLASSE_EFF_ACS = ?, FK_COMBUSTIBILE_RISC = ?, NUMERO_BOLLINO = ?, GEN_ANNO_RISC = ?, FK_COMBUSTIBILE_ACS = ?, POT_RISCALDAMENTO = ?, GEN_ANNO_ACS = ?, POT_ACS = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFlgBollino(),dto.getFkClasseEffRisc(),dto.getCodiceImpianto(),dto.getFkClasseEffAcs(),dto.getFkCombustibileRisc(),dto.getNumeroBollino(),dto.getGenAnnoRisc(),dto.getFkCombustibileAcs(),dto.getPotRiscaldamento(),dto.getGenAnnoAcs(),dto.getPotAcs(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	
	public void delete(SiceeTImpRiscaldamentoAcsPk pk) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTImpRiscaldamentoAcs
	 */
	public SiceeTImpRiscaldamentoAcs mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTImpRiscaldamentoAcs dto = new SiceeTImpRiscaldamentoAcs();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFlgBollino( rs.getString( 4 ) );
		dto.setFkClasseEffRisc( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setFkClasseEffRisc( null );
		}
		
		dto.setCodiceImpianto( rs.getString( 6 ) );
		dto.setFkClasseEffAcs( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setFkClasseEffAcs( null );
		}
		
		dto.setFkCombustibileRisc( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setFkCombustibileRisc( null );
		}
		
		dto.setNumeroBollino( rs.getString( 9 ) );
		dto.setGenAnnoRisc( new Integer( rs.getInt(10) ) );
		if (rs.wasNull()) {
			dto.setGenAnnoRisc( null );
		}
		
		dto.setFkCombustibileAcs( new Integer( rs.getInt(11) ) );
		if (rs.wasNull()) {
			dto.setFkCombustibileAcs( null );
		}
		
		dto.setPotRiscaldamento( new Double( rs.getDouble(12) ) );
		if (rs.wasNull()) {
			dto.setPotRiscaldamento( null );
		}
		
		dto.setGenAnnoAcs( new Integer( rs.getInt(13) ) );
		if (rs.wasNull()) {
			dto.setGenAnnoAcs( null );
		}
		
		dto.setPotAcs( new Double( rs.getDouble(14) ) );
		if (rs.wasNull()) {
			dto.setPotAcs( null );
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
		return "SICEE_T_IMP_RISCALDAMENTO_ACS";
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTImpRiscaldamentoAcs findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			List<SiceeTImpRiscaldamentoAcs> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria ''.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findAll() throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereAnnoEquals(String anno) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FLG_BOLLINO = :flgBollino'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereFlgBollinoEquals(String flgBollino) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE FLG_BOLLINO = ? ORDER BY FLG_BOLLINO", this,flgBollino);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_CLASSE_EFF_RISC = :fkClasseEffRisc'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkClasseEffRiscEquals(Integer fkClasseEffRisc) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE FK_CLASSE_EFF_RISC = ? ORDER BY FK_CLASSE_EFF_RISC", this,fkClasseEffRisc);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'CODICE_IMPIANTO = :codiceImpianto'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereCodiceImpiantoEquals(String codiceImpianto) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE CODICE_IMPIANTO = ? ORDER BY CODICE_IMPIANTO", this,codiceImpianto);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_CLASSE_EFF_ACS = :fkClasseEffAcs'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkClasseEffAcsEquals(Integer fkClasseEffAcs) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE FK_CLASSE_EFF_ACS = ? ORDER BY FK_CLASSE_EFF_ACS", this,fkClasseEffAcs);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_COMBUSTIBILE_RISC = :fkCombustibileRisc'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkCombustibileRiscEquals(Integer fkCombustibileRisc) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE FK_COMBUSTIBILE_RISC = ? ORDER BY FK_COMBUSTIBILE_RISC", this,fkCombustibileRisc);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'NUMERO_BOLLINO = :numeroBollino'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereNumeroBollinoEquals(String numeroBollino) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE NUMERO_BOLLINO = ? ORDER BY NUMERO_BOLLINO", this,numeroBollino);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'GEN_ANNO_RISC = :genAnnoRisc'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereGenAnnoRiscEquals(Integer genAnnoRisc) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE GEN_ANNO_RISC = ? ORDER BY GEN_ANNO_RISC", this,genAnnoRisc);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_COMBUSTIBILE_ACS = :fkCombustibileAcs'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkCombustibileAcsEquals(Integer fkCombustibileAcs) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE FK_COMBUSTIBILE_ACS = ? ORDER BY FK_COMBUSTIBILE_ACS", this,fkCombustibileAcs);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'POT_RISCALDAMENTO = :potRiscaldamento'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWherePotRiscaldamentoEquals(Double potRiscaldamento) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE POT_RISCALDAMENTO = ? ORDER BY POT_RISCALDAMENTO", this,potRiscaldamento);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'GEN_ANNO_ACS = :genAnnoAcs'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWhereGenAnnoAcsEquals(Integer genAnnoAcs) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE GEN_ANNO_ACS = ? ORDER BY GEN_ANNO_ACS", this,genAnnoAcs);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'POT_ACS = :potAcs'.
	 */
	
	public List<SiceeTImpRiscaldamentoAcs> findWherePotAcsEquals(Double potAcs) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FLG_BOLLINO, FK_CLASSE_EFF_RISC, CODICE_IMPIANTO, FK_CLASSE_EFF_ACS, FK_COMBUSTIBILE_RISC, NUMERO_BOLLINO, GEN_ANNO_RISC, FK_COMBUSTIBILE_ACS, POT_RISCALDAMENTO, GEN_ANNO_ACS, POT_ACS FROM " + getTableName() + " WHERE POT_ACS = ? ORDER BY POT_ACS", this,potAcs);
		}
		catch (Exception e) {
			throw new SiceeTImpRiscaldamentoAcsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that matches the specified primary-key value.
	 */
	public SiceeTImpRiscaldamentoAcs findByPrimaryKey(SiceeTImpRiscaldamentoAcsPk pk) throws SiceeTImpRiscaldamentoAcsDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
