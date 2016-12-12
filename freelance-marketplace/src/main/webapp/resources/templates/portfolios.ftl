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
<h1>Портфолио</h1>

<table border="1">
<#if portfolios??>
    <#list portfolios as portfolio>
        <tr>
            <td>${portfolio.id}</td>
            <td>${portfolio.user.login}</td>
            <td>${portfolio.description}</td>
        </tr>
    </#list>
</#if>
</table>
</body>
</html>