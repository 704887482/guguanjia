

$(function() {


//处理head标签的公共引入css和  公共 引入js
    console.log(path);
    <!-- bootstrap & fontawesome -->
    var head = '';
    head += `<link rel="stylesheet" href="${path}/static/bootstrap/bootstrap.min.css" />`;
    head += `<link rel="stylesheet" href="${path}/static/css/font-awesome.min.css" />`;
    head += `<link rel="stylesheet" href="${path}/static/chosen/chosen.min.css" />`;
    <!-- ace styles -->
    head += `<link rel="stylesheet" href="${path}/static/ace/css/ace.min.css" id="main-ace-style" />`
    head += `<link rel="stylesheet" href="${path}/static/ace/css/ace-skins.min.css" />`;
    head += `<link rel="stylesheet" href="${path}/static/ace/css/ace-rtl.min.css" />`;
    head += `<link rel="stylesheet" href="${path}/static/ztree/metro.css" />`;
    head += `<link rel="stylesheet" href="${path}/static/validate/css/validform.css" />`;
    head += `<link rel="stylesheet" href="${path}/static/css/custom.css" />`;

    head += `<script src="${path}/static/bootstrap/bootstrap.min.js"></script>`;
    <!-- ace scripts -->
    head += `<script src="${path}/static/ace/js/ace.min.js"></script>`;
    head +=`<script src="${path}/static/ace/js/ace-elements.min.js"></script>`;

    <!-- ace settings handler -->
    head += `<script src="${path}/static/ace/js/ace-extra.min.js"></script>`;
    <!-- 引入其他js -->
    head += `<script src="${path}/static/js/history.js"></script> `;
    /*script += `<script  src="${path}/static/layer/layer.min.js"></script>`;*/
    head += `<script  src="${path}/static/js/spin.min.js"></script>`;
    head += `<script  src="${path}/static/ztree/jquery.ztree.all-3.5.min.js"></script>`;
    head += `<script  src="${path}/static/js/jquery.autosize.min.js"></script>`;
    head += `<script  src="${path}/static/chosen/chosen.jquery.min.js"></script>
    <script src="${path}/static/validate/Validform_v5.3.2_min.js"></script>
    <script  src="${path}/static/js/jquery.form.js"></script>
    <script  src="${path}/static/js/bootstrap-contextmenu.js"></script>
    <script  src="${path}/static/js/jquery.nicescroll.min.js"></script>
    <script  src="${path}/static/js/public.js"></script>
    <script  src="${path}/static/js/vue.js"></script>
    <script src="${path}/static/js/axios.js"></script>
    <script  src="${path}/static/js/common/vuePublic.js"></script>
    `;
//放入head
    $("head:eq(0)").html(head);

})