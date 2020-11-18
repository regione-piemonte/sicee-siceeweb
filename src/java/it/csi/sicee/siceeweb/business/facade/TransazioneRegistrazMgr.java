/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneRegistrazDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeWPrezziDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistraz;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistrazPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezzi;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazioneRegistrazDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWPrezziDaoException;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento;
import it.csi.sicee.siceeweb.dto.pagamenti.Transazione;
import it.csi.sicee.siceeweb.dto.transazioni.TransazioneRegistrazione;
import it.csi.sicee.siceeweb.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class TransazioneRegistrazMgr.
 */
public class TransazioneRegistrazMgr extends BaseMgr {

	/** The sicee t transazione registraz dao. */
	private SiceeTTransazioneRegistrazDao siceeTTransazioneRegistrazDao;

	/** The sicee w prezzi dao. */
	private SiceeWPrezziDao siceeWPrezziDao;

	/**
	 * Gets the sicee t transazione registraz dao.
	 *
	 * @return the sicee t transazione registraz dao
	 */
	public SiceeTTransazioneRegistrazDao getSiceeTTransazioneRegistrazDao() {
		return this.siceeTTransazioneRegistrazDao;
	}

	/**
	 * Sets the sicee t transazione registraz dao.
	 *
	 * @param siceeTTransazioneRegistrazDao the new sicee t transazione registraz dao
	 */
	public void setSiceeTTransazioneRegistrazDao(
			SiceeTTransazioneRegistrazDao siceeTTransazioneRegistrazDao) {
		this.siceeTTransazioneRegistrazDao = siceeTTransazioneRegistrazDao;
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
	 * @param siceeWPrezziDao the new sicee w prezzi dao
	 */
	public void setSiceeWPrezziDao(
			SiceeWPrezziDao siceeWPrezziDao) {
		this.siceeWPrezziDao = siceeWPrezziDao;
	}
	
	/**
	 * Inizia transazione.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @return the long
	 * @throws BEException the bE exception
	 */
	@Transactional
	public Long iniziaTransazione(DatiPagamento dp, DatiCertificatore cert)
			throws BEException {
		SiceeTTransazioneRegistrazPk pk = null;
		try {
			SiceeTTransazioneRegistraz obj = this.mapToDB(dp, cert);
			pk = this.getSiceeTTransazioneRegistrazDao().insert(obj);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return pk.getIdTransazioneReg();
	}

	/**
	 * Abortisci transazione.
	 *
	 * @param idTransazione the idTransazione
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void abortisciTransazione(Long idTransazione) throws BEException {

		SiceeTTransazioneRegistraz trans;
		try {
			trans = this.getSiceeTTransazioneRegistrazDao().findByPrimaryKey(idTransazione);
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(trans.getNumTransazione());
			trans.setFlgVerificato(BaseMgr.convertToString(mdp.getCodStato()));
			this.getSiceeTTransazioneRegistrazDao().update(trans.createPk(),
					trans);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Annulla transazione.
	 *
	 * @param idTransazione the idTransazione
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void annullaTransazione(Long idTransazione) throws BEException {
		SiceeTTransazioneRegistraz trans;
		try {
			trans = this.getSiceeTTransazioneRegistrazDao().findByPrimaryKey(idTransazione);
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(trans.getNumTransazione());
			trans.setFlgVerificato(BaseMgr.convertToString(mdp.getCodStato()));
			this.getSiceeTTransazioneRegistrazDao().update(trans.createPk(),
					trans);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Chiudi transazione.
	 *
	 * @param idTransazione the idTransazione
	 * @return the long
	 * @throws BEException the bE exception
	 */
	@Transactional
	public Long chiudiTransazione(Long idTransazione) throws BEException {
		SiceeTTransazioneRegistraz trans;
		try {
			trans = this.getSiceeTTransazioneRegistrazDao().findByPrimaryKey(
					idTransazione);
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(trans.getNumTransazione());
			trans.setFlgVerificato(BaseMgr.convertToString(mdp.getCodStato()));
			this.getSiceeTTransazioneRegistrazDao().update(trans.createPk(),
					trans);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return trans.getIdTransazioneReg();
	}

	/**
	 * Map to db.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @return the sicee t transazione registraz
	 * @throws BEException the bE exception
	 */
	public SiceeTTransazioneRegistraz mapToDB(DatiPagamento dp,
			DatiCertificatore cert) throws BEException {
		SiceeTTransazioneRegistraz dto = new SiceeTTransazioneRegistraz();

		dto.setDataTransazione(DateUtil.convertToTimestamp(""
				+ System.currentTimeMillis()));
		dto.setEseguitoCognome(dp.getEseguitoDaCognome());
		dto.setEseguitoNome(dp.getEseguitoDaNome());
		Integer modPagamento = null;
		if (dp.getModPagamento().equals("CC")) {
			modPagamento = new Integer(1);
			dto.setNumTransazione(dp.getIdTransazioneMDP());
		} else {
			modPagamento = new Integer(2);
			dto.setNumTransazione(dp.getCro());
		}
		dto.setFlgVerificato(dp.getStatoTransazione());

		dto.setFkTipoPagamento(modPagamento);
		dto.setFkCertificatore(cert.getIdCertificatore());
		dto.setAnno(DateUtil.getAnnoFromUDTDateValid(dp.getDataValuta()));
		dto.setQuantita(dp.getQuantita());
		return dto;
	}

	/**
	 * Gets the transazioni.
	 *
	 * @param cert the cert
	 * @return the transazioni
	 * @throws BEException the bE exception
	 */
	public ArrayList<TransazioneRegistrazione> getTransazioni(
			DatiCertificatore cert) throws BEException {
		SiceeTTransazioneRegistraz dto = new SiceeTTransazioneRegistraz();
		ArrayList<TransazioneRegistrazione> ret = new ArrayList<TransazioneRegistrazione>();
		try {
			List<SiceeTTransazioneRegistraz> list = this
					.getSiceeTTransazioneRegistrazDao()
					.findBySiceeTCertificatoreAndFlgVerificatoEquals(
							cert.getIdCertificatore(), "4", "E");
			Iterator<SiceeTTransazioneRegistraz> iter = list.iterator();

			while (iter.hasNext()) {
				ret.add(this.mapToTransazioneRegistraz(iter.next()));
			}

		} catch (SiceeTTransazioneRegistrazDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return ret;
	}

	/**
	 * Map to transazione registraz.
	 *
	 * @param next the next
	 * @return the transazione registrazione
	 */
	private TransazioneRegistrazione mapToTransazioneRegistraz(
			SiceeTTransazioneRegistraz next) {
		TransazioneRegistrazione t = new TransazioneRegistrazione();

		t.setIdTransazione(next.getIdTransazioneReg());
		t.setNumeroTransazione(next.getNumTransazione());
		t.setDataTransazione(DateUtil.convertToString(next.getDataTransazione()));
		t.setTipoTransazione(this.convertToString(next.getFkTipoPagamento()));
		t.setStato(next.getFlgVerificato());
		t.setIdCertificatore(next.getFkCertificatore());

		return t;
	}

	/**
	 * Gets the data transazione.
	 *
	 * @param idTransazione the id transazione
	 * @return the data transazione
	 * @throws BEException the bE exception
	 */
	public Date getDataTransazione(long idTransazione) throws BEException {
		Date data = null;
		try {
			SiceeTTransazioneRegistraz obj = this
					.getSiceeTTransazioneRegistrazDao().findByPrimaryKey(
							idTransazione);
			data = obj.getDataTransazione();

		} catch (SiceeTTransazioneRegistrazDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return data;
	}

	/**
	 * Gets the data transazione.
	 *
	 * @param idTransazione the id transazione
	 * @return the data transazione
	 * @throws BEException the bE exception
	 */
	public Double getPrezzoRegistrazioneByData(Date dataRegistrazione) throws BEException {
		Double valore = null;
		try {
			SiceeWPrezzi obj = this
					.getSiceeWPrezziDao().findWhereDescrizioneValidaAllaDataEquals("REGISTRAZIONE", dataRegistrazione);
			valore = obj.getValuta();

		} catch (SiceeWPrezziDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return valore;
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

	/**
	 * Gets the transazione.
	 *
	 * @param idTransazione the id transazione
	 * @return the transazione
	 * @throws BEException the bE exception
	 */
	public it.csi.sicee.siceeweb.dto.transazioni.Transazione getTransazione(
			Long idTransazione) throws BEException {

		it.csi.sicee.siceeweb.dto.transazioni.Transazione ret = null;
		try {
			SiceeTTransazioneRegistraz obj = this
					.getSiceeTTransazioneRegistrazDao().findByPrimaryKey(
							idTransazione);
			ret = this.mapToTransazioneRegistraz(obj);

		} catch (SiceeTTransazioneRegistrazDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the transazione.
	 *
	 * @param numTransazione the num transazione
	 * @return the transazione
	 * @throws BEException the bE exception
	 */
	public it.csi.sicee.siceeweb.dto.transazioni.Transazione getTransazioneByNumTransazione(
			String numTransazione) throws BEException {

		it.csi.sicee.siceeweb.dto.transazioni.Transazione ret = null;
		try {
			List<SiceeTTransazioneRegistraz> list = this
					.getSiceeTTransazioneRegistrazDao().findWhereNumTransazioneEquals(numTransazione);
			
			
			if (list != null && list.size() > 0)
			{
				// Non dovrebbe mai succedere che mi ritorni più di un risultato, comunque prendo il primo
				ret = this.mapToTransazioneRegistraz(list.get(0));
			}

		} catch (SiceeTTransazioneRegistrazDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Aggiorna stato transazione.
	 *
	 * @param idTransazione the id transazione
	 * @return the long
	 * @throws BEException the bE exception
	 */
	public Long aggiornaStatoTransazione(Long idTransazione) throws BEException {
		SiceeTTransazioneRegistraz trans;
		Long stato = 0L;
		try {
			trans = this.getSiceeTTransazioneRegistrazDao().findByPrimaryKey(
					idTransazione);
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(trans.getNumTransazione());
			stato = mdp.getCodStato();
			trans.setFlgVerificato(BaseMgr.convertToString(stato));
			this.getSiceeTTransazioneRegistrazDao().update(trans.createPk(),
					trans);

		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus()
//					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return stato;

	}

	/**
	 * Aggiorna stato transazione.
	 *
	 * @param idTransazione the id transazione
	 * @param stato the stato
	 * @throws BEException the bE exception
	 */
	public void aggiornaStatoTransazione(Long idTransazione, String stato)
			throws BEException {
		SiceeTTransazioneRegistraz trans;
		try {
			trans = this.getSiceeTTransazioneRegistrazDao().findByPrimaryKey(
					idTransazione);
			trans.setFlgVerificato(stato);
			this.getSiceeTTransazioneRegistrazDao().update(trans.createPk(),
					trans);

		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus()
//					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Gets the transazioni anomale.
	 *
	 * @param cert the cert
	 * @return the transazioni anomale
	 * @throws BEException the bE exception
	 */
	public ArrayList<TransazioneRegistrazione> getTransazioniAnomale(
			DatiCertificatore cert) throws BEException {
		SiceeTTransazioneRegistraz dto = new SiceeTTransazioneRegistraz();
		ArrayList<TransazioneRegistrazione> ret = new ArrayList<TransazioneRegistrazione>();
		try {
			List<SiceeTTransazioneRegistraz> list = this
					.getSiceeTTransazioneRegistrazDao()
					.findBySiceeTCertificatoreAndFlgVerificatoEquals(
							cert.getIdCertificatore(), "3", "S");
			Iterator<SiceeTTransazioneRegistraz> iter = list.iterator();

			while (iter.hasNext()) {
				ret.add(this.mapToTransazioneRegistraz(iter.next()));
			}

		} catch (SiceeTTransazioneRegistrazDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return ret;
	}

	/**
	 * Checks if is transazioni anomale.
	 *
	 * @param cert the cert
	 * @return true, if is transazioni anomale
	 * @throws BEException the bE exception
	 */
	public boolean isTransazioniAnomale(DatiCertificatore cert)
			throws BEException {
		boolean ret = false;
		try {
			List<SiceeTTransazioneRegistraz> list = this
					.getSiceeTTransazioneRegistrazDao()
					.findBySiceeTCertificatoreAndFlgVerificatoEquals(
							cert.getIdCertificatore(), "3", "S");
			ret = list.size() == 0 ? false : true;

		} catch (SiceeTTransazioneRegistrazDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return ret;
	}
}
