package com.buss.person.service.impl;

import java.util.Calendar;
import java.util.List;

import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buss.active.entity.ZformPersonActiveEntity;
import com.buss.common.Common;
import com.buss.common.PersonService;
import com.buss.person.service.ZformPersonActiveSalaryTaskI;
import com.buss.person.service.ZformPersonServiceI;
import com.buss.salary.entity.ZformPersonSalaryEntity;

@Service("UpdatePersonActiveSalaryTask")
public class ZformPersonActiveSalaryTaskImpl implements ZformPersonActiveSalaryTaskI{
	@Autowired
	private ZformPersonServiceI zformPersonService;
	@Autowired
	private SystemService systemService;
	
	PersonService personService;
	public ZformPersonActiveSalaryTaskImpl(){
		personService = new PersonService();
	}
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		String hql0 = "from ZformPersonSalaryEntity where 1 = 1 AND EXTRA1 = '1' AND effective_date <= ?";
			
		List<ZformPersonSalaryEntity> personSalaryEntityList = systemService.findHql(hql0, Calendar.getInstance().getTime());
		
		if (personSalaryEntityList == null || personSalaryEntityList.size() < 1)
			return;
		
		for (ZformPersonSalaryEntity personSalaryEntity : personSalaryEntityList){
			try {
				ZformPersonActiveEntity personActiveEntity = personService.getPersonActiveByCode(systemService, personSalaryEntity.getCode());
				if (personActiveEntity == null)
					continue;
				//更新岗位信息
				if (StringUtil.isNotEmpty(personSalaryEntity.getNewJob())){
					personActiveEntity.setCurrentJob(personSalaryEntity.getNewJob());
				}
				
				if (StringUtil.isNotEmpty(personSalaryEntity.getNewJobLevel())){
					personActiveEntity.setCurrentJobLevel(personSalaryEntity.getNewJobLevel());
				}
				
				if (personSalaryEntity.getNewJobType() != null){
					personActiveEntity.setJobSalary(String.valueOf(personSalaryEntity.getNewJobSalary()).toString());					
				}
				
				//更新薪级信息
				if (StringUtil.isNotEmpty(personSalaryEntity.getNewRankLevel())){					
					personActiveEntity.setRank(personSalaryEntity.getNewRankLevel());
				}
				
				if (personSalaryEntity.getNewRankSalary() != null){
					personActiveEntity.setRankSalary(String.valueOf(personSalaryEntity.getNewRankSalary()).toString());
				}
								
				String jobSalary = personActiveEntity.getJobSalary();
				String rankSalary = personActiveEntity.getRankSalary();

				Double djobSalary = 0.0;
				Double drankSalary = 0.0;
				
				try{
					djobSalary = Double.parseDouble(jobSalary);
				}catch(Exception e){
					
				}
				
				try{
					drankSalary = Double.parseDouble(rankSalary);
				}catch(Exception e){
					
				}
				
				Double extraSalary = (djobSalary + drankSalary) * 0.1;
				
				personActiveEntity.setExecutiveTitle(String.valueOf(extraSalary).toString());
				
				
				zformPersonService.updateEntitie(personActiveEntity);
				
				personSalaryEntity.setExtra1("2");
				
				zformPersonService.updateEntitie(personSalaryEntity);
				
				
			} catch (Exception e) {
				
			}
		}
	}

}
