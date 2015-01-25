$(document).ready(function() {

    //$('#start').click(function() {
    //    $("#myModal").on("show", function() { // wire up the OK button to dismiss the modal when shown
    //        $("#myModal a.btn").on("click", function(e) {
    //            console.log("button pressed"); // just as an example...
    //            $("#myModal").modal('hide'); // dismiss the dialog
    //        });
    //    });
    //
    //    $("#myModal").on("hide", function() { // remove the event listeners when the dialog is dismissed
    //        $("#myModal a.btn").off("click");
    //    });
    //    $("#myModal").on("hidden", function() { // remove the actual elements from the DOM when fully hidden
    //        $("#myModal").remove();
    //    });
    //    $("#myModal").modal({ // wire up the actual modal functionality and show the dialog
    //        "backdrop" : "static",
    //        "keyboard" : true,
    //        "show" : true // ensure the modal is shown immediately
    //    });
    //});
    //
    //$("#myModal").on("show", function() { // wire up the OK button to dismiss the modal when shown
    //    $("#myModal a.btn").on("click", function(e) {
    //        console.log("button pressed"); // just as an example...
    //        $("#myModal").modal('hide'); // dismiss the dialog
    //    });
    //});
    //
    //$("#myModal").on("hide", function() { // remove the event listeners when the dialog is dismissed
    //    $("#myModal a.btn").off("click");
    //});
    //$("#myModal").on("hidden", function() { // remove the actual elements from the DOM when fully hidden
    //    $("#myModal").remove();
    //});

    if($(location).attr('pathname') === "/home" || $(location).attr('pathname') === "/") {
        document.getElementsByTagName("LI")[0].setAttribute("class", "active");
    }
    if($(location).attr('pathname') === "/profile") {
        document.getElementsByTagName("LI")[1].setAttribute("class", "active");
    }
    if($(location).attr('pathname') === "/learn" || $(location).attr('pathname') === "/learn/stop") {
        document.getElementsByTagName("LI")[2].setAttribute("class", "active");
        if($('#istorieVal').val() == "0+0") {
            $('#istorieTab').hide();
        }
        if($('#geografieVal').val() == "0+0+0") {
            $('#geografieTab').hide();
        }
        if($('#biologieVal').val() == "0+0+0") {
            $('#biologieTab').hide();
        }
        if($('#anatomieVal').val() == "0+0+0") {
            $('#anatomieTab').hide();
        }
    }
    if($(location).attr('pathname') === "/rank") {
        document.getElementsByTagName("LI")[3].setAttribute("class", "active");
    }

    //sign in popover event
    $("[data-toggle=popover]").popover({
        html: true,
        content: function() {
            return $('#popover-content').html();
        }
    });

    $('.dropdown-toggle').dropdown();

    //clear answer buttons
    if($('#answer1').prop('checked') || $('#answer2').prop('checked') ||
       $('#answer3').prop('checked') || $('#answer4').prop('checked')) {
        $('#answer1').removeAttr('checked');
        $('#answer2').removeAttr('checked');
        $('#answer3').removeAttr('checked');
        $('#answer4').removeAttr('checked');
    }

    //answer button events for game
    $('#answer1').on("change", function() {
        if($('#answer1').prop('checked')) {
            $('#ans1').attr('style', 'background-color: blue');
        }
        else {
            $('#ans1').removeAttr('style');
        }
    });
    $('#answer2').on("change", function() {
        if($('#answer2').prop('checked')) {
            $('#ans2').attr('style', 'background-color: blue');
        }
        else {
            $('#ans2').removeAttr('style');
        }
    });
    $('#answer3').on("change", function() {
        if($('#answer3').prop('checked')) {
            $('#ans3').attr('style', 'background-color: blue');
        }
        else {
            $('#ans3').removeAttr('style');
        }
    });
    $('#answer4').on("change", function() {
        if($('#answer4').prop('checked')) {
            $('#ans4').attr('style', 'background-color: blue');
        }
        else {
            $('#ans4').removeAttr('style');
        }
    });

    $('#sub1R').on("click", function() {
        $('#material').val('romana1');
        $('#materialForm').submit();
    });

    $('#sub3R').on("click", function() {
        $('#material').val('romana3');
        $('#materialForm').submit();
    });

    $('#sub1I').on("click", function () {
        $('#material').val('istorie1');
        $('#materialForm').submit();
    });

    $('#sub3I').on("click", function () {
        $('#material').val('istorie3');
        $('#materialForm').submit();
    });

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

});