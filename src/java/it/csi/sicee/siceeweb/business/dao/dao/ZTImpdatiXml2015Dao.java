/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.ZTImpdatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.ZTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.ZTImpdatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTImpdatiXml2015DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.ZTImpdatiXml2015DaoException;

import java.util.List;

public interface ZTImpdatiXml2015Dao
{
	
	/** 
	 * Updates a single row in the SICEE_T_IMPDATI_XML_2015 table.
	 */
	public void update(ZTImpdatiXml2015Pk pk, ZTImpdatiXml2015 dto) throws ZTImpdatiXml2015DaoException;

	
	/** 
	 * Returns all rows from the SICEE_T_IMPDATI_XML_2015 table that match the criteria ''.
	 */
	public List<ZTImpdatiXml2015> findAll() throws ZTImpdatiXml2015DaoException;

	
}
