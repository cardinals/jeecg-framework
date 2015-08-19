<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:1px;">
		<t:datagrid name="zformSchoolList" checkbox="true" fitColumns="false" title="单位基本信息表" actionUrl="zformSchoolController.do?datagrid" idField="id" fit="true" queryMode="group">
			<t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="单位编码" field="code" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="单位名称" field="name" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="邮政编码" field="zipcode" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="单位地址" field="address" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="值班电话" field="contactNo" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="办公室电话" field="officeNo" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="校长室电话" field="masterOfficeNo" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="校长姓名" field="masterName" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="校长宅电" field="masterHomeNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="校长手机号" field="masterCellphoneNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="一年级班数" field="grade1ClassNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="一年级学生数" field="grade1StudentNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="一年级教师数" field="grade1TeacherNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="二年级班数" field="grade2ClassNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="二年级学生数" field="grade2StudentNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="二年级教师数" field="grade2TeacherNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="三年级班数" field="grade3ClassNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="三年级学生数" field="grade3StudentNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="三年级教师数" field="grade3TeacherNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="四年级班数" field="grade4ClassNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="四年级学生数" field="grade4StudentNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="四年级教师数" field="grade4TeacherNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="五年级班数" field="grade5ClassNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="五年级学生数" field="grade5StudentNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="五年级教师数" field="grade5TeacherNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="六年级班数" field="grade6ClassNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="六年级学生数" field="grade6StudentNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="六年级教师数" field="grade6TeacherNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="食堂用餐教职工数" field="canteenEmployeeNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="食堂用餐学生数" field="canteenStudentNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="住宿生数" field="boarderNo" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="离休职工人数" field="retireEmployeeNo1" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="退休职工人数" field="retireEmployeeNo2" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="人事干部姓名" field="personnelName" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="人事干部职务" field="personnelDuty" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="人事干部手机号" field="personnelCellphone" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="系统管理员姓名" field="adminName" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="系统管理员职务" field="adminDuty" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="系统管理员手机号" field="adminCellphone" hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="组织机构代码" field="organizationCode" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="社保登记证号" field="ssnNo" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="档案所在地" field="archiveAddress" queryMode="single" dictionary="archive" width="120"></t:dgCol>
			<t:dgCol title="网址" field="url" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="所在乡镇街道" field="addressExtra" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="单位分类" field="category" queryMode="single" dictionary="danwei_fl" width="120"></t:dgCol>
			<t:dgCol title="单位类型" field="type" queryMode="single" dictionary="danwei_lx" width="120"></t:dgCol>
			<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
			<t:dgDelOpt title="删除" url="zformSchoolController.do?doDel&id={id}" />
			<t:dgToolBar title="录入" icon="icon-add" url="zformSchoolController.do?goAdd" funname="add"></t:dgToolBar>
			<t:dgToolBar title="编辑" icon="icon-edit" url="zformSchoolController.do?goUpdate" funname="update"></t:dgToolBar>
			<t:dgToolBar title="批量删除" icon="icon-remove" url="zformSchoolController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
			<t:dgToolBar title="查看" icon="icon-search" url="zformSchoolController.do?goUpdate" funname="detail"></t:dgToolBar>			
			<t:dgToolBar title="导出学校信息" icon="icon-putout" funname="ExportXls"></t:dgToolBar>						
		</t:datagrid>
	</div>
</div>
<script src="webpage/com/buss/school/zformSchoolList.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zformSchoolController.do?upload', "zformSchoolList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zformSchoolController.do?exportXls","zformSchoolList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zformSchoolController.do?exportXlsByT","zformSchoolList");
}

 </script>