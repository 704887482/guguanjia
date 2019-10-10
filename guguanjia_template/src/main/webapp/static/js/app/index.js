var vm = new Vue({
    el: '#main-container',
    data: {
        appList: [],//原list
        pageInfo:'',//分页对象
        appVersion:{
            platform:'',
            forceUpdate:'',
            versionNo:'',
            downPath:'',
            size:'',
            appExplain:''
        }
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
                this.appList=response.data.list;
                this.pageInfo=response.data;
            }).catch(reason => {
                console.log(reason);
            })
        },
        toUpdate:function (id) {
            console.log(id);
            axios({
                url:path+'/manager/app/selectById',params:{id:id}
            }).then(response=>{
                this.appVersion=response.data;
            $("#updateModal").modal("show");
            }).catch(reason => {
                console.log(reason);
            });
        },
        update:function () {
            axios({url:path+'/manager/app/update',method:'post',data:this.appVersion}).then(value => {
                if (value.data.success){
                    for (let i = 0; i < this.appList.length; i++) {
                        if (this.appVersion.id==this.appList[i].id){
                            Vue.set(this.appList,i,this.appVersion);
                        }
                    }
                    $("#updateModal").modal("hide");
                }else {
                    alert(value.data.msg);
                }
            }).catch(reason => {
                console.log(reason);
            })
        },
        toDelete:function (id) {
            this.id=id;//将id放入vue
            $("#delModal").modal("show");
        },
        deleteById:function () {
            axios({url:path+'/manager/app/delete',params:{id:this.id}})
                .then(value => {
                    if (value.data.success){
                        $("#delModal").modal("hide");
                        this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);
                    }else {
                        alert(value.data.msg);
                    }
                })
                .catch(reason => {
                    console.log(reason);
                })
        },
        save:function () {
            axios({url:path+"/manager/app/save",method: "post",data:this.appVersion})
                .then(value => {
                    if (value.data.success){
                        alert(value.data.msg);
                        this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);
                        this.clearAppVersion();
                    }else {
                        alert(value.data.msg);
                    }
                }).catch(reason => {
                    console.log(reason);
            });
        },
        clearAppVersion:function () {//清空对象数据
            this.appVersion={
                platform:'',
                forceUpdate:'',
                versionNo:'',
                downPath:'',
                size:'',
                appExplain:''
            }
        }
    },
    created: function () {
        this.selectAll();
    },

});
