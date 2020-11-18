/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDMappingXml implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3667215514006523421L;

	/** 
	 * This attribute maps to the column CAMPO_XML in the SICEE_D_MAPPING_XML table.
	 */
	protected String campoXml;

	/** 
	 * This attribute maps to the column CAMPO_WEB in the SICEE_D_MAPPING_XML table.
	 */
	protected String campoWeb;

	/**
	 * Method 'SiceeDMappingXml'
	 * 
	 */
	public SiceeDMappingXml()
	{
	}

	/**
	 * Method 'getCampoXml'
	 * 
	 * @return String
	 */
	public String getCampoXml()
	{
		return this.campoXml;
	}

	/**
	 * Method 'setCampoXml'
	 * 
	 * @param campoXml
	 */
	public void setCampoXml(String campoXml)
	{
		this.campoXml = campoXml;
	}

	/**
	 * Method 'getCampoWeb'
	 * 
	 * @return String
	 */
	public String getCampoWeb()
	{
		return this.campoWeb;
	}

	/**
	 * Method 'setCampoWeb'
	 * 
	 * @param campoWeb
	 */
	public void setCampoWeb(String campoWeb)
	{
		this.campoWeb = campoWeb;
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
		
		if (!(_other instanceof SiceeDMappingXml)) {
			return false;
		}
		
		final SiceeDMappingXml _cast = (SiceeDMappingXml) _other;
		if (this.campoXml == null ? _cast.campoXml != this.campoXml : !this.campoXml.equals( _cast.campoXml )) {
			return false;
		}
		
		if (this.campoWeb == null ? _cast.campoWeb != this.campoWeb : !this.campoWeb.equals( _cast.campoWeb )) {
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
		if (this.campoXml != null) {
			_hashCode = 29 * _hashCode + this.campoXml.hashCode();
		}
		
		if (this.campoWeb != null) {
			_hashCode = 29 * _hashCode + this.campoWeb.hashCode();
		}
		
		return _hashCode;
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDMappingXml: " );
		ret.append( "campoXml=" + this.campoXml );
		ret.append( ", campoWeb=" + this.campoWeb );
		return ret.toString();
	}

}
