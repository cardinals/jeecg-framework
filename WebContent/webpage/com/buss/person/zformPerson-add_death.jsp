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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zformPersonController.do?doAdd">
		<input id="id" name="id" type="hidden" value="${zformPersonPage.id }">
		<input id="seqNo" name="seqNo" type="hidden" value="${zformPersonPage.seqNo }">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">人员编号:</label></td>
				<td class="value"><input id="code" name="code" type="text" style="width: 150px" class="inputxt" datatype="*"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">人员编号</label></td>
				<td align="right"><label class="Validform_label">人员姓名:</label></td>
				<td class="value"><input id="name" name="name" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">人员姓名</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">性别:</label></td>
				<td class="value"><t:dictSelect field="sex" type="list" typeGroupCode="sex" hasLabel="false" title="性别"></t:dictSelect> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">性别</label></td>
				<td align="right"><label class="Validform_label">出生日期:</label></td>
				<td class="value"><input id="birthday" name="birthday" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">出生日期</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">年龄:</label></td>
				<td class="value"><input id="age" name="age" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">年龄</label></td>
				<td align="right"><label class="Validform_label">身份证号码:</label></td>
				<td class="value"><input id="photoIdNo" name="photoIdNo" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">身份证号码</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">民族:</label></td>
				<td class="value"><t:dictSelect field="nationality" type="list" typeGroupCode="national" hasLabel="false" title="民族"></t:dictSelect> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">民族</label></td>
				<td align="right"><label class="Validform_label">政治面貌:</label></td>
				<td class="value"><t:dictSelect field="socialStatus" type="list" typeGroupCode="social_s" hasLabel="false" title="政治面貌"></t:dictSelect> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">政治面貌</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">参加工作时间:</label></td>
				<td class="value"><input id="startWorkDate" name="startWorkDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">参加工作时间</label></td>
				<td align="right"><label class="Validform_label">学历:</label></td>
				<td class="value"><t:dictSelect field="eduBackground" type="list" typeGroupCode="edu_back" hasLabel="false" title="学历"></t:dictSelect> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">学历</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">学历补充:</label></td>
				<td class="value"><input id="eduExtra" name="eduExtra" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">学历补充</label></td>
				<td align="right"><label class="Validform_label">学位:</label></td>
				<td class="value"><t:dictSelect field="degree" type="list" typeGroupCode="degree" hasLabel="false" title="学位"></t:dictSelect> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">学位</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">专业:</label></td>
				<td class="value"><input id="major" name="major" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">专业</label></td>
				<td align="right"><label class="Validform_label">毕业时间:</label></td>
				<td class="value"><input id="graduateDate" name="graduateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">毕业时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">毕业学校:</label></td>
				<td class="value"><input id="graduateSchool" name="graduateSchool" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">毕业学校</label></td>
				<td align="right"><label class="Validform_label">联系电话:</label></td>
				<td class="value"><input id="contactNo" name="contactNo" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">联系电话</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">家庭住址:</label></td>
				<td class="value"><input id="homeAddress" name="homeAddress" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">家庭住址</label></td>
				<td align="right"><label class="Validform_label">进入行业方式:</label></td>
				<td class="value"><input id="enterApproach" name="enterApproach" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">进入行业方式</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">进入行业时间:</label></td>
				<td class="value"><input id="enterDate" name="enterDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">进入行业时间</label></td>
				<td align="right"><label class="Validform_label">初级职称取得时间:</label></td>
				<td class="value"><input id="juniorTitleDate" name="juniorTitleDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()">
					<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">初级职称取得时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">中级职称取得时间:</label></td>
				<td class="value"><input id="secondaryTitleDate" name="secondaryTitleDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()">
					<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">中级职称取得时间</label></td>
				<td align="right"><label class="Validform_label">高级职称取得时间:</label></td>
				<td class="value"><input id="seniorTitleDate" name="seniorTitleDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()">
					<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">高级职称取得时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">照片:</label></td>
				<td class="value"><input type="hidden" id="photo" name="photo" /> <a target="_blank" id="photo_href">暂时未上传文件</a> <input class="ui-button" type="button" value="上传附件"
					onclick="commonUpload(photoCallback)" /> <script type="text/javascript">
						function photoCallback(url,name){
							$("#photo_href").attr('href',url).html('下载');
							$("#photo").val(url);
						}
						</script> <span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">照片</label></td>
				<td align="right"><label class="Validform_label">备注:</label></td>
				<td class="value"><input id="comments" name="comments" type="text" style="width: 150px" class="inputxt"> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">备注</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">目前状态:</label></td>
				<td class="value"><t:dictSelect field="currentStatus" type="list" typeGroupCode="status" hasLabel="false" title="目前状态"></t:dictSelect> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">目前状态</label></td>
			</tr>
		</table>
		<div style="width: auto;height: 200px;">
			<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
			<div style="width:800px;height:1px;"></div>
			<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				<t:tab href="zformPersonController.do?zformPersonDeathList&code=${zformPersonPage.code}" icon="icon-search" title="死亡" id="zformPersonDeath"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonStatusList&code=${zformPersonPage.code}" icon="icon-search" title="状态变动" id="zformPersonStatus"></t:tab>
			</t:tabs>
		</div>
	</t:formvalid>
	<!-- 添加 附表明细 模版 -->
	<table style="display:none">				
		<tbody id="add_zformPersonDeath_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><input name="zformPersonDeathList[#index#].deathDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">死亡日期</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].auditDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">死亡审批日期</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].deathReason" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">死亡原因</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].funeralExp" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">丧葬费</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].basicSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">基本工资</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].stateIncomeAvg" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">上年度人均支配收入</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].pension" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">抚恤金合计</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].funeralExpTotal" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">丧抚费总金额</label></td>
				<td align="left"><input name="zformPersonDeathList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</tbody>		
		<tbody id="add_zformPersonStatus_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><t:dictSelect field="zformPersonStatusList[#index#].prevStatus" type="list" typeGroupCode="status" defaultVal="" hasLabel="false" title="变更前状态"></t:dictSelect> <label
					class="Validform_label" style="display: none;">变更前状态</label></td>
				<td align="left"><t:dictSelect field="zformPersonStatusList[#index#].afterStatus" type="list" typeGroupCode="status" defaultVal="" hasLabel="false" title="变更后状态"></t:dictSelect> <label
					class="Validform_label" style="display: none;">变更后状态</label></td>
				<td align="left"><input name="zformPersonStatusList[#index#].stateChangeReason" maxlength="32" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">变更原因</label></td>
				<td align="left"><input name="zformPersonStatusList[#index#].statusChangeDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">变更日期</label></td>
			</tr>
		</tbody>
	</table>
</body>
<script src="webpage/com/buss/person/zformPerson.js"></script>