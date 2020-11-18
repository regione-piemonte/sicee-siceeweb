/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFabbisogno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFabbisognoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTFabbisognoDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTFabbisognoDao.
 */
public interface SiceeTFabbisognoDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTFabbisognoPk
	 */
	public SiceeTFabbisognoPk insert(SiceeTFabbisogno dto);

	/**
	 * Updates a single row in the SICEE_T_FABBISOGNO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public void update(SiceeTFabbisognoPk pk, SiceeTFabbisogno dto) throws SiceeTFabbisognoDaoException;

	/**
	 * Deletes a single row in the SICEE_T_FABBISOGNO table.
	 *
	 * @param pk the pk
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public void delete(SiceeTFabbisognoPk pk) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t fabbisogno
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public SiceeTFabbisogno findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findAll() throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereAnnoEquals(String anno) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'DOM_RISC_QH = :domRiscQh'.
	 *
	 * @param domRiscQh the dom risc qh
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereDomRiscQhEquals(Double domRiscQh) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'LIMITE_REG_QH_LIM = :limiteRegQhLim'.
	 *
	 * @param limiteRegQhLim the limite reg qh lim
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereLimiteRegQhLimEquals(Double limiteRegQhLim) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'FABB_CONDIZ = :fabbCondiz'.
	 *
	 * @param fabbCondiz the fabb condiz
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereFabbCondizEquals(Double fabbCondiz) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'DOM_ACS_QHW = :domAcsQhw'.
	 *
	 * @param domAcsQhw the dom acs qhw
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereDomAcsQhwEquals(Double domAcsQhw) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'EN_ACS_RINNO = :enAcsRinno'.
	 *
	 * @param enAcsRinno the en acs rinno
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereEnAcsRinnoEquals(Double enAcsRinno) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'REND_ACS_ETAGACS = :rendAcsEtagacs'.
	 *
	 * @param rendAcsEtagacs the rend acs etagacs
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereRendAcsEtagacsEquals(Double rendAcsEtagacs) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'FABB_ACS = :fabbAcs'.
	 *
	 * @param fabbAcs the fabb acs
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereFabbAcsEquals(Double fabbAcs) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns all rows from the SICEE_T_FABBISOGNO table that match the criteria 'FABB_ILLUM = :fabbIllum'.
	 *
	 * @param fabbIllum the fabb illum
	 * @return the list
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public List<SiceeTFabbisogno> findWhereFabbIllumEquals(Double fabbIllum) throws SiceeTFabbisognoDaoException;

	/**
	 * Returns the rows from the SICEE_T_FABBISOGNO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t fabbisogno
	 * @throws SiceeTFabbisognoDaoException the sicee t fabbisogno dao exception
	 */
	public SiceeTFabbisogno findByPrimaryKey(SiceeTFabbisognoPk pk) throws SiceeTFabbisognoDaoException;

}
