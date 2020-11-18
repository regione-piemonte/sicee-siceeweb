/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiornoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDGradiGiornoDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDGradiGiornoDao.
 */
public interface SiceeDGradiGiornoDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDGradiGiornoPk
	 */
	public SiceeDGradiGiornoPk insert(SiceeDGradiGiorno dto);

	/**
	 * Updates a single row in the SICEE_D_GRADI_GIORNO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public void update(SiceeDGradiGiornoPk pk, SiceeDGradiGiorno dto) throws SiceeDGradiGiornoDaoException;

	/**
	 * Deletes a single row in the SICEE_D_GRADI_GIORNO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public void delete(SiceeDGradiGiornoPk pk) throws SiceeDGradiGiornoDaoException;

	/**
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'ID_COMUNE = :idComune'.
	 *
	 * @param idComune the id comune
	 * @return the sicee d gradi giorno
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public SiceeDGradiGiorno findByPrimaryKey(String idComune) throws SiceeDGradiGiornoDaoException;

	/**
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public List<SiceeDGradiGiorno> findAll() throws SiceeDGradiGiornoDaoException;

	/**
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'COMUNE = :comune'.
	 *
	 * @param comune the comune
	 * @return the list
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public List<SiceeDGradiGiorno> findWhereComuneEquals(String comune) throws SiceeDGradiGiornoDaoException;

	/**
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'ID_COMUNE = :idComune'.
	 *
	 * @param idComune the id comune
	 * @return the list
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public List<SiceeDGradiGiorno> findWhereIdComuneEquals(String idComune) throws SiceeDGradiGiornoDaoException;

	/**
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'ZONA_CLIMATICA = :zonaClimatica'.
	 *
	 * @param zonaClimatica the zona climatica
	 * @return the list
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public List<SiceeDGradiGiorno> findWhereZonaClimaticaEquals(String zonaClimatica) throws SiceeDGradiGiornoDaoException;

	/**
	 * Returns all rows from the SICEE_D_GRADI_GIORNO table that match the criteria 'GRADI_GIORNO = :gradiGiorno'.
	 *
	 * @param gradiGiorno the gradi giorno
	 * @return the list
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public List<SiceeDGradiGiorno> findWhereGradiGiornoEquals(Integer gradiGiorno) throws SiceeDGradiGiornoDaoException;

	/**
	 * Returns the rows from the SICEE_D_GRADI_GIORNO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d gradi giorno
	 * @throws SiceeDGradiGiornoDaoException the sicee d gradi giorno dao exception
	 */
	public SiceeDGradiGiorno findByPrimaryKey(SiceeDGradiGiornoPk pk) throws SiceeDGradiGiornoDaoException;

}
