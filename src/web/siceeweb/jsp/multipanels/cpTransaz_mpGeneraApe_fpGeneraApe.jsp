<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpGeneraApe" class="formPanelBlock"><!-- startFragment:p_fpGeneraApe -->
		
	
<div class="formPanel" id="fpGeneraApe">


	
	

	
	
			
	
	<div id="p_wpGenApe" class="widgetsPanelBlock"><!-- startFragment:p_wpGenApe -->
	
	

<div class="widgetsPanel" id="wpGenApe">
	
	<customtag:widgetsPanel id="wpGenApeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpTransaz','ptCostoSingolo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransaz.ptCostoSingolo.label')}" labelFor="widg_ptCostoSingolo" errorFor="appDatagestioneCreditoNew.importoApe" labelId="ptCostoSingoloLbl"   tdStyleClass="numbers">


<!-- widget ptCostoSingolo -->
<s:property value="appDatagestioneCreditoNew.importoApe" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransaz','tfNumApe')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransaz.tfNumApe.label')}" labelFor="widg_tfNumApe" errorFor="appDatagestioneCreditoNew.numeroApe" labelId="tfNumApeLbl"
	  >


<!-- widget tfNumApe -->
<s:textfield 
	
	
	name="appDatagestioneCreditoNew.numeroApe" id="widg_tfNumApe"
maxlength="3"	disabled="isWidgetDisabled('cpTransaz','tfNumApe')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGenApe --></div>

			
	
	<div id="p_cpGeneraApeFun" class="commandPanelBlock"><!-- startFragment:p_cpGeneraApeFun -->
	
	
<div class="commandPanel functional" id="cpGeneraApeFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpTransaz','bAnnullaGeneraApe')" >

	



<!-- widget bAnnullaGeneraApe -->
<s:submit name="widg_bAnnullaGeneraApe" id="widg_bAnnullaGeneraApe" method="handleBAnnullaGeneraApe_CLICKED"
	key="cpTransaz.bAnnullaGeneraApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransaz','bAnnullaGeneraApe')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransaz','bConfGeneraApe')" >

	



<!-- widget bConfGeneraApe -->
<s:submit name="widg_bConfGeneraApe" id="widg_bConfGeneraApe" method="handleBConfGeneraApe_CLICKED"
	key="cpTransaz.bConfGeneraApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransaz','bConfGeneraApe')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpGeneraApeFun --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGeneraApe --></div>
