/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTConsumiEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTConsumiEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTConsumiEdificioDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTConsumiEdificioDao.
 */
public interface SiceeTConsumiEdificioDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTConsumiEdificioPk
	 */
	public SiceeTConsumiEdificioPk insert(SiceeTConsumiEdificio dto);

	/**
	 * Updates a single row in the SICEE_T_CONSUMI_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public void update(SiceeTConsumiEdificioPk pk, SiceeTConsumiEdificio dto) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Deletes a single row in the SICEE_T_CONSUMI_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public void delete(SiceeTConsumiEdificioPk pk) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t consumi edificio
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public SiceeTConsumiEdificio findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findAll() throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereAnnoEquals(String anno) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'DESC_TIPO_EROG = :descTipoErog'.
	 *
	 * @param descTipoErog the desc tipo erog
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereDescTipoErogEquals(String descTipoErog) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'FK_TIPO_IMPIANTO = :fkTipoImpianto'.
	 *
	 * @param fkTipoImpianto the fk tipo impianto
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereFkTipoImpiantoEquals(Integer fkTipoImpianto) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'DESC_TIPO_DISTRIB = :descTipoDistrib'.
	 *
	 * @param descTipoDistrib the desc tipo distrib
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereDescTipoDistribEquals(String descTipoDistrib) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'DESC_TIPO_REG = :descTipoReg'.
	 *
	 * @param descTipoReg the desc tipo reg
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereDescTipoRegEquals(String descTipoReg) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_TERMI_FOSSILE = :annTermiFossile'.
	 *
	 * @param annTermiFossile the ann termi fossile
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereAnnTermiFossileEquals(Double annTermiFossile) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_ELETT_FOSSILE = :annElettFossile'.
	 *
	 * @param annElettFossile the ann elett fossile
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereAnnElettFossileEquals(Double annElettFossile) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_TERMI_RINNO = :annTermiRinno'.
	 *
	 * @param annTermiRinno the ann termi rinno
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereAnnTermiRinnoEquals(Double annTermiRinno) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'ANN_ELETT_RINNO = :annElettRinno'.
	 *
	 * @param annElettRinno the ann elett rinno
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereAnnElettRinnoEquals(Double annElettRinno) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'COMPLESS_TERMICO = :complessTermico'.
	 *
	 * @param complessTermico the compless termico
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereComplessTermicoEquals(Double complessTermico) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'COMPLESS_ELETTRICO = :complessElettrico'.
	 *
	 * @param complessElettrico the compless elettrico
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereComplessElettricoEquals(Double complessElettrico) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'UI_SERVITE = :uiServite'.
	 *
	 * @param uiServite the ui servite
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereUiServiteEquals(String uiServite) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_T_CONSUMI_EDIFICIO table that match the criteria 'FLG_CONT_RIP = :flgContRip'.
	 *
	 * @param flgContRip the flg cont rip
	 * @return the list
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public List<SiceeTConsumiEdificio> findWhereFlgContRipEquals(String flgContRip) throws SiceeTConsumiEdificioDaoException;

	/**
	 * Returns the rows from the SICEE_T_CONSUMI_EDIFICIO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t consumi edificio
	 * @throws SiceeTConsumiEdificioDaoException the sicee t consumi edificio dao exception
	 */
	public SiceeTConsumiEdificio findByPrimaryKey(SiceeTConsumiEdificioPk pk) throws SiceeTConsumiEdificioDaoException;

}
