<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<div class="update-pin-box content-box">
	<p class="label">
		<fmt:message key="pin.update.header" />
	</p>

	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>

	<form name="updatePin" action="${changePinUrl}" method="post">
		<table>
			<c:if test="${updateMode.equals('updatePin')}">
				<tr>
					<td><fmt:message key="pin.update.curpin" /></td>
					<td><input name="curPin" type="password" /></td>
					<td class="error-message"><c:out value="${curPinError}" /></td>
				</tr>
			</c:if>
			<tr>
				<td><fmt:message key="pin.update.newpin" /></td>
				<td><input name="newPin" type="password" /></td>
				<td class="error-message"><c:out value="${newPinError }" /></td>
			</tr>
		</table>
		<div class="btn">
			<input name="submit" type="submit" value="<fmt:message key="pin.update.submit"/>" class="submit-btn" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>