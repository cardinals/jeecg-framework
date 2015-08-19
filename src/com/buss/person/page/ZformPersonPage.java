
package com.buss.person.page;
import com.buss.person.entity.ZformPersonEntity;
import com.buss.active.entity.ZformPersonActiveEntity;
import com.buss.retire.entity.ZformPersonRetireEntity;
import com.buss.transferexternal.entity.ZformPersonTransferExternalEntity;
import com.buss.death.entity.ZformPersonDeathEntity;
import com.buss.punishment.entity.ZformPersonPunishEntity;
import com.buss.transferinternal.entity.ZformPersonTransferInnerEntity;
import com.buss.job.entity.ZformPersonJobEntity;
import com.buss.exam.entity.ZformPersonExamEntity;
import com.buss.salary.entity.ZformPersonSalaryEntity;
import com.buss.title.entity.ZformPersonTitleEntity;
import com.buss.status.entity.ZformPersonStatusEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;


/**   
 * @Title: Entity
 * @Description: 人员基本信息数据库
 * @author onlineGenerator
 * @date 2015-07-19 11:33:28
 * @version V1.0   
 *
 */
public class ZformPersonPage implements java.io.Serializable {
	/**保存-在职*/
	private List<ZformPersonActiveEntity> zformPersonActiveList = new ArrayList<ZformPersonActiveEntity>();
	public List<ZformPersonActiveEntity> getZformPersonActiveList() {
		return zformPersonActiveList;
	}
	public void setZformPersonActiveList(List<ZformPersonActiveEntity> zformPersonActiveList) {
		this.zformPersonActiveList = zformPersonActiveList;
	}
	/**保存-退休*/
	private List<ZformPersonRetireEntity> zformPersonRetireList = new ArrayList<ZformPersonRetireEntity>();
	public List<ZformPersonRetireEntity> getZformPersonRetireList() {
		return zformPersonRetireList;
	}
	public void setZformPersonRetireList(List<ZformPersonRetireEntity> zformPersonRetireList) {
		this.zformPersonRetireList = zformPersonRetireList;
	}
	/**保存-调出*/
	private List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList = new ArrayList<ZformPersonTransferExternalEntity>();
	public List<ZformPersonTransferExternalEntity> getZformPersonTransferExternalList() {
		return zformPersonTransferExternalList;
	}
	public void setZformPersonTransferExternalList(List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList) {
		this.zformPersonTransferExternalList = zformPersonTransferExternalList;
	}
	/**保存-死亡*/
	private List<ZformPersonDeathEntity> zformPersonDeathList = new ArrayList<ZformPersonDeathEntity>();
	public List<ZformPersonDeathEntity> getZformPersonDeathList() {
		return zformPersonDeathList;
	}
	public void setZformPersonDeathList(List<ZformPersonDeathEntity> zformPersonDeathList) {
		this.zformPersonDeathList = zformPersonDeathList;
	}
	/**保存-处分*/
	private List<ZformPersonPunishEntity> zformPersonPunishList = new ArrayList<ZformPersonPunishEntity>();
	public List<ZformPersonPunishEntity> getZformPersonPunishList() {
		return zformPersonPunishList;
	}
	public void setZformPersonPunishList(List<ZformPersonPunishEntity> zformPersonPunishList) {
		this.zformPersonPunishList = zformPersonPunishList;
	}
	/**保存-人员调动*/
	private List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList = new ArrayList<ZformPersonTransferInnerEntity>();
	public List<ZformPersonTransferInnerEntity> getZformPersonTransferInnerList() {
		return zformPersonTransferInnerList;
	}
	public void setZformPersonTransferInnerList(List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList) {
		this.zformPersonTransferInnerList = zformPersonTransferInnerList;
	}
	/**保存-岗位聘用*/
	private List<ZformPersonJobEntity> zformPersonJobList = new ArrayList<ZformPersonJobEntity>();
	public List<ZformPersonJobEntity> getZformPersonJobList() {
		return zformPersonJobList;
	}
	public void setZformPersonJobList(List<ZformPersonJobEntity> zformPersonJobList) {
		this.zformPersonJobList = zformPersonJobList;
	}
	/**保存-年度考核*/
	private List<ZformPersonExamEntity> zformPersonExamList = new ArrayList<ZformPersonExamEntity>();
	public List<ZformPersonExamEntity> getZformPersonExamList() {
		return zformPersonExamList;
	}
	public void setZformPersonExamList(List<ZformPersonExamEntity> zformPersonExamList) {
		this.zformPersonExamList = zformPersonExamList;
	}
	/**保存-薪资管理*/
	private List<ZformPersonSalaryEntity> zformPersonSalaryList = new ArrayList<ZformPersonSalaryEntity>();
	public List<ZformPersonSalaryEntity> getZformPersonSalaryList() {
		return zformPersonSalaryList;
	}
	public void setZformPersonSalaryList(List<ZformPersonSalaryEntity> zformPersonSalaryList) {
		this.zformPersonSalaryList = zformPersonSalaryList;
	}
	/**保存-职务变动*/
	private List<ZformPersonTitleEntity> zformPersonTitleList = new ArrayList<ZformPersonTitleEntity>();
	public List<ZformPersonTitleEntity> getZformPersonTitleList() {
		return zformPersonTitleList;
	}
	public void setZformPersonTitleList(List<ZformPersonTitleEntity> zformPersonTitleList) {
		this.zformPersonTitleList = zformPersonTitleList;
	}
	/**保存-状态变动*/
	private List<ZformPersonStatusEntity> zformPersonStatusList = new ArrayList<ZformPersonStatusEntity>();
	public List<ZformPersonStatusEntity> getZformPersonStatusList() {
		return zformPersonStatusList;
	}
	public void setZformPersonStatusList(List<ZformPersonStatusEntity> zformPersonStatusList) {
		this.zformPersonStatusList = zformPersonStatusList;
	}

	/**主键*/
	private java.lang.String id;
	/**人员编号*/
	private java.lang.String code;
	/**序号*/
	private java.lang.Integer seqNo;
	/**人员姓名*/
	private java.lang.String name;
	/**性别*/
	private java.lang.String sex;
	/**出生日期*/
	private java.util.Date birthday;
	/**年龄*/
	private java.lang.String age;
	/**身份证号码*/
	private java.lang.String photoIdNo;
	/**民族*/
	private java.lang.String nationality;
	/**政治面貌*/
	private java.lang.String socialStatus;
	/**参加工作时间*/
	private java.util.Date startWorkDate;
	/**学历*/
	private java.lang.String eduBackground;
	/**学历补充*/
	private java.lang.String eduExtra;
	/**学位*/
	private java.lang.String degree;
	/**专业*/
	private java.lang.String major;
	/**毕业时间*/
	private java.util.Date graduateDate;
	/**毕业学校*/
	private java.lang.String graduateSchool;
	/**联系电话*/
	private java.lang.String contactNo;
	/**家庭住址*/
	private java.lang.String homeAddress;
	/**进入行业方式*/
	private java.lang.String enterApproach;
	/**进入行业时间*/
	private java.util.Date enterDate;
	/**初级职称取得时间*/
	private java.util.Date juniorTitleDate;
	/**中级职称取得时间*/
	private java.util.Date secondaryTitleDate;
	/**高级职称取得时间*/
	private java.util.Date seniorTitleDate;
	/**照片*/
	private java.lang.String photo;
	/**备注*/
	private java.lang.String comments;
	/**目前状态*/
	private java.lang.String currentStatus;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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
	 *@return: java.lang.String  人员姓名
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	public java.util.Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年龄
	 */
	public java.lang.String getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年龄
	 */
	public void setAge(java.lang.String age){
		this.age = age;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号码
	 */
	public java.lang.String getPhotoIdNo(){
		return this.photoIdNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号码
	 */
	public void setPhotoIdNo(java.lang.String photoIdNo){
		this.photoIdNo = photoIdNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */
	public java.lang.String getNationality(){
		return this.nationality;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNationality(java.lang.String nationality){
		this.nationality = nationality;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */
	public java.lang.String getSocialStatus(){
		return this.socialStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setSocialStatus(java.lang.String socialStatus){
		this.socialStatus = socialStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  参加工作时间
	 */
	public java.util.Date getStartWorkDate(){
		return this.startWorkDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  参加工作时间
	 */
	public void setStartWorkDate(java.util.Date startWorkDate){
		this.startWorkDate = startWorkDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	public java.lang.String getEduBackground(){
		return this.eduBackground;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEduBackground(java.lang.String eduBackground){
		this.eduBackground = eduBackground;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历补充
	 */
	public java.lang.String getEduExtra(){
		return this.eduExtra;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历补充
	 */
	public void setEduExtra(java.lang.String eduExtra){
		this.eduExtra = eduExtra;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学位
	 */
	public java.lang.String getDegree(){
		return this.degree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学位
	 */
	public void setDegree(java.lang.String degree){
		this.degree = degree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	public java.lang.String getMajor(){
		return this.major;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setMajor(java.lang.String major){
		this.major = major;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  毕业时间
	 */
	public java.util.Date getGraduateDate(){
		return this.graduateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  毕业时间
	 */
	public void setGraduateDate(java.util.Date graduateDate){
		this.graduateDate = graduateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业学校
	 */
	public java.lang.String getGraduateSchool(){
		return this.graduateSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业学校
	 */
	public void setGraduateSchool(java.lang.String graduateSchool){
		this.graduateSchool = graduateSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	public java.lang.String getContactNo(){
		return this.contactNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setContactNo(java.lang.String contactNo){
		this.contactNo = contactNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭住址
	 */
	public java.lang.String getHomeAddress(){
		return this.homeAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭住址
	 */
	public void setHomeAddress(java.lang.String homeAddress){
		this.homeAddress = homeAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进入行业方式
	 */
	public java.lang.String getEnterApproach(){
		return this.enterApproach;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进入行业方式
	 */
	public void setEnterApproach(java.lang.String enterApproach){
		this.enterApproach = enterApproach;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  进入行业时间
	 */
	public java.util.Date getEnterDate(){
		return this.enterDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  进入行业时间
	 */
	public void setEnterDate(java.util.Date enterDate){
		this.enterDate = enterDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  初级职称取得时间
	 */
	public java.util.Date getJuniorTitleDate(){
		return this.juniorTitleDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  初级职称取得时间
	 */
	public void setJuniorTitleDate(java.util.Date juniorTitleDate){
		this.juniorTitleDate = juniorTitleDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  中级职称取得时间
	 */
	public java.util.Date getSecondaryTitleDate(){
		return this.secondaryTitleDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  中级职称取得时间
	 */
	public void setSecondaryTitleDate(java.util.Date secondaryTitleDate){
		this.secondaryTitleDate = secondaryTitleDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  高级职称取得时间
	 */
	public java.util.Date getSeniorTitleDate(){
		return this.seniorTitleDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  高级职称取得时间
	 */
	public void setSeniorTitleDate(java.util.Date seniorTitleDate){
		this.seniorTitleDate = seniorTitleDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  照片
	 */
	public java.lang.String getPhoto(){
		return this.photo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  照片
	 */
	public void setPhoto(java.lang.String photo){
		this.photo = photo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
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
	 *@return: java.lang.String  目前状态
	 */
	public java.lang.String getCurrentStatus(){
		return this.currentStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目前状态
	 */
	public void setCurrentStatus(java.lang.String currentStatus){
		this.currentStatus = currentStatus;
	}
}
