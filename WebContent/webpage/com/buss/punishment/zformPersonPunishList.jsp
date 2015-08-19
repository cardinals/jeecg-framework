<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZformPersonPunishBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZformPersonPunishBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZformPersonPunishBtn').bind('click', function(){   
 		 var tr =  $("#add_zformPersonPunish_table_template tr").clone();
	 	 $("#add_zformPersonPunish_table").append(tr);
	 	 resetTrNum('add_zformPersonPunish_table');
	 	 return false;
    });  
	$('#delZformPersonPunishBtn').bind('click', function(){   
      	$("#add_zformPersonPunish_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zformPersonPunish_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zformPersonPunish_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZformPersonPunishBtn" href="#">添加</a> <a id="delZformPersonPunishBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zformPersonPunish_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
		<td align="left" bgcolor="#EEEEEE">所受处分情况</td>
		<td align="left" bgcolor="#EEEEEE">所受处分到期日期</td>
		<td align="left" bgcolor="#EEEEEE">备注</td>
	</tr>
	<tbody id="add_zformPersonPunish_table">
		<c:if test="${fn:length(zformPersonPunishList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="zformPersonPunishList[0].id" type="hidden" />
				<input name="zformPersonPunishList[0].code" type="hidden" />
				<input name="zformPersonPunishList[0].extra1" type="hidden" />
				<input name="zformPersonPunishList[0].extra2" type="hidden" />
				<td align="left"><input name="zformPersonPunishList[0].punishment" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">所受处分情况</label></td>
				<td align="left"><input name="zformPersonPunishList[0].punishmentEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;">
					<label class="Validform_label" style="display: none;">所受处分到期日期</label></td>
				<td align="left"><input name="zformPersonPunishList[0].comments" maxlength="200" type="text" class="inputxt" style="width:120px;"> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(zformPersonPunishList)  > 0 }">
			<c:forEach items="${zformPersonPunishList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="zformPersonPunishList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<input name="zformPersonPunishList[${stuts.index }].code" type="hidden" value="${poVal.code }" />
					<input name="zformPersonPunishList[${stuts.index }].extra1" type="hidden" value="${poVal.extra1 }" />
					<input name="zformPersonPunishList[${stuts.index }].extra2" type="hidden" value="${poVal.extra2 }" />
					<td align="left"><input name="zformPersonPunishList[${stuts.index }].punishment" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.punishment }"> <label
						class="Validform_label" style="display: none;">所受处分情况</label></td>
					<td align="left"><input name="zformPersonPunishList[${stuts.index }].punishmentEndDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" style="width:120px;"
						value="<fmt:formatDate value='${poVal.punishmentEndDate}' type="date" pattern="yyyy-MM-dd"/>"> <label class="Validform_label" style="display: none;">所受处分到期日期</label></td>
					<td align="left"><input name="zformPersonPunishList[${stuts.index }].comments" maxlength="200" type="text" class="inputxt" style="width:120px;" value="${poVal.comments }"> <label
						class="Validform_label" style="display: none;">备注</label></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
