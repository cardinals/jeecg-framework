<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZformPersonSalaryBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZformPersonSalaryBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZformPersonSalaryBtn').bind('click', function(){   
 		 var tr =  $("#add_zformPersonSalary_table_template tr").clone();
	 	 $("#add_zformPersonSalary_table").append(tr);
	 	 resetTrNum('add_zformPersonSalary_table');
	 	 return false;
    });  
	$('#delZformPersonSalaryBtn').bind('click', function(){   
      	$("#add_zformPersonSalary_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zformPersonSalary_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zformPersonSalary_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZformPersonSalaryBtn" href="#">添加</a> <a id="delZformPersonSalaryBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zformPersonSalary_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
		<td align="left" bgcolor="#EEEEEE">序号</td>
		<td align="left" bgcolor="#EEEEEE">年度</td>
		<td align="left" bgcolor="#EEEEEE">变动原因</td>
		<td align="left" bgcolor="#EEEEEE">变动生效日期</td>
		<td align="left" bgcolor="#EEEEEE">原岗位</td>
		<td align="left" bgcolor="#EEEEEE">原岗位等级</td>
		<td align="left" bgcolor="#EEEEEE">原岗位类型</td>
		<td align="left" bgcolor="#EEEEEE">原岗位工资</td>
		<td align="left" bgcolor="#EEEEEE">原薪级</td>
		<td align="left" bgcolor="#EEEEEE">原薪级工资</td>
		<td align="left" bgcolor="#EEEEEE">原百分之十</td>
		<td align="left" bgcolor="#EEEEEE">新岗位</td>
		<td align="left" bgcolor="#EEEEEE">新岗位等级</td>
		<td align="left" bgcolor="#EEEEEE">新岗位类型</td>
		<td align="left" bgcolor="#EEEEEE">新岗位工资</td>
		<td align="left" bgcolor="#EEEEEE">新薪级</td>
		<td align="left" bgcolor="#EEEEEE">新薪级工资</td>
		<td align="left" bgcolor="#EEEEEE">新百分之十</td>
		<td align="left" bgcolor="#EEEEEE">备注</td>
	</tr>
	<tbody id="add_zformPersonSalary_table">
		<c:if test="${fn:length(zformPersonSalaryList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="zformPersonSalaryList[0].id" type="hidden" />
				<input name="zformPersonSalaryList[0].code" type="hidden" />
				<input name="zformPersonSalaryList[0].extra1" type="hidden" />
				<input name="zformPersonSalaryList[0].extra2" type="hidden" />
				<td align="left"><input name="zformPersonSalaryList[0].seqNo" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">序号</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].year" maxlength="10" type="text" class="inputxt" style="width:120px;" datatype="*"> <label
					class="Validform_label" style="display: none;">年度</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].changeReason" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">变动原因</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].effectiveDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;" datatype="*">
					<label class="Validform_label" style="display: none;">变动生效日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].prevJob" type="list" typeGroupCode="job" defaultVal="${zformPersonSalaryPage.prevJob}" hasLabel="false" title="原岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonSalaryPage.prevJobLevel}" hasLabel="false" title="原岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonSalaryPage.prevJobType}" hasLabel="false" title="原岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位类型</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].prevJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原岗位工资</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].prevRankLevel" type="list" typeGroupCode="rank" defaultVal="${zformPersonSalaryPage.prevRankLevel}" hasLabel="false" title="原薪级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原薪级</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].prevRankSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原薪级工资</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].prevExtraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原百分之十</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].newJob" type="list" typeGroupCode="job" defaultVal="${zformPersonSalaryPage.newJob}" hasLabel="false" title="新岗位"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonSalaryPage.newJobLevel}" hasLabel="false" title="新岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].newJobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonSalaryPage.newJobType}" hasLabel="false" title="新岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位类型</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].newJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新岗位工资</label></td>
				<td align="left"><t:dictSelect field="zformPersonSalaryList[0].newRankLevel" type="list" typeGroupCode="rank" defaultVal="${zformPersonSalaryPage.newRankLevel}" hasLabel="false" title="新薪级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新薪级</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].newRankSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新薪级工资</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].newExtraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新百分之十</label></td>
				<td align="left"><input name="zformPersonSalaryList[0].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(zformPersonSalaryList)  > 0 }">
			<c:forEach items="${zformPersonSalaryList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="zformPersonSalaryList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<input name="zformPersonSalaryList[${stuts.index }].code" type="hidden" value="${poVal.code }" />
					<input name="zformPersonSalaryList[${stuts.index }].extra1" type="hidden" value="${poVal.extra1 }" />
					<input name="zformPersonSalaryList[${stuts.index }].extra2" type="hidden" value="${poVal.extra2 }" />
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].seqNo" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.seqNo }"> <label
						class="Validform_label" style="display: none;">序号</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].year" maxlength="10" type="text" class="inputxt" style="width:120px;" datatype="*" value="${poVal.year }"> <label
						class="Validform_label" style="display: none;">年度</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].changeReason" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.changeReason }"> <label
						class="Validform_label" style="display: none;">变动原因</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].effectiveDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;" datatype="*"
						value="<fmt:formatDate value='${poVal.effectiveDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">变动生效日期</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].prevJob" type="list" typeGroupCode="job" defaultVal="${poVal.prevJob }" hasLabel="false" title="原岗位"></t:dictSelect>
						<label class="Validform_label" style="display: none;">原岗位</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.prevJobLevel }" hasLabel="false"
							title="原岗位等级"></t:dictSelect> <label class="Validform_label" style="display: none;">原岗位等级</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.prevJobType }" hasLabel="false"
							title="原岗位类型"></t:dictSelect> <label class="Validform_label" style="display: none;">原岗位类型</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].prevJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.prevJobSalary }"> <label
						class="Validform_label" style="display: none;">原岗位工资</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].prevRankLevel" type="list" typeGroupCode="rank" defaultVal="${poVal.prevRankLevel }" hasLabel="false" title="原薪级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">原薪级</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].prevRankSalary" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.prevRankSalary }">
						<label class="Validform_label" style="display: none;">原薪级工资</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].prevExtraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.prevExtraSalary }">
						<label class="Validform_label" style="display: none;">原百分之十</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].newJob" type="list" typeGroupCode="job" defaultVal="${poVal.newJob }" hasLabel="false" title="新岗位"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新岗位</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.newJobLevel }" hasLabel="false"
							title="新岗位等级"></t:dictSelect> <label class="Validform_label" style="display: none;">新岗位等级</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].newJobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.newJobType }" hasLabel="false" title="新岗位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新岗位类型</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].newJobSalary" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.newJobSalary }"> <label
						class="Validform_label" style="display: none;">新岗位工资</label></td>
					<td align="left"><t:dictSelect field="zformPersonSalaryList[${stuts.index }].newRankLevel" type="list" typeGroupCode="rank" defaultVal="${poVal.newRankLevel }" hasLabel="false" title="新薪级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新薪级</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].newRankSalary" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.newRankSalary }"> <label
						class="Validform_label" style="display: none;">新薪级工资</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].newExtraSalary" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.newExtraSalary }">
						<label class="Validform_label" style="display: none;">新百分之十</label></td>
					<td align="left"><input name="zformPersonSalaryList[${stuts.index }].comments" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.comments }"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
