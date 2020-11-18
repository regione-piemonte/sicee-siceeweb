/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXmlEdReale2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiXmlEdReale2015DaoException;

import java.util.List;

public interface SiceeTDatiXmlEdReale2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDatiXmlEdReale2015Pk
	 */
	public SiceeTDatiXmlEdReale2015Pk insert(SiceeTDatiXmlEdReale2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	public void update(SiceeTDatiXmlEdReale2015Pk pk, SiceeTDatiXmlEdReale2015 dto) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	public void delete(SiceeTDatiXmlEdReale2015Pk pk) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTDatiXmlEdReale2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria ''.
	 */
	public List<SiceeTDatiXmlEdReale2015> findAll() throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereAnnoEquals(String anno) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_EXTRA_FLUS = :fabbRiscInvolucroExtraFlus'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroExtraFlusEquals(Double fabbRiscInvolucroExtraFlus) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_TRASMISSIO = :fabbRiscInvolucroTrasmissio'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroTrasmissioEquals(Double fabbRiscInvolucroTrasmissio) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_VENTILAZIO = :fabbRiscInvolucroVentilazio'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroVentilazioEquals(Double fabbRiscInvolucroVentilazio) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_APPORTI_SO = :fabbRiscInvolucroApportiSo'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroApportiSoEquals(Double fabbRiscInvolucroApportiSo) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_APPORTI_IN = :fabbRiscInvolucroApportiIn'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroApportiInEquals(Double fabbRiscInvolucroApportiIn) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_APPORTI_LA = :fabbRiscInvolucroApportiLa'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroApportiLaEquals(Double fabbRiscInvolucroApportiLa) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_QHND = :fabbRiscInvolucroQhnd'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroQhndEquals(Double fabbRiscInvolucroQhnd) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_QLR = :fabbRiscInvolucroQlr'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroQlrEquals(Double fabbRiscInvolucroQlr) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_INVOLUCRO_QHIMP = :fabbRiscInvolucroQhimp'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscInvolucroQhimpEquals(Double fabbRiscInvolucroQhimp) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAR = :fabbRiscImpiantoEtar'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtarEquals(Double fabbRiscImpiantoEtar) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAD = :fabbRiscImpiantoEtad'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtadEquals(Double fabbRiscImpiantoEtad) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAE = :fabbRiscImpiantoEtae'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtaeEquals(Double fabbRiscImpiantoEtae) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that match the criteria 'FABB_RISC_IMPIANTO_ETAG = :fabbRiscImpiantoEtag'.
	 */
	public List<SiceeTDatiXmlEdReale2015> findWhereFabbRiscImpiantoEtagEquals(Double fabbRiscImpiantoEtag) throws SiceeTDatiXmlEdReale2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_DATI_XML_ED_REALE_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiXmlEdReale2015 findByPrimaryKey(SiceeTDatiXmlEdReale2015Pk pk) throws SiceeTDatiXmlEdReale2015DaoException;

}
