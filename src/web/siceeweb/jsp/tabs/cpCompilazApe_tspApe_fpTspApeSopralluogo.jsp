<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpTspApeSopralluogo" class="formPanelBlock"><!-- startFragment:p_fpTspApeSopralluogo -->
		
	
<div class="formPanel" id="fpTspApeSopralluogo">


	
	

	
	
			
	
	<div id="p_pErrSopralluogo" class="stdMessagePanelBlock"><!-- startFragment:p_pErrSopralluogo -->
	
	
<div class="stdMessagePanel" id="pErrSopralluogo">
	<customtag:stdMessagePanel id="pErrSopralluogo" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrSopralluogo --></div>

			
	
	<div id="p_wpDataSopralluogo" class="widgetsPanelBlock"><!-- startFragment:p_wpDataSopralluogo -->
	
	

<div class="widgetsPanel" id="wpDataSopralluogo">
	
	<customtag:widgetsPanel id="wpDataSopralluogoTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','txtObblDataSopralluogo')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget txtObblDataSopralluogo -->
<s:text name="cpCompilazApe.txtObblDataSopralluogo.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDataSopralluogo_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDataSopralluogo_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDataSopralluogo_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDataSopralluogo_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cDataSopralluogo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cDataSopralluogo.label')}" labelFor="widg_cDataSopralluogo" errorFor="appDatacertificato.altreInfo.sopralluoghi.data" labelId="cDataSopralluogoLbl"
	position="first"  >


<!-- widget cDataSopralluogo -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.sopralluoghi.data" id="widg_cDataSopralluogo"
	disabled="isWidgetDisabled('cpCompilazApe','cDataSopralluogo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','btnSalvaDataSopralluogo')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnSalvaDataSopralluogo -->
<s:submit name="widg_btnSalvaDataSopralluogo" id="widg_btnSalvaDataSopralluogo" method="handleBtnSalvaDataSopralluogo_CLICKED"
	key="cpCompilazApe.btnSalvaDataSopralluogo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','btnSalvaDataSopralluogo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDataSopralluogo_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDataSopralluogo_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDataSopralluogo --></div>

			
	
	
<s:include value="/jsp/userpanels/cpCompilazApe_udPreview.jsp"></s:include>

	



			
	
	<div id="p_cpPreview" class="commandPanelBlock"><!-- startFragment:p_cpPreview -->
	
	
<div class="commandPanel functional" id="cpPreview">

	
	
		
		
<s:if test="isWidgetVisible('cpCompilazApe','btnEliminaFoto')" >

	



<!-- widget btnEliminaFoto -->
<s:submit name="widg_btnEliminaFoto" id="widg_btnEliminaFoto" method="handleBtnEliminaFoto_CLICKED"
	key="cpCompilazApe.btnEliminaFoto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','btnEliminaFoto')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpPreview --></div>

			
	
	<div id="p_wpTextNote" class="widgetsPanelBlock"><!-- startFragment:p_wpTextNote -->
	
	

<div class="widgetsPanel" id="wpTextNote">
	
	<customtag:widgetsPanel id="wpTextNoteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','txtNote1Foto')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget txtNote1Foto -->
<s:text name="cpCompilazApe.txtNote1Foto.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpTextNote --></div>

			
	
	<div id="p_wpImmaginePrincipale" class="widgetsPanelBlock"><!-- startFragment:p_wpImmaginePrincipale -->
	
	
<h4 class="wpLabel">Immagine Principale </h4>
<div class="widgetsPanel" id="wpImmaginePrincipale">
	
	<customtag:widgetsPanel id="wpImmaginePrincipaleTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','txtObblDtFoto')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget txtObblDtFoto -->
<s:text name="cpCompilazApe.txtObblDtFoto.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpImmaginePrincipale_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpImmaginePrincipale_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpImmaginePrincipale_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImmaginePrincipale_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','fileFotoCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.fileFotoCatasto.label')}" labelFor="widg_fileFotoCatasto" errorFor="widg_fileFotoCatasto" labelId="fileFotoCatastoLbl"
	position="first"  >


<s:file 
	
	
	name="widg_fileFotoCatasto" id="widg_fileFotoCatasto"
	disabled="isWidgetDisabled('cpCompilazApe','fileFotoCatasto')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbTipoFoto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbTipoFoto.label')}" labelFor="widg_cbTipoFoto" errorFor="appDatatipoFotoSel" labelId="cbTipoFotoLbl"
	  >


<!-- widget cbTipoFoto -->
<s:select name="appDatatipoFotoSel" id="widg_cbTipoFoto"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipoFoto"
	  disabled="isWidgetDisabled('cpCompilazApe','cbTipoFoto')"
	  listKey="idTipoFoto"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','btnCaricaFoto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCaricaFoto -->
<s:submit name="widg_btnCaricaFoto" id="widg_btnCaricaFoto" method="handleBtnCaricaFoto_CLICKED"
	key="cpCompilazApe.btnCaricaFoto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','btnCaricaFoto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImmaginePrincipale --></div>

			
	
	<div id="p_wpImmaginiSecondarie" class="widgetsPanelBlock"><!-- startFragment:p_wpImmaginiSecondarie -->
	
	
<h4 class="wpLabel">Altre Immagini </h4>
<div class="widgetsPanel" id="wpImmaginiSecondarie">
	
	<customtag:widgetsPanel id="wpImmaginiSecondarieTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','txtObblDtFotoAltre')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget txtObblDtFotoAltre -->
<s:text name="cpCompilazApe.txtObblDtFotoAltre.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpImmaginiSecondarie_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpImmaginiSecondarie_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpImmaginiSecondarie_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImmaginiSecondarie_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','fileFotoCatastoAltre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.fileFotoCatastoAltre.label')}" labelFor="widg_fileFotoCatastoAltre" errorFor="widg_fileFotoCatastoAltre" labelId="fileFotoCatastoAltreLbl"
	position="first"  >


<s:file 
	
title=""	
	name="widg_fileFotoCatastoAltre" id="widg_fileFotoCatastoAltre"
	disabled="isWidgetDisabled('cpCompilazApe','fileFotoCatastoAltre')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbTipoFotoAltre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbTipoFotoAltre.label')}" labelFor="widg_cbTipoFotoAltre" errorFor="appDatatipoFotoAltreSel" labelId="cbTipoFotoAltreLbl"
	  >


<!-- widget cbTipoFotoAltre -->
<s:select name="appDatatipoFotoAltreSel" id="widg_cbTipoFotoAltre"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipoFoto"
	  disabled="isWidgetDisabled('cpCompilazApe','cbTipoFotoAltre')"
	  listKey="idTipoFoto"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','btnCaricaFotoAltre')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCaricaFotoAltre -->
<s:submit name="widg_btnCaricaFotoAltre" id="widg_btnCaricaFotoAltre" method="handleBtnCaricaFotoAltre_CLICKED"
	key="cpCompilazApe.btnCaricaFotoAltre.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','btnCaricaFotoAltre')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImmaginiSecondarie --></div>

	

		
	
</div>

	<!-- endFragment:p_fpTspApeSopralluogo --></div>
