<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="product.heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now }" />
	</p>

	<br>
	<a href="<c:url value="home"/>">Home</a>
	<br>
	<a href="<c:url value="createproduct"/>">Create Product</a>
	<br>
	<a href="<c:url value="priceincrease"/>">Increase Prices</a>
	<br>

	<h3>Products</h3>
	<c:forEach items="${model.products}" var="prod">
		
		<c:out value="Name: ${prod.name}" />
		<br>
		<c:out value="Des: ${prod.description}" />
		<br>
		<fmt:formatNumber type="number" maxFractionDigits="2"
			value="${prod.price}" />
		<br><br>
	</c:forEach>
</body>
</html>
