<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/27/2014
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/resources/jsp/includes.html"%>
<link href="/resources/css/game.css" rel="stylesheet" type="text/css" />


<div id="gameImg">
    <img src="resources/img/intro.jpg" width="400" height="300"/>
</div>

<form:form method="POST" commandName="game">
    <%--<input type="hidden" name="questionCounter" id="questionCounter" value="" />--%>
    <%--<input type="hidden" name="remainingQuestions" id="remainingQuestions" value="" />--%>
    <%--<input type="hidden" name="correctAnswers" id="correctAnswers" value="" />--%>
    <%--<input type="hidden" name="incorrectAnswers" id="incorrectAnswers" value="" />--%>
    <div id="questionWindow">
       <p id="questionText">${question}</p>
    </div>

    <div id="answerButtons">
    <div class="answers">
        <label class="lab">
            <div id="ans1">
                <form:checkbox path="answer1" id="answer1" value="${answer1}" /><span>${answer1}</span>
            </div>
        </label>
    </div>

    <div class="answers">
        <label class="lab">
            <div id="ans2">
                <form:checkbox path="answer2" id="answer2" value="${answer2}" /><span>${answer2}</span>
            </div>
        </label>
    </div>

    <div class="answers">
        <label class="lab">
            <div id="ans3">
                <form:checkbox path="answer3" id="answer3" value="${answer3}" /><span>${answer3}</span>
            </div>
        </label>
    </div>


    <div class="answers">
        <label class="lab">
            <div id="ans4">
                <form:checkbox path="answer4" id="answer4" value="${answer4}" /><span>${answer4}</span>
            </div>
        </label>
    </div>
    </div>

    <div id="responseButton">
        <input type="submit" id="submit" class="btn btn-success" value="Raspunde" />
    </div>

    <div id="InfoWindow">
        <div class="infos">
            Total Intrebari: ${totalQuestions}
        </div>
        <div class="infos">
            Intrebari ramase: ${remainedQuestions}
        </div>
        <div class="infos">
            Raspunsuri corecte: ${correctAnswers}
        </div>
        <div class="infos">
            Raspunsuri incorecte: ${incorrectAnswers}
        </div>
    </div>

</form:form>

<script src="/resources/js/script.js"></script>