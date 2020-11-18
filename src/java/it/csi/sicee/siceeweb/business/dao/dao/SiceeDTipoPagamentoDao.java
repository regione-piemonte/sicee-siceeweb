/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoPagamento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoPagamentoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoPagamentoDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDTipoPagamentoDao.
 */
public interface SiceeDTipoPagamentoDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDTipoPagamentoPk
	 */
	public SiceeDTipoPagamentoPk insert(SiceeDTipoPagamento dto);

	/**
	 * Updates a single row in the SICEE_D_TIPO_PAGAMENTO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public void update(SiceeDTipoPagamentoPk pk, SiceeDTipoPagamento dto) throws SiceeDTipoPagamentoDaoException;

	/**
	 * Deletes a single row in the SICEE_D_TIPO_PAGAMENTO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public void delete(SiceeDTipoPagamentoPk pk) throws SiceeDTipoPagamentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'ID_TIPO_PAGAMENTO = :idTipoPagamento'.
	 *
	 * @param idTipoPagamento the id tipo pagamento
	 * @return the sicee d tipo pagamento
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public SiceeDTipoPagamento findByPrimaryKey(Integer idTipoPagamento) throws SiceeDTipoPagamentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public List<SiceeDTipoPagamento> findAll() throws SiceeDTipoPagamentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'ID_TIPO_PAGAMENTO = :idTipoPagamento'.
	 *
	 * @param idTipoPagamento the id tipo pagamento
	 * @return the list
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public List<SiceeDTipoPagamento> findWhereIdTipoPagamentoEquals(Integer idTipoPagamento) throws SiceeDTipoPagamentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public List<SiceeDTipoPagamento> findWhereDescrEquals(String descr) throws SiceeDTipoPagamentoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'FLG_PAGAM_ATTIVO = :flgPagamAttivo'.
	 *
	 * @param flgPagamAttivo the flg pagam attivo
	 * @return the list
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public List<SiceeDTipoPagamento> findWhereFlgPagamAttivoEquals(String flgPagamAttivo) throws SiceeDTipoPagamentoDaoException;

	/**
	 * Returns the rows from the SICEE_D_TIPO_PAGAMENTO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d tipo pagamento
	 * @throws SiceeDTipoPagamentoDaoException the sicee d tipo pagamento dao exception
	 */
	public SiceeDTipoPagamento findByPrimaryKey(SiceeDTipoPagamentoPk pk) throws SiceeDTipoPagamentoDaoException;

}
