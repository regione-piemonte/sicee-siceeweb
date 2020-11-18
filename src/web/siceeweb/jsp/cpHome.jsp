<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpHome -->

<s:form id="cpHome" action="cpHome" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpHome_pUserInfoCustomHome.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpHome','menu')" >

	


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
				<h3><s:text name="cpHome.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrDtAnag" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtAnag -->
	
	
<div class="stdMessagePanel" id="pErrDtAnag">
	<customtag:stdMessagePanel id="pErrDtAnag" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtAnag --></div>

			
	
	
<s:include value="/jsp/userpanels/cpHome_pHome.jsp"></s:include>

	



			
	
	<div id="p_cpStampa" class="commandPanelBlock"><!-- startFragment:p_cpStampa -->
	
	
<div class="commandPanel functional" id="cpStampa">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpHome','btCreaApeJasper')" >

	



<!-- widget btCreaApeJasper -->
<s:submit name="widg_btCreaApeJasper" id="widg_btCreaApeJasper" method="handleBtCreaApeJasper_CLICKED"
	key="cpHome.btCreaApeJasper.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpHome','btCreaApeJasper')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpHome','btRiportaBozza')" >

	



<!-- widget btRiportaBozza -->
<s:submit name="widg_btRiportaBozza" id="widg_btRiportaBozza" method="handleBtRiportaBozza_CLICKED"
	key="cpHome.btRiportaBozza.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btRiportaBozza')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpHome','btCompletaSw')" >

	



<!-- widget btCompletaSw -->
<s:submit name="widg_btCompletaSw" id="widg_btCompletaSw" method="handleBtCompletaSw_CLICKED"
	key="cpHome.btCompletaSw.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btCompletaSw')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpHome','btEstrapolaSw')" >

	



<!-- widget btEstrapolaSw -->
<s:submit name="widg_btEstrapolaSw" id="widg_btEstrapolaSw" method="handleBtEstrapolaSw_CLICKED"
	key="cpHome.btEstrapolaSw.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btEstrapolaSw')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpHome','btEffettuaCalcoli')" >

	



<!-- widget btEffettuaCalcoli -->
<s:submit name="widg_btEffettuaCalcoli" id="widg_btEffettuaCalcoli" method="handleBtEffettuaCalcoli_CLICKED"
	key="cpHome.btEffettuaCalcoli.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btEffettuaCalcoli')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpHome','btEffettuaArchivia')" >

	



<!-- widget btEffettuaArchivia -->
<s:submit name="widg_btEffettuaArchivia" id="widg_btEffettuaArchivia" method="handleBtEffettuaArchivia_CLICKED"
	key="cpHome.btEffettuaArchivia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btEffettuaArchivia')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpStampa --></div>

	

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
