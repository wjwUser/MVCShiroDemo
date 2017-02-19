<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jspview/common/include.jsp"%>
<!DOCTYPE html>
<html>

<body>
	<div class="middle">
		<table id="gridTableRole">
		</table>
		<div id="gridPagerRole" style="margin-bottom: 0px;"></div>
	</div>


	<script type="text/javascript">
		$(function(){
			pageInit();
		});
	
		function pageInit() {
			$("#gridTableRole").jqGrid({
				url : "${ctx}/role/role.do",
				// datatype: "local",
				datatype : "json",
				styleUI : 'Bootstrap',
				width : $(".middle").width() * 0.99,
				multiselect : true,
				rownumbers : true,
				mtype : "POST",
				colNames : [ '角色ID', '角色名','创建时间','修改时间','备注' ],
				colModel : [ {
					name : 'id',
					index : 'id',
					sortable : false,
					width : "50px",
					hidden : true
				}, {
					name : 'name',
					index : 'name',
					sortable : false,
					width : "50px"
				}, {
					name : 'create_time',
					index : 'create_time',
					sortable : false,
					width : "50px"
				},{
					name : 'update_time',
					index : 'update_time',
					sortable : false,
					width : "50px"
				},{
					name : 'remark',
					index : 'remarks',
					sortable : false,
					width : "50px"
				},

				],
				sortname : 'id',
				sortorder : 'desc',
				viewrecords : true,
				rowNum : 10,
				rowList : [ 10, 20, 30 ],
				pager : "#gridPagerRole",
				/* caption: "用户信息表", */
				jsonReader : {
					root : "list",
					page : 'pageNum', // 页码
					total : 'pages', // 总页数
					records : 'total', // 总记录数
					repeatitems : false,
					cell : "row",
					id : "id",
					userdata : "userdata",
					subgrid : {
						root : "rows",
						repeatitems : true,
						cell : "cell"
					},

				}
			}).navGrid('#pager2', {
				edit : false,
				add : false,
				del : false
			});
		}
	</script>
</body>

</html>
