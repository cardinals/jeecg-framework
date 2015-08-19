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
	<table cellpadding="0" cellspacing="1" class="formtable" id="zformPersonDeath_table">
		<tbody id="add_zformPersonDeath_table">
			<c:if test="${fn:length(zformPersonDeathList)  <= 0 }">
				<tr>
					<input name="zformPersonDeathList[0].id" type="hidden" value="${poVal.id}" />
					<input name="zformPersonDeathList[0].code" type="hidden" value="${poVal.code}" />
					<input name="zformPersonDeathList[0].extra1" type="hidden" value="${poVal.extra1}" />
					<input name="zformPersonDeathList[0].extra2" type="hidden" value="${poVal.extra2}" />
					<input name="zformPersonDeathList[0].extra3" type="hidden" value="${poVal.extra3}" />
					<input name="zformPersonDeathList[0].extra4" type="hidden" value="${poVal.extra4}" />
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 死亡日期: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].deathDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">死亡日期</label></td>
					<td align="right"><label class="Validform_label"> 死亡审批日期: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].auditDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"> <label
						class="Validform_label" style="display: none;">死亡审批日期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 死亡原因: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].deathReason" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">死亡原因</label></td>
					<td align="right"><label class="Validform_label"> 丧葬费: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].funeralExp" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">丧葬费</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 基本工资: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].basicSalary" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">基本工资</label></td>
					<td align="right"><label class="Validform_label"> 上年度人均支配收入: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].stateIncomeAvg" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">上年度人均支配收入</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 抚恤金合计: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].pension" maxlength="10" type="text" class="inputxt"> <label class="Validform_label"
						style="display: none;">抚恤金合计</label></td>
					<td align="right"><label class="Validform_label"> 丧抚费总金额: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].funeralExpTotal" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">丧抚费总金额</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 备注: </label></td>
					<td class="value"><input name="zformPersonDeathList[0].comments" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:if>
			<c:if test="${fn:length(zformPersonDeathList)  > 0 }">
				<c:forEach items="${zformPersonDeathList}" var="poVal" varStatus="stuts" begin="0" end="0">
					<tr>
						<input name="zformPersonDeathList[0].id" type="hidden" value="${poVal.id}" />
						<input name="zformPersonDeathList[0].code" type="hidden" value="${poVal.code}" />
						<input name="zformPersonDeathList[0].extra1" type="hidden" value="${poVal.extra1}" />
						<input name="zformPersonDeathList[0].extra2" type="hidden" value="${poVal.extra2}" />
						<input name="zformPersonDeathList[0].extra3" type="hidden" value="${poVal.extra3}" />
						<input name="zformPersonDeathList[0].extra4" type="hidden" value="${poVal.extra4}" />
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 死亡日期: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].deathDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.deathDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">死亡日期</label></td>
						<td align="right"><label class="Validform_label"> 死亡审批日期: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].auditDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.auditDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">死亡审批日期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 死亡原因: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].deathReason" maxlength="200" type="text" class="inputxt" value="${poVal.deathReason }"> <label class="Validform_label"
							style="display: none;">死亡原因</label></td>
						<td align="right"><label class="Validform_label"> 丧葬费: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].funeralExp" maxlength="10" type="text" class="inputxt" value="${poVal.funeralExp }"> <label class="Validform_label"
							style="display: none;">丧葬费</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 基本工资: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].basicSalary" maxlength="10" type="text" class="inputxt" value="${poVal.basicSalary }"> <label class="Validform_label"
							style="display: none;">基本工资</label></td>
						<td align="right"><label class="Validform_label"> 上年度人均支配收入: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].stateIncomeAvg" maxlength="10" type="text" class="inputxt" value="${poVal.stateIncomeAvg }"> <label class="Validform_label"
							style="display: none;">上年度人均支配收入</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 抚恤金合计: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].pension" maxlength="10" type="text" class="inputxt" value="${poVal.pension }"> <label class="Validform_label"
							style="display: none;">抚恤金合计</label></td>
						<td align="right"><label class="Validform_label"> 丧抚费总金额: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].funeralExpTotal" maxlength="10" type="text" class="inputxt" value="${poVal.funeralExpTotal }"> <label class="Validform_label"
							style="display: none;">丧抚费总金额</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 备注: </label></td>
						<td class="value"><input name="zformPersonDeathList[0].comments" maxlength="200" type="text" class="inputxt" value="${poVal.comments }"> <label class="Validform_label"
							style="display: none;">备注</label></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>