package com.buss.death.entity;

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
 * @Description: 死亡
 * @author onlineGenerator
 * @date 2015-07-19 11:33:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_death", schema = "")
@SuppressWarnings("serial")
public class ZformPersonDeathEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**死亡日期*/
	@Excel(name="死亡日期")
	private java.util.Date deathDate;
	/**死亡审批日期*/
	@Excel(name="死亡审批日期")
	private java.util.Date auditDate;
	/**死亡原因*/
	@Excel(name="死亡原因")
	private java.lang.String deathReason;
	/**丧葬费*/
	@Excel(name="丧葬费")
	private java.lang.Double funeralExp;
	/**基本工资*/
	@Excel(name="基本工资")
	private java.lang.Double basicSalary;
	/**上年度人均支配收入*/
	@Excel(name="上年度人均支配收入")
	private java.lang.Double stateIncomeAvg;
	/**抚恤金合计*/
	@Excel(name="抚恤金合计")
	private java.lang.Double pension;
	/**丧抚费总金额*/
	@Excel(name="丧抚费总金额")
	private java.lang.Double funeralExpTotal;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String comments;
	/**备用字段1*/
	private java.lang.String extra1;
	/**备用字段2*/
	private java.lang.String extra2;
	/**备用字段3*/
	private java.lang.String extra3;
	/**备用字段4*/
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  死亡日期
	 */
	@Column(name ="DEATH_DATE",nullable=true,length=32)
	public java.util.Date getDeathDate(){
		return this.deathDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  死亡日期
	 */
	public void setDeathDate(java.util.Date deathDate){
		this.deathDate = deathDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  死亡审批日期
	 */
	@Column(name ="AUDIT_DATE",nullable=true,length=32)
	public java.util.Date getAuditDate(){
		return this.auditDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  死亡审批日期
	 */
	public void setAuditDate(java.util.Date auditDate){
		this.auditDate = auditDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  死亡原因
	 */
	@Column(name ="DEATH_REASON",nullable=true,length=200)
	public java.lang.String getDeathReason(){
		return this.deathReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  死亡原因
	 */
	public void setDeathReason(java.lang.String deathReason){
		this.deathReason = deathReason;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  丧葬费
	 */
	@Column(name ="FUNERAL_EXP",nullable=true,scale=2,length=10)
	public java.lang.Double getFuneralExp(){
		return this.funeralExp;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  丧葬费
	 */
	public void setFuneralExp(java.lang.Double funeralExp){
		this.funeralExp = funeralExp;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  基本工资
	 */
	@Column(name ="BASIC_SALARY",nullable=true,scale=2,length=10)
	public java.lang.Double getBasicSalary(){
		return this.basicSalary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  基本工资
	 */
	public void setBasicSalary(java.lang.Double basicSalary){
		this.basicSalary = basicSalary;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  上年度人均支配收入
	 */
	@Column(name ="STATE_INCOME_AVG",nullable=true,scale=2,length=10)
	public java.lang.Double getStateIncomeAvg(){
		return this.stateIncomeAvg;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  上年度人均支配收入
	 */
	public void setStateIncomeAvg(java.lang.Double stateIncomeAvg){
		this.stateIncomeAvg = stateIncomeAvg;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  抚恤金合计
	 */
	@Column(name ="PENSION",nullable=true,scale=2,length=10)
	public java.lang.Double getPension(){
		return this.pension;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  抚恤金合计
	 */
	public void setPension(java.lang.Double pension){
		this.pension = pension;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  丧抚费总金额
	 */
	@Column(name ="FUNERAL_EXP_TOTAL",nullable=true,scale=2,length=10)
	public java.lang.Double getFuneralExpTotal(){
		return this.funeralExpTotal;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  丧抚费总金额
	 */
	public void setFuneralExpTotal(java.lang.Double funeralExpTotal){
		this.funeralExpTotal = funeralExpTotal;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段3
	 */
	@Column(name ="EXTRA3",nullable=true,length=200)
	public java.lang.String getExtra3(){
		return this.extra3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段3
	 */
	public void setExtra3(java.lang.String extra3){
		this.extra3 = extra3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段4
	 */
	@Column(name ="EXTRA4",nullable=true,length=200)
	public java.lang.String getExtra4(){
		return this.extra4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段4
	 */
	public void setExtra4(java.lang.String extra4){
		this.extra4 = extra4;
	}
}
