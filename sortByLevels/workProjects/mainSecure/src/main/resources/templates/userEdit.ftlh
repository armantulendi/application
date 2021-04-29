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
                        <a class="nav-link active" href="/greeting">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="http://10.22.33.17:8082/subscribe">Внутренние номера</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">Входящая маршрутизация</a>
                    </li>
                    <#if isAdmin>
                        <li class="nav-item">
                            <a class="nav-link " href="/user">Управление пользователями</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/user/profile">Профиль</a>
                        </li> </#if>
                </ul>
            </nav>
        </div>
    </div>

    <div class="col-8 mt-5">
        <h3>Редактирование</h3>
        <form action="/user/${user.id}" class="row g-3" method="post">
            <div class="col-md-4">
                <label for="validationServer01"  class="form-label">Имя</label>
                <input type="text" name="firstname" value="${user.getFirstname()}" class="form-control<#-- is-valid-->" id="validationServer01"  <#--required-->>
            </div>
            <div class="col-md-4">
                <label for="validationServer02" class="form-label">Фамилия</label>
                <input type="text"  name="lastname" value="${user.getLastname()}" class="form-control " id="validationServer02"  >
            </div>
            <div class="col-md-4">
                <label for="validationServerUsername" class="form-label">Username</label>
                <div class="input-group has-validation">
                    <input type="text" name="username" value="${user.getUsername()}" class="form-control <#--is-invalid-->"
                           id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                    <div id="validationServerUsernameFeedback" class="invalid-feedback">
                        Please choose a username.
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <label   class="form-label">Email</label>
                <div class="input-group has-validation">
                    <span class="input-group-text" id="inputGroupPrepend3">@</span>
                    <input type="text" name="email" value="${user.getEmail()}" class="form-control  "
                           aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                    <div id="validationServerUsernameFeedback" class="invalid-feedback">
                        Please choose a username.
                    </div>
                </div>
            </div>

            <div class="col-md-4 ">
                <label for="validationServerUsername" class="form-label">Роль</label>

                <#list roles as role>
                <div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="${role}" value=""${user.roles?seq_contains(role)?string("checked", "")}  >
                        <label class="form-check-label">
                            ${role}
                        </label>
                    </div>
                </div>
            </#list>
            </div>
            <input type="hidden" value="${user.id}" name="userId">
            <button class="btn btn-info" type="submit" >Изменить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>

    </div>
</div>
<!-- Option 2: Separate Popper and Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
</body>
</html>

