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
            axios({
                url:path+"/manager/statute/toIndex",
                params:{
                    type:this.type,
                    pageNum:pageNum,
                    pageSize:pageSize
                }
            }).then(response => {
                this.pageInfo=response.data;
            }).catch(error => console.log(error))
        },

        update: function () {
        },
        selectAll2:function () {
          this.type='';
          this.selectAll(1,this.pageInfo.pageSize);
        },
        selectAll3:function (pageNum,pageSize) {
            this.type='';
            this.selectAll(pageNum,pageSize);
        },
        selectByType:function () {
            this.selectAll(1,this.pageInfo.pageSize)
        }
    },
    created: function () {
        this.selectAll(this.pageNum,this.pageSize);
    }
})