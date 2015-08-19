<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zformRankSalaryList" checkbox="true" fitColumns="false" title="薪级工资数据库" actionUrl="zformRankSalaryController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="年度"  field="year"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="岗位类型"  field="jobtype"    queryMode="single" dictionary="jobtype" width="120"></t:dgCol>
   <t:dgCol title="薪级"  field="rank"    queryMode="single" dictionary="rank" width="120"></t:dgCol>
   <t:dgCol title="工资"  field="salary"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zformRankSalaryController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="zformRankSalaryController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zformRankSalaryController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zformRankSalaryController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zformRankSalaryController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/salary/zformRankSalaryList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zformRankSalaryController.do?upload', "zformRankSalaryList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zformRankSalaryController.do?exportXls","zformRankSalaryList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zformRankSalaryController.do?exportXlsByT","zformRankSalaryList");
}
 </script>