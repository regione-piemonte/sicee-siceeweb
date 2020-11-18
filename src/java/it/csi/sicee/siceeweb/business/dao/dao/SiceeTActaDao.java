/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTActaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTActa;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTActaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTActaDaoException;
import java.util.Date;
import java.util.List;

public interface SiceeTActaDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTActaPk
	 */
	public SiceeTActaPk insert(SiceeTActa dto);

	/** 
	 * Updates a single row in the SICEE_T_ACTA table.
	 */
	public void update(SiceeTActaPk pk, SiceeTActa dto) throws SiceeTActaDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_ACTA table.
	 */
	public void delete(SiceeTActaPk pk) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTActa findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria ''.
	 */
	public List<SiceeTActa> findAll() throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTActa> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTActa> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTActa> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTActa> findWhereAnnoEquals(String anno) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'VOLUME = :volume'.
	 */
	public List<SiceeTActa> findWhereVolumeEquals(String volume) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_DOC_ACTA = :idDocActa'.
	 */
	public List<SiceeTActa> findWhereIdDocActaEquals(String idDocActa) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CLASSIFICAZIONE_ACTA = :idClassificazioneActa'.
	 */
	public List<SiceeTActa> findWhereIdClassificazioneActaEquals(String idClassificazioneActa) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'TIPO_DOCUMENTO_ACTA = :tipoDocumentoActa'.
	 */
	public List<SiceeTActa> findWhereTipoDocumentoActaEquals(String tipoDocumentoActa) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'FAILED_STEP_ACTA = :failedStepActa'.
	 */
	public List<SiceeTActa> findWhereFailedStepActaEquals(String failedStepActa) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'TIMESTAMP_ARCHIVIAZIONE = :timestampArchiviazione'.
	 */
	public List<SiceeTActa> findWhereTimestampArchiviazioneEquals(Date timestampArchiviazione) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'NUMERO_PROTOCOLLO = :numeroProtocollo'.
	 */
	public List<SiceeTActa> findWhereNumeroProtocolloEquals(String numeroProtocollo) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'MAIL_INVIATA = :mailInviata'.
	 */
	public List<SiceeTActa> findWhereMailInviataEquals(String mailInviata) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'TIMESTAMP_PROTOCOLLO = :timestampProtocollo'.
	 */
	public List<SiceeTActa> findWhereTimestampProtocolloEquals(Date timestampProtocollo) throws SiceeTActaDaoException;

	/** 
	 * Returns the rows from the SICEE_T_ACTA table that matches the specified primary-key value.
	 */
	public SiceeTActa findByPrimaryKey(SiceeTActaPk pk) throws SiceeTActaDaoException;

}
