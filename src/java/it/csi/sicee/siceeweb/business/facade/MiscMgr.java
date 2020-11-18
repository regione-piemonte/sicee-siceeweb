/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCarattEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEfficienzaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCombustibileDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDatiIngressoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDestUsoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDichiarazioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMappingXmlDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoSostDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDQualitaInvolucroDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDSistemaRaccDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoImpiantoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoPagamentoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeRDestClasseDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImportDatiLog2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeWPrezziDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCarattEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEfficienza;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDatiIngresso;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMappingXml;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoSost;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDQualitaInvolucro;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDSistemaRacc;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoPagamento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClasse;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDatiLog2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDCarattEdificioDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDClasseEfficienzaDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDClasseEnergeticaDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDCombustibileDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDatiIngressoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDestUsoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDichiarazioneDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMotivoRilascioDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMotivoSostDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDQualitaInvolucroDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDSistemaRaccDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoEdificioDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoImpiantoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoPagamentoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRDestClasseDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTParametriDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWPrezziDaoException;
import it.csi.sicee.siceeweb.dto.annullamento.DtAnnullamento;
import it.csi.sicee.siceeweb.dto.annullamento.MotivoAnnullamento;
import it.csi.sicee.siceeweb.dto.attestati.CarattEdificio;
import it.csi.sicee.siceeweb.dto.attestati.ClasseEfficienzaEnerg;
import it.csi.sicee.siceeweb.dto.attestati.ClasseEnerg;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.attestati.DestUso;
import it.csi.sicee.siceeweb.dto.attestati.Dichiarazione;
import it.csi.sicee.siceeweb.dto.attestati.MotivoRilascio;
import it.csi.sicee.siceeweb.dto.attestati.QualitaInvolucro;
import it.csi.sicee.siceeweb.dto.attestati.Sistema;
import it.csi.sicee.siceeweb.dto.attestati.TipoCombustibile;
import it.csi.sicee.siceeweb.dto.attestati.TipoDistrib;
import it.csi.sicee.siceeweb.dto.attestati.TipoEdificio;
import it.csi.sicee.siceeweb.dto.attestati.TipoImmobile;
import it.csi.sicee.siceeweb.dto.attestati.TipoImpianto;
import it.csi.sicee.siceeweb.dto.attestati.TipoRedazione;
import it.csi.sicee.siceeweb.dto.attestati.TipoRegolaz;
import it.csi.sicee.siceeweb.dto.attestati.TipoTermErogaz;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.daticert.DtAIEnergetiche;
import it.csi.sicee.siceeweb.dto.daticert.DtAIGenerali;
import it.csi.sicee.siceeweb.dto.daticert.DtAISopralluoghi;
import it.csi.sicee.siceeweb.dto.daticert.DtAltreInfo;
import it.csi.sicee.siceeweb.dto.daticert.DtAnagImmobile;
import it.csi.sicee.siceeweb.dto.daticert.DtCatastali;
import it.csi.sicee.siceeweb.dto.daticert.DtClasseEnerg;
import it.csi.sicee.siceeweb.dto.daticert.DtCoCertificatore;
import it.csi.sicee.siceeweb.dto.daticert.DtConsumiReali;
import it.csi.sicee.siceeweb.dto.daticert.DtDichiarazFinale;
import it.csi.sicee.siceeweb.dto.daticert.DtEnergiaFontiRinnov;
import it.csi.sicee.siceeweb.dto.daticert.DtGasSerra;
import it.csi.sicee.siceeweb.dto.daticert.DtImpAcqua;
import it.csi.sicee.siceeweb.dto.daticert.DtImpRiscald;
import it.csi.sicee.siceeweb.dto.daticert.DtImpianti;
import it.csi.sicee.siceeweb.dto.daticert.DtIndiciFabbisogno;
import it.csi.sicee.siceeweb.dto.daticert.DtLocReale;
import it.csi.sicee.siceeweb.dto.daticert.DtLocTeorica;
import it.csi.sicee.siceeweb.dto.daticert.DtResponsabili;
import it.csi.sicee.siceeweb.dto.daticert.DtRispettoNorme;
import it.csi.sicee.siceeweb.dto.daticert.DtTecniciGen;
import it.csi.sicee.siceeweb.dto.type.UDTDateValid;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.DesEncrypter;
import it.csi.sicee.siceeweb.util.GenericUtil;
import it.csi.sicee.siceeweb.util.MailSender;
import it.csi.sicee.siceeweb.util.SiceeXmlErrorHandler;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.raster.JimiRasterImage;

// TODO: Auto-generated Javadoc
/**
 * The Class MiscMgr.
 */
public class MiscMgr extends BaseMgr {

	/** The sicee d tipo pagamento dao. */
	SiceeDTipoPagamentoDao siceeDTipoPagamentoDao = null;

	/** The sicee d classe energetica dao. */
	SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao = null;

	/** The sicee d dest uso dao. */
	SiceeDDestUsoDao siceeDDestUsoDao = null;

	/** The sicee d caratt edificio dao. */
	SiceeDCarattEdificioDao siceeDCarattEdificioDao = null;

	/** The sicee d sistema racc dao. */
	SiceeDSistemaRaccDao siceeDSistemaRaccDao = null;

	/** The sicee d dichiarazione dao. */
	SiceeDDichiarazioneDao siceeDDichiarazioneDao = null;

	/** The sicee d motivo rilascio dao. */
	SiceeDMotivoRilascioDao siceeDMotivoRilascioDao = null;

	/** The sicee d tipo impianto dao. */
	SiceeDTipoImpiantoDao siceeDTipoImpiantoDao = null;

	/** The sicee d tipo edificio dao. */
	SiceeDTipoEdificioDao siceeDTipoEdificioDao = null;

	/** The sicee d dati ingresso dao. */
	SiceeDDatiIngressoDao siceeDDatiIngressoDao = null;

	/** The sicee d combustibile dao. */
	SiceeDCombustibileDao siceeDCombustibileDao = null;

	/** The sicee d qualita involucro dao. */
	SiceeDQualitaInvolucroDao siceeDQualitaInvolucroDao = null;

	/** The sicee d classe efficienza dao. */
	SiceeDClasseEfficienzaDao siceeDClasseEfficienzaDao = null;

	/** The sicee w prezzi dao. */
	SiceeWPrezziDao siceeWPrezziDao = null;

	/** The sicee r dest classe dao. */
	SiceeRDestClasseDao siceeRDestClasseDao = null;

	/** The sicee t parametri dao. */
	SiceeTParametriDao siceeTParametriDao = null;

	/** The sicee d mapping xml dao. */
	SiceeDMappingXmlDao siceeDMappingXmlDao = null;

	/** The sicee d motivo sost dao. */
	SiceeDMotivoSostDao siceeDMotivoSostDao;

	/** The sicee t import dati log 2015 dao. */
	SiceeTImportDatiLog2015Dao siceeTImportDatiLog2015Dao;
	
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}
	
	/**
	 * Gets the sicee d motivo sost dao.
	 * 
	 * @return the sicee d motivo sost dao
	 */
	public SiceeDMotivoSostDao getSiceeDMotivoSostDao() {
		return this.siceeDMotivoSostDao;
	}

	/**
	 * Sets the sicee d motivo sost dao.
	 * 
	 * @param siceeDMotivoSostDao
	 *            the new sicee d motivo sost dao
	 */
	public void setSiceeDMotivoSostDao(SiceeDMotivoSostDao siceeDMotivoSostDao) {
		this.siceeDMotivoSostDao = siceeDMotivoSostDao;
	}

	/**
	 * Gets the sicee d mapping xml dao.
	 * 
	 * @return the sicee d mapping xml dao
	 */
	public SiceeDMappingXmlDao getSiceeDMappingXmlDao() {
		return this.siceeDMappingXmlDao;
	}

	/**
	 * Sets the sicee d mapping xml dao.
	 * 
	 * @param siceeDMappingXmlDao
	 *            the new sicee d mapping xml dao
	 */
	public void setSiceeDMappingXmlDao(SiceeDMappingXmlDao siceeDMappingXmlDao) {
		this.siceeDMappingXmlDao = siceeDMappingXmlDao;
	}

	/**
	 * Gets the sicee t parametri dao.
	 * 
	 * @return the sicee t parametri dao
	 */
	public SiceeTParametriDao getSiceeTParametriDao() {
		return this.siceeTParametriDao;
	}

	/**
	 * Sets the sicee t parametri dao.
	 * 
	 * @param siceeTParametriDao
	 *            the new sicee t parametri dao
	 */
	public void setSiceeTParametriDao(SiceeTParametriDao siceeTParametriDao) {
		this.siceeTParametriDao = siceeTParametriDao;
	}

	/**
	 * Gets the sicee r dest classe dao.
	 * 
	 * @return the sicee r dest classe dao
	 */
	public SiceeRDestClasseDao getSiceeRDestClasseDao() {
		return this.siceeRDestClasseDao;
	}

	/**
	 * Sets the sicee r dest classe dao.
	 * 
	 * @param siceeRDestClasseDao
	 *            the new sicee r dest classe dao
	 */
	public void setSiceeRDestClasseDao(SiceeRDestClasseDao siceeRDestClasseDao) {
		this.siceeRDestClasseDao = siceeRDestClasseDao;
	}

	/**
	 * Gets the sicee w prezzi dao.
	 * 
	 * @return the sicee w prezzi dao
	 */
	public SiceeWPrezziDao getSiceeWPrezziDao() {
		return this.siceeWPrezziDao;
	}

	/**
	 * Sets the sicee w prezzi dao.
	 * 
	 * @param siceeWPrezziDao
	 *            the new sicee w prezzi dao
	 */
	public void setSiceeWPrezziDao(SiceeWPrezziDao siceeWPrezziDao) {
		this.siceeWPrezziDao = siceeWPrezziDao;
	}

	/**
	 * Gets the sicee d classe efficienza dao.
	 * 
	 * @return the sicee d classe efficienza dao
	 */
	public SiceeDClasseEfficienzaDao getSiceeDClasseEfficienzaDao() {
		return this.siceeDClasseEfficienzaDao;
	}

	/**
	 * Sets the sicee d classe efficienza dao.
	 * 
	 * @param siceeDClasseEfficienzaDao
	 *            the new sicee d classe efficienza dao
	 */
	public void setSiceeDClasseEfficienzaDao(
			SiceeDClasseEfficienzaDao siceeDClasseEfficienzaDao) {
		this.siceeDClasseEfficienzaDao = siceeDClasseEfficienzaDao;
	}

	/**
	 * Gets the sicee d qualita involucro dao.
	 * 
	 * @return the sicee d qualita involucro dao
	 */
	public SiceeDQualitaInvolucroDao getSiceeDQualitaInvolucroDao() {
		return this.siceeDQualitaInvolucroDao;
	}

	/**
	 * Sets the sicee d qualita involucro dao.
	 * 
	 * @param siceeDQualitaInvolucroDao
	 *            the new sicee d qualita involucro dao
	 */
	public void setSiceeDQualitaInvolucroDao(
			SiceeDQualitaInvolucroDao siceeDQualitaInvolucroDao) {
		this.siceeDQualitaInvolucroDao = siceeDQualitaInvolucroDao;
	}

	/**
	 * Gets the sicee d combustibile dao.
	 * 
	 * @return the sicee d combustibile dao
	 */
	public SiceeDCombustibileDao getSiceeDCombustibileDao() {
		return this.siceeDCombustibileDao;
	}

	/**
	 * Sets the sicee d combustibile dao.
	 * 
	 * @param siceeDCombustibileDao
	 *            the new sicee d combustibile dao
	 */
	public void setSiceeDCombustibileDao(
			SiceeDCombustibileDao siceeDCombustibileDao) {
		this.siceeDCombustibileDao = siceeDCombustibileDao;
	}

	/**
	 * Gets the sicee d classe energetica dao.
	 * 
	 * @return the sicee d classe energetica dao
	 */
	public SiceeDClasseEnergeticaDao getSiceeDClasseEnergeticaDao() {
		return this.siceeDClasseEnergeticaDao;
	}

	/**
	 * Sets the sicee d classe energetica dao.
	 * 
	 * @param siceeDClasseEnergeticaDao
	 *            the new sicee d classe energetica dao
	 */
	public void setSiceeDClasseEnergeticaDao(
			SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao) {
		this.siceeDClasseEnergeticaDao = siceeDClasseEnergeticaDao;
	}

	/**
	 * Gets the sicee d dest uso dao.
	 * 
	 * @return the sicee d dest uso dao
	 */
	public SiceeDDestUsoDao getSiceeDDestUsoDao() {
		return this.siceeDDestUsoDao;
	}

	/**
	 * Sets the sicee d dest uso dao.
	 * 
	 * @param siceeDDestUsoDao
	 *            the new sicee d dest uso dao
	 */
	public void setSiceeDDestUsoDao(SiceeDDestUsoDao siceeDDestUsoDao) {
		this.siceeDDestUsoDao = siceeDDestUsoDao;
	}

	/**
	 * Gets the sicee d caratt edificio dao.
	 * 
	 * @return the sicee d caratt edificio dao
	 */
	public SiceeDCarattEdificioDao getSiceeDCarattEdificioDao() {
		return this.siceeDCarattEdificioDao;
	}

	/**
	 * Sets the sicee d caratt edificio dao.
	 * 
	 * @param siceeDCarattEdificioDao
	 *            the new sicee d caratt edificio dao
	 */
	public void setSiceeDCarattEdificioDao(
			SiceeDCarattEdificioDao siceeDCarattEdificioDao) {
		this.siceeDCarattEdificioDao = siceeDCarattEdificioDao;
	}

	/**
	 * Gets the sicee d sistema racc dao.
	 * 
	 * @return the sicee d sistema racc dao
	 */
	public SiceeDSistemaRaccDao getSiceeDSistemaRaccDao() {
		return this.siceeDSistemaRaccDao;
	}

	/**
	 * Sets the sicee d sistema racc dao.
	 * 
	 * @param siceeDSistemaRaccDao
	 *            the new sicee d sistema racc dao
	 */
	public void setSiceeDSistemaRaccDao(
			SiceeDSistemaRaccDao siceeDSistemaRaccDao) {
		this.siceeDSistemaRaccDao = siceeDSistemaRaccDao;
	}

	/**
	 * Gets the sicee d dichiarazione dao.
	 * 
	 * @return the sicee d dichiarazione dao
	 */
	public SiceeDDichiarazioneDao getSiceeDDichiarazioneDao() {
		return this.siceeDDichiarazioneDao;
	}

	/**
	 * Sets the sicee d dichiarazione dao.
	 * 
	 * @param siceeDDichiarazioneDao
	 *            the new sicee d dichiarazione dao
	 */
	public void setSiceeDDichiarazioneDao(
			SiceeDDichiarazioneDao siceeDDichiarazioneDao) {
		this.siceeDDichiarazioneDao = siceeDDichiarazioneDao;
	}

	/**
	 * Gets the sicee d motivo rilascio dao.
	 * 
	 * @return the sicee d motivo rilascio dao
	 */
	public SiceeDMotivoRilascioDao getSiceeDMotivoRilascioDao() {
		return this.siceeDMotivoRilascioDao;
	}

	/**
	 * Sets the sicee d motivo rilascio dao.
	 * 
	 * @param siceeDMotivoRilascioDao
	 *            the new sicee d motivo rilascio dao
	 */
	public void setSiceeDMotivoRilascioDao(
			SiceeDMotivoRilascioDao siceeDMotivoRilascioDao) {
		this.siceeDMotivoRilascioDao = siceeDMotivoRilascioDao;
	}

	/**
	 * Gets the sicee d tipo impianto dao.
	 * 
	 * @return the sicee d tipo impianto dao
	 */
	public SiceeDTipoImpiantoDao getSiceeDTipoImpiantoDao() {
		return this.siceeDTipoImpiantoDao;
	}

	/**
	 * Sets the sicee d tipo impianto dao.
	 * 
	 * @param siceeDTipoImpiantoDao
	 *            the new sicee d tipo impianto dao
	 */
	public void setSiceeDTipoImpiantoDao(
			SiceeDTipoImpiantoDao siceeDTipoImpiantoDao) {
		this.siceeDTipoImpiantoDao = siceeDTipoImpiantoDao;
	}

	/**
	 * Gets the sicee d tipo edificio dao.
	 * 
	 * @return the sicee d tipo edificio dao
	 */
	public SiceeDTipoEdificioDao getSiceeDTipoEdificioDao() {
		return this.siceeDTipoEdificioDao;
	}

	/**
	 * Sets the sicee d tipo edificio dao.
	 * 
	 * @param siceeDTipoEdificioDao
	 *            the new sicee d tipo edificio dao
	 */
	public void setSiceeDTipoEdificioDao(
			SiceeDTipoEdificioDao siceeDTipoEdificioDao) {
		this.siceeDTipoEdificioDao = siceeDTipoEdificioDao;
	}

	/**
	 * Gets the sicee d dati ingresso dao.
	 * 
	 * @return the sicee d dati ingresso dao
	 */
	public SiceeDDatiIngressoDao getSiceeDDatiIngressoDao() {
		return this.siceeDDatiIngressoDao;
	}

	/**
	 * Sets the sicee d dati ingresso dao.
	 * 
	 * @param siceeDDatiIngressoDao
	 *            the new sicee d dati ingresso dao
	 */
	public void setSiceeDDatiIngressoDao(
			SiceeDDatiIngressoDao siceeDDatiIngressoDao) {
		this.siceeDDatiIngressoDao = siceeDDatiIngressoDao;
	}

	/**
	 * Gets the sicee d tipo pagamento dao.
	 * 
	 * @return the sicee d tipo pagamento dao
	 */
	public SiceeDTipoPagamentoDao getSiceeDTipoPagamentoDao() {
		return this.siceeDTipoPagamentoDao;
	}

	/**
	 * Sets the sicee d tipo pagamento dao.
	 * 
	 * @param siceeDTipoPagamentoDao
	 *            the new sicee d tipo pagamento dao
	 */
	public void setSiceeDTipoPagamentoDao(
			SiceeDTipoPagamentoDao siceeDTipoPagamentoDao) {
		this.siceeDTipoPagamentoDao = siceeDTipoPagamentoDao;
	}
	
	
	/**
	 * Gets the sicee t import dati log 2015 dao.
	 * 
	 * @return the sicee t import dati log 2015 dao
	 */
	public SiceeTImportDatiLog2015Dao getSiceeTImportDatiLog2015Dao() {
		return this.siceeTImportDatiLog2015Dao;
	}

	/**
	 * Sets the sicee t import dati log 2015 dao.
	 * 
	 * @param siceeTImportDatiLog2015Dao
	 *            the new sicee t import dati log 2015 dao
	 */
	public void setSiceeTImportDatiLog2015Dao(
			SiceeTImportDatiLog2015Dao siceeTImportDatiLog2015Dao) {
		this.siceeTImportDatiLog2015Dao = siceeTImportDatiLog2015Dao;
	}
	
	/**
	 * Gets the mod pagamento abilitati.
	 * 
	 * @return la concatenazione delle sigle dei tipi pagamento abilitati: BB se
	 *         solo bonifico, CC se solo carta di credito BBCC o CCBB (a seconda
	 *         dell'ordine nei record) se entrambi. Per testare se una modalità
	 *         è abilitata è necessario testare la presenza nella stringa del
	 *         codice.
	 * @throws BEException
	 *             the bE exception
	 */
	public String getModPagamentoAbilitati() throws BEException {
		try {
			java.util.List<SiceeDTipoPagamento> tipiPagam = this
					.getSiceeDTipoPagamentoDao().findAll();
			String ris = "";
			for (Iterator<SiceeDTipoPagamento> iterator = tipiPagam.iterator(); iterator
					.hasNext();) {
				SiceeDTipoPagamento siceeDTipoPagamento = iterator.next();
				if ("S".equals(siceeDTipoPagamento.getFlgPagamAttivo())) {
					ris += siceeDTipoPagamento.getDescr();
				}
			}
			return ris;
		} catch (SiceeDTipoPagamentoDaoException e) {
			throw new BEException(
					"Error nella lettura dei  tipi pagamento ammessi:" + e, e);
		}

	}

	/**
	 * Gets the classe energetica.
	 * 
	 * @return the classe energetica
	 * @throws BEException
	 *             the bE exception
	 */
	public List<ClasseEnerg> getClasseEnergetica() throws BEException {
		ArrayList<ClasseEnerg> ret = new ArrayList<ClasseEnerg>();
		try {
			List<SiceeDClasseEnergetica> list = this
					.getSiceeDClasseEnergeticaDao()
					.findWhereFlgNazionale19205Equals("S");
			Iterator<SiceeDClasseEnergetica> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDClasseEnergetica obj = iter.next();
				ClasseEnerg o = new ClasseEnerg();
				o.setCod(this.convertToString(obj.getIdClasse()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDClasseEnergeticaDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the destinazione duso.
	 * 
	 * @return the destinazione duso
	 * @throws BEException
	 *             the bE exception
	 */
	public List<DestUso> getDestinazioneDuso() throws BEException {
		ArrayList<DestUso> ret = new ArrayList<DestUso>();
		try {
			List<SiceeDDestUso> list = this.getSiceeDDestUsoDao().findAll();
			Iterator<SiceeDDestUso> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDDestUso obj = iter.next();
				DestUso o = new DestUso();
				o.setCod(this.convertToString(obj.getIdDestUso()));
				o.setDescr(obj.getSigla());
				ret.add(o);
			}
		} catch (SiceeDDestUsoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipo edificio.
	 * 
	 * @return the tipo edificio
	 * @throws BEException
	 *             the bE exception
	 */
	public List<TipoEdificio> getTipoEdificio() throws BEException {
		ArrayList<TipoEdificio> ret = new ArrayList<TipoEdificio>();
		try {
			List<SiceeDTipoEdificio> list = this.getSiceeDTipoEdificioDao()
					.findAll();
			Iterator<SiceeDTipoEdificio> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDTipoEdificio obj = iter.next();
				TipoEdificio o = new TipoEdificio();
				o.setCod(this.convertToString(obj.getIdTipoEdificio()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}
		} catch (SiceeDTipoEdificioDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the sistemi.
	 * 
	 * @return the sistemi
	 * @throws BEException
	 *             the bE exception
	 */
	public List<Sistema> getSistemi() throws BEException {
		ArrayList<Sistema> ret = new ArrayList<Sistema>();
		try {
			List<SiceeDSistemaRacc> list = this.getSiceeDSistemaRaccDao()
					.findAll();
			Iterator<SiceeDSistemaRacc> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDSistemaRacc obj = iter.next();
				Sistema o = new Sistema();
				o.setCod(obj.getSistema());
				o.setDescr(obj.getSistema());
				ret.add(o);
			}
		} catch (SiceeDSistemaRaccDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipologie immobile.
	 * 
	 * @return the tipologie immobile
	 */
	public List<TipoImmobile> getTipologieImmobile() {

		return new ArrayList<TipoImmobile>();
	}

	/**
	 * Gets the dichiarazioni.
	 * 
	 * @return the dichiarazioni
	 * @throws BEException
	 *             the bE exception
	 */
	public List<Dichiarazione> getDichiarazioni() throws BEException {
		ArrayList<Dichiarazione> ret = new ArrayList<Dichiarazione>();
		try {
			List<SiceeDDichiarazione> list = this.getSiceeDDichiarazioneDao()
					.findAll();
			Iterator<SiceeDDichiarazione> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDDichiarazione obj = iter.next();
				Dichiarazione o = new Dichiarazione();
				o.setCod(this.convertToString(obj.getIdDichiarazione()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}
		} catch (SiceeDDichiarazioneDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Gets the dichiarazioni.
	 * 
	 * @return the dichiarazioni
	 * @throws BEException
	 *             the bE exception
	 */
	public List<Dichiarazione> getDichiarazioniNew() throws BEException {
		ArrayList<Dichiarazione> ret = new ArrayList<Dichiarazione>();
		try {
			List<SiceeDDichiarazione> list = this.getSiceeDDichiarazioneDao()
					.findWhereIdDichiarazioneNew();
			Iterator<SiceeDDichiarazione> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDDichiarazione obj = iter.next();
				Dichiarazione o = new Dichiarazione();
				o.setCod(this.convertToString(obj.getIdDichiarazione()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}
		} catch (SiceeDDichiarazioneDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the motivi rilascio.
	 * 
	 * @return the motivi rilascio
	 * @throws BEException
	 *             the bE exception
	 */
	public List<MotivoRilascio> getMotiviRilascio() throws BEException {
		ArrayList<MotivoRilascio> ret = new ArrayList<MotivoRilascio>();
		try {
			// List<SiceeDMotivoRilascio> list =
			// getSiceeDMotivoRilascioDao().findAll();
			List<SiceeDMotivoRilascio> list = this.getSiceeDMotivoRilascioDao()
					.findWhereFlgComboEqualsS();
			Iterator<SiceeDMotivoRilascio> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDMotivoRilascio obj = iter.next();
				MotivoRilascio o = new MotivoRilascio();
				o.setCod(this.convertToString(obj.getIdMotivo()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDMotivoRilascioDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipi combustibile riscaldamento.
	 * 
	 * @return the tipi combustibile riscaldamento
	 * @throws BEException
	 *             the bE exception
	 */
	public List<TipoCombustibile> getTipiCombustibileRiscaldamento()
			throws BEException {
		ArrayList<TipoCombustibile> ret = new ArrayList<TipoCombustibile>();
		try {
			List<SiceeDCombustibile> list = this.getSiceeDCombustibileDao()
					.findWhereFlgComboRiscaldEquals(Constants.SI);
			Iterator<SiceeDCombustibile> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDCombustibile obj = iter.next();
				TipoCombustibile o = new TipoCombustibile();
				o.setCod(this.convertToString(obj.getIdCombustibile()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDCombustibileDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipi combustibile acqua calda.
	 * 
	 * @return the tipi combustibile acqua calda
	 * @throws BEException
	 *             the bE exception
	 */
	public List<TipoCombustibile> getTipiCombustibileAcquaCalda()
			throws BEException {
		ArrayList<TipoCombustibile> ret = new ArrayList<TipoCombustibile>();
		try {
			List<SiceeDCombustibile> list = this.getSiceeDCombustibileDao()
					.findAll();
			Iterator<SiceeDCombustibile> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDCombustibile obj = iter.next();
				TipoCombustibile o = new TipoCombustibile();
				o.setCod(this.convertToString(obj.getIdCombustibile()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDCombustibileDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipi distrib.
	 * 
	 * @return the tipi distrib
	 */
	public List<TipoDistrib> getTipiDistrib() {

		return new ArrayList<TipoDistrib>();
	}

	/**
	 * Gets the motivi annullamento.
	 * 
	 * @return the motivi annullamento
	 * @throws BEException
	 *             the bE exception
	 */
	public List<MotivoAnnullamento> getMotiviAnnullamento() throws BEException {
		ArrayList<MotivoAnnullamento> ret = new ArrayList<MotivoAnnullamento>();
		try {
			// List<SiceeDMotivoSost> list = getSiceeDMotivoSostDao().findAll();
			List<SiceeDMotivoSost> list = this.getSiceeDMotivoSostDao()
					.findWhereFlagComboEqualsS();
			Iterator<SiceeDMotivoSost> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDMotivoSost obj = iter.next();
				MotivoAnnullamento o = new MotivoAnnullamento();
				o.setCod(this.convertToString(obj.getIdMotivoSost()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}
		} catch (SiceeDMotivoSostDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the motivo annullamento by id.
	 * 
	 * @param idMotivo
	 *            the id motivo
	 * @return the motivo annullamento by id
	 * @throws BEException
	 *             the bE exception
	 */
	public MotivoAnnullamento getMotivoAnnullamentoById(Integer idMotivo)
			throws BEException {
		MotivoAnnullamento ret = null;
		try {
			SiceeDMotivoSost motivazione = this.getSiceeDMotivoSostDao()
					.findByPrimaryKey(idMotivo);

			if (motivazione != null) {
				ret = new MotivoAnnullamento();
				ret.setCod(this.convertToString(motivazione.getIdMotivoSost()));
				ret.setDescr(motivazione.getDescr());
			}
		} catch (SiceeDMotivoSostDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Check coerenza sostituzione.
	 * 
	 * @param idMotivoSost
	 *            the id motivo sost
	 * @param countOld
	 *            the count old
	 * @param countNew
	 *            the count new
	 * @return true, if successful
	 * @throws BEException
	 *             the bE exception
	 */
	public boolean checkCoerenzaSostituzione(int idMotivoSost, int countOld,
			int countNew) throws BEException {

		boolean isCoerenteOld = false;
		boolean isCoerenteNew = false;

		try {
			SiceeDMotivoSost motivoSost = this.getSiceeDMotivoSostDao()
					.findByPrimaryKey(idMotivoSost);

			if (motivoSost.getMin() == null) {
				if (countOld > 1) {
					isCoerenteOld = true;
				}
			} else if (motivoSost.getMin() == countOld) {
				isCoerenteOld = true;
			}

			if (motivoSost.getMax() == null) {
				if (countNew > 1) {
					isCoerenteNew = true;
				}
			} else if (motivoSost.getMax() == countNew) {
				isCoerenteNew = true;
			}

			return (isCoerenteOld && isCoerenteNew);
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Gets the tipi impianto.
	 * 
	 * @return the tipi impianto
	 * @throws BEException
	 *             the bE exception
	 */
	public List<TipoImpianto> getTipiImpianto() throws BEException {
		ArrayList<TipoImpianto> ret = new ArrayList<TipoImpianto>();
		try {
			List<SiceeDTipoImpianto> list = this.getSiceeDTipoImpiantoDao()
					.findAll();
			Iterator<SiceeDTipoImpianto> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDTipoImpianto obj = iter.next();
				TipoImpianto o = new TipoImpianto();
				o.setCod(this.convertToString(obj.getIdTipoImpianto()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDTipoImpiantoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipi edificio.
	 * 
	 * @param idTipoImpianto
	 *            the id tipo impianto
	 * @return the tipi edificio
	 * @throws BEException
	 *             the bE exception
	 */
	public List<TipoEdificio> getTipiEdificio(Integer idTipoImpianto)
			throws BEException {
		ArrayList<TipoEdificio> ret = new ArrayList<TipoEdificio>();
		try {
			List<SiceeDTipoEdificio> list = this.getSiceeDTipoEdificioDao()
					.findWhereFkTipoImpiantoEquals(idTipoImpianto);
			Iterator<SiceeDTipoEdificio> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDTipoEdificio obj = iter.next();
				TipoEdificio o = new TipoEdificio();
				o.setCod(this.convertToString(obj.getIdTipoEdificio()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDTipoEdificioDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the caratteristiche edificio.
	 * 
	 * @param idTipoEdificio
	 *            the id tipo edificio
	 * @return the caratteristiche edificio
	 * @throws BEException
	 *             the bE exception
	 */
	public List<CarattEdificio> getCaratteristicheEdificio(
			Integer idTipoEdificio) throws BEException {
		ArrayList<CarattEdificio> ret = new ArrayList<CarattEdificio>();
		try {
			List<SiceeDCarattEdificio> list = this.getSiceeDCarattEdificioDao()
					.findWhereFkTipoEdificioEquals(idTipoEdificio);
			Iterator<SiceeDCarattEdificio> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDCarattEdificio obj = iter.next();
				CarattEdificio o = new CarattEdificio();
				o.setCod(this.convertToString(obj.getIdCarattEdificio()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDCarattEdificioDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the caratteristiche edificio.
	 * 
	 * @return the caratteristiche edificio
	 * @throws BEException
	 *             the bE exception
	 */
	public List<CarattEdificio> getCaratteristicheEdificio() throws BEException {
		ArrayList<CarattEdificio> ret = new ArrayList<CarattEdificio>();
		try {
			List<SiceeDCarattEdificio> list = this.getSiceeDCarattEdificioDao()
					.findAll();
			Iterator<SiceeDCarattEdificio> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDCarattEdificio obj = iter.next();
				CarattEdificio o = new CarattEdificio();
				o.setCod(this.convertToString(obj.getIdCarattEdificio()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDCarattEdificioDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipi redazione.
	 * 
	 * @return the tipi redazione
	 * @throws BEException
	 *             the bE exception
	 */
	public List<TipoRedazione> getTipiRedazione() throws BEException {
		ArrayList<TipoRedazione> ret = new ArrayList<TipoRedazione>();
		try {
			List<SiceeDDatiIngresso> list = this.getSiceeDDatiIngressoDao()
					.findAll();
			Iterator<SiceeDDatiIngresso> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDDatiIngresso obj = iter.next();
				TipoRedazione o = new TipoRedazione();
				o.setCod(this.convertToString(obj.getIdDati()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDDatiIngressoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the tipi term erogazione.
	 * 
	 * @return the tipi term erogazione
	 */
	public List<TipoTermErogaz> getTipiTermErogazione() {

		return new ArrayList<TipoTermErogaz>();
	}

	/**
	 * Gets the tipi regolazione.
	 * 
	 * @return the tipi regolazione
	 */
	public List<TipoRegolaz> getTipiRegolazione() {

		return new ArrayList<TipoRegolaz>();
	}

	/**
	 * Gets the qualita involucro.
	 * 
	 * @return the qualita involucro
	 * @throws BEException
	 *             the bE exception
	 */
	public List<QualitaInvolucro> getQualitaInvolucro() throws BEException {
		ArrayList<QualitaInvolucro> ret = new ArrayList<QualitaInvolucro>();
		try {
			List<SiceeDQualitaInvolucro> list = this
					.getSiceeDQualitaInvolucroDao().findAll();
			Iterator<SiceeDQualitaInvolucro> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDQualitaInvolucro obj = iter.next();
				QualitaInvolucro o = new QualitaInvolucro();
				o.setCod(this.convertToString(obj.getIdQualita()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDQualitaInvolucroDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the classe efficienza energetica.
	 * 
	 * @return the classe efficienza energetica
	 * @throws BEException
	 *             the bE exception
	 */
	public List<ClasseEfficienzaEnerg> getClasseEfficienzaEnergetica()
			throws BEException {
		ArrayList<ClasseEfficienzaEnerg> ret = new ArrayList<ClasseEfficienzaEnerg>();
		try {
			List<SiceeDClasseEfficienza> list = this
					.getSiceeDClasseEfficienzaDao().findAll();
			Iterator<SiceeDClasseEfficienza> iter = list.iterator();
			while (iter.hasNext()) {
				SiceeDClasseEfficienza obj = iter.next();
				ClasseEfficienzaEnerg o = new ClasseEfficienzaEnerg();
				o.setCod(this.convertToString(obj.getIdClasseEff()));
				o.setDescr(obj.getDescr());
				ret.add(o);
			}

		} catch (SiceeDClasseEfficienzaDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the sigla destinazione duso.
	 * 
	 * @param id
	 *            the id
	 * @return the sigla destinazione duso
	 */
	public String getSiglaDestinazioneDuso(String id) {
		try {
			return this.getSiceeDDestUsoDao()
					.findByPrimaryKey(BaseMgr.convertToInteger(id)).getSigla();
		} catch (SiceeDDestUsoDaoException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Checks if is edificio.
	 * 
	 * @param id
	 *            the id
	 * @return true, if is edificio
	 */
	public boolean isEdificio(String id) {
		try {
			String flg = this.getSiceeDDestUsoDao()
					.findByPrimaryKey(BaseMgr.convertToInteger(id))
					.getFlgEdificio();

			return (flg != null && flg
					.equalsIgnoreCase(Constants.EDIFICIO_RESIDENZIALE));
		} catch (SiceeDDestUsoDaoException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * Gets the descrizione tipo impianto.
	 * 
	 * @param id
	 *            the id
	 * @return the descrizione tipo impianto
	 */
	public String getDescrizioneTipoImpianto(String id) {
		try {
			return this.getSiceeDTipoImpiantoDao()
					.findByPrimaryKey(BaseMgr.convertToInteger(id)).getDescr();
		} catch (SiceeDTipoImpiantoDaoException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the descrizione classe energetica.
	 * 
	 * @param id
	 *            the id
	 * @return the descrizione classe energetica
	 */
	public String getDescrizioneClasseEnergetica(String id) {
		try {
			return this.getSiceeDClasseEnergeticaDao()
					.findByPrimaryKey(BaseMgr.convertToInteger(id)).getDescr();
		} catch (SiceeDClasseEnergeticaDaoException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the descrizione qualita involucro.
	 * 
	 * @param id
	 *            the id
	 * @return the descrizione qualita involucro
	 */
	public String getDescrizioneQualitaInvolucro(String id) {
		try {
			return this.getSiceeDQualitaInvolucroDao()
					.findByPrimaryKey(BaseMgr.convertToInteger(id)).getDescr();
		} catch (SiceeDQualitaInvolucroDaoException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the descrizione comustibile fossile.
	 * 
	 * @param id
	 *            the id
	 * @return the descrizione comustibile fossile
	 */
	public String getDescrizioneComustibileFossile(String id) {
		try {
			return this.getSiceeDCombustibileDao()
					.findByPrimaryKey(BaseMgr.convertToInteger(id)).getDescr();
		} catch (SiceeDCombustibileDaoException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the prezzo ace.
	 * 
	 * @return the prezzo ace
	 * @throws BEException
	 *             the bE exception
	 */
	public Double getPrezzoAce() throws BEException {
		try {
			return this.getSiceeWPrezziDao().findWhereDescrizioneValidaEquals("ACE")
					.getValuta();
		} catch (SiceeWPrezziDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Gets the prezzo registrazione.
	 * 
	 * @return the prezzo registrazione
	 * @throws BEException
	 *             the bE exception
	 */
	public Double getPrezzoRegistrazione() throws BEException {
		try {
			return this.getSiceeWPrezziDao().findWhereDescrizioneValidaEquals("REGISTRAZIONE")
					.getValuta();
		} catch (SiceeWPrezziDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Gets the descrizione motivo rilascio.
	 * 
	 * @param id
	 *            the id
	 * @return the descrizione motivo rilascio
	 */
	public String getDescrizioneMotivoRilascio(String id) {
		try {
			return this.getSiceeDMotivoRilascioDao()
					.findByPrimaryKey(BaseMgr.convertToInteger(id)).getDescr();
		} catch (SiceeDMotivoRilascioDaoException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the classe energetica per valore.
	 * 
	 * @param indPrestEnergGlobLim
	 *            the ind prest energ glob lim
	 * @param destUso
	 *            the dest uso
	 * @return the classe energetica per valore
	 */
	public String getClasseEnergeticaPerValore(
			UDTPositiveDoubleFour indPrestEnergGlobLim, Integer destUso) {
		List<SiceeRDestClasse> list;
		String codClasseEnergetica = null;
		try {
			list = this.getSiceeRDestClasseDao().findWhereIdDestUsoEquals(
					destUso);

			Iterator<SiceeRDestClasse> iter = list.iterator();

			while (iter.hasNext()) {
				SiceeRDestClasse r = iter.next();
				if (indPrestEnergGlobLim.getValue() >= r.getMin()
						&& indPrestEnergGlobLim.getValue() < r.getMax()) {
					SiceeDClasseEnergetica c = this
							.getSiceeDClasseEnergeticaDao().findByPrimaryKey(
									r.getIdClasse());

					codClasseEnergetica = c.getDescr();
				}
			}
		} catch (SiceeRDestClasseDaoException e) {
			log.error(e);
		} catch (SiceeDClasseEnergeticaDaoException e) {
			log.error(e);
		}
		return codClasseEnergetica;
	}

	/**
	 * Gets the parametro.
	 * 
	 * @param codice
	 *            the codice
	 * @return the parametro
	 */
	public String getParametro(String codice) {
		String value = "";

		try {
			SiceeTParametri param = this.getSiceeTParametriDao()
					.findWhereCodiceEquals(codice);
			if (param != null) {
				value = param.getValore();
			} else {
				log.error(codice + " non configurato sul db", new Exception());
			}
		} catch (SiceeTParametriDaoException e) {
			log.error(e);
		}

		return value;
	}

	public String getParametroValiditaNomeFile() {
		String value = this.getParametro(Constants.VALIDITA_NOME_FILE);

		return value;
	}

	

	/**
	 * Gets the parametro foto.
	 * 
	 * @return the parametro foto
	 */
	public boolean getParametroFoto() {
		String value = this.getParametro(Constants.FOTO_ABILITATA);

		return BaseMgr.convertToBoolean(value);
	}

	/**
	 * Gets the parametro import xml.
	 * 
	 * @return the parametro import xml
	 */
	public boolean getParametroImportXml() {
		String value = this.getParametro(Constants.IMPORT_XML);

		return BaseMgr.convertToBoolean(value);
	}

	/**
	 * Gets the parametro firma pdf.
	 * 
	 * @return the parametro firma pdf
	 */
	public String getParametroFirmaPdf() {
		String value = this.getParametro(Constants.FIRMA_PDF);

		return value;
	}
	
	public String[] getParametroSedeRegione() {
		String param = this.getParametro(Constants.SEDE_REGIONE_PIEMONTE);
		
		return param.split(Constants.CARRIAGE_RETURN);
	}

	/**
	 * Gets the parametro xsd.
	 * 
	 * @return the parametro xsd
	 */
	/*
	public URL getParametroXsd() {

		URL value = null;
		try {
			value = new URL(this.getParametro(Constants.URL_XSD));
		} catch (MalformedURLException e) {
			log.error("URL_XSD non correttamente definito", e);
		}

		return value;
	}
	*/
	
	/**
	 * Gets the parametro certificati ammessi.
	 * 
	 * @return the parametro certificati ammessi
	 */
	public String getParametroCertificatiAmmessi() {
		return this.getParametro(Constants.CERTIFICATI_FIRMATI_AMMESSI);
	}

	/**
	 * Gets the parametro formati immagini ammessi.
	 * 
	 * @return the parametro formati immagini ammessi
	 */
	public String getParametroFormatiImmaginiAmmessi() {
		return this.getParametro(Constants.FORMATI_IMMAGINI_AMMESSI);

	}

	/**
	 * Convert xml to dati attestato.
	 * 
	 * @param file
	 *            the file
	 * @return the array list
	 * @throws BEException
	 *             the bE exception
	 */
	public List<DatiAttestato> convertXmlToDatiAttestato(File file)
			throws BEException {
		Document doc;

		ArrayList<DatiAttestato> list = null;
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			doc = db.parse(file);

			DatiAttestato orig = this.readXmlValues(doc);
			DatiAttestato calc = this.readXmlValues(doc);

			list = new ArrayList<DatiAttestato>();
			list.add(orig);
			list.add(calc);

		} catch (SAXException e) {
			throw new BEException("Errore file xml", e);
		} catch (ParserConfigurationException e) {
			throw new BEException("Errore file xml", e);
		} catch (IOException e) {
			throw new BEException("Errore file xml", e);
		} catch (Exception e) {
			throw new BEException("Errore file xml", e);
		}
		return list;
	}

	/**
	 * Convert xml to document.
	 * 
	 * @param xml
	 *            the xml
	 * @return the dOM source
	 */
	private DOMSource convertXmlToDocument(File xml) {
		Locale loc = Locale.getDefault();
		Locale.setDefault(Locale.ITALY);
		try {

			// Get a parser capable of parsing vanilla XML into a DOM tree
			DocumentBuilder parser = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();

			// parse the XML purely as XML and get a DOM tree represenation.
			Document document = parser.parse(xml);

			// parse the XML DOM tree againts the stricter XSD schema

			return new DOMSource(document);

		} catch (Exception e) {
			log.error(e);
			return null;
		} finally {
			Locale.setDefault(loc);
		}
	}

	/**
	 * Convert xml to stream.
	 * 
	 * @param source
	 *            the source
	 * @return the string
	 */
	public String convertXmlToStream(DOMSource source) {
		String xml = null;
		try {
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);

			// Write the DOM document to the file
			Transformer xformer = TransformerFactory.newInstance()
					.newTransformer();
			xformer.transform(source, result);

			xml = writer.getBuffer().toString();
		} catch (TransformerConfigurationException e) {
			log.error(e);
		} catch (TransformerException e) {
			log.error(e);
		}

		return xml;

	}

	/**
	 * Checks if is file xml valid file xml.
	 * 
	 * @param att
	 *            the att
	 * @param cert
	 *            the cert
	 * @param xml
	 *            the xml
	 * @return the array list
	 */
	/*
	public List<String> isFileXmlValidFileXml(DatiAttestato att,
			DatiCertificatore cert, File xml) {
		Validator validator = null;

		try {

			SchemaFactory schemaFactory = SchemaFactory
					.newInstance(Constants.W3C_XML_SCHEMA_NS_URI);
			// get the custom xsd schema describing the required format for my
			// XML files.
			Schema schemaXSD = schemaFactory.newSchema(this.getParametroXsd());

			// Create a Validator capable of validating XML files according to
			// my custom schema.

			validator = schemaXSD.newValidator();
			validator.setErrorHandler(new SiceeXmlErrorHandler());
			// Get a parser capable of parsing vanilla XML into a DOM tree
			// parse the XML DOM tree againts the stricter XSD schema

			validator.validate(this.convertXmlToDocument(xml));
			ArrayList<String> list = ((SiceeXmlErrorHandler) validator
					.getErrorHandler()).getList();
			if (list != null) {
				this.sendMailPerXml(att, cert, xml, list);
			}

			return list;

		} catch (Exception e) {
			log.error(e);
			return null;
		}

	}
	*/

	/**
	 * Send mail per xml.
	 * 
	 * @param att
	 *            the att
	 * @param cert
	 *            the cert
	 * @param xml
	 *            the xml
	 * @param errors
	 *            the errors
	 */
	public void sendMailPerXml(DatiAttestato att, DatiCertificatore cert,
			File xml, List<String> errors) {
		MailSender sender = new MailSender();
		it.csi.sicee.siceeweb.util.Mail email = new it.csi.sicee.siceeweb.util.Mail();
		it.csi.sicee.siceeorch.dto.siceeorch.Documento doc = new it.csi.sicee.siceeorch.dto.siceeorch.Documento();
		doc.setNome(att.getNumeroAttestato().replaceAll(" ", "_") + ".xml");
		doc.setDoc(this.readFile(xml));

		// invio e-mail ad assistenza
		email.setDestinatario(this.getParametro(Constants.EMAIL_XML));
		email.setHost(Constants.MAIL_HOST);
		email.setPort(Constants.MAIL_PORT);
		email.setMittente(this.getParametro(Constants.MAIL_MITT_XML));

		email.setOggetto(this.creaOggettoEmailXml(att, cert));
		email.setHtml(this.creaHtmlEmailXml(att, cert, errors));
		email.setTesto(this.creaTestoEmailXml(att, cert, errors));

		try {
			sendMail(email, doc);
		} catch (Exception e) {
			log.error(e);
		}

		// invio e-mail al certificatore
		email.setDestinatario(cert.getDtResidenza().getEmail());
		email.setHost(Constants.MAIL_HOST);
		email.setPort(Constants.MAIL_PORT);
		email.setMittente(this.getParametro(Constants.MAIL_MITT_XML));

		email.setOggetto(this.creaOggettoEmailXml(att, cert));
		email.setHtml(this.creaHtmlEmailXml(att, cert, errors));
		email.setTesto(this.creaTestoEmailXml(att, cert, errors));
		try {
			sendMail(email, doc);
		} catch (Exception e) {
			log.error(e);
		}

	}
	
	/**
	 * Send mail per xml.
	 * 
	 * @param att
	 *            the att
	 * @param cert
	 *            the cert
	 * @param xml
	 *            the xml
	 * @param errors
	 *            the errors
	 */
	public void sendMailPerXmlNew(DatiAttestato att, DatiCertificatore cert,
			File xml, List<String> errors, int numValidazione, boolean sendUtente) {
		MailSender sender = new MailSender();
		it.csi.sicee.siceeweb.util.Mail email = new it.csi.sicee.siceeweb.util.Mail();
		it.csi.sicee.siceeorch.dto.siceeorch.Documento doc = new it.csi.sicee.siceeorch.dto.siceeorch.Documento();
		doc.setNome(att.getNumeroAttestato().replaceAll(" ", "_") + ".xml");
		doc.setDoc(this.readFile(xml));

		
		gestisciErroreLogDbXml(att, cert, errors, numValidazione);
		
		/*
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
		String progrCertificato = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];
		
		// inserisco gli errori sul db
		SiceeTImportDatiLog2015 importLog = new SiceeTImportDatiLog2015();
		importLog.setIdCertificatore(idCertificatore);
		importLog.setProgrCertificato(progrCertificato);
		importLog.setAnno(anno);
		importLog.setTimestamp(new Date());
		importLog.setPassoValidazione(numValidazione);
		
		xx
		
		String msg = this.convertListaErroriToStringDb(errors);
		if (msg != null && msg.length() > Constants.LUNGHEZZA_MASSIMA_LOG)
		{
			// Il messaggio è troppo lungo, lo limito a 500 caratteri
			msg = msg.substring(0, Constants.LUNGHEZZA_MASSIMA_LOG);
		}
		
		importLog.setMessaggioErrore(msg);
		
		getSiceeTImportDatiLog2015Dao().insert(importLog);
		*/
		
		// invio e-mail ad assistenza
		email.setDestinatario(this.getParametro(Constants.EMAIL_XML));
		email.setHost(Constants.MAIL_HOST);
		email.setPort(Constants.MAIL_PORT);
		email.setMittente(this.getParametro(Constants.MAIL_MITT_XML));

		email.setOggetto(this.creaOggettoEmailXmlNew(att, cert, numValidazione));
		
		email.setHtml(this.creaHtmlEmailXml(att, cert, errors));
		email.setTesto(this.creaTestoEmailXml(att, cert, errors));

		if (log.isDebugEnabled())
		{
			log.debug("Stampo mail - getOggetto: "+email.getOggetto());
			log.debug("Stampo mail - getHtml: "+email.getHtml());
			log.debug("Stampo mail - getTesto: "+email.getTesto());
		}
		
		try {
			sendMail(email, doc);
		} catch (Exception e) {
			log.error("Ho ricevuto un'eccezione nell'invio mail, riprovo ad inviarla senza allegato");
			log.error(e);
			
			try
			{
				sendMail(email, null);
			} catch (Exception ex) {
				log.error("Ho ricevuto un'eccezione nell'invio mail SENZA ALLEGATO");
				log.error(e);
			}
			
		}

		if (sendUtente)
		{
			// invio e-mail al certificatore
			email.setDestinatario(cert.getDtResidenza().getEmail());
			email.setHost(Constants.MAIL_HOST);
			email.setPort(Constants.MAIL_PORT);
			email.setMittente(this.getParametro(Constants.MAIL_MITT_XML));
	
			email.setOggetto(this.creaOggettoEmailXmlNew(att, cert, numValidazione));
			email.setHtml(this.creaHtmlEmailXml(att, cert, errors));
			email.setTesto(this.creaTestoEmailXml(att, cert, errors));
			try {
				sendMail(email, doc);
			} catch (Exception e) {
				log.error("Ho ricevuto un'eccezione nell'invio mail, riprovo ad inviarla senza allegato");
				log.error(e);
				
				try
				{
					sendMail(email, null);
				} catch (Exception ex) {
					log.error("Ho ricevuto un'eccezione nell'invio mail SENZA ALLEGATO");
					log.error(e);
				}
				
			}
		}

	}
	
	public void gestisciErroreLogDbXml(DatiAttestato att, DatiCertificatore cert,
			String error, int numValidazione) {
		List<String> listError = new ArrayList<String>();
		listError.add(error);
		
		gestisciErroreLogDbXml(att, cert, listError, numValidazione);
	}
	
	public void gestisciErroreLogDbXml(DatiAttestato att, DatiCertificatore cert,
			List<String> errors, int numValidazione) {


		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
		String progrCertificato = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		// inserisco gli errori sul db
		SiceeTImportDatiLog2015 importLog = new SiceeTImportDatiLog2015();
		importLog.setIdCertificatore(idCertificatore);
		importLog.setProgrCertificato(progrCertificato);
		importLog.setAnno(anno);
		importLog.setTimestamp(new Date());
		importLog.setPassoValidazione(numValidazione);

		String msg = this.convertListaErroriToStringDb(errors);
		if (msg != null && msg.length() > Constants.LUNGHEZZA_MASSIMA_LOG)
		{
			// Il messaggio è troppo lungo, lo limito a 500 caratteri
			msg = msg.substring(0, Constants.LUNGHEZZA_MASSIMA_LOG);
		}

		importLog.setMessaggioErrore(msg);

		getSiceeTImportDatiLog2015Dao().insert(importLog);

	}

	/**
	 * Crea html email xml.
	 * 
	 * @param att
	 *            the att
	 * @param cert
	 *            the cert
	 * @param errors
	 *            the errors
	 * @return the string
	 */
	private String creaHtmlEmailXml(DatiAttestato att, DatiCertificatore cert,
			List<String> errors) {
		String msg = null;

		try {
			String messaggio = this.getParametro(Constants.TESTO_MAIL_XML_HTML);

			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE,
					att.getNumeroAttestato());
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, cert
					.getDtAnag().getNome());
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE,
					cert.getDtAnag().getCognome());
			messaggio = messaggio.replaceAll(Constants.DATA_INVIO, DateUtil
					.convertToString(new Date(System.currentTimeMillis())));

			messaggio = messaggio.replaceAll(Constants.LISTA_ERRORI,
					this.convertListaErroriToStringHtml(errors));
			msg = messaggio;
			
			/*
			if (msg != null && msg.length() > Constants.LUNGHEZZA_MASSIMA_LOG)
			{
				// Il messaggio è troppo lungo, lo limito a 500 caratteri
				msg = msg.substring(0, Constants.LUNGHEZZA_MASSIMA_LOG);
			}
			*/

			
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}

	/**
	 * Send mail per annullamento.
	 * 
	 * @param attestatoOld
	 *            the attestato old
	 * @param attestatoNew
	 *            the attestato new
	 * @param emailDest
	 *            the email dest
	 * @param annullamento
	 *            the annullamento
	 * @throws BEException
	 *             the bE exception
	 */
	public void sendMailPerAnnullamento(String attestatoOld,
			String attestatoNew, String emailDest, DtAnnullamento annullamento)
			throws BEException {
		MailSender sender = new MailSender();
		it.csi.sicee.siceeweb.util.Mail email = new it.csi.sicee.siceeweb.util.Mail();

		// Documento doc = new Documento();
		// doc.setNome(att.getNumeroAttestato().replaceAll(" ", "_") + ".xml");
		// doc.setDoc(readFile(xml));

		// Destinatario
		email.setDestinatario(emailDest);
		email.setHost(Constants.MAIL_HOST);
		email.setPort(Constants.MAIL_PORT);
		email.setMittente(this
				.getParametro(Constants.MITTENTE_MAIL_SOSTITUZIONE));

		email.setOggetto(this.creaOggettoEmailSostituzione(attestatoOld));
		email.setHtml(this.creaHtmlEmailSostituzione(attestatoOld,
				attestatoNew, annullamento));
		email.setTesto(this.creaTestoEmailSostituzione(attestatoOld,
				attestatoNew, annullamento));
		try {
			sendMail(email, null);
		} catch (Exception e) {
			log.error(e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Send mail per verifica mail.
	 * 
	 * @param attestatoOld
	 *            the attestato old
	 * @param attestatoNew
	 *            the attestato new
	 * @param emailDest
	 *            the email dest
	 * @param annullamento
	 *            the annullamento
	 * @throws BEException
	 *             the bE exception
	 */
	public void sendMailVerificaMail(DatiCertificatore cert, 
			String mailDest, String dataVerifica)
			throws BEException {
		MailSender sender = new MailSender();
		it.csi.sicee.siceeweb.util.Mail email = new it.csi.sicee.siceeweb.util.Mail();

		// Documento doc = new Documento();
		// doc.setNome(att.getNumeroAttestato().replaceAll(" ", "_") + ".xml");
		// doc.setDoc(readFile(xml));

		// Destinatario
		email.setDestinatario(mailDest);
		email.setHost(Constants.MAIL_HOST);
		email.setPort(Constants.MAIL_PORT);

		email.setMittente(this
				.getParametro(Constants.MITTENTE_MAIL_VERIFICA));

		String numOreScadenza = this
				.getParametro(Constants.ORE_VERIFICA_EMAIL);
		
//		public static final String MITTENTE_MAIL_VERIFICA = "MITTENTE_MAIL_VERIFICA";
//		public static final String OGGETTO_MAIL_VERIFICA = "OGGETTO_MAIL_VERIFICA";
//		public static final String TESTO_MAIL_VERIFICA_TXT = "TESTO_MAIL_VERIFICA_TXT";
//		public static final String TESTO_MAIL_VERIFICA_HTML = "TESTO_MAIL_VERIFICA_HTML";
		
		
		
		//TESTO_VERIFICA_EMAIL
		
		email.setOggetto(this
				.getParametro(Constants.OGGETTO_MAIL_VERIFICA));
		
		email.setHtml(this.creaHtmlEmailVerifica(cert.getDtAnag().getNome(),
				cert.getDtAnag().getCognome(), cert.getDtAnag().getCodFisc(), dataVerifica, numOreScadenza));
		
		email.setTesto(this.creaTestoEmailVerifica(cert.getDtAnag().getNome(),
				cert.getDtAnag().getCognome(), cert.getDtAnag().getCodFisc(), dataVerifica, numOreScadenza));
		
		try {
			sendMail(email, null);
		} catch (Exception e) {
			log.error(e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * CODICE INSERITO PER CAPIRE COME MAI A VOLTE VENGONO INSERITI IL DOPPIO DEI CERTIFICATI
	 * (è codice che dopo che si scova il baco si può cancellare)
	 */
	public void sendMailPerProblema(String testoErrore)
			throws BEException {
		MailSender sender = new MailSender();
		it.csi.sicee.siceeweb.util.Mail email = new it.csi.sicee.siceeweb.util.Mail();

		// Destinatario
		// Destinatario
				email.setDestinatario("assistenza.energia@csi.it");
				email.setHost(Constants.MAIL_HOST);
				email.setPort(Constants.MAIL_PORT);

				email.setMittente(this
						.getParametro(Constants.MITTENTE_MAIL_VERIFICA));

				
//				public static final String MITTENTE_MAIL_VERIFICA = "MITTENTE_MAIL_VERIFICA";
//				public static final String OGGETTO_MAIL_VERIFICA = "OGGETTO_MAIL_VERIFICA";
//				public static final String TESTO_MAIL_VERIFICA_TXT = "TESTO_MAIL_VERIFICA_TXT";
//				public static final String TESTO_MAIL_VERIFICA_HTML = "TESTO_MAIL_VERIFICA_HTML";
				
				
				
				//TESTO_VERIFICA_EMAIL
				
				email.setOggetto("PROBLEMA - duplicazione APE scartato");
				
				email.setHtml(testoErrore);
				
				if (log.isDebugEnabled())
				{
					log.debug("SETTO IL TESTO MAIL");
					
					log.debug(testoErrore.replace("<BR>", "\n"));
				}
				
				email.setTesto(testoErrore.replace("<BR>", "\n"));

		
		try {
			sendMail(email, null);
		} catch (Exception e) {
			log.error(e);
			throw new BEException(e.getMessage(), e);
		}

	}
	
	/**
	 * Crea html email sostituzione.
	 * 
	 * @param attestatoOld
	 *            the attestato old
	 * @param attestanoNew
	 *            the attestano new
	 * @param annullamento
	 *            the annullamento
	 * @return the string
	 */
	private String creaHtmlEmailSostituzione(String attestatoOld,
			String attestanoNew, DtAnnullamento annullamento) {
		String msg = null;

		try {
			String messaggio = this
					.getParametro(Constants.TESTO_MAIL_SOSTITUZIONE_HTML);

			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE_OLD,
					attestatoOld);
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE_NEW,
					attestanoNew);
			messaggio = messaggio.replaceAll(Constants.DATA_INVIO,
					annullamento.getData());

			messaggio = messaggio.replaceAll(Constants.MOTIVAZIONE,
					annullamento.getDescMotivo());
			messaggio = messaggio.replaceAll(Constants.NOTE,
					annullamento.getNote());

			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}

	/**
	 * Crea testo email sostituzione.
	 * 
	 * @param attestatoOld
	 *            the attestato old
	 * @param attestanoNew
	 *            the attestano new
	 * @param annullamento
	 *            the annullamento
	 * @return the string
	 */
	private String creaTestoEmailSostituzione(String attestatoOld,
			String attestanoNew, DtAnnullamento annullamento) {
		String msg = null;

		try {
			String messaggio = this
					.getParametro(Constants.TESTO_MAIL_SOSTITUZIONE_TXT);

			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE_OLD,
					attestatoOld);
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE_NEW,
					attestanoNew);
			messaggio = messaggio.replaceAll(Constants.DATA_INVIO,
					annullamento.getData());

			messaggio = messaggio.replaceAll(Constants.MOTIVAZIONE,
					annullamento.getDescMotivo());
			messaggio = messaggio.replaceAll(Constants.NOTE,
					annullamento.getNote());

			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}

		return msg;
	}

	/**
	 * Crea html email verifica mail.
	 * 
	 * @param nomeCertificatore
	 *            the nomeCertificatore
	 * @param cognomeCertificatore
	 *            the cognomeCertificatore
	 * @param cfCertificatore
	 *            the cfCertificatore
	 * @param email
	 *            the email
	 * @param scadenzaLink
	 *            the scadenzaLink
	 * @return the string
	 */
	private String creaHtmlEmailVerifica(String nomeCertificatore,
			String cognomeCertificatore, String cfCertificatore, String dataVerifica, String scadenzaLink) {
		String msg = null;

		try {
			String messaggio = this
					.getParametro(Constants.TESTO_MAIL_VERIFICA_HTML);

			
//			<BODY><P >Salve @nome.certificatore@ @cognome.certificatore@ <BR></P><P > Le chiediamo di confermare l'indirizzo email per poter proseguire con la registrazione al Sistema Informativo per 
//			le Certificazioni Energetiche degli Edifici cliccando il seguente link: @link.email@. Confermando l'indirizzo email sara' possibile accedere al sistema. <BR></P><P >
//			Le ricordiamo che questo link sara' valido per @scadenza_link@ ore. <BR></P><P > Assistenza Energia
			
			
			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE,
					nomeCertificatore);
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE,
					cognomeCertificatore);
			
			
			String url = this
					.getParametro(Constants.URL_MAIL_VERIFICA);
			
			String link = cfCertificatore+Constants.DIVIDE_LINK+dataVerifica;
			
			messaggio = messaggio.replaceAll(Constants.LINK_MAIL,
					url+linkGenerator(link));

			messaggio = messaggio.replaceAll(Constants.LINK_SCADENZA,
					scadenzaLink);

			msg = messaggio;
			
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}
	
	/**
	 * Crea testo email verifica mail.
	 * 
	 * @param nomeCertificatore
	 *            the nomeCertificatore
	 * @param cognomeCertificatore
	 *            the cognomeCertificatore
	 * @param cfCertificatore
	 *            the cfCertificatore
	 * @param email
	 *            the email
	 * @param scadenzaLink
	 *            the scadenzaLink
	 * @return the string
	 */
	private String creaTestoEmailVerifica(String nomeCertificatore,
			String cognomeCertificatore, String cfCertificatore, String dataVerifica, String scadenzaLink) {
		String msg = null;

		try {
			String messaggio = this
					.getParametro(Constants.TESTO_MAIL_VERIFICA_TXT);

			
//			<BODY><P >Salve @nome.certificatore@ @cognome.certificatore@ <BR></P><P > Le chiediamo di confermare l'indirizzo email per poter proseguire con la registrazione al Sistema Informativo per 
//			le Certificazioni Energetiche degli Edifici cliccando il seguente link: @link.email@. Confermando l'indirizzo email sara' possibile accedere al sistema. <BR></P><P >
//			Le ricordiamo che questo link sara' valido per @scadenza_link@ ore. <BR></P><P > Assistenza Energia
			
			
			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE,
					nomeCertificatore);
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE,
					cognomeCertificatore);
			
			
			String url = this
					.getParametro(Constants.URL_MAIL_VERIFICA);
			
			String link = cfCertificatore+Constants.DIVIDE_LINK+dataVerifica;
			
			messaggio = messaggio.replaceAll(Constants.LINK_MAIL,
					url+linkGenerator(link));

			messaggio = messaggio.replaceAll(Constants.LINK_SCADENZA,
					scadenzaLink);

			msg = messaggio;
			
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}
	
	public static String linkGenerator(String variabile) {

		log.debug("[MiscMgr] - linkGenerator - START");

		DesEncrypter d = new DesEncrypter(Constants.PASSPHRASE);

		String link = d.encrypt(variabile);

		if (log.isDebugEnabled())
			log.debug("IL CF CODIFICATO E' IL SEGUENTE " + link);

		link = d.encode(link);

		if (log.isDebugEnabled())
			log.debug("IL CF CODIFICATO E' IL SEGUENTE " + link);

		log.debug("[MiscMgr] - linkGenerator - END");
		return link;
	}
	
	public boolean isLinkCorrect(String linkCript, String cfCertificatore)
	{	
		boolean isCFCorretto = false;
		boolean isDataCorretta = false;
		
		DesEncrypter d = new DesEncrypter(Constants.PASSPHRASE);

		String urlDecriptata = d.decrypt(linkCript);
		
		StringTokenizer tok = new StringTokenizer(
				urlDecriptata, Constants.DIVIDE_LINK);
		
		String codiceFiscale = null;
		String data = null;
		
		if (tok.hasMoreTokens())
		{
			codiceFiscale = tok.nextToken();
			
			if (tok.hasMoreTokens())
			{
				data = tok.nextToken();
			}
		}
		
		
		if (codiceFiscale != null && data != null)
		{
			// Devo verificare che il link è ancora valido
			// ore scadenza link
			String scadenza = this
					.getParametro(Constants.ORE_VERIFICA_EMAIL);
			
			isCFCorretto = cfCertificatore.equalsIgnoreCase(codiceFiscale);
	
			isDataCorretta = verificaDataLink(data, BaseMgr.convertToInteger(scadenza));
		}
		
		return isCFCorretto && isDataCorretta;
	}
	
	public boolean isLastLink(String linkCript, String dataVerificaLink)
	{	
		boolean isLastLink = false;
		
		DesEncrypter d = new DesEncrypter(Constants.PASSPHRASE);

		String urlDecriptata = d.decrypt(linkCript);
		
		StringTokenizer tok = new StringTokenizer(
				urlDecriptata, Constants.DIVIDE_LINK);
		
		String data = null;
		
		if (tok.hasMoreTokens())
		{
			// Il CF in questo caso non mi interessa
			tok.nextToken();
			
			// Recupero la data
			if (tok.hasMoreTokens())
			{
				data = tok.nextToken();
			}
		}
		
		if (log.isDebugEnabled())
		{
			log.debug("Stampo la data recuperata db: "+dataVerificaLink);
			log.debug("Stampo la data recuperata link: "+data);
		}
		
		if (data != null)
		{
			isLastLink = data.equals(dataVerificaLink);
		}
		
		return isLastLink;
	}
	
	private boolean verificaDataLink(String dataLink, int oreScadenza)
	{
		boolean linkValido = false;
		try {
			Date dataMaxValLink = DateUtil.addHour(dataLink, oreScadenza);
			String sDataRiferimento = DateUtil.convertToStringDataCompleta(new Date());
			Date dDataRiferimento = DateUtil.convertToDateCompleta(sDataRiferimento);

			if (log.isDebugEnabled())
			{
				log.debug("Stampo la dataMaxValLink: "+dataMaxValLink);
				log.debug("Stampo la dDataRiferimento: "+dDataRiferimento);
			}
			
			linkValido = DateUtil.checkDateOrder(dDataRiferimento, dataMaxValLink, true);
			
			if (log.isDebugEnabled())
				log.debug("Link valido: "+linkValido);
			
			
			
		} catch (BEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linkValido;

	}
	
	
	
	/**
	 * Convert lista errori to string text.
	 * 
	 * @param errors
	 *            the errors
	 * @return the string
	 */
	private String convertListaErroriToStringText(List<String> errors) {
		StringBuffer list = new StringBuffer();
		for (int i = 0; i < errors.size(); i++) {
			list.append(errors.get(i));
			list.append("\n");
		}

		return list.toString();
	}

	/**
	 * Convert lista errori to string html.
	 * 
	 * @param errors
	 *            the errors
	 * @return the string
	 */
	private String convertListaErroriToStringHtml(List<String> errors) {
		StringBuffer list = new StringBuffer();
		for (int i = 0; i < errors.size(); i++) {
			list.append(errors.get(i));
			list.append("</br>");
		}

		return list.toString();
	}

	/**
	 * Convert lista errori to string text.
	 * 
	 * @param errors
	 *            the errors
	 * @return the string
	 */
	private String convertListaErroriToStringDb(List<String> errors) {
		StringBuffer list = new StringBuffer();
		for (int i = 0; i < errors.size(); i++) {
			list.append(errors.get(i));
			list.append(";");
		}

		return list.toString();
	}

	/**
	 * Crea testo email xml.
	 * 
	 * @param att
	 *            the att
	 * @param cert
	 *            the cert
	 * @param errors
	 *            the errors
	 * @return the string
	 */
	private String creaTestoEmailXml(DatiAttestato att, DatiCertificatore cert,
			List<String> errors) {
		String msg = null;

		try {
			String messaggio = this.getParametro(Constants.TESTO_MAIL_XML_TXT);

			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE,
					att.getNumeroAttestato());
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, cert
					.getDtAnag().getNome());
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE,
					cert.getDtAnag().getCognome());
			messaggio = messaggio.replaceAll(Constants.DATA_INVIO, DateUtil
					.convertToString(new Date(System.currentTimeMillis())));

			messaggio = messaggio.replaceAll(Constants.LISTA_ERRORI,
					this.convertListaErroriToStringText(errors));

			msg = messaggio;
			
			/*
			if (msg != null && msg.length() > Constants.LUNGHEZZA_MASSIMA_LOG)
			{
				// Il messaggio è troppo lungo, lo limito a 500 caratteri
				msg = msg.substring(0, Constants.LUNGHEZZA_MASSIMA_LOG);
			}
			*/
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}

	/**
	 * Crea oggetto email xml.
	 * 
	 * @param att
	 *            the att
	 * @param cert
	 *            the cert
	 * @return the string
	 */
	private String creaOggettoEmailXml(DatiAttestato att, DatiCertificatore cert) {
		String msg = null;

		try {
			String messaggio = this.getParametro(Constants.OGGETTO_MAIL_XML);

			messaggio = messaggio.replaceAll(Constants.CODICE_ACE,
					att.getNumeroAttestato());

			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;

	}

	/**
	 * Crea oggetto email xml.
	 * 
	 * @param att
	 *            the att
	 * @param cert
	 *            the cert
	 * @return the string
	 */
	private String creaOggettoEmailXmlNew(DatiAttestato att, DatiCertificatore cert, int numValidazione) {
		String msg = null;

		try {
			String messaggio = "VALIDAZIONE-"+numValidazione + " - " + this.getParametro(Constants.OGGETTO_MAIL_XML);

			messaggio = " " + messaggio.replaceAll(Constants.CODICE_ACE,
					att.getNumeroAttestato());

			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;

	}
	
	/**
	 * Crea oggetto email sostituzione.
	 * 
	 * @param att
	 *            the att
	 * @return the string
	 */
	private String creaOggettoEmailSostituzione(String att) {
		String msg = null;

		try {
			String messaggio = this
					.getParametro(Constants.OGGETTO_MAIL_SOSTITUZIONE);

			messaggio = messaggio.replaceAll(Constants.CODICE_ACE_OLD, att);

			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;

	}

	public byte[] resizeFoto(byte[] byteFile) {
		byte[] imgByte = null;
		try
		{

			Image inImage = new ImageIcon(byteFile).getImage();
			//
			int maxDim = 500;
			double scale = (double) maxDim / (double) inImage.getHeight(null);
			if (inImage.getWidth(null) > inImage.getHeight(null))
			{
				scale = (double) maxDim / (double) inImage.getWidth(null);
			}
			// Determine size of new image.
			//One of them
			// should equal maxDim.
			int scaledW = (int) (scale * inImage.getWidth(null));
			int scaledH = (int) (scale * inImage.getHeight(null));

			if (log.isDebugEnabled())
				log.debug("resizeFoto >> " 
					+ inImage.getSource().getClass() 
					+ " aspect ratio = " 
					+ scaledW + " , " + scaledH);
			
			Image img = inImage.getScaledInstance(scaledW , scaledH, Image.SCALE_SMOOTH);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			JimiRasterImage raster = Jimi.createRasterImage(img.getSource());

			Jimi.putImage("image/jpg", raster, bos);

			imgByte = bos.toByteArray();

			if (log.isDebugEnabled())
				log.debug("resizeFoto - imgByte: "+imgByte);

		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}

		return imgByte;
	}
	
	/**
	 * Read file.
	 * 
	 * @param f
	 *            the f
	 * @return the byte[]
	 */
	public byte[] readFile(File f) {
		InputStream is = null;
		byte[] bytes = null;
		
		log.debug("### PRIMA DI LEGGERE LA FOTO");

		try {
			is = new FileInputStream(f);

			long length = f.length();
			if (length > Integer.MAX_VALUE) {
				log.error("File is too large");
			}

			bytes = new byte[(int) length];

			is.read(bytes);

			is.close();
			log.debug("### DOPO DI LEGGERE LA FOTO");

		} catch (Exception e) {
			log.error("Impossibile leggere file", e);
		} finally {
			
			log.debug("### PRIMA (finally) DI LEGGERE LA FOTO");

			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("Impossibile chiudere stream", e);
				}
			}
			log.debug("### DOPO (finally) DI LEGGERE LA FOTO");
		}
		return bytes;
	}

	/**
	 * Checks if is file xml valid file xml.
	 * 
	 * @param xml
	 *            the xml
	 * @return the array list
	 */
	public List<String> isFileXmlValidFileXml(File xml) {
		//log.debug("XSD :" + this.getParametroXsd());
		return this.isFileXmlValidFileXml(xml, GenericUtil.getURLInClassPath(Constants.APE_2015_COMPLETO));
	}

	/**
	 * Checks if is file xml valid file xml.
	 * 
	 * @param xml
	 *            the xml
	 * @param xsd
	 *            the xsd
	 * @return the array list
	 */
	private List<String> isFileXmlValidFileXml(File xml, URL xsd) {
		Locale loc = Locale.getDefault();
		Locale.setDefault(Locale.ITALY);

		if (log.isDebugEnabled())
			log.info("COUNTRY: " + loc.getCountry());

		List<String> list = null;

		try {

			log.info("PASSO ");
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance(Constants.W3C_XML_SCHEMA_NS_URI);
			// get the custom xsd schema describing the required format for my

			log.info("PASSO 0");
			if (log.isDebugEnabled())
			{
				log.debug("PASSO 0 - schemaFactory: "+schemaFactory);
				log.debug("PASSO 0 - xsd: "+xsd);
			}

			// XML files.

			Schema schemaXSD = schemaFactory.newSchema(xsd);

			list = isFileXmlValidFileXml(xml, schemaXSD);


		} catch (Exception e) {
			log.error("ERRORE Exception", e);
			list = null;
		} finally {
			Locale.setDefault(loc);

		}
		return list;

	}

	/**
	 * Checks if is file xml valid file xml.
	 * 
	 * @param xml
	 *            the xml
	 * @param xsd
	 *            the xsd
	 * @return the array list
	 */
	public List<String> isFileXmlValidFileXml(File xml, File xsd) {
		//Validator validator = null;
		Locale loc = Locale.getDefault();
		Locale.setDefault(Locale.ITALY);
		
		if (log.isDebugEnabled())
			log.debug("COUNTRY: " + loc.getCountry());
		
		List<String> list = new LinkedList<String>();

		try {

			SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
			Schema schema = factory.newSchema(xsd);
			
			list = isFileXmlValidFileXml(xml, schema);
			
		} catch (Exception e) {
            //System.out.println("Exception: "+e.getMessage());
			list = null;
        }

		return list;

	}
	
	/**
	 * Checks if is file xml valid file xml.
	 * 
	 * @param xml
	 *            the xml
	 * @param xsd
	 *            the xsd
	 * @return the array list
	 */
	private List<String> isFileXmlValidFileXml(File xml, Schema schemaXsd) {
		//Validator validator = null;
		Locale loc = Locale.getDefault();
		Locale.setDefault(Locale.ITALY);
		
		if (log.isDebugEnabled())
			log.debug("COUNTRY: " + loc.getCountry());
		
		List<String> listErrorFormat = new ArrayList<String>();
		try {

			final List<String> list = new LinkedList<String>();

			SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
			//System.out.println("Stampo factory: "+factory);

			//Schema schema = factory.newSchema(xsd);
			
			//System.out.println("Stampo schema: "+schemaXsd);

            Validator validator = schemaXsd.newValidator();
            
			//System.out.println("Stampo validator: "+validator);

			//final List<String> list = new LinkedList<String>();
			  validator.setErrorHandler(new ErrorHandler()
			  {
			    public void warning(SAXParseException exception) throws SAXException
			    {
			    //System.out.println("####warning-exception.getMessage(): "+exception.getMessage());	
			    list.add(exception.getMessage());
			    }

			    public void fatalError(SAXParseException exception) throws SAXException
			    {
				    //System.out.println("####fatalError-exception.getMessage(): "+exception.getMessage());	
				    list.add(exception.getMessage());
			    }

			    public void error(SAXParseException exception) throws SAXException
			    {
				    //System.out.println("####error-exception.getMessage(): "+exception.getMessage());	
				    list.add(exception.getMessage());
			    }
			  });
			  
            validator.validate(new StreamSource(xml));
            
            if (list != null && list.size() > 0)
            {
            	String errorFormat = null;
	            for (int i = 0; i< list.size(); i++) {
	            	errorFormat = "ERRORE " + (i+1) + ": " + list.get(i);
					//System.out.println(errorFormat);
					listErrorFormat.add(i, errorFormat);
				}
            }
            
            /*
            for (SAXParseException saxParseException : exceptions) {
				System.out.println("Stampo saxParseException: "+saxParseException);
			}
            */
			//System.out.println("Stampo dopo validate....");
            
            
		} catch (Exception e) {
            log.error("Exception: "+e.getMessage());
            //list = null;
           return null;
        }

		return listErrorFormat;

	}
	
	/**
	 * Checks if is file xml valid file xml.
	 * 
	 * @param xml
	 *            the xml
	 * @param xsd
	 *            the xsd
	 * @return the array list
	 */
	/*
	public List<String> isFileXmlValidFileXml(File xml, File xsd) {
		Validator validator = null;
		Locale loc = Locale.getDefault();
		Locale.setDefault(Locale.ITALY);
		
		if (log.isDebugEnabled())
			log.debug("COUNTRY: " + loc.getCountry());
		
		List<String> list = null;

		try {

			SchemaFactory schemaFactory = SchemaFactory
					.newInstance(Constants.W3C_XML_SCHEMA_NS_URI);
			// get the custom xsd schema describing the required format for my
			// XML files.
			Schema schemaXSD = schemaFactory.newSchema(xsd);

			// Create a Validator capable of validating XML files according to
			// my custom schema.

			validator = schemaXSD.newValidator();
			validator.setErrorHandler(new SiceeXmlErrorHandler());
			// Get a parser capable of parsing vanilla XML into a DOM tree
			DocumentBuilder parser = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();

			// parse the XML purely as XML and get a DOM tree represenation.
			Document document = parser.parse(xml);

			System.out.println("Stampo document: "+document);
			
			// parse the XML DOM tree againts the stricter XSD schema

			validator.validate(new DOMSource(document));
			list = ((SiceeXmlErrorHandler) validator.getErrorHandler())
					.getList();
		} catch (org.xml.sax.SAXParseException e) {
			log.error(e);
			list = null;
		} catch (Exception e) {
			log.error(e);
			list = null;
		} finally {
			Locale.setDefault(loc);
		}

		return list;

	}
	*/
	
	

	/**
	 * Read xml values.
	 * 
	 * @param doc
	 *            the doc
	 * @return the dati attestato
	 * @throws Exception
	 *             the exception
	 */
	private DatiAttestato readXmlValues(Document doc) throws Exception {
		DatiAttestato ret = this.creaNuovaIstanza();
		try {
			List<SiceeDMappingXml> list = this.getSiceeDMappingXmlDao()
					.findAll();

			if (!BaseMgr.isNullOrEmpty(list)) {
				Iterator<SiceeDMappingXml> iter = list.iterator();
				while (iter.hasNext()) {
					SiceeDMappingXml map = iter.next();
					this.putValueFromElement(ret, doc, map.getCampoWeb(),
							map.getCampoXml());
				}
			}
		} catch (Exception e) {

			log.error(e);
		}

		return ret;
	}

	/*
	 * @SuppressWarnings("unchecked") private void
	 * putValueFromElement(DatiAttestato att, Document doc, String pathObj,
	 * String pathXml, Class klazz) throws Exception{ if
	 * (klazz.getName().endsWith("Date")) { NodeList nl =
	 * doc.getElementsByTagName(pathXml); Node n = nl.item(0); String value =
	 * (String) n.getFirstChild().getNodeValue(); try { value =
	 * convertToString(convertToDateFromXml(value));
	 * n.getFirstChild().setNodeValue(value);
	 * 
	 * } catch (BEException e) { log.error(e); } } putValueFromElement(att, doc,
	 * pathObj, pathXml); }
	 */

	/**
	 * Put value from element.
	 * 
	 * @param att
	 *            the att
	 * @param doc
	 *            the doc
	 * @param pathObj
	 *            the path obj
	 * @param pathXml
	 *            the path xml
	 * @throws Exception
	 *             the exception
	 */
	private void putValueFromElement(DatiAttestato att, Document doc,
			String pathObj, String pathXml) throws Exception {
		try {
			NodeList nl = doc.getElementsByTagName(pathXml);
			if (nl != null) {
				Node n = nl.item(0);
				if (n == null) {
					return;
				}
				if (n.getFirstChild() == null) {
					return;
				}
				Object value = n.getFirstChild().getNodeValue();

				String[] pathsObj = pathObj.split("\\.");
				String[] fields = pathObj.split("\\.");
				for (int i = 0; i < (pathsObj.length - 1); i++) {
					pathsObj[i] = "get" + this.makeUpperCaseFirst(pathsObj[i]);
				}
				pathsObj[pathsObj.length - 1] = "set"
						+ this.makeUpperCaseFirst(pathsObj[pathsObj.length - 1]);

				Object o = att;
				for (int i = 0; i < pathsObj.length - 1; i++) {
					Method m = o.getClass().getDeclaredMethod(pathsObj[i]);
					o = m.invoke(o);
					m.setAccessible(true);

				}

				Field f = o.getClass().getDeclaredField(
						"_" + fields[fields.length - 1]);
				f.setAccessible(true);

				Class<?> type = f.getType();
				Class<?> klass = null;
				String val = null;
				if (value != null) {
					val = value.toString();
				}
				if (type.getName().endsWith("UDTPositiveInteger")) {
					klass = UDTPositiveInteger.class;
					value = new UDTPositiveInteger(new Integer(val));
				} else if (type.getName().endsWith("UDTPositiveDoubleFour")) {
					klass = UDTPositiveDoubleFour.class;
					value = new UDTPositiveDoubleFour(new Double(val));
				} else if (type.getName().endsWith("UDTPositiveDoubleFive")) {
					klass = UDTPositiveDoubleFive.class;
					value = new UDTPositiveDoubleFive(new Double(val));
				} else if (type.getName().endsWith("UDTPositiveDoubleTwo")) {
					klass = UDTPositiveDoubleTwo.class;
					value = new UDTPositiveDoubleTwo(new Double(val));
				} else if (type.getName().endsWith("UDTDateValid")) {
					klass = UDTDateValid.class;
					value = new UDTDateValid(DateUtil.convertToString(DateUtil
							.convertToDateFromXml(val)));
				} else if (type.getName().endsWith("Integer")) {
					klass = Integer.class;
					value = new Integer(val);
				} else {
					klass = String.class;
				}

				Method m = o.getClass().getDeclaredMethod(
						pathsObj[pathsObj.length - 1], klass);
				m.invoke(o, value);

			}
		} catch (Exception e) {
			log.error("", e);
			throw e;
		}

	}

	/**
	 * Make upper case first.
	 * 
	 * @param someString
	 *            the some string
	 * @return the string
	 */
	private String makeUpperCaseFirst(String someString) {
		return someString.substring(0, 1).toUpperCase()
				+ someString.substring(1);
	}

	/**
	 * Crea nuova istanza.
	 * 
	 * @return the dati attestato
	 */
	private DatiAttestato creaNuovaIstanza() {
		DatiAttestato ret = new DatiAttestato();
		ret.setDatiAnagraficiImm(new DtAnagImmobile());
		ret.getDatiAnagraficiImm().setDtCatastali(new DtCatastali());
		ret.getDatiAnagraficiImm()
				.setDtCoCertificatore(new DtCoCertificatore());
		ret.getDatiAnagraficiImm().setDtResponsabili(new DtResponsabili());
		ret.setAltreInfo(new DtAltreInfo());
		ret.getAltreInfo().setEnergetiche(new DtAIEnergetiche());
		ret.getAltreInfo().setGenerali(new DtAIGenerali());
		ret.getAltreInfo().setSopralluoghi(new DtAISopralluoghi());
		ret.setClasseEnerg(new DtClasseEnerg());
		ret.getClasseEnerg().setLocReale(new DtLocReale());
		ret.getClasseEnerg().setLocTeorica(new DtLocTeorica());
		ret.setConsumiReali(new DtConsumiReali());
		ret.setDatiTecnici(new DtTecniciGen());
		ret.setDichiarazioni(new DtDichiarazFinale());
		ret.setEnergRinnov(new DtEnergiaFontiRinnov());
		ret.setGasSerra(new DtGasSerra());
		ret.setImpianti(new DtImpianti());
		ret.getImpianti().setAcqua(new DtImpAcqua());
		ret.getImpianti().setRiscaldamento(new DtImpRiscald());
		ret.setIndFabbisogno(new DtIndiciFabbisogno());
		ret.setRispNorme(new DtRispettoNorme());

		/*
		 * SoggResponsabile prog = new SoggResponsabile(); SoggResponsabile
		 * dirLav = new SoggResponsabile();
		 */

		return ret;
	}

	/** The calcolo mgr. */
	private CalcoloMgr calcoloMgr;

	/**
	 * Gets the calcolo mgr.
	 * 
	 * @return the calcolo mgr
	 */
	public CalcoloMgr getCalcoloMgr() {
		return this.calcoloMgr;
	}

	/**
	 * Sets the calcolo mgr.
	 * 
	 * @param calcoloMgr
	 *            the new calcolo mgr
	 */
	public void setCalcoloMgr(CalcoloMgr calcoloMgr) {
		this.calcoloMgr = calcoloMgr;
	}

	/**
	 * Check valide decodifiche.
	 * 
	 * @param calc
	 *            the calc
	 * @return the array list
	 */
	public List<String> checkValideDecodifiche(DatiAttestato calc) {
		ArrayList<String> list = new ArrayList<String>();
		try {

			if (GenericUtil.isNullOrEmpty(this.getSiceeDDestUsoDao()
					.findWhereIdDestUsoEquals(
							BaseMgr.convertToInteger(calc.getDatiTecnici()
									.getDestUso())))) {
				list.add("Il valore 'destinazioneUso' non e' valido");
			}
			if (GenericUtil.isNullOrEmpty(this.getSiceeDClasseEnergeticaDao()
					.findWhereIdClasseEquals(
							BaseMgr.convertToInteger(calc.getClasseEnerg()
									.getLocTeorica().getClasseEnerg())))) {
				list.add("Il valore 'codiceClasseEnergica' non e' valido");
			}
			if (GenericUtil.isNullOrEmpty(this.getSiceeDMotivoRilascioDao()
					.findWhereIdMotivoEquals(
							BaseMgr.convertToInteger(calc.getAltreInfo()
									.getGenerali().getMotivoRilascio())))) {
				list.add("Il valore 'motivazioneRilascio' non e' valido");
			}
			if (GenericUtil
					.isNullOrEmpty(this.getSiceeDClasseEnergeticaDao()
							.findWhereIdClasseEquals(
									BaseMgr.convertToInteger(calc
											.getAltreInfo().getEnergetiche()
											.getClasseEnergEdificio())))) {
				list.add("Il valore 'classeEnergGlobaleNazionaleEdificio' non e' valido");
			}
			if (GenericUtil.isNullOrEmpty(this.getSiceeDQualitaInvolucroDao()
					.findWhereIdQualitaEquals(
							BaseMgr.convertToInteger(calc.getAltreInfo()
									.getEnergetiche()
									.getQualitaInvolucroRaffresc())))) {
				list.add("Il valore 'qualitaTermicaEstivaEdificio' non e' valido");
			}
			if (GenericUtil.isNullOrEmpty(this.getSiceeDDatiIngressoDao()
					.findWhereIdDatiEquals(
							BaseMgr.convertToInteger(calc.getAltreInfo()
									.getSopralluoghi().getTipoRedazione())))) {
				list.add("Il valore 'datiRedazioneSopralluogo' non e' valido");
			}

			// BEPPE
			if (!BaseMgr.isNullOrEmpty(calc.getImpianti().getRiscaldamento()
					.getClasseEfficienzaEnerg())) {
				if (GenericUtil.isNullOrEmpty(this
						.getSiceeDClasseEfficienzaDao()
						.findWhereIdClasseEffEquals(
								BaseMgr.convertToInteger(calc.getImpianti()
										.getRiscaldamento()
										.getClasseEfficienzaEnerg())))) {
					list.add("Il valore 'classeEfficienzaEnergeticaRiscaldamento' non e' valido");
				}
			}

			if (GenericUtil.isNullOrEmpty(this.getSiceeDCombustibileDao()
					.findWhereIdCombustibileEquals(
							BaseMgr.convertToInteger(calc.getImpianti()
									.getRiscaldamento()
									.getCombustibileFossile())))) {
				list.add("Il valore 'fonteEnergeticaUtilizzataRiscaldamento' non e' valido");
			}
			if (GenericUtil.isNullOrEmpty(this.getSiceeDTipoImpiantoDao()
					.findWhereIdTipoImpiantoEquals(
							BaseMgr.convertToInteger(calc.getDatiTecnici()
									.getTipoImpianto())))) {
				list.add("Il valore 'tipoImpianto' non e' valido");
			}

			// BEPPE
			if (!BaseMgr.isNullOrEmpty(calc.getImpianti().getAcqua()
					.getClasseEfficienzaEnerg())) {
				if (GenericUtil
						.isNullOrEmpty(this.getSiceeDClasseEfficienzaDao()
								.findWhereIdClasseEffEquals(
										BaseMgr.convertToInteger(calc
												.getImpianti().getAcqua()
												.getClasseEfficienzaEnerg())))) {
					list.add("Il valore 'classeEfficienzaEnergeticaAcs' non e' valido");
				}
			}

			if (GenericUtil.isNullOrEmpty(this.getSiceeDCombustibileDao()
					.findWhereIdCombustibileEquals(
							BaseMgr.convertToInteger(calc.getImpianti()
									.getAcqua().getCombustibileFossile())))) {
				list.add("Il valore 'fonteEnergeticaUtilizzataAcs' non e' valido");
			}

		} catch (Exception e) {
			log.error(e);
		}

		return list;
	}

	/**
	 * Gets the string not null.
	 * 
	 * @param value
	 *            the value
	 * @return the string not null
	 */
	public String getStringNotNull(String value) {
		return (value != null) ? value : "";
	}

	/**
	 * isFileNameValid
	 * 
	 * @param widg_fileFotoCatastoFileName
	 * @return
	 *         boolean
	 */
	public boolean isFileNameValid(String name) {
	
		if (!GenericUtil.isNullOrEmpty(name)) {
			return name.matches(getParametroValiditaNomeFile());
		}
	
		return false;
	}
	
	private void sendMail(it.csi.sicee.siceeweb.util.Mail email, it.csi.sicee.siceeorch.dto.siceeorch.Documento doc)
	{
		MailSender sender = new MailSender();

		try
		{
			sender.sendMail(email, doc);
			
		} catch (Exception ex) {
			log.error("Errore nell'invio della mail", ex);

			try {
				
				// In caso di eccezione invio mail (problema noto)
				// javax.activation.UnsupportedDataTypeException: no object DCH for MIME type multipart/mixed;
				// tentiamo di inviare la mail grazie al servizio messo a disposizione di siceews
				getSoaIntegrationMgr().sendMailService(email, doc);
				
			} catch (BEException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
			//log.error(ex);
		}
	}
}
