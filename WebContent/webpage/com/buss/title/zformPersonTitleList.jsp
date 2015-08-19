<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZformPersonTitleBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZformPersonTitleBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZformPersonTitleBtn').bind('click', function(){   
 		 var tr =  $("#add_zformPersonTitle_table_template tr").clone();
	 	 $("#add_zformPersonTitle_table").append(tr);
	 	 resetTrNum('add_zformPersonTitle_table');
	 	 return false;
    });  
	$('#delZformPersonTitleBtn').bind('click', function(){   
      	$("#add_zformPersonTitle_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zformPersonTitle_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zformPersonTitle_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZformPersonTitleBtn" href="#">添加</a> <a id="delZformPersonTitleBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zformPersonTitle_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
		<td align="left" bgcolor="#EEEEEE">原职称</td>
		<td align="left" bgcolor="#EEEEEE">原职称扩充</td>
		<td align="left" bgcolor="#EEEEEE">原岗位</td>
		<td align="left" bgcolor="#EEEEEE">原岗位扩充</td>
		<td align="left" bgcolor="#EEEEEE">原岗位等级</td>
		<td align="left" bgcolor="#EEEEEE">原岗位类型</td>
		<td align="left" bgcolor="#EEEEEE">新职称</td>
		<td align="left" bgcolor="#EEEEEE">新职称扩充</td>
		<td align="left" bgcolor="#EEEEEE">新岗位</td>
		<td align="left" bgcolor="#EEEEEE">新岗位扩充</td>
		<td align="left" bgcolor="#EEEEEE">新岗位等级</td>
		<td align="left" bgcolor="#EEEEEE">新岗位类型</td>
		<td align="left" bgcolor="#EEEEEE">职务变动原因</td>
		<td align="left" bgcolor="#EEEEEE">职务变动生效日期</td>
		<td align="left" bgcolor="#EEEEEE">备注</td>
	</tr>
	<tbody id="add_zformPersonTitle_table">
		<c:if test="${fn:length(zformPersonTitleList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="zformPersonTitleList[0].id" type="hidden" />
				<input name="zformPersonTitleList[0].code" type="hidden" />
				<input name="zformPersonTitleList[0].extra1" type="hidden" />
				<input name="zformPersonTitleList[0].extra2" type="hidden" />
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].prevTitle" type="list" typeGroupCode="title" defaultVal="" hasLabel="false" title="原职称"></t:dictSelect>
					<label class="Validform_label" style="display: none;">原职称</label></td>
				<td align="left"><input name="zformPersonTitleList[0].prevTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label class="Validform_label"
					style="display: none;">原职称扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].prevJob" type="list" typeGroupCode="job" defaultVal="${zformPersonTitlePage.prevJob}" hasLabel="false" title="原岗位"></t:dictSelect>
					<label class="Validform_label" style="display: none;">原岗位</label></td>
				<td align="left"><input name="zformPersonTitleList[0].prevJobExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label class="Validform_label"
					style="display: none;">原岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonTitlePage.prevJobLevel}" hasLabel="false"
						title="原岗位等级"></t:dictSelect> <label class="Validform_label" style="display: none;">原岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonTitlePage.prevJobType}" hasLabel="false" title="原岗位类型"></t:dictSelect>
					<label class="Validform_label" style="display: none;">原岗位类型</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].newTitle" type="list" typeGroupCode="title" defaultVal="${zformPersonTitlePage.newTitle}" hasLabel="false" title="新职称"></t:dictSelect>
					<label class="Validform_label" style="display: none;">新职称</label></td>
				<td align="left"><input name="zformPersonTitleList[0].newTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label class="Validform_label"
					style="display: none;">新职称扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].newJob" type="list" typeGroupCode="job" defaultVal="${zformPersonTitlePage.newJob}" hasLabel="false" title="新岗位"></t:dictSelect>
					<label class="Validform_label" style="display: none;">新岗位</label></td>
				<td align="left"><input name="zformPersonTitleList[0].newJobExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label class="Validform_label"
					style="display: none;">新岗位扩充</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonTitlePage.newJobLevel}" hasLabel="false" title="新岗位等级"></t:dictSelect>
					<label class="Validform_label" style="display: none;">新岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonTitleList[0].newJobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonTitlePage.newJobType}" hasLabel="false" title="新岗位类型"></t:dictSelect>
					<label class="Validform_label" style="display: none;">新岗位类型</label></td>
				<td align="left"><input name="zformPersonTitleList[0].changeReason" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label class="Validform_label"
					style="display: none;">职务变动原因</label></td>
				<td align="left"><input name="zformPersonTitleList[0].effectiveDate" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;" datatype="*"> <label
					class="Validform_label" style="display: none;">职务变动生效日期</label></td>
				<td align="left"><input name="zformPersonTitleList[0].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(zformPersonTitleList)  > 0 }">
			<c:forEach items="${zformPersonTitleList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="zformPersonTitleList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<input name="zformPersonTitleList[${stuts.index }].code" type="hidden" value="${poVal.code }" />
					<input name="zformPersonTitleList[${stuts.index }].extra1" type="hidden" value="${poVal.extra1 }" />
					<input name="zformPersonTitleList[${stuts.index }].extra2" type="hidden" value="${poVal.extra2 }" />
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].prevTitle" type="list" typeGroupCode="title" defaultVal="${poVal.prevTitle }" hasLabel="false" title="原职称"></t:dictSelect>
						<label class="Validform_label" style="display: none;">原职称</label></td>
					<td align="left"><input name="zformPersonTitleList[${stuts.index }].prevTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.prevTitleExtra }">
						<label class="Validform_label" style="display: none;">原职称扩充</label></td>
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].prevJob" type="list" typeGroupCode="job" defaultVal="${poVal.prevJob }" hasLabel="false" title="原岗位"></t:dictSelect>
						<label class="Validform_label" style="display: none;">原岗位</label></td>
					<td align="left"><input name="zformPersonTitleList[${stuts.index }].prevJobExtra" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.prevJobExtra }"> <label
						class="Validform_label" style="display: none;">原岗位扩充</label></td>
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].prevJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.prevJobLevel }" hasLabel="false"
							title="原岗位等级"></t:dictSelect> <label class="Validform_label" style="display: none;">原岗位等级</label></td>
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].prevJobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.prevJobType }" hasLabel="false" title="原岗位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">原岗位类型</label></td>
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].newTitle" type="list" typeGroupCode="title" defaultVal="${poVal.newTitle }" hasLabel="false" title="新职称"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新职称</label></td>
					<td align="left"><input name="zformPersonTitleList[${stuts.index }].newTitleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.newTitleExtra }"> <label
						class="Validform_label" style="display: none;">新职称扩充</label></td>
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].newJob" type="list" typeGroupCode="job" defaultVal="${poVal.newJob }" hasLabel="false" title="新岗位"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新岗位</label></td>
					<td align="left"><input name="zformPersonTitleList[${stuts.index }].newJobExtra" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.newJobExtra }"> <label
						class="Validform_label" style="display: none;">新岗位扩充</label></td>
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].newJobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.newJobLevel }" hasLabel="false"
							title="新岗位等级"></t:dictSelect> <label class="Validform_label" style="display: none;">新岗位等级</label></td>
					<td align="left"><t:dictSelect field="zformPersonTitleList[${stuts.index }].newJobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.newJobType }" hasLabel="false" title="新岗位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">新岗位类型</label></td>
					<td align="left"><input name="zformPersonTitleList[${stuts.index }].changeReason" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.changeReason }"> <label
						class="Validform_label" style="display: none;">职务变动原因</label></td>
					<td align="left"><input name="zformPersonTitleList[${stuts.index }].effectiveDate" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;" datatype="*"
						value="<fmt:formatDate value='${poVal.effectiveDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">职务变动生效日期</label></td>
					<td align="left"><input name="zformPersonTitleList[${stuts.index }].comments" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.comments }"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
