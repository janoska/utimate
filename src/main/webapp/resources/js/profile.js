/**
 * Created by jboy on 20.12.2014.
 */
$("#editProfileBtn").click(function() {
    $("#scoala").replaceWith($("<input type='text' name='scoala' value='"+$("#scoala").html()  +"' />"));
    $("#oras").replaceWith($("<input type='text' name='oras' value='"+$("#oras").html()  +"' />"));
    $("#judet").replaceWith($("<input type='text' name='judet' value='"+$("#judet").html()  +"' />"));
    $("#bac").replaceWith($("<input type='text' name='bac' value='"+$("#bac").html()  +"' />"));
    $("#editProfileBtn").replaceWith($("<button class='btn btn-primary' type='button' id='saveBtn'>Salveaza</button>"));

    $("#saveBtn").click(function() {
        $("#profileInfoForm").submit();
    });
});