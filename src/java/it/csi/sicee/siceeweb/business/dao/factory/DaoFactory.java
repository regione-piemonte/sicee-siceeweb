/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.factory;

import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCerticatoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCarattEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEfficienzaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCombustibileDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDatiIngressoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDestUso2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDestUsoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDichiarazioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDGradiGiornoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoSostDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDNormativaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDOggettoApe2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDPrioritaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDQualitaInvolucroDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRiqEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRuoloCert2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRuoloDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDServEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDSistemaRaccDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoCertDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoImpiantoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoPagamentoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTitoloDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDUnitaMisura2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeDZonaClimatica2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeRCertRuoliDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeRDestClasseDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAltreInfoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAziendaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertXml2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTClasseEnergeticaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTConsumiEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDatiGeneraliDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDetImp2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDocumentoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEnergiaSoprIngrDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFabbisognoDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFirmaMarcaDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTImpRiscaldamentoAcsDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTLimiteqhPiemonteDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTQtaConsumi2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRaccomand2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRaccomandazioniDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRifIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRispettoNormativeDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTRuoliEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTSostituzioneDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneAceDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneRegistrazDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTVerifysignandcertDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeWCertificatoreDao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DaoFactory
{
	/**
	 * Method 'createSiceeDTipoPagamentoDao'
	 * 
	 * @return SiceeDTipoPagamentoDao
	 */
	public static SiceeDTipoPagamentoDao createSiceeDTipoPagamentoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTipoPagamentoDao) bf.getBean( "SiceeDTipoPagamentoDao" );
	}

	/**
	 * Method 'createSiceeDDichiarazioneDao'
	 * 
	 * @return SiceeDDichiarazioneDao
	 */
	public static SiceeDDichiarazioneDao createSiceeDDichiarazioneDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDDichiarazioneDao) bf.getBean( "SiceeDDichiarazioneDao" );
	}

	/**
	 * Method 'createSiceeDStatoCertDao'
	 * 
	 * @return SiceeDStatoCertDao
	 */
	public static SiceeDStatoCertDao createSiceeDStatoCertDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDStatoCertDao) bf.getBean( "SiceeDStatoCertDao" );
	}

	/**
	 * Method 'createSiceeDMotivoSostDao'
	 * 
	 * @return SiceeDMotivoSostDao
	 */
	public static SiceeDMotivoSostDao createSiceeDMotivoSostDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDMotivoSostDao) bf.getBean( "SiceeDMotivoSostDao" );
	}

	/**
	 * Method 'createSiceeDClasseEfficienzaDao'
	 * 
	 * @return SiceeDClasseEfficienzaDao
	 */
	public static SiceeDClasseEfficienzaDao createSiceeDClasseEfficienzaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDClasseEfficienzaDao) bf.getBean( "SiceeDClasseEfficienzaDao" );
	}

	/**
	 * Method 'createSiceeDClasseEnergeticaDao'
	 * 
	 * @return SiceeDClasseEnergeticaDao
	 */
	public static SiceeDClasseEnergeticaDao createSiceeDClasseEnergeticaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDClasseEnergeticaDao) bf.getBean( "SiceeDClasseEnergeticaDao" );
	}

	/**
	 * Method 'createSiceeDCombustibileDao'
	 * 
	 * @return SiceeDCombustibileDao
	 */
	public static SiceeDCombustibileDao createSiceeDCombustibileDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDCombustibileDao) bf.getBean( "SiceeDCombustibileDao" );
	}

	/**
	 * Method 'createSiceeDDatiIngressoDao'
	 * 
	 * @return SiceeDDatiIngressoDao
	 */
	public static SiceeDDatiIngressoDao createSiceeDDatiIngressoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDDatiIngressoDao) bf.getBean( "SiceeDDatiIngressoDao" );
	}

	/**
	 * Method 'createSiceeDDestUsoDao'
	 * 
	 * @return SiceeDDestUsoDao
	 */
	public static SiceeDDestUsoDao createSiceeDDestUsoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDDestUsoDao) bf.getBean( "SiceeDDestUsoDao" );
	}

	/**
	 * Method 'createSiceeDGradiGiornoDao'
	 * 
	 * @return SiceeDGradiGiornoDao
	 */
	public static SiceeDGradiGiornoDao createSiceeDGradiGiornoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDGradiGiornoDao) bf.getBean( "SiceeDGradiGiornoDao" );
	}

	/**
	 * Method 'createSiceeDMotivoRilascioDao'
	 * 
	 * @return SiceeDMotivoRilascioDao
	 */
	public static SiceeDMotivoRilascioDao createSiceeDMotivoRilascioDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDMotivoRilascioDao) bf.getBean( "SiceeDMotivoRilascioDao" );
	}

	/**
	 * Method 'createSiceeDNormativaDao'
	 * 
	 * @return SiceeDNormativaDao
	 */
	public static SiceeDNormativaDao createSiceeDNormativaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDNormativaDao) bf.getBean( "SiceeDNormativaDao" );
	}

	/**
	 * Method 'createSiceeDPrioritaDao'
	 * 
	 * @return SiceeDPrioritaDao
	 */
	public static SiceeDPrioritaDao createSiceeDPrioritaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDPrioritaDao) bf.getBean( "SiceeDPrioritaDao" );
	}

	/**
	 * Method 'createSiceeDQualitaInvolucroDao'
	 * 
	 * @return SiceeDQualitaInvolucroDao
	 */
	public static SiceeDQualitaInvolucroDao createSiceeDQualitaInvolucroDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDQualitaInvolucroDao) bf.getBean( "SiceeDQualitaInvolucroDao" );
	}

	/**
	 * Method 'createSiceeDRuoloDao'
	 * 
	 * @return SiceeDRuoloDao
	 */
	public static SiceeDRuoloDao createSiceeDRuoloDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDRuoloDao) bf.getBean( "SiceeDRuoloDao" );
	}

	/**
	 * Method 'createSiceeDSistemaRaccDao'
	 * 
	 * @return SiceeDSistemaRaccDao
	 */
	public static SiceeDSistemaRaccDao createSiceeDSistemaRaccDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDSistemaRaccDao) bf.getBean( "SiceeDSistemaRaccDao" );
	}

	/**
	 * Method 'createSiceeDTipoImpiantoDao'
	 * 
	 * @return SiceeDTipoImpiantoDao
	 */
	public static SiceeDTipoImpiantoDao createSiceeDTipoImpiantoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTipoImpiantoDao) bf.getBean( "SiceeDTipoImpiantoDao" );
	}
	
	/**
	 * Method 'createSiceeDTipoEdificioDao'
	 * 
	 * @return SiceeDTipoEdificioDao
	 */
	public static SiceeDTipoEdificioDao createSiceeDTipoEdificioDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTipoEdificioDao) bf.getBean( "SiceeDTipoEdificioDao" );
	}

	/**
	 * Method 'createSiceeDTitoloDao'
	 * 
	 * @return SiceeDTitoloDao
	 */
	public static SiceeDTitoloDao createSiceeDTitoloDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTitoloDao) bf.getBean( "SiceeDTitoloDao" );
	}

	/**
	 * Method 'createSiceeRCertRuoliDao'
	 * 
	 * @return SiceeRCertRuoliDao
	 */
	public static SiceeRCertRuoliDao createSiceeRCertRuoliDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeRCertRuoliDao) bf.getBean( "SiceeRCertRuoliDao" );
	}

	/**
	 * Method 'createSiceeRDestClasseDao'
	 * 
	 * @return SiceeRDestClasseDao
	 */
	public static SiceeRDestClasseDao createSiceeRDestClasseDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeRDestClasseDao) bf.getBean( "SiceeRDestClasseDao" );
	}

	/**
	 * Method 'createSiceeTAltreInfoDao'
	 * 
	 * @return SiceeTAltreInfoDao
	 */
	public static SiceeTAltreInfoDao createSiceeTAltreInfoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTAltreInfoDao) bf.getBean( "SiceeTAltreInfoDao" );
	}

	/**
	 * Method 'createSiceeTAziendaDao'
	 * 
	 * @return SiceeTAziendaDao
	 */
	public static SiceeTAziendaDao createSiceeTAziendaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTAziendaDao) bf.getBean( "SiceeTAziendaDao" );
	}

	/**
	 * Method 'createSiceeTCertificatoDao'
	 * 
	 * @return SiceeTCertificatoDao
	 */
	public static SiceeTCertificatoDao createSiceeTCertificatoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTCertificatoDao) bf.getBean( "SiceeTCertificatoDao" );
	}

	/**
	 * Method 'createSiceeTCertificatoreDao'
	 * 
	 * @return SiceeTCertificatoreDao
	 */
	public static SiceeTCertificatoreDao createSiceeTCertificatoreDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTCertificatoreDao) bf.getBean( "SiceeTCertificatoreDao" );
	}

	/**
	 * Method 'createSiceeTClasseEnergeticaDao'
	 * 
	 * @return SiceeTClasseEnergeticaDao
	 */
	public static SiceeTClasseEnergeticaDao createSiceeTClasseEnergeticaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTClasseEnergeticaDao) bf.getBean( "SiceeTClasseEnergeticaDao" );
	}

	/**
	 * Method 'createSiceeTConsumiEdificioDao'
	 * 
	 * @return SiceeTConsumiEdificioDao
	 */
	public static SiceeTConsumiEdificioDao createSiceeTConsumiEdificioDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTConsumiEdificioDao) bf.getBean( "SiceeTConsumiEdificioDao" );
	}

	/**
	 * Method 'createSiceeTDatiGeneraliDao'
	 * 
	 * @return SiceeTDatiGeneraliDao
	 */
	public static SiceeTDatiGeneraliDao createSiceeTDatiGeneraliDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTDatiGeneraliDao) bf.getBean( "SiceeTDatiGeneraliDao" );
	}

	/**
	 * Method 'createSiceeTEnergiaSoprIngrDao'
	 * 
	 * @return SiceeTEnergiaSoprIngrDao
	 */
	public static SiceeTEnergiaSoprIngrDao createSiceeTEnergiaSoprIngrDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTEnergiaSoprIngrDao) bf.getBean( "SiceeTEnergiaSoprIngrDao" );
	}

	/**
	 * Method 'createSiceeTFabbisognoDao'
	 * 
	 * @return SiceeTFabbisognoDao
	 */
	public static SiceeTFabbisognoDao createSiceeTFabbisognoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTFabbisognoDao) bf.getBean( "SiceeTFabbisognoDao" );
	}

	/**
	 * Method 'createSiceeTImpRiscaldamentoAcsDao'
	 * 
	 * @return SiceeTImpRiscaldamentoAcsDao
	 */
	public static SiceeTImpRiscaldamentoAcsDao createSiceeTImpRiscaldamentoAcsDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTImpRiscaldamentoAcsDao) bf.getBean( "SiceeTImpRiscaldamentoAcsDao" );
	}

	/**
	 * Method 'createSiceeTLimiteqhPiemonteDao'
	 * 
	 * @return SiceeTLimiteqhPiemonteDao
	 */
	public static SiceeTLimiteqhPiemonteDao createSiceeTLimiteqhPiemonteDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTLimiteqhPiemonteDao) bf.getBean( "SiceeTLimiteqhPiemonteDao" );
	}

	/**
	 * Method 'createSiceeTRaccomandazioniDao'
	 * 
	 * @return SiceeTRaccomandazioniDao
	 */
	public static SiceeTRaccomandazioniDao createSiceeTRaccomandazioniDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTRaccomandazioniDao) bf.getBean( "SiceeTRaccomandazioniDao" );
	}

	/**
	 * Method 'createSiceeTRispettoNormativeDao'
	 * 
	 * @return SiceeTRispettoNormativeDao
	 */
	public static SiceeTRispettoNormativeDao createSiceeTRispettoNormativeDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTRispettoNormativeDao) bf.getBean( "SiceeTRispettoNormativeDao" );
	}

	/**
	 * Method 'createSiceeTRuoliEdificioDao'
	 * 
	 * @return SiceeTRuoliEdificioDao
	 */
	public static SiceeTRuoliEdificioDao createSiceeTRuoliEdificioDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTRuoliEdificioDao) bf.getBean( "SiceeTRuoliEdificioDao" );
	}

	/**
	 * Method 'createSiceeTTransazioneAceDao'
	 * 
	 * @return SiceeTTransazioneAceDao
	 */
	public static SiceeTTransazioneAceDao createSiceeTTransazioneAceDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTTransazioneAceDao) bf.getBean( "SiceeTTransazioneAceDao" );
	}

	/**
	 * Method 'createSiceeTTransazioneRegistrazDao'
	 * 
	 * @return SiceeTTransazioneRegistrazDao
	 */
	public static SiceeTTransazioneRegistrazDao createSiceeTTransazioneRegistrazDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTTransazioneRegistrazDao) bf.getBean( "SiceeTTransazioneRegistrazDao" );
	}

	/**
	 * Method 'createSiceeWCertificatoreDao'
	 * 
	 * @return SiceeWCertificatoreDao
	 */
	public static SiceeWCertificatoreDao createSiceeWCertificatoreDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeWCertificatoreDao) bf.getBean( "SiceeWCertificatoreDao" );
	}
	
	/**
	 * Method 'createOptimizedSiceeTCerticatoDao'
	 * 
	 * @return OptimizedSiceeTCerticatoDao
	 */
	
	public static OptimizedSiceeTCerticatoDao createOptimizedSiceeTCerticatoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (OptimizedSiceeTCerticatoDao) bf.getBean( "OptimizedSiceeTCerticatoDao" );
	}
	
	/**
	 * Method 'createSiceeDTipoDocumentoDao'
	 * 
	 * @return SiceeDTipoDocumentoDao
	 */
	public static SiceeDTipoDocumentoDao createSiceeDTipoDocumentoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTipoDocumentoDao) bf.getBean( "SiceeDTipoDocumentoDao" );
	}

	/**
	 * Method 'createSiceeTDocumentoDao'
	 * 
	 * @return SiceeTDocumentoDao
	 */
	public static SiceeTDocumentoDao createSiceeTDocumentoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTDocumentoDao) bf.getBean( "SiceeTDocumentoDao" );
	}

	
	/**
	 * Method 'createSiceeTParametriDao'
	 * 
	 * @return SiceeTParametriDao
	 */
	public static SiceeTParametriDao createSiceeTParametriDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTParametriDao) bf.getBean( "SiceeTParametriDao" );
	}
	
	/**
	 * Method 'createSiceeTExportBoDao'
	 * 
	 * @return SiceeTExportBoDao
	 */
	public static SiceeTExportBoDao createSiceeTExportBoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTExportBoDao) bf.getBean( "SiceeTExportBoDao" );
	}

	/**
	 * Method 'createSiceeTSostituzioneDao'
	 * 
	 * @return SiceeTSostituzioneDao
	 */
	public static SiceeTSostituzioneDao createSiceeTSostituzioneDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTSostituzioneDao) bf.getBean( "SiceeTSostituzioneDao" );
	}

	/**
	 * Method 'createSiceeDCarattEdificioDao'
	 * 
	 * @return SiceeDCarattEdificioDao
	 */
	public static SiceeDCarattEdificioDao createSiceeDCarattEdificioDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDCarattEdificioDao) bf.getBean( "SiceeDCarattEdificioDao" );
	}
	
	/**
	 * Method 'createSiceeTFirmaMarcaDao'
	 * 
	 * @return SiceeTFirmaMarcaDao
	 */
	public static SiceeTFirmaMarcaDao createSiceeTFirmaMarcaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTFirmaMarcaDao) bf.getBean( "SiceeTFirmaMarcaDao" );
	}

	/**
	 * Method 'createSiceeTVerifysignandcertDao'
	 * 
	 * @return SiceeTVerifysignandcertDao
	 */
	public static SiceeTVerifysignandcertDao createSiceeTVerifysignandcertDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTVerifysignandcertDao) bf.getBean( "SiceeTVerifysignandcertDao" );
	}
	
	/**
	 * Method 'createSiceeDDestUso2015Dao'
	 * 
	 * @return SiceeDDestUso2015Dao
	 */
	public static SiceeDDestUso2015Dao createSiceeDDestUso2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDDestUso2015Dao) bf.getBean( "SiceeDDestUso2015Dao" );
	}

	/**
	 * Method 'createSiceeDOggettoApe2015Dao'
	 * 
	 * @return SiceeDOggettoApe2015Dao
	 */
	public static SiceeDOggettoApe2015Dao createSiceeDOggettoApe2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDOggettoApe2015Dao) bf.getBean( "SiceeDOggettoApe2015Dao" );
	}

	/**
	 * Method 'createSiceeDRiqEner2015Dao'
	 * 
	 * @return SiceeDRiqEner2015Dao
	 */
	public static SiceeDRiqEner2015Dao createSiceeDRiqEner2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDRiqEner2015Dao) bf.getBean( "SiceeDRiqEner2015Dao" );
	}

	/**
	 * Method 'createSiceeDRuoloCert2015Dao'
	 * 
	 * @return SiceeDRuoloCert2015Dao
	 */
	public static SiceeDRuoloCert2015Dao createSiceeDRuoloCert2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDRuoloCert2015Dao) bf.getBean( "SiceeDRuoloCert2015Dao" );
	}

	/**
	 * Method 'createSiceeDServEner2015Dao'
	 * 
	 * @return SiceeDServEner2015Dao
	 */
	public static SiceeDServEner2015Dao createSiceeDServEner2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDServEner2015Dao) bf.getBean( "SiceeDServEner2015Dao" );
	}

	/**
	 * Method 'createSiceeDTipoDocIndex2015Dao'
	 * 
	 * @return SiceeDTipoDocIndex2015Dao
	 */
	public static SiceeDTipoDocIndex2015Dao createSiceeDTipoDocIndex2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTipoDocIndex2015Dao) bf.getBean( "SiceeDTipoDocIndex2015Dao" );
	}

	/**
	 * Method 'createSiceeDTipoFoto2015Dao'
	 * 
	 * @return SiceeDTipoFoto2015Dao
	 */
	public static SiceeDTipoFoto2015Dao createSiceeDTipoFoto2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTipoFoto2015Dao) bf.getBean( "SiceeDTipoFoto2015Dao" );
	}

	/**
	 * Method 'createSiceeDUnitaMisura2015Dao'
	 * 
	 * @return SiceeDUnitaMisura2015Dao
	 */
	public static SiceeDUnitaMisura2015Dao createSiceeDUnitaMisura2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDUnitaMisura2015Dao) bf.getBean( "SiceeDUnitaMisura2015Dao" );
	}

	/**
	 * Method 'createSiceeDZonaClimatica2015Dao'
	 * 
	 * @return SiceeDZonaClimatica2015Dao
	 */
	public static SiceeDZonaClimatica2015Dao createSiceeDZonaClimatica2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDZonaClimatica2015Dao) bf.getBean( "SiceeDZonaClimatica2015Dao" );
	}

	/**
	 * Method 'createSiceeTCertXml2015Dao'
	 * 
	 * @return SiceeTCertXml2015Dao
	 */
	public static SiceeTCertXml2015Dao createSiceeTCertXml2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTCertXml2015Dao) bf.getBean( "SiceeTCertXml2015Dao" );
	}

	/**
	 * Method 'createSiceeTDatiEner2015Dao'
	 * 
	 * @return SiceeTDatiEner2015Dao
	 */
	public static SiceeTDatiEner2015Dao createSiceeTDatiEner2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTDatiEner2015Dao) bf.getBean( "SiceeTDatiEner2015Dao" );
	}

	/**
	 * Method 'createSiceeTDetImp2015Dao'
	 * 
	 * @return SiceeTDetImp2015Dao
	 */
	public static SiceeTDetImp2015Dao createSiceeTDetImp2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTDetImp2015Dao) bf.getBean( "SiceeTDetImp2015Dao" );
	}

	/**
	 * Method 'createSiceeTFoto2015Dao'
	 * 
	 * @return SiceeTFoto2015Dao
	 */
	public static SiceeTFoto2015Dao createSiceeTFoto2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTFoto2015Dao) bf.getBean( "SiceeTFoto2015Dao" );
	}

	/**
	 * Method 'createSiceeTQtaConsumi2015Dao'
	 * 
	 * @return SiceeTQtaConsumi2015Dao
	 */
	public static SiceeTQtaConsumi2015Dao createSiceeTQtaConsumi2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTQtaConsumi2015Dao) bf.getBean( "SiceeTQtaConsumi2015Dao" );
	}

	/**
	 * Method 'createSiceeTRaccomand2015Dao'
	 * 
	 * @return SiceeTRaccomand2015Dao
	 */
	public static SiceeTRaccomand2015Dao createSiceeTRaccomand2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTRaccomand2015Dao) bf.getBean( "SiceeTRaccomand2015Dao" );
	}

	/**
	 * Method 'createSiceeTRifIndex2015Dao'
	 * 
	 * @return SiceeTRifIndex2015Dao
	 */
	public static SiceeTRifIndex2015Dao createSiceeTRifIndex2015Dao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTRifIndex2015Dao) bf.getBean( "SiceeTRifIndex2015Dao" );
	}
}
