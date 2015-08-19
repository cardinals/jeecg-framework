<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
		}
    });
</script>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:auto;">
	<table cellpadding="0" cellspacing="1" class="formtable" id="zformPersonActive_table">
		<tbody id="add_zformPersonActive_table">
			<c:if test="${fn:length(zformPersonActiveList)  <= 0 }">
				<tr>
					<input name="zformPersonActiveList[0].id" type="hidden" value="${poVal.id}" />
					<input name="zformPersonActiveList[0].code" type="hidden" value="${poVal.code}" />
					<input name="zformPersonActiveList[0].extra1" type="hidden" value="${poVal.extra1}" />
					<input name="zformPersonActiveList[0].extra4" type="hidden" value="${poVal.extra4}" />
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 所在学校: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].schoolCode" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${User_SchoolCode}" hasLabel="false"
							title="所在学校"></t:dictSelect> <label class="Validform_label" style="display: none;">所在学校</label></td>
					<td align="right"><label class="Validform_label"> 现身份: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentIdentity" type="list" typeGroupCode="identity" defaultVal="${zformPersonActivePage.currentIdentity}" hasLabel="false" title="现身份"></t:dictSelect>
						<label class="Validform_label" style="display: none;">现身份</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 现职称: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentTitle" type="list" typeGroupCode="title" defaultVal="${zformPersonActivePage.currentTitle}" hasLabel="false" title="现职称"></t:dictSelect> <label
						class="Validform_label" style="display: none;">现职称</label></td>
					<td align="right"><label class="Validform_label"> 现职称扩充: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].currentTitleExtra" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">现职称扩充</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 现职称评审日期: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].currentTitleDate" maxlength="200" type="text" class="Wdate" onClick="WdatePicker()">
						<label class="Validform_label" style="display: none;">现职称评审日期</label></td>
					<td align="right"><label class="Validform_label"> 任职类别: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].dutyCategory" type="list" typeGroupCode="duty" defaultVal="${zformPersonActivePage.dutyCategory}" hasLabel="false" title="任职类别"></t:dictSelect> <label
						class="Validform_label" style="display: none;">任职类别</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 行政职务: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].executiveTitle" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">行政职务</label></td>
					<td align="right"><label class="Validform_label"> 所聘岗位: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentJob" type="list" typeGroupCode="job" defaultVal="${zformPersonActivePage.currentJob}" hasLabel="false" title="所聘岗位"></t:dictSelect> <label
						class="Validform_label" style="display: none;">所聘岗位</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 所聘岗位扩充: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].currentJobExtra" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">所聘岗位扩充</label></td>
					<td align="right"><label class="Validform_label"> 所聘岗位等级: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonActivePage.currentJobLevel}" hasLabel="false" title="所聘岗位等级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">所聘岗位等级</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 所聘岗位类型: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentJobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonActivePage.currentJobType}" hasLabel="false" title="所聘岗位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">所聘岗位类型</label></td>
					<td align="right"><label class="Validform_label"> 岗位工资: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].jobSalary" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">岗位工资</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 薪级: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].rank" type="list" typeGroupCode="rank" defaultVal="${zformPersonActivePage.rank}" hasLabel="false" title="薪级"></t:dictSelect> <label
						class="Validform_label" style="display: none;">薪级</label></td>
					<td align="right"><label class="Validform_label"> 薪级工资: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].rankSalary" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">薪级工资</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 百分之十工资: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].extraSalary" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">百分之十工资</label></td>
					<td align="right"><label class="Validform_label"> 累计工龄: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].totalSeniority" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">累计工龄</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 教龄: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].teachingSeniority" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">教龄</label></td>
					<td align="right"><label class="Validform_label"> 教育人才类别: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].hardCore" type="checkbox" typeGroupCode="hardcore" defaultVal="" hasLabel="false" title="教育人才类别"></t:dictSelect> <label
						class="Validform_label" style="display: none;">教育人才类别</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 所获荣誉称号: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].honorTitle" type="checkbox" typeGroupCode="honor_t" defaultVal="${zformPersonActivePage.honorTitle}" hasLabel="false" title="所获荣誉称号"></t:dictSelect> <label
						class="Validform_label" style="display: none;">所获荣誉称号</label></td>
					<td align="right"><label class="Validform_label"> 班主任年级: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].majorGrade" type="list" typeGroupCode="grade" defaultVal="${zformPersonActivePage.majorGrade}" hasLabel="false" title="班主任年级"></t:dictSelect> <label
						class="Validform_label" style="display: none;">班主任年级</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 任教课程1: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingCourse1" type="list" typeGroupCode="class_t" defaultVal="" hasLabel="false" title="任教课程1"></t:dictSelect> <label
						class="Validform_label" style="display: none;">任教课程1</label></td>
					<td align="right"><label class="Validform_label"> 任教学段1: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingGrade1" type="list" typeGroupCode="grade" defaultVal="${zformPersonActivePage.teachingGrade1}" hasLabel="false" title="任教学段1"></t:dictSelect> <label
						class="Validform_label" style="display: none;">任教学段1</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 任教节数1: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].teachingClassNo1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">任教节数1</label></td>
					<td align="right"><label class="Validform_label"> 任教课程2: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingCourse2" type="list" typeGroupCode="class_t" defaultVal="" hasLabel="false" title="任教课程2" ></t:dictSelect> <label
						class="Validform_label" style="display: none;">任教课程2</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 任教学段2: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingGrade2" type="list" typeGroupCode="grade" defaultVal="${zformPersonActivePage.teachingGrade2}" hasLabel="false" title="任教学段2"></t:dictSelect> <label
						class="Validform_label" style="display: none;">任教学段2</label></td>
					<td align="right"><label class="Validform_label"> 任教节数2: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].teachingClassNo2" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">任教节数2</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 任教年级: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingMajorGrade" type="list" typeGroupCode="grade" defaultVal="${zformPersonActivePage.teachingMajorGrade}" hasLabel="false" title="任教年级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">任教年级</label></td>
					<td align="right"><label class="Validform_label"> 聘用合同聘期: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].contractTerm" maxlength="32" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">聘用合同聘期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 聘用合同截止日期: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].contractEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">聘用合同截止日期</label></td>
					<td align="right"><label class="Validform_label"> 转正定级日期: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].probationEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">转正定级日期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 教师资格: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].teacherCert" type="list" typeGroupCode="qualify" defaultVal="${zformPersonActivePage.teacherCert}" hasLabel="false" title="教师资格"></t:dictSelect> <label
						class="Validform_label" style="display: none;">教师资格</label></td>
					<td align="right"><label class="Validform_label"> 教师资格证等级: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].teacherCertLevel" type="list" typeGroupCode="cert_level" defaultVal="${zformPersonActivePage.teacherCertLevel}" hasLabel="false" title="教师资格证等级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">教师资格证等级</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 教师资格证颁发日期: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].teacherCertDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">教师资格证颁发日期</label></td>
					<td align="right"><label class="Validform_label"> 教师资额注册截止日期: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].regEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">教师资额注册截止日期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 交流轮岗情况: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].rotateStatus" type="list" typeGroupCode="rotate_s" defaultVal="${zformPersonActivePage.rotateStatus}" hasLabel="false" title="交流轮岗情况"></t:dictSelect> <label
						class="Validform_label" style="display: none;">交流轮岗情况</label></td>
					<td align="right"><label class="Validform_label"> 试用期情况: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].probationStatus" type="list" typeGroupCode="probate" defaultVal="${zformPersonActivePage.probationStatus}" hasLabel="false" title="试用期情况"></t:dictSelect>
						<label class="Validform_label" style="display: none;">试用期情况</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 调动原因: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].transferReason" type="list" typeGroupCode="trans_r" defaultVal="${zformPersonActivePage.transferReason}" hasLabel="false" title="调动原因"></t:dictSelect>
						<label class="Validform_label" style="display: none;">调动原因</label></td>
					<td align="right"><label class="Validform_label"> 所在部门: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].department" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">所在部门</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 单位分类: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].extra2" type="list" typeGroupCode="danwei_fl" defaultVal="" hasLabel="false" title="单位分类"></t:dictSelect>
						<label class="Validform_label" style="display: none;">单位分类</label></td>
					<td align="right"><label class="Validform_label"> 单位类型: </label></td>
					<td class="value"><t:dictSelect field="zformPersonActiveList[0].extra3" type="list" typeGroupCode="danwei_lx" defaultVal="" hasLabel="false" title="单位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">单位类型</label></td>			
				</tr>
				
				<tr>
					<td align="right"><label class="Validform_label"> 周课时: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].weeklyHours" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">周课时</label></td>
					<td align="right"><label class="Validform_label"> 服务期截止日期: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].serviceEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">服务期截止日期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 服务期剩余时间: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].serviceRemainDate" maxlength="32" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">服务期剩余时间</label></td>
					<td align="right"><label class="Validform_label"> 备注: </label></td>
					<td class="value"><input name="zformPersonActiveList[0].comments" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:if>
			<c:if test="${fn:length(zformPersonActiveList)  > 0 }">
				<c:forEach items="${zformPersonActiveList}" var="poVal" varStatus="stuts" begin="0" end="0">
					<tr>
						<input name="zformPersonActiveList[0].id" type="hidden" value="${poVal.id}" />
						<input name="zformPersonActiveList[0].code" type="hidden" value="${poVal.code}" />
						<input name="zformPersonActiveList[0].extra1" type="hidden" value="${poVal.extra1}" />
						<input name="zformPersonActiveList[0].extra4" type="hidden" value="${poVal.extra4}" />
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 所在学校: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].schoolCode" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${poVal.schoolCode}" hasLabel="false"
								title="所在学校"></t:dictSelect> <label class="Validform_label" style="display: none;">所在学校</label></td>
						<td align="right"><label class="Validform_label"> 现身份: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentIdentity" type="list" typeGroupCode="identity" defaultVal="${poVal.currentIdentity}" hasLabel="false" title="现身份"></t:dictSelect>
							<label class="Validform_label" style="display: none;">现身份</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 现职称: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentTitle" type="list" typeGroupCode="title" defaultVal="${poVal.currentTitle}" hasLabel="false" title="现职称"></t:dictSelect> <label
							class="Validform_label" style="display: none;">现职称</label></td>
						<td align="right"><label class="Validform_label"> 现职称扩充: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].currentTitleExtra" maxlength="200" type="text" class="inputxt" value="${poVal.currentTitleExtra }"> <label
							class="Validform_label" style="display: none;">现职称扩充</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 现职称评审日期: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].currentTitleDate" maxlength="200" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.currentTitleDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">现职称评审日期</label></td>
						<td align="right"><label class="Validform_label"> 任职类别: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].dutyCategory" type="list" typeGroupCode="duty" defaultVal="${poVal.dutyCategory}" hasLabel="false" title="任职类别"></t:dictSelect> <label
							class="Validform_label" style="display: none;">任职类别</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 行政职务: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].executiveTitle" maxlength="200" type="text" class="inputxt" value="${poVal.executiveTitle }"> <label class="Validform_label"
							style="display: none;">行政职务</label></td>
						<td align="right"><label class="Validform_label"> 所聘岗位: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentJob" type="list" typeGroupCode="job" defaultVal="${poVal.currentJob}" hasLabel="false" title="所聘岗位"></t:dictSelect> <label
							class="Validform_label" style="display: none;">所聘岗位</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 所聘岗位扩充: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].currentJobExtra" maxlength="200" type="text" class="inputxt" value="${poVal.currentJobExtra }"> <label
							class="Validform_label" style="display: none;">所聘岗位扩充</label></td>
						<td align="right"><label class="Validform_label"> 所聘岗位等级: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.currentJobLevel}" hasLabel="false" title="所聘岗位等级"></t:dictSelect>
							<label class="Validform_label" style="display: none;">所聘岗位等级</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 所聘岗位类型: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].currentJobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.currentJobType}" hasLabel="false" title="所聘岗位类型"></t:dictSelect>
							<label class="Validform_label" style="display: none;">所聘岗位类型</label></td>
						<td align="right"><label class="Validform_label"> 岗位工资: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].jobSalary" maxlength="200" type="text" class="inputxt" value="${poVal.jobSalary }"> <label class="Validform_label"
							style="display: none;">岗位工资</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 薪级: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].rank" type="list" typeGroupCode="rank" defaultVal="${poVal.rank}" hasLabel="false" title="薪级"></t:dictSelect> <label
							class="Validform_label" style="display: none;">薪级</label></td>
						<td align="right"><label class="Validform_label"> 薪级工资: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].rankSalary" maxlength="200" type="text" class="inputxt" value="${poVal.rankSalary }"> <label class="Validform_label"
							style="display: none;">薪级工资</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 百分之十工资: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].extraSalary" maxlength="10" type="text" class="inputxt" value="${poVal.extraSalary }"> <label class="Validform_label"
							style="display: none;">百分之十工资</label></td>
						<td align="right"><label class="Validform_label"> 累计工龄: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].totalSeniority" maxlength="200" type="text" class="inputxt" value="${poVal.totalSeniority }"> <label class="Validform_label"
							style="display: none;">累计工龄</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 教龄: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].teachingSeniority" maxlength="200" type="text" class="inputxt" value="${poVal.teachingSeniority }"> <label
							class="Validform_label" style="display: none;">教龄</label></td>
						<td align="right"><label class="Validform_label"> 教育人才类别: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].hardCore" type="checkbox" typeGroupCode="hardcore" defaultVal="${poVal.hardCore}" hasLabel="false" title="教育人才类别"></t:dictSelect> <label
							class="Validform_label" style="display: none;">教育人才类别</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 所获荣誉称号: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].honorTitle" type="checkbox" typeGroupCode="honor_t" defaultVal="${poVal.honorTitle}" hasLabel="false" title="所获荣誉称号"></t:dictSelect> <label
							class="Validform_label" style="display: none;">所获荣誉称号</label></td>
						<td align="right"><label class="Validform_label"> 班主任年级: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].majorGrade" type="list" typeGroupCode="grade" defaultVal="${poVal.majorGrade}" hasLabel="false" title="班主任年级"></t:dictSelect> <label
							class="Validform_label" style="display: none;">班主任年级</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 任教课程1: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingCourse1" type="list" typeGroupCode="class_t" defaultVal="${poVal.teachingCourse1}" hasLabel="false" title="任教课程1"></t:dictSelect>
						 <label class="Validform_label" style="display: none;">任教课程1</label></td>
						<td align="right"><label class="Validform_label"> 任教学段1: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingGrade1" type="list" typeGroupCode="grade" defaultVal="${poVal.teachingGrade1}" hasLabel="false" title="任教学段1"></t:dictSelect>
							<label class="Validform_label" style="display: none;">任教学段1</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 任教节数1: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].teachingClassNo1" maxlength="10" type="text" class="inputxt" value="${poVal.teachingClassNo1 }"> <label
							class="Validform_label" style="display: none;">任教节数1</label></td>
						<td align="right"><label class="Validform_label"> 任教课程2: </label></td>
						<td class="value">
							<t:dictSelect field="zformPersonActiveList[0].teachingCourse2" type="list" typeGroupCode="class_t" defaultVal="${poVal.teachingCourse2}" hasLabel="false" title="任教课程2"></t:dictSelect>
						<label class="Validform_label" style="display: none;">任教课程2</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 任教学段2: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingGrade2" type="list" typeGroupCode="grade" defaultVal="${poVal.teachingGrade2}" hasLabel="false" title="任教学段2"></t:dictSelect>
							<label class="Validform_label" style="display: none;">任教学段2</label></td>
						<td align="right"><label class="Validform_label"> 任教节数2: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].teachingClassNo2" maxlength="10" type="text" class="inputxt" value="${poVal.teachingClassNo2 }"> <label
							class="Validform_label" style="display: none;">任教节数2</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 任教年级: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].teachingMajorGrade" type="list" typeGroupCode="grade" defaultVal="${poVal.teachingMajorGrade}" hasLabel="false" title="任教年级"></t:dictSelect>
							<label class="Validform_label" style="display: none;">任教年级</label></td>
						<td align="right"><label class="Validform_label"> 聘用合同聘期: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].contractTerm" maxlength="32" type="text" class="inputxt" value="${poVal.contractTerm }"> <label class="Validform_label"
							style="display: none;">聘用合同聘期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 聘用合同截止日期: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].contractEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" value="${poVal.contractEndDate }"> <label class="Validform_label"
							style="display: none;">聘用合同截止日期</label></td>
						<td align="right"><label class="Validform_label"> 转正定级日期: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].probationEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" value="${poVal.probationEndDate }"> <label
							class="Validform_label" style="display: none;">转正定级日期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 教师资格: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].teacherCert" type="list" typeGroupCode="qualify" defaultVal="${poVal.teacherCert}" hasLabel="false" title="教师资格"></t:dictSelect> <label
							class="Validform_label" style="display: none;">教师资格</label></td>
						<td align="right"><label class="Validform_label"> 教师资格证等级: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].teacherCertLevel" type="list" typeGroupCode="cert_level" defaultVal="${poVal.teacherCertLevel}" hasLabel="false" title="教师资格证等级"></t:dictSelect>
							<label class="Validform_label" style="display: none;">教师资格证等级</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 教师资格证颁发日期: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].teacherCertDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" value="${poVal.teacherCertDate }"> <label class="Validform_label"
							style="display: none;">教师资格证颁发日期</label></td>
						<td align="right"><label class="Validform_label"> 教师资额注册截止日期: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].regEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" value="${poVal.regEndDate }"> <label class="Validform_label"
							style="display: none;">教师资额注册截止日期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 交流轮岗情况: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].rotateStatus" type="list" typeGroupCode="rotate_s" defaultVal="${poVal.rotateStatus}" hasLabel="false" title="交流轮岗情况"></t:dictSelect>
							<label class="Validform_label" style="display: none;">交流轮岗情况</label></td>
						<td align="right"><label class="Validform_label"> 试用期情况: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].probationStatus" type="list" typeGroupCode="probate" defaultVal="${poVal.probationStatus}" hasLabel="false" title="试用期情况"></t:dictSelect>
							<label class="Validform_label" style="display: none;">试用期情况</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 调动原因: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].transferReason" type="list" typeGroupCode="trans_r" defaultVal="${poVal.transferReason}" hasLabel="false" title="调动原因"></t:dictSelect>
							<label class="Validform_label" style="display: none;">调动原因</label></td>
						<td align="right"><label class="Validform_label"> 所在部门: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].department" maxlength="200" type="text" class="inputxt" value="${poVal.department }"> <label class="Validform_label"
							style="display: none;">所在部门</label></td>
					</tr>
					<tr>
					<td align="right"><label class="Validform_label"> 单位分类: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].extra2" type="list" typeGroupCode="danwei_fl" defaultVal="${poVal.extra2}" hasLabel="false" title="单位分类"></t:dictSelect>
							<label class="Validform_label" style="display: none;">单位分类</label></td>
						<td align="right"><label class="Validform_label"> 单位类型: </label></td>
						<td class="value"><t:dictSelect field="zformPersonActiveList[0].extra3" type="list" typeGroupCode="danwei_lx" defaultVal="${poVal.extra3}" hasLabel="false" title="单位类型"></t:dictSelect>
							<label class="Validform_label" style="display: none;">单位类型</label></td>			
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 周课时: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].weeklyHours" maxlength="10" type="text" class="inputxt" value="${poVal.weeklyHours }"> <label class="Validform_label"
							style="display: none;">周课时</label></td>
						<td align="right"><label class="Validform_label"> 服务期截止日期: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].serviceEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" value="${poVal.serviceEndDate }"> <label class="Validform_label"
							style="display: none;">服务期截止日期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 服务期剩余时间: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].serviceRemainDate" maxlength="32" type="text" class="inputxt" value="${poVal.serviceRemainDate }"> <label
							class="Validform_label" style="display: none;">服务期剩余时间</label></td>
						<td align="right"><label class="Validform_label"> 备注: </label></td>
						<td class="value"><input name="zformPersonActiveList[0].comments" maxlength="200" type="text" class="inputxt" value="${poVal.comments }"> <label class="Validform_label"
							style="display: none;">备注</label></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>