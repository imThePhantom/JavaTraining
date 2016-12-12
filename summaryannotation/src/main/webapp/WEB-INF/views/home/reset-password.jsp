<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<div class="reset-box content-box">
	<p class="label">
		<fmt:message key="password.reset.header"></fmt:message>
	</p>
	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>

	<form:form name="reset-password" action="${resetPasswordUrl}" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><fmt:message key="email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="pin" /></td>
				<td><form:password path="sPIN" /></td>
				<td><form:errors path="sPIN" cssClass="error-message" /></td>
			</tr>

		</table>
		<div class="btn">
			<input name="submit" type="submit" class="submit-btn" value="<fmt:message key="password.reset.submit" />"/>
			<a href="${homeUrl}">
				<input type="button" class="submit-btn" value="<fmt:message key="password.reset.cancel" />" />
			</a>
		</div>
	</form:form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>