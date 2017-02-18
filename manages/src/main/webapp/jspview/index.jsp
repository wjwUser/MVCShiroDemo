<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jspview/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>后台登录系统</title>
<link rel='stylesheet' href="${ctx}/resource/css/index.css" />
<link rel='stylesheet'
	href='${ctx}/resource/bootstrap/css/bootstrap.css'>
<style type="text/css">
body {
	background-image: url(${ctx}/resource/images/timg.jpg);
	background-repeat: repeat-x;
}
</style>
</head>

<script type="text/javascript"
	src="${ctx}/resource/bootstrap/js/jquery-1.9.1.min.js">
	
</script>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<form class="form-horizontal">
					<span class="heading">用户登录</span>
					<div class="form-group">
						<input id="name" type="text" class="form-control" id="inputEmail3"
							placeholder="用户名或电子邮件"> <i class="fa fa-user"></i>
						<span id="nameView" style="color: red"></span>
					</div>
					<div class="form-group help">
						<input id="password" type="password" class="form-control" id="inputPassword3"
							placeholder="密　码"> <i class="fa fa-lock"></i> <a href="#"
							class="fa fa-question-circle"></a>
						<span id="passwordView" style="color: red"></span>
					</div>
					<div class="form-group">
						<div class="main-checkbox">
							<input type="checkbox" value="None" id="checkbox1" name="check" />
							<label for="checkbox1"></label>
						</div>
						<span class="text">Remember me</span>
						<button type="button" class="btn btn-default" onclick="loginDefind()">登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	function loginDefind() {
		$.ajax({
			url : "${ctx}/login/login",
			type : "post",
			dataType : "json",
			data : {
				name : $("#name").val(),
				password : $("#password").val(),
			},
			success : function(data) {
				if (data.status == "success") {
					//跳转到首页
					//alert("1");
					window.location.href="${ctx}/jspview/user/user.jsp"; 
				}
				if(data.status  == "error"){
					var obj=data.obj;
					//alert(obj.obj);
				}
			},
			error : function(data) {

			}
		});
	}
</script>
</html>
