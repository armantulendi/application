
<!DOCTYPE html>
<html lang="en" >
<head>
     <meta charset="UTF-8">
     <title>DemoProject</title>
     <meta name="viewport" content="width=device-width, initial-scale=1">

     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>

<body>

<div class="row">
     <div class="col-1">
     </div>
     <div class="col-9 mt-5"  >
     <#--Header -->
          <h4>Шлюзы</h4>
          <div class="btn-group" role="group" aria-label="Basic outlined example">
               <a href="/gateway"><button type="button" class="btn btn-primary">Шлюзы</button></a>
               <a href="/rules"><button type="button" class="btn btn-outline-primary">Правила</button></a>
               <a href="/groups" ><button  type="button" class="btn btn-outline-primary">Группы</button></a>
          </div>

          <div>
               <form class="form-inline col-6 mt-1"  method="get" action="/main">
                    <input  type="text" name="filter" value="${RequestParameters.filter!}"
                            placeholder="Поиск">
                    <button class="btn  btn-primary"  type="submit" >Поиск</button>
<#--                    <button class = "btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">-->
<#--                         Добавить-->
<#--                    </button>-->
               </form>

          </div>
          <#--Create-->
<#--          <div class="collapse" id="collapseExample">-->
<#--               <div class="card card-body">-->
                    <form class="form mt-1"  method="post" action="/gateway/save">
                    <div class="row ">
                         <div class="col-3">
                              <input type="text" class="form-control "
                                     name="gwAddress" placeholder="Адрес шлюза" aria-label="Адрес шлюза" required>
                         </div>
                         <div class="col">
                              <input type="number" class="form-control input-sm" name="strip" placeholder="strip" aria-label="strip" required>
                         </div>
                         <div class="col">
                              <input type="number" class="form-control input-sm" name="type" placeholder="type" aria-label="strip" required>
                         </div>
                         <div class="col">
                              <input type="text" class="form-control input-sm" name="priPrefix" placeholder="Префикс" aria-label="Префикс" >
                         </div>
                         <div class="col">
                              <input type="text" class="form-control input-sm" name="attrs" placeholder="Аттрибуты" aria-label="Аттрибуты" >
                         </div>
                         <div class="col">
                              <input type="text" class="form-control" name="description" placeholder="Описание" aria-label="Описание">
                         </div>
                              <div class="col">
                                   <button type="submit" class="btn btn-primary">Добавить</button>
                              </div>
                    </div>
                    </form>
<#--               </div>-->
<#--          </div>-->
          <#--read update-->
          <table class="table">
               <thead>
               <tr>
                    <th scope="col">id</th>
                    <th scope="col">gwAddress</th>
                    <th scope="col">strip</th>
                    <th scope="col">type</th>
                    <th scope="col">priPrefix</th>
                    <th scope="col">attrs</th>
                    <th scope="col">description</th>
                    <th scope="col"></th>
               </tr>
               </thead>
               <tbody>
               <#list gateway as g>
               <tr>
                    <form action="/gateway/update" method="post" >
                    <#if g.gwId??>
                         <td><input  class="form-control" name="gwId" type="number" readonly value="${g.gwId}"></td>
                    </#if>
                    <#if g.gwAddress??>
                    <td><input type="text" class="form-control "
                               name="gwAddress" value="${g.gwAddress}" required >  </td>

                         <div class="invalid-feedback">
                              <#if errors??>
                             ${errors}
                             </#if>
                         </div>
                    <#else ><td>null</td>
                    </#if>
                    <#if g.strip??>
                    <td><input type="number" class="form-control"
                               name="strip" value="${g.strip}" required></td>
                    <#else><td><input type="number" class="form-control"
                                      name="strip" value=" " required></td>
                    </#if>
                    <#if g.type??>
                    <td><input type="number" class="form-control"
                               name="type" value="${g.type}" required></td>
                    <#else><td><input type="number" class="form-control"
                                      name="type" value=" " required></td>
                    </#if>
                    <#if g.priPrefix??>
                    <td><input type="text" class="form-control"
                               name="priPrefix" value="${g.priPrefix}" required></td>
                    <#else ><td><input type="text" class="form-control"
                                       name="priPrefix" value=" " required></td></td>
                    </#if>
                    <#if g.attrs??>
                    <td><input type="text" class="form-control"
                               name="attrs" value="${g.attrs}" required></td>
                    <#else ><td><input type="text" class="form-control"
                                       name="attrs" value=" " required></td></td>
                    </#if>
                    <#if g.description??>
                    <td><input type="text" class="form-control"
                               name="description" value="${g.description}"></td>
                    <#else ><td><input type="text" class="form-control"
                                       name="description" value=" "></td></td>
                    </#if>
                    <td>
                              <button type="submit" value="save" class="btn btn-primary">Сохранить</button>
                    </td>
                    </form>
                    <#--delete-->
                    <td>
                         <form action="/gateway/${g.gwId}/delete" method="post" >
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