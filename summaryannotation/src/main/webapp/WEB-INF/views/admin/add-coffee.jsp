<%@ include file="/WEB-INF/views/header.jsp"%>

<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<div class="register-box content-box">
	<p class="label">
		<fmt:message key="coffee.add.header" />
	</p>

	<c:if test="${not empty error }">
		<div class="error">${error }</div>
	</c:if>

	<form:form name="addCoffee" action="${addCoffeeUrl}" method="post" modelAttribute="coffee">
		<table>
			<tr>
				<td><fmt:message key="coffee.code" /></td>
				<td><form:input path="coffeeCode" /></td>
				<td><form:errors path="coffeeCode" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="coffee.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error-message" /></td>
			</tr>
			<tr>
				<td><fmt:message key="coffee.price" /></td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="error-message" /></td>
			</tr>
		</table>
		<div class="btn">
			<input name="submit" type="submit" class="submit-btn" value="<fmt:message key="coffee.add.submit" />" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form:form>
</div>


<%@ include file="/WEB-INF/views/footer.jsp"%>