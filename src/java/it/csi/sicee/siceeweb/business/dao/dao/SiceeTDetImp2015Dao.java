/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDetImp2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDetImp2015DaoException;

import java.util.List;

public interface SiceeTDetImp2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDetImp2015Pk
	 */
	public SiceeTDetImp2015Pk insert(SiceeTDetImp2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_DET_IMP_2015 table.
	 */
	public void update(SiceeTDetImp2015Pk pk, SiceeTDetImp2015 dto) throws SiceeTDetImp2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DET_IMP_2015 table.
	 */
	public void delete(SiceeTDetImp2015Pk pk) throws SiceeTDetImp2015DaoException;

	/** 
	 * Deletes in the SICEE_T_DET_IMP_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_DETTAGLIO_IMP = :idDettaglioImp'.
	 */
	public SiceeTDetImp2015 findByPrimaryKey(long idDettaglioImp) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria ''.
	 */
	public List<SiceeTDetImp2015> findAll() throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'FK_SERV_ENER = :fkServEner'.
	 */
	public List<SiceeTDetImp2015> findBySiceeDServEner2015(Integer fkServEner) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_DETTAGLIO_IMP = :idDettaglioImp'.
	 */
	public List<SiceeTDetImp2015> findWhereIdDettaglioImpEquals(long idDettaglioImp) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'PROGRESSIVO_DETT = :progressivoDett'.
	 */
	public List<SiceeTDetImp2015> findWhereProgressivoDettEquals(Integer progressivoDett) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTDetImp2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTDetImp2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'FK_COMBUSTIBILE = :fkCombustibile'.
	 */
	public List<SiceeTDetImp2015> findWhereFkCombustibileEquals(Integer fkCombustibile) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTDetImp2015> findWhereAnnoEquals(String anno) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'FK_SERV_ENER = :fkServEner'.
	 */
	public List<SiceeTDetImp2015> findWhereFkServEnerEquals(Integer fkServEner) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'TIPO_IMPIANTO = :tipoImpianto'.
	 */
	public List<SiceeTDetImp2015> findWhereTipoImpiantoEquals(String tipoImpianto) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ANNO_INSTALL = :annoInstall'.
	 */
	public List<SiceeTDetImp2015> findWhereAnnoInstallEquals(Integer annoInstall) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'POTENZA_NOMIN_KW = :potenzaNominKw'.
	 */
	public List<SiceeTDetImp2015> findWherePotenzaNominKwEquals(Double potenzaNominKw) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'EFFICIENZA = :efficienza'.
	 */
	public List<SiceeTDetImp2015> findWhereEfficienzaEquals(Double efficienza) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'CODICE_IMPIANTO_CIT = :codiceImpiantoCit'.
	 */
	public List<SiceeTDetImp2015> findWhereCodiceImpiantoCitEquals(long codiceImpiantoCit) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'EPREN = :epren'.
	 */
	public List<SiceeTDetImp2015> findWhereEprenEquals(Double epren) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'EPNREN = :epnren'.
	 */
	public List<SiceeTDetImp2015> findWhereEpnrenEquals(Double epnren) throws SiceeTDetImp2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DET_IMP_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTDetImp2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTDetImp2015DaoException;
	
	/** 
	 * Returns the rows from the SICEE_T_DET_IMP_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDetImp2015 findByPrimaryKey(SiceeTDetImp2015Pk pk) throws SiceeTDetImp2015DaoException;

	
}
