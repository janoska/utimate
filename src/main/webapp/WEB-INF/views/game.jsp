
<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 12.11.2014
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <%@include file="/resources/jsp/includes.html"%>
  <link href="/resources/css/game.css" rel="stylesheet" type="text/css" />
  <%--<link href="/resources/css/game.css" rel="stylesheet" type="text/css" />--%>
</head>
<body>
<div id="background">
    <div id="wrapper">
      <div id="centeredTag" style="margin-top: 50px; height: 650px;">
      <form:form method="POST" commandName="game" id="startGames">
        <div style="margin: 0 auto; text-align: center; font-weight: bold; font-size: 18px;">
          Subiectul ${subject}
          <progress style="width: 200px;" max="100" value="${currentStage}"></progress>
          ${curriculum}
        </div><br />

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
        </div><br />

        <div id="responseButton">
          <button id="submitAnswer" class="btn btn-primary">R&#259spunde</button>
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
        <div id="stopGame">Ma opresc si continui mai tarziu
          <button class="btn btn-default" id="stop" name="stop">Stop</button>
        </div>
    </div>
</div>
</div>
<form:form method="post" action="/learn/stop" id="stopGames">
</form:form>
<script>
  $('#stop').on('click', function() {
    $('#stopGames').submit();
  });

  $('#submitAnswer').on('click', function() {
    $('#startGames').submit();
  });
</script>
</body>
</html>
