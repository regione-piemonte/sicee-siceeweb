<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/monitoraggio -->
<!-- pageId:cpMonitoraggio -->

<s:form id="cpMonitoraggio" action="cpMonitoraggio" namespace="/base/monitoraggio" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pLeftMenu" class="formPanelBlock"><!-- startFragment:p_pLeftMenu -->

	
	

	
	
			
	
	<div id="p_pMenu" class="menuPanelBlock"><!-- startFragment:p_pMenu -->
	
	
<div class="menuPanel vertical" id="pMenu">

	
		
			
<s:if test="isWidgetVisible('cpMonitoraggio','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_pMenu --></div>

	

	<!-- endFragment:p_pLeftMenu --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpMonitoraggio.pMain.label" /></h3>

					
	
	<div id="p_pVerifica" class="formPanelBlock"><!-- startFragment:p_pVerifica -->

	
	

	
	
			
	
	<div id="p_pErrMonitoraggio" class="stdMessagePanelBlock"><!-- startFragment:p_pErrMonitoraggio -->
	
	
<div class="stdMessagePanel" id="pErrMonitoraggio">
	<customtag:stdMessagePanel id="pErrMonitoraggio" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrMonitoraggio --></div>

			
	
	<div id="p_pDatabase" class="widgetsPanelBlock"><!-- startFragment:p_pDatabase -->
	
	
<h4 class="wpLabel">Verifica Database </h4>
<div class="widgetsPanel" id="pDatabase">
	
	<customtag:widgetsPanel id="pDatabaseTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="50,50">
	

	
	
<s:if test="isWidgetVisible('cpMonitoraggio','txtKoDatabase')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpMonitoraggio.txtKoDatabase.label')}" labelFor="widg_txtKoDatabase" errorFor="widg_txtKoDatabase" labelId="txtKoDatabaseLbl"   >


<!-- widget txtKoDatabase -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpMonitoraggio','cbTitoliMonitoraggio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpMonitoraggio.cbTitoliMonitoraggio.label')}" labelFor="widg_cbTitoliMonitoraggio" errorFor="widg_cbTitoliMonitoraggio" labelId="cbTitoliMonitoraggioLbl"
	  >


<!-- widget cbTitoliMonitoraggio -->
<s:select name="widg_cbTitoliMonitoraggio" id="widg_cbTitoliMonitoraggio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatitoliMonitoraggio"
	  disabled="isWidgetDisabled('cpMonitoraggio','cbTitoliMonitoraggio')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatabase --></div>

			
	
	<div id="p_pTavt" class="widgetsPanelBlock"><!-- startFragment:p_pTavt -->
	
	
<h4 class="wpLabel">Verifica TAVT </h4>
<div class="widgetsPanel" id="pTavt">
	
	<customtag:widgetsPanel id="pTavtTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="40,60">
	

	
	
<s:if test="isWidgetVisible('cpMonitoraggio','txtKoTavt')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpMonitoraggio.txtKoTavt.label')}" labelFor="widg_txtKoTavt" errorFor="widg_txtKoTavt" labelId="txtKoTavtLbl"   >


<!-- widget txtKoTavt -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpMonitoraggio','cbProvinceMonitoraggio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpMonitoraggio.cbProvinceMonitoraggio.label')}" labelFor="widg_cbProvinceMonitoraggio" errorFor="widg_cbProvinceMonitoraggio" labelId="cbProvinceMonitoraggioLbl"
	  >


<!-- widget cbProvinceMonitoraggio -->
<s:select name="widg_cbProvinceMonitoraggio" id="widg_cbProvinceMonitoraggio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceMonitoraggio"
	  disabled="isWidgetDisabled('cpMonitoraggio','cbProvinceMonitoraggio')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pTavt --></div>

			
	
	<div id="p_pTope" class="widgetsPanelBlock"><!-- startFragment:p_pTope -->
	
	
<h4 class="wpLabel">Verifica Toponomastica </h4>
<div class="widgetsPanel" id="pTope">
	
	<customtag:widgetsPanel id="pTopeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="50,50">
	

	
	
<s:if test="isWidgetVisible('cpMonitoraggio','txtKoTope')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpMonitoraggio.txtKoTope.label')}" labelFor="widg_txtKoTope" errorFor="widg_txtKoTope" labelId="txtKoTopeLbl"   >


<!-- widget txtKoTope -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpMonitoraggio','cbIndirizziMonitoraggio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpMonitoraggio.cbIndirizziMonitoraggio.label')}" labelFor="widg_cbIndirizziMonitoraggio" errorFor="widg_cbIndirizziMonitoraggio" labelId="cbIndirizziMonitoraggioLbl"
	  >


<!-- widget cbIndirizziMonitoraggio -->
<s:select name="widg_cbIndirizziMonitoraggio" id="widg_cbIndirizziMonitoraggio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataindirizziMonitoraggio"
	  disabled="isWidgetDisabled('cpMonitoraggio','cbIndirizziMonitoraggio')"
	  
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pTope --></div>

			
	
	<div id="p_pIndex" class="widgetsPanelBlock"><!-- startFragment:p_pIndex -->
	
	
<h4 class="wpLabel">Verifica INDEX </h4>
<div class="widgetsPanel" id="pIndex">
	
	<customtag:widgetsPanel id="pIndexTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="50,50">
	

	
	
<s:if test="isWidgetVisible('cpMonitoraggio','btnScaricaFoto')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnScaricaFoto -->
<s:submit name="widg_btnScaricaFoto" id="widg_btnScaricaFoto" method="handleBtnScaricaFoto_CLICKED"
	key="cpMonitoraggio.btnScaricaFoto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpMonitoraggio','btnScaricaFoto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pIndex --></div>

			
	
	<div id="p_pModol" class="widgetsPanelBlock"><!-- startFragment:p_pModol -->
	
	
<h4 class="wpLabel">Verifica MODOL </h4>
<div class="widgetsPanel" id="pModol">
	
	<customtag:widgetsPanel id="pModolTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="50,50">
	

	
	
<s:if test="isWidgetVisible('cpMonitoraggio','btnScaricaApe')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnScaricaApe -->
<s:submit name="widg_btnScaricaApe" id="widg_btnScaricaApe" method="handleBtnScaricaApe_CLICKED"
	key="cpMonitoraggio.btnScaricaApe.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpMonitoraggio','btnScaricaApe')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pModol --></div>

	

	<!-- endFragment:p_pVerifica --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
