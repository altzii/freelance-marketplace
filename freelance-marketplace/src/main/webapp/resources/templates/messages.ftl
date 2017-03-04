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
<div style="height:78px;" class="header_container"></div>
<header class="black">
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
<div class="messages">
    <div class="top">
        <div class="inside">
            <div class="title">Чат с ${to_user.name}</div>
        </div>
    </div>
    <div class="content">
        <div class="inside">
            <div class="blocks">
            <#if messages??>
                <#list messages as message>
                    <div class="block <#if message.fromUser.id==user.id>my</#if>">
                        <div class="img"></div>
                        <div class="date">${message.date}</div>
                        <div class="name">${message.fromUser.name}</div>
                        <div class="text">${message.text}</div>
                    </div>
                </#list>
            </#if>
            </div>
            <@form.form action="/send_message/${to_id}" id="message" acceptCharset="UTF-8"  method="post">
                <input name="text" type="text"  placeholder="Введите сообщение">
                <div class="button" onclick="document.getElementById('message').submit();">Отправить</div>
            </@form.form>form>
        </div>
    </div>

</div>
<footer style="position: relative;">
    <div class="inside">
        <div class="col-3">
            <div class="title">Информация</div>
            <ul>
                <li>О нас</li>
                <li>Наш блог</li>
                <li>Карьера</li>
                <li>Пользовательское соглашение</li>
                <li>Контакты</li>
            </ul>
        </div>
        <div class="col-3">
            <div class="title">Дополнительные услуги</div>
            <ul>
                <li>Бизнес решения</li>
                <li>Платформа</li>
            </ul>
        </div>
        <div class="col-3">
            <div class="title">Соц сети</div>
            <ul>
                <li>Facebook</li>
                <li>Twitter</li>
                <li>Google Plus</li>
            </ul>
        </div>
    </div>
</footer>
</body>
<script src="/resources/js/jquery-1.11.3.min.js"></script>
<script src="/resources/js/javascript.js"></script>
</html>
