var vm = new Vue({
    el: '#main-container',
    data: {
        type:'',
        pageInfo:{
            pageNum:1,
            pageSize:5
        }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            axios({url:path+"/manager/statute/toIndex",params:{type:this.type,pageNum:pageNum,pageSize:pageSize}})
                .then(response => {
                    // console.log(response.data);
                    this.pageInfo = response.data;
                })
                .catch(function(error){console.log(error)});
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
        selectByType:function(){
            //带条件查询，需要访问第一页数据，并且带type
            this.selectAll(1,this.pageInfo.pageSize);
        },
        selectAll2:function(){
            //查询全部数据  需要清空条件数据 访问第一页
            this.type='';
            this.selectAll(1,this.pageInfo.pageSize);
        }
    },
    created: function () {
        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    }

});