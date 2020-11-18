/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRuoliEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRuoliEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRuoliEdificioDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTRuoliEdificioDao.
 */
public interface SiceeTRuoliEdificioDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTRuoliEdificioPk
	 */
	public SiceeTRuoliEdificioPk insert(SiceeTRuoliEdificio dto);

	/**
	 * Updates a single row in the SICEE_T_RUOLI_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public void update(SiceeTRuoliEdificioPk pk, SiceeTRuoliEdificio dto) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Deletes a single row in the SICEE_T_RUOLI_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public void delete(SiceeTRuoliEdificioPk pk) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND FK_TIPO_RUOLO = :fkTipoRuolo'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @param fkTipoRuolo the fk tipo ruolo
	 * @return the sicee t ruoli edificio
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public SiceeTRuoliEdificio findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, Integer fkTipoRuolo) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_RUOLO_EDIFICIO = :idRuoloEdificio'.
	 *
	 * @param idRuoloEdificio the id ruolo edificio
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereIdRuoloEdificioEquals(Integer idRuoloEdificio) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findAll() throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'FK_TIPO_RUOLO = :fkTipoRuolo'.
	 *
	 * @param fkTipoRuolo the fk tipo ruolo
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereFkTipoRuoloEquals(Integer fkTipoRuolo) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'NOME = :nome'.
	 *
	 * @param nome the nome
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereNomeEquals(String nome) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'COGNOME = :cognome'.
	 *
	 * @param cognome the cognome
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereCognomeEquals(String cognome) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 *
	 * @param idIndirizzo the id indirizzo
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 *
	 * @param descIndirizzo the desc indirizzo
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'CAP = :cap'.
	 *
	 * @param cap the cap
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereCapEquals(String cap) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_COMUNE = :idComune'.
	 *
	 * @param idComune the id comune
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereIdComuneEquals(String idComune) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_COMUNE = :descComune'.
	 *
	 * @param descComune the desc comune
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereDescComuneEquals(String descComune) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'TELEFONO = :telefono'.
	 *
	 * @param telefono the telefono
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereTelefonoEquals(String telefono) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'FAX = :fax'.
	 *
	 * @param fax the fax
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereFaxEquals(String fax) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'CELL = :cell'.
	 *
	 * @param cell the cell
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereCellEquals(String cell) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'EMAIL = :email'.
	 *
	 * @param email the email
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereEmailEquals(String email) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_REGIONE = :idRegione'.
	 *
	 * @param idRegione the id regione
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereIdRegioneEquals(String idRegione) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_REGIONE = :descRegione'.
	 *
	 * @param descRegione the desc regione
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereDescRegioneEquals(String descRegione) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_PROVINCIA = :idProvincia'.
	 *
	 * @param idProvincia the id provincia
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereIdProvinciaEquals(String idProvincia) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'DESC_PROVINCIA = :descProvincia'.
	 *
	 * @param descProvincia the desc provincia
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereDescProvinciaEquals(String descProvincia) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'NUM_CIVICO = :numCivico'.
	 *
	 * @param numCivico the num civico
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereNumCivicoEquals(String numCivico) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_RUOLI_EDIFICIO table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public List<SiceeTRuoliEdificio> findWhereAnnoEquals(String anno) throws SiceeTRuoliEdificioDaoException;

	/**
	 * Returns the rows from the SICEE_T_RUOLI_EDIFICIO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t ruoli edificio
	 * @throws SiceeTRuoliEdificioDaoException the sicee t ruoli edificio dao exception
	 */
	public SiceeTRuoliEdificio findByPrimaryKey(SiceeTRuoliEdificioPk pk) throws SiceeTRuoliEdificioDaoException;

}
