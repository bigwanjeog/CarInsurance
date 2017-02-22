/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    goToTop();
    pageFormulaire();
    listConstructeurModeleVoiture();

    if (document.getElementById("chatDiv") !== null) {
        pageChat();
    }
});

function goToTop() {
    $(window).scroll(function () {
        if ($(this).scrollTop() > 50) {
            $('#back-to-top').fadeIn();
        } else {
            $('#back-to-top').fadeOut();
        }
    });
    // scroll body to 0px on click
    $('#back-to-top').click(function () {
        $('#back-to-top').tooltip('hide');
        $('body,html').animate({
            scrollTop: 0
        }, 800);
        return false;
    });

    $('#back-to-top').tooltip('show');
}

function pageFormulaire() {
    if (document.getElementById("inputDateNaissance") !== null) {
        $(function () {
            $("#inputDateNaissance").datepicker();
        });
    }
}

function pageChat() {
    var btnChat = $("#btnChat");
    var inputChat = $("#inputChat");
    var webSocket = new WebSocket("ws://192.168.1.177:8080/CarInsurance/chat");

    webSocket.onerror = function (event) {
        console.log("error");
    };
    webSocket.onopen = function (event) {
    };
    webSocket.onclose = function (event) {
        console.log("close");
    };
    webSocket.onmessage = function (event) {
        var tableChat = $("#tableChat tr:last");
        var date = getDate(new Date());
        console.log(event.data);
        var json = JSON.parse(event.data);
        tableChat.after('<tr ><td class="pseudo">' + date + ' | ' + json.pseudo + '</td><td>' + json.msg + '</td></tr>');
        $("#chatDiv").scrollTop($("#chatDiv")[0].scrollHeight);

    };


    inputChat.keypress(function (event) {
        if (event.which === 13) {
            sendMessage(webSocket);
        }
    });

    btnChat.click(function () {
        sendMessage(webSocket);
    });
}

function sendMessage(webSocket) {
    var inputChat = $("#inputChat");
    getPseudo(function (pseudo) {
        var json = '{ "pseudo": "' + pseudo + '", "msg": "' + inputChat.val() + '"}';
        inputChat.attr("placeholder", "Entrez votre message...");
        inputChat.val("");
        webSocket.send(json);
    });
}

function getPseudo(callback) {
    $.get("app", {request: "pseudo"}, function (responseJson) {
        callback(responseJson.pseudo);
    });
}


function getDate(date) {
    return addZero(date.getHours()) + ":" + addZero(date.getMinutes()) + ":" + addZero(date.getSeconds());
}

function addZero(temp) {
    if (temp < 10) {
        return "0" + temp;
    } else {
        return temp;
    }
}

function listConstructeurModeleVoiture() {
    var selectConstructeur = $("#selectConstructeur");
    var selectModele = $("#selectModele");
    var selectVoiture = $("#selectVoiture");
    if (document.getElementById("selectConstructeur") !== null) {
        selectConstructeur.append($(new Option("Constructeur", "null")));
        selectModele.append($(new Option("Modele", "null")));
        selectVoiture.append($(new Option("Voiture", "null")));

        $.get("app", {resultat: "constructeur"}, function (responseJson) {
            $.each(responseJson, function (index, item) {
                selectConstructeur.append($(new Option(item.nom, item.id)));
            });
        });

        selectConstructeur.on("change", function () {
            var val = $(this).val();

            resetModele(selectModele);
            resetVoiture(selectVoiture);
            validatorVoiture();

            if (val !== "null") {
                $.get("app", {resultat: "modele", modele: val}, function (responseJson) {
                    $.each(responseJson, function (index, item) {
                        selectModele.append($(new Option(item.nom, item.id)));
                    });
                });
            }
        });

        selectModele.on("change", function () {
            var val = $(this).val();

            resetVoiture(selectVoiture);
            validatorVoiture();

            if (val !== "null") {
                $.get("app", {resultat: "voiture", voiture: val}, function (responseJson) {
                    $.each(responseJson, function (index, item) {
                        var value = "Année : " + item.annee + " | Carburant : " + item.carburant + " | Chevaux : " + item.chevaux;
                        selectVoiture.append($(new Option(value, item.id)));
                    });
                });
            }
        });

        $("#selectVoiture").on("change", function () {
            validatorVoiture();
        });
    }
}

function resetModele(selectModele) {
    selectModele.empty();
    selectModele.append($(new Option("Modèle", "null")));
}

function resetVoiture(selectVoiture) {
    selectVoiture.empty();
    selectVoiture.append($(new Option("Voiture", "null")));
}

function validatorVoiture() {
    var value = $("#selectVoiture").val();
    var btnVoiture = $("#btnVoiture");
    if (value === "null") {
        btnVoiture.prop('disabled', true);
    } else {
        btnVoiture.prop('disabled', false);
    }
}

