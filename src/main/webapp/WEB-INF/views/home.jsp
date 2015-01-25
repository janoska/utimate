<%--
  Created by IntelliJ IDEA.
  User: sara
  Date: 11.11.2014
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="/resources/jsp/includes.html"%>
</head>
<body>
    <%@include file="/resources/jsp/menubar.jsp"%>

        <div id="background">
          <div id="wrapper">
            <c:choose>
              <c:when test="${sessionScope.username == null}">
                <%@include file="/resources/jsp/beforeLogin.jsp"%>
              </c:when>

              <c:otherwise>
                <%@include file="/resources/jsp/afterlogin.jsp"%>
              </c:otherwise>
            </c:choose>
              <%--<c:if test="${not empty error}">--%>
                  <%--<div class="error">${error}</div>--%>
              <%--</c:if>--%>
              <%--<c:if test="${not empty msg}">--%>
                  <%--<div class="msg">${msg}</div>--%>
              <%--</c:if>--%>
          </div>
        </div>

</body>
</html>
