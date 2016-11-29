<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="createproduct.heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now }" />
	</p>

	<br>
	<a href="<c:url value="product"/>">Product</a>
	<br>
	
	<form:form method="post" modelAttribute="product">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="price"/></td>
				<td><form:errors path="price" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>