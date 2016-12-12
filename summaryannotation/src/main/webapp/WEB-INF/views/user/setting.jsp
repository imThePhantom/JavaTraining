<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty error }">
	<div class="error">${error }</div>
</c:if>
<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<%@ include file="/WEB-INF/views/footer.jsp"%>