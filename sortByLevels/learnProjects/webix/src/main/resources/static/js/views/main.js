define(['views/cars'], function (cars){
    return {
        container: "web",
        height: 400,
        id:'web',
        rows: [
            {
                view: 'button',
                label: 'cars',
                click: function () {
                    webix.ui(car, $$('web'))
                }
            },
            {template: "View 1"},
            {template: "View 2"}
        ]
    }
})