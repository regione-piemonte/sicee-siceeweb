<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiAcquaCalda" class="formPanelBlock"><!-- startFragment:p_pDatiAcquaCalda -->
		
	
<div class="formPanel" id="pDatiAcquaCalda">


	
	

	
	
			
	
	<div id="p_pErrDtAcquaCalda" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtAcquaCalda -->
	
	
<div class="stdMessagePanel" id="pErrDtAcquaCalda">
	<customtag:stdMessagePanel id="pErrDtAcquaCalda" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtAcquaCalda --></div>

			
	
	<div id="p_pDtAcquaCalda" class="widgetsPanelBlock"><!-- startFragment:p_pDtAcquaCalda -->
	
	

<div class="widgetsPanel" id="pDtAcquaCalda">
	
	<customtag:widgetsPanel id="pDtAcquaCaldaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtAcquaCalda')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDtAcquaCalda -->
<s:text name="cpCompilaz.txtObblDtAcquaCalda.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfAnnoInstGenerAcqua')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfAnnoInstGenerAcqua.label')}" labelFor="widg_tfAnnoInstGenerAcqua" errorFor="appDatacertificato.impianti.acqua.annoInstallGeneratore" labelId="tfAnnoInstGenerAcquaLbl"
	  >


<!-- widget tfAnnoInstGenerAcqua -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.acqua.annoInstallGeneratore" id="widg_tfAnnoInstGenerAcqua"
maxlength="4"	disabled="isWidgetDisabled('cpCompilaz','tfAnnoInstGenerAcqua')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfPotenzaNomAcqua')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfPotenzaNomAcqua.label')}" labelFor="widg_tfPotenzaNomAcqua" errorFor="appDatacertificato.impianti.acqua.potNomCompl" labelId="tfPotenzaNomAcquaLbl"
	  >


<!-- widget tfPotenzaNomAcqua -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.acqua.potNomCompl" id="widg_tfPotenzaNomAcqua"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfPotenzaNomAcqua')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbClasseEfficEnergAcqua')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbClasseEfficEnergAcqua.label')}" labelFor="widg_cbClasseEfficEnergAcqua" errorFor="appDatacertificato.impianti.acqua.classeEfficienzaEnerg" labelId="cbClasseEfficEnergAcquaLbl"
	  >


<!-- widget cbClasseEfficEnergAcqua -->
<s:select name="appDatacertificato.impianti.acqua.classeEfficienzaEnerg" id="widg_cbClasseEfficEnergAcqua"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataclassiEfficienzaEnergetiche"
	  disabled="isWidgetDisabled('cpCompilaz','cbClasseEfficEnergAcqua')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbTipoCombustibAcqua')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbTipoCombustibAcqua.label')}" labelFor="widg_cbTipoCombustibAcqua" errorFor="appDatacertificato.impianti.acqua.combustibileFossile" labelId="cbTipoCombustibAcquaLbl"
	  >


<!-- widget cbTipoCombustibAcqua -->
<s:select name="appDatacertificato.impianti.acqua.combustibileFossile" id="widg_cbTipoCombustibAcqua"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipiCombustibileAcquaCalda"
	  disabled="isWidgetDisabled('cpCompilaz','cbTipoCombustibAcqua')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAcquaCalda --></div>

			
	
	<div id="p_pDtAcquaCaldaNav" class="commandPanelBlock"><!-- startFragment:p_pDtAcquaCaldaNav -->
	
	
<div class="commandPanel navigation" id="pDtAcquaCaldaNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAcquaCaldaIndietro')" >

	



<!-- widget bDtAcquaCaldaIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAcquaCaldaIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAcquaCaldaIndietro" id="widg_bDtAcquaCaldaIndietro" method="handleBDtAcquaCaldaIndietro_CLICKED"
	key="cpCompilaz.bDtAcquaCaldaIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAcquaCaldaIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAcquaCaldaAvanti')" >

	



<!-- widget bDtAcquaCaldaAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAcquaCaldaAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAcquaCaldaAvanti" id="widg_bDtAcquaCaldaAvanti" method="handleBDtAcquaCaldaAvanti_CLICKED"
	key="cpCompilaz.bDtAcquaCaldaAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAcquaCaldaAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtAcquaCaldaNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiAcquaCalda --></div>
