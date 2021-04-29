<#include "parts/security.ftlh">
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>DemoProject</title>
    <#--    <link rel="stylesheet" href="/static/style_old.css">-->
    <#--    <link rel="script" href="/static/index.js">-->

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>

<body>

<div class="row">
    <div class="col-3">
        <div class="container-fluid bcontent">
            <h2>Тестовая платформа</h2>
            <hr />
            <nav class="navbar navbar-light bg-light">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link " href="http://10.22.33.17:8081/greeting">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="http://10.22.33.17:8082/subscribe">Внутренние номера</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">Входящая маршрутизация</a>
                    </li>
                        <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link " href="http://10.22.33.17:8081/user">Управление пользователями</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="http://10.22.33.17:8081/user/profile">Профиль</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://10.22.33.17:8082/rules">Управление исходящей маршрутизации</a>
                    </li>
                    </#if>
                </ul>
            </nav>
        </div>
    </div>
    <div class="col-8 mt-5">

    <h5>${username}</h5>
    <form method="post">
            <div class="form-group row   ">
                <label class="col-sm-2 col-form-label">Email:</label>
                <div class="col-sm-6">
                    <input type="text" name="email" class="form-control" placeholder="email@gmail.com" value="${email!''}" required>
                    <div id="validationServerUsernameFeedback" class="invalid-feedback">
                        Неправильно введен логин
                    </div>
                </div>
            </div>
            <div class="form-group row  ">
                <label class="col-sm-2 col-form-label">Имя:</label>
                <div class="col-sm-6">
                    <input type="text" name="firstname" class="form-control" placeholder="Имя" value="${firstname!''}"/>
                </div>
            </div>
            <div class="form-group row   ">
                <label class="col-sm-2 col-form-label">Фамилия:</label>
                <div class="col-sm-6">
                    <input type="text" name="lastname" class="form-control" placeholder="Фамилия" value="${lastname!''}" />
                </div>
            </div>
        <div class="form-group row   ">
            <label class="col-sm-2 col-form-label">Логин:</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Логин" value="${username!''}" />
            </div>
        </div>
        <div class="form-group row   ">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Пароль" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <div class="form-group row  ">
                <label class="col-sm-2 col-form-label">Подтверждение пароли:</label>
                <div class="col-sm-6">
                    <input type="password" name="repeatPassword" class="form-control" placeholder="Подтверждение пароли" value=""/>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

        <div class="col justify-content-start">
            <div class="col-2">
                <button class="btn btn-primary" type="submit">Сохранить</button>
            </div>
        </div>
    </form>
    </div>
    <div class="col-1 mt-2">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary" type="submit"> Выход</button>
        </form>
    </div>
</div>
