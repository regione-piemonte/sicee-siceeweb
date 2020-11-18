/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEsameDpr75Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsameDpr75;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsameDpr75Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTEsameDpr75DaoException;
import java.util.Date;
import java.util.List;

public interface SiceeTEsameDpr75Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTEsameDpr75Pk
	 */
	public SiceeTEsameDpr75Pk insert(SiceeTEsameDpr75 dto);

	/** 
	 * Updates a single row in the SICEE_T_ESAME_DPR75 table.
	 */
	public void update(SiceeTEsameDpr75Pk pk, SiceeTEsameDpr75 dto) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_ESAME_DPR75 table.
	 */
	public void delete(SiceeTEsameDpr75Pk pk) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	public SiceeTEsameDpr75 findByPrimaryKey(Integer idDatiEsami) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'IDENTIFIC_ATTESTATO = :identificAttestato'.
	 */
	public List<SiceeTEsameDpr75> findWhereIdentificAttestatoEquals(String identificAttestato) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria ''.
	 */
	public List<SiceeTEsameDpr75> findAll() throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	public SiceeTEsameDpr75 findBySiceeTCertificatore(String fkCertificatore) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ID_DATI_ESAMI = :idDatiEsami'.
	 */
	public List<SiceeTEsameDpr75> findWhereIdDatiEsamiEquals(Integer idDatiEsami) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	public List<SiceeTEsameDpr75> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'CORSO_FREQUENTATO = :corsoFrequentato'.
	 */
	public List<SiceeTEsameDpr75> findWhereCorsoFrequentatoEquals(String corsoFrequentato) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_DAL = :dtDal'.
	 */
	public List<SiceeTEsameDpr75> findWhereDtDalEquals(Date dtDal) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_AL = :dtAl'.
	 */
	public List<SiceeTEsameDpr75> findWhereDtAlEquals(Date dtAl) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'TOTALE_ORE = :totaleOre'.
	 */
	public List<SiceeTEsameDpr75> findWhereTotaleOreEquals(Integer totaleOre) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ESAME_PRESSO = :esamePresso'.
	 */
	public List<SiceeTEsameDpr75> findWhereEsamePressoEquals(String esamePresso) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_ESAME = :dtEsame'.
	 */
	public List<SiceeTEsameDpr75> findWhereDtEsameEquals(Date dtEsame) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'ATTESTATO_PRESSO = :attestatoPresso'.
	 */
	public List<SiceeTEsameDpr75> findWhereAttestatoPressoEquals(String attestatoPresso) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ESAME_DPR75 table that match the criteria 'DT_ATTESTATO = :dtAttestato'.
	 */
	public List<SiceeTEsameDpr75> findWhereDtAttestatoEquals(Date dtAttestato) throws SiceeTEsameDpr75DaoException;

	/** 
	 * Returns the rows from the SICEE_T_ESAME_DPR75 table that matches the specified primary-key value.
	 */
	public SiceeTEsameDpr75 findByPrimaryKey(SiceeTEsameDpr75Pk pk) throws SiceeTEsameDpr75DaoException;

}
