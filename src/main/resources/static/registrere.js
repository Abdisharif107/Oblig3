$(function (){
    hentAlt();
});

function hentAlt(){
    $.get("/hentAlt", function (){
    })
}
function validerForavn(fornavn) {
    let regx = /[a-zæøåA-ZÆØÅ. -]{2,50}$/;
    if (regx.test(fornavn)) {
        $("#feil3").html("")
        return true;
    } else {
        $("#feil3").html("Fornavn feltet er påkrevet")
        return false;
    }
}

//Mobilnummer validation
function valMobilnummer(mobilnummer){
    let regx =/^[0-9]{8}$/;
    return regx.test(mobilnummer);

}

//E-post validation
function valEpost(epost){
    const regx = /^[a-z A-Z0-9.-]+@[a-z]+\.[a-zA-Z]{2,}$/;
    return regx.test(epost);
}

function feilMelding(){
    $("#feil1").html("");
    $("#feil2").html("");
    $("#feil3").html("");
    $("#feil4").html("");
    $("#feil5").html("");
    $("#feil6").html("");
    $("#feil7").html("");
}
$(document).ready(function() {
    $('#kjopBillett').click(function() {
        let validTicket = true;
        let film = $("#film").val();
        let antall =$("#antall").val();
        let fornavn = $("#fornavn").val();
        let etternavn = $("#etternavn").val();
        let adresse = $("#adresse").val();
        let mobilnummer = $("#mobilnummer").val();
        let epost = $("#epost").val();

        if (film === "") {
            validTicket = false;
            let feil1 = $("#feil1");
            feil1.html("Velg film");
        } else {
            $("#feil1").html("")
        }
        if (antall < 1 || antall === "" || antall % 1 !== 0) {
            validTicket = false;
            let feil2 = $("#feil2");
            feil2.html("Velg antall");
        } else {
            $("#feil2").html("")
        }
        if (!validerForavn(fornavn)) {
            validTicket = false;
            let feil3 = $("#feil3");
            feil3.html("Fornavn feltet er påkrevet");

        }
        else {
            $("#feil3").html("");
        }
        if (etternavn === "") {
            validTicket = false;
            let feil4 = $("#feil4");
            feil4.html("Etternavn feltet er påkrevet");
        } else {
            $("#feil4").html("");
        }

        if (adresse === "") {
            validTicket = false;
            let feil5 = $("#feil5");
            feil5.html("Adresse feltet er påkrevet");
        } else {
            $("#feil5").html("");
        }

        // Mobilnummer validation
        if (mobilnummer === "") {
            validTicket = false
            let feil6 = $("#feil6");
            feil6.html("Mobilnummer feltet er påkrevet");
        } else if (!valMobilnummer(mobilnummer)) {
            validTicket = false;
            let feil6 = $("#feil6");
            feil6.html("Ugyldig mobilnummer, maks 8 siffer.");
        } else {
            $("#feil6").html("");
        }

        // Epost validation
        if (epost === "") {
            validTicket = false;
            let feil7 = $("#feil7");
            feil7.html("E-post feltet er påkrevet.");
        } else if (!valEpost(epost)) {
            validTicket = false;
            let feil7 = $("#feil7");
            feil7.html("Vennligst skriv inn en gyldig e-post.")
            console.log("1");
        } else {
            $("#feil7").html("")
        }


        if (validTicket){
            const billett= {
                film: $("#film").val(),
                antall: $("#antall").val(),
                fornavn: $("#fornavn").val(),
                etternavn: $("#etternavn").val(),
                adresse: $("#adresse").val(),
                mobilnummer: $("#mobilnummer").val(),
                epost: $("#epost").val(),
            }
            $("#film").val("Velg film");
            $("#antall").val("");
            $("#fornavn").val("");
            $("#etternavn").val("");
            $("#adresse").val("");
            $("#mobilnummer").val("");
            $("#epost").val("");

            $.post("/lagre", billett, function (){
                hentAlt();
            });
            feilMelding();
            window.location.href="/";
        }
    });
});