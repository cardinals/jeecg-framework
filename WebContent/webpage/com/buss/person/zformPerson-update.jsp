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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zformPersonController.do?doUpdate">
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
				<t:tab href="zformPersonController.do?zformPersonActiveList&code=${zformPersonPage.code}" icon="icon-search" title="在职" id="zformPersonActive"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonRetireList&code=${zformPersonPage.code}" icon="icon-search" title="退休" id="zformPersonRetire"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonTransferExternalList&code=${zformPersonPage.code}" icon="icon-search" title="调出" id="zformPersonTransferExternal"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonDeathList&code=${zformPersonPage.code}" icon="icon-search" title="死亡" id="zformPersonDeath"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonPunishList&code=${zformPersonPage.code}" icon="icon-search" title="处分" id="zformPersonPunish"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonTransferInnerList&code=${zformPersonPage.code}" icon="icon-search" title="人员调动" id="zformPersonTransferInner"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonJobList&code=${zformPersonPage.code}" icon="icon-search" title="岗位聘用" id="zformPersonJob"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonExamList&code=${zformPersonPage.code}" icon="icon-search" title="年度考核" id="zformPersonExam"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonSalaryList&code=${zformPersonPage.code}" icon="icon-search" title="薪资管理" id="zformPersonSalary"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonTitleList&code=${zformPersonPage.code}" icon="icon-search" title="职务变动" id="zformPersonTitle"></t:tab>
				<t:tab href="zformPersonController.do?zformPersonStatusList&code=${zformPersonPage.code}" icon="icon-search" title="状态变动" id="zformPersonStatus"></t:tab>
			</t:tabs>
		</div>
	</t:formvalid>
	<!-- 添加 附表明细 模版 -->
	<table style="display:none">
		<tbody id="add_zformPersonActive_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].schoolCode" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false"
						title="所在学校"></t:dictSelect> <label class="Validform_label" style="display: none;">所在学校</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].currentIdentity" type="list" typeGroupCode="identity" defaultVal="" hasLabel="false" title="现身份"></t:dictSelect> <label
					class="Validform_label" style="display: none;">现身份</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].currentTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="现职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">现职称</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].currentTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">现职称扩充</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].currentTitleDate" maxlength="200" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">现职称评审日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].dutyCategory" type="list" typeGroupCode="duty" defaultVal="" hasLabel="false" title="任职类别"></t:dictSelect> <label
					class="Validform_label" style="display: none;">任职类别</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].executiveTitle" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">行政职务</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].currentJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="所聘岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">所聘岗位</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].currentJobExtra" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">所聘岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].currentJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="所聘岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">所聘岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].currentJobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="所聘岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">所聘岗位类型</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].jobSalary" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">岗位工资</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].rank" type="list" typeGroupCode="rank" defaultVal="" hasLabel="false" title="薪级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">薪级</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].rankSalary" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">薪级工资</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].extraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">百分之十工资</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].totalSeniority" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">累计工龄</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].teachingSeniority" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">教龄</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].hardCore" type="checkbox" typeGroupCode="hardcore" defaultVal="" hasLabel="false" title="教育人才类别"></t:dictSelect> <label
					class="Validform_label" style="display: none;">教育人才类别</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].honorTitle" type="checkbox" typeGroupCode="honor_t" defaultVal="" hasLabel="false" title="所获荣誉称号"></t:dictSelect> <label
					class="Validform_label" style="display: none;">所获荣誉称号</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].majorGrade" type="list" typeGroupCode="grade" defaultVal="" hasLabel="false" title="班主任年级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">班主任年级</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].teachingCourse1" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">任教课程1</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].teachingGrade1" type="list" typeGroupCode="grade" defaultVal="" hasLabel="false" title="任教学段1"></t:dictSelect> <label
					class="Validform_label" style="display: none;">任教学段1</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].teachingClassNo1" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">任教节数1</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].teachingCourse2" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">任教课程2</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].teachingGrade2" type="list" typeGroupCode="grade" defaultVal="" hasLabel="false" title="任教学段2"></t:dictSelect> <label
					class="Validform_label" style="display: none;">任教学段2</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].teachingClassNo2" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">任教节数2</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].teachingMajorGrade" type="list" typeGroupCode="grade" defaultVal="" hasLabel="false" title="任教年级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">任教年级</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].contractTerm" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">聘用合同聘期</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].contractEndDate" maxlength="32" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">聘用合同截止日期</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].probationEndDate" maxlength="32" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">转正定级日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].teacherCert" type="list" typeGroupCode="qualify" defaultVal="" hasLabel="false" title="教师资格"></t:dictSelect> <label
					class="Validform_label" style="display: none;">教师资格</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].teacherCertLevel" type="list" typeGroupCode="cert_level" defaultVal="" hasLabel="false" title="教师资格证等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">教师资格证等级</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].teacherCertDate" maxlength="32" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">教师资格证颁发日期</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].regEndDate" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">教师资额注册截止日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].rotateStatus" type="list" typeGroupCode="rotate_s" defaultVal="" hasLabel="false" title="交流轮岗情况"></t:dictSelect> <label
					class="Validform_label" style="display: none;">交流轮岗情况</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].probationStatus" type="list" typeGroupCode="probate" defaultVal="" hasLabel="false" title="试用期情况"></t:dictSelect> <label
					class="Validform_label" style="display: none;">试用期情况</label></td>
				<td align="left"><t:dictSelect field="zformPersonActiveList[#index#].transferReason" type="list" typeGroupCode="trans_r" defaultVal="" hasLabel="false" title="调动原因"></t:dictSelect> <label
					class="Validform_label" style="display: none;">调动原因</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].department" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">所在部门</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].weeklyHours" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">周课时</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].serviceEndDate" maxlength="32" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">服务期截止日期</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].serviceRemainDate" maxlength="32" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">服务期剩余时间</label></td>
				<td align="left"><input name="zformPersonActiveList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</tbody>
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
		<tbody id="add_zformPersonTransferExternal_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><t:dictSelect field="zformPersonTransferExternalList[#index#].fromSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false"
						title="调出单位"></t:dictSelect> <label class="Validform_label" style="display: none;">调出单位</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].toSchool" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">调往单位</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].toSchoolAddress" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">调往单位所在区县</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].refLetterNo" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">干部介绍信编号</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].refLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">干部介绍信开具日期</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].salaryEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">工资止薪日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferExternalList[#index#].penalityStatus" type="list" typeGroupCode="penality" defaultVal="" hasLabel="false" title="违约金情况"></t:dictSelect>
					<label class="Validform_label" style="display: none;">违约金情况</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].penalityAmount" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">违约金数额</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].transferReason" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">调动原因</label></td>
				<td align="left"><input name="zformPersonTransferExternalList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</tbody>
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
		<tbody id="add_zformPersonPunish_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><input name="zformPersonPunishList[#index#].punishment" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">所受处分情况</label></td>
				<td align="left"><input name="zformPersonPunishList[#index#].punishmentEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">所受处分到期日期</label></td>
				<td align="left"><input name="zformPersonPunishList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</tbody>
		<tbody id="add_zformPersonTransferInner_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[#index#].fromSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false"
						title="调出学校"></t:dictSelect> <label class="Validform_label" style="display: none;">调出学校</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[#index#].toSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false"
						title="调入学校"></t:dictSelect> <label class="Validform_label" style="display: none;">调入学校</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[#index#].transferDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">调动日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[#index#].transferLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">商调函日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[#index#].notifyLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">调干通知书日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[#index#].refLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">干部介绍信日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[#index#].salaryEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">原单位止薪日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[#index#].transferReason" type="list" typeGroupCode="trans_r" defaultVal="" hasLabel="false" title="调动原因"></t:dictSelect> <label
					class="Validform_label" style="display: none;">调动原因</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[#index#].transferTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="调出前职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">调出前职称</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[#index#].nominate" type="list" typeGroupCode="yesorno" defaultVal="" hasLabel="false" title="是否组织任命"></t:dictSelect> <label
					class="Validform_label" style="display: none;">是否组织任命</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">备注</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[#index#].transferStatus" maxlength="100" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">调动状态</label></td>
			</tr>
		</tbody>
		<tbody id="add_zformPersonJob_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><input name="zformPersonJobList[#index#].year" maxlength="20" type="text" class="inputxt" style="width:120px;" datatype="*"> <label
					class="Validform_label" style="display: none;">学年度</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].prevTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="原职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原职称</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].prevTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原职称扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].prevJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="原岗位名称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位名称</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="原岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位等级</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].prevJobExtra" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="原岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位类型</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].prevWorkAge" maxlength="100" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原任职年限</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].prevJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原岗位工资</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].prevTitleWorkDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">原专技职务聘用日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].newTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="新职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新职称</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].newTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新职称扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].newJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="新岗位名称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位名称</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].newJobExtra" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="新岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[#index#].newJobType" type="list" typeGroupCode="jobetype" defaultVal="" hasLabel="false" title="新岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位类型</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].newJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新岗位工资</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].newJobStartDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">新岗位起聘日期</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].newJobEndDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">新岗位止聘日期</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].jobChangeReason" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">岗位变动原因</label></td>
				<td align="left"><input name="zformPersonJobList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</tbody>
		<tbody id="add_zformPersonExam_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[#index#].schoolCode" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="" hasLabel="false"
						title="学校名称"></t:dictSelect> <label class="Validform_label" style="display: none;">学校名称</label></td>
				<td align="left"><input name="zformPersonExamList[#index#].year" maxlength="10" type="text" class="inputxt" style="width:120px;" datatype="*"> <label
					class="Validform_label" style="display: none;">年度</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[#index#].title" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="技术职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">技术职称</label></td>
				<td align="left"><input name="zformPersonExamList[#index#].titleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">职称扩充</label></td>
				<td align="left"><input name="zformPersonExamList[#index#].executiveTitle" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">行政职务</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[#index#].job" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="岗位名称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">岗位名称</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[#index#].jobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[#index#].jobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">岗位类型</label></td>
				<td align="left"><input name="zformPersonExamList[#index#].score" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">量化考核分数</label></td>
				<td align="left"><input name="zformPersonExamList[#index#].voteReview" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">民主测评结果</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[#index#].finalResult" type="list" typeGroupCode="exam_r" defaultVal="" hasLabel="false" title="最终考核结果"></t:dictSelect> <label
					class="Validform_label" style="display: none;">最终考核结果</label></td>
				<td align="left"><input name="zformPersonExamList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</tbody>
		<tbody id="add_zformPersonSalary_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].seqNo" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">序号</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].year" maxlength="10" type="text" class="inputxt" style="width:120px;" datatype="*"> <label
					class="Validform_label" style="display: none;">年度</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].changeReason" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">变动原因</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].effectiveDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;" datatype="*">
					<label class="Validform_label" style="display: none;">变动生效日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].prevJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="原岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="原岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="原岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位类型</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].prevJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">原岗位工资</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].prevRankLevel" type="list" typeGroupCode="rank" defaultVal="" hasLabel="false" title="原薪级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原薪级</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].prevRankSalary" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">原薪级工资</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].prevExtraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">原百分之十</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].newJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="新岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="新岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].newJobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="新岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位类型</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].newJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新岗位工资</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[#index#].newRankLevel" type="list" typeGroupCode="rank" defaultVal="" hasLabel="false" title="新薪级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新薪级</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].newRankSalary" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">新薪级工资</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].newExtraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">新百分之十</label></td>
				<td align="left"><input name="zformPersonSalaryList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</tbody>
		<tbody id="add_zformPersonTitle_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].prevTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="原职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原职称</label></td>
				<td align="left"><input name="zformPersonTitleList[#index#].prevTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">原职称扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].prevJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="原岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位</label></td>
				<td align="left"><input name="zformPersonTitleList[#index#].prevJobExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="原岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="原岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位类型</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].newTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="新职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新职称</label></td>
				<td align="left"><input name="zformPersonTitleList[#index#].newTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">新职称扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].newJob" type="list" typeGroupCode="job" defaultVal="" hasLabel="false" title="新岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位</label></td>
				<td align="left"><input name="zformPersonTitleList[#index#].newJobExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="" hasLabel="false" title="新岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[#index#].newJobType" type="list" typeGroupCode="jobtype" defaultVal="" hasLabel="false" title="新岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位类型</label></td>
				<td align="left"><input name="zformPersonTitleList[#index#].changeReason" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">职务变动原因</label></td>
				<td align="left"><input name="zformPersonTitleList[#index#].effectiveDate" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;" datatype="*">
					<label class="Validform_label" style="display: none;">职务变动生效日期</label></td>
				<td align="left"><input name="zformPersonTitleList[#index#].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
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