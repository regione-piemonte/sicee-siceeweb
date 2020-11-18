/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.print.dto;

import java.io.Serializable;
import java.util.List;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCertifServener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRCombDener2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDetImp2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015;
//import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDaticatastSec;
import it.csi.sicee.siceeweb.dto.geo.Comune;

public class DatiGenericiDto implements Serializable{
	
	protected SiceeTCertificato certificato;
	protected SiceeTDatiGenerali datiGenerali;
	protected SiceeTAltreInfo altreInfo;
	protected SiceeTDatiXml2015 datiXml2015;
	protected SiceeTDatiXmlEdReale2015 datiXmlEdReale2015;
	protected SiceeTDatiXmlEdRif2015 datiXmlEdRif2015;
	protected SiceeDDestUso2015 destinazioneUso2015;
	protected String zonaClimatica;
	protected Comune comune;
	//protected List<SiceeTDaticatastSec> datiCatastaliSec;
	protected List<SiceeDClasseEnergetica> classiEnergetiche;
	protected List<SiceeDCombustibile> combustibiliEsportazione;
	protected SiceeDCombustibile combustibileEsportazione;

	// NEW
	protected SiceeTDatiEner2015 datiEner2015;
	protected List<SiceeTDaticatastSec> datiCatastaliSec;
	protected List<SiceeTQtaConsumi2015> quantitaConsumi2015;
	protected List<SiceeTRaccomand2015> raccomandazioni2015;
	protected List<SiceeRCertifServener2015> certifServener2015;
	protected List<SiceeTDetImp2015> detImp2015;

	
	public SiceeTCertificato getCertificato() {
		return this.certificato;
	}
	public void setCertificato(SiceeTCertificato certificato) {
		this.certificato = certificato;
	}

	public SiceeTDatiGenerali getDatiGenerali() {
		return this.datiGenerali;
	}
	public void setDatiGenerali(SiceeTDatiGenerali datiGenerali) {
		this.datiGenerali = datiGenerali;
	}

	public SiceeTAltreInfo getAltreInfo() {
		return this.altreInfo;
	}
	public void setAltreInfo(SiceeTAltreInfo altreInfo) {
		this.altreInfo = altreInfo;
	}

	public SiceeTDatiXml2015 getDatiXml2015() {
		return this.datiXml2015;
	}
	public void setDatiXml2015(SiceeTDatiXml2015 datiXml2015) {
		this.datiXml2015 = datiXml2015;
	}

	public SiceeTDatiXmlEdReale2015 getDatiXmlEdReale2015() {
		return this.datiXmlEdReale2015;
	}
	public void setDatiXmlEdReale2015(SiceeTDatiXmlEdReale2015 datiXmlEdReale2015) {
		this.datiXmlEdReale2015 = datiXmlEdReale2015;
	}

	public SiceeTDatiXmlEdRif2015 getDatiXmlEdRif2015() {
		return this.datiXmlEdRif2015;
	}
	public void setDatiXmlEdRif2015(SiceeTDatiXmlEdRif2015 datiXmlEdRif2015) {
		this.datiXmlEdRif2015 = datiXmlEdRif2015;
	}

	public SiceeDDestUso2015 getDestinazioneUso2015() {
		return this.destinazioneUso2015;
	}
	public void setDestinazioneUso2015(SiceeDDestUso2015 destinazioneUso2015) {
		this.destinazioneUso2015 = destinazioneUso2015;
	}

	public String getZonaClimatica() {
		return this.zonaClimatica;
	}
	public void setZonaClimatica(String zonaClimatica) {
		this.zonaClimatica = zonaClimatica;
	}

	public Comune getComune() {
		return this.comune;
	}
	public void setComune(Comune comune) {
		this.comune = comune;
	}
/*
	public List<SiceeTDaticatastSec> getDatiCatastaliSec() {
		return this.datiCatastaliSec;
	}
	public void setDatiCatastaliSec(List<SiceeTDaticatastSec> datiCatastaliSec) {
		this.datiCatastaliSec = datiCatastaliSec;
	}

*/
	public List<SiceeDClasseEnergetica> getClassiEnergetiche() {
		return this.classiEnergetiche;
	}
	public void setClassiEnergetiche(List<SiceeDClasseEnergetica> classiEnergetiche) {
		this.classiEnergetiche = classiEnergetiche;
	}

	public List<SiceeDCombustibile> getCombustibiliEsportazione() {
		return this.combustibiliEsportazione;
	}
	public void setCombustibiliEsportazione(List<SiceeDCombustibile> combustibiliEsportazione) {
		this.combustibiliEsportazione = combustibiliEsportazione;
	}
	public SiceeDCombustibile getCombustibileEsportazione() {
		return combustibileEsportazione;
	}
	public void setCombustibileEsportazione(
			SiceeDCombustibile combustibileEsportazione) {
		this.combustibileEsportazione = combustibileEsportazione;
	}
	public List<SiceeTDaticatastSec> getDatiCatastaliSec() {
		return datiCatastaliSec;
	}
	public void setDatiCatastaliSec(List<SiceeTDaticatastSec> datiCatastaliSec) {
		this.datiCatastaliSec = datiCatastaliSec;
	}
	public SiceeTDatiEner2015 getDatiEner2015() {
		return datiEner2015;
	}
	public void setDatiEner2015(SiceeTDatiEner2015 datiEner2015) {
		this.datiEner2015 = datiEner2015;
	}
	public List<SiceeTQtaConsumi2015> getQuantitaConsumi2015() {
		return quantitaConsumi2015;
	}
	public void setQuantitaConsumi2015(
			List<SiceeTQtaConsumi2015> quantitaConsumi2015) {
		this.quantitaConsumi2015 = quantitaConsumi2015;
	}
	public List<SiceeTRaccomand2015> getRaccomandazioni2015() {
		return raccomandazioni2015;
	}
	public void setRaccomandazioni2015(List<SiceeTRaccomand2015> raccomandazioni2015) {
		this.raccomandazioni2015 = raccomandazioni2015;
	}
	public List<SiceeRCertifServener2015> getCertifServener2015() {
		return certifServener2015;
	}
	public void setCertifServener2015(
			List<SiceeRCertifServener2015> certifServener2015) {
		this.certifServener2015 = certifServener2015;
	}
	public List<SiceeTDetImp2015> getDetImp2015() {
		return detImp2015;
	}
	public void setDetImp2015(List<SiceeTDetImp2015> detImp2015) {
		this.detImp2015 = detImp2015;
	}
	
	
}
