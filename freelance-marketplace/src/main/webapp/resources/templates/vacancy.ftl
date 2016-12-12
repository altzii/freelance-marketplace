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
<#else>
<h3>Такой вакансии не существует</h3>
</#if>

</body>
</html>