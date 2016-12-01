<%@ include file="/WEB-INF/views/header.jsp"%>

<span>${greeting}</span>
<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<%@ include file="/WEB-INF/views/footer.jsp"%>