/**
 * Created by jboy on 20.12.2014.
 */
//$(document).ready(function() {

    $("#submitRegister").on('click', function() {
        $('#registerForm').validator();
    })


    if($("#authError").val() != null) {
        $("#loginError").on("show", function() { // wire up the OK button to dismiss the modal when shown
            $("#loginError a.btn").on("click", function(e) {
                $("#loginError").modal('hide'); // dismiss the dialog
            });
        });

        $("#loginError").on("hide", function() { // remove the event listeners when the dialog is dismissed
            $("#loginError a.btn").off("click");
        });
        $("#loginError").on("hidden", function() { // remove the actual elements from the DOM when fully hidden
            $("#loginError").remove();
        });
        $("#loginError").modal({ // wire up the actual modal functionality and show the dialog
            "backdrop" : "static",
            "keyboard" : true,
            "show" : true // ensure the modal is shown immediately
        });
    }

    $('#start').click(function() {
        $("#loginRegister").on("show", function() { // wire up the OK button to dismiss the modal when shown
            $("#loginRegister a.btn").on("click", function(e) {
                $("#loginRegister").modal('hide'); // dismiss the dialog
            });
        });

        $("#loginRegister").on("hide", function() { // remove the event listeners when the dialog is dismissed
            $("#loginRegister a.btn").off("click");
        });
        $("#loginRegister").on("hidden", function() { // remove the actual elements from the DOM when fully hidden
            $("#loginRegister").remove();
        });
        $("#loginRegister").modal({ // wire up the actual modal functionality and show the dialog
            "backdrop" : "static",
            "keyboard" : true,
            "show" : true // ensure the modal is shown immediately
        });
    });
//});