package com.buss.transferexternal.entity;

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
 * @Description: 调出
 * @author onlineGenerator
 * @date 2015-07-19 11:33:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_transfer_external", schema = "")
@SuppressWarnings("serial")
public class ZformPersonTransferExternalEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**调出单位*/
	@Excel(name="调出单位")
	private java.lang.String fromSchool;
	/**调往单位*/
	@Excel(name="调往单位")
	private java.lang.String toSchool;
	/**调往单位所在区县*/
	@Excel(name="调往单位所在区县")
	private java.lang.String toSchoolAddress;
	/**干部介绍信编号*/
	@Excel(name="干部介绍信编号")
	private java.lang.String refLetterNo;
	/**干部介绍信开具日期*/
	@Excel(name="干部介绍信开具日期")
	private java.util.Date refLetterDate;
	/**工资止薪日期*/
	@Excel(name="工资止薪日期")
	private java.util.Date salaryEndDate;
	/**违约金情况*/
	@Excel(name="违约金情况")
	private java.lang.String penalityStatus;
	/**违约金数额*/
	@Excel(name="违约金数额")
	private java.lang.Double penalityAmount;
	/**调动原因*/
	@Excel(name="调动原因")
	private java.lang.String transferReason;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调出单位
	 */
	@Column(name ="FROM_SCHOOL",nullable=true,length=50)
	public java.lang.String getFromSchool(){
		return this.fromSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调出单位
	 */
	public void setFromSchool(java.lang.String fromSchool){
		this.fromSchool = fromSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调往单位
	 */
	@Column(name ="TO_SCHOOL",nullable=true,length=200)
	public java.lang.String getToSchool(){
		return this.toSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调往单位
	 */
	public void setToSchool(java.lang.String toSchool){
		this.toSchool = toSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调往单位所在区县
	 */
	@Column(name ="TO_SCHOOL_ADDRESS",nullable=true,length=200)
	public java.lang.String getToSchoolAddress(){
		return this.toSchoolAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调往单位所在区县
	 */
	public void setToSchoolAddress(java.lang.String toSchoolAddress){
		this.toSchoolAddress = toSchoolAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  干部介绍信编号
	 */
	@Column(name ="REF_LETTER_NO",nullable=true,length=200)
	public java.lang.String getRefLetterNo(){
		return this.refLetterNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  干部介绍信编号
	 */
	public void setRefLetterNo(java.lang.String refLetterNo){
		this.refLetterNo = refLetterNo;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  干部介绍信开具日期
	 */
	@Column(name ="REF_LETTER_DATE",nullable=true,length=32)
	public java.util.Date getRefLetterDate(){
		return this.refLetterDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  干部介绍信开具日期
	 */
	public void setRefLetterDate(java.util.Date refLetterDate){
		this.refLetterDate = refLetterDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  工资止薪日期
	 */
	@Column(name ="SALARY_END_DATE",nullable=true,length=32)
	public java.util.Date getSalaryEndDate(){
		return this.salaryEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  工资止薪日期
	 */
	public void setSalaryEndDate(java.util.Date salaryEndDate){
		this.salaryEndDate = salaryEndDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违约金情况
	 */
	@Column(name ="PENALITY_STATUS",nullable=true,length=200)
	public java.lang.String getPenalityStatus(){
		return this.penalityStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违约金情况
	 */
	public void setPenalityStatus(java.lang.String penalityStatus){
		this.penalityStatus = penalityStatus;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  违约金数额
	 */
	@Column(name ="PENALITY_AMOUNT",nullable=true,scale=2,length=10)
	public java.lang.Double getPenalityAmount(){
		return this.penalityAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  违约金数额
	 */
	public void setPenalityAmount(java.lang.Double penalityAmount){
		this.penalityAmount = penalityAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调动原因
	 */
	@Column(name ="TRANSFER_REASON",nullable=true,length=200)
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
