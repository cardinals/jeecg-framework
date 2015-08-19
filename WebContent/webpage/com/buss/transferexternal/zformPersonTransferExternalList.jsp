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
	<table cellpadding="0" cellspacing="1" class="formtable" id="zformPersonTransferExternal_table">
		<tbody id="add_zformPersonTransferExternal_table">
			<c:if test="${fn:length(zformPersonTransferExternalList)  <= 0 }">
				<tr>
					<input name="zformPersonTransferExternalList[0].id" type="hidden" value="${poVal.id}" />
					<input name="zformPersonTransferExternalList[0].code" type="hidden" value="${poVal.code}" />
					<input name="zformPersonTransferExternalList[0].extra2" type="hidden" value="${poVal.extra2}" />
					<input name="zformPersonTransferExternalList[0].extra3" type="hidden" value="${poVal.extra3}" />
					<input name="zformPersonTransferExternalList[0].extra4" type="hidden" value="${poVal.extra4}" />
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 调出单位: </label></td>
					<td class="value"><t:dictSelect field="zformPersonTransferExternalList[0].fromSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${zformPersonTransferExternalPage.fromSchool}"
							hasLabel="false" title="调出单位"></t:dictSelect> <label class="Validform_label" style="display: none;">调出单位</label></td>
					<td align="right"><label class="Validform_label"> 调往单位: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].toSchool" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">调往单位</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 调往单位所在区县: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].toSchoolAddress" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">调往单位所在区县</label></td>
					<td align="right"><label class="Validform_label"> 干部介绍信编号: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].refLetterNo" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">干部介绍信编号</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 干部介绍信开具日期: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].refLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()">
						<label class="Validform_label" style="display: none;">干部介绍信开具日期</label></td>
					<td align="right"><label class="Validform_label"> 工资止薪日期: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].salaryEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()">
						<label class="Validform_label" style="display: none;">工资止薪日期</label></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 调动原因: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].transferReason" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">调动原因</label></td>
					<td align="right"><label class="Validform_label"> 合同情况: </label></td>
					<td class="value"><t:dictSelect field="zformPersonTransferExternalList[0].extra1" type="list" typeGroupCode="contract" defaultVal="${zformPersonTransferExternalPage.extra1}" hasLabel="false" title="合同情况"></t:dictSelect>
						<label class="Validform_label" style="display: none;">合同情况</label></td>	
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 违约金情况: </label></td>
					<td class="value"><t:dictSelect field="zformPersonTransferExternalList[0].penalityStatus" type="list" typeGroupCode="penality" defaultVal="${zformPersonTransferExternalPage.penalityStatus}" hasLabel="false" title="违约金情况"></t:dictSelect>
						<label class="Validform_label" style="display: none;">违约金情况</label></td>
					<td align="right"><label class="Validform_label"> 违约金数额: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].penalityAmount" maxlength="10" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">违约金数额</label></td>
				</tr>
				<tr>					
					<td align="right"><label class="Validform_label"> 备注: </label></td>
					<td class="value"><input name="zformPersonTransferExternalList[0].comments" maxlength="200" type="text" class="inputxt"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:if>
			<c:if test="${fn:length(zformPersonTransferExternalList)  > 0 }">
				<c:forEach items="${zformPersonTransferExternalList}" var="poVal" varStatus="stuts" begin="0" end="0">
					<tr>
						<input name="zformPersonTransferExternalList[0].id" type="hidden" value="${poVal.id}" />
						<input name="zformPersonTransferExternalList[0].code" type="hidden" value="${poVal.code}" />						
						<input name="zformPersonTransferExternalList[0].extra2" type="hidden" value="${poVal.extra2}" />
						<input name="zformPersonTransferExternalList[0].extra3" type="hidden" value="${poVal.extra3}" />
						<input name="zformPersonTransferExternalList[0].extra4" type="hidden" value="${poVal.extra4}" />
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 调出单位: </label></td>
						<td class="value"><t:dictSelect field="zformPersonTransferExternalList[0].fromSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${poVal.fromSchool}"
								hasLabel="false" title="调出单位"></t:dictSelect> <label class="Validform_label" style="display: none;">调出单位</label></td>
						<td align="right"><label class="Validform_label"> 调往单位: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].toSchool" maxlength="200" type="text" class="inputxt" value="${poVal.toSchool }"> <label class="Validform_label"
							style="display: none;">调往单位</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 调往单位所在区县: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].toSchoolAddress" maxlength="200" type="text" class="inputxt" value="${poVal.toSchoolAddress }"> <label
							class="Validform_label" style="display: none;">调往单位所在区县</label></td>
						<td align="right"><label class="Validform_label"> 干部介绍信编号: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].refLetterNo" maxlength="200" type="text" class="inputxt" value="${poVal.refLetterNo }"> <label
							class="Validform_label" style="display: none;">干部介绍信编号</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 干部介绍信开具日期: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].refLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.refLetterDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">干部介绍信开具日期</label></td>
						<td align="right"><label class="Validform_label"> 工资止薪日期: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].salaryEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"
							value="<fmt:formatDate value='${poVal.salaryEndDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">工资止薪日期</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 调动原因: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].transferReason" maxlength="200" type="text" class="inputxt" value="${poVal.transferReason }"> <label
							class="Validform_label" style="display: none;">调动原因</label></td>
						<td align="right"><label class="Validform_label"> 合同情况: </label></td>
						<td class="value"><t:dictSelect field="zformPersonTransferExternalList[0].extra1" type="list" typeGroupCode="contract" defaultVal="${poVal.extra1}" hasLabel="false" title="合同情况"></t:dictSelect>
							<label class="Validform_label" style="display: none;">合同情况</label></td>	
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 违约金情况: </label></td>
						<td class="value"><t:dictSelect field="penalityStatus" type="list" typeGroupCode="penality" defaultVal="${poVal.penalityStatus}" hasLabel="false" title="违约金情况"></t:dictSelect>
							<label class="Validform_label" style="display: none;">违约金情况</label></td>
						<td align="right"><label class="Validform_label"> 违约金数额: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].penalityAmount" maxlength="10" type="text" class="inputxt" value="${poVal.penalityAmount }"> <label
							class="Validform_label" style="display: none;">违约金数额</label></td>
					</tr>
					<tr>
						<td align="right"><label class="Validform_label"> 备注: </label></td>
						<td class="value"><input name="zformPersonTransferExternalList[0].comments" maxlength="200" type="text" class="inputxt" value="${poVal.comments }"> <label class="Validform_label"
							style="display: none;">备注</label></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>