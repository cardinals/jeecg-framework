<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>人员基本信息数据库</title>
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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zformPersonController.do?doTransferInternal">
		<input id="id" name="id" type="hidden" value="${zformPersonPage.id }">
		<input id="seqNo" name="seqNo" type="hidden" value="${zformPersonPage.seqNo }">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 调往学校名称: </label></td>
				<td class="value"><t:dictSelect field="toSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false" title="学校名称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">调往学校名称</label></td>
				<td align="right"><label class="Validform_label"> 调动原因: </label></td>
				<td class="value"><t:dictSelect field="transferReason" type="list" typeGroupCode="trans_r" defaultVal="" hasLabel="false" title="调动原因"></t:dictSelect> <label class="Validform_label"
					style="display: none;">调动原因</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 原单位止薪日期</label></td>
				<td class="value"><input id="salaryEndDate" name="salaryEndDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">原单位止薪日期</label></td>
				<td align="right"><label class="Validform_label"> 是否有组织任命: </label></td>
				<td class="value"><t:dictSelect field="nominate" type="list" typeGroupCode="yesorno" defaultVal="" hasLabel="false" title="组织任命"></t:dictSelect> <label class="Validform_label"
					style="display: none;">组织任命</label></td>
			</tr>

			<tr>
				<td align="right"><label class="Validform_label"> 调出前职称: </label></td>
				<td class="value"><t:dictSelect field="beforeTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="调出前职称"></t:dictSelect> <label class="Validform_label"
					style="display: none;">调出前职称</label></td>
				<td align="right"><label class="Validform_label"> 备注</label></td>
				<td class="value"><input id="comments" name="comments" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">备注</label></td>
			</tr>
		</table>
	</t:formvalid>
</body>
<script src="webpage/com/buss/person/zformPerson.js"></script>