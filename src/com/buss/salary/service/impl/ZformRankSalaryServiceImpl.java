package com.buss.salary.service.impl;
import com.buss.salary.service.ZformRankSalaryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.salary.entity.ZformRankSalaryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("zformRankSalaryService")
@Transactional
public class ZformRankSalaryServiceImpl extends CommonServiceImpl implements ZformRankSalaryServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZformRankSalaryEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((ZformRankSalaryEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((ZformRankSalaryEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZformRankSalaryEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZformRankSalaryEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZformRankSalaryEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZformRankSalaryEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{year}",String.valueOf(t.getYear()));
 		sql  = sql.replace("#{jobtype}",String.valueOf(t.getJobtype()));
 		sql  = sql.replace("#{rank}",String.valueOf(t.getRank()));
 		sql  = sql.replace("#{salary}",String.valueOf(t.getSalary()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}