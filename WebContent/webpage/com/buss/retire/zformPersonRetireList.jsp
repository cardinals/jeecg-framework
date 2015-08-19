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
	<table cellpadding="0" cellspacing="1" class="formtable" id="zformPersonRetire_table">
		<tbody id="add_zformPersonRetire_table">
			<c:if test="${fn:length(zformPersonRetireList)  <= 0 }">
				<tr>
					<input name="zformPersonRetireList[0].id" type="hidden" value="${poVal.id}" />
					<input name="zformPersonRetireList[0].code" type="hidden" value="${poVal.code}" />
					<input name="zformPersonRetireList[0].jobSalaryP" type="hidden" value="${poVal.jobSalaryP}" />
					<input name="zformPersonRetireList[0].jobSalaryUpP" type="hidden" value="${poVal.jobSalaryUpP}" />
					<input name="zformPersonRetireList[0].jobSalarySumP" type="hidden" value="${poVal.jobSalarySumP}" />
					<input name="zformPersonRetireList[0].rankSalaryP" type="hidden" value="${poVal.rankSalaryP}" />
					<input name="zformPersonRetireList[0].rankSalaryUpP" type="hidden" value="${poVal.rankSalaryUpP}" />
					<input name="zformPersonRetireList[0].rankSalarySumP" type="hidden" value="${poVal.rankSalarySumP}" />
					<input name="zformPersonRetireList[0].extraSalaryP" type="hidden" value="${poVal.extraSalaryP}" />
					<input name="zformPersonRetireList[0].extraSalaryUpP" type="hidden" value="${poVal.extraSalaryUpP}" />
					<input name="zformPersonRetireList[0].extraSalarySumP" type="hidden" value="${poVal.extraSalarySumP}" />
					<input name="zformPersonRetireList[0].teachExtraP" type="hidden" value="${poVal.teachExtraP}" />
					<input name="zformPersonRetireList[0].teachExtraUpP" type="hidden" value="${poVal.teachExtraUpP}" />
					<input name="zformPersonRetireList[0].teachExtraSumP" type="hidden" value="${poVal.teachExtraSumP}" />
					<input name="zformPersonRetireList[0].extra1" type="hidden" value="${poVal.extra1}" />
					<input name="zformPersonRetireList[0].extra2" type="hidden" value="${poVal.extra2}" />
					<input name="zformPersonRetireList[0].extra3" type="hidden" value="${poVal.extra3}" />
					<input name="zformPersonRetireList[0].extra4" type="hidden" value="${poVal.extra4}" />
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 退休证号: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].retireCardNo" maxlength="32" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">退休证号</label></td>
					<td align="right"><label class="Validform_label"> 退休时单位: </label></td>
					<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${zformPersonRetirePage.retireSchool}" hasLabel="false"
							title="退休时单位"></t:dictSelect> <label class="Validform_label" style="display: none;">退休时单位</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 连续工龄: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].workAge" maxlength="32" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">连续工龄</label></td>
					<td align="right"><label class="Validform_label"> 退休时岗位: </label></td>
					<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireJob" type="list" typeGroupCode="job" defaultVal="${zformPersonRetirePage.retireJob}" hasLabel="false" title="退休时岗位"></t:dictSelect> <label
						class="Validform_label" style="display: none;">退休时岗位</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 退休时岗位级别: </label></td>
					<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonRetirePage.retireJobLevel}" hasLabel="false" title="退休时岗位级别"></t:dictSelect>
						<label class="Validform_label" style="display: none;">退休时岗位级别</label></td>
					<td align="right"><label class="Validform_label"> 退休时薪级: </label></td>
					<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireRankLevel" type="list" typeGroupCode="rank" defaultVal="${zformPersonRetirePage.retireRankLevel}" hasLabel="false" title="退休时薪级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">退休时薪级</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 退休时身份: </label></td>
					<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireIdentity" type="list" typeGroupCode="identity" defaultVal="${zformPersonRetirePage.retireIdentity}" hasLabel="false" title="退休时身份"></t:dictSelect>
						<label class="Validform_label" style="display: none;">退休时身份</label></td>
					<td align="right"><label class="Validform_label"> 退休日期: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].retireDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">退休日期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 开始领取退休金日期: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].pensionStartDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()">
						<label class="Validform_label" style="display: none;">开始领取退休金日期</label></td>
					<td align="right"><label class="Validform_label"> 退休审批日期: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].auditDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">退休审批日期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 岗位工资: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].jobSalary" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">岗位工资</label></td>
					<td align="right"><label class="Validform_label"> 薪级工资: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].rankSalary" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">薪级工资</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 百分之十部分: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].extraSalary" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">百分之十部分</label></td>
					<td align="right"><label class="Validform_label"> 特教津贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].teachExtra" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">特教津贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 教龄津贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].teachAgeExtra" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">教龄津贴</label></td>
					<td align="right"><label class="Validform_label"> 07年生活补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].liveExtra2007" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">07年生活补贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 10年按职务增加补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].dutyExtra2010" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">10年按职务增加补贴</label></td>
					<td align="right"><label class="Validform_label"> 10年按年龄增加补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].ageExtra2010" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">10年按年龄增加补贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 11年事业增加补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].instituteExtra2011" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">11年事业增加补贴</label></td>
					<td align="right"><label class="Validform_label"> 13年事业增加补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].instituteExtra2013" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">13年事业增加补贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 14年事业增加补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].instituteExtra2014" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">14年事业增加补贴</label></td>
					<td align="right"><label class="Validform_label"> 11年增长机制补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].growthExtra2011" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">11年增长机制补贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 11年工作年限补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].workAgeExtra2011" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">11年工作年限补贴</label></td>
					<td align="right"><label class="Validform_label"> 11年提高退休费补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].pensionUpgrade2011" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">11年提高退休费补贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 公有住房提租补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].houseRentExtra" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公有住房提租补贴</label></td>
					<td align="right"><label class="Validform_label"> 书报洗理费: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].bookExtra" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">书报洗理费</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 包干结余奖: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].surplusExtra" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">包干结余奖</label></td>
					<td align="right"><label class="Validform_label"> 劳模荣誉津贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].workModelExtra" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">劳模荣誉津贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 特级教师津贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].seniorTeacherExtra" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">特级教师津贴</label></td>
					<td align="right"><label class="Validform_label"> 事业基本退休费: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].instituteBasic" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">事业基本退休费</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 公务员职务工资: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].dutySalary1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员职务工资</label></td>
					<td align="right"><label class="Validform_label"> 公务员级别工资: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].rankSalary1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员级别工资</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 公务员警衔津贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].policeRankSalary1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员警衔津贴</label></td>
					<td align="right"><label class="Validform_label"> 公务员职务补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].dutyExtra1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员职务补贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 公务员年龄补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].ageExtra1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员年龄补贴</label></td>
					<td align="right"><label class="Validform_label"> 公务员工作年限补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].workAgeExtra1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员工作年限补贴</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 公务员提高退休费补贴: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].pensionUpgrade1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员提高退休费补贴</label></td>
					<td align="right"><label class="Validform_label"> 公务员基本退休费: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].serventBasic1" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">公务员基本退休费</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 备注: </label></td>
					<td class="value"><input name="zformPersonRetireList[0].comments" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:if>
			<c:if test="${fn:length(zformPersonRetireList)  > 0 }">
				<c:forEach items="${zformPersonRetireList}" var="poVal" varStatus="stuts" begin="0" end="0">
					<tr>
						<input name="zformPersonRetireList[0].id" type="hidden" value="${poVal.id}" />
						<input name="zformPersonRetireList[0].code" type="hidden" value="${poVal.code}" />
						<input name="zformPersonRetireList[0].jobSalaryP" type="hidden" value="${poVal.jobSalaryP}" />
						<input name="zformPersonRetireList[0].jobSalaryUpP" type="hidden" value="${poVal.jobSalaryUpP}" />
						<input name="zformPersonRetireList[0].jobSalarySumP" type="hidden" value="${poVal.jobSalarySumP}" />
						<input name="zformPersonRetireList[0].rankSalaryP" type="hidden" value="${poVal.rankSalaryP}" />
						<input name="zformPersonRetireList[0].rankSalaryUpP" type="hidden" value="${poVal.rankSalaryUpP}" />
						<input name="zformPersonRetireList[0].rankSalarySumP" type="hidden" value="${poVal.rankSalarySumP}" />
						<input name="zformPersonRetireList[0].extraSalaryP" type="hidden" value="${poVal.extraSalaryP}" />
						<input name="zformPersonRetireList[0].extraSalaryUpP" type="hidden" value="${poVal.extraSalaryUpP}" />
						<input name="zformPersonRetireList[0].extraSalarySumP" type="hidden" value="${poVal.extraSalarySumP}" />
						<input name="zformPersonRetireList[0].teachExtraP" type="hidden" value="${poVal.teachExtraP}" />
						<input name="zformPersonRetireList[0].teachExtraUpP" type="hidden" value="${poVal.teachExtraUpP}" />
						<input name="zformPersonRetireList[0].teachExtraSumP" type="hidden" value="${poVal.teachExtraSumP}" />
						<input name="zformPersonRetireList[0].extra1" type="hidden" value="${poVal.extra1}" />
						<input name="zformPersonRetireList[0].extra2" type="hidden" value="${poVal.extra2}" />
						<input name="zformPersonRetireList[0].extra3" type="hidden" value="${poVal.extra3}" />
						<input name="zformPersonRetireList[0].extra4" type="hidden" value="${poVal.extra4}" />
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 退休证号: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].retireCardNo" maxlength="32" type="text" class="inputxt" value="${poVal.retireCardNo }"> <label class="Validform_label"
							style="display: none;">退休证号</label></td>
						<td align="right"><label class="Validform_label"> 退休时单位: </label></td>
						<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${poVal.retireSchool}"
								hasLabel="false" title="退休时单位"></t:dictSelect> <label class="Validform_label" style="display: none;">退休时单位</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 连续工龄: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].workAge" maxlength="32" type="text" class="inputxt" value="${poVal.workAge }"> <label class="Validform_label"
							style="display: none;">连续工龄</label></td>
						<td align="right"><label class="Validform_label"> 退休时岗位: </label></td>
						<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireJob" type="list" typeGroupCode="job" defaultVal="${poVal.retireJob}" hasLabel="false" title="退休时岗位"></t:dictSelect> <label
							class="Validform_label" style="display: none;">退休时岗位</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 退休时岗位级别: </label></td>
						<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.retireJobLevel}" hasLabel="false" title="退休时岗位级别"></t:dictSelect>
							<label class="Validform_label" style="display: none;">退休时岗位级别</label></td>
						<td align="right"><label class="Validform_label"> 退休时薪级: </label></td>
						<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireRankLevel" type="list" typeGroupCode="rank" defaultVal="${poVal.retireRankLevel}" hasLabel="false" title="退休时薪级"></t:dictSelect>
							<label class="Validform_label" style="display: none;">退休时薪级</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 退休时身份: </label></td>
						<td class="value"><t:dictSelect field="zformPersonRetireList[0].retireIdentity" type="list" typeGroupCode="identity" defaultVal="${poVal.retireIdentity}" hasLabel="false" title="退休时身份"></t:dictSelect>
							<label class="Validform_label" style="display: none;">退休时身份</label></td>
						<td align="right"><label class="Validform_label"> 退休日期: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].retireDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.retireDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">退休日期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 开始领取退休金日期: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].pensionStartDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.pensionStartDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">开始领取退休金日期</label></td>
						<td align="right"><label class="Validform_label"> 退休审批日期: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].auditDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.auditDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">退休审批日期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 岗位工资: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].jobSalary" maxlength="10" type="text" class="inputxt" value="${poVal.jobSalary }"> <label class="Validform_label"
							style="display: none;">岗位工资</label></td>
						<td align="right"><label class="Validform_label"> 薪级工资: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].rankSalary" maxlength="10" type="text" class="inputxt" value="${poVal.rankSalary }"> <label class="Validform_label"
							style="display: none;">薪级工资</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 百分之十部分: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].extraSalary" maxlength="10" type="text" class="inputxt" value="${poVal.extraSalary }"> <label class="Validform_label"
							style="display: none;">百分之十部分</label></td>
						<td align="right"><label class="Validform_label"> 特教津贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].teachExtra" maxlength="10" type="text" class="inputxt" value="${poVal.teachExtra }"> <label class="Validform_label"
							style="display: none;">特教津贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 教龄津贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].teachAgeExtra" maxlength="10" type="text" class="inputxt" value="${poVal.teachAgeExtra }"> <label class="Validform_label"
							style="display: none;">教龄津贴</label></td>
						<td align="right"><label class="Validform_label"> 07年生活补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].liveExtra2007" maxlength="10" type="text" class="inputxt" value="${poVal.liveExtra2007 }"> <label class="Validform_label"
							style="display: none;">07年生活补贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 10年按职务增加补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].dutyExtra2010" maxlength="10" type="text" class="inputxt" value="${poVal.dutyExtra2010 }"> <label class="Validform_label"
							style="display: none;">10年按职务增加补贴</label></td>
						<td align="right"><label class="Validform_label"> 10年按年龄增加补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].ageExtra2010" maxlength="10" type="text" class="inputxt" value="${poVal.ageExtra2010 }"> <label class="Validform_label"
							style="display: none;">10年按年龄增加补贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 11年事业增加补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].instituteExtra2011" maxlength="10" type="text" class="inputxt" value="${poVal.instituteExtra2011 }"> <label
							class="Validform_label" style="display: none;">11年事业增加补贴</label></td>
						<td align="right"><label class="Validform_label"> 13年事业增加补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].instituteExtra2013" maxlength="10" type="text" class="inputxt" value="${poVal.instituteExtra2013 }"> <label
							class="Validform_label" style="display: none;">13年事业增加补贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 14年事业增加补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].instituteExtra2014" maxlength="10" type="text" class="inputxt" value="${poVal.instituteExtra2014 }"> <label
							class="Validform_label" style="display: none;">14年事业增加补贴</label></td>
						<td align="right"><label class="Validform_label"> 11年增长机制补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].growthExtra2011" maxlength="10" type="text" class="inputxt" value="${poVal.growthExtra2011 }"> <label class="Validform_label"
							style="display: none;">11年增长机制补贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 11年工作年限补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].workAgeExtra2011" maxlength="10" type="text" class="inputxt" value="${poVal.workAgeExtra2011 }"> <label
							class="Validform_label" style="display: none;">11年工作年限补贴</label></td>
						<td align="right"><label class="Validform_label"> 11年提高退休费补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].pensionUpgrade2011" maxlength="10" type="text" class="inputxt" value="${poVal.pensionUpgrade2011 }"> <label
							class="Validform_label" style="display: none;">11年提高退休费补贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 公有住房提租补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].houseRentExtra" maxlength="10" type="text" class="inputxt" value="${poVal.houseRentExtra }"> <label class="Validform_label"
							style="display: none;">公有住房提租补贴</label></td>
						<td align="right"><label class="Validform_label"> 书报洗理费: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].bookExtra" maxlength="10" type="text" class="inputxt" value="${poVal.bookExtra }"> <label class="Validform_label"
							style="display: none;">书报洗理费</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 包干结余奖: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].surplusExtra" maxlength="10" type="text" class="inputxt" value="${poVal.surplusExtra }"> <label class="Validform_label"
							style="display: none;">包干结余奖</label></td>
						<td align="right"><label class="Validform_label"> 劳模荣誉津贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].workModelExtra" maxlength="10" type="text" class="inputxt" value="${poVal.workModelExtra }"> <label class="Validform_label"
							style="display: none;">劳模荣誉津贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 特级教师津贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].seniorTeacherExtra" maxlength="10" type="text" class="inputxt" value="${poVal.seniorTeacherExtra }"> <label
							class="Validform_label" style="display: none;">特级教师津贴</label></td>
						<td align="right"><label class="Validform_label"> 事业基本退休费: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].instituteBasic" maxlength="10" type="text" class="inputxt" value="${poVal.instituteBasic }"> <label class="Validform_label"
							style="display: none;">事业基本退休费</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 公务员职务工资: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].dutySalary1" maxlength="10" type="text" class="inputxt" value="${poVal.dutySalary1 }"> <label class="Validform_label"
							style="display: none;">公务员职务工资</label></td>
						<td align="right"><label class="Validform_label"> 公务员级别工资: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].rankSalary1" maxlength="10" type="text" class="inputxt" value="${poVal.rankSalary1 }"> <label class="Validform_label"
							style="display: none;">公务员级别工资</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 公务员警衔津贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].policeRankSalary1" maxlength="10" type="text" class="inputxt" value="${poVal.policeRankSalary1 }"> <label
							class="Validform_label" style="display: none;">公务员警衔津贴</label></td>
						<td align="right"><label class="Validform_label"> 公务员职务补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].dutyExtra1" maxlength="10" type="text" class="inputxt" value="${poVal.dutyExtra1 }"> <label class="Validform_label"
							style="display: none;">公务员职务补贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 公务员年龄补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].ageExtra1" maxlength="10" type="text" class="inputxt" value="${poVal.ageExtra1 }"> <label class="Validform_label"
							style="display: none;">公务员年龄补贴</label></td>
						<td align="right"><label class="Validform_label"> 公务员工作年限补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].workAgeExtra1" maxlength="10" type="text" class="inputxt" value="${poVal.workAgeExtra1 }"> <label class="Validform_label"
							style="display: none;">公务员工作年限补贴</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 公务员提高退休费补贴: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].pensionUpgrade1" maxlength="10" type="text" class="inputxt" value="${poVal.pensionUpgrade1 }"> <label class="Validform_label"
							style="display: none;">公务员提高退休费补贴</label></td>
						<td align="right"><label class="Validform_label"> 公务员基本退休费: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].serventBasic1" maxlength="10" type="text" class="inputxt" value="${poVal.serventBasic1 }"> <label class="Validform_label"
							style="display: none;">公务员基本退休费</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 备注: </label></td>
						<td class="value"><input name="zformPersonRetireList[0].comments" maxlength="200" type="text" class="inputxt" value="${poVal.comments }"> <label class="Validform_label"
							style="display: none;">备注</label></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>