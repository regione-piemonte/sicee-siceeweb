<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpTransazAnomaleAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestcertificatore -->
<!-- pageId:cpTransazAnomale -->

<s:form id="cpTransazAnomale" action="cpTransazAnomale" namespace="/base/gestcertificatore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpTransazAnomale_pUserInfoCustomRegistraz.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpTransazAnomale','menu')" >

	


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
				<h3><s:text name="cpTransazAnomale.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizTransaz" class="wizardPanelBlock"><!-- startFragment:p_pWizTransaz -->
	
	
<div class="wizardPanel" id="pWizTransaz">
	<ol>
		<s:url id="cpTransazAnomale_pWizTransaz_pRegistrazCert_URL" action="cpTransazAnomale" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpTransazAnomale_pWizTransaz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpTransazAnomale_pWizTransaz_pRegistrazCert'}" />
		</s:url>
		<s:if test="%{#session.cpTransazAnomale_pWizTransaz_selectedMultiPanel == 'cpTransazAnomale_pWizTransaz_pRegistrazCert' || #session.cpTransazAnomale_pWizTransaz_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">1. <s:text name="cpTransazAnomale.pRegistrazCert.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">
		<s:a href="%{cpTransazAnomale_pWizTransaz_pRegistrazCert_URL}">1. <s:text name="cpTransazAnomale.pRegistrazCert.label" /></s:a><span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="cpTransazAnomale_pWizTransaz_pAcquistoAce_URL" action="cpTransazAnomale" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpTransazAnomale_pWizTransaz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpTransazAnomale_pWizTransaz_pAcquistoAce'}" />
		</s:url>
		<s:if test="%{#session.cpTransazAnomale_pWizTransaz_selectedMultiPanel == 'cpTransazAnomale_pWizTransaz_pAcquistoAce'}">
	<li class="item-2 active"><span class="activeItem">2. <s:text name="cpTransazAnomale.pAcquistoAce.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">
		<s:a href="%{cpTransazAnomale_pWizTransaz_pAcquistoAce_URL}">2. <s:text name="cpTransazAnomale.pAcquistoAce.label" /></s:a><span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpTransazAnomale_pWizTransaz_selectedMultiPanel == 'cpTransazAnomale_pWizTransaz_pRegistrazCert' || #session.cpTransazAnomale_pWizTransaz_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpTransazAnomale_pWizTransaz_pRegistrazCert.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpTransazAnomale_pWizTransaz_selectedMultiPanel == 'cpTransazAnomale_pWizTransaz_pAcquistoAce'">
	<s:include value="/jsp/wizardpanels/cpTransazAnomale_pWizTransaz_pAcquistoAce.jsp" ></s:include>
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
