<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZformPersonTransferInnerBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZformPersonTransferInnerBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZformPersonTransferInnerBtn').bind('click', function(){   
 		 var tr =  $("#add_zformPersonTransferInner_table_template tr").clone();
	 	 $("#add_zformPersonTransferInner_table").append(tr);
	 	 resetTrNum('add_zformPersonTransferInner_table');
	 	 return false;
    });  
	$('#delZformPersonTransferInnerBtn').bind('click', function(){   
      	$("#add_zformPersonTransferInner_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zformPersonTransferInner_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zformPersonTransferInner_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZformPersonTransferInnerBtn" href="#">添加</a> <a id="delZformPersonTransferInnerBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zformPersonTransferInner_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
		<td align="left" bgcolor="#EEEEEE">调出学校</td>
		<td align="left" bgcolor="#EEEEEE">调入学校</td>
		<td align="left" bgcolor="#EEEEEE">调动日期</td>
		<td align="left" bgcolor="#EEEEEE">商调函日期</td>
		<td align="left" bgcolor="#EEEEEE">调干通知书日期</td>
		<td align="left" bgcolor="#EEEEEE">干部介绍信日期</td>
		<td align="left" bgcolor="#EEEEEE">原单位止薪日期</td>
		<td align="left" bgcolor="#EEEEEE">调动原因</td>
		<td align="left" bgcolor="#EEEEEE">调出前职称</td>
		<td align="left" bgcolor="#EEEEEE">是否组织任命</td>
		<td align="left" bgcolor="#EEEEEE">备注</td>
		<td align="left" bgcolor="#EEEEEE">调动状态</td>
	</tr>
	<tbody id="add_zformPersonTransferInner_table">
		<c:if test="${fn:length(zformPersonTransferInnerList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="zformPersonTransferInnerList[0].id" type="hidden" />
				<input name="zformPersonTransferInnerList[0].code" type="hidden" />
				<input name="zformPersonTransferInnerList[0].extra1" type="hidden" />
				<input name="zformPersonTransferInnerList[0].extra2" type="hidden" />
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[0].fromSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${zformPersonTransferInnerPage.fromSchool}"
						hasLabel="false" title="调出学校"></t:dictSelect> <label class="Validform_label" style="display: none;">调出学校</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[0].toSchool" type="list" dictTable="zform_school" dictField="code" dictText="name" defaultVal="${zformPersonTransferInnerPage.toSchool}" hasLabel="false"
						title="调入学校"></t:dictSelect> <label class="Validform_label" style="display: none;">调入学校</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[0].transferDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">调动日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[0].transferLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">商调函日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[0].notifyLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">调干通知书日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[0].refLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">干部介绍信日期</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[0].salaryEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">原单位止薪日期</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[0].transferReason" type="list" typeGroupCode="trans_r" defaultVal="${zformPersonTransferInnerPage.transferReason}" hasLabel="false" title="调动原因"></t:dictSelect>
					<label class="Validform_label" style="display: none;">调动原因</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[0].transferTitle" type="list" typeGroupCode="title" defaultVal="${zformPersonTransferInnerPage.transferTitle}" hasLabel="false" title="调出前职称"></t:dictSelect>
					<label class="Validform_label" style="display: none;">调出前职称</label></td>
				<td align="left"><t:dictSelect field="zformPersonTransferInnerList[0].nominate" type="list" typeGroupCode="yesorno" defaultVal="${zformPersonTransferInnerPage.nominate}" hasLabel="false" title="是否组织任命"></t:dictSelect> <label
					class="Validform_label" style="display: none;">是否组织任命</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[0].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
				<td align="left"><input name="zformPersonTransferInnerList[0].transferStatus" maxlength="100" type="text" class="inputxt" style="width:120px;">
					<label class="Validform_label" style="display: none;">调动状态</label></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(zformPersonTransferInnerList)  > 0 }">
			<c:forEach items="${zformPersonTransferInnerList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="zformPersonTransferInnerList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<input name="zformPersonTransferInnerList[${stuts.index }].code" type="hidden" value="${poVal.code }" />
					<input name="zformPersonTransferInnerList[${stuts.index }].extra1" type="hidden" value="${poVal.extra1 }" />
					<input name="zformPersonTransferInnerList[${stuts.index }].extra2" type="hidden" value="${poVal.extra2 }" />
					<td align="left"><t:dictSelect field="zformPersonTransferInnerList[${stuts.index }].fromSchool" type="list" dictTable="zform_school" dictField="code" dictText="name"
							defaultVal="${poVal.fromSchool }" hasLabel="false" title="调出学校"></t:dictSelect> <label class="Validform_label" style="display: none;">调出学校</label></td>
					<td align="left"><t:dictSelect field="zformPersonTransferInnerList[${stuts.index }].toSchool" type="list" dictTable="zform_school" dictField="code" dictText="name"
							defaultVal="${poVal.toSchool }" hasLabel="false" title="调入学校"></t:dictSelect> <label class="Validform_label" style="display: none;">调入学校</label></td>
					<td align="left"><input name="zformPersonTransferInnerList[${stuts.index }].transferDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.transferDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">调动日期</label></td>
					<td align="left"><input name="zformPersonTransferInnerList[${stuts.index }].transferLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.transferLetterDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">商调函日期</label></td>
					<td align="left"><input name="zformPersonTransferInnerList[${stuts.index }].notifyLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.notifyLetterDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">调干通知书日期</label></td>
					<td align="left"><input name="zformPersonTransferInnerList[${stuts.index }].refLetterDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.refLetterDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">干部介绍信日期</label></td>
					<td align="left"><input name="zformPersonTransferInnerList[${stuts.index }].salaryEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.salaryEndDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">原单位止薪日期</label></td>
					<td align="left"><t:dictSelect field="zformPersonTransferInnerList[${stuts.index }].transferReason" type="list" typeGroupCode="trans_r" defaultVal="${poVal.transferReason }" hasLabel="false"
							title="调动原因"></t:dictSelect> <label class="Validform_label" style="display: none;">调动原因</label></td>
					<td align="left"><t:dictSelect field="zformPersonTransferInnerList[${stuts.index }].transferTitle" type="list" typeGroupCode="title" defaultVal="${poVal.transferTitle }" hasLabel="false"
							title="调出前职称"></t:dictSelect> <label class="Validform_label" style="display: none;">调出前职称</label></td>
					<td align="left"><t:dictSelect field="zformPersonTransferInnerList[${stuts.index }].nominate" type="list" typeGroupCode="yesorno" defaultVal="${poVal.nominate }" hasLabel="false"
							title="是否组织任命"></t:dictSelect> <label class="Validform_label" style="display: none;">是否组织任命</label></td>
					<td align="left"><input name="zformPersonTransferInnerList[${stuts.index }].comments" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.comments }"> <label
						class="Validform_label" style="display: none;">备注</label></td>
					<td align="left"><input name="zformPersonTransferInnerList[${stuts.index }].transferStatus" maxlength="100" type="text" class="inputxt" style="width:120px;" value="${poVal.transferStatus }">
						<label class="Validform_label" style="display: none;">调动状态</label></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
