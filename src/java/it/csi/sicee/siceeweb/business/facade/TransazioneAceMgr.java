/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneAceDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeWPrezziDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneAce;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneAcePk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistraz;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezzi;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazioneAceDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazioneRegistrazDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWPrezziDaoException;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamento;
import it.csi.sicee.siceeweb.dto.pagamenti.Transazione;
import it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce;
import it.csi.sicee.siceeweb.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class TransazioneAceMgr.
 */
public class TransazioneAceMgr extends BaseMgr {

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
		SiceeTTransazioneAcePk pk = null;
		try {
			SiceeTTransazioneAce obj = this.mapToDB(dp, cert);
			pk = this.getSiceeTTransazioneAceDao().insert(obj);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return pk.getIdTransazioneAce();
	}

	/**
	 * cercaStato transazione.
	 *
	 * @param dp the dp
	 * @throws BEException the bE exception
	 */
	public int cercaStatoTransazione(String numTransazione) throws BEException {
		int idStatoTrans = 0;
		try {
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(numTransazione);
			
			if (mdp != null)
			{
				idStatoTrans = mdp.getCodStato().intValue();
			}
			
			return idStatoTrans;
		} catch (Exception e) {
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Annulla transazione.
	 *
	 * @param dp the dp
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void annullaTransazione(Long idTransazione) throws BEException {
		SiceeTTransazioneAce trans;
		try {
			trans = this.getSiceeTTransazioneAceDao().findByPrimaryKey(idTransazione);
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(trans.getNumTransazione());
			trans.setFlgVerificato(BaseMgr.convertToString(mdp.getCodStato()));
			this.getSiceeTTransazioneAceDao().update(trans.createPk(), trans);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}

	/**
	 * Abortisci transazione.
	 *
	 * @param idTransazione the idTransazione
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void abortisciTransazione(Long idTransazione) throws BEException {
		SiceeTTransazioneAce trans;
		try {
			trans = this.getSiceeTTransazioneAceDao().findByPrimaryKey(idTransazione);
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(trans.getNumTransazione());
			trans.setFlgVerificato(BaseMgr.convertToString(mdp.getCodStato()));
			this.getSiceeTTransazioneAceDao().update(trans.createPk(), trans);
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
	public Long chiudiTransazione(Long idTransazione) throws BEException {
		SiceeTTransazioneAce trans;
		try {
			trans = this.getSiceeTTransazioneAceDao().findByPrimaryKey(
					idTransazione);
			
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(trans.getNumTransazione());
			
			trans.setFlgVerificato(BaseMgr.convertToString(mdp.getCodStato()));
			this.getSiceeTTransazioneAceDao().update(trans.createPk(), trans);
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return trans.getIdTransazioneAce();

	}

	/**
	 * Aggiorna transazione.
	 *
	 * @param dp the dp
	 * @return the long
	 * @throws BEException the bE exception
	 */
//	@Transactional
//	public Long aggiornaTransazione(DatiPagamento dp) throws BEException {
//		SiceeTTransazioneAce trans;
//		try {
//			trans = this.getSiceeTTransazioneAceDao().findByPrimaryKey(
//					dp.getIdTransazione());
//			Transazione mdp = this.getSoaIntegrationMgr()
//					.verificaTransazionePagamento(trans.getNumTransazione());
//			trans.setFlgVerificato(BaseMgr.convertToString(mdp.getCodStato()));
//			this.getSiceeTTransazioneAceDao().update(trans.createPk(), trans);
//		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus()
//					.setRollbackOnly();
//			log.error("Erroe", e);
//			throw new BEException(e.getMessage(), e);
//		}
//		return trans.getIdTransazioneAce();
//
//	}

	/** The sicee t transazione ace dao. */
	private SiceeTTransazioneAceDao siceeTTransazioneAceDao;

	/** The sicee w prezzi dao. */
	private SiceeWPrezziDao siceeWPrezziDao;
	
	/**
	 * Gets the sicee t transazione ace dao.
	 *
	 * @return the sicee t transazione ace dao
	 */
	public SiceeTTransazioneAceDao getSiceeTTransazioneAceDao() {
		return this.siceeTTransazioneAceDao;
	}

	/**
	 * Sets the sicee t transazione ace dao.
	 *
	 * @param siceeTTransazioneAceDao the new sicee t transazione ace dao
	 */
	public void setSiceeTTransazioneAceDao(
			SiceeTTransazioneAceDao siceeTTransazioneAceDao) {
		this.siceeTTransazioneAceDao = siceeTTransazioneAceDao;
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
	 * Map to db.
	 *
	 * @param dp the dp
	 * @param cert the cert
	 * @return the sicee t transazione ace
	 * @throws BEException the bE exception
	 */
	public SiceeTTransazioneAce mapToDB(DatiPagamento dp, DatiCertificatore cert)
			throws BEException {
		SiceeTTransazioneAce dto = new SiceeTTransazioneAce();

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

		dto.setAnno(DateUtil.getAnnoFromUDTDateValid(dp.getDataValuta()));
		dto.setFkCertificatore(cert.getIdCertificatore());
		dto.setQuantita(dp.getQuantita());

		dto.setFkTipoPagamento(modPagamento);

		return dto;
	}

	/**
	 * Gets the transazioni.
	 *
	 * @param cert the cert
	 * @return the transazioni
	 * @throws BEException the bE exception
	 */
	public ArrayList<TransazioneAce> getTransazioni(DatiCertificatore cert)
			throws BEException {
		SiceeTTransazioneAce dto = new SiceeTTransazioneAce();
		ArrayList<TransazioneAce> ret = new ArrayList<TransazioneAce>();
		try {
			List<SiceeTTransazioneAce> list = this.getSiceeTTransazioneAceDao()
					.findBySiceeTCertificatoreAndFlgVerificatoEquals(
							cert.getIdCertificatore(), "4", "E");
			Iterator<SiceeTTransazioneAce> iter = list.iterator();

			while (iter.hasNext()) {
				ret.add(this.mapToTransazioneAce(iter.next()));
			}

		} catch (SiceeTTransazioneAceDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return ret;
	}

	/**
	 * Map to transazione ace.
	 *
	 * @param next the next
	 * @return the transazione ace
	 */
	private TransazioneAce mapToTransazioneAce(SiceeTTransazioneAce next) {
		TransazioneAce t = new TransazioneAce();

		t.setIdTransazione(next.getIdTransazioneAce());
		t.setNumeroTransazione(next.getNumTransazione());
		t.setDataTransazione(DateUtil.convertToString(next.getDataTransazione()));
		t.setQuantita(this.convertToString(next.getQuantita()));
		t.setTipoTransazione(this.convertToString(next.getFkTipoPagamento()));
		t.setStato(next.getFlgVerificato());

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
			SiceeTTransazioneAce obj = this.getSiceeTTransazioneAceDao()
					.findByPrimaryKey(idTransazione);
			data = obj.getDataTransazione();

		} catch (SiceeTTransazioneAceDaoException e) {
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
					.getSiceeWPrezziDao().findWhereDescrizioneValidaAllaDataEquals("ACE", dataRegistrazione);
			valore = obj.getValuta();

		} catch (SiceeWPrezziDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return valore;
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
			SiceeTTransazioneAce obj = this.getSiceeTTransazioneAceDao()
					.findByPrimaryKey(idTransazione);
			ret = this.mapToTransazioneAce(obj);

		} catch (SiceeTTransazioneAceDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the transazione.
	 *
	 * @param idTransazione the id transazione
	 * @return the transazione
	 * @throws BEException the bE exception
	 */
	public it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce getTransazioneAce(
			Long idTransazione) throws BEException {

		it.csi.sicee.siceeweb.dto.transazioni.TransazioneAce ret = null;
		try {
			SiceeTTransazioneAce obj = this.getSiceeTTransazioneAceDao()
					.findByPrimaryKey(idTransazione);
			ret = this.mapToTransazioneAce(obj);

		} catch (SiceeTTransazioneAceDaoException e) {
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
			List<SiceeTTransazioneAce> list = this
					.getSiceeTTransazioneAceDao().findWhereNumTransazioneEquals(numTransazione);
			
			
			if (list != null && list.size() > 0)
			{
				// Non dovrebbe mai succedere che mi ritorni più di un risultato, comunque prendo il primo
				ret = this.mapToTransazioneAce(list.get(0));
			}

		} catch (SiceeTTransazioneAceDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Sets the stato transazione.
	 *
	 * @param idTransazione the id transazione
	 * @return the it.csi.sicee.siceeweb.dto.transazioni. transazione
	 * @throws BEException the bE exception
	 */
	public it.csi.sicee.siceeweb.dto.transazioni.Transazione setStatoTransazione(
			Long idTransazione) throws BEException {

		it.csi.sicee.siceeweb.dto.transazioni.Transazione ret = null;
		try {
			SiceeTTransazioneAce obj = this.getSiceeTTransazioneAceDao()
					.findByPrimaryKey(idTransazione);
			ret = this.mapToTransazioneAce(obj);

		} catch (SiceeTTransazioneAceDaoException e) {
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
	public Long aggiornaStatoTransazione(Long idTransazione, Long stato) throws BEException {
		SiceeTTransazioneAce trans;
		//Long stato = 0L;
		try {
			
			trans = this.getSiceeTTransazioneAceDao().findByPrimaryKey(
					idTransazione);
			
//			Transazione mdp = this.getSoaIntegrationMgr()
//					.verificaTransazionePagamento(trans.getNumTransazione());
//			
//			stato = mdp.getCodStato();
			
			trans.setFlgVerificato(BaseMgr.convertToString(stato));
			this.getSiceeTTransazioneAceDao().update(trans.createPk(), trans);

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
		SiceeTTransazioneAce trans;

		try {
			trans = this.getSiceeTTransazioneAceDao().findByPrimaryKey(
					idTransazione);
			trans.setFlgVerificato(stato);
			this.getSiceeTTransazioneAceDao().update(trans.createPk(), trans);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus()
//					.setRollbackOnly();
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}

	}

	/**
	 * Aggiorna stato transazione.
	 *
	 * @param idTransazione the id transazione
	 * @return the long
	 * @throws BEException the bE exception
	 */
	public Long recuperaStatoTransazioneMDP(String numTransazione) throws BEException {
		//SiceeTTransazioneAce trans;
		Long stato = 0L;
		try {
			
			Transazione mdp = this.getSoaIntegrationMgr()
					.verificaTransazionePagamento(numTransazione);
			stato = mdp.getCodStato();
			
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		return stato;

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
	 * Gets the transazioni anomale.
	 *
	 * @param cert the cert
	 * @return the transazioni anomale
	 * @throws BEException the bE exception
	 */
	public ArrayList<TransazioneAce> getTransazioniAnomale(
			DatiCertificatore cert) throws BEException {
		SiceeTTransazioneAce dto = new SiceeTTransazioneAce();
		ArrayList<TransazioneAce> ret = new ArrayList<TransazioneAce>();
		try {
			List<SiceeTTransazioneAce> list = this.getSiceeTTransazioneAceDao()
					.findBySiceeTCertificatoreAndFlgVerificatoEquals(
							cert.getIdCertificatore(), "3", "S");
			Iterator<SiceeTTransazioneAce> iter = list.iterator();

			while (iter.hasNext()) {
				ret.add(this.mapToTransazioneAce(iter.next()));
			}

		} catch (SiceeTTransazioneAceDaoException e) {
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
			List<SiceeTTransazioneAce> list = this.getSiceeTTransazioneAceDao()
					.findBySiceeTCertificatoreAndFlgVerificatoEquals(
							cert.getIdCertificatore(), "3", "S");
			ret = list.size() == 0 ? false : true;

		} catch (SiceeTTransazioneAceDaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		}

		return ret;
	}

}
