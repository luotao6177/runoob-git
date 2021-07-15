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
                        <h5>公告详情</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                <form role="form" class="form-horizontal">
                                    <div class="form-group" id="gonggaoTitle">
                                        <label><h2>公告标题</h2></label><br/>
                                    </div>

                                    <div class="form-group" id="gonggaoContent">
                                        <label><h3>公告内容</h3></label><br/>
                                    </div>

                                    <div class="form-group" id="gonggaoTime">
                                        <label><h5>发布时间</h5></label><br/>
                                    </div>

                                    <div class="form-group" id="gonggaoAuthor">
                                        <label style="text-align: center"><h5>发布人</h5></label><br/>
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

	    //
        function getGonggaoById(id){
            $.ajax({
                url: '../getGonggaoById.do',
                type: 'POST',
                data:{'gonggaoId':id},
                dataType: 'JSON',
                success: function (res) {
                    /*$("#gonggaoAuthor").append("<option value='"+res[j].doctorName+"'>"+res[j].doctorName+"</option>");*/
                    $("#gonggaoTitle").append("<span value='"+res.gonggaoTitle+"' style='font-size: 25px'>"+res.gonggaoTitle+"</span>");
                    $("#gonggaoContent").append("<span value='"+res.gonggaoContent+"' style='font-size: 25px'>"+res.gonggaoContent+"</span>");
                    $("#gonggaoTime").append("<span value='"+res.gonggaoTime+"' style='font-size: 25px'>"+res.gonggaoTime+"</span>");
                    $("#gonggaoAuthor").append("<span value='"+res.gonggaoAuthor+"' style='font-size: 25px'>"+res.gonggaoAuthor+"</span>");
                },
                error: function(res){
                    layer.msg('加载失败');
                }
            });
        }


    </script>

    
    

</body>

</html>
