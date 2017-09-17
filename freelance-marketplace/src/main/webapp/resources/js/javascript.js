$(document).ready(function () {
    var h = window.innerHeight
        || document.documentElement.clientHeight
        || document.body.clientHeight;
    $(".welcome").css("height", h);
    $(".signincontainer").css("height", h);
    $(".signupcontainer").css("height", h);

    $("header .hamburger .text").click(function () {
        $("header .menu").addClass("show");
    });

    $("header .menu li:first-child").click(function () {
        $("header .menu").removeClass("show");
    });
});

$(window).resize(function () {
    var h = window.innerHeight
        || document.documentElement.clientHeight
        || document.body.clientHeight;
    $(".welcome").css("height", h);
    $(".signincontainer").css("height", h);
    $(".signupcontainer").css("height", h);
});

$(window).load(function () {
});

function deleteVacancyComment(id) {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $.ajax({
        url: '/vacancies/delete_comment/',
        method: 'POST',
        data: {'id': id},

        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
        },

        success: function () {
            location.reload();
        },

        error: function () {
            alert("Не удалось удалить данный комментарий.");
        }
    });
}
