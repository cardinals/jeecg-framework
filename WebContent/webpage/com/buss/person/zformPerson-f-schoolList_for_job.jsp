<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>查询条件</title>
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
  
  function ExportJobStatDetails(){	
	  window.location.href = "zformPersonController.do?exportJobStatDetails";
	}
 </script>
</head>

<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zformPersonController.do?doExportJobStatDetails">		
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 学校名称: </label></td>
				<td class="value">
					<t:dictSelect field="schoolCode" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false" title="所在学校"></t:dictSelect> 
					<label class="Validform_label" style="display: none;">学校名称</label></td>
			
				<td align="right"><label class="Validform_label">学年度</label></td>
				<td align="left">
					<input name="schoolYear" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">学年度</label></td>
			</tr>
		</table>
</t:formvalid>

<script src="webpage/com/buss/person/zformPerson.js"></script>