package com.buss.common;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;

import com.buss.active.entity.ZformPersonActiveEntity;
import com.buss.death.entity.ZformPersonDeathEntity;
import com.buss.exam.entity.ExamExportEntity;
import com.buss.exam.entity.ZformPersonExamEntity;
import com.buss.job.entity.JobExportEntity;
import com.buss.job.entity.JobExportStatDetailEntity;
import com.buss.job.entity.ZformPersonJobEntity;
import com.buss.person.entity.ZformPersonEntity;
import com.buss.salary.entity.SalaryExportEntity;
import com.buss.salary.entity.ZformPersonSalaryEntity;
import com.buss.school.entity.SchoolExportEntity;
import com.buss.school.entity.ZformSchoolEntity;
import com.buss.transferinternal.entity.TransferInnerExportEntity;
import com.buss.transferinternal.entity.ZformPersonTransferInnerEntity;


public class ReportService {
	
	public Map<String, Object> GetDeathExepenseAudit(
			PersonService personService, SystemService systemService,
			ZformPersonEntity t, ZformPersonDeathEntity deathEntity) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		
		if (t == null)
			return map;
		
		map.put("name", t.getName() == null ? "" : t.getName());
		map.put("sex", t.getSex() == null ? "" : t.getSex());
		map.put("birthday", t.getBirthday() == null ? "" : t.getBirthday());
		map.put("startWorkDate", t.getStartWorkDate() == null ? "" : t.getStartWorkDate());
		map.put("category", "退休");
		map.put("retireDate", "");
		
		if (deathEntity == null)
			return map;
		
		map.put("deathDate", deathEntity.getDeathDate() == null ? "" : deathEntity.getDeathDate());
		map.put("deathReason", deathEntity.getDeathReason() == null ? "" : deathEntity.getDeathReason());
		map.put("funeralExp", deathEntity.getFuneralExp() == null? "" : deathEntity.getFuneralExp());
		map.put("basicSalary", deathEntity.getBasicSalary() == null ? "" : deathEntity.getBasicSalary());
		map.put("stateIncomeAvg", deathEntity.getStateIncomeAvg() == null ? "": deathEntity.getStateIncomeAvg());
		map.put("pension", deathEntity.getPension() == null ? "" : deathEntity.getPension());
		map.put("funeralExpTotal", deathEntity.getFuneralExpTotal() == null ? "" : deathEntity.getFuneralExpTotal());
		
		return map;
	}
	
	public Map<String, Object> GetJobStatSum1(PersonService personService, SystemService systemService, String schoolCode, String schoolYear){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("date", DateService.GetToday());
		if (StringUtil.isEmpty(schoolCode) || systemService == null || personService == null)
			return map;
		
		ZformSchoolEntity zformSchoolEntity = personService.getSchoolByCode(systemService, schoolCode);
		
		if (zformSchoolEntity == null)
			return map;
				
		map.put("schoolName", zformSchoolEntity.getName() == null ? "" : zformSchoolEntity.getName());
		return map;
	}
	
	public Map<String, Object> GetJobStatSum2(PersonService personService, SystemService systemService, String schoolCode, String schoolYear){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("date", DateService.GetToday());
		
		if (StringUtil.isEmpty(schoolCode) || systemService == null || personService == null)
			return map;
		
		ZformSchoolEntity zformSchoolEntity = personService.getSchoolByCode(systemService, schoolCode);
		
		if (zformSchoolEntity == null)
			return map;
				
		map.put("schoolName", zformSchoolEntity.getName() == null ? "" : zformSchoolEntity.getName());
		
		return map;
	}
	
	public Map<String, Object> GetJobStatDetails(PersonService personService, SystemService systemService, String schoolCode, String schoolYear){
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("date", DateService.GetToday());
				
		if (StringUtil.isEmpty(schoolCode) || systemService == null || personService == null)
			return map;
		
		ZformSchoolEntity zformSchoolEntity = personService.getSchoolByCode(systemService, schoolCode);
		
		if (zformSchoolEntity == null)
			return map;
				
		map.put("schoolName", zformSchoolEntity.getName() == null ? "" : zformSchoolEntity.getName());
				
		String hql2 = "from ZformPersonActiveEntity where 1 = 1 AND schoolCode = ?";
		List<ZformPersonActiveEntity> personActiveEntityList = systemService.findHql(hql2, zformSchoolEntity.getCode());
		if (personActiveEntityList == null || personActiveEntityList.size() < 1)
			return map;
		
		List<JobExportStatDetailEntity> jobExportStatDetailEntityList_leader = new ArrayList<JobExportStatDetailEntity>();
		List<JobExportStatDetailEntity> jobExportStatDetailEntityList_teacher = new ArrayList<JobExportStatDetailEntity>();
		List<JobExportStatDetailEntity> jobExportStatDetailEntityList_worker = new ArrayList<JobExportStatDetailEntity>();
		int seq = 0;
		
		for(ZformPersonActiveEntity personActiveEntity : personActiveEntityList){
						
			String code = personActiveEntity.getCode();
			
			if (StringUtil.isEmpty(code))
				continue;
			
			String jobType = personActiveEntity.getCurrentJobType();
			
			if (StringUtil.isEmpty(jobType))
				continue;			
			
			ZformPersonEntity personEntity = personService.getPersonEntityByCode(systemService, code);
			
			if (personEntity == null)
				continue;
			
			JobExportStatDetailEntity jobExportStatDetailEntity = new JobExportStatDetailEntity();
			
			seq ++;
			
			jobExportStatDetailEntity.setSeq(seq+"");			
			jobExportStatDetailEntity.setName(personEntity.getName() == null ? "" : personEntity.getName());
			jobExportStatDetailEntity.setSex(personEntity.getSex() == null ? "" : personEntity.getSex());
			jobExportStatDetailEntity.setBirthday(personEntity.getBirthday() == null ? "" : personEntity.getBirthday().toString());
			jobExportStatDetailEntity.setSocialStatus(personEntity.getSocialStatus() == null ? "" : personEntity.getSocialStatus());
			jobExportStatDetailEntity.setEduBackground(personEntity.getEduBackground() == null ? "" : personEntity.getEduBackground());
			jobExportStatDetailEntity.setGraduateSchool(personEntity.getGraduateSchool() == null ? "" : personEntity.getGraduateSchool());
			jobExportStatDetailEntity.setWorkAge(DateService.getWorkAge(personEntity.getStartWorkDate()));
			
			String hql3 = "from ZformPersonJobEntity where 1 = 1 AND code = ? and year = ?";
			List<ZformPersonJobEntity> personJobEntityList = systemService.findHql(hql3, personEntity.getCode(), Integer.valueOf(schoolYear));
			
			if (personJobEntityList == null || personJobEntityList.size() < 1){
				jobExportStatDetailEntity.setPrevJob("");
				jobExportStatDetailEntity.setPrevTitle("");
				jobExportStatDetailEntity.setPrevJobLevel("");
				jobExportStatDetailEntity.setPrevWorkAge("");
				jobExportStatDetailEntity.setPrevJobSalary("");
				jobExportStatDetailEntity.setPrevTitleWorkDate("");
				jobExportStatDetailEntity.setNewJob(personActiveEntity.getCurrentJob() == null ? "" : personActiveEntity.getCurrentJob());
				jobExportStatDetailEntity.setNewTitle(personActiveEntity.getCurrentTitle() == null ? "" : personActiveEntity.getCurrentTitle());
				jobExportStatDetailEntity.setNewJobLevel(personActiveEntity.getCurrentJobLevel() == null ? "" : personActiveEntity.getCurrentJobLevel());
				jobExportStatDetailEntity.setNewJobSalary(personActiveEntity.getJobSalary() == null ? "" : personActiveEntity.getJobSalary());
			}else{
				ZformPersonJobEntity personJobEntity = personJobEntityList.get(0);
				
				jobExportStatDetailEntity.setPrevJob(personJobEntity.getPrevJob() == null ? "" : personJobEntity.getPrevJob());
				jobExportStatDetailEntity.setPrevTitle(personJobEntity.getPrevTitle() == null ? "" : personJobEntity.getPrevTitle());
				jobExportStatDetailEntity.setPrevJobLevel(personJobEntity.getPrevJobLevel() == null ? "" : personJobEntity.getPrevJobLevel());
				jobExportStatDetailEntity.setPrevWorkAge(personJobEntity.getPrevWorkAge() == null ? "" : personJobEntity.getPrevWorkAge());
				jobExportStatDetailEntity.setPrevJobSalary(personJobEntity.getPrevJobSalary() == null ? "" : personJobEntity.getPrevJobSalary().toString());
				jobExportStatDetailEntity.setPrevTitleWorkDate(personJobEntity.getPrevTitleWorkDate() == null ? "" : personJobEntity.getPrevTitleWorkDate().toString());
				jobExportStatDetailEntity.setNewJob(personJobEntity.getNewJob() == null ? "" : personJobEntity.getNewJob());
				jobExportStatDetailEntity.setNewTitle(personJobEntity.getNewTitle() == null ? "" : personJobEntity.getNewTitle());
				jobExportStatDetailEntity.setNewJobLevel(personJobEntity.getNewJobLevel() == null ? "" : personJobEntity.getNewJobLevel());
				jobExportStatDetailEntity.setNewJobSalary(personJobEntity.getNewJobSalary() == null ? "" : personJobEntity.getNewJobSalary().toString());
				
				String newJobStartDate = personJobEntity.getNewJobStartDate() == null ? "" : personJobEntity.getNewJobStartDate().toString();
				
				String newJobEndDate = personJobEntity.getNewJobEndDate() == null ? "" : personJobEntity.getNewJobEndDate().toString();
				
				jobExportStatDetailEntity.setNewJobStartStopDate(newJobStartDate + "-" + newJobEndDate);
				
				jobExportStatDetailEntity.setComment(personJobEntity.getComments() == null ? "" : personJobEntity.getComments());				
				
			}
			
			if (jobType.equals("工勤技能岗位"))
				jobExportStatDetailEntityList_worker
						.add(jobExportStatDetailEntity);
			else if (jobType.equals("管理岗位"))
				jobExportStatDetailEntityList_leader
						.add(jobExportStatDetailEntity);
			else if (jobType.equals("专业技术岗位")
					|| personActiveEntity.getCurrentJobType().equals("双肩挑"))
				jobExportStatDetailEntityList_teacher
						.add(jobExportStatDetailEntity);
			
		}
		
		map.put("leaderlist", jobExportStatDetailEntityList_leader);
		map.put("teacherlist", jobExportStatDetailEntityList_teacher);
		map.put("workerlist", jobExportStatDetailEntityList_worker);
		
		return map;
	}
	
	
	public Map<String,Object> GetPersonalResumeWithJob(ZformPersonEntity personEntity, ZformPersonActiveEntity personActiveEntity, 
			ZformSchoolEntity schoolEntity, List<ZformPersonExamEntity> zformPersonExamEntityList, List<ZformPersonJobEntity> zformPersonJobEntityList){
		Map<String,Object> map = new HashMap<String, Object>();
		
		String schoolCode = "";
		String schoolName = "";
		
		if (schoolEntity != null){
			if (StringUtil.isNotEmpty(schoolEntity.getName()))
				schoolName = (schoolEntity.getName() == null) ? "" : schoolEntity.getName();
			
			if (StringUtil.isNotEmpty(schoolEntity.getCode()))
				schoolCode = (schoolEntity.getCode() == null) ? "" : schoolEntity.getCode();
		}
		
		if (personEntity != null){
			
			map.put("code", schoolCode + "_" + personEntity.getCode());
			map.put("school_name", schoolName == null ? "":schoolName);
			
	        map.put("seq_no", personEntity.getSeqNo() == null ? "" : personEntity.getSeqNo());
	        map.put("name", personEntity.getName() == null ? "" : personEntity.getName());
	        map.put("sex",  personEntity.getSex() == null  ? "" : personEntity.getSex());
	        map.put("age",  personEntity.getAge() == null  ? "" : personEntity.getAge());
	        map.put("birthday", personEntity.getBirthday() == null ? "" : personEntity.getBirthday());
	        map.put("photo_id_no", personEntity.getPhotoIdNo()==null? "" : personEntity.getPhotoIdNo());
	        map.put("nationality", personEntity.getNationality()==null? "" : personEntity.getNationality());
	        map.put("social_status", personEntity.getSocialStatus()==null? "" : personEntity.getSocialStatus());
	        map.put("start_work_date", personEntity.getStartWorkDate()==null? "" : personEntity.getStartWorkDate());	        
	        map.put("edu_background", personEntity.getEduBackground()==null ? "" : personEntity.getEduBackground());
	        map.put("degree", personEntity.getDegree()==null ? "" : personEntity.getDegree());	        
	        map.put("major", personEntity.getMajor()==null ?  "" : personEntity.getMajor() );
	        map.put("graduate_date", personEntity.getGraduateDate()==null ? "" : personEntity.getGraduateDate());
	        map.put("graduate_school", personEntity.getGraduateSchool() == null ? "" : personEntity.getGraduateSchool());
	        map.put("contact_no", personEntity.getContactNo() == null ? "" : personEntity.getContactNo());
	        map.put("home_address", personEntity.getHomeAddress() == null ? "" : personEntity.getHomeAddress());
	        map.put("enter_approach", personEntity.getEnterApproach() == null ? "" : personEntity.getEnterApproach());
	        map.put("enter_date", personEntity.getEnterDate() == null ? "" : personEntity.getEnterDate());
	        map.put("junior_title_date", personEntity.getJuniorTitleDate() == null ? "" : personEntity.getJuniorTitleDate());
	        map.put("secondary_title_date", personEntity.getSecondaryTitleDate() == null ? "" : personEntity.getSecondaryTitleDate());
	        map.put("senior_title_date", personEntity.getSeniorTitleDate() == null ? "" : personEntity.getSeniorTitleDate());
	        map.put("comment", personEntity.getComments() == null ? "" : personEntity.getComments());
	        
	        map.put("work_age", DateService.getWorkAge(personEntity.getStartWorkDate()));
	        map.put("photo", "");
	        
		}
		
		List<JobExportEntity> jobList = new ArrayList<JobExportEntity>();
		int seq=0;
		
		if (zformPersonJobEntityList != null && zformPersonJobEntityList.size() > 0){
			for(ZformPersonJobEntity zformPersonJobEntity : zformPersonJobEntityList){
				
				JobExportEntity jobEntity = new JobExportEntity();
				
				seq++;
				Integer year = zformPersonJobEntity.getYear();
				String  yearRange = DateService.GetSchoolYearRange(year);
				String  job  = zformPersonJobEntity.getNewJob();
				String  examResult = "";
				
				if (zformPersonExamEntityList != null && zformPersonExamEntityList.size() > 0){			
					for(ZformPersonExamEntity zformPersonExamEntity : zformPersonExamEntityList){
						
						if (zformPersonExamEntity.getYear()!= null && year != null && zformPersonExamEntity.getYear().intValue() == year.intValue())
						{
							examResult = zformPersonExamEntity.getFinalResult() == null ? "" : zformPersonExamEntity.getFinalResult();
							break;
						}													
					}
				}
				
				jobEntity.setSeq(String.valueOf(seq).toString());
				jobEntity.setYearRange(yearRange);
				jobEntity.setExamResult(examResult);
				jobEntity.setJob(job);
				
				jobList.add(jobEntity);
				
			}
		}		
		
		map.put("joblist", jobList);
		
		return map;
	}
	
	public Map<String,Object> GetPersonalResumeWithSalary(ZformPersonEntity personEntity, ZformPersonActiveEntity personActiveEntity, 
			ZformSchoolEntity schoolEntity, List<ZformPersonExamEntity> zformPersonExamEntityList, List<ZformPersonJobEntity> zformPersonJobEntityList,
			List<ZformPersonSalaryEntity> zformPersonSalaryEntityList){
		Map<String,Object> map = new HashMap<String, Object>();
		
		String schoolCode = "";
		String schoolName = "";
		
		if (schoolEntity != null){
			if (StringUtil.isNotEmpty(schoolEntity.getName()))
				schoolName = (schoolEntity.getName() == null) ? "" : schoolEntity.getName();
			
			if (StringUtil.isNotEmpty(schoolEntity.getCode()))
				schoolCode = (schoolEntity.getCode() == null) ? "" : schoolEntity.getCode();
		}
		
		if (personEntity != null){
			
			map.put("code", schoolCode + "_" + personEntity.getCode());
			map.put("school_name", schoolName == null ? "":schoolName);
			
	        map.put("seq_no", personEntity.getSeqNo() == null ? "" : personEntity.getSeqNo());
	        map.put("name", personEntity.getName() == null ? "" : personEntity.getName());
	        map.put("sex",  personEntity.getSex() == null  ? "" : personEntity.getSex());
	        map.put("age",  personEntity.getAge() == null  ? "" : personEntity.getAge());
	        map.put("birthday", personEntity.getBirthday() == null ? "" : personEntity.getBirthday());
	        map.put("photo_id_no", personEntity.getPhotoIdNo()==null? "" : personEntity.getPhotoIdNo());
	        map.put("nationality", personEntity.getNationality()==null? "" : personEntity.getNationality());
	        map.put("social_status", personEntity.getSocialStatus()==null? "" : personEntity.getSocialStatus());
	        map.put("start_work_date", personEntity.getStartWorkDate()==null? "" : personEntity.getStartWorkDate());	        
	        map.put("edu_background", personEntity.getEduBackground()==null ? "" : personEntity.getEduBackground());
	        map.put("degree", personEntity.getDegree()==null ? "" : personEntity.getDegree());	        
	        map.put("major", personEntity.getMajor()==null ?  "" : personEntity.getMajor() );
	        map.put("graduate_date", personEntity.getGraduateDate()==null ? "" : personEntity.getGraduateDate());
	        map.put("graduate_school", personEntity.getGraduateSchool() == null ? "" : personEntity.getGraduateSchool());
	        map.put("contact_no", personEntity.getContactNo() == null ? "" : personEntity.getContactNo());
	        map.put("home_address", personEntity.getHomeAddress() == null ? "" : personEntity.getHomeAddress());
	        map.put("enter_approach", personEntity.getEnterApproach() == null ? "" : personEntity.getEnterApproach());
	        map.put("enter_date", personEntity.getEnterDate() == null ? "" : personEntity.getEnterDate());
	        map.put("junior_title_date", personEntity.getJuniorTitleDate() == null ? "" : personEntity.getJuniorTitleDate());
	        map.put("secondary_title_date", personEntity.getSecondaryTitleDate() == null ? "" : personEntity.getSecondaryTitleDate());
	        map.put("senior_title_date", personEntity.getSeniorTitleDate() == null ? "" : personEntity.getSeniorTitleDate());
	        map.put("comment", personEntity.getComments() == null ? "" : personEntity.getComments());
	        
	        map.put("work_age", DateService.getWorkAge(personEntity.getStartWorkDate()));
	        map.put("photo", "");
	        
		}
		
		List<SalaryExportEntity> salaryList = new ArrayList<SalaryExportEntity>();
		int seq=0;
		
		if (zformPersonSalaryEntityList != null && zformPersonSalaryEntityList.size() > 0){
			for(ZformPersonSalaryEntity zformPersonSalaryEntity : zformPersonSalaryEntityList){
				
				SalaryExportEntity salaryEntity = new SalaryExportEntity();
				
				seq++;
				
				salaryEntity.setSeq(String.valueOf(seq).toString());
				salaryEntity.setChangeReason(zformPersonSalaryEntity.getChangeReason() == null ? "" : zformPersonSalaryEntity.getChangeReason());				
				salaryEntity.setJobSalary(zformPersonSalaryEntity.getNewJobSalary() == null ? "" : zformPersonSalaryEntity.getNewJobSalary().toString());
				salaryEntity.setRankSalary(zformPersonSalaryEntity.getNewRankSalary() == null ? "" : zformPersonSalaryEntity.getNewRankSalary().toString());
				salaryEntity.setExtraSalary(zformPersonSalaryEntity.getNewExtraSalary() == null ? "" : zformPersonSalaryEntity.getNewExtraSalary().toString());
				salaryEntity.setEffectDate(zformPersonSalaryEntity.getEffectiveDate() == null ? "" : zformPersonSalaryEntity.getEffectiveDate().toString());
				
				salaryList.add(salaryEntity);
				
			}
		}		
		
		map.put("salarylist", salaryList);
		
		return map;
	}
	
	public Map<String, Object> GetPersonalResumeWithInnerTransfer(ZformPersonEntity personEntity, ZformPersonActiveEntity personActiveEntity, 
			ZformSchoolEntity schoolEntity, List<ZformPersonTransferInnerEntity> zformTransferInnerEntityList, SystemService systemService, PersonService personService){
		Map<String, Object> map = new HashMap<String, Object>();
		
		String schoolCode = "";
		String schoolName = "";
		
		if (schoolEntity != null){
			if (StringUtil.isNotEmpty(schoolEntity.getName()))
				schoolName = (schoolEntity.getName() == null) ? "" : schoolEntity.getName();
			
			if (StringUtil.isNotEmpty(schoolEntity.getCode()))
				schoolCode = (schoolEntity.getCode() == null) ? "" : schoolEntity.getCode();
		}
		
		if (personEntity != null){
			
			map.put("code", schoolCode + "_" + personEntity.getCode());
			map.put("school_name", schoolName == null ? "":schoolName);
			
	        map.put("seq_no", personEntity.getSeqNo() == null ? "" : personEntity.getSeqNo());
	        map.put("name", personEntity.getName() == null ? "" : personEntity.getName());
	        map.put("sex",  personEntity.getSex() == null  ? "" : personEntity.getSex());
	        map.put("age",  personEntity.getAge() == null  ? "" : personEntity.getAge());
	        map.put("birthday", personEntity.getBirthday() == null ? "" : personEntity.getBirthday());
	        map.put("photo_id_no", personEntity.getPhotoIdNo()==null? "" : personEntity.getPhotoIdNo());
	        map.put("nationality", personEntity.getNationality()==null? "" : personEntity.getNationality());
	        map.put("social_status", personEntity.getSocialStatus()==null? "" : personEntity.getSocialStatus());
	        map.put("start_work_date", personEntity.getStartWorkDate()==null? "" : personEntity.getStartWorkDate());	        
	        map.put("edu_background", personEntity.getEduBackground()==null ? "" : personEntity.getEduBackground());
	        map.put("degree", personEntity.getDegree()==null ? "" : personEntity.getDegree());	        
	        map.put("major", personEntity.getMajor()==null ?  "" : personEntity.getMajor() );
	        map.put("graduate_date", personEntity.getGraduateDate()==null ? "" : personEntity.getGraduateDate());
	        map.put("graduate_school", personEntity.getGraduateSchool() == null ? "" : personEntity.getGraduateSchool());
	        map.put("contact_no", personEntity.getContactNo() == null ? "" : personEntity.getContactNo());
	        map.put("home_address", personEntity.getHomeAddress() == null ? "" : personEntity.getHomeAddress());
	        map.put("enter_approach", personEntity.getEnterApproach() == null ? "" : personEntity.getEnterApproach());
	        map.put("enter_date", personEntity.getEnterDate() == null ? "" : personEntity.getEnterDate());
	        map.put("junior_title_date", personEntity.getJuniorTitleDate() == null ? "" : personEntity.getJuniorTitleDate());
	        map.put("secondary_title_date", personEntity.getSecondaryTitleDate() == null ? "" : personEntity.getSecondaryTitleDate());
	        map.put("senior_title_date", personEntity.getSeniorTitleDate() == null ? "" : personEntity.getSeniorTitleDate());
	        map.put("comment", personEntity.getComments() == null ? "" : personEntity.getComments());
	        
	        map.put("work_age", DateService.getWorkAge(personEntity.getStartWorkDate()));
	        map.put("photo", "");
	        
		}
		
		List<TransferInnerExportEntity> innerList = new ArrayList<TransferInnerExportEntity>();
		
		
		if (zformTransferInnerEntityList != null & zformTransferInnerEntityList.size() > 0){
			
			int seq = 1;
			for(ZformPersonTransferInnerEntity transferInnerEntity : zformTransferInnerEntityList){
				TransferInnerExportEntity t = new TransferInnerExportEntity();
				
				t.setSeqNo(Integer.valueOf(seq).toString());
				
				ZformSchoolEntity fromSchool = personService.getSchoolByCode(systemService, transferInnerEntity.getFromSchool());
				ZformSchoolEntity toSchool = personService.getSchoolByCode(systemService, transferInnerEntity.getToSchool());
				
				String fromSchoolName = "";
				if (fromSchool != null && StringUtil.isNotEmpty(fromSchool.getName()))
					fromSchoolName = fromSchool.getName();
				
				String toSchoolName = "";
				if (toSchool != null && StringUtil.isNotEmpty(toSchool.getName()))
					toSchoolName = toSchool.getName();
				
				t.setFromSchool(fromSchoolName);
				t.setToSchool(toSchoolName);
				t.setTransferLetterDate(transferInnerEntity.getTransferLetterDate() == null ? "" : transferInnerEntity.getTransferDate().toString());
				t.setNotifyLetterDate(transferInnerEntity.getNotifyLetterDate() == null ? "" : transferInnerEntity.getNotifyLetterDate().toString());
				t.setRefLetterDate(transferInnerEntity.getRefLetterDate() == null ? "" : transferInnerEntity.getRefLetterDate().toString());
				t.setSalaryEndDate(transferInnerEntity.getSalaryEndDate() == null ? "" : transferInnerEntity.getSalaryEndDate().toString());
				t.setTransferReason(transferInnerEntity.getTransferReason() == null ? "" : transferInnerEntity.getTransferReason());
				t.setTransferTitle(transferInnerEntity.getTransferTitle() == null ? "":transferInnerEntity.getTransferTitle());
				t.setNominate(transferInnerEntity.getNominate() == null ? "" : transferInnerEntity.getNominate());
				t.setComments(transferInnerEntity.getComments() == null ? "" : transferInnerEntity.getComments());				
				
				innerList.add(t);
				seq++;
			}
		}
		
		map.put("innertransferlist", innerList);
		
		return map;
	}
	
	
	public Map<String,Object> GetPersonalResumeWithExam(ZformPersonEntity personEntity, ZformPersonActiveEntity personActiveEntity, 
			ZformSchoolEntity schoolEntity, List<ZformPersonExamEntity> zformPersonExamEntityList){
		Map<String,Object> map = new HashMap<String, Object>();
		
		String schoolCode = "";
		String schoolName = "";
		
		if (schoolEntity != null){
			if (StringUtil.isNotEmpty(schoolEntity.getName()))
				schoolName = (schoolEntity.getName() == null) ? "" : schoolEntity.getName();
			
			if (StringUtil.isNotEmpty(schoolEntity.getCode()))
				schoolCode = (schoolEntity.getCode() == null) ? "" : schoolEntity.getCode();
		}
		
		if (personEntity != null){
			
			map.put("code", schoolCode + "_" + personEntity.getCode());
			map.put("school_name", schoolName == null ? "":schoolName);
			
	        map.put("seq_no", personEntity.getSeqNo() == null ? "" : personEntity.getSeqNo());
	        map.put("name", personEntity.getName() == null ? "" : personEntity.getName());
	        map.put("sex",  personEntity.getSex() == null  ? "" : personEntity.getSex());
	        map.put("age",  personEntity.getAge() == null  ? "" : personEntity.getAge());
	        map.put("birthday", personEntity.getBirthday() == null ? "" : personEntity.getBirthday());
	        map.put("photo_id_no", personEntity.getPhotoIdNo()==null? "" : personEntity.getPhotoIdNo());
	        map.put("nationality", personEntity.getNationality()==null? "" : personEntity.getNationality());
	        map.put("social_status", personEntity.getSocialStatus()==null? "" : personEntity.getSocialStatus());
	        map.put("start_work_date", personEntity.getStartWorkDate()==null? "" : personEntity.getStartWorkDate());	        
	        map.put("edu_background", personEntity.getEduBackground()==null ? "" : personEntity.getEduBackground());
	        map.put("degree", personEntity.getDegree()==null ? "" : personEntity.getDegree());	        
	        map.put("major", personEntity.getMajor()==null ?  "" : personEntity.getMajor() );
	        map.put("graduate_date", personEntity.getGraduateDate()==null ? "" : personEntity.getGraduateDate());
	        map.put("graduate_school", personEntity.getGraduateSchool() == null ? "" : personEntity.getGraduateSchool());
	        map.put("contact_no", personEntity.getContactNo() == null ? "" : personEntity.getContactNo());
	        map.put("home_address", personEntity.getHomeAddress() == null ? "" : personEntity.getHomeAddress());
	        map.put("enter_approach", personEntity.getEnterApproach() == null ? "" : personEntity.getEnterApproach());
	        map.put("enter_date", personEntity.getEnterDate() == null ? "" : personEntity.getEnterDate());
	        map.put("junior_title_date", personEntity.getJuniorTitleDate() == null ? "" : personEntity.getJuniorTitleDate());
	        map.put("secondary_title_date", personEntity.getSecondaryTitleDate() == null ? "" : personEntity.getSecondaryTitleDate());
	        map.put("senior_title_date", personEntity.getSeniorTitleDate() == null ? "" : personEntity.getSeniorTitleDate());
	        map.put("comment", personEntity.getComments() == null ? "" : personEntity.getComments());
	        
	        map.put("work_age", DateService.getWorkAge(personEntity.getStartWorkDate()));
	        map.put("photo", "");
	        
		}
		
		List<ExamExportEntity> examList = new ArrayList<ExamExportEntity>();
		int seq=0;
		
		if (zformPersonExamEntityList != null && zformPersonExamEntityList.size() > 0){			
			for(ZformPersonExamEntity zformPersonExamEntity : zformPersonExamEntityList){
				ExamExportEntity examEntity = new ExamExportEntity();
				
				seq++;
				String year = DateService.GetSchoolYearRange(zformPersonExamEntity.getYear());
				String examResult = zformPersonExamEntity.getFinalResult() == null ? "" : zformPersonExamEntity.getFinalResult();
				String job = zformPersonExamEntity.getJob() == null ? "":zformPersonExamEntity.getJob();				
				
				examEntity.setSeq(String.valueOf(seq).toString());
				examEntity.setYearRange(year);
				examEntity.setExamResult(examResult);
				examEntity.setJob(job);
				
				examList.add(examEntity);
			}
		}
		
		map.put("examlist", examList);
		
		return map;
	}
		
	public Map<String,Object> GetPersonalResume(ZformPersonEntity personEntity, ZformPersonActiveEntity personActiveEntity, ZformSchoolEntity schoolEntity){
		Map<String,Object> map = new HashMap<String, Object>();
		
		String schoolCode = "";
		String schoolName = "";
		
		if (schoolEntity != null){
			if (StringUtil.isNotEmpty(schoolEntity.getName()))
				schoolName = (schoolEntity.getName() == null) ? "" : schoolEntity.getName();
			
			if (StringUtil.isNotEmpty(schoolEntity.getCode()))
				schoolCode = (schoolEntity.getCode() == null) ? "" : schoolEntity.getCode();
		}
		
		if (personEntity != null){
			
			map.put("code", schoolCode + "_" + personEntity.getCode());
			map.put("school_name", schoolName == null ? "":schoolName);
			
	        map.put("seq_no", personEntity.getSeqNo() == null ? "" : personEntity.getSeqNo());
	        map.put("name", personEntity.getName() == null ? "" : personEntity.getName());
	        map.put("sex",  personEntity.getSex() == null  ? "" : personEntity.getSex());
	        map.put("age",  personEntity.getAge() == null  ? "" : personEntity.getAge());
	        map.put("birthday", personEntity.getBirthday() == null ? "" : personEntity.getBirthday());
	        map.put("photo_id_no", personEntity.getPhotoIdNo()==null? "" : personEntity.getPhotoIdNo());
	        map.put("nationality", personEntity.getNationality()==null? "" : personEntity.getNationality());
	        map.put("social_status", personEntity.getSocialStatus()==null? "" : personEntity.getSocialStatus());
	        map.put("start_work_date", personEntity.getStartWorkDate()==null? "" : personEntity.getStartWorkDate());	        
	        map.put("edu_background", personEntity.getEduBackground()==null ? "" : personEntity.getEduBackground());
	        map.put("degree", personEntity.getDegree()==null ? "" : personEntity.getDegree());	        
	        map.put("major", personEntity.getMajor()==null ?  "" : personEntity.getMajor() );
	        map.put("graduate_date", personEntity.getGraduateDate()==null ? "" : personEntity.getGraduateDate());
	        map.put("graduate_school", personEntity.getGraduateSchool() == null ? "" : personEntity.getGraduateSchool());
	        map.put("contact_no", personEntity.getContactNo() == null ? "" : personEntity.getContactNo());
	        map.put("home_address", personEntity.getHomeAddress() == null ? "" : personEntity.getHomeAddress());
	        map.put("enter_approach", personEntity.getEnterApproach() == null ? "" : personEntity.getEnterApproach());
	        map.put("enter_date", personEntity.getEnterDate() == null ? "" : personEntity.getEnterDate());
	        map.put("junior_title_date", personEntity.getJuniorTitleDate() == null ? "" : personEntity.getJuniorTitleDate());
	        map.put("secondary_title_date", personEntity.getSecondaryTitleDate() == null ? "" : personEntity.getSecondaryTitleDate());
	        map.put("senior_title_date", personEntity.getSeniorTitleDate() == null ? "" : personEntity.getSeniorTitleDate());
	        map.put("comment", personEntity.getComments() == null ? "" : personEntity.getComments());
	        
	        map.put("work_age", DateService.getWorkAge(personEntity.getStartWorkDate()));
	        map.put("photo", "");
	        
		}
		
		if (personActiveEntity != null){
			map.put("current_identity", personActiveEntity.getCurrentIdentity() == null ? "" : personActiveEntity.getCurrentIdentity());
			map.put("current_title", personActiveEntity.getCurrentTitle() == null ? "" : personActiveEntity.getCurrentTitle());
			map.put("current_title_date", personActiveEntity.getCurrentTitleDate() == null ? "" : personActiveEntity.getCurrentTitleDate());
	        map.put("duty_category", personActiveEntity.getDutyCategory() == null ? "" : personActiveEntity.getDutyCategory());
	        map.put("executive_title", personActiveEntity.getExecutiveTitle() == null ? "" : personActiveEntity.getExecutiveTitle());    
	        map.put("job", personActiveEntity.getCurrentJob() == null ? "" : personActiveEntity.getCurrentJob());
	        map.put("job_extra", personActiveEntity.getCurrentJobExtra() == null ? "" : personActiveEntity.getCurrentJobExtra());
	        map.put("job_type", personActiveEntity.getCurrentJobType() == null ? "" : personActiveEntity.getCurrentJobType());
	        map.put("job_level", personActiveEntity.getCurrentJobLevel() == null ? "" : personActiveEntity.getCurrentJobLevel());
	        map.put("job_salary", personActiveEntity.getJobSalary() == null ? "" : personActiveEntity.getJobSalary());
	        map.put("rank", personActiveEntity.getRank() == null ? "" : personActiveEntity.getRank());
	        map.put("rank_salary", personActiveEntity.getRankSalary() == null ? "" : personActiveEntity.getRankSalary());
	        map.put("extra_salary", personActiveEntity.getExtraSalary() == null ? "" : personActiveEntity.getExtraSalary());
	        map.put("teaching_seniority", personActiveEntity.getTeachingSeniority() == null ? "" : personActiveEntity.getTeachingSeniority());
	        map.put("hard_core", personActiveEntity.getHardCore() == null ? "" : personActiveEntity.getHardCore());
	        map.put("honor_title", personActiveEntity.getHonorTitle() == null ? "" : personActiveEntity.getHonorTitle());	
	        map.put("major_grade", personActiveEntity.getMajorGrade() == null ? "" : personActiveEntity.getMajorGrade());
	        map.put("teaching_course_1", personActiveEntity.getTeachingCourse1() == null ? "" : personActiveEntity.getTeachingCourse1());
	        map.put("teaching_grade_1", personActiveEntity.getTeachingGrade1() == null ? "" : personActiveEntity.getTeachingGrade1());  
	        map.put("teaching_class_no_1", personActiveEntity.getTeachingClassNo1() == null ? "" : personActiveEntity.getTeachingClassNo1());
	        map.put("teaching_course_2", personActiveEntity.getTeachingCourse2() == null ? "" : personActiveEntity.getTeachingCourse2());
	        map.put("teaching_grade_2", personActiveEntity.getTeachingGrade2() == null ? "" : personActiveEntity.getTeachingGrade2());
	        map.put("teaching_class_no_2", personActiveEntity.getTeachingClassNo2() == null ? "" : personActiveEntity.getTeachingClassNo2());
	        map.put("contract_term", personActiveEntity.getContractTerm() == null ? "" : personActiveEntity.getContractTerm());
	        map.put("contract_end_date", personActiveEntity.getContractEndDate() == null ? "" : personActiveEntity.getContractEndDate());
	        map.put("probation_end_date", personActiveEntity.getProbationEndDate() == null ? "" : personActiveEntity.getProbationEndDate());
	        map.put("teacher_cert", personActiveEntity.getTeacherCert() == null ? "" : personActiveEntity.getTeacherCert());
	        map.put("teacher_cert_level", personActiveEntity.getTeacherCertLevel() == null ? "" : personActiveEntity.getTeacherCertLevel());
	        map.put("teacher_cert_date", personActiveEntity.getTeacherCertDate() == null ? "" : personActiveEntity.getTeacherCertDate());
	        map.put("reg_end_date", personActiveEntity.getRegEndDate() == null ? "" : personActiveEntity.getRegEndDate());
	        map.put("rotate_status", personActiveEntity.getRotateStatus() == null ? "" : personActiveEntity.getRotateStatus());
	        map.put("probation_status", personActiveEntity.getProbationStatus() == null ? "" : personActiveEntity.getProbationStatus());
	        map.put("transfer_reason", personActiveEntity.getTransferReason() == null ? "" : personActiveEntity.getTransferReason());
	        map.put("department", personActiveEntity.getDepartment() == null ? "" : personActiveEntity.getDepartment());
	        map.put("weekly_hours", personActiveEntity.getWeeklyHours() == null ? "" : personActiveEntity.getWeeklyHours());
	        map.put("service_end_date", personActiveEntity.getServiceEndDate() == null ? "" : personActiveEntity.getServiceEndDate());
	        map.put("service_remain_date", personActiveEntity.getServiceRemainDate() == null ? "" : personActiveEntity.getServiceRemainDate());
	        map.put("comments2", personActiveEntity.getComments() == null ? "" : personActiveEntity.getComments());
	        
	        
	        map.put("total_salary", DateService.GetTotalSalary(personActiveEntity.getJobSalary(), personActiveEntity.getRankSalary(), personActiveEntity.getExtraSalary()));
		}
		
        
		return map;
	}

	public Map<String, Object> GetSchoolStat(SystemService systemService, int year, int month) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();		
		
		String hql0 = "from ZformPersonEntity where 1 = 1";
		List<ZformPersonEntity> zformPersonEntityList = systemService.findHql(hql0);
		
		if (zformPersonEntityList == null || zformPersonEntityList.size() < 1)
			return null;
		
		String hql1 = "from ZformPersonActiveEntity where 1 = 1";
		List<ZformPersonActiveEntity> zformPersonActiveEntityList = systemService.findHql(hql1);
				
		if (zformPersonActiveEntityList == null || zformPersonActiveEntityList.size() < 1) 
			return null;
		
		String hql2 = "from ZformSchoolEntity where 1 = 1";
		List<ZformSchoolEntity> zformSchoolEntityList = systemService.findHql(hql2);
		
		if (zformSchoolEntityList == null || zformSchoolEntityList.size() < 1)
			return null;
		
		int currentYear = DateService.GetCurrentSchoolYear();
		
		map.put("start_year", currentYear);
		map.put("end_year", currentYear + 1);
		
		int cateen_employee_count = 0;
		int cateen_student_count = 0;
		int board_count = 0;
		int retire_1 = 0;
		int retire_2 = 0;
		
		int grade1_class_no = 0;
		int grade2_class_no = 0;
		int grade3_class_no = 0;
		int grade4_class_no = 0;
		int grade5_class_no = 0;
		int grade6_class_no = 0;
		
		int grade1_student_no = 0;
		int grade2_student_no = 0;
		int grade3_student_no = 0;
		int grade4_student_no = 0;
		int grade5_student_no = 0;
		int grade6_student_no = 0;
		
		int grade1_teacher_no = 0;
		int grade2_teacher_no = 0;
		int grade3_teacher_no = 0;
		int grade4_teacher_no = 0;
		int grade5_teacher_no = 0;
		int grade6_teacher_no = 0;
		
		for(ZformSchoolEntity zformSchoolEntity : zformSchoolEntityList){
			
			if (zformSchoolEntity == null)
				continue;
			
			Integer cateenStudentNo = zformSchoolEntity.getCanteenStudentNo();
			Integer cateenEmployeeNo = zformSchoolEntity.getCanteenEmployeeNo();
			Integer boardNo = zformSchoolEntity.getBoarderNo();
			Integer retireEmployeeNo1 = zformSchoolEntity.getRetireEmployeeNo1();
			Integer retireEmployeeNo2 = zformSchoolEntity.getRetireEmployeeNo2();
			
			if (cateenStudentNo != null)
				cateen_student_count += cateenStudentNo.intValue();
			if (cateenEmployeeNo != null)
				cateen_employee_count += cateenEmployeeNo.intValue();
			if (boardNo != null)
				board_count += boardNo.intValue();
			if (retireEmployeeNo1 != null)
				retire_1 += retireEmployeeNo1.intValue();
			if (retireEmployeeNo2 != null)
				retire_2 += retireEmployeeNo2.intValue();
			
			if (zformSchoolEntity.getGrade1ClassNo() != null)
				grade1_class_no += zformSchoolEntity.getGrade1ClassNo().intValue();
			
			if (zformSchoolEntity.getGrade2ClassNo() != null)
				grade2_class_no += zformSchoolEntity.getGrade2ClassNo().intValue();
			
			if (zformSchoolEntity.getGrade3ClassNo() != null)
				grade3_class_no += zformSchoolEntity.getGrade3ClassNo().intValue();
			
			if (zformSchoolEntity.getGrade4ClassNo() != null)
				grade4_class_no += zformSchoolEntity.getGrade4ClassNo().intValue();
			
			if (zformSchoolEntity.getGrade5ClassNo() != null)
				grade5_class_no += zformSchoolEntity.getGrade5ClassNo().intValue();
			
			if (zformSchoolEntity.getGrade6ClassNo() != null)
				grade6_class_no += zformSchoolEntity.getGrade6ClassNo().intValue();
			
			//////////////////////////////////////////////////////////////////////////////
			
			if (zformSchoolEntity.getGrade1StudentNo() != null)
				grade1_student_no += zformSchoolEntity.getGrade1StudentNo().intValue();
			
			if (zformSchoolEntity.getGrade2StudentNo() != null)
				grade2_student_no += zformSchoolEntity.getGrade2StudentNo().intValue();
			
			if (zformSchoolEntity.getGrade3StudentNo() != null)
				grade3_student_no += zformSchoolEntity.getGrade3StudentNo().intValue();
			
			if (zformSchoolEntity.getGrade4StudentNo() != null)
				grade4_student_no += zformSchoolEntity.getGrade4StudentNo().intValue();
			
			if (zformSchoolEntity.getGrade5StudentNo() != null)
				grade5_student_no += zformSchoolEntity.getGrade5StudentNo().intValue();
			
			if (zformSchoolEntity.getGrade6StudentNo() != null)
				grade6_student_no += zformSchoolEntity.getGrade6StudentNo().intValue();
			
			////////////////////////////////////////////////////////////////////////////////
			
			if (zformSchoolEntity.getGrade1TeacherNo() != null)
				grade1_teacher_no += zformSchoolEntity.getGrade1TeacherNo().intValue();
			
			if (zformSchoolEntity.getGrade2TeacherNo() != null)
				grade2_teacher_no += zformSchoolEntity.getGrade2TeacherNo().intValue();
			
			if (zformSchoolEntity.getGrade3TeacherNo() != null)
				grade3_teacher_no += zformSchoolEntity.getGrade3TeacherNo().intValue();

			if (zformSchoolEntity.getGrade4TeacherNo() != null)
				grade4_teacher_no += zformSchoolEntity.getGrade4TeacherNo().intValue();
			
			if (zformSchoolEntity.getGrade5TeacherNo() != null)
				grade5_teacher_no += zformSchoolEntity.getGrade5TeacherNo().intValue();
			
			if (zformSchoolEntity.getGrade6TeacherNo() != null)
				grade6_teacher_no += zformSchoolEntity.getGrade6TeacherNo().intValue();
			
		}
		
		map.put("cateen_employee_count", cateen_employee_count);
		map.put("cateen_student_count", cateen_student_count);
		map.put("board_count", board_count);
		
		map.put("retire_1", retire_1);
		map.put("retire_2", retire_2);
		
		
		map.put("grade1_class_no", grade1_class_no);
		map.put("grade2_class_no", grade2_class_no);
		map.put("grade3_class_no", grade3_class_no);
		map.put("grade4_class_no", grade4_class_no);
		map.put("grade5_class_no", grade5_class_no);
		map.put("grade6_class_no", grade6_class_no);
		
		map.put("grade1_student_no", grade1_student_no);
		map.put("grade2_student_no", grade2_student_no);
		map.put("grade3_student_no", grade3_student_no);
		map.put("grade4_student_no", grade4_student_no);
		map.put("grade5_student_no", grade5_student_no);
		map.put("grade6_student_no", grade6_student_no);
		
		map.put("grade1_teacher_no", grade1_teacher_no);
		map.put("grade2_teacher_no", grade2_teacher_no);
		map.put("grade3_teacher_no", grade3_teacher_no);
		map.put("grade4_teacher_no", grade4_teacher_no);
		map.put("grade5_teacher_no", grade5_teacher_no);
		map.put("grade6_teacher_no", grade6_teacher_no);
		
		
		
		int total_near_retire = 0;
		
		
		
		int totalEmployeeCount = 0;
		int maleEmployeeCount = 0;
		int femaleEmployeeCount = 0;
		
		int high_leader_phd_count = 0;
		int high_leader_master_count = 0;
		int high_leader_university_count = 0;
		int high_leader_college_count = 0;
		int high_leader_special_count = 0;
		int high_leader_highschool_count = 0;
		int high_leader_other_count = 0;
		int high_leader_total_count = 0;
		
		int middle_leader_phd_count = 0;
		int middle_leader_master_count = 0;
		int middle_leader_university_count = 0;
		int middle_leader_college_count = 0;
		int middle_leader_special_count = 0;
		int middle_leader_highschool_count = 0;
		int middle_leader_other_count = 0;
		int middle_leader_total_count = 0;
		
		int special_teacher_phd_count = 0;
		int special_teacher_master_count = 0;
		int special_teacher_university_count = 0;
		int special_teacher_college_count = 0;
		int special_teacher_special_count = 0;
		int special_teacher_highschool_count = 0;
		int special_teacher_other_count = 0;
		int special_teacher_total_count = 0;
		
		int technian_phd_count = 0;
		int technian_master_count = 0;
		int technian_university_count = 0;
		int technian_college_count = 0;
		int technian_special_count = 0;
		int technian_highschool_count = 0;
		int technian_other_count = 0;
		int technian_total_count = 0;
		
		int staff_member_phd_count = 0;
		int staff_member_master_count = 0;
		int staff_member_university_count = 0;
		int staff_member_college_count = 0;
		int staff_member_special_count = 0;
		int staff_member_highschool_count = 0;
		int staff_member_other_count = 0;
		int staff_member_total_count = 0;
		
		int special_worker_phd_count = 0;
		int special_worker_master_count = 0;
		int special_worker_university_count = 0;
		int special_worker_college_count = 0;
		int special_worker_special_count = 0;
		int special_worker_highschool_count = 0;
		int special_worker_other_count = 0;
		int special_worker_total_count = 0;
		
		int sick_leave_phd_count = 0;
		int sick_leave_master_count = 0;
		int sick_leave_university_count = 0;
		int sick_leave_college_count = 0;
		int sick_leave_special_count = 0;
		int sick_leave_highschool_count = 0;
		int sick_leave_other_count = 0;
		int sick_leave_total_count = 0;
		
		int other_phd_count = 0;
		int other_master_count = 0;
		int other_university_count = 0;
		int other_college_count = 0;
		int other_special_count = 0;
		int other_highschool_count = 0;
		int other_other_count = 0;
		int other_total_count = 0;
		
		int party_count = 0;
		int league_count = 0;
		int democratic_count = 0;
		int minority_count = 0;
		
		int male_25 = 0;
		int male_26_30 = 0;
		int male_31_35 = 0;
		int male_36_40 = 0;
		int male_41_45 = 0;
		int male_46_50 = 0;
		int male_51_55 = 0;
		int male_56 = 0;
		
		int male_teacher_25 = 0;
		int male_teacher_26_30 = 0;
		int male_teacher_31_35 = 0;
		int male_teacher_36_40 = 0;
		int male_teacher_41_45 = 0;
		int male_teacher_46_50 = 0;
		int male_teacher_51_55 = 0;
		int male_teacher_56 = 0;
		
		int female_25 = 0;
		int female_26_30 = 0;
		int female_31_35 = 0;
		int female_36_40 = 0;
		int female_41_45 = 0;
		int female_46_50 = 0;
		int female_51_55 = 0;
		int female_56 = 0;
		
		int female_teacher_25 = 0;
		int female_teacher_26_30 = 0;
		int female_teacher_31_35 = 0;
		int female_teacher_36_40 = 0;
		int female_teacher_41_45 = 0;
		int female_teacher_46_50 = 0;
		int female_teacher_51_55 = 0;
		int female_teacher_56 = 0;
		
		
		
		int teacher_title_1 = 0;
		int teacher_title_2 = 0;
		int teacher_title_3 = 0;
		int teacher_title_4 = 0;
		int teacher_title_5 = 0;
		int teacher_title_6 = 0;
		
		int worker_title_1 = 0;
		int worker_title_2 = 0;
		int worker_title_3 = 0;
		int worker_title_4 = 0;
		
		int core_1 = 0;
		int core_2 = 0;
		int core_3 = 0;
		int core_4 = 0;
		int core_5 = 0;
		
		
		
		
		
		for(ZformPersonEntity zformPersonEntity : zformPersonEntityList){
			
			totalEmployeeCount ++ ;
			
			if (zformPersonEntity.getBirthday() != null){
				String age = DateService.getAge(zformPersonEntity.getBirthday());
				if (DateService.NearRetire(age, zformPersonEntity.getSex()))
					total_near_retire ++;
			}
			
			String age = zformPersonEntity.getAge();
			
			String sex = zformPersonEntity.getSex();
			//教职工数
			if (sex != null){
				if (sex.equalsIgnoreCase(Common.Female))
					femaleEmployeeCount ++;
				if (sex.equalsIgnoreCase(Common.Male))
					maleEmployeeCount ++;				
			}			
			
			//少数民族人数
			String nationality = zformPersonEntity.getNationality();
			
			if (StringUtil.isNotEmpty(nationality)){
				if (!nationality.contains(Common.HanNationality))
					minority_count ++;
			}
			
			//党员，团员，民主党派
			String socialStatus = zformPersonEntity.getSocialStatus();
			
			if (socialStatus != null){
				if (socialStatus.contains(Common.PartyMember))
					party_count ++;
				if (socialStatus.contains(Common.LeagueMember))
					league_count ++;
				if (socialStatus.contains(Common.DemocraticMember))
					democratic_count++;
			}
			
			
			String code = zformPersonEntity.getCode();
			
			String eduBackground = zformPersonEntity.getEduBackground(); 
			
			for (ZformPersonActiveEntity personActiveEntity : zformPersonActiveEntityList){
				
				String dutyCategory =  personActiveEntity.getDutyCategory();
				
				if (!personActiveEntity.getCode().equals(code))
					continue;
				
				
				String core = personActiveEntity.getHardCore();
				
				if (StringUtil.isNotEmpty(core)){
					if (core.contains(Common.Extinguish_Teacher)){
						core_1 ++;
					}
					
					if (core.contains(Common.City_Leader)){
						core_2 ++;
					}
					
					if (core.contains(Common.City_country_Core) || core.contains(Common.City_Core)){
						core_3 ++;
					}
					
					if (core.contains(Common.Local_Core) || core.contains(Common.Local_Core_Research)){
						core_4 ++;
					}
					
					if (core.contains(Common.Local_Youth_Core)){
						core_5 ++;
					}
				}
				
				String title   = personActiveEntity.getCurrentTitle();
				String jobType = personActiveEntity.getCurrentJobType();
				String jobLevel = personActiveEntity.getCurrentJobLevel();
				
				if (StringUtil.isNotEmpty(title) && StringUtil.isNotEmpty(jobType)){
					
					//专职技术职务任职资格情况
					if (jobType.equals("专业技术岗位") || jobType.equals("双肩挑")){						
						if (title.equals("正高级教师")){
							teacher_title_1++;
						}else if (title.equals("高级教师")){
							teacher_title_2++;
						}else if (title.equals("一级教师")){
							teacher_title_3++;
						}else if (title.equals("二级教师")){
							teacher_title_4++;
						}else if (title.equals("三级教师")){
							teacher_title_5++;
						}else{
							teacher_title_6++;
						}
					//工人技术等级情况	
					}else if (jobType.equals("工勤技能岗位")){
						if(jobLevel != null){
							if (jobLevel.equals("1")){
								worker_title_1++;
							}else if (jobLevel.equals("2") || jobLevel.equals("3")){
								worker_title_2++;
							}else if (jobLevel.equals("4") || jobLevel.equals("5")){
								worker_title_3++;
							}else if (jobLevel.equals("普通工")){
								worker_title_4++;
							}
						}
					}
				}
				
				if (dutyCategory != null && sex != null && age != null){
					//教职工年龄结构
					int currentAge = Integer.parseInt(age);
					
					if (currentAge <= 25){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_25++;
							male_25++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_25++;
							female_25++;
						}
					}
					
					if (currentAge > 25 && currentAge <= 30){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_26_30++;
							male_26_30++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_26_30++;
							female_26_30++;
						}
					}
					
					if (currentAge > 30 && currentAge <= 35){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_31_35++;
							male_31_35++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_31_35++;
							female_31_35++;
						}
					}
					
					if (currentAge > 35 && currentAge <= 40){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_36_40++;
							male_36_40++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_36_40++;
							female_36_40++;
						}
					}
					
					if (currentAge > 40 && currentAge <= 45){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_41_45++;
							male_41_45++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_41_45++;
							female_41_45++;
						}
					}
					
					if (currentAge > 45 && currentAge <= 50){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_46_50++;
							male_46_50++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_46_50++;
							female_46_50++;
						}
					}
					
					if (currentAge > 50 && currentAge <= 55){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_51_55++;
							male_51_55++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_51_55++;
							female_51_55++;
						}
					}
					
					if (currentAge > 55){
						if (sex.equals(Common.Male)){
							if (dutyCategory.equals(Common.Special_Teacher))
								male_teacher_56++;
							male_56++;
						}
						
						if (sex.equals(Common.Female)){
							if (dutyCategory.equals(Common.Special_Teacher))
								female_teacher_56++;
							female_56++;
						}
					}
				}
				
				//学历情况
				if (eduBackground != null && dutyCategory != null) {
					switch (dutyCategory) {
					case Common.High_Leader:
						// 校级领导
						switch (eduBackground) {
						case Common.Phd_Above:
							high_leader_phd_count++;
							break;
						case Common.Master:
							high_leader_master_count++;
							break;
						case Common.University:
							high_leader_university_count++;
							break;
						case Common.College:
							high_leader_college_count++;
							break;
						case Common.Special:
							high_leader_special_count++;
							break;
						case Common.HighSchool_Below:
							high_leader_highschool_count++;
							break;
						default:
							high_leader_other_count++;
						}
						break;
					case Common.Middle_Leader:
						// 中层领导
						switch (eduBackground) {
						case Common.Phd_Above:
							middle_leader_phd_count++;
							break;
						case Common.Master:
							middle_leader_master_count++;
							break;
						case Common.University:
							middle_leader_university_count++;
							break;
						case Common.College:
							middle_leader_college_count++;
							break;
						case Common.Special:
							middle_leader_special_count++;
							break;
						case Common.HighSchool_Below:
							middle_leader_highschool_count++;
							break;
						default:
							middle_leader_other_count++;
						}
						break;
					case Common.Special_Teacher:
						// 专任教师
						switch (eduBackground) {
						case Common.Phd_Above:
							special_teacher_phd_count++;
							break;
						case Common.Master:
							special_teacher_master_count++;
							break;
						case Common.University:
							special_teacher_university_count++;
							break;
						case Common.College:
							special_teacher_college_count++;
							break;
						case Common.Special:
							special_teacher_special_count++;
							break;
						case Common.HighSchool_Below:
							special_teacher_highschool_count++;
							break;
						default:
							special_teacher_other_count++;
						}
						break;
					case Common.Technian:
						// 其它技术人员
						switch (eduBackground) {
						case Common.Phd_Above:
							technian_phd_count++;
							break;
						case Common.Master:
							technian_master_count++;
							break;
						case Common.University:
							technian_university_count++;
							break;
						case Common.College:
							technian_college_count++;
							break;
						case Common.Special:
							technian_special_count++;
							break;
						case Common.HighSchool_Below:
							technian_highschool_count++;
							break;
						default:
							technian_other_count++;
						}
						break;
					case Common.Staff_Member:
						// 职员
						switch (eduBackground) {
						case Common.Phd_Above:
							staff_member_phd_count++;
							break;
						case Common.Master:
							staff_member_master_count++;
							break;
						case Common.University:
							staff_member_university_count++;
							break;
						case Common.College:
							staff_member_college_count++;
							break;
						case Common.Special:
							staff_member_special_count++;
							break;
						case Common.HighSchool_Below:
							staff_member_highschool_count++;
							break;
						default:
							staff_member_other_count++;
						}
						break;
					case Common.Special_Worker:
						// 工勤
						switch (eduBackground) {
						case Common.Phd_Above:
							special_worker_phd_count++;
							break;
						case Common.Master:
							special_worker_master_count++;
							break;
						case Common.University:
							special_worker_university_count++;
							break;
						case Common.College:
							special_worker_college_count++;
							break;
						case Common.Special:
							special_worker_special_count++;
							break;
						case Common.HighSchool_Below:
							special_worker_highschool_count++;
							break;
						default:
							special_worker_other_count++;
						}
						break;
					case Common.Sick_Leave:
						// 病休
						switch (eduBackground) {
						case Common.Phd_Above:
							sick_leave_phd_count++;
							break;
						case Common.Master:
							sick_leave_master_count++;
							break;
						case Common.University:
							sick_leave_university_count++;
							break;
						case Common.College:
							sick_leave_college_count++;
							break;
						case Common.Special:
							sick_leave_special_count++;
							break;
						case Common.HighSchool_Below:
							sick_leave_highschool_count++;
							break;
						default:
							sick_leave_other_count++;
						}
						break;
					case Common.Other:
						// 其它
						switch (eduBackground) {
						case Common.Phd_Above:
							other_phd_count++;
							break;
						case Common.Master:
							other_master_count++;
							break;
						case Common.University:
							other_university_count++;
							break;
						case Common.College:
							other_college_count++;
							break;
						case Common.Special:
							other_special_count++;
							break;
						case Common.HighSchool_Below:
							other_highschool_count++;
							break;
						default:
							other_other_count++;
						}
						break;
					default:
						break;
					}
				}
			}			
		}
		
		
		map.put("total_near_retire", total_near_retire);
		map.put("total_employee_count", totalEmployeeCount);
		map.put("male_employee_count", maleEmployeeCount);
		map.put("female_employee_count", femaleEmployeeCount);
		
		map.put("party_count", party_count);
		map.put("league_count", league_count);
		map.put("democratic_count", democratic_count);
		map.put("minority_count", minority_count);
		
		high_leader_total_count = high_leader_phd_count + high_leader_master_count + high_leader_university_count + high_leader_college_count + high_leader_special_count + high_leader_highschool_count + high_leader_other_count;
		map.put("duty_leader", high_leader_total_count);
		
		middle_leader_total_count = middle_leader_phd_count + middle_leader_master_count + middle_leader_university_count + middle_leader_college_count + middle_leader_special_count + middle_leader_highschool_count + middle_leader_other_count;
		map.put("duty_middle", middle_leader_total_count);
		
		special_teacher_total_count = special_teacher_phd_count + special_teacher_master_count + special_teacher_university_count + special_teacher_college_count + special_teacher_special_count + special_teacher_highschool_count + special_teacher_other_count;
		map.put("duty_teacher", special_teacher_total_count);
		
		technian_total_count = technian_phd_count + technian_master_count + technian_university_count + technian_college_count + technian_special_count + technian_highschool_count + technian_other_count;
		map.put("duty_tech", technian_total_count);
		
		staff_member_total_count = staff_member_phd_count + staff_member_master_count + staff_member_university_count + staff_member_college_count + staff_member_special_count + staff_member_highschool_count + staff_member_other_count;
		map.put("duty_employee", staff_member_total_count);
		
		special_worker_total_count = special_worker_phd_count + special_worker_master_count + special_worker_university_count + special_worker_college_count + special_worker_special_count + special_worker_highschool_count + special_worker_other_count;
		map.put("duty_worker", special_worker_total_count);
		
		sick_leave_total_count = sick_leave_phd_count + sick_leave_master_count + sick_leave_university_count + sick_leave_college_count + sick_leave_special_count + sick_leave_highschool_count + sick_leave_other_count;
		map.put("duty_ill", sick_leave_total_count);
		
		other_total_count = other_phd_count + other_master_count + other_university_count + other_college_count + other_special_count + other_highschool_count + other_other_count;
		map.put("duty_other", other_total_count);
		
		map.put("duty_all", high_leader_total_count + middle_leader_total_count + special_teacher_total_count + technian_total_count + staff_member_total_count + special_worker_total_count + sick_leave_total_count + other_total_count);
		
		
		map.put("phd_1", high_leader_phd_count);
		map.put("phd_2", middle_leader_phd_count);
		map.put("phd_3", special_teacher_phd_count);
		map.put("phd_4", technian_phd_count);
		map.put("phd_5", staff_member_phd_count);
		map.put("phd_6", special_worker_phd_count);
		map.put("phd_7", sick_leave_phd_count + other_phd_count);
		map.put("phd_total", high_leader_phd_count + middle_leader_phd_count + special_teacher_phd_count + technian_phd_count + staff_member_phd_count + special_worker_phd_count + sick_leave_phd_count + other_phd_count);
		
		map.put("master_1", high_leader_master_count);
		map.put("master_2", middle_leader_master_count);
		map.put("master_3", special_teacher_master_count);
		map.put("master_4", technian_master_count);
		map.put("master_5", staff_member_master_count);
		map.put("master_6", special_worker_master_count);
		map.put("master_7", sick_leave_master_count + other_master_count);
		map.put("master_total", high_leader_master_count + middle_leader_master_count + special_teacher_master_count + technian_master_count + staff_member_master_count + special_worker_master_count + sick_leave_master_count + other_master_count);
		
		map.put("university_1", high_leader_university_count);
		map.put("university_2", middle_leader_university_count);
		map.put("university_3", special_teacher_university_count);
		map.put("university_4", technian_university_count);
		map.put("university_5", staff_member_university_count);
		map.put("university_6", special_worker_university_count);
		map.put("university_7", sick_leave_university_count + other_university_count);
		map.put("university_total", high_leader_university_count + middle_leader_university_count + special_teacher_university_count + technian_university_count + staff_member_university_count + special_worker_university_count + sick_leave_university_count + other_university_count);
		
		map.put("college_1", high_leader_college_count);
		map.put("college_2", middle_leader_college_count);
		map.put("college_3", special_teacher_college_count);
		map.put("college_4", technian_college_count);
		map.put("college_5", staff_member_college_count);
		map.put("college_6", special_worker_college_count);
		map.put("college_7", sick_leave_college_count + other_college_count);
		map.put("college_total", high_leader_college_count + middle_leader_college_count + special_teacher_college_count + technian_college_count + staff_member_college_count + special_worker_college_count + sick_leave_college_count + other_college_count);
		
		map.put("special_1", high_leader_special_count);
		map.put("special_2", middle_leader_special_count);
		map.put("special_3", special_teacher_special_count);
		map.put("special_4", technian_special_count);
		map.put("special_5", staff_member_special_count);
		map.put("special_6", special_worker_special_count);
		map.put("special_7", sick_leave_special_count + other_special_count);
		map.put("special_total", high_leader_special_count + middle_leader_special_count + special_teacher_special_count + technian_special_count + staff_member_special_count + special_worker_special_count + sick_leave_special_count + other_special_count);

		map.put("highschool_1", high_leader_highschool_count);
		map.put("highschool_2", middle_leader_highschool_count);
		map.put("highschool_3", special_teacher_highschool_count);
		map.put("highschool_4", technian_highschool_count);
		map.put("highschool_5", staff_member_highschool_count);
		map.put("highschool_6", special_worker_highschool_count);
		map.put("highschool_7", sick_leave_highschool_count + other_highschool_count);
		map.put("highschool_total", high_leader_highschool_count + middle_leader_highschool_count + special_teacher_highschool_count + technian_highschool_count + staff_member_highschool_count + special_worker_highschool_count + sick_leave_highschool_count + other_highschool_count);
		
		map.put("other_1", high_leader_other_count);
		map.put("other_2", middle_leader_other_count);
		map.put("other_3", special_teacher_other_count);
		map.put("other_4", technian_other_count);
		map.put("other_5", staff_member_other_count);
		map.put("other_6", special_worker_other_count);
		map.put("other_7", sick_leave_other_count + other_other_count);
		map.put("other_8", high_leader_other_count + middle_leader_other_count + special_teacher_other_count + technian_other_count + staff_member_other_count + special_worker_other_count + sick_leave_other_count + other_other_count);
		
		map.put("male_25", male_25);
		map.put("male_26_30", male_26_30);
		map.put("male_31_35", male_31_35);
		map.put("male_36_40", male_36_40);
		map.put("male_41_45", male_41_45);
		map.put("male_46_50", male_46_50);
		map.put("male_51_55", male_51_55);
		map.put("male_56", male_56);
		
		map.put("male_teacher_25", male_teacher_25);
		map.put("male_teacher_26_30", male_teacher_26_30);
		map.put("male_teacher_31_35", male_teacher_31_35);
		map.put("male_teacher_36_40", male_teacher_36_40);
		map.put("male_teacher_41_45", male_teacher_41_45);
		map.put("male_teacher_46_50", male_teacher_46_50);
		map.put("male_teacher_51_55", male_teacher_51_55);
		map.put("male_teacher_56", male_teacher_56);
		
		map.put("female_25", female_25);
		map.put("female_26_30", female_26_30);
		map.put("female_31_35", female_31_35);
		map.put("female_36_40", female_36_40);
		map.put("female_41_45", female_41_45);
		map.put("female_46_50", female_46_50);
		map.put("female_51_55", female_51_55);
		map.put("female_56", female_56);
		
		map.put("female_teacher_25", female_teacher_25);
		map.put("female_teacher_26_30", female_teacher_26_30);
		map.put("female_teacher_31_35", female_teacher_31_35);
		map.put("female_teacher_36_40", female_teacher_36_40);
		map.put("female_teacher_41_45", female_teacher_41_45);
		map.put("female_teacher_46_50", female_teacher_46_50);
		map.put("female_teacher_51_55", female_teacher_51_55);
		map.put("female_teacher_56", female_teacher_56);
		
		
		
		map.put("teacher_title_1", teacher_title_1);
		map.put("teacher_title_2", teacher_title_2);
		map.put("teacher_title_3", teacher_title_3);
		map.put("teacher_title_4", teacher_title_4);
		map.put("teacher_title_5", teacher_title_5);
		map.put("teacher_title_6", teacher_title_6);
		
		map.put("worker_title_1", worker_title_1);
		map.put("worker_title_2", worker_title_2);
		map.put("worker_title_3", worker_title_3);
		map.put("worker_title_4", worker_title_4);
		
		map.put("core_1", core_1);
		map.put("core_2", core_2);
		map.put("core_3", core_3);
		map.put("core_4", core_4);
		map.put("core_5", core_5);
		return map;
	}

	public Map<String, Object> getInnerTransferBusinessMap(ZformPersonEntity zformPerson, ZformPersonActiveEntity zformPersonActiveEntity, ZformPersonTransferInnerEntity zformTransferInnerEntity,
			ZformSchoolEntity zformSchoolEntity) {		
		Calendar calendar = Calendar.getInstance();
		
		Map<String,Object> map = new HashMap<String, Object>();
		if (zformTransferInnerEntity != null && zformTransferInnerEntity.getSeqNo() != null)
			map.put("number", zformTransferInnerEntity.getSeqNo().toString());
		else
			map.put("number", "1");
		map.put("year", calendar.get(Calendar.YEAR));
		map.put("month", calendar.get(Calendar.MONTH)+1);
		map.put("day", calendar.get(Calendar.DAY_OF_MONTH));
		
		if (zformPerson != null)
			map.put("name", zformPerson.getName() == null ? "" : zformPerson.getName());
		else
			map.put("name", "");
		
		if (zformSchoolEntity != null)			
			map.put("to_school", zformSchoolEntity.getName() == null ? "" : zformSchoolEntity.getName());
		else
			map.put("to_school", "");
		
		if (zformTransferInnerEntity != null){
			Date salaryEndDate = zformTransferInnerEntity.getSalaryEndDate();
			if (salaryEndDate != null){
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				map.put("report_end_date", dateFormat.format(salaryEndDate));
			}
				
			else
				map.put("report_end_date", "");
		}else{
			map.put("report_end_date", "");
		}
		
		
		return map;
	}
	
	public Map<String, Object> getInnerTransferNotifyMap(ZformPersonEntity zformPerson, ZformPersonActiveEntity zformPersonActiveEntity, ZformPersonTransferInnerEntity zformTransferInnerEntity,
			ZformSchoolEntity zformSchoolEntity) {		
		Calendar calendar = Calendar.getInstance();
		
		Map<String,Object> map = new HashMap<String, Object>();
		if (zformTransferInnerEntity != null && zformTransferInnerEntity.getSeqNo() != null)
			map.put("number", zformTransferInnerEntity.getSeqNo().toString());
		else
			map.put("number", "1");
		map.put("year", calendar.get(Calendar.YEAR));
		map.put("month", calendar.get(Calendar.MONTH));
		map.put("day", calendar.get(Calendar.DAY_OF_MONTH));
		
		if (zformPerson != null)
			map.put("name", zformPerson.getName());
		else
			map.put("name", "");
		
		if (zformSchoolEntity != null)			
			map.put("to_school", zformSchoolEntity.getName());
		else
			map.put("to_school", "");
		
		
		return map;
	}
	
	public Map<String, Object> getInnerTransferReferenceMap(ZformPersonEntity zformPerson, ZformPersonActiveEntity zformPersonActiveEntity, ZformPersonTransferInnerEntity zformTransferInnerEntity,
			ZformSchoolEntity zformSchoolEntity) {		
		Calendar calendar = Calendar.getInstance();
		
		Map<String,Object> map = new HashMap<String, Object>();
		if (zformTransferInnerEntity != null && zformTransferInnerEntity.getSeqNo() != null)
			map.put("number", zformTransferInnerEntity.getSeqNo().toString());
		else
			map.put("number", "1");
		map.put("year", calendar.get(Calendar.YEAR));
		map.put("month", calendar.get(Calendar.MONTH));
		map.put("day", calendar.get(Calendar.DAY_OF_MONTH));
		
		if (zformPerson != null)
			map.put("name", zformPerson.getName());
		else
			map.put("name", "");
		
		if (zformSchoolEntity != null)			
			map.put("to_school", zformSchoolEntity.getName());
		else
			map.put("to_school", "");
		
		
		return map;
	}

	public Map<String, Object> getActivePersonMap(List<ZformPersonEntity> zformPersonEntityList) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put(key, value)
		
		return null;
	}
	
	public Map<String, Object> GetSalaryChangeAudit(ZformPersonEntity zformPerson, ZformPersonActiveEntity activeEntity, List<ZformPersonSalaryEntity> salaryList){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("name", zformPerson.getName() == null ? "" : zformPerson.getName());
		map.put("birth", zformPerson.getBirthday() == null ? "": zformPerson.getBirthday());
		map.put("startWorkDate", zformPerson.getStartWorkDate() == null ? "" : zformPerson.getStartWorkDate());
		map.put("wage", activeEntity.getTotalSeniority() == null ? "" : activeEntity.getTotalSeniority());
		map.put("edu", zformPerson.getEduBackground() == null ? "" : zformPerson.getEduBackground());
		map.put("grd", zformPerson.getGraduateDate() == null ? "" : zformPerson.getGraduateDate());
		
		ZformPersonSalaryEntity selectedSalaryEntity = null;
		for(ZformPersonSalaryEntity salaryEntity : salaryList){
			if (salaryEntity == null)
				continue;
			if (salaryEntity.getExtra1() != null && salaryEntity.getExtra1().equals("1")){
				selectedSalaryEntity = salaryEntity;
			}
		}
		
		if (selectedSalaryEntity != null)
		{
			map.put("pj", selectedSalaryEntity.getPrevJob() == null ? "" : selectedSalaryEntity.getPrevJob());
			map.put("prevJobDate", "");
			map.put("pl", selectedSalaryEntity.getPrevJobLevel() == null ? "" : selectedSalaryEntity.getPrevJobLevel());
			map.put("ps", selectedSalaryEntity.getPrevJobSalary() == null ? "" : selectedSalaryEntity.getPrevJobSalary().toString());
			map.put("pr", selectedSalaryEntity.getPrevRankLevel() == null ? "" : selectedSalaryEntity.getPrevRankLevel());
			map.put("prs", selectedSalaryEntity.getPrevRankSalary() == null ? "" : selectedSalaryEntity.getPrevRankSalary().toString());
			map.put("pe", selectedSalaryEntity.getPrevExtraSalary() == null ? "" : selectedSalaryEntity.getPrevExtraSalary().toString());
			
			map.put("nj", selectedSalaryEntity.getNewJob() == null ? "" : selectedSalaryEntity.getNewJob());
			map.put("newJobDate", "");
			map.put("nl", selectedSalaryEntity.getNewJobLevel() == null ? "" : selectedSalaryEntity.getNewJobLevel());
			map.put("ns", selectedSalaryEntity.getNewJobSalary() == null ? "" : selectedSalaryEntity.getNewJobSalary());
			map.put("nr", selectedSalaryEntity.getNewRankLevel() == null ? "" : selectedSalaryEntity.getNewRankLevel());
			map.put("nrs", selectedSalaryEntity.getNewRankSalary() == null ? "" : selectedSalaryEntity.getNewRankSalary().toString());
			map.put("ne", selectedSalaryEntity.getNewExtraSalary() == null ? "" : selectedSalaryEntity.getNewExtraSalary());
			map.put("date", DateService.GetToday());
			map.put("comment", "");
		}else{
			map.put("pj", "");
			map.put("prevJobDate", "");
			map.put("pl", "");
			map.put("ps", "");
			map.put("pr", "");
			map.put("prs", "");
			map.put("pe", "");
			
			map.put("nj", "");
			map.put("newJobDate", "");
			map.put("nl", "");
			map.put("ns", "");
			map.put("nr", "");
			map.put("nrs", "");
			map.put("ne", "");
			map.put("date", DateService.GetToday());
			map.put("comment", "");
		}
		
		return map;
	}
	
	public Map<String, Object> GetJobChangeAndSalaryChangeAudit(ZformPersonEntity zformPerson, ZformPersonActiveEntity activeEntity, List<ZformPersonSalaryEntity> salaryList){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("name", zformPerson.getName() == null ? "" : zformPerson.getName());
		map.put("birth", zformPerson.getBirthday() == null ? "": zformPerson.getBirthday());
		map.put("startWorkDate", zformPerson.getStartWorkDate() == null ? "" : zformPerson.getStartWorkDate());
		map.put("wage", activeEntity.getTotalSeniority() == null ? "" : activeEntity.getTotalSeniority());
		map.put("edu", zformPerson.getEduBackground() == null ? "" : zformPerson.getEduBackground());
		map.put("grd", zformPerson.getGraduateDate() == null ? "" : zformPerson.getGraduateDate());
		
		ZformPersonSalaryEntity selectedSalaryEntity = null;
		for(ZformPersonSalaryEntity salaryEntity : salaryList){
			if (salaryEntity == null)
				continue;
			if (salaryEntity.getExtra1() != null && salaryEntity.getExtra1().equals("1")
			 && salaryEntity.getExtra2() != null && salaryEntity.getExtra2().equals(Common.Salary_Change_For_Job_Extra)){
				selectedSalaryEntity = salaryEntity;
			}
		}
		
		if (selectedSalaryEntity != null)
		{
			map.put("pj", selectedSalaryEntity.getPrevJob() == null ? "" : selectedSalaryEntity.getPrevJob());
			map.put("prevJobDate", "");
			map.put("pl", selectedSalaryEntity.getPrevJobLevel() == null ? "" : selectedSalaryEntity.getPrevJobLevel());
			map.put("ps", selectedSalaryEntity.getPrevJobSalary() == null ? "" : selectedSalaryEntity.getPrevJobSalary().toString());
			map.put("pr", selectedSalaryEntity.getPrevRankLevel() == null ? "" : selectedSalaryEntity.getPrevRankLevel());
			map.put("prs", selectedSalaryEntity.getPrevRankSalary() == null ? "" : selectedSalaryEntity.getPrevRankSalary().toString());
			map.put("pe", selectedSalaryEntity.getPrevExtraSalary() == null ? "" : selectedSalaryEntity.getPrevExtraSalary().toString());
			
			map.put("nj", selectedSalaryEntity.getNewJob() == null ? "" : selectedSalaryEntity.getNewJob());
			map.put("newJobDate", "");
			map.put("nl", selectedSalaryEntity.getNewJobLevel() == null ? "" : selectedSalaryEntity.getNewJobLevel());
			map.put("ns", selectedSalaryEntity.getNewJobSalary() == null ? "" : selectedSalaryEntity.getNewJobSalary());
			map.put("nr", selectedSalaryEntity.getNewRankLevel() == null ? "" : selectedSalaryEntity.getNewRankLevel());
			map.put("nrs", selectedSalaryEntity.getNewRankSalary() == null ? "" : selectedSalaryEntity.getNewRankSalary().toString());
			map.put("ne", selectedSalaryEntity.getNewExtraSalary() == null ? "" : selectedSalaryEntity.getNewExtraSalary());
			map.put("date", DateService.GetToday());
			
			String comment = "";
			Date effectiveDate = selectedSalaryEntity.getEffectiveDate();
			if (effectiveDate != null){
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(effectiveDate);
				
				String effectveYear  = String.valueOf(calendar.get(Calendar.YEAR)).toString();
				String effectiveMonth = String.valueOf(calendar.get(Calendar.MONTH + 1)).toString();
				
				calendar.add(Calendar.MONTH, -1);
				
				String changeYear = String.valueOf(calendar.get(Calendar.YEAR));
				String changeMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1).toString();
				
				
				comment = changeYear + "年" + changeMonth + "月" + "聘用岗位发生变动，自" + effectveYear + "年"  + effectiveMonth + "月起执行新的岗位工资"; 
				
			}
				
			map.put("date", DateService.GetToday());
			map.put("comment", comment);
			
		}else{
			map.put("pj", "");
			map.put("prevJobDate", "");
			map.put("pl", "");
			map.put("ps", "");
			map.put("pr", "");
			map.put("prs", "");
			map.put("pe", "");
			
			map.put("nj", "");
			map.put("newJobDate", "");
			map.put("nl", "");
			map.put("ns", "");
			map.put("nr", "");
			map.put("nrs", "");
			map.put("ne", "");
			map.put("date", DateService.GetToday());
			map.put("comment", "");
		}
		
		return map;
	}
	
	public Map<String, Object> GetTitleChangeAndSalaryChangeAudit(ZformPersonEntity zformPerson, ZformPersonActiveEntity activeEntity, List<ZformPersonSalaryEntity> salaryList){
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("name", zformPerson.getName() == null ? "" : zformPerson.getName());
		map.put("birth", zformPerson.getBirthday() == null ? "": zformPerson.getBirthday());
		map.put("startWorkDate", zformPerson.getStartWorkDate() == null ? "" : zformPerson.getStartWorkDate());
		map.put("wage", activeEntity.getTotalSeniority() == null ? "" : activeEntity.getTotalSeniority());
		map.put("edu", zformPerson.getEduBackground() == null ? "" : zformPerson.getEduBackground());
		map.put("grd", zformPerson.getGraduateDate() == null ? "" : zformPerson.getGraduateDate());
		
		ZformPersonSalaryEntity selectedSalaryEntity = null;
		for(ZformPersonSalaryEntity salaryEntity : salaryList){
			if (salaryEntity == null)
				continue;
			if (salaryEntity.getExtra1() != null && salaryEntity.getExtra1().equals("1")
			 && salaryEntity.getExtra2() != null && salaryEntity.getExtra2().equals(Common.Salary_Change_For_Title_Extra)){
				selectedSalaryEntity = salaryEntity;
			}
		}
		
		if (selectedSalaryEntity != null)
		{
			map.put("pj", selectedSalaryEntity.getPrevJob() == null ? "" : selectedSalaryEntity.getPrevJob());
			map.put("prevJobDate", "");
			map.put("pl", selectedSalaryEntity.getPrevJobLevel() == null ? "" : selectedSalaryEntity.getPrevJobLevel());
			map.put("ps", selectedSalaryEntity.getPrevJobSalary() == null ? "" : selectedSalaryEntity.getPrevJobSalary().toString());
			map.put("pr", selectedSalaryEntity.getPrevRankLevel() == null ? "" : selectedSalaryEntity.getPrevRankLevel());
			map.put("prs", selectedSalaryEntity.getPrevRankSalary() == null ? "" : selectedSalaryEntity.getPrevRankSalary().toString());
			map.put("pe", selectedSalaryEntity.getPrevExtraSalary() == null ? "" : selectedSalaryEntity.getPrevExtraSalary().toString());
			
			map.put("nj", selectedSalaryEntity.getNewJob() == null ? "" : selectedSalaryEntity.getNewJob());
			map.put("newJobDate", "");
			map.put("nl", selectedSalaryEntity.getNewJobLevel() == null ? "" : selectedSalaryEntity.getNewJobLevel());
			map.put("ns", selectedSalaryEntity.getNewJobSalary() == null ? "" : selectedSalaryEntity.getNewJobSalary());
			map.put("nr", selectedSalaryEntity.getNewRankLevel() == null ? "" : selectedSalaryEntity.getNewRankLevel());
			map.put("nrs", selectedSalaryEntity.getNewRankSalary() == null ? "" : selectedSalaryEntity.getNewRankSalary().toString());
			map.put("ne", selectedSalaryEntity.getNewExtraSalary() == null ? "" : selectedSalaryEntity.getNewExtraSalary());
			map.put("date", DateService.GetToday());
			
			String comment = "";
			Date effectiveDate = selectedSalaryEntity.getEffectiveDate();
			if (effectiveDate != null){
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(effectiveDate);
				
				String effectveYear  = String.valueOf(calendar.get(Calendar.YEAR)).toString();
				String effectiveMonth = String.valueOf(calendar.get(Calendar.MONTH + 1)).toString();
				
				calendar.add(Calendar.MONTH, -1);
				
				String changeYear = String.valueOf(calendar.get(Calendar.YEAR));
				String changeMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1).toString();
				
				
				comment = changeYear + "年" + changeMonth + "月" + "职务发生变动，自" + effectveYear + "年"  + effectiveMonth + "月起执行新的岗位工资"; 
				
			}
				
			map.put("date", DateService.GetToday());
			map.put("comment", comment);
			
		}else{
			map.put("pj", "");
			map.put("prevJobDate", "");
			map.put("pl", "");
			map.put("ps", "");
			map.put("pr", "");
			map.put("prs", "");
			map.put("pe", "");
			
			map.put("nj", "");
			map.put("newJobDate", "");
			map.put("nl", "");
			map.put("ns", "");
			map.put("nr", "");
			map.put("nrs", "");
			map.put("ne", "");
			map.put("date", DateService.GetToday());
			map.put("comment", "");
		}
		
		return map;
	}

	public Map<String, Object> GetHardcoreExamSummary(
			PersonService personService, SystemService systemService) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		//return map;
		
		//String hql1 = "from ZformPersonActiveEntity where 1 = 1 AND hardCore = ?";
		//List<ZformPersonActiveEntity> personActiveEntityList1 = systemService.findHql(hql1, "通州区骨干教师");
		
		//if (personActiveEntityList1 != null)
		//	map.put("teacherList1", personActiveEntityList1);
		
		//String hql2 = "from ZformPersonActiveEntity where 1 = 1 AND hardCore = ?";
		//List<ZformPersonActiveEntity> personActiveEntityList2 = systemService.findHql(hql2, "通州区青年骨干教师");
		
		//if (personActiveEntityList2 != null)
		//	map.put("teacherList2", personActiveEntityList2);
		
		String hql3 = "from ZformSchoolEntity where 1 = 1";
		List<ZformSchoolEntity> schoolList = systemService.findHql(hql3);
		
		List<SchoolExportEntity> schoolExportList = new ArrayList<SchoolExportEntity>();
		
		if (schoolList != null){
			
			for(ZformSchoolEntity school : schoolList){
				if (school != null){
					SchoolExportEntity schoolEntity = new SchoolExportEntity();
					schoolEntity.setCode(school.getCode() == null ? "" : school.getCode());
					schoolEntity.setName(school.getName() == null ? "" : school.getName());
					schoolExportList.add(schoolEntity);
				}
			}
			
		}
		map.put("schoolList", schoolExportList);
		
		return map;
	}
	
	public Map<String, Object> GetExamSummary(
			PersonService personService, SystemService systemService) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		//return map;
		
		//String hql1 = "from ZformPersonActiveEntity where 1 = 1 AND hardCore = ?";
		//List<ZformPersonActiveEntity> personActiveEntityList1 = systemService.findHql(hql1, "通州区骨干教师");
		
		//if (personActiveEntityList1 != null)
		//	map.put("teacherList1", personActiveEntityList1);
		
		//String hql2 = "from ZformPersonActiveEntity where 1 = 1 AND hardCore = ?";
		//List<ZformPersonActiveEntity> personActiveEntityList2 = systemService.findHql(hql2, "通州区青年骨干教师");
		
		//if (personActiveEntityList2 != null)
		//	map.put("teacherList2", personActiveEntityList2);
		
		String hql3 = "from ZformSchoolEntity where 1 = 1";
		List<ZformSchoolEntity> schoolList = systemService.findHql(hql3);
		
		List<SchoolExportEntity> schoolExportList = new ArrayList<SchoolExportEntity>();
		
		if (schoolList != null){
			
			for(ZformSchoolEntity school : schoolList){
				if (school != null){
					SchoolExportEntity schoolEntity = new SchoolExportEntity();
					schoolEntity.setCode(school.getCode() == null ? "" : school.getCode());
					schoolEntity.setName(school.getName() == null ? "" : school.getName());
					schoolExportList.add(schoolEntity);
				}
			}
			
		}
		map.put("schoolList", schoolExportList);
		
		return map;
	}
	
}
