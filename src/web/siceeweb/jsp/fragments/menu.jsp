<%@taglib prefix="s" uri="/struts-tags" %>

	
<div id="mainMenu">
	<h3>Menu di navigazione</h3>
	<ul>
		
<s:if test="isMenuVisible('mnuhome')">
	<s:if test="isMenuEnabled('mnuhome')">
		<s:url id="targetUrlMnuhome" action="goToMnuhomeFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuhome')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuhome}" id="menu_items_mnuhome">
				<s:text name="mnuhome.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuhome.label" /></li>
	</s:else>
	

</s:if>

		
		
			
<s:if test="isMenuVisible('mnuGstDatiCert')">
	<s:if test="isAtLeastOneSubMenuVisible('mnuGstDatiCert')">
		<s:if test="isMenuEnabled('mnuGstDatiCert')">
			<li class="parent<s:property value="%{(isMenuActive('mnuGstDatiCert') || isSubMenuActive('mnuGstDatiCert')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuGstDatiCert')"> id="current"</s:if>>
				<s:url id="targetUrlMnuGstDatiCert" action="goToMnuGstDatiCertFromMenu" namespace="/secure" includeParams="none" />
				<s:a href="%{targetUrlMnuGstDatiCert}" id="menu_items_mnuGstDatiCert">
					<span><s:text name="mnuGstDatiCert.label" /></span>
				</s:a>
				<ul>
					

<s:if test="isMenuVisible('mnuRegDatiCert')">
	<s:if test="isMenuEnabled('mnuRegDatiCert')">
		<s:url id="targetUrlMnuRegDatiCert" action="goToMnuRegDatiCertFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRegDatiCert')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRegDatiCert}" id="menu_items_mnuRegDatiCert">
				<s:text name="mnuRegDatiCert.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRegDatiCert.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuTransDatiCert')">
	<s:if test="isMenuEnabled('mnuTransDatiCert')">
		<s:url id="targetUrlMnuTransDatiCert" action="goToMnuTransDatiCertFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuTransDatiCert')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuTransDatiCert}" id="menu_items_mnuTransDatiCert">
				<s:text name="mnuTransDatiCert.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuTransDatiCert.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuTransAnomaleDatiCert')">
	<s:if test="isMenuEnabled('mnuTransAnomaleDatiCert')">
		<s:url id="targetUrlMnuTransAnomaleDatiCert" action="goToMnuTransAnomaleDatiCertFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuTransAnomaleDatiCert')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuTransAnomaleDatiCert}" id="menu_items_mnuTransAnomaleDatiCert">
				<s:text name="mnuTransAnomaleDatiCert.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuTransAnomaleDatiCert.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuInvioCurriculum')">
	<s:if test="isMenuEnabled('mnuInvioCurriculum')">
		<s:url id="targetUrlMnuInvioCurriculum" action="goToMnuInvioCurriculumFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuInvioCurriculum')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuInvioCurriculum}" id="menu_items_mnuInvioCurriculum">
				<s:text name="mnuInvioCurriculum.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuInvioCurriculum.label" /></li>
	</s:else>
	

</s:if>



				</ul>
			</li>
		</s:if>
		<s:else>
			<li class="parent<s:property value="%{(isMenuActive('mnuGstDatiCert') || isSubMenuActive('mnuGstDatiCert')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuGstDatiCert')"> id="current"</s:if>><span><s:text name="mnuGstDatiCert.label" /></span>
				<ul>
					

<s:if test="isMenuVisible('mnuRegDatiCert')">
	<s:if test="isMenuEnabled('mnuRegDatiCert')">
		<s:url id="targetUrlMnuRegDatiCert" action="goToMnuRegDatiCertFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRegDatiCert')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRegDatiCert}" id="menu_items_mnuRegDatiCert">
				<s:text name="mnuRegDatiCert.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRegDatiCert.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuTransDatiCert')">
	<s:if test="isMenuEnabled('mnuTransDatiCert')">
		<s:url id="targetUrlMnuTransDatiCert" action="goToMnuTransDatiCertFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuTransDatiCert')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuTransDatiCert}" id="menu_items_mnuTransDatiCert">
				<s:text name="mnuTransDatiCert.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuTransDatiCert.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuTransAnomaleDatiCert')">
	<s:if test="isMenuEnabled('mnuTransAnomaleDatiCert')">
		<s:url id="targetUrlMnuTransAnomaleDatiCert" action="goToMnuTransAnomaleDatiCertFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuTransAnomaleDatiCert')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuTransAnomaleDatiCert}" id="menu_items_mnuTransAnomaleDatiCert">
				<s:text name="mnuTransAnomaleDatiCert.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuTransAnomaleDatiCert.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuInvioCurriculum')">
	<s:if test="isMenuEnabled('mnuInvioCurriculum')">
		<s:url id="targetUrlMnuInvioCurriculum" action="goToMnuInvioCurriculumFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuInvioCurriculum')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuInvioCurriculum}" id="menu_items_mnuInvioCurriculum">
				<s:text name="mnuInvioCurriculum.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuInvioCurriculum.label" /></li>
	</s:else>
	

</s:if>



				</ul>
			</li>
		</s:else>
		
	
	</s:if>
	<s:else>
		<s:if test="isMenuEnabled('mnuGstDatiCert')">
			<li<s:if test="isMenuActive('mnuGstDatiCert')"> id="current" class="active"</s:if>>
				<s:url id="targetUrlMnuGstDatiCert" action="goToMnuGstDatiCertFromMenu" namespace="/secure" includeParams="none" />
				<s:a href="%{targetUrlMnuGstDatiCert}" id="menu_items_mnuGstDatiCert">
					<s:text name="mnuGstDatiCert.label" />
				</s:a>
			</li>
		</s:if>
		<s:else>
			<li><s:text name="mnuGstDatiCert.label" /></li>
		</s:else>
		
	
	</s:else>
</s:if>

		
		
			
<s:if test="isMenuVisible('mnuGstCert')">
	<s:if test="isAtLeastOneSubMenuVisible('mnuGstCert')">
		<s:if test="isMenuEnabled('mnuGstCert')">
			<li class="parent<s:property value="%{(isMenuActive('mnuGstCert') || isSubMenuActive('mnuGstCert')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuGstCert')"> id="current"</s:if>>
				<s:url id="targetUrlMnuGstCert" action="goToMnuGstCertFromMenu" namespace="/secure" includeParams="none" />
				<s:a href="%{targetUrlMnuGstCert}" id="menu_items_mnuGstCert">
					<span><s:text name="mnuGstCert.label" /></span>
				</s:a>
				<ul>
					

<s:if test="isMenuVisible('mnuPrenotAttestati')">
	<s:if test="isMenuEnabled('mnuPrenotAttestati')">
		<s:url id="targetUrlMnuPrenotAttestati" action="goToMnuPrenotAttestatiFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuPrenotAttestati')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuPrenotAttestati}" id="menu_items_mnuPrenotAttestati">
				<s:text name="mnuPrenotAttestati.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuPrenotAttestati.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuRicercaACE')">
	<s:if test="isMenuEnabled('mnuRicercaACE')">
		<s:url id="targetUrlMnuRicercaACE" action="goToMnuRicercaACEFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicercaACE')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicercaACE}" id="menu_items_mnuRicercaACE">
				<s:text name="mnuRicercaACE.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicercaACE.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuGestACE')">
	<s:if test="isMenuEnabled('mnuGestACE')">
		<s:url id="targetUrlMnuGestACE" action="goToMnuGestACEFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuGestACE')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuGestACE}" id="menu_items_mnuGestACE">
				<s:text name="mnuGestACE.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuGestACE.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuAnnullaACE')">
	<s:if test="isMenuEnabled('mnuAnnullaACE')">
		<s:url id="targetUrlMnuAnnullaACE" action="goToMnuAnnullaACEFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuAnnullaACE')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuAnnullaACE}" id="menu_items_mnuAnnullaACE">
				<s:text name="mnuAnnullaACE.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuAnnullaACE.label" /></li>
	</s:else>
	

</s:if>



				</ul>
			</li>
		</s:if>
		<s:else>
			<li class="parent<s:property value="%{(isMenuActive('mnuGstCert') || isSubMenuActive('mnuGstCert')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuGstCert')"> id="current"</s:if>><span><s:text name="mnuGstCert.label" /></span>
				<ul>
					

<s:if test="isMenuVisible('mnuPrenotAttestati')">
	<s:if test="isMenuEnabled('mnuPrenotAttestati')">
		<s:url id="targetUrlMnuPrenotAttestati" action="goToMnuPrenotAttestatiFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuPrenotAttestati')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuPrenotAttestati}" id="menu_items_mnuPrenotAttestati">
				<s:text name="mnuPrenotAttestati.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuPrenotAttestati.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuRicercaACE')">
	<s:if test="isMenuEnabled('mnuRicercaACE')">
		<s:url id="targetUrlMnuRicercaACE" action="goToMnuRicercaACEFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicercaACE')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicercaACE}" id="menu_items_mnuRicercaACE">
				<s:text name="mnuRicercaACE.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicercaACE.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuGestACE')">
	<s:if test="isMenuEnabled('mnuGestACE')">
		<s:url id="targetUrlMnuGestACE" action="goToMnuGestACEFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuGestACE')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuGestACE}" id="menu_items_mnuGestACE">
				<s:text name="mnuGestACE.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuGestACE.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuAnnullaACE')">
	<s:if test="isMenuEnabled('mnuAnnullaACE')">
		<s:url id="targetUrlMnuAnnullaACE" action="goToMnuAnnullaACEFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuAnnullaACE')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuAnnullaACE}" id="menu_items_mnuAnnullaACE">
				<s:text name="mnuAnnullaACE.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuAnnullaACE.label" /></li>
	</s:else>
	

</s:if>



				</ul>
			</li>
		</s:else>
		
	
	</s:if>
	<s:else>
		<s:if test="isMenuEnabled('mnuGstCert')">
			<li<s:if test="isMenuActive('mnuGstCert')"> id="current" class="active"</s:if>>
				<s:url id="targetUrlMnuGstCert" action="goToMnuGstCertFromMenu" namespace="/secure" includeParams="none" />
				<s:a href="%{targetUrlMnuGstCert}" id="menu_items_mnuGstCert">
					<s:text name="mnuGstCert.label" />
				</s:a>
			</li>
		</s:if>
		<s:else>
			<li><s:text name="mnuGstCert.label" /></li>
		</s:else>
		
	
	</s:else>
</s:if>

		
		
			
<s:if test="isMenuVisible('mnuMonitoraggio')">
	<s:if test="isAtLeastOneSubMenuVisible('mnuMonitoraggio')">
	
		<li class="parent<s:property value="%{(isMenuActive('mnuMonitoraggio') || isSubMenuActive('mnuMonitoraggio')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuMonitoraggio')"> id="current"</s:if>><span><s:text name="mnuMonitoraggio.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('vAmbiente')">
	<s:if test="isMenuEnabled('vAmbiente')">
		<s:url id="targetUrlVAmbiente" action="goToVAmbienteFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('vAmbiente')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlVAmbiente}" id="menu_items_vAmbiente">
				<s:text name="vAmbiente.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="vAmbiente.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="mnuMonitoraggio.label" /></li>
	
	</s:else>
</s:if>

		

		
<!-- STATIC LINKS -->

<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:catch var="ex">
	<r:include url="/ris/utheme/sisp7/siceeweb/include/static_links.html" resourceProvider="sp" />
</c:catch>
	</ul>
</div>


