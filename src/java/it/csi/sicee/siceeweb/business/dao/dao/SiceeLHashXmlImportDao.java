/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeLHashXmlImportDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeLHashXmlImport;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeLHashXmlImportPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeLHashXmlImportDaoException;

import java.util.Date;
import java.util.List;

public interface SiceeLHashXmlImportDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeLHashXmlImportPk
	 */
	public SiceeLHashXmlImportPk insert(SiceeLHashXmlImport dto);

	/** 
	 * Returns all rows from the SICEE_L_HASH_XML_IMPORT table that match the criteria ''.
	 */
	public List<SiceeLHashXmlImport> findAll() throws SiceeLHashXmlImportDaoException;

	/** 
	 * Returns the rows from the SICEE_L_HASH_XML_IMPORT table that matches the specified primary-key value.
	 */
	public SiceeLHashXmlImport findByPrimaryKey(SiceeLHashXmlImportPk pk) throws SiceeLHashXmlImportDaoException;
}
