/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTClasseEnergeticaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTClasseEnergeticaDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTClasseEnergeticaDao.
 */
public interface SiceeTClasseEnergeticaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTClasseEnergeticaPk
	 */
	public SiceeTClasseEnergeticaPk insert(SiceeTClasseEnergetica dto);

	/**
	 * Updates a single row in the SICEE_T_CLASSE_ENERGETICA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public void update(SiceeTClasseEnergeticaPk pk, SiceeTClasseEnergetica dto) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Deletes a single row in the SICEE_T_CLASSE_ENERGETICA table.
	 *
	 * @param pk the pk
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public void delete(SiceeTClasseEnergeticaPk pk) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t classe energetica
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public SiceeTClasseEnergetica findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findAll() throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_RISC_EPI = :indRiscEpi'.
	 *
	 * @param indRiscEpi the ind risc epi
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIndRiscEpiEquals(Double indRiscEpi) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_COND_EST = :indCondEst'.
	 *
	 * @param indCondEst the ind cond est
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIndCondEstEquals(Double indCondEst) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_ILLUM = :indIllum'.
	 *
	 * @param indIllum the ind illum
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIndIllumEquals(Double indIllum) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereAnnoEquals(String anno) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_GLOB_EPLORDO = :indGlobEplordo'.
	 *
	 * @param indGlobEplordo the ind glob eplordo
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIndGlobEplordoEquals(Double indGlobEplordo) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'FK_CLASSE = :fkClasse'.
	 *
	 * @param fkClasse the fk classe
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereFkClasseEquals(Integer fkClasse) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_GENER = :rendGener'.
	 *
	 * @param rendGener the rend gener
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereRendGenerEquals(Double rendGener) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_REGOL = :rendRegol'.
	 *
	 * @param rendRegol the rend regol
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereRendRegolEquals(Double rendRegol) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'SERVIZI_ENERGETICI = :serviziEnergetici'.
	 *
	 * @param serviziEnergetici the servizi energetici
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereServiziEnergeticiEquals(String serviziEnergetici) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_EMISS = :rendEmiss'.
	 *
	 * @param rendEmiss the rend emiss
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereRendEmissEquals(Double rendEmiss) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_DISTRIB = :rendDistrib'.
	 *
	 * @param rendDistrib the rend distrib
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereRendDistribEquals(Double rendDistrib) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_IMP_ETAG = :rendImpEtag'.
	 *
	 * @param rendImpEtag the rend imp etag
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereRendImpEtagEquals(Double rendImpEtag) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'DOM_RISC_QHTO = :domRiscQhto'.
	 *
	 * @param domRiscQhto the dom risc qhto
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereDomRiscQhtoEquals(Double domRiscQhto) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'LIMITE_REG_QHTO = :limiteRegQhto'.
	 *
	 * @param limiteRegQhto the limite reg qhto
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereLimiteRegQhtoEquals(Double limiteRegQhto) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_RISC_EPITO = :indRiscEpito'.
	 *
	 * @param indRiscEpito the ind risc epito
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIndRiscEpitoEquals(Double indRiscEpito) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'DOM_ACS_QHWTO = :domAcsQhwto'.
	 *
	 * @param domAcsQhwto the dom acs qhwto
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereDomAcsQhwtoEquals(Double domAcsQhwto) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'EN_ACS_RINNO_TO = :enAcsRinnoTo'.
	 *
	 * @param enAcsRinnoTo the en acs rinno to
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereEnAcsRinnoToEquals(Double enAcsRinnoTo) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'REND_ACS_ETAG_ACSTO = :rendAcsEtagAcsto'.
	 *
	 * @param rendAcsEtagAcsto the rend acs etag acsto
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereRendAcsEtagAcstoEquals(Double rendAcsEtagAcsto) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'FABB_ACS_TO = :fabbAcsTo'.
	 *
	 * @param fabbAcsTo the fabb acs to
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereFabbAcsToEquals(Double fabbAcsTo) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_GLOB_EPLORDO_TO = :indGlobEplordoTo'.
	 *
	 * @param indGlobEplordoTo the ind glob eplordo to
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIndGlobEplordoToEquals(Double indGlobEplordoTo) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'ETAG_CONV = :etagConv'.
	 *
	 * @param etagConv the etag conv
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereEtagConvEquals(Double etagConv) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns all rows from the SICEE_T_CLASSE_ENERGETICA table that match the criteria 'IND_GLOB_LIMITE_TO = :indGlobLimiteTo'.
	 *
	 * @param indGlobLimiteTo the ind glob limite to
	 * @return the list
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public List<SiceeTClasseEnergetica> findWhereIndGlobLimiteToEquals(Double indGlobLimiteTo) throws SiceeTClasseEnergeticaDaoException;

	/**
	 * Returns the rows from the SICEE_T_CLASSE_ENERGETICA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t classe energetica
	 * @throws SiceeTClasseEnergeticaDaoException the sicee t classe energetica dao exception
	 */
	public SiceeTClasseEnergetica findByPrimaryKey(SiceeTClasseEnergeticaPk pk) throws SiceeTClasseEnergeticaDaoException;

}
