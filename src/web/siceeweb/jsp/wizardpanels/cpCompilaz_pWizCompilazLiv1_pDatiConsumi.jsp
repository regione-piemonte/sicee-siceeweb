<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiConsumi" class="formPanelBlock"><!-- startFragment:p_pDatiConsumi -->
		
	
<div class="formPanel" id="pDatiConsumi">


	
	

	
	
			
	
	<div id="p_pErrDtConsumi" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtConsumi -->
	
	
<div class="stdMessagePanel" id="pErrDtConsumi">
	<customtag:stdMessagePanel id="pErrDtConsumi" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtConsumi --></div>

			
	
	<div id="p_pDtConsumi" class="widgetsPanelBlock"><!-- startFragment:p_pDtConsumi -->
	
	

<div class="widgetsPanel" id="pDtConsumi">
	
	<customtag:widgetsPanel id="pDtConsumiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','tConsAnnoTermicoFossile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tConsAnnoTermicoFossile.label')}" labelFor="widg_tConsAnnoTermicoFossile" errorFor="appDatacertificato.consumiReali.annoTermicoFossile" labelId="tConsAnnoTermicoFossileLbl"
	  >


<!-- widget tConsAnnoTermicoFossile -->
<s:textfield 
	
	
	name="appDatacertificato.consumiReali.annoTermicoFossile" id="widg_tConsAnnoTermicoFossile"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tConsAnnoTermicoFossile')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tConsAnnoElettricoFossile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tConsAnnoElettricoFossile.label')}" labelFor="widg_tConsAnnoElettricoFossile" errorFor="appDatacertificato.consumiReali.annoElettricoFossile" labelId="tConsAnnoElettricoFossileLbl"
	  >


<!-- widget tConsAnnoElettricoFossile -->
<s:textfield 
	
	
	name="appDatacertificato.consumiReali.annoElettricoFossile" id="widg_tConsAnnoElettricoFossile"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tConsAnnoElettricoFossile')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tConsAnnoTermicoRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tConsAnnoTermicoRinnov.label')}" labelFor="widg_tConsAnnoTermicoRinnov" errorFor="appDatacertificato.consumiReali.annoTermicoRinnov" labelId="tConsAnnoTermicoRinnovLbl"
	  >


<!-- widget tConsAnnoTermicoRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.consumiReali.annoTermicoRinnov" id="widg_tConsAnnoTermicoRinnov"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tConsAnnoTermicoRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tConsAnnoElettricoRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tConsAnnoElettricoRinnov.label')}" labelFor="widg_tConsAnnoElettricoRinnov" errorFor="appDatacertificato.consumiReali.annoElettricoRinnov" labelId="tConsAnnoElettricoRinnovLbl"
	  >


<!-- widget tConsAnnoElettricoRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.consumiReali.annoElettricoRinnov" id="widg_tConsAnnoElettricoRinnov"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tConsAnnoElettricoRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tConsMedioTermico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tConsMedioTermico.label')}" labelFor="widg_tConsMedioTermico" errorFor="appDatacertificato.consumiReali.medioTermico" labelId="tConsMedioTermicoLbl"
	  >


<!-- widget tConsMedioTermico -->
<s:textfield 
	
	
	name="appDatacertificato.consumiReali.medioTermico" id="widg_tConsMedioTermico"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tConsMedioTermico')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tConsMedioElettrico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tConsMedioElettrico.label')}" labelFor="widg_tConsMedioElettrico" errorFor="appDatacertificato.consumiReali.medioElettrico" labelId="tConsMedioElettricoLbl"
	  >


<!-- widget tConsMedioElettrico -->
<s:textfield 
	
	
	name="appDatacertificato.consumiReali.medioElettrico" id="widg_tConsMedioElettrico"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tConsMedioElettrico')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtConsumi --></div>

			
	
	<div id="p_pDtConsumiNav" class="commandPanelBlock"><!-- startFragment:p_pDtConsumiNav -->
	
	
<div class="commandPanel navigation" id="pDtConsumiNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtConsumiIndietro')" >

	



<!-- widget bDtConsumiIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtConsumiIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtConsumiIndietro" id="widg_bDtConsumiIndietro" method="handleBDtConsumiIndietro_CLICKED"
	key="cpCompilaz.bDtConsumiIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtConsumiIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtConsumiAvanti')" >

	



<!-- widget bDtConsumiAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtConsumiAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtConsumiAvanti" id="widg_bDtConsumiAvanti" method="handleBDtConsumiAvanti_CLICKED"
	key="cpCompilaz.bDtConsumiAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtConsumiAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtConsumiNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiConsumi --></div>
