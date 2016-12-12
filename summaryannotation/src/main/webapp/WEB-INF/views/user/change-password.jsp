<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<c:out value="${updateMode }"></c:out>
<div class="update-password-box content-box">
	<p class="label">
		<fmt:message key="password.change.header" />
	</p>

	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>

	<form name="updatePassword" action="${changePasswordUrl}" method="post">
		<table>
			<tr>
				<td><fmt:message key="password.change.curpass" /></td>
				<td><input name="curPass" type="password" /></td>
				<td class="error-message"><c:out value="${curPassError}" /></td>
			</tr>
			<tr>
				<td><fmt:message key="password.change.newpass" /></td>
				<td><input name="newPass" type="password" /></td>
				<td class="error-message"><c:out value="${newPassError }" /></td>
			</tr>
		</table>
		<div class="btn">
			<input name="submit" type="submit" value="<fmt:message key='password.change.submit' />" class="submit-btn" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>