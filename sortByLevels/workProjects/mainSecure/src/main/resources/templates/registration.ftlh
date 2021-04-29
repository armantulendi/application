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
                        <a class="nav-link " href="/greeting">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="http://10.22.33.17:8082/subscribe">Внутренние номера</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">Входящая маршрутизация</a>
                    </li>
                    <#if isAdmin>
                        <li class="nav-item">
                            <a class="nav-link active" href="/user">Управление пользователями</a>
                        </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/user/profile">Профиль</a>
                    </li></#if>
                </ul>
            </nav>
        </div>
    </div>
<#--    ${message??}-->

<div class="center" style="width:700px; margin:0 auto;">
    <div class="col-8 mt-5">
        <h3>Новый пользователь</h3>
        <form action="/registration" class="row g-3" method="post">

                <div class="col-md-6">
                    <label for="validationServer01"  class="form-label">Имя</label>
                    <input type="text" name="firstname"  class="form-control " id="validationServer01"  >
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="validationServer02" class="form-label">Фамилия</label>
                    <input type="text" name="lastname" class="form-control" id="validationServer02"  <#--required-->>
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="validationServerUsername" class="form-label">Логин</label>
                    <div class="input-group has-validation">
                        <input type="text" name="username"
                               class="form-control "
                               id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                        <div id="validationServerUsernameFeedback" class="invalid-feedback">
                            Введите логин
                        </div>
                    </div>
                </div>
            <div class="col-md-6">
                    <label for="validationServerUsername" class="form-label">Email</label>
                    <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend3">@</span>
                        <input type="text" name="email"
                               class="form-control ${(emailError??)?string('is-invalid','')}"
                               id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" <#--required--> >
                        <#if emailError??>
                            <div class="invalid-feedback">
                                ${emailError}
                            </div>
                        </#if>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="validationServer03" class="form-label">Пароль</label>
                    <input type="password" name="password"
                           class="form-control  ${(passwordError??)?string('is-invalid','')}" placeholder="Пароль"/>
                    <#if passwordError??>
                        <div class="invalid-feedback">
                            ${passwordError}
                        </div>
                    </#if>
                </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="col-md-6">
                <label for="validationServer05" class=" col-form-label">Подтвердите пароль:</label>
                    <input type="password" name="repeatPassword"
                           class="form-control ${(repeatPasswordError??)?string('is-invalid','')}"
                           placeholder="Подтверждение пароли"/>
                    <#if repeatPasswordError??>
                        <div class="invalid-feedback">
                            ${repeatPasswordError}
                        </div>
                    </#if>
                </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>


            <button class="btn btn-primary  " type="submit" >Добавить</button>
        </form>

<#--&lt;#&ndash;        old&ndash;&gt;-->
<#--    <form action="/registration" method="post">-->

<#--            <div class="form-group row   ">-->
<#--                <div class="mt-5 "><h4>Новый пользователь</h4></div>-->
<#--                <label class="col-sm-2 col-form-label">Email:</label>-->
<#--                <div class="col-sm-6">-->
<#--                    <input type="text" name="email"-->
<#--                           class="form-control ${(emailError??)?string('is-invalid','')}" placeholder="Email"/>-->
<#--                    <#if emailError??>-->
<#--                        <div class="invalid-feedback">-->
<#--                            ${emailError}-->
<#--                        </div>-->
<#--                    </#if>-->
<#--                </div>-->
<#--            </div>-->
<#--            <div class="form-group row  ">-->
<#--                <label class="col-sm-2 col-form-label">Firstname:</label>-->
<#--                <div class="col-sm-6">-->
<#--                    <input type="text" name="firstname" class="form-control" placeholder="Имя"/>-->
<#--                </div>-->
<#--            </div>-->
<#--            <div class="form-group row   ">-->
<#--                <label class="col-sm-2 col-form-label">Lastname:</label>-->
<#--                <div class="col-sm-6">-->
<#--                    <input type="text" name="lastname" class="form-control" placeholder="Фамилия"/>-->
<#--                </div>-->
<#--            </div>-->
<#--        <div class="form-group row   ">-->
<#--            <label class="col-sm-2 col-form-label">User Name :</label>-->
<#--            <div class="col-sm-6">-->
<#--                <input type="text" name="username"-->
<#--                       class="form-control ${(usernameError??)?string('is-invalid','')}" placeholder="Логин"/>-->
<#--                <#if usernameError??>-->
<#--                    <div class="invalid-feedback">-->
<#--                        ${usernameError}-->
<#--                    </div>-->
<#--                </#if>-->
<#--            </div>-->
<#--        </div>-->
<#--        <div class="form-group row   ">-->
<#--            <label class="col-sm-2 col-form-label">Password:</label>-->
<#--            <div class="col-sm-6">-->
<#--                <input type="password" name="password"-->
<#--                       class="form-control  ${(passwordError??)?string('is-invalid','')}" placeholder="Пароль"/>-->
<#--                <#if passwordError??>-->
<#--                    <div class="invalid-feedback">-->
<#--                        ${passwordError}-->
<#--                    </div>-->
<#--                </#if>-->
<#--            </div>-->
<#--        </div>-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--            <div class="form-group row  ">-->
<#--                <label class="col-sm-2 col-form-label">Confirm Password:</label>-->
<#--                <div class="col-sm-6">-->
<#--                    <input type="password" name="repeatPassword"-->
<#--                           class="form-control ${(prepeatPasswordError??)?string('is-invalid','')}"-->
<#--                           placeholder="Подтверждение пароли"/>-->
<#--                    <#if prepeatPasswordError??>-->
<#--                        <div class="invalid-feedback">-->
<#--                            ${prepeatPasswordError}-->
<#--                        </div>-->
<#--                    </#if>-->
<#--                </div>-->
<#--            </div>-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--        <div class="col justify-content-start">-->
<#--            <div class="col-2">-->
<#--                <button class="btn btn-primary" type="submit"> Создать </button>-->
<#--            </div>-->
<#--        </div>-->
<#--    </form>-->
<#--</div>-->
    </div>
</div>
    </div>
</body>
</html>