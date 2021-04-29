
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
          <div class="container">
               <div class="row align-items-start">
                    <h5> Server 1</h5>
                    <form class="form-inline col-6 mt-1"  method="post" action="/connection/servers/1">
                         <input  type="text"  name="command1" placeholder="команда"/>
                         <button class="btn btn-primary"  type="submit" >Ввод</button>
                    </form>
                    <#if result1??>
                    <p>${result1}</p>
                    </#if>
               </div>
               <div class="row align-items-center">
                    <h5>Server 2</h5>
                    <form class="form-inline col-6 mt-1"  method="post" action="/connection/servers/2">
                         <input  type="text"  name="command2" placeholder="команда"/>
                         <button class="btn btn-primary"  type="submit" >Ввод</button>
                    </form>
                    <#if result2??>
                         <p>${result2}</p>
                    </#if>
               </div>

          </div>

     </div>
</div>

<!-- Option 2: Separate Popper and Bootstrap JS -->

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>


</body>
</html>