<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<div class="register-box content-box">
	<p class="label">
		<fmt:message key="register.header" />
	</p>

	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>

	<form:form name="register" action="${registerUrl}" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><fmt:message key="email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="password" /></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error-message" /></td>
			</tr>
		</table>
		<div class="btn">
			<input name="submit" type="submit" class="submit-btn" value="<fmt:message key="register.submit" />" />
		</div>

	</form:form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>