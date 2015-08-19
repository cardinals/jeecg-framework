<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZformPersonExamBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZformPersonExamBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZformPersonExamBtn').bind('click', function(){   
 		 var tr =  $("#add_zformPersonExam_table_template tr").clone();
	 	 $("#add_zformPersonExam_table").append(tr);
	 	 resetTrNum('add_zformPersonExam_table');
	 	 return false;
    });  
	$('#delZformPersonExamBtn').bind('click', function(){   
      	$("#add_zformPersonExam_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zformPersonExam_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zformPersonExam_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZformPersonExamBtn" href="#">添加</a> <a id="delZformPersonExamBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zformPersonExam_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
		<td align="left" bgcolor="#EEEEEE">学校名称</td>
		<td align="left" bgcolor="#EEEEEE">年度</td>
		<td align="left" bgcolor="#EEEEEE">技术职称</td>
		<td align="left" bgcolor="#EEEEEE">职称扩充</td>
		<td align="left" bgcolor="#EEEEEE">行政职务</td>
		<td align="left" bgcolor="#EEEEEE">岗位名称</td>
		<td align="left" bgcolor="#EEEEEE">岗位等级</td>
		<td align="left" bgcolor="#EEEEEE">岗位类型</td>
		<td align="left" bgcolor="#EEEEEE">量化考核分数</td>
		<td align="left" bgcolor="#EEEEEE">民主测评结果</td>
		<td align="left" bgcolor="#EEEEEE">最终考核结果</td>
		<td align="left" bgcolor="#EEEEEE">备注</td>
	</tr>
	<tbody id="add_zformPersonExam_table">
		<c:if test="${fn:length(zformPersonExamList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="zformPersonExamList[0].id" type="hidden" />
				<input name="zformPersonExamList[0].code" type="hidden" />
				<input name="zformPersonExamList[0].extra1" type="hidden" />
				<input name="zformPersonExamList[0].extra2" type="hidden" />
				<td align="left"><t:dictSelect field="zformPersonExamList[0].schoolCode" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${zformPersonExamPage.schoolCode}" hasLabel="false"
						title="学校名称"></t:dictSelect> <label class="Validform_label" style="display: none;">学校名称</label></td>
				<td align="left"><input name="zformPersonExamList[0].year" maxlength="10" type="text" class="inputxt" style="width:120px;" datatype="*"> <label
					class="Validform_label" style="display: none;">年度</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[0].title" type="list" typeGroupCode="title" defaultVal="${zformPersonExamPage.title}" hasLabel="false" title="技术职称"></t:dictSelect> <label
					class="Validform_label" style="display: none;">技术职称</label></td>
				<td align="left"><input name="zformPersonExamList[0].titleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">职称扩充</label></td>
				<td align="left"><input name="zformPersonExamList[0].executiveTitle" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">行政职务</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[0].job" type="list" typeGroupCode="job" defaultVal="${zformPersonExamPage.job}" hasLabel="false" title="岗位名称"></t:dictSelect> <label class="Validform_label"
					style="display: none;">岗位名称</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[0].jobLevel" type="list" typeGroupCode="joblevel" defaultVal="${zformPersonExamPage.jobLevel}" hasLabel="false" title="岗位等级"></t:dictSelect> <label
					class="Validform_label" style="display: none;">岗位等级</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[0].jobType" type="list" typeGroupCode="jobtype" defaultVal="${zformPersonExamPage.jobType}" hasLabel="false" title="岗位类型"></t:dictSelect> <label
					class="Validform_label" style="display: none;">岗位类型</label></td>
				<td align="left"><input name="zformPersonExamList[0].score" maxlength="10" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">量化考核分数</label></td>
				<td align="left"><input name="zformPersonExamList[0].voteReview" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">民主测评结果</label></td>
				<td align="left"><t:dictSelect field="zformPersonExamList[0].finalResult" type="list" typeGroupCode="exam_r" defaultVal="${zformPersonExamPage.finalResult}" hasLabel="false" title="最终考核结果"></t:dictSelect> <label
					class="Validform_label" style="display: none;">最终考核结果</label></td>
				<td align="left"><input name="zformPersonExamList[0].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(zformPersonExamList)  > 0 }">
			<c:forEach items="${zformPersonExamList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="zformPersonExamList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<input name="zformPersonExamList[${stuts.index }].code" type="hidden" value="${poVal.code }" />
					<input name="zformPersonExamList[${stuts.index }].extra1" type="hidden" value="${poVal.extra1 }" />
					<input name="zformPersonExamList[${stuts.index }].extra2" type="hidden" value="${poVal.extra2 }" />
					<td align="left"><t:dictSelect field="zformPersonExamList[${stuts.index }].schoolCode" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${poVal.schoolCode }"
							hasLabel="false" title="学校名称"></t:dictSelect> <label class="Validform_label" style="display: none;">学校名称</label></td>
					<td align="left"><input name="zformPersonExamList[${stuts.index }].year" maxlength="10" type="text" class="inputxt" style="width:120px;" datatype="*" value="${poVal.year }"> <label
						class="Validform_label" style="display: none;">年度</label></td>
					<td align="left"><t:dictSelect field="zformPersonExamList[${stuts.index }].title" type="list" typeGroupCode="title" defaultVal="${poVal.title }" hasLabel="false" title="技术职称"></t:dictSelect>
						<label class="Validform_label" style="display: none;">技术职称</label></td>
					<td align="left"><input name="zformPersonExamList[${stuts.index }].titleExtra" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.titleExtra }"> <label
						class="Validform_label" style="display: none;">职称扩充</label></td>
					<td align="left"><input name="zformPersonExamList[${stuts.index }].executiveTitle" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.executiveTitle }">
						<label class="Validform_label" style="display: none;">行政职务</label></td>
					<td align="left"><t:dictSelect field="zformPersonExamList[${stuts.index }].job" type="list" typeGroupCode="job" defaultVal="${poVal.job }" hasLabel="false" title="岗位名称"></t:dictSelect> <label
						class="Validform_label" style="display: none;">岗位名称</label></td>
					<td align="left"><t:dictSelect field="zformPersonExamList[${stuts.index }].jobLevel" type="list" typeGroupCode="joblevel" defaultVal="${poVal.jobLevel }" hasLabel="false" title="岗位等级"></t:dictSelect>
						<label class="Validform_label" style="display: none;">岗位等级</label></td>
					<td align="left"><t:dictSelect field="zformPersonExamList[${stuts.index }].jobType" type="list" typeGroupCode="jobtype" defaultVal="${poVal.jobType }" hasLabel="false" title="岗位类型"></t:dictSelect>
						<label class="Validform_label" style="display: none;">岗位类型</label></td>
					<td align="left"><input name="zformPersonExamList[${stuts.index }].score" maxlength="10" type="text" class="inputxt" style="width:120px;" value="${poVal.score }"> <label
						class="Validform_label" style="display: none;">量化考核分数</label></td>
					<td align="left"><input name="zformPersonExamList[${stuts.index }].voteReview" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.voteReview }"> <label
						class="Validform_label" style="display: none;">民主测评结果</label></td>
					<td align="left"><t:dictSelect field="zformPersonExamList[${stuts.index }].finalResult" type="list" typeGroupCode="exam_r" defaultVal="${poVal.finalResult }" hasLabel="false" title="最终考核结果"></t:dictSelect>
						<label class="Validform_label" style="display: none;">最终考核结果</label></td>
					<td align="left"><input name="zformPersonExamList[${stuts.index }].comments" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.comments }"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
