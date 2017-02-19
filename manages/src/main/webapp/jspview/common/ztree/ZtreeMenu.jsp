<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jspview/common/include.jsp"%>

<html>
<body>
	<p>导航菜单</p>
	<ul id="ZtreeContaint" class="ztree">

	</ul>
</body>
<script type="text/javascript">
	var zNodes;
	
	//加载菜单
	var zTreeObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {
		async: {
			enable: true, //true开启异步加载的模式
			type: "get",
			dataFilter: ajaxDataFilter,
			url: "${ctx}/menu/view.do",//后台取值的地址
			otherParam: {}
		},
		callback: {
			onClick:zTreeOnClick
		},
		data: {
			key: {
				url: "#"
			},
			simpleData: {
				enable: false,//不使用简单模式数据结构
			}
		}
	};
	//预处理函数
	function ajaxDataFilter(treeId, parentNode, responseData){
		
	}
	//点击触发的函数(跳转函数)
	function zTreeOnClick(event, treeId, treeNod){
		if(treeNod.url==null||$.trim(treeNod.url)==""){
			return false;
		}
		window.location.href="${ctx}/menu/control.menu?"+"id="+treeNod.id;
		return true;
	}
	
	function ExpandNode(id){
 		if(id!=null||id!=""){
 			var node = zTreeObj.getNodeByParam("id",id);  
 	        zTreeObj.expandNode(node, true);//指定选中ID节点展开  
 	        return true;
 		}
        return false;
	}
	
	$.ajax({
		type : "POST",
		url : "${ctx}/menu/view.do",
		data : {

		},
		async : false,
		dataType : "json",
		success : function(data) {
			zNodes = data;
		}
	});

	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($("#ZtreeContaint"), setting, zNodes);
		ExpandNode("${menuPid}");
	});
</script>
</html>
