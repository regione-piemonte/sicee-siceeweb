/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTExportBoDaoException;
import java.util.Date;
import java.util.List;

public interface SiceeTExportBoDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTExportBoPk
	 */
	public SiceeTExportBoPk insert(SiceeTExportBo dto);

	/** 
	 * Updates a single row in the SICEE_T_EXPORT_BO table.
	 */
	public void update(SiceeTExportBoPk pk, SiceeTExportBo dto) throws SiceeTExportBoDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_EXPORT_BO table.
	 */
	public void delete(SiceeTExportBoPk pk) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO = :anno AND ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public SiceeTExportBo findByPrimaryKey(String anno, String idCertificatore, String progrCertificato) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_EDIFICIO = :fkEdificio'.
	 */
	public List<SiceeTExportBo> findWhereFkEdificioEquals(Integer fkEdificio) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria ''.
	 */
	public List<SiceeTExportBo> findAll() throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public List<SiceeTExportBo> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO = :anno'.
	 */
	public List<SiceeTExportBo> findWhereAnnoEquals(String anno) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTExportBo> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 */
	public List<SiceeTExportBo> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_STATO = :fkStato'.
	 */
	public List<SiceeTExportBo> findWhereFkStatoEquals(Integer fkStato) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DT_INIZIO = :dtInizio'.
	 */
	public List<SiceeTExportBo> findWhereDtInizioEquals(Date dtInizio) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DT_UPLOAD = :dtUpload'.
	 */
	public List<SiceeTExportBo> findWhereDtUploadEquals(Date dtUpload) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_PROV = :descProv'.
	 */
	public List<SiceeTExportBo> findWhereDescProvEquals(String descProv) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_PROV = :idProv'.
	 */
	public List<SiceeTExportBo> findWhereIdProvEquals(String idProv) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	public List<SiceeTExportBo> findWhereDescComuneEquals(String descComune) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	public List<SiceeTExportBo> findWhereIdComuneEquals(String idComune) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	public List<SiceeTExportBo> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	public List<SiceeTExportBo> findWhereNumCivicoEquals(String numCivico) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SEZIONE = :sezione'.
	 */
	public List<SiceeTExportBo> findWhereSezioneEquals(String sezione) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FOGLIO = :foglio'.
	 */
	public List<SiceeTExportBo> findWhereFoglioEquals(String foglio) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PARTICELLA = :particella'.
	 */
	public List<SiceeTExportBo> findWhereParticellaEquals(String particella) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUBALTERNO = :subalterno'.
	 */
	public List<SiceeTExportBo> findWhereSubalternoEquals(String subalterno) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'GRADI_GIORNO = :gradiGiorno'.
	 */
	public List<SiceeTExportBo> findWhereGradiGiornoEquals(Integer gradiGiorno) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PIANO = :piano'.
	 */
	public List<SiceeTExportBo> findWherePianoEquals(Integer piano) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'NUM_PIANI_COMPLESSIVI = :numPianiComplessivi'.
	 */
	public List<SiceeTExportBo> findWhereNumPianiComplessiviEquals(Integer numPianiComplessivi) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_DEST_USO = :fkDestUso'.
	 */
	public List<SiceeTExportBo> findWhereFkDestUsoEquals(Integer fkDestUso) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CARATT_EDIFICIO = :fkCarattEdificio'.
	 */
	public List<SiceeTExportBo> findWhereFkCarattEdificioEquals(Integer fkCarattEdificio) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DESC_TIPO_EDIFICIO = :descTipoEdificio'.
	 */
	public List<SiceeTExportBo> findWhereDescTipoEdificioEquals(String descTipoEdificio) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO_COSTRUZIONE = :annoCostruzione'.
	 */
	public List<SiceeTExportBo> findWhereAnnoCostruzioneEquals(Integer annoCostruzione) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ANNO_ULT_RIST = :annoUltRist'.
	 */
	public List<SiceeTExportBo> findWhereAnnoUltRistEquals(Integer annoUltRist) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'VOL_LORDO_RISCALDATO = :volLordoRiscaldato'.
	 */
	public List<SiceeTExportBo> findWhereVolLordoRiscaldatoEquals(Double volLordoRiscaldato) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUP_DISPERDENTE_TOT = :supDisperdenteTot'.
	 */
	public List<SiceeTExportBo> findWhereSupDisperdenteTotEquals(Double supDisperdenteTot) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SU = :su'.
	 */
	public List<SiceeTExportBo> findWhereSuEquals(Double su) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'V_SU = :vSu'.
	 */
	public List<SiceeTExportBo> findWhereVSuEquals(Double vSu) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FATTORE_FORMA = :fattoreForma'.
	 */
	public List<SiceeTExportBo> findWhereFattoreFormaEquals(Double fattoreForma) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'TRASM_OPACHE = :trasmOpache'.
	 */
	public List<SiceeTExportBo> findWhereTrasmOpacheEquals(Double trasmOpache) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'TRASM_TRASP = :trasmTrasp'.
	 */
	public List<SiceeTExportBo> findWhereTrasmTraspEquals(Double trasmTrasp) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_TIPO_IMPIANTO = :fkTipoImpianto'.
	 */
	public List<SiceeTExportBo> findWhereFkTipoImpiantoEquals(Integer fkTipoImpianto) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_COMBUSTIBILE_RISC = :fkCombustibileRisc'.
	 */
	public List<SiceeTExportBo> findWhereFkCombustibileRiscEquals(Integer fkCombustibileRisc) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_COMBUSTIBILE_ACS = :fkCombustibileAcs'.
	 */
	public List<SiceeTExportBo> findWhereFkCombustibileAcsEquals(Integer fkCombustibileAcs) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CLASSE = :fkClasse'.
	 */
	public List<SiceeTExportBo> findWhereFkClasseEquals(Integer fkClasse) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CLASSE_192_05 = :fkClasse19205'.
	 */
	public List<SiceeTExportBo> findWhereFkClasse19205Equals(Integer fkClasse19205) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_RISC_QH = :domRiscQh'.
	 */
	public List<SiceeTExportBo> findWhereDomRiscQhEquals(Double domRiscQh) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_RISC_QHTO = :domRiscQhto'.
	 */
	public List<SiceeTExportBo> findWhereDomRiscQhtoEquals(Double domRiscQhto) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_ACS_QHW = :domAcsQhw'.
	 */
	public List<SiceeTExportBo> findWhereDomAcsQhwEquals(Double domAcsQhw) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_ACS_QHWTO = :domAcsQhwto'.
	 */
	public List<SiceeTExportBo> findWhereDomAcsQhwtoEquals(Double domAcsQhwto) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_FABB_ACS = :flgFabbAcs'.
	 */
	public List<SiceeTExportBo> findWhereFlgFabbAcsEquals(String flgFabbAcs) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EN_ACS_RINNO = :enAcsRinno'.
	 */
	public List<SiceeTExportBo> findWhereEnAcsRinnoEquals(Double enAcsRinno) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'DOM_ACS_QHW_SU = :domAcsQhwSu'.
	 */
	public List<SiceeTExportBo> findWhereDomAcsQhwSuEquals(Double domAcsQhwSu) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_IMP_ETAG = :rendImpEtag'.
	 */
	public List<SiceeTExportBo> findWhereRendImpEtagEquals(Double rendImpEtag) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_ACS_ETAGACS = :rendAcsEtagacs'.
	 */
	public List<SiceeTExportBo> findWhereRendAcsEtagacsEquals(Double rendAcsEtagacs) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'VALORE_PREST_PDC = :valorePrestPdc'.
	 */
	public List<SiceeTExportBo> findWhereValorePrestPdcEquals(Double valorePrestPdc) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_RISC_EPI = :indRiscEpi'.
	 */
	public List<SiceeTExportBo> findWhereIndRiscEpiEquals(Double indRiscEpi) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_RISC_EPITO = :indRiscEpito'.
	 */
	public List<SiceeTExportBo> findWhereIndRiscEpitoEquals(Double indRiscEpito) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_FABB_MAX_INDICE = :flgFabbMaxIndice'.
	 */
	public List<SiceeTExportBo> findWhereFlgFabbMaxIndiceEquals(String flgFabbMaxIndice) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FABB_ACS = :fabbAcs'.
	 */
	public List<SiceeTExportBo> findWhereFabbAcsEquals(Double fabbAcs) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_GLOB_EPLORDO = :indGlobEplordo'.
	 */
	public List<SiceeTExportBo> findWhereIndGlobEplordoEquals(Double indGlobEplordo) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'IND_GLOB_EPLORDO_TO = :indGlobEplordoTo'.
	 */
	public List<SiceeTExportBo> findWhereIndGlobEplordoToEquals(Double indGlobEplordoTo) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_MOTIVO = :fkMotivo'.
	 */
	public List<SiceeTExportBo> findWhereFkMotivoEquals(Integer fkMotivo) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'METODOLOGIA_CALCOLO = :metodologiaCalcolo'.
	 */
	public List<SiceeTExportBo> findWhereMetodologiaCalcoloEquals(String metodologiaCalcolo) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SW_UTILIZZATO = :swUtilizzato'.
	 */
	public List<SiceeTExportBo> findWhereSwUtilizzatoEquals(String swUtilizzato) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'PRESTAZIONE_ENE = :prestazioneEne'.
	 */
	public List<SiceeTExportBo> findWherePrestazioneEneEquals(Double prestazioneEne) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'NUM_APPARTAMENTI = :numAppartamenti'.
	 */
	public List<SiceeTExportBo> findWhereNumAppartamentiEquals(Integer numAppartamenti) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'UI_SERVITE = :uiServite'.
	 */
	public List<SiceeTExportBo> findWhereUiServiteEquals(String uiServite) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'POT_RISCALDAMENTO = :potRiscaldamento'.
	 */
	public List<SiceeTExportBo> findWherePotRiscaldamentoEquals(Double potRiscaldamento) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FK_CLASSE_EFF_RISC = :fkClasseEffRisc'.
	 */
	public List<SiceeTExportBo> findWhereFkClasseEffRiscEquals(Integer fkClasseEffRisc) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'GEN_ANNO_RISC = :genAnnoRisc'.
	 */
	public List<SiceeTExportBo> findWhereGenAnnoRiscEquals(Integer genAnnoRisc) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_CONT_RIP = :flgContRip'.
	 */
	public List<SiceeTExportBo> findWhereFlgContRipEquals(String flgContRip) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_GENER = :rendGener'.
	 */
	public List<SiceeTExportBo> findWhereRendGenerEquals(Double rendGener) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_REGOL = :rendRegol'.
	 */
	public List<SiceeTExportBo> findWhereRendRegolEquals(Double rendRegol) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_EMISS = :rendEmiss'.
	 */
	public List<SiceeTExportBo> findWhereRendEmissEquals(Double rendEmiss) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'REND_DISTRIB = :rendDistrib'.
	 */
	public List<SiceeTExportBo> findWhereRendDistribEquals(Double rendDistrib) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_OLD = :flgOld'.
	 */
	public List<SiceeTExportBo> findWhereFlgOldEquals(String flgOld) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'FLG_EDIF_E0 = :flgEdifE0'.
	 */
	public List<SiceeTExportBo> findWhereFlgEdifE0Equals(String flgEdifE0) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EPGL_NREN_GLOBALE = :epglNrenGlobale'.
	 */
	public List<SiceeTExportBo> findWhereEpglNrenGlobaleEquals(Double epglNrenGlobale) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EPGL_REN_GLOBALE = :epglRenGlobale'.
	 */
	public List<SiceeTExportBo> findWhereEpglRenGlobaleEquals(Double epglRenGlobale) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EMISSIONI_CO2 = :emissioniCo2'.
	 */
	public List<SiceeTExportBo> findWhereEmissioniCo2Equals(Double emissioniCo2) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUP_RAFFRESCATA = :supRaffrescata'.
	 */
	public List<SiceeTExportBo> findWhereSupRaffrescataEquals(Double supRaffrescata) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'SUP_RISCALDATA = :supRiscaldata'.
	 */
	public List<SiceeTExportBo> findWhereSupRiscaldataEquals(Double supRiscaldata) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'VOL_LORDO_RAFFRESCATO = :volLordoRaffrescato'.
	 */
	public List<SiceeTExportBo> findWhereVolLordoRaffrescatoEquals(Double volLordoRaffrescato) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'EPH = :eph'.
	 */
	public List<SiceeTExportBo> findWhereEphEquals(Double eph) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'ASOL_ASUP = :asolAsup'.
	 */
	public List<SiceeTExportBo> findWhereAsolAsupEquals(Double asolAsup) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'YIE = :yie'.
	 */
	public List<SiceeTExportBo> findWhereYieEquals(Double yie) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'V_SU_RAFF = :vSuRaff'.
	 */
	public List<SiceeTExportBo> findWhereVSuRaffEquals(Double vSuRaff) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'V_SU_RISC = :vSuRisc'.
	 */
	public List<SiceeTExportBo> findWhereVSuRiscEquals(Double vSuRisc) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'S_V_RAFF = :sVRaff'.
	 */
	public List<SiceeTExportBo> findWhereSVRaffEquals(Double sVRaff) throws SiceeTExportBoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria 'S_V_RISC = :sVRisc'.
	 */
	public List<SiceeTExportBo> findWhereSVRiscEquals(Double sVRisc) throws SiceeTExportBoDaoException;

	/** 
	 * Returns the rows from the SICEE_T_EXPORT_BO table that matches the specified primary-key value.
	 */
	public SiceeTExportBo findByPrimaryKey(SiceeTExportBoPk pk) throws SiceeTExportBoDaoException;

}
