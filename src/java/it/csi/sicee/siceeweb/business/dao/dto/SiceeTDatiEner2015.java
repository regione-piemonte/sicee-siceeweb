/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import it.csi.sicee.siceeweb.business.dao.dao.*;
import it.csi.sicee.siceeweb.business.dao.factory.*;
import it.csi.sicee.siceeweb.business.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class SiceeTDatiEner2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_CLASSE_ENERGETICA in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Integer fkClasseEnergetica;

	/** 
	 * This attribute maps to the column FK_CE_RACC_TOTALE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Integer fkCeRaccTotale;

	/** 
	 * This attribute maps to the column FK_CLASSE_ENER_ESISTENTI in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Integer fkClasseEnerEsistenti;

	/** 
	 * This attribute maps to the column FK_CLASSE_ENER_NUOVI in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Integer fkClasseEnerNuovi;

	/** 
	 * This attribute maps to the column EPH in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double eph;

	/** 
	 * This attribute maps to the column EPH_LIMITE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double ephLimite;

	/** 
	 * This attribute maps to the column YIE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double yie;

	/** 
	 * This attribute maps to the column ASOL_ASUP in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double asolAsup;

	/** 
	 * This attribute maps to the column FLG_EDIF_E0 in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String flgEdifE0;

	/** 
	 * This attribute maps to the column FLG_CLIMAT_INVERNALE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String flgClimatInvernale;

	/** 
	 * This attribute maps to the column FLG_CLIMAT_ESTIVA in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String flgClimatEstiva;

	/** 
	 * This attribute maps to the column FLG_VENTIL_MECCANICA in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String flgVentilMeccanica;

	/** 
	 * This attribute maps to the column FLG_PROD_H2O_SANITARIA in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String flgProdH2oSanitaria;

	/** 
	 * This attribute maps to the column FLG_ILLUMINAZIONE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String flgIlluminazione;

	/** 
	 * This attribute maps to the column FLG_TRASPORTO_PERS_COSE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected String flgTrasportoPersCose;

	/** 
	 * This attribute maps to the column ENERGIA_ESPORTATA in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double energiaEsportata;

	/** 
	 * This attribute maps to the column EPGL_NREN_RACC_TOTALE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double epglNrenRaccTotale;

	/** 
	 * This attribute maps to the column EPGL_REN_GLOBALE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double epglRenGlobale;

	/** 
	 * This attribute maps to the column EPGL_NREN_GLOBALE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double epglNrenGlobale;

	/** 
	 * This attribute maps to the column EMISSIONI_CO2 in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double emissioniCo2;

	/** 
	 * This attribute maps to the column EPGL_NREN_NUOVI in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double epglNrenNuovi;

	/** 
	 * This attribute maps to the column EPGL_NREN_ESISTENTI in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double epglNrenEsistenti;

	/** 
	 * This attribute maps to the column EPGL_NREN_RIF in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double epglNrenRif;

	/** 
	 * This attribute maps to the column FLG_SMILE_INVERNO in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Integer flgSmileInverno;
	
	/** 
	 * This attribute maps to the column FLG_SMILE_ESTATE in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Integer flgSmileEstate;
	
	/** 
	 * This attribute maps to the column RAPPORTO_SV in the SICEE_T_DATI_ENER_2015 table.
	 */
	protected Double rapportoSv;

	
	/**
	 * Method 'SiceeTDatiEner2015'
	 * 
	 */
	public SiceeTDatiEner2015()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return idCertificatore;
	}

	/**
	 * Method 'setIdCertificatore'
	 * 
	 * @param idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/**
	 * Method 'getProgrCertificato'
	 * 
	 * @return String
	 */
	public String getProgrCertificato()
	{
		return progrCertificato;
	}

	/**
	 * Method 'setProgrCertificato'
	 * 
	 * @param progrCertificato
	 */
	public void setProgrCertificato(String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/**
	 * Method 'getAnno'
	 * 
	 * @return String
	 */
	public String getAnno()
	{
		return anno;
	}

	/**
	 * Method 'setAnno'
	 * 
	 * @param anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/**
	 * Method 'getFkClasseEnergetica'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasseEnergetica()
	{
		return fkClasseEnergetica;
	}

	/**
	 * Method 'setFkClasseEnergetica'
	 * 
	 * @param fkClasseEnergetica
	 */
	public void setFkClasseEnergetica(Integer fkClasseEnergetica)
	{
		this.fkClasseEnergetica = fkClasseEnergetica;
	}

	/**
	 * Method 'getFkCeRaccTotale'
	 * 
	 * @return Integer
	 */
	public Integer getFkCeRaccTotale()
	{
		return fkCeRaccTotale;
	}

	/**
	 * Method 'setFkCeRaccTotale'
	 * 
	 * @param fkCeRaccTotale
	 */
	public void setFkCeRaccTotale(Integer fkCeRaccTotale)
	{
		this.fkCeRaccTotale = fkCeRaccTotale;
	}

	/**
	 * Method 'getFkClasseEnerEsistenti'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasseEnerEsistenti()
	{
		return fkClasseEnerEsistenti;
	}

	/**
	 * Method 'setFkClasseEnerEsistenti'
	 * 
	 * @param fkClasseEnerEsistenti
	 */
	public void setFkClasseEnerEsistenti(Integer fkClasseEnerEsistenti)
	{
		this.fkClasseEnerEsistenti = fkClasseEnerEsistenti;
	}

	/**
	 * Method 'getFkClasseEnerNuovi'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasseEnerNuovi()
	{
		return fkClasseEnerNuovi;
	}

	/**
	 * Method 'setFkClasseEnerNuovi'
	 * 
	 * @param fkClasseEnerNuovi
	 */
	public void setFkClasseEnerNuovi(Integer fkClasseEnerNuovi)
	{
		this.fkClasseEnerNuovi = fkClasseEnerNuovi;
	}

	/**
	 * Method 'getEph'
	 * 
	 * @return Double
	 */
	public Double getEph()
	{
		return eph;
	}

	/**
	 * Method 'setEph'
	 * 
	 * @param eph
	 */
	public void setEph(Double eph)
	{
		this.eph = eph;
	}

	/**
	 * Method 'getEphLimite'
	 * 
	 * @return Double
	 */
	public Double getEphLimite()
	{
		return ephLimite;
	}

	/**
	 * Method 'setEphLimite'
	 * 
	 * @param ephLimite
	 */
	public void setEphLimite(Double ephLimite)
	{
		this.ephLimite = ephLimite;
	}

	/**
	 * Method 'getYie'
	 * 
	 * @return Double
	 */
	public Double getYie()
	{
		return yie;
	}

	/**
	 * Method 'setYie'
	 * 
	 * @param yie
	 */
	public void setYie(Double yie)
	{
		this.yie = yie;
	}

	/**
	 * Method 'getAsolAsup'
	 * 
	 * @return Double
	 */
	public Double getAsolAsup()
	{
		return asolAsup;
	}

	/**
	 * Method 'setAsolAsup'
	 * 
	 * @param asolAsup
	 */
	public void setAsolAsup(Double asolAsup)
	{
		this.asolAsup = asolAsup;
	}

	/**
	 * Method 'getFlgEdifE0'
	 * 
	 * @return String
	 */
	public String getFlgEdifE0()
	{
		return flgEdifE0;
	}

	/**
	 * Method 'setFlgEdifE0'
	 * 
	 * @param flgEdifE0
	 */
	public void setFlgEdifE0(String flgEdifE0)
	{
		this.flgEdifE0 = flgEdifE0;
	}

	/**
	 * Method 'getFlgClimatInvernale'
	 * 
	 * @return String
	 */
	public String getFlgClimatInvernale()
	{
		return flgClimatInvernale;
	}

	/**
	 * Method 'setFlgClimatInvernale'
	 * 
	 * @param flgClimatInvernale
	 */
	public void setFlgClimatInvernale(String flgClimatInvernale)
	{
		this.flgClimatInvernale = flgClimatInvernale;
	}

	/**
	 * Method 'getFlgClimatEstiva'
	 * 
	 * @return String
	 */
	public String getFlgClimatEstiva()
	{
		return flgClimatEstiva;
	}

	/**
	 * Method 'setFlgClimatEstiva'
	 * 
	 * @param flgClimatEstiva
	 */
	public void setFlgClimatEstiva(String flgClimatEstiva)
	{
		this.flgClimatEstiva = flgClimatEstiva;
	}

	/**
	 * Method 'getFlgVentilMeccanica'
	 * 
	 * @return String
	 */
	public String getFlgVentilMeccanica()
	{
		return flgVentilMeccanica;
	}

	/**
	 * Method 'setFlgVentilMeccanica'
	 * 
	 * @param flgVentilMeccanica
	 */
	public void setFlgVentilMeccanica(String flgVentilMeccanica)
	{
		this.flgVentilMeccanica = flgVentilMeccanica;
	}

	/**
	 * Method 'getFlgProdH2oSanitaria'
	 * 
	 * @return String
	 */
	public String getFlgProdH2oSanitaria()
	{
		return flgProdH2oSanitaria;
	}

	/**
	 * Method 'setFlgProdH2oSanitaria'
	 * 
	 * @param flgProdH2oSanitaria
	 */
	public void setFlgProdH2oSanitaria(String flgProdH2oSanitaria)
	{
		this.flgProdH2oSanitaria = flgProdH2oSanitaria;
	}

	/**
	 * Method 'getFlgIlluminazione'
	 * 
	 * @return String
	 */
	public String getFlgIlluminazione()
	{
		return flgIlluminazione;
	}

	/**
	 * Method 'setFlgIlluminazione'
	 * 
	 * @param flgIlluminazione
	 */
	public void setFlgIlluminazione(String flgIlluminazione)
	{
		this.flgIlluminazione = flgIlluminazione;
	}

	/**
	 * Method 'getFlgTrasportoPersCose'
	 * 
	 * @return String
	 */
	public String getFlgTrasportoPersCose()
	{
		return flgTrasportoPersCose;
	}

	/**
	 * Method 'setFlgTrasportoPersCose'
	 * 
	 * @param flgTrasportoPersCose
	 */
	public void setFlgTrasportoPersCose(String flgTrasportoPersCose)
	{
		this.flgTrasportoPersCose = flgTrasportoPersCose;
	}

	/**
	 * Method 'getEnergiaEsportata'
	 * 
	 * @return Double
	 */
	public Double getEnergiaEsportata()
	{
		return energiaEsportata;
	}

	/**
	 * Method 'setEnergiaEsportata'
	 * 
	 * @param energiaEsportata
	 */
	public void setEnergiaEsportata(Double energiaEsportata)
	{
		this.energiaEsportata = energiaEsportata;
	}

	/**
	 * Method 'getEpglNrenRaccTotale'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenRaccTotale()
	{
		return epglNrenRaccTotale;
	}

	/**
	 * Method 'setEpglNrenRaccTotale'
	 * 
	 * @param epglNrenRaccTotale
	 */
	public void setEpglNrenRaccTotale(Double epglNrenRaccTotale)
	{
		this.epglNrenRaccTotale = epglNrenRaccTotale;
	}

	/**
	 * Method 'getEpglRenGlobale'
	 * 
	 * @return Double
	 */
	public Double getEpglRenGlobale()
	{
		return epglRenGlobale;
	}

	/**
	 * Method 'setEpglRenGlobale'
	 * 
	 * @param epglRenGlobale
	 */
	public void setEpglRenGlobale(Double epglRenGlobale)
	{
		this.epglRenGlobale = epglRenGlobale;
	}

	/**
	 * Method 'getEpglNrenGlobale'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenGlobale()
	{
		return epglNrenGlobale;
	}

	/**
	 * Method 'setEpglNrenGlobale'
	 * 
	 * @param epglNrenGlobale
	 */
	public void setEpglNrenGlobale(Double epglNrenGlobale)
	{
		this.epglNrenGlobale = epglNrenGlobale;
	}

	/**
	 * Method 'getEmissioniCo2'
	 * 
	 * @return Double
	 */
	public Double getEmissioniCo2()
	{
		return emissioniCo2;
	}

	/**
	 * Method 'setEmissioniCo2'
	 * 
	 * @param emissioniCo2
	 */
	public void setEmissioniCo2(Double emissioniCo2)
	{
		this.emissioniCo2 = emissioniCo2;
	}

	/**
	 * Method 'getEpglNrenNuovi'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenNuovi()
	{
		return epglNrenNuovi;
	}

	/**
	 * Method 'setEpglNrenNuovi'
	 * 
	 * @param epglNrenNuovi
	 */
	public void setEpglNrenNuovi(Double epglNrenNuovi)
	{
		this.epglNrenNuovi = epglNrenNuovi;
	}

	/**
	 * Method 'getEpglNrenEsistenti'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenEsistenti()
	{
		return epglNrenEsistenti;
	}

	/**
	 * Method 'setEpglNrenEsistenti'
	 * 
	 * @param epglNrenEsistenti
	 */
	public void setEpglNrenEsistenti(Double epglNrenEsistenti)
	{
		this.epglNrenEsistenti = epglNrenEsistenti;
	}

	/**
	 * Method 'getEpglNrenRif'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenRif()
	{
		return epglNrenRif;
	}

	/**
	 * Method 'setEpglNrenRif'
	 * 
	 * @param epglNrenRif
	 */
	public void setEpglNrenRif(Double epglNrenRif)
	{
		this.epglNrenRif = epglNrenRif;
	}
	
	

	public Integer getFlgSmileInverno() {
		return flgSmileInverno;
	}

	public void setFlgSmileInverno(Integer flgSmileInverno) {
		this.flgSmileInverno = flgSmileInverno;
	}

	public Integer getFlgSmileEstate() {
		return flgSmileEstate;
	}

	public void setFlgSmileEstate(Integer flgSmileEstate) {
		this.flgSmileEstate = flgSmileEstate;
	}

	public Double getRapportoSv() {
		return rapportoSv;
	}

	public void setRapportoSv(Double rapportoSv) {
		this.rapportoSv = rapportoSv;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeTDatiEner2015)) {
			return false;
		}
		
		final SiceeTDatiEner2015 _cast = (SiceeTDatiEner2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (fkClasseEnergetica == null ? _cast.fkClasseEnergetica != fkClasseEnergetica : !fkClasseEnergetica.equals( _cast.fkClasseEnergetica )) {
			return false;
		}
		
		if (fkCeRaccTotale == null ? _cast.fkCeRaccTotale != fkCeRaccTotale : !fkCeRaccTotale.equals( _cast.fkCeRaccTotale )) {
			return false;
		}
		
		if (fkClasseEnerEsistenti == null ? _cast.fkClasseEnerEsistenti != fkClasseEnerEsistenti : !fkClasseEnerEsistenti.equals( _cast.fkClasseEnerEsistenti )) {
			return false;
		}
		
		if (fkClasseEnerNuovi == null ? _cast.fkClasseEnerNuovi != fkClasseEnerNuovi : !fkClasseEnerNuovi.equals( _cast.fkClasseEnerNuovi )) {
			return false;
		}
		
		if (eph == null ? _cast.eph != eph : !eph.equals( _cast.eph )) {
			return false;
		}
		
		if (ephLimite == null ? _cast.ephLimite != ephLimite : !ephLimite.equals( _cast.ephLimite )) {
			return false;
		}
		
		if (yie == null ? _cast.yie != yie : !yie.equals( _cast.yie )) {
			return false;
		}
		
		if (asolAsup == null ? _cast.asolAsup != asolAsup : !asolAsup.equals( _cast.asolAsup )) {
			return false;
		}
		
		if (flgEdifE0 == null ? _cast.flgEdifE0 != flgEdifE0 : !flgEdifE0.equals( _cast.flgEdifE0 )) {
			return false;
		}
		
		if (flgClimatInvernale == null ? _cast.flgClimatInvernale != flgClimatInvernale : !flgClimatInvernale.equals( _cast.flgClimatInvernale )) {
			return false;
		}
		
		if (flgClimatEstiva == null ? _cast.flgClimatEstiva != flgClimatEstiva : !flgClimatEstiva.equals( _cast.flgClimatEstiva )) {
			return false;
		}
		
		if (flgVentilMeccanica == null ? _cast.flgVentilMeccanica != flgVentilMeccanica : !flgVentilMeccanica.equals( _cast.flgVentilMeccanica )) {
			return false;
		}
		
		if (flgProdH2oSanitaria == null ? _cast.flgProdH2oSanitaria != flgProdH2oSanitaria : !flgProdH2oSanitaria.equals( _cast.flgProdH2oSanitaria )) {
			return false;
		}
		
		if (flgIlluminazione == null ? _cast.flgIlluminazione != flgIlluminazione : !flgIlluminazione.equals( _cast.flgIlluminazione )) {
			return false;
		}
		
		if (flgTrasportoPersCose == null ? _cast.flgTrasportoPersCose != flgTrasportoPersCose : !flgTrasportoPersCose.equals( _cast.flgTrasportoPersCose )) {
			return false;
		}
		
		if (energiaEsportata == null ? _cast.energiaEsportata != energiaEsportata : !energiaEsportata.equals( _cast.energiaEsportata )) {
			return false;
		}
		
		if (epglNrenRaccTotale == null ? _cast.epglNrenRaccTotale != epglNrenRaccTotale : !epglNrenRaccTotale.equals( _cast.epglNrenRaccTotale )) {
			return false;
		}
		
		if (epglRenGlobale == null ? _cast.epglRenGlobale != epglRenGlobale : !epglRenGlobale.equals( _cast.epglRenGlobale )) {
			return false;
		}
		
		if (epglNrenGlobale == null ? _cast.epglNrenGlobale != epglNrenGlobale : !epglNrenGlobale.equals( _cast.epglNrenGlobale )) {
			return false;
		}
		
		if (emissioniCo2 == null ? _cast.emissioniCo2 != emissioniCo2 : !emissioniCo2.equals( _cast.emissioniCo2 )) {
			return false;
		}
		
		if (epglNrenNuovi == null ? _cast.epglNrenNuovi != epglNrenNuovi : !epglNrenNuovi.equals( _cast.epglNrenNuovi )) {
			return false;
		}
		
		if (epglNrenEsistenti == null ? _cast.epglNrenEsistenti != epglNrenEsistenti : !epglNrenEsistenti.equals( _cast.epglNrenEsistenti )) {
			return false;
		}
		
		if (epglNrenRif == null ? _cast.epglNrenRif != epglNrenRif : !epglNrenRif.equals( _cast.epglNrenRif )) {
			return false;
		}
		
		if (flgSmileInverno == null ? _cast.flgSmileInverno != flgSmileInverno : !flgSmileInverno.equals( _cast.flgSmileInverno )) {
			return false;
		}
		
		if (flgSmileEstate == null ? _cast.flgSmileEstate != flgSmileEstate : !flgSmileEstate.equals( _cast.flgSmileEstate )) {
			return false;
		}
		
		if (rapportoSv == null ? _cast.rapportoSv != rapportoSv : !rapportoSv.equals( _cast.rapportoSv )) {
			return false;
		}
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (fkClasseEnergetica != null) {
			_hashCode = 29 * _hashCode + fkClasseEnergetica.hashCode();
		}
		
		if (fkCeRaccTotale != null) {
			_hashCode = 29 * _hashCode + fkCeRaccTotale.hashCode();
		}
		
		if (fkClasseEnerEsistenti != null) {
			_hashCode = 29 * _hashCode + fkClasseEnerEsistenti.hashCode();
		}
		
		if (fkClasseEnerNuovi != null) {
			_hashCode = 29 * _hashCode + fkClasseEnerNuovi.hashCode();
		}
		
		if (eph != null) {
			_hashCode = 29 * _hashCode + eph.hashCode();
		}
		
		if (ephLimite != null) {
			_hashCode = 29 * _hashCode + ephLimite.hashCode();
		}
		
		if (yie != null) {
			_hashCode = 29 * _hashCode + yie.hashCode();
		}
		
		if (asolAsup != null) {
			_hashCode = 29 * _hashCode + asolAsup.hashCode();
		}
		
		if (flgEdifE0 != null) {
			_hashCode = 29 * _hashCode + flgEdifE0.hashCode();
		}
		
		if (flgClimatInvernale != null) {
			_hashCode = 29 * _hashCode + flgClimatInvernale.hashCode();
		}
		
		if (flgClimatEstiva != null) {
			_hashCode = 29 * _hashCode + flgClimatEstiva.hashCode();
		}
		
		if (flgVentilMeccanica != null) {
			_hashCode = 29 * _hashCode + flgVentilMeccanica.hashCode();
		}
		
		if (flgProdH2oSanitaria != null) {
			_hashCode = 29 * _hashCode + flgProdH2oSanitaria.hashCode();
		}
		
		if (flgIlluminazione != null) {
			_hashCode = 29 * _hashCode + flgIlluminazione.hashCode();
		}
		
		if (flgTrasportoPersCose != null) {
			_hashCode = 29 * _hashCode + flgTrasportoPersCose.hashCode();
		}
		
		if (energiaEsportata != null) {
			_hashCode = 29 * _hashCode + energiaEsportata.hashCode();
		}
		
		if (epglNrenRaccTotale != null) {
			_hashCode = 29 * _hashCode + epglNrenRaccTotale.hashCode();
		}
		
		if (epglRenGlobale != null) {
			_hashCode = 29 * _hashCode + epglRenGlobale.hashCode();
		}
		
		if (epglNrenGlobale != null) {
			_hashCode = 29 * _hashCode + epglNrenGlobale.hashCode();
		}
		
		if (emissioniCo2 != null) {
			_hashCode = 29 * _hashCode + emissioniCo2.hashCode();
		}
		
		if (epglNrenNuovi != null) {
			_hashCode = 29 * _hashCode + epglNrenNuovi.hashCode();
		}
		
		if (epglNrenEsistenti != null) {
			_hashCode = 29 * _hashCode + epglNrenEsistenti.hashCode();
		}
		
		if (epglNrenRif != null) {
			_hashCode = 29 * _hashCode + epglNrenRif.hashCode();
		}
		
		if (flgSmileInverno != null) {
			_hashCode = 29 * _hashCode + flgSmileInverno.hashCode();
		}
		
		if (flgSmileEstate != null) {
			_hashCode = 29 * _hashCode + flgSmileEstate.hashCode();
		}
		
		if (rapportoSv != null) {
			_hashCode = 29 * _hashCode + rapportoSv.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDatiEner2015Pk
	 */
	public SiceeTDatiEner2015Pk createPk()
	{
		return new SiceeTDatiEner2015Pk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", fkClasseEnergetica=" + fkClasseEnergetica );
		ret.append( ", fkCeRaccTotale=" + fkCeRaccTotale );
		ret.append( ", fkClasseEnerEsistenti=" + fkClasseEnerEsistenti );
		ret.append( ", fkClasseEnerNuovi=" + fkClasseEnerNuovi );
		ret.append( ", eph=" + eph );
		ret.append( ", ephLimite=" + ephLimite );
		ret.append( ", yie=" + yie );
		ret.append( ", asolAsup=" + asolAsup );
		ret.append( ", flgEdifE0=" + flgEdifE0 );
		ret.append( ", flgClimatInvernale=" + flgClimatInvernale );
		ret.append( ", flgClimatEstiva=" + flgClimatEstiva );
		ret.append( ", flgVentilMeccanica=" + flgVentilMeccanica );
		ret.append( ", flgProdH2oSanitaria=" + flgProdH2oSanitaria );
		ret.append( ", flgIlluminazione=" + flgIlluminazione );
		ret.append( ", flgTrasportoPersCose=" + flgTrasportoPersCose );
		ret.append( ", energiaEsportata=" + energiaEsportata );
		ret.append( ", epglNrenRaccTotale=" + epglNrenRaccTotale );
		ret.append( ", epglRenGlobale=" + epglRenGlobale );
		ret.append( ", epglNrenGlobale=" + epglNrenGlobale );
		ret.append( ", emissioniCo2=" + emissioniCo2 );
		ret.append( ", epglNrenNuovi=" + epglNrenNuovi );
		ret.append( ", epglNrenEsistenti=" + epglNrenEsistenti );
		ret.append( ", epglNrenRif=" + epglNrenRif );
		ret.append( ", flgSmileInverno=" + flgSmileInverno );
		ret.append( ", flgSmileEstate=" + flgSmileEstate );
		ret.append( ", rapportoSv=" + rapportoSv );
		return ret.toString();
	}

}
