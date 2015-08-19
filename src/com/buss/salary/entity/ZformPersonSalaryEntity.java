package com.buss.salary.entity;

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
 * @Description: 薪资管理
 * @author onlineGenerator
 * @date 2015-07-19 11:33:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_salary", schema = "")
@SuppressWarnings("serial")
public class ZformPersonSalaryEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**序号*/
	@Excel(name="序号")
	private java.lang.Integer seqNo;
	/**年度*/
	@Excel(name="年度")
	private java.lang.String year;
	/**变动原因*/
	@Excel(name="变动原因")
	private java.lang.String changeReason;
	/**变动生效日期*/
	@Excel(name="变动生效日期")
	private java.util.Date effectiveDate;
	/**原岗位*/
	@Excel(name="原岗位")
	private java.lang.String prevJob;
	/**原岗位等级*/
	@Excel(name="原岗位等级")
	private java.lang.String prevJobLevel;
	/**原岗位类型*/
	@Excel(name="原岗位类型")
	private java.lang.String prevJobType;
	/**原岗位工资*/
	@Excel(name="原岗位工资")
	private java.lang.Double prevJobSalary;
	/**原薪级*/
	@Excel(name="原薪级")
	private java.lang.String prevRankLevel;
	/**原薪级工资*/
	@Excel(name="原薪级工资")
	private java.lang.Double prevRankSalary;
	/**原百分之十*/
	@Excel(name="原百分之十")
	private java.lang.Double prevExtraSalary;
	/**新岗位*/
	@Excel(name="新岗位")
	private java.lang.String newJob;
	/**新岗位等级*/
	@Excel(name="新岗位等级")
	private java.lang.String newJobLevel;
	/**新岗位类型*/
	@Excel(name="新岗位类型")
	private java.lang.String newJobType;
	/**新岗位工资*/
	@Excel(name="新岗位工资")
	private java.lang.Double newJobSalary;
	/**新薪级*/
	@Excel(name="新薪级")
	private java.lang.String newRankLevel;
	/**新薪级工资*/
	@Excel(name="新薪级工资")
	private java.lang.Double newRankSalary;
	/**新百分之十*/
	@Excel(name="新百分之十")
	private java.lang.Double newExtraSalary;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String comments;
	/**备用字段1*/
	private java.lang.String extra1;
	/**备用字段2*/
	private java.lang.String extra2;
	
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  序号
	 */
	@Column(name ="SEQ_NO",nullable=true,length=10)
	public java.lang.Integer getSeqNo(){
		return this.seqNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  序号
	 */
	public void setSeqNo(java.lang.Integer seqNo){
		this.seqNo = seqNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年度
	 */
	@Column(name ="YEAR",nullable=false,scale=2,length=10)
	public java.lang.String getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年度
	 */
	public void setYear(java.lang.String year){
		this.year = year;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动原因
	 */
	@Column(name ="CHANGE_REASON",nullable=true,length=200)
	public java.lang.String getChangeReason(){
		return this.changeReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动原因
	 */
	public void setChangeReason(java.lang.String changeReason){
		this.changeReason = changeReason;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  变动生效日期
	 */
	@Column(name ="EFFECTIVE_DATE",nullable=false,length=32)
	public java.util.Date getEffectiveDate(){
		return this.effectiveDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  变动生效日期
	 */
	public void setEffectiveDate(java.util.Date effectiveDate){
		this.effectiveDate = effectiveDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原岗位
	 */
	@Column(name ="PREV_JOB",nullable=true,length=32)
	public java.lang.String getPrevJob(){
		return this.prevJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原岗位
	 */
	public void setPrevJob(java.lang.String prevJob){
		this.prevJob = prevJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原岗位等级
	 */
	@Column(name ="PREV_JOB_LEVEL",nullable=true,length=32)
	public java.lang.String getPrevJobLevel(){
		return this.prevJobLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原岗位等级
	 */
	public void setPrevJobLevel(java.lang.String prevJobLevel){
		this.prevJobLevel = prevJobLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原岗位类型
	 */
	@Column(name ="PREV_JOB_TYPE",nullable=true,length=32)
	public java.lang.String getPrevJobType(){
		return this.prevJobType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原岗位类型
	 */
	public void setPrevJobType(java.lang.String prevJobType){
		this.prevJobType = prevJobType;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  原岗位工资
	 */
	@Column(name ="PREV_JOB_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getPrevJobSalary(){
		return this.prevJobSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  原岗位工资
	 */
	public void setPrevJobSalary(java.lang.Double prevJobSalary){
		this.prevJobSalary = prevJobSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原薪级
	 */
	@Column(name ="PREV_RANK_LEVEL",nullable=true,length=32)
	public java.lang.String getPrevRankLevel(){
		return this.prevRankLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原薪级
	 */
	public void setPrevRankLevel(java.lang.String prevRankLevel){
		this.prevRankLevel = prevRankLevel;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  原薪级工资
	 */
	@Column(name ="PREV_RANK_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getPrevRankSalary(){
		return this.prevRankSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  原薪级工资
	 */
	public void setPrevRankSalary(java.lang.Double prevRankSalary){
		this.prevRankSalary = prevRankSalary;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  原百分之十
	 */
	@Column(name ="PREV_EXTRA_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getPrevExtraSalary(){
		return this.prevExtraSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  原百分之十
	 */
	public void setPrevExtraSalary(java.lang.Double prevExtraSalary){
		this.prevExtraSalary = prevExtraSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新岗位
	 */
	@Column(name ="NEW_JOB",nullable=true,length=32)
	public java.lang.String getNewJob(){
		return this.newJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新岗位
	 */
	public void setNewJob(java.lang.String newJob){
		this.newJob = newJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新岗位等级
	 */
	@Column(name ="NEW_JOB_LEVEL",nullable=true,length=32)
	public java.lang.String getNewJobLevel(){
		return this.newJobLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新岗位等级
	 */
	public void setNewJobLevel(java.lang.String newJobLevel){
		this.newJobLevel = newJobLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新岗位类型
	 */
	@Column(name ="NEW_JOB_TYPE",nullable=true,length=32)
	public java.lang.String getNewJobType(){
		return this.newJobType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新岗位类型
	 */
	public void setNewJobType(java.lang.String newJobType){
		this.newJobType = newJobType;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  新岗位工资
	 */
	@Column(name ="NEW_JOB_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getNewJobSalary(){
		return this.newJobSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  新岗位工资
	 */
	public void setNewJobSalary(java.lang.Double newJobSalary){
		this.newJobSalary = newJobSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新薪级
	 */
	@Column(name ="NEW_RANK_LEVEL",nullable=true,length=32)
	public java.lang.String getNewRankLevel(){
		return this.newRankLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新薪级
	 */
	public void setNewRankLevel(java.lang.String newRankLevel){
		this.newRankLevel = newRankLevel;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  新薪级工资
	 */
	@Column(name ="NEW_RANK_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getNewRankSalary(){
		return this.newRankSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  新薪级工资
	 */
	public void setNewRankSalary(java.lang.Double newRankSalary){
		this.newRankSalary = newRankSalary;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  新百分之十
	 */
	@Column(name ="NEW_EXTRA_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getNewExtraSalary(){
		return this.newExtraSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  新百分之十
	 */
	public void setNewExtraSalary(java.lang.Double newExtraSalary){
		this.newExtraSalary = newExtraSalary;
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
	 *@return: java.lang.String  备用字段1
	 */
	@Column(name ="EXTRA1",nullable=true,length=200)
	public java.lang.String getExtra1(){
		return this.extra1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段1
	 */
	public void setExtra1(java.lang.String extra1){
		this.extra1 = extra1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段2
	 */
	@Column(name ="EXTRA2",nullable=true,length=200)
	public java.lang.String getExtra2(){
		return this.extra2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段2
	 */
	public void setExtra2(java.lang.String extra2){
		this.extra2 = extra2;
	}
}
