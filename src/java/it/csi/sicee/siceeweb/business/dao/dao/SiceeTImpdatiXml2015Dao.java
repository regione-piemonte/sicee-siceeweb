/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImpdatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImpdatiXml2015DaoException;

import java.util.List;

public interface SiceeTImpdatiXml2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTImpdatiXml2015Pk
	 */
	public SiceeTImpdatiXml2015Pk insert(SiceeTImpdatiXml2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	public void update(SiceeTImpdatiXml2015Pk pk, SiceeTImpdatiXml2015 dto) throws SiceeTImpdatiXml2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	public void delete(SiceeTImpdatiXml2015Pk pk) throws SiceeTImpdatiXml2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpdatiXml2015DaoException;

	/** 
	 * Returns the number of rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public int countByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpdatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTImpdatiXml2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTImpdatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria ''.
	 */
	public List<SiceeTImpdatiXml2015> findAll() throws SiceeTImpdatiXml2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_IMPDATI_XML_2015 table that matches the specified primary-key value.
	 */
	public SiceeTImpdatiXml2015 findByPrimaryKey(SiceeTImpdatiXml2015Pk pk) throws SiceeTImpdatiXml2015DaoException;

}
