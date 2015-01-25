<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/13/2014
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page session="true"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                <form:form method="POST" action="/learn/starting" id="materialForm">
                    <input type="hidden" name="material" id="material" value="" />
                </form:form>
                <div style="margin:0 auto; text-align: center; font-weight: bold; font-size: 20px; padding-bottom: 10px; ">&#206nva&#539&#259</div>

                <table data-toggle="table">
                    <thead>
                    <tr>
                        <th>Materie</th>
                        <th>Subiect</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                            <div>
                                <p>Rom&#226n&#259</p>
                                <p><progress style="width: 280px;" max="100" value="${romanaStageSubI}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                                <p>Rom&#226n&#259</p>
                                <p><progress style="width: 280px;" max="100" value="${romanaStageSubIII}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                            </div>

                            </td>
                            <td>
                            <div>
                                <p>Mod de &#238nv&#259&#539are: Subiectul I</p>
                                <p>${romanaStageSubIVal} <button class="btn btn-primary" id="sub1R" name="sub3R">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul III</p>
                                <p>${romanaStageSubIIIVal} <button class="btn btn-primary" id="sub3R" name="sub3R">&#206ncepe</button></p>
                            </div>

                            </td>
                        </tr>
                    <tr id="istorieTab">
                        <td>
                            <div>
                                <p>Istorie</p>
                                <p><progress style="width: 280px;" max="100" value="${istorieStageSubI}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                                <p>Istorie</p>
                                <p><progress style="width: 280px;" max="100" value="${istorieStageSubIII}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                            </div>
                        </td>
                        <td>
                            <div>
                                <p>Mod de &#238nv&#259&#539are: Subiectul I-II</p>
                                <p>${istorieStageSubIVal} <button class="btn btn-primary" id="sub1I" name="sub1I">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul III</p>
                                <p>${istorieStageSubIIIVal} <button class="btn btn-primary" id="sub3I" name="sub3I">&#206ncepe</button></p>
                            </div>
                        </td>
                    </tr>
                    <tr id="geografieTab">
                        <td>
                        <div>
                            <p>Geografie</p>
                            <p><progress style="width: 280px;" max="100" value="${geografieStageSubI}"></progress></p>
                            <p>Locul X &#238n clasament</p>
                            <p>Geografie</p>
                            <p><progress style="width: 280px;" max="100" value="${geografieStageSubII}"></progress></p>
                            <p>Locul X &#238n clasament</p>
                            <p>Geografie</p>
                            <p><progress style="width: 280px;" max="100" value="${geografieStageSubIII}"></progress></p>
                            <p>Locul X &#238n clasament</p>
                        </div>
                        </td>
                        <td>
                            <div>
                                <p>Mod de &#238nv&#259&#539are: Subiectul I</p>
                                <p>${geografieStageSubIVal} <button class="btn btn-primary" id="sub1G" name="sub1G">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul II</p>
                                <p>${geografieStageSubIIVal} <button class="btn btn-primary" id="sub2G" name="sub2G">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul III</p>
                                <p>${geografieStageSubIIIVal} <button class="btn btn-primary" id="sub3G" name="sub3G">&#206ncepe</button></p>
                            </div>
                        </td>
                    </tr>
                    <tr id="biologieTab">
                        <td>
                            <div>
                                <p>Biologie</p>
                                <p><progress style="width: 280px;" max="100" value="${biologieStageSubI}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                                <p>Biologie</p>
                                <p><progress style="width: 280px;" max="100" value="${biologieStageSubII}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                                <p>Biologie</p>
                                <p><progress style="width: 280px;" max="100" value="${biologieStageSubIII}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                            </div>
                        </td>
                        <td>
                            <div>
                                <p>Mod de &#238nv&#259&#539are: Subiectul I</p>
                                <p>${biologieStageSubIVal} <button class="btn btn-primary" id="sub1B" name="sub1B">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul II</p>
                                <p>${biologieStageSubIIVal} <button class="btn btn-primary" id="sub2B" name="sub2B">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul III</p>
                                <p>${biologieStageSubIIIVal} <button class="btn btn-primary" id="sub3B" name="sub3B">&#206ncepe</button></p>
                            </div>
                        </td>
                    </tr>
                    <tr id="anatomieTab">
                        <td>
                            <div>
                                <p>Anatomie</p>
                                <p><progress style="width: 280px;" max="100" value="${anatomieStageSubI}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                                <p>Anatomie</p>
                                <p><progress style="width: 280px;" max="100" value="${anatomieStageSubII}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                                <p>Anatomie</p>
                                <p><progress style="width: 280px;" max="100" value="${anatomieStageSubIII}"></progress></p>
                                <p>Locul X &#238n clasament</p>
                            </div>
                        </td>
                        <td>
                            <div>
                                <p>Mod de &#238nv&#259&#539are: Subiectul I</p>
                                <p>${anatomieStageSubIVal} <button class="btn btn-primary" id="sub1A" name="sub1A">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul II</p>
                                <p>${anatomieStageSubIIVal} <button class="btn btn-primary" id="sub2A" name="sub2A">&#206ncepe</button></p><br />
                                <p>Mod de &#238nv&#259&#539are: Subiectul III</p>
                                <p>${anatomieStageSubIIIVal} <button class="btn btn-primary" id="sub3A" name="sub3A">&#206ncepe</button></p>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <br />
                <div id="drop" class="dropdown">
                <button type="button" id="add" name="add" class="btn btn-default dropdown-toggle" id="addValues" data-toggle="dropdown">+Adauga materie</button>
                <ul  class="dropdown-menu" role="menu" aria-labelledby="addValues">
                    <li id="ist" role="presentation"><a role="menuitem" tabindex="-1" href="#">Istorie</a></li>
                    <li id="geo" role="presentation"><a role="menuitem" tabindex="-1" href="#">Geografie</a></li>
                    <li id="bio" role="presentation"><a role="menuitem" tabindex="-1" href="#">Biologie</a></li>
                    <li id="ana" role="presentation"><a role="menuitem" tabindex="-1" href="#">Anatomie</a></li>
                </ul>
                </div>

                <input type="hidden" value="${istorieStageSubI}+${istorieStageSubIII}" id="istorieVal"/>
                <input type="hidden" value="${geografieStageSubI}+${geografieStageSubII}+${geografieStageSubIII}" id="geografieVal"/>
                <input type="hidden" value="${biologieStageSubI}+${biologieStageSubII}+${biologieStageSubIII}" id="biologieVal"/>
                <input type="hidden" value="${anatomieStageSubI}+${anatomieStageSubII}+${anatomieStageSubIII}" id="anatomieVal"/>
            </div>
        </div>
    </div>
<script src="/resources/js/script.js"></script>

<script>

//    $('#sub1R').on("click", function() {
//        $('#material').val('romana1');
//        $('#materialForm').submit();
//    });
//
//    $('#sub3R').on("click", function() {
//        $('#material').val('romana3');
//        $('#materialForm').submit();
//    });



    var istorieEvents = function() {
        $('#sub1I').on("click", function () {
            $('#material').val('istorie1');
            $('#materialForm').submit();
        });

        $('#sub3I').on("click", function () {
            $('#material').val('istorie3');
            $('#materialForm').submit();
        });
    }

    var geografieEvents = function() {
        $('#sub1G').on("click", function () {
            $('#material').val('geografie1');
            $('#materialForm').submit();
        });

        $('#sub2G').on("click", function () {
            $('#material').val('geografie2');
            $('#materialForm').submit();
        });

        $('#sub3G').on("click", function () {
            $('#material').val('geografie3');
            $('#materialForm').submit();
        });
    }

    var biologieEvents = function() {
        $('#sub1B').on("click", function () {
            $('#material').val('biologie1');
            $('#materialForm').submit();
        });

        $('#sub2B').on("click", function () {
            $('#material').val('biologie2');
            $('#materialForm').submit();
        });

        $('#sub3B').on("click", function () {
            $('#material').val('biologie3');
            $('#materialForm').submit();
        });
    }

    var anatomieEvents = function() {
        $('#sub1A').on("click", function () {
            $('#material').val('anatomie1');
            $('#materialForm').submit();
        });

        $('#sub2A').on("click", function () {
            $('#material').val('anatomie2');
            $('#materialForm').submit();
        });

        $('#sub3A').on("click", function () {
            $('#material').val('anatomie33');
            $('#materialForm').submit();
        });
    }

    $('#add').on('click', function() {
        var centeredTagHeight = $('#centeredTag').height()+70;
        $('#drop').attr('style', 'position: absolute');
        $('#centeredTag').attr('style', 'height:'+centeredTagHeight+'px');
    });

    var removeStyles = function() {
        $('#drop').removeAttr('style');
        $('#centeredTag').removeAttr('style');
    }

    $('#ist').on('click', function() {
        removeStyles();
        $('#istorieTab').show();
        istorieEvents();
    });

    $('#geo').on('click', function() {
        removeStyles();
        $('#geografieTab').show();
        geografieEvents();
    });

    $('#bio').on('click', function() {
        removeStyles();
        $('#biologieTab').show();
        biologieEvents();
    });

    $('#ana').on('click', function() {
        removeStyles();
        $('#anatomieTab').show();
        anatomieEvents();
    });
</script>

</body>
</html>
