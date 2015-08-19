package com.buss.common;

import org.jeecgframework.core.util.StringUtil;

public class JobService {

	public static String getJobByJobTypeAndJobLevel(String jobType, String jobLevel){
		if (StringUtil.isNotEmpty(jobType) && StringUtil.isNotEmpty(jobLevel))
		{
			if (jobType.equalsIgnoreCase("管理岗位")){
				switch (jobLevel){
					case "1":
						return "一级管理岗位";
					case "2":
						return "二级管理岗位";
					case "3":
						return "三级管理岗位";
					case "4":
						return "四级管理岗位";
					case "5":
						return "五级管理岗位";
					case "6":
						return "六级管理岗位";
					case "7":
						return "七级管理岗位";
					case "8":
						return "八级管理岗位";
					case "9":
						return "九级管理岗位";
					case "10":
						return "十级管理岗位";
					default:
						return "";
				}
			}else if (jobType.equalsIgnoreCase("专业技术岗位") || jobType.equalsIgnoreCase("双肩挑")){
				switch (jobLevel){
					case "1":
						return "正高级教师一级岗";
					case "2":
						return "正高级教师二级岗";
					case "3":
						return "正高级教师三级岗";
					case "4":
						return "正高级教师四级岗";
					case "5":
						return "高级教师一级岗";
					case "6":
						return "高级教师二级岗";
					case "7":
						return "高级教师三级岗";
					case "8":
						return "一级教师一级岗";
					case "9":
						return "一级教师二级岗";
					case "10":
						return "一级教师三级岗";
					case "11":
						return "二级教师一级岗";
					case "12":
						return "二级教师二级岗";
					case "13":
						return "三级教师岗";
					default:
						return "";
				}
			}else if (jobType.equals("工勤技能岗位")){
				switch (jobLevel){
					case "1":
						return "技术工一级";
					case "2":
						return "技术工二级";
					case "3":
						return "技术工三级";
					case "4":
						return "技术工四级";
					case "5":
						return "技术工五级";
					case "普通工":
						return "普通工";
					default:
						return "";
				}
			}
		}
		
		return "";
	}
}
