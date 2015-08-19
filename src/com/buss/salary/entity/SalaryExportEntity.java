package com.buss.salary.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

public class SalaryExportEntity {
	@Excel(name="序号")
	private String seq;
	@Excel(name="变动原因")
	private String changeReason;
	@Excel(name="岗位工资")
	private String jobSalary;
	@Excel(name="薪级工资")
	private String rankSalary;
	@Excel(name="百分之十")
	private String extraSalary;
	@Excel(name="变动日期")
	private String effectDate;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	public String getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getRankSalary() {
		return rankSalary;
	}
	public void setRankSalary(String rankSalary) {
		this.rankSalary = rankSalary;
	}
	public String getExtraSalary() {
		return extraSalary;
	}
	public void setExtraSalary(String extraSalary) {
		this.extraSalary = extraSalary;
	}
	public String getEffectDate() {
		return effectDate;
	}
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}
	
}
