/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDIstruzioneDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDIstruzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDIstruzionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDIstruzioneDaoException;
import java.util.List;

public interface SiceeDIstruzioneDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDIstruzionePk
	 */
	public SiceeDIstruzionePk insert(SiceeDIstruzione dto);

	/** 
	 * Updates a single row in the SICEE_D_ISTRUZIONE table.
	 */
	public void update(SiceeDIstruzionePk pk, SiceeDIstruzione dto) throws SiceeDIstruzioneDaoException;

	/** 
	 * Deletes a single row in the SICEE_D_ISTRUZIONE table.
	 */
	public void delete(SiceeDIstruzionePk pk) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'ID_ISTRUZIONE = :idIstruzione'.
	 */
	public SiceeDIstruzione findByPrimaryKey(Integer idIstruzione) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria ''.
	 */
	public List<SiceeDIstruzione> findAll() throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'FK_TIPO_ISTRUZIONE = :fkTipoIstruzione'.
	 */
	public List<SiceeDIstruzione> findBySiceeDTipoIstruzione(Integer fkTipoIstruzione) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'ID_ISTRUZIONE = :idIstruzione'.
	 */
	public List<SiceeDIstruzione> findWhereIdIstruzioneEquals(Integer idIstruzione) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'FK_TIPO_ISTRUZIONE = :fkTipoIstruzione'.
	 */
	public List<SiceeDIstruzione> findWhereFkTipoIstruzioneEquals(Integer fkTipoIstruzione) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'CODICE = :codice'.
	 */
	public List<SiceeDIstruzione> findWhereCodiceEquals(String codice) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 */
	public List<SiceeDIstruzione> findWhereDenominazioneEquals(String denominazione) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'SIGLA_ORDINE = :siglaOrdine'.
	 */
	public List<SiceeDIstruzione> findWhereSiglaOrdineEquals(String siglaOrdine) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'SIGLA_NON_ORDINE = :siglaNonOrdine'.
	 */
	public List<SiceeDIstruzione> findWhereSiglaNonOrdineEquals(String siglaNonOrdine) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns all rows from the SICEE_D_ISTRUZIONE table that match the criteria 'FK_TIPO_ISTRUZIONE = :fkTipoIstruzione
AND SIGLA_ORDINE IS NOT NULL '.
	 */
	public List<SiceeDIstruzione> findWhereFkTipoIstruzioneEqualsAndSiglaOrdineIsNotNull(Integer fkTipoIstruzione) throws SiceeDIstruzioneDaoException;

	/** 
	 * Returns the rows from the SICEE_D_ISTRUZIONE table that matches the specified primary-key value.
	 */
	public SiceeDIstruzione findByPrimaryKey(SiceeDIstruzionePk pk) throws SiceeDIstruzioneDaoException;

}
