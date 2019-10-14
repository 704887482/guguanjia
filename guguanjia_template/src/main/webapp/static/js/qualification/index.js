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
        },
        obj:''
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
                this.pageInfo=response.data;
                console.log(this.pageInfo);
            }).catch(function(error){console.log(error)})
        },
        toUpdate: function (id) {

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
        },
        selectById:function (id) {
            axios({
                url:path+'/manager/qualification/selectById/'+id
            }).then(value => {
                this.obj=value.data;
                //显示模态框
                $("#updateModal").modal("show");
            }).catch(function (error) {

            });
        },
        update:function (check) {
            this.obj.check=check;
            this.obj.address=null;
            axios({url:path+'/manager/qualification/update',method:'post',data:this.obj})
                .then(value => {
                    if (value.data.success){
                        /*for (let i = 0; i < this.pageInfo.list.length; i++) {
                            if(this.obj.id==this.pageInfo.list[i].id){
                                Vue.set(this.pageInfo.list,i,this.obj);//vue处理数组监听api
                            }
                        }*/
                        alert(value.data.msg);
                        $("#updateModal").modal("hide");
                        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                    }else {
                        alert(value.data.msg);
                    }

                }).catch(reason => console.log(reason))
        }
    },
    created: function () {
        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    }

});