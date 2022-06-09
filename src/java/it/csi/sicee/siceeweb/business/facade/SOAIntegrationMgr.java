/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.sicee.siceeorch.dto.siceeorch.Certificatore;
import it.csi.sicee.siceeorch.dto.siceeorch.CoordinateLOCCSI;
import it.csi.sicee.siceeorch.dto.siceeorch.DettaglioPagamento;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceeorch.dto.siceeorch.Gateway;
import it.csi.sicee.siceeorch.dto.siceeorch.Impianto;
import it.csi.sicee.siceeorch.dto.siceeorch.InformativaScelta;
import it.csi.sicee.siceeorch.dto.siceeorch.MdpBox;
import it.csi.sicee.siceeorch.dto.siceeorch.MimeTypeInfo;
import it.csi.sicee.siceeorch.dto.siceeorch.Signature;
import it.csi.sicee.siceeorch.dto.siceeorch.Transazione;
import it.csi.sicee.siceeorch.dto.siceeorch.VerifyReport;
import it.csi.sicee.siceeorch.dto.siceeorch.Via;
import it.csi.sicee.siceeorch.exception.siceeorch.DocumentoException;
import it.csi.sicee.siceeorch.exception.siceeorch.LOCCSIException;
import it.csi.sicee.siceeorch.exception.siceeorch.PagamentoException;
import it.csi.sicee.siceeorch.exception.siceeorch.SiceesrvException;
import it.csi.sicee.siceeorch.exception.siceeorch.SigitExcessiveResultsException;
import it.csi.sicee.siceeorch.exception.siceeorch.ToponomasticaException;
import it.csi.sicee.siceeorch.interfacecsi.siceeorch.SiceeorchSrv;
import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiFirmaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFirmaMarcaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRifIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifyReportDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifysignandcertDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiFirma;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFirmaMarca;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReport;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifysignandcert;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifysignandcertPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocumentoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRifIndex2015DaoException;
import it.csi.sicee.siceeweb.business.facade.exceptions.UserException;
import it.csi.sicee.siceeweb.dto.LabelValue;
import it.csi.sicee.siceeweb.dto.ace.Ace;
import it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.geo.Comune;
import it.csi.sicee.siceeweb.dto.geo.Indirizzo;
import it.csi.sicee.siceeweb.dto.geo.Provincia;
import it.csi.sicee.siceeweb.dto.geo.Regione;
import it.csi.sicee.siceeweb.dto.main.CpPagamentoModel;
import it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew;
import it.csi.sicee.siceeweb.dto.pagamenti.GestorePagamento;
import it.csi.sicee.siceeweb.dto.pagamenti.InformativaSceltaNew;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.Converter;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.GenericUtil;
import it.csi.sicee.siceeweb.util.MapDto;
//import it.doqui.acta.acaris.repositoryservice.RepositoryServicePort;
//import it.doqui.acta.actasrv.client.AcarisServiceClient;
//import it.doqui.acta.actasrv.dto.acaris.type.archive.AcarisRepositoryEntryType;
import it.csi.sicee.siceews.stubs.SiceewsMgrLocator;
import it.csi.sicee.siceews.stubs.SiceewsMgrSoapBindingStub;









import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

// TODO: Auto-generated Javadoc
/**
 * Questa classe rappresenta il punto di contatto tra lo strato spring della web
 * application e il servizio di orchestrazione siceeorch.
 *
 * @author 869
 */
public class SOAIntegrationMgr extends BaseMgr {

	/** The srv. */
	protected static SiceeorchSrv srv;

	protected static SiceewsMgrSoapBindingStub srvSiceews;

	private static String wsSiceeUrl = null;

	/** The Constant PD_SORCH_RES. */
	public final static String PD_SORCH_RES = "/META-INF/defpd_siceeorch.xml";

	public void setWSSiceeUrl(String ws) {
		log.debug("Stampo il ws passato: "+ws);
		wsSiceeUrl = ws;
	}

	public static String getWSSiceeUrl() {
		return wsSiceeUrl;
	}
	
	// Questo metodo non serve piu' perche' srvSiceews viene creato quando si istanzia la classe, lo lascio per sicurezza
	private static SiceewsMgrSoapBindingStub getWSSicee()
	{
		if (srvSiceews == null)
		{
			SiceewsMgrLocator loc = new SiceewsMgrLocator();
			//+Constants.WS_SICEEWS_URL
			//				log.debug("SOAIntegrationMgr - PASSO 1: "+Constants.WS_SICEEWS_URL);
			//				loc.setSiceewsMgrWSPortEndpointAddress(Constants.WS_SICEEWS_URL);
			log.debug("SOAIntegrationMgr - PASSO 2");
			try {
				srvSiceews = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();

				log.debug("SOAIntegrationMgr - PASSO 3: "+srvSiceews);

			} catch (Exception e) {
				log.error("ERRORE nell caricamento del WS si SICEEWS:"+e, e); // TODO log4j
			}
			catch (Throwable t)
			{
				log.debug("SOAIntegrationMgr - PASSO 4");

				log.error(t);
				log.debug("SOAIntegrationMgr - PASSO 5");

			}
		}
		return srvSiceews;
	}

	static {

		InputStream is = SOAIntegrationMgr.class
				.getResourceAsStream(PD_SORCH_RES);
		
		
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				srv = (SiceeorchSrv) PDProxy.newInstance(info);
			} catch (Exception e) {
				log.error(
						"ERRORE nell caricamento della PD del servizio di orchestrazione",
						e);
			}
		} else {
			log.error("ERRORE nell caricamento della PD del servizio di orchestrazione:input stream nullo");

		}
		
		SiceewsMgrLocator loc = new SiceewsMgrLocator();
		//+Constants.WS_SICEEWS_URL
		log.debug("SOAIntegrationMgr - PASSO 1: "+Constants.WS_SICEEWS_URL);
		loc.setSiceewsMgrWSPortEndpointAddress(Constants.WS_SICEEWS_URL);
		log.debug("SOAIntegrationMgr - PASSO 2");
		try {
			srvSiceews = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();
			
			log.debug("SOAIntegrationMgr - PASSO 3");

		} catch (Exception e) {
			log.error("ERRORE nell caricamento del WS si SICEEWS:"+e, e); // TODO log4j
		}
		catch (Throwable t)
		{
			log.debug("SOAIntegrationMgr - PASSO 4");
			
			log.error(t);
			log.debug("SOAIntegrationMgr - PASSO 5");

		}

	}

	// ACARIS
//	private AcarisServiceClient serviceAcaris;
//
//	public AcarisServiceClient getServiceAcaris() {
//		return serviceAcaris;
//	}
//
//	public void setServiceAcaris(AcarisServiceClient serviceAcaris) {
//		this.serviceAcaris = serviceAcaris;
//	}

	/** The sicee t documento dao. */
	private SiceeTDocumentoDao siceeTDocumentoDao;

	/**
	 * Gets the sicee t documento dao.
	 *
	 * @return the sicee t documento dao
	 */
	public SiceeTDocumentoDao getSiceeTDocumentoDao() {
		return this.siceeTDocumentoDao;
	}

	/**
	 * Sets the sicee t documento dao.
	 *
	 * @param siceeTDocumentoDao the new sicee t documento dao
	 */
	public void setSiceeTDocumentoDao(SiceeTDocumentoDao siceeTDocumentoDao) {
		this.siceeTDocumentoDao = siceeTDocumentoDao;
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

	/** The sicee t verifysignandcert dao. */
	private SiceeTVerifysignandcertDao siceeTVerifysignandcertDao;

	/**
	 * Gets the sicee t verifysignandcert dao.
	 *
	 * @return the sicee t verifysignandcert dao
	 */
	public SiceeTVerifysignandcertDao getSiceeTVerifysignandcertDao() {
		return this.siceeTVerifysignandcertDao;
	}

	/**
	 * Sets the sicee t verifysignandcert dao.
	 *
	 * @param siceeTVerifysignandcertDao the new sicee t verifysignandcert dao
	 */
	public void setSiceeTVerifysignandcertDao(
			SiceeTVerifysignandcertDao siceeTVerifysignandcertDao) {
		this.siceeTVerifysignandcertDao = siceeTVerifysignandcertDao;
	}

	/** The sicee t firma marca dao. */
	private SiceeTFirmaMarcaDao siceeTFirmaMarcaDao;

	/**
	 * Gets the sicee t firma marca dao.
	 *
	 * @return the sicee t firma marca dao
	 */
	public SiceeTFirmaMarcaDao getSiceeTFirmaMarcaDao() {
		return this.siceeTFirmaMarcaDao;
	}

	/**
	 * Sets the sicee t firma marca dao.
	 *
	 * @param siceeTFirmaMarcaDao the new sicee t firma marca dao
	 */
	public void setSiceeTFirmaMarcaDao(SiceeTFirmaMarcaDao siceeTFirmaMarcaDao) {
		this.siceeTFirmaMarcaDao = siceeTFirmaMarcaDao;
	}

	/** The sicee t parametri dao. */
	private SiceeTParametriDao siceeTParametriDao;

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
	
	/** The sicee t rif index 2015 dao. */
	private SiceeTRifIndex2015Dao siceeTRifIndex2015Dao;

	/**
	 * Gets the sicee t rif index 2015 dao.
	 *
	 * @return the sicee t rif index 2015 dao
	 */
	public SiceeTRifIndex2015Dao getSiceeTRifIndex2015Dao() {
		return this.siceeTRifIndex2015Dao;
	}

	/**
	 * Sets the siceet t rif index 2015 dao.
	 *
	 * @param siceeTRifIndex2015Dao the new sicee t rif index 2015 dao
	 */
	public void setSiceeTRifIndex2015Dao(SiceeTRifIndex2015Dao siceeTRifIndex2015Dao) {
		this.siceeTRifIndex2015Dao = siceeTRifIndex2015Dao;
	}

	/** The sicee t certificatore dao. */
	private SiceeTCertificatoreDao siceeTCertificatoreDao;

	/**
	 * Gets the sicee t certificatore dao.
	 *
	 * @return the sicee t certificatore dao
	 */
	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return this.siceeTCertificatoreDao;
	}

	/**
	 * Sets the siceet t certificatore dao.
	 *
	 * @param siceeTCertificatoreDao the new sicee t certificatore dao
	 */
	public void setSiceeTCertificatoreDao(SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
	}

	/** The sicee t certificatore dao. */
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
	 * Sets the siceet t certificato dao.
	 *
	 * @param siceeTCertificatoDao the new sicee t certificato dao
	 */
	public void setSiceeTCertificatoDao(SiceeTCertificatoDao siceeTCertificatoDao) {
		this.siceeTCertificatoDao = siceeTCertificatoDao;
	}
	
	/*
	public void eliminaImmagine(String uid)
			throws BEException {

		eliminaDaIndex(uid);
	}
	
	
	public void eliminaDocumento(String uid)
			throws BEException {

		eliminaDaIndex(uid);
	}
	 */
	
	public void eliminaFileDaIndex(String uid)
			throws BEException {

		Documento docOrch = new Documento();
		try {
			docOrch.setUid(uid);
			srv.cancellaDocumento(docOrch);
		} catch (DocumentoException e) {
			log.warn("Warning cancellazione documento", e);
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			log.warn("Warning cancellazione documento", e);
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.warn("Warning cancellazione documento", e);
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			log.warn("Warning cancellazione documento", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Salva immagine.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param buf the buf
	 * @param nomeFoto the nome foto
	 * @param contentType the content type
	 * @param length the length
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String salvaImmagine(String id, String prog, String anno, DatiAttestato att,
			byte[] buf, String nomeFoto, String contentType, long length)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {
			doc = new Documento();
			doc.setAttestato(att.getNumeroAttestato());
			doc.setDoc(buf);
			doc.setNome(nomeFoto);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
			
			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali()
					.getDescrComune());
			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			doc.setTipologia(Constants.TIPOLOGIA_ALLEGATO_IMG);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(id);
			doc.setProgrCertificato(prog);
			doc.setDataUpload(new Date(System.currentTimeMillis()));
			
			uid = srv.inserisciDocumento(doc);

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		}

		return uid;

	}

	public String salvaImmagine(DatiCertificatore cert, DatiAttestato att,
			byte[] buf, String nomeFoto, String contentType, long length)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {
			String[] split = BaseMgr.recuperaChiaveAttestato(
					cert.getIdCertificatore(), att.getNumeroAttestato());

			String id = split[Constants.PK_ID_CERTIFICATORE];
			String prog = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			doc = new Documento();
			doc.setAttestato(att.getNumeroAttestato());
			doc.setDoc(buf);
			doc.setNome(nomeFoto);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
			
//			doc.setClasseEnergetica(att.getClasseEnerg().getLocTeorica()
//					.getDescClasseEnerg());
			
			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali()
					.getDescrComune());
			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			doc.setTipologia(Constants.TIPOLOGIA_ALLEGATO_IMG);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(id);
			doc.setProgrCertificato(prog);
			doc.setDataUpload(new Date(System.currentTimeMillis()));

			log.debug("### PRIMA DI INSERIRE LA FOTO");
			uid = srv.inserisciDocumento(doc);
			log.debug("### DOPO DI INSERIRE LA FOTO");

			if (BaseMgr.isNullOrEmpty(uid)) {
				throw new DocumentoException("Attestato Immagine: " + uid
						+ " UID null!!!");
			} else if (!BaseMgr.isNullOrEmpty(att.getDatiAnagraficiImm()
					.getDtCatastali().getUidFoto())
					&& !att.getDatiAnagraficiImm().getDtCatastali()
							.getUidFoto().equals(uid)) {
				Documento docOrch = new Documento();
				docOrch.setUid(att.getDatiAnagraficiImm().getDtCatastali()
						.getUidFoto());
				try {
					srv.cancellaDocumento(docOrch);
				} catch (DocumentoException e) {
					log.warn("Warning cancellazione documento", e);
				} catch (SystemException e) {
					log.warn("Warning cancellazione documento", e);
				} catch (UnrecoverableException e) {
					log.warn("Warning cancellazione documento", e);
				} catch (CSIException e) {
					log.warn("Warning cancellazione documento", e);
				}
			}
		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		}

		return uid;

	}

	public String salvaImmagineSecondaria(DatiCertificatore cert, DatiAttestato att,
			byte[] buf, String nomeFoto, String contentType, long length)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {
			String[] split = BaseMgr.recuperaChiaveAttestato(
					cert.getIdCertificatore(), att.getNumeroAttestato());

			String id = split[Constants.PK_ID_CERTIFICATORE];
			String prog = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			doc = new Documento();
			doc.setAttestato(att.getNumeroAttestato());
			doc.setDoc(buf);
			doc.setNome(nomeFoto);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
			
//			doc.setClasseEnergetica(att.getClasseEnerg().getLocTeorica()
//					.getDescClasseEnerg());
			
			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali()
					.getDescrComune());
			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			doc.setTipologia(Constants.TIPOLOGIA_ALLEGATO_IMG);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(id);
			doc.setProgrCertificato(prog);
			doc.setDataUpload(new Date(System.currentTimeMillis()));

			
			uid = srv.inserisciDocumento(doc);
/*
			if (BaseMgr.isNullOrEmpty(uid)) {
				throw new DocumentoException("Attestato Immagine: " + uid
						+ " UID null!!!");
			} else if (!BaseMgr.isNullOrEmpty(att.getDatiAnagraficiImm()
					.getDtCatastali().getUidFoto())
					&& !att.getDatiAnagraficiImm().getDtCatastali()
							.getUidFoto().equals(uid)) {
				Documento docOrch = new Documento();
				docOrch.setUid(att.getDatiAnagraficiImm().getDtCatastali()
						.getUidFoto());
				try {
					srv.cancellaDocumento(docOrch);
				} catch (DocumentoException e) {
					log.warn("Warning cancellazione documento", e);
				} catch (SystemException e) {
					log.warn("Warning cancellazione documento", e);
				} catch (UnrecoverableException e) {
					log.warn("Warning cancellazione documento", e);
				} catch (CSIException e) {
					log.warn("Warning cancellazione documento", e);
				}
			}
*/
		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		}

		return uid;

	}

	public String salvaFileXML(String id, String prog, String anno, DatiAttestato att,
			byte[] buf, String nomeFoto, String contentType, long length)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {
			doc = new Documento();
			doc.setAttestato(att.getNumeroAttestato());
			doc.setDoc(buf);
			doc.setNome(nomeFoto);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
			
			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali().getDescrComune());
			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			doc.setTipologia(Constants.TIPOLOGIA_ALLEGATO_XML);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(id);
			doc.setProgrCertificato(prog);
			doc.setDataUpload(new Date(System.currentTimeMillis()));
	
			uid = srv.inserisciDocumento(doc);

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		}

		return uid;

	}

	/**
	 * Gets the stato transazione.
	 *
	 * @param numeroTransazione the numero transazione
	 * @return the stato transazione
	 * @throws BEException the bE exception
	 */
	public it.csi.sicee.siceeweb.dto.pagamenti.Transazione getStatoTransazione(
			String numeroTransazione) throws BEException {

		try {

			Transazione box = srv.getMdpTransactionState(numeroTransazione);

			return Converter.convertTo(box);
		} catch (PagamentoException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		}

	}

	/**
	 * Gets the modalita pagamento.
	 *
	 * @param theModel the the model
	 * @return the modalita pagamento
	 * @throws BEException the bE exception
	 */
	public void getModalitaPagamento(CpPagamentoModel theModel)
			throws BEException {
		ArrayList<GestorePagamento> array = new ArrayList<GestorePagamento>();
		try {

			MdpBox box = srv.getMdpPaymentMode(Constants.MDP_ID_APP);
			Gateway[] gateways = box.getGateways();
			if (gateways != null) {
				for (int i = 0; i < gateways.length; i++) {
					String cod = gateways[i].getGatewayId()
							+ Constants.DIVIDE_IDS
							+ gateways[i].getPaymentmodeId();
					String nome = gateways[i].getGatewayDescription()
							+ Constants.DIVIDE_IDS
							+ gateways[i].getPaymentmodeDescription();
					GestorePagamento gest = new GestorePagamento();
					gest.setCod(cod);
					gest.setNome(nome);
					array.add(gest);
				}
			}

			theModel.setAppDatatransazione(Converter.convertTo(box
					.getTransazione()));
			theModel.setAppDatagestoriPagamento(array);
		} catch (PagamentoException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		}

	}

	/**
	 * Acquista articolo.
	 *
	 * @param value the value
	 * @param causale the causale
	 * @param dataValuta the data valuta
	 * @param cert the cert
	 * @param model the model
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String acquistaArticolo(Double value, String causale,
			String dataValuta, DatiCertificatore cert, CpPagamentoModel model)
			throws BEException {
		String url = null;
		try {

			Transazione trn = Converter
					.convertTo(model.getAppDatatransazione());
			
			
			// Prova da eliminare - inizio - è stata inserita per baypassare in TST il problema di Unicredit che non permetteva l'insrimento dell'indirizzo mail pur essendo obbligatorio
			//trn.setBuyerEmail("cip@ciop.it");
			// Prova da eliminare - fine
			
			trn.setAmount(value);
			trn.setCcy("EUR");
			String[] ids = model.getAppDataidGestorePagamento().split(
					Constants.DIVIDE_IDS);
			trn.setGatewayId(ids[0]);
			trn.setGatewaypaymodeid(ids[1]);
			url = srv.startMdpTransaction(trn);

			// TODO
			/*
			 * Articolo articolo = new Articolo(); articolo.setId(1);
			 * articolo.setDescrizione(causale); articolo.setPrezzo(value);
			 * articolo.setPrezzoTotale(value); articolo.setQuantita(1);
			 * articolo.setDataCreazione(convertToDate(dataValuta));
			 * 
			 * Buyer buyer = new Buyer();
			 * 
			 * buyer.setNome(cert.getDtAnag().getCognome() + " " +
			 * cert.getDtAnag().getNome());
			 * buyer.setCodiceFiscale(cert.getDtAnag().getCodFisc());
			 * 
			 * transazione = srv.acquistaOggetto(articolo, buyer,
			 * Constants.MDP_ID_APP);
			 */} catch (PagamentoException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		}

		return url;
	}

	/*
	 * private java.util.Date convertToDate(String s) throws BEException{ if(s
	 * != null && s.length()>0){ SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd/MM/yyyy"); try { return sdf.parse(s); } catch
	 * (ParseException e) { throw new
	 * BEException("Errore nella parsificazioen della data "+s, e); } } else
	 * return null; }
	 */

	/**
	 * restituisce l'elenco di tutte le regioni italiane.
	 *
	 * @return the all regioni
	 * @throws BEException the bE exception
	 */

	public List<Regione> getAllRegioni() throws BEException {
		ArrayList<Regione> ris = new ArrayList<Regione>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Regione[] regioni = srv
					.elencoRegioni();
			if (regioni != null) {
				for (it.csi.sicee.siceeorch.dto.siceeorch.Regione currReg : regioni) {
					Regione currRis = new Regione();
					currRis.setCod(currReg.getCod());
					currRis.setNome(currReg.getNome());
					ris.add(currRis);
				}
			}
			return ris;
		} catch (ToponomasticaException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		}
	}

	/**
	 * Gets the province by regione.
	 *
	 * @param codRegione the cod regione
	 * @return the province by regione
	 * @throws BEException the bE exception
	 */
	public List<Provincia> getProvinceByRegione(String codRegione)
			throws BEException {
		ArrayList<Provincia> ris = new ArrayList<Provincia>();
		if (codRegione != null && codRegione.length() > 0) {
			try {
				it.csi.sicee.siceeorch.dto.siceeorch.Provincia[] province = srv
						.elencoProvince(codRegione);
				if (province != null) {
					for (it.csi.sicee.siceeorch.dto.siceeorch.Provincia currProv : province) {
						Provincia currRis = new Provincia();
						currRis.setCod(currProv.getCod());
						currRis.setNome(currProv.getNome());
						ris.add(currRis);
					}
				}
				return ris;
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getProvince della regione:"
						+ e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getProvince della regione:"
						+ e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getProvince della regione:"
						+ e, e);
			} catch (CSIException e) {
				throw new BEException("Errore in getProvince della regione:"
						+ e, e);
			}
		} else {
			return ris;
		}
	}

	/**
	 * Gets the province by piemonte.
	 *
	 * @return the province by piemonte
	 * @throws BEException the bE exception
	 */
	public List<Provincia> getProvinceByPiemonte() throws BEException {
		List<Provincia> ris = new ArrayList<Provincia>();
		try {
			ris = this.getProvinceByRegione(Constants.COD_REGIONE_PIEMONTE);
		} catch (BEException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		}

		return ris;
	}

	/**
	 * Gets the comuni by provincia.
	 *
	 * @param codProvincia the cod provincia
	 * @return the comuni by provincia
	 * @throws BEException the bE exception
	 */
	public List<Comune> getComuniByProvincia(String codProvincia)
			throws BEException {
		ArrayList<Comune> ris = new ArrayList<Comune>();
		log.debug("getComuniByProvincia:codProvincia: "+codProvincia);
		if (codProvincia != null && codProvincia.length() > 0) {
			try {
				log.debug("getComuniByProvincia: prima del servizio");

				it.csi.sicee.siceeorch.dto.siceeorch.Comune[] comuni = srv
						.elencoComuni(codProvincia);
				log.debug("getComuniByProvincia: dopo il servizio");
				// throw new CSIException("ERRORE FORZATO");
				// SCOMMENTARE DOPO AVER TOLTO ERRORE
				if (comuni != null) {
					
					if (log.isDebugEnabled())
						log.debug("getComuniByProvincia: comuni: "+comuni);

					for (it.csi.sicee.siceeorch.dto.siceeorch.Comune currCom : comuni) {
						Comune currRis = new Comune();
						currRis.setCod(currCom.getCod());
						currRis.setNome(currCom.getNome());
						currRis.setCodCatasto(currCom.getCodCatasto());
						
//						log.debug("currRis.getNome(): "+currRis.getNome());
//						log.debug("currRis.getCodCatasto(): "+currRis.getCodCatasto());
						
						ris.add(currRis);
					}
				}
				return ris;
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getComuni della provincia:"
						+ e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getComuni della provincia:"
						+ e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getComuni della provincia:"
						+ e, e);
			} catch (CSIException e) {
				throw new BEException("Errore in getComuni della provincia:"
						+ e, e);
			}
		} else {
			return ris;
		}
	}

	public Comune getDescrizioneComune(String codComune)
			throws BEException {
		Comune ris = new Comune();
		log.debug("getDescrizioneComune: codComune: "+codComune);
		if (codComune != null && codComune.length() > 0) {
			try {
				log.debug("getDescrizioneComune: prima del servizio");

				it.csi.sicee.siceeorch.dto.siceeorch.Comune comune = srv.getDescrizioneComune(codComune);
				log.debug("getDescrizioneComune: dopo il servizio");
				if (comune != null) {
					log.debug("getDescrizioneComune: comune: "+ comune);
					ris.setCod(comune.getCod());
					ris.setNome(comune.getNome());
					ris.setCodCatasto(comune.getCodCatasto());
					ris.setCodProv(comune.getCodProv());
					ris.setNomeProv(comune.getNomeProv());
				}
				return ris;
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getDescrizioneComune:"
						+ e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getDescrizioneComune:"
						+ e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getDescrizioneComune:"
						+ e, e);
			} catch (CSIException e) {
				throw new BEException("getDescrizioneComune:"
						+ e, e);
			}
		} else {
			return ris;
		}
	}

	public Provincia getDescrizioneProvincia(String codProvincia)
			throws BEException {
		Provincia ris = new Provincia();
		log.debug("getDescrizioneProvincia: codComune: "+codProvincia);
		if (codProvincia != null && codProvincia.length() > 0) {
			try {
				log.debug("getDescrizioneProvincia: prima del servizio");

				it.csi.sicee.siceeorch.dto.siceeorch.Provincia provincia = srv.getDescrizioneProvincia(codProvincia);
				log.debug("getDescrizioneComune: dopo il servizio");
				if (provincia != null) {
					log.debug("getDescrizioneProvincia: comune: "+ provincia);
					ris.setCod(provincia.getCod());
					ris.setNome(provincia.getNome());
				}
				return ris;
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getDescrizioneProvincia:"
						+ e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getDescrizioneProvincia:"
						+ e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getDescrizioneProvincia:"
						+ e, e);
			} catch (CSIException e) {
				throw new BEException("getDescrizioneProvincia:"
						+ e, e);
			}
		} else {
			return ris;
		}
	}
	/**
	 * Verifica indirizzi.
	 *
	 * @param descrIndirizzo the descr indirizzo
	 * @param codIstatComune the cod istat comune
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Indirizzo> verificaIndirizzi(String descrIndirizzo,
			String codIstatComune) throws BEException {
		if (descrIndirizzo == null || descrIndirizzo.length() == 0
				|| codIstatComune == null) {
			return new ArrayList<Indirizzo>();
		} else {
			descrIndirizzo = descrIndirizzo.trim();
			Via[] vie;
			ArrayList<Indirizzo> indirizzi = new ArrayList<Indirizzo>();
			try {
				vie = srv.getVieByCodiceIstat(descrIndirizzo, codIstatComune);
			} catch (ToponomasticaException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			} catch (SystemException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			} catch (CSIException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			}
			if (vie != null) {
				for (Via via : vie) {
					Indirizzo curr = new Indirizzo();
					curr.setCod(via.getId());
					curr.setDescr(via.getDenominazione());
					indirizzi.add(curr);

					if (log.isDebugEnabled())
						log.debug("STAMPO l'INDIRIZZO: "+curr);
				}
			}
			
			if (log.isDebugEnabled())
				log.debug("STAMPO GLI INDIRIZZI: "+indirizzi);
			
			return indirizzi;
		}

	}

	/**
	 * Gets the indirizzo by id.
	 *
	 * @param id the id
	 * @return the indirizzo by id
	 * @throws BEException the bE exception
	 */
	public Indirizzo getIndirizzoById(Integer id) throws BEException {
		if (id == null) {
			return null;
		} else {
			try {
				Via via = srv.getViaById(id);
				if (via != null) {
					Indirizzo ris = new Indirizzo();
					ris.setCod(id);
					ris.setDescr(via.getDenominazione());
					return ris;
				} else {
					return null;
				}
			} catch (ToponomasticaException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			} catch (SystemException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			} catch (CSIException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			}
		}
	}

	/**
	 * Recupera immagine.
	 *
	 * @param att the att
	 * @return the input stream
	 */
	public InputStream recuperaImmagine(DatiAttestato att) {
		ByteArrayInputStream bis = null;
		Documento doc = new Documento();
		doc.setUid(att.getDatiAnagraficiImm().getDtCatastali().getUidFoto());
		try {
			Documento docu = srv.ricercaDocumento(doc);
			if (docu != null) {
				bis = new ByteArrayInputStream(docu.getDoc());
			}

		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		}
		return bis;
	}

	/**
	 * Recupera documento.
	 *
	 * @param uid the uid
	 * @return the documento
	 */
	public Documento recuperaDocumento(String uid) {
		Documento doc = new Documento();
		doc.setUid(uid);
		try {
			doc = srv.ricercaDocumento(doc);
			
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		
		return doc;
	}

	/**
	 * Salva verifica attestato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param bytes the bytes
	 * @param nomeAttestato the nome attestato
	 * @param contentType the content type
	 * @param length the length
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	@Transactional
	public List<String> salvaVerificaAttestato(DatiCertificatore cert,
			DatiAttestato att, byte[] bytes, String nomeAttestato,
			String contentType, long length) throws BEException {
		Documento doc = new Documento();
		ArrayList<String> result = null;
		try {
			String[] split = BaseMgr.recuperaChiaveAttestato(
					cert.getIdCertificatore(), att.getNumeroAttestato());

			String id = split[Constants.PK_ID_CERTIFICATORE];
			String prog = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			String uid = "";
			String uidTarghetta = "";
			doc = new Documento();
			doc.setAttestato(att.getNumeroAttestato());
			doc.setDoc(bytes);

			
			if (log.isDebugEnabled())
				log.debug("STAMPO bytes.length: "+ bytes.length);
			
			doc.setNome(nomeAttestato);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
			//			doc.setClasseEnergetica(att.getClasseEnerg().getLocTeorica()
			//					.getDescClasseEnerg());
			//			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali()
			//					.getDescrComune());
			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			doc.setTipologia(Constants.TIPOLOGIA_ALLEGATO_ACE_NEW);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(id);
			doc.setProgrCertificato(prog);
			doc.setDataUpload(new Date(System.currentTimeMillis()));

			String dosignVer = srv.getParametro("DOSIGN_VERSIONE_SERVIZIO");

			if (log.isDebugEnabled())
				log.debug("STAMPO dosignVer: "+dosignVer);

			boolean newDosign = dosignVer.equals("1") ? false : true;

			// DA MODIFICARE A TRUE per baypassare il controllo
			boolean isCertFirmatario = false;
			boolean isCoCertFirmatario = false;

			String cfCert = cert.getDtAnag().getCodFisc();
			// Per gestire controllo firma cocertificatore
			String cfCocert = null;
			
			if (att.getDatiAnagraficiImm() != null && att.getDatiAnagraficiImm().getDtCoCertificatore() != null && !GenericUtil.isNullOrEmpty(att.getDatiAnagraficiImm().getDtCoCertificatore().getCodFisc()))
			{
				cfCocert = att.getDatiAnagraficiImm().getDtCoCertificatore().getCodFisc();
			}
			else
			{
				// Se non c'è il cocertificatore devo baypassare la verifica
				isCoCertFirmatario = true;
			}
			
			log.debug("Stampo il CF del certificatore: "+cfCert);
			
			log.debug("STAMPO newDosign: "+newDosign);

			try
			{
				VerifyReport vr = newDosign ? srv.verificaDocumentoNewDosign(doc)
						: srv.verificaDocumento(doc);

				ArrayList<Integer> errorCodes = new ArrayList<Integer>();

				if (vr != null) {
					
					// Sposto questo codice sotto, in modo che se l'insert sul db da errore non viene fatto l'insert su index
					/*
					if (vr.getEsito()) {
						log.debug("Inserisco documento APE su index: " + vr.getEsito());
						uid = srv.inserisciDocumento(doc);
						if (BaseMgr.isNullOrEmpty(uid)) {
							throw new DocumentoException("Attestato: "
									+ att.getNumeroAttestato() + " UID null!!!");
						}

						log.debug("UID: " + uid);

					}
					*/
					
					Long progrVerifyReport = this.getSiceeTVerifyReportDao()
							.getNextValue();

					if (!newDosign) {
						SiceeTVerifyReport dto = new SiceeTVerifyReport();
						dto.setAnno(anno);
						dto.setFormatoFirma(vr.getFormatoFirma());
						dto.setIdCertificatore(id);
						dto.setNumCertificatiFirma(vr.getNumeroCertificatiFirma());
						dto.setNumMarche(vr.getNumeroMarche());
						dto.setParametriInput(vr.getConformitaParametriInput());
						dto.setProgrCertificato(prog);
						dto.setProgrVerifyReport(progrVerifyReport.intValue());
						dto.setTipoFirma(vr.getTipoFirma());

						this.getSiceeTVerifyReportDao().insert(dto);

						for (int i = 0; i < vr.getErrorCode().length; i++) {
							errorCodes.add(vr.getErrorCode()[i]);
						}
						if (vr.getSignatures() != null && errorCodes.isEmpty()) {
							Signature[] si = vr.getSignatures();
							String cfFirma = null;
							if (si.length > 0) {

								for (int i = 0; i < si.length; i++) {
									SiceeTDatiFirma dt = new SiceeTDatiFirma();
									dt.setAnno(anno);
									dt.setCa(si[i].getCa());
									
									// Modifica per risolvere l'eventuale problema del prefisso ISOCode nel codice fiscale (sicee-484)
									
									if (log.isDebugEnabled())
									{
										log.debug("STAMPO I CF DELLA FIRMA");
										log.debug("Firma n. "+i+": "+si[i].getCodiceFiscale());
									}
									
									cfFirma = GenericUtil.normalizzaCFFirma(si[i].getCodiceFiscale());
									
									dt.setCodiceFiscale(cfFirma);
									
									if (dt.getCodiceFiscale().equalsIgnoreCase(cfCert))
									{
										isCertFirmatario = true;
									}
									
									if (cfCocert != null && dt.getCodiceFiscale().equalsIgnoreCase(cfCocert))
									{
										isCoCertFirmatario = true;
									}
									
									dt.setDtFineValCert(DateUtil
											.convertToTimestamp(si[i]
													.getDataFineValidita()));
									dt.setDtFirma(DateUtil.convertToTimestamp(si[i]
											.getDataOra()));
									dt.setDtInizioValCert(DateUtil
											.convertToTimestamp(si[i]
													.getDataInizioValidita()));
									dt.setDtVerifica(DateUtil
											.convertToTimestamp(si[i]
													.getDataOraVerifica()));
									dt.setErrorCode(si[i].getCodiceErrore());

									errorCodes.add(si[i].getCodiceErrore());
									if (si[i].getCodiceErrore() == 0) {
										dt.setFkStatoFile(Constants.VERIFICA_OK);
									} else if (si[i].getCodiceErrore() == 6) {
										dt.setFkStatoFile(Constants.VERIFICA_NON_COMPLETA);
									} else {
										dt.setFkStatoFile(Constants.VERIFICA_KO);
									}

									dt.setGivenName(si[i].getNome());
									dt.setIdCertificatore(cert.getIdCertificatore());
									dt.setProgrCertificato(prog);
									dt.setProgrVerifyReport(progrVerifyReport
											.intValue());
									dt.setSerialNumber(si[i].getNumeroSerie());
									dt.setSurname(si[i].getCognome());
									this.getSiceeTDatiFirmaDao().insert(dt);
								}
								
							}
						}
						
						if (!isCertFirmatario)
						{
							throw new BEException(Constants.ERROR_CODE_FIRMA_CERT, null);
						}
						
						if (!isCoCertFirmatario)
						{
							throw new BEException(Constants.ERROR_CODE_FIRMA_COCERT, null);
						}
						
						
					} else {
						SiceeTVerifysignandcert dto = new SiceeTVerifysignandcert();
						dto.setAnno(anno);
						dto.setIdCertificatore(id);
						dto.setProgrCertificato(prog);
						dto.setErrorCode(vr.getErrorCodeComplessivo());
						dto.setTotNumSignature(vr.getNumeroCertificatiFirma());
						dto.setTotNumTimestamp(vr.getNumeroMarche());
						dto.setVerificationDate(vr.getDataVerifica());
						dto.setDeliberationCompliant(vr.getDeliberationCompliant() ? "TRUE"
								: "FALSE"); // verificare valore
						dto.setSignatureType(vr.getTipoFirma());
						dto.setSignatureFormat(vr.getFormatoFirma());
						if (vr.getTipoFile() != null) {
							dto.setFileType(Integer.parseInt(vr.getTipoFile()));
						}

						SiceeTVerifysignandcertPk dtoPk = this
								.getSiceeTVerifysignandcertDao().insert(dto);

						if (vr.getErrorCode() != null) {
							for (int i = 0; i < vr.getErrorCode().length; i++) {
								errorCodes.add(vr.getErrorCode()[i]);
							}
						}

						if (vr.getSignatures() != null) {
							for (Signature s : vr.getSignatures()) {
								SiceeTFirmaMarca fm = new SiceeTFirmaMarca();
								fm.setAnno(anno);
								fm.setIdCertificatore(id);
								fm.setProgrCertificato(prog);
								fm.setProgrSignandcert(dtoPk.getProgrSignandcert());
								fm.setCertificateType(s.getTipoCertificato());
								fm.setCompliance(s.getCompliance());
								fm.setDateTimeSignature(s.getDataOra());
								fm.setDigestAlgorithm(s.getAlgoritmo());
								fm.setErrorCodeFirma(s.getCodiceErrore());
								fm.setGivenName(s.getNome());
								fm.setSurname(s.getCognome());
								fm.setTaxCode(s.getCodiceFiscale());

								fm.setRevocationDate(s.getDataRevoca());
								fm.setCertificationAuthority(s
										.getAutoritaCertificato());
								fm.setErrorCodeCertificato(s
										.getCodiceErroreCertificato());
								fm.setSerialNumber(s.getNumeroSerie());
								fm.setValidFrom(s.getDataInizioValidita());
								fm.setValidTo(s.getDataFineValidita());

								this.getSiceeTFirmaMarcaDao().insert(fm);
							}
						}
					}
					
					// Ho spostato questo controllo, in modo che se l'insert sul db da errore non viene fatto l'insert su index
					if (vr.getEsito()) {
						log.debug("Inserisco documento APE su index: " + vr.getEsito());
						uid = srv.inserisciDocumento(doc);
						if (BaseMgr.isNullOrEmpty(uid)) {
							throw new DocumentoException("Attestato: "
									+ att.getNumeroAttestato() + " UID null!!!");
						}

						log.debug("UID: " + uid);

					}
				}

				log.debug("CODICI DI ERRORE: " + errorCodes);

				result = this.convertErrorCodeToString(errorCodes);

				result.add(0, uid);

				log.debug("CODICI FINALI: " + result);

				return result;

				/*
				 * Documento img = new Documento();
				 * img.setNome(att.getDatiAnagraficiImm
				 * ().getDtCatastali().getNomeFoto());
				 * img.setUid(att.getDatiAnagraficiImm
				 * ().getDtCatastali().getUidFoto()); srv.cancellaDocumento(img);
				 */

			} catch (DocumentoException e) {
				log.error("Errore", e);
				throw new BEException(e.getMessage(), e);
			} catch (SystemException e) {
				log.error("Errore", e);
				throw new BEException(e.getMessage(), e);
			} catch (UnrecoverableException e) {
				log.error("Errore", e);
				throw new BEException(Constants.ERROR_CODE_INDEX, e);
			} catch (CSIException e) {
				log.error("Errore", e);

				throw new BEException(e.getMessage(), e);
			} catch (UndeclaredThrowableException e) {
				log.error("Errore", e);
				throw new BEException(e.getMessage(), e);
			}
		}
		catch (BEException e) {
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
			throw e;
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
			log.error("Errore", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@@SETTEMBRE 2015 INIZIO
	/**
	 * Estrai Docuemnto.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param bytes the bytes
	 * @param nomeAttestato the nome attestato
	 * @param contentType the content type
	 * @param length the length
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public Documento estraiDocumento(DatiCertificatore cert,
			DatiAttestato att, byte[] bytes, String nomeAttestato,
			String contentType, long length) throws BEException {
		Documento doc = new Documento();
		
		Documento result = null;
		
		try {
			String[] split = BaseMgr.recuperaChiaveAttestato(
					cert.getIdCertificatore(), att.getNumeroAttestato());

			String id = split[Constants.PK_ID_CERTIFICATORE];
			String prog = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];

			doc = new Documento();
			doc.setAttestato(att.getNumeroAttestato());
			doc.setDoc(bytes);
			doc.setNome(nomeAttestato);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
//			doc.setClasseEnergetica(att.getClasseEnerg().getLocTeorica()
//					.getDescClasseEnerg());
//			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali()
//					.getDescrComune());
			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			doc.setTipologia(Constants.TIPOLOGIA_ALLEGATO_ACE_NEW);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(id);
			doc.setProgrCertificato(prog);
			doc.setDataUpload(new Date(System.currentTimeMillis()));
			
			log.debug("SOAIntegrationMgr::estraiDocumento Istanzio parametro da passare al servizio");
			String dosignVer = srv.getParametro("DOSIGN_VERSIONE_SERVIZIO");
			log.debug("SOAIntegrationMgr::estraiDocumento Parametro OK");
			log.debug("SOAIntegrationMgr::estraiDocumento Richiamo servizio");
			Documento vr=srv.estraiDocumento(doc);
			
			if (vr != null) {
				result=vr;
			}

			return result;

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(Constants.ERROR_CODE_INDEX, e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UndeclaredThrowableException e) {
			e.printStackTrace();
			throw new BEException(e.getMessage(), e);
		}

	}
	//@@SETTEMBRE 2015 FINE
	
	
	
	
	
	
	
	/**
	 * Gets the stampa dettaglio.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the stampa dettaglio
	 */
	public ArrayList<LabelValue> getDettaglioAce(String numeroCertificato) {
		ArrayList<LabelValue> ret = new ArrayList<LabelValue>();
		try {

			String[] split = numeroCertificato.split(" ");
			
			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];
						
			it.csi.sicee.siceeorch.dto.siceeorch.LabelValue [] labelValueA = 
					srv.getDettaglioAce(numCertificatore, progrCertificato, annoCertificato);
				
			LabelValue currRis = null;
				if (labelValueA!=null){
					
					for (it.csi.sicee.siceeorch.dto.siceeorch.LabelValue labelValue : labelValueA) {
						currRis = new LabelValue();
						currRis.setLabel(labelValue.getLabel());
						currRis.setValue(labelValue.getValue());
						ret.add(currRis);
					}
					
					
				}

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Convert error code to string.
	 *
	 * @param errorCodes the error codes
	 * @return the array list
	 */
	private ArrayList<String> convertErrorCodeToString(
			ArrayList<Integer> errorCodes) {
		ArrayList<String> ret = new ArrayList<String>();
		try {
			for (int i = 0; i < errorCodes.size(); i++) {
				switch (errorCodes.get(i).intValue()) {
				case 101:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_SIGNANDCERT_1)
							.getValore());
					break;
				case 102:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_SIGNANDCERT_2)
							.getValore());
					break;
				case 103:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_SIGNANDCERT_3)
							.getValore());
					break;
				case 400:
					this.addIfNotExists(
							ret,
							this.getSiceeTParametriDao()
									.findWhereCodiceEquals(
											Constants.KO_SIGNANDCERT_400)
									.getValore());
					break;
				case 91:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_91)
							.getValore());
					break;
				case 92:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_92)
							.getValore());
					break;
				case 93:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_93)
							.getValore());
					break;
				case 1:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_1)
							.getValore());
					break;
				case 2:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_2)
							.getValore());
					break;
				case 3:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_3)
							.getValore());
					break;
				case 4:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_4)
							.getValore());
					break;
				case 5:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_5)
							.getValore());
					break;
				case 7:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.ERROR_CODE_7)
							.getValore());
					break;
				// new dosign begin
				case 10:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_SIGNANDCERT_10)
							.getValore());
					break;
				case 11:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_SIGNANDCERT_11)
							.getValore());
					break;
				case 12:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_SIGNANDCERT_12)
							.getValore());
					break;
				case 20:
					this.addIfNotExists(
							ret,
							this.getSiceeTParametriDao()
									.findWhereCodiceEquals(
											Constants.KO_SIGNATURE_TYPE_FORMAT)
									.getValore());
					break;
				case 40:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_FILE_TYPE)
							.getValore());
					break;
				case 49:
					this.addIfNotExists(
							ret,
							this.getSiceeTParametriDao()
									.findWhereCodiceEquals(
											Constants.KO_SIGNANDCERT_4_9)
									.getValore());
					break;
				case 50:
					this.addIfNotExists(ret, this.getSiceeTParametriDao()
							.findWhereCodiceEquals(Constants.KO_COMPLIANCE)
							.getValore());
					break;
				case 60:
					this.addIfNotExists(
							ret,
							this.getSiceeTParametriDao()
									.findWhereCodiceEquals(
											Constants.KO_DIGEST_ALGORITHM)
									.getValore());
					break;

				// new dosign end
				}
			}

		} catch (Exception e) {
			log.error(e);
		}

		return ret;
	}

	/**
	 * Adds the if not exists.
	 *
	 * @param list the list
	 * @param value the value
	 */
	public void addIfNotExists(ArrayList<String> list, String value) {
		boolean add = true;
		for (String s : list) {
			if (s.equals(value)) {
				add = false;
				break;
			}
		}
		if (add) {
			list.add(value);
		}
	}

	/**
	 * Crea alberatura.
	 *
	 * @param idCertificatore the id certificatore
	 * @param anno the anno
	 * @param init the init
	 * @param end the end
	 * @throws BEException the bE exception
	 */
	public void creaAlberatura(String idCertificatore, String anno,
			Integer init, Integer end) throws BEException {
		try {
			log.debug("SOAIntegrationMgr::creaAlberatura BEGIN");
			log.debug("idCertificatore: " + idCertificatore);
			log.debug("anno: " + anno);
			log.debug("init: " + init);
			log.debug("end: " + end);
			srv.creaAlberatura(idCertificatore, anno, init, end);

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		} finally {
			log.debug("SOAIntegrationMgr::creaAlberatura END");
		}

	}

	/**
	 * Salva documento.
	 *
	 * @param cert the cert
	 * @param bytes the bytes
	 * @param nomeAttestato the nome attestato
	 * @param contentType the content type
	 * @param length the length
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String salvaDocumento(DatiCertificatore cert, byte[] bytes,
			String nomeAttestato, String contentType, long length, String tipoDocumentoIndex, Integer tipoDocumentoDB)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {

			doc.setMatricola(cert.getNumCertificatore());
			doc.setIdCertificatore(cert.getIdCertificatore());
			doc.setDoc(bytes);
			doc.setNome(nomeAttestato);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
			doc.setDataUpload(new Date(System.currentTimeMillis()));
			doc.setTipologia(tipoDocumentoIndex);

			doc.setDataUpload(new Date(System.currentTimeMillis()));

			srv.creaAlberatura(cert.getNumCertificatore(), "doc", 0, 0);
			uid = srv.inserisciAllegato(doc);

			if (BaseMgr.isNullOrEmpty(uid)) {
				throw new DocumentoException("Attestato : "
						+ nomeAttestato + " UID null!!!");
			} else {
				SiceeTDocumento dto = (SiceeTDocumento) this
						.getSiceeTDocumentoDao()
						.findWhereIdCertificatoreAndIdTipoDocEquals(cert.getIdCertificatore(), tipoDocumentoDB);
				if (dto != null) {
					String u = dto.getIdentificDoc();
					if (!BaseMgr.isNullOrEmpty(u) && !u.equals(uid)) {
						Documento docOrch = new Documento();
						docOrch.setUid(u);
						try {
							srv.cancellaDocumento(docOrch);
						} catch (DocumentoException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (SystemException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (UnrecoverableException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (CSIException e) {
							log.warn("Warning cancellazione documento", e);
						}
					}
				}
			}

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}

		return uid;
	}

	public String salvaDocumentoNew(DatiCertificatore cert, byte[] bytes,
			String nomeAttestato, String contentType, long length, String tipoDocumentoIndex, Integer tipoDocumentoDB, Integer fkCorso)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {

			doc.setMatricola(cert.getNumCertificatore());
			doc.setIdCertificatore(cert.getIdCertificatore());
			doc.setDoc(bytes);
			doc.setNome(nomeAttestato);
			doc.setMimeType(contentType);
			doc.setEncoding("UTF-8");
			doc.setDimensione(length);
			doc.setDataUpload(new Date(System.currentTimeMillis()));
			doc.setTipologia(tipoDocumentoIndex);

			doc.setDataUpload(new Date(System.currentTimeMillis()));

			srv.creaAlberatura(cert.getNumCertificatore(), "doc", 0, 0);
			uid = srv.inserisciAllegato(doc);

			if (BaseMgr.isNullOrEmpty(uid)) {
				throw new DocumentoException("Attestato : "
						+ nomeAttestato + " UID null!!!");
			} else {
				SiceeTDocumento dto = (SiceeTDocumento) this
						.getSiceeTDocumentoDao()
						.findWhereIdCertificatoreAndFkCorsoEquals(
								cert.getIdCertificatore(), fkCorso);
				if (dto != null) {
					String u = dto.getIdentificDoc();
					if (!BaseMgr.isNullOrEmpty(u) && !u.equals(uid)) {
						Documento docOrch = new Documento();
						docOrch.setUid(u);
						try {
							srv.cancellaDocumento(docOrch);
						} catch (DocumentoException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (SystemException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (UnrecoverableException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (CSIException e) {
							log.warn("Warning cancellazione documento", e);
						}
					}
				}
			}

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}

		return uid;
	}

	/**
	 * Salva documento.
	 *
	 * @param cert the cert
	 * @param bytes the bytes
	 * @param nomeAttestato the nome attestato
	 * @param contentType the content type
	 * @param length the length
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String salvaDocumento(DatiCertificatore cert, byte[] bytes,
			String nomeAttestato, String tipoDocumentoIndex, DatiAttestato att)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {

//			doc.setMatricola(cert.getNumCertificatore());
//			doc.setIdCertificatore(cert.getIdCertificatore());
//			doc.setDoc(bytes);
//			doc.setNome(nomeAttestato);
//			doc.setMimeType("application/pdf");
//			doc.setEncoding("UTF-8");
//			doc.setDimensione(new Long(bytes.length));
//			doc.setDataUpload(new Date(System.currentTimeMillis()));
//			doc.setTipologia(tipoDocumentoIndex);
//
//			doc.setDataUpload(new Date(System.currentTimeMillis()));
//
//			
			
			
			String[] split = BaseMgr.recuperaChiaveAttestato(
					cert.getIdCertificatore(), att.getNumeroAttestato());

			String id = split[Constants.PK_ID_CERTIFICATORE];
			String prog = split[Constants.PK_PROGR];
			String anno = split[Constants.PK_ANNO];
			
			doc = new Documento();
			doc.setAttestato(att.getNumeroAttestato());
			doc.setDoc(bytes);
			doc.setNome(nomeAttestato);
			doc.setMimeType("application/pdf");
			doc.setEncoding("UTF-8");
			doc.setDimensione(new Long(bytes.length));
			
//			doc.setClasseEnergetica(att.getClasseEnerg().getLocTeorica()
//					.getDescClasseEnerg());
			
//			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali()
//					.getDescrComune());
//			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			//doc.setTipologia(tipoDocumentoIndex);
			doc.setTipologia(tipoDocumentoIndex);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(id);
			doc.setProgrCertificato(prog);
			doc.setDataUpload(new Date(System.currentTimeMillis()));
			
			
			
			uid = srv.inserisciDocumento(doc);
			
//			srv.creaAlberatura(cert.getNumCertificatore(), "doc", 0, 0);
//			uid = srv.inserisciAllegato(doc);

			if (BaseMgr.isNullOrEmpty(uid)) {
				throw new DocumentoException("Attestato : "
						+ nomeAttestato + " UID null!!!");
			}
			
			/*
			else {
				
				
				SiceeTDocumento dto = (SiceeTDocumento) this
						.getSiceeTDocumentoDao()
						.findWhereIdCertificatoreAndIdTipoDocEquals(
								cert.getIdCertificatore(), tipoDocumentoDB);
				if (dto != null) {
					String u = dto.getIdentificDoc();
					if (!BaseMgr.isNullOrEmpty(u) && !u.equals(uid)) {
						Documento docOrch = new Documento();
						docOrch.setUid(u);
						try {
							srv.cancellaDocumento(docOrch);
						} catch (DocumentoException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (SystemException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (UnrecoverableException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (CSIException e) {
							log.warn("Warning cancellazione documento", e);
						}
					}
				}
			}
			*/

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		} 
		return uid;
	}

	/**
	 * Convert to.
	 *
	 * @param filtro the filtro
	 * @return the it.csi.sicee.siceeorch.dto.siceeorch. filtro ricerca ace
	 */
	private it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce convertTo(
			FiltroRicercaAce filtro) {
		it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce ret = new it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce();
		
		
		log.debug("convertTo - inizio");
		
		if (log.isDebugEnabled())
		{
			GenericUtil.stampa(filtro, true, 3);
		}
		
		ret.setAnno(filtro.getAnnoCertificato());
		ret.setCertificatore(filtro.getCertificatore());
		ret.setNumero(filtro.getProgCertificato());
		
		ret.setCodProv(filtro.getCodProv());
		if (GenericUtil.isNotNullOrEmpty(filtro.getCodComune()))
		{
			log.debug("Setto il codComune: "+filtro.getCodComune());
			ret.setCodComune(filtro.getCodComune());
		}
		else
		{
			log.debug("Setto il descComune: "+filtro.getDescComune());

			ret.setDescComune(filtro.getDescComune());
		}

		ret.setDescIndirizzo(filtro.getDescIndirizzo());
		ret.setNumCivico(filtro.getNumCivico());
		ret.setSezione(filtro.getSezione());
		ret.setFoglio(filtro.getFoglio());
		ret.setParticella(filtro.getParticella());
		ret.setSubalterno(filtro.getSubalterno());
		ret.setStato(filtro.getStato());
		
		if (log.isDebugEnabled())
		{
			GenericUtil.stampa(ret, true, 3);
		}
		
		log.debug("convertTo - fine");
		
		return ret;
	}

	/**
	 * Convert to.
	 *
	 * @param ace the ace
	 * @return the ace
	 */
	private Ace convertTo(it.csi.sicee.siceeorch.dto.siceeorch.Ace ace, int idRiga) {
		Ace ret = new Ace();
		
		ret.setIdRigaTabella(idRiga);
		String indirizzo = ace.getIndirizzo();
		
		if (!BaseMgr.isNullOrEmpty(ace.getCivico())) {
			indirizzo = indirizzo + ", " + ace.getCivico();
		}
		
		indirizzo = indirizzo + " - " + ace.getComune() + " - (" + ace.getProvincia()
				+ ")";

		ret.setDescIndirizzo(indirizzo);
		
		

		ret.setDescDatiCat(ace.getDescDatiCat());
		
		ret.setCodice(ace.getAnno() + " " + ace.getCertificatore() + " "
				+ ace.getNumero());
		ret.setAnno(ace.getAnno());
		ret.setCertificatore(ace.getCertificatore());
		ret.setNumero(ace.getNumero());
		ret.setDataInvio(DateUtil.convertToString(ace.getDataInvio()));
		ret.setUid(ace.getUid());
		ret.setCognome(ace.getCognome());
		ret.setNome(ace.getNome());
		ret.setDataUpload(DateUtil.convertToString(ace.getDataUpload()));
		ret.setDataScadenza(DateUtil.convertToString(ace.getDataScadenza()));
		
		ret.setFlgInviato("Modulo A.P.E.");
		ret.setLinkDownload("Modulo A.P.E.");
		
		ret.setStato(ace.getDescStato());
		
		if (!GenericUtil.isNullOrEmpty(ace.getIdStato())
				&& ace.getIdStato() == Constants.INVIATO) {
			ret.setFlgRicevuta("Ricevuta");
		}

		if (!GenericUtil.isNullOrEmpty(ace.getUidIndicatore()))
		{
			ret.setUidIndicatore(ace.getUidIndicatore());
			ret.setLinkDownloadInd(ret.getCodice());
		}
		return ret;
	}

	/**
	 * Convert to.
	 *
	 * @param ace the ace
	 * @return the array list
	 */
	private ArrayList<Ace> convertTo(
			it.csi.sicee.siceeorch.dto.siceeorch.Ace[] ace) {
		ArrayList<Ace> ret = null;

		if (!BaseMgr.isNullOrEmpty(ace)) {
			int i = 1;
			ret = new ArrayList<Ace>();
			for (it.csi.sicee.siceeorch.dto.siceeorch.Ace a : ace) {
				ret.add(this.convertTo(a, i++));
			}
		}

		return ret;
	}

	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAce(
			it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce filtro)
			throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace ace = srv.findAce(this
					.convertTo(filtro));
			
			if (ace != null) {
				
				/*
				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv
						.findCertificatore(filtro.getCertificatore());
				if (cert != null) {
					ace.setCertificatore(cert.getMatricola());
				}
				*/
				
				ret.add(this.convertTo(ace, 1));
			}

			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAce:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAce:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAce:" + e, e);
		}
	}

	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAceFlgPregresso(
			it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce filtro, boolean flgPregresso)
			throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace ace = srv.findAceFlgPregresso(this
					.convertTo(filtro), flgPregresso);
			if (ace != null) {
				
				/*
				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv
						.findCertificatore(filtro.getCertificatore());
				if (cert != null) {
					ace.setCertificatore(cert.getMatricola());
				}
				*/
				ret.add(this.convertTo(ace, 1));
			}

			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAce:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAce:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAce:" + e, e);
		}
	}
	
	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAceFiltro(
			it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce filtro, String idCertificatore)
			throws BEException {
		return findAceFiltro(filtro, idCertificatore, false, false);
	}
	
	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAceFiltro(
			it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce filtro, String idCertificatore, boolean flgPregresso, boolean flgSostituzione)
			throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace[] aceList = srv.findAceFiltro(this
					.convertTo(filtro), idCertificatore, flgPregresso, flgSostituzione);
			if (aceList != null) {
				/*
				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv
						.findCertificatore(filtro.getCertificatore());
				if (cert != null) {
				*/
				int idRiga = 1;
					for (it.csi.sicee.siceeorch.dto.siceeorch.Ace ace : aceList) {
						
						//ace.setCertificatore(cert.getMatricola());
						ret.add(this.convertTo(ace, idRiga++));
					}
					
				//}
				
			}

			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		}
	}
	
	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public Integer findAceFiltroCount(
			it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce filtro, String idCertificatore, boolean flgPregresso)
			throws BEException {
		Integer ret = null;
		try {
			ret = srv.findAceFiltroCount(this
					.convertTo(filtro), idCertificatore, flgPregresso, false);
				
			log.debug("STAMPO il count: "+ret);

			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		}
	}
	
	/**
	 * Find ace.
	 *
	 * @param idCertificatore the idCertificatore
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAceMonitoraggio(String idCertificatore)
			throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace[] aceList = srv.findAceMonitoraggio(idCertificatore);
			if (aceList != null) {
				/*
				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv
						.findCertificatore(filtro.getCertificatore());
				if (cert != null) {
				*/
				int idRiga = 1;
					for (it.csi.sicee.siceeorch.dto.siceeorch.Ace ace : aceList) {
						
						//ace.setCertificatore(cert.getMatricola());
						ret.add(this.convertTo(ace, idRiga++));
					}
					
				//}
				
			}

			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAceMonitoraggio:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAceMonitoraggio:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAceMonitoraggio:" + e, e);
		}
	}
	
	/**
	 * Find ace sostitutivi.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAceSostitutivi(
			it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce filtro)
			throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			ret = this
					.convertTo(srv.findAceSostitutivi(this.convertTo(filtro)));

			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		}
	}

	/**
	 * Gets the stampa certificato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @param scrittaSfondo the scritta sfondo
	 * @return the stampa certificato
	 * @throws BEException the bE exception
	 */
	public byte[] getStampaCertificato(String numeroCertificato,
			String scrittaSfondo) throws BEException {
		byte[] ret = null;
		try {

			// String[] split =
			// BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(),
			// numeroCertificato);

			String[] split = numeroCertificato.split(" ");

			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];

			
			ret = srv.getStampaCertificato(numCertificatore, progrCertificato,
					annoCertificato, scrittaSfondo);

			return ret;

		} catch (SystemException e) {
			throw new BEException("Errore in getStampaCertificato:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getStampaCertificato:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getStampaCertificato:" + e, e);
		}
	}

	/**
	 * Gets the stampa certificato.
	 *
	 * @param idCertificatore the id certificatore
	 * @param numeroCertificato the numero certificato
	 * @param idTipoDoc the tipo di documento
	 * @return the stampa certificato
	 * @throws BEException the bE exception
	 */
	public byte[] getStampaCertificatoNew(String idCertificatore, String numeroCertificato, Integer idTipoDoc) throws BEException {
		byte[] ret = null;
		try {

			// String[] split =
			// BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(),
			// numeroCertificato);

			String[] split = numeroCertificato.split(" ");

			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];


			SiceeTRifIndex2015 tRifIndex2015 = getSiceeTRifIndex2015Dao().findBySiceeTCertificatoidTipoDoc(idCertificatore, progrCertificato, annoCertificato, idTipoDoc);
			Documento doc = recuperaDocumento(tRifIndex2015.getUidIndex());
			ret = doc.getDoc();
			
			return ret;

		} catch (SiceeTRifIndex2015DaoException e) {
			throw new BEException("Errore in getStampaCertificatoNew:" + e, e);
		} catch (Exception e) {
			throw new BEException("Errore in getStampaCertificatoNew:" + e, e);
		}
	}
	
	/**
	 * Gets the stampa certificato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @param idTipoDoc the tipo di documento
	 * @return the stampa certificato
	 * @throws BEException the bE exception
	 */
	public byte[] getStampaCertificatoNew(String numeroCertificato, Integer idTipoDoc) throws BEException {
		byte[] ret = null;
		try {

			// String[] split =
			// BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(),
			// numeroCertificato);


			String[] split = numeroCertificato.split(" ");

			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];

			SiceeTCertificatore cert = getSiceeTCertificatoreDao().findWhereNumCertificatoreEquals(numCertificatore);

			SiceeTRifIndex2015 tRifIndex2015 = getSiceeTRifIndex2015Dao().findBySiceeTCertificatoidTipoDoc(cert.getIdCertificatore(), progrCertificato, annoCertificato, idTipoDoc);
			Documento doc = recuperaDocumento(tRifIndex2015.getUidIndex());
			ret = doc.getDoc();
			
			return ret;

		} catch (SiceeTRifIndex2015DaoException e) {
			throw new BEException("Errore in getStampaCertificatoNew:" + e, e);
		} catch (Exception e) {
			throw new BEException("Errore in getStampaCertificatoNew:" + e, e);
		}
	}
	
	/**
	 * Gets the stampa certificato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @param idTipoDoc the tipo di documento
	 * @return the stampa certificato
	 * @throws BEException the bE exception
	 */
	public boolean isAttestatoOld(String numeroCertificato) throws BEException {
		try {

			// String[] split =
			// BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(),
			// numeroCertificato);


			String[] split = numeroCertificato.split(" ");

			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];

			SiceeTCertificatore certificatore = getSiceeTCertificatoreDao().findWhereNumCertificatoreEquals(numCertificatore);

			SiceeTCertificato certificato = getSiceeTCertificatoDao().findByPrimaryKey(certificatore.getIdCertificatore(), progrCertificato, annoCertificato);

			return certificato.getFlgOld().equalsIgnoreCase(Constants.SI);

		} catch (Exception e) {
			throw new BEException("Errore in isAttestatoOld:" + e, e);
		}
	}
	
	/**
	 * Gets the stampa ricevuta invio ace.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the stampa ricevuta invio ace
	 * @throws BEException the bE exception
	 */
	public byte[] getStampaRicevutaInvioAce(String numeroCertificato)
			throws BEException {
		byte[] ret = null;
		try {

			String[] split = numeroCertificato.split(" ");

			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];

			ret = srv.getStampaRicevutaInvioAce(numCertificatore,
					progrCertificato, annoCertificato);

			return ret;
		} catch (SiceesrvException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		}
	}

	/**
	 * Check mime type immagine.
	 *
	 * @param file the file
	 * @return the string
	 */
	public String checkMimeTypeImmagine(File file) {
		String out = null;
		try {
			Documento documento = new Documento();
			documento.setDoc(this.getMiscMgr().readFile(file));
			documento.setNome(file.getName());

			MimeTypeInfo info;

			info = srv.getMimeTypeInfo(documento);
			//log.debug("\n\n\n >>>>>>> info.getMimeType(): " + info.getMimeType());
			if (info != null) {
				
				if (log.isDebugEnabled())
					log.debug("Stampo il mimeType della foto: "+info.getMimeType());

				String param = this.getMiscMgr()
						.getParametroFormatiImmaginiAmmessi();
				String[] ends = param.split(",");

				for (int i = 0; i < ends.length; i++) {
					if (info.getMimeType().equals(ends[i])) {
						out = info.getMimeType();
						break;
					}
				}
			}
		} catch (Exception e) {
			log.warn("", e);
		}
		return out;
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

	/**
	 * Verifica transazione pagamento.
	 *
	 * @param numeroTransazione the numero transazione
	 * @return the it.csi.sicee.siceeweb.dto.pagamenti. transazione
	 * @throws BEException the bE exception
	 */
	public it.csi.sicee.siceeweb.dto.pagamenti.Transazione verificaTransazionePagamento(
			String numeroTransazione) throws BEException {
		it.csi.sicee.siceeweb.dto.pagamenti.Transazione ret = null;
		try {

			Transazione box = srv.getMdpTransactionState(numeroTransazione);
			ret = Converter.convertTo(box);

		} catch (PagamentoException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in acquistaArticolo:" + e, e);
		}
		
		return ret;

	}

	/**
	 * Ricerca visura per codice impianto.
	 *
	 * @param codiceImpianto the codice impianto
	 * @return the ArrayList<VisuraImpianto> impianti
	 * @throws BEException the bE exception
	 */
	public ArrayList<VisuraImpianto> visuraByCodImpianto(
			Integer codiceImpianto) throws BEException {
		
		ArrayList<VisuraImpianto> ret = null;
		try {

			Impianto[] impianti = srv.findImpiantoByCodice(codiceImpianto);
			
			if (log.isDebugEnabled())
				log.debug("Stampo gli impianti trovati: "+impianti);
			
			if (impianti != null && impianti.length > 0)
			{
				log.debug("Stampo la lunghezza degli impianti: "+impianti.length);
				
				ret = MapDto.mapToImpianto(impianti);
			}
			
			//ret = Converter.convertTo(box);

		
		} catch (SystemException e) {
			throw new BEException("Errore in visuraByCodImpianto:" + e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in visuraByCodImpianto:" + e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException("Errore in visuraByCodImpianto:" + e.getMessage(), e);
		}
		
		return ret;

	}
	
	/**
	 * Ricerca visura per pod.
	 *
	 * @param pod the pod
	 * @return the ArrayList<VisuraImpianto> impianti
	 * @throws BEException the bE exception
	 */
	public ArrayList<VisuraImpianto> visuraByPOD(
			String pod) throws BEException, UserException {
		
		ArrayList<VisuraImpianto> ret = null;
		try {

			Impianto[] impianti = srv.findImpiantoByPOD(pod);
			
			if (log.isDebugEnabled())
				log.debug("Stampo gli impianti trovati: "+impianti);
			
			if (impianti != null && impianti.length > 0)
			{
				log.debug("Stampo la lunghezza degli impianti: "+impianti.length);
				
				ret = MapDto.mapToImpianto(impianti);
			}
			
			//ret = Converter.convertTo(box);

		
		} 
		catch (SigitExcessiveResultsException e) {
			throw new UserException("Sono stati estratti troppi risultati");
		} catch (SystemException e) {
			throw new BEException("Errore in visuraByPOD:" + e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in visuraByPOD:" + e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException("Errore in visuraByPOD:" + e.getMessage(), e);
		}
		
		return ret;

	}
	
	/**
	 * Ricerca visura per pdr.
	 *
	 * @param pdr the pdr
	 * @return the ArrayList<VisuraImpianto> impianti
	 * @throws BEException the bE exception
	 */
	public ArrayList<VisuraImpianto> visuraByPDR(
			String pdr) throws BEException, UserException {
		
		ArrayList<VisuraImpianto> ret = null;
		try {

			Impianto[] impianti = srv.findImpiantoByPDR(pdr);
			
			if (log.isDebugEnabled())
				log.debug("Stampo gli impianti trovati: "+impianti);
			
			if (impianti != null && impianti.length > 0)
			{
				log.debug("Stampo la lunghezza degli impianti: "+impianti.length);
				
				ret = MapDto.mapToImpianto(impianti);
			}
			
			//ret = Converter.convertTo(box);

		
		} 
		catch (SigitExcessiveResultsException e) {
			throw new UserException("Sono stati estratti troppi risultati");
		} catch (SystemException e) {
			throw new BEException("Errore in visuraByPDR:" + e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in visuraByPDR:" + e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException("Errore in visuraByPDR:" + e.getMessage(), e);
		}
		
		return ret;

	}

	public ArrayList<VisuraImpianto> visuraByIndirizzo(
			String istat,String indirizzo, String civico) throws BEException, UserException {

		ArrayList<VisuraImpianto> ret = null;
		try {

			Impianto[] impianti = srv.findImpiantoByIndirizzo(istat, indirizzo, civico);

			if (log.isDebugEnabled())
				log.debug("Stampo gli impianti trovati: " + impianti);

			if (impianti != null && impianti.length > 0) {
				log.debug("Stampo la lunghezza degli impianti: " + impianti.length);

				ret = MapDto.mapToImpianto(impianti);
			}

			//ret = Converter.convertTo(box);

		} catch (SigitExcessiveResultsException e) {
			throw new UserException("Sono stati estratti troppi risultati");
		} catch (SystemException e) {
			throw new BEException("Errore in visuraByIndirizzo:" + e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in visuraByIndirizzo:" + e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException("Errore in visuraByIndirizzo" + e.getMessage(), e);
		}

		return ret;

	}
	
	/**
	 * Ricerca libretto.
	 *
	 * @param uid the uid del libretto
	 * @return the byte[] libretto
	 * @throws BEException the bE exception
	 */
	public Documento recuperaLibrettoByUID(
			String uid) throws BEException {
		
		Documento ret = null;
		try {

			ret = srv.findLibrettoByUID(uid);
			
		} catch (SystemException e) {
			throw new BEException("Errore in recuperaLibrettoByUID:" + e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in recuperaLibrettoByUID:" + e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException("Errore in recuperaLibrettoByUID:" + e.getMessage(), e);
		}
		
		return ret;

	}
	
	/**
	 * Recupera documento.
	 *
	 * @param uid the uid
	 * @return the documento
	 */
	public byte[] recuperaStampaCertificatoReadOnly(String idCertificatore, String progrCertificato, String anno, Integer idStatoCertificato)  throws BEException {
		byte[] docPdf = null;
		try {

			docPdf = srv.getStampaCertificatoIText(idCertificatore, progrCertificato, anno, idStatoCertificato);
			
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly: " + e, e);

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly: " + e, e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly: " + e, e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly: " + e, e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly: " + e, e);
		}
		return docPdf;
	}
	
	
	public byte[] recuperaStampaRicevutaApeReadOnly(Integer idCredito)  throws BEException {
		byte[] docPdf = null;
		try {
			
			log.info("[SOAIntegrationMgr] - idCredito: " + idCredito);
			docPdf = srv.getStampaRicevutaApe(idCredito);
			
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaRicevutaApeReadOnly: " + e, e);

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaRicevutaApeReadOnly: " + e, e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaRicevutaApeReadOnly: " + e, e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaRicevutaApeReadOnly: " + e, e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaRicevutaApeReadOnly: " + e, e);
		}
		return docPdf;
	}
	
	/**
	 * Recupera documento.
	 *
	 * @param uid the uid
	 * @return the documento
	 */
	public byte[] recuperaStampaTarghettaCertificatoReadOnly(String idCertificatore, String progrCertificato, String anno)  throws BEException {
		byte[] docPdf = null;
		try {
			
			docPdf = srv.getStampaTarghettaCertificatoIText(idCertificatore, progrCertificato, anno);
			
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaTarghettaCertificatoReadOnly: " + e, e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaTarghettaCertificatoReadOnly: " + e, e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaTarghettaCertificatoReadOnly: " + e, e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaTarghettaCertificatoReadOnly: " + e, e);
		} 
		catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaTarghettaCertificatoReadOnly: " + e, e);
		}
		
		
		return docPdf;
	}
	
	/**
	 * Gets the stato transazione.
	 *
	 * @param numeroTransazione the numero transazione
	 * @return the stato transazione
	 * @throws BEException the bE exception
	 */
	public String getNewNumTransazione() throws BEException {

		try {

			String numTransazione = srv.getMdpNewTransazione();

			log.debug("SOAIntegrationMgr::getNewNumTransazione - numTransazione: "+numTransazione);
			
			return numTransazione;
		} catch (PagamentoException e) {
			throw new BEException("Errore in getNewNumTransazione:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getNewNumTransazione:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getNewNumTransazione:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getNewNumTransazione:" + e, e);
		}

	}

	public String getNewUrlWisp(
			String numeroTransazione, Double valore) throws BEException {

		try {

			String urlWisp = srv.getMdpNewUrlWisp(numeroTransazione, valore);

			if (log.isDebugEnabled())
				log.debug("SOAIntegrationMgr::getNewUrlWisp - urlWisp: "+urlWisp);
			
			return urlWisp;
		} catch (PagamentoException e) {
			throw new BEException("Errore in getNewUrlWisp:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getNewUrlWisp:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getNewUrlWisp:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getNewUrlWisp:" + e, e);
		}

	}
	
	public InformativaSceltaNew getNewSceltaWisp(
			String numeroTransazione) throws BEException {

		try {

			InformativaScelta info = srv.getMdpNewSceltaWisp(numeroTransazione);

			if (log.isDebugEnabled())
				log.debug("SOAIntegrationMgr::getNewSceltaWisp - info: "+info);
			
			return Converter.convertTo(info);
		} catch (PagamentoException e) {
			throw new BEException("Errore in getNewSceltaWisp:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getNewSceltaWisp:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getNewSceltaWisp:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getNewSceltaWisp:" + e, e);
		}

	}
	
	public String getNewNumIUV() throws BEException {

		try {

			String iuv = srv.getMdpNewIUV();

			if (log.isDebugEnabled())
				log.debug("SOAIntegrationMgr::getNewNumIUV - info: "+iuv);
			
			return iuv;
		} catch (PagamentoException e) {
			throw new BEException("Errore in getNewNumIUV:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getNewNumIUV:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getNewNumIUV:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getNewNumIUV:" + e, e);
		}

	}
	
	public String getNewUrlPagamento(
			DatiCertificatore certificatore, DatiPagamentoNew pagamento, String numIUV) throws BEException {

		try {
			DettaglioPagamento dettaglio = Converter.convertTo(certificatore, pagamento, numIUV);
			
			if (log.isDebugEnabled())
				GenericUtil.stampa(dettaglio, true, 3);
			
			String urlPagamento = srv.getMdpNewUrlPagamento(dettaglio);

			if (log.isDebugEnabled())
				log.debug("SOAIntegrationMgr::getNewSceltaWisp - urlPagamento: "+urlPagamento);
			
			return urlPagamento;
		} catch (PagamentoException e) {
			throw new BEException("Errore in getNewUrlPagamento:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getNewUrlPagamento:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getNewUrlPagamento:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getNewUrlPagamento:" + e, e);
		}

	}
	
	public void insertLogAccesso(String codiceFiscale, String nome, String cognome, String ruolo) throws BEException {
		try {
			srv.insertLogAccesso(codiceFiscale, nome, cognome, ruolo);
		} catch (SiceesrvException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		}

	}
	
	public boolean sendMailService(it.csi.sicee.siceeweb.util.Mail emailVo, it.csi.sicee.siceeorch.dto.siceeorch.Documento doc) throws BEException{
		log.info("[SOAIntegrationMgr::sendMailService] START");

		boolean isMailInviata = false;
		try {
			log.info("Prima di getWSSicee");
			
//			boolean isAlive = getWSSicee().isAlive();
//			log.info("isAlive: "+isAlive);

			it.csi.sicee.siceews.stubs.Mail mailService = new it.csi.sicee.siceews.stubs.Mail();
			
			mailService.setMittente(emailVo.getMittente());
			mailService.setDestinatario(emailVo.getDestinatario());
			mailService.setDestinatarioCC(emailVo.getDestinatarioCC());
			mailService.setOggetto(emailVo.getOggetto());
			mailService.setHtml(emailVo.getHtml());
			
			
			ArrayList<it.csi.sicee.siceews.stubs.Allegato> elencoAllegati = new ArrayList<it.csi.sicee.siceews.stubs.Allegato>();

			if (doc != null)
			{
				
				it.csi.sicee.siceews.stubs.Allegato allegato = new it.csi.sicee.siceews.stubs.Allegato();
				allegato.setNomeFile(doc.getNome());
				allegato.setContentType("application/xml");
				allegato.setFile(doc.getDoc());
				elencoAllegati.add(allegato);

			}
			
			/*
			if (ricevutaInvioByte != null)
			{
				it.csi.sicee.siceews.stubs.Allegato allegatoRicevuta = new it.csi.sicee.siceews.stubs.Allegato();
				allegatoRicevuta.setNomeFile("ricevuta_trasmissione.pdf");
				allegatoRicevuta.setContentType("application/pdf");
				allegatoRicevuta.setFile(ricevutaInvioByte);
				elencoAllegati.add(allegatoRicevuta);
			}
			*/
			
			if (elencoAllegati.size() > 0)
			{
				
				it.csi.sicee.siceews.stubs.Allegato[] elencoAllegatiNew = new it.csi.sicee.siceews.stubs.Allegato[elencoAllegati.size()]; 
				elencoAllegatiNew = elencoAllegati.toArray(elencoAllegatiNew);
				
				mailService.setElencoAllegati(elencoAllegatiNew);
			
			}
			
			isMailInviata = getWSSicee().invioMail(mailService);

			log.info("Dopo della chiamta SICEEWS");
			
		} catch (Exception e) {
			log.error("[SOAIntegrationMgr::sendMailService] - Errore nell'invio della mail", e);
			throw new BEException("Errore nell'invio della mail:" + e, e);
		}
		finally {
			log.info("[SOAIntegrationMgr::sendMailService] END");
		}
		return isMailInviata;
	}
	
	public CoordinateLOCCSI getCoordinateLOCCSI(String comune, String indirizzo, String civico) throws BEException {
		try {
			return srv.getCoordinateLOCCSI(comune, indirizzo, civico);
		} catch (CSIException e) {
			log.error("Impossibile recuperare coordinate LOCCSI:" + e);
			CoordinateLOCCSI coordinateLOCCSI = new CoordinateLOCCSI();
			coordinateLOCCSI.setCoordX(0.0);
			coordinateLOCCSI.setCoordY(0.0);
			
			return coordinateLOCCSI;
		} catch (Exception e) {
			log.error("Errore in getCoordinateLOCCSI:" + e);
			throw new BEException("Errore in getCoordinateLOCCSI:" + e, e);
		}

	}

	@Transactional
	public String salvaDocAggiuntiva(Documento documento) throws BEException {
		try {
			return srv.inserisciDocumento(documento);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		}
	}
}
