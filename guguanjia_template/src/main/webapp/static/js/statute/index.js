var vm = new Vue({
    el: '#main-container',
    data: {
        type: '',
        pageInfo: {
            pageNum: 1,
            pageSize: 5
        },
        obj:'',
        statute: {
            description: `<h2><img src="http://img.baidu.com/hi/jx2/j_0003.gif"/>Vue + UEditor + v-model双向绑定1</h2>`
        },
        myconfig: {
            UEDITOR_HOME_URL: path + '/static/ueditor/',//设置组件的默认读取ueditor文件的目录
            initialFrameWidth: '100%',
            initialFrameHeight: 350,
            autoHeightEnabled: false,
            //服务器统一请求接口路径
            serverUrl: path + '/manager/ueditor/config'
        }
    },
    components: {
        VueUeditorWrap //导入第三方组件
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            axios({
                url: path + "/manager/statute/toIndex",
                params: {
                    type: this.type,
                    pageNum: pageNum,
                    pageSize: pageSize
                }
            }).then(response => {
                this.pageInfo = response.data;
            }).catch(error => console.log(error))
        },
        selectById: function (id) {
            axios({
                url: path + "/manager/statute/selectById/" + id
            }).then(value => {
                this.obj=value.data;
                console.log(this.obj);
            }).catch(reason => console.log(reason))
        },
        update: function () {
            axios({
                url:path+"/manager/statute/update",data:this.obj,method: "post"
            }).then(value => {
                if (value.data.success){
                    this.obj='';
                    this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                    alert(value.data.msg);
                    $("#updateModal").modal("hide");
                }else {
                    alert(value.data.msg);

                }
            }).catch(reason => console.log(reason))
        },
        save: function () {
            axios({url: path + "/manager/statute/save", data: this.statute, method: "post"})
                .then(value => {
                    console.log(value.data);
                    if (value.data.success) {
                        this.clear();
                        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                        alert(value.data.msg);
                    } else {
                        alert(value.data.msg);
                    }
                }).catch(reason => console.log(reason));
        },
        deleteById:function (id) {
            axios({url:path+"/manager/statute/delete/"+id}).then(value => {
                if (value.data.success){
                    alert(value.data.msg);
                    this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                }else {
                    alert(value.data.msg);
                }
            }).catch(reason => console.log(reason))
        }
        , clear: function () {
            this.statute = {
                description: ''
            };
        }
        ,
        selectAll2: function () {
            this.type = '';
            this.selectAll(1, this.pageInfo.pageSize);
        },
        selectAll3: function (pageNum, pageSize) {
            this.type = '';
            this.selectAll(pageNum, pageSize);
        },
        selectByType: function () {
            this.selectAll(1, this.pageInfo.pageSize)
        }
    },
    created: function () {
        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    }
})