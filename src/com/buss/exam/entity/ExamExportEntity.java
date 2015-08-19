package com.buss.exam.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

public class ExamExportEntity {
	@Excel(name="序号")
	private String seq;
	@Excel(name="学年度")
	private String yearRange;
	@Excel(name="考核结果")
	private String examResult;
	@Excel(name="岗位聘用情况")
	private String job;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getYearRange() {
		return yearRange;
	}
	public void setYearRange(String yearRange) {
		this.yearRange = yearRange;
	}
	public String getExamResult() {
		return examResult;
	}
	public void setExamResult(String examResult) {
		this.examResult = examResult;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
