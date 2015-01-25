<%--
  Created by IntelliJ IDEA.
  User: jboy
  Date: 9/13/2014
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation" >
    <div style="float: left;margin-left: 100px; margin-top: -8px; color: blue; font-weight: bold;" >
        <h2 style="font-family: 'Times New Roman', Times, serif;">Iau Bacu Lejer</h2>
    </div>

    <c:if test="${sessionScope.username != null}">
    <div style="float: left; margin-left: 30px; margin-top: 6px;">
        <ul class="nav nav-pills" role="tablist">
            <li><a href="/home">Acasa</a></li>
            <li><a href="/profile">Profil</a></li>
            <li><a href="/learn">Invata</a></li>
            <li><a href="/rank">Clasament</a></li>
        </ul>
    </div>
    </c:if>

    <div style="float: right; margin-right: 15px; margin-top: 8px;">
        <c:if test="${sessionScope.username != null}">
            <%@include file="logout.jsp"%>
        </c:if>
        <c:if test="${sessionScope.username == null}">
            <div style="height: 40px;"><%@include file="login.jsp"%></div>
        </c:if>
    </div>

    <div style="float:right; margin-right: 15px; margin-top: 3px;">
        <c:if test="${sessionScope.username != null}">
        <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                <a><img src="/resources/img/setting.png" width="35" height="35"></a>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Profile</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Account</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Style</a></li>
                <li role="presentation" class="divider"></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Querstions</a></li>
            </ul>
        </div>
    </c:if>
        <c:if test="${sessionScope.username == null}">
            <%--<a href="#" style="text-decoration: none; "><div style="height: 50px; width: 100px; padding-top: 8px; color: #ffffff; font-weight: bold; font-size: 18px; text-decoration: none; " >--%>
                <%--<img src="/resources/img/fb_login.png" width="32" height="32" /> Login--%>
            <%--</div></a>--%>
            <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
            </fb:login-button>
            <%--<div style="margin-top:9px;" class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="false" data-auto-logout-link="false"></div>--%>
        </c:if>
    </div>

    <div style="float: right; margin-right: 15px; font-weight: bold; margin-top: 17px;" >
        <c:if test="${sessionScope.username != null}">
            Bun venit: ${sessionScope.username}
        </c:if>
    </div>
</nav>
<div id="fbStatus" hidden="hidden"></div>
<div id="fb-root"></div>

<c:if test="${sessionScope.username == null}">

<script>

    function statusChangeCallback(response) {
        console.log('statusChangeCallback');
        console.log(response);
        // The response object is returned with a status field that lets the
        // app know the current login status of the person.
        // Full docs on the response object can be found in the documentation
        // for FB.getLoginStatus().
        if (response.status === 'connected') {
            // Logged into your app and Facebook.
            loadUserInfos();
        } else if (response.status === 'not_authorized') {
            // The person is logged into Facebook, but not your app.
        //    document.getElementById('status').innerHTML = 'Please log ' +
          //  'into this app.';
        } else {
            // The person is not logged into Facebook, so we're not sure if
            // they are logged into this app or not.
      //      document.getElementById('status').innerHTML = 'Please log ' +
       //     'into Facebook.';
        }

    }

    // This function is called when someone finishes with the Login
    // Button.  See the onlogin handler attached to it in the sample
    // code below.
    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
        return statusChangeCallback(response);
    }

    window.fbAsyncInit = function() {
        FB.init({
            appId      : '796119047096634',
            cookie     : true,  // enable cookies to allow the server to access
                                // the session
            xfbml      : true,  // parse social plugins on this page
            version    : 'v2.1' // use version 2.1
        });

        // Now that we've initialized the JavaScript SDK, we call
        // FB.getLoginStatus().  This function gets the state of the
        // person visiting this page and can return one of three states to
        // the callback you provide.  They can be:
        //
        // 1. Logged into your app ('connected')
        // 2. Logged into Facebook, but not your app ('not_authorized')
        // 3. Not logged into Facebook and can't tell if they are logged into
        //    your app or not.
        //
        // These three cases are handled in the callback function.

        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });


    };
    // Load the SDK asynchronously
    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    // Here we run a very simple test of the Graph API after login is
    // successful.  See statusChangeCallback() for when this call is made.
    function loadUserInfos() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log('Successful login for: ' + response.name);
//            document.getElementById('').innerHTML = response;
            $("#fname").val(response.first_name);
            $("#lname").val(response.last_name);
            $("#mail").val(response.email);
            $("#fbsubmit").submit();
        });
    };

    //    function infos() {
    //        FB.api('/me', function(response) {
    //            console.log(JSON.stringify(response));
    //            document.getElementById('fbinfo').innerHTML = JSON.stringify(response);
    //        });
</script>

</c:if>