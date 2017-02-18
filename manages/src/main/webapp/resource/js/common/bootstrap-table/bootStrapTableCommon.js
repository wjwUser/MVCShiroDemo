
/**
 * 头部行数,即全局行数
 */
var headRow;

/**
 * 页数
 */
var page;

/**
 * 条数
 */
var TotalNum;


/**
 * 构建表单参数
 */
function ConfigueTable(id,col,Rowdata){
	//获取表单对象
	var table=$("#"+id);
	var tr=createTrTableHead(col,Rowdata);
	table.append(tr);
	return true;
	
}

/**
 * 返回生成好的tr
 */
function createTrTableHead(col,Rowdata){
	//生成行序列的唯一标识
	var id = new UUID();
	
	var tr=document.createElement("tr");
	tr.id=id+"table"+"tr";
	
	//构建tr
	for(var i=0;i<col;i++){
		var td=document.createElement("td");
		td.id=id+"table"+"td"+i;
		console.log(Rowdata);
		td.value=Rowdata[i];
		tr.appendChild(td);
	}
	return tr;
}





