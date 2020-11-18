/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiEner2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTDatiEner2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDatiEner2015>, SiceeTDatiEner2015Dao
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
	 * @return SiceeTDatiEner2015Pk
	 */
	
	public SiceeTDatiEner2015Pk insert(SiceeTDatiEner2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkClasseEnergetica(),dto.getFkCeRaccTotale(),dto.getFkClasseEnerEsistenti(),dto.getFkClasseEnerNuovi(),dto.getEph(),dto.getEphLimite(),dto.getYie(),dto.getAsolAsup(),dto.getFlgEdifE0(),dto.getFlgClimatInvernale(),dto.getFlgClimatEstiva(),dto.getFlgVentilMeccanica(),dto.getFlgProdH2oSanitaria(),dto.getFlgIlluminazione(),dto.getFlgTrasportoPersCose(),dto.getEnergiaEsportata(),dto.getEpglNrenRaccTotale(),dto.getEpglRenGlobale(),dto.getEpglNrenGlobale(),dto.getEmissioniCo2(),dto.getEpglNrenNuovi(),dto.getEpglNrenEsistenti(),dto.getEpglNrenRif(),dto.getFlgSmileInverno(),dto.getFlgSmileEstate(),dto.getRapportoSv());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_DATI_ENER_2015 table.
	 */
	
	public void update(SiceeTDatiEner2015Pk pk, SiceeTDatiEner2015 dto) throws SiceeTDatiEner2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, FK_CLASSE_ENERGETICA = ?, FK_CE_RACC_TOTALE = ?, FK_CLASSE_ENER_ESISTENTI = ?, FK_CLASSE_ENER_NUOVI = ?, EPH = ?, EPH_LIMITE = ?, YIE = ?, ASOL_ASUP = ?, FLG_EDIF_E0 = ?, FLG_CLIMAT_INVERNALE = ?, FLG_CLIMAT_ESTIVA = ?, FLG_VENTIL_MECCANICA = ?, FLG_PROD_H2O_SANITARIA = ?, FLG_ILLUMINAZIONE = ?, FLG_TRASPORTO_PERS_COSE = ?, ENERGIA_ESPORTATA = ?, EPGL_NREN_RACC_TOTALE = ?, EPGL_REN_GLOBALE = ?, EPGL_NREN_GLOBALE = ?, EMISSIONI_CO2 = ?, EPGL_NREN_NUOVI = ?, EPGL_NREN_ESISTENTI = ?, EPGL_NREN_RIF = ?, FLG_SMILE_INVERNO = ?, FLG_SMILE_ESTATE = ?, RAPPORTO_SV = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getFkClasseEnergetica(),dto.getFkCeRaccTotale(),dto.getFkClasseEnerEsistenti(),dto.getFkClasseEnerNuovi(),dto.getEph(),dto.getEphLimite(),dto.getYie(),dto.getAsolAsup(),dto.getFlgEdifE0(),dto.getFlgClimatInvernale(),dto.getFlgClimatEstiva(),dto.getFlgVentilMeccanica(),dto.getFlgProdH2oSanitaria(),dto.getFlgIlluminazione(),dto.getFlgTrasportoPersCose(),dto.getEnergiaEsportata(),dto.getEpglNrenRaccTotale(),dto.getEpglRenGlobale(),dto.getEpglNrenGlobale(),dto.getEmissioniCo2(),dto.getEpglNrenNuovi(),dto.getEpglNrenEsistenti(),dto.getEpglNrenRif(),dto.getFlgSmileInverno(),dto.getFlgSmileEstate(),dto.getRapportoSv(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_T_DATI_ENER_2015 table.
	 */
	
	public void delete(SiceeTDatiEner2015Pk pk) throws SiceeTDatiEner2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTDatiEner2015
	 */
	public SiceeTDatiEner2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTDatiEner2015 dto = new SiceeTDatiEner2015();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setFkClasseEnergetica( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setFkClasseEnergetica( null );
		}
		
		dto.setFkCeRaccTotale( new Integer( rs.getInt(5) ) );
		if (rs.wasNull()) {
			dto.setFkCeRaccTotale( null );
		}
		
		dto.setFkClasseEnerEsistenti( new Integer( rs.getInt(6) ) );
		if (rs.wasNull()) {
			dto.setFkClasseEnerEsistenti( null );
		}
		
		dto.setFkClasseEnerNuovi( new Integer( rs.getInt(7) ) );
		if (rs.wasNull()) {
			dto.setFkClasseEnerNuovi( null );
		}
		
		dto.setEph( new Double( rs.getDouble(8) ) );
		if (rs.wasNull()) {
			dto.setEph( null );
		}
		
		dto.setEphLimite( new Double( rs.getDouble(9) ) );
		if (rs.wasNull()) {
			dto.setEphLimite( null );
		}
		
		dto.setYie( new Double( rs.getDouble(10) ) );
		if (rs.wasNull()) {
			dto.setYie( null );
		}
		
		dto.setAsolAsup( new Double( rs.getDouble(11) ) );
		if (rs.wasNull()) {
			dto.setAsolAsup( null );
		}
		
		dto.setFlgEdifE0( rs.getString( 12 ) );
		dto.setFlgClimatInvernale( rs.getString( 13 ) );
		dto.setFlgClimatEstiva( rs.getString( 14 ) );
		dto.setFlgVentilMeccanica( rs.getString( 15 ) );
		dto.setFlgProdH2oSanitaria( rs.getString( 16 ) );
		dto.setFlgIlluminazione( rs.getString( 17 ) );
		dto.setFlgTrasportoPersCose( rs.getString( 18 ) );
		dto.setEnergiaEsportata( new Double( rs.getDouble(19) ) );
		if (rs.wasNull()) {
			dto.setEnergiaEsportata( null );
		}
		
		dto.setEpglNrenRaccTotale( new Double( rs.getDouble(20) ) );
		if (rs.wasNull()) {
			dto.setEpglNrenRaccTotale( null );
		}
		
		dto.setEpglRenGlobale( new Double( rs.getDouble(21) ) );
		if (rs.wasNull()) {
			dto.setEpglRenGlobale( null );
		}
		
		dto.setEpglNrenGlobale( new Double( rs.getDouble(22) ) );
		if (rs.wasNull()) {
			dto.setEpglNrenGlobale( null );
		}
		
		dto.setEmissioniCo2( new Double( rs.getDouble(23) ) );
		if (rs.wasNull()) {
			dto.setEmissioniCo2( null );
		}
		
		dto.setEpglNrenNuovi( new Double( rs.getDouble(24) ) );
		if (rs.wasNull()) {
			dto.setEpglNrenNuovi( null );
		}
		
		dto.setEpglNrenEsistenti( new Double( rs.getDouble(25) ) );
		if (rs.wasNull()) {
			dto.setEpglNrenEsistenti( null );
		}
		
		dto.setEpglNrenRif( new Double( rs.getDouble(26) ) );
		if (rs.wasNull()) {
			dto.setEpglNrenRif( null );
		}
		
		dto.setFlgSmileInverno( new Integer( rs.getInt(27) ) );
		if (rs.wasNull()) {
			dto.setFlgSmileInverno( null );
		}
		
		dto.setFlgSmileEstate( new Integer( rs.getInt(28) ) );
		if (rs.wasNull()) {
			dto.setFlgSmileEstate( null );
		}
		
		dto.setRapportoSv( new Double( rs.getDouble(29) ) );
		if (rs.wasNull()) {
			dto.setRapportoSv( null );
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
		return "SICEE_T_DATI_ENER_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTDatiEner2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiEner2015DaoException
	{
		try {
			List<SiceeTDatiEner2015> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}
	
	/**
	 * QUESTO METODO E' PER RECUPERARE GLI APE CHE NON HANNO GLI SMILE E RAPPORTO S/V - è un trattamento dati 
	 */
	public List<SiceeTDatiEner2015> findAllSenzaSmile() throws SiceeTDatiEner2015DaoException
	{
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT de.ID_CERTIFICATORE, de.PROGR_CERTIFICATO, de.ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV ");
			sb.append("FROM SICEE_T_DATI_ENER_2015 de, SICEE_T_CERTIFICATO c ");

			sb.append("WHERE de.id_certificatore = c.id_certificatore ");
			sb.append("AND de.progr_certificato = c.progr_certificato ");
			sb.append("AND de.anno = c.anno ");
			sb.append("AND c.fk_stato not in (0,1) ");
			sb.append("AND c.flg_old = 'N' ");
			sb.append("AND FLG_SMILE_INVERNO IS NULL ");
			sb.append("AND FLG_SMILE_ESTATE IS NULL ");
			sb.append("AND rownum <= (SELECT VALORE FROM SICEE_T_PARAMETRI WHERE CODICE='NUMERO_MAX_ACE_TRATTAMENTO')");
			
			return jdbcTemplate.query(sb.toString(), this);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTDatiEner2015> findAll() throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? ORDER BY ID_CERTIFICATORE", this,idCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE PROGR_CERTIFICATO = ? ORDER BY PROGR_CERTIFICATO", this,progrCertificato);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ANNO = :anno'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereAnnoEquals(String anno) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE ANNO = ? ORDER BY ANNO", this,anno);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CLASSE_ENERGETICA = :fkClasseEnergetica'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFkClasseEnergeticaEquals(Integer fkClasseEnergetica) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FK_CLASSE_ENERGETICA = ? ORDER BY FK_CLASSE_ENERGETICA", this,fkClasseEnergetica);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CE_RACC_TOTALE = :fkCeRaccTotale'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFkCeRaccTotaleEquals(Integer fkCeRaccTotale) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FK_CE_RACC_TOTALE = ? ORDER BY FK_CE_RACC_TOTALE", this,fkCeRaccTotale);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CLASSE_ENER_ESISTENTI = :fkClasseEnerEsistenti'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFkClasseEnerEsistentiEquals(Integer fkClasseEnerEsistenti) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FK_CLASSE_ENER_ESISTENTI = ? ORDER BY FK_CLASSE_ENER_ESISTENTI", this,fkClasseEnerEsistenti);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CLASSE_ENER_NUOVI = :fkClasseEnerNuovi'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFkClasseEnerNuoviEquals(Integer fkClasseEnerNuovi) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FK_CLASSE_ENER_NUOVI = ? ORDER BY FK_CLASSE_ENER_NUOVI", this,fkClasseEnerNuovi);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPH = :eph'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEphEquals(Double eph) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPH = ? ORDER BY EPH", this,eph);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPH_LIMITE = :ephLimite'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEphLimiteEquals(Double ephLimite) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPH_LIMITE = ? ORDER BY EPH_LIMITE", this,ephLimite);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'YIE = :yie'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereYieEquals(Double yie) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE YIE = ? ORDER BY YIE", this,yie);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ASOL_ASUP = :asolAsup'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereAsolAsupEquals(Double asolAsup) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE ASOL_ASUP = ? ORDER BY ASOL_ASUP", this,asolAsup);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_EDIF_E0 = :flgEdifE0'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFlgEdifE0Equals(String flgEdifE0) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FLG_EDIF_E0 = ? ORDER BY FLG_EDIF_E0", this,flgEdifE0);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_CLIMAT_INVERNALE = :flgClimatInvernale'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFlgClimatInvernaleEquals(String flgClimatInvernale) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FLG_CLIMAT_INVERNALE = ? ORDER BY FLG_CLIMAT_INVERNALE", this,flgClimatInvernale);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_CLIMAT_ESTIVA = :flgClimatEstiva'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFlgClimatEstivaEquals(String flgClimatEstiva) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FLG_CLIMAT_ESTIVA = ? ORDER BY FLG_CLIMAT_ESTIVA", this,flgClimatEstiva);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_VENTIL_MECCANICA = :flgVentilMeccanica'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFlgVentilMeccanicaEquals(String flgVentilMeccanica) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FLG_VENTIL_MECCANICA = ? ORDER BY FLG_VENTIL_MECCANICA", this,flgVentilMeccanica);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_PROD_H2O_SANITARIA = :flgProdH2oSanitaria'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFlgProdH2oSanitariaEquals(String flgProdH2oSanitaria) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FLG_PROD_H2O_SANITARIA = ? ORDER BY FLG_PROD_H2O_SANITARIA", this,flgProdH2oSanitaria);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_ILLUMINAZIONE = :flgIlluminazione'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFlgIlluminazioneEquals(String flgIlluminazione) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FLG_ILLUMINAZIONE = ? ORDER BY FLG_ILLUMINAZIONE", this,flgIlluminazione);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_TRASPORTO_PERS_COSE = :flgTrasportoPersCose'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereFlgTrasportoPersCoseEquals(String flgTrasportoPersCose) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE FLG_TRASPORTO_PERS_COSE = ? ORDER BY FLG_TRASPORTO_PERS_COSE", this,flgTrasportoPersCose);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ENERGIA_ESPORTATA = :energiaEsportata'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEnergiaEsportataEquals(Double energiaEsportata) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE ENERGIA_ESPORTATA = ? ORDER BY ENERGIA_ESPORTATA", this,energiaEsportata);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_RACC_TOTALE = :epglNrenRaccTotale'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEpglNrenRaccTotaleEquals(Double epglNrenRaccTotale) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPGL_NREN_RACC_TOTALE = ? ORDER BY EPGL_NREN_RACC_TOTALE", this,epglNrenRaccTotale);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_REN_GLOBALE = :epglRenGlobale'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEpglRenGlobaleEquals(Double epglRenGlobale) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPGL_REN_GLOBALE = ? ORDER BY EPGL_REN_GLOBALE", this,epglRenGlobale);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_GLOBALE = :epglNrenGlobale'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEpglNrenGlobaleEquals(Double epglNrenGlobale) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPGL_NREN_GLOBALE = ? ORDER BY EPGL_NREN_GLOBALE", this,epglNrenGlobale);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EMISSIONI_CO2 = :emissioniCo2'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEmissioniCo2Equals(Double emissioniCo2) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EMISSIONI_CO2 = ? ORDER BY EMISSIONI_CO2", this,emissioniCo2);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_NUOVI = :epglNrenNuovi'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEpglNrenNuoviEquals(Double epglNrenNuovi) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPGL_NREN_NUOVI = ? ORDER BY EPGL_NREN_NUOVI", this,epglNrenNuovi);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_ESISTENTI = :epglNrenEsistenti'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEpglNrenEsistentiEquals(Double epglNrenEsistenti) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPGL_NREN_ESISTENTI = ? ORDER BY EPGL_NREN_ESISTENTI", this,epglNrenEsistenti);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_RIF = :epglNrenRif'.
	 */
	
	public List<SiceeTDatiEner2015> findWhereEpglNrenRifEquals(Double epglNrenRif) throws SiceeTDatiEner2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, FK_CLASSE_ENERGETICA, FK_CE_RACC_TOTALE, FK_CLASSE_ENER_ESISTENTI, FK_CLASSE_ENER_NUOVI, EPH, EPH_LIMITE, YIE, ASOL_ASUP, FLG_EDIF_E0, FLG_CLIMAT_INVERNALE, FLG_CLIMAT_ESTIVA, FLG_VENTIL_MECCANICA, FLG_PROD_H2O_SANITARIA, FLG_ILLUMINAZIONE, FLG_TRASPORTO_PERS_COSE, ENERGIA_ESPORTATA, EPGL_NREN_RACC_TOTALE, EPGL_REN_GLOBALE, EPGL_NREN_GLOBALE, EMISSIONI_CO2, EPGL_NREN_NUOVI, EPGL_NREN_ESISTENTI, EPGL_NREN_RIF, FLG_SMILE_INVERNO, FLG_SMILE_ESTATE, RAPPORTO_SV FROM " + getTableName() + " WHERE EPGL_NREN_RIF = ? ORDER BY EPGL_NREN_RIF", this,epglNrenRif);
		}
		catch (Exception e) {
			throw new SiceeTDatiEner2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_DATI_ENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiEner2015 findByPrimaryKey(SiceeTDatiEner2015Pk pk) throws SiceeTDatiEner2015DaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
