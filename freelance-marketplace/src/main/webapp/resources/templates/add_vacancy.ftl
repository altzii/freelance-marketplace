<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Добавить вакансию</title>
</head>

<body>
<h1>Добавить вакансию</h1>

<@form.form commandName="add_vacancy_form" action="/consumer/vacancies/add" acceptCharset="UTF-8"  method="post">
<div>
    <@form.input id="title" name="title" path="title" placeholder="введите заголовок" />
    <p><@form.errors path="title" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input  id="organization" name="organization" path="organization"  class="form-control" placeholder="введите наименование организации"/>
    <p><@form.errors path="organization" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input  id="description" type="description" name="description" path="description" class="form-control" placeholder="введите описание"/>
    <p><@form.errors path="description" cssStyle="color: #ab2020;" /></p>
</div>

<button type="submit">Создать вакансию</button>
</@form.form>

</body>
</html>