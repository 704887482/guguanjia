var vm = new Vue({
    el: '#main-container',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5
        },
        params:{
            pageNum:'',
            pageSize:'',
            type:'',
            startDate:'',
            endDate:'',
            check:''
        }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            // var _this = this;
            this.params.pageNum = pageNum;
            this.params.pageSize = pageSize;
            axios({
                url:path+'/manager/qualification/toIndex',method:"post",data:this.params}).then( response => {
                // this.appList = response.data.list;//箭头函数，会自动将当前函数selectAll中的this传递过来
                this.pageInfo = response.data;
                console.log(this.pageInfo);
            }).catch(function(error){})
        },
        toUpdate: function (id) {

        },
        update: function () {


        },
        toDelete: function (id) {

        },
        deleteById: function () {

        },
        save: function () {

        },
        selectAllByCondition:function(){
            this.selectAll(1,this.pageInfo.pageSize);
        },
        selectAll2:function(){
            this.deleteAll();
            this.selectAll(1,this.pageInfo.pageSize);
        },
        deleteAll:function(){
            this.params={
                    pageNum:'',
                    pageSize:'',
                    type:'',
                    startDate:'',
                    endDate:'',
                    check:''
            }
        }
    },
    created: function () {
        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    }

});