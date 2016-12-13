$(document).ready(function() {
    var h = window.innerHeight
        || document.documentElement.clientHeight
        || document.body.clientHeight;
    $(".welcome").css("height", h);
    $(".signincontainer").css("height", h);
    $(".signupcontainer").css("height", h);

    $("header .hamburger .text").click(function() {
        $("header .menu").addClass("show");
    });

    $("header .menu li:first-child").click(function() {
        $("header .menu").removeClass("show");
    });
});

$(window).resize(function() {
    var h = window.innerHeight
        || document.documentElement.clientHeight
        || document.body.clientHeight;
    $(".welcome").css("height", h);
    $(".signincontainer").css("height", h);
    $(".signupcontainer").css("height", h);
});

$(window).load(function() {
});

