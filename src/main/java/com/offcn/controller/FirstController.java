package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @author K
 * @date 2020/10/27 19:29
 * @description
 */
@Controller     //注意:使用thymeleaf时的注解只能用@Controller
public class FirstController {

    /**
     * 访问http://localhost:8080/first
     * 将数据message填充到templates/index.html
     * @param model
     * @return
     */
    @RequestMapping("/first")
    public String indexPage(Model model) {
        String message = "Hello, Thymeleaf!";
        model.addAttribute("message", message);

        User user = new User();
        user.setId(1);
        user.setName("李斯");
        user.setAge(18);
        model.addAttribute("user",user);

        Map map = new HashMap();
        map.put("id",2);
        map.put("name","嬴政");
        map.put("age",22);
        model.addAttribute("map",map);

        return "index";
    }


    @RequestMapping("/three")
    public String index2(Model model) {
        List<User> list=new ArrayList<User>();
        User u1 = new User();
        u1.setId(1);
        u1.setName("优就业");
        u1.setAge(18);
        list.add(u1);

        User u2 = new User();
        u2.setId(2);
        u2.setName("中公教育");
        u2.setAge(28);
        list.add(u2);

        User u3 = new User();
        u3.setId(3);
        u3.setName("IT先锋");
        u3.setAge(88);
        list.add(u3);

        User u4 = new User();
        u4.setId(4);
        u4.setName("JAVA第一");
        u4.setAge(888);
        list.add(u4);

        model.addAttribute("userList", list);
        return "index2";
    }

    @GetMapping("/four")
    public String index3(Model model) {
        model.addAttribute("userName", "优就业");
        model.addAttribute("href", "http://www.ujiuye.com");
        return "index3";
    }

    @GetMapping("/five")
    public String index4(Model model) {
        model.addAttribute("flag", "yes");
        model.addAttribute("menu", "admin");
        model.addAttribute("manager", "admin");
        return "index4";
    }

    @RequestMapping("/six")
    public String index5(Model model){
        //定义日期
        Date date = new Date();
        model.addAttribute("date",date);
        //定义数字
        double number = 1234.567d;
        model.addAttribute("num",number);
        //定义大文本
        String str="Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。\\r\\n\" + \n" +
                "\t  \t\t\"Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。\\r\\n\" + \n" +
                "\t  \t\t\"Thymeleaf也从一开始就设计了Web标准 - 特别是HTML5 - 允许您创建完全验证的模板，如果这是您需要的\\r\\n\n";
        model.addAttribute("str",str);
        return "index5";
    }


}
