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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zformPersonController.do?doUpdate&updateStatus=10">
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
				<t:tab href="zformPersonController.do?zformPersonJobList&code=${zformPersonPage.code}" icon="icon-search" title="岗位聘用" id="zformPersonJob"></t:tab>
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