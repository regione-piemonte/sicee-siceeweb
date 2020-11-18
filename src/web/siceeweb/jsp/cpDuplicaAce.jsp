<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestattestati/CpDuplicaAceAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpDuplicaAce -->

<s:form id="cpDuplicaAce" action="cpDuplicaAce" namespace="/base/gestattestati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDuplicaAce_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpDuplicaAce','menu')" >

	


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
				<h3><s:text name="cpDuplicaAce.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrDuplicaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDuplicaAce -->
	
	
<div class="stdMessagePanel" id="pErrDuplicaAce">
	<customtag:stdMessagePanel id="pErrDuplicaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDuplicaAce --></div>

			
	
<div id="p_msgSel" class="msgBoxPanelBlock"><!-- startFragment:p_msgSel -->

		
<s:if test="isWidgetVisible('cpDuplicaAce','txtSelAce')" >

	
<p>


<!-- widget txtSelAce -->
<s:text name="cpDuplicaAce.txtSelAce.statictext.label" />

	
</p>

</s:if>

	

<!-- endFragment:p_msgSel --></div>

			
	
	<div id="p_pMsg" class="widgetsPanelBlock"><!-- startFragment:p_pMsg -->
	
	

<div class="widgetsPanel" id="pMsg">
	
	<customtag:widgetsPanel id="pMsgTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDuplicaAce','txtDuplicaAce')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_txtDuplicaAce" errorFor="widg_txtDuplicaAce" labelId="txtDuplicaAceLbl"   >


<!-- widget txtDuplicaAce -->


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pMsg --></div>

			
	
	<div id="p_pTable" class="widgetsPanelBlock"><!-- startFragment:p_pTable -->
	
	

<div class="widgetsPanel" id="pTable">
	

	
	
<s:if test="isWidgetVisible('cpDuplicaAce','tblNuoviAce')" >

	
<div class="tableWidget">


<!-- widget tblNuoviAce -->
<s:set name="cpDuplicaAce_tblNuoviAce_clearStatus" value="isTableClearStatus('cpDuplicaAce_tblNuoviAce')" />
<s:url id="cpDuplicaAceViewUrl"						   
					   action="cpDuplicaAce"
					   namespace="/base/gestattestati"/>
<display:table name="appDatacertificatiNuovi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblNuoviAce"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpDuplicaAceViewUrl}"  
               clearStatus="${cpDuplicaAce_tblNuoviAce_clearStatus}"
               uid="row_tblNuoviAce"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tblNuoviAce.codice}" name="appDatacodiciAceNuoviSelezionati" id="%{'tblNuoviAce-editcell-'+ (#attr.row_tblNuoviAce_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpDuplicaAce.tblNuoviAce.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>

<s:hidden name="__tableselectionempty_appDatacodiciAceNuoviSelezionati" id="__tableselectionempty_widg_tblNuoviAce" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pTable --></div>

			
	
	<div id="p_pDuplicaAceNav" class="commandPanelBlock"><!-- startFragment:p_pDuplicaAceNav -->
	
	
<div class="commandPanel navigation" id="pDuplicaAceNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDuplicaAce','bDuplicaAceIndietro')" >

	



<!-- widget bDuplicaAceIndietro -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpDuplicaAce!handleBDuplicaAceIndietro_CLICKED.do" 
		
		pageId="cpDuplicaAce" 
		formName="cpDuplicaAce"
		javascriptDetection="false">
<s:submit name="widg_bDuplicaAceIndietro" id="widg_bDuplicaAceIndietro" method="handleBDuplicaAceIndietro_CLICKED"
	key="cpDuplicaAce.bDuplicaAceIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDuplicaAce','bDuplicaAceIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDuplicaAce','bDuplicaAceAvanti')" >

	



<!-- widget bDuplicaAceAvanti -->
<s:submit name="widg_bDuplicaAceAvanti" id="widg_bDuplicaAceAvanti" method="handleBDuplicaAceAvanti_CLICKED"
	key="cpDuplicaAce.bDuplicaAceAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDuplicaAce','bDuplicaAceAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDuplicaAceNav --></div>

	

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
