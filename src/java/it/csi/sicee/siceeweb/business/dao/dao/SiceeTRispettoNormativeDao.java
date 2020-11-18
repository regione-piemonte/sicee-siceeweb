/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRispettoNormative;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRispettoNormativePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRispettoNormativeDaoException;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTRispettoNormativeDao.
 */
public interface SiceeTRispettoNormativeDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTRispettoNormativePk
	 */
	public SiceeTRispettoNormativePk insert(SiceeTRispettoNormative dto);

	/**
	 * Updates a single row in the SICEE_T_RISPETTO_NORMATIVE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public void update(SiceeTRispettoNormativePk pk, SiceeTRispettoNormative dto) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Deletes a single row in the SICEE_T_RISPETTO_NORMATIVE table.
	 *
	 * @param pk the pk
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public void delete(SiceeTRispettoNormativePk pk) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t rispetto normative
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public SiceeTRispettoNormative findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findAll() throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'DT_TITOLO = :dtTitolo'.
	 *
	 * @param dtTitolo the dt titolo
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereDtTitoloEquals(Date dtTitolo) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereAnnoEquals(String anno) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'FK_NORMA = :fkNorma'.
	 *
	 * @param fkNorma the fk norma
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereFkNormaEquals(Integer fkNorma) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'FLG_NORMA = :flgNorma'.
	 *
	 * @param flgNorma the flg norma
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereFlgNormaEquals(String flgNorma) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'MOTIVO_NON_CONFORMITA = :motivoNonConformita'.
	 *
	 * @param motivoNonConformita the motivo non conformita
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereMotivoNonConformitaEquals(String motivoNonConformita) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns all rows from the SICEE_T_RISPETTO_NORMATIVE table that match the criteria 'NOTE = :note'.
	 *
	 * @param note the note
	 * @return the list
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public List<SiceeTRispettoNormative> findWhereNoteEquals(String note) throws SiceeTRispettoNormativeDaoException;

	/**
	 * Returns the rows from the SICEE_T_RISPETTO_NORMATIVE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t rispetto normative
	 * @throws SiceeTRispettoNormativeDaoException the sicee t rispetto normative dao exception
	 */
	public SiceeTRispettoNormative findByPrimaryKey(SiceeTRispettoNormativePk pk) throws SiceeTRispettoNormativeDaoException;

}
