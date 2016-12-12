<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
</head>

<body>
<h1>Вакансия</h1>
<#if !not_found??>
    <table>
        <tr>
            <td>${vacancy.id}</td>
            <td>${vacancy.user.login}</td>
            <td>${vacancy.title}</td>
            <td>${vacancy.description}</td>
        </tr>
    </table>


    <h1>Комментарии</h1>

    <@form.form commandName="add_vacancy_comment_form" action="/vacancies/add_comment/${vacancy.id}" acceptCharset="UTF-8"  method="post">
    <div>
        <@form.textarea path="text" id="text" name="text" rows="5" cols="30" placeholder="Введите текст комментария"  />
        <p><@form.errors path="text" cssStyle="color: #ab2020;" /></p>
    </div>
    <button type="submit">Добавить комментарий</button>
    </@form.form>

    <#if vacancy.vacancyComments??>
    <table border="1">
        <#list vacancy.vacancyComments as vacancyComment>
            <tr>
                <td>${vacancyComment.date}</td>
                <td>${vacancyComment.user.name}</td>
                <td>${vacancyComment.text}</td>
            </tr>
        </#list>
    </table>
    </#if>
<#else>
<h3>Такой вакансии не существует</h3>
</#if>

</body>
</html>