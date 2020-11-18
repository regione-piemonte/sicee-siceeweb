/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTSostituzione implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8684313983147594588L;

	/** 
	 * This attribute maps to the column ID_SOSTITUZIONE in the SICEE_T_SOSTITUZIONE table.
	 */
	protected Integer idSostituzione;

	/** 
	 * This attribute maps to the column PROGR_SOSTITUZIONE in the SICEE_T_SOSTITUZIONE table.
	 */
	protected Integer progrSostituzione;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE_OLD in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String idCertificatoreOld;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO_OLD in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String progrCertificatoOld;

	/** 
	 * This attribute maps to the column ANNO_OLD in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String annoOld;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE_NEW in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String idCertificatoreNew;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO_NEW in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String progrCertificatoNew;

	/** 
	 * This attribute maps to the column ANNO_NEW in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String annoNew;

	/** 
	 * This attribute maps to the column FLG_INVIO_MAIL in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String flgInvioMail;

	/** 
	 * This attribute maps to the column EMAIL in the SICEE_T_SOSTITUZIONE table.
	 */
	protected String email;

	/**
	 * Method 'SiceeTSostituzione'
	 * 
	 */
	public SiceeTSostituzione()
	{
	}

	/**
	 * Method 'getIdSostituzione'
	 * 
	 * @return Long
	 */
	public Integer getIdSostituzione()
	{
		return this.idSostituzione;
	}

	/**
	 * Method 'setIdSostituzione'
	 * 
	 * @param idSostituzione
	 */
	public void setIdSostituzione(Integer idSostituzione)
	{
		this.idSostituzione = idSostituzione;
	}

	/**
	 * Method 'getProgrSostituzione'
	 * 
	 * @return Long
	 */
	public Integer getProgrSostituzione()
	{
		return this.progrSostituzione;
	}

	/**
	 * Method 'setProgrSostituzione'
	 * 
	 * @param progrSostituzione
	 */
	public void setProgrSostituzione(Integer progrSostituzione)
	{
		this.progrSostituzione = progrSostituzione;
	}

	/**
	 * Method 'getIdCertificatoreOld'
	 * 
	 * @return String
	 */
	public String getIdCertificatoreOld()
	{
		return this.idCertificatoreOld;
	}

	/**
	 * Method 'setIdCertificatoreOld'
	 * 
	 * @param idCertificatoreOld
	 */
	public void setIdCertificatoreOld(String idCertificatoreOld)
	{
		this.idCertificatoreOld = idCertificatoreOld;
	}

	/**
	 * Method 'getProgrCertificatoOld'
	 * 
	 * @return String
	 */
	public String getProgrCertificatoOld()
	{
		return this.progrCertificatoOld;
	}

	/**
	 * Method 'setProgrCertificatoOld'
	 * 
	 * @param progrCertificatoOld
	 */
	public void setProgrCertificatoOld(String progrCertificatoOld)
	{
		this.progrCertificatoOld = progrCertificatoOld;
	}

	/**
	 * Method 'getAnnoOld'
	 * 
	 * @return String
	 */
	public String getAnnoOld()
	{
		return this.annoOld;
	}

	/**
	 * Method 'setAnnoOld'
	 * 
	 * @param annoOld
	 */
	public void setAnnoOld(String annoOld)
	{
		this.annoOld = annoOld;
	}

	/**
	 * Method 'getIdCertificatoreNew'
	 * 
	 * @return String
	 */
	public String getIdCertificatoreNew()
	{
		return this.idCertificatoreNew;
	}

	/**
	 * Method 'setIdCertificatoreNew'
	 * 
	 * @param idCertificatoreNew
	 */
	public void setIdCertificatoreNew(String idCertificatoreNew)
	{
		this.idCertificatoreNew = idCertificatoreNew;
	}

	/**
	 * Method 'getProgrCertificatoNew'
	 * 
	 * @return String
	 */
	public String getProgrCertificatoNew()
	{
		return this.progrCertificatoNew;
	}

	/**
	 * Method 'setProgrCertificatoNew'
	 * 
	 * @param progrCertificatoNew
	 */
	public void setProgrCertificatoNew(String progrCertificatoNew)
	{
		this.progrCertificatoNew = progrCertificatoNew;
	}

	/**
	 * Method 'getAnnoNew'
	 * 
	 * @return String
	 */
	public String getAnnoNew()
	{
		return this.annoNew;
	}

	/**
	 * Method 'setAnnoNew'
	 * 
	 * @param annoNew
	 */
	public void setAnnoNew(String annoNew)
	{
		this.annoNew = annoNew;
	}

	/**
	 * Method 'getFlgInvioMail'
	 * 
	 * @return String
	 */
	public String getFlgInvioMail()
	{
		return this.flgInvioMail;
	}

	/**
	 * Method 'setFlgInvioMail'
	 * 
	 * @param flgInvioMail
	 */
	public void setFlgInvioMail(String flgInvioMail)
	{
		this.flgInvioMail = flgInvioMail;
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
		
		if (!(_other instanceof SiceeTSostituzione)) {
			return false;
		}
		
		final SiceeTSostituzione _cast = (SiceeTSostituzione) _other;
		if (this.idSostituzione == null ? _cast.idSostituzione != this.idSostituzione : !this.idSostituzione.equals( _cast.idSostituzione )) {
			return false;
		}
		
		if (this.progrSostituzione == null ? _cast.progrSostituzione != this.progrSostituzione : !this.progrSostituzione.equals( _cast.progrSostituzione )) {
			return false;
		}
		
		if (this.idCertificatoreOld == null ? _cast.idCertificatoreOld != this.idCertificatoreOld : !this.idCertificatoreOld.equals( _cast.idCertificatoreOld )) {
			return false;
		}
		
		if (this.progrCertificatoOld == null ? _cast.progrCertificatoOld != this.progrCertificatoOld : !this.progrCertificatoOld.equals( _cast.progrCertificatoOld )) {
			return false;
		}
		
		if (this.annoOld == null ? _cast.annoOld != this.annoOld : !this.annoOld.equals( _cast.annoOld )) {
			return false;
		}
		
		if (this.idCertificatoreNew == null ? _cast.idCertificatoreNew != this.idCertificatoreNew : !this.idCertificatoreNew.equals( _cast.idCertificatoreNew )) {
			return false;
		}
		
		if (this.progrCertificatoNew == null ? _cast.progrCertificatoNew != this.progrCertificatoNew : !this.progrCertificatoNew.equals( _cast.progrCertificatoNew )) {
			return false;
		}
		
		if (this.annoNew == null ? _cast.annoNew != this.annoNew : !this.annoNew.equals( _cast.annoNew )) {
			return false;
		}
		
		if (this.flgInvioMail == null ? _cast.flgInvioMail != this.flgInvioMail : !this.flgInvioMail.equals( _cast.flgInvioMail )) {
			return false;
		}
		
		if (this.email == null ? _cast.email != this.email : !this.email.equals( _cast.email )) {
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
		if (this.idSostituzione != null) {
			_hashCode = 29 * _hashCode + this.idSostituzione.hashCode();
		}
		
		if (this.progrSostituzione != null) {
			_hashCode = 29 * _hashCode + this.progrSostituzione.hashCode();
		}
		
		if (this.idCertificatoreOld != null) {
			_hashCode = 29 * _hashCode + this.idCertificatoreOld.hashCode();
		}
		
		if (this.progrCertificatoOld != null) {
			_hashCode = 29 * _hashCode + this.progrCertificatoOld.hashCode();
		}
		
		if (this.annoOld != null) {
			_hashCode = 29 * _hashCode + this.annoOld.hashCode();
		}
		
		if (this.idCertificatoreNew != null) {
			_hashCode = 29 * _hashCode + this.idCertificatoreNew.hashCode();
		}
		
		if (this.progrCertificatoNew != null) {
			_hashCode = 29 * _hashCode + this.progrCertificatoNew.hashCode();
		}
		
		if (this.annoNew != null) {
			_hashCode = 29 * _hashCode + this.annoNew.hashCode();
		}
		
		if (this.flgInvioMail != null) {
			_hashCode = 29 * _hashCode + this.flgInvioMail.hashCode();
		}
		
		if (this.email != null) {
			_hashCode = 29 * _hashCode + this.email.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTSostituzionePk
	 */
	public SiceeTSostituzionePk createPk()
	{
		return new SiceeTSostituzionePk(this.idSostituzione, this.progrSostituzione);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTSostituzione: " );
		ret.append( "idSostituzione=" + this.idSostituzione );
		ret.append( ", progrSostituzione=" + this.progrSostituzione );
		ret.append( ", idCertificatoreOld=" + this.idCertificatoreOld );
		ret.append( ", progrCertificatoOld=" + this.progrCertificatoOld );
		ret.append( ", annoOld=" + this.annoOld );
		ret.append( ", idCertificatoreNew=" + this.idCertificatoreNew );
		ret.append( ", progrCertificatoNew=" + this.progrCertificatoNew );
		ret.append( ", annoNew=" + this.annoNew );
		ret.append( ", flgInvioMail=" + this.flgInvioMail );
		ret.append( ", email=" + this.email );
		return ret.toString();
	}

}
