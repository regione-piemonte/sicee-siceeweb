/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCorso2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCreditoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDIstruzioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoIstruzioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTitoloDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAziendaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCredito2018Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiEsamiDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEsameDpr75Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEsamiDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeWCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeWEmailNewsletterDao;
import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCorso2015;
import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCredito;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDIstruzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocumento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTitolo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAziendaPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatorePk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsami;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEsamiPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsameDpr75;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsameDpr75Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCorso2015DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCreditoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDIstruzioneDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoDocumentoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoIstruzioneDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTitoloDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertificatoreDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocumentoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWEmailNewsletterDaoException;
import it.csi.sicee.siceeweb.dto.attestati.CorsoAttestatoSummary;
import it.csi.sicee.siceeweb.dto.attestati.CurriculumSummary;
import it.csi.sicee.siceeweb.dto.certificatore.Attestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiAnag;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCompetenze;
import it.csi.sicee.siceeweb.dto.certificatore.DatiEsame;
import it.csi.sicee.siceeweb.dto.certificatore.DatiOrdine;
import it.csi.sicee.siceeweb.dto.certificatore.DatiResidenza;
import it.csi.sicee.siceeweb.dto.certificatore.DatiStudio;
import it.csi.sicee.siceeweb.dto.certificatore.Titolo;
import it.csi.sicee.siceeweb.dto.commons.DocumentSummary;
import it.csi.sicee.siceeweb.dto.daticert.Istruzione;
import it.csi.sicee.siceeweb.dto.pagamenti.GestioneCreditoNew;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.Converter;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.GenericUtil;
import it.csi.sicee.siceeweb.util.Messages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

// TODO: Auto-generated Javadoc
/**
 * Facade di gestione dell'entita' Certificatore.
 *
 * @author 869
 */
public class CertificatoreMgr extends BaseMgr {

	/** The soa integration mgr. */
	//private SOAIntegrationMgr soaIntegrationMgr;

	/**
	 * Gets the soa integration mgr.
	 *
	 * @return the soa integration mgr
	 */
//	public SOAIntegrationMgr getSoaIntegrationMgr() {
//		return this.soaIntegrationMgr;
//	}

	/**
	 * Sets the soa integration mgr.
	 *
	 * @param soaIntegrationMgr the new soa integration mgr
	 */
//	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
//		this.soaIntegrationMgr = soaIntegrationMgr;
//	}
	
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
	 * Sets the sicee t certificatore dao.
	 *
	 * @param siceeTCertificatoreDao the new sicee t certificatore dao
	 */
	public void setSiceeTCertificatoreDao(
			SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
	}

	/** The sicee t azienda dao. */
	private SiceeTAziendaDao siceeTAziendaDao;

	/**
	 * Gets the sicee t azienda dao.
	 *
	 * @return the sicee t azienda dao
	 */
	public SiceeTAziendaDao getSiceeTAziendaDao() {
		return this.siceeTAziendaDao;
	}

	/**
	 * Sets the sicee t azienda dao.
	 *
	 * @param siceeTAziendaDao the new sicee t azienda dao
	 */
	public void setSiceeTAziendaDao(SiceeTAziendaDao siceeTAziendaDao) {
		this.siceeTAziendaDao = siceeTAziendaDao;
	}

	/** The sicee d titolo dao. */
	private SiceeDTitoloDao siceeDTitoloDao;

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
	public void setSiceeDTitoloDao(SiceeDTitoloDao siceeDTitoloDao) {
		this.siceeDTitoloDao = siceeDTitoloDao;
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

	/** The sicee d tipo documento dao. */
	private SiceeDTipoDocumentoDao siceeDTipoDocumentoDao;

	/**
	 * Gets the sicee d tipo documento dao.
	 *
	 * @return the sicee d tipo documento dao
	 */
	public SiceeDTipoDocumentoDao getSiceeDTipoDocumentoDao() {
		return this.siceeDTipoDocumentoDao;
	}

	/**
	 * Sets the sicee d tipo documento dao.
	 *
	 * @param siceeDTipoDocumentoDao the new sicee d tipo documento dao
	 */
	public void setSiceeDTipoDocumentoDao(
			SiceeDTipoDocumentoDao siceeDTipoDocumentoDao) {
		this.siceeDTipoDocumentoDao = siceeDTipoDocumentoDao;
	}

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

	/** The sicee t documento dao. */
	private SiceeTDocumentoDao siceeTDocumentoDao;

	/** The sicee t esami dao. */
	private SiceeTEsamiDao siceeTEsamiDao;

	/**
	 * Sets the sicee t esami dao.
	 *
	 * @param siceeTEsamiDao the new sicee t esami dao
	 */
	public void setSiceeTEsamiDao(SiceeTEsamiDao siceeTEsamiDao) {
		this.siceeTEsamiDao = siceeTEsamiDao;
	}

	/**
	 * Gets the sicee t esami dao.
	 *
	 * @return the sicee t esami dao
	 */
	public SiceeTEsamiDao getSiceeTEsamiDao() {
		return this.siceeTEsamiDao;
	}

	/** The sicee t dati esami dao. */
	private SiceeTDatiEsamiDao siceeTDatiEsamiDao;

	/**
	 * Sets the sicee t dati esami dao.
	 *
	 * @param siceeTDatiEsamiDao the new sicee t dati esami dao
	 */
	public void setSiceeTDatiEsamiDao(SiceeTDatiEsamiDao siceeTDatiEsamiDao) {
		this.siceeTDatiEsamiDao = siceeTDatiEsamiDao;
	}

	/**
	 * Gets the sicee t dati esami dao.
	 *
	 * @return the sicee t dati esami dao
	 */
	public SiceeTDatiEsamiDao getSiceeTDatiEsamiDao() {
		return this.siceeTDatiEsamiDao;
	}

	/** The sicee t esame dpr75 dao. */
	private SiceeTEsameDpr75Dao siceeTEsameDpr75Dao;

	/**
	 * Sets the sicee t dati esami dao.
	 *
	 * @param siceeTDatiEsamiDao the new sicee t esame dpr75 dao
	 */
	public void setSiceeTEsameDpr75Dao(SiceeTEsameDpr75Dao siceeTEsameDpr75Dao) {
		this.siceeTEsameDpr75Dao = siceeTEsameDpr75Dao;
	}

	/**
	 * Gets the sicee t dati esami dao.
	 *
	 * @return the sicee t esame dpr75 dao
	 */
	public SiceeTEsameDpr75Dao getSiceeTEsameDpr75Dao() {
		return this.siceeTEsameDpr75Dao;
	}
	
	/** The sicee w email newsletter dao. */
	private SiceeWEmailNewsletterDao siceeWEmailNewsletterDao;

	/**
	 * Sets the sicee w email newsletter dao.
	 *
	 * @param siceeWEmailNewsletterDao the new sicee w email newsletter dao
	 */
	public void setSiceeWEmailNewsletterDao(
			SiceeWEmailNewsletterDao siceeWEmailNewsletterDao) {
		this.siceeWEmailNewsletterDao = siceeWEmailNewsletterDao;
	}

	/**
	 * Gets the sicee w email newsletter dao.
	 *
	 * @return the sicee w email newsletter dao
	 */
	public SiceeWEmailNewsletterDao getSiceeWEmailNewsletterDao() {
		return this.siceeWEmailNewsletterDao;
	}

	/** The transazione registraz mgr. */
	private TransazioneRegistrazMgr transazioneRegistrazMgr;

	
	
	
	/** The sicee d tipo istruzione dao. */
	private SiceeDTipoIstruzioneDao siceeDTipoIstruzioneDao;

	/**
	 * Gets the sicee d tipo istruzione dao.
	 *
	 * @return the sicee d tipo istruzione dao
	 */
	public SiceeDTipoIstruzioneDao getSiceeDTipoIstruzioneDao() {
		return this.siceeDTipoIstruzioneDao;
	}

	/**
	 * Sets the sicee d tipo istruzione dao.
	 *
	 * @param SiceeDTipoIstruzioneDao the new sicee d tipo istruzione dao
	 */
	public void setSiceeDTipoIstruzioneDao(SiceeDTipoIstruzioneDao siceeDTipoIstruzioneDao) {
		this.siceeDTipoIstruzioneDao = siceeDTipoIstruzioneDao;
	}
	
	/** The sicee d istruzione dao. */
	private SiceeDIstruzioneDao siceeDIstruzioneDao;

	/**
	 * Gets the sicee d istruzione dao.
	 *
	 * @return the sicee d istruzione dao
	 */
	public SiceeDIstruzioneDao getSiceeDIstruzioneDao() {
		return this.siceeDIstruzioneDao;
	}

	/**
	 * Sets the sicee d titolo dao.
	 *
	 * @param SiceeDIstruzioneDao the new sicee d istruzione dao
	 */
	public void setSiceeDIstruzioneDao(SiceeDIstruzioneDao siceeDIstruzioneDao) {
		this.siceeDIstruzioneDao = siceeDIstruzioneDao;
	}
	
	/** The optimized sicee t corso 2015 dao. */
	private OptimizedSiceeTCorso2015Dao optimizedSiceeTCorso2015Dao;

	/**
	 * Gets the optimized sicee t corso 2015 dao.
	 *
	 * @return the optimized sicee t corso 2015 dao
	 */
	public OptimizedSiceeTCorso2015Dao getOptimizedSiceeTCorso2015Dao() {
		return this.optimizedSiceeTCorso2015Dao;
	}

	/**
	 * Sets the optimized sicee t corso 2015 dao.
	 *
	 * @param OptimizedSiceeTCorso2015Dao the new optimized sicee t corso 2015 dao
	 */
	public void setOptimizedSiceeTCorso2015Dao(OptimizedSiceeTCorso2015Dao optimizedSiceeTCorso2015Dao) {
		this.optimizedSiceeTCorso2015Dao = optimizedSiceeTCorso2015Dao;
	}

	/** The optimized sicee t credito dao. */
	private OptimizedSiceeTCreditoDao optimizedSiceeTCreditoDao;

	/**
	 * Gets the optimized sicee t credito dao.
	 *
	 * @return the optimized sicee t credito dao
	 */
	public OptimizedSiceeTCreditoDao getOptimizedSiceeTCreditoDao() {
		return this.optimizedSiceeTCreditoDao;
	}

	/**
	 * Sets the optimized sicee t credito dao.
	 *
	 * @param OptimizedSiceeTCreditoDao the new optimized sicee t credito dao
	 */
	public void setOptimizedSiceeTCreditoDao(OptimizedSiceeTCreditoDao optimizedSiceeTCreditoDao) {
		this.optimizedSiceeTCreditoDao = optimizedSiceeTCreditoDao;
	}

	/**
	 * Gets the transazione registraz mgr.
	 *
	 * @return the transazione registraz mgr
	 */
	public TransazioneRegistrazMgr getTransazioneRegistrazMgr() {
		return this.transazioneRegistrazMgr;
	}

	/**
	 * Sets the transazione registraz mgr.
	 *
	 * @param transazioneRegistrazMgr the new transazione registraz mgr
	 */
	public void setTransazioneRegistrazMgr(
			TransazioneRegistrazMgr transazioneRegistrazMgr) {
		this.transazioneRegistrazMgr = transazioneRegistrazMgr;
	}

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
	 * Scaduta.
	 *
	 * @param dataScadenza the data scadenza
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public static boolean scaduta(String dataScadenza) throws BEException {
		if (dataScadenza != null) {
			java.util.Date now = new java.util.Date(System.currentTimeMillis());
			java.util.Date dtScad = DateUtil.convertToDate(dataScadenza);
			return dtScad.getTime() < now.getTime();
		} else {
			return false;
		}
	}

	/**
	 * Checks if is flag pagamento.
	 *
	 * @param cert the cert
	 * @return true, if is flag pagamento
	 */
	public static boolean isFlagPagamento(DatiCertificatore cert) {
		return (cert.getDtOrdine().getFlagIscritto() != null && cert
				.getDtOrdine().getFlagIscritto()
				.equalsIgnoreCase(Constants.NO));
	}
//	public static boolean isFlagPagamento(DatiCertificatore cert) {
//		return (cert.getDtOrdine().getTitolo().getFlgMdp() != null && cert
//				.getDtOrdine().getTitolo().getFlgMdp()
//				.equalsIgnoreCase(Constants.SI));
//	}
	
	/**
	 * Checks if is not registrato or near scadenza.
	 *
	 * @param cert the cert
	 * @return true, if is not registrato or near scadenza
	 */
	public static boolean isNotRegistratoOrNearScadenza(DatiCertificatore cert) {
		return (cert.getStato() != Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO);
	}

	/*
	 * public static boolean isRegistratoAttivo(DatiCertificatore cert) throws
	 * BEException{ if (cert.getRegistrato()){ String dataIscrizione =
	 * cert.getDataIscrizioneRegistrazione(); String dataScadenza =
	 * cert.getDataScadenzaRegistrazione(); if
	 * (dataIscrizione!=null&&dataIscrizione.length()>0){ return
	 * !scaduta(dataScadenza); } else return false; // questo caso non dovrebbe
	 * essere mai vero } else return false; }
	 */

	/**
	 * Load certifcatore by cf.
	 *
	 * @param cf the cf
	 * @return the dati certificatore
	 * @throws BEException the bE exception
	 */
	@Transactional
	public DatiCertificatore loadCertifcatoreByCF(String cf) throws BEException {
		DatiCertificatore result = new DatiCertificatore();
		try {
			List<SiceeTCertificatore> db_certs = this
					.getSiceeTCertificatoreDao().findWhereCodiceFiscaleEquals(
							cf);
			if (!db_certs.isEmpty()) {
				if (!(db_certs.size() > 1)) {
					// carica anche l'azienda collegata
					SiceeTCertificatore dto = db_certs.get(0);
					
					SiceeDIstruzione dtoIstruzione = null;
					SiceeDTipoIstruzione dtoTipoIstruzione = null;

					if (dto.getFkIstruzione() != null) {
						dtoIstruzione = this.getSiceeDIstruzioneDao()
								.findByPrimaryKey(dto.getFkIstruzione());
						
						if (dtoIstruzione != null)
						{
							dtoTipoIstruzione = this.getSiceeDTipoIstruzioneDao().findByPrimaryKey(dtoIstruzione.getFkTipoIstruzione());
						}
						
					}
					
					SiceeTAzienda dtoAzienda = null;
					if (!dto.isFkAziendaNull()) {
						dtoAzienda = this.getSiceeTAziendaDao()
								.findByPrimaryKey(dto.getFkAzienda());
					}
					
					
					SiceeTDatiEsami dtoEsameReg = this
							.getSiceeTDatiEsamiDao()
							.findBySiceeTCertificatore(dto.getIdCertificatore());
					
					
					if (dtoEsameReg == null)
					{
						dtoEsameReg = new SiceeTDatiEsami();
						dtoEsameReg.setFkCertificatore(dto.getIdCertificatore());

						SiceeTDatiEsamiPk pkEsame = this.getSiceeTDatiEsamiDao().insert(dtoEsameReg);
						dtoEsameReg.setIdDatiEsami(pkEsame.getIdDatiEsami());
						
					}
					
					SiceeTEsameDpr75 dtoEsameNaz = this
							.getSiceeTEsameDpr75Dao()
							.findBySiceeTCertificatore(dto.getIdCertificatore());
					
					if (dtoEsameNaz == null)
					{
						dtoEsameNaz = new SiceeTEsameDpr75();
						dtoEsameNaz.setFkCertificatore(dto.getIdCertificatore());

						SiceeTEsameDpr75Pk pkEsameDpr75 = this.getSiceeTEsameDpr75Dao().insert(dtoEsameNaz);
						dtoEsameNaz.setIdDatiEsami(pkEsameDpr75.getIdDatiEsami());
						
					}
					

					result = this.mapFromDB(dto, dtoTipoIstruzione, dtoIstruzione, dtoAzienda, dtoEsameReg, dtoEsameNaz);

				} else {
					throw new BEException("", null);
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Creates the and store new certificatore.
	 *
	 * @param cf the cf
	 * @param nome the nome
	 * @param cognome the cognome
	 * @return the dati certificatore
	 * @throws BEException the bE exception
	 */
	@Transactional
	public DatiCertificatore createAndStoreNewCertificatore(String cf,
			String nome, String cognome) throws BEException {
		DatiCertificatore cert = null;
		try {
			cert = new DatiCertificatore();
			DatiAnag dtAnag = new DatiAnag();
			DatiOrdine dtOrdine = new DatiOrdine();
			DatiResidenza dtResid = new DatiResidenza();
			DatiStudio dtStudio = new DatiStudio();
			DatiCompetenze dtComp = new DatiCompetenze();
			DatiEsame dtEsamReg = new DatiEsame();
			DatiEsame dtEsamNaz = new DatiEsame();
			Titolo titolo = new Titolo();
			dtOrdine.setTitolo(titolo);

			cert.setDtAnag(dtAnag);
			cert.setDtCompetenze(dtComp);
			cert.setDtOrdine(dtOrdine);
			cert.setDtStudio(dtStudio);
			cert.setDtResidenza(dtResid);
			// cert.setRegistrato(false);
			// cert.setPrimoAccesso(true);
			cert.setStato(Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO);
			cert.setDtEsameReg(dtEsamReg);
			cert.setDtEsameNaz(dtEsamNaz);
			cert.getDtAnag().setCodFisc(cf);
			cert.getDtAnag().setNome(nome);
			cert.getDtAnag().setCognome(cognome);

			// / prima insert azienda
			SiceeTAziendaPk pkAz = this.getSiceeTAziendaDao().insert(
					this.mapToDBAzienda(dtStudio));
			dtStudio.setIdAzienda(pkAz.getIdAzienda()); // TODO chiarire
														// politica gestioen
														// azienda

			SiceeTCertificatorePk newPK = this.getSiceeTCertificatoreDao()
					.insert(this.mapToDB(cert));
			cert.setIdCertificatore(newPK.getIdCertificatore());

			dtEsamReg.setFkCertificatore(cert.getIdCertificatore());
			SiceeTDatiEsamiPk pkEsame = this.getSiceeTDatiEsamiDao().insert(
					this.mapToDBDatiEsameReg(dtEsamReg));
			dtEsamReg.setId(pkEsame.getIdDatiEsami());
			
			dtEsamNaz.setFkCertificatore(cert.getIdCertificatore());
			SiceeTEsameDpr75Pk pkEsameNaz = this.getSiceeTEsameDpr75Dao().insert(
					this.mapToDBDatiEsameNaz(dtEsamReg));
			dtEsamNaz.setId(pkEsameNaz.getIdDatiEsami());
			

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return cert;
	}

	/**
	 * Load certifcatore by num certificatore.
	 *
	 * @param numCertificatore the num certificatore
	 * @return the dati certificatore
	 * @throws BEException the bE exception
	 */
	@Transactional
	public DatiCertificatore loadCertifcatoreByNumCertificatore(
			String numCertificatore) throws BEException {
		DatiCertificatore result = new DatiCertificatore();
		try {
			SiceeTCertificatore dto = this.getSiceeTCertificatoreDao()
					.findWhereNumCertificatoreEquals(numCertificatore);
			if (dto != null) {
				
				SiceeDIstruzione dtoIstruzione = null;
				SiceeDTipoIstruzione dtoTipoIstruzione = null;
				
				if (dto.getFkIstruzione() != null) {
					dtoIstruzione = this.getSiceeDIstruzioneDao()
							.findByPrimaryKey(dto.getFkIstruzione());
					
					if (dtoIstruzione != null)
					{
						dtoTipoIstruzione = this.getSiceeDTipoIstruzioneDao().findByPrimaryKey(dtoIstruzione.getFkTipoIstruzione());
					}
				}
				
				// carica anche l'azienda collegata
				SiceeTAzienda dtoAzienda = null;
				if (!dto.isFkAziendaNull()) {
					dtoAzienda = this.getSiceeTAziendaDao().findByPrimaryKey(
							dto.getFkAzienda());
				}
				
				SiceeTDatiEsami dtoEsameReg = this.getSiceeTDatiEsamiDao()
						.findBySiceeTCertificatore(dto.getIdCertificatore());

				SiceeTEsameDpr75 dtoEsameNaz = this
						.getSiceeTEsameDpr75Dao()
						.findBySiceeTCertificatore(dto.getIdCertificatore());
				
				result = this.mapFromDB(dto, dtoTipoIstruzione, dtoIstruzione, dtoAzienda, dtoEsameReg, dtoEsameNaz);
			} else {
				return null;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return result;
	}

	@Transactional
	public DatiCertificatore loadCertifcatoreByIdCertificatore(
			String idCertificatore) throws BEException {
		DatiCertificatore result = new DatiCertificatore();
		try {
			SiceeTCertificatore dto = this.getSiceeTCertificatoreDao()
					.findByPrimaryKey(idCertificatore);
			if (dto != null) {
				
				SiceeDIstruzione dtoIstruzione = null;
				SiceeDTipoIstruzione dtoTipoIstruzione = null;
				
				if (dto.getFkIstruzione() != null) {
					dtoIstruzione = this.getSiceeDIstruzioneDao()
							.findByPrimaryKey(dto.getFkIstruzione());
					
					if (dtoIstruzione != null)
					{
						dtoTipoIstruzione = this.getSiceeDTipoIstruzioneDao().findByPrimaryKey(dtoIstruzione.getFkTipoIstruzione());
					}
				}
				
				// carica anche l'azienda collegata
				SiceeTAzienda dtoAzienda = null;
				if (!dto.isFkAziendaNull()) {
					dtoAzienda = this.getSiceeTAziendaDao().findByPrimaryKey(
							dto.getFkAzienda());
				}
				
				SiceeTDatiEsami dtoEsameReg = this.getSiceeTDatiEsamiDao()
						.findBySiceeTCertificatore(dto.getIdCertificatore());

				SiceeTEsameDpr75 dtoEsameNaz = this
						.getSiceeTEsameDpr75Dao()
						.findBySiceeTCertificatore(dto.getIdCertificatore());
				
				result = this.mapFromDB(dto, dtoTipoIstruzione, dtoIstruzione, dtoAzienda, dtoEsameReg, dtoEsameNaz);
			} else {
				return null;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Update certificatore.
	 *
	 * @param cert the cert
	 * @throws BEException the bE exception
	 */
	public void updateCertificatore(DatiCertificatore cert) throws BEException {
		
		updateCertificatore(cert, null);
	}

	/**
	 * Update certificatore.
	 *
	 * @param cert the cert
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void updateCertificatore(DatiCertificatore cert, ArrayList<Attestato> listAttestati) throws BEException {
		SiceeTCertificatorePk pk = new SiceeTCertificatorePk(
				cert.getIdCertificatore());

		try {
			this.getSiceeTCertificatoreDao().update(pk, this.mapToDB(cert));
			SiceeTAziendaPk pkAz = new SiceeTAziendaPk(cert.getDtStudio()
					.getIdAzienda());
			this.getSiceeTAziendaDao().update(pkAz,
					this.mapToDBAzienda(cert.getDtStudio()));
			
			if (cert.getDtEsameReg().getId() != null) {
				SiceeTDatiEsamiPk pkEsameReg = new SiceeTDatiEsamiPk(cert
						.getDtEsameReg().getId());
				this.getSiceeTDatiEsamiDao().update(pkEsameReg,
						this.mapToDBDatiEsameReg(cert.getDtEsameReg()));
			} else {
				cert.getDtEsameReg().setFkCertificatore(cert.getIdCertificatore());
				SiceeTDatiEsamiPk pkEsameReg = this.getSiceeTDatiEsamiDao()
						.insert(this.mapToDBDatiEsameReg(cert.getDtEsameReg()));
				cert.getDtEsameReg().setId(pkEsameReg.getIdDatiEsami());
			}

			if (cert.getDtEsameNaz().getId() != null) {
				SiceeTEsameDpr75Pk pkEsameNaz = new SiceeTEsameDpr75Pk(cert
						.getDtEsameNaz().getId());
				this.getSiceeTEsameDpr75Dao().update(pkEsameNaz,
						this.mapToDBDatiEsameNaz(cert.getDtEsameNaz()));
			} else {
				cert.getDtEsameNaz().setFkCertificatore(cert.getIdCertificatore());
				SiceeTEsameDpr75Pk pkEsameNaz = this.getSiceeTEsameDpr75Dao()
						.insert(this.mapToDBDatiEsameNaz(cert.getDtEsameNaz()));
				cert.getDtEsameNaz().setId(pkEsameNaz.getIdDatiEsami());
			}
/*			
			if (listAttestati != null && listAttestati.size() > 0)
			{
				for (Attestato attestato : listAttestati) {
					aggiornaAttestatoInviato(cert, attestato.getUid(), attestato.getNome(), attestato.getTipo(), null);
				}
			}
*/			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Update certificatore.
	 *
	 * @param cert the cert
	 * @throws BEException the bE exception
	 */
	public void aggiornaCertificatoreEmail (String idCertificatore, String email, Date dataVerificaMail) throws BEException {
		SiceeTCertificatorePk pk = new SiceeTCertificatorePk(idCertificatore);

		try {

			SiceeTCertificatore cert = this.getSiceeTCertificatoreDao().findByPrimaryKey(pk);
			cert.setEmail(email);
			cert.setDtEmailVerifica(dataVerificaMail);
			this.getSiceeTCertificatoreDao().update(pk,cert);
			
		} catch (Exception e) {
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Update certificatore.
	 *
	 * @param cert the cert
	 * @throws BEException the bE exception
	 */
	public void aggiornaCertificatoreFlgEmail (String idCertificatore) throws BEException {
		SiceeTCertificatorePk pk = new SiceeTCertificatorePk(idCertificatore);

		try {

			SiceeTCertificatore cert = this.getSiceeTCertificatoreDao().findByPrimaryKey(pk);
			cert.setFlgAggEmail(this.convertToString(true));
			cert.setDtAggEmail(new Date());
			this.getSiceeTCertificatoreDao().update(pk,cert);
			
		} catch (Exception e) {
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Update certificatore.
	 *
	 * @param cert the cert
	 * @throws BEException the bE exception
	 */
	public void aggiornaCertificatoreFlgDati (String idCertificatore) throws BEException {
		SiceeTCertificatorePk pk = new SiceeTCertificatorePk(idCertificatore);

		try {

			SiceeTCertificatore cert = this.getSiceeTCertificatoreDao().findByPrimaryKey(pk);
			cert.setFlgAggDati(this.convertToString(true));
			cert.setDtAggDati(new Date());
			this.getSiceeTCertificatoreDao().update(pk,cert);
			
		} catch (Exception e) {
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Map to db azienda.
	 *
	 * @param dStudio the d studio
	 * @return the sicee t azienda
	 */
	public SiceeTAzienda mapToDBAzienda(DatiStudio dStudio) {
		SiceeTAzienda dto = new SiceeTAzienda();
		dto.setCap(dStudio.getCap());
		dto.setDenominazione(this.toUpperCase(dStudio.getRagSociale()));
		dto.setDescComune(dStudio.getDescrComune());
		dto.setIdComune(dStudio.getCodComune());
		dto.setIdIndirizzo(dStudio.getCodIndirizzo());
		dto.setIdProv(dStudio.getCodProv());
		dto.setIdRegione(dStudio.getCodReg());
		dto.setDescComune(dStudio.getDescrComune());
		dto.setDescIndirizzo(dStudio.getDescrIndirizzo());
		dto.setDescProv(dStudio.getDescrProv());
		dto.setDescRegione(dStudio.getDescrReg());
		dto.setNumCivico(dStudio.getNumCiv());		
		dto.setPIva(dStudio.getPartitaIVA());
		dto.setIdAzienda(dStudio.getIdAzienda());

		return dto;
	}

	/**
	 * Map from db azienda.
	 *
	 * @param dto the dto
	 * @param out the out
	 * @return the dati studio
	 */
	public DatiStudio mapFromDBAzienda(SiceeTAzienda dto, DatiStudio out) {
		DatiStudio ris = (out == null ? new DatiStudio() : out);
		ris.setCap(dto.getCap());
		ris.setCodComune(dto.getIdComune());
		ris.setCodIndirizzo(dto.getIdIndirizzo());
		ris.setCodProv(dto.getIdProv());
		ris.setCodReg(dto.getIdRegione());
		ris.setDescrComune(dto.getDescComune());
		ris.setDescrIndirizzo(dto.getDescIndirizzo());
		ris.setDescrProv(dto.getDescProv());
		ris.setDescrReg(dto.getDescRegione());
		ris.setNumCiv(dto.getNumCivico());
		ris.setPartitaIVA(dto.getPIva());
		ris.setRagSociale(dto.getDenominazione());
		ris.setIdAzienda(dto.getIdAzienda());
		return ris;
	}

	/**
	 * Map from db titolo.
	 *
	 * @param dto the dto
	 * @return the titolo
	 */
	public Titolo mapFromDBTitolo(SiceeDTitolo dto) {
		Titolo ris = new Titolo();
		ris.setId(dto.getIdTitolo());
		ris.setDescr(dto.getDescr());
		ris.setEdifici(("S".equals(dto.getFlgEdifici()) ? true : false));
		ris.setImpianti(("S".equals(dto.getFlgImpianti()) ? true : false));
		ris.setSigla(dto.getSigla());
		ris.setFlgMdp(dto.getFlgMdp());
		return ris;
	}

	/**
	 * Map to db titolo.
	 *
	 * @param tit the tit
	 * @return the sicee d titolo
	 */
	public SiceeDTitolo mapToDBTitolo(Titolo tit) {
		SiceeDTitolo dto = new SiceeDTitolo();
		dto.setDescr(tit.getDescr());
		dto.setFlgEdifici(tit.getEdifici() ? "S" : "N");
		dto.setFlgImpianti(tit.getImpianti() ? "S" : "N");
		dto.setIdTitolo(tit.getId());
		dto.setSigla(dto.getSigla());
		return dto;
	}

	/**
	 * Map from db LabelValue.
	 *
	 * @param dto the dto
	 * @return the LabelValue
	 */
	public Istruzione mapFromDBIstruzione(SiceeDTipoIstruzione dto) {
		Istruzione ris = new Istruzione();
		ris.setId(this.convertToString(dto.getIdTipoIstruzione()));
		ris.setDescr(dto.getDescr());
		
		if (log.isDebugEnabled())
			log.debug("AGGIUNGO ALLA COMBO: "+dto.getIdTipoIstruzione()+" - "+dto.getDescr());
		
		return ris;
	}
	
	/**
	 * Map from db LabelValue.
	 *
	 * @param dto the dto
	 * @return the LabelValue
	 */
	public Istruzione mapFromDBLabelValue(SiceeDIstruzione dto) {
		Istruzione ris = new Istruzione();
		ris.setId(this.convertToString(dto.getIdIstruzione()));
		ris.setCod(dto.getCodice());
		ris.setDescr(dto.getDenominazione());
		
		if (log.isDebugEnabled())
		{
			log.debug("AGGIUNGO ALLA COMBO: "+dto.getIdIstruzione()+" - "+dto.getCodice());
			log.debug("SETTO ANCHE LA DESCRIZIONE: "+dto.getDenominazione());
		}
		
		return ris;
	}
	
	
	/**
	 * Map from db dati esame.
	 *
	 * @param dto the dto
	 * @return the dati esame
	 */
	public DatiEsame mapFromDBDatiEsame(SiceeTDatiEsami dto) {
		DatiEsame ris = new DatiEsame();
		if (dto != null) {
			ris.setId(dto.getIdDatiEsami());
			ris.setCorso(dto.getCorsoFrequentato());
			ris.setFkCertificatore(dto.getFkCertificatore());
			ris.setModulo1DataDal(DateUtil.convertToUDTDateValid(dto
					.getDtModulo1Da()));
			ris.setModulo1DataAl(DateUtil.convertToUDTDateValid(dto
					.getDtModulo1A()));
			ris.setModulo2DataDal(DateUtil.convertToUDTDateValid(dto
					.getDtModulo2Da()));
			ris.setModulo2DataAl(DateUtil.convertToUDTDateValid(dto
					.getDtModulo2A()));
			ris.setAttestazionePartecipazione(dto.getAttPartecipEmesso());
			ris.setDataPartecipazione(DateUtil.convertToUDTDateValid(dto
					.getDtAttPartecip()));
			ris.setAttestazioneEsame(dto.getAttEsamePresso());
			ris.setDataEsame(DateUtil.convertToUDTDateValid(dto.getDtAttEsame()));
		}
		return ris;

	}

	/**
	 * Map to db dati esame.
	 *
	 * @param esam the esam
	 * @return the sicee t dati esami
	 * @throws BEException the bE exception
	 */
	public SiceeTDatiEsami mapToDBDatiEsameReg(DatiEsame esam) throws BEException {
		SiceeTDatiEsami dto = new SiceeTDatiEsami();
		dto.setIdDatiEsami(esam.getId());
		dto.setFkCertificatore(esam.getFkCertificatore());
		dto.setCorsoFrequentato(esam.getCorso());
		dto.setDtModulo1Da(DateUtil.convertToDate(esam.getModulo1DataDal()));
		dto.setDtModulo1A(DateUtil.convertToDate(esam.getModulo1DataAl()));
		dto.setDtModulo2Da(DateUtil.convertToDate(esam.getModulo2DataDal()));
		dto.setDtModulo2A(DateUtil.convertToDate(esam.getModulo2DataAl()));
		dto.setTotaleOre(this.convertTo(esam.getTotaleOre()));
		
		dto.setAttPartecipEmesso(esam.getAttestazionePartecipazione());
		dto.setDtAttPartecip(DateUtil.convertToDate(esam
				.getDataPartecipazione()));
		dto.setAttEsamePresso(esam.getAttestazioneEsame());
		dto.setDtAttEsame(DateUtil.convertToDate(esam.getDataEsame()));
		return dto;
	}

	/**
	 * Map to db dati esame.
	 *
	 * @param esam the esam
	 * @return the sicee t dati esami
	 * @throws BEException the bE exception
	 */
	public SiceeTEsameDpr75 mapToDBDatiEsameNaz(DatiEsame esam) throws BEException {
		SiceeTEsameDpr75 dto = new SiceeTEsameDpr75();
		dto.setIdDatiEsami(esam.getId());
		dto.setFkCertificatore(esam.getFkCertificatore());
		dto.setCorsoFrequentato(esam.getCorso());
		dto.setDtDal(DateUtil.convertToDate(esam.getModulo1DataDal()));
		dto.setDtAl(DateUtil.convertToDate(esam.getModulo1DataAl()));
		dto.setTotaleOre(this.convertTo(esam.getTotaleOre()));

		
		dto.setEsamePresso(esam.getAttestazionePartecipazione());
		dto.setDtAttestato(DateUtil.convertToDate(esam.getDataPartecipazione()));

		dto.setAttestatoPresso(esam.getAttestazioneEsame());
		dto.setDtEsame(DateUtil.convertToDate(esam
				.getDataEsame()));
		
		
		return dto;
	}
	
	/**
	 * Map to db.
	 *
	 * @param cert the cert
	 * @return the sicee t certificatore
	 * @throws BEException the bE exception
	 */
	public SiceeTCertificatore mapToDB(DatiCertificatore cert)
			throws BEException {
		SiceeTCertificatore dto = new SiceeTCertificatore();

		if (!GenericUtil.isNullOrEmpty(cert.getIdBlocco()))
		{
			dto.setFkBloccoCertificatore(cert.getIdBlocco());
		}
//		if (cert.getStato() >= Constants.STATO_CERTIFICATORE_RADIATO) {
//			// se è uno stato da 4 in su è un blocco e lo riporto nel dto per salvarlo
//			dto.setFkStatoCertificatore(cert.getStato());
//		}

		dto.setCap(cert.getDtResidenza().getCap());

		dto.setCodiceFiscale(cert.getDtAnag().getCodFisc());
		dto.setCognome(this.toUpperCase(cert.getDtAnag().getCognome()));
		dto.setDataIscrAlbo(DateUtil.convertToDate(cert.getDtOrdine()
				.getDataIscrizione()));
		dto.setDescComuneNascita(cert.getDtAnag().getDescrComuneNasc());
		dto.setDescComuneResidenza(cert.getDtResidenza().getDescrComune());
		dto.setDescIndirizzo(cert.getDtResidenza().getDescrIndirizzo());
		dto.setDescProvNascita(cert.getDtAnag().getDescrProvNasc());
		dto.setDescProvOrdine(cert.getDtOrdine().getDescrProv());
		dto.setDescProvResidenza(cert.getDtResidenza().getDescrProv());
		dto.setDescRegioneNascita(cert.getDtAnag().getDescrRegNasc());
		dto.setDescRegioneResidenza(cert.getDtResidenza().getDescrReg());
		// dto.setDtIscrElenco(convertToDate(cert.getDtOrdine().getDataIscrizione()));
		dto.setDtNascita(DateUtil.convertToDate(cert.getDtAnag()
				.getDataNascita()));
		dto.setDtScadenzaElenco(DateUtil.convertToDate(cert
				.getDataScadenzaRegistrazione()));
		dto.setDtIscrElenco(DateUtil.convertToDate(cert
				.getDataIscrizioneRegistrazione()));

		// certificatore residente all’estero.
		dto.setStatoResEstero(cert.getDtResidenza().getStatoResEstero());
		dto.setCittaEstera(cert.getDtResidenza().getCittaEstera());
		dto.setViaEstera(cert.getDtResidenza().getViaEstera());
		dto.setCivicoEstero(cert.getDtResidenza().getCivicoEstero());
		dto.setCapEstero(cert.getDtResidenza().getCapEstero());
		dto.setFlgResidenzaItalia(cert.getDtResidenza().getFlgResidenzaItalia());

		dto.setCell(cert.getDtResidenza().getCell());
		dto.setEmail(cert.getDtResidenza().getEmail());

		cert.setEMailErrata(this.checkEmailDaScartare(cert.getDtResidenza()
				.getEmail()));

//		boolean ace = this.getTransazioneAceMgr().isTransazioniAnomale(cert);
//		boolean registr = this.getTransazioneRegistrazMgr()
//				.isTransazioniAnomale(cert);
//		cert.setTransazioneAnomale((ace || registr));

		dto.setTelefono(cert.getDtResidenza().getTel());
		dto.setEmailPec(cert.getDtResidenza().getEmailPec());

		dto.setFlgConsensoCell(this.convertToString(cert.getDtResidenza()
				.getFlgAutorCell()));
		dto.setFlgConsensoEmail(this.convertToString(cert.getDtResidenza()
				.getFlgAutorEmail()));
		dto.setFlgConsensoTel(this.convertToString(cert.getDtResidenza()
				.getFlgAutorTel()));
		dto.setFlgNewsletter(this.convertToString(cert.getDtResidenza()
				.getFlgNewsletter()));

		dto.setFax(cert.getDtResidenza().getFax());
		dto.setSitoWeb(cert.getDtResidenza().getSitoWeb());

		if (cert.getDtEsameNaz() != null || cert.getDtEsameReg() == null)
		{
			dto.setCompetenzeNazionali(this.convertToString(true));
		}
		else
		{
			dto.setCompetenzeNazionali(this.convertToString(false));
		}
		
//		if (cert.getDtEsameReg() != null) {
//			dto.setFlgEsameSostenuto(cert.getDtEsameReg()().getFlagSostenuto());
//		}
		
		dto.setFlgAggEmail(this.convertToString(cert.getFlgAggEmail()));
		dto.setFlgAggDati(this.convertToString(cert.getFlgAggDati()));

		dto.setDtAggEmail(DateUtil.convertToDate(cert.getDataAggEmail()));
		dto.setDtAggDati(DateUtil.convertToDate(cert.getDataAggDati()));

		dto.setFlgEdifici(cert.getDtCompetenze().getEdifici());

		
		dto.setFlgImpianti(cert.getDtCompetenze().getImpianti());
		if (cert.getStato() == Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO
				|| cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO) {
			dto.setFlgPagamento(Constants.NO);
		} else {
			dto.setFlgPagamento(Constants.SI);
		}
		dto.setFlgVerificato(null); // TODO manca il dato nel bean
		dto.setIdComuneNascita(cert.getDtAnag().getCodComuneNasc());
		dto.setIdComuneResidenza(cert.getDtResidenza().getCodComune());
		dto.setIdIndirizzo(cert.getDtResidenza().getCodIndirizzo());
		dto.setIdProvNascita(cert.getDtAnag().getCodProvNasc());
		dto.setIdProvOrdine(cert.getDtOrdine().getCodProv());
		dto.setIdProvResidenza(cert.getDtResidenza().getCodProv());
		dto.setIdRegioneNascita(cert.getDtAnag().getCodRegNasc());
		dto.setIdRegioneResidenza(cert.getDtResidenza().getCodReg());
		dto.setNome(this.toUpperCase(cert.getDtAnag().getNome()));
		dto.setNote(null); // TODO missing?
		dto.setNumCertificatore(cert.getNumCertificatore());
		dto.setIdCertificatore(cert.getIdCertificatore());
		dto.setNumCivicoResidenza(cert.getDtResidenza().getNumCiv());
		dto.setOrdine(cert.getDtOrdine().getAlbo());
		
		dto.setNumIscrAlbo(cert.getDtOrdine().getNumIscrizione());
		dto.setNumTotAceNull(true); // TODO MISSING or misplaced

		if (log.isDebugEnabled())
			GenericUtil.stampa(cert.getDtOrdine(), true, 2);

		dto.setIscrittoOrdine(cert.getDtOrdine().getFlagIscritto());
		dto.setFkIstruzione(this.convertToInteger(cert.getDtOrdine().getCodiceIstruzione()));
		
		
		dto.setSettore(cert.getDtOrdine().getSettore());
		dto.setSezione(cert.getDtOrdine().getSezione());
		
		if (cert.getDtOrdine().getPresaVisione() != null && cert.getDtOrdine().getPresaVisione())
		{
			dto.setAccettazioneTecnico(Constants.SI);
		} else {
			dto.setAccettazioneTecnico(Constants.NO);
		}
		
		
		dto.setStatoEstero(cert.getDtAnag().getStatoEstero());

		if (cert.getDtStudio() == null) {
			dto.setFkAziendaNull(true);
		} else {
			dto.setFkAziendaNull(false);
			dto.setFkAzienda(cert.getDtStudio().getIdAzienda());
		}

		/*
		if (!BaseMgr.isNullOrEmpty(cert.getDtOrdine().getTitolo().getId())) {
			dto.setFkTitolo(cert.getDtOrdine().getTitolo().getId());
			try {
				cert.getDtOrdine()
						.getTitolo()
						.setDescr(
								this.getSiceeDTitoloDao()
										.findByPrimaryKey(
												cert.getDtOrdine().getTitolo()
														.getId()).getDescr());
			} catch (SiceeDTitoloDaoException e) {
				throw new BEException(e.getMessage(), e);
			}
		}
		*/

		return dto;
	}

	/**
	 * Map from db.
	 *
	 * @param dto il dto dell'oggetto certificatore
	 * @param dtoAzienda il dto (opzionale) della azienda associata
	 * @param dtoEsame the dto esame
	 * @return the dati certificatore
	 * @throws BEException the bE exception
	 */
	public DatiCertificatore mapFromDB(SiceeTCertificatore dto, SiceeDTipoIstruzione dtoTipoIstruzione, SiceeDIstruzione dtoIstruzione,
			SiceeTAzienda dtoAzienda, SiceeTDatiEsami dtoEsameReg, SiceeTEsameDpr75 dtoEsameNaz)
			throws BEException {
		DatiCertificatore cert = new DatiCertificatore();
		DatiAnag dAnag = new DatiAnag();
		DatiCompetenze dComp = new DatiCompetenze();
		DatiOrdine dOrd = new DatiOrdine();
		DatiResidenza dResid = new DatiResidenza();
		DatiStudio dStudio = new DatiStudio();
		//DatiEsame dEsame = new DatiEsame();
		DatiEsame dEsameReg = new DatiEsame();
		DatiEsame dEsameNaz = new DatiEsame();
		
		cert.setDtAnag(dAnag);
		cert.setDtCompetenze(dComp);
		cert.setDtOrdine(dOrd);
		cert.setDtResidenza(dResid);
		cert.setDtStudio(dStudio);
		cert.setDtEsameReg(dEsameReg);
		cert.setDtEsameNaz(dEsameNaz);

		cert.getDtResidenza().setCap(dto.getCap());

		cert.getDtAnag().setCodFisc(dto.getCodiceFiscale());
		cert.getDtAnag().setCognome(dto.getCognome());
//		cert.getDtOrdine().setDataIscrizione(
//				DateUtil.convertToUDTDateValid(dto.getDataIscrAlbo()));
		cert.getDtAnag().setDescrComuneNasc(dto.getDescComuneNascita());
		cert.getDtResidenza().setDescrComune(dto.getDescComuneResidenza());
		cert.getDtResidenza().setDescrIndirizzo(dto.getDescIndirizzo());
		cert.getDtAnag().setDescrProvNasc(dto.getDescProvNascita());
		cert.getDtOrdine().setDescrProv(dto.getDescProvOrdine());
		cert.getDtResidenza().setDescrProv(dto.getDescProvResidenza());
		cert.getDtAnag().setDescrRegNasc(dto.getDescRegioneNascita());
		cert.getDtResidenza().setDescrReg(dto.getDescRegioneResidenza());
		cert.getDtOrdine().setDataIscrizione(
				DateUtil.convertToUDTDateValid(dto.getDataIscrAlbo()));
		cert.getDtAnag().setDataNascita(
				DateUtil.convertToUDTDateValid(dto.getDtNascita()));
		
		cert.getDtOrdine().setAlbo(dto.getOrdine());
		
		cert.setDataScadenzaRegistrazione(DateUtil.convertToString(dto
				.getDtScadenzaElenco()));
		cert.setDataIscrizioneRegistrazione(DateUtil.convertToString(dto
				.getDtIscrElenco()));

		// certificatore residente all’estero.  
		cert.getDtResidenza().setStatoResEstero(dto.getStatoResEstero());
		cert.getDtResidenza().setCittaEstera(dto.getCittaEstera());
		cert.getDtResidenza().setViaEstera(dto.getViaEstera());
		cert.getDtResidenza().setCivicoEstero(dto.getCivicoEstero());
		cert.getDtResidenza().setCapEstero(dto.getCapEstero());
		cert.getDtResidenza().setFlgResidenzaItalia(dto.getFlgResidenzaItalia());

		cert.getDtResidenza().setCell(dto.getCell());
		cert.getDtResidenza().setEmail(dto.getEmail());

		cert.setEMailErrata(this.checkEmailDaScartare(cert.getDtResidenza()
				.getEmail()));

		cert.getDtResidenza().setTel(dto.getTelefono());
		cert.getDtResidenza().setEmailPec(dto.getEmailPec());

		cert.getDtResidenza().setFlgAutorCell(
				BaseMgr.convertToBoolean(dto.getFlgConsensoCell()));
		cert.getDtResidenza().setFlgAutorEmail(
				BaseMgr.convertToBoolean(dto.getFlgConsensoEmail()));
		cert.getDtResidenza().setFlgAutorTel(
				BaseMgr.convertToBoolean(dto.getFlgConsensoTel()));
		cert.getDtResidenza().setFlgNewsletter(
				BaseMgr.convertToBoolean(dto.getFlgNewsletter()));

		cert.getDtResidenza().setFax(dto.getFax());
		cert.getDtResidenza().setSitoWeb(dto.getSitoWeb());
		cert.getDtCompetenze().setEdifici(dto.getFlgEdifici());
		cert.getDtCompetenze().setImpianti(dto.getFlgImpianti());

		
		cert.setFlgAggEmail(BaseMgr.convertToBoolean(dto.getFlgAggEmail()));
		cert.setFlgAggDati(BaseMgr.convertToBoolean(dto.getFlgAggDati()));
		
		cert.setDataAggEmail(DateUtil.convertToString(dto.getDtAggEmail()));
		cert.setDataAggDati(DateUtil.convertToString(dto.getDtAggDati()));
		cert.setDataEmailVerifica(DateUtil.convertToStringDataCompleta(dto.getDtEmailVerifica()));


		if (BaseMgr.isNullOrEmpty(cert.getDataScadenzaRegistrazione())) {
			cert.setStato(Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO);
		} else if (this.checkDataScadenzaRegistrazioneAfterSysdate(cert
				.getDataScadenzaRegistrazione())
				&& Constants.SI.equals(dto.getFlgPagamento())) {
			// cert.setRegistrato(true);
			cert.setStato(Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO);
			if (DateUtil
					.diffDate(DateUtil.convertToString(new Date(System
							.currentTimeMillis())), cert
							.getDataScadenzaRegistrazione())) {
				cert.setStato(Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA);
			}
		} else {
			// cert.setRegistrato(false);
			cert.setStato(Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO);
		}

		if (!BaseMgr.isNullOrEmpty(dto.getFkBloccoCertificatore())) {
			cert.setIdBlocco(dto.getFkBloccoCertificatore());
			
			String descErrore = null;;

			switch (cert.getIdBlocco()) {
				case Constants.ID_BLOCCO_CERTIFICATORE_RADIATO:  descErrore = Messages.ERROR_BLOCCO_CERTIFICATORE_RADIATO;
					break;
				case Constants.ID_BLOCCO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO:  descErrore = Messages.ERROR_BLOCCO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO;
					break;
				case Constants.ID_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI:  descErrore = Messages.ERROR_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI;
					break;
				case Constants.ID_BLOCCO_CERTIFICATORE_ASSENZA_CORSO:  descErrore = Messages.ERROR_BLOCCO_CERTIFICATORE_ASSENZA_CORSO;
					break;
				case Constants.ID_BLOCCO_CERTIFICATORE_MANCANZA_INFORMAZIONI:  descErrore = Messages.ERROR_BLOCCO_CERTIFICATORE_MANCANZA_INFORMAZIONI;
					break;
				case Constants.ID_BLOCCO_CERTIFICATORE_MANCANZA_GENERICA:  descErrore = Messages.ERROR_BLOCCO_CERTIFICATORE_MANCANZA_GENERICA;
					break;
			//            case Constants.ID_BLOCCO_CERTIFICATORE_DECEDUTO:  descErrore = Messages.ERROR_BLOCCO_CERTIFICATORE_RADIATO;
			//            break; // Non è previsto nessun messaggio x il decesso

			}
			cert.setDescBlocco(descErrore);
                  
		}

		
		// cert.setNearScadenza(diffDate(convertToString(new
		// Date(System.currentTimeMillis())),
		// convertToString(dto.getDtScadenzaElenco())));

		cert.getDtAnag().setCodComuneNasc(dto.getIdComuneNascita());
		cert.getDtResidenza().setCodComune(dto.getIdComuneResidenza());
		cert.getDtResidenza().setCodIndirizzo(dto.getIdIndirizzo());
		cert.getDtAnag().setCodProvNasc(dto.getIdProvNascita());
		cert.getDtOrdine().setCodProv(dto.getIdProvOrdine());
		cert.getDtResidenza().setCodProv(dto.getIdProvResidenza());
		cert.getDtAnag().setCodRegNasc(dto.getIdRegioneNascita());
		cert.getDtResidenza().setCodReg(dto.getIdRegioneResidenza());
		cert.getDtAnag().setNome(dto.getNome());
		// dto.setNote(null); // TODO missing?
		cert.setNumCertificatore(dto.getNumCertificatore());
		cert.setIdCertificatore(dto.getIdCertificatore());
		cert.getDtResidenza().setNumCiv(dto.getNumCivicoResidenza());
		cert.getDtOrdine().setNumIscrizione(dto.getNumIscrAlbo());
		cert.getDtAnag().setStatoEstero(dto.getStatoEstero());
		
		
//		if (dto.getFkTitolo() != null && dto.getFkTitolo().length() > 0) {
//			cert.getDtOrdine().setTitolo(this.getTitoloById(dto.getFkTitolo()));
//		} else {
//			cert.getDtOrdine().setTitolo(new Titolo());
//		}
		
		cert.getDtOrdine().setFlagIscritto(dto.getIscrittoOrdine());
		
		if (dtoIstruzione != null)
		{
			cert.getDtOrdine().setTipoIstruzione(this.convertToString(dtoIstruzione.getFkTipoIstruzione()));
			cert.getDtOrdine().setCodiceIstruzione(this.convertToString(dtoIstruzione.getIdIstruzione()));
			cert.getDtOrdine().setTitoloIstruzione(dtoIstruzione.getDenominazione());
			
			if (dtoTipoIstruzione != null)
			{
				cert.getDtOrdine().setDescTipoIstruzione(dtoTipoIstruzione.getDescr());
			}
			
			cert.getDtOrdine().setDescCodTitoloIstruzione(dtoIstruzione.getCodice() + " - " +dtoIstruzione.getDenominazione());
		}
		
		cert.getDtOrdine().setSettore(dto.getSettore());
		cert.getDtOrdine().setSezione(dto.getSezione());
		cert.getDtOrdine().setPresaVisione(this.convertToBoolean(dto.getAccettazioneTecnico()));
		
		
//		boolean ace = this.getTransazioneAceMgr().isTransazioniAnomale(cert);
//		boolean registr = this.getTransazioneRegistrazMgr()
//				.isTransazioniAnomale(cert);
//		cert.setTransazioneAnomale((ace || registr));

		// / FK's
		if (dtoAzienda != null) {
			cert.getDtStudio().setCap(dtoAzienda.getCap());
			cert.getDtStudio().setCodComune(dtoAzienda.getIdComune());
			cert.getDtStudio().setCodIndirizzo(dtoAzienda.getIdIndirizzo());
			cert.getDtStudio().setCodProv(dtoAzienda.getIdProv());
			cert.getDtStudio().setCodReg(dtoAzienda.getIdRegione());
			cert.getDtStudio().setDescrComune(dtoAzienda.getDescComune());
			cert.getDtStudio().setDescrIndirizzo(dtoAzienda.getDescIndirizzo());
			cert.getDtStudio().setDescrProv(dtoAzienda.getDescProv());
			cert.getDtStudio().setDescrReg(dtoAzienda.getDescRegione());
			cert.getDtStudio().setNumCiv(dtoAzienda.getNumCivico());
			cert.getDtStudio().setPartitaIVA(dtoAzienda.getPIva());
			cert.getDtStudio().setRagSociale(dtoAzienda.getDenominazione());
			cert.getDtStudio().setIdAzienda(dtoAzienda.getIdAzienda());
		}

		if (dtoEsameReg != null) {
			cert.getDtEsameReg().setId(dtoEsameReg.getIdDatiEsami());
			cert.getDtEsameReg().setCorso(dtoEsameReg.getCorsoFrequentato());
			cert.getDtEsameReg().setFkCertificatore(dtoEsameReg.getFkCertificatore());
			cert.getDtEsameReg().setModulo1DataDal(
					DateUtil.convertToUDTDateValid(dtoEsameReg.getDtModulo1Da()));
			cert.getDtEsameReg().setModulo1DataAl(
					DateUtil.convertToUDTDateValid(dtoEsameReg.getDtModulo1A()));
			cert.getDtEsameReg().setModulo2DataDal(
					DateUtil.convertToUDTDateValid(dtoEsameReg.getDtModulo2Da()));
			cert.getDtEsameReg().setModulo2DataAl(
					DateUtil.convertToUDTDateValid(dtoEsameReg.getDtModulo2A()));
			cert.getDtEsameReg().setAttestazionePartecipazione(
					dtoEsameReg.getAttPartecipEmesso());
			cert.getDtEsameReg()
					.setDataPartecipazione(
							DateUtil.convertToUDTDateValid(dtoEsameReg
									.getDtAttPartecip()));
			cert.getDtEsameReg()
					.setAttestazioneEsame(dtoEsameReg.getAttEsamePresso());
			cert.getDtEsameReg().setTotaleOre(
					this.convertTo(dtoEsameReg.getTotaleOre()));
			cert.getDtEsameReg().setDataEsame(
					DateUtil.convertToUDTDateValid(dtoEsameReg.getDtAttEsame()));
			
//			if (!BaseMgr.isNullOrEmpty(cert.getDtEsameReg().getDataEsame())) {
//				cert.getDtEsameReg().setFlagSostenuto(Constants.SI);
//			} else {
//				cert.getDtEsameReg().setFlagSostenuto(Constants.NO);
//			}
			
		}

		if (dtoEsameNaz != null) {
			cert.getDtEsameNaz().setId(dtoEsameNaz.getIdDatiEsami());
			cert.getDtEsameNaz().setCorso(dtoEsameNaz.getCorsoFrequentato());
			cert.getDtEsameNaz().setFkCertificatore(dtoEsameNaz.getFkCertificatore());
			cert.getDtEsameNaz().setModulo1DataDal(
					DateUtil.convertToUDTDateValid(dtoEsameNaz.getDtDal()));
			cert.getDtEsameNaz().setModulo1DataAl(
					DateUtil.convertToUDTDateValid(dtoEsameNaz.getDtAl()));

			cert.getDtEsameNaz().setAttestazionePartecipazione(
					dtoEsameNaz.getEsamePresso());
			
			cert.getDtEsameNaz()
					.setDataPartecipazione(
							DateUtil.convertToUDTDateValid(dtoEsameNaz
									.getDtAttestato()));
			cert.getDtEsameNaz()
					.setAttestazioneEsame(dtoEsameNaz.getEsamePresso());
			cert.getDtEsameNaz().setTotaleOre(
					this.convertTo(dtoEsameNaz.getTotaleOre()));
			cert.getDtEsameNaz().setDataEsame(
					DateUtil.convertToUDTDateValid(dtoEsameNaz.getDtEsame()));
			
			
//			if (!BaseMgr.isNullOrEmpty(cert.getDtEsameNaz().getDataEsame())) {
//				cert.getDtEsameNaz().setFlagSostenuto(Constants.SI);
//			} else {
//				cert.getDtEsameNaz().setFlagSostenuto(Constants.NO);
//			}
			
			
			
		}
		
		
		if (dtoEsameReg != null || dtoEsameNaz != null)
		{
			if (dtoEsameNaz != null)
			{
				cert.setFlgCompetenzeNaz(true);
			}
			else
			{
				cert.setFlgCompetenzeNaz(false);
			}
		}
		else
		{
			// Nel caso in cui sia iscritto ad un ordine
			cert.setFlgCompetenzeNaz(true);
		}
		
		return cert;
	}

	/**
	 * Gets the all titoli.
	 *
	 * @return the all titoli
	 * @throws BEException the bE exception
	 */
	public ArrayList<Titolo> getAllTitoli() throws BEException {
		ArrayList<Titolo> titoli = new ArrayList<Titolo>();
		try {
			List<SiceeDTitolo> temp = this.getSiceeDTitoloDao().findAll();
			Iterator<SiceeDTitolo> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDTitolo siceeDTitolo = it.next();
				Titolo curr = this.mapFromDBTitolo(siceeDTitolo);
				titoli.add(curr);
			}
			return titoli;
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Gets the titolo by id.
	 *
	 * @param id the id
	 * @return the titolo by id
	 * @throws BEException the bE exception
	 */
	public Titolo getTitoloById(String id) throws BEException {
		try {
			SiceeDTitolo temp = this.getSiceeDTitoloDao().findByPrimaryKey(id);
			if (temp != null) {
				return this.mapFromDBTitolo(temp);
			} else {
				return null;
			}
		} catch (SiceeDTitoloDaoException e) {
			throw new BEException("Errore nella lettura del titolo " + id, e);
		}
	}

	/**
	 * Gets the all tipo istruzione.
	 *
	 * @return the all tipo istruzione
	 * @throws BEException the bE exception
	 */
	public ArrayList<Istruzione> getAllTipoIstruzione() throws BEException {
		ArrayList<Istruzione> tipoIstruzione = new ArrayList<Istruzione>();
		try {
			List<SiceeDTipoIstruzione> temp = this.getSiceeDTipoIstruzioneDao().findAll();
			Iterator<SiceeDTipoIstruzione> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDTipoIstruzione siceeDTipoIstruzione = it.next();
				Istruzione curr = this.mapFromDBIstruzione(siceeDTipoIstruzione);
				tipoIstruzione.add(curr);
			}
			return tipoIstruzione;
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Gets the all istruzione.
	 *
	 * @return the all istruzione
	 * @throws BEException the bE exception
	 */
	public ArrayList<Istruzione> getIstruzioneByIdTipoIstruzione(Integer idTipoIstruzione, boolean isIscritto) throws BEException {
		ArrayList<Istruzione> istruzione = new ArrayList<Istruzione>();
		try {
			List<SiceeDIstruzione> temp = null;
			if (isIscritto)
			{
				log.debug("isIscritto: "+isIscritto);
				temp = this.getSiceeDIstruzioneDao().findWhereFkTipoIstruzioneEqualsAndSiglaOrdineIsNotNull(idTipoIstruzione);
			}
			else
			{
				log.debug("isIscritto: "+isIscritto);

				temp = this.getSiceeDIstruzioneDao().findWhereFkTipoIstruzioneEquals(idTipoIstruzione);
			}
			
			Iterator<SiceeDIstruzione> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDIstruzione siceeDIstruzione = it.next();
				Istruzione curr = this.mapFromDBLabelValue(siceeDIstruzione);
				istruzione.add(curr);
			}
			return istruzione;
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Gets the all istruzione.
	 *
	 * @return the all istruzione
	 * @throws BEException the bE exception
	 */
	public SiceeDIstruzione getIstruzioneByIdIstruzione(Integer idIstruzione) throws BEException {
		try {
			SiceeDIstruzione temp = null;
			log.debug("idIstruzione: "+idIstruzione);
			temp = this.getSiceeDIstruzioneDao().findByPrimaryKey(idIstruzione);
			
			return temp;
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	/**
	 * Gets the tipo istruzione by id.
	 *
	 * @param id the id
	 * @return the tipo istruzione by id
	 * @throws BEException the bE exception
	 */
	public String getDescTipoIstruzioneById(Integer id) throws BEException {
		try {
			SiceeDTipoIstruzione temp = this.getSiceeDTipoIstruzioneDao().findByPrimaryKey(id);
			if (temp != null) {
				return temp.getDescr();
			} else {
				return null;
			}
		} catch (SiceeDTipoIstruzioneDaoException e) {
			throw new BEException("Errore nella lettura del tipo istruzione " + id, e);
		}
	}
	
	/**
	 * Gets the istruzione by id.
	 *
	 * @param id the id
	 * @return the istruzione by id
	 * @throws BEException the bE exception
	 */
	public String getDescIstruzioneById(Integer id) throws BEException {
		try {
			SiceeDIstruzione temp = this.getSiceeDIstruzioneDao().findByPrimaryKey(id);
			if (temp != null) {
				return temp.getCodice() + " - " +temp.getDenominazione() ;
			} else {
				return null;
			}
		} catch (SiceeDIstruzioneDaoException e) {
			throw new BEException("Errore nella lettura del istruzione " + id, e);
		}
	}
	
	/**
	 * Calcola numero matricola.
	 *
	 * @param cert the cert
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String calcolaNumeroMatricola(DatiCertificatore cert)
			throws BEException {
		
		String prog = "00000".substring(0, (5 - cert.getIdCertificatore()
				.length()))
				+ cert.getIdCertificatore();
		
		Integer idIstruzione = convertToInteger(cert.getDtOrdine().getCodiceIstruzione());
		SiceeDIstruzione istruzione = this.getIstruzioneByIdIstruzione(idIstruzione);
		String sigla = null;
		if (cert.getDtOrdine().getFlagIscritto().equalsIgnoreCase(Constants.SI))
		{
			sigla = istruzione.getSiglaOrdine();
		}
		else
		{
			sigla = istruzione.getSiglaNonOrdine();
		}
		
		return sigla + prog;
	}

//	public String calcolaNumeroMatricola(DatiCertificatore cert)
//			throws BEException {
//		String prog = "00000".substring(0, (5 - cert.getIdCertificatore()
//				.length()))
//				+ cert.getIdCertificatore();
//		String sigla = this.getTitoloById(
//				cert.getDtOrdine().getTitolo().getId()).getSigla();
//		return sigla + prog;
//	}


	/**
	 * Completa registrazione.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @return the long
	 * @throws BEException the bE exception
	 */
	public Long completaRegistrazione(Long idTransazione, DatiCertificatore cert)
			throws BEException {
		String dataIscr = null;
		if (cert.getStato() == Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO
				|| cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO) {
			dataIscr = DateUtil.convertToString(new java.util.Date(System
					.currentTimeMillis()));
		} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA) {
			dataIscr = DateUtil.addOneDay(cert.getDataScadenzaRegistrazione());
		}
		cert.setDataIscrizioneRegistrazione(dataIscr);
		if (BaseMgr.isNullOrEmpty(cert.getDataScadenzaRegistrazione())) {
			cert.setNumCertificatore(this.calcolaNumeroMatricola(cert));
		}
		cert.setDataScadenzaRegistrazione(DateUtil.addOneYear(dataIscr));

		cert.setStato(Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO);
		// cert.setPrimoAccesso(false);
		this.updateCertificatore(cert);
		Long idTrans = this.getTransazioneRegistrazMgr().chiudiTransazione(idTransazione);

		/*
		 * if (cert.getNearScadenza()) { cert.setNearScadenza(false); }
		 */

		return idTrans;
	}

	@Transactional
	public void completaRegistrazioneNew(DatiCertificatore cert, GestioneCreditoNew gestCredito)
			throws BEException 
	{
		try
		{
			String dataIscr = null;

			if (cert.getStato() == Constants.STATO_CERTIFICATORE_NUOVO_ISCRITTO
					|| cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_SCADUTO) {
				dataIscr = DateUtil.convertToString(new java.util.Date(System
						.currentTimeMillis()));
			} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA) {
				dataIscr = DateUtil.addOneDay(cert.getDataScadenzaRegistrazione());
			}

			cert.setDataIscrizioneRegistrazione(dataIscr);

			if (BaseMgr.isNullOrEmpty(cert.getDataScadenzaRegistrazione())) {
				cert.setNumCertificatore(this.calcolaNumeroMatricola(cert));
			}

			cert.setDataScadenzaRegistrazione(DateUtil.addOneYear(dataIscr));

			cert.setStato(Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO);
			// cert.setPrimoAccesso(false);

			this.updateCertificatore(cert);

			Date date = new Date(System.currentTimeMillis());

			Double importoRegistrazione = -gestCredito.getImportoRegistrazione().doubleValue();

			Double creditoIniziale = gestCredito.getCreditoDisponibile().doubleValue();

			Double creditoFinale = creditoIniziale+importoRegistrazione;

			this.getSiceeTCredito2018Dao().insert(this.mapToDBCredito2018(cert.getIdCertificatore(), date, importoRegistrazione, creditoIniziale, creditoFinale));
		}
		catch (Exception e)
		{
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();

			throw new BEException(e.getMessage(), e);

		}
		//Long idTrans = this.getTransazioneRegistrazMgr().chiudiTransazione(idTransazione);

	}
	
	/**
	 * Check data scadenza registrazione after sysdate.
	 *
	 * @param date the date
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public boolean checkDataScadenzaRegistrazioneAfterSysdate(String date)
			throws BEException {
		// TODO da verificare NON FUNZIONA
		if (!BaseMgr.isNullOrEmpty(date)) {
			if (date.equals(DateUtil.convertToString(new Date(System
					.currentTimeMillis())))) {
				return true;
			}

			return DateUtil.convertToDate(date).after(
					new Date(System.currentTimeMillis()));
		} else {
			return true;
		}
	}

	/**
	 * Check email da scartare.
	 *
	 * @param eMail the e mail
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public boolean checkEmailDaScartare(String eMail) throws BEException {
		// se l'email del cert si trova nella tavola SiceeWEmailNewsletter non
		// e' valida
		try {
			if (this.getSiceeWEmailNewsletterDao().findWhereEmailEquals(eMail) != null) {
				return true;
			} else {
				return false;
			}
		} catch (SiceeWEmailNewsletterDaoException e) {
			log.error(e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Check email verificata
	 *
	 * @param cf the cf
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public boolean checkEmailVerificata(String cf) throws BEException {
		boolean isCorrect = false;
		try {
			List<SiceeTCertificatore> db_certs = this
					.getSiceeTCertificatoreDao().findWhereCodiceFiscaleEquals(
							cf);
			if (!db_certs.isEmpty()) {
				if (!(db_certs.size() > 1)) {
					
					if (db_certs.get(0).getFlgAggEmail() != null)
					{
						isCorrect = db_certs.get(0).getFlgAggEmail().equalsIgnoreCase(Constants.SI);
					}
					
					return isCorrect;
					
				} else {
					throw new BEException("", null);
				}
			} else {
				return isCorrect;
			}
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Check dati registrazione verificati
	 *
	 * @param cf the cf
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public boolean checkDatiRegVerificati(String cf) throws BEException {
		boolean isCorrect = false;
		try {
			List<SiceeTCertificatore> db_certs = this
					.getSiceeTCertificatoreDao().findWhereCodiceFiscaleEquals(
							cf);
			if (!db_certs.isEmpty()) {
				if (!(db_certs.size() > 1)) {
					
					if (db_certs.get(0).getFlgAggDati() != null)
					{
						isCorrect = db_certs.get(0).getFlgAggDati().equalsIgnoreCase(Constants.SI);
					}
					
					return isCorrect;
					
				} else {
					throw new BEException("", null);
				}
			} else {
				return isCorrect;
			}
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Aggiorna curriculum inviato.
	 *
	 * @param cert the cert
	 * @param uid the uid
	 * @param name the name
	 * @throws BEException the bE exception
	 */
	public void aggiornaCurriculumInviato(SiceeTDocumento doc, Integer idDoc, String uid,
			String name, String idCertificatore) throws BEException {

		try {
			
//			SiceeTDocumento doc = this.getSiceeTDocumentoDao()
//					.findWhereIdCertificatoreAndIdTipoDocEquals(
//							cert.getIdCertificatore(), TIPO_CURRICULUM_VITAE);
			
			if (doc != null) {
				// Devo cancellare da Index il vecchio DOC
				String uidOld = doc.getIdentificDoc();

				doc.setIdentificDoc(uid);
				doc.setDtUpload(new Date(System.currentTimeMillis()));
				doc.setNomeFile(name);
				this.getSiceeTDocumentoDao().update(doc.createPk(), doc);
				
				// cancello il file vecchio su INDEX, se non riesco non e' grave
				eliminaFileIndexByUid(uidOld);
				
			} else {
				doc = new SiceeTDocumento();
				doc.setIdDocumento(idDoc);
				doc.setIdCertificatore(idCertificatore);
				doc.setNomeFile(name);
				doc.setDtUpload(new Date(System.currentTimeMillis()));
				doc.setIdentificDoc(uid);
				doc.setIdTipoDoc(TIPO_CURRICULUM_VITAE);
				this.getSiceeTDocumentoDao().insert(doc);
			}

		} catch (Exception e) {
			log.error("Errore", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Aggiorna titolo di studio inviato.
	 *
	 * @param cert the cert
	 * @param uid the uid
	 * @param name the name
	 * @throws BEException the bE exception
	 */
	public void aggiornaTitoloDiStudioInviato(SiceeTDocumento doc, Integer idDoc, String uid,
			String name, String idCertificatore) throws BEException {

		try {
//			SiceeTDocumento doc = this.getSiceeTDocumentoDao()
//					.findWhereIdCertificatoreAndIdTipoDocEquals(
//							cert.getIdCertificatore(), TITOLO_DI_STUDIO);
			if (doc != null) {
				// Devo cancellare da Index il vecchio DOC
				String uidOld = doc.getIdentificDoc();

				doc.setIdentificDoc(uid);
				doc.setDtUpload(new Date(System.currentTimeMillis()));
				doc.setNomeFile(name);
				this.getSiceeTDocumentoDao().update(doc.createPk(), doc);
				
				// cancello il file vecchio su INDEX, se non riesco non e' grave
				eliminaFileIndexByUid(uidOld);

			} else {
				doc = new SiceeTDocumento();
				doc.setIdDocumento(idDoc);
				doc.setIdCertificatore(idCertificatore);
				doc.setNomeFile(name);
				doc.setDtUpload(new Date(System.currentTimeMillis()));
				doc.setIdentificDoc(uid);
				doc.setIdTipoDoc(TITOLO_DI_STUDIO);
				this.getSiceeTDocumentoDao().insert(doc);
			}

		} catch (Exception e) {
			log.error("Errore", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Aggiorna attestato inviato.
	 *
	 * @param cert the cert
	 * @param uid the uid
	 * @param name the name
	 * @throws BEException the bE exception
	 */
	public void aggiornaAttestatoInviato(SiceeTDocumento doc, Integer idDoc, String uid,
			String name, Integer idTipoDocumento, Integer fkCorso, String idCertificatore) throws BEException {

		try {
//			SiceeTDocumento doc = this.getSiceeTDocumentoDao()
//					.findWhereIdCertificatoreAndFkCorsoEquals(
//							cert.getIdCertificatore(), fkCorso);

			if (doc != null) {
				// Devo cancellare da Index il vecchio DOC
				String uidOld = doc.getIdentificDoc();

				doc.setNomeFile(name);
				doc.setIdentificDoc(uid);
				doc.setDtUpload(new Date(System.currentTimeMillis()));
				this.getSiceeTDocumentoDao().update(doc.createPk(), doc);
				
				// cancello il file vecchio su INDEX, se non riesco non e' grave
				eliminaFileIndexByUid(uidOld);

			} else {
				doc = new SiceeTDocumento();
				doc.setIdDocumento(idDoc);
				doc.setIdCertificatore(idCertificatore);
				doc.setNomeFile(name);
				doc.setDtUpload(new Date(System.currentTimeMillis()));
				doc.setIdentificDoc(uid);
				doc.setIdTipoDoc(idTipoDocumento);
				doc.setFkCorso(fkCorso);
				this.getSiceeTDocumentoDao().insert(doc);
			}

		} catch (Exception e) {
			
			log.error("Errore", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Gets the curriculum.
	 *
	 * @param cert the cert
	 * @return the curriculum
	 * @throws BEException the bE exception
	 */
	public ArrayList<CurriculumSummary> getCurriculum(DatiCertificatore cert)
			throws BEException {
		ArrayList<CurriculumSummary> ret = new ArrayList<CurriculumSummary>();
		try {
			SiceeTDocumento doc = this.getSiceeTDocumentoDao()
					.findWhereIdCertificatoreAndIdTipoDocEquals(
							cert.getIdCertificatore(), TIPO_CURRICULUM_VITAE);
			if (doc != null) {
				ret.add(this.mapToCurriculumSummary(doc));
			}
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the curriculum.
	 *
	 * @param cert the cert
	 * @return the curriculum
	 * @throws BEException the bE exception
	 */
	public ArrayList<DocumentSummary> getDocumento(DatiCertificatore cert, Integer idTipoDocumento)
			throws BEException {
		ArrayList<DocumentSummary> ret = new ArrayList<DocumentSummary>();
		try {
			SiceeTDocumento doc = this.getSiceeTDocumentoDao()
					.findWhereIdCertificatoreAndIdTipoDocEquals(
							cert.getIdCertificatore(), idTipoDocumento);
			
			SiceeDTipoDocumento tipoDoc = this.getSiceeDTipoDocumentoDao().findByPrimaryKey(idTipoDocumento);
			
			if (doc != null) {
				ret.add(this.mapToDocumentSummary(doc, tipoDoc));
			}
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeDTipoDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		if (log.isDebugEnabled())
			log.debug("STAMPO LA LISTA DOCUMENTI TROVATI: "+ret);
		
		return ret;
	}
	
	public ArrayList<DocumentSummary> getDocumentiTitoloDiStudio(DatiCertificatore cert)
			throws BEException {
		ArrayList<DocumentSummary> ret = new ArrayList<DocumentSummary>();
		try {
			ArrayList<SiceeTDocumento> docList = (ArrayList<SiceeTDocumento>) this.getSiceeTDocumentoDao()
					.findTitoloDiStudio(cert.getIdCertificatore());
			
			for (SiceeTDocumento doc : docList) {
				SiceeDTipoDocumento tipoDoc = this.getSiceeDTipoDocumentoDao().findByPrimaryKey(doc.getIdTipoDoc());
				ret.add(this.mapToDocumentSummary(doc, tipoDoc));
			}
			
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeDTipoDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		if (log.isDebugEnabled())
			log.debug("\nSTAMPO LA LISTA TITOLI DI STUDIO TROVATI (DOVREBBE ESSERE SEMPRE E SOLO UNO): "+ret);
		
		return ret;
	}

	public ArrayList<DocumentSummary> getDocumentiPartecipazioneOld(DatiCertificatore cert)
			throws BEException {
		ArrayList<DocumentSummary> ret = new ArrayList<DocumentSummary>();
		try {
			ArrayList<SiceeTDocumento> docList = (ArrayList<SiceeTDocumento>) this.getSiceeTDocumentoDao()
					.findAttPartOld(cert.getIdCertificatore());
			
			for (SiceeTDocumento doc : docList) {
				SiceeDTipoDocumento tipoDoc = this.getSiceeDTipoDocumentoDao().findByPrimaryKey(doc.getIdTipoDoc());
				ret.add(this.mapToDocumentSummary(doc, tipoDoc));
			}
			
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeDTipoDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		if (log.isDebugEnabled())
			log.debug("\nSTAMPO LA LISTA DOCUMENTI TROVATI (OLD): "+ret);
		
		return ret;
	}
	
	public ArrayList<CorsoAttestatoSummary> getDocumentiPartecipazioneNew(DatiCertificatore cert)
			throws BEException {
		ArrayList<CorsoAttestatoSummary> ret = new ArrayList<CorsoAttestatoSummary>();
		try {
			log.debug("\ngetDocumentiPartecipazioneNew :: CF CERTIFICATORE : "+ cert.getDtAnag().getCodFisc());
			ArrayList<OptimizedSiceeTCorso2015> docList = (ArrayList<OptimizedSiceeTCorso2015>) this.getOptimizedSiceeTCorso2015Dao()
					.executeByCodiceFiscale(cert.getDtAnag().getCodFisc());
			for (OptimizedSiceeTCorso2015 doc : docList) {
				ret.add(this.mapToCorsoAttestatoSummary(doc));
			}
		} catch (OptimizedSiceeTCorso2015DaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		if (log.isDebugEnabled())
			log.debug("\nSTAMPO LA LISTA CORSI/DOCUMENTI TROVATI (NEW): "+ ret);
		
		return ret;
	}
	
	public Float getValoreCreditoFinale(String fkCertificatore)
			throws BEException {
		
		OptimizedSiceeTCredito credito = null;
		try {
			credito = this.getOptimizedSiceeTCreditoDao()
					.executeByFkCertificatore(fkCertificatore);
		} catch (OptimizedSiceeTCreditoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		if (credito != null)
			return credito.getValoreCreditoFinale();
		else
			return new Float(0);
	}
	
	/**
	 * Map to curriculum summary.
	 *
	 * @param doc the doc
	 * @return the curriculum summary
	 */
	private CurriculumSummary mapToCurriculumSummary(SiceeTDocumento doc) {
		CurriculumSummary cv = new CurriculumSummary();
		cv.setCod("1");
		cv.setTipo("CURRICULUM VITAE");
		cv.setNome(doc.getNomeFile());
		cv.setFlgScarico("Scarica");
		cv.setUid(doc.getIdentificDoc());
		cv.setDataUpload(DateUtil.convertToString(doc.getDtUpload()));
		return cv;
	}

	/**
	 * Map to curriculum summary.
	 *
	 * @param doc the doc
	 * @return the curriculum summary
	 */
	private DocumentSummary mapToDocumentSummary(SiceeTDocumento doc, SiceeDTipoDocumento tipoDoc) {
		DocumentSummary cv = new DocumentSummary();
		cv.setCod(convertToString(tipoDoc.getIdTipoDoc()));
		cv.setTipo(tipoDoc.getDsTipoDoc());
		cv.setNome(doc.getNomeFile());
		cv.setFlgScarico("Scarica");
		cv.setUid(doc.getIdentificDoc());
		cv.setDataUpload(DateUtil.convertToString(doc.getDtUpload()));
		return cv;
	}
	
	private CorsoAttestatoSummary mapToCorsoAttestatoSummary(OptimizedSiceeTCorso2015 doc) {
		CorsoAttestatoSummary cas = new CorsoAttestatoSummary();
		cas.setIdCorso(Converter.convertToString(doc.getIdCorso()));
		cas.setTitolo(doc.getTitolo());
		cas.setDenominazione(doc.getDenominazione());
		cas.setTotaleOre(Converter.convertToString(doc.getTotaleOre()));
		cas.setDataEsame(DateUtil.convertToString(doc.getDataEsame()));
		cas.setEsitoEsame(doc.getEsitoEsame());
		cas.setIdentificDoc(doc.getIdentificDoc());
		cas.setFlgScarico("");
		return cas;
	}
	
	/**
	 * Gets the id certificatore from num certificatore.
	 *
	 * @param numCertificatore the num certificatore
	 * @return the id certificatore from num certificatore
	 * @throws BEException the bE exception
	 */
	public String getIdCertificatoreFromNumCertificatore(String numCertificatore)
			throws BEException {
		String idCertificatore = null;
		try {
			SiceeTCertificatore cert = this.getSiceeTCertificatoreDao()
					.findWhereNumCertificatoreEquals(numCertificatore);
			if (cert != null) {
				idCertificatore = cert.getIdCertificatore();
			}
		} catch (SiceeTCertificatoreDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return idCertificatore;
	}

	private SiceeTCredito2018 mapToDBCredito2018(String idCertificatore, Date dataInserimento, Double prezzoApe, Double creditoIniziale, Double creditoFinale) throws BEException
	{
		SiceeTCredito2018 dto = new SiceeTCredito2018();
		
		dto.setFkCertificatore(idCertificatore);
		
		dto.setFkTipoOp2018(Constants.ID_TIPO_OP_ISCRIZIONE_ANN);
		
		dto.setValoreCreditoIniziale(creditoIniziale);
		
		dto.setValoreCreditoFinale(creditoFinale);
		
		dto.setDataOperazione(dataInserimento);
		
		dto.setValoreOperazione(prezzoApe);
		
		return dto;
	}
		
	/**
	 * Gets the id documento.
	 *
	 */
	public int getIdDocumento() throws BEException {
		try {
			return this.getSiceeTDocumentoDao().createIdDocumento();
		} catch (Exception e) {
			throw new BEException("Errore nella creazione dell'ID", e);
		}
	}
	
		public void eliminaFileIndexByUid(String uidFile) throws BEException {
			try {
				// Eliminazione documento da index
				//getSoaIntegrationMgr().eliminaFileDaIndex(uidFile);
			} catch (Exception e) {

				log.error("[CertificatoreMgr - eliminaFileIndexByUid] Eccezione, in questo caso ignoro l'eccezione su INDEX per l'uid "+uidFile);
				
			}
		}
}
