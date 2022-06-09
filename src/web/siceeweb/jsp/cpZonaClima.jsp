<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/compilazattestatiape -->
<!-- pageId:cpZonaClima -->

<s:form id="cpZonaClima" action="cpZonaClima" namespace="/base/compilazattestatiape" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpZonaClima_pUserInfoCustomGestACE.jsp"></s:include>

	



	

	<!-- endFragment:p_pUp --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pLeft" class="formPanelBlock"><!-- startFragment:p_pLeft -->

	
	

	
	
			
	
	<div id="p_pMenu" class="menuPanelBlock"><!-- startFragment:p_pMenu -->
	
	
<div class="menuPanel vertical" id="pMenu">

	
		
			
<s:if test="isWidgetVisible('cpZonaClima','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_pMenu --></div>

	

	<!-- endFragment:p_pLeft --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpZonaClima.pZonaClima.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pWZonaClima" class="widgetsPanelBlock"><!-- startFragment:p_pWZonaClima -->
	
	
<h4 class="wpLabel">Comune che ricade su pi&ugrave; zone climatiche </h4>
<div class="widgetsPanel" id="pWZonaClima">
	
	<customtag:widgetsPanel id="pWZonaClimaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpZonaClima','cbZonaClima')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpZonaClima.cbZonaClima.label')}" labelFor="widg_cbZonaClima" errorFor="appDatadescZonaClima" labelId="cbZonaClimaLbl"
	  >


<!-- widget cbZonaClima -->
<s:select name="appDatadescZonaClima" id="widg_cbZonaClima"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatalistZoneClima"
	  disabled="isWidgetDisabled('cpZonaClima','cbZonaClima')"
	  listKey="value"
	  listValue="label"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pWZonaClima --></div>

			
	
	<div id="p_fpZonaClima" class="formPanelBlock"><!-- startFragment:p_fpZonaClima -->
		
	
<div class="formPanel" id="fpZonaClima">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_pZonaClimaNav" class="commandPanelBlock"><!-- startFragment:p_pZonaClimaNav -->
	
	
<div class="commandPanel navigation" id="pZonaClimaNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpZonaClima','bSalvaZonaClima')" >

	



<!-- widget bSalvaZonaClima -->
<s:submit name="widg_bSalvaZonaClima" id="widg_bSalvaZonaClima" method="handleBSalvaZonaClima_CLICKED"
	key="cpZonaClima.bSalvaZonaClima.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpZonaClima','bSalvaZonaClima')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pZonaClimaNav --></div>

			
	
	<div id="p_indietroNav" class="commandPanelBlock"><!-- startFragment:p_indietroNav -->
	
	
<div class="commandPanel navigation" id="indietroNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpZonaClima','bBack')" >

	



<!-- widget bBack -->
<s:submit name="widg_bBack" id="widg_bBack" method="handleBBack_CLICKED"
	key="cpZonaClima.bBack.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpZonaClima','bBack')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_indietroNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpZonaClima --></div>

	

	<!-- endFragment:p_pCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
