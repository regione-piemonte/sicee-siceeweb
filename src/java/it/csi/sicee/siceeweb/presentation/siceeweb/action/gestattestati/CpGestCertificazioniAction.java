package it.csi.sicee.siceeweb.presentation.siceeweb.action.gestattestati;

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
import it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel;

import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;

import it.csi.sicee.siceeweb.business.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.gestattestati.states.CpGestCertificazioniScreenStates;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.MethodProtection;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;
import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestCertificazioniAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestCertificazioniAction extends AbstractCPAction<CpGestCertificazioniModel>
		implements
			Preparable,
			ModelDriven<CpGestCertificazioniModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestCertificazioniModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestCertificazioniModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestCertificazioniModel modello) {
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
			model = new CpGestCertificazioniModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestCertificazioni";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestattestati";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestattestati";

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

	private static final String URL_BACK_COMMAND = "/base/gestattestati/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceeweb.dto.gestattestati.CpGestCertificazioniModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [tblAttestati]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttestati_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "tblAttestati", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bImportaDati]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBImportaDati_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bImportaDati", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bReConsAPE]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBReConsAPE_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bReConsAPE", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bReInitAPE]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBReInitAPE_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bReInitAPE", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bPagaAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBPagaAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bPagaAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDettApe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDettApe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bDettApe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDocAggiuntiva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDocAggiuntiva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bDocAggiuntiva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDownloadModulo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDownloadModulo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bDownloadModulo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btStampaAce]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtStampaAce_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "btStampaAce", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bStampaReport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBStampaReport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bStampaReport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bVisuraCit]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBVisuraCit_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "bVisuraCit", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "btnIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "btnConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroCons]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroCons_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "btnIndietroCons", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaCons]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaCons_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestattestati", "cpgestcertificazioni", "btnConfermaCons", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tblAttestati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttestati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviAttestati", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-907655746) ENABLED START*/
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
