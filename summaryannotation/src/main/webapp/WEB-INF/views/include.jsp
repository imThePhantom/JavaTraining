<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<%@ page contentType="text/html;charset=UTF-8"%>

<c:url value="/admin" var="adminUrl" />
<c:url value="/admin/add-coffee" var="addCoffeeUrl" />
<c:url value="/home" var="homeUrl" />
<c:url value="/logout" var="logoutUrl" />
<c:url value="/login" var="loginUrl" />
<c:url value="/register" var="registerUrl" />
<c:url value="/reset-password" var="resetPasswordUrl" />
<c:url value="/user" var="userUrl" />
<c:url value="/user/change-password" var="changePasswordUrl" />
<c:url value="/user/change-pin" var="changePinUrl" />
<c:url value="/user/setting" var="userSettingUrl" />
<c:url value="/resources/css/style.css" var="stylesheetUrl" />