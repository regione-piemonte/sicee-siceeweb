/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertXml2015DaoException;
import java.util.List;

public interface SiceeTCertXml2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTCertXml2015Pk
	 */
	public SiceeTCertXml2015Pk insert(SiceeTCertXml2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_CERT_XML_2015 table.
	 */
	public void update(SiceeTCertXml2015Pk pk, SiceeTCertXml2015 dto) throws SiceeTCertXml2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_CERT_XML_2015 table.
	 */
	public void delete(SiceeTCertXml2015Pk pk) throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTCertXml2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria ''.
	 */
	public List<SiceeTCertXml2015> findAll() throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTCertXml2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTCertXml2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTCertXml2015> findWhereAnnoEquals(String anno) throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'XML_ALLEGATO = :xmlAllegato'.
	 */
	public List<SiceeTCertXml2015> findWhereXmlAllegatoEquals(String xmlAllegato) throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERT_XML_2015 table that match the criteria 'FLG_CONTROLLO_BOZZA = :flgControlloBozza'.
	 */
	public List<SiceeTCertXml2015> findWhereFlgControlloBozzaEquals(String flgControlloBozza) throws SiceeTCertXml2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_CERT_XML_2015 table that matches the specified primary-key value.
	 */
	public SiceeTCertXml2015 findByPrimaryKey(SiceeTCertXml2015Pk pk) throws SiceeTCertXml2015DaoException;

}
