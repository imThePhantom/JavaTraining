<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
	<head>
		<title>Hello Page</title>
	</head>
	<body>
		<h1>Hello, my Friend</h1>
		<p>Greetings, it is now <c:out value="${now}"/></p>
		<a href="<c:url value="product" />">Product</a>
	</body>
</html>