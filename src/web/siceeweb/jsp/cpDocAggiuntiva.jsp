<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestattestati/CpDocAggiuntivaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpDocAggiuntiva -->

<s:form id="cpDocAggiuntiva" action="cpDocAggiuntiva" namespace="/base/gestattestati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDocAggiuntiva_pUserInfoCustomGestACE.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpDocAggiuntiva','menu')" >

	


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
				<h3><s:text name="cpDocAggiuntiva.pDocAggiuntiva.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpDocAggiuntiva" class="formPanelBlock"><!-- startFragment:p_fpDocAggiuntiva -->
		
	
<div class="formPanel" id="fpDocAggiuntiva">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpDocAggiuntiva" class="widgetsPanelBlock"><!-- startFragment:p_wpDocAggiuntiva -->
	
	

<div class="widgetsPanel" id="wpDocAggiuntiva">
	

	
	
<s:if test="isWidgetVisible('cpDocAggiuntiva','tblDocAggiuntiva')" >

	
<div class="tableWidget">


<!-- widget tblDocAggiuntiva -->
<s:set name="cpDocAggiuntiva_tblDocAggiuntiva_clearStatus" value="isTableClearStatus('cpDocAggiuntiva_tblDocAggiuntiva')" />
<s:url id="cpDocAggiuntivaViewUrl"						   
					   action="cpDocAggiuntiva"
					   namespace="/base/gestattestati"/>
<display:table name="appDatalistDocumentazioneAggiuntiva"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDocAggiuntiva"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpDocAggiuntivaViewUrl}"  
               clearStatus="${cpDocAggiuntiva_tblDocAggiuntiva_clearStatus}"
               uid="row_tblDocAggiuntiva"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.gestattestati.CpDocAggiuntivaTblDocAggiuntivaCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblDocAggiuntiva.id}" name="appDataidDocumentoSelezionato" id="%{'tblDocAggiuntiva-editcell-'+ (#attr.row_tblDocAggiuntiva_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="nomeDocumento" titleKey="cpDocAggiuntiva.tblDocAggiuntiva.nomeDocumento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipoDocumento" titleKey="cpDocAggiuntiva.tblDocAggiuntiva.tipoDocumento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpDocAggiuntiva.tblDocAggiuntiva.dataUpload.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="statoDocumento" titleKey="cpDocAggiuntiva.tblDocAggiuntiva.statoDocumento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDocAggiuntiva --></div>

			
	
	<div id="p_pDocAggiuntivaNav" class="commandPanelBlock"><!-- startFragment:p_pDocAggiuntivaNav -->
	
	
<div class="commandPanel navigation" id="pDocAggiuntivaNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDocAggiuntiva','bVisualizzaDocumento')" >

	



<!-- widget bVisualizzaDocumento -->
<s:submit name="widg_bVisualizzaDocumento" id="widg_bVisualizzaDocumento" method="handleBVisualizzaDocumento_CLICKED"
	key="cpDocAggiuntiva.bVisualizzaDocumento.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDocAggiuntiva','bVisualizzaDocumento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDocAggiuntiva','bInsertDoc')" >

	



<!-- widget bInsertDoc -->
<s:submit name="widg_bInsertDoc" id="widg_bInsertDoc" method="handleBInsertDoc_CLICKED"
	key="cpDocAggiuntiva.bInsertDoc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDocAggiuntiva','bInsertDoc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDocAggiuntiva','bDeleteDoc')" >

	



<!-- widget bDeleteDoc -->
<s:submit name="widg_bDeleteDoc" id="widg_bDeleteDoc" method="handleBDeleteDoc_CLICKED"
	key="cpDocAggiuntiva.bDeleteDoc.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDocAggiuntiva','bDeleteDoc')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDocAggiuntivaNav --></div>

			
	
	<div id="p_indietroNav" class="commandPanelBlock"><!-- startFragment:p_indietroNav -->
	
	
<div class="commandPanel navigation" id="indietroNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDocAggiuntiva','bBack')" >

	



<!-- widget bBack -->
<s:submit name="widg_bBack" id="widg_bBack" method="handleBBack_CLICKED"
	key="cpDocAggiuntiva.bBack.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDocAggiuntiva','bBack')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_indietroNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDocAggiuntiva --></div>

	

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
