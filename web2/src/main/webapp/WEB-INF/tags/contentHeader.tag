<%@tag  pageEncoding="UTF-8" %>
<%@attribute name="title" type="java.lang.String" required="false" %>
<%@attribute name="style" type="java.lang.String" required="false" %>
<%@attribute name="body" required="false" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]> <html class="ie ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html class="ie ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1" name="viewport"/>

  <meta http-equiv="Cache-Control" content="no-store"/>
  <meta http-equiv="Pragma" content="no-cache"/>
  <meta http-equiv="Expires" content="0"/>

  <title>${title}</title>
  <link rel="icon" href="${ctx}/static/common/img/favicon.ico">
  <link rel="shortcut icon" href="${ctx}/static/common/img/favicon.ico">
  <%@include file="/WEB-INF/jsp/common/import-css.jspf" %>
  <script type="text/javascript">var currentURL = "${requestScope.currentURL}";</script>
  <jsp:invoke fragment="body" />
</head>
<body <c:if test="${not empty style}">class="${style}"</c:if>>
