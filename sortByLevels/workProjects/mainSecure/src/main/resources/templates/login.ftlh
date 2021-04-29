<!DOCTYPE html>
<html lang="en"  >
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" type="text/css" href="css/logStyle.css">
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <h1>VoIP</h1>
<#--            <img src="/d3.jpg"  id="icon" alt="User Icon" />-->
        </div>

        <!-- Login Form -->
        <form action="/login" method="post">
            <input type="text" id="login" class="fadeIn second" name="username" placeholder="логин">
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="пароль">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" class="fadeIn fourth" value="Войти">
        </form>
    </div>
</div>
</body>
</html>