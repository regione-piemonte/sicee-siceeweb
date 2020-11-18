/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTFoto2015DaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTFoto2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTFoto2015Pk
	 */
	public SiceeTFoto2015Pk insert(SiceeTFoto2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_FOTO_2015 table.
	 */
	public void update(SiceeTFoto2015Pk pk, SiceeTFoto2015 dto) throws SiceeTFoto2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_FOTO_2015 table.
	 */
	public void delete(SiceeTFoto2015Pk pk) throws SiceeTFoto2015DaoException;

	/** 
	 * Deletes rows in the SICEE_T_FOTO_2015 table.
	 */
	public void deleteByPkCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTFoto2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_FOTO_2015 table.
	 */
	public void deleteByIdentificFoto(String identificFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_FOTO = :idFoto'.
	 */
	public SiceeTFoto2015 findByPrimaryKey(long idFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND FLG_PRINCIPALE = :flgPrincipale'.
	 */
	public List<SiceeTFoto2015> findBySiceeTCertificatoFlgPrincipale(String idCertificatore, String progrCertificato, String anno, String flgPrincipale) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTFoto2015> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTFoto2015DaoException;

	
	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria ''.
	 */
	public List<SiceeTFoto2015> findAll() throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'FK_TIPO_FOTO = :fkTipoFoto'.
	 */
	public List<SiceeTFoto2015> findBySiceeDTipoFoto2015(long fkTipoFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_FOTO = :idFoto'.
	 */
	public List<SiceeTFoto2015> findWhereIdFotoEquals(long idFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTFoto2015> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTFoto2015> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTFoto2015> findWhereAnnoEquals(String anno) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'IDENTIFIC_FOTO = :identificFoto'.
	 */
	public List<SiceeTFoto2015> findWhereIdentificFotoEquals(String identificFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'NOME_FOTO = :nomeFoto'.
	 */
	public List<SiceeTFoto2015> findWhereNomeFotoEquals(String nomeFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'DT_FOTO = :dtFoto'.
	 */
	public List<SiceeTFoto2015> findWhereDtFotoEquals(Date dtFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'FLG_PRINCIPALE = :flgPrincipale'.
	 */
	public List<SiceeTFoto2015> findWhereFlgPrincipaleEquals(String flgPrincipale) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_FOTO_2015 table that match the criteria 'FK_TIPO_FOTO = :fkTipoFoto'.
	 */
	public List<SiceeTFoto2015> findWhereFkTipoFotoEquals(long fkTipoFoto) throws SiceeTFoto2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_FOTO_2015 table that matches the specified primary-key value.
	 */
	public SiceeTFoto2015 findByPrimaryKey(SiceeTFoto2015Pk pk) throws SiceeTFoto2015DaoException;

}
