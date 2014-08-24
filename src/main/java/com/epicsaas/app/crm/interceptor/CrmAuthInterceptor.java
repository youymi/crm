package com.epicsaas.app.crm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.epicpaas.sdk.core.api.ServiceResult;
//import com.epicsaas.api.session.SessionAPI;
import com.epicsaas.api.userbase.UserBaseAPI;
import com.epicsaas.app.crm.common.CrmConst;
import com.epicsaas.service.biz.userbase.dto.GroupDTO;
import com.epicsaas.service.biz.userbase.dto.UserDTO;


/**
 * crm 权限拦截器
 * @author ghg
 *
 */
public class CrmAuthInterceptor extends HandlerInterceptorAdapter {

    /** 
  * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在 
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 
  * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */ 
	public boolean preHandle(HttpServletRequest request,	HttpServletResponse response, Object handler) throws Exception {
		//判断当前用户的权限
//		UserDTO  user =	SessionAPI.getInstance().getSessionUtil().getUserFromRequest(request);
//		ServiceResult<List<GroupDTO>>  groupListRet = UserBaseAPI.getInstance().getUserQueryService().getGroupListTenant(user.getId(), CrmConst.__APP_ID);
//		if(groupListRet.isSucceed() && !CollectionUtils.isEmpty(groupListRet.getData())){
//			request.setAttribute(CrmConst.__CRM_GROUP, groupListRet.getData());
//		}
		return true;
	}
	
	
    /** 
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操 
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用。
     */  
    @Override  
    public void postHandle(HttpServletRequest request,  HttpServletResponse response, Object handler,    ModelAndView modelAndView) throws Exception {  
        // TODO Auto-generated method stub  
          
    }  
    
    /** 
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。 
     */  
    @Override  
    public void afterCompletion(HttpServletRequest request,  HttpServletResponse response, Object handler, Exception ex)   throws Exception {  
        // TODO Auto-generated method stub  
          
    } 
	
}
