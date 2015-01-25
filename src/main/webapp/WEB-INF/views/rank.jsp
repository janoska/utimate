<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/13/2014
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
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
        <div id="centeredTag">
            <div style="font-size: 25px; font-weight: bold; float: left;">Clasamentul general</div>
            <div style="font-size: 20px; float: right;">
                Materia:
                <form:form method="POST" id="rank">
                <select id="curriculums" name="curriculums" class="form-control form-control-inline">
                    <option id="1" value="romana">Rom&#226n&#259</option>
                    <option id="2" value="istorie">Istorie</option>
                    <option id="3" value="geografie">Geografie</option>
                    <option id="4" value="biologie">Biologie</option>
                    <option id="5" value="anatomie">Anatomie</option>
                </select>
                </form:form>
                <input type="hidden" id="selectedValue" value="${selectedValue}" />
            </div>
            <div style="height: 600px;">
                <table data-toggle="table" data-sort-name="rank"  data-sort-order="desc">
                    <thead>
                    <tr>
                        <th data-field="id">#</th>
                        <th data-field="name" data-sortable="true">Nume &#x219i Prenume</th>
                        <th data-field="rank" data-sortable="true">Nivel</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="j" value="1" ></c:set>
                        <c:forEach items="${level}" var="level" varStatus="status" >

                            <c:set var="j" value="${j+1}" ></c:set>

                            <tr>
                            <td>${j}</td>
                            <td>${name[status.index]}</td>
                            <td>${level}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="/resources/js/rank.js"></script>

</body>
</html>
