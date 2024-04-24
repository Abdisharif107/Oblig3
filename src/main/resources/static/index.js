$(function (){
    hentAlt();
})

function hentAlt(){
    $.get("/hentAlt", function (format){
        hentData(format);
    })
}

function hentData(format){
    let ut = "<table class='table table-striped'>" +
        "<tr><th>Film</th><th>Antall</th><th>Fornavn</th><th>Etternavn</th><th>Adresse</th>" +
        "<th>Mobilnummer</th><th>Epost</th></tr>";
    for (let billett of format) {
        ut += "<tr><td>" + billett.film + "</td><td>" + billett.antall +
            "</td><td>" + billett.fornavn + "</td><td>"
            + billett.etternavn + "</td><td>" + billett.adresse + "</td><td>" + billett.mobilnummer +
            "</td><td>" + billett.epost +
            "<td> <button class='btn btn-primary' onclick='idTilEndring("+billett.id+")'>Endre</button></td>"+
            "<td> <button class='btn btn-danger' onclick='slettEnBillett("+billett.id+")'>Slett</button></td>"+
            "</td>"
        ut += "</tr>";
    }
    ut += "</table>";
    $("#filmene").html(ut);
}

function idTilEndring(id){
    window.location.href="/endre.html?" + id;
}

function slettEnBillett(id){
    const url = "/slettEnBillett?id=" + id;
    $.get(url, function (){
        window.location.href="/"
    });
}

function slettBillett() {
    $.get("/slettBillett", function () {
        hentAlt();
    });
}