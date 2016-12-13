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
<div class="signupcontainer">
    <div class="content">
        <div class="col-2">
            <div class="inside">
                <div class="block">
                    <div class="text">Лучшая площадка фриланса для дизайнеров</div>
                </div>
            </div>
        </div>
        <div class="col-2">
            <div class="inside">
                <div class="block">
                    <div class="title">Регистрация</div>
                <@form.form commandName="signup_form" id="signup" action="/signup" acceptCharset="UTF-8"  method="post">
                    <div>
                        <@form.input id="login" name="login" path="login" placeholder="Ваш логин" />
                        <p><@form.errors path="login" cssStyle="color: #ab2020;" /></p>
                    </div>
                    <div>
                        <@form.input  id="name" name="name" path="name"  class="form-control" placeholder="ФИО"/>
                        <p><@form.errors path="name" cssStyle="color: #ab2020;" /></p>
                    </div>
                    <div>
                        <@form.input  id="email" type="email" name="email" path="email" class="form-control" placeholder="Ваш Email"/>
                        <p><@form.errors path="email" cssStyle="color: #ab2020;" /></p>
                    </div>
                    <div>
                        <@form.input  id="phone" name="phone" path="phone" class="form-control" placeholder="Ваш номер телефона"/>
                        <p><@form.errors path="phone" cssStyle="color: #ab2020;" /></p>
                    </div>
                    <div>
                        <@form.input type="password" name="password" path="password" class="form-control" placeholder="Пароль"/>
                        <p><@form.errors path="password" cssStyle="color: #ab2020;" /></p>
                    </div>
                    <div>
                        <@form.input type="password" name="confirmPassword" path="confirmPassword" class="form-control" placeholder="Повторный ввод пароля"/>
                    </div>
                    <div>
                        <p><@form.errors path="confirmPassword" cssStyle="color: #ab2020;"/></p>
                    </div>

                    <div>
                    <p><@form.select path="role" id="role"></p>
                        <option value="ROLE_DESIGNER">Дизайнер</option>
                        <option value="ROLE_CUSTOMER">Заказчик</option>
                    </@form.select>
                    </div>
                    <div class="button" onclick="document.getElementById('signup').submit();">Регистрация</div>
                </@form.form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/resources/js/jquery-1.11.3.min.js"></script>
<script src="/resources/js/javascript.js"></script>
</html>
