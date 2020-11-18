/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTRuoliEdificio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2105087010040019119L;

	/** 
	 * This attribute maps to the column FK_TIPO_RUOLO in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected Integer fkTipoRuolo;

	/** 
	 * This attribute maps to the column NOME in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String nome;

	/** 
	 * This attribute maps to the column COGNOME in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String cognome;

	/** 
	 * This attribute maps to the column ID_INDIRIZZO in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected Integer idIndirizzo;

	/** 
	 * This attribute maps to the column DESC_INDIRIZZO in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String descIndirizzo;

	/** 
	 * This attribute maps to the column CAP in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String cap;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String idComune;

	/** 
	 * This attribute maps to the column DESC_COMUNE in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String descComune;

	/** 
	 * This attribute maps to the column TELEFONO in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String telefono;

	/** 
	 * This attribute maps to the column FAX in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String fax;

	/** 
	 * This attribute maps to the column CELL in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String cell;

	/** 
	 * This attribute maps to the column EMAIL in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String email;

	/** 
	 * This attribute maps to the column ID_REGIONE in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String idRegione;

	/** 
	 * This attribute maps to the column DESC_REGIONE in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String descRegione;

	/** 
	 * This attribute maps to the column ID_PROVINCIA in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String idProvincia;

	/** 
	 * This attribute maps to the column DESC_PROVINCIA in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String descProvincia;

	/** 
	 * This attribute maps to the column NUM_CIVICO in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String numCivico;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_RUOLI_EDIFICIO table.
	 */
	protected String anno;

	/**
	 * Method 'SiceeTRuoliEdificio'
	 * 
	 */
	public SiceeTRuoliEdificio()
	{
	}

	/**
	 * Method 'getFkTipoRuolo'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoRuolo()
	{
		return this.fkTipoRuolo;
	}

	/**
	 * Method 'setFkTipoRuolo'
	 * 
	 * @param fkTipoRuolo
	 */
	public void setFkTipoRuolo(Integer fkTipoRuolo)
	{
		this.fkTipoRuolo = fkTipoRuolo;
	}

	/**
	 * Method 'getNome'
	 * 
	 * @return String
	 */
	public String getNome()
	{
		return this.nome;
	}

	/**
	 * Method 'setNome'
	 * 
	 * @param nome
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * Method 'getCognome'
	 * 
	 * @return String
	 */
	public String getCognome()
	{
		return this.cognome;
	}

	/**
	 * Method 'setCognome'
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	/**
	 * Method 'getIdIndirizzo'
	 * 
	 * @return Integer
	 */
	public Integer getIdIndirizzo()
	{
		return this.idIndirizzo;
	}

	/**
	 * Method 'setIdIndirizzo'
	 * 
	 * @param idIndirizzo
	 */
	public void setIdIndirizzo(Integer idIndirizzo)
	{
		this.idIndirizzo = idIndirizzo;
	}

	/**
	 * Method 'getDescIndirizzo'
	 * 
	 * @return String
	 */
	public String getDescIndirizzo()
	{
		return this.descIndirizzo;
	}

	/**
	 * Method 'setDescIndirizzo'
	 * 
	 * @param descIndirizzo
	 */
	public void setDescIndirizzo(String descIndirizzo)
	{
		this.descIndirizzo = descIndirizzo;
	}

	/**
	 * Method 'getCap'
	 * 
	 * @return String
	 */
	public String getCap()
	{
		return this.cap;
	}

	/**
	 * Method 'setCap'
	 * 
	 * @param cap
	 */
	public void setCap(String cap)
	{
		this.cap = cap;
	}

	/**
	 * Method 'getIdComune'
	 * 
	 * @return String
	 */
	public String getIdComune()
	{
		return this.idComune;
	}

	/**
	 * Method 'setIdComune'
	 * 
	 * @param idComune
	 */
	public void setIdComune(String idComune)
	{
		this.idComune = idComune;
	}

	/**
	 * Method 'getDescComune'
	 * 
	 * @return String
	 */
	public String getDescComune()
	{
		return this.descComune;
	}

	/**
	 * Method 'setDescComune'
	 * 
	 * @param descComune
	 */
	public void setDescComune(String descComune)
	{
		this.descComune = descComune;
	}

	/**
	 * Method 'getTelefono'
	 * 
	 * @return String
	 */
	public String getTelefono()
	{
		return this.telefono;
	}

	/**
	 * Method 'setTelefono'
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	/**
	 * Method 'getFax'
	 * 
	 * @return String
	 */
	public String getFax()
	{
		return this.fax;
	}

	/**
	 * Method 'setFax'
	 * 
	 * @param fax
	 */
	public void setFax(String fax)
	{
		this.fax = fax;
	}

	/**
	 * Method 'getCell'
	 * 
	 * @return String
	 */
	public String getCell()
	{
		return this.cell;
	}

	/**
	 * Method 'setCell'
	 * 
	 * @param cell
	 */
	public void setCell(String cell)
	{
		this.cell = cell;
	}

	/**
	 * Method 'getEmail'
	 * 
	 * @return String
	 */
	public String getEmail()
	{
		return this.email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method 'getIdRegione'
	 * 
	 * @return String
	 */
	public String getIdRegione()
	{
		return this.idRegione;
	}

	/**
	 * Method 'setIdRegione'
	 * 
	 * @param idRegione
	 */
	public void setIdRegione(String idRegione)
	{
		this.idRegione = idRegione;
	}

	/**
	 * Method 'getDescRegione'
	 * 
	 * @return String
	 */
	public String getDescRegione()
	{
		return this.descRegione;
	}

	/**
	 * Method 'setDescRegione'
	 * 
	 * @param descRegione
	 */
	public void setDescRegione(String descRegione)
	{
		this.descRegione = descRegione;
	}

	/**
	 * Method 'getIdProvincia'
	 * 
	 * @return String
	 */
	public String getIdProvincia()
	{
		return this.idProvincia;
	}

	/**
	 * Method 'setIdProvincia'
	 * 
	 * @param idProvincia
	 */
	public void setIdProvincia(String idProvincia)
	{
		this.idProvincia = idProvincia;
	}

	/**
	 * Method 'getDescProvincia'
	 * 
	 * @return String
	 */
	public String getDescProvincia()
	{
		return this.descProvincia;
	}

	/**
	 * Method 'setDescProvincia'
	 * 
	 * @param descProvincia
	 */
	public void setDescProvincia(String descProvincia)
	{
		this.descProvincia = descProvincia;
	}

	/**
	 * Method 'getNumCivico'
	 * 
	 * @return String
	 */
	public String getNumCivico()
	{
		return this.numCivico;
	}

	/**
	 * Method 'setNumCivico'
	 * 
	 * @param numCivico
	 */
	public void setNumCivico(String numCivico)
	{
		this.numCivico = numCivico;
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
		
		if (!(_other instanceof SiceeTRuoliEdificio)) {
			return false;
		}
		
		final SiceeTRuoliEdificio _cast = (SiceeTRuoliEdificio) _other;
		if (this.fkTipoRuolo == null ? _cast.fkTipoRuolo != this.fkTipoRuolo : !this.fkTipoRuolo.equals( _cast.fkTipoRuolo )) {
			return false;
		}
		
		if (this.nome == null ? _cast.nome != this.nome : !this.nome.equals( _cast.nome )) {
			return false;
		}
		
		if (this.cognome == null ? _cast.cognome != this.cognome : !this.cognome.equals( _cast.cognome )) {
			return false;
		}
		
		if (this.idIndirizzo == null ? _cast.idIndirizzo != this.idIndirizzo : !this.idIndirizzo.equals( _cast.idIndirizzo )) {
			return false;
		}
		
		if (this.descIndirizzo == null ? _cast.descIndirizzo != this.descIndirizzo : !this.descIndirizzo.equals( _cast.descIndirizzo )) {
			return false;
		}
		
		if (this.cap == null ? _cast.cap != this.cap : !this.cap.equals( _cast.cap )) {
			return false;
		}
		
		if (this.idComune == null ? _cast.idComune != this.idComune : !this.idComune.equals( _cast.idComune )) {
			return false;
		}
		
		if (this.descComune == null ? _cast.descComune != this.descComune : !this.descComune.equals( _cast.descComune )) {
			return false;
		}
		
		if (this.telefono == null ? _cast.telefono != this.telefono : !this.telefono.equals( _cast.telefono )) {
			return false;
		}
		
		if (this.fax == null ? _cast.fax != this.fax : !this.fax.equals( _cast.fax )) {
			return false;
		}
		
		if (this.cell == null ? _cast.cell != this.cell : !this.cell.equals( _cast.cell )) {
			return false;
		}
		
		if (this.email == null ? _cast.email != this.email : !this.email.equals( _cast.email )) {
			return false;
		}
		
		if (this.idRegione == null ? _cast.idRegione != this.idRegione : !this.idRegione.equals( _cast.idRegione )) {
			return false;
		}
		
		if (this.descRegione == null ? _cast.descRegione != this.descRegione : !this.descRegione.equals( _cast.descRegione )) {
			return false;
		}
		
		if (this.idProvincia == null ? _cast.idProvincia != this.idProvincia : !this.idProvincia.equals( _cast.idProvincia )) {
			return false;
		}
		
		if (this.descProvincia == null ? _cast.descProvincia != this.descProvincia : !this.descProvincia.equals( _cast.descProvincia )) {
			return false;
		}
		
		if (this.numCivico == null ? _cast.numCivico != this.numCivico : !this.numCivico.equals( _cast.numCivico )) {
			return false;
		}
		
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
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
		if (this.fkTipoRuolo != null) {
			_hashCode = 29 * _hashCode + this.fkTipoRuolo.hashCode();
		}
		
		if (this.nome != null) {
			_hashCode = 29 * _hashCode + this.nome.hashCode();
		}
		
		if (this.cognome != null) {
			_hashCode = 29 * _hashCode + this.cognome.hashCode();
		}
		
		if (this.idIndirizzo != null) {
			_hashCode = 29 * _hashCode + this.idIndirizzo.hashCode();
		}
		
		if (this.descIndirizzo != null) {
			_hashCode = 29 * _hashCode + this.descIndirizzo.hashCode();
		}
		
		if (this.cap != null) {
			_hashCode = 29 * _hashCode + this.cap.hashCode();
		}
		
		if (this.idComune != null) {
			_hashCode = 29 * _hashCode + this.idComune.hashCode();
		}
		
		if (this.descComune != null) {
			_hashCode = 29 * _hashCode + this.descComune.hashCode();
		}
		
		if (this.telefono != null) {
			_hashCode = 29 * _hashCode + this.telefono.hashCode();
		}
		
		if (this.fax != null) {
			_hashCode = 29 * _hashCode + this.fax.hashCode();
		}
		
		if (this.cell != null) {
			_hashCode = 29 * _hashCode + this.cell.hashCode();
		}
		
		if (this.email != null) {
			_hashCode = 29 * _hashCode + this.email.hashCode();
		}
		
		if (this.idRegione != null) {
			_hashCode = 29 * _hashCode + this.idRegione.hashCode();
		}
		
		if (this.descRegione != null) {
			_hashCode = 29 * _hashCode + this.descRegione.hashCode();
		}
		
		if (this.idProvincia != null) {
			_hashCode = 29 * _hashCode + this.idProvincia.hashCode();
		}
		
		if (this.descProvincia != null) {
			_hashCode = 29 * _hashCode + this.descProvincia.hashCode();
		}
		
		if (this.numCivico != null) {
			_hashCode = 29 * _hashCode + this.numCivico.hashCode();
		}
		
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTRuoliEdificioPk
	 */
	public SiceeTRuoliEdificioPk createPk()
	{
		return new SiceeTRuoliEdificioPk(this.idCertificatore, this.progrCertificato, this.anno, this.fkTipoRuolo);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRuoliEdificio: " );
		ret.append( "fkTipoRuolo=" + this.fkTipoRuolo );
		ret.append( ", nome=" + this.nome );
		ret.append( ", cognome=" + this.cognome );
		ret.append( ", idIndirizzo=" + this.idIndirizzo );
		ret.append( ", descIndirizzo=" + this.descIndirizzo );
		ret.append( ", cap=" + this.cap );
		ret.append( ", idComune=" + this.idComune );
		ret.append( ", descComune=" + this.descComune );
		ret.append( ", telefono=" + this.telefono );
		ret.append( ", fax=" + this.fax );
		ret.append( ", cell=" + this.cell );
		ret.append( ", email=" + this.email );
		ret.append( ", idRegione=" + this.idRegione );
		ret.append( ", descRegione=" + this.descRegione );
		ret.append( ", idProvincia=" + this.idProvincia );
		ret.append( ", descProvincia=" + this.descProvincia );
		ret.append( ", numCivico=" + this.numCivico );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		return ret.toString();
	}

}
