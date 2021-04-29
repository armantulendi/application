
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>DemoProject</title>
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
                        <#--                              <#if isAdmin>-->
                    <li class="nav-item">
                        <a class="nav-link " href="http://10.22.33.17:8081/user">Управление пользователями</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="http://10.22.33.17:8081/user/profile">Профиль</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="http://10.22.33.17:8082/rules">Управление исходящей маршрутизации</a>
                    </li>
                    <#--                         </#if>-->
                </ul>
            </nav>
        </div>
    </div>
    <div class="col-8 mt-5"  >

<#--Header-->
        <h4>Группы</h4>
        <div class="btn-group" role="group" aria-label="Basic outlined example">
            <a href="/gateway"><button type="button" class="btn btn-outline-primary">Шлюзы</button></a>
            <a href="/rules"><button type="button" class="btn btn-outline-primary">Правила</button></a>
            <a href="/groups" ><button  type="button" class="btn btn-primary">Группы</button></a>
        </div>

        <div  >
            <form class="form-inline col-6 mt-1"  method="get" action="/groups/filter">
                <input  type="text" name="username" value=""  placeholder="username">
                <button class="btn  btn-primary"  type="submit" >Поиск</button>
<#--                <button class = "btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">-->
<#--                    Добавить-->
<#--                </button>-->
            </form>

        </div>
        <#--collapse-->
        <#--create-->
<#--        <div class="collapse" id="collapseExample">-->
<#--            <div class="card card-body">-->
                <form class="form-inline mt-1"  method="post" action="/groups/save">

                    <div class="row ">
                        <div class="col">
                            <input type="text" class="form-control (${error?if_exists})?is-invalid:'' " name="userName" placeholder="username" aria-label="username" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control " name="domain" placeholder="domain" aria-label="domain" required>
                        </div>
                        <div class="col">

                            <select  name="drRules" class="form-select ml-3 required" aria-label="Default select example" >
                                <option selected>Выберите правила</option>
                                <option disabled>id описание</option>
                                <#list rules as r>

                                    <option name="drRules" value="${r.groupId}"> ${r.groupId} ${r.description}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name="description" placeholder="description" aria-label="description"   >
                        </div>
                        <div class="col">
                            <button type="submit" class="btn btn-primary">Добавить</button>
                        </div>
                    </div>
                </form>
<#--            </div>-->
<#--        </div>-->
        <#--list-->
<#--        read update-->
        <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">username</th>
                <th scope="col">domain</th>
                <th scope="col">Правило</th>
                <th scope="col">description</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list groups as g>
                <tr>
                    <form action="/groups/update" method="post" >
                        <td><input name="idGroup" class="form-control col-1" type="number"  value="${g.idGroup}">
                        </td>
                    <#if g.userName??>
                        <td><input type="text" class="form-control"
                                   name="userName" value="${g.userName}" required></td>
                    <#else ><td>null</td>
                        </#if>
                        <#if g.domain??>
                            <td><input type="text" class="form-control"
                                       name="domain" value="${g.domain}" required></td>
                        <#else ><td>null</td>
                        </#if>

                            <td><select  name="drRules" class="form-select ml-3" aria-label="Default select example">
                            <option selected value="${g.drRules}">${g.drRules} </option>

                                <#list rules as r>
                                <option type="number" name="drRules" value="${r.groupId}"> ${r.groupId} ${r.description}</option>
                                </#list>
                        </select>
                        </td>

                        <#if g.description??>
                            <td><input type="text" class="form-control"
                                       name="description" value="${g.description}" ></td>
                        <#else ><td><input type="text" class="form-control"
                                           name="description" value=" " ></td></td>
                        </#if>
                        <td>
                            <button type="submit" value="save" class="btn btn-primary">Сохранить</button>
                        </td>
                    </form>
                            <td>
                                <#--delete-->
                            <form action="/groups/${g.idGroup}/delete" method="post" >
                                <button type="submit" value="delete" class="btn btn-danger">Удалить</button>
                            </form>
                        </td>
                        <td></td>
                </tr>
            </#list>

            </tbody>
        </table>
    </div>
</div>

<!-- Option 2: Separate Popper and Bootstrap JS -->

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>


</body>
</html>