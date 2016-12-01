<%@ include file="/WEB-INF/views/header.jsp"%>
<c:url value='/reset-password' var="resetUrl" />
<c:url value="/home" var="homeUrl" />

<div id="reset-box">
	<p id="reset-label">
		<fmt:message key="reset"></fmt:message>
	</p>
	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>
	<c:if test="${not empty message }">
		<div class="message">${message }</div>
	</c:if>

	<form:form name="reset-password" action="${registerUrl}" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><fmt:message key="reset.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="reset.pin" /></td>
				<td><form:password path="sPIN" /></td>
				<td><form:errors path="sPIN" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" class="submit-btn"
					value="<fmt:message key="reset.submit" />" /> <a href="${homeUrl}"><input type="button"
						class="submit-btn" value="<fmt:message key="reset.cancel" />" /></a></td>
			</tr>
		</table>
	</form:form>

</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>