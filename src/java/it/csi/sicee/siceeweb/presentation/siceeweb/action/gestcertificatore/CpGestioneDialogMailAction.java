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
import it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel;

import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;

import it.csi.sicee.siceeweb.business.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.gestcertificatore.states.CpGestioneDialogMailScreenStates;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.MethodProtection;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;
import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestioneDialogMailAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestioneDialogMailAction extends AbstractCPAction<CpGestioneDialogMailModel>
		implements
			Preparable,
			ModelDriven<CpGestioneDialogMailModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestioneDialogMailModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestioneDialogMailModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestioneDialogMailModel modello) {
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
			model = new CpGestioneDialogMailModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestioneDialogMail";

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
		return it.csi.sicee.siceeweb.dto.gestcertificatore.CpGestioneDialogMailModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [hvEsitoMailOK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvEsitoMailOK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpgestionedialogmail", "hvEsitoMailOK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvEsitoMailKO]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvEsitoMailKO_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpgestionedialogmail", "hvEsitoMailKO", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvEsitoMailMSG]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvEsitoMailMSG_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpgestionedialogmail", "hvEsitoMailMSG", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [cbMailEsitoOK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbMailEsitoOK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpgestionedialogmail", "cbMailEsitoOK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [cbMailEsitoKO]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbMailEsitoKO_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpgestionedialogmail", "cbMailEsitoKO", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btPagConf]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtPagConf_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpgestionedialogmail", "btPagConf", "CLICKED");

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
		/*PROTECTED REGION ID(R-415341929) ENABLED START*/
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
