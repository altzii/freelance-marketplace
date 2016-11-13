<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Вход</title>
</head>

<body>
<h1>Вход</h1>


<form action="j_spring_security_check" method="post">
    <p>
        <label for="login">Логин</label><br />
        <input name="j_username" type="text" class="form-control" placeholder="логин">
    </p>

    <p>
        <label for="password">Пароль</label><br />
        <input name="j_password" type="password" class="form-control" placeholder="пароль">
    </p>

    <label>
        <input type="checkbox" name="remember-me">&nbsp;&nbsp;Запомнить меня
    </label>

    <#if error??>
    <p style="color: #a71f1f">
     ${SPRING_SECURITY_LAST_EXCEPTION.message}
    </p>
    </#if>

    <button type="submit">Войти</button>
</form>

</body>
</html>