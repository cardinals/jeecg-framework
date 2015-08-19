package com.buss.person.controller;
import com.buss.person.entity.ZformPersonEntity;
import com.buss.person.service.ZformPersonServiceI;
import com.buss.person.page.ZformPersonPage;
import com.buss.active.entity.ZformPersonActiveEntity;
import com.buss.retire.entity.ZformPersonRetireEntity;
import com.buss.transferexternal.entity.ZformPersonTransferExternalEntity;
import com.buss.common.Common;
import com.buss.common.DateService;
import com.buss.common.PersonService;
import com.buss.common.ReportService;
import com.buss.death.entity.ZformPersonDeathEntity;
import com.buss.punishment.entity.ZformPersonPunishEntity;
import com.buss.transferinternal.entity.ZformPersonTransferInnerEntity;
import com.buss.job.entity.ZformPersonJobEntity;
import com.buss.exam.entity.ZformPersonExamEntity;
import com.buss.salary.entity.ZformPersonSalaryEntity;
import com.buss.school.entity.ZformSchoolEntity;
import com.buss.title.entity.ZformPersonTitleEntity;
import com.buss.status.entity.ZformPersonStatusEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.hqlsearch.parse.vo.HqlParseEnum;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateWordConstants;
import org.jeecgframework.poi.excel.view.JeecgTemplateExcelView;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;


/**   
 * @Title: Controller
 * @Description: 人员基本信息数据库
 * @author onlineGenerator
 * @date 2015-07-19 11:33:28
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/zformPersonController")
public class ZformPersonController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZformPersonController.class);

	@Autowired
	private ZformPersonServiceI zformPersonService;
	@Autowired
	private SystemService systemService;
	
	private PersonService personService;
	private ReportService reportService;

	public ZformPersonController(){
		personService = new PersonService();
		reportService = new ReportService();
	}

	/**
	 * 人员基本信息数据库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPerson")
	public ModelAndView zformPerson(HttpServletRequest request) {
		String status = request.getParameter("status");
		
		if (StringUtil.isNotEmpty(status))
		{
			if (status.equalsIgnoreCase("1"))
				return new ModelAndView("com/buss/person/zformPersonList_active");
			if (status.equalsIgnoreCase("2"))
				return new ModelAndView("com/buss/person/zformPersonList_retire_audit");
			if (status.equalsIgnoreCase("3"))
				return new ModelAndView("com/buss/person/zformPersonList_retire");
			if (status.equalsIgnoreCase("4"))
				return new ModelAndView("com/buss/person/zformPersonList_transfer_external_audit");
			if (status.equalsIgnoreCase("5"))
				return new ModelAndView("com/buss/person/zformPersonList_transfer_external");
			if (status.equalsIgnoreCase("6"))
				return new ModelAndView("com/buss/person/zformPersonList_death_audit");
			if (status.equalsIgnoreCase("7"))
				return new ModelAndView("com/buss/person/zformPersonList_death");
			if (status.equalsIgnoreCase("8"))
				return new ModelAndView("com/buss/person/zformPersonList_transfer_internal");
			if (status.equalsIgnoreCase("9"))
				return new ModelAndView("com/buss/person/zformPersonList_transfer_internal_audit");
			if (status.equalsIgnoreCase("10"))
				return new ModelAndView("com/buss/person/zformPersonList_job");			
			if (status.equalsIgnoreCase("11"))
				return new ModelAndView("com/buss/person/zformPersonList_exam");
			if (status.equalsIgnoreCase("12"))
				return new ModelAndView("com/buss/person/zformPersonList_salary");
			if (status.equalsIgnoreCase("13"))
				return new ModelAndView("com/buss/person/zformPersonList_title");
			if (status.equalsIgnoreCase("14"))
				return new ModelAndView("com/buss/person/zformPersonList_active_near_retire");
			
		}
		
		return new ModelAndView("com/buss/person/zformPersonList");
	}
	
	
	@RequestMapping(params = "salarydatagrid")
	public void salarydatagrid(ZformPersonEntity zformPerson,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZformPersonActiveEntity.class, dataGrid);
		//查询条件组装器		 				
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zformPerson);
		try{
		//自定义追加查询条件				
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zformPersonService.getDataGridReturn(cq, true);
		
		TagUtil.datagrid(response, dataGrid);
	}


	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZformPersonEntity zformPerson,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZformPersonEntity.class, dataGrid);
		//查询条件组装器		 
		
		//对已有的查询条件，应该加上* aaa * 进行模糊查询
		//if (zformPerson != null && StringUtil.isNotEmpty(zformPerson.getSocialStatus())){
		//	String socialStatus = HqlParseEnum.SUFFIX_ASTERISK.getValue() + zformPerson.getSocialStatus() + HqlParseEnum.SUFFIX_ASTERISK.getValue();			
		//	zformPerson.setSocialStatus(socialStatus);
		//}		
		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zformPerson);
		try{
		//自定义追加查询条件
			String status = request.getParameter("status");
			
			if (StringUtil.isNotEmpty(status))
				cq.eq("currentStatus", status);
			
			String nearRetire = request.getParameter("nearRetire");
			
			String startworkDate_begin = request.getParameter("startWorkDate_begin");
			String startworkDate_end = request.getParameter("startWorkDate_end");
			
			if (StringUtil.isNotEmpty(startworkDate_begin)){
				cq.ge("startWorkDate", startworkDate_begin);
			}
			
			if (StringUtil.isNotEmpty(startworkDate_end)){
				cq.le("startWorkDate", startworkDate_end);
			}
			
			String age_begin = request.getParameter("age_begin");
			String age_end = request.getParameter("age_end");
			
			if (StringUtil.isNotEmpty(age_begin)){
				cq.ge("age", age_begin);
			}
			
			if (StringUtil.isNotEmpty(age_end)){
				cq.le("age", age_end);
			}
			
			//找出快退休的所有人员，条件为差1个月60岁
			if (StringUtil.isNotEmpty(nearRetire) && nearRetire.equalsIgnoreCase("1")){
				Calendar calendar = Calendar.getInstance();
				int currentYear = calendar.get(Calendar.YEAR);
				int currentMonth = calendar.get(Calendar.MONTH);
				
				int birthYearQuery = currentYear - 60;
				int birthMonthQuery = currentMonth + 1;
				if (birthMonthQuery > 12){
					birthMonthQuery = 1;
					birthYearQuery = birthYearQuery + 1;
				}
				
				calendar.set(birthYearQuery, birthMonthQuery, 1); 
				
				cq.le("birthday", calendar.getTime());
			}
			
			//得到当前用户所在学校，如果为空则是教委管理人员
			
			String schoolCode = ClientManager.getInstance().getClient().getUser().getSchoolCode();
						
			if (StringUtil.isNotEmpty(schoolCode)){
				String hql1 = "from ZformPersonActiveEntity where 1 = 1 AND schoolCode = ?";
				List<ZformPersonActiveEntity> zformPersonActiveEntityList = systemService.findHql(hql1, schoolCode);
				
				if (zformPersonActiveEntityList != null && zformPersonActiveEntityList.size() > 0){					
					List<String> personCodeList = new ArrayList<String>();
					for(ZformPersonActiveEntity personActive : zformPersonActiveEntityList)
						personCodeList.add(personActive.getCode());
					
					cq.in("code", personCodeList.toArray());					
				}
								
			}
						
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zformPersonService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除人员基本信息数据库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZformPersonEntity zformPerson, HttpServletRequest request) {
		
		AjaxJson j = new AjaxJson();
		zformPerson = systemService.getEntity(ZformPersonEntity.class, zformPerson.getId());
		String message = "人员基本信息数据库删除成功";
		try{
			zformPersonService.delMain(zformPerson);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "人员基本信息数据库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除人员基本信息数据库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "人员基本信息数据库删除成功";		
		try{
			for(String id:ids.split(",")){
				ZformPersonEntity zformPerson = systemService.getEntity(ZformPersonEntity.class, id);
				zformPersonService.delMain(zformPerson);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "人员基本信息数据库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加人员基本信息数据库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZformPersonEntity zformPerson,ZformPersonPage zformPersonPage, HttpServletRequest request) {
		List<ZformPersonActiveEntity> zformPersonActiveList =  zformPersonPage.getZformPersonActiveList();
		List<ZformPersonRetireEntity> zformPersonRetireList =  zformPersonPage.getZformPersonRetireList();
		List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList =  zformPersonPage.getZformPersonTransferExternalList();
		List<ZformPersonDeathEntity> zformPersonDeathList =  zformPersonPage.getZformPersonDeathList();
		List<ZformPersonPunishEntity> zformPersonPunishList =  zformPersonPage.getZformPersonPunishList();
		List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList =  zformPersonPage.getZformPersonTransferInnerList();
		List<ZformPersonJobEntity> zformPersonJobList =  zformPersonPage.getZformPersonJobList();
		List<ZformPersonExamEntity> zformPersonExamList =  zformPersonPage.getZformPersonExamList();
		List<ZformPersonSalaryEntity> zformPersonSalaryList =  zformPersonPage.getZformPersonSalaryList();
		List<ZformPersonTitleEntity> zformPersonTitleList =  zformPersonPage.getZformPersonTitleList();
		List<ZformPersonStatusEntity> zformPersonStatusList =  zformPersonPage.getZformPersonStatusList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			if (StringUtil.isEmpty(zformPerson.getCurrentStatus()))
				zformPerson.setCurrentStatus("1");
			
			//更新在职用户的编码.
			personService.updateNewAddedPersonCode(zformPerson);
			
			//更新在职用户的岗位工资和薪级工资，以及根据用户出生日期计算年龄。
			personService.updateNewAddedActivePersonAgeAndSalary(zformPerson, zformPersonActiveList, systemService);
			//更新在职用户的单位类型和单位分类
			personService.updateNewAddedActivePersonSchoolTypeAndSchoolCategory(zformPerson, zformPersonActiveList, systemService);
			
			zformPersonService.addMain(zformPerson, zformPersonActiveList,zformPersonRetireList,zformPersonTransferExternalList,zformPersonDeathList,zformPersonPunishList,zformPersonTransferInnerList,zformPersonJobList,zformPersonExamList,zformPersonSalaryList,zformPersonTitleList,zformPersonStatusList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "人员基本信息数据库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新人员基本信息数据库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZformPersonEntity zformPerson,ZformPersonPage zformPersonPage, HttpServletRequest request) {
		List<ZformPersonActiveEntity> zformPersonActiveList =  zformPersonPage.getZformPersonActiveList();
		List<ZformPersonRetireEntity> zformPersonRetireList =  zformPersonPage.getZformPersonRetireList();
		List<ZformPersonTransferExternalEntity> zformPersonTransferExternalList =  zformPersonPage.getZformPersonTransferExternalList();
		List<ZformPersonDeathEntity> zformPersonDeathList =  zformPersonPage.getZformPersonDeathList();
		List<ZformPersonPunishEntity> zformPersonPunishList =  zformPersonPage.getZformPersonPunishList();
		List<ZformPersonTransferInnerEntity> zformPersonTransferInnerList =  zformPersonPage.getZformPersonTransferInnerList();
		List<ZformPersonJobEntity> zformPersonJobList =  zformPersonPage.getZformPersonJobList();
		List<ZformPersonExamEntity> zformPersonExamList =  zformPersonPage.getZformPersonExamList();
		List<ZformPersonSalaryEntity> zformPersonSalaryList =  zformPersonPage.getZformPersonSalaryList();
		List<ZformPersonTitleEntity> zformPersonTitleList =  zformPersonPage.getZformPersonTitleList();
		List<ZformPersonStatusEntity> zformPersonStatusList =  zformPersonPage.getZformPersonStatusList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			String updateStatus = request.getParameter("updateStatus");
			
			if (StringUtil.isEmpty(updateStatus))
				updateStatus = "";
			//更新在职用户的岗位工资和薪级工资，以及根据用户出生日期计算年龄。			
			personService.updateNewAddedActivePersonAgeAndSalary(zformPerson, zformPersonActiveList, systemService);
			//更新在职用户的单位类型和单位分类，使用Extra2和Extra3字段
			personService.updateNewAddedActivePersonSchoolTypeAndSchoolCategory(zformPerson, zformPersonActiveList, systemService);
			
			zformPersonService.updateMain(zformPerson, zformPersonActiveList,zformPersonRetireList,
					zformPersonTransferExternalList,zformPersonDeathList,zformPersonPunishList,
					zformPersonTransferInnerList,zformPersonJobList,zformPersonExamList,
					zformPersonSalaryList,zformPersonTitleList,zformPersonStatusList, updateStatus);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新人员基本信息数据库失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 人员基本信息数据库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			req.setAttribute("zformPersonPage", zformPerson);
		}
		
		String status = req.getParameter("status");
		
		if (StringUtil.isNotEmpty(status))
		{
			if (status.equalsIgnoreCase("1"))
				return new ModelAndView("com/buss/person/zformPerson-add_active");
			if (status.equalsIgnoreCase("2"))
				return new ModelAndView("com/buss/person/zformPerson-add_retire");
			if (status.equalsIgnoreCase("3"))
				return new ModelAndView("com/buss/person/zformPerson-add_retire");
			if (status.equalsIgnoreCase("4"))
				return new ModelAndView("com/buss/person/zformPerson-add_transfer_external");
			if (status.equalsIgnoreCase("5"))
				return new ModelAndView("com/buss/person/zformPerson-add_transfer_external");
			if (status.equalsIgnoreCase("6"))
				return new ModelAndView("com/buss/person/zformPerson-add_death");
			if (status.equalsIgnoreCase("7"))
				return new ModelAndView("com/buss/person/zformPerson-add_death");
		}
		return new ModelAndView("com/buss/person/zformPerson-add");
	}
	
	/**
	 * 人员基本信息数据库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			
			String id = zformPerson.getId();
			
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			
			if (zformPerson == null || zformPerson.getId() == null || zformPerson.getId()  == ""){				
				zformPerson = personService.getPersonByActivityID(systemService, id);								
			}
			
			req.setAttribute("zformPersonPage", zformPerson);
		}
		
		String status = req.getParameter("status");
		if (StringUtil.isNotEmpty(status))
		{
			if (status.equalsIgnoreCase("1"))
				return new ModelAndView("com/buss/person/zformPerson-update_active");
			if (status.equalsIgnoreCase("2"))
				return new ModelAndView("com/buss/person/zformPerson-update_retire");
			if (status.equalsIgnoreCase("3"))
				return new ModelAndView("com/buss/person/zformPerson-update_retire");
			if (status.equalsIgnoreCase("4"))
				return new ModelAndView("com/buss/person/zformPerson-update_transfer_external");
			if (status.equalsIgnoreCase("5"))
				return new ModelAndView("com/buss/person/zformPerson-update_transfer_external");
			if (status.equalsIgnoreCase("6"))
				return new ModelAndView("com/buss/person/zformPerson-update_death");
			if (status.equalsIgnoreCase("7"))
				return new ModelAndView("com/buss/person/zformPerson-update_death");
			if (status.equalsIgnoreCase("8"))
				return new ModelAndView("com/buss/person/zformPerson-update_transfer_internal");
			if (status.equalsIgnoreCase("9"))
				return new ModelAndView("com/buss/person/zformPerson-update_transfer_internal");
			if (status.equalsIgnoreCase("10"))
				return new ModelAndView("com/buss/person/zformPerson-update_job");
			if (status.equalsIgnoreCase("11"))
				return new ModelAndView("com/buss/person/zformPerson-update_exam");
			if (status.equalsIgnoreCase("12"))
				return new ModelAndView("com/buss/person/zformPerson-update_salary");	
			if (status.equalsIgnoreCase("13"))
				return new ModelAndView("com/buss/person/zformPerson-update_title");
		}
		
		return new ModelAndView("com/buss/person/zformPerson-update");
	}
	
	
	/**
	 * 加载明细列表[在职]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonActiveList")
	public ModelAndView zformPersonActiveList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE0 = zformPerson.getCode();
		//===================================================================================
		//查询-在职
	    String hql0 = "from ZformPersonActiveEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonActiveEntity> zformPersonActiveEntityList = systemService.findHql(hql0,cODE0);
			req.setAttribute("zformPersonActiveList", zformPersonActiveEntityList);
			req.setAttribute("User_SchoolCode", ClientManager.getInstance().getClient().getUser().getSchoolCode());
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/active/zformPersonActiveList");
	}
	/**
	 * 加载明细列表[退休]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonRetireList")
	public ModelAndView zformPersonRetireList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE1 = zformPerson.getCode();
		//===================================================================================
		//查询-退休
	    String hql1 = "from ZformPersonRetireEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonRetireEntity> zformPersonRetireEntityList = systemService.findHql(hql1,cODE1);
			req.setAttribute("zformPersonRetireList", zformPersonRetireEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/retire/zformPersonRetireList");
	}
	/**
	 * 加载明细列表[调出]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonTransferExternalList")
	public ModelAndView zformPersonTransferExternalList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE2 = zformPerson.getCode();
		//===================================================================================
		//查询-调出
	    String hql2 = "from ZformPersonTransferExternalEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonTransferExternalEntity> zformPersonTransferExternalEntityList = systemService.findHql(hql2,cODE2);
			req.setAttribute("zformPersonTransferExternalList", zformPersonTransferExternalEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/transferexternal/zformPersonTransferExternalList");
	}
	/**
	 * 加载明细列表[死亡]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonDeathList")
	public ModelAndView zformPersonDeathList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE3 = zformPerson.getCode();
		//===================================================================================
		//查询-死亡
	    String hql3 = "from ZformPersonDeathEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonDeathEntity> zformPersonDeathEntityList = systemService.findHql(hql3,cODE3);
			req.setAttribute("zformPersonDeathList", zformPersonDeathEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/death/zformPersonDeathList");
	}
	/**
	 * 加载明细列表[处分]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonPunishList")
	public ModelAndView zformPersonPunishList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE4 = zformPerson.getCode();
		//===================================================================================
		//查询-处分
	    String hql4 = "from ZformPersonPunishEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonPunishEntity> zformPersonPunishEntityList = systemService.findHql(hql4,cODE4);
			req.setAttribute("zformPersonPunishList", zformPersonPunishEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/punishment/zformPersonPunishList");
	}
	/**
	 * 加载明细列表[人员调动]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonTransferInnerList")
	public ModelAndView zformPersonTransferInnerList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE5 = zformPerson.getCode();
		//===================================================================================
		//查询-人员调动
	    String hql5 = "from ZformPersonTransferInnerEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonTransferInnerEntity> zformPersonTransferInnerEntityList = systemService.findHql(hql5,cODE5);
			req.setAttribute("zformPersonTransferInnerList", zformPersonTransferInnerEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/transferinternal/zformPersonTransferInnerList");
	}
	/**
	 * 加载明细列表[岗位聘用]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonJobList")
	public ModelAndView zformPersonJobList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE6 = zformPerson.getCode();
		//===================================================================================
		//查询-岗位聘用
	    String hql6 = "from ZformPersonJobEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonJobEntity> zformPersonJobEntityList = systemService.findHql(hql6,cODE6);
			req.setAttribute("zformPersonJobList", zformPersonJobEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/job/zformPersonJobList");
	}
	/**
	 * 加载明细列表[年度考核]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonExamList")
	public ModelAndView zformPersonExamList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE7 = zformPerson.getCode();
		//===================================================================================
		//查询-年度考核
	    String hql7 = "from ZformPersonExamEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonExamEntity> zformPersonExamEntityList = systemService.findHql(hql7,cODE7);
			req.setAttribute("zformPersonExamList", zformPersonExamEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/exam/zformPersonExamList");
	}
	/**
	 * 加载明细列表[薪资管理]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonSalaryList")
	public ModelAndView zformPersonSalaryList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE8 = zformPerson.getCode();
		//===================================================================================
		//查询-薪资管理
	    String hql8 = "from ZformPersonSalaryEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonSalaryEntity> zformPersonSalaryEntityList = systemService.findHql(hql8,cODE8);
			req.setAttribute("zformPersonSalaryList", zformPersonSalaryEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/salary/zformPersonSalaryList");
	}
	/**
	 * 加载明细列表[职务变动]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonTitleList")
	public ModelAndView zformPersonTitleList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE9 = zformPerson.getCode();
		//===================================================================================
		//查询-职务变动
	    String hql9 = "from ZformPersonTitleEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonTitleEntity> zformPersonTitleEntityList = systemService.findHql(hql9,cODE9);
			req.setAttribute("zformPersonTitleList", zformPersonTitleEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/title/zformPersonTitleList");
	}
	/**
	 * 加载明细列表[状态变动]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformPersonStatusList")
	public ModelAndView zformPersonStatusList(ZformPersonEntity zformPerson, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object cODE10 = zformPerson.getCode();
		//===================================================================================
		//查询-状态变动
	    String hql10 = "from ZformPersonStatusEntity where 1 = 1 AND code = ? ";
	    try{
	    	List<ZformPersonStatusEntity> zformPersonStatusEntityList = systemService.findHql(hql10,cODE10);
			req.setAttribute("zformPersonStatusList", zformPersonStatusEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/status/zformPersonStatusList");
	}
	
 	/**
	 * 自定义按钮-sql增强-转入退休审核
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doTo_RetireAudit")
	@ResponseBody
	public AjaxJson doTo_RetireAudit(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转入退休审核成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_RetireAuditSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转入退休审核失败";
		}
		j.setMsg(message);
		return j;
	}
		
	@RequestMapping(params = "doTo_TrasnferExternalAudit")
	@ResponseBody
	public AjaxJson doTo_TrasnferExternalAudit(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转入调出审核成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_TrasnferExternalAuditSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转入调出审核失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_DeathAudit")
	@ResponseBody
	public AjaxJson doTo_DeathAudit(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转入死亡审核成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_DeathAuditSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转入死亡审核失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_RetireAccept")
	@ResponseBody
	public AjaxJson doTo_RetireAccept(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "退休审核通过成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_RetireAcceptSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退休审核通过失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_RetireRevoke")
	@ResponseBody
	public AjaxJson doTo_RetireRevoke(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "退休审核退回成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_RetireRevokeSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退休审核退回失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_Active")
	@ResponseBody
	public AjaxJson doTo_Active(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转回在职库成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_ActiveSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转回在职库失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_TransferExternalAccept")
	@ResponseBody
	public AjaxJson doTo_TransferExternalAccept(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转入调出库成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_TransferExternalAcceptSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转入调出库失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_TransferExternalRevoke")
	@ResponseBody
	public AjaxJson doTo_TransferExternalRevoke(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转回在职库成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_TransferExternalRevokeSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转回在职库失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_DeathAccept")
	@ResponseBody
	public AjaxJson doTo_DeathAccept(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转入死亡库成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_DeathAcceptSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转入死亡库失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_DeathRevoke_ToActive")
	@ResponseBody
	public AjaxJson doTo_DeathRevoke_ToActive(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "退回在职库成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_DeathRevoke(t, "1");
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退回在职库失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_DeathRevoke_ToRetire")
	@ResponseBody
	public AjaxJson doTo_DeathRevoke_ToRetire(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "退回退休库成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{
			zformPersonService.doTo_DeathRevoke(t, "3");
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退回退休库失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTransferInternal")
	@ResponseBody
	public AjaxJson doTransferInternal(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "人员调动申请成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());		
		
		try{			
			ZformPersonActiveEntity personActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());
		    ZformPersonTransferInnerEntity transferInnerEntity = personService.getPersonTransferInner(t,personActiveEntity,request);			
			zformPersonService.doTo_TransferInternal(t, transferInnerEntity);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "人员调动申请失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_TransferInternalAccept")
	@ResponseBody
	public AjaxJson doTo_TransferInternalAccept(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "人员调动成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{			
		    ZformPersonActiveEntity zformPersonActive = personService.getPersonActiveByCode(systemService, t.getCode());
		    ZformPersonTransferInnerEntity zformPersonTransferInner = personService.getPersonTransferInner(systemService, t.getCode());		    
		    zformPersonService.doTo_TransferInternalAcceptSql(t,zformPersonActive,zformPersonTransferInner);			
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "人员调动失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doTo_TransferInternalRevoke")
	@ResponseBody
	public AjaxJson doTo_TransferInternalRevoke(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "人员调动撤销成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{			
		    ZformPersonActiveEntity zformPersonActive = personService.getPersonActiveByCode(systemService, t.getCode());
		    ZformPersonTransferInnerEntity zformPersonTransferInner = personService.getPersonTransferInner(systemService, t.getCode());		    
		    zformPersonService.doTo_TransferInternalRevokeSql(t,zformPersonActive,zformPersonTransferInner);			
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "人员调动撤销失败";
		}
		j.setMsg(message);
		return j;
	}
	
	//岗位聘用
	@RequestMapping(params = "doChangeJob")
	@ResponseBody
	public AjaxJson doChangeJob(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "岗位聘用成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{	
		    ZformPersonActiveEntity activeEntity = personService.getPersonActiveByCode(systemService, t.getCode()); 
		    ZformPersonJobEntity jobEntity = personService.getPersonNewJob(t, activeEntity, request, systemService);
		    //岗位聘用成功后，会增加一条调整用户岗位工资的记录。生效日为下月1月1日
		    ZformPersonSalaryEntity salaryEntity = personService.getPersonSalaryForJobChange(t, activeEntity, jobEntity, systemService);
		    zformPersonService.doTo_ChangeJob(t,activeEntity,jobEntity, salaryEntity);	
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "岗位聘用失败";
		}
		j.setMsg(message);
		return j;
	}
	
	//职务变动
	@RequestMapping(params = "doChangeTitle")
	@ResponseBody
	public AjaxJson doChangeTitle(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "职务变动成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{	
			//得到当前在职用户的信息
		    ZformPersonActiveEntity activeEntity = personService.getPersonActiveByCode(systemService, t.getCode()); 
		    //根据用户输入，得到用户新的title
		    ZformPersonTitleEntity titleEntity = personService.getPersonNewTitle(t, activeEntity, request, systemService);		    
		    //职务变动成功后，会增加一条调整用户岗位工资的记录。生效为下个月1月1日
		    ZformPersonSalaryEntity salaryEntity = personService.getPersonSalaryForTitleChange(t, activeEntity, titleEntity, systemService);
		    zformPersonService.doTo_ChangeTitle(t,activeEntity,titleEntity, salaryEntity);			
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "职务变动失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doInputExam")
	@ResponseBody
	public AjaxJson doInputExam(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "年度考核成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{				
		    ZformPersonActiveEntity activeEntity = personService.getPersonActiveByCode(systemService, t.getCode());
		    ZformPersonExamEntity examEntity = personService.getPersonExam(t, activeEntity, request);
		    
		    //对于考核为优秀或者合格者，次年1月1日工资自动增加一级岗位
		    ZformPersonSalaryEntity zformPersonSalaryEntity = personService.getPersonSalaryForExam(t, activeEntity, examEntity, request, systemService);
		    
		    zformPersonService.doTo_AddExamSql(t, activeEntity, examEntity, zformPersonSalaryEntity);			
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = e.toString() + "年度考核失败";
		}
		j.setMsg(message);
		return j;
	}
	
	//手工添加一条薪资录入信息
	@RequestMapping(params = "doAddSalary")
	@ResponseBody
	public AjaxJson doAddSalary(ZformPersonEntity zformPerson, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "薪资录入成功";
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		try{		    
		    ZformPersonActiveEntity personActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());
		    ZformPersonSalaryEntity salaryEntity = personService.getPersonNewSalary(t,personActiveEntity, request, systemService);
		    zformPersonService.doTo_AddSalarySql(t,personActiveEntity,salaryEntity);			
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "薪资录入失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params="doExportJobStatDetails")
	public String doExportJobStatDetails(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response){
		
		
		String schoolCode = "0001";//request.getParameter("schoolCode");
		String schoolYear = "2014";//request.getParameter("schoolYear");
		
		
		
		try{
			Map<String, Object> map = null;
			map = reportService.GetJobStatDetails(personService, systemService, schoolCode, schoolYear);
			
			ModelMap modelMap = new ModelMap();
			modelMap.put(TemplateExcelConstants.FILE_NAME, "岗位人员聘用备案名册");
			modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/jobStatDetails.xls",0,1,2));
			modelMap.put(TemplateExcelConstants.MAP_DATA, map);
			
			//JeecgTemplateExcelView excelView = new JeecgTemplateExcelView();
			//excelView.render(modelMap, request, response);
			
		}catch(Exception exp){
			
		}
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;  
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")	
	public String exportXls(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, 
			DataGrid dataGrid, ModelMap modelMap) {
		
		CriteriaQuery cq = new CriteriaQuery(ZformPersonEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zformPerson, request.getParameterMap());
		//cq.eq("currentStatus", "1");
		//cq.add();
        List<ZformPersonEntity> zformPersonEntityList = this.zformPersonService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "人员基本信息表");
        modelMap.put(NormalExcelConstants.CLASS, ZformPersonEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("人员基本信息列表","导出人：" + ResourceUtil.getSessionUserName().getRealName(),"导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, zformPersonEntityList);
                        
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }
	
	/**
	 * 生成电子简历
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportPersonalResume")
	public String ExportPersonalResume(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap) {
        
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        ZformSchoolEntity zformSchoolEntity = null;
        Map<String,Object> map = null;
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());        	
        	zformSchoolEntity = personService.getSchoolByCode(systemService, zformPersonActiveEntity.getSchoolCode());       	
        	map = reportService.GetPersonalResume(t, zformPersonActiveEntity, zformSchoolEntity);
        	
        }catch(Exception exp){
        	
        }
          
        
		modelMap.put(TemplateExcelConstants.FILE_NAME,"个人简历");
        modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("export/template/personalResume.xls",0));
        modelMap.put(TemplateExcelConstants.MAP_DATA,map);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;  
	}
	
	//个人考试台帐
	@RequestMapping(params = "exportPersonalResumeWithInnerTransfer")
	public String ExportPersonalResumeWithInnerTransfer(ZformPersonEntity zformPerson,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid, ModelMap modelMap) {

		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());

		ZformPersonActiveEntity zformPersonActiveEntity = null;
		ZformSchoolEntity zformSchoolEntity = null;
		List<ZformPersonTransferInnerEntity> zformInnerList = null;

		Map<String, Object> map = null;

		try {
			zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());
			zformSchoolEntity = personService.getSchoolByCode(systemService,zformPersonActiveEntity.getSchoolCode());
			zformInnerList = personService.getPersonTransferInnerListByCode(systemService, t.getCode());			
			map = reportService.GetPersonalResumeWithInnerTransfer(t,
					zformPersonActiveEntity, zformSchoolEntity,
					zformInnerList,systemService, personService);

		} catch (Exception exp) {

		}

		modelMap.put(TemplateExcelConstants.FILE_NAME, "个人历年内部调动情况台账");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams(
				"export/template/personalResume_innertransfer.xls", 0));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	//个人考试台帐
	@RequestMapping(params = "exportPersonalResumeWithExam")
	public String ExportPersonalResumeWithExam(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap) {
        
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        ZformSchoolEntity zformSchoolEntity = null;
        List<ZformPersonExamEntity> zformExamEntityList = null;
        
        Map<String,Object> map = null;
        
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());        	
        	zformSchoolEntity = personService.getSchoolByCode(systemService, zformPersonActiveEntity.getSchoolCode());
        	zformExamEntityList = personService.getPersonExamEntityListByCode(systemService, t.getCode());
        	map = reportService.GetPersonalResumeWithExam(t, zformPersonActiveEntity, zformSchoolEntity, zformExamEntityList);
        	
        }catch(Exception exp){
        	
        }
          
        
		modelMap.put(TemplateExcelConstants.FILE_NAME,"个人历年岗位聘用情况台账");
        modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("export/template/personalResume_exam.xls",0));
        modelMap.put(TemplateExcelConstants.MAP_DATA,map);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;  
	}
	
	//个人工作工作台帐
	@RequestMapping(params = "exportPersonalResumeWithJob")
	public String ExportPersonalResumeWithJob(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap) {
        
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        ZformSchoolEntity zformSchoolEntity = null;
        List<ZformPersonExamEntity> zformExamEntityList = null;
        List<ZformPersonJobEntity> zformJobEntityList = null;
        
        Map<String,Object> map = null;
        
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());        	
        	zformSchoolEntity = personService.getSchoolByCode(systemService, zformPersonActiveEntity.getSchoolCode());
        	zformExamEntityList = personService.getPersonExamEntityListByCode(systemService, t.getCode());
        	zformJobEntityList = personService.getPersonJobEntityListByCode(systemService, t.getCode());
        	
        	map = reportService.GetPersonalResumeWithJob(t, zformPersonActiveEntity, zformSchoolEntity, zformExamEntityList, zformJobEntityList);
        	
        }catch(Exception exp){
        	
        }
          
        
		modelMap.put(TemplateExcelConstants.FILE_NAME,"个人历年岗位聘用情况台账");
        modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("export/template/personalResume_job.xls",0));
        modelMap.put(TemplateExcelConstants.MAP_DATA,map);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;  
	}
	
	@RequestMapping(params = "exportPersonalResumeWithSalary")
	public String ExportPersonalResumeWithSalary(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap) {
        		
		ZformPersonEntity t = personService.getPersonEntityByCode(systemService, zformPerson.getCode());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        ZformSchoolEntity zformSchoolEntity = null;
        List<ZformPersonExamEntity> zformExamEntityList = null;
        List<ZformPersonJobEntity> zformJobEntityList = null;
        List<ZformPersonSalaryEntity> zformSalaryEntityList = null;
        
        Map<String,Object> map = null;
        
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());        	
        	zformSchoolEntity = personService.getSchoolByCode(systemService, zformPersonActiveEntity.getSchoolCode());
        	zformExamEntityList = personService.getPersonExamEntityListByCode(systemService, t.getCode());
        	zformJobEntityList = personService.getPersonJobEntityListByCode(systemService, t.getCode());
        	zformSalaryEntityList = personService.getPersonSalaryEntityListByCode(systemService, t.getCode());
        	
        	map = reportService.GetPersonalResumeWithSalary(t, zformPersonActiveEntity, zformSchoolEntity, zformExamEntityList, zformJobEntityList, zformSalaryEntityList);
        	
        }catch(Exception exp){
        	
        }
          
        
		modelMap.put(TemplateExcelConstants.FILE_NAME,"个人历年工资变动情况台账");
        modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("export/template/personalResume_salary.xls",0));
        modelMap.put(TemplateExcelConstants.MAP_DATA,map);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;  
	}
	
	@RequestMapping(params = "exportSalaryChangeAudit")
	public String ExportSalaryChangeAudit(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap) {
        		
		ZformPersonEntity t = personService.getPersonEntityByCode(systemService, zformPerson.getCode());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        List<ZformPersonJobEntity> zformJobEntityList = null;
        List<ZformPersonSalaryEntity> zformSalaryEntityList = null;
        
        Map<String,Object> map = null;
        
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());        	
        	zformJobEntityList = personService.getPersonJobEntityListByCode(systemService, t.getCode());
        	zformSalaryEntityList = personService.getPersonSalaryEntityListByCode(systemService, t.getCode());
        	
        	map = reportService.GetSalaryChangeAudit(t, zformPersonActiveEntity, zformSalaryEntityList);
        	
        }catch(Exception exp){
        	
        }
          
        modelMap.put(TemplateWordConstants.FILE_NAME,"北京市事业单位工作人员工资变动审批表");
		modelMap.put(TemplateWordConstants.MAP_DATA,map);
		modelMap.put(TemplateWordConstants.URL,"export/template/salaryChangeAudit.docx");
		return TemplateWordConstants.JEECG_TEMPLATE_WORD_VIEW;  
	}
	
	@RequestMapping(params = "exportJobChangeAndSalaryChangeAudit")
	public String ExportJobChangeAndSalaryChangeAudit(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap) {
        		
		ZformPersonEntity t = personService.getPersonEntityByCode(systemService, zformPerson.getCode());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        List<ZformPersonJobEntity> zformJobEntityList = null;
        List<ZformPersonSalaryEntity> zformSalaryEntityList = null;
        
        Map<String,Object> map = null;
        
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());        	
        	zformJobEntityList = personService.getPersonJobEntityListByCode(systemService, t.getCode());
        	zformSalaryEntityList = personService.getPersonSalaryEntityListByCode(systemService, t.getCode());
        	
        	map = reportService.GetJobChangeAndSalaryChangeAudit(t, zformPersonActiveEntity, zformSalaryEntityList);
        	
        }catch(Exception exp){
        	
        }
          
        modelMap.put(TemplateWordConstants.FILE_NAME,"工资审批表--因岗位聘用变动岗位工资变动");
		modelMap.put(TemplateWordConstants.MAP_DATA,map);
		modelMap.put(TemplateWordConstants.URL,"export/template/salaryChangeAudit_job.docx");
		return TemplateWordConstants.JEECG_TEMPLATE_WORD_VIEW;  
	}
	
	@RequestMapping(params = "exportTitleChangeAndSalaryChangeAudit")
	public String ExportTitleChangeAndSalaryChangeAudit(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap) {
        		
		ZformPersonEntity t = personService.getPersonEntityByCode(systemService, zformPerson.getCode());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        List<ZformPersonJobEntity> zformJobEntityList = null;
        List<ZformPersonSalaryEntity> zformSalaryEntityList = null;
        
        Map<String,Object> map = null;
        
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());        	
        	zformJobEntityList = personService.getPersonJobEntityListByCode(systemService, t.getCode());
        	zformSalaryEntityList = personService.getPersonSalaryEntityListByCode(systemService, t.getCode());
        	
        	map = reportService.GetTitleChangeAndSalaryChangeAudit(t, zformPersonActiveEntity, zformSalaryEntityList);
        	
        }catch(Exception exp){
        	
        }
          
        modelMap.put(TemplateWordConstants.FILE_NAME,"工资审批表--因职称评审变动岗位工资变动");
		modelMap.put(TemplateWordConstants.MAP_DATA,map);
		modelMap.put(TemplateWordConstants.URL,"export/template/salaryChangeAudit_title.docx");
		return TemplateWordConstants.JEECG_TEMPLATE_WORD_VIEW;  
	}
	
	//生成单位统计表
	@RequestMapping(params="exportStat")
	public String ExportStat(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
		
		int year = 2015;
		int month = 1;
		
		Map<String, Object> map = reportService.GetSchoolStat(systemService, year, month);
		modelMap.put(TemplateExcelConstants.FILE_NAME,"统计报表");
        modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("export/template/totalStatic.xls",0));
        modelMap.put(TemplateExcelConstants.MAP_DATA,map);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@RequestMapping(params="exportJobStatSum1")
	public String ExportJobStatSum1(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
		
		String schoolCode = "0001";//request.getParameter("schoolCode");
		String schoolYear = "2014";//request.getParameter("schoolYear");
		
		Map<String, Object> map = null;
		
		try{
			map = reportService.GetJobStatSum1(personService, systemService, schoolCode, schoolYear);
			
		}catch(Exception exp){
			
		}
		
		modelMap.put(TemplateExcelConstants.FILE_NAME, "汇总表");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/jobStatSum1.xls",0));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@RequestMapping(params="exportJobStatSum2")
	public String ExportJobStatSum2(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
		
		String schoolCode = "0001";//request.getParameter("schoolCode");
		String schoolYear = "2014";//request.getParameter("schoolYear");
		
		Map<String, Object> map = null;
		
		try{
			map = reportService.GetJobStatSum2(personService, systemService, schoolCode, schoolYear);
			
		}catch(Exception exp){
			
		}
		
		modelMap.put(TemplateExcelConstants.FILE_NAME, "聘用结果备案表");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/jobStatSum2.xls",0));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@RequestMapping(params="exportJobStatDetails")
	public String ExportJobStatDetails(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
		
		String schoolCode = "0001";//request.getParameter("schoolCode");
		String schoolYear = "2014";//request.getParameter("schoolYear");
		
		Map<String, Object> map = null;
		
		try{
			map = reportService.GetJobStatDetails(personService, systemService, schoolCode, schoolYear);
			
		}catch(Exception exp){
			
		}
		
		modelMap.put(TemplateExcelConstants.FILE_NAME, "岗位人员聘用备案名册");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/jobStatDetails.xls",0,1,2));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@RequestMapping(params="exportDeathExpenseList")
	public String ExportDeathExpenseList(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
		
		String schoolCode = "0001";//request.getParameter("schoolCode");
		String schoolYear = "2014";//request.getParameter("schoolYear");
		
		Map<String, Object> map = null;
		
		try{
			map = reportService.GetJobStatDetails(personService, systemService, schoolCode, schoolYear);
			
		}catch(Exception exp){
			
		}
		
		modelMap.put(TemplateExcelConstants.FILE_NAME, "死亡人员丧抚费花名册");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/deathExpenseList.xls",0));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@RequestMapping(params="exportDeathExpenseAudit")
	public String ExportDeathExpenseAudit(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
				
		Map<String, Object> map = null;
		
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		
		ZformPersonDeathEntity deathEntity = null;
		
		if (t != null)
			deathEntity = personService.GetPersonDeathEntityByCode(systemService,t.getCode());
		
		try{
			map = reportService.GetDeathExepenseAudit(personService, systemService, t, deathEntity);
			
		}catch(Exception exp){
			
		}
		
		modelMap.put(TemplateExcelConstants.FILE_NAME, "死亡人员丧抚费审批表");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/deathExpenseAudit.xls",0));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@RequestMapping(params="exportHardCoreExamSummary")
	public String ExportHardCoreExamSummary(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
				
		Map<String, Object> map = null;
		
		try{
			
			map = reportService.GetHardcoreExamSummary(personService, systemService);
			
		}catch(Exception exp){
			
		}
		
		modelMap.put(TemplateExcelConstants.FILE_NAME, "骨干教师考核情况");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/hardCoreExamSummary.xls",0,1,2));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@RequestMapping(params="exportExamSummary")
	public String ExportExamSummary(ZformPersonEntity zformPerson, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,
			ModelMap modelMap){
				
		Map<String, Object> map = null;
		
		try{
			
			map = reportService.GetExamSummary(personService, systemService);
			
		}catch(Exception exp){
			
		}
		
		modelMap.put(TemplateExcelConstants.FILE_NAME, "事业单位考核表格汇总");
		modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/template/examSummary.xls",0,1,2,3,4,5));
		modelMap.put(TemplateExcelConstants.MAP_DATA, map);
		
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	
	
	//开具商调函
	@RequestMapping(params = "generateInnerTransferBusinessDocument")
	public String GenerateInnerTransferBusinessDocument(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
                
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        ZformPersonTransferInnerEntity  zformTransferInnerEntity = null;
        ZformSchoolEntity zformSchoolEntity = null;
        Map<String,Object> map = null;
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());
        	zformTransferInnerEntity = personService.getPersonTransferInner(systemService, t.getCode());        	
        	zformSchoolEntity = personService.getSchoolByCode(systemService, zformTransferInnerEntity.getToSchool());
        	
        	map = reportService.getInnerTransferBusinessMap(t, zformPersonActiveEntity, zformTransferInnerEntity, zformSchoolEntity);
        	
        }catch(Exception exp){
        	
        }

        modelMap.put(TemplateWordConstants.FILE_NAME,"商调函");
		modelMap.put(TemplateWordConstants.MAP_DATA,map);
		modelMap.put(TemplateWordConstants.URL,"export/template/innerTransferBussiness.docx");
		return TemplateWordConstants.JEECG_TEMPLATE_WORD_VIEW;
	}
	
	//开具调干通知书
	@RequestMapping(params = "generateInnerTransferNotifyDocument")
	public String GenerateInnerTransferNotifyDocument(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
                
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        ZformPersonTransferInnerEntity  zformTransferInnerEntity = null;
        ZformSchoolEntity zformSchoolEntity = null;
        Map<String,Object> map = null;
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());
        	zformTransferInnerEntity = personService.getPersonTransferInner(systemService, t.getCode());        	
        	zformSchoolEntity = personService.getSchoolByCode(systemService, zformTransferInnerEntity.getToSchool());
        	
        	map = reportService.getInnerTransferBusinessMap(t, zformPersonActiveEntity, zformTransferInnerEntity, zformSchoolEntity);
        	
        }catch(Exception exp){
        	
        }

        modelMap.put(TemplateWordConstants.FILE_NAME,"调干通知书");
		modelMap.put(TemplateWordConstants.MAP_DATA,map);
		modelMap.put(TemplateWordConstants.URL,"export/template/innerTransferNotify.docx");
		return TemplateWordConstants.JEECG_TEMPLATE_WORD_VIEW;
	}

	//开具干部介绍信
	@RequestMapping(params = "generateInnerTransferReferenceDocument")
	public String GenerateInnerTransferReferenceDocument(ZformPersonEntity zformPerson,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
                
		ZformPersonEntity t = zformPersonService.get(ZformPersonEntity.class, zformPerson.getId());
		
        ZformPersonActiveEntity zformPersonActiveEntity = null;
        ZformPersonTransferInnerEntity  zformTransferInnerEntity = null;
        ZformSchoolEntity zformSchoolEntity = null;
        Map<String,Object> map = null;
        try{
        	zformPersonActiveEntity = personService.getPersonActiveByCode(systemService, t.getCode());
        	zformTransferInnerEntity = personService.getPersonTransferInner(systemService, t.getCode());        	
        	zformSchoolEntity = personService.getSchoolByCode(systemService, zformTransferInnerEntity.getToSchool());
        	
        	map = reportService.getInnerTransferBusinessMap(t, zformPersonActiveEntity, zformTransferInnerEntity, zformSchoolEntity);
        	
        }catch(Exception exp){
        	
        }

        modelMap.put(TemplateWordConstants.FILE_NAME,"干部介绍信");
		modelMap.put(TemplateWordConstants.MAP_DATA,map);
		modelMap.put(TemplateWordConstants.URL,"export/template/innerTransferRef.docx");
		return TemplateWordConstants.JEECG_TEMPLATE_WORD_VIEW;
	}
	
	
	
	@RequestMapping(params = "goTransferInternal")
	public ModelAndView goTransferInternal(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			req.setAttribute("zformPersonPage", zformPerson);
		}
				
		return new ModelAndView("com/buss/person/zformPerson-f-transfer_internal");
	}
	
	@RequestMapping(params = "goTo_Job")
	public ModelAndView goTo_Job(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			req.setAttribute("zformPersonPage", zformPerson);
		}
				
		return new ModelAndView("com/buss/person/zformPerson-f-change-job");
	}	
	
	@RequestMapping(params = "goExam")
	public ModelAndView goExam(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			req.setAttribute("zformPersonPage", zformPerson);
		}
				
		return new ModelAndView("com/buss/person/zformPerson-f-exam");
	}	
	
	@RequestMapping(params = "goAddSalary")
	public ModelAndView goAddSalary(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			
			String id = zformPerson.getId();
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			
			
			if (zformPerson == null || zformPerson.getId() == null || zformPerson.getId() == ""){
				zformPerson = personService.getPersonByActivityID(systemService, id);				
			}
			
			req.setAttribute("zformPersonPage", zformPerson);
		}

		return new ModelAndView("com/buss/person/zformPerson-f-salary");
	}	
	
	@RequestMapping(params = "goChangeTitle")
	public ModelAndView goChangeTitle(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			req.setAttribute("zformPersonPage", zformPerson);
		}

		return new ModelAndView("com/buss/person/zformPerson-f-change-title");
	}	

	
	@RequestMapping(params = "goActivePersonStatReport")
	public ModelAndView goActivePersonStatReport(ZformPersonEntity zformPerson, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformPerson.getId())) {
			zformPerson = zformPersonService.getEntity(ZformPersonEntity.class, zformPerson.getId());
			req.setAttribute("zformPersonPage", zformPerson);
		}

		return new ModelAndView("com/buss/person/zformPerson-f-active-person-stat");
	}	
	
	@RequestMapping(params = "goSelectSchoolForJob")
	public ModelAndView goSelectSchoolForJob(ZformPersonEntity zformPerson, HttpServletRequest req){
		return new ModelAndView("com/buss/person/zformPerson-f-schoolList_for_job");
	}
}
