var vm = new Vue({
    el: "#fill-main-content",
    data: {
        demandList: [],//list
        pageInfo:'',//分页对象
        demand:{
            id:'',
            createDate:'',
            name:'',
            phone:'',
            company:'',
            description:'',
            status:'',
            treatment:''
        }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            axios({
                url: path + "/manager/demand/toIndex",
                params: {
                    pageNum: pageNum,
                    pageSize: pageSize
                }
            }).then(value => {
                this.demandList = value.data.list;
                this.pageInfo=value.data;
            }).catch(reason => console.log(reason));
        },
        toUpdate:function (id) {
            axios({
                url:path+"/manager/demand/selectById",
                params:{
                    id:id
                }
            }).then(value => {
                $("#updateModal").modal("show");
                this.demand=value.data;
                console.log(demand);
            }).catch(reason => console.log(reason))
        },
        update:function () {
            axios({
                url:path+"/manager/demand/update",
                method:'post',
                data: this.demand
            }).then(value => {
                
                if (value.data.success){
                    for (let i = 0; i < this.demandList.length; i++) {
                        if (this.demandList[i].id==this.demand.id){
                            Vue.set(this.demandList,i,this.demand);
                        }
                    }
                    $("#updateModal").modal("hide");
                }else {
                    alert(value.data.msg);
                }
                console.log(value);
            }).catch(reason => console.log(reason))
        },
        detail:function (id) {
            axios({
                url:path+"/manager/demand/selectById",
                params:{
                    id:id
                }
            }).then(value => {
                $("#detailModal").modal("show");
                this.demand=value.data;
                console.log(demand);
            }).catch(reason => console.log(reason))
        }
    },
    created: function () {
        this.selectAll();
    }
});