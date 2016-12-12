<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty message }">
	<div class="message">${message}</div>
</c:if>

<div class="user-box content-box">
	<p class="label">
		<fmt:message key="user.info.header"></fmt:message>
	</p>

	<form:form action="${userUrl}" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><fmt:message key="email" /><td>
				<td><form:input path="email" disabled="true" /></td>
			</tr>
			<tr>
				<td><fmt:message key="username" /><td>
				<td><form:input path="username" /></td>
				<td class="error-message"><c:out value="${error}" ></c:out></td>
			</tr>
		</table>
		<div class="btn">
			<input type="submit" value="Chance Username" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form:form>
</div>

<div class="user-info-nav content-box">
	<a href="${changePinUrl }"><input type="button" value="Change PIN" /></a> <a
		href="${changePasswordUrl }"><input type="button" value="Change Password" /></a>
</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>