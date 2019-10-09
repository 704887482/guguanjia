$(function () {
    var head = '';
    head = `<!-- bootstrap & fontawesome -->
            <link rel="stylesheet" href="${path}/static/bootstrap/bootstrap.min.css" />
            <link rel="stylesheet" href="${path}/static/css/font-awesome.min.css" />
            <link rel="stylesheet" href="${path}/static/chosen/chosen.min.css" />
            <!-- ace styles -->
            <link rel="stylesheet" href="${path}/static/ace/css/ace.min.css" id="main-ace-style" />
            <link rel="stylesheet" href="${path}/static/ace/css/ace-skins.min.css" />
            <link rel="stylesheet" href="${path}/static/ace/css/ace-rtl.min.css" />
            <link rel="stylesheet" href="${path}/static/ztree/metro.css" />
            <link rel="stylesheet" href="${path}/static/validate/css/validform.css" />
            <link rel="stylesheet" href="${path}/static/css/custom.css" />
            <!-- ace settings handler -->
            <script src="${path}/static/ace/js/ace-extra.min.js"></script>
            <script src="${path}/static/bootstrap/bootstrap.min.js"></script>
            <!-- ace scripts -->
            <script src="${path}/static/ace/js/ace.min.js"></script>
            <script src="${path}/static/ace/js/ace-elements.min.js"></script>
            <!-- 引入其他js -->
            <script src="${path}/static/js/history.js"></script>
            <script type="text/javascript" src="${path}/static/js/spin.min.js"></script>
            <script type="text/javascript" src="${path}/static/ztree/jquery.ztree.all-3.5.min.js"></script>
            <script type="text/javascript" src="${path}/static/js/jquery.autosize.min.js"></script>
            <script type="text/javascript" src="${path}/static/chosen/chosen.jquery.min.js"></script>
            <script type="text/javascript" src="${path}/static/validate/Validform_v5.3.2_min.js"></script>
            <script type="text/javascript" src="${path}/static/js/jquery.form.js"></script>
            <script type="text/javascript" src="${path}/static/js/bootstrap-contextmenu.js"></script>
            <script type="text/javascript" src="${path}/static/js/jquery.nicescroll.min.js"></script>
            <script type="text/javascript" src="${path}/static/js/public.js"></script>
            <script type="text/javascript" src="${path}/static/js/vue.js"></script>
            <script type="text/javascript" src="${path}/static/js/axios.js"></script>
            <script type="text/javascript" src="${path}/static/js/common/vuePublic.js"></script>
            <script type="text/javascript" src="${path}/static/js/app/index.js"></script>`;

    //放入head
    $("head:eq(0)").html(head);

    //load（url）：异步加载url地址返回的html
    $("#navbar").load(`${path}/manager/common/navbar`);
    $("#sidebar").load(`${path}/manager/common/sidebar`);
    $("#ace-settings-container").load(`${path}/manager/common/aceSetting`);

})