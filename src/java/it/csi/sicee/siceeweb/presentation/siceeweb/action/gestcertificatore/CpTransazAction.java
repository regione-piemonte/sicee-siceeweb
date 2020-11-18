package it.csi.sicee.siceeweb.presentation.siceeweb.action.gestcertificatore;

import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.sicee.siceeweb.util.*;
import it.csi.sicee.siceeweb.dto.*;
import it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel;

import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;

import it.csi.sicee.siceeweb.business.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.gestcertificatore.states.CpTransazScreenStates;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.MethodProtection;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;
import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpTransazAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpTransazAction extends AbstractCPAction<CpTransazModel>
		implements
			Preparable,
			ModelDriven<CpTransazModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpTransazModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpTransazModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpTransazModel modello) {
		this.model = modello;
	}

	/**
	 * Il metodo setSession() viene ridefinito in modo che venga asosciato all'oggetto
	 * model.
	 * N.B: il model deve essere creato in precedenza, altrimenti l'impostazione non 
	 * e' possibile. 
	 * Per questo motivo esso viene creato in questo (se non gia' esistente).
	 */
	@Override
	public void setSession(Map session) {
		// implementazione standard di SessionAware
		super.setSession(session);
		// creo una nuova istanza di modello, se gia' non esiste 
		if (model == null) {
			model = new CpTransazModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpTransaz";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestcertificatore";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestcertificatore";

	/**
	 * restituisce il nome del content panel
	 */
	public String getCPName() {
		return CP_NAME;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel
	 */
	public String getCPNamespace() {
		return CP_NAMESPACE;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel, comprensivo di prefisso "base"/"secure"
	 */
	public String getCPFullNamespace() {
		return CP_FULL_NAMESPACE;
	}

	private static final String URL_BACK_COMMAND = "/base/gestcertificatore/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceeweb.dto.gestcertificatore.CpTransazModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del click sui Tab
	/// contenuto nel contentPanel
	/// metodo: handle<id_completo_tab_item>_CLICKED
	/// 
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set pWizTransaz 
	 */
	public String handle_CpTransaz_PWizTransaz_PRegistrazCert_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpTransaz_pWizTransaz_selectedMultiPanel");
		getModel().setSelectedTabValue("cpTransaz_pWizTransaz_pRegistrazCert");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsTransaz_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set pWizTransaz 
	 */
	public String handle_CpTransaz_PWizTransaz_PAcquistoAce_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpTransaz_pWizTransaz_selectedMultiPanel");
		getModel().setSelectedTabValue("cpTransaz_pWizTransaz_pAcquistoAce");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsTransaz_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set pWizTransaz 
	 */
	public String handle_CpTransaz_PWizTransaz_PAcquistoCrediti_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpTransaz_pWizTransaz_selectedMultiPanel");
		getModel().setSelectedTabValue("cpTransaz_pWizTransaz_pAcquistoCrediti");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsTransaz_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		// else
		return false;
	}

	protected boolean isOnRefreshLegacyMode() {
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del singolo tipo di evento sul singolo widget
	/// contenuto nel contentPanel
	/// metodo: handle<nomeWidget>_<NOME_EVENTO>
	/// es: handletreeVoci_CLICKED
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento CLICKED sul widget [bStampaRicevutaReg]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBStampaRicevutaReg_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bStampaRicevutaReg", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bStampaRicevutaAce]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBStampaRicevutaAce_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bStampaRicevutaAce", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoRic]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoRic_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "cbTipoRic", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bRicaricaCredito]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBRicaricaCredito_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bRicaricaCredito", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDettRicarica]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDettRicarica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bDettRicarica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bGeneraApe]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBGeneraApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bGeneraApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bPagaIscrizioneAnnuale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBPagaIscrizioneAnnuale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bPagaIscrizioneAnnuale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bListaRT]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBListaRT_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bListaRT", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bConfGeneraApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBConfGeneraApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bConfGeneraApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bAnnullaGeneraApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBAnnullaGeneraApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "bAnnullaGeneraApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsTransaz]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsTransaz_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cptransaz", "tsTransaz", "CLICKED");

	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodo di data providing sull'intero ContentPanel
	/// metodo: provide_CPDATA
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	/// metodi di data providing sui widget dotati di multi data binding
	/// contenuti nel contentPanel
	/// metodo: provide<nomeWidget>_<tipologia dati>
	/// es: provideCbComuni_DATASET
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget transReg.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTransReg_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatransazioneRegistrazione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget transAce.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTransAce_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatransazioneAce", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoRic.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoRic_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipoRicercaTransazioniNew", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget transCredito.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTransCredito_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatransazioneCredito", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1193855691) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 * Metodo di preparazione della schermata/action
	 */
	public void prepare() throws CommandExecutionException {
		super.prepare();

	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// nothing to clear...
	}

	@SkipValidation
	public String handleChangeTab() {
		if (this.hasActionErrors() || this.hasFieldErrors() || this.hasErrors())
			return INPUT;
		else {
			session.put(getModel().getSelectedTabKey(), getModel().getSelectedTabValue());
			return SUCCESS;
		}
	}

}
