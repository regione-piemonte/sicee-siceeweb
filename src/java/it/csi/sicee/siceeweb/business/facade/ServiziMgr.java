/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceeweb.business.facade.exceptions.ServiceException;
import it.csi.sicee.siceeweb.business.print.dto.ApeDto;
import it.csi.sicee.siceeweb.dto.attestati.DatiAttestato;
import it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.MapDto;
import it.csi.sicee.siceeweb.util.Messages;
import it.csi.sicee.siceeweb.util.XmlBeanUtils;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;

import java.util.List;

import org.apache.log4j.Logger;


public class ServiziMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");
	
	protected CertificatoMgr certificatoMgr;
	
	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}
	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}
	
	private TransazioneCreditoMgr transazioneCreditoMgr = null;

	public TransazioneCreditoMgr getTransazioneCreditoMgr() {
		return transazioneCreditoMgr;
	}

	public void setTransazioneCreditoMgr(
			TransazioneCreditoMgr transazioneCreditoMgr) {
		this.transazioneCreditoMgr = transazioneCreditoMgr;
	}
/*	
	protected Properties getProperties() {
		log.debug("[ServiziMgr::getProperties] BEGIN");
		InputStream is = getClass().getResourceAsStream(PROPERTIES_RESOURCE);
		if (is != null) {
			try {
				 Properties properties = new Properties();
	             properties.load(is);
	              
				return properties;
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getProperties] errore nella parsificazione della configurazione delle PROPERTIES:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione delle PROPERTIES");
			}
		} else{
			log.error("[ServiziMgr::getProperties] configurazione delle PROPERTIES non trovata");
		}
		throw new IllegalArgumentException("configurazione delle PROPERTIES non trovata");
	}
*/	
	public void test(){
		log.debug("ServiziMgr RAGGIUNTO CORRETTAMENTE");
	}
				

	public void creaPdfTarghetta(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		try
		{
			
			byte[] targettaPdf = getSOAIntegrationMgr().recuperaStampaTarghettaCertificatoReadOnly(idCertificatore, progrCertificato, anno);
			
			
			
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato + "_targhetta.pdf";;
	
			if (log.isDebugEnabled())
				log.debug("STAMPO il nome del pdf: "+nome);
			

			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, targettaPdf,
					nome, 
					Constants.TIPOLOGIA_TARGHETTA_ACE, att);
			
			String hash = getCertificatoMgr().getHashFile(targettaPdf);
			
			
			getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_INDICATORE_APE, nome, hash, uidIndex);
			
		}
		catch (Exception e) {
			log.error("Errore consolidamento: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	
	public MODDocument getApe(String idCertificatore, String progrCertificato, String anno) throws ServiceException {
		log.debug("[ServiziMgr::getApe] BEGIN");
		try {
			// recupero XML da db
			SiceeTCertXml2015 certXML = getCertificatoMgr().recuperaCertXml2015(idCertificatore, progrCertificato, anno);
			// recupero da tutti i dto i dati da forzare nell'XML
			// e li mappo su un dto unico per comodità
			ApeDto apeDto = new ApeDto();
			SiceeTCertificato certificato = getCertificatoMgr().recuperaCertificato(idCertificatore, progrCertificato, anno);
			SiceeTImportDati2015 datiOrigXML = getCertificatoMgr().getSiceeTImportDati2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			SiceeTDatiGenerali datiGenerali = getCertificatoMgr().recuperaDatiGenerali(idCertificatore, progrCertificato, anno);
			SiceeTAltreInfo altreInfo = getCertificatoMgr().recuperaAltreInfo(idCertificatore, progrCertificato, anno);
			String dMotivo = null;
			String flagServizioEnergia = "N";
			if (!BaseMgr.isNullOrEmpty(altreInfo.getAltroServiziEnergia())) {
				dMotivo = getCertificatoMgr().recuperaDMotivoRilascioDecodifica(altreInfo.getAltroServiziEnergia()).getDescr();
				if ((Constants.ID_MOTIVO_ANTE_OPERAM == altreInfo.getAltroServiziEnergia()) 
						||(Constants.ID_MOTIVO_POST_OPERAM == altreInfo.getAltroServiziEnergia())) {
					flagServizioEnergia = "S";
					// decodifico solo se il motivo è ANTE_OPERAM o POST_OPERAM (getDescr() non produce un null pointer) 
				}
			}
			SiceeTCertificatore certificatore = getCertificatoMgr().recuperaCertificatore(idCertificatore);
			SiceeTAzienda azienda = getCertificatoMgr().recuperaAzienda(certificatore.getFkAzienda());
			String dTitolo = getCertificatoMgr().recuperaDTitolo(certificatore.getFkIstruzione());
			List<SiceeDDestUso2015> elencoClassificazioni = getCertificatoMgr().recuperaElencoClassificazioni();
			List<SiceeDUnitaMisura2015> elencoUnitaMisura = getCertificatoMgr().recuperaElencoUnitaMisura();
			List<SiceeDClasseEnergetica> elencoClasseEnergetica = getCertificatoMgr().recuperaElencoClasseEnergetica();
			List<SiceeDRiqEner2015> elencoCodiciREN = getCertificatoMgr().recuperaElencoCodiciREN();
			List<SiceeDCombustibile> elencoCombustibiliEnEsportata = getCertificatoMgr().recuperaElencoCombustibiliEnEsportata();
			List<SiceeDCombustibile> elencoCombustibiliDettImpianti = getCertificatoMgr().recuperaElencoCombustibiliDettImpianti();
			List<SiceeDCombustibile> elencoConsumiCombustibile = getCertificatoMgr().recuperaElencoConsumiCombustibile();
			apeDto = MapDto.mapFromCertificatoToApe(certificato, datiOrigXML, apeDto);
			
			// devo settare la descrizione della dichiarazione di indipendenza
			SiceeDDichiarazione dichiarazione = getCertificatoMgr().recuperaDichiarazioneIndipendenza(certificato.getFkDichiarazione());
			if (dichiarazione != null)
			{
				// deve essere sicuramente valorizzato
				apeDto.setDescDichIndipendenza(dichiarazione.getDescr());
			}
			
			apeDto = MapDto.mapFromDatiGeneraliToApe(datiGenerali, apeDto);
			apeDto = MapDto.mapFromAltreInfoToApe(altreInfo, apeDto, dMotivo, flagServizioEnergia);
			apeDto = MapDto.mapFromCertificatoreToApe(certificatore, azienda, dTitolo, apeDto);
			
			MODDocument modDoc = null;
			if (certXML != null) {
				log.debug("CERTIFICATO TROVATO");
				modDoc = MapDto.mapToMODDocument(XmlBeanUtils.readString(certXML.getXmlAllegato()));
				modDoc = MapDto.mapToDatiGenerici(modDoc, apeDto);				
				modDoc = MapDto.mapToDatiCatastali(modDoc, apeDto);			
				modDoc = MapDto.mapToElencoClassificazioni(modDoc, elencoClassificazioni);					
				modDoc = MapDto.mapToElencoUnitaMisura(modDoc, elencoUnitaMisura);			
				modDoc = MapDto.mapToElencoClasseEnergetica(modDoc, elencoClasseEnergetica);				
				modDoc = MapDto.mapToElencoCodiciREN(modDoc, elencoCodiciREN);							
				modDoc = MapDto.mapToElencoCombustibiliEnEsportata(modDoc, elencoCombustibiliEnEsportata);							
				modDoc = MapDto.mapToElencoCombustibiliDettImpianti(modDoc, elencoCombustibiliDettImpianti);						
			} else {
				log.debug("CERTIFICATO NON TROVATO");
				modDoc = MODDocument.Factory.newInstance();
				modDoc.addNewMOD();
				modDoc.getMOD().addNewSystem();
				modDoc.getMOD().addNewAttestato();
				modDoc.getMOD().getAttestato().addNewDatiPrecompilati();
				modDoc.getMOD().getAttestato().addNewDatiGenerali();
				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewSezDatiCatastali();
				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewCertificatore();
				modDoc.getMOD().getAttestato().getDatiPrecompilati().addNewFoto();
				modDoc.getMOD().getAttestato().addNewPrestEnergImpianti();
				modDoc.getMOD().getAttestato().addNewSoggettoCertificatore();
				modDoc = MapDto.mapToDatiGenerici(modDoc, apeDto);				
				modDoc = MapDto.mapToDatiCatastali(modDoc, apeDto);			
				modDoc = MapDto.mapToElencoClassificazioni(modDoc, elencoClassificazioni);				
				modDoc = MapDto.mapToElencoUnitaMisura(modDoc, elencoUnitaMisura);			
				modDoc = MapDto.mapToElencoClasseEnergetica(modDoc, elencoClasseEnergetica);			
				modDoc = MapDto.mapToElencoCodiciREN(modDoc, elencoCodiciREN);							
				modDoc = MapDto.mapToElencoCombustibiliEnEsportata(modDoc, elencoCombustibiliEnEsportata);							
				modDoc = MapDto.mapToElencoCombustibiliDettImpianti(modDoc, elencoCombustibiliDettImpianti);							
				modDoc = MapDto.mapToElencoConsumiCombustibile(modDoc, elencoConsumiCombustibile);							
			}
			return modDoc;
		} catch (Exception e) {
			log.error("Errore getApe",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally{
			log.debug("[ServiziMgr::getApe] END");
		}
			
	}

	public void creaPdfEConsolidaCertificatoReadOnly(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		creaPdfESalvaCertificatoReadOnly(cert, idCertificatore, progrCertificato, anno, att, Constants.CONSOLIDATO);
	}
	
	public void creaPdfEAnnullaCertificatoReadOnly(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att) throws ServiceException
	{
		creaPdfESalvaCertificatoReadOnly(cert, idCertificatore, progrCertificato, anno, att, Constants.ANNULLATO);
	}

	private void creaPdfESalvaCertificatoReadOnly(DatiCertificatore cert, String idCertificatore, String progrCertificato, String anno, DatiAttestato att, int idStatoAttestato) throws ServiceException
	{
		try
		{

			byte[] thePdf = getCertificatoMgr().recuperaStampaCertificatoReadOnly(idCertificatore, progrCertificato, anno, idStatoAttestato);
			
			String nome = anno + "_" + cert.getNumCertificatore() + "_" + progrCertificato;
			if (idStatoAttestato == Constants.ANNULLATO)
			{
				nome += "_annullato";
			}
			nome += ".pdf";
	
			if (log.isDebugEnabled())
				log.debug("STAMPO il nome del pdf: "+nome);
			

			String uidIndex = getSOAIntegrationMgr().salvaDocumento(cert, thePdf,
					nome, 
					Constants.TIPOLOGIA_ALLEGATO_ACE_NEW, att);
			
			String hash = getCertificatoMgr().getHashFile(thePdf);
			
			if (idStatoAttestato == Constants.CONSOLIDATO)
			{
				getCertificatoMgr().inserisciDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			else if (idStatoAttestato == Constants.ANNULLATO)
			{
				getCertificatoMgr().modificaDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			}
			
			
		}
		catch (Exception e) {
			log.error("Errore creaPdfESalvaAttestato: ", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}
	
	public byte[] getRicevutaApeReadOnly(Integer idCredito) throws Exception {
		log.debug("[ServiziManager::getRicevutaApeReadOnly] START");

		try {
			
			log.info("[ServiziMgr] - idCredito: " + idCredito);
			byte[] xmlModel = getCertificatoMgr().recuperaStampaRicevutaApeReadOnly(idCredito);
		
			return xmlModel;


		}catch(Exception e){
			log.error("Errore apertura file",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally{
			log.debug("[ServiziMgr::getRicevutaApeReadOnly] END");
		}
	}
	
}