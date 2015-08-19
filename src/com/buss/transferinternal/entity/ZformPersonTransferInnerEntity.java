package com.buss.transferinternal.entity;

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
 * @Description: 人员调动
 * @author onlineGenerator
 * @date 2015-07-19 11:33:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_transfer_inner", schema = "")
@SuppressWarnings("serial")
public class ZformPersonTransferInnerEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;	
	/**序号*/
	private java.lang.Integer seqNo;
	/**人员编号*/
	private java.lang.String code;
	/**调出学校*/
	@Excel(name="调出学校")
	private java.lang.String fromSchool;
	/**调入学校*/
	@Excel(name="调入学校")
	private java.lang.String toSchool;
	/**调动日期*/
	@Excel(name="调动日期")
	private java.util.Date transferDate;
	/**商调函日期*/
	@Excel(name="商调函日期")
	private java.util.Date transferLetterDate;
	/**调干通知书日期*/
	@Excel(name="调干通知书日期")
	private java.util.Date notifyLetterDate;
	/**干部介绍信日期*/
	@Excel(name="干部介绍信日期")
	private java.util.Date refLetterDate;
	/**原单位止薪日期*/
	@Excel(name="原单位止薪日期")
	private java.util.Date salaryEndDate;
	/**调动原因*/
	@Excel(name="调动原因")
	private java.lang.String transferReason;
	/**调出前职称*/
	@Excel(name="调出前职称")
	private java.lang.String transferTitle;
	/**是否组织任命*/
	@Excel(name="是否组织任命")
	private java.lang.String nominate;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String comments;
	/**调动状态*/
	@Excel(name="调动状态")
	private java.lang.String transferStatus;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  序号
	 */
	
	@Column(name ="SEQ_NO",nullable=true,length=32)
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
	 *@return: java.lang.String  调出学校
	 */
	@Column(name ="FROM_SCHOOL",nullable=true,length=100)
	public java.lang.String getFromSchool(){
		return this.fromSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调出学校
	 */
	public void setFromSchool(java.lang.String fromSchool){
		this.fromSchool = fromSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调入学校
	 */
	@Column(name ="TO_SCHOOL",nullable=true,length=100)
	public java.lang.String getToSchool(){
		return this.toSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调入学校
	 */
	public void setToSchool(java.lang.String toSchool){
		this.toSchool = toSchool;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  调动日期
	 */
	@Column(name ="TRANSFER_DATE",nullable=true,length=32)
	public java.util.Date getTransferDate(){
		return this.transferDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  调动日期
	 */
	public void setTransferDate(java.util.Date transferDate){
		this.transferDate = transferDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  商调函日期
	 */
	@Column(name ="TRANSFER_LETTER_DATE",nullable=true,length=32)
	public java.util.Date getTransferLetterDate(){
		return this.transferLetterDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  商调函日期
	 */
	public void setTransferLetterDate(java.util.Date transferLetterDate){
		this.transferLetterDate = transferLetterDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  调干通知书日期
	 */
	@Column(name ="NOTIFY_LETTER_DATE",nullable=true,length=32)
	public java.util.Date getNotifyLetterDate(){
		return this.notifyLetterDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  调干通知书日期
	 */
	public void setNotifyLetterDate(java.util.Date notifyLetterDate){
		this.notifyLetterDate = notifyLetterDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  干部介绍信日期
	 */
	@Column(name ="REF_LETTER_DATE",nullable=true,length=32)
	public java.util.Date getRefLetterDate(){
		return this.refLetterDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  干部介绍信日期
	 */
	public void setRefLetterDate(java.util.Date refLetterDate){
		this.refLetterDate = refLetterDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  原单位止薪日期
	 */
	@Column(name ="SALARY_END_DATE",nullable=true,length=32)
	public java.util.Date getSalaryEndDate(){
		return this.salaryEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  原单位止薪日期
	 */
	public void setSalaryEndDate(java.util.Date salaryEndDate){
		this.salaryEndDate = salaryEndDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调动原因
	 */
	@Column(name ="TRANSFER_REASON",nullable=true,length=100)
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
	 *@return: java.lang.String  调出前职称
	 */
	@Column(name ="TRANSFER_TITLE",nullable=true,length=100)
	public java.lang.String getTransferTitle(){
		return this.transferTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调出前职称
	 */
	public void setTransferTitle(java.lang.String transferTitle){
		this.transferTitle = transferTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否组织任命
	 */
	@Column(name ="NOMINATE",nullable=true,length=100)
	public java.lang.String getNominate(){
		return this.nominate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否组织任命
	 */
	public void setNominate(java.lang.String nominate){
		this.nominate = nominate;
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
	 *@return: java.lang.String  调动状态
	 */
	@Column(name ="TRANSFER_STATUS",nullable=true,length=100)
	public java.lang.String getTransferStatus(){
		return this.transferStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调动状态
	 */
	public void setTransferStatus(java.lang.String transferStatus){
		this.transferStatus = transferStatus;
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
