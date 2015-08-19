package com.buss.person.service;
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

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ZformPersonServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZformPersonEntity zformPerson,
	        List<ZformPersonActiveEntity> zformPersonActiveList,List<ZformPersonRetireEntity> zformPersonRetireList,List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList,List<ZformPersonDeathEntity> zformPersonDeathList,List<ZformPersonPunishEntity> zformPersonPunishList,List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList,List<ZformPersonJobEntity> zformPersonJobList,List<ZformPersonExamEntity> zformPersonExamList,List<ZformPersonSalaryEntity> zformPersonSalaryList,List<ZformPersonTitleEntity> zformPersonTitleList,List<ZformPersonStatusEntity> zformPersonStatusList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZformPersonEntity zformPerson,
	        List<ZformPersonActiveEntity> zformPersonActiveList,List<ZformPersonRetireEntity> zformPersonRetireList,
	        List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList,List<ZformPersonDeathEntity> zformPersonDeathList,
	        List<ZformPersonPunishEntity> zformPersonPunishList,List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList,
	        List<ZformPersonJobEntity> zformPersonJobList,List<ZformPersonExamEntity> zformPersonExamList,
	        List<ZformPersonSalaryEntity> zformPersonSalaryList,List<ZformPersonTitleEntity> zformPersonTitleList,
	        List<ZformPersonStatusEntity> zformPersonStatusList, String updateStatus);
	public void delMain (ZformPersonEntity zformPerson);
	
 	/**
	 * 自定义按钮-sql增强-转入退休审核
	 * @param id
	 * @return
	 */
	 public boolean doTo_RetireAuditSql(ZformPersonEntity t);
	 
	 public boolean doTo_TrasnferExternalAuditSql(ZformPersonEntity t);
	 
	 public boolean doTo_DeathAuditSql(ZformPersonEntity t);
	 
	 public boolean doTo_RetireAcceptSql(ZformPersonEntity t);
	 
	 public boolean doTo_RetireRevokeSql(ZformPersonEntity t);
	 
	 public boolean doTo_ActiveSql(ZformPersonEntity t);
	 
	 public boolean doTo_TransferExternalAcceptSql(ZformPersonEntity t);
	 
	 public boolean doTo_TransferExternalRevokeSql(ZformPersonEntity t);
	 
	 public boolean doTo_DeathAcceptSql(ZformPersonEntity t);
	 
	 public boolean doTo_DeathRevoke(ZformPersonEntity t, String backStatus);
	 
	 public boolean doTo_TransferInternal(ZformPersonEntity t, ZformPersonTransferInnerEntity transferInnerEntity);
	 
	 public boolean doTo_TransferInternalAcceptSql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonTransferInnerEntity transferInnerEntity);
	 
	 public boolean doTo_TransferInternalRevokeSql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonTransferInnerEntity transferInnerEntity);
	 
	 public boolean doTo_ChangeJob(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonJobEntity personJobEntity, ZformPersonSalaryEntity personSalaryEntity);
	 
	 public boolean doTo_ChangeTitle(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonTitleEntity personTitleEntity, ZformPersonSalaryEntity personSalaryEntity);
	 
	 public boolean doTo_AddExamSql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonExamEntity personExamEntity, ZformPersonSalaryEntity personSalaryEntity);
	 
	 public boolean doTo_AddSalarySql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonSalaryEntity salaryEntity);
	 
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZformPersonEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZformPersonEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZformPersonEntity t);
}
