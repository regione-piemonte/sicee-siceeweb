/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeTEnergiaSoprIngr implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 75691977060916280L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_DATI in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Integer fkDati;

	/** 
	 * This attribute maps to the column TECNO_RINNO in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected String tecnoRinno;

	/** 
	 * This attribute maps to the column ANNO_INSTALL in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Integer annoInstall;

	/** 
	 * This attribute maps to the column EN_TERMICA_PROD in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Double enTermicaProd;

	/** 
	 * This attribute maps to the column EN_ELETT_PROD in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Double enElettProd;

	/** 
	 * This attribute maps to the column AUTOCONS_TERMICO in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Double autoconsTermico;

	/** 
	 * This attribute maps to the column AUTOCONS_ELETT in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Double autoconsElett;

	/** 
	 * This attribute maps to the column DT_SOPRALLUOGO in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Date dtSopralluogo;

	/** 
	 * This attribute maps to the column NOTE_SOPRALL in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected String noteSoprall;

	/** 
	 * This attribute maps to the column PERC_FONTI_RINNOV in the SICEE_T_ENERGIA_SOPR_INGR table.
	 */
	protected Double percFontiRinnov;

	/**
	 * Method 'SiceeTEnergiaSoprIngr'
	 * 
	 */
	public SiceeTEnergiaSoprIngr()
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
	 * Method 'getFkDati'
	 * 
	 * @return Integer
	 */
	public Integer getFkDati()
	{
		return this.fkDati;
	}

	/**
	 * Method 'setFkDati'
	 * 
	 * @param fkDati
	 */
	public void setFkDati(Integer fkDati)
	{
		this.fkDati = fkDati;
	}

	/**
	 * Method 'getTecnoRinno'
	 * 
	 * @return String
	 */
	public String getTecnoRinno()
	{
		return this.tecnoRinno;
	}

	/**
	 * Method 'setTecnoRinno'
	 * 
	 * @param tecnoRinno
	 */
	public void setTecnoRinno(String tecnoRinno)
	{
		this.tecnoRinno = tecnoRinno;
	}

	/**
	 * Method 'getAnnoInstall'
	 * 
	 * @return Integer
	 */
	public Integer getAnnoInstall()
	{
		return this.annoInstall;
	}

	/**
	 * Method 'setAnnoInstall'
	 * 
	 * @param annoInstall
	 */
	public void setAnnoInstall(Integer annoInstall)
	{
		this.annoInstall = annoInstall;
	}

	/**
	 * Method 'getEnTermicaProd'
	 * 
	 * @return Double
	 */
	public Double getEnTermicaProd()
	{
		return this.enTermicaProd;
	}

	/**
	 * Method 'setEnTermicaProd'
	 * 
	 * @param enTermicaProd
	 */
	public void setEnTermicaProd(Double enTermicaProd)
	{
		this.enTermicaProd = enTermicaProd;
	}

	/**
	 * Method 'getEnElettProd'
	 * 
	 * @return Double
	 */
	public Double getEnElettProd()
	{
		return this.enElettProd;
	}

	/**
	 * Method 'setEnElettProd'
	 * 
	 * @param enElettProd
	 */
	public void setEnElettProd(Double enElettProd)
	{
		this.enElettProd = enElettProd;
	}

	/**
	 * Method 'getAutoconsTermico'
	 * 
	 * @return Double
	 */
	public Double getAutoconsTermico()
	{
		return this.autoconsTermico;
	}

	/**
	 * Method 'setAutoconsTermico'
	 * 
	 * @param autoconsTermico
	 */
	public void setAutoconsTermico(Double autoconsTermico)
	{
		this.autoconsTermico = autoconsTermico;
	}

	/**
	 * Method 'getAutoconsElett'
	 * 
	 * @return Double
	 */
	public Double getAutoconsElett()
	{
		return this.autoconsElett;
	}

	/**
	 * Method 'setAutoconsElett'
	 * 
	 * @param autoconsElett
	 */
	public void setAutoconsElett(Double autoconsElett)
	{
		this.autoconsElett = autoconsElett;
	}

	/**
	 * Method 'getDtSopralluogo'
	 * 
	 * @return Date
	 */
	public Date getDtSopralluogo()
	{
		return this.dtSopralluogo;
	}

	/**
	 * Method 'setDtSopralluogo'
	 * 
	 * @param dtSopralluogo
	 */
	public void setDtSopralluogo(Date dtSopralluogo)
	{
		this.dtSopralluogo = dtSopralluogo;
	}

	/**
	 * Method 'getNoteSoprall'
	 * 
	 * @return String
	 */
	public String getNoteSoprall()
	{
		return this.noteSoprall;
	}

	/**
	 * Method 'setNoteSoprall'
	 * 
	 * @param noteSoprall
	 */
	public void setNoteSoprall(String noteSoprall)
	{
		this.noteSoprall = noteSoprall;
	}

	/**
	 * Method 'getPercFontiRinnov'
	 * 
	 * @return Double
	 */
	public Double getPercFontiRinnov()
	{
		return this.percFontiRinnov;
	}

	/**
	 * Method 'setPercFontiRinnov'
	 * 
	 * @param percFontiRinnov
	 */
	public void setPercFontiRinnov(Double percFontiRinnov)
	{
		this.percFontiRinnov = percFontiRinnov;
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
		
		if (!(_other instanceof SiceeTEnergiaSoprIngr)) {
			return false;
		}
		
		final SiceeTEnergiaSoprIngr _cast = (SiceeTEnergiaSoprIngr) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.fkDati == null ? _cast.fkDati != this.fkDati : !this.fkDati.equals( _cast.fkDati )) {
			return false;
		}
		
		if (this.tecnoRinno == null ? _cast.tecnoRinno != this.tecnoRinno : !this.tecnoRinno.equals( _cast.tecnoRinno )) {
			return false;
		}
		
		if (this.annoInstall == null ? _cast.annoInstall != this.annoInstall : !this.annoInstall.equals( _cast.annoInstall )) {
			return false;
		}
		
		if (this.enTermicaProd == null ? _cast.enTermicaProd != this.enTermicaProd : !this.enTermicaProd.equals( _cast.enTermicaProd )) {
			return false;
		}
		
		if (this.enElettProd == null ? _cast.enElettProd != this.enElettProd : !this.enElettProd.equals( _cast.enElettProd )) {
			return false;
		}
		
		if (this.autoconsTermico == null ? _cast.autoconsTermico != this.autoconsTermico : !this.autoconsTermico.equals( _cast.autoconsTermico )) {
			return false;
		}
		
		if (this.autoconsElett == null ? _cast.autoconsElett != this.autoconsElett : !this.autoconsElett.equals( _cast.autoconsElett )) {
			return false;
		}
		
		if (this.dtSopralluogo == null ? _cast.dtSopralluogo != this.dtSopralluogo : !this.dtSopralluogo.equals( _cast.dtSopralluogo )) {
			return false;
		}
		
		if (this.noteSoprall == null ? _cast.noteSoprall != this.noteSoprall : !this.noteSoprall.equals( _cast.noteSoprall )) {
			return false;
		}
		
		if (this.percFontiRinnov == null ? _cast.percFontiRinnov != this.percFontiRinnov : !this.percFontiRinnov.equals( _cast.percFontiRinnov )) {
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
		
		if (this.fkDati != null) {
			_hashCode = 29 * _hashCode + this.fkDati.hashCode();
		}
		
		if (this.tecnoRinno != null) {
			_hashCode = 29 * _hashCode + this.tecnoRinno.hashCode();
		}
		
		if (this.annoInstall != null) {
			_hashCode = 29 * _hashCode + this.annoInstall.hashCode();
		}
		
		if (this.enTermicaProd != null) {
			_hashCode = 29 * _hashCode + this.enTermicaProd.hashCode();
		}
		
		if (this.enElettProd != null) {
			_hashCode = 29 * _hashCode + this.enElettProd.hashCode();
		}
		
		if (this.autoconsTermico != null) {
			_hashCode = 29 * _hashCode + this.autoconsTermico.hashCode();
		}
		
		if (this.autoconsElett != null) {
			_hashCode = 29 * _hashCode + this.autoconsElett.hashCode();
		}
		
		if (this.dtSopralluogo != null) {
			_hashCode = 29 * _hashCode + this.dtSopralluogo.hashCode();
		}
		
		if (this.noteSoprall != null) {
			_hashCode = 29 * _hashCode + this.noteSoprall.hashCode();
		}
		
		if (this.percFontiRinnov != null) {
			_hashCode = 29 * _hashCode + this.percFontiRinnov.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTEnergiaSoprIngrPk
	 */
	public SiceeTEnergiaSoprIngrPk createPk()
	{
		return new SiceeTEnergiaSoprIngrPk(this.idCertificatore, this.progrCertificato, this.anno);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTEnergiaSoprIngr: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", fkDati=" + this.fkDati );
		ret.append( ", tecnoRinno=" + this.tecnoRinno );
		ret.append( ", annoInstall=" + this.annoInstall );
		ret.append( ", enTermicaProd=" + this.enTermicaProd );
		ret.append( ", enElettProd=" + this.enElettProd );
		ret.append( ", autoconsTermico=" + this.autoconsTermico );
		ret.append( ", autoconsElett=" + this.autoconsElett );
		ret.append( ", dtSopralluogo=" + this.dtSopralluogo );
		ret.append( ", noteSoprall=" + this.noteSoprall );
		ret.append( ", percFontiRinnov=" + this.percFontiRinnov );
		return ret.toString();
	}

}
