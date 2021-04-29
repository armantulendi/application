<!DOCTYPE html>

<html >

<head>
    <title>Good Thymes Virtual Grocery</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>

<body>

<div class="row">
    <div class="col-3">
        <div class="container-fluid bcontent">
            <h2>Тестовая платформа</h2>
            <hr/>
            <nav class="navbar navbar-light bg-light">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link " href="/greeting">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/main">Страница для данных</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/user/profile">Профиль</a>
                    </li>

                </ul>
            </nav>
        </div>
    </div>
    <div class="col-8 mt-5">

        <table class="table table-bordered border-secondary">
            <#--            <#if books??>-->
            <thead><h5>Данные первой БД</h5>
<#--            <div>-->
<#--                Подключение к БД:-->
<#--            <#if connect=="connected"><button type="button" class="btn btn-success" disabled>Подключено</button>-->
<#--            </div>-->
            <tr  >
                <th scope="col">id</th>
                <th scope="col">bookingAmount</th>
                <th scope="col">createdBy</th>
                <th scope="col">pickupAddress</th>
                <th scope="col">dropAddress</th>
                <th scope="col">действия</th>
            </tr>
            </thead>
<#--            <#else><button type="button" class="btn btn-danger" disabled>Не подключено</button></#if>-->
            <tbody>
<#--            <#if books??>-->
            <#list books as book>

                        <form enctype="multipart/form-data" method="post" action="/databases/view">
                    <tr>
                        <td><input type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
                                   name="id" value="${book.id}"  ></td>
                        <td><input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
                                   name="bookingAmount"   value="${book.bookingAmount} "></td>
                        <td><input type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
                                   name="createdBy" value="${book.createdBy}"></td>
                        <td><input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
                                   name="pickupAddress" value="${book.pickupAddress}"></td>
                        <td><input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
                                   name="dropAddress" value="${book.dropAddress}"></td>
                        <td> <button type="submit" class="btn btn-secondary  ">Сохранить</button></td>
                    </tr>
                </form>

            </#list>
<#--            </#if>-->
            </tbody>
        </table>

        <table class="table table-bordered  border-secondary ">
            <thead>
            <h5>Данные второй БД</h5>
            <tr>
                <th scope="col">id</th>
                <th>str</th>
                <th>действия</th>
            </tr>
            </thead>

            <tbody>
<#--            <#if users??>-->
            <#list users as user>
                <form enctype="multipart/form-data" method="post" action="/databases/user">
                    <tr>
                        <td ><input type="text" class="form-control" aria-label="Sizing example input"
                                    aria-describedby="inputGroup-sizing-default"
                                    name="userId" value="${user.userId}"></td>
                        <td ><input type="text" class="form-control" aria-label="Sizing example input"
                                    aria-describedby="inputGroup-sizing-default"
                                    name="userStr" value="${user.getStr()}"></td>
                        <td>
                            <button type="submit" class="btn btn-secondary  ">Сохранить</button>
                        </td>
                    </tr>
                </form>
            </#list>
<#--            </#if>-->
            </tbody>

        </table>
        <table class="table table-bordered  border-secondary ">
            <thead>
            <h5>Данные третьей БД</h5>
            <tr>
                <th scope="col">id</th>
                <th>first_name</th>
                <th>last_name</th>
                <th>gender</th>
                <th>email</th>
                <th>действия</th>
            </tr>
            </thead>

            <tbody>
            <#--            <#if users??>-->
            <#list data as d>
                <form enctype="multipart/form-data" method="post" action="/databases/data">
                    <tr>
                        <td ><input type="text" class="form-control" aria-label="Sizing example input"
                                    aria-describedby="inputGroup-sizing-default"
                                    name="id" value="${d.id}"></td>
                        <td ><input type="text" class="form-control" aria-label="Sizing example input"
                                    aria-describedby="inputGroup-sizing-default"
                                    name="firstName" value="${d.firstName}"></td>
                        <td ><input type="text" class="form-control" aria-label="Sizing example input"
                                    aria-describedby="inputGroup-sizing-default"
                                    name="lastName" value="${d.lastName}"></td>

                        <td ><input type="text" class="form-control" aria-label="Sizing example input"
                                    aria-describedby="inputGroup-sizing-default"
                                    name="gender" value="${d.gender}"></td>

                        <td ><input type="text" class="form-control" aria-label="Sizing example input"
                                    aria-describedby="inputGroup-sizing-default"
                                    name="email" value="${d.email}"></td>
                        <td>
                            <button type="submit" class="btn btn-secondary  ">Сохранить</button>
                        </td>
                    </tr>
                </form>
            </#list>
            <#--            </#if>-->
            </tbody>

        </table>
    <div class="col-1 mt-2">
    </div>
</div>
</if>
</body>


</html>
