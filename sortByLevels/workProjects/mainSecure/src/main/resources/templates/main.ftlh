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
<div class="row ">
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
    <div class="col-8 mt-4 ">
        <h4  >Здесь можно добавлять данные для редактирования или работы с ними</h4>
        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
        <div class="form-row">
            <div class="form-group col-md-6 ">
                <form class="form-inline" method="get" action="/main">
                    <input type="text" class="form-control" name="filter" value="${RequestParameters.filter!}"
                           placeholder="Search">
                    <button type="submit" class="btn btn-primary ml-2">Search</button>
                </form>
            </div>
        </div>
        <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Добавить новое сообщение
        </a>
        <div class="collapse <#if message??>show</#if>" id="collapseExample">
            <div class="form-group mt-3">
                <form enctype="multipart/form-data" method="post">
                    <div class="form-group ">
                        <input type="text" class="form-control ${(textError??)?string('is-invalid','')}"
                               value="<#if message??>${message.text}</#if>" name="text" placeholder="Введите сообщение"/>
                        <#if textError??>
                            <div class="invalid-feedback">
                                ${textError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control ${(tagError??)?string('is-invalid','')}"
                               value="<#if message??>${message.tag}</#if>"  name="tag" placeholder="Тэг">
                        <#if tagError??>
                            <div class="invalid-feedback">
                                ${tagError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <div class="custom-file">
                            <input type="file" name="file" id="customFile">
                            <label class="custom-file-label" for="customFile">Choose file</label>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary ">Добавить</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="card-columns">
            <#list messages as message>
                <div class="card my-3">
                    <#if message.filename??>
                        <img src="/img/${message.fileName}" class="card-img-top">
                    </#if>
                    <div class="m-2">
                        <span>${message.text}</span>
                        <i>${message.tag}</i>
                    </div>
                    <div class="card-footer text-muted">
                        ${message.authorName}
                    </div>
                </div>
            <#else>
                No message
            </#list>
        </div>
    </div>
    <div class="col-1 mt-2">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary" type="submit"> Выход</button>
        </form>
    </div>
</div>
</body>
</html>

