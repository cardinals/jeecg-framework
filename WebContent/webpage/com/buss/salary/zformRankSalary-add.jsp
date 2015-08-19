<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>薪级工资数据库</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zformRankSalaryController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zformRankSalaryPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							年度:
						</label>
					</td>
					<td class="value">
					     	 <input id="year" name="year" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年度</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							岗位类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="jobtype" type="list"
									typeGroupCode="jobtype" defaultVal="${zformRankSalaryPage.jobtype}" hasLabel="false"  title="岗位类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							薪级:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="rank" type="list"
									typeGroupCode="rank" defaultVal="${zformRankSalaryPage.rank}" hasLabel="false"  title="薪级"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">薪级</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							工资:
						</label>
					</td>
					<td class="value">
					     	 <input id="salary" name="salary" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工资</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/salary/zformRankSalary.js"></script>		