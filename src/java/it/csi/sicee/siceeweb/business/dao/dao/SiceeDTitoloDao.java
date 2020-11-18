/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTitoloDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTitolo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTitoloPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTitoloDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDTitoloDao.
 */
public interface SiceeDTitoloDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDTitoloPk
	 */
	public SiceeDTitoloPk insert(SiceeDTitolo dto);

	/**
	 * Updates a single row in the SICEE_D_TITOLO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public void update(SiceeDTitoloPk pk, SiceeDTitolo dto) throws SiceeDTitoloDaoException;

	/**
	 * Deletes a single row in the SICEE_D_TITOLO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public void delete(SiceeDTitoloPk pk) throws SiceeDTitoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'ID_TITOLO = :idTitolo'.
	 *
	 * @param idTitolo the id titolo
	 * @return the sicee d titolo
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public SiceeDTitolo findByPrimaryKey(String idTitolo) throws SiceeDTitoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public List<SiceeDTitolo> findAll() throws SiceeDTitoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'ID_TITOLO = :idTitolo'.
	 *
	 * @param idTitolo the id titolo
	 * @return the list
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public List<SiceeDTitolo> findWhereIdTitoloEquals(String idTitolo) throws SiceeDTitoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public List<SiceeDTitolo> findWhereDescrEquals(String descr) throws SiceeDTitoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'FLG_EDIFICI = :flgEdifici'.
	 *
	 * @param flgEdifici the flg edifici
	 * @return the list
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public List<SiceeDTitolo> findWhereFlgEdificiEquals(String flgEdifici) throws SiceeDTitoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'FLG_IMPIANTI = :flgImpianti'.
	 *
	 * @param flgImpianti the flg impianti
	 * @return the list
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public List<SiceeDTitolo> findWhereFlgImpiantiEquals(String flgImpianti) throws SiceeDTitoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_TITOLO table that match the criteria 'SIGLA = :sigla'.
	 *
	 * @param sigla the sigla
	 * @return the list
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public List<SiceeDTitolo> findWhereSiglaEquals(String sigla) throws SiceeDTitoloDaoException;

	/**
	 * Returns the rows from the SICEE_D_TITOLO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d titolo
	 * @throws SiceeDTitoloDaoException the sicee d titolo dao exception
	 */
	public SiceeDTitolo findByPrimaryKey(SiceeDTitoloPk pk) throws SiceeDTitoloDaoException;

}
