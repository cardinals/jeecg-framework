<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZformPersonJobBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZformPersonJobBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZformPersonJobBtn').bind('click', function(){   
 		 var tr =  $("#add_zformPersonJob_table_template tr").clone();
	 	 $("#add_zformPersonJob_table").append(tr);
	 	 resetTrNum('add_zformPersonJob_table');
	 	 return false;
    });  
	$('#delZformPersonJobBtn').bind('click', function(){   
      	$("#add_zformPersonJob_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zformPersonJob_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zformPersonJob_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZformPersonJobBtn" href="#">添加</a> <a id="delZformPersonJobBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zformPersonJob_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
		<td align="left" bgcolor="#EEEEEE">学年度</td>
		<td align="left" bgcolor="#EEEEEE">原岗位名称</td>
		<td align="left" bgcolor="#EEEEEE">原岗位等级</td>
		<td align="left" bgcolor="#EEEEEE">原岗位扩充</td>
		<td align="left" bgcolor="#EEEEEE">原岗位类型</td>
		<td align="left" bgcolor="#EEEEEE">原任职年限</td>		
		<td align="left" bgcolor="#EEEEEE">原专技职务聘用日期</td>
		<td align="left" bgcolor="#EEEEEE">新职称</td>
		<td align="left" bgcolor="#EEEEEE">新职称扩充</td>
		<td align="left" bgcolor="#EEEEEE">新岗位名称</td>
		<td align="left" bgcolor="#EEEEEE">新岗位扩充</td>
		<td align="left" bgcolor="#EEEEEE">新岗位等级</td>
		<td align="left" bgcolor="#EEEEEE">新岗位类型</td>		
		<td align="left" bgcolor="#EEEEEE">新岗位起聘日期</td>
		<td align="left" bgcolor="#EEEEEE">新岗位止聘日期</td>
		<td align="left" bgcolor="#EEEEEE">岗位变动原因</td>
		<td align="left" bgcolor="#EEEEEE">备注</td>
	</tr>
	<tbody id="add_zformPersonJob_table">
		<c:if test="${fn:length(zformPersonJobList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="zformPersonJobList[0].id" type="hidden" />
				<input name="zformPersonJobList[0].code" type="hidden" />
				<input name="zformPersonJobList[0].extra1" type="hidden" />
				<input name="zformPersonJobList[0].extra2" type="hidden" />
				<td align="left"><input name="zformPersonJobList[0].year" maxlength="20" type="text" class="inputxt" style="width:120px;" datatype="*"> <label
					class="Validform_label" style="display: none;">学年度</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[0].prevJob" type="list" typeGroupCode="job" defaultVal="${zformPersonJobPage.prevJob}" hasLabel="false" title="原岗位名称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位名称</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[0].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonJobPage.prevJobLevel}" hasLabel="false" title="原岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位等级</label></td>
				<td align="left"><input name="zformPersonJobList[0].prevJobExtra" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[0].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonJobPage.prevJobType}" hasLabel="false" title="原岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">原岗位类型</label></td>
				<td align="left"><input name="zformPersonJobList[0].prevWorkAge" maxlength="100" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">原任职年限</label></td>
				<td align="left"><input name="zformPersonJobList[0].prevTitleWorkDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">原专技职务聘用日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[0].newTitle" type="list" typeGroupCode="title" defaultVal="${zformPersonJobPage.newTitle}" hasLabel="false" title="新职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新职称</label></td>
				<td align="left"><input name="zformPersonJobList[0].newTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新职称扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[0].newJob" type="list" typeGroupCode="job" defaultVal="${zformPersonJobPage.newJob}" hasLabel="false" title="新岗位名称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位名称</label></td>
				<td align="left"><input name="zformPersonJobList[0].newJobExtra" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">新岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[0].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonJobPage.newJobLevel}" hasLabel="false" title="新岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonJobList[0].newJobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonJobPage.newJobType}" hasLabel="false" title="新岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">新岗位类型</label></td>
				<td align="left"><input name="zformPersonJobList[0].newJobStartDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">新岗位起聘日期</label></td>
				<td align="left"><input name="zformPersonJobList[0].newJobEndDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">新岗位止聘日期</label></td>
				<td align="left"><input name="zformPersonJobList[0].jobChangeReason" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">岗位变动原因</label></td>
				<td align="left"><input name="zformPersonJobList[0].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(zformPersonJobList)  > 0 }">
			<c:forEach items="${zformPersonJobList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="zformPersonJobList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<input name="zformPersonJobList[${stuts.index }].code" type="hidden" value="${poVal.code }" />
					<input name="zformPersonJobList[${stuts.index }].extra1" type="hidden" value="${poVal.extra1 }" />
					<input name="zformPersonJobList[${stuts.index }].extra2" type="hidden" value="${poVal.extra2 }" />
					<td align="left"><input name="zformPersonJobList[${stuts.index }].year" maxlength="20" type="text" class="inputxt" style="width:120px;" datatype="*" value="${poVal.year }"> <label
						class="Validform_label" style="display: none;">学年度</label></td>
					<td align="left"><t:dictSelect field="zformPersonJobList[${stuts.index }].prevJob" type="list" typeGroupCode="job" defaultVal="${poVal.prevJob }" hasLabel="false" title="原岗位名称"></t:dictSelect>
						<label class="Validform_label" style="display: none;">原岗位名称</label></td>
					<td align="left"><t:dictSelect field="zformPersonJobList[${stuts.index }].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.prevJobLevel }" hasLabel="false"
							title="原岗位等级"></t:dictSelect> <label class="Validform_label" style="display: none;">原岗位等级</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].prevJobExtra" maxlength="32" type="text" class="inputxt" style="width:120px;" value="${poVal.prevJobExtra }"> <label
						class="Validform_label" style="display: none;">原岗位扩充</label></td>
					<td align="left"><t:dictSelect field="zformPersonJobList[${stuts.index }].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.prevJobType }" hasLabel="false" title="原岗位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">原岗位类型</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].prevWorkAge" maxlength="100" type="text" class="inputxt" style="width:120px;" value="${poVal.prevWorkAge }"> <label
						class="Validform_label" style="display: none;">原任职年限</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].prevTitleWorkDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.prevTitleWorkDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">原专技职务聘用日期</label></td>
					<td align="left"><t:dictSelect field="zformPersonJobList[${stuts.index }].newTitle" type="list" typeGroupCode="title" defaultVal="${poVal.newTitle }" hasLabel="false" title="新职称"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新职称</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].newTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.newTitleExtra }"> <label
						class="Validform_label" style="display: none;">新职称扩充</label></td>
					<td align="left"><t:dictSelect field="zformPersonJobList[${stuts.index }].newJob" type="list" typeGroupCode="job" defaultVal="${poVal.newJob }" hasLabel="false" title="新岗位名称"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新岗位名称</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].newJobExtra" maxlength="32" type="text" class="inputxt" style="width:120px;" value="${poVal.newJobExtra }"> <label
						class="Validform_label" style="display: none;">新岗位扩充</label></td>
					<td align="left"><t:dictSelect field="zformPersonJobList[${stuts.index }].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.newJobLevel }" hasLabel="false" title="新岗位等级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新岗位等级</label></td>
					<td align="left"><t:dictSelect field="zformPersonJobList[${stuts.index }].newJobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.newJobType }" hasLabel="false" title="新岗位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新岗位类型</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].newJobStartDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.newJobStartDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">新岗位起聘日期</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].newJobEndDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.newJobEndDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">新岗位止聘日期</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].jobChangeReason" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.jobChangeReason }">
						<label class="Validform_label" style="display: none;">岗位变动原因</label></td>
					<td align="left"><input name="zformPersonJobList[${stuts.index }].comments" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.comments }"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
