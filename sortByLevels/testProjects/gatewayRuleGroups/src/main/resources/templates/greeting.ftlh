
<!DOCTYPE html>
<html lang="en" >
<head>
     <meta charset="UTF-8">
     <title>DemoProject</title>
     <#--    <link rel="stylesheet" href="/static/style.css">-->
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
               <nav class="navbar navbar-light bg-light">
                    <ul class="navbar-nav">
                         <li class="nav-item">
                              <a class="nav-link active" href="/greeting">Главная</a>
                         </li>
                         <li class="nav-item">
                              <a class="nav-link " href="/main">Страница для данных</a>

<#--                              <#if isAdmin>-->
                         <li class="nav-item">
                              <a class="nav-link " href="/user">Управление пользователями</a>
                         </li>

                         <li class="nav-item">
                              <a class="nav-link" href="/user/profile">Профиль</a>
                         </li>
                    </ul>
               </nav>
          </div>
     </div>
     <div class="col-8 mt-5">
          <h2>Тестовая платформа для администрирования системы </h2>
          <#--find by username-->
          <form class="form-inline col-6"  method="get" action="/main">
               <input type="text" class="form-control" name="filter" value="${RequestParameters.filter!}"
                      placeholder="Search">
               <button type="submit" class="btn btn-primary  ">Search</button>

          </form>
          <#--collapse-->
          <p>
               <button class = "btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                    Add new data
               </button>
          </p>
          <div class="collapse" id="collapseExample">
               <div class="card card-body">
                    <form class="form-inline "  method="post" action="/main">
                    <div class="row ">
                         <div class="col">
                              <input type="text" class="form-control"
                                     name="username" placeholder="Username" aria-label="Username">
                         </div>
                         <div class="col">
                              <input type="text" class="form-control" name="domain" placeholder="Domain" aria-label="Domain">
                         </div>
                         <div class="col">
                              <input type="password" class="form-control" name="password" placeholder="Password" aria-label="Password">
                         </div>
                              <div class="col-3">
                                   <button type="submit" class="btn btn-primary col-12">add</button>
                              </div>
                    </div>
                    </form>
               </div>
          </div>
          <#--list-->
          <table class="table">
               <thead>
               <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Domain</th>
                    <th scope="col">Действие</th>
                    <th scope="col"></th>
               </tr>
               </thead>
               <tbody>

               <#list subscriberData as s>
               <tr>
                    <th scope="row">${s.id}</th>
                    <#if s.username??>
                    <td>${s.username}</td>
                    </#if>
                    <#if s.domain??>
                    <td>${s.domain}</td>
                    </#if>
                    <td>
                         <form action="main/${s.id}" method="post" >
                              <button type="submit" value="delete" class="btn btn-danger">Удалить</button>
                         </form>
                    </td>
                    <td></td>
               </tr>
               </#list>

               </tbody>
          </table>
     </div>
     <div class="col-1">
          <form action="/logout" method="post">
                    <button class="btn btn-primary" type="submit"> Выход</button>
          </form>
     </div>
</div>

<!-- Option 2: Separate Popper and Bootstrap JS -->

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>


</body>
</html>