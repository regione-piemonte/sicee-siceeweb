/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCertifServener2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRCertifServener2015DaoException;
import java.util.List;

public interface SiceeRCertifServener2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeRCertifServener2015Pk
	 */
	public SiceeRCertifServener2015Pk insert(SiceeRCertifServener2015 dto);

	/** 
	 * Updates a single row in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	public void update(SiceeRCertifServener2015Pk pk, SiceeRCertifServener2015 dto) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	public void delete(SiceeRCertifServener2015Pk pk) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Deletes rows in the SICEE_R_CERTIF_SERVENER2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND ID_SERV_ENER = :idServEner'.
	 */
	public SiceeRCertifServener2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer idServEner) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria ''.
	 */
	public List<SiceeRCertifServener2015> findAll() throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeRCertifServener2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeRCertifServener2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeRCertifServener2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeRCertifServener2015> findWhereAnnoEquals(String anno) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'ID_SERV_ENER = :idServEner'.
	 */
	public List<SiceeRCertifServener2015> findWhereIdServEnerEquals(Integer idServEner) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'EFFICIENZA = :efficienza'.
	 */
	public List<SiceeRCertifServener2015> findWhereEfficienzaEquals(Double efficienza) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'EPREN = :epren'.
	 */
	public List<SiceeRCertifServener2015> findWhereEprenEquals(Double epren) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns all rows from the SICEE_R_CERTIF_SERVENER2015 table that match the criteria 'EPNREN = :epnren'.
	 */
	public List<SiceeRCertifServener2015> findWhereEpnrenEquals(Double epnren) throws SiceeRCertifServener2015DaoException;

	/** 
	 * Returns the rows from the SICEE_R_CERTIF_SERVENER2015 table that matches the specified primary-key value.
	 */
	public SiceeRCertifServener2015 findByPrimaryKey(SiceeRCertifServener2015Pk pk) throws SiceeRCertifServener2015DaoException;

}
