<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Freelance Marketplace</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=cyrillic" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <header>
        <div class="menu">
            <div class="inside">
                <ul>
                    <li style="margin-right: 40px;"><img src="/resources/images/close.png"></li>
                    <a href="/designers"><li>Дизайнеры</li></a>
                    <a href="/customers"><li>Заказчики</li></a>
                    <a href="/vacancies"><li>Вакансии</li></a>
                </ul>
            </div>
        </div>
        <div class="inside">
            <div class="col-3">
                <div class="hamburger">
                    <img src="/resources/images/hamburger.png">
                    <div class="text">Меню</div>
                </div>
                <div class="search">
                    <img src="/resources/images/search.png">
                    <div class="text">Поиск</div>
                </div>
            </div>
            <div class="col-3">
                <div class="logo">
                    <a href="/">FreelanceDesign</a>
                </div>
            </div>
            <div class="col-3">
            <@security.authorize access="isAnonymous()">
                <div class="signin">
                    <a href="/signin"><div class="button">Вход</div></a>
                </div>
                <div class="signup">
                    <a href="/signup"><div class="button">Регистрация</div></a>
                </div>
            </@security.authorize>
            <@security.authorize access="isAuthenticated()">
                <div class="signin">
                    <a href="/"><div class="button">${user.login}</div></a>
                </div>
                <div style="margin-left: 30px;" class="signin">
                    <a href="/j_spring_security_logout"><div class="button">Выйти</div></a>
                </div>
            </@security.authorize>
            </div>
        </div>
    </header>
    <div class="welcome">
        <div class="background"></div>
        <div class="content">
            <div class="col-2">
                <div class="inside">
                    <div class="block">
                        <div class="text">Лучший путь найти профессионала для проекта</div>
                        <a href="/vacancies"><div class="button">Оставить вакансию</div></a>
                    </div>
                </div>
            </div>
            <div class="col-2">
                <div class="inside">
                    <div class="block">
                        <div class="text">Нуждаешься в работе? Расскажи нам свою историю</div>
                        <a href="/signup"><div class="button">Зарегистрироваться</div></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="inside">
            <a href="/vacancies">
            <div class="button">
                <div class="text">Посмотреть доступные вакансии</div>
                <img src="/resources/images/arrow-next.png">
            </div>
            </a>
        </div>
    </footer>
</body>
<script src="/resources/js/jquery-1.11.3.min.js"></script>
<script src="/resources/js/javascript.js"></script>
</html>
