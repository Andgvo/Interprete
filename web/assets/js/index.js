$(window).scroll(function () {
    var top = $(document).scrollTop();
    $('.splash').css({
        'background-position': '0px -'+(top/3).toFixed(2)+'px'
    });
    if(top > 40)
        $('.navbar').removeClass('navbar-transparent');
    else
        $('.navbar').addClass('navbar-transparent');
});

$(document).ready(function () {
    // Page scrolling feature
    $('a.elemento-scroll').bind('click', function(event) {
        var link = $(this);
        $('html, body').stop().animate({
            scrollTop: $(link.attr('href')).offset().top - 40
        }, 500);
        event.preventDefault();
    });
    $('body').scrollspy({
        target: '.navbar-fixed-top',
        offset: 80
    });
});