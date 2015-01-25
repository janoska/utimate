
<%--
  Created by IntelliJ IDEA.
  User: sara
  Date: 12.11.2014
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="/resources/css/game.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/resources/jsp/menubar.jsp"%>

<div id="background">
    <div id="wrapper">
      <form:form method="POST" commandName="game">
        <%--<input type="hidden" name="questionCounter" id="questionCounter" value="" />--%>
        <%--<input type="hidden" name="remainingQuestions" id="remainingQuestions" value="" />--%>
        <%--<input type="hidden" name="correctAnswers" id="correctAnswers" value="" />--%>
        <%--<input type="hidden" name="incorrectAnswers" id="incorrectAnswers" value="" />--%>
        <div id="questionWindow">
          <p id="questionText">What is your name?</p>
        </div>

        <div id="answerButtons">
          <div class="answers">
            <label class="lab">
              <div id="ans1">
                <form:checkbox path="answer1" id="answer1" value="Janos" /><span>Janos</span>
              </div>
            </label>
          </div>

          <div class="answers">
            <label class="lab">
              <div id="ans2">
                <form:checkbox path="answer2" id="answer2" value="Timea" /><span>Timea</span>
              </div>
            </label>
          </div>

          <div class="answers">
            <label class="lab">
              <div id="ans3">
                <form:checkbox path="answer3" id="answer3" value="Radu" /><span>Radu</span>
              </div>
            </label>
          </div>


          <div class="answers">
            <label class="lab">
              <div id="ans4">
                <form:checkbox path="answer4" id="answer4" value="Attila" /><span>Attila</span>
              </div>
            </label>
          </div>
        </div>

        <div id="responseButton">
          <input type="submit" id="submit" class="btn btn-success" value="Raspunde" />
        </div>
          <div id="InfoWindow">
            <div class="infos">
              Total Intrebari: 1780
            </div>
            <div class="infos">
              Intrebari ramase: 1500
            </div>
            <div class="infos">
              Raspunsuri corecte: 200
            </div>
            <div class="infos">
              Raspunsuri incorecte: 79
            </div>
          </div>

      </form:form>

      <script src="/resources/js/script.js"></script>
    </div>
</div>


</body>
</html>
