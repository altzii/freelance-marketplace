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
<h1>Сообщения</h1>

<table border="1">
<#if messages??>
    <#list messages as message>
    <tr>
        <td>${message.date}</td>
        <td>${message.fromUser.name}</td>
        <td>${message.text}</td>
    </tr>
    </#list>
</#if>
</table>
<form action="/send_message/${to_id}" method="post" accept-charset="UTF-8">
    <input name="text" type="text"  placeholder="Введите сообщение">
    <button type="submit">Отправить</button>
</form>
</body>
</html>