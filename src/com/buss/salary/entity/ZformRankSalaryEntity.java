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
 * @Description: 薪级工资数据库
 * @author onlineGenerator
 * @date 2015-07-19 10:56:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "zform_rank_salary", schema = "")
@SuppressWarnings("serial")
public class ZformRankSalaryEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**年度*/
	@Excel(name="年度")
	private java.lang.Integer year;
	/**岗位类型*/
	@Excel(name="岗位类型")
	private java.lang.String jobtype;
	/**薪级*/
	@Excel(name="薪级")
	private java.lang.String rank;
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
	@Column(name ="JOBTYPE",nullable=false,length=32)
	public java.lang.String getJobtype(){
		return this.jobtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位类型
	 */
	public void setJobtype(java.lang.String jobtype){
		this.jobtype = jobtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  薪级
	 */
	@Column(name ="RANK",nullable=false,length=32)
	public java.lang.String getRank(){
		return this.rank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  薪级
	 */
	public void setRank(java.lang.String rank){
		this.rank = rank;
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
