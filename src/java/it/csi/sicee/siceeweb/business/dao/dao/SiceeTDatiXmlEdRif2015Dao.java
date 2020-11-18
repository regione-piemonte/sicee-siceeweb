/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXmlEdRif2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiXmlEdRif2015DaoException;

import java.util.List;

public interface SiceeTDatiXmlEdRif2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDatiXmlEdRif2015Pk
	 */
	public SiceeTDatiXmlEdRif2015Pk insert(SiceeTDatiXmlEdRif2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	public void update(SiceeTDatiXmlEdRif2015Pk pk, SiceeTDatiXmlEdRif2015 dto) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	public void delete(SiceeTDatiXmlEdRif2015Pk pk) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTDatiXmlEdRif2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria ''.
	 */
	public List<SiceeTDatiXmlEdRif2015> findAll() throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereAnnoEquals(String anno) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'QH = :qh'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereQhEquals(Double qh) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'QC = :qc'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereQcEquals(Double qc) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPHND = :ephnd'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEphndEquals(Double ephnd) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPCND = :epcnd'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpcndEquals(Double epcnd) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPH = :eph'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEphEquals(Double eph) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPC = :epc'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpcEquals(Double epc) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPW = :epw'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpwEquals(Double epw) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPV = :epv'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpvEquals(Double epv) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EP = :ep'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpEquals(Double ep) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPGLNR = :epglnr'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpglnrEquals(Double epglnr) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPGLR = :epglr'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpglrEquals(Double epglr) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'EPGLTOT = :epgltot'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEpgltotEquals(Double epgltot) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ETAH = :etah'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEtahEquals(Double etah) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ETAC = :etac'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEtacEquals(Double etac) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that match the criteria 'ETAW = :etaw'.
	 */
	public List<SiceeTDatiXmlEdRif2015> findWhereEtawEquals(Double etaw) throws SiceeTDatiXmlEdRif2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_DATI_XML_ED_RIF_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiXmlEdRif2015 findByPrimaryKey(SiceeTDatiXmlEdRif2015Pk pk) throws SiceeTDatiXmlEdRif2015DaoException;

}
