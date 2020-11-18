package it.csi.sicee.siceeweb.presentation.siceeweb.action.gestcertificatore;

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
import it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel;

import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;

import it.csi.sicee.siceeweb.business.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.gestcertificatore.states.CpRegistrazScreenStates;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.MethodProtection;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;
import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpRegistrazAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpRegistrazAction extends AbstractCPAction<CpRegistrazModel>
		implements
			Preparable,
			ModelDriven<CpRegistrazModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpRegistrazModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpRegistrazModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpRegistrazModel modello) {
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
			model = new CpRegistrazModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpRegistraz";

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
		return it.csi.sicee.siceeweb.dto.gestcertificatore.CpRegistrazModel.class;
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

		if (AbstractCPAction.IMPLICIT_EVENT_ON_REFRESH //NOSONAR
				.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		// else
		return false;
	}

	protected boolean isOnRefreshLegacyMode() {
		return true;
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del singolo tipo di evento sul singolo widget
	/// contenuto nel contentPanel
	/// metodo: handle<nomeWidget>_<NOME_EVENTO>
	/// es: handletreeVoci_CLICKED
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRegNasc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRegNasc_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbRegNasc", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvNasc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvNasc_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbProvNasc", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComNasc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComNasc_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbComNasc", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAnagAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAnagAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtAnagAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbFlgResidenzaItalia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbFlgResidenzaItalia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "rbFlgResidenzaItalia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRegResid]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRegResid_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbRegResid", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvResid]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvResid_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbProvResid", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComResid]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComResid_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbComResid", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifIndRes]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifIndRes_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "vVerifIndRes", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbSceltaIndRes]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbSceltaIndRes_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbSceltaIndRes", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtResIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtResIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtResIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtResAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtResAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtResAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRegStudio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRegStudio_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbRegStudio", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvStudio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvStudio_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbProvStudio", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComStudio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComStudio_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbComStudio", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifIndStudio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifIndStudio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "vVerifIndStudio", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbSceltaIndStudio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbSceltaIndStudio_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbSceltaIndStudio", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtStudioIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtStudioIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtStudioIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtStudioAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtStudioAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtStudioAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsIscrittoOrdine]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsIscrittoOrdine_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "rbsIscrittoOrdine", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoIstr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoIstr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbTipoIstr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbCodiceIstr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbCodiceIstr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "cbCodiceIstr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblTitoloStudioSummary]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblTitoloStudioSummary_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "tblTitoloStudioSummary", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bInsAttTitoloStudio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBInsAttTitoloStudio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bInsAttTitoloStudio", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttPartNewSummary]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttPartNewSummary_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "tblAttPartNewSummary", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bInsAttPartNew]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBInsAttPartNew_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bInsAttPartNew", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttPartOldSummary]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttPartOldSummary_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "tblAttPartOldSummary", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtOrdineIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtOrdineIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtOrdineIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtOrdineAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtOrdineAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtOrdineAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvPagamentoOK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvPagamentoOK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "hvPagamentoOK", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtRiepilogoIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtRiepilogoIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtRiepilogoIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtRiepilogoAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtRiepilogoAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "bDtRiepilogoAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btPagOK]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtPagOK_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestcertificatore", "cpregistraz", "btPagOK", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbRegNasc.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRegNasc_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataregioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProvNasc.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvNasc_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceRegione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComNasc.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComNasc_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniProvincia", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRegResid.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRegResid_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataregioniRes", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProvResid.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvResid_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceResRegione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComResid.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComResid_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniResProvincia", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSceltaIndRes.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSceltaIndRes_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasuggestIndirizzo", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRegStudio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRegStudio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataregioniStudio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProvStudio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvStudio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceStudioRegione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComStudio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComStudio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniStudioProvincia", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSceltaIndStudio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSceltaIndStudio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasuggestIndirizzo", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoIstr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoIstr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipoIstruzione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCodiceIstr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCodiceIstr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacodiceIstruzione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblTitoloStudioSummary.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblTitoloStudioSummary_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviTitoloStudio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttPartNewSummary.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttPartNewSummary_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviAttPartNew", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttPartOldSummary.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttPartOldSummary_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviAttPartOld", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R226146551) ENABLED START*/
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
		String[] appDataToClear = new String[]{"comuniProvincia", "comuniProvincia_bckp", "provinceRegione",
				"provinceRegione_bckp", "suggestIndirizzo", "suggestIndirizzo_bckp", "regioni", "regioni_bckp",
				"comuniResProvincia", "comuniResProvincia_bckp", "comuniStudioProvincia", "comuniStudioProvincia_bckp",
				"provinceResRegione", "provinceResRegione_bckp", "provinceStudioRegione", "provinceStudioRegione_bckp",
				"regioniRes", "regioniRes_bckp", "regioniStudio", "regioniStudio_bckp", "provinceOrdinePiemonte",
				"provinceOrdinePiemonte_bckp", "msgPagamento", "msgPagamento_bckp"

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
