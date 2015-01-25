/**
 * Created by jboy on 20.12.2014.
 */
$('#curriculums').on("change", function() {
    $('#rank').submit();
});

if($('#selectedValue').val() == "romana") {
    $('#1').attr('selected', 'selected');
}
else if($('#selectedValue').val() == "istorie") {
    $('#2').attr('selected', 'selected');
}
else if($('#selectedValue').val() == "geografie") {
    $('#3').attr('selected', 'selected');
}
else if($('#selectedValue').val() == "biologie") {
    $('#4').attr('selected', 'selected');
}
else if($('#selectedValue').val() == "anatomie"){
    $('#5').attr('selected', 'selected');
}
else {
    $('#1').attr('selected', 'selected');
}