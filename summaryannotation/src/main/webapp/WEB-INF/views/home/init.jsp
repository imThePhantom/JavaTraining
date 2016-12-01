<%@ include file="/WEB-INF/views/header.jsp"%>

<c:url var="initUrl" value="/init"></c:url>
<form:form action="${initUrl}" method="post">
	<input type="submit" name="init" value="Init" id="init-btn">
</form:form>

<%@ include file="/WEB-INF/views/footer.jsp"%>