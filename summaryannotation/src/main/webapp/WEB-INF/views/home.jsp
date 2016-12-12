<%@ include file="/WEB-INF/views/header.jsp"%>

<span>${greeting}</span>
<c:if test="${not empty message }">
	<div class="message">${message }</div>
</c:if>

<c:if test="${not empty listCoffees }">
	<table>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${listCoffees }" var="coffee">
			<tr>
				<td>${coffee.coffeeCode }
				<td>${coffee.name }</td>
				<td>${coffee.price }</td>
			</tr>
		</c:forEach>
	</table>
</c:if>


<%@ include file="/WEB-INF/views/footer.jsp"%>