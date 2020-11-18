/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTSostituzioneDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSostituzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSostituzionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTSostituzioneDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTSostituzioneDao.
 */
public interface SiceeTSostituzioneDao
{
	
	/**
	 * Gets the next value sostituzione progr.
	 *
	 * @return the next value sostituzione progr
	 */
	public int getNextValueSostituzioneProgr(); 
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTSostituzionePk
	 */
	public SiceeTSostituzionePk insert(SiceeTSostituzione dto);

	/**
	 * Updates a single row in the SICEE_T_SOSTITUZIONE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public void update(SiceeTSostituzionePk pk, SiceeTSostituzione dto) throws SiceeTSostituzioneDaoException;

	/**
	 * Deletes a single row in the SICEE_T_SOSTITUZIONE table.
	 *
	 * @param pk the pk
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public void delete(SiceeTSostituzionePk pk) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_SOSTITUZIONE = :idSostituzione AND PROGR_SOSTITUZIONE = :progrSostituzione'.
	 *
	 * @param idSostituzione the id sostituzione
	 * @param progrSostituzione the progr sostituzione
	 * @return the sicee t sostituzione
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public SiceeTSostituzione findByPrimaryKey(Integer idSostituzione, Integer progrSostituzione) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_OLD = :idCertificatoreOld AND ID_CERTIFICATORE_NEW = :idCertificatoreNew AND PROGR_CERTIFICATO_OLD = :progrCertificatoOld AND PROGR_CERTIFICATO_NEW = :progrCertificatoNew AND ANNO_OLD = :annoOld AND ANNO_NEW = :annoNew'.
	 *
	 * @param idCertificatoreOld the id certificatore old
	 * @param idCertificatoreNew the id certificatore new
	 * @param progrCertificatoOld the progr certificato old
	 * @param progrCertificatoNew the progr certificato new
	 * @param annoOld the anno old
	 * @param annoNew the anno new
	 * @return the sicee t sostituzione
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public SiceeTSostituzione findBySiceeTCertificatoOldNew(String idCertificatoreOld, String idCertificatoreNew, String progrCertificatoOld, String progrCertificatoNew, String annoOld, String annoNew) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findAll() throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_NEW = :idCertificatoreNew'.
	 *
	 * @param idCertificatoreNew the id certificatore new
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findBySiceeTCertificato(String idCertificatoreNew) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_OLD = :idCertificatoreOld AND PROGR_CERTIFICATO_OLD = :progrCertificatoOld AND PROGR_CERTIFICATO_NEW = :progrCertificatoNew AND ANNO_OLD = :annoOld AND ANNO_NEW = :annoNew'.
	 *
	 * @param idCertificatoreOld the id certificatore old
	 * @param progrCertificatoOld the progr certificato old
	 * @param progrCertificatoNew the progr certificato new
	 * @param annoOld the anno old
	 * @param annoNew the anno new
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findBySiceeTCertificato2(String idCertificatoreOld, String progrCertificatoOld, String progrCertificatoNew, String annoOld, String annoNew) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_SOSTITUZIONE = :idSostituzione'.
	 *
	 * @param idSostituzione the id sostituzione
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereIdSostituzioneEquals(Long idSostituzione) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'PROGR_SOSTITUZIONE = :progrSostituzione'.
	 *
	 * @param progrSostituzione the progr sostituzione
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereProgrSostituzioneEquals(Long progrSostituzione) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_OLD = :idCertificatoreOld'.
	 *
	 * @param idCertificatoreOld the id certificatore old
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereIdCertificatoreOldEquals(String idCertificatoreOld) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'PROGR_CERTIFICATO_OLD = :progrCertificatoOld'.
	 *
	 * @param progrCertificatoOld the progr certificato old
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereProgrCertificatoOldEquals(String progrCertificatoOld) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ANNO_OLD = :annoOld'.
	 *
	 * @param annoOld the anno old
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereAnnoOldEquals(String annoOld) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ID_CERTIFICATORE_NEW = :idCertificatoreNew'.
	 *
	 * @param idCertificatoreNew the id certificatore new
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereIdCertificatoreNewEquals(String idCertificatoreNew) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'PROGR_CERTIFICATO_NEW = :progrCertificatoNew'.
	 *
	 * @param progrCertificatoNew the progr certificato new
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereProgrCertificatoNewEquals(String progrCertificatoNew) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'ANNO_NEW = :annoNew'.
	 *
	 * @param annoNew the anno new
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereAnnoNewEquals(String annoNew) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'FLG_INVIO_MAIL = :flgInvioMail'.
	 *
	 * @param flgInvioMail the flg invio mail
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereFlgInvioMailEquals(String flgInvioMail) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns all rows from the SICEE_T_SOSTITUZIONE table that match the criteria 'EMAIL = :email'.
	 *
	 * @param email the email
	 * @return the list
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public List<SiceeTSostituzione> findWhereEmailEquals(String email) throws SiceeTSostituzioneDaoException;

	/**
	 * Returns the rows from the SICEE_T_SOSTITUZIONE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t sostituzione
	 * @throws SiceeTSostituzioneDaoException the sicee t sostituzione dao exception
	 */
	public SiceeTSostituzione findByPrimaryKey(SiceeTSostituzionePk pk) throws SiceeTSostituzioneDaoException;

}
