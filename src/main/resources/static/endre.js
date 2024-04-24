$(function (){
    henteEnBillett();
})

function henteEnBillett(){
    const id = window.location.search.substring(1); // kommer fra kallet i index.js
    const url = "/henteEnBillett?id="+id;
    $.get( url, function(enBillett) {
        // overfør til input-feltene i skjemaet
        $("#id").val(enBillett.id); // må ha med denne for å vite hvilken id
        $("#film").val(enBillett.film);
        $("#antall").val(enBillett.antall);
        $("#fornavn").val(enBillett.fornavn);
        $("#etternavn").val(enBillett.etternavn);
        $("#adresse").val(enBillett.adresse);
        $("#mobilnummer").val(enBillett.mobilnummer);
        $("#epost").val(enBillett.epost);
    });
}

function endreBillett(){
    const billett = {
        id : $("#id").val(),
        film : $("#film").val(),
        antall : $("#antall").val(),
        fornavn : $("#film").val(),
        etternavn : $("#etternavn").val(),
        adresse : $("#adresse").val(),
        mobilnummer : $("#mobilnummer").val(),
        epost : $("#epost").val(),
    };
    $.post("/endre", billett, function(){
    });
    window.location.href="/index.html";
}