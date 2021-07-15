<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 个人中心</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
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
   <%-- <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>我的挂号单<small>列表</small></h5>
                        <div class="ibox-tools">
                        </div>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>挂号单ID</th>
                                    <th>预约人姓名</th>
                                    <th>挂号科室</th>
                                    <th>挂号医生</th>
                                    <th>挂号单状态</th>
                                    <th>预约时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody id="deptList">
                            
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
        
    </div>--%>
   <div class="middle-box text-center loginscreen   animated fadeInDown">
       <div>
           <div>

              <%-- <h1 class="logo-name">H+</h1>--%>
               <h2> 个人中心</h2>
           </div>
           <%--<h3>欢迎注册 【医院挂号系统】</h3>
           <p>创建一个新账户</p>--%>
           <form class="m-t" role="form" action="login.html">
               <div class="form-group">
                   <input id="username" type="text" class="form-control" placeholder="请输入用户名" required="">
               </div>
               <div class="form-group">
                   <input id="password" type="password" class="form-control" placeholder="请输入密码" required="">
               </div>
               <div class="form-group">
                   <input id="repassword" type="password" class="form-control" placeholder="请再次输入密码" required="">
               </div>
               <div class="form-group">
                   <input id="name" type="text" class="form-control" placeholder="请输入姓名" required="">
               </div>
               <div class="form-group">
                   <input id="address" type="text" class="form-control" placeholder="请输入地址" required="">
               </div>
               <div class="form-group">
                   <input id="tel" type="text" class="form-control" placeholder="请输入联系方式" required="">
               </div>
               <button type="button" class="btn btn-primary block full-width m-b" onclick="register()">注 册</button>

               <p class="text-muted text-center"><small>已经有账户了？</small><a href="login.jsp">点此登录</a>
               </p>
           </form>
           <div class="form-group">
               <input id="username" type="text" class="form-control" placeholder="" required="">
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
	<script type="text/javascript" src="../static/js/jquery.cookie.js"></script>
    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
         	var username = $.cookie('username');
         	
        	$.ajax({
        		url: '../getRegListByName.do',
        		type: 'POST',
        		data:{'hzUsername':username},
        		dataType: 'JSON',
        		success: function(res){
        			var data = res;
        			//然后 DataTables 这样初始化：
                    $('.dataTables-example').DataTable( {
                        data: data,
                        columns: [
                            { data: 'registerId' },
                            { data: 'hzName' },
                            { data: 'deptName' },
                            { data: 'doctorName' },
                            { data: 'ghStatus',render:function(data,type,row){
                                if(data == 1){
                                    return "<button class='btn btn-success'>正常</a>";
                                }else{
                                    return "<button class='btn btn-danger'>取消</a>";
                                }
                        	} },
                            { data: 'registerTime' },
                            { data: null}
                        ],
                        columnDefs:[{
                            targets: 6,
                            render: function (data, type, row, meta) {
                            	if(row.ghStatus == 1){
                            		return '<a type="button" class="btn btn-info" href="#" onclick=changeghStatus(' + row.registerId + ') >取消预约 </a>';
                            	}else{
                            		return '<a type="button" class="btn btn-danger" href="#" disabled>已取消 </a>';
                            	}
                            	
                                
                            }
                        },
                            { "orderable": false, "targets": 4 },
                        ],
                    } );
        		},
        		error: function(res){
        			layer.msg('加载失败');
        		}
        	});
        });
        function changeghStatus(id){
            	layer.confirm('确认取消预约？', {
          		  btn: ['确定','取消'] //按钮
          		}, function(){
          			$.ajax({
                  		url: '../updateghStatus.do',
                  		type: 'POST',
                  		data: {
                  			'registerId':id
                  		},
                  		dataType: 'JSON',
                  		success: function(result){
                  			if(result=="success"){
                  				layer.alert('修改成功',function(index){
                  					layer.close(index);
                  					reload();
                  				});
                  			}
                  		},
                  		error: function(res){
                  			layer.msg('修改失败');
                  		}
                  	});
          		}, function(){
          	});
        }
        //重新加载
        function reload(){
        	window.location.reload();
        }
    </script>
	
    
    

</body>

</html>
