/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMappingXmlDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMappingXml;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMappingXmlDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDMappingXmlDao.
 */
public interface SiceeDMappingXmlDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 */
	public void insert(SiceeDMappingXml dto);

	/**
	 * Returns all rows from the SICEE_D_MAPPING_XML table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDMappingXmlDaoException the sicee d mapping xml dao exception
	 */
	public List<SiceeDMappingXml> findAll() throws SiceeDMappingXmlDaoException;

	/**
	 * Returns all rows from the SICEE_D_MAPPING_XML table that match the criteria 'CAMPO_XML = :campoXml'.
	 *
	 * @param campoXml the campo xml
	 * @return the sicee d mapping xml
	 * @throws SiceeDMappingXmlDaoException the sicee d mapping xml dao exception
	 */
	public SiceeDMappingXml findWhereCampoXmlEquals(String campoXml) throws SiceeDMappingXmlDaoException;

	/**
	 * Returns all rows from the SICEE_D_MAPPING_XML table that match the criteria 'CAMPO_WEB = :campoWeb'.
	 *
	 * @param campoWeb the campo web
	 * @return the sicee d mapping xml
	 * @throws SiceeDMappingXmlDaoException the sicee d mapping xml dao exception
	 */
	public SiceeDMappingXml findWhereCampoWebEquals(String campoWeb) throws SiceeDMappingXmlDaoException;

}
