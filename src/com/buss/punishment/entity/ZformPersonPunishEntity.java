package com.buss.punishment.entity;

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
 * @Description: 处分
 * @author onlineGenerator
 * @date 2015-07-19 11:33:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_punish", schema = "")
@SuppressWarnings("serial")
public class ZformPersonPunishEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**所受处分情况*/
	@Excel(name="所受处分情况")
	private java.lang.String punishment;
	/**所受处分到期日期*/
	@Excel(name="所受处分到期日期")
	private java.util.Date punishmentEndDate;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所受处分情况
	 */
	@Column(name ="PUNISHMENT",nullable=true,length=200)
	public java.lang.String getPunishment(){
		return this.punishment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所受处分情况
	 */
	public void setPunishment(java.lang.String punishment){
		this.punishment = punishment;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  所受处分到期日期
	 */
	@Column(name ="PUNISHMENT_END_DATE",nullable=true,length=32)
	public java.util.Date getPunishmentEndDate(){
		return this.punishmentEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  所受处分到期日期
	 */
	public void setPunishmentEndDate(java.util.Date punishmentEndDate){
		this.punishmentEndDate = punishmentEndDate;
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
