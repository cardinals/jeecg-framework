<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>年度考核</title>
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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zformPersonController.do?doInputExam">
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
				<td align="right"><label class="Validform_label">量化考核分数</label></td>
				<td class="value">
					<input id="score" name="score" type="text" style="width: 150px" class="inputxt"> 
					<span class="Validform_checktip"></span> 
					<label class="Validform_label" style="display: none;">量化考核分数</label>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">民主测评结果</label></td>
				<td class="value">
					<input id="voteReview" name="voteReview" type="text" style="width: 150px" class="inputxt"> 
					<span class="Validform_checktip"></span> 
					<label class="Validform_label" style="display: none;">民主测评结果</label>
				</td>
				<td align="right"><label class="Validform_label">最终考核结果</label></td>
				<td class="value">
					<t:dictSelect field="finalResult" type="list" typeGroupCode="exam_r" defaultVal="" hasLabel="false" title="最终考核结果"></t:dictSelect> 
					<label class="Validform_label" style="display: none;">最终考核结果</label>
				</td>
			</tr>
			<tr>
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