<%@ include file="init.jsp"%>

<div class="alert alert-info">
	<liferay-ui:message key="you-are-already-logged-in"/>
</div>

<script type="text/javascript">
	window.location.href = '${themeDisplay.getURLHome()}';
</script>