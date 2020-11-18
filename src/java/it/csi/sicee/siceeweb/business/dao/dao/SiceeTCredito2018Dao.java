/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCredito2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCredito2018DaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTCredito2018Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTCredito2018Pk
	 */
	public SiceeTCredito2018Pk insert(SiceeTCredito2018 dto);

	/** 
	 * Updates a single row in the SICEE_T_CREDITO_2018 table.
	 */
	public void update(SiceeTCredito2018Pk pk, SiceeTCredito2018 dto) throws SiceeTCredito2018DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_CREDITO_2018 table.
	 */
	public void delete(SiceeTCredito2018Pk pk) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'ID_CREDITO = :idCredito'.
	 */
	public SiceeTCredito2018 findByPrimaryKey(long idCredito) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_CERTIFICATORE_CERTIFICATO = :fkCertificatoreCertificato AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTCredito2018> findBySiceeTCertificato(String fkCertificatoreCertificato, String progrCertificato, String anno) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria ''.
	 */
	public List<SiceeTCredito2018> findAll() throws SiceeTCredito2018DaoException;

	public SiceeTCredito2018 findWhereFkCertificatoreEqualsCreditoDisp(String fkCertificatore) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TIPO_OP_2018 = :fkTipoOp2018'.
	 */
	public List<SiceeTCredito2018> findBySiceeDTipoOp2018(Integer fkTipoOp2018) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TRANSAZIONE_2018 = :fkTransazione2018'.
	 */
	public List<SiceeTCredito2018> findBySiceeTTransazione2018(long fkTransazione2018) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'ID_CREDITO = :idCredito'.
	 */
	public List<SiceeTCredito2018> findWhereIdCreditoEquals(long idCredito) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 */
	public List<SiceeTCredito2018> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TRANSAZIONE_2018 = :fkTransazione2018'.
	 */
	public List<SiceeTCredito2018> findWhereFkTransazione2018Equals(long fkTransazione2018) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_TIPO_OP_2018 = :fkTipoOp2018'.
	 */
	public List<SiceeTCredito2018> findWhereFkTipoOp2018Equals(Integer fkTipoOp2018) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'VALORE_CREDITO_INIZIALE = :valoreCreditoIniziale'.
	 */
	public List<SiceeTCredito2018> findWhereValoreCreditoInizialeEquals(long valoreCreditoIniziale) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'VALORE_CREDITO_FINALE = :valoreCreditoFinale'.
	 */
	public List<SiceeTCredito2018> findWhereValoreCreditoFinaleEquals(long valoreCreditoFinale) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'DATA_OPERAZIONE = :dataOperazione'.
	 */
	public List<SiceeTCredito2018> findWhereDataOperazioneEquals(Date dataOperazione) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'VALORE_OPERAZIONE = :valoreOperazione'.
	 */
	public List<SiceeTCredito2018> findWhereValoreOperazioneEquals(long valoreOperazione) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'NOTE = :note'.
	 */
	public List<SiceeTCredito2018> findWhereNoteEquals(String note) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'FK_CERTIFICATORE_CERTIFICATO = :fkCertificatoreCertificato'.
	 */
	public List<SiceeTCredito2018> findWhereFkCertificatoreCertificatoEquals(String fkCertificatoreCertificato) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTCredito2018> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CREDITO_2018 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTCredito2018> findWhereAnnoEquals(String anno) throws SiceeTCredito2018DaoException;

	/** 
	 * Returns the rows from the SICEE_T_CREDITO_2018 table that matches the specified primary-key value.
	 */
	public SiceeTCredito2018 findByPrimaryKey(SiceeTCredito2018Pk pk) throws SiceeTCredito2018DaoException;

}
