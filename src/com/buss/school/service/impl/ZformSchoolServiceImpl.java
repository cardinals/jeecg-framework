package com.buss.school.service.impl;
import com.buss.school.service.ZformSchoolServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.school.entity.ZformSchoolEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("zformSchoolService")
@Transactional
public class ZformSchoolServiceImpl extends CommonServiceImpl implements ZformSchoolServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZformSchoolEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((ZformSchoolEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((ZformSchoolEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZformSchoolEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZformSchoolEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZformSchoolEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZformSchoolEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{zipcode}",String.valueOf(t.getZipcode()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{contact_no}",String.valueOf(t.getContactNo()));
 		sql  = sql.replace("#{office_no}",String.valueOf(t.getOfficeNo()));
 		sql  = sql.replace("#{master_office_no}",String.valueOf(t.getMasterOfficeNo()));
 		sql  = sql.replace("#{master_name}",String.valueOf(t.getMasterName()));
 		sql  = sql.replace("#{master_home_no}",String.valueOf(t.getMasterHomeNo()));
 		sql  = sql.replace("#{master_cellphone_no}",String.valueOf(t.getMasterCellphoneNo()));
 		sql  = sql.replace("#{grade1_class_no}",String.valueOf(t.getGrade1ClassNo()));
 		sql  = sql.replace("#{grade1_student_no}",String.valueOf(t.getGrade1StudentNo()));
 		sql  = sql.replace("#{grade1_teacher_no}",String.valueOf(t.getGrade1TeacherNo()));
 		sql  = sql.replace("#{grade2_class_no}",String.valueOf(t.getGrade2ClassNo()));
 		sql  = sql.replace("#{grade2_student_no}",String.valueOf(t.getGrade2StudentNo()));
 		sql  = sql.replace("#{grade2_teacher_no}",String.valueOf(t.getGrade2TeacherNo()));
 		sql  = sql.replace("#{grade3_class_no}",String.valueOf(t.getGrade3ClassNo()));
 		sql  = sql.replace("#{grade3_student_no}",String.valueOf(t.getGrade3StudentNo()));
 		sql  = sql.replace("#{grade3_teacher_no}",String.valueOf(t.getGrade3TeacherNo()));
 		sql  = sql.replace("#{grade4_class_no}",String.valueOf(t.getGrade4ClassNo()));
 		sql  = sql.replace("#{grade4_student_no}",String.valueOf(t.getGrade4StudentNo()));
 		sql  = sql.replace("#{grade4_teacher_no}",String.valueOf(t.getGrade4TeacherNo()));
 		sql  = sql.replace("#{grade5_class_no}",String.valueOf(t.getGrade5ClassNo()));
 		sql  = sql.replace("#{grade5_student_no}",String.valueOf(t.getGrade5StudentNo()));
 		sql  = sql.replace("#{grade5_teacher_no}",String.valueOf(t.getGrade5TeacherNo()));
 		sql  = sql.replace("#{grade6_class_no}",String.valueOf(t.getGrade6ClassNo()));
 		sql  = sql.replace("#{grade6_student_no}",String.valueOf(t.getGrade6StudentNo()));
 		sql  = sql.replace("#{grade6_teacher_no}",String.valueOf(t.getGrade6TeacherNo()));
 		sql  = sql.replace("#{canteen_employee_no}",String.valueOf(t.getCanteenEmployeeNo()));
 		sql  = sql.replace("#{canteen_student_no}",String.valueOf(t.getCanteenStudentNo()));
 		sql  = sql.replace("#{boarder_no}",String.valueOf(t.getBoarderNo()));
 		sql  = sql.replace("#{retire_employee_no1}",String.valueOf(t.getRetireEmployeeNo1()));
 		sql  = sql.replace("#{retire_employee_no2}",String.valueOf(t.getRetireEmployeeNo2()));
 		sql  = sql.replace("#{personnel_name}",String.valueOf(t.getPersonnelName()));
 		sql  = sql.replace("#{personnel_duty}",String.valueOf(t.getPersonnelDuty()));
 		sql  = sql.replace("#{personnel_cellphone}",String.valueOf(t.getPersonnelCellphone()));
 		sql  = sql.replace("#{admin_name}",String.valueOf(t.getAdminName()));
 		sql  = sql.replace("#{admin_duty}",String.valueOf(t.getAdminDuty()));
 		sql  = sql.replace("#{admin_cellphone}",String.valueOf(t.getAdminCellphone()));
 		sql  = sql.replace("#{organization_code}",String.valueOf(t.getOrganizationCode()));
 		sql  = sql.replace("#{ssn_no}",String.valueOf(t.getSsnNo()));
 		sql  = sql.replace("#{archive_address}",String.valueOf(t.getArchiveAddress()));
 		sql  = sql.replace("#{url}",String.valueOf(t.getUrl()));
 		sql  = sql.replace("#{address_extra}",String.valueOf(t.getAddressExtra()));
 		sql  = sql.replace("#{category}",String.valueOf(t.getCategory()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}