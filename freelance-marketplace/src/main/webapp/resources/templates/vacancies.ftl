<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Вакансии</title>
</head>

<body>
<h1>Вакансии</h1>

<table border="1">
<#if vacancies??>
    <#list vacancies as vacancy>
        <tr>
            <td>${vacancy.id}</td>
            <td>${vacancy.user.login}</td>
            <td>${vacancy.title}</td>
            <td>${vacancy.description}</td>
        </tr>
    </#list>
</#if>
</table>

</body>
</html>