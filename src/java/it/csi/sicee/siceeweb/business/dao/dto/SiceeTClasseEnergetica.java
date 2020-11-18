/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTClasseEnergetica implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3441662481939140114L;

	/** 
	 * This attribute maps to the column IND_RISC_EPI in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double indRiscEpi;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column IND_COND_EST in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double indCondEst;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column IND_ILLUM in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double indIllum;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column IND_GLOB_EPLORDO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double indGlobEplordo;

	/** 
	 * This attribute maps to the column FK_CLASSE in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Integer fkClasse;

	/** 
	 * This attribute maps to the column REND_GENER in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double rendGener;

	/** 
	 * This attribute maps to the column REND_REGOL in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double rendRegol;

	/** 
	 * This attribute maps to the column SERVIZI_ENERGETICI in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected String serviziEnergetici;

	/** 
	 * This attribute maps to the column REND_EMISS in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double rendEmiss;

	/** 
	 * This attribute maps to the column REND_DISTRIB in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double rendDistrib;

	/** 
	 * This attribute maps to the column REND_IMP_ETAG in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double rendImpEtag;

	/** 
	 * This attribute maps to the column DOM_RISC_QHTO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double domRiscQhto;

	/** 
	 * This attribute maps to the column LIMITE_REG_QHTO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double limiteRegQhto;

	/** 
	 * This attribute maps to the column IND_RISC_EPITO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double indRiscEpito;

	/** 
	 * This attribute maps to the column DOM_ACS_QHWTO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double domAcsQhwto;

	/** 
	 * This attribute maps to the column EN_ACS_RINNO_TO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double enAcsRinnoTo;

	/** 
	 * This attribute maps to the column REND_ACS_ETAG_ACSTO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double rendAcsEtagAcsto;

	/** 
	 * This attribute maps to the column FABB_ACS_TO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double fabbAcsTo;

	/** 
	 * This attribute maps to the column IND_GLOB_EPLORDO_TO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double indGlobEplordoTo;

	/** 
	 * This attribute maps to the column ETAG_CONV in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double etagConv;

	/** 
	 * This attribute maps to the column IND_GLOB_LIMITE_TO in the SICEE_T_CLASSE_ENERGETICA table.
	 */
	protected Double indGlobLimiteTo;

	/**
	 * Method 'SiceeTClasseEnergetica'
	 * 
	 */
	public SiceeTClasseEnergetica()
	{
	}

	/**
	 * Method 'getIndRiscEpi'
	 * 
	 * @return Double
	 */
	public Double getIndRiscEpi()
	{
		return this.indRiscEpi;
	}

	/**
	 * Method 'setIndRiscEpi'
	 * 
	 * @param indRiscEpi
	 */
	public void setIndRiscEpi(Double indRiscEpi)
	{
		this.indRiscEpi = indRiscEpi;
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
	 * Method 'getIndCondEst'
	 * 
	 * @return Double
	 */
	public Double getIndCondEst()
	{
		return this.indCondEst;
	}

	/**
	 * Method 'setIndCondEst'
	 * 
	 * @param indCondEst
	 */
	public void setIndCondEst(Double indCondEst)
	{
		this.indCondEst = indCondEst;
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
	 * Method 'getIndIllum'
	 * 
	 * @return Double
	 */
	public Double getIndIllum()
	{
		return this.indIllum;
	}

	/**
	 * Method 'setIndIllum'
	 * 
	 * @param indIllum
	 */
	public void setIndIllum(Double indIllum)
	{
		this.indIllum = indIllum;
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
	 * Method 'getIndGlobEplordo'
	 * 
	 * @return Double
	 */
	public Double getIndGlobEplordo()
	{
		return this.indGlobEplordo;
	}

	/**
	 * Method 'setIndGlobEplordo'
	 * 
	 * @param indGlobEplordo
	 */
	public void setIndGlobEplordo(Double indGlobEplordo)
	{
		this.indGlobEplordo = indGlobEplordo;
	}

	/**
	 * Method 'getFkClasse'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasse()
	{
		return this.fkClasse;
	}

	/**
	 * Method 'setFkClasse'
	 * 
	 * @param fkClasse
	 */
	public void setFkClasse(Integer fkClasse)
	{
		this.fkClasse = fkClasse;
	}

	/**
	 * Method 'getRendGener'
	 * 
	 * @return Double
	 */
	public Double getRendGener()
	{
		return this.rendGener;
	}

	/**
	 * Method 'setRendGener'
	 * 
	 * @param rendGener
	 */
	public void setRendGener(Double rendGener)
	{
		this.rendGener = rendGener;
	}

	/**
	 * Method 'getRendRegol'
	 * 
	 * @return Double
	 */
	public Double getRendRegol()
	{
		return this.rendRegol;
	}

	/**
	 * Method 'setRendRegol'
	 * 
	 * @param rendRegol
	 */
	public void setRendRegol(Double rendRegol)
	{
		this.rendRegol = rendRegol;
	}

	/**
	 * Method 'getServiziEnergetici'
	 * 
	 * @return String
	 */
	public String getServiziEnergetici()
	{
		return this.serviziEnergetici;
	}

	/**
	 * Method 'setServiziEnergetici'
	 * 
	 * @param serviziEnergetici
	 */
	public void setServiziEnergetici(String serviziEnergetici)
	{
		this.serviziEnergetici = serviziEnergetici;
	}

	/**
	 * Method 'getRendEmiss'
	 * 
	 * @return Double
	 */
	public Double getRendEmiss()
	{
		return this.rendEmiss;
	}

	/**
	 * Method 'setRendEmiss'
	 * 
	 * @param rendEmiss
	 */
	public void setRendEmiss(Double rendEmiss)
	{
		this.rendEmiss = rendEmiss;
	}

	/**
	 * Method 'getRendDistrib'
	 * 
	 * @return Double
	 */
	public Double getRendDistrib()
	{
		return this.rendDistrib;
	}

	/**
	 * Method 'setRendDistrib'
	 * 
	 * @param rendDistrib
	 */
	public void setRendDistrib(Double rendDistrib)
	{
		this.rendDistrib = rendDistrib;
	}

	/**
	 * Method 'getRendImpEtag'
	 * 
	 * @return Double
	 */
	public Double getRendImpEtag()
	{
		return this.rendImpEtag;
	}

	/**
	 * Method 'setRendImpEtag'
	 * 
	 * @param rendImpEtag
	 */
	public void setRendImpEtag(Double rendImpEtag)
	{
		this.rendImpEtag = rendImpEtag;
	}

	/**
	 * Method 'getDomRiscQhto'
	 * 
	 * @return Double
	 */
	public Double getDomRiscQhto()
	{
		return this.domRiscQhto;
	}

	/**
	 * Method 'setDomRiscQhto'
	 * 
	 * @param domRiscQhto
	 */
	public void setDomRiscQhto(Double domRiscQhto)
	{
		this.domRiscQhto = domRiscQhto;
	}

	/**
	 * Method 'getLimiteRegQhto'
	 * 
	 * @return Double
	 */
	public Double getLimiteRegQhto()
	{
		return this.limiteRegQhto;
	}

	/**
	 * Method 'setLimiteRegQhto'
	 * 
	 * @param limiteRegQhto
	 */
	public void setLimiteRegQhto(Double limiteRegQhto)
	{
		this.limiteRegQhto = limiteRegQhto;
	}

	/**
	 * Method 'getIndRiscEpito'
	 * 
	 * @return Double
	 */
	public Double getIndRiscEpito()
	{
		return this.indRiscEpito;
	}

	/**
	 * Method 'setIndRiscEpito'
	 * 
	 * @param indRiscEpito
	 */
	public void setIndRiscEpito(Double indRiscEpito)
	{
		this.indRiscEpito = indRiscEpito;
	}

	/**
	 * Method 'getDomAcsQhwto'
	 * 
	 * @return Double
	 */
	public Double getDomAcsQhwto()
	{
		return this.domAcsQhwto;
	}

	/**
	 * Method 'setDomAcsQhwto'
	 * 
	 * @param domAcsQhwto
	 */
	public void setDomAcsQhwto(Double domAcsQhwto)
	{
		this.domAcsQhwto = domAcsQhwto;
	}

	/**
	 * Method 'getEnAcsRinnoTo'
	 * 
	 * @return Double
	 */
	public Double getEnAcsRinnoTo()
	{
		return this.enAcsRinnoTo;
	}

	/**
	 * Method 'setEnAcsRinnoTo'
	 * 
	 * @param enAcsRinnoTo
	 */
	public void setEnAcsRinnoTo(Double enAcsRinnoTo)
	{
		this.enAcsRinnoTo = enAcsRinnoTo;
	}

	/**
	 * Method 'getRendAcsEtagAcsto'
	 * 
	 * @return Double
	 */
	public Double getRendAcsEtagAcsto()
	{
		return this.rendAcsEtagAcsto;
	}

	/**
	 * Method 'setRendAcsEtagAcsto'
	 * 
	 * @param rendAcsEtagAcsto
	 */
	public void setRendAcsEtagAcsto(Double rendAcsEtagAcsto)
	{
		this.rendAcsEtagAcsto = rendAcsEtagAcsto;
	}

	/**
	 * Method 'getFabbAcsTo'
	 * 
	 * @return Double
	 */
	public Double getFabbAcsTo()
	{
		return this.fabbAcsTo;
	}

	/**
	 * Method 'setFabbAcsTo'
	 * 
	 * @param fabbAcsTo
	 */
	public void setFabbAcsTo(Double fabbAcsTo)
	{
		this.fabbAcsTo = fabbAcsTo;
	}

	/**
	 * Method 'getIndGlobEplordoTo'
	 * 
	 * @return Double
	 */
	public Double getIndGlobEplordoTo()
	{
		return this.indGlobEplordoTo;
	}

	/**
	 * Method 'setIndGlobEplordoTo'
	 * 
	 * @param indGlobEplordoTo
	 */
	public void setIndGlobEplordoTo(Double indGlobEplordoTo)
	{
		this.indGlobEplordoTo = indGlobEplordoTo;
	}

	/**
	 * Method 'getEtagConv'
	 * 
	 * @return Double
	 */
	public Double getEtagConv()
	{
		return this.etagConv;
	}

	/**
	 * Method 'setEtagConv'
	 * 
	 * @param etagConv
	 */
	public void setEtagConv(Double etagConv)
	{
		this.etagConv = etagConv;
	}

	/**
	 * Method 'getIndGlobLimiteTo'
	 * 
	 * @return Double
	 */
	public Double getIndGlobLimiteTo()
	{
		return this.indGlobLimiteTo;
	}

	/**
	 * Method 'setIndGlobLimiteTo'
	 * 
	 * @param indGlobLimiteTo
	 */
	public void setIndGlobLimiteTo(Double indGlobLimiteTo)
	{
		this.indGlobLimiteTo = indGlobLimiteTo;
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
		
		if (!(_other instanceof SiceeTClasseEnergetica)) {
			return false;
		}
		
		final SiceeTClasseEnergetica _cast = (SiceeTClasseEnergetica) _other;
		if (this.indRiscEpi == null ? _cast.indRiscEpi != this.indRiscEpi : !this.indRiscEpi.equals( _cast.indRiscEpi )) {
			return false;
		}
		
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.indCondEst == null ? _cast.indCondEst != this.indCondEst : !this.indCondEst.equals( _cast.indCondEst )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.indIllum == null ? _cast.indIllum != this.indIllum : !this.indIllum.equals( _cast.indIllum )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.indGlobEplordo == null ? _cast.indGlobEplordo != this.indGlobEplordo : !this.indGlobEplordo.equals( _cast.indGlobEplordo )) {
			return false;
		}
		
		if (this.fkClasse == null ? _cast.fkClasse != this.fkClasse : !this.fkClasse.equals( _cast.fkClasse )) {
			return false;
		}
		
		if (this.rendGener == null ? _cast.rendGener != this.rendGener : !this.rendGener.equals( _cast.rendGener )) {
			return false;
		}
		
		if (this.rendRegol == null ? _cast.rendRegol != this.rendRegol : !this.rendRegol.equals( _cast.rendRegol )) {
			return false;
		}
		
		if (this.serviziEnergetici == null ? _cast.serviziEnergetici != this.serviziEnergetici : !this.serviziEnergetici.equals( _cast.serviziEnergetici )) {
			return false;
		}
		
		if (this.rendEmiss == null ? _cast.rendEmiss != this.rendEmiss : !this.rendEmiss.equals( _cast.rendEmiss )) {
			return false;
		}
		
		if (this.rendDistrib == null ? _cast.rendDistrib != this.rendDistrib : !this.rendDistrib.equals( _cast.rendDistrib )) {
			return false;
		}
		
		if (this.rendImpEtag == null ? _cast.rendImpEtag != this.rendImpEtag : !this.rendImpEtag.equals( _cast.rendImpEtag )) {
			return false;
		}
		
		if (this.domRiscQhto == null ? _cast.domRiscQhto != this.domRiscQhto : !this.domRiscQhto.equals( _cast.domRiscQhto )) {
			return false;
		}
		
		if (this.limiteRegQhto == null ? _cast.limiteRegQhto != this.limiteRegQhto : !this.limiteRegQhto.equals( _cast.limiteRegQhto )) {
			return false;
		}
		
		if (this.indRiscEpito == null ? _cast.indRiscEpito != this.indRiscEpito : !this.indRiscEpito.equals( _cast.indRiscEpito )) {
			return false;
		}
		
		if (this.domAcsQhwto == null ? _cast.domAcsQhwto != this.domAcsQhwto : !this.domAcsQhwto.equals( _cast.domAcsQhwto )) {
			return false;
		}
		
		if (this.enAcsRinnoTo == null ? _cast.enAcsRinnoTo != this.enAcsRinnoTo : !this.enAcsRinnoTo.equals( _cast.enAcsRinnoTo )) {
			return false;
		}
		
		if (this.rendAcsEtagAcsto == null ? _cast.rendAcsEtagAcsto != this.rendAcsEtagAcsto : !this.rendAcsEtagAcsto.equals( _cast.rendAcsEtagAcsto )) {
			return false;
		}
		
		if (this.fabbAcsTo == null ? _cast.fabbAcsTo != this.fabbAcsTo : !this.fabbAcsTo.equals( _cast.fabbAcsTo )) {
			return false;
		}
		
		if (this.indGlobEplordoTo == null ? _cast.indGlobEplordoTo != this.indGlobEplordoTo : !this.indGlobEplordoTo.equals( _cast.indGlobEplordoTo )) {
			return false;
		}
		
		if (this.etagConv == null ? _cast.etagConv != this.etagConv : !this.etagConv.equals( _cast.etagConv )) {
			return false;
		}
		
		if (this.indGlobLimiteTo == null ? _cast.indGlobLimiteTo != this.indGlobLimiteTo : !this.indGlobLimiteTo.equals( _cast.indGlobLimiteTo )) {
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
		if (this.indRiscEpi != null) {
			_hashCode = 29 * _hashCode + this.indRiscEpi.hashCode();
		}
		
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.indCondEst != null) {
			_hashCode = 29 * _hashCode + this.indCondEst.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.indIllum != null) {
			_hashCode = 29 * _hashCode + this.indIllum.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.indGlobEplordo != null) {
			_hashCode = 29 * _hashCode + this.indGlobEplordo.hashCode();
		}
		
		if (this.fkClasse != null) {
			_hashCode = 29 * _hashCode + this.fkClasse.hashCode();
		}
		
		if (this.rendGener != null) {
			_hashCode = 29 * _hashCode + this.rendGener.hashCode();
		}
		
		if (this.rendRegol != null) {
			_hashCode = 29 * _hashCode + this.rendRegol.hashCode();
		}
		
		if (this.serviziEnergetici != null) {
			_hashCode = 29 * _hashCode + this.serviziEnergetici.hashCode();
		}
		
		if (this.rendEmiss != null) {
			_hashCode = 29 * _hashCode + this.rendEmiss.hashCode();
		}
		
		if (this.rendDistrib != null) {
			_hashCode = 29 * _hashCode + this.rendDistrib.hashCode();
		}
		
		if (this.rendImpEtag != null) {
			_hashCode = 29 * _hashCode + this.rendImpEtag.hashCode();
		}
		
		if (this.domRiscQhto != null) {
			_hashCode = 29 * _hashCode + this.domRiscQhto.hashCode();
		}
		
		if (this.limiteRegQhto != null) {
			_hashCode = 29 * _hashCode + this.limiteRegQhto.hashCode();
		}
		
		if (this.indRiscEpito != null) {
			_hashCode = 29 * _hashCode + this.indRiscEpito.hashCode();
		}
		
		if (this.domAcsQhwto != null) {
			_hashCode = 29 * _hashCode + this.domAcsQhwto.hashCode();
		}
		
		if (this.enAcsRinnoTo != null) {
			_hashCode = 29 * _hashCode + this.enAcsRinnoTo.hashCode();
		}
		
		if (this.rendAcsEtagAcsto != null) {
			_hashCode = 29 * _hashCode + this.rendAcsEtagAcsto.hashCode();
		}
		
		if (this.fabbAcsTo != null) {
			_hashCode = 29 * _hashCode + this.fabbAcsTo.hashCode();
		}
		
		if (this.indGlobEplordoTo != null) {
			_hashCode = 29 * _hashCode + this.indGlobEplordoTo.hashCode();
		}
		
		if (this.etagConv != null) {
			_hashCode = 29 * _hashCode + this.etagConv.hashCode();
		}
		
		if (this.indGlobLimiteTo != null) {
			_hashCode = 29 * _hashCode + this.indGlobLimiteTo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTClasseEnergeticaPk
	 */
	public SiceeTClasseEnergeticaPk createPk()
	{
		return new SiceeTClasseEnergeticaPk(this.idCertificatore, this.progrCertificato, this.anno);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTClasseEnergetica: " );
		ret.append( "indRiscEpi=" + this.indRiscEpi );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", indCondEst=" + this.indCondEst );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", indIllum=" + this.indIllum );
		ret.append( ", anno=" + this.anno );
		ret.append( ", indGlobEplordo=" + this.indGlobEplordo );
		ret.append( ", fkClasse=" + this.fkClasse );
		ret.append( ", rendGener=" + this.rendGener );
		ret.append( ", rendRegol=" + this.rendRegol );
		ret.append( ", serviziEnergetici=" + this.serviziEnergetici );
		ret.append( ", rendEmiss=" + this.rendEmiss );
		ret.append( ", rendDistrib=" + this.rendDistrib );
		ret.append( ", rendImpEtag=" + this.rendImpEtag );
		ret.append( ", domRiscQhto=" + this.domRiscQhto );
		ret.append( ", limiteRegQhto=" + this.limiteRegQhto );
		ret.append( ", indRiscEpito=" + this.indRiscEpito );
		ret.append( ", domAcsQhwto=" + this.domAcsQhwto );
		ret.append( ", enAcsRinnoTo=" + this.enAcsRinnoTo );
		ret.append( ", rendAcsEtagAcsto=" + this.rendAcsEtagAcsto );
		ret.append( ", fabbAcsTo=" + this.fabbAcsTo );
		ret.append( ", indGlobEplordoTo=" + this.indGlobEplordoTo );
		ret.append( ", etagConv=" + this.etagConv );
		ret.append( ", indGlobLimiteTo=" + this.indGlobLimiteTo );
		return ret.toString();
	}

}
