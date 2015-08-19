package com.buss.school.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 单位基本信息表
 * @author onlineGenerator
 * @date 2015-07-18 11:28:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_school", schema = "")
@SuppressWarnings("serial")
public class ZformSchoolEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**单位编码*/
	@Excel(name="单位编码")
	private java.lang.String code;
	/**单位名称*/
	@Excel(name="单位名称")
	private java.lang.String name;
	/**邮政编码*/
	@Excel(name="邮政编码")
	private java.lang.String zipcode;
	/**单位地址*/
	@Excel(name="单位地址")
	private java.lang.String address;
	/**值班电话*/
	@Excel(name="值班电话")
	private java.lang.String contactNo;
	/**办公室电话*/
	@Excel(name="办公室电话")
	private java.lang.String officeNo;
	/**校长室电话*/
	@Excel(name="校长室电话")
	private java.lang.String masterOfficeNo;
	/**校长姓名*/
	@Excel(name="校长姓名")
	private java.lang.String masterName;
	/**校长宅电*/
	@Excel(name="校长宅电")
	private java.lang.String masterHomeNo;
	/**校长手机号*/
	@Excel(name="校长手机号")
	private java.lang.String masterCellphoneNo;
	/**一年级班数*/
	@Excel(name="一年级班数")
	private java.lang.Integer grade1ClassNo;
	/**一年级学生数*/
	@Excel(name="一年级学生数")
	private java.lang.Integer grade1StudentNo;
	/**一年级教师数*/
	@Excel(name="一年级教师数")
	private java.lang.Integer grade1TeacherNo;
	/**二年级班数*/
	@Excel(name="二年级班数")
	private java.lang.Integer grade2ClassNo;
	/**二年级学生数*/
	@Excel(name="二年级学生数")
	private java.lang.Integer grade2StudentNo;
	/**二年级教师数*/
	@Excel(name="二年级教师数")
	private java.lang.Integer grade2TeacherNo;
	/**三年级班数*/
	@Excel(name="三年级班数")
	private java.lang.Integer grade3ClassNo;
	/**三年级学生数*/
	@Excel(name="三年级学生数")
	private java.lang.Integer grade3StudentNo;
	/**三年级教师数*/
	@Excel(name="三年级教师数")
	private java.lang.Integer grade3TeacherNo;
	/**四年级班数*/
	@Excel(name="四年级班数")
	private java.lang.Integer grade4ClassNo;
	/**四年级学生数*/
	@Excel(name="四年级学生数")
	private java.lang.Integer grade4StudentNo;
	/**四年级教师数*/
	@Excel(name="四年级教师数")
	private java.lang.Integer grade4TeacherNo;
	/**五年级班数*/
	@Excel(name="五年级班数")
	private java.lang.Integer grade5ClassNo;
	/**五年级学生数*/
	@Excel(name="五年级学生数")
	private java.lang.Integer grade5StudentNo;
	/**五年级教师数*/
	@Excel(name="五年级教师数")
	private java.lang.Integer grade5TeacherNo;
	/**六年级班数*/
	@Excel(name="六年级班数")
	private java.lang.Integer grade6ClassNo;
	/**六年级学生数*/
	@Excel(name="六年级学生数")
	private java.lang.Integer grade6StudentNo;
	/**六年级教师数*/
	@Excel(name="六年级教师数")
	private java.lang.Integer grade6TeacherNo;
	/**食堂用餐教职工数*/
	@Excel(name="食堂用餐教职工数")
	private java.lang.Integer canteenEmployeeNo;
	/**食堂用餐学生数*/
	@Excel(name="食堂用餐学生数")
	private java.lang.Integer canteenStudentNo;
	/**住宿生数*/
	@Excel(name="住宿生数")
	private java.lang.Integer boarderNo;
	/**离休职工人数*/
	@Excel(name="离休职工人数")
	private java.lang.Integer retireEmployeeNo1;
	/**退休职工人数*/
	@Excel(name="退休职工人数")
	private java.lang.Integer retireEmployeeNo2;
	/**人事干部姓名*/
	@Excel(name="人事干部姓名")
	private java.lang.String personnelName;
	/**人事干部职务*/
	@Excel(name="人事干部职务")
	private java.lang.String personnelDuty;
	/**人事干部手机号*/
	@Excel(name="人事干部手机号")
	private java.lang.String personnelCellphone;
	/**系统管理员姓名*/
	@Excel(name="系统管理员姓名")
	private java.lang.String adminName;
	/**系统管理员职务*/
	@Excel(name="系统管理员职务")
	private java.lang.String adminDuty;
	/**系统管理员手机号*/
	@Excel(name="系统管理员手机号")
	private java.lang.String adminCellphone;
	/**组织机构代码*/
	@Excel(name="组织机构代码")
	private java.lang.String organizationCode;
	/**社保登记证号*/
	@Excel(name="社保登记证号")
	private java.lang.String ssnNo;
	/**档案所在地*/
	@Excel(name="档案所在地")
	private java.lang.String archiveAddress;
	/**网址*/
	@Excel(name="网址")
	private java.lang.String url;
	/**所在乡镇街道*/
	@Excel(name="所在乡镇街道")
	private java.lang.String addressExtra;
	/**单位分类*/
	@Excel(name="单位分类")
	private java.lang.String category;
	/**单位类型*/
	@Excel(name="单位类型")
	private java.lang.String type;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位编码
	 */
	@Column(name ="CODE",nullable=false,length=32)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位编码
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位名称
	 */
	@Column(name ="NAME",nullable=false,length=200)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮政编码
	 */
	@Column(name ="ZIPCODE",nullable=true,length=32)
	public java.lang.String getZipcode(){
		return this.zipcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮政编码
	 */
	public void setZipcode(java.lang.String zipcode){
		this.zipcode = zipcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=200)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  值班电话
	 */
	@Column(name ="CONTACT_NO",nullable=true,length=32)
	public java.lang.String getContactNo(){
		return this.contactNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  值班电话
	 */
	public void setContactNo(java.lang.String contactNo){
		this.contactNo = contactNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办公室电话
	 */
	@Column(name ="OFFICE_NO",nullable=true,length=32)
	public java.lang.String getOfficeNo(){
		return this.officeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办公室电话
	 */
	public void setOfficeNo(java.lang.String officeNo){
		this.officeNo = officeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校长室电话
	 */
	@Column(name ="MASTER_OFFICE_NO",nullable=true,length=32)
	public java.lang.String getMasterOfficeNo(){
		return this.masterOfficeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校长室电话
	 */
	public void setMasterOfficeNo(java.lang.String masterOfficeNo){
		this.masterOfficeNo = masterOfficeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校长姓名
	 */
	@Column(name ="MASTER_NAME",nullable=true,length=32)
	public java.lang.String getMasterName(){
		return this.masterName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校长姓名
	 */
	public void setMasterName(java.lang.String masterName){
		this.masterName = masterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校长宅电
	 */
	@Column(name ="MASTER_HOME_NO",nullable=true,length=32)
	public java.lang.String getMasterHomeNo(){
		return this.masterHomeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校长宅电
	 */
	public void setMasterHomeNo(java.lang.String masterHomeNo){
		this.masterHomeNo = masterHomeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校长手机号
	 */
	@Column(name ="MASTER_CELLPHONE_NO",nullable=true,length=32)
	public java.lang.String getMasterCellphoneNo(){
		return this.masterCellphoneNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校长手机号
	 */
	public void setMasterCellphoneNo(java.lang.String masterCellphoneNo){
		this.masterCellphoneNo = masterCellphoneNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  一年级班数
	 */
	@Column(name ="GRADE1_CLASS_NO",nullable=true,length=32)
	public java.lang.Integer getGrade1ClassNo(){
		return this.grade1ClassNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  一年级班数
	 */
	public void setGrade1ClassNo(java.lang.Integer grade1ClassNo){
		this.grade1ClassNo = grade1ClassNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  一年级学生数
	 */
	@Column(name ="GRADE1_STUDENT_NO",nullable=true,length=32)
	public java.lang.Integer getGrade1StudentNo(){
		return this.grade1StudentNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  一年级学生数
	 */
	public void setGrade1StudentNo(java.lang.Integer grade1StudentNo){
		this.grade1StudentNo = grade1StudentNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  一年级教师数
	 */
	@Column(name ="GRADE1_TEACHER_NO",nullable=true,length=32)
	public java.lang.Integer getGrade1TeacherNo(){
		return this.grade1TeacherNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  一年级教师数
	 */
	public void setGrade1TeacherNo(java.lang.Integer grade1TeacherNo){
		this.grade1TeacherNo = grade1TeacherNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  二年级班数
	 */
	@Column(name ="GRADE2_CLASS_NO",nullable=true,length=32)
	public java.lang.Integer getGrade2ClassNo(){
		return this.grade2ClassNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  二年级班数
	 */
	public void setGrade2ClassNo(java.lang.Integer grade2ClassNo){
		this.grade2ClassNo = grade2ClassNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  二年级学生数
	 */
	@Column(name ="GRADE2_STUDENT_NO",nullable=true,length=32)
	public java.lang.Integer getGrade2StudentNo(){
		return this.grade2StudentNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  二年级学生数
	 */
	public void setGrade2StudentNo(java.lang.Integer grade2StudentNo){
		this.grade2StudentNo = grade2StudentNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  二年级教师数
	 */
	@Column(name ="GRADE2_TEACHER_NO",nullable=true,length=32)
	public java.lang.Integer getGrade2TeacherNo(){
		return this.grade2TeacherNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  二年级教师数
	 */
	public void setGrade2TeacherNo(java.lang.Integer grade2TeacherNo){
		this.grade2TeacherNo = grade2TeacherNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  三年级班数
	 */
	@Column(name ="GRADE3_CLASS_NO",nullable=true,length=32)
	public java.lang.Integer getGrade3ClassNo(){
		return this.grade3ClassNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  三年级班数
	 */
	public void setGrade3ClassNo(java.lang.Integer grade3ClassNo){
		this.grade3ClassNo = grade3ClassNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  三年级学生数
	 */
	@Column(name ="GRADE3_STUDENT_NO",nullable=true,length=32)
	public java.lang.Integer getGrade3StudentNo(){
		return this.grade3StudentNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  三年级学生数
	 */
	public void setGrade3StudentNo(java.lang.Integer grade3StudentNo){
		this.grade3StudentNo = grade3StudentNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  三年级教师数
	 */
	@Column(name ="GRADE3_TEACHER_NO",nullable=true,length=32)
	public java.lang.Integer getGrade3TeacherNo(){
		return this.grade3TeacherNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  三年级教师数
	 */
	public void setGrade3TeacherNo(java.lang.Integer grade3TeacherNo){
		this.grade3TeacherNo = grade3TeacherNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  四年级班数
	 */
	@Column(name ="GRADE4_CLASS_NO",nullable=true,length=32)
	public java.lang.Integer getGrade4ClassNo(){
		return this.grade4ClassNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  四年级班数
	 */
	public void setGrade4ClassNo(java.lang.Integer grade4ClassNo){
		this.grade4ClassNo = grade4ClassNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  四年级学生数
	 */
	@Column(name ="GRADE4_STUDENT_NO",nullable=true,length=32)
	public java.lang.Integer getGrade4StudentNo(){
		return this.grade4StudentNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  四年级学生数
	 */
	public void setGrade4StudentNo(java.lang.Integer grade4StudentNo){
		this.grade4StudentNo = grade4StudentNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  四年级教师数
	 */
	@Column(name ="GRADE4_TEACHER_NO",nullable=true,length=32)
	public java.lang.Integer getGrade4TeacherNo(){
		return this.grade4TeacherNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  四年级教师数
	 */
	public void setGrade4TeacherNo(java.lang.Integer grade4TeacherNo){
		this.grade4TeacherNo = grade4TeacherNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  五年级班数
	 */
	@Column(name ="GRADE5_CLASS_NO",nullable=true,length=32)
	public java.lang.Integer getGrade5ClassNo(){
		return this.grade5ClassNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  五年级班数
	 */
	public void setGrade5ClassNo(java.lang.Integer grade5ClassNo){
		this.grade5ClassNo = grade5ClassNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  五年级学生数
	 */
	@Column(name ="GRADE5_STUDENT_NO",nullable=true,length=32)
	public java.lang.Integer getGrade5StudentNo(){
		return this.grade5StudentNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  五年级学生数
	 */
	public void setGrade5StudentNo(java.lang.Integer grade5StudentNo){
		this.grade5StudentNo = grade5StudentNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  五年级教师数
	 */
	@Column(name ="GRADE5_TEACHER_NO",nullable=true,length=32)
	public java.lang.Integer getGrade5TeacherNo(){
		return this.grade5TeacherNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  五年级教师数
	 */
	public void setGrade5TeacherNo(java.lang.Integer grade5TeacherNo){
		this.grade5TeacherNo = grade5TeacherNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  六年级班数
	 */
	@Column(name ="GRADE6_CLASS_NO",nullable=true,length=32)
	public java.lang.Integer getGrade6ClassNo(){
		return this.grade6ClassNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  六年级班数
	 */
	public void setGrade6ClassNo(java.lang.Integer grade6ClassNo){
		this.grade6ClassNo = grade6ClassNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  六年级学生数
	 */
	@Column(name ="GRADE6_STUDENT_NO",nullable=true,length=32)
	public java.lang.Integer getGrade6StudentNo(){
		return this.grade6StudentNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  六年级学生数
	 */
	public void setGrade6StudentNo(java.lang.Integer grade6StudentNo){
		this.grade6StudentNo = grade6StudentNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  六年级教师数
	 */
	@Column(name ="GRADE6_TEACHER_NO",nullable=true,length=32)
	public java.lang.Integer getGrade6TeacherNo(){
		return this.grade6TeacherNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  六年级教师数
	 */
	public void setGrade6TeacherNo(java.lang.Integer grade6TeacherNo){
		this.grade6TeacherNo = grade6TeacherNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  食堂用餐教职工数
	 */
	@Column(name ="CANTEEN_EMPLOYEE_NO",nullable=true,length=32)
	public java.lang.Integer getCanteenEmployeeNo(){
		return this.canteenEmployeeNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  食堂用餐教职工数
	 */
	public void setCanteenEmployeeNo(java.lang.Integer canteenEmployeeNo){
		this.canteenEmployeeNo = canteenEmployeeNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  食堂用餐学生数
	 */
	@Column(name ="CANTEEN_STUDENT_NO",nullable=true,length=32)
	public java.lang.Integer getCanteenStudentNo(){
		return this.canteenStudentNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  食堂用餐学生数
	 */
	public void setCanteenStudentNo(java.lang.Integer canteenStudentNo){
		this.canteenStudentNo = canteenStudentNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  住宿生数
	 */
	@Column(name ="BOARDER_NO",nullable=true,length=32)
	public java.lang.Integer getBoarderNo(){
		return this.boarderNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  住宿生数
	 */
	public void setBoarderNo(java.lang.Integer boarderNo){
		this.boarderNo = boarderNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  离休职工人数
	 */
	@Column(name ="RETIRE_EMPLOYEE_NO1",nullable=true,length=32)
	public java.lang.Integer getRetireEmployeeNo1(){
		return this.retireEmployeeNo1;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  离休职工人数
	 */
	public void setRetireEmployeeNo1(java.lang.Integer retireEmployeeNo1){
		this.retireEmployeeNo1 = retireEmployeeNo1;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  退休职工人数
	 */
	@Column(name ="RETIRE_EMPLOYEE_NO2",nullable=true,length=32)
	public java.lang.Integer getRetireEmployeeNo2(){
		return this.retireEmployeeNo2;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  退休职工人数
	 */
	public void setRetireEmployeeNo2(java.lang.Integer retireEmployeeNo2){
		this.retireEmployeeNo2 = retireEmployeeNo2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人事干部姓名
	 */
	@Column(name ="PERSONNEL_NAME",nullable=true,length=32)
	public java.lang.String getPersonnelName(){
		return this.personnelName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人事干部姓名
	 */
	public void setPersonnelName(java.lang.String personnelName){
		this.personnelName = personnelName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人事干部职务
	 */
	@Column(name ="PERSONNEL_DUTY",nullable=true,length=32)
	public java.lang.String getPersonnelDuty(){
		return this.personnelDuty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人事干部职务
	 */
	public void setPersonnelDuty(java.lang.String personnelDuty){
		this.personnelDuty = personnelDuty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人事干部手机号
	 */
	@Column(name ="PERSONNEL_CELLPHONE",nullable=true,length=32)
	public java.lang.String getPersonnelCellphone(){
		return this.personnelCellphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人事干部手机号
	 */
	public void setPersonnelCellphone(java.lang.String personnelCellphone){
		this.personnelCellphone = personnelCellphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系统管理员姓名
	 */
	@Column(name ="ADMIN_NAME",nullable=true,length=32)
	public java.lang.String getAdminName(){
		return this.adminName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系统管理员姓名
	 */
	public void setAdminName(java.lang.String adminName){
		this.adminName = adminName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系统管理员职务
	 */
	@Column(name ="ADMIN_DUTY",nullable=true,length=32)
	public java.lang.String getAdminDuty(){
		return this.adminDuty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系统管理员职务
	 */
	public void setAdminDuty(java.lang.String adminDuty){
		this.adminDuty = adminDuty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系统管理员手机号
	 */
	@Column(name ="ADMIN_CELLPHONE",nullable=true,length=32)
	public java.lang.String getAdminCellphone(){
		return this.adminCellphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系统管理员手机号
	 */
	public void setAdminCellphone(java.lang.String adminCellphone){
		this.adminCellphone = adminCellphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组织机构代码
	 */
	@Column(name ="ORGANIZATION_CODE",nullable=true,length=32)
	public java.lang.String getOrganizationCode(){
		return this.organizationCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组织机构代码
	 */
	public void setOrganizationCode(java.lang.String organizationCode){
		this.organizationCode = organizationCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  社保登记证号
	 */
	@Column(name ="SSN_NO",nullable=true,length=32)
	public java.lang.String getSsnNo(){
		return this.ssnNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  社保登记证号
	 */
	public void setSsnNo(java.lang.String ssnNo){
		this.ssnNo = ssnNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  档案所在地
	 */
	@Column(name ="ARCHIVE_ADDRESS",nullable=true,length=32)
	public java.lang.String getArchiveAddress(){
		return this.archiveAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  档案所在地
	 */
	public void setArchiveAddress(java.lang.String archiveAddress){
		this.archiveAddress = archiveAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  网址
	 */
	@Column(name ="URL",nullable=true,length=300)
	public java.lang.String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网址
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在乡镇街道
	 */
	@Column(name ="ADDRESS_EXTRA",nullable=true,length=200)
	public java.lang.String getAddressExtra(){
		return this.addressExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在乡镇街道
	 */
	public void setAddressExtra(java.lang.String addressExtra){
		this.addressExtra = addressExtra;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位分类
	 */
	@Column(name ="CATEGORY",nullable=true,length=32)
	public java.lang.String getCategory(){
		return this.category;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位分类
	 */
	public void setCategory(java.lang.String category){
		this.category = category;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位类型
	 */
	@Column(name ="TYPE",nullable=true,length=32)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
}
