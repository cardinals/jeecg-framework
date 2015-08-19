package com.buss.active.entity;

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
 * @Description: 在职
 * @author onlineGenerator
 * @date 2015-07-19 11:33:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_active", schema = "")
@SuppressWarnings("serial")
public class ZformPersonActiveEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**所在学校*/
	@Excel(name="所在学校")
	private java.lang.String schoolCode;
	/**现身份*/
	@Excel(name="现身份")
	private java.lang.String currentIdentity;
	/**现职称*/
	@Excel(name="现职称")
	private java.lang.String currentTitle;
	/**现职称扩充*/
	@Excel(name="现职称扩充")
	private java.lang.String currentTitleExtra;
	/**现职称评审日期*/
	@Excel(name="现职称评审日期")
	private java.util.Date currentTitleDate;
	/**任职类别*/
	@Excel(name="任职类别")
	private java.lang.String dutyCategory;
	/**行政职务*/
	@Excel(name="行政职务")
	private java.lang.String executiveTitle;
	/**所聘岗位*/
	@Excel(name="所聘岗位")
	private java.lang.String currentJob;
	/**所聘岗位扩充*/
	@Excel(name="所聘岗位扩充")
	private java.lang.String currentJobExtra;
	/**所聘岗位等级*/
	@Excel(name="所聘岗位等级")
	private java.lang.String currentJobLevel;
	/**所聘岗位类型*/
	@Excel(name="所聘岗位类型")
	private java.lang.String currentJobType;
	/**岗位工资*/
	@Excel(name="岗位工资")
	private java.lang.String jobSalary;
	/**薪级*/
	@Excel(name="薪级")
	private java.lang.String rank;
	/**薪级工资*/
	@Excel(name="薪级工资")
	private java.lang.String rankSalary;
	/**百分之十工资*/
	@Excel(name="百分之十工资")
	private java.lang.String extraSalary;
	/**累计工龄*/
	@Excel(name="累计工龄")
	private java.lang.String totalSeniority;
	/**教龄*/
	@Excel(name="教龄")
	private java.lang.String teachingSeniority;
	/**教育人才类别*/
	@Excel(name="教育人才类别")
	private java.lang.String hardCore;
	/**所获荣誉称号*/
	@Excel(name="所获荣誉称号")
	private java.lang.String honorTitle;
	/**班主任年级*/
	@Excel(name="班主任年级")
	private java.lang.String majorGrade;
	/**任教课程1*/
	@Excel(name="任教课程1")
	private java.lang.String teachingCourse1;
	/**任教学段1*/
	@Excel(name="任教学段1")
	private java.lang.String teachingGrade1;
	/**任教节数1*/
	@Excel(name="任教节数1")
	private java.lang.Integer teachingClassNo1;
	/**任教课程2*/
	@Excel(name="任教课程2")
	private java.lang.String teachingCourse2;
	/**任教学段2*/
	@Excel(name="任教学段2")
	private java.lang.String teachingGrade2;
	/**任教节数2*/
	@Excel(name="任教节数2")
	private java.lang.Integer teachingClassNo2;
	/**任教年级*/
	@Excel(name="任教年级")
	private java.lang.String teachingMajorGrade;
	/**聘用合同聘期*/
	@Excel(name="聘用合同聘期")
	private java.util.Date contractTerm;
	/**聘用合同截止日期*/
	@Excel(name="聘用合同截止日期")
	private java.util.Date contractEndDate;
	/**转正定级日期*/
	@Excel(name="转正定级日期")
	private java.util.Date probationEndDate;
	/**教师资格*/
	@Excel(name="教师资格")
	private java.lang.String teacherCert;
	/**教师资格证等级*/
	@Excel(name="教师资格证等级")
	private java.lang.String teacherCertLevel;
	/**教师资格证颁发日期*/
	@Excel(name="教师资格证颁发日期")
	private java.util.Date teacherCertDate;
	/**教师资额注册截止日期*/
	@Excel(name="教师资额注册截止日期")
	private java.util.Date regEndDate;
	/**交流轮岗情况*/
	@Excel(name="交流轮岗情况")
	private java.lang.String rotateStatus;
	/**试用期情况*/
	@Excel(name="试用期情况")
	private java.lang.String probationStatus;
	/**调动原因*/
	@Excel(name="调动原因")
	private java.lang.String transferReason;
	/**所在部门*/
	@Excel(name="所在部门")
	private java.lang.String department;
	/**周课时*/
	@Excel(name="周课时")
	private java.lang.Integer weeklyHours;
	/**服务期截止日期*/
	@Excel(name="服务期截止日期")
	private java.util.Date serviceEndDate;
	/**服务期剩余时间*/
	@Excel(name="服务期剩余时间")
	private java.lang.String serviceRemainDate;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String comments;
	/**预留字段1*/
	private java.lang.String extra1;
	/**预留字段2*/
	private java.lang.String extra2;
	/**预留字段3*/
	private java.lang.String extra3;
	/**预留字段4*/
	private java.lang.String extra4;
	
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
	 *@return: java.lang.String  人员编号
	 */
	@Column(name ="CODE",nullable=false,length=32)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员编号
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在学校
	 */
	@Column(name ="SCHOOL_CODE",nullable=true,length=32)
	public java.lang.String getSchoolCode(){
		return this.schoolCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在学校
	 */
	public void setSchoolCode(java.lang.String schoolCode){
		this.schoolCode = schoolCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现身份
	 */
	@Column(name ="CURRENT_IDENTITY",nullable=true,length=200)
	public java.lang.String getCurrentIdentity(){
		return this.currentIdentity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现身份
	 */
	public void setCurrentIdentity(java.lang.String currentIdentity){
		this.currentIdentity = currentIdentity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现职称
	 */
	@Column(name ="CURRENT_TITLE",nullable=true,length=200)
	public java.lang.String getCurrentTitle(){
		return this.currentTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现职称
	 */
	public void setCurrentTitle(java.lang.String currentTitle){
		this.currentTitle = currentTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现职称扩充
	 */
	@Column(name ="CURRENT_TITLE_EXTRA",nullable=true,length=200)
	public java.lang.String getCurrentTitleExtra(){
		return this.currentTitleExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现职称扩充
	 */
	public void setCurrentTitleExtra(java.lang.String currentTitleExtra){
		this.currentTitleExtra = currentTitleExtra;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  现职称评审日期
	 */
	@Column(name ="CURRENT_TITLE_DATE",nullable=true,length=200)
	public java.util.Date getCurrentTitleDate(){
		return this.currentTitleDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  现职称评审日期
	 */
	public void setCurrentTitleDate(java.util.Date currentTitleDate){
		this.currentTitleDate = currentTitleDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任职类别
	 */
	@Column(name ="DUTY_CATEGORY",nullable=true,length=200)
	public java.lang.String getDutyCategory(){
		return this.dutyCategory;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任职类别
	 */
	public void setDutyCategory(java.lang.String dutyCategory){
		this.dutyCategory = dutyCategory;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行政职务
	 */
	@Column(name ="EXECUTIVE_TITLE",nullable=true,length=200)
	public java.lang.String getExecutiveTitle(){
		return this.executiveTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行政职务
	 */
	public void setExecutiveTitle(java.lang.String executiveTitle){
		this.executiveTitle = executiveTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所聘岗位
	 */
	@Column(name ="CURRENT_JOB",nullable=true,length=200)
	public java.lang.String getCurrentJob(){
		return this.currentJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所聘岗位
	 */
	public void setCurrentJob(java.lang.String currentJob){
		this.currentJob = currentJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所聘岗位扩充
	 */
	@Column(name ="CURRENT_JOB_EXTRA",nullable=true,length=200)
	public java.lang.String getCurrentJobExtra(){
		return this.currentJobExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所聘岗位扩充
	 */
	public void setCurrentJobExtra(java.lang.String currentJobExtra){
		this.currentJobExtra = currentJobExtra;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所聘岗位等级
	 */
	@Column(name ="CURRENT_JOB_LEVEL",nullable=true,length=200)
	public java.lang.String getCurrentJobLevel(){
		return this.currentJobLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所聘岗位等级
	 */
	public void setCurrentJobLevel(java.lang.String currentJobLevel){
		this.currentJobLevel = currentJobLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所聘岗位类型
	 */
	@Column(name ="CURRENT_JOB_TYPE",nullable=true,length=200)
	public java.lang.String getCurrentJobType(){
		return this.currentJobType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所聘岗位类型
	 */
	public void setCurrentJobType(java.lang.String currentJobType){
		this.currentJobType = currentJobType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位工资
	 */
	@Column(name ="JOB_SALARY",nullable=true,length=200)
	public java.lang.String getJobSalary(){
		return this.jobSalary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位工资
	 */
	public void setJobSalary(java.lang.String jobSalary){
		this.jobSalary = jobSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  薪级
	 */
	@Column(name ="RANK",nullable=true,length=200)
	public java.lang.String getRank(){
		return this.rank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  薪级
	 */
	public void setRank(java.lang.String rank){
		this.rank = rank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  薪级工资
	 */
	@Column(name ="RANK_SALARY",nullable=true,length=200)
	public java.lang.String getRankSalary(){
		return this.rankSalary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  薪级工资
	 */
	public void setRankSalary(java.lang.String rankSalary){
		this.rankSalary = rankSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  百分之十工资
	 */
	@Column(name ="EXTRA_SALARY",nullable=true,length=10)
	public java.lang.String getExtraSalary(){
		return this.extraSalary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  百分之十工资
	 */
	public void setExtraSalary(java.lang.String extraSalary){
		this.extraSalary = extraSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  累计工龄
	 */
	@Column(name ="TOTAL_SENIORITY",nullable=true,length=200)
	public java.lang.String getTotalSeniority(){
		return this.totalSeniority;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  累计工龄
	 */
	public void setTotalSeniority(java.lang.String totalSeniority){
		this.totalSeniority = totalSeniority;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教龄
	 */
	@Column(name ="TEACHING_SENIORITY",nullable=true,length=200)
	public java.lang.String getTeachingSeniority(){
		return this.teachingSeniority;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教龄
	 */
	public void setTeachingSeniority(java.lang.String teachingSeniority){
		this.teachingSeniority = teachingSeniority;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教育人才类别
	 */
	@Column(name ="HARD_CORE",nullable=true,length=200)
	public java.lang.String getHardCore(){
		return this.hardCore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教育人才类别
	 */
	public void setHardCore(java.lang.String hardCore){
		this.hardCore = hardCore;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所获荣誉称号
	 */
	@Column(name ="HONOR_TITLE",nullable=true,length=200)
	public java.lang.String getHonorTitle(){
		return this.honorTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所获荣誉称号
	 */
	public void setHonorTitle(java.lang.String honorTitle){
		this.honorTitle = honorTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  班主任年级
	 */
	@Column(name ="MAJOR_GRADE",nullable=true,length=200)
	public java.lang.String getMajorGrade(){
		return this.majorGrade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  班主任年级
	 */
	public void setMajorGrade(java.lang.String majorGrade){
		this.majorGrade = majorGrade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任教课程1
	 */
	@Column(name ="TEACHING_COURSE_1",nullable=true,length=200)
	public java.lang.String getTeachingCourse1(){
		return this.teachingCourse1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任教课程1
	 */
	public void setTeachingCourse1(java.lang.String teachingCourse1){
		this.teachingCourse1 = teachingCourse1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任教学段1
	 */
	@Column(name ="TEACHING_GRADE_1",nullable=true,length=200)
	public java.lang.String getTeachingGrade1(){
		return this.teachingGrade1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任教学段1
	 */
	public void setTeachingGrade1(java.lang.String teachingGrade1){
		this.teachingGrade1 = teachingGrade1;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  任教节数1
	 */
	@Column(name ="TEACHING_CLASS_NO_1",nullable=true,length=10)
	public java.lang.Integer getTeachingClassNo1(){
		return this.teachingClassNo1;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  任教节数1
	 */
	public void setTeachingClassNo1(java.lang.Integer teachingClassNo1){
		this.teachingClassNo1 = teachingClassNo1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任教课程2
	 */
	@Column(name ="TEACHING_COURSE_2",nullable=true,length=200)
	public java.lang.String getTeachingCourse2(){
		return this.teachingCourse2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任教课程2
	 */
	public void setTeachingCourse2(java.lang.String teachingCourse2){
		this.teachingCourse2 = teachingCourse2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任教学段2
	 */
	@Column(name ="TEACHING_GRADE_2",nullable=true,length=200)
	public java.lang.String getTeachingGrade2(){
		return this.teachingGrade2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任教学段2
	 */
	public void setTeachingGrade2(java.lang.String teachingGrade2){
		this.teachingGrade2 = teachingGrade2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  任教节数2
	 */
	@Column(name ="TEACHING_CLASS_NO_2",nullable=true,length=10)
	public java.lang.Integer getTeachingClassNo2(){
		return this.teachingClassNo2;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  任教节数2
	 */
	public void setTeachingClassNo2(java.lang.Integer teachingClassNo2){
		this.teachingClassNo2 = teachingClassNo2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任教年级
	 */
	@Column(name ="TEACHING_MAJOR_GRADE",nullable=true,length=200)
	public java.lang.String getTeachingMajorGrade(){
		return this.teachingMajorGrade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任教年级
	 */
	public void setTeachingMajorGrade(java.lang.String teachingMajorGrade){
		this.teachingMajorGrade = teachingMajorGrade;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  聘用合同聘期
	 */
	@Column(name ="CONTRACT_TERM",nullable=true,length=32)
	public java.util.Date getContractTerm(){
		return this.contractTerm;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  聘用合同聘期
	 */
	public void setContractTerm(java.util.Date contractTerm){
		this.contractTerm = contractTerm;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  聘用合同截止日期
	 */
	@Column(name ="CONTRACT_END_DATE",nullable=true,length=32)
	public java.util.Date getContractEndDate(){
		return this.contractEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  聘用合同截止日期
	 */
	public void setContractEndDate(java.util.Date contractEndDate){
		this.contractEndDate = contractEndDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  转正定级日期
	 */
	@Column(name ="PROBATION_END_DATE",nullable=true,length=32)
	public java.util.Date getProbationEndDate(){
		return this.probationEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  转正定级日期
	 */
	public void setProbationEndDate(java.util.Date probationEndDate){
		this.probationEndDate = probationEndDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教师资格
	 */
	@Column(name ="TEACHER_CERT",nullable=true,length=200)
	public java.lang.String getTeacherCert(){
		return this.teacherCert;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教师资格
	 */
	public void setTeacherCert(java.lang.String teacherCert){
		this.teacherCert = teacherCert;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教师资格证等级
	 */
	@Column(name ="TEACHER_CERT_LEVEL",nullable=true,length=100)
	public java.lang.String getTeacherCertLevel(){
		return this.teacherCertLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教师资格证等级
	 */
	public void setTeacherCertLevel(java.lang.String teacherCertLevel){
		this.teacherCertLevel = teacherCertLevel;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  教师资格证颁发日期
	 */
	@Column(name ="TEACHER_CERT_DATE",nullable=true,length=32)
	public java.util.Date getTeacherCertDate(){
		return this.teacherCertDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  教师资格证颁发日期
	 */
	public void setTeacherCertDate(java.util.Date teacherCertDate){
		this.teacherCertDate = teacherCertDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  教师资额注册截止日期
	 */
	@Column(name ="REG_END_DATE",nullable=true,length=32)
	public java.util.Date getRegEndDate(){
		return this.regEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  教师资额注册截止日期
	 */
	public void setRegEndDate(java.util.Date regEndDate){
		this.regEndDate = regEndDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交流轮岗情况
	 */
	@Column(name ="ROTATE_STATUS",nullable=true,length=100)
	public java.lang.String getRotateStatus(){
		return this.rotateStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交流轮岗情况
	 */
	public void setRotateStatus(java.lang.String rotateStatus){
		this.rotateStatus = rotateStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试用期情况
	 */
	@Column(name ="PROBATION_STATUS",nullable=true,length=100)
	public java.lang.String getProbationStatus(){
		return this.probationStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试用期情况
	 */
	public void setProbationStatus(java.lang.String probationStatus){
		this.probationStatus = probationStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调动原因
	 */
	@Column(name ="TRANSFER_REASON",nullable=true,length=50)
	public java.lang.String getTransferReason(){
		return this.transferReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调动原因
	 */
	public void setTransferReason(java.lang.String transferReason){
		this.transferReason = transferReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在部门
	 */
	@Column(name ="DEPARTMENT",nullable=true,length=200)
	public java.lang.String getDepartment(){
		return this.department;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在部门
	 */
	public void setDepartment(java.lang.String department){
		this.department = department;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  周课时
	 */
	@Column(name ="WEEKLY_HOURS",nullable=true,length=10)
	public java.lang.Integer getWeeklyHours(){
		return this.weeklyHours;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  周课时
	 */
	public void setWeeklyHours(java.lang.Integer weeklyHours){
		this.weeklyHours = weeklyHours;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  服务期截止日期
	 */
	@Column(name ="SERVICE_END_DATE",nullable=true,length=32)
	public java.util.Date getServiceEndDate(){
		return this.serviceEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  服务期截止日期
	 */
	public void setServiceEndDate(java.util.Date serviceEndDate){
		this.serviceEndDate = serviceEndDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务期剩余时间
	 */
	@Column(name ="SERVICE_REMAIN_DATE",nullable=true,length=32)
	public java.lang.String getServiceRemainDate(){
		return this.serviceRemainDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务期剩余时间
	 */
	public void setServiceRemainDate(java.lang.String serviceRemainDate){
		this.serviceRemainDate = serviceRemainDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="COMMENTS",nullable=true,length=200)
	public java.lang.String getComments(){
		return this.comments;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setComments(java.lang.String comments){
		this.comments = comments;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预留字段1
	 */
	@Column(name ="EXTRA1",nullable=true,length=200)
	public java.lang.String getExtra1(){
		return this.extra1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预留字段1
	 */
	public void setExtra1(java.lang.String extra1){
		this.extra1 = extra1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预留字段2
	 */
	@Column(name ="EXTRA2",nullable=true,length=200)
	public java.lang.String getExtra2(){
		return this.extra2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预留字段2
	 */
	public void setExtra2(java.lang.String extra2){
		this.extra2 = extra2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预留字段3
	 */
	@Column(name ="EXTRA3",nullable=true,length=200)
	public java.lang.String getExtra3(){
		return this.extra3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预留字段3
	 */
	public void setExtra3(java.lang.String extra3){
		this.extra3 = extra3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预留字段4
	 */
	@Column(name ="EXTRA4",nullable=true,length=200)
	public java.lang.String getExtra4(){
		return this.extra4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预留字段4
	 */
	public void setExtra4(java.lang.String extra4){
		this.extra4 = extra4;
	}
}
