/**
 * @Title: BaseController.java
 * @Package com.cqut.controller.basecontroller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author matao@cqrainbowsoft.com
 * @date 2014-8-15 下午8:59:10
 * @version V1.0
 */
package com.cqut.controller.basecontroller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.cqut.tool.util.DateConvertEditor;

import sun.beans.editors.FloatEditor;
import sun.beans.editors.LongEditor;

/**
 * 项目名称：CisdiRswpManage
 * 类名称：BaseController
 * 类描述：   
 * 创建人：xhay
 * 创建时间：2014-8-15 下午8:59:10
 * 修改人：xhay
 * 修改时间：2014-8-15 下午8:59:10
 * 修改备注：   
 * @version 1.0
 * 软件工程创新实验室  
 */
public abstract class BaseController {
	@InitBinder    
	protected void initBinder(WebDataBinder binder) {    
      
  		binder.registerCustomEditor(Date.class, new DateConvertEditor());    

     //binder.registerCustomEditor(int.class, new CustomNumberEditor(int.class, true));    
		binder.registerCustomEditor(int.class, new IntegerEditor());    
		//binder.registerCustomEditor(long.class, new CustomNumberEditor(long.class, true));  
		binder.registerCustomEditor(long.class, new LongEditor());    
		binder.registerCustomEditor(double.class, new DoubleEditor());    
		binder.registerCustomEditor(float.class, new FloatEditor());    
	}   
}