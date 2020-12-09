package com.zjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.Map;

/**
 * @Author : ZJC
 * @Date : 2020/11/7 10:15
 * className : ScopeController
 * package: com.zjc.controller
 * version : 1.0
 * Description
 */

/**
 * @SessionAttributes注解是将隐含模型中的数据，同步 到Request域中<br />
 * names属性指定哪些key的数据也同步到Session中<br/>
 * types属性指定哪些类型的Value数据，也同步到Session中<br/>
 */
@SessionAttributes(types = {Long.class})
@Controller
public class ScopeController {
    @RequestMapping(value = "/sessionAttributes")
    public String sessionAttributes(Map<String, Object> map) {
        System.out.println("sessionAttributes");
        map.put("mapKey1", "mapValue1");
        map.put("mapKey2", new Long(99));
        return "scope";
    }

    @ModelAttribute
    public void zjc(Map<String,Object> map) {
        System.out.println("@ModelAttribute注解标识的 abc() 方法");
        map.put("zjc", new Book("如何获取富婆的欢心", "翟哥",new BigDecimal(999)));
    }

    /**
     * 1.先获取参数的类名Book
     * 类名首字母小写book作为key到隐含模型中取值
     */
    @RequestMapping(value = "/target")
    public String target(@ModelAttribute("zjc") Book book) {
        System.out.println("target——>" + book);
        return "scope";
    }

    @RequestMapping(value = "/requestScope")
    public String requestScope(HttpServletRequest request) {
        request.setAttribute("reqKey1", "reqValue1");
        request.setAttribute("reqKey2", "reqValue2");
        return "scope";
    }

    @RequestMapping(value = "/sessionScope")
    public String sessionScope(HttpSession session) {
        System.out.println("sessionScope(HttpSession session)");
        session.setAttribute("sessionKey1", "sessionValue1");
        session.setAttribute("sessionKey2", "sessionValue2");
        return "scope";
    }

    //@Autowired
    //ServletContext servletContext;

    @RequestMapping(value = "/servletContextScope")
    public String servletContextScope(HttpSession session) {
        System.out.println("servletContextScope");
        session.getServletContext().setAttribute("servletContextScopeKey1", "servletContextScopeValue1");
        session.getServletContext().setAttribute("servletContextScopeKey2", "servletContextScopeValue2");
        return "scope";
    }

    @RequestMapping(value = "/mapToRequset")
    public String mapToRequset(Map<String, Object> map) {
        System.out.println("mapToRequset");
        // 保存到Map中的数据，会自动同步地保存到Request域中
        map.put("key1", "value1");
        map.put("key2", "value2");
        return "scope";
    }

    @RequestMapping(value = "/modelToRequest")
    public String modelToRequest(Model model) {
        System.out.println(" modelToRequest ");

        // 保存到 Model 中的数据，会自动同步地保存到Request域中
        model.addAttribute("modelkey1", "modelvalue1");
        model.addAttribute("modelkey2", "modelvalue2");

        return "scope";
    }

    @RequestMapping(value = "/modelMapToRequest")
    public String modelMapToRequest(ModelMap modelMap) {
        System.out.println(" modelMapToRequest ");

        // 保存到 ModelMap 中的数据，会自动同步地保存到Request域中
        modelMap.addAttribute("modelMapkey1", "modelMapvalue1");
        modelMap.addAttribute("modelMapkey2", "modelMapvalue2");

        return "scope";
    }

    /**
     * BindingAwareModelMap类我们管它叫 隐含模型，它的作用是用来保存视图渲染需要的数据。<br/>
     * <p>
     * 视图                   客户端（浏览器最终看到的页面）就是html，或jsp等其他的页面<br/>
     * 渲染                   执行视图的代码 <br/>
     * 渲染需要的数据          页面需要输出的数据(保存到域中的那些需要给页面输出的数据)<br/>
     * <p>
     * org.springframework.validation.support.BindingAwareModelMap类 <br/>
     * /\
     * ||
     * BindingAwareModelMap extends ExtendedModelMap
     * /\
     * ||
     * class ExtendedModelMap extends ModelMap implements Model
     * /\
     * ||
     * class ModelMap extends LinkedHashMap<String, Object>
     */
    @RequestMapping(value = "/mapAndModelAndModelMap")
    public String mapAndModelAndModelMap(Map<String, Object> map, Model model, ModelMap modelMap) {
        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        System.out.println("==================================");

        map.put("key1", "value1");

        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        System.out.println("==================================");

        model.addAttribute("model1", "modelValue1");

        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        System.out.println("==================================");

        modelMap.addAttribute("modelMap1", "modelMapValue1");
        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        System.out.println("==================================");

        System.out.println(map.getClass());
        System.out.println(model.getClass());
        System.out.println(modelMap.getClass());

        return "scope";
    }

}
