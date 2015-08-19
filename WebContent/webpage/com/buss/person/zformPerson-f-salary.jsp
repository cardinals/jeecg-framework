<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>工资变动</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
<script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
</head>
<body style="overflow-x: hidden;">
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zformPersonController.do?doAddSalary">
		<input id="id" name="id" type="hidden" value="${zformPersonPage.id }">
		<input id="seqNo" name="seqNo" type="hidden" value="${zformPersonPage.seqNo }">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">学年度</label></td>
				<td class="value">
					<input id="year" name="year" type="text" style="width: 150px" class="inputxt"> 
					<span class="Validform_checktip"></span> 
					<label class="Validform_label" style="display: none;">学年度</label>
				</td>
				<td align="right"><label class="Validform_label">薪资变动原因</label></td>
				<td class="value">
					<input id="changeReason" name="changeReason" type="text" style="width: 150px" class="inputxt"> 
					<span class="Validform_checktip"></span> 
					<label class="Validform_label" style="display: none;">薪资变动原因</label>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">变动生效日期</label></td>
				<td class="value"><input id="effectiveDate" name="effectiveDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"> 
					<span class="Validform_checktip"></span> 
					<label class="Validform_label" style="display: none;">变动生效日期</label>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">新岗位名称 </label></td>
				<td class="value">
					<t:dictSelect field="newJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="岗位名称"></t:dictSelect> 
					<label class="Validform_label" style="display: none;">新聘岗位名称</label>
				</td>
				<td align="right"><label class="Validform_label"> 新岗位名称扩充</label></td>
				<td class="value"><input id="newJobExtra" name="newJobExtra" type="text" style="width: 150px" class="inputxt"> 
					<span class="Validform_checktip"></span> 
					<label class="Validform_label"style="display: none;">新岗位名称扩充</label>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">新岗位类型</label></td>
				<td class="value"><t:dictSelect field="newJobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="岗位类型"></t:dictSelect> 
					<label class="Validform_label" style="display: none;">新岗位类型</label>
				</td>
				<td align="right"><label class="Validform_label">新岗位等级 </label></td>
				<td class="value"><t:dictSelect field="newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="岗位等级"></t:dictSelect> 
					<label class="Validform_label" style="display: none;">新岗位等级</label>
				</td>				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">新薪级</label></td>
				<td class="value"><t:dictSelect field="newRankLevel" type="list" typeGroupCode="rank" defaultVal="" hasLabel="false" title="薪级"></t:dictSelect> 
					<label class="Validform_label" style="display: none;">新薪级</label>
				</td>
				<td align="right"><label class="Validform_label">备注</label></td>
				<td class="value">
					<input id="comments" name="comments" type="text" style="width: 150px" class="inputxt"> 
					<span class="Validform_checktip"></span> 
					<label class="Validform_label" style="display: none;">备注</label>
				</td>				
			</tr>
		</table>
	</t:formvalid>
</body>
<script src="webpage/com/buss/person/zformPerson.js"></script>