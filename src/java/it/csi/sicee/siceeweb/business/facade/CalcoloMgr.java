/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCombustibileDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDGradiGiornoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeRDestClasseDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTLimiteqhPiemonteDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDGradiGiorno;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClasse;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTLimiteqhPiemonte;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDClasseEnergeticaDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDGradiGiornoDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRDestClasseDaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTLimiteqhPiemonteDaoException;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel;
import it.csi.sicee.siceeweb.dto.daticert.DtAnagImmobile;
import it.csi.sicee.siceeweb.dto.daticert.DtClasseEnerg;
import it.csi.sicee.siceeweb.dto.daticert.DtEnergiaFontiRinnov;
import it.csi.sicee.siceeweb.dto.daticert.DtIndiciFabbisogno;
import it.csi.sicee.siceeweb.dto.daticert.DtLocReale;
import it.csi.sicee.siceeweb.dto.daticert.DtLocTeorica;
import it.csi.sicee.siceeweb.dto.daticert.DtTecniciGen;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.exception.CalcoloException;

import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CalcoloMgr.
 */
public class CalcoloMgr extends BaseMgr {

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

	/** The sicee t limiteqh piemonte dao. */
	SiceeTLimiteqhPiemonteDao siceeTLimiteqhPiemonteDao;
	
	/** The sicee r dest classe dao. */
	SiceeRDestClasseDao siceeRDestClasseDao;
	
	/** The sicee d classe energetica dao. */
	SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao;
	
	/** The sicee d gradi giorno dao. */
	SiceeDGradiGiornoDao siceeDGradiGiornoDao;
	
	/** The sicee d combustibile dao. */
	SiceeDCombustibileDao siceeDCombustibileDao;

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
	 * @param siceeRDestClasseDao the new sicee r dest classe dao
	 */
	public void setSiceeRDestClasseDao(SiceeRDestClasseDao siceeRDestClasseDao) {
		this.siceeRDestClasseDao = siceeRDestClasseDao;
	}

	/**
	 * Gets the sicee t limiteqh piemonte dao.
	 *
	 * @return the sicee t limiteqh piemonte dao
	 */
	public SiceeTLimiteqhPiemonteDao getSiceeTLimiteqhPiemonteDao() {
		return this.siceeTLimiteqhPiemonteDao;
	}

	/**
	 * Sets the sicee t limiteqh piemonte dao.
	 *
	 * @param siceeTLimiteqhPiemonteDao the new sicee t limiteqh piemonte dao
	 */
	public void setSiceeTLimiteqhPiemonteDao(
			SiceeTLimiteqhPiemonteDao siceeTLimiteqhPiemonteDao) {
		this.siceeTLimiteqhPiemonteDao = siceeTLimiteqhPiemonteDao;
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
	 * Calcola fabbisogno.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaFabbisogno(CpCompilazModel theModel)
			throws CalcoloException {
		this.calcolaFabbisogno(theModel.getAppDatacertificato(), false);
	}

	/**
	 * Calcola fabbisogno.
	 *
	 * @param cert the cert
	 * @param isImportXml the is import xml
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaFabbisogno(DatiAttestato cert, boolean isImportXml)
			throws CalcoloException {
		try {
			log.debug("Calcolo Fabbisogno");
			DtIndiciFabbisogno fab = cert.getIndFabbisogno();
			DtTecniciGen tec = cert.getDatiTecnici();
			DtAnagImmobile anagImmobile = cert.getDatiAnagraficiImm();

			/*
			 * Double num = convertTo(fab.getRendGlobStagioneAcqua());
			 * 
			 * if (num == null || num == 0) { throw new
			 * CalcoloException("Divisione per zero", new Exception()); }
			 */

			if (BaseMgr.convertTo(tec.getSuperficieUtile()) == 0) {
				throw new CalcoloException(
						"Possibili divisioni per zero. Verificare i dati inseriti",
						new Exception());
			}

			if (BaseMgr.convertTo(tec.getVolLordoRiscald()) == 0) {
				throw new CalcoloException(
						"Possibili divisioni per zero. Verificare i dati inseriti",
						new Exception());
			}

			// Beppe 27/01/2012
			/*
			 * if (convertTo(fab.getIndPrestEnergAcqua()) == 0) { throw new
			 * CalcoloException("Divisione per zero", new Exception()); }
			 */

			// Beppe - SICEE-296
			/*
			 * if (!isImportXml) { if (convertTo(fab.getDomEnergAcqua()) == 0 &&
			 * convertTo(fab.getIndPrestEnergAcqua()) != 0) { throw new
			 * CalcoloException(
			 * "Se il fabbisogno di energia termica utile per acqua calda sanitaria è zero, l'indice prestazione energetica per acqua calda sanitaria deve essere uguale a zero"
			 * , new Exception()); }
			 * 
			 * }
			 */

			// setRendGlobStagioneAcqua = Etagacs
			if (BaseMgr.convertTo(fab.getDomEnergAcqua()) == 0) {
				fab.setRendGlobStagioneAcqua(new UDTPositiveDoubleFive(
						new Double(0)));

			} else {
				fab.setRendGlobStagioneAcqua(new UDTPositiveDoubleFive(
						new Double(0.6)));
			}

			// Beppe - jira SICEE-296
			/*
			 * else if (convertTo(fab.getDomEnergAcqua()) != 0 &&
			 * convertTo(fab.getIndPrestEnergAcqua()) == 0) {
			 * fab.setRendGlobStagioneAcqua(new UDTPositiveDoubleFive(new
			 * Double(1)));
			 * 
			 * } else { fab.setRendGlobStagioneAcqua(convertToDoubleFive(
			 * (convertTo
			 * (fab.getDomEnergAcqua())/(convertTo(tec.getSuperficieUtile
			 * ())*convertTo(fab.getIndPrestEnergAcqua())))));
			 * 
			 * }
			 */

			// SICEE_T_FABBISOGNO.dom_acs_qhw/ (SICEE_T_DATI_GENERALI.su *
			// SICEE_T_FABBISOGNO.fabb_acs)

			boolean isEdificio = this.getMiscMgr().isEdificio(tec.getDestUso());
			// 21 dicembre 2010 per caso d'uso SICEE-CDU-08-V04
			// indici_fabbisogno.doc:
			// Indice prestazione energetica per acqua calda sanitaria(EPacs)
			// diventa un Campo editabile e non viene piu' calcolato
			/*
			 * if (isEdificio) { fab.setIndPrestEnergAcqua(convertTo( (
			 * (convertTo
			 * (fab.getDomEnergAcqua())-convertTo(fab.getEnergTermAcquaRinnov
			 * ())) /convertTo(fab.getRendGlobStagioneAcqua()))
			 * /convertTo(tec.getSuperficieUtile()))); } else {
			 * fab.setIndPrestEnergAcqua(convertTo(
			 * ((convertTo(fab.getDomEnergAcqua
			 * ())-convertTo(fab.getEnergTermAcquaRinnov()))
			 * /convertTo(fab.getRendGlobStagioneAcqua()))
			 * /convertTo(tec.getVolLordoRiscald())) ); }
			 */

			Double volume = BaseMgr.convertTo(tec.getVolLordoRiscald());
			Integer gradiGiorno = this.convertTo(anagImmobile.getDtCatastali()
					.getGradiGiorno());

			fab.setLimNormRegione(this.convertTo(this.calcoloLimiteQh(volume,
					gradiGiorno, isEdificio)));
		} catch (CalcoloException e) {
			log.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CalcoloException(
					"Si e' verificato un errore, si prega di riprovare. Se l'errore persiste contattare l'assistenza.",
					e);
		}

	}

	/**
	 * Calcolo limite qh.
	 *
	 * @param v the v
	 * @param gg the gg
	 * @param isEdificio the is edificio
	 * @return the double
	 */
	private Double calcoloLimiteQh(Double v, Integer gg, boolean isEdificio) {
		Double volume = v;
		Integer gradiGiorno = gg;
		Double limiteQh = null;

		if (volume <= 500D) {
			volume = new Double(500D);
		} else if (volume >= 10000) {
			volume = new Double(10000D);
		}

		if (gradiGiorno <= 3000) {
			gradiGiorno = new Integer(3000);
		} else if (gradiGiorno > 5000) {
			gradiGiorno = new Integer(5000);
		}

		if (log.isDebugEnabled())
		{
			log.debug("edificio residenziale: " + isEdificio);
			log.debug("volume: " + volume);
			log.debug("gradiGiorno:" + gradiGiorno);
		}
		
		try {
			List<SiceeTLimiteqhPiemonte> list = null;

			if (isEdificio) {
				list = this.getSiceeTLimiteqhPiemonteDao()
						.findWhereFlgEdificioEquals(
								Constants.EDIFICIO_RESIDENZIALE);
			} else {
				list = this.getSiceeTLimiteqhPiemonteDao()
						.findWhereFlgEdificioEquals(
								Constants.EDIFICIO_NON_RESIDENZIALE);
			}

			Iterator<SiceeTLimiteqhPiemonte> iter = list.iterator();

			SiceeTLimiteqhPiemonte min = new SiceeTLimiteqhPiemonte();
			min.setVolume(Integer.MIN_VALUE);
			SiceeTLimiteqhPiemonte max = new SiceeTLimiteqhPiemonte();
			max.setVolume(Integer.MAX_VALUE);

			while (iter.hasNext()) {
				SiceeTLimiteqhPiemonte dto = iter.next();
				if (dto.getVolume() <= volume
						&& dto.getVolume() > min.getVolume()) {
					min = dto;

				} else if (dto.getVolume() >= volume
						&& dto.getVolume() < max.getVolume()) {
					max = dto;

				}
			}

			if (max.getVolume() == Integer.MAX_VALUE) {
				max = min;
			}

			Double civ1 = null;
			Double civ2 = null;

			if (isEdificio && min.getGg3000() == 35) {
				civ1 = new Double(35);
			} else if (!isEdificio && min.getGg3000() == 11.5D) {
				civ1 = new Double(11.5D);
			}

			if (isEdificio && min.getGg5000() == 75) {
				civ2 = new Double(75);
			} else if (!isEdificio && min.getGg5000() == 25) {
				civ2 = new Double(25);
			}

			if (civ1 == null) {
				civ1 = min.getGg3000()
						+ ((max.getGg3000() - min.getGg3000())
								/ (max.getVolume() - min.getVolume()) * (volume - min
								.getVolume()));
			}

			if (civ2 == null) {
				civ2 = min.getGg5000()
						+ ((max.getGg5000() - min.getGg5000())
								/ (max.getVolume() - min.getVolume()) * (volume - min
								.getVolume()));
			}

			if (log.isDebugEnabled())
			{
				log.debug("valore minimo trovato: " + min.getVolume());
				log.debug("valore minimo 3000: " + min.getGg3000());
				log.debug("valore minimo 5000: " + min.getGg5000());
				log.debug("valore massimo trovato: " + max.getVolume());
				log.debug("valore massimo 3000: " + max.getGg3000());
				log.debug("valore massimo 5000: " + max.getGg5000());
	
				log.debug("c...zo i valore 1: " + civ1);
				log.debug("c...zo i valore 2: " + civ2);
			}
			
			limiteQh = ((civ2 - civ1) / 2000 * (gradiGiorno - 3000)) + civ1;

			if (log.isDebugEnabled())
				log.debug("limiteQh: " + limiteQh);

		} catch (SiceeTLimiteqhPiemonteDaoException e) {
			log.error(e.getMessage(), e);
			new BEException(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			new BEException(e.getMessage(), e);
		}

		return limiteQh;
	}

	/**
	 * Calcola classe energetica reale.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaClasseEnergeticaReale(CpCompilazModel theModel)
			throws CalcoloException {
		this.calcolaClasseEnergeticaReale(theModel.getAppDatacertificato());
	}

	/**
	 * Calcola classe energetica reale.
	 *
	 * @param cert the cert
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaClasseEnergeticaReale(DatiAttestato cert)
			throws CalcoloException {
		try {
			DtLocReale reale = cert.getClasseEnerg().getLocReale();
			DtIndiciFabbisogno fab = cert.getIndFabbisogno();

			/*
			 * reale.setRendGlobTermico( reale.getRendGeneraz()
			 * reale.getRendRegolaz()reale.getRendEmissione()
			 * reale.getRendDistrib());
			 */

			if (BaseMgr.convertTo(reale.getRendGlobTermico()) == 0) {
				throw new CalcoloException("Divisione per zero",
						new Exception());
			}

			reale.setIndPrestEnergRiscald(this.convertTo(BaseMgr.convertTo(fab
					.getDomEnergRiscald())
					/ BaseMgr.convertTo(reale.getRendGlobTermico())));

			reale.setIndPrestEnergGlob(this.convertTo(BaseMgr.convertTo(reale
					.getIndPrestEnergRiscald())
					+ BaseMgr.convertTo(fab.getIndPrestEnergAcqua())));

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CalcoloException(e.getMessage(), e);
		}

	}

	/**
	 * Calcola classe energetica teorica.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaClasseEnergeticaTeorica(CpCompilazModel theModel)
			throws CalcoloException {
		this.calcolaClasseEnergeticaTeorica(theModel.getAppDatacertificato());

	}

	/**
	 * Calcola classe energetica teorica.
	 *
	 * @param cert the cert
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaClasseEnergeticaTeorica(DatiAttestato cert)
			throws CalcoloException {
		try {
			DtLocReale reale = cert.getClasseEnerg().getLocReale();
			DtLocTeorica teorica = cert.getClasseEnerg().getLocTeorica();
			// DtIndiciFabbisogno fab = cert.getIndFabbisogno();
			DtTecniciGen tec = cert.getDatiTecnici();
			// DtClasseEnerg ce = cert.getClasseEnerg();

			if (BaseMgr.convertTo(reale.getRendGlobTermico()) == 0) {
				throw new CalcoloException("Divisione per zero",
						new Exception());
			}

			if (BaseMgr.convertTo(tec.getSuperficieUtile()) == 0) {
				throw new CalcoloException("Divisione per zero",
						new Exception());
			}

			if (BaseMgr.convertTo(tec.getVolLordoRiscald()) == 0) {
				throw new CalcoloException("Divisione per zero",
						new Exception());
			}

			/*
			 * BEPPE 09/01/2012 if
			 * (convertTo(teorica.getRendGlobStagioneAcqua()) == 0) { throw new
			 * CalcoloException("Divisione per zero", new Exception()); }
			 */

			/*
			 * teorica.setIndPrestEnergRiscald( teorica.getDomEnergRiscald()
			 * /reale.getRendGlobTermico());
			 */

			boolean isEdificio = this.getMiscMgr().isEdificio(tec.getDestUso());

			// 23 dicembre 2010 per SICEE-CDU-09-V05 classeenergetica.doc
			// L'indice Prestazione energetica acqua calda sanitaria (EPacs To)
			// non viene piu' calcolata
			/*
			 * if (isEdificio) { teorica.setIndPrestEnergAcqua(convertTo( (
			 * convertTo(teorica.getDomEnergAcqua())-convertTo(teorica.
			 * getEnergTermAcquaRinnov()) )
			 * /convertTo(teorica.getRendGlobStagioneAcqua())
			 * /convertTo(tec.getSuperficieUtile()) )); } else {
			 * teorica.setIndPrestEnergAcqua(convertTo( (
			 * convertTo(teorica.getDomEnergAcqua()) -
			 * convertTo(teorica.getEnergTermAcquaRinnov()) )
			 * /convertTo(teorica.getRendGlobStagioneAcqua())
			 * /convertTo(tec.getVolLordoRiscald()) )); }
			 */

			teorica.setIndPrestEnergGlob(this.convertTo(BaseMgr
					.convertTo(teorica.getIndPrestEnergRiscald())
					+ BaseMgr.convertTo(teorica.getIndPrestEnergAcqua())));

			Double volume = BaseMgr.convertTo(tec.getVolLordoRiscald());

			try {
				SiceeDGradiGiorno gg = this.getSiceeDGradiGiornoDao()
						.findByPrimaryKey(Constants.ISTAT_TORINO);
				teorica.setLimNormaRegione(this.convertTo(this.calcoloLimiteQh(
						volume, gg.getGradiGiorno(), isEdificio)));
			} catch (SiceeDGradiGiornoDaoException e) {
				log.error(e.getMessage(), e);
			}

			/*
			 * if (getMiscMgr().isEdificio(tec.getDestUso())) {
			 * teorica.setIndPrestEnergGlobLim( (teorica.getLimNormaRegione()
			 * /new Double("0.9")) +18); } else {
			 * teorica.setIndPrestEnergGlobLim( (teorica.getLimNormaRegione()
			 * /new Double("0.9")) +6); }
			 */

			try {
				List<SiceeRDestClasse> list = this.getSiceeRDestClasseDao()
						.findWhereIdDestUsoEquals(
								BaseMgr.convertToInteger(tec.getDestUso()));
				Iterator<SiceeRDestClasse> iter = list.iterator();

				teorica.setClasseEnerg(null);
				teorica.setDescClasseEnerg(null);
				
				while (iter.hasNext()) {
					SiceeRDestClasse r = iter.next();
					if (BaseMgr.convertTo(teorica.getIndPrestEnergGlob()) >= r
							.getMin()
							&& BaseMgr
									.convertTo(teorica.getIndPrestEnergGlob()) < r
									.getMax()) {
						SiceeDClasseEnergetica c = this
								.getSiceeDClasseEnergeticaDao()
								.findByPrimaryKey(r.getIdClasse());

						teorica.setClasseEnerg(this.convertToString(c
								.getIdClasse()));
						teorica.setDescClasseEnerg(c.getDescr());
					}
				}

			} catch (SiceeRDestClasseDaoException e) {
				log.error(e.getMessage(), e);
			} catch (SiceeDClasseEnergeticaDaoException e) {
				log.error(e.getMessage(), e);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CalcoloException(e.getMessage(), e);
		}

	}

	/**
	 * Calcola dati tecnici generali.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaDatiTecniciGenerali(CpCompilazModel theModel)
			throws CalcoloException {
		this.calcolaDatiTecniciGenerali(theModel.getAppDatacertificato());
	}

	/**
	 * Calcola dati tecnici generali.
	 *
	 * @param cert the cert
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaDatiTecniciGenerali(DatiAttestato cert)
			throws CalcoloException {
		try {
			DtTecniciGen tec = cert.getDatiTecnici();
			if (BaseMgr.convertTo(tec.getVolLordoRiscald()) == 0) {
				throw new CalcoloException("Divisione per zero",
						new Exception());
			}
			cert.getDatiTecnici().setFattoreForma(
					this.convertTo(BaseMgr.convertTo(tec.getSupDispTot())
							/ BaseMgr.convertTo(tec.getVolLordoRiscald())));

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CalcoloException(e.getMessage(), e);
		}
	}

	/**
	 * Calcola fonti rinnov.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaFontiRinnov(CpCompilazModel theModel)
			throws CalcoloException {
		this.calcolaFontiRinnov(theModel.getAppDatacertificato());
	}

	/**
	 * Calcola fonti rinnov.
	 *
	 * @param cert the cert
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaFontiRinnov(DatiAttestato cert) throws CalcoloException {
		try {
			DtEnergiaFontiRinnov efr = cert.getEnergRinnov();
			DtTecniciGen tec = cert.getDatiTecnici();
			DtIndiciFabbisogno fab = cert.getIndFabbisogno();
			DtClasseEnerg ce = cert.getClasseEnerg();
			// DtConsumiReali cr = cert.getConsumiReali();

			if (efr.getEnergTermicaProdotta() == null) {
				efr.setPercEnergiaFontiRinnov(BaseMgr.convertToDoubleTwo(0D));
			} else {
				if (BaseMgr.convertTo(tec.getSuperficieUtile()) == 0) {
					throw new CalcoloException("Divisione per zero",
							new Exception());
				}

				// Beppe 05/03/12
				/*
				 * if (convertTo(fab.getDomEnergAcqua()) == 0) { throw new
				 * CalcoloException("Divisione per zero", new Exception()); }
				 */

				// Beppe 05/03/12
				/*
				 * Double num = convertTo(fab.getRendGlobStagioneAcqua()); if
				 * (num == null || num == 0) { throw new
				 * CalcoloException("Divisione per zero", new Exception()); }
				 */

				/*
				 * if (cr.getAnnoElettricoRinnov() == 0) { throw new
				 * CalcoloException("Divisione per zero", new Exception()); }
				 */

				double val = 0D;

				/*
				 * if (!isNullOrEmpty(cr.getAnnoElettricoRinnov()) &&
				 * cr.getAnnoElettricoRinnov() != 0D) { val =
				 * ((efr.getEnergTermicaProdotta()/tec.getSuperficieUtile())
				 * /((fab
				 * .getDomEnergAcqua()/tec.getSuperficieUtile()/convertToDouble
				 * (fab.getRendGlobStagioneAcqua()))
				 * +ce.getLocReale().getIndPrestEnergRiscald())) +
				 * (efr.getEnergElettricaProdotta
				 * ()/cr.getAnnoElettricoRinnov()); } else {
				 */

				// se

				boolean isEdificio = this.getMiscMgr().isEdificio(
						tec.getDestUso());
				if (isEdificio) {

					// se getDomEnergAcqua == 0 && getRendGlobStagioneAcqua == 0
					// ignorare la riga

					if (BaseMgr.convertTo(fab.getDomEnergAcqua()) == 0
							&& BaseMgr
									.convertTo(fab.getRendGlobStagioneAcqua()) == 0) {
						val = ((BaseMgr
								.convertTo(efr.getEnergTermicaProdotta()) / BaseMgr
								.convertTo(tec.getSuperficieUtile())) / (
						// (
						// convertTo(fab.getDomEnergAcqua())/convertTo(tec.getSuperficieUtile())/convertTo(fab.getRendGlobStagioneAcqua()))
						BaseMgr.convertTo(ce.getLocReale()
								.getIndPrestEnergRiscald())));
					} else {
						val = ((BaseMgr
								.convertTo(efr.getEnergTermicaProdotta()) / BaseMgr
								.convertTo(tec.getSuperficieUtile())) / ((BaseMgr
								.convertTo(fab.getDomEnergAcqua())
								/ BaseMgr.convertTo(tec.getSuperficieUtile()) / BaseMgr
								.convertTo(fab.getRendGlobStagioneAcqua())) + BaseMgr
								.convertTo(ce.getLocReale()
										.getIndPrestEnergRiscald())

						));

					}
				} else {
					if (BaseMgr.convertTo(fab.getDomEnergAcqua()) == 0
							&& BaseMgr
									.convertTo(fab.getRendGlobStagioneAcqua()) == 0) {
						val = ((BaseMgr
								.convertTo(efr.getEnergTermicaProdotta()) / BaseMgr
								.convertTo(tec.getVolLordoRiscald())) / (
						// (
						// convertTo(fab.getDomEnergAcqua())/convertTo(tec.getVolLordoRiscald())/convertTo(fab.getRendGlobStagioneAcqua()))
						BaseMgr.convertTo(ce.getLocReale()
								.getIndPrestEnergRiscald())

						));
					} else {
						val = ((BaseMgr
								.convertTo(efr.getEnergTermicaProdotta()) / BaseMgr
								.convertTo(tec.getVolLordoRiscald())) / ((BaseMgr
								.convertTo(fab.getDomEnergAcqua())
								/ BaseMgr.convertTo(tec.getVolLordoRiscald()) / BaseMgr
								.convertTo(fab.getRendGlobStagioneAcqua())) + BaseMgr
								.convertTo(ce.getLocReale()
										.getIndPrestEnergRiscald())

						));

					}
				}

				if (val > 1d) {
					val = 1d;
				}

				efr.setPercEnergiaFontiRinnov(BaseMgr
						.convertToDoubleTwo(val * 100));
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CalcoloException(e.getMessage(), e);
		}

	}

	/**
	 * Calcola limite normativo regionale impianto termico.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaLimiteNormativoRegionaleImpiantoTermico(
			CpCompilazModel theModel) throws CalcoloException {
		this.calcolaLimiteNormativoRegionaleImpiantoTermico(theModel
				.getAppDatacertificato());
	}

	/**
	 * Calcola limite normativo regionale impianto termico.
	 *
	 * @param cert the cert
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaLimiteNormativoRegionaleImpiantoTermico(
			DatiAttestato cert) throws CalcoloException {
		try {
			// Calcolo limite normativo
			Double limiteNormativoRegionaleImpiantoTermico;
			UDTPositiveDoubleFour potenzaUtileNominaleComplessiva = cert
					.getImpianti().getRiscaldamento().getPotNomCompl();

			if (potenzaUtileNominaleComplessiva.getValue().doubleValue() == 0.0) {
				limiteNormativoRegionaleImpiantoTermico = 0.77;
			} else if (potenzaUtileNominaleComplessiva.getValue().doubleValue() >= 1000.0) {
				limiteNormativoRegionaleImpiantoTermico = 0.86;
			} else {
				Double log10 = Math.log(potenzaUtileNominaleComplessiva
						.getValue().doubleValue()) / Math.log(10.0);

				limiteNormativoRegionaleImpiantoTermico = (77.0 + 3.0 * log10) / 100.0;
			}
			
			log.debug("limiteNormativoRegionaleImpiantoTermico = "
					+ limiteNormativoRegionaleImpiantoTermico);

			cert.getImpianti()
					.getRiscaldamento()
					.setLimNormRegImpTerm(
							this.convertTo(limiteNormativoRegionaleImpiantoTermico));

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CalcoloException(e.getMessage(), e);
		}
	}

	/**
	 * Calcola indice prestazione energetica globale limite torino.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaIndicePrestazioneEnergeticaGlobaleLimiteTorino(
			CpCompilazModel theModel) throws CalcoloException {
		this.calcolaIndicePrestazioneEnergeticaGlobaleLimiteTorino(theModel
				.getAppDatacertificato());
	}

	/**
	 * Calcola indice prestazione energetica globale limite torino.
	 *
	 * @param cert the cert
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaIndicePrestazioneEnergeticaGlobaleLimiteTorino(
			DatiAttestato cert) throws CalcoloException {
		// Calcolo indice
		Double indicePrestazEnergGlobaleLimTorino;
		Double limiteNormativoRegionaleImpiantoTermico = BaseMgr.convertTo(cert
				.getImpianti().getRiscaldamento().getLimNormRegImpTerm());
		if (limiteNormativoRegionaleImpiantoTermico != null
				&& limiteNormativoRegionaleImpiantoTermico != 0) {
			Double limNormaRegione = BaseMgr.convertTo(cert.getClasseEnerg()
					.getLocTeorica().getLimNormaRegione());
			boolean isEdificio = this.getMiscMgr().isEdificio(
					cert.getDatiTecnici().getDestUso());
			if (isEdificio) {
				indicePrestazEnergGlobaleLimTorino = (limNormaRegione / limiteNormativoRegionaleImpiantoTermico) + 9;
			} else {
				indicePrestazEnergGlobaleLimTorino = (limNormaRegione / limiteNormativoRegionaleImpiantoTermico) + 3;
			}
			cert.getClasseEnerg()
					.getLocTeorica()
					.setIndGlobLimiteTo(
							this.convertTo(indicePrestazEnergGlobaleLimTorino));
		}

	}

	/**
	 * Calcola emissioni gas serra e ettari bosco.
	 *
	 * @param theModel the the model
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaEmissioniGasSerraEEttariBosco(CpCompilazModel theModel)
			throws CalcoloException {
		this.calcolaEmissioniGasSerraEEttariBosco(theModel
				.getAppDatacertificato());
	}

	/**
	 * Calcola emissioni gas serra e ettari bosco.
	 *
	 * @param cert the cert
	 * @throws CalcoloException the calcolo exception
	 */
	public void calcolaEmissioniGasSerraEEttariBosco(DatiAttestato cert)
			throws CalcoloException {
		try {
			// calcolo emissioni gas serra

			// l'Indice di prestazione energetica per il riscaldamento invernale
			// (EPi To) e' un dato obblicatorio del pannello Classe Energetica
			// Indice di prestazione energetica per il riscaldamento invernale
			// (EPi To)
			Double epi = BaseMgr.convertTo(cert.getClasseEnerg().getLocReale()
					.getIndPrestEnergRiscald());

			// La Superficie disperdente totale (S) e' un dato obbligatorio del
			// pannello Dati tecnici generali
			// Double s = convertTo(cert.getDatiTecnici().getSupDispTot());
			// Jira-113:sostituire la sup disperdente tot con la superf utile
			Double s = BaseMgr.convertTo(cert.getDatiTecnici()
					.getSuperficieUtile());

			// il combustibile e' obbligatorio
			String idCombustibileRiscaldam = cert.getImpianti()
					.getRiscaldamento().getCombustibileFossile();
			// fattore emissione combustibile impianto
			Double fattoreEmissionePerRiscaldamento = (this
					.getSiceeDCombustibileDao().findByPrimaryKey(Integer
					.valueOf(idCombustibileRiscaldam))).getFattoreEmissione();

			// Vol lordo riscaldato
			Double v = BaseMgr.convertTo(cert.getDatiTecnici()
					.getVolLordoRiscald());
			if (v == null || v == 0) {
				throw new CalcoloException("Divisione per zero",
						new Exception());
			}
			// Indice prestazione energetica per acqua calda sanitaria (EPacs) *
			// e' un dato obbligatorio
			Double ePacs = BaseMgr.convertTo(cert.getIndFabbisogno()
					.getIndPrestEnergAcqua());

			String idCombustibileAcqua = cert.getImpianti().getAcqua()
					.getCombustibileFossile();
			Double fattoreEmissionePerAcqua = (this.getSiceeDCombustibileDao()
					.findByPrimaryKey(Integer.valueOf(idCombustibileAcqua)))
					.getFattoreEmissione();

			Double emissioniGasSerra = null;
			boolean isEdificio = this.getMiscMgr().isEdificio(
					cert.getDatiTecnici().getDestUso());
			if (isEdificio) {
				emissioniGasSerra = (epi * s * fattoreEmissionePerRiscaldamento / v)
						+ (ePacs * s * fattoreEmissionePerAcqua / v);
			} else {
				emissioniGasSerra = (epi * v * fattoreEmissionePerRiscaldamento / v)
						+ (ePacs * v * fattoreEmissionePerAcqua / v);
			}

			cert.getGasSerra().setEmissioniGasSerra(
					this.convertTo(emissioniGasSerra));

			// calcolo superficie ettari di bosco equivalente
			Double ettariBosco = null;
			if (isEdificio) {
				ettariBosco = ((epi * s * fattoreEmissionePerRiscaldamento) + (ePacs
						* s * fattoreEmissionePerAcqua)) / 100000;
			} else {
				ettariBosco = ((epi * v * fattoreEmissionePerRiscaldamento) + (ePacs
						* v * fattoreEmissionePerAcqua)) / 100000;
			}
			cert.getGasSerra().setSupBoscoEquiv(
					this.convertToDoubleFive(ettariBosco));

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CalcoloException(e.getMessage(), e);
		}
	}
}
