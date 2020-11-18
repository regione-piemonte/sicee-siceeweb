/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEnergiaSoprIngr;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEnergiaSoprIngrPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTEnergiaSoprIngrDaoException;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTEnergiaSoprIngrDao.
 */
public interface SiceeTEnergiaSoprIngrDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTEnergiaSoprIngrPk
	 */
	public SiceeTEnergiaSoprIngrPk insert(SiceeTEnergiaSoprIngr dto);

	/**
	 * Updates a single row in the SICEE_T_ENERGIA_SOPR_INGR table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public void update(SiceeTEnergiaSoprIngrPk pk, SiceeTEnergiaSoprIngr dto) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Deletes a single row in the SICEE_T_ENERGIA_SOPR_INGR table.
	 *
	 * @param pk the pk
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public void delete(SiceeTEnergiaSoprIngrPk pk) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t energia sopr ingr
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public SiceeTEnergiaSoprIngr findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findAll() throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereAnnoEquals(String anno) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'FK_DATI = :fkDati'.
	 *
	 * @param fkDati the fk dati
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereFkDatiEquals(Integer fkDati) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'TECNO_RINNO = :tecnoRinno'.
	 *
	 * @param tecnoRinno the tecno rinno
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereTecnoRinnoEquals(String tecnoRinno) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'ANNO_INSTALL = :annoInstall'.
	 *
	 * @param annoInstall the anno install
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereAnnoInstallEquals(Integer annoInstall) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'EN_TERMICA_PROD = :enTermicaProd'.
	 *
	 * @param enTermicaProd the en termica prod
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereEnTermicaProdEquals(Double enTermicaProd) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'EN_ELETT_PROD = :enElettProd'.
	 *
	 * @param enElettProd the en elett prod
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereEnElettProdEquals(Double enElettProd) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'AUTOCONS_TERMICO = :autoconsTermico'.
	 *
	 * @param autoconsTermico the autocons termico
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereAutoconsTermicoEquals(Double autoconsTermico) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'AUTOCONS_ELETT = :autoconsElett'.
	 *
	 * @param autoconsElett the autocons elett
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereAutoconsElettEquals(Double autoconsElett) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'DT_SOPRALLUOGO = :dtSopralluogo'.
	 *
	 * @param dtSopralluogo the dt sopralluogo
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereDtSopralluogoEquals(Date dtSopralluogo) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'NOTE_SOPRALL = :noteSoprall'.
	 *
	 * @param noteSoprall the note soprall
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWhereNoteSoprallEquals(String noteSoprall) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns all rows from the SICEE_T_ENERGIA_SOPR_INGR table that match the criteria 'PERC_FONTI_RINNOV = :percFontiRinnov'.
	 *
	 * @param percFontiRinnov the perc fonti rinnov
	 * @return the list
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public List<SiceeTEnergiaSoprIngr> findWherePercFontiRinnovEquals(Double percFontiRinnov) throws SiceeTEnergiaSoprIngrDaoException;

	/**
	 * Returns the rows from the SICEE_T_ENERGIA_SOPR_INGR table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t energia sopr ingr
	 * @throws SiceeTEnergiaSoprIngrDaoException the sicee t energia sopr ingr dao exception
	 */
	public SiceeTEnergiaSoprIngr findByPrimaryKey(SiceeTEnergiaSoprIngrPk pk) throws SiceeTEnergiaSoprIngrDaoException;

}
