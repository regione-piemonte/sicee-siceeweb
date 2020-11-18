package it.csi.sicee.siceeweb.presentation.siceeweb.action.compilazattestati;

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
import it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel;

import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.security.*;

import it.csi.sicee.siceeweb.business.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.*;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.compilazattestati.states.CpCompilazScreenStates;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.MethodProtection;

import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;
import it.csi.sicee.siceeweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpCompilazAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpCompilazAction extends AbstractCPAction<CpCompilazModel>
		implements
			Preparable,
			ModelDriven<CpCompilazModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpCompilazModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpCompilazModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpCompilazModel modello) {
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
			model = new CpCompilazModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpCompilaz";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "compilazattestati";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/compilazattestati";

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

	private static final String URL_BACK_COMMAND = "/base/compilazattestati/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceeweb.dto.compilazattestati.CpCompilazModel.class;
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvDtCatastali]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvDtCatastali_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbProvDtCatastali", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComDtCatastali]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComDtCatastali_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbComDtCatastali", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifIndDtCatastali]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifIndDtCatastali_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "vVerifIndDtCatastali", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [svuotaIndDtCatastaliCombo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleSvuotaIndDtCatastaliCombo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "svuotaIndDtCatastaliCombo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [svuotaIndDtCatastaliText]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleSvuotaIndDtCatastaliText_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "svuotaIndDtCatastaliText", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvDtCatastaliSec]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvDtCatastaliSec_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbProvDtCatastaliSec", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bAddDtCatastaleSecondario]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBAddDtCatastaleSecondario_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bAddDtCatastaleSecondario", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDelDtCatastaleSecondario]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDelDtCatastaleSecondario_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDelDtCatastaleSecondario", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtCatastaliIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtCatastaliIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtCatastaliIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtCatastaliAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtCatastaliAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtCatastaliAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRegProgettista]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRegProgettista_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbRegProgettista", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvProgettista]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvProgettista_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbProvProgettista", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComProgettista]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComProgettista_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbComProgettista", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifIndProgettista]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifIndProgettista_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "vVerifIndProgettista", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbSceltaIndProgettista]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbSceltaIndProgettista_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbSceltaIndProgettista", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRegDirLav]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRegDirLav_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbRegDirLav", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvDirLav]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvDirLav_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbProvDirLav", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComDirLav]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComDirLav_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbComDirLav", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifIndDirLav]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifIndDirLav_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "vVerifIndDirLav", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbSceltaIndDirLav]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbSceltaIndDirLav_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbSceltaIndDirLav", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRegCostr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRegCostr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbRegCostr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvCostr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvCostr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbProvCostr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComCostr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComCostr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbComCostr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifIndCostr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifIndCostr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "vVerifIndCostr", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbSceltaIndCostr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbSceltaIndCostr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbSceltaIndCostr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtResponsIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtResponsIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtResponsIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtResponsAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtResponsAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtResponsAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtCoCertificatoreIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtCoCertificatoreIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtCoCertificatoreIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtCertificatoreAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtCertificatoreAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtCertificatoreAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbDestUso]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbDestUso_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbDestUso", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoImpianto2]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoImpianto2_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbTipoImpianto2", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoEdificio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoEdificio_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "cbTipoEdificio", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtTecniciCalcola]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtTecniciCalcola_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtTecniciCalcola", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtTecniciIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtTecniciIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtTecniciIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtTecniciAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtTecniciAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtTecniciAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbFabbisognoEnergia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbFabbisognoEnergia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "rbFabbisognoEnergia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFabbisognoCalcola]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFabbisognoCalcola_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFabbisognoCalcola", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFabbisognoIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFabbisognoIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFabbisognoIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFabbisognoAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFabbisognoAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFabbisognoAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtLocReale]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtLocReale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtLocReale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtLocRealeIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtLocRealeIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtLocRealeIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtLocRealeAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtLocRealeAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtLocRealeAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtLocTeor]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtLocTeor_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtLocTeor", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtLocTeoricaIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtLocTeoricaIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtLocTeoricaIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtLocTeoricaAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtLocTeoricaAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtLocTeoricaAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFontiRinnovCalcola]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFontiRinnovCalcola_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFontiRinnovCalcola", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFontiRinnovIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFontiRinnovIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFontiRinnovIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFontiRinnovAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFontiRinnovAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFontiRinnovAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriGeneraliIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriGeneraliIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriGeneraliIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriGeneraliAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriGeneraliAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriGeneraliAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bAddRaccomand]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBAddRaccomand_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bAddRaccomand", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDelRaccomand]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDelRaccomand_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDelRaccomand", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriRaccomandIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriRaccomandIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriRaccomandIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriRaccomandAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriRaccomandAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriRaccomandAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriEnergIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriEnergIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriEnergIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriEnergAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriEnergAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriEnergAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriSopralluoghiIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriSopralluoghiIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriSopralluoghiIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAltriSopralluoghiAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAltriSopralluoghiAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAltriSopralluoghiAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtNormative]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtNormative_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtNormative", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaAutorizzatoNormativa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaAutorizzatoNormativa_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "btnAnnullaAutorizzatoNormativa", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtNormativeIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtNormativeIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtNormativeIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtNormativeAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtNormativeAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtNormativeAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtLimNormRegImpTermCalcola]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtLimNormRegImpTermCalcola_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtLimNormRegImpTermCalcola", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtriscaldamentoIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtriscaldamentoIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtriscaldamentoIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtRiscaldamentoAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtRiscaldamentoAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtRiscaldamentoAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAcquaCaldaIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAcquaCaldaIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAcquaCaldaIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtAcquaCaldaAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtAcquaCaldaAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtAcquaCaldaAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtEmissGasAndSuperfBosco]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtEmissGasAndSuperfBosco_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtEmissGasAndSuperfBosco", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtGasSerraIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtGasSerraIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtGasSerraIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtGasSerraAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtGasSerraAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtGasSerraAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtConsumiIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtConsumiIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtConsumiIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtConsumiAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtConsumiAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtConsumiAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtDichiarazIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtDichiarazIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtDichiarazIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtDichiarazAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtDichiarazAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtDichiarazAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCaricaFoto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCaricaFoto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "btnCaricaFoto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFotoIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFotoIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFotoIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtFotoAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtFotoAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtFotoAvanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btStampaBozza]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtStampaBozza_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "btStampaBozza", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btStampaDefinitiva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtStampaDefinitiva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "btStampaDefinitiva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtStampaIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtStampaIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtStampaIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDtStampaAvanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDtStampaAvanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("compilazattestati", "cpcompilaz", "bDtStampaAvanti", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbProvDtCatastaliSec.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvDtCatastaliSec_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceCertDTCat", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComDtCatastaliSec.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComDtCatastaliSec_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniCertDtCatSecondari", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDtCatastaliSecondari.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDtCatastaliSecondari_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatempDtCatastaliSecondari", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRegProgettista.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRegProgettista_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataregioniCertProgettista", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProvProgettista.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvProgettista_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceCertProgettista", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComProgettista.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComProgettista_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniCertProgettista", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSceltaIndProgettista.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSceltaIndProgettista_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasuggestIndirizzoCertProgettista", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRegDirLav.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRegDirLav_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataregioniCertDirLav", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProvDirLav.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvDirLav_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceCertDirLav", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComDirLav.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComDirLav_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniCertDirLav", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSceltaIndDirLav.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSceltaIndDirLav_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasuggestIndirizzoCertDirLav", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRegCostr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRegCostr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataregioniCertCostr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProvCostr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvCostr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovinceCertCostr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComCostr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComCostr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuniCertCostr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSceltaIndCostr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSceltaIndCostr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasuggestIndirizzoCertCostr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDestUso.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDestUso_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatadestinazioniUso", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoImpianto2.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoImpianto2_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipiImpianto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoEdificio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoEdificio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipiEdificio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCarattEdificio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCarattEdificio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacarattEdificio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbMotivoRilascio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbMotivoRilascio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatamotiviRilascio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSistema.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSistema_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasistemi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblRaccomandazioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblRaccomandazioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatempRaccomandazioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbClasseEnergEnerg.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbClasseEnergEnerg_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataclassiEnergetiche", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbQualitaInvolucroRaffrescEnerg.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbQualitaInvolucroRaffrescEnerg_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataqualitaInvolucro", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiRedazione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiRedazione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipiRedazione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbClasseEfficEnergRiscald.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbClasseEfficEnergRiscald_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataclassiEfficienzaEnergetiche", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoCombustibRiscald.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoCombustibRiscald_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipiCombustibileRiscaldamento", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbClasseEfficEnergAcqua.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbClasseEfficEnergAcqua_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataclassiEfficienzaEnergetiche", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoCombustibAcqua.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoCombustibAcqua_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipiCombustibileAcquaCalda", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDichiarazioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDichiarazioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatadichiarazioni", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1084455431) ENABLED START*/
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
		String[] appDataToClear = new String[]{"suggestIndirizzo", "suggestIndirizzo_bckp",
				"raccomandazioneSelezionata", "raccomandazioneSelezionata_bckp", "qualitaInvolucro",
				"qualitaInvolucro_bckp", "classiEfficienzaEnergetiche", "classiEfficienzaEnergetiche_bckp",
				"datoCatastaleSelezionato", "datoCatastaleSelezionato_bckp"

		};

		String[] appDataToClear_cpCompilaz = new String[]{"suggestIndirizzo", "suggestIndirizzo_bckp",
				"raccomandazioneSelezionata", "raccomandazioneSelezionata_bckp", "datoCatastaleSelezionato",
				"datoCatastaleSelezionato_bckp"};
		if ("cpCompilaz".equals(targetContentPanelName)) {
			ClearAppDataCommand clearCmd = new ClearAppDataCommand(appDataToClear_cpCompilaz);
			session.put(PENDING_CLEAR_COMMAND_ATTRIBUTE, clearCmd);
			return;
		}

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
