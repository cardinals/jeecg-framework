<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:1px;">
		<t:datagrid name="zformJobSalaryList" checkbox="true" fitColumns="false" title="岗位工资数据库" actionUrl="zformJobSalaryController.do?datagrid" idField="id" fit="true" queryMode="group">
			<t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="年度" field="year" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="岗位类型" field="jobType" queryMode="single" dictionary="jobtype" width="120"></t:dgCol>
			<t:dgCol title="岗位等级" field="jobLevel" queryMode="single" dictionary="joblevel" width="120"></t:dgCol>
			<t:dgCol title="岗位名称" field="job" queryMode="single" dictionary="job" width="120"></t:dgCol>
			<t:dgCol title="岗位名称扩充" field="jobExtra" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="工资" field="salary" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
			<t:dgDelOpt title="删除" url="zformJobSalaryController.do?doDel&id={id}" />
			<t:dgToolBar title="录入" icon="icon-add" url="zformJobSalaryController.do?goAdd" funname="add"></t:dgToolBar>
			<t:dgToolBar title="编辑" icon="icon-edit" url="zformJobSalaryController.do?goUpdate" funname="update"></t:dgToolBar>
			<t:dgToolBar title="批量删除" icon="icon-remove" url="zformJobSalaryController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
			<t:dgToolBar title="查看" icon="icon-search" url="zformJobSalaryController.do?goUpdate" funname="detail"></t:dgToolBar>
			<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
			<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
			<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
		</t:datagrid>
	</div>
</div>
<script src="webpage/com/buss/salary/zformJobSalaryList.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zformJobSalaryController.do?upload', "zformJobSalaryList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zformJobSalaryController.do?exportXls","zformJobSalaryList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zformJobSalaryController.do?exportXlsByT","zformJobSalaryList");
}
 </script>