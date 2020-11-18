/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRaccomand2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTQtaConsumi2015DaoException;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRaccomand2015DaoException;

import java.util.List;

public interface SiceeTRaccomand2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTRaccomand2015Pk
	 */
	public SiceeTRaccomand2015Pk insert(SiceeTRaccomand2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_RACCOMAND_2015 table.
	 */
	public void update(SiceeTRaccomand2015Pk pk, SiceeTRaccomand2015 dto) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_RACCOMAND_2015 table.
	 */
	public void delete(SiceeTRaccomand2015Pk pk) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Deletes in the SICEE_T_RACCOMAND_2015 table.
	 */
	public void delete(String idCertificatore, String progrCertificato, String anno) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_RACCOMANDAZIONE = :idRaccomandazione'.
	 */
	public SiceeTRaccomand2015 findByPrimaryKey(long idRaccomandazione) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria ''.
	 */
	public List<SiceeTRaccomand2015> findAll() throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	public List<SiceeTRaccomand2015> findBySiceeDRiqEner2015(String codiceRen) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_RACCOMANDAZIONE = :idRaccomandazione'.
	 */
	public List<SiceeTRaccomand2015> findWhereIdRaccomandazioneEquals(long idRaccomandazione) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	public List<SiceeTRaccomand2015> findWhereCodiceRenEquals(String codiceRen) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'FK_CLASSE_ENERGETICA = :fkClasseEnergetica'.
	 */
	public List<SiceeTRaccomand2015> findWhereFkClasseEnergeticaEquals(Integer fkClasseEnergetica) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTRaccomand2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTRaccomand2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTRaccomand2015> findWhereAnnoEquals(String anno) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'TIPO_INTERVENTO = :tipoIntervento'.
	 */
	public List<SiceeTRaccomand2015> findWhereTipoInterventoEquals(String tipoIntervento) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'FLG_RISTRUTTURAZIONE = :flgRistrutturazione'.
	 */
	public List<SiceeTRaccomand2015> findWhereFlgRistrutturazioneEquals(String flgRistrutturazione) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'NR_ANNI_RIT_INVEST = :nrAnniRitInvest'.
	 */
	public List<SiceeTRaccomand2015> findWhereNrAnniRitInvestEquals(Double nrAnniRitInvest) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'EPGL_NREN_SINGOLO_INT = :epglNrenSingoloInt'.
	 */
	public List<SiceeTRaccomand2015> findWhereEpglNrenSingoloIntEquals(Double epglNrenSingoloInt) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_RACCOMAND_2015 table that matches the specified primary-key value.
	 */
	public SiceeTRaccomand2015 findByPrimaryKey(SiceeTRaccomand2015Pk pk) throws SiceeTRaccomand2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_RACCOMAND_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTRaccomand2015> findWhereIdCertProgrAnno(String idCertificatore, String progrCertificato, String anno) throws SiceeTRaccomand2015DaoException;
}
