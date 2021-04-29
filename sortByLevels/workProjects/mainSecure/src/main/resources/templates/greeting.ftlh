<#include "parts/security.ftlh">
<!DOCTYPE html>
<html lang="en" >
<head>
     <meta charset="UTF-8">
     <title>DemoProject</title>
         <link rel="stylesheet" href="/style_old.css">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
                              <a class="nav-link active" href="http://10.22.33.17:8081/greeting">Главная</a>
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
     <div class="col-8 mt-5">
          <h2>Тестовая платформа для администрирования системы </h2>

          <span>Приветствую, <strong> ${lastname} ${firstname}</strong> (Фамилия и Имя пользователя) </span>
          <div> Здесь будет краткая информация о системе </div>


     </div>
     <div class="col-1 mt-2">
          <form action="/logout" method="post">
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                    <button class="btn btn-primary" type="submit"> Выход</button>
          </form>
     </div>
</div>

<!-- Option 2: Separate Popper and Bootstrap JS -->

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>


</body>
</html>