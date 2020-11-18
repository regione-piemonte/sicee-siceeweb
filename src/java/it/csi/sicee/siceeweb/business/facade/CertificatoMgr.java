/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;
//import it.csi.modol.modolsrv.dto.XmlModel;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCerticatoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCarattEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCombustibileDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDestUso2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDichiarazioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDGradiGiornoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDIstruzioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDNormativaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDOggettoApe2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDPrioritaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDProprietaEdif2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRiqEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoCertDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoImpianto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoRistrutt2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipolEdilizia2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipolCostrutt2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTitoloDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDUnitaMisura2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDZonaClimatica2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCertifServener2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCombDener2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTActaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAltreInfoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCredito2018Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiFirmaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXmlEdReale2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiXmlEdRif2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAziendaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTConsumiEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiGeneraliDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDaticatastSecDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDetImp2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEnergiaSoprIngrDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFabbisognoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImportDati2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImpdatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImpRiscaldamentoAcsDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTQtaConsumi2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRaccomandazioniDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRaccomand2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRifIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRispettoNormativeDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRuoliEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTSiapeDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTSostituzioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifyReportDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeWCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.ZTImpdatiXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCerticato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDNormativa;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDPriorita;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDZonaClimatica2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTActa;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfoPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatoPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTClasseEnergeticaPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTConsumiEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTConsumiEdificioPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGeneraliPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEnergiaSoprIngr;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEnergiaSoprIngrPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFabbisogno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFabbisognoPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpdatiXml2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpRiscaldamentoAcs;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpRiscaldamentoAcsPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomandazioni;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015Pk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRispettoNormative;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRispettoNormativePk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRuoliEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRuoliEdificioPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSiape;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTSostituzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReportPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWCertificatorePk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.ZTImpdatiXml2015;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCerticatoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDGradiGiornoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDNormativaDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDPrioritaDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertificatoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTParametriDaoException;
import it.csi.sicee.siceeweb.business.print.dto.AceDto;
import it.csi.sicee.siceeweb.business.print.dto.DatiGenericiDto;
import it.csi.sicee.siceeweb.dto.LabelValue;
import it.csi.sicee.siceeweb.dto.ace.Ace;
import it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceeweb.dto.annullamento.DtAnnullamento;
import it.csi.sicee.siceeweb.dto.annullamento.MotivoAnnullamento;
import it.csi.sicee.siceeweb.dto.attestati.AttestatoSummary;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.attestati.Raccomandazione;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.daticert.DtAIEnergetiche;
import it.csi.sicee.siceeweb.dto.daticert.DtAIGenerali;
import it.csi.sicee.siceeweb.dto.daticert.DtAISopralluoghi;
import it.csi.sicee.siceeweb.dto.daticert.DtAltreInfo;
import it.csi.sicee.siceeweb.dto.daticert.DtAnagImmobile;
import it.csi.sicee.siceeweb.dto.daticert.DtCatastali;
import it.csi.sicee.siceeweb.dto.daticert.DtCatastaliSecondari;
import it.csi.sicee.siceeweb.dto.daticert.DtClasseEnerg;
import it.csi.sicee.siceeweb.dto.daticert.DtCoCertificatore;
import it.csi.sicee.siceeweb.dto.daticert.DtConsumiReali;
import it.csi.sicee.siceeweb.dto.daticert.DtDichiarazFinale;
import it.csi.sicee.siceeweb.dto.daticert.DtEnergiaFontiRinnov;
import it.csi.sicee.siceeweb.dto.daticert.DtFoto;
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
import it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile;
import it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento;
import it.csi.sicee.siceeweb.dto.pagamenti.GestioneCreditoNew;
import it.csi.sicee.siceeweb.dto.pagamenti.Transazione;
import it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.Converter;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.GenericUtil;
import it.csi.sicee.siceeweb.util.MapDto;
import it.csi.sicee.siceeweb.util.RaccomandazioneComparator;
import it.csi.sicee.siceeweb.util.XmlBeanUtils;
import it.csi.sicee.siceeweb.xml.attestato.data.AltriDatiEnergeticiDocument.AltriDatiEnergetici.Vettori;
import it.csi.sicee.siceeweb.xml.attestato.data.AttestatoDocument.Attestato;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneAcquaCalda;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneClimaEst;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneClimaInver;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneIlluminazione;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneImpiantiCombinati;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneProdFontiRinn;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneTrasporto;
import it.csi.sicee.siceeweb.xml.attestato.data.DettaglioImpiantiDocument.DettaglioImpianti.SezioneVentMecc;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;
import it.csi.sicee.siceeweb.xml.attestato.data.PrestEnergImpiantiDocument.PrestEnergImpianti.ElencoFontiEnergetiche;
import it.csi.sicee.siceeweb.xml.attestato.data.PrestEnergImpiantiDocument.PrestEnergImpianti.AltreFontiEnergetiche;
import it.csi.sicee.siceeweb.xml.attestato.data.RaccomandazioniDocument.Raccomandazioni.SezioneRen;
import it.csi.sicee.siceeweb.xml.attestato.data.RowConsumiCombustibileDocument.RowConsumiCombustibile;
import it.csi.sicee.siceeweb.xml.attestato.data.RowImpiantoDocument.RowImpianto;
import it.csi.sicee.siceeweb.xml.attestato.data.RowRenDocument.RowRen;
import it.csi.sicee.siceeweb.xml.attestato.data.RowVettoreDocument.RowVettore;
import it.csi.sicee.siceeweb.xml.attestato.data.RowDatiCatastaliDocument.RowDatiCatastali;
import it.csi.sicee.siceeweb.xml.attestato.data.RowSubalterniSingoliDocument.RowSubalterniSingoli;
import it.csi.sicee.siceeweb.xml.xmlapecompleto2015.data.DocumentoDocument;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.apache.xmlbeans.impl.util.Base64;

// TODO: Auto-generated Javadoc
/**
 * The Class CertificatoMgr.
 */
public class CertificatoMgr extends BaseMgr {

	/** The transazione ace mgr. */
	private TransazioneAceMgr transazioneAceMgr;

	/**
	 * Gets the transazione ace mgr.
	 *
	 * @return the transazione ace mgr
	 */
	public TransazioneAceMgr getTransazioneAceMgr() {
		return this.transazioneAceMgr;
	}

	/**
	 * Sets the transazione ace mgr.
	 *
	 * @param transazioneAceMgr the new transazione ace mgr
	 */
	public void setTransazioneAceMgr(TransazioneAceMgr transazioneAceMgr) {
		this.transazioneAceMgr = transazioneAceMgr;
	}

	/** The certificatore mgr. */
	private CertificatoreMgr certificatoreMgr;

	/**
	 * Gets the certificatore mgr.
	 *
	 * @return the certificatore mgr
	 */
	public CertificatoreMgr getCertificatoreMgr() {
		return this.certificatoreMgr;
	}

	/**
	 * Sets the certificatore mgr.
	 *
	 * @param certificatoreMgr the new certificatore mgr
	 */
	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}
	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}
	
	/** The sicee t certificato dao. */
	private SiceeTCertificatoDao siceeTCertificatoDao;

	/**
	 * Gets the sicee t certificato dao.
	 *
	 * @return the sicee t certificato dao
	 */
	public SiceeTCertificatoDao getSiceeTCertificatoDao() {
		return this.siceeTCertificatoDao;
	}

	/**
	 * Sets the sicee t certificato dao.
	 *
	 * @param siceeTCertificatoDao the new sicee t certificato dao
	 */
	public void setSiceeTCertificatoDao(
			SiceeTCertificatoDao siceeTCertificatoDao) {
		this.siceeTCertificatoDao = siceeTCertificatoDao;
	}

	/** The sicee t export bo dao. */
	private SiceeTExportBoDao siceeTExportBoDao;

	/**
	 * Gets the sicee t export bo dao.
	 *
	 * @return the sicee t export bo dao
	 */
	public SiceeTExportBoDao getSiceeTExportBoDao() {
		return this.siceeTExportBoDao;
	}

	/**
	 * Sets the sicee t export bo dao.
	 *
	 * @param siceeTExportBoDao the new sicee t export bo dao
	 */
	public void setSiceeTExportBoDao(SiceeTExportBoDao siceeTExportBoDao) {
		this.siceeTExportBoDao = siceeTExportBoDao;
	}

	/** The sicee t sostituzione dao. */
	private SiceeTSostituzioneDao siceeTSostituzioneDao;

	/**
	 * Gets the sicee t sostituzione dao.
	 *
	 * @return the sicee t sostituzione dao
	 */
	public SiceeTSostituzioneDao getSiceeTSostituzioneDao() {
		return this.siceeTSostituzioneDao;
	}

	/**
	 * Sets the sicee t sostituzione dao.
	 *
	 * @param siceeTSostituzioneDao the new sicee t sostituzione dao
	 */
	public void setSiceeTSostituzioneDao(
			SiceeTSostituzioneDao siceeTSostituzioneDao) {
		this.siceeTSostituzioneDao = siceeTSostituzioneDao;
	}

	/** The sicee w certificatore dao. */
	private SiceeWCertificatoreDao siceeWCertificatoreDao;

	/**
	 * Gets the sicee w certificatore dao.
	 *
	 * @return the sicee w certificatore dao
	 */
	public SiceeWCertificatoreDao getSiceeWCertificatoreDao() {
		return this.siceeWCertificatoreDao;
	}

	/**
	 * Sets the sicee w certificatore dao.
	 *
	 * @param siceeWCertificatoreDao the new sicee w certificatore dao
	 */
	public void setSiceeWCertificatoreDao(
			SiceeWCertificatoreDao siceeWCertificatoreDao) {
		this.siceeWCertificatoreDao = siceeWCertificatoreDao;
	}

	/**
	 * Gets the sicee t classe energetica dao.
	 *
	 * @return the sicee t classe energetica dao
	 */
	public SiceeTClasseEnergeticaDao getSiceeTClasseEnergeticaDao() {
		return this.siceeTClasseEnergeticaDao;
	}

	/**
	 * Sets the sicee t classe energetica dao.
	 *
	 * @param siceeTClasseEnergeticaDao the new sicee t classe energetica dao
	 */
	public void setSiceeTClasseEnergeticaDao(
			SiceeTClasseEnergeticaDao siceeTClasseEnergeticaDao) {
		this.siceeTClasseEnergeticaDao = siceeTClasseEnergeticaDao;
	}

	/**
	 * Gets the sicee t consumi edificio dao.
	 *
	 * @return the sicee t consumi edificio dao
	 */
	public SiceeTConsumiEdificioDao getSiceeTConsumiEdificioDao() {
		return this.siceeTConsumiEdificioDao;
	}

	/**
	 * Sets the sicee t consumi edificio dao.
	 *
	 * @param siceeTConsumiEdificioDao the new sicee t consumi edificio dao
	 */
	public void setSiceeTConsumiEdificioDao(
			SiceeTConsumiEdificioDao siceeTConsumiEdificioDao) {
		this.siceeTConsumiEdificioDao = siceeTConsumiEdificioDao;
	}

	/**
	 * Gets the sicee t dati generali dao.
	 *
	 * @return the sicee t dati generali dao
	 */
	public SiceeTDatiGeneraliDao getSiceeTDatiGeneraliDao() {
		return this.siceeTDatiGeneraliDao;
	}

	/**
	 * Sets the sicee t dati generali dao.
	 *
	 * @param siceeTDatiGeneraliDao the new sicee t dati generali dao
	 */
	public void setSiceeTDatiGeneraliDao(
			SiceeTDatiGeneraliDao siceeTDatiGeneraliDao) {
		this.siceeTDatiGeneraliDao = siceeTDatiGeneraliDao;
	}

	/**
	 * Gets the sicee t energia sopr ingr dao.
	 *
	 * @return the sicee t energia sopr ingr dao
	 */
	public SiceeTEnergiaSoprIngrDao getSiceeTEnergiaSoprIngrDao() {
		return this.siceeTEnergiaSoprIngrDao;
	}

	/**
	 * Sets the sicee t energia sopr ingr dao.
	 *
	 * @param siceeTEnergiaSoprIngrDao the new sicee t energia sopr ingr dao
	 */
	public void setSiceeTEnergiaSoprIngrDao(
			SiceeTEnergiaSoprIngrDao siceeTEnergiaSoprIngrDao) {
		this.siceeTEnergiaSoprIngrDao = siceeTEnergiaSoprIngrDao;
	}

	/**
	 * Gets the sicee t fabbisogno dao.
	 *
	 * @return the sicee t fabbisogno dao
	 */
	public SiceeTFabbisognoDao getSiceeTFabbisognoDao() {
		return this.siceeTFabbisognoDao;
	}

	/**
	 * Sets the sicee t fabbisogno dao.
	 *
	 * @param siceeTFabbisognoDao the new sicee t fabbisogno dao
	 */
	public void setSiceeTFabbisognoDao(SiceeTFabbisognoDao siceeTFabbisognoDao) {
		this.siceeTFabbisognoDao = siceeTFabbisognoDao;
	}

	/**
	 * Gets the sicee t imp riscaldamento acs dao.
	 *
	 * @return the sicee t imp riscaldamento acs dao
	 */
	public SiceeTImpRiscaldamentoAcsDao getSiceeTImpRiscaldamentoAcsDao() {
		return this.siceeTImpRiscaldamentoAcsDao;
	}

	/**
	 * Sets the sicee t imp riscaldamento acs dao.
	 *
	 * @param siceeTImpRiscaldamentoAcsDao the new sicee t imp riscaldamento acs dao
	 */
	public void setSiceeTImpRiscaldamentoAcsDao(
			SiceeTImpRiscaldamentoAcsDao siceeTImpRiscaldamentoAcsDao) {
		this.siceeTImpRiscaldamentoAcsDao = siceeTImpRiscaldamentoAcsDao;
	}

	/**
	 * Gets the sicee t raccomandazioni dao.
	 *
	 * @return the sicee t raccomandazioni dao
	 */
	public SiceeTRaccomandazioniDao getSiceeTRaccomandazioniDao() {
		return this.siceeTRaccomandazioniDao;
	}

	/**
	 * Sets the sicee t raccomandazioni dao.
	 *
	 * @param siceeTRaccomandazioniDao the new sicee t raccomandazioni dao
	 */
	public void setSiceeTRaccomandazioniDao(
			SiceeTRaccomandazioniDao siceeTRaccomandazioniDao) {
		this.siceeTRaccomandazioniDao = siceeTRaccomandazioniDao;
	}

	/**
	 * Gets the sicee t rispetto normative dao.
	 *
	 * @return the sicee t rispetto normative dao
	 */
	public SiceeTRispettoNormativeDao getSiceeTRispettoNormativeDao() {
		return this.siceeTRispettoNormativeDao;
	}

	/**
	 * Sets the sicee t rispetto normative dao.
	 *
	 * @param siceeTRispettoNormativeDao the new sicee t rispetto normative dao
	 */
	public void setSiceeTRispettoNormativeDao(
			SiceeTRispettoNormativeDao siceeTRispettoNormativeDao) {
		this.siceeTRispettoNormativeDao = siceeTRispettoNormativeDao;
	}

	/** The sicee t ruoli edificio dao. */
	private SiceeTRuoliEdificioDao siceeTRuoliEdificioDao;

	/**
	 * Gets the sicee t ruoli edificio dao.
	 *
	 * @return the sicee t ruoli edificio dao
	 */
	public SiceeTRuoliEdificioDao getSiceeTRuoliEdificioDao() {
		return this.siceeTRuoliEdificioDao;
	}

	/**
	 * Sets the sicee t ruoli edificio dao.
	 *
	 * @param siceeTRuoliEdificioDao the new sicee t ruoli edificio dao
	 */
	public void setSiceeTRuoliEdificioDao(
			SiceeTRuoliEdificioDao siceeTRuoliEdificioDao) {
		this.siceeTRuoliEdificioDao = siceeTRuoliEdificioDao;
	}

	/**
	 * Gets the sicee d priorita dao.
	 *
	 * @return the sicee d priorita dao
	 */
	public SiceeDPrioritaDao getSiceeDPrioritaDao() {
		return this.siceeDPrioritaDao;
	}

	/**
	 * Sets the sicee d priorita dao.
	 *
	 * @param siceeDPrioritaDao the new sicee d priorita dao
	 */
	public void setSiceeDPrioritaDao(SiceeDPrioritaDao siceeDPrioritaDao) {
		this.siceeDPrioritaDao = siceeDPrioritaDao;
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
	 * @param siceeDDichiarazioneDao the new sicee d dichiarazione dao
	 */
	public void setSiceeDDichiarazioneDao(SiceeDDichiarazioneDao siceeDDichiarazioneDao) {
		this.siceeDDichiarazioneDao = siceeDDichiarazioneDao;
	}

	/**
	 * Gets the sicee d tipo impianto 2015 dao.
	 *
	 * @return the sicee d tipo impianto 2015 dao
	 */
	public SiceeDTipoImpianto2015Dao getSiceeDTipoImpianto2015Dao() {
		return this.siceeDTipoImpianto2015Dao;
	}

	/**
	 * Sets the sicee d tipo impianto 2015 dao.
	 *
	 * @param siceeDTipoImpianto2015Dao the new sicee d tipo impianto 2015 dao
	 */
	public void setSiceeDTipoImpianto2015Dao(SiceeDTipoImpianto2015Dao siceeDTipoImpianto2015Dao) {
		this.siceeDTipoImpianto2015Dao = siceeDTipoImpianto2015Dao;
	}

	
	
	
	/**
	 * Gets the sicee t daticatast sec dao.
	 *
	 * @return the sicee t daticatast sec dao
	 */
	public SiceeTDaticatastSecDao getSiceeTDaticatastSecDao() {
		return this.siceeTDaticatastSecDao;
	}

	/**
	 * Sets the sicee t daticatast sec dao.
	 *
	 * @param siceeTDaticatastSecDao the new sicee t daticatast sec dao
	 */
	public void setSiceeTDaticatastSecDao(
			SiceeTDaticatastSecDao siceeTDaticatastSecDao) {
		this.siceeTDaticatastSecDao = siceeTDaticatastSecDao;
	}

	/**
	 * Sets the optimized sicee t certicato dao.
	 *
	 * @param optimizedSiceeTCerticatoDao the new optimized sicee t certicato dao
	 */
	public void setOptimizedSiceeTCerticatoDao(
			OptimizedSiceeTCerticatoDao optimizedSiceeTCerticatoDao) {
		this.optimizedSiceeTCerticatoDao = optimizedSiceeTCerticatoDao;
	}

	/** The sicee t credito 2018 dao. */
	private SiceeTCredito2018Dao siceeTCredito2018Dao;

	/**
	 * Gets the sicee t credito 2018 dao.
	 *
	 * @return the sicee t credito 2018 dao
	 */
	public SiceeTCredito2018Dao getSiceeTCredito2018Dao() {
		return this.siceeTCredito2018Dao;
	}

	/**
	 * Sets the sicee t credito 2018 dao.
	 *
	 * @param siceeTCredito2018Dao the new sicee t credito 2018 dao
	 */
	public void setSiceeTCredito2018Dao(
			SiceeTCredito2018Dao siceeTCredito2018Dao) {
		this.siceeTCredito2018Dao = siceeTCredito2018Dao;
	}

	/**
	 * Gets the optimized sicee t certicato dao.
	 *
	 * @return the optimized sicee t certicato dao
	 */
	public OptimizedSiceeTCerticatoDao getOptimizedSiceeTCerticatoDao() {
		return this.optimizedSiceeTCerticatoDao;
	}

	/** The sicee t classe energetica dao. */
	private SiceeTClasseEnergeticaDao siceeTClasseEnergeticaDao;
	
	/** The sicee t consumi edificio dao. */
	private SiceeTConsumiEdificioDao siceeTConsumiEdificioDao;
	
	/** The sicee t dati generali dao. */
	private SiceeTDatiGeneraliDao siceeTDatiGeneraliDao;
	
	/** The sicee t energia sopr ingr dao. */
	private SiceeTEnergiaSoprIngrDao siceeTEnergiaSoprIngrDao;
	
	/** The sicee t fabbisogno dao. */
	private SiceeTFabbisognoDao siceeTFabbisognoDao;
	
	/** The sicee t imp riscaldamento acs dao. */
	private SiceeTImpRiscaldamentoAcsDao siceeTImpRiscaldamentoAcsDao;
	
	/** The sicee t raccomandazioni dao. */
	private SiceeTRaccomandazioniDao siceeTRaccomandazioniDao;
	
	/** The sicee t rispetto normative dao. */
	private SiceeTRispettoNormativeDao siceeTRispettoNormativeDao;
	
	/** The sicee t altre info dao. */
	private SiceeTAltreInfoDao siceeTAltreInfoDao;
	
	/** The sicee t dati xml 2015 dao. */
	SiceeTDatiXml2015Dao siceeTDatiXml2015Dao;

	/** The sicee t dati xml ed reale 2015 dao. */
	SiceeTDatiXmlEdReale2015Dao siceeTDatiXmlEdReale2015Dao;

	/** The sicee t dati xml ed rif 2015 dao. */
	SiceeTDatiXmlEdRif2015Dao siceeTDatiXmlEdRif2015Dao;
	
	/** The sicee t import dati dao. */
	private SiceeTImportDati2015Dao siceeTImportDati2015Dao;

	/** The sicee t imp dati xml dao. */
	private SiceeTImpdatiXml2015Dao siceeTImpdatiXml2015Dao;

	/** The sicee d gradi giorno dao. */
	private SiceeDGradiGiornoDao siceeDGradiGiornoDao;
	
	/** The sicee d stato cert dao. */
	private SiceeDStatoCertDao siceeDStatoCertDao;
	
	/** The sicee d classe energetica dao. */
	private SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao;
	
	/** The sicee d normativa dao. */
	private SiceeDNormativaDao siceeDNormativaDao;
	
	/** The optimized sicee t certicato dao. */
	private OptimizedSiceeTCerticatoDao optimizedSiceeTCerticatoDao;
	
	/** The sicee t certificatore dao. */
	private SiceeTCertificatoreDao siceeTCertificatoreDao;
	
	/** The sicee d priorita dao. */
	private SiceeDPrioritaDao siceeDPrioritaDao;
	
	/** The sicee d dichiarazione dao. */
	private SiceeDDichiarazioneDao siceeDDichiarazioneDao;
	
	/** The sicee d dichiarazione dao. */
	private SiceeDTipoImpianto2015Dao siceeDTipoImpianto2015Dao;
	
	/** The sicee t daticatast sec dao. */
	private SiceeTDaticatastSecDao siceeTDaticatastSecDao;
	
	/** The sicee t parametri dao. */
	private SiceeTParametriDao siceeTParametriDao;
	
	/** The sicee d caratt edificio dao. */
	private SiceeDCarattEdificioDao siceeDCarattEdificioDao;
	
	/** The sicee d tipo edificio dao. */
	private SiceeDTipoEdificioDao siceeDTipoEdificioDao;

	/** The sicee d titolo dao. */
	private SiceeDTitoloDao siceeDTitoloDao;

	/** The sicee d unita misura dao. */
	private SiceeDUnitaMisura2015Dao siceeDUnitaMisura2015Dao;

	/** The sicee d zona climatica dao. */
	private SiceeDZonaClimatica2015Dao siceeDZonaClimatica2015Dao;

	/** The sicee d dest uso dao. */
	private SiceeDDestUso2015Dao siceeDDestUso2015Dao;

	/** The sicee d riq ener dao. */
	private SiceeDRiqEner2015Dao siceeDRiqEner2015Dao;

	/** The sicee d combustibile dao. */
	private SiceeDCombustibileDao siceeDCombustibileDao;

	/** The sicee d riq ener dao. */
	private SiceeTFoto2015Dao siceeTFoto2015Dao;
	
	/** The sicee t dati ener 2015 dao. */
	private SiceeTDatiEner2015Dao siceeTDatiEner2015Dao;
	
	/** The sicee t qta consumi 2015 dao. */
	private SiceeTQtaConsumi2015Dao siceeTQtaConsumi2015Dao;
	
	/** The sicee t raccomand 2015 dao. */
	private SiceeTRaccomand2015Dao siceeTRaccomand2015Dao;
	
	/** The sicee t det imp 2015 dao. */
	private SiceeTDetImp2015Dao siceeTDetImp2015Dao;

	/** The sicee r comb d ener 2015 dao. */
	private SiceeRCombDener2015Dao siceeRCombDener2015Dao;

	/** The sicee d istruzione dao. */
	private SiceeDIstruzioneDao siceeDIstruzioneDao;

	/** The sicee t azienda dao. */
	private SiceeTAziendaDao siceeTAziendaDao;

	/** The sicee r certif servener 2015 dao. */
	private SiceeRCertifServener2015Dao siceeRCertifServEner2015Dao;

	public SiceeRCertifServener2015Dao getSiceeRCertifServener2015Dao() {
		return this.siceeRCertifServEner2015Dao;
	}

	public void setSiceeRCertifServener2015Dao(
			SiceeRCertifServener2015Dao siceeRCertifServEner2015Dao) {
		this.siceeRCertifServEner2015Dao = siceeRCertifServEner2015Dao;
	}

	public SiceeTAziendaDao getSiceeTAziendaDao() {
		return this.siceeTAziendaDao;
	}

	public void setSiceeTAziendaDao(
			SiceeTAziendaDao siceeTAziendaDao) {
		this.siceeTAziendaDao = siceeTAziendaDao;
	}

	/**
	 * Gets d istruzione dao.
	 *
	 * @return the sicee d istruzione dao
	 */
	public SiceeDIstruzioneDao getSiceeDIstruzioneDao() {
		return this.siceeDIstruzioneDao;
	}

	/**
	 * Sets the d istruzione dao.
	 *
	 * @param siceeDIstruzioneDao the new sicee d istruzione dao
	 */
	public void setSiceeDIstruzioneDao(
			SiceeDIstruzioneDao siceeDIstruzioneDao) {
		this.siceeDIstruzioneDao = siceeDIstruzioneDao;
	}

	/**
	 * Gets sicee r comb d ener 2015 dao.
	 *
	 * @return the sicee r comb d ener 2015 dao
	 */
	public SiceeRCombDener2015Dao getSiceeRCombDener2015Dao() {
		return this.siceeRCombDener2015Dao;
	}

	/**
	 * Sets the sicee r comb d ener 2015 dao.
	 *
	 * @param siceeRCombDener2015Dao the new sicee r comb d ener 2015 dao
	 */
	public void setSiceeRCombDener2015Dao(
			SiceeRCombDener2015Dao siceeRCombDener2015Dao) {
		this.siceeRCombDener2015Dao = siceeRCombDener2015Dao;
	}

	/**
	 * Gets sicee t det imp 2015 dao.
	 *
	 * @return the sicee t det imp 2015 dao
	 */
	public SiceeTDetImp2015Dao getSiceeTDetImp2015Dao() {
		return this.siceeTDetImp2015Dao;
	}

	/**
	 * Sets the sicee t det imp 2015 dao.
	 *
	 * @param SiceeTDetImp2015Dao the new sicee t det imp 2015 dao
	 */
	public void setSiceeTDetImp2015Dao(
			SiceeTDetImp2015Dao siceeTDetImp2015Dao) {
		this.siceeTDetImp2015Dao = siceeTDetImp2015Dao;
	}

	/**
	 * Gets sicee t raccomand 2015 dao.
	 *
	 * @return the sicee t raccomand 2015 dao
	 */
	public SiceeTRaccomand2015Dao getSiceeTRaccomand2015Dao() {
		return this.siceeTRaccomand2015Dao;
	}

	/**
	 * Sets the sicee t raccomand 2015 dao.
	 *
	 * @param SiceeTRaccomand2015Dao the new sicee t raccomand 2015 dao
	 */
	public void setSiceeTRaccomand2015Dao(
			SiceeTRaccomand2015Dao siceeTRaccomand2015Dao) {
		this.siceeTRaccomand2015Dao = siceeTRaccomand2015Dao;
	}

	/**
	 * Gets sicee t qta consumi 2015 dao.
	 *
	 * @return the sicee t qta consumi 2015 dao
	 */
	public SiceeTQtaConsumi2015Dao getSiceeTQtaConsumi2015Dao() {
		return this.siceeTQtaConsumi2015Dao;
	}

	/**
	 * Sets the sicee t qta consumi 2015 dao.
	 *
	 * @param SiceeTQtaConsumi2015Dao the new sicee t qta consumi 2015 dao
	 */
	public void setSiceeTQtaConsumi2015Dao(
			SiceeTQtaConsumi2015Dao siceeTQtaConsumi2015Dao) {
		this.siceeTQtaConsumi2015Dao = siceeTQtaConsumi2015Dao;
	}

	/**
	 * Gets sicee t dati ener 2015 dao.
	 *
	 * @return the sicee t dati ener 2015 dao
	 */
	public SiceeTDatiEner2015Dao getSiceeTDatiEner2015Dao() {
		return this.siceeTDatiEner2015Dao;
	}

	/**
	 * Sets the sicee t dati ener 2015 dao.
	 *
	 * @param SiceeTDatiEner2015Dao the new sicee t dati ener 2015 dao
	 */
	public void setSiceeTDatiEner2015Dao(
			SiceeTDatiEner2015Dao siceeTDatiEner2015Dao) {
		this.siceeTDatiEner2015Dao = siceeTDatiEner2015Dao;
	}

	/**
	 * Gets the sicee d titolo dao.
	 *
	 * @return the sicee d titolo dao
	 */
	public SiceeDTitoloDao getSiceeDTitoloDao() {
		return this.siceeDTitoloDao;
	}

	/**
	 * Sets the sicee d titolo dao.
	 *
	 * @param siceeDTitoloDao the new sicee d titolo dao
	 */
	public void setSiceeDTitoloDao(
			SiceeDTitoloDao siceeDTitoloDao) {
		this.siceeDTitoloDao = siceeDTitoloDao;
	}

	/**
	 * Gets the sicee d dest uso dao.
	 *
	 * @return the sicee d dest uso dao
	 */
	public SiceeDDestUso2015Dao getSiceeDDestUso2015Dao() {
		return this.siceeDDestUso2015Dao;
	}

	/**
	 * Sets the sicee d dest uso dao.
	 *
	 * @param siceeDTitoloDao the new sicee d dest uso dao
	 */
	public void setSiceeDDestUso2015Dao(
			SiceeDDestUso2015Dao siceeDDestUso2015Dao) {
		this.siceeDDestUso2015Dao = siceeDDestUso2015Dao;
	}

	/**
	 * Gets the sicee d unita misura dao.
	 *
	 * @return the sicee d unita misura dao
	 */
	public SiceeDUnitaMisura2015Dao getSiceeDUnitaMisura2015Dao() {
		return this.siceeDUnitaMisura2015Dao;
	}

	/**
	 * Sets the sicee d unita misura dao.
	 *
	 * @param siceeDTitoloDao the new sicee d unita misura dao
	 */
	public void setSiceeDUnitaMisura2015Dao(
			SiceeDUnitaMisura2015Dao siceeDUnitaMisura2015Dao) {
		this.siceeDUnitaMisura2015Dao = siceeDUnitaMisura2015Dao;
	}

	/**
	 * Gets the sicee d riq ener dao.
	 *
	 * @return the sicee d riq ener dao
	 */
	public SiceeDRiqEner2015Dao getSiceeDRiqEner2015Dao() {
		return this.siceeDRiqEner2015Dao;
	}

	/**
	 * Sets the sicee d riq ener dao.
	 *
	 * @param siceeDRiqEner2015Dao the new sicee d riq ener dao
	 */
	public void setSiceeDRiqEner2015Dao(
			SiceeDRiqEner2015Dao siceeDRiqEner2015Dao) {
		this.siceeDRiqEner2015Dao = siceeDRiqEner2015Dao;
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
	 * @param siceeDCombustibileDao the new sicee d combustibile dao
	 */
	public void setSiceeDCombustibileDao(
			SiceeDCombustibileDao siceeDCombustibileDao) {
		this.siceeDCombustibileDao = siceeDCombustibileDao;
	}

	/**
	 * Gets the sicee d zona climatica dao.
	 *
	 * @return the sicee d zona climatica dao
	 */
	public SiceeDZonaClimatica2015Dao getSiceeDZonaClimatica2015Dao() {
		return this.siceeDZonaClimatica2015Dao;
	}

	/**
	 * Sets the sicee d zona climatica dao.
	 *
	 * @param siceeDTitoloDao the new sicee d zona climatica dao
	 */
	public void setSiceeDZonaClimatica2015Dao(
			SiceeDZonaClimatica2015Dao siceeDZonaClimatica2015Dao) {
		this.siceeDZonaClimatica2015Dao = siceeDZonaClimatica2015Dao;
	}

	/**
	 * Gets the sicee d titolo dao.
	 *
	 * @return the sicee d titolo dao
	 */
	public SiceeTFoto2015Dao getSiceeTFoto2015Dao() {
		return this.siceeTFoto2015Dao;
	}

	/**
	 * Sets the sicee d titolo dao.
	 *
	 * @param siceeDTitoloDao the new sicee d titolo dao
	 */
	public void setSiceeTFoto2015Dao(
			SiceeTFoto2015Dao siceeTFoto2015Dao) {
		this.siceeTFoto2015Dao = siceeTFoto2015Dao;
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
	 * @param siceeDTipoEdificioDao the new sicee d tipo edificio dao
	 */
	public void setSiceeDTipoEdificioDao(
			SiceeDTipoEdificioDao siceeDTipoEdificioDao) {
		this.siceeDTipoEdificioDao = siceeDTipoEdificioDao;
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
	 * @param siceeDCarattEdificioDao the new sicee d caratt edificio dao
	 */
	public void setSiceeDCarattEdificioDao(
			SiceeDCarattEdificioDao siceeDCarattEdificioDao) {
		this.siceeDCarattEdificioDao = siceeDCarattEdificioDao;
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
	 * @param siceeDClasseEnergeticaDao the new sicee d classe energetica dao
	 */
	public void setSiceeDClasseEnergeticaDao(
			SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao) {
		this.siceeDClasseEnergeticaDao = siceeDClasseEnergeticaDao;
	}

	/**
	 * Gets the sicee d normativa dao.
	 *
	 * @return the sicee d normativa dao
	 */
	public SiceeDNormativaDao getSiceeDNormativaDao() {
		return this.siceeDNormativaDao;
	}

	/**
	 * Sets the sicee d normativa dao.
	 *
	 * @param siceeDNormativaDao the new sicee d normativa dao
	 */
	public void setSiceeDNormativaDao(SiceeDNormativaDao siceeDNormativaDao) {
		this.siceeDNormativaDao = siceeDNormativaDao;
	}

	/**
	 * Gets the sicee d stato cert dao.
	 *
	 * @return the sicee d stato cert dao
	 */
	public SiceeDStatoCertDao getSiceeDStatoCertDao() {
		return this.siceeDStatoCertDao;
	}

	/**
	 * Sets the sicee d stato cert dao.
	 *
	 * @param siceeDStatoCertDao the new sicee d stato cert dao
	 */
	public void setSiceeDStatoCertDao(SiceeDStatoCertDao siceeDStatoCertDao) {
		this.siceeDStatoCertDao = siceeDStatoCertDao;
	}

	/**
	 * Gets the sicee d gradi giorno dao.
	 *
	 * @return the sicee d gradi giorno dao
	 */
	public SiceeDGradiGiornoDao getSiceeDGradiGiornoDao() {
		return this.siceeDGradiGiornoDao;
	}

	/**
	 * Sets the sicee d gradi giorno dao.
	 *
	 * @param siceeDGradiGiornoDao the new sicee d gradi giorno dao
	 */
	public void setSiceeDGradiGiornoDao(
			SiceeDGradiGiornoDao siceeDGradiGiornoDao) {
		this.siceeDGradiGiornoDao = siceeDGradiGiornoDao;
	}

	/**
	 * Gets the sicee t altre info dao.
	 *
	 * @return the sicee t altre info dao
	 */
	public SiceeTAltreInfoDao getSiceeTAltreInfoDao() {
		return this.siceeTAltreInfoDao;
	}

	/**
	 * Gets the sicee t dati xml 2015 dao.
	 *
	 * @return the sicee t dati xml 2015 dao
	 */
	public SiceeTDatiXml2015Dao getSiceeTDatiXml2015Dao() {
		return this.siceeTDatiXml2015Dao;
	}

	/**
	 * Sets the sicee t dati xml 2015 dao.
	 *
	 * @param siceeTDatiXml2015Dao the new sicee t dati xml 2015 dao
	 */
	public void setSiceeTDatiXml2015Dao(SiceeTDatiXml2015Dao siceeTDatiXml2015Dao) {
		this.siceeTDatiXml2015Dao = siceeTDatiXml2015Dao;
	}

	/**
	 * Gets the sicee t dati xml ed reale 2015 dao.
	 *
	 * @return the sicee t dati xml ed reale 2015 dao
	 */
	public SiceeTDatiXmlEdReale2015Dao getSiceeTDatiXmlEdReale2015Dao() {
		return this.siceeTDatiXmlEdReale2015Dao;
	}

	/**
	 * Sets the sicee t dati xml ed reale 2015 dao.
	 *
	 * @param siceeTDatiXmlEdReale2015Dao the new sicee t dati xml ed reale 2015 dao
	 */
	public void setSiceeTDatiXmlEdReale2015Dao(SiceeTDatiXmlEdReale2015Dao siceeTDatiXmlEdReale2015Dao) {
		this.siceeTDatiXmlEdReale2015Dao = siceeTDatiXmlEdReale2015Dao;
	}

	/**
	 * Gets the sicee t dati xml ed rif 2015 dao.
	 *
	 * @return the sicee t dati xml ed rif 2015 dao
	 */
	public SiceeTDatiXmlEdRif2015Dao getSiceeTDatiXmlEdRif2015Dao() {
		return this.siceeTDatiXmlEdRif2015Dao;
	}

	/**
	 * Sets the sicee t dati xml ed rif 2015 dao.
	 *
	 * @param siceeTDatiXmlEdRif2015Dao the new sicee t dati xml ed rif 2015 dao
	 */
	public void setSiceeTDatiXmlEdRif2015Dao(SiceeTDatiXmlEdRif2015Dao siceeTDatiXmlEdRif2015Dao) {
		this.siceeTDatiXmlEdRif2015Dao = siceeTDatiXmlEdRif2015Dao;
	}

	/**
	 * Sets the sicee t altre info dao.
	 *
	 * @param siceeTAltreInfoDao the new sicee t altre info dao
	 */
	public void setSiceeTAltreInfoDao(SiceeTAltreInfoDao siceeTAltreInfoDao) {
		this.siceeTAltreInfoDao = siceeTAltreInfoDao;
	}

	/**
	 * Gets the sicee t import dati dao.
	 *
	 * @return the sicee t import dati dao
	 */
	public SiceeTImportDati2015Dao getSiceeTImportDati2015Dao() {
		return this.siceeTImportDati2015Dao;
	}

	/**
	 * Sets the sicee t import dati dao.
	 *
	 * @param siceeTImportDati2015Dao the new sicee t import dati dao
	 */
	public void setSiceeTImportDati2015Dao(SiceeTImportDati2015Dao siceeTImportDati2015Dao) {
		this.siceeTImportDati2015Dao = siceeTImportDati2015Dao;
	}
	
	/**
	 * Gets the sicee t imp dati xml dao.
	 *
	 * @return the sicee t imp dati xml dao
	 */
	public SiceeTImpdatiXml2015Dao getSiceeTImpdatiXml2015Dao() {
		return this.siceeTImpdatiXml2015Dao;
	}

	/**
	 * Sets the sicee t imp dati xml dao.
	 *
	 * @param siceeTImpdatiXml2015Dao the new sicee t imp dati xml dao
	 */
	public void setSiceeTImpdatiXml2015Dao(SiceeTImpdatiXml2015Dao siceeTImpdatiXml2015Dao) {
		this.siceeTImpdatiXml2015Dao = siceeTImpdatiXml2015Dao;
	}
	
	/** The sicee t siape dao. */
	private SiceeTSiapeDao siceeTSiapeDao;

	/**
	 * Gets the sicee t siape dao.
	 *
	 * @return the sicee t siape dao
	 */
	public SiceeTSiapeDao getSiceeTSiapeDao() {
		return this.siceeTSiapeDao;
	}

	/**
	 * Sets the sicee t siape dao.
	 *
	 * @param siceeTSiapeDao the new sicee t siape dao
	 */
	public void setSiceeTSiapeDao(SiceeTSiapeDao siceeTSiapeDao) {
		this.siceeTSiapeDao = siceeTSiapeDao;
	}

	/** The sicee t acta dao. */
	private SiceeTActaDao siceeTActaDao;

	/**
	 * Gets the sicee t acta dao.
	 *
	 * @return the sicee t acta dao
	 */
	public SiceeTActaDao getSiceeTActaDao() {
		return this.siceeTActaDao;
	}

	/**
	 * Sets the sicee t acta dao.
	 *
	 * @param siceeTSiapeDao the new sicee t siape dao
	 */
	public void setSiceeTActaDao(SiceeTActaDao siceeTActaDao) {
		this.siceeTActaDao = siceeTActaDao;
	}

	
	/**
	 * Gets the sicee t certificatore dao.
	 *
	 * @return the sicee t certificatore dao
	 */
	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return this.siceeTCertificatoreDao;
	}

	/**
	 * Sets the sicee t certificatore dao.
	 *
	 * @param siceeTCertificatoreDao the new sicee t certificatore dao
	 */
	public void setSiceeTCertificatoreDao(
			SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
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
	 * @param siceeTParametriDao the new sicee t parametri dao
	 */
	public void setSiceeTParametriDao(SiceeTParametriDao siceeTParametriDao) {
		this.siceeTParametriDao = siceeTParametriDao;
	}

	/** The sicee t verify report dao. */
	private SiceeTVerifyReportDao siceeTVerifyReportDao;

	/**
	 * Gets the sicee t verify report dao.
	 *
	 * @return the sicee t verify report dao
	 */
	public SiceeTVerifyReportDao getSiceeTVerifyReportDao() {
		return this.siceeTVerifyReportDao;
	}

	/**
	 * Sets the sicee t verify report dao.
	 *
	 * @param siceeTVerifyReportDao the new sicee t verify report dao
	 */
	public void setSiceeTVerifyReportDao(
			SiceeTVerifyReportDao siceeTVerifyReportDao) {
		this.siceeTVerifyReportDao = siceeTVerifyReportDao;
	}

	/** The sicee t dati firma dao. */
	private SiceeTDatiFirmaDao siceeTDatiFirmaDao;

	/**
	 * Gets the sicee t dati firma dao.
	 *
	 * @return the sicee t dati firma dao
	 */
	public SiceeTDatiFirmaDao getSiceeTDatiFirmaDao() {
		return this.siceeTDatiFirmaDao;
	}

	/**
	 * Sets the sicee t dati firma dao.
	 *
	 * @param siceeTDatiFirmaDao the new sicee t dati firma dao
	 */
	public void setSiceeTDatiFirmaDao(SiceeTDatiFirmaDao siceeTDatiFirmaDao) {
		this.siceeTDatiFirmaDao = siceeTDatiFirmaDao;
	}
	
	// DAO 2015
		private SiceeTCertXml2015Dao siceeTCertXml2015Dao;
		
		public SiceeTCertXml2015Dao getSiceeTCertXml2015Dao() {
			return this.siceeTCertXml2015Dao;
		}
		public void setSiceeTCertXml2015Dao(SiceeTCertXml2015Dao siceeTCertXml2015Dao) {
			this.siceeTCertXml2015Dao = siceeTCertXml2015Dao;
		}

		private SiceeDTipoRistrutt2015Dao siceeDTipoRistrutt2015Dao;
		
		public SiceeDTipoRistrutt2015Dao getSiceeDTipoRistrutt2015Dao() {
			return this.siceeDTipoRistrutt2015Dao;
		}
		public void setSiceeDTipoRistrutt2015Dao(SiceeDTipoRistrutt2015Dao siceeDTipoRistrutt2015Dao) {
			this.siceeDTipoRistrutt2015Dao = siceeDTipoRistrutt2015Dao;
		}

		public List<SiceeDTipoRistrutt2015> recuperaDTipoRistrutt2015() throws BEException {

			List<SiceeDTipoRistrutt2015> vo = null;
			try {
				vo = this.getSiceeDTipoRistrutt2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaDTipoRistrutt2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		private SiceeDTipolEdilizia2015Dao siceeDTipolEdilizia2015Dao;
		
		public SiceeDTipolEdilizia2015Dao getSiceeDTipolEdilizia2015Dao() {
			return this.siceeDTipolEdilizia2015Dao;
		}
		public void setSiceeDTipolEdilizia2015Dao(SiceeDTipolEdilizia2015Dao siceeDTipolEdilizia2015Dao) {
			this.siceeDTipolEdilizia2015Dao = siceeDTipolEdilizia2015Dao;
		}

		public List<SiceeDTipolEdilizia2015> recuperaDTipolEdilizia2015() throws BEException {

			List<SiceeDTipolEdilizia2015> vo = null;
			try {
				vo = this.getSiceeDTipolEdilizia2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaDTipolEdilizia2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		private SiceeDTipolCostrutt2015Dao siceeDTipolCostrutt2015Dao;
		
		public SiceeDTipolCostrutt2015Dao getSiceeDTipolCostrutt2015Dao() {
			return this.siceeDTipolCostrutt2015Dao;
		}
		public void setSiceeDTipolCostrutt2015Dao(SiceeDTipolCostrutt2015Dao siceeDTipolCostrutt2015Dao) {
			this.siceeDTipolCostrutt2015Dao = siceeDTipolCostrutt2015Dao;
		}

		public List<SiceeDTipolCostrutt2015> recuperaDTipolCostrutt2015() throws BEException {

			List<SiceeDTipolCostrutt2015> vo = null;
			try {
				vo = this.getSiceeDTipolCostrutt2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaDTipolCostrutt2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		private SiceeDTipoFoto2015Dao siceeDTipoFoto2015Dao;
		
		public SiceeDTipoFoto2015Dao getSiceeDTipoFoto2015Dao() {
			return this.siceeDTipoFoto2015Dao;
		}
		public void setSiceeDTipoFoto2015Dao(SiceeDTipoFoto2015Dao siceeDTipoFoto2015Dao) {
			this.siceeDTipoFoto2015Dao = siceeDTipoFoto2015Dao;
		}

		public List<SiceeDTipoFoto2015> recuperaTipoFoto2015() throws BEException {

			List<SiceeDTipoFoto2015> vo = null;
			try {
				vo = this.getSiceeDTipoFoto2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaTipoFoto2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		private SiceeDProprietaEdif2015Dao siceeDProprietaEdif2015Dao;
		
		public SiceeDProprietaEdif2015Dao getSiceeDProprietaEdif2015Dao() {
			return this.siceeDProprietaEdif2015Dao;
		}
		public void setSiceeDProprietaEdif2015Dao(SiceeDProprietaEdif2015Dao siceeDProprietaEdif2015Dao) {
			this.siceeDProprietaEdif2015Dao = siceeDProprietaEdif2015Dao;
		}

		public List<SiceeDProprietaEdif2015> recuperaDProprietaEdif2015() throws BEException {

			List<SiceeDProprietaEdif2015> vo = null;
			try {
				vo = this.getSiceeDProprietaEdif2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaProprietaEdif2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		private SiceeDMotivoRilascioDao siceeDMotivoRilascioDao;
		
		public SiceeDMotivoRilascioDao getSiceeDMotivoRilascioDao() {
			return this.siceeDMotivoRilascioDao;
		}
		public void setSiceeDMotivoRilascioDao(SiceeDMotivoRilascioDao siceeDMotivoRilascioDao) {
			this.siceeDMotivoRilascioDao = siceeDMotivoRilascioDao;
		}

		private SiceeDOggettoApe2015Dao siceeDOggettoApe2015Dao;
		
		public SiceeDOggettoApe2015Dao getSiceeDOggettoApe2015Dao() {
			return this.siceeDOggettoApe2015Dao;
		}
		public void setSiceeDOggettoApe2015Dao(SiceeDOggettoApe2015Dao siceeDOggettoApe2015Dao) {
			this.siceeDOggettoApe2015Dao = siceeDOggettoApe2015Dao;
		}

		public List<SiceeDMotivoRilascio> recuperaDMotivoRilascio() throws BEException {

			List<SiceeDMotivoRilascio> vo = null;
			try {
				vo = this.getSiceeDMotivoRilascioDao().findMotiviStandardWhereFlgAttivoOn(Constants.ID_MOTIVO_ALTRO);
			} catch (Exception e) {
				log.error("Errore in recuperaDMotivoRilascio", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public List<SiceeDMotivoRilascio> recuperaServiziEnergia() throws BEException {

			List<SiceeDMotivoRilascio> vo = null;
			try {
				vo = this.getSiceeDMotivoRilascioDao().findAltroWhereFlgAttivoOn(Constants.ID_MOTIVO_ALTRO);
			} catch (Exception e) {
				log.error("Errore in recuperaDMotivoRilascio", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public List<SiceeDOggettoApe2015> recuperaDOggettoApe() throws BEException {

			List<SiceeDOggettoApe2015> vo = null;
			try {
				vo = this.getSiceeDOggettoApe2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaDOggettoApe", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public SiceeDMotivoRilascio recuperaDMotivoRilascioDecodifica(Integer idMotivo) throws BEException {

			SiceeDMotivoRilascio vo = null;
			try {
				vo = this.getSiceeDMotivoRilascioDao().findByPrimaryKey(idMotivo);
			} catch (Exception e) {
				log.error("Errore in recuperaDMotivoRilascioDecodifica", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public SiceeDTipoFoto2015 recuperaTipoFoto2015(long idTipoFoto) throws BEException {

			SiceeDTipoFoto2015 vo = null;
			try {
				vo = this.getSiceeDTipoFoto2015Dao().findByPrimaryKey(idTipoFoto);
			} catch (Exception e) {
				log.error("Errore in recuperaTipoFoto2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public SiceeTCertXml2015 recuperaCertXml2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			SiceeTCertXml2015 vo = null;
			try {
				vo = this.getSiceeTCertXml2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			} catch (Exception e) {
				log.error("Errore in recuperaCertXml2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public SiceeTCertificato recuperaCertificato(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			SiceeTCertificato vo = null;
			try {
				vo = this.getSiceeTCertificatoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			} catch (Exception e) {
				log.error("Errore in recuperaCertificato", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public SiceeTDatiGenerali recuperaDatiGenerali(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			SiceeTDatiGenerali vo = null;
			try {
				vo = this.getSiceeTDatiGeneraliDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			} catch (Exception e) {
				log.error("Errore in recuperaDatiGenerali", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public SiceeTAltreInfo recuperaAltreInfo(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			SiceeTAltreInfo vo = null;
			try {
				vo = this.getSiceeTAltreInfoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			} catch (Exception e) {
				log.error("Errore in recuperaAltreInfo", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public SiceeTDatiEner2015 recuperaDatiEner2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			SiceeTDatiEner2015 vo = null;
			try {
				vo = this.getSiceeTDatiEner2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			} catch (Exception e) {
				log.error("Errore in recuperaDatiEner2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public List<SiceeTDaticatastSec> recuperaDatiCatastaliSec(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			List<SiceeTDaticatastSec> vo = null;
			try {
				vo = this.getSiceeTDaticatastSecDao().findBySiceeTCertificato(idCertificatore, progrCertificato, anno);

			} catch (Exception e) {
				log.error("Errore in recuperaDatiCatastaliSec", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public List<SiceeTQtaConsumi2015> recuperaQuantitaConsumi2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			List<SiceeTQtaConsumi2015> vo = null;
			try {
				vo = this.getSiceeTQtaConsumi2015Dao().findWhereIdCertProgrAnno(idCertificatore, progrCertificato, anno);

			} catch (Exception e) {
				log.error("Errore in recuperaQuantitaConsumi2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public List<SiceeTRaccomand2015> recuperaRaccomand2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			List<SiceeTRaccomand2015> vo = null;
			try {
				vo = this.getSiceeTRaccomand2015Dao().findWhereIdCertProgrAnno(idCertificatore, progrCertificato, anno);

			} catch (Exception e) {
				log.error("Errore in recuperaRaccomand2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public SiceeRCombDener2015 recuperaCombDener2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			SiceeRCombDener2015 vo = null;
			try {
				List<SiceeRCombDener2015> voList = this.getSiceeRCombDener2015Dao().findBySiceeTDatiEner2015(idCertificatore, progrCertificato, anno);
				
				if (voList != null && voList.size() > 0)
				{
					// Prendo il primo elemento
					vo = voList.get(0);
				}

			} catch (Exception e) {
				log.error("Errore in recuperaCombDener2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public List<SiceeRCertifServener2015> recuperaCertifServener2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			List<SiceeRCertifServener2015> voList = null;
			try {
				voList = this.getSiceeRCertifServener2015Dao().findBySiceeTCertificato(idCertificatore, progrCertificato, anno);
				
			} catch (Exception e) {
				log.error("Errore in recuperaCombDener2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return voList;
		}
		
		public List<SiceeTDetImp2015> recuperaDetImp2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			List<SiceeTDetImp2015> voList = null;
			try {
				voList = this.getSiceeTDetImp2015Dao().findBySiceeTCertificato(idCertificatore, progrCertificato, anno);
				
			} catch (Exception e) {
				log.error("Errore in recuperaCombDener2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return voList;
		}
		
		public void eliminaFileIndexByUid(String uidFile) throws BEException {
			try {
				// Eliminazione documento da index
				getSoaIntegrationMgr().eliminaFileDaIndex(uidFile);
			} catch (Exception e) {
				
				if (e != null
						&& e.getMessage().contains("it.doqui.index.ecmengine.exception.publishing.NoSuchNodeException"))
				{
					log.error("E' una NoSuchNodeException, in questo caso ignoro l'eccezione, non ha trovato l'uid ("+uidFile+") su index)");
				}
				else
				{
					log.error("Errore in eliminaFileIndexByUid", e);
					throw new BEException(e.getMessage(), e);
				}
			}
		}
		
		/*
		public void eliminaXmlByUid(String uidIndex) throws BEException {
			try {
				// Eliminazione documento da index
				getSoaIntegrationMgr().eliminaDocumento(uidIndex);
			} catch (Exception e) {
				log.error("Errore in eliminaXmlByUid", e);
				throw new BEException(e.getMessage(), e);
			}
		}
		*/
		
		public String recuperaPreviewFotoByUid(String uidFoto) throws BEException {
			
			String indexResizedImage = null;
			try {
				Documento doc = getSoaIntegrationMgr().recuperaDocumento(uidFoto);
				if (doc.getDoc() != null) {
					byte[] indexOriginalImageByte = doc.getDoc();
					
					/*
					java.awt.image.BufferedImage originalImage = null;
					
					ByteArrayInputStream bis = new ByteArrayInputStream(indexOriginalImageByte);
					originalImage = javax.imageio.ImageIO.read(bis);
					bis.close();
					
					int iWidth = originalImage.getWidth();
					int iHeight = originalImage.getHeight();
					while ((iWidth > Constants.IMAGEPREVIEW_WIDTH) || (iHeight > Constants.IMAGEPREVIEW_HEIGHT)) {
						iWidth = (int) (iWidth * 0.90);
						iHeight = (int) (iHeight * 0.90);
					}
					
					BufferedImage resizedImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_4BYTE_ABGR);
					Graphics2D g2 = (Graphics2D) resizedImage.getGraphics();
					g2.drawImage(originalImage, 0, 0, resizedImage.getWidth(), resizedImage.getHeight(), 0, 0, originalImage.getWidth(), originalImage.getHeight(), null);
					g2.dispose();
					
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					javax.imageio.ImageIO.write(resizedImage, "png", bos);
					byte[] indexResizedImageByte = bos.toByteArray();
					bos.close();
					indexResizedImage = new String(Base64.encode(indexResizedImageByte));
					*/
					
					indexResizedImage = new String(Base64.encode(indexOriginalImageByte));

				}
			} catch (Exception e) {
				log.error("Errore in recuperaFotoByUid", e);
				throw new BEException(e.getMessage(), e);
			}
			return indexResizedImage;
		}

		public String recuperaFoto(String idCertificatore, String progrCertificato, String anno) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			String indexImage = null;
			List<SiceeTFoto2015> voList = null;
			try {
				voList = this.getSiceeTFoto2015Dao().findBySiceeTCertificatoFlgPrincipale(idCertificatore, progrCertificato, anno, "S");
				if ((voList == null) || (voList.size() == 0)) {
					log.debug("\n>>>>>>>NESSUNA FOTO PRESENTE");
				}
				else {
					log.debug("\n>>>>>>>FOTO PRESENTE");
					SiceeTFoto2015 vo = voList.get(0);
					Documento doc = getSoaIntegrationMgr().recuperaDocumento(vo.getIdentificFoto());
					if (doc.getDoc() != null) {
						
			            byte[] immagineEncodata = Base64.encode(doc.getDoc());
			            indexImage = new String(immagineEncodata);
						
				    }
				}
			} catch (Exception e) {
				log.error("Errore in recuperaFoto", e);
				throw new BEException(e.getMessage(), e);
			}
			return indexImage;
		}

		public SiceeTCertificatore recuperaCertificatore(String idCertificatore) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);

			SiceeTCertificatore vo = null;
			try {
				vo = this.getSiceeTCertificatoreDao().findByPrimaryKey(idCertificatore);
			} catch (Exception e) {
				log.error("Errore in recuperaCertificatore", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public List<SiceeTCertificatore> recuperaCertificatoriByCf(String codiceFiscale) throws BEException {

			log.debug("codiceFiscale: " + codiceFiscale);

			List<SiceeTCertificatore> vo = null;
			try {
				vo = this.getSiceeTCertificatoreDao().findByCf(codiceFiscale);
			} catch (Exception e) {
				log.error("Errore in recuperaCertificatoriByCf", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public SiceeTAzienda recuperaAzienda(long idAzienda) throws BEException {

			log.debug("idAzienda: " + idAzienda);

			SiceeTAzienda vo = null;
			try {
				vo = this.getSiceeTAziendaDao().findByPrimaryKey(idAzienda);
			} catch (Exception e) {
				log.error("Errore in recuperaAzienda", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		
		public String recuperaDTitolo(Integer fkIstruzione) throws BEException {

			log.debug("fkIstruzione: " + fkIstruzione);

			String dTitolo = null;
			try {
				// fkTitolo può essere null ?
				if (fkIstruzione != null)
					dTitolo = this.getSiceeDIstruzioneDao().findByPrimaryKey(fkIstruzione).getDenominazione();
			} catch (Exception e) {
				log.error("Errore in recuperaDTitolo", e);
				throw new BEException(e.getMessage(), e);
			}
			return dTitolo;
		}
		
		public List<SiceeDDestUso2015> recuperaElencoClassificazioni() throws BEException {

			List<SiceeDDestUso2015> list = new ArrayList<SiceeDDestUso2015>();
			try {
					list = this.getSiceeDDestUso2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaElencoClassificazioni", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}

		public SiceeDDestUso2015 recuperaDDestUso2015(Integer idDestUso2015) throws BEException {

			SiceeDDestUso2015 vo = new SiceeDDestUso2015();
			try {
					vo = this.getSiceeDDestUso2015Dao().findByPrimaryKey(idDestUso2015);
			} catch (Exception e) {
				log.error("Errore in recuperaDDestUso2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}

		public List<SiceeDZonaClimatica2015> recuperaElencoZoneClimatiche() throws BEException {

			List<SiceeDZonaClimatica2015> list = new ArrayList<SiceeDZonaClimatica2015>();
			try {
					list = this.getSiceeDZonaClimatica2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaElencoZoneClimatiche", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}

		public List<SiceeDUnitaMisura2015> recuperaElencoUnitaMisura() throws BEException {

			List<SiceeDUnitaMisura2015> list = new ArrayList<SiceeDUnitaMisura2015>();
			try {
					list = this.getSiceeDUnitaMisura2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaElencoUnitaMisura", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}

		public List<SiceeDRiqEner2015> recuperaElencoCodiciREN() throws BEException {

			List<SiceeDRiqEner2015> list = new ArrayList<SiceeDRiqEner2015>();
			try {
					list = this.getSiceeDRiqEner2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaElencoCodiciREN", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}

		private SiceeTRifIndex2015Dao siceeTRifIndex2015Dao;
		
		public SiceeTRifIndex2015Dao getSiceeTRifIndex2015Dao() {
			return this.siceeTRifIndex2015Dao;
		}
		public void setSiceeTRifIndex2015Dao(SiceeTRifIndex2015Dao siceeTRifIndex2015Dao) {
			this.siceeTRifIndex2015Dao = siceeTRifIndex2015Dao;
		}

		public List<SiceeDCombustibile> recuperaElencoCombustibiliEnEsportata() throws BEException {

			List<SiceeDCombustibile> list = new ArrayList<SiceeDCombustibile>();
			try {
					list = this.getSiceeDCombustibileDao().findWhereFlgVettoreEnExportEquals("S");
			} catch (Exception e) {
				log.error("Errore in recuperaElencoCombustibiliEnEsportata", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}

		public SiceeDCombustibile recuperaCombustibileById(Integer idCombustibile) throws BEException {

			SiceeDCombustibile comb = null;
			try {
				comb = this.getSiceeDCombustibileDao().findByPrimaryKey(idCombustibile);
			} catch (Exception e) {
				log.error("Errore in recuperaCombustibileById", e);
				throw new BEException(e.getMessage(), e);
			}
			return comb;
		}

		
		public List<SiceeDCombustibile> recuperaElencoCombustibiliDettImpianti() throws BEException {

			List<SiceeDCombustibile> list = new ArrayList<SiceeDCombustibile>();
			try {
					list = this.getSiceeDCombustibileDao().findWhereFlgVettoreDetImpEquals("S");
			} catch (Exception e) {
				log.error("Errore in recuperaElencoCombustibiliEnEsportata", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}
		
		public List<SiceeDCombustibile> recuperaElencoCombustibiliDettImpiantiImport() throws BEException {

			List<SiceeDCombustibile> list = new ArrayList<SiceeDCombustibile>();
			List<SiceeDCombustibile> listReturn = new ArrayList<SiceeDCombustibile>();

			try {
					list = this.getSiceeDCombustibileDao().findWhereFlgVettoreDetImpEquals("S");
					for (SiceeDCombustibile c : list) {
						if (c.getIdCombustibile().intValue() != Constants.ID_COMBUSTIBILE_ALTRO)
							listReturn.add(c);
					}
			} catch (Exception e) {
				log.error("Errore in recuperaElencoCombustibiliEnEsportata", e);
				throw new BEException(e.getMessage(), e);
			}
			return listReturn;
		}
		
		//@@SETTEMBRE 2015 INIZIO
		public SiceeTRifIndex2015 recuperaRifIndex2015(String idCertificatore, String progrCertificato, String anno, Integer idTipoDoc) throws BEException {

			log.debug("idCertificatore: " + idCertificatore);
			log.debug("progressivoCertificato: " + progrCertificato);
			log.debug("anno: " + anno);

			SiceeTRifIndex2015 vo = null;
			try {
				vo = this.getSiceeTRifIndex2015Dao().findBySiceeTCertificatoidTipoDoc(idCertificatore, progrCertificato, anno, idTipoDoc);
			} catch (Exception e) {
				log.error("Errore in recuperaRifIndex2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return vo;
		}
		//@@SETTEMBRE 2015 FINE
		
		public List<SiceeDCombustibile> recuperaElencoConsumiCombustibile() throws BEException {

			List<SiceeDCombustibile> list = new ArrayList<SiceeDCombustibile>();
			List<SiceeDCombustibile> listReturn = new ArrayList<SiceeDCombustibile>();
			try {
					list = this.getSiceeDCombustibileDao().findWhereFlgConsumiEquals("S");
					for (SiceeDCombustibile c : list) {
						if (c.getIdCombustibile().intValue() != Constants.ID_COMBUSTIBILE_ALTRO)
							listReturn.add(c);
					}
			} catch (Exception e) {
				log.error("Errore in recuperaElencoConsumiCombustibile", e);
				throw new BEException(e.getMessage(), e);
			}
			return listReturn;
		}

		public SiceeDClasseEnergetica recuperaClasseEnergeticaAttivaWhereDescrEquals(String descr) throws BEException {

			SiceeDClasseEnergetica dto = null;
			try {
				List<SiceeDClasseEnergetica> list = this.getSiceeDClasseEnergeticaDao().findAttivoWhereDescrEquals("1", descr);
				// Questo metodo deve ritornare un solo risultato
				if (list != null && list.size() == 1)
				{
					dto = list.get(0);
				}
					
			} catch (Exception e) {
				log.error("Errore in recuperaClasseEnergeticaAttivaWhereDescrEquals", e);
				throw new BEException(e.getMessage(), e);
			}
			return dto;
		}

		public List<SiceeDClasseEnergetica> recuperaElencoClasseEnergetica() throws BEException {

			List<SiceeDClasseEnergetica> list = new ArrayList<SiceeDClasseEnergetica>();
			try {
					list = this.getSiceeDClasseEnergeticaDao().findWhereFlgAttivoEquals("1");
			} catch (Exception e) {
				log.error("Errore in recuperaElencoClasseEnergetica", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}
		
		public List<SiceeDRiqEner2015> recuperaElencoRiqEnerg() throws BEException {

			List<SiceeDRiqEner2015> list = new ArrayList<SiceeDRiqEner2015>();
			try {
					list = this.getSiceeDRiqEner2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaElencoRiqEnerg", e);
				throw new BEException(e.getMessage(), e);
			}
			return list;
		}
		
		
		public SiceeDClasseEnergetica recuperaClasseEnergetica(Integer idClasse) throws BEException {

			SiceeDClasseEnergetica dto = null;
			try {
				dto = this.getSiceeDClasseEnergeticaDao().findByPrimaryKey(idClasse);
			} catch (Exception e) {
				log.error("Errore in recuperaClasseEnergetica", e);
				throw new BEException(e.getMessage(), e);
			}
			return dto;
		}

		public SiceeDDichiarazione recuperaDichiarazioneIndipendenza(Integer idDichiarazione) throws BEException {

			SiceeDDichiarazione dto = null;
			try {
				dto = this.getSiceeDDichiarazioneDao().findByPrimaryKey(idDichiarazione);
			} catch (Exception e) {
				log.error("Errore in recuperaDichiarazioneIndipendenza", e);
				throw new BEException(e.getMessage(), e);
			}
			return dto;
		}

		public List<SiceeDTipoImpianto2015> recuperaElencoTipoImpianto2015() throws BEException {

			List<SiceeDTipoImpianto2015> dtoList = null;
			try {
				dtoList = this.getSiceeDTipoImpianto2015Dao().findAll();
			} catch (Exception e) {
				log.error("Errore in recuperaElencoTipoImpianto2015", e);
				throw new BEException(e.getMessage(), e);
			}
			return dtoList;
		}
		
		public void salvaModuloApeXml(SiceeTCertXml2015 certXML) throws BEException {
			// recupero XML da db
			SiceeTCertXml2015 certXMLonDB = this.recuperaCertXml2015(certXML.getIdCertificatore(),
					certXML.getProgrCertificato(), certXML.getAnno());

			try {
				if (certXMLonDB != null) {
					log.debug("CERTIFICATO GIA' PRESENTE SUL DB: UPDATE");
					SiceeTCertXml2015Pk pk = new SiceeTCertXml2015Pk();
					pk.setIdCertificatore(certXML.getIdCertificatore());
					pk.setProgrCertificato(certXML.getProgrCertificato());
					pk.setAnno(certXML.getAnno());
					this.getSiceeTCertXml2015Dao().update(pk, certXML);
				} else {
					log.debug("CERTIFICATO NON PRESENTE SUL DB: INSERT");
					this.getSiceeTCertXml2015Dao().insert(certXML);
				}				
			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
/*		
		public void salvaInfoFileXml(SiceeTImportDati2015 datiOrigXML) throws BEException {
			try {
				SiceeTImportDati2015Pk pk = new SiceeTImportDati2015Pk();
				pk.setIdCertificatore(datiOrigXML.getIdCertificatore());
				pk.setProgrCertificato(datiOrigXML.getProgrCertificato());
				pk.setAnno(datiOrigXML.getAnno());
				this.getSiceeTImportDati2015Dao().delete(pk);
				this.getSiceeTImportDati2015Dao().insert(datiOrigXML);
			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
*/
/*		
		public void salvaFileXml(SiceeTImpdatiXml2015 origXML) throws BEException {
			try {
				SiceeTImpdatiXml2015Pk pk = new SiceeTImpdatiXml2015Pk();
				pk.setIdCertificatore(origXML.getIdCertificatore());
				pk.setProgrCertificato(origXML.getProgrCertificato());
				pk.setAnno(origXML.getAnno());
				this.getSiceeTImpdatiXml2015Dao().delete(pk);
				this.getSiceeTImpdatiXml2015Dao().insert(origXML);
			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
*/		
	/**
	 * Insert certificato.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @param idTransazione the id transazione
	 * @param anno the anno
	 * @return the integer
	 * @throws BEException the bE exception
	 */
		public Integer insertCertificato(DatiCertificatore cert,
				Long idTransazione, String anno) throws BEException {
			Date date = new Date(System.currentTimeMillis());
			String year = DateUtil.convertToString(date).substring(6);
			SiceeWCertificatorePk pk = new SiceeWCertificatorePk(new Integer(
					cert.getIdCertificatore()), year);

			SiceeWCertificatore prog = null;

			try {
				prog = this.getSiceeWCertificatoreDao().findByPrimaryKey(pk);
				prog.setProgrCertificato(prog.getProgrCertificato() + 1);

				SiceeTCertificato dto = this.mapToDB(cert, prog, idTransazione);
				this.getSiceeTCertificatoDao().insert(dto);

				this.getSiceeWCertificatoreDao().update(pk, prog);
			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}

			return prog.getProgrCertificato();

		}
		
		
/*
		public void updateCertificato(SiceeTCertificato dto) throws BEException {
			SiceeTCertificatoPk pk = new SiceeTCertificatoPk();
			pk.setIdCertificatore(dto.getIdCertificatore());
			pk.setProgrCertificato(dto.getProgrCertificato());
			pk.setAnno(dto.getAnno());
			try {
				this.getSiceeTCertificatoDao().update(pk, dto);

			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
*/
/*
		public void updateDatiGenerali(SiceeTDatiGenerali dto) throws BEException {
			SiceeTDatiGeneraliPk pk = new SiceeTDatiGeneraliPk();
			pk.setIdCertificatore(dto.getIdCertificatore());
			pk.setProgrCertificato(dto.getProgrCertificato());
			pk.setAnno(dto.getAnno());
			try {
				SiceeTDatiGenerali obj = this.getSiceeTDatiGeneraliDao().findByPrimaryKey(pk);
				if (obj == null) {
					obj = new SiceeTDatiGenerali();
					obj.setIdCertificatore(dto.getIdCertificatore());
					obj.setProgrCertificato(dto.getProgrCertificato());
					obj.setAnno(dto.getAnno());
					this.getSiceeTDatiGeneraliDao().insert(obj);
				}
				// obbligatori: AnnoCostruzione, ZonaClimatica ; non obbligatorio: AnnoUltRist
				this.getSiceeTDatiGeneraliDao().update(pk, dto);

			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
*/
/*
		public void updateAltreInfo(SiceeTAltreInfo dto) throws BEException {
			SiceeTAltreInfoPk pk = new SiceeTAltreInfoPk();
			pk.setIdCertificatore(dto.getIdCertificatore());
			pk.setProgrCertificato(dto.getProgrCertificato());
			pk.setAnno(dto.getAnno());
			try {
				SiceeTAltreInfo obj = this.getSiceeTAltreInfoDao().findByPrimaryKey(pk);
				if (obj == null) {
					obj = new SiceeTAltreInfo();
					obj.setIdCertificatore(dto.getIdCertificatore());
					obj.setProgrCertificato(dto.getProgrCertificato());
					obj.setAnno(dto.getAnno());
					this.getSiceeTAltreInfoDao().insert(obj);
				}
				this.getSiceeTAltreInfoDao().update(pk, dto);

			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
*/
/*
		public void deleteDatiXmlAll(SiceeTDatiXml2015 dto1, SiceeTDatiXmlEdReale2015 dto2, SiceeTDatiXmlEdRif2015 dto3) throws BEException {
			SiceeTDatiXml2015Pk pk1 = new SiceeTDatiXml2015Pk();
			pk1.setIdCertificatore(dto1.getIdCertificatore());
			pk1.setProgrCertificato(dto1.getProgrCertificato());
			pk1.setAnno(dto1.getAnno());
			SiceeTDatiXmlEdReale2015Pk pk2 = new SiceeTDatiXmlEdReale2015Pk();
			pk2.setIdCertificatore(dto2.getIdCertificatore());
			pk2.setProgrCertificato(dto2.getProgrCertificato());
			pk2.setAnno(dto2.getAnno());
			SiceeTDatiXmlEdRif2015Pk pk3 = new SiceeTDatiXmlEdRif2015Pk();
			pk3.setIdCertificatore(dto3.getIdCertificatore());
			pk3.setProgrCertificato(dto3.getProgrCertificato());
			pk3.setAnno(dto3.getAnno());
			try {
				this.getSiceeTDatiXml2015Dao().delete(pk1);
				this.getSiceeTDatiXmlEdReale2015Dao().delete(pk2);
				this.getSiceeTDatiXmlEdRif2015Dao().delete(pk3);
			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
*/
/*
		public void updateDatiXmlAll(SiceeTDatiXml2015 dto1, SiceeTDatiXmlEdReale2015 dto2, SiceeTDatiXmlEdRif2015 dto3) throws BEException {
			SiceeTDatiXml2015Pk pk1 = new SiceeTDatiXml2015Pk();
			pk1.setIdCertificatore(dto1.getIdCertificatore());
			pk1.setProgrCertificato(dto1.getProgrCertificato());
			pk1.setAnno(dto1.getAnno());
			SiceeTDatiXmlEdReale2015Pk pk2 = new SiceeTDatiXmlEdReale2015Pk();
			pk2.setIdCertificatore(dto2.getIdCertificatore());
			pk2.setProgrCertificato(dto2.getProgrCertificato());
			pk2.setAnno(dto2.getAnno());
			SiceeTDatiXmlEdRif2015Pk pk3 = new SiceeTDatiXmlEdRif2015Pk();
			pk3.setIdCertificatore(dto3.getIdCertificatore());
			pk3.setProgrCertificato(dto3.getProgrCertificato());
			pk3.setAnno(dto3.getAnno());
			try {
				this.getSiceeTDatiXml2015Dao().delete(pk1);
				this.getSiceeTDatiXml2015Dao().insert(dto1);
				this.getSiceeTDatiXmlEdReale2015Dao().delete(pk2);
				this.getSiceeTDatiXmlEdReale2015Dao().insert(dto2);
				this.getSiceeTDatiXmlEdRif2015Dao().delete(pk3);
				this.getSiceeTDatiXmlEdRif2015Dao().insert(dto3);
			} catch (Exception e) {
				throw new BEException(e.getMessage(), e);
			}
		}
*/
	/**
	 * Calcola numero progressivo.
	 *
	 * @param num the num
	 * @return the string
	 */
	private String calcolaNumeroProgressivo(int num) {
		String str = this.convertToString(num);
		String prog = "0000".substring(0, 4 - str.length()) + str;

		return prog;
	}

	/**
	 * Map to db.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @param prog the prog
	 * @param idTransazione the id transazione
	 * @return the sicee t certificato
	 * @throws BEException the bE exception
	 */
	private SiceeTCertificato mapToDB(DatiCertificatore cert,
			SiceeWCertificatore prog, Long idTransazione) throws BEException {
		SiceeTCertificato dto = new SiceeTCertificato();
		dto.setIdCertificatore(cert.getIdCertificatore());
		dto.setProgrCertificato(this.calcolaNumeroProgressivo(prog
				.getProgrCertificato()));
		dto.setAnno(prog.getAnno());
		dto.setFkTransazioneAce(idTransazione);

		// Modificata la formattazione data, per capire il problema della moltiplicazione dell'inserimento dei certificati - salvo anche ora, minuti e secondi
		dto.setDtAcquisto(DateUtil.convertToDateCompleta(DateUtil
		.convertToStringDataCompleta(new java.util.Date())));
		
		
		//dto.setDtAcquisto(DateUtil.convertToDate(dp.getDataValuta()));
		dto.setFlgOld(Constants.NO);
		dto.setFkStato(new Integer("0"));
		return dto;
	}

	/**
	 * Map to db.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @param prog the prog
	 * @param idTransazione the id transazione
	 * @return the sicee t certificato
	 * @throws BEException the bE exception
	 */
	private SiceeTCertificato mapToDBNew(SiceeWCertificatore prog, Date dataInserimento) throws BEException
	{
		SiceeTCertificato dto = new SiceeTCertificato();
		
		dto.setIdCertificatore(convertToString(prog.getIdCertificatore()));
		
		dto.setProgrCertificato(this.calcolaNumeroProgressivo(prog
				.getProgrCertificato()));
	
		dto.setAnno(prog.getAnno());
		
		dto.setFkTransazioneAce(Constants.ID_TRANSAZIONE_ACE_FITTIZIA);

		// Modificata la formattazione data, per capire il problema della moltiplicazione dell'inserimento dei certificati - salvo anche ora, minuti e secondi
		dto.setDtAcquisto(dataInserimento);
		
		
		//dto.setDtAcquisto(DateUtil.convertToDate(dp.getDataValuta()));
		dto.setFlgOld(Constants.NO);
		dto.setFkStato(new Integer("0"));
		return dto;
	}
	
	private SiceeTCredito2018 mapToDBCredito2018(SiceeTCertificato cert, Date dataInserimento, Double prezzoApe, Double creditoIniziale, Double creditoFinale) throws BEException
	{
		SiceeTCredito2018 dto = new SiceeTCredito2018();
		
		dto.setFkCertificatore(cert.getIdCertificatore());
		
		dto.setFkTipoOp2018(Constants.ID_TIPO_OP_GENERA_APE);
		
		dto.setValoreCreditoIniziale(creditoIniziale);
		
		dto.setValoreCreditoFinale(creditoFinale);
		
		dto.setDataOperazione(dataInserimento);
		
		dto.setValoreOperazione(prezzoApe);
		
		dto.setFkCertificatoreCertificato(cert.getIdCertificatore());
		
		dto.setProgrCertificato(cert.getProgrCertificato());
		
		dto.setAnno(cert.getAnno());
		
		return dto;
	}
	
	/**
	 * Gets the certificati.
	 *
	 * @param cert the cert
	 * @return the certificati
	 * @throws BEException the bE exception
	 */
	public List<AttestatoSummary> getCertificati(DatiCertificatore cert)
			throws BEException {
		ArrayList<AttestatoSummary> attestati = null;
		try {
			List<OptimizedSiceeTCerticato> list = this
					.getOptimizedSiceeTCerticatoDao().execute(
							cert.getIdCertificatore());
			Iterator<OptimizedSiceeTCerticato> iter = list.iterator();
			attestati = new ArrayList<AttestatoSummary>();
			Integer numAtt = new Integer(0);
			
			int i = 1;
			while (iter.hasNext()) {
				OptimizedSiceeTCerticato c = iter.next();
				AttestatoSummary as = new AttestatoSummary();
				
				as.setIdRigaTabella(i++);
				
				String numero = c.getAnno() + " " + cert.getNumCertificatore()
						+ " " + c.getProgrCertificato();
				as.setCod(numero);
				as.setDescr("Certificato n.: " + numero);
				String ind = "";
				if (c.getFkStato() != null && c.getFkStato() != 0) {
					if (c.getNumCivico() == null) {
						ind = this.getMiscMgr().convertToStringForReport(
								c.getDescIndirizzo());
						if (c.getDescIndirizzo() != null
								&& c.getDescComune() != null) {
							ind = ind + " - ";
						}
						ind = ind
								+ this.getMiscMgr().convertToStringForReport(
										c.getDescComune());
					} else {
						ind = this.getMiscMgr().convertToStringForReport(
								c.getDescIndirizzo());
						if (c.getDescIndirizzo() != null) {
							ind = ind + ",";
						}
						ind = ind + c.getNumCivico();
						if (c.getDescComune() != null) {
							ind = ind + " - " + c.getDescComune();
						}
					}
					as.setDataInizio((DateUtil.convertToString(c.getDtUpload()) == null) ? ""
							: DateUtil.convertToString(c.getDtUpload()));
					as.setDataUltimaCompilazione((DateUtil.convertToStringRevert(c.getDtInizio()) == null) ? ""
							: DateUtil.convertToStringRevert(c.getDtInizio()));
				} else {
					numAtt++;
				}
				as.setIndirizzo(ind);
				// SiceeDStatoCert obj =
				// getSiceeDStatoCertDao().findByPrimaryKey(c.getFkStato());
				as.setStato((c.getDescStato() == null) ? "" : c.getDescStato());
				/*
				 * if (c.getFkStato() != null && c.getFkStato() == 3) {
				 * as.setFlgScarico("ModuloACE"); as.setFlgRicevuta("Ricevuta");
				 * }
				 */
				// //Segnalazione SICEE-130:Nell'elenco di compilazione ace non
				// devono essere visibili gli ace in stato INVIATO
				if (c.getFkStato() != null
						&& c.getFkStato() != Constants.INVIATO) {
					attestati.add(as);
				}
			}

			cert.setNumeroAceDisp(numAtt);

		} catch (OptimizedSiceeTCerticatoDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}
		return attestati;
	}

	/**
	 * Gets the certificati.
	 *
	 * @param filtro the filtro
	 * @param idCerificatore the id cerificatore
	 * @return the certificati
	 * @throws BEException the bE exception
	 */
	/*
	public List<Ace> getCertificati(FiltroRicercaAce filtro,
			String idCerificatore) throws BEException {
		ArrayList<Ace> attestati = null;
		try {
			SiceeTParametri param = this.getSiceeTParametriDao()
					.findWhereCodiceEquals(
							Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param,
					Constants.NUMERO_MINIMO_ID_CERTIFICATORE)) {

				List<OptimizedSiceeTCerticato> list = this
						.getOptimizedSiceeTCerticatoDao().executeByParametri(
								idCerificatore, filtro,
								new Long(param.getValore()), null);
				Iterator<OptimizedSiceeTCerticato> iter = list.iterator();
				attestati = new ArrayList<Ace>();
				Integer numAtt = new Integer(0);
				while (iter.hasNext()) {
					OptimizedSiceeTCerticato c = iter.next();

					Ace ace = new Ace();
					String numero = c.getAnno() + " " + c.getNumCertificatore()
							+ " " + c.getProgrCertificato();
					ace.setCodice(numero);

					String ind = "";
					if (c.getFkStato() != null
							&& c.getFkStato() != Constants.NUOVO) {
						if (c.getNumCivico() == null) {
							ind = c.getDescIndirizzo() + " - "
									+ c.getDescComune();
						} else {
							ind = c.getDescIndirizzo() + ", "
									+ c.getNumCivico() + " - "
									+ c.getDescComune();
						}
						ace.setDataInvio((DateUtil.convertToString(c
								.getDtInizio()) == null) ? "" : DateUtil
								.convertToString(c.getDtInizio()));
					} else {
						numAtt++;
					}
					ace.setDescIndirizzo(ind);
					// SiceeDStatoCert obj =
					// getSiceeDStatoCertDao().findByPrimaryKey(c.getFkStato());
					ace.setStato((c.getDescStato() == null) ? "" : c
							.getDescStato());
					ace.setFlgInviato("Modulo A.P.E.");
					ace.setLinkDownload(ace.getFlgInviato());
					if (!GenericUtil.isNullOrEmpty(c.getFkStato())
							&& c.getFkStato() == Constants.INVIATO) {
						ace.setFlgRicevuta("Ricevuta");
					}
					attestati.add(ace);
				}
			}
			// cert.setNumeroAceDisp(numAtt);

		} catch (SiceeTParametriDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} catch (OptimizedSiceeTCerticatoDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return attestati;
	}
	*/
	

	/**
	 * Gets the numero max ace annulla sost.
	 *
	 * @return the numero max ace annulla sost
	 * @throws BEException the bE exception
	 */
	public Integer getNumeroMaxAceAnnullaSost() throws BEException {
		try {
			SiceeTParametri param = this.getSiceeTParametriDao()
					.findWhereCodiceEquals(
							Constants.NUMERO_MAX_ACE_SOSTITUZIONE);
			if (GenericUtil.verifyParam(param,
					Constants.NUMERO_MAX_ACE_SOSTITUZIONE)) {
				return Integer.valueOf(param.getValore());
			} else {
				return null;
			}
		} catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "
					+ Constants.NUMERO_MAX_ACE_SOSTITUZIONE, e);
		}
	}

	/**
	 * Gets the anno minimo costruzione.
	 *
	 * @return the anno minimo costruzione
	 * @throws BEException the bE exception
	 */
	public Integer getAnnoMinimoCostruzione() throws BEException {
		try {
			SiceeTParametri param = this.getSiceeTParametriDao()
					.findWhereCodiceEquals(Constants.ANNO_MIN_COSTRUZIONE);
			if (GenericUtil.verifyParam(param, Constants.ANNO_MIN_COSTRUZIONE)) {
				return Integer.valueOf(param.getValore());
			} else {
				return null;
			}
		} catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "
					+ Constants.ANNO_MIN_COSTRUZIONE, e);
		}
	}

	/**
	 * Gets the certificati duplicazione sost by parametri.
	 *
	 * @param filtro the filtro
	 * @param idCerificatore the id cerificatore
	 * @param idStato the id stato
	 * @param flgPregresso the flg pregresso
	 * @return the certificati annulla sost by parametri
	 * @throws BEException the bE exception
	 */
	
	public List<Ace> getCertificatiPerDuplicazione(String idCerificatore) throws BEException {
		List<Ace> attestati = new ArrayList<Ace>();
		try {
			
			List<OptimizedSiceeTCerticato> list = this
					.getOptimizedSiceeTCerticatoDao()
					.executePerDuplicazione(idCerificatore);
			
			attestati = this.mapToModelFromDB(list);
				
				
			
		} catch (OptimizedSiceeTCerticatoDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);

		} 
		
		return attestati;
	}
	
	
	/**
	 * Gets the certificati annulla sost by parametri count.
	 *
	 * @param filtro the filtro
	 * @param idCerificatore the id cerificatore
	 * @param idStato the id stato
	 * @param flgPregresso the flg pregresso
	 * @return the certificati annulla sost by parametri count
	 * @throws BEException the bE exception
	 */
	/*
	public Integer getCertificatiAnnullaSostByParametriCount(
			FiltroRicercaAce filtro, String idCerificatore, Integer idStato,
			boolean flgPregresso) throws BEException {
		Integer count = null;
		try {
			SiceeTParametri param = this.getSiceeTParametriDao()
					.findWhereCodiceEquals(
							Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param,
					Constants.NUMERO_MINIMO_ID_CERTIFICATORE)) {
				filtro.setStato(idStato);

				String dataPregresso = null;
				if (flgPregresso) {
					SiceeTParametri paramDatapregresso = this
							.getSiceeTParametriDao().findWhereCodiceEquals(
									Constants.DATA_INIZIO_SOSTITUZIONE);
					if (GenericUtil.verifyParam(paramDatapregresso,
							Constants.DATA_INIZIO_SOSTITUZIONE)) {
						dataPregresso = paramDatapregresso.getValore();

					}
				}

				count = getSoaIntegrationMgr().findAceFiltroCount(filtro, idCerificatore, dataPregresso);
				
				
			}
		} catch (SiceeTParametriDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);

		} 
		
		return count;
	}
	*/
	
	/**
	 * Gets the certificati annulla sost by parametri.
	 *
	 * @param filtro the filtro
	 * @param idCerificatore the id cerificatore
	 * @param idStato the id stato
	 * @param flgPregresso the flg pregresso
	 * @return the certificati annulla sost by parametri
	 * @throws BEException the bE exception
	 */
	/*
	public List<Ace> getCertificatiAnnullaSostByParametri(
			FiltroRicercaAce filtro, String idCerificatore, Integer idStato,
			boolean flgPregresso) throws BEException {
		List<Ace> attestati = new ArrayList<Ace>();
		try {
			SiceeTParametri param = this.getSiceeTParametriDao()
					.findWhereCodiceEquals(
							Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param,
					Constants.NUMERO_MINIMO_ID_CERTIFICATORE)) {
				filtro.setStato(idStato);

				String dataPregresso = null;
				if (flgPregresso) {
					SiceeTParametri paramDatapregresso = this
							.getSiceeTParametriDao().findWhereCodiceEquals(
									Constants.DATA_INIZIO_SOSTITUZIONE);
					if (GenericUtil.verifyParam(paramDatapregresso,
							Constants.DATA_INIZIO_SOSTITUZIONE)) {
						dataPregresso = paramDatapregresso.getValore();

					}
				}

				attestati = getSoaIntegrationMgr().findAceFiltro(filtro, idCerificatore, dataPregresso, true);
				
				
//					List<OptimizedSiceeTCerticato> list = this
//							.getOptimizedSiceeTCerticatoDao()
//							.executeByParametriPerSostituzione(idCerificatore,
//									filtro, new Long(param.getValore()),
//									dataPregresso);
//								
//					attestati = this.mapToModelFromDB(list);
				
				
			}
		} catch (SiceeTParametriDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);

		} 
		
		return attestati;
	}
	*/

	/**
	 * Gets the certificati annulla sost by codice.
	 *
	 * @param filtro the filtro
	 * @param idStato the id stato
	 * @param flgPregresso the flg pregresso
	 * @return the certificati annulla sost by codice
	 * @throws BEException the bE exception
	 */
	/*
	public List<Ace> getCertificatiAnnullaSostByCodice(
			FiltroRicercaAce filtro, Integer idStato, boolean flgPregresso)
			throws BEException {
		ArrayList<Ace> attestati = new ArrayList<Ace>();
		try {
			SiceeTParametri param = this.getSiceeTParametriDao()
					.findWhereCodiceEquals(
							Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param,
					Constants.NUMERO_MINIMO_ID_CERTIFICATORE)) {
				
				String idCertificatore = this.getCertificatoreMgr()
						.getIdCertificatoreFromNumCertificatore(
								filtro.getCertificatore());

				String dataPregresso = null;
				if (flgPregresso) {
					SiceeTParametri paramDatapregresso = this
							.getSiceeTParametriDao().findWhereCodiceEquals(
									Constants.DATA_INIZIO_SOSTITUZIONE);
					if (GenericUtil.verifyParam(paramDatapregresso,
							Constants.DATA_INIZIO_SOSTITUZIONE)) {
						dataPregresso = paramDatapregresso.getValore();

					}
				}

				List<OptimizedSiceeTCerticato> list = this
						.getOptimizedSiceeTCerticatoDao().executeByCodice(
								filtro.getAnnoCertificato(), idCertificatore,
								filtro.getProgCertificato(), idStato,
								new Long(param.getValore()), dataPregresso);

				attestati = this.mapToModelFromDB(list);

			}
		} catch (SiceeTParametriDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} catch (OptimizedSiceeTCerticatoDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return attestati;
	}
	*/
	
	/**
	 * Map to model from db.
	 *
	 * @param list the list
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	private ArrayList<Ace> mapToModelFromDB(List<OptimizedSiceeTCerticato> list)
			throws BEException {

		ArrayList<Ace> attestati = null;

		Iterator<OptimizedSiceeTCerticato> iter = list.iterator();
		attestati = new ArrayList<Ace>();

		while (iter.hasNext()) {
			OptimizedSiceeTCerticato c = iter.next();

			Ace ace = new Ace();
			String numero = c.getAnno() + " " + c.getNumCertificatore() + " "
					+ c.getProgrCertificato();
			ace.setCodice(numero);

			String ind = "";
			if (c.getFkStato() != null && c.getFkStato() != 0) {
				if (c.getNumCivico() == null) {
					ind = c.getDescIndirizzo() + " - " + c.getDescComune();
				} else {
					ind = c.getDescIndirizzo() + ", " + c.getNumCivico()
							+ " - " + c.getDescComune();
				}
				ace.setDataInvio((DateUtil.convertToString(c.getDtInizio()) == null) ? ""
						: DateUtil.convertToString(c.getDtInizio()));
			}

			ace.setDescIndirizzo(ind);

			String datiCat = "Sez. " + StringUtils.trimToEmpty(c.getSezione())
					+ " F. " + StringUtils.trimToEmpty(c.getFoglio()) + " N. "
					+ StringUtils.trimToEmpty(c.getParticella()) + " Sub. "
					+ StringUtils.trimToEmpty(c.getSubalterno());

			ace.setDescDatiCat(datiCat);

			// SiceeDStatoCert obj =
			// getSiceeDStatoCertDao().findByPrimaryKey(c.getFkStato());
			ace.setStato((c.getDescStato() == null) ? "" : c.getDescStato());
			if (c.getFkStato() != null
					&& (c.getFkStato() == Constants.INVIATO || c.getFkStato() == Constants.DA_INVIARE)) {
				ace.setFlgInviato("Modulo A.P.E.");
				ace.setLinkDownload(ace.getFlgInviato());
				ace.setFlgRicevuta("Ricevuta");
			}
			attestati.add(ace);
		}

		return attestati;
	}

	/**
	 * Gets the certificati transazione.
	 *
	 * @param idTrans the id trans
	 * @param cert the cert
	 * @return the certificati transazione
	 * @throws BEException the bE exception
	 */
	public List<AttestatoSummary> getCertificatiTransazione(Long idTrans,
			DatiCertificatore cert) throws BEException {
		ArrayList<AttestatoSummary> attestati = null;
		try {
			List<SiceeTCertificato> list = this.getSiceeTCertificatoDao()
					.findBySiceeTTransazioneAce(idTrans);
			Iterator<SiceeTCertificato> iter = list.iterator();
			attestati = new ArrayList<AttestatoSummary>();
			while (iter.hasNext()) {
				SiceeTCertificato c = iter.next();
				AttestatoSummary as = new AttestatoSummary();
				String numero = c.getAnno() + " " + cert.getNumCertificatore()
						+ " " + c.getProgrCertificato();
				as.setCod(numero);
				as.setDescr("Certificato n.: " + numero);
				attestati.add(as);
			}

		} catch (SiceeTCertificatoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return attestati;
	}

	/**
	 * Aggiorna attestato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void aggiornaAttestato(DatiCertificatore cert, DatiAttestato att)
			throws BEException {

		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if (att.getStatus() != null && att.getStatus() > Constants.BOZZA) {
			return;
		}
		*/
		if ((att.getStatus() != null) && 
				((att.getStatus() == Constants.CONSOLIDATO)
						|| (att.getStatus() == Constants.INVIATO) 
						|| (att.getStatus() == Constants.ANNULLATO)
						|| (att.getStatus() == Constants.DA_INVIARE)
						|| (att.getStatus() == Constants.SOSPESO)
						|| (att.getStatus() == Constants.CANCELLATO)
						|| (att.getStatus() == Constants.ANNULLATO_BO))) {
			return;
		}

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		try {

			SiceeTCertificatoPk pk = new SiceeTCertificatoPk(id, prog, anno);
			SiceeTCertificato c = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(pk);
			this.getSiceeTCertificatoDao().update(pk,
					this.mapToDBCertificatoOld(c, att));

			SiceeTRuoliEdificioPk pkProg = new SiceeTRuoliEdificioPk(id, prog,
					anno, Constants.PROGETTISTA);
			this.getSiceeTRuoliEdificioDao().update(pkProg,
					this.mapToDBRuoliEdificio(pkProg, att));

			SiceeTRuoliEdificioPk pkDirLav = new SiceeTRuoliEdificioPk(id,
					prog, anno, Constants.DIRETTORE_LAVORI);
			this.getSiceeTRuoliEdificioDao().update(pkDirLav,
					this.mapToDBRuoliEdificio(pkDirLav, att));

			SiceeTRuoliEdificioPk pkCostr = new SiceeTRuoliEdificioPk(id, prog,
					anno, Constants.COSTRUTTORE);
			this.getSiceeTRuoliEdificioDao().update(pkCostr,
					this.mapToDBRuoliEdificio(pkCostr, att));

			SiceeTClasseEnergeticaPk pk0 = new SiceeTClasseEnergeticaPk(id,
					prog, anno);
			this.getSiceeTClasseEnergeticaDao().update(pk0,
					this.mapToDBClasseEnergetica(pk0, att));

			SiceeTConsumiEdificioPk pk1 = new SiceeTConsumiEdificioPk(id, prog,
					anno);
			this.getSiceeTConsumiEdificioDao().update(pk1,
					this.mapToDBConsumiEdificio(pk1, att));

			SiceeTDatiGeneraliPk pk2 = new SiceeTDatiGeneraliPk(id, prog, anno);
			this.getSiceeTDatiGeneraliDao().update(pk2,
					this.mapToDBDatiGenerali(pk2, att));

			SiceeTEnergiaSoprIngrPk pk3 = new SiceeTEnergiaSoprIngrPk(id, prog,
					anno);
			this.getSiceeTEnergiaSoprIngrDao().update(pk3,
					this.mapToDBEnergiaSoprIngr(pk3, att));

			SiceeTFabbisognoPk pk4 = new SiceeTFabbisognoPk(id, prog, anno);
			this.getSiceeTFabbisognoDao().update(pk4,
					this.mapToDBFabbisogno(pk4, att));

			SiceeTImpRiscaldamentoAcsPk pk5 = new SiceeTImpRiscaldamentoAcsPk(
					id, prog, anno);
			this.getSiceeTImpRiscaldamentoAcsDao().update(pk5,
					this.mapToDBImpRiscaldamentoAcs(pk5, att));

			SiceeTRispettoNormativePk pk7 = new SiceeTRispettoNormativePk(id,
					prog, anno);
			this.getSiceeTRispettoNormativeDao().update(pk7,
					this.mapToDBRispettoNormative(pk7, att));

			SiceeTAltreInfoPk pk8 = new SiceeTAltreInfoPk(id, prog, anno);
			this.getSiceeTAltreInfoDao().update(pk8,
					this.mapToDBAltreInfo(pk8, att));

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Aggiorna attestato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void aggiornaDatiGenerali(DatiCertificatore cert, DatiAttestato att, String descIndTope)
			throws BEException {

		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if (att.getStatus() != null && att.getStatus() > Constants.BOZZA) {
			return;
		}
		*/
		if ((att.getStatus() != null) && 
				((att.getStatus() == Constants.CONSOLIDATO)
						|| (att.getStatus() == Constants.INVIATO) 
						|| (att.getStatus() == Constants.ANNULLATO)
						|| (att.getStatus() == Constants.DA_INVIARE)
						|| (att.getStatus() == Constants.SOSPESO)
						|| (att.getStatus() == Constants.CANCELLATO)
						|| (att.getStatus() == Constants.ANNULLATO_BO))) {
			return;
		}

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		try {

			SiceeTCertificatoPk pk = new SiceeTCertificatoPk(id, prog, anno);
			SiceeTCertificato c = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(pk);
			
			this.getSiceeTCertificatoDao().update(pk,
					this.mapToDBCertificato(c, att, descIndTope));

			SiceeTDatiGeneraliPk pk2 = new SiceeTDatiGeneraliPk(id, prog, anno);

			SiceeTDatiGenerali obj2 = this.getSiceeTDatiGeneraliDao()
					.findByPrimaryKey(pk2);
			
			log.debug("STAMPO SiceeTDatiGenerali DEL DB !!!!!");
			
			if (log.isDebugEnabled())
				GenericUtil.stampa(obj2, true, 3);
			
			if (obj2 == null) {
				obj2 = new SiceeTDatiGenerali();
				obj2.setIdCertificatore(id);
				obj2.setProgrCertificato(prog);
				obj2.setAnno(anno);
				this.getSiceeTDatiGeneraliDao().insert(obj2);
			}
			
			this.getSiceeTDatiGeneraliDao().update(pk2,
					this.mapToDBDatiGeneraliNew(obj2, att));

			SiceeTAltreInfoPk pk8 = new SiceeTAltreInfoPk(id, prog, anno);

			SiceeTAltreInfo obj8 = this.getSiceeTAltreInfoDao()
					.findByPrimaryKey(pk8);
			if (obj8 == null) {
				obj8 = new SiceeTAltreInfo();
				obj8.setIdCertificatore(id);
				obj8.setProgrCertificato(prog);
				obj8.setAnno(anno);
				this.getSiceeTAltreInfoDao().insert(obj8);
			}

			this.getSiceeTAltreInfoDao().update(pk8,
					this.mapToDBAltreInfoNew(obj8, att));

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Aggiorna foto.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @throws BEException the bE exception
	 */
	@Transactional
	public Long aggiornaDatiGeneraliFoto(DatiCertificatore cert, DatiAttestato att)
			throws BEException {

		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if (att.getStatus() != null && att.getStatus() > Constants.BOZZA) {
			return;
		}
		*/
		if ((att.getStatus() != null) && 
				((att.getStatus() == Constants.CONSOLIDATO)
						|| (att.getStatus() == Constants.INVIATO) 
						|| (att.getStatus() == Constants.ANNULLATO)
						|| (att.getStatus() == Constants.DA_INVIARE)
						|| (att.getStatus() == Constants.SOSPESO)
						|| (att.getStatus() == Constants.CANCELLATO)
						|| (att.getStatus() == Constants.ANNULLATO_BO))) {
			return null;
		}

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		try {
			
			SiceeTFoto2015 foto2015 = new SiceeTFoto2015();
			foto2015.setIdCertificatore(id);
			foto2015.setProgrCertificato(prog);
			foto2015.setAnno(anno);
			foto2015.setFkTipoFoto(new Long(1));
			foto2015.setFlgPrincipale("S");
			foto2015.setIdentificFoto(att.getDatiAnagraficiImm()
					.getDtCatastali().getUidFoto());
			foto2015.setNomeFoto(att.getDatiAnagraficiImm()
				.getDtCatastali().getNomeFoto());
			foto2015.setDtFoto(DateUtil.convertToDateCompleta(att.getDatiAnagraficiImm()
					.getDtCatastali().getDataUpFoto()));
			
			
			log.debug("Stampo l'id della foto: "+att.getDatiAnagraficiImm()
					.getDtCatastali().getIdFoto());
			
			// Devo capire se è un inserimento o una modifica
			if (BaseMgr.isNullOrEmpty(att.getDatiAnagraficiImm()
					.getDtCatastali().getIdFoto()))
			{
				// E' un inserimento
				
				log.debug("INSERISCO la foto");
				SiceeTFoto2015Pk fotoPk = this.getSiceeTFoto2015Dao().insert(foto2015);

				foto2015.setIdFoto(fotoPk.getIdFoto());
				
				// Setto l'id nel modello
				att.getDatiAnagraficiImm()
						.getDtCatastali().setIdFoto(foto2015.getIdFoto());

				// Setto la preview nel modello
				att.getDatiAnagraficiImm().getDtCatastali().setPreviewBase64(this.recuperaPreviewFotoByUid(foto2015.getIdentificFoto()));

				// Setto la descrizione del tipo della foto
				att.getDatiAnagraficiImm().getDtCatastali().setDescTipoFoto(this.recuperaTipoFoto2015(foto2015.getFkTipoFoto()).getDescr());
			}
			else
			{
				log.debug("MODIFICO la foto");

				// E' una modifica
				foto2015.setIdFoto(att.getDatiAnagraficiImm()
					.getDtCatastali().getIdFoto());
				
				this.getSiceeTFoto2015Dao().update(new SiceeTFoto2015Pk(foto2015.getIdFoto()), foto2015);

				// Setto la preview nel modello
				att.getDatiAnagraficiImm().getDtCatastali().setPreviewBase64(this.recuperaPreviewFotoByUid(foto2015.getIdentificFoto()));

				// Setto la descrizione del tipo della foto
				att.getDatiAnagraficiImm().getDtCatastali().setDescTipoFoto(this.recuperaTipoFoto2015(foto2015.getFkTipoFoto()).getDescr());
			}
			
			return foto2015.getIdFoto();

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			throw new BEException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public Long aggiornaDatiGeneraliFotoAltre(DatiCertificatore cert, DatiAttestato att)
			throws BEException {

		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if (att.getStatus() != null && att.getStatus() > Constants.BOZZA) {
			return;
		}
		*/
		if ((att.getStatus() != null) && 
				((att.getStatus() == Constants.CONSOLIDATO)
						|| (att.getStatus() == Constants.INVIATO) 
						|| (att.getStatus() == Constants.ANNULLATO)
						|| (att.getStatus() == Constants.DA_INVIARE)
						|| (att.getStatus() == Constants.SOSPESO)
						|| (att.getStatus() == Constants.CANCELLATO)
						|| (att.getStatus() == Constants.ANNULLATO_BO))) {
			return null;
		}

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		try {			
			SiceeTFoto2015 foto2015 = new SiceeTFoto2015();
			ArrayList<DtFoto> dtFotoListBuild = new ArrayList<DtFoto>();
			ArrayList<DtFoto> dtFotoList = att.getDatiAnagraficiImm().getDtCatastali().getDtFoto();
			for (DtFoto dtFoto : dtFotoList) {
				// Dell'ArrayList delle foto secondarie prendo solo quella (unica) con id < 0, cioè che non è stata ancora inserita
				if (dtFoto.getIdFoto() < 0) {			
					foto2015.setIdCertificatore(id);
					foto2015.setProgrCertificato(prog);
					foto2015.setAnno(anno);
					foto2015.setFkTipoFoto(dtFoto.getFkTipoFoto());
					foto2015.setFlgPrincipale("N");
					foto2015.setIdentificFoto(dtFoto.getUidFoto());
					foto2015.setNomeFoto(dtFoto.getNomeFoto());
					foto2015.setDtFoto(DateUtil.convertToDateCompleta(dtFoto.getDataUpFoto()));					

					// E' sempre un inserimento
					log.debug("INSERISCO la foto");
					SiceeTFoto2015Pk fotoPk = this.getSiceeTFoto2015Dao().insert(foto2015);

					foto2015.setIdFoto(fotoPk.getIdFoto());
					
					// Setto l'id per l'inserimento successivo nel modello
					dtFoto.setIdFoto(foto2015.getIdFoto());
					// Setto la preview per l'inserimento successivo nel modello
					dtFoto.setPreviewBase64(this.recuperaPreviewFotoByUid(foto2015.getIdentificFoto()));
					// Setto la descrizione del tipo della foto
					dtFoto.setDescTipoFoto(this.recuperaTipoFoto2015(foto2015.getFkTipoFoto()).getDescr());
				}
				dtFotoListBuild.add(dtFoto);
			}
			// Setto l'id nel modello
			att.getDatiAnagraficiImm().getDtCatastali().setDtFoto(dtFotoListBuild);
					
			return foto2015.getIdFoto();

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Map to db export bo.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t export bo
	 * @throws BEException the bE exception
	 */
	private SiceeTExportBo mapToDBExportBo(SiceeTExportBoPk pk, SiceeTCertificato siceeTCertificato,
			SiceeTDatiGenerali siceeTDatiGenerali, SiceeTDatiEner2015 siceeTDatiEner2015, SiceeTAltreInfo siceeTAltreInfo) throws BEException {
		
		SiceeTExportBo obj = new SiceeTExportBo();

		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		
		obj.setFkStato(siceeTCertificato.getFkStato());
		obj.setFlgOld(siceeTCertificato.getFlgOld());

		if (siceeTCertificato != null)
		{
			obj.setDescProv(siceeTCertificato.getDescProv());

			obj.setIdProv(siceeTCertificato.getIdProv());

			obj.setDescComune(siceeTCertificato.getDescComune());

			obj.setIdComune(siceeTCertificato.getIdComune());

			obj.setDescIndirizzo(siceeTCertificato.getDescIndirizzo());

			obj.setNumCivico(siceeTCertificato.getNumCivico());

			obj.setSezione(siceeTCertificato.getSezione());
			obj.setFoglio(siceeTCertificato.getFoglio());
			obj.setParticella(siceeTCertificato.getParticella());
			obj.setSubalterno(siceeTCertificato.getSubalterno());

			obj.setDtInizio(siceeTCertificato.getDtInizio());
			obj.setDtUpload(siceeTCertificato.getDtUpload());
			obj.setDtScadenza(siceeTCertificato.getDtScadenza());
		}
		

		if (siceeTDatiGenerali != null)
		{
			
			obj.setFkDestUso(siceeTDatiGenerali.getFkDestUso2015());

			obj.setAnnoCostruzione(siceeTDatiGenerali
				.getAnnoCostruzione());
			obj.setAnnoUltRist(siceeTDatiGenerali
				.getAnnoUltRist());
			
			obj.setSupRaffrescata(siceeTDatiGenerali.getSupRaffrescata());
			obj.setSupRiscaldata(siceeTDatiGenerali.getSupRiscaldata());
			obj.setVolLordoRaffrescato(siceeTDatiGenerali.getVolLordoRaffrescato());
			obj.setVolLordoRiscaldato(siceeTDatiGenerali.getVolLordoRiscaldato());
			
			
			if (log.isDebugEnabled())
				GenericUtil.stampa(siceeTDatiGenerali, true, 4);
			
			obj.setVSuRaff(GenericUtil.effettuaDivisione(siceeTDatiGenerali.getVolLordoRaffrescato(), siceeTDatiGenerali.getSupRaffrescata()));
			obj.setVSuRisc(GenericUtil.effettuaDivisione(siceeTDatiGenerali.getVolLordoRiscaldato(), siceeTDatiGenerali.getSupRiscaldata()));
			obj.setSVRaff(GenericUtil.effettuaDivisione(siceeTDatiGenerali.getSupRaffrescata(), siceeTDatiGenerali.getVolLordoRaffrescato()));
			obj.setSVRisc(GenericUtil.effettuaDivisione(siceeTDatiGenerali.getSupRiscaldata(), siceeTDatiGenerali.getVolLordoRiscaldato()));

		}

		
		
		
		if (siceeTDatiEner2015 != null)
		{
			obj.setFkClasse(siceeTDatiEner2015.getFkClasseEnergetica());
			
			obj.setFlgEdifE0(siceeTDatiEner2015.getFlgEdifE0());

			obj.setEpglNrenGlobale(siceeTDatiEner2015.getEpglNrenGlobale());
			obj.setEpglRenGlobale(siceeTDatiEner2015.getEpglRenGlobale());

			obj.setEmissioniCo2(siceeTDatiEner2015.getEmissioniCo2());

			obj.setEph(siceeTDatiEner2015.getEph());
			obj.setAsolAsup(siceeTDatiEner2015.getAsolAsup());
			obj.setYie(siceeTDatiEner2015.getYie());


			
		}

		if (siceeTAltreInfo != null)
		{
			obj.setFkMotivo(siceeTAltreInfo.getFkMotivo());
		}
		
		if (log.isDebugEnabled())
			GenericUtil.stampa(obj, true, 4);

		return obj;
	}

	/*
	private SiceeTExportBo mapToDBExportBoOld(SiceeTExportBoPk pk,
			DatiAttestato att) throws BEException {
		SiceeTExportBo obj = new SiceeTExportBo();

		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtTecniciGen dt = att.getDatiTecnici();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
		DtDichiarazFinale df = att.getDichiarazioni();
		DtAltreInfo ai = att.getAltreInfo();
		DtClasseEnerg ce = att.getClasseEnerg();
		DtIndiciFabbisogno in = att.getIndFabbisogno();
		DtImpianti im = att.getImpianti();

		// att.get

		if (df != null)
		{
			obj.setDtInizio(DateUtil.convertToDate(df.getDataDichiarazione()));
			
		}
		// data upload

		if (cat != null)
		{
			obj.setDescProv(cat.getDescrProv());

			obj.setIdProv(cat.getCodProv());

			obj.setDescComune(cat.getDescrComune());

			obj.setIdComune(cat.getCodComune());

			obj.setDescIndirizzo(cat.getDescrIndirizzo());

			obj.setNumCivico(cat.getNumCiv());

			obj.setSezione(cat.getSezione());
			obj.setFoglio(cat.getFoglio());
			obj.setParticella(cat.getParticella());
			obj.setSubalterno(cat.getSubalterno());

			obj.setPiano((cat.getPiano()));
			obj.setNumPianiComplessivi(this.convertTo(cat.getPianiTot()));

			obj.setGradiGiorno(this.convertTo(cat.getGradiGiorno()));
			
			obj.setNumAppartamenti(this.convertTo(cat.getNumUnita()));

		}
		

		obj.setFkStato(att.getStatus());

		if (dt != null)
		{
			obj.setFkDestUso(BaseMgr.convertToInteger(dt.getDestUso()));
			obj.setDescTipoEdificio(dt.getDescrizioneEdificio());

			obj.setFkCarattEdificio(BaseMgr.convertToInteger(dt.getTipoEdificio()));
			
			obj.setAnnoCostruzione(BaseMgr.convertToInteger(dt.getAnnoCostr()));
			obj.setAnnoUltRist(BaseMgr.convertToInteger(dt.getAnnoUltimaRistrutt()));

			obj.setVolLordoRiscaldato(BaseMgr.convertTo(dt.getVolLordoRiscald()));

			obj.setSupDisperdenteTot(BaseMgr.convertTo(dt.getSupDispTot()));
			obj.setSu(BaseMgr.convertTo(dt.getSuperficieUtile()));

			obj.setFattoreForma(BaseMgr.convertTo(dt.getFattoreForma()));
			obj.setTrasmOpache(BaseMgr.convertTo(dt.getTrasmittanzaOpache()));
			obj.setTrasmTrasp(BaseMgr.convertTo(dt.getTrasmittanzaTrasp()));
			
			obj.setFkTipoImpianto(BaseMgr.convertToInteger(dt.getTipoImpianto()));

			
		}
		
		if (ce != null)
		{
			obj.setFkClasse(BaseMgr.convertToInteger(ce.getLocTeorica()
					.getClasseEnerg()));
			
			obj.setDomRiscQhto(BaseMgr.convertTo(ce.getLocTeorica()
					.getDomEnergRiscald()));

			obj.setIndRiscEpi(BaseMgr.convertTo(ce.getLocReale()
					.getIndPrestEnergRiscald()));
			obj.setIndRiscEpito(BaseMgr.convertTo(ce.getLocTeorica()
					.getIndPrestEnergRiscald()));

			obj.setRendImpEtag(BaseMgr.convertTo(ce.getLocReale()
					.getRendGlobTermico()));

			obj.setIndGlobEplordo(BaseMgr.convertTo(ce.getLocReale()
					.getIndPrestEnergGlob()));
			obj.setIndGlobEplordoTo(BaseMgr.convertTo(ce.getLocTeorica()
					.getIndPrestEnergGlob()));

			obj.setDomAcsQhwto(BaseMgr.convertTo(ce.getLocTeorica()
					.getDomEnergAcqua()));
			
			obj.setRendGener(BaseMgr.convertTo(ce.getLocReale().getRendGeneraz()));
			obj.setRendRegol(BaseMgr.convertTo(ce.getLocReale().getRendRegolaz()));
			obj.setRendEmiss(BaseMgr.convertTo(ce.getLocReale().getRendEmissione()));
			obj.setRendDistrib(BaseMgr.convertTo(ce.getLocReale().getRendDistrib()));

		}
		
		

		if (obj.getVolLordoRiscaldato() != null && obj.getSu() != null) {
			// DA APPROSSIMARE + 4 DECIMALI
			obj.setVSu(obj.getVolLordoRiscaldato() / obj.getSu());
		}

		
		if (im != null)
		{
			obj.setFkCombustibileRisc(BaseMgr.convertToInteger(im
					.getRiscaldamento().getCombustibileFossile()));
			obj.setFkCombustibileAcs(BaseMgr.convertToInteger(im.getAcqua()
					.getCombustibileFossile()));
			
			obj.setUiServite(im.getUiServite());
			obj.setPotRiscaldamento(BaseMgr.convertTo(im.getRiscaldamento()
					.getPotNomCompl()));
			obj.setFkClasseEffRisc(BaseMgr.convertToInteger(im.getRiscaldamento()
					.getClasseEfficienzaEnerg()));
			obj.setGenAnnoRisc(BaseMgr.convertToInteger(im.getRiscaldamento()
					.getAnnoInstallGeneratore()));
			obj.setFlgContRip(im.getFlgRipartizione());
		}
		
		

		if (in != null)
		{
			obj.setDomRiscQh(BaseMgr.convertTo(in.getDomEnergRiscald()));
			
			obj.setFabbAcs(BaseMgr.convertTo(in.getIndPrestEnergAcqua()));

			obj.setFlgFabbMaxIndice(obj.getDomRiscQhto() > obj.getIndRiscEpito() ? Constants.SI
					: Constants.NO);
			
			obj.setRendAcsEtagacs(BaseMgr.convertTo(in.getRendGlobStagioneAcqua()));
			obj.setDomAcsQhw(BaseMgr.convertTo(in.getDomEnergAcqua()));
			obj.setEnAcsRinno(BaseMgr.convertTo(in.getEnergTermAcquaRinnov()));

		}
		
		
		
		
		if (obj.getDomAcsQhw() != null && obj.getSu() != null) {
			// DA APPROSSIMARE + 4 DECIMALI
			obj.setDomAcsQhwSu(obj.getDomAcsQhw() / obj.getSu());
		}

		
//		obj.setFlgFabbAcs(obj.getDomAcsQhw() != obj.getDomAcsQhwto() ? Constants.SI
//				: Constants.NO);

		
		if (ai != null)
		{
			obj.setFkClasse19205(BaseMgr.convertToInteger(ai.getEnergetiche()
					.getClasseEnergEdificio()));

			obj.setValorePrestPdc(BaseMgr.convertTo(ai.getEnergetiche()
					.getPrestazPompaCalore()));

			obj.setFkMotivo(BaseMgr.convertToInteger(ai.getGenerali()
					.getMotivoRilascio()));
			obj.setMetodologiaCalcolo(ai.getGenerali().getMetodoCalcolo());
			obj.setSwUtilizzato(ai.getGenerali().getSoftware());

			obj.setPrestazioneEne(BaseMgr.convertTo(ai.getEnergetiche()
					.getPrestEnergRaggiungibile()));
			
		}
		
		
		
		GenericUtil.stampa(obj, true, 4);

		return obj;
	}
	*/
	
	/**
	 * Map to db ruoli edificio.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t ruoli edificio
	 */
	private SiceeTRuoliEdificio mapToDBRuoliEdificio(SiceeTRuoliEdificioPk pk,
			DatiAttestato att) {
		SiceeTRuoliEdificio obj = new SiceeTRuoliEdificio();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());
		obj.setFkTipoRuolo(pk.getFkTipoRuolo());

		SoggResponsabile sogg = null;

		if (pk.getFkTipoRuolo().intValue() == 1) {
			sogg = att.getDatiAnagraficiImm().getDtResponsabili()
					.getDtProgettista();
		} else if (pk.getFkTipoRuolo().intValue() == 2) {
			sogg = att.getDatiAnagraficiImm().getDtResponsabili()
					.getDtDirLavori();
		} else if (pk.getFkTipoRuolo().intValue() == 3) {
			sogg = att.getDatiAnagraficiImm().getDtResponsabili()
					.getDtCostruttore();
		}

		obj.setNome(sogg.getNome());
		obj.setCognome(sogg.getCognome());
		// obj.setIdIndirizzo(sogg.getCodIndirizzo()); //TODO
		obj.setDescIndirizzo(sogg.getDescrIndirizzo());
		obj.setCap(sogg.getCap());
		obj.setIdComune(sogg.getCodComune());
		obj.setDescComune(sogg.getDescrComune());
		obj.setIdProvincia(sogg.getCodProv());
		obj.setDescProvincia(sogg.getDescrProv());
		obj.setIdRegione(sogg.getCodReg());
		obj.setDescRegione(sogg.getDescrReg());
		obj.setTelefono(sogg.getTel());
		obj.setCell(sogg.getCell());
		obj.setFax(sogg.getFax());
		obj.setEmail(sogg.getEmail());
		obj.setNumCivico(sogg.getNumCiv());

		return obj;
	}

	/**
	 * Map to db altre info.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t altre info
	 */
	private SiceeTAltreInfo mapToDBAltreInfo(SiceeTAltreInfoPk pk,
			DatiAttestato att) {
		SiceeTAltreInfo obj = new SiceeTAltreInfo();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtAltreInfo ai = att.getAltreInfo();
		DtImpRiscald impRiscald = att.getImpianti().getRiscaldamento();
		;
		obj.setFkClasse19205(BaseMgr.convertToInteger(ai.getEnergetiche()
				.getClasseEnergEdificio()));
		obj.setPrestazioneEne(BaseMgr.convertTo(ai.getEnergetiche()
				.getPrestEnergRaggiungibile()));
		obj.setLimiteNormaRisc(BaseMgr.convertTo(ai.getEnergetiche()
				.getLimNormaNazRiscald()));
		obj.setFkQualitaInvo(BaseMgr.convertToInteger(ai.getEnergetiche()
				.getQualitaInvolucroRaffresc()));
		obj.setLimiteNormaImp(BaseMgr.convertTo(impRiscald
				.getLimNormRegImpTerm()));
		obj.setValorePrestPdc(BaseMgr.convertTo(ai.getEnergetiche()
				.getPrestazPompaCalore()));
		obj.setLimiteNormaPdc(BaseMgr.convertTo(ai.getEnergetiche()
				.getLimNormaPrestPompa()));
		obj.setUltInfo(ai.getEnergetiche().getAltreInfo());
		obj.setFkMotivo(BaseMgr.convertToInteger(ai.getGenerali()
				.getMotivoRilascio()));
		obj.setMetodologiaCalcolo(ai.getGenerali().getMetodoCalcolo());
		obj.setNomeProduttore(ai.getGenerali().getDenomProduttore());
		obj.setSwUtilizzato(ai.getGenerali().getSoftware());
		obj.setUniTs11300(ai.getGenerali().getRispondenzaUNITS11300());
		obj.setIndRiscEpiNaz(BaseMgr.convertTo(ai.getEnergetiche()
				.getIndPrestEnergRiscald()));

		return obj;
	}

	private SiceeTAltreInfo mapToDBAltreInfoNew(SiceeTAltreInfo obj,
			DatiAttestato att) {
//		SiceeTAltreInfo obj = new SiceeTAltreInfo();
//		obj.setIdCertificatore(pk.getIdCertificatore());
//		obj.setProgrCertificato(pk.getProgrCertificato());
//		obj.setAnno(pk.getAnno());

		DtAltreInfo ai = att.getAltreInfo();
		obj.setFkMotivo(BaseMgr.convertToInteger(ai.getGenerali()
				.getMotivoRilascio()));
		obj.setAltroServiziEnergia(BaseMgr.convertToInteger(ai.getGenerali()
				.getAltroServiziEnergia()));
		
		return obj;
	}

	/**
	 * Map to db certificato.
	 *
	 * @param obj the obj
	 * @param att the att
	 * @return the sicee t certificato
	 * @throws BEException the bE exception
	 */
	private SiceeTCertificato mapToDBCertificatoOld(SiceeTCertificato obj,
			DatiAttestato att) throws BEException {

		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
		DtCoCertificatore coCert = att.getDatiAnagraficiImm()
				.getDtCoCertificatore();
		DtDichiarazFinale df = att.getDichiarazioni();
		DtAltreInfo ai = att.getAltreInfo();

		obj.setIdProv(cat.getCodProv());
		obj.setDescProv(cat.getDescrProv());
		obj.setIdComune(cat.getCodComune());
		obj.setDescComune(cat.getDescrComune());
		obj.setIdIndirizzo(cat.getCodIndirizzo());
		obj.setDescIndirizzo(cat.getDescrIndirizzo());

		obj.setNumCivico(cat.getNumCiv());
		obj.setCap(cat.getCap());

		// Beppe 10/01/2012
		// obj.setFlgCondominio(cat.getFlgCondominio());

		obj.setSezione(cat.getSezione());
		obj.setFoglio(cat.getFoglio());
		obj.setParticella(cat.getParticella());
		obj.setSubalterno(cat.getSubalterno());
		obj.setPiano((cat.getPiano()));
		obj.setNumPianiComplessivi(this.convertTo(cat.getPianiTot()));
		obj.setNumAppartamenti(this.convertTo(cat.getNumUnita()));
		obj.setScala(cat.getScala());
		obj.setInterno(cat.getInterno());
		obj.setNote(cat.getNote());
		obj.setNomeCocertificatore(coCert.getNome());
		obj.setCognomeCocertificatore(coCert.getCognome());
		obj.setNumCocertificatore(coCert.getNumMatricola());

		obj.setFkDichiarazione(df.getCodDichiaraz());
		obj.setLuogoDichiarazione(df.getLuogoDichiarazione());
		// Date data = convertToDate(df.getDataDichiarazione());

		obj.setDtInizio(DateUtil.convertToDate(df.getDataDichiarazione()));
		obj.setDtScadenza(DateUtil.convertToDate(DateUtil.addTenYear(df
				.getDataDichiarazione())));

		obj.setFkStato(Constants.BOZZA);

		obj.setNomeFoto(cat.getNomeFoto());
		obj.setIdentificFoto(cat.getUidFoto());
		obj.setIdentificPdf(cat.getUidDoc());

		obj.setDtFoto(DateUtil.convertToDateCompleta(cat.getDataUpFoto()));

		obj.setFlgEdificioPerformante(this.convertToString(ai
				.getFlgEdificioPerformante()));

		obj.setNomePdf(cat.getNomeDoc());

		return obj;
	}

	/**
	 * Map to db certificato.
	 *
	 * @param obj the obj
	 * @param att the att
	 * @return the sicee t certificato
	 * @throws BEException the bE exception
	 */
	private SiceeTCertificato mapToDBCertificato(SiceeTCertificato obj,
			DatiAttestato att, String descIndTope) throws BEException {

		
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
		DtCoCertificatore coCert = att.getDatiAnagraficiImm().getDtCoCertificatore();
		DtDichiarazFinale df = att.getDichiarazioni();
//		DtAltreInfo ai = att.getAltreInfo();

		obj.setIdProv(cat.getCodProv());
		obj.setDescProv(cat.getDescrProv());
		obj.setIdComune(cat.getCodComune());
		obj.setDescComune(cat.getDescrComune());
		
		if (!GenericUtil.isNullOrEmpty(cat.getCodIndirizzo()))
		{
			obj.setIdIndirizzo(cat.getCodIndirizzo());
			obj.setDescIndirizzo(GenericUtil.normalizzaSql(descIndTope));
		}
		else
		{
			obj.setIdIndirizzo(null);
			obj.setDescIndirizzo(GenericUtil.normalizzaSql(cat.getDescrIndirizzo()));
		}

		obj.setIdRegione(Constants.COD_REGIONE_PIEMONTE);
		obj.setDescRegione(Constants.DESC_REGIONE_PIEMONTE);
		
		obj.setNumCivico(cat.getNumCiv());
		obj.setCap(cat.getCap());

		obj.setInterno(cat.getInterno());
		obj.setScala(cat.getScala());
		obj.setPiano((cat.getPiano()));

		obj.setNumPianiComplessivi(convertTo(cat.getPianiTot()));
		obj.setNumPianiFTRisc(convertTo(cat.getNumPianiFtRisc()));
		
		obj.setSezione(cat.getSezione());
		obj.setFoglio(cat.getFoglio());
		obj.setParticella(cat.getParticella());
		obj.setSubalterno(cat.getSubalterno());
		
		//co-certificatore
		obj.setCognomeCocertificatore(GenericUtil.normalizzaSql(coCert.getCognome()));
		obj.setNomeCocertificatore(GenericUtil.normalizzaSql(coCert.getNome()));
		obj.setNumCocertificatore(GenericUtil.normalizzaSql(coCert.getNumMatricola()));
		obj.setCodFiscCocertificatore(GenericUtil.normalizzaSql(coCert.getCodFisc()));

		log.debug("****************COORDINATA NORD =" + new Double(cat.getCoordN()));
		
		obj.setCoordN(new Double(cat.getCoordN()));
		
		log.debug("****************COORDINATA EST =" + new Double(cat.getCoordE()));
		
		obj.setCoordE(new Double(cat.getCoordE()));
		 
		
		obj.setRifCatasto(cat.getSistCatast());

		log.debug("**** CertificatoMgr - mapToDBCertificato CODICE COMUNE CATASTALE: " + cat.getCodComuneCatasto());

		obj.setCodiceComuneCatastale(cat.getCodComuneCatasto());
		
		obj.setFkDichiarazione(df.getCodDichiaraz());
		//obj.setDtInizio(DateUtil.convertToDate(df.getDataDichiarazione()));
		obj.setDtInizio(new Date());
		
		
		obj.setFkScadenzaCert(att.getIdScadenza());
		
		int idTipoScad = att.getIdScadenza();
		Date dataScadenza = null;
		
		/*
		if (idTipoScad == Constants.ID_TIPO_SCADENZA_ANNO_IN_CORSO)
		{
			dataScadenza = DateUtil.getFineAnnoCorrente();
		}
		else 
		*/
		if (idTipoScad == Constants.ID_TIPO_SCADENZA_ANNO_SUCCESSIVO)
		{
			dataScadenza = DateUtil.getFineAnnoSuccessivo();
		}
		else if (idTipoScad == Constants.ID_TIPO_SCADENZA_ANNO_10)
		{
			dataScadenza = DateUtil.getAggiungi10Anni(new Date());
		}
		
		obj.setDtScadenza(dataScadenza);

		obj.setFkStato(att.getStatus());

		return obj;
	}
	
	/**
	 * Map to db rispetto normative.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t rispetto normative
	 * @throws BEException the bE exception
	 */
	private SiceeTRispettoNormative mapToDBRispettoNormative(
			SiceeTRispettoNormativePk pk, DatiAttestato att) throws BEException {
		SiceeTRispettoNormative obj = new SiceeTRispettoNormative();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		obj.setDtTitolo(DateUtil.convertToDate(att.getRispNorme()
				.getDataTitolo()));
		obj.setFkNorma(BaseMgr.convertToInteger(att.getRispNorme()
				.getCodNorma()));
		obj.setFlgNorma(att.getRispNorme().getAutorizzato());
		obj.setMotivoNonConformita(att.getRispNorme().getMotivoNonConformita());
		obj.setNote(att.getRispNorme().getNote());

		return obj;
	}

	/**
	 * Map to db imp riscaldamento acs.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t imp riscaldamento acs
	 * @throws BEException the bE exception
	 */
	private SiceeTImpRiscaldamentoAcs mapToDBImpRiscaldamentoAcs(
			SiceeTImpRiscaldamentoAcsPk pk, DatiAttestato att)
			throws BEException {
		SiceeTImpRiscaldamentoAcs obj = new SiceeTImpRiscaldamentoAcs();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtImpianti im = att.getImpianti();
		obj.setCodiceImpianto(im.getRiscaldamento().getCodImpianto());
		obj.setFkClasseEffAcs(BaseMgr.convertToInteger(im.getAcqua()
				.getClasseEfficienzaEnerg()));
		obj.setFkClasseEffRisc(BaseMgr.convertToInteger(im.getRiscaldamento()
				.getClasseEfficienzaEnerg()));
		obj.setFkCombustibileAcs(BaseMgr.convertToInteger(im.getAcqua()
				.getCombustibileFossile()));
		obj.setFkCombustibileRisc(BaseMgr.convertToInteger(im
				.getRiscaldamento().getCombustibileFossile()));
		obj.setFlgBollino(im.getRiscaldamento().getFlgBollino());
		obj.setGenAnnoAcs(BaseMgr.convertToInteger(im.getAcqua()
				.getAnnoInstallGeneratore()));
		obj.setGenAnnoRisc(BaseMgr.convertToInteger(im.getRiscaldamento()
				.getAnnoInstallGeneratore()));
		obj.setNumeroBollino(im.getRiscaldamento().getNumBollino());
		obj.setPotAcs(BaseMgr.convertTo(im.getAcqua().getPotNomCompl()));
		obj.setPotRiscaldamento(BaseMgr.convertTo(im.getRiscaldamento()
				.getPotNomCompl()));

		return obj;
	}

	/**
	 * Map to db fabbisogno.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t fabbisogno
	 * @throws BEException the bE exception
	 */
	private SiceeTFabbisogno mapToDBFabbisogno(SiceeTFabbisognoPk pk,
			DatiAttestato att) throws BEException {
		SiceeTFabbisogno obj = new SiceeTFabbisogno();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtIndiciFabbisogno in = att.getIndFabbisogno();

		obj.setDomAcsQhw(BaseMgr.convertTo(in.getDomEnergAcqua()));
		obj.setDomRiscQh(BaseMgr.convertTo(in.getDomEnergRiscald()));
		obj.setEnAcsRinno(BaseMgr.convertTo(in.getEnergTermAcquaRinnov()));
		obj.setFabbAcs(BaseMgr.convertTo(in.getIndPrestEnergAcqua()));
		obj.setFabbCondiz(BaseMgr.convertTo(in.getFabbCondizionamento()));
		obj.setFabbIllum(BaseMgr.convertTo(in.getIndPrestEnergIlluminaz()));
		obj.setLimiteRegQhLim(BaseMgr.convertTo(in.getLimNormRegione()));
		obj.setRendAcsEtagacs(BaseMgr.convertTo(in.getRendGlobStagioneAcqua()));

		return obj;
	}

	/**
	 * Map to db energia sopr ingr.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t energia sopr ingr
	 * @throws BEException the bE exception
	 */
	private SiceeTEnergiaSoprIngr mapToDBEnergiaSoprIngr(
			SiceeTEnergiaSoprIngrPk pk, DatiAttestato att) throws BEException {
		SiceeTEnergiaSoprIngr obj = new SiceeTEnergiaSoprIngr();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtAltreInfo ai = att.getAltreInfo();
		DtEnergiaFontiRinnov ef = att.getEnergRinnov();

		obj.setAutoconsElett(BaseMgr.convertTo(ef.getAutoconsumoElettrico()));
		obj.setAutoconsTermico(BaseMgr.convertTo(ef.getAutoconsumoTermico()));
		obj.setDtSopralluogo(DateUtil.convertToDate(ai.getSopralluoghi()
				.getData()));
		obj.setEnElettProd(BaseMgr.convertTo(ef.getEnergElettricaProdotta()));
		obj.setEnTermicaProd(BaseMgr.convertTo(ef.getEnergTermicaProdotta()));
		obj.setFkDati(BaseMgr.convertToInteger(ai.getSopralluoghi()
				.getTipoRedazione()));
		obj.setNoteSoprall(ai.getSopralluoghi().getNote());
		obj.setTecnoRinno(ef.getTechFontiRinnov());
		obj.setAnnoInstall(BaseMgr.convertToInteger(ef.getAnnoInstall()));
		obj.setPercFontiRinnov(BaseMgr.convertTo(ef.getPercEnergiaFontiRinnov()));
		return obj;
	}

	/**
	 * Map to db dati generali.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t dati generali
	 * @throws BEException the bE exception
	 */
	private SiceeTDatiGenerali mapToDBDatiGenerali(SiceeTDatiGeneraliPk pk,
			DatiAttestato att) throws BEException {
		SiceeTDatiGenerali obj = new SiceeTDatiGenerali();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtTecniciGen dt = att.getDatiTecnici();
		DtAnagImmobile anagImmobile = att.getDatiAnagraficiImm();
		DtCatastali cat = anagImmobile.getDtCatastali();
		
		obj.setFkOggettoApe(BaseMgr.convertToInteger(dt.getOggetto()));
		
		obj.setAnnoCostruzione(BaseMgr.convertToInteger(dt.getAnnoCostr()));
		obj.setAnnoUltRist(BaseMgr.convertToInteger(dt.getAnnoUltimaRistrutt()));
		obj.setZonaClimatica(cat.getZonaClimatica());
		obj.setGradiGiorno(BaseMgr.convertToInteger(cat.getGradiGiorno()));
		
		obj.setFkTipoRistrutturaz(BaseMgr.convertToInteger(dt.getTipoRistrutturazione()));
		obj.setFkTipolEdilizia(BaseMgr.convertToInteger(dt.getTipolEdilizia()));
		obj.setFkTipolCostruttiva(BaseMgr.convertToInteger(dt.getTipolCostruttiva()));
		obj.setFkProprietaEdi(BaseMgr.convertToInteger(dt.getProprEdificio()));

		return obj;
	}

	/**
	 * Map to db dati generali.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t dati generali
	 * @throws BEException the bE exception
	 */
	private SiceeTDatiGenerali mapToDBDatiGeneraliNew(SiceeTDatiGenerali obj,
			DatiAttestato att) throws BEException {
//		SiceeTDatiGenerali obj = new SiceeTDatiGenerali();
//		obj.setIdCertificatore(pk.getIdCertificatore());
//		obj.setProgrCertificato(pk.getProgrCertificato());
//		obj.setAnno(pk.getAnno());

		DtTecniciGen dt = att.getDatiTecnici();
		DtAnagImmobile anagImmobile = att.getDatiAnagraficiImm();
		DtCatastali cat = anagImmobile.getDtCatastali();
		
		obj.setFkOggettoApe(BaseMgr.convertToInteger(dt.getOggetto()));
		
		obj.setAnnoCostruzione(BaseMgr.convertToInteger(dt.getAnnoCostr()));
		obj.setAnnoUltRist(BaseMgr.convertToInteger(dt.getAnnoUltimaRistrutt()));
		obj.setZonaClimatica(cat.getZonaClimatica());
		obj.setGradiGiorno(BaseMgr.convertToInteger(cat.getGradiGiorno()));
		
		obj.setFkTipoRistrutturaz(BaseMgr.convertToInteger(dt.getTipoRistrutturazione()));
		obj.setFkTipolEdilizia(BaseMgr.convertToInteger(dt.getTipolEdilizia()));
		obj.setFkTipolCostruttiva(BaseMgr.convertToInteger(dt.getTipolCostruttiva()));
		obj.setFkProprietaEdi(BaseMgr.convertToInteger(dt.getProprEdificio()));

		return obj;
	}
	/**
	 * Map to db dati generali.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t dati generali
	 * @throws BEException the bE exception
	 */
	/*
	private SiceeTDatiGenerali mapToDBDatiGeneraliOld(SiceeTDatiGeneraliPk pk,
			DatiAttestato att) throws BEException {
		SiceeTDatiGenerali obj = new SiceeTDatiGenerali();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtTecniciGen dt = att.getDatiTecnici();
		DtAnagImmobile anagImmobile = att.getDatiAnagraficiImm();
		DtCatastali cat = anagImmobile.getDtCatastali();

		obj.setFlagUsoPubblico(dt.getFlagUsoPubblico());
		obj.setAnnoCostruzione(BaseMgr.convertToInteger(dt.getAnnoCostr()));
		obj.setAnnoUltRist(BaseMgr.convertToInteger(dt.getAnnoUltimaRistrutt()));
		obj.setEmissioniSerra(BaseMgr.convertTo(att.getGasSerra()
				.getEmissioniGasSerra()));
		obj.setEttariBosco(BaseMgr.convertTo(att.getGasSerra()
				.getSupBoscoEquiv()));

		obj.setFattoreForma(BaseMgr.convertTo(dt.getFattoreForma()));
		obj.setFkDestUso(BaseMgr.convertToInteger(dt.getDestUso()));
		obj.setFkCarattEdificio(BaseMgr.convertToInteger(dt.getCarattEdificio()));
		obj.setDescTipoEdificio(dt.getDescrizioneEdificio());
		obj.setGradiGiorno(this.convertTo(cat.getGradiGiorno()));
		obj.setSu(BaseMgr.convertTo(dt.getSuperficieUtile()));
		obj.setSupDisperdenteTot(BaseMgr.convertTo(dt.getSupDispTot()));
		obj.setTrasmOpache(BaseMgr.convertTo(dt.getTrasmittanzaOpache()));
		obj.setTrasmTrasp(BaseMgr.convertTo(dt.getTrasmittanzaTrasp()));
		obj.setVolLordoRiscaldato(BaseMgr.convertTo(dt.getVolLordoRiscald()));
		obj.setZonaClimatica(cat.getZonaClimatica());

		return obj;
	}
	*/
	
	/**
	 * Map to db consumi edificio.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t consumi edificio
	 * @throws BEException the bE exception
	 */
	private SiceeTConsumiEdificio mapToDBConsumiEdificio(
			SiceeTConsumiEdificioPk pk, DatiAttestato att) throws BEException {
		SiceeTConsumiEdificio obj = new SiceeTConsumiEdificio();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtConsumiReali cr = att.getConsumiReali();
		DtImpianti impianti = att.getImpianti();

		obj.setAnnElettFossile(BaseMgr.convertTo(cr.getAnnoElettricoFossile()));
		obj.setAnnElettRinno(BaseMgr.convertTo(cr.getAnnoElettricoRinnov()));
		obj.setAnnTermiFossile(BaseMgr.convertTo(cr.getAnnoTermicoFossile()));
		obj.setAnnTermiRinno(BaseMgr.convertTo(cr.getAnnoTermicoRinnov()));
		obj.setComplessElettrico(BaseMgr.convertTo(cr.getMedioElettrico()));
		obj.setComplessTermico(BaseMgr.convertTo(cr.getMedioTermico()));
		obj.setDescTipoDistrib(impianti.getTipoDistrib());
		obj.setDescTipoErog(impianti.getTipoTermErogaz());
		// obj.setFkTipoImpianto(convertToInteger(impianti.getTipoImpianto()));
		obj.setFkTipoImpianto(BaseMgr.convertToInteger(att.getDatiTecnici()
				.getTipoImpianto()));
		obj.setDescTipoReg(impianti.getTipoRegolaz());
		obj.setFlgContRip(impianti.getFlgRipartizione());
		obj.setUiServite(impianti.getUiServite());

		return obj;
	}

	/**
	 * Map to db classe energetica.
	 *
	 * @param pk the pk
	 * @param att the att
	 * @return the sicee t classe energetica
	 * @throws BEException the bE exception
	 */
	private SiceeTClasseEnergetica mapToDBClasseEnergetica(
			SiceeTClasseEnergeticaPk pk, DatiAttestato att) throws BEException {
		SiceeTClasseEnergetica obj = new SiceeTClasseEnergetica();
		obj.setIdCertificatore(pk.getIdCertificatore());
		obj.setProgrCertificato(pk.getProgrCertificato());
		obj.setAnno(pk.getAnno());

		DtClasseEnerg ce = att.getClasseEnerg();

		obj.setServiziEnergetici(Constants.SERVIZI_ENERGETICI_INCLUSI);
		obj.setDomAcsQhwto(BaseMgr.convertTo(ce.getLocTeorica()
				.getDomEnergAcqua()));
		obj.setDomRiscQhto(BaseMgr.convertTo(ce.getLocTeorica()
				.getDomEnergRiscald()));
		obj.setEnAcsRinnoTo(BaseMgr.convertTo(ce.getLocTeorica()
				.getEnergTermAcquaRinnov()));
		obj.setEtagConv(new Double("0.9"));
		obj.setFabbAcsTo(BaseMgr.convertTo(ce.getLocTeorica()
				.getIndPrestEnergAcqua()));
		obj.setFkClasse(BaseMgr.convertToInteger(ce.getLocTeorica()
				.getClasseEnerg()));
		obj.setIndCondEst(BaseMgr.convertTo(ce.getLocReale()
				.getIndPrestEnergCondiz()));
		obj.setIndGlobEplordo(BaseMgr.convertTo(ce.getLocReale()
				.getIndPrestEnergGlob()));
		obj.setIndGlobEplordoTo(BaseMgr.convertTo(ce.getLocTeorica()
				.getIndPrestEnergGlob()));
		obj.setIndGlobLimiteTo(BaseMgr.convertTo(ce.getLocTeorica()
				.getIndGlobLimiteTo()));
		obj.setIndIllum(BaseMgr.convertTo(ce.getLocReale()
				.getIndPrestEnergIlluminaz()));
		obj.setIndRiscEpi(BaseMgr.convertTo(ce.getLocReale()
				.getIndPrestEnergRiscald()));
		obj.setIndRiscEpito(BaseMgr.convertTo(ce.getLocTeorica()
				.getIndPrestEnergRiscald()));
		obj.setLimiteRegQhto(BaseMgr.convertTo(ce.getLocTeorica()
				.getLimNormaRegione()));
		obj.setRendAcsEtagAcsto(BaseMgr.convertTo(ce.getLocTeorica()
				.getRendGlobStagioneAcqua()));
		obj.setRendDistrib(BaseMgr.convertTo(ce.getLocReale().getRendDistrib()));
		obj.setRendEmiss(BaseMgr.convertTo(ce.getLocReale().getRendEmissione()));
		obj.setRendGener(BaseMgr.convertTo(ce.getLocReale().getRendGeneraz()));
		obj.setRendImpEtag(BaseMgr.convertTo(ce.getLocReale()
				.getRendGlobTermico()));
		obj.setRendRegol(BaseMgr.convertTo(ce.getLocReale().getRendRegolaz()));
		obj.setServiziEnergetici(ce.getLocTeorica().getServEnergInclusi());

		return obj;
	}

	/**
	 * Recupera attestato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the dati attestato
	 * @throws BEException the bE exception
	 */
	/*
	@Transactional
	public DatiAttestato recuperaAttestato(String numeroCertificato)
			throws BEException {

		
		
		DatiAttestato ret = null;
		try {

			String[] split = numeroCertificato.split(" ");

			DatiCertificatore certificatore = new DatiCertificatore();

			String idCertificatore = this.getCertificatoreMgr()
					.getIdCertificatoreFromNumCertificatore(split[1]);
			certificatore.setIdCertificatore(idCertificatore);

			ret = this.recuperaAttestato(certificatore, numeroCertificato);

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

		return ret;
		
		
	}
	*/

	public String recuperaUidDocumento(DatiCertificatore cert,
			String numeroCertificato, Integer idTipoDoc) throws BEException {
		
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), numeroCertificato);

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		log.debug("idCertificatore: " + id);
		log.debug("progressivoCertificato: " + prog);
		log.debug("anno: " + anno);
		
		String uid = null;
		try {
			SiceeTRifIndex2015 rifIndex = recuperaRifIndex2015(id, prog, anno, idTipoDoc);
			
			if (rifIndex != null)
			{
				uid = rifIndex.getUidIndex();
			}
		} catch (Exception e) {
			
			log.error("Errore", e);
			throw new BEException(e.getMessage(), e);
		}
		
		return uid;

	}
	
	public void inserisciDocumento(String idCertificatore, String progrCertificato, String anno, Integer idTipoDoc, String nomeFile, String hash, String uidIndex) throws BEException {
		
		try {
			
			SiceeTRifIndex2015 rifIndex = new SiceeTRifIndex2015();
			rifIndex.setIdCertificatore(idCertificatore);
			rifIndex.setProgrCertificato(progrCertificato);
			rifIndex.setAnno(anno);
			rifIndex.setFkTipoDoc(idTipoDoc);
			rifIndex.setNomeFile(nomeFile);
			rifIndex.setHash(hash);
			rifIndex.setUidIndex(uidIndex);

			rifIndex.setDtCaricamento(new Date());
			
			getSiceeTRifIndex2015Dao().insert(rifIndex);
			
		} catch (Exception e) {
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		
	}

	public void modificaDocumento(String idCertificatore, String progrCertificato, String anno, Integer idTipoDoc, String nomeFile, String hash, String uidIndex) throws BEException {
		
		try {
			
			SiceeTRifIndex2015 rifIndex = getSiceeTRifIndex2015Dao().findBySiceeTCertificatoidTipoDoc(idCertificatore, progrCertificato, anno, idTipoDoc);
			
			rifIndex.setIdCertificatore(idCertificatore);
			rifIndex.setProgrCertificato(progrCertificato);
			rifIndex.setAnno(anno);
			rifIndex.setFkTipoDoc(idTipoDoc);
			rifIndex.setNomeFile(nomeFile);
			rifIndex.setHash(hash);
			rifIndex.setUidIndex(uidIndex);
			
			rifIndex.setDtCaricamento(new Date());

			getSiceeTRifIndex2015Dao().update(rifIndex.createPk(), rifIndex);
			
		} catch (Exception e) {
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		
	}

	
	/**
	 * Recupera attestato.
	 *
	 * @param cert the cert
	 * @param numeroCertificato the numero certificato
	 * @return the dati attestato
	 * @throws BEException the bE exception
	 */
	@Transactional
	public DatiAttestato recuperaAttestato(DatiCertificatore cert,
			String numeroCertificato) throws BEException {
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), numeroCertificato);

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		log.debug("recuperaAttestato");
		log.debug("idCertificatore: " + id);
		log.debug("progressivoCertificato: " + prog);
		log.debug("anno: " + anno);

		boolean isOld = false;
		
		DatiAttestato ret = null;
		try {

			SiceeTCertificatoPk pk9 = new SiceeTCertificatoPk(id, prog, anno);
			SiceeTCertificato obj9 = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(pk9);
			if (obj9 == null) {
				obj9 = new SiceeTCertificato();
				obj9.setIdCertificatore(id);
				obj9.setProgrCertificato(prog);
				obj9.setAnno(anno);
				obj9.setFlgOld(Constants.NO);
				this.getSiceeTCertificatoDao().insert(obj9);
			}

			if (obj9.getFlgOld() != null)
			{
				isOld = BaseMgr.convertToBoolean(obj9
						.getFlgOld());
			}

			SiceeTDatiGeneraliPk pk2 = new SiceeTDatiGeneraliPk(id, prog, anno);
			SiceeTDatiGenerali obj2 = this.getSiceeTDatiGeneraliDao()
					.findByPrimaryKey(pk2);
			if (obj2 == null) {
				obj2 = new SiceeTDatiGenerali();
				obj2.setIdCertificatore(id);
				obj2.setProgrCertificato(prog);
				obj2.setAnno(anno);
				this.getSiceeTDatiGeneraliDao().insert(obj2);
			}

			if (isOld)
			{
				SiceeTClasseEnergeticaPk pk0 = new SiceeTClasseEnergeticaPk(id,
						prog, anno);
				SiceeTClasseEnergetica obj0 = this.getSiceeTClasseEnergeticaDao()
						.findByPrimaryKey(pk0);
				if (obj0 == null) {
					obj0 = new SiceeTClasseEnergetica();
					obj0.setIdCertificatore(id);
					obj0.setProgrCertificato(prog);
					obj0.setAnno(anno);
					obj0.setServiziEnergetici(Constants.SERVIZI_ENERGETICI_INCLUSI);
					this.getSiceeTClasseEnergeticaDao().insert(obj0);
				}	

				SiceeTConsumiEdificioPk pk1 = new SiceeTConsumiEdificioPk(id, prog,
						anno);
				SiceeTConsumiEdificio obj1 = this.getSiceeTConsumiEdificioDao()
						.findByPrimaryKey(pk1);
				if (obj1 == null) {
					obj1 = new SiceeTConsumiEdificio();
					obj1.setIdCertificatore(id);
					obj1.setProgrCertificato(prog);
					obj1.setAnno(anno);
					this.getSiceeTConsumiEdificioDao().insert(obj1);
				}


				SiceeTEnergiaSoprIngrPk pk3 = new SiceeTEnergiaSoprIngrPk(id, prog,
						anno);
				SiceeTEnergiaSoprIngr obj3 = this.getSiceeTEnergiaSoprIngrDao()
						.findByPrimaryKey(pk3);
				if (obj3 == null) {
					obj3 = new SiceeTEnergiaSoprIngr();
					obj3.setIdCertificatore(id);
					obj3.setProgrCertificato(prog);
					obj3.setAnno(anno);
					this.getSiceeTEnergiaSoprIngrDao().insert(obj3);
				}

				SiceeTFabbisognoPk pk4 = new SiceeTFabbisognoPk(id, prog, anno);
				SiceeTFabbisogno obj4 = this.getSiceeTFabbisognoDao()
						.findByPrimaryKey(pk4);
				if (obj4 == null) {
					obj4 = new SiceeTFabbisogno();
					obj4.setIdCertificatore(id);
					obj4.setProgrCertificato(prog);
					obj4.setAnno(anno);
					this.getSiceeTFabbisognoDao().insert(obj4);
				}

				SiceeTImpRiscaldamentoAcsPk pk5 = new SiceeTImpRiscaldamentoAcsPk(
						id, prog, anno);
				SiceeTImpRiscaldamentoAcs obj5 = this
						.getSiceeTImpRiscaldamentoAcsDao().findByPrimaryKey(pk5);
				if (obj5 == null) {
					obj5 = new SiceeTImpRiscaldamentoAcs();
					obj5.setIdCertificatore(id);
					obj5.setProgrCertificato(prog);
					obj5.setAnno(anno);
					this.getSiceeTImpRiscaldamentoAcsDao().insert(obj5);
				}

				SiceeTRispettoNormativePk pk7 = new SiceeTRispettoNormativePk(id,
						prog, anno);
				SiceeTRispettoNormative obj7 = this.getSiceeTRispettoNormativeDao()
						.findByPrimaryKey(pk7);
				if (obj7 == null) {
					obj7 = new SiceeTRispettoNormative();
					obj7.setIdCertificatore(id);
					obj7.setProgrCertificato(prog);
					obj7.setAnno(anno);
					this.getSiceeTRispettoNormativeDao().insert(obj7);
				}

				SiceeTAltreInfoPk pk8 = new SiceeTAltreInfoPk(id, prog, anno);
				SiceeTAltreInfo obj8 = this.getSiceeTAltreInfoDao()
						.findByPrimaryKey(pk8);
				if (obj8 == null) {
					obj8 = new SiceeTAltreInfo();
					obj8.setIdCertificatore(id);
					obj8.setProgrCertificato(prog);
					obj8.setAnno(anno);
					this.getSiceeTAltreInfoDao().insert(obj8);
				}

				/*
			SiceeTCertificatoPk pk9 = new SiceeTCertificatoPk(id, prog, anno);
			SiceeTCertificato obj9 = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(pk9);
			if (obj9 == null) {
				obj9 = new SiceeTCertificato();
				obj9.setIdCertificatore(id);
				obj9.setProgrCertificato(prog);
				obj9.setAnno(anno);
				this.getSiceeTCertificatoDao().insert(obj9);
			}
				 */

				// NEW BEPPE
				List<SiceeTDaticatastSec> obj10 = this.getSiceeTDaticatastSecDao()
						.findBySiceeTCertificato(id, prog, anno);
				
				SiceeTRuoliEdificioPk pkProg = new SiceeTRuoliEdificioPk(id, prog,
						anno, Constants.PROGETTISTA);
				SiceeTRuoliEdificio objProg = this.getSiceeTRuoliEdificioDao()
						.findByPrimaryKey(pkProg);
				if (objProg == null) {
					objProg = new SiceeTRuoliEdificio();
					objProg.setIdCertificatore(id);
					objProg.setProgrCertificato(prog);
					objProg.setAnno(anno);
					objProg.setFkTipoRuolo(Constants.PROGETTISTA);
					this.getSiceeTRuoliEdificioDao().insert(objProg);
				}
				
				SiceeTRuoliEdificioPk pkDirLav = new SiceeTRuoliEdificioPk(id,
						prog, anno, Constants.DIRETTORE_LAVORI);
				SiceeTRuoliEdificio objDirLav = this.getSiceeTRuoliEdificioDao()
						.findByPrimaryKey(pkDirLav);
				if (objDirLav == null) {
					objDirLav = new SiceeTRuoliEdificio();
					objDirLav.setIdCertificatore(id);
					objDirLav.setProgrCertificato(prog);
					objDirLav.setAnno(anno);
					objDirLav.setFkTipoRuolo(Constants.DIRETTORE_LAVORI);
					this.getSiceeTRuoliEdificioDao().insert(objDirLav);
				}

				SiceeTRuoliEdificioPk pkCostr = new SiceeTRuoliEdificioPk(id, prog,
						anno, Constants.COSTRUTTORE);
				SiceeTRuoliEdificio objCostr = this.getSiceeTRuoliEdificioDao()
						.findByPrimaryKey(pkCostr);
				if (objCostr == null) {
					objCostr = new SiceeTRuoliEdificio();
					objCostr.setIdCertificatore(id);
					objCostr.setProgrCertificato(prog);
					objCostr.setAnno(anno);
					objCostr.setFkTipoRuolo(Constants.COSTRUTTORE);
					this.getSiceeTRuoliEdificioDao().insert(objCostr);
				}

				ret = this.mapToModelFromDB(obj0, obj1, obj2, obj3, obj4, obj5,
						obj7, obj8, obj9, obj10, objProg, objDirLav, objCostr);

			}
			else
			{
				List<SiceeTFoto2015> objFotoList = this.getSiceeTFoto2015Dao()
						.findBySiceeTCertificato(id, prog,
						anno);

				SiceeTAltreInfoPk pk8 = new SiceeTAltreInfoPk(id, prog, anno);
				SiceeTAltreInfo obj8 = this.getSiceeTAltreInfoDao()
						.findByPrimaryKey(pk8);
				if (obj8 == null) {
					obj8 = new SiceeTAltreInfo();
					obj8.setIdCertificatore(id);
					obj8.setProgrCertificato(prog);
					obj8.setAnno(anno);
					this.getSiceeTAltreInfoDao().insert(obj8);
				}
				
				

				// ultime modifiche Alex (Dati xml)
				/*
				SiceeTDatiXml2015Pk pk15 = new SiceeTDatiXml2015Pk(id, prog, anno);
				SiceeTDatiXml2015 obj15 = this.getSiceeTDatiXml2015Dao()
						.findByPrimaryKey(pk15);
				*/
				ret = this.mapToModelFromDB(obj2, obj9, objFotoList, obj8);
			}

			ret.setNumeroAttestato(numeroCertificato);

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
			log.error("Errore in recuperaAttestato ", e);
			throw new BEException(e.getMessage(), e);
		}

		return ret;
	}

	public SiceeTExportBo creaExportBo(DatiCertificatore cert,
			String numeroCertificato) throws BEException {
		
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), numeroCertificato);

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		log.debug("idCertificatore: " + id);
		log.debug("progressivoCertificato: " + prog);
		log.debug("anno: " + anno);

		SiceeTExportBo exportBo = null;
		try {

			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(id, prog, anno);

//			SiceeTCertificato siceeTCertificato,
//			SiceeTDatiGenerali siceeTDatiGenerali, SiceeTDatiEner2015 siceeTDatiEner2015, SiceeTAltreInfo siceeTAltreInfo
			
			SiceeTCertificatoPk pk1 = new SiceeTCertificatoPk(id, prog, anno);
			SiceeTCertificato obj1 = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(pk1);
			
			SiceeTDatiGeneraliPk pk2 = new SiceeTDatiGeneraliPk(id, prog, anno);
			SiceeTDatiGenerali obj2 = this.getSiceeTDatiGeneraliDao()
					.findByPrimaryKey(pk2);
			

			SiceeTDatiEner2015Pk pk3 = new SiceeTDatiEner2015Pk(id, prog, anno);
			SiceeTDatiEner2015 obj3 = this.getSiceeTDatiEner2015Dao()
					.findByPrimaryKey(pk3);
			
			SiceeTAltreInfoPk pk4 = new SiceeTAltreInfoPk(id, prog, anno);
			SiceeTAltreInfo obj4 = this.getSiceeTAltreInfoDao()
					.findByPrimaryKey(pk4);
			
			exportBo = this.mapToDBExportBo(exportpk, obj1, obj2, obj3, obj4);
			
		} catch (Exception e) {

			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

		return exportBo;
	}
	
	/**
	 * Duplica attestato.
	 *
	 * @param numeroCertificatoInviato the numero certificato inviato
	 * @param numeroCertificatoNuovo the numero certificato nuovo
	 * @throws BEException the bE exception
	 */
	@Transactional
	public boolean duplicaAttestato(String numeroCertificatoInviato,
			String numeroCertificatoNuovo) throws BEException {

		String[] splitNumeroCertificatoInviato = numeroCertificatoInviato
				.split(" ");
		String[] splitNumeroCertificatoNuovo = numeroCertificatoNuovo
				.split(" ");

		String numCertificatoreNuovo = splitNumeroCertificatoNuovo[1];
		String numCertificatoreInviato = splitNumeroCertificatoInviato[1];

		log.debug("Certificato inviato (quello da cui prendere i dati = "
				+ numeroCertificatoInviato + ")");
		log.debug("Certificato nuovo (quello da duplicare = "
				+ numeroCertificatoNuovo + ")");
		try {
			
			DatiCertificatore certInviato = new DatiCertificatore();
			
			certInviato.setIdCertificatore(this.getCertificatoreMgr()
					.getIdCertificatoreFromNumCertificatore(
							numCertificatoreInviato));
			
			String[] splitOld = BaseMgr.recuperaChiaveAttestato(
					certInviato.getIdCertificatore(), numeroCertificatoInviato);

			String idOld = splitOld[Constants.PK_ID_CERTIFICATORE];
			String progOld = splitOld[Constants.PK_PROGR];
			String annoOld = splitOld[Constants.PK_ANNO];

			log.debug("idCertificatoreOld: " + idOld);
			log.debug("progressivoCertificatoOld: " + progOld);
			log.debug("annoOld: " + annoOld);
			
			SiceeTCertificatoPk pkOld = new SiceeTCertificatoPk(idOld, progOld, annoOld);
			SiceeTCertificato certOld = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(pkOld);
			
			
			String[] splitNew = BaseMgr.recuperaChiaveAttestato(
					certInviato.getIdCertificatore(), numeroCertificatoNuovo);

			String idNew = splitNew[Constants.PK_ID_CERTIFICATORE];
			String progNew = splitNew[Constants.PK_PROGR];
			String annoNew = splitNew[Constants.PK_ANNO];

			log.debug("idCertificatoreNew: " + idNew);
			log.debug("progressivoCertificatoNew: " + progNew);
			log.debug("annoNew: " + annoNew);
			
			SiceeTCertificatoPk certNewPk = new SiceeTCertificatoPk(idNew, progNew, annoNew);
			SiceeTCertificato certNew = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(certNewPk);
			
			
			certNew.setFkStato(Constants.BOZZA);
			certNew.setIdRegione(certOld.getIdRegione());
			certNew.setDescRegione(certOld.getDescRegione());
			certNew.setIdProv(certOld.getIdProv());
			certNew.setDescProv(certOld.getDescProv());
			certNew.setIdComune(certOld.getIdComune());
			certNew.setDescComune(certOld.getDescComune());
			certNew.setCodiceComuneCatastale(certOld.getCodiceComuneCatastale());
			certNew.setIdIndirizzo(certOld.getIdIndirizzo());
			certNew.setDescIndirizzo(certOld.getDescIndirizzo());
			certNew.setNumCivico(certOld.getNumCivico());
			certNew.setCap(certOld.getCap());
			certNew.setInterno(certOld.getInterno());
			certNew.setScala(certOld.getScala());
			certNew.setPiano(certOld.getPiano());
			certNew.setSezione(certOld.getSezione());
			certNew.setFoglio(certOld.getFoglio());
			certNew.setParticella(certOld.getParticella());
			certNew.setSubalterno(certOld.getSubalterno());
			
			certNew.setRifCatasto(certOld.getRifCatasto());
					
			certNew.setCoordE(certOld.getCoordE());
			//certNew.setCoordENull(certOld.getcoo);
			certNew.setCoordN(certOld.getCoordN());
			//certNew.setCoordNNull(certOld.getCoordNNull);
			certNew.setDtInizio(certOld.getDtInizio());
			certNew.setFkScadenzaCert(certOld.getFkScadenzaCert());
			certNew.setDtScadenza(certOld.getDtScadenza());

			
			
			// Aggiorno il certificato
			this.getSiceeTCertificatoDao().update(certNewPk, certNew);
			
			
			SiceeTDatiGeneraliPk datiGenPkOld = new SiceeTDatiGeneraliPk(idOld, progOld, annoOld);
			SiceeTDatiGenerali datiGenOld = this.getSiceeTDatiGeneraliDao()
					.findByPrimaryKey(datiGenPkOld);
			
			
			SiceeTDatiGeneraliPk datiGenPkNew = new SiceeTDatiGeneraliPk(idNew, progNew, annoNew);
			SiceeTDatiGenerali datiGenNew = this.getSiceeTDatiGeneraliDao()
					.findByPrimaryKey(datiGenPkNew);

			if (datiGenNew == null) {
				// Inserisco i dati generali
				datiGenNew = new SiceeTDatiGenerali();
				datiGenNew.setIdCertificatore(idNew);
				datiGenNew.setProgrCertificato(progNew);
				datiGenNew.setAnno(annoNew);
				this.getSiceeTDatiGeneraliDao().insert(datiGenNew);
			}
			
			datiGenNew.setAnnoCostruzione(datiGenOld.getAnnoCostruzione());
			datiGenNew.setAnnoUltRist(datiGenOld.getAnnoUltRist());
			
			datiGenNew.setFkDestUso2015(datiGenOld.getFkDestUso2015());
			datiGenNew.setCodiceEdificioScolastico(datiGenOld.getCodiceEdificioScolastico());

			datiGenNew.setZonaClimatica(datiGenOld.getZonaClimatica());
			datiGenNew.setGradiGiorno(datiGenOld.getGradiGiorno());
			
			// Aggiorno i dati generali
			this.getSiceeTDatiGeneraliDao().update(datiGenPkNew, datiGenNew);
			
			// -- inizio modifiche Alex bug 03/11/2016 --
			SiceeTAltreInfoPk altreInfoPkOld = new SiceeTAltreInfoPk(idOld, progOld, annoOld);
			SiceeTAltreInfo altreInfoOld = this.getSiceeTAltreInfoDao()
					.findByPrimaryKey(altreInfoPkOld);
			
			
			SiceeTAltreInfoPk altreInfoPkNew = new SiceeTAltreInfoPk(idNew, progNew, annoNew);
			SiceeTAltreInfo altreInfoNew = this.getSiceeTAltreInfoDao()
					.findByPrimaryKey(altreInfoPkNew);

			if (altreInfoNew == null) {
				// Inserisco le altre informazioni
				altreInfoNew = new SiceeTAltreInfo();
				altreInfoNew.setIdCertificatore(idNew);
				altreInfoNew.setProgrCertificato(progNew);
				altreInfoNew.setAnno(annoNew);
				this.getSiceeTAltreInfoDao().insert(altreInfoNew);
			}
			
			altreInfoNew.setFkMotivo(altreInfoOld.getFkMotivo());
			altreInfoNew.setMotivoAltro(altreInfoOld.getMotivoAltro());
			altreInfoNew.setAltroServiziEnergia(altreInfoOld.getAltroServiziEnergia());
			
			// Aggiorno le altre informazioni
			this.getSiceeTAltreInfoDao().update(altreInfoPkNew, altreInfoNew);
			// -- fine modifiche Alex bug 03/11/2016 --
			
			SiceeTCertXml2015Pk certXMLPkOld = new SiceeTCertXml2015Pk(idOld, progOld, annoOld);
			SiceeTCertXml2015 certXMLOld = getSiceeTCertXml2015Dao().findByPrimaryKey(certXMLPkOld);
			
			if (certXMLOld == null)
			{
				// E' un caso che non dovrebbe mai succedere, a me no di trattamento dati errato
				log.error("duplicaAttestato - ATTENZIONE: non è stato trovato nessuna riga sulla tabella SICEE_T_CERT_XML_2015: "+numeroCertificatoInviato);
				
				TransactionAspectSupport.currentTransactionStatus()
				.setRollbackOnly();
				
				// forzo l'eccezione
				return false;
			}
			
			SiceeTCertXml2015Pk certXMLPkNew = new SiceeTCertXml2015Pk(idNew, progNew, annoNew);
			SiceeTCertXml2015 certXMLNew = getSiceeTCertXml2015Dao().findByPrimaryKey(certXMLPkNew);

			if (log.isDebugEnabled())
				log.debug("VERIFICO IL certXMLNew (dovrebbe essere nullo): "+certXMLNew);
			
			// Dovrebbe essere sicuramente null
			if (certXMLNew == null)
			{
				log.debug("ENTRO x certXMLNew == null");
				
				certXMLNew = new SiceeTCertXml2015();
				certXMLNew.setIdCertificatore(idNew);
				certXMLNew.setProgrCertificato(progNew);
				certXMLNew.setAnno(annoNew);
				certXMLNew.setFlgControlloBozza("N");
				certXMLNew.setXmlAllegato(certXMLOld.getXmlAllegato());
				
				
				if (log.isDebugEnabled())
					GenericUtil.stampa(certXMLNew, true, 3);
				
				this.getSiceeTCertXml2015Dao().insert(certXMLNew);
			}
			
			// Recupero il documento aggiornato
			MODDocument document = getServiziMgr().getApe(idNew, progNew, annoNew);
			
//			XmlModel xmlModel = new XmlModel();
//			xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(document));

//			certXMLNew.setXmlAllegato(XmlBeanUtils.readByteArray(xmlModel.getXmlContent()));
			certXMLNew.setXmlAllegato(XmlBeanUtils.readByteArray(XmlBeanUtils.extractByteArray(document)));
			
			// Salvo sul DB il nuovo modulo modificato
			this.getSiceeTCertXml2015Dao().update(certXMLPkNew, certXMLNew);
			
			return true;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Duplica attestato.
	 *
	 * @param numeroCertificatoInviato the numero certificato inviato
	 * @param numeroCertificatoNuovo the numero certificato nuovo
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void duplicaAttestatoOld(String numeroCertificatoInviato,
			String numeroCertificatoNuovo) throws BEException {
		String[] splitNumeroCertificatoInviato = numeroCertificatoInviato
				.split(" ");
		String[] splitNumeroCertificatoNuovo = numeroCertificatoNuovo
				.split(" ");

		String numCertificatoreNuovo = splitNumeroCertificatoNuovo[1];
		String numCertificatoreInviato = splitNumeroCertificatoInviato[1];

		log.debug("Certificato inviato (quello da cui prendere i dati = "
				+ numeroCertificatoInviato + ")");
		log.debug("Certificato nuovo (quello da duplicare = "
				+ numeroCertificatoNuovo + ")");
		try {
			// devo prima andare a prendere l'id del cerificatore del
			// certificato (nuovo) da duplicare
			DatiCertificatore certInviato = new DatiCertificatore();
			certInviato.setIdCertificatore(this.getCertificatoreMgr()
					.getIdCertificatoreFromNumCertificatore(
							numCertificatoreInviato));
			DatiAttestato certificatoInviato = this.recuperaAttestato(
					certInviato, numeroCertificatoInviato);
			ArrayList<Raccomandazione> racc = (ArrayList<Raccomandazione>) this.recuperaRaccomandazioni(
					certInviato, numeroCertificatoInviato);

			DatiCertificatore certNuovo = new DatiCertificatore();
			certNuovo.setIdCertificatore(this.getCertificatoreMgr()
					.getIdCertificatoreFromNumCertificatore(
							numCertificatoreNuovo));
			this.recuperaAttestato(certNuovo, numeroCertificatoNuovo);

			certificatoInviato.setDataScadenza(null);
			certificatoInviato.setDataUpload(null);
			certificatoInviato.setDichiarazioni(new DtDichiarazFinale());
			certificatoInviato.getDatiAnagraficiImm().getDtCatastali()
					.setNomeDoc(null);
			certificatoInviato.getDatiAnagraficiImm().getDtCatastali()
					.setNomeFoto(null);
			certificatoInviato.getDatiAnagraficiImm().getDtCatastali()
					.setUidDoc(null);
			certificatoInviato.getDatiAnagraficiImm().getDtCatastali()
					.setUidFoto(null);

			certificatoInviato.setStatus(Constants.BOZZA);
			certificatoInviato.setNumeroAttestato(numeroCertificatoNuovo);

			this.aggiornaAttestato(certNuovo, certificatoInviato);
			this.aggiornaAttestato(certNuovo, certificatoInviato, racc);
			this.aggiornaDatiCatastali(certNuovo, certificatoInviato,
					certificatoInviato.getDatiAnagraficiImm().getDtCatastali()
							.getDtCatastaliSecondari());

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Recupera raccomandazioni.
	 *
	 * @param cert the cert
	 * @param numeroCertificato the numero certificato
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	@Transactional
	public List<Raccomandazione> recuperaRaccomandazioni(
			DatiCertificatore cert, String numeroCertificato)
			throws BEException {
		ArrayList<Raccomandazione> racc = new ArrayList<Raccomandazione>();
		ArrayList<Raccomandazione> raccAlta = new ArrayList<Raccomandazione>();
		ArrayList<Raccomandazione> raccMedia = new ArrayList<Raccomandazione>();
		ArrayList<Raccomandazione> raccBassa = new ArrayList<Raccomandazione>();

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), numeroCertificato);

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		log.debug("idCertificatore: " + id);
		log.debug("progressivoCertificato: " + prog);
		log.debug("anno: " + anno);

		try {
			List<SiceeDPriorita> prioritaList = this.recuperaPriorita();

			List<SiceeTRaccomandazioni> l = this.getSiceeTRaccomandazioniDao()
					.findBySiceeTCertificato(id, prog, anno);
			if (l != null) {
				for (int i = 0; i < l.size(); i++) {
					Raccomandazione r = new Raccomandazione();

					SiceeTRaccomandazioni obj = l.get(i);

					r.setId(obj.getSistema() + "-" + obj.getIntervento() + "-"
							+ obj.getPriorita());
					r.setCodSistema(obj.getSistema());
					r.setIntervento(obj.getIntervento());
					r.setPriorita(obj.getPriorita());
					r.setTempoRitorno(obj.getTempoRitorno());
					if (prioritaList != null) {
						for (int j = 0; j < prioritaList.size(); j++) {
							SiceeDPriorita priorita = prioritaList.get(j);
							if (obj.getPriorita()
									.equals(priorita.getPriorita())) {
								r.setDescrPriorita(priorita.getDescr());
								break;
							}
						}

					}

					if (obj.getPriorita() != null
							&& obj.getPriorita().startsWith("1")) {
						raccAlta.add(r);
					} else if (obj.getPriorita() != null
							&& obj.getPriorita().startsWith("2")) {
						raccMedia.add(r);
					} else {
						raccBassa.add(r);
					}
				}
				racc.addAll(raccAlta);
				racc.addAll(raccMedia);
				racc.addAll(raccBassa);
			}

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return racc;
	}

	/**
	 * Recupera priorita.
	 *
	 * @return the list
	 * @throws SiceeDPrioritaDaoException the sicee d priorita dao exception
	 */
	public List<SiceeDPriorita> recuperaPriorita()
			throws SiceeDPrioritaDaoException {
		return this.getSiceeDPrioritaDao().findAll();
	}

	/**
	 * Map to model from db.
	 *
	 * @param obj0 the obj0
	 * @param obj1 the obj1
	 * @param obj2 the obj2
	 * @param obj3 the obj3
	 * @param obj4 the obj4
	 * @param obj5 the obj5
	 * @param obj7 the obj7
	 * @param obj8 the obj8
	 * @param obj9 the obj9
	 * @param obj10 the obj10
	 * @param objProg the obj prog
	 * @param objDirLav the obj dir lav
	 * @param objCostr the obj costr
	 * @return the dati attestato
	 * @throws BEException the bE exception
	 */
	private DatiAttestato mapToModelFromDB(SiceeTClasseEnergetica obj0,
			SiceeTConsumiEdificio obj1, SiceeTDatiGenerali obj2,
			SiceeTEnergiaSoprIngr obj3, SiceeTFabbisogno obj4,
			SiceeTImpRiscaldamentoAcs obj5, SiceeTRispettoNormative obj7,
			SiceeTAltreInfo obj8, SiceeTCertificato obj9,
			List<SiceeTDaticatastSec> obj10, SiceeTRuoliEdificio objProg,
			SiceeTRuoliEdificio objDirLav, SiceeTRuoliEdificio objCostr)
			throws BEException {

		DatiAttestato ret = new DatiAttestato();
		try {
			DtAltreInfo altreInfo = new DtAltreInfo();
			// SiceeTAltreInfo
			altreInfo.setFlgEdificioPerformante(BaseMgr.convertToBoolean(obj9
					.getFlgEdificioPerformante()));
			altreInfo.setFlgSigmater(BaseMgr.convertToBoolean(obj9
					.getFlgSigmater()));
			DtAIEnergetiche ener = new DtAIEnergetiche();
			ener.setClasseEnergEdificio(this.convertToString(obj8
					.getFkClasse19205()));
			ener.setPrestEnergRaggiungibile(this.convertTo(obj8
					.getPrestazioneEne()));
			ener.setLimNormaNazRiscald(this.convertTo(obj8.getLimiteNormaRisc()));
			ener.setQualitaInvolucroRaffresc(this.convertToString(obj8
					.getFkQualitaInvo()));
			// ener.setLimNormaNazImpTermico(convertTo(obj8.getLimiteNormaImp()));spostato
			ener.setPrestazPompaCalore(this.convertTo(obj8.getValorePrestPdc()));
			ener.setLimNormaPrestPompa(this.convertTo(obj8.getLimiteNormaPdc()));
			ener.setAltreInfo(obj8.getUltInfo());
			ener.setIndPrestEnergRiscald(this.convertTo(obj8.getIndRiscEpiNaz()));

			DtAIGenerali gen = new DtAIGenerali();

			gen.setMotivoRilascio(this.convertToString(obj8.getFkMotivo()));
			gen.setMetodoCalcolo(obj8.getMetodologiaCalcolo());
			gen.setDenomProduttore(obj8.getNomeProduttore());
			gen.setSoftware(obj8.getSwUtilizzato());
			gen.setRispondenzaUNITS11300(obj8.getUniTs11300());

			// SiceeTEnergiaSoprIngr

			DtAISopralluoghi sopr = new DtAISopralluoghi();
			sopr.setData(DateUtil.convertToUDTDateValid(obj3.getDtSopralluogo()));
			sopr.setNote(obj3.getNoteSoprall());
			sopr.setTipoRedazione(this.convertToString(obj3.getFkDati()));

			altreInfo.setEnergetiche(ener);
			altreInfo.setGenerali(gen);
			altreInfo.setSopralluoghi(sopr);

			ret.setAltreInfo(altreInfo);

			DtClasseEnerg classeEnerg = new DtClasseEnerg();
			// SiceeTClasseEnergetica

			DtLocReale reale = new DtLocReale();
			DtLocTeorica teor = new DtLocTeorica();

			teor.setDomEnergAcqua(this.convertTo(obj0.getDomAcsQhwto()));
			teor.setDomEnergRiscald(this.convertTo(obj0.getDomRiscQhto()));
			teor.setEnergTermAcquaRinnov(this.convertTo(obj0.getEnAcsRinnoTo()));

			teor.setIndPrestEnergAcqua(this.convertTo(obj0.getFabbAcsTo()));
			teor.setClasseEnerg(this.convertToString(obj0.getFkClasse()));

			if (teor.getClasseEnerg() != null) {
				teor.setDescClasseEnerg(this.getSiceeDClasseEnergeticaDao()
						.findByPrimaryKey(obj0.getFkClasse()).getDescr());
			}

			reale.setIndPrestEnergCondiz(this.convertTo(obj0.getIndCondEst()));
			reale.setIndPrestEnergGlob(this.convertTo(obj0.getIndGlobEplordo()));

			teor.setIndPrestEnergGlob(this.convertTo(obj0.getIndGlobEplordoTo()));
			teor.setIndGlobLimiteTo(this.convertTo(obj0.getIndGlobLimiteTo()));

			reale.setIndPrestEnergIlluminaz(this.convertTo(obj0.getIndIllum()));
			reale.setIndPrestEnergRiscald(this.convertTo(obj0.getIndRiscEpi()));

			teor.setIndPrestEnergRiscald(this.convertTo(obj0.getIndRiscEpito()));
			teor.setLimNormaRegione(this.convertTo(obj0.getLimiteRegQhto()));
			teor.setRendGlobStagioneAcqua(new UDTPositiveDoubleFive(obj0
					.getRendAcsEtagAcsto()));

			reale.setRendDistrib(this.convertTo(obj0.getRendDistrib()));
			reale.setRendEmissione(this.convertTo(obj0.getRendEmiss()));
			reale.setRendGeneraz(this.convertTo(obj0.getRendGener()));
			reale.setRendGlobTermico(this.convertTo(obj0.getRendImpEtag()));
			reale.setRendRegolaz(this.convertTo(obj0.getRendRegol()));

			teor.setServEnergInclusi(obj0.getServiziEnergetici());

			classeEnerg.setLocReale(reale);
			classeEnerg.setLocTeorica(teor);

			ret.setClasseEnerg(classeEnerg);

			DtConsumiReali consumiReali = new DtConsumiReali();

			// SiceeTConsumiEdificio

			consumiReali.setAnnoElettricoFossile(this.convertTo(obj1
					.getAnnElettFossile()));
			consumiReali.setAnnoElettricoRinnov(this.convertTo(obj1
					.getAnnElettRinno()));
			consumiReali.setAnnoTermicoFossile(this.convertTo(obj1
					.getAnnTermiFossile()));
			consumiReali.setAnnoTermicoRinnov(this.convertTo(obj1
					.getAnnTermiRinno()));
			consumiReali.setMedioElettrico(this.convertTo(obj1
					.getComplessElettrico()));
			consumiReali.setMedioTermico(this.convertTo(obj1
					.getComplessTermico()));

			ret.setConsumiReali(consumiReali);

			DtImpianti impianti = new DtImpianti();

			impianti.setTipoDistrib(obj1.getDescTipoDistrib());
			impianti.setTipoTermErogaz(obj1.getDescTipoErog());
			impianti.setTipoRegolaz(obj1.getDescTipoReg());
			impianti.setFlgRipartizione(obj1.getFlgContRip());
			impianti.setUiServite(obj1.getUiServite());

			ret.setImpianti(impianti);

			DtTecniciGen tecniciGen = new DtTecniciGen();
			// SiceeTDatiGenerali

			tecniciGen.setFlagUsoPubblico(obj2.getFlagUsoPubblico());
			tecniciGen.setAnnoCostr(this.convertToString(obj2
					.getAnnoCostruzione()));
			tecniciGen.setAnnoUltimaRistrutt(this.convertToString(obj2
					.getAnnoUltRist()));
			tecniciGen.setDestUso(this.convertToString(obj2.getFkDestUso()));
			tecniciGen.setTipoImpianto(this.convertToString(obj1
					.getFkTipoImpianto()));

			tecniciGen.setCarattEdificio(this.convertToString(obj2
					.getFkCarattEdificio()));

			if (tecniciGen.getCarattEdificio() != null) {
				tecniciGen.setTipoEdificio(this.convertToString(this
						.getSiceeDCarattEdificioDao()
						.findByPrimaryKey(obj2.getFkCarattEdificio())
						.getFkTipoEdificio()));
				// tecniciGen.setTipoImpianto(convertToString(getSiceeDTipoEdificioDao().findByPrimaryKey(convertToInteger(tecniciGen.getTipoEdificio())).getFkTipoImpianto()));
			}

			tecniciGen.setTipoImpianto(this.convertToString(obj1
					.getFkTipoImpianto()));

			tecniciGen.setDescrizioneEdificio(obj2.getDescTipoEdificio());
			tecniciGen.setSuperficieUtile(this.convertTo(obj2.getSu()));
			tecniciGen
					.setSupDispTot(this.convertTo(obj2.getSupDisperdenteTot()));
			tecniciGen.setTrasmittanzaOpache(this.convertTo(obj2
					.getTrasmOpache()));
			tecniciGen
					.setTrasmittanzaTrasp(this.convertTo(obj2.getTrasmTrasp()));
			tecniciGen.setVolLordoRiscald(this.convertTo(obj2
					.getVolLordoRiscaldato()));
			tecniciGen.setFattoreForma(this.convertTo(obj2.getFattoreForma()));

			ret.setDatiTecnici(tecniciGen);

			DtAnagImmobile anagImmobile = new DtAnagImmobile();

			// SiceeTCertificato

			DtCatastali cat = new DtCatastali();
			DtCoCertificatore coCert = new DtCoCertificatore();

			cat.setCodProv(obj9.getIdProv());
			cat.setDescrProv(obj9.getDescProv());
			cat.setCodComune(obj9.getIdComune());
			cat.setDescrComune(obj9.getDescComune());
			cat.setCodIndirizzo(obj9.getIdIndirizzo());
			cat.setDescrIndirizzo(obj9.getDescIndirizzo());
			cat.setNumCiv(obj9.getNumCivico());

			// Beppe 10/01/2012
			// cat.setFlgCondominio(obj9.getFlgCondominio());
			
			
			cat.setCap(obj9.getCap());
			cat.setSezione(obj9.getSezione());
			cat.setFoglio(obj9.getFoglio());
			cat.setParticella(obj9.getParticella());
			cat.setSubalterno(obj9.getSubalterno());
			cat.setPiano(obj9.getPiano());
			cat.setPianiTot(this.convertTo(obj9.getNumPianiComplessivi()));
			cat.setNumUnita(this.convertTo(obj9.getNumAppartamenti()));
			cat.setScala(obj9.getScala());
			cat.setInterno(obj9.getInterno());
			cat.setNote(obj9.getNote());
			cat.setNomeFoto(obj9.getNomeFoto());
			cat.setUidFoto(obj9.getIdentificFoto());
			cat.setUidDoc(obj9.getIdentificPdf());
			cat.setNomeDoc(obj9.getNomePdf());
			cat.setDataUpFoto(DateUtil.convertToStringDataCompleta(obj9
					.getDtFoto()));

			cat.setGradiGiorno(this.convertTo(obj2.getGradiGiorno()));
			cat.setZonaClimatica(obj2.getZonaClimatica());
			cat.setNumPianiFtRisc(convertTo(obj9.getNumPianiFTRisc()));

			ret.setStatus(obj9.getFkStato());
			ret.setDataScadenza(DateUtil.convertToString(obj9.getDtScadenza()));
			ret.setDataUpload(DateUtil.convertToString(obj9.getDtUpload()));

			coCert.setNome(obj9.getNomeCocertificatore());
			coCert.setCognome(obj9.getCognomeCocertificatore());
			coCert.setNumMatricola(obj9.getNumCocertificatore());

			// SEQ_SICEE_T_DATICATAST_SEC
			ArrayList<DtCatastaliSecondari> listDtCatastaliSecondari = new ArrayList<DtCatastaliSecondari>();
			for (int i = 0; i < obj10.size(); i++) {
				SiceeTDaticatastSec tDaticatastSec = obj10.get(i);

				DtCatastaliSecondari datCatSec = new DtCatastaliSecondari();
				datCatSec.setId("" + i);
				datCatSec.setCodProv(tDaticatastSec.getIdProv());

				datCatSec.setDescrProv(tDaticatastSec.getDescProv());
				datCatSec.setCodComune(tDaticatastSec.getIdComune());
				datCatSec.setDescrComune(tDaticatastSec.getDescComune());
				datCatSec.setSezione(tDaticatastSec.getSezione());
				datCatSec.setFoglio(tDaticatastSec.getFoglio());
				datCatSec.setParticella(tDaticatastSec.getParticella());
				datCatSec.setSubalterno(tDaticatastSec.getSubalterno());
				listDtCatastaliSecondari.add(datCatSec);

			}

			cat.setDtCatastaliSecondari(listDtCatastaliSecondari);

			anagImmobile.setDtCatastali(cat);
			anagImmobile.setDtCoCertificatore(coCert);

			DtResponsabili resp = new DtResponsabili();

			SoggResponsabile prog = new SoggResponsabile();

			prog.setNome(objProg.getNome());
			prog.setCognome(objProg.getCognome());
			prog.setCodIndirizzo(objProg.getIdIndirizzo());
			prog.setDescrIndirizzo(objProg.getDescIndirizzo());
			prog.setCap(objProg.getCap());
			prog.setCodComune(objProg.getIdComune());
			prog.setDescrComune(objProg.getDescComune());
			prog.setCodProv(objProg.getIdProvincia());
			prog.setDescrProv(objProg.getDescProvincia());
			prog.setCodReg(objProg.getIdRegione());
			prog.setDescrReg(objProg.getDescRegione());
			prog.setTel(objProg.getTelefono());
			prog.setCell(objProg.getCell());
			prog.setFax(objProg.getFax());
			prog.setEmail(objProg.getEmail());
			prog.setNumCiv(objProg.getNumCivico());

			SoggResponsabile dirLav = new SoggResponsabile();

			dirLav.setNome(objDirLav.getNome());
			dirLav.setCognome(objDirLav.getCognome());
			dirLav.setCodIndirizzo(objDirLav.getIdIndirizzo());
			dirLav.setDescrIndirizzo(objDirLav.getDescIndirizzo());
			dirLav.setCap(objDirLav.getCap());
			dirLav.setCodComune(objDirLav.getIdComune());
			dirLav.setDescrComune(objDirLav.getDescComune());
			dirLav.setCodProv(objDirLav.getIdProvincia());
			dirLav.setDescrProv(objDirLav.getDescProvincia());
			dirLav.setCodReg(objDirLav.getIdRegione());
			dirLav.setDescrReg(objDirLav.getDescRegione());
			dirLav.setTel(objDirLav.getTelefono());
			dirLav.setCell(objDirLav.getCell());
			dirLav.setFax(objDirLav.getFax());
			dirLav.setEmail(objDirLav.getEmail());
			dirLav.setNumCiv(objDirLav.getNumCivico());

			SoggResponsabile costr = new SoggResponsabile();

			costr.setNome(objCostr.getNome());
			costr.setCognome(objCostr.getCognome());
			costr.setCodIndirizzo(objCostr.getIdIndirizzo());
			costr.setDescrIndirizzo(objCostr.getDescIndirizzo());
			costr.setCap(objCostr.getCap());
			costr.setCodComune(objCostr.getIdComune());
			costr.setDescrComune(objCostr.getDescComune());
			costr.setCodProv(objCostr.getIdProvincia());
			costr.setDescrProv(objCostr.getDescProvincia());
			costr.setCodReg(objCostr.getIdRegione());
			costr.setDescrReg(objCostr.getDescRegione());
			costr.setTel(objCostr.getTelefono());
			costr.setCell(objCostr.getCell());
			costr.setFax(objCostr.getFax());
			costr.setEmail(objCostr.getEmail());
			costr.setNumCiv(objCostr.getNumCivico());

			resp.setDtCostruttore(costr);
			resp.setDtDirLavori(dirLav);
			resp.setDtProgettista(prog);
			anagImmobile.setDtResponsabili(resp);

			ret.setDatiAnagraficiImm(anagImmobile);

			DtDichiarazFinale dichiarazioneFinale = new DtDichiarazFinale();

			// SiceeTCertificato

			dichiarazioneFinale.setCodDichiaraz(obj9.getFkDichiarazione());
			dichiarazioneFinale.setDataDichiarazione(DateUtil
					.convertToUDTDateValid(obj9.getDtInizio()));
			dichiarazioneFinale.setLuogoDichiarazione(obj9
					.getLuogoDichiarazione());

			ret.setDichiarazioni(dichiarazioneFinale);

			DtEnergiaFontiRinnov energiaFontiRinnov = new DtEnergiaFontiRinnov();

			// SiceeTEnergiaSoprIngr

			energiaFontiRinnov.setAutoconsumoElettrico(this.convertTo(obj3
					.getAutoconsElett()));
			energiaFontiRinnov.setAutoconsumoTermico(this.convertTo(obj3
					.getAutoconsTermico()));
			energiaFontiRinnov.setEnergElettricaProdotta(this.convertTo(obj3
					.getEnElettProd()));
			energiaFontiRinnov.setEnergTermicaProdotta(this.convertTo(obj3
					.getEnTermicaProd()));
			energiaFontiRinnov.setTechFontiRinnov(obj3.getTecnoRinno());
			energiaFontiRinnov.setAnnoInstall(this.convertToString(obj3
					.getAnnoInstall()));
			energiaFontiRinnov.setPercEnergiaFontiRinnov(BaseMgr
					.convertToDoubleTwo(obj3.getPercFontiRinnov()));

			ret.setEnergRinnov(energiaFontiRinnov);

			DtGasSerra gasSerra = new DtGasSerra();

			// SiceeTDatiGenerali

			gasSerra.setEmissioniGasSerra(this.convertTo(obj2
					.getEmissioniSerra()));
			gasSerra.setSupBoscoEquiv(this.convertToDoubleFive(obj2
					.getEttariBosco()));

			ret.setGasSerra(gasSerra);

			// DtImpianti impianti = new DtImpianti();
			// SiceeTImpRiscaldamentoAcs

			DtImpRiscald risc = new DtImpRiscald();
			DtImpAcqua acqua = new DtImpAcqua();

			risc.setCodImpianto(obj5.getCodiceImpianto());
			acqua.setClasseEfficienzaEnerg(this.convertToString(obj5
					.getFkClasseEffAcs()));
			risc.setClasseEfficienzaEnerg(this.convertToString(obj5
					.getFkClasseEffRisc()));
			acqua.setCombustibileFossile(this.convertToString(obj5
					.getFkCombustibileAcs()));
			risc.setCombustibileFossile(this.convertToString(obj5
					.getFkCombustibileRisc()));
			risc.setFlgBollino(obj5.getFlgBollino());
			acqua.setAnnoInstallGeneratore(this.convertToString(obj5
					.getGenAnnoAcs()));
			risc.setAnnoInstallGeneratore(this.convertToString(obj5
					.getGenAnnoRisc()));
			risc.setNumBollino(obj5.getNumeroBollino());
			acqua.setPotNomCompl(this.convertTo(obj5.getPotAcs()));
			risc.setPotNomCompl(this.convertTo(obj5.getPotRiscaldamento()));
			risc.setLimNormRegImpTerm(this.convertTo(obj8.getLimiteNormaImp()));

			impianti.setAcqua(acqua);
			impianti.setRiscaldamento(risc);

			ret.setImpianti(impianti);

			DtIndiciFabbisogno indiciFabbisogno = new DtIndiciFabbisogno();

			// SiceeTFabbisogno

			if (obj4.getDomAcsQhw() != null && obj4.getDomAcsQhw() == 0) {
				indiciFabbisogno.setFabAcquaCaldaSanit(Constants.NO);
			} else {
				indiciFabbisogno.setFabAcquaCaldaSanit(Constants.SI);
			}

			indiciFabbisogno.setDomEnergAcqua(this.convertTo(obj4
					.getDomAcsQhw()));
			indiciFabbisogno.setDomEnergRiscald(this.convertTo(obj4
					.getDomRiscQh()));
			indiciFabbisogno.setEnergTermAcquaRinnov(this.convertTo(obj4
					.getEnAcsRinno()));
			indiciFabbisogno.setIndPrestEnergAcqua(this.convertTo(obj4
					.getFabbAcs()));
			indiciFabbisogno.setFabbCondizionamento(this.convertTo(obj4
					.getFabbCondiz()));
			indiciFabbisogno.setIndPrestEnergIlluminaz(this.convertTo(obj4
					.getFabbIllum()));
			indiciFabbisogno.setLimNormRegione(this.convertTo(obj4
					.getLimiteRegQhLim()));
			indiciFabbisogno
					.setRendGlobStagioneAcqua(new UDTPositiveDoubleFive(obj4
							.getRendAcsEtagacs()));

			ret.setIndFabbisogno(indiciFabbisogno);

			DtRispettoNorme rispettoNorme = new DtRispettoNorme();

			// SiceeTRispettoNormative

			rispettoNorme.setDataTitolo(DateUtil.convertToUDTDateValid(obj7
					.getDtTitolo()));
			rispettoNorme.setCodNorma(this.convertToString(obj7.getFkNorma()));
			if (obj7.getFkNorma() != null) {
				rispettoNorme.setDescrNorma(this.getSiceeDNormativaDao()
						.findByPrimaryKey(obj7.getFkNorma()).getDescr());
			}
			rispettoNorme.setAutorizzato(obj7.getFlgNorma());
			rispettoNorme.setMotivoNonConformita(obj7.getMotivoNonConformita());
			rispettoNorme.setNote(obj7.getNote());

			ret.setRispNorme(rispettoNorme);
			
			ret.setFlgOldApe(this.convertToBoolean(obj9.getFlgOld()));

			ret.setStatus(obj9.getFkStato());
		} catch (Exception e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Map to model from db.
	 *
	 * @param obj0 the obj0
	 * @param obj1 the obj1
	 * @param obj2 the obj2
	 * @param obj3 the obj3
	 * @param obj4 the obj4
	 * @param obj5 the obj5
	 * @param obj7 the obj7
	 * @param obj8 the obj8
	 * @param obj9 the obj9
	 * @param obj10 the obj10
	 * @param objProg the obj prog
	 * @param objDirLav the obj dir lav
	 * @param objCostr the obj costr
	 * @return the dati attestato
	 * @throws BEException the bE exception
	 */
	private DatiAttestato mapToModelFromDB(SiceeTDatiGenerali obj2, SiceeTCertificato obj9, List<SiceeTFoto2015> objFotoList, SiceeTAltreInfo obj8)
			throws BEException {

		DatiAttestato ret = new DatiAttestato();
		try {

			
			DtAIGenerali aIGenerali = new DtAIGenerali();
			aIGenerali.setMotivoRilascio(this.convertToString(obj8.getFkMotivo()));
			aIGenerali.setAltroServiziEnergia(this.convertToString(obj8.getAltroServiziEnergia()));

			DtAltreInfo altreInfo = new DtAltreInfo();
			// SiceeTAltreInfo
			altreInfo.setGenerali(aIGenerali);
			
			// Alex: remmate 28/09/2016: da tenere a mente
			//altreInfo.setFlgEdificioPerformante(BaseMgr.convertToBoolean(obj9
					//.getFlgEdificioPerformante()));
			//altreInfo.setFlgSigmater(BaseMgr.convertToBoolean(obj9
					//.getFlgSigmater()));
			
			ret.setAltreInfo(altreInfo);

			DtTecniciGen tecniciGen = new DtTecniciGen();
			// SiceeTDatiGenerali

			tecniciGen.setOggetto(this.convertToString(obj2.getFkOggettoApe()));

			tecniciGen.setFlagUsoPubblico(obj2.getFlagUsoPubblico());
			tecniciGen.setAnnoCostr(this.convertToString(obj2
					.getAnnoCostruzione()));
			tecniciGen.setAnnoUltimaRistrutt(this.convertToString(obj2
					.getAnnoUltRist()));
			
			
			tecniciGen.setDestUso(this.convertToString(obj2.getFkDestUso2015()));
			if (tecniciGen.getDestUso() != null) {
				SiceeDDestUso2015 destUso2015 = this
				.getSiceeDDestUso2015Dao()
				.findByPrimaryKey(obj2.getFkDestUso2015());
				
				if (destUso2015 != null)
				{
					tecniciGen.setDescDestUso(destUso2015.getSigla() + " " + destUso2015.getDescr());
					// tecniciGen.setTipoImpianto(convertToString(getSiceeDTipoEdificioDao().findByPrimaryKey(convertToInteger(tecniciGen.getTipoEdificio())).getFkTipoImpianto()));
				}
			}
			
			tecniciGen.setCodEdificioScolastico(obj2.getCodiceEdificioScolastico());


			tecniciGen.setCarattEdificio(this.convertToString(obj2
					.getFkCarattEdificio()));

			if (tecniciGen.getCarattEdificio() != null) {
				tecniciGen.setTipoEdificio(this.convertToString(this
						.getSiceeDCarattEdificioDao()
						.findByPrimaryKey(obj2.getFkCarattEdificio())
						.getFkTipoEdificio()));
				// tecniciGen.setTipoImpianto(convertToString(getSiceeDTipoEdificioDao().findByPrimaryKey(convertToInteger(tecniciGen.getTipoEdificio())).getFkTipoImpianto()));
			}
			
			tecniciGen.setDescrizioneEdificio(obj2.getDescTipoEdificio());
			tecniciGen.setSuperficieUtile(this.convertTo(obj2.getSu()));
			tecniciGen
					.setSupDispTot(this.convertTo(obj2.getSupDisperdenteTot()));
			tecniciGen.setTrasmittanzaOpache(this.convertTo(obj2
					.getTrasmOpache()));
			tecniciGen
					.setTrasmittanzaTrasp(this.convertTo(obj2.getTrasmTrasp()));
			tecniciGen.setVolLordoRiscald(this.convertTo(obj2
					.getVolLordoRiscaldato()));
			tecniciGen.setFattoreForma(this.convertTo(obj2.getFattoreForma()));

			String tmpVal = null;
			try{tmpVal = Integer.toString(obj2.getFkTipoRistrutturaz());} catch(Exception e){tmpVal = null;}
			tecniciGen.setTipoRistrutturazione(tmpVal);
			try{tmpVal = Integer.toString(obj2.getFkTipolEdilizia());} catch(Exception e){tmpVal = null;}
			tecniciGen.setTipolEdilizia(tmpVal);
			try{tmpVal = Integer.toString(obj2.getFkTipolCostruttiva());} catch(Exception e){tmpVal = null;}
			tecniciGen.setTipolCostruttiva(tmpVal);
			try{tmpVal = Integer.toString(obj2.getFkProprietaEdi());} catch(Exception e){tmpVal = null;}
			tecniciGen.setProprEdificio(tmpVal);

			ret.setDatiTecnici(tecniciGen);

			DtDichiarazFinale dichiarazioneFinale = new DtDichiarazFinale();

			dichiarazioneFinale.setCodDichiaraz(obj9.getFkDichiarazione());

			dichiarazioneFinale.setLuogoDichiarazione(obj9
					.getLuogoDichiarazione());

			ret.setDichiarazioni(dichiarazioneFinale);
			
			DtAnagImmobile anagImmobile = new DtAnagImmobile();

			// SiceeTCertificato

			DtCatastali cat = new DtCatastali();

			cat.setCodProv(obj9.getIdProv());
			cat.setDescrProv(obj9.getDescProv());
			cat.setCodComune(obj9.getIdComune());
			cat.setDescrComune(obj9.getDescComune());
			
			cat.setCodIndirizzo(obj9.getIdIndirizzo());
			cat.setDescrIndirizzo(obj9.getDescIndirizzo());
			
			cat.setNumCiv(obj9.getNumCivico());
			
			
			if (obj9.getFkStato() != null && obj9.getFkStato().intValue() != Constants.NUOVO)
			{
				log.debug("****************COORDINATA NORD LETTA DA DB=" + obj9.getCoordN());
				log.debug("****************COORDINATA NORD TRASFORMATA DA DB=" + Double.toString(obj9.getCoordN()));

				/*
				java.math.BigDecimal coordN = new java.math.BigDecimal(obj9.getCoordN());
				if (coordN.setScale(8, java.math.BigDecimal.ROUND_DOWN).compareTo(coordN.setScale(0, java.math.BigDecimal.ROUND_DOWN)) != 0)
					coordN = coordN.setScale(8, java.math.BigDecimal.ROUND_DOWN);
				else
					coordN = coordN.setScale(0, java.math.BigDecimal.ROUND_DOWN);
				*/
				java.math.BigDecimal coordN = Converter.convertToBigDecimal(obj9.getCoordN());

				cat.setCoordN(coordN.toString());
				
				log.debug("****************COORDINATA EST LETTA DA DB=" + obj9.getCoordE());
				log.debug("****************COORDINATA EST TRASFORMATA DA DB=" + Double.toString(obj9.getCoordE()));

				/*
				java.math.BigDecimal coordE = new java.math.BigDecimal(obj9.getCoordE());
				if (coordE.setScale(8, java.math.BigDecimal.ROUND_DOWN).compareTo(coordE.setScale(0, java.math.BigDecimal.ROUND_DOWN)) != 0)
					coordE = coordE.setScale(8, java.math.BigDecimal.ROUND_DOWN);
				else
					coordE = coordE.setScale(0, java.math.BigDecimal.ROUND_DOWN);
				*/
				java.math.BigDecimal coordE = Converter.convertToBigDecimal(obj9.getCoordE());
				cat.setCoordE(coordE.toString());
			}
			
			if (obj9.getFkStato() == null || obj9.getFkStato().intValue() == Constants.NUOVO
					|| obj9.getFkStato().intValue() == Constants.BOZZA)
			{
				
				dichiarazioneFinale.setDataDichiarazione(DateUtil
						.convertToUDTDateValid(new Date()));
				
			}
			else
			{
				dichiarazioneFinale.setDataDichiarazione(DateUtil
						.convertToUDTDateValid(obj9.getDtInizio()));
			}

			// Beppe 10/01/2012
			// cat.setFlgCondominio(obj9.getFlgCondominio());

			cat.setCap(obj9.getCap());
			cat.setSezione(obj9.getSezione());
			cat.setFoglio(obj9.getFoglio());
			cat.setParticella(obj9.getParticella());
			cat.setSubalterno(obj9.getSubalterno());
			cat.setPiano(obj9.getPiano());
			cat.setPianiTot(this.convertTo(obj9.getNumPianiComplessivi()));
			cat.setNumUnita(this.convertTo(obj9.getNumAppartamenti()));
			cat.setScala(obj9.getScala());
			cat.setInterno(obj9.getInterno());
			cat.setNote(obj9.getNote());
			cat.setUidDoc(obj9.getIdentificPdf());
			cat.setNomeDoc(obj9.getNomePdf());
			cat.setNumPianiFtRisc(convertTo(obj9.getNumPianiFTRisc()));

			
			if (!isNullOrEmpty(obj9.getRifCatasto()))
			{
				cat.setSistCatast(obj9.getRifCatasto());
			}
			else
			{
				cat.setSistCatast(Constants.ID_RIF_CATASTO_NCEU);
			}

			log.debug("**** CertificatoMgr - mapToModelFromDB - CODICE COMUNE CATASTALE: " + obj9.getCodiceComuneCatastale());

			cat.setCodComuneCatasto(obj9.getCodiceComuneCatastale());
			

			
			if (objFotoList != null && objFotoList.size() > 0)
			{
				//ALEX ADV MOD START
				//SiceeTFoto2015 objFoto = objFotoList.get(0); // Per adesso ne gestiamo solo una
				//cat.setIdFoto(objFoto.getIdFoto());
				//cat.setNomeFoto(objFoto.getNomeFoto());
				//cat.setUidFoto(objFoto.getIdentificFoto());
				//cat.setDataUpFoto(DateUtil.convertToStringDataCompleta(objFoto.getDtFoto()));
				
				DtFoto dtFoto = null;
				ArrayList<DtFoto> dtFotoList = new ArrayList<DtFoto>();
				for (SiceeTFoto2015 theFoto : objFotoList) {
					if (theFoto.getFlgPrincipale().equals("S")) {
						SiceeDTipoFoto2015 tipoFoto = this.recuperaTipoFoto2015(theFoto.getFkTipoFoto());
						cat.setIdFoto(theFoto.getIdFoto());
						cat.setNomeFoto(theFoto.getNomeFoto());
						cat.setDescTipoFoto(tipoFoto.getDescr());
						cat.setUidFoto(theFoto.getIdentificFoto());
						cat.setDataUpFoto(DateUtil.convertToStringDataCompleta(theFoto.getDtFoto()));						
						cat.setPreviewBase64(this.recuperaPreviewFotoByUid(theFoto.getIdentificFoto()));
					} else {
						dtFoto = new DtFoto();
						SiceeDTipoFoto2015 tipoFoto = this.recuperaTipoFoto2015(theFoto.getFkTipoFoto());
						dtFoto.setIdFoto(theFoto.getIdFoto());
						dtFoto.setNomeFoto(theFoto.getNomeFoto());
						dtFoto.setDescTipoFoto(tipoFoto.getDescr());
						dtFoto.setUidFoto(theFoto.getIdentificFoto());
						dtFoto.setDataUpFoto(DateUtil.convertToStringDataCompleta(theFoto.getDtFoto()));
						dtFoto.setFlgPrincipale(theFoto.getFlgPrincipale());
						dtFoto.setPreviewBase64(this.recuperaPreviewFotoByUid(theFoto.getIdentificFoto()));
						dtFotoList.add(dtFoto);
					}
				}
				cat.setDtFoto(dtFotoList);
				//ALEX ADV MOD END
			}
			
			//cat.setGradiGiorno(this.convertTo(obj2.getGradiGiorno()));
			cat.setZonaClimatica(obj2.getZonaClimatica());

			ret.setStatus(obj9.getFkStato());
			
			ret.setIdScadenza(obj9.getFkScadenzaCert());
			ret.setDataScadenza(DateUtil.convertToString(obj9.getDtScadenza()));
			ret.setDataUpload(DateUtil.convertToString(obj9.getDtUpload()));
			// Setto la Dichiarazione di conformita'
			dichiarazioneFinale.setCodDichiaraz(obj9.getFkDichiarazione());
			
			DtCoCertificatore dtCoCertificatore = new DtCoCertificatore();
			dtCoCertificatore.setNome(obj9.getNomeCocertificatore());
			dtCoCertificatore.setCognome(obj9.getCognomeCocertificatore());
			dtCoCertificatore.setNumMatricola(obj9.getNumCocertificatore());
			dtCoCertificatore.setCodFisc(obj9.getCodFiscCocertificatore());
			
			anagImmobile.setDtCoCertificatore(dtCoCertificatore);
			
			anagImmobile.setDtCatastali(cat);

			ret.setDatiAnagraficiImm(anagImmobile);




			ret.setFlgOldApe(this.convertToBoolean(obj9.getFlgOld()));
			ret.setStatus(obj9.getFkStato());
		} catch (Exception e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Aggiorna attestato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param appDataRacc the app data racc
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void aggiornaAttestato(DatiCertificatore cert, DatiAttestato att,
			ArrayList<Raccomandazione> appDataRacc) throws BEException {

		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if (att.getStatus() != null && att.getStatus() > Constants.BOZZA) {
			return;
		}
		*/
		if ((att.getStatus() != null) && 
				((att.getStatus() == Constants.CONSOLIDATO)
						|| (att.getStatus() == Constants.INVIATO) 
						|| (att.getStatus() == Constants.ANNULLATO)
						|| (att.getStatus() == Constants.DA_INVIARE)
						|| (att.getStatus() == Constants.SOSPESO)
						|| (att.getStatus() == Constants.CANCELLATO)
						|| (att.getStatus() == Constants.ANNULLATO_BO))) {
			return;
		}

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		try {
			List<SiceeTRaccomandazioni> racc = this
					.getSiceeTRaccomandazioniDao().findBySiceeTCertificato(id,
							prog, anno);
			if (racc != null) {
				Iterator<SiceeTRaccomandazioni> iter = racc.iterator();
				while (iter.hasNext()) {
					SiceeTRaccomandazioni r = iter.next();
					this.getSiceeTRaccomandazioniDao().delete(r.createPk());
				}
			}
			if (appDataRacc != null && appDataRacc.size() > 0) {
				for (int i = 0; i < appDataRacc.size(); i++) {
					this.getSiceeTRaccomandazioniDao().insert(
							this.mapToDBRaccomandazione(appDataRacc.get(i), id,
									prog, anno));
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Map to db raccomandazione.
	 *
	 * @param raccomandazione the raccomandazione
	 * @param id the id
	 * @param prog the prog
	 * @param anno the anno
	 * @return the sicee t raccomandazioni
	 */
	private SiceeTRaccomandazioni mapToDBRaccomandazione(
			Raccomandazione raccomandazione, String id, String prog, String anno) {

		SiceeTRaccomandazioni dto = new SiceeTRaccomandazioni();
		dto.setIdCertificatore(id);
		dto.setProgrCertificato(prog);
		dto.setAnno(anno);
		dto.setPriorita(raccomandazione.getPriorita());
		dto.setSistema(raccomandazione.getCodSistema());
		dto.setIntervento(raccomandazione.getIntervento());
		dto.setTempoRitorno(raccomandazione.getTempoRitorno());

		return dto;
	}

	/**
	 * Aggiorna dati catastali.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param appDataRacc the app data racc
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void aggiornaDatiCatastali(DatiCertificatore cert,
			DatiAttestato att, ArrayList<DtCatastaliSecondari> appDataRacc)
			throws BEException {

		// Vecchia espressione della condizione tramite operatore logico >
		// sostituita con elencazione completa degli stati
		// perchè rigida e potenzialmente instabile 
		/*
		if (att.getStatus() != null && att.getStatus() > Constants.BOZZA) {
			return;
		}
		*/
		if ((att.getStatus() != null) && 
				((att.getStatus() == Constants.CONSOLIDATO)
						|| (att.getStatus() == Constants.INVIATO) 
						|| (att.getStatus() == Constants.ANNULLATO)
						|| (att.getStatus() == Constants.DA_INVIARE)
						|| (att.getStatus() == Constants.SOSPESO)
						|| (att.getStatus() == Constants.CANCELLATO)
						|| (att.getStatus() == Constants.ANNULLATO_BO))) {
			return;
		}

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];

		try {
			List<SiceeTDaticatastSec> racc = this.getSiceeTDaticatastSecDao()
					.findBySiceeTCertificato(id, prog, anno);
			if (racc != null) {
				Iterator<SiceeTDaticatastSec> iter = racc.iterator();
				while (iter.hasNext()) {
					SiceeTDaticatastSec r = iter.next();
					this.getSiceeTDaticatastSecDao().delete(r.createPk());
				}
			}
			if (appDataRacc != null && appDataRacc.size() > 0) {
				for (int i = 0; i < appDataRacc.size(); i++) {
					this.getSiceeTDaticatastSecDao().insert(
							this.mapToDBDaticatastSec(appDataRacc.get(i), id,
									prog, anno));
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Map to db daticatast sec.
	 *
	 * @param datoCatastale the dato catastale
	 * @param id the id
	 * @param prog the prog
	 * @param anno the anno
	 * @return the sicee t daticatast sec
	 */
	private SiceeTDaticatastSec mapToDBDaticatastSec(
			DtCatastaliSecondari datoCatastale, String id, String prog,
			String anno) {

		SiceeTDaticatastSec dto = new SiceeTDaticatastSec();
		dto.setIdCertificatore(id);
		dto.setProgrCertificato(prog);
		dto.setAnno(anno);
		dto.setIdProv(datoCatastale.getCodProv());
		dto.setDescProv(datoCatastale.getDescrProv());

		dto.setIdComune(datoCatastale.getCodComune());
		dto.setDescComune(datoCatastale.getDescrComune());

		dto.setSezione(datoCatastale.getSezione());
		dto.setFoglio(datoCatastale.getFoglio());
		dto.setParticella(datoCatastale.getParticella());
		dto.setSubalterno(datoCatastale.getSubalterno());

		return dto;
	}

	/**
	 * Recupera gradi giorno e zona climatica.
	 *
	 * @param att the att
	 * @throws BEException the bE exception
	 */
	public DatiAttestato recuperaGradiGiornoEZonaClimatica(DatiAttestato att)
			throws BEException {
		try {
			SiceeDGradiGiorno dto = this.getSiceeDGradiGiornoDao()
					.findByPrimaryKey(
							att.getDatiAnagraficiImm().getDtCatastali()
									.getCodComune());
			if (dto != null) {
				att.getDatiAnagraficiImm().getDtCatastali()
						.setGradiGiorno(this.convertTo(dto.getGradiGiorno()));
				att.getDatiAnagraficiImm().getDtCatastali()
						.setZonaClimatica(dto.getZonaClimatica());
			} else {
				att.getDatiAnagraficiImm().getDtCatastali()
						.setGradiGiorno(null);
				att.getDatiAnagraficiImm().getDtCatastali()
						.setZonaClimatica(null);
			}
		} catch (NumberFormatException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeDGradiGiornoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		return att;
	}

	public SiceeDGradiGiorno recuperaZonaClimaticaDaIstatComune(String istatComune)
			throws BEException {
		try {
			SiceeDGradiGiorno dto = this.getSiceeDGradiGiornoDao()
					.findByPrimaryKey(istatComune);
			
			if (dto != null) {
				return dto;
			} else {
				return null;
			}
		} catch (SiceeDGradiGiornoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Gets the normativa vigente.
	 *
	 * @param att the att
	 * @return the normativa vigente
	 */
	public boolean getNormativaVigente(DatiAttestato att) {
		if (GenericUtil.isNullOrEmpty(att.getRispNorme().getDataTitolo())) {
			att.getRispNorme().setCodNorma(null);
			att.getRispNorme().setDescrNorma(null);
			att.getRispNorme().setAutorizzato(null);
			att.getRispNorme().setMotivoNonConformita(null);
			return true;
		}
		try {
			SiceeDNormativa norm = this.getSiceeDNormativaDao()
					.findWhereDtInizioBetweenDtFine(
							DateUtil.convertToDate(att.getRispNorme()
									.getDataTitolo()));
			if (norm == null) {
				return false;
			}
			att.getRispNorme().setCodNorma(
					this.convertToString(norm.getIdNorma()));
			att.getRispNorme().setDescrNorma(norm.getDescr());
		} catch (SiceeDNormativaDaoException e) {
			log.error(e.getMessage());
		} catch (BEException e) {
			log.error(e.getMessage());
		}
		return true;
	}

	/**
	 * Compila certificato per report.
	 *
	 * @param att the att
	 * @param cert the cert
	 * @return the ace dto
	 * @throws BEException the bE exception
	 */
	public AceDto compilaCertificatoPerReport(DatiAttestato att,
			DatiCertificatore cert) throws BEException {
		AceDto dto = new AceDto();
		log.debug("\n\n CertificatoMgr::compilaCertificatoPerReport");
		ArrayList<Raccomandazione> arrayList = (ArrayList<Raccomandazione>) this.recuperaRaccomandazioni(
				cert, att.getNumeroAttestato());

		DtAnagImmobile anagImmobile = att.getDatiAnagraficiImm();
		DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
		DtResponsabili rp = att.getDatiAnagraficiImm().getDtResponsabili();
		DtTecniciGen tg = att.getDatiTecnici();
		DtConsumiReali cr = att.getConsumiReali();
		DtImpRiscald impRisc = att.getImpianti().getRiscaldamento();
		DtImpAcqua impAcqua = att.getImpianti().getAcqua();
		DtIndiciFabbisogno fab = att.getIndFabbisogno();
		DtLocTeorica teo = att.getClasseEnerg().getLocTeorica();
		DtLocReale rea = att.getClasseEnerg().getLocReale();
		DtEnergiaFontiRinnov efr = att.getEnergRinnov();
		DtGasSerra gs = att.getGasSerra();
		DtAIEnergetiche aien = att.getAltreInfo().getEnergetiche();
		DtAIGenerali aieg = att.getAltreInfo().getGenerali();
		DtRispettoNorme rn = att.getRispNorme();
		DtDichiarazFinale df = att.getDichiarazioni();
		DtImpianti impianti = att.getImpianti();
		DtAltreInfo ai = att.getAltreInfo();

		String unitaDiMisura = "";
		if (tg != null && tg.getDestUso() != null) {
			if (this.getMiscMgr().isEdificio(tg.getDestUso())) {
				unitaDiMisura = " kWh/m2";
			} else {
				unitaDiMisura = " kWh/m3";
			}
		}

		dto.setProvincia(cat.getDescrProv());

		dto.setComune(cat.getDescrComune());

		if (!BaseMgr.isNullOrEmpty(cat.getNumCiv())) {
			dto.setIndirizzo(cat.getDescrIndirizzo() + ", " + cat.getNumCiv());
		} else {
			dto.setIndirizzo(cat.getDescrIndirizzo());
		}
		if (!BaseMgr.isNullOrEmpty(cat.getSezione())) {
			dto.setDatiCatSez(cat.getSezione());
		}
		dto.setDatiCatF(cat.getFoglio());
		dto.setDatiCatN(cat.getParticella());
		if (!BaseMgr.isNullOrEmpty(cat.getSubalterno())) {
			dto.setDatiCatSub(cat.getSubalterno());
		}
		dto.setPianoN(this.convertToString((cat.getPiano())));
		dto.setPianoDi(this.convertToString(this.convertTo(cat.getPianiTot())));
		dto.setNumAppartamentiUnita(this.convertToString(this.convertTo(cat
				.getNumUnita())));
		dto.setScala(cat.getScala());
		dto.setInterno(cat.getInterno());

		if (!BaseMgr.isNullOrEmpty(rp.getDtProgettista().getNome())) {
			dto.setProgettista(rp.getDtProgettista().getNome() + " "
					+ rp.getDtProgettista().getCognome());
		}

		dto.setCapProgettista(rp.getDtProgettista().getCap());
		dto.setCellProgettista(rp.getDtProgettista().getCell());
		dto.setCognomeProgettista(rp.getDtProgettista().getCognome());
		dto.setDescrComuneProgettista(rp.getDtProgettista().getDescrComune());
		dto.setDescrIndirizzoProgettista(rp.getDtProgettista()
				.getDescrIndirizzo());
		dto.setDescrProvProgettista(rp.getDtProgettista().getDescrProv());
		dto.setDescrRegProgettista(rp.getDtProgettista().getDescrReg());
		dto.setEmailProgettista(rp.getDtProgettista().getEmail());
		dto.setFaxProgettista(rp.getDtProgettista().getFax());
		dto.setNomeProgettista(rp.getDtProgettista().getNome());
		dto.setNumCivProgettista(rp.getDtProgettista().getNumCiv());
		dto.setTelProgettista(rp.getDtProgettista().getTel());

		if (!BaseMgr.isNullOrEmpty(rp.getDtDirLavori().getNome())) {
			dto.setDirettoreLavori(rp.getDtDirLavori().getNome() + " "
					+ rp.getDtDirLavori().getCognome());
		}

		dto.setCapDirettoreLavori(rp.getDtDirLavori().getCap());
		dto.setCellDirettoreLavori(rp.getDtDirLavori().getCell());
		dto.setCognomeDirettoreLavori(rp.getDtDirLavori().getCognome());
		dto.setDescrComuneDirettoreLavori(rp.getDtDirLavori().getDescrComune());
		dto.setDescrIndirizzoDirettoreLavori(rp.getDtDirLavori()
				.getDescrIndirizzo());
		dto.setDescrProvDirettoreLavori(rp.getDtDirLavori().getDescrProv());
		dto.setDescrRegDirettoreLavori(rp.getDtDirLavori().getDescrReg());
		dto.setEmailDirettoreLavori(rp.getDtDirLavori().getEmail());
		dto.setFaxDirettoreLavori(rp.getDtDirLavori().getFax());
		dto.setNomeDirettoreLavori(rp.getDtDirLavori().getNome());
		dto.setNumCivDirettoreLavori(rp.getDtDirLavori().getNumCiv());
		dto.setTelDirettoreLavori(rp.getDtDirLavori().getTel());

		if (!BaseMgr.isNullOrEmpty(rp.getDtCostruttore().getNome())) {
			dto.setCostruttore(rp.getDtCostruttore().getNome() + " "
					+ rp.getDtCostruttore().getCognome());
		}
		dto.setCapCostruttore(rp.getDtCostruttore().getCap());
		dto.setCellCostruttore(rp.getDtCostruttore().getCell());
		dto.setCognomeCostruttore(rp.getDtCostruttore().getCognome());
		dto.setDescrComuneCostruttore(rp.getDtCostruttore().getDescrComune());
		dto.setDescrIndirizzoCostruttore(rp.getDtCostruttore()
				.getDescrIndirizzo());
		dto.setDescrProvCostruttore(rp.getDtCostruttore().getDescrProv());
		dto.setDescrRegCostruttore(rp.getDtCostruttore().getDescrReg());
		dto.setEmailCostruttore(rp.getDtCostruttore().getEmail());
		dto.setFaxCostruttore(rp.getDtCostruttore().getFax());
		dto.setNomeCostruttore(rp.getDtCostruttore().getNome());
		dto.setNumCivCostruttore(rp.getDtCostruttore().getNumCiv());
		dto.setTelCostruttore(rp.getDtCostruttore().getTel());

		if (anagImmobile.getDtCoCertificatore() != null) {
			dto.setNomeCocertificatore(anagImmobile.getDtCoCertificatore()
					.getNome());
			dto.setCognomeCocertificatore(anagImmobile.getDtCoCertificatore()
					.getCognome());
			dto.setMatricolaCocertificatore(anagImmobile.getDtCoCertificatore()
					.getNumMatricola());
		}
		if (tg != null && tg.getDestUso() != null) {
			dto.setDestinazioneUso(this.getMiscMgr().getSiglaDestinazioneDuso(
					tg.getDestUso()));
		}
		if (BaseMgr.isNullOrEmpty(tg.getAnnoUltimaRistrutt())) {
			dto.setAnnoCostruzione(tg.getAnnoCostr());
		} else {
			dto.setAnnoCostruzione(tg.getAnnoCostr() + " / "
					+ tg.getAnnoUltimaRistrutt());
		}
		dto.setDescrizioneEdificio(tg.getDescrizioneEdificio());
		dto.setFlagUsoPubblico(tg.getFlagUsoPubblico());
		dto.setSuperficieUtileClimatizzata(String.valueOf(BaseMgr.convertTo(tg
				.getSuperficieUtile())));
		dto.setVolumeLordoRiscaldato(this.parseNumberForPrint(BaseMgr
				.convertTo(tg.getVolLordoRiscald())));
		dto.setSuperfDispTotale(this.parseNumberForPrint(BaseMgr.convertTo(tg
				.getSupDispTot())));
		dto.setFattoreForma(this.parseNumberForPrint(BaseMgr.convertTo(tg
				.getFattoreForma())));
		dto.setTrasmMedSupOp(this.parseNumberForPrint(BaseMgr.convertTo(tg
				.getTrasmittanzaOpache())));
		dto.setTrasmMedSupTrasp(this.parseNumberForPrint(BaseMgr.convertTo(tg
				.getTrasmittanzaTrasp())));

		if (tg != null && tg.getTipoImpianto() != null) {
			dto.setTipolImpRisc(this.getMiscMgr().getDescrizioneTipoImpianto(
					tg.getTipoImpianto()));
		}

		if (!BaseMgr.isNullOrEmpty(impRisc.getCombustibileFossile())) {
			dto.setCombustibileRisc(this.getMiscMgr()
					.getDescrizioneComustibileFossile(
							impRisc.getCombustibileFossile()));
		}
		if (!BaseMgr.isNullOrEmpty(impAcqua.getCombustibileFossile())) {
			dto.setCombustibileAcquaCaldaSan(this.getMiscMgr()
					.getDescrizioneComustibileFossile(
							impAcqua.getCombustibileFossile()));
		}

		// ------------> Fabbisogno
		if (fab != null && fab.getDomEnergRiscald() != null) {
			dto.setQh(this.parseNumberForPrint(BaseMgr.convertTo(fab
					.getDomEnergRiscald())) + unitaDiMisura);
			dto.setQh(this.parseNumberForPrint(BaseMgr.convertTo(fab
					.getDomEnergRiscald())));
		}
		if (fab != null && fab.getLimNormRegione() != null) {
			dto.setLimiteLegge(this.proporzioneQh(BaseMgr.convertTo(
					fab.getLimNormRegione()).floatValue()));
			dto.setLimiteDiLegge(this.parseNumberForPrint(BaseMgr.convertTo(fab
					.getLimNormRegione())) + unitaDiMisura);
		}
		if (fab != null && fab.getDomEnergAcqua() != null) {
			dto.setQhW(this.parseNumberForPrint(BaseMgr.convertTo(fab
					.getDomEnergAcqua())) + unitaDiMisura);
			dto.setQhW(this.parseNumberForPrint(BaseMgr.convertTo(fab
					.getDomEnergAcqua())));
		}
		if (fab != null && fab.getEnergTermAcquaRinnov() != null) {
			dto.setFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili(this
					.parseNumberForPrint(BaseMgr.convertTo(fab
							.getEnergTermAcquaRinnov())));
		}

		// EtAg acss
		if (fab != null && fab.getRendGlobStagioneAcqua() != null) {
			dto.seteTAgacs(this.parseNumberForPrint(BaseMgr.convertTo(fab
					.getRendGlobStagioneAcqua())));
		}

		// Epacs
		if (fab != null && fab.getIndPrestEnergAcqua() != null) {
			dto.setePacs(String.valueOf(BaseMgr.convertTo(fab
					.getIndPrestEnergAcqua())));

			// ??
			dto.setQuozienteQhw(this.proporzioneFabbisognoEnergeticoAcs(BaseMgr
					.convertTo(fab.getIndPrestEnergAcqua()).floatValue())); // corrisponde
																			// a
																			// Indice
																			// prestazione
																			// energetica
																			// acs
		}
		if (fab != null && fab.getFabbCondizionamento() != null) {
			dto.setFabbisognoEnergiaUtileClimatizzazioneEstiva(String
					.valueOf(BaseMgr.convertTo(fab.getFabbCondizionamento())));
		}
		if (fab != null && fab.getIndPrestEnergIlluminaz() != null) {
			dto.setFabbisognoEnergiaElettricaIlluminazione(String
					.valueOf(BaseMgr.convertTo(fab.getIndPrestEnergIlluminaz())));
		}

		// -------------> Classe energetica loc. reale
		dto.setRendimentoDiGenerazione(String.valueOf(BaseMgr.convertTo(rea
				.getRendGeneraz())));
		dto.setRendimentoDiRegolazione(String.valueOf(BaseMgr.convertTo(rea
				.getRendRegolaz())));
		dto.setRendimentoDiEmissione(String.valueOf(BaseMgr.convertTo(rea
				.getRendEmissione())));
		dto.setRendimentoDiDistribuzione(String.valueOf(BaseMgr.convertTo(rea
				.getRendDistrib())));
		// Etag:
		dto.setRendimentoMedGlobStagImp(this.parseNumberForPrint(BaseMgr
				.convertTo(rea.getRendGlobTermico())));

		// Epi
		if (!BaseMgr.isNullOrEmpty(rea.getIndPrestEnergRiscald())
				&& !BaseMgr.isNullOrEmpty(this.parseNumberForPrint(rea
						.getIndPrestEnergRiscald().getValue()))) {
			dto.setPrestRisc(this.parseNumberForPrint(rea
					.getIndPrestEnergRiscald().getValue()) + unitaDiMisura);
		}

		dto.setIndiceDiPrestazioneEnergeticaClimatizzazioneEstiva(String
				.valueOf(BaseMgr.convertTo(rea.getIndPrestEnergCondiz())));
		dto.setIndicePrestazioneEnergeticaIlluminazione(String.valueOf(BaseMgr
				.convertTo(rea.getIndPrestEnergIlluminaz())));
		dto.setIndicePrestazioneEnergeticaGlobale(String.valueOf(BaseMgr
				.convertTo(rea.getIndPrestEnergGlob())));

		// -------------> Classe energetica loc. teorica (Torino)
		if (!BaseMgr.isNullOrEmpty(teo.getDomEnergRiscald())) {
			dto.setQuozienteQh(this.proporzioneQh(BaseMgr.convertTo(
					teo.getDomEnergRiscald()).floatValue()));
		}

		if (!BaseMgr.isNullOrEmpty(teo.getLimNormaRegione())) {
			dto.setLimiteDiNormativaRegionale(String.valueOf(BaseMgr
					.convertTo(teo.getLimNormaRegione())));
		}

		// Epi To
		if (!BaseMgr.isNullOrEmpty(teo.getIndPrestEnergRiscald())
				&& !BaseMgr.isNullOrEmpty(this.parseNumberForPrint(teo
						.getIndPrestEnergRiscald().getValue()))) {
			dto.setIndiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo(this
					.parseNumberForPrint(teo.getIndPrestEnergRiscald()
							.getValue())
					+ unitaDiMisura);
		}

		if (!BaseMgr.isNullOrEmpty(teo.getDomEnergAcqua())) {
			dto.setQhWPerClasseEnergetica(this.parseNumberForPrint(BaseMgr
					.convertTo(teo.getDomEnergAcqua())));
		}

		if (!BaseMgr.isNullOrEmpty(teo.getEnergTermAcquaRinnov())) {
			dto.setFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica(this
					.parseNumberForPrint(BaseMgr.convertTo(teo
							.getEnergTermAcquaRinnov())));
		}

		// ETAg acs To
		if (!BaseMgr.isNullOrEmpty(teo.getRendGlobStagioneAcqua())) {
			dto.seteTAgacsTo(this.parseNumberForPrint(BaseMgr.convertTo(teo
					.getRendGlobStagioneAcqua())));
		}

		// EPacs To
		if (!BaseMgr.isNullOrEmpty(teo.getIndPrestEnergAcqua())) {
			dto.setePacsTo(this.parseNumberForPrint(BaseMgr.convertTo(teo
					.getIndPrestEnergAcqua())));
		}

		// EPL lordo
		if (!BaseMgr.isNullOrEmpty(teo.getIndPrestEnergGlob())) {
			dto.setIndicePrestEnGlob(this.parseNumberForPrint(BaseMgr
					.convertTo(teo.getIndPrestEnergGlob())) + unitaDiMisura);
		}

		// BEPPE
		if (!BaseMgr.isNullOrEmpty(rea.getIndPrestEnergGlob())) {
			dto.setIndicePrestEnGlob(this.parseNumberForPrint(BaseMgr
					.convertTo(teo.getIndPrestEnergGlob())) + unitaDiMisura);
		}

		if (!BaseMgr.isNullOrEmpty(teo.getDescClasseEnerg())) {
			dto.setClasseEnergetica(teo.getDescClasseEnerg());
		}

		if (!BaseMgr.isNullOrEmpty(teo.getServEnergInclusi())) {
			dto.setServiziEnergeticiInclusiNellaClassificazione(teo
					.getServEnergInclusi());
		}

		// Energia da fonti rinnovabili

		dto.setTecnologieUsoFontiRinnovabili(efr.getTechFontiRinnov());
		dto.setAnnoInstallazione(efr.getAnnoInstall());

		dto.setEnergiaTermicaProdotta(this.parseNumberForPrint(BaseMgr
				.convertTo(efr.getEnergTermicaProdotta())));
		dto.setEnergiaElettricaProdotta(this.parseNumberForPrint(BaseMgr
				.convertTo(efr.getEnergElettricaProdotta())));
		dto.setAutoconsumoTermico(this.parseNumberForPrint(BaseMgr
				.convertTo(efr.getAutoconsumoTermico())));
		dto.setAutoconsumoElettrico(this.parseNumberForPrint(BaseMgr
				.convertTo(efr.getAutoconsumoElettrico())));
		dto.setQuotaEnCopFRin(this.parseNumberForPrint(BaseMgr.convertTo(efr
				.getPercEnergiaFontiRinnov())));

		// -------->Altre informazioni - Generali
		dto.setMotivazioneRilascio(aieg.getMotivoRilascio());
		dto.setMetodologiaDiCalcoloAdottata(aieg.getMetodoCalcolo());
		dto.setSoftwareUtilizzato(aieg.getSoftware());
		dto.setDenominazioneProduttore(aieg.getDenomProduttore());
		dto.setRispondenzaAUNITS11300(aieg.getRispondenzaUNITS11300());

		// -------->Altre informazioni - Raccomandazioni

		int edi = 0;
		int imp = 0;
		// Arrays.sort(arrayList, )
		if (arrayList != null && arrayList.size() > 0) {
			Raccomandazione[] racc = new Raccomandazione[arrayList.size()];
			arrayList.toArray(racc);
			Arrays.sort(racc, new RaccomandazioneComparator());

			for (int i = 0; i < racc.length; i++) {

				if (racc[i].getCodSistema().equals("EDIFICIO")) {
					edi++;
				} else {
					imp++;
				}

				Raccomandazione r = racc[i];
				if (r.getCodSistema().equals("EDIFICIO")) {
					switch (edi) {
					case 1:
						dto.setEdificioIntervento1(r.getIntervento());
						dto.setEdificioPriorita1(r.getDescrPriorita());
						dto.setEdificioTempoRit1(r.getTempoRitorno());
						break;
					case 2:
						dto.setEdificioIntervento2(r.getIntervento());
						dto.setEdificioPriorita2(r.getDescrPriorita());
						dto.setEdificioTempoRit2(r.getTempoRitorno());
						break;
					case 3:
						dto.setEdificioIntervento3(r.getIntervento());
						dto.setEdificioPriorita3(r.getDescrPriorita());
						dto.setEdificioTempoRit3(r.getTempoRitorno());
						break;
					case 4:
						dto.setEdificioIntervento4(r.getIntervento());
						dto.setEdificioPriorita4(r.getDescrPriorita());
						dto.setEdificioTempoRit4(r.getTempoRitorno());
						break;
					}
				} else {
					switch (imp) {
					case 1:
						dto.setImpiantoIntervento1(r.getIntervento());
						dto.setImpiantoPriorita1(r.getDescrPriorita());
						dto.setImpiantoTempoRit1(r.getTempoRitorno());
						break;
					case 2:
						dto.setImpiantoIntervento2(r.getIntervento());
						dto.setImpiantoPriorita2(r.getDescrPriorita());
						dto.setImpiantoTempoRit2(r.getTempoRitorno());
						break;
					case 3:
						dto.setImpiantoIntervento3(r.getIntervento());
						dto.setImpiantoPriorita3(r.getDescrPriorita());
						dto.setImpiantoTempoRit3(r.getTempoRitorno());
						break;
					case 4:
						dto.setImpiantoIntervento4(r.getIntervento());
						dto.setImpiantoPriorita4(r.getDescrPriorita());
						dto.setImpiantoTempoRit4(r.getTempoRitorno());
						break;
					}
				}
			}
		}

		// -------->Altre informazioni - Energetiche
		if (!BaseMgr.isNullOrEmpty(aien.getClasseEnergEdificio())) {
			dto.setClasseEnGlobNazEdif(this.getMiscMgr()
					.getDescrizioneClasseEnergetica(
							aien.getClasseEnergEdificio()));
		}

		if (!BaseMgr.isNullOrEmpty(aien.getPrestEnergRaggiungibile())) {
			dto.setPrestEnerRagg(this.parseNumberForPrint(BaseMgr
					.convertTo(aien.getPrestEnergRaggiungibile()))
					+ unitaDiMisura);
		}

		if (!BaseMgr.isNullOrEmpty(aien.getIndPrestEnergRiscald())) {
			dto.setIndiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale(this
					.parseNumberForPrint(BaseMgr.convertTo(aien
							.getIndPrestEnergRiscald())));
		}

		if (!BaseMgr.isNullOrEmpty(aien.getLimNormaNazRiscald())) {
			dto.setLimiteNormNazRisc(this.parseNumberForPrint(BaseMgr
					.convertTo(aien.getLimNormaNazRiscald())) + unitaDiMisura);
		}
		if (!BaseMgr.isNullOrEmpty(aien.getQualitaInvolucroRaffresc())) {
			dto.setQualitaInvRaffresc(this.getMiscMgr()
					.getDescrizioneQualitaInvolucro(
							aien.getQualitaInvolucroRaffresc()));
		}
		if (!BaseMgr.isNullOrEmpty(aien.getPrestazPompaCalore())) {
			dto.setValorePrestEnPomCal(this.parseNumberForPrint(BaseMgr
					.convertTo(aien.getPrestazPompaCalore())));
		}
		if (!BaseMgr.isNullOrEmpty(aien.getLimNormaPrestPompa())) {
			dto.setLimiteNormPrestEnPomCal(this.parseNumberForPrint(BaseMgr
					.convertTo(aien.getLimNormaPrestPompa())));
		}
		dto.setAltreInfo(aien.getAltreInfo());

		// -------->Altre informazioni - sopralluoghi e dati di ingresso
		dto.setDataEffettuazioneSopralluogo(DateUtil.convertToString(ai
				.getSopralluoghi().getData()));
		dto.setNoteSopralluogo(ai.getSopralluoghi().getNote());
		dto.setDatiRedazione(ai.getSopralluoghi().getTipoRedazione());

		// -------->Normative energetiche
		if (!GenericUtil.isNullOrEmpty(rn.getDataTitolo())) {
			dto.setDataTitAbitCostr(this.convertoToString(rn.getDataTitolo()));
		}
		if (!BaseMgr.isNullOrEmpty(rn.getDescrNorma())) {
			dto.setNDecretoLgs(rn.getDescrNorma());
		}

		if (!BaseMgr.isNullOrEmpty(rn.getAutorizzato())) {
			if (rn.getAutorizzato().equals("S")) {
				dto.setComboDecretoLgs(AceDto.DECRETO_LGS_S_N_OPTION_SI);
			} else {
				dto.setComboDecretoLgs(AceDto.DECRETO_LGS_S_N_OPTION_NO);
			}
		} else {
			dto.setComboDecretoLgs("");
		}

		dto.setMotivoNonConformita(rn.getMotivoNonConformita());

		dto.setUlterioriNoteNormativeEn(rn.getNote());

		// -------->Impianti - riscaldamento
		dto.setImpiantoColBollino(impianti.getRiscaldamento().getFlgBollino());
		dto.setNumBollino(impianti.getRiscaldamento().getNumBollino());
		dto.setCodiceImpianto(impianti.getRiscaldamento().getCodImpianto());
		dto.setAnnoInstallGeneratore(impianti.getRiscaldamento()
				.getAnnoInstallGeneratore());
		dto.setPotenzaUtileNominaleComplessiva(this.parseNumberForPrint(BaseMgr
				.convertTo(impianti.getRiscaldamento().getPotNomCompl())));
		dto.setLimiteNormRendMedGlob(this.parseNumberForPrint(BaseMgr
				.convertTo(impRisc.getLimNormRegImpTerm())));
		dto.setClasseEfficienzaEnergetica(impRisc.getClasseEfficienzaEnerg());
		dto.setFonteEnergeticaUtilizzata(impRisc.getCombustibileFossile());
		dto.setUnitaImmobiliariServite(att.getImpianti().getUiServite());
		dto.setFlgRipartizione(att.getImpianti().getFlgRipartizione());
		dto.setTipoImpianto(att.getDatiTecnici().getTipoImpianto());
		dto.setTipoTerminaliErogazione(att.getImpianti().getTipoTermErogaz());
		dto.setTipoDiDistribuzione(att.getImpianti().getTipoDistrib());
		dto.setTipoDiRegolazione(att.getImpianti().getTipoRegolaz());

		// -------->Impianti - acqua calda snitaria
		dto.setAnnoInstallazioneSistema(impAcqua.getAnnoInstallGeneratore());
		dto.setPotenzaUtileNominaleComplessivaPerAcquaCalda(this
				.parseNumberForPrint(BaseMgr.convertTo(impAcqua
						.getPotNomCompl())));
		dto.setClasseEfficienzaEnergeticaPerAcquaCalda(impAcqua
				.getClasseEfficienzaEnerg());
		dto.setFonteEnergeticaUtilizzataPerAcquaCalda(impAcqua
				.getCombustibileFossile());

		// --------->Emissioni gas serra
		dto.setEmissioniGasSerra(this.parseNumberForPrint(BaseMgr.convertTo(gs
				.getEmissioniGasSerra())));
		dto.setEttariBosco(this.parseNumberForPrint(BaseMgr.convertTo(gs
				.getSupBoscoEquiv())));

		if (!BaseMgr.isNullOrEmpty(gs.getEmissioniGasSerra())) {
			dto.setQuozienteEmissioneGasSerra(this.proporzioneGasSerra(BaseMgr
					.convertTo(gs.getEmissioniGasSerra()).floatValue()));
		}

		// --------->Consumi reali
		dto.setAnnualeTermicoDaFossile(BaseMgr.convertToString(cr
				.getAnnoTermicoFossile()));
		dto.setAnnualeElettricoDaFossile(BaseMgr.convertToString(cr
				.getAnnoElettricoFossile()));
		dto.setAnnualeTermicoDaFontiRinnovabili(BaseMgr.convertToString(cr
				.getAnnoTermicoRinnov()));
		dto.setAnnualeElettricoDaFontiRinnovabili(BaseMgr.convertToString(cr
				.getAnnoElettricoRinnov()));
		dto.setMedioComplessivoTermico(BaseMgr.convertToString(cr
				.getMedioTermico()));
		dto.setMedioComplessivoElettrico(BaseMgr.convertToString(cr
				.getMedioElettrico()));

		if (!BaseMgr.isNullOrEmpty(teo.getClasseEnerg())) {
			dto.setClasseEnergetica(this.getMiscMgr()
					.getDescrizioneClasseEnergetica(teo.getClasseEnerg()));
		}
		dto.setClasseEnergeticaLinea(this.getMiscMgr()
				.getClasseEnergeticaPerValore(teo.getIndGlobLimiteTo(),
						BaseMgr.convertToInteger(tg.getDestUso())));

		dto.setNCertificato(att.getNumeroAttestato());
		dto.setDataScadenza(att.getDataScadenza());

		dto.setNCertificatoA(att.getNumeroAttestato());

		dto.setLimiteNormNazRisc(this.parseNumberForPrint(BaseMgr
				.convertTo(aien.getLimNormaNazRiscald())) + unitaDiMisura);

		if (!BaseMgr.isNullOrEmpty(aien.getLimNormaPrestPompa())) {
			dto.setLimiteNormPrestEnPomCal(this.parseNumberForPrint(BaseMgr
					.convertTo(aien.getLimNormaPrestPompa())));
		}

		if (!BaseMgr.isNullOrEmpty(aieg.getMotivoRilascio())) {
			dto.setMotivoRilAttest(this.getMiscMgr()
					.getDescrizioneMotivoRilascio(aieg.getMotivoRilascio()));
		}

		dto.setNomeCertificatore(cert.getDtAnag().getNome() + " "
				+ cert.getDtAnag().getCognome());
		if (!BaseMgr.isNullOrEmpty(cert.getDtAnag().getDescrComuneNasc())) {
			dto.setLuogoNascitaCertificatore(cert.getDtAnag()
					.getDescrComuneNasc()
					+ " ("
					+ cert.getDtAnag().getDescrProvNasc() + ")");
		} else if (!BaseMgr.isNullOrEmpty(cert.getDtAnag().getStatoEstero())) {
			dto.setLuogoNascitaCertificatore(cert.getDtAnag().getStatoEstero());
		}
		if (!BaseMgr.isNullOrEmpty(cert.getDtAnag().getDataNascita())) {
			dto.setDataNascitaCertificatore(DateUtil.convertToString(cert
					.getDtAnag().getDataNascita()));
		}
		dto.setLuogoResidenzaCertificatore(cert.getDtResidenza()
				.getDescrComune()
				+ " ("
				+ cert.getDtResidenza().getDescrProv()
				+ ")");
		dto.setCfCertificatore(cert.getDtAnag().getCodFisc());
		dto.setLuogoCompilazione(df.getLuogoDichiarazione());
		dto.setDataCompilazione(DateUtil.convertToString(df
				.getDataDichiarazione()));
		dto.setFirmaCertificatore(cert.getDtAnag().getNome() + " "
				+ cert.getDtAnag().getCognome() + " N. "
				+ cert.getNumCertificatore());

		switch (df.getCodDichiaraz()) {
		case 1:
			dto.setRadioCertificazione(AceDto.RADIO_CERTIFICAZIONE_VALORE_1);
			break;
		case 2:
			dto.setRadioCertificazione(AceDto.RADIO_CERTIFICAZIONE_VALORE_2);
			break;
		case 3:
			dto.setRadioCertificazione(AceDto.RADIO_CERTIFICAZIONE_VALORE_3);
			break;
		}

		dto.setSupUtileSumCubi(this.parseNumberForPrint(BaseMgr.convertTo(tg
				.getSuperficieUtile())));
		dto.setZonaClimGradiGiorno(anagImmobile.getDtCatastali()
				.getZonaClimatica()
				+ " / "
				+ anagImmobile.getDtCatastali().getGradiGiorno());
		if (!GenericUtil.isNullOrEmpty(ai.getFlgEdificioPerformante())) {
			if (ai.getFlgEdificioPerformante()) {
				dto.setEdificioPerformante("L'edificio non necessita di interventi migliorativi");
			}
		}

		dto.setFotoEdificio(this.getSoaIntegrationMgr().recuperaImmagine(att));

		return dto;
	}


	@Transactional
	public void reInitApe(String idCertificatore, String progrCertificato, String anno) throws BEException {
		//int retval = 0;
		try
		{
			log.debug("\n\n CertificatoMgr::reInitApe");
	
			// UPDATE SICEE_T_CERTIFICATO
			SiceeTCertificato siceeTCertificato = this.getSiceeTCertificatoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			SiceeTCertificato siceeTCertificatoNew = new SiceeTCertificato();
			siceeTCertificatoNew.setIdCertificatore(siceeTCertificato.getIdCertificatore());
			siceeTCertificatoNew.setProgrCertificato(siceeTCertificato.getProgrCertificato());
			siceeTCertificatoNew.setAnno(siceeTCertificato.getAnno());
			siceeTCertificatoNew.setFkTransazioneAce(siceeTCertificato.getFkTransazioneAce());
			siceeTCertificatoNew.setDtAcquisto(siceeTCertificato.getDtAcquisto());
			siceeTCertificatoNew.setFkStato(Constants.NUOVO);
			siceeTCertificatoNew.setFlgOld(Constants.NO);
			SiceeTCertificatoPk pk1 = new SiceeTCertificatoPk();
			pk1.setIdCertificatore(idCertificatore);
			pk1.setProgrCertificato(progrCertificato);
			pk1.setAnno(anno);
			this.getSiceeTCertificatoDao().update(pk1, siceeTCertificatoNew);
			
			// DELETE FROM SICEE_T_DATI_GENERALI
			SiceeTDatiGeneraliPk pk2 = new SiceeTDatiGeneraliPk();
			pk2.setIdCertificatore(idCertificatore);
			pk2.setProgrCertificato(progrCertificato);
			pk2.setAnno(anno);
			this.getSiceeTDatiGeneraliDao().delete(pk2);

			// DELETE FROM SICEE_T_ALTRE_INFO
			SiceeTAltreInfoPk pk3 = new SiceeTAltreInfoPk();
			pk3.setIdCertificatore(idCertificatore);
			pk3.setProgrCertificato(progrCertificato);
			pk3.setAnno(anno);
			this.getSiceeTAltreInfoDao().delete(pk3);
			
			// DELETE FROM SICEE_T_CERT_XML_2015
			SiceeTCertXml2015Pk pk5 = new SiceeTCertXml2015Pk();
			pk5.setIdCertificatore(idCertificatore);
			pk5.setProgrCertificato(progrCertificato);
			pk5.setAnno(anno);
			this.getSiceeTCertXml2015Dao().delete(pk5);

			// DELETE FROM SICEE_T_DATI_CATAST_SEC
			this.getSiceeTDaticatastSecDao().delete(idCertificatore, progrCertificato, anno);

			// DELETE FROM SICEE_T_QTA_CONSUMI_2015
			this.getSiceeTQtaConsumi2015Dao().delete(idCertificatore, progrCertificato, anno);
			
			// DELETE FROM SICEE_T_RACCOMAND_2015
			this.getSiceeTRaccomand2015Dao().delete(idCertificatore, progrCertificato, anno);
			
			// DELETE FROM SICEE_T_DET_IMP_2015
			this.getSiceeTDetImp2015Dao().delete(idCertificatore, progrCertificato, anno);

			// DELETE FROM SICEE_R_COMB_DENER_2015
			this.getSiceeRCombDener2015Dao().delete(idCertificatore, progrCertificato, anno);

			// DELETE FROM SICEE_T_DATI_ENER_2015
			SiceeTDatiEner2015Pk pk4 = new SiceeTDatiEner2015Pk();
			pk4.setIdCertificatore(idCertificatore);
			pk4.setProgrCertificato(progrCertificato);
			pk4.setAnno(anno);
			this.getSiceeTDatiEner2015Dao().delete(pk4);

			// DELETE FROM SICEE_R_CERTIF_SERVENER2015
			this.getSiceeRCertifServener2015Dao().delete(idCertificatore, progrCertificato, anno);

			// Recupero informazioni foto da SICEE_T_FOTO_2015 per la
			// cancellazione da index delle foto dell'APE
			List<SiceeTFoto2015> listaFoto = this.getSiceeTFoto2015Dao().findBySiceeTCertificato(idCertificatore, progrCertificato, anno);
			// DELETE FROM SICEE_T_FOTO_2015			
			this.getSiceeTFoto2015Dao().deleteByPkCertificato(idCertificatore, progrCertificato, anno);

			// Recupero informazioni documento XML da SICEE_T_IMPORT_DATI_2015 per la
			// cancellazione da index dell'XML originario e dei dati a correlati
			//SiceeTImportDati2015 datiOrigXML = this.getSiceeTImportDati2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);

			// DELETE FROM SICEE_T_DATI_XML_2015
			// DELETE FROM SICEE_T_DATI_XML_ED_REALE_2015
			// DELETE FROM SICEE_T_DATI_XML_ED_RIF_2015
			// DELETE FROM SICEE_T_IMPDATI_XML_2015
			// DELETE FROM SICEE_T_IMPORT_DATI_2015
			this.getSiceeTDatiXml2015Dao().delete(idCertificatore, progrCertificato, anno);
			this.getSiceeTDatiXmlEdReale2015Dao().delete(idCertificatore, progrCertificato, anno);
			this.getSiceeTDatiXmlEdRif2015Dao().delete(idCertificatore, progrCertificato, anno);
			this.getSiceeTImpdatiXml2015Dao().delete(idCertificatore, progrCertificato, anno);
			this.getSiceeTImportDati2015Dao().delete(idCertificatore, progrCertificato, anno);

			
			this.getSiceeTExportBoDao().delete(new SiceeTExportBoPk(idCertificatore, progrCertificato, anno));
			
			
			SiceeTRifIndex2015 siceeTRifIndex2015 = this.getSiceeTRifIndex2015Dao().findBySiceeTCertificatoidTipoDoc(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO);
			
			if (siceeTRifIndex2015 != null && !GenericUtil.isNullOrEmpty(siceeTRifIndex2015.getUidIndex()))
			{
				this.getSiceeTRifIndex2015Dao().delete(siceeTRifIndex2015.createPk());
				// Nel caso in cui si sta riportando a NUOVO un ape che era in stato CONSOLIDATO, bisogna eliminare anche il pdf da INDEX
				eliminaFileIndexByUid(siceeTRifIndex2015.getUidIndex());
			}
			
			// Cancellazione da index delle foto
			for (SiceeTFoto2015 foto : listaFoto) {
				eliminaFileIndexByUid(foto.getIdentificFoto());
			}
			
			/*
			if (datiOrigXML != null) {
				eliminaXmlByUid(datiOrigXML.getUidIndex());
			}
			*/
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore nella re-inizializzazione dell'APE: ", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	@Transactional
	public void reInitConsolidaApe(String idCertificatore, String progrCertificato, String anno) throws BEException {
		//int retval = 0;
		try
		{
			log.debug("\n\n CertificatoMgr::reInitConsolidaApe");
	
			// UPDATE SICEE_T_CERTIFICATO
			SiceeTCertificato siceeTCertificato = this.getSiceeTCertificatoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			
			siceeTCertificato.setFkStato(Constants.CONSOLIDATO);
			siceeTCertificato.setDtUpload(null);
			siceeTCertificato.setIdentificPdf(null);
			siceeTCertificato.setNomePdf(null);
			
			this.getSiceeTCertificatoDao().update(siceeTCertificato.createPk(), siceeTCertificato);
			
			this.getSiceeTDatiFirmaDao().deleteBySiceeTCertificato(idCertificatore, progrCertificato, anno);
			this.getSiceeTVerifyReportDao().deleteBySiceeTCertificato(idCertificatore, progrCertificato, anno);
			this.getSiceeTExportBoDao().delete(new SiceeTExportBoPk(idCertificatore, progrCertificato, anno));
			
			List<SiceeTRifIndex2015> siceeTRifIndex2015list = this.getSiceeTRifIndex2015Dao().findBySiceeTCertificato(idCertificatore, progrCertificato, anno);
			
			log.debug("Recupero i dati da getSiceeTRifIndex2015Dao per capire cosa cancellare, lunghezza: "+siceeTRifIndex2015list.size());
			
			
			for (SiceeTRifIndex2015 siceeTRifIndex2015 : siceeTRifIndex2015list) {
				
				if (log.isDebugEnabled())
					log.debug("Stampo il siceeTRifIndex2015: "+siceeTRifIndex2015);
				
				if (siceeTRifIndex2015.getFkTipoDoc().intValue() == Constants.ID_PDF_APE_FIRMATO.intValue() ||
						siceeTRifIndex2015.getFkTipoDoc().intValue() == Constants.ID_PDF_INDICATORE_APE.intValue() )
				{
					// Devo cancellare su index il file
					eliminaFileIndexByUid(siceeTRifIndex2015.getUidIndex());
					this.getSiceeTRifIndex2015Dao().delete(siceeTRifIndex2015.createPk());
					
				}
			}
			
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore nella reInitConsolidaApe dell'APE: ", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	
	@Transactional
	public void eliminaFotoDbIndexByUid(String uidFoto) throws BEException {
		//int retval = 0;
		try
		{
			this.getSiceeTFoto2015Dao()
			.deleteByIdentificFoto(uidFoto);

			eliminaFileIndexByUid(uidFoto);

		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore nella re-inizializzazione dell'APE: ", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	
	@Transactional
	public void importApe(String idCertificatore, String progrCertificato, String anno, DatiGenericiDto datiGenericiDto, String xmlModol, String fileName, String xmlDoc) throws BEException {
		//int retval = 0;
		try
		{
			log.debug("\n\n CertificatoMgr::importApe");
			log.debug("\n>>>>>>> idCertificatore: " + idCertificatore);
			log.debug("\n>>>>>>> progrCertificato: " + progrCertificato);
			log.debug("\n>>>>>>> anno: " + anno);
	
			// UPDATE SICEE_T_CERTIFICATO
			SiceeTCertificatoPk pk01 = new SiceeTCertificatoPk();
			pk01.setIdCertificatore(idCertificatore);
			pk01.setProgrCertificato(progrCertificato);
			pk01.setAnno(anno);
			this.getSiceeTCertificatoDao().update(pk01, datiGenericiDto.getCertificato());
			
			log.debug("Dentro MGR (1) datiGenericiDto.getDatiGenerali().getFkDestUso2015: "+datiGenericiDto.getDatiGenerali().getFkDestUso2015());

			// UPDATE SICEE_T_DATI_GENERALI
			SiceeTDatiGeneraliPk pk02 = new SiceeTDatiGeneraliPk();
			pk02.setIdCertificatore(idCertificatore);
			pk02.setProgrCertificato(progrCertificato);
			pk02.setAnno(anno);
			SiceeTDatiGenerali obj02 = this.getSiceeTDatiGeneraliDao().findByPrimaryKey(pk02);
			if (obj02 == null) {
				obj02 = new SiceeTDatiGenerali();
				obj02.setIdCertificatore(idCertificatore);
				obj02.setProgrCertificato(progrCertificato);
				obj02.setAnno(anno);
				this.getSiceeTDatiGeneraliDao().insert(obj02);
			}
			this.getSiceeTDatiGeneraliDao().update(pk02, datiGenericiDto.getDatiGenerali());
			
			// UPDATE SICEE_T_ALTRE_INFO
			SiceeTAltreInfoPk pk03 = new SiceeTAltreInfoPk();
			pk03.setIdCertificatore(idCertificatore);
			pk03.setProgrCertificato(progrCertificato);
			pk03.setAnno(anno);
			SiceeTAltreInfo obj03 = this.getSiceeTAltreInfoDao().findByPrimaryKey(pk03);
			if (obj03 == null) {
				obj03 = new SiceeTAltreInfo();
				obj03.setIdCertificatore(idCertificatore);
				obj03.setProgrCertificato(progrCertificato);
				obj03.setAnno(anno);
				this.getSiceeTAltreInfoDao().insert(obj03);
			}
			this.getSiceeTAltreInfoDao().update(pk03, datiGenericiDto.getAltreInfo());

			// UPDATE SICEE_T_CERT_XML_2015 / INSERT INTO SICEE_T_CERT_XML_2015
			SiceeTCertXml2015 certXML = new SiceeTCertXml2015();
			certXML.setIdCertificatore(idCertificatore);
			certXML.setProgrCertificato(progrCertificato);
			certXML.setAnno(anno);
			certXML.setFlgControlloBozza("N");
			certXML.setXmlAllegato(xmlModol);
			SiceeTCertXml2015 certXMLonDB = this.recuperaCertXml2015(idCertificatore, progrCertificato, anno);
			if (certXMLonDB != null) {
				log.debug("CERTIFICATO GIA' PRESENTE SUL DB: UPDATE");
				SiceeTCertXml2015Pk pk04 = new SiceeTCertXml2015Pk();
				pk04.setIdCertificatore(idCertificatore);
				pk04.setProgrCertificato(progrCertificato);
				pk04.setAnno(anno);
				this.getSiceeTCertXml2015Dao().update(pk04, certXML);
			} else {
				log.debug("CERTIFICATO NON PRESENTE SUL DB: INSERT");
				this.getSiceeTCertXml2015Dao().insert(certXML);
			}		

			// DELETE FROM SICEE_T_DATI_XML_2015
			SiceeTDatiXml2015Pk pk05 = new SiceeTDatiXml2015Pk();
			pk05.setIdCertificatore(idCertificatore);
			pk05.setProgrCertificato(progrCertificato);
			pk05.setAnno(anno);
			this.getSiceeTDatiXml2015Dao().delete(pk05);
			// DELETE FROM SICEE_T_DATI_XML_ED_REALE_2015
			SiceeTDatiXmlEdReale2015Pk pk06 = new SiceeTDatiXmlEdReale2015Pk();
			pk06.setIdCertificatore(idCertificatore);
			pk06.setProgrCertificato(progrCertificato);
			pk06.setAnno(anno);
			this.getSiceeTDatiXmlEdReale2015Dao().delete(pk06);
			// DELETE FROM SICEE_T_DATI_XML_ED_RIF_2015
			SiceeTDatiXmlEdRif2015Pk pk07 = new SiceeTDatiXmlEdRif2015Pk();
			pk07.setIdCertificatore(idCertificatore);
			pk07.setProgrCertificato(progrCertificato);
			pk07.setAnno(anno);
			this.getSiceeTDatiXmlEdRif2015Dao().delete(pk07);

			SiceeTImportDati2015 datiOrigXML = this.getSiceeTImportDati2015Dao().findByPrimaryKey(
					idCertificatore, progrCertificato, anno);
			if (datiOrigXML != null) {
				// DELETE FROM SICEE_T_IMPDATI_XML_2015
				this.getSiceeTImpdatiXml2015Dao().delete(idCertificatore, progrCertificato, anno);
				// DELETE FROM SICEE_T_IMPORT_DATI_2015
				this.getSiceeTImportDati2015Dao().delete(idCertificatore, progrCertificato, anno);
			}

			// INSERT INTO SICEE_T_IMPORT_DATI_2015
			datiOrigXML = new SiceeTImportDati2015();
			datiOrigXML.setIdCertificatore(idCertificatore);
			datiOrigXML.setProgrCertificato(progrCertificato);
			datiOrigXML.setAnno(anno);
			datiOrigXML.setNomeXml(fileName);
			datiOrigXML.setDtCaricamento(new Date());
			this.getSiceeTImportDati2015Dao().insert(datiOrigXML);

			// INSERT INTO SICEE_T_IMPDATI_XML_2015
			SiceeTImpdatiXml2015 origXML = new SiceeTImpdatiXml2015();
			origXML.setIdCertificatore(idCertificatore);
			origXML.setProgrCertificato(progrCertificato);
			origXML.setAnno(anno);
			origXML.setFXml(xmlDoc);
			this.getSiceeTImpdatiXml2015Dao().insert(origXML);
		
			// INSERT INTO SICEE_T_DATI_XML_2015
			this.getSiceeTDatiXml2015Dao().insert(datiGenericiDto.getDatiXml2015());
			// INSERT INTO SICEE_T_DATI_XML_ED_REALE_2015
			this.getSiceeTDatiXmlEdReale2015Dao().insert(datiGenericiDto.getDatiXmlEdReale2015());
			// INSERT INTO SICEE_T_DATI_XML_ED_RIF_2015
			this.getSiceeTDatiXmlEdRif2015Dao().insert(datiGenericiDto.getDatiXmlEdRif2015());
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore nell'import dell'APE: ", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	@Transactional
	public void importApeReadOnly(String idCertificatore, String progrCertificato, String anno, DatiGenericiDto datiGenericiDto, String fileName, String xmlDoc) throws BEException {
		//int retval = 0;
		try
		{
			log.debug("\n\n CertificatoMgr::importApe");
			log.debug("\n>>>>>>> idCertificatore: " + idCertificatore);
			log.debug("\n>>>>>>> progrCertificato: " + progrCertificato);
			log.debug("\n>>>>>>> anno: " + anno);
	
			// UPDATE SICEE_T_CERTIFICATO
			SiceeTCertificatoPk pk01 = new SiceeTCertificatoPk();
			pk01.setIdCertificatore(idCertificatore);
			pk01.setProgrCertificato(progrCertificato);
			pk01.setAnno(anno);
			this.getSiceeTCertificatoDao().update(pk01, datiGenericiDto.getCertificato());
			
			log.debug("Dentro MGR (1) datiGenericiDto.getDatiGenerali().getFkDestUso2015: "+datiGenericiDto.getDatiGenerali().getFkDestUso2015());

			// UPDATE SICEE_T_DATI_GENERALI
			SiceeTDatiGeneraliPk pk02 = new SiceeTDatiGeneraliPk();
			pk02.setIdCertificatore(idCertificatore);
			pk02.setProgrCertificato(progrCertificato);
			pk02.setAnno(anno);
			SiceeTDatiGenerali obj02 = this.getSiceeTDatiGeneraliDao().findByPrimaryKey(pk02);
			if (obj02 == null) {
				obj02 = new SiceeTDatiGenerali();
				obj02.setIdCertificatore(idCertificatore);
				obj02.setProgrCertificato(progrCertificato);
				obj02.setAnno(anno);
				this.getSiceeTDatiGeneraliDao().insert(obj02);
			}
			this.getSiceeTDatiGeneraliDao().update(pk02, datiGenericiDto.getDatiGenerali());
			
			// UPDATE SICEE_T_ALTRE_INFO
			SiceeTAltreInfoPk pk03 = new SiceeTAltreInfoPk();
			pk03.setIdCertificatore(idCertificatore);
			pk03.setProgrCertificato(progrCertificato);
			pk03.setAnno(anno);
			SiceeTAltreInfo obj03 = this.getSiceeTAltreInfoDao().findByPrimaryKey(pk03);
			if (obj03 == null) {
				obj03 = new SiceeTAltreInfo();
				obj03.setIdCertificatore(idCertificatore);
				obj03.setProgrCertificato(progrCertificato);
				obj03.setAnno(anno);
				this.getSiceeTAltreInfoDao().insert(obj03);
			}
			this.getSiceeTAltreInfoDao().update(pk03, datiGenericiDto.getAltreInfo());

			/*
			// UPDATE SICEE_T_CERT_XML_2015 / INSERT INTO SICEE_T_CERT_XML_2015
			SiceeTCertXml2015 certXML = new SiceeTCertXml2015();
			certXML.setIdCertificatore(idCertificatore);
			certXML.setProgrCertificato(progrCertificato);
			certXML.setAnno(anno);
			certXML.setFlgControlloBozza("N");
			certXML.setXmlAllegato(xmlModol);
			SiceeTCertXml2015 certXMLonDB = this.recuperaCertXml2015(idCertificatore, progrCertificato, anno);
			if (certXMLonDB != null) {
				log.debug("CERTIFICATO GIA' PRESENTE SUL DB: UPDATE");
				SiceeTCertXml2015Pk pk04 = new SiceeTCertXml2015Pk();
				pk04.setIdCertificatore(idCertificatore);
				pk04.setProgrCertificato(progrCertificato);
				pk04.setAnno(anno);
				this.getSiceeTCertXml2015Dao().update(pk04, certXML);
			} else {
				log.debug("CERTIFICATO NON PRESENTE SUL DB: INSERT");
				this.getSiceeTCertXml2015Dao().insert(certXML);
			}		
			*/
			
			// DELETE FROM SICEE_T_DATI_XML_2015
			SiceeTDatiXml2015Pk pk05 = new SiceeTDatiXml2015Pk();
			pk05.setIdCertificatore(idCertificatore);
			pk05.setProgrCertificato(progrCertificato);
			pk05.setAnno(anno);
			this.getSiceeTDatiXml2015Dao().delete(pk05);
			// DELETE FROM SICEE_T_DATI_XML_ED_REALE_2015
			SiceeTDatiXmlEdReale2015Pk pk06 = new SiceeTDatiXmlEdReale2015Pk();
			pk06.setIdCertificatore(idCertificatore);
			pk06.setProgrCertificato(progrCertificato);
			pk06.setAnno(anno);
			this.getSiceeTDatiXmlEdReale2015Dao().delete(pk06);
			// DELETE FROM SICEE_T_DATI_XML_ED_RIF_2015
			SiceeTDatiXmlEdRif2015Pk pk07 = new SiceeTDatiXmlEdRif2015Pk();
			pk07.setIdCertificatore(idCertificatore);
			pk07.setProgrCertificato(progrCertificato);
			pk07.setAnno(anno);
			this.getSiceeTDatiXmlEdRif2015Dao().delete(pk07);

			SiceeTImportDati2015 datiOrigXML = this.getSiceeTImportDati2015Dao().findByPrimaryKey(
					idCertificatore, progrCertificato, anno);
			if (datiOrigXML != null) {
				// DELETE FROM SICEE_T_IMPDATI_XML_2015
				this.getSiceeTImpdatiXml2015Dao().delete(idCertificatore, progrCertificato, anno);
				// DELETE FROM SICEE_T_IMPORT_DATI_2015
				this.getSiceeTImportDati2015Dao().delete(idCertificatore, progrCertificato, anno);
			}

			// INSERT INTO SICEE_T_IMPORT_DATI_2015
			datiOrigXML = new SiceeTImportDati2015();
			datiOrigXML.setIdCertificatore(idCertificatore);
			datiOrigXML.setProgrCertificato(progrCertificato);
			datiOrigXML.setAnno(anno);
			datiOrigXML.setNomeXml(fileName);
			datiOrigXML.setDtCaricamento(new Date());
			this.getSiceeTImportDati2015Dao().insert(datiOrigXML);

			// INSERT INTO SICEE_T_IMPDATI_XML_2015
			SiceeTImpdatiXml2015 origXML = new SiceeTImpdatiXml2015();
			origXML.setIdCertificatore(idCertificatore);
			origXML.setProgrCertificato(progrCertificato);
			origXML.setAnno(anno);
			origXML.setFXml(xmlDoc);
			this.getSiceeTImpdatiXml2015Dao().insert(origXML);
		
			// INSERT INTO SICEE_T_DATI_XML_2015
			this.getSiceeTDatiXml2015Dao().insert(datiGenericiDto.getDatiXml2015());
			// INSERT INTO SICEE_T_DATI_XML_ED_REALE_2015
			this.getSiceeTDatiXmlEdReale2015Dao().insert(datiGenericiDto.getDatiXmlEdReale2015());
			// INSERT INTO SICEE_T_DATI_XML_ED_RIF_2015
			this.getSiceeTDatiXmlEdRif2015Dao().insert(datiGenericiDto.getDatiXmlEdRif2015());
			
			// NEW - BEPPE
			
			
			List<SiceeTDaticatastSec> datiCatastaliSecList = datiGenericiDto.getDatiCatastaliSec();
			for (SiceeTDaticatastSec datoCatastaleSec : datiCatastaliSecList) {

				this.getSiceeTDaticatastSecDao().insert(datoCatastaleSec);

			}
			
			// INSERT INTO SICEE_T_DATI_XML_2015
			this.getSiceeTDatiEner2015Dao().insert(datiGenericiDto.getDatiEner2015());
			
			SiceeDCombustibile cd = datiGenericiDto.getCombustibileEsportazione();
			
			if (cd != null)
			{
				SiceeRCombDener2015 combDener = new SiceeRCombDener2015();
				combDener.setIdCertificatore(idCertificatore);
				combDener.setProgrCertificato(progrCertificato);
				combDener.setAnno(anno);		
				combDener.setIdCombustibile(cd.getIdCombustibile());
				combDener.setDescrAltro(cd.getDescr());
			
				this.getSiceeRCombDener2015Dao().insert(combDener);
			}
			
			
			// INSERT INTO SICEE_T_QTA_CONSUMI_2015
			List<SiceeTQtaConsumi2015> quantitaConsumi2015 = datiGenericiDto.getQuantitaConsumi2015();
			for (SiceeTQtaConsumi2015 siceeTQtaConsumi2015 : quantitaConsumi2015) {

				this.getSiceeTQtaConsumi2015Dao().insert(siceeTQtaConsumi2015);

			}

			
			
			// INSERT INTO SICEE_T_RACCOMAND_2015
			List<SiceeTRaccomand2015> raccomandazioni2015 = datiGenericiDto.getRaccomandazioni2015();
			for (SiceeTRaccomand2015 siceeTRaccomand2015 : raccomandazioni2015) {

				if (log.isDebugEnabled())
					GenericUtil.stampa(siceeTRaccomand2015, true, 3);
				
				this.getSiceeTRaccomand2015Dao().insert(siceeTRaccomand2015);

			}
			

			// INSERT INTO SICEE_R_CERTIF_SERVENER_2015
			List<SiceeRCertifServener2015> certifServener2015 = datiGenericiDto.getCertifServener2015();
			for (SiceeRCertifServener2015 certifSer2015 : certifServener2015) {

				if (log.isDebugEnabled())
					GenericUtil.stampa(certifSer2015, true, 3);

				this.getSiceeRCertifServener2015Dao().insert(certifSer2015);

			}

			// INSERT INTO SICEE_R_CERTIF_SERVENER_2015
			List<SiceeTDetImp2015> detImpianti2015 = datiGenericiDto.getDetImp2015();
			for (SiceeTDetImp2015 detImpianto2015 : detImpianti2015) {

				if (log.isDebugEnabled())
					GenericUtil.stampa(detImpianto2015, true, 3);

				this.getSiceeTDetImp2015Dao().insert(detImpianto2015);

			}

			
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore nell'import dell'APE: ", e);
			throw new BEException("Si e' verificato un problema nell'import dell'XML", e);
		}
	}
	
	@Transactional
	//public AceDto consolidaApe(String numeroAttestato,
	public int consolidaApeReadOnly(String numeroAttestato,
			DatiCertificatore cert) throws BEException {

		// BEPPE
		//Questa parte non esisterà più, verrà salvato sul DB quando si fa l'import
		
		int retval = 0;
		String operazioneDB = "";
		//AceDto dto = new AceDto();
		
		try
		{
			log.debug("\n\n CertificatoMgr::consolidaApe");
	
			DatiAttestato att = recuperaAttestato(cert,
					numeroAttestato);
			
			DtAnagImmobile anagImmobile = att.getDatiAnagraficiImm();
			DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
			
			String[] split = BaseMgr.recuperaChiaveAttestato(
					cert.getIdCertificatore(), att.getNumeroAttestato());

			String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];
			
			
			
			
//			SiceeTCertXml2015 certXML = getSiceeTCertXml2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);			
//			MODDocument modDoc = MapDto.mapToMODDocument(XmlBeanUtils.readString(certXML.getXmlAllegato()));
	
			//salvo i dati dell'xml sul db
			log.debug("\n>>>>>>> salvo i dati dell'xml sul db");
			
			//SICEE_T_CERTIFICATO
			SiceeTCertificato siceeTCertificato = this.getSiceeTCertificatoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			operazioneDB = "UPDATE";
			if (siceeTCertificato == null) {
				siceeTCertificato = new SiceeTCertificato();
				operazioneDB = "INSERT";
			}
			siceeTCertificato.setIdCertificatore(idCertificatore);
			siceeTCertificato.setProgrCertificato(progrCertificato);
			siceeTCertificato.setAnno(anno);
			siceeTCertificato.setFkStato(Constants.CONSOLIDATO);

			
			if (operazioneDB.equalsIgnoreCase("UPDATE")) {
				log.debug("\n>>>>>>> UPDATE del record di SICEE_T_CERTIFICATO");
				SiceeTCertificatoPk pk = new SiceeTCertificatoPk();
				pk.setIdCertificatore(idCertificatore);
				pk.setProgrCertificato(progrCertificato);
				pk.setAnno(anno);
				this.getSiceeTCertificatoDao().update(pk, siceeTCertificato);
			} else {
				log.debug("\n>>>>>>> INSERT del record di SICEE_T_CERTIFICATO");
				siceeTCertificato.setFlgOld(Constants.NO);
				this.getSiceeTCertificatoDao().insert(siceeTCertificato);
			}			
			
			// Valorizzo EXPORT_BO
			
			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(idCertificatore, progrCertificato, anno);

//			SiceeTCertificato siceeTCertificato,
//			SiceeTDatiGenerali siceeTDatiGenerali, SiceeTDatiEner2015 siceeTDatiEner2015, SiceeTAltreInfo siceeTAltreInfo
			
			boolean isPresents = this.getSiceeTExportBoDao().findByPrimaryKey(exportpk) !=null;
			
			//SICEE_T_DATI_GENERALI
			SiceeTDatiGenerali siceeTDatiGenerali = this.getSiceeTDatiGeneraliDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			//SICEE_T_DATI_ENER_2015
			SiceeTDatiEner2015 siceeTDatiEner2015 = this.getSiceeTDatiEner2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			//SICEE_T_ALTRE_INFO
			SiceeTAltreInfo siceeTAltreInfo = this.getSiceeTAltreInfoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			
			SiceeTExportBo exportBo = this.mapToDBExportBo(exportpk, siceeTCertificato, siceeTDatiGenerali, siceeTDatiEner2015, siceeTAltreInfo);

			if (!isPresents) {
				
				this.getSiceeTExportBoDao().insert(exportBo);
			} else {
				this.getSiceeTExportBoDao().update(exportpk,
						exportBo);
			}
			
			// Valorizzo EXPORT_BO
			
			log.debug("Prima del creaPdfEConsolidaLibretto");
			getServiziMgr().creaPdfEConsolidaCertificatoReadOnly(cert, idCertificatore, progrCertificato, anno, att);
			
			return retval;
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			if (retval == Constants.CODERR_FKCLASSEENERGETICA.intValue()) {
				// Errore gestito: ritorno il codice di errore particolare
				log.error("Errore gestito: FK_CLASSEENERGETICA NULL");
				return retval;
			} else {
				log.error("Errore in consolidamento: ", e);
				throw new BEException(e.getMessage(), e);
			}
		}
	}
	
	@Transactional
	/*
	public int consolidaApeOLD(String numeroAttestato,
			DatiCertificatore cert) throws BEException {

		final int SEZIONE_CLIMAINVER = 1;
		final int SEZIONE_CLIMAEST = 2;
		final int SEZIONE_ACQUACALDA = 3;
		final int SEZIONE_IMPIANTICOMBINATI = 4;
		final int SEZIONE_PRODFONTIRINN = 5;
		final int SEZIONE_VENTMECC = 6;
		final int SEZIONE_ILLUMINAZIONE = 7;
		final int SEZIONE_TRASPORTO = 8;

		// BEPPE
		//Questa parte non esisterà più, verrà salvato sul DB quando si fa l'import
		
		int retval = 0;
		String operazioneDB = "";
		//AceDto dto = new AceDto();
		
		try
		{
			log.debug("\n\n CertificatoMgr::consolidaApe");
	
			DatiAttestato att = recuperaAttestato(cert,
					numeroAttestato);
			
			DtAnagImmobile anagImmobile = att.getDatiAnagraficiImm();
			DtCatastali cat = att.getDatiAnagraficiImm().getDtCatastali();
			
			String[] split = BaseMgr.recuperaChiaveAttestato(
					cert.getIdCertificatore(), att.getNumeroAttestato());

			String idCertificatore = split[Constants.PK_ID_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];
			
			SiceeTCertXml2015 certXML = getSiceeTCertXml2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);			
			MODDocument modDoc = MapDto.mapToMODDocument(XmlBeanUtils.readString(certXML.getXmlAllegato()));
	
			//salvo i dati dell'xml sul db
			log.debug("\n>>>>>>> salvo i dati dell'xml sul db");
			
			//SICEE_T_CERTIFICATO
			SiceeTCertificato siceeTCertificato = this.getSiceeTCertificatoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			operazioneDB = "UPDATE";
			if (siceeTCertificato == null) {
				siceeTCertificato = new SiceeTCertificato();
				operazioneDB = "INSERT";
			}
			siceeTCertificato.setIdCertificatore(idCertificatore);
			siceeTCertificato.setProgrCertificato(progrCertificato);
			siceeTCertificato.setAnno(anno);
			
			Date dataScadenza = null;

			if (siceeTCertificato.getFkScadenzaCert() == Constants.ID_TIPO_SCADENZA_ANNO_SUCCESSIVO)
			{
				dataScadenza = DateUtil.getFineAnnoSuccessivo();
			}
			else if (siceeTCertificato.getFkScadenzaCert() == Constants.ID_TIPO_SCADENZA_ANNO_10)
			{
				dataScadenza = DateUtil.getAggiungi10Anni(new Date());
			}
			
			siceeTCertificato.setDtInizio(new Date());
			siceeTCertificato.setDtScadenza(dataScadenza);
			
			siceeTCertificato.setFkStato(Constants.CONSOLIDATO);
			try{siceeTCertificato.setFlgNoRaccomand(modDoc.getMOD().getAttestato().getRaccomandazioni().getFlagIntervConv());}catch (Exception e) {siceeTCertificato.setFlgNoRaccomand(null);}

			if (operazioneDB.equalsIgnoreCase("UPDATE")) {
				log.debug("\n>>>>>>> UPDATE del record di SICEE_T_CERTIFICATO");
				SiceeTCertificatoPk pk = new SiceeTCertificatoPk();
				pk.setIdCertificatore(idCertificatore);
				pk.setProgrCertificato(progrCertificato);
				pk.setAnno(anno);
				this.getSiceeTCertificatoDao().update(pk, siceeTCertificato);
			} else {
				log.debug("\n>>>>>>> INSERT del record di SICEE_T_CERTIFICATO");
				siceeTCertificato.setFlgOld(Constants.NO);
				this.getSiceeTCertificatoDao().insert(siceeTCertificato);
			}				

			//SICEE_T_DATI_GENERALI
			SiceeTDatiGenerali siceeTDatiGenerali = this.getSiceeTDatiGeneraliDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			operazioneDB = "UPDATE";
			if (siceeTDatiGenerali == null) {
				siceeTDatiGenerali = new SiceeTDatiGenerali();
				operazioneDB = "INSERT";
			}
			siceeTDatiGenerali.setIdCertificatore(idCertificatore);
			siceeTDatiGenerali.setProgrCertificato(progrCertificato);
			siceeTDatiGenerali.setAnno(anno);
			try{siceeTDatiGenerali.setFkDestUso2015(Converter.convertToInteger(modDoc.getMOD().getAttestato().getDatiGenerali().getCodClassificazione()));}catch (Exception e) {siceeTDatiGenerali.setFkDestUso2015(null);}
			try{siceeTDatiGenerali.setFkOggettoApe(Converter.convertToInteger(modDoc.getMOD().getAttestato().getDatiGenerali().getOggetto()));}catch (Exception e) {siceeTDatiGenerali.setFkOggettoApe(null);}
			try{siceeTDatiGenerali.setNrUm(Converter.convertToInteger(modDoc.getMOD().getAttestato().getDatiGenerali().getNumeroUI()));}catch (Exception e) {siceeTDatiGenerali.setNrUm(null);}
			try{siceeTDatiGenerali.setSupRiscaldata(Converter.convertToDouble(modDoc.getMOD().getAttestato().getDatiGenerali().getSupUtileRisc()));}catch (Exception e) {siceeTDatiGenerali.setSupRiscaldata(null);}
			try{siceeTDatiGenerali.setSupRaffrescata(Converter.convertToDouble(modDoc.getMOD().getAttestato().getDatiGenerali().getSupUtileRaffr()));}catch (Exception e) {siceeTDatiGenerali.setSupRaffrescata(null);}
			try{siceeTDatiGenerali.setVolLordoRiscaldato(Converter.convertToDouble(modDoc.getMOD().getAttestato().getDatiGenerali().getVolLordoRisc()));}catch (Exception e) {siceeTDatiGenerali.setVolLordoRiscaldato(null);}
			try{siceeTDatiGenerali.setVolLordoRaffrescato(Converter.convertToDouble(modDoc.getMOD().getAttestato().getDatiGenerali().getVolLordoRaffr()));}catch (Exception e) {siceeTDatiGenerali.setVolLordoRaffrescato(null);}
			try{siceeTDatiGenerali.setSupDisperdente(Converter.convertToDouble(modDoc.getMOD().getAttestato().getAltriDatiFabbricato().getSupDisperdente()));}catch (Exception e) {siceeTDatiGenerali.setSupDisperdente(null);}

			if (operazioneDB.equalsIgnoreCase("UPDATE")) {
				log.debug("\n>>>>>>> UPDATE del record di SICEE_T_DATI_GENERALI");
				SiceeTDatiGeneraliPk pk = new SiceeTDatiGeneraliPk();
				pk.setIdCertificatore(idCertificatore);
				pk.setProgrCertificato(progrCertificato);
				pk.setAnno(anno);
				this.getSiceeTDatiGeneraliDao().update(pk, siceeTDatiGenerali);
			} else {
				log.debug("\n>>>>>>> INSERT del record di SICEE_T_DATI_GENERALI");
				this.getSiceeTDatiGeneraliDao().insert(siceeTDatiGenerali);
			}				

			//SICEE_T_ALTRE_INFO
			SiceeTAltreInfo siceeTAltreInfo = this.getSiceeTAltreInfoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			operazioneDB = "UPDATE";
			if (siceeTAltreInfo == null) {
				siceeTAltreInfo = new SiceeTAltreInfo();
				operazioneDB = "INSERT";
			}
			siceeTAltreInfo.setIdCertificatore(idCertificatore);
			siceeTAltreInfo.setProgrCertificato(progrCertificato);
			siceeTAltreInfo.setAnno(anno);
			try{siceeTAltreInfo.setFkMotivo(Converter.convertToInteger(modDoc.getMOD().getAttestato().getDatiGenerali().getMotivazione()));}catch (Exception e) {siceeTAltreInfo.setFkMotivo(null);}
			try{siceeTAltreInfo.setMotivoAltro(modDoc.getMOD().getAttestato().getDatiGenerali().getMotivazioneAltro());}catch (Exception e) {siceeTAltreInfo.setMotivoAltro(null);}
			try{siceeTAltreInfo.setInfoMiglPrestEnerg(modDoc.getMOD().getAttestato().getInformazioni().getNote());}catch (Exception e) {siceeTAltreInfo.setInfoMiglPrestEnerg(null);}
			try{siceeTAltreInfo.setFkRuoloCert(Converter.convertToInteger(modDoc.getMOD().getAttestato().getSoggettoCertificatore().getTipoSoggetto()));}catch (Exception e) {siceeTAltreInfo.setFkRuoloCert(null);}
			
			//try{siceeTAltreInfo.setDichInpipendenza(modDoc.getMOD().getAttestato().getSoggettoCertificatore().getDichiarIndip());}catch (Exception e) {siceeTAltreInfo.setDichInpipendenza(null);}
			
			try{siceeTAltreInfo.setUltInfo(modDoc.getMOD().getAttestato().getSoggettoCertificatore().getInfoAgg());}catch (Exception e) {siceeTAltreInfo.setUltInfo(null);}
			try{siceeTAltreInfo.setFlgSopralluogo(decodModolCheckBox(modDoc.getMOD().getAttestato().getSopralluoghi().getFlagEseguitoRilievo()));}catch (Exception e) {siceeTAltreInfo.setFlgSopralluogo(null);}
			try{siceeTAltreInfo.setFlgSw1(decodModolCheckBox(modDoc.getMOD().getAttestato().getSoftware().getDomanda1()));}catch (Exception e) {siceeTAltreInfo.setFlgSw1(null);}
			try{siceeTAltreInfo.setFlgSw2(decodModolCheckBox(modDoc.getMOD().getAttestato().getSoftware().getDomanda2()));}catch (Exception e) {siceeTAltreInfo.setFlgSw2(null);}

			if (operazioneDB.equalsIgnoreCase("UPDATE")) {
				log.debug("\n>>>>>>> UPDATE del record di SICEE_T_ALTRE_INFO");
				SiceeTAltreInfoPk pk = new SiceeTAltreInfoPk();
				pk.setIdCertificatore(idCertificatore);
				pk.setProgrCertificato(progrCertificato);
				pk.setAnno(anno);
				this.getSiceeTAltreInfoDao().update(pk, siceeTAltreInfo);
			} else {
				log.debug("\n>>>>>>> INSERT del record di SICEE_T_ALTRE_INFO");
				this.getSiceeTAltreInfoDao().insert(siceeTAltreInfo);
			}				
	
			//SICEE_T_DATI_ENER_2015
			SiceeTDatiEner2015 siceeTDatiEner2015 = this.getSiceeTDatiEner2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			operazioneDB = "UPDATE";
			if (siceeTDatiEner2015 == null) {
				siceeTDatiEner2015 = new SiceeTDatiEner2015();
				operazioneDB = "INSERT";
			}
			siceeTDatiEner2015.setIdCertificatore(idCertificatore);
			siceeTDatiEner2015.setProgrCertificato(progrCertificato);
			siceeTDatiEner2015.setAnno(anno);
			try{siceeTDatiEner2015.setFlgClimatInvernale(modDoc.getMOD().getAttestato().getDatiGenerali().getFlagServiziClimaInv());}catch (Exception e) {siceeTDatiEner2015.setFlgClimatInvernale(null);}
			try{siceeTDatiEner2015.setFlgClimatEstiva(modDoc.getMOD().getAttestato().getDatiGenerali().getFlagServiziClimaEst());}catch (Exception e) {siceeTDatiEner2015.setFlgClimatEstiva(null);}
			try{siceeTDatiEner2015.setFlgVentilMeccanica(modDoc.getMOD().getAttestato().getDatiGenerali().getFlagServiziVent());}catch (Exception e) {siceeTDatiEner2015.setFlgVentilMeccanica(null);}
			try{siceeTDatiEner2015.setFlgProdH2oSanitaria(modDoc.getMOD().getAttestato().getDatiGenerali().getFlagServiziAcquaCalda());}catch (Exception e) {siceeTDatiEner2015.setFlgProdH2oSanitaria(null);}
			try{siceeTDatiEner2015.setFlgIlluminazione(modDoc.getMOD().getAttestato().getDatiGenerali().getFlagServiziLuce());}catch (Exception e) {siceeTDatiEner2015.setFlgIlluminazione(null);}
			try{siceeTDatiEner2015.setFlgTrasportoPersCose(modDoc.getMOD().getAttestato().getDatiGenerali().getFlagServiziTrasporto());}catch (Exception e) {siceeTDatiEner2015.setFlgTrasportoPersCose(null);}

			try{siceeTDatiEner2015.setFlgEdifE0(modDoc.getMOD().getAttestato().getPrestEnergFabb().getFlagEdifEnergZero());}catch (Exception e) {siceeTDatiEner2015.setFlgEdifE0(null);}
			try{siceeTDatiEner2015.setEpglNrenRif(Converter.convertToDouble(modDoc.getMOD().getAttestato().getPrestEnergFabb().getEpglnrenStandard()));}catch (Exception e) {siceeTDatiEner2015.setEpglNrenRif(null);}
			try{siceeTDatiEner2015.setFkClasseEnergetica(Converter.convertToInteger(modDoc.getMOD().getAttestato().getPrestEnergFabb().getClasseEnergetica()));}catch (Exception e) {siceeTDatiEner2015.setFkClasseEnergetica(null);}
			try{siceeTDatiEner2015.setFkClasseEnerNuovi(Converter.convertToInteger(modDoc.getMOD().getAttestato().getPrestEnergFabb().getCodClasseEdNuovi()));}catch (Exception e) {siceeTDatiEner2015.setFkClasseEnerNuovi(null);}
			
			if (siceeTDatiEner2015.getFkClasseEnerNuovi().intValue() == -1)
				siceeTDatiEner2015.setFkClasseEnerNuovi(null);
			
			try{siceeTDatiEner2015.setEpglNrenNuovi(Converter.convertToDouble(modDoc.getMOD().getAttestato().getPrestEnergFabb().getEpglnrenEdNuovi()));}catch (Exception e) {siceeTDatiEner2015.setEpglNrenNuovi(null);}
			try{siceeTDatiEner2015.setFkClasseEnerEsistenti(Converter.convertToInteger(modDoc.getMOD().getAttestato().getPrestEnergFabb().getCodClasseEdEsistenti()));}catch (Exception e) {siceeTDatiEner2015.setFkClasseEnerEsistenti(null);}
			
			if (siceeTDatiEner2015.getFkClasseEnerEsistenti().intValue() == -1)
				siceeTDatiEner2015.setFkClasseEnerEsistenti(null);
			
			try{siceeTDatiEner2015.setEpglNrenEsistenti(Converter.convertToDouble(modDoc.getMOD().getAttestato().getPrestEnergFabb().getEpglnrenEdEsistenti()));}catch (Exception e) {siceeTDatiEner2015.setEpglNrenEsistenti(null);}
			
			try{siceeTDatiEner2015.setEpglNrenGlobale(Converter.convertToDouble(modDoc.getMOD().getAttestato().getPrestEnergImpianti().getEpglnrenTotale()));}catch (Exception e) {siceeTDatiEner2015.setEpglNrenGlobale(null);}
			try{siceeTDatiEner2015.setEpglRenGlobale(Converter.convertToDouble(modDoc.getMOD().getAttestato().getPrestEnergImpianti().getEpglrenTotale()));}catch (Exception e) {siceeTDatiEner2015.setEpglRenGlobale(null);}
			try{siceeTDatiEner2015.setEmissioniCo2(Converter.convertToDouble(modDoc.getMOD().getAttestato().getPrestEnergImpianti().getEmissioniCO2()));}catch (Exception e) {siceeTDatiEner2015.setEmissioniCo2(null);}
			try{siceeTDatiEner2015.setFkCeRaccTotale(Converter.convertToInteger(modDoc.getMOD().getAttestato().getRaccomandazioni().getClasse()));}catch (Exception e) {siceeTDatiEner2015.setFkCeRaccTotale(null);}
			
			if (siceeTDatiEner2015.getFkCeRaccTotale().intValue() == -1)
				siceeTDatiEner2015.setFkCeRaccTotale(null);
			
			try{siceeTDatiEner2015.setEpglNrenRaccTotale(Converter.convertToDouble(modDoc.getMOD().getAttestato().getRaccomandazioni().getEPglnrenTotale()));}catch (Exception e) {siceeTDatiEner2015.setEpglNrenRaccTotale(null);}
			
			try{siceeTDatiEner2015.setEnergiaEsportata(Converter.convertToDouble(modDoc.getMOD().getAttestato().getAltriDatiEnergetici().getEnergiaEsportata()));}catch (Exception e) {siceeTDatiEner2015.setEnergiaEsportata(null);}

			try{siceeTDatiEner2015.setEph(Converter.convertToDouble(modDoc.getMOD().getAttestato().getAltriDatiFabbricato().getEPHnd()));}catch (Exception e) {siceeTDatiEner2015.setEph(null);}
			try{siceeTDatiEner2015.setEphLimite(Converter.convertToDouble(modDoc.getMOD().getAttestato().getAltriDatiFabbricato().getEPHndLimite()));}catch (Exception e) {siceeTDatiEner2015.setEphLimite(null);}
			try{siceeTDatiEner2015.setAsolAsup(Converter.convertToDouble(modDoc.getMOD().getAttestato().getAltriDatiFabbricato().getRapportoAsolAsup()));}catch (Exception e) {siceeTDatiEner2015.setAsolAsup(null);}
			try{siceeTDatiEner2015.setYie(Converter.convertToDouble(modDoc.getMOD().getAttestato().getAltriDatiFabbricato().getYie()));}catch (Exception e) {siceeTDatiEner2015.setYie(null);}

			GenericUtil.stampa(siceeTDatiEner2015, true, 3);
			
			// Errore particolare: Caso in cui la classe energetica per qualche motivo non risulta calcolata
			// Non ritorno un Fatal, ma trappo l'eccezione, la rilancio a livello più alto e faccio
			// ritornare un messaggio più significativo e rassicurante
			if ((siceeTDatiEner2015.getFkClasseEnergetica() == null) || (siceeTDatiEner2015.getFkClasseEnergetica().intValue() == -1)) {
				retval = Constants.CODERR_FKCLASSEENERGETICA;
				throw new Exception();
			}
			
			if (operazioneDB.equalsIgnoreCase("UPDATE")) {
				log.debug("\n>>>>>>> UPDATE del record di SICEE_T_DATI_ENER_2015");
				SiceeTDatiEner2015Pk pk = new SiceeTDatiEner2015Pk();
				pk.setIdCertificatore(idCertificatore);
				pk.setProgrCertificato(progrCertificato);
				pk.setAnno(anno);
				this.getSiceeTDatiEner2015Dao().update(pk, siceeTDatiEner2015);
			} else {
				log.debug("\n>>>>>>> INSERT del record di SICEE_T_DATI_ENER_2015");
				this.getSiceeTDatiEner2015Dao().insert(siceeTDatiEner2015);
			}				
		
			//SICEE_T_DATI_CATAST_SEC
			log.debug("\n>>>>>>> DELETE dei record di SICEE_T_DATI_CATAST_SEC presenti in tabella");
			this.getSiceeTDaticatastSecDao().delete(idCertificatore, progrCertificato, anno);

			List<RowDatiCatastali> rowDatiCatastaliList = modDoc.getMOD().getAttestato().getDatiPrecompilati().getSezDatiCatastali().getRowDatiCatastaliList();
			SiceeTDaticatastSec siceeTDaticatastSec = null;
			for(RowDatiCatastali rdc : rowDatiCatastaliList) {
				siceeTDaticatastSec = new SiceeTDaticatastSec();
				List<RowSubalterniSingoli> rowSubalterniSingoliList = rdc.getSubalterniSingoli().getRowSubalterniSingoliList();
				
				for(RowSubalterniSingoli rss : rowSubalterniSingoliList) {
					List<String> subalternoList = rss.getSubalternoList();
					for(String subalterno : subalternoList) {
						if (!GenericUtil.isNullOrEmpty(subalterno)) {
							siceeTDaticatastSec.setIdCertificatore(idCertificatore);
							siceeTDaticatastSec.setProgrCertificato(progrCertificato);
							siceeTDaticatastSec.setAnno(anno);
							siceeTDaticatastSec.setCodiceComuneCatastale(rdc.getComuneCatastale());
							siceeTDaticatastSec.setSezione(rdc.getSezione());
							siceeTDaticatastSec.setFoglio(rdc.getFoglio());
							siceeTDaticatastSec.setParticella(rdc.getParticella());
							siceeTDaticatastSec.setSubalterno(subalterno);
							// setto id/desc comune e id/desc provincia con gli stessi valori dei principali su SICEE_T_CERTIFICATO
							siceeTDaticatastSec.setIdComune(siceeTCertificato.getIdComune());
							siceeTDaticatastSec.setDescComune(siceeTCertificato.getDescComune());
							siceeTDaticatastSec.setIdProv(siceeTCertificato.getIdProv());
							siceeTDaticatastSec.setDescProv(siceeTCertificato.getDescProv());
							log.debug("\n>>>>>>> INSERT del record di SICEE_T_DATI_CATAST_SEC --> " + subalterno);
							this.getSiceeTDaticatastSecDao().insert(siceeTDaticatastSec);	
						}
					}
				}
				
				if (rdc.getFlagPrincipale() == false) {
					try {
						int myIntInf = rdc.getDa1().intValue();
						int myIntSup = rdc.getA1().intValue();
						for (int i = myIntInf; i<=myIntSup; i++) {
							siceeTDaticatastSec.setIdCertificatore(idCertificatore);
							siceeTDaticatastSec.setProgrCertificato(progrCertificato);
							siceeTDaticatastSec.setAnno(anno);
							siceeTDaticatastSec.setCodiceComuneCatastale(rdc.getComuneCatastale());
							siceeTDaticatastSec.setSezione(rdc.getSezione());
							siceeTDaticatastSec.setFoglio(rdc.getFoglio());
							siceeTDaticatastSec.setParticella(rdc.getParticella());
							siceeTDaticatastSec.setSubalterno("" + i);
							// setto id/desc comune e id/desc provincia con gli stessi valori dei principali su SICEE_T_CERTIFICATO
							siceeTDaticatastSec.setIdComune(siceeTCertificato.getIdComune());
							siceeTDaticatastSec.setDescComune(siceeTCertificato.getDescComune());
							siceeTDaticatastSec.setIdProv(siceeTCertificato.getIdProv());
							siceeTDaticatastSec.setDescProv(siceeTCertificato.getDescProv());
							log.debug("\n>>>>>>> INSERT del record di SICEE_T_DATI_CATAST_SEC --> subalterno " + i);
							this.getSiceeTDaticatastSecDao().insert(siceeTDaticatastSec);
						}
					} catch (Exception e) {}
					try {
						int myIntInf = rdc.getDa2().intValue();
						int myIntSup = rdc.getA2().intValue();
						for (int i = myIntInf; i<=myIntSup; i++) {
							siceeTDaticatastSec.setIdCertificatore(idCertificatore);
							siceeTDaticatastSec.setProgrCertificato(progrCertificato);
							siceeTDaticatastSec.setAnno(anno);
							siceeTDaticatastSec.setCodiceComuneCatastale(rdc.getComuneCatastale());
							siceeTDaticatastSec.setSezione(rdc.getSezione());
							siceeTDaticatastSec.setFoglio(rdc.getFoglio());
							siceeTDaticatastSec.setParticella(rdc.getParticella());
							siceeTDaticatastSec.setSubalterno("" + i);
							// setto id/desc comune e id/desc provincia con gli stessi valori dei principali su SICEE_T_CERTIFICATO
							siceeTDaticatastSec.setIdComune(siceeTCertificato.getIdComune());
							siceeTDaticatastSec.setDescComune(siceeTCertificato.getDescComune());
							siceeTDaticatastSec.setIdProv(siceeTCertificato.getIdProv());
							siceeTDaticatastSec.setDescProv(siceeTCertificato.getDescProv());
							log.debug("\n>>>>>>> INSERT del record di SICEE_T_DATI_CATAST_SEC --> subalterno " + i);
							this.getSiceeTDaticatastSecDao().insert(siceeTDaticatastSec);
						}
					} catch (Exception e) {}
					try {
						int myIntInf = rdc.getDa3().intValue();
						int myIntSup = rdc.getA3().intValue();
						for (int i = myIntInf; i<=myIntSup; i++) {
							siceeTDaticatastSec.setIdCertificatore(idCertificatore);
							siceeTDaticatastSec.setProgrCertificato(progrCertificato);
							siceeTDaticatastSec.setAnno(anno);
							siceeTDaticatastSec.setCodiceComuneCatastale(rdc.getComuneCatastale());
							siceeTDaticatastSec.setSezione(rdc.getSezione());
							siceeTDaticatastSec.setFoglio(rdc.getFoglio());
							siceeTDaticatastSec.setParticella(rdc.getParticella());
							siceeTDaticatastSec.setSubalterno("" + i);
							// setto id/desc comune e id/desc provincia con gli stessi valori dei principali su SICEE_T_CERTIFICATO
							siceeTDaticatastSec.setIdComune(siceeTCertificato.getIdComune());
							siceeTDaticatastSec.setDescComune(siceeTCertificato.getDescComune());
							siceeTDaticatastSec.setIdProv(siceeTCertificato.getIdProv());
							siceeTDaticatastSec.setDescProv(siceeTCertificato.getDescProv());
							log.debug("\n>>>>>>> INSERT del record di SICEE_T_DATI_CATAST_SEC --> subalterno " + i);
							this.getSiceeTDaticatastSecDao().insert(siceeTDaticatastSec);
						}
					} catch (Exception e) {}
					try {
						int myIntInf = rdc.getDa4().intValue();
						int myIntSup = rdc.getA4().intValue();
						for (int i = myIntInf; i<=myIntSup; i++) {
							siceeTDaticatastSec.setIdCertificatore(idCertificatore);
							siceeTDaticatastSec.setProgrCertificato(progrCertificato);
							siceeTDaticatastSec.setAnno(anno);
							siceeTDaticatastSec.setCodiceComuneCatastale(rdc.getComuneCatastale());
							siceeTDaticatastSec.setSezione(rdc.getSezione());
							siceeTDaticatastSec.setFoglio(rdc.getFoglio());
							siceeTDaticatastSec.setParticella(rdc.getParticella());
							siceeTDaticatastSec.setSubalterno("" + i);
							// setto id/desc comune e id/desc provincia con gli stessi valori dei principali su SICEE_T_CERTIFICATO
							siceeTDaticatastSec.setIdComune(siceeTCertificato.getIdComune());
							siceeTDaticatastSec.setDescComune(siceeTCertificato.getDescComune());
							siceeTDaticatastSec.setIdProv(siceeTCertificato.getIdProv());
							siceeTDaticatastSec.setDescProv(siceeTCertificato.getDescProv());
							log.debug("\n>>>>>>> INSERT del record di SICEE_T_DATI_CATAST_SEC --> subalterno " + i);
							this.getSiceeTDaticatastSecDao().insert(siceeTDaticatastSec);
						}
					} catch (Exception e) {}
				}
			}

			//SICEE_T_QTA_CONSUMI_2015
			log.debug("\n>>>>>>> DELETE dei record di SICEE_T_QTA_CONSUMI_2015 presenti in tabella");
			this.getSiceeTQtaConsumi2015Dao().delete(idCertificatore, progrCertificato, anno);
			ElencoFontiEnergetiche efe = modDoc.getMOD().getAttestato().getPrestEnergImpianti().getElencoFontiEnergetiche();
			List<RowConsumiCombustibile> consumiCombustibileList = efe.getRowConsumiCombustibileList();
			AltreFontiEnergetiche afe = modDoc.getMOD().getAttestato().getPrestEnergImpianti().getAltreFontiEnergetiche();
			RowConsumiCombustibile consumiAltroCombustibile = afe.getRowConsumiCombustibile();
			SiceeTQtaConsumi2015 siceeTQtaConsumi2015 = null;
			
			boolean isImport = modDoc.getMOD().getAttestato().getDatiPrecompilati().getStatoModulo().equalsIgnoreCase(Constants.STATO_MODULO_BOZZA_DA_XML);
			
			for (RowConsumiCombustibile rcc : consumiCombustibileList) {
				siceeTQtaConsumi2015 = new SiceeTQtaConsumi2015();
				siceeTQtaConsumi2015.setIdCertificatore(idCertificatore);
				siceeTQtaConsumi2015.setProgrCertificato(progrCertificato);
				siceeTQtaConsumi2015.setAnno(anno);
				try{siceeTQtaConsumi2015.setFkCombustibile(Converter.convertToInteger(rcc.getIdCombustibile()));}catch (Exception e) {siceeTQtaConsumi2015.setFkCombustibile(null);}
				try{siceeTQtaConsumi2015.setQuantita(Converter.convertToDouble(rcc.getQuantita()));}catch (Exception e) {siceeTQtaConsumi2015.setQuantita(null);}
				try{siceeTQtaConsumi2015.setFkUnitaMisura(Converter.convertToInteger(rcc.getUi()));}catch (Exception e) {siceeTQtaConsumi2015.setFkUnitaMisura(null);}
				//try{siceeTQtaConsumi2015.setAltroDescrComb(rcc.getDescrCombustibile());}catch (Exception e) {siceeTQtaConsumi2015.setAltroDescrComb(null);}
				
				if ("S".equalsIgnoreCase(rcc.getFlagPresente())) {

					if (isImport && 
							Converter.convertToInteger(rcc.getIdCombustibile()).intValue() == Constants.ID_COMBUSTIBILE_GASOLIO)
					{
						// Vuol dire che devo scompattare il valore, devo salvare il valore gasolio e olioCombustibile, salvati sul modulo quando ho fatto l'import
						
						Double quantita = Converter.convertToDouble(modDoc.getMOD().getAttestato().getDatiPrecompilati().getGasolio());
						
						if (quantita != null)
						{
							siceeTQtaConsumi2015.setFkCombustibile(Constants.ID_COMBUSTIBILE_GASOL);
							siceeTQtaConsumi2015.setQuantita(quantita);
							this.getSiceeTQtaConsumi2015Dao().insert(siceeTQtaConsumi2015);
						}

						quantita = Converter.convertToDouble(modDoc.getMOD().getAttestato().getDatiPrecompilati().getOlioCombustibile());
						
						if (quantita != null)
						{
							siceeTQtaConsumi2015.setFkCombustibile(Constants.ID_COMBUSTIBILE_OLIO_COMBUSTIBILE);
							siceeTQtaConsumi2015.setQuantita(quantita);
							this.getSiceeTQtaConsumi2015Dao().insert(siceeTQtaConsumi2015);
						}
					}
					else
					{
						log.debug("\n>>>>>>> INSERT del record di SICEE_T_QTA_CONSUMI_2015");
						this.getSiceeTQtaConsumi2015Dao().insert(siceeTQtaConsumi2015);
					}
				}
			}		
			siceeTQtaConsumi2015 = new SiceeTQtaConsumi2015();
			siceeTQtaConsumi2015.setIdCertificatore(idCertificatore);
			siceeTQtaConsumi2015.setProgrCertificato(progrCertificato);
			siceeTQtaConsumi2015.setAnno(anno);
			siceeTQtaConsumi2015.setFkCombustibile(Constants.ID_COMBUSTIBILE_ALTRO);
			try{siceeTQtaConsumi2015.setQuantita(Converter.convertToDouble(consumiAltroCombustibile.getQuantita()));}catch (Exception e) {siceeTQtaConsumi2015.setQuantita(null);}
			try{siceeTQtaConsumi2015.setFkUnitaMisura(Converter.convertToInteger(consumiAltroCombustibile.getUi()));}catch (Exception e) {siceeTQtaConsumi2015.setFkUnitaMisura(null);}
			try{siceeTQtaConsumi2015.setAltroDescrComb(consumiAltroCombustibile.getDescrCombustibile());}catch (Exception e) {siceeTQtaConsumi2015.setAltroDescrComb(null);}
			if ("S".equalsIgnoreCase(consumiAltroCombustibile.getFlagPresente())) {
				log.debug("\n>>>>>>> INSERT del record di SICEE_T_QTA_CONSUMI_2015");
				this.getSiceeTQtaConsumi2015Dao().insert(siceeTQtaConsumi2015);
			}

			//SICEE_T_RACCOMAND_2015
			log.debug("\n>>>>>>> DELETE dei record di SICEE_T_RACCOMAND_2015 presenti in tabella");
			this.getSiceeTRaccomand2015Dao().delete(idCertificatore, progrCertificato, anno);
			SezioneRen sr = modDoc.getMOD().getAttestato().getRaccomandazioni().getSezioneRen();
			List<RowRen> renList = sr.getRowRenList();
			SiceeTRaccomand2015 siceeTRaccomand2015 = null;
			for (RowRen rr : renList) {
				siceeTRaccomand2015 = new SiceeTRaccomand2015();
				siceeTRaccomand2015.setIdCertificatore(idCertificatore);
				siceeTRaccomand2015.setProgrCertificato(progrCertificato);
				siceeTRaccomand2015.setAnno(anno);
				try{siceeTRaccomand2015.setCodiceRen(rr.getCodRen());}catch (Exception e) {siceeTRaccomand2015.setCodiceRen(null);}
				try{siceeTRaccomand2015.setTipoIntervento(rr.getTipoIntervento());}catch (Exception e) {siceeTRaccomand2015.setTipoIntervento(null);}
				try{siceeTRaccomand2015.setFlgRistrutturazione(rr.getRistrutturazioneImportante());}catch (Exception e) {siceeTRaccomand2015.setFlgRistrutturazione(null);}
				try{siceeTRaccomand2015.setNrAnniRitInvest(Converter.convertToDouble(rr.getAnniRitornoInv()));}catch (Exception e) {siceeTRaccomand2015.setNrAnniRitInvest(null);}
				try{siceeTRaccomand2015.setEpglNrenSingoloInt(Converter.convertToDouble(rr.getEPglnren()));}catch (Exception e) {siceeTRaccomand2015.setEpglNrenSingoloInt(null);}
				try{siceeTRaccomand2015.setFkClasseEnergetica(Converter.convertToInteger(rr.getClasse()));}catch (Exception e) {siceeTRaccomand2015.setFkClasseEnergetica(null);}
				if ((siceeTRaccomand2015.getCodiceRen() != null) && (!siceeTRaccomand2015.getCodiceRen().equalsIgnoreCase("-1"))) {
					log.debug("\n>>>>>>> INSERT del record di SICEE_T_RACCOMAND_2015");
					this.getSiceeTRaccomand2015Dao().insert(siceeTRaccomand2015);
				}
			}		

			//SICEE_R_COMB_DENER_2015
			log.debug("\n>>>>>>> DELETE dei record di SICEE_R_COMB_ENER_2015 presenti in tabella");
			this.getSiceeRCombDener2015Dao().delete(idCertificatore, progrCertificato, anno);
			Vettori v = modDoc.getMOD().getAttestato().getAltriDatiEnergetici().getVettori();
			List<RowVettore> vettoreList = v.getRowVettoreList();
			SiceeRCombDener2015 siceeRCombDener2015 = null;			
			for (RowVettore rv : vettoreList) {	
				GenericUtil.stampa(rv, true, 3);
					
				siceeRCombDener2015 = new SiceeRCombDener2015();
				siceeRCombDener2015.setIdCertificatore(idCertificatore);
				siceeRCombDener2015.setProgrCertificato(progrCertificato);
				siceeRCombDener2015.setAnno(anno);
				try{siceeRCombDener2015.setIdCombustibile(Converter.convertToInteger(rv.getCodVettore()));}catch (Exception e) {siceeRCombDener2015.setIdCombustibile(null);}
				try{siceeRCombDener2015.setDescrAltro(rv.getDescrVettore());}catch (Exception e) {siceeRCombDener2015.setDescrAltro(null);}

				if ((siceeRCombDener2015.getIdCombustibile() != null) && (siceeRCombDener2015.getIdCombustibile() != -1)){
					log.debug("\n>>>>>>> INSERT del record di SICEE_R_COMB_ENER_2015");
					this.getSiceeRCombDener2015Dao().insert(siceeRCombDener2015);
				}
			}		

			//SICEE_T_DET_IMP_2015
			log.debug("\n>>>>>>> DELETE dei record di SICEE_T_DET_IMP_2015 presenti in tabella");
			this.getSiceeTDetImp2015Dao().delete(idCertificatore, progrCertificato, anno);
			this.getSiceeRCertifServener2015Dao().delete(idCertificatore, progrCertificato, anno);
			List<RowImpianto> impiantoList = null;
			Double efficienza = null;
			Double epren = null;
			Double epnren = null;
			
			SezioneClimaInver sci = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneClimaInver();
			impiantoList = sci.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(sci.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(sci.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(sci.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_CLIMAINVER);

			SezioneClimaEst sce = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneClimaEst();
			impiantoList = sce.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(sce.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(sce.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(sce.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_CLIMAEST);
			
			SezioneAcquaCalda sac = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneAcquaCalda();
			impiantoList = sac.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(sac.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(sac.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(sac.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_ACQUACALDA);
			
			SezioneImpiantiCombinati sic = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneImpiantiCombinati();
			impiantoList = sic.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(sic.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(sic.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(sic.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_IMPIANTICOMBINATI);
			
			SezioneProdFontiRinn spfr = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneProdFontiRinn();
			impiantoList = spfr.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(spfr.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(spfr.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(spfr.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_PRODFONTIRINN);
			
			SezioneVentMecc svm = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneVentMecc();
			impiantoList = svm.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(svm.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(svm.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(svm.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_VENTMECC);
			
			SezioneIlluminazione si = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneIlluminazione();
			impiantoList = si.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(si.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(si.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(si.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_ILLUMINAZIONE);
			
			SezioneTrasporto st = modDoc.getMOD().getAttestato().getDettaglioImpianti().getSezioneTrasporto();
			impiantoList = st.getElencoImpianti().getRowImpiantoList();
			try{efficienza = Converter.convertToDouble(st.getEfficienza());}catch (Exception e) {efficienza = null;}
			try{epren = Converter.convertToDouble(st.getEpren());}catch (Exception e) {epren = null;}
			try{epnren = Converter.convertToDouble(st.getEPnren());}catch (Exception e) {epnren = null;}
			iteraDetImp(impiantoList, efficienza, epren, epnren, idCertificatore, progrCertificato, anno, SEZIONE_TRASPORTO);

			
			// Valorizzo EXPORT_BO
			
			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(idCertificatore, progrCertificato, anno);

//			SiceeTCertificato siceeTCertificato,
//			SiceeTDatiGenerali siceeTDatiGenerali, SiceeTDatiEner2015 siceeTDatiEner2015, SiceeTAltreInfo siceeTAltreInfo
			
			boolean isPresents = this.getSiceeTExportBoDao().findByPrimaryKey(exportpk) !=null;
			
			SiceeTExportBo exportBo = this.mapToDBExportBo(exportpk, siceeTCertificato, siceeTDatiGenerali, siceeTDatiEner2015, siceeTAltreInfo);

			if (!isPresents) {
				
				this.getSiceeTExportBoDao().insert(exportBo);
			} else {
				this.getSiceeTExportBoDao().update(exportpk,
						exportBo);
			}
			
			// Valorizzo EXPORT_BO
			
			log.debug("Prima del creaPdfEConsolidaLibretto");
			getServiziMgr().creaPdfEConsolidaCertificatoOLD(cert, idCertificatore, progrCertificato, anno, att);
			
			return retval;
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			if (retval == Constants.CODERR_FKCLASSEENERGETICA.intValue()) {
				// Errore gestito: ritorno il codice di errore particolare
				log.error("Errore gestito: FK_CLASSEENERGETICA NULL");
				return retval;
			} else {
				log.error("Errore in consolidamento: ", e);
				throw new BEException(e.getMessage(), e);
			}
		}
	}
	*/
	
	public String decodModolCheckBox(String iValue) {
		String oValue;
		try {
			if (iValue.equalsIgnoreCase("1"))
				oValue = "S";
			else if (iValue.equalsIgnoreCase("0"))
				oValue = "N";
			else
				oValue = null;
		} catch (Exception e) {
				oValue = null;
		}
		return oValue;
	}
	
	public void iteraDetImp(List<RowImpianto> impiantoList, Double efficienza, Double epren, Double epnren, String idCertificatore, String progrCertificato, String anno, int codServizioEnergetico)
	{	
		SiceeTDetImp2015 siceeTDetImp2015 = null;
		SiceeRCertifServener2015 siceeRCertifServEner2015 = null;
		int i = 0;

		siceeRCertifServEner2015 = new SiceeRCertifServener2015();
		siceeRCertifServEner2015.setIdCertificatore(idCertificatore);
		siceeRCertifServEner2015.setProgrCertificato(progrCertificato);
		siceeRCertifServEner2015.setAnno(anno);
		siceeRCertifServEner2015.setIdServEner(codServizioEnergetico);
		siceeRCertifServEner2015.setEfficienza(efficienza);
		siceeRCertifServEner2015.setEpren(epren);
		siceeRCertifServEner2015.setEpnren(epnren);
		log.debug("\n>>>>>>> INSERT del record di SICEE_R_CERTIF_SERVENER2015");
		this.getSiceeRCertifServener2015Dao().insert(siceeRCertifServEner2015);

		for (RowImpianto ri : impiantoList) {
			
			//GenericUtil.stampa(ri, true, 3);
			siceeTDetImp2015 = new SiceeTDetImp2015();
			siceeTDetImp2015.setIdCertificatore(idCertificatore);
			siceeTDetImp2015.setProgrCertificato(progrCertificato);
			siceeTDetImp2015.setAnno(anno);
			siceeTDetImp2015.setProgressivoDett(++i);
			try{siceeTDetImp2015.setTipoImpianto(ri.getTipoImpianto());}catch (Exception e) {siceeTDetImp2015.setTipoImpianto(null);}
			try{siceeTDetImp2015.setAnnoInstall(Converter.convertToInteger(ri.getAnnoInst()));}catch (Exception e) {siceeTDetImp2015.setAnnoInstall(null);}
			try{siceeTDetImp2015.setCodiceImpiantoCit(Converter.convertToInteger(ri.getCodCatReg()));}catch (Exception e) {siceeTDetImp2015.setCodiceImpiantoCit(null);}
			try{siceeTDetImp2015.setFkCombustibile(Converter.convertToInteger(ri.getCombustibile()));}catch (Exception e) {siceeTDetImp2015.setFkCombustibile(null);}
			if (siceeTDetImp2015.getFkCombustibile() == null)
				siceeTDetImp2015.setFkCombustibile(-1);
			try{siceeTDetImp2015.setPotenzaNominKw(Converter.convertToDouble(ri.getPotenza()));}catch (Exception e) {siceeTDetImp2015.setPotenzaNominKw(null);}
			try{siceeTDetImp2015.setFkServEner(codServizioEnergetico);}catch (Exception e) {siceeTDetImp2015.setFkServEner(null);}
			//log.debug("\n>>>>>>> codServizioEnergetico " + codServizioEnergetico);
			//log.debug("\n>>>>>>> siceeTDetImp2015.getTipoImpianto() " + siceeTDetImp2015.getTipoImpianto());
			//log.debug("\n>>>>>>> siceeTDetImp2015.getFkCombustibile() " + siceeTDetImp2015.getFkCombustibile());
			if ((siceeTDetImp2015.getTipoImpianto() != null) && (siceeTDetImp2015.getFkCombustibile() != -1)) {
				log.debug("\n>>>>>>> INSERT del record di SICEE_T_DET_IMP_2015");
				this.getSiceeTDetImp2015Dao().insert(siceeTDetImp2015);
			}
		}		

	}

	
	/**
	 * Proporzione qh.
	 *
	 * @param value the value
	 * @return the float
	 */
	public float proporzioneQh(float value) {
		if (value > 400) {
			return 100;
		}
		if (value < 0) {
			return 0;
		}

		return value / 4; // (v*100/400)
	}

	/**
	 * Proporzione fabbisogno energetico acs.
	 *
	 * @param value the value
	 * @return the float
	 */
	public float proporzioneFabbisognoEnergeticoAcs(float value) {
		if (value > 100) {
			return 100;
		}
		if (value < 0) {
			return 0;
		}

		return value; // (v*100/100)
	}

	/**
	 * Proporzione gas serra.
	 *
	 * @param value the value
	 * @return the float
	 */
	public float proporzioneGasSerra(float value) {
		if (value > 100) {
			return 100;
		}
		if (value < 0) {
			return 0;
		}

		return value; // (v*100/100)
	}

	/**
	 * Aggiorna stato definitivo.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void aggiornaStatoDefinitivo(DatiCertificatore cert,
			DatiAttestato att) throws BEException {
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];
		try {
			SiceeTCertificato dto = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(id, prog, anno);
			if (dto.getFkStato() < 3) {
				dto.setFkStato(Constants.CONSOLIDATO);
				this.getSiceeTCertificatoDao().update(dto.createPk(), dto);
				att.setStatus(Constants.CONSOLIDATO);

				SiceeTExportBoPk exportpk = new SiceeTExportBoPk(id, prog, anno);
				SiceeTExportBo exportBo = this.getSiceeTExportBoDao()
						.findByPrimaryKey(exportpk);

				if (exportBo == null) {
					
					exportBo = creaExportBo(cert, att.getNumeroAttestato());
					this.getSiceeTExportBoDao().insert(exportBo);
				} else {
					// Recupero i dati aggiornati
					exportBo = creaExportBo(cert, att.getNumeroAttestato());
					this.getSiceeTExportBoDao().update(exportpk,
							exportBo);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Aggiorna stato inviato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param uid the uid
	 * @param nomePdf the nome pdf
	 * @param stato the stato
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void aggiornaStatoInviato(DatiCertificatore cert, DatiAttestato att,
			String uid, String nomePdf, String hashFile, int stato) throws BEException {
		
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];
		try {
			SiceeTCertificato dto = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(id, prog, anno);
			dto.setFkStato(stato);
			dto.setDtUpload(new Date(System.currentTimeMillis()));
			dto.setIdentificPdf(uid);
			dto.setNomePdf(nomePdf);
			
			this.getSiceeTCertificatoDao().update(dto.createPk(), dto);
			
			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(id, prog, anno);
			
			SiceeTExportBo exportBo = this.getSiceeTExportBoDao()
					.findByPrimaryKey(exportpk);
			
			if (exportBo == null) {
				att = this.recuperaAttestato(cert, att.getNumeroAttestato());
				
				exportBo = this.creaExportBo(cert, att.getNumeroAttestato());
				//exportBo.setDtUpload(new Date(System.currentTimeMillis()));
				this.getSiceeTExportBoDao().insert(exportBo);
			} 
			else
			{
				exportBo.setDtUpload(dto.getDtUpload());
				exportBo.setFkStato(stato);
				this.getSiceeTExportBoDao().update(exportpk, exportBo);
			}
			
			// Inserita questa verifica nel caso in cui si facciano delle prove in PROD
			SiceeTParametri param = getSiceeTParametriDao().findWhereCodiceEquals(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{
				if (new Long(dto.getIdCertificatore()) > new Long(param.getValore())) 
				{

					if (stato == Constants.INVIATO)
					{
						// Inserisco una riga anche nella tabellea SIEE_T_ACTA, in modo che si sappia quali certificati bisogna archiviare/protocollare
						SiceeTActa acta = new SiceeTActa();
						acta.setIdCertificatore(dto.getIdCertificatore());
						acta.setProgrCertificato(dto.getProgrCertificato());
						acta.setAnno(dto.getAnno());
						this.getSiceeTActaDao().insert(acta);

						// Inserisco una riga anche nella tabellea SIEE_T_SIAPE, in modo che si sappia quali certificati bisogna inviare al SIAPE
						SiceeTSiape siape = new SiceeTSiape();
						siape.setIdCertificatore(dto.getIdCertificatore());
						siape.setProgrCertificato(dto.getProgrCertificato());
						siape.setAnno(dto.getAnno());
						siape.setIdTipoAzione(Constants.ID_TIPO_AZIONE_INVIO);
						siape.setFlgDaElaborare(Constants.SI);
						this.getSiceeTSiapeDao().insert(siape);
					}
				}
			}
			
			inserisciDocumento(id, prog, anno, Constants.ID_PDF_APE_FIRMATO, nomePdf, hashFile ,uid);
			
			log.debug("CREO LA TARGHETTA - INIZIO");
			getServiziMgr().creaPdfTarghetta(cert, id, prog, anno, att);
			log.debug("CREO LA TARGHETTA - FINE");
//			SiceeTRifIndex2015 rifIndex = new SiceeTRifIndex2015();
//			getSiceeTRifIndex2015Dao().insert(dto)
			
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Errore", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Aggiorna stato inviato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @throws BEException the bE exception
	 */
	public void aggiornaStatoInviato(DatiCertificatore cert, DatiAttestato att)
			throws BEException {
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];
		try {
			SiceeTCertificato dto = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(id, prog, anno);
			dto.setFkStato(Constants.INVIATO);
			this.getSiceeTCertificatoDao().update(dto.createPk(), dto);

			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(id, prog, anno);
			SiceeTExportBo exportBo = this.getSiceeTExportBoDao()
					.findByPrimaryKey(exportpk);

			if (exportBo == null) {
				att = this.recuperaAttestato(cert, split[1]);
				
				exportBo = creaExportBo(cert, att.getNumeroAttestato());
				
				this.getSiceeTExportBoDao().insert(exportBo);
			} else {
				exportBo.setFkStato(Constants.INVIATO);
				this.getSiceeTExportBoDao().update(exportpk, exportBo);
			}
			
			// Inserita questa verifica nel caso in cui si facciano delle prove in PROD
			SiceeTParametri param = getSiceeTParametriDao().findWhereCodiceEquals(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{
				if (new Long(dto.getIdCertificatore()) > new Long(param.getValore())) 
				{
					// Inserisco una riga anche nella tabellea SIEE_T_ACTA, in modo che si sappia quali certificati bisogna archiviare/protocollare
					SiceeTActa acta = new SiceeTActa();
					acta.setIdCertificatore(dto.getIdCertificatore());
					acta.setProgrCertificato(dto.getProgrCertificato());
					acta.setAnno(dto.getAnno());
					this.getSiceeTActaDao().insert(acta);

					// Inserisco una riga anche nella tabellea SIEE_T_SIAPE, in modo che si sappia quali certificati bisogna inviare al SIAPE
					SiceeTSiape siape = new SiceeTSiape();
					siape.setIdCertificatore(dto.getIdCertificatore());
					siape.setProgrCertificato(dto.getProgrCertificato());
					siape.setAnno(dto.getAnno());
					siape.setIdTipoAzione(Constants.ID_TIPO_AZIONE_INVIO);
					siape.setFlgDaElaborare(Constants.SI);
					this.getSiceeTSiapeDao().insert(siape);
				}
			}
			// exportBo.setFkStato(Constants.INVIATO);

			// getSiceeTExportBoDao().update(exportBo.createPk(), exportBo);

		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Aggiorna stato annullato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param idMotivoSost the id motivo sost
	 * @param dataSost the data sost
	 * @param noteSost the note sost
	 * @throws BEException the bE exception
	 */
	public void aggiornaStatoAnnullato(DatiCertificatore cert,
			DatiAttestato att, int idMotivoSost, Date dataSost, String noteSost)
			throws BEException {

		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];
		try {
			SiceeTCertificato dto = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(id, prog, anno);
			dto.setFkStato(Constants.ANNULLATO);
			dto.setFkMotivoSost(idMotivoSost);
			dto.setDtSostituzione(dataSost);
			dto.setNoteSostituzione(noteSost);
			this.getSiceeTCertificatoDao().update(dto.createPk(), dto);

			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(id, prog, anno);
			SiceeTExportBo exportBo = this.getSiceeTExportBoDao()
					.findByPrimaryKey(exportpk);
			if (exportBo == null) {
				//att = this.recuperaAttestato(cert, att.getNumeroAttestato());
				
				exportBo = creaExportBo(cert, att.getNumeroAttestato());
				
				this.getSiceeTExportBoDao().insert(exportBo);
			} else {
				exportBo.setFkStato(Constants.ANNULLATO);
				this.getSiceeTExportBoDao().update(exportpk, exportBo);
			}

			// Inserita questa verifica nel caso in cui si facciano delle prove in PROD
			SiceeTParametri param = getSiceeTParametriDao().findWhereCodiceEquals(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{
				if (new Long(id) > new Long(param.getValore())) 
				{
					// Inserisco una riga anche nella tabellea SIEE_T_SIAPE, in modo che si sappia quali certificati bisogna inviare al SIAPE
					// Bisogna inviare a SIAPE i certificati annullati solo se in precenza è stato inviato quello di inserimento,
					// nel caso di annullamento di certificati vecchi non bisogna mandarlo al SIAPE
					SiceeTSiape siape = this.getSiceeTSiapeDao().findByPrimaryKey(dto.getIdCertificatore(), dto.getProgrCertificato(), dto.getAnno(), Constants.ID_TIPO_AZIONE_INVIO);

					if (siape != null)
					{
						siape.setIdTipoAzione(Constants.ID_TIPO_AZIONE_ANNULLAMENTO);
						siape.setFlgDaElaborare(Constants.SI);
						this.getSiceeTSiapeDao().insert(siape);
					}
				}
			}
			if (dto.getFlgOld().equalsIgnoreCase(Constants.NO))
			{
				log.debug("Prima del creaPdfEConsolidaLibretto");
				//getServiziMgr().creaPdfEAnnullaCertificato(cert, id, prog, anno, att);
				getServiziMgr().creaPdfEAnnullaCertificatoReadOnly(cert, id, prog, anno, att);
			}

		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Sostituisci certificati.
	 *
	 * @param cert the cert
	 * @param attestatiOld the attestati old
	 * @param attestatiNew the attestati new
	 * @param datiAnnullamento the dati annullamento
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void sostituisciCertificati(DatiCertificatore cert,
			ArrayList<Ace> attestatiOld, ArrayList<Ace> attestatiNew,
			DtAnnullamento datiAnnullamento) throws BEException {

		try {
			// Aggiorno gli attestati OLD
			for (int i = 0; i < attestatiOld.size(); i++) {
				DatiAttestato attestato = new DatiAttestato();
				attestato.setNumeroAttestato(attestatiOld.get(i).getCodice());

				String[] splitOld = attestatiOld.get(i).getCodice().split(" ");
				
				
				SiceeTCertificatore certificatoreOld = this.getCertificatoreMgr()
						.getSiceeTCertificatoreDao()
						.findWhereNumCertificatoreEquals(splitOld[1]);
				
//				String idOld = this.getCertificatoreMgr()
//						.getSiceeTCertificatoreDao()
//						.findWhereNumCertificatoreEquals(splitOld[1])
//						.getIdCertificatore();

				DatiCertificatore certOld = new DatiCertificatore();
				certOld.setIdCertificatore(certificatoreOld.getIdCertificatore());
				certOld.setNumCertificatore(certificatoreOld.getNumCertificatore());
				this.aggiornaStatoAnnullato(certOld, attestato,
						datiAnnullamento.getIdMotivo(),
						DateUtil.convertToDate(datiAnnullamento.getData()),
						datiAnnullamento.getNote());

			}

			// Aggiorno gli attestati NEW
			for (int i = 0; i < attestatiNew.size(); i++) {
				DatiAttestato attestato = new DatiAttestato();
				attestato.setNumeroAttestato(attestatiNew.get(i).getCodice());

				this.aggiornaStatoInviato(cert, attestato);

			}

			// Inserisco nella tabella TSostituzione
			// Recupero il progressivo della sostituzione
			int idSostituzioneProgr = this.getSiceeTSostituzioneDao()
					.getNextValueSostituzioneProgr();

			for (int i = 0; i < attestatiOld.size(); i++) {

				String[] splitOld = attestatiOld.get(i).getCodice().split(" ");
				String idOld = this
						.getCertificatoreMgr()
						.getSiceeTCertificatoreDao()
						.findWhereNumCertificatoreEquals(
								splitOld[Constants.PK_ID_CERTIFICATORE])
						.getIdCertificatore();
				String progOld = splitOld[Constants.PK_PROGR];
				String annoOld = splitOld[Constants.PK_ANNO];

				for (int j = 0; j < attestatiNew.size(); j++) {

					SiceeTSostituzione sostituzione = new SiceeTSostituzione();
					sostituzione.setProgrSostituzione(idSostituzioneProgr);

					sostituzione.setIdCertificatoreOld(idOld);
					sostituzione.setAnnoOld(annoOld);
					sostituzione.setProgrCertificatoOld(progOld);

					String[] splitNew = BaseMgr.recuperaChiaveAttestato(cert
							.getIdCertificatore(), attestatiNew.get(j)
							.getCodice());

					String idNew = splitNew[Constants.PK_ID_CERTIFICATORE];
					String progNew = splitNew[Constants.PK_PROGR];
					String annoNew = splitNew[Constants.PK_ANNO];

					sostituzione.setIdCertificatoreNew(idNew);
					sostituzione.setAnnoNew(annoNew);
					sostituzione.setProgrCertificatoNew(progNew);

					if (log.isDebugEnabled())
						GenericUtil.stampa(sostituzione, true, 4);

					this.getSiceeTSostituzioneDao().insert(sostituzione);

				}
			}

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	// BEPPE
	/**
	 * Invio mail sostituzione certificati.
	 *
	 * @param certificatoreNew the certificatore new
	 * @param attestatiOld the attestati old
	 * @param attestatiNew the attestati new
	 * @throws BEException the bE exception
	 */
	public void invioMailSostituzioneCertificati(
			DatiCertificatore certificatoreNew, ArrayList<Ace> attestatiOld,
			ArrayList<Ace> attestatiNew) throws BEException {

		try {

			String attestatiNewFormat = "";
			// Formatto i certificati NEW per la mail
			for (int i = 0; i < attestatiNew.size(); i++) {
				if (i != 0) {
					attestatiNewFormat += ", ";
				}
				attestatiNewFormat += attestatiNew.get(i).getCodice();

			}

			for (int i = 0; i < attestatiOld.size(); i++) {

				String[] splitOld = attestatiOld.get(i).getCodice().split(" ");
				String idOld = this
						.getCertificatoreMgr()
						.getSiceeTCertificatoreDao()
						.findWhereNumCertificatoreEquals(
								splitOld[Constants.PK_ID_CERTIFICATORE])
						.getIdCertificatore();
				String progOld = splitOld[Constants.PK_PROGR];
				String annoOld = splitOld[Constants.PK_ANNO];

				SiceeTCertificatore certificatoreOld = this
						.getCertificatoreMgr().getSiceeTCertificatoreDao()
						.findWhereNumCertificatoreEquals(splitOld[1]);

				SiceeTCertificato certificatoOld = this
						.getSiceeTCertificatoDao().findByPrimaryKey(idOld,
								progOld, annoOld);

				MotivoAnnullamento motivoAnnullamento = this.getMiscMgr()
						.getMotivoAnnullamentoById(
								certificatoOld.getFkMotivoSost());

				DtAnnullamento annullamento = new DtAnnullamento();
				annullamento.setDescMotivo(motivoAnnullamento.getDescr());
				annullamento.setNote(certificatoOld.getNoteSostituzione());
				annullamento.setData(DateUtil.convertToString(new Date(System
						.currentTimeMillis())));

				try {

					boolean isMailInviata = false;
					try {
						this.getMiscMgr().sendMailPerAnnullamento(
								attestatiOld.get(i).getCodice(),
								attestatiNewFormat,
								certificatoreOld.getEmail(), annullamento);
						isMailInviata = true;
					} catch (Exception ex) {
						isMailInviata = false;
						log.error(
								"Erroe nell'invio della mail o dell'aggiornamento dello stato",
								ex);
					}

					for (int j = 0; j < attestatiNew.size(); j++) {

						String[] splitNew = BaseMgr.recuperaChiaveAttestato(
								certificatoreNew.getIdCertificatore(),
								attestatiNew.get(j).getCodice());

						String idNew = splitNew[Constants.PK_ID_CERTIFICATORE];
						String progNew = splitNew[Constants.PK_PROGR];
						String annoNew = splitNew[Constants.PK_ANNO];

						SiceeTSostituzione sostituzioneDao = this
								.getSiceeTSostituzioneDao()
								.findBySiceeTCertificatoOldNew(idOld, idNew,
										progOld, progNew, annoOld, annoNew);

						sostituzioneDao
								.setFlgInvioMail(isMailInviata ? Constants.SI
										: Constants.NO);
						sostituzioneDao.setEmail(certificatoreOld.getEmail());

						this.getSiceeTSostituzioneDao().update(
								sostituzioneDao.createPk(), sostituzioneDao);

					}
				} catch (Exception ex) {
					log.error(
							"Erroe nell'invio della mail o dell'aggiornamento dello stato",
							ex);
				}

			}

		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}


	public byte[] recuperaFotoJasper(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		byte[] ret = null;
		String indexImage = null;
		List<SiceeTFoto2015> voList = null;
		try {
			voList = this.getSiceeTFoto2015Dao().findBySiceeTCertificatoFlgPrincipale(idCertificatore, progrCertificato, anno, "S");
			if ((voList == null) || (voList.size() == 0)) {
				log.debug("\n>>>>>>>NESSUNA FOTO PRESENTE");
			}
			else {
				log.debug("\n>>>>>>>FOTO PRESENTE");
				SiceeTFoto2015 vo = voList.get(0);
				Documento doc = getSoaIntegrationMgr().recuperaDocumento(vo.getIdentificFoto());
				if (doc.getDoc() != null) {
					ret = doc.getDoc();
//		            byte[] immagineEncodata = Base64.encode(doc.getDoc());
//		            indexImage = new String(immagineEncodata);
					
			    }
			}
		} catch (Exception e) {
			log.error("Errore in recuperaFotoJasper", e);
			throw new BEException(e.getMessage(), e);
		}
		return ret;
		//return indexImage;
	}
	
	
	/**
	 * Check stato inviato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @return the string
	 */
	public String checkStatoInviato(DatiCertificatore cert, DatiAttestato att) {
		String[] split = BaseMgr.recuperaChiaveAttestato(
				cert.getIdCertificatore(), att.getNumeroAttestato());

		String id = split[Constants.PK_ID_CERTIFICATORE];
		String prog = split[Constants.PK_PROGR];
		String anno = split[Constants.PK_ANNO];
		String date = null;
		try {
			Date now = new Date(System.currentTimeMillis());

			SiceeTCertificato dto = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(id, prog, anno);
			if (dto != null) {
				if (now.before(dto.getDtInizio())) {
					date = DateUtil.convertToString(dto.getDtInizio());
				}
			}

		} catch (SiceeTCertificatoDaoException e) {
			log.error(e.getMessage(), e);
		}

		return date;
	}

	/**
	 * Inserisci certificati.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @param idTrans the id trans
	 * @return the integer
	 * @throws BEException the bE exception
	 */
	private Integer inserisciCertificati(
			DatiCertificatore cert, Long idTrans, String quantita) throws BEException {
		int numeroAceAcquistati = Integer.parseInt(quantita);
		Integer prog = null;
		String data = DateUtil.convertToString(new java.util.Date(System
				.currentTimeMillis()));
		String anno = data.substring(6);
		try {
			if (this.getSiceeWCertificatoreDao().findByPrimaryKey(
					BaseMgr.convertToInteger(cert.getIdCertificatore()), anno) == null) {
				this.insertCertificatoreProgressivo(cert, anno);
			}

			for (int i = 0; i < numeroAceAcquistati; i++) {
				Integer p = this.insertCertificato(cert, idTrans, anno);
				if (i == 0) {
					prog = p;
				}
			}
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

		return prog;
	}
	
	
	public String getHashFile(byte[] theFile) throws BEException {
		
		FileInputStream fileInputStream=null;
		String retAsh=null;
		
		    try {
		    	/*
		    	byte[] bFile = new byte[(int) fAsh.length()];
				FileInputStream is = new FileInputStream(fAsh);
				is.read(bFile);
				is.close();
			    
			    MessageDigest md = MessageDigest.getInstance("SHA1");
			    byte[] dataBytes = new byte[bFile.length];
			    int nread = 0; 
			    
			    while ((nread = is.read(dataBytes)) != -1) {
			      md.update(dataBytes, 0, nread);
			    };
			    byte[] mdbytes = md.digest();
			    */
			    

			    // PRIMO FILE
			    MessageDigest md = MessageDigest.getInstance("SHA1");
				InputStream is = new ByteArrayInputStream(theFile);
			    //FileInputStream is = new FileInputStream(fAsh);
			    byte[] dataBytes = new byte[1024];
			    int nread = 0; 
			    while ((nread = is.read(dataBytes)) != -1) {
			      md.update(dataBytes, 0, nread);
			    };
			    byte[] mdbytes = md.digest();
			    
			    //byte --> hex format
			    StringBuffer sb = new StringBuffer("");
			    for (int i = 0; i < mdbytes.length; i++) {
			    	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			    }
			    
				if (log.isDebugEnabled())
					log.debug("ASH TROVATO=" + sb.toString());
				
			    retAsh = sb.toString();
			    
	    } catch (FileNotFoundException e) {
	    	log.error("Errore", e);
	    	throw new BEException(e.getMessage(), e);
	    } catch (IOException e) {
	    	log.error("Errore", e);
	    	throw new BEException(e.getMessage(), e);
	    }catch (NoSuchAlgorithmException e) {
	    	log.error("Errore", e);
	    	throw new BEException(e.getMessage(), e);
	    }
		
		return retAsh;
	}
	
	
	//@@SETTEMBRE 2015 INIZIO
	//Dichiaro metodo per ash del file
	public String getAshFile(File fAsh) throws BEException {
		
			FileInputStream fileInputStream=null;
			String retAsh=null;
			
			    try {
			    	/*
			    	byte[] bFile = new byte[(int) fAsh.length()];
					FileInputStream is = new FileInputStream(fAsh);
					is.read(bFile);
					is.close();
				    
				    MessageDigest md = MessageDigest.getInstance("SHA1");
				    byte[] dataBytes = new byte[bFile.length];
				    int nread = 0; 
				    
				    while ((nread = is.read(dataBytes)) != -1) {
				      md.update(dataBytes, 0, nread);
				    };
				    byte[] mdbytes = md.digest();
				    */
				    
				    
				    // PRIMO FILE
				    MessageDigest md = MessageDigest.getInstance("SHA1");
				    FileInputStream is = new FileInputStream(fAsh);
				    byte[] dataBytes = new byte[1024];
				    int nread = 0; 
				    while ((nread = is.read(dataBytes)) != -1) {
				      md.update(dataBytes, 0, nread);
				    };
				    byte[] mdbytes = md.digest();
				    
				    //byte --> hex format
				    StringBuffer sb = new StringBuffer("");
				    for (int i = 0; i < mdbytes.length; i++) {
				    	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
				    }
				    
					if (log.isDebugEnabled())
						log.debug("ASH TROVATO=" + sb.toString());
					
				    retAsh = sb.toString();
				    
		    } catch (FileNotFoundException e) {
		    	log.error("Errore", e);
		    	throw new BEException(e.getMessage(), e);
		    } catch (IOException e) {
		    	log.error("Errore", e);
		    	throw new BEException(e.getMessage(), e);
		    }catch (NoSuchAlgorithmException e) {
		    	log.error("Errore", e);
		    	throw new BEException(e.getMessage(), e);
		    }
			
			return retAsh;
	}
	//@@SETTEMBRE 2015 FINE
	
	
	//Aggiungere DAO per ritorno Ash
	//SiceeTRifIndex2015 dao=new SiceeTRifIndex2015();
	//@@SETTEMBRE 2015 FINE
	
	/**
	 * Chiudi transazione.
	 *
	 * @param dp the dp
	 * @return the long
	 * @throws BEException the bE exception
	 */
	/*
	@Transactional
	private Long chiudiTransazione(Long idTransazione) throws BEException {
		Long idTrans = null;
		try {
			idTrans = this.getTransazioneAceMgr().chiudiTransazione(dp);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return idTrans;
	}
	*/

	/**
	 * Completa acquisto ace.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @return the long
	 * @throws BEException the bE exception
	 */
	
	@Transactional
	public void completaAcquistoACE(Long idTransazione, DatiCertificatore cert)
			throws BEException {
		
		try {
			
			// Verifico se sono già presenti dei certificati per questa transazione (non dovrebbe)
			List<SiceeTCertificato> listProblem = this.getSiceeTCertificatoDao()
					.findBySiceeTTransazioneAce(idTransazione);
			
			// Vuol dire che non esiste nessun certificato per questa transazione
			// nel caso ci fossero già dei certificati NON li reinserisco
			if (listProblem == null || listProblem.size() == 0)
			{
				
				this.getTransazioneAceMgr().chiudiTransazione(idTransazione);
				
				TransazioneAce transazione = this.getTransazioneAceMgr().getTransazioneAce(idTransazione);
				
				this.inserisciCertificati(cert, idTransazione, transazione.getQuantita());
				
			}
			else
			{
				// Sono nel caso di duplicazione ACE, quindi li scarto ma mando comunque la notifica
				
				StringBuffer testoErrore = new StringBuffer("Si e' verificato un problema di duplicazione acquisizione APE:<BR> IdCertificatore: "+cert.getIdCertificatore()+" <BR> idTransazione: "+idTransazione+"<BR><BR>");

				testoErrore.append("<BR> Esistono gia' delle transazioni (su SiceeTCertificato) per questa Transazione");
				testoErrore.append("<BR> idTransazione: "+idTransazione);
				testoErrore.append("<BR> numero transazioni presenti: "+listProblem.size());
				testoErrore.append("<BR> RICERCO LA TRANSAZIONE sul DB");
				
				TransazioneAce transazioneDB = this.getTransazioneAceMgr().getTransazioneAce(idTransazione);

				testoErrore.append("<BR> IdTransazione: "+transazioneDB.getIdTransazione());
				testoErrore.append("<BR> NumeroTransazione: "+transazioneDB.getNumeroTransazione());
				testoErrore.append("<BR> DataTransazione: "+transazioneDB.getDataTransazione());
				testoErrore.append("<BR> Quantita: "+transazioneDB.getQuantita());
				testoErrore.append("<BR> TipoTransazione: "+transazioneDB.getTipoTransazione());
				testoErrore.append("<BR> Stato: "+transazioneDB.getStato());

				Transazione transazioneMDP = this.getSoaIntegrationMgr()
						.verificaTransazionePagamento(transazioneDB.getNumeroTransazione());
				
				testoErrore.append("<BR> RICERCO LA TRANSAZIONE sul MDP");
				
				testoErrore.append("<BR> CodStato: "+transazioneMDP.getCodStato());
				testoErrore.append("<BR> Amount: "+transazioneMDP.getAmount());
				
				// Invio la mail per avvisare dell'anomalia
				getMiscMgr().sendMailPerProblema(testoErrore.toString());
				
				log.error("CertificatoMgr :: completaAcquistoACE - " + testoErrore);
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			
			log.error("CertificatoMgr :: completaAcquistoACE - ho ricevuto un'eccezione",e);
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Completa acquisto ace.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @return the long
	 * @throws BEException the bE exception
	 */
	
	@Transactional
	public void completaAcquistoACEOld(Long idTransazione, DatiCertificatore cert)
			throws BEException {
		
		// Da togliere dopo che si scopre il problema delle bollettini doppi
		//Logger logProblem = Logger.getLogger("siceewebProblem");
		boolean isError = false;
		StringBuffer testoErrore = new StringBuffer("Si e' verificato un problema di duplicazione acquisizione APE:<BR> IdCertificatore: "+cert.getIdCertificatore()+" <BR> idTransazione: "+idTransazione+"<BR><BR>");
		
		try {
			//this.getTransazioneAceMgr().aggiornaStatoTransazione(idTransazione);
			
			/**
			 * CODICE INSERITO PER CAPIRE COME MAI A VOLTE VENGONO INSERITI IL DOPPIO DEI CERTIFICATI - inizio
			 * (è codice che dopo che si scova il baco si può cancellare)
			 */
			
			
			// Verifico se sono già presenti dei certificati per questa transazione (non dovrebbe)
			List<SiceeTCertificato> listProblem = this.getSiceeTCertificatoDao()
					.findBySiceeTTransazioneAce(idTransazione);
			
			
//			log.info("STAMPO LA LISTPROBLEM: "+listProblem);
//			log.info("STAMPO LA listProblem.size(): "+listProblem.size());
			
			if (listProblem != null && listProblem.size() > 0)
			{
				isError = true;

				// Non dovrebbe succedere


				testoErrore.append("<BR> Esistono gia' delle transazioni (su SiceeTCertificato) per questa Transazione");
				testoErrore.append("<BR> idTransazione: "+idTransazione);
				testoErrore.append("<BR> numero transazioni presenti: "+listProblem.size());
				testoErrore.append("<BR> RICERCO LA TRANSAZIONE sul DB");
				
				TransazioneAce transazioneDB = this.getTransazioneAceMgr().getTransazioneAce(idTransazione);

				testoErrore.append("<BR> IdTransazione: "+transazioneDB.getIdTransazione());
				testoErrore.append("<BR> NumeroTransazione: "+transazioneDB.getNumeroTransazione());
				testoErrore.append("<BR> DataTransazione: "+transazioneDB.getDataTransazione());
				testoErrore.append("<BR> Quantita: "+transazioneDB.getQuantita());
				testoErrore.append("<BR> TipoTransazione: "+transazioneDB.getTipoTransazione());
				testoErrore.append("<BR> Stato: "+transazioneDB.getStato());

				Transazione transazioneMDP = this.getSoaIntegrationMgr()
						.verificaTransazionePagamento(transazioneDB.getNumeroTransazione());
				
				testoErrore.append("<BR> RICERCO LA TRANSAZIONE sul MDP");
				
				testoErrore.append("<BR> CodStato: "+transazioneMDP.getCodStato());
				testoErrore.append("<BR> Amount: "+transazioneMDP.getAmount());
				
				log.error("CertificatoMgr :: completaAcquistoACE - " + testoErrore);
				
				
			}
			
			/**
			 * CODICE INSERITO PER CAPIRE COME MAI A VOLTE VENGONO INSERITI IL DOPPIO DEI CERTIFICATI - fine
			 * (è codice che dopo che si scova il baco si può cancellare)
			 */
			
			this.getTransazioneAceMgr().chiudiTransazione(idTransazione);
			
			
			if (isError)
			{
				log.error("CertificatoMgr :: completaAcquistoACE - Ho chiuso la transazione che sarebbe dovuto essere già chiusa");

			}
			
			TransazioneAce transazione = this.getTransazioneAceMgr().getTransazioneAce(idTransazione);
			
			this.inserisciCertificati(cert, idTransazione, transazione.getQuantita());
			
			/**
			 * CODICE INSERITO PER CAPIRE COME MAI A VOLTE VENGONO INSERITI IL DOPPIO DEI CERTIFICATI - inizio
			 * (è codice che dopo che si scova il baco si può cancellare)
			 */
			
			// Verifico quanti certificati per questa transazione sono presenti
			List<SiceeTCertificato> listProblem2 = this.getSiceeTCertificatoDao()
						.findBySiceeTTransazioneAce(idTransazione);
			
			int numeroAceAcquistati = Integer.parseInt(transazione.getQuantita());

			if (numeroAceAcquistati != listProblem2.size())
			{
				testoErrore.append("<BR> Non corrisponde il numero degli ACE inseriti con quelli acquistati");
				
				testoErrore.append("<BR> numeroAceAcquistati: " +numeroAceAcquistati);
				testoErrore.append("<BR> numeroAceInseriti: " +listProblem2.size());

				log.error("CertificatoMgr :: completaAcquistoACE - " + testoErrore);
				
				//log.error("CertificatoMgr :: completaAcquistoACE - Non corrisponde il numero degli ACE inseriti");
				
				isError = true;
			}
			
			/**
			 * CODICE INSERITO PER CAPIRE COME MAI A VOLTE VENGONO INSERITI IL DOPPIO DEI CERTIFICATI - fine
			 * (è codice che dopo che si scova il baco si può cancellare)
			 */
			
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			
			log.error("CertificatoMgr :: completaAcquistoACE - ho ricevuto un'eccezione",e);
			isError = true;
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		finally
		{
			log.error("CertificatoMgr :: completaAcquistoACE - verifico se si è verificato un errore: "+isError);
			
			if (isError)
			{
				
				// Invio la mail per avvisare dell'anomalia
				getMiscMgr().sendMailPerProblema(testoErrore.toString());
			}
		}

	}
	
	public void generaACE(String idCertificatore, GestioneCreditoNew gestCredito)
			throws BEException {

		try {
			
			int numeroAceAcquistati = Integer.parseInt(gestCredito.getNumeroApe());

			Date date = new Date(System.currentTimeMillis());
			
			String anno = DateUtil.convertToString(date).substring(6);

			SiceeWCertificatorePk pk = new SiceeWCertificatorePk(new Integer(
					idCertificatore), anno);

			SiceeWCertificatore certDto = this.getSiceeWCertificatoreDao().findByPrimaryKey(pk);

			if (certDto == null) 
			{
				certDto = new SiceeWCertificatore();
				certDto.setIdCertificatore(new Integer(idCertificatore));
				certDto.setAnno(anno);
				certDto.setProgrCertificato(new Integer(0));
				pk = this.getSiceeWCertificatoreDao().insert(certDto);
			}

			Double importoApe = -gestCredito.getImportoApe().doubleValue();
			
			Double creditoIniziale = gestCredito.getCreditoDisponibile().doubleValue();
			
			Double creditoFinale = null;
			
			for (int i = 0; i < numeroAceAcquistati; i++) {

				creditoFinale = creditoIniziale+importoApe;

				this.insertCertificatoNew(pk, certDto, date, importoApe, creditoIniziale, creditoFinale);
				
				creditoIniziale = creditoFinale;
			}

			//	this.inserisciCertificatiNew(cert, quantita);

		}
		catch (Exception e) {
			log.error("CertificatoMgr :: completaAcquistoACE - ho ricevuto un'eccezione",e);
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	@Transactional
	private void insertCertificatoNew(SiceeWCertificatorePk pk, SiceeWCertificatore prog, Date dataInserimento, Double prezzoApe, Double creditoIniziale, Double creditoFinale) throws BEException 
	{
		try {
		
			prog = this.getSiceeWCertificatoreDao().findByPrimaryKey(pk);
			prog.setProgrCertificato(prog.getProgrCertificato() + 1);

			SiceeTCertificato dto = this.mapToDBNew(prog, dataInserimento);
			this.getSiceeTCertificatoDao().insert(dto);

			this.getSiceeWCertificatoreDao().update(pk, prog);
			
			
			this.getSiceeTCredito2018Dao().insert(this.mapToDBCredito2018(dto, dataInserimento, prezzoApe, creditoIniziale, creditoFinale));
			
		} catch (Exception e) {
			
			log.error("CertificatoMgr :: completaAcquistoACE - ho ricevuto un'eccezione",e);

			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
			
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Insert certificatore progressivo.
	 *
	 * @param cert the cert
	 * @param anno the anno
	 * @throws BEException the bE exception
	 */
	public SiceeWCertificatorePk insertCertificatoreProgressivo(DatiCertificatore cert,
			String anno) throws BEException {
		try {
			SiceeWCertificatore dto = new SiceeWCertificatore();
			dto.setIdCertificatore(new Integer(cert.getIdCertificatore()));
			dto.setAnno(anno);
			dto.setProgrCertificato(new Integer(0));
			return this.getSiceeWCertificatoreDao().insert(dto);
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Gets the stato certificato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the stato certificato
	 * @throws BEException the bE exception
	 */
	public int getStatoCertificato(String numeroCertificato) throws BEException {
		int status = -1;
		try {
			String[] split = numeroCertificato.split(" ");
			split[Constants.PK_ID_CERTIFICATORE] = ""
					+ Integer.parseInt(split[Constants.PK_ID_CERTIFICATORE]
							.substring(1));

			SiceeTCertificato cert = this
					.getSiceeTCertificatoDao()
					.findByPrimaryKey(split[Constants.PK_ID_CERTIFICATORE],
							split[Constants.PK_PROGR], split[Constants.PK_ANNO]);
			status = cert.getFkStato();
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

		return status;
	}

	
	/**
	 * Questo metodo serve solo una volta x riportare a nuovo gli APE in bozza, il max di elemnti da restituire e' preso dal db
	 *
	 */
	/*
	public int testTrattamentoRiportaANuovo() throws BEException {
		try {

			int elaboratiOk = 0;

			List<SiceeTCertificato> certificatiList = getSiceeTCertificatoDao().findRiportareANuovo();

			for (SiceeTCertificato siceeTCertificato : certificatiList) {
				if ((siceeTCertificato.getFkStato().intValue() == Constants.BOZZA)) 
				{
					String esito = "KO";
					// Sicuramente lo stato è in stato BOZZA, ma per sicurezza verifico
					try
					{

						reInitApe(siceeTCertificato.getIdCertificatore(), siceeTCertificato.getProgrCertificato(), siceeTCertificato.getAnno());
						elaboratiOk++;
						esito = "OK";
					} catch (BEException e) {
						log.error("Errore in testTrattamentoRiportaANuovo:" + e, e);
					}
					log.info("##########");
					log.info("########## Riportato a stato NUOVO: "+siceeTCertificato.getAnno() + "-" + siceeTCertificato.getIdCertificatore() + "-"+siceeTCertificato.getProgrCertificato() +" (esito: "+esito+")");
					log.info("##########");
					
				}
			}
			
			return elaboratiOk;
		} catch (Exception e) {
			throw new BEException("Errore in testRecuperaCertificatiBozzaMax:" + e, e);
		}
	}
	*/
	
	/**
	 * Questo metodo serve solo una volta x effettuare i calcoli smile_inverno, smile_estate e rapporto s/v, il max di elemnti da restituire e' preso dal db
	 *
	 */
	public int testTrattamentoEffettuaCalcoli() throws BEException {
		try {

			int elaboratiOk = 0;


			List<SiceeTDatiEner2015> datiEnerList = getSiceeTDatiEner2015Dao().findAllSenzaSmile();

			SiceeTDatiGenerali datiGenerali = null;

			for (SiceeTDatiEner2015 datiEner2015 : datiEnerList) 
			{
				String esito = "KO";
				try
				{
					Integer idSmileInverno = GenericUtil.calcolaSmileInverno(datiEner2015.getEph(), datiEner2015.getEphLimite());
					if (idSmileInverno != null)
					{
						datiEner2015.setFlgSmileInverno(idSmileInverno);
					}

					Integer idSmileEstate = GenericUtil.calcolaSmileEstate(datiEner2015.getAsolAsup(), datiEner2015.getYie());
					if (idSmileEstate != null)
					{
						datiEner2015.setFlgSmileEstate(idSmileEstate);
					}

					datiGenerali = getSiceeTDatiGeneraliDao().findByPrimaryKey(datiEner2015.getIdCertificatore(), datiEner2015.getProgrCertificato(), datiEner2015.getAnno());

					Double rapportoSV = GenericUtil.calcolaRapportoSV(datiGenerali.getSupDisperdente(), datiGenerali.getVolLordoRiscaldato());

					if (rapportoSV != null)
					{
						datiEner2015.setRapportoSv(rapportoSV);
					}

					getSiceeTDatiEner2015Dao().update(datiEner2015.createPk(), datiEner2015);

					elaboratiOk++;
					esito = "OK";
				} catch (Exception e) {
					log.error("Errore in testTrattamentoEffettuaCalcoli:" + e, e);
				}

				log.info("##########");
				log.info("########## Effettuati calcoli: "+datiEner2015.getAnno() + "-" + datiEner2015.getIdCertificatore() + "-"+datiEner2015.getProgrCertificato() +" (esito: "+esito+")");
				log.info("##########");


			}

			return elaboratiOk;
		} catch (Exception e) {
			throw new BEException("Errore in testRecuperaCertificatiBozzaMax:" + e, e);
		}
	}
	
	/**
	 * Questo metodo serve per archiviare gli APE
	 *
	 */
	public void ArchiviaACTA() throws BEException {
		try {

			int elaboratiOk = 0;


			//getSoaIntegrationMgr().testAcaris();

		

		} catch (Exception e) {
			throw new BEException("Errore in ArchiviaACTA:" + e, e);
		}
	}
	
	/** The soa integration mgr. */
	private SOAIntegrationMgr soaIntegrationMgr;

	/**
	 * Gets the soa integration mgr.
	 *
	 * @return the soa integration mgr
	 */
	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return this.soaIntegrationMgr;
	}

	/**
	 * Sets the soa integration mgr.
	 *
	 * @param soaIntegrationMgr the new soa integration mgr
	 */
	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/** The misc mgr. */
	private MiscMgr miscMgr;

	/**
	 * Gets the misc mgr.
	 *
	 * @return the misc mgr
	 */
	public MiscMgr getMiscMgr() {
		return this.miscMgr;
	}

	/**
	 * Sets the misc mgr.
	 *
	 * @param miscMgr the new misc mgr
	 */
	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	public void completaSwTmp(SiceeTDatiXml2015 siceeTDatiXml2015) throws BEException
	{
		DocumentoDocument docXmlApeCompleto2015 = null;
		
		try {
			SiceeTImpdatiXml2015 importXml = getSiceeTImpdatiXml2015Dao().findByPrimaryKey(siceeTDatiXml2015.getIdCertificatore(), siceeTDatiXml2015.getProgrCertificato(), siceeTDatiXml2015.getAnno());
			docXmlApeCompleto2015 = MapDto
					.mapImportToDocumentoDocument(XmlBeanUtils
							.readString(importXml.getFXml()));

			if (docXmlApeCompleto2015 == null) {
				//log.debug("\n\n\n>>>>>>> RITORNA UN NULL !!!");
				Exception e = new Exception();
				throw (e);
			}
			
			
//			Integer gradiGiorno = null;
//			try{gradiGiorno = Converter.convertToInteger(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getGradiGiorno());} catch (Exception e) {BEException bee = new BEException("I gradi giorno sono nulli o non sono in formato corretto", e); throw bee;}
//			siceeTDatiXml2015.setGradiGiorno(gradiGiorno);
//			
			
//			Date dtSopralluogo = null;
//			try{dtSopralluogo = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getDataSopralluogo().getTime();} catch (Exception e) {BEException bee = new BEException("La data sopralluogo e' nulla o non e' in formato corretto", e); throw bee;}
//			siceeTDatiXml2015.setDtSopralluogo(dtSopralluogo);
			
			Integer numCertifSw = null;
			try{numCertifSw = (int) docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getNumeroCertificatoSoftware();} catch (Exception e) {BEException bee = new BEException("Il numero Certificato Software non e' in formato corretto", e); throw bee;}
			siceeTDatiXml2015.setNumCertifSw(numCertifSw);
			
			
			String softwareUtilizzato = null;
			try{softwareUtilizzato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getSoftwareUtilizzato();} catch (Exception e) {BEException bee = new BEException("Il software utilizzato non e' in formato corretto", e); throw bee;}
			siceeTDatiXml2015.setSwUtilizzato(softwareUtilizzato);
			
			getSiceeTDatiXml2015Dao().update(siceeTDatiXml2015.createPk(), siceeTDatiXml2015);
			
			
		} catch (Exception e) {
			
		}
	}
	
	public byte[] recuperaStampaCertificatoReadOnly(String idCertificatore, String progrCertificato, String anno, Integer idStatoCertificato) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		byte[] docXml = null;
		try {
			
				docXml = getSoaIntegrationMgr().recuperaStampaCertificatoReadOnly(idCertificatore, progrCertificato, anno, idStatoCertificato);
				
			
		} catch (Exception e) {
			log.error("Errore in recuperaFoto", e);
			throw new BEException(e.getMessage(), e);
		}
		return docXml;
	}

	
	
	// DA ELIMINARE dopo aver processato la tabella
	/** The sicee t imp dati xml dao. */
	private ZTImpdatiXml2015Dao zTImpdatiXml2015Dao;
	
	/**
	 * Gets the sicee t imp dati xml dao.
	 *
	 * @return the sicee t imp dati xml dao
	 */
	public ZTImpdatiXml2015Dao getZTImpdatiXml2015Dao() {
		return this.zTImpdatiXml2015Dao;
	}

	/**
	 * Sets the sicee t imp dati xml dao.
	 *
	 * @param siceeTImpdatiXml2015Dao the new sicee t imp dati xml dao
	 */
	public void setZTImpdatiXml2015Dao(ZTImpdatiXml2015Dao zTImpdatiXml2015Dao) {
		this.zTImpdatiXml2015Dao = zTImpdatiXml2015Dao;
	}
	
	public void completaZTImpdatiTmp() throws BEException
	{
		DocumentoDocument docXmlApeCompleto2015 = null;
		
		try {
			
			List<ZTImpdatiXml2015> certificatiList = getZTImpdatiXml2015Dao().findAll(); 

			for (ZTImpdatiXml2015 ztImpdatiXml2015 : certificatiList) {
				docXmlApeCompleto2015 = MapDto
						.mapImportToDocumentoDocument(XmlBeanUtils
								.readString(ztImpdatiXml2015.getFXml()));
			
			

				if (docXmlApeCompleto2015 == null) {
					//log.debug("\n\n\n>>>>>>> RITORNA UN NULL !!!");
					Exception e = new Exception();
					throw (e);
				}
				
				
				Integer gradiGiorno = null;
				try{gradiGiorno = Converter.convertToInteger(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getGradiGiorno());} catch (Exception e) {BEException bee = new BEException("I gradi giorno sono nulli o non sono in formato corretto", e); throw bee;}
				ztImpdatiXml2015.setGradiGiorno(gradiGiorno);
				
				
				Date dtSopralluogo = null;
				try{dtSopralluogo = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getDataSopralluogo().getTime();} catch (Exception e) {BEException bee = new BEException("La data sopralluogo e' nulla o non e' in formato corretto", e); throw bee;}
				ztImpdatiXml2015.setDtSopralluogo(dtSopralluogo);
				
				Integer numCertifSw = null;
				try{numCertifSw = (int) docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getNumeroCertificatoSoftware();} catch (Exception e) {BEException bee = new BEException("Il numero Certificato Software non e' in formato corretto", e); throw bee;}
				ztImpdatiXml2015.setNumCertifSw(numCertifSw);
				
				
				String softwareUtilizzato = null;
				try{softwareUtilizzato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getSoftwareUtilizzato();} catch (Exception e) {BEException bee = new BEException("Il software utilizzato non e' in formato corretto", e); throw bee;}
				ztImpdatiXml2015.setSwUtilizzato(softwareUtilizzato);
				
				getZTImpdatiXml2015Dao().update(ztImpdatiXml2015.createPk(), ztImpdatiXml2015);
			}
			
		} catch (Exception e) {
			log.error(e);
		}
	}
	
}
