<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Дизайнеры</title>
</head>

<body>
<h1>Дизайнеры</h1>

<table>
<#if designers??>
    <#list designers as designer>
        <tr>
            <td>${designer.login}</td>
            <td>${designer.name}</td>
            <td>${designer.email}</td>
            <td>${designer.phone}</td>
        </tr>
    </#list>
</#if>
</table>
</body>