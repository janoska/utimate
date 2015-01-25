<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/23/2014
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/resources/css/style.css" rel="stylesheet"  type="text/css" />
    <link href="/resources/css/bootstrap/css/bootstrap.css" rel="stylesheet"  type="text/css" />
</head>
<body>
    <div id="background">
        <div id="wrapper">
            <div style="text-align: center; font-weight: bold; font-size: 20px; margin-top: 20px; padding-bottom: -20px;">Adaug&#259 &#238ntreb&#259ri pentru materii</div>
            <div id="centeredTag" style="margin-top: 50px; height:550px;">

            <form:form method="post" style="text-align: center;">
    <div style="float: left; font-weight: bold; font-size: 15px;">Selecteaz&#259 materia
        <select id="curriculum" name="curriculum" class="form-control form-control-inline">
            <option value="romana">Roman&#259</option>
            <option value="istorie">Istorie</option>
            <option value="geografie">Geografie</option>
            <option value="biologie">Biologie</option>
            <option value="anatomie">Anatomie</option>
        </select>
    </div>
                <div style="float: right; font-weight: bold; font-size: 15px;">Selecteaz&#259 subiectul
                    <select id="subject" name="subject" class="form-control form-control-inline">
                        <option value="1">Subiectul I</option>
                        <option value="2">Subiectul II</option>
                        <option value="3">Subiectul III</option>
                    </select>
                </div><br /><br /><br /><br />

    <div style="width: 500px; margin: 0 auto;">
        <p style="font-weight: bold; font-size: 15px;">&#206ntrebare:</p>
         <textarea class="form-control" name="question" id="question" cols="30" rows="3" required></textarea>
    </div><br />
                <div class="row">
                    <div style="width: 50%; margin: 0 auto;">
                        <div class="input-group">
                            <input type="text" id="answer1" name="answer1" class="form-control" placeholder="R&#259spuns 1" required>
                            <span class="input-group-addon">
                                <input type="checkbox" id="corrAnswer1" name="corrAnswer1">
                            </span>
                        </div>
                    </div>
                </div><br />

                <div class="row">
                    <div style="width: 50%; margin: 0 auto;">
                        <div class="input-group">
                            <input type="text" id="answer2" name="answer2" class="form-control" placeholder="R&#259spuns 2" required>
                            <span class="input-group-addon">
                                <input type="checkbox" id="corrAnswer2" name="corrAnswer2">
                            </span>
                        </div>
                    </div>
                </div><br />

                <div class="row">
                    <div style="width: 50%; margin: 0 auto;">
                        <div class="input-group">
                            <input type="text" id="answer3" name="answer3" class="form-control" placeholder="R&#259spuns 3" required>
                            <span class="input-group-addon">
                                <input type="checkbox" id="corrAnswer3" name="corrAnswer3">
                            </span>
                        </div>
                    </div>
                </div><br />

                <div class="row">
                    <div style="width: 50%; margin: 0 auto;">
                        <div class="input-group">
                            <input type="text" id="answer4" name="answer4" class="form-control" placeholder="R&#259spuns 4" required>
                            <span class="input-group-addon">
                                <input type="checkbox" id="corrAnswer4" name="corrAnswer4">
                            </span>
                        </div>
                    </div>
                </div><br />

    <div id="button">
        <input type="submit" class="btn btn-success" id="submit" value="Adauga" />
    </div>
</form:form>
            </div>
        </div>
    </div>
</body>
</html>
