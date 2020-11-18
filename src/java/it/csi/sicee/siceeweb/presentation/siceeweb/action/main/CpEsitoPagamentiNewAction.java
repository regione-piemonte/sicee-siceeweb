package it.csi.sicee.siceeweb.presentation.siceeweb.action.main;

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
import it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel;

import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;

import it.csi.sicee.siceeweb.business.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.main.states.CpEsitoPagamentiNewScreenStates;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.MethodProtection;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;
import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpEsitoPagamentiNewAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpEsitoPagamentiNewAction extends AbstractCPAction<CpEsitoPagamentiNewModel>
		implements
			Preparable,
			ModelDriven<CpEsitoPagamentiNewModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpEsitoPagamentiNewModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpEsitoPagamentiNewModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpEsitoPagamentiNewModel modello) {
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
			model = new CpEsitoPagamentiNewModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpEsitoPagamentiNew";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "main";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/main";

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

	private static final String URL_BACK_COMMAND = "/base/main/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceeweb.dto.main.CpEsitoPagamentiNewModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

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
	 * Gestione dell'evento CLICKED sul widget [hvPagamentoWISPOK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvPagamentoWISPOK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "hvPagamentoWISPOK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvPagamentoWISPKO]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvPagamentoWISPKO_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "hvPagamentoWISPKO", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvPagamentoOK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvPagamentoOK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "hvPagamentoOK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvPagamentoKO]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvPagamentoKO_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "hvPagamentoKO", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvPagamentoBACK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvPagamentoBACK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "hvPagamentoBACK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bPagOK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBPagOK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "bPagOK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bPagKO]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBPagKO_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "bPagKO", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bPagBACK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBPagBACK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "bPagBACK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bPagWISPKO]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBPagWISPKO_CLICKED() throws CommandExecutionException {

		return handleEventInternal("main", "cpesitopagamentinew", "bPagWISPKO", "CLICKED");

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
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1809191958) ENABLED START*/
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
		String[] appDataToClear = new String[]{"msgPagamento", "msgPagamento_bckp"

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
