var vm = new Vue({
    el:'#main-container',
    data:{
        appList:[],//原list
        pageInfo:'',//分页对象
        path:path,
        appVersion:{
            platform:'',
            forceUpdate:'',
            versionNo:'',
            downPath:'',
            size:'',
            appExplain:''
        },
        id:''
    },
    methods:{
        selectAll:function(pageNum,pageSize){
            // var _this = this;
            axios({
                url:path+'/manager/app/toIndex',params:{pageNum:pageNum,pageSize:pageSize}}).then( response => {
                   this.appList = response.data.list;//箭头函数，会自动将当前函数selectAll中的this传递过来
                   this.pageInfo = response.data;
            }).catch(function(error){})
        },
        toUpdate:function(id){
            console.log(id);

            axios({url:path+'/manager/app/selectById',params:{id:id}}).then( response=> {
                this.appVersion = response.data;
                $("#updateModal").modal("show");
            }).catch(function(error){
                console.log(error);
            })
        },
        update:function(){

            axios({url:path+'/manager/app/update',method:'post',data:this.appVersion}).then( response =>{
                // console.log(response.data);
                // console.log(this.appList);
                // console.log(this.appVersion);
                if(response.data.success){
                    //遍历appList  替换掉当前修改后的appVersion
                    for (let i = 0; i < this.appList.length; i++) {
                        if(this.appList[i].id==this.appVersion.id){
                            Vue.set(this.appList,i,this.appVersion);//vue处理数组监听api
                        }
                    }
                    alert(response.data.msg);
                    $("#updateModal").modal("hide");//隐藏模态框
                }else{
                    alert(response.data.msg);
                }
            }).catch(function(error){

            })
        },
        toDelete:function(id){
            this.id = id;//将id放入vue
            $("#delModal").modal("show");
        },
        deleteById:function(){
            axios({url:path+'/manager/app/delete',params:{id:this.id}})
                .then( response => {  //返回result
                    if(response.data.success){//删除成功
                        // for (let i = 0; i < this.appList.length; i++) {
                        //     if(this.appList[i].id==this.id){//遍历appList找出索引
                        //         this.appList.splice(i,1);//splice会自动删除
                        //     }
                        // }
                        $("#delModal").modal("hide");
                        this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);//更新视图
                    }else{
                        alert(response.data.msg);
                    }
                })
                .catch(
                    function(error){
                        console.log(error);
                    }
                )
        },
        save:function(){
            // console.log(this.appVersion);
            axios({url:path+"/manager/app/save",method:"post",data:this.appVersion})
                .then(response=>{
                    console.log(response.data);
                    if(response.data.success){
                        alert(response.data.msg);
                        //处理视图显示    ：  1.非最后一页  不用操作
                        // 2.最后一页  appVersionList长度与pageSize一致，不用操作
                        //appVersionList长度与pageSize不一致，appVersionList添加当前appVersion
                        // console.log(this.pageInfo.isLastPage);
                        // if(this.pageInfo.isLastPage){
                        //     if(this.appList.length<this.pageInfo.pageSize){
                        //         this.appList.push(this.appVersion);
                        //     }
                        // }
                        this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);
                        this.clearAppVersion();//清空表单项

                    }else{
                        alert(response.data.msg);
                    }
                })
                .catch(
                function(error){
                    console.log(error);
                }
            )
        },
        clearAppVersion:function(){//清空对象数据
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
    created:function(){
        this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);
    }
});