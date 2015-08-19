<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZformPersonStatusBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZformPersonStatusBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZformPersonStatusBtn').bind('click', function(){   
 		 var tr =  $("#add_zformPersonStatus_table_template tr").clone();
	 	 $("#add_zformPersonStatus_table").append(tr);
	 	 resetTrNum('add_zformPersonStatus_table');
	 	 return false;
    });  
	$('#delZformPersonStatusBtn').bind('click', function(){   
      	$("#add_zformPersonStatus_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zformPersonStatus_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zformPersonStatus_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZformPersonStatusBtn" href="#">添加</a> <a id="delZformPersonStatusBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zformPersonStatus_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
		<td align="left" bgcolor="#EEEEEE">变更前状态</td>
		<td align="left" bgcolor="#EEEEEE">变更后状态</td>
		<td align="left" bgcolor="#EEEEEE">变更原因</td>
		<td align="left" bgcolor="#EEEEEE">变更日期</td>
	</tr>
	<tbody id="add_zformPersonStatus_table">
		<c:if test="${fn:length(zformPersonStatusList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="zformPersonStatusList[0].id" type="hidden" />
				<input name="zformPersonStatusList[0].code" type="hidden" />
				<input name="zformPersonStatusList[0].extra1" type="hidden" />
				<input name="zformPersonStatusList[0].extra2" type="hidden" />
				<input name="zformPersonStatusList[0].extra3" type="hidden" />
				<input name="zformPersonStatusList[0].extra4" type="hidden" />
				<td align="left"><t:dictSelect field="zformPersonStatusList[0].prevStatus" type="list" typeGroupCode="status" defaultVal="${zformPersonStatusPage.prevStatus}" hasLabel="false" title="变更前状态"></t:dictSelect> <label
					class="Validform_label" style="display: none;">变更前状态</label></td>
				<td align="left"><t:dictSelect field="zformPersonStatusList[0].afterStatus" type="list" typeGroupCode="status" defaultVal="${zformPersonStatusPage.afterStatus}" hasLabel="false" title="变更后状态"></t:dictSelect> <label
					class="Validform_label" style="display: none;">变更后状态</label></td>
				<td align="left"><input name="zformPersonStatusList[0].stateChangeReason" maxlength="32" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">变更原因</label></td>
				<td align="left"><input name="zformPersonStatusList[0].statusChangeDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">变更日期</label></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(zformPersonStatusList)  > 0 }">
			<c:forEach items="${zformPersonStatusList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="zformPersonStatusList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<input name="zformPersonStatusList[${stuts.index }].code" type="hidden" value="${poVal.code }" />
					<input name="zformPersonStatusList[${stuts.index }].extra1" type="hidden" value="${poVal.extra1 }" />
					<input name="zformPersonStatusList[${stuts.index }].extra2" type="hidden" value="${poVal.extra2 }" />
					<input name="zformPersonStatusList[${stuts.index }].extra3" type="hidden" value="${poVal.extra3 }" />
					<input name="zformPersonStatusList[${stuts.index }].extra4" type="hidden" value="${poVal.extra4 }" />
					<td align="left"><t:dictSelect field="zformPersonStatusList[${stuts.index }].prevStatus" type="list" typeGroupCode="status" defaultVal="${poVal.prevStatus }" hasLabel="false" title="变更前状态"></t:dictSelect>
						<label class="Validform_label" style="display: none;">变更前状态</label></td>
					<td align="left"><t:dictSelect field="zformPersonStatusList[${stuts.index }].afterStatus" type="list" typeGroupCode="status" defaultVal="${poVal.afterStatus }" hasLabel="false" title="变更后状态"></t:dictSelect>
						<label class="Validform_label" style="display: none;">变更后状态</label></td>
					<td align="left"><input name="zformPersonStatusList[${stuts.index }].stateChangeReason" maxlength="32" type="text" class="inputxt" style="width:120px;" value="${poVal.stateChangeReason }">
						<label class="Validform_label" style="display: none;">变更原因</label></td>
					<td align="left"><input name="zformPersonStatusList[${stuts.index }].statusChangeDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.statusChangeDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">变更日期</label></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
