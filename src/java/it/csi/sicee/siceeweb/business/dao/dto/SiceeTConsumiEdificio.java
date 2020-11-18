/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTConsumiEdificio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3794857347968108105L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column DESC_TIPO_EROG in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String descTipoErog;

	/** 
	 * This attribute maps to the column FK_TIPO_IMPIANTO in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected Integer fkTipoImpianto;

	/** 
	 * This attribute maps to the column DESC_TIPO_DISTRIB in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String descTipoDistrib;

	/** 
	 * This attribute maps to the column DESC_TIPO_REG in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String descTipoReg;

	/** 
	 * This attribute maps to the column ANN_TERMI_FOSSILE in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected Double annTermiFossile;

	/** 
	 * This attribute maps to the column ANN_ELETT_FOSSILE in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected Double annElettFossile;

	/** 
	 * This attribute maps to the column ANN_TERMI_RINNO in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected Double annTermiRinno;

	/** 
	 * This attribute maps to the column ANN_ELETT_RINNO in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected Double annElettRinno;

	/** 
	 * This attribute maps to the column COMPLESS_TERMICO in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected Double complessTermico;

	/** 
	 * This attribute maps to the column COMPLESS_ELETTRICO in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected Double complessElettrico;

	/** 
	 * This attribute maps to the column UI_SERVITE in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String uiServite;

	/** 
	 * This attribute maps to the column FLG_CONT_RIP in the SICEE_T_CONSUMI_EDIFICIO table.
	 */
	protected String flgContRip;

	/**
	 * Method 'SiceeTConsumiEdificio'
	 * 
	 */
	public SiceeTConsumiEdificio()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
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
		return this.progrCertificato;
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
		return this.anno;
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
	 * Method 'getDescTipoErog'
	 * 
	 * @return String
	 */
	public String getDescTipoErog()
	{
		return this.descTipoErog;
	}

	/**
	 * Method 'setDescTipoErog'
	 * 
	 * @param descTipoErog
	 */
	public void setDescTipoErog(String descTipoErog)
	{
		this.descTipoErog = descTipoErog;
	}

	/**
	 * Method 'getFkTipoImpianto'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoImpianto()
	{
		return this.fkTipoImpianto;
	}

	/**
	 * Method 'setFkTipoImpianto'
	 * 
	 * @param fkTipoImpianto
	 */
	public void setFkTipoImpianto(Integer fkTipoImpianto)
	{
		this.fkTipoImpianto = fkTipoImpianto;
	}

	/**
	 * Method 'getDescTipoDistrib'
	 * 
	 * @return String
	 */
	public String getDescTipoDistrib()
	{
		return this.descTipoDistrib;
	}

	/**
	 * Method 'setDescTipoDistrib'
	 * 
	 * @param descTipoDistrib
	 */
	public void setDescTipoDistrib(String descTipoDistrib)
	{
		this.descTipoDistrib = descTipoDistrib;
	}

	/**
	 * Method 'getDescTipoReg'
	 * 
	 * @return String
	 */
	public String getDescTipoReg()
	{
		return this.descTipoReg;
	}

	/**
	 * Method 'setDescTipoReg'
	 * 
	 * @param descTipoReg
	 */
	public void setDescTipoReg(String descTipoReg)
	{
		this.descTipoReg = descTipoReg;
	}

	/**
	 * Method 'getAnnTermiFossile'
	 * 
	 * @return Double
	 */
	public Double getAnnTermiFossile()
	{
		return this.annTermiFossile;
	}

	/**
	 * Method 'setAnnTermiFossile'
	 * 
	 * @param annTermiFossile
	 */
	public void setAnnTermiFossile(Double annTermiFossile)
	{
		this.annTermiFossile = annTermiFossile;
	}

	/**
	 * Method 'getAnnElettFossile'
	 * 
	 * @return Double
	 */
	public Double getAnnElettFossile()
	{
		return this.annElettFossile;
	}

	/**
	 * Method 'setAnnElettFossile'
	 * 
	 * @param annElettFossile
	 */
	public void setAnnElettFossile(Double annElettFossile)
	{
		this.annElettFossile = annElettFossile;
	}

	/**
	 * Method 'getAnnTermiRinno'
	 * 
	 * @return Double
	 */
	public Double getAnnTermiRinno()
	{
		return this.annTermiRinno;
	}

	/**
	 * Method 'setAnnTermiRinno'
	 * 
	 * @param annTermiRinno
	 */
	public void setAnnTermiRinno(Double annTermiRinno)
	{
		this.annTermiRinno = annTermiRinno;
	}

	/**
	 * Method 'getAnnElettRinno'
	 * 
	 * @return Double
	 */
	public Double getAnnElettRinno()
	{
		return this.annElettRinno;
	}

	/**
	 * Method 'setAnnElettRinno'
	 * 
	 * @param annElettRinno
	 */
	public void setAnnElettRinno(Double annElettRinno)
	{
		this.annElettRinno = annElettRinno;
	}

	/**
	 * Method 'getComplessTermico'
	 * 
	 * @return Double
	 */
	public Double getComplessTermico()
	{
		return this.complessTermico;
	}

	/**
	 * Method 'setComplessTermico'
	 * 
	 * @param complessTermico
	 */
	public void setComplessTermico(Double complessTermico)
	{
		this.complessTermico = complessTermico;
	}

	/**
	 * Method 'getComplessElettrico'
	 * 
	 * @return Double
	 */
	public Double getComplessElettrico()
	{
		return this.complessElettrico;
	}

	/**
	 * Method 'setComplessElettrico'
	 * 
	 * @param complessElettrico
	 */
	public void setComplessElettrico(Double complessElettrico)
	{
		this.complessElettrico = complessElettrico;
	}

	/**
	 * Method 'getUiServite'
	 * 
	 * @return String
	 */
	public String getUiServite()
	{
		return this.uiServite;
	}

	/**
	 * Method 'setUiServite'
	 * 
	 * @param uiServite
	 */
	public void setUiServite(String uiServite)
	{
		this.uiServite = uiServite;
	}

	/**
	 * Method 'getFlgContRip'
	 * 
	 * @return String
	 */
	public String getFlgContRip()
	{
		return this.flgContRip;
	}

	/**
	 * Method 'setFlgContRip'
	 * 
	 * @param flgContRip
	 */
	public void setFlgContRip(String flgContRip)
	{
		this.flgContRip = flgContRip;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeTConsumiEdificio)) {
			return false;
		}
		
		final SiceeTConsumiEdificio _cast = (SiceeTConsumiEdificio) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.descTipoErog == null ? _cast.descTipoErog != this.descTipoErog : !this.descTipoErog.equals( _cast.descTipoErog )) {
			return false;
		}
		
		if (this.fkTipoImpianto == null ? _cast.fkTipoImpianto != this.fkTipoImpianto : !this.fkTipoImpianto.equals( _cast.fkTipoImpianto )) {
			return false;
		}
		
		if (this.descTipoDistrib == null ? _cast.descTipoDistrib != this.descTipoDistrib : !this.descTipoDistrib.equals( _cast.descTipoDistrib )) {
			return false;
		}
		
		if (this.descTipoReg == null ? _cast.descTipoReg != this.descTipoReg : !this.descTipoReg.equals( _cast.descTipoReg )) {
			return false;
		}
		
		if (this.annTermiFossile == null ? _cast.annTermiFossile != this.annTermiFossile : !this.annTermiFossile.equals( _cast.annTermiFossile )) {
			return false;
		}
		
		if (this.annElettFossile == null ? _cast.annElettFossile != this.annElettFossile : !this.annElettFossile.equals( _cast.annElettFossile )) {
			return false;
		}
		
		if (this.annTermiRinno == null ? _cast.annTermiRinno != this.annTermiRinno : !this.annTermiRinno.equals( _cast.annTermiRinno )) {
			return false;
		}
		
		if (this.annElettRinno == null ? _cast.annElettRinno != this.annElettRinno : !this.annElettRinno.equals( _cast.annElettRinno )) {
			return false;
		}
		
		if (this.complessTermico == null ? _cast.complessTermico != this.complessTermico : !this.complessTermico.equals( _cast.complessTermico )) {
			return false;
		}
		
		if (this.complessElettrico == null ? _cast.complessElettrico != this.complessElettrico : !this.complessElettrico.equals( _cast.complessElettrico )) {
			return false;
		}
		
		if (this.uiServite == null ? _cast.uiServite != this.uiServite : !this.uiServite.equals( _cast.uiServite )) {
			return false;
		}
		
		if (this.flgContRip == null ? _cast.flgContRip != this.flgContRip : !this.flgContRip.equals( _cast.flgContRip )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.descTipoErog != null) {
			_hashCode = 29 * _hashCode + this.descTipoErog.hashCode();
		}
		
		if (this.fkTipoImpianto != null) {
			_hashCode = 29 * _hashCode + this.fkTipoImpianto.hashCode();
		}
		
		if (this.descTipoDistrib != null) {
			_hashCode = 29 * _hashCode + this.descTipoDistrib.hashCode();
		}
		
		if (this.descTipoReg != null) {
			_hashCode = 29 * _hashCode + this.descTipoReg.hashCode();
		}
		
		if (this.annTermiFossile != null) {
			_hashCode = 29 * _hashCode + this.annTermiFossile.hashCode();
		}
		
		if (this.annElettFossile != null) {
			_hashCode = 29 * _hashCode + this.annElettFossile.hashCode();
		}
		
		if (this.annTermiRinno != null) {
			_hashCode = 29 * _hashCode + this.annTermiRinno.hashCode();
		}
		
		if (this.annElettRinno != null) {
			_hashCode = 29 * _hashCode + this.annElettRinno.hashCode();
		}
		
		if (this.complessTermico != null) {
			_hashCode = 29 * _hashCode + this.complessTermico.hashCode();
		}
		
		if (this.complessElettrico != null) {
			_hashCode = 29 * _hashCode + this.complessElettrico.hashCode();
		}
		
		if (this.uiServite != null) {
			_hashCode = 29 * _hashCode + this.uiServite.hashCode();
		}
		
		if (this.flgContRip != null) {
			_hashCode = 29 * _hashCode + this.flgContRip.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTConsumiEdificioPk
	 */
	public SiceeTConsumiEdificioPk createPk()
	{
		return new SiceeTConsumiEdificioPk(this.idCertificatore, this.progrCertificato, this.anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTConsumiEdificio: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", descTipoErog=" + this.descTipoErog );
		ret.append( ", fkTipoImpianto=" + this.fkTipoImpianto );
		ret.append( ", descTipoDistrib=" + this.descTipoDistrib );
		ret.append( ", descTipoReg=" + this.descTipoReg );
		ret.append( ", annTermiFossile=" + this.annTermiFossile );
		ret.append( ", annElettFossile=" + this.annElettFossile );
		ret.append( ", annTermiRinno=" + this.annTermiRinno );
		ret.append( ", annElettRinno=" + this.annElettRinno );
		ret.append( ", complessTermico=" + this.complessTermico );
		ret.append( ", complessElettrico=" + this.complessElettrico );
		ret.append( ", uiServite=" + this.uiServite );
		ret.append( ", flgContRip=" + this.flgContRip );
		return ret.toString();
	}

}
