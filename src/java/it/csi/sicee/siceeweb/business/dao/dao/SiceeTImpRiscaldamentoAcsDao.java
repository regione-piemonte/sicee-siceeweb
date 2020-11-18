/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpRiscaldamentoAcs;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpRiscaldamentoAcsPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImpRiscaldamentoAcsDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTImpRiscaldamentoAcsDao.
 */
public interface SiceeTImpRiscaldamentoAcsDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTImpRiscaldamentoAcsPk
	 */
	public SiceeTImpRiscaldamentoAcsPk insert(SiceeTImpRiscaldamentoAcs dto);

	/**
	 * Updates a single row in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public void update(SiceeTImpRiscaldamentoAcsPk pk, SiceeTImpRiscaldamentoAcs dto) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Deletes a single row in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 *
	 * @param pk the pk
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public void delete(SiceeTImpRiscaldamentoAcsPk pk) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t imp riscaldamento acs
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public SiceeTImpRiscaldamentoAcs findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findAll() throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereAnnoEquals(String anno) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FLG_BOLLINO = :flgBollino'.
	 *
	 * @param flgBollino the flg bollino
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereFlgBollinoEquals(String flgBollino) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_CLASSE_EFF_RISC = :fkClasseEffRisc'.
	 *
	 * @param fkClasseEffRisc the fk classe eff risc
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkClasseEffRiscEquals(Integer fkClasseEffRisc) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'CODICE_IMPIANTO = :codiceImpianto'.
	 *
	 * @param codiceImpianto the codice impianto
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereCodiceImpiantoEquals(String codiceImpianto) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_CLASSE_EFF_ACS = :fkClasseEffAcs'.
	 *
	 * @param fkClasseEffAcs the fk classe eff acs
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkClasseEffAcsEquals(Integer fkClasseEffAcs) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_COMBUSTIBILE_RISC = :fkCombustibileRisc'.
	 *
	 * @param fkCombustibileRisc the fk combustibile risc
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkCombustibileRiscEquals(Integer fkCombustibileRisc) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'NUMERO_BOLLINO = :numeroBollino'.
	 *
	 * @param numeroBollino the numero bollino
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereNumeroBollinoEquals(String numeroBollino) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'GEN_ANNO_RISC = :genAnnoRisc'.
	 *
	 * @param genAnnoRisc the gen anno risc
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereGenAnnoRiscEquals(Integer genAnnoRisc) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'FK_COMBUSTIBILE_ACS = :fkCombustibileAcs'.
	 *
	 * @param fkCombustibileAcs the fk combustibile acs
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereFkCombustibileAcsEquals(Integer fkCombustibileAcs) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'POT_RISCALDAMENTO = :potRiscaldamento'.
	 *
	 * @param potRiscaldamento the pot riscaldamento
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWherePotRiscaldamentoEquals(Double potRiscaldamento) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'GEN_ANNO_ACS = :genAnnoAcs'.
	 *
	 * @param genAnnoAcs the gen anno acs
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWhereGenAnnoAcsEquals(Integer genAnnoAcs) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns all rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that match the criteria 'POT_ACS = :potAcs'.
	 *
	 * @param potAcs the pot acs
	 * @return the list
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public List<SiceeTImpRiscaldamentoAcs> findWherePotAcsEquals(Double potAcs) throws SiceeTImpRiscaldamentoAcsDaoException;

	/**
	 * Returns the rows from the SICEE_T_IMP_RISCALDAMENTO_ACS table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t imp riscaldamento acs
	 * @throws SiceeTImpRiscaldamentoAcsDaoException the sicee t imp riscaldamento acs dao exception
	 */
	public SiceeTImpRiscaldamentoAcs findByPrimaryKey(SiceeTImpRiscaldamentoAcsPk pk) throws SiceeTImpRiscaldamentoAcsDaoException;

}
