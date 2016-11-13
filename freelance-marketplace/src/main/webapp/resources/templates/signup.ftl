<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Регистрация</title>
</head>

<body>
<h1>Регистрация</h1>


<form action="/signup" acceptCharset="UTF-8"  method="post">
    <p>
        <label for="login">Логин</label><br />
        <input id="login" name="login" type="text" required />
    </p>

    <p>
        <label for="name">ФИО</label><br />
        <input id="name" name="name" type="text" required />
    </p>

    <p>
        <label for="email">email</label><br />
        <input id="email" name="email" type="email" required />
    </p>

    <p>
        <label for="password">Пароль</label><br />
        <input id="password" name="password" type="password" required />
    </p>

    <p>
        <select required name="role">
            <option value="ROLE_DESIGNER">Дизайнер</option>
            <option value="ROLE_CUSTOMER">Заказчик</option>
        </select>
    </p>
    <button type="submit">Регистрация</button>
</form>


</body>
</html>