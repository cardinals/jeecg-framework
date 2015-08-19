package com.buss.title.entity;

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
 * @Description: 职务变动
 * @author onlineGenerator
 * @date 2015-07-19 11:33:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_title", schema = "")
@SuppressWarnings("serial")
public class ZformPersonTitleEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**个人编号*/
	private java.lang.String code;
	/**原职称*/
	@Excel(name="原职称")
	private java.lang.String prevTitle;
	/**原职称扩充*/
	@Excel(name="原职称扩充")
	private java.lang.String prevTitleExtra;
	/**原岗位*/
	@Excel(name="原岗位")
	private java.lang.String prevJob;
	/**原岗位扩充*/
	@Excel(name="原岗位扩充")
	private java.lang.String prevJobExtra;
	/**原岗位等级*/
	@Excel(name="原岗位等级")
	private java.lang.String prevJobLevel;
	/**原岗位类型*/
	@Excel(name="原岗位类型")
	private java.lang.String prevJobType;
	/**新职称*/
	@Excel(name="新职称")
	private java.lang.String newTitle;
	/**新职称扩充*/
	@Excel(name="新职称扩充")
	private java.lang.String newTitleExtra;
	/**新岗位*/
	@Excel(name="新岗位")
	private java.lang.String newJob;
	/**新岗位扩充*/
	@Excel(name="新岗位扩充")
	private java.lang.String newJobExtra;
	/**新岗位等级*/
	@Excel(name="新岗位等级")
	private java.lang.String newJobLevel;
	/**新岗位类型*/
	@Excel(name="新岗位类型")
	private java.lang.String newJobType;
	/**职务变动原因*/
	@Excel(name="职务变动原因")
	private java.lang.String changeReason;
	/**职务变动生效日期*/
	@Excel(name="职务变动生效日期")
	private java.util.Date effectiveDate;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String comments;
	/**备用字段1 */
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
	 *@return: java.lang.String  个人编号
	 */
	@Column(name ="CODE",nullable=false,length=32)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人编号
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原职称
	 */
	@Column(name ="PREV_TITLE",nullable=true,length=100)
	public java.lang.String getPrevTitle(){
		return this.prevTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原职称
	 */
	public void setPrevTitle(java.lang.String prevTitle){
		this.prevTitle = prevTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原职称扩充
	 */
	@Column(name ="PREV_TITLE_EXTRA",nullable=true,length=200)
	public java.lang.String getPrevTitleExtra(){
		return this.prevTitleExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原职称扩充
	 */
	public void setPrevTitleExtra(java.lang.String prevTitleExtra){
		this.prevTitleExtra = prevTitleExtra;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原岗位
	 */
	@Column(name ="PREV_JOB",nullable=true,length=100)
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
	 *@return: java.lang.String  原岗位扩充
	 */
	@Column(name ="PREV_JOB_EXTRA",nullable=true,length=200)
	public java.lang.String getPrevJobExtra(){
		return this.prevJobExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原岗位扩充
	 */
	public void setPrevJobExtra(java.lang.String prevJobExtra){
		this.prevJobExtra = prevJobExtra;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原岗位等级
	 */
	@Column(name ="PREV_JOB_LEVEL",nullable=true,length=100)
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
	@Column(name ="PREV_JOB_TYPE",nullable=true,length=100)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新职称
	 */
	@Column(name ="NEW_TITLE",nullable=true,length=100)
	public java.lang.String getNewTitle(){
		return this.newTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新职称
	 */
	public void setNewTitle(java.lang.String newTitle){
		this.newTitle = newTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新职称扩充
	 */
	@Column(name ="NEW_TITLE_EXTRA",nullable=true,length=200)
	public java.lang.String getNewTitleExtra(){
		return this.newTitleExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新职称扩充
	 */
	public void setNewTitleExtra(java.lang.String newTitleExtra){
		this.newTitleExtra = newTitleExtra;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新岗位
	 */
	@Column(name ="NEW_JOB",nullable=true,length=100)
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
	 *@return: java.lang.String  新岗位扩充
	 */
	@Column(name ="NEW_JOB_EXTRA",nullable=true,length=200)
	public java.lang.String getNewJobExtra(){
		return this.newJobExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新岗位扩充
	 */
	public void setNewJobExtra(java.lang.String newJobExtra){
		this.newJobExtra = newJobExtra;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新岗位等级
	 */
	@Column(name ="NEW_JOB_LEVEL",nullable=true,length=100)
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
	@Column(name ="NEW_JOB_TYPE",nullable=true,length=100)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职务变动原因
	 */
	@Column(name ="CHANGE_REASON",nullable=true,length=200)
	public java.lang.String getChangeReason(){
		return this.changeReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职务变动原因
	 */
	public void setChangeReason(java.lang.String changeReason){
		this.changeReason = changeReason;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  职务变动生效日期
	 */
	@Column(name ="EFFECTIVE_DATE",nullable=false,length=50)
	public java.util.Date getEffectiveDate(){
		return this.effectiveDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  职务变动生效日期
	 */
	public void setEffectiveDate(java.util.Date effectiveDate){
		this.effectiveDate = effectiveDate;
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
