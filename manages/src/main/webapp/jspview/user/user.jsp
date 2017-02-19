<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jspview/common/include.jsp"%>
<!DOCTYPE html>
<html>

<body>
	
	<div class="col-md-10" style="margin-left:-14px;margin-bottom:10px;">
		<button style="height:20px;" type="button" onclick="showAddUserModal()">新增用户</button>
		<button style="height:20px;" type="button" onclick="showAddUserModal()">修改用户</button>
		<button style="height:20px;" type="button" onclick="showAddUserModal()">删除用户</button>
	</div>
	
	
	<div class="modal fade" id="addUser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="border-bottom: 1px solid #FFFFFF;">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增用户</h4>

				</div>
				<hr />
				<form id="insertForm" action="#">
					<div class="modal-body">
						<div class="row">
							<div class="col-sm-3">
								<label style="top: 0vh;">用户名:</label>
							</div>
							<div class="col-sm-9">
								<input id="insert_name" name="insert_name" type="text"
									class="form-control form-file" placeholder="角色1"> <span
									id="insertSpan_name"></span>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label style="top: 0vh;">备注:</label>
							</div>
							<div class="col-sm-9">
								<input id="insert_remark" name="insert_remark" type="text"
									class="form-control form-file"> <span
									id="insertSpan_remark"></span>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label style="top: 0vh;">权限:</label>
							</div>
							<div class="col-sm-9">
								<select id="roleselect" name="roleselect"
									class="form-control form-file" onclick="">

								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label style="top: 0vh;">权限:</label>
							</div>
							<div class="col-sm-9">
								<select id="roleselect" name="roleselect"
									class="form-control form-file" onclick="">

								</select>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
							onclick="insertSubmit()">确定</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>



	<div class="middle">
		<table id="gridTableUser">
		</table>
		<div id="gridPagerUser" style="margin-bottom: 0px;"></div>
	</div>


	<script type="text/javascript">
		$(function() {
			pageInit();
		});
		
		function pageInit() {
			$("#gridTableUser").jqGrid({
				url : "${ctx}/user/user.do",
				// datatype: "local",
				datatype : "json",
				styleUI : 'Bootstrap',
				width : $(".middle").width() * 0.99,
				multiselect : true,
				rownumbers : true,
				mtype : "POST",
				colNames : [ '用户ID', '用户名', '创建时间', '修改时间', '备注' ],
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
				}, {
					name : 'update_time',
					index : 'update_time',
					sortable : false,
					width : "50px"
				}, {
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
				pager : "#gridPagerUser",
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
		
		function showAddUserModal(){
			$('#addUser').modal('show');
		}
	</script>
</body>

</html>
