package it.csi.sicee.siceeweb.presentation.siceeweb.action.compilazattestatiape;

import java.io.File;
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
import it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel;

import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;

import it.csi.sicee.siceeweb.business.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.compilazattestatiape.states.CpCompilazApeScreenStates;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.MethodProtection;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;
import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpCompilazApeAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpCompilazApeAction extends AbstractCPAction<CpCompilazApeModel>
		implements
			Preparable,
			ModelDriven<CpCompilazApeModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpCompilazApeModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpCompilazApeModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpCompilazApeModel modello) {
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
			model = new CpCompilazApeModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpCompilazApe";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "compilazattestatiape";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/compilazattestatiape";

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

	private static final String URL_BACK_COMMAND = "/base/compilazattestatiape/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceeweb.dto.compilazattestatiape.CpCompilazApeModel.class;
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
	 * Gestione dell'evento di click sul tab Switcher del tab-set tspApe 
	 */
	public String handle_CpCompilazApe_TspApe_FpTspApeDatiGen_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpCompilazApe_tspApe_selectedMultiPanel");
		getModel().setSelectedTabValue("cpCompilazApe_tspApe_fpTspApeDatiGen");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsApe_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set tspApe 
	 */
	public String handle_CpCompilazApe_TspApe_FpTspApeSopralluogo_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpCompilazApe_tspApe_selectedMultiPanel");
		getModel().setSelectedTabValue("cpCompilazApe_tspApe_fpTspApeSopralluogo");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsApe_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_ON_REFRESH.equals(implicitEventName)) //NOSONAR
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvDtCatastali]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvDtCatastali_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "cbProvDtCatastali", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComDtCatastali]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComDtCatastali_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "cbComDtCatastali", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifIndDtCatastali]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifIndDtCatastali_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "vVerifIndDtCatastali", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [svuotaIndDtCatastaliText]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleSvuotaIndDtCatastaliText_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "svuotaIndDtCatastaliText", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bCercaCoordinate]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBCercaCoordinate_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bCercaCoordinate", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbFkMotivo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbFkMotivo_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "cbFkMotivo", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bCercaCfCertificatori]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBCercaCfCertificatori_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bCercaCfCertificatori", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbListaCf]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbListaCf_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "cbListaCf", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnSalvaDataSopralluogo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnSalvaDataSopralluogo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "btnSalvaDataSopralluogo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnEliminaFoto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnEliminaFoto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "btnEliminaFoto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCaricaFoto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCaricaFoto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "btnCaricaFoto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCaricaFotoAltre]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCaricaFotoAltre_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "btnCaricaFotoAltre", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "tsApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bInviaApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBInviaApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bInviaApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bConsolidaApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBConsolidaApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bConsolidaApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bCompModApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBCompModApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bCompModApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bViasualizzaApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBViasualizzaApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bViasualizzaApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bVerificaApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBVerificaApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bVerificaApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDocAggiuntiva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDocAggiuntiva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bDocAggiuntiva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestatiape", "cpcompilazape", "bIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbProvDtCatastali.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvDtCatastali_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceCertDTCat", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComDtCatastali.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComDtCatastali_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniCertDtCat", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSceltaIndDtCatastali.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSceltaIndDtCatastali_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasuggestIndirizzoDtCat", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSistCatast.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSistCatast_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatarifCatasto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFkTipoRistrutturaz.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFkTipoRistrutturaz_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipoRistrutt", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFkTipolEdilizia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFkTipolEdilizia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipolEdilizia", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFkTipolCostrutt.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFkTipolCostrutt_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipolCostrutt", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFkProprietaEdi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFkProprietaEdi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataproprEdificio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFkOggetto.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFkOggetto_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataoggettiApeLista", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFkMotivo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFkMotivo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatamotiviRilascio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAltroServiziEnergia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAltroServiziEnergia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataserviziEnergia", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDichiarazioneIndipendenza.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDichiarazioneIndipendenza_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatadichiarazioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbListaCf.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbListaCf_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatalistaCf", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoFoto.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoFoto_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipoFoto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoFotoAltre.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoFotoAltre_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipoFoto", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1136236031) ENABLED START*/
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
		String[] appDataToClear = new String[]{"suggestIndirizzo", "suggestIndirizzo_bckp"

		};

		ClearAppDataCommand clearCmd = new ClearAppDataCommand(appDataToClear);
		session.put(PENDING_CLEAR_COMMAND_ATTRIBUTE, clearCmd);

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
