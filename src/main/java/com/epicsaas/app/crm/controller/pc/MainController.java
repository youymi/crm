/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// import com.epicsaas.api.session.SessionAPI;
import com.epicsaas.app.crm.appobject.AttentionAO;
import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.appobject.ContractAO;
import com.epicsaas.app.crm.appobject.TodoContactorAO;
import com.epicsaas.app.crm.common.CrmConst;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.AttentionCriteria;
import com.epicsaas.app.crm.entity.gen.CompanyCriteria;
import com.epicsaas.app.crm.entity.gen.ContractCriteria;
import com.epicsaas.app.crm.entity.gen.TodoContactorCriteria;
import com.epicsaas.app.crm.service.IAttentionService;
import com.epicsaas.app.crm.service.ICompanyService;
import com.epicsaas.app.crm.service.IContractService;
import com.epicsaas.app.crm.service.ITodoContactorService;
import com.epicsaas.framework.mybatis.Page;
import com.epicsaas.framework.util.BeanConvertUtils;
import com.epicsaas.framework.util.DateTimeUtils;
import com.epicsaas.service.biz.userbase.dto.UserDTO;
import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Main控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/main")
public class MainController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private IAttentionService attentionService;

    @Resource
    private ITodoContactorService todoContactorService;

    @Resource
    private ICompanyService companyService;

    @Resource
    private IContractService contractService;

    /**
     * 应用主入口地址
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String main(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", CrmConst.__APP_ID);
        model.addAttribute("appName", CrmConst.__APP_NAME);

        //UserDTO  user =SessionAPI.getInstance().getSessionUtil().getUserFromRequest(request);
        UserDTO user = new UserDTO();
        user.setId("1");

        Page page = new Page();
        page.setBegin(0);
        page.setLength(5);

        //我关注的客户
        AttentionCriteria example = new AttentionCriteria();
        example.createCriteria().andUserIdEqualTo(user.getId());
        example.setOrderByClause("contact_date desc");
        example.setPage(page);

        ServiceResult<List<AttentionAO>> attentionListRet = attentionService.selectByCriteria(example);
        if (attentionListRet.isSucceed() && !CollectionUtils.isEmpty(attentionListRet.getData())) {
            for (AttentionAO attentionAO : attentionListRet.getData()) {
                attentionAO.setCompanyAO(companyService.getById(attentionAO.getCompanyId()).getData());
            }
            model.addAttribute("attentionList", attentionListRet.getData());
        }
        //待联系客户
        TodoContactorCriteria todoContactorCriteria = new TodoContactorCriteria();
        todoContactorCriteria.createCriteria().andUserIdEqualTo(user.getId());
        todoContactorCriteria.setOrderByClause("contact_date desc");
        todoContactorCriteria.setPage(page);

        ServiceResult<List<TodoContactorAO>> todoContactorListRet = todoContactorService
                .selectByCriteria(todoContactorCriteria);
        if (attentionListRet.isSucceed() && !CollectionUtils.isEmpty(todoContactorListRet.getData())) {
            for (TodoContactorAO todoContactorAO : todoContactorListRet.getData()) {
                todoContactorAO.setCompanyAO(companyService.getById(todoContactorAO.getCompanyId()).getData());
            }
            model.addAttribute("todoContactorList", todoContactorListRet.getData());
        }

        //当前客户占比 ---客户增长趋势
        //全部客户数量
        int count = 0;
        //有多少客户类型
        Set<String> type = new HashSet<String>();
        Map<String, Double> mapData = new HashMap<String, Double>();
        Map<String, List<Map<String, Integer>>> mapData2 = new HashMap<String, List<Map<String, Integer>>>();
        String end = DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD);
        List<String> months = getMonthList(7, end);

        CompanyCriteria companyCriteria = new CompanyCriteria();
        companyCriteria.createCriteria().andIdIsNotNull();
        companyCriteria.setOrderByClause("create_date desc"); //创建时间到序
        ServiceResult<List<CompanyAO>> companyListRet = companyService.selectByCriteria(companyCriteria);
        if (companyListRet.isSucceed() && !CollectionUtils.isEmpty(companyListRet.getData())) {
            count = companyListRet.getData().size();
            for (CompanyAO company : companyListRet.getData()) {
                type.add(company.getType());
            }

            for (String s : type) {
                List<CompanyAO> tmpList = new ArrayList<CompanyAO>();
                for (CompanyAO company : companyListRet.getData()) {
                    if (s.equals(company.getType())) {
                        tmpList.add(company);
                    }
                }
                mapData.put(s, tmpList.size() * 100.0 / count);

                //月份段
                List<Map<String, Integer>> listTmp = new ArrayList<Map<String, Integer>>();
                for (String m : months) {
                    Map<String, Integer> tmpMap = new HashMap<String, Integer>();
                    int tmpCount = 0;
                    Date startDate = DateTimeUtils.parseStrToDate(m.concat("-01"), DateTimeUtils.FORMAT_YMD);
                    Date endDate = DateTimeUtils.parseStrToDate(m.concat("-31"), DateTimeUtils.FORMAT_YMD);
                    for (CompanyAO company : tmpList) {
                        //	 						int t = DateTimeUtils.compareDate(company.getCreateDate(), startDate);
                        //	 						 t = DateTimeUtils.compareDate(company.getCreateDate(), endDate);
                        //	 						System.out.println(t);
                        if (DateTimeUtils.compareDate(company.getCreateDate(), startDate) >= 0
                                && DateTimeUtils.compareDate(company.getCreateDate(), endDate) <= 0) {
                            tmpCount += 1;
                        }
                    }
                    tmpMap.put(m, tmpCount);
                    listTmp.add(tmpMap);
                }
                mapData2.put(s, listTmp);
            }
        }

        model.addAttribute("countData", count);
        model.addAttribute("months", months);
        model.addAttribute("mapData", mapData);
        model.addAttribute("mapData2", mapData2);

        //销售精英榜
        ContractCriteria contractCriteria = new ContractCriteria();
        //contractCriteria.createCriteria().andSignDateGreaterThanOrEqualTo(new Date(2014, 1, 1));
        contractCriteria.setPage(page);
        contractCriteria.setOrderByClause("money desc");
        ServiceResult<List<ContractAO>> contractListRet = contractService.selectByCriteria(contractCriteria);
        if (contractListRet.isSucceed() && !CollectionUtils.isEmpty(contractListRet.getData())) {
            model.addAttribute("contractList", contractListRet.getData());
        }

        return MVCViewName.APP_CRM_PC_IE9_MAIN_INDEX.toString();
    }

    public List<String> getMonthList(int count, String endTime) {
        //		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        //		SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        List<String> monthList = new ArrayList<String>();

        Date end = DateTimeUtils.parseStrToDate(endTime, DateTimeUtils.FORMAT_YMD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.MONTH, 0 - count);

        Date begin = calendar.getTime();

        int months = (end.getYear() - begin.getYear()) * 12 + (end.getMonth() - begin.getMonth());

        for (int i = 0; i <= months; i++) {
            calendar = Calendar.getInstance();
            calendar.setTime(begin);
            calendar.add(Calendar.MONTH, i);
            String tmp = DateTimeUtils.formateDateToStr(calendar.getTime(), DateTimeUtils.FORMAT_YMD);
            tmp = tmp.substring(0, tmp.lastIndexOf("-"));
            monthList.add(tmp);
        }

        return monthList;
    }

    /**
     * 应用快速创建某种业务数据如今，例如：快速创建一个请假申请
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
    public String create(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    /**
     * 打开某种业务数据，例如：打开数据ID等于dataId的请假申请
     * @param dataId 业务数据ID
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/open/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public String create(@PathVariable String dataId, Model model, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    @RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object search(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ServiceResult<List<Object>> ret = new ServiceResult<List<Object>>();
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        String word = request.getParameter("word");

        //        List<Object> data = new ArrayList<Object>();
        //        Map<String, Object> map1 = new HashMap<String, Object>(); 
        //        map1.put("name", word + "a1"); 
        //        map1.put("id", 0); 
        //        Map<String, Object> map2 = new HashMap<String, Object>(); 
        //        map2.put("name", word + "a2"); 
        //        map2.put("id", 0); 
        //        Map<String, Object> map3 = new HashMap<String, Object>(); 
        //        map3.put("name", word + "a3"); 
        //        map3.put("id", 0); 
        //
        //        data.add(map1);
        //        data.add(map2);
        //        data.add(map3);
        Page page = new Page();
        page.setBegin(0);
        page.setLength(10);

        CompanyCriteria companyCriteria = new CompanyCriteria();
        companyCriteria.createCriteria().andNameLike("%".concat(word).concat("%"));
        companyCriteria.setPage(page);
        List<Object> data = new ArrayList<Object>();

        ServiceResult<List<CompanyAO>> companyListRet = companyService.selectByCriteria(companyCriteria);
        if (companyListRet.isSucceed() && !CollectionUtils.isEmpty(companyListRet.getData())) {
            for (CompanyAO companyAO : companyListRet.getData()) {
                try {
                    Map map = BeanConvertUtils.convertBean(companyAO);
                    data.add(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        ret.setData(data);
        ret.setMsg("搜索成功");
        return ret;
    }

}
