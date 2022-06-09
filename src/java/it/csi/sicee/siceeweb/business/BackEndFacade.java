package it.csi.sicee.siceeweb.business;

import java.util.*;

import it.csi.sicee.siceeweb.dto.*;

import org.apache.log4j.*;
import it.csi.sicee.siceeweb.util.*;

/*PROTECTED REGION ID(R-1534196706) ENABLED START*/
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.business.facade.ActivationMgr;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.facade.CertificatoreMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneAceMgr;
import it.csi.sicee.siceeweb.business.facade.TransazioneRegistrazMgr;

/*PROTECTED REGION END*/

public class BackEndFacade {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [labelValue, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUE_CODE = "appDatalabelValue";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	// ApplicationData: [isPulireTab, scope:USER_SESSION]
	public static final String APPDATA_ISPULIRETAB_CODE = "appDataisPulireTab";

	// ApplicationData: [idRigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDRIGASELEZIONATA_CODE = "appDataidRigaSelezionata";

	// ApplicationData: [idTipoDocumento, scope:USER_SESSION]
	public static final String APPDATA_IDTIPODOCUMENTO_CODE = "appDataidTipoDocumento";

	// ApplicationData: [listZoneClima, scope:USER_SESSION]
	public static final String APPDATA_LISTZONECLIMA_CODE = "appDatalistZoneClima";

	// ApplicationData: [idComuneZonaClima, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNEZONACLIMA_CODE = "appDataidComuneZonaClima";

	// ApplicationData: [descZonaClima, scope:USER_SESSION]
	public static final String APPDATA_DESCZONACLIMA_CODE = "appDatadescZonaClima";

	// ApplicationData: [documentoAggiuntivo, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTOAGGIUNTIVO_CODE = "appDatadocumentoAggiuntivo";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	// ApplicationData: [uidDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_UIDDOCUMENTOSELEZIONATO_CODE = "appDatauidDocumentoSelezionato";

	// ApplicationData: [filtroAce, scope:USER_ACTION]
	public static final String APPDATA_FILTROACE_CODE = "appDatafiltroAce";

	// ApplicationData: [certificatiInviati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATIINVIATI_CODE = "appDatacertificatiInviati";

	// ApplicationData: [codAceInviatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACEINVIATOSELEZIONATO_CODE = "appDatacodAceInviatoSelezionato";

	// ApplicationData: [codiciAceNuoviSelezionati, scope:USER_SESSION]
	public static final String APPDATA_CODICIACENUOVISELEZIONATI_CODE = "appDatacodiciAceNuoviSelezionati";

	// ApplicationData: [parametroDiRequest, scope:USER_ACTION]
	public static final String APPDATA_PARAMETRODIREQUEST_CODE = "appDataparametroDiRequest";

	// ApplicationData: [certificatiNuovi, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATINUOVI_CODE = "appDatacertificatiNuovi";

	// ApplicationData: [certificatiSostituiti, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATISOSTITUITI_CODE = "appDatacertificatiSostituiti";

	// ApplicationData: [listTipiDoc, scope:USER_SESSION]
	public static final String APPDATA_LISTTIPIDOC_CODE = "appDatalistTipiDoc";

	// ApplicationData: [numACEDesiderati, scope:USER_SESSION]
	public static final String APPDATA_NUMACEDESIDERATI_CODE = "appDatanumACEDesiderati";

	// ApplicationData: [chiaviAttestati, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTESTATI_CODE = "appDatachiaviAttestati";

	// ApplicationData: [attestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_ATTESTATOSELEZIONATO_CODE = "appDataattestatoSelezionato";

	// ApplicationData: [codAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATOSELEZIONATO_CODE = "appDatacodAttestatoSelezionato";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [chiaviCurriculum, scope:USER_SESSION]
	public static final String APPDATA_CHIAVICURRICULUM_CODE = "appDatachiaviCurriculum";

	// ApplicationData: [uidDaStampare, scope:USER_SESSION]
	public static final String APPDATA_UIDDASTAMPARE_CODE = "appDatauidDaStampare";

	// ApplicationData: [attestatiXml, scope:USER_SESSION]
	public static final String APPDATA_ATTESTATIXML_CODE = "appDataattestatiXml";

	// ApplicationData: [labelValueArray, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUEARRAY_CODE = "appDatalabelValueArray";

	// ApplicationData: [dichiarazioneAceSostitutivo, scope:USER_SESSION]
	public static final String APPDATA_DICHIARAZIONEACESOSTITUTIVO_CODE = "appDatadichiarazioneAceSostitutivo";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [regioni, scope:SAME_PAGE]
	public static final String APPDATA_REGIONI_CODE = "appDataregioni";

	// ApplicationData: [provinceRegione, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCEREGIONE_CODE = "appDataprovinceRegione";

	// ApplicationData: [comuniProvincia, scope:SAME_PAGE]
	public static final String APPDATA_COMUNIPROVINCIA_CODE = "appDatacomuniProvincia";

	// ApplicationData: [suggestIndirizzo, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZO_CODE = "appDatasuggestIndirizzo";

	// ApplicationData: [regioniRes, scope:SAME_PAGE]
	public static final String APPDATA_REGIONIRES_CODE = "appDataregioniRes";

	// ApplicationData: [provinceResRegione, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCERESREGIONE_CODE = "appDataprovinceResRegione";

	// ApplicationData: [comuniResProvincia, scope:SAME_PAGE]
	public static final String APPDATA_COMUNIRESPROVINCIA_CODE = "appDatacomuniResProvincia";

	// ApplicationData: [regioniStudio, scope:SAME_PAGE]
	public static final String APPDATA_REGIONISTUDIO_CODE = "appDataregioniStudio";

	// ApplicationData: [provinceStudioRegione, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCESTUDIOREGIONE_CODE = "appDataprovinceStudioRegione";

	// ApplicationData: [comuniStudioProvincia, scope:SAME_PAGE]
	public static final String APPDATA_COMUNISTUDIOPROVINCIA_CODE = "appDatacomuniStudioProvincia";

	// ApplicationData: [titoli, scope:USER_SESSION]
	public static final String APPDATA_TITOLI_CODE = "appDatatitoli";

	// ApplicationData: [provinceOrdinePiemonte, scope:SAME_PAGE]
	public static final String APPDATA_PROVINCEORDINEPIEMONTE_CODE = "appDataprovinceOrdinePiemonte";

	// ApplicationData: [flagAutocert, scope:USER_SESSION]
	public static final String APPDATA_FLAGAUTOCERT_CODE = "appDataflagAutocert";

	// ApplicationData: [flagDatiPers, scope:USER_SESSION]
	public static final String APPDATA_FLAGDATIPERS_CODE = "appDataflagDatiPers";

	// ApplicationData: [flagDatiPersCurriculum, scope:USER_SESSION]
	public static final String APPDATA_FLAGDATIPERSCURRICULUM_CODE = "appDataflagDatiPersCurriculum";

	// ApplicationData: [cerificatore, scope:USER_SESSION]
	public static final String APPDATA_CERIFICATORE_CODE = "appDatacerificatore";

	// ApplicationData: [mailVerifica, scope:USER_SESSION]
	public static final String APPDATA_MAILVERIFICA_CODE = "appDatamailVerifica";

	// ApplicationData: [flgEsitoVerifica, scope:USER_SESSION]
	public static final String APPDATA_FLGESITOVERIFICA_CODE = "appDataflgEsitoVerifica";

	// ApplicationData: [authVerify, scope:USER_SESSION]
	public static final String APPDATA_AUTHVERIFY_CODE = "appDataauthVerify";

	// ApplicationData: [chiaviAttPartReg, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTREG_CODE = "appDatachiaviAttPartReg";

	// ApplicationData: [chiaviAttPartProfittoReg, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTPROFITTOREG_CODE = "appDatachiaviAttPartProfittoReg";

	// ApplicationData: [chiaviAttPartProfittoNaz, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTPROFITTONAZ_CODE = "appDatachiaviAttPartProfittoNaz";

	// ApplicationData: [tipoIstruzione, scope:USER_SESSION]
	public static final String APPDATA_TIPOISTRUZIONE_CODE = "appDatatipoIstruzione";

	// ApplicationData: [codiceIstruzione, scope:USER_SESSION]
	public static final String APPDATA_CODICEISTRUZIONE_CODE = "appDatacodiceIstruzione";

	// ApplicationData: [chiaviAttPartOld, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTOLD_CODE = "appDatachiaviAttPartOld";

	// ApplicationData: [chiaviAttPartNew, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTNEW_CODE = "appDatachiaviAttPartNew";

	// ApplicationData: [idCorsoSelected, scope:USER_SESSION]
	public static final String APPDATA_IDCORSOSELECTED_CODE = "appDataidCorsoSelected";

	// ApplicationData: [chiaviTitoloStudio, scope:USER_SESSION]
	public static final String APPDATA_CHIAVITITOLOSTUDIO_CODE = "appDatachiaviTitoloStudio";

	// ApplicationData: [mdpURL, scope:USER_SESSION]
	public static final String APPDATA_MDPURL_CODE = "appDatamdpURL";

	// ApplicationData: [datiPagamento, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTO_CODE = "appDatadatiPagamento";

	// ApplicationData: [switchPagamento, scope:USER_SESSION]
	public static final String APPDATA_SWITCHPAGAMENTO_CODE = "appDataswitchPagamento";

	// ApplicationData: [msgPagamento, scope:SAME_PAGE]
	public static final String APPDATA_MSGPAGAMENTO_CODE = "appDatamsgPagamento";

	// ApplicationData: [msgDuplicaAce, scope:SAME_PAGE]
	public static final String APPDATA_MSGDUPLICAACE_CODE = "appDatamsgDuplicaAce";

	// ApplicationData: [msgEsitoTransazione, scope:USER_ACTION]
	public static final String APPDATA_MSGESITOTRANSAZIONE_CODE = "appDatamsgEsitoTransazione";

	// ApplicationData: [msgEsitoVerificaMail, scope:USER_SESSION]
	public static final String APPDATA_MSGESITOVERIFICAMAIL_CODE = "appDatamsgEsitoVerificaMail";

	// ApplicationData: [valoreMsgBlocco, scope:USER_SESSION]
	public static final String APPDATA_VALOREMSGBLOCCO_CODE = "appDatavaloreMsgBlocco";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [mdpNewURL, scope:USER_SESSION]
	public static final String APPDATA_MDPNEWURL_CODE = "appDatamdpNewURL";

	// ApplicationData: [provinceCertDTCat, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTDTCAT_CODE = "appDataprovinceCertDTCat";

	// ApplicationData: [comuniCertDtCat, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDTCAT_CODE = "appDatacomuniCertDtCat";

	// ApplicationData: [provinceCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTPROGETTISTA_CODE = "appDataprovinceCertProgettista";

	// ApplicationData: [comuniCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTPROGETTISTA_CODE = "appDatacomuniCertProgettista";

	// ApplicationData: [regioniCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_REGIONICERTPROGETTISTA_CODE = "appDataregioniCertProgettista";

	// ApplicationData: [provinceCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTDIRLAV_CODE = "appDataprovinceCertDirLav";

	// ApplicationData: [comuniCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDIRLAV_CODE = "appDatacomuniCertDirLav";

	// ApplicationData: [regioniCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_REGIONICERTDIRLAV_CODE = "appDataregioniCertDirLav";

	// ApplicationData: [provinceCertCostr, scope:USER_SESSION]
	public static final String APPDATA_PROVINCECERTCOSTR_CODE = "appDataprovinceCertCostr";

	// ApplicationData: [comuniCertCostr, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTCOSTR_CODE = "appDatacomuniCertCostr";

	// ApplicationData: [regioniCertCostr, scope:USER_SESSION]
	public static final String APPDATA_REGIONICERTCOSTR_CODE = "appDataregioniCertCostr";

	// ApplicationData: [tipologieImmobili, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIEIMMOBILI_CODE = "appDatatipologieImmobili";

	// ApplicationData: [destinazioniUso, scope:USER_SESSION]
	public static final String APPDATA_DESTINAZIONIUSO_CODE = "appDatadestinazioniUso";

	// ApplicationData: [tipiEdificio, scope:USER_SESSION]
	public static final String APPDATA_TIPIEDIFICIO_CODE = "appDatatipiEdificio";

	// ApplicationData: [carattEdificio, scope:USER_SESSION]
	public static final String APPDATA_CARATTEDIFICIO_CODE = "appDatacarattEdificio";

	// ApplicationData: [classiEnergetiche, scope:USER_SESSION]
	public static final String APPDATA_CLASSIENERGETICHE_CODE = "appDataclassiEnergetiche";

	// ApplicationData: [sistemi, scope:USER_SESSION]
	public static final String APPDATA_SISTEMI_CODE = "appDatasistemi";

	// ApplicationData: [motiviRilascio, scope:USER_SESSION]
	public static final String APPDATA_MOTIVIRILASCIO_CODE = "appDatamotiviRilascio";

	// ApplicationData: [serviziEnergia, scope:USER_SESSION]
	public static final String APPDATA_SERVIZIENERGIA_CODE = "appDataserviziEnergia";

	// ApplicationData: [oggettiApeLista, scope:USER_SESSION]
	public static final String APPDATA_OGGETTIAPELISTA_CODE = "appDataoggettiApeLista";

	// ApplicationData: [tipiRedazione, scope:USER_SESSION]
	public static final String APPDATA_TIPIREDAZIONE_CODE = "appDatatipiRedazione";

	// ApplicationData: [dichiarazioni, scope:USER_SESSION]
	public static final String APPDATA_DICHIARAZIONI_CODE = "appDatadichiarazioni";

	// ApplicationData: [tipiCombustibileRiscaldamento, scope:USER_SESSION]
	public static final String APPDATA_TIPICOMBUSTIBILERISCALDAMENTO_CODE = "appDatatipiCombustibileRiscaldamento";

	// ApplicationData: [tipiCombustibileAcquaCalda, scope:USER_SESSION]
	public static final String APPDATA_TIPICOMBUSTIBILEACQUACALDA_CODE = "appDatatipiCombustibileAcquaCalda";

	// ApplicationData: [tipiImpianto, scope:USER_SESSION]
	public static final String APPDATA_TIPIIMPIANTO_CODE = "appDatatipiImpianto";

	// ApplicationData: [tipiTermErogaz, scope:USER_SESSION]
	public static final String APPDATA_TIPITERMEROGAZ_CODE = "appDatatipiTermErogaz";

	// ApplicationData: [tipiDistrib, scope:USER_SESSION]
	public static final String APPDATA_TIPIDISTRIB_CODE = "appDatatipiDistrib";

	// ApplicationData: [tipiRegolazione, scope:USER_SESSION]
	public static final String APPDATA_TIPIREGOLAZIONE_CODE = "appDatatipiRegolazione";

	// ApplicationData: [tempDichiarazSelez, scope:USER_SESSION]
	public static final String APPDATA_TEMPDICHIARAZSELEZ_CODE = "appDatatempDichiarazSelez";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [suggestIndirizzoDtCat, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZODTCAT_CODE = "appDatasuggestIndirizzoDtCat";

	// ApplicationData: [suggestIndirizzoCertCostr, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCERTCOSTR_CODE = "appDatasuggestIndirizzoCertCostr";

	// ApplicationData: [suggestIndirizzoCertDirLav, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCERTDIRLAV_CODE = "appDatasuggestIndirizzoCertDirLav";

	// ApplicationData: [suggestIndirizzoCertProgettista, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCERTPROGETTISTA_CODE = "appDatasuggestIndirizzoCertProgettista";

	// ApplicationData: [raccomandazioneSelezionata, scope:SAME_PAGE]
	public static final String APPDATA_RACCOMANDAZIONESELEZIONATA_CODE = "appDataraccomandazioneSelezionata";

	// ApplicationData: [qualitaInvolucro, scope:SAME_PAGE]
	public static final String APPDATA_QUALITAINVOLUCRO_CODE = "appDataqualitaInvolucro";

	// ApplicationData: [classiEfficienzaEnergetiche, scope:SAME_PAGE]
	public static final String APPDATA_CLASSIEFFICIENZAENERGETICHE_CODE = "appDataclassiEfficienzaEnergetiche";

	// ApplicationData: [tempRaccomandazioni, scope:USER_SESSION]
	public static final String APPDATA_TEMPRACCOMANDAZIONI_CODE = "appDatatempRaccomandazioni";

	// ApplicationData: [xmlResult, scope:USER_SESSION]
	public static final String APPDATA_XMLRESULT_CODE = "appDataxmlResult";

	// ApplicationData: [esitoImportaXml, scope:USER_ACTION]
	public static final String APPDATA_ESITOIMPORTAXML_CODE = "appDataesitoImportaXml";

	// ApplicationData: [certificatoXml, scope:SAME_PAGE]
	public static final String APPDATA_CERTIFICATOXML_CODE = "appDatacertificatoXml";

	// ApplicationData: [isImportaDati, scope:USER_SESSION]
	public static final String APPDATA_ISIMPORTADATI_CODE = "appDataisImportaDati";

	// ApplicationData: [datoCatastaleSelezionato, scope:SAME_PAGE]
	public static final String APPDATA_DATOCATASTALESELEZIONATO_CODE = "appDatadatoCatastaleSelezionato";

	// ApplicationData: [tempDtCatastaliSecondari, scope:USER_SESSION]
	public static final String APPDATA_TEMPDTCATASTALISECONDARI_CODE = "appDatatempDtCatastaliSecondari";

	// ApplicationData: [comuniCertDtCatSecondari, scope:USER_SESSION]
	public static final String APPDATA_COMUNICERTDTCATSECONDARI_CODE = "appDatacomuniCertDtCatSecondari";

	// ApplicationData: [suggestIndirizzoCodCostr, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODCOSTR_CODE = "appDatasuggestIndirizzoCodCostr";

	// ApplicationData: [suggestIndirizzoCodDirLav, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODDIRLAV_CODE = "appDatasuggestIndirizzoCodDirLav";

	// ApplicationData: [suggestIndirizzoCodProgettista, scope:USER_SESSION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODPROGETTISTA_CODE = "appDatasuggestIndirizzoCodProgettista";

	// ApplicationData: [suggestIndirizzoCode, scope:USER_ACTION]
	public static final String APPDATA_SUGGESTINDIRIZZOCODE_CODE = "appDatasuggestIndirizzoCode";

	// ApplicationData: [fotoSelezionata, scope:USER_SESSION]
	public static final String APPDATA_FOTOSELEZIONATA_CODE = "appDatafotoSelezionata";

	// ApplicationData: [tipoFoto, scope:USER_SESSION]
	public static final String APPDATA_TIPOFOTO_CODE = "appDatatipoFoto";

	// ApplicationData: [tipoFotoSel, scope:USER_SESSION]
	public static final String APPDATA_TIPOFOTOSEL_CODE = "appDatatipoFotoSel";

	// ApplicationData: [tipoFotoAltreSel, scope:USER_SESSION]
	public static final String APPDATA_TIPOFOTOALTRESEL_CODE = "appDatatipoFotoAltreSel";

	// ApplicationData: [visuraRicerca, scope:USER_SESSION]
	public static final String APPDATA_VISURARICERCA_CODE = "appDatavisuraRicerca";

	// ApplicationData: [visuraImpiantoList, scope:USER_SESSION]
	public static final String APPDATA_VISURAIMPIANTOLIST_CODE = "appDatavisuraImpiantoList";

	// ApplicationData: [visuraRifCatastaleList, scope:USER_SESSION]
	public static final String APPDATA_VISURARIFCATASTALELIST_CODE = "appDatavisuraRifCatastaleList";

	// ApplicationData: [visuraRappControlloList, scope:USER_SESSION]
	public static final String APPDATA_VISURARAPPCONTROLLOLIST_CODE = "appDatavisuraRappControlloList";

	// ApplicationData: [visuraImpianto, scope:USER_SESSION]
	public static final String APPDATA_VISURAIMPIANTO_CODE = "appDatavisuraImpianto";

	// ApplicationData: [visuraCodImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_VISURACODIMPIANTOSELEZ_CODE = "appDatavisuraCodImpiantoSelez";

	// ApplicationData: [visuraUidLibrettoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_VISURAUIDLIBRETTODASTAMPARE_CODE = "appDatavisuraUidLibrettoDaStampare";

	// ApplicationData: [tipoRistrutt, scope:USER_SESSION]
	public static final String APPDATA_TIPORISTRUTT_CODE = "appDatatipoRistrutt";

	// ApplicationData: [tipolEdilizia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLEDILIZIA_CODE = "appDatatipolEdilizia";

	// ApplicationData: [tipolCostrutt, scope:USER_SESSION]
	public static final String APPDATA_TIPOLCOSTRUTT_CODE = "appDatatipolCostrutt";

	// ApplicationData: [proprEdificio, scope:USER_SESSION]
	public static final String APPDATA_PROPREDIFICIO_CODE = "appDataproprEdificio";

	// ApplicationData: [listaCf, scope:USER_SESSION]
	public static final String APPDATA_LISTACF_CODE = "appDatalistaCf";

	// ApplicationData: [cfSel, scope:USER_SESSION]
	public static final String APPDATA_CFSEL_CODE = "appDatacfSel";

	// ApplicationData: [rifCatasto, scope:USER_SESSION]
	public static final String APPDATA_RIFCATASTO_CODE = "appDatarifCatasto";

	// ApplicationData: [transazioneRegistrazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEREGISTRAZIONE_CODE = "appDatatransazioneRegistrazione";

	// ApplicationData: [transazioneAce, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEACE_CODE = "appDatatransazioneAce";

	// ApplicationData: [idTransazione, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONE_CODE = "appDataidTransazione";

	// ApplicationData: [transazioneCredito, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONECREDITO_CODE = "appDatatransazioneCredito";

	// ApplicationData: [tipoRicercaTransazioniNew, scope:USER_SESSION]
	public static final String APPDATA_TIPORICERCATRANSAZIONINEW_CODE = "appDatatipoRicercaTransazioniNew";

	// ApplicationData: [codRicercaTransazioniNewSelez, scope:USER_SESSION]
	public static final String APPDATA_CODRICERCATRANSAZIONINEWSELEZ_CODE = "appDatacodRicercaTransazioniNewSelez";

	// ApplicationData: [province, scope:USER_ACTION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_ACTION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [datiAnnullamento, scope:USER_SESSION]
	public static final String APPDATA_DATIANNULLAMENTO_CODE = "appDatadatiAnnullamento";

	// ApplicationData: [motiviAnnullamento, scope:USER_SESSION]
	public static final String APPDATA_MOTIVIANNULLAMENTO_CODE = "appDatamotiviAnnullamento";

	// ApplicationData: [certificatiTrovati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATITROVATI_CODE = "appDatacertificatiTrovati";

	// ApplicationData: [codiciCertificatiSelezionati, scope:USER_SESSION]
	public static final String APPDATA_CODICICERTIFICATISELEZIONATI_CODE = "appDatacodiciCertificatiSelezionati";

	// ApplicationData: [idTipoRicAnnullametoSost, scope:USER_SESSION]
	public static final String APPDATA_IDTIPORICANNULLAMETOSOST_CODE = "appDataidTipoRicAnnullametoSost";

	// ApplicationData: [isPrimoIngresso, scope:USER_SESSION]
	public static final String APPDATA_ISPRIMOINGRESSO_CODE = "appDataisPrimoIngresso";

	// ApplicationData: [codiceCertificatoDaSostituireSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICECERTIFICATODASOSTITUIRESELEZIONATO_CODE = "appDatacodiceCertificatoDaSostituireSelezionato";

	// ApplicationData: [codiceCertificatoSostitutivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICECERTIFICATOSOSTITUTIVOSELEZIONATO_CODE = "appDatacodiceCertificatoSostitutivoSelezionato";

	// ApplicationData: [carrelloAceOld, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACEOLD_CODE = "appDatacarrelloAceOld";

	// ApplicationData: [carrelloAceNew, scope:USER_SESSION]
	public static final String APPDATA_CARRELLOACENEW_CODE = "appDatacarrelloAceNew";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [titoliMonitoraggio, scope:USER_ACTION]
	public static final String APPDATA_TITOLIMONITORAGGIO_CODE = "appDatatitoliMonitoraggio";

	// ApplicationData: [provinceMonitoraggio, scope:USER_ACTION]
	public static final String APPDATA_PROVINCEMONITORAGGIO_CODE = "appDataprovinceMonitoraggio";

	// ApplicationData: [indirizziMonitoraggio, scope:USER_ACTION]
	public static final String APPDATA_INDIRIZZIMONITORAGGIO_CODE = "appDataindirizziMonitoraggio";

	// ApplicationData: [aceMonitoraggio, scope:USER_SESSION]
	public static final String APPDATA_ACEMONITORAGGIO_CODE = "appDataaceMonitoraggio";

	// ApplicationData: [codiceAttestatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODICEATTESTATOSELEZIONATO_CODE = "appDatacodiceAttestatoSelezionato";

	// ApplicationData: [gestoriPagamento, scope:USER_SESSION]
	public static final String APPDATA_GESTORIPAGAMENTO_CODE = "appDatagestoriPagamento";

	// ApplicationData: [idGestorePagamento, scope:USER_ACTION]
	public static final String APPDATA_IDGESTOREPAGAMENTO_CODE = "appDataidGestorePagamento";

	// ApplicationData: [transazione, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONE_CODE = "appDatatransazione";

	// ApplicationData: [numeroTransazione, scope:USER_SESSION]
	public static final String APPDATA_NUMEROTRANSAZIONE_CODE = "appDatanumeroTransazione";

	// ApplicationData: [valoreCreditoFinale, scope:USER_SESSION]
	public static final String APPDATA_VALORECREDITOFINALE_CODE = "appDatavaloreCreditoFinale";

	// ApplicationData: [datiPagamentoNew, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTONEW_CODE = "appDatadatiPagamentoNew";

	// ApplicationData: [gestioneCreditoNew, scope:USER_SESSION]
	public static final String APPDATA_GESTIONECREDITONEW_CODE = "appDatagestioneCreditoNew";

	// ApplicationData: [datiPagamentoNewList, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTONEWLIST_CODE = "appDatadatiPagamentoNewList";

	// ApplicationData: [statiTransazioneMdpNew, scope:USER_SESSION]
	public static final String APPDATA_STATITRANSAZIONEMDPNEW_CODE = "appDatastatiTransazioneMdpNew";

	// ApplicationData: [idStatoTransazioneMdpNewSelez, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOTRANSAZIONEMDPNEWSELEZ_CODE = "appDataidStatoTransazioneMdpNewSelez";

	// ApplicationData: [idDatiPagamentoNewSelez, scope:USER_SESSION]
	public static final String APPDATA_IDDATIPAGAMENTONEWSELEZ_CODE = "appDataidDatiPagamentoNewSelez";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	/// - i metodi relativi a menu e azioni di inizializzazione sono direttamente 
	///   implementati in questa classe
	/// - i metodi relativi ai singoli content panel sono delegati nei rispettivi
	///   bean
	//////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaPagamentoACE utilizzato in un ExecCommand
	 * del ContentPanel cpPrenotazAttestati
	 */
	public ExecResults preparaPagamentoACE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpPrenotazAttestatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPrenotazAttestati
		return getCPBECpPrenotazAttestati().preparaPagamentoACE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ottieniValoreCreditoFinale utilizzato in un ExecCommand
	 * del ContentPanel cpPrenotazAttestati
	 */
	public ExecResults ottieniValoreCreditoFinale(

			it.csi.sicee.siceeweb.dto.gestattestati.CpPrenotazAttestatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPrenotazAttestati
		return getCPBECpPrenotazAttestati().ottieniValoreCreditoFinale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaScaricoModulo utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaScaricoModulo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaImportaXml utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaImportaXml(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaImportaXml(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaReConsolidaAPE utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaReConsolidaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaReConsolidaAPE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaReInizializzaAPE utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaReInizializzaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaReInizializzaAPE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaEditAttestatoOld utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaEditAttestatoOld(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaEditAttestatoOld(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaEditAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaEditAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaEditAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaAperturaDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaAperturaDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaAperturaDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo invioCertificato utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults invioCertificato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().invioCertificato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaAce utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults stampaAce(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().stampaAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaReport utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().stampaReport(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaVisuraCIT utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults preparaVisuraCIT(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().preparaVisuraCIT(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo reInizializzaAPE utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults reInizializzaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().reInizializzaAPE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo reConsolidaAPE utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults reConsolidaAPE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().reConsolidaAPE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaAttestati utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults initListaAttestati(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().initListaAttestati(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchPulsanteScaricaMod utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults switchPulsanteScaricaMod(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().switchPulsanteScaricaMod(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo aggiornaDatiPagina utilizzato in un ExecCommand
	 * del ContentPanel cpGestCertificazioni
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestCertificazioni
		return getCPBECpGestCertificazioni().aggiornaDatiPagina(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaDownloadDocumento utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaDownloadDocumento(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().preparaDownloadDocumento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaInserisciDocumento utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaInserisciDocumento(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().preparaInserisciDocumento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaEliminaDocumento utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaEliminaDocumento(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().preparaEliminaDocumento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo jumpBackDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults jumpBackDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().jumpBackDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults eliminaDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().eliminaDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaDocumentazione utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults initListaDocumentazione(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().initListaDocumentazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo uploadDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpUploadDocAggiuntiva
	 */
	public ExecResults uploadDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpUploadDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpUploadDocAggiuntiva
		return getCPBECpUploadDocAggiuntiva().uploadDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaTipiDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpUploadDocAggiuntiva
	 */
	public ExecResults initListaTipiDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpUploadDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpUploadDocAggiuntiva
		return getCPBECpUploadDocAggiuntiva().initListaTipiDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaACEInviatiByCodice utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceInviati
	 */
	public ExecResults ricercaACEInviatiByCodice(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceInviati
		return getCPBECpRicercaAceInviati().ricercaACEInviatiByCodice(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaFromTavt utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceInviati
	 */
	public ExecResults setProvinciaFromTavt(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceInviati
		return getCPBECpRicercaAceInviati().setProvinciaFromTavt(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneFromTavt utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceInviati
	 */
	public ExecResults setComuneFromTavt(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceInviati
		return getCPBECpRicercaAceInviati().setComuneFromTavt(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAceByFiltro utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceInviati
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceInviati
		return getCPBECpRicercaAceInviati().ricercaAceByFiltro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeoPerRicerca utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceInviati
	 */
	public ExecResults gestisciComboGeoPerRicerca(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceInviati
		return getCPBECpRicercaAceInviati().gestisciComboGeoPerRicerca(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo precaricaFiltroRicercaACE utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceInviati
	 */
	public ExecResults precaricaFiltroRicercaACE(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRicercaAceInviatiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceInviati
		return getCPBECpRicercaAceInviati().precaricaFiltroRicercaACE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaScaricoModulo utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().preparaScaricoModulo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo vediACESostituiti utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults vediACESostituiti(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().vediACESostituiti(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaACENuovi utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults ricercaACENuovi(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().ricercaACENuovi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaReport utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().stampaReport(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults visualizzaAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().visualizzaAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaAperturaDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults preparaAperturaDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().preparaAperturaDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchPulsantiStampaDuplica utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults switchPulsantiStampaDuplica(

			it.csi.sicee.siceeweb.dto.gestattestati.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().switchPulsantiStampaDuplica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo invioAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpGestInvioCertificato
	 */
	public ExecResults invioAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCertificatoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestInvioCertificato
		return getCPBECpGestInvioCertificato().invioAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroInvioCert utilizzato in un ExecCommand
	 * del ContentPanel cpGestInvioCertificato
	 */
	public ExecResults indietroInvioCert(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCertificatoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestInvioCertificato
		return getCPBECpGestInvioCertificato().indietroInvioCert(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo invioAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpGestInvioCurriculum
	 */
	public ExecResults invioAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCurriculumModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestInvioCurriculum
		return getCPBECpGestInvioCurriculum().invioAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaCurriculumVitae utilizzato in un ExecCommand
	 * del ContentPanel cpGestInvioCurriculum
	 */
	public ExecResults scaricaCurriculumVitae(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCurriculumModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestInvioCurriculum
		return getCPBECpGestInvioCurriculum().scaricaCurriculumVitae(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaCurriculum utilizzato in un ExecCommand
	 * del ContentPanel cpGestInvioCurriculum
	 */
	public ExecResults initListaCurriculum(

			it.csi.sicee.siceeweb.dto.gestattestati.CpGestInvioCurriculumModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestInvioCurriculum
		return getCPBECpGestInvioCurriculum().initListaCurriculum(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDuplicaAceAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpDuplicaAce
	 */
	public ExecResults bDuplicaAceAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDuplicaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDuplicaAce
		return getCPBECpDuplicaAce().bDuplicaAceAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaAttestatiNuovi utilizzato in un ExecCommand
	 * del ContentPanel cpDuplicaAce
	 */
	public ExecResults initListaAttestatiNuovi(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDuplicaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDuplicaAce
		return getCPBECpDuplicaAce().initListaAttestatiNuovi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietro utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioAttestato
	 */
	public ExecResults indietro(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDettaglioAttestatoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioAttestato
		return getCPBECpDettaglioAttestato().indietro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaDettaglioAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioAttestato
	 */
	public ExecResults visualizzaDettaglioAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDettaglioAttestatoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioAttestato
		return getCPBECpDettaglioAttestato().visualizzaDettaglioAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setComuneDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setComuneDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzoDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().verificaIndirizzoDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo svuotaComboDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults svuotaComboDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().svuotaComboDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo svuotaIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults svuotaIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().svuotaIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastaliSecondario utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaDtCatastaliSecondario(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setProvinciaDtCatastaliSecondario(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addDatoCatastale utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults addDatoCatastale(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().addDatoCatastale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo deleteDatoCatastale utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults deleteDatoCatastale(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().deleteDatoCatastale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroDatiCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults indietroDatiCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().indietroDatiCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo controlloIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults controlloIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().controlloIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtCatastaliAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtCatastaliAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtCatastaliAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneProgettista utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setRegioneProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setRegioneProgettista(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaProgettista utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setProvinciaProgettista(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneProgettista utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setComuneProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setComuneProgettista(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzoProgettista utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().verificaIndirizzoProgettista(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scegliIndirizzoProgettista utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults scegliIndirizzoProgettista(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().scegliIndirizzoProgettista(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneDirLav utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setRegioneDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setRegioneDirLav(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDirLav utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setProvinciaDirLav(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneDirLav utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setComuneDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setComuneDirLav(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzoDirLav utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().verificaIndirizzoDirLav(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scegliIndirizzoDirLav utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults scegliIndirizzoDirLav(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().scegliIndirizzoDirLav(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneCostr utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setRegioneCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setRegioneCostr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaCostr utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setProvinciaCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setProvinciaCostr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneCostr utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults setComuneCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().setComuneCostr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzoCostr utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults verificaIndirizzoCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().verificaIndirizzoCostr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scegliIndirizzoCostr utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults scegliIndirizzoCostr(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().scegliIndirizzoCostr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtResponsAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtResponsAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtResponsAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtAnagCoCertificatoreSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtAnagCoCertificatoreSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtAnagCoCertificatoreSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboTipoImpianto utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults gestisciComboTipoImpianto(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().gestisciComboTipoImpianto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtTecniciCalcola utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtTecniciCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtTecniciCalcola(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtTecniciAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtTecniciAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtTecniciAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFabbisognoCalcola utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtFabbisognoCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtFabbisognoCalcola(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFabbisognoAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtFabbisognoAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtFabbisognoAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtLocRealeCalcola utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocRealeCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtLocRealeCalcola(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtLocRealeAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocRealeAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtLocRealeAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtLocTeorCalcola utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocTeorCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtLocTeorCalcola(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtLocTeoricaAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtLocTeoricaAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtLocTeoricaAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFontiRinnovCalcola utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtFontiRinnovCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtFontiRinnovCalcola(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFontiRinnovAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtFontiRinnovAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtFontiRinnovAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtAltriGeneraliAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriGeneraliAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtAltriGeneraliAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addRaccomandazione utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults addRaccomandazione(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().addRaccomandazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo deleteRaccomandazione utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults deleteRaccomandazione(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().deleteRaccomandazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtAltriRaccomandAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriRaccomandAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtAltriRaccomandAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtAltriEnergAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriEnergAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtAltriEnergAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtAltriSopralluoghiAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtAltriSopralluoghiAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtAltriSopralluoghiAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtNormativeVigente utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtNormativeVigente(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtNormativeVigente(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ripulisciCampi utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults ripulisciCampi(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().ripulisciCampi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtNormativeAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtNormativeAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtNormativeAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtLimNormRegImpTermToCalcola utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtLimNormRegImpTermToCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtLimNormRegImpTermToCalcola(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtRiscaldamentoAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtRiscaldamentoAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtRiscaldamentoAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtAcquaCaldaAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtAcquaCaldaAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtAcquaCaldaAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtEmissGasAndSuperfBoscoCalcola utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtEmissGasAndSuperfBoscoCalcola(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtEmissGasAndSuperfBoscoCalcola(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtGasSerraAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtGasSerraAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtGasSerraAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtConsumiAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtConsumiAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtConsumiAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtDichiarazAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtDichiarazAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtDichiarazAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFotoCarica utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtFotoCarica(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtFotoCarica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFotoAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults bDtFotoAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().bDtFotoAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaBozza utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults stampaBozza(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().stampaBozza(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaDefinitivo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults stampaDefinitivo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().stampaDefinitivo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo tornaAllaHome utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults tornaAllaHome(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().tornaAllaHome(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchScreenState utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().switchScreenState(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisibComboImpDatiTecnici utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults gestisciVisibComboImpDatiTecnici(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().gestisciVisibComboImpDatiTecnici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisibFabbisognoAcquaCalda utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults gestisciVisibFabbisognoAcquaCalda(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().gestisciVisibFabbisognoAcquaCalda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciBottoneStampaDefinitiva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults gestisciBottoneStampaDefinitiva(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().gestisciBottoneStampaDefinitiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().gestisciComboGeo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo isEdificioPerformante utilizzato in un ExecCommand
	 * del ContentPanel cpCompilaz
	 */
	public ExecResults isEdificioPerformante(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilaz
		return getCPBECpCompilaz().isEdificioPerformante(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaXml utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults caricaXml(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().caricaXml(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults setComuneDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().setComuneDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eseguiCalcoli utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults eseguiCalcoli(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().eseguiCalcoli(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eseguiAnnulla utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults eseguiAnnulla(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().eseguiAnnulla(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo importaXml utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults importaXml(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().importaXml(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeo utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().gestisciComboGeo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchScreenState utilizzato in un ExecCommand
	 * del ContentPanel cpImportaXml
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestati.CpImportaXmlModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImportaXml
		return getCPBECpImportaXml().switchScreenState(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults setComuneDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().setComuneDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzoDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults verificaIndirizzoDtCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().verificaIndirizzoDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo svuotaIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults svuotaIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().svuotaIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo cercaCoordinate utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults cercaCoordinate(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().cercaCoordinate(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo motivazioneChanged utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults motivazioneChanged(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().motivazioneChanged(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaListaCf utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults caricaListaCf(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().caricaListaCf(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo copiaDatiCoCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults copiaDatiCoCertificatore(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().copiaDatiCoCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo controlloIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults controlloIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().controlloIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtCatastaliAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults bDtCatastaliAvantiSalva(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().bDtCatastaliAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaDatiGenerali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults salvaDatiGenerali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().salvaDatiGenerali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtSalvaDataSopralluogo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults bDtSalvaDataSopralluogo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().bDtSalvaDataSopralluogo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFotoElimina utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults bDtFotoElimina(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().bDtFotoElimina(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFotoCarica utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults bDtFotoCarica(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().bDtFotoCarica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtFotoCaricaAltre utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults bDtFotoCaricaAltre(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().bDtFotoCaricaAltre(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo invioCertificato utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults invioCertificato(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().invioCertificato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo consolidaCertificato utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults consolidaCertificato(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().consolidaCertificato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo modificaApe utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults modificaApe(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().modificaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaApe utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults stampaApe(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().stampaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaApe utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults verificaApe(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().verificaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaAperturaDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults preparaAperturaDocAggiuntiva(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().preparaAperturaDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroDatiCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults indietroDatiCatastali(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().indietroDatiCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchScreenState utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().switchScreenState(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo checkMotivazione utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults checkMotivazione(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().checkMotivazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaComboIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults visualizzaComboIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().visualizzaComboIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults gestisciComboIndirizzo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().gestisciComboIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeo utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().gestisciComboGeo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo aggiornaDatiPagina utilizzato in un ExecCommand
	 * del ContentPanel cpCompilazApe
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCompilazApe
		return getCPBECpCompilazApe().aggiornaDatiPagina(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaXmlReadOnly utilizzato in un ExecCommand
	 * del ContentPanel cpImpXml2015
	 */
	public ExecResults caricaXmlReadOnly(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImpXml2015
		return getCPBECpImpXml2015().caricaXmlReadOnly(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaXml utilizzato in un ExecCommand
	 * del ContentPanel cpImpXml2015
	 */
	public ExecResults caricaXml(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImpXml2015
		return getCPBECpImpXml2015().caricaXml(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaEditAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpImpXml2015
	 */
	public ExecResults preparaEditAttestato(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImpXml2015
		return getCPBECpImpXml2015().preparaEditAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchScreenState utilizzato in un ExecCommand
	 * del ContentPanel cpImpXml2015
	 */
	public ExecResults switchScreenState(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpImpXml2015Model theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpImpXml2015
		return getCPBECpImpXml2015().switchScreenState(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaZonaClima utilizzato in un ExecCommand
	 * del ContentPanel cpZonaClima
	 */
	public ExecResults salvaZonaClima(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpZonaClimaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpZonaClima
		return getCPBECpZonaClima().salvaZonaClima(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initZonaClimaComboBox utilizzato in un ExecCommand
	 * del ContentPanel cpZonaClima
	 */
	public ExecResults initZonaClimaComboBox(

			it.csi.sicee.siceeweb.dto.compilazattestatiape.CpZonaClimaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpZonaClima
		return getCPBECpZonaClima().initZonaClimaComboBox(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaRicevutaReg utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults stampaRicevutaReg(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().stampaRicevutaReg(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaRicevutaAce utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults stampaRicevutaAce(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().stampaRicevutaAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricaricaTransazioniCredito utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults ricaricaTransazioniCredito(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().ricaricaTransazioniCredito(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricaricaCredito utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults ricaricaCredito(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().ricaricaCredito(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo dettaglioRicarica utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults dettaglioRicarica(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().dettaglioRicarica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciGeneraApe utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults gestisciGeneraApe(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().gestisciGeneraApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo pagaIscrAnnuale utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults pagaIscrAnnuale(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().pagaIscrAnnuale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo listaAttesaRT utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults listaAttesaRT(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().listaAttesaRT(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciRicevutaApe utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults gestisciRicevutaApe(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().gestisciRicevutaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo generaApe utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults generaApe(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().generaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaTransazioni utilizzato in un ExecCommand
	 * del ContentPanel cpTransaz
	 */
	public ExecResults initListaTransazioni(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransaz
		return getCPBECpTransaz().initListaTransazioni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneNascita utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setRegioneNascita(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setRegioneNascita(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaNascita utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setProvinciaNascita(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setProvinciaNascita(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneNascita utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setComuneNascita(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setComuneNascita(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtAnagAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults bDtAnagAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().bDtAnagAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setResidenzaForward utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setResidenzaForward(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setResidenzaForward(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchResidenza utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults switchResidenza(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().switchResidenza(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneResid utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setRegioneResid(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setRegioneResid(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaResid utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setProvinciaResid(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setProvinciaResid(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneResid utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setComuneResid(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setComuneResid(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzoRes utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults verificaIndirizzoRes(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().verificaIndirizzoRes(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scegliIndirizzoRes utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults scegliIndirizzoRes(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().scegliIndirizzoRes(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroRes utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults indietroRes(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().indietroRes(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtResAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults bDtResAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().bDtResAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setRegioneStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setRegioneStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setProvinciaStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setProvinciaStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setComuneStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setComuneStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzoStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults verificaIndirizzoStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().verificaIndirizzoStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scegliIndirizzoStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults scegliIndirizzoStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().scegliIndirizzoStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults indietroStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().indietroStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setResidenzaBackward utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults setResidenzaBackward(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().setResidenzaBackward(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtStudioAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults bDtStudioAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().bDtStudioAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo changeIscrittoOrdine utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults changeIscrittoOrdine(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().changeIscrittoOrdine(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo changeTipoIstruzione utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults changeTipoIstruzione(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().changeTipoIstruzione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo changeCodiceIstruzione utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults changeCodiceIstruzione(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().changeCodiceIstruzione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaTitoloStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults scaricaTitoloStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().scaricaTitoloStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo uploadTitoloStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults uploadTitoloStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().uploadTitoloStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaAttestatoPartecipazioneNew utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults scaricaAttestatoPartecipazioneNew(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().scaricaAttestatoPartecipazioneNew(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo uploadAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults uploadAttestato(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().uploadAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaAttestatoPartecipazioneOld utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults scaricaAttestatoPartecipazioneOld(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().scaricaAttestatoPartecipazioneOld(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroOrdine utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults indietroOrdine(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().indietroOrdine(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtOrdineAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults bDtOrdineAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().bDtOrdineAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoOK utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults recepisciPagamentoOK(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().recepisciPagamentoOK(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroRiepilogo utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults indietroRiepilogo(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().indietroRiepilogo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bDtRiepilogoAvantiSalva utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults bDtRiepilogoAvantiSalva(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().bDtRiepilogoAvantiSalva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaDatiPagamentoIscrizione utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults preparaDatiPagamentoIscrizione(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().preparaDatiPagamentoIscrizione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeo utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().gestisciComboGeo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchStatoWidget utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults switchStatoWidget(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().switchStatoWidget(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciTabAttPartOld utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults gestisciTabAttPartOld(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().gestisciTabAttPartOld(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciTabAttPartNew utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults gestisciTabAttPartNew(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().gestisciTabAttPartNew(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciTabTitoloStudio utilizzato in un ExecCommand
	 * del ContentPanel cpRegistraz
	 */
	public ExecResults gestisciTabTitoloStudio(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRegistraz
		return getCPBECpRegistraz().gestisciTabTitoloStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaTransazioneReg utilizzato in un ExecCommand
	 * del ContentPanel cpTransazAnomale
	 */
	public ExecResults verificaTransazioneReg(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazAnomale
		return getCPBECpTransazAnomale().verificaTransazioneReg(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaTransazioneAce utilizzato in un ExecCommand
	 * del ContentPanel cpTransazAnomale
	 */
	public ExecResults verificaTransazioneAce(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazAnomale
		return getCPBECpTransazAnomale().verificaTransazioneAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaRicevutaAce utilizzato in un ExecCommand
	 * del ContentPanel cpTransazAnomale
	 */
	public ExecResults stampaRicevutaAce(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazAnomale
		return getCPBECpTransazAnomale().stampaRicevutaAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaRicevutaReg utilizzato in un ExecCommand
	 * del ContentPanel cpTransazAnomale
	 */
	public ExecResults stampaRicevutaReg(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazAnomale
		return getCPBECpTransazAnomale().stampaRicevutaReg(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaTransazioni utilizzato in un ExecCommand
	 * del ContentPanel cpTransazAnomale
	 */
	public ExecResults initListaTransazioni(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazAnomaleModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazAnomale
		return getCPBECpTransazAnomale().initListaTransazioni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaMail utilizzato in un ExecCommand
	 * del ContentPanel cpVerificaMail
	 */
	public ExecResults verificaMail(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpVerificaMailModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificaMail
		return getCPBECpVerificaMail().verificaMail(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciEsitoMailOK utilizzato in un ExecCommand
	 * del ContentPanel cpGestioneDialogMail
	 */
	public ExecResults recepisciEsitoMailOK(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestioneDialogMail
		return getCPBECpGestioneDialogMail().recepisciEsitoMailOK(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciEsitoMailKO utilizzato in un ExecCommand
	 * del ContentPanel cpGestioneDialogMail
	 */
	public ExecResults recepisciEsitoMailKO(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestioneDialogMail
		return getCPBECpGestioneDialogMail().recepisciEsitoMailKO(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciMsgConMail utilizzato in un ExecCommand
	 * del ContentPanel cpGestioneDialogMail
	 */
	public ExecResults gestisciMsgConMail(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestioneDialogMail
		return getCPBECpGestioneDialogMail().gestisciMsgConMail(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciConfermaMail utilizzato in un ExecCommand
	 * del ContentPanel cpGestioneDialogMail
	 */
	public ExecResults gestisciConfermaMail(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpGestioneDialogMail
		return getCPBECpGestioneDialogMail().gestisciConfermaMail(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricaricaDatiPagamento utilizzato in un ExecCommand
	 * del ContentPanel cpAttesaRT
	 */
	public ExecResults ricaricaDatiPagamento(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpAttesaRTModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAttesaRT
		return getCPBECpAttesaRT().ricaricaDatiPagamento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaRicevutaRicarica utilizzato in un ExecCommand
	 * del ContentPanel cpAttesaRT
	 */
	public ExecResults stampaRicevutaRicarica(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpAttesaRTModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAttesaRT
		return getCPBECpAttesaRT().stampaRicevutaRicarica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaDatiPagamento utilizzato in un ExecCommand
	 * del ContentPanel cpAttesaRT
	 */
	public ExecResults caricaDatiPagamento(

			it.csi.sicee.siceeweb.dto.gestcertificatore.CpAttesaRTModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAttesaRT
		return getCPBECpAttesaRT().caricaDatiPagamento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaACESostituzione utilizzato in un ExecCommand
	 * del ContentPanel cpAnnullaSostAceHome
	 */
	public ExecResults ricercaACESostituzione(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpAnnullaSostAceHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAnnullaSostAceHome
		return getCPBECpAnnullaSostAceHome().ricercaACESostituzione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initDatiAnnullamento utilizzato in un ExecCommand
	 * del ContentPanel cpAnnullaSostAceHome
	 */
	public ExecResults initDatiAnnullamento(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpAnnullaSostAceHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAnnullaSostAceHome
		return getCPBECpAnnullaSostAceHome().initDatiAnnullamento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciAceDaSostituire utilizzato in un ExecCommand
	 * del ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciAceDaSostituire(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpSelezionaTipoRicercaAnnullaSost
		return getCPBECpSelezionaTipoRicercaAnnullaSost().gestisciAceDaSostituire(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciAceSostitutivi utilizzato in un ExecCommand
	 * del ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciAceSostitutivi(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpSelezionaTipoRicercaAnnullaSost
		return getCPBECpSelezionaTipoRicercaAnnullaSost().gestisciAceSostitutivi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisualizzaCarrello utilizzato in un ExecCommand
	 * del ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciVisualizzaCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpSelezionaTipoRicercaAnnullaSost
		return getCPBECpSelezionaTipoRicercaAnnullaSost().gestisciVisualizzaCarrello(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisCarrello utilizzato in un ExecCommand
	 * del ContentPanel cpSelezionaTipoRicercaAnnullaSost
	 */
	public ExecResults gestisciVisCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpSelezionaTipoRicercaAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpSelezionaTipoRicercaAnnullaSost
		return getCPBECpSelezionaTipoRicercaAnnullaSost().gestisciVisCarrello(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaACEByCodice utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults ricercaACEByCodice(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().ricercaACEByCodice(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisibBotAggiungiByCodice utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisibBotAggiungiByCodice(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().gestisciVisibBotAggiungiByCodice(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAceByFiltro utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().ricercaAceByFiltro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisibBotAggiungiByFiltro utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisibBotAggiungiByFiltro(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().gestisciVisibBotAggiungiByFiltro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaScaricoModulo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().preparaScaricoModulo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo aggiungiAlCarrello utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults aggiungiAlCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().aggiungiAlCarrello(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisualizzaCarrello utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisualizzaCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().gestisciVisualizzaCarrello(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciInitAnnullaSost utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciInitAnnullaSost(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().gestisciInitAnnullaSost(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciCombo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().gestisciCombo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisCarrello utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciVisCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().gestisciVisCarrello(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciInitAnnullaSostPrimoIngresso utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults gestisciInitAnnullaSostPrimoIngresso(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().gestisciInitAnnullaSostPrimoIngresso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo precaricaFiltroRicercaACE utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAceAnnullaSost
	 */
	public ExecResults precaricaFiltroRicercaACE(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRicercaAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAceAnnullaSost
		return getCPBECpRicercaAceAnnullaSost().precaricaFiltroRicercaACE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaOldDalCarrello utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults eliminaOldDalCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().eliminaOldDalCarrello(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisBotEliminaOld utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciVisBotEliminaOld(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().gestisciVisBotEliminaOld(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaNewDalCarrello utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults eliminaNewDalCarrello(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().eliminaNewDalCarrello(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisBotEliminaNew utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciVisBotEliminaNew(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().gestisciVisBotEliminaNew(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciIndietro utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciIndietro(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().gestisciIndietro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo sostituisciCertificati utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults sostituisciCertificati(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().sostituisciCertificati(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciRiepilogoCarrelloPrimoIngresso utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciRiepilogoCarrelloPrimoIngresso(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().gestisciRiepilogoCarrelloPrimoIngresso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciIngressoVisBotEliminaOld utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciIngressoVisBotEliminaOld(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().gestisciIngressoVisBotEliminaOld(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciIngressoVisBotEliminaNew utilizzato in un ExecCommand
	 * del ContentPanel cpRiepilogoAceAnnullaSost
	 */
	public ExecResults gestisciIngressoVisBotEliminaNew(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpRiepilogoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRiepilogoAceAnnullaSost
		return getCPBECpRiepilogoAceAnnullaSost().gestisciIngressoVisBotEliminaNew(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciStampaRicevuta utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoAceAnnullaSost
	 */
	public ExecResults gestisciStampaRicevuta(

			it.csi.sicee.siceeweb.dto.annullasostcert.CpEsitoAceAnnullaSostModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoAceAnnullaSost
		return getCPBECpEsitoAceAnnullaSost().gestisciStampaRicevuta(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaFoto utilizzato in un ExecCommand
	 * del ContentPanel cpMonitoraggio
	 */
	public ExecResults scaricaFoto(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpMonitoraggio
		return getCPBECpMonitoraggio().scaricaFoto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaApe utilizzato in un ExecCommand
	 * del ContentPanel cpMonitoraggio
	 */
	public ExecResults scaricaApe(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpMonitoraggio
		return getCPBECpMonitoraggio().scaricaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaComboTitoli utilizzato in un ExecCommand
	 * del ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboTitoli(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpMonitoraggio
		return getCPBECpMonitoraggio().caricaComboTitoli(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaComboProvince utilizzato in un ExecCommand
	 * del ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboProvince(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpMonitoraggio
		return getCPBECpMonitoraggio().caricaComboProvince(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaComboIndirizzi utilizzato in un ExecCommand
	 * del ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboIndirizzi(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpMonitoraggio
		return getCPBECpMonitoraggio().caricaComboIndirizzi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaComboAce utilizzato in un ExecCommand
	 * del ContentPanel cpMonitoraggio
	 */
	public ExecResults caricaComboAce(

			it.csi.sicee.siceeweb.dto.monitoraggio.CpMonitoraggioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpMonitoraggio
		return getCPBECpMonitoraggio().caricaComboAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaApeJasper utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults verificaApeJasper(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().verificaApeJasper(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo riportaBozza utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults riportaBozza(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().riportaBozza(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo effettuaCalcoli utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults effettuaCalcoli(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().effettuaCalcoli(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo effettuaArchivio utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults effettuaArchivio(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().effettuaArchivio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo completaSW utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults completaSW(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().completaSW(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo estrapolaSW utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults estrapolaSW(

			it.csi.sicee.siceeweb.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().estrapolaSW(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaPagamentoRegistrazione utilizzato in un ExecCommand
	 * del ContentPanel cpPagamento
	 */
	public ExecResults preparaPagamentoRegistrazione(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPagamento
		return getCPBECpPagamento().preparaPagamentoRegistrazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaTipiPagamentoPossibili utilizzato in un ExecCommand
	 * del ContentPanel cpPagamento
	 */
	public ExecResults abilitaTipiPagamentoPossibili(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPagamento
		return getCPBECpPagamento().abilitaTipiPagamentoPossibili(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo chiamaServizioPagamento utilizzato in un ExecCommand
	 * del ContentPanel cpPagamento
	 */
	public ExecResults chiamaServizioPagamento(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPagamento
		return getCPBECpPagamento().chiamaServizioPagamento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaPagamento utilizzato in un ExecCommand
	 * del ContentPanel cpPagamentoNew
	 */
	public ExecResults preparaPagamento(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoNewModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPagamentoNew
		return getCPBECpPagamentoNew().preparaPagamento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaRicevutaRicarica utilizzato in un ExecCommand
	 * del ContentPanel cpPagamentoDettNew
	 */
	public ExecResults stampaRicevutaRicarica(

			it.csi.sicee.siceeweb.dto.main.CpPagamentoDettNewModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPagamentoDettNew
		return getCPBECpPagamentoDettNew().stampaRicevutaRicarica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoOK utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamenti
	 */
	public ExecResults recepisciPagamentoOK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamenti
		return getCPBECpEsitoPagamenti().recepisciPagamentoOK(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoKO utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamenti
	 */
	public ExecResults recepisciPagamentoKO(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamenti
		return getCPBECpEsitoPagamenti().recepisciPagamentoKO(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoABORT utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamenti
	 */
	public ExecResults recepisciPagamentoABORT(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamenti
		return getCPBECpEsitoPagamenti().recepisciPagamentoABORT(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo switchOggettoPagato utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamenti
	 */
	public ExecResults switchOggettoPagato(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamenti
		return getCPBECpEsitoPagamenti().switchOggettoPagato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoWISPOK utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoWISPOK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamentiNew
		return getCPBECpEsitoPagamentiNew().recepisciPagamentoWISPOK(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoWISPKO utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoWISPKO(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamentiNew
		return getCPBECpEsitoPagamentiNew().recepisciPagamentoWISPKO(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoOK utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoOK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamentiNew
		return getCPBECpEsitoPagamentiNew().recepisciPagamentoOK(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoKO utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoKO(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamentiNew
		return getCPBECpEsitoPagamentiNew().recepisciPagamentoKO(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciPagamentoBACK utilizzato in un ExecCommand
	 * del ContentPanel cpEsitoPagamentiNew
	 */
	public ExecResults recepisciPagamentoBACK(

			it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpEsitoPagamentiNew
		return getCPBECpEsitoPagamentiNew().recepisciPagamentoBACK(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bRobotLancia utilizzato in un ExecCommand
	 * del ContentPanel cpRobot
	 */
	public ExecResults bRobotLancia(

			it.csi.sicee.siceeweb.dto.main.CpRobotModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRobot
		return getCPBECpRobot().bRobotLancia(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo retrieveRagioneBlocco utilizzato in un ExecCommand
	 * del ContentPanel cpBloccoUtente
	 */
	public ExecResults retrieveRagioneBlocco(

			it.csi.sicee.siceeweb.dto.main.CpBloccoUtenteModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpBloccoUtente
		return getCPBECpBloccoUtente().retrieveRagioneBlocco(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaCodiceImpianto utilizzato in un ExecCommand
	 * del ContentPanel cpVisuraCIT
	 */
	public ExecResults verificaCodiceImpianto(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVisuraCIT
		return getCPBECpVisuraCIT().verificaCodiceImpianto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaPOD utilizzato in un ExecCommand
	 * del ContentPanel cpVisuraCIT
	 */
	public ExecResults verificaPOD(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVisuraCIT
		return getCPBECpVisuraCIT().verificaPOD(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaPDR utilizzato in un ExecCommand
	 * del ContentPanel cpVisuraCIT
	 */
	public ExecResults verificaPDR(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVisuraCIT
		return getCPBECpVisuraCIT().verificaPDR(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpVisuraCIT
	 */
	public ExecResults verificaIndirizzo(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVisuraCIT
		return getCPBECpVisuraCIT().verificaIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaImpianto utilizzato in un ExecCommand
	 * del ContentPanel cpVisuraCIT
	 */
	public ExecResults visualizzaImpianto(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVisuraCIT
		return getCPBECpVisuraCIT().visualizzaImpianto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaLibretto utilizzato in un ExecCommand
	 * del ContentPanel cpVisuraCIT
	 */
	public ExecResults scaricaLibretto(

			it.csi.sicee.siceeweb.dto.main.CpVisuraCITModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVisuraCIT
		return getCPBECpVisuraCIT().scaricaLibretto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaCertificatoreDatiCert definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults recuperaCertificatoreDatiCert(

			it.csi.sicee.siceeweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERACERTIFICATOREDATICERT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1757551045) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(RECUPERACERTIFICATOREDATICERT_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaCertificatoreDatiCert] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaCertificatoreRegistraz definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults recuperaCertificatoreRegistraz(

			it.csi.sicee.siceeweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERACERTIFICATOREREGISTRAZ_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1087562510) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(RECUPERACERTIFICATOREREGISTRAZ_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaCertificatoreRegistraz] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaCertificatoreTransaz definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults recuperaCertificatoreTransaz(

			it.csi.sicee.siceeweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERACERTIFICATORETRANSAZ_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-495955130) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(RECUPERACERTIFICATORETRANSAZ_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaCertificatoreTransaz] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaCertificatoreTransazAnomale definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults recuperaCertificatoreTransazAnomale(

			it.csi.sicee.siceeweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERACERTIFICATORETRANSAZANOMALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R24637347) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RECUPERACERTIFICATORETRANSAZANOMALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaCertificatoreTransazAnomale] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaCertificatoreInviaCur definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults recuperaCertificatoreInviaCur(

			it.csi.sicee.siceeweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERACERTIFICATOREINVIACUR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-50208998) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaCertificatore(theModel);

			// impostazione del result code 
			result.setResultCode(RECUPERACERTIFICATOREINVIACUR_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaCertificatoreInviaCur] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initAnnullaSostAce definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults initAnnullaSostAce(

			it.csi.sicee.siceeweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITANNULLASOSTACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-352401549) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INITANNULLASOSTACE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initAnnullaSostAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaProvenienza definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults verificaProvenienza(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAPROVENIENZA_OUTCOME_CODE__LOGIN = //NOSONAR  Reason:EIAS
				"LOGIN"; //NOSONAR  Reason:EIAS
		final String VERIFICAPROVENIENZA_OUTCOME_CODE__PAGAMENTO = //NOSONAR  Reason:EIAS
				"PAGAMENTO"; //NOSONAR  Reason:EIAS
		final String VERIFICAPROVENIENZA_OUTCOME_CODE__VERIFICA_MAIL = //NOSONAR  Reason:EIAS
				"VERIFICA_MAIL"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-700850660) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("[BackEndFacade::verificaProvenienza] - theModel.getAuth(): " + theModel.getAuth());

			log.debug("[BackEndFacade::verificaProvenienza] - theModel.getTranId(): " + theModel.getTranId());

			log.debug("[BackEndFacade::verificaProvenienza] - theModel.getTransactionId(): "
					+ theModel.getTransactionId());

			log.debug("[BackEndFacade::verificaProvenienza] - theModel.getEsito(): " + theModel.getEsito());

			if (GenericUtil.isNullOrEmpty(theModel.getTransactionId())) {
				theModel.setAppDatanumeroTransazione(theModel.getTransactionId());
			} else if (GenericUtil.isNullOrEmpty(theModel.getTranId())) {
				theModel.setAppDatanumeroTransazione(theModel.getTranId());
			}

			theModel.setAppDataisPulireTab(true);
			/*
			if (theModel.getTranId() != null) {
				result.setResultCode(VERIFICAPROVENIENZA_OUTCOME_CODE__PAGAMENTO);
			} else 
			 */
			if (theModel.getAuth() != null) {
				result.setResultCode(VERIFICAPROVENIENZA_OUTCOME_CODE__VERIFICA_MAIL);
			} else {
				result.setResultCode(VERIFICAPROVENIENZA_OUTCOME_CODE__LOGIN);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaProvenienza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo checkEnabled definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults checkEnabled(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHECKENABLED_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CHECKENABLED_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1679769053) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (!getActivationMgr().isServiceEnabled()) {
				String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
				if (getActivationMgr().isUserEnabled(codiceFiscale)) {
					result.setResultCode(CHECKENABLED_OUTCOME_CODE__OK);
				} else {
					result.setResultCode(CHECKENABLED_OUTCOME_CODE__KO);
				}

			} else {
				result.setResultCode(CHECKENABLED_OUTCOME_CODE__OK);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::checkEnabled] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaLogAccesso definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults salvaLogAccesso(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVALOGACCESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-484381076) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UserInfo user = theModel.getAppDatacurrentUser();

			getSoaIntegrationMgr().insertLogAccesso(user.getCodFisc(), user.getNome(), user.getCognome(),
					Constants.RUOLO_CERTIFICATORE_LOG_ACCESSO);

			// impostazione del result code 
			result.setResultCode(SALVALOGACCESSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaLogAccesso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaAggMail definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults verificaAggMail(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAAGGMAIL_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAAGGMAIL_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1777080117) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String cf = theModel.getAppDatacurrentUser().getCodFisc();
			DatiCertificatore cert = getCertificatoreMgr().loadCertifcatoreByCF(cf);

			if (BaseMgr.isNullOrEmpty(cert)) {
				// NON TROVATO, creo
				cert = getCertificatoreMgr().createAndStoreNewCertificatore(cf,
						theModel.getAppDatacurrentUser().getNome(), theModel.getAppDatacurrentUser().getCognome());
			} else {
				// se è registrato marco anche i flag autocertificazione
				theModel.getAppDatacurrentUser().setNome(cert.getDtAnag().getNome());
				theModel.getAppDatacurrentUser().setCognome(cert.getDtAnag().getCognome());

				theModel.setAppDatamailVerifica(cert.getDtResidenza().getEmail());

			}

			theModel.setAppDatacertificatore(cert);

			if (getCertificatoreMgr().checkEmailVerificata(cf)) {
				// impostazione del result code 
				result.setResultCode(VERIFICAAGGMAIL_OUTCOME_CODE__OK);
			} else {
				// impostazione del result code 
				result.setResultCode(VERIFICAAGGMAIL_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaAggMail] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaAggDati definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults verificaAggDati(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAAGGDATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAAGGDATI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1603140688) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String cf = theModel.getAppDatacurrentUser().getCodFisc();

			if (getCertificatoreMgr().checkDatiRegVerificati(cf)) {
				// impostazione del result code 
				result.setResultCode(VERIFICAAGGDATI_OUTCOME_CODE__OK);
			} else {
				// impostazione del result code 
				result.setResultCode(VERIFICAAGGDATI_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaAggDati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaAccreditamento definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults verificaAccreditamento(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAACCREDITAMENTO_OUTCOME_CODE__REGISTRATO = //NOSONAR  Reason:EIAS
				"REGISTRATO"; //NOSONAR  Reason:EIAS
		final String VERIFICAACCREDITAMENTO_OUTCOME_CODE__NUOVO_ISCRITTO = //NOSONAR  Reason:EIAS
				"NUOVO_ISCRITTO"; //NOSONAR  Reason:EIAS
		final String VERIFICAACCREDITAMENTO_OUTCOME_CODE__REGISTRATO_SCADUTO = //NOSONAR  Reason:EIAS
				"REGISTRATO_SCADUTO"; //NOSONAR  Reason:EIAS
		final String VERIFICAACCREDITAMENTO_OUTCOME_CODE__NON_ABILITATO = //NOSONAR  Reason:EIAS
				"NON_ABILITATO"; //NOSONAR  Reason:EIAS
		final String VERIFICAACCREDITAMENTO_OUTCOME_CODE__BLOCCATO = //NOSONAR  Reason:EIAS
				"BLOCCATO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1812388874) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			/*if (getSpringSecurityHelper()
					.verifyCurrentUserForUseCaseInApplication(
							theModel.getSession())) {*/
			//if (true) {
			theModel.getAppDatacurrentUser().setRuolo("TITOLARE_CF@UTENTI_IRIDE2");

			String cf = theModel.getAppDatacurrentUser().getCodFisc();

			DatiCertificatore cert = theModel.getAppDatacertificatore();

			/*
			DatiCertificatore cert = getCertificatoreMgr()
					.loadCertifcatoreByCF(cf);
			
			if (BaseMgr.isNullOrEmpty(cert)) {
				// NON TROVATO, creo
				cert = getCertificatoreMgr().createAndStoreNewCertificatore(cf,
						theModel.getAppDatacurrentUser().getNome(),
						theModel.getAppDatacurrentUser().getCognome());
			} else {
				// se è registrato marco anche i flag autocertificazione
				theModel.getAppDatacurrentUser().setNome(
						cert.getDtAnag().getNome());
				theModel.getAppDatacurrentUser().setCognome(
						cert.getDtAnag().getCognome());
				// TODO
			
			}
			theModel.setAppDatacertificatore(cert);
			 */

			log.debug("\n\n\n>>>>>>> BackEndFacade::verificaAccreditamento --> cert.getStato(): " + cert.getStato());
			// impostazione del result code
			if (!GenericUtil.isNullOrEmpty(cert.getIdBlocco())) {
				result.setResultCode(VERIFICAACCREDITAMENTO_OUTCOME_CODE__BLOCCATO);
			} else if (cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_VALIDO
					|| cert.getStato() == Constants.STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA) {
				result.setResultCode(VERIFICAACCREDITAMENTO_OUTCOME_CODE__REGISTRATO);
			} else {
				result.setResultCode(VERIFICAACCREDITAMENTO_OUTCOME_CODE__NUOVO_ISCRITTO);
			}

			// modifica degli attributi del model (che verranno propagati allo
			// strato
			// di presentation). si puo' agire anche direttamente sull'attributo
			// "session".
			/*} else {
				theModel.getAppDatacurrentUser().setRuolo(null);
				result.setResultCode(VERIFICAACCREDITAMENTO_OUTCOME_CODE__NON_ABILITATO);
			}*/

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaAccreditamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciBloccoCertificatore definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults gestisciBloccoCertificatore(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__RADIATO = //NOSONAR  Reason:EIAS
				"RADIATO"; //NOSONAR  Reason:EIAS
		final String GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__DECEDUTO = //NOSONAR  Reason:EIAS
				"DECEDUTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__ASSENZA_TITOLO_STUDIO = //NOSONAR  Reason:EIAS
				"ASSENZA_TITOLO_STUDIO"; //NOSONAR  Reason:EIAS
		final String GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__FALSE_DICHIARAZIONI = //NOSONAR  Reason:EIAS
				"FALSE_DICHIARAZIONI"; //NOSONAR  Reason:EIAS
		final String GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__ASSENZA_CORSO = //NOSONAR  Reason:EIAS
				"ASSENZA_CORSO"; //NOSONAR  Reason:EIAS
		final String GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__MANCANZA_INFORMAZIONI = //NOSONAR  Reason:EIAS
				"MANCANZA_INFORMAZIONI"; //NOSONAR  Reason:EIAS
		final String GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__MANCANZA_GENERICA = //NOSONAR  Reason:EIAS
				"MANCANZA_GENERICA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-944815743) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DatiCertificatore cert = theModel.getAppDatacertificatore();

			if (cert.getIdBlocco() == Constants.ID_BLOCCO_CERTIFICATORE_RADIATO) {
				result.setResultCode(GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__RADIATO);
			} else if (cert.getIdBlocco() == Constants.ID_BLOCCO_CERTIFICATORE_DECEDUTO) {
				result.setResultCode(GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__DECEDUTO);
			} else if (cert.getIdBlocco() == Constants.ID_BLOCCO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO) {
				result.setResultCode(GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__ASSENZA_TITOLO_STUDIO);
			} else if (cert.getIdBlocco() == Constants.ID_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI) {
				result.setResultCode(GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__FALSE_DICHIARAZIONI);
			} else if (cert.getIdBlocco() == Constants.ID_BLOCCO_CERTIFICATORE_ASSENZA_CORSO) {
				result.setResultCode(GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__ASSENZA_CORSO);
			} else if (cert.getIdBlocco() == Constants.ID_BLOCCO_CERTIFICATORE_MANCANZA_INFORMAZIONI) {
				result.setResultCode(GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__MANCANZA_INFORMAZIONI);
			} else if (cert.getIdBlocco() == Constants.ID_BLOCCO_CERTIFICATORE_MANCANZA_GENERICA) {
				result.setResultCode(GESTISCIBLOCCOCERTIFICATORE_OUTCOME_CODE__MANCANZA_GENERICA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciBloccoCertificatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciEsito definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults gestisciEsito(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_OK = //NOSONAR  Reason:EIAS
				"ESITO_PAG_OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_KO = //NOSONAR  Reason:EIAS
				"ESITO_PAG_KO"; //NOSONAR  Reason:EIAS
		final String GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_ABORT = //NOSONAR  Reason:EIAS
				"ESITO_PAG_ABORT"; //NOSONAR  Reason:EIAS
		final String GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_ANOMAL = //NOSONAR  Reason:EIAS
				"ESITO_PAG_ANOMAL"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R585512245) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			log.debug("###### Stampo theModel.getTranId(): " + theModel.getTranId());

			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			theModel.setAppDatanumeroTransazione(theModel.getTranId());
			//theModel.setAppDataesitoTransazione(theModel.getTranEsito());

			// Devo recuperare in base al num transazione che tipo di transazione di pagamento è: REGISTRAZIONE o ACE
			it.csi.sicee.siceeweb.dto.transazioni.Transazione transazione = null;

			// Inizio a cercare il num transazione nella REGISTRAZIONE
			transazione = getTransazioneRegistrazioneMgr()
					.getTransazioneByNumTransazione(theModel.getAppDatanumeroTransazione());

			String cf = theModel.getAppDatacurrentUser().getCodFisc();
			DatiCertificatore cert = getCertificatoreMgr().loadCertifcatoreByCF(cf);

			if (BaseMgr.isNullOrEmpty(cert)) {
				// NON TROVATO, creo
				cert = getCertificatoreMgr().createAndStoreNewCertificatore(cf,
						theModel.getAppDatacurrentUser().getNome(), theModel.getAppDatacurrentUser().getCognome());
			} else {
				// se è registrato marco anche i flag autocertificazione
				theModel.getAppDatacurrentUser().setNome(cert.getDtAnag().getNome());
				theModel.getAppDatacurrentUser().setCognome(cert.getDtAnag().getCognome());
				// TODO

			}

			theModel.setAppDatacertificatore(cert);

			// Se è nulla la cerco negli ACE
			if (transazione == null) {
				transazione = getTransazioneAceMgr()
						.getTransazioneByNumTransazione(theModel.getAppDatanumeroTransazione());

				// Se non l'ho trovata neanche negli ACE (non dovrebbe essere possibile) dovrei rilanciare un'eccezione
				if (transazione == null) {
					throw new IllegalArgumentException("errore interno: numero di transazione non previsto "
							+ theModel.getAppDatanumeroTransazione());
				} else {
					theModel.setAppDataswitchPagamento(Constants.PAGAMENTO_ACE);
				}

			} else {
				theModel.setAppDataswitchPagamento(Constants.PAGAMENTO_REGISTRAZIONE);
			}

			theModel.setAppDataidTransazione(transazione.getIdTransazione());

			int idStatoTrans = getTransazioneAceMgr().cercaStatoTransazione(theModel.getAppDatanumeroTransazione());

			// Se sul DB risulta diverso da stato INIZIALIZED e STARTED vuol dire che è già passato da questo punto.

			String statoTransaz = transazione.getStato();

			if (!statoTransaz.equals(Constants.TRANSAZIONE_INIZIALIZED)
					&& !statoTransaz.equals(Constants.TRANSAZIONE_STARTED)) {
				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_ANOMAL);

			} else if (idStatoTrans == Constants.TRANSAZIONE_MDP_OK) {

				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_OK);

			} else if (idStatoTrans == Constants.TRANSAZIONE_MDP_KO) {

				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_KO);

			} else if (idStatoTrans == Constants.TRANSAZIONE_MDP_ABORT) {

				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_ABORT);
			} else {
				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_ANOMAL);

			}

			//			if (theModel.getTranEsito().equalsIgnoreCase(
			//					Constants.ESITO_PAGAMENTO_OK)) {
			//				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_OK);
			//			} else if (theModel.getTranEsito().equalsIgnoreCase(
			//					Constants.ESITO_PAGAMENTO_KO)) {
			//				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_KO);
			//			} else if (theModel.getTranEsito().equalsIgnoreCase(
			//					Constants.ESITO_PAGAMENTO_ABORT)) {
			//				result.setResultCode(GESTISCIESITO_OUTCOME_CODE__ESITO_PAG_ABORT);
			//			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciEsito] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaUrlConfermaMail definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults verificaUrlConfermaMail(

			it.csi.sicee.siceeweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAURLCONFERMAMAIL_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAURLCONFERMAMAIL_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1089607304) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Devo verificare la url ricevuta 

			String linkCript = theModel.getAuth();
			String cf = theModel.getAppDatacurrentUser().getCodFisc();

			if (getCertificatoreMgr().checkEmailVerificata(cf)) {
				// L'utente ha già confermato la mail

				theModel.setAppDatamsgEsitoVerificaMail("L'indirizzo email e' gia' stato confermato");
				result.setResultCode(VERIFICAURLCONFERMAMAIL_OUTCOME_CODE__KO);

			} else {
				boolean isCorrect = getMiscMgr().isLinkCorrect(linkCript, cf);

				if (isCorrect) {

					DatiCertificatore cert = getCertificatoreMgr().loadCertifcatoreByCF(cf);

					if (BaseMgr.isNullOrEmpty(cert)) {
						theModel.setAppDatamsgEsitoVerificaMail(
								"Indirizzo email non verificato correttamente, si prega di riprovare");
						// NON DOVREBBE MAI SUCCEDERE IN QUESTO PUNTO
						result.setResultCode(VERIFICAURLCONFERMAMAIL_OUTCOME_CODE__KO);
					} else {

						boolean isLast = getMiscMgr().isLastLink(linkCript, cert.getDataEmailVerifica());

						if (isLast) {
							theModel.setAppDataflgEsitoVerifica(true);

							// se è registrato marco anche i flag autocertificazione
							theModel.getAppDatacurrentUser().setNome(cert.getDtAnag().getNome());
							theModel.getAppDatacurrentUser().setCognome(cert.getDtAnag().getCognome());

							theModel.setAppDatacertificatore(cert);

							// impostazione del result code 
							result.setResultCode(VERIFICAURLCONFERMAMAIL_OUTCOME_CODE__OK);
						} else {
							// Il link è corretto, ma, ne esiste uno più recente, evidentemente ha cliccato piò volte su verifica firma!!

							theModel.setAppDatamsgEsitoVerificaMail(
									"Indirizzo email non verificato correttamente, esiste un'altro link...");
							// NON DOVREBBE MAI SUCCEDERE IN QUESTO PUNTO
							result.setResultCode(VERIFICAURLCONFERMAMAIL_OUTCOME_CODE__KO);
						}
					}

				} else {
					theModel.setAppDataflgEsitoVerifica(false);
					theModel.setAppDatamsgEsitoVerificaMail(
							"Indirizzo email non verificato correttamente, si prega di riprovare");
					// impostazione del result code 
					result.setResultCode(VERIFICAURLCONFERMAMAIL_OUTCOME_CODE__KO);
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaUrlConfermaMail] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property relative ai bean spring associati agli specifici content panel
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * riferimento al CPBE del content panel cpPrenotazAttestati
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpPrenotazAttestati cPBECpPrenotazAttestati = null;

	/**
	 * riferimento al CPBE del content panel cpPrenotazAttestati
	 */
	public void setCPBECpPrenotazAttestati(it.csi.sicee.siceeweb.business.gestattestati.CPBECpPrenotazAttestati bean) {
		this.cPBECpPrenotazAttestati = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpPrenotazAttestati
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpPrenotazAttestati getCPBECpPrenotazAttestati() {
		return this.cPBECpPrenotazAttestati;
	}

	/**
	 * riferimento al CPBE del content panel cpGestCertificazioni
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestCertificazioni cPBECpGestCertificazioni = null;

	/**
	 * riferimento al CPBE del content panel cpGestCertificazioni
	 */
	public void setCPBECpGestCertificazioni(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestCertificazioni bean) {
		this.cPBECpGestCertificazioni = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpGestCertificazioni
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestCertificazioni getCPBECpGestCertificazioni() {
		return this.cPBECpGestCertificazioni;
	}

	/**
	 * riferimento al CPBE del content panel cpDocAggiuntiva
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpDocAggiuntiva cPBECpDocAggiuntiva = null;

	/**
	 * riferimento al CPBE del content panel cpDocAggiuntiva
	 */
	public void setCPBECpDocAggiuntiva(it.csi.sicee.siceeweb.business.gestattestati.CPBECpDocAggiuntiva bean) {
		this.cPBECpDocAggiuntiva = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDocAggiuntiva
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpDocAggiuntiva getCPBECpDocAggiuntiva() {
		return this.cPBECpDocAggiuntiva;
	}

	/**
	 * riferimento al CPBE del content panel cpUploadDocAggiuntiva
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpUploadDocAggiuntiva cPBECpUploadDocAggiuntiva = null;

	/**
	 * riferimento al CPBE del content panel cpUploadDocAggiuntiva
	 */
	public void setCPBECpUploadDocAggiuntiva(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpUploadDocAggiuntiva bean) {
		this.cPBECpUploadDocAggiuntiva = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpUploadDocAggiuntiva
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpUploadDocAggiuntiva getCPBECpUploadDocAggiuntiva() {
		return this.cPBECpUploadDocAggiuntiva;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAceInviati
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpRicercaAceInviati cPBECpRicercaAceInviati = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaAceInviati
	 */
	public void setCPBECpRicercaAceInviati(it.csi.sicee.siceeweb.business.gestattestati.CPBECpRicercaAceInviati bean) {
		this.cPBECpRicercaAceInviati = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAceInviati
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpRicercaAceInviati getCPBECpRicercaAceInviati() {
		return this.cPBECpRicercaAceInviati;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaAce
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpRisultatoRicercaAce cPBECpRisultatoRicercaAce = null;

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaAce
	 */
	public void setCPBECpRisultatoRicercaAce(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpRisultatoRicercaAce bean) {
		this.cPBECpRisultatoRicercaAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaAce
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpRisultatoRicercaAce getCPBECpRisultatoRicercaAce() {
		return this.cPBECpRisultatoRicercaAce;
	}

	/**
	 * riferimento al CPBE del content panel cpGestInvioCertificato
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestInvioCertificato cPBECpGestInvioCertificato = null;

	/**
	 * riferimento al CPBE del content panel cpGestInvioCertificato
	 */
	public void setCPBECpGestInvioCertificato(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestInvioCertificato bean) {
		this.cPBECpGestInvioCertificato = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpGestInvioCertificato
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestInvioCertificato getCPBECpGestInvioCertificato() {
		return this.cPBECpGestInvioCertificato;
	}

	/**
	 * riferimento al CPBE del content panel cpGestInvioCurriculum
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestInvioCurriculum cPBECpGestInvioCurriculum = null;

	/**
	 * riferimento al CPBE del content panel cpGestInvioCurriculum
	 */
	public void setCPBECpGestInvioCurriculum(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestInvioCurriculum bean) {
		this.cPBECpGestInvioCurriculum = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpGestInvioCurriculum
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpGestInvioCurriculum getCPBECpGestInvioCurriculum() {
		return this.cPBECpGestInvioCurriculum;
	}

	/**
	 * riferimento al CPBE del content panel cpDatiCertificazioni
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpDatiCertificazioni cPBECpDatiCertificazioni = null;

	/**
	 * riferimento al CPBE del content panel cpDatiCertificazioni
	 */
	public void setCPBECpDatiCertificazioni(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpDatiCertificazioni bean) {
		this.cPBECpDatiCertificazioni = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDatiCertificazioni
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpDatiCertificazioni getCPBECpDatiCertificazioni() {
		return this.cPBECpDatiCertificazioni;
	}

	/**
	 * riferimento al CPBE del content panel cpDuplicaAce
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpDuplicaAce cPBECpDuplicaAce = null;

	/**
	 * riferimento al CPBE del content panel cpDuplicaAce
	 */
	public void setCPBECpDuplicaAce(it.csi.sicee.siceeweb.business.gestattestati.CPBECpDuplicaAce bean) {
		this.cPBECpDuplicaAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDuplicaAce
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpDuplicaAce getCPBECpDuplicaAce() {
		return this.cPBECpDuplicaAce;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpDettaglioAttestato cPBECpDettaglioAttestato = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	public void setCPBECpDettaglioAttestato(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpDettaglioAttestato bean) {
		this.cPBECpDettaglioAttestato = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpDettaglioAttestato getCPBECpDettaglioAttestato() {
		return this.cPBECpDettaglioAttestato;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioSostituzioni
	 */
	private it.csi.sicee.siceeweb.business.gestattestati.CPBECpDettaglioSostituzioni cPBECpDettaglioSostituzioni = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioSostituzioni
	 */
	public void setCPBECpDettaglioSostituzioni(
			it.csi.sicee.siceeweb.business.gestattestati.CPBECpDettaglioSostituzioni bean) {
		this.cPBECpDettaglioSostituzioni = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioSostituzioni
	 */
	public it.csi.sicee.siceeweb.business.gestattestati.CPBECpDettaglioSostituzioni getCPBECpDettaglioSostituzioni() {
		return this.cPBECpDettaglioSostituzioni;
	}

	/**
	 * riferimento al CPBE del content panel cpCompilaz
	 */
	private it.csi.sicee.siceeweb.business.compilazattestati.CPBECpCompilaz cPBECpCompilaz = null;

	/**
	 * riferimento al CPBE del content panel cpCompilaz
	 */
	public void setCPBECpCompilaz(it.csi.sicee.siceeweb.business.compilazattestati.CPBECpCompilaz bean) {
		this.cPBECpCompilaz = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpCompilaz
	 */
	public it.csi.sicee.siceeweb.business.compilazattestati.CPBECpCompilaz getCPBECpCompilaz() {
		return this.cPBECpCompilaz;
	}

	/**
	 * riferimento al CPBE del content panel cpImportaXml
	 */
	private it.csi.sicee.siceeweb.business.compilazattestati.CPBECpImportaXml cPBECpImportaXml = null;

	/**
	 * riferimento al CPBE del content panel cpImportaXml
	 */
	public void setCPBECpImportaXml(it.csi.sicee.siceeweb.business.compilazattestati.CPBECpImportaXml bean) {
		this.cPBECpImportaXml = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpImportaXml
	 */
	public it.csi.sicee.siceeweb.business.compilazattestati.CPBECpImportaXml getCPBECpImportaXml() {
		return this.cPBECpImportaXml;
	}

	/**
	 * riferimento al CPBE del content panel cpCompilazApe
	 */
	private it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpCompilazApe cPBECpCompilazApe = null;

	/**
	 * riferimento al CPBE del content panel cpCompilazApe
	 */
	public void setCPBECpCompilazApe(it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpCompilazApe bean) {
		this.cPBECpCompilazApe = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpCompilazApe
	 */
	public it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpCompilazApe getCPBECpCompilazApe() {
		return this.cPBECpCompilazApe;
	}

	/**
	 * riferimento al CPBE del content panel cpImpXml2015
	 */
	private it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpImpXml2015 cPBECpImpXml2015 = null;

	/**
	 * riferimento al CPBE del content panel cpImpXml2015
	 */
	public void setCPBECpImpXml2015(it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpImpXml2015 bean) {
		this.cPBECpImpXml2015 = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpImpXml2015
	 */
	public it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpImpXml2015 getCPBECpImpXml2015() {
		return this.cPBECpImpXml2015;
	}

	/**
	 * riferimento al CPBE del content panel cpZonaClima
	 */
	private it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpZonaClima cPBECpZonaClima = null;

	/**
	 * riferimento al CPBE del content panel cpZonaClima
	 */
	public void setCPBECpZonaClima(it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpZonaClima bean) {
		this.cPBECpZonaClima = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpZonaClima
	 */
	public it.csi.sicee.siceeweb.business.compilazattestatiape.CPBECpZonaClima getCPBECpZonaClima() {
		return this.cPBECpZonaClima;
	}

	/**
	 * riferimento al CPBE del content panel cpTransaz
	 */
	private it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpTransaz cPBECpTransaz = null;

	/**
	 * riferimento al CPBE del content panel cpTransaz
	 */
	public void setCPBECpTransaz(it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpTransaz bean) {
		this.cPBECpTransaz = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpTransaz
	 */
	public it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpTransaz getCPBECpTransaz() {
		return this.cPBECpTransaz;
	}

	/**
	 * riferimento al CPBE del content panel cpRegistraz
	 */
	private it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpRegistraz cPBECpRegistraz = null;

	/**
	 * riferimento al CPBE del content panel cpRegistraz
	 */
	public void setCPBECpRegistraz(it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpRegistraz bean) {
		this.cPBECpRegistraz = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRegistraz
	 */
	public it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpRegistraz getCPBECpRegistraz() {
		return this.cPBECpRegistraz;
	}

	/**
	 * riferimento al CPBE del content panel cpDatiCertificatore
	 */
	private it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpDatiCertificatore cPBECpDatiCertificatore = null;

	/**
	 * riferimento al CPBE del content panel cpDatiCertificatore
	 */
	public void setCPBECpDatiCertificatore(
			it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpDatiCertificatore bean) {
		this.cPBECpDatiCertificatore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDatiCertificatore
	 */
	public it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpDatiCertificatore getCPBECpDatiCertificatore() {
		return this.cPBECpDatiCertificatore;
	}

	/**
	 * riferimento al CPBE del content panel cpTransazAnomale
	 */
	private it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpTransazAnomale cPBECpTransazAnomale = null;

	/**
	 * riferimento al CPBE del content panel cpTransazAnomale
	 */
	public void setCPBECpTransazAnomale(it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpTransazAnomale bean) {
		this.cPBECpTransazAnomale = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpTransazAnomale
	 */
	public it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpTransazAnomale getCPBECpTransazAnomale() {
		return this.cPBECpTransazAnomale;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificaMail
	 */
	private it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpVerificaMail cPBECpVerificaMail = null;

	/**
	 * riferimento al CPBE del content panel cpVerificaMail
	 */
	public void setCPBECpVerificaMail(it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpVerificaMail bean) {
		this.cPBECpVerificaMail = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificaMail
	 */
	public it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpVerificaMail getCPBECpVerificaMail() {
		return this.cPBECpVerificaMail;
	}

	/**
	 * riferimento al CPBE del content panel cpGestioneDialogMail
	 */
	private it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpGestioneDialogMail cPBECpGestioneDialogMail = null;

	/**
	 * riferimento al CPBE del content panel cpGestioneDialogMail
	 */
	public void setCPBECpGestioneDialogMail(
			it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpGestioneDialogMail bean) {
		this.cPBECpGestioneDialogMail = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpGestioneDialogMail
	 */
	public it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpGestioneDialogMail getCPBECpGestioneDialogMail() {
		return this.cPBECpGestioneDialogMail;
	}

	/**
	 * riferimento al CPBE del content panel cpAttesaRT
	 */
	private it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpAttesaRT cPBECpAttesaRT = null;

	/**
	 * riferimento al CPBE del content panel cpAttesaRT
	 */
	public void setCPBECpAttesaRT(it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpAttesaRT bean) {
		this.cPBECpAttesaRT = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpAttesaRT
	 */
	public it.csi.sicee.siceeweb.business.gestcertificatore.CPBECpAttesaRT getCPBECpAttesaRT() {
		return this.cPBECpAttesaRT;
	}

	/**
	 * riferimento al CPBE del content panel cpAnnullaSostAceHome
	 */
	private it.csi.sicee.siceeweb.business.annullasostcert.CPBECpAnnullaSostAceHome cPBECpAnnullaSostAceHome = null;

	/**
	 * riferimento al CPBE del content panel cpAnnullaSostAceHome
	 */
	public void setCPBECpAnnullaSostAceHome(
			it.csi.sicee.siceeweb.business.annullasostcert.CPBECpAnnullaSostAceHome bean) {
		this.cPBECpAnnullaSostAceHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpAnnullaSostAceHome
	 */
	public it.csi.sicee.siceeweb.business.annullasostcert.CPBECpAnnullaSostAceHome getCPBECpAnnullaSostAceHome() {
		return this.cPBECpAnnullaSostAceHome;
	}

	/**
	 * riferimento al CPBE del content panel cpSelezionaTipoRicercaAnnullaSost
	 */
	private it.csi.sicee.siceeweb.business.annullasostcert.CPBECpSelezionaTipoRicercaAnnullaSost cPBECpSelezionaTipoRicercaAnnullaSost = null;

	/**
	 * riferimento al CPBE del content panel cpSelezionaTipoRicercaAnnullaSost
	 */
	public void setCPBECpSelezionaTipoRicercaAnnullaSost(
			it.csi.sicee.siceeweb.business.annullasostcert.CPBECpSelezionaTipoRicercaAnnullaSost bean) {
		this.cPBECpSelezionaTipoRicercaAnnullaSost = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpSelezionaTipoRicercaAnnullaSost
	 */
	public it.csi.sicee.siceeweb.business.annullasostcert.CPBECpSelezionaTipoRicercaAnnullaSost getCPBECpSelezionaTipoRicercaAnnullaSost() {
		return this.cPBECpSelezionaTipoRicercaAnnullaSost;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAceAnnullaSost
	 */
	private it.csi.sicee.siceeweb.business.annullasostcert.CPBECpRicercaAceAnnullaSost cPBECpRicercaAceAnnullaSost = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaAceAnnullaSost
	 */
	public void setCPBECpRicercaAceAnnullaSost(
			it.csi.sicee.siceeweb.business.annullasostcert.CPBECpRicercaAceAnnullaSost bean) {
		this.cPBECpRicercaAceAnnullaSost = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAceAnnullaSost
	 */
	public it.csi.sicee.siceeweb.business.annullasostcert.CPBECpRicercaAceAnnullaSost getCPBECpRicercaAceAnnullaSost() {
		return this.cPBECpRicercaAceAnnullaSost;
	}

	/**
	 * riferimento al CPBE del content panel cpRiepilogoAceAnnullaSost
	 */
	private it.csi.sicee.siceeweb.business.annullasostcert.CPBECpRiepilogoAceAnnullaSost cPBECpRiepilogoAceAnnullaSost = null;

	/**
	 * riferimento al CPBE del content panel cpRiepilogoAceAnnullaSost
	 */
	public void setCPBECpRiepilogoAceAnnullaSost(
			it.csi.sicee.siceeweb.business.annullasostcert.CPBECpRiepilogoAceAnnullaSost bean) {
		this.cPBECpRiepilogoAceAnnullaSost = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRiepilogoAceAnnullaSost
	 */
	public it.csi.sicee.siceeweb.business.annullasostcert.CPBECpRiepilogoAceAnnullaSost getCPBECpRiepilogoAceAnnullaSost() {
		return this.cPBECpRiepilogoAceAnnullaSost;
	}

	/**
	 * riferimento al CPBE del content panel cpEsitoAceAnnullaSost
	 */
	private it.csi.sicee.siceeweb.business.annullasostcert.CPBECpEsitoAceAnnullaSost cPBECpEsitoAceAnnullaSost = null;

	/**
	 * riferimento al CPBE del content panel cpEsitoAceAnnullaSost
	 */
	public void setCPBECpEsitoAceAnnullaSost(
			it.csi.sicee.siceeweb.business.annullasostcert.CPBECpEsitoAceAnnullaSost bean) {
		this.cPBECpEsitoAceAnnullaSost = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpEsitoAceAnnullaSost
	 */
	public it.csi.sicee.siceeweb.business.annullasostcert.CPBECpEsitoAceAnnullaSost getCPBECpEsitoAceAnnullaSost() {
		return this.cPBECpEsitoAceAnnullaSost;
	}

	/**
	 * riferimento al CPBE del content panel cpMonitoraggio
	 */
	private it.csi.sicee.siceeweb.business.monitoraggio.CPBECpMonitoraggio cPBECpMonitoraggio = null;

	/**
	 * riferimento al CPBE del content panel cpMonitoraggio
	 */
	public void setCPBECpMonitoraggio(it.csi.sicee.siceeweb.business.monitoraggio.CPBECpMonitoraggio bean) {
		this.cPBECpMonitoraggio = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpMonitoraggio
	 */
	public it.csi.sicee.siceeweb.business.monitoraggio.CPBECpMonitoraggio getCPBECpMonitoraggio() {
		return this.cPBECpMonitoraggio;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpHome cPBECpHome = null;

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public void setCPBECpHome(it.csi.sicee.siceeweb.business.main.CPBECpHome bean) {
		this.cPBECpHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpHome getCPBECpHome() {
		return this.cPBECpHome;
	}

	/**
	 * riferimento al CPBE del content panel cpPagamento
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpPagamento cPBECpPagamento = null;

	/**
	 * riferimento al CPBE del content panel cpPagamento
	 */
	public void setCPBECpPagamento(it.csi.sicee.siceeweb.business.main.CPBECpPagamento bean) {
		this.cPBECpPagamento = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpPagamento
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpPagamento getCPBECpPagamento() {
		return this.cPBECpPagamento;
	}

	/**
	 * riferimento al CPBE del content panel cpPagamentoNew
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpPagamentoNew cPBECpPagamentoNew = null;

	/**
	 * riferimento al CPBE del content panel cpPagamentoNew
	 */
	public void setCPBECpPagamentoNew(it.csi.sicee.siceeweb.business.main.CPBECpPagamentoNew bean) {
		this.cPBECpPagamentoNew = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpPagamentoNew
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpPagamentoNew getCPBECpPagamentoNew() {
		return this.cPBECpPagamentoNew;
	}

	/**
	 * riferimento al CPBE del content panel cpPagamentoDettNew
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpPagamentoDettNew cPBECpPagamentoDettNew = null;

	/**
	 * riferimento al CPBE del content panel cpPagamentoDettNew
	 */
	public void setCPBECpPagamentoDettNew(it.csi.sicee.siceeweb.business.main.CPBECpPagamentoDettNew bean) {
		this.cPBECpPagamentoDettNew = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpPagamentoDettNew
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpPagamentoDettNew getCPBECpPagamentoDettNew() {
		return this.cPBECpPagamentoDettNew;
	}

	/**
	 * riferimento al CPBE del content panel cpEsitoPagamenti
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamenti cPBECpEsitoPagamenti = null;

	/**
	 * riferimento al CPBE del content panel cpEsitoPagamenti
	 */
	public void setCPBECpEsitoPagamenti(it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamenti bean) {
		this.cPBECpEsitoPagamenti = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpEsitoPagamenti
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamenti getCPBECpEsitoPagamenti() {
		return this.cPBECpEsitoPagamenti;
	}

	/**
	 * riferimento al CPBE del content panel cpEsitoPagamentiNew
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamentiNew cPBECpEsitoPagamentiNew = null;

	/**
	 * riferimento al CPBE del content panel cpEsitoPagamentiNew
	 */
	public void setCPBECpEsitoPagamentiNew(it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamentiNew bean) {
		this.cPBECpEsitoPagamentiNew = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpEsitoPagamentiNew
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpEsitoPagamentiNew getCPBECpEsitoPagamentiNew() {
		return this.cPBECpEsitoPagamentiNew;
	}

	/**
	 * riferimento al CPBE del content panel cpNonAbilitato
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpNonAbilitato cPBECpNonAbilitato = null;

	/**
	 * riferimento al CPBE del content panel cpNonAbilitato
	 */
	public void setCPBECpNonAbilitato(it.csi.sicee.siceeweb.business.main.CPBECpNonAbilitato bean) {
		this.cPBECpNonAbilitato = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpNonAbilitato
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpNonAbilitato getCPBECpNonAbilitato() {
		return this.cPBECpNonAbilitato;
	}

	/**
	 * riferimento al CPBE del content panel cpRobot
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpRobot cPBECpRobot = null;

	/**
	 * riferimento al CPBE del content panel cpRobot
	 */
	public void setCPBECpRobot(it.csi.sicee.siceeweb.business.main.CPBECpRobot bean) {
		this.cPBECpRobot = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRobot
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpRobot getCPBECpRobot() {
		return this.cPBECpRobot;
	}

	/**
	 * riferimento al CPBE del content panel cpEsci
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpEsci cPBECpEsci = null;

	/**
	 * riferimento al CPBE del content panel cpEsci
	 */
	public void setCPBECpEsci(it.csi.sicee.siceeweb.business.main.CPBECpEsci bean) {
		this.cPBECpEsci = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpEsci
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpEsci getCPBECpEsci() {
		return this.cPBECpEsci;
	}

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpDisabled cPBECpDisabled = null;

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	public void setCPBECpDisabled(it.csi.sicee.siceeweb.business.main.CPBECpDisabled bean) {
		this.cPBECpDisabled = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpDisabled getCPBECpDisabled() {
		return this.cPBECpDisabled;
	}

	/**
	 * riferimento al CPBE del content panel cpBloccoUtente
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpBloccoUtente cPBECpBloccoUtente = null;

	/**
	 * riferimento al CPBE del content panel cpBloccoUtente
	 */
	public void setCPBECpBloccoUtente(it.csi.sicee.siceeweb.business.main.CPBECpBloccoUtente bean) {
		this.cPBECpBloccoUtente = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpBloccoUtente
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpBloccoUtente getCPBECpBloccoUtente() {
		return this.cPBECpBloccoUtente;
	}

	/**
	 * riferimento al CPBE del content panel cpVisuraCIT
	 */
	private it.csi.sicee.siceeweb.business.main.CPBECpVisuraCIT cPBECpVisuraCIT = null;

	/**
	 * riferimento al CPBE del content panel cpVisuraCIT
	 */
	public void setCPBECpVisuraCIT(it.csi.sicee.siceeweb.business.main.CPBECpVisuraCIT bean) {
		this.cPBECpVisuraCIT = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpVisuraCIT
	 */
	public it.csi.sicee.siceeweb.business.main.CPBECpVisuraCIT getCPBECpVisuraCIT() {
		return this.cPBECpVisuraCIT;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1264235389) ENABLED START*/
	// // inserire qui le property che si vogliono iniettare in questo bean (es.
	// dao, proxy di pd, ...)
	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private MiscMgr miscMgr = null;

	public void setMiscMgr(MiscMgr cm) {
		miscMgr = cm;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	private SecurityHelper springSecurityHelper;

	public SecurityHelper getSpringSecurityHelper() {
		return springSecurityHelper;
	}

	public void setSpringSecurityHelper(SecurityHelper springSecurityHelper) {
		this.springSecurityHelper = springSecurityHelper;
	}

	private ActivationMgr activationMgr;

	public ActivationMgr getActivationMgr() {
		return activationMgr;
	}

	public void setActivationMgr(ActivationMgr activationMgr) {
		this.activationMgr = activationMgr;
	}

	private DatiCertificatore recuperaCertificatore(GlobalMenuModel theModel) throws BEException {
		DatiCertificatore cert = null;
		try {
			cert = getCertificatoreMgr().loadCertifcatoreByCF(theModel.getAppDatacurrentUser().getCodFisc());

			theModel.setAppDatacertificatore(cert);

		} catch (BEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return cert;

	}

	private DatiCertificatore recuperaCertificatore(GlobalHomeModel theModel) throws BEException {
		DatiCertificatore cert = null;
		try {
			cert = getCertificatoreMgr().loadCertifcatoreByCF(theModel.getAppDatacurrentUser().getCodFisc());

			theModel.setAppDatacertificatore(cert);

		} catch (BEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return cert;

	}

	private TransazioneAceMgr transazioneAceMgr = null;
	private TransazioneRegistrazMgr transazioneRegistrazioneMgr = null;

	public TransazioneAceMgr getTransazioneAceMgr() {
		return transazioneAceMgr;
	}

	public void setTransazioneAceMgr(TransazioneAceMgr transazioneAceMgr) {
		this.transazioneAceMgr = transazioneAceMgr;
	}

	public TransazioneRegistrazMgr getTransazioneRegistrazioneMgr() {
		return transazioneRegistrazioneMgr;
	}

	public void setTransazioneRegistrazioneMgr(TransazioneRegistrazMgr transazioneRegistrazioneMgr) {
		this.transazioneRegistrazioneMgr = transazioneRegistrazioneMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/*PROTECTED REGION END*/
}
