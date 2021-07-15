<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 数据表格</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="../static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">
    <style>
    	.float-e-margins .btn {margin-bottom: 0px;}		
		.tableBtn{float:left;width:30%;margin-top:0px;margin-left:5px;padding:2px 8px;}
    </style>
	
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>公告<small>列表</small></h5>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>公告ID</th>
                                    <th>公告标题</th>
                                    <th>公告内容</th>
                                    <th>发布时间</th>
                                    <th>公告发布人</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
        
    </div>

    <!-- 全局js -->
    <script src="../static/js/jquery.min.js?v=2.1.4"></script>
    <script src="../static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="../static/js/plugins/jeditable/jquery.jeditable.js"></script>
    <!-- Data Tables -->
    <script src="../static/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="../static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <!-- 自定义js -->
    <script src="../static/js/content.js?v=1.0.0"></script>
	<script src="../static/layer/layer.js"></script>

    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
        	$.ajax({
        		url: '../getGonggaoList.do',
        		type: 'POST',
        		dataType: 'JSON',
        		success: function(res){
        		    //alert(res);

        			var data = res;
        			//然后 DataTables 这样初始化：
                    $('.dataTables-example').DataTable( {
                    	"bAutoWidth": false,
                        data: data,
                        columns: [
                            { data: 'gonggaoId' ,width:"5%"},
                            { data: 'gonggaoTitle' ,width:"15%"},
                            { data: 'gonggaoContent' ,width:"45%"},
                            { data: 'gonggaoTime' ,width:"10%"},
                            { data: 'gonggaoAuthor' ,width:"5%"}
                        ],
                        columnDefs:[{
                            targets: 5,
                            render: function (data, type, row, meta) {
                                return '<a type="button" class="btn btn-danger tableBtn" href="#" onclick=showGonggao(' + row.gonggaoId + ') >查看公告详情</a>';
                            }
                        },
                            { "orderable": false, "targets": 5 },
                        ]
                    } );
        		},
        		error: function(res){
        			layer.msg('新增失败');
        		}
        	});

        });

        function showGonggao(id){
            layer.open({
                type: 2,
                title: '公告详情',
                shadeClose: true,
                shade: 0.8,
                area: ['90%', '80%'],
                content: './gonggaoDetails.jsp',
                success: function (layero, index) {
                    var iframe = window['layui-layer-iframe' + index];
                    iframe.getGonggaoById(id)
                }
            });
        }
        function addGonggao(){
        	layer.open({
        		  type: 2,
        		  title: '新增公告信息',
        		  shadeClose: true,
        		  shade: 0.8,
        		  area: ['50%', '50%'],
        		  content: './addGonggao.jsp' //iframe的url
        		}); 
        }

        //重新加载
        function reload(){
        	window.location.reload();
        }
        
        function show(data){
        	layer.alert(data);
        }
    </script>

    
    

</body>

</html>
