<%@ include file="/WEB-INF/views/header.jsp"%>
<c:url value='/register' var="registerUrl" />

<div id="register-box">
	<p id="register-label">
		<fmt:message key="register" />
	</p>

	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>

	<c:if test="${not empty message }">
		<div class="message">${message }</div>
	</c:if>

	<form:form name="register" action="${registerUrl}" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><fmt:message key="register.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="register.password" /></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="register.username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" class="submit-btn"
					value="<fmt:message key="register.submit" />" /></td>
			</tr>
		</table>
	</form:form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>