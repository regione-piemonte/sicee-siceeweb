<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_pHome" class="panelBlock"><!-- startFragment:p_pHome -->
<div class="userDefinedPanel" id="pHome">
<!--PROTECTED REGION ID(R481634501) ENABLED START-->
<!-- Inserire il codice del pannello -->
<div class="contenuti">	
	<dl>
	<dt>
	<s:url id="targetUrlRegistrazione" action="goToMnuRegDatiCertFromMenu" includeParams="none" namespace="/secure"/>
	<s:a href="%{targetUrlRegistrazione}">
		<s:text name="Dati registrazione" />
	</s:a>
	</dt>
	<dd>	
		La funzione permette la visualizzazione e la modifica dei dati inseriti in fase di registrazione.
	</dd>
	
	<s:if test="isMenuVisible('mnuTransDatiCert')">
		<s:if test="isMenuEnabled('mnuTransDatiCert')">
			<dt>
			<s:url id="targetUrlTransazioni" action="goToMnuTransDatiCertFromMenu" includeParams="none" namespace="/secure"/>
			<s:a href="%{targetUrlTransazioni}">
				<s:text name="Riepilogo Transazioni" />
			</s:a>
			</dt>
			<dd>
			In questa sezione il certificatore pu&ograve; visualizzare tutte le transazioni effettuate (registrazione e acquisto codici A.P.E.) e scaricare le relative ricevute.
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Riepilogo Transazioni" />
			</dt>
			<dd>
			In questa sezione il certificatore pu&ograve; visualizzare tutte le transazioni effettuate (registrazione e acquisto codici A.P.E.) e scaricare le relative ricevute.
			</dd>
		</s:else>
	</s:if>
	
	<s:if test="isMenuVisible('mnuTransAnomaleDatiCert')">
		<s:if test="isMenuEnabled('mnuTransAnomaleDatiCert')">
			<dt>
			<s:url id="targetUrlTransazioniAnomale" action="goToMnuTransAnomaleDatiCertFromMenu" includeParams="none" namespace="/secure"/>
			<s:a href="%{targetUrlTransazioniAnomale}">
				<s:text name="Transazioni Anomale" />
			</s:a>
			</dt>
			<dd>
			La funzione permette al certificatore di verificare le transazioni che non si sono concluse correttamente sia per quanto riguarda la registrazione che gli acquisti dei codici A.P.E. (per es. se si &egrave; dimenticati di cliccare il pulsante &quot;torna&quot; al termine del pagamento).
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Transazioni Anomale" />
			</dt>
			<dd>
			La funzione permette al certificatore di verificare le transazioni che non si sono concluse correttamente sia per quanto riguarda la registrazione che gli acquisti dei codici A.P.E. (per es. se si &egrave; dimenticati di cliccare il pulsante &quot;torna&quot; al termine del pagamento).
			</dd>
		</s:else>
	</s:if>
	
	<s:if test="isMenuVisible('mnuInvioCurriculum')">
		<s:if test="isMenuEnabled('mnuInvioCurriculum')">
			<dt>
			<s:url id="targetUrlInvioCurriculum" action="goToMnuInvioCurriculumFromMenu" includeParams="none" namespace="/secure"/>
			<s:a href="%{targetUrlInvioCurriculum}">
				<s:text name="Invia Curriculum Vitae" />
			</s:a>
			</dt>
			<dd>
			Tramite questa funzione il certificatore pu&ograve; inviare il proprio curriculum vitae che sar&agrave; pubblicato nell'elenco dei certificatori.
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Invia Curriculum Vitae" />
			</dt>
			<dd>
			Tramite questa funzione il certificatore pu&ograve; inviare il proprio curriculum vitae che sar&agrave; pubblicato nell'elenco dei certificatori.
			</dd>
		</s:else>
	</s:if>
			
	
	
	</dl>
	</div>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_pHome --></div>
