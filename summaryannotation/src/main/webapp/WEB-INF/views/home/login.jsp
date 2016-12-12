<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty message }">
	<div class="message">${message}</div>
</c:if>

<div class="login-box content-box">
	<p class="label">
		<fmt:message key="login.header"></fmt:message>
	</p>
	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>

	<form name="loginForm" action="${loginUrl}" method="post">
		<table>
			<tr>
				<td><fmt:message key="email" /></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><fmt:message key="password" /></td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<div class="btn">
			<input name="submit" type="submit" class="submit-btn" value="<fmt:message key="login.submit" />" />
		</div>
		<a href="${resetPasswordUrl}"><fmt:message key="login.forget.password" /></a>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>