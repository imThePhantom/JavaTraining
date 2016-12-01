<%@ include file="/WEB-INF/views/header.jsp"%>
<c:url value="/reset-password" var="resetPasswordUrl" />
<c:url value='/login' var="loginUrl" />

<div id="login-box">
	<p id="login-label">
		<fmt:message key="login"></fmt:message>
	</p>
	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>
	<c:if test="${not empty message }">
		<div class="message">${message }</div>
	</c:if>

	<form name="loginForm" action="${loginUrl}" method="post">

		<table>
			<tr>
				<td><fmt:message key="login.email" /></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><fmt:message key="login.password" /></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submit" type="submit" class="submit-btn"
					value="<fmt:message key="login.submit" />" /></td>
			</tr>
			<tr>
				<td><a href="${resetPasswordUrl}"><fmt:message key="login.forget.password" /></a></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>