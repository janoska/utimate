<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/14/2014
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<form action="<c:url value='/j_spring_security_logout' />" method="post" class="form-inline" role="form" id="logoutForm">

    <div id="button">
        <input type="submit" class="btn btn-primary" name="submit" value="Logout"/>
    </div>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</form>
