<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiFoto" class="formPanelBlock"><!-- startFragment:p_pDatiFoto -->
		
	
<div class="formPanel" id="pDatiFoto">


	
	

	
	
			
	
	<div id="p_pErrDtFoto" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtFoto -->
	
	
<div class="stdMessagePanel" id="pErrDtFoto">
	<customtag:stdMessagePanel id="pErrDtFoto" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtFoto --></div>

			
	
	<div id="p_pDtCaricaFoto" class="widgetsPanelBlock"><!-- startFragment:p_pDtCaricaFoto -->
	
	

<div class="widgetsPanel" id="pDtCaricaFoto">
	
	<customtag:widgetsPanel id="pDtCaricaFotoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtFoto')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget txtObblDtFoto -->
<s:text name="cpCompilaz.txtObblDtFoto.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtCaricaFoto_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtCaricaFoto_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','fileFotoCatasto')" >

	
<customtag:widgetsPanelColumn 
	position="first" colSpan="4" >


<s:file 
	
	
	name="widg_fileFotoCatasto" id="widg_fileFotoCatasto"
	disabled="isWidgetDisabled('cpCompilaz','fileFotoCatasto')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNomeFoto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtNomeFoto.label')}" labelFor="widg_txtNomeFoto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto" labelId="txtNomeFotoLbl" colSpan="3" position="first" >


<!-- widget txtNomeFoto -->
<s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1Foto')" >

	
<customtag:widgetsPanelColumn  colSpan="4" position="first" >


<!-- widget txtNote1Foto -->
<s:text name="cpCompilaz.txtNote1Foto.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtCaricaFoto --></div>

			
	
	<div id="p_pDtFoto" class="commandPanelBlock"><!-- startFragment:p_pDtFoto -->
	
	
<div class="commandPanel functional" id="pDtFoto">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','btnCaricaFoto')" >

	



<!-- widget btnCaricaFoto -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBtnCaricaFoto_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_btnCaricaFoto" id="widg_btnCaricaFoto" method="handleBtnCaricaFoto_CLICKED"
	key="cpCompilaz.btnCaricaFoto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','btnCaricaFoto')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtFoto --></div>

			
	
	<div id="p_pDtFotoNav" class="commandPanelBlock"><!-- startFragment:p_pDtFotoNav -->
	
	
<div class="commandPanel navigation" id="pDtFotoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFotoIndietro')" >

	



<!-- widget bDtFotoIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFotoIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFotoIndietro" id="widg_bDtFotoIndietro" method="handleBDtFotoIndietro_CLICKED"
	key="cpCompilaz.bDtFotoIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFotoIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFotoAvanti')" >

	



<!-- widget bDtFotoAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFotoAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFotoAvanti" id="widg_bDtFotoAvanti" method="handleBDtFotoAvanti_CLICKED"
	key="cpCompilaz.bDtFotoAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFotoAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtFotoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiFoto --></div>
