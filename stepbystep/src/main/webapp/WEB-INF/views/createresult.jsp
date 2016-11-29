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
	<a href="<c:url value="product"/>">Product</a>
	<br>
	
	<h3>New product</h3>
	<c:out value="Name: ${product.name}" />
	<br>
	<c:out value="Des: ${product.description}" />
	<br>
	<fmt:formatNumber type="number" maxFractionDigits="2"
		value="Price: ${product.price}" />
	<br>
</body>
</html>