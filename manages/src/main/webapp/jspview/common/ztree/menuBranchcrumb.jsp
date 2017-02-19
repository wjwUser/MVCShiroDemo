<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jspview/common/include.jsp"%>

<html>
<body>
	<ol id="crumb" class="breadcrumb">
		
	</ol>
</body>
<script type="text/javascript">
	$(function() {
		//清空ol
		del();
		
		$.ajax({
			type : "POST",
			url : "${ctx}/menu/createbranch",
			data : {
				id : "${menuId}",
			},
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.status == "success") {

					var obj = data.obj.obj;
					var depth_path = obj.depth_path;
					var result = depth_path.split(",");
					//Ztree对象
					var treeObj = $.fn.zTree.getZTreeObj("ZtreeContaint");
					//保存面包屑的集合
					var arr = new Array();
					//获取根节点节点
					var nodes = treeObj.getNodes();
					//节点数据集合
					var nodesList=new Array();
					getAlllNodes(nodes[0],nodesList);
					
					for (var i = 0; i < result.length; i++) {
						for(var j=0;j<nodesList.length;j++){
							if(nodesList[j].id==result[i]){
								arr.push(nodesList[j]);
							}
						}
					}
					createCrumb(arr);
				}
			}
		});
	});
	
	function getAlllNodes(nodes,nodesList){
		if(nodes.children!=null){
			for(var i=0;i<nodes.children.length;i++){
				getAlllNodes(nodes.children[i],nodesList);
			}
		}
		nodesList.push(nodes);
	}
	
	/*
	*渲染函数
	*/
	function createCrumb(arr) {
		var crumb = $("#crumb");
		for (var i = 0; i < arr.length; i++) {
			var str="";
			str += "<li>";
			str += "<a href='#'>";
			//str += "${ctx}/menu/control.menu?"; 
			//str += "id=" + arr[i].id;
			str+=arr[i].name;
			str += "</a>"; 
			str += "</li>";
			crumb.append(str);
		}
		
	}
	/*
	*删除节点Arr的函数
	*/
	function del() {
		var s = document.getElementById('crumb');
		var t = s.childNodes.length;
		if(t<=0){
			return false;
		}
		for (var i=0;i<t.length;i++) {
			s.removeChild(s.childNodes[i]);
		}
	}
</script>
</html>
