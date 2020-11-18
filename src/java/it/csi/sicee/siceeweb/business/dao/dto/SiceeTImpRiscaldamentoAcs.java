/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTImpRiscaldamentoAcs implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6170105499223338818L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FLG_BOLLINO in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected String flgBollino;

	/** 
	 * This attribute maps to the column FK_CLASSE_EFF_RISC in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Integer fkClasseEffRisc;

	/** 
	 * This attribute maps to the column CODICE_IMPIANTO in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected String codiceImpianto;

	/** 
	 * This attribute maps to the column FK_CLASSE_EFF_ACS in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Integer fkClasseEffAcs;

	/** 
	 * This attribute maps to the column FK_COMBUSTIBILE_RISC in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Integer fkCombustibileRisc;

	/** 
	 * This attribute maps to the column NUMERO_BOLLINO in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected String numeroBollino;

	/** 
	 * This attribute maps to the column GEN_ANNO_RISC in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Integer genAnnoRisc;

	/** 
	 * This attribute maps to the column FK_COMBUSTIBILE_ACS in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Integer fkCombustibileAcs;

	/** 
	 * This attribute maps to the column POT_RISCALDAMENTO in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Double potRiscaldamento;

	/** 
	 * This attribute maps to the column GEN_ANNO_ACS in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Integer genAnnoAcs;

	/** 
	 * This attribute maps to the column POT_ACS in the SICEE_T_IMP_RISCALDAMENTO_ACS table.
	 */
	protected Double potAcs;

	/**
	 * Method 'SiceeTImpRiscaldamentoAcs'
	 * 
	 */
	public SiceeTImpRiscaldamentoAcs()
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
	 * Method 'getFlgBollino'
	 * 
	 * @return String
	 */
	public String getFlgBollino()
	{
		return this.flgBollino;
	}

	/**
	 * Method 'setFlgBollino'
	 * 
	 * @param flgBollino
	 */
	public void setFlgBollino(String flgBollino)
	{
		this.flgBollino = flgBollino;
	}

	/**
	 * Method 'getFkClasseEffRisc'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasseEffRisc()
	{
		return this.fkClasseEffRisc;
	}

	/**
	 * Method 'setFkClasseEffRisc'
	 * 
	 * @param fkClasseEffRisc
	 */
	public void setFkClasseEffRisc(Integer fkClasseEffRisc)
	{
		this.fkClasseEffRisc = fkClasseEffRisc;
	}

	/**
	 * Method 'getCodiceImpianto'
	 * 
	 * @return String
	 */
	public String getCodiceImpianto()
	{
		return this.codiceImpianto;
	}

	/**
	 * Method 'setCodiceImpianto'
	 * 
	 * @param codiceImpianto
	 */
	public void setCodiceImpianto(String codiceImpianto)
	{
		this.codiceImpianto = codiceImpianto;
	}

	/**
	 * Method 'getFkClasseEffAcs'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasseEffAcs()
	{
		return this.fkClasseEffAcs;
	}

	/**
	 * Method 'setFkClasseEffAcs'
	 * 
	 * @param fkClasseEffAcs
	 */
	public void setFkClasseEffAcs(Integer fkClasseEffAcs)
	{
		this.fkClasseEffAcs = fkClasseEffAcs;
	}

	/**
	 * Method 'getFkCombustibileRisc'
	 * 
	 * @return Integer
	 */
	public Integer getFkCombustibileRisc()
	{
		return this.fkCombustibileRisc;
	}

	/**
	 * Method 'setFkCombustibileRisc'
	 * 
	 * @param fkCombustibileRisc
	 */
	public void setFkCombustibileRisc(Integer fkCombustibileRisc)
	{
		this.fkCombustibileRisc = fkCombustibileRisc;
	}

	/**
	 * Method 'getNumeroBollino'
	 * 
	 * @return String
	 */
	public String getNumeroBollino()
	{
		return this.numeroBollino;
	}

	/**
	 * Method 'setNumeroBollino'
	 * 
	 * @param numeroBollino
	 */
	public void setNumeroBollino(String numeroBollino)
	{
		this.numeroBollino = numeroBollino;
	}

	/**
	 * Method 'getGenAnnoRisc'
	 * 
	 * @return Integer
	 */
	public Integer getGenAnnoRisc()
	{
		return this.genAnnoRisc;
	}

	/**
	 * Method 'setGenAnnoRisc'
	 * 
	 * @param genAnnoRisc
	 */
	public void setGenAnnoRisc(Integer genAnnoRisc)
	{
		this.genAnnoRisc = genAnnoRisc;
	}

	/**
	 * Method 'getFkCombustibileAcs'
	 * 
	 * @return Integer
	 */
	public Integer getFkCombustibileAcs()
	{
		return this.fkCombustibileAcs;
	}

	/**
	 * Method 'setFkCombustibileAcs'
	 * 
	 * @param fkCombustibileAcs
	 */
	public void setFkCombustibileAcs(Integer fkCombustibileAcs)
	{
		this.fkCombustibileAcs = fkCombustibileAcs;
	}

	/**
	 * Method 'getPotRiscaldamento'
	 * 
	 * @return Double
	 */
	public Double getPotRiscaldamento()
	{
		return this.potRiscaldamento;
	}

	/**
	 * Method 'setPotRiscaldamento'
	 * 
	 * @param potRiscaldamento
	 */
	public void setPotRiscaldamento(Double potRiscaldamento)
	{
		this.potRiscaldamento = potRiscaldamento;
	}

	/**
	 * Method 'getGenAnnoAcs'
	 * 
	 * @return Integer
	 */
	public Integer getGenAnnoAcs()
	{
		return this.genAnnoAcs;
	}

	/**
	 * Method 'setGenAnnoAcs'
	 * 
	 * @param genAnnoAcs
	 */
	public void setGenAnnoAcs(Integer genAnnoAcs)
	{
		this.genAnnoAcs = genAnnoAcs;
	}

	/**
	 * Method 'getPotAcs'
	 * 
	 * @return Double
	 */
	public Double getPotAcs()
	{
		return this.potAcs;
	}

	/**
	 * Method 'setPotAcs'
	 * 
	 * @param potAcs
	 */
	public void setPotAcs(Double potAcs)
	{
		this.potAcs = potAcs;
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
		
		if (!(_other instanceof SiceeTImpRiscaldamentoAcs)) {
			return false;
		}
		
		final SiceeTImpRiscaldamentoAcs _cast = (SiceeTImpRiscaldamentoAcs) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.flgBollino == null ? _cast.flgBollino != this.flgBollino : !this.flgBollino.equals( _cast.flgBollino )) {
			return false;
		}
		
		if (this.fkClasseEffRisc == null ? _cast.fkClasseEffRisc != this.fkClasseEffRisc : !this.fkClasseEffRisc.equals( _cast.fkClasseEffRisc )) {
			return false;
		}
		
		if (this.codiceImpianto == null ? _cast.codiceImpianto != this.codiceImpianto : !this.codiceImpianto.equals( _cast.codiceImpianto )) {
			return false;
		}
		
		if (this.fkClasseEffAcs == null ? _cast.fkClasseEffAcs != this.fkClasseEffAcs : !this.fkClasseEffAcs.equals( _cast.fkClasseEffAcs )) {
			return false;
		}
		
		if (this.fkCombustibileRisc == null ? _cast.fkCombustibileRisc != this.fkCombustibileRisc : !this.fkCombustibileRisc.equals( _cast.fkCombustibileRisc )) {
			return false;
		}
		
		if (this.numeroBollino == null ? _cast.numeroBollino != this.numeroBollino : !this.numeroBollino.equals( _cast.numeroBollino )) {
			return false;
		}
		
		if (this.genAnnoRisc == null ? _cast.genAnnoRisc != this.genAnnoRisc : !this.genAnnoRisc.equals( _cast.genAnnoRisc )) {
			return false;
		}
		
		if (this.fkCombustibileAcs == null ? _cast.fkCombustibileAcs != this.fkCombustibileAcs : !this.fkCombustibileAcs.equals( _cast.fkCombustibileAcs )) {
			return false;
		}
		
		if (this.potRiscaldamento == null ? _cast.potRiscaldamento != this.potRiscaldamento : !this.potRiscaldamento.equals( _cast.potRiscaldamento )) {
			return false;
		}
		
		if (this.genAnnoAcs == null ? _cast.genAnnoAcs != this.genAnnoAcs : !this.genAnnoAcs.equals( _cast.genAnnoAcs )) {
			return false;
		}
		
		if (this.potAcs == null ? _cast.potAcs != this.potAcs : !this.potAcs.equals( _cast.potAcs )) {
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
		
		if (this.flgBollino != null) {
			_hashCode = 29 * _hashCode + this.flgBollino.hashCode();
		}
		
		if (this.fkClasseEffRisc != null) {
			_hashCode = 29 * _hashCode + this.fkClasseEffRisc.hashCode();
		}
		
		if (this.codiceImpianto != null) {
			_hashCode = 29 * _hashCode + this.codiceImpianto.hashCode();
		}
		
		if (this.fkClasseEffAcs != null) {
			_hashCode = 29 * _hashCode + this.fkClasseEffAcs.hashCode();
		}
		
		if (this.fkCombustibileRisc != null) {
			_hashCode = 29 * _hashCode + this.fkCombustibileRisc.hashCode();
		}
		
		if (this.numeroBollino != null) {
			_hashCode = 29 * _hashCode + this.numeroBollino.hashCode();
		}
		
		if (this.genAnnoRisc != null) {
			_hashCode = 29 * _hashCode + this.genAnnoRisc.hashCode();
		}
		
		if (this.fkCombustibileAcs != null) {
			_hashCode = 29 * _hashCode + this.fkCombustibileAcs.hashCode();
		}
		
		if (this.potRiscaldamento != null) {
			_hashCode = 29 * _hashCode + this.potRiscaldamento.hashCode();
		}
		
		if (this.genAnnoAcs != null) {
			_hashCode = 29 * _hashCode + this.genAnnoAcs.hashCode();
		}
		
		if (this.potAcs != null) {
			_hashCode = 29 * _hashCode + this.potAcs.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTImpRiscaldamentoAcsPk
	 */
	public SiceeTImpRiscaldamentoAcsPk createPk()
	{
		return new SiceeTImpRiscaldamentoAcsPk(this.idCertificatore, this.progrCertificato, this.anno);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTImpRiscaldamentoAcs: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", flgBollino=" + this.flgBollino );
		ret.append( ", fkClasseEffRisc=" + this.fkClasseEffRisc );
		ret.append( ", codiceImpianto=" + this.codiceImpianto );
		ret.append( ", fkClasseEffAcs=" + this.fkClasseEffAcs );
		ret.append( ", fkCombustibileRisc=" + this.fkCombustibileRisc );
		ret.append( ", numeroBollino=" + this.numeroBollino );
		ret.append( ", genAnnoRisc=" + this.genAnnoRisc );
		ret.append( ", fkCombustibileAcs=" + this.fkCombustibileAcs );
		ret.append( ", potRiscaldamento=" + this.potRiscaldamento );
		ret.append( ", genAnnoAcs=" + this.genAnnoAcs );
		ret.append( ", potAcs=" + this.potAcs );
		return ret.toString();
	}

}
