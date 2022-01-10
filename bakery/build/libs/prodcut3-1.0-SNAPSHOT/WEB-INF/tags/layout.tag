<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="content" fragment="true" %>
<%@attribute name="secondContent" fragment="true"%>
<%@ attribute name="footer" fragment="true" %>
<html>
<head>
    <d:head/>
    <jsp:invoke fragment="head"/>
</head>
<body class="footer-offset">

<script src="assets\vendor\hs-navbar-vertical-aside\hs-navbar-vertical-aside-mini-cache.js"></script>
<%@include file="only-dev.html" %>

<jsp:invoke fragment="content"/>
<jsp:invoke fragment="secondContent"/>
<%@include file="js-plugins.html" %>
</body>
</html>
