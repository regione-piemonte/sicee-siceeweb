/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDatiXml2015DaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTDatiXml2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTDatiXml2015Pk
	 */
	public SiceeTDatiXml2015Pk insert(SiceeTDatiXml2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_DATI_XML_2015 table.
	 */
	public void update(SiceeTDatiXml2015Pk pk, SiceeTDatiXml2015 dto) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_2015 table.
	 */
	public void delete(SiceeTDatiXml2015Pk pk) throws SiceeTDatiXml2015DaoException;
	/** 
	 * Deletes a single row in the SICEE_T_DATI_XML_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTDatiXml2015 findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXml2015DaoException;

	public List<SiceeTDatiXml2015> findByDaCompletareTmp() throws SiceeTDatiXml2015DaoException;
	
	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria ''.
	 */
	public List<SiceeTDatiXml2015> findAll() throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTDatiXml2015> findBySiceeTImportDati2015(String idCertificatore, String progrCertificato, String anno) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTDatiXml2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTDatiXml2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTDatiXml2015> findWhereAnnoEquals(String anno) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'FK_PROPRIETA_EDI = :fkProprietaEdi'.
	 */
	public List<SiceeTDatiXml2015> findWhereFkProprietaEdiEquals(Integer fkProprietaEdi) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'FK_TIPO_VENTILAZIONE = :fkTipoVentilazione'.
	 */
	public List<SiceeTDatiXml2015> findWhereFkTipoVentilazioneEquals(Integer fkTipoVentilazione) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'DT_TITOLO_ABILITATIVO = :dtTitoloAbilitativo'.
	 */
	public List<SiceeTDatiXml2015> findWhereDtTitoloAbilitativoEquals(Date dtTitoloAbilitativo) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'FLG_SISTEMA_CONTABILIZZAZIONE = :flgSistemaContabilizzazione'.
	 */
	public List<SiceeTDatiXml2015> findWhereFlgSistemaContabilizzazioneEquals(String flgSistemaContabilizzazione) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'HT = :ht'.
	 */
	public List<SiceeTDatiXml2015> findWhereHtEquals(Double ht) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'SUP_DISP_TOT_OPACA = :supDispTotOpaca'.
	 */
	public List<SiceeTDatiXml2015> findWhereSupDispTotOpacaEquals(Double supDispTotOpaca) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'SUP_DISP_TOT_TRASP = :supDispTotTrasp'.
	 */
	public List<SiceeTDatiXml2015> findWhereSupDispTotTraspEquals(Double supDispTotTrasp) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'TRASMITTANZA_MED_SUP_OPACHE = :trasmittanzaMedSupOpache'.
	 */
	public List<SiceeTDatiXml2015> findWhereTrasmittanzaMedSupOpacheEquals(Double trasmittanzaMedSupOpache) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'TRASMITTANZA_MED_SUP_TRASP = :trasmittanzaMedSupTrasp'.
	 */
	public List<SiceeTDatiXml2015> findWhereTrasmittanzaMedSupTraspEquals(Double trasmittanzaMedSupTrasp) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'PORTATA_VENTILAZIONE_TOT = :portataVentilazioneTot'.
	 */
	public List<SiceeTDatiXml2015> findWherePortataVentilazioneTotEquals(Double portataVentilazioneTot) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_DATI_XML_2015 table that match the criteria 'EFFICIENZA_RECUPERO_MEDIO = :efficienzaRecuperoMedio'.
	 */
	public List<SiceeTDatiXml2015> findWhereEfficienzaRecuperoMedioEquals(Double efficienzaRecuperoMedio) throws SiceeTDatiXml2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_DATI_XML_2015 table that matches the specified primary-key value.
	 */
	public SiceeTDatiXml2015 findByPrimaryKey(SiceeTDatiXml2015Pk pk) throws SiceeTDatiXml2015DaoException;

}
