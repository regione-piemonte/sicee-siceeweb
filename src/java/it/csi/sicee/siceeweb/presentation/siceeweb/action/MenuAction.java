package it.csi.sicee.siceeweb.presentation.siceeweb.action;

import java.util.*;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.*;

import it.csi.sicee.siceeweb.dto.*;
import it.csi.sicee.siceeweb.business.*;
import it.csi.sicee.siceeweb.presentation.siceeweb.command.*;
import it.csi.sicee.siceeweb.presentation.siceeweb.interceptor.FatClientOnly;

/**
 * MenuAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
public class MenuAction extends BaseAction<GlobalMenuModel> implements ModelDriven<GlobalMenuModel> {

	private GlobalMenuModel model;

	public GlobalMenuModel getModel() {
		return model;
	}

	public void setModel(GlobalMenuModel modello) {
		this.model = modello;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		super.setSession(session);
		if (model == null) {
			model = new GlobalMenuModel();
		}
		model.setSession(session);
	}

	private Map<String, JumpExtCommand> jumpExtCommands = new HashMap<String, JumpExtCommand>();

	public Map<String, JumpExtCommand> getJumpExtCommands() {
		return jumpExtCommands;
	}

	public void setJumpExtCommands(Map<String, JumpExtCommand> jumpExtCommands) {
		this.jumpExtCommands = jumpExtCommands;
	}

	/**
	 * classe model associata
	 */
	public Class modelClass() {
		return it.csi.sicee.siceeweb.dto.GlobalMenuModel.class;
	}

	/**
	 *
	 * @return Il risultato delle azioni, SUCCESS altrimenti.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return SUCCESS;
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuhome() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuhome", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuhome] returning result [" + result + "]");
			}
			setActiveMenu("mnuhome");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuhome] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuhome");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuGstDatiCert() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuGstDatiCert", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuGstDatiCert] returning result [" + result + "]");
			}
			setActiveMenu("mnuGstDatiCert");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuGstDatiCert] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuGstDatiCert");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuRegDatiCert() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuRegDatiCert", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRegDatiCert] returning result [" + result + "]");
			}
			setActiveMenu("mnuRegDatiCert");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRegDatiCert] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuRegDatiCert");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuTransDatiCert() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuTransDatiCert", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuTransDatiCert] returning result [" + result + "]");
			}
			setActiveMenu("mnuTransDatiCert");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuTransDatiCert] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuTransDatiCert");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuTransAnomaleDatiCert() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuTransAnomaleDatiCert", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuTransAnomaleDatiCert] returning result [" + result + "]");
			}
			setActiveMenu("mnuTransAnomaleDatiCert");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuTransAnomaleDatiCert] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuTransAnomaleDatiCert");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuInvioCurriculum() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuInvioCurriculum", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuInvioCurriculum] returning result [" + result + "]");
			}
			setActiveMenu("mnuInvioCurriculum");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuInvioCurriculum] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuInvioCurriculum");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuGstCert() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuGstCert", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuGstCert] returning result [" + result + "]");
			}
			setActiveMenu("mnuGstCert");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuGstCert] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuGstCert");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuPrenotAttestati() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuPrenotAttestati", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuPrenotAttestati] returning result [" + result + "]");
			}
			setActiveMenu("mnuPrenotAttestati");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuPrenotAttestati] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuPrenotAttestati");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuRicercaACE() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuRicercaACE", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicercaACE] returning result [" + result + "]");
			}
			setActiveMenu("mnuRicercaACE");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicercaACE] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuRicercaACE");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuGestACE() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuGestACE", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuGestACE] returning result [" + result + "]");
			}
			setActiveMenu("mnuGestACE");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuGestACE] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuGestACE");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuAnnullaACE() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuAnnullaACE", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuAnnullaACE] returning result [" + result + "]");
			}
			setActiveMenu("mnuAnnullaACE");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuAnnullaACE] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuAnnullaACE");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToVAmbiente() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "vAmbiente", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToVAmbiente] returning result [" + result + "]");
			}
			setActiveMenu("vAmbiente");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToVAmbiente] returning default result [SUCCESS]");
			}
			setActiveMenu("vAmbiente");
			return SUCCESS;
		}
	}

	public static final String ACTIVE_MENU_ATTRNAME = "active_menu";

	public void setActiveMenu(String menuName) {
		session.put(ACTIVE_MENU_ATTRNAME, "menu_items_" + menuName);
	}

	/**
	 * inizializza la struttura dei command da eseguire per ciascun event handler 
	 * di ciascun widget
	 */
	protected ICommand initCommand(String moduleName, String panelName, String sourceWidget, String eventType) {
		ICommand cmd = null;
		try {
			cmd = CommandFactory.getInstance().buildCmdStructure_internal(null, "global",
					"_" + sourceWidget.toLowerCase() + "_" + "CLICKED");
		} catch (CommandExecutionException cee) {
			LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage() + ", restituisco NOPCommand",
					cee);
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-963475072) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// non sapendo quale content panel si sta abbandonando vengono rimossi tutti
		// gli appdata a scope PAGE

	}

	protected void dumpModel(boolean pre) {
		// metodo intenzionalmente vuoto
	}

	protected void doBeforeEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}

	protected void doAfterEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}
}
