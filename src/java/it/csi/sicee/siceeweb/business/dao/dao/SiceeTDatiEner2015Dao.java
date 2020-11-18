/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiEner2015DaoException;
import java.util.List;

public interface SiceeTDatiEner2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDatiEner2015Pk
	 */
	public SiceeTDatiEner2015Pk insert(SiceeTDatiEner2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_DATI_ENER_2015 table.
	 */
	public void update(SiceeTDatiEner2015Pk pk, SiceeTDatiEner2015 dto) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_ENER_2015 table.
	 */
	public void delete(SiceeTDatiEner2015Pk pk) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTDatiEner2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria ''.
	 */
	public List<SiceeTDatiEner2015> findAll() throws SiceeTDatiEner2015DaoException;

	/**
	 * QUESTO METODO E' PER RECUPERARE GLI APE CHE NON HANNO GLI SMILE E RAPPORTO S/V - è un trattamento dati 
	 */
	public List<SiceeTDatiEner2015> findAllSenzaSmile() throws SiceeTDatiEner2015DaoException;
	
	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTDatiEner2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTDatiEner2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTDatiEner2015> findWhereAnnoEquals(String anno) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CLASSE_ENERGETICA = :fkClasseEnergetica'.
	 */
	public List<SiceeTDatiEner2015> findWhereFkClasseEnergeticaEquals(Integer fkClasseEnergetica) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CE_RACC_TOTALE = :fkCeRaccTotale'.
	 */
	public List<SiceeTDatiEner2015> findWhereFkCeRaccTotaleEquals(Integer fkCeRaccTotale) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CLASSE_ENER_ESISTENTI = :fkClasseEnerEsistenti'.
	 */
	public List<SiceeTDatiEner2015> findWhereFkClasseEnerEsistentiEquals(Integer fkClasseEnerEsistenti) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FK_CLASSE_ENER_NUOVI = :fkClasseEnerNuovi'.
	 */
	public List<SiceeTDatiEner2015> findWhereFkClasseEnerNuoviEquals(Integer fkClasseEnerNuovi) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPH = :eph'.
	 */
	public List<SiceeTDatiEner2015> findWhereEphEquals(Double eph) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPH_LIMITE = :ephLimite'.
	 */
	public List<SiceeTDatiEner2015> findWhereEphLimiteEquals(Double ephLimite) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'YIE = :yie'.
	 */
	public List<SiceeTDatiEner2015> findWhereYieEquals(Double yie) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ASOL_ASUP = :asolAsup'.
	 */
	public List<SiceeTDatiEner2015> findWhereAsolAsupEquals(Double asolAsup) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_EDIF_E0 = :flgEdifE0'.
	 */
	public List<SiceeTDatiEner2015> findWhereFlgEdifE0Equals(String flgEdifE0) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_CLIMAT_INVERNALE = :flgClimatInvernale'.
	 */
	public List<SiceeTDatiEner2015> findWhereFlgClimatInvernaleEquals(String flgClimatInvernale) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_CLIMAT_ESTIVA = :flgClimatEstiva'.
	 */
	public List<SiceeTDatiEner2015> findWhereFlgClimatEstivaEquals(String flgClimatEstiva) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_VENTIL_MECCANICA = :flgVentilMeccanica'.
	 */
	public List<SiceeTDatiEner2015> findWhereFlgVentilMeccanicaEquals(String flgVentilMeccanica) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_PROD_H2O_SANITARIA = :flgProdH2oSanitaria'.
	 */
	public List<SiceeTDatiEner2015> findWhereFlgProdH2oSanitariaEquals(String flgProdH2oSanitaria) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_ILLUMINAZIONE = :flgIlluminazione'.
	 */
	public List<SiceeTDatiEner2015> findWhereFlgIlluminazioneEquals(String flgIlluminazione) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'FLG_TRASPORTO_PERS_COSE = :flgTrasportoPersCose'.
	 */
	public List<SiceeTDatiEner2015> findWhereFlgTrasportoPersCoseEquals(String flgTrasportoPersCose) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'ENERGIA_ESPORTATA = :energiaEsportata'.
	 */
	public List<SiceeTDatiEner2015> findWhereEnergiaEsportataEquals(Double energiaEsportata) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_RACC_TOTALE = :epglNrenRaccTotale'.
	 */
	public List<SiceeTDatiEner2015> findWhereEpglNrenRaccTotaleEquals(Double epglNrenRaccTotale) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_REN_GLOBALE = :epglRenGlobale'.
	 */
	public List<SiceeTDatiEner2015> findWhereEpglRenGlobaleEquals(Double epglRenGlobale) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_GLOBALE = :epglNrenGlobale'.
	 */
	public List<SiceeTDatiEner2015> findWhereEpglNrenGlobaleEquals(Double epglNrenGlobale) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EMISSIONI_CO2 = :emissioniCo2'.
	 */
	public List<SiceeTDatiEner2015> findWhereEmissioniCo2Equals(Double emissioniCo2) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_NUOVI = :epglNrenNuovi'.
	 */
	public List<SiceeTDatiEner2015> findWhereEpglNrenNuoviEquals(Double epglNrenNuovi) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_ESISTENTI = :epglNrenEsistenti'.
	 */
	public List<SiceeTDatiEner2015> findWhereEpglNrenEsistentiEquals(Double epglNrenEsistenti) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ENER_2015 table that match the criteria 'EPGL_NREN_RIF = :epglNrenRif'.
	 */
	public List<SiceeTDatiEner2015> findWhereEpglNrenRifEquals(Double epglNrenRif) throws SiceeTDatiEner2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_DATI_ENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiEner2015 findByPrimaryKey(SiceeTDatiEner2015Pk pk) throws SiceeTDatiEner2015DaoException;

}
