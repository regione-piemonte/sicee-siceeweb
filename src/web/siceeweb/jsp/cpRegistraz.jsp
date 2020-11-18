<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpRegistrazAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestcertificatore -->
<!-- pageId:cpRegistraz -->

<s:form id="cpRegistraz" action="cpRegistraz" namespace="/base/gestcertificatore" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRegistraz_pUserInfoCustomRegistraz.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRegistraz','menu')" >

	


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
				<h3><s:text name="cpRegistraz.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizRegistraz" class="wizardPanelBlock"><!-- startFragment:p_pWizRegistraz -->
	
	
<div class="wizardPanel" id="pWizRegistraz">
	<ol>
		<s:url id="cpRegistraz_pWizRegistraz_pDatiAnag_URL" action="cpRegistraz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRegistraz_pWizRegistraz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRegistraz_pWizRegistraz_pDatiAnag'}" />
		</s:url>
		<s:if test="%{#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pDatiAnag' || #session.cpRegistraz_pWizRegistraz_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">1. <s:text name="cpRegistraz.pDatiAnag.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1"><span class="wizardItem">1. <s:text name="cpRegistraz.pDatiAnag.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpRegistraz_pWizRegistraz_pResidenza_URL" action="cpRegistraz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRegistraz_pWizRegistraz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRegistraz_pWizRegistraz_pResidenza'}" />
		</s:url>
		<s:if test="%{#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pResidenza'}">
	<li class="item-2 active"><span class="activeItem">2. <s:text name="cpRegistraz.pResidenza.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2"><span class="wizardItem">2. <s:text name="cpRegistraz.pResidenza.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpRegistraz_pWizRegistraz_pStudio_URL" action="cpRegistraz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRegistraz_pWizRegistraz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRegistraz_pWizRegistraz_pStudio'}" />
		</s:url>
		<s:if test="%{#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pStudio'}">
	<li class="item-3 active"><span class="activeItem">3. <s:text name="cpRegistraz.pStudio.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3"><span class="wizardItem">3. <s:text name="cpRegistraz.pStudio.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpRegistraz_pWizRegistraz_pOrdine_URL" action="cpRegistraz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRegistraz_pWizRegistraz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRegistraz_pWizRegistraz_pOrdine'}" />
		</s:url>
		<s:if test="%{#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pOrdine'}">
	<li class="item-4 active"><span class="activeItem">4. <s:text name="cpRegistraz.pOrdine.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-4"><span class="wizardItem">4. <s:text name="cpRegistraz.pOrdine.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpRegistraz_pWizRegistraz_pRiepilogo_URL" action="cpRegistraz" namespace="/base/gestcertificatore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRegistraz_pWizRegistraz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRegistraz_pWizRegistraz_pRiepilogo'}" />
		</s:url>
		<s:if test="%{#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pRiepilogo'}">
	<li class="item-5 active"><span class="activeItem">5. <s:text name="cpRegistraz.pRiepilogo.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-5"><span class="wizardItem">5. <s:text name="cpRegistraz.pRiepilogo.label" /></span><span class="separator"> | </span></li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pDatiAnag' || #session.cpRegistraz_pWizRegistraz_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpRegistraz_pWizRegistraz_pDatiAnag.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pResidenza'">
	<s:include value="/jsp/wizardpanels/cpRegistraz_pWizRegistraz_pResidenza.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pStudio'">
	<s:include value="/jsp/wizardpanels/cpRegistraz_pWizRegistraz_pStudio.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pOrdine'">
	<s:include value="/jsp/wizardpanels/cpRegistraz_pWizRegistraz_pOrdine.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpRegistraz_pWizRegistraz_selectedMultiPanel == 'cpRegistraz_pWizRegistraz_pRiepilogo'">
	<s:include value="/jsp/wizardpanels/cpRegistraz_pWizRegistraz_pRiepilogo.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_pWizRegistraz --></div>
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
