<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/13/2014
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>


<form action="<c:url value='/j_spring_security_check' />" method="post" class="form-inline" role="form">

        <input type="text" placeholder="Nume Utilizator" class="form-control" name="username" id="username" maxlength="20" size="20" />

        <input type="password" placeholder="Parol&#259" class="form-control" name="password" id="password" maxlength="20" size="20" />

        <input type="submit" class="btn btn-success" name="submit" id="login" value="Conectare" />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</form>
