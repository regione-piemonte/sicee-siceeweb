/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiEsamiDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsami;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsamiPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiEsamiDaoException;
import java.util.Date;
import java.util.List;

public interface SiceeTDatiEsamiDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDatiEsamiPk
	 */
	public SiceeTDatiEsamiPk insert(SiceeTDatiEsami dto);

	/** 
	 * Updates a single row in the SICEE_T_DATI_ESAMI table.
	 */
	public void update(SiceeTDatiEsamiPk pk, SiceeTDatiEsami dto) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_ESAMI table.
	 */
	public void delete(SiceeTDatiEsamiPk pk) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	public SiceeTDatiEsami findByPrimaryKey(Integer idDatiEsami) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria ''.
	 */
	public List<SiceeTDatiEsami> findAll() throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	public SiceeTDatiEsami findBySiceeTCertificatore(String fkCertificatore) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	public List<SiceeTDatiEsami> findWhereIdDatiEsamiEquals(Integer idDatiEsami) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	public List<SiceeTDatiEsami> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'CORSO_FREQUENTATO = :corsoFrequentato'.
	 */
	public List<SiceeTDatiEsami> findWhereCorsoFrequentatoEquals(String corsoFrequentato) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO1_DA = :dtModulo1Da'.
	 */
	public List<SiceeTDatiEsami> findWhereDtModulo1DaEquals(Date dtModulo1Da) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO1_A = :dtModulo1A'.
	 */
	public List<SiceeTDatiEsami> findWhereDtModulo1AEquals(Date dtModulo1A) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO2_DA = :dtModulo2Da'.
	 */
	public List<SiceeTDatiEsami> findWhereDtModulo2DaEquals(Date dtModulo2Da) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_MODULO2_A = :dtModulo2A'.
	 */
	public List<SiceeTDatiEsami> findWhereDtModulo2AEquals(Date dtModulo2A) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'TOTALE_ORE = :totaleOre'.
	 */
	public List<SiceeTDatiEsami> findWhereTotaleOreEquals(Integer totaleOre) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ATT_PARTECIP_EMESSO = :attPartecipEmesso'.
	 */
	public List<SiceeTDatiEsami> findWhereAttPartecipEmessoEquals(String attPartecipEmesso) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_ATT_PARTECIP = :dtAttPartecip'.
	 */
	public List<SiceeTDatiEsami> findWhereDtAttPartecipEquals(Date dtAttPartecip) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'ATT_ESAME_PRESSO = :attEsamePresso'.
	 */
	public List<SiceeTDatiEsami> findWhereAttEsamePressoEquals(String attEsamePresso) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_ESAMI table that match the criteria 'DT_ATT_ESAME = :dtAttEsame'.
	 */
	public List<SiceeTDatiEsami> findWhereDtAttEsameEquals(Date dtAttEsame) throws SiceeTDatiEsamiDaoException;

	/** 
	 * Returns the rows from the SICEE_T_DATI_ESAMI table that matches the specified primary-key value.
	 */
	public SiceeTDatiEsami findByPrimaryKey(SiceeTDatiEsamiPk pk) throws SiceeTDatiEsamiDaoException;

}
