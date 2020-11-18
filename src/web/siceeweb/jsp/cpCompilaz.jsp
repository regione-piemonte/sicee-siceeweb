<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestati/CpCompilazAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/compilazattestati -->
<!-- pageId:cpCompilaz -->

<s:form id="cpCompilaz" action="cpCompilaz" namespace="/base/compilazattestati" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpCompilaz_pUserInfoCustomRegistraz.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpCompilaz','menu')" >

	


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
				<h3><s:text name="cpCompilaz.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizCompilazLiv1" class="wizardPanelBlock"><!-- startFragment:p_pWizCompilazLiv1 -->
	
	
<div class="wizardPanel" id="pWizCompilazLiv1">
	<ol>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiAnagImmobile_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiAnagImmobile'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiAnagImmobile' || #session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">1. <s:text name="cpCompilaz.pDatiAnagImmobile.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1"><span class="wizardItem">1. <s:text name="cpCompilaz.pDatiAnagImmobile.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiTecnici_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiTecnici'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiTecnici'}">
	<li class="item-2 active"><span class="activeItem">2. <s:text name="cpCompilaz.pDatiTecnici.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2"><span class="wizardItem">2. <s:text name="cpCompilaz.pDatiTecnici.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiFabbisogno_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiFabbisogno'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiFabbisogno'}">
	<li class="item-3 active"><span class="activeItem">3. <s:text name="cpCompilaz.pDatiFabbisogno.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3"><span class="wizardItem">3. <s:text name="cpCompilaz.pDatiFabbisogno.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiClEnerg_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiClEnerg'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiClEnerg'}">
	<li class="item-4 active"><span class="activeItem">4. <s:text name="cpCompilaz.pDatiClEnerg.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-4"><span class="wizardItem">4. <s:text name="cpCompilaz.pDatiClEnerg.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiFontiRinnov_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiFontiRinnov'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiFontiRinnov'}">
	<li class="item-5 active"><span class="activeItem">5. <s:text name="cpCompilaz.pDatiFontiRinnov.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-5"><span class="wizardItem">5. <s:text name="cpCompilaz.pDatiFontiRinnov.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiAltreInfo_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiAltreInfo'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiAltreInfo'}">
	<li class="item-6 active"><span class="activeItem">6. <s:text name="cpCompilaz.pDatiAltreInfo.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-6"><span class="wizardItem">6. <s:text name="cpCompilaz.pDatiAltreInfo.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiNormative_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiNormative'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiNormative'}">
	<li class="item-7 active"><span class="activeItem">7. <s:text name="cpCompilaz.pDatiNormative.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-7"><span class="wizardItem">7. <s:text name="cpCompilaz.pDatiNormative.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiImpianti_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiImpianti'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiImpianti'}">
	<li class="item-8 active"><span class="activeItem">8. <s:text name="cpCompilaz.pDatiImpianti.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-8"><span class="wizardItem">8. <s:text name="cpCompilaz.pDatiImpianti.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiGasSerra_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiGasSerra'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiGasSerra'}">
	<li class="item-9 active"><span class="activeItem">9. <s:text name="cpCompilaz.pDatiGasSerra.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-9"><span class="wizardItem">9. <s:text name="cpCompilaz.pDatiGasSerra.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiConsumi_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiConsumi'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiConsumi'}">
	<li class="item-10 active"><span class="activeItem">10. <s:text name="cpCompilaz.pDatiConsumi.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-10"><span class="wizardItem">10. <s:text name="cpCompilaz.pDatiConsumi.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiDichiaraz_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiDichiaraz'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiDichiaraz'}">
	<li class="item-11 active"><span class="activeItem">11. <s:text name="cpCompilaz.pDatiDichiaraz.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-11"><span class="wizardItem">11. <s:text name="cpCompilaz.pDatiDichiaraz.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pDatiFoto_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pDatiFoto'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiFoto'}">
	<li class="item-12 active"><span class="activeItem">12. <s:text name="cpCompilaz.pDatiFoto.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-12"><span class="wizardItem">12. <s:text name="cpCompilaz.pDatiFoto.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizCompilazLiv1_pStampaCertitificato_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizCompilazLiv1_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizCompilazLiv1_pStampaCertitificato'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pStampaCertitificato'}">
	<li class="item-13 active"><span class="activeItem">13. <s:text name="cpCompilaz.pStampaCertitificato.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-13"><span class="wizardItem">13. <s:text name="cpCompilaz.pStampaCertitificato.label" /></span><span class="separator"> | </span></li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiAnagImmobile' || #session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiAnagImmobile.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiTecnici'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiTecnici.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiFabbisogno'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiFabbisogno.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiClEnerg'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiClEnerg.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiFontiRinnov'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiFontiRinnov.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiAltreInfo'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiAltreInfo.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiNormative'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiNormative.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiImpianti'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiImpianti.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiGasSerra'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiGasSerra.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiConsumi'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiConsumi.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiDichiaraz'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiDichiaraz.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pDatiFoto'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pDatiFoto.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizCompilazLiv1_selectedMultiPanel == 'cpCompilaz_pWizCompilazLiv1_pStampaCertitificato'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizCompilazLiv1_pStampaCertitificato.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_pWizCompilazLiv1 --></div>
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
