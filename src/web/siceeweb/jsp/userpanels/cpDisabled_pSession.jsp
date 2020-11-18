<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_pSession" class="panelBlock"><!-- startFragment:p_pSession -->
<div class="userDefinedPanel" id="pSession">
<!--PROTECTED REGION ID(R1991948668) ENABLED START-->
<%
  synchronized( session ) {
	   session.invalidate() ;
  }
%>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_pSession --></div>
