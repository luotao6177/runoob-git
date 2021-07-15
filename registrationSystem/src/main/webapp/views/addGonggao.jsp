<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 全局js -->
    <script src="../static/js/jquery.min.js?v=2.1.4"></script>
    <script src="../static/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- iCheck -->
    <script src="../static/js/plugins/iCheck/icheck.min.js"></script>
    <script src="../static/layer/layer.js"></script>
    <!-- 自定义js -->
    <script src="../static/js/content.js?v=1.0.0"></script>

    <title> - 基本表单</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">
	<style>
		.form-control, .single-line{padding:4px 12px;}
	</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>新增公告</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                <form role="form" class="form-horizontal">
                                    <div class="form-group">
                                        *<label>公告标题(必填)</label>
                                        <input id="gonggaoTitle" type="text" placeholder="请输入公告标题" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        *<label>公告内容(必填)</label>
                                        <input id="gonggaoContent" type="text" placeholder="请输入公告内容" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        *<label>发布时间(必填)</label>
                                        <input id="gonggaoTime" type="text" placeholder="请输入发布时间" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        *<label>发布人(必填)</label>
                                        <select class="form-control m-b" name="gonggaoAuthor" id="gonggaoAuthor">

                                        </select>
                                    </div>

                                    <div>
                                        <button type="button" class="btn btn-sm btn-primary pull-right m-t-n-xs" onclick="addGonggao()">
                                        	<strong>新 增</strong>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           </div>
    </div>



    <script>
	    $(document).ready(function () {
	        $('.i-checks').iCheck({
	            checkboxClass: 'icheckbox_square-green',
	            radioClass: 'iradio_square-green',
	        });
	    });

        //获取所有医生信息
        $.ajax({
            url: '../getDocList.do',
            type: 'POST',
            dataType: 'JSON',
            success: function(res){
                for(var j=0;j<res.length;j++)
                    $("#gonggaoAuthor").append("<option value='"+res[j].doctorName+"'>"+res[j].doctorName+"</option>");
            },
            error: function(res){
                layer.msg('加载失败');
            }
        });

        function addGonggao(){
            /*alert();*/
        	var gonggaoTitle = $('#gonggaoTitle').val();
        	var gonggaoTime = $('#gonggaoTime').val();
        	var gonggaoContent = $('#gonggaoContent').val();
        	var gonggaoAuthor = $('#gonggaoAuthor').val();
           /* alert(gonggaoTitle);
            alert(gonggaoTime);
            alert(gonggaoContent);*/

        	if(gonggaoTitle == "" || gonggaoTime == "" || gonggaoContent == "") {
                //layer.msg("请输入公告必填信息!");
                alert("请输入公告必填信息!");
            }else {
                $.ajax({
                    url: '../addGonggao.do',
                    type: 'POST',
                    data: {'gonggaoTitle':gonggaoTitle,'gonggaoTime':gonggaoTime,'gonggaoContent':gonggaoContent,'gonggaoAuthor':gonggaoAuthor},
                    dataType: 'JSON',
                    success: function(result){
                        if(result=="success"){
                            layer.alert('新增成功',function(index){
                                layer.close(index);
                                parent.reload();
                                parent.layer.close(frameIndex);
                            });
                        }else if(result=="exists"){
                            layer.msg("公告已存在!");
                        }
                    },
                    error: function(res){
                        layer.msg('新增失败');
                    }
                })
            }

        }
    </script>

    
    

</body>

</html>
