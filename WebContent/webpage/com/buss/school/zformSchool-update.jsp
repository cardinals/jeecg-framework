<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>单位基本信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zformSchoolController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zformSchoolPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位编码:
							</label>
						</td>
						<td class="value">
						     	 <input id="code" name="code" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${zformSchoolPage.code}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位编码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单位名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${zformSchoolPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								邮政编码:
							</label>
						</td>
						<td class="value">
						     	 <input id="zipcode" name="zipcode" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.zipcode}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邮政编码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单位地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.address}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								值班电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="contactNo" name="contactNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.contactNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">值班电话</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								办公室电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="officeNo" name="officeNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.officeNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">办公室电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								校长室电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="masterOfficeNo" name="masterOfficeNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.masterOfficeNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">校长室电话</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								校长姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="masterName" name="masterName" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.masterName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">校长姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								校长宅电:
							</label>
						</td>
						<td class="value">
						     	 <input id="masterHomeNo" name="masterHomeNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.masterHomeNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">校长宅电</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								校长手机号:
							</label>
						</td>
						<td class="value">
						     	 <input id="masterCellphoneNo" name="masterCellphoneNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.masterCellphoneNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">校长手机号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								一年级班数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade1ClassNo" name="grade1ClassNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade1ClassNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">一年级班数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								一年级学生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade1StudentNo" name="grade1StudentNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade1StudentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">一年级学生数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								一年级教师数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade1TeacherNo" name="grade1TeacherNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade1TeacherNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">一年级教师数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								二年级班数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade2ClassNo" name="grade2ClassNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade2ClassNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">二年级班数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								二年级学生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade2StudentNo" name="grade2StudentNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade2StudentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">二年级学生数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								二年级教师数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade2TeacherNo" name="grade2TeacherNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade2TeacherNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">二年级教师数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								三年级班数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade3ClassNo" name="grade3ClassNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade3ClassNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">三年级班数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								三年级学生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade3StudentNo" name="grade3StudentNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade3StudentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">三年级学生数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								三年级教师数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade3TeacherNo" name="grade3TeacherNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade3TeacherNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">三年级教师数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								四年级班数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade4ClassNo" name="grade4ClassNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade4ClassNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">四年级班数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								四年级学生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade4StudentNo" name="grade4StudentNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade4StudentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">四年级学生数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								四年级教师数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade4TeacherNo" name="grade4TeacherNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade4TeacherNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">四年级教师数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								五年级班数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade5ClassNo" name="grade5ClassNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade5ClassNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">五年级班数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								五年级学生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade5StudentNo" name="grade5StudentNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade5StudentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">五年级学生数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								五年级教师数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade5TeacherNo" name="grade5TeacherNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade5TeacherNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">五年级教师数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								六年级班数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade6ClassNo" name="grade6ClassNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade6ClassNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">六年级班数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								六年级学生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade6StudentNo" name="grade6StudentNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade6StudentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">六年级学生数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								六年级教师数:
							</label>
						</td>
						<td class="value">
						     	 <input id="grade6TeacherNo" name="grade6TeacherNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.grade6TeacherNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">六年级教师数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								食堂用餐教职工数:
							</label>
						</td>
						<td class="value">
						     	 <input id="canteenEmployeeNo" name="canteenEmployeeNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.canteenEmployeeNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">食堂用餐教职工数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								食堂用餐学生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="canteenStudentNo" name="canteenStudentNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.canteenStudentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">食堂用餐学生数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								住宿生数:
							</label>
						</td>
						<td class="value">
						     	 <input id="boarderNo" name="boarderNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.boarderNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住宿生数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								离休职工人数:
							</label>
						</td>
						<td class="value">
						     	 <input id="retireEmployeeNo1" name="retireEmployeeNo1" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.retireEmployeeNo1}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">离休职工人数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								退休职工人数:
							</label>
						</td>
						<td class="value">
						     	 <input id="retireEmployeeNo2" name="retireEmployeeNo2" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.retireEmployeeNo2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">退休职工人数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								人事干部姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="personnelName" name="personnelName" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.personnelName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人事干部姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								人事干部职务:
							</label>
						</td>
						<td class="value">
						     	 <input id="personnelDuty" name="personnelDuty" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.personnelDuty}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人事干部职务</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								人事干部手机号:
							</label>
						</td>
						<td class="value">
						     	 <input id="personnelCellphone" name="personnelCellphone" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.personnelCellphone}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人事干部手机号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								系统管理员姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="adminName" name="adminName" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.adminName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系统管理员姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								系统管理员职务:
							</label>
						</td>
						<td class="value">
						     	 <input id="adminDuty" name="adminDuty" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.adminDuty}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系统管理员职务</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								系统管理员手机号:
							</label>
						</td>
						<td class="value">
						     	 <input id="adminCellphone" name="adminCellphone" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.adminCellphone}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系统管理员手机号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								组织机构代码:
							</label>
						</td>
						<td class="value">
						     	 <input id="organizationCode" name="organizationCode" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.organizationCode}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">组织机构代码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								社保登记证号:
							</label>
						</td>
						<td class="value">
						     	 <input id="ssnNo" name="ssnNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.ssnNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">社保登记证号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								档案所在地:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="archiveAddress" type="list"
										typeGroupCode="archive" defaultVal="${zformSchoolPage.archiveAddress}" hasLabel="false"  title="档案所在地"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">档案所在地</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								网址:
							</label>
						</td>
						<td class="value">
						     	 <input id="url" name="url" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.url}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">网址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								所在乡镇街道:
							</label>
						</td>
						<td class="value">
						     	 <input id="addressExtra" name="addressExtra" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zformSchoolPage.addressExtra}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所在乡镇街道</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位分类:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="category" type="list"
										typeGroupCode="danwei_fl" defaultVal="${zformSchoolPage.category}" hasLabel="false"  title="单位分类"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位分类</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单位类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="type" type="list"
										typeGroupCode="danwei_lx" defaultVal="${zformSchoolPage.type}" hasLabel="false"  title="单位类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位类型</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/school/zformSchool.js"></script>		