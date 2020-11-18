<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpTransazAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestcertificatore -->
<!-- pageId:cpTransaz -->

<s:form id="cpTransaz" action="cpTransaz" namespace="/base/gestcertificatore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpTransaz_pUserInfoCustomRegistraz.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpTransaz','menu')" >

	


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
				<h3><s:text name="cpTransaz.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizTransaz" class="wizardPanelBlock"><!-- startFragment:p_pWizTransaz -->
	
	
<div class="wizardPanel" id="pWizTransaz">
	<ol>
		<s:url id="cpTransaz_pWizTransaz_pRegistrazCert_URL" action="cpTransaz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpTransaz_pWizTransaz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpTransaz_pWizTransaz_pRegistrazCert'}" />
		</s:url>
		<s:if test="%{#session.cpTransaz_pWizTransaz_selectedMultiPanel == 'cpTransaz_pWizTransaz_pRegistrazCert' || #session.cpTransaz_pWizTransaz_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">1. <s:text name="cpTransaz.pRegistrazCert.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">

	<csiuicore:ajaxify id="p_pWizTransaz" 
		widgetType="button" 
		requestUri="/siceeweb/base/gestcertificatore/cpTransaz!handle_CpTransaz_PWizTransaz_PRegistrazCert_CLICKED.do" 
		pageId="cpTransaz" 
		formName="cpTransaz"
		javascriptDetection="false">
    	<s:submit name="tsTransaz"
		          id="tsTransaz_pRegistrazCert"
		          method="handle_CpTransaz_PWizTransaz_PRegistrazCert_CLICKED"
		          key="cpTransaz.pRegistrazCert.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="cpTransaz_pWizTransaz_pAcquistoAce_URL" action="cpTransaz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpTransaz_pWizTransaz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpTransaz_pWizTransaz_pAcquistoAce'}" />
		</s:url>
		<s:if test="%{#session.cpTransaz_pWizTransaz_selectedMultiPanel == 'cpTransaz_pWizTransaz_pAcquistoAce'}">
	<li class="item-2 active"><span class="activeItem">2. <s:text name="cpTransaz.pAcquistoAce.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">

	<csiuicore:ajaxify id="p_pWizTransaz" 
		widgetType="button" 
		requestUri="/siceeweb/base/gestcertificatore/cpTransaz!handle_CpTransaz_PWizTransaz_PAcquistoAce_CLICKED.do" 
		pageId="cpTransaz" 
		formName="cpTransaz"
		javascriptDetection="false">
    	<s:submit name="tsTransaz"
		          id="tsTransaz_pAcquistoAce"
		          method="handle_CpTransaz_PWizTransaz_PAcquistoAce_CLICKED"
		          key="cpTransaz.pAcquistoAce.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="cpTransaz_pWizTransaz_pAcquistoCrediti_URL" action="cpTransaz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpTransaz_pWizTransaz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpTransaz_pWizTransaz_pAcquistoCrediti'}" />
		</s:url>
		<s:if test="%{#session.cpTransaz_pWizTransaz_selectedMultiPanel == 'cpTransaz_pWizTransaz_pAcquistoCrediti'}">
	<li class="item-3 active"><span class="activeItem">3. <s:text name="cpTransaz.pAcquistoCrediti.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3">

	<csiuicore:ajaxify id="p_pWizTransaz" 
		widgetType="button" 
		requestUri="/siceeweb/base/gestcertificatore/cpTransaz!handle_CpTransaz_PWizTransaz_PAcquistoCrediti_CLICKED.do" 
		pageId="cpTransaz" 
		formName="cpTransaz"
		javascriptDetection="false">
    	<s:submit name="tsTransaz"
		          id="tsTransaz_pAcquistoCrediti"
		          method="handle_CpTransaz_PWizTransaz_PAcquistoCrediti_CLICKED"
		          key="cpTransaz.pAcquistoCrediti.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpTransaz_pWizTransaz_selectedMultiPanel == 'cpTransaz_pWizTransaz_pRegistrazCert' || #session.cpTransaz_pWizTransaz_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpTransaz_pWizTransaz_pRegistrazCert.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpTransaz_pWizTransaz_selectedMultiPanel == 'cpTransaz_pWizTransaz_pAcquistoAce'">
	<s:include value="/jsp/wizardpanels/cpTransaz_pWizTransaz_pAcquistoAce.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpTransaz_pWizTransaz_selectedMultiPanel == 'cpTransaz_pWizTransaz_pAcquistoCrediti'">
	<s:include value="/jsp/wizardpanels/cpTransaz_pWizTransaz_pAcquistoCrediti.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_pWizTransaz --></div>
	</div>

	

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
