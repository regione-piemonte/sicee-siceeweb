/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiGeneraliDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGeneraliPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiGeneraliDaoException;
import java.util.List;

public interface SiceeTDatiGeneraliDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDatiGeneraliPk
	 */
	public SiceeTDatiGeneraliPk insert(SiceeTDatiGenerali dto);

	/** 
	 * Updates a single row in the SICEE_T_DATI_GENERALI table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public void update(SiceeTDatiGeneraliPk pk, SiceeTDatiGenerali dto) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_GENERALI table.
	 *
	 * @param pk the pk
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public void delete(SiceeTDatiGeneraliPk pk) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t dati generali
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public SiceeTDatiGenerali findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_DEST_USO = :fkDestUso'.
	 */
	public List<SiceeTDatiGenerali> findBySiceeDDestUso(Integer fkDestUso) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_EDIFICIO = :fkEdificio'.
	 */
	public List<SiceeTDatiGenerali> findBySiceeDEdificio(Integer fkEdificio) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_EDIFICIO = :fkEdificio'.
	 */
	public List<SiceeTDatiGenerali> findWhereFkEdificioEquals(Integer fkEdificio) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_CARATT_EDIFICIO = :fkCarattEdificio'.
	 */
	public List<SiceeTDatiGenerali> findBySiceeDCarattEdificio(Integer fkCarattEdificio) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findAll() throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereAnnoEquals(String anno) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'DESC_TIPO_EDIFICIO = :descTipoEdificio'.
	 *
	 * @param descTipoEdificio the desc tipo edificio
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereDescTipoEdificioEquals(String descTipoEdificio) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_DEST_USO = :fkDestUso'.
	 *
	 * @param fkDestUso the fk dest uso
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereFkDestUsoEquals(Integer fkDestUso) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ANNO_COSTRUZIONE = :annoCostruzione'.
	 *
	 * @param annoCostruzione the anno costruzione
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereAnnoCostruzioneEquals(Integer annoCostruzione) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ANNO_ULT_RIST = :annoUltRist'.
	 *
	 * @param annoUltRist the anno ult rist
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereAnnoUltRistEquals(Integer annoUltRist) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'VOL_LORDO_RISCALDATO = :volLordoRiscaldato'.
	 *
	 * @param volLordoRiscaldato the vol lordo riscaldato
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereVolLordoRiscaldatoEquals(Double volLordoRiscaldato) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_DISPERDENTE_TOT = :supDisperdenteTot'.
	 *
	 * @param supDisperdenteTot the sup disperdente tot
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereSupDisperdenteTotEquals(Double supDisperdenteTot) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FATTORE_FORMA = :fattoreForma'.
	 *
	 * @param fattoreForma the fattore forma
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereFattoreFormaEquals(Double fattoreForma) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'TRASM_OPACHE = :trasmOpache'.
	 *
	 * @param trasmOpache the trasm opache
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereTrasmOpacheEquals(Double trasmOpache) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'TRASM_TRASP = :trasmTrasp'.
	 *
	 * @param trasmTrasp the trasm trasp
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereTrasmTraspEquals(Double trasmTrasp) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ZONA_CLIMATICA = :zonaClimatica'.
	 *
	 * @param zonaClimatica the zona climatica
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereZonaClimaticaEquals(String zonaClimatica) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'GRADI_GIORNO = :gradiGiorno'.
	 *
	 * @param gradiGiorno the gradi giorno
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereGradiGiornoEquals(Integer gradiGiorno) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SU = :su'.
	 *
	 * @param su the su
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereSuEquals(Double su) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'EMISSIONI_SERRA = :emissioniSerra'.
	 *
	 * @param emissioniSerra the emissioni serra
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereEmissioniSerraEquals(Double emissioniSerra) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'ETTARI_BOSCO = :ettariBosco'.
	 *
	 * @param ettariBosco the ettari bosco
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereEttariBoscoEquals(Double ettariBosco) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FLG_USO_PUBBLICO = :flgUsoPubblico'.
	 *
	 * @param flgUsoPubblico the flg uso pubblico
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereFlgUsoPubblicoEquals(String flgUsoPubblico) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_CARATT_EDIFICIO = :fkCarattEdificio'.
	 *
	 * @param fkCarattEdificio the fk caratt edificio
	 * @return the list
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public List<SiceeTDatiGenerali> findWhereFkCarattEdificioEquals(Integer fkCarattEdificio) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'NR_UM = :nrUm'.
	 */
	public List<SiceeTDatiGenerali> findWhereNrUmEquals(Integer nrUm) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_RISCALDATA = :supRiscaldata'.
	 */
	public List<SiceeTDatiGenerali> findWhereSupRiscaldataEquals(Double supRiscaldata) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_RAFFRESCATA = :supRaffrescata'.
	 */
	public List<SiceeTDatiGenerali> findWhereSupRaffrescataEquals(Double supRaffrescata) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'SUP_DISPERDENTE = :supDisperdente'.
	 */
	public List<SiceeTDatiGenerali> findWhereSupDisperdenteEquals(Double supDisperdente) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'VOL_LORDO_RAFFRESCATO = :volLordoRaffrescato'.
	 */
	public List<SiceeTDatiGenerali> findWhereVolLordoRaffrescatoEquals(Double volLordoRaffrescato) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_OGGETTO_APE = :fkOggettoApe'.
	 */
	public List<SiceeTDatiGenerali> findWhereFkOggettoApeEquals(long fkOggettoApe) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_GENERALI table that match the criteria 'FK_DEST_USO_2015 = :fkDestUso2015'.
	 */
	public List<SiceeTDatiGenerali> findWhereFkDestUso2015Equals(Integer fkDestUso2015) throws SiceeTDatiGeneraliDaoException;

	/** 
	 * Returns the rows from the SICEE_T_DATI_GENERALI table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t dati generali
	 * @throws SiceeTDatiGeneraliDaoException the sicee t dati generali dao exception
	 */
	public SiceeTDatiGenerali findByPrimaryKey(SiceeTDatiGeneraliPk pk) throws SiceeTDatiGeneraliDaoException;

}
