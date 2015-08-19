<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:1px;">
		<t:datagrid name="zformPersonList" checkbox="true" fitColumns="false" title="人员工资变动" actionUrl="zformPersonController.do?salarydatagrid&status=1" idField="id" fit="true" queryMode="group">
			<t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="人员编号" field="code" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="人员姓名" field="extra1" width="120"></t:dgCol>
			<t:dgCol title="岗位类型" field="currentJobType" width="120"></t:dgCol>
			<t:dgCol title="岗位名称" field="currentJob" width="120"></t:dgCol>
			<t:dgCol title="岗位等级" field="currentJobLevel" width="120"></t:dgCol>
			<t:dgCol title="岗位工资" field="jobSalary" width="120"></t:dgCol>
			<t:dgCol title="薪级" field="rank" width="120"></t:dgCol>
			<t:dgCol title="薪级工资" field="rankSalary" width="120"></t:dgCol>
			<t:dgCol title="百分之十" field="extraSalary" width="120"></t:dgCol>
			<t:dgCol title="工资总数" field="extra4" width="120"></t:dgCol>
			<t:dgToolBar title="编辑" icon="icon-edit" url="zformPersonController.do?goUpdate&status=12&code={code}" funname="update"></t:dgToolBar>
			<t:dgToolBar title="查看" icon="icon-search" url="zformPersonController.do?goUpdate&status=12&code={code}" funname="detail"></t:dgToolBar>
			<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
			<t:dgToolBar title="个人工资变动台帐" icon="icon-putout" funname="ExportPersonalResumeWithSalary"></t:dgToolBar>
			<t:dgToolBar title="工资变动审批表" icon="icon-putout" funname="ExportSalaryChangeAudit"></t:dgToolBar>
			<t:dgToolBar title="岗位聘用工资变动审批表" icon="icon-putout" funname="ExportJobChangeAndSalaryChangeAudit"></t:dgToolBar>
			<t:dgToolBar title="职称变动工资变动审批表" icon="icon-putout" funname="ExportTitleChangeAndSalaryChangeAudit"></t:dgToolBar>			
			<t:dgToolBar title="添加工资变动" icon="pictures" url="zformPersonController.do?goAddSalary&code={code}" funname="update"></t:dgToolBar>
		</t:datagrid>
	</div>
</div>
<script src="webpage/com/buss/person/zformPersonList.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zformPersonListtb").find("input[name='birthday']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zformPersonListtb").find("input[name='startWorkDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zformPersonListtb").find("input[name='graduateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zformPersonListtb").find("input[name='enterDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zformPersonListtb").find("input[name='juniorTitleDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zformPersonListtb").find("input[name='secondaryTitleDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zformPersonListtb").find("input[name='seniorTitleDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 	//自定义按钮-sql增强-转入退休审核
 	function doTo_RetireAudit(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择转入退休审核项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zformPersonController.do?upload', "zformPersonList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zformPersonController.do?exportXls","zformPersonList");
}

function ExportPersonalResumeWithSalary(title, url, id) {
	var rowData = $('#' + id).datagrid('getSelected');
	if (!rowData) {
		tip('请选择生成个人历年工资台账的人员');
		return;
	}		
	JeecgExcelExport("zformPersonController.do?exportPersonalResumeWithSalary&id="+rowData['id']+"&code="+rowData['code'], "zformPersonList");		
}

function ExportSalaryChangeAudit(title, url, id){
	var rowData = $('#' + id).datagrid('getSelected');
	if (!rowData) {
		tip('请选择生成工资变动审批表的人员');
		return;
	}		
	JeecgExcelExport("zformPersonController.do?exportSalaryChangeAudit&id="+rowData['id']+"&code="+rowData['code'], "zformPersonList");	
}

function ExportJobChangeAndSalaryChangeAudit(title, url, id){
	var rowData = $('#' + id).datagrid('getSelected');
	if (!rowData) {
		tip('请选择生成岗位聘用工资变动审批表的人员');
		return;
	}		
	JeecgExcelExport("zformPersonController.do?exportJobChangeAndSalaryChangeAudit&id="+rowData['id']+"&code="+rowData['code'], "zformPersonList");	
}

function ExportTitleChangeAndSalaryChangeAudit(title, url, id){
	var rowData = $('#' + id).datagrid('getSelected');
	if (!rowData) {
		tip('请选择生成职称变动工资变动审批表的人员');
		return;
	}		
	JeecgExcelExport("zformPersonController.do?exportTitleChangeAndSalaryChangeAudit&id="+rowData['id']+"&code="+rowData['code'], "zformPersonList");	
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zformPersonController.do?exportXlsByT","zformPersonList");
}
 </script>