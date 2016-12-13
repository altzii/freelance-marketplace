<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Заказчики</title>
</head>

<body>
<h1>Заказчики</h1>

<table>
<#if customers??>
    <#list customers as customer>
        <tr>
            <td>${customer.login}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
        </tr>
    </#list>
</#if>
</table>
</body>