/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.impl.util.Base64;
import org.xml.sax.SAXException;

import it.csi.sicee.siceeorch.dto.siceeorch.Impianto;
import it.csi.sicee.siceeorch.dto.siceeorch.RappControllo;
import it.csi.sicee.siceeorch.dto.siceeorch.RifCatastale;
import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.TrackingDbBEException;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGeneraliPk;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.business.print.dto.ApeDto;
import it.csi.sicee.siceeweb.business.print.dto.CodiceDescrizione;
import it.csi.sicee.siceeweb.business.print.dto.DatiGenericiDto;
import it.csi.sicee.siceeweb.dto.attestati.VisuraImpianto;
import it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo;
import it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClasseEnergetica;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClasseEnergetica.ClasseEnergetica;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClassificazioni;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClassificazioni.Classificazione;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoTipiImpProdFontiRinn;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoTipiImpProdFontiRinn.TipoImpianto;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCodiciREN;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCodiciREN.CodiceREN;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliDettImpianti;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliDettImpianti.CombustibileDettImpianti;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliEnEsportata;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliEnEsportata.CombustibileEnEsportata;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoUnitaMisura;
import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoUnitaMisura.UnitaMisura;
import it.csi.sicee.siceeweb.xml.attestato.data.ImageJPG;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;
import it.csi.sicee.siceeweb.xml.attestato.data.PrestEnergImpiantiDocument.PrestEnergImpianti.ElencoFontiEnergetiche;
import it.csi.sicee.siceeweb.xml.attestato.data.RowConsumiCombustibileDocument.RowConsumiCombustibile;
import it.csi.sicee.siceeweb.xml.attestato.data.RowDatiCatastaliDocument.RowDatiCatastali;
import it.csi.sicee.siceeweb.xml.xmlapecompleto2015.data.DocumentoDocument;
import it.csi.sicee.siceeweb.xml.xmlapecompleto2015.data.TypeDatiCatastali;
import it.csi.sicee.siceeweb.xml.xmlapecompleto2015.data.TypeImpianto;
import it.csi.sicee.siceeweb.xml.xmlapecompleto2015.data.TypeInterventoRaccomandato;


/**
 * Mappa DTO con gli oggetti GUI e viceversa
 * 
 */
public class MapDto {

	private static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".util");

	public static MODDocument mapToMODDocument(byte[] theXml){
		try {
			log.debug("[MapDto::mapToMODDocument] start");
			String theXmlString = ModolXFAReader.getXMLData(theXml, "data:MOD");
			//log.debug("theXmlString " + theXmlString);
			InputStream is = new ByteArrayInputStream(XmlBeanUtils.readString(theXmlString));
			MODDocument apeDoc = MODDocument.Factory.parse(is);
			
			log.debug("[MapDto::mapToMODDocument] end");
			return apeDoc;
		} catch (XmlException e) {
			log.error("Errore mapToMODDocument - XmlException",e);
			return null;
		} catch (IOException e) {
			log.error("Errore mapToMODDocument - IOException",e);
			return null;
		} catch (ParserConfigurationException e) {
			log.error("Errore mapToMODDocument - ParserConfigurationException",e);
			return null;
		} catch (SAXException e) {
			log.error("Errore mapToMODDocument - SAXException",e);
			return null;
		}		
	}
	
	
	public static ApeDto mapFromCertificatoToApe(SiceeTCertificato certificato, SiceeTImportDati2015 datiOrigXML, ApeDto apeDto){
		log.debug("[MapDto::.mapFromCertificatoToApe] start");
		
		if (datiOrigXML == null)
			apeDto.setIsBozzaDaXml(false);
		else
			apeDto.setIsBozzaDaXml(true);
		apeDto.setFkStato(certificato.getFkStato());
		apeDto.setAnno(certificato.getAnno());
		apeDto.setIdCertificatoreCertificato(certificato.getIdCertificatore());
		apeDto.setProgrCertificato(certificato.getProgrCertificato());
		apeDto.setDtScadenza(certificato.getDtScadenza());
		apeDto.setDescRegione(certificato.getDescRegione());
		apeDto.setDescComune(certificato.getDescComune());
		apeDto.setDescIndirizzoCertificato(certificato.getDescIndirizzo());
		apeDto.setNumCivico(certificato.getNumCivico());
		apeDto.setPiano(certificato.getPiano());
		apeDto.setInterno(certificato.getInterno());
		apeDto.setCoordN(certificato.getCoordN());
		apeDto.setCoordE(certificato.getCoordE());
		apeDto.setDtInizio(certificato.getDtInizio());
		apeDto.setCodiceComuneCatastale(certificato.getCodiceComuneCatastale());
		apeDto.setFoglio(certificato.getFoglio());
		apeDto.setSezione(certificato.getSezione());
		apeDto.setParticella(certificato.getParticella());
		apeDto.setSubalterno(certificato.getSubalterno());

		log.debug("[MapDto::.mapFromCertificatoToApe] end");
		return apeDto;
	}
	
	public static ApeDto mapFromCertificatoToApeReadOnly(SiceeTCertificato certificato, ApeDto apeDto){
		log.debug("[MapDto::.mapFromCertificatoToApeReadOnly] start");
		
		// Sicuramente è da import
		apeDto.setIsBozzaDaXml(true);
		
		apeDto.setFkStato(certificato.getFkStato());
		apeDto.setAnno(certificato.getAnno());
		apeDto.setIdCertificatoreCertificato(certificato.getIdCertificatore());
		apeDto.setProgrCertificato(certificato.getProgrCertificato());
		apeDto.setDtScadenza(certificato.getDtScadenza());
		apeDto.setDescRegione(certificato.getDescRegione());
		apeDto.setDescComune(certificato.getDescComune());
		apeDto.setDescIndirizzoCertificato(certificato.getDescIndirizzo());
		apeDto.setNumCivico(certificato.getNumCivico());
		apeDto.setPiano(certificato.getPiano());
		apeDto.setInterno(certificato.getInterno());
		apeDto.setCoordN(certificato.getCoordN());
		apeDto.setCoordE(certificato.getCoordE());
		apeDto.setDtInizio(certificato.getDtInizio());
		apeDto.setCodiceComuneCatastale(certificato.getCodiceComuneCatastale());
		apeDto.setFoglio(certificato.getFoglio());
		apeDto.setSezione(certificato.getSezione());
		apeDto.setParticella(certificato.getParticella());
		apeDto.setSubalterno(certificato.getSubalterno());

		log.debug("[MapDto::.mapFromCertificatoToApeReadOnly] end");
		return apeDto;
	}

	public static ApeDto mapFromDatiGeneraliToApeReadOnly(SiceeTDatiGenerali datiGenerali, ApeDto apeDto){
		log.debug("[MapDto::.mapFromDatiGeneraliToApe] start");
		
		apeDto.setAnnoCostruzione(datiGenerali.getAnnoCostruzione());
		apeDto.setZonaClimatica(datiGenerali.getZonaClimatica());
		apeDto.setOggetto(Integer.toString(datiGenerali.getFkOggettoApe()));
	
		log.debug("[MapDto::.mapFromDatiGeneraliToApe] end");
		return apeDto;
	}

	public static ApeDto mapFromAltreInfoToApeReadOnly(SiceeTAltreInfo altreInfo, ApeDto apeDto, String dMotivo, String flagServizioEnergia){
		log.debug("[MapDto::.mapFromAltreInfoToApeReadOnly] start");
		
		apeDto.setMotivazione(Integer.toString(altreInfo.getFkMotivo()));
		if (!BaseMgr.isNullOrEmpty(dMotivo)) {
			apeDto.setDescrizioneAltraMotivazione(dMotivo);
		} else {
			apeDto.setDescrizioneAltraMotivazione(altreInfo.getMotivoAltro());
		}
		apeDto.setFlagServizioEnergia(flagServizioEnergia);
		log.debug("[MapDto::.mapFromAltreInfoToApeReadOnly] end");
		return apeDto;
	}

	public static ApeDto mapFromCertificatoreToApeReadOnlyOLD(SiceeTCertificatore certificatore, SiceeTAzienda azienda, String dTitolo, ApeDto apeDto){
		log.debug("[MapDto::.mapFromCertificatoreToApeReadOnly] start");
		
		String cognomeRagSociale = certificatore.getCognome();
		apeDto.setNumCertificatore(certificatore.getNumCertificatore());
		apeDto.setDTitolo(dTitolo);
		
		String tmpStr = "";
		if (certificatore.getIscrittoOrdine() != null && certificatore.getIscrittoOrdine().equalsIgnoreCase(Constants.SI))
		{
			if (certificatore.getOrdine() != null)
				tmpStr = certificatore.getOrdine() + " / ";
			if (certificatore.getNumIscrAlbo() != null)
				tmpStr = tmpStr + certificatore.getNumIscrAlbo();			
		}
		apeDto.setIscrittoOrdine(tmpStr);
		
		if (log.isDebugEnabled())
			log.debug("azienda: "+azienda);
		
		if (azienda != null && azienda.getDescIndirizzo() != null) {
			
			log.debug("azienda.getDescIndirizzo(): "+azienda.getDescIndirizzo());
			
			// Nel caso ci sia l'azienda concateno la denominazione
			cognomeRagSociale += " / " + azienda.getDenominazione();
			
			apeDto.setDescIndirizzoCertificatore(azienda.getDescIndirizzo());
			apeDto.setNumCivicoResidenza(azienda.getNumCivico());
			apeDto.setDescComuneResidenza(azienda.getDescComune());
			apeDto.setDescProvResidenza(azienda.getDescProv());
		} else {
			if ("S".equalsIgnoreCase(certificatore.getFlgResidenzaItalia())) {
				apeDto.setDescIndirizzoCertificatore(certificatore.getDescIndirizzo());
				apeDto.setNumCivicoResidenza(certificatore.getNumCivicoResidenza());
				apeDto.setDescComuneResidenza(certificatore.getDescComuneResidenza());
				apeDto.setDescProvResidenza(certificatore.getDescProvResidenza());
			} else {
				apeDto.setDescIndirizzoCertificatore(certificatore.getViaEstera());
				apeDto.setNumCivicoResidenza(certificatore.getCivicoEstero());
				apeDto.setDescComuneResidenza(certificatore.getCittaEstera());
				apeDto.setDescProvResidenza(certificatore.getStatoResEstero());
			}
		}

		apeDto.setNome(certificatore.getNome());
		apeDto.setCognomeRagSociale(cognomeRagSociale);
		apeDto.setCognome(certificatore.getCognome());

		apeDto.setEmail(certificatore.getEmail());
		apeDto.setTelefono(certificatore.getTelefono());
	
		log.debug("[MapDto::.mapFromCertificatoreToApeReadOnly] end");
		return apeDto;
	}
	
	public static ApeDto mapFromDatiGeneraliToApe(SiceeTDatiGenerali datiGenerali, ApeDto apeDto){
		log.debug("[MapDto::.mapFromDatiGeneraliToApe] start");
		
		apeDto.setAnnoCostruzione(datiGenerali.getAnnoCostruzione());
		apeDto.setZonaClimatica(datiGenerali.getZonaClimatica());
		apeDto.setOggetto(Integer.toString(datiGenerali.getFkOggettoApe()));
	
		log.debug("[MapDto::.mapFromDatiGeneraliToApe] end");
		return apeDto;
	}

	public static ApeDto mapFromAltreInfoToApe(SiceeTAltreInfo altreInfo, ApeDto apeDto, String dMotivo, String flagServizioEnergia){
		log.debug("[MapDto::.mapFromAltreInfoToApe] start");
		
		apeDto.setMotivazione(Integer.toString(altreInfo.getFkMotivo()));
		if (!BaseMgr.isNullOrEmpty(dMotivo)) {
			apeDto.setDescrizioneAltraMotivazione(dMotivo);
		} else {
			apeDto.setDescrizioneAltraMotivazione(altreInfo.getMotivoAltro());
		}
		apeDto.setFlagServizioEnergia(flagServizioEnergia);
		log.debug("[MapDto::.mapFromAltreInfoToApe] end");
		return apeDto;
	}

	public static ApeDto mapFromCertificatoreToApe(SiceeTCertificatore certificatore, SiceeTAzienda azienda, String dTitolo, ApeDto apeDto){
		log.debug("[MapDto::.mapFromCertificatoreToApe] start");
		
		String cognomeRagSociale = certificatore.getCognome();
		apeDto.setNumCertificatore(certificatore.getNumCertificatore());
		apeDto.setDTitolo(dTitolo);
		
		String tmpStr = "";
		if (certificatore.getIscrittoOrdine() != null && certificatore.getIscrittoOrdine().equalsIgnoreCase(Constants.SI))
		{
			if (certificatore.getOrdine() != null)
				tmpStr = certificatore.getOrdine() + " / ";
			if (certificatore.getNumIscrAlbo() != null)
				tmpStr = tmpStr + certificatore.getNumIscrAlbo();			
		}
		apeDto.setIscrittoOrdine(tmpStr);
		
		if (log.isDebugEnabled())
			log.debug("azienda: "+azienda);
		
		if (azienda != null && azienda.getDescIndirizzo() != null) {
			
			log.debug("azienda.getDescIndirizzo(): "+azienda.getDescIndirizzo());
			
			// Nel caso ci sia l'azienda concateno la denominazione
			cognomeRagSociale += " / " + azienda.getDenominazione();
			
			apeDto.setDescIndirizzoCertificatore(azienda.getDescIndirizzo());
			apeDto.setNumCivicoResidenza(azienda.getNumCivico());
			apeDto.setDescComuneResidenza(azienda.getDescComune());
			apeDto.setDescProvResidenza(azienda.getDescProv());
		} else {
			if ("S".equalsIgnoreCase(certificatore.getFlgResidenzaItalia())) {
				apeDto.setDescIndirizzoCertificatore(certificatore.getDescIndirizzo());
				apeDto.setNumCivicoResidenza(certificatore.getNumCivicoResidenza());
				apeDto.setDescComuneResidenza(certificatore.getDescComuneResidenza());
				apeDto.setDescProvResidenza(certificatore.getDescProvResidenza());
			} else {
				apeDto.setDescIndirizzoCertificatore(certificatore.getViaEstera());
				apeDto.setNumCivicoResidenza(certificatore.getCivicoEstero());
				apeDto.setDescComuneResidenza(certificatore.getCittaEstera());
				apeDto.setDescProvResidenza(certificatore.getStatoResEstero());
			}
		}

		apeDto.setNome(certificatore.getNome());
		apeDto.setCognomeRagSociale(cognomeRagSociale);
		apeDto.setCognome(certificatore.getCognome());

		apeDto.setEmail(certificatore.getEmail());
		apeDto.setTelefono(certificatore.getTelefono());
	
		log.debug("[MapDto::.mapFromCertificatoreToApe] end");
		return apeDto;
	}

	public static MODDocument mapToDatiGenerici(MODDocument modDoc, ApeDto apeDto){
		log.debug("[MapDto::mapToDatiGenerici] start");
		
		modDoc.getMOD().getSystem().setModuloEditabile(Constants.TRUE);
		modDoc.getMOD().getSystem().setBtSalvaInBozza(Constants.TRUE);
		modDoc.getMOD().getSystem().setBtSalvaEcontrolla(Constants.TRUE);
		//modDoc.getMOD().getSystem().setBtInvia(Constants.FALSE);
		
		// stato modulo
		String statoModulo = "";
		if ((apeDto.getFkStato().intValue() == Constants.BOZZA) && (apeDto.getIsBozzaDaXml() == false))
			statoModulo = "BOZZA";
		if ((apeDto.getFkStato().intValue() == Constants.BOZZA) && (apeDto.getIsBozzaDaXml() == true))
			statoModulo = "BOZZA_DA_XML";
		else if (apeDto.getFkStato().intValue() == Constants.CONSOLIDATO)
			statoModulo = "CONSOLIDATO";
		else if (apeDto.getFkStato().intValue() == Constants.ANNULLATO || apeDto.getFkStato().intValue() == Constants.ANNULLATO_BO)
			statoModulo = "ANNULLATO";
		else if (apeDto.getFkStato().intValue() == Constants.DA_INVIARE)
			statoModulo = "CONSOLIDATO";
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setStatoModulo(statoModulo);
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setAnno(Converter.convertToBigInteger(apeDto.getAnno()));
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setIdCertificatore(apeDto.getNumCertificatore());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setProgressivoCertificato(apeDto.getProgrCertificato());
		
		// data validità
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = sdf.format(apeDto.getDtScadenza());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setDataValidita(dataStr);
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setRegione(apeDto.getDescRegione());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setComune(apeDto.getDescComune());
		String civico = "";
		if (apeDto.getNumCivico() != null)
			civico = apeDto.getNumCivico();
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setIndirizzo(apeDto.getDescIndirizzoCertificato() + " " + civico);
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setPiano(Converter.convertToString(apeDto.getPiano()));
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setInterno(apeDto.getInterno());

		// coordinate geografiche
		java.math.BigDecimal coordN = Converter.convertToBigDecimal(apeDto.getCoordN());
		java.math.BigDecimal coordE = Converter.convertToBigDecimal(apeDto.getCoordE());
		/*
		*/
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setCoordinateGIS(coordN.toString() + " " + coordE.toString());

		modDoc.getMOD().getAttestato().getDatiPrecompilati().setAnnoCostruzione(Converter.convertToString(apeDto.getAnnoCostruzione()));
		modDoc.getMOD().getAttestato().getDatiGenerali().setZonaClimatica(apeDto.getZonaClimatica());

		// certificatore
		civico = "";
		String indirizzo = "";
		String comune = "";
		String prov = "";
		
		if (apeDto.getDescIndirizzoCertificatore() != null)
			indirizzo = apeDto.getDescIndirizzoCertificatore();
		if (apeDto.getNumCivicoResidenza() != null)
			civico = apeDto.getNumCivicoResidenza();
		if (apeDto.getDescComuneResidenza() != null)
			comune = apeDto.getDescComuneResidenza();
		if (apeDto.getDescProvResidenza() != null)
			prov = apeDto.getDescProvResidenza();
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setDenominazione(apeDto.getNome() + " " + apeDto.getCognomeRagSociale());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setIndirizzo(indirizzo
				+ " " + civico
				+ " " + comune
				+ " (" + prov  + ")");
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setEmail(apeDto.getEmail());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setTelefono(apeDto.getTelefono());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setTitolo(apeDto.getDTitolo());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setOrdine(apeDto.getIscrittoOrdine());

		// data emissione
		dataStr = sdf.format(apeDto.getDtInizio());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setDataEmissione(dataStr);
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setFirma(apeDto.getCognome() 
				+ " " + apeDto.getNome()
				+ " " + "N."
				+ " " + apeDto.getNumCertificatore());

		modDoc.getMOD().getAttestato().getDatiGenerali().setOggetto(Converter.convertToBigInteger(apeDto.getOggetto()));
		modDoc.getMOD().getAttestato().getDatiGenerali().setMotivazione(Converter.convertToBigInteger(apeDto.getMotivazione()));
		modDoc.getMOD().getAttestato().getDatiGenerali().setMotivazioneAltro(apeDto.getDescrizioneAltraMotivazione());
		modDoc.getMOD().getAttestato().getDatiGenerali().setFlagServizioEnergia(apeDto.getFlagServizioEnergia());

		// Dichiarazione indipendenza
		modDoc.getMOD().getAttestato().getSoggettoCertificatore().setDichiarIndip(apeDto.getDescDichIndipendenza());
		
		log.debug("[MapDto::mapToDatiGenerici] end");
		return modDoc;
	}

	
	private static SiceeTQtaConsumi2015 decodeQtaConsumi(int idCombustibile, List<SiceeTQtaConsumi2015> quantitaConsumi2015)
	{
		SiceeTQtaConsumi2015 qtaConsumi = null;
		
		for (SiceeTQtaConsumi2015 siceeTQtaConsumi2015 : quantitaConsumi2015) {
			if (idCombustibile == siceeTQtaConsumi2015.getFkCombustibile().intValue())
			{
				qtaConsumi = siceeTQtaConsumi2015;
			}
		}
		
		return qtaConsumi;
	}
	
	private static String decodeUnitaMisura(Integer idUnitaMisura, List<SiceeDUnitaMisura2015> unitaMisure2015)
	{
		String unita = null;
		
		for (SiceeDUnitaMisura2015 unitaMis : unitaMisure2015) {
			if (idUnitaMisura.intValue() == unitaMis.getIdUnitaMisura().intValue())
			{
				unita = unitaMis.getDescr();
			}
		}
		
		return unita;
	}
	
	
	
	public static MODDocument mapToDatiCatastali(MODDocument modDoc, ApeDto apeDto){
		log.debug("[MapDto::mapToDatiCatastali] start");
		// sezione dati catastali

		List<RowDatiCatastali> rowDatiCatastaliList = modDoc.getMOD().getAttestato().getDatiPrecompilati().getSezDatiCatastali().getRowDatiCatastaliList();
		//List<RowDatiCatastali> rowDatiCatastaliBuildList = new ArrayList<RowDatiCatastali>();

		if (rowDatiCatastaliList.size() == 0) {
			//log.debug("\n>>>>>>> rowDatiCatastaliList.size() == 0 ; prima volta che entro");
			RowDatiCatastali rdc = RowDatiCatastali.Factory.newInstance();
			rdc.setFlagPrincipale(true);
			rdc.setComuneCatastale(apeDto.getCodiceComuneCatastale());
			rdc.setSezione(apeDto.getSezione());
			rdc.setFoglio(apeDto.getFoglio());
			rdc.setParticella(apeDto.getParticella());
			try{rdc.setDa1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setDa1(null);}
			try{rdc.setA1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setA1(null);}
			rowDatiCatastaliList.add(rdc);	

			RowDatiCatastali[] rowDatiCatastaliArray = new RowDatiCatastali[rowDatiCatastaliList.size()];
			rowDatiCatastaliArray = rowDatiCatastaliList.toArray(rowDatiCatastaliArray);
			modDoc.getMOD().getAttestato().getDatiPrecompilati().getSezDatiCatastali().setRowDatiCatastaliArray(rowDatiCatastaliArray);
		} 
		else {
			//log.debug("\n>>>>>>> rowDatiCatastaliList.size() > 0 ; ciclo sulle righe");
			for(RowDatiCatastali rdc : rowDatiCatastaliList) {
				if (rdc.getFlagPrincipale() == true) {
					rdc.setComuneCatastale(apeDto.getCodiceComuneCatastale());
					rdc.setSezione(apeDto.getSezione());
					rdc.setFoglio(apeDto.getFoglio());
					rdc.setParticella(apeDto.getParticella());
					try{rdc.setDa1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setDa1(null);}
					try{rdc.setA1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setA1(null);}
				
				}
				//rowDatiCatastaliBuildList.add(rdc);	
			}
			RowDatiCatastali[] rowDatiCatastaliArray = new RowDatiCatastali[rowDatiCatastaliList.size()];
			rowDatiCatastaliArray = rowDatiCatastaliList.toArray(rowDatiCatastaliArray);
			modDoc.getMOD().getAttestato().getDatiPrecompilati().getSezDatiCatastali().setRowDatiCatastaliArray(rowDatiCatastaliArray);
		}	

		log.debug("[MapDto::mapToDatiCatastali] end");
		return modDoc;
	}

	public static MODDocument mapToElencoClassificazioni(MODDocument modDoc, List<SiceeDDestUso2015> elencoClassificazioni){
		log.debug("[MapDto::mapToElencoClassificazioni] start");
		
		ElencoClassificazioni e = ElencoClassificazioni.Factory.newInstance();
		Classificazione classificazione = null;
		List<Classificazione> classificazioneList = e.getClassificazioneList();
		classificazione = Classificazione.Factory.newInstance();
		classificazione.setCodice(Converter.convertToBigInteger(-1));
		classificazione.setDescrizione(" ");
		classificazioneList.add(classificazione);
		for (SiceeDDestUso2015 c : elencoClassificazioni) {
			classificazione = Classificazione.Factory.newInstance();
			classificazione.setCodice(Converter.convertToBigInteger(c.getIdDestUso2015()));
			classificazione.setDescrizione(c.getSigla() + " " + c.getDescr());
			classificazione.setFlagIsResidenziale(c.getFlgResidenziale());
			classificazioneList.add(classificazione);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoClassificazioni(e);
		
		log.debug("[MapDto::mapToElencoClassificazioni] end");
		return modDoc;
	}

	public static MODDocument mapToElencoUnitaMisura(MODDocument modDoc, List<SiceeDUnitaMisura2015> elencoUnitaMisura){
		log.debug("[MapDto::mapToElencoUnitaMisura] start");
		
		ElencoUnitaMisura e = ElencoUnitaMisura.Factory.newInstance();
		UnitaMisura unitaMisura = null;
		List<UnitaMisura> unitaMisuraList = e.getUnitaMisuraList();
		unitaMisura = UnitaMisura.Factory.newInstance();
		unitaMisura.setCodice(Converter.convertToBigInteger(-1));
		unitaMisura.setDescrizione(" ");
		unitaMisuraList.add(unitaMisura);
		for (SiceeDUnitaMisura2015 um : elencoUnitaMisura) {
			unitaMisura = UnitaMisura.Factory.newInstance();
			unitaMisura.setCodice(Converter.convertToBigInteger(um.getIdUnitaMisura()));
			unitaMisura.setDescrizione(um.getDescr());
			unitaMisuraList.add(unitaMisura);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoUnitaMisura(e);
		
		log.debug("[MapDto::mapToElencoUnitaMisura] end");
		return modDoc;
	}

	public static MODDocument mapToElencoClasseEnergetica(MODDocument modDoc, List<SiceeDClasseEnergetica> elencoClasseEnergetica){
		log.debug("[MapDto::mapToElencoClasseEnergetica] start");
		
		ElencoClasseEnergetica e = ElencoClasseEnergetica.Factory.newInstance();
		ClasseEnergetica classeEnergetica = null;
		List<ClasseEnergetica> classeEnergeticaList = e.getClasseEnergeticaList();
		classeEnergetica = ClasseEnergetica.Factory.newInstance();
		classeEnergetica.setCodice(Converter.convertToBigInteger(-1));
		classeEnergetica.setDescrizione(" ");
		classeEnergeticaList.add(classeEnergetica);
		for (SiceeDClasseEnergetica ce : elencoClasseEnergetica) {
			classeEnergetica = ClasseEnergetica.Factory.newInstance();
			classeEnergetica.setCodice(Converter.convertToBigInteger(ce.getIdClasse()));
			classeEnergetica.setDescrizione(ce.getDescr());
			classeEnergeticaList.add(classeEnergetica);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoClasseEnergetica(e);
		
		log.debug("[MapDto::mapToElencoClasseEnergetica] end");
		return modDoc;
	}

	public static MODDocument mapToElencoCodiciREN(MODDocument modDoc, List<SiceeDRiqEner2015> elencoCodiciREN){
		log.debug("[MapDto::mapToElencoCodiciREN] start");
		
		ElencoCodiciREN e = ElencoCodiciREN.Factory.newInstance();
		CodiceREN codiceREN = null;
		List<CodiceREN> codiceRENList = e.getCodiceRENList();
		codiceREN = CodiceREN.Factory.newInstance();
		codiceREN.setCodice("-1");
		codiceREN.setDescrizione(" ");
		codiceRENList.add(codiceREN);
		for (SiceeDRiqEner2015 cren : elencoCodiciREN) {
			codiceREN = CodiceREN.Factory.newInstance();
			codiceREN.setCodice(cren.getCodiceRen());
			codiceREN.setDescrizione(cren.getCodiceRen());
			codiceRENList.add(codiceREN);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoCodiciREN(e);
		
		log.debug("[MapDto::mapToElencoCodiciREN] end");
		return modDoc;
	}

	public static MODDocument mapToElencoCombustibiliEnEsportata(MODDocument modDoc, List<SiceeDCombustibile> elencoCombustibiliEnEsportata){
		log.debug("[MapDto::mapToElencoCombustibiliEnEsportata] start");
		
		ElencoCombustibiliEnEsportata e = ElencoCombustibiliEnEsportata.Factory.newInstance();
		CombustibileEnEsportata combustibileEnEsportata = null;
		List<CombustibileEnEsportata> combustibileEnEsportataList = e.getCombustibileEnEsportataList();
		combustibileEnEsportata = CombustibileEnEsportata.Factory.newInstance();
		combustibileEnEsportata.setCodice(Converter.convertToBigInteger(-1));
		combustibileEnEsportata.setDescrizione(" ");
		combustibileEnEsportataList.add(combustibileEnEsportata);
		for (SiceeDCombustibile c : elencoCombustibiliEnEsportata) {
			combustibileEnEsportata = CombustibileEnEsportata.Factory.newInstance();
			combustibileEnEsportata.setCodice(Converter.convertToBigInteger(c.getIdCombustibile()));
			combustibileEnEsportata.setDescrizione(c.getDescr());
			combustibileEnEsportataList.add(combustibileEnEsportata);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoCombustibiliEnEsportata(e);
		
		log.debug("[MapDto::mapToElencoCombustibiliEnEsportata] end");
		return modDoc;
	}

	public static MODDocument mapToElencoCombustibiliDettImpianti(MODDocument modDoc, List<SiceeDCombustibile> elencoCombustibiliDettImpianti){
		log.debug("[MapDto::mapToElencoCombustibiliDettImpianti] start");
		
		ElencoCombustibiliDettImpianti e = ElencoCombustibiliDettImpianti.Factory.newInstance();
		CombustibileDettImpianti combustibileDettImpianti = null;
		List<CombustibileDettImpianti> combustibileDettImpiantiList = e.getCombustibileDettImpiantiList();
		combustibileDettImpianti = CombustibileDettImpianti.Factory.newInstance();
		combustibileDettImpianti.setCodice(Converter.convertToBigInteger(-1));
		combustibileDettImpianti.setDescrizione(" ");
		combustibileDettImpiantiList.add(combustibileDettImpianti);
		for (SiceeDCombustibile c : elencoCombustibiliDettImpianti) {
			combustibileDettImpianti = CombustibileDettImpianti.Factory.newInstance();
			combustibileDettImpianti.setCodice(Converter.convertToBigInteger(c.getIdCombustibile()));
			combustibileDettImpianti.setDescrizione(c.getDescr());
			combustibileDettImpiantiList.add(combustibileDettImpianti);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoCombustibiliDettImpianti(e);
		
		log.debug("[MapDto::mapToElencoCombustibiliDettImpianti] end");
		return modDoc;
	}

	public static MODDocument mapToElencoConsumiCombustibile(MODDocument modDoc, List<SiceeDCombustibile> elencoConsumiCombustibile){
		log.debug("[MapDto::mapToElencoConsumiCombustibile] start");
		
		ElencoFontiEnergetiche e = ElencoFontiEnergetiche.Factory.newInstance();
		RowConsumiCombustibile consumiCombustibile = null;
		List<RowConsumiCombustibile> consumiCombustibileList = e.getRowConsumiCombustibileList();
		for (SiceeDCombustibile c : elencoConsumiCombustibile) {
			consumiCombustibile = RowConsumiCombustibile.Factory.newInstance();
			consumiCombustibile.setIdCombustibile(Converter.convertToBigInteger(c.getIdCombustibile()));
			consumiCombustibile.setDescrCombustibile(c.getDescr());
			consumiCombustibileList.add(consumiCombustibile);
	    }		
		
		modDoc.getMOD().getAttestato().getPrestEnergImpianti().setElencoFontiEnergetiche(e);
		
		log.debug("[MapDto::mapToElencoConsumiCombustibile] end");
		return modDoc;
	}

	public static ArrayList<VisuraImpianto> mapToImpianto(Impianto[] impianti)
	{
		log.debug("[MapDto::mapToImpianto] start");
		
		ArrayList<VisuraImpianto> visuraImpList = new ArrayList<VisuraImpianto>();
		ArrayList<VisuraRifCatastale> visuraRifCatastaleList = null;
		ArrayList<VisuraRappControllo> visuraRappControlloList = null;

		VisuraImpianto visImp = null;
		VisuraRifCatastale visRifCat = null;
		VisuraRappControllo visRappCont = null;
		

		if (impianti != null && impianti.length > 0)
		{
			int riga = 1;
			for (Impianto impianto : impianti) {
				visImp = new VisuraImpianto();
				visuraRifCatastaleList = new ArrayList<VisuraRifCatastale>();
				visuraRappControlloList = new ArrayList<VisuraRappControllo>();
				
				if (log.isDebugEnabled())
					GenericUtil.stampa(impianto, true, 3);
				
				visImp.setIdRigaTabella(riga++);
				visImp.setCodiceImpianto(BaseMgr.convertToUDTPositiveInteger(impianto.getCodiceImpianto()));
				visImp.setDescStato(impianto.getStato());
				visImp.setDtAssegnazione(Converter.convertToStringWeb(impianto.getDtAssegnazione()));
				visImp.setDtDismissione(Converter.convertToStringWeb(impianto.getDtDismissione()));
				visImp.setMotivoDisimissione(impianto.getMotivoDisimissione());
				visImp.setUbicazione(getUbicazioneByImpianto(impianto));
				visImp.setIdentResponsabile(getIdentificativoResp(impianto.getDenomResponsabile(), impianto.getCfResponsabile()));
				visImp.setIdent3Responsabile(getIdentificativoResp(impianto.getDenom3Responsabile(), impianto.getCf3Responsabile()));
				visImp.setDtUltAggLibretto(Converter.convertToStringWeb(impianto.getDtUltAggLibretto()));
				visImp.setUidIndexLibretto(impianto.getUidIndexLibretto());
				

				RifCatastale[] rifCatastali = impianto.getRifCatastale();

				if (rifCatastali != null && rifCatastali.length > 0)
				{
					for (RifCatastale rifCatastale : rifCatastali) {
						visRifCat = new VisuraRifCatastale();
						
						visRifCat.setSezione(rifCatastale.getSezione());
						visRifCat.setFoglio(rifCatastale.getFoglio());
						visRifCat.setParticella(rifCatastale.getParticella());
						visRifCat.setSubalterno(rifCatastale.getSubalterno());
						visRifCat.setPod(rifCatastale.getPod());
						visRifCat.setPdr(rifCatastale.getPdr());
						
						visuraRifCatastaleList.add(visRifCat);
						
					}
					
					visImp.setRifCatastale(visuraRifCatastaleList);
				}
				
				RappControllo[] rapControlli = impianto.getRappControllo();

				if (rapControlli != null && rapControlli.length > 0)
				{
					for (RappControllo rapControllo : rapControlli) {
						visRappCont = new VisuraRappControllo();
						
						visRappCont.setDescTipoDoc(rapControllo.getDescTipoDoc());
						if (rapControllo.getSiglaBollino() != null && rapControllo.getNumBollino() != null) {							
							visRappCont.setBollino(rapControllo.getSiglaBollino() + "-"+ rapControllo.getNumBollino());
						}
						visRappCont.setDtControllo(Converter.convertToStringWeb(rapControllo.getDtControllo()));
						visRappCont.setApparecchiature(rapControllo.getApparecchiature());
						visRappCont.setUidIndexLibretto(rapControllo.getUidIndexLibretto());
						//visRappCont.setLinkDownloadLib("Allegato");
						
						visuraRappControlloList.add(visRappCont);
					}
					
					visImp.setRappControllo(visuraRappControlloList);
				}
				
				visuraImpList.add(visImp);
			}
		}
		
		log.debug("[MapDto::mapToImpianto] end");
		
		return visuraImpList;
	}

	public static String getUbicazioneByImpianto(Impianto impianto)
	{
		log.debug("[MapDto::getUbicazioneByImpianto] start");
		

		StringBuffer ubicazione = new StringBuffer();
		
		ubicazione.append(impianto.getIndirizzo());
		
		if (!GenericUtil.isNullOrEmpty(impianto.getCivico()))
		{
			ubicazione.append(", ");

			ubicazione.append(impianto.getCivico());
		}

		if (!GenericUtil.isNullOrEmpty(impianto.getDescComune()))
		{
			ubicazione.append(" - ");

			ubicazione.append(impianto.getDescComune());
		}
		
		if (!GenericUtil.isNullOrEmpty(impianto.getSiglaProv()))
		{
			ubicazione.append(" (");

			ubicazione.append(impianto.getSiglaProv());
			ubicazione.append(")");
		}
		
		log.debug("[MapDto::getUbicazioneByImpianto] end");
		
		return ubicazione.toString();
	}
	
	public static String getIdentificativoResp(String denom, String cf)
	{
		log.debug("[MapDto::getIdentificativoResp] start");
		

		StringBuffer ubicazione = new StringBuffer();
		
		
		if (!GenericUtil.isNullOrEmpty(denom))
		{
			ubicazione.append(denom);
		}

		if (!GenericUtil.isNullOrEmpty(cf))
		{
			ubicazione.append(" (");

			ubicazione.append(cf);
			ubicazione.append(")");
		}
		
		
		log.debug("[MapDto::getIdentificativoResp] end");
		
		return ubicazione.toString();
	}
	
	public static DocumentoDocument mapImportToDocumentoDocument(byte[] theXml){
		try {
			log.debug("[MapDto::mapImportToDocumentoDocument] start");
			String theXmlString = ModolXFAReader.getXMLData(theXml, "documento");
			//log.debug("theXmlString " + theXmlString);
			InputStream is = new ByteArrayInputStream(XmlBeanUtils.readString(theXmlString));
			DocumentoDocument docXmlApeCompleto2015 = DocumentoDocument.Factory.parse(is);
			
			log.debug("[MapDto::mapImportToDocumentoDocument] end");
			return docXmlApeCompleto2015;
		} catch (XmlException e) {
			log.error("Errore mapImportToDocumentoDocument - XmlException",e);
			return null;
		} catch (IOException e) {
			log.error("Errore mapImportToDocumentoDocument - IOException",e);
			return null;
		} catch (ParserConfigurationException e) {
			log.error("Errore mapImportToDocumentoDocument - ParserConfigurationException",e);
			return null;
		} catch (SAXException e) {
			log.error("Errore mapImportToDocumentoDocument - SAXException",e);
			return null;
		}		
	}

	public static void mappaImportDatiGenericiReadOnly(
			DocumentoDocument docXmlApeCompleto2015, DatiGenericiDto datiGenericiDto)
			throws TrackingDbBEException, BEException {

		log.debug("\n\n\n >>>>>>> mappaImportDatiGenericiReadOnly");

		//final int SUBALTERNISINGOLI_PER_RIGA = 16;
		
		// datiAttestato (anno, idCertificatore, progrCertificatore: vale l'info su DB (ci deve obbligatoriamente essere)
		
		//*modDoc.getMOD().getAttestato().getDatiPrecompilati().setAnno(Converter.convertToBigInteger(datiGenericiDto.getCertificato().getAnno()));
		//*modDoc.getMOD().getAttestato().getDatiPrecompilati().setIdCertificatore(datiGenericiDto.getCertificato().getIdCertificatore());
		//*modDoc.getMOD().getAttestato().getDatiPrecompilati().setProgressivoCertificato(datiGenericiDto.getCertificato().getProgrCertificato());
		
		
		// datiAttestato (dataScadenza): Info da salvare su DB; check if null
		// se dataScadenza - dataEmissione > 2 anni allora dataEmissione = sysdate ; flag=10anni (FkScadenzaCert = 3) ; dataScadenza = dataEmissione + 10
		// se dataScadenza - dataEmissione < 2 anni allora dataEmissione = sysdate ; flag=31/12+1 (FkScadenzaCert = 2) ; dataScadenza = 31/12+1
		Date dtScadenza = null;
		Date dtEmissione = null;
		try{dtScadenza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiAttestato().getDataScadenza().getTime();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La data scadenza e' nulla o non e' in formato corretto", e); throw bee;}
		try{dtEmissione = docXmlApeCompleto2015.getDocumento().getApe2015().getDataEmissione().getTime();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La data emissione e' nulla o non e' in formato corretto", e); throw bee;}
		if ((dtEmissione != null) && (dtScadenza != null)) {
			if ((DateUtil.checkDateOrder(new Date(), dtScadenza, true)) == false) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("La data scadenza APE non deve essere antecedente alla data odierna", e); 
				throw bee;
			}
			if ((DateUtil.checkDateOrder(dtEmissione, dtScadenza, true)) == false) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("La data scadenza APE non deve essere antecedente alla data emissione APE", e); 
				throw bee;
			}
			if (DateUtil.isScadenzaSuccessivaANumAnni(dtScadenza, dtEmissione, 2)) {
				//*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				//*String dataStr = sdf.format(DateUtil.getAggiungi10Anni(new Date()));
				//*modDoc.getMOD().getAttestato().getDatiPrecompilati().setDataValidita(dataStr);
				datiGenericiDto.getCertificato().setDtInizio(new Date());
				datiGenericiDto.getCertificato().setFkScadenzaCert(Constants.ID_TIPO_SCADENZA_ANNO_10);
				datiGenericiDto.getCertificato().setDtScadenza(DateUtil.getAggiungi10Anni(new Date()));
			} else {
				//*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				//*String dataStr = sdf.format(DateUtil.getFineAnnoSuccessivo());
				//*modDoc.getMOD().getAttestato().getDatiPrecompilati().setDataValidita(dataStr);
				datiGenericiDto.getCertificato().setDtInizio(new Date());
				datiGenericiDto.getCertificato().setFkScadenzaCert(Constants.ID_TIPO_SCADENZA_ANNO_SUCCESSIVO);
				datiGenericiDto.getCertificato().setDtScadenza(DateUtil.getFineAnnoSuccessivo());
			}
		} 
		//*else {
		//*modDoc.getMOD().getAttestato().getDatiPrecompilati().setDataValidita("");
		//*}

		// datiGenerali (dataSopralluogo)
		Date dtSopralluogo = null;
		try{dtSopralluogo = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getDataSopralluogo().getTime();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La data sopralluogo e' nulla o non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getAltreInfo().setDataSopralluogo(dtSopralluogo);
		
		Integer tipologiaEdilizia;
		Integer tipologiaCostruttiva;
		try{tipologiaEdilizia = (int) docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getTipologiaEdilizia();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La tipologia edilizia non e' in formato numerico corretto", e); throw bee;}
		datiGenericiDto.getDatiGenerali().setFkTipolEdilizia(tipologiaEdilizia);
		try{tipologiaCostruttiva = (int) docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getTipologiaCostruttiva();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La tipologia costruttiva non e' in formato numerico corretto", e); throw bee;}
		datiGenericiDto.getDatiGenerali().setFkTipolCostruttiva(tipologiaCostruttiva);

		
		// OK
		// datiGenerali (destinazioneUso, classificazioneDPR412) : estrarre decodifica da DB; check if null
		Short codClassificazione = null;
		try{codClassificazione = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getClassificazioneDPR412();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il codice Classificazione DPR 412 e' nullo o non e' in formato corretto", e); throw bee;}
		if (codClassificazione != null) {
			
			
			// Setto la dest uso x il WEB
			datiGenericiDto.getDatiGenerali().setFkDestUso2015(Converter.convertToInteger(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getClassificazioneDPR412()));

			log.debug("Dentro MAPDTO datiGenericiDto.getDatiGenerali().getFkDestUso2015: "+datiGenericiDto.getDatiGenerali().getFkDestUso2015());
			
			if (datiGenericiDto.getDestinazioneUso2015().getFlgResidenziale().equalsIgnoreCase("S")) {
				//*modDoc.getMOD().getAttestato().getDatiGenerali().setFlagResidenziale("S");
				//*modDoc.getMOD().getAttestato().getDatiGenerali().setFlagNonResidenziale("N");
			} else {
				//*modDoc.getMOD().getAttestato().getDatiGenerali().setFlagResidenziale("N");
				//*modDoc.getMOD().getAttestato().getDatiGenerali().setFlagNonResidenziale("S");
			}
		} else {
			//modDoc.getMOD().getAttestato().getDatiGenerali().setCodClassificazione(null);
			//*modDoc.getMOD().getAttestato().getDatiGenerali().setFlagResidenziale(null);
			//*modDoc.getMOD().getAttestato().getDatiGenerali().setFlagNonResidenziale(null);
		}

		// OK
		// datiGenerali (oggettoAttestato, numeroUnitaImmobiliari, motivazione, descrizioneAltraMotivazione); check if null
		Short oggettoAttestato = null;
		try{oggettoAttestato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getOggettoAttestato();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'oggetto attestato e' nullo o non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiGenerali().setFkOggettoApe((int) oggettoAttestato);
		Integer numeroUnitaImmobiliari = null;
		try{numeroUnitaImmobiliari = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getNumeroUnitaImmobiliari();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il numero unita' immobiliari e' nullo o non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiGenerali().setNrUm(numeroUnitaImmobiliari);
		
		Short motivazione = null;
		try{motivazione = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getMotivazione();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La motivazione e' nulla o non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getAltreInfo().setFkMotivo(decodMotivazione(motivazione));
		String descrizioneAltraMotivazione = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDescrizioneAltraMotivazione();
		
		if (docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getAltraMotivazione() && StringUtils.isNotBlank(descrizioneAltraMotivazione)) {
			datiGenericiDto.getAltreInfo().setMotivoAltro(descrizioneAltraMotivazione);
		}
		
		// datiGenerali/datiIdentificativi (codiceISTAT)
		// Attenzione: nell'XML c'è un campo comune: non tenerne conto
		String istatComune = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getCodiceISTAT();
		datiGenericiDto.getCertificato().setIdComune(istatComune);
		datiGenericiDto.getCertificato().setDescComune(datiGenericiDto.getComune().getNome());
		datiGenericiDto.getCertificato().setIdProv(datiGenericiDto.getComune().getCodProv());
		datiGenericiDto.getCertificato().setDescProv(datiGenericiDto.getComune().getNomeProv());
		datiGenericiDto.getCertificato().setIdRegione(Constants.COD_REGIONE_PIEMONTE);
		datiGenericiDto.getCertificato().setDescRegione(Constants.DESC_REGIONE_PIEMONTE);
		// datiGenerali/datiIdentificativi (cap)
		datiGenericiDto.getCertificato().setCap(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getCAP());
		// datiGenerali/datiIdentificativi (indirizzo, civico)
		//String indirizzo = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getIndirizzo();
		String indirizzo = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getIndirizzo();
		if (BaseMgr.isNullOrEmpty(indirizzo)) {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il campo indirizzo non e' valorizzato", e); 
			throw bee;
		} else if (indirizzo.length() > 160) {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("La lunghezza dell'indirizzo e' maggiore di 160 caratteri", e); 
			throw bee;
		}


		datiGenericiDto.getCertificato().setDescIndirizzo(indirizzo.toUpperCase());
		String civico = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getCivico();
		if (!BaseMgr.isNullOrEmpty(civico) && (civico.length() > 10)) {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("La lunghezza del civico e' maggiore di 10 caratteri", e); 
			throw bee;
		}
		datiGenericiDto.getCertificato().setNumCivico(civico);

		datiGenericiDto.getCertificato().setIdIndirizzo(null); // il desc indirizzo importato non ha l'id stradario. se pre-esiste occorre annullarlo
		// datiCalcolo/risultatiCalcolo/edificioReale/indiciPrestazione (ht)
		BigDecimal ht;
		try{ht = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getIndiciPrestazione().getHT();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il coefficiente medio globale di scambio termico non e' in formato numerico", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setHt(Converter.convertToDouble(ht));
		// datiGenerali/datiIdentificativi (piano)
		Integer piano = null;
		if (BaseMgr.isNullOrEmpty(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getPiano())) {
			datiGenericiDto.getCertificato().setPiano(null);
		} else {
			if (docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getPiano().length() > 3) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("La lunghezza del piano e' maggiore di 3 caratteri", e); throw bee;}
			try{piano = Integer.parseInt(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getPiano());} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il piano non e' in formato numerico", e); throw bee;}		
			
			datiGenericiDto.getCertificato().setPiano(piano);
		}
		// datiGenerali/datiIdentificativi (interno)
		String interno = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getInterno();
		if (!BaseMgr.isNullOrEmpty(interno) && (interno.length() > 10)) {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("La lunghezza dell'interno e' maggiore di 10 caratteri", e); 
			throw bee;
		}
		datiGenericiDto.getCertificato().setInterno(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getInterno());
		// datiExtra (NPianiComplessivi, NPianiFTRisc)
		Integer nPianiComplessivi = null;
		Integer nPianiFTRisc = null;
		try{nPianiComplessivi = (int) docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getNPianiComplessivi();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il numero di piani complessivi non e' in formato numerico", e); throw bee;}		
		// nel caso in cui non esista il tag <NPianiComplessivi> (minOccurs="0") il metodo al posto di null restituisce scorrettamente e singolarmente uno zero
		if ((nPianiComplessivi == null) || (nPianiComplessivi.intValue() == 0)) {
			nPianiComplessivi = null;
		}
		datiGenericiDto.getCertificato().setNumPianiComplessivi(nPianiComplessivi);
		try{nPianiFTRisc = (int) docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getNPianiFTRisc();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il numero di piani fuori terra riscaldati non e' in formato numerico", e); throw bee;}		
		// nel caso in cui non esista il tag <NPianiFTRisc> (minOccurs="0") il metodo al posto di null restituisce scorrettamente e singolarmente uno zero
		if ((nPianiFTRisc == null) || (nPianiFTRisc.intValue() == 0)) {
			nPianiFTRisc = null;
		}
		datiGenericiDto.getCertificato().setNumPianiFTRisc(nPianiFTRisc);

		// TODO
		// datiExtra (dataTitoloAbilitativo, ??presenzaSitContabilizzazione??, proprietaEdificio)
		Date dtTitoloAbilitativo = null;
		if (docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getDataTitoloAbilitativo() != null) {
			try{dtTitoloAbilitativo = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getDataTitoloAbilitativo().getTime();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La data titolo abilitativo non e' in formato corretto", e); throw bee;}
		}
		datiGenericiDto.getDatiXml2015().setDtTitoloAbilitativo(dtTitoloAbilitativo);
		
		Integer proprietaEdificio = null;
		try{proprietaEdificio = (int) docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getProprietaEdificio();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La proprietà edificio non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiGenerali().setFkProprietaEdi(proprietaEdificio);

		// datiGenerali/datiIdentificativi (latitudineGIS, longitudineGIS)
		BigDecimal latitudineGIS = null;
		BigDecimal longitudineGIS = null;
		try{latitudineGIS = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getLatitudineGIS();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La latitudine e' nulla o non e' in formato corretto", e); throw bee;}
		try{longitudineGIS = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getLongitudineGIS();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La longitudine e' nulla o non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getCertificato().setCoordN(latitudineGIS.doubleValue());
		datiGenericiDto.getCertificato().setCoordE(longitudineGIS.doubleValue());
		// datiGenerali/datiIdentificativi (zonaClimatica); qualunque cosa sia scritto nell'XML, lo calcolo a partire dal comune
		datiGenericiDto.getDatiGenerali().setZonaClimatica(datiGenericiDto.getZonaClimatica());
		// datiExtra (gradiGiorno)
		//Integer gradiGiorno = null;
		//try{gradiGiorno = Converter.convertToInteger(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getGradiGiorno());} catch (Exception e) {BEException bee = new BEException("I gradi giorno sono nulli o non sono in formato corretto", e); throw bee;}
		//datiGenericiDto.getDatiGenerali().setGradiGiorno(gradiGiorno);
		//datiGenericiDto.getDatiXml2015().setGradiGiorno(gradiGiorno);

		Integer numCertifSw = null;
		try{numCertifSw = (int) docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getNumeroCertificatoSoftware();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il numero Certificato Software non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setNumCertifSw(numCertifSw);
		
		
		String softwareUtilizzato = null;
		try{softwareUtilizzato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getSoftwareUtilizzato();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il software utilizzato non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setSwUtilizzato(softwareUtilizzato);
		
		
		// datiGenerali/datiIdentificativi (annoCostruzione)
		Integer annoCostruzione;
		try{annoCostruzione = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getAnnoCostruzione();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'anno costruzione e' nullo o non e' in formato numerico corretto", e); throw bee;}
		datiGenericiDto.getDatiGenerali().setAnnoCostruzione(annoCostruzione);
		// datiCalcolo/datiGenerali (annoUltimaRistrutturazione)
		
		
		
		Integer annoUltimaRistrutturazione;
		try{annoUltimaRistrutturazione = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getAnnoUltimaRistrutturazione();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'anno ultima ristrutturazione e' nullo o non e' in formato numerico corretto", e); throw bee;}
		// nel caso in cui non esista il tag <AnnoRistrutturazione> (minOccurs="0") il metodo al posto di null restituisce scorrettamente e singolarmente uno zero
		if ((annoUltimaRistrutturazione == null) || (annoUltimaRistrutturazione.intValue() == 0)) {
			annoUltimaRistrutturazione = null;
		}
//		else if (annoUltimaRistrutturazione.intValue() > annoCostruzione.intValue())
//		{
//			Exception e = new Exception();
//			TrackingDbBEException bee = new TrackingDbBEException("L'anno di ristrutturazione non puo' essere precedente all'anno di costruzione", e); 
//			throw bee;
//		}
		
		datiGenericiDto.getDatiGenerali().setAnnoUltRist(annoUltimaRistrutturazione);	
		
		
		datiGenericiDto.getDatiGenerali().setCodiceEdificioScolastico(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getCodiceEdificioScolastico());

		
		// datiCalcolo/datiGenerali (tipologiaIntervento, tipologiaEdilizia, tipologiaCostruttiva)
		Integer tipologiaIntervento;

		try{tipologiaIntervento = (int) docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getDatiGenerali().getTipologiaIntervento();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La tipologia intervento non e' in formato numerico corretto", e); throw bee;}
		datiGenericiDto.getDatiGenerali().setFkTipoRistrutturaz(tipologiaIntervento);
		
		// datiGenerali/datiIdentificativi (superficieUtileRiscaldata, superficieUtileRaffrescata, volumeLordoRiscaldato, volumeLordoRaffrescato)
		BigDecimal superficieUtileRiscaldata = null;
		BigDecimal superficieUtileRaffrescata = null;
		BigDecimal volumeLordoRiscaldato = null;
		BigDecimal volumeLordoRaffrescato = null;

		try{superficieUtileRiscaldata = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getSuperficieUtileRiscaldata();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La superficie utile riscaldata e' nulla o non e' in formato corretto", e); throw bee;}
		try{superficieUtileRaffrescata = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getSuperficieUtileRaffrescata();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La superficie utile raffrescata e' nulla o non e' in formato corretto", e); throw bee;}
		try{volumeLordoRiscaldato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getVolumeLordoRiscaldato();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il volume lordo riscaldato e' nullo o non e' in formato corretto", e); throw bee;}
		try{volumeLordoRaffrescato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getVolumeLordoRaffrescato();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il volume lordo raffrescato e' nullo o non e' in formato corretto", e); throw bee;}
		if ((superficieUtileRiscaldata != null) && (superficieUtileRiscaldata.doubleValue() >= 0)) {
			datiGenericiDto.getDatiGenerali().setSupRiscaldata(Converter.convertToDouble(superficieUtileRiscaldata));
		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("La superficie utile riscaldata deve essere maggiore o uguale a zero", e);
			throw bee;
		}
		if ((superficieUtileRaffrescata != null) && (superficieUtileRaffrescata.doubleValue() >= 0)) {
			datiGenericiDto.getDatiGenerali().setSupRaffrescata(Converter.convertToDouble(superficieUtileRaffrescata));
		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("La superficie utile raffrescata deve essere maggiore o uguale a zero", e);
			throw bee;
		}
		if ((volumeLordoRiscaldato != null) && (volumeLordoRiscaldato.doubleValue() >= 0)) {
			datiGenericiDto.getDatiGenerali().setVolLordoRiscaldato(Converter.convertToDouble(volumeLordoRiscaldato));
		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il volume lordo riscaldato deve essere maggiore o uguale a zero", e);
			throw bee;
		}
		
		if ((volumeLordoRaffrescato != null) && (volumeLordoRaffrescato.doubleValue() >= 0)) {
			datiGenericiDto.getDatiGenerali().setVolLordoRaffrescato(Converter.convertToDouble(volumeLordoRaffrescato));
		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il volume lordo raffrescato deve essere maggiore o uguale a zero", e);
			throw bee;
		}

		
		
		// datiCalcolo/fabbricato/altriDatiSintetici (superficieOpacaTotale, superficieVetrataTotale, superficieOpacaTrasmittanzaMedia, superficieVetrataTrasmittanzaMedia)
		// datiCalcolo/fabbricato/altriDatiSintetici (portataVentilazioneEffettivaTotale, tipologiaVentilazione, efficienzaRecuperoMedia)
		BigDecimal superficieOpacaTotale = null;
		BigDecimal superficieVetrataTotale = null;
		BigDecimal superficieOpacaTrasmittanzaMedia = null;
		BigDecimal superficieVetrataTrasmittanzaMedia = null;
		BigDecimal portataVentilazioneEffettivaTotale = null;
		Integer tipologiaVentilazione = null;
		BigDecimal efficienzaRecuperoMedia = null;
		try{superficieOpacaTotale = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getFabbricato().getAltriDatiSintetici().getSuperficieOpacaTotale();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La superficie opaca totale non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setSupDispTotOpaca(Converter.convertToDouble(superficieOpacaTotale));
		try{superficieVetrataTotale = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getFabbricato().getAltriDatiSintetici().getSuperficieVetrataTotale();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La superficie vetrata totale non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setSupDispTotTrasp(Converter.convertToDouble(superficieVetrataTotale));
		try{superficieOpacaTrasmittanzaMedia = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getFabbricato().getAltriDatiSintetici().getSuperficieOpacaTrasmittanzaMedia();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La Trasmittanza media della superficie opaca totale non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setTrasmittanzaMedSupOpache(Converter.convertToDouble(superficieOpacaTrasmittanzaMedia));
		try{superficieVetrataTrasmittanzaMedia = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getFabbricato().getAltriDatiSintetici().getSuperficieVetrataTrasmittanzaMedia();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La Trasmittanza media della superficie vetrata totale non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setTrasmittanzaMedSupTrasp(Converter.convertToDouble(superficieVetrataTrasmittanzaMedia));
		try{portataVentilazioneEffettivaTotale = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getFabbricato().getAltriDatiSintetici().getPortataVentilazioneEffettivaTotale();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La portata della ventilazione effettiva totale non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setPortataVentilazioneTot(Converter.convertToDouble(portataVentilazioneEffettivaTotale));
		try{tipologiaVentilazione = (int) docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getFabbricato().getAltriDatiSintetici().getTipologiaVentilazione();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La tipologia della ventilazione non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setFkTipoVentilazione(tipologiaVentilazione);
		try{efficienzaRecuperoMedia = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getFabbricato().getAltriDatiSintetici().getEfficienzaRecuperoMedia();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La efficienza recupero media non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXml2015().setEfficienzaRecuperoMedio(Converter.convertToDouble(efficienzaRecuperoMedia));

		// datiCalcolo/RisultatiCalcolo/edificioReale/fabbisogni/valoriAnnuali/riscaldamento/involucro (extraFlusso, trasmissione, ventilazione, apportiSolari)
		// datiCalcolo/RisultatiCalcolo/edificioReale/fabbisogni/valoriAnnuali/riscaldamento/involucro (apportiInterni, apportiLatenti, qhnd, qlr, qhimp)
		BigDecimal extraFlusso = null;
		BigDecimal trasmissione = null;
		BigDecimal ventilazione = null;
		BigDecimal apportiSolari = null;
		BigDecimal apportiInterni = null;
		BigDecimal apportiLatenti = null;
		BigDecimal qhnd = null;
		BigDecimal qlr = null;
		BigDecimal qhimp = null;
		
		
		if (log.isDebugEnabled())
		{
			log.debug("############# PROBLEMA BIG DECIMAL - start #############");
		
			log.debug("xml 2015: "+docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getExtraFlusso());
			log.debug("convert: "+Converter.convertToFloat(extraFlusso));
		}
		
		try{extraFlusso = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getExtraFlusso();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'extra flusso non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroExtraFlus(Converter.convertToDouble(extraFlusso));
		
		if (log.isDebugEnabled())
			log.debug("su datiGenericiDto: "+datiGenericiDto.getDatiXmlEdReale2015().getFabbRiscInvolucroExtraFlus());
		
		try{trasmissione = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getTrasmissione();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La trasmissione non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroTrasmissio(Converter.convertToDouble(trasmissione));
		try{ventilazione = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getVentilazione();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("La ventilazione non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroVentilazio(Converter.convertToDouble(ventilazione));
		try{apportiSolari = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getApportiSolari();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'apporto solare non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroApportiSo(Converter.convertToDouble(apportiSolari));
		try{apportiInterni = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getApportiInterni();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'apporto interno non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroApportiIn(Converter.convertToDouble(apportiInterni));
		try{apportiLatenti = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getApportiLatenti();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'apporto latente non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroApportiLa(Converter.convertToDouble(apportiLatenti));
		try{qhnd = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getQHnd();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il QHnd non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroQhnd(Converter.convertToDouble(qhnd));
		try{qlr = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getQlr();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il Qlr non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroQlr(Converter.convertToDouble(qlr));
		try{qhimp = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getInvolucro().getQHimp();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il QHimp non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscInvolucroQhimp(Converter.convertToDouble(qhimp));

		//datiCalcolo/RisultatiCalcolo/edificioReale/fabbisogni/valoriAnnuali/riscaldamento/impianto/regolazione (ETAr)
		BigDecimal ETAr = null;
		try{ETAr = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getImpianto().getRegolazione().getETAr();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'ETAr non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscImpiantoEtar(Converter.convertToDouble(ETAr));
		//datiCalcolo/RisultatiCalcolo/edificioReale/fabbisogni/valoriAnnuali/riscaldamento/impianto/distribuzione (ETAd)
		BigDecimal ETAd = null;
		try{ETAd = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getImpianto().getDistribuzione().getETAd();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'ETAd non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscImpiantoEtad(Converter.convertToDouble(ETAd));
		//datiCalcolo/RisultatiCalcolo/edificioReale/fabbisogni/valoriAnnuali/riscaldamento/impianto/emissione (ETAe)
		BigDecimal ETAe = null;
		try{ETAe = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getImpianto().getEmissione().getETAe();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'ETAe non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscImpiantoEtae(Converter.convertToDouble(ETAe));
		//datiCalcolo/RisultatiCalcolo/edificioReale/fabbisogni/valoriAnnuali/riscaldamento/impianto/generazione (ETAg)
		BigDecimal ETAg = null;
		try{ETAg = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioReale().getFabbisogni().getValoriAnnuali().getRiscaldamento().getImpianto().getGenerazione().getETAg();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'ETAg non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdReale2015().setFabbRiscImpiantoEtag(Converter.convertToDouble(ETAg));
		
		// datiCalcolo/RisultatiCalcolo/edificioRiferimento (Qh, Qc, EPhnd, EPcnd, EPh, Epc, Epw)
		// datiCalcolo/RisultatiCalcolo/edificioRiferimento (EPv, EP, EPglnr, EPglr, EPgltot, ETAh, ETAc, ETAw)
		BigDecimal Qh = null;
		BigDecimal Qc = null;
		BigDecimal EPhnd = null;
		BigDecimal EPcnd = null;
		BigDecimal EPh = null;
		BigDecimal EPc = null;
		BigDecimal EPw = null;
		BigDecimal EPv = null;
		BigDecimal EPl = null;
		BigDecimal EPglnr = null;
		BigDecimal EPglr = null;
		BigDecimal EPgltot = null;
		BigDecimal ETAh = null;
		BigDecimal ETAc = null;
		BigDecimal ETAw = null;
		try{Qh = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getQh();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il Qh non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setQh(Converter.convertToDouble(Qh));
		try{Qc = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getQc();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il Qc non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setQc(Converter.convertToDouble(Qc));
		try{EPhnd = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEPhnd();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPhnd non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEphnd(Converter.convertToDouble(EPhnd));
		try{EPcnd = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEPcnd();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPcnd non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpcnd(Converter.convertToDouble(EPcnd));
		try{EPh = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEP().getEPh();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPh non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEph(Converter.convertToDouble(EPh));
		try{EPc = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEP().getEPc();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPc non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpc(Converter.convertToDouble(EPc));
		try{EPw = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEP().getEPw();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPw non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpw(Converter.convertToDouble(EPw));
		try{EPv = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEP().getEPv();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPv non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpv(Converter.convertToDouble(EPv));
		try{EPl = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEP().getEPl();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPl non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpl(Converter.convertToDouble(EPl));
		try{EPglnr = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEPnr().getEPgl();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPgl (nr) non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpglnr(Converter.convertToDouble(EPglnr));
		try{EPglr = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEPr().getEPgl();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPgl (r) non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpglr(Converter.convertToDouble(EPglr));
		try{EPgltot = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getEP().getEP().getEPgl();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'EPgl (tot) non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEpgltot(Converter.convertToDouble(EPgltot));
		try{ETAh = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getETAh();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'ETAh non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEtah(Converter.convertToDouble(ETAh));
		try{ETAc = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getETAc();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'ETAc non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEtac(Converter.convertToDouble(ETAc));
		try{ETAw = docXmlApeCompleto2015.getDocumento().getDatiCalcolo().getRisultatiCalcolo().getEdificioRiferimentoCL().getETAw();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("L'ETAw non e' in formato corretto", e); throw bee;}
		datiGenericiDto.getDatiXmlEdRif2015().setEtaw(Converter.convertToDouble(ETAw));
		
		// datiGenerali/datiIdentificativi/datiCatasto
		
		
		List<SiceeTDaticatastSec> datiCatastaliSecList = new ArrayList<SiceeTDaticatastSec>();
		
		List<TypeDatiCatastali> dcXmlApeList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getCatasto().getDatiCatastaliList();
		
		
		int iRow = 0;
		boolean isSubPresenti = false;
		for (TypeDatiCatastali dcXmlApeRow : dcXmlApeList) {
			
			isSubPresenti = false;
			
			String codiceCatastale = dcXmlApeRow.getCodiceCatastale();
			
			short tipoCat = dcXmlApeRow.getTipoCatasto(); // 0=Catasto Terreni --> NCT ; 1=Catasto Fabbricati --> NCEU ; 2=Catasto Tavolare --> CT
			String tipoCatasto = null;
			if (tipoCat == 0)
			{
				tipoCatasto = Constants.ID_RIF_CATASTO_NCT;
			}
			else if (tipoCat == 1)
			{
				tipoCatasto = Constants.ID_RIF_CATASTO_NCEU;

			} else if (tipoCat == 2)
			{
				tipoCatasto = Constants.ID_RIF_CATASTO_CT;

			}
			//String tipoCatasto = dcXmlApeRow.getTipoCatasto() == 0  ? "NCT" : "NCEU"; // 0=Catasto Terreni --> NCT ; 1=Catasto Fabbricati --> NCEU
			
			String sezione = dcXmlApeRow.getSezione();
			if (!BaseMgr.isNullOrEmpty(sezione) && (sezione.length() > 5)) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("La lunghezza della sezione e' maggiore di 5 caratteri", e); 
				throw bee;
			}

			String foglio = dcXmlApeRow.getFoglio();
			if (BaseMgr.isNullOrEmpty(foglio)) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("Il foglio principale e' nullo", e); 
				throw bee;
			} else if (foglio.length() > 5) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("La lunghezza del foglio e' maggiore di 5 caratteri", e); 
				throw bee;
			}

			String particella = dcXmlApeRow.getParticella();
			if (BaseMgr.isNullOrEmpty(particella)) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("La particella principale e' nulla", e); 
				throw bee;
			} else if (particella.length() > 9) {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("La lunghezza della particella e' maggiore di 9 caratteri", e); 
				throw bee;
			}
			List<String> subDAList = new ArrayList<String>();
			List<String> subAList = new ArrayList<String>();
			if (dcXmlApeRow.getSubalterni() != null) {
				subDAList = dcXmlApeRow.getSubalterni().getSubDAList();
				subAList = dcXmlApeRow.getSubalterni().getSubAList();
			}
			
			
			if (iRow == 0) {
				
				//*rdc.setFlagPrincipale(true);
				// Setto il subalterno principale
				datiGenericiDto.getCertificato().setCodiceComuneCatastale(codiceCatastale);
				datiGenericiDto.getCertificato().setRifCatasto(tipoCatasto);
				datiGenericiDto.getCertificato().setSezione(sezione);
				datiGenericiDto.getCertificato().setFoglio(foglio);
				datiGenericiDto.getCertificato().setParticella(particella);
				if (subDAList.size() >= 1)
					datiGenericiDto.getCertificato().setSubalterno(subDAList.get(0));
				else
					datiGenericiDto.getCertificato().setSubalterno(null);
			}
			

			/* 
			else {
				rdc.setFlagPrincipale(false);
			}
			
			
			rdc.setComuneCatastale(codiceCatastale);
			rdc.setSezione(sezione);
			rdc.setFoglio(foglio);
			rdc.setParticella(particella);
			 */
			
			int da1 = 0;
			int a1 = 0;
			int da2 = 0;
			int a2 = 0;
			int da3 = 0;
			int a3 = 0;
			int da4 = 0;
			int a4 = 0;

			boolean subDAListNotEmpty = false;
			boolean subAListNotEmpty = false;
			
			if (log.isDebugEnabled())
			{
				log.debug("mappaImportDatiGenericiReadOnly: subDAList: "+subDAList);
				log.debug("mappaImportDatiGenericiReadOnly: subDAList.size(): "+subDAList.size());
	
				log.debug("mappaImportDatiGenericiReadOnly: subAList: "+subAList);
				log.debug("mappaImportDatiGenericiReadOnly: subAList.size(): "+subAList.size());
			}
			
			if ((subDAList.size() >= 1) && (subAList.size() >= 1)) {
				
				subDAListNotEmpty = (!BaseMgr.isNullOrEmpty(subDAList.get(0)));
				subAListNotEmpty = (!BaseMgr.isNullOrEmpty(subAList.get(0)));
				
				if (log.isDebugEnabled())
				{
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
					log.debug("mappaImportDatiGenericiReadOnly: subDAList.get(0): "+subDAList.get(0));
					log.debug("mappaImportDatiGenericiReadOnly: subDAListNotEmpty: "+subDAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: subAList.get(0): "+subAList.get(0));
					log.debug("mappaImportDatiGenericiReadOnly: subAListNotEmpty: "+subAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
				}
				
				if (subDAListNotEmpty != subAListNotEmpty)
				{
					Exception e = new Exception(); 
					TrackingDbBEException bee = new TrackingDbBEException("Se indicato il subalterno da1 e' necessario indicare anche a1 e viceversa", e); 
					throw bee;
				}
				
				if (subDAListNotEmpty) {
					
					if (subDAList.get(0).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da1 e' maggiore di 4 caratteri", e); throw bee;}
					try{da1 = Converter.convertToBigInteger(subDAList.get(0)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da1 non e' in formato numerico", e); throw bee;}
					//*rdc.setDa1(Converter.convertToBigInteger(da1));
				}
				
				if (subAListNotEmpty) {
					if (subAList.get(0).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a1 e' maggiore di 4 caratteri", e); throw bee;}
					try{a1 = Converter.convertToBigInteger(subAList.get(0)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a1 non e' in formato numerico", e); throw bee;}
					//*rdc.setA1(Converter.convertToBigInteger(da1));
				}
				
				if (a1 < da1) {
					Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a1 e' minore di da1", e); throw bee;
					} else 
					{
						if (iRow == 0) 
						{
							// Nel caso in cui l'utente ha impostato da1 a1 con lo stesso numero, non devo inserirlo nei secondari perchè è già presente nel principale
							if (a1 != da1)
							{

								// Se invece a1 è diverso da da1 devo inserire a1+1 nei datoCatastaleSec, nel caso sia il principale
								mappaDatiCatastaliSec(da1+1, a1, datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
								isSubPresenti = true;
							}
						} else if (a1 > 0 && da1 > 0)
						{
							mappaDatiCatastaliSec(da1, a1, datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
							isSubPresenti = true;
						}
					}
				
			}
			
			if ((subDAList.size() >= 2) && (subAList.size() >= 2)) {

				subDAListNotEmpty = (!BaseMgr.isNullOrEmpty(subDAList.get(1)));
				subAListNotEmpty = (!BaseMgr.isNullOrEmpty(subAList.get(1)));
				
				if (log.isDebugEnabled())
				{
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
					log.debug("mappaImportDatiGenericiReadOnly: subDAList.get(1): "+subDAList.get(1));
					log.debug("mappaImportDatiGenericiReadOnly: subDAListNotEmpty: "+subDAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: subAList.get(1): "+subAList.get(1));
					log.debug("mappaImportDatiGenericiReadOnly: subAListNotEmpty: "+subAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
				}
				
				if (subDAListNotEmpty != subAListNotEmpty)
				{
					Exception e = new Exception(); 
					TrackingDbBEException bee = new TrackingDbBEException("Se indicato il subalterno da2 e' necessario indicare anche a2 e viceversa", e); 
					throw bee;
				}
				
				if (!BaseMgr.isNullOrEmpty(subDAList.get(1)))
				{
					if (subDAList.get(1).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da2 e' maggiore di 4 caratteri", e); throw bee;}
					try{da2 = Converter.convertToBigInteger(subDAList.get(1)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da2 non e' in formato numerico", e); throw bee;}
				}
				if (!BaseMgr.isNullOrEmpty(subAList.get(1)))
				{
					if (subAList.get(1).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a2 e' maggiore di 4 caratteri", e); throw bee;}
					try{a2 = Converter.convertToBigInteger(subAList.get(1)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a2 non e' in formato numerico", e); throw bee;}
				}
				
				if (a2 < da2) {
					Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a2 e' minore di da2", e); throw bee;
				}
				else if (a2 > 0 && da2 > 0)
				{
					mappaDatiCatastaliSec(da2, a2, datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
					isSubPresenti = true;

				}


			}
			
			if ((subDAList.size() >= 3) && (subAList.size() >= 3)) {
				
				subDAListNotEmpty = (!BaseMgr.isNullOrEmpty(subDAList.get(2)));
				subAListNotEmpty = (!BaseMgr.isNullOrEmpty(subAList.get(2)));
				
				if (log.isDebugEnabled())
				{
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
					log.debug("mappaImportDatiGenericiReadOnly: subDAList.get(2): "+subDAList.get(2));
					log.debug("mappaImportDatiGenericiReadOnly: subDAListNotEmpty: "+subDAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: subAList.get(2): "+subAList.get(2));
					log.debug("mappaImportDatiGenericiReadOnly: subAListNotEmpty: "+subAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
				}
				
				if (subDAListNotEmpty != subAListNotEmpty)
				{
					Exception e = new Exception(); 
					TrackingDbBEException bee = new TrackingDbBEException("Se indicato il subalterno da3 e' necessario indicare anche a3 e viceversa", e); 
					throw bee;
				}
				
				if (!BaseMgr.isNullOrEmpty(subDAList.get(2)))
				{
					if (subDAList.get(2).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da3 e' maggiore di 4 caratteri", e); throw bee;}
					try{da3 = Converter.convertToBigInteger(subDAList.get(2)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da3 non e' in formato numerico", e); throw bee;}
				}
				if (!BaseMgr.isNullOrEmpty(subAList.get(2)))
				{
					if (subAList.get(2).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a3 e' maggiore di 4 caratteri", e); throw bee;}
					try{a3 = Converter.convertToBigInteger(subAList.get(2)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a3 non e' in formato numerico", e); throw bee;}
				}
				
				if (a3 < da3) {
					Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a3 e' minore di da3", e); throw bee;
				} 
				else  if (a3 > 0 && da3 > 0)
				{
					mappaDatiCatastaliSec(da3, a3, datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
					isSubPresenti = true;
				}

			}
			
			if ((subDAList.size() >= 4) && (subAList.size() >= 4)) {
				
				subDAListNotEmpty = (!BaseMgr.isNullOrEmpty(subDAList.get(3)));
				subAListNotEmpty = (!BaseMgr.isNullOrEmpty(subAList.get(3)));

				if (log.isDebugEnabled())
				{
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
					log.debug("mappaImportDatiGenericiReadOnly: subDAList.get(3): "+subDAList.get(3));
					log.debug("mappaImportDatiGenericiReadOnly: subDAListNotEmpty: "+subDAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: subAList.get(3): "+subAList.get(3));
					log.debug("mappaImportDatiGenericiReadOnly: subAListNotEmpty: "+subAListNotEmpty);
					log.debug("mappaImportDatiGenericiReadOnly: ----------------------");
				}
				
				if (subDAListNotEmpty != subAListNotEmpty)
				{
					Exception e = new Exception(); 
					TrackingDbBEException bee = new TrackingDbBEException("Se indicato il subalterno da4 e' necessario indicare anche a4 e viceversa", e); 
					throw bee;
				}
				
				if (!BaseMgr.isNullOrEmpty(subDAList.get(3)))
				{
					if (subDAList.get(3).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da4 e' maggiore di 4 caratteri", e); throw bee;}
					try{da4 = Converter.convertToBigInteger(subDAList.get(3)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno da4 non e' in formato numerico", e); throw bee;}
				}
				if (!BaseMgr.isNullOrEmpty(subAList.get(3)))
				{
					if (subAList.get(3).length() > 4) {Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a4 e' maggiore di 4 caratteri", e); throw bee;}
					try{a4 = Converter.convertToBigInteger(subAList.get(3)).intValue();} catch (Exception e) {TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a4 non e' in formato numerico", e); throw bee;}
				}
				
				if (a4 < da4) {
					Exception e = new Exception(); TrackingDbBEException bee = new TrackingDbBEException("Il subalterno a4 e' minore di da4", e); throw bee;
					} else  if (a4 > 0 && da4 > 0)
					{
						mappaDatiCatastaliSec(da4, a4, datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
						isSubPresenti = true;
					}

			}
			
			List<String> subAltriList = dcXmlApeRow.getAltriSubalterniList();
			//*int subAltriNumero = subAltriList.size();
			
			for (String subalterno : subAltriList) {
				
				if (!GenericUtil.isNullOrEmpty(subalterno))
				{
					mappaDatiCatastaliSec(subalterno, datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
					isSubPresenti = true;
				}
			}
			
			if (log.isDebugEnabled())
			{
				log.debug("mappaImportDatiGenericiReadOnly: iRow - "+iRow);
				log.debug("mappaImportDatiGenericiReadOnly: sezione - "+sezione + "; foglio - "+ foglio + "; particella - "+particella);
				log.debug("mappaImportDatiGenericiReadOnly: isSubPresenti - "+isSubPresenti);
			}
			
			if (iRow != 0 && !isSubPresenti)
			{
				mappaDatiCatastaliSec(null, datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
			}
			
			iRow++;	
		}
		
		// setto la lista dei dati catastali
		datiGenericiDto.setDatiCatastaliSec(datiCatastaliSecList);
		
		// datiGenerali/serviziEnergeticiPresenti
		String tmpFlag = null;
		try{tmpFlag = Converter.convertToString(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getServiziEnergeticiPresenti().getClimatizzazioneInvernale());}catch (Exception e) {tmpFlag = null;}
		datiGenericiDto.getDatiEner2015().setFlgClimatInvernale(tmpFlag);
		
		try{tmpFlag = Converter.convertToString(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getServiziEnergeticiPresenti().getClimatizzazioneEstiva());}catch (Exception e) {tmpFlag = null;}
		datiGenericiDto.getDatiEner2015().setFlgClimatEstiva(tmpFlag);

		try{tmpFlag = Converter.convertToString(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getServiziEnergeticiPresenti().getVentilazioneMeccanica());}catch (Exception e) {tmpFlag = null;}
		datiGenericiDto.getDatiEner2015().setFlgVentilMeccanica(tmpFlag);

		try{tmpFlag = Converter.convertToString(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getServiziEnergeticiPresenti().getProduzioneAcquaCaldaSanitaria());}catch (Exception e) {tmpFlag = null;}
		datiGenericiDto.getDatiEner2015().setFlgProdH2oSanitaria(tmpFlag);

		try{tmpFlag = Converter.convertToString(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getServiziEnergeticiPresenti().getIlluminazione());}catch (Exception e) {tmpFlag = null;}
		datiGenericiDto.getDatiEner2015().setFlgIlluminazione(tmpFlag);

		try{tmpFlag = Converter.convertToString(docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getServiziEnergeticiPresenti().getTrasportoPersoneCose());}catch (Exception e) {tmpFlag = null;}
		datiGenericiDto.getDatiEner2015().setFlgTrasportoPersCose(tmpFlag);

		//return modDoc;
	}
	
	private static void mappaDatiCatastaliSec(int da, int a, DatiGenericiDto datiGenericiDto, String codiceCatastale, String sezione, String foglio, String particella, List<SiceeTDaticatastSec> datiCatastaliSecList)
	{
		
		for (int i = da; i < a+1; i++) {
			
			mappaDatiCatastaliSec(Converter.convertToString(i), datiGenericiDto, codiceCatastale, sezione, foglio, particella, datiCatastaliSecList);
			
		}
		
		
	}

	private static void mappaDatiCatastaliSec(String subalterno, DatiGenericiDto datiGenericiDto, String codiceCatastale, String sezione, String foglio, String particella, List<SiceeTDaticatastSec> datiCatastaliSecList)
	{
		SiceeTDaticatastSec datoCatastaleSec = new SiceeTDaticatastSec();


		// Rimappo i dati comuni 
		datoCatastaleSec.setIdCertificatore(datiGenericiDto.getCertificato().getIdCertificatore());
		datoCatastaleSec.setProgrCertificato(datiGenericiDto.getCertificato().getProgrCertificato());
		datoCatastaleSec.setAnno(datiGenericiDto.getCertificato().getAnno());
		datoCatastaleSec.setCodiceComuneCatastale(codiceCatastale);
		datoCatastaleSec.setSezione(sezione);
		datoCatastaleSec.setFoglio(foglio);
		datoCatastaleSec.setParticella(particella);
		datoCatastaleSec.setIdProv(datiGenericiDto.getCertificato().getIdProv());
		datoCatastaleSec.setDescProv(datiGenericiDto.getCertificato().getDescProv());
		datoCatastaleSec.setIdComune(datiGenericiDto.getCertificato().getIdComune());
		datoCatastaleSec.setDescComune(datiGenericiDto.getCertificato().getDescComune());

		datoCatastaleSec.setSubalterno(subalterno);

		datiCatastaliSecList.add(datoCatastaleSec);



	}

	public static void mappaImportPrestazioniReadOnly(
			DocumentoDocument docXmlApeCompleto2015, DatiGenericiDto datiGenericiDto, List<SiceeDCombustibile> elencoConsumiCombustibile, List<SiceeDClasseEnergetica> classiEnergetiche)
			throws TrackingDbBEException, BEException {

		log.debug("\n\n\n >>>>>>> mappaImportPrestazioniReadOnly");
		// prestazioneGlobale/prestazioneEnergeticaGlobale (edificioEnergiaQuasiZero)
		String tmpFlag = null;
		try{tmpFlag = Converter.convertToString(docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getPrestazioneEnergeticaGlobale().getEdificioEnergiaQuasiZero());}catch (Exception e) {tmpFlag = null;}
		//*modDoc.getMOD().getAttestato().getPrestEnergFabb().setFlagEdifEnergZero(tmpFlag);
		datiGenericiDto.getDatiEner2015().setFlgEdifE0(tmpFlag);
		
		// prestazioneGlobale/riferimenti/classificazione nuovi ed esistenti (classeEnergetica, epglnren)
		BigDecimal epglnren = null;

		String classeEnergeticaNuovi = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getRiferimenti().getClassificazioneNuovi().getClasseEnergetica().toString();
		if (classeEnergeticaNuovi != null)
		{
			//*modDoc.getMOD().getAttestato().getPrestEnergFabb().setClasseEdNuovi(classeEnergeticaNuovi);
			datiGenericiDto.getDatiEner2015().setFkClasseEnerNuovi(decodClasseEnergeticaDescr(classeEnergeticaNuovi, classiEnergetiche));
		}
		
		
		try{epglnren = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getRiferimenti().getClassificazioneNuovi().getEpglnren();}catch (Exception e) {epglnren = null;}
		if ((epglnren != null) && (epglnren.doubleValue() >= 0)) {
			//*modDoc.getMOD().getAttestato().getPrestEnergFabb().setEpglnrenEdNuovi(epglnren);
			datiGenericiDto.getDatiEner2015().setEpglNrenNuovi(Converter.convertToDouble(epglnren));
		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore EPgl,nren nuovi edifici deve essere maggiore o uguale a zero", e);
			throw bee;
		}
		
		String classeEnergeticaEsistenti = null;
		try{classeEnergeticaEsistenti = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getRiferimenti().getClassificazioneEsistenti().getClasseEnergetica().toString();}catch (Exception e) {classeEnergeticaEsistenti = null;}
		if (classeEnergeticaEsistenti != null)
		{
			//*modDoc.getMOD().getAttestato().getPrestEnergFabb().setClasseEdEsistenti(classeEnergeticaEsistenti);
			datiGenericiDto.getDatiEner2015().setFkClasseEnerEsistenti(decodClasseEnergeticaDescr(classeEnergeticaEsistenti, classiEnergetiche));
		}
		
		try{epglnren = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getRiferimenti().getClassificazioneEsistenti().getEpglnren();}catch (Exception e) {epglnren = null;}
		if (epglnren != null) {
			if (epglnren.doubleValue() >= 0) {
				//*modDoc.getMOD().getAttestato().getPrestEnergFabb().setEpglnrenEdEsistenti(epglnren);
				datiGenericiDto.getDatiEner2015().setEpglNrenEsistenti(Converter.convertToDouble(epglnren));
			} else {
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("Il valore EPgl,nren edifici esistenti deve essere maggiore o uguale a zero", e);
				throw bee;
			}
		}

		BigDecimal consumoAnnuoEER = null; Short consumoAnnuoUMEER = null;
		BigDecimal consumoAnnuoGN = null; Short consumoAnnuoUMGN = null;
		BigDecimal consumoAnnuoGPL = null; Short consumoAnnuoUMGPL = null;
		BigDecimal consumoAnnuoCarbone = null; Short consumoAnnuoUMCarbone = null;
		//BigDecimal consumoAnnuoGasolio = null; Short consumoAnnuoUMGasolio = null;
		BigDecimal consumoAnnuoGasol = null; Short consumoAnnuoUMGasol = null;
		BigDecimal consumoAnnuoOlio = null; Short consumoAnnuoUMOlio = null;
		BigDecimal consumoAnnuoBMS = null; Short consumoAnnuoUMBMS = null;
		BigDecimal consumoAnnuoBML = null; Short consumoAnnuoUMBML = null;
		BigDecimal consumoAnnuoBMG = null; Short consumoAnnuoUMBMG = null;
		BigDecimal consumoAnnuoSF = null; Short consumoAnnuoUMSF = null;
		BigDecimal consumoAnnuoST = null; Short consumoAnnuoUMST = null;
		BigDecimal consumoAnnuoEolico = null; Short consumoAnnuoUMEolico = null;
		BigDecimal consumoAnnuoTR = null; Short consumoAnnuoUMTR = null;
		BigDecimal consumoAnnuoTF = null; Short consumoAnnuoUMTF = null;
		BigDecimal consumoAnnuoAltro = null; Short consumoAnnuoUMAltro = null; String descrizioneAltro = null;
		try{consumoAnnuoEER = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEnergiaElettricaRete().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoEER = null;}
		try{consumoAnnuoUMEER = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEnergiaElettricaRete().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMEER = null;}
		try{consumoAnnuoGN = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGasNaturale().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoGN = null;}
		try{consumoAnnuoUMGN = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGasNaturale().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMGN = null;}
		try{consumoAnnuoGPL = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGpl().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoGPL = null;}
		try{consumoAnnuoUMGPL = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGpl().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMGPL = null;}
		try{consumoAnnuoCarbone = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getCarbone().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoCarbone = null;}
		try{consumoAnnuoUMCarbone = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getCarbone().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMCarbone = null;}
		
		//try{consumoAnnuoGasolio = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGasolioOlioCombustibile().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoGasolio = null;}
		//try{consumoAnnuoUMGasolio = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGasolioOlioCombustibile().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMGasolio = null;}

		try{consumoAnnuoGasol = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGasolio().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoGasol = null;}
		try{consumoAnnuoUMGasol = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getGasolio().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMGasol = null;}
		
		try{consumoAnnuoOlio = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getOlioCombustibile().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoOlio = null;}
		try{consumoAnnuoUMOlio = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getOlioCombustibile().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMOlio = null;}
		
		try{consumoAnnuoBMS = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getBiomasseSolide().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoBMS = null;}
		try{consumoAnnuoUMBMS = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getBiomasseSolide().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMBMS = null;}
		try{consumoAnnuoBML = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getBiomasseLiquide().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoBML = null;}
		try{consumoAnnuoUMBML = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getBiomasseLiquide().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMBML = null;}
		try{consumoAnnuoBMG = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getBiomasseGassose().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoBMG = null;}
		try{consumoAnnuoUMBMG = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getBiomasseGassose().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMBMG = null;}
		try{consumoAnnuoSF = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getSolareFotovoltaico().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoSF = null;}
		try{consumoAnnuoUMSF = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getSolareFotovoltaico().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMSF = null;}
		try{consumoAnnuoST = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getSolareTermico().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoST = null;}
		try{consumoAnnuoUMST = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getSolareTermico().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMST = null;}
		try{consumoAnnuoEolico = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEolico().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoEolico = null;}
		try{consumoAnnuoUMEolico = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEolico().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMEolico = null;}
		try{consumoAnnuoTR = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getTeleriscaldamento().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoTR = null;}
		try{consumoAnnuoUMTR = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getTeleriscaldamento().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMTR = null;}
		try{consumoAnnuoTF = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getTeleraffrescamento().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoTF = null;}
		try{consumoAnnuoUMTF = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getTeleraffrescamento().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMTF = null;}
		try{consumoAnnuoAltro = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getAltro().getConsumoAnnuo();}catch (Exception e) {consumoAnnuoAltro = null;}
		try{consumoAnnuoUMAltro = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getAltro().getConsumoAnnuoUM();}catch (Exception e) {consumoAnnuoUMAltro = null;}
		try{descrizioneAltro = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getAltro().getDescrizioneFonteEnergetica();}catch (Exception e) {descrizioneAltro = null;}
		
		if (consumoAnnuoGasol != null || consumoAnnuoOlio != null)
		{
			// Uno dei due è valorizzato

			if (consumoAnnuoGasol != null && consumoAnnuoOlio != null && Converter.convertToInteger(consumoAnnuoUMGasol).intValue() != Converter.convertToInteger(consumoAnnuoUMOlio).intValue())
			{
				Exception e = new Exception();
				TrackingDbBEException bee = new TrackingDbBEException("L'unita' di misura di Gasolio e Olio combustibile deve essere la medesima", e);
				throw bee;
			}
		}
		
		log.debug("@@@@ STAMPO consumoAnnuoGasol: "+consumoAnnuoGasol);
		log.debug("@@@@ STAMPO consumoAnnuoOlio: "+consumoAnnuoOlio);
		
		List <SiceeTQtaConsumi2015> quantitaConsumi = new ArrayList<SiceeTQtaConsumi2015>();
		SiceeTQtaConsumi2015 siceeTQtaConsumi2015 = null;
		SiceeTDatiGeneraliPk pkAttestato = datiGenericiDto.getDatiGenerali().createPk();
		Integer idCombustibile = null;
		for (SiceeDCombustibile consumoComb : elencoConsumiCombustibile) {
			
			idCombustibile = consumoComb.getIdCombustibile().intValue();
			
			siceeTQtaConsumi2015 = null;
				
				switch (idCombustibile) {
				case Constants.ID_COMBUSTIBILE_ENERGIAELETTRICA:
					if (consumoAnnuoEER != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoEER, consumoAnnuoUMEER);
//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoEER);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMEER));
					}
					break;
				case Constants.ID_COMBUSTIBILE_GASNATURALE:
					if (consumoAnnuoGN != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoGN, consumoAnnuoUMGN);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoGN);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMGN));
					}
					break;
				case Constants.ID_COMBUSTIBILE_GPL:
					if (consumoAnnuoGPL != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoGPL, consumoAnnuoUMGPL);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoGPL);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMGPL));
					}
					break;
				case Constants.ID_COMBUSTIBILE_CARBONE:
					if (consumoAnnuoCarbone != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoCarbone, consumoAnnuoUMCarbone);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoCarbone);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMCarbone));
					}
					break;
//				case Constants.ID_COMBUSTIBILE_GASOLIO:
//					if (consumoAnnuoGasolio != null) {
//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoGasolio);
//						rcc.setUi(Converter.convertToBigInteger(consumoAnnuoUMGasolio));
//					}
					//				break;
				case Constants.ID_COMBUSTIBILE_GASOL:
					if (consumoAnnuoGasol != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoGasol, consumoAnnuoUMGasol);

					}
					break;
				case Constants.ID_COMBUSTIBILE_OLIO_COMBUSTIBILE:
					if (consumoAnnuoOlio != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoOlio, consumoAnnuoUMOlio);

					}
					break;

				case Constants.ID_COMBUSTIBILE_BIOMASSESOLIDE:
					if (consumoAnnuoBMS != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoBMS, consumoAnnuoUMBMS);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoBMS);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMBMS));
					}
					break;
				case Constants.ID_COMBUSTIBILE_BIOMASSELIQUIDE:
					if (consumoAnnuoBML != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoBML, consumoAnnuoUMBML);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoBML);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMBML));
					}
					break;
				case Constants.ID_COMBUSTIBILE_BIOMASSEGASSOSE:
					if (consumoAnnuoBMG != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoBMG, consumoAnnuoUMBMG);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoBMG);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMBMG));
					}
					break;
				case Constants.ID_COMBUSTIBILE_SOLAREFOTOVOLTAICO:
					if (consumoAnnuoSF != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoSF, consumoAnnuoUMSF);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoSF);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMSF));
					}
					break;
				case Constants.ID_COMBUSTIBILE_SOLARETERMICO:
					if (consumoAnnuoST != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoST, consumoAnnuoUMST);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoST);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMST));
					}
					break;
				case Constants.ID_COMBUSTIBILE_EOLICO:
					if (consumoAnnuoEolico != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoEolico, consumoAnnuoUMEolico);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoEolico);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMEolico));
					}
					break;
				case Constants.ID_COMBUSTIBILE_TELERISCALDAMENTO:
					if (consumoAnnuoTR != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoTR, consumoAnnuoUMTR);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoTR);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMTR));
					}
					break;
				case Constants.ID_COMBUSTIBILE_TELERAFFRESCAMENTO:
					if (consumoAnnuoTF != null) {
						siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, idCombustibile, consumoAnnuoTF, consumoAnnuoUMTF);

//						rcc.setFlagPresente("S");
//						rcc.setQuantita(consumoAnnuoTF);
//						rcc.setUi(Converter.convertToString(consumoAnnuoUMTF));
					}
					break;
				}
				
				if (siceeTQtaConsumi2015 != null)
				{
					quantitaConsumi.add(siceeTQtaConsumi2015);
				}
				
				
				
			
		}
		
		
		if (consumoAnnuoAltro != null) {
		
			siceeTQtaConsumi2015 = mappaConsumi(pkAttestato, Constants.ID_COMBUSTIBILE_ALTRO, consumoAnnuoAltro, consumoAnnuoUMAltro);
			siceeTQtaConsumi2015.setAltroDescrComb(descrizioneAltro);
			
			quantitaConsumi.add(siceeTQtaConsumi2015);
		}

		datiGenericiDto.setQuantitaConsumi2015(quantitaConsumi);
		
		BigDecimal emissioniCO2 = null;
		try{emissioniCO2 = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEmissioniCO2();}catch (Exception e) {emissioniCO2 = null;}
		if ((emissioniCO2 != null) && (emissioniCO2.doubleValue() >= 0)) {
			//*modDoc.getMOD().getAttestato().getPrestEnergImpianti().setEmissioniCO2(emissioniCO2);
			datiGenericiDto.getDatiEner2015().setEmissioniCo2(Converter.convertToDouble(emissioniCO2));
		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore emissioni di CO2 deve essere maggiore o uguale a zero", e);
			throw bee;
		}
	}
	
	private static SiceeTQtaConsumi2015 mappaConsumi(SiceeTDatiGeneraliPk pkAttestato, Integer idCombustibile, BigDecimal consumoAnnuoQuant, Short consumoAnnuoUnita)
	{
		SiceeTQtaConsumi2015 siceeTQtaConsumi2015 = new SiceeTQtaConsumi2015();
		siceeTQtaConsumi2015.setIdCertificatore(pkAttestato.getIdCertificatore());
		siceeTQtaConsumi2015.setProgrCertificato(pkAttestato.getProgrCertificato());
		siceeTQtaConsumi2015.setAnno(pkAttestato.getAnno());
		
		try{siceeTQtaConsumi2015.setFkCombustibile(idCombustibile);}catch (Exception e) {siceeTQtaConsumi2015.setFkCombustibile(null);}
		try{siceeTQtaConsumi2015.setQuantita(Converter.convertToDouble(consumoAnnuoQuant));}catch (Exception e) {siceeTQtaConsumi2015.setQuantita(null);}
		try{siceeTQtaConsumi2015.setFkUnitaMisura(Converter.convertToInteger(consumoAnnuoUnita));}catch (Exception e) {siceeTQtaConsumi2015.setFkUnitaMisura(null);}
		
		return siceeTQtaConsumi2015;
	}
	
	public static void mappaImportRaccomandazioniReadOnly(
			DocumentoDocument docXmlApeCompleto2015, DatiGenericiDto datiGenericiDto, List<SiceeDClasseEnergetica> classiEnergetiche, List<SiceeDRiqEner2015> listRiqEner)
			throws TrackingDbBEException, BEException {

		log.debug("\n\n\n >>>>>>> mappaImportRaccomandazioniReadOnly");
		// raccomandazioni (interventiRaccomandati, classe energetica raggiungibile)
		Short codice = null;
		String tipoIntervento = null;
		boolean ristrutturazioneImportante;
		BigDecimal tempoRitorno = null;
		String classe = null;
		BigDecimal epglnren = null;
		List<TypeInterventoRaccomandato> interventiRaccomandatiList = docXmlApeCompleto2015.getDocumento().getApe2015().getRaccomandazioni().getInterventoRaccomandatoList();
		List<it.csi.sicee.siceeweb.xml.attestato2015.data.RowRenDocument.RowRen> rrList = new ArrayList<it.csi.sicee.siceeweb.xml.attestato2015.data.RowRenDocument.RowRen>();

		SiceeTRaccomand2015 siceeTRaccomand2015 = null;
		SiceeTDatiGeneraliPk pkAttestato = datiGenericiDto.getDatiGenerali().createPk();

		List <SiceeTRaccomand2015> raccomandazioni = new ArrayList<SiceeTRaccomand2015>();

		for (TypeInterventoRaccomandato ir : interventiRaccomandatiList) {
			it.csi.sicee.siceeweb.xml.attestato2015.data.RowRenDocument.RowRen rr = it.csi.sicee.siceeweb.xml.attestato2015.data.RowRenDocument.RowRen.Factory.newInstance();
			siceeTRaccomand2015 = new SiceeTRaccomand2015();

			siceeTRaccomand2015.setIdCertificatore(pkAttestato.getIdCertificatore());
			siceeTRaccomand2015.setProgrCertificato(pkAttestato.getProgrCertificato());
			siceeTRaccomand2015.setAnno(pkAttestato.getAnno());

			try{codice = ir.getCodice();}catch (Exception e) {codice = null;}
			
			if ((codice != null) && (!Converter.convertToString(codice).equalsIgnoreCase("-1"))) {
				
				
				try{tipoIntervento = ir.getTipoInterventoRaccomandato();}catch (Exception e) {tipoIntervento = null;}
				try{ristrutturazioneImportante = ir.getRistrutturazioneImportante();}catch (Exception e) {ristrutturazioneImportante = false;}

				try{siceeTRaccomand2015.setCodiceRen(decodRiqEnergCod(codice, listRiqEner));}catch (Exception e) {siceeTRaccomand2015.setCodiceRen(null);}
				try{siceeTRaccomand2015.setTipoIntervento(tipoIntervento);}catch (Exception e) {siceeTRaccomand2015.setTipoIntervento(null);}
				try{siceeTRaccomand2015.setFlgRistrutturazione(Converter.convertToString(ristrutturazioneImportante));}catch (Exception e) {siceeTRaccomand2015.setFlgRistrutturazione(null);}

				
				try{tempoRitorno = ir.getTempoRitornoInvestimento();}catch (Exception e) {tempoRitorno = null;}
				if ((tempoRitorno != null) && (tempoRitorno.doubleValue() > 0)) {
					
					if (tempoRitorno.doubleValue() < 100) {
						rr.setAnniRitornoInv(tempoRitorno);
						try{siceeTRaccomand2015.setNrAnniRitInvest(Converter.convertToDouble(rr.getAnniRitornoInv()));}catch (Exception e) {siceeTRaccomand2015.setNrAnniRitInvest(null);}
					}
					else {
						Exception e = new Exception();
						TrackingDbBEException bee = new TrackingDbBEException("Il valore tempoRitornoInvestimento deve essere minore di cento", e);
						throw bee;
					}
					
				} else {
					Exception e = new Exception();
					TrackingDbBEException bee = new TrackingDbBEException("Il valore tempoRitornoInvestimento deve essere maggiore a zero", e);
					throw bee;
				}

				
				
				try{classe = ir.getClassificazioneRaggiungibile().getClasseEnergetica().toString();}catch (Exception e) {classe = null;}
				try{epglnren = ir.getClassificazioneRaggiungibile().getEpglnren();}catch (Exception e) {epglnren = null;}
				
				try{siceeTRaccomand2015.setFkClasseEnergetica(decodClasseEnergeticaDescr(classe, classiEnergetiche));}catch (Exception e) {siceeTRaccomand2015.setFkClasseEnergetica(null);}
				try{siceeTRaccomand2015.setEpglNrenSingoloInt(Converter.convertToDouble(epglnren));}catch (Exception e) {siceeTRaccomand2015.setEpglNrenSingoloInt(null);}
				
				raccomandazioni.add(siceeTRaccomand2015);
				
//				rr.setCodRen(decodREN(codice));
//				rr.setTipoIntervento(tipoIntervento);
//				rr.setRistrutturazioneImportante(decodComboBoolean(ristrutturazioneImportante));
//				//rr.setClasse(Converter.convertToBigInteger(decodClasseEnergetica(classe, datiGenericiDto.getClassiEnergetiche())));
//				rr.setClasse(classe);
//				rr.setEPglnren(epglnren);
//				rrList.add(rr);
//				
//				
//					if ((siceeTRaccomand2015.getCodiceRen() != null) && (!siceeTRaccomand2015.getCodiceRen().equalsIgnoreCase("-1"))) {
//						log.debug("\n>>>>>>> INSERT del record di SICEE_T_RACCOMAND_2015");
//						this.getSiceeTRaccomand2015Dao().insert(siceeTRaccomand2015);
//					}
				
				
			}

		}
		
		datiGenericiDto.setRaccomandazioni2015(raccomandazioni);

		
//		it.csi.sicee.siceeweb.xml.attestato2015.data.RowRenDocument.RowRen[] rrArray = new it.csi.sicee.siceeweb.xml.attestato2015.data.RowRenDocument.RowRen[rrList.size()];
//		rrArray = rrList.toArray(rrArray);
//		modDoc.getMOD().getAttestato().getRaccomandazioni().getSezioneRen().setRowRenArray(rrArray);
//		
		
		String classeRaggiungibile = null;
		BigDecimal epglnrenRaggiungibile = null;
		try{classeRaggiungibile = docXmlApeCompleto2015.getDocumento().getApe2015().getRaccomandazioni().getClassificazione().getClasseEnergetica().toString();}catch (Exception e) {classeRaggiungibile = null;}
//		modDoc.getMOD().getAttestato().getRaccomandazioni().setClasse(classeRaggiungibile);
		try{datiGenericiDto.getDatiEner2015().setFkCeRaccTotale(decodClasseEnergeticaDescr(classeRaggiungibile, classiEnergetiche));}catch (Exception e) {datiGenericiDto.getDatiEner2015().setFkCeRaccTotale(null);}

		try{epglnrenRaggiungibile = docXmlApeCompleto2015.getDocumento().getApe2015().getRaccomandazioni().getClassificazione().getEpglnren();}catch (Exception e) {epglnrenRaggiungibile = null;}
//		modDoc.getMOD().getAttestato().getRaccomandazioni().setEPglnrenTotale(epglnrenRaggiungibile);
		try{datiGenericiDto.getDatiEner2015().setEpglNrenRaccTotale(Converter.convertToDouble(epglnrenRaggiungibile));}catch (Exception e) {datiGenericiDto.getDatiEner2015().setEpglNrenRaccTotale(null);}

		
		// dati energetici
		BigDecimal energiaEsportata = null;
		Short vettore = null;
		try{energiaEsportata = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiEnergetici().getEnergiaEsportata();}catch (Exception e) {energiaEsportata = null;}
		try{vettore = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiEnergetici().getVettoreEnergetico();}catch (Exception e) {vettore = null;}
		
		try{datiGenericiDto.getDatiEner2015().setEnergiaEsportata(Converter.convertToDouble(energiaEsportata));}catch (Exception e) {datiGenericiDto.getDatiEner2015().setEnergiaEsportata(null);}
		// Il vettore è stato già salvato nell'oggetto datiGenericiDto
		
		
		
//		it.csi.sicee.siceeweb.xml.attestato2015.data.RowVettoreDocument.RowVettore[] rv = new it.csi.sicee.siceeweb.xml.attestato2015.data.RowVettoreDocument.RowVettore[1];
//		rv[0] = it.csi.sicee.siceeweb.xml.attestato2015.data.RowVettoreDocument.RowVettore.Factory.newInstance();
//		rv[0].setCodVettore(Converter.convertToBigInteger(cd.getIdCombustibile()));
//		rv[0].setDescrVettore(cd.getDescr());
		//modDoc.getMOD().getAttestato().getAltriDatiEnergetici().setEnergiaEsportata(energiaEsportata);
		//modDoc.getMOD().getAttestato().getAltriDatiEnergetici().getVettori().setRowVettoreArray(rv);

		// dati fabbricato
		BigDecimal superficieDisperdente = null;
		BigDecimal ephnd = null;
		BigDecimal rapportoAsolAsupUtile = null;
		BigDecimal yie = null;

		try{superficieDisperdente = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiFabbricato().getSuperficieDisperdente();}catch (Exception e) {superficieDisperdente = null;}
		if ((superficieDisperdente != null) && (superficieDisperdente.doubleValue() >= 0)) {
			//modDoc.getMOD().getAttestato().getAltriDatiFabbricato().setSupDisperdente(superficieDisperdente);
			try{datiGenericiDto.getDatiGenerali().setSupDisperdente(Converter.convertToDouble(superficieDisperdente));}catch (Exception e) {datiGenericiDto.getDatiGenerali().setSupDisperdente(null);}

		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore superficie disperdente deve essere maggiore o uguale a zero", e);
			throw bee;
		}
		
		
		// BEPPE - DA SPOSTARE
		// CALCOLO RAPPORTO SV - inizio

		// Il VolLordoRisc deve essere riportato anche nel campo MOD.sbfAltriDatiFabbricato.sbfDati.volumeRisc
		// Non è ancora presente
		
		BigDecimal volLordoRisc = null;
		try{volLordoRisc = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiGenerali().getDatiIdentificativi().getVolumeLordoRiscaldato();}catch (Exception e) {volLordoRisc = null;}
		
		if ((volLordoRisc != null) && (volLordoRisc.doubleValue() <= 0)) {
			
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore volume lordo riscaldato deve essere maggiore di zero", e);
			throw bee;
		}
		else if ((superficieDisperdente.doubleValue() > 0) && 
				volLordoRisc.doubleValue() > 0) {
			
			
			Double rapportoSV = GenericUtil.calcolaRapportoSV(superficieDisperdente.doubleValue(), volLordoRisc.doubleValue());
			datiGenericiDto.getDatiEner2015().setRapportoSv(rapportoSV);

		}
		
		// CALCOLO RAPPORTO SV - fine
		
		
		
		

		try{ephnd = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiFabbricato().getEphnd();}catch (Exception e) {ephnd = null;}
		if ((ephnd != null) && (ephnd.doubleValue() >= 0)) {
			//modDoc.getMOD().getAttestato().getAltriDatiFabbricato().setEPHnd(ephnd);
			try{datiGenericiDto.getDatiEner2015().setEph(Converter.convertToDouble(ephnd));}catch (Exception e) {datiGenericiDto.getDatiEner2015().setEph(null);}

		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore EPh,nd deve essere maggiore o uguale a zero", e);
			throw bee;
		}

		try{rapportoAsolAsupUtile = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiFabbricato().getRapportoAsolAsupUtile();}catch (Exception e) {rapportoAsolAsupUtile = null;}
		if ((rapportoAsolAsupUtile != null) && (rapportoAsolAsupUtile.doubleValue() >= 0)) {
			//modDoc.getMOD().getAttestato().getAltriDatiFabbricato().setRapportoAsolAsup(rapportoAsolAsupUtile);
			try{datiGenericiDto.getDatiEner2015().setAsolAsup(Converter.convertToDouble(rapportoAsolAsupUtile));}catch (Exception e) {datiGenericiDto.getDatiEner2015().setAsolAsup(null);}

		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il rapporto Asol,est /Asup utile deve essere maggiore o uguale a zero", e);
			throw bee;
		}

		try{yie = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiFabbricato().getYie();}catch (Exception e) {yie = null;}
		if ((yie != null) && (yie.doubleValue() >= 0)) {
			//modDoc.getMOD().getAttestato().getAltriDatiFabbricato().setYie(yie);
			try{datiGenericiDto.getDatiEner2015().setYie(Converter.convertToDouble(yie));}catch (Exception e) {datiGenericiDto.getDatiEner2015().setYie(null);}

		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore Yie deve essere maggiore o uguale a zero", e);
			throw bee;
		}
		
		
		
	}
		
	public static void mappaImportDatiImpiantiReadOnly(
			DocumentoDocument docXmlApeCompleto2015, DatiGenericiDto datiGenericiDto, List<SiceeDCombustibile> elencoCombustibiliDettImpianti, List<SiceeDTipoImpianto2015> elencoTipiImpianto)
			throws TrackingDbBEException, BEException {

		List <SiceeRCertifServener2015> certifServEnerList = new ArrayList<SiceeRCertifServener2015>();
		List <SiceeTDetImp2015> dettImpTotList = new ArrayList<SiceeTDetImp2015>();
		List <SiceeTDetImp2015> dettImpParzList = new ArrayList<SiceeTDetImp2015>();

		SiceeTDatiGeneraliPk pkDatiGenerali = datiGenericiDto.getDatiGenerali().createPk();
		
		SiceeRCertifServener2015 certifServEner = null;

		
		log.debug("\n\n\n >>>>>>> mappaImportDatiImpiantiReadOnly");
		
		List<TypeImpianto> impiantiList = null;
		it.csi.sicee.siceeweb.xml.attestato2015.data.RowImpiantoDocument.RowImpianto[] ri = null;
		BigDecimal efficienza = null;	
		BigDecimal epren = null;
		BigDecimal epnren = null;
		String impiantoSimulato = null;

		BigDecimal eprenTot = new BigDecimal(0);
		BigDecimal epnrenTot = new BigDecimal(0);
		
		log.debug("##### mappaImportDatiImpianti - INIZIO");
		
		// climatizzazione invernale
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneInvernale().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			
		
			try{efficienza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneInvernale().getEfficienza();}catch (Exception e) {efficienza = null;}
			try{epren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneInvernale().getPrestazione().getEpren();}catch (Exception e) {epren = null;}
			try{epnren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneInvernale().getPrestazione().getEpnren();}catch (Exception e) {epnren = null;}

			eprenTot = eprenTot.add(GenericUtil.getBigDecimalValid(epren));
			epnrenTot = epnrenTot.add(GenericUtil.getBigDecimalValid(epnren));

			log.debug("mappaImportDatiImpianti - getClimatizzazioneInvernale - epnren: "+epnren);
			log.debug("mappaImportDatiImpianti - getClimatizzazioneInvernale - epnrenTot: "+epnrenTot);
			
			impiantoSimulato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneInvernale().getImpiantoSimulato();
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_CLIMAINVER, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_CLIMAINVER);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);
			
		}
		
		// climatizzazione estiva
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneEstiva().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			try{efficienza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneEstiva().getEfficienza();}catch (Exception e) {efficienza = null;}
			try{epren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneEstiva().getPrestazione().getEpren();}catch (Exception e) {epren = null;}
			try{epnren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getClimatizzazioneEstiva().getPrestazione().getEpnren();}catch (Exception e) {epnren = null;}

			eprenTot = eprenTot.add(GenericUtil.getBigDecimalValid(epren));
			epnrenTot = epnrenTot.add(GenericUtil.getBigDecimalValid(epnren));

			log.debug("mappaImportDatiImpianti - getClimatizzazioneEstiva - epnren: "+epnren);
			log.debug("mappaImportDatiImpianti - getClimatizzazioneEstiva - epnrenTot: "+epnrenTot);

			impiantoSimulato = null;
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_CLIMAEST, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			
			//*ri = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_CLIMAEST);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);
			
		}
		// produzione acqua calda sanitaria
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getProduzioneACS().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			try{efficienza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getProduzioneACS().getEfficienza();}catch (Exception e) {efficienza = null;}
			try{epren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getProduzioneACS().getPrestazione().getEpren();}catch (Exception e) {epren = null;}
			try{epnren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getProduzioneACS().getPrestazione().getEpnren();}catch (Exception e) {epnren = null;}

			eprenTot = eprenTot.add(GenericUtil.getBigDecimalValid(epren));
			epnrenTot = epnrenTot.add(GenericUtil.getBigDecimalValid(epnren));

			log.debug("mappaImportDatiImpianti - getProduzioneACS - epnren: "+epnren);
			log.debug("mappaImportDatiImpianti - getProduzioneACS - epnrenTot: "+epnrenTot);

			impiantoSimulato = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getProduzioneACS().getImpiantoSimulato();
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_ACQUACALDA, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			
			//*ri = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_ACQUACALDA);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);
			
		}
		// impianti combinati
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getImpiantiCombinati().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			try{efficienza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getImpiantiCombinati().getEfficienza();}catch (Exception e) {efficienza = null;}
			try{epren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getImpiantiCombinati().getPrestazione().getEpren();}catch (Exception e) {epren = null;}
			try{epnren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getImpiantiCombinati().getPrestazione().getEpnren();}catch (Exception e) {epnren = null;}

			eprenTot = eprenTot.add(GenericUtil.getBigDecimalValid(epren));
			epnrenTot = epnrenTot.add(GenericUtil.getBigDecimalValid(epnren));

			log.debug("mappaImportDatiImpianti - getImpiantiCombinati - epnren: "+epnren);
			log.debug("mappaImportDatiImpianti - getImpiantiCombinati - epnrenTot: "+epnrenTot);

			impiantoSimulato = null;
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_IMPIANTICOMBINATI, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			//*ri = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_IMPIANTICOMBINATI);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);
			
			
		}
		// produzione energia da fonti rinnovabili
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getProduzioneFontiRinnovabili().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			efficienza = null;
			epren = null;
			epnren = null;
			impiantoSimulato = null;
			
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_PRODFONTIRINN, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			
			//*ri = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_PRODFONTIRINN);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);

		}

		// ventilazione meccanica
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getVentilazioneMeccanica().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			try{efficienza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getVentilazioneMeccanica().getEfficienza();}catch (Exception e) {efficienza = null;}
			try{epren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getVentilazioneMeccanica().getPrestazione().getEpren();}catch (Exception e) {epren = null;}
			try{epnren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getVentilazioneMeccanica().getPrestazione().getEpnren();}catch (Exception e) {epnren = null;}

			eprenTot = eprenTot.add(GenericUtil.getBigDecimalValid(epren));
			epnrenTot = epnrenTot.add(GenericUtil.getBigDecimalValid(epnren));

			log.debug("mappaImportDatiImpianti - getVentilazioneMeccanica - epnren: "+epnren);
			log.debug("mappaImportDatiImpianti - getVentilazioneMeccanica - epnrenTot: "+epnrenTot);

			impiantoSimulato = null;
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_VENTMECC, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			
			//*ri = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_VENTMECC);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);

			
		}

		
		
		// sezione illuminazione
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getIlluminazione().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			try{efficienza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getIlluminazione().getEfficienza();}catch (Exception e) {efficienza = null;}
			try{epren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getIlluminazione().getPrestazione().getEpren();}catch (Exception e) {epren = null;}
			try{epnren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getIlluminazione().getPrestazione().getEpnren();}catch (Exception e) {epnren = null;}

			eprenTot = eprenTot.add(GenericUtil.getBigDecimalValid(epren));
			epnrenTot = epnrenTot.add(GenericUtil.getBigDecimalValid(epnren));

			log.debug("mappaImportDatiImpianti - getIlluminazione - epnren: "+epnren);
			log.debug("mappaImportDatiImpianti - getIlluminazione - epnrenTot: "+epnrenTot);

			impiantoSimulato = null;
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_ILLUMINAZIONE, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			
			//*ri = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, elencoCombustibiliDettImpianti,elencoTipiImpianto);
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_ILLUMINAZIONE);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);

			
		}

		// sezione trasporto
		try{impiantiList = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getTrasportoPersoneCose().getImpiantoList();}catch (Exception e) {impiantiList = null;}
		if (impiantiList != null) {
			try{efficienza = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getTrasportoPersoneCose().getEfficienza();}catch (Exception e) {efficienza = null;}
			try{epren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getTrasportoPersoneCose().getPrestazione().getEpren();}catch (Exception e) {epren = null;}
			try{epnren = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiImpianti().getTrasportoPersoneCose().getPrestazione().getEpnren();}catch (Exception e) {epnren = null;}

			eprenTot = eprenTot.add(GenericUtil.getBigDecimalValid(epren));
			epnrenTot = epnrenTot.add(GenericUtil.getBigDecimalValid(epnren));

			log.debug("mappaImportDatiImpianti - getTrasportoPersoneCose - epnren: "+epnren);
			log.debug("mappaImportDatiImpianti - getTrasportoPersoneCose - epnrenTot: "+epnrenTot);

			impiantoSimulato = null;
			dettImpParzList = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, pkDatiGenerali, Constants.SEZIONE_TRASPORTO, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			dettImpTotList.addAll(dettImpParzList);
			
			//*ri = iteraDatiImpiantiReadOnly(impiantiList, impiantoSimulato, elencoCombustibiliDettImpianti, elencoTipiImpianto);
			certifServEner = new SiceeRCertifServener2015();

			certifServEner.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
			certifServEner.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
			certifServEner.setAnno(pkDatiGenerali.getAnno());
			
			certifServEner.setIdServEner(Constants.SEZIONE_TRASPORTO);
			certifServEner.setEfficienza(Converter.convertToDouble(efficienza));
			certifServEner.setEpren(Converter.convertToDouble(epren));
			certifServEner.setEpnren(Converter.convertToDouble(epnren));
			
			certifServEnerList.add(certifServEner);

			
		}

		datiGenericiDto.setCertifServener2015(certifServEnerList);
		datiGenericiDto.setDetImp2015(dettImpTotList);

		
		// BEPPE - CALCOLO EPglren totale - inizio

		datiGenericiDto.getDatiEner2015().setEpglRenGlobale(Converter.convertToDouble(eprenTot));
		datiGenericiDto.getDatiEner2015().setEpglNrenGlobale(Converter.convertToDouble(epnrenTot));
		
		// Questo controllo andrebbe nella sezione ristrutturazioni, ma per usare l'oggetto non MODOL, lo faccio qui 
		BigDecimal epglnrenRaggiungibile = null;
		try{epglnrenRaggiungibile = docXmlApeCompleto2015.getDocumento().getApe2015().getRaccomandazioni().getClassificazione().getEpglnren();}catch (Exception e) {epglnrenRaggiungibile = null;}
		
		if (log.isDebugEnabled())
		{
			log.debug("mappaImportDatiImpianti - getTrasportoPersoneCose - epglnrenRaggiungibile: "+epglnrenRaggiungibile);
			log.debug("mappaImportDatiImpianti - getTrasportoPersoneCose - epnrenTot: "+epnrenTot);
	
			log.debug("mappaImportDatiImpianti - getTrasportoPersoneCose - epglnrenRaggiungibile.doubleValue(): "+epglnrenRaggiungibile.doubleValue());
			log.debug("mappaImportDatiImpianti - getTrasportoPersoneCose - epnrenTot.doubleValue(): "+epnrenTot.doubleValue());
	
			log.debug("##### mappaImportDatiImpianti - INIZIO");
		}
		
		if (epglnrenRaggiungibile.doubleValue() > epnrenTot.doubleValue())
		{
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("EPgl,nren della classe energetica raggiungibile se si realizzano tutti gli interventi raccomandati deve essere minore o uguale a quello globale", e);
			throw bee;
		}
		
		
		if (log.isDebugEnabled())
		{
			log.debug("######################################à");
			log.debug("eprenTot: "+eprenTot);
			log.debug("presImpiantiEpglren: "+docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEpglren());
			log.debug("--------------------------");
			log.debug("epnrenTot: "+epnrenTot);
			log.debug("presImpiantiEpglnren: "+docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEpglnren());
			log.debug("--------------------------");
			log.debug("epnrenTot: "+epnrenTot);
			log.debug("presGlobaleEpglnren: "+docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getPrestazioneEnergeticaGlobale().getClassificazione().getEpglnren());
			log.debug("######################################à");
		}
		
		BigDecimal presImpiantiEpglren = null;
		try{presImpiantiEpglren = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEpglren();}catch (Exception e) {presImpiantiEpglren = null;}
		if (presImpiantiEpglren != null && presImpiantiEpglren.doubleValue() != eprenTot.doubleValue())
		{
			
			log.debug("eprenTot: "+eprenTot);
			log.debug("presImpiantiEpglren: "+presImpiantiEpglren);
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("EPgl,ren dato dalla somma dei 'dati di dettaglio degli impianti' e' diverso dal valore indicato in 'prestazione energetica degli impianti e consumi stimati'", e);
			throw bee;
		}

		BigDecimal presImpiantiEpglnren = null;
		try{presImpiantiEpglnren = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneImpianti().getEpglnren();}catch (Exception e) {presImpiantiEpglnren = null;}
		if (presImpiantiEpglnren != null && presImpiantiEpglnren.doubleValue() != epnrenTot.doubleValue())
		{
			log.debug("epnrenTot: "+epnrenTot);
			log.debug("presImpiantiEpglnren: "+presImpiantiEpglnren);
			
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("EPgl,nren dato dalla somma dei 'dati di dettaglio degli impianti' e' diverso dal valore indicato in 'prestazione energetica degli impianti e consumi stimati'", e);
			throw bee;
		}

		BigDecimal presGlobaleEpglnren = null;
		try{presGlobaleEpglnren = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getPrestazioneEnergeticaGlobale().getClassificazione().getEpglnren();}catch (Exception e) {presGlobaleEpglnren = null;}
		if (presGlobaleEpglnren != null && presGlobaleEpglnren.doubleValue() != epnrenTot.doubleValue())
		{
			log.debug("epnrenTot: "+epnrenTot);
			log.debug("presGlobaleEpglnren: "+presGlobaleEpglnren);
			
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("EPgl,nren dato dalla somma dei 'dati di dettaglio degli impianti' e' diverso dal valore indicato in 'prestazione energetica globale del fabbricato'", e);
			throw bee;
		}
		// BEPPE - CALCOLO EPglren totale - fine

		// BEPPE - CALCOLO CLASSE - inizio
		//BigDecimal epglnren = null;
		BigDecimal ePglnrenRifStandard = null;

		try{ePglnrenRifStandard = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getEPglnrenRifStandard();}catch (Exception e) {ePglnrenRifStandard = null;}

		Integer fkClasseEnerg = null;

		if (epnrenTot != null && ePglnrenRifStandard != null)
		{

			double vEPglnren = epnrenTot.doubleValue();
			double vEPglnrenStnd = ePglnrenRifStandard.doubleValue();
			//var vEPglnren  -- campo EpglnrenTotale
			//var vEPglnrenStnd  -- campo EpglnrenStandard
			//var fieldIdClasse
			//var fieldClasse
			if (  vEPglnren <= (0.4 * vEPglnrenStnd )  ){
				//fieldIdClasse.rawValue= 100; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_A4; 
			}
			else if ( (vEPglnren > (0.4 * vEPglnrenStnd )) && (vEPglnren <= (0.6 * vEPglnrenStnd ) ) ){
				//fieldClasse.rawValue= 101; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_A3; 
			}
			else if ( (vEPglnren > (0.6 * vEPglnrenStnd )) && (vEPglnren <= (0.8 * vEPglnrenStnd ) ) ){
				//fieldIdClasse.rawValue= 102; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_A2; 
			} 
			else if ( (vEPglnren > (0.8 * vEPglnrenStnd )) && (vEPglnren <= (1 * vEPglnrenStnd ) ) ){
				//fieldIdClasse.rawValue= 103; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_A1; 
			} 
			else if ( (vEPglnren > (1 * vEPglnrenStnd )) && (vEPglnren <= (1.2 * vEPglnrenStnd ) ) ){
				//fieldIdClasse.rawValue= 104; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_B; 
			} 
			else if ( (vEPglnren > (1.2 * vEPglnrenStnd )) && (vEPglnren <= (1.5 * vEPglnrenStnd ) ) ){
				//fieldClasse.rawValue= 105; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_C; 
			} 
			else if ( (vEPglnren > (1.5 * vEPglnrenStnd )) && (vEPglnren <= (2 * vEPglnrenStnd ) ) ){
				//fieldIdClasse.rawValue= 106; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_D; 
			}
			else if ( (vEPglnren > (2 * vEPglnrenStnd )) && (vEPglnren <= (2.6 * vEPglnrenStnd ) ) ){
				//fieldIdClasse.rawValue= 107; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_E; 
			}
			else if ( (vEPglnren > (2.6 * vEPglnrenStnd )) && (vEPglnren <= (3.5 * vEPglnrenStnd ) ) ){
				//fieldIdClasse.rawValue= 108; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_F; 
			}
			else if ( vEPglnren > (3.5 * vEPglnrenStnd )  ){
				//fieldIdClasse.rawValue= 109; 
				fkClasseEnerg = Constants.ID_CLASSE_ENERGETICA_G; 
			}
			
		}else{
			// Non si riesce a calcolare la classe energetica
		}

		if (fkClasseEnerg != null)
		{
			//modDoc.getMOD().getAttestato().getPrestEnergFabb().setClasseEnergetica(classeEnerg);
			datiGenericiDto.getDatiEner2015().setFkClasseEnergetica(fkClasseEnerg);

			//try {
			
				log.debug("########## IMMAGINE - inizio ##########");

				
			
			log.debug("########## IMMAGINE - fine ##########");

			//InputStream is = getFilePath("classe_energ_a_piu.png", servletContext);


		}

//		datiGenericiDto.getDatiEner2015().setFlgSmileInverno(calcolaSmileInverno(datiGenericiDto.getDatiEner2015()));
//		datiGenericiDto.getDatiEner2015().setFlgSmileEstate(calcolaSmileEstate(datiGenericiDto.getDatiEner2015()));
		
		// Devo settare la classe

		// BEPPE - CALCOLO CLASSE - fine

		//return modDoc;
	}
	
	private static SiceeRCertifServener2015 recuperaCertifServener2015ByServEner(List<SiceeRCertifServener2015> certifServener2015Tot, int idServEner)
	{
		SiceeRCertifServener2015 certifServener2015 = null;
		
		for (SiceeRCertifServener2015 siceeRCertifServener2015 : certifServener2015Tot) 
		{
			if (siceeRCertifServener2015.getIdServEner() == idServEner)
			{
				// Devo settare l'elembnto trovato
				certifServener2015 = siceeRCertifServener2015;;
			}
				
		}
		
		return certifServener2015;
	}
	
	private static List<SiceeTDetImp2015> recuperaDettImp2015ByServEner(List<SiceeTDetImp2015> dettImp2015Tot, int idServEner)
	{
		List<SiceeTDetImp2015> detImp2015Parz = new ArrayList<SiceeTDetImp2015>();
		
		for (SiceeTDetImp2015 siceeTDetImp2015 : dettImp2015Tot) 
		{
			if (siceeTDetImp2015.getFkServEner() == idServEner)
			{
				// Devo aggiungere l'elemento
				detImp2015Parz.add(siceeTDetImp2015);
			}
		}
		
		return detImp2015Parz;
	}
	
	public static void mappaImportDatiFinaliReadOnly(
			DocumentoDocument docXmlApeCompleto2015, DatiGenericiDto datiGenericiDto)
			throws TrackingDbBEException, BEException {

		log.debug("\n\n\n >>>>>>> mappaImportDatiFinaliReadOnly");
		
		String informazioniMiglioramento = null;
		try{informazioniMiglioramento = docXmlApeCompleto2015.getDocumento().getApe2015().getInformazioniMiglioramento();}catch (Exception e) {informazioniMiglioramento = null;}
		datiGenericiDto.getAltreInfo().setInfoMiglPrestEnerg(informazioniMiglioramento);

		// sezione soggetto certificatore
		Short tipoSoggettoCertificatore	= null;
		// La dichiarazione non viene più presa quella del modello nazionale, ma viene compilato sul DB
		//Short dichiarazioneIndipendenza = null;
		String informazioniAggiuntive = null;

		try{tipoSoggettoCertificatore = docXmlApeCompleto2015.getDocumento().getApe2015().getSoggettoCertificatore().getTipoSoggettoCertificatore();}catch (Exception e) {tipoSoggettoCertificatore = null;}

		try{informazioniAggiuntive = docXmlApeCompleto2015.getDocumento().getApe2015().getSoggettoCertificatore().getInformazioniAggiuntive();}catch (Exception e) {informazioniAggiuntive = null;}

		datiGenericiDto.getAltreInfo().setFkRuoloCert(Converter.convertToInteger(tipoSoggettoCertificatore));
		datiGenericiDto.getAltreInfo().setUltInfo(informazioniAggiuntive);
		
		
		// sopralluogoObbligatorio, softwareUtilizzato
		boolean sopralluogoObbligatorio;
		boolean requisitiRispondenzaRisultati;
		boolean calcoloSemplificato;
		try{sopralluogoObbligatorio = docXmlApeCompleto2015.getDocumento().getApe2015().getSopralluogoObbligatorio();}catch (Exception e) {sopralluogoObbligatorio = false;}
		try{requisitiRispondenzaRisultati = docXmlApeCompleto2015.getDocumento().getApe2015().getSoftwareUtilizzato().getRequisitiRispondenzaRisultati();}catch (Exception e) {requisitiRispondenzaRisultati = false;}
		try{calcoloSemplificato = docXmlApeCompleto2015.getDocumento().getApe2015().getSoftwareUtilizzato().getCalcoloSemplificato();}catch (Exception e) {calcoloSemplificato = false;}
		
		
		// BEPPE - da testare
		// Questi due campi devono essere SI altrimenti non può andare avanti
		if (!sopralluogoObbligatorio)
		{
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il sopralluogo/rilievo deve essere SI", e);
			throw bee;
		}
		
		if (!requisitiRispondenzaRisultati)
		{
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il software utilizzato risponde ai requisiti di rispondenza e garanzia deve essere SI", e);
			throw bee;
		}
		
		datiGenericiDto.getAltreInfo().setFlgSopralluogo(Converter.convertToString(sopralluogoObbligatorio));
		datiGenericiDto.getAltreInfo().setFlgSw1(Converter.convertToString(requisitiRispondenzaRisultati));
		datiGenericiDto.getAltreInfo().setFlgSw2(Converter.convertToString(calcoloSemplificato));
		

		// dati extra
		BigDecimal ephndLim;
		BigDecimal epglnrRif;
		
		try{ephndLim = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getEphndLim();}catch (Exception e) {ephndLim = null;}
		if ((ephndLim != null) && (ephndLim.doubleValue() >= 0)) {
			//*modDoc.getMOD().getAttestato().getAltriDatiFabbricato().setEPHndLimite(ephndLim);
			datiGenericiDto.getDatiEner2015().setEphLimite(Converter.convertToDouble(ephndLim));
		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore EPh,nd Limite deve essere maggiore o uguale a zero", e);
			throw bee;
		}

		try{epglnrRif = docXmlApeCompleto2015.getDocumento().getApe2015().getDatiExtra().getEPglnrenRifStandard();}catch (Exception e) {epglnrRif = null;}
		
		
		// DA COMMENTARE SE SI VUOLE BAYPASSARE IL CONTROLLO - BEPPE
		log.debug("ERRORE epglnrRif NULL");
		log.debug("epglnrRif: "+epglnrRif);
		log.debug("epglnrRif.doubleValue(): "+epglnrRif.doubleValue());
		log.debug("Converter.convertToDouble(epglnrRif): "+Converter.convertToDouble(epglnrRif));

		if ((epglnrRif != null) && (epglnrRif.doubleValue() > 0)) {
			datiGenericiDto.getDatiEner2015().setEpglNrenRif(Converter.convertToDouble(epglnrRif));

		} else {
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("Il valore EPgl,nren Limite (Standard) deve essere maggiore di zero", e);
			throw bee;
		}
		
		// dati extra
		Short smileInverno;
		Short smileEstate;
		
		Integer idSmileInverno = GenericUtil.calcolaSmileInverno(datiGenericiDto.getDatiEner2015().getEph(), datiGenericiDto.getDatiEner2015().getEphLimite());
		
		try{smileInverno = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getPrestazioneEnergeticaFabbricato().getInverno();} catch (Exception e) {smileInverno = null;}
		
		if (smileInverno == null || idSmileInverno == null || smileInverno.intValue() != idSmileInverno.intValue())
		{
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("La prestazione energetica invernale del fabbricato non e' coerente con i dati di dettaglio del fabbricato presenti su XML", e);
			throw bee;
		}
		else
		{
			datiGenericiDto.getDatiEner2015().setFlgSmileInverno(idSmileInverno);
		}
		
		Integer idSmileEstate = GenericUtil.calcolaSmileEstate(datiGenericiDto.getDatiEner2015().getAsolAsup(), datiGenericiDto.getDatiEner2015().getYie());

		try{smileEstate = docXmlApeCompleto2015.getDocumento().getApe2015().getPrestazioneGlobale().getPrestazioneEnergeticaFabbricato().getEstate();} catch (Exception e) {smileEstate = null;}

		if (smileEstate == null || idSmileEstate == null || smileEstate.intValue() != idSmileEstate.intValue())
		{
			Exception e = new Exception();
			TrackingDbBEException bee = new TrackingDbBEException("La prestazione energetica estiva del fabbricato non e' coerente con i dati di dettaglio del fabbricato presenti su XML", e);
			throw bee;
		}
		else
		{
			datiGenericiDto.getDatiEner2015().setFlgSmileEstate(idSmileEstate);
		}
		
				
	}

	public static List<SiceeTDetImp2015> iteraDatiImpiantiReadOnly(List<TypeImpianto> impiantiList, String impiantoSimulato, SiceeTDatiGeneraliPk pkDatiGenerali, int codServizioEnergetico,
			 List<SiceeDCombustibile> elencoCombustibiliDettImpianti, List<SiceeDTipoImpianto2015> elencoTipiImpianto) throws TrackingDbBEException, BEException {
		
		List<SiceeTDetImp2015> dettImpList = new ArrayList<SiceeTDetImp2015>();

		// Mi creo l'oggetto
		SiceeTDetImp2015 dettImp = null;
		int i = 0;
		
		//it.csi.sicee.siceeweb.xml.attestato2015.data.RowImpiantoDocument.RowImpianto[] ri = null;
		
		if ((impiantiList != null) && (impiantiList.size() > 0)) {
			log.debug("\n\n\n >>>>>>> impiantiList.size(): " + impiantiList.size());
			Short tipoImpianto = null;
			String descrizioneImpianto = null;
			Integer annoInstallazione = null;
			Integer codiceCatastoRegionaleImpiantiTermici = null;
			//String codiceCatastoRegionaleImpiantiTermici = null;
			Short vettoriEnergeticiUtilizzati = null;
			BigDecimal potenzaNominale = null;
			//ri = new it.csi.sicee.siceeweb.xml.attestato2015.data.RowImpiantoDocument.RowImpianto[impiantiList.size()];
			
			
			
			
			for (TypeImpianto impianto : impiantiList) {
				
				// Inizializzo l'oggetto
				dettImp = new SiceeTDetImp2015();
				
				//ri[i] = it.csi.sicee.siceeweb.xml.attestato2015.data.RowImpiantoDocument.RowImpianto.Factory.newInstance();
				try{tipoImpianto = impianto.getTipoImpianto();}catch (Exception e) {tipoImpianto = null;}
				try{descrizioneImpianto = impianto.getDescrizioneImpianto();}catch (Exception e) {descrizioneImpianto = null;}
				try{annoInstallazione = impianto.getAnnoInstallazione();}catch (Exception e) {annoInstallazione = null;}
				
				if (annoInstallazione.intValue() > GenericUtil.getAnnoProssimo())
				{
					Exception e = new Exception();
					TrackingDbBEException bee = new TrackingDbBEException("Non e' possibile inserire una data futura ("+annoInstallazione+")", e); 
					throw bee;
				}
				
				try{codiceCatastoRegionaleImpiantiTermici = Converter.convertToInteger(impianto.getCodiceCatastoRegionaleImpiantiTermici());}catch (Exception e) {codiceCatastoRegionaleImpiantiTermici = null; /*aggiungere riga di log ?*/}
				//Se è presente la lista dei vettoriEnergeticiUtilizzati prendo il primo elemento e scarto gli altri
				try{vettoriEnergeticiUtilizzati = impianto.getVettoriEnergeticiUtilizzati().getVettoreList().get(0);}catch (Exception e) {vettoriEnergeticiUtilizzati = null;} 
				try{potenzaNominale = impianto.getPotenzaNominale();}catch (Exception e) {potenzaNominale = null;}
				
				String descrizioneCompletaImpianto = decodTipoImpiantoDesc(tipoImpianto, elencoTipiImpianto) + " " + StringUtils.trimToEmpty(descrizioneImpianto);
				
				log.debug("Stampo la descrizioneCompletaImpianto: "+descrizioneCompletaImpianto);
				
				if (descrizioneCompletaImpianto.length() > 100) {
					Exception e = new Exception();
					TrackingDbBEException bee = new TrackingDbBEException("La descrizione dell'impianto \"" + descrizioneCompletaImpianto + "\" e' maggiore di 100 caratteri", e); 
					throw bee;
				}
//				ri[i].setTipoImpianto(descrizioneCompletaImpianto);
//				ri[i].setAnnoInst(Converter.convertToBigInteger(annoInstallazione));
//				if (codiceCatastoRegionaleImpiantiTermici != null)
//					ri[i].setCodCatReg(codiceCatastoRegionaleImpiantiTermici.toString());
//				else
//					ri[i].setCodCatReg(null);
//				ri[i].setCombustibile(decodVettoreEnergeticoDettImpiantoDesc(decodCombustibile(vettoriEnergeticiUtilizzati), elencoCombustibiliDettImpianti));
//				ri[i].setPotenza(potenzaNominale);
//				i++;
				
				dettImp.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
				dettImp.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
				dettImp.setAnno(pkDatiGenerali.getAnno());
				dettImp.setProgressivoDett(++i);
				dettImp.setFkTipoImpianto(Converter.convertToInteger(tipoImpianto));
				dettImp.setTipoImpianto(descrizioneImpianto);
				dettImp.setAnnoInstall(annoInstallazione);
				if (codiceCatastoRegionaleImpiantiTermici != null)
				{
					dettImp.setCodiceImpiantoCit(codiceCatastoRegionaleImpiantiTermici);
				}
				dettImp.setFkCombustibile(decodCombustibile(vettoriEnergeticiUtilizzati));
				
				dettImp.setPotenzaNominKw(Converter.convertToDouble(potenzaNominale));
				dettImp.setFkServEner(codServizioEnergetico);
				dettImpList.add(dettImp);
				i++;
				
				
			}
		} else {
			if (impiantoSimulato !=  null) {
				// impianto simulato
				log.debug("\n\n\n >>>>>>> impianto simulato ");
//				ri = new it.csi.sicee.siceeweb.xml.attestato2015.data.RowImpiantoDocument.RowImpianto[1];
//				ri[0] = it.csi.sicee.siceeweb.xml.attestato2015.data.RowImpiantoDocument.RowImpianto.Factory.newInstance();
//				ri[0].setTipoImpianto(impiantoSimulato);
//				ri[0].setCombustibile(decodVettoreEnergeticoDettImpiantoDesc(Constants.ID_COMBUSTIBILE_GASNATURALE, elencoCombustibiliDettImpianti));
//				
				// Inizializzo l'oggetto
				dettImp = new SiceeTDetImp2015();
				
				dettImp.setIdCertificatore(pkDatiGenerali.getIdCertificatore());
				dettImp.setProgrCertificato(pkDatiGenerali.getProgrCertificato());
				dettImp.setAnno(pkDatiGenerali.getAnno());
				dettImp.setProgressivoDett(++i);
				dettImp.setTipoImpianto(impiantoSimulato);
				
				dettImp.setFkCombustibile(Constants.ID_COMBUSTIBILE_GASNATURALE);
				dettImp.setFkServEner(codServizioEnergetico);

				dettImpList.add(dettImp);

			}
		}
		
		return dettImpList;
	}
	
	public static CodiceDescrizione decodVettoreEnergetico (Short vettore, List<SiceeDCombustibile> combustibiliEsportazione) {
		CodiceDescrizione retval = new CodiceDescrizione();
		//0=100-Energia elettrica ; 1=101-Energia termica ; 2=102-Altro
		if (vettore != null) {
			for (SiceeDCombustibile ce : combustibiliEsportazione) {
				if (ce.getIdCombustibile().intValue() == (vettore.intValue() + 100)) {
					retval.setCodice(ce.getIdCombustibile().toString());
					retval.setDescrizione(ce.getDescr());
				}
			}
		}
		return retval;
	}

	public static Integer decodClasseEnergetica (String descrizione, List<SiceeDClasseEnergetica> classiEnergetiche) {
		if (descrizione != null) {
			for (SiceeDClasseEnergetica ce : classiEnergetiche) {
				if (ce.getDescr().equalsIgnoreCase(descrizione))
					return ce.getIdClasse();
			}
		}
		return null;
	}

	public static Integer decodClasseEnergeticaDescr (String classe, List<SiceeDClasseEnergetica> classiEnergetiche) {
		Integer retval = null;
		if (classe != null) {
			for (SiceeDClasseEnergetica ce : classiEnergetiche) {
				if (ce.getDescr().equalsIgnoreCase(classe)) 
				{
					retval = ce.getIdClasse();
				}
			}
		}
		return retval;
	}
	
	public static String decodClasseEnergeticaId (Integer idClasse, List<SiceeDClasseEnergetica> classiEnergetiche) {
		String retval = null;
		if (idClasse != null) {
			for (SiceeDClasseEnergetica ce : classiEnergetiche) {
				if (ce.getIdClasse().intValue() == idClasse.intValue()) 
				{
					retval = ce.getDescr();
				}
			}
		}
		return retval;
	}
	
	public static String decodComboBoolean (boolean codice) {
		String retval = null;
		//false=0 true=1
		if (codice == false) {
			retval = "0";
		} else {
			retval = "1";
		}
		return retval;
	}

	public static String decodBooleanSINO (boolean codice) {
		String retval = null;
		//false=0 true=1
		if (codice == false) {
			retval = Constants.LABEL_NO.toUpperCase();
		} else {
			retval = Constants.LABEL_SI.toUpperCase();
		}
		return retval;
	}
	
	public static String decodREN (Short codice) {
		String retval = null;
		//0=REN1 ; 1=REN2 ; 2=REN3 ; 3=REN4  ; 4=REN5  ; 5=REN6
		if (codice != null) {
			retval = "REN" + (codice + 1);
		}
		return retval;
	}

	public static Integer decodCombustibile (Short codice) {
		Integer retval = null;
		//0=200-Energia elettrica ; 1=201-Gas Naurale ; 2=202-GPL ; ecc.
		if (codice != null) {
			retval = codice + 200;
		}
		return retval;
	}

	public static Integer decodVettoreEnergetico (Short vettore) {
		Integer retval = null;
		//0=100-Energia elettrica ; 1=101-Energia termica ; 2=102-Altro
		if (vettore != null) {
			retval = vettore.intValue() + 100;
		}
		
		return retval;
	}
	
	public static String decodVettoreEnergeticoDettImpiantoDesc (Integer vettore, List<SiceeDCombustibile> combustibiliEsportazione) {
		String retval = new String();
		if (vettore != null) {
			for (SiceeDCombustibile ce : combustibiliEsportazione) {
				if (ce.getIdCombustibile().intValue() == vettore.intValue()) 
				{
					retval = ce.getDescr();
				}
			}
		}
		return retval;
	}
	
	public static String decodTipoImpiantoDesc (Short tipoImpianto, List<SiceeDTipoImpianto2015> tipiImpianto) {
		String retval = new String();
		if (tipoImpianto != null) {
			
			retval = decodTipoImpiantoDesc(tipoImpianto.intValue(), tipiImpianto);
			
		}
		return retval;
	}
	
	public static String decodTipoImpiantoDesc (Integer tipoImpianto, List<SiceeDTipoImpianto2015> tipiImpianto) {
		String retval = new String();
		
		if (!GenericUtil.isNullOrEmpty(tipoImpianto)) {
			for (SiceeDTipoImpianto2015 ce : tipiImpianto) {
				if (ce.getIdTipoImpianto().intValue() == tipoImpianto.intValue()) 
				{
					retval = ce.getDescr();
				}
			}
		}
		return retval;
	}
	
	public static String decodRiqEnergCod (Short id, List<SiceeDRiqEner2015> listRiqEner) {
		String retval = null;
		if (id != null) {
			for (SiceeDRiqEner2015 ce : listRiqEner) {
				if (ce.getIdXml().intValue() == id.intValue()) 
				{
					retval = ce.getCodiceRen();
				}
			}
		}
		return retval;
	}
	
	public static Integer decodMotivazione (Short codice) {
		Integer retval = null;
		//0=100-Nuova costruzione ; 1=101-Passaggio di proprieta' ; 2=102-Locazione
		if (codice != null) {
			retval = codice + 100;
		}
		return retval;
	}

}
