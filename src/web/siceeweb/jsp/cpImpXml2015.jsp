<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/compilazattestatiape -->
<!-- pageId:cpImpXml2015 -->

<s:form id="cpImpXml2015" action="cpImpXml2015" namespace="/base/compilazattestatiape" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpImpXml2015_pUserInfoCustomHome.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpImpXml2015','menu')" >

	


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
				<h3><s:text name="cpImpXml2015.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pMessagePanel" class="stdMessagePanelBlock"><!-- startFragment:p_pMessagePanel -->
	
	
<div class="stdMessagePanel" id="pMessagePanel">
	<customtag:stdMessagePanel id="pMessagePanel" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pMessagePanel --></div>

			
	
	<div id="p_pDati" class="widgetsPanelBlock"><!-- startFragment:p_pDati -->
	
	

<div class="widgetsPanel" id="pDati">
	
	<customtag:widgetsPanel id="pDatiTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpImpXml2015','fileCarica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpImpXml2015.fileCarica.label')}" labelFor="widg_fileCarica" errorFor="widg_fileCarica" labelId="fileCaricaLbl"
	position="first"  >


<s:file 
	
	
	name="widg_fileCarica" id="widg_fileCarica"
	disabled="isWidgetDisabled('cpImpXml2015','fileCarica')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpImpXml2015','btnCaricaXmlRO')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCaricaXmlRO -->
<s:submit name="widg_btnCaricaXmlRO" id="widg_btnCaricaXmlRO" method="handleBtnCaricaXmlRO_CLICKED"
	key="cpImpXml2015.btnCaricaXmlRO.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImpXml2015','btnCaricaXmlRO')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpImpXml2015','btnCaricaXml')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCaricaXml -->
<s:submit name="widg_btnCaricaXml" id="widg_btnCaricaXml" method="handleBtnCaricaXml_CLICKED"
	key="cpImpXml2015.btnCaricaXml.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImpXml2015','btnCaricaXml')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDati --></div>

			
	
	<div id="p_cpNavigazione" class="commandPanelBlock"><!-- startFragment:p_cpNavigazione -->
	
	
<div class="commandPanel navigation" id="cpNavigazione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpImpXml2015','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpImpXml2015.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImpXml2015','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpImpXml2015','btnConferma')" >

	



<!-- widget btnConferma -->
<s:submit name="widg_btnConferma" id="widg_btnConferma" method="handleBtnConferma_CLICKED"
	key="cpImpXml2015.btnConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImpXml2015','btnConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavigazione --></div>

	

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
