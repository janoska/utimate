/**
 * Created by jboy on 20.12.2014.
 */



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