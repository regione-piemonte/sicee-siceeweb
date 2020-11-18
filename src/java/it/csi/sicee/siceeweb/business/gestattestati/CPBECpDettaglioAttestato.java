package it.csi.sicee.siceeweb.business.gestattestati;

import java.util.*;

import it.csi.sicee.siceeweb.dto.*;
import it.csi.sicee.siceeweb.dto.ace.*;
import it.csi.sicee.siceeweb.dto.attestati.*;
import it.csi.sicee.siceeweb.dto.certificatore.*;
import it.csi.sicee.siceeweb.dto.geo.*;
import it.csi.sicee.siceeweb.dto.pagamenti.*;
import it.csi.sicee.siceeweb.dto.daticert.*;
import it.csi.sicee.siceeweb.dto.transazioni.*;
import it.csi.sicee.siceeweb.dto.annullamento.*;
import it.csi.sicee.siceeweb.dto.commons.*;

import org.apache.log4j.*;
import it.csi.sicee.siceeweb.util.*;
import it.csi.sicee.siceeweb.business.*;

/*PROTECTED REGION ID(R-85924552) ENABLED START*/
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDPriorita;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDPrioritaDaoException;
import it.csi.sicee.siceeweb.business.facade.CertificatoMgr;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpDettaglioAttestato {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [labelValueArray, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUEARRAY_CODE = "appDatalabelValueArray";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [parametroDiRequest, scope:USER_ACTION]
	public static final String APPDATA_PARAMETRODIREQUEST_CODE = "appDataparametroDiRequest";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [certificato, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATO_CODE = "appDatacertificato";

	// ApplicationData: [provenienzaPerReport, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZAPERREPORT_CODE = "appDataprovenienzaPerReport";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioAttestato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietro definito in un ExecCommand del
	 * ContentPanel cpDettaglioAttestato
	 */
	public ExecResults indietro(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDettaglioAttestatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRO_OUTCOME_CODE__RICERCAACE = //NOSONAR  Reason:EIAS
				"RicercaACE"; //NOSONAR  Reason:EIAS
		final String INDIETRO_OUTCOME_CODE__COMPILAZIONE = //NOSONAR  Reason:EIAS
				"Compilazione"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1397995347) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDataprovenienzaPerReport().equalsIgnoreCase(INDIETRO_OUTCOME_CODE__RICERCAACE))
				result.setResultCode(INDIETRO_OUTCOME_CODE__RICERCAACE);
			else
				result.setResultCode(INDIETRO_OUTCOME_CODE__COMPILAZIONE);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDettaglioAttestato definito in un ExecCommand del
	 * ContentPanel cpDettaglioAttestato
	 */
	public ExecResults visualizzaDettaglioAttestato(

			it.csi.sicee.siceeweb.dto.gestattestati.CpDettaglioAttestatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADETTAGLIOATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-169960929) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAttestatoDaStampare();

			ArrayList<LabelValue> labelValueList = getSOAIntegrationMgr().getDettaglioAce(codiceCertificato);

			if (log.isDebugEnabled()) {
				log.debug("STAMPO il labelValueList: " + labelValueList);
				log.debug("STAMPO il labelValueList.size(): " + labelValueList.size());
			}

			theModel.setAppDatalabelValueArray(labelValueList);

			/*
			DatiAttestato attestato = getCertificatoMgr().recuperaAttestato(
					theModel.getAppDatacertificatore(),
					theModel.getAppDatacodAttestatoDaStampare());
			attestato.setNumeroAttestato(theModel
					.getAppDatacodAttestatoDaStampare());
			attestato
					.getAltreInfo()
					.setRaccomandazioni(
							(ArrayList<Raccomandazione>) getCertificatoMgr()
									.recuperaRaccomandazioni(
											theModel.getAppDatacertificatore(),
											theModel.getAppDatacodAttestatoDaStampare()));
			
			ArrayList<LabelValue> labelValueList = (ArrayList<LabelValue>) getLabelValueListFromAttestato(attestato);
			theModel.setAppDatacertificato(attestato);
			theModel.setAppDatalabelValueArray(labelValueList);
			 */

			// impostazione del result code
			result.setResultCode(VISUALIZZADETTAGLIOATTESTATO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaDettaglioAttestato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDettaglioAttestato
	 */
	public static void resetClearStatus_widg_tbDettaglioAttestato(java.util.Map session) {
		session.put("cpDettaglioAttestato_tbDettaglioAttestato_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1371320708) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private CertificatoMgr certificatoMgr = null;

	public void setCertificatoMgr(CertificatoMgr cm) {
		certificatoMgr = cm;
	}

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	private MiscMgr miscMgr = null;

	public void setMiscMgr(MiscMgr mm) {
		miscMgr = mm;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}
	/*
	private List<LabelValue> getLabelValueListFromAttestato(
			DatiAttestato attestato) throws BEException,
			SiceeDPrioritaDaoException {
	
		ArrayList<LabelValue> labelValueList = new ArrayList<LabelValue>();
	
		LabelValue labelValue = new LabelValue();
		labelValue.setLabel("Codice A.P.E.");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getNumeroAttestato()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Provincia");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiAnagraficiImm().getDtCatastali()
						.getDescrProv()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Comune");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getDescrComune());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Zona climatica");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getZonaClimatica());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Gradi giorno");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiAnagraficiImm().getDtCatastali()
						.getGradiGiorno()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Indirizzo");
		String value = attestato.getDatiAnagraficiImm().getDtCatastali()
				.getDescrIndirizzo();
		if (attestato.getDatiAnagraficiImm().getDtCatastali().getNumCiv() != null)
			value = value
					+ ","
					+ attestato.getDatiAnagraficiImm().getDtCatastali()
							.getNumCiv();
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("CAP");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getCap());
		labelValueList.add(labelValue);
	
		// Beppe 10/01/2012
		
	
		labelValue = new LabelValue();
		labelValue.setLabel("Sezione");
		labelValue
				.setValue(getMiscMgr().getStringNotNull(
						attestato.getDatiAnagraficiImm().getDtCatastali()
								.getSezione()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Foglio");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getFoglio());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Particella");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getParticella());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Subalterno");
		labelValue.setValue(getMiscMgr().getStringNotNull(
				attestato.getDatiAnagraficiImm().getDtCatastali()
						.getSubalterno()));
		labelValueList.add(labelValue);
	
		// Dati catastali secondari
		ArrayList<DtCatastaliSecondari> datiCatastaliSecondariList = attestato
				.getDatiAnagraficiImm().getDtCatastali()
				.getDtCatastaliSecondari();
	
		if (datiCatastaliSecondariList != null
				&& datiCatastaliSecondariList.size() > 0) {
			for (int i = 0; i < datiCatastaliSecondariList.size(); i++) {
				labelValue = new LabelValue();
				value = "";
				labelValue.setLabel("NCEU secondari " + (i + 1) + "");
				DtCatastaliSecondari datiCatastaliSecondari = datiCatastaliSecondariList
						.get(i);
				value = value + "Prov:" + datiCatastaliSecondari.getDescrProv()
						+ "; ";
				value = value + "Comune:"
						+ datiCatastaliSecondari.getDescrComune() + "; ";
				if (datiCatastaliSecondari.getSezione() != null)
					value = value
							+ "Sez:"
							+ getMiscMgr().convertToStringForReport(
									datiCatastaliSecondari.getSezione()) + "; ";
				value = value
						+ "F:"
						+ getMiscMgr().convertToStringForReport(
								datiCatastaliSecondari.getFoglio()) + "; ";
				value = value
						+ "N:"
						+ getMiscMgr().convertToStringForReport(
								datiCatastaliSecondari.getParticella());
				if (datiCatastaliSecondari.getSubalterno() != null)
					value = value
							+ "; Sub:"
							+ getMiscMgr().convertToStringForReport(
									datiCatastaliSecondari.getSubalterno());
				labelValue.setValue(value);
				labelValueList.add(labelValue);
	
			}
		} else {
			labelValue = new LabelValue();
			labelValue.setLabel("NCEU secondari");
			labelValue.setValue("-");
			labelValueList.add(labelValue);
		}
	
		labelValue = new LabelValue();
		labelValue.setLabel("Piano");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiAnagraficiImm().getDtCatastali().getPiano()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Piani totali");
		labelValue.setValue(getMiscMgr()
				.convertToStringForReport(
						attestato.getDatiAnagraficiImm().getDtCatastali()
								.getPianiTot()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("N.appart./Unita'");
		labelValue.setValue(getMiscMgr()
				.convertToStringForReport(
						attestato.getDatiAnagraficiImm().getDtCatastali()
								.getNumUnita()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Scala");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getScala());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Interno");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getInterno());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Note");
		labelValue.setValue(attestato.getDatiAnagraficiImm().getDtCatastali()
				.getNote());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Progettista");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiAnagraficiImm().getDtResponsabili()
						.getDtProgettista().getNome())
				+ " "
				+ getMiscMgr().getStringNotNull(
						attestato.getDatiAnagraficiImm().getDtResponsabili()
								.getDtProgettista().getCognome()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Direttore lavori");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiAnagraficiImm().getDtResponsabili()
						.getDtDirLavori().getNome())
				+ " "
				+ getMiscMgr().convertToStringForReport(
						attestato.getDatiAnagraficiImm().getDtResponsabili()
								.getDtDirLavori().getCognome()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Costruttore");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiAnagraficiImm().getDtResponsabili()
						.getDtCostruttore().getNome())
				+ " "
				+ getMiscMgr().convertToStringForReport(
						attestato.getDatiAnagraficiImm().getDtResponsabili()
								.getDtCostruttore().getCognome()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Co-certificatore");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiAnagraficiImm().getDtCoCertificatore()
						.getNome())
				+ " "
				+ getMiscMgr().convertToStringForReport(
						attestato.getDatiAnagraficiImm().getDtCoCertificatore()
								.getCognome())
				+ " "
				+ getMiscMgr().convertToStringForReport(
						attestato.getDatiAnagraficiImm().getDtCoCertificatore()
								.getNumMatricola()));
		labelValueList.add(labelValue);
	
		
		labelValue = new LabelValue();
		labelValue.setLabel("Destinazione d'uso");
	
		ArrayList<DestUso> destUsoList = (ArrayList<DestUso>) getMiscMgr()
				.getDestinazioneDuso();
		value = "";
		Iterator<DestUso> it = destUsoList.iterator();
		while (it.hasNext()) {
			DestUso destUso = (DestUso) it.next();
			if (destUso.getCod().equalsIgnoreCase(
					attestato.getDatiTecnici().getDestUso()))
				value = destUso.getDescr();
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tipo impianto");
	
		ArrayList<TipoImpianto> tipiImpiantoList = (ArrayList<TipoImpianto>) getMiscMgr()
				.getTipiImpianto();
		value = "";
		Iterator<TipoImpianto> iteratorTipImp = tipiImpiantoList.iterator();
		while (iteratorTipImp.hasNext()) {
			TipoImpianto tipoImpianto = (TipoImpianto) iteratorTipImp.next();
			if (tipoImpianto.getCod().equalsIgnoreCase(
					attestato.getDatiTecnici().getTipoImpianto()))
				value = tipoImpianto.getDescr();
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tipologia dell'edificio");
	
		ArrayList<TipoEdificio> TipoEdificioList = (ArrayList<TipoEdificio>) getMiscMgr()
				.getTipoEdificio();
		value = "";
		Iterator<TipoEdificio> itTipEd = TipoEdificioList.iterator();
		while (itTipEd.hasNext()) {
			TipoEdificio tipoEdificio = (TipoEdificio) itTipEd.next();
			if (tipoEdificio.getCod().equalsIgnoreCase(
					attestato.getDatiTecnici().getTipoEdificio()))
				value = tipoEdificio.getDescr();
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Caratteristiche dell'edificio ");
	
		ArrayList<CarattEdificio> carattEdificioList = (ArrayList<CarattEdificio>) getMiscMgr()
				.getCaratteristicheEdificio();
	
		log.debug("BEPPE - carattEdificioList: " + carattEdificioList);
		log.debug("BEPPE - carattEdificioList.size(): "
				+ carattEdificioList.size());
		log.debug("BEPPE - attestato.getCarattEdificio(): "
				+ attestato.getDatiTecnici().getCarattEdificio());
	
		value = "";
	
		Iterator<CarattEdificio> itCarattEdificio = carattEdificioList
				.iterator();
		while (itCarattEdificio.hasNext()) {
			CarattEdificio carattEdificio = (CarattEdificio) itCarattEdificio
					.next();
	
			log.debug("BEPPE: getCod: " + carattEdificio.getCod());
			if (carattEdificio.getCod().equalsIgnoreCase(
					attestato.getDatiTecnici().getCarattEdificio())) {
				value = carattEdificio.getDescr();
	
			}
	
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Edificio pubblico o ad uso pubblico");
		if (attestato.getDatiTecnici().getFlagUsoPubblico() != null
				&& attestato.getDatiTecnici().getFlagUsoPubblico()
						.equalsIgnoreCase(Constants.SI))
			labelValue.setValue(Constants.LABEL_SI);
		else if (attestato.getDatiTecnici().getFlagUsoPubblico() != null
				&& attestato.getDatiTecnici().getFlagUsoPubblico()
						.equalsIgnoreCase(Constants.NO))
			labelValue.setValue(Constants.LABEL_NO);
		else
			labelValue.setValue("");
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Anno costruzione");
		labelValue.setValue(attestato.getDatiTecnici().getAnnoCostr());
		labelValueList.add(labelValue);
		labelValue = new LabelValue();
		labelValue.setLabel("Anno ultima ristrutturazione");
		labelValue.setValue(attestato.getDatiTecnici().getAnnoUltimaRistrutt());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tipologia edificio");
	
		ArrayList<TipoEdificio> tipiEdificio = (ArrayList<TipoEdificio>) getMiscMgr()
				.getTipoEdificio();
		value = "";
		Iterator<TipoEdificio> iteratorTE = tipiEdificio.iterator();
		while (iteratorTE.hasNext()) {
			TipoEdificio tipoEdificio = (TipoEdificio) iteratorTE.next();
			if (tipoEdificio.getCod().equalsIgnoreCase(
					attestato.getDatiTecnici().getTipoEdificio()))
				value = tipoEdificio.getDescr();
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Descrizione edificio");
		labelValue
				.setValue(attestato.getDatiTecnici().getDescrizioneEdificio());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue//.setLabel("Superficie utile climatizzata (SU) [m<sup>2</sup>]");
				.setLabel("Superficie utile climatizzata (SU) [m2]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiTecnici().getSuperficieUtile()));
		labelValueList.add(labelValue);
		labelValue = new LabelValue();
		labelValue.setLabel("Volume lordo riscaldato (V) [m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiTecnici().getVolLordoRiscald()));
		labelValueList.add(labelValue);
		labelValue = new LabelValue();
		labelValue.setLabel("Superficie disperdente totale (S) [m2]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiTecnici().getSupDispTot()));
		labelValueList.add(labelValue);
		labelValue = new LabelValue();
		labelValue.setLabel("Fattore Forma (S/V) [m-1]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiTecnici().getFattoreForma()));
		labelValueList.add(labelValue);
		labelValue = new LabelValue();
		labelValue
				.setLabel("Trasmittanza media superfici opache verticali [W/m2*K]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiTecnici().getTrasmittanzaOpache()));
		labelValueList.add(labelValue);
		labelValue = new LabelValue();
		labelValue
				.setLabel("Trasmittanza media superfici trasparenti [W/m2*K]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getDatiTecnici().getTrasmittanzaTrasp()));
		labelValueList.add(labelValue);
	
		// ------------> Fabbisogno
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia termica utile ideale (QH,nd) per unità di sup/vol [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getIndFabbisogno().getDomEnergRiscald()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Limite normativo regionale [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getIndFabbisogno().getLimNormRegione()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia termica utile per acqua calda sanitaria [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getIndFabbisogno().getDomEnergAcqua()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia termica utile per acqua calda sanitaria soddisfatto da fonti rinnovabili [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getIndFabbisogno().getEnergTermAcquaRinnov()));
		labelValueList.add(labelValue);
	
		//		labelValue = new LabelValue();
		//		labelValue
		//				.setLabel("Rendimento medio globale stagionale per acqua calda sanitaria (ETAg acs) [kWh/m2 o kWh/m3]");
		//		labelValue.setValue(getMiscMgr().convertToStringForReport(
		//				attestato.getIndFabbisogno().getRendGlobStagioneAcqua()));
		//		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice prestazione energetica per acqua calda sanitaria (EPacs) [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getIndFabbisogno().getIndPrestEnergAcqua()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia utile per la climatizzazione estiva (QC,nd) per unità di sup/vol [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getIndFabbisogno().getFabbCondizionamento()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia elettrica per illuminazione [kWh/m2]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getIndFabbisogno().getIndPrestEnergIlluminaz()));
		labelValueList.add(labelValue);
	
		//-------------> Classe energetica loc. reale
		labelValue = new LabelValue();
		labelValue.setLabel("Rendimento di generazione");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale().getRendGeneraz()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Rendimento di regolazione");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale().getRendRegolaz()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Rendimento di emissione");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale().getRendEmissione()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Rendimento di distribuzione");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale().getRendDistrib()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Rendimento medio globale impianto termico (ETAg)");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale().getRendGlobTermico()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice di prestazione energetica riscaldamento invernale (EPi,r) [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale()
						.getIndPrestEnergRiscald()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice di prestazione energetica per la climatizzazione estiva");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale()
						.getIndPrestEnergCondiz()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Indice prestazione energetica per illuminazione");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocReale()
						.getIndPrestEnergIlluminaz()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice prestazione energetica globale (EPL lordo) [kWh/m2 o kWh/m3] ");
		labelValue.setValue(getMiscMgr()
				.convertToStringForReport(
						attestato.getClasseEnerg().getLocReale()
								.getIndPrestEnergGlob()));
		labelValueList.add(labelValue);
	
		//-------------> Classe energetica loc. teorica (Torino)
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia termica utile ideale (QH,nd) per unità di sup/vol [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr()
				.convertToStringForReport(
						attestato.getClasseEnerg().getLocTeorica()
								.getDomEnergRiscald()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Limite di normativa regionale [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr()
				.convertToStringForReport(
						attestato.getClasseEnerg().getLocTeorica()
								.getLimNormaRegione()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice di prestazione energetica per il riscaldamento invernale (EPiTo) [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocTeorica()
						.getIndPrestEnergRiscald()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia termica utile per acqua calda sanitaria [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocTeorica().getDomEnergAcqua()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Fabbisogno di energia termica utile per acqua calda sanitaria soddisfatto da fonti rinnovabili [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocTeorica()
						.getEnergTermAcquaRinnov()));
		labelValueList.add(labelValue);
	
		//		labelValue = new LabelValue();
		//		labelValue
		//				.setLabel("Rendimento medio globale stagionale per acqua calda sanitaria (ETAg acs To)");
		//		labelValue.setValue(getMiscMgr().convertToStringForReport(
		//				attestato.getClasseEnerg().getLocTeorica()
		//						.getRendGlobStagioneAcqua()));
		//		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice prestazione energetica acqua calda sanitaria (EPacs To) [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocTeorica()
						.getIndPrestEnergAcqua()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice prestazione energetica globale (EPL lordo) [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocTeorica()
						.getIndPrestEnergGlob()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Classe Energetica");
		labelValue.setValue(getMiscMgr()
				.convertToStringForReport(
						attestato.getClasseEnerg().getLocTeorica()
								.getDescClasseEnerg()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Servizi energetici inclusi nella classificazione");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getClasseEnerg().getLocTeorica()
						.getServEnergInclusi()));
		labelValueList.add(labelValue);
	
		//-------->Energia da fonti rinnovabili 
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tecnologie uso fonti rinnovabili");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getEnergRinnov().getTechFontiRinnov()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Anno installazione");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getEnergRinnov().getAnnoInstall()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Energia termica prodotta [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getEnergRinnov().getEnergTermicaProdotta()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Energia elettrica prodotta [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getEnergRinnov().getEnergElettricaProdotta()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Autoconsumo termico");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getEnergRinnov().getAutoconsumoTermico()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Autoconsumo elettrico");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getEnergRinnov().getAutoconsumoElettrico()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Quota di energia coperta da fonti rinnovabili [%]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getEnergRinnov().getPercEnergiaFontiRinnov()));
		labelValueList.add(labelValue);
	
		//-------->Altre informazioni - Generali 
	
		labelValue = new LabelValue();
		labelValue.setLabel("Motivazione rilascio");
		ArrayList<MotivoRilascio> motiviRilascio = (ArrayList<MotivoRilascio>) getMiscMgr()
				.getMotiviRilascio();
		value = "";
		Iterator<MotivoRilascio> iterator = motiviRilascio.iterator();
		while (iterator.hasNext()) {
			MotivoRilascio motivoRilascio = (MotivoRilascio) iterator.next();
			if (motivoRilascio.getCod().equalsIgnoreCase(
					attestato.getAltreInfo().getGenerali().getMotivoRilascio()))
				value = motivoRilascio.getDescr();
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Metodologia di calcolo adottata");
		labelValue.setValue(attestato.getAltreInfo().getGenerali()
				.getMetodoCalcolo());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Software utilizzato");
		labelValue.setValue(attestato.getAltreInfo().getGenerali()
				.getSoftware());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Denominazione produttore");
		labelValue.setValue(attestato.getAltreInfo().getGenerali()
				.getDenomProduttore());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Rispondenza a UNI TS 11300");
		labelValue.setValue(attestato.getAltreInfo().getGenerali()
				.getRispondenzaUNITS11300());
		labelValueList.add(labelValue);
	
		//-------->Altre informazioni -Raccomandazioni
		ArrayList<Raccomandazione> raccomandazioniList = attestato
				.getAltreInfo().getRaccomandazioni();
		if (raccomandazioniList != null && raccomandazioniList.size() > 0) {
			List<SiceeDPriorita> prioritaList = getCertificatoMgr()
					.recuperaPriorita();
			for (int i = 0; i < raccomandazioniList.size(); i++) {
				labelValue = new LabelValue();
				value = "";
				labelValue.setLabel("Raccomandazione " + (i + 1) + "");
				Raccomandazione raccomandazione = raccomandazioniList.get(i);
				value = raccomandazione.getIntervento() + "; ";
				if (prioritaList != null) {
					for (int j = 0; j < prioritaList.size(); j++) {
						SiceeDPriorita priorita = prioritaList.get(j);
						if (raccomandazione.getPriorita().equals(
								priorita.getPriorita())) {
							value = value + "PRIO:" + priorita.getDescr()
									+ "; ";
							break;
						}
					}
	
				}
	
				value = value + "TdR:" + raccomandazione.getTempoRitorno();
				labelValue.setValue(value);
				labelValueList.add(labelValue);
	
			}
		} else {
			labelValue = new LabelValue();
			labelValue.setLabel("Raccomandazione");
			labelValue.setValue("-");
			labelValueList.add(labelValue);
		}
		//-------->Altre informazioni - Energetiche
	
		labelValue = new LabelValue();
		labelValue.setLabel("Classe energetica globale nazionale edificio");
		ArrayList<ClasseEnerg> classeEnergList = (ArrayList<ClasseEnerg>) getMiscMgr()
				.getClasseEnergetica();
		value = "";
		Iterator<ClasseEnerg> iter = classeEnergList.iterator();
		while (iter.hasNext()) {
			ClasseEnerg classeEnerg = (ClasseEnerg) iter.next();
			if (classeEnerg.getCod().equalsIgnoreCase(
					attestato.getAltreInfo().getEnergetiche()
							.getClasseEnergEdificio()))
				value = classeEnerg.getDescr();
		}
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice di prestazione energetica raggiungibile [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getAltreInfo().getEnergetiche()
						.getPrestEnergRaggiungibile()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Indice prestazione energetica riscaldamento invernale nazionale (EPi naz) [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getAltreInfo().getEnergetiche()
						.getIndPrestEnergRiscald()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Limite normativo nazionale per il riscaldamento [kWh/m2 o kWh/m3]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getAltreInfo().getEnergetiche()
						.getLimNormaNazRiscald()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Qualità termica estiva edificio (punto 6.1 del D.M. 26 giugno 2009)");
		ArrayList<QualitaInvolucro> qualitaInvolucroList = (ArrayList<QualitaInvolucro>) getMiscMgr()
				.getQualitaInvolucro();
		value = "";
		Iterator<QualitaInvolucro> iterator2 = qualitaInvolucroList.iterator();
		while (iterator2.hasNext()) {
			QualitaInvolucro qualitaInvolucro = (QualitaInvolucro) iterator2
					.next();
			if (qualitaInvolucro.getCod().equalsIgnoreCase(
					getMiscMgr().convertToStringForReport(
							attestato.getAltreInfo().getEnergetiche()
									.getQualitaInvolucroRaffresc())))
				value = qualitaInvolucro.getDescr();
		}
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Coefficiente di prestazione della pompa calore (se installata)");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getAltreInfo().getEnergetiche()
						.getPrestazPompaCalore()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Limite normativo per prestazione energetica della pompa calore (se installata)");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getAltreInfo().getEnergetiche()
						.getLimNormaPrestPompa()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Ulteriori informazioni");
		labelValue.setValue(attestato.getAltreInfo().getEnergetiche()
				.getAltreInfo());
		labelValueList.add(labelValue);
	
		//-------->Altre informazioni - sopralluoghi e dati di ingresso 
		labelValue = new LabelValue();
		labelValue.setLabel("Data effettuazione sopralluoghi");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getAltreInfo().getSopralluoghi().getData()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Note sopralluoghi");
		labelValue.setValue(attestato.getAltreInfo().getSopralluoghi()
				.getNote());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Dati redazione");
	
		ArrayList<TipoRedazione> tipiRedazione = (ArrayList<TipoRedazione>) getMiscMgr()
				.getTipiRedazione();
		value = "";
		Iterator<TipoRedazione> iterator3 = tipiRedazione.iterator();
		while (iterator3.hasNext()) {
			TipoRedazione tipoRedazione = (TipoRedazione) iterator3.next();
			if (tipoRedazione.getCod().equalsIgnoreCase(
					attestato.getAltreInfo().getSopralluoghi()
							.getTipoRedazione()))
				value = tipoRedazione.getDescr();
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
		//-------->Normative energetiche
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Data delle richiesta del titolo abilitativo a costruire/ristrutturare");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getRispNorme().getDataTitolo()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Normativa");
		labelValue.setValue(attestato.getRispNorme().getDescrNorma());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Rispetto degli obblighi normativi in campo energetico?");
		if (attestato.getRispNorme().getAutorizzato() != null
				&& attestato.getRispNorme().getAutorizzato()
						.equalsIgnoreCase("S"))
			labelValue.setValue("SI");
		else if (attestato.getRispNorme().getAutorizzato() != null
				&& attestato.getRispNorme().getAutorizzato()
						.equalsIgnoreCase("N"))
			labelValue.setValue("NO");
		else
			labelValue.setValue("");
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Se no, perchè");
		labelValue.setValue(attestato.getRispNorme().getMotivoNonConformita());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Ulteriori note");
		labelValue.setValue(attestato.getRispNorme().getNote());
		labelValueList.add(labelValue);
	
		//-------->Impianti - riscaldamento
		labelValue = new LabelValue();
		labelValue.setLabel("Impianto col bollino");
		if (attestato.getImpianti().getRiscaldamento().getFlgBollino() != null
				&& attestato.getImpianti().getRiscaldamento().getFlgBollino()
						.equalsIgnoreCase("S"))
			labelValue.setValue("SI");
		else if (attestato.getImpianti().getRiscaldamento().getFlgBollino() != null
				&& attestato.getImpianti().getRiscaldamento().getFlgBollino()
						.equalsIgnoreCase("N"))
			labelValue.setValue("NO");
		else
			labelValue.setValue("");
	
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Numero bollino");
		labelValue.setValue(attestato.getImpianti().getRiscaldamento()
				.getNumBollino());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Codice impianto");
		labelValue.setValue(attestato.getImpianti().getRiscaldamento()
				.getCodImpianto());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Anno installazione generatore");
		labelValue.setValue(attestato.getImpianti().getRiscaldamento()
				.getAnnoInstallGeneratore());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Potenza utile nominale complessiva [kW]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getImpianti().getRiscaldamento().getPotNomCompl()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Limite normativo regionale impianto termico (D.G.R. 46-11968)");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getImpianti().getRiscaldamento()
						.getLimNormRegImpTerm()));
		labelValueList.add(labelValue);
	
		
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Classe efficienza energetica per il riscaldamento");
		ArrayList<ClasseEfficienzaEnerg> classeEfficienzaEnergList = (ArrayList<ClasseEfficienzaEnerg>) getMiscMgr()
				.getClasseEfficienzaEnergetica();
		value = "";
		Iterator<ClasseEfficienzaEnerg> iterator4 = classeEfficienzaEnergList
				.iterator();
		while (iterator4.hasNext()) {
			ClasseEfficienzaEnerg classeEfficienzaEnerg = (ClasseEfficienzaEnerg) iterator4
					.next();
			if (classeEfficienzaEnerg.getCod().equalsIgnoreCase(
					attestato.getImpianti().getRiscaldamento()
							.getClasseEfficienzaEnerg()))
				value = classeEfficienzaEnerg.getDescr();
		}
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Fonte energetica utilizzata per il riscaldamento");
		ArrayList<TipoCombustibile> tipiCombustibileRiscaldamentoList = (ArrayList<TipoCombustibile>) getMiscMgr()
				.getTipiCombustibileRiscaldamento();
		value = "";
		Iterator<TipoCombustibile> iterator5 = tipiCombustibileRiscaldamentoList
				.iterator();
		while (iterator5.hasNext()) {
			TipoCombustibile tipoCombustibile = (TipoCombustibile) iterator5
					.next();
			if (tipoCombustibile.getCod().equalsIgnoreCase(
					attestato.getImpianti().getRiscaldamento()
							.getCombustibileFossile()))
				value = tipoCombustibile.getDescr();
		}
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Unita' immobiliari servite");
		labelValue.setValue(attestato.getImpianti().getUiServite());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Contabilizzazione/ripartizione");
		if (attestato.getImpianti().getFlgRipartizione() != null
				&& attestato.getImpianti().getFlgRipartizione()
						.equalsIgnoreCase("S"))
			labelValue.setValue("SI");
		else if (attestato.getImpianti().getFlgRipartizione() != null
				&& attestato.getImpianti().getFlgRipartizione()
						.equalsIgnoreCase("N"))
			labelValue.setValue("NO");
		else
			labelValue.setValue("");
	
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tipo impianto");
		value = "";
		Iterator<TipoImpianto> iterator8 = tipiImpiantoList.iterator();
		while (iterator8.hasNext()) {
			TipoImpianto tipoImpianto = (TipoImpianto) iterator8.next();
			if (tipoImpianto.getCod().equalsIgnoreCase(
					attestato.getDatiTecnici().getTipoImpianto()))
				value = tipoImpianto.getDescr();
		}
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tipo terminali erogazione");
		labelValue.setValue(attestato.getImpianti().getTipoTermErogaz());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tipo di distribuzione");
		labelValue.setValue(attestato.getImpianti().getTipoDistrib());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Tipo di regolazione");
		labelValue.setValue(attestato.getImpianti().getTipoRegolaz());
		labelValueList.add(labelValue);
	
		//-------->Impianti - acqua calda snitaria
		labelValue = new LabelValue();
		labelValue.setLabel("Anno installazione sistema acqua calda sanitaria");
		labelValue.setValue(attestato.getImpianti().getAcqua()
				.getAnnoInstallGeneratore());
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Potenza utile nominale complessiva acs [kW]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getImpianti().getAcqua().getPotNomCompl()));
		labelValueList.add(labelValue);
	
		
	
		labelValue = new LabelValue();
		labelValue.setLabel("Classe efficienza energetica acs");
		classeEfficienzaEnergList = (ArrayList<ClasseEfficienzaEnerg>) getMiscMgr()
				.getClasseEfficienzaEnergetica();
		value = "";
		Iterator<ClasseEfficienzaEnerg> iterator6 = classeEfficienzaEnergList
				.iterator();
		while (iterator6.hasNext()) {
			ClasseEfficienzaEnerg classeEfficienzaEnerg = (ClasseEfficienzaEnerg) iterator6
					.next();
			if (classeEfficienzaEnerg.getCod().equalsIgnoreCase(
					attestato.getImpianti().getAcqua()
							.getClasseEfficienzaEnerg()))
				value = classeEfficienzaEnerg.getDescr();
		}
	
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Fonte energetica utilizzata acs");
		ArrayList<TipoCombustibile> tipiCombustibileAcquaCaldaList = (ArrayList<TipoCombustibile>) getMiscMgr()
				.getTipiCombustibileAcquaCalda();
		value = "";
		Iterator<TipoCombustibile> iterator7 = tipiCombustibileAcquaCaldaList
				.iterator();
		while (iterator7.hasNext()) {
			TipoCombustibile tipoCombustibile = (TipoCombustibile) iterator7
					.next();
			if (tipoCombustibile.getCod()
					.equalsIgnoreCase(
							attestato.getImpianti().getAcqua()
									.getCombustibileFossile()))
				value = tipoCombustibile.getDescr();
		}
		labelValue.setValue(value);
		labelValueList.add(labelValue);
	
		//--------->Emissioni gas serra 
		labelValue = new LabelValue();
		labelValue.setLabel("Emissioni gas serra [kg/m3 anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getGasSerra().getEmissioniGasSerra()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Superficie ettari bosco equivalente [ha]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getGasSerra().getSupBoscoEquiv()));
		labelValueList.add(labelValue);
	
		
	
		//--------->Consumi reali
	
		labelValue = new LabelValue();
		labelValue.setLabel("Annuale termico da fossile [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getConsumiReali().getAnnoTermicoFossile()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Annuale elettrico da fossile [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getConsumiReali().getAnnoElettricoFossile()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Annuale termico da fonti rinnovabili [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getConsumiReali().getAnnoTermicoRinnov()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Annuale elettrico da fonti rinnovabili [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getConsumiReali().getAnnoElettricoRinnov()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue.setLabel("Medio complessivo termico (su 3 anni) [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getConsumiReali().getMedioTermico()));
		labelValueList.add(labelValue);
	
		labelValue = new LabelValue();
		labelValue
				.setLabel("Medio complessivo elettrico (su 3 anni) [kWh/anno]");
		labelValue.setValue(getMiscMgr().convertToStringForReport(
				attestato.getConsumiReali().getMedioElettrico()));
		labelValueList.add(labelValue);
	
		return labelValueList;
	}
	 */

	/*PROTECTED REGION END*/
}
