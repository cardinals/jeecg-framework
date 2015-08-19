package com.buss.salary.controller;
import com.buss.salary.entity.ZformJobSalaryEntity;
import com.buss.salary.service.ZformJobSalaryServiceI;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.annotation.Scope;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import org.jeecgframework.core.util.ExceptionUtil;



/**   
 * @Title: Controller
 * @Description: 岗位工资数据库
 * @author onlineGenerator
 * @date 2015-07-19 10:56:34
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/zformJobSalaryController")
public class ZformJobSalaryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZformJobSalaryController.class);

	@Autowired
	private ZformJobSalaryServiceI zformJobSalaryService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 岗位工资数据库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zformJobSalary")
	public ModelAndView zformJobSalary(HttpServletRequest request) {
		return new ModelAndView("com/buss/salary/zformJobSalaryList");
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
	public void datagrid(ZformJobSalaryEntity zformJobSalary,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZformJobSalaryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zformJobSalary, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zformJobSalaryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除岗位工资数据库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZformJobSalaryEntity zformJobSalary, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zformJobSalary = systemService.getEntity(ZformJobSalaryEntity.class, zformJobSalary.getId());
		message = "岗位工资数据库删除成功";
		try{
			zformJobSalaryService.delete(zformJobSalary);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "岗位工资数据库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除岗位工资数据库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "岗位工资数据库删除成功";
		try{
			for(String id:ids.split(",")){
				ZformJobSalaryEntity zformJobSalary = systemService.getEntity(ZformJobSalaryEntity.class, 
				id
				);
				zformJobSalaryService.delete(zformJobSalary);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "岗位工资数据库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加岗位工资数据库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZformJobSalaryEntity zformJobSalary, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "岗位工资数据库添加成功";
		try{
			zformJobSalaryService.save(zformJobSalary);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "岗位工资数据库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新岗位工资数据库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZformJobSalaryEntity zformJobSalary, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "岗位工资数据库更新成功";
		ZformJobSalaryEntity t = zformJobSalaryService.get(ZformJobSalaryEntity.class, zformJobSalary.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(zformJobSalary, t);
			zformJobSalaryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "岗位工资数据库更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 岗位工资数据库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZformJobSalaryEntity zformJobSalary, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformJobSalary.getId())) {
			zformJobSalary = zformJobSalaryService.getEntity(ZformJobSalaryEntity.class, zformJobSalary.getId());
			req.setAttribute("zformJobSalaryPage", zformJobSalary);
		}
		return new ModelAndView("com/buss/salary/zformJobSalary-add");
	}
	/**
	 * 岗位工资数据库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZformJobSalaryEntity zformJobSalary, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zformJobSalary.getId())) {
			zformJobSalary = zformJobSalaryService.getEntity(ZformJobSalaryEntity.class, zformJobSalary.getId());
			req.setAttribute("zformJobSalaryPage", zformJobSalary);
		}
		return new ModelAndView("com/buss/salary/zformJobSalary-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zformJobSalaryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZformJobSalaryEntity zformJobSalary,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZformJobSalaryEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zformJobSalary, request.getParameterMap());
		List<ZformJobSalaryEntity> zformJobSalarys = this.zformJobSalaryService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"岗位工资数据库");
		modelMap.put(NormalExcelConstants.CLASS,ZformJobSalaryEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("岗位工资数据库列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zformJobSalarys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZformJobSalaryEntity zformJobSalary,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "岗位工资数据库");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,ZformJobSalaryEntity.class);
		modelMap.put(TemplateExcelConstants.LIST_DATA,null);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<ZformJobSalaryEntity> listZformJobSalaryEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZformJobSalaryEntity.class,params);
				for (ZformJobSalaryEntity zformJobSalary : listZformJobSalaryEntitys) {
					zformJobSalaryService.save(zformJobSalary);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
}
