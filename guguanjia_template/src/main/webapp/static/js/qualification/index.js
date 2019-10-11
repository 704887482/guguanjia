var vm = new Vue({
    el: '#main-container',
    data: {},
    methods: {
        selectAll: function (pageNum, pageSize) {
            axios({}).then(response => {
            }).catch(error => console.log(error))
        },
        update: function () {
        }
    },
    created: function () {

    }
})