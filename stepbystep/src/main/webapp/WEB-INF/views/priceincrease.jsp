<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="priceincrease.heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now }" />
	</p>

	<br>
	<a href="<c:url value="home"/>"></a>
	<br>
	
	<form:form method="post" modelAttribute="priceIncrease">
		<table>
			<tr>
				<td>Increase (%):</td>
				<td><form:input path="percentage"/></td>
				<td><form:errors path="percentage" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Excute">
	</form:form>
</body>
</html>