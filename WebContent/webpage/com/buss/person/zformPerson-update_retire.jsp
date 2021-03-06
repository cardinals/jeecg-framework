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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zformPersonController.do?doUpdate&updateStatus=2">
		<input id="id" name="id" type="hidden" value="${zformPersonPage.id }">
		<input id="seqNo" name="seqNo" type="hidden" value="${zformPersonPage.seqNo }">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">人员编号:</label></td>
				<td class="value"><input id="code" name="code" type="text" readonly="readonly" style="width: 150px" class="inputxt" datatype="*" value='${zformPersonPage.code}'> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">人员编号</label></td>
				<td align="right"><label class="Validform_label">人员姓名:</label></td>
				<td class="value"><input id="name" name="name" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.name}'> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">人员姓名</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">性别:</label></td>
				<td class="value"><t:dictSelect field="sex" type="list" typeGroupCode="sex" defaultVal="${zformPersonPage.sex}" hasLabel="false" title="性别"></t:dictSelect> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">性别</label></td>
				<td align="right"><label class="Validform_label">出生日期:</label></td>
				<td class="value"><input id="birthday" name="birthday" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
					value='<fmt:formatDate value='${zformPersonPage.birthday}' type="date" pattern="yyyy-MM-dd"/>'> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">出生日期</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">年龄:</label></td>
				<td class="value"><input id="age" name="age" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.age}'> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">年龄</label></td>
				<td align="right"><label class="Validform_label">身份证号码:</label></td>
				<td class="value"><input id="photoIdNo" name="photoIdNo" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.photoIdNo}'> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">身份证号码</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">民族:</label></td>
				<td class="value"><t:dictSelect field="nationality" type="list" typeGroupCode="national" defaultVal="${zformPersonPage.nationality}" hasLabel="false" title="民族"></t:dictSelect> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">民族</label></td>
				<td align="right"><label class="Validform_label">政治面貌:</label></td>
				<td class="value"><t:dictSelect field="socialStatus" type="list" typeGroupCode="social_s" defaultVal="${zformPersonPage.socialStatus}" hasLabel="false" title="政治面貌"></t:dictSelect> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">政治面貌</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">参加工作时间:</label></td>
				<td class="value"><input id="startWorkDate" name="startWorkDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
					value='<fmt:formatDate value='${zformPersonPage.startWorkDate}' type="date" pattern="yyyy-MM-dd"/>'> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">参加工作时间</label></td>
				<td align="right"><label class="Validform_label">学历:</label></td>
				<td class="value"><t:dictSelect field="eduBackground" type="list" typeGroupCode="edu_back" defaultVal="${zformPersonPage.eduBackground}" hasLabel="false" title="学历"></t:dictSelect> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">学历</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">学历补充:</label></td>
				<td class="value"><input id="eduExtra" name="eduExtra" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.eduExtra}'> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">学历补充</label></td>
				<td align="right"><label class="Validform_label">学位:</label></td>
				<td class="value"><t:dictSelect field="degree" type="list" typeGroupCode="degree" defaultVal="${zformPersonPage.degree}" hasLabel="false" title="学位"></t:dictSelect> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">学位</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">专业:</label></td>
				<td class="value"><input id="major" name="major" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.major}'> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">专业</label></td>
				<td align="right"><label class="Validform_label">毕业时间:</label></td>
				<td class="value"><input id="graduateDate" name="graduateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
					value='<fmt:formatDate value='${zformPersonPage.graduateDate}' type="date" pattern="yyyy-MM-dd"/>'> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">毕业时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">毕业学校:</label></td>
				<td class="value"><input id="graduateSchool" name="graduateSchool" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.graduateSchool}'> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">毕业学校</label></td>
				<td align="right"><label class="Validform_label">联系电话:</label></td>
				<td class="value"><input id="contactNo" name="contactNo" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.contactNo}'> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">联系电话</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">家庭住址:</label></td>
				<td class="value"><input id="homeAddress" name="homeAddress" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.homeAddress}'> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">家庭住址</label></td>
				<td align="right"><label class="Validform_label">进入行业方式:</label></td>
				<td class="value"><input id="enterApproach" name="enterApproach" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.enterApproach}'> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">进入行业方式</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">进入行业时间:</label></td>
				<td class="value"><input id="enterDate" name="enterDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
					value='<fmt:formatDate value='${zformPersonPage.enterDate}' type="date" pattern="yyyy-MM-dd"/>'> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">进入行业时间</label></td>
				<td align="right"><label class="Validform_label">初级职称取得时间:</label></td>
				<td class="value"><input id="juniorTitleDate" name="juniorTitleDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
					value='<fmt:formatDate value='${zformPersonPage.juniorTitleDate}' type="date" pattern="yyyy-MM-dd"/>'> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">初级职称取得时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">中级职称取得时间:</label></td>
				<td class="value"><input id="secondaryTitleDate" name="secondaryTitleDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
					value='<fmt:formatDate value='${zformPersonPage.secondaryTitleDate}' type="date" pattern="yyyy-MM-dd"/>'> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">中级职称取得时间</label></td>
				<td align="right"><label class="Validform_label">高级职称取得时间:</label></td>
				<td class="value"><input id="seniorTitleDate" name="seniorTitleDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
					value='<fmt:formatDate value='${zformPersonPage.seniorTitleDate}' type="date" pattern="yyyy-MM-dd"/>'> <span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">高级职称取得时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">照片:</label></td>
				<td class="value"><input type="hidden" id="photo" name="photo" /> <c:if test="${empty zformPersonPage.photo}">
						<a target="_blank" id="photo_href">暂时未上传文件</a>
					</c:if> <c:if test="${!empty zformPersonPage.photo}">
						<a href="${zformPersonPage.photo}" target="_blank" id="photo_href" href='${zformPersonPage.photo}'>下载</a>
					</c:if> <input class="ui-button" type="button" value="上传附件" onclick="commonUpload(photoCallback)" /> <script type="text/javascript">
						function photoCallback(url,name){
							$("#photo_href").attr('href',url).html('下载');
							$("#photo").val(url);
						}
						</script> <span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">照片</label></td>
				<td align="right"><label class="Validform_label">备注:</label></td>
				<td class="value"><input id="comments" name="comments" type="text" style="width: 150px" class="inputxt" value='${zformPersonPage.comments}'> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">目前状态:</label></td>
				<td class="value"><t:dictSelect field="currentStatus" type="list" typeGroupCode="status" defaultVal="${zformPersonPage.currentStatus}" hasLabel="false" title="目前状态"></t:dictSelect> <span
					class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">目前状态</label></td>
			</tr>
		</table>
		<div style="width: auto;height: 200px;">
			<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
			<div style="width:800px;height:1px;"></div>
			<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">				
				<t:tab href="zformPersonController.do?zformPersonRetireList&code=${zformPersonPage.code}" icon="icon-search" title="退休" id="zformPersonRetire"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonStatusList&code=${zformPersonPage.code}" icon="icon-search" title="状态变动" id="zformPersonStatus"></t:tab>
			</t:tabs>
		</div>
	</t:formvalid>
	<!-- 添加 附表明细 模版 -->
	<table style="display:none">
		<tbody id="add_zformPersonRetire_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><input name="zformPersonRetireList[#index#].retireCardNo" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">退休证号</label></td>
				<td align="left"><t:dictSelect field="zformPersonRetireList[#index#].retireSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false"
						title="退休时单位"></t:dictSelect> <label class="Validform_label" style="display: none;">退休时单位</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].workAge" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">连续工龄</label></td>
				<td align="left"><t:dictSelect field="zformPersonRetireList[#index#].retireJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="退休时岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">退休时岗位</label></td>
				<td align="left"><t:dictSelect field="zformPersonRetireList[#index#].retireJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="退休时岗位级别"></t:dictSelect> <label
					class="Validform_label" style="display: none;">退休时岗位级别</label></td>
				<td align="left"><t:dictSelect field="zformPersonRetireList[#index#].retireRankLevel" type="list" typeGroupCode="rank" defaultVal="" hasLabel="false" title="退休时薪级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">退休时薪级</label></td>
				<td align="left"><t:dictSelect field="zformPersonRetireList[#index#].retireIdentity" type="list" typeGroupCode="identity" defaultVal="" hasLabel="false" title="退休时身份"></t:dictSelect> <label
					class="Validform_label" style="display: none;">退休时身份</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].retireDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">退休日期</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].pensionStartDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">开始领取退休金日期</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].auditDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">退休审批日期</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].jobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">岗位工资</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].rankSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">薪级工资</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].extraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">百分之十部分</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].teachExtra" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">特教津贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].teachAgeExtra" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">教龄津贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].liveExtra2007" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">07年生活补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].dutyExtra2010" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">10年按职务增加补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].ageExtra2010" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">10年按年龄增加补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].instituteExtra2011" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">11年事业增加补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].instituteExtra2013" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">13年事业增加补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].instituteExtra2014" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">14年事业增加补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].growthExtra2011" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">11年增长机制补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].workAgeExtra2011" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">11年工作年限补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].pensionUpgrade2011" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">11年提高退休费补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].houseRentExtra" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">公有住房提租补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].bookExtra" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">书报洗理费</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].surplusExtra" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">包干结余奖</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].workModelExtra" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">劳模荣誉津贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].seniorTeacherExtra" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">特级教师津贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].instituteBasic" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">事业基本退休费</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].dutySalary1" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">公务员职务工资</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].rankSalary1" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">公务员级别工资</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].policeRankSalary1" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">公务员警衔津贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].dutyExtra1" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">公务员职务补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].ageExtra1" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">公务员年龄补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].workAgeExtra1" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">公务员工作年限补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].pensionUpgrade1" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">公务员提高退休费补贴</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].serventBasic1" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">公务员基本退休费</label></td>
				<td align="left"><input name="zformPersonRetireList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
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