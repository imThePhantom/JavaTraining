<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="priceincrease.heading" />
	</h1>

	<br>
	<a href="<c:url value="home"/>">Home</a>
	<br>
	<a href="<c:url value="priceincrease"/>">Increase Prices</a>
	<br>

	<h3>New price</h3>
	<c:forEach items="${products}" var="prod">

		<c:out value="Name: ${prod.name}" />
		<br>
		<c:out value="Des: ${prod.description}" />
		<br>
		<fmt:formatNumber type="number" maxFractionDigits="2"
			value="${prod.price}" />
		<br>
		<br>
	</c:forEach>
</body>
</html>
