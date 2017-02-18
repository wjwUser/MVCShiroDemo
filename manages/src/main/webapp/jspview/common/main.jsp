<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jspview/common/include.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Headsds -->
<head>
<meta charset="utf-8" />
<title>管理平台</title>
<link rel='stylesheet'
	href='${ctx}/resource/bootstrap/css/bootstrap.css'>
<link rel='stylesheet'
	href='${ctx}/resource/zTree/css/zTreeStyle/zTreeStyle.css'>
<!-- easyUI -->
<link rel="stylesheet" type="text/css" href="${ctx}/resource/jquery-easyui-1.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/resource/jquery-easyui-1.5/themes/icon.css">

</head>
<script type="text/javascript"
	src="${ctx}/resource/bootstrap/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${ctx}/resource/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${ctx}/resource/zTree/js/jquery.ztree.core.js"></script>
<!-- 自定义 bootstrap加载组件 --已禁用-->
<%-- <script type="text/javascript"
	src="${ctx}/resource/js/common/bootstrap-table/bootStrapTableCommon.js"></script> --%>
<!-- easyUI -->
<script type="text/javascript" src="${ctx}/resource/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<!-- jsUUID生成器 -->
<script type="text/javascript"
	src="${ctx}/resource/js/common/UUID.js"></script>
<!-- jqGrid -->
<script src="${ctx}/resource/jqgrid_5.1.1/js/i18n/grid.locale-cn.js"
	type="application/javascript"></script>
<script src="${ctx}/resource/jqgrid_5.1.1/js/jquery.jqGrid.min.js"
	type="application/javascript"></script>
<body>
	<div class="container" style="width: 100%">
		<div class="">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">后台系统</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>
								注册</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
								登录</a></li>
					</ul>
				</div>
			</nav>
		</div>

		<div class="col-md-2" style="height: 100%">
			<jsp:include page="/jspview/common/ztree/ZtreeMenu.jsp"></jsp:include>
		</div>

		<div class="col-md-10">
			<sitemesh:write property='body' />
		</div>

	</div>
</body>

</html>
