var vm = new Vue({
    el: '#main-container',
    data: function(){
      return{
          pageInfo:{
              pageNum:1,
              pageSize:5
          },
          params: {
              pageNum: '',
              pageSize: '',
              companyName:'',
              lDate:'',
              rDate:'',
              status:''
          },//list
          companyName:'全部',
          treeObj:'',//树对象
          name:'',
          flag:false,
          lDate:'',
          rDate:'',
          status:'',
          setting:{
              data:{
                  simpleData:{
                      enable:true, //设置简单数据模式,自动根据id(默认id)和pId(默认pId)  、rootId（默认0）生成菜单树
                      idKey:'id',
                      pIdKey:'parentId',
                      rootPId:0
                  }
              },
              callback:{
                  //this.onClick undefined  说明this是undefined或者  this对象上没有onClick函数    此处this是windows对象
                  onClick:this.onClick
              },
              view: {
                  expandSpeed: "normal",
                  fontCss:this.setFontCss
              }
          },
          workDetail:'',
          nodes:'',
          print2:''
      }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.params.pageNum=pageNum;
            this.params.pageSize=pageSize;
            axios({
                url: path + "/manager/admin/toIndex",method:'post',data:this.params
            }).then(value => {
                this.pageInfo=value.data;
            }).catch(reason => console.log(reason));
        },
        initTree:function(){
            axios({url:path+"/manager/office/selectOffices"}).then(value => {
                value.data[value.data.length]={"id":0,name:"全部","open":true};//将根节点放入数组
                this.nodes=value.data;
                //obj,setting,nodes     obj传入一个ztree的存放容器dom对象    setting设置参数      nodes设置ztree上显示的菜单数的内容
                    this.treeObj=$.fn.zTree.init($("#pullDownTreeone"),this.setting,this.nodes);
            }).catch(reason => console.log(reason))
        },
        showTree:function(){
            //通过
            this.flag = true;
            this.treeObj.expandAll(true);//展开所有节点
        },
        detail:function(id){
            axios({url:path+"/manager/admin/work/detail/"+id})
                .then(value => {
                    this.workDetail=value.data;
                    console.log(this.data);
                    $("#detailModal").modal("show");
                }).catch(reason => console.log(reason))
        },
        print:function(id){
          axios({url:path+"/manager/admin/work/print/"+id}).then(value => {
              this.print2=value.data;
              $("#printModal").modal("show");
              console.log(value);
          }).catch(reason => console.log(reason));
        },
        selectAll2:function(){
            this.params={
                pageNum: '',
                    pageSize: '',
                    companyName:'',
                    lDate:'',
                    rDate:'',
                    status:''
            },
          this.selectAll(1,this.pageInfo.pageSize);
        },
        selectCondition:function(){
            this.params.companyName = this.companyName;
            this.params.lDate=this.lDate;
            this.params.rDate=this.rDate;
            this.params.status=this.status;
            this.selectAll(1,this.pageInfo.pageSize);
        },
        onClick:function(event,treeId,treeNode){
            this.companyName = treeNode.name;
        },
        search:function(){
            //清除原绑定的选中标记属性值为false
            let treeNodes = this.treeObj.getNodes();//返回所有节点集合,组成格式是  父节点嵌套包含子节点数组格式
            treeNodes = this.treeObj.transformToArray(treeNodes);
            for (let i = 0; i < treeNodes.length; i++) {
                treeNodes[i].hightLight = false;
                this.treeObj.updateNode(treeNodes[i]);
            }
            // console.log(this.name);
            let searchNodes = this.treeObj.getNodesByParamFuzzy("name",this.name,null);
            //设置选中标记为true
            for (let i = 0; i < searchNodes.length; i++) {
                searchNodes[i].hightLight=true;//添加一个选中标记设置为true
                this.treeObj.updateNode(searchNodes[i]);//将该节点更新
            }

        },
        setFontCss:function(treeId, treeNode){
            return treeNode.hightLight?{color:"red","font-weight":"blod"}:{color:"black","font-weight":"normal"};
        }
    },
    created: function () {
        this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);
    },
    mounted:function(){//dom树生成后
        this.initTree();
    }
})