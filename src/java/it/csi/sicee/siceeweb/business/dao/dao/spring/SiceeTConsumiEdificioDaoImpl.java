/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTConsumiEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTConsumiEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTConsumiEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTConsumiEdificioDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTConsumiEdificioDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTConsumiEdificio>, SiceeTConsumiEdificioDao
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
	 * @return SiceeTConsumiEdificioPk
	 */
	
	public SiceeTConsumiEdificioPk insert(SiceeTConsumiEdificio dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDescTipoErog(),dto.getFkTipoImpianto(),dto.getDescTipoDistrib(),dto.getDescTipoReg(),dto.getAnnTermiFossile(),dto.getAnnElettFossile(),dto.getAnnTermiRinno(),dto.getAnnElettRinno(),dto.getComplessTermico(),dto.getComplessElettrico(),dto.getUiServite(),dto.getFlgContRip());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	
	public void update(SiceeTConsumiEdificioPk pk, SiceeTConsumiEdificio dto) throws SiceeTConsumiEdificioDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, DESC_TIPO_EROG = ?, FK_TIPO_IMPIANTO = ?, DESC_TIPO_DISTRIB = ?, DESC_TIPO_REG = ?, ANN_TERMI_FOSSILE = ?, ANN_ELETT_FOSSILE = ?, ANN_TERMI_RINNO = ?, ANN_ELETT_RINNO = ?, COMPLESS_TERMICO = ?, COMPLESS_ELETTRICO = ?, UI_SERVITE = ?, FLG_CONT_RIP = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDescTipoErog(),dto.getFkTipoImpianto(),dto.getDescTipoDistrib(),dto.getDescTipoReg(),dto.getAnnTermiFossile(),dto.getAnnElettFossile(),dto.getAnnTermiRinno(),dto.getAnnElettRinno(),dto.getComplessTermico(),dto.getComplessElettrico(),dto.getUiServite(),dto.getFlgContRip(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	
	public void delete(SiceeTConsumiEdificioPk pk) throws SiceeTConsumiEdificioDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTConsumiEdificio
	 */
	public SiceeTConsumiEdificio mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTConsumiEdificio dto = new SiceeTConsumiEdificio();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setDescTipoErog( rs.getString( 4 ) );
		dto.setFkTipoImpianto( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setFkTipoImpianto( null );
		}
		
		dto.setDescTipoDistrib( rs.getString( 6 ) );
		dto.setDescTipoReg( rs.getString( 7 ) );
		dto.setAnnTermiFossile( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setAnnTermiFossile( null );
		}
		
		dto.setAnnElettFossile( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setAnnElettFossile( null );
		}
		
		dto.setAnnTermiRinno( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setAnnTermiRinno( null );
		}
		
		dto.setAnnElettRinno( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setAnnElettRinno( null );
		}
		
		dto.setComplessTermico( new Double( rs.getDouble(12) ) );
		if (rs.wasNull()) {
			dto.setComplessTermico( null );
		}
		
		dto.setComplessElettrico( new Double( rs.getDouble(13) ) );
		if (rs.wasNull()) {
			dto.setComplessElettrico( null );
		}
		
		dto.setUiServite( rs.getString( 14 ) );
		dto.setFlgContRip( rs.getString( 15 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_CONSUMI_EDIFICIO";
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTConsumiEdificio findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTConsumiEdificioDaoException
	{
		try {
			List<SiceeTConsumiEdificio> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria ''.
	 */
	
	public List<SiceeTConsumiEdificio> findAll() throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTConsumiEdificio> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereAnnoEquals(String anno) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'DESC_TIPO_EROG = :descTipoErog'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereDescTipoErogEquals(String descTipoErog) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE DESC_TIPO_EROG = ? ORDER BY DESC_TIPO_EROG", this,descTipoErog);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'FK_TIPO_IMPIANTO = :fkTipoImpianto'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereFkTipoImpiantoEquals(Integer fkTipoImpianto) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE FK_TIPO_IMPIANTO = ? ORDER BY FK_TIPO_IMPIANTO", this,fkTipoImpianto);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'DESC_TIPO_DISTRIB = :descTipoDistrib'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereDescTipoDistribEquals(String descTipoDistrib) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE DESC_TIPO_DISTRIB = ? ORDER BY DESC_TIPO_DISTRIB", this,descTipoDistrib);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'DESC_TIPO_REG = :descTipoReg'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereDescTipoRegEquals(String descTipoReg) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE DESC_TIPO_REG = ? ORDER BY DESC_TIPO_REG", this,descTipoReg);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_TERMI_FOSSILE = :annTermiFossile'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereAnnTermiFossileEquals(Double annTermiFossile) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ANN_TERMI_FOSSILE = ? ORDER BY ANN_TERMI_FOSSILE", this,annTermiFossile);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_ELETT_FOSSILE = :annElettFossile'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereAnnElettFossileEquals(Double annElettFossile) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ANN_ELETT_FOSSILE = ? ORDER BY ANN_ELETT_FOSSILE", this,annElettFossile);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_TERMI_RINNO = :annTermiRinno'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereAnnTermiRinnoEquals(Double annTermiRinno) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ANN_TERMI_RINNO = ? ORDER BY ANN_TERMI_RINNO", this,annTermiRinno);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_ELETT_RINNO = :annElettRinno'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereAnnElettRinnoEquals(Double annElettRinno) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE ANN_ELETT_RINNO = ? ORDER BY ANN_ELETT_RINNO", this,annElettRinno);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'COMPLESS_TERMICO = :complessTermico'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereComplessTermicoEquals(Double complessTermico) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE COMPLESS_TERMICO = ? ORDER BY COMPLESS_TERMICO", this,complessTermico);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'COMPLESS_ELETTRICO = :complessElettrico'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereComplessElettricoEquals(Double complessElettrico) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE COMPLESS_ELETTRICO = ? ORDER BY COMPLESS_ELETTRICO", this,complessElettrico);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'UI_SERVITE = :uiServite'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereUiServiteEquals(String uiServite) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE UI_SERVITE = ? ORDER BY UI_SERVITE", this,uiServite);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'FLG_CONT_RIP = :flgContRip'.
	 */
	
	public List<SiceeTConsumiEdificio> findWhereFlgContRipEquals(String flgContRip) throws SiceeTConsumiEdificioDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DESC_TIPO_EROG, FK_TIPO_IMPIANTO, DESC_TIPO_DISTRIB, DESC_TIPO_REG, ANN_TERMI_FOSSILE, ANN_ELETT_FOSSILE, ANN_TERMI_RINNO, ANN_ELETT_RINNO, COMPLESS_TERMICO, COMPLESS_ELETTRICO, UI_SERVITE, FLG_CONT_RIP FROM " + getTableName() + " WHERE FLG_CONT_RIP = ? ORDER BY FLG_CONT_RIP", this,flgContRip);
		}
		catch (Exception e) {
			throw new SiceeTConsumiEdificioDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_CONSUMI_EDIFICIO table that matches the specified primary-key value.
	 */
	public SiceeTConsumiEdificio findByPrimaryKey(SiceeTConsumiEdificioPk pk) throws SiceeTConsumiEdificioDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
