<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpUploadDocAggiuntiva -->

<s:form id="cpUploadDocAggiuntiva" action="cpUploadDocAggiuntiva" namespace="/base/gestattestati" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpUploadDocAggiuntiva_pUserInfoCustomGestACE.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpUploadDocAggiuntiva','menu')" >

	


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
				<h3><s:text name="cpUploadDocAggiuntiva.pUploadDocAggiuntiva.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pInvioDoc" class="widgetsPanelBlock"><!-- startFragment:p_pInvioDoc -->
	
	
<h4 class="wpLabel">Carica file </h4>
<div class="widgetsPanel" id="pInvioDoc">
	
	<customtag:widgetsPanel id="pInvioDocTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpUploadDocAggiuntiva','fileDocCaricato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpUploadDocAggiuntiva.fileDocCaricato.label')}" labelFor="widg_fileDocCaricato" errorFor="widg_fileDocCaricato" labelId="fileDocCaricatoLbl"
	  >


<s:file 
	
	
	name="widg_fileDocCaricato" id="widg_fileDocCaricato"
	disabled="isWidgetDisabled('cpUploadDocAggiuntiva','fileDocCaricato')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pInvioDoc --></div>

			
	
	<div id="p_pTipoDoc" class="widgetsPanelBlock"><!-- startFragment:p_pTipoDoc -->
	
	
<h4 class="wpLabel">Tipo documento </h4>
<div class="widgetsPanel" id="pTipoDoc">
	
	<customtag:widgetsPanel id="pTipoDocTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpUploadDocAggiuntiva','cbTipoDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpUploadDocAggiuntiva.cbTipoDoc.label')}" labelFor="widg_cbTipoDoc" errorFor="appDataidTipoDocumento" labelId="cbTipoDocLbl"
	  >


<!-- widget cbTipoDoc -->
<s:select name="appDataidTipoDocumento" id="widg_cbTipoDoc"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatalistTipiDoc"
	  disabled="isWidgetDisabled('cpUploadDocAggiuntiva','cbTipoDoc')"
	  listKey="value"
	  listValue="label"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pTipoDoc --></div>

			
	
	<div id="p_fpUploadDocAggiuntiva" class="formPanelBlock"><!-- startFragment:p_fpUploadDocAggiuntiva -->
		
	
<div class="formPanel" id="fpUploadDocAggiuntiva">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_pDocAggiuntivaNav" class="commandPanelBlock"><!-- startFragment:p_pDocAggiuntivaNav -->
	
	
<div class="commandPanel navigation" id="pDocAggiuntivaNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpUploadDocAggiuntiva','bCaricaDocumento')" >

	



<!-- widget bCaricaDocumento -->
<s:submit name="widg_bCaricaDocumento" id="widg_bCaricaDocumento" method="handleBCaricaDocumento_CLICKED"
	key="cpUploadDocAggiuntiva.bCaricaDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpUploadDocAggiuntiva','bCaricaDocumento')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDocAggiuntivaNav --></div>

			
	
	<div id="p_indietroNav" class="commandPanelBlock"><!-- startFragment:p_indietroNav -->
	
	
<div class="commandPanel navigation" id="indietroNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpUploadDocAggiuntiva','bBack')" >

	



<!-- widget bBack -->
<s:submit name="widg_bBack" id="widg_bBack" method="handleBBack_CLICKED"
	key="cpUploadDocAggiuntiva.bBack.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpUploadDocAggiuntiva','bBack')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_indietroNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpUploadDocAggiuntiva --></div>

	

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
