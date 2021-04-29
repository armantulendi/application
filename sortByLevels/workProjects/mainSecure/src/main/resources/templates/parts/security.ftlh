<#--Определяем переменные для freemarker, переменные подтягивается из контроллера -->
<#assign
known=Session.SPRING_SECURITY_CONTEXT??
>
<#if known><#--if session opened-->
    <#assign
    user1=Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name=user1.getUsername()
    isAdmin=user1.isAdmin()
    >
<#else>
    <#assign
        name="пользователь"
        isAdmin=false
    >
</#if>