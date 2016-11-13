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

<@form.form commandName="signup_form" action="/signup" acceptCharset="UTF-8"  method="post">
<div>
    <@form.input id="login" name="login" path="login" placeholder="введите логин" />
    <p><@form.errors path="login" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input  id="name" name="name" path="name"  class="form-control" placeholder="введите ФИО"/>
    <p><@form.errors path="name" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input  id="email" type="email" name="email" path="email" class="form-control" placeholder="введите e-mail"/>
    <p><@form.errors path="email" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input  id="phone" name="phone" path="phone" class="form-control" placeholder="введите номер телефона"/>
    <p><@form.errors path="phone" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input type="password" name="password" path="password" class="form-control" placeholder="введите пароль"/>
    <p><@form.errors path="password" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input type="password" name="confirmPassword" path="confirmPassword" class="form-control" placeholder="повторите ввод пароля"/>
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
<button type="submit">Регистрация</button>
</@form.form>
<div>
<a href="/signin" class="text-center">У меня уже есть аккаунт</a>
</div>

</body>
</html>