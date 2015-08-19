package com.buss.retire.entity;

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
 * @Description: 退休
 * @author onlineGenerator
 * @date 2015-07-19 11:33:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_retire", schema = "")
@SuppressWarnings("serial")
public class ZformPersonRetireEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**退休证号*/
	@Excel(name="退休证号")
	private java.lang.String retireCardNo;
	/**退休时单位*/
	@Excel(name="退休时单位")
	private java.lang.String retireSchool;
	/**连续工龄*/
	@Excel(name="连续工龄")
	private java.lang.String workAge;
	/**退休时岗位*/
	@Excel(name="退休时岗位")
	private java.lang.String retireJob;
	/**退休时岗位级别*/
	@Excel(name="退休时岗位级别")
	private java.lang.String retireJobLevel;
	/**退休时薪级*/
	@Excel(name="退休时薪级")
	private java.lang.String retireRankLevel;
	/**退休时身份*/
	@Excel(name="退休时身份")
	private java.lang.String retireIdentity;
	/**退休日期*/
	@Excel(name="退休日期")
	private java.util.Date retireDate;
	/**开始领取退休金日期*/
	@Excel(name="开始领取退休金日期")
	private java.util.Date pensionStartDate;
	/**退休审批日期*/
	@Excel(name="退休审批日期")
	private java.util.Date auditDate;
	/**岗位工资*/
	@Excel(name="岗位工资")
	private java.lang.Double jobSalary;
	/**岗位工资规定比例*/
	private java.lang.Integer jobSalaryP;
	/**岗位工资提高比例*/
	private java.lang.Integer jobSalaryUpP;
	/**岗位工资实际比例*/
	private java.lang.Integer jobSalarySumP;
	/**薪级工资*/
	@Excel(name="薪级工资")
	private java.lang.Double rankSalary;
	/**薪级工资规定比例*/
	private java.lang.Integer rankSalaryP;
	/**薪级工资提高比例*/
	private java.lang.Integer rankSalaryUpP;
	/**薪级工资实际比例*/
	private java.lang.Integer rankSalarySumP;
	/**百分之十部分*/
	@Excel(name="百分之十部分")
	private java.lang.Double extraSalary;
	/**百分之十规定比例*/
	private java.lang.Integer extraSalaryP;
	/**百分之十提高比例*/
	private java.lang.Integer extraSalaryUpP;
	/**百分之十实际比例*/
	private java.lang.Integer extraSalarySumP;
	/**特教津贴*/
	@Excel(name="特教津贴")
	private java.lang.Double teachExtra;
	/**特教津贴规定比例*/
	private java.lang.Integer teachExtraP;
	/**特教津贴提高比例*/
	private java.lang.Integer teachExtraUpP;
	/**特教津贴实际比例*/
	private java.lang.Integer teachExtraSumP;
	/**教龄津贴*/
	@Excel(name="教龄津贴")
	private java.lang.Double teachAgeExtra;
	/**07年生活补贴*/
	@Excel(name="07年生活补贴")
	private java.lang.Double liveExtra2007;
	/**10年按职务增加补贴*/
	@Excel(name="10年按职务增加补贴")
	private java.lang.Double dutyExtra2010;
	/**10年按年龄增加补贴*/
	@Excel(name="10年按年龄增加补贴")
	private java.lang.Double ageExtra2010;
	/**11年事业增加补贴*/
	@Excel(name="11年事业增加补贴")
	private java.lang.Double instituteExtra2011;
	/**13年事业增加补贴*/
	@Excel(name="13年事业增加补贴")
	private java.lang.Double instituteExtra2013;
	/**14年事业增加补贴*/
	@Excel(name="14年事业增加补贴")
	private java.lang.Double instituteExtra2014;
	/**11年增长机制补贴*/
	@Excel(name="11年增长机制补贴")
	private java.lang.Double growthExtra2011;
	/**11年工作年限补贴*/
	@Excel(name="11年工作年限补贴")
	private java.lang.Double workAgeExtra2011;
	/**11年提高退休费补贴*/
	@Excel(name="11年提高退休费补贴")
	private java.lang.Double pensionUpgrade2011;
	/**公有住房提租补贴*/
	@Excel(name="公有住房提租补贴")
	private java.lang.Double houseRentExtra;
	/**书报洗理费*/
	@Excel(name="书报洗理费")
	private java.lang.Double bookExtra;
	/**包干结余奖*/
	@Excel(name="包干结余奖")
	private java.lang.Double surplusExtra;
	/**劳模荣誉津贴*/
	@Excel(name="劳模荣誉津贴")
	private java.lang.Double workModelExtra;
	/**特级教师津贴*/
	@Excel(name="特级教师津贴")
	private java.lang.Double seniorTeacherExtra;
	/**事业基本退休费*/
	@Excel(name="事业基本退休费")
	private java.lang.Double instituteBasic;
	/**公务员职务工资*/
	@Excel(name="公务员职务工资")
	private java.lang.Double dutySalary1;
	/**公务员级别工资*/
	@Excel(name="公务员级别工资")
	private java.lang.Double rankSalary1;
	/**公务员警衔津贴*/
	@Excel(name="公务员警衔津贴")
	private java.lang.Double policeRankSalary1;
	/**公务员职务补贴*/
	@Excel(name="公务员职务补贴")
	private java.lang.Double dutyExtra1;
	/**公务员年龄补贴*/
	@Excel(name="公务员年龄补贴")
	private java.lang.Double ageExtra1;
	/**公务员工作年限补贴*/
	@Excel(name="公务员工作年限补贴")
	private java.lang.Double workAgeExtra1;
	/**公务员提高退休费补贴*/
	@Excel(name="公务员提高退休费补贴")
	private java.lang.Double pensionUpgrade1;
	/**公务员基本退休费*/
	@Excel(name="公务员基本退休费")
	private java.lang.Double serventBasic1;
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
	@Column(name ="CODE",nullable=true,length=32)
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
	 *@return: java.lang.String  退休证号
	 */
	@Column(name ="RETIRE_CARD_NO",nullable=true,length=32)
	public java.lang.String getRetireCardNo(){
		return this.retireCardNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退休证号
	 */
	public void setRetireCardNo(java.lang.String retireCardNo){
		this.retireCardNo = retireCardNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退休时单位
	 */
	@Column(name ="RETIRE_SCHOOL",nullable=true,length=200)
	public java.lang.String getRetireSchool(){
		return this.retireSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退休时单位
	 */
	public void setRetireSchool(java.lang.String retireSchool){
		this.retireSchool = retireSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  连续工龄
	 */
	@Column(name ="WORK_AGE",nullable=true,length=32)
	public java.lang.String getWorkAge(){
		return this.workAge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  连续工龄
	 */
	public void setWorkAge(java.lang.String workAge){
		this.workAge = workAge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退休时岗位
	 */
	@Column(name ="RETIRE_JOB",nullable=true,length=32)
	public java.lang.String getRetireJob(){
		return this.retireJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退休时岗位
	 */
	public void setRetireJob(java.lang.String retireJob){
		this.retireJob = retireJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退休时岗位级别
	 */
	@Column(name ="RETIRE_JOB_LEVEL",nullable=true,length=32)
	public java.lang.String getRetireJobLevel(){
		return this.retireJobLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退休时岗位级别
	 */
	public void setRetireJobLevel(java.lang.String retireJobLevel){
		this.retireJobLevel = retireJobLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退休时薪级
	 */
	@Column(name ="RETIRE_RANK_LEVEL",nullable=true,length=32)
	public java.lang.String getRetireRankLevel(){
		return this.retireRankLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退休时薪级
	 */
	public void setRetireRankLevel(java.lang.String retireRankLevel){
		this.retireRankLevel = retireRankLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退休时身份
	 */
	@Column(name ="RETIRE_IDENTITY",nullable=true,length=32)
	public java.lang.String getRetireIdentity(){
		return this.retireIdentity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退休时身份
	 */
	public void setRetireIdentity(java.lang.String retireIdentity){
		this.retireIdentity = retireIdentity;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  退休日期
	 */
	@Column(name ="RETIRE_DATE",nullable=true,length=32)
	public java.util.Date getRetireDate(){
		return this.retireDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  退休日期
	 */
	public void setRetireDate(java.util.Date retireDate){
		this.retireDate = retireDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始领取退休金日期
	 */
	@Column(name ="PENSION_START_DATE",nullable=true,length=32)
	public java.util.Date getPensionStartDate(){
		return this.pensionStartDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始领取退休金日期
	 */
	public void setPensionStartDate(java.util.Date pensionStartDate){
		this.pensionStartDate = pensionStartDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  退休审批日期
	 */
	@Column(name ="AUDIT_DATE",nullable=true,length=32)
	public java.util.Date getAuditDate(){
		return this.auditDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  退休审批日期
	 */
	public void setAuditDate(java.util.Date auditDate){
		this.auditDate = auditDate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  岗位工资
	 */
	@Column(name ="JOB_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getJobSalary(){
		return this.jobSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  岗位工资
	 */
	public void setJobSalary(java.lang.Double jobSalary){
		this.jobSalary = jobSalary;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  岗位工资规定比例
	 */
	@Column(name ="JOB_SALARY_P",nullable=true,length=10)
	public java.lang.Integer getJobSalaryP(){
		return this.jobSalaryP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  岗位工资规定比例
	 */
	public void setJobSalaryP(java.lang.Integer jobSalaryP){
		this.jobSalaryP = jobSalaryP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  岗位工资提高比例
	 */
	@Column(name ="JOB_SALARY_UP_P",nullable=true,length=10)
	public java.lang.Integer getJobSalaryUpP(){
		return this.jobSalaryUpP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  岗位工资提高比例
	 */
	public void setJobSalaryUpP(java.lang.Integer jobSalaryUpP){
		this.jobSalaryUpP = jobSalaryUpP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  岗位工资实际比例
	 */
	@Column(name ="JOB_SALARY_SUM_P",nullable=true,length=10)
	public java.lang.Integer getJobSalarySumP(){
		return this.jobSalarySumP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  岗位工资实际比例
	 */
	public void setJobSalarySumP(java.lang.Integer jobSalarySumP){
		this.jobSalarySumP = jobSalarySumP;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  薪级工资
	 */
	@Column(name ="RANK_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getRankSalary(){
		return this.rankSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  薪级工资
	 */
	public void setRankSalary(java.lang.Double rankSalary){
		this.rankSalary = rankSalary;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  薪级工资规定比例
	 */
	@Column(name ="RANK_SALARY_P",nullable=true,length=10)
	public java.lang.Integer getRankSalaryP(){
		return this.rankSalaryP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  薪级工资规定比例
	 */
	public void setRankSalaryP(java.lang.Integer rankSalaryP){
		this.rankSalaryP = rankSalaryP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  薪级工资提高比例
	 */
	@Column(name ="RANK_SALARY_UP_P",nullable=true,length=10)
	public java.lang.Integer getRankSalaryUpP(){
		return this.rankSalaryUpP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  薪级工资提高比例
	 */
	public void setRankSalaryUpP(java.lang.Integer rankSalaryUpP){
		this.rankSalaryUpP = rankSalaryUpP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  薪级工资实际比例
	 */
	@Column(name ="RANK_SALARY_SUM_P",nullable=true,length=10)
	public java.lang.Integer getRankSalarySumP(){
		return this.rankSalarySumP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  薪级工资实际比例
	 */
	public void setRankSalarySumP(java.lang.Integer rankSalarySumP){
		this.rankSalarySumP = rankSalarySumP;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  百分之十部分
	 */
	@Column(name ="EXTRA_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getExtraSalary(){
		return this.extraSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  百分之十部分
	 */
	public void setExtraSalary(java.lang.Double extraSalary){
		this.extraSalary = extraSalary;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  百分之十规定比例
	 */
	@Column(name ="EXTRA_SALARY_P",nullable=true,length=10)
	public java.lang.Integer getExtraSalaryP(){
		return this.extraSalaryP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  百分之十规定比例
	 */
	public void setExtraSalaryP(java.lang.Integer extraSalaryP){
		this.extraSalaryP = extraSalaryP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  百分之十提高比例
	 */
	@Column(name ="EXTRA_SALARY_UP_P",nullable=true,length=10)
	public java.lang.Integer getExtraSalaryUpP(){
		return this.extraSalaryUpP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  百分之十提高比例
	 */
	public void setExtraSalaryUpP(java.lang.Integer extraSalaryUpP){
		this.extraSalaryUpP = extraSalaryUpP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  百分之十实际比例
	 */
	@Column(name ="EXTRA_SALARY_SUM_P",nullable=true,length=10)
	public java.lang.Integer getExtraSalarySumP(){
		return this.extraSalarySumP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  百分之十实际比例
	 */
	public void setExtraSalarySumP(java.lang.Integer extraSalarySumP){
		this.extraSalarySumP = extraSalarySumP;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  特教津贴
	 */
	@Column(name ="TEACH_EXTRA",nullable=true,scale=2,length=10)
	public java.lang.Double getTeachExtra(){
		return this.teachExtra;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  特教津贴
	 */
	public void setTeachExtra(java.lang.Double teachExtra){
		this.teachExtra = teachExtra;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  特教津贴规定比例
	 */
	@Column(name ="TEACH_EXTRA_P",nullable=true,length=10)
	public java.lang.Integer getTeachExtraP(){
		return this.teachExtraP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  特教津贴规定比例
	 */
	public void setTeachExtraP(java.lang.Integer teachExtraP){
		this.teachExtraP = teachExtraP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  特教津贴提高比例
	 */
	@Column(name ="TEACH_EXTRA_UP_P",nullable=true,length=10)
	public java.lang.Integer getTeachExtraUpP(){
		return this.teachExtraUpP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  特教津贴提高比例
	 */
	public void setTeachExtraUpP(java.lang.Integer teachExtraUpP){
		this.teachExtraUpP = teachExtraUpP;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  特教津贴实际比例
	 */
	@Column(name ="TEACH_EXTRA_SUM_P",nullable=true,length=10)
	public java.lang.Integer getTeachExtraSumP(){
		return this.teachExtraSumP;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  特教津贴实际比例
	 */
	public void setTeachExtraSumP(java.lang.Integer teachExtraSumP){
		this.teachExtraSumP = teachExtraSumP;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  教龄津贴
	 */
	@Column(name ="TEACH_AGE_EXTRA",nullable=true,scale=2,length=10)
	public java.lang.Double getTeachAgeExtra(){
		return this.teachAgeExtra;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  教龄津贴
	 */
	public void setTeachAgeExtra(java.lang.Double teachAgeExtra){
		this.teachAgeExtra = teachAgeExtra;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  07年生活补贴
	 */
	@Column(name ="LIVE_EXTRA_2007",nullable=true,scale=2,length=10)
	public java.lang.Double getLiveExtra2007(){
		return this.liveExtra2007;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  07年生活补贴
	 */
	public void setLiveExtra2007(java.lang.Double liveExtra2007){
		this.liveExtra2007 = liveExtra2007;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  10年按职务增加补贴
	 */
	@Column(name ="DUTY_EXTRA_2010",nullable=true,scale=2,length=10)
	public java.lang.Double getDutyExtra2010(){
		return this.dutyExtra2010;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  10年按职务增加补贴
	 */
	public void setDutyExtra2010(java.lang.Double dutyExtra2010){
		this.dutyExtra2010 = dutyExtra2010;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  10年按年龄增加补贴
	 */
	@Column(name ="AGE_EXTRA_2010",nullable=true,scale=2,length=10)
	public java.lang.Double getAgeExtra2010(){
		return this.ageExtra2010;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  10年按年龄增加补贴
	 */
	public void setAgeExtra2010(java.lang.Double ageExtra2010){
		this.ageExtra2010 = ageExtra2010;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  11年事业增加补贴
	 */
	@Column(name ="INSTITUTE_EXTRA_2011",nullable=true,scale=2,length=10)
	public java.lang.Double getInstituteExtra2011(){
		return this.instituteExtra2011;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  11年事业增加补贴
	 */
	public void setInstituteExtra2011(java.lang.Double instituteExtra2011){
		this.instituteExtra2011 = instituteExtra2011;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  13年事业增加补贴
	 */
	@Column(name ="INSTITUTE_EXTRA_2013",nullable=true,scale=2,length=10)
	public java.lang.Double getInstituteExtra2013(){
		return this.instituteExtra2013;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  13年事业增加补贴
	 */
	public void setInstituteExtra2013(java.lang.Double instituteExtra2013){
		this.instituteExtra2013 = instituteExtra2013;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  14年事业增加补贴
	 */
	@Column(name ="INSTITUTE_EXTRA_2014",nullable=true,scale=2,length=10)
	public java.lang.Double getInstituteExtra2014(){
		return this.instituteExtra2014;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  14年事业增加补贴
	 */
	public void setInstituteExtra2014(java.lang.Double instituteExtra2014){
		this.instituteExtra2014 = instituteExtra2014;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  11年增长机制补贴
	 */
	@Column(name ="GROWTH_EXTRA_2011",nullable=true,scale=2,length=10)
	public java.lang.Double getGrowthExtra2011(){
		return this.growthExtra2011;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  11年增长机制补贴
	 */
	public void setGrowthExtra2011(java.lang.Double growthExtra2011){
		this.growthExtra2011 = growthExtra2011;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  11年工作年限补贴
	 */
	@Column(name ="WORK_AGE_EXTRA_2011",nullable=true,scale=2,length=10)
	public java.lang.Double getWorkAgeExtra2011(){
		return this.workAgeExtra2011;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  11年工作年限补贴
	 */
	public void setWorkAgeExtra2011(java.lang.Double workAgeExtra2011){
		this.workAgeExtra2011 = workAgeExtra2011;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  11年提高退休费补贴
	 */
	@Column(name ="PENSION_UPGRADE_2011",nullable=true,scale=2,length=10)
	public java.lang.Double getPensionUpgrade2011(){
		return this.pensionUpgrade2011;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  11年提高退休费补贴
	 */
	public void setPensionUpgrade2011(java.lang.Double pensionUpgrade2011){
		this.pensionUpgrade2011 = pensionUpgrade2011;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公有住房提租补贴
	 */
	@Column(name ="HOUSE_RENT_EXTRA",nullable=true,scale=2,length=10)
	public java.lang.Double getHouseRentExtra(){
		return this.houseRentExtra;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公有住房提租补贴
	 */
	public void setHouseRentExtra(java.lang.Double houseRentExtra){
		this.houseRentExtra = houseRentExtra;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  书报洗理费
	 */
	@Column(name ="BOOK_EXTRA",nullable=true,scale=2,length=10)
	public java.lang.Double getBookExtra(){
		return this.bookExtra;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  书报洗理费
	 */
	public void setBookExtra(java.lang.Double bookExtra){
		this.bookExtra = bookExtra;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  包干结余奖
	 */
	@Column(name ="SURPLUS_EXTRA",nullable=true,scale=2,length=10)
	public java.lang.Double getSurplusExtra(){
		return this.surplusExtra;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  包干结余奖
	 */
	public void setSurplusExtra(java.lang.Double surplusExtra){
		this.surplusExtra = surplusExtra;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  劳模荣誉津贴
	 */
	@Column(name ="WORK_MODEL_EXTRA",nullable=true,scale=2,length=10)
	public java.lang.Double getWorkModelExtra(){
		return this.workModelExtra;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  劳模荣誉津贴
	 */
	public void setWorkModelExtra(java.lang.Double workModelExtra){
		this.workModelExtra = workModelExtra;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  特级教师津贴
	 */
	@Column(name ="SENIOR_TEACHER_EXTRA",nullable=true,scale=2,length=10)
	public java.lang.Double getSeniorTeacherExtra(){
		return this.seniorTeacherExtra;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  特级教师津贴
	 */
	public void setSeniorTeacherExtra(java.lang.Double seniorTeacherExtra){
		this.seniorTeacherExtra = seniorTeacherExtra;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  事业基本退休费
	 */
	@Column(name ="INSTITUTE_BASIC",nullable=true,scale=2,length=10)
	public java.lang.Double getInstituteBasic(){
		return this.instituteBasic;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  事业基本退休费
	 */
	public void setInstituteBasic(java.lang.Double instituteBasic){
		this.instituteBasic = instituteBasic;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员职务工资
	 */
	@Column(name ="DUTY_SALARY_1",nullable=true,scale=2,length=10)
	public java.lang.Double getDutySalary1(){
		return this.dutySalary1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员职务工资
	 */
	public void setDutySalary1(java.lang.Double dutySalary1){
		this.dutySalary1 = dutySalary1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员级别工资
	 */
	@Column(name ="RANK_SALARY_1",nullable=true,scale=2,length=10)
	public java.lang.Double getRankSalary1(){
		return this.rankSalary1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员级别工资
	 */
	public void setRankSalary1(java.lang.Double rankSalary1){
		this.rankSalary1 = rankSalary1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员警衔津贴
	 */
	@Column(name ="POLICE_RANK_SALARY_1",nullable=true,scale=2,length=10)
	public java.lang.Double getPoliceRankSalary1(){
		return this.policeRankSalary1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员警衔津贴
	 */
	public void setPoliceRankSalary1(java.lang.Double policeRankSalary1){
		this.policeRankSalary1 = policeRankSalary1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员职务补贴
	 */
	@Column(name ="DUTY_EXTRA_1",nullable=true,scale=2,length=10)
	public java.lang.Double getDutyExtra1(){
		return this.dutyExtra1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员职务补贴
	 */
	public void setDutyExtra1(java.lang.Double dutyExtra1){
		this.dutyExtra1 = dutyExtra1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员年龄补贴
	 */
	@Column(name ="AGE_EXTRA_1",nullable=true,scale=2,length=10)
	public java.lang.Double getAgeExtra1(){
		return this.ageExtra1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员年龄补贴
	 */
	public void setAgeExtra1(java.lang.Double ageExtra1){
		this.ageExtra1 = ageExtra1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员工作年限补贴
	 */
	@Column(name ="WORK_AGE_EXTRA_1",nullable=true,scale=2,length=10)
	public java.lang.Double getWorkAgeExtra1(){
		return this.workAgeExtra1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员工作年限补贴
	 */
	public void setWorkAgeExtra1(java.lang.Double workAgeExtra1){
		this.workAgeExtra1 = workAgeExtra1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员提高退休费补贴
	 */
	@Column(name ="PENSION_UPGRADE_1",nullable=true,scale=2,length=10)
	public java.lang.Double getPensionUpgrade1(){
		return this.pensionUpgrade1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员提高退休费补贴
	 */
	public void setPensionUpgrade1(java.lang.Double pensionUpgrade1){
		this.pensionUpgrade1 = pensionUpgrade1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公务员基本退休费
	 */
	@Column(name ="SERVENT_BASIC_1",nullable=true,scale=2,length=10)
	public java.lang.Double getServentBasic1(){
		return this.serventBasic1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公务员基本退休费
	 */
	public void setServentBasic1(java.lang.Double serventBasic1){
		this.serventBasic1 = serventBasic1;
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
