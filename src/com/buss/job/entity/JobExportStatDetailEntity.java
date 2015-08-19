package com.buss.job.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

public class JobExportStatDetailEntity {
	@Excel(name="序号")
	private String seq;
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSocialStatus() {
		return socialStatus;
	}

	public void setSocialStatus(String socialStatus) {
		this.socialStatus = socialStatus;
	}

	public String getEduBackground() {
		return eduBackground;
	}

	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getStartWorkDate() {
		return startWorkDate;
	}

	public void setStartWorkDate(String startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public String getWorkAge() {
		return workAge;
	}

	public void setWorkAge(String workAge) {
		this.workAge = workAge;
	}

	public String getPrevTitle() {
		return prevTitle;
	}

	public void setPrevTitle(String prevTitle) {
		this.prevTitle = prevTitle;
	}

	public String getPrevJob() {
		return prevJob;
	}

	public void setPrevJob(String prevJob) {
		this.prevJob = prevJob;
	}

	public String getPrevJobLevel() {
		return prevJobLevel;
	}

	public void setPrevJobLevel(String prevJobLevel) {
		this.prevJobLevel = prevJobLevel;
	}

	public String getPrevWorkAge() {
		return prevWorkAge;
	}

	public void setPrevWorkAge(String prevWorkAge) {
		this.prevWorkAge = prevWorkAge;
	}

	public String getPrevJobSalary() {
		return prevJobSalary;
	}

	public void setPrevJobSalary(String prevJobSalary) {
		this.prevJobSalary = prevJobSalary;
	}

	public String getPrevTitleWorkDate() {
		return prevTitleWorkDate;
	}

	public void setPrevTitleWorkDate(String prevTitleWorkDate) {
		this.prevTitleWorkDate = prevTitleWorkDate;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewJob() {
		return newJob;
	}

	public void setNewJob(String newJob) {
		this.newJob = newJob;
	}

	public String getNewJobLevel() {
		return newJobLevel;
	}

	public void setNewJobLevel(String newJobLevel) {
		this.newJobLevel = newJobLevel;
	}

	public String getNewJobSalary() {
		return newJobSalary;
	}

	public void setNewJobSalary(String newJobSalary) {
		this.newJobSalary = newJobSalary;
	}

	public String getNewJobStartStopDate() {
		return newJobStartStopDate;
	}

	public void setNewJobStartStopDate(String newJobStartStopDate) {
		this.newJobStartStopDate = newJobStartStopDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Excel(name="姓名")
	private String name;
	
	@Excel(name="性别")
	private String sex;
	
	@Excel(name="出生年月")
	private String birthday;
	
	@Excel(name="政治面貌")
	private String socialStatus;
	
	@Excel(name="最高学历")
	private String eduBackground;
	
	@Excel(name="毕业院校")
	private String graduateSchool;
	
	@Excel(name="参加工作时间")
	private String startWorkDate;
	
	@Excel(name="工作年限")
	private String workAge;
	
	@Excel(name="原职务")
	private String prevTitle;
	
	@Excel(name="原岗位名称")
	private String prevJob;
	
	@Excel(name="原岗位等级")
	private String prevJobLevel;
	
	@Excel(name="原任职年限")
	private String prevWorkAge;
	
	@Excel(name="原岗位工资")
	private String prevJobSalary;
	
	@Excel(name="原专技职务聘用时间")
	private String prevTitleWorkDate;
	
	@Excel(name="新职务")
	private String newTitle;
	
	@Excel(name="新岗位")
	private String newJob;
	
	@Excel(name="新岗位等级")
	private String newJobLevel;
	
	@Excel(name="新岗位工资")
	private String newJobSalary;
	
	@Excel(name="新聘用起始截止日期")
	private String newJobStartStopDate;
	
	@Excel(name="备注")
	private String comment;
	
	
	
	
	
	
	
}
