/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCredito2018Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoTrans2018Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoTransMdp2018Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCredito2018Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazione2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTrans2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTransMdp2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCredito2018DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoTrans2018DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoTransMdp2018DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCredito2018DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazione2018DaoException;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.dto.commons.LabelValueCombo;
import it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew;
import it.csi.sicee.siceeweb.dto.pagamenti.InformativaSceltaNew;
import it.csi.sicee.siceeweb.dto.transazioni.TransazioneCredito;
import it.csi.sicee.siceeweb.util.Converter;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.GenericUtil;
import it.csi.sicee.siceeweb.util.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class TransazioneCreditoMgr.
 */
public class TransazioneCreditoMgr extends BaseMgr {

	/** The soa integration mgr. */
	private SOAIntegrationMgr soaIntegrationMgr;

	/**
	 * Gets the soa integration mgr.
	 *
	 * @return the soa integration mgr
	 */
	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return this.soaIntegrationMgr;
	}

	/**
	 * Sets the soa integration mgr.
	 *
	 * @param soaIntegrationMgr the new soa integration mgr
	 */
	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/** The sicee t credito 2018 dao. */
	private OptimizedSiceeTCredito2018Dao optimizedSiceeTCredito2018Dao;

	/** The sicee d tipo op 2018 dao. */
	//private SiceeDTipoOp2018Dao siceeDTipoOp2018Dao;
	
	
	/**
	 * @return the siceeTCredito2018Dao
	 */
	public OptimizedSiceeTCredito2018Dao getOptimizedSiceeTCredito2018Dao() {
		return optimizedSiceeTCredito2018Dao;
	}

	/**
	 * @param siceeTCredito2018Dao the siceeTCredito2018Dao to set
	 */
	public void setOptimizedSiceeTCredito2018Dao(OptimizedSiceeTCredito2018Dao optimizedSiceeTCredito2018Dao) {
		this.optimizedSiceeTCredito2018Dao = optimizedSiceeTCredito2018Dao;
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
	
	/** The sicee t transazione 2018 dao. */
	private SiceeTTransazione2018Dao siceeTTransazione2018Dao;

	/**
	 * Gets the sicee t transazione 2018 dao.
	 *
	 * @return the sicee t transazione 2018 dao
	 */
	public SiceeTTransazione2018Dao getSiceeTTransazione2018Dao() {
		return this.siceeTTransazione2018Dao;
	}

	/**
	 * Sets the sicee t transazione 2018 dao.
	 *
	 * @param siceeTTransazione2018Dao the new sicee t transazione 2018 dao
	 */
	public void setSiceeTTransazione2018Dao(
			SiceeTTransazione2018Dao siceeTTransazione2018Dao) {
		this.siceeTTransazione2018Dao = siceeTTransazione2018Dao;
	}
	
	
	/** The sicee d stato trans 2018 dao. */
	private SiceeDStatoTrans2018Dao siceeDStatoTrans2018Dao;

	/**
	 * Gets the sicee d stato trans 2018 dao.
	 *
	 * @return the sicee d stato trans 2018 dao
	 */
	public SiceeDStatoTrans2018Dao getSiceeDStatoTrans2018Dao() {
		return this.siceeDStatoTrans2018Dao;
	}

	/**
	 * Sets the sicee d stato trans 2018 dao.
	 *
	 * @param siceeDStatoTrans2018Dao the new sicee d stato trans 2018 dao
	 */
	public void setSiceeDStatoTrans2018Dao(
			SiceeDStatoTrans2018Dao siceeDStatoTrans2018Dao) {
		this.siceeDStatoTrans2018Dao = siceeDStatoTrans2018Dao;
	}
	
	
	/**
	 * @return the siceeDTipoOp2018Dao
	 */
	/*
	public SiceeDTipoOp2018Dao getSiceeDTipoOp2018Dao() {
		return siceeDTipoOp2018Dao;
	}
	*/
	
	/**
	 * @param siceeDTipoOp2018Dao the siceeDTipoOp2018Dao to set
	 */
	/*
	public void setSiceeDTipoOp2018Dao(SiceeDTipoOp2018Dao siceeDTipoOp2018Dao) {
		this.siceeDTipoOp2018Dao = siceeDTipoOp2018Dao;
	}
	*/

	/**
	 * Gets the transazioni.
	 *
	 * @param cert the cert
	 * @return the transazioni
	 * @throws BEException the bE exception
	 */
	public ArrayList<TransazioneCredito> getTransazioni(DatiCertificatore cert, String codTipoRic)
			throws BEException {
		ArrayList<TransazioneCredito> ret = new ArrayList<TransazioneCredito>();
		try {
			List<OptimizedSiceeTCredito2018> list = this.getOptimizedSiceeTCredito2018Dao().executeByFkCertificatore(cert.getIdCertificatore(), codTipoRic);
			Iterator<OptimizedSiceeTCredito2018> iter = list.iterator();

			while (iter.hasNext()) {
				ret.add(this.mapToTransazioneCredito(iter.next()));
			}

		} catch (OptimizedSiceeTCredito2018DaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return ret;
	}
	
	/**
	 * Gets the transazioni.
	 *
	 * @param cert the cert
	 * @return the transazioni
	 * @throws BEException the bE exception
	 */
	public Double getCreditoDisponibile(String idCertificatore)
			throws BEException {
		Double credito = null;
		try {
			SiceeTCredito2018 siceeTCredito2018 = this.getSiceeTCredito2018Dao().findWhereFkCertificatoreEqualsCreditoDisp(idCertificatore);
			
			if (siceeTCredito2018 != null)
			{
				credito = siceeTCredito2018.getValoreCreditoFinale();
			}
		} catch (SiceeTCredito2018DaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return credito;
	}
	
	

	public SiceeTCredito2018 getCreditoById(Long idCredito)
			throws BEException {
		
		SiceeTCredito2018 siceeTCredito2018 = null;
		
		try {
			
			siceeTCredito2018 = this.getSiceeTCredito2018Dao().findByPrimaryKey(idCredito);
			
		} catch (SiceeTCredito2018DaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return siceeTCredito2018;
	}

	public DatiPagamentoNew getTransazioneById(Integer idTransazione)
			throws BEException {
		DatiPagamentoNew transazione = null;
		try {
			
			SiceeTTransazione2018 siceeTTransazione2018 = this.getSiceeTTransazione2018Dao().findByPrimaryKey(idTransazione.longValue());
			
			if (siceeTTransazione2018 != null)
			{
				transazione = mapToDatiPagamentoNew(siceeTTransazione2018);
			}
		} catch (SiceeTTransazione2018DaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return transazione;
	}
	
	/*
	private static String decodTipoOperazioneDesc (Integer idTipoOp, List<SiceeDTipoOp2018> tipiOperazione) {
		String retval = new String();
		
		if (!GenericUtil.isNullOrEmpty(tipiOperazione)) {
			for (SiceeDTipoOp2018 ce : tipiOperazione) {
				if (ce.getIdTipoOp2018().intValue() == idTipoOp.intValue()) 
				{
					retval = ce.getDescrTipoOp2018();
				}
			}
		}
		return retval;
	}
	*/
	
	public ArrayList<LabelValueCombo> getComboStatiTransazione2018()
			throws BEException {
		
		ArrayList<LabelValueCombo> labelValueList = new ArrayList<LabelValueCombo>();
		try {
			
			List<SiceeDStatoTrans2018> siceeDStatoTrans2018List = this.getSiceeDStatoTrans2018Dao().findAll();
			
			LabelValueCombo labelValue = null; 
			
			if (siceeDStatoTrans2018List != null)
			{
				for (SiceeDStatoTrans2018 siceeDStatoTransMdp2018 : siceeDStatoTrans2018List) {
					if (siceeDStatoTransMdp2018.getIdStatoTrans2018() == Constants.ID_STATO_TRANS_2018_AVVIO_TRANS ||
							siceeDStatoTransMdp2018.getIdStatoTrans2018() == Constants.ID_STATO_TRANS_2018_ATTESA_RT ||
							siceeDStatoTransMdp2018.getIdStatoTrans2018() == Constants.ID_STATO_TRANS_2018_FALLITO ||
							siceeDStatoTransMdp2018.getIdStatoTrans2018() == Constants.ID_STATO_TRANS_2018_ANNULLATO ||
							siceeDStatoTransMdp2018.getIdStatoTrans2018() == Constants.ID_STATO_TRANS_2018_PAGAMENTO_KO ||
							siceeDStatoTransMdp2018.getIdStatoTrans2018() == Constants.ID_STATO_TRANS_2018_PAGAMENTO_KO_AUTO)
					{
						labelValue = new LabelValueCombo();
						labelValue.setValue(convertToString(siceeDStatoTransMdp2018.getIdStatoTrans2018()));
						labelValue.setLabel(siceeDStatoTransMdp2018.getDescrStatoTrans());
						labelValueList.add(labelValue);
					}
				}
			}
		} catch (SiceeDStatoTrans2018DaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return labelValueList;
	}

	public SiceeDStatoTrans2018 getStatoTransazione2018ById(Integer idStatoMdp)
			throws BEException {
		
		SiceeDStatoTrans2018 siceeDStatoTrans2018;
		try {
			
			siceeDStatoTrans2018 = this.getSiceeDStatoTrans2018Dao().findByPrimaryKey(idStatoMdp);
			
			
		} catch (SiceeDStatoTrans2018DaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return siceeDStatoTrans2018;
	}

	
	public ArrayList<DatiPagamentoNew> getTransazioneByIdStato(Integer idStato, String idCertificatore)
			throws BEException {

		ArrayList<DatiPagamentoNew> transazioneList = new ArrayList<DatiPagamentoNew>();

		try {
			
			DatiPagamentoNew transazione = null;
			
			List<SiceeTTransazione2018> siceeTTransazione2018List = this.getSiceeTTransazione2018Dao().findWhereFkCertificatoreAndStatoEquals(idCertificatore, idStato);
			
			if (siceeTTransazione2018List != null)
			{
				for (SiceeTTransazione2018 siceeTTransazione2018 : siceeTTransazione2018List) {
					
					transazione = mapToDatiPagamentoNew(siceeTTransazione2018);
					
					transazioneList.add(transazione);
					
				}
			}
		} catch (SiceeTTransazione2018DaoException e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return transazioneList;
	}
	
	public String getMdpNewNumTransazione()
			throws BEException {

		String numTransazione = null;
		
		try {
			
			// recupero il numero transazione
			numTransazione = getSOAIntegrationMgr().getNewNumTransazione();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return numTransazione;
	}
	
	public String getMdpNewUrlWispOld(DatiPagamentoNew datiPagamento, String idCertificatore)
			throws BEException {

		String urlWisp;

		try {
			
			SiceeTTransazione2018 siceeTTransazione2018 = mapToTTransazione2018(datiPagamento, idCertificatore);
			// inserisco la transazione sul DB
			getSiceeTTransazione2018Dao().insert(siceeTTransazione2018);

			// recupero l'url SISP
			urlWisp = getSOAIntegrationMgr().getNewUrlWisp(datiPagamento.getIdTransMdp(), convertTo(datiPagamento.getImporto()));
			
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return urlWisp;
	}
	
	public String getMdpNewUrlPagamentoOld(DatiCertificatore datiCertificatore, DatiPagamentoNew datiPagamento)
			throws BEException {

		String urlPagamento;

		try {
			
			log.debug("TransazioneCreditoMgr :: getMdpNewUrlPagamento: "+datiPagamento.getIdTransMdp());
			
			// recupero l'informativa della scelta
			InformativaSceltaNew informativa = getSOAIntegrationMgr().getNewSceltaWisp(datiPagamento.getIdTransMdp());
			
			
			List<SiceeTTransazione2018> siceeTTransazione2018List = getSiceeTTransazione2018Dao().findWhereIdTransazioneMdpEquals(datiPagamento.getIdTransMdp());
			
			if (siceeTTransazione2018List != null && siceeTTransazione2018List.size() == 1)
			{
				SiceeTTransazione2018 siceeTTransazione2018 = siceeTTransazione2018List.get(0); 
				
				
				// dovrebbe trovarne uno solo
				siceeTTransazione2018 = mapToTTransazione2018(informativa, siceeTTransazione2018);
				
				SiceeTTransazione2018Pk siceeTTransazione2018Pk = new SiceeTTransazione2018Pk(siceeTTransazione2018.getIdTransazione2018());
				// modifico la transazione sul DB
				getSiceeTTransazione2018Dao().update(siceeTTransazione2018Pk, siceeTTransazione2018);

				// recupero il numero IUV
				String numIUV = getSOAIntegrationMgr().getNewNumIUV();
				datiPagamento.setIdInformativaMdp(informativa.getIdInformativa());
				
				// recupero l'url Pagamento
				urlPagamento = getSOAIntegrationMgr().getNewUrlPagamento(datiCertificatore, datiPagamento, numIUV);

				// modifico la transazione sul DB
				siceeTTransazione2018.setFkStatoTrans2018(Constants.ID_STATO_TRANS_2018_AVVIO_TRANS);
				siceeTTransazione2018.setS3IdIuv(numIUV);
				siceeTTransazione2018.setS3DtAvvioTransazione(new Date());
				getSiceeTTransazione2018Dao().update(siceeTTransazione2018Pk, siceeTTransazione2018);

			}
			else
			{
				throw new BEException("Errore nella ricerca della transazione", null);
			}
			
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return urlPagamento;
	}

	public String getMdpNewUrlPagamento(DatiCertificatore datiCertificatore, DatiPagamentoNew datiPagamento)
			throws BEException {

		String urlPagamento;

		try {
			
			log.debug("TransazioneCreditoMgr :: getMdpNewUrlPagamento: "+datiPagamento.getIdTransMdp());
			
			// recupero l'informativa della scelta
//			InformativaSceltaNew informativa = getSOAIntegrationMgr().getNewSceltaWisp(datiPagamento.getIdTransMdp());
			
			SiceeTTransazione2018 siceeTTransazione2018 = mapToTTransazione2018(datiPagamento, datiCertificatore.getIdCertificatore());

			// inserisco la transazione sul DB
			getSiceeTTransazione2018Dao().insert(siceeTTransazione2018);

			
			log.debug("STAMPO l'ID TRANSAZIONE INSERITA SUL DB: "+siceeTTransazione2018.getIdTransazione2018());
			
				// dovrebbe trovarne uno solo
				//siceeTTransazione2018 = mapToTTransazione2018(informativa, siceeTTransazione2018);
				
				SiceeTTransazione2018Pk siceeTTransazione2018Pk = new SiceeTTransazione2018Pk(siceeTTransazione2018.getIdTransazione2018());
				// modifico la transazione sul DB
				getSiceeTTransazione2018Dao().update(siceeTTransazione2018Pk, siceeTTransazione2018);

				// recupero il numero IUV
				String numIUV = getSOAIntegrationMgr().getNewNumIUV();
				//datiPagamento.setIdInformativaMdp(informativa.getIdInformativa());
				
				// recupero l'url Pagamento
				urlPagamento = getSOAIntegrationMgr().getNewUrlPagamento(datiCertificatore, datiPagamento, numIUV);

				// modifico la transazione sul DB
				siceeTTransazione2018.setFkStatoTrans2018(Constants.ID_STATO_TRANS_2018_AVVIO_TRANS);
				siceeTTransazione2018.setS3IdIuv(numIUV);
				siceeTTransazione2018.setS3DtAvvioTransazione(new Date());
				getSiceeTTransazione2018Dao().update(siceeTTransazione2018Pk, siceeTTransazione2018);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 

		return urlPagamento;
	}
	public void aggiornaStatoTransazioneNew(String numTransazione, int newStato)
			throws BEException {
		try {
			
			List<SiceeTTransazione2018> siceeTTransazione2018List = getSiceeTTransazione2018Dao().findWhereIdTransazioneMdpEquals(numTransazione);
			
			if (siceeTTransazione2018List != null && siceeTTransazione2018List.size() == 1)
			{
				SiceeTTransazione2018 siceeTTransazione2018 = siceeTTransazione2018List.get(0); 
				
				SiceeTTransazione2018Pk siceeTTransazione2018Pk = new SiceeTTransazione2018Pk(siceeTTransazione2018.getIdTransazione2018());

				// modifico la transazione sul DB
				siceeTTransazione2018.setFkStatoTrans2018(newStato);
				if (GenericUtil.isNullOrEmpty(siceeTTransazione2018.getXmlRt()))
				{
					// Se nel frattempo il servizio WS non aggiornato lo stato della transazione con il rispettivo RT
					getSiceeTTransazione2018Dao().update(siceeTTransazione2018Pk, siceeTTransazione2018);
				}
			}
			else
			{
				throw new BEException("Errore nella ricerca della transazione", null);
			}
			
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException(e.getMessage(), e);
		} 
	}

	/**
	 * Map to transazione ace.
	 *
	 * @param dto the next
	 * @return the transazione ace
	 */
	private TransazioneCredito mapToTransazioneCredito(OptimizedSiceeTCredito2018 dto) {
		TransazioneCredito t = new TransazioneCredito();

		t.setIdCredito(this.convertToString(dto.getIdCredito()));
		t.setValoreOperazione(Converter.convertToFloat(dto.getValoreOperazione()));
		t.setValoreCreditoIniziale(Converter.convertToFloat(dto.getValoreCreditoIniziale()));
		t.setValoreCreditoFinale(Converter.convertToFloat(dto.getValoreCreditoFinale()));
		t.setDataOperazione(DateUtil.convertToStringDataCompleta(dto.getDataOperazione()));

		String descOp = dto.getDescrTipoOp2018();
		
		if (dto.getFkTipoOp2018().intValue() == Constants.ID_TIPO_OP_RICARICA)
		{
			descOp += " " + dto.getIdTransazioneMdp();
		}
		else if (dto.getFkTipoOp2018().intValue() == Constants.ID_TIPO_OP_GENERA_APE)
		{
			descOp += " " + dto.getAnno() + "_" + dto.getNumCertificatore() + "_" + dto.getProgrCertificato();
		} 
		else if (dto.getFkTipoOp2018().intValue() == Constants.ID_TIPO_OP_STORNO_ERROR)
		{
			descOp += " " + dto.getIdTransazioneMdp();
		}
			
		t.setDescrizioneOperazione(descOp);

		return t;
	}
	
	private DatiPagamentoNew mapToDatiPagamentoNew(SiceeTTransazione2018 dto) {
		DatiPagamentoNew t = new DatiPagamentoNew();

		t.setIdTransazione2018(dto.getIdTransazione2018());
		t.setIdCertificatore(Converter.convertToInteger(dto.getFkCertificatore()));
		t.setIdTransMdp(dto.getS1IdTransazioneMdp());
//		Double valoreD = dto.getS1ValoreTransazione();
//		Float valoreF = convertToFloat(valoreD);
		
		t.setImporto(convertToDoubleTwo(dto.getS1ValoreTransazione()));
		t.setDtTransazione(DateUtil.convertToStringDataCompleta(dto.getS1DtCreazioneTransazione()));
		t.setTipoPersonaDesc(Constants.SIGLA_TIPO_PERS_PF.equalsIgnoreCase(dto.getS1TipoIdVersante())?Constants.DESC_TIPO_PERS_PF:Constants.DESC_TIPO_PERS_PG);
		t.setCodiceFiscale(dto.getS1CodIdVersante());
		t.setAnagraficaVersante(dto.getS1AnagraficaVersante());
		t.setIdStatoTrans2018(dto.getFkStatoTrans2018());

		return t;
	}
	
	private SiceeTTransazione2018 mapToTTransazione2018(DatiPagamentoNew dtn, String idCertificatore) {
		SiceeTTransazione2018 dto = new SiceeTTransazione2018();

		dto.setFkCertificatore(idCertificatore);
		dto.setS1IdTransazioneMdp(dtn.getIdTransMdp());

		dto.setS1ValoreTransazione(convertTo(dtn.getImporto()));
		dto.setS1DtCreazioneTransazione(new Date());
		dto.setS1TipoIdVersante(dtn.getTipoPersona());
		dto.setS1CodIdVersante(dtn.getCodiceFiscale());
		dto.setS1AnagraficaVersante(dtn.getAnagraficaVersante());
		dto.setFkStatoTrans2018(Constants.ID_STATO_TRANS_2018_CREA_TRANS);
		
		
		return dto;
	}
	
	private SiceeTTransazione2018 mapToTTransazione2018(InformativaSceltaNew informativa, SiceeTTransazione2018 dto) {

		dto.setS2IdInformativaPsp(informativa.getIdInformativa());
		dto.setS2IdentificativoPsp(informativa.getIdentificativo());
		dto.setS2RagSocialePsp(informativa.getRagioneSociale());
		dto.setS2DescrServizioPsp(informativa.getDescrizioneServizio());
		dto.setFkStatoTrans2018(Constants.ID_STATO_TRANS_2018_URL_WIS);

		return dto;
	}
}
