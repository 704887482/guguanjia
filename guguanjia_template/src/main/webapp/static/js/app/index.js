var vm = new Vue({
    el: '#main-container',
    data: {
        appList: [],//原list
        pageInfo:'',//分页对象
        appVersion:''
    },
    methods: {
        selectAll: function (pageNum,pageSize) {
            // var _this = this;
            axios({
                url: path+'/manager/app/toIndex',
                params:{
                    pageNum:pageNum,
                    pageSize:pageSize
                }
            }).then(response=>{
                console.log(response);
                this.appList=response.data.list;
                this.pageInfo=response.data;
            }).catch(reason => {
                console.log(reason);
            })
        },
        toUpdate:function (id) {
            console.log(id);
        }
    },
    created: function () {
        this.selectAll();
    },

});
