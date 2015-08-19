package com.buss.status.entity;

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
 * @Description: 状态变动
 * @author onlineGenerator
 * @date 2015-07-19 11:33:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_status", schema = "")
@SuppressWarnings("serial")
public class ZformPersonStatusEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**变更前状态*/
	@Excel(name="变更前状态")
	private java.lang.String prevStatus;
	/**变更后状态*/
	@Excel(name="变更后状态")
	private java.lang.String afterStatus;
	/**变更原因*/
	@Excel(name="变更原因")
	private java.lang.String stateChangeReason;
	/**变更日期*/
	@Excel(name="变更日期")
	private java.util.Date statusChangeDate;
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
	 *@return: java.lang.String  变更前状态
	 */
	@Column(name ="PREV_STATUS",nullable=true,length=32)
	public java.lang.String getPrevStatus(){
		return this.prevStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变更前状态
	 */
	public void setPrevStatus(java.lang.String prevStatus){
		this.prevStatus = prevStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变更后状态
	 */
	@Column(name ="AFTER_STATUS",nullable=true,length=32)
	public java.lang.String getAfterStatus(){
		return this.afterStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变更后状态
	 */
	public void setAfterStatus(java.lang.String afterStatus){
		this.afterStatus = afterStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变更原因
	 */
	@Column(name ="STATE_CHANGE_REASON",nullable=true,length=32)
	public java.lang.String getStateChangeReason(){
		return this.stateChangeReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变更原因
	 */
	public void setStateChangeReason(java.lang.String stateChangeReason){
		this.stateChangeReason = stateChangeReason;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  变更日期
	 */
	@Column(name ="STATUS_CHANGE_DATE",nullable=true,length=32)
	public java.util.Date getStatusChangeDate(){
		return this.statusChangeDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  变更日期
	 */
	public void setStatusChangeDate(java.util.Date statusChangeDate){
		this.statusChangeDate = statusChangeDate;
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
