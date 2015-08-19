package com.buss.common;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;

import com.buss.active.entity.ZformPersonActiveEntity;
import com.buss.death.entity.ZformPersonDeathEntity;
import com.buss.exam.entity.ZformPersonExamEntity;
import com.buss.job.entity.ZformPersonJobEntity;
import com.buss.person.entity.ZformPersonEntity;
import com.buss.salary.entity.ZformJobSalaryEntity;
import com.buss.salary.entity.ZformPersonSalaryEntity;
import com.buss.salary.entity.ZformRankSalaryEntity;
import com.buss.school.entity.ZformSchoolEntity;
import com.buss.title.entity.ZformPersonTitleEntity;
import com.buss.transferinternal.entity.ZformPersonTransferInnerEntity;

public class PersonService {

	public ZformPersonDeathEntity GetPersonDeathEntityByCode(SystemService systemService, String code) {
		// TODO Auto-generated method stub
		if (systemService == null || StringUtil.isEmpty(code))
			return null;
		
		String hql1 = "from ZformPersonDeathEntity where 1 = 1 AND code = ?";
		List<ZformPersonDeathEntity> zformPersonDeathEntityList = systemService.findHql(hql1, code);
		
		if (zformPersonDeathEntityList == null || zformPersonDeathEntityList.size() < 1)
			return new ZformPersonDeathEntity();
		
		return zformPersonDeathEntityList.get(0);
	}
	
	public ZformPersonEntity getPersonByActivityID(SystemService systemService, String id){
		if (systemService == null || id == null)
			return new ZformPersonEntity();
		
		String hql1 = "from ZformPersonActiveEntity where 1 = 1 AND id = ?";
		List<ZformPersonActiveEntity> zformPersonActiveEntityList = systemService.findHql(hql1, id);

		if (zformPersonActiveEntityList == null || zformPersonActiveEntityList.size() < 1) {
			return new ZformPersonEntity();
		}
		String code = zformPersonActiveEntityList.get(0).getCode();
		
		if (code == null || code == "")
			return new ZformPersonEntity();
		
		String hql2 = "from ZformPersonEntity where 1 = 1 AND code = ?";
		
		List<ZformPersonEntity> zformPersonEntityList = systemService.findHql(hql2, code);
		
		if (zformPersonEntityList == null || zformPersonEntityList.size() < 1) {
			return new ZformPersonEntity();
		}
		
		return zformPersonEntityList.get(0);
	}
	
	public List<ZformPersonTransferInnerEntity> getPersonTransferInnerListByCode(SystemService systemService, String code){
		if (systemService == null || StringUtil.isEmpty(code))
			return null;
		
		String hql1 = "from ZformPersonTransferInnerEntity where 1 = 1 AND code = ?";
		List<ZformPersonTransferInnerEntity> result = systemService.findHql(hql1, code);
		return result;
	}
	
	public List<ZformPersonExamEntity> getPersonExamEntityListByCode(SystemService systemService, String code){
		if (systemService == null || StringUtil.isEmpty(code))
			return null;
		
		String hql1 = "from ZformPersonExamEntity where 1 = 1 AND code = ?";
		List<ZformPersonExamEntity> result = systemService.findHql(hql1, code);
		return result;
	}
	
	public List<ZformPersonJobEntity> getPersonJobEntityListByCode(SystemService systemService, String code){
		if (systemService == null || StringUtil.isEmpty(code))
			return null;
		
		String hql1 = "from ZformPersonJobEntity where 1 = 1 AND code = ?";
		List<ZformPersonJobEntity> result = systemService.findHql(hql1, code);
		return result;
	}
	
	public List<ZformPersonSalaryEntity> getPersonSalaryEntityListByCode(SystemService systemService, String code){
		if (systemService == null || StringUtil.isEmpty(code))
			return null;
		
		String hql1 = "from ZformPersonSalaryEntity where 1 = 1 AND code = ?";
		List<ZformPersonSalaryEntity> result = systemService.findHql(hql1, code);
		return result;
	}
	
	public ZformPersonActiveEntity getPersonActiveByCode( SystemService systemService, String code) throws Exception {
		
		if (systemService == null || code == null)
			throw new Exception("获取在职人员信息出错");
		
		String hql1 = "from ZformPersonActiveEntity where 1 = 1 AND code = ?";
		List<ZformPersonActiveEntity> zformPersonActiveEntityList = systemService.findHql(hql1, code);

		if (zformPersonActiveEntityList == null || zformPersonActiveEntityList.size() < 1) {
			throw new Exception("获取在职人员信息出错");
		}
		return zformPersonActiveEntityList.get(0);
	}
	
	public ZformPersonEntity getPersonEntityByCode(SystemService systemService, String code){
		if (systemService == null || StringUtil.isEmpty(code))
			return null;
		
		String hql1 = "from ZformPersonEntity where 1 = 1 AND code = ?";
		List<ZformPersonEntity> zformPersonEntityList = systemService.findHql(hql1, code);
		
		if (zformPersonEntityList == null || zformPersonEntityList.size() < 1)
			return null;
		
		return zformPersonEntityList.get(0);
	}

	public ZformPersonTransferInnerEntity getPersonTransferInner(
			SystemService systemService, String code) throws Exception {
		String hql0 = "from ZformPersonTransferInnerEntity where 1 = 1 AND code = ? AND transferStatus = ?";
		List<ZformPersonTransferInnerEntity> zformPersonTransferInnerEntityList = systemService
				.findHql(hql0, code,
						Common.transfer_inner_status_wait_for_accept);

		if (zformPersonTransferInnerEntityList == null
				|| zformPersonTransferInnerEntityList.size() < 1) {
			throw new Exception("获取在职人员信息出错");
		}

		return zformPersonTransferInnerEntityList.get(0);
	}

	// 根据用户输入的year(学年)，jobLevel(岗位等级), jobType(岗位类型)返回对应的岗位工资
	public Double getJobSalary(String schoolYear, String jobLevel,
			String jobType, SystemService systemService) {
		
		if (jobLevel == null || jobType == null)
			return 0.0;

		String selectedJobType = jobType;

		if (selectedJobType.equalsIgnoreCase("双肩挑")) {
			selectedJobType = "专业技术岗位";
		}

		String hql1 = "from ZformJobSalaryEntity where 1 = 1 AND jobLevel = ? AND jobType = ? order by year desc";

		List<ZformJobSalaryEntity> zformJobSalaryEntityList = systemService
				.findHql(hql1, jobLevel, selectedJobType);

		if (zformJobSalaryEntityList == null
				|| zformJobSalaryEntityList.size() < 1)
			return 0.0;

		for (ZformJobSalaryEntity jobSalaryEntity : zformJobSalaryEntityList) {
			if (jobSalaryEntity.getYear().toString() == schoolYear) {
				return jobSalaryEntity.getSalary();
			}
		}

		// 如果没有在对应学年找到岗位工资，则返回最近学年的岗位工资
		return zformJobSalaryEntityList.get(0).getSalary();
	}

	// 根据用户输入的year(学年)，rank(薪级), jobType(岗位类型)返回对应的薪级工资
	public Double getRankSalary(String schoolYear, String rank, String jobType,
			SystemService systemService) {
		
		if (rank == null || jobType == null)
			return 0.0;

		String selectedJobType = jobType;

		if (selectedJobType != null && selectedJobType.equalsIgnoreCase("双肩挑")) {
			selectedJobType = "专业技术岗位";
		}

		String hql1 = "from ZformRankSalaryEntity where 1 = 1 AND rank = ? AND jobtype = ? order by year desc";
		List<ZformRankSalaryEntity> zformRankSalaryEntityList = systemService
				.findHql(hql1, rank, selectedJobType);

		if (zformRankSalaryEntityList == null
				|| zformRankSalaryEntityList.size() < 1)
			return 0.0;

		for (ZformRankSalaryEntity rankSalaryEntity : zformRankSalaryEntityList) {
			if (rankSalaryEntity.getYear().toString() == schoolYear) {
				return rankSalaryEntity.getSalary();
			}
		}

		// 如果没有在对应学年找到薪级工资，则返回最近学年的薪级工资
		return zformRankSalaryEntityList.get(0).getSalary();
	}

	public ZformPersonTransferInnerEntity getPersonTransferInner(
			ZformPersonEntity t, ZformPersonActiveEntity personActiveEntity,
			HttpServletRequest request) throws ParseException {
		ZformPersonTransferInnerEntity transferInnerEntity = new ZformPersonTransferInnerEntity();

		transferInnerEntity.setId(UUID.randomUUID().toString());
		transferInnerEntity.setCode(t.getCode());
		transferInnerEntity.setFromSchool(personActiveEntity.getSchoolCode());
		transferInnerEntity.setToSchool(request.getParameter("toSchool"));
		transferInnerEntity.setTransferReason(request
				.getParameter("transferReason"));

		String salaryEndDate = request.getParameter("salaryEndDate");
		if (StringUtil.isNotEmpty(salaryEndDate)) {
			transferInnerEntity.setSalaryEndDate(new SimpleDateFormat(
					"yyyy-MM-dd").parse(salaryEndDate));
		}

		transferInnerEntity.setNominate(request.getParameter("nominate"));
		transferInnerEntity.setTransferTitle(request
				.getParameter("beforeTitle"));
		transferInnerEntity.setComments(request.getParameter("comments"));
		transferInnerEntity
				.setTransferStatus(Common.transfer_inner_status_wait_for_accept);

		return transferInnerEntity;
	}

	// 工资变动，添加一条新的工资信息
	public ZformPersonSalaryEntity getPersonNewSalary(ZformPersonEntity t,
			ZformPersonActiveEntity personActiveEntity,
			HttpServletRequest request, SystemService systemService)
			throws Exception {
		
		if (t == null || personActiveEntity == null || request == null || systemService == null)
			return null;
		
		ZformPersonSalaryEntity personSalaryEntity = new ZformPersonSalaryEntity();
		
		personSalaryEntity.setId(UUID.randomUUID().toString());
		personSalaryEntity.setCode(t.getCode());

		String year = request.getParameter("year");
		if (StringUtil.isNotEmpty(year)) {
			personSalaryEntity.setYear(year);
		} else {
			personSalaryEntity.setYear(String.valueOf(DateService
					.GetCurrentSchoolYear()));
		}

		personSalaryEntity.setChangeReason(request.getParameter("changeReason"));

		personSalaryEntity.setPrevJob(personActiveEntity.getCurrentJob());
		personSalaryEntity.setPrevJobLevel(personActiveEntity.getCurrentJobLevel());
		personSalaryEntity.setPrevJobType(personActiveEntity.getCurrentJobType());
		personSalaryEntity.setPrevRankLevel(personActiveEntity.getRank());
		

		personSalaryEntity.setNewJob(request.getParameter("newJob"));
		personSalaryEntity.setNewJobType(request.getParameter("newJobType"));
		personSalaryEntity.setNewJobLevel(request.getParameter("newJobLevel"));
		personSalaryEntity.setNewRankLevel(request.getParameter("newRankLevel"));
		personSalaryEntity.setComments(request.getParameter("comments"));

		String effectiveDate = request.getParameter("effectiveDate");
		if (StringUtil.isNotEmpty(effectiveDate))
			personSalaryEntity.setEffectiveDate(DateService
					.GetDate(effectiveDate));
		else {
			// 如果没有设置工资变动生效日期，则默认从次月1日生效
			personSalaryEntity.setEffectiveDate(DateService
					.GetNextMonthFirstDay());
		}

		// 根据当前人员的工作岗位查询当前的岗位工资
		String prevJobSalary = personActiveEntity.getJobSalary();
		if (StringUtil.isNotEmpty(prevJobSalary))
			personSalaryEntity.setPrevJobSalary(Double
					.parseDouble(prevJobSalary));
		else {
			personSalaryEntity.setPrevJobSalary(getJobSalary(
					String.valueOf(DateService.GetCurrentSchoolYear())
							.toString(), personSalaryEntity.getPrevJobLevel(),
					personSalaryEntity.getPrevJobType(), systemService));
		}

		String rankSalary = personActiveEntity.getRankSalary();
		if (StringUtil.isNotEmpty(rankSalary))
			personSalaryEntity
					.setPrevRankSalary(Double.parseDouble(rankSalary));
		else {
			personSalaryEntity.setPrevRankSalary(getRankSalary(
					String.valueOf(DateService.GetCurrentSchoolYear())
							.toString(), personSalaryEntity.getPrevRankLevel(),
					personSalaryEntity.getPrevJobType(), systemService));
		}

		Double newJobSalary = getJobSalary(personSalaryEntity.getYear(),
				personSalaryEntity.getNewJobLevel(),
				personSalaryEntity.getNewJobType(), systemService);
		personSalaryEntity.setNewJobSalary(newJobSalary);

		Double newRankSalary = getRankSalary(personSalaryEntity.getYear(),
				personSalaryEntity.getNewRankLevel(),
				personSalaryEntity.getNewJobType(), systemService);
		personSalaryEntity.setNewRankSalary(newRankSalary);
		
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		
		if (StringUtil.isNotEmpty(personActiveEntity.getExtraSalary()))
			personSalaryEntity.setPrevExtraSalary(Double.parseDouble(personActiveEntity.getExtraSalary()));
		else
			personSalaryEntity.setPrevExtraSalary(0.0);
		
		Double newExtraSalary = Double.parseDouble(decimalFormat.format((newJobSalary + newRankSalary) * 0.1));
		personSalaryEntity.setNewExtraSalary(newExtraSalary);
				
		personSalaryEntity.setExtra1("1");
		personSalaryEntity.setExtra2(Common.Salary_Change_For_Customize_Extra);

		return personSalaryEntity;
	}

	// 岗位聘用，次月调整岗位工资。
	public ZformPersonJobEntity getPersonNewJob(ZformPersonEntity personEntity,
			ZformPersonActiveEntity activePersonEntity,
			HttpServletRequest request, SystemService systemService)
			throws Exception {

		if (personEntity == null || activePersonEntity == null
				|| request == null || systemService == null)
			return null;

		ZformPersonJobEntity jobEntity = new ZformPersonJobEntity();

		jobEntity.setId(UUID.randomUUID().toString());
		jobEntity.setCode(personEntity.getCode());
		String year = request.getParameter("year");
		if (StringUtil.isNotEmpty(year)) {
			jobEntity.setYear(Integer.parseInt(year));
		} else {
			jobEntity.setYear(DateService.GetCurrentSchoolYear());
		}

		jobEntity.setPrevTitle(activePersonEntity.getCurrentTitle());
		jobEntity.setPrevTitleExtra(activePersonEntity.getCurrentTitleExtra());
		jobEntity.setPrevJob(activePersonEntity.getCurrentJob());
		jobEntity.setPrevJobExtra(activePersonEntity.getCurrentJobExtra());
		jobEntity.setPrevJobLevel(activePersonEntity.getCurrentJobLevel());
		jobEntity.setPrevJobType(activePersonEntity.getCurrentJobType());

		String prevJobSalary = activePersonEntity.getJobSalary();
		if (StringUtil.isNotEmpty(prevJobSalary))
			jobEntity.setPrevJobSalary(Double.parseDouble(activePersonEntity.getJobSalary()));
		else {
			jobEntity.setPrevJobSalary(getJobSalary(year,jobEntity.getPrevJobLevel(), jobEntity.getPrevJobType(),systemService));
		}
		
		

		jobEntity.setPrevWorkAge(request.getParameter("prevWorkAge"));

		String titleWorkDate = request.getParameter("titleWorkDate");
		if (StringUtil.isNotEmpty(titleWorkDate))
			jobEntity.setPrevTitleWorkDate(DateService.GetDate(titleWorkDate));
		

		jobEntity.setNewTitle(request.getParameter("newTitle"));
		jobEntity.setNewTitleExtra(request.getParameter("newTitleExtra"));
		jobEntity.setNewJob(request.getParameter("newJob"));
		jobEntity.setNewJobExtra(request.getParameter("newJobExtra"));
		jobEntity.setNewJobLevel(request.getParameter("newJobLevel"));
		jobEntity.setNewJobType(request.getParameter("newJobType"));

		jobEntity.setNewJobSalary(getJobSalary(
				String.valueOf(DateService.GetCurrentSchoolYear()).toString(),
				jobEntity.getNewJobLevel(), jobEntity.getNewJobType(),
				systemService));

		String newJobStartDate = request.getParameter("newJobStartDate");
		if (StringUtil.isNotEmpty(newJobStartDate))
			jobEntity.setNewJobStartDate(DateService.GetDate(newJobStartDate));

		String newJobEndDate = request.getParameter("newJobEndDate");
		if (StringUtil.isNotEmpty(newJobEndDate))
			jobEntity.setNewJobEndDate(DateService.GetDate(newJobEndDate));

		jobEntity.setJobChangeReason(request.getParameter("jobChangeReason"));
		jobEntity.setComments(request.getParameter("comments"));

		return jobEntity;
	}
	
	//因为岗位聘用变更，增加一条工资调整信息。
	public ZformPersonSalaryEntity getPersonSalaryForJobChange(
			ZformPersonEntity t, ZformPersonActiveEntity personActiveEntity,
			ZformPersonJobEntity personJobEntity, SystemService systemService)
			throws Exception {

		if (t == null || personActiveEntity == null || personJobEntity == null)
			return null;

		ZformPersonSalaryEntity zformPersonSalaryEntity = new ZformPersonSalaryEntity();

		zformPersonSalaryEntity.setId(UUID.randomUUID().toString());
		zformPersonSalaryEntity.setCode(t.getCode());
		Integer year = personJobEntity.getYear();
		if (year == null)
			zformPersonSalaryEntity.setYear(String.valueOf(DateService.GetCurrentSchoolYear()).toString());
		else
			zformPersonSalaryEntity.setYear(year.toString());

		zformPersonSalaryEntity.setChangeReason(Common.Salary_Change_For_Job);
		
		//岗位聘用变更导致的薪资调整，要到下个月1日开始。
		zformPersonSalaryEntity.setEffectiveDate(DateService.GetNextMonthFirstDay());
		zformPersonSalaryEntity.setPrevJob(personJobEntity.getPrevJob());
		zformPersonSalaryEntity.setPrevJobLevel(personJobEntity.getPrevJobLevel());
		zformPersonSalaryEntity.setPrevJobType(personJobEntity.getPrevJobType());
		zformPersonSalaryEntity.setPrevJobSalary(personJobEntity.getPrevJobSalary());
		zformPersonSalaryEntity.setPrevRankLevel(personActiveEntity.getRank());
		if (StringUtil.isNotEmpty(personActiveEntity.getRankSalary()))
			zformPersonSalaryEntity.setPrevRankSalary(Double.parseDouble(personActiveEntity.getRankSalary()));
		else
			zformPersonSalaryEntity.setPrevRankSalary(0.0);
		
		if (StringUtil.isNotEmpty(personActiveEntity.getExtraSalary()))
			zformPersonSalaryEntity.setPrevExtraSalary(Double.parseDouble(personActiveEntity.getExtraSalary()));
		else
			zformPersonSalaryEntity.setPrevExtraSalary(0.0);
		
		zformPersonSalaryEntity.setNewJob(personJobEntity.getNewJob());
		zformPersonSalaryEntity.setNewJobLevel(personJobEntity.getNewJobLevel());
		zformPersonSalaryEntity.setNewJobType(personJobEntity.getNewJobType());
		zformPersonSalaryEntity.setNewJobSalary(personJobEntity.getNewJobSalary());
		
		
		zformPersonSalaryEntity.setNewRankLevel(zformPersonSalaryEntity.getPrevRankLevel());		
		zformPersonSalaryEntity.setNewRankSalary(zformPersonSalaryEntity.getPrevRankSalary());		
		
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		
		Double newExtraSalary = Double.parseDouble(decimalFormat.format((zformPersonSalaryEntity.getNewJobSalary() + zformPersonSalaryEntity.getNewRankSalary()) * 0.1));
		
		zformPersonSalaryEntity.setNewExtraSalary(newExtraSalary);
		
		zformPersonSalaryEntity.setExtra1("1");
		zformPersonSalaryEntity.setExtra2(Common.Salary_Change_For_Job_Extra);
		
		return zformPersonSalaryEntity;

	}

	// 职务调整，次月调整岗位工资。
	public ZformPersonTitleEntity getPersonNewTitle(
			ZformPersonEntity personEntity,
			ZformPersonActiveEntity activePersonEntity,
			HttpServletRequest request, SystemService systemService)
			throws Exception {

		if (personEntity == null || activePersonEntity == null || request == null || systemService == null)
			return null;

		ZformPersonTitleEntity titleEntity = new ZformPersonTitleEntity();

		titleEntity.setId(UUID.randomUUID().toString());
		titleEntity.setCode(personEntity.getCode());

		titleEntity.setPrevTitle(activePersonEntity.getCurrentTitle());
		titleEntity.setPrevTitleExtra(activePersonEntity.getCurrentTitleExtra());
		titleEntity.setPrevJob(activePersonEntity.getCurrentJob());
		titleEntity.setPrevJobExtra(activePersonEntity.getCurrentJobExtra());
		titleEntity.setPrevJobLevel(activePersonEntity.getCurrentJobLevel());
		titleEntity.setPrevJobType(activePersonEntity.getCurrentJobType());

		titleEntity.setNewTitle(request.getParameter("newTitle"));
		titleEntity.setNewTitleExtra(request.getParameter("newTitleExtra"));
		titleEntity.setNewJob(request.getParameter("newJob"));
		titleEntity.setNewJobExtra(request.getParameter("newJobExtra"));
		titleEntity.setNewJobLevel(request.getParameter("newJobLevel"));
		titleEntity.setNewJobType(request.getParameter("newJobType"));

		titleEntity.setChangeReason(request.getParameter("changeReason"));
		titleEntity.setComments(request.getParameter("comments"));
		// 用title表里面的extra1字段存储学年
		titleEntity.setExtra1(request.getParameter("year"));

		titleEntity.setEffectiveDate(DateService.GetNextMonthFirstDay());

		return titleEntity;
	}

	// 因为职务变更带来的工资改变，生成一条新的工资变动信息。
	public ZformPersonSalaryEntity getPersonSalaryForTitleChange(
			ZformPersonEntity t, ZformPersonActiveEntity personActiveEntity,
			ZformPersonTitleEntity personTitleEntity,
			SystemService systemService) throws Exception {

		if (t == null || personActiveEntity == null || personTitleEntity == null)
			return null;

		ZformPersonSalaryEntity zformPersonSalaryEntity = new ZformPersonSalaryEntity();

		zformPersonSalaryEntity.setId(UUID.randomUUID().toString());
		zformPersonSalaryEntity.setCode(t.getCode());
		zformPersonSalaryEntity.setChangeReason(Common.Salary_Change_For_Title);
		zformPersonSalaryEntity.setEffectiveDate(DateService.GetNextMonthFirstDay());
		
		zformPersonSalaryEntity.setPrevJob(personTitleEntity.getPrevJob());
		zformPersonSalaryEntity.setPrevJobLevel(personTitleEntity.getPrevJobLevel());
		zformPersonSalaryEntity.setPrevJobType(personTitleEntity.getPrevJobType());	

		//参考的学年从title表extra1中获得。
		String year = personTitleEntity.getExtra1();

		if (StringUtil.isNotEmpty(year)) {
			zformPersonSalaryEntity.setYear(year);
		} else {
			zformPersonSalaryEntity.setYear(String.valueOf(DateService.GetCurrentSchoolYear()).toString());
		}

		Double prevJobSalary = 0.0;

		if (StringUtil.isNotEmpty(personActiveEntity.getJobSalary())) {
			prevJobSalary = Double.parseDouble(personActiveEntity
					.getJobSalary());
		} else {
			prevJobSalary = getJobSalary(
					String.valueOf(DateService.GetCurrentSchoolYear())
							.toString(), personTitleEntity.getPrevJobLevel(),
					personTitleEntity.getPrevJobType(), systemService);
		}		
		
		zformPersonSalaryEntity.setPrevJobSalary(prevJobSalary);
		zformPersonSalaryEntity.setPrevRankLevel(personActiveEntity.getRank());
		if (StringUtil.isNotEmpty(personActiveEntity.getRankSalary()))
			zformPersonSalaryEntity.setPrevRankSalary(Double.parseDouble(personActiveEntity.getRankSalary()));
		else
			zformPersonSalaryEntity.setPrevRankSalary(0.0);
		
		if (StringUtil.isNotEmpty(personActiveEntity.getExtraSalary()))
			zformPersonSalaryEntity.setPrevExtraSalary(Double.parseDouble(personActiveEntity.getExtraSalary()));
		else
			zformPersonSalaryEntity.setPrevExtraSalary(0.0);
		
		
		
		zformPersonSalaryEntity.setNewJob(personTitleEntity.getNewJob());
		zformPersonSalaryEntity.setNewJobLevel(personTitleEntity
				.getNewJobLevel());
		zformPersonSalaryEntity
				.setNewJobType(personTitleEntity.getNewJobType());

		Double newJobSalary = 0.0;

		newJobSalary = getJobSalary(
				String.valueOf(DateService.GetCurrentSchoolYear()).toString(),
				personTitleEntity.getNewJobLevel(),
				personTitleEntity.getNewJobType(), systemService);	

		zformPersonSalaryEntity.setNewJobSalary(newJobSalary);
		
		zformPersonSalaryEntity.setNewRankLevel(zformPersonSalaryEntity.getPrevRankLevel());		
		zformPersonSalaryEntity.setNewRankSalary(zformPersonSalaryEntity.getPrevRankSalary());		
		
		zformPersonSalaryEntity.setNewRankLevel(zformPersonSalaryEntity.getPrevRankLevel());		
		zformPersonSalaryEntity.setNewRankSalary(zformPersonSalaryEntity.getPrevRankSalary());		
		
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		
		Double newExtraSalary = Double.parseDouble(decimalFormat.format((zformPersonSalaryEntity.getNewJobSalary() + zformPersonSalaryEntity.getNewRankSalary()) * 0.1));
		
		zformPersonSalaryEntity.setNewExtraSalary(newExtraSalary);
					
		zformPersonSalaryEntity.setExtra1("1");
		
		zformPersonSalaryEntity.setExtra2(Common.Salary_Change_For_Title_Extra);

		return zformPersonSalaryEntity;
	}

	// 根据用户输入，得到新的人员考核信息
	public ZformPersonExamEntity getPersonExam(ZformPersonEntity t,
			ZformPersonActiveEntity activeEntity, HttpServletRequest request) {

		ZformPersonExamEntity examEntity = new ZformPersonExamEntity();
		
		examEntity.setId(UUID.randomUUID().toString());
		examEntity.setCode(t.getCode());
		examEntity.setSchoolCode(activeEntity.getSchoolCode());

		String year = request.getParameter("year");
		if (StringUtil.isNotEmpty(year)) {
			examEntity.setYear(Integer.parseInt(year));
		} else {
			examEntity.setYear(DateService.GetCurrentSchoolYear());
		}

		examEntity.setTitle(activeEntity.getCurrentTitle());
		examEntity.setTitleExtra(activeEntity.getCurrentTitleExtra());
		examEntity.setExecutiveTitle(activeEntity.getExecutiveTitle());
		examEntity.setJob(activeEntity.getCurrentJob());
		examEntity.setJobLevel(activeEntity.getCurrentJobLevel());
		examEntity.setJobType(activeEntity.getCurrentJobType());
		String score = request.getParameter("score");
		if (StringUtil.isNotEmpty(score)) {
			examEntity.setScore(Integer.parseInt(score));
		}

		examEntity.setVoteReview(request.getParameter("voteReview"));
		examEntity.setFinalResult(request.getParameter("finalResult"));
		examEntity.setComments(request.getParameter("comments"));

		return examEntity;
	}

	// 对于考核为优秀或者合格者，次年1月1日工资自动增加一个薪级等级，生成一条对应的工资信息
	public ZformPersonSalaryEntity getPersonSalaryForExam(ZformPersonEntity t,
			ZformPersonActiveEntity activeEntity,
			ZformPersonExamEntity examEntity, HttpServletRequest request,
			SystemService systemService) throws Exception {

		if (t == null || examEntity == null || examEntity.getFinalResult() == null)
			return null;

		if (!examEntity.getFinalResult().equals("优秀") && !examEntity.getFinalResult().equals("合格"))
			return null;

		ZformPersonSalaryEntity zformPersonSalaryEntity = new ZformPersonSalaryEntity();

		zformPersonSalaryEntity.setId(UUID.randomUUID().toString());
		zformPersonSalaryEntity.setCode(t.getCode());

		Integer year = examEntity.getYear();

		if (year == null) {
			zformPersonSalaryEntity.setYear(String.valueOf(
					DateService.GetCurrentSchoolYear()).toString());
		} else {
			zformPersonSalaryEntity.setYear(year.toString());
		}

		zformPersonSalaryEntity.setEffectiveDate(DateService.GetNextYearFirstDay()); // 对于考核为优秀或者合格者，次年1月1日薪级工资自动增加一级
		zformPersonSalaryEntity.setChangeReason(Common.Salary_Change_For_Exam);
		zformPersonSalaryEntity.setPrevJob(activeEntity.getCurrentJob());
		zformPersonSalaryEntity.setPrevJobLevel(activeEntity.getCurrentJobLevel());
		zformPersonSalaryEntity.setPrevJobType(activeEntity.getCurrentJobType());
		
		if (StringUtil.isNotEmpty(activeEntity.getJobSalary()))
			zformPersonSalaryEntity.setPrevJobSalary(Double.parseDouble(activeEntity.getJobSalary()));
		else
			zformPersonSalaryEntity.setPrevJobSalary(0.0);
		
		if (StringUtil.isNotEmpty(activeEntity.getExtraSalary())){
			zformPersonSalaryEntity.setPrevExtraSalary(Double.parseDouble(activeEntity.getExtraSalary()));
		}else{
			zformPersonSalaryEntity.setPrevExtraSalary(0.0);
		}
		
		zformPersonSalaryEntity.setPrevRankLevel(activeEntity.getRank());
		
		
		
		String previousRankLevel = activeEntity.getRank();
		
		
		// 如果当前人员的薪级级别不为空，那么在现有基础上增加一个等级
		if (StringUtil.isNotEmpty(previousRankLevel)) {
			try {
				int newRankLevel = Integer.parseInt(previousRankLevel) + 1; // 对于考核为优秀或者合格者，次年1月1日岗位工资自动增加一个等级
				
				// 设定薪级工资等级上限，对于工勤技能岗位上限为40,对于其它为65
				String jobType = activeEntity.getCurrentJobType();
				
				if (StringUtil.isNotEmpty(jobType)){
					if (jobType.equals("工勤技能岗位")){
						if (newRankLevel > 40)
							newRankLevel = 40;
					}else{
						if (newRankLevel > 65)
							newRankLevel = 65;	
					}
				}
								
				String prevRankSalary = activeEntity.getRankSalary();
				
				
				if (StringUtil.isNotEmpty(prevRankSalary)){
					zformPersonSalaryEntity.setPrevRankSalary(Double.parseDouble(prevRankSalary));
				}else{
					Double dPrevRankSalary = getRankSalary(String.valueOf(DateService.GetCurrentSchoolYear()).toString(),
							previousRankLevel, activeEntity.getCurrentJobType(), systemService);
					zformPersonSalaryEntity.setPrevRankSalary(dPrevRankSalary);
				}
				
				zformPersonSalaryEntity.setNewRankLevel(String.valueOf(newRankLevel).toString());
				Double newRankSalary = getRankSalary(String.valueOf(DateService.GetCurrentSchoolYear()).toString(),
						String.valueOf(newRankLevel).toString(), activeEntity.getCurrentJobType(), systemService);
				zformPersonSalaryEntity.setNewRankSalary(newRankSalary);
				
				zformPersonSalaryEntity.setNewJob(zformPersonSalaryEntity.getPrevJob());
				zformPersonSalaryEntity.setNewJobLevel(zformPersonSalaryEntity.getPrevJobLevel());
				zformPersonSalaryEntity.setNewJobType(zformPersonSalaryEntity.getPrevJobType());
				zformPersonSalaryEntity.setNewJobSalary(zformPersonSalaryEntity.getPrevJobSalary());
				
				Double newJobSalary = zformPersonSalaryEntity.getNewJobSalary();				
				Double newExtraSalary = (newJobSalary + newRankSalary) * 0.1;
				
				DecimalFormat decimalFormat = new DecimalFormat("#.00"); 
				
				zformPersonSalaryEntity.setNewExtraSalary(Double.parseDouble(decimalFormat.format(newExtraSalary)));
				
			} catch (Exception exp) {
				zformPersonSalaryEntity = null;
				throw new Exception("自动增加薪级等级失败  ");
			}
		} else {
			throw new Exception("无法获取之前的薪级等级  ");
		}

		// 因为是次年自动增加，所以先利用extra1字段为1。表示暂时未被执行，在执行之后，会次年1月1日通过数据库触发器执行后，更新到在职人员信息中，并将extra1设为 2
		// extra2字段表示是因为评审原因，薪级工资调整，所以只是向上调整一级薪级。
		zformPersonSalaryEntity.setExtra1("1");
		zformPersonSalaryEntity.setExtra2(Common.Salary_Change_For_Exam_Extra);
		
		return zformPersonSalaryEntity;
	}

	public ZformSchoolEntity getSchoolByCode(SystemService systemService,
			String schoolCode) {
		// TODO Auto-generated method stub
		String hql1 = "from ZformSchoolEntity where 1 = 1 AND code = ?";

		List<ZformSchoolEntity> schoolEntityList = systemService.findHql(hql1,
				schoolCode);

		if (schoolEntityList == null || schoolEntityList.size() < 1)
			return null;

		return schoolEntityList.get(0);
	}
	
	//更新在职用户的code，code第一位为性别，第二，三位为入职年份。
	@SuppressWarnings("deprecation")
	public void updateNewAddedPersonCode(ZformPersonEntity zformPerson) {
		if (zformPerson == null)
			return;
		String sex = "M";
		if (zformPerson.getSex() != null && zformPerson.getSex().equals("男")){
			sex = "M";
		}else{
			sex = "F";
		}
		
		String year = "";
		
		if (zformPerson.getStartWorkDate() != null)
			year = String.valueOf(zformPerson.getStartWorkDate().getYear() + 1900).toString().substring(2);
		else
			year = String.valueOf(DateService.GetCurrentSchoolYear()).toString().substring(2);
		
		//个人编号：第一位表示性别，第二三为表示入职年份，后四位为编号。
		zformPerson.setCode(sex + year + zformPerson.getCode());
			
	}
	
	//根据用户所选学校code，更新用户的学校分类和学校类型
	public void updateNewAddedActivePersonSchoolTypeAndSchoolCategory(ZformPersonEntity zformPerson,
			List<ZformPersonActiveEntity> zformPersonActiveList, SystemService systemService){
		if (zformPerson == null || zformPersonActiveList == null || zformPersonActiveList.size() < 1)
			return;
		
		String schoolCode = zformPersonActiveList.get(0).getSchoolCode();
		
		if (StringUtil.isEmpty(schoolCode))
			return;
		
		ZformSchoolEntity schoolEntity = getSchoolByCode(systemService, schoolCode);
		
		if (schoolEntity != null){
			zformPersonActiveList.get(0).setExtra2(schoolEntity.getCategory());
			zformPersonActiveList.get(0).setExtra3(schoolEntity.getType());	
		}	
	}
	
	//更新在职用户的岗位工资and薪级工资and10%，并更新用户的基本信息，如年龄等。
	public void updateNewAddedActivePersonAgeAndSalary(ZformPersonEntity zformPerson,
			List<ZformPersonActiveEntity> zformPersonActiveList, SystemService systemService) {
		
		if (zformPerson == null || zformPersonActiveList == null || zformPersonActiveList.size() < 1)
			return;
		
		Date birthday = zformPerson.getBirthday();
		zformPerson.setAge(DateService.getAge(birthday));
		
		
		for (ZformPersonActiveEntity zformPersonActiveEntity : zformPersonActiveList){
						
			Double jobSalary  = getJobSalary (String.valueOf(DateService.GetCurrentSchoolYear()).toString(), zformPersonActiveEntity.getCurrentJobLevel(), zformPersonActiveEntity.getCurrentJobType(), systemService);
			Double rankSalary = getRankSalary(String.valueOf(DateService.GetCurrentSchoolYear()).toString(), zformPersonActiveEntity.getRank(), zformPersonActiveEntity.getCurrentJobType(), systemService);
			
			zformPersonActiveEntity.setJobSalary(String.valueOf(jobSalary).toString());
			zformPersonActiveEntity.setRankSalary(String.valueOf(rankSalary).toString());
			
			// 10%
			Double extraSalary = (jobSalary + rankSalary) * 0.1;
			DecimalFormat decimalFormat = new DecimalFormat("#.00"); 
			zformPersonActiveEntity.setExtraSalary(decimalFormat.format(extraSalary));
			
			Double totalSalary = jobSalary + rankSalary + extraSalary;
			//extra4 存储全部工资信息
			zformPersonActiveEntity.setExtra4(decimalFormat.format(totalSalary));
			//extra1 存储name信息
			zformPersonActiveEntity.setExtra1(zformPerson.getName());
			
			
			zformPersonActiveEntity.setTotalSeniority(DateService.getWorkAge(zformPerson.getStartWorkDate()));
			
			
		}
				
		// TODO Auto-generated method stub
		
	}


	
}
