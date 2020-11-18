/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTQtaConsumi2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTQtaConsumi2015DaoException;

import java.util.List;

public interface SiceeTQtaConsumi2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTQtaConsumi2015Pk
	 */
	public SiceeTQtaConsumi2015Pk insert(SiceeTQtaConsumi2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	public void update(SiceeTQtaConsumi2015Pk pk, SiceeTQtaConsumi2015 dto) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	public void delete(SiceeTQtaConsumi2015Pk pk) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Deletes a in the SICEE_T_QTA_CONSUMI_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_QTA_CONSUMI = :idQtaConsumi'.
	 */
	public SiceeTQtaConsumi2015 findByPrimaryKey(long idQtaConsumi) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria ''.
	 */
	public List<SiceeTQtaConsumi2015> findAll() throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'FK_UNITA_MISURA = :fkUnitaMisura'.
	 */
	public List<SiceeTQtaConsumi2015> findBySiceeDUnitaMisura2015(Integer fkUnitaMisura) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_QTA_CONSUMI = :idQtaConsumi'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereIdQtaConsumiEquals(long idQtaConsumi) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereAnnoEquals(String anno) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'FK_COMBUSTIBILE = :fkCombustibile'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereFkCombustibileEquals(Integer fkCombustibile) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'FK_UNITA_MISURA = :fkUnitaMisura'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereFkUnitaMisuraEquals(Integer fkUnitaMisura) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'QUANTITA = :quantita'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereQuantitaEquals(Double quantita) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ALTRO_DESCR_COMB = :altroDescrComb'.
	 */
	public List<SiceeTQtaConsumi2015> findWhereAltroDescrCombEquals(String altroDescrComb) throws SiceeTQtaConsumi2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_QTA_CONSUMI_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public List<SiceeTQtaConsumi2015> findWhereIdCertProgrAnno(String idCertificatore, String progrCertificato, String anno) throws SiceeTQtaConsumi2015DaoException;
	
	
	/** 
	 * Returns the rows from the SICEE_T_QTA_CONSUMI_2015 table that matches the specified primary-key value.
	 */
	public SiceeTQtaConsumi2015 findByPrimaryKey(SiceeTQtaConsumi2015Pk pk) throws SiceeTQtaConsumi2015DaoException;

}
