<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/27/2014
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<div id="leftTag">
    <H1 style="margin-top: 50px; margin-bottom: 50px; text-align: center">Iau Bacu Lejer</H1>
    <div style="font-size: 17px; margin-bottom: 40px;">
    Primul joc de acest gen venit &#238n ajutorul elevilor. Toate materialele sunt verificate &#351i revizuite permanent de c&#259tre profesori califica&#539i care sus&#539in &#238nv&#259&#539atul inteligent!
    Echipa IauBacuLejer &#238&#539i ofer&#259 metoda prin care s&#259 acumulezi repede &#x219i f&#259r&#259 b&#259t&#259i de cap materia pentru examen.
    Intreb&#259rile sunt atent selec&#539ionate pentru a cuprinde informa&#539iile cele mai valoroase, excluz&#226nd orice informa&#539ie care se pred&#259 &#238n plus la &#351coal&#259.
    Totul va fi ca un joc, nici nu trebuie s&#259 te concentrezi prea tare, informa&#539iile &#238&#539i vor intra &#238n subcon&#x219tient prin repeti&#539ie iar la examen nu vei avea probleme.
    </div>
    <div style="text-align: center;">
    <button id="start" name="start" class="btn btn-primary"><div style="font-size: 25px;">&#206ncepe</div></button>
    </div>
    <form method="post" action="/home" id="fbsubmit">

    <input type="hidden" id="fname" name="fname"/>
    <input type="hidden" id="lname" name="lname"/>
    <input type="hidden" id="mail" name="mail"/>

    </form>
    <input type="hidden" id="" />

</div>

<div id="rightTag">
    <p style="font-size: 18px;">Site-ul cuprinde:</p>
    <p>- 4 materii (Rom&#226n&#259, Istorie, Geografie, Biologie)</p>
    <p>- &#238ntreb&#259ri &#x219i r&#259spunsuri din toat&#259 materia de bac pentru fiecare subiect &#238n parte</p>
    <p>- clasament &#238n care po&#539i s&#259 &#238&#539i vezi punctajul fa&#539&#259 de prieteni</p>
    <p>+ multe alte materii ce vor fi ad&#259ugate &#238n foarte scurt timp pe m&#259sur&#259 ce cre&#x219te traficul pe site</p>
    <p>+ site-ul este absolut gratuit, cu rug&#259mintea s&#259-l sus&#539ine&#539i cu un like, mul&#539umim!</p>
</div>

<div id="loginRegister" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 720px; height: 420px; margin: 0 auto; padding-left: 30px; padding-right: 30px;">
            <%-- dialog header --%>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                Logheaz&#259-te / Registreaz&#259-te
            </div>
            <!-- dialog body -->
            <div class="modal-body" style="height: 450px;">
                <div style="width:300px; float:left; height:300px; border-left:1px solid lightgray; text-align: center;">
                    <p style="font-size: 18px; color: grey; font-weight: bold;">Logheaz&#259-te!</p>
                    <div style="margin: 0 auto; width: 220px; border-left: 1px solid lightgray; border-right: 1px solid lightgray; border-bottom: 1px solid lightgray;">
                        <%@include file="login.jsp"%>
                        <p><a href="">Am uitat parola</a></p>
                    </div><br /><br />
                    <div id="fbLogin" class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="false" data-auto-logout-link="false"></div>

                <%--<div style="border-radius: 4px; margin: 0 auto; width:160px; color:#ffffff; background-color: #2b669a; font-size: 30px; font-weight: bold; padding-right: 8px;">--%>
                    <%--<img src="/resources/img/fb_login.png" /> Intrare--%>
                </div>
                <div style="width: 300px; float: right; height:300px; border-right:1px solid lightgray; text-align: center;">
                    <p style="font-size: 18px; color: grey; font-weight: bold;">Creeaz&#259 cont nou!</p>
                    <form:form method="post" action="/register" commandName="register" data-toggle="validator" role="form" id="registerForm">
                    <div style="width: 250px; margin:0 auto; text-align: center;">
                    <input type="text" placeholder="Nume" class="form-control" name="firstName" id="firstName" maxlength="20" size="20" required/>
                    <input type="text" placeholder="Prenume" class="form-control" name="lastName" id="lastName" maxlength="20" size="20" required/>
                    <input type="text" placeholder="Nume Utilizator" class="form-control" name="userName" id="userName" maxlength="20" size="20" required/>
                    <input type="password" data-minlength="6" placeholder="Parol&#259" class="form-control" name="password" id="password" maxlength="20" size="20" required/>
                    <input type="password" data-match="#password" data-match-error="Parolele nu sunt autentice" placeholder="Rescrie parola" class="form-control" name="passwordAgain" id="passwordAgain" maxlength="20" size="20" required/>
                    <input type="email" data-error="Adresa de e-mail invalid" placeholder="E-mail" class="form-control" name="email" id="email" maxlength="30" size="20" required/>
                    </div><br />
                        <input type="submit" class="btn btn-success" value="Cont nou" id="submitRegister" name="submitRegister" />
                    </form:form>
                    </div>
            </div>
        </div>
    </div>
</div>

<div id="loginError" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 300px; height: 180px; margin: 0 auto; text-align: center;">
            <%-- dialog header --%>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                Erroare de autentificare
            </div>
            <!-- dialog body -->
            <div class="modal-body" >
                <p style="color: red; font-weight: bold; font-size: 18px;">${error}</p>
                <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
                </div>
            </div>
        </div>
    </div>
<c:if test="${not empty error}">
<%--<div class="error">${error}</div>--%>
    <input type="hidden" value="${error}" id="authError" />
</c:if>
<%--<c:if test="${not empty msg}">--%>
<%--&lt;%&ndash;<div class="msg">${msg}</div>&ndash;%&gt;--%>
<%--</c:if>--%>

<script src="/resources/js/home.js"></script>

