var vm = new Vue({
    el: '#main-container',
    data: {
        work: [],//list
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            axios({
                url: path + "/manager/admin/work", params: {
                    pageNum: pageNum,
                    pageSize:pageSize
                }
            }).then(value => {
                console.log(value);
            }).catch(reason => console.log(reason));
        }
    },
    created: function () {
        this.selectAll();
    }
})