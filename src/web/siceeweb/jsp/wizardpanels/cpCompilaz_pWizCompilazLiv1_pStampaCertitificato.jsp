<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pStampaCertitificato" class="formPanelBlock"><!-- startFragment:p_pStampaCertitificato -->
		
	
<div class="formPanel" id="pStampaCertitificato">


	
	

	
	
			
	
<div id="p_msgStampa" class="msgBoxPanelBlock"><!-- startFragment:p_msgStampa -->

		
<s:if test="isWidgetVisible('cpCompilaz','txtVisualizzaBozza')" >

	
<p>


<!-- widget txtVisualizzaBozza -->
<s:text name="cpCompilaz.txtVisualizzaBozza.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpCompilaz','txtDettVisualizzaBozza')" >

	
<p>


<!-- widget txtDettVisualizzaBozza -->
<s:text name="cpCompilaz.txtDettVisualizzaBozza.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpCompilaz','txtSpace')" >

	
<p>


<!-- widget txtSpace -->
<s:text name="cpCompilaz.txtSpace.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpCompilaz','txtVisualizzaDefinitivo')" >

	
<p>


<!-- widget txtVisualizzaDefinitivo -->
<s:text name="cpCompilaz.txtVisualizzaDefinitivo.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpCompilaz','txtDettVisualizzaDefinitivo')" >

	
<p>


<!-- widget txtDettVisualizzaDefinitivo -->
<s:text name="cpCompilaz.txtDettVisualizzaDefinitivo.statictext.label" />

	
</p>

</s:if>

	

<!-- endFragment:p_msgStampa --></div>

			
	
	<div id="p_pDtStampa" class="commandPanelBlock"><!-- startFragment:p_pDtStampa -->
	
	
<div class="commandPanel functional" id="pDtStampa">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','btStampaBozza')" >

	



<!-- widget btStampaBozza -->
<s:submit name="widg_btStampaBozza" id="widg_btStampaBozza" method="handleBtStampaBozza_CLICKED"
	key="cpCompilaz.btStampaBozza.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpCompilaz','btStampaBozza')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','btStampaDefinitiva')" >

	



<!-- widget btStampaDefinitiva -->
<s:submit name="widg_btStampaDefinitiva" id="widg_btStampaDefinitiva" method="handleBtStampaDefinitiva_CLICKED"
	key="cpCompilaz.btStampaDefinitiva.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpCompilaz','btStampaDefinitiva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtStampa --></div>

			
	
	<div id="p_pDtStampaNav" class="commandPanelBlock"><!-- startFragment:p_pDtStampaNav -->
	
	
<div class="commandPanel navigation" id="pDtStampaNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtStampaIndietro')" >

	



<!-- widget bDtStampaIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtStampaIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtStampaIndietro" id="widg_bDtStampaIndietro" method="handleBDtStampaIndietro_CLICKED"
	key="cpCompilaz.bDtStampaIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtStampaIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtStampaAvanti')" >

	



<!-- widget bDtStampaAvanti -->
<s:submit name="widg_bDtStampaAvanti" id="widg_bDtStampaAvanti" method="handleBDtStampaAvanti_CLICKED"
	key="cpCompilaz.bDtStampaAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtStampaAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtStampaNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pStampaCertitificato --></div>
