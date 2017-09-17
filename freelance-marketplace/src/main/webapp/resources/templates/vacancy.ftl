<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html>
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
<div class="vacancy">
    <div class="top">
        <div class="inside">
            <div class="title">Вакансия</div>
        </div>
    </div>
    <div class="content">
        <div class="inside">
            <a href="/vacancies">
                <div class="back">
                    <img src="/resources/images/arrow-next.png">
                    <span>Вакансии</span>
                </div>
            </a>
            <div class="blocks">
            <#if vacancy??>
                <div class="block">
                    <div class="img"></div>
                    <div class="name">${vacancy.user.login}</div>
                    <a href="/conversation?id=${vacancy.user.id}"><div class="button">Написать</div></a>
                    <div style="display: block"></div>
                    <div class="title">${vacancy.title}</div>
                    <div style="display: block"></div>
                    <div class="desc">${vacancy.description}</div>
                </div>

                <div class="comments">
                    <h1>Комментарии</h1>

                    <@form.form commandName="add_vacancy_comment_form" id="comment" action="/vacancies/add_comment/${vacancy.id}" acceptCharset="UTF-8"  method="post">
                        <div>
                            <@form.textarea path="text" id="text" name="text" rows="5" cols="30" placeholder="Введите текст комментария"  />
                            <p><@form.errors path="text" cssStyle="color: #ab2020;" /></p>
                        </div>
                        <div class="button" onclick="document.getElementById('comment').submit();">Добавить комментарий</div>
                    </@form.form>

                    <#if vacancy.vacancyComments??>
                        <div class="comment_items">
                            <#list vacancy.vacancyComments as vacancyComment>
                                <div class="comment">
                                    <div>
                                        <#if (user == vacancyComment.user)>
                                            <div class="img" style="cursor: pointer" id="deleteVacancyComment" onclick="deleteVacancyComment(${vacancyComment.id})"></div>
                                        </#if>
                                        <div class="name">${vacancyComment.user.name} ${(user == vacancyComment.user)?string('Автор', 'Не автор')}</div>
                                        <div class="date">${vacancyComment.date}</div>
                                    </div>
                                    <div class="text">${vacancyComment.text}</div>
                                </div>
                            </#list>
                        </div>
                    </#if>
                </div>
            </#if>
            </div>

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
