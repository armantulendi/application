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
                        <a class="nav-link active" href="http://10.22.33.17:8081/user">Управление пользователями</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="http://10.22.33.17:8081/user/profile">Профиль</a>
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
        <h4>Пользователи</h4>
        <a href="/registration">
            <button  type="submit" class="btn btn-primary">Добавить</button>
        </a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ФИО</th>
                <th scope="col">Email</th>
                <th scope="col">Роль</th>
                <th scope="col">Действие</th>
                <th ></th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <#if user.firstname??>
                    <td>${user.firstname} ${user.lastname}</td>
                    </#if>
                    <#if user.email??>
                        <td>${user.email}</td>
                    <#else><td>null</td>
                    </#if>
                    <#if user.roles??>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    </#if>
                    <td><a href="/user/${user.id}"> <button type="submit" class="btn btn-primary">Изменить</button></a></td>
                    <td><form action="/user/${user.id}/remove" method="post" >
                            <button type="submit" value="delete" class="btn btn-danger">Удалить</button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        </form></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <div class="col-1 mt-2">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <button class="btn btn-primary" type="submit"> Выход</button>
        </form>
    </div>
</div>
</if>
</body>
</html>

