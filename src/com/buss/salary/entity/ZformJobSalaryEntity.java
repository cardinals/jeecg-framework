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
 * @Description: 岗位工资数据库
 * @author onlineGenerator
 * @date 2015-07-19 10:56:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_job_salary", schema = "")
@SuppressWarnings("serial")
public class ZformJobSalaryEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**年度*/
	@Excel(name="年度")
	private java.lang.Integer year;
	/**岗位类型*/
	@Excel(name="岗位类型")
	private java.lang.String jobType;
	/**岗位等级*/
	@Excel(name="岗位等级")
	private java.lang.String jobLevel;
	/**岗位名称*/
	@Excel(name="岗位名称")
	private java.lang.String job;
	/**岗位名称扩充*/
	@Excel(name="岗位名称扩充")
	private java.lang.String jobExtra;
	/**工资*/
	@Excel(name="工资")
	private java.lang.Double salary;
	
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
	 *@return: java.lang.String  岗位类型
	 */
	@Column(name ="JOB_TYPE",nullable=false,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位等级
	 */
	@Column(name ="JOB_LEVEL",nullable=false,length=32)
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
	 *@return: java.lang.String  岗位名称
	 */
	@Column(name ="JOB",nullable=false,length=32)
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
	 *@return: java.lang.String  岗位名称扩充
	 */
	@Column(name ="JOB_EXTRA",nullable=true,length=32)
	public java.lang.String getJobExtra(){
		return this.jobExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位名称扩充
	 */
	public void setJobExtra(java.lang.String jobExtra){
		this.jobExtra = jobExtra;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  工资
	 */
	@Column(name ="SALARY",nullable=false,scale=2,length=10)
	public java.lang.Double getSalary(){
		return this.salary;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  工资
	 */
	public void setSalary(java.lang.Double salary){
		this.salary = salary;
	}
}
