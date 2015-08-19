package com.buss.person.service.impl;
import com.buss.person.service.ZformPersonServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.buss.person.entity.ZformPersonEntity;
import com.buss.active.entity.ZformPersonActiveEntity;
import com.buss.retire.entity.ZformPersonRetireEntity;
import com.buss.transferexternal.entity.ZformPersonTransferExternalEntity;
import com.buss.common.Common;
import com.buss.death.entity.ZformPersonDeathEntity;
import com.buss.punishment.entity.ZformPersonPunishEntity;
import com.buss.transferinternal.entity.ZformPersonTransferInnerEntity;
import com.buss.job.entity.ZformPersonJobEntity;
import com.buss.exam.entity.ZformPersonExamEntity;
import com.buss.salary.entity.ZformPersonSalaryEntity;
import com.buss.title.entity.ZformPersonTitleEntity;
import com.buss.status.entity.ZformPersonStatusEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.io.Serializable;


@Service("zformPersonService")
@Transactional
public class ZformPersonServiceImpl extends CommonServiceImpl implements ZformPersonServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZformPersonEntity)entity);
 	}
	
	public void addMain(ZformPersonEntity zformPerson,
	        List<ZformPersonActiveEntity> zformPersonActiveList,List<ZformPersonRetireEntity> zformPersonRetireList,List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList,List<ZformPersonDeathEntity> zformPersonDeathList,List<ZformPersonPunishEntity> zformPersonPunishList,List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList,List<ZformPersonJobEntity> zformPersonJobList,List<ZformPersonExamEntity> zformPersonExamList,List<ZformPersonSalaryEntity> zformPersonSalaryList,List<ZformPersonTitleEntity> zformPersonTitleList,List<ZformPersonStatusEntity> zformPersonStatusList){
			//保存主信息
			this.save(zformPerson);
		
			/**保存-在职*/
			for(ZformPersonActiveEntity zformPersonActive:zformPersonActiveList){
				//外键设置
				zformPersonActive.setCode(zformPerson.getCode());
				this.save(zformPersonActive);
			}
			/**保存-退休*/
			for(ZformPersonRetireEntity zformPersonRetire:zformPersonRetireList){
				//外键设置
				zformPersonRetire.setCode(zformPerson.getCode());
				this.save(zformPersonRetire);
			}
			/**保存-调出*/
			for(ZformPersonTransferExternalEntity zformPersonTransferExternal:zformPersonTransferExternalList){
				//外键设置
				zformPersonTransferExternal.setCode(zformPerson.getCode());
				this.save(zformPersonTransferExternal);
			}
			/**保存-死亡*/
			for(ZformPersonDeathEntity zformPersonDeath:zformPersonDeathList){
				//外键设置
				zformPersonDeath.setCode(zformPerson.getCode());
				this.save(zformPersonDeath);
			}
			/**保存-处分*/
			for(ZformPersonPunishEntity zformPersonPunish:zformPersonPunishList){
				//外键设置
				zformPersonPunish.setCode(zformPerson.getCode());
				this.save(zformPersonPunish);
			}
			/**保存-人员调动*/
			for(ZformPersonTransferInnerEntity zformPersonTransferInner:zformPersonTransferInnerList){
				//外键设置
				zformPersonTransferInner.setCode(zformPerson.getCode());
				this.save(zformPersonTransferInner);
			}
			/**保存-岗位聘用*/
			for(ZformPersonJobEntity zformPersonJob:zformPersonJobList){
				//外键设置
				zformPersonJob.setCode(zformPerson.getCode());
				this.save(zformPersonJob);
			}
			/**保存-年度考核*/
			for(ZformPersonExamEntity zformPersonExam:zformPersonExamList){
				//外键设置
				zformPersonExam.setCode(zformPerson.getCode());
				this.save(zformPersonExam);
			}
			/**保存-薪资管理*/
			for(ZformPersonSalaryEntity zformPersonSalary:zformPersonSalaryList){
				//外键设置
				zformPersonSalary.setCode(zformPerson.getCode());
				this.save(zformPersonSalary);
			}
			/**保存-职务变动*/
			for(ZformPersonTitleEntity zformPersonTitle:zformPersonTitleList){
				//外键设置
				zformPersonTitle.setCode(zformPerson.getCode());
				this.save(zformPersonTitle);
			}
			/**保存-状态变动*/
			for(ZformPersonStatusEntity zformPersonStatus:zformPersonStatusList){
				//外键设置
				zformPersonStatus.setCode(zformPerson.getCode());
				this.save(zformPersonStatus);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zformPerson);
	}

	
	public void updateMain(ZformPersonEntity zformPerson,
	        List<ZformPersonActiveEntity> zformPersonActiveList,List<ZformPersonRetireEntity> zformPersonRetireList,
	        List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList,List<ZformPersonDeathEntity> zformPersonDeathList,
	        List<ZformPersonPunishEntity> zformPersonPunishList,List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList,
	        List<ZformPersonJobEntity> zformPersonJobList,List<ZformPersonExamEntity> zformPersonExamList,
	        List<ZformPersonSalaryEntity> zformPersonSalaryList,List<ZformPersonTitleEntity> zformPersonTitleList,
	        List<ZformPersonStatusEntity> zformPersonStatusList, String updateStatus) {
		//保存主表信息
		this.saveOrUpdate(zformPerson);
		//===================================================================================
		//获取参数
		Object cODE0 = zformPerson.getCode();
		Object cODE1 = zformPerson.getCode();
		Object cODE2 = zformPerson.getCode();
		Object cODE3 = zformPerson.getCode();
		Object cODE4 = zformPerson.getCode();
		Object cODE5 = zformPerson.getCode();
		Object cODE6 = zformPerson.getCode();
		Object cODE7 = zformPerson.getCode();
		Object cODE8 = zformPerson.getCode();
		Object cODE9 = zformPerson.getCode();
		Object cODE10 = zformPerson.getCode();
		//===================================================================================
		//1.查询出数据库的明细数据-在职
	    String hql0 = "from ZformPersonActiveEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonActiveEntity> zformPersonActiveOldList = this.findHql(hql0,cODE0);
		//2.筛选更新明细数据-在职
		for(ZformPersonActiveEntity oldE:zformPersonActiveOldList){
			boolean isUpdate = false;
				for(ZformPersonActiveEntity sendE:zformPersonActiveList){
					//需要更新的明细数据-在职
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equalsIgnoreCase("1")){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-在职
		    		//super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-在职
			for(ZformPersonActiveEntity zformPersonActive:zformPersonActiveList){
				if(oConvertUtils.isEmpty(zformPersonActive.getId())){
					//外键设置
					zformPersonActive.setCode(zformPerson.getCode());
					this.save(zformPersonActive);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-退休
	    String hql1 = "from ZformPersonRetireEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonRetireEntity> zformPersonRetireOldList = this.findHql(hql1,cODE1);
		//2.筛选更新明细数据-退休
		for(ZformPersonRetireEntity oldE:zformPersonRetireOldList){
			boolean isUpdate = false;
				for(ZformPersonRetireEntity sendE:zformPersonRetireList){
					//需要更新的明细数据-退休
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equalsIgnoreCase("2")){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-退休
		    		//super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-退休
			for(ZformPersonRetireEntity zformPersonRetire:zformPersonRetireList){
				if(oConvertUtils.isEmpty(zformPersonRetire.getId())){
					//外键设置
					zformPersonRetire.setCode(zformPerson.getCode());
					this.save(zformPersonRetire);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-调出
	    String hql2 = "from ZformPersonTransferExternalEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonTransferExternalEntity> zformPersonTransferExternalOldList = this.findHql(hql2,cODE2);
		//2.筛选更新明细数据-调出
		for(ZformPersonTransferExternalEntity oldE:zformPersonTransferExternalOldList){
			boolean isUpdate = false;
				for(ZformPersonTransferExternalEntity sendE:zformPersonTransferExternalList){
					//需要更新的明细数据-调出
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("4") && (zformPersonTransferExternalList.size()>0)){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-调出
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-调出
			for(ZformPersonTransferExternalEntity zformPersonTransferExternal:zformPersonTransferExternalList){
				if(oConvertUtils.isEmpty(zformPersonTransferExternal.getId())){
					//外键设置
					zformPersonTransferExternal.setCode(zformPerson.getCode());
					this.save(zformPersonTransferExternal);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-死亡
	    String hql3 = "from ZformPersonDeathEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonDeathEntity> zformPersonDeathOldList = this.findHql(hql3,cODE3);
		//2.筛选更新明细数据-死亡
		for(ZformPersonDeathEntity oldE:zformPersonDeathOldList){
			boolean isUpdate = false;
				for(ZformPersonDeathEntity sendE:zformPersonDeathList){
					//需要更新的明细数据-死亡
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("6") && (zformPersonDeathList.size()>0)){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-死亡
		    		//super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-死亡
			for(ZformPersonDeathEntity zformPersonDeath:zformPersonDeathList){
				if(oConvertUtils.isEmpty(zformPersonDeath.getId())){
					//外键设置
					zformPersonDeath.setCode(zformPerson.getCode());
					this.save(zformPersonDeath);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-处分
	    String hql4 = "from ZformPersonPunishEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonPunishEntity> zformPersonPunishOldList = this.findHql(hql4,cODE4);
		//2.筛选更新明细数据-处分
		for(ZformPersonPunishEntity oldE:zformPersonPunishOldList){
			boolean isUpdate = false;
				for(ZformPersonPunishEntity sendE:zformPersonPunishList){
					//需要更新的明细数据-处分
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("1") && zformPersonPunishList.size()>0){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-处分
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-处分
			for(ZformPersonPunishEntity zformPersonPunish:zformPersonPunishList){
				if(oConvertUtils.isEmpty(zformPersonPunish.getId())){
					//外键设置
					zformPersonPunish.setCode(zformPerson.getCode());
					this.save(zformPersonPunish);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-人员调动
	    String hql5 = "from ZformPersonTransferInnerEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonTransferInnerEntity> zformPersonTransferInnerOldList = this.findHql(hql5,cODE5);
		//2.筛选更新明细数据-人员调动
		for(ZformPersonTransferInnerEntity oldE:zformPersonTransferInnerOldList){
			boolean isUpdate = false;
				for(ZformPersonTransferInnerEntity sendE:zformPersonTransferInnerList){
					//需要更新的明细数据-人员调动
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("8") && (zformPersonTransferInnerList.size()>0)){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-人员调动
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-人员调动
			for(ZformPersonTransferInnerEntity zformPersonTransferInner:zformPersonTransferInnerList){
				if(oConvertUtils.isEmpty(zformPersonTransferInner.getId())){
					//外键设置
					zformPersonTransferInner.setCode(zformPerson.getCode());
					this.save(zformPersonTransferInner);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-岗位聘用
	    String hql6 = "from ZformPersonJobEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonJobEntity> zformPersonJobOldList = this.findHql(hql6,cODE6);
		//2.筛选更新明细数据-岗位聘用
		for(ZformPersonJobEntity oldE:zformPersonJobOldList){
			boolean isUpdate = false;
				for(ZformPersonJobEntity sendE:zformPersonJobList){
					//需要更新的明细数据-岗位聘用
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("10") && (zformPersonJobList.size()>0)){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-岗位聘用
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-岗位聘用
			for(ZformPersonJobEntity zformPersonJob:zformPersonJobList){
				if(oConvertUtils.isEmpty(zformPersonJob.getId())){
					//外键设置
					zformPersonJob.setCode(zformPerson.getCode());
					this.save(zformPersonJob);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-年度考核
	    String hql7 = "from ZformPersonExamEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonExamEntity> zformPersonExamOldList = this.findHql(hql7,cODE7);
		//2.筛选更新明细数据-年度考核
		for(ZformPersonExamEntity oldE:zformPersonExamOldList){
				boolean isUpdate = false;
				for(ZformPersonExamEntity sendE:zformPersonExamList){
					//需要更新的明细数据-年度考核
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("11") && (zformPersonExamList.size() > 0) ){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-年度考核
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-年度考核
			for(ZformPersonExamEntity zformPersonExam:zformPersonExamList){
				if(oConvertUtils.isEmpty(zformPersonExam.getId())){
					//外键设置
					zformPersonExam.setCode(zformPerson.getCode());
					this.save(zformPersonExam);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-薪资管理
	    String hql8 = "from ZformPersonSalaryEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonSalaryEntity> zformPersonSalaryOldList = this.findHql(hql8,cODE8);
		//2.筛选更新明细数据-薪资管理
		for(ZformPersonSalaryEntity oldE:zformPersonSalaryOldList){
			boolean isUpdate = false;
				for(ZformPersonSalaryEntity sendE:zformPersonSalaryList){
					//需要更新的明细数据-薪资管理
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("12") && zformPersonSalaryList.size() > 0 ){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-薪资管理
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-薪资管理
			for(ZformPersonSalaryEntity zformPersonSalary:zformPersonSalaryList){
				if(oConvertUtils.isEmpty(zformPersonSalary.getId())){
					//外键设置
					zformPersonSalary.setCode(zformPerson.getCode());
					this.save(zformPersonSalary);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-职务变动
	    String hql9 = "from ZformPersonTitleEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonTitleEntity> zformPersonTitleOldList = this.findHql(hql9,cODE9);
		//2.筛选更新明细数据-职务变动
		for(ZformPersonTitleEntity oldE:zformPersonTitleOldList){
			boolean isUpdate = false;
				for(ZformPersonTitleEntity sendE:zformPersonTitleList){
					//需要更新的明细数据-职务变动
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("13") & (zformPersonTitleList.size()>0)){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-职务变动
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-职务变动
			for(ZformPersonTitleEntity zformPersonTitle:zformPersonTitleList){
				if(oConvertUtils.isEmpty(zformPersonTitle.getId())){
					//外键设置
					zformPersonTitle.setCode(zformPerson.getCode());
					this.save(zformPersonTitle);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-状态变动
	    String hql10 = "from ZformPersonStatusEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonStatusEntity> zformPersonStatusOldList = this.findHql(hql10,cODE10);
		//2.筛选更新明细数据-状态变动
		for(ZformPersonStatusEntity oldE:zformPersonStatusOldList){
			boolean isUpdate = false;
				for(ZformPersonStatusEntity sendE:zformPersonStatusList){
					//需要更新的明细数据-状态变动
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate && updateStatus.equals("1")&&zformPersonStatusList.size()>0){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-状态变动
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-状态变动
			for(ZformPersonStatusEntity zformPersonStatus:zformPersonStatusList){
				if(oConvertUtils.isEmpty(zformPersonStatus.getId())){
					//外键设置
					zformPersonStatus.setCode(zformPerson.getCode());
					this.save(zformPersonStatus);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zformPerson);
	}

	
	public void delMain(ZformPersonEntity zformPerson) {
		//删除主表信息
		this.delete(zformPerson);
		//===================================================================================
		//获取参数
		Object cODE0 = zformPerson.getCode();
		Object cODE1 = zformPerson.getCode();
		Object cODE2 = zformPerson.getCode();
		Object cODE3 = zformPerson.getCode();
		Object cODE4 = zformPerson.getCode();
		Object cODE5 = zformPerson.getCode();
		Object cODE6 = zformPerson.getCode();
		Object cODE7 = zformPerson.getCode();
		Object cODE8 = zformPerson.getCode();
		Object cODE9 = zformPerson.getCode();
		Object cODE10 = zformPerson.getCode();
		//===================================================================================
		//删除-在职
	    String hql0 = "from ZformPersonActiveEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonActiveEntity> zformPersonActiveOldList = this.findHql(hql0,cODE0);
		this.deleteAllEntitie(zformPersonActiveOldList);
		//===================================================================================
		//删除-退休
	    String hql1 = "from ZformPersonRetireEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonRetireEntity> zformPersonRetireOldList = this.findHql(hql1,cODE1);
		this.deleteAllEntitie(zformPersonRetireOldList);
		//===================================================================================
		//删除-调出
	    String hql2 = "from ZformPersonTransferExternalEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonTransferExternalEntity> zformPersonTransferExternalOldList = this.findHql(hql2,cODE2);
		this.deleteAllEntitie(zformPersonTransferExternalOldList);
		//===================================================================================
		//删除-死亡
	    String hql3 = "from ZformPersonDeathEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonDeathEntity> zformPersonDeathOldList = this.findHql(hql3,cODE3);
		this.deleteAllEntitie(zformPersonDeathOldList);
		//===================================================================================
		//删除-处分
	    String hql4 = "from ZformPersonPunishEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonPunishEntity> zformPersonPunishOldList = this.findHql(hql4,cODE4);
		this.deleteAllEntitie(zformPersonPunishOldList);
		//===================================================================================
		//删除-人员调动
	    String hql5 = "from ZformPersonTransferInnerEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonTransferInnerEntity> zformPersonTransferInnerOldList = this.findHql(hql5,cODE5);
		this.deleteAllEntitie(zformPersonTransferInnerOldList);
		//===================================================================================
		//删除-岗位聘用
	    String hql6 = "from ZformPersonJobEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonJobEntity> zformPersonJobOldList = this.findHql(hql6,cODE6);
		this.deleteAllEntitie(zformPersonJobOldList);
		//===================================================================================
		//删除-年度考核
	    String hql7 = "from ZformPersonExamEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonExamEntity> zformPersonExamOldList = this.findHql(hql7,cODE7);
		this.deleteAllEntitie(zformPersonExamOldList);
		//===================================================================================
		//删除-薪资管理
	    String hql8 = "from ZformPersonSalaryEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonSalaryEntity> zformPersonSalaryOldList = this.findHql(hql8,cODE8);
		this.deleteAllEntitie(zformPersonSalaryOldList);
		//===================================================================================
		//删除-职务变动
	    String hql9 = "from ZformPersonTitleEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonTitleEntity> zformPersonTitleOldList = this.findHql(hql9,cODE9);
		this.deleteAllEntitie(zformPersonTitleOldList);
		//===================================================================================
		//删除-状态变动
	    String hql10 = "from ZformPersonStatusEntity where 1 = 1 AND code = ? ";
	    List<ZformPersonStatusEntity> zformPersonStatusOldList = this.findHql(hql10,cODE10);
		this.deleteAllEntitie(zformPersonStatusOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-转入退休审核
	 * @param id
	 * @return
	 */
	 public boolean doTo_RetireAuditSql(ZformPersonEntity t){
	 	 //sql增强第1条
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_retire_review + "' where code = '#{code}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 return true;
	 }
	 
	 public boolean doTo_TrasnferExternalAuditSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_transfer_external_review + "' where code = '#{code}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 return true;
	 }
	 
	 public boolean doTo_DeathAuditSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_death_review + "' where code = '#{code}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 return true;
	 }
	 
	 public boolean doTo_RetireAcceptSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_retired + "' where code = '#{code}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
				 
		 ZformPersonStatusEntity zformPersonStatus = new ZformPersonStatusEntity();
		 zformPersonStatus.setId(UUID.randomUUID().toString());
		 zformPersonStatus.setCode(t.getCode());
		 zformPersonStatus.setPrevStatus(Common.person_status_active);
		 zformPersonStatus.setAfterStatus(Common.person_status_retired);
		 zformPersonStatus.setStateChangeReason(Common.transfer_reason_retire);
		 zformPersonStatus.setStatusChangeDate(Calendar.getInstance().getTime());
		 
		 this.save(zformPersonStatus);
		 
		 return true;
	 }
	 
	 public boolean doTo_RetireRevokeSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '"+ Common.person_status_active +"' where code = '#{code}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 return true;
	 }
	 
	 public boolean doTo_ActiveSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_active + "' where code = '#{code}'";		 
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 ZformPersonStatusEntity zformPersonStatus = new ZformPersonStatusEntity();
		 zformPersonStatus.setId(UUID.randomUUID().toString());
		 zformPersonStatus.setCode(t.getCode());
		 zformPersonStatus.setPrevStatus(t.getCurrentStatus());
		 zformPersonStatus.setAfterStatus(Common.person_status_active);
		 zformPersonStatus.setStateChangeReason(Common.transfer_reason_active);
		 zformPersonStatus.setStatusChangeDate(Calendar.getInstance().getTime());
		 
		 this.save(zformPersonStatus);
		 
		 return true;
	 }
	 
	 public boolean doTo_TransferExternalAcceptSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_transfer_external + "' where code = '#{code}'";		 
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 ZformPersonStatusEntity zformPersonStatus = new ZformPersonStatusEntity();
		 
		 zformPersonStatus.setId(UUID.randomUUID().toString());
		 zformPersonStatus.setCode(t.getCode());
		 zformPersonStatus.setPrevStatus(Common.person_status_active);
		 zformPersonStatus.setAfterStatus(Common.person_status_transfer_external);
		 zformPersonStatus.setStateChangeReason(Common.transfer_reason_transfer_external);
		 zformPersonStatus.setStatusChangeDate(Calendar.getInstance().getTime());
		 
		 this.save(zformPersonStatus);
		 
		 return true;
	 }
	 
	 public boolean doTo_TransferExternalRevokeSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_active + "' where code = '#{code}'";		 
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 return true;
	 }
	 
	 public boolean doTo_DeathAcceptSql(ZformPersonEntity t){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_death + "' where code = '#{code}'";		 
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 ZformPersonStatusEntity zformPersonStatus = new ZformPersonStatusEntity();
		 
		 zformPersonStatus.setId(UUID.randomUUID().toString());
		 zformPersonStatus.setCode(t.getCode());
		 zformPersonStatus.setPrevStatus(Common.person_status_retired);
		 zformPersonStatus.setAfterStatus(Common.person_status_death);
		 zformPersonStatus.setStateChangeReason(Common.transfer_reason_death);
		 zformPersonStatus.setStatusChangeDate(Calendar.getInstance().getTime());
		 
		 this.save(zformPersonStatus);
		 
		 return true;
	 }
	 
	 public boolean doTo_DeathRevoke(ZformPersonEntity t, String backStatus){
		 String sqlEnhance_1 = "update zform_person set current_status = '" + backStatus + "' where code = '#{code}'";		 
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 return true;
		 
	 }
	 
	 public boolean doTo_TransferInternal(ZformPersonEntity t, ZformPersonTransferInnerEntity transferInnerEntity){
		 
		 //内部人员调动申请，将人员状态转换为内部调动申请中
		 String sqlEnhance_1 = "update zform_person set current_status = '"+ Common.person_status_transfer_internal_review +"' where code = '#{code}'";		 
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 //内部人员调动申请，添加一条调动记录
		 if (transferInnerEntity != null)
			 this.save(transferInnerEntity);
		 
		 return true;
	 }
	 
	 public boolean doTo_TransferInternalAcceptSql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonTransferInnerEntity transferInnerEntity){
		 //内部人员调动审核后被接受，将人员状态转为在职
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_active + "' where code = '#{code}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 //内部人员调动审核后被接受，将人员所在学校信息更新
		 personActive.setSchoolCode(transferInnerEntity.getToSchool());
		 this.saveOrUpdate(personActive);		 
		 
		//内部人员调动审核后被接受，更新内部调动记录的状态
		 transferInnerEntity.setTransferDate(Calendar.getInstance().getTime());
		 transferInnerEntity.setTransferStatus(Common.transfer_inner_status_accepted);		 
		 this.saveOrUpdate(transferInnerEntity);
		 
		 return true;
	 }
	 
	 public boolean doTo_TransferInternalRevokeSql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonTransferInnerEntity transferInnerEntity){
		 //内部人员调动审核时被退回，将人员状态转为在职
		 String sqlEnhance_1 = "update zform_person set current_status = '" + Common.person_status_active + "' where code = '#{code}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 
		 //内部调动人员审核时被退回，删除对应的内部调动记录
		 String sqlEnhance_2 = "delete from zform_person_transfer_inner where code = '#{code}' and transfer_status = '"+ Common.transfer_inner_status_wait_for_accept + "'";
		 this.executeSql(replaceVal(sqlEnhance_2,t));
		 
		 return true;
	 }
	 
	 //岗位聘用
	 public boolean doTo_ChangeJob(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonJobEntity personJobEntity, ZformPersonSalaryEntity personSalaryEntity){
		 
		 if (personJobEntity == null)
			 return true;
		 
		 this.save(personJobEntity);
		 
		 if (personActive == null)
			 return true;
		 
		 //更新在职人员的薪水和岗位信息
		 personActive.setCurrentTitle(personJobEntity.getNewTitle());
		 personActive.setCurrentTitleExtra(personJobEntity.getNewTitleExtra());
		 personActive.setCurrentJob(personJobEntity.getNewJob());
		 personActive.setCurrentJobExtra(personJobEntity.getNewJobExtra());
		 personActive.setCurrentJobLevel(personJobEntity.getNewJobLevel());		 
		 
		 
		 String newJobSalary = "";
		 try{
			newJobSalary = String.valueOf(personJobEntity.getNewJobSalary());
		 }catch(Exception exp){
			 
		 }
		 personActive.setJobSalary(newJobSalary); 
		 personActive.setExtraSalary(getExtraSalary(personActive.getJobSalary(),personActive.getRankSalary()));
		 		 
		 this.updateEntitie(personActive);
		 
		 
		 if (personSalaryEntity != null)
			 this.save(personSalaryEntity);
		 		 
		 return true; 
	 }
	 
	 //职务变动
	 public boolean doTo_ChangeTitle(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonTitleEntity personTitleEntity, ZformPersonSalaryEntity personSalaryEntity){
		 
		 if (personTitleEntity == null)
			 return true;
		 
		 this.save(personTitleEntity);
		 
		 if (personActive == null)
			 return true;
		 
		 //更新在职人员的薪水，岗位和职务信息
		 personActive.setCurrentTitle(personTitleEntity.getNewTitle());
		 personActive.setCurrentTitleExtra(personTitleEntity.getNewTitleExtra());
		 personActive.setCurrentJob(personTitleEntity.getNewJob());
		 personActive.setCurrentJobExtra(personTitleEntity.getNewJobExtra());
		 personActive.setCurrentJobLevel(personTitleEntity.getNewJobLevel());		 
		 
		 String newJobSalary = "";
		 try{
			newJobSalary = String.valueOf(personSalaryEntity.getNewJobSalary());
		 }catch(Exception exp){
			 
		 }
		 personActive.setJobSalary(newJobSalary);
		 personActive.setExtraSalary(getExtraSalary(personActive.getJobSalary(), personActive.getRankSalary()));
		 
		 this.saveOrUpdate(personActive);
		 		 
		 if (personSalaryEntity != null)
			 this.save(personSalaryEntity);
		 		 
		 return true; 
	 }
	 
	 //考核
	 public boolean doTo_AddExamSql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonExamEntity personExamEntity, ZformPersonSalaryEntity personSalaryEntity){
		 if (personExamEntity != null)
			 this.save(personExamEntity);	
		 if (personSalaryEntity != null)		 
			 this.save(personSalaryEntity);
		 
		 return true;
	 }
	 
	 
	 public boolean doTo_AddSalarySql(ZformPersonEntity t, ZformPersonActiveEntity personActive, ZformPersonSalaryEntity salaryEntity){
		 
		 if (salaryEntity == null)
			 return true;
		 this.save(salaryEntity);
		 
		 if (personActive == null)
			 return true;
		 
		 personActive.setCurrentJob(salaryEntity.getNewJob());
		 personActive.setCurrentJobLevel(salaryEntity.getNewJobLevel());
		 personActive.setCurrentJobType(salaryEntity.getNewJobType());
		 personActive.setRank(salaryEntity.getNewRankLevel());
		 
		 Double newJobSalary = salaryEntity.getNewJobSalary();
		 Double newRankSalary = salaryEntity.getNewRankSalary();
		 
		 personActive.setRankSalary(String.valueOf(newRankSalary).toString());
		 personActive.setJobSalary(String.valueOf(newJobSalary).toString());
		 personActive.setExtraSalary(getExtraSalary(personActive.getJobSalary(), personActive.getRankSalary()));
		 
		 this.saveOrUpdate(personActive);
		 return true;
	 }
 	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZformPersonEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZformPersonEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZformPersonEntity t){
	 	return true;
 	}
 	
 	private String getExtraSalary(String jobSalary, String rankSalary){
 		Double dJobSalary = 0.0;
 		Double dRankSalary = 0.0;
 		
 		if (StringUtil.isNotEmpty(jobSalary)){
 			try{
 				dJobSalary = Double.parseDouble(jobSalary);
 			}catch(Exception e){
 				
 			}
 			
 		}
 		
 		if (StringUtil.isNotEmpty(rankSalary)){
 			try{
 				dRankSalary = Double.parseDouble(rankSalary);
 			}catch(Exception e){
 				
 			}
 		}
 		
 		Double dExtraSalary = (dJobSalary + dRankSalary) * 0.1;
 		
 		return String.valueOf(dExtraSalary).toString();
 		
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZformPersonEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{seq_no}",String.valueOf(t.getSeqNo()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{birthday}",String.valueOf(t.getBirthday()));
 		sql  = sql.replace("#{age}",String.valueOf(t.getAge()));
 		sql  = sql.replace("#{photo_id_no}",String.valueOf(t.getPhotoIdNo()));
 		sql  = sql.replace("#{nationality}",String.valueOf(t.getNationality()));
 		sql  = sql.replace("#{social_status}",String.valueOf(t.getSocialStatus()));
 		sql  = sql.replace("#{start_work_date}",String.valueOf(t.getStartWorkDate()));
 		sql  = sql.replace("#{edu_background}",String.valueOf(t.getEduBackground()));
 		sql  = sql.replace("#{edu_extra}",String.valueOf(t.getEduExtra()));
 		sql  = sql.replace("#{degree}",String.valueOf(t.getDegree()));
 		sql  = sql.replace("#{major}",String.valueOf(t.getMajor()));
 		sql  = sql.replace("#{graduate_date}",String.valueOf(t.getGraduateDate()));
 		sql  = sql.replace("#{graduate_school}",String.valueOf(t.getGraduateSchool()));
 		sql  = sql.replace("#{contact_no}",String.valueOf(t.getContactNo()));
 		sql  = sql.replace("#{home_address}",String.valueOf(t.getHomeAddress()));
 		sql  = sql.replace("#{enter_approach}",String.valueOf(t.getEnterApproach()));
 		sql  = sql.replace("#{enter_date}",String.valueOf(t.getEnterDate()));
 		sql  = sql.replace("#{junior_title_date}",String.valueOf(t.getJuniorTitleDate()));
 		sql  = sql.replace("#{secondary_title_date}",String.valueOf(t.getSecondaryTitleDate()));
 		sql  = sql.replace("#{senior_title_date}",String.valueOf(t.getSeniorTitleDate()));
 		sql  = sql.replace("#{photo}",String.valueOf(t.getPhoto()));
 		sql  = sql.replace("#{comments}",String.valueOf(t.getComments()));
 		sql  = sql.replace("#{current_status}",String.valueOf(t.getCurrentStatus()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}