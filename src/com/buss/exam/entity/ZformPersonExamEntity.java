package com.buss.exam.entity;

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
 * @Description: 年度考核
 * @author onlineGenerator
 * @date 2015-07-19 11:33:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_person_exam", schema = "")
@SuppressWarnings("serial")
public class ZformPersonExamEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**学校名称*/
	@Excel(name="学校名称")
	private java.lang.String schoolCode;
	/**年度*/
	@Excel(name="年度")
	private java.lang.Integer year;
	/**技术职称*/
	@Excel(name="技术职称")
	private java.lang.String title;
	/**职称扩充*/
	@Excel(name="职称扩充")
	private java.lang.String titleExtra;
	/**行政职务*/
	@Excel(name="行政职务")
	private java.lang.String executiveTitle;
	/**岗位名称*/
	@Excel(name="岗位名称")
	private java.lang.String job;
	/**岗位等级*/
	@Excel(name="岗位等级")
	private java.lang.String jobLevel;
	/**岗位类型*/
	@Excel(name="岗位类型")
	private java.lang.String jobType;
	/**量化考核分数*/
	@Excel(name="量化考核分数")
	private java.lang.Integer score;
	/**民主测评结果*/
	@Excel(name="民主测评结果")
	private java.lang.String voteReview;
	/**最终考核结果*/
	@Excel(name="最终考核结果")
	private java.lang.String finalResult;
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
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="SCHOOL_CODE",nullable=true,length=32)
	public java.lang.String getSchoolCode(){
		return this.schoolCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setSchoolCode(java.lang.String schoolCode){
		this.schoolCode = schoolCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年度
	 */
	@Column(name ="YEAR",nullable=false,length=10)
	public java.lang.Integer getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年度
	 */
	public void setYear(java.lang.Integer year){
		this.year = year;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  技术职称
	 */
	@Column(name ="TITLE",nullable=true,length=100)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  技术职称
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职称扩充
	 */
	@Column(name ="TITLE_EXTRA",nullable=true,length=200)
	public java.lang.String getTitleExtra(){
		return this.titleExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职称扩充
	 */
	public void setTitleExtra(java.lang.String titleExtra){
		this.titleExtra = titleExtra;
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
	 *@return: java.lang.String  岗位名称
	 */
	@Column(name ="JOB",nullable=true,length=200)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位名称
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位等级
	 */
	@Column(name ="JOB_LEVEL",nullable=true,length=200)
	public java.lang.String getJobLevel(){
		return this.jobLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位等级
	 */
	public void setJobLevel(java.lang.String jobLevel){
		this.jobLevel = jobLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位类型
	 */
	@Column(name ="JOB_TYPE",nullable=true,length=200)
	public java.lang.String getJobType(){
		return this.jobType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位类型
	 */
	public void setJobType(java.lang.String jobType){
		this.jobType = jobType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  量化考核分数
	 */
	@Column(name ="SCORE",nullable=true,length=10)
	public java.lang.Integer getScore(){
		return this.score;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  量化考核分数
	 */
	public void setScore(java.lang.Integer score){
		this.score = score;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民主测评结果
	 */
	@Column(name ="VOTE_REVIEW",nullable=true,length=200)
	public java.lang.String getVoteReview(){
		return this.voteReview;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民主测评结果
	 */
	public void setVoteReview(java.lang.String voteReview){
		this.voteReview = voteReview;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最终考核结果
	 */
	@Column(name ="FINAL_RESULT",nullable=true,length=200)
	public java.lang.String getFinalResult(){
		return this.finalResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最终考核结果
	 */
	public void setFinalResult(java.lang.String finalResult){
		this.finalResult = finalResult;
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
