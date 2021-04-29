requirejs.config({
    baseUrl:'js'
})
require(['views/main','views/cars'],function (main,cars){
    webix.ready(function () {
        webix.ui({
            id:'web',
            rows:[
                main
            ]
        })
    })
});
