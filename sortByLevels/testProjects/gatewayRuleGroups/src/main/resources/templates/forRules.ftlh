
<!DOCTYPE html>
<html lang="en" >
<head>
     <meta charset="UTF-8">
     <title>DemoProject</title>
     <meta name="viewport" content="width=device-width, initial-scale=1">

     <!-- Bootstrap CSS -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
     <script>
     </script>
</head>

<body>

<div class="row">
     <div class="col-1">
     </div>
     <div class="col-9 mt-5">

          <h4>Правила</h4>

          <div class="btn-group" role="group" aria-label="Basic outlined example">
               <a href="/gateway"><button type="button" class="btn btn-outline-primary">Шлюзы</button></a>
               <a href="/rules"><button type="button" class="btn btn-primary">Правила</button></a>
               <a href="/groups" ><button  type="button" class="btn btn-outline-primary">Группы</button></a>
          </div>

          <div  role="group">
               <form class="form-inline col-6"  method="get" action="/main">
                    <input  type="text" name="filter" value="${RequestParameters.filter!}"
                            placeholder="Поиск">
                    <button class="btn btn-primary mt-1"  type="submit" >Поиск</button>

               </form>

          </div>

          <#--collapse-->
<#--Create-->
                    <form class="form-inline mt-1"  method="post" action="/rules/save">
                         <div class="row">
                              <div class="col-2">
                                   <input type="text" class="form-control" name="groupId" placeholder="groupId" aria-label="groupId" required >
                              </div>
                              <div class="col-2">
                                   <input type="text" class="form-control" name="prefix" placeholder="prefix" aria-label="description">
                              </div>
<#--                              <div class="col-2">-->
<#--&lt;#&ndash;                                   <input type="text" class="form-control" name="timeRec" placeholder="timeRec" aria-label="timeRec">&ndash;&gt;-->
<#--                              </div>-->

<#--                         </div>-->
<#--                         <div class="row">-->
                              <div class="col-2">
                                   <input type="text" class="form-control" name="priority" placeholder="priority" aria-label="priority" required>
                              </div>
                              <div class="col-2">
                                   <#--                                   <#if routeId??>-->
                                   <input type="text" class="form-control" name="routeId" placeholder="routeId" aria-label="routeId" required>
                                   <#--                                   <#else >-->
                                   <#--                                        <input type="text" class="form-control" name="routeId" placeholder="routeId" aria-label="routeId"></input>-->
                                   <#--                                   </#if>-->
                              </div>
                              <div class="col-2 ">
                                   <select type="text"  name="gwList" class="form-select ml-3" aria-label="Default select example" required>
                                        <option  selected >Выберите шлюз: </option>
                                        <option disabled>
                                             id описание
                                        </option>
                                        <#list gateways as g>

                                             <option type="text" name="gwList" value="${g.gwId}" >${g.gwId}
                                                  ${g.description}
                                             </option>
                                        </#list>
                                   </select>
                              </div>
                              <div class="col-2">
                                   <input type="text" class="form-control " name="description" placeholder="description" aria-label="description" >
                              </div>
                              <div class="col-2 mt-1">
                                   <button type="submit" class="btn btn-primary">Добавить</button>
                              </div></div>
                    </form>
                              <div class="col mt-1">
                              <form action="/rules/activate" method="post">
                                   <button type="submit" class="btn btn-primary">Применить правила</button>
                              </form>

                                   <#if resultCommand??>
                                        <#assign x=1>
                                        <#list resultCommand as result>
                                                   <div>Server ${x}:  ${result}</div>
                                                  <#assign x=x+1>
                                        </#list>

                                   </#if>
                              </div>


          <#--list-->
          <#--read Update-->
          <table class="table">
               <thead>
               <tr>
                    <th scope="col">id</th>
                    <th scope="col">groupId</th>
                    <th scope="col">prefix</th>
<#--                    <th scope="col">timeRec</th>-->
                    <th scope="col">priority</th>
                    <th scope="col">routeId</th>
                    <th scope="col">gw_Lists__</th>
                    <th scope="col">description</th>
                    <th scope="col"></th>
               </tr>
               </thead>
               <tbody>

               <#list rules as r>
                    <tr>
                         <form action="/rules/update" method="post" >
                              <#if r.ruleId??>
                                   <td class="row">

                                        <input type="text" name="ruleId" class="form-control"  value="${r.ruleId}">

                                   </td>
                              </#if>
                              <#if r.groupId??>
                                   <td><input type="text" class="form-control"
                                              name="groupId" value="${r.groupId}" required></td>
                              <#else ><td>null</td>
                              </#if>
                              <#if r.prefix??>
                                   <td><input type="text" class="form-control"
                                              name="prefix" value="${r.prefix}" ></td>
                              <#else ><td>null</td>
                              </#if>
<#--                              <#if r.timeRec??>-->
<#--                                   <td><input type="text" class="form-control"-->
<#--                                              name="timeRec" value="${r.timeRec}"></td>-->
<#--                              <#else ><td><input type="text" class="form-control"-->
<#--                                                 name="priPrefix" value=" "></td></td>-->
<#--                              </#if>-->
                              <#if r.priority??>
                                   <td><input type="text" class="form-control"
                                              name="priority" value="${r.priority}" required></td>
                              <#else ><td><input type="text" class="form-control"
                                                 name="priority" value=" " required></td></td>
                              </#if>
                              <#if r.routeId??>
                                   <td><input type="text" class="form-control"
                                              name="routeId" value="${r.routeId}" required> </td>
                              <#else ><td><input type="text" class="form-control"
                                                 name="routeId" value=" " required></td></td>
                              </#if>
                              <#if r.gwList??>
                              <td><select name="gwList" class="form-select ml-3" aria-label="Default select example">
                                        <option selected value="${r.gwList}">${r.gwList} </option>

                                        <#list gateways as g>
                                             <option  name="gwList" value="${g.gwId}"> ${g.gwId} ${g.description}</option>
                                        </#list>
                                   </select>
                              </td>
                              </#if>
                              <#if r.description??>
                                   <td><input type="text" class="form-control"
                                              name="description" value="${r.description}"></td>
                              <#else ><td><input type="text" class="form-control"
                                                 name="description" value=" "></td></td>
                              </#if>
                              <td>
                                   <button type="submit" value="save" class="btn btn-primary">Сохранить</button>
                              </td>
                         </form>
                         <td>
                              <#--delete-->
                              <form action="/rules/${r.ruleId}/delete" method="post" >
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