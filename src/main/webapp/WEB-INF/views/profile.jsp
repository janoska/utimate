<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/13/2014
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <div id="leftTag" style="height: 650px">
            <div style="float:left; width:160px; height: 200px; text-align: center;">
            <img src="${image}" width="160" height="120" />
                <p style="margin-top: 15px;"><%request.getSession().getAttribute("user");%></p>
                <button class="btn btn-info" type="button" id="editProfileBtn" name="editProfile">Editeaz&#259-&#539i datele</button>
            </div>
            <div style="float:left; width:350px; height: 200px; padding-left: 15px;">
                <form:form id="profileInfoForm" method="post" commandName="editProfile">
                    <p><span class="gray">&#350coal&#259:</span> <span id="scoala"> ${school}</span></p>
                    <p><span class="gray">Ora&#x219:</span> <span id="oras"> ${city}</span></p>
                    <p><span class="gray">Jude&#539:</span> <span id="judet"> ${judet}</span></p>
                    <p><span class="gray">An bacalaureat:</span> <span id="bac"> ${bac}</span></p>
                </form:form>
            </div>
            <div style="width: 500px;">
                <p style="font-weight: bold;">Materii in progres</p>
                <p>Rom&#226n&#259 ${romanaStage}%</p>
                <p class="distance"><progress max="100" value="${romanaStage}"></progress></p>
                <p>Istorie ${istorieStage}%</p>
                <p class="distance"><progress max="100" value="${istorieStage}"></progress></p>
                <p>Geografie ${geografieStage}%</p>
                <p class="distance"><progress max="100" value="${geografieStage}"></progress></p>
                <p>Biologie ${biologieStage}%</p>
                <p class="distance"><progress max="100" value="${biologieStage}"></progress></p>
                <p>Anatomie ${anatomieStage}%</p>
                <p class="distance"><progress max="100" value="${anatomieStage}"></progress></p>
            </div>
        </div>
        <div id="rightTag">
            <p><img src="/resources/img/student.jpg" style="float:left" width="60" height="45" /> Zsoldos Janos
                Ai ob&#539inut nivelul 10 la Rom&#226n&#259!
            </p>
        </div>
    </div>
</div>

<script src="/resources/js/profile.js"></script>

</body>
</html>
