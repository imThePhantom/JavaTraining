<%@page import="org.springframework.context.MessageSource"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!doctype html>
<html>
<head>
<link href="${stylesheetUrl}" rel="stylesheet" type="text/css">
<meta charset="UTF-8)">
<title>${title}</title>
</head>
<body>
	<header>
		<h1 class="inline">
			<a href="${homeUrl}" class="webname">Spring MVC</a>
		</h1>

		<div class="user-panel">
			<c:url value="/logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>

			<c:choose>
				<c:when test="${pageContext.request.userPrincipal.name == null}">
					<a href="${loginUrl}" class="box inline"><fmt:message key="login" /></a>
					<a href="${registerUrl}" class="box inline"><fmt:message key="register" /></a>
				</c:when>

				<c:otherwise>
					<div class="dropdown">
						<a href="${userUrl}">${pageContext.request.userPrincipal.name}</a>

						<button onclick="dropdown()" class="dropbtn inline">▼</button>
						<div id="dropdownBtn" class="dropdown-content">
							<sec:authorize access="hasRole('ADMIN')">
								<a href="${adminUrl}"><fmt:message key="admin" /></a>
							</sec:authorize>
							<sec:authorize access="hasAnyRole('USER', 'ADMIN')">
								<a href="${userSettingUrl}"><fmt:message key="setting" /></a>
							</sec:authorize>
							<a href="javascript:formSubmit()"><fmt:message key="logout" /></a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</header>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<script>
		function dropdown() {
			document.getElementById('dropdownBtn').classList.toggle("show");
		}
	</script>