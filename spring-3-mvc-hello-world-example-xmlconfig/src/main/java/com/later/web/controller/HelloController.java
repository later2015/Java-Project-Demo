package com.later.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by liqiliang <liqiliang@baibu.la> on 2016/9/28.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        model.addAttribute("name", "Spring 3 MVC Hello World");
        return "hello";//跳转到hello.jsp

    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
//path里配了参数的话，不用专门set，会自动传到定义的model hello.jsp里面去。
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");//跳转到hello.jsp
        model.addObject("msg",name);//跟上面的addAttribute一样效果

        return model;

    }

}