<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpRobot -->

<s:form id="cpRobot" action="cpRobot" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpRobot.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pRobotPanel" class="formPanelBlock"><!-- startFragment:p_pRobotPanel -->
		
	
<h4 class="fpLabel"><s:text name="cpRobot.pRobotPanel.label" /></h4>
<div class="formPanel" id="pRobotPanel">


	
	

	
	
			
	
	<div id="p_cpRobotFunc" class="commandPanelBlock"><!-- startFragment:p_cpRobotFunc -->
	
	
<div class="commandPanel functional" id="cpRobotFunc">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRobot','bRobot')" >

	



<!-- widget bRobot -->
<s:submit name="widg_bRobot" id="widg_bRobot" method="handleBRobot_CLICKED"
	key="cpRobot.bRobot.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRobot','bRobot')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpRobotFunc --></div>

	

		
	
</div>

	<!-- endFragment:p_pRobotPanel --></div>

	

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
