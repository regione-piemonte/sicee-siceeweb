/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCombDener2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRCombDener2015DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRaccomand2015DaoException;

import java.util.List;

public interface SiceeRCombDener2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeRCombDener2015Pk
	 */
	public SiceeRCombDener2015Pk insert(SiceeRCombDener2015 dto);

	/** 
	 * Updates a single row in the SICEE_R_COMB_DENER_2015 table.
	 */
	public void update(SiceeRCombDener2015Pk pk, SiceeRCombDener2015 dto) throws SiceeRCombDener2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_R_COMB_DENER_2015 table.
	 */
	public void delete(SiceeRCombDener2015Pk pk) throws SiceeRCombDener2015DaoException;

	/** 
	 * Deletes in the SICEE_R_COMB_DENER_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile AND ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeRCombDener2015 findByPrimaryKey(Integer idCombustibile, String idCertificatore, String progrCertificato, String anno) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria ''.
	 */
	public List<SiceeRCombDener2015> findAll() throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeRCombDener2015> findBySiceeTDatiEner2015(String idCertificatore, String progrCertificato, String anno) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_COMBUSTIBILE = :idCombustibile'.
	 */
	public List<SiceeRCombDener2015> findWhereIdCombustibileEquals(Integer idCombustibile) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeRCombDener2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeRCombDener2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeRCombDener2015> findWhereAnnoEquals(String anno) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_COMB_DENER_2015 table that match the criteria 'DESCR_ALTRO = :descrAltro'.
	 */
	public List<SiceeRCombDener2015> findWhereDescrAltroEquals(String descrAltro) throws SiceeRCombDener2015DaoException;

	/** 
	 * Returns the rows from the SICEE_R_COMB_DENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeRCombDener2015 findByPrimaryKey(SiceeRCombDener2015Pk pk) throws SiceeRCombDener2015DaoException;

}
