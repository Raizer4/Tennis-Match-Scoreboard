<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>

<header class="header">
    <nav class="header_nav">
        <a href="#">HOME</a>
        <a href="#">MENU</a>
        <a href="#">MATCHES</a>
    </nav>
</header>

<div class="wrapper">
    <div class="menu">
        <h2>Tennis score board</h2>
        <div class="temp_1"><a href="/new-match">NEW</a> - start new match</div>
        <div class="temp_2"><a href="/matches">MATCHES</a> - list of finished matches</div>
    </div>
</div>

</body>
</html>